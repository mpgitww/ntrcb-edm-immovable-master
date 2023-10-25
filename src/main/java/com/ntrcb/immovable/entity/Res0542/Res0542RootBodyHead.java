package com.ntrcb.immovable.entity.Res0542;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description:
 * @Date: create in 2022/9/11 14:43
 */
@Data
public class Res0542RootBodyHead {
    @ApiModelProperty(value = "流水号",required = false, notes = "唯一流水号")
    private String stdpid;
    @ApiModelProperty(value = "信息校验结果",required = false, example = "1:通过；0不通过")
    private String stdmerrslt;
    @ApiModelProperty(
            value = "申请人信息未通过项",
            required = true,
            example = "1:个人编号不存在; 2:证件信息不匹配;3:姓名不匹配"
    )
    private String stdrslttp;
    @ApiModelProperty(value = "公积金中心行政机构代码",required = false, notes = "中心提供固定值")
    private String stdjcfsdd;
    @ApiModelProperty(value = "中心机构代码",required = false, notes = "Accuorgaid")
    private String stdsjfsjg;
    @ApiModelProperty(value = "申请人基本信息姓名",required = true, notes = "custname")
    private String std400cunm;
    @ApiModelProperty(value = "申请人基本信息姓名简拼",required = false, notes = "Null空")
    private String std400dfnm;
    @ApiModelProperty(value = "申请人基本信息性别",required = false, example = "M-男 F-女，sexsign")
    private String std400sexx;
    @ApiModelProperty(value = "申请人基本信息个人登记号",required = false, notes = "Null空")
    private String std400rgid;
    @ApiModelProperty(value = "申请人公积金号",required = false, notes = "Custacn")
    private String std400grid;
    @ApiModelProperty(value = "申请人基本信息证件类型",required = true, notes = "0:居民身份证")
    private String std400idtp;
    @ApiModelProperty(value = "申请人基本信息证件号码",required = true, notes = "Paperid")
    private String std400idno;
    @ApiModelProperty(value = "申请人基本信息出生年月",required = false, notes = "birtdate, Date类型")
    private String std400brth;
    @ApiModelProperty(value = "申请人基本信息参加工作时间",required = false, notes = "Null空")
    private String std400wktm;
    @ApiModelProperty(value = "申请人基本信息税前工资总额",required = false, notes = "monthinco")
    private BigDecimal std400sqam;
    @ApiModelProperty(value = "申请人基本信息住宅电话",required = false, notes = "tel")
    private String std400gddh;
    @ApiModelProperty(value = "申请人基本信息手机号",required = true, notes = "mobile")
    private String std400mobl;
    @ApiModelProperty(value = "申请人基本信息联系地址(家庭）",required = true, notes = "Addr")
    private String std400addr;
    @ApiModelProperty(value = "申请人现缴存单位信息单位名称",required = true, notes = "custname")
    private String stdcmpnm;
    @ApiModelProperty(value = "申请人现缴存单位信息单位登记号",required = false, notes = "Null空")
    private String stdcmprgno;
    @ApiModelProperty(value = "申请人现缴存单位信息开户管理部编号",required = false, notes = "agentcorpno")
    private String stdcmpkhid;
    @ApiModelProperty(value = "申请人现缴存单位信息初次登记时间",required = true, notes = "Operdate, Date类型")
    private String stdcmprgtm;
    @ApiModelProperty(value = "申请人现缴存单位信息组织机构代码",required = false, notes = "orgaid")
    private String stdcmpzzno;
    @ApiModelProperty(value = "申请人现缴存单位信息营业执照号码(工商注册号)",required = true, notes = "liceid")
    private String stdcmpzyyno;
    @ApiModelProperty(value = "申请人现缴存单位信息性质代码",required = true,
                        notes = "Orgakind" ,
                        example = "A1 国家机关;" +
                                "B1 事业单位;" +
                                "C1 民办非企业单位;" +
                                "D1 社会团体;" +
                                "E1 国有;E2 集体;E3 股份合作企;E4 联营;E5 有限责任公司;E6 股份有限公司;E7 私营;E8 其它;" +
                                "F1 与港澳台商合资经营;F2 与港澳台商合作经营;F3 港澳台商独资;F4 港澳台商投资股份有限公司;" +
                                "G1 中外合资经营;G2 中外合作经营;G3 外商独资;G4 外商投资股份有限公司;" +
                                "H1 部队;" +
                                "I1 其他单位"
    )
    private String stdcmpprpt;
    @ApiModelProperty(value = "申请人现缴存单位信息单位地址",required = true, notes = "Addr")
    private String stdcmpaddr;
    @ApiModelProperty(value = "申请人现缴存单位信息单位缴存状态",required = false, notes = "corpacstat")
    private String stdcmpjczt;
    @ApiModelProperty(value = "申请人现缴存单位信息单位缴存资金来源",required = false, example = "0:财政；1:自筹")
    private String stdcmpjcly;
    @ApiModelProperty(value = "申请人现缴存单位信息法定代表人或负责人",required = false, notes = "leadcustname")
    private String stdcmpdbnm;
    @ApiModelProperty(value = "申请人现缴存单位信息单位联系方式",required = false, notes = "corplinkmantel")
    private String stdcmptel;
    @ApiModelProperty(value = "申请人现缴存单位信息单位开户银行及行号（缴存银行）",required = false, notes = "banktype")
    private String stdcmpkhbk;
    @ApiModelProperty(value = "申请人现缴存单位信息单位账号",required = false, notes = "CORPACNO")
    private String stdcmpacno;
    @ApiModelProperty(value = "申请人现缴存单位信息发薪日期（缴交日）",required = false, notes = "Saveday")
    private String stdcmpfxrq;
    @ApiModelProperty(value = "申请人现缴存单位信息是否申请公积金缓缴",required = false, example = "TurnStat 1:是；0:否")
    private String stdcmphjfg;
    @ApiModelProperty(value = "申请人现缴存单位信息申请缓缴时间",required = false, notes = "Null空")
    private String stdcmphjdt;
    @ApiModelProperty(value = "申请人现缴存单位信息申请缓缴的原因",required = false, notes = "Null空")
    private String stdcmphjrn;
    @ApiModelProperty(value = "个人公积金账户信息公积金账号",required = false, notes = "Custacno")
    private String stdgjjacno;
    @ApiModelProperty(value = "个人公积金账户信息开户日期",required = true, notes = "operdate，Date类型")
    private String stdgjjrgdt;
    @ApiModelProperty(value = "个人公积金账户信息初缴年月日",required = true, notes = "FirstSaveDate,2010年后是否取开户日期的下个月，Date类型")
    private String stdgjjstdt;
    @ApiModelProperty(value = "个人公积金账户信息缴至年月日",required = false, notes = "LastSaveMonth")
    private String stdgjjendt;
    @ApiModelProperty(value = "个人公积金账户信息近十二个月月缴存单位名称",notes = "list, 以‘|’ 分割")
    private String stdgjjennm;
    @ApiModelProperty(value = "个人公积金账户信息近十二个月单位缴存额",notes = "list, 以‘|’ 分割")
    private String stdgjjdwam;
    @ApiModelProperty(value = "个人公积金账户信息近十二个月单位缴存比例",required = true,notes = "list, 以‘|’ 分割")
    private String stdgjjdwsc;
    @ApiModelProperty(value = "个人公积金账户信息近十二个月缴存状态",required = true,notes = "list, 以‘|’ 分割")
    private String stdglljcst;
    @ApiModelProperty(value = "个人公积金账户信息最近一次缴交日期",required = false)
    private String stdgjjltdt;
    @ApiModelProperty(value = "个人公积金账户信息当前公积金年度",required = false)
    private String stdgjjcdqnd;
    @ApiModelProperty(value = "个人公积金账户信息累计缴存次数",required = true, notes = "近12个月")
    private String stdgjjjccs;
    @ApiModelProperty(value = "个人公积金账户信息近36个月累计缴存次数",required = true, notes = "近36个月")
    private String stdgjjjccs36;
    @ApiModelProperty(value = "个人公积金账户信息近12个月连续缴存次数",required = true)
    private String stdgjjlxjccs;
    @ApiModelProperty(value = "个人公积金账户信息当前余额",required = true)
    private BigDecimal stdgjjacbl;
    @ApiModelProperty(value = "个人公积金账户信息近12个自然月个人缴存额",required = true, notes = "list, 以‘|’ 分割")
    private String stdgjjgram;
    @ApiModelProperty(value = "个人公积金账户信息近12个自然月个人缴存比例",required = true, notes = "list, 以‘|’ 分割")
    private String stdgjjgrsc;
    @ApiModelProperty(value = "个人公积金账户信息近12个自然月单位缴存比例",required = true, notes = "list, 以‘|’ 分割")
    private String stdcmpyjsc;
    @ApiModelProperty(value = "个人公积金提取信息公积金账号",required = false)
    private String stdgjjwdid;
    @ApiModelProperty(value = "个人公积金提取信息提取原因",required = false)
    private String stdgjjwdrn;
    @ApiModelProperty(value = "个人公积金提取信息提取时间",required = false)
    private String stdgjjwddt;
    @ApiModelProperty(value = "个人公积金提取信息提取方式",required = false)
    private String stdgjjwdtp;
    @ApiModelProperty(value = "个人公积金提取信息核定提取总额",required = false)
    private String stdgjjhdze;
    @ApiModelProperty(value = "个人公积金提取信息提取金额",required = false)
    private String stdgjjwdam;
    @ApiModelProperty(value = "个人公积金提取信息累计提取金额",required = false)
    private String stdgjjouam;
    @ApiModelProperty(value = "个人公积金提取信息共同提取人姓名",required = false)
    private String stdgjjtwdnm;
    @ApiModelProperty(value = "个人公积金提取信息共同提取人身份证号",required = false)
    private String stdgjjtwdno;
    @ApiModelProperty(value = "个人公积金提取信息共同提取人是否建立公积金",required = false)
    private String stdgjjtwdbd;
    @ApiModelProperty(value = "个人公积金贷款信息公积金账号",required = false)
    private String stdgjjdkid;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款编号",required = false)
    private String stdgjjdkbh;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款金额",required = false)
    private String stdgjjdkam;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款期限",required = false)
    private String stdgjjdkpd;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款月还款额",required = false)
    private String stdgjjppam;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款起始日期",required = false)
    private String stdgjjdkdt;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款到期日期",required = false)
    private String stdgjjmudt;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款结清日期",required = false)
    private String stdgjjjqdt;
    @ApiModelProperty(value = "个人公积金贷款信息共同贷款人姓名",required = false)
    private String stdgjjtdknm;
    @ApiModelProperty(value = "个人公积金贷款信息共同贷款人身份证号",required = false)
    private String stdgjjtdkno;
    @ApiModelProperty(value = "个人公积金贷款信息共同贷款人是否建立公积金",required = false)
    private String stdgjjtdkbd;
    @ApiModelProperty(value = "个人公积金贷款信息联系地址(家庭）",required = false)
    private String stdgjjdkaddr;
    @ApiModelProperty(value = "个人公积金贷款信息贷款状态",required = false)
    private String stdgjjdkzt;
    @ApiModelProperty(value = "个人公积金贷款信息当期还款状态",required = false)
    private String stdgjjdqzt;
    @ApiModelProperty(value = "个人公积金贷款信息公积金贷款历史发生逾期次数",required = false)
    private String stdgjjyqcs;
    @ApiModelProperty(value = "个人公积金贷款信息最大连续的逾期期数（近24个月）",required = false)
    private String stdgjjmyqcs;
    @ApiModelProperty(value = "个人购/租房信息个人购房地址",required = false)
    private String stdhougfad;
    @ApiModelProperty(value = "个人购/租房信息个人租房地址",required = false)
    private String stdhouzfad;
    @ApiModelProperty(value = "个人购/租房信息房屋购买记税价格",required = false)
    private String stdhougfam;
    @ApiModelProperty(value = "个人购/租房信息房屋租金",required = false)
    private String stdhouzfam;
    @ApiModelProperty(value = "个人公积金账户信息近3个月连续缴存次数",required = true)
    private String stdgjjlxjccs3;
    @ApiModelProperty(value = "个人公积金账户信息近6个月连续缴存次数",required = true)
    private String stdgjjlxjccs6;
    @ApiModelProperty(value = "个人公积金账户信息近24个月单位/个人缴存年月",required = false, notes = "邮储银行使用")
    private String stdgjjjcny;
    @ApiModelProperty(value = "个人公积金账户信息近24个月单位/个人实缴日期",required = false, notes = "邮储银行使用")
    private String stdgjjsjrq;
    @ApiModelProperty(value = "个人公积金账户信息近24个月连续缴存次数(不含补缴)",required = false, notes = "邮储银行使用")
    private String stdgjjjccs24;
    @ApiModelProperty(value = "个人公积金账户信息近24个月缴存类型",required = false, notes = "邮储银行使用", example = "11正常汇缴;13单位补缴;14提前汇缴")
    private String Stdgjjjclx24;

}
