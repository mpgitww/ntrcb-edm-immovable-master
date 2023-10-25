package com.ntrcb.immovable.service.imp;

import cn.hutool.core.io.file.FileReader;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ntrcb.common.util.Base64Util;
import com.ntrcb.common.util.ParamUtil;
import com.ntrcb.common.util.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class DownMethodHandler {

    private static final Logger logger = LoggerFactory.getLogger(DownMethodHandler.class);

    @Value("${property.file.localpath}")
    private String localpath;

    public JSONObject getUrltoByte4DydjFjxx(JSONObject jsonObject){
        //判断文件夹是否存在
        File fileDown = new File(localpath);
        if(!fileDown.exists()){
            try {
                fileDown.mkdirs();
            } catch (Exception e) {
                logger.info("创建文件夹失败");
            }
        }

        //获取url
        try{
            byte[] bytes = Base64Util.decryptBASE64(jsonObject.getStr("fileUrl"));
            String url = new String(bytes);
            //设置合同编号为文件名称
            String fileName = "bjbh"+jsonObject.getStr("bjbh");
            fileName = ToolUtil.download(url, localpath, fileName);
            //获取文件内容
            File file = new File(localpath+fileName);
            FileReader fileReader = new FileReader(file);
            String result =fileReader.readString();
            System.out.println(result);
            List<JSONObject> list1 = new ArrayList<>();
            JSONObject object = JSONUtil.parseObj(result);
            JSONArray list = object.getJSONArray("attachmentInfoList");
            for (Object o : list) {
                JSONObject jsonObject1 = (JSONObject) o;
                JSONObject params = new JSONObject();
                params.set("clmc",jsonObject1.getStr("clmc"));
                params.set("mrfjys",jsonObject1.getStr("ys"));
                params.set("ys",jsonObject1.getStr("ys"));
                params.set("fs",jsonObject1.getStr("fs"));
                params.set("fjlx", ParamUtil.replaceFjlx4Dydjcj(jsonObject1.getStr("cldm")));
                JSONArray clnr = jsonObject1.getJSONArray("clnr");
                List<JSONObject> list2 = new ArrayList<>();
                for (int i = 0; i < clnr.size(); i++) {
                    JSONObject jsonObject2 = clnr.getJSONObject(i);
                    JSONObject clnrParams = new JSONObject();
                    clnrParams.set("fjmc",jsonObject2.getStr("fileName") +"."+ jsonObject2.getStr("fileType"));
                    //读取真正附件内容
                    byte[] fjUrlBytes = Base64Util.decryptBASE64(jsonObject2.getStr("url"));
                    String  fjUrl = new String(fjUrlBytes);
                    String fjName = "bjbh"+jsonObject.getStr("bjbh") + "_"+jsonObject2.getStr("fileNo");
                    fjName = ToolUtil.download(fjUrl, localpath, fjName);
                    //获取文件内容
                    File fjFile = new File(localpath+fjName);
                    FileReader fjFileReader = new FileReader(fjFile);
                    clnrParams.set("bytes",fjFileReader.readString());
                    list2.add(clnrParams);
                }
                params.set("clnr",list2);
                list1.add(params);
            }
            jsonObject.set("fjxx",list1);
            //删除文件
            file.delete();
            return jsonObject;
        }catch (Exception e){
            logger.info("下载文件失败："+e.getMessage());
        }
        return jsonObject;
    }

    public JSONObject getUrltoByte4DyzxFjxx(JSONObject jsonObject){
        //判断文件夹是否存在
        File fileDown = new File(localpath);
        if(!fileDown.exists()){
            try {
                fileDown.mkdirs();
            } catch (Exception e) {
                logger.info("创建文件夹失败");
            }
        }

        //获取url
        try{
            byte[] bytes = Base64Util.decryptBASE64(jsonObject.getStr("fileUrl"));
            String url = new String(bytes);
            //设置合同编号为文件名称
            String fileName = "bjbh"+jsonObject.getStr("bjbh");
            fileName = ToolUtil.download(url, localpath, fileName);
            //获取文件内容
            File file = new File(localpath+fileName);
            FileReader fileReader = new FileReader(file);
            String result =fileReader.readString();
            System.out.println(result);
            List<JSONObject> list1 = new ArrayList<>();
            JSONObject object = JSONUtil.parseObj(result);
            JSONArray list = object.getJSONArray("attachmentInfoList");
            for (Object o : list) {
                JSONObject jsonObject1 = (JSONObject) o;
                JSONObject params = new JSONObject();
                params.set("clmc",jsonObject1.getStr("clmc"));
                params.set("mrfjys",jsonObject1.getStr("ys"));
                params.set("ys",jsonObject1.getStr("ys"));
                params.set("fs",jsonObject1.getStr("fs"));
                params.set("fjlx", ParamUtil.replaceFjlx4Dyzx(jsonObject1.getStr("cldm")));
                JSONArray clnr = jsonObject1.getJSONArray("clnr");
                List<JSONObject> list2 = new ArrayList<>();
                for (int i = 0; i < clnr.size(); i++) {
                    JSONObject jsonObject2 = clnr.getJSONObject(i);
                    JSONObject clnrParams = new JSONObject();
                    clnrParams.set("fjmc",jsonObject2.getStr("fileName") +"."+ jsonObject2.getStr("fileType"));
                    //读取真正附件内容
                    byte[] fjUrlBytes = Base64Util.decryptBASE64(jsonObject2.getStr("url"));
                    String  fjUrl = new String(fjUrlBytes);
                    String fjName = "bjbh"+jsonObject.getStr("bjbh") + "_"+jsonObject2.getStr("fileNo");
                    fjName = ToolUtil.download(fjUrl, localpath, fjName);
                    //获取文件内容
                    File fjFile = new File(localpath+fjName);
                    FileReader fjFileReader = new FileReader(fjFile);
                    clnrParams.set("bytes",fjFileReader.readString());
                    list2.add(clnrParams);
                }
                params.set("clnr",list2);
                list1.add(params);
            }
            jsonObject.set("fjxx",list1);
            //删除文件
            file.delete();
            return jsonObject;
        }catch (Exception e){
            logger.info("下载文件失败："+e.getMessage());
        }
        return jsonObject;
    }

    //获取链接内容，
    public JSONObject getUrltoByte(JSONObject jsonObject){
        //判断文件夹是否存在
        File fileDown = new File(localpath);
        if(!fileDown.exists()){
            try {
                fileDown.mkdirs();
            } catch (Exception e) {
                logger.info("创建文件夹失败");
            }
        }


       // "fileUrl":"aHR0cDovLzAwMXhkbmxwdC5lb3NkZXYuc2xzeXVuOjgwNjAvMDAxeGRubHB0LzQ0NzExODI4MzU4MjM0NTIxNi50eHQ/WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotRGF0ZT0yMDIzMDgxN1QwNDEyNTRaJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZYLUFtei1FeHBpcmVzPTYwNDgwMCZYLUFtei1DcmVkZW50aWFsPTZQVDZFVjJKNDJDU0xTQzhLWVRGJTJGMjAyMzA4MTclMkZ1cy1lYXN0LTElMkZzMyUyRmF3czRfcmVxdWVzdCZYLUFtei1TaWduYXR1cmU9NGU1MDhlZWEyNzkzNjE5N2Q0YWIxZDk3NTY1MzUyMDEwM2U4ZmEyM2NjMWEzMDQ3OTBhNzlkYmFmZDdjMjY2NA==",
        //获取url
        try{
            byte[] bytes = Base64Util.decryptBASE64(jsonObject.getStr("fileUrl"));
            String url = new String(bytes);
            //设置合同编号为文件名称
            String fileName = "bjbh"+jsonObject.getStr("bjbh");
            fileName = ToolUtil.download(url, localpath, fileName);
            //获取文件内容
            File file = new File(localpath+fileName);
            FileReader fileReader = new FileReader(file);
            String result =fileReader.readString();
            System.out.println(result);
            List<JSONObject> list1 = new ArrayList<>();
            JSONObject object = JSONUtil.parseObj(result);
            JSONArray list = object.getJSONArray("attachmentInfoList");
            int lx = 1;
            for (Object o : list) {
                JSONObject jsonObject1 = (JSONObject) o;
                JSONArray clnr = jsonObject1.getJSONArray("clnr");
//                JSONObject object1 = new JSONObject();
//                object1.fluentPut("0","116").fluentPut("1","32");
                for (int i = 0; i < clnr.size(); i++) {
                    JSONObject jsonObject2 = clnr.getJSONObject(i);

                    JSONObject params = new JSONObject();

                    params.set("xh",lx);
                    params.set("clmc",jsonObject1.getStr("clmc"));
                    params.set("fs",jsonObject1.getStr("fs"));
//                    params.set("fs","1");
                    params.set("ys",jsonObject1.getStr("ys"));
//                    params.set("ys","1");
                    params.set("fjmc",jsonObject2.getStr("fileName") +"."+ jsonObject2.getStr("fileType"));
                    params.set("fjlx",jsonObject2.getStr("fileType"));
                    byte[] fjUrlBytes = Base64Util.decryptBASE64(jsonObject2.getStr("url"));
                    String  fjUrl = new String(fjUrlBytes);
                    params.set("fjurl",fjUrl);
                    //读取真正附件内容
                    String fjName = "bjbh"+jsonObject.getStr("bjbh") + "_"+jsonObject2.getStr("fileNo");
                    fjName = ToolUtil.download(fjUrl, localpath, fjName);
                    //获取文件内容
                    File fjFile = new File(localpath+fjName);
                    FileReader fjFileReader = new FileReader(fjFile);
                    params.set("bytes",fjFileReader.readString());
                    list1.add(params);
                    lx = lx + 1;
                }

            }
            jsonObject.set("fjxx",list1);
            //删除文件
            file.delete();
            return jsonObject;
        }catch (Exception e){
            logger.info("下载文件失败："+e.getMessage());
        }
        return jsonObject;
    }

}
