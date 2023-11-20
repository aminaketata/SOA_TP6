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
    @Column
    Long Id;
    @Column
    double Solde;
    @Column
    Date dateCreation;
    @Column
    TypeCompte type;
    @Column
    EtatCompte etat;
}
