package controller;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceNhaCungCap;
import utils.EntityManagerFactoryProvider;

import java.io.IOException;
import java.security.Provider.Service;

import entities.NhaCungCap;

/**
 * Servlet implementation class DanhSachNhaCungCap
 */
@WebServlet(urlPatterns = { "/nha-cung-cap", "/nha-cung-cap/*" })
public class DanhSachNhaCungCap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ServiceNhaCungCap serviceNhaCungCap;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachNhaCungCap() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
    public void init(ServletConfig config) throws ServletException {
		serviceNhaCungCap = new ServiceNhaCungCap(EntityManagerFactoryProvider.getFactory().createEntityManager());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("nhaCungCaps", serviceNhaCungCap.getListNhaCungCap());
		
		if(request.getParameter("deleteSupplier") != null) {
			boolean status = serviceNhaCungCap.deletNhaCungCap(Integer.parseInt(request.getParameter("deleteSupplier")));
			request.setAttribute("deleteNotify", "Delete successfully!");
		}
		
		request.getRequestDispatcher("views/NhaCungCap/index.jsp").forward(request, response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
