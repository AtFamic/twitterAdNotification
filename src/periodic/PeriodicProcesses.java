package periodic;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import mail.MailProcesses;
import twitter.TwitterProcesses;

public class PeriodicProcesses{


	public void process() {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		int startTime = (24 + 7  - hour) % 24;
		int endTime = (24 + 23 - hour) % 24;
		System.out.println("Start will begin in :" + startTime);
		System.out.println("End will begin in :" + endTime);

		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run(){
				TwitterProcesses tp = new TwitterProcesses(TwitterStatus.OffStatus);
				tp.process();
				MailProcesses mp = new MailProcesses(false);
				mp.process();
			}
		}, endTime, 24, TimeUnit.HOURS);

		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			public void run() {
				TwitterProcesses tp = new TwitterProcesses(TwitterStatus.OnStatus);
				tp.process();
				MailProcesses mp = new MailProcesses(true);
				mp.process();
			}
		}, startTime, 24, TimeUnit.HOURS);

		//現在時刻
//		LocalDateTime ldt = LocalDateTime.now();
//		Timer onStatusTimer = new Timer();
//		Timer offStatusTimer = new Timer();
//		TimerTask onStatusProcess = new OnStatusProcess();
//		TimerTask offStatusProcess = new OffStatusProcess();
//		LocalTime onStatusTime = LocalTime.parse("07:00:00");
//		LocalTime offStatusTime = LocalTime.parse("23:00:00");
//
//		while(true) {
//			ldt.now();
//			Instant onStatusInstant = onStatusTime.atDate(LocalDate.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth())).
//			        atZone(ZoneId.systemDefault()).toInstant();
//			Date onStatusDate = Date.from(onStatusInstant);
//
//			onStatusTimer.schedule(onStatusProcess, onStatusDate);
//
//
//			ldt.now();
//
//			Instant offStatusInstant = offStatusTime.atDate(LocalDate.of(ldt.getYear(), ldt.getMonth(), ldt.getDayOfMonth())).
//			        atZone(ZoneId.systemDefault()).toInstant();
//			Date offStatusDate = Date.from(offStatusInstant);
//
//			offStatusTimer.schedule(offStatusProcess, offStatusDate);
//
//		}

	}


}
