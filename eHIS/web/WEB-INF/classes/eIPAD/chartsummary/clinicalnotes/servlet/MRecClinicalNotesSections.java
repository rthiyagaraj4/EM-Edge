package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class RecordClinicalNoteServlet
 */
public class MRecClinicalNotesSections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRecClinicalNotesSections() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		
		if(patientContext!=null){
			String noteTypeId = request.getParameter("hdnNoteType") == null? "":request.getParameter("hdnNoteType"); //noteTypeId
			//String medServices = request.getParameter("hdnMedSer") == null? "":request.getParameter("hdnMedSer"); 
			String speciality = request.getParameter("hdnSpecialityCode") == null? "":request.getParameter("hdnSpecialityCode"); 
			
			/*ClinicalNotesSectionResponse secResponse;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			secResponse = cnBC.getSecNoteListName( patientContext,  noteTypeId , speciality);
			request.setAttribute("SectionResponse",secResponse);*/
		}
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSections.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// TODO Auto-generated method stub
	}

}
