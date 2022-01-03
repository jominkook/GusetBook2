package dao;

import vo.GuestBook2Vo;

public class GuestBook2DaoTest {

	public static void main(String[] args) {
		GuestBook2Vo gvo = new GuestBook2Vo();
		gvo.setName("남도완");
		gvo.setPassword("1234");
		gvo.setContent("adsddasdsds");
		GuestBook2Dao dao = new GuestBook2DaoImpl();
		if(dao.insert(gvo)) {
			System.out.println("데이터 추가 성공!");
		}
		else {
			System.out.println("실패");
		}
		 

	}

}
