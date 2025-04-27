<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
		function onSuccess()
		{
			alert(getMessage('RECORD_MODIFIED','SM'));
			window.close();
		}
	</script>
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad='ClearMsg()'>
<form name='Related_Family_form' id='Related_Family_form' action='../../servlet/eMP.PatientRegistrationServlet' method='post' target='messageFrame'> 
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' >
	<%
	request.setCharacterEncoding("UTF-8");
	
		Connection	    con		= null;
		java.sql.Statement		st		= null;
		ResultSet		rs		= null;			        
		int j=0,i=0;
		String classValue="";
		int rowIndex		= 1;
		StringBuffer relFam=new StringBuffer();
		String relationship="";
		//String facility_id = (String)session.getValue("facility_id");
		String  FAMILY_ORG_ID_ACCEPT_YN             =request.getParameter("FAMILY_ORG_ID_ACCEPT_YN")==null?"N":request.getParameter("FAMILY_ORG_ID_ACCEPT_YN");

		String  FAMILY_ORG_ID             =request.getParameter("FAMILY_ORG_ID")==null?"":request.getParameter("FAMILY_ORG_ID");
		String  FAMILY_ORG_SUB_ID      =request.getParameter("FAMILY_ORG_SUB_ID")==null?"":request.getParameter("FAMILY_ORG_SUB_ID");
		String  patient_id					    =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String  FAMILY_ORG_MEMBERSHIP=request.getParameter("FAMILY_ORG_MEMBERSHIP")==null?"":request.getParameter("FAMILY_ORG_MEMBERSHIP");
		String  alt_id1_no                    = request.getParameter("alt_id1_no")==null?"":request.getParameter("alt_id1_no");
		String  changed_val				   =  request.getParameter("changed_val")==null?"":request.getParameter("changed_val");
		String  nw_alt_id1_no			   =  request.getParameter("nw_alt_id1_no")==null?"":request.getParameter("nw_alt_id1_no");

		relFam.append("Select patient_id,get_age(date_of_birth) age, FAMILY_ORG_MEMBERSHIP,decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,sex,(Case when relationship_to_head is not null then (select short_desc from mp_relationship where relationship_code = relationship_to_head)end )RELATIONSHIP_TO_HEAD from mp_patient  where alt_id1_no='"+alt_id1_no+"' and FAMILY_ORG_MEMBERSHIP!='"+FAMILY_ORG_MEMBERSHIP+"'");
		boolean recAvl=false;
		try
		{
			con	= ConnectionManager.getConnection(request);
			st=con.createStatement();
			rs = st.executeQuery(relFam.toString());
			if(rs!=null)
			{
				while(rs.next())
				{
					 recAvl=true;
					 FAMILY_ORG_MEMBERSHIP=rs.getString("FAMILY_ORG_MEMBERSHIP")==null?"":rs.getString("FAMILY_ORG_MEMBERSHIP");
					 relationship=rs.getString("RELATIONSHIP_TO_HEAD")==null?"":rs.getString("RELATIONSHIP_TO_HEAD");
					 if (j==0)
					 {%>
							<th ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th> 
							<th ><fmt:message key="Common.name.label" bundle="${common_labels}"/> </th> 
							<th ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></th>
							<th ><fmt:message key="Common.age.label" bundle="${common_labels}"/></th>
							<th ><fmt:message key="eMP.membership.label" bundle="${mp_labels}"/></th>
					<%}
					j=1;
					classValue =	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
					%>
					<tr>
					<td class='<%=classValue%>'> <font size=1><%=rs.getString("patient_id")==null?"":rs.getString("patient_id")%></td>
					<td class='<%=classValue%>'> <font size=1><%=rs.getString("patient_name")==null?"":rs.getString("patient_name")%></td>
					<td class='<%=classValue%>' align='center'> <font size=1><%=rs.getString("sex")==null?"":rs.getString("sex")%></td>
					<td class='<%=classValue%>' align='center'> <font size=1><%=rs.getString("age")==null?"":rs.getString("age")%></td>
					<td class='<%=classValue%>' align='left'> <font size=1><%=relationship%>
					<input type="hidden" name="pat_id<%=i%>" id="pat_id<%=i%>" value ='<%=rs.getString("patient_id")==null?"&nbsp;":rs.getString("patient_id")%>'</td>	
					</tr>
					<%i++;
					rowIndex++;
				}
			}
			if(recAvl==false)
			{%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));window.close();</script> 
			<%}
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		%>
		<%!
		public static String checkForNull(String inputString)
		{
		return((inputString == null) ? "" : inputString);
		}
		public static String checkForNull(String inputString, String defaultValue)
		{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
	%>
	</table>
	<INPUT TYPE="hidden" name="cnt" id="cnt"  value=<%=i%>>
	<INPUT TYPE="hidden" name="related_pat_ids" id="related_pat_ids"  value=''>
	<INPUT TYPE="hidden" name="operation" id="operation"  value='updateRelatedData'>
	<INPUT TYPE="hidden" name="changed_val" id="changed_val"  value='<%=changed_val%>'>
	<INPUT TYPE="hidden" name="patient_id" id="patient_id"  value='<%=patient_id%>'>
	<INPUT TYPE="hidden" name="nw_alt_id1_no" id="nw_alt_id1_no"  value='<%=nw_alt_id1_no%>'>
	<INPUT TYPE="hidden" name="org_id" id="org_id"  value='<%=FAMILY_ORG_ID%>'>
	<INPUT TYPE="hidden" name="sub_organization" id="sub_organization"  value='<%=FAMILY_ORG_SUB_ID%>'>
	<INPUT TYPE="hidden" name="family_org_id_accept_yn" id="family_org_id_accept_yn"  value='<%=FAMILY_ORG_ID_ACCEPT_YN%>'>
</form>
</body>
</html>

