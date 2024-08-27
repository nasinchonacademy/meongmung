package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Table(name="member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "uid", updatable = false, unique = true ,nullable = false)
    private String uid;

    @Column(name = "nickname" ,unique = true,nullable = false)
    private String nickname;

    @Column(name = "email",nullable = false)
    private String email;

    @Column(name = "password" ,nullable = false)
    private String password;

    @Column(name = "name" ,nullable = false)
    private String name;

    @Column(name = "dogname")
    private String dogname;

    @Column(name="dogbreed")
    private String dogbreed;

    @Column(name="Profile_photo")
    private String profilePhoto;

    @Column(name="dogbirthday")
    private Date dogbirthday;

    @Column(name = "dogmeeting")
    private String dogmeeting;

    @Column(name = "marketsns")
    private boolean marketsns;

    @Column(name = "locservice")
    private boolean locservice;

    @Column(name = "term_use")
    private boolean term_use;

    @Column(name = "personalinfo")
    private boolean personalinfo;

    @Column(name = "jellypoint", nullable = false)
    @ColumnDefault("0")
    private int jellypoint;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date", nullable = false, updatable = false)
    @CreatedDate
    private Date regDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "withdrawal_date")
    private Date withdrawal_date;

    @OneToMany(mappedBy = "user")
    private Set<StoryLike> likes;





    @Builder
    public User(String uid, String nickname, String email, String password, String name, String dogname, String dogbreed, String profilePhoto, Date dogbirthday,
                String dogmeeting , boolean marketsns, boolean locservice, boolean term_use,boolean personalinfo, int jellypoint) {
        this.uid = uid;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.name = name;
        this.dogname = dogname;
        this.dogbreed = dogbreed;
        this.profilePhoto = profilePhoto;
        this.dogbirthday = dogbirthday;
        this.dogmeeting = dogmeeting;
        this.marketsns = marketsns;
        this.locservice = locservice;
        this.term_use = term_use;
        this.jellypoint = jellypoint;
        this.personalinfo = personalinfo;
        this.regDate = new Date();
    }


    //권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    //사용자의 id를 반환(고유한값)
    @Override
    public String getUsername() {
        return uid;
    }

    //사용자의 패스워드를 반환
    @Override
    public String getPassword() {
        return password;
    }

    //계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        //계정이 만료되었는지 확인하는 로직
        return UserDetails.super.isAccountNonExpired();
    }

    //계정의 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        //계정이 잠금되었는지 확인하는 로직
        return UserDetails.super.isAccountNonLocked();
    }

    //패스워드의 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        //패스워드가 만료되었는지 확인 하는 로직
        return UserDetails.super.isCredentialsNonExpired();
    }

    // 계정 사용 가능 여부 반환
    @Override
    public boolean isEnabled() {
        // 계정이 사용가능한지 확인 하는 로직
        return UserDetails.super.isEnabled();
    }
}
