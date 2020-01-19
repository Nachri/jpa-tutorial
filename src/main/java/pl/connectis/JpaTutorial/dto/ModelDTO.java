package pl.connectis.JpaTutorial.dto;

import lombok.Data;

import java.util.Set;

@Data
public class ModelDTO {

    private String name;
    private BrandDTO brand;
    private Set<EngineDTO> engines;
}
