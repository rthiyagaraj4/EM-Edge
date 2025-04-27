<!DOCTYPE html>

<%--
Filename		: VisitStatByCircumInjury.jsp
Modified On		: 1-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
	String locale=(String)session.getAttribute("LOCALE");
%>
<html>
<HEAD>
<SCRIPT>

async function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale="<%=locale%>";

	target.value=trimString(target.value);
	
	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);
	
	if(obj.name=="tocinjury" || obj.name=="fromcinjury")
	{
		tit=getLabel("Common.CircumstanceofInjury.label","Common");

		//SQL

		
		//argumentArray[0]="select contact_reason_code code, contact_reason description from am_contact_reason where '1' like ? and upper(contact_reason_code) like upper(nvl(?,contact_reason_code)) and upper(contact_reason) like upper(nvl(?,contact_reason)) order by 2";

		//argumentArray[0]="select contact_reason_code code, contact_reason description from am_contact_reason_lang_vw where '1' like ? and language_id='"+locale+"' and upper(contact_reason_code) like upper(nvl(?,contact_reason_code)) and upper(contact_reason) like upper(nvl(?,contact_reason)) order by 2";

		argumentArray[0]="select CIRCUMSTANCE_OF_INJURY_CODE code, SHORT_DESC description from AM_CIRCUM_OF_INJURY_LANG_VW where '1' like ? and language_id='"+locale+"' and upper(CIRCUMSTANCE_OF_INJURY_CODE) like upper(nvl(?,CIRCUMSTANCE_OF_INJURY_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) order by 2";
		        
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

        
	}else
    {
        tit=getLabel("Common.Location.label","Common");

		//SQL

        //argumentArray[0]="select clinic_code code, short_desc description from op_clinic where facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

                
    }

	var retVal=await CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
		 
}
function setDate(Object){ 

//var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"DMY",localeName))
        {
          return true;
        }
        else
        {
			alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
			Object.value="";
            Object.focus();            
        }
    }
	}


<%-- Code added/modified by Tushar .T. Bhat on 09-Feb-04 ends --%>


</SCRIPT>

<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src="../../eOP/js/repOPVisitStatByCircumInjury_SRR.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onLoad="Focusing('p_fm_date')" onKeyDown ='lockKey()'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br>

<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<td class='columnheader' width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>

<tr width='33%'><td>&nbsp;</td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td></tr>

<tr>
	<td class="label"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type=text id='mdsfrom'  name='p_fm_date' id='p_fm_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
	<td class='fields'><input type=text id='mdsto'  name='p_to_date' id='p_to_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsto');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
	
	</td>
</tr>



<tr>
	<td class="label"><fmt:message key="Common.CircumstanceofInjury.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_circum_inj" id="p_fm_circum_inj" size="8" maxlength="8" onBlur='searchCode(fromcinjury,this)'><input type='button' name='fromcinjury' id='fromcinjury' value='?' class='button' onclick='searchCode(this, p_fm_circum_inj)'></td>

	

	<td class='fields'><input type="text" name="p_to_circum_inj" id="p_to_circum_inj" size="8" maxlength="8" onBlur='searchCode(tocinjury,this)'><input type='button' name='tocinjury' id='tocinjury' value='?' class='button' onclick='searchCode(this, p_to_circum_inj)'>
	</td>
</tr>


<tr>
	<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>

	<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code)'>
	</td>

	<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code)'>
	</td>
</tr>

	<tr>
		<td class="label"><fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/></td>
    <td class='fields'><select name="visit_status" id="visit_status" >
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='C'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value ='I'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			<option value ='A'><fmt:message key="eOP.AutoComplete.label" bundle="${op_labels}"/></option>
		</select>
		</td>
		<td>&nbsp;</td>		
	</tr>	
</table>

	<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id %>">

		
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPVSCRIJ">
		<input type="hidden" name="p_user_name" id="p_user_name"		 value="<%=p_user_name %>">
		
		<input type="hidden" name="p_circum_injury_from" id="p_circum_injury_from"	value="">
		<input type="hidden" name="p_circum_injury_to" id="p_circum_injury_to" 		value="">
		
		<input type="hidden" name="p_clinic_from" id="p_clinic_from"	value="">
		<input type="hidden" name="p_clinic_to" id="p_clinic_to" 		value="">
		
		<input type="hidden" name="p_visit_status" id="p_visit_status"	value="">
		
		<input type="hidden" name="p_date_from" id="p_date_from"	value="">
		<input type="hidden" name="p_date_to" id="p_date_to" 		 value="">

	<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>
</body>
</center>

<br>
<br>
</html>

