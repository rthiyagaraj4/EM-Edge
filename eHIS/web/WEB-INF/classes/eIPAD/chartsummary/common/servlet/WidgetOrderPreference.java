/**
 * 
 */
package eIPAD.chartsummary.common.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eCA.MobileWidgetOrder.MobileWidgetOrderHome;
import eIPAD.chartsummary.common.constants.WidgetItems;


/**
 * @author SaraswathiR
 *
 */
public class WidgetOrderPreference extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WidgetOrderPreference() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session		=	request.getSession(true) ;
		PrintWriter out =	response.getWriter();
		java.util.Properties	p		=	null;
		p =	(java.util.Properties)session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		
		HashMap htWidgetOrder = new HashMap();
		
		
		
		String str_wid_vitals = request.getParameter("wid_vitals")==null?"0":request.getParameter("wid_vitals");
		String str_wid_allergy = request.getParameter("wid_allergy")==null?"0":request.getParameter("wid_allergy");
		String str_wid_procedure = request.getParameter("wid_procedure")==null?"0":request.getParameter("wid_procedure");
		String str_wid_problems = request.getParameter("wid_problems")==null?"0":request.getParameter("wid_problems");
		String str_wid_notes = request.getParameter("wid_notes")==null?"0":request.getParameter("wid_notes");
		String str_wid_results = request.getParameter("wid_results")==null?"0":request.getParameter("wid_results");
		String str_wid_pendingorders = request.getParameter("wid_pendingorders")==null?"0":request.getParameter("wid_pendingorders");
		String str_wid_medications = request.getParameter("wid_medications")==null?"0":request.getParameter("wid_medications");
		
		int wid_vitals = parseWithDefault(str_wid_vitals,0);
		int wid_allergy = parseWithDefault(str_wid_allergy,0);
		int wid_procedure = parseWithDefault(str_wid_procedure,0);
		int wid_problems = parseWithDefault(str_wid_problems,0);
		int wid_notes = parseWithDefault(str_wid_notes,0);
		int wid_results = parseWithDefault(str_wid_results,0);
		int wid_pendingorders = parseWithDefault(str_wid_pendingorders,0);
		int wid_medications = parseWithDefault(str_wid_medications,0);
		
		String login_user = (String)session.getAttribute("login_user");
		String facility_id = (String)session.getAttribute("facility_id"); 
		String wsNo = request.getRemoteAddr();
		if(session!=null){
			if(login_user!=null && wid_vitals!=0 && wid_allergy!=0 && wid_procedure!=0 && wid_problems!=0 && wid_notes!=0 && wid_results!=0 && wid_pendingorders!=0 && wid_medications!=0){
				
				HashMap<String, Integer> widgetOrderHash = new HashMap<String, Integer>();
				widgetOrderHash.put(WidgetItems.VITALS.getWidgetId(), wid_vitals);
				widgetOrderHash.put(WidgetItems.ALLERGY.getWidgetId(), wid_allergy);
				widgetOrderHash.put(WidgetItems.PROCEDURE.getWidgetId(), wid_procedure);
				widgetOrderHash.put(WidgetItems.PROBLEMS.getWidgetId(), wid_problems);
				widgetOrderHash.put(WidgetItems.NOTES.getWidgetId(), wid_notes);
				widgetOrderHash.put(WidgetItems.RESULTS.getWidgetId(), wid_results);
				widgetOrderHash.put(WidgetItems.PENDINGORDERS.getWidgetId(), wid_pendingorders);
				widgetOrderHash.put(WidgetItems.MEDICATIONS.getWidgetId(), wid_medications);
				//htWidgetOrder.put("wid_vitals",wid_vitals);
				//htWidgetOrder.put("wid_allergy",wid_allergy);
				//htWidgetOrder.put("wid_procedure",wid_procedure);
				//htWidgetOrder.put("wid_problems",wid_problems);
				//htWidgetOrder.put("wid_notes",wid_notes);
				//htWidgetOrder.put("wid_results",wid_results);
				//htWidgetOrder.put("wid_pendingorders",wid_pendingorders);
				//htWidgetOrder.put("wid_medications",wid_medications);
				htWidgetOrder.put("widgetOrderHash",widgetOrderHash);
				htWidgetOrder.put("login_user", login_user);
				htWidgetOrder.put("facility_id", facility_id);
				htWidgetOrder.put("wsNo", wsNo);
				
				try
				{
					boolean local_ejbs = false;
					
					if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) &&(getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE"))) local_ejbs = true;
	
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/MobileWidgetOrder",MobileWidgetOrderHome.class,local_ejbs);
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					
					Object argArray[] = new Object[2];
					argArray[0] = p;
					argArray[1] = htWidgetOrder;
					
					Class [] paramArray = new Class[2];
					paramArray[0] = p.getClass();
					paramArray[1] = htWidgetOrder.getClass();
					
	
	
					java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insertWidgetOrder",paramArray)).invoke(busObj,argArray);
	
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					htWidgetOrder.clear();
								
					boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;
					out.println(inserted);
					if(!inserted){
						String error = ( ((String ) results.get( "error" )).toString());
						out.println(error);
					}
					
				}
				catch(Exception e)
				{
					out.println("Widget ordering  Servlet Exception:"+e);
					
					e.printStackTrace();
					out.println("Exception while accessing MobileWidgetOrder EJB for Inseting Records!"+e);
					
				}
			}
		}
	}
	
	public int parseWithDefault(String number, int defaultVal) {
		  try {
		    return Integer.parseInt(number);
		  } catch (NumberFormatException e) {
		    return defaultVal;
		  }
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
