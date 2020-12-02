//package com.ayoola.hospital.controller;
//
//import com.ayoola.hospital.model.Patient;
//import com.ayoola.hospital.repository.PatientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class JsonController {
//    @Autowired
//    private PatientRepository patientRepository;
//
////    @RequestMapping(value = "/patients/list", method = RequestMethod.GET)
////    public String patients(Model model){
////        model.addAttribute("patients", patientRepository.findAll());
////
////        return "patient/list";
////    }
//
//    //Create
//    @CrossOrigin(exposedHeaders = "http://localhost:8888")
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
//    public String create(@RequestParam String lastName,@RequestParam String firstName,@RequestParam String nextOfKin,@RequestParam String phoneNumber, @RequestParam char gender){
//
//        Patient patient = new Patient(lastName, firstName, nextOfKin, phoneNumber, gender);
//
//        patientRepository.save(patient);
//
//        return "Successfully Created";
//    }
//
//    //Read
//    @CrossOrigin(exposedHeaders = "http://localhost:8888")
//    @RequestMapping(value="/test/{id}", method = RequestMethod.GET)
//    public Patient getPatientById(@PathVariable long id, Model model)
//    {
//        Patient patient = patientRepository.findById(id).get();
//        return patient;
//    }
//
//    //List
//    @CrossOrigin(exposedHeaders = "http://localhost:8888")
//    @RequestMapping(path="/tests", method = RequestMethod.GET)
//    public List getPatient()
//    {
//        return (List)patientRepository.findAll();
//    }
//
//    //Update
//    @CrossOrigin(exposedHeaders = "http://localhost:8888")
//    @RequestMapping(path = "/test/update", method = RequestMethod.PUT)
//    public String update(@RequestParam long id, @RequestParam String lastName/*,@RequestParam String firstName,@RequestParam String nextOfKin,@RequestParam String phoneNumber, @RequestParam char gender*/)
//    {
//        Patient patient = patientRepository.findById(id).get();
//        patient.setLastName(lastName);
////        patient.setFirstName(firstName);
////        patient.setNextOfKin(nextOfKin);
////        patient.setPhoneNumber(phoneNumber);
////        patient.setGender(gender);
//
//        patientRepository.save(patient);
//
//        return "Successfully Updated";
//
//    }
//
//    //Delete
//    @CrossOrigin(exposedHeaders = "http://localhost:8888")
//    @RequestMapping(path = "/test/delete/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable long id)
//    {
//        Patient patient = patientRepository.findById(id).get();
//
//        patientRepository.delete(patient);
//
//        return "File Successfully Deleted";
//    }
//
//}
