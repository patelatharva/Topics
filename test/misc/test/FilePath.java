/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package misc.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author atharva
 */
public class FilePath {
    public void filepathTest() {
        try {
            String inputFileName = "/media/StoreHouse/Education/Webapplications/Code\\ and\\ SDKs/Topics/Topics/build/web/WEB-INF/classes/topics/streams/feedaggre/feedURLs.txt";
            InputStream fstream = getClass().getResourceAsStream(inputFileName);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            strLine = br.readLine();
            System.out.println(strLine);
        } catch (IOException ex) {
            //Logger.getLogger(FilePath.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File opening issue. Let's Try again.");
        }
    }
    public static void main (String [] args){
        FilePath ft = new FilePath();
        ft.filepathTest();
    }
}
