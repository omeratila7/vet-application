package com.example.vetapplication.repository;

import com.example.vetapplication.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet,Long> {

    @Query("SELECT p FROM Pet p WHERE UPPER(p.name) LIKE %?1% OR UPPER(p.owner.name) LIKE %?1%")
    List<Pet> search(String keyword);

    List<Pet> findByName(String name);

}
