package periodic;

import java.util.TimerTask;

import twitter.TwitterProcesses;

public class OnStatusProcess extends TimerTask {
	private TwitterStatus status = TwitterStatus.OnStatus;

	public void run() {
			TwitterProcesses tp = new TwitterProcesses(this.status);
				tp.process();
	}
}
