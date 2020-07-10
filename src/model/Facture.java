package model;

/***********************************************************************
 * Module:  Facture.java
 * Author:  MbayeDione
 * Purpose: Defines the Class Facture
 ***********************************************************************/

import java.util.*;

/** model facture
 * 
 * @pdOid a55a2e33-316a-4411-b442-cc4944f3fbb3 */
public class Facture {
   /** @pdOid 9e33912c-4f3a-4877-8142-bb2384b69f6b */
   private int idFacture;
   /** @pdOid 17fd3a5d-38b1-4f19-a38d-640e28a9da3b */
   private String libelleFac;
   private int idUser;
  /** @pdOid d8b5ff4b-1427-4008-aa43-26b24e709013 */
   private String dateFac;
   /** @pdOid 5761056b-53be-46e5-b2c7-b97af6eb1725 */
   private int montantFac;
   private int idCommande;
   private String nomClient;
   private String nomArticle;
   private int qte;

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }


    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
   
   /** @pdRoleInfo migr=no name=Users assc=editer coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Users> users;
   
   /**
     * @return  *  @pdOid ed45c548-3834-4ed6-aedb-b5157fd9a7f7 */
   public int getIdFacture() {
      return idFacture;
   }
   
   /** @param newIdFacture
    * @pdOid 6dcafcf2-4088-414b-aefa-ba47a3f123fe */
   public void setIdFacture(int newIdFacture) {
      idFacture = newIdFacture;
   }
   
   /**
     * @return  *  @pdOid 36be7970-5658-4a28-b70e-27589b63548f */
   public String getLibelleFac() {
      return libelleFac;
   }
   
   /** @param newLibelleFac
    * @pdOid ed0fa72a-1c20-4160-8e1b-ee89df6f1252 */
   public void setLibelleFac(String newLibelleFac) {
      libelleFac = newLibelleFac;
   }
   
  
   /**
     * @return  *  @pdOid 97ae79d6-2cbd-4a8f-8bb6-7fd1ac91638d */
   public int getMontantFac() {
      return montantFac;
   }
   
   /** @param newMontantFac
    * @pdOid 5e7525c5-0eb8-4831-a02e-29b51a4b5298 */
   public void setMontantFac(int newMontantFac) {
      montantFac = newMontantFac;
   }
   
   
   /**
     * @return  *  @pdGenerated default getter */
   public java.util.Collection<Users> getUsers() {
      if (users == null)
         users = new java.util.HashSet<>();
      return users;
   }
   
   /**
     * @return  *  @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorUsers() {
      if (users == null)
         users = new java.util.HashSet<>();
      return users.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newUsers */
   public void setUsers(java.util.Collection<Users> newUsers) {
      removeAllUsers();
      for (java.util.Iterator iter = newUsers.iterator(); iter.hasNext();)
         addUsers((Users)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newUsers */
   public void addUsers(Users newUsers) {
      if (newUsers == null)
         return;
      if (this.users == null)
         this.users = new java.util.HashSet<>();
      if (!this.users.contains(newUsers))
         this.users.add(newUsers);
   }
   
   /** @pdGenerated default remove
     * @param oldUsers */
   public void removeUsers(Users oldUsers) {
      if (oldUsers == null)
         return;
      if (this.users != null)
         if (this.users.contains(oldUsers))
            this.users.remove(oldUsers);
   }

    public String getDateFac() {
        return dateFac;
    }

    public void setDateFac(String dateFac) {
        this.dateFac = dateFac;
    }
   
   /** @pdGenerated default removeAll */
   public void removeAllUsers() {
      if (users != null)
         users.clear();
   }

}