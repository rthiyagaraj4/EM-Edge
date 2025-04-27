package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesTemplateResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;

/**
 * Servlet implementation class RecCNDisplayTemplateServlet
 */
public class MRecClinicalNotesSectionContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRecClinicalNotesSectionContent() {
        super();
        // TODO Auto-generated constructor stub
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
			String secCode = request.getParameter("secCode") == null? "":request.getParameter("secCode"); //secCode
			
			ClinicalNotesTemplateResponse resp;
			ClinicalNotesBC cnBC = new ClinicalNotesBC();
			resp = cnBC.getSectionTemplate(secCode, patientContext);
			request.setAttribute("TemplateResponse",resp);
			}
		
		rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/RecordCNDisplayTemplate.jsp");
		rd.forward(request, response);
		
		//rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/ClinicalNotes/XMLExample.jsp");
		//rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
