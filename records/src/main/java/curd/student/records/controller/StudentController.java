package curd.student.records.controller;

import curd.student.records.entity.Student;
import curd.student.records.exception.ResourceNotFoundException;
import curd.student.records.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student creatStudent(@RequestBody Student student) {

        return studentRepository.save(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Student student = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
        return ResponseEntity.ok(student);

    }
    @PutMapping("{id}")
    public ResponseEntity<Student> updateEmployeeById(@PathVariable long id,@RequestBody Student employee){
        Student updateemployee = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        updateemployee.setFirstName(employee.getFirstName());
        updateemployee.setLastName(employee.getLastName());
        updateemployee.setDob(employee.getDob());
        updateemployee.setSrn(employee.getSrn());
        studentRepository.save(updateemployee);
        return ResponseEntity.ok(updateemployee);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteemployeeById(@PathVariable long id){
        Student  employee = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found"));
        studentRepository.delete(employee);
        return ResponseEntity.noContent().build();
    }
}

