package topics.dba.mongodb;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Object of this class will store all the Mongo instances being used by application
 * @TODO We should remove this bottlenack soon by not relying just one object to store
 * all the details about the open mongo connections
 * @TODO Take care of the load balancing for mongo instances; either take care
 * of load balancing inside this class or in new separate class
 * @author atharva
 */
public class MongoInstanceStore {

    private List<Mongo> mongoInstances;

    MongoInstanceStore() {
        mongoInstances = new ArrayList<Mongo>();
    }

    /**
     * 
     */
    public Mongo createNewMongoInstance() {
        Mongo m = null;
        try {
            /**
             * @TODO Provide authentication if required
             */
            m = new Mongo();
            boolean add = mongoInstances.add(m);
            if (add==false){
                Logger.getLogger(MongoInstanceStore.class.getName()).log(Level.SEVERE, "The mongoInstance list could not add a new Mongo instance");
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(MongoInstanceStore.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MongoException ex) {
            Logger.getLogger(MongoInstanceStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            return m;
        }

    }

    /**Returns an active Mongo access instance
     *
     * @TODO We can apply load balancing code here or in external class we 
     * also synchrosnize this method if required in order to take care of 
     * concurrency while trying the get Mongo instance
     *
     * @return
     */
    public Mongo getMongoInstance() {
        /*Write now this method returns the last instance added in the mongo
        MongoInstances list. This is very hasty solution and need to improve
         */
        if (mongoInstances.isEmpty()) {
            return createNewMongoInstance();
        } else {
            return mongoInstances.get(mongoInstances.size() - 1);
        }
    }
}
