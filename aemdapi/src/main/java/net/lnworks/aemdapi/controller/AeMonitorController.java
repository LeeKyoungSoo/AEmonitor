package net.lnworks.aemdapi.controller;

import lombok.extern.java.Log;
import net.lnworks.aemdapi.domain.AeDataVO;
import net.lnworks.aemdapi.domain.MessageVO;
import net.lnworks.aemdapi.domain.ReturnMessageVO;
import net.lnworks.aemdapi.domain.study.AEMPrtcpntSymptmsVO;
import net.lnworks.aemdapi.service.study.AEMntmgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
@RequestMapping("/aemonitors/")
public class AeMonitorController {

    @Autowired
    private AEMntmgService aeMntmgService;

    @PostMapping(value="/testApi")
    public AeDataVO userTestApi(@RequestBody AeDataVO  aeDataVO) throws  Exception {

        log.info(" API - aemonitors/userAeData");

        return aeDataVO;
    }

    @PostMapping(value = "/userAeData")
    public AeDataVO userAeData(@RequestBody AeDataVO aeDataVO) throws Exception {
        //AeDataVO returnAeData = new AeDataVO();

        log.info(" API - aemonitors/userAeData");
        //System.out.println(aeDataVO);

        MessageVO mesVo = aeDataVO.getMessage();
        AEMPrtcpntSymptmsVO inputData = new AEMPrtcpntSymptmsVO();
        inputData.setStudyId(aeDataVO.getStudyId());
        inputData.setPrtcpntId(aeDataVO.getPrtcpntId());
        inputData.setSymptmsRegtypeCode(mesVo.getSymptmsRegtypeCode());
        inputData.setSymptmsCn(mesVo.getSymptmsCn());
        inputData.setCallPartner(mesVo.getCallPartner());
        inputData.setSymptmsRegistDe(mesVo.getSymptmsRegistDe());
        inputData.setFrstRegisterId("apiSystem");
        inputData.setLastUpdusrId("apiSystem");
        int resultNum = aeMntmgService.insertSymptms(inputData);
        if ( resultNum > 0 ) {
            ReturnMessageVO returnMessage = new ReturnMessageVO();
            returnMessage.setRetunCode("100");
            returnMessage.setReturnMessage("aemonitors data input Success");
            aeDataVO.setApiResult(returnMessage);
        }
        else {
            ReturnMessageVO returnMessage = new ReturnMessageVO();
            returnMessage.setRetunCode("200");
            returnMessage.setReturnMessage("aemonitors data input fail");
            aeDataVO.setApiResult(returnMessage);
        }
        return aeDataVO;
    }
}
