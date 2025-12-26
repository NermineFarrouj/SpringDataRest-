package net.supervision.devoirdatarest;

import net.supervision.devoirdatarest.enums.Genre;
import net.supervision.devoirdatarest.model.Centre;
import net.supervision.devoirdatarest.model.Etudiant;
import net.supervision.devoirdatarest.repository.CentreRepository;
import net.supervision.devoirdatarest.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;


@SpringBootApplication
public class DevoirDataRestApplication implements CommandLineRunner {

    @Autowired
    private EtudiantRepository etudiantRepository;
@Autowired
private CentreRepository centreRepository;
    public static void main(String[] args) {
        SpringApplication.run(DevoirDataRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Centre centre1 = Centre.builder()
                .nom("Maarif").adresse("Biranzarane").build();
        centreRepository.save(centre1);
        Centre centre2 = Centre.builder()
                .nom("Oranges").adresse("Oulfa").build();
        centreRepository.save(centre2);
        Etudiant et1 = Etudiant.builder()
                .nom("Ad")
                .prenom("r")
                .genre(Genre.Homme).centre(centre1)
                .build();

        etudiantRepository.save(et1);
        Etudiant et2 = Etudiant.builder()
                .nom("meowmi")
                .prenom("m")
                .genre(Genre.Femme).centre(centre2)
                .build();

        etudiantRepository.save(et2);
        Etudiant et3 = Etudiant.builder()
                .nom("senora")
                .prenom("f")
                .genre(Genre.Femme).centre(centre2)
                .build();

        etudiantRepository.save(et3);

        // Pour vérifier que l'enregistrement s’est bien fait
        etudiantRepository.findAll().forEach(System.out::println);
    }
}


