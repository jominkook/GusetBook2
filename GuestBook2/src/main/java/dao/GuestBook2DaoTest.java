package dao;

import vo.GuestBook2Vo;

public class GuestBook2DaoTest {

	public static void main(String[] args) {
		GuestBook2Vo gvo = new GuestBook2Vo();
		gvo.setName("������");
		gvo.setPassword("1234");
		gvo.setContent("adsddasdsds");
		GuestBook2Dao dao = new GuestBook2DaoImpl();
		if(dao.insert(gvo)) {
			System.out.println("������ �߰� ����!");
		}
		else {
			System.out.println("����");
		}
		 

	}

}
