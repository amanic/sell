package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.annotation.SysOutAnnotation;
import com.imooc.annotation.SysOutTypeAnnotation;
import com.imooc.repository.OrderDetailRepository;
import com.imooc.service.TestService;
import com.imooc.test.mqTest.TestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * Created by chenhaitao on 2018/4/4.
 */
@Controller
@SysOutTypeAnnotation("disappointment")
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private TestProduct testProduct;

    @Autowired
    private TestService testService;

    @GetMapping("test01")
    @ResponseBody
    @SysOutAnnotation(value = "test01",required = false)
    public String test01(@RequestParam(value = "name")String name){
        return "Hello World！hello "+name;
    }

    @GetMapping("test02")
    @ResponseBody
    @SysOutAnnotation(value = "test02",required = true)
    public String test02(@RequestParam(value = "name")String name){
        return "Hello World！hello "+name;
    }

    /**
     * 测试使用beeltl模板
     * @return
     */
    @GetMapping("test03")
    public String test03(){
        return "/product/list.btl";
    }

    @PostMapping(value = "test04",params = "hhh!=1",headers = "myHeader=1",consumes = "application/json")
    @ResponseBody
    public String test04(){
        return "成功输出";
    }

    @GetMapping("test05")
    @ResponseBody
    public ResultVO test05(){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(null);
        resultVO.setCode(0);
        resultVO.setMsg("noThing");
        return resultVO;
    }


    @GetMapping("test06")
    @ResponseBody
    public Callable<ResultVO<String>> processUpload(HttpServletRequest request,
                                          final HttpServletResponse response) {
        System.out.println("线程名称："+Thread.currentThread().getName());
        return new Callable<ResultVO<String>>() {
            public ResultVO<String> call() throws Exception {
                try {
                    System.out.println("线程名称："+Thread.currentThread().getName());
                    response.setContentType("text/plain;charset=utf-8");
                    ResultVO<String> resultVO = new ResultVO<>();
                    resultVO.setMsg("xiaoxi");
                    resultVO.setCode(1);
                    resultVO.setData("data");
                    response.getWriter().write(resultVO.toString());
                    response.getWriter().close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
    }


    @GetMapping("test07")
    @ResponseBody
    public String test07(String s){
        testProduct.sendMessage(s);
        return s;
    }

    @GetMapping("test08")
    @ResponseBody
    public String test08(){
        testService.a();
        return "测试事物的传导性";
    }
}
