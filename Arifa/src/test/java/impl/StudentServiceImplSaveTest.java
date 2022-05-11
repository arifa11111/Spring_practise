package impl;

import com.Assignment.demo.entity.Student;
import com.Assignment.demo.repository.StudentRepository;
import com.Assignment.demo.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceImplSaveTest {

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StudentServiceImpl studentService;


    @Test
    void saveStudent() {
        Student student = new Student("shiny","star","email@");
        studentService.saveStudent(student);
        verify(studentRepository).save(student);
    }

    @Test
    void updateStudent(){
        Student student = new Student("Up","date","email@");
        studentService.updateStudent(student);
        verify(studentRepository).save(student);

    }

    @Test
    void deleteStudentById(){
        studentService.deleteStudentById(10L);
        verify(studentRepository).deleteById(10L);
    }

    @Test
    void getStudentById(){
        Student student = new Student("getStudent","byid","email@");
        when(studentRepository.findById(10L)).thenReturn(Optional.of(student));

        assertEquals(student,studentService.getStudentById(10L));

    }

    @Test
    void getAllStudents(){
        when(studentRepository.findAll())
                .thenReturn(Stream.of(new Student("getAll", "stds","Arfa@"), new Student("Jeevana", "meedhuri","rt@er")).collect(Collectors.toList()));

        assertEquals(2, studentService.getAllStudents().size());
    }

}