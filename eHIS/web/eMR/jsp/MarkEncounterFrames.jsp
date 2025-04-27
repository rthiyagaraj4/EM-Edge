<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.ConnectionManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html> 
<head>
    <title><fmt:message key="eMR.MarkingofMLCOSCC.label" bundle="${mr_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../js/MarkEncounter.js'></script>
	<script language='javascript' src='../js/MedRecRequest.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String FacilityId = request.getParameter("FacilityId");
	String call_from  = request.getParameter("call_from");
	String Encounter_Id	= request.getParameter("Encounter_Id");
	String patient_id	= request.getParameter("patient_id");
	if(patient_id == null) patient_id = "";
	Connection con = null;
	PreparedStatement pat_file_Stmt = null;
	ResultSet pat_file_Rs	= null ;	
	int count=0;
try
{
	/*
	con = ConnectionManager.getConnection(request);
	String pat_file_sql = "select count(1) from MR_PAT_FILE_INDEX where facility_id = ? and patient_id = ? ";

		pat_file_Stmt = con.prepareStatement(pat_file_sql);
		pat_file_Stmt.setString(1,FacilityId);
		pat_file_Stmt.setString(2,patient_id);
		pat_file_Rs = pat_file_Stmt.executeQuery(  );

		if(pat_file_Rs != null)
		{
			while( pat_file_Rs.next() )
			{
				count = pat_file_Rs.getInt(1);
			}
		}
	if(count == 0)
	{
		out.println("<script>alert(getMessage('FILE_DOESNOT_EXIST','MR'))</script>");
		out.println("<script>parent.window.close();</script>");
	}
	else
	{ */
%>
	</head>
	<iframe name='pline' id='pline' src="../../eCommon/jsp/pline.jsp?EncounterId=<%=Encounter_Id%>&Facility_Id=<%=FacilityId%>" frameborder=0 scrolling='no' style='height:15vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/addModifyMarkEncounter.jsp?Encounter_Id=<%=Encounter_Id%>&patient_id=<%=patient_id%>&FacilityId=<%=FacilityId%>&call_from=<%=call_from%>' frameborder=0 scrolling='no' style='height:85vh;width:100vw'></iframe>				
		<iframe name='messageFrame' id='messageFrame'src='../../eCommon/jsp/error.jsp' frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
	</html>     
<%
//	}				
}
catch(Exception e)
{
	//out.println("Exception "+e.toString());
	e.printStackTrace();
}
finally
{
	try
	{
		if (pat_file_Rs!=null) pat_file_Rs.close();
		if (pat_file_Stmt!=null)pat_file_Stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception @ finally"+e.toString());
		e.printStackTrace();
	}
	if(con!= null)	ConnectionManager.returnConnection(con,request);
}%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

