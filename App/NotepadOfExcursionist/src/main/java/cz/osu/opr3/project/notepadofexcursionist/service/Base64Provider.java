package cz.osu.opr3.project.notepadofexcursionist.service;

import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.io.InputStream;

public class Base64Provider {

    public static String getBase64Img(Part picturePart) throws IOException {
        StringBuilder sbBase64 = new StringBuilder();

        InputStream pictureContent = picturePart.getInputStream();
        byte[] byteContent = pictureContent.readAllBytes();

        if (byteContent.length == 0)
            sbBase64.append("");
        else
            sbBase64.append("data:").
                    append(
                            picturePart.getContentType()
                    ).
                    append(";base64,").
                    append(
                            DatatypeConverter.printBase64Binary(byteContent)
                    );
        return sbBase64.toString();
    }

}
