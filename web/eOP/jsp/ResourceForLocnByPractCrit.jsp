<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con = null;
    String facilityid=(String)session.getValue("facility_id");
    String locale=(String)session.getAttribute("LOCALE");
        
try{
    con=ConnectionManager.getConnection(request);    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	String callfunc=request.getParameter("call_func");
	String oper=request.getParameter("oper");
	String unittypedesc1 = "";
	String unittypecode = "";
	
	Boolean isSimplifyPractNursUnit = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","SIMPLIFY_PRACT_FOR_NURS_RES");
	
%>
<html>
<head>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eOP/js/menuItemCheck.js" language="javascript"></script>
<script language='javascript' src='../../eOP/js/OPPractitionerComponent.js'></script>
<script language='javascript' src='../../eOP/js/ResourceForLocnByPract.js'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eOP/js/ResourceForUnit.js'></script> 

</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'> 
<form name="ResourceForLocnByPractForm" id="ResourceForLocnByPractForm">
<table border="0" cellpadding="0" cellspacing="0" width="70%" align='end'>
		<tr align="left">
			<td class='label'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> &nbsp;</td>				
			<td class='field'><input type='text' name="pract_name" id="pract_name" onBlur="onBlurCallPractitionerSearch(document.forms[0].pract_butt,pract_name);" value="">
			<input type='button' name='pract_butt' id='pract_butt' value='?' class='button'  onClick="getPractCall(this, pract_name);">
			<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<input type='hidden' name="pract_id" id="pract_id" value="">
		</tr>
		<tr align="center">&nbsp;</tr>
		<tr align="left">
			<td class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/> &nbsp;</td>				
			<td class='field'>
				<select name="unit_type" id="unit_type" onChange="validateFields(this);">
								<option value='' >&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;

								<%
								pstmt=con.prepareStatement("select locn_type,short_desc from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in('C','E','Y') and sys_user_def_ind='S' order by 2");
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										unittypecode=rs.getString("locn_type");
										unittypedesc1=rs.getString("short_desc");

										%>
											<option value='<%=unittypecode%>'><%=unittypedesc1%>
										<%
									}
								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								%>
											
								</select> <img src="../../eCommon/images/mandatory.gif"></img> 
			</td>
			<td class='label'><fmt:message key="Common.searchby.label" bundle="${common_labels}"/> &nbsp;</td>				
			<td class='field'>
				<select name='search_by' id='search_by' id='search_by' onChange='disableSearch(this)'>
					<option value='' selected>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
					<option value='c' ><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></option>
					<option value='d' ><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></option>
				</select> 
				&nbsp;
				<input type='text' id="search_desc" name="search_desc" id="search_desc" value="" disabled>
			</td>
		</tr>
		<tr align="center">&nbsp;</tr>
		<tr align="left">
			<td class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> &nbsp;</td>				
			<td class='field'><input type='text' name="speciality_name" id="speciality_name" onBlur="callGetSpeciality(this);" onChange="validateFields(this)" value="">
				<input type='button' name='speciality_btn' id='speciality_btn' value='?' class='button'  onClick="getSpecialityCall(this,speciality_name);">
							<input type='hidden' name="speciality_id" id="speciality_id" value="">
			</td>
			<td class='label'>&nbsp;</td>
			<td align='center' class='field'>
				<input type='button' name='search' id='search' value='search' class='button'  onClick="applyForRes();">
			</td>
		</tr>
</table>


<input type="hidden" name="call_function" id="call_function" value="res_for_locn_by_pract">
<input type = "hidden" name='fac_id' id='fac_id' value='<%=facilityid%>'>
<input type = "hidden" name='isSimplifyPractNursUnit' id='isSimplifyPractNursUnit' value='<%=isSimplifyPractNursUnit%>'>
<input type = "hidden" name='locale' id='locale' value='<%=locale%>'>
<input type = "hidden" name='oper' id='oper' value='<%=oper%>'>
</form>
</body>
</html>
	<%
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>

