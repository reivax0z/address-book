package reivax.norac.addressbook.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * Helper class for book download as a JSON file.
 * 
 * @author Xavier
 *
 */
public class DownloadJsonFile {

	/**
	 * Downloads the content of the book DB as a JSON file.
	 * 
	 * @param jsonAsString the content of the DB as a valid JSON String
	 * @param response the HttpServletResponse
	 * @param filePath the path to the file for temp storage
	 * @throws IOException
	 */
	public static void download(String jsonAsString, HttpServletResponse response, String filePath) throws IOException{
		String fileName = "book.json";
        String fileType = "json";

		File my_file = new File(filePath + File.separator
				+ fileName);
		FileWriter file = new FileWriter(my_file);
		file.write(jsonAsString);
		file.close();
        
        response.setContentType(fileType);

        response.setHeader("Content-disposition","attachment; filename="+fileName);

        OutputStream out = response.getOutputStream();
        FileInputStream in = new FileInputStream(my_file);
        byte[] buffer = new byte[4096];
        int length;
        while ((length = in.read(buffer)) > 0){
           out.write(buffer, 0, length);
        }
        in.close();
        out.flush();
	}
}
