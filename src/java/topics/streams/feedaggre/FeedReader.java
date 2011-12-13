/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.streams.feedaggre;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atharva
 */
public class FeedReader {

    private List<URL> feedURLs;
    private List<SyndEntryImpl> entries;

    public FeedReader() {
        this.entries = new ArrayList<SyndEntryImpl>();
        this.feedURLs = new ArrayList<URL>();
    }

    /**
     *
     * @param filename path for the file which contains the URLs of the feeds
     * make sure it uses proper file path separator according to the 
     * opearting system environment
     * @throws Exception
     */
    public void readURLs(String filename) {
        if (filename == null) {
            try {
                throw new Exception("please mention a valid filename from which to read the URLs");
            } catch (Exception ex) {
                Logger.getLogger(FeedReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                InputStream fstream = getClass().getResourceAsStream(filename);
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                System.out.println("Opened the feed input file successfully");
                String strLine = "";
                //strLine = br.readLine();
                //System.out.println(strLine);
                while ((strLine = br.readLine()) != null && strLine.compareTo("") != 0) {
                    System.out.println("Trying to add URL:" + strLine);
                    URL feedURL = new URL(strLine);
                    boolean add = feedURLs.add(feedURL);
                }
                System.out.println("Added number of URLs:" + feedURLs.size());
                //in.close();
            } catch (Exception ex) {
                System.out.println("Error detected.");
            }
        }
    }

    public void readFeeds() {
        SyndFeedInput input = new SyndFeedInput();
        for (int i = 0; i < feedURLs.size(); i++) {
            try {
                SyndFeed feed = input.build(new XmlReader((URL) feedURLs.get(i)));
                List<SyndEntryImpl> tempEntries = feed.getEntries();
                for (SyndEntryImpl entry : tempEntries) {
                    entries.add(entry);
                }
                /**
                 * @TODO insert the feed entries into appropriate database for
                 * each URL
                 */
            } catch (Exception ex) {
                System.err.println("Error in reading feed from a URL: "+feedURLs.get(i));
                
            }
        }
    }

    public void printFeeds() {
        for (SyndEntry entry : this.entries) {
            System.out.println(entry);
        }
    }

    public static void main(String[] args) {
        /**
         * @TODO write a JUnit test code for FeedReader class
         */
        FeedReader fr = new FeedReader();

    }
}
