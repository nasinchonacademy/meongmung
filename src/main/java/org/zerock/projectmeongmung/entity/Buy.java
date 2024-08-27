package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "buy")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderno", updatable = false)
    private Long orderno;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private User user;

    @Column(name = "res_name", nullable = false)
    private String resName;

    @Column(name = "res_address", nullable = false)
    private String resAddress;

    @Column(name = "res_phone", nullable = false)
    private String resPhone;

    @Column(name = "res_requirement")
    private String resRequirement;

    @Column(name = "totalprice", nullable = false)
    private int totalPrice;

    @Column(name = "orderdate", nullable = false)
    private Timestamp orderDate;

    @Builder
    public Buy(User user, String resName, String resAddress, String resPhone, String resRequirement, int totalPrice, Timestamp orderDate) {
        this.user = user;
        this.resName = resName;
        this.resAddress = resAddress;
        this.resPhone = resPhone;
        this.resRequirement = resRequirement;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }
}

