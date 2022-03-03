package kr.co.soft.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.soft.beans.BoardInfoBean;
import kr.co.soft.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{
	
	// (xml에서) Interceptor클래스는 @Autowire를 사용 할 수 있음
	@Autowired
	private TopMenuService topMenuService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}

	
	
}
