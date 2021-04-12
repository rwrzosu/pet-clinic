package com.mesh.petclinic.services.map;

import com.mesh.petclinic.model.BaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMapServiceTest {

    GenericMapService<BaseEntity, Long> ms;
    Long id = 1234L;

    @BeforeEach
    void setUp() {
        ms = new GenericMapService<>();
    }

    @Test
    void findById() {
        ms.save(new BaseEntity(id));
        BaseEntity be = ms.findById(id);

        assertNotNull(be);
        assertEquals(id, be.getId());
    }

    @Test
    void findAll() {
        ms.save(new BaseEntity(id));
        ms.save(new BaseEntity(id + 1));
        ms.save(new BaseEntity(id + 2));

        Set<BaseEntity> all = ms.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void findAll_checkEquals() {
        BaseEntity be = new BaseEntity(id);
        BaseEntity bePlusOne = new BaseEntity(id);
        ms.save(be);
        ms.save(bePlusOne);

        Set<BaseEntity> all = ms.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void save_normalSave() {
        BaseEntity saved = ms.save(new BaseEntity(id));
        assertNotNull(saved, "ref can not be null");
        assertEquals(id, saved.getId(), "not equal id");
    }

    @Test
    void save_throwingException() {
        Exception exception = assertThrows(RuntimeException.class, () -> ms.save(null));

        String expectedMsg = "Saved object can not be null.";
        assertEquals(expectedMsg, exception.getMessage());
    }

    @Test
    void delete() {
        ms.save(new BaseEntity(id));
        ms.delete(ms.findById(id));
        assertEquals(0L, ms.findAll().size());
    }

    @Test
    void deleteById() {
        ms.save(new BaseEntity(id));
        ms.deleteById(id);
        assertEquals(0L, ms.findAll().size());
    }
}