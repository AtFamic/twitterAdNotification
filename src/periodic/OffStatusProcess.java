package periodic;

import java.util.TimerTask;

import twitter.TwitterProcesses;

public class OffStatusProcess extends TimerTask {
	private final TwitterStatus status = TwitterStatus.OffStatus;

	@Override
	public void run() {
		TwitterProcesses tp = new TwitterProcesses(this.status);
		tp.process();
	}

}
