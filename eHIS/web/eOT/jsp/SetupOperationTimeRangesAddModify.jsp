<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %> 
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/dchk.js" ></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language='javascript' src='../../eOT/js/SetupOperationTimeRanges.js'></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript'>
var RE_NUM = /^\-?\d+$/;
function checkForPositiveNumber(obj)
{
	//RE_EXP=/^[1-9]$/
	//if(RE_EXP.exec(obj))
var object=obj.value;

	if(isNaN(object)==true)
	{
		//alert("Enter a valid no");
		alert(getMessage("INVALID_NEXT_NUMBER","common"));
	   obj.select();
	   obj.focus();
	   
	}
	if(object!="" && object<=0 ){
	  //alert("No. should be > 0");
	  alert(getMessage("INVALID_POSITIVE_NUMBER","common"));
	  obj.select();
	  obj.focus();
	}
}

function checkForSpecCharsforID(event)
{
    var strCheck = '0123456789:';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
	return (event.keyCode -= 32);
	return true ;
}
/*
function timeValidity(obj) {
	var str_time=obj.value;
    var dt_date = new Date();
	var arr_time = String(str_time ? str_time : '').split(':');
	if (!arr_time[0]) dt_date.setHours(0);
	
	else if (RE_NUM.exec(arr_time[0]))
		if (arr_time[0] < 24) dt_date.setHours(arr_time[0]);
			else return cal_error ("Invalid hours value: '" + arr_time[0] + "'.\nAllowed range is 00-23.",obj);
	else return cal_error ("Invalid hours value: '" + arr_time[0] + "'.\nAllowed format is HH24:MM",obj);
		//alert("88");
	if (!arr_time[1]) dt_date.setMinutes(0);
	else if (RE_NUM.exec(arr_time[1]))
		if (arr_time[1] < 60) dt_date.setMinutes(arr_time[1]);
		else return cal_error ("Invalid minutes value: '" + arr_time[1] + "'.\nAllowed range is 00-59.",obj);
	else return cal_error ("Invalid minutes value: '" + arr_time[1] + "'.\nAllowed format is HH24:MM",obj);
	return true;
}

function cal_error (str_message,obj) {
	alert (str_message);
	return false;
}
*/
function timeCheckBetObjects(objst,objend)
{
		var st_date =  objst.value; 
		var end_date = objend.value; 
		
		var start_date_arr = st_date.split(':');
		var end_date_arr = end_date.split(':');

		var	dt_date_start = new Date();
		var	dt_date_end = new Date();

		dt_date_start.setHours(start_date_arr[0]);
		dt_date_start.setMinutes(start_date_arr[1]);
		dt_date_end.setHours(end_date_arr[0]);
		dt_date_end.setMinutes(end_date_arr[1]);
	
       if(start_date_arr[1]>59){
			return true;
	   }else if(dt_date_end > dt_date_start){
			return true;
	   }else if(dt_date_start.length!=5|| dt_date_end.length!=5){
				return true;
		}else {
			return false;
		}
	
}
function chkTime_local(strfromTime){
	strfromTimeVal = strfromTime.value;
	strSplitTime = strfromTimeVal.split(":");
	hr = strSplitTime[0];
	min = strSplitTime[1];
	if(strfromTime.value.length !=5)
	{
		//alert(getMessage("INVALID_TIME_FMT","CA"));
		alert(getMessage("AM0161","AM"));// Time in Minutes should be between 0 and 59
		//strfromTime.select();
		strfromTime.value="";
		return false;
	}
	if(hr>23){
		//alert(getMessage("INVALID_TIME_HOUR"),"CA");
		alert(getMessage("AM0160","AM"));//Time in Hours should be between 0 and 23
		//strfromTime.select();
		strfromTime.value = "";
		return false;
	}
	if(min>59){
		//	alert(getMessage("INVALID_TIME_MINUTE","CA"));
		alert(getMessage("AM0161","AM"));
		//strfromTime.select();
		strfromTime.value = "";
		//return false;
		return false;
	}
	return true;
}
function TimeCheck(obj,field)
{   
	var formObj = document.SetupOperationTimeRanges_form;
	var objTrace = null;
	var objId = null;
	var previousObj  = null;
	eval('formObj.slot_'+field).value=obj.value;
	var flag1=true;
	for (dtCnt=1;dtCnt<=field;dtCnt++ )
	{
		objTrace = eval('this.document.SetupOperationTimeRanges_form.time_slot_'+dtCnt); 
		objId = eval('this.document.SetupOperationTimeRanges_form.time_slot_id_'+dtCnt); 
		if(objTrace.value!=null && objTrace.value!=""){
		if (dtCnt==field ){
			var flag = chkTime_local(objTrace);// timeValidity(objTrace);
		}else{
		    var flag = true;

		}
			if ( flag == true && flag1==true){
				if (dtCnt>1){
					previousObj = eval('this.document.SetupOperationTimeRanges_form.time_slot_'+(dtCnt-1)); 
					if(previousObj!=null){
						if (dtCnt==field){
							if (timeCheckBetObjects(previousObj,objTrace) == false && flag1==true){
								//alert("if")
								//objTrace.select();	
								alert(getMessage("APP-OT0113","OT"));//This time slot should be greater than the previous time slot
								objTrace.focus();
								//objTrace.select();
								objTrace.value = "";
								flag1=false;
								break;
								
							}
						}
					}

				}
				
			}else{
				return;

			}

		}
		
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
Connection con=null;
Connection con1=null;
PreparedStatement stmt=null;
PreparedStatement stmt1=null;
ResultSet rs=null;
ResultSet rs1=null;
String mode=request.getParameter("mode");
String time_range_code = request.getParameter("time_range_code")==null?"":request.getParameter( "time_range_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String time_slot_1="";
String time_slot_2="";
String time_slot_3="";
String time_slot_4="";
String time_slot_5="";
String time_slot_6="";
String time_slot_7="";
String time_slot_8="";
String time_slot_9="";
String time_slot_10="";
String status="";
String sql="";
String time_range_code_disable="";
StringBuffer time_range_code_from_DB=new StringBuffer();

if(mode.equals("modify"))
{
	try{

		con1=ConnectionManager.getConnection(request);
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		sql="SELECT TIME_RANGE_CODE,TO_CHAR(TIME_1_SLOT,'HH24:MI'), TO_CHAR(TIME_2_SLOT,'HH24:MI'),TO_CHAR(TIME_3_SLOT,'HH24:MI'), TO_CHAR(TIME_4_SLOT,'HH24:MI'),TO_CHAR(TIME_5_SLOT,'HH24:MI'),TO_CHAR(TIME_6_SLOT,'HH24:MI'),TO_CHAR(TIME_7_SLOT,'HH24:MI'),TO_CHAR(TIME_8_SLOT,'HH24:MI'),TO_CHAR(TIME_9_SLOT,'HH24:MI'),TO_CHAR(TIME_10_SLOT,'HH24:MI'), NVL(STATUS,'E') STATUS FROM  OT_OPER_TIME_RANGE WHERE TIME_RANGE_CODE=?";

		stmt1=con1.prepareStatement(sql);
		stmt1.setString(1,time_range_code);
		rs1=stmt1.executeQuery();
		if(rs1!=null && rs1.next())
		{

			time_slot_1=rs1.getString(2);
			time_slot_2=rs1.getString(3);
			time_slot_3=rs1.getString(4);
			time_slot_4=rs1.getString(5);
			time_slot_5=rs1.getString(6);
			time_slot_6=rs1.getString(7);
			time_slot_7=rs1.getString(8);
			time_slot_8=rs1.getString(9);
			time_slot_9=rs1.getString(10);
			time_slot_10=rs1.getString(11);
			status=rs1.getString(12);			
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			chk_value="E";
			disable_flag="";
			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		
	time_range_code_disable="disabled";	

}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt1!=null) stmt1.close();
			if(rs1!=null)rs1.close();
			if(con1!=null)
			ConnectionManager.returnConnection(con1);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
}else if(mode.equals("insert")){
   
		try{
		con=ConnectionManager.getConnection(request);
		sql="SELECT TIME_RANGE_CODE FROM OT_OPER_TIME_RANGE";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        		
		while(rs!=null && rs.next())
		{
			time_range_code_from_DB=time_range_code_from_DB.append(",").append(rs.getString(1));
			//out.println("time_range_code_from_DB===="+time_range_code_from_DB);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
	}

%>
<form name="SetupOperationTimeRanges_form" id="SetupOperationTimeRanges_form"  onload='FocusFirstElement()' action="../../servlet/eOT.SetupOperationTimeRangesServlet" method='post' target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='70%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
	<%
	PreparedStatement stmt2=null;
	ResultSet rs2=null;
	String curr_date="";

	try{
		con=ConnectionManager.getConnection(request);
		con=ConnectionManager.getConnection(request);
		sql="select '01'||to_char(sysdate,'/mm/yyyy') from dual";
		stmt2=con.prepareStatement(sql);
		rs2=stmt2.executeQuery();

		if(rs2!=null && rs2.next())
		{
			curr_date=rs2.getString(1);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt2!=null) stmt2.close();
			if(rs2!=null)rs2.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
		%>
</tr>

<tr>
	<td class=label width="25%">
		<fmt:message key="eOT.TimeRangeCode.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" colspan="3">
		<input type="text" name="time_range_code" id="time_range_code" onkeypress="return checkForSpecCharsforID(event);" value="<%=time_range_code%>" size=4 maxlength=4 <%=time_range_code_disable%> onBlur="checkForPositiveNumber(this);">  
        <img src='../../eCommon/images/mandatory.gif'>
	</td> 
</tr>

<tr>
    <th class='columnheader' width="25%" colspan="4">
		<fmt:message key="eOT.TimeSlots.Label" bundle="${ot_labels}"/>
	</th>
</tr>

<tr>
	<td class='label' width="25%">1</td>
	<td class='fields' width="25%">
		<!-- <input type="text" name="time_slot_1" id="time_slot_1" id='time_slot_id_1' value="<%=time_slot_1%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,1);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'> -->
		<input type="text" name="time_slot_1" id="time_slot_1" id='time_slot_id_1' value="<%=time_slot_1%>" size=5 maxlength=5  onkeypress="return checkForSpecCharsforID(event);" onBlur="if(this.value!='')TimeCheck(this,1);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' width="25%">2</td>
	<td class='fields' width="25%" nowrap>
		<input type="text" name="time_slot_2" id="time_slot_2" id='time_slot_id_2' value="<%=time_slot_2%>"  size=5 maxlength=5 onkeypress="return checkForSpecCharsforID(event);" onBlur="if(this.value!='')TimeCheck(this,2);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class='label' width="25%">3</td>
	<td class='fields' width="25%">
		<input type="text" name="time_slot_3" id="time_slot_3" id='time_slot_id_3' value="<%=time_slot_3%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,3);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' width="25%">4</td>
	<td class='fields' width="25%" nowrap>
		<input type="text" name="time_slot_4" id="time_slot_4" id='time_slot_id_4' value="<%=time_slot_4%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,4);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>	
</tr>
<tr>
	<td class='label' width="25%">5</td>
	<td class='fields' width="25%">
		<input type="text" name="time_slot_5" id="time_slot_5" id='time_slot_id_5' value="<%=time_slot_5%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,5);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' width="25%">6</td>
	<td class='fields' width="25%" nowrap>
		<input type="text" name="time_slot_6" id="time_slot_6" id='time_slot_id_6' value="<%=time_slot_6%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,6);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
<tr>
	<td class='label' width="25%">7</td>
	<td class='fields' width="25%">
		<input type="text" name="time_slot_7" id="time_slot_7" id='time_slot_id_7' value="<%=time_slot_7%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,7);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif' >
	</td>
	<td class='label' width="25%">8</td>
	<td class='fields' width="25%" nowrap>
		<input type="text" name="time_slot_8" id="time_slot_8" id='time_slot_id_8' value="<%=time_slot_8%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,8);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
<tr>
	<td class='label' width="25%">9</td>
	<td class='fields' width="25%">
		<input type="text" name="time_slot_9" id="time_slot_9" id='time_slot_id_9' value="<%=time_slot_9%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,9);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	<td class='label' width="25%">10</td>
	<td class='fields' width="25%" nowrap>
		<input type="text" name="time_slot_10" id="time_slot_10" id='time_slot_id_10' value="<%=time_slot_10%>" onkeypress="return checkForSpecCharsforID(event);" size=5 maxlength=5 onBlur="if(this.value!='')TimeCheck(this,10);" <%=disable_flag%> ><img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
<tr>
	<td class="label" width="25%">
		<fmt:message key="Common.status.label" bundle="${common_labels}"/>
	</td>
		<td class='fields' colspan="3">
			<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value="<%=chk_value%>" <%=chk_checked%> >
		</td>

</tr>

<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='time_range_code1' id='time_range_code1' value="<%=time_range_code%>">
<input type="hidden" name='slot_1' id='slot_1' value="<%=time_slot_1%>">
<input type="hidden" name='slot_2' id='slot_2' value="<%=time_slot_2%>">
<input type="hidden" name='slot_3' id='slot_3' value="<%=time_slot_3%>">
<input type="hidden" name='slot_4' id='slot_4' value="<%=time_slot_4%>">
<input type="hidden" name='slot_5' id='slot_5' value="<%=time_slot_5%>">
<input type="hidden" name='slot_6' id='slot_6' value="<%=time_slot_6%>">
<input type="hidden" name='slot_7' id='slot_7' value="<%=time_slot_7%>">
<input type="hidden" name='slot_8' id='slot_8' value="<%=time_slot_8%>">
<input type="hidden" name='slot_9' id='slot_9' value="<%=time_slot_9%>">
<input type="hidden" name='slot_10' id='slot_10' value="<%=time_slot_10%>">
<input type="hidden" name='curr_date' id='curr_date' value="<%=curr_date%>">
<input type="hidden" name='disable_flag' id='disable_flag' value="<%=disable_flag%>">
<input type="hidden" name='time_range_code_from_DB' id='time_range_code_from_DB' value="<%=time_range_code_from_DB%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


