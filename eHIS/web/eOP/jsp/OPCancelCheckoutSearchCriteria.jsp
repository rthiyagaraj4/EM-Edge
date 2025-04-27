<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String loginUser = (String)session.getValue("login_user");


	Connection con      = null;
try
{request.setCharacterEncoding("UTF-8");	
	con=ConnectionManager.getConnection(request);
	Statement stmt      = null ;
	ResultSet rset      = null;	
	StringBuffer sql = new StringBuffer();
	String facility_id       = (String) session.getValue( "facility_id" ) ;
	String locale=(String)session.getAttribute("LOCALE");
	String module_id = request.getParameter("module_id");
	String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String pid_length=request.getParameter("patient_id_length")==null?"":request.getParameter("patient_id_length");
	/*
		Added on:11/23/2010,For:IN025177
	*/
	String level_of_care_ind="A";
	if(module_id.equals("AE")){
		level_of_care_ind="E";
	}
	//String pid_length = "";
	//String oper_stn_id = "";
	//String sys_date = "";
	//String curr_year = "";
/*	
try
{
	p_sql	= "select patient_id_length from mp_param where module_id='MP'";
	stmt1	= con.createStatement();
	rs	= stmt1.executeQuery(p_sql);
	while (rs.next())
	{
		pid_length = rs.getString(1);
	}
}
catch(Exception e)
{
	out.println("Exception at Patient ID level :" + e);
}
finally
{
	if(rs!=null) rs.close();
	if (stmt1!=null )stmt1.close();
}
*/

	/*	StringBuffer aesql = new StringBuffer();
		
		aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
		  aesql.append(" where appl_user_id= ? ");
		  aesql.append(" and facility_id=  ? ");
		
		  pstmt = con.prepareStatement(aesql.toString());
		  pstmt.setString(1, loginUser);
		  pstmt.setString(2, facility_id1);

		  rset = pstmt.executeQuery();
		  if(rset.next())
			oper_stn_id=rset.getString(1);

		  if(rset!=null)rset.close();
		  if(pstmt!=null)pstmt.close();
		  if((aesql != null) && (aesql.length() > 0))
			{
				aesql.delete(0,aesql.length());
			} 
*/

/*try
{
	p_sql	= "select to_char(sysdate,'dd/mm/rrrr hh24:mi') sys_date,to_char(sysdate,'rrrr') curr_year from dual";
	stmt1	= con.createStatement();
	rs	= stmt1.executeQuery(p_sql);
	while (rs.next())
	{
		sys_date=rs.getString("sys_date");
	}
	sys_date=DateUtils.convertDate(sys_date,"DMYHM","en",localeName);	

}
catch(Exception e)
{
	out.println("Exception at Patient ID level :" + e);
}
finally
{
	if(rs!=null) rs.close();
	if (stmt1!=null )stmt1.close();
}*/
		
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOP/js/OPCancelCheckout.js'></script>
<script language="javascript" src="../../eOP/js/OPPractitionerComponent.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='OPCancelChkoutSearch' id='OPCancelChkoutSearch'>
<table border='0' cellpadding='2' cellspacing='0' width='100%' >
<tr>
	<td  class='label'  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td  class='Fields'>
		<select name='speciality' id='speciality' onChange="clearList()" tabindex=1><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---- 
		<%        	
//			sql.append("Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E' and language_id='"+locale+"' order by 1");
		/*
			The Query was modified on 11/23/2010,For:25177
		*/
			sql.append("SELECT SHORT_DESC,SPECIALITY_CODE  FROM AM_SPECIALITY_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID='"+locale+"' AND SPECIALITY_CODE IN (SELECT DISTINCT SPECIALITY_CODE FROM OP_CLINIC WHERE EFF_STATUS = 'E' AND LEVEL_OF_CARE_IND='"+level_of_care_ind+"')  ORDER BY 1");
			stmt	= con.createStatement();
			rset=stmt.executeQuery(sql.toString());
			if(rset != null)
			{
				while(rset.next())
				{
					out.println("<option value='" + rset.getString("Speciality_Code") + "' >" + rset.getString("Short_Desc")+"</option>");
				}
			}	
								  
			if (rset != null)       rset.close();
			if (stmt != null)       stmt.close();
			sql.setLength(0);
		
		%>
		</select>
	</td>
	<td class='label' width="25%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class='field' width="25%"><input type='text' name='patient_id' id='patient_id'  tabindex=2 onKeyPress="return(CheckForSpecChars(event))"  value="" size='20' maxlength='<%=pid_length%>' onBlur='changeCase(this);'><input type='button' class='BUTTON' value="?"  name='patient_search' id='patient_search' onClick = 'callPatientSearch()' tabindex=3></td>
</tr>
<tr>
	 <td   class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
	 <td class='field' width="25%">
		<%
			if(module_id.equals("OP"))
		{
		%>		
				<select name="loc_type" id="loc_type" tabindex=4>
				<option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
				<%
								String loctype = "";
								String loctypedesc = "";
								sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");
								stmt	= con.createStatement();
								rset=stmt.executeQuery(sql.toString());
								if(rset != null)
								{
									while(rset.next())
									{
										loctype=rset.getString("locn_type");
										loctypedesc=rset.getString("short_desc");
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}						  
							  if (rset != null)       rset.close();
							  if (stmt != null)       stmt.close();
							  sql.setLength(0);						
		}
		else if(module_id.equals("AE"))
		{
			%>
			<select name="loc_type" id="loc_type" value='C' tabindex=4 disabled>
			<%
								String loctype = "";
								String loctypedesc = "";
								sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");
								stmt	= con.createStatement();
								rset=stmt.executeQuery(sql.toString());
								if(rset != null)
								{
									while(rset.next())
									{
										loctype=rset.getString("locn_type");
										loctypedesc=rset.getString("short_desc");
										%>
											<option value="<%=loctype%>" disabled><%=loctypedesc%>
										<%
									}
								}						  
							  if (rset != null)       rset.close();
							   if (stmt != null)       stmt.close();
							  sql.setLength(0);	
		
		}
	%>
				</select>
		
		</td>
		<td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		<td class='fields'> <input type='text' name='locdesc' id='locdesc' size='20' maxlength='20' onBlur="getValues(locn_button,this,oplocation,document.forms[0].loc_type.value,document.forms[0].loginUser.value,document.forms[0].oper_stn_id.value)" tabindex=5><input type='hidden' name='oplocation' id='oplocation' value=''><input type='button' class='button' readOnly name='locn_button' id='locn_button' value='?' onClick="getValues(this,locdesc,oplocation,document.forms[0].loc_type.value,document.forms[0].loginUser.value,document.forms[0].oper_stn_id.value)" tabindex=6></td>
</tr>
<tr>
	<td class='label'> <fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
       <td class='fields'><input type='text' name='pract_desc' id='pract_desc' size='30' maxlength='30' onBlur="getValues(pract_button,this,pract)" tabindex=7><input type='hidden' name='pract' id='pract' value=''><input type='button' class='button' readOnly name='pract_button' id='pract_button' value='?' onClick="getValues(this,pract_desc,pract)" tabindex=8></td>

		<td  class='label'  width="25%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='gender' id='gender' tabindex=9>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
		<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
		<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
		</select>
		</td>
</tr>

<!--
<tr>
	<td class='label' width='25%'><fmt:message key="Common.CheckoutDate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='text' id='chkoutFrom'  size='12' maxlength='16' value="" onblur='validDateObj(this,"DMY",localeName);doDate(this);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('chkoutFrom');" style="cursor='hand'"></img></td>

	<td class='label' width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='text' id='chkoutTo'  size='10' maxlength='10' onblur='validDateObj(this,"DMY",localeName);doDate(this);'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('chkoutTo');" style="cursor='hand'"></img></td>
</tr>
-->

<%
	if(module_id.equals("AE"))
	{
%>
	<tr>
		<td class='label' width="25%"><fmt:message key="Common.Disaster.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='disaster' id='disaster' tabindex=10><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
		</td>
		<td class='label' width="25%"><fmt:message key="Common.CaseofTrauma.label" bundle="${common_labels}"/></td>
		<td class='field'  width="25%"><select name='caseoftrauma' id='caseoftrauma' tabindex=11><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
		<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
		</td>
	</tr>


<%
	}
else 
	{
%>
<input type='hidden' name='disaster' id='disaster' value=''>
<input type='hidden' name='caseoftrauma' id='caseoftrauma' value=''>
<%
	}
%>
<tr>
	<td  colspan=4 align='right' >
	<input type="button" class='Button' name="search_button" id="search_button" title='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'onClick='searchChkout();' tabindex=12>&nbsp;<input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearFn();' tabindex=13>
	</td>
</tr>

<table>

<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='loginUser' id='loginUser' value='<%=loginUser%>'>
<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>



</form>
</center>
</body>
</html>

<%
}catch(Exception e) {}
finally{
if(con!=null) ConnectionManager.returnConnection(con,request);

}
%>

