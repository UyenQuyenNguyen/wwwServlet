package service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;import java.util.ResourceBundle.Control;

import dao.NhaCungCapDao;
import entities.NhaCungCap;
import impl.NhaCungCapImpl;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ServiceNhaCungCap {
	private static NhaCungCapDao nhaCungCapDao;
	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator;
	
	public ServiceNhaCungCap(EntityManager eManager) {
		nhaCungCapDao = new NhaCungCapImpl(eManager);
		validator = factory.getValidator();
	}
	
	public List<NhaCungCap> getListNhaCungCap() {
		return nhaCungCapDao.getListNhaCungCap();
	}
	
	public String inser(String tenNCC, String diaChi, String soDienThoai) {
		String message = "Add supplier successfully";
		NhaCungCap ncc = new NhaCungCap(tenNCC, diaChi, soDienThoai);
		Set<ConstraintViolation<NhaCungCap>> violations = validator.validate(ncc);
		for(ConstraintViolation<NhaCungCap> vio : violations) {
			return vio.getMessage();
		}
		if(!nhaCungCapDao.insertNhaCungCap(ncc)) {
			message = "Failled";
		}
		
		return message;
	}
	
	public String updateNhaCungCap(int maNCC, String tenNCC, String diaChi, String soDienThoai) {
		String message = "";
		NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai);
		
		Set<ConstraintViolation<NhaCungCap>> violations = validator.validate(ncc);
		for (ConstraintViolation<NhaCungCap> vio : violations) {
			return vio.getMessage();
		}
		
		if(!nhaCungCapDao.updateNhaCungCap(ncc)) {
			message = "Failed";
		}
		
		return message;
		
	}
	
	public boolean deletNhaCungCap(int id) {
		return nhaCungCapDao.deleteNhaCungCap(id);
	}
	
	public List<NhaCungCap> getNCCByName(String name) {
		return nhaCungCapDao.getNCCByPhone(name);
	}
	
	public List<NhaCungCap> getNCCByAddress(String address) {
		return nhaCungCapDao.getNCCByAddress(address);
	}
	
	public List<NhaCungCap> getNCCByPhone( String phone) {
		return nhaCungCapDao.getNCCByPhone(phone);
	}
}
