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
@TableName("qy_ds_edsp_xmid")
public class XmidEntity {

    @Id
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("cqzh")
    private String cqzh;

    @TableField("xmid")
    private String xmid;

    @TableField("create_time")
    private Date createTime;

}
