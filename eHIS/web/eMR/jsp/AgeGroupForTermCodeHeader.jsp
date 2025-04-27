<!DOCTYPE html>
<!-- AgeGroupForTermCodeHeader.jsp -->
<%--
*	Created By		:	Suchilagna panigrahi
*	Created On		:	7 Feb 2005
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eMR.*, eCommon.Common.*,com.ehis.eslp.* " %>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*,eOR.Common.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, java.net.*"%>
<jsp:useBean id="AgeGroupForTermCode" class="webbeans.eCommon.RecordSet" scope="session"/>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	


<script language="JavaScript" src="../js/AgeGroupForTermCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
AgeGroupForTermCode.clearAll();
//String age_group_code=request.getParameter("age_group_code")== null ? "":request.getParameter("age_group_code");
String TerminologySet_sql="";
String Agegroup_sql="";
ArrayList TerminologySet_list=new ArrayList();
ArrayList Agegroup_list=new ArrayList();
Connection conn=null;
PreparedStatement TerminologySet_stmt=null;
PreparedStatement Agegroup_stmt=null;
ResultSet TerminologySet_rs=null;
ResultSet Agegroup_rs=null;

try
{
conn=ConnectionManager.getConnection();
TerminologySet_sql="Select term_Set_id,term_set_desc,diag_spec_yn,proc_spec_yn from mr_term_set where eff_status = 'E' order by term_set_desc ";
TerminologySet_stmt=conn.prepareStatement(TerminologySet_sql);
TerminologySet_rs=TerminologySet_stmt.executeQuery();
while(TerminologySet_rs.next())
	{
		TerminologySet_list.add(TerminologySet_rs.getString("term_Set_id"));
		TerminologySet_list.add(TerminologySet_rs.getString("term_set_desc"));
	}
Agegroup_sql="SELECT age_group_code,long_desc FROM am_age_group WHERE eff_status = 'E' ORDER BY long_desc ";
Agegroup_stmt=conn.prepareStatement(Agegroup_sql);
Agegroup_rs=Agegroup_stmt.executeQuery();
while(Agegroup_rs.next())
	{
		Agegroup_list.add(Agegroup_rs.getString("age_group_code"));
		Agegroup_list.add(Agegroup_rs.getString("long_desc"));
	}
}catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
finally
{
	Agegroup_rs.close();
	TerminologySet_rs.close();
	Agegroup_stmt.close();
	TerminologySet_stmt.close();
	ServiceLocator.getInstance().returnConnection(conn,request);
}

%>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown='lockKey()' >
		<form name=form_AgeGroupForTermCode>
		<table border='0' cellspacing='0' cellpadding='5' align='center' width='100%'>
			<tr>
				<td width="25%" class='label'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
				<td class='fields' width='55%'><select name='age_group_code' id='age_group_code' onChange='_cleanResult()'>
						<option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
						<%for(int i=0;i<Agegroup_list.size();i+=2){%>
							<option value=<%=Agegroup_list.get(i)%>><%=Agegroup_list.get(i+1)%></option>
							<%}%>
					</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				    
				</td>
				<td class='label' width='20%'></td>
			  </tr>

			  <tr>
			 <td class='label'><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
			 <td class='fields'><select name='term_set_id' id='term_set_id' onchange='loadtype(this);_cleanResult()'>
						<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
						<%for(int i=0;i<TerminologySet_list.size();i+=2){%>
							<option value=<%=TerminologySet_list.get(i)%>><%=TerminologySet_list.get(i+1)%></option>
							<%}%>
					</select><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td class='label'></td>
				</tr>
				<tr>
			<td   class='label'><fmt:message key="Common.TerminologyCodeDescription.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type='text' name='term_code_desc' id='term_code_desc' value='' size='50' maxlength='100' onKeypress='return CheckForSpecChar(event);'></td>
			<td class='fields'><select name='search_criteria' id='search_criteria'>
								<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							</select>
			</td>
			
			</tr>
			<tr>
				 <td class='label'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<select name='type' id='type'>
						<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
					</select>
				</td>
				<td class='button'><input class='button' type=button name="search_button" id="search_button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick='searchDetails()'></td>
			 </tr>
		 </table>
		
	 <input type="hidden" name="AchkAll" id="AchkAll" value="">
	 <input type="hidden" name="BchkAll" id="BchkAll" value="">
	 <input type="hidden" name="CchkAll" id="CchkAll" value="">
	 <input type="hidden" name="DchkAll" id="DchkAll" value="">
	 <input type="hidden" name="EchkAll" id="EchkAll" value="">
	 <input type="hidden" name="FchkAll" id="FchkAll" value="">
	 <input type="hidden" name="GchkAll" id="GchkAll" value="">
	 <input type="hidden" name="HchkAll" id="HchkAll" value="">
	 <input type="hidden" name="IchkAll" id="IchkAll" value="">
	 <input type="hidden" name="JchkAll" id="JchkAll" value="">
	 <input type="hidden" name="KchkAll" id="KchkAll" value="">
	 <input type="hidden" name="LchkAll" id="LchkAll" value="">
	 <input type="hidden" name="MchkAll" id="MchkAll" value="">
	 <input type="hidden" name="NchkAll" id="NchkAll" value="">
	 <input type="hidden" name="OchkAll" id="OchkAll" value="">
	 <input type="hidden" name="PchkAll" id="PchkAll" value="">
	 <input type="hidden" name="QchkAll" id="QchkAll" value="">
	 <input type="hidden" name="RchkAll" id="RchkAll" value="">
	 <input type="hidden" name="SchkAll" id="SchkAll" value="">
	 <input type="hidden" name="TchkAll" id="TchkAll" value="">
	 <input type="hidden" name="UchkAll" id="UchkAll" value="">
	 <input type="hidden" name="VchkAll" id="VchkAll" value="">
	 <input type="hidden" name="WchkAll" id="WchkAll" value="">
	 <input type="hidden" name="XchkAll" id="XchkAll" value="">
	 <input type="hidden" name="YchkAll" id="YchkAll" value="">
	 <input type="hidden" name="ZchkAll" id="ZchkAll" value="">
	 <input type="hidden" name="_chkAll" id="_chkAll" value="">
	 <input type="hidden" name="AssociatedchkAll" id="AssociatedchkAll" value="Y">


	  </form>
	 </body>
	</html>
	<%
		if ( TerminologySet_list != null) TerminologySet_list.clear();
		if ( Agegroup_list != null) Agegroup_list.clear();
	%>
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

