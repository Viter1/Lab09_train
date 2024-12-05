package com.vitech.Lab09_train.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Order {

    @Id
    private long id;
    private boolean validated;
    private LocalDate creationDate;
    private LocalDate validationDate;


    public long getId() {
        return this.id;
    }

    public boolean isValidated() {
        return this.validated;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public LocalDate getValidationDate() {
        return this.validationDate;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setValidationDate(LocalDate validationDate) {
        this.validationDate = validationDate;
    }
}
