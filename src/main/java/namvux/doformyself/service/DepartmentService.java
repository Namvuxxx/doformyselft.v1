package namvux.doformyself.service;

import lombok.AllArgsConstructor;
import namvux.doformyself.common.GenericSpecificationBuilder;
import namvux.doformyself.model.Department;
import namvux.doformyself.model.dto.DepartmentDTO;
import namvux.doformyself.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository repository;

    public List<Department> findAll(String condition){
        GenericSpecificationBuilder<Department> builder = new GenericSpecificationBuilder<>(condition);
        return repository.findAll(builder.build());
    }
}
