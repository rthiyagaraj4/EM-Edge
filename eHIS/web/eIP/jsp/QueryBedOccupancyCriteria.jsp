<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<%@page import="java.sql.*,webbeans.eCommon.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String facilityid = (String)session.getValue("facility_id");
	String locale	  = (String)session.getAttribute("LOCALE");
	//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Connection con  =  null;
	String isSpltyNurUnitToEnableYNAppl="";
try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
	}catch(Exception e){/* out.println(e); */e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //END
%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	
	
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../../eIP/js/IPQueryCommon.js" language="javascript"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<body  onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='label'  width='30%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<!-- Changed to Common lookup on 10/02/04 by Sridhar -->
			<td>
				<input type=text  name='SplDesc' id='SplDesc' size="15" maxlength="15" align="center" onBlur=" beforeGetSpecialty_BedOccupancy(Splcode,SplDesc);"><input type='button' name='spltybutton' id='spltybutton' value='?' class='button' onclick='SpecialLookup_BedOccupancy(Splcode,SplDesc);'><input type=hidden  name='Splcode' id='Splcode' size="4" maxlength="4" align="center">
			</td>
				<td colspan=2>&nbsp;</td>
			</tr>
			<tr>
				<!-- Common lookup for NursingUnit From & To  -->
				<!-- Modified by Sridhar on 10/02/2004 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<td  class='label'  width='30%'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<input type=hidden name="to_nursing_unit" id="to_nursing_unit" value="">
				<%}else{%>
				<td  class='label'  width='30%'><fmt:message key="eIP.NursingUnitFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td><%}%>
				<td>
					<input type=text  name='fr_nursing_unit_desc' id='fr_nursing_unit_desc' size="15" maxlength="15" align="center" onBlur="beforeGetNursingUnit_BedOccupancy(fr_nursing_unit,fr_nursing_unit_desc);"><input type='button' name='nursing_unit_fm' id='nursing_unit_fm' value='?' class='button'
					onclick='Lookup_BedOccupancy(fr_nursing_unit,fr_nursing_unit_desc);'><input type=hidden  name='fr_nursing_unit' id='fr_nursing_unit' size="4" maxlength="4" align="center" onBlur="return makeValidQueryCriteria(this);">
				</td>
				<%if(isSpltyNurUnitToEnableYNAppl.equals("Y")){%>
				<td class='label' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<input type=text  name='to_nursing_unit_desc' id='to_nursing_unit_desc' size="15" maxlength="15" align="center" onBlur="compareFrom_BedOccupancy();beforeGetNursingUnit_BedOccupancy(to_nursing_unit,to_nursing_unit_desc);" ><input type='button' name='nursing_unit_to' id='nursing_unit_to' value='?' class='button' onclick='Lookup_BedOccupancy(to_nursing_unit,to_nursing_unit_desc);' onBlur="compareFrom_BedOccupancy();"><input type=hidden  name='to_nursing_unit' id='to_nursing_unit' size="4" maxlength="4" align="center" onBlur="return makeValidQueryCriteria(this);">
				</td>
				<%}%>
			</tr>
		</table>
		<table align='right'>
			<tr>
				<td align='right' class='white'>
					<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>removeToSearch();<%}%> submitPage_BedOccupancy()'>
					<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="clearAll_BedOccupancy()">			
				</td>
				<input type=hidden name="facilityid" id="facilityid" value="<%=facilityid%>">
				<input type=hidden name="locale" id="locale" value="<%=locale%>">
			</tr>				
		</table>
	</form>
  </body>
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

