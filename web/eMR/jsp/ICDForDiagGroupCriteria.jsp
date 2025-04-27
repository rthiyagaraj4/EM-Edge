<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page language="java" import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
     <%
		request.setCharacterEncoding("UTF-8"); 
        Connection conlConn = null;
		Statement stmt = null;
		ResultSet rstlRs = null;
		String diag_group_code ="",diag_group_desc="",diag_code_scheme="",speciality_code="",facility_id="";
	try
	{
	       conlConn = ConnectionManager.getConnection(request);
	      String mrParamsql="select group_type,diag_group_code ,diag_group_desc,diag_code_scheme,speciality_code,facility_id,practitioner_id from  mr_diag_group";
	      stmt = conlConn.createStatement();
		   rstlRs = stmt.executeQuery(mrParamsql);

     %>
      
      <head>
      	
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
   	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eMR/js/ICDForDiagGroup.js' language='javascript'></script>


	
      </head>
     <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onload='FocusFirstElement();to_hide();' >
     <form>
	<table  align='center' cellpadding='5' cellspacing=0 border='0' width='100%'>
	
	<tr>
		<td class='label' width='25%' ><fmt:message key="eMR.DiagnosisProcedureGroup.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='20%'><select name='diag_grp_detail' id='diag_grp_detail' onChange='to_hide();populateValues(this)'><option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
		<% if(rstlRs !=null)
		{
			while(rstlRs.next())
			{
			String group_type_value = rstlRs.getString("group_type");
			String group_type ="";
			if (group_type_value.equals("D")) group_type ="Diagnosis";
			else group_type = "Procedure";			
			diag_group_code = rstlRs.getString("diag_group_code");
			diag_group_desc= rstlRs.getString("diag_group_desc");
			diag_code_scheme=rstlRs.getString("diag_code_scheme");
			speciality_code=rstlRs.getString("speciality_code");
			facility_id=rstlRs.getString("facility_id");
//			practitioner_id = rstlRs.getString("practitioner_id");
			out.println("<option value='"+diag_group_code+"^"+diag_code_scheme+"^"+speciality_code+"^"+facility_id+"^"+group_type+"^"+group_type_value+"'>" +diag_group_desc+"</option>");
			}
		}	
		%></select><img src='../../eCommon/images/mandatory.gif'></img>
		<td class='label' width='10%' id='group_type' ></td>
		<td class='queryData' width='15%' id='group_type_disp'> </td>
		<td class='label' id='diag_code_desc' width='15%'></td>
		<td class='queryData' width='15%' id='diag_code_disp'></td>
		</tr>
		
		<tr>
			<td class='label' id='speciality_disp'></td>
			<td class='queryData' id='speciality'></td>
			<td class='label' id='facility_disp'></td>
			<td class='queryData' id='facility' colspan = 3></td>
		</tr>
		
	<tr>
		<td class='label' id='pract_disp'></td>
		<td class='queryData' id='practitioner' colspan='5'></td>
	</tr>
    
    <tr>
			<td class='label'  ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
			<td  class='fields' ><select name='searchby' id='searchby' ><option value='C'><fmt:message key="Common.code.label" bundle="${common_labels}"/></option><option value='D'><fmt:message key="Common.description.label" bundle="${common_labels}"/></option></select></td><td class=label ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td><td class='fields' colspan='3'><select name='searchcriteria' id='searchcriteria'><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option></select>
			</td>
        	
	</tr>
	
	<tr>
		<td class=label ><fmt:message key="eMR.SearchDesc.label" bundle="${mr_labels}"/></td><td colspan='5' class='fields' ><input type='text' size='57' maxlength='70' name='alpha_desc' id='alpha_desc'></td>
	</tr>
   
	<tr>
		<td class='label' colspan='5'></td>
		<td class='button'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='populateResult()'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'></td>
	</tr>
	
	</table>
	</form>
	</body>
	</html>

<% 	}
	catch(Exception e){
		// out.println("Exception @ try"+e.toString());
		e.printStackTrace();
    }
	finally{
        try
		{
            if(stmt != null){ stmt.close(); }
            if(rstlRs != null){ rstlRs.close(); }	     
		}
		catch(Exception e){
	      //out.println("Exception @ finally"+e.toString());
		  e.printStackTrace();
		}
			ConnectionManager.returnConnection(conlConn,request);
    }
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

