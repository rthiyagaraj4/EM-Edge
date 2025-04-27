<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
async function searchCode(obj,target,encounter_type_obj)
{
	var sql="";
	var sqlSecond="";
	var facilityid =document.forms[0].p_facility_id.value;	
	var tit="";
	var locale = "<%=localeName%>";
	target.value=trimString(target.value);
	if(target.value=="" && window.event.target == target)
		return;
	var argumentArray=new Array(8);
	var encounter_type=encounter_type_obj.value;
	if(obj.name=="fromlocn" || obj.name=="tolocn")
    {
		  tit=getLabel("Common.locationcode.label","Common");
		if(encounter_type=='ALL')
			{
			argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and clinic_type IN ('C','E') and LEVEL_OF_CARE_IND in ('A','E') order by 2";
			}
		else if(encounter_type=='OP')
			{
			argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and clinic_type IN ('C','E') and LEVEL_OF_CARE_IND = 'A' order by 2";
			}
		else if(encounter_type=='EM')
			{
			argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and clinic_type = 'C' and LEVEL_OF_CARE_IND = 'E' order by 2";
			}	
	  
	//	argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id like ? and upper(clinic_code) like upper(nvl(?,clinic_code)) and upper(long_desc) like upper(nvl(?,long_desc)) and clinic_type IN ('C','E') and LEVEL_OF_CARE_IND in ('A','E') order by 2";
	
		argumentArray[1]=new Array("facility_id");
		argumentArray[2]=new Array(facilityid);
		argumentArray[3]=new Array(STRING);
		argumentArray[4]="2,3";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
    }	
	else if(obj.name=="custcode1")
            {
		//	tit=getLabel("eOP.DisplayInReportCustomerGroupCode1.label","OP");
			tit=getLabel("eOP.DisplayInReportCustomerGroup1.label","OP");
			argumentArray[0]="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_group_code) like upper(nvl(?,cust_group_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";         
			argumentArray[1]=new Array("'1'");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC;    	
	 }
	else{
	   // tit=getLabel("eOP.DisplayInReportCustomerGroupCode2.label","OP");
			tit=getLabel("eOP.DisplayInReportCustomerGroup2.label","OP");
			argumentArray[0]="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_group_code) like upper(nvl(?,cust_group_code)) and upper(long_desc) like upper(nvl(?,long_desc)) order by 2";         
			argumentArray[1]=new Array("'1'");
			argumentArray[2]=new Array("1");
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
function validate_dateTo(obj) {
		var from = obj.value;
		var to   = document.forms[0].CurrentDate.value;
		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldt = getMessage("TO_DT_NGE_CURR_DATE","SM") ;
					var visit_Date=getLabel('Common.to.label','common_labels')+" "+getLabel('Common.VisitDate.label','op_labels');
					invaldt = invaldt.replace('To date',visit_Date);
					alert(invaldt);
					document.forms[0].p_to_visit_date.select();
					document.forms[0].p_to_visit_date.focus();
				}
			}
		}
		function validate_dateFrom(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if (CheckDate(obj)){
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var visit_fromDate=getLabel('Common.from.label','common_labels')+" "+getLabel('Common.VisitDate.label','common_labels');
					invaldtFrom = invaldtFrom.replace('From date',visit_fromDate);
					alert(invaldtFrom);
					document.forms[0].p_fm_visit_date.select();
					document.forms[0].p_fm_visit_date.focus();
					}
				}
		}
	function setValue()
{
				
if ( repClinicStatDaywiseform.sum_id.checked == true)
     {
	    repClinicStatDaywiseform.p_sum_yn.value="Y";			 
	  }              
	  if ( repClinicStatDaywiseform.detail_id.checked == true)
        {
	     repClinicStatDaywiseform.p_sum_yn.value="N";
		}             
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
	
	
function Remove_CustomerCode1()
	{
	var cus_code1=document.forms[0].p_cust_code1.value;
	var cus_code2=document.forms[0].p_cust_code2.value;
	if(cus_code1!="" && cus_code2!="")
	{
	if(cus_code1==cus_code2){
	alert(getMessage("DUP_CUSGROUP_CODE",'OP'));
	document.forms[0].p_cust_code1.value="";
	document.forms[0].p_cust_code1.focus();
	}
    }
	}
	function Remove_CustomerCode2()
	{
	var cus_code1=document.forms[0].p_cust_code1.value;
	var cus_code2=document.forms[0].p_cust_code2.value;
	if(cus_code1!="" && cus_code2!=""){
	if(cus_code1==cus_code2){
	alert(getMessage("DUP_CUSGROUP_CODE",'OP'));
	document.forms[0].p_cust_code2.value="";
	document.forms[0].p_cust_code2.focus();
	}
	}
	}
function ClearLocn(obj,fm_locn_code,to_locn_code)
	{
	fm_locn_code.value='';
	to_locn_code.value='';
	}
</script>
<%
	String p_menu_id=request.getParameter("menu_id");
    String p_module_id      = request.getParameter("module_id");
    
        
    String p_report_id      = "OPVSTCUS" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
    String function_id		= request.getParameter("function_id");
    String function_name	=  request.getParameter("function_name");
    String function_type	=  request.getParameter("function_type");
    String access			=  request.getParameter("access");
    
   // System.err.println("Module Id" +p_module_id);
    //System.err.println("Menu Id" +p_menu_id);
    //System.err.println("Fact Id" +p_);
    //System.err.println("Menu Id" +p_menu_id);

    
    StringBuffer strValue = new StringBuffer();
    //strValue.append("<option value='B' selected><fmt:message key=Common.Both.label bundle=${common_labels}/>");
    //strValue.append("<option value=B selected>Both");
    strValue.append("<option value='C'>Cash");
    strValue.append("<option value='R'>Credit");
    //strValue.append("<option value='N'><fmt:message key=Common.none.label bundle=${common_labels}/>");
    //strValue.append("<option value='N'>None");
    		
   	String CurrentDate = "";
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con=null;
    String ID="";
    String dat="";
    String en="";
   try{
		con=ConnectionManager.getConnection(request); 
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="reportVisitStatsCustomerform" id="reportVisitStatsCustomerform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR>
    <table width='80%' align='center' valign='top'>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	</table>   
    <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>        
			 <tr>
					<td >&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>

					<td class="label"><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type=text id='p_fm_visit_date'  name='p_fm_visit_date' id='p_fm_visit_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
					<td class='fields'><input type=text id='p_to_visit_date'  name='p_to_visit_date' id='p_to_visit_date' size="10" maxlength="10" align="left" onBlur='if(validDateObj(this,"DMY",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
					</td>
			</tr> 
			<!-- Shaik mujafar  added as per MMS-QH-CRF-0175 on 28/1/2015  -->
			<tr>
				<td class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/>
				</td>
						<td class='fields'><select name="p_encounter_type" id="p_encounter_type" onchange='ClearLocn(this,p_fm_locn_code,p_to_locn_code)'>
						<option value='ALL' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						
						<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
						<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
						</select></td>
		         </tr>  
		<!--  mujafar end  -->
			<tr class='fields'>
				<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
				<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" onBlur='searchCode(fromlocn,this,p_encounter_type)'><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode(this, p_fm_locn_code,p_encounter_type)'>
				</td>
				<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4" onBlur='searchCode(tolocn,this,p_encounter_type)'><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode(this, p_to_locn_code,p_encounter_type)'>
				</td>
			</tr>

			<tr>
				<!-- Shaik Mujafar added for MMS-QH-CRF-0175 as on 27/01/2015 -->
				<!--<td class="label"><fmt:message key="eOP.DisplayInReportCustomerGroupCode1.label" bundle="${op_labels}"/></td>-->
				<td class="label"><fmt:message key="eOP.DisplayInReportCustomerGroup1.label" bundle="${op_labels}"/></td>
				<td class='fields'><input type="text" name="p_cust_code1" id="p_cust_code1" size="8" maxlength="8" onBlur='searchCode(custcode1,this,p_encounter_type);Remove_CustomerCode1()'><input type='button' name='custcode1' id='custcode1' value='?' class='button' onclick='searchCode(this, p_cust_code1,p_encounter_type);Remove_CustomerCode1()'>
				</td>
				</tr>
				<tr>
				<!-- Shaik Mujafar added for MMS-QH-CRF-0175 as on 27/01/2015 -->
				<!--<td class="label"><fmt:message key="eOP.DisplayInReportCustomerGroupCode2.label" bundle="${op_labels}"/></td> -->
				<td class="label"><fmt:message key="eOP.DisplayInReportCustomerGroup2.label" bundle="${op_labels}"/></td>
				<td class='fields'><input type="text" name="p_cust_code2" id="p_cust_code2" size="8" maxlength="8" onBlur='searchCode(custcode2,this,p_encounter_type);Remove_CustomerCode2()'><input type='button' name='custcode2' id='custcode2' value='?' class='button' onclick='searchCode(this, p_cust_code2,p_encounter_type);Remove_CustomerCode2()'>
				</td>
			</tr>
			<tr>
				<td class="label"><fmt:message key="eOP.VisitRegistrationBy.label" bundle="${op_labels}"/>
				</td>
						<td class='fields'><select name="p_payable" id="p_payable">
						<option value='A' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<%=strValue.toString() %>
						<option value='N'><fmt:message key="Common.none.label" bundle="${common_labels}"/>
						</select></td>
		         </tr>   
            
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="OP">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
		<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">
		<input type="hidden" name="p_function_id" id="p_function_id"		value="<%= function_id %>">
		<input type="hidden" name="p_function_name" id="p_function_name"		value="<%= function_name %>">
		<input type="hidden" name="p_function_type" id="p_function_type"		value="<%= function_type %>">
    </form>
<% }
	catch(Exception e)
	{ out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 if( con !=null ) ConnectionManager.returnConnection(con,request);
}
%>
</center>
</body>
</html>

