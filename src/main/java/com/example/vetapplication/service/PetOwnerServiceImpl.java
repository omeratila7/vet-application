package com.example.vetapplication.service;

import com.example.vetapplication.model.PetOwner;
import com.example.vetapplication.repository.PetOwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {

    @Autowired
    private PetOwnerRepository petOwnerRepository;


    @Override
    public List<PetOwner> getAllPetOwners() {
        return petOwnerRepository.findAll();
    }

    @Override
    public void savePetOwner(PetOwner petOwner) {
        petOwnerRepository.save(petOwner);
    }

    @Override
    public PetOwner getPetOwnersById(Long id){
        Optional<PetOwner> optional = petOwnerRepository.findById(id);
        PetOwner petOwner = null;
        if (optional.isPresent()) {
            petOwner = optional.get();
        } else {
            throw new RuntimeException(" Pet owner not found for id :: " + id);
        }
        return petOwner;

    }

    @Override
    public void deletePetOwnersById(Long id) {
        petOwnerRepository.deleteById(id);
    }


}
