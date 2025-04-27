<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  language="java" contentType="text/html;charset=UTF-8"  import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
  <head>
  	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/CustomListTerminologyGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection		con = null;
	PreparedStatement pstmt	= null;
	ResultSet rs = null;
	String term_group_id = "";
	String mode = "";
	String term_set_id = "";
	String index_type_from_modify = "";
	String isdisabled = "";
	String isselected = "";
	String effect_status = "";
	String checkBoxAttribute = "";

	try
	{
		con = ConnectionManager.getConnection(request);
		mode = checkForNull(request.getParameter("mode"));
		if(mode.equals("2"))
		{
			term_group_id = request.getParameter("term_group_id");
			term_set_id = request.getParameter("term_set_id");
			index_type_from_modify = request.getParameter("index_type");
			isdisabled = "disabled";
			effect_status = request.getParameter("effect_status");
			if(effect_status.equals("D"))
			{
				checkBoxAttribute="";
			}
			else
			{
				checkBoxAttribute="CHECKED";
			}
		}

	%>
	<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown='lockKey()' >
	<form name='addModifyCustomListTerminologyGroupAddModify' id='addModifyCustomListTerminologyGroupAddModify' method='post'>
	<table border='0' width='100%' align='center' cellpadding='5' cellspacing='0'>
		<tr>
			<td class='label' width='25%'><fmt:message key="eMR.TerminologyGroup.label" bundle="${mr_labels}"/></td>
			<td class='fields' width='25%'><select name='term_group' id='term_group' onChange="setTermSet()" <%=isdisabled%> style="width:304px"><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<%
				StringBuffer terminology_group_query = new StringBuffer();
				terminology_group_query.append(" select term_group_id ,TERM_GROUP_DESC from mr_term_group_hdr  WHERE   eff_status='E' AND  INDEX_TYPE_YN ='Y' ");
				pstmt = con.prepareStatement(terminology_group_query.toString());
				rs = pstmt.executeQuery();
				
				while(rs!=null && rs.next())
				{
					if(mode.equals("2") && term_group_id.equals(rs.getString(1)))
						isselected = "selected";

					out.println("<option value='"+rs.getString(1)+"' "+isselected+">"+rs.getString(2)+"</option>"); 
				}

				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
			%>			
			</select><img src="../../eCommon/images/mandatory.gif"></img></td>
			<td class='label' width='25%'><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><select name='term_set' id='term_set' onChange='onTermSet()'<%=isdisabled%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select><img src="../../eCommon/images/mandatory.gif"></img></td>
			<td width='25%'></td>
		
		</tr>
		<tr>
			<td class='label' width='25%'><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><select name='index_type' id='index_type' onChange='onIndexType()'<%=isdisabled%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
			<% if(mode!=null && mode.equals("2") && index_type_from_modify.equals("S")) {%>
			<option value='S' selected><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option><option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<% }else if(mode!=null && mode.equals("2") && index_type_from_modify.equals("P")){ %>
			<option value='S' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option><option value='P' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<% } else if(mode!=null && mode.equals("1")) {%>
			<option value='S' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option><option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<% } %>
			</select><img src="../../eCommon/images/mandatory.gif"> </img></td>
			<!--<td class='label' colspan='1'></td>5/21/2009-->
				<td width='20%' class='label'><fmt:message key="Common.search.label" bundle="${common_labels}"/> </td>
				<td width='60%' class='fields'><input type='text' name='index_desc' id='index_desc' onkeypress="return CheckForSpecChars_term(event);" size='15' maxlength='15' ></input><select name='search_criteria' id='search_criteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
			<!--5/21/2009 -->
			<td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='search_index_type()' <%=isdisabled%>></td>
		</tr>
		<!--<tr>
			<td class='label' width='25%'><fmt:message key="Common.Enable.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%'><input type='checkbox' name='custom_list_enable_YN' id='custom_list_enable_YN' <%=isdisabled%> checked value='E' onClick='setEffect_Status(this)'></td>
			<td class='label' colspan='1'></td>
			<td class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='search_index_type()' <%=isdisabled%>></td>
		</tr>-->
		<input type='hidden' name='mode' id='mode' value='1'>
	</table>

	</form>
	<script>
		if('<%=mode%>'==2)
		{
			document.forms[0].term_group.onchange();
		}
	</script>
	</body>
	
<%
	}
	catch(Exception e)
	{
		//out.println("Exception in sql:"+e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>
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

