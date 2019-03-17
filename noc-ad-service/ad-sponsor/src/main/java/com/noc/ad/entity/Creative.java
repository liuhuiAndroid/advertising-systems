package com.noc.ad.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 创意表对应实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ad_creative")
public class Creative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // 创意名称
    @Basic
    @Column(name = "name", nullable = false)
    private String name;

    // 物料类型（图片、视频）
    @Basic
    @Column(name = "type", nullable = false)
    private Integer type;

    /** 物料的类型, 比如图片可以是 bmp, jpg等等 */
    @Basic
    @Column(name = "material_type", nullable = false)
    private Integer materialType;

    // 高度
    @Basic
    @Column(name = "height", nullable = false)
    private Integer height;

    // 宽度
    @Basic
    @Column(name = "width", nullable = false)
    private Integer width;

    /** 物料大小 */
    @Basic
    @Column(name = "size", nullable = false)
    private Long size;

    /** 持续时长, 只有视频不为0 */
    @Basic
    @Column(name = "duration", nullable = false)
    private Integer duration;

    /** 审核状态 */
    @Basic
    @Column(name = "audit_status", nullable = false)
    private Integer auditStatus;

    // 标记当前所属用户
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // 无聊地址
    @Basic
    @Column(name = "url", nullable = false)
    private String url;

    // 创建时间
    @Basic
    @Column(name = "create_time", nullable = false)
    private Date createTime;

    // 更新时间
    @Basic
    @Column(name = "updateTime", nullable = false)
    private Date updateTime;
}
