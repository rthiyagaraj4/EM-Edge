/**
 * 
 */
package eIPAD.InPatientDetails.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import eIPAD.InPatientDetails.bc.InPatsIndicatorBc;
import eIPAD.InPatientDetails.bc.PatsIndicators;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 
 *
 */
public class IpIndicator extends HttpServlet {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// getting Session variable

		HttpSession session = request.getSession(true);

		String facility_id = session.getAttribute("facility_id").toString();

		PatContext patientContext = null;

		if (session.getAttribute("PatientContext") != null) {
			patientContext = (PatContext) session
					.getAttribute("PatientContext");
		}

		String encounter_ids = request.getParameter("encounter_ids");

		String patId = request.getParameter("pat_ids");

		String[] listOfPats = patId.split(",");

		String[] listOfEncd = encounter_ids.split(",");

		// ArrayList<String> listOfPats = (ArrayList<String>)
		// Arrays.asList(patId.split(","));


		InPatsIndicatorBc bcIndicator = new InPatsIndicatorBc();

		HashMap<String, String> detailsOfPrats = new HashMap<String, String>();

		String responsibility_id_sess = (String) session
				.getAttribute("responsibility_id");

		if (responsibility_id_sess == null) {

			responsibility_id_sess = "";

		}

		detailsOfPrats.put("responsibility_id", responsibility_id_sess);
		detailsOfPrats.put("practitioner_id",
				session.getAttribute("practitioner_id").toString());
		detailsOfPrats.put("login_user", session.getAttribute("login_user")
				.toString());
		detailsOfPrats.put("others_unsigned", "N");
		detailsOfPrats.put("facility_id", session.getAttribute("facility_id")
				.toString());
		detailsOfPrats.put("app_server_ip",
				session.getAttribute("app_server_ip").toString());
		detailsOfPrats.put("responsibility_name",
				session.getAttribute("responsibility_name").toString());
		// detailsOfPrats.put("version_no",session.getAttribute("version_no").toString());
		// detailsOfPrats.put("bl_operational",session.getAttribute("bl_operational").toString());
		detailsOfPrats.put("CUSTOMER_ID", session.getAttribute("CUSTOMER_ID")
				.toString());
		// detailsOfPrats.put("connection_pooling_yn",session.getAttribute("connection_pooling_yn").toString());
		// detailsOfPrats.put("ACC_ENTITY_ID",session.getAttribute("ACC_ENTITY_ID").toString());
		detailsOfPrats.put("report_connect_string",
				session.getAttribute("report_connect_string").toString());
		detailsOfPrats.put("product_description",
				session.getAttribute("product_description").toString());
		detailsOfPrats.put("jdbc_user", session.getAttribute("jdbc_user")
				.toString());
		detailsOfPrats.put("practitioner_type",
				session.getAttribute("practitioner_type").toString());
		detailsOfPrats.put("facility_name",
				session.getAttribute("facility_name").toString());
		// detailsOfPrats.put("env",session.getAttribute("env").toString());
		// detailsOfPrats.put("userSite",session.getAttribute("userSite").toString());
		detailsOfPrats.put("Login", session.getAttribute("Login").toString());
		// detailsOfPrats.put("bl_install_yn",session.getAttribute("bl_install_yn").toString());
		// detailsOfPrats.put("jdbc",session.getAttribute("jdbc").toString());
		// detailsOfPrats.put("client_ip_address",session.getAttribute("client_ip_address").toString());
		detailsOfPrats.put("appl_user_name",
				session.getAttribute("appl_user_name").toString());
		// detailsOfPrats.put("PREFERRED_STYLE",session.getAttribute("PREFERRED_STYLE").toString());
		detailsOfPrats.put("practitioner_name",
				session.getAttribute("practitioner_name").toString());
		detailsOfPrats.put("responsibility_id",
				session.getAttribute("responsibility_id").toString());
		detailsOfPrats.put("login_user", session.getAttribute("login_user")
				.toString());
		detailsOfPrats.put("facility_id", session.getAttribute("facility_id")
				.toString());
		// detailsOfPrats.put("PRIMARY_LANG",session.getAttribute("PRIMARY_LANG").toString());
		// detailsOfPrats.put("product_name",session.getAttribute("product_name").toString());
		detailsOfPrats.put("ca_practitioner_id",
				session.getAttribute("ca_practitioner_id").toString());
		// detailsOfPrats.put("serviceURL",session.getAttribute("serviceURL").toString());
		// detailsOfPrats.put("mp_bl_oper_yn",session.getAttribute("serviceURL").toString());
		detailsOfPrats.put("LOCALE", session.getAttribute("LOCALE").toString());
		// detailsOfPrats.put("report_server",session.getAttribute("report_server").toString());

		ArrayList<PatsIndicators> pendingInds = bcIndicator
				.getAllIndicatiorsForallPatient(patientContext, listOfPats,
						listOfEncd, facility_id, detailsOfPrats);

		String json = new Gson().toJson(pendingInds);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
		// TODO Auto-generated method stub
		PatContext patientContext = null;

	}

}
