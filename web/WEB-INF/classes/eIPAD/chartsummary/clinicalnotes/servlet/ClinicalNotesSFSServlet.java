/**
 * 
 */
package eIPAD.chartsummary.clinicalnotes.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.request.ClinicalNotesRequest;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * @author pooranisenthil
 *
 */
public class ClinicalNotesSFSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClinicalNotesSFSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession(false);
		RequestDispatcher rd;
		PatContext patientContext;
		
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		ClinicalNotesRequest oCnReq = new ClinicalNotesRequest();
		oCnReq.setPatientContext(patientContext);
		ClinicalNotesResponse oCnRes = null;
		ClinicalNotesBC oCnBC = new ClinicalNotesBC();
		String encounterID = request.getParameter("encounterID");
		String viewPage = request.getParameter("viewPage");
		
		String finalStartDate = request.getParameter("finalStartDate");
		String finalEndDate = request.getParameter("finalEndDate");
		
		oCnBC.getNoteTypeListSfs(patientContext, viewPage, finalStartDate, finalEndDate, encounterID);
		oCnBC.getMedServListSfs(patientContext, viewPage, finalStartDate, finalEndDate, encounterID);
		oCnBC.getStatusListSfs(patientContext, viewPage, finalStartDate, finalEndDate, encounterID);
		oCnBC.getPerformedByListSfs(patientContext, viewPage, finalStartDate, finalEndDate, encounterID);
		
		
		if(request.getParameter("encounterID") !=null){
			encounterID = request.getParameter("encounterID");
			oCnReq.setEncounterID(encounterID);
		}
		if(request.getParameter("viewPage") !=null){
			viewPage = request.getParameter("viewPage");
			oCnReq.setViewPage(viewPage);
		}

		EncounterListRequest encReq = new EncounterListRequest();
		EncounterListResponse encResp;
		if(patientContext!=null){
			encReq.setPatientContext(patientContext);
		}
		EncounterListBC encBC = new EncounterListBC();
		encResp = encBC.getEncounterList(encReq);
		
		//get the current encounter details
		encReq.setFilterEncounterId(patientContext.getEncounterId());
		

		if(encResp.isSuccessResponse() && !encResp.isEmptyDataResponse()){
			ArrayList<EncounterHO> encList = encResp.getEncounterList();

		}
			
		request.setAttribute("EncounterListResponse", encResp);
		//request.setAttribute("CurrentEncounterResponse", currentEncResp);
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/ClinicalNotesSFS.jsp");
		rd.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
