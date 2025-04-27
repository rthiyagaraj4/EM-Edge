<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>



 <%
     request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBDRCNU" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String isSpltyNurUnitToEnableYNAppl="";
	Connection con = ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	Statement stmt=null;
	ResultSet rs =null;
	String str = "select to_char(sysdate,'dd/mm/yyyy') from dual";
	String CurrentDate="";
	try{
		stmt=con.createStatement();
		rs = stmt.executeQuery(str);	
		while (rs.next())
			CurrentDate= rs.getString(1);
	}
	catch(Exception e)
	{}
	finally
	{
		if(stmt!=null) stmt.close();
		if(rs!=null)	rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
<html>	
<HEAD>
<TITLE></TITLE>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>

<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='JavaScript'></script>
<script src="../../eCommon/js/DateUtils.js" language='JavaScript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
 async	function searchCode(obj,target)
		{
				var retVal = 	new String();
				var dialogHeight= "400px" ;
				var dialogWidth="900px";
				/* var dialogHeight= "28" ;
				var dialogWidth	= "43" ; */
				var status = "no";
				var arguments	= "" ;
				var sql="";
				var search_code="";
				var search_desc="";
				var tit="";
	
				//alert(obj.name)
				if(obj.name=="nursing_unit")
				{
					tit="Nursing Unit"
					sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%=p_facility_id%>`";
					search_code="nursing_unit_code";
					search_desc= "short_desc";
				}
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
				retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+tit,arguments,features);
	
				if (!(retVal == null))
				{
					target.value=retVal;
				}
				else
					target.focus();
		}

		 function validate_date(obj) {
				if(obj.value!=''){

					if(isBeforeNow(obj.value,"DMY",localeName))
						return true;
					else {
						alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
						obj.select();
						obj.focus();
						return false ;
					}
				}
  }

</script>

</HEAD>

<BODY onMouseDown="CodeArrest();" onload="FocusFirstElement()" onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2DailyIPCensusForm" id="Rep2DailyIPCensusForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	       <tr>
		   <td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
     		<tr>
				<td >&nbsp;</td>
				<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
				<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
				<td align="left" class="label" ><fmt:message key="eIP.CensusDateRange.label" bundle="${ip_labels}"/> &nbsp;</td>
				<td  width='30%' align='left'>
				<input type=text  name='P_FM_TRN_DATE' id='P_FM_TRN_DATE'  onblur = "if(validDateObj(this,'DMY',localeName))validate_date(this)" size="10" maxlength="10" align="center"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_FM_TRN_DATE');"><img align='center' src='../../eMP/images/mandatory.gif'>
				<td  width='30%' align='left'>
				<input type=text  name='P_TO_TRN_DATE' id='P_TO_TRN_DATE' size="10" maxlength="10" align="center" onblur="if(validDateObj(this,'DMY',localeName))validate_date(this)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_TRN_DATE');"><img align='center' src='../../eMP/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<tr>
					<!-- /*<td align='right' width='30%' class="label">From Date &nbsp;</td>
					<td width='20%'  >
						<input type=text  name='frmdate' id='frmdate' onblur = 'validate_date(this)' size="10" maxlength="10" align="center" >
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>

					<td align='left' width='20%' class="label">To Date &nbsp;</td>
					<td width='20%'  >
						<input type=text  name='todate' id='todate' onblur = 'validate_date(this)' size="10" maxlength="10" align="center" >
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>

					<td colspan ='2'>
				</tr>*/ -->
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
					<td align="center" width="35%">&nbsp;</td>
						<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/>
					</td>
				</tr>				
				<tr>
						<td align="left" class="label" ><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='20%' class="fields">
							<input type=text  name='p_fr_nursing_unit' id='p_fr_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_fr_nursing_unit)'>
						</td>
						<td width='40%' class="fields">
							<input type=text  name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
						</td>
				</tr><%}%>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		
				<tr>
				<td align="left" class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
						<td width='20%'>
							<select name='p_order_by' id='p_order_by'>
							<option value="1"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
							<option value="13"><fmt:message key="eIP.PercentageofOccupancy.label" bundle="${ip_labels}"/></option>
							</select>
						</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"			value="<%= CurrentDate %>">

</form>

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

