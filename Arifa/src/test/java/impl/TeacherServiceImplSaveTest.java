package impl;


import com.Assignment.demo.entity.Teacher;
import com.Assignment.demo.repository.TeacherRepository;
import com.Assignment.demo.service.impl.TeacherServiceImpl;
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
class TeacherServiceImplSaveTest {

    @MockBean
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherServiceImpl teacherService;


    @Test
    void saveTeacher() {

        Teacher teacher = new Teacher("vyshnavi","madam","email@");
        teacherService.saveTeacher(teacher);
        verify(teacherRepository).save(teacher);
    }

    @Test
    void updateTeacher(){
        Teacher teacher = new Teacher("roopa","akesh","email@");
        teacherService.updateTeacher(teacher);
        verify(teacherRepository).save(teacher);

    }

    @Test
    void deleteTeacherById(){
        teacherService.deleteTeacherById(10L);
        verify(teacherRepository).deleteById(10L);
    }

    @Test
    void getTeacherById(){
        Teacher teacher = new Teacher("anju","madam","email@");
        when(teacherRepository.findById(10L)).thenReturn(Optional.of(teacher));

        assertEquals(teacher,teacherService.getTeacherById(10L));

    }

    @Test
    void getAllTeachers(){
        when(teacherRepository.findAll())
                .thenReturn(Stream.of(new Teacher("kantharao", "sir","kantha@"), new Teacher("madam", "surekha","rt@er")).collect(Collectors.toList()));

        assertEquals(2, teacherService.getAllTeachers().size());
    }

}