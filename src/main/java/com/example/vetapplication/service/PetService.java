package com.example.vetapplication.service;

import com.example.vetapplication.model.Pet;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PetService {
    List<Pet> getAllPets(String keyword);
    List<Pet> getPetsByName(String name);
    void savePet(Pet pet);
    Pet getPetById(Long id);
    void deletePetById(Long id);
    Page<Pet> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
