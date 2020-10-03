package com.ayoola.hospital.controller;

import com.ayoola.hospital.model.Patient;
import com.ayoola.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value = "/patients/list", method = RequestMethod.GET)
    public String patients(Model model){
        model.addAttribute("patients", patientRepository.findAll());

        return "patient/list";
    }

    @RequestMapping(value = "/patients/create", method = RequestMethod.GET)
    public String create(Model model) {
        return "patient/create";
    }

    @RequestMapping(value = "/patients/add", method = RequestMethod.POST)
    public String add(Model model, @RequestParam String lastName,@RequestParam String firstName,@RequestParam String dob,@RequestParam String nextOfKin,@RequestParam String phoneNumber,
                      @RequestParam char gender,@RequestParam int age,@RequestParam String bloodGroup,@RequestParam String department,@RequestParam String doctorsName,@RequestParam String complains,
                      @RequestParam String appointmentDate,@RequestParam String createdBy,@RequestParam String createdDate,@RequestParam String modifiedBy,@RequestParam String modifiedDate) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(dob);
        java.sql.Date dateOfBirth = new java.sql.Date(utilDate.getTime());

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(appointmentDate);
        java.sql.Date appointment_Date = new java.sql.Date(utilDate.getTime());

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(createdDate);
        java.sql.Date created_Date = new java.sql.Date(utilDate.getTime());

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(modifiedDate);
        java.sql.Date modified_Date = new java.sql.Date(utilDate.getTime());

        Patient patient = new Patient(lastName, firstName, dateOfBirth, nextOfKin, phoneNumber, gender, age, bloodGroup, department, doctorsName, complains, appointment_Date, createdBy, created_Date, modifiedBy, modified_Date);
        patientRepository.save(patient);
        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/patients/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        model.addAttribute("patient", patientRepository.findById(id).get());
        return "patient/edit";
    }

    @RequestMapping(value = "/patients/update", method = RequestMethod.POST)
    public String updatePatient(Model model,@RequestParam long id, @RequestParam String lastName,@RequestParam String firstName,@RequestParam String dob,@RequestParam String nextOfKin,@RequestParam String phoneNumber,
                                @RequestParam char gender,@RequestParam int age,@RequestParam String bloodGroup,@RequestParam String department,@RequestParam String doctorsName,@RequestParam String complains,
                                @RequestParam String appointmentDate,@RequestParam String createdBy,@RequestParam String createdDate,@RequestParam String modifiedBy,@RequestParam String modifiedDate) throws ParseException {

        Patient patient= patientRepository.findById(id).get();

        patient.setLastName(lastName);
        patient.setFirstName(firstName);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(dob);
        java.sql.Date dateOfBirth = new java.sql.Date(utilDate.getTime());
        patient.setDob(dateOfBirth);

        patient.setNextOfKin(nextOfKin);
        patient.setPhoneNumber(phoneNumber);

        patient.setGender(gender);
        patient.setAge(age);
        patient.setBloodGroup(bloodGroup);
        patient.setDepartment(department);
        patient.setDoctorsName(doctorsName);
        patient.setComplains(complains);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(appointmentDate);
        java.sql.Date appointment_Date = new java.sql.Date(utilDate.getTime());
        patient.setAppointmentDate(appointment_Date);

        patient.setCreatedBy(createdBy);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(createdDate);
        java.sql.Date created_Date = new java.sql.Date(utilDate.getTime());
        patient.setCreatedDate(created_Date);
        patient.setModifiedBy(modifiedBy);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(modifiedDate);
        java.sql.Date modified_Date = new java.sql.Date(utilDate.getTime());
        patient.setModifiedDate(modified_Date);
        patientRepository.save(patient);

        return "redirect:/patients/list";
    }

    @RequestMapping(value = "/patients/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {

        Patient patient = patientRepository.findById(id).get();

        patientRepository.delete(patient);
        return "redirect:/patients/list";
    }

}
