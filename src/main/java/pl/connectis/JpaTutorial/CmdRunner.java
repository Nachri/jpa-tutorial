package pl.connectis.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.connectis.JpaTutorial.domain.Brand;
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

        Brand brand = brandRepository.getOne(-1L);
        for (Model model : brand.getModels()) {
            System.out.println("Model: " + model.getName());
        }

        Model pegeout508 = modelRepository.getOne(-3L);
        System.out.println(pegeout508.getBrand().getName());
    }
}
