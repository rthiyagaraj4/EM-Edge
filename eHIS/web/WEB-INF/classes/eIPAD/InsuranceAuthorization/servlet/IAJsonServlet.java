package eIPAD.InsuranceAuthorization.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import eIPAD.InsuranceAuthorization.bc.InsuranceAuthBC;
import eIPAD.chartsummary.activeproblems.bc.ProblemsDiagnosisBC;
import eIPAD.chartsummary.activeproblems.response.DiagnosisSetResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

public class IAJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IAJsonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mode = request.getParameter("mode") == null? "":request.getParameter("mode");
		String patientId =  request.getParameter("patientId") == null? "":request.getParameter("patientId");
		String facilityId = request.getParameter("facilityId") == null? "":request.getParameter("facilityId");
		String locale = request.getParameter("locale") == null? "":request.getParameter("locale");
		response.setContentType("application/json");
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		PrintWriter out = response.getWriter();
		if(mode != null && !mode.equals("")){
			if(mode.equals("ENCOUNTER_LIST")){
				EncounterListResponse encLisRes;
				InsuranceAuthBC iaBC = new InsuranceAuthBC();
				encLisRes = iaBC.getEncounterListForPatient(patientId, facilityId, locale);
				if(encLisRes != null && encLisRes.isSuccessResponse()) {
					jsonFieldResponse = gson.toJson(encLisRes);
				}
				response.getWriter().write(jsonFieldResponse);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
