package impl;

import java.util.List;

import dao.DienThoaiDao;
import entities.DienThoai;
import jakarta.persistence.EntityManager;

public class DienThoaiImpl implements DienThoaiDao {
	private EntityManager eManager;

	@Override
	public List<DienThoai> getListDienThoai() {
		return eManager.createQuery("from DienThoại", DienThoai.class).getResultList();
	}

	@Override
	public DienThoai getPhoneById(int id) {
		return eManager.find(DienThoai.class, id);
	}

	@Override
	public boolean insertPhone(DienThoai dt) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(dt);
			eManager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if(eManager.getTransaction().isActive()) {
				eManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePhone(DienThoai dt) {
		try {
			eManager.getTransaction().begin();
			DienThoai phone = eManager.find(DienThoai.class, dt.getMaDT());
			if(phone != null) {
				if(dt.getHinhAnh() == null || dt.getHinhAnh().isEmpty()) {
					dt.setHinhAnh(phone.getHinhAnh());
				}
			}
			eManager.merge(dt);
			eManager.getTransaction().commit();
		} catch (Exception e) {
			if(eManager.getTransaction().isActive())
				eManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePhone(int id) {
		try {
			eManager.getTransaction().begin();
			DienThoai delPhone = eManager.find(DienThoai.class, id);
			
			if(delPhone != null) {
				eManager.remove(delPhone);
				eManager.getTransaction().commit();
				return true;
			}
			
			eManager.getTransaction().rollback();
			
		}catch (Exception e) {
			if(eManager.getTransaction().isActive()) {
				eManager.getTransaction().rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<DienThoai> getListPhoneByNCC(int nhaCungCapID) {
		return eManager.createQuery("select a from DienThoai a where a.nhaCungCap.maNCC = :maNCC", DienThoai.class)
				.setParameter("maNCC", nhaCungCapID).getResultList();
	}
	
}
