package com.projet.dao;

import com.projet.beans.utilisateur;

public interface UtilisateurDao {

    void creer( utilisateur utilisateur ) throws DAOException;
    utilisateur trouver( String email ) throws DAOException;


}
