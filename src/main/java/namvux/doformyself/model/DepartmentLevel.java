package namvux.doformyself.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DepartmentLevel {
    @Id
    private String code;

    @OneToOne(mappedBy = "parentDepartmentLevel")
    @JsonIgnore
    private DepartmentLevel departmentLevelCode;

    @Column(name = "name")
    private String name;

    @Column(name = "can_approve")
    private Boolean canApprove;

    @Column(name = "approval_level_name")
    private String approvalLevelName;

    @OneToOne
    @JoinColumn(name = "parent_department_level_code", referencedColumnName = "code")
    @JsonIgnore
    private DepartmentLevel parentDepartmentLevel;

    @Column(name = "display_order")
    private short displayOrder;
}
