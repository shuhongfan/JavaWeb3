package com.shf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JSPController {
    @RequestMapping("/hi")
    public String Hi(){
        return "Hi";
    }

    @RequestMapping("/counter")
    public String Counter(Model model){
        return "Counter";
    }

    @RequestMapping("/sum")
    public String Sum(Model model){
        return "Sum";
    }

    @RequestMapping("/table")
    public String Table(Model model){
        return "Table";
    }
    
    @RequestMapping("/counterInclude")
    public String CounterInclude(Model model){
        return "CounterInclude";
    }

    @RequestMapping("/counterForward")
    public String CounterForward(Model model){
        return "CounterForward";
    }
}
