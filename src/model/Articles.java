package model;

import javax.swing.JComboBox;

/***********************************************************************
 * Module:  Articles.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Articles
 ***********************************************************************/

/** model Articles
 * 
 * @pdOid 744d7519-819b-412b-81a6-6e2fd0a8e356 */
public class Articles {


   private String nomArticle;
  
   private String designation;
   private JComboBox liste;
   int idCtegorie;
   
   int idArticle;
   int idFournisseur;
   int qte;
   int prixU;
   int prixT;

    public int getPrixU() {
        return prixU;
    }

    public void setPrixU(int prixU) {
        this.prixU = prixU;
    }

    public int getPrixT() {
        return prixT;
    }

    public void setPrixT(int prixT) {
        this.prixT = prixT;
    }
 

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }
   
   public Stock stock;

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }
   
   /**
     * @return  *  @pdOid 8d5131d6-6705-4de3-bfd0-3c8f68519125 */
   public int getIdArticle() {
      return idArticle;
   }
   
   /** @param newIdArticle
    * @pdOid e0969e61-4d4d-4c5a-b549-7432f0961cd4 */
   public void setIdArticle(int newIdArticle) {
      idArticle = newIdArticle;
   }
   
   /**
     * @return  *  @pdOid fe8b12cf-6e21-412e-85ae-73faf8fb6131 */
   public String getNomArticle() {
      return nomArticle;
   }
   
   /** @param newNomArticle
    * @pdOid 96320082-c401-4d21-8c52-325fb818eccb */
   public void setNomArticle(String newNomArticle) {
      nomArticle = newNomArticle;
   }
   
   /**
     * @return  *  @pdOid 8ea1e90d-d865-4c2a-97c6-befa17c91d64 */
   public String getDesignation() {
      return designation;
   }
   
   /** @param newDesignation
    * @pdOid 70d916e1-0926-42ab-b9ec-9ef4eac99378 */
   public void setDesignation(String newDesignation) {
      designation = newDesignation;
   }
       public int getIdCtegorie() {
        return idCtegorie;
    }

    public void setIdCtegorie(int idCtegorie) {
        this.idCtegorie = idCtegorie;
    }
   

}