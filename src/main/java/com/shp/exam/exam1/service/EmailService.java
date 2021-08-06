package com.shp.exam.exam1.service;

import com.shp.exam.exam1.app.App;
import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.container.ContainerComponent;
import com.shp.exam.exam1.util.Ut;

public class EmailService implements ContainerComponent {

	@Override
	public void init() {
		
	}

	public int notify(String to, String title, String body) {
		App app = Container.app;
		String smtpGmailId = app.getSmtpGmailId();
		String smtpGmailPw = app.getSmtpGmailPw();
		String from = "no-reply@no-reply.com";
		String fromName = app.getNotifyEmailFromName();
				
		return Ut.sendMail(smtpGmailId, smtpGmailPw, from, fromName, to, title, body);
	}
	
}
