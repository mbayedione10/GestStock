package model;

/***********************************************************************
 * Module:  Stock.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Stock
 ***********************************************************************/

/** model stock
 * 
 * @pdOid 916c1e20-1592-435d-8f53-cf71729d72f1 */
public class Stock {
   /** @pdOid d2abaca7-231b-4b4b-81ba-516aacb4aaf3 */
   private int idStock;
   /** @pdOid 6a70f025-c3a4-48eb-a767-548455ed1ab4 */
   private int montantStock;
   /** @pdOid c77d6fe6-2b29-4b3c-a947-3fffbc5d8f61 */
   private int qteStock;
   private String nomArticle;
   
   
   /**
     * @return  *  @pdOid 71ba1bcd-d727-4f64-8c62-2a30f4817b33 */
   public int getIdStock() {
      return idStock;
   }

    public int getMontantStock() {
        return montantStock;
    }

    public void setMontantStock(int montantStock) {
        this.montantStock = montantStock;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }


   
   
   /** @param newIdStock
    * @pdOid 9ec3ab8b-965f-4153-bcdc-2d68f6b86f7b */
   public void setIdStock(int newIdStock) {
      idStock = newIdStock;
   }
   

   /**
     * @return  *  @pdOid a0992fe5-6fac-437c-812a-a433c2dd7f4a */
   public int getQteStock() {
      return qteStock;
   }
   
   /** @param newQteStock
    * @pdOid 01a8a134-aa49-45ed-9f62-2c507cb9b24f */
   public void setQteStock(int newQteStock) {
      qteStock = newQteStock;
   }

}