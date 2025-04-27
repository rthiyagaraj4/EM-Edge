<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="webbeans.eCommon.*,java.util.*,java.sql.*,com.ehis.util.*,java.text.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPCRLDGRL" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	//Added by shanmukh on 14th-AUG-2018 for ML-MMOH-CRF-1115
	Connection con  =  null;
	String isSpltyNurUnitToEnableYNAppl="";
	try
    {
	con  =  ConnectionManager.getConnection(request);
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);
	}catch(Exception e){out.println(e);e.printStackTrace();}
	 finally
	 {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	 }
	 //END
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src='../js/Rep2MasterList.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<script>
async function searchCode(obj,target)
	{
		var retVal		= 	new String();
		var locale		= "<%=locale%>";
		var eff_status	= "E" ;
		var dialogHeight= "400px" ;
		var dialogWidth	= "700px" ;
		var status		= "no";
		var arguments	= "" ;
		var sql			="";
		var search_code	="";
		var search_desc	="";
		var tit			="";
 
        if(obj.name=="nursing_unit_code")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`<%= p_facility_id%>` and language_id=`"+locale+"` ";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}

	    if(obj.name=="p_reason_for_stay_code")
			{
				tit=getLabel('eIP.ReasonforStay.label','eIP');
				sql="select reason_for_stay_code, short_desc from IP_REASON_FOR_LOD_STAY_LANG_VW where language_id=`"+locale+"` and eff_status = `"+eff_status+"`";
				search_code="reason_for_stay_code";
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

	function validate_date(obj) {
	
		if(obj.value!=''){
			
			if(!validDateObjforAdm(obj.value,'DMYHM',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'));
			//obj.select();
			obj.value="";
		}else{
			if(isBeforeNow(obj.value,"DMYHM",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				//obj.select();
				//obj.focus();
				obj.value="";
				return false ;
				}
			}
		}
  }

  function validDateObjforAdm(Object3){
	
	var checkFlag= true ;
    var strDate;
    var strDay;
    var strMonth;
    var strYear;
    
    var dateArray1=Object3.split(" ");
	var	dateArray=(dateArray1[0]).split("/");
	var time1arr=dateArray1[1].split(":");
	if(time1arr.length==2)
				{
					var time1hr=time1arr[0];
					var time1min=time1arr[1];

					if(time1hr < 0 && time1hr >24 && time1min < 00 && time1min > 59)
						{
						 checkFlag=false;
					}

					if (time1hr.length != 2 || time1min.length != 2)
					{
						 checkFlag=false;
					}
				}
    var strDateArray = new Array();

   
    if (dateArray.length == 0) checkFlag= true;


    strDateArray = dateArray;
    if (strDateArray.length != 3) {
        checkFlag= false;
    }
    else {
        strDay = trimString(strDateArray[0]);
        strMonth = trimString(strDateArray[1]);
        strYear = trimString(strDateArray[2]);
    }


    if (strYear.length < 4 || strYear.length > 4) checkFlag= false;
    if (strMonth.length != 2) checkFlag= false;
    if (strDay.length != 2) checkFlag= false;

    if (isNaN(strDay)==true) checkFlag= false;
    if (isNaN(strMonth)==true) checkFlag = false;
    if (isNaN(strYear)==true) checkFlag= false;

    if (strYear < 1800) checkFlag = false;

        if (strMonth>12 || strMonth<1)  checkFlag = false;

    if ((strMonth == 01 || strMonth == 03 || strMonth == 05 || strMonth == 07 || strMonth == 08 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) checkFlag = false;

    if ((strMonth == 04 || strMonth == 06 || strMonth == 09 || strMonth == 11) && (strDay > 30 || strDay < 01)) checkFlag = false;

    if (strMonth == 02) {
        if (strDay < 01) checkFlag = false;

        if (LeapYear(strYear) == true) {
            if (strDay > 29) checkFlag = false;
        }
        else {
            if (strDay > 28) checkFlag = false;
        }
    }
    return checkFlag;
}

</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="CurrentLodgerListForm" id="CurrentLodgerListForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
     
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	  <tr>
	  <td width="80%" class="Border" align='center'>

		<table width='100%' cellPadding="0" cellSpacing="0"  align='left' style="padding-left:5%;" >
            
			<tr>
			<td class='label' align="left" width="30%"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
			<td class="label" width="30%"><fmt:message key="Common.Lodger.label" bundle="${common_labels}"/></td>
            </tr>

			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

		    <tr>
			<td align="center" width="30%">&nbsp;</td>
			<td class="label" width="30%" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="label" width="40%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		    </tr>
            
            <tr>
				<td class='label' width='30%' align='left'><fmt:message key="eIP.CheckInDate.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td width='35%'>
				<input type='text' id="P_FROM_DATE" maxlength='16' size='16' name='P_FROM_DATE' id='P_FROM_DATE' onblur="if(validDateObj(this,'DMYHM',localeName))validate_date(this)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_FROM_DATE', null, 'hh:mm');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>     
				</td>
				<td width='40%'> 
				<input type='text' id="P_TO_DATE" maxlength='16' size='16' name='P_TO_DATE' id='P_TO_DATE' onBlur="if(validDateObj(this,'DMYHM',localeName))validate_date(this)"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_DATE', null, 'hh:mm');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

			<tr><!--Added by Shanmukh on 20th-AUG-2018 for ML-MMOH-CRF-1115-->
			<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
				<jsp:include page="CommonNursingUnitLookup.jsp">
				<jsp:param name="nursing_unit_code_Appl" value="P_FR_NURSING_UNIT_CODE"/>
				<jsp:param name="nursing_unit_to_code_Appl" value="P_TO_NURSING_UNIT_CODE"/>
				</jsp:include>
				<%}else{%>
                 <td align='left' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
				<td width='30%'  >
					<input type=text  name='P_FR_NURSING_UNIT_CODE' id='P_FR_NURSING_UNIT_CODE' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, P_FR_NURSING_UNIT_CODE)'>
				</td>
				<td width='40%'> 
					<input type=text  name='P_TO_NURSING_UNIT_CODE' id='P_TO_NURSING_UNIT_CODE' size="4" maxlength="4" align="center"><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, P_TO_NURSING_UNIT_CODE)'>
				</td>
				<%}%>	
			</tr>

			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>

            <tr>
			<td  align='left' width='30%' class="label"><fmt:message key="eIP.ReasonforStay.label" bundle="${ip_labels}"/> &nbsp;</td> 
			<td width='30%' >
			   <input type=text  name='P_FROM_STAY_CODE' id='P_FROM_STAY_CODE' size="4" maxlength="2" align="center"><input type='button' name='p_reason_for_stay_code' id='p_reason_for_stay_code' value='?' class='button' onclick='searchCode(this, P_FROM_STAY_CODE)'>
			</td>
			<td width='40%' >
			   <input type=text  name='P_TO_STAY_CODE' id='P_TO_STAY_CODE' size="4" maxlength="2" align="center"><input type='button' name='p_reason_for_stay_code' id='p_reason_for_stay_code' value='?' class='button' onclick='searchCode(this, P_TO_STAY_CODE)'>
			</td>
	        </tr>


        </table>
	
	  </td>
      </tr>
</table>
<input type="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id"   value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id"   value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	  value="<%= p_user_name %>">
<input type="hidden" name="P_CATEGORY" id="P_CATEGORY"    value="Lodger">
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

