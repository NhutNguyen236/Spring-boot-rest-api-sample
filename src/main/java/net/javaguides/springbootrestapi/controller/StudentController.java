package net.javaguides.springbootrestapi.controller;

import net.javaguides.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// turn the url into something like this students/... where students is the base for the url
@RequestMapping("students")
public class StudentController {
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Nhut", "Nguyen");
        //return new ResponseEntity<>(student, HttpStatus.CREATED);
        return ResponseEntity.ok()
                .header("custom-header", "hello there")
                .body(student);
    }

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
        // make a new students array list type
        List<Student> students = new ArrayList<>();
        students.add(new Student(2, "harry", "potter"));
        students.add(new Student(3, "ron", "potter"));
        students.add(new Student(4, "hermione", "potter"));
        return ResponseEntity.ok(students);
    }

    // Spring boot rest api with path variable
    // {id} - URI template variable
    // for example we go for http://localhost:8080/students/1
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentVariable(@PathVariable("id") int studentId,
                                   @PathVariable("first-name") String firstName,
                                   @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

    @GetMapping("students/query")
    public Student StudentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName){
        return new Student(id, firstName, lastName);
    }

    // PostMapping for Post request
    @PostMapping("student/create")
    // define a custom response Status
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // UPDATE student info route
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // DELETE student info route
    @DeleteMapping("student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        return "student deleted successfully!";
    }
}