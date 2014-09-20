package reivax.norac.addressbook.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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
	
	public static void upload2(HttpServletRequest request, String filePath, String fileName) throws Exception{
		// Check that we have a file upload request
	      boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	      File file;

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);

	      try{ 
	      // Parse the request to get file items.
	      List fileItems = upload.parseRequest(request);
		
	      // Process the uploaded file items
	      Iterator i = fileItems.iterator();

	      while ( i.hasNext () ) 
	      {
	         FileItem fi = (FileItem)i.next();
	         if ( !fi.isFormField () )	
	         {
	            // Write the file
	               file = new File(filePath + File.separator
	                       + fileName) ;
	            fi.write( file ) ;
	         }
	      }
	   }catch(FileNotFoundException ex) {
	       System.out.println(ex);
	   }
	}
}
