package model;

/***********************************************************************
 * Module:  Commandes.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Commandes
 ***********************************************************************/

import java.util.*;

/** model Commande
 * 
 * @pdOid c3ab7d04-b81a-47fb-9b08-ddcc7655b3e2 */
public class Commandes {
   /** @pdOid 20a7d6f6-97b5-490c-95b3-3807a4d0dead */
   private int idCommande;
   /** @pdOid f88d77ab-03b9-4862-9d2b-8862f25db5a2 */
   private String libelle;
   /** @pdOid fd6d3a9b-67dd-4986-8635-ad3e5ce685a9 */
   private String date;
   private int idClient;
   private int idArticle;
   private int qte;

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
   private int idUser;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }
   /** @pdRoleInfo migr=no name=Facture assc=concerner mult=1..1 */
   public Facture facture;
   public java.util.Collection composer;
   
   /**
     * @return  *  @pdOid 9baf9ccb-bba1-404f-b397-555aba1e49ab */
   public int getIdCommande() {
      return idCommande;
   }
   
   /** @param newIdCommande
    * @pdOid f0b3a8d2-9a76-49ec-9c5d-a9b09656d358 */
   public void setIdCommande(int newIdCommande) {
      idCommande = newIdCommande;
   }
   
   /**
     * @return  *  @pdOid d5c4014e-0261-4d83-8364-ce4324dfacd5 */
   public String getLibelle() {
      return libelle;
   }
   
   /** @param newLibelle
    * @pdOid 8b4555c8-2142-4ad1-aaab-0f360cc874f0 */
   public void setLibelle(String newLibelle) {
      libelle = newLibelle;
   }
   
   /**
     * @return  *  @pdOid eff20bb5-f80a-4a5e-9118-035117cf2501 
   public Date getDate() {
      return date;
   }
   
   /** @param newDate
    * @pdOid f829bd02-ad28-4446-80b5-4ae41f7a03f0 
   public void setDate(Date newDate) {
      date = newDate;
   }
**/
}