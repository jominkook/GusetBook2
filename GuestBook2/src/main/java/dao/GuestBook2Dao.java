package dao;

import java.util.List;

import vo.GuestBook2Vo;

public interface GuestBook2Dao {
		public boolean insert(GuestBook2Vo vo);
		public List<GuestBook2Vo> getlist();
		public boolean delete(GuestBook2Vo vo);
		
}


