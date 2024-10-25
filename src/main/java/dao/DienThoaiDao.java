package dao;

import java.util.List;

import entities.DienThoai;

public interface DienThoaiDao {
	List<DienThoai> getListDienThoai();
	
	DienThoai getPhoneById(int id);
	
	boolean insertPhone(DienThoai dt);
	
	boolean updatePhone(DienThoai dt);
	
	boolean deletePhone(int id);
	
	List<DienThoai> getListPhoneByNCC(int nhaCunfCapID);
	
	
}
