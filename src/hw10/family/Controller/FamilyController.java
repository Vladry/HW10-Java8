package hw10.family.Controller;

import hw10.family.service.Services;

public class FamilyController {
    public Services FamilyService ;

    public FamilyController(Services service) {
        this.FamilyService  = service;
    }
}
