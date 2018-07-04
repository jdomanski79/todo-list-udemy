package pl.jdomanski.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.jdomanski.service.DemoService;

@Slf4j
@Controller
public class DemoController {

    // == constants ==
    private final static String USERNAME = "Jarek";
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
    public String welcome(Model model){
        model.addAttribute("helloMessage", demoService.getHelloMessage(USERNAME));
        model.addAttribute("welcomeMessage", demoService.getWelcomeMessage());
        log.info("model = {}", model);
        return "welcome";
    }
    
}

