package com.shp.exam.exam1.interceptor;

import com.shp.exam.exam1.container.Container;
import com.shp.exam.exam1.dto.Member;
import com.shp.exam.exam1.http.Rq;
import com.shp.exam.exam1.service.MemberService;
import com.shp.exam.exam1.util.Ut;

public class BeforeActionInterceptor extends Interceptor {

	private MemberService memberService;
	
	public void init() {
		memberService = Container.memberService;
	}

	@Override
	public boolean runBeforeAction(Rq rq) {
		String loginedMemberJson = rq.getSessionAttr("loginedMemberJson", "");

		if (loginedMemberJson.length() > 0) {
			rq.setLogined(true);
			rq.setLoginedMember(Ut.toObjFromJson(loginedMemberJson, Member.class));
			rq.setLoginedMemberId(rq.getLoginedMember().getId());
			rq.setAdmin(memberService.isAdmin(rq.getLoginedMember()));
		}
		
		rq.setAttr("rq", rq);

		return true;
	}

}