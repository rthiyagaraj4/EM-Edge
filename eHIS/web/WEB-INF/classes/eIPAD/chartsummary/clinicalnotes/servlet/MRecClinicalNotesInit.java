package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ehis.persist.PersistenceHelper;
import eIPAD.chartsummary.common.healthobject.PatContext;
import webbeans.eCA.RecClinicalNotesSectionBean;

/**
 * Servlet implementation class MRecClinicalNotesInit 
 */
public class MRecClinicalNotesInit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd;
		PatContext patientContext;
		
		HttpSession session = request.getSession(false);
		patientContext = (PatContext)session.getAttribute("PatientContext");
		PrintWriter out = response.getWriter();
		
		if(patientContext!=null){
			try{
				RecClinicalNotesSectionBean sectionBean = (RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
				sectionBean = new RecClinicalNotesSectionBean();
				String strKey = "";

				strKey = patientContext.getPatientId() + "~" + patientContext.getEncounterId();
				strKey = strKey.trim();

				//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesMain.jsp at 8  ====>>>"+sectionBean+"   strKey   :    "+strKey+"   session   :   "+session);

				sectionBean.removePatientSection(strKey);	
				sectionBean.startPatientSection(strKey);
				PersistenceHelper.putObjectInBean("sectionBean",sectionBean,session); 
			}catch(Exception e){
				System.out.println("Exception while Initializing RecClinicalNotesSectionBean");
				e.printStackTrace(System.out);
			}
			rd = getServletContext().getRequestDispatcher("/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesBasePage.jsp");
			rd.forward(request, response);
		}else{
			out.println("No Patients were selected");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
