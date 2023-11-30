package org.exemple.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class Compte
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    double Solde;
    Date dateCreation;
    TypeCompte type;
    EtatCompte etat;
}
