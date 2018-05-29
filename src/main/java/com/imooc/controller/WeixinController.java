package com.imooc.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by chenhaitao
 * 2017-07-03 00:50
 */
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {


    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        log.info("进入auth方法。。。");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx27f347f2f4c76849&secret=bfbf986e8a23178486f30f74c1ad0929&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }


    @GetMapping(value = "check", produces = "text/plain;charset=utf-8")
    public String checkToken(String timestamp, String nonce, String echostr, String signature){
        log.debug("接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", timestamp, nonce, echostr, signature);

        if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        if (wxMpService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }

    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        System.out.println("--------->"+name);
        if(name.contains("海涛")&&!name.startsWith("杜")){
            return name+"是天下第一帅!";}else if(null==name||name.trim().equals("")){
            return "请在链接后面加上姓名";
        }
        return name+"是个大傻叉!";
    }



    @GetMapping("/testException")
//    @ResponseStatus(value = HttpStatus.ACCEPTED,reason = "接口被禁用")
    public Integer testException(@RequestParam("value") String name) {
        return Integer.valueOf(name);
    }
}
