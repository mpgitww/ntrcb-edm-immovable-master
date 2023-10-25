package com.ntrcb.common.util;

public class ParamUtil {
    public static String replaceParam(String param){
        String s  = "";
        if ("Ind01".equals(param)){
            s = "1";
        }else if ("Ind02".equals(param)){
            s = "4";
        }else if ("Ind03".equals(param)){
            s = "3";
        }else if ("Ind04".equals(param)){
            s = "5";
        }else if ("Ind05".equals(param)){
            s = "5";
        }else if ("Ind06".equals(param)){
            s = "2";
        }else if ("Ind07".equals(param)){
            s = "2";
        }else if ("Ind08".equals(param)){
            s = "1";
        }else if ("Ind09".equals(param)){
            s = "99";
        }else if ("Ind10".equals(param)){
            s = "5";
        }else if ("Ind11".equals(param)){
            s = "99";
        }else if ("Ind12".equals(param)){
            s = "2";
        }else if ("Ind13".equals(param)){
            s = "2";
        }else if ("Ind14".equals(param)){
            s = "2";
        }else if ("Ind15".equals(param)){
            s = "99";
        }else if ("Ind16".equals(param)){
            s = "99";
        }else if ("Ind17".equals(param)){
            s = "99";
        }else if ("Ind18".equals(param)){
            s = "2";
        }
        return s;
    }

    public static String replaceDjyy(String param){
        if ("320600".equals(param)){
            return "17";
        }else if ("320612".equals(param)){
            return "123459";
        }else if ("320623".equals(param)){
            return "123461";
        }else if ("320681".equals(param)){
            return "123462";
        }else if ("320682".equals(param)){
            return "123463";
        }else if ("320621".equals(param)){
            return "123464";
        }else if ("320604".equals(param)){
            return "123480";
        }else if ("320698".equals(param)){
            return "123481";
        }else if ("320699".equals(param)){
            return "123482";
        }else if ("320684".equals(param)){
            return "123484";
        }
        return "17";
    }

    public static String replaceZlmc(String param){
        if ("1".equals(param)){
            return "个人";
        }else if ("2".equals(param)){
            return "企业";
        }else if ("3".equals(param)){
            return "法院";
        }else if ("4".equals(param)){
            return "事业单位";
        }else if ("5".equals(param)){
            return "国家机关";
        }
        return "其他";
    }


    public static String replaceGyfsmc(String param){
        if ("0".equals(param)){
            return "单独所有";
        }else if ("1".equals(param)){
            return "共同共有";
        }else if ("2".equals(param)){
            return "按份共有";
        }else if ("3".equals(param)){
            return "其它共有";
        }
        return "";
    }

    public static String replaceFjlx4Dydjcj(String param){
        //不动产登记申请书
        if ("REALESTATE_REG_APPLY".equals(param)){
            return "2020091711";
        }
        //不动产登记询问笔录
        else if ("REALESTATE_RECORD".equals(param)){
            return "2020092711";
        }
        //主债权合同及抵押合同信息采集表
        else if ("CREDITOR_MORTGAGE_CONTRACT_TABLE".equals(param)){
            return "108";
        }
        //不动产证
        else if ("REALESTATE_PROVE".equals(param)){
            return "231";
        }
        //授权委托书
        else if ("POWER_OF_ATTORNEY".equals(param)){
            return "20220524";
        }
        //ID_CARD	身份证
        //RESIDENCE	户口本
        //MARRIAGE_ PROVE	结婚证或婚姻状况证明
        //MANAGER_TALK	客户经理谈话照片
        else if ("ID_CARD".equals(param) || "RESIDENCE".equals(param) ||"MARRIAGE_PROVE".equals(param)){
            return "21";
        }
        return param;
    }

    public static String replaceFjlx4Dyzx(String param){
        //不动产登记申请书
        if ("REALESTATE_REG_APPLY".equals(param)){
            return "2020091701";
        }
        //不动产登记询问笔录
        else if ("REALESTATE_RECORD".equals(param)){
            return "2020092701";
        }
        //他项权利证书或不动产登记证明
        else if ("OTHER_OR_REALESTATE_PROVE".equals(param)){
            return "996";
        }
        //授权委托书
        else if ("POWER_OF_ATTORNEY".equals(param)){
            return "2022120201";
        }
        //ID_CARD	身份证
        //RESIDENCE	户口本
        //MARRIAGE_ PROVE	结婚证或婚姻状况证明
        else if ("ID_CARD".equals(param) || "RESIDENCE".equals(param) ||"MARRIAGE_PROVE".equals(param) || "REALESTATE_PROVE".equals(param)){
            return "20";
        }
        return "60";
    }

}
