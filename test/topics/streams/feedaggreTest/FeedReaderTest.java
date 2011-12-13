/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package topics.streams.feedaggreTest;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.streams.feedaggre.FeedReader;

/**
 *
 * @author atharva
 */
public class FeedReaderTest {
    public static void main (String[] args){
        FeedReader fr = new FeedReader();
        String fs = File.separator;
        String filename = "feedURLs.txt";
        /**
         * @TODO find appropriate method to mention the filepath in java
         */
        //String filename = "/media/StoreHouse/Education/Webapplications/Code and SDKs/Topics/Topics/test/topics/streams/feedaggreTest/feedURLs.txt";
        try {
            fr.readURLs(filename);
        } catch (Exception ex) {

            System.out.println("ERROR while reading URLs"+ex.getMessage());
            //Logger.getLogger(FeedReaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        fr.readFeeds();
        fr.printFeeds();
        
    }
}
