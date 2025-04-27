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


public class InsAuthorizationStatusDetails extends HttpServlet
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
		response.getWriter();
		session = request.getSession(false);
		p = (java.util.Properties) session.getValue("jdbc") ;
		try{
			if("AuthStatusCheck".equals(callType)) {
				String responseTxt="";
				responseTxt=authStatusDetails(request, reqParams, p, session);
				
				System.out.println("***Inside InsAuthorizationStatusDetails AuthStatusCheck" +responseTxt);
				
				PrintWriter resp = response.getWriter();
				resp.flush();
				resp.write(responseTxt);
				resp.close(); 						
			}
		}catch (Exception exp) {
			exp.printStackTrace(System.err);
		}
	}
	
	
	private String authStatusDetails(HttpServletRequest request, Map<String, String> reqParams, java.util.Properties p, HttpSession session) throws Exception 
	{	
		Connection dbConn = null;
		ResultSet rs=null;
		CallableStatement ostmt = null;
		p.getProperty("LOCALE");
		request.getSession().getId();	

		String getDispNovalue="", getDrugCodevalue="", strgetOrderLineNo="", authstatusresult="", approvedamtresult="", resultofauthstatus="";
		
		new ArrayList();
		try
		{ 

			dbConn = ConnectionManager.getConnection(request);
	
			String recordsStr = reqParams.toString();
			String[] recordSplit=recordsStr.split("#");
	
			for(String recbillprint:recordSplit)
			{
				String[] recordSplit1=recbillprint.split("~");
	
				PatientDetails authstatus= addValuesToObject(recordSplit1); 
	
				List<PatientDetails> list = new ArrayList<PatientDetails>();
				list.add(authstatus);
				list.toString();
	
				for(int i = 0; i < list.size(); i++) 
				{
		
					if( list.get(i).getPatientId() != null && !"".equals(list.get(i).getPatientId()) ){
						list.get(i).getPatientId().replace("{dataElements=","");
					} 
					
					if( list.get(i).getEncounterId() != null && !"".equals(list.get(i).getEncounterId()) ){
						list.get(i).getEncounterId();
					} 
					
					if( list.get(i).getDispNo() != null && !"".equals(list.get(i).getDispNo()) ){
						getDispNovalue = list.get(i).getDispNo();	
					} 
					
					if( list.get(i).getDrugCode() != null && !"".equals(list.get(i).getDrugCode()) ){
						getDrugCodevalue = list.get(i).getDrugCode();
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
	
					if( list.get(i).getPatientClass() != null && !"".equals(list.get(i).getPatientClass()) ){
						list.get(i).getPatientClass();
					} 
					
					
					/*if( list.get(i).getAuthStatus() != null && !"".equals(list.get(i).getAuthStatus()) ){
						getAuthStatus = list.get(i).getAuthStatus();
					}
	
					if( list.get(i).getBenefitValue() != null && !"".equals(list.get(i).getBenefitValue()) ){
						getBenefitValue = list.get(i).getBenefitValue();
						approvalTotalAmount = Float.parseFloat(getBenefitValue);
					}*/
					
					authstatusresult = InsuranceAuthStatusBean.getauthstatusdetails(getDispNovalue,strgetOrderLineNo,getDrugCodevalue);
					
					approvedamtresult = InsuranceAuthStatusBean.getapporvedamount(getDispNovalue,strgetOrderLineNo,getDrugCodevalue);
					
					if(approvedamtresult == null){
						resultofauthstatus = authstatusresult+"#"+"0";
					}else{
						resultofauthstatus = authstatusresult+"#"+approvedamtresult;
					}
					
	
				}//inner-for-loop
			}//outer-for-loop
		
		}
		catch(Exception exp)
		{
			System.out.println("***Exception in InsAuthorizationStatusDetails - "+exp);
			System.out.println("***Exception in InsAuthorizationStatusDetails - line number "+exp.getStackTrace()[0].getLineNumber());
			exp.printStackTrace();
		}
		finally
		{			
			XHUtil.closeDBResources(rs, ostmt, dbConn);
		}
		
		return resultofauthstatus;			
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
