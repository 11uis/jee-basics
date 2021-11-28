/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package academy.learnprogramming.entity;

import java.time.LocalDate;
import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lluis.carrasco.martinez-cic@ibm.com
 */

/*
* Add the Javax Annotation API annotation to turn the class into an entity
* We will be using the package javax.persistence.*
*/
@Entity
public class Todo {
    
    /*
    * Local Variables
    */
    // ID for the DB, primary key
    @Id
    // The value of the id will be automatically generated
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotEmpty(message = "The task must be set.") // Add validation to the task
    @Size(min = 10, message = "A task should not be less than 10 characters.")
    private String task;
    
    @NotNull(message = "The due date must be set.")
    // Validation to the date, so it does not lay in the past
    @FutureOrPresent(message = "The due date must be in the present or the future.")
    // Set a specific date format
    @JsonbDateFormat("dd-MM-yyyy")
    private LocalDate dueDate;
    
    private boolean isCompleted;
    private LocalDate dateCompleted;
    private LocalDate dateCreated;

    /*
    * Class methods
    */
    @PrePersist // Save on creation before the Persistence Unit is called
    private void init(){
        // Set the creation date
        setDateCreated(LocalDate.now());
    }
    
    
    

    /*
     * Getters and Setters
     */
    public Long getId() {    
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    
    
}
