<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import ="java.sql.ResultSet,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement ,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>

<%	
	request.setCharacterEncoding("UTF-8");
	
	String queryString=request.getQueryString();
	Connection con=null;
	PreparedStatement pstmt=null;
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset=null;
	ResultSet rset1=null;

	String classValue="";

try{
		con = ConnectionManager.getConnection(request);

		boolean isPatDis =false;	//Added Against SS-SCF-0796-TF
		isPatDis = CommonBean.isSiteSpecific(con,"OT","OT_DIS_ENC");
		boolean isPreDis =false;	//Added Against KDAH-SCF-0836-TF
		isPreDis = CommonBean.isSiteSpecific(con,"OT","OT_PRE_DIS_ENC");
		System.err.println("isPreDis --->"+isPreDis);
		String facility_id		= (String) session.getValue("facility_id");
		String patient_id		= checkForNull(request.getParameter("patient_id"));
		String patient_class	= checkForNull(request.getParameter("patient_class"));
		String from				= checkForNull(request.getParameter("from")).intern() ;
		String to				= checkForNull(request.getParameter("to")).intern() ;
		String view_by			= checkForNull(request.getParameter("view_by"));
		String tabID			= checkForNull(request.getParameter("tabID"));
		System.err.println("tabID --------->"+tabID);
		 String sql_patient = "";
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=0;

		start = (from!="")?Integer.parseInt( from ):1;
		end =	(to!="")?Integer.parseInt( to ):14;

		stmt1=con.createStatement();	
%>

<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOT/js/OTEncounterPatientSearch.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function submitPrevNext(from, to){
	    document.forms[0].from.value = from;
	    document.forms[0].to.value = to; 
	    document.forms[0].submit();
	}
</script>
</head>

<body  onLoad="FocusFirstElement();" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<form name='responsibility_form' id='responsibility_form' action='../../eOT/jsp/OTEncounterPatientSearchResults.jsp' method='post'>
<table width='100%'>
	<tr>
		<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
		<%
			if(!(start <= 1)){
		%>		
		<%
			}
			if(!((start+14) > maxRecord)){
		%>			
		<%
			}
		%>
		</td>
	</tr>
	</table>

	<table border='1' cellpadding=3 cellspacing='0' align='center'  width='100%' >
		<td class="columnHeader" width="10%">
			<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader" width="10%">
			<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
		</td>

		<td class="columnHeader" width="10%">
			<fmt:message key="Common.episodeid.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader" width="7%">
			<fmt:message key="Common.VisitID.label" bundle="${common_labels}"/>
		</td>
		<td class="columnHeader" width="10%">
			<fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/>
		</td>
<%
	if(tabID.equals("ChkIn") && isPatDis) // Added Against SS-SS-SCF-0796-TF
	{
		 sql_patient="SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS='"+patient_class+"') EPIOSDE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+patient_class+"' AND FACILITY_ID='"+facility_id+"'  AND ((patient_class IN ('OP','EM') AND visit_status != '99') OR (patient_class IN ('IP', 'DC') AND adt_status != '09'))";
	}
	else if(isPreDis)	// Added Against KDAH-SCF-0836-TF
	{
		sql_patient="SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS='"+patient_class+"') EPIOSDE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+patient_class+"' AND FACILITY_ID='"+facility_id+"'  AND DISCHARGE_DATE_TIME IS NULL AND OTH_ADT_STATUS IS NULL AND ((patient_class IN ('OP','EM') AND visit_status != '99') OR (patient_class IN ('IP', 'DC') AND adt_status != '09') )";
	}
	else{
	 sql_patient="SELECT ENCOUNTER_ID,PATIENT_CLASS,EPISODE_ID,OP_EPISODE_VISIT_NUM,(SELECT EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS='"+patient_class+"') EPIOSDE_TYPE   FROM PR_ENCOUNTER WHERE PATIENT_ID='"+patient_id+"' AND PATIENT_CLASS='"+patient_class+"' AND FACILITY_ID='"+facility_id+"' AND DISCHARGE_DATE_TIME IS NULL AND ((patient_class IN ('OP','EM') AND visit_status != '99') OR (patient_class IN ('IP', 'DC') AND adt_status != '09'))"; //MODIFIED BY DHANASEKARV AGAINST PMG20089-CRF-0859 & KAUH-SCF-271
	}

	System.err.println("OTEncPatSrchRst.jsp sql_patient--->"+sql_patient);

	stmt=con.createStatement();
	rset=stmt.executeQuery(sql_patient);
	if(rset!=null)
	{
		if(start != 0){
		for(int j=1; j<start; i++,j++){
			  rset.next();
		}
		}
	
	String	encounter_id1		="";
	String	patient_class1		="";
	String	episode_id1			="";
	String	visit_no1			="";
	String	episode_type1		="";
	while(rset.next() && i<end ){
			if((i%2) == 1)
				classValue = "QRYODD";
			else
				classValue ="QRYEVEN";
			encounter_id1=rset.getString("ENCOUNTER_ID");
			patient_class1=rset.getString("PATIENT_CLASS");
			episode_id1=rset.getString("EPISODE_ID");
			visit_no1=rset.getString("OP_EPISODE_VISIT_NUM");
			episode_type1=rset.getString("EPIOSDE_TYPE");				
			if(episode_id1==null) episode_id1="";
			if(visit_no1==null) visit_no1="";
			System.err.println("i==>"+i+" OTEncPatSrchRst.jsp encounter_id1==>"+encounter_id1);
			System.err.println("i==>"+i+" OTEncPatSrchRst.jsp patient_class1==>"+patient_class1);
			System.err.println("i==>"+i+" OTEncPatSrchRst.jsp episode_id1==>"+episode_id1);
			System.err.println("i==>"+i+" OTEncPatSrchRst.jsp visit_no1==>"+visit_no1);
			System.err.println("i==>"+i+" OTEncPatSrchRst.jsp episode_type1==>"+episode_type1);
			out.println("<tr>");
			out.println("<td class='"+classValue+"' onClick=returnPatientDetails('"+i+"','"+encounter_id1+"','"+patient_class1+"','"+episode_id1+"','"+episode_type1+"','"+visit_no1+"');><font class='HYPERLINK' style='font-size:7pt;color:blue;cursor:pointer;font-weight:normal'>"+encounter_id1+"</font></td>");
			out.println("<td class='"+classValue+"' >&nbsp;"+patient_class1+"</td>");
			out.println("<td class='"+classValue+"' >&nbsp;"+episode_id1+"</td>");
			out.println("<td class='"+classValue+"' >&nbsp;"+visit_no1+"</td>");
			out.println("<td align='center'class='"+classValue+"' >&nbsp;"+episode_type1+"</td>");
			out.println("</tr>");
		%>
				<input type='hidden' name='patient_class_<%=i%>' id='patient_class_<%=i%>' value="<%=patient_class1%>" >
		<%		
			i++;
		}
	}
	if(i==0) 
		out.println("<SCRIPT>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</SCRIPT>");
%>	
	</table>
		<input type='hidden' name=from value='<%=start%>'>
		<input type='hidden' name=to value='<%=end%>'>
		<input type='hidden' name='start' id='start' value='<%=start%>'>
		<input type='hidden' name='end' id='end' value='<%=end%>'>
		<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>">
		<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
		<input type='hidden' name='view_by' id='view_by' value="<%=view_by%>">	
<%	}catch(Exception e){
		e.printStackTrace();
		System.err.println("OTEncounterPatientSearchResults.jsp Error===>"+e);
		}
	finally
	{
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();
		if(rset1!=null) rset1.close();
		if(stmt1!=null) stmt1.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}	
%>
</form>
</body>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</html>

