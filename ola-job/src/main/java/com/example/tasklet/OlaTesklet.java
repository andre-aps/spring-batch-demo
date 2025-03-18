package com.example.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

@Component
public class OlaTesklet implements Tasklet {

    @Override
    public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) {
        System.out.printf("Olá, mundo! %n");
        return RepeatStatus.FINISHED;
    }

}
