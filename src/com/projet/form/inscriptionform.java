package com.projet.form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.projet.beans.utilisateur;

public final class inscriptionform {
	
	private static final String CHAMP_EMAIL="email";
	private static final String CHAMP_PASS="motdepasse";
	private static final String CHAMP_CONF="confirmation";
	private static final String CHAMP_NOMUTILISATEUR="nomutilisateur";
	
	private String resultat;
	private Map<String,String> erreur = new HashMap<String,String>(); 
	
	
	public String getResultat(){
		return resultat;
	}
	
	public Map<String,String> getErreur(){
		return erreur;
	}
	
	
	public utilisateur inscriptionutilisateur(HttpServletRequest request){
		
		 String email = getValeurChamp( request, CHAMP_EMAIL );
         String motDePasse = getValeurChamp( request, CHAMP_PASS );
		 String confirmation = getValeurChamp( request, CHAMP_CONF );
		 String nomutilisateur = getValeurChamp( request, CHAMP_NOMUTILISATEUR);

		   utilisateur utilisateur = new utilisateur();


		    try {

		        validationEmail( email );

		    } catch ( Exception e ) {

		        setErreur( CHAMP_EMAIL, e.getMessage() );

		    }

		   utilisateur.setEmail(email);
		   
		   try {

		        validationNomutilisateur(nomutilisateur);

		    } catch ( Exception e ) {

		        setErreur( CHAMP_NOMUTILISATEUR, e.getMessage() );

		    }

		   utilisateur.setNomutilisateur(nomutilisateur);

		   try {

		        validationMotDePass(motDePasse,confirmation);

		    } catch ( Exception e ) {

		        setErreur( CHAMP_PASS, e.getMessage() );
		        setErreur( CHAMP_CONF, null );
		    }

		   utilisateur.setMotDePasse(motDePasse);

		if(erreur.isEmpty()){
			
			resultat="inscription avec succes";
			
		}else{
			
			resultat="Echec inscription";
		}
		
		return utilisateur;
		
	}

	private void validationMotDePass(String motDePasse, String confirmation) throws Exception {
		if ( motDePasse != null && confirmation != null ) {

	        if ( !motDePasse.equals( confirmation ) ) {

	            throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );

	        } else if ( motDePasse.length() < 3 ) {

	            throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );

	        }

	    } else {

	        throw new Exception( "Merci de saisir et confirmer votre mot de passe." );

	    }
		
	}

	private void validationNomutilisateur(String nomutilisateur) throws Exception {
		 if (nomutilisateur == null || nomutilisateur.length() < 3 ) {

		        throw new Exception( "Le nom d'utilisateur doit contenir au moins 3 caractères." );

		    }
		
	}

	private void setErreur(String champ, String message) {
		erreur.put( champ, message );
		
	}

	private String getValeurChamp(HttpServletRequest request, String nomchamp) {
		 String valeur = request.getParameter(nomchamp );

		    if ( valeur == null || valeur.trim().length() == 0 ) {

		        return null;

		    } else {

		        return valeur.trim();

		    }
	}

	private void validationEmail(String email) throws Exception {
		
		if ( email != null ) {
	        if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
	            throw new Exception( "Merci de saisir une adresse mail valide." );
	        }

	    } else {
	        throw new Exception( "Merci de saisir une adresse mail." );

	    }
	}
	
	
}
