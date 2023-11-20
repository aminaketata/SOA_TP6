package org.exemple.Amina_LSI3_SOA_TP6;

import org.exemple.entities.Compte;
import org.exemple.entities.EtatCompte;
import org.exemple.entities.TypeCompte;
import org.exemple.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.exemple.repositories")
@EntityScan(basePackages = "org.exemple.entities")
@ComponentScan("org.exemple")
public class AminaLSI3SOATP6Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(AminaLSI3SOATP6Application.class,args);
    }
    @Bean
    public CommandLineRunner CLR (CompteRepository compteRepository)
    {
        return (args)->
        {
            compteRepository.save(new Compte(null, 200, new Date(), TypeCompte.COURANT, EtatCompte.ACTIVE));
            compteRepository.save(new Compte(null, 400, new Date(), TypeCompte.EPARGNE, EtatCompte.CREE));
            compteRepository.save(new Compte(null, 9000, new Date(), TypeCompte.EPARGNE, EtatCompte.BLOQUE));
            List<Compte> comptes = compteRepository.findAll();
            for (Compte compte : comptes)
            {
                System.out.println("Solde du compte " + compte.getId() + ": " + compte.getSolde());
            }
        };
        }
}
