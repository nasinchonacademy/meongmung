package org.zerock.projectmeongmung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.projectmeongmung.entity.MungStory;
import org.zerock.projectmeongmung.entity.User;
import org.zerock.projectmeongmung.service.MyPageService;
import org.zerock.projectmeongmung.service.UserDetailService;
import org.zerock.projectmeongmung.service.UserService;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class MyPageController {

    @Autowired
    private MyPageService myPageService;
    @Autowired
    private UserDetailService userDetailService;
    @Autowired
    private UserService userService;


    @GetMapping("/mypage")
    public String getMyPage(Authentication authentication, Model model) {
        String username = authentication.getName();
        User user = userDetailService.loadUserByUsername(username);

        // 좋아요한 스토리 가져오기
        List<MungStory> likedStories = myPageService.getLikedStories(user);
        model.addAttribute("likedStories", likedStories);

        // 젤리 포인트 가져오기
        int jelly = user.getJellypoint();
        model.addAttribute("jelly", jelly);

        List<MungStory> writtenStories = myPageService.getWrittenStories(user);
        model.addAttribute("writtenStories", writtenStories);

        return "mypage/mypage";
    }

    // 사용자 정보 수정 페이지를 표시하는 메서드
    @GetMapping("/mypageedit")
    public String showEditPage(Model model,Authentication authentication) {
        String username = authentication.getName();
        User user = userDetailService.loadUserByUsername(username);
        model.addAttribute("user", user);
        return "mypage/mypage_edit";
    }


    // 사용자 정보를 업데이트하는 메서드
    @PostMapping("/mypageedit")
    public String updateUserInfo(Authentication authentication,
                                 @RequestParam("nickname") String nickname,
                                 @RequestParam("dogname") String dogname,
                                 @RequestParam("profilePhoto") MultipartFile profilePhoto,
                                 @RequestParam(value = "dogbirthday", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dogbirthday,
                                  @RequestParam("dogbreed") String dogbreed)

    {

        // 기존 사용자 정보를 불러오기
        String username = authentication.getName();
        User  existingUser = userDetailService.loadUserByUsername(username);

        // 프로필 사진을 파일로 저장할 경우에만 처리
        String profilePhotoPath = existingUser.getProfilePhoto();
        if (!profilePhoto.isEmpty()) {
            try {
                // 파일 저장 로직을 구현하여 경로를 얻어오는 부분
                profilePhotoPath = saveProfilePhoto(profilePhoto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 업데이트할 새로운 사용자 정보 설정
        userDetailService.updateUser( username, nickname, dogname, profilePhotoPath,dogbreed,dogbirthday);


        // 리다이렉트: 수정 후 다시 마이페이지로 이동
        return "redirect:/mypage?uid=" + username;
    }

    private String saveProfilePhoto(MultipartFile file) throws IOException {
        // 저장할 경로 설정
        String uploadDir = "C:\\work\\uploads\\";

        // 파일명을 고유하게 하기 위해 UUID를 사용하거나 다른 로직을 사용할 수 있습니다.
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        // 전체 경로 생성
        String filePath = uploadDir + fileName;

        // 파일을 저장할 경로로 전송
        file.transferTo(new java.io.File(filePath));

        // 저장된 파일의 경로 반환 (웹에서 접근 가능한 경로로 변환)
        return  fileName;
    }

    // 사용자 정보 수정 페이지를 표시하는 메서드
    @GetMapping("/mypagejellylist")
    public String showjellylistPage(Model model,Authentication authentication) {
        return "mypage/mypagejellylist";
    }

}
