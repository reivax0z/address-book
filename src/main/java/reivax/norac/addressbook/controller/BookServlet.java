package reivax.norac.addressbook.controller;

import java.io.IOException;
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

public class BookServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public BookServlet() {
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
		Collections.sort(book, new ComparatorExact());

		// Forward the info to the appropriate JSP
		request.setAttribute("book", book);

		request.setAttribute("isInError", Boolean.FALSE);
		request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
	}
}
