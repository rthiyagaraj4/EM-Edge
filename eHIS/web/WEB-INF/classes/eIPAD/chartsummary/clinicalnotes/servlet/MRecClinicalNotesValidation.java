package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.healthobject.ClinicalNotesErrorItem;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesValidationResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class MRecClinicalNotesValidation
 */
public class MRecClinicalNotesValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRecClinicalNotesValidation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PatContext patientContext;
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		ClinicalNotesValidationResponse valiResp = new ClinicalNotesValidationResponse();
		ClinicalNotesBC bc = new ClinicalNotesBC();
		ClinicalNotesErrorItem errorItem;
		
		if(patientContext != null){
			String note_type = checkForNull(request.getParameter("note_type"));
			String operation_mode = checkForNull(request.getParameter("operation_mode"));
			String resp_id = (String)session.getAttribute("responsibility_id");
			String locale = patientContext.getLocale();
			ClinicalNotesMapResponse sectDetailsResponse = bc.getNoteTypeSectionDetails(resp_id, note_type, locale);
			HashMap sectDetailsMap = sectDetailsResponse.getMap();
			String privilege_type = (String)sectDetailsMap.get("privilege_type");
			if(privilege_type.equals("2") && operation_mode.equals("Sign")){
				valiResp.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_ERROR);
				errorItem = new ClinicalNotesErrorItem();
				errorItem.setErrorMessageId("PRIVILEGE_ERROR");
				valiResp.getErrorList().add(errorItem);
			}
			
			
		}else{
			valiResp.setValidationResult(ClinicalNotesValidationResponse.VALIDATION_ERROR);
			errorItem = new ClinicalNotesErrorItem();
			errorItem.setErrorMessageId("SESSION_ERROR");
		}
		
		
		jsonFieldResponse = gson.toJson(valiResp);
		response.setContentType("application/json");
		response.getWriter().write(jsonFieldResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}

}
