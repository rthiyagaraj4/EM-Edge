package eXH;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsAuthStatusRecord extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
		doPost(request, response);
	}
	
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    { 
		Map<String, String> reqParams = XHUtil.getRequestParams(request);
		String callType = reqParams.get("callType");	
		HttpSession session;
		java.util.Properties p;
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc") ;
			try{
				if("AuthStatus".equals(callType)) {
					String responseTxt="";
					responseTxt=AuthStatus(request, reqParams, p, session);
					
					System.out.println("***Inside InsAuthStatusRecord AuthStatus - AuthStatus Response... " +responseTxt);
					
					PrintWriter resp = response.getWriter();
					resp.flush();
					resp.write(responseTxt);
					resp.close(); 						
				}
			}catch (Exception exp) {
				exp.printStackTrace(System.err);
			}
	}
	
	
	private String AuthStatus(HttpServletRequest request, Map<String, String> reqParams, java.util.Properties p, HttpSession session) throws Exception {	
		String responseTxt="";
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		String locale = (String) p.getProperty("LOCALE");
			System.out.println("inside locale-----"+locale);
		String facilityid = (String)session.getValue("facility_id")==null ? "" :(String)session.getValue("facility_id");
				System.out.println("inside facilityid-----"+facilityid);
		String userid = p.getProperty( "login_user" )==null ? "" :p.getProperty( "login_user" );
				System.out.println("inside userid-----"+userid);
		String wsno = p.getProperty("client_ip_address") ==null ? "" : p.getProperty("client_ip_address");
				System.out.println("inside wsno-----"+wsno);
		String session_id = request.getSession().getId();	
			System.out.println("inside session_id-----"+session_id);

		String strgetOrderLineNo="";
		new ArrayList();
		try
		{ 

		dbConn = ConnectionManager.getConnection(request);
		
		System.out.println("reqParams--"+reqParams);
		String recordsStr = reqParams.toString();
		String[] recordSplit=recordsStr.split("#");

		for(String recbillprint:recordSplit){
		
		String[] recordSplit1=recbillprint.split("~");
		
		PatientDetails billprint= addValuesToObject(recordSplit1); 

		List<PatientDetails> list = new ArrayList<PatientDetails>();
		list.add(billprint);
		list.toString();
	
			for(int i = 0; i < list.size(); i++) {
	
				if( list.get(i).getPatientId() != null && !"".equals(list.get(i).getPatientId()) ){
					list.get(i).getPatientId().replace("{dataElements=","");
				} 
				
				if( list.get(i).getEncounterId() != null && !"".equals(list.get(i).getEncounterId()) ){
					list.get(i).getEncounterId();
				} 
				
				if( list.get(i).getDispNo() != null && !"".equals(list.get(i).getDispNo()) ){
					list.get(i).getDispNo();
				} 
				
				if( list.get(i).getDrugCode() != null && !"".equals(list.get(i).getDrugCode()) ){
					list.get(i).getDrugCode();
				} 
				
				if( list.get(i).getOrderLineNo() != null && !"".equals(list.get(i).getOrderLineNo()) ){
					strgetOrderLineNo = list.get(i).getOrderLineNo();
					Integer.parseInt(strgetOrderLineNo);
				} 
				
				if( list.get(i).getDispQty() != null && !"".equals(list.get(i).getDispQty()) ){
					list.get(i).getDispQty();
				} 
				
				if( list.get(i).getOrderId() != null && !"".equals(list.get(i).getOrderId()) ){
					list.get(i).getOrderId();
				} 
		
		

			}
			
			
		}
		
		}
		catch(Exception exp)
		{
			System.out.println("***Exception in InsAuthStatusGenerateBill - generatebill procedure "+exp);
			System.out.println("***Exception in InsAuthStatusGenerateBill - generatebill procedure line number "+exp.getStackTrace()[0].getLineNumber());
			exp.printStackTrace();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		
		return responseTxt;			
	}	
	
	public static PatientDetails addValuesToObject(String[] recordSplit1)
	{

		PatientDetails authdetails = new PatientDetails();
		
		if(recordSplit1 !=null && recordSplit1.length > 1){
			authdetails.setPatientId(recordSplit1[0]);
			authdetails.setEncounterId(recordSplit1[1]);
			authdetails.setDispNo(recordSplit1[2]);
			authdetails.setDrugCode(recordSplit1[3]);
			authdetails.setOrderLineNo(recordSplit1[4]);
			authdetails.setDispQty(recordSplit1[5]);
			authdetails.setOrderId(recordSplit1[6]);
			authdetails.setPatientClass(recordSplit1[7]);
		}

		return authdetails;
	}
}			

