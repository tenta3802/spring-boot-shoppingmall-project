package com.shop.shop.entity;

import com.shop.shop.constant.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter @Setter
@ToString
public class Member {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String name;
    private String address;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member createMember() {
        Member member = new Member();
        return member;
    }
}

