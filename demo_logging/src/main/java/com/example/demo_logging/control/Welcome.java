package com.example.demo_logging.control;

import com.example.demo_logging.Person.person;
import lombok.extern.slf4j.Slf4j;
import org.apache.juli.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * @author 韩伟Q
 */
@Slf4j
@Controller
public class Welcome{


    @GetMapping("/well")

    public String hello(@RequestParam("name")String name, Model model){
        model.addAttribute("msg", name);

        model.addAttribute("imgUrl","goole2.jpg");
        log.info("已看到你发的名字：{}",name);
        return "Welcome";
    }

    //th-each 遍历
    @GetMapping("/list")
    public String lish(Model model){
        List<person> list = Arrays.asList(
                new person(1L,"张三1","",12,"pm"),
                new person(2L,"张三2","zs2@qq.com",13,"pm"),
                new person(3L,"张三3","zs3@qq.com",14,"pm"),
                new person(4L,"张三4","zs4@qq.com",15,"pm"),
                new person(5L,"张三5","zs5@qq.com",19,"pm")
        );
        model.addAttribute("persons", list);
        return "list";
    }
    @GetMapping("/")
    public String index() {
        return "index"; // 这里的 "index" 对应 templates/index.html
    }
//    @ResponseBody
//    @ExceptionHandler(Exception.class)
    public String handleException(Exception e)
    {

        return "ooo... 原因" + e.getMessage();
    }

}
