package com.fujitsu.primesoft.condition;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.demo.entity.RaceCourseIndexEntity;
import com.fujitsu.primesoft.PsoftIllegalArgumentException;

public class PsoftGENTests {
    @Test
    void throwPsoftIllegalArgumentException() {
        PsoftIllegalArgumentException exception = assertThrows(PsoftIllegalArgumentException.class, () -> {
            new PsoftGEN<RaceCourseIndexEntity>(new RaceCourseIndexEntity("1"), 0);
        });
        assertEquals(exception.getMessage(), null);
    }

    @Test
    void getConditionKind() {
        RaceCourseIndexEntity keyValue = new RaceCourseIndexEntity("1");
        PsoftGEN<RaceCourseIndexEntity> condition = new PsoftGEN<RaceCourseIndexEntity>(keyValue, 1);
        assertEquals(condition.getConditionKind(), PsoftConditionKind.GEN); 
    }
}
