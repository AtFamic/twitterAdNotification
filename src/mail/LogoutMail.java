package mail;

import org.sikuli.script.Key;

class LogoutMail extends MailProcesses {

	@Override
	public boolean process() {
		super.wait(1000);
		super.screen.click();
		super.screen.keyDown(Key.CTRL);
		super.screen.keyDown("w");
		super.screen.keyUp(Key.CTRL);
		super.screen.keyUp("w");
		return false;
	}

}
