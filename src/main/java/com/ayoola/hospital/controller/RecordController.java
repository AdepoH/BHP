package com.ayoola.hospital.controller;

import com.ayoola.hospital.model.Patient;
import com.ayoola.hospital.model.Record;
import com.ayoola.hospital.repository.PatientRepository;
import com.ayoola.hospital.repository.RecordRepository;
import com.ayoola.hospital.repository.RoleRepository;
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
public class RecordController {
    @Autowired
    private RecordRepository recordRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/records/list", method = RequestMethod.GET)
    public String records(Model model){
        model.addAttribute("records", recordRepository.findAll());
        return "record/list";
    }

    @RequestMapping(value = "/records/create/{id}", method = RequestMethod.GET)
    public String create(@PathVariable("id") long id,  Model model) {

        model.addAttribute("patient", patientRepository.findById(id).get());

        return "record/create";

    }

    @RequestMapping(value = "records/add", method = RequestMethod.POST)
    public String add(Model model,@RequestParam long id, @RequestParam String lastName,@RequestParam String firstName, @RequestParam String dob,@RequestParam char gender,@RequestParam int age,
                      @RequestParam String bloodGroup,@RequestParam String nextOfKin ,@RequestParam String phoneNumber ,@RequestParam String address,@RequestParam String city,
                      @RequestParam String country,@RequestParam String maritalStatus,@RequestParam String appointmentDate,@RequestParam String createdBy,@RequestParam String createdDate, @RequestParam String modifiedBy, @RequestParam String modifiedDate) throws ParseException {

        Patient patient = patientRepository.findById(id).get();

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


        Record record;
        record = new Record(lastName, firstName, patient, dateOfBirth, gender, age,
                bloodGroup, nextOfKin, phoneNumber, address, city,
                country, maritalStatus, appointment_Date, createdBy, created_Date, modifiedBy, modified_Date);
        recordRepository.save(record);
        return "redirect:/records/list";
    }

    @RequestMapping(value = "/records/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model){

        model.addAttribute("record", recordRepository.findById(id).get());
        return "record/edit";
    }

    @RequestMapping(value = "/records/update", method = RequestMethod.POST)
    public String updateRecords(Model model, @RequestParam long id, @RequestParam String lastName,@RequestParam String firstName, @RequestParam String dob,@RequestParam char gender,@RequestParam int age,@RequestParam String bloodGroup,
                                @RequestParam String nextOfKin ,@RequestParam String phoneNumber ,@RequestParam String address,@RequestParam String city, @RequestParam String country,@RequestParam String maritalStatus, @RequestParam String appointmentDate,
                                @RequestParam String createdBy,@RequestParam String createdDate,@RequestParam String modifiedBy,@RequestParam String modifiedDate) throws ParseException {

        Record record = recordRepository.findById(id).get();

        record.setLastName(lastName);
        record.setFirstName(firstName);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = formatter.parse(dob);
        java.sql.Date dateOfBirth = new java.sql.Date(utilDate.getTime());
        record.setDob(dateOfBirth);

        record.setGender(gender);
        record.setAge(age);
        record.setBloodGroup(bloodGroup);
        record.setNextOfKin(nextOfKin);
        record.setPhoneNumber(phoneNumber);
        record.setAddress(address);
        record.setCity(city);
        record.setCountry(country);
        record.setMaritalStatus(maritalStatus);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(appointmentDate);
        java.sql.Date appointment_Date = new java.sql.Date(utilDate.getTime());
        record.setAppointmentDate(appointment_Date);

        record.setCreatedBy(createdBy);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(createdDate);
        java.sql.Date created_Date = new java.sql.Date(utilDate.getTime());
        record.setCreatedDate(created_Date);

        record.setModifiedBy(modifiedBy);

        formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        utilDate = formatter.parse(modifiedDate);
        java.sql.Date modified_Date = new java.sql.Date(utilDate.getTime());
        record.setModifiedDate(modified_Date);

        recordRepository.save(record);

        return "redirect:/records/list";
    }

    @RequestMapping(value = "/records/delete/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") long id, Model model) {

        Record records = recordRepository.findById(id).get();

        recordRepository.delete(records);
        return "redirect:/records/list";
    }

}
