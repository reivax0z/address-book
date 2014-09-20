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
 * Servlet dedicated to searching an entry in Address Book.
 * 
 * @author Xavier
 *
 */
public class SearchServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public SearchServlet() {
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

		// Get name to be searched
		String name = request.getParameter("search_name");
		
		// Get book from Model
		List<Entry> book = Model.getInstance().getCurrentAddressBook();
		
		SearchManager<Entry> searchManager = new SearchManager<Entry>();
		Entry e = new Entry();
		e.setName(name);

		request.setAttribute("searchedName", name);
		
		// Get exact matches
		List<Entry> matchedNames = searchManager.searchEngine(e, book, new ComparatorExact());
		request.setAttribute("matchedNames", matchedNames);
		
		// Get similar matches
		List<Entry> closeNames = searchManager.searchEngine(e, book, new ComparatorClose());
		Collections.sort(closeNames, new ComparatorExact());
		request.setAttribute("closeNames", closeNames);

		request.setAttribute("isInError", Boolean.FALSE);
		request.getRequestDispatcher("SearchBook.jsp").forward(request, response);
	}
}
