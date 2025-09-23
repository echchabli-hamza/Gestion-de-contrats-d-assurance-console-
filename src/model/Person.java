package model;

abstract public class Person {

    private String nom ;
    private String prenom ;
    private String email;


    public Person (String nom , String prenom , String email ){


        this.nom = nom ;
        this.prenom = prenom ;

        this.email = email;



    }


    public String getNom(){
        return this.nom;

    }

    public void setNom(String newNom){

        this.nom = newNom;

    }

    public String getPernom(){

        return this.prenom;
    }

    public void setPrenom(String newPrenom){
        this.prenom = newPrenom ;
    }


    public String getEmail(){
        return this.email ;

    }

    public void setEmail(String newEmail){

        this.email = newEmail ;

    }

    public String toString(){
        return "Nom : " + this.nom + "/ Prenom : " + this.prenom + " / Email : " +this.email ;
    }



}
