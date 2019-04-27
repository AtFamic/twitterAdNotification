package mail;

import org.sikuli.script.FindFailed;

class LoginMail extends MailProcesses {

	public boolean process() {
		//Google Chromeを起動して(画面最大化したのちに)Twitterに移動
				//(1700,40)px,width=60,height=30
		try {
			wait(1000);
			this.screen.doubleClick("imgs/twitter/LoginTwitter/GoogleGhrome.PNG",0);
			wait(600);
			//this.screen.click("imgs/twitter/LoginTwitter/google.PNG");
//			this.screen.keyDown(Key.ALT);
//			this.screen.type(Key.SPACE);
//			this.screen.keyUp(Key.ALT);
//			wait(6000);
//			//this.screen.keyUp(Key.SHIFT);
//			this.screen.type("x");
			//this.screen.keyUp("x");
			this.waitClick("imgs/mail/LoginMail/chatworkBanner.PNG");
		}catch(FindFailed e) {
			e.printStackTrace();
		}
		return true;
	}
		/*
		//ChatWorkをクリックして起動
		try {
			super.screen.doubleClick("imgs/mail/LoginMail/ChatWork.PNG");
			super.wait(10000);
		}catch(FindFailed e) {
			e.getStackTrace();
			return false;
		}
		return true;
	}
	*/

}
