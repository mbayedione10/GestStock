package model;

/***********************************************************************
 * Module:  Users.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Users
 ***********************************************************************/

/** @pdOid 44efa9e2-cbd6-47c7-ad70-01626eb53c1b */
public class Users {
   /** @pdOid d38d638d-87fd-4d8e-8ef1-67b67aed8b10 */
   private int idUser;
   /** @pdOid 94b5970d-18a6-44f4-b103-56ff080509e6 */
   private String nomUser;
   /** @pdOid 149ce976-fd9f-4944-8800-922625f5e10c */
   private String poste;
   /** @pdOid 3de7651d-4a1c-41cb-9d6d-ef30e41207d0 */
   private String pseudo;
   /** @pdOid 90aa0718-ba59-4323-9588-f1e8ed446d24 */
   private String motDePasse;
   /** @pdOid 937288e5-be42-4534-af3a-9bdcce0ca94c */
   private int telUser;
   /** @pdOid 7b4f5bce-78f1-401a-a37e-bb185948e376 */
   private String emailUser;
   /** @pdOid 4b1a92f5-26b5-4e64-981d-c19a73924d96 */
   private String adrUser;
   
   private int privilege;

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

   
   /**
     * @return  *  @pdOid 48faa947-ed8f-442f-b37c-6f3aa52c06e4 */
   public int getIdUser() {
      return idUser;
   }
   
   /** @param newIdUser
    * @pdOid 6ae348ab-a023-4920-a5ff-f823c344edb3 */
   public void setIdUser(int newIdUser) {
      idUser = newIdUser;
   }
   
   /**
     * @return  *  @pdOid 5d07140e-4607-42aa-847f-d9b136decab4 */
   public String getNomUser() {
      return nomUser;
   }
   
   /** @param newNomUser
    * @pdOid f95050d8-ef07-40e7-aff2-71a4e128d77d */
   public void setNomUser(String newNomUser) {
      nomUser = newNomUser;
   }
   
   /**
     * @return  *  @pdOid 53fb40b6-5788-4497-9cf6-5096e65d9d1f */
   public String getPoste() {
      return poste;
   }
   
   /** @param newPoste
    * @pdOid 3d79a4be-7a1d-4386-9f1c-1803c3023c61 */
   public void setPoste(String newPoste) {
      poste = newPoste;
   }
   
   /**
     * @return  *  @pdOid dd6f8c26-93ea-48a1-9427-c6827f556c67 */
   public String getPseudo() {
      return pseudo;
   }
   
   /** @param newPseudo
    * @pdOid dcbe9d03-c96a-495c-ae6f-3ac9ca576a9a */
   public void setPseudo(String newPseudo) {
      pseudo = newPseudo;
   }
   
   /**
     * @return  *  @pdOid 97a0933d-b647-4a27-85af-f7814c1040fb */
   public String getMotDePasse() {
      return motDePasse;
   }
   
   /** @param newMotDePasse
    * @pdOid cb71fa64-e584-47f9-9b71-1e08ff77c967 */
   public void setMotDePasse(String newMotDePasse) {
      motDePasse = newMotDePasse;
   }
   
   /**
     * @return  *  @pdOid c40345a9-1eb2-4570-9044-8d4dc80ffcca */
   public int getTelUser() {
      return telUser;
   }
   
   /** @param newTelUser
    * @pdOid 40140764-12fa-46df-975c-67b5996de3e7 */
   public void setTelUser(int newTelUser) {
      telUser = newTelUser;
   }
   
   /**
     * @return  *  @pdOid f3e0124c-60eb-4dec-9624-66af69393c95 */
   public String getEmailUser() {
      return emailUser;
   }
   
   /** @param newEmailUser
    * @pdOid b998387f-3d23-4c2d-aa5c-600f98b189a2 */
   public void setEmailUser(String newEmailUser) {
      emailUser = newEmailUser;
   }
   
   /**
     * @return  *  @pdOid f6cd7b29-9288-426f-b835-32cc46989f78 */
   public String getAdrUser() {
      return adrUser;
   }
   
   /** @param newAdrUser
    * @pdOid 50c8981b-e975-4be3-8990-94cf196611c4 */
   public void setAdrUser(String newAdrUser) {
      adrUser = newAdrUser;
   }
   
   /** @pdOid 836cb60a-14e3-48ac-b679-d0394ba28ab2 */
   public Users() {
      // TODO: implement
   }

}