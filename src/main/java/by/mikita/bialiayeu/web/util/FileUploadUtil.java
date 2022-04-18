package by.mikita.bialiayeu.web.util;

import by.mikita.bialiayeu.web.controller.AdminController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(urlPatterns = "/imagesUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadUtil extends HttpServlet {

    private static final String UPLOAD_DIR = "D:\\Work\\picture\\";

    private static final String TEACHER_PAGE = "/admin/teacher";
    private static final String COURSE_PAGE = "/admin/course";
    private static final String BLOG_PAGE = "/admin/blog";

    private static final String TEACHER = "teacher";
    private static final String COURSE = "course";
    private static final String BLOG = "blog";


    @Autowired
    private AdminController adminController;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter("page");
        //System.getProperty("user.home");

        File fileSaveDir = new File(UPLOAD_DIR);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        StringBuilder fileName = new StringBuilder();
        request.getParts().forEach(part -> {
            try {
                String path = part.getSubmittedFileName();
                if (path == null) {
                   // throw new ControllerException();
                }
                part.write(UPLOAD_DIR + path);
                fileName.append(path);
            } catch (IOException e) {
                // LOGGER.error("File was not uploaded");
            }
        });
        switch (page) {
            case TEACHER:
                response.sendRedirect(TEACHER_PAGE);
                break;
            case COURSE:
                response.sendRedirect(COURSE_PAGE);
                break;
            case BLOG:
                response.sendRedirect(BLOG_PAGE);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
