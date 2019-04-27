package twitter;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Key;
import org.sikuli.script.Region;

class LoginTwitter extends TwitterProcesses {

	@Override
	public boolean process() {
		//Google Chromeを起動して(画面最大化したのちに)Twitterに移動
		//(1700,40)px,width=60,height=30
		try {
			this.screen.doubleClick("imgs/twitter/LoginTwitter/GoogleGhrome.PNG",0);
			wait(600);
			//this.screen.click("imgs/twitter/LoginTwitter/google.PNG");
			new Region(425,670,200,30).click();
			this.screen.keyDown(Key.ALT);
			this.screen.type(Key.SPACE);
			this.screen.keyUp(Key.ALT);
			//this.screen.keyUp(Key.SHIFT);
			wait(1000);
			this.screen.type("x");
			//this.screen.keyUp("x");
			this.waitClick("imgs/twitter/LoginTwitter/TwitterBanner.PNG");
		}catch(FindFailed e) {
			e.printStackTrace();
		}

		//Twitterサイトからツイッター広告のページまで移動
		try {
			wait(500);
			this.screen.find("imgs/twitter/LoginTwitter/tweetBanner.PNG").left().click("imgs/twitter/LoginTwitter/icon.PNG",0);
			/*
			 * 「twitter広告」が画像認識されないので、画面位置の指定によってクリックを行わせる
			 * (1240,380)px,width=200,heigt=25
			 * Chromeのアップデート後（20180921）
			 * heght=30
			 */
			wait(500);
			new Region(1240,380,200,30).click();

			wait(500);
			return true;
			/*
			 * wait(500);

			if(this.screen.exists("imgs/AddPageBanner.PNG",0).getScore()!=0)
				return true;
			*/
		}catch(FindFailed e) {
			e.getStackTrace();
		}

		return false;
	}




}
