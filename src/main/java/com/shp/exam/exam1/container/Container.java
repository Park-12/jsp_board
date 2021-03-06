package com.shp.exam.exam1.container;

import java.util.ArrayList;
import java.util.List;

import com.shp.exam.exam1.app.App;
import com.shp.exam.exam1.http.container.AdmHomeController;
import com.shp.exam.exam1.http.container.UsrArticleController;
import com.shp.exam.exam1.http.container.UsrHomeController;
import com.shp.exam.exam1.http.container.UsrMemberController;
import com.shp.exam.exam1.interceptor.BeforeActionInterceptor;
import com.shp.exam.exam1.interceptor.NeedAdminInterceptor;
import com.shp.exam.exam1.interceptor.NeedLoginInterceptor;
import com.shp.exam.exam1.interceptor.NeedLogoutInterceptor;
import com.shp.exam.exam1.repository.ArticleRepository;
import com.shp.exam.exam1.repository.BoardRepository;
import com.shp.exam.exam1.repository.MemberRepository;
import com.shp.exam.exam1.service.ArticleService;
import com.shp.exam.exam1.service.BoardService;
import com.shp.exam.exam1.service.EmailService;
import com.shp.exam.exam1.service.MemberService;

public class Container {
	private static List<ContainerComponent> containerComponents;
	
	public static App app;
	
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	public static NeedAdminInterceptor needAdminInterceptor;

	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;

	public static UsrHomeController usrHomeController;

	public static BoardRepository boardRepository;
	public static BoardService boardService;
	
	public static AdmHomeController admHomeController;

	public static EmailService emailService;

	public static void init() {
		containerComponents = new ArrayList<>();
		
		// 의존성 세팅
		app = addContainerComponent(new App());
		memberRepository = addContainerComponent(new MemberRepository());
		boardRepository = addContainerComponent(new BoardRepository());
		articleRepository = addContainerComponent(new ArticleRepository());
		
		memberService = addContainerComponent(new MemberService());
		boardService = addContainerComponent(new BoardService());
		articleService = addContainerComponent(new ArticleService());

		beforeActionInterceptor = addContainerComponent(new BeforeActionInterceptor());
		needLoginInterceptor = addContainerComponent(new NeedLoginInterceptor());
		needLogoutInterceptor = addContainerComponent(new NeedLogoutInterceptor());
		needAdminInterceptor = new NeedAdminInterceptor();

		usrMemberController = addContainerComponent(new UsrMemberController());
		usrArticleController = addContainerComponent(new UsrArticleController());
		usrHomeController = addContainerComponent(new UsrHomeController());
		
		admHomeController = addContainerComponent(new AdmHomeController());
		
		emailService = addContainerComponent(new EmailService());
		
		// 초기화
		for (ContainerComponent containerComponent : containerComponents) {
			containerComponent.init();
		}
	}
	
	private static <T> T addContainerComponent(ContainerComponent containerComponent) {
		containerComponents.add(containerComponent);
		
		return (T) containerComponent;
	}
}