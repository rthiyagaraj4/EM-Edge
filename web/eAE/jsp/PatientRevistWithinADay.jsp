<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String p_resp_id		= (String)session.getValue("responsibility_id");
	StringBuffer NationalityVal	= new StringBuffer();
	String locale						= (String)session.getAttribute("LOCALE");


%>
<html>
<HEAD>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eAE/js/PatientRevistWithinADay.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eAE/js/AEPractitionerComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onload = 'FocusFirstElement()' onKeyDown = 'lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
    Connection con  =  null;
    PreparedStatement pstmt = null;
    ResultSet rs = null; 
    String currdate			= "";
	String isSpltyNurUnitToEnableYNAppl="";
	try{
		con = ConnectionManager.getConnection(request);
		isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 25th-OCT-2018 for ML-MMOH-CRF-1115.1
try {
		String sql = "Select  to_char(sysdate,'dd/mm/yyyy') sys_date from dual";
		  pstmt = con.prepareStatement(sql);
	      rs    = pstmt.executeQuery();
	      if( rs != null )
	      {
	          while( rs.next())
	          {
	        	currdate = rs.getString("sys_date") ;
			  }
		  }			
    if (rs    != null)    rs.close();
	if (pstmt != null) pstmt.close();
	
	} catch(Exception e) {e.printStackTrace();}

    
	Statement stmt = con.createStatement(); 
    String sql = "" ;
    sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_LANG_VW Where language_id = '"+locale+"' and EFF_STATUS = 'E' order by 2" ;
    ResultSet rset = stmt.executeQuery(sql);
	StringBuffer StrVal = new StringBuffer();
    try
    {
		if(rset != null)
		{
			while(rset.next())
			{
				StrVal.append("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
		}
	 if(rset != null)    rset.close();
	 if(stmt != null)    stmt.close();
	 
	 }
	 catch(Exception e){e.printStackTrace();}
	
%>

<table cellpadding='0' border = '0' cellspacing='0' width='90%'>
<th align='left' width='100%'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='0' border = '0' cellspacing='0' width='90%'>
<tr>
	<td colspan='4' class='label' height='5'></td>
</tr>
	<%
  try
		{				
			String sql1  = "Select country_code, long_desc from MP_COUNTRY_LANG_VW Where language_id = '"+locale+"'Order by 2";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					NationalityVal.append("<option 	value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			    }
			}
		if(rset!=null) rset.close();
        if(stmt!=null) stmt.close();   
		
		}catch(Exception e){e.printStackTrace();}
		
	%>
<tr>
		
	                <td width="25%" colspan=4>&nbsp;</td>
					<td width="25%"></td>
					<td width="25%"></td>
					<td width="25%"></td>
</tr> 
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/> </td>
	<td  width="25%"><select name='p_nationality' id='p_nationality'>
   <%

     try{
		   String sql1  = "Select country_code, long_desc from MP_COUNTRY_LANG_VW Where language_id = '"+locale+"'Order by 2";
			stmt = con.createStatement();
			rset = stmt.executeQuery(sql1);
			if(rset!=null)
			{
			   while(rset.next())
			   {
					NationalityVal.append("<option 	value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			    }
			}
		
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();

		}catch(Exception e){e.printStackTrace();}
		
	%>
	 <option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----------</option>
		<%=NationalityVal.toString()%>
		</select>
	</td>
	<td width="25%"></td>
	<td width="25%"></td>
</tr>

<tr><td width="25%"></td><td class="querydata" width="25%"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></td><td class="querydata" width="25%"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></td> 
<td width="25%"></td></tr>
<tr>
	<td  class="label"  width="25%"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
	<td  width="25%"><input type=text  name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur="validDateObj(this,'DMY','<%=locale%>')"><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_fm_date.select();return showCalendar('p_fm_date');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td  width="25%"><input type=text  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur="validDateObj(this,'DMY','<%=locale%>')"><img name= "dob" src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].p_to_date.select();return showCalendar('p_to_date');" style='cursor:pointer'></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td width="25%"></td>
</tr>
<input type='hidden' name='revisitfromdate' id='revisitfromdate' value=''>
<input type='hidden' name='revisittodate' id='revisittodate' value=''>
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></td>

	<td width="25%"><input type="text" name="p_fm_visit_type" id="p_fm_visit_type" size="2" maxlength="2" onBlur='searchCode(fromvtype,this)'><input type='button' name='fromvtype' id='fromvtype' value='?' class='button' onclick='searchCode(this, p_fm_visit_type)'>
	</td>
	<td width="25%">
	    <input type="text" name="p_to_visit_type" id="p_to_visit_type" size="2" maxlength="2" onBlur='searchCode(tovtype,this)'><input type='button' name='tovtype' id='tovtype' value='?' class='button' onclick='searchCode(this, p_to_visit_type)'>
	</td>
	 <td  width="25%"></td>
</tr>

<tr>
	<td  class="label" width="25%"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
	<td width="25%"><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>
	<td width="25%">
	    <input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
	<td  width="25%"></td>
</tr>
<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="../../eIP/jsp/CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
				<%}else{%>
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>

	<td width="25%"><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td width="25%">
	    <input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
	<td width="25%"></td>
				</tr><%}%>
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>

	<td width="25%"><input type="text" name="p_fm_service_code" id="p_fm_service_code" size="4" maxlength="4" onBlur='searchCode(fromservice,this)'><input type='button' name='fromservice' id='fromservice' value='?' class='button' onclick='searchCode(this, p_fm_service_code)'>
	</td>
	<td width="25%">
	    <input type="text" name="p_to_service_code" id="p_to_service_code" size="4" maxlength="4" onBlur='searchCode(toservice,this)'><input type='button' name='toservice' id='toservice' value='?' class='button' onclick='searchCode(this, p_to_service_code)'>
	</td>
	<td width="25%"></td>
</tr>
<tr>
                    <td  class="label" width="25%"><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
                    <td width="25%"><select name="fm_pract_type" id="fm_pract_type">
						<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
						<%=StrVal.toString()%>
						</select>
					</td>
					<td width="25%">
						<select name="to_pract_type" id="to_pract_type">
						<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------</option>
						<%=StrVal.toString()%>
						</select>
					</td>
					<td width="25%"></td>
                </tr>
<tr>
	<td  class="label" width="25%"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
	
	<td width="25%"><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id1,this)'><input type='button' name='pract_id1' id='pract_id1' value='?' class='button' onclick='searchCode(this, p_fm_pract_id)'>
	</td>
	<td width="25%">
	<input type="text" name="p_to_pract_id" id="p_to_pract_id" size="15" maxlength="15" onBlur='searchCode(pract_id2,this)'><input type='button' name='pract_id2' id='pract_id2' value='?' class='button' onclick='searchCode(this, p_to_pract_id)'>
	</td>
	<td width="25%"></td>
</tr>


<tr>
	<td class='label' height='5'></td>
	<td></td>
	<td></td>
	<td></td>
</tr>


</table>
	
		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id %>">

		<input type="hidden" name="p_module_id" id="p_module_id" value="AE">
		<input type="hidden" name="p_report_id" id="p_report_id" value="AEBPRVST"> 

		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=p_user_name %>">
		<input type="hidden" name="p_resp_id" id="p_resp_id"	value="<%= p_resp_id %>"></input>
		<input type="hidden" name="p_curr_date" id="p_curr_date"	value="<%= currdate%>">
		<% 
		StrVal.setLength(0);
		NationalityVal.setLength(0); 
		}catch(Exception e){e.printStackTrace();}
	 finally
	 {
		
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	 }
		%>
		<input type="hidden" name="locale" id="locale"			value="<%= locale %>">
</form>
</body>
</center>
</html>

