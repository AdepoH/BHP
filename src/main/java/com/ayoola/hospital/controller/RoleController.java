package com.ayoola.hospital.controller;

import com.ayoola.hospital.model.Role;
import com.ayoola.hospital.repository.RoleRepository;
import com.ayoola.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/roles/list", method = RequestMethod.GET)
    public String roles(Model model){
        model.addAttribute("roles", roleRepository.findAll());
        return "role/list";
    }

    @GetMapping("/roles/create")
    public String create(Model model){
        return "role/create";
    }

    @RequestMapping(value = "/roles/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam String name) {

        Role role = new Role(name);
        roleRepository.save(role);
        //model.addAttribute("roles", roleRepository.findAll());
        return "redirect:/roles/list";
    }

    @RequestMapping(value = "/roles/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") int id, Model model) {

        model.addAttribute("role", roleRepository.findById(id).get());
        return "role/edit";
    }



    @RequestMapping(value = "/roles/update", method = RequestMethod.POST)
    public String updateRole(Model model, @RequestParam int id, @RequestParam String name) {

        Role role= roleRepository.findById(id).get();
        role.setName(name);

        roleRepository.save(role);

        return "redirect:/roles/list";
    }

    @RequestMapping(value = "/roles/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") int id, Model model) {

        Role role = roleRepository.findById(id).get();

        roleRepository.delete(role);
        return "redirect:/roles/list";
    }

}