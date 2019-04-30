package Servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.JpaUtil;

/**
 * Servlet implementation class ActionServlet
 */

// A modifier l'annotation en fonction du nom de la servlet choisie
@WebServlet(name="ActionServlet", urlPatterns = {"/ActionServlet"})
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer le paramètre si besoin 
		// qui nous dira quoi faire
		String todo = request.getParameter("aModifierNomDuParametre");
		
		if (todo == "creerService") {
			ActionCreation ac = new ActionCreation();
			
			try {
				ac.executeAction(request);
			} catch (ParseException ex) {
				Logger.getLogger(ActionServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

    @Override
    public void init() throws ServletException {
    	super.init();
    	JpaUtil.init();
    }
    
    @Override
    public void destroy() {
    	super.destroy();
    	JpaUtil.destroy();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@Override
	public String getServletInfo() {
		return "Servlet principale faisant office de controler";
	}

}
