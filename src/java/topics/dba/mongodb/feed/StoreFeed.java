/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topics.dba.mongodb.feed;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.WriteResult;
import com.sun.syndication.feed.synd.SyndFeed;
import topics.dba.mongodb.DBManager;

/**
 * Contains the methods to store the feeds in to the database
 * @author atharva
 */
public class StoreFeed {
DBManager dbmanager;
DB db;
    /**
     *
     * @param dbmanager
     */
    StoreFeed(DBManager dbmanager){
        this.dbmanager=dbmanager;
        this.db = dbmanager.getDB();
    }
    public boolean storeFeed(SyndFeed feed){
        boolean stored = false;
        BasicDBObject feedDoc = new BasicDBObject();
        if(feed.getTitle()!=null){
            feedDoc.append("title",feed.getTitle());
        }
        if(feed.getLink()!=null){
            feedDoc.append("link", feed.getLink());
        }
        if(feed.getDescription()!=null){
            feedDoc.append("description",feed.getDescription());
        }
        
        /**
         * @TODO Similarly as above fill up the remaining attributes in the
         * feedDoc before storing it. Storing SyndImage may require some special
         * care. Check it out! May be we have to store that image in some other
         * database than mongodb
         */
        DBCollection feedsCollection = db.getCollection("All feeds");
        WriteResult insert = feedsCollection.insert(feedDoc);
        if(insert.getError()==(null)){
            return true;
        }
        return false;
    }
}
