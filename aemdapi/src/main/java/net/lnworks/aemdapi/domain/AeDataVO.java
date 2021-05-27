package net.lnworks.aemdapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class AeDataVO implements Serializable {
    private static final long serialVersionUID = 8790295116848734737L;

    private String studyId;
    private String prtcpntId;

    private MessageVO message;
    private ReturnMessageVO apiResult;
}
