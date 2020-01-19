package pl.connectis.JpaTutorial.service;

import org.springframework.stereotype.Service;
import pl.connectis.JpaTutorial.domain.Brand;
import pl.connectis.JpaTutorial.domain.Engine;
import pl.connectis.JpaTutorial.domain.EngineType;
import pl.connectis.JpaTutorial.domain.Model;
import pl.connectis.JpaTutorial.dto.BrandDTO;
import pl.connectis.JpaTutorial.dto.EngineDTO;
import pl.connectis.JpaTutorial.dto.ModelDTO;
import pl.connectis.JpaTutorial.repository.BrandRepository;
import pl.connectis.JpaTutorial.repository.EngineRepository;
import pl.connectis.JpaTutorial.repository.ModelRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final EngineRepository engineRepository;

    public ModelService(ModelRepository modelRepository, BrandRepository brandRepository, EngineRepository engineRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.engineRepository = engineRepository;
    }

    @Transactional
    public ModelDTO save(ModelDTO modelDTO){
        Model toBeSavedModel = toEntity(modelDTO);
        Brand savedBrand = brandRepository.save(toBeSavedModel.getBrand());
        List<Engine> savedEngine = engineRepository.saveAll(toBeSavedModel.getEngines());
        toBeSavedModel.setBrand(savedBrand);
        toBeSavedModel.setEngines(new HashSet<>(savedEngine));
        Model savedModel = modelRepository.save(toBeSavedModel);
        return toDTO(savedModel);
    }

    public List<ModelDTO> findByName(String name) {
        List<Model> foundModels = modelRepository.findByName(name);
        List<ModelDTO> modelDTOS = new ArrayList<>();
        for (Model model:foundModels
        ) {
            ModelDTO modelDTO = toDTO(model);
            modelDTOS.add(modelDTO);
        }
        return modelDTOS;
    }

    private ModelDTO toDTO(Model model){

            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setName(model.getBrand().getName());
            Set<EngineDTO> engineDTOS = new HashSet<>();
            for (Engine engine:model.getEngines()
            ) {
                EngineDTO engineDTO = new EngineDTO();
                engineDTO.setCode(engine.getCode());
                engineDTO.setType(engine.getType().name());
                engineDTOS.add(engineDTO);
            }
            ModelDTO modelDTO = new ModelDTO();
            modelDTO.setBrand(brandDTO);
            modelDTO.setEngines(engineDTOS);
            modelDTO.setName(model.getName());
        return modelDTO;
    }

    private Model toEntity(ModelDTO modelDTO){
        Model model = new Model();
        Brand brand = new Brand();
        brand.setName(modelDTO.getBrand().getName());
        model.setBrand(brand);
        Set<Engine> engines = new HashSet<>();
        for (EngineDTO engineDTO : modelDTO.getEngines()) {
            Engine engine = new Engine();
            engine.setCode(engineDTO.getCode());
            engine.setType(EngineType.valueOf(engineDTO.getType()));
            engines.add(engine);
        }
        model.setEngines(engines);
        model.setName(modelDTO.getName());
        return model;
    }
}
