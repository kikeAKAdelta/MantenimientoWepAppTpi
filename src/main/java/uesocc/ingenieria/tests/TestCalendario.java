package uesocc.ingenieria.tests;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import uesocc.ingenieria.entity.Calendario;


public class TestCalendario {
    
    private static EntityManager manager;
    
    private static EntityManagerFactory emf;
    
    public static void main(String[] args){
        //Se crea el gestor de persistencia
        emf = Persistence.createEntityManagerFactory("Mantenimiento");
        manager = emf.createEntityManager();
        
        List<Calendario> calendario = (List<Calendario>) manager.createQuery("FROM Calendario").getResultList();
        System.out.println("Hay " + calendario.size() + " datos");
    }
    
}
