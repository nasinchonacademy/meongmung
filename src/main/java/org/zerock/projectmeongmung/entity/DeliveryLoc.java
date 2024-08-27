package org.zerock.projectmeongmung.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "delivery_loc")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class DeliveryLoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private User user;

    @Column(name = "road_addr")
    private String roadAddr;

    @Column(name = "local_addr")
    private String localAddr;

    @Column(name = "etc_addr")
    private String etcAddr;

    @Builder
    public DeliveryLoc(User user, String roadAddr, String localAddr, String etcAddr) {
        this.user = user;
        this.roadAddr = roadAddr;
        this.localAddr = localAddr;
        this.etcAddr = etcAddr;
    }
}
