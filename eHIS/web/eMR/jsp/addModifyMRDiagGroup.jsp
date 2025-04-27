<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
      <head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
      	<script src='../../eCommon/js/common.js' language='javascript'></script>
			
  		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
		<script language='javascript' src='../../eMR/js/MRDiagGroup.js'></script>
		<script language='javascript' src='../../eMR/js/MRPractitionerComponent.js'></script>



      </head>

      <body OnMouseDown='CodeArrest()' onload='FocusFirstElement()' onkeydown='lockKey()'> 


<%
	request.setCharacterEncoding("UTF-8");
	Connection conn=null;
	Statement stmt=null;
	ResultSet rset=null;

	Statement stmt1=null;
	ResultSet rset1=null;

	Statement stmt3=null;
	ResultSet rset3=null;

	Statement stmt4=null;
	ResultSet rset4=null;

	String diag_group_code="";String insModify="",pract_name="";
	String diag_code_scheme="";
	String proc_code_scheme="";
	String group_type="";
	String code_scheme_value ="";
	String code_scheme ="";

     try{
		group_type = request.getParameter("group_type");

		
		if (group_type==null) group_type="";
		diag_group_code = request.getParameter("diagGroupCode");

		if(diag_group_code == null) { diag_group_code=""; insModify ="insert";} else insModify="modify";

		conn=ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
		
		String mrparamSql="select DIAG_CODE_SCHEME,PROC_CODE_SCHEME from mr_parameter ";
		stmt4 = conn.createStatement();
		rset4=stmt4.executeQuery(mrparamSql);

		if(rset4.next()){
			diag_code_scheme=rset4.getString(1);
			proc_code_scheme=rset4.getString(2);
		}


				StringBuffer repopulate= new StringBuffer();
				String diag_code="",diag_desc="",sp_code="",fac_id="",pract_id="";
				if(!diag_group_code.equals(""))
				{
				repopulate.append("select diag_group_code,diag_group_desc,diag_code_scheme,"); repopulate.append("speciality_code,facility_id,a.practitioner_id,practitioner_name    from ");
				repopulate.append("mr_diag_group a, am_practitioner b where ");
				repopulate.append("a.practitioner_id = b.practitioner_id(+) and group_type = '"+group_type+"' and diag_group_code='"+diag_group_code+"' ");
				stmt3= conn.createStatement();	
				rset3 =stmt3.executeQuery(repopulate.toString());
				rset3.next();
				diag_code=rset3.getString("diag_group_code");
				if(diag_code == null) diag_code="";
				diag_desc=rset3.getString("diag_group_desc"); 
				if(diag_desc == null) diag_desc="";
				sp_code=rset3.getString("speciality_code");
				if(sp_code == null) sp_code="";
				fac_id=rset3.getString("facility_id");
				if(fac_id == null) fac_id="";
				pract_id=rset3.getString("practitioner_id");
				if(pract_id == null) pract_id="";
				pract_name = rset3.getString("practitioner_name");
				if(pract_name == null) pract_name="";
				diag_code_scheme = rset3.getString("diag_code_scheme");
					if(diag_code_scheme == null) diag_code_scheme="";
				}

		
		
		String spSql="select SPECIALITY_CODE,short_desc from am_speciality where eff_status='E' order by 2";
		String facSql="select facility_id,facility_name   from sm_facility_param  order by 2";
		rset=stmt.executeQuery(spSql);
		rset1=stmt1.executeQuery(facSql);
		
		String speciality_code="",short_desc="";
		String facility_id="",facility_name="";
		String diag_code_scheme_val="";
		String proc_code_scheme_val="";
		
		
		diag_code_scheme_val = diag_code_scheme;
		proc_code_scheme_val = proc_code_scheme;
		
		if(diag_code_scheme.equals("1"))
			diag_code_scheme="ICD10";
		else
			diag_code_scheme="ICD9-CM";

		if(proc_code_scheme.equals("3"))
			proc_code_scheme="CPT4";
		else if(proc_code_scheme.equals("6"))
			proc_code_scheme="ICD10-PCS";
		else
			proc_code_scheme="ICD9-CM";
		if (insModify.equals("modify"))
		{
           if (group_type.equals("D"))
			{
				code_scheme			= diag_code_scheme;
				code_scheme_value	= diag_code_scheme_val;		
			}
			else
		    {
				code_scheme			= proc_code_scheme;
				code_scheme_value	= proc_code_scheme_val;		
			}

		}		
		String group_type_value ="";
		if (group_type.equals("D"))
			group_type_value ="Diagnosis";
		else
			group_type_value = "Procedure";
		
%>

      	<form name='mr_diag_grp' id='mr_diag_grp' action='../../servlet/eMR.MRDiagGroupServlet' method='post' target='messageFrame'>
      	<div align='left'>
<BR><BR><BR><BR><BR>
      	<BR><BR><BR>
      	<table border='0' cellpadding='5' cellspacing='0' width='auto' align='center'>
      	   		<tr>
      		    <td  width='50%' class='label'><fmt:message key="Common.GroupType.label" bundle="${common_labels}"/></td>
      		    <td width='50%' class='fields'>
				<%if (insModify.equals("insert")){%>
					<select name = group_type onChange = 'group_type_chng(this)'> 
					<option value = ''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- 
					<option value = 'D'> <fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
					<option value = 'P'> <fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
					</select><img src = '../../eCommon/images/mandatory.gif'>
				<%}else{%>
                <input type = text size = 10 disabled name=group_type_value value=<%=group_type_value%>>
				<input type = hidden name = group_type value = <%=group_type%>>
				<%}%>
      		</tr>
  			
			<tr>
      		    <td class='label'><fmt:message key="eMR.CodeScheme.label" bundle="${mr_labels}"/></td>
      		    <td class='Querydata' id='diag_code_scheme_id' ><%=code_scheme%> 
      		</tr>
			<input type='hidden' name='diag_code_scheme' id='diag_code_scheme' value='<%=code_scheme_value%>'>
			
      		<tr>
      		    <td class='label'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		   <% if(insModify.equals("insert")) { %>
      		   <input type='text' name='diag_group_code' id='diag_group_code' value="" size='4' maxlength='4' onKeyPress="return CheckForSpecChars(event)" onBlur="changeCase(this)">
      		   <% } else { %>
      		 <input type='text' name='diag_group_code' id='diag_group_code' value="<%=diag_code%>"  readOnly size='4' maxlength='4' onKeyPress="return CheckForSpecChars(event)" onBlur="makeValidString(this);changeCase(this)">   
      		   <% } %>
      		   
      		   <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td  class='label'> <fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		     <% if(insModify.equals("insert")) { %>
      		    <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=""    onBlur="makeValidString(this);">
      		      <% } else { %>
      		      <input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=diag_desc%>"  onBlur="makeValidString(this);">
      		        <% } %>
      		    <img src='../../eCommon/images/mandatory.gif'></img></td>
      		</tr>
      		
      		<tr>
      		    <td class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <select name='speciality_code' id='speciality_code'><option value='' > ----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
      		    <% if(rset !=null) 
      		    { 
			    while(rset.next())
			    {
				 speciality_code=rset.getString("speciality_code");
				 short_desc=rset.getString("short_desc");
				 String sel="";
				 if (speciality_code.equals(sp_code))
					 sel = "selected";
				 else
					 sel = "";
				 out.println("<option value =\""+speciality_code+"\" "+sel+">"+short_desc+"</option>");
			    }
      		    }
      		    %>
      		    </select>
      		    </td>
      		</tr>
      		
      		<tr>
      		    <td  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
      		    <td class='fields'>
      		    <select name='facility_id' id='facility_id'><option value='' > -------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------- </option>
      		    <% if(rset1 !=null) 
      		    { 
			    while(rset1.next())
			    {
				 facility_id=rset1.getString("facility_id");
				 facility_name=rset1.getString("facility_name");
				 String sel="";
				 if (facility_id.equals(fac_id))
					 sel = "selected";
				 else
					 sel = "";
				 out.println("<option value =\""+facility_id+"\" "+sel+">"+facility_name+"</option>");
			    }
      		    }
      		    %>
      		    </select>
      		   
      		   </td>
      		</tr>

		
		<tr>
		    <td  class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		    <!-- <td width='60%' colspan='2'>&nbsp;&nbsp;
		     <input type='text' name='practitioner_name' id='practitioner_name' size='30' maxlength='30' value="<%=pract_name%>"  readOnly><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=pract_id%>"><input type='button' class='button' value='?' onClick='populatePract(this,practitioner_name,practitioner_id)'>
		    </td> -->
			<td class='fields'>
		     <input type='text' name='practitioner_name' id='practitioner_name' size='30' maxlength='30' value="<%=pract_name%>"  onblur="getattndpract();" ><input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=pract_id%>"><input type='button' name='pract_id_search1' id='pract_id_search1' class='button' value='?' onClick='callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practitioner_name); fixvaluespractitioner();'><input type=hidden maxlength=10 size=10 name="temp_desc" id="temp_desc" ><input type=hidden name="temp_physician_id" id="temp_physician_id"> 			 
		    </td>
		</tr>
      		
      		
      		<% if(diag_group_code.equals("")) { %>
      		<input type='hidden' name='function_name' id='function_name' value='insert'>
      		<% } else { %>
      		<input type='hidden' name='function_name' id='function_name' value='modify'>
      		<% } %>
      	<input type='hidden' name='proc_code_scheme1' id='proc_code_scheme1' value="<%=proc_code_scheme%>">
      	<input type='hidden' name='diag_code_scheme1' id='diag_code_scheme1' value="<%=diag_code_scheme%>">
      	<input type='hidden' name='diag_code_scheme_val' id='diag_code_scheme_val' value="<%=diag_code_scheme_val%>">
      	<input type='hidden' name='proc_code_scheme_val' id='proc_code_scheme_val' value="<%=proc_code_scheme_val%>">    	
      	</form>
      	</body>
      	</html>
<%

		}catch(Exception e){
			e.toString();
	     }
	     finally{
			 try
			 {
	     	     	if(stmt!=null)    	stmt.close();
	     	     	if(rset!=null)    	     	rset.close();
	     	     	if(stmt1!=null)  	     	stmt1.close();
	     	     	if(rset1!=null)  	     	rset1.close();
			if(stmt3!=null)  	stmt3.close();
			if(rset3!=null)		rset3.close();

	     	     	if(stmt4!=null)	     	stmt4.close();
	     	     	if(rset4!=null) 	     	rset4.close();

			 }
catch(Exception e){
			
	     }



			ConnectionManager.returnConnection(conn,request);
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

