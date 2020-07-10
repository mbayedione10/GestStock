/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author mamadoumbayedione
 */
public class EtatStock {
    /** @pdOid d2abaca7-231b-4b4b-81ba-516aacb4aaf3 */
   private int idEStock;
   /** @pdOid 6a70f025-c3a4-48eb-a767-548455ed1ab4 */
   private int montantEStock;
   /** @pdOid c77d6fe6-2b29-4b3c-a947-3fffbc5d8f61 */
   private int qteEStock;
   private String nomEArticle;

    public int getIdEStock() {
        return idEStock;
    }

    public void setIdEStock(int idEStock) {
        this.idEStock = idEStock;
    }

    public int getMontantEStock() {
        return montantEStock;
    }

    public void setMontantEStock(int montantEStock) {
        this.montantEStock = montantEStock;
    }

    public int getQteEStock() {
        return qteEStock;
    }

    public void setQteEStock(int qteEStock) {
        this.qteEStock = qteEStock;
    }

    public String getNomEArticle() {
        return nomEArticle;
    }

    public void setNomEArticle(String nomEArticle) {
        this.nomEArticle = nomEArticle;
    }
}
