/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.service;

import academy.learnprogramming.entity.Todo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author lluis.carrasco.martinez-cic@ibm.com
 */

// Automate the transactions
@Transactional // Turn the class into a service for the CRUD operations
public class TodoService {
    
    // Inject the Persistence
    @PersistenceContext
    EntityManager entityManager;
    
    
    /*
    * Create an Entities
    */
    public Todo createTodo(Todo todo){
        // Persist into DB
        entityManager.persist(todo);
        return todo;
    }
    
    /*
    * Update a todo
    */
    public Todo updateTodo(Todo todo){
        entityManager.merge(todo);
        return todo;
    }
    
    /*
    * Find a todo given the ID
    */
    public Todo findTdodoById(Long id){
        return entityManager.find(Todo.class, id);
    }
    
    
    public List<Todo> getTodos(){
        return entityManager
                .createQuery("SELECT t FROM Todo t", Todo.class).getResultList();
    }
    
}
