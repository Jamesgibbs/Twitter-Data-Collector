
import twitter4j.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class main {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
	
		Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query("Enter Query");
            query.setUntil("2013-11-25");
            QueryResult result;
            do {
                result = twitter.search(query);
               
                List<Status> tweets = result.getTweets();
           
                for (Status tweet : tweets) {
                	
                	String text = "ID:"+ tweet.getId()+"| "+tweet.getCreatedAt()+"| "+ tweet.getUser().getScreenName() + " - " + tweet.getText()+"|";
                   
                
                	try {
                	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Kate/Desktop/android_workspace/twitter/tweets-new1.txt", true)));
                	    out.println(text);
                	    out.close();
                	} catch (IOException e) {
                	    System.out.println("problem");
                	}
                }
            } while ((query = result.nextQuery()) != null);
            
            try {
        	    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/Kate/Desktop/android_workspace/twitter/tweets-new1.txt", true)));
        	    out.println("-----------------------------BREAK-----------------------------------------");
        	    out.close();
        	} catch (IOException e) {
        	    System.out.println("problem");
        	}
          
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }

	}

}
