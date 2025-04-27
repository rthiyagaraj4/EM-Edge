<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></title>
	<script language='javascript' src='../js/PatProblem.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//String a=request.getQueryString();
String facility_id			= (String)session.getValue("facility_id");
String Patient_Id			= request.getParameter("patient_id");
String Encounter_Id			= request.getParameter("episode_id");
String oper_num				= request.getParameter("oper_num")==null?"":request.getParameter("oper_num");

String Practitioner_Id		= "";
String relationship_id		= request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
String Locn_Code			= request.getParameter("location_code");
String Locn_Type			= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");

if(Locn_Type.equals("")) 
	Locn_Type="C";

String modal_yn				= request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");


String term_code			= request.getParameter("term_code")==null?"":request.getParameter("term_code");
String Sec_Hdg_Code			= request.getParameter("Sec_Hdg");
String function				= request.getParameter("Function");
String patient_type			= request.getParameter("patient_type");
String context				= request.getParameter("Context");
String logicalseqno			= request.getParameter("Logical_Seq")==null?"":request.getParameter("Logical_Seq");
String patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
String called_from_ip = request.getParameter("IP_YN")==null?"N":request.getParameter("IP_YN");

String age = request.getParameter("Age")==null?"":request.getParameter("Age");
String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");

Practitioner_Id		= request.getParameter("ip_practitioner_id")==null?"":request.getParameter("ip_practitioner_id");	

if(Practitioner_Id.equals("") || Practitioner_Id.equals("null")){
		Practitioner_Id		= (String)session.getValue("ca_practitioner_id");	
}

/* Added by Chitra */
String stagedesc = request.getParameter("stage_desc")==null?"":request.getParameter("stage_desc");
String stagecode = request.getParameter("stage_code")==null?"":request.getParameter("stage_code");
//added for notes
String visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
String episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
if(stagecode.equals("A")){
	out.println("<script>window.document.title='Admitting Diagnosis'</script>");
}else if(called_from_ip.equals("N")){
	out.println("<script>window.document.title='Diagnosis'</script>");
}
if(!stagecode.equals("")) Locn_Type = "N";

Connection con = null; //(Connection)session.getValue("connection") ;
PreparedStatement stmt = null;
ResultSet rset = null;
PreparedStatement pstmt	= null;
ResultSet rs = null;
String past_visit="";
boolean func_appl_yn = true;

try
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement("select ca_get_func_appl_past_visit(?,?,?,?,?) from dual");
	pstmt.setString(1,facility_id);		// facility id
    pstmt.setString(2,"PROCEDURE");		// function
    pstmt.setString(3,Encounter_Id);	// episode_id
    pstmt.setString(4,patient_class);   // episode_type
    pstmt.setString(5,Patient_Id); 

	rs = pstmt.executeQuery();
    while(rs!=null && rs.next())
    {
		past_visit = rs.getString(1);
    }
    if(rs!=null) rs.close();
    if(pstmt!=null) pstmt.close();
             
    // If the Episode is not closed, Continue.
    if(past_visit!=null && past_visit.equalsIgnoreCase("FALSE"))
    {
		func_appl_yn = false;
		%>
		<script>
		alert(getMessage('CA_DIAG_PROCEDURE','CA'));
		</script> 
		<%
    }
	if(func_appl_yn)
	{
		/* ---Ends---  @Added on 08/08/2002 by Prakash.S */
		stmt = con.prepareStatement("select 1 from mr_parameter"); 
		rset = stmt.executeQuery();
		
		String str ="Logical_Seq=" +logicalseqno + "&Function=" + function +"&Patient_Id=" +Patient_Id  +"&Encounter_Id=" +Encounter_Id+"&Practitioner_Id="+ Practitioner_Id + "&Locn_Code=" + Locn_Code+"&Locn_Type=" + Locn_Type+ "&f_authorize_yn=N&P_context="+context+ "&stage_code="+ stagecode+ "&stage_desc="+ stagedesc + "&patient_class=" + patient_class + "&called_from_ip="+called_from_ip;
		

		if(rset.next())
		{
		%>
	
			<% if(called_from_ip.equals("Y") ||modal_yn.equals("Y")) {%>
			<frameset rows='20%,3%,*,5%,0%,0%,7%'  framespacing=0 border="0">
			<% }else {%>
			<frameset rows='27%,4%,*,6%,0%'  framespacing=0 border="0">
				<%}%>
			<frame name ="PatProblemQueryResult" src="PatProblemQueryResult.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&relationship_id=<%=relationship_id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sec_Hdg_Code=<%=Sec_Hdg_Code%>&patient_type=<%=patient_type%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&oper_num=<%=oper_num%>" marginwidth=0 marginheight=0 frameborder=0 noresize> </frame>
			<frame name="PatProblemHeader" src="PatProblemHeader.jsp?"  marginwidth=0 marginheight=0 frameborder=0 noresize> </frame>
			<frame name ="addModifyPatProblem" src="addModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&QueryString=<%=java.net.URLEncoder.encode(str)%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&visit_adm_date=<%=visit_adm_date%>&episode_type=<%=episode_type%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&diag_code=<%=term_code%>&oper_num=<%=oper_num%>" marginwidth=0 marginheight=0 frameborder=0 scrolling='yes'  noresize></frame>
			<frame name ="PatProblemQueryTools" src="PatProblemQueryTools.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&patient_type=<%=patient_type%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&relationship_id=<%=relationship_id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&Sec_Hdg_Code=<%=Sec_Hdg_Code%>&P_context=<%=context%>&stage_desc=<%=stagedesc%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>" marginwidth=0 marginheight=0 frameborder=0 scrolling='no'  noresize></frame>
			<frame name='support' src='../../eCommon/html/blank.html' marginwidth=0 marginheight=0 frameborder=0 scrolling='no'  noresize></frame>
			<% if(called_from_ip.equals("Y") ||modal_yn.equals("Y")) {%>
				<frame name='msgframe0' src='../../eCommon/jsp/error.jsp' marginwidth=0 marginheight=0 frameborder=0 scrolling='no' ></frame> 
				<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' marginwidth=0 marginheight=0 frameborder=0 scrolling='no' ></frame>
				<% } %>
			</frameset>
		<%
		}
		else
		{
			out.println("<script>alert(getMessage('DEFINE_MR_PARAM','CA'))</script>");
		}
	}//end of func_appl_yn
	
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
} 
catch (Exception e) 
{
	//out.println("Exception @ try "+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally{
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
