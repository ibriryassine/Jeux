package com.projet.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projet.beans.utilisateur;
import com.projet.form.inscriptionform;

@WebServlet("/inscription")
public class inscription extends HttpServlet{

	 /**
	 * 
	 */
		private static final long serialVersionUID = 1L;
		public static final String ATT_USER = "utilisateur";
	    public static final String ATT_FORM = "form";
	    public static final String VUE = "/WEB-INF/inscription.jsp";
	    public static final String VUE1 = "/WEB-INF/connexion.jsp";
			
	    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Affichage de la page d'inscription */
	        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	    }
		
	    
	    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
	        /* Préparation de l'objet formulaire */
	        inscriptionform form = new inscriptionform();
			
	        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
	        utilisateur utilisateur = form.inscriptionutilisateur( request );
			
	        /* Stockage du formulaire et du bean dans l'objet request */
	        request.setAttribute( ATT_FORM, form );
	        
	        
	        if(form.getErreur().isEmpty()){
	        	//session.request.setAttribute( ATT_USER, utilisateur);
	        	 this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );
	        }
	        else{
	        	request.setAttribute( ATT_USER, utilisateur);
	        	this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	        }
	       
	    }
	
}
