package namvux.doformyself.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Department {

    @Id
    private String code;

    @OneToOne(mappedBy = "parentDepartment")
    @JsonIgnore
    private Department departmentCode;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_level_code", referencedColumnName = "code")
    private DepartmentLevel departmentLevel;


    @OneToOne
    @JoinColumn(name = "parent_department_code", referencedColumnName = "code")
    @JsonIgnore
    private Department parentDepartment;
//    private String parentDepartmentCode;
}
