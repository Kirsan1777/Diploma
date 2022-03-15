package by.mikita.bialiayeu.web.util;

import by.mikita.bialiayeu.server.model.Course;
import by.mikita.bialiayeu.server.service.impl.CourseServiceImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

@RestController
@RequestMapping("/picture/*")
@EnableAutoConfiguration
public class PictureServlet extends HttpServlet {

    private static final int BEGIN_INDEX = 1;
    private static final String UPLOAD_DIR = "D:\\Work\\picture\\";
    private static final String CONTENT_DISPOSITION_VALUE = "inline; filename=\"%s\"";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String filename = request.getPathInfo().substring(BEGIN_INDEX);
        File file = new File(UPLOAD_DIR, filename);
        response.setHeader(CONTENT_TYPE, getServletContext().getMimeType(filename));
        response.setHeader(CONTENT_LENGTH, String.valueOf(file.length()));
        response.setHeader(CONTENT_DISPOSITION, String.format(CONTENT_DISPOSITION_VALUE, filename));
        Files.copy(file.toPath(), response.getOutputStream());
        //обработку ошибки Files.copy
    }

}
