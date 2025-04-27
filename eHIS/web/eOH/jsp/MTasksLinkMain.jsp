<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
   request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
<script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%

Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String DB_trmt_code="";
String DB_trmt_desc = "";

try{
	con=ConnectionManager.getConnection(request);	

%>
<form name="MTasksLinkMain_form" id="MTasksLinkMain_form"  onload='FocusFirstElement()'> 
<table border=0 cellspacing=0 cellpadding=3  width='80%'  align='center'>
<tr>
	<td class=label><fmt:message key="Common.Treatment.label" bundle="${common_labels}"/></td>
	<td><input type="text"  name="treatment_desc" id="treatment_desc" size='40' maxlength='20' value="" onBlur="if(this.value!='') getTreatmentLookUp(treatment_code,treatment_desc);">
	<input type="hidden"  name="treatment_code" id="treatment_code" value=""><input type="button" class="button" name="treatment_lookup" id="treatment_lookup" value="?" onclick="getTreatmentLookUp(treatment_code,treatment_desc);" ><img src='../../eCommon/images/mandatory.gif'></td> 
	
		<!-- <td><select name="treatment_code" id="treatment_code" onchange='clearDtl_Frame();'> 
			<option value='' selected><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
			<%	
				pstmt=con.prepareStatement("SELECT TRMT_DESC, TRMT_CODE FROM OH_TREATMENT_LANG_VW WHERE LANGUAGE_ID = ? AND EFF_STATUS = 'E' ORDER BY 1");
				pstmt.setString(1,locale);
				rs=pstmt.executeQuery();
				if(rs!=null){
					while(rs.next()){
						DB_trmt_desc=rs.getString("TRMT_DESC");
						DB_trmt_code=rs.getString("TRMT_CODE");
			%>	
						<option value="<%=DB_trmt_code%>"><%=DB_trmt_desc%>
			<%		}
				}
			%>
		</select><img src='../../eCommon/images/mandatory.gif' align='center'> 
	</td> -->
		
<% }catch(Exception e){
		out.println("exp"+e);
	}

	finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			out.println("exp"+e);
		}
	}
%>

</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<!-- <tr>
	<td  class='label' ><fmt:message key="Common.Tasks.label" bundle="${common_labels}"/></td>
	<td  class ='fields'>
		
		<select name="search_criteria" id="search_criteria"">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td class ='label'><fmt:message key="Common.Text.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="task_search_text" id="task_search_text" size='13' maxlength='8' value="" OnKeyPress ="return CheckForSpecChars(event)"></td>
	
</tr> -->
<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
    <td align="right" class="button" colspan = '3'>
		<input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="callDetailForm();"  >&nbsp;&nbsp;<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvalues();"  >
	</td>
	<!-- <td align="right" class="button">
		<input type="button" class="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearvalues();"  >
	</td> -->
</tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


