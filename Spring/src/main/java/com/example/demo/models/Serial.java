package com.example.demo.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Serial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "please fill the name serial")
    @Length(max = 255, message = "please fill the name serial")
    private String title;

    @NotBlank(message = "please fill the description serial")
    @Length(max = 4096, message = "please fill the description serial")
    private String description;

    @ElementCollection(targetClass = Genres.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "genre_name", joinColumns = @JoinColumn(name = "genre_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genres> genres;

    private String filename;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany
    @ToString.Exclude
    private Set<Rating> rating;

    @OneToMany
    @ToString.Exclude
    private Set<Comment> comments;

    private Integer view = 0;

    public String getAlias() {
        return "/poster/" + getTitle();
    }
}
