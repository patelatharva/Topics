/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.streamaggre.rssaggreTest;

import topics.streamaggre.rssaggre.Feed;
import topics.streamaggre.rssaggre.FeedMessage;
import topics.streamaggre.rssaggre.RSSFeedParser;

/**
 *
 * @author Atharva
 */
public class RSSReadTest {
    public static void main(String[] args) {
		/* RSSFeedParser parser = new RSSFeedParser(
				"http://www.vogella.de/article.rss");*/
                RSSFeedParser parser = new RSSFeedParser("http://rss.cnn.com/rss/edition.rss");
		Feed feed = parser.readFeed();
		System.out.println(feed);
		for (FeedMessage message : feed.getMessages()) {
			System.out.println(message);

		}

	}
}
