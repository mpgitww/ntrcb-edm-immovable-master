package com.ntrcb.common.util;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.dom4j.*;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Org NTRCB
 * @Author: 06101675
 * @Description: xml 解析成 json 采用 dom4j 解析
 * @Date: create in 2022/9/11 13:38
 */
@Slf4j
public class XmlToJsonUtil {
    /**
     * xml转json_str
     */
    public static String xmlToJsonStr(String xmlStr){
        return xmlToJson(xmlStr).toString();
    }

    public static JSONObject xmlToJson(String xmlStr){
        JSONObject json = new JSONObject();
        try {
            Document doc = DocumentHelper.parseText(xmlStr);
            dom4j2Json(doc.getRootElement(), json);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return json;

    }



    public static void dom4j2Json(Element element, JSONObject json) {
        // 如果是属性
        for (Object o : element.attributes()) {
            Attribute attr = (Attribute) o;
            if (!ObjectUtils.isEmpty(attr.getValue())) {
                json.put("@" + attr.getName(), attr.getValue());
            }
        }
        List<Element> chdEl = element.elements();
        if (chdEl.isEmpty() && !ObjectUtils.isEmpty(element.getText())) {//如果没有子元素,只有一个值
            json.put(element.getName(), element.getText());
        }
        for (Element e : chdEl) {//有子元素
            if (!e.elements().isEmpty()) {//子元素也有子元素
                JSONObject chdjson = new JSONObject();
                dom4j2Json(e, chdjson);
                Object o = json.get(e.getName());
                if (o != null) {
                    JSONArray jsona = null;
                    if (o instanceof JSONObject) {//如果此元素已存在,则转为jsonArray
                        JSONObject jsono = (JSONObject) o;
                        json.remove(e.getName());
                        jsona = new JSONArray();
                        jsona.add(jsono);
                        jsona.add(chdjson);
                    }
                    if (o instanceof JSONArray) {
                        jsona = (JSONArray) o;
                        jsona.add(chdjson);
                    }
                    json.put(e.getName(), jsona);
                } else {
                    if (!chdjson.isEmpty()) {
                        json.put(e.getName(), chdjson);
                    }
                }
            } else {//子元素没有子元素
                for (Object o : element.attributes()) {
                    Attribute attr = (Attribute) o;
                    if (!ObjectUtils.isEmpty(attr.getValue())) {
                        json.put("@" + attr.getName(), attr.getValue());
                    }
                }
                if (!e.getText().isEmpty()) {
                    json.put(e.getName(), e.getText());
                }
            }
        }
    }
}
