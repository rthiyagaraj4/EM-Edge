<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	String fromquery = request.getParameter("fromQuery")==null?"":request.getParameter("fromQuery");
	String facilityid = (String)session.getValue("facility_id");
%>
	<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<script>
			function submitPage()
			{				
				var params = "";
				if(document.forms[0].fr_nursing_unit.value != '')
					params+="&fr_nursing_unit="+document.forms[0].fr_nursing_unit.value;
				if(document.forms[0].to_nursing_unit.value != '')
					params+="&to_nursing_unit="+document.forms[0].to_nursing_unit.value;
				if(document.forms[0].fr_bed_class.value != '')
					params+="&fr_bed_class="+document.forms[0].fr_bed_class.value;
				if(document.forms[0].to_bed_class.value != '')
					params+="&to_bed_class="+document.forms[0].to_bed_class.value;

				if('<%=fromquery%>' == 'ON')
					parent.result.location.href= '../jsp/QueryBedOccupancyByNursUnitResult.jsp?'+params
				else
					parent.result.location.href= '../jsp/QueryBedClassStatisticsResult.jsp?'+params
			}
			
			async function searchCode(obj,target)
			{
					var retVal = 	new String();
					var dialogHeight= "28" ;
					var dialogWidth	= "43" ;
					var status = "no";
					var arguments	= "" ;
					var sql="";
					var search_code="";
					var search_desc="";
					var tit="";

					if(obj.name=="nursing_unit")
					{
						tit=getLabel('Common.nursingUnit.label','common');
						sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`<%=facilityid%>`";
						search_code="nursing_unit_code";
						search_desc= "short_desc";
					}
					else if(obj.name == "bed_class_code")
					{
						tit=getLabel('Common.BedClass.label','common')
						sql="select bed_class_code, short_desc from ip_bed_class ";
						search_code="bed_class_code";
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
			
		</script>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
	<form name='Criteria_Form' id='Criteria_Form' >
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
				<td  class='label' align='right' width='30%'><fmt:message key="eIP.NursingUnitFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<input type=text  name='fr_nursing_unit' id='fr_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, fr_nursing_unit)'>
				</td>
				<td  class='label' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td>
					<input type=text  name='to_nursing_unit' id='to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit' id='nursing_unit' value='?' class='button' onclick='searchCode(this, to_nursing_unit)'>
				</td>
			</tr>
			
			<tr>
				<td align='right' width='30%' class="label"><fmt:message key="eIP.BedClassCodeFrom.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td >
					<input type=text  name='fr_bed_class' id='fr_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, fr_bed_class)'>
				</td>
				<td  class='label' align='right'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td> 
					<input type=text  name='to_bed_class' id='to_bed_class' size="2" maxlength="2" align="center"><input type='button' name='bed_class_code' id='bed_class_code' value='?' class='button' onclick='searchCode(this, to_bed_class)'>
				</td>
			</tr>
		</table>

		<table align='right'>
		<tr>
			<td align='right' class='white'>
				<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick="this.form.reset();parent.result.location.href='../../eCommon/html/blank.html' ">
				<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'>
				<input type='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onclick="parent.window.returnValue='';parent.window.close()">
			</td>
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

