package com.brhmkskn.scheduled;

import java.util.Iterator;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component
public class ScheduledExample {

	// cron // https://crontab.cronhub.io/ * * * * * *
	//@Scheduled(cron ="0 03 23 * * *")
	@Scheduled(cron ="*/5 * * * * *")
	public void write1to10() {
		
		for (int i=1; i<=10 ;i++) {
			System.out.print(i +" ");
			
		}
		System.out.println();
	}
}
