package net.lnworks.aemdapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVO {
    private String messageNo;
    private String type;
    private String content;
    private String fileId;
    private String regTm;
}
