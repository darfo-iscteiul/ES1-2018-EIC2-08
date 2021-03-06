package BDA;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class that changes name of the BDA account.
 */


public class ChangeName {
	private	JFrame launcher;
	private String email;
	
	
	/**
	 * Class that allows the user to change his password.
	 * @param email		The User's Login mail of the BDA application.
	 */
	
	public ChangeName(String email){
		this.email=email;
		init();
	}

	/**
	 * Gets the frame
	 * @return		Returns the JFrame
	 */
	public JFrame getLauncher() {
		return launcher;
	}

	/**
	 * Gets the email
	 * @return		Returns the user email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Launches and builds the change password window.
	 * Initiates the frame components (JLabel,	JTextField, and JButton).
	 * Adds an actionlistener to the button.
	 * Puts everything in the correct positions.
	 */

	public void init() {
		// SettingsJFrame
		launcher = new JFrame("BOM DIA ACADEMIA!");
		launcher.setResizable(false);
		launcher.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		launcher.setVisible(true);

		// Dar Refresh

		launcher.pack();
		launcher.setSize(800, 600);

		//Background
		launcher.setContentPane(new JLabel(new ImageIcon("images\\background.png")));
		
		//Imagens
		JLabel logo=new JLabel(new ImageIcon("images\\logo.png"));
		//JLabel signup=new JLabel(new ImageIcon("images\\signup.png"));
		
		launcher.setLayout(new GridLayout(1,2));
		JPanel signform= new JPanel();
		signform.setOpaque(false);
		signform.setLayout(null);
		
		
		
		
		 
		  JLabel l1 = new JLabel("New Name");
		  
		  Cursor cur=new Cursor(Cursor.HAND_CURSOR);
		 
		  JTextField newName = new JTextField();
		 
		  
		  JButton btn1 = new JButton("Done");
		  btn1.setCursor(cur);
		  
		  //signup.setBounds(35,-50,400,400);
		  l1.setForeground(Color.black);
		 		  		  
		  l1.setBounds(100, 180, 200, 30);
		  newName.setBounds(100, 230, 200, 30);
		  		 
		  btn1.setBounds(160, 430, 100, 30);
		  
		  //signform.add(signup);
		  signform.add(l1);
		  signform.add(newName);
		  signform.add(btn1);
		

		
		launcher.add(logo);
		launcher.add(signform);
	
		//Dar Refresh
		launcher.setSize(799,599);
		launcher.setSize(800,600);
		
		
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!newName.getText().equals("")) {
					change(newName.getText());
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "You must insert a name");
				}
			}
		});
	}

	
	/**
	 *It changes the user name and closes the window.
	 *Saves the changes in the XML file.
	 * 
	 * @param name		The user new name.
	 */
	public void change(String name) {
		File file = new File("config.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();

			NodeList list = doc.getChildNodes().item(0).getChildNodes();
			for (int count = 0; count < list.getLength(); count++) {
				Node tempNode = list.item(count);
				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
					if (tempNode.hasAttributes()) {
						if (((Element) tempNode).getAttribute("Email").equals(email)) {
							((Element) tempNode).setAttribute("Name", name);
							launcher.dispose();
							break;
						}
					}
				}
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
	         transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	         StreamResult result = new StreamResult(new FileOutputStream("config.xml"));
	         DOMSource source = new DOMSource(doc);
	         transformer.transform(source, result);
		} catch (ParserConfigurationException | SAXException | IOException | TransformerFactoryConfigurationError | TransformerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
	}
}
