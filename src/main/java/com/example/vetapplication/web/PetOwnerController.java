package com.example.vetapplication.web;

import com.example.vetapplication.model.PetOwner;
import com.example.vetapplication.service.PetOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PetOwnerController {

    @Autowired
    private PetOwnerService petOwnerService;
    // for listing pet owners
    @GetMapping("/pet-owners")
    public String viewPetOwners(Model model){
        return findPaginated(1,"name", "asc", model);
    }

    @GetMapping("/new-owner-form")
    public String newOwnerForm(Model model){

        PetOwner owner = new PetOwner();
        model.addAttribute("owner",owner);
        return "new-owner";
    }
    @PostMapping("/save-owner")
    public String saveOwner(@ModelAttribute("owner") PetOwner owner){
        petOwnerService.savePetOwner(owner);
        return "redirect:/pet-owners";
    }

    @GetMapping("/update-owner-form/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Long id, Model model) {

        PetOwner owner = petOwnerService.getPetOwnersById(id);

        model.addAttribute("owner", owner);
        return "update-owner";
    }

    @GetMapping("/delete-owner/{id}")
    public String deleteOwner(@PathVariable (value = "id") Long id) {

        this.petOwnerService.deletePetOwnersById(id);
        return "redirect:/pet-owners";
    }


    @GetMapping("/pageOwner/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 6;

        Page<PetOwner> page = petOwnerService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<PetOwner> listOwners = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listOwners", listOwners);
        return "pet-owner";
    }


}
