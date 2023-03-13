package sn.esmt.Cv.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cvusers")

public class CvEntity {
    @Id//JPA ID est cle primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto-increment
    private int id;
    @Column(length = 200,nullable = false)
    private String nom;
    @Column(length = 200,nullable = false)
    private String prenom;
    private int age;
    @Column(length = 200,nullable = false)
    private String adresse;
    @Column(length = 200,nullable = false)
    private String email;
    private int telephone;
    @Column(length = 200,nullable = false)
    private String specialite;
    @Column(length = 200,nullable = false)
    private String niveauEtude;
    @Column(length = 200,nullable = false)
    private String  experienceProfessionelle;

}
