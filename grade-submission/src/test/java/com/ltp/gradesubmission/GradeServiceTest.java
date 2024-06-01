package com.ltp.gradesubmission;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ltp.gradesubmission.repository.GradeRepository;
import com.ltp.gradesubmission.service.GradeService;

@RunWith(MockitoJUnitRunner.class)
public class GradeServiceTest {

    @Mock
    private GradeRepository gradeRepository;
    
    @InjectMocks
    private GradeService gradeService;

    @Test
    public void getGraidesFromRepoTest(){
        when(gradeRepository.getGrades()).thenReturn(Arrays.asList(
            new Grades("Hermione", "Potions", "A+"),
            new Grades("Harry", "Charms", "C-")
        ));

        List<Grades> result = gradeService.getGrades();

        assertEquals("Hermione", result.get(0).getName());
        assertEquals("Potions", result.get(1).getSubject());
    }
    
}
