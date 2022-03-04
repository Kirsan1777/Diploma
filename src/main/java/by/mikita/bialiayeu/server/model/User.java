package by.mikita.bialiayeu.server.model;

import lombok.Data;

import javax.persistence.*;

/**
 * The {@code UserRole} class represents UserRole.
 *
 * @author Belyaev Nikita
 * @version 1.0
 */
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idUser;
    private String login;
    private String password;
    @Column(name = "role")
    private String role;
}
