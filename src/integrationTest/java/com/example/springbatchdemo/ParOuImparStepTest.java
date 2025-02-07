package com.example.springbatchdemo;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@SpringBatchTest
@ActiveProfiles("integration-test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ParOuImparStepTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    @Qualifier("parOuImparJob")
    private Job parOuImparJob;

    @Test
    void testParOuImparStep() {
        jobLauncherTestUtils.setJob(parOuImparJob);
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("parOuImparStep");

        StepExecution stepExecution = jobExecution.getStepExecutions().iterator().next();

        assertThat(stepExecution.getReadCount()).isEqualTo(10L);
        assertThat(stepExecution.getWriteCount()).isEqualTo(10L);
        assertThat(jobExecution.getExitStatus().getExitCode()).isEqualTo("COMPLETED");
    }

}
