package by.mikita.bialiayeu.web.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet(urlPatterns = "/FileUploadingServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileUploadUtil extends HttpServlet {

    private static final String UPLOAD_DIR = "D:\\Work\\picture\\";

    private static final String USER_PAGE = "user";

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = request.getParameter(Attribute.PAGE);
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
                //LOGGER.error("File was not uploaded");
            }
        });
        request.setAttribute(Attribute.PICTURE, fileName.toString());
        if (page.equals(USER_PAGE)) {
           // new UpdateUserPictureCommand().execute(request, response);

        } else {
            if (request.getParameter(Attribute.BOOKS_ID) != null && !request.getParameter(Attribute.BOOKS_ID).equals("")) {
                request.setAttribute(Attribute.BOOKS_ID, request.getParameter(Attribute.BOOKS_ID));
            }
            request.setAttribute(Attribute.PAGE, page);
            request.setAttribute("type", fileName.toString());
            new UpdateBookPictureCommand().execute(request, response);
            //request.getRequestDispatcher(PagePath.BOOK_PAGE_COMMAND).forward(request, response);
        }
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
