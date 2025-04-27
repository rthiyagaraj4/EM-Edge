<!DOCTYPE html>
<%/*
-------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
---------------------------------------------------------------------------------------------------------
*/%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<title><fmt:message key="eCA.Notescontent.label" bundle="${ca_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<%
String accession_num=request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
String no_modal=request.getParameter("no_modal")==null?"":request.getParameter("no_modal");;
String called_function_id=request.getParameter("called_function_id")==null?"":request.getParameter("called_function_id");
//IN065341 starts
	String RepDb = request.getParameter("RepDb") == null ? "" : request.getParameter("RepDb");
	String clob_data = request.getParameter("clob_data") == null ? "" : request.getParameter("clob_data");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
//IN065341 ends
String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
String contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num"); //[IN032721]
if (called_function_id.equals("INVIDE_WAITLIST"))
{
	out.println("<iframe name ='heading' id ='heading' marginwidth=0 marginheight=0 frameborder=no scrolling='no' noresize  src='../../eCA/jsp/PhysicanNotesDetailsHeading.jsp?accession_num="+accession_num+"' style='height:13vh;width:100vw'></iframe><iframe name ='result' id ='result' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num+"&function_id="+function_id+"' style='height:100vh;width:100vw'></iframe><iframe name ='PhysicainNoteResult' id ='PhysicainNoteResult' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='src='../../eCommon/html/blank.html' style='height:0vh;width:100vw'></iframe>	 ");
}
else
{
	if(no_modal !=null && no_modal.equals("Y")){
		out.println("<iframe name ='heading' id ='heading' marginwidth=0 marginheight=0 frameborder=no scrolling='no' noresize  src='../../eCA/jsp/ViewClinicalNoteNoteContentHeader.jsp?accession_num="+accession_num+"&no_modal="+no_modal+"&encounter_id="+encounter_id+"&function_id="+function_id+"&contr_mod_accession_num="+contr_mod_accession_num+"' style='height:13vh;width:98vw'></iframe><iframe name ='result' id ='result' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num+"&function_id="+function_id+"' style='height:82vh;width:100vw'></iframe><iframe name ='blank' id ='blank' marginwidth=0 marginheight=0 frameborder=no scrolling='no' src='../../eCommon/html/blank.html' style='height:1vh;width:100vw'></iframe>	 ");
	}
	else{
		//out.println("<iframe name ='heading' id ='heading' marginwidth=0 marginheight=0 frameborder=no scrolling='no' noresize  src='../../eCA/jsp/PhysicanNotesDetailsHeading.jsp?accession_num="+accession_num+"&function_id="+function_id+"' style='height:5vh;width:100vw'></iframe><iframe name ='result' id ='result' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num+"&function_id="+function_id+"' style='height:89vh;width:100vw'></iframe><iframe name ='PhysicainNoteResult' id ='PhysicainNoteResult' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetailsFrameClose.jsp' style='height:6vh;width:100vw'></iframe>	 ");//IN065341
		out.println("<iframe name ='heading' id ='heading' marginwidth=0 marginheight=0 frameborder=no scrolling='no' noresize  src='../../eCA/jsp/PhysicanNotesDetailsHeading.jsp?accession_num="+accession_num+"&function_id="+function_id+"&RepDb="+RepDb+"&clob_data="+clob_data+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"' style='height:5vh;width:100vw'></iframe><iframe name ='result' id ='result' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetails.jsp?accession_num="+accession_num+"&function_id="+function_id+"&RepDb="+RepDb+"&RepDb="+RepDb+"&clob_data="+clob_data+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"' style='height:84vh;width:100vw'></iframe><iframe name ='PhysicainNoteResult' id ='PhysicainNoteResult' marginwidth=0 marginheight=0 frameborder=no scrolling='auto' src='../../eCA/jsp/PhysicanNotesDetailsFrameClose.jsp' style='height:6vh;width:100vw'></iframe>	 ");//IN065341
	}
}
%>
</html>

