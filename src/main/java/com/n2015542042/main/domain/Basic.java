package com.n2015542042.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

@Table
@Entity
public class Basic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Column
    private String phone;

    @Builder
    public Basic(String name, String label, String email, String phone) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
    }

    public void Update(Basic basic) {
        this.name = basic.getName();
        this.label = basic.getLabel();
        this.email = basic.getEmail();
        this.phone = basic.getPhone();
    }
}
