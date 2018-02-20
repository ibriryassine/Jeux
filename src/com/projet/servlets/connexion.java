package com.projet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.projet.beans.utilisateur;
import com.projet.form.connexionform;

@WebServlet("/connexion")
public class connexion extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID  = 1L;
	public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/connexion.jsp";
    public static final String VUE1             = "/WEB-INF/accueilutilisateur.jsp";


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }


    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        /* Préparation de l'objet formulaire */
        connexionform form = new connexionform();

        /* Traitement de la requête et récupération du bean en résultant */
        utilisateur utilisateur = form.connecterutilisateur( request );
        
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        


        /**

         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean

         * Utilisateur à la session, sinon suppression du bean de la session.

         */
       

        if ( form.getErreur().isEmpty() ) {

            session.setAttribute( ATT_SESSION_USER, utilisateur );
            this.getServletContext().getRequestDispatcher( VUE1 ).forward( request, response );

        } else {

            session.setAttribute( ATT_SESSION_USER, null );
            this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

        }


        /* Stockage du formulaire et du bean dans l'objet request */

        request.setAttribute( ATT_FORM, form );

        request.setAttribute( ATT_USER, utilisateur );


     

    }

}