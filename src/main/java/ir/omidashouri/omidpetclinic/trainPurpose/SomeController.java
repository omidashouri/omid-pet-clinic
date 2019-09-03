package ir.omidashouri.omidpetclinic.trainPurpose;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeController {

    private final MyService myService;

    @Autowired
    public SomeController(MyService myService) {
        this.myService = myService;
    }


}
