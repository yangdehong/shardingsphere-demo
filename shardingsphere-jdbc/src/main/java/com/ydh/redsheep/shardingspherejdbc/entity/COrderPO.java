package com.ydh.redsheep.shardingspherejdbc.entity;

import lombok.Data;

import java.lang.*;
import java.util.*;
import java.math.*;

import java.io.Serializable;

import javax.persistence.*;

/**
 *
 * @author : yangdehong
 * @date : 2021-01-24T21:08:07.742
 */
@Data
@Entity
@Table(name = "c_order")
public class COrderPO implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //
    @Column(name = "is_del")
    private boolean isDel; // 是否被删除
    @Column(name = "user_id")
    private Integer userId; // ⽤用户id
    @Column(name = "company_id")
    private Integer companyId; // 公司id
    @Column(name = "publish_user_id")
    private Integer publishUserId; // B端⽤用户id
    @Column(name = "position_id")
    private Integer positionId; // 职位ID
    @Column(name = "resume_type")
    private Integer resumeType; // 简历类型:0附件 1在线
    @Column(name = "status")
    private String status; // 投递状态 WAIT-待处理理 AUTO_FILTER-⾃自动过滤 PREPARE_CONTACT-待沟通 REFUSE-拒绝 ARRANGE_INTERVIEW-通知⾯面试
    @Column(name = "create_time")
    private Date createTime; // 创建时间
    @Column(name = "update_time")
    private Date updateTime; // 处理理时间



}
