package net.lnworks.monitor.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
public class MemberRole {
    private Long fno;
    private String roleName;
    private String uid;
}
