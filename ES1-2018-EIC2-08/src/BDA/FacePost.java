package BDA;

import java.util.Date;
import com.restfb.types.Post;


	/** 
	 * Object that represents a post.
	 *
	 */

public class FacePost {

	private int id;
	private String message;
	private Post post;
	private Date date;
	private String story;
	
	/**
	 * Constructor, it initializes all attributes: id, message, post, date and story.
	 * 
	 * @param p				The post from Facebook that contains all the information needed.
	 * @param counter		The number that will serve has the id from the FacePost.
	 */
	
	public FacePost (Post p, int counter){
		post=p;
		id=counter;
		message=post.getMessage();
		date=post.getCreatedTime();
		story=post.getStory();
	}
		
	/**
	 * Contructor, Creates a facebook post with given parameters
	 * @param id post id
	 * @param message post message
	 * @param story post story
	 * @param date post date
	 */
	
	public FacePost(String id, String message, String story, String date) {
		// TODO Auto-generated constructor stub
		this.id=Integer.valueOf(id);
		this.message=message;
		this.story=story;
		this.date=new Date(Long.valueOf(date));
		
	}

	@Override
	public String toString() {
		return "<html> FacePost: "+ id +"<br/>Date:"+date+"<br/Story:"+story;
	}

	/**
	 * 
	 * @return		Returns the id number of the FacePost.
	 */
	
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return		Returns the message of the FacePost.
	 */
	
	public String getMessage() {
		return message;
	}
	
	/**
	 * 
	 * @return		Returns the story of the FacePost.
	 */
	
	public String getStory() {
		return story;
	}
	
	/**
	 * 
	 * @return		Returns the post of the FacePost.
	 */
	
	public Post getPost() {
		return post;
	}

	/**
	 * 
	 * @return		Returns the date of the FacePost.
	 */
	
	public Date getDate() {
		return date;
	}
}
