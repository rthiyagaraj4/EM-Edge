<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,java.text.*,eBL.*" contentType="text/html;charset=UTF-8" %>
<%@page import="eBL.BLReportIdMapper"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
 <%@page import="org.json.simple.JSONObject"%>	

<%
	Connection con = null;
	PreparedStatement pstmt=null; 
	ResultSet rst =null;

	System.err.println("BillingPasswrCheckAjax.jsp:"+request.getQueryString());
		try
	{
	String userID=request.getParameter("user_id");
	if(userID == null) userID = "";
		userID = userID.toUpperCase();
	String password=request.getParameter("password");
	if(password==null) password="";
		password=password.trim();	
		password=password.toUpperCase();
	String facilityID=request.getParameter("facilityID");
	int fc_count=0;
	String called_from = request.getParameter("called_from");
	String responseString = "";
	String pass_word = "";
	String locale	= (String)session.getValue("LOCALE");
	if(locale == null) locale = "en";
	String fc_value=null;
		

		con	=	ConnectionManager.getConnection(request);
		System.err.println("called_from:"+called_from);
		if(("authUser").equals(called_from))
		{
			
			String valid_eligible_user = "";
		
			String query_elgb_user="select eff_status, nvl(app_password.decrypt(appl_user_password),'~!@') as password from sm_appl_user a where a.appl_user_id= UPPER(?)";
			System.err.println("	query_elgb_user:"+query_elgb_user+"/"+userID+"/"+facilityID);
		
			pstmt = con.prepareStatement(query_elgb_user);	
			pstmt.setString(1,userID);

			rst = pstmt.executeQuery();
			while(rst!=null && rst.next())
			{				
				valid_eligible_user = rst.getString(1);
				pass_word = rst.getString("password");
				pass_word=pass_word.trim();
				pass_word=pass_word.toUpperCase();
			}
		
			if(valid_eligible_user.equals("E")){
				if(pass_word.equals(password)){			
					responseString = "Y:::"+valid_eligible_user;	//valid user					
				}
				else{
					responseString = "P:::"+valid_eligible_user;	//Invalid pin						
				}			
			} else {
				responseString = "U:::"+valid_eligible_user;	//Invalid user	
			}

			out.println(responseString);   
		}
		else if(("facilityForUser").equals(called_from)){
			String facSql = "SELECT   facility_id, facility_name from sm_facility_param_lang_vw where language_id = ? and facility_id in (select facility_id FROM sm_facility_for_user  WHERE appl_user_id = ? AND (TRUNC (SYSDATE) BETWEEN NVL (access_eff_date_from,TO_DATE ('01/01/1472', 'dd/mm/rrrr')) AND NVL (access_eff_date_to,TO_DATE ('31/12/5000', 'dd/mm/rrrr'))) INTERSECT SELECT   facility_id FROM sm_facility_for_resp  WHERE resp_id = 'EBL_MANAGER') ORDER BY 2";
				
			System.err.println("facSql:"+facSql+"/"+locale+"/"+userID);
				pstmt = con.prepareStatement( facSql ) ;//Fine Tuned Above Query
				pstmt.setString( 1, locale ) ;
				pstmt.setString( 2, userID ) ;

				rst = pstmt.executeQuery() ;
				while(rst!=null && rst.next()){
					fc_count++;
					if(fc_count==1){
						fc_value=rst.getString( "facility_id" )+"~"+rst.getString( "facility_name" );
					}else{
					fc_value=fc_value+"$"+rst.getString( "facility_id" )+"~"+rst.getString( "facility_name" );
					}
				}
				out.write(fc_value+"^"+fc_count);
		}	
		else if(("pageCalledYN").equals(called_from)){
			System.err.println("pageCalledYN set in Session-begin");
			session.setAttribute("pageCalledYN","Y");
			System.err.println("pageCalledYN set in Session-end");
			out.write("success");
		}
	}
catch(Exception e){	
	e.printStackTrace();
	System.err.println("BillingPasswrCheckAjax.jsp : " + e);
}finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>

 
