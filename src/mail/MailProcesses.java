/*
 * ChatWorkを用いて、何月何日何時にTwitter広告のステータスを
 * On/Offにしたことを通知する。
 */
package mail;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

import org.sikuli.script.Screen;

import upper.Processes;

public class MailProcesses extends Processes {
	Screen screen = new Screen();
	String groupName = "TwitterAdNotification";
	boolean flag;
	ArrayList<MailProcesses> processChain = new ArrayList();
	LocalDateTime processdate = LocalDateTime.now();
	
	public MailProcesses(boolean flag) {
		this.flag=flag;
	}
	public MailProcesses() {	}

	@Override
	public boolean process() {
		// TODO 自動生成されたメソッド・スタブ
		MailProcesses LiM = new LoginMail();
		MailProcesses MM = new MainMail(this.flag);
		MailProcesses LoM = new LogoutMail();
		this.processChain.add(LiM);
		this.processChain.add(MM);
		this.processChain.add(LoM);
		Iterator<MailProcesses> it = this.processChain.iterator();
		while(it.hasNext()) {
			it.next().process();
		}
		
		return true;
	}
	
	void waitClick(String imgAdress) {
		try {
			Thread.sleep(500);
			super.clickRepeat(this.screen, imgAdress,3);
		}catch(Exception e) {
		}
	}
	void wait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
