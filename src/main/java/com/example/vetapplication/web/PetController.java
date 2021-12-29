package com.example.vetapplication.web;

import com.example.vetapplication.model.Pet;
import com.example.vetapplication.model.PetOwner;
import com.example.vetapplication.service.PetOwnerService;
import com.example.vetapplication.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;
    @Autowired
    PetOwnerService petOwnerService;

    @GetMapping("/pets")
    public String viewPet(Model model){
        return findPaginated(1,"name", "asc", model);
    }

    @RequestMapping("/search-pet")
    public String searchPet(Model model, @Param("keyword") String keyword){
        List<Pet> listPets = petService.getAllPets(keyword);
        model.addAttribute("listPets", listPets);
        model.addAttribute("keyword", keyword);

        return"search-pet";
    }

    @GetMapping("/new-pet-form")
    public String newPetForm(Model model){
        List<PetOwner> owners = petOwnerService.getAllPetOwners();
        model.addAttribute("owners", owners);
        Pet pet = new Pet();
        model.addAttribute("pet",pet);
        return "new-pet";
    }
    @PostMapping("/save-pet")
    public String savePet(@ModelAttribute("pet") Pet pet){
        petService.savePet(pet);
        return "redirect:/pets";
    }

    @GetMapping("/update-pet-form/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Long id, Model model) {

        List<PetOwner> owners = petOwnerService.getAllPetOwners();
        model.addAttribute("owners", owners);

        Pet pet = petService.getPetById(id);

        model.addAttribute("pet", pet);
        return "update-pet";
    }

    @GetMapping("/delete-pet/{id}")
    public String deletePet(@PathVariable (value = "id") Long id) {

        this.petService.deletePetById(id);
        return "redirect:/pets";
    }


    @GetMapping("/pagePet/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 6;

        Page<Pet> page = petService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<Pet> listPets = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listPets", listPets);
        return "pet";
    }


}
