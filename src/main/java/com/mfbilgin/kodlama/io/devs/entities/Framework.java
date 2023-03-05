package com.mfbilgin.kodlama.io.devs.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "frameworks")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Framework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="language_id",nullable = false)
    private ProgramingLanguage language;
}
