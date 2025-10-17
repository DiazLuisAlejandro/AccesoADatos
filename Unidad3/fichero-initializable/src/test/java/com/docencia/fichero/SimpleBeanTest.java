package com.docencia.fichero;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.docencia.fichero.fichero_Serializable.serializacion.SimpleBean;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class SimpleBeanTest {

    @Test
    void SimpleBeanTest() {
        XmlMapper xmlMapper = new XmlMapper();
        String xml;
        try {
            SimpleBean value = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
            assertTrue(value.getX() == 1 && value.getY() == 2);
        } catch (Exception e) {
            Assertions.fail("Se ha producido un error controlado", e);
        }
    }
}
