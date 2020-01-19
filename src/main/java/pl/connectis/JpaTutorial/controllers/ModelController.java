package pl.connectis.JpaTutorial.controllers;


import org.springframework.web.bind.annotation.*;
import pl.connectis.JpaTutorial.dto.ModelDTO;
import pl.connectis.JpaTutorial.repository.ModelRepository;
import pl.connectis.JpaTutorial.service.ModelService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService, ModelRepository modelRepository) {
        this.modelService = modelService;
    }

    @GetMapping("/getModel/{name}")
    List<ModelDTO> getByName(@PathVariable String name){
        return modelService.findByName(name);
    }

    @PostMapping("/saveModel")
    ModelDTO save(@RequestBody @Valid ModelDTO model){
        return modelService.save(model);
    }


}
