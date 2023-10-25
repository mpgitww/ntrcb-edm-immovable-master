package com.ntrcb.immovable.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import nonapi.io.github.classgraph.json.Id;

import java.util.Date;

@Data
@Accessors(chain = true)
@TableName("qy_ds_edsp_bjjdts")
public class PushEntity {

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("slbh")
    private String slbh;

    @TableField("action_time")
    private String actionTime;

    @TableField("bjzt")
    private String bjzt;

    @TableField("dyzmh")
    private String dyzmh;

    @TableField("bjztsbyy")
    private String bjztsbyy;

    @TableField("xzqdm")
    private String xzqdm;

    @TableField("create_time")
    private Date createTime;

}
