package model;

/***********************************************************************
 * Module:  Categories.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Categories
 ***********************************************************************/


public class Categories {
   /** @pdOid 2f9e419a-70a8-48a9-8262-bff92b83694b */
   private int idCategories;
   /** @pdOid a7cee99f-311d-46ba-833c-7898fc70f79d */
   private String nameCategorie;
   private String genre;
   
   /** @pdRoleInfo migr=no name=Articles assc=appartenir mult=1..1 */
   
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
   
   /**
     * @return  *  @pdOid 0ad793a2-e2bf-4d99-869b-963971f94e7f */
   public int getIdCategories() {
      return idCategories;
   }
   
   /** @param newIdCategories
    * @pdOid d1453712-671c-415b-b0b7-cc2da06a6af4 */
   public void setIdCategories(int newIdCategories) {
      idCategories = newIdCategories;
   }
   
   /**
     * @return  *  @pdOid 14567b7e-b2c4-4f57-873f-df93edd8cf11 */
   public String getNameCategorie() {
      return nameCategorie;
   }
   
   /** @param newNameCategorie
    * @pdOid 20fffc0d-d266-401b-81bb-4f02e04a3b8d */
   public void setNameCategorie(String newNameCategorie) {
      nameCategorie = newNameCategorie;
   }

}