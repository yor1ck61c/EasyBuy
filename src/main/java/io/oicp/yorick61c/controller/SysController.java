package io.oicp.yorick61c.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class SysController {

    @RequestMapping(value = "/getData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getData(@RequestBody String json){
        System.out.println(json);
        JSONObject obj = new JSONObject();
        obj.put("PatientName","666");
        obj.put("PatientID","888");
        return obj.toJSONString();
    }
}
