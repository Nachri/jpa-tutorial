package pl.connectis.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.connectis.JpaTutorial.domain.Brand;
import pl.connectis.JpaTutorial.domain.Engine;
import pl.connectis.JpaTutorial.domain.Model;
import pl.connectis.JpaTutorial.repository.BrandRepository;
import pl.connectis.JpaTutorial.repository.ModelRepository;

import javax.transaction.Transactional;

@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelRepository modelRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm running");

        Model mazda6 = modelRepository.getOne(-1L);
        for (Engine engine : mazda6.getEngines()) {
            System.out.println("Mazda 6 engine: " + engine.getCode());
        }

        Model mazdacx5 = modelRepository.getOne(-2L);
        for (Engine engine : mazdacx5.getEngines()) {
            System.out.println("Mazda CX-5 engine: " + engine.getCode());
        }
    }
}
