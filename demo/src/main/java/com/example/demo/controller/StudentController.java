package com.example.demo.controller;

import com.example.demo.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

//    @GetMapping("student")
//    public ResponseEntity<Student> getStudent(){
//        Student s1 = new Student(101,"Sachin","Arora");
//        return new ResponseEntity<>(s1, HttpStatus.OK);
//    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        return ResponseEntity.ok().header("name", "sachin").body(list);

    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for(Student stud : list){
            if(stud.getId() == id){
                return new ResponseEntity(stud, HttpStatus.OK);
            }
        }

        return null;
    }


    @GetMapping("query")
    public ResponseEntity<Student> getStudentWithId(@RequestParam("id") int id){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        for(Student stud : list){
            if(stud.getId() == id){
                return new ResponseEntity<>(stud, HttpStatus.OK);
            }
        }

        return null;
    }


    @PostMapping("create")
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<Student>> createStudent(@RequestBody Student stud){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(stud);

        return new ResponseEntity<>(list, HttpStatus.CREATED);
    }


    @PutMapping("{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student stud, @PathVariable("id") int id){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);


        for(Student student : list){
            if(student.getId() == id){
//                student.setId(student.getId());
                student.setFname(stud.getFname());
                student.setLname(stud.getLname());

                return new ResponseEntity<>(student, HttpStatus.OK);
            }

        }

        return null;


    }



    @DeleteMapping("{id}/delete")
    public ResponseEntity<List<Student>> updateStudent(@PathVariable("id") int id){
        Student s1 = new Student(101,"Sachin","Arora");
        Student s2 = new Student(102,"Manish","Kumar");
        Student s3 = new Student(103,"Karan","Jain");
        Student s4 = new Student(104,"Ravi","Kumar");

        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);


        for(Student student : list){
            if(student.getId() == id){
                list.remove(student);
                return new ResponseEntity<>(list, HttpStatus.OK);
            }

        }

        return null;


    }
}
