package com.docencia.personas.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.docencia.personas.model.Direccion;
import com.docencia.personas.model.Persona;


@SpringBootTest
@ActiveProfiles
public class PersonaRepositoryTest {

    private PersonaRepository personaRepository;
    private Persona personaCollection;
    private Direccion direccion;
    private Persona personaFind;
    private String email="test@email.com";
    private Persona personaCollection2;
    private Direccion direccion2;


    @Autowired
    public void setPersonaRepository(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @BeforeEach
    void cleanDB() {
        personaRepository.deleteAll();
        direccion=new Direccion();
        direccion.setCalle("calle");
        direccion.setCiudad("Ciudad");
        direccion.setCodigoPostal("38300");
        direccion.setPais("Pais");
        direccion2=new Direccion("Calle", "Cita", "38200", "Pais");
        personaCollection = new Persona();
        personaCollection.setId("1");
        personaCollection.setDireccion(direccion);
        personaCollection.setEdad(18);
        personaCollection.setEmail(email);
        personaCollection.setNombre("Test");
        personaCollection2=new Persona("test2", 55, email, direccion2);
        personaFind = personaRepository.save(personaCollection);
    }

    @Test
    void testFind() {
        Assertions.assertEquals(1,personaRepository.count());
        Assertions.assertNotNull(personaFind);
        Assertions.assertNotNull(personaFind.getId());
    }

    @Test
    void testFindByCiudad() {
        List<Persona> personas=personaRepository.findByCiudad("Ciudad");
        Assertions.assertEquals(personas.get(personas.size()-1), personaFind);
    }

    @Test
    void testFindByEdadBetween() {
        List<Persona> personas=personaRepository.findByEdadBetween(16, 40);
        Assertions.assertEquals(personas.get(personas.size()-1).getEdad(), personaFind.getEdad());

    }

    @Test
    void testFindByEmail() {
        Optional<Persona> persona=personaRepository.findByEmail(email);
        Persona persona2= persona.stream().toList().get(0);
        Assertions.assertEquals(persona2, personaFind);
    }

    @Test
    void testFindByNombreContainingIgnoreCase() {
        List<Persona> personas=personaRepository.findByNombreContainingIgnoreCase("TEST");
        Assertions.assertEquals(personas.get(personas.size()-1).getNombre(), personaFind.getNombre());
    }

}
