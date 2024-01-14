package com.example.demo.repos;

import com.example.demo.models.Serial;
import com.example.demo.models.Genres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SerialRepository extends CrudRepository<Serial, Long>, JpaRepository<Serial, Long> {
    List<Serial> findSerialsByTitle(String title);

    List<Serial> findByGenres(Genres genres);

    Serial findByTitle(String title);

    Serial findByTitleOrderByCommentsDesc(String title);

}