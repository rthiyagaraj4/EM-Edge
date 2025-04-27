<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	Statement		stmt	= null;
	ResultSet		rset	= null;	
	Connection		con		= null;
	
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBBDSCT" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

%>
<html>
<HEAD>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/CommonCalendar.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
		async function searchCode(obj,target)
		{
			var retVal = 	new String();
			var locale= "<%=locale%>"
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql		="";
			var search_code	="";
			var search_desc	="";
			var facilityid = "<%=p_facility_id%>";
			var tit="";

			var allfacilityid	=	document.forms[0].p_all_facility_id.value;

			if(obj.name=="nursing_unit_code_fm" || obj.name=="nursing_unit_code_to")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`"+allfacilityid+"` and eff_status = `E` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+allfacilityid+"` and language_id=`"+locale+"` and eff_status = `E` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;						
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);
			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else			
				target.focus();
			}

	function chkVal(obj)
	{

		if ( obj.value == "All" )
		{		if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fr_nursing_unit.disabled = true
					document.forms[0].p_to_nursing_unit.disabled = true
					document.forms[0].nursing_unit_desc.disabled = true
					document.forms[0].nursing_unit.disabled = true
				}else{
				document.forms[0].p_fr_nursing_unit.disabled = true
				document.forms[0].p_to_nursing_unit.disabled = true
				document.forms[0].nursing_unit_code_fm.disabled = true
				document.forms[0].nursing_unit_code_to.disabled = true
				}
		}
		else
		{		if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fr_nursing_unit.disabled = false
					document.forms[0].p_to_nursing_unit.disabled = false
					document.forms[0].nursing_unit_desc.disabled = false
					document.forms[0].nursing_unit.disabled = false
				}else{
				document.forms[0].p_fr_nursing_unit.disabled = false
				document.forms[0].p_to_nursing_unit.disabled = false
				document.forms[0].nursing_unit_code_fm.disabled = false
				document.forms[0].nursing_unit_code_to.disabled = false
				}
		}		if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].nursing_unit_desc.value = ""}
				document.forms[0].p_fr_nursing_unit.value = ""
				document.forms[0].p_to_nursing_unit.value = ""
	}
	</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="repBedStatChartForm" id="repBedStatChartForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
   <th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
   <tr>
	<td width="100%" class="Border" align='center'>
	<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>
	 <tr>		
	   	<td width='30%' class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		<td class="fields" width='20%' >				
	   	 	<select name='p_all_facility_id' id='p_all_facility_id' onchange ="chkVal(this)">		
<%
		StringBuffer sql1 = new StringBuffer();
		String isSpltyNurUnitToEnableYNAppl="";
		try
		{
			con		=	ConnectionManager.getConnection(request);
			isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
		stmt=con.createStatement();
		String fid;
		String fname;
		
		//sql1.append("select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");
		
		String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");
		
		sql1.append("select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'  and p.language_id='"+locale+"'  and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ");				

		rset=stmt.executeQuery(sql1.toString());
		if(rset!=null)
		{
		   while(rset.next())
		   {
			fid=rset.getString("facility_id");
			fname=rset.getString("facility_name");
			if(fid.equals("All"))
			out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
			else
			out.println("<option value='"+fid+ "' >"+fname+"</option>");
		   }
		   if(rset !=null) rset.close(); if(stmt != null) stmt.close();

		}
		}catch(Exception e)
		{
			out.println(e);
		}
		finally { 
				ConnectionManager.returnConnection(con,request);
				}

		   
%>	</select>
		</td>
		</tr>

		<tr>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
		<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td  width='30%' class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class="fields" width='20%' >
				<input type=text id="p_date_frm" name='p_fm_trn_date' id='p_fm_trn_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_frm');">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>		
			<td class="fields" width='40%' >
				<input type=text id="p_date_to" name='p_to_trn_date' id='p_to_trn_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');">&nbsp;<img src='../../eCommon/images/mandatory.gif'align='center'></img>
			</td>
		</tr>

		<tr>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>	
		<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
		<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fr_nursing_unit"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
					</jsp:include>
					</tr>
		<%}else{%>
		<tr>

			<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class="fields" width='20%'  >
				<input type=text disabled name='p_fr_nursing_unit' id='p_fr_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_fm' id='nursing_unit_code_fm' value='?' class='button' onclick='searchCode(this, p_fr_nursing_unit)'>
			</td>			
			<td class="fields" width='40%'> 
				<input type=text  disabled name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_to' id='nursing_unit_code_to' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
			</td>		
		
		</tr><%}%>
		<tr>
			<td class="label">&nbsp;</td>
			<td class="label">&nbsp;</td>
		</tr>
			
		</table>
		</td>
	</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="p_resp_id" id="p_resp_id"			value="<%= p_resp_id %>">
<input type="hidden" name="isSpltyNurUnitToEnableYNAppl" id="isSpltyNurUnitToEnableYNAppl"  value="<%= isSpltyNurUnitToEnableYNAppl %>">
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		

</form>
<script>
	document.forms[0].p_all_facility_id.focus();
	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
	document.forms[0].nursing_unit_desc.disabled = true
	document.forms[0].nursing_unit.disabled = true
	document.forms[0].p_fr_nursing_unit.disabled = true
	document.forms[0].p_to_nursing_unit.disabled = true}
</script>
</BODY>
</HTML>

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

