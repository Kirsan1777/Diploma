package by.anya.kuksa.server.service;


import by.anya.kuksa.server.model.Course;
import org.springframework.data.domain.Page;

public interface CourseService {

    /**
     * add book
     *
     * @param course  the all information of book
     * @param genre the id genre
     */
    void addBook(Course course, int genre);

    /**
     * delete the book
     *
     * @param idBook the id book
     */
    void deleteBook(int idBook);

    /**
     * gets all user-bought books
     *
     * @param idUser the id user
     * @return the books
     */
    Page<Course> getMyBoughtBook(int idUser);

    /**
     * gets all books by genre
     *
     * @param idGenre the id genre
     * @return the books
     */
    Page<Course> getAllBookByGenre(int idGenre);

    /**
     * gets all books by name
     *
     * @param name the name book
     * @return the books
     */
    Page<Course> getAllBookByName(String name);

    /**
     * gets all books by id author
     *
     * @param idUser the id author(user)
     * @return the books
     */
    Page<Course> getAllBookByIdAuthor(int idUser);

    /**
     * gets all books by criteria
     *
     * @param sort the selection criterion
     * @return the books
     */
    Page<Course> getAllBookSort(String sort);

    /**
     * find book by id
     *
     * @param idBook the id book
     * @return the book
     */
    Course findBook(int idBook);

    /**
     * updates the picture of the book
     *
     * @param idBook      the id book
     * @param namePicture the new name picture
     */
    void updateBookPicture(int idBook, String namePicture);

    /**
     * changes book access
     *
     * @param idBook the id book
     * @param status the new status of the book
     */
    void updateBookStatus(int idBook, int status);

    /**
     * updates book information
     *
     * @param course the book
     */
    void updateBook(Course course);
}
