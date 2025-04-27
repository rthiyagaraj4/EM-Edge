<% 
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?			?			?
06/04/2015		IN048704		Nijitha S							HSA-CRF-0175
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCA/js/CAMenu.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
 <jsp:useBean id="keyGen" scope="page" class="eCA._ca_license_rights">
 </jsp:useBean>

<html>
<title> IBA Health </title>
<script>//window.name='eHospital Information'</script>
<%
Connection con = null;
PreparedStatement stmt=null,stmt1=null; 
ResultSet rset =null,rs=null,rset1=null;
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

PreparedStatement pstmt = null;
String menu_Active = "N";
String reln_req_yn = "N";
String from_service_yn = request.getParameter("from_service_yn")==null?"N":request.getParameter("from_service_yn");
StringBuffer sql_reln = new StringBuffer();

String relnid ="";
String scrollbars = "No";
//String lookupFileName = request.getParameter("lookupFileName")==null?"":request.getParameter("lookupFileName");
//IN048704 Starts
String referral_id 	=	request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
String assign_confirm_referral_yn	=	request.getParameter("assign_confirm_referral_yn")==null?"":request.getParameter("assign_confirm_referral_yn");
String assignorConfirmKey	=	request.getParameter("assignorConfirmKey")==null?"":request.getParameter("assignorConfirmKey");
String patient_id ="";	
String episode_id ="";	
//IN048704 Ends
try{

	con =  ConnectionManager.getConnection(request);
    
    String login_user=(String)session.getValue("login_user");
	if(login_user == null)
		login_user = "";
	String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(a.func_role_id,?,'1') practitioner_name, pract_type,'N' TAB_MENU_YN , (select c.ESTABLISH_RELN_REQ_YN from ca_encntr_param c ) reln_req_yn from sm_appl_user a, am_practitioner b where b.practitioner_id=a.func_role_id and appl_user_id = ? and func_role ='P' ";
    String func_role_id="",practitioner_name="",pract_type="";

	
	
	stmt=con.prepareStatement(sql);
	stmt.setString(1,locale);
	stmt.setString(2,login_user);
	
    rset=stmt.executeQuery();
	
    if(rset !=null && rset.next())
    {
			
		func_role_id=rset.getString("func_role_id");
		if(func_role_id == null) func_role_id="";

		practitioner_name=rset.getString("practitioner_name");
		if(practitioner_name == null) practitioner_name="";

		pract_type = rset.getString("pract_type");
		if(pract_type == null) pract_type="";

		menu_Active = rset.getString("TAB_MENU_YN");
		if (menu_Active==null) menu_Active="Y";

		//out.println("<script>alert('menu_Active   :   "+menu_Active+"')</script>");

		reln_req_yn = rset.getString("reln_req_yn");
		//if (reln_req_yn==null) reln_req_yn="N";	
		
		

    session.putValue("ca_practitioner_id",func_role_id);
    session.putValue("practitioner_name",practitioner_name);
    session.putValue("practitioner_type",pract_type);


    String query_string = request.getQueryString() == null? "" :request.getQueryString();
	patient_id =request.getParameter("patient_id") ;//IN048704
	episode_id =request.getParameter("episode_id") ;//IN048704



	if (patient_id == null) patient_id= "";

	if(!patient_id.equals(""))
		scrollbars = "Yes";
  
    String limit_function_id = request.getParameter("limit_function_id")== null?"":request.getParameter("limit_function_id");
	String chartTitle = request.getParameter("chartTitle")== null?"":request.getParameter("chartTitle");
    String child_window = "N";
    String resp_id = (String) session.getValue("responsibility_id");
	if(resp_id == null)
		resp_id = "";

    String facility_id = (String) session.getValue("facility_id");
	if(facility_id == null)
		facility_id = "";
	
	if(!patient_id.equals(""))
		 child_window = "Y";

    query_string=query_string + "&child_window="+child_window+"&limit_function_id="+limit_function_id+"&chartTitle="+chartTitle;



    String respid=(String) session.getValue("responsibility_id");
	
	if(respid == null)
		respid = "";

	String resp_name="";
	String qry = "select resp_name from sm_resp_lang_Vw where resp_id=? AND LANGUAGE_ID = ? ";
	pstmt	=	con.prepareStatement(qry);
	pstmt.setString(1,respid);
	pstmt.setString(2,locale);

	rs=pstmt.executeQuery();
	if(rs.next())
		resp_name = rs.getString(1)==null?"":rs.getString(1);
	
	session.putValue("resp_name",resp_name);
	rs.close();
	pstmt.close();

	if(!patient_id.equals("")&&reln_req_yn.equals("Y"))
	{
		//out.println("<script>alert('patient_id   :   "+patient_id+"')</script>");	
		sql_reln.append("Select PRACT_RELN_ID PHYS_PROV_RELN_ID from CA_ENCNTR_PRACT_RELN Where FACILITY_ID = ? AND NVL(ENCOUNTER_ID,0) = NVL(?,0) AND PRACTITIONER_ID=? AND PATIENT_ID=? AND STATUS ='01' AND nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) BETWEEN SYSDATE AND  nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))AND BEGIN_DATE_TIME<=SYSDATE+.0006 ");	
			
			
			stmt1 = con.prepareStatement(sql_reln.toString());
			stmt1.setString(1,facility_id);
			stmt1.setString(2,episode_id);
			stmt1.setString(3,func_role_id);
			stmt1.setString(4,patient_id);
			
			/*if(!(episodeid == null || episodeid.equals(""))){
				stmt.setString(4,episodeid);
			}*/
			
			rset1 = stmt1.executeQuery();

            if(rset1!=null && rset1.next())
            {
				relnid = rset1.getString("PHYS_PROV_RELN_ID")==null?"":rset1.getString("PHYS_PROV_RELN_ID");
							}
			if(rset1!=null)      rset1.close();
			if(stmt1!=null)  stmt1.close();

		

	} 

	if(!patient_id.equals(""))
	{
	
		query_string = query_string + "&relationship_id="+relnid; 
	}
  
	String titleFrameSize = "8%";
	if(patient_id !=""){
		titleFrameSize= "50%";
	}else{
		titleFrameSize= "8%";
	}

	if ( reln_req_yn !=null && reln_req_yn.length() >0);
		else{
			out.println("<script>alert(getMessage('MISSING_ENC_PARAM','CA'));</script>");
			out.println("<script>window.history.go(-1)</script>");
			return;			
		}

%>
<script>
    if("<%=child_window%>" == "N"){
        window.onbeforeunload =closeWindows
	}
	else
	{
		/**Modified by Parimala on 20/12/2003 for clearing the beans related to the arch*/
		window.onbeforeunload = clearObjects ;
		/**Ends Here*/
	}
</script>
    <frameset border="0" framespacing=0 rows='8%,*,5%,1%' scrolling='auto' id="mainFrameSet">
		<frame name='CommonToolbar' src='CAMainTitle.jsp?<%=query_string%>&reln_req_yn=<%=reln_req_yn%>&fromNewFunction=Y' noresize  frameborder="0" marginheight=0 marginwidth=0 SCROLLING='no' noresize>
		<%
		if(menu_Active.equals("N"))
		{
			//out.println("<script>alert('in If : "+menu_Active+"')</script>");	
			%> 
			<frameset border="0" framespacing=0 cols="0%,0%,*,0%" scrolling='yes' id='workArea' name='workArea'>
				<frame name='menuFrame' id='menuFrame' src='../../eCommon/html/blank.html' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='<%=scrollbars%>' BORDERCOLOR='red' noresize>
				<frame name='matFrame' id='matFrame' src='../../eCommon/html/blank.html' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='yes' BORDERCOLOR='red'>
			<!-- 	<frame name='subMenuFrame' src='../../eOH/jsp/OHDentalChartTabSearch.jsp?<%=query_string%>' frameborder=1  marginheight=0 marginwidth=0 SCROLLING='yes' BORDERCOLOR='red'> -->
				<frame name='workAreaFrame' id='workAreaFrame' src='../../eCommon/html/blank.html'   frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no' BORDERCOLOR='green' noresize>
				<frame name='lookupMenuFrame' id='lookupMenuFrame' src='../../eCommon/html/blank.html'   frameborder=1  marginheight=1 marginwidth=1 SCROLLING='auto' BORDERCOLOR='red'>
			</frameset>
		 <%}else if(menu_Active.equals("Y")){%> 			
			<frameset frameborder=0 framespacing=0 rows="5%,5%,*,5%" scrolling='no' id='workArea' name='workArea'>
				<frame name='Options1' id='Options1' src='../../eCA/jsp/CAMainOptions1.jsp?<%=query_string%>&reln_req_yn=<%=reln_req_yn%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no'>
				<frame name='Options2' id='Options2' src='../../eCommon/html/blank.html' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no'>
				<frame name='workAreaFrame' id='workAreaFrame' src='../../eCommon/html/blank.html' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no'>
				<frame name='Options3' id='Options3' src='../../eCommon/html/blank.html' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='no'>
			</frameset>
		<%}%> 
        <frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize  frameborder=0  marginheight=0 marginwidth=0 SCROLLING='auto' noresize> 
         
	</frameset>
</html>

<%
}// E.O.F if cond
else
{
    out.println("<script>alert(getMessage('INVALID_CA_USER','CA'));</script>");
	
	if(from_service_yn.equals("Y")){
	    out.println("<script>parent.window.close();</script>");	
	}else{
	   out.println("<script>location.href='../../eCommon/jsp/dmenu.jsp'</script>");
	}
}

}
    catch(Exception e){
		e.printStackTrace();
		//out.println("Exception in CAMain.jsp"+e.toString());//COMMON-ICN-0181
    }
    finally{
        if (rset !=null) rset.close();
		if (stmt!=null) stmt.close();
        if (con !=null) ConnectionManager.returnConnection(con,request);
		

    }
%>

<script>

	window.focus();
	//IN048704 Starts
	if(("<%=assign_confirm_referral_yn%>"=="Y") && ("<%=assignorConfirmKey%>"=="AC"))
				{
					var features   = 'dialogTop:72;dialogHeight:41;dialogWidth:65;status=no';
					var arguments  = '' ;		
					window.showModalDialog("../../eIP/jsp/PaintReferralPatientDetails.jsp?encounterId=<%=episode_id%>&patientid=<%=patient_id%>&called_from=CA&call_function=BedSideReferral&referralID=<%=referral_id%>",arguments,features);
					
				}
	//IN048704 Ends			
</script>
