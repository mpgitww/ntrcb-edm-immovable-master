package com.ntrcb.common.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import com.ntrcb.common.constant.Charsets;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: json 转 xml 采用 net.sf.json
 * @Date: create in 2022/9/11 13:38
 */
@Slf4j
public class JsonToXmlUtil {

    /**
     * jsonStr2XmlStr
     *
     * @param jsonString
     * @param charSet
     * @return
     */
    public static String jsonStr2XmlStr(String jsonString, String charSet) {
        XMLSerializer xmlSerializer = new XMLSerializer();
        xmlSerializer.setRootName("root");
        xmlSerializer.setTypeHintsEnabled(false);
        xmlSerializer.setForceTopLevelObject(true);
        String xmlStr = xmlSerializer.write(JSONSerializer.toJSON(jsonString));
        xmlStr = xmlStr.replace("<?xml version=\"1.0\" encoding=\"UTF-8\"?>", "<?xml version=\"1.0\" encoding=\"" + charSet + "\"?>");
        return xmlStr;
    }

    /**
     * JSON(数组)字符串<STRONG>转换</STRONG>成XML字符串
     *
     * @param jsonString jsonString
     * @return string
     */
    public static String jsonStr2XmlStr(String jsonString) {
        return jsonStr2XmlStr(jsonString, Charsets.CHARSET_GBK);
    }
}