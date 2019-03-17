package com.noc.ad.entity;

import com.noc.ad.constant.CommonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户账户表对应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_user")
public class AdUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 账户名称
    @Basic
    @Column(name = "username", nullable = false)
    private String username;

    // 账户token
    @Basic
    @Column(name = "token", nullable = false)
    private String token;

    // 创建状态
    @Basic
    @Column(name = "user_status", nullable = false)
    private Integer userStatus;

    // 创建时间
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    // 更新时间
    @Basic
    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public AdUser(String username, String token) {
        this.username = username;
        this.token = token;
        this.userStatus = CommonStatus.VALID.getStatus();
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }
}
