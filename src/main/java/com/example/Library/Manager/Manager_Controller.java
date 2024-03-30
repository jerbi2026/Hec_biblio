package com.example.Library.Manager;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Manager_Controller {
    private final Manager_service service;

    public Manager_Controller(Manager_service service) {
        this.service = service;
    }

    @PostMapping("/login_manager")
    public Front_Manager login(@RequestBody LoginRequest log_req )
    {

        return  service.login(log_req);
    }

    @PostMapping("/get_front_manager")
    public Front_Manager get_front_manager(@RequestBody String mail )

    {
        return  service.get_front_manager(mail);
    }

    @PostMapping("/update_manager")
    public int update_manager(@RequestBody Front_Manager fr )
    {

        return  service.update_manager(fr);
    }
}
