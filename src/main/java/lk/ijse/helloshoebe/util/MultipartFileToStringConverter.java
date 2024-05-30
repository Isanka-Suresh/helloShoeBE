package lk.ijse.helloshoebe.util;

import org.apache.logging.log4j.util.Base64Util;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class MultipartFileToStringConverter {
    public static String convert(MultipartFile file){
        if (file == null || file.isEmpty()) {
            return null;
        }
        try {
            return Base64.getEncoder().encodeToString(file.getBytes());
        }catch (IOException e){
            throw new RuntimeException("Failed to convert MultipartFile to String", e);
        }
    }
}
