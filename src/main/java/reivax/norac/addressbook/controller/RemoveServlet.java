package reivax.norac.addressbook.controller;

import reivax.norac.addressbook.model.Entry;
import reivax.norac.addressbook.model.Model;
import reivax.norac.addressbook.util.ComparatorExact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Servlet dedicated to removing an entry in Address Book.
 * 
 * @author Xavier
 *
 */
public class RemoveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public RemoveServlet() {
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

		// Get parameter
		int id = Integer.parseInt(request.getParameter("remove_id"));
		
		// Remove from Model
		List<Entry> book = Model.getInstance().getCurrentAddressBook();
		for(Entry e : book){
			if(e.getId() == id){
				Model.getInstance().removeEntry(e);
				break;
			}
		}
		
		// Get back updated book from Model
		book = Model.getInstance().getCurrentAddressBook();
		Collections.sort(book, new ComparatorExact());
		request.setAttribute("book", book);
		
		request.setAttribute("removeSuccess", Boolean.TRUE);
		request.setAttribute("isInError", Boolean.FALSE);
		request.getRequestDispatcher("DisplayBook.jsp").forward(request, response);
	}
}
