package kr.co.soft.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.soft.beans.BoardInfoBean;

@Repository
public class TopMenuDao {
	
	//servlet-context에 있는 쿼리문 동작에서 명시하는 클래스 자동주입
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardInfoBean> getTopMenuList(){
		//topmenu.get_topmenu_list : top_menu_mapper.xml의 namespace 와 id
		List<BoardInfoBean> topMenuList = sqlSessionTemplate.selectList("topmenu.get_topmenu_list");
		return topMenuList;

	}

}
