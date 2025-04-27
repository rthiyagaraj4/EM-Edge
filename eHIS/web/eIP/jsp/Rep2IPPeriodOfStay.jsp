<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%

	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBLOSST" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	Connection	con		=	null;
	Statement	stmt			=	null;
	ResultSet	rset			=	null;

%>
<html>

<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
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
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var allfacilityid	=	document.forms[0].p_all_facility_id.value;
										
			if(obj.name=="nursing_unit_code_fm" || obj.name=="nursing_unit_code_to")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`"+allfacilityid+"` ";

				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+allfacilityid+"` and language_id=`"+locale+"`";
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


	function chkAscendingOrder()
	{

		if(blankchk())
		{	
			var itr;
			var itr1;
			if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
			itr=7;
			itr1=15;
			}else{
				itr=5;
				itr1=13;
				}
			for(var i=itr;i<itr1;i++)
			{

				if(document.RepIPPeriodOfStayForm.elements[i].value == '0' || document.RepIPPeriodOfStayForm.elements[i+1].value == '0')
				{
					alert(parent.parent.frames[0].getMessage('INVALID_POSITIVE_NUMBER','common'));
					return false;
					break;
				}
				else if(document.RepIPPeriodOfStayForm.elements[i].value == '' &&( document.RepIPPeriodOfStayForm.elements[i+1].value != ''  && document.RepIPPeriodOfStayForm.elements[i-1].value != ''))
				{
						alert(parent.parent.frames[0].getMessage('MUST_BE_ASCENDING','IP'));
						return false;
						break;
				}
				else if(eval(document.RepIPPeriodOfStayForm.elements[i].value) > eval(document.RepIPPeriodOfStayForm.elements[i+1].value))
				{
					alert(parent.parent.frames[0].getMessage('MUST_BE_ASCENDING','IP'));
					return false;
					break;
				}
			}
		}
		else
		{
			alert(parent.parent.frames[0].getMessage('ATLEAST_ONE_RANGE','IP'));
			return false;
		}
		return true;
	}


	function blankchk()
	{		var itr;
			var itr1;
			if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
			itr=6;
			itr1=15;
			}else{
				itr=4;
				itr1=13;
				}
		for(var i=itr;i<itr1;i++){
			
			if(document.RepIPPeriodOfStayForm.elements[i].value !=' '){
				return true;
				break; 
			}
		}
		return false;
	}

	function chkVal(obj)
	{

		if ( obj.value == "All" )
		{	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fr_nursing_unit_code.disabled = true
					document.forms[0].p_to_nursing_unit_code.disabled = true
					document.forms[0].nursing_unit_desc.disabled = true
					document.forms[0].nursing_unit.disabled = true
				}else{
				document.forms[0].p_fr_nursing_unit_code.disabled = true
				document.forms[0].p_to_nursing_unit_code.disabled = true
				document.forms[0].nursing_unit_code_fm.disabled = true
				document.forms[0].nursing_unit_code_to.disabled = true
				}
		}
		else
		{	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fr_nursing_unit_code.disabled = false
					document.forms[0].p_to_nursing_unit_code.disabled = false
					document.forms[0].nursing_unit_desc.disabled = false
					document.forms[0].nursing_unit.disabled = false
				}else{	
				document.forms[0].p_fr_nursing_unit_code.disabled = false
				document.forms[0].p_to_nursing_unit_code.disabled = false
				document.forms[0].nursing_unit_code_fm.disabled = false
				document.forms[0].nursing_unit_code_to.disabled = false
				}
		}
			if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].nursing_unit_desc.value = ""}
				document.forms[0].p_fr_nursing_unit_code.value = ""
				document.forms[0].p_to_nursing_unit_code.value = ""

	}


</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="RepIPPeriodOfStayForm" id="RepIPPeriodOfStayForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' cellPadding="0" cellSpacing="0" >

	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

	<tr>

		<td width="100%" align='center' cellPadding="0" cellSpacing="0"  >

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

			<!-- To Populate Facility List -->

				<tr>
					<td  class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td colspan ="3"> 
							<select name='p_all_facility_id' id='p_all_facility_id' onchange ="chkVal(this)">
						<%
							String isSpltyNurUnitToEnableYNAppl="";
							try
							{
							
							con		=	ConnectionManager.getConnection(request);
							isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
							stmt=con.createStatement();

							String fid;
							String fname;

							//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"' and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";
							rset=stmt.executeQuery(sql1);

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
							}
							if(rset!=null)rset.close();
							if(stmt!=null)stmt.close();
							}catch(Exception e)
							{
								out.println(e);
							}
							finally { 
									ConnectionManager.returnConnection(con,request);
									}

						%>	
						</select>
					</td>
				</tr>


				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
	
				</tr>								
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fr_nursing_unit_code"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit_code"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='20%'  >
						<input type=text  disabled name='p_fr_nursing_unit_code' id='p_fr_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_fm' id='nursing_unit_code_fm' value='?' class='button' onclick='searchCode(this, p_fr_nursing_unit_code)'>
					</td>
					<td class="fields" width='40%'> 
						<input type=text  disabled name='p_to_nursing_unit_code' id='p_to_nursing_unit_code' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_to' id='nursing_unit_code_to' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit_code)'>
					</td>
				</tr><%}%>

				<tr><td colspan=3>&nbsp;</td></tr>	

				</table>
				<tr><th align='left' width='100%'> <fmt:message key="eIP.StayPeriod.label" bundle="${ip_labels}"/></th></tr>

				<tr>
						<td align='left' class="label">&nbsp;&nbsp; <fmt:message key="eIP.RangeinDays.label" bundle="${ip_labels}"/> --> &nbsp;</td>
				</tr>

				<tr>
						<td class="fields" align='center' >
							<input type="text" name="p_range1" id="p_range1" value='1' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range2" id="p_range2" value='2' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range3" id="p_range3" value='3' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range4" id="p_range4" value='4' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range5" id="p_range5" value='5' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range6" id="p_range6" value='6' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range7" id="p_range7" value='7' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range8" id="p_range8" value='14' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range9" id="p_range9" value='21' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;&nbsp;
							<input type="text" name="p_range10" id="p_range10" value='28' size=4 maxlength=4 onKeyPress='return(ChkNumberInput(this,event,0))' >
						</td>
				</tr>
				<tr><td>&nbsp;</td></tr>	
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
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
	document.forms[0].p_all_facility_id.focus()
	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
	document.forms[0].nursing_unit_desc.disabled = true
	document.forms[0].nursing_unit.disabled = true
	document.forms[0].p_fr_nursing_unit_code.disabled = true
	document.forms[0].p_to_nursing_unit_code.disabled = true}
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

