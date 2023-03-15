package com.mfbilgin.kodlama.io.devs.entities;

import javax.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "programing_languages")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProgramingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "language")
    private List<Framework> frameworks;
}
