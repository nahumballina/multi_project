package com.manning.gia.todo.repository;

import com.manning.gia.todo.model.ToDoItem;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InMemoryToDoRepositoryTest {
    private ToDoRepository inMemoryToDoRepository;
	private int elementos=0;
    @Before
    public void setUp() {
        inMemoryToDoRepository = new InMemoryToDoRepository();
		elementos = Integer.parseInt(System.getProperty("items"));
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
        ToDoItem newToDoItem;
		Long newId;
		for (int i=0;i<elementos;i++){
			newToDoItem= new ToDoItem();
			newToDoItem.setName("Write unit"+elementos);
			newId = inMemoryToDoRepository.insert(newToDoItem);
			assertNotNull(newId);
		}
		
        assertEquals(inMemoryToDoRepository.findAll().size(), elementos);
    }
	
}
