package com.docencia.repo;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@ContextConfiguration
@ActiveProfiles("test")
@Transactional
public class NoteJpaRepositoryTest {

    @Autowired
    private INoteRepository noteRepository;

    @Test
    void buscarNotaTest(){
        Assert.assertNotNull(noteRepository);
    }

}
