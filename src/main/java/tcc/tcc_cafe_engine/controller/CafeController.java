package tcc.tcc_cafe_engine.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tcc.tcc_cafe_engine.handler.CafeRulesHandler;
import tcc.tcc_cafe_engine.model.CustomerModel;

@RestController
public class CafeController {

    private final CafeRulesHandler handler = new CafeRulesHandler();

    @RequestMapping(value = {"/cafe"}, method = RequestMethod.POST, consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void transactionalDataRetriever(@RequestBody CustomerModel customer) {
        handler.cafeEngineHandler(customer);
    }
}
