package com.utfpr.facetruco.data;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author vitor
 */

 public class Connection {
    private static EntityManager manager;

    public synchronized static EntityManager getConnection() {
        if(manager == null)
            manager = Persistence.createEntityManagerFactory("facetruco").createEntityManager();
        return manager;       
    }

    public synchronized static void closeConnection(){
        manager.close();
    }
 }