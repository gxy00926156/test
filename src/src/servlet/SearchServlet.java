package src.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DoctorDao;
import bean.Doctor;
import bean.Hospital;
import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search.do")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String rs_type = request.getParameter("type");
		String rs_key = request.getParameter("key");
		String rs_hospital = request.getParameter("hospital");
		String rs_jobtitle = request.getParameter("jobtitle");
		String rs_province = request.getParameter("province");
		String flag = request.getParameter("flag");
		boolean isde ;
		if(flag.equals("是")){
			isde = true;
		}else{
			isde = false;
		}
		if(rs_province==""){
			rs_province = null;
		}
		System.out.println("hahaha"+rs_province);
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		DoctorDao dao = (DoctorDao) context.getBean("doctorDao");
		// ProvinceDao provinceDao = (ProvinceDao)
		// context.getBean("provinceDao");
		List<Doctor> doctors = new ArrayList<Doctor>();
		if (rs_type.equals("1")) {
			doctors = dao.getDoctorByDepart(rs_province, rs_key,isde);
		}else{
			doctors = dao.getDoctorByDisease(rs_province, rs_key, isde);
		}
		double[] w = new double[] { Double.parseDouble(rs_hospital),
				Double.parseDouble(rs_jobtitle) };
		List<Doctor> list = dao.SortList(doctors, w);
//		for(Doctor doc:list){
//			System.out.println(doc);
//		}

		JSONObject docs = new JSONObject();
		JSONArray docArray = new JSONArray();
		
		for (int i = 0; i < list.size() && i < 100; i++) {
			Doctor temp = list.get(i);
			JSONObject doc = new JSONObject();
			doc.put("name", temp.getName());
			System.out.println(temp.getJobtitle());
			doc.put("jobtitle", temp.getJobtitle());
			doc.put("rating", temp.getRating());
			// doc.put("area",
			// provinceDao.findById(String.valueOf(temp.getArea())).getName());
			doc.put("departdetail", temp.getDepartdetail());
			doc.put("goodat", temp.getGoodat());
			// TODO
			// JSONArray hosArray = new JSONArray();
			// JSONObject hosObject = new JSONObject();
			Hospital hos = temp.getHos();
			doc.put("hos_hospital", hos.getHospital());
			doc.put("hos_address", hos.getAddress());
			doc.put("hos_goodat", hos.getGoodat());
			doc.put("hos_level", hos.getLevel());
			doc.put("hos_type", hos.getType());
			// hosArray.add(hos);
			// doc.element("hos", hosArray);
			docArray.add(doc);
		}
		docs.element("docs", docArray);
		PrintWriter out = response.getWriter();
		out.write(docs.toString());
		out.flush();
		out.close();
		System.out.println("write success!!");
	}

}
