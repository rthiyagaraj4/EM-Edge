<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<%
	Connection con =null;
	String patcode="";
	String shortdesc="";
	PreparedStatement pstmt=null ;
	ResultSet reset=null;
	//String prefix_or_suffix_length=request.getParameter("prefix_or_suffix_length");

	

%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eMP/js/PatientNumberingForRelation.js' language='javascript'>
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' OnLoad="Focusing('pat_ser_grp_code')">
<!--<form name="patNumRelation_form" id="patNumRelation_form" action="../../servlet/eMP.PatNumberingRelationServlet" method="post" target="messageFrame">-->
<form name="patNumRelation_form" id="patNumRelation_form" >

<BR><BR><BR>
<table border="0" cellpadding="0" cellspacing="0" width="90%" align='center'>
   <tr>
	<td class="NONE" width="100%">
		<table border='0' cellpadding='5' cellspacing='0' width='100%'>
		<tr><td colspan='3' class='label'>&nbsp;</td></tr>
			<tr>
				<td class="label" width="40%" ><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
				<td width="60%" colspan="2" class="fields"  nowrap><select name='pat_ser_grp_code' id='pat_ser_grp_code' onChange="Pass2MsgFrm('forpatnum');populateSeparator();" >
				<OPTION VALUE=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------
				<%
				try{
					con = ConnectionManager.getConnection(request);
					pstmt = con.prepareStatement("select pat_ser_grp_code,MP_GET_DESC.MP_PAT_SER_GRP(pat_ser_grp_code,'"+localeName+"','2') short_desc from mp_pat_ser_grp where GEN_PID_USING_ALT_ID1_RULE_YN='Y' order by short_desc ");
						reset=pstmt.executeQuery();
						if( reset != null )
						{
						   while( reset.next() )
							{
								 patcode = reset.getString( "pat_ser_grp_code" ) ;
								 shortdesc=reset.getString("short_desc");
								
								%><OPTION VALUE='<%= patcode%>' ><%= shortdesc%></option>
								<%
							}
							
						}
													
						if (reset != null) reset.close();
						if (pstmt != null) pstmt.close();
					}catch(Exception e) { out.println(e.toString());}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}
			%>
				</select>
				<img src='../images/mandatory.gif'></img></td>
			<tr>
		<td class="label" width="40%" ><fmt:message key="eMP.SeparatorValue.label" bundle="${mp_labels}"/></td>
		<td class='QUERYDATA'  width='60%'><input type='text' name='SeparatorValue' id='SeparatorValue' size='3' value='' disabled></td>
	</tr>
	<tr>
		<td class="label" width="40%" ><fmt:message key="eMP.SeparatorPosition.label" bundle="${mp_labels}"/></td>
		<td class='QUERYDATA'  width='60%'><input type='text' name='SeparatorPosition' id='SeparatorPosition' size='3' value='' disabled></td>				      
	</tr>
	<tr>
		<td class="label" width="40%" ><fmt:message key="eMP.PatNumberingUsing.label" bundle="${mp_labels}"/></td>
		<td class='fields'  width='60%'><fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>1<input type='radio' name='patient_numbering_using' id='patient_numbering_using'   tabIndex='0'  value='A'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.SystemGenerated.label" bundle="${mp_labels}"/><input type='radio' name='patient_numbering_using' id='patient_numbering_using' tabIndex='0' value='S'></td>				      
	</tr>
    <tr><td colspan='3' class='label'>&nbsp;</td></tr>
	</table>
	</td>
    </tr>
</table>

<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
<input type='hidden' name='gen_pid_using_alt_id1_rule_yn' id='gen_pid_using_alt_id1_rule_yn' value=''>

</form>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

