package net.lnworks.aemdapi.controller;

import lombok.extern.java.Log;
import net.lnworks.aemdapi.domain.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Log
@RequestMapping("/accounts/")
public class LoginController {
    @PostMapping(value = "/auth")
    public int goLogin(LoginVO loginVO) throws Exception {
        int returnNum = 0;

        log.info(" API - accounts/auth");

        return returnNum;
    }
}
