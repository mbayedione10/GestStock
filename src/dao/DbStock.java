/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javafx.scene.control.RadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.*;

/**
 *
 * @author mamadoumbayedione
 */
public class DbStock {
    private String user = "root";
    private String password = "";
    //url d'acces a la base de donnée
    private String urlDatabase = "jdbc:mysql://localhost:3306/db_stock";
    //objet de connection a la base qui symbolisera l'instance
    private String urlDriver =  "com.mysql.jdbc.Driver";
    private Connection connect;
    
     public void connectionDB(){
        //si le try ne marche pas le programme va continuer
        try {
            //chargement des pilotes deja importés
            Class.forName(urlDriver);
                connect = DriverManager.getConnection(urlDatabase, user, password);
                System.out.println("SUCCESS, Connexion reussie");
            } catch (Exception e) {
                //sur l'éxception afficher la nature de l'erreur
                e.printStackTrace();
                System.out.println("ERROR, Connexion échouée");
        }
        
    }
     
     /*prend le login et le mdp et verification d'existence
    methode d'authentification*/
    public boolean CheckUser(String login, String password){
        try {
            //avant de verifier il faut se connecter dans la base de donnee
            connectionDB();
         
            //requete sql pour selectionner le login et le password
            String sql ="select * from users where (pseudo = ? or nomUser = ? or telUser = ?) and mdp = ?;";
            //la variable connect est renseigner a travers l'instance pour y acceder
            
            PreparedStatement st = connect.prepareStatement(sql);
            //? est une requete preparee et pour renseigner
            st.setString(1, login);
            st.setString(2, login);
            st.setString(3, login);
            st.setString(4, password);
            
            //executer la requete 
            ResultSet rs = st.executeQuery();
            //s'il ya un resultat
            if (rs.next()) {
                return true;
            }
            //sinon
            else{
                return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        }
    }
     public int PrivilegeLogin(int  id){
            int p = 0;
            try {
                connectionDB();
                String sql = "select privilege from users where idUser like'%"+id+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 p = rs.getInt("privilege");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return p;
        }
     public int idLogin(String login){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idUser from users where nomUser like'%"+login+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idUser");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
     public boolean saveUser(Users user){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `users`(`nomUser`, `fonction`, `pseudo`, `mdp`, `telUser`, `emailUser`, `adrUser`, `privilege`)  VALUES (?,?,?,?,?,?,?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, user.getNomUser());
            stm.setString(2, user.getPoste());
            stm.setString(3, user.getPseudo());
            stm.setString(4, user.getMotDePasse());
            stm.setInt(5, user.getTelUser());
            stm.setString(6, user.getEmailUser());
            stm.setString(7, user.getAdrUser());
            stm.setInt(8, user.getPrivilege());
     
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
     
    //MODIFIER un user dans la base de donnee
    public boolean updateUser(Users user){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            
            String sql = " UPDATE `users` SET `nomUser`=?,`Fonction`=?,`pseudo`=?,`telUser`=?,`emailUser`=?,`adrUser`=?,`privilege`=? WHERE `idUser`=?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, user.getNomUser());
            stm.setString(2, user.getPoste());
            stm.setString(3, user.getPseudo());
           // stm.setString(4, user.getMotDePasse());
            stm.setInt(4, user.getTelUser());
            stm.setString(5, user.getEmailUser());
            stm.setString(6, user.getAdrUser());
            stm.setInt(7, user.getPrivilege());
            stm.setInt(8, user.getIdUser());

            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteUser(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `users` WHERE `users`.`idUser` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger tous les articles
        public void loadUser(DefaultTableModel dftm, JTable jtUser){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "SELECT * FROM `users`;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idUser"));
                v.add(rs.getString("nomUser"));
                v.add(rs.getString("fonction"));
               v.add(rs.getString("pseudo"));
               //v.add(rs.getString("mdp"));
                v.add(rs.getInt("telUser"));
               v.add(rs.getString("emailUser"));
               v.add(rs.getString("adrUser"));
                v.add(rs.getInt("privilege"));
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtUser.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadUserByName(DefaultTableModel dftm, JTable jtArticle, String name){
        try {
            String sql = "select * from users WHERE `nomUsers` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idUser"));
                v.add(rs.getString("nomUser"));
                v.add(rs.getString("fonction"));
               v.add(rs.getString("pseudo"));
               v.add(rs.getString("mdp"));
                v.add(rs.getInt("telUser"));
               v.add(rs.getString("emailUser"));
               v.add(rs.getString("adrlUser"));
                v.add(rs.getInt("privilege"));
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtArticle.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

        
     //enregistrer un article dans la base de donnee
    public boolean saveArticle(Articles article){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `articles`(`nomArticle`, `designation`, `idCategorie`, idFournisseur, qte, prixU, prixT) VALUES (?,?,?,?,?,?,?)";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, article.getNomArticle());
            stm.setString(2, article.getDesignation());
            //recuperation de l'íd de la categorie
            stm.setInt(3, article.getIdCtegorie());
            stm.setInt(4, article.getIdFournisseur());
            stm.setInt(5, article.getQte());
            stm.setInt(6, article.getPrixU());
            stm.setInt(7, article.getPrixT());
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    //MODIFIER un article dans la base de donnee
    public boolean updateArticle(Articles article){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            String sql = "UPDATE `articles` SET `nomArticle`=?,`designation`=?,`idCategorie`=?, idFournisseur=?, qte=?, prixU=?, prixT=? WHERE articles.idArticle = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, article.getNomArticle());
            stm.setString(2, article.getDesignation());
            stm.setInt(3, article.getIdCtegorie());
      
            
            stm.setInt(4, article.getIdFournisseur());
            stm.setInt(5, article.getQte());
            stm.setInt(6, article.getPrixU());
            stm.setInt(7, article.getPrixT());
            stm.setInt(8, article.getIdArticle());
            
            
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
     public boolean updateArticleQte(Articles article){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            String sql = "UPDATE `articles` SET  qte=?, prixT= ? WHERE articles.idArticle = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
       
            stm.setInt(1, article.getQte());
          stm.setInt(2, article.getPrixT());
            stm.setInt(3, article.getIdArticle());
            
            
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteArticle(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `articles` WHERE `articles`.`idArticle` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger tous les articles
        public void loadArticle(DefaultTableModel dftm, JTable jtArticle){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "SELECT `idArticle`, `nomArticle`, `designation`, `qte`,prixU, prixT, `nomCategorie`, `nomFournisseur`  FROM `articles` join categories using(idCategorie) join fournisseur using(idFournisseur);";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idArticle"));
                v.add(rs.getString("nomArticle"));
                v.add(rs.getString("designation"));
                
                //qte 
               v.add(rs.getString("qte"));
                v.add(rs.getInt("prixU"));
                 v.add(rs.getInt("prixT"));
               v.add(rs.getString("nomCategorie"));
               //Fournisseur
               v.add(rs.getString("nomFournisseur"));
               
                
               
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtArticle.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadArticleByName(DefaultTableModel dftm, JTable jtArticle, String name){
        try {
            String sql = "SELECT `idArticle`, `nomArticle`, `designation`, `qte`, `nomCategorie`, `nomFournisseur`, prixU, prixT FROM `articles` join categories using(idCategorie) join fournisseur using(idFournisseur) WHERE `nomArticle` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idArticle"));
                v.add(rs.getString("nomArticle"));
                v.add(rs.getString("designation"));
                
                //qte 
               v.add(rs.getString("qte"));
               v.add(rs.getString("nomCategorie"));
               //Fournisseur
               v.add(rs.getString("nomFournisseur"));
                  v.add(rs.getInt("prixU"));
                 v.add(rs.getInt("prixT"));
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtArticle.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
         public int QteArticle(int id){
             int qte = 0;
             try {
                connectionDB();
                String sql = "select qte from articles where idArticle = "+id+";";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("qte");
                  }
             } catch (Exception e) {
             }
             return qte;
         }
           public int PrixArticle(int id){
             int prixU = 0;
             try {
                connectionDB();
                String sql = "select prixU from articles where idArticle = "+id+";";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 prixU = rs.getInt("prixU");
                  }
             } catch (Exception e) {
             }
             return prixU;
         }
             public String nomArticle(int id){
             String nomA = "";
             try {
                connectionDB();
                String sql = "select nomArticle from articles where idArticle = "+id+";";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 nomA = rs.getString("nomArticle");
                  }
             } catch (Exception e) {
             }
             return nomA;
         }
        //prendre l'id du dernier article
        public int loadidArticle(){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idArticle from articles order by idArticle desc limit 1;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idArticle");
                
                
                
                    
                }
                
            } catch (Exception e) {
            }
            return id;
        }
          public int idArticle(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idArticle from articles where nomArticle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idArticle");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
           //inserer les articles dans JCombobox
        public void listeArticle1(JComboBox liste){
            try {
                connectionDB();
                String sql = "select nomArticle from articles;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nomArticle"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
                public void listeArticle(JComboBox liste, String nom){
            try {
                connectionDB();
                String sql = "select nomArticle from articles where nomArticle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nomArticle"));
                     listeArticle1(liste);
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
       
       /* public void chargerComboBox(){
            
            try { 
            String sql = "SELECT nomCategorie  FROM `categories`;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
             while (rs.next())
             {      
                String name = rs.getString("nomCategorie");         
              //  name.addItem(rs.getString("nomCategorie"));
             }//end while
             //connection.close();
             } catch (Exception e) {
                  e.printStackTrace();
             }
        }
        */
        
        
        //enregistrer une categorie dans la base de donnee
    public boolean saveCategorie(Categories categorie){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `categories`(`nomCategorie`, `genre`) VALUES (?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, categorie.getNameCategorie());
            stm.setString(2, categorie.getGenre());
           
            
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    //MODIFIER une categorie dans la base de donnee
    public boolean updateCategorie(Categories categorie){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            String sql = "UPDATE `categories` SET `nomCategorie`=?,`genre`=? WHERE idCategorie = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, categorie.getNameCategorie());
            stm.setString(2, categorie.getGenre());
            
            
      
      
            stm.setInt(3, categorie.getIdCategories());
            
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    //supprimer une categorie
     public boolean deleteCategorie(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `categories` WHERE idCategorie = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger toutes les categories
        public void loadCategorie(DefaultTableModel dftm, JTable jtCategorie){
        try {
            String sql = "SELECT * FROM categories;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idCategorie"));
                v.add(rs.getString("nomCategorie"));
                 v.add(rs.getString("genre"));
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtCategorie.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        //inserer les categorie dans JCombobox
        public void listeCategorie(JComboBox liste, String genre){
            try {
                connectionDB();
                String sql = "select nomCategorie from categories where genre like '%"+genre+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nomCategorie"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // retourner le nom de l'article en ayant l'id
        public String nomCategorie(int id){
            String nom= "";
            try {
                 connectionDB();
                String sql = "select nomCategorie from categories where idCategorie = "+id+";";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                 while (rs.next()) {
                      //on cree un vecteur
                 nom = rs.getString("nomCategorie");
                
                
                
                    
                }
            } catch (Exception e) {
                 e.printStackTrace();
            }
            return nom;
        }
        public String genreCategorie(String nomC){
            String genre =  "";
            try {
                 connectionDB();
                String sql = "select genre from categories where nomCategorie like '%"+nomC+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                 while (rs.next()) {
                      //on cree un vecteur
                 genre = rs.getString("genre");
                 }
                
            } catch (Exception e) {
                    e.printStackTrace();
                    }
            return genre;
        }
        public int idCategorie(String nomCategorie){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idCategorie from categories where nomCategorie like '%"+nomCategorie+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idCategorie");
                
                
                
                    
                }
                
            } catch (Exception e) {
                 e.printStackTrace();
            }
            return id;
        }
        //charger les categories par nom
        public void loadCategorieByName(DefaultTableModel dftm, JTable jtCategorie, String name){
        try {
            String sql = "SELECT *  FROM `categories` WHERE `nomCategorie` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idCategorie"));
                v.add(rs.getString("nomCategorie"));
                v.add(rs.getString("genre"));
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtCategorie.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
           //enregistrer un client dans la base de donnee
    public boolean saveClient(Clients client){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `clients`(`nomClient`, `prenomClient`, addressClient, emailClient, telephoneClient) VALUES (?,?,?,?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, client.getNomClient());
            stm.setString(2, client.getPrenomClient());
            stm.setString(3, client.getAddressClient());
            stm.setString(4, client.getEmailClient());
            stm.setInt(5, client.getTelephoneClient());
           
            
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    //MODIFIER un client dans la base de donnee
    public boolean updateClient(Clients client){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            String sql = "UPDATE `clients` SET `nomClient`=?,`prenomClient`=?,`addressClient`=?,`emailClient`=?,`telephoneClient`=? WHERE idClient = ?;";
            
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, client.getNomClient());
            stm.setString(2, client.getPrenomClient());
            stm.setString(3, client.getAddressClient());
            stm.setString(4, client.getEmailClient());
            stm.setInt(5, client.getTelephoneClient());
            
            
      
      
            stm.setInt(6, client.getIdClient());
            
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    //supprimer un client
     public boolean deleteClient(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `clients` WHERE idClient = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger tous les clients
        public void loadClient(DefaultTableModel dftm, JTable jtClient){
        try {
            String sql = "SELECT * FROM clients;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idClient"));
                v.add(rs.getString("nomClient"));
                v.add(rs.getString("prenomClient"));
                v.add(rs.getString("emailClient"));
                v.add(rs.getInt("telephoneClient"));
                v.add(rs.getString("addressClient"));
                
                
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtClient.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        //charger les clients par nom
        public void loadClientByName(DefaultTableModel dftm, JTable jtClient, String name){
        try {
            String sql = "SELECT *  FROM `clients` WHERE concat(nomClient,\" \",prenomClient) LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
           
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idClient"));
                v.add(rs.getString("nomClient"));
                v.add(rs.getString("prenomClient"));
                v.add(rs.getString("emailClient"));
                v.add(rs.getInt("telephoneClient"));
                v.add(rs.getString("addressClient"));
                
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtClient.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
          public int idClient(String client){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idClient from clients where concat(nomClient,\" \", prenomClient) like'%"+client+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idClient");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
           /* public int idClientFacture(int id){
            int idC = 0;
            try {
                connectionDB();
                String sql = "select idClient from facture where idFacture = %"+id+"%;";
                PreparedStatement stm = connect.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idC = rs.getInt("idClient");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idC;
        }*/
          
           //inserer les clients dans JCombobox
        public void listeClient(JComboBox liste){
            try {
                connectionDB();
                String sql = "select concat(nomClient,\" \", prenomClient) as nomClient from clients;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nomClient"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
              //enregistrer un fournisseur dans la base de donnee
    public boolean saveFournisseur(Fournisseurs fournisseur){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `fournisseur`(`nomFournisseur`, `prenomFournisseur`, `addressFournisseur`, `emailFournisseur`, `telFournisseur`) VALUES (?,?,?,?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, fournisseur.getNomF());
            stm.setString(2, fournisseur.getPrenomF());
            stm.setString(3, fournisseur.getAddressF());
            stm.setString(4, fournisseur.getEmailF());
            stm.setInt(5, fournisseur.getTelF());
           
            
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    
    //MODIFIER un client dans la base de donnee
    public boolean updateFournisseur(Fournisseurs fournisseur){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
            String sql = "UPDATE `fournisseur` SET `nomFournisseur`=?,`prenomFournisseur`=?,`addressFournisseur`=?,`emailFournisseur`=?,`telFournisseur`=? WHERE idFournisseur = ?;";
            
            
            PreparedStatement stm = connect.prepareStatement(sql);
           stm.setString(1, fournisseur.getNomF());
            stm.setString(2, fournisseur.getPrenomF());
            stm.setString(3, fournisseur.getAddressF());
            stm.setString(4, fournisseur.getEmailF());
            stm.setInt(5, fournisseur.getTelF());
           
            
      
      
            stm.setInt(6, fournisseur.getIdFournisseur());
            
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    //supprimer un client
     public boolean deleteFournisseur(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `fournisseur` WHERE idFournisseur = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger tous les clients
        public void loadFournisseur(DefaultTableModel dftm, JTable jtFournisseur){
        try {
            String sql = "SELECT * FROM fournisseur;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idFournisseur"));
                v.add(rs.getString("nomFournisseur"));
                v.add(rs.getString("prenomFournisseur"));
                v.add(rs.getString("emailFournisseur"));
                v.add(rs.getInt("telFournisseur"));
                v.add(rs.getString("addressFournisseur"));
                
                
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtFournisseur.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        //charger les clients par nom
        public void loadFournisseurByName(DefaultTableModel dftm, JTable jtFournisseur, String name){
        try {
            String sql = "SELECT *  FROM `fournisseur` WHERE (nomFournisseur or prenomFournisseur) LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
           
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idFournisseur"));
                v.add(rs.getString("nomFournisseur"));
                v.add(rs.getString("prenomFournisseur"));
                v.add(rs.getString("emailFournisseur"));
                v.add(rs.getInt("telFournisseur"));
                v.add(rs.getString("addressFournisseur"));
                
             
                
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtFournisseur.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
         public int idFournisseur(String fournisseur){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idFournisseur from fournisseur where concat(nomFournisseur,\" \",prenomFournisseur) like '%"+fournisseur+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idFournisseur");
                
                
                
                    
                }
                
            } catch (Exception e) {
            }
            return id;
        }
         /* public void chargerComboBoxF(){
            
            try { 
            String sql = "SELECT nomFournisseur  FROM `fournisseur`;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
             while (rs.next())
             {      
                String name = rs.getString("nomFournisseur");         
              //  name.addItem(rs.getString("nomCategorie"));
             }//end while
             //connection.close();
             } catch (Exception e) {
                  e.printStackTrace();
             }
        }*/
          //inserer les fournisseurs dans JCombobox
        public void listeFournisseur(JComboBox liste, String nom){
            try {
                connectionDB();
                String sql = "select concat(nomFournisseur,\" \",prenomFournisseur) as nom from fournisseur where concat(nomFournisseur,\" \",prenomFournisseur) like '%"+nom+"%';";
                
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nom"));
                     listeFournisseur1(liste);
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public void listeFournisseur1(JComboBox liste){
            try {
                connectionDB();
                String sql = "select concat(nomFournisseur,\" \",prenomFournisseur) as nom from fournisseur;";
                
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("nom"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public boolean saveCommande(Commandes commande){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `commande`(`libelle`, `date`, `qteC`, `idArticle`, idUser, idClient)VALUES (?,?,?,?,?,?)";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, commande.getLibelle());
            stm.setString(2, commande.getDate());
            //recuperation de l'íd de la categorie
            stm.setInt(3, commande.getQte());
            stm.setInt(4, commande.getIdArticle());
            stm.setInt(5, commande.getIdUser());
            stm.setInt(6, commande.getIdClient());
            
            
        
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
        
    //MODIFIER un article dans la base de donnee
    public boolean updateCommande(Commandes commande){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
             
            String sql = "UPDATE `commande` SET `libelle`=?,`date`=?,`qteC`=?,`idArticle`=?, idClient=?, idUser =? WHERE idCommande = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, commande.getLibelle());
            stm.setString(2, commande.getDate());
            stm.setInt(3, commande.getQte());
            stm.setInt(4, commande.getIdArticle());
            stm.setInt(5, commande.getIdClient());
            stm.setInt(6, commande.getIdUser());
            stm.setInt(7, commande.getIdCommande());
                     
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteCommande(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `commande` WHERE `commande`.`idCommande` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
         public boolean deleteCommandeNom(String name){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `commande` WHERE `libelle` LIKE '%" +name+ "%' ;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            //stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    //charger toutes les commandes
        public void loadCommande(DefaultTableModel dftm, JTable jtCommande){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "select idCommande,libelle,date,nomClient,nomArticle,qteC,nomUser from commande join clients USING(idClient) JOIN articles using(idArticle) join users using(idUser);";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idCommande"));
                v.add(rs.getString("libelle"));
                v.add(rs.getString("date"));
                v.add(rs.getString("qteC"));
                
               v.add(rs.getString("nomClient"));
               v.add(rs.getString("nomArticle"));
              
               v.add(rs.getString("nomUser"));
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtCommande.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadCommandeByName(DefaultTableModel dftm, JTable jtCommande, String name){
        try {
            String sql = "select idCommande,libelle,date,nomClient,nomArticle,qteC,nomUser from commande join clients USING(idClient) JOIN articles using(idArticle) join users using(idUser) WHERE `libelle` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
                v.add(rs.getInt("idCommande"));
                v.add(rs.getString("libelle"));
                v.add(rs.getString("date"));
                v.add(rs.getString("qteC"));
                
               v.add(rs.getString("nomClient"));
               v.add(rs.getString("nomArticle"));
              
               v.add(rs.getString("nomUser"));
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtCommande.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
  
                
          public int idCommande(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idCommande from commande where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idCommande");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
           public int qteCommandeNom(String nom){
            int qte = 0;
            try {
                connectionDB();
                String sql = "select qteC from commande where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 qte = rs.getInt("qteC");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return qte;
        }
             public int qteCommande(int id){
            int idC = 0;
            try {
                connectionDB();
                String sql = "select qteC from commande where idCommande like '%"+id+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idC = rs.getInt("qteC");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idC;
        }
           //inserer les articles dans JCombobox
        public void listeCommande(JComboBox liste){
            try {
                connectionDB();
                String sql = "select libelle from commande;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("libelle"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public int idArticleCommande(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idArticle from commande where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idArticle");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
        
         public boolean saveFacture(Facture fact){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `facture`(`libelleFact`, `dateFact`, `montantFact`, `idCommande`, `idUser`,quantite, nomClient, nomArticle)  VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement stm = connect.prepareStatement(sql);
           
            stm.setString(1, fact.getLibelleFac());
            stm.setString(2, fact.getDateFac());
            stm.setInt(3, fact.getMontantFac());
            stm.setInt(4, fact.getIdCommande());
            stm.setInt(5, fact.getIdUser());
            stm.setInt(6, fact.getQte());
            stm.setString(7, fact.getNomClient());
             stm.setString(8, fact.getNomArticle());
            
            
       
        
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
        
    /*//MODIFIER un article dans la base de donnee
    public boolean updateFacture(Facture fact){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
             
            String sql = "UPDATE `facture` SET `libelleFact`=?,`dateFact`=?,`montantFact`=?,`idCommande`=?,`idUser`=?,quantite = ? , nomClient = ? WHERE `idFacture`=?;";
        
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setString(1, fact.getLibelleFac());
            stm.setString(2, fact.getDateFac());
            stm.setInt(3, fact.getMontantFac());
            stm.setInt(4, fact.getIdCommande());
            stm.setInt(5, fact.getIdUser());
             stm.setInt(6, fact.getQte());
             stm.setString(7, fact.getNomClient());
            stm.setInt(8, fact.getIdFacture());
           
            
                     
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteFacture(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `facture` WHERE `facture`.`idFacture` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }*/
    
    //charger toutes les factures
        public void loadFacture(DefaultTableModel dftm, JTable jtFacture){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "select idFacture,libelleFact,dateFact, quantite,montantFact, nomClient, nomArticle, nomUser from facture f  join users u on(f.idUser=u.idUser);";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idFacture"));
                v.add(rs.getString("libelleFact"));
                v.add(rs.getString("dateFact"));
                v.add(rs.getInt("quantite"));
                v.add(rs.getInt("montantFact"));
                v.add(rs.getString("nomArticle"));
                v.add(rs.getString("nomClient"));
               v.add(rs.getString("nomUser"));
               
              
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtFacture.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadFactureByName(DefaultTableModel dftm, JTable jtFacture, String name){
        try {
            String sql = "select idFacture,libelleFact,dateFact, quantite,montantFact, nomClient, nomArticle, nomUser from facture f  join users u on(f.idUser=u.idUser) WHERE `libelleFact` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
                 v.add(rs.getInt("idFacture"));
                v.add(rs.getString("libelleFact"));
                v.add(rs.getString("dateFact"));
                v.add(rs.getInt("quantite"));
                v.add(rs.getInt("montantFact"));
                v.add(rs.getString("nomArticle"));
                v.add(rs.getString("nomClient"));
               v.add(rs.getString("nomUser"));
               
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtFacture.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
  public String nomClientCommande(String nom){
            String nomClient = "";
            try {
                connectionDB();
                String sql = "select concat(nomClient, ' ',prenomClient) as nom from commande c join clients cl on (c.idClient = cl.idClient) where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 nomClient = rs.getString("nom");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return nomClient;
        }
                
          public int idFacture(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idFacture from facture where nomFacture like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idFacture");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
           //inserer les articles dans JCombobox
        public void listeFacture(JComboBox liste){
            try {
                connectionDB();
                String sql = "select libelle from facture;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("libelle"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
          public boolean saveStock(Stock stock){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `stock`(`qteStock`, `MontantStock`, `nomArticle`) VALUES (?,?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(1, stock.getQteStock());
            stm.setInt(2, stock.getMontantStock());
            //recuperation de l'íd de l'article
            stm.setString(3, stock.getNomArticle());
            
            
        
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
        
    //MODIFIER un article dans la base de donnee
    public boolean updateStock(Stock stock){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
             
            String sql = "UPDATE `stock` SET `qteStock`=?,`MontantStock`=?,`nomArticle`=? WHERE 1 WHERE `idStock` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            
            stm.setInt(1, stock.getQteStock());
            stm.setInt(2, stock.getMontantStock());
            //recuperation de l'íd de l'article
            stm.setString(3, stock.getNomArticle());
             stm.setInt(4, stock.getIdStock());
                     
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteStock(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `stock` WHERE `stock`.`idStock` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
      }
     public int qteStock(int id){
            int idC = 0;
            try {
                connectionDB();
                String sql = "select qteStock from stock where idStock like '%"+id+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idC = rs.getInt("qteStock");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idC;
        }
     public int montantStock(String name){
            int montant = 0;
            try {
                connectionDB();
                String sql = "select montantStock from stock where nomArticle like '%"+name+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 montant = rs.getInt("montantStock");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return montant;
        }
       public int idStockArticle(String nom){
            int idA = 0;
            try {
                connectionDB();
                String sql = "select idStock from stock where nomArticle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idA = rs.getInt("idStock");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idA;
        }
    
    //charger toutes les commandes
        public void loadStock(DefaultTableModel dftm, JTable jtStock){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "select idStock,qteStock,MontantStock,nomArticle from stock;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idStock"));
                v.add(rs.getInt("qteStock"));
                v.add(rs.getInt("MontantStock"));
               v.add(rs.getString("nomArticle"));
               
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtStock.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadStockByName(DefaultTableModel dftm, JTable jtStock, String name){
        try {
            String sql = "select idStock,qteStock,MontantStock,nomArticle from stock WHERE `nomArticle` LIKE '%" +name+ "%';";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
                v.add(rs.getInt("idStock"));
                v.add(rs.getInt("qteStock"));
                v.add(rs.getInt("MontantStock"));
               v.add(rs.getString("nomArticle"));
               
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtStock.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
           public boolean saveEStock(EtatStock etatStock){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "INSERT INTO `etatstock`(`qteEStock`, `MontantEStock`, `nomEArticle`) VALUES (?,?,?);";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            stm.setInt(2, etatStock.getMontantEStock());
            stm.setInt(1, etatStock.getQteEStock());
            //recuperation de l'íd de l'article
            stm.setString(3, etatStock.getNomEArticle());
            
            
        
            
            //inserer dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
        
    //MODIFIER un article dans la base de donnee
    public boolean updateEStock(EtatStock stock){
       
        try {
            //ecrire une requete sql
             connectionDB();
            //requete sql pour la modification
             
            String sql = "UPDATE `etatStock` SET `qteEStock`=?,`MontantEStock`=?,`nomEArticle`=? WHERE `idES` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);
            
            stm.setInt(1, stock.getQteEStock());
            stm.setInt(2, stock.getMontantEStock());
            //recuperation de l'íd de l'article
            stm.setString(3, stock.getNomEArticle());
             stm.setInt(4, stock.getIdEStock());
                     
            
            //inserer  dans la base de donnee
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
      public boolean deleteEStock(int id){
       
        try {
            //ecrire une requete sql
             connectionDB();
            String sql = "DELETE FROM `etatStock` WHERE `idES` = ?;";
            
            PreparedStatement stm = connect.prepareStatement(sql);

            stm.setInt(1,id);
            
            
            //supprimer dans la base de donnee
            
            
            stm.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
      }
     public int qteEStock(int id){
            int idC = 0;
            try {
                connectionDB();
                String sql = "select qteEStock from etaStock where idES like '%"+id+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idC = rs.getInt("qteEStock");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idC;
        }
     public int montantEStock(String name){
            int montant = 0;
            try {
                connectionDB();
                String sql = "select montantEStock from etatStock where nomEArticle like '%"+name+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 montant = rs.getInt("montantEStock");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return montant;
        }
       public int idEStockArticle(String nom){
            int idA = 0;
            try {
                connectionDB();
                String sql = "select idES from etatStock where nomEArticle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idA = rs.getInt("idES");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idA;
        }
    
    //charger toutes les commandes
        public void loadEStock(DefaultTableModel dftm, JTable jtStock){
        try {
            //prendre le nom de la categorie et le nom du fournisseur
            String sql = "select idES,qteEStock,MontantEStock,nomEArticle from etatStock;";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
                //insertion des lignes dans le vecteur
              
                v.add(rs.getInt("idES"));
                v.add(rs.getInt("qteEStock"));
                v.add(rs.getInt("MontantEStock"));
               v.add(rs.getString("nomEArticle"));
               
                //chargement du vecteur dans le dftm
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtStock.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
        public void loadEStockByNameArticle(DefaultTableModel dftm, JTable jtStock, String name){
        try {
            String sql = "select idES,qteEStock,MontantEStock,nomEArticle from etatStock WHERE `nomEArticle` LIKE '%" +name+ "%'";
            connectionDB();
            PreparedStatement stm = connect.prepareStatement(sql);
            //stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            //tant qu'il y a un resultat
            while (rs.next()){
                
                //on cree un vecteur
                Vector v = new Vector();
      //insertion des lignes dans le vecteur
                v.add(rs.getInt("idES"));
                v.add(rs.getInt("qteEStock"));
                v.add(rs.getInt("MontantEStock"));
               v.add(rs.getString("nomEArticle"));
               
                //et on l'ajoute dans la dftm
                dftm.addRow(v);
                
            }
            
                    //ON BRANCHE LE dftm dans jtStudent
            jtStock.setModel(dftm);
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
             /*   
          public int idCommande(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idCommande from commande where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idCommande");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
             public int qteCommande(int id){
            int idC = 0;
            try {
                connectionDB();
                String sql = "select qteC from commande where idCommande like '%"+id+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 idC = rs.getInt("qteC");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return idC;
        }
           //inserer les articles dans JCombobox
        public void listeCommande(JComboBox liste){
            try {
                connectionDB();
                String sql = "select libelle from commande;";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                     liste.addItem(rs.getString("libelle"));
                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        public int idArticleCommande(String nom){
            int id = 0;
            try {
                connectionDB();
                String sql = "select idArticle from commande where libelle like '%"+nom+"%';";
                PreparedStatement stm = connect.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                  while (rs.next()) {
                      //on cree un vecteur
                 id = rs.getInt("idArticle");
                
                
                
                    
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            return id;
        }
      
      */
      //pour appeler la fonction main psvm
    public static void main(String[] args) {
        DbStock db = new DbStock();
        db.connectionDB();
         DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        
        
    }
    
    
    
}
