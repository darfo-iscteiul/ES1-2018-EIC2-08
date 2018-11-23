package JUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.swing.JList;

import org.junit.jupiter.api.Test;

import BDA.T;
import BDA.TwitterApp;
import BDA.Background;
import twitter4j.TwitterException;

class TwitterTimeLine_init {

	@Test
	void test() {
		TwitterApp ta = new TwitterApp("djruORHuSHJcsJW060wtuGowg","LzofRAO9R7a8sZIDofWXoix6gtXiS43MzFsrFrlqiIeKo66Ly5","1063486441114820608-2pujB6rSntopZvEd6ENTrt3gOPspgv","DTB1yFxV0pelfd9BlbBbYar6GE34rbGHA6ceDBs0beCnd");
		JList tweets= null;
		try {
			tweets=new JList<T>(ta.getTimeline());
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(ta);
		assertNotNull(tweets);
		

//		frame
		Background background=null;
		try {
			background=new Background("images/twittertimeline.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(background);
	}

}
