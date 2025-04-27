<!DOCTYPE html>
<!--
	Developed By       :  P.Sudhakaran
-->
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<title><fmt:message key="eDR.PatientFileDetails.label" bundle="${dr_labels}"/></title>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<%
	Connection con                  = null;
	java.sql.Statement	stmt		= null;
	ResultSet	rs			        = null;
	
	String str				        = "";
	String p_file_no				= "";
	String p_mr_sec_code			= "";
	String p_created_date			= "";
	String name						= "";
	String facility_name			= "";
	String old_file_no				= "";
	String classValue				= "";
     String locale=(String)session.getAttribute("LOCALE");  
	int i							= 1;
	
 try
   {
	String p_patient_id		        = checkForNull(request.getParameter("patient_id"));

	con                             = ConnectionManager.getConnection(request);
	stmt					        = con.createStatement();

	demography d = new demography();
	name =d.name_age_sex(session ,p_patient_id,con,locale);
	str  = "select facility_name,old_file_no,file_no,nvl(mr_section_code,'&nbsp;')mr_section_code,to_char(file_created_date, 'dd/mm/yyyy')file_created_date from mr_pat_file_index_vw where patient_id = '"+p_patient_id+"' ";
	rs=stmt.executeQuery(str);

	if(rs != null)
	{
	%>
	<br>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center' >
	<tr><th align='left'class='fields' colspan='5'><%=name%></th></tr>
	<tr><td colspan='5' class='label'></td></tr>
	
	<tr>
			<td class='columnheader'  nowrap ><b><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></b></td>
			<td class='columnheader'   nowrap ><b><fmt:message key="Common.MRNo.label" bundle="${common_labels}"/></b></td>
			<td class='columnheader'  nowrap ><b><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></b></td>	
			<td class='columnheader'   nowrap ><b><fmt:message key="Common.CreatedDate.label" bundle="${common_labels}"/></b></td>
			<td class='columnheader'  nowrap  ><b><fmt:message key="eMP.OldFileNo.label" bundle="${mp_labels}"/></b></td>
			</tr>	
	<%
	while(rs.next())
		{
		        if ( i % 2 == 0 )
				classValue = "QRY_EVEN" ;
				else
				classValue = "QRY_ODD" ;

		p_file_no		= checkForNull(rs.getString("file_no"));
		p_mr_sec_code	= checkForNull(rs.getString("mr_section_code"));
		p_created_date	= checkForNull(rs.getString("file_created_date"));
		facility_name	= checkForNull(rs.getString("facility_name"));
		old_file_no		= checkForNull(rs.getString("old_file_no"));		
				
		%>

		<tr>
		<td  class='<%=classValue%>'  nowrap align='left' ><%=facility_name%></td>
		<td  class='<%=classValue%>'  nowrap align='left' ><%=p_file_no%></td>	
		<td  class='<%=classValue%>'  nowrap align='left' ><%=p_mr_sec_code%></td>
		<td  class='<%=classValue%>'  nowrap align='left' ><%=p_created_date%></td>
		<td  class='<%=classValue%>'  nowrap align='left' ><%=old_file_no%></td>
		</tr>
		<%
		i++;		
		}
	}
	%>
	</table>
	<%
	    if (stmt != null) stmt.close();
		if (rs != null) rs.close();
	}
	catch(Exception e)
	{
	   out.println("Exception in the File DRViewMRN "+e.toString());
	 }
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
<table border='0' cellspacing='0' cellpadding='0' width='100%' >
<tr ><td class=white>&nbsp;</td></tr>
<tr><td class=white ><input type='button' class='button' value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='window.close()'></td></tr>	
</table>

</table>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
%>

