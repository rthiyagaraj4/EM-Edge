<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String locale		= (String)session.getAttribute("LOCALE");
try{
%>
<html>
<head>
<%
    String sStyle	=         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script  language="javascript">
	function addOrderByCol() { 
		var from = document.getElementById("OrderbyCols"); 
		if ( from.options.length > 0 ) { 
			var to = document.getElementById("OrderbyColumns"); 
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value= from.options[from.selectedIndex].value; 
			to.add(element); 			
			from.remove(from.selectedIndex); 
		}
	} 
	
	function removeOrderByCol()	{ 
		var from = document.getElementById("OrderbyColumns"); 
		if ( from.options.length > 0 ) { 
			var to = document.getElementById("OrderbyCols");
			var element = document.createElement("OPTION"); 
			element.text = from.options[from.selectedIndex].text; 
			element.value = from.options[from.selectedIndex].value; to.add(element);			
			from.remove(from.selectedIndex); 
		} 
	}	
	
	function SelectAll() {
		var i = 0; document.getElementById("OrderbyColumns").selectedIndex=0; 
		while ( i < document.getElementById("OrderbyColumns").length) { 	
			document.getElementById("OrderbyColumns").options[i].selected=true; 
			i++; 
		}
	} 
	
	function execQuery() {  
		SelectAll();
		if(document.forms[0].date_from.value =="")
		{
            alert(getMessage('FROM_DATE_CANNOT_BE_BLANK','SM'));
			focusObject();
		}
		else if(document.forms[0].date_to.value =="")
		{
            alert(getMessage('TO_DT_NOT_BLANK','SM'));
			focusObject();
		}
		else if(document.forms[0].OrderbyColumns.value=="")
		{
			var msg = getMessage("CAN_NOT_BE_BLANK","Common");
			msg     = msg.replace("$",getLabel("Common.orderBy.label","Common"));
			alert(msg);
			focusObject();
		}
		else
		{
	     var date_from=document.forms[0].date_from.value;
	     var date_to=document.forms[0].date_to.value;
		 var proc_id=document.forms[0].proc_id.value;
		 var facility_id=document.forms[0].faci_id.value;
		 var facility_name=document.forms[0].faci_name.value;
        document.location.href="../../eSM/jsp/ProcQueryResult.jsp?date_from="+date_from+"&date_to="+date_to+"&proc_id="+proc_id+"&facility_id="+facility_id+"&facility_name="+facility_name
		}
	}
	function focusObject()
		{
		document.forms[0].elements[0].focus();
		}

	function DateValidation(obj,obj1)
{
	var msg="";

	if(obj.name=="date_from")
	   msg = getMessage("FROM_DT_NGE_CURR_DATE","SM");
	if(obj.name=="date_to")
	   msg = getMessage("TO_DT_NGE_CURR_DATE","SM");
	
	if(!(isBeforeNow(obj.value,"DMY",localeName)))
	{
		if(obj.value!=''){
		obj.focus();
		obj.select();
		obj.value='';
		alert(msg);
		return false;
		}
	}
	if(obj.name=="date_from" && document.query_form.date_to.value!="" ){
	if(!(isBefore(obj.value,document.query_form.date_to.value,"DMY",localeName))){
		if(obj.value!=''){
		document.query_form.date_to.focus();
		obj.select();
		obj.value='';
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));		
		return false;
		}
	}
 }
	if(obj.name=="date_to" && document.query_form.date_from.value!="" ){
	if(!(isBefore(document.query_form.date_from.value,obj.value,"DMY",localeName))){
		if(obj.value!=''){
		obj.focus();
		obj.select();	
		obj.value='';
		alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
		obj.value='';
		return false;
		}
	}
 }	
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" onLoad="focusObject()">
<form name="query_form" id="query_form" action="../eSM/jsp/ProcQueryResult.jsp" method="post" onSubmit="SelectAll()">
<table width="100%" align="center">
		<th align="left" width="20%"><fmt:message key="Common.QueryCriteria.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" ><p class=label title="Query Criteria">
			<table width="100%">
				<tr>
					<td width="25%" class="label"><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></td>
					<td class='fields' width="25%"><input type="text" name ="proc_id" id ="proc_id" maxlength="30" size="30" value=""></td></td>
				</tr>
                <tr>
					<td width="25%" class="label"><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
					<td class='fields' width="25%"><input type="text" name ="faci_id" id ="faci_id" maxlength="2" size="3" value=""></td></td>
				</tr>
				<tr>
					<td width="25%" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td class='fields' width="25%"><input type="text" name ="faci_name" id ="faci_name" onBlur='ChangeUpperCase(this);'  maxlength="35" size="70" value=""></td></td>
				</tr>
		
				<tr>
					<td width="25%" class="label"><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td>
					<td class='fields' width="25%"><input type="text" id="date_from" name ="date_from" maxlength="30" size="10" value="" onblur='if(validDateObj(this,"DMY","<%=locale%>")) DateValidation(this)'><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('date_from');" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
					<td width="25%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td> 
					<td class='fields' width="25%"><input type="text" id="date_to" name ="date_to" maxlength="30" size="10" value="" onblur='if(validDateObj(this,"DMY","<%=locale%>")) DateValidation(this)'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');" style='cursor:pointer'></img>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>					
				</tr>
			</table>
		</td>
	</tr>
				<table  width='100%' align='center'><th width='20%' align='left'><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/><tr><td nowrap  width='60%' >  <p  title='Sort Order'>
				<table width='50%' align="center" border='0'><td  nowrap align='left'><b><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><td>&nbsp;</td><td nowrap align='left' ><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td><tr><td nowrap width='60%'  >
				<tr>
					<td width="60%"  class='fields'><Select name="OrderbyCols" id="OrderbyCols" size="3"><Option value="msg_date_time"><fmt:message key="eSM.DateDesc.label" bundle="${sm_labels}"/>
					<Option value="operating_facility_id"><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/><Option value="facility_name"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td  width='40%' class='fields'><input type='button' name='add' id='add' class='button' onclick='addOrderByCol()' value='---->' title="Sort Order"><br><input type='button' name='add' id='add' class='button'  value='<----' onclick='removeOrderByCol()' title="Sort Order"></img></td>
					<td width="40%" align="right" class='fields'><Select name="OrderbyColumns" id="OrderbyColumns" size="3" multiple="true"><Option value="proc_id"><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></Select></td>
				</tr>
			</table>
</table><br>
<br><table border='0' width='100%' align='center'><tr><td nowrap width='100%' align='center' class='white'><input type='button' name='ExecuteQuery' id='ExecuteQuery' class='Button' onclick='execQuery()' Value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Execute.label","common_labels")%>'></td></tr></table> 
</form>
</body>
</html>
 <%
} catch (Exception e) {}

%>

