package JUnitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import javax.swing.DefaultListModel;

import org.junit.Test;

import BDA.Email;
import BDA.Mail;

public class LoginMail {

	@Test
	public void test() {
		
		String email="darfo@iscte-iul.pt";
		String pass="EngenhariaSoftware98";
		
		DefaultListModel<Email> mail=Mail.LoginMail(email, pass);
		assertEquals(20, mail.size());
		
	}

}
