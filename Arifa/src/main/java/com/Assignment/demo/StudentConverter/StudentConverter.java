package com.Assignment.demo.StudentConverter;

import com.Assignment.demo.dto.StudentDto;
import com.Assignment.demo.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentConverter {

    public StudentDto entityToDto(Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setFirstName(student.getFirstName());
        dto.setLastName(student.getLastName());
        dto.setEmail(student.getEmail());
    return dto;
    }

    public List<StudentDto> entityToDto(List<Student> student){

        return student.stream().map(x-> entityToDto(x)).collect(Collectors.toList());
    }

    public  Student dtoToEntity(StudentDto dto){
        Student student = new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());

        return student;
    }

    public  List<Student> dtoToEntity(List<StudentDto> dto){
        return dto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
    }

}
