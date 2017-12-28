package com.manning.gia.todo.repository;

import com.manning.gia.todo.model.ToDoItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InMemoryToDoRepositoryTest {
    private ToDoRepository inMemoryToDoRepository;

    @Before
    public void setUp() {
        inMemoryToDoRepository = new InMemoryToDoRepository();
    }

    @Test
    public void testInsertToDoItem() {
        ToDoItem newToDoItem = new ToDoItem();
        newToDoItem.setName("Write unit tests");
        Long newId = inMemoryToDoRepository.insert(newToDoItem);
        assertNotNull(newId);

        ToDoItem persistedToDoItem = inMemoryToDoRepository.findById(newId);
        assertNotNull(persistedToDoItem);
        assertEquals(newToDoItem, persistedToDoItem);
    }
	
	@Test
    public void testAddToDoItem() {
        ToDoItem newToDoItem = new ToDoItem();
        newToDoItem.setName("Write unit tests1");
        Long newId = inMemoryToDoRepository.insert(newToDoItem);
        assertNotNull(newId);
		
		newToDoItem = new ToDoItem();
        newToDoItem.setName("Write unit tests2");
        newId = inMemoryToDoRepository.insert(newToDoItem);
        assertNotNull(newId);

        assertEquals(inMemoryToDoRepository.findAll().size(), 2);
    }
	
}
