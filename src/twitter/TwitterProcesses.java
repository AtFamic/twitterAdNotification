package twitter;

import java.util.ArrayList;
import java.util.Iterator;

import org.sikuli.script.Screen;

import periodic.TwitterStatus;
import upper.Processes;

public class TwitterProcesses extends Processes {
	//private String twitterURL = "https://twitter.com/";
	boolean flag;

	private TwitterStatus status;

	Screen screen = new Screen();
	//処理手順(Process Chain)
	private ArrayList<TwitterProcesses> processChain = new ArrayList<TwitterProcesses>();


	//コンストラクタでonStatusかoffStatusを選択
	public TwitterProcesses(TwitterStatus status) {
		this.status = status;
		if(this.status == TwitterStatus.valueOf("OnStatus")) {
			this.flag = false;
		}else {
			this.flag = true;
		}
	}
	public TwitterProcesses() {	}


	public boolean process() {
		TwitterProcesses LiT = new LoginTwitter();
		TwitterProcesses LM = new TwitterMain(this.flag);
		TwitterProcesses LoT = new LogoutTwitter();
		this.processChain.add(LiT);
		this.processChain.add(LM);
		this.processChain.add(LoT);
		Iterator<TwitterProcesses> it = this.processChain.iterator();
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
