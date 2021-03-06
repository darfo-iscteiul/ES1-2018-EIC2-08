package BDA;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import twitter4j.TwitterException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;

/**
 * Class that filters lists by containing certain words
 *
 */

@SuppressWarnings("serial")
public class ContainsFilter extends JFrame {

	
	private JPanel contentPane;
	private JTextField textField;
	private JList<FacePost>facePosts;
	private JList<Email> emails;
	private JList<T> tweets;

	
	/**
	 * Create the frame.
	 * @param tweets list of tweets
	 * @param emails list of emails
	 * @param facePosts list of posts
	 */
	public ContainsFilter(JList<FacePost> facePosts, JList<Email> emails, JList<T> tweets) {
		this.facePosts=facePosts;
		this.emails=emails;
		this.tweets=tweets;
		setTitle("Contains Filter");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 77);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Filter");
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					containsFilter(textField.getText());
				} catch (TwitterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}});
		setVisible(true);
	}
	
	/**
	 * Filter 3 lists by a certain word
	 * @param s word to search
	 * @throws TwitterException Twitter exception
	 */
	
	public void containsFilter(String s) throws TwitterException {
		DefaultListModel<Email> e = new DefaultListModel<>();
		DefaultListModel<FacePost> f = new DefaultListModel<>();
		DefaultListModel<T> t = new DefaultListModel<>();

		for (int i = 0; i < tweets.getModel().getSize(); i++) {
			if (tweets.getModel().getElementAt(i).getText().contains(s)) {
				t.addElement(tweets.getModel().getElementAt(i));
			}
		}
		for (int j = 0; j < emails.getModel().getSize(); j++) {
			if (emails.getModel().getElementAt(j).getBody().contains(s)) {
				e.addElement(emails.getModel().getElementAt(j));
			}
		}

		for (int k = 0; k < facePosts.getModel().getSize(); k++) {
			if (facePosts.getModel().getElementAt(k).getMessage().contains(s)) {
				f.addElement(facePosts.getModel().getElementAt(k));
			}
		}

		emails.setModel(e);
		facePosts.setModel(f);
		tweets.setModel(t);
	}

	/**
	 * Get the facebook posts
	 * @return list of facebook posts
	 */
	
	public JList<FacePost> getFacePosts() {
		return facePosts;
	}

	/**
	 * Get the emails
	 * @return list of emails
	 */
	
	public JList<Email> getEmails() {
		return emails;
	}

	/**
	 * Get the tweets
	 * @return list of tweets
	 */
	
	public JList<T> getTweets() {
		return tweets;
	}

	
	
}

