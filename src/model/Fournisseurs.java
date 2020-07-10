package model;

/***********************************************************************
 * Module:  Fournisseurs.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Fournisseurs
 ***********************************************************************/

/** @pdOid a8d6eef5-7428-45c3-9e32-f2e8c5c0376f */
public class Fournisseurs {
   /** @pdOid 41c3d26c-3ce4-453d-948d-7950b7ddf476 */
   private int idFournisseur;
   /** @pdOid 62c8af82-9dab-46f5-8e4a-250e4aac92a0 */
   private String nomF;
   /** @pdOid e78fbc44-3341-428f-9c7b-e21c445ac4f6 */
   private String prenomF;
   /** @pdOid a1647295-fe80-41e3-9d63-428738b1b926 */
   private String addressF;
   /** @pdOid 12c71642-48c6-4ebc-8cd8-118b50455135 */
   private String emailF;
   /** @pdOid 57dce09c-5d92-47a0-a178-5c0a39787670 */
   private int telF;
   
   /** @pdRoleInfo migr=no name=Livraison assc=livrer mult=1..1 */
   //public Livraison livraison;
   
   /**
     * @return  *  @pdOid d1ba12cf-af92-427a-9aba-ceb8e0ed2c71 */
   public int getIdFournisseur() {
      return idFournisseur;
   }
   
   /** @param newIdFournisseur
    * @pdOid 347350c6-d407-4783-8c78-145dfcd9e764 */
   public void setIdFournisseur(int newIdFournisseur) {
      idFournisseur = newIdFournisseur;
   }
   
   /**
     * @return  *  @pdOid 3d7694ee-2256-447e-9dcb-26e6f619204d */
   public String getNomF() {
      return nomF;
   }
   
   /** @param newNomF
    * @pdOid bb0c9a5d-2360-4970-90ca-289de246971a */
   public void setNomF(String newNomF) {
      nomF = newNomF;
   }
   
   /**
     * @return  *  @pdOid 0ea0c6cf-2483-4f9a-8805-ddbb118630d5 */
   public String getPrenomF() {
      return prenomF;
   }
   
   /** @param newPrenomF
    * @pdOid 8470fbcc-835c-4886-8b93-590e0fed25d6 */
   public void setPrenomF(String newPrenomF) {
      prenomF = newPrenomF;
   }
   
   /**
     * @return  *  @pdOid ca071a0f-8fd1-45c3-b8a5-70c94e8c1a6e */
   public String getAddressF() {
      return addressF;
   }
   
   /** @param newAddressF
    * @pdOid 8eb11350-d5ee-4d11-b92e-5694a88a083e */
   public void setAddressF(String newAddressF) {
      addressF = newAddressF;
   }
   
   /**
     * @return  *  @pdOid c109f193-61a4-4882-8110-1216c494460c */
   public String getEmailF() {
      return emailF;
   }
   
   /** @param newEmailF
    * @pdOid e8172c7f-2d0e-4328-b909-f41be1ef399f */
   public void setEmailF(String newEmailF) {
      emailF = newEmailF;
   }
   
   /**
     * @return  *  @pdOid 47695481-0b2f-4eda-ac98-cdb175a216e0 */
   public int getTelF() {
      return telF;
   }
   
   /** @param newTelF
    * @pdOid a8eeb5d0-7ec1-4445-8663-0287cf4dab93 */
   public void setTelF(int newTelF) {
      telF = newTelF;
   }

}