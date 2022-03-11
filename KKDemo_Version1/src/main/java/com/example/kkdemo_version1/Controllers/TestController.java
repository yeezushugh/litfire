package com.example.kkdemo_version1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TestController {

    @RequestMapping (value = "/index", method = RequestMethod.GET)
    public String GetMainFunctionalIndex(){
        return "mainFunctionalIndex";
    }

    @RequestMapping (value = "/login/default", method = RequestMethod.GET)
    public String GetLoginIndex(){
        return "loginIndex";
    }

    @RequestMapping (value = "/login/githuboauth", method = RequestMethod.GET)
    public String GetGitHubOauthLoginIndex(){
        return "loginIndex";
    }

    @RequestMapping (value = "/login/googleoauth", method = RequestMethod.GET)
    public String GetGoogleOauthLoginIndex(){
        return "loginIndex";
    }
    /*
GET /favicon.ico
GET /apple-touch-icon-120x120-precomposed.png
GET /apple-touch-icon-120x120.png
GET /apple-touch-icon.png
GET /apple-touch-icon.png
    * */
}
