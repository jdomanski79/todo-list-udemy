package pl.jdomanski.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.jdomanski.service.DemoService;

@Slf4j
@Controller
public class DemoController {

    // == fields ==
    private DemoService demoService;

    // == constructor ==
    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    // == mappings ==
    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    
    @GetMapping("welcome")
    public String welcome(@RequestParam String name, @RequestParam int age, Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(name));
        model.addAttribute("age", age);
        log.info("model = {}", model);
        return "welcome";
    }
    
    //== model attributes ==
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("added welcomeMessage @ModelAttribute");
        return demoService.getWelcomeMessage();
    }
    
}

