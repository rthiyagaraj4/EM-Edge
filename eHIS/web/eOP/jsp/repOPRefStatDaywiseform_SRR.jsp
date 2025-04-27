<!DOCTYPE html>
<%--
Filename		: repOPRefStatDaywiseform.jsp
Modified On		: 2-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8"); 
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con = null; 

    String p_module_id      = "OP" ;
    String p_report_id      = "OPBDYRFC" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String locale=(String)session.getAttribute("LOCALE");
    String ID="";
    String dat="";
    String en="";
    try{
		con = ConnectionManager.getConnection(request); 
%>
<html>
<HEAD>
<TITLE></TITLE>

<script>
/*function chmonth(obj)
{
    if(obj.value != "")
	{
		if(validDate(obj.value,'MM',localeName)==false)
		{
			var msg=getMessage("INVALID_MONTH_FMT","SM");
			alert(msg);
			obj.select();
		}		
	}
}

function validateYear(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'YY',localeName)==false)
				{
				alert(getMessage("INVALID_YEAR_FMT", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}*/
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
                //Object.focus();
            
        }
    }
	}

	function validateMthYr(obj)
	{
		if(obj.value!="")
		{
			if(validDate(obj.value,'MY',localeName)==false)
				{
				alert(getMessage("MONTH_YEAR_INVALID", "SM"));
				obj.select();	
				return false;
			}
			else
				return true;
		}
}
function searchCode(obj,target)
{
	var retVal = 	new String();
	var dialogHeight= "28" ;
	var dialogWidth	= "43" ;
	var status = "no";
	var arguments	= "" ;
	var sql="";
	var search_code="";
	var search_desc="";
	var facilityid = document.forms[0].p_for_facility_id.value;
	var locale="<%=locale%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	return;
	var tit="";
   	var argumentArray=new Array(8);
   tit=getLabel("Common.Location.label","Common");
     
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where facility_id like ? and language_id='"+locale+"' and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";
                
				argumentArray[1]=new Array("facility_id");
				argumentArray[2]=new Array(facilityid);
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
          var retVal=CommonLookup(tit,argumentArray);
		if(retVal==null || retVal=="")
		target.value="";
		else
			target.value=retVal[0];
}

async function SpecialityCode(obj,target)
{
	var sql="";
	var sqlSecond="";
	var facilityid = document.forms[0].p_for_facility_id.value;
	var tit="";
	var locale="<%=locale%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
	return;
	var argumentArray=new Array(8);
          tit=getLabel("Common.speciality.label","Common");
		argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where '1' like ? and language_id='"+locale+"' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(short_desc) like upper(nvl(?,short_desc)) order by 2";
       			argumentArray[1]=new Array("'1'");
				argumentArray[2]=new Array("1");
				argumentArray[3]=new Array(STRING);
				argumentArray[4]="2,3";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;
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

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
 <!-- <script src="../../eOP/js/repResetRunList_SRR.js"></script> -->
 <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<br>
<br>
<form name="repOPRefStatDaywiseform" id="repOPRefStatDaywiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
</table>
       
<table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>
      			<tr>
					<td class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
                    <td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
                    <%
                    stmt=con.createStatement();
                    //rset=stmt.executeQuery("SELECT FACILITY_NAME,FACILITY_ID from sm_facility_for_user_vw WHERE APPL_USER_ID='"+p_user_name+"' order by FACILITY_NAME ");

					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");

                    if(rset!=null)
                    {
                    while(rset.next())
                    {
                    dat=rset.getString("FACILITY_NAME");
                    ID=rset.getString("FACILITY_ID");

                    out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
                    }%>
                    </select>
                    <%  }

                    %>
                    </td>
                </tr>               
  <tr>
      <td class="label"><fmt:message key="eOP.ForMonthYear.label" bundle="${op_labels}"/></td>
	  <!-- <td  class="label"><fmt:message key="Common.month.label" bundle="${common_labels}"/>/<fmt:message key="Common.year.label" bundle="${common_labels}"/></td> -->
	  <td class='fields'>
			<!-- <td class='fields' colspan='2'><input type="text" name="p_p_month" id="p_p_month" size="2" maxlength="2" onBlur="chmonth(this)" onKeyPress='return(ChkNumberInput(this,event,0))'>
			/ <input type="text" name="p_p_year" id="p_p_year" size="4" maxlength="4" onBlur="validateYear(this)" onKeyPress='return(ChkNumberInput(this,event,0))'><img src='../../eMP/images/mandatory.gif' align='center'></img> -->
			<input type="text" id='mdsfrom' name="p_fm_mon_yr" id="p_fm_mon_yr" size="7" maxlength="7" onBlur='if(validateMthYr(this)){setDate(this)}'><img  src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('mdsfrom','mm/y', null);" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img>
        </td> 		
  </tr> 
  <tr>
		<td width='33%'>&nbsp;</td>
		<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="querydata" width='33%' style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
  </tr>
  <tr>
		<td class="label"><fmt:message key="Common.SpecialtyCode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="p_specialty_from" id="p_specialty_from" size="4" maxlength="4" onBlur='SpecialityCode(this,p_specialty_from)'><input type='button' name='fromspec' id='fromspec' value='?' class='button' onclick='SpecialityCode(this,p_specialty_from)'>
		</td>	
		<td class='fields'><input type="text" name="p_specialty_to" id="p_specialty_to" size="4" maxlength="4" onBlur='SpecialityCode(this,p_specialty_to)'><input type='button' name='tospec' id='tospec' value='?' class='button' onclick='SpecialityCode(this,p_specialty_to)'>
		</td>
</tr>
<tr>
		<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="p_loc_from" id="p_loc_from" size="4" maxlength="4"  onBlur='searchCode(this,p_loc_from)'><input type='button' name='location' id='location' value='?' class='button' onclick='searchCode(this,p_loc_from)'>
		</td>
		<td class='fields'><input type="text" name="p_loc_to" id="p_loc_to" size="4" maxlength="4" onBlur='searchCode(this,p_loc_to)'><input type='button' name='location' id='location' value='?' class='button' onclick='searchCode(this,p_loc_to)'>
		</td>
</tr>

</table>        
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
<input type="hidden" name="p_month" id="p_month"             value="">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

</form>

<%}
catch(Exception e) {out.println(e.toString());}
finally{
	try
	{
	if(stmt != null) stmt.close();
	if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
if(con!=null)
    ConnectionManager.returnConnection(con,request);
}  %>
</BODY>
</HTML>

