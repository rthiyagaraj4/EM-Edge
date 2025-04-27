<%@ page language="java" import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*, java.text.SimpleDateFormat,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="org.json.simple.JSONObject"%>	
    

<%
HttpSession httpSession = request.getSession(false);
Properties p = (Properties) httpSession.getValue("jdbc");
Connection con = con=ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs = null;
String includeHomeMedicationAllYN="N";
String preappDurCapping="N"; //Added V180725-Gayathri/MMS-DM-CRF-0126
String dailyLimitYN ="N"; //Added V190404-Dhananjay/MMS-DM-CRF-0129
boolean dailyLimitSiteSpec = false;//Added V190405-Dhananjay/MMS-DM-CRF-0129
JSONObject obj=new JSONObject();
try{
	
	
	String service_code=request.getParameter("service_code");
	String called_from=request.getParameter("calledFrom");
	String type=request.getParameter("type");
	String locale = (String)session.getAttribute("LOCALE");
	System.out.println("service_code"+service_code+"/"+"type"+type+"/"+"locale"+locale);

	if("policyDefn".equals(called_from)){	
	 try {
		pstmt=con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?)  from dual");
		
		pstmt.setString(1,locale);
		pstmt.setString(2,type);
		pstmt.setString(3,service_code);
		
		rs = pstmt.executeQuery();
		while (rs.next()) {
			includeHomeMedicationAllYN =rs.getString(1);
		}
		System.out.println("includeHomeMedicationAllYN" + includeHomeMedicationAllYN);
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("includeHomeMedicationAllYN" + e);
	} 
	obj.put("includeHomeMedicationAllYN",includeHomeMedicationAllYN);
	System.out.println("includeHomeMedicationAllYN=frm back end=="+includeHomeMedicationAllYN);
	
	}
	//Added V180725-Gayathri/MMS-DM-CRF-0126/Starts
	if("preApproval".equals(called_from)){
		if ("".equals(service_code)){ preappDurCapping="N"; }
		else{
	 try {
			pstmt=con.prepareStatement("select blcommonproc.bl_preappr_ph_dur_yn(?,?,?) from dual");
			
			
			pstmt.setString(1,type);
			pstmt.setString(2,service_code);
			pstmt.setString(3,locale);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				preappDurCapping =rs.getString(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("preappDurCapping" + e);
		} 
		}
		obj.put("preappDurCapping",preappDurCapping);
		//System.out.println("preappDurCapping=frm back end=="+preappDurCapping);
	}
//Added V180725-Gayathri/MMS-DM-CRF-0126/Ends
	//Added V190404-DHANANJAY/MMS-DM-CRF-0129/Starts
	if("rate_based_dtl".equals(called_from)){
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT"); //Added V190405-Dhananjay/MMS-DM-CRF-0129
	 	if(dailyLimitSiteSpec) {
			if ("".equals(service_code)) {
				dailyLimitYN ="N";
			} else {
			 	try {
					pstmt=con.prepareStatement("select blcommonproc.bl_pharm_service_yn(?,?,?) from dual"); 
					pstmt.setString(1,locale);
					pstmt.setString(2,type);
					pstmt.setString(3,service_code);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						dailyLimitYN =rs.getString(1);
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		else 
		{
			dailyLimitYN ="R"; //Added V190405-Dhananjay/MMS-DM-CRF-0129
		}
		obj.put("dailyLimitYN",dailyLimitYN);
	}
	//Added V190404-DHANANJAY/MMS-DM-CRF-0129/Ends
	

	out.println(obj);
   
	
}


catch(Exception ee){
	
	ee.printStackTrace();
	System.err.println("PkgDefIncludeHomeMedicationAjax : " + ee);
}finally
{	

	ConnectionManager.returnConnection(con);
}	


%>
