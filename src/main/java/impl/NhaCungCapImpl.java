package impl;

import java.awt.Dialog;
import java.util.List;

import dao.NhaCungCapDao;
import entities.NhaCungCap;
import jakarta.persistence.EntityManager;

public class NhaCungCapImpl implements NhaCungCapDao{
	
	private EntityManager eManager;

	public NhaCungCapImpl(EntityManager eManager2) {
		this.eManager = eManager2;
	}

	@Override
	public List<NhaCungCap> getListNhaCungCap() {
		eManager.clear(); 
		return  eManager.createQuery("FROM NhaCungCap", NhaCungCap.class).getResultList();
	}

	@Override
	public NhaCungCap getNCCByID(int id) {
		return eManager.find(NhaCungCap.class, id);
	}

	@Override
	public boolean insertNhaCungCap(NhaCungCap ncc) {
		try {
			eManager.getTransaction().begin();
			eManager.persist(ncc);
			eManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			if(eManager.getTransaction().isActive())
				eManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateNhaCungCap(NhaCungCap ncc) {
		try {
			eManager.getTransaction().begin();
			NhaCungCap updateNcc = eManager.find(NhaCungCap.class, ncc.getMaNCC());
			eManager.merge(updateNcc);
			eManager.getTransaction().commit();
			return true;
		}catch (Exception e) {
			if(eManager.getTransaction().isActive())
				eManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteNhaCungCap(int id) {
		try {
			eManager.getTransaction().begin();
			NhaCungCap ncc = eManager.find(NhaCungCap.class, id);
		
			if(ncc != null) {
				eManager.remove(ncc);
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
	public List<NhaCungCap> getNCCByName(String tenNcc) {
		return eManager.createQuery("select ncc from NhaCungCap ncc where ncc.nhaCungCap.tenNcc = :tenNcc", NhaCungCap.class)
				.setParameter("tenNcc", tenNcc).getResultList();
	}

	@Override
	public List<NhaCungCap> getNCCByAddress(String address) {
		return eManager.createQuery("select ncc from NhaCungCap ncc where ncc.nhaCungCap.diaChi like :address", NhaCungCap.class)
				.setParameter("address", address).getResultList();
	}

	@Override
	public List<NhaCungCap> getNCCByPhone(String phone) {
		return eManager.createQuery("select ncc from NhaCungCap where ncc.nhaCungCap.soDienThoai like :phone", NhaCungCap.class)
				.setParameter("phone", phone).getResultList();
	}
	
}
