/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.streamaggre.rssaggre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Atharva
 */
public class GetURL {

    public static void main(String args[]) {
        try {
            URL rssfeed = new URL("http://rss.cnn.com/rss/edition.rss");
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(rssfeed.openStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }

                in.close();
            } catch (IOException ex) {
                Logger.getLogger(GetURL.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(GetURL.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
