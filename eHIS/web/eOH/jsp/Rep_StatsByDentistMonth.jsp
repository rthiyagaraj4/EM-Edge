<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
String facility_id = (String)session.getValue("facility_id");
String user_id = (String)session.getValue("login_user");
String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
request.setCharacterEncoding("UTF-8");
%>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language='javascript' src='../../eOH/js/MasterReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReports.js'></script> 
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script> 
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>


</head>
<%
String  FromMonth  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FromMonth.label","common_labels");
String  ToMonth  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ToMonth.label","common_labels");
String  FromDentist  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.FromDentist.Label","oh_labels");
String  ToDentist  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ToDentist.Label","oh_labels");
%>
<script>

function isValidMonth(obj){
	var RE_NUM =/^\d{2}\/+\d{4}$/
	var str_date = obj.value;
	var arr_date = str_date.split('/');
	var dt_date = new Date();
	var flag=true;
	var flag1=true;
	var year = dt_date.getFullYear();
	if(obj.value!=""){
		if(!RE_NUM.test(str_date) && arr_date.length!=2) flag=false;
		if (arr_date[0] < 1 || arr_date[0] > 12) flag=false;
		if(arr_date[1]>year) flag1=false;
		if(flag==false){
			return cal_error (getMessage('INVALID_DATE_FMT','SM'),obj);
		}else if(monthcheck(obj)==false){// else if condition added by parul on 27/04/2010 for IN020945
			 alert(getMessage("INVALID_DATE_FMT", "SM"));
			 obj.select();
			 obj.focus();
		}
		if(flag1==false){//  if condition added by parul on 05/05/2010
			alert(getMessage("DATE_NOT_GREATER_SYSDATE",'Common'));
			obj.focus();
			obj.select();
		}
	}
	return true
}
function cal_error (str_message,obj) {
	alert (str_message);
	obj.focus();
	obj.select();
	return null;
}
/*
function checkmonths(formObj) {
	//var msg1=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
	//alert(msg1);
	var fromdt=formObj.param1.value;
	var todt=formObj.param2.value;
	var msg = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
	var msgArray = msg.split("#");
	var to_date=getLabel("Common.todate.label","Common");
	var from_date =getLabel("Common.fromdate.label","Common");
	var from_month="From Motnh";
	var to_month="To Month"
    var frm_dt= formObj.param1.value;

	if ( fromdt.value != undefined)
	{
		fromdt = fromdt.value ;
	}
	else
		fromdt = fromdt;
	
	if ( todt.value != undefined)
	{
		todt = todt.value ;
	}
	else
		todt = todt;

    var arr = new Array();
    var arr1 = new Array();
    arr = fromdt.split("/");
    arr1 = todt.split("/");
    if(arr[0].length == 1)
        var fr=arr[1] + '0' + arr[0];
    else
        var fr=arr[1] + arr[0];

    if(arr1[0].length == 1)
        var to=arr1[1] + '0'+arr1[0];
    else
        var to=arr1[1] + arr1[0];

    if(fr <= to)
        return true;
    else {
		alert(msgArray[0]+from_month+(msgArray[1])+to_month+(msgArray[2]));
		return false;
         }
		 }*/

	
</script>
<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
 
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;
String Current_Month="";
String sql = "";

 sql = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') DATE_TIME, TO_CHAR(SYSDATE,'MM/YYYY') MON_YEAR, TO_CHAR(SYSDATE,'HH24:MI') HOURS_MTS FROM DUAL";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			Current_Month = com.ehis.util.DateUtils.convertDate(rst.getString("MON_YEAR"),"MY","en",locale);  
		}	
		
  
%>
<form name="OHReportOptionsForm" id="OHReportOptionsForm" onload='FocusFirstElement()'  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" method="" > 
<table border=0 cellspacing=0 cellpadding=3  width='100%'  align='center'>

    <td class='label' width='25%'>
		
		<fmt:message key="Common.FromMonth.label" bundle="${common_labels}"/> 
	</td>

    <td class='fields' width='25%'>
			<input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='11'   value='<%=Current_Month%>'  maxlength='7'  Onblur="javascript:isValidMonth(this);">
			<input type='image' name='imagedate' id='imagedate' src="../../eCommon/images/CommonCalendar.gif" 
			onClick="return showCalendar('P_FROM_DATE','mm/y');">
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
		<td class='label' width='25%'>
		 <fmt:message key="Common.ToMonth.label" bundle="${common_labels}"/> 
		
		   
	</td>
	<td class='fields' width='25%'>
			<input type='text' name='P_TO_DATE' id='P_TO_DATE' size='11'   value='<%=Current_Month%>'  maxlength='7'  Onblur="javascript:isValidMonth(this);">
			<input type='image' name='imagedate' id='imagedate' src="../../eCommon/images/CommonCalendar.gif" 
			onClick="return showCalendar('P_TO_DATE','mm/y');">
			<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	
</tr>
 <tr>
	<td class='label' width='25%'>
	 <fmt:message key="eOH.FromDentist.Label" bundle="${oh_labels}"/> 
	
	
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="P_FRM_DENTIST" id="P_FRM_DENTIST" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='25' title='<%=FromDentist%>' param1 = 'P_FRM_DENTIST'  param2 = 'param4' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_FRM_DENTIST.value='',param4.value='' "> 
	<input type='button' class='button' value='?' name='FromDentistLookUp' id='FromDentistLookUp' onClick="callCommonLookup(param3_desc);">
	</td>

	<td class='label' width='25%'>
	<fmt:message key="eOH.ToDentist.Label" bundle="${oh_labels}"/> 

	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6' value=""> 
		<input type='hidden' name="P_TO_DENTIST" id="P_TO_DENTIST" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='25' title='<%=ToDentist%>' param1 = 'P_TO_DENTIST'  param2 = 'param6' key ='DENTIST' onBlur="if(this.value!='')callCommonLookup(this); else P_TO_DENTIST.value='',param6.value='' "> 
		<input type='button' class='button' value='?' name='ToDentistLookUp' id='ToDentistLookUp' onClick="callCommonLookup(param5_desc);" >
		
	</td>
</tr>   

		
	<% 
	}catch(Exception e){
		out.println("exp"+e);
	}finally{
		try{
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			out.println("exp"+e);
		}
	}
%>

</td>

</tr>
 <tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr> 
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>" >
<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>" >
<input type="hidden" name="p_module_id" id="p_module_id"  value="OH" >
<input type="hidden" name="p_report_id" id="p_report_id" value="OHRDENST" > 

<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=FromMonth%>" disabled>
<input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=ToMonth%>" disabled> 
<!-- <input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param3_desc##<%=FromDentist%>" disabled> -->

 <!-- <input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##FromMonth" disabled>
<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>  -->

</form>
</body>
</html>


