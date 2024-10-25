package entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "")
public class NhaCungCap {
	@Id
	@Column(name = "MANCC")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maNCC;
	
	@NotEmpty(message = "Tên nhà cung cấp không được bỏ trống!")
	@Size(max = 255, message = "Tên nhà cung cấp tối đa 255 ký tự")
	@Column(name = "TENNCC")
	private String tenNCC;
	
	@NotEmpty(message = "Địa chỉ nhà cung cấp không được bỏ trống!")
	@Size(max = 255, message = "Địa chỉ nhà cung cấp tối đa 255 ký tự")
	@Column(name = "DIACHI")
	private String diaChi;
	
	@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại gồm 10 ký số")
	@Column(name = "SODIENTHOAI")
	private String soDienThoai;
	
	@OneToMany(mappedBy = "nhaCungCap")
	private List<DienThoai> listDienThoai;
	
	public NhaCungCap() {
		super();
	}
	
	public NhaCungCap(
			@NotEmpty(message = "Tên nhà cung cấp không được bỏ trống!") @Size(max = 255, message = "Tên nhà cung cấp tối đa 255 ký tự") String tenNCC,
			@NotEmpty(message = "Địa chỉ nhà cung cấp không được bỏ trống!") @Size(max = 255, message = "Địa chỉ nhà cung cấp tối đa 255 ký tự") String diaChi,
			@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại gồm 10 ký số") String soDienThoai) {
		super();
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	
	
	public NhaCungCap(int maNCC,
			@NotEmpty(message = "Tên nhà cung cấp không được bỏ trống!") @Size(max = 255, message = "Tên nhà cung cấp tối đa 255 ký tự") String tenNCC,
			@NotEmpty(message = "Địa chỉ nhà cung cấp không được bỏ trống!") @Size(max = 255, message = "Địa chỉ nhà cung cấp tối đa 255 ký tự") String diaChi,
			@Pattern(regexp = "0[0-9]{9}", message = "Số điện thoại gồm 10 ký số") String soDienThoai) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<DienThoai> getListDienThoai() {
		return listDienThoai;
	}

	public void setListDienThoai(List<DienThoai> listDienThoai) {
		this.listDienThoai = listDienThoai;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChi=" + diaChi + ", soDienThoai="
				+ soDienThoai + ", listDienThoai=" + listDienThoai + "]";
	}
	
	
	
	
	
}
