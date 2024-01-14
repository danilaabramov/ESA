package com.example.demo.models;

import lombok.*;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    private Integer value = 0;

    public Rating(User user, int value) {
        this.user = user;
        this.value = value;
    }
}
