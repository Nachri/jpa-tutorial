package pl.connectis.JpaTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pl.connectis.JpaTutorial.domain.Brand;
import pl.connectis.JpaTutorial.domain.Country;
import pl.connectis.JpaTutorial.repository.BrandRepository;

import javax.transaction.Transactional;

@Component
@Transactional
public class CmdRunner implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm running");

        Brand brand = brandRepository.getOne(-1L);
        System.out.println("Got brand with id: " + brand.getId());
        System.out.println("Brand name: " + brand.getName());
        System.out.println("CEO id: " + brand.getCeo().getId());
        System.out.println("CEO name: " + brand.getCeo().getFirstName());
    }
}
