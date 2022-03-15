package by.mikita.bialiayeu.server.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "date_registration")
    private String dateRegistration;
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
}