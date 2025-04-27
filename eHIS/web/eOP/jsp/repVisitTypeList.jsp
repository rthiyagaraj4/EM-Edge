<!DOCTYPE html>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	
// commented by Raj when dealing with unclosed connections and resultsets on 10/17/2003
	//Statement stmt;
	//ResultSet rs ;
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "OP" ;
	String p_report_id		= "OPRVSTTY" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;	
	String p_locale = (String)session.getAttribute("LOCALE");


%>
<html>
<HEAD>
<TITLE></TITLE>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<script>
async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var tit="";
			var facilityid = "<%=p_facility_id%>";	
			var locale = "<%=p_locale%>";

			target.value=trimString(target.value);
			
			if(target.value=="" && window.event.target == target)
				return;
			
			var argumentArray=new Array(8);
			
			if(obj.name=="fm_visitTypeCode" || obj.name=="to_visitTypeCode")
			{				
				tit=getLabel("Common.visittype.label","Common");

                //SQL
				
				argumentArray[0]="select visit_type_code code,short_desc description from op_visit_type_lang_vw where language_id='"+locale+"' and Facility_id like ? and upper(visit_type_code) like upper(nvl(?,visit_type_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[1]=new Array("Facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
			}
			
			var retVal=await CommonLookup(tit,argumentArray);
			var ret1=unescape(retVal);
		 	var arr=ret1.split(",");
		 	if(arr[1]==undefined) 
	 		{
		 		arr[0]="";	
		 		arr[1]="";	
	 		}
			if(retVal==null || retVal=="")
				target.value="";
			else
				target.value=arr[0];
			
	}
	
</script>

<BODY onMouseDown="CodeArrest();" onLoad="Focusing('p_fm_visit_type_code')" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repVisitTypeList" id="repVisitTypeList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<table width='80%' align='center' valign='top'>
			<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
			</table>
            <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border ='0'>
				<tr>
					<td width='33%'>&nbsp;</td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text  name='p_fm_visit_type_code' id='p_fm_visit_type_code' size="2" maxlength="2" align="center" onBlur='if(this.value!="")searchCode(fm_visitTypeCode,this)'><input type='button' name='fm_visitTypeCode' id='fm_visitTypeCode' value='?' class='button' onclick='searchCode(this, p_fm_visit_type_code)'></td>
					<td class='fields'><input type=text  name='p_to_visit_type_code' id='p_to_visit_type_code' size="2" maxlength="2" align="center" onBlur='if(this.value!="")searchCode(to_visitTypeCode,this)'><input type='button' name='to_visitTypeCode' id='to_visitTypeCode' value='?' class='button' onclick='searchCode(this, p_to_visit_type_code)'></td>
				</tr>				
				<tr>
					<td class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='2'>
						<select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>				
				<tr>
					<td class="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan='2'>
						<select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="Common.VisitTypeCode.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="Common.VisitTypeDescription.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>				
			</table>	
		
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
<input type="hidden" name="sql_p_fm_visit_type_code" id="sql_p_fm_visit_type_code" value="">
<input type="hidden" name="p_locale" id="p_locale"		value="<%= p_locale %>">
</form>
</BODY>
</HTML>

