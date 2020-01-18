package pl.connectis.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.connectis.JpaTutorial.domain.Engine;
import pl.connectis.JpaTutorial.domain.Model;
import pl.connectis.JpaTutorial.repository.BrandRepository;
import pl.connectis.JpaTutorial.repository.EngineRepository;
import pl.connectis.JpaTutorial.repository.ModelRepository;

import javax.transaction.Transactional;

@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private EngineRepository engineRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm running");

        Engine engine = engineRepository.getOne("SKYACTIV-D 2.2");
        for (Model model : engine.getModels()) {
            System.out.println("Model using engine: " + model.getName());
        }
    }
}
