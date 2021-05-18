package net.lnworks.aemdapi.controller;

import lombok.extern.java.Log;
import net.lnworks.aemdapi.domain.AeDataVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequestMapping("/aemonitors/")
public class AeMonitorController {
    @PostMapping(value = "/userAeData")
    public int goLogin(AeDataVO aeDataVO) throws Exception {
        int returnNum = 0;

        log.info(" API - aemonitors/userAeData");

        return returnNum;
    }
}
