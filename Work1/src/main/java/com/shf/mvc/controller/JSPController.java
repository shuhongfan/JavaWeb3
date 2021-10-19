package com.shf.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/register")
    public String Register(Model model){
        return "register";
    }

    @RequestMapping("/registerMethods")
    public String RegisterMethods(){
        return "registerMethods";
    }

    @RequestMapping("/times")
    public String Times(){
        return "times";
    }

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/loginMethods")
    public String LoginMethods(){
        return "loginMethods";
    }

    @RequestMapping("/welcome")
    public String Welcome(){
        return "welcome";
    }

    @RequestMapping("/error")
    public String Error(){
        return "error";
    }

    @RequestMapping("/vote")
    public String Vote(){
        return "vote";
    }

    @RequestMapping("/voteAdd/{id}")
    public String VoteAdd(@PathVariable String id,Model model){
        System.out.println(id);
        model.addAttribute("id",id);
        return "voteAdd";
    }

    @RequestMapping("/jdbc/addUser")
    public String addUser(){
        return "addUser";
    }
}
