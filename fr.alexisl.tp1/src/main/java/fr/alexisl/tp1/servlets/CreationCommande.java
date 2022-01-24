package fr.alexisl.tp1.servlets;

import java.io.IOException;

import fr.alexisl.tp1.beans.Client;
import fr.alexisl.tp1.beans.Commande;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CreationCommande extends HttpServlet {

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        
        double montant;
        try {
            //montant = Double.parseDouble( request.getParameter( "montantCommande" ) );
        } catch ( NumberFormatException e ) {
            montant = -1;
        }
        String modePaiement = request.getParameter( "modePaiementCommande" );
        String statutPaiement = request.getParameter( "statutPaiementCommande" );
        String modeLivraison = request.getParameter( "modeLivraisonCommande" );
        String statutLivraison = request.getParameter( "statutLivraisonCommande" );


        Commande commande = new Commande();
        //commande.setMontant( montant );
        commande.setModePaiement( modePaiement );
        commande.setStatutPaiement( statutPaiement );
        commande.setModeLivraison( modeLivraison );
        commande.setStatutLivraison( statutLivraison );

        request.setAttribute( "commande", commande );
        
            this.getServletContext().getRequestDispatcher("/WEB-INF/afficherCommande.jsp").forward( request, response );
    }
    
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/WEB-INF/creerCommande.jsp" ).forward( request, response );
    }
}