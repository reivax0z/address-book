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
import reivax.norac.addressbook.util.DownloadJsonFile;
import reivax.norac.addressbook.util.JsonDecode;
import reivax.norac.addressbook.util.JsonEncode;
import reivax.norac.addressbook.util.SearchManager;
import reivax.norac.addressbook.util.UploadJsonFile;

/**
 * Servlet dedicated to compare the Address Book with another one.
 * 
 * @author Xavier
 *
 */
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String filePath = ".";

	/**
	 * Default constructor. 
	 */
	public DownloadServlet() {
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

		List<Entry> book = Model.getInstance().getCurrentAddressBook();
		String bookAsJsonString = JsonEncode.encodeBook(book).toJSONString();
	    try{
	    	DownloadJsonFile.download(bookAsJsonString, response, filePath);
	    	return;
	    } catch (IOException e){
			request.setAttribute("isInError", Boolean.TRUE);
			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
	    } catch (Exception e) {
			request.setAttribute("isInError", Boolean.TRUE);
			request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
			return;
		}
	    
//		request.setAttribute("isInError", Boolean.FALSE);
//		request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
	}
}
