package reivax.norac.addressbook.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.addressbook.model.DBConnection;
import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.model.Model;
import reivax.norac.addressbook.util.ComparatorExact;
import reivax.norac.addressbook.util.ComparatorClose;
import reivax.norac.addressbook.util.SearchManager;

/**
 * Servlet dedicated to adding new entry in Address Book.
 * 
 * @author Xavier
 *
 */
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public AddServlet() {
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

		// Get parameters
		String name = request.getParameter("add_name");
		name = name.trim();
		String phone = request.getParameter("add_phone");
		phone = phone.trim();
		
		Entry e = new Entry();
		e.setName(name);
		e.setPhone(phone);
		
		// Delegate adding to the model
		Model.getInstance().addEntry(e);

		// Get the updated book back
		List<Entry> book = Model.getInstance().getCurrentAddressBook();
		Collections.sort(book, new ComparatorExact());
		request.setAttribute("book", book);
		
		request.setAttribute("addSuccess", Boolean.TRUE);
		request.setAttribute("isInError", Boolean.FALSE);
		request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
	}
}
