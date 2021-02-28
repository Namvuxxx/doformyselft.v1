package namvux.doformyself.controller;

import lombok.AllArgsConstructor;
import namvux.doformyself.model.Department;
import namvux.doformyself.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
@AllArgsConstructor
public class DepartmentController {
    public final DepartmentService service;
    @GetMapping("/getall/{condition}")
    public ResponseEntity<List<Department>> getAll(@PathVariable String condition){
        return ResponseEntity.ok(service.findAll(condition));
    }
}
