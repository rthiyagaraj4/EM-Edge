<!DOCTYPE html>
<!--
	Created Date	:	11/14/2002
	Module ID		:	AE
	Function Name	:	Patient Movement History
-->

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,com.ehis.util.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
	<%
	//<!--Added by Himanshu Saxena on 6-Jul-2023 for ML-MMOH-CRF-1972 Starts-->
	boolean isPendingForAdmissionAppl=false;
	//<!--Added by Himanshu Saxena on 6-Jul-2023 for ML-MMOH-CRF-1972 ends-->
	
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='PatientMovementHistoryForm' id='PatientMovementHistoryForm'>

<%

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

	String	facilityId 			= (String) session.getValue( "facility_id" ) ;
	String	patient_id			= request.getParameter("patient_id");
	String  visit_date_time		= request.getParameter("visit_date_time");
	String	called_from			= request.getParameter("called_from");
	String  visit_date_to		= request.getParameter("visit_date_to"); //Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042

	String  classValue			="";
	String  bedNO               ="";
	String status				=""; //<!--Added by Himanshu Saxena on 6-Jul-2023 for ML-MMOH-CRF-1972 -->

	if (called_from==null) called_from="";

	try
	{
		int i		    = 1 ;
		con				=	(Connection)	ConnectionManager.getConnection(request);
		
				//<!--Added by Himanshu Saxena on 6-Jul-2023 for ML-MMOH-CRF-1972 Starts-->
				isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");
			    //<!--Added by Himanshu Saxena on 6-Jul-2023 for ML-MMOH-CRF-1972 ends-->	
			    
		
		StringBuffer sql = new StringBuffer();
		sql.append("select to_char(assign_date,'dd/mm/yyyy hh24:mi') assign_date, assign_tmt_area_code, assign_practitioner_id, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(FACILITY_ID,ASSIGN_CLINIC_CODE,ASSIGN_TMT_AREA_CODE,'"+locale+"','2')  tmt_short_desc, assign_bed_no, AM_GET_DESC.AM_PRACTITIONER(ASSIGN_PRACTITIONER_ID,'"+locale+"','1') practitioner_name,FOR_ADMISSTION_STATUS,to_char(FOR_ADMISSTION_DATE_TIME,'dd/mm/yyyy hh24:mi')  FOR_ADMISSTION_DATE_TIME from ae_pat_movement_log where patient_id=? and facility_id=? and trunc(assign_date) BETWEEN nvl(trunc(to_date(?,'dd/mm/yyyy hh24:mi')),trunc(sysdate)) AND nvl(trunc(to_date(?,'dd/mm/yyyy hh24:mi')),trunc(sysdate)) order by assign_date ");
	   pstmt=con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

		pstmt.setString	(	1,	patient_id		);
		pstmt.setString	(	2,	facilityId		);
		pstmt.setString	(	3,	visit_date_time	);
		pstmt.setString	(	4,	visit_date_to	); //Added by Ashwini on 04-Oct-2018 for ML-MMOH-CRF-1042

		rs			=	pstmt.executeQuery();
		  int cnt=0;
					  
		 while (rs.next()){
			if(cnt==0){	

%>
 <table border='1' cellpadding='0' cellspacing='0' width='100%' id='tb1'>
 <th width='20%'><fmt:message key="Common.assigndatetime.label" bundle="${common_labels}"/></th>
 <th width='30%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></th>
 <th width='15%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></th>
 <th width='20%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
 <%
 if(isPendingForAdmissionAppl){ %>
 <th width='15%'><fmt:message key="eAE.WaitingForAdmission.label" bundle="${ae_labels}"/></th>
 <%
 }
 
 }
		classValue				=	((i%2)==0)? "QRYEVEN" : "QRYODD";
        bedNO =checkForNull(rs.getString("assign_bed_no")) ;
%>
		<tr>
			<td class='<%=classValue%>'><%=DateUtils.convertDate(checkForNull(rs.getString("assign_date")),"DMYHM","en",locale)%></td>
			<td class='<%=classValue%>'><%=checkForNull(rs.getString("tmt_short_desc"))%></td>
	        <td class='<%=classValue%>'><%=bedNO%></td>
			<td class='<%=classValue%>'><%=checkForNull(rs.getString("practitioner_name"))%></td>
			<%if(isPendingForAdmissionAppl)
			{ 
				
				if(checkForNull(rs.getString("FOR_ADMISSTION_STATUS")).equals("C"))
				{
					status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelForAdmission.label","common_labels")+" - "+DateUtils.convertDate(checkForNull(rs.getString("FOR_ADMISSTION_DATE_TIME")),"DMYHM","en",locale);
				}
				else if(checkForNull(rs.getString("FOR_ADMISSTION_STATUS")).equals("W"))
				{
					status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.WaitingForAdmission.label","ae_labels")+" - "+DateUtils.convertDate(checkForNull(rs.getString("FOR_ADMISSTION_DATE_TIME")),"DMYHM","en",locale);
				}else
				{
					status="";
				}
			%>
				<td class='<%=classValue%>'><%=checkForNull(status)%></td>
			<% } %>
		</tr>
<%	
		i++;
		cnt++;
	
   }

   if(cnt==0){%>

   			<script>
				parent.parent.frames[2].location.href='../../eCommon/html/blank.html';
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				window.close();				
			</script>
			<%}
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();
	if((sql != null) && (sql.length() > 0))
	{
		sql.delete(0,sql.length());
	} 
}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		out.println("<script>	if(parent.parent.frames[1].document.forms[0].search != null )parent.parent.frames[1].document.forms[0].search.disabled = false ;</script>");
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</form>
</body>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "&nbsp;" : inputString );
	}
%>
</html>

