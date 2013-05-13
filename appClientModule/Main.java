import java.util.Collection;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;


public class Main {
	public static void main(String[] args) {
		System.out.println("main start");

	Connection connection = new XMPPConnection("localhost");
	try {
		connection.connect();
		connection.login("test@afaneor-comp", "123");
	} catch (XMPPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Chat chat = connection.getChatManager().createChat("dima@afaneor-comp", new MessageListener() {

	    public void processMessage(Chat chat, Message message) {
	        System.out.println("Received message: " + message );
	        System.out.println("message body:"+message != null ? message.getBody() : "NULL");
	    }
	});
	try {
		chat.sendMessage("Howdy!");
	} catch (XMPPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Roster roster = connection.getRoster();
	Collection<RosterEntry> entries = roster.getEntries();
	for (RosterEntry entry : entries) {
	    System.out.println(entry);
	}
	// Assume we've created a Connection name "connection".
//	ChatManager chatmanager = connection.getChatManager();
//	chatmanager.addChatListener(
//	    new ChatManagerListener() {
//	        @Override
//	        public void chatCreated(Chat chat, boolean createdLocally)
//	        {
//	            if (!createdLocally)
//	                chat.addMessageListener(new MessageListener(){
//
//	            	    public void processMessage(Chat chat, Message message) {
//	            	        System.out.println("Received message: " + message + (message != null ? message.getBody() : "NULL"));
//	            	    }
//	                });
//	        }
//	    });
	
	// idle for 20 seconds
	  final long start = System.nanoTime();
	  while ((System.nanoTime() - start) / 1000000 < 20000) // do for 20 seconds
	  {
	    try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }	
	System.out.println("end main loop");
	connection.disconnect();
}
	/* (non-Java-doc)
	 * @see java.lang.Object#Object()
	 */
//	public Main() {
//		super();
//	}

}