package com.example.vetapplication.service;

import com.example.vetapplication.model.PetOwner;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PetOwnerService {
    List<PetOwner> getAllPetOwners();
    void savePetOwner(PetOwner petOwner);
    PetOwner getPetOwnersById(Long id);
    void deletePetOwnersById(Long id);

    Page<PetOwner> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);

}
