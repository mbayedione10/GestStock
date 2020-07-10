package model;

/***********************************************************************
 * Module:  Clients.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Clients
 ***********************************************************************/

/** @pdOid ab76766a-2062-44b4-9494-032b89fe512f */
public class Clients {
   /** @pdOid eba84f36-e1ec-41f2-b114-2b904b1626bc */
   private String nomClient;
   /** @pdOid fa024f64-d089-43b4-8ff0-393d5a936713 */
   private String prenomClient;
   /** @pdOid b24bb093-f454-4324-962c-2cf518d5c021 */
   private String addressClient;
   /** @pdOid 52fed368-3efb-4172-8947-665c30fb4f14 */
   private String emailClient;
   /** @pdOid 7df792ff-c9a9-4a15-bc92-88515b46c482 */
   private int telephoneClient;
   
   /** @pdOid e7a2dce7-0375-42a1-8b0c-6e183adde7b4 */
   public int idClient;
   
   /** @pdRoleInfo migr=no name=Commandes assc=passer mult=1..1 */
   public Commandes commandes;
   
   /**
     * @return  *  @pdOid 21483ceb-35a5-4c69-9456-342b269345df */
   public int getIdClient() {
      return idClient;
   }
   
   /** @param newIdClient
    * @pdOid 7e94d5ee-2445-4422-87b4-9e19674a7a38 */
   public void setIdClient(int newIdClient) {
      idClient = newIdClient;
   }
   
   /**
     * @return  *  @pdOid 1f839d3a-4748-46fa-a445-86964ed429dc */
   public String getNomClient() {
      return nomClient;
   }
   
   /** @param newNomClient
    * @pdOid 5bd4d67b-318e-4718-b325-b311a5194e9e */
   public void setNomClient(String newNomClient) {
      nomClient = newNomClient;
   }
   
   /**
     * @return  *  @pdOid 9e614664-6323-4b33-80d0-cc101943f6a7 */
   public String getPrenomClient() {
      return prenomClient;
   }
   
   /** @param newPrenomClient
    * @pdOid af6e9348-e9de-44b4-84ed-278add8aa1f7 */
   public void setPrenomClient(String newPrenomClient) {
      prenomClient = newPrenomClient;
   }
   
   /**
     * @return  *  @pdOid dfd8efff-1d15-4ccb-801c-c943e7cf395c */
   public String getAddressClient() {
      return addressClient;
   }
   
   /** @param newAddressClient
    * @pdOid 92edc03e-2751-4002-9af5-7e09e014be93 */
   public void setAddressClient(String newAddressClient) {
      addressClient = newAddressClient;
   }
   
   /**
     * @return  *  @pdOid 41000cb8-a9a6-4e71-a239-e788ce4767e1 */
   public String getEmailClient() {
      return emailClient;
   }
   
   /** @param newEmailClient
    * @pdOid aeda8134-144d-452e-8688-554dd8c59c16 */
   public void setEmailClient(String newEmailClient) {
      emailClient = newEmailClient;
   }
   
   /**
     * @return  *  @pdOid 051be476-1144-43ef-8693-2d99f46af349 */
   public int getTelephoneClient() {
      return telephoneClient;
   }
   
   /** @param newTelephoneClient
    * @pdOid e24e3ce0-304a-4940-8532-38c9be48315e */
   public void setTelephoneClient(int newTelephoneClient) {
      telephoneClient = newTelephoneClient;
   }

}