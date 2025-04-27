<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<title><fmt:message key="eMR.DiagnosisRecoding.label" bundle="${mr_labels}"/></title>
	<script language='javascript' src='../js/DiagRecodePatProblem.js'></script>
	<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
    <!--<script src='../../eCA/js/CAMessages.js' language='javascript'></script>-->
	<script language='javascript' src='../../eCommon/js/common.js'></script>

</head>
<%
//String a=request.getQueryString();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String facility_id			= (String)session.getValue("facility_id");
String Patient_Id			= request.getParameter("PatientId");
String Encounter_Id			= request.getParameter("episode_id");
String oper_num				= request.getParameter("oper_num")==null?"":request.getParameter("oper_num");

String calledFromDeathReg = request.getParameter("called_from_death_reg") == null ? "" : request.getParameter("called_from_death_reg");
String patLineYN = request.getParameter("pat_line_yn") == null ? "" : request.getParameter("pat_line_yn");

String chkRec = "";
String dispFrame = "";

String sql_mr_death_reg = "select 1 from MR_DEATH_REGISTER_HDR where FACILITY_ID=? and ENCOUNTER_ID  =?";
PreparedStatement ps_death_reg = null;
ResultSet res_death_reg = null;

String Practitioner_Id		= "";
String relationship_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
String Locn_Code			= request.getParameter("location_code");
String Locn_Type			= request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
if(Locn_Type.equals("")) Locn_Type="C";
String modal_yn				= request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");

//added by kishore on 5/30/2005
String term_code			= request.getParameter("term_code")==null?"":request.getParameter("term_code");
//String term_set_id			= request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
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

String rows = "27%,*,6%,0%";

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
	out.println("<script>window.document.title=getLabel(\"eMR.AdmittingDiagnosis.label\",\"MR\");</script>");
}else if(called_from_ip.equals("N")){
	out.println("<script>window.document.title=getLabel(\"eMR.DiagnosisRecoding.label\",\"MR\");</script>");
}
if(!stagecode.equals("")) Locn_Type = "N";
/* Added by Chitra */
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

	if(calledFromDeathReg.equals("Y"))
	{
		try
		{
			ps_death_reg = con.prepareStatement(sql_mr_death_reg);
			ps_death_reg.setString(1,facility_id);
			ps_death_reg.setString(2,Encounter_Id);
			res_death_reg = ps_death_reg.executeQuery();
			while(res_death_reg != null && res_death_reg.next())
			{
				chkRec = res_death_reg.getString(1) == null ? "" : res_death_reg.getString(1);
			}			

			if(chkRec.equals(""))
			{
				dispFrame = "dispFrame";
				%>
					<script>
						alert('cannot record values!!!');
					</script>
				<%
			}
			
			if(res_death_reg != null) res_death_reg.close();
			if(ps_death_reg != null) ps_death_reg.close();			
		}
		catch(Exception ee)
		{
			ee.printStackTrace(System.err);
		}
		finally
		{
			if(res_death_reg != null) res_death_reg.close();
			if(ps_death_reg != null) ps_death_reg.close();			
		}
	}
	/* ---Start---  @Added on 08/08/2002 by Prakash.S */
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
		alert(getMessage('DIAG_PROCEDURE','MR'));
		parent.window.close();
		</script> 
		<%
    }
	if(!dispFrame.equals("dispFrame"))
	{
	if(func_appl_yn)
	{
		/* ---Ends---  @Added on 08/08/2002 by Prakash.S */
		stmt = con.prepareStatement("select 1 from mr_parameter"); 
		rset = stmt.executeQuery();
		
		String str ="Logical_Seq=" +logicalseqno + "&Function=" + function +"&Patient_Id=" +Patient_Id  +"&Encounter_Id=" +Encounter_Id+"&Practitioner_Id="+ Practitioner_Id + "&Locn_Code=" + Locn_Code+"&Locn_Type=" + Locn_Type+ "&f_authorize_yn=N&P_context="+context+ "&stage_code="+ stagecode+ "&stage_desc="+ stagedesc + "&patient_class=" + patient_class + "&called_from_ip="+called_from_ip;

		if(patLineYN.equals("Y")) rows = "9%,23%,4%,*,6%,0%";
		else rows = "27%,*,6%,0%";

		if(calledFromDeathReg.equals("Y")) rows = "8%,20%,3%,*,5%,7%,7%";
		else rows = "6.5%,22%,*,5%,25%,7%,7%";



		
		if(rset.next())
		{			
		%>
	
	<%	if(called_from_ip.equals("Y") && modal_yn.equals("Y")) 
		{	%>
			
			<frameset rows='7%,20%,*,5%,25%,0%,7%'  framespacing=0 border="1">
	<%	}else{	%>
				
			<frameset rows='<%=rows%>'  framespacing=0 border="1">
	<%	}	%>
			
			
			<frame name='patientLineFrame' src='../../eCommon/jsp/pline.jsp?Patient_Id=<%=Patient_Id%>&EncounterId=<%=Encounter_Id%>' framespacing=0 border="0">
			
			<frame name ="PatProblemQueryResult" src="DiagRecodePatProblemQueryResult.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&relationship_id=<%=relationship_id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Sec_Hdg_Code=<%=Sec_Hdg_Code%>&patient_type=<%=patient_type%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&oper_num=<%=oper_num%>&patLineYN=<%=patLineYN%>&calledFromDeathReg=<%=calledFromDeathReg%>" marginwidth=0 marginheight=0 frameborder=0 noresize> </frame>			

			<frame name ="addModifyPatProblem" src="DiagRecodeaddModifyPatProblem.jsp?Logical_Seq=<%=logicalseqno%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&relationship_id=<%=relationship_id%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&P_context=<%=context%>&stage_code=<%=stagecode%>&stage_desc=<%=stagedesc%>&QueryString=<%=java.net.URLEncoder.encode(str)%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&visit_adm_date=<%=visit_adm_date%>&episode_type=<%=episode_type%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&diag_code=<%=term_code%>&oper_num=<%=oper_num%>&patLineYN=<%=patLineYN%>&calledFromDeathReg=<%=calledFromDeathReg%>" marginwidth=0 marginheight=0 frameborder=0   noresize></frame>
			
			<frame name = "PatProblemQueryTools" src="DiagRecodePatProblemQueryTools.jsp?Logical_Seq=<%=logicalseqno%>&stage_code=<%=stagecode%>&patient_type=<%=patient_type%>&Function=<%=function%>&Patient_Id=<%=Patient_Id%>&relationship_id=<%=relationship_id%>&Encounter_Id=<%=Encounter_Id%>&Practitioner_Id=<%=Practitioner_Id%>&Locn_Code=<%=Locn_Code%>&Locn_Type=<%=Locn_Type%>&f_authorize_yn=N&Sec_Hdg_Code=<%=Sec_Hdg_Code%>&P_context=<%=context%>&stage_desc=<%=stagedesc%>&patient_class=<%=patient_class%>&called_from_ip=<%=called_from_ip%>&Age=<%=age%>&Dob=<%=dob%>&Sex=<%=sex%>&modal_yn=<%=modal_yn%>&calledFromDeathReg=<%=calledFromDeathReg%>" marginwidth=0 marginheight=0 frameborder=0 scrolling='no'  noresize></frame>
			
			<frame name='Diagresultframe' src='../../eCommon/html/blank.html'  marginwidth=0 marginheight=0 frameborder=0 scrolling='auto'  noresize></frame>
			
			<frame name='support' src='../../eCommon/html/blank.html' marginwidth=0 marginheight=0 frameborder=0  noresize></frame>
			<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' marginwidth=0 marginheight=0 frameborder=0 scrolling='no' ></frame>


			
		<%	/*if(called_from_ip.equals("Y") || modal_yn.equals("Y")) 
			{	*/%>
				
			<!--	<frame name='msgframe0' src='../../eCommon/jsp/error.jsp' marginwidth=0 marginheight=0 frameborder=0 scrolling='no' ></frame> 
				<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' marginwidth=0 marginheight=0 frameborder=0 scrolling='no' ></frame>-->
		<%/*	}*/	%>
			</frameset>
		<%
		}
		else
		{
			out.println("<script>alert(getMessage(\"MR_PARAM_NOT_DEFINED\",\"MR\"))</script>");
			out.println("<script>window.close();</script>");

		}
	}//end of func_appl_yn
}
	
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
} 
catch (Exception e) 
{
	//out.println("Exception @ try "+e.toString());
	e.printStackTrace();
}
finally{
	if (rset != null) rset.close();
	if (stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
