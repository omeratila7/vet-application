package com.example.vetapplication.service;

import com.example.vetapplication.model.Pet;
import com.example.vetapplication.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> getAllPets(String keyword) {
        if (keyword != null) {
            return petRepository.search(keyword.toUpperCase());
        }
        return petRepository.findAll();
    }

    @Override
    public List<Pet> getPetsByName(String name) {
        return petRepository.findByName(name);
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public Pet getPetById(Long id) {
        Optional<Pet> optional = petRepository.findById(id);
        Pet pet = null;
        if (optional.isPresent()) {
            pet = optional.get();
        } else {
            throw new RuntimeException(" Pet not found for id :: " + id);
        }
        return pet;
    }

    @Override
    public void deletePetById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public Page<Pet> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.petRepository.findAll(pageable);
    }
}
