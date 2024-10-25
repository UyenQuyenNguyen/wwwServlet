package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "")
public class DienThoai {
	@Id
	@Column(name = "MADT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maDT;
	
	@Column(name = "TENDT")
	@NotEmpty(message = "Tên điện thoại không được bỏ trống!")
	private String tenDT;
	
	@Column(name = "NAMSANXUAT")
	@NotEmpty(message = "Năm sản xuất không được bỏ trống")
	private int namSanXuat;
	
	@Column(name = "CAUHINH")
	@Size(max = 255, message = "Cấu hình tối đa 255 ký tự")
	private String cauHinh; 
	
	@Column(name = "HINHANH")
	@Pattern(regexp = "(^$|.*\\.(png|jpg)$)", message = "Hình ảnh phải có định dạng .png hoặc .jpg")
	private String hinhAnh;
	
	@ManyToOne
	@JoinColumn(name = "MANCC")
	private NhaCungCap nhaCungCap;



	public DienThoai(int maDT, @NotEmpty(message = "Tên điện thoại không được bỏ trống!") String tenDT,
			@NotEmpty(message = "Năm sản xuất không được bỏ trống") int namSanXuat,
			@Size(max = 255, message = "Cấu hình tối đa 255 ký tự") String cauHinh,
			@Pattern(regexp = "(^$|.*\\.(png|jpg)$)", message = "Hình ảnh phải có định dạng .png hoặc .jpg") String hinhAnh,
			NhaCungCap nhaCungCap) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}
	
	

	public DienThoai(@NotEmpty(message = "Tên điện thoại không được bỏ trống!") String tenDT,
			@NotEmpty(message = "Năm sản xuất không được bỏ trống") int namSanXuat,
			@Size(max = 255, message = "Cấu hình tối đa 255 ký tự") String cauHinh,
			@Pattern(regexp = "(^$|.*\\.(png|jpg)$)", message = "Hình ảnh phải có định dạng .png hoặc .jpg") String hinhAnh,
			NhaCungCap nhaCungCap) {
		super();
		this.tenDT = tenDT;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.hinhAnh = hinhAnh;
		this.nhaCungCap = nhaCungCap;
	}



	public int getMaDT() {
		return maDT;
	}

	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}

	public String getTenDT() {
		return tenDT;
	}

	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}

	public int getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	@Override
	public String toString() {
		return "DienThoai [maDT=" + maDT + ", tenDT=" + tenDT + ", namSanXuat=" + namSanXuat + ", cauHinh=" + cauHinh
				+ ", hinhAnh=" + hinhAnh + ", nhaCungCap=" + nhaCungCap + "]";
	}
	
	
	
}
