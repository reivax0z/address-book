package reivax.norac.addressbook.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.json.simple.parser.ParseException;

import reivax.norac.addressbook.model.DBConnection;
import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.model.Model;
import reivax.norac.addressbook.util.ComparatorExact;
import reivax.norac.addressbook.util.ComparatorClose;
import reivax.norac.addressbook.util.JsonDecode;
import reivax.norac.addressbook.util.SearchManager;
import reivax.norac.addressbook.util.UploadJsonFile;

/**
 * Servlet dedicated to compare the Address Book with another one.
 * 
 * @author Xavier
 *
 */
public class CompareServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String filePath = ".";
	private static String fileName = "compare.json";

	/**
	 * Default constructor. 
	 */
	public CompareServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processData(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processData(request, response);
	}

	private void processData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    // Step1: Upload the file on system
	    try{
	    	UploadJsonFile.upload2(request, filePath, fileName);
	    } catch (IOException e){
			request.setAttribute("isInError", Boolean.TRUE);
			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
	    } catch (Exception e) {
			request.setAttribute("isInError", Boolean.TRUE);
			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
		}
	    
	    // Step2: Decode and compare the file
	    try {
	    	// Decode the file
			List<Entry> uploaded = JsonDecode.decodeBook(filePath + File.separator
			        + fileName);
			
			// Get book from Model
			List<Entry> book = Model.getInstance().getCurrentAddressBook();
			
			// Get similar and different results
			Collection<Entry> similar = new ArrayList<Entry>( book );
			Collection<Entry> different = new ArrayList<Entry>();
			different.addAll( book );
			different.addAll( uploaded );

			// Keep similar names
			similar.retainAll( uploaded );
			
			// Keep different names
			different.removeAll( similar );
			
			request.setAttribute("similarNames", similar);
			request.setAttribute("differentNames", different);

		} catch (ParseException e) {
			request.setAttribute("isInError", Boolean.TRUE);
			getServletContext().getRequestDispatcher("/DisplayBook.jsp").forward(request, response);
//			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
		} catch (Exception e) {
			request.setAttribute("isInError", Boolean.TRUE);
			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
		}
	    
		request.setAttribute("compareSuccess", Boolean.TRUE);
		request.setAttribute("isInError", Boolean.FALSE);
		request.getRequestDispatcher("CompareBook.jsp").forward(request, response);
	}
}
