package aero.flightreview.web.controller;

import aero.flightreview.database.model.document.SchoolDoc;
import aero.flightreview.database.model.servicemodel.SchoolServiceModel;
import aero.flightreview.database.service.SchoolService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;
    private final ModelMapper modelMapper;

    public SchoolController(SchoolService schoolService, ModelMapper modelMapper) {
        this.schoolService = schoolService;
        this.modelMapper = modelMapper;
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/api/v1/get/schools")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<SchoolDoc>> getAllSchools() {
        return schoolService.getAll();
    }

    @PostMapping("/api/v1/create/school")
    public void createSchool(@RequestBody SchoolServiceModel doc) {
        schoolService.save(modelMapper.map(doc, SchoolDoc.class));
    }


}
