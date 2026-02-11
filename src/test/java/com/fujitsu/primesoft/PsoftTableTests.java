package com.fujitsu.primesoft;

import org.junit.jupiter.api.Test;

import com.example.demo.entity.RaceCourseEntity;
import com.example.demo.entity.RaceCourseIndexEntity;
import com.fujitsu.primesoft.PsoftNonePartition;
import com.fujitsu.primesoft.PsoftTable.PsoftWaitMode;
import com.fujitsu.primesoft.condition.PsoftKEQ;

public class PsoftTableTests {
    @Test
    void select() {
        RaceCourseIndexEntity keyValue = new RaceCourseIndexEntity("3");
        PsoftKEQ<RaceCourseIndexEntity> condition = new PsoftKEQ<RaceCourseIndexEntity>(keyValue);
        try (PsoftTable<RaceCourseEntity, RaceCourseIndexEntity, PsoftNonePartition> table = new PsoftTable<RaceCourseEntity, RaceCourseIndexEntity, PsoftNonePartition>()) {
            table.select(condition, null, PsoftWaitMode.WAIT);
        }
        catch (PsoftException e) {
            
        }

        

    }
}