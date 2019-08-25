package com.ma.app.util;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class ImagenUtil {

    private static final Logger logger = Logger.getLogger(ImagenUtil.class.getName());

    private static final int SIZE_RANDOM = 7;
    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final String NOMBRE_PREFIJO = "x";
    private static final String RESOURCES_IMAGES = "/resources/images/";
    private static Random random = new Random();

    private ImagenUtil() {}

    public static String guardarImagen(MultipartFile multipartFile, HttpServletRequest request) {
        String nombreOriginal = getNombre(multipartFile);
        String rutaFinal = getRutaFinal(request);
        try {
            File imageFile = new File(rutaFinal + nombreOriginal);
            multipartFile.transferTo(imageFile);
            return nombreOriginal;
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    private static String getRutaFinal(HttpServletRequest request) {
        String rutaFinal = request.getServletContext().getRealPath(RESOURCES_IMAGES);
        rutaFinal = rutaFinal.endsWith(File.separator) ? rutaFinal :
                    rutaFinal.concat(File.separator);
        return rutaFinal;
    }

    private static String getNombre(MultipartFile multipartFile) {
        return randomAlphaNumeric(SIZE_RANDOM).concat(multipartFile.getOriginalFilename().replace(" ", "-"));
    }

    private static String randomAlphaNumeric(int count) {
        StringBuilder sb = new StringBuilder();
        sb.append(NOMBRE_PREFIJO);
        while (count-- > 0) {
            sb.append(CARACTERES.charAt(random.nextInt(CARACTERES.length())));
        }
        return sb.toString();
    }

}
