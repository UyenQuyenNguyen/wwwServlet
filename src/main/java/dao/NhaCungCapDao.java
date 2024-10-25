package dao;

import java.util.List;

import entities.NhaCungCap;

public interface NhaCungCapDao {
	 List<NhaCungCap> getListNhaCungCap();
	
	 NhaCungCap getNCCByID(int id);
	
	 boolean insertNhaCungCap(NhaCungCap ncc);
	
	 boolean updateNhaCungCap(NhaCungCap ncc);
	
	 boolean deleteNhaCungCap(int id);
	
	 List<NhaCungCap> getNCCByName(String tenNcc);
	 
	 List<NhaCungCap> getNCCByAddress(String address);
	 
	 List<NhaCungCap> getNCCByPhone(String phone);
	
}
