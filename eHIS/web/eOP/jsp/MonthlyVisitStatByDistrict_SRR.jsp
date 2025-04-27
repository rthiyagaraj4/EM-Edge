<!DOCTYPE html>

<%--
Filename		: MonthlyVisitStatByDistrict.jsp
Modified On		: 2-3-2005
Version			: 3
--%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id		= (String) session.getValue( "facility_id" );
	String p_user_name		= (String) session.getValue( "login_user" );
%>
<html>
<HEAD>
<SCRIPT>



<%-- Code added/modified by Tushar .T. Bhat on 10-Feb-04 for incorporating enterable look-ups --%>


function searchCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = "<%=p_facility_id%>";
	var tit="";
	var locale = "<%= localeName %>"; 

	target.value=trimString(target.value);

	if(target.value=="" && window.event.target == target)
		return;
	
	var argumentArray=new Array(8);

	if(obj.name=="toresarea" || obj.name=="fromresarea")
	{
		tit=getLabel("Common.area.label","Common");

		//SQL

		//argumentArray[0]="select res_area_code code, short_desc description from mp_res_area where '1' like ? and upper(res_area_code) like upper(nvl(?,res_area_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select res_area_code code, long_desc description from mp_res_area_lang_vw where language_id='"+locale+"' and '1' like ? and upper(res_area_code) like upper(nvl(?,res_area_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
		
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;

   	}
	else if(obj.name=="tospecialty" || obj.name=="fromspecialty")
            {
		
                tit=getLabel("Common.speciality.label","Common");

				//SQL

                //argumentArray[0]="select speciality_code code, short_desc description from am_speciality where '1' like ? and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

				argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
                
				argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

            }
	else if(obj.name=="torestown" || obj.name=="fromrestown")
	{
		tit=getLabel("Common.Town.label","Common");

		//SQL

		//argumentArray[0]="select res_town_code code, short_desc description from mp_res_town where '1' like ? and upper(res_town_code) like upper(nvl(?,res_town_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select res_town_code code, long_desc description from mp_res_town_lang_vw where language_id='"+locale+"' and '1' like ? and upper(res_town_code) like upper(nvl(?,res_town_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
		
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
          
	}	
	else
	{
		tit=getLabel("eMP.Province.label","MP");

		//SQL

		//argumentArray[0]="select res_town_code code, short_desc description from mp_res_town where '1' like ? and upper(res_town_code) like upper(nvl(?,res_town_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";

		argumentArray[0]="select region_code code, short_desc description from mp_region_lang_vw where language_id='"+locale+"' and '1' like ? and upper(region_code) like upper(nvl(?,region_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
		
		argumentArray[1]=new Array("'1'");
		argumentArray[2]=new Array("1");
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
	
	
	}

	var retVal=CommonLookup(tit,argumentArray);

	if(retVal==null || retVal=="")
		target.value="";
	else
		target.value=retVal[0];
	

}

function setDate(Object)    { 

var currentDate = new Date();
       if(Object.value!="")
	{
	   if (isBeforeNow(Object.value,"MY",localeName))
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



<%-- Code added/modified by Tushar .T. Bhat on 10-Feb-04 ends --%>




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
<script src="../../eOP/js/MonthlyVisitStatByDistrict_SRR.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<center>
<BODY OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name="VisitByStatus_form" id="VisitByStatus_form"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br>

<table cellpadding='0' border = '0' cellspacing='0' width='80%'>
<td class='columnheader' width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
</table>
<table cellpadding='2' border = '0' cellspacing='0' width='80%'>
<tr>
	<!-- <td class="label"><fmt:message key="eOP.StatisticsMonthYear.label" bundle="${op_labels}"/></td> -->
	<td  class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2'><input type=text id='mdsfrom' name='p_st_date' id='p_st_date' size="7" maxlength="7" align="left" onBlur='if(validateMthYr(this)){setDate(this)}'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom','mm/y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
</tr>
<tr>
	<td width='33%'>&nbsp;</td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
	<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.AreaCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_resarea" id="p_fm_resarea" size="4" maxlength="4" onBlur='searchCode(fromresarea,this)'><input type='button' name='fromresarea' id='fromresarea' value='?' class='button' onclick='searchCode(this, p_fm_resarea)'>
	</td>
	<td class='fields'><input type="text" name="p_to_resarea" id="p_to_resarea" size="4" maxlength="4" onBlur='searchCode(toresarea,this)'><input type='button' name='toresarea' id='toresarea' value='?' class='button' onclick='searchCode(this, p_to_resarea)'>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.TownCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_restown" id="p_fm_restown" size="6" maxlength="6" onBlur='searchCode(fromrestown,this)'><input type='button' name='fromrestown' id='fromrestown' value='?' class='button' onclick='searchCode(this, p_fm_restown)'>
	</td>
	<td class='fields'><input type="text" name="p_to_restown" id="p_to_restown" size="6" maxlength="6" onBlur='searchCode(torestown,this)'><input type='button' name='torestown' id='torestown' value='?' class='button' onclick='searchCode(this, p_to_restown)'>
	</td>	
</tr>
<tr>
	<td class="label"><fmt:message key="eMP.Province.label" bundle="${mp_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_province" id="p_fm_province" size="6" maxlength="6" onBlur='searchCode(fromprovince,this)'><input type='button' name='fromprovince' id='fromprovince' value='?' class='button' onclick='searchCode(this, p_fm_province)'>
	</td>
	<td class='fields'><input type="text" name="p_to_province" id="p_to_province" size="6" maxlength="6" onBlur='searchCode(toprovince,this)'><input type='button' name='toprovince' id='toprovince' value='?' class='button' onclick='searchCode(this, p_to_province)'>
	</td>	
</tr>
<tr class='fields'>
	<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="p_fm_specialty_code" id="p_fm_specialty_code" size="4" maxlength="4" onBlur='searchCode(fromspecialty,this)'><input type='button' name='fromspecialty' id='fromspecialty' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
	</td>
	<td class='fields'><input type="text" name="p_to_specialty_code" id="p_to_specialty_code" size="4" maxlength="4" onBlur='searchCode(tospecialty,this)'><input type='button' name='tospecialty' id='tospecialty' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
	</td>
</tr>
<tr>
	<td class="label"><fmt:message key="Common.close.label" bundle="${common_labels}"/><fmt:message key="Common.VisitStatus.label" bundle="${common_labels}"/></td>
    <td class='fields' colspan='2'><select name="visit_status" id="visit_status" >
			<option value =''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" 
			bundle="${common_labels}"/> --------&nbsp;</option>
			<option value ='C'><fmt:message key="Common.complete.label" bundle="${common_labels}"/></option>
			<option value ='I'><fmt:message key="Common.incomplete.label" bundle="${common_labels}"/></option>
			<option value ='A'><fmt:message key="eOP.AutoComplete.label" bundle="${op_labels}"/></option>
		</select>
		</td>		
	</tr>	
</table>

	<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=p_facility_id %>">
		<input type="hidden" name="p_facility" id="p_facility"  		value="<%=p_facility_id %>">
		
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="OP">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="OPMNVSDS">
		<input type="hidden" name="p_user_name" id="p_user_name"		    value="<%=p_user_name %>">
		
		<input type="hidden" name="p_res_area_from" id="p_res_area_from"		value="">
		<input type="hidden" name="p_res_area_to" id="p_res_area_to" 		value="">

		<input type="hidden" name="p_res_town_from" id="p_res_town_from"		value="">
		<input type="hidden" name="p_res_town_to" id="p_res_town_to" 		value="">

		<input type="hidden" name="p_visit_status" id="p_visit_status"		value="">
		
		<input type="hidden" name="p_stat_date" id="p_stat_date"		    value="">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>
</body>
</center>

<br>
<br>
</html>

