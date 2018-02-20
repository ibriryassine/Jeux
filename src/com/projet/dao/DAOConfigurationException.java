package com.projet.dao;

public class DAOConfigurationException extends RuntimeException {

    /*

     * Constructeurs

     */

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public DAOConfigurationException( String message ) {

        super( message );

    }


    public DAOConfigurationException( String message, Throwable cause ) {

        super( message, cause );

    }


    public DAOConfigurationException( Throwable cause ) {

        super( cause );

    }

}
