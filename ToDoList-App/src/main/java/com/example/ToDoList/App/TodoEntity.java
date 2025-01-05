package com.example.ToDoList.App;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TodoEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

//    @Getter
//    @Setter
    private String thingToBeSaved;

    public void setThingToBeSaved(String thingToBeSaved) {
        this.thingToBeSaved = thingToBeSaved;
    }

    public String getThingToBeSaved() {
        return thingToBeSaved;
    }
}
