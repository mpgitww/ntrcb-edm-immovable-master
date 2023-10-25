package com.ntrcb.immovable.entity.Immovable.model;

import lombok.Data;

/**
 * 物流信息
 */
@Data
public class LogisticsMegModel {


    //领证方式代码
    private String lzfsdm;
    //领证方式名称
    private String lzfsmc;
    //收件人联系电话
    private String sjrlxdh;
    //收件人名称
    private String sjrmc;
    //收件人所在市
    private String sjrszshi;
    //收件人所在省
    private String sjrszsheng;
    //收件人所在县
    private String sjrszx;
    //收件人详细地址
    private String sjrxxdz;
    //电子邮箱（收件人）
    private String dzyx;
    //领证人名称
    private String lzrmc;
    //领证人证件种类代码
    private String lzrzjzldm;
    //领证人证件种类名称
    private String lzrzjzlmc;
    //领证人证件号
    private String lzrzjh;
    //领证人联系电话
    private String lzrlxdh;
    //领证人证件种类
    private String lzrzjzl;
    //物流id
    private String wlid;
    //领证详细地址
    private String lzxxdz;

}
