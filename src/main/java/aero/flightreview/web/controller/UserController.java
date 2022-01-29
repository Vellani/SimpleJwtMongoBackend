package aero.flightreview.web.controller;

import aero.flightreview.database.model.document.UserDoc;
import aero.flightreview.database.model.servicemodel.UserServiceModel;
import aero.flightreview.database.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/api/v1/create/user")
    public UserDoc createUser(@RequestBody UserServiceModel serviceModel) {
        return userService.save( modelMapper.map(serviceModel, UserDoc.class));
    }




}
