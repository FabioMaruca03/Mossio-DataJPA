package com.example.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "business")
public class Business {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @OneToOne
    private Person owner;

    @OneToMany
    private List<Person> employees;
}
