<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách nhà cung cấp</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row p-3 justify-content-center">
			<div class="col-12 text-center">
				<h2 class="text-info">Danh sách nhà cung cấp</h2>
			</div>

			<c:if test="${deleteNotify != null}">
				<div class="alert alert-primary" role="alert">${deleteNotify}</div>
			</c:if>

			<div class="col-8 text-cente mt-3r">
				<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Mã nhà cung cấp</th>
							<th>Tên nhà cung cấp</th>
							<th>Địa chỉ</th>
							<th>Số điện thoại</th>
							<th>Tác vụ</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="supplier" items="${nhaCungCaps}">
							<tr>
								<th scope="row">1</th>
								<td>${supplier.maNCC}</td>
								<td>${supplier.tenNCC}</td>
								<td>${supplier.diaChi}</td>
								<td>${supplier.soDienThoai}</td>
								<td><a type="button" class="btn btn-danger"
									href="${pageContext.request.contextPath}/nha-cung-cap?deleteSupplier=${supplier.maNCC}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>

<script type="text/javascript">
	const handleDeletePhone = () => {
		window.location.href = 'home'
	}
</script>
</html>