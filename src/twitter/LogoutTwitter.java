package twitter;

import org.sikuli.script.Key;

class LogoutTwitter extends TwitterProcesses {

	@Override
	public boolean process() {
		//Google Chromeを閉じて、初期状態に戻す
		wait(500);
		this.closeWindow();
		return true;
	}
	
	private void closeWindow() {
		this.screen.keyDown(Key.ALT);
		this.screen.keyDown(Key.F4);
		this.screen.keyUp(Key.ALT);
		this.screen.keyUp(Key.F4);
	}

}
