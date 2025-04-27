package eBL;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hsqldb.lib.HashMap;

import com.google.gson.JsonObject;

import eBL.reprintreport.bc.ReprintReportBC;
import eBL.reprintreport.request.ReprintRequest;
import eBL.reprintreport.response.ReprintResponse;

import com.google.gson.JsonObject;


/**
 * Servlet implementation class BLPatientPayerSummaryDetail
 */
public class BLPatientPayerSummaryDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
      /**
     * @see HttpServlet#HttpServlet()
     */
    public BLPatientPayerSummaryDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    System.out.println("Reached to servlet");
		    
			ReprintRequest mainRequest = new ReprintRequest();
			ReprintResponse mainResponse = null;
			BlPatientPayerSummary getData=new BlPatientPayerSummary();
			JsonObject jsonObj = new JsonObject();
			PrintWriter out = response.getWriter();
			ReprintRequest bean = null;
			try{
			bean = new ReprintRequest();	
			bean.setParam1(request.getParameter("custGrpCode"));
			bean.setParam2(request.getParameter("custCode"));
			bean.setParam3(request.getParameter("Bill_Duration_From"));
			bean.setParam4(request.getParameter("Bill_Duration_To"));
			bean.setParam5(request.getParameter("App_status"));
			bean.setParam6(request.getParameter("Episodetype_OP"));
			bean.setParam7(request.getParameter("Episodetype_IP"));
			bean.setParam8(request.getParameter("Episodetype_EM"));
			bean.setParam9(request.getParameter("Episodetype_DC"));
			bean.setParam10(request.getParameter("PatientPayerWisebut"));
			bean.setParam11(request.getParameter("ReportOptionbut"));
			bean.setParam12(request.getParameter("userid"));
			bean.setFacilityId(request.getParameter("facility_id"));
			bean.setReportId(request.getParameter("report_id"));			
			
			mainResponse=getData.getPatientPayerSummary(bean);
			
			if(mainResponse.isStatus()){
				jsonObj.addProperty("Success", "Y");
				jsonObj.addProperty("SessionID",mainResponse.getSessionId());
				jsonObj.addProperty("PgmDate",mainResponse.getPgmDate());	
				out.println(jsonObj);
			}
			else{
				jsonObj.addProperty("Success","N");
				jsonObj.addProperty("errorMessage", mainResponse.getError());
				out.println(jsonObj);
			}
			}catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in BLPatientPayerSummaryDetail "+e);
				jsonObj.addProperty("errorMessage", "N");			
				out.println(jsonObj);
			}
	}	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

}
