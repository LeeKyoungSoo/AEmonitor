package net.lnworks.monitor.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudyInfoMngVO {
    private String studyId;
    private String studyNo;
    private String studyNm;
    private String ctcaeVer;
    private String uniqId;
    private String causalityKindType;
}
