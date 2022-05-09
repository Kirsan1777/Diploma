package by.mikita.bialiayeu.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "claim")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "date_registration")
    private String dateRegistration;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "id_course")
    private int idCourse;
}