package by.mikita.bialiayeu.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The {@code Book} class represents Book.
 *
 * @author Belyaev Nikita
 * @version 1.0
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private int id;
    @Column(name = "name_course")
    private String nameCourse;
    @Column(name = "type_of_course")
    private String typeOfCourse;
    private String description;
    @Column(name = "photo_reference")
    private String photoReference;


}
