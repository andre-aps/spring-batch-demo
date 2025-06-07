package com.example.step.reader;

import org.junit.jupiter.api.Test;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ParOuImparReaderTest {

    @Autowired
    private ItemReader<Integer> parOuImparItemReader;

    @Test
    void testParOuImparItemReader() throws Exception {
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer expectedNumber : expectedNumbers) {
            assertThat(parOuImparItemReader.read()).isEqualTo(expectedNumber);
        }
        assertThat(parOuImparItemReader.read()).isNull();
    }

}
