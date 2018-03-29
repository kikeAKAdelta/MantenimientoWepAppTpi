package uesocc.ingenieria.tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import uesocc.ingenieria.entity.Calendario;


public class TestCalendario {
    
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    
    public static void main(String[] args){
        //Se crea el gestor de persistencia
        Persistence.createEntityManagerFactory("Mantenimiento");
        manager = emf.createEntityManager();
        
        List<Calendario> calendario = (List<Calendario>) manager.createNamedQuery("FROM calendario").getResultList();
        System.out.println("Hay" +calendario + " datos");
    }
    
}
