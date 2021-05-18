package net.lnworks.aemdapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
public class AeDataVO implements Serializable {
    private static final long serialVersionUID = 8790295116848734737L;

    private String studyCode;
    private String subjectKey;

    private List<MessageVO> message;
}
