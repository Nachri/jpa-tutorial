package pl.connectis.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.connectis.JpaTutorial.domain.Brand;
import pl.connectis.JpaTutorial.domain.Country;
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

        Model model = modelRepository.getOne(-1L);
        System.out.println("Model name: " + model.getName());
        System.out.println("Brand name: " + model.getBrand().getName());
        System.out.println("CEO name: " + model.getBrand().getCeo().getFirstName());
    }
}
