package com.ahmad.delete.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deltedfiles")

public class DeletedFile {

    @Id
    @GeneratedValue
    private int id;
    private String name;

}
