package net.lnworks.aemdapi.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageVO {
    private String symptmsRegtypeCode;
    private String type;
    private String symptmsCn;
    private String callPartner;
    private String symptmsRegistDe;
}
