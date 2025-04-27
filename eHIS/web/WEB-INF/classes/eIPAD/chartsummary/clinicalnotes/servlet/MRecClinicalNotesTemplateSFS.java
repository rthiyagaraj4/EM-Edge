/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesFieldItem;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * @author ACibibalan 
 *
 */
public class MRecClinicalNotesTemplateSFS  extends HttpServlet {
	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		PatContext patientContext = null;
		HttpSession session = request.getSession(true);
		if (session.getAttribute("PatientContext") != null) {
			patientContext = (PatContext) session
					.getAttribute("PatientContext");
		}
		
		String search_id = request.getParameter("search_id");
		
		
		
		
		
		ClinicalNotesBC sfsctrl=new ClinicalNotesBC();
		
		ArrayList<ClinicalNotesFieldItem> allComboDetails = new ArrayList<ClinicalNotesFieldItem>();
		
		try {
			allComboDetails = sfsctrl.getRecordsForSfs(search_id,
					patientContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		String json = new Gson().toJson(allComboDetails);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		
	}



	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatContext patientContext = null;
		
		

	}
	
}
