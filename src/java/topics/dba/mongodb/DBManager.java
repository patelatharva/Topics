/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.dba.mongodb;

import com.mongodb.DB;
import com.mongodb.Mongo;

/**
 * Initializes the Mongodb initializes the database connection with specified
 * database string name
 * 
 * @author atharva
 */
public class DBManager {

    MongoInstanceStore mongoStore;
    DB db;

    /**
     * @TODO Store the list of the dbname, username and password in a list
     * for all the database connections are currently active
     */
    /**
     * Constructor of DBManager without authentication
     * @param nameofdb the name of the mongodb database with which to make connection
     */
    DBManager(String dbname) throws Exception {
        mongoStore = new MongoInstanceStore();
        Mongo m = mongoStore.getMongoInstance();
        db = m.getDB(dbname);
        if (db == null) {
            throw (new Exception("Couldn't find the db with name:" + dbname));
        } else {
            /**
             * @TODO Store the live database connections in the array
             */
        }
    }

    public DBManager(String dbname, String username, String passwd) throws Exception {
        mongoStore = new MongoInstanceStore();
        Mongo m = mongoStore.getMongoInstance();
        db = m.getDB(dbname);
        boolean authenticate = db.authenticate(username, passwd.toCharArray());
        if (authenticate == false) {
            throw (new Exception("DB authentication failed for\n username: "
                    + "" + username + "password: " + passwd));
        } else {
            /**
             * @TODO Store the live database connections in the array
             */
        }
    }

    public DB getDB() {
        return db;
    }
}
