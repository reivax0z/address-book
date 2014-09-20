package reivax.norac.addressbook.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

public class UploadJsonFile {

	public static void upload(String filePath, String fileName, Part filePart) throws IOException{
	
    OutputStream out = null;
    InputStream filecontent = null;

    try {
        out = new FileOutputStream(new File(filePath + File.separator
                + fileName));
        filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
    } catch (FileNotFoundException fne) {
        System.err.println("You either did not specify a file to upload or are "
                + "trying to upload a file to a protected or nonexistent "
                + "location.");

    } finally {
        if (out != null) {
            out.close();
        }
        if (filecontent != null) {
            filecontent.close();
        }
    }
	}
}
