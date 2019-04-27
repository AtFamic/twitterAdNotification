package mail;

import java.time.format.DateTimeFormatter;

import org.sikuli.script.FindFailed;

class MainMail extends MailProcesses {
	private String message;
	private boolean flag;

	MainMail(boolean flag){
		this.flag=flag;
	}

	@Override
	public boolean process() {
		super.screen.click();
		//検索欄にフォーカスする
		try {
			super.screen.click("imgs/mail/MainMail/search_focus.PNG");
		}catch(FindFailed e) {}

		super.screen.type(super.groupName);

		super.waitClick("imgs/mail/MainMail/TwitterAdNotification.PNG");
		super.waitClick("imgs/mail/MainMail/typeZone.PNG");

		//メッセージの作成
		this.message=super.processdate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH;mm"));
		this.message+="\nTwitterAdStatus was turned ";
		if(this.flag==false) {
			this.message+="off";
		}else if(this.flag==true){
			this.message+="on";
		}

		super.screen.type(this.message);

		super.waitClick("imgs/mail/MainMail/send.PNG");


		return true;
	}

}
