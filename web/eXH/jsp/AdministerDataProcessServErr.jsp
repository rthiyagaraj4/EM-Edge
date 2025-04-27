<!DOCTYPE html>
<HTML> 
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HEAD> 
<title>Server Errors</title>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
    
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>							    
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>			   
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/AdministerReviewCommunicationProcess.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<Script>												  

/** Added for Date Validation **/

function ValidateDateTimesp(obj)
{
/*	alert(obj.value);
	if(!(obj.value==""))
	{
		if(validDateObj(obj,"DMYHM",localeName))
		{
			if(!(isBeforeNow(obj.value,"DMYHM",localeName)))
			{
				obj.focus();
				obj.select();
				obj.value='';												  
				alert(getMessage('DT_NLT_CURR_DT','SM'));
			}
		}
	}	
*/
}
  function isAfterCurrDate(obj)
{
	/*var date = obj.value.split(" ");
	var chk_out_date=date[0];
	var chk_out_time=date[1];
			var locale = document.getElementById("locale").value;
	
				var formObj=document.forms[0];

		if(!isAfter(chk_out_date,chk_out_time,"DMYHM",locale)){
					var msg_1 = getMessage("DATE1_NOT_LESSER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedInDateTime.Label","OT");
					var chk_out_dt_time =getLabel("eOT.CheckedOutDateTime.Label","OT");
					alert(msgArr[0]+ chk_out_dt_time +msgArr[1]+ checkin_time +msgArr[2]);								
					 obj.value="";
											 
					 return false;
			}else if(isBeforeNow(chk_out_date,'DMYHM',locale)){
						return true;
				}else{
					var msg_1 = getMessage("DATE1_NOT_GREATER_THAN_DATE2","OT");
					var msgArr = msg_1.split("#");
					var checkin_time = getLabel("eOT.CheckedOutDateTime.Label","OT");
					var systemdatetime =getLabel("Common.SystemDateTime.label","Common");
					alert(msgArr[0]+ checkin_time  +msgArr[1]+ systemdatetime +msgArr[2]);
					obj.value="";;
					
				}		   */







	var date = obj.value;
	var locale = document.getElementById("locale").value;	

	if(isValidDate(obj) && date.length > 0 )
	{
		if(!isBeforeNow(date,'DMYHM',locale))							    
		{												    
			alert(getMessage("XH1010",'XH'));
			obj.value = "";
			obj.focus();
			return false;
		}									   
		else
		{
			if(!compareDates())
			{
				obj.value = "";
				obj.focus();
				return false;
			}
		}
	}	
}															    
function compareDates()
{
	locale = document.getElementById("locale").value;
	msg_dt1 = document.forms[0].fromDate.value;
	msg_dt2 = document.forms[0].toDate.value;

	if(msg_dt1.length > 0 && msg_dt2.length > 0)
	{
		if(!isBefore(msg_dt1,msg_dt2,'DMYHM',locale))
		{
			alert(getMessage("XH1009",'XH'));
			return false;
		}
		else
		{
			return true;
		}
	}
	else
	{
		return true;
	}
} 
  function isValidDate(obj)
{	
	var date = obj.value;
	var locale = document.getElementById("locale").value;

	if(date.length > 0 )		 
	{
		if(!validDate(date,'DMYHM',locale))
		{
			var msg = getMessage("INVALID_VALUE",'COMMON');
			msg = msg.replace('#','Date Format');
			alert(msg);

			obj.value = "";
			obj.focus();
			return false;
		}
		else
		{
			return true;
		}
	}							 		   
} 

function showExcelProcess(flag,obj,action)
{		

	 var flagch=true;
	if(action=="purge")
	{

			var i=window.confirm(getMessage("DELETE_RECORD","common"));
			if(i==true)
			{
				flagch=true;
			}											    
			else
			{
			    flagch=false;							 			  
			}
	}													    
	 if(flagch)
	{
		this.document.forms[0].method = 'POST';					    
		this.document.forms[0].target="";					 
		this.document.forms[0].action='../../servlet/eXH.AdminOraJobExcepToXLServlet?flag='+flag+'&proc_id='+obj+'&action='+action+'&rule=I';  
		this.document.forms[0].submit();   
	}
}										       
																	  

function searchErrors()
{			
	//alert(this.document.forms[0].proc_date.value);			
	var fromDate = this.document.forms[0].fromDate.value;
	var toDate = this.document.forms[0].toDate.value;
	var proc_id = this.document.forms[0].proc_id.value;
	var facilityID = this.document.forms[0].facilityID.value;		    

	var xmlDoc = "";
	var xmlHttp = new XMLHttpRequest();
	var xmlStr = "<root><SEARCH ";
	xmlStr += " fromDate=\""+fromDate+"\"";
	xmlStr += " toDate=\""+toDate+"\"";
	xmlStr += " proc_id=\""+proc_id+"\"";
	xmlStr += " facilityID=\""+facilityID+"\"";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","AdministerDataProcessGetServerErr.jsp",false);
	xmlHttp.send(xmlDoc);																   

//	alert(xmlHttp.responseText);
	eval(xmlHttp.responseText);		
}

</script>

</HEAD>

<title><fmt:message key="eXH.ServerError.Label" bundle="${xh_labels}"/></title>
<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%	
	String locale = ((String)session.getAttribute("LOCALE"));		  
	String procID = XHDBAdapter.checkNull((String)request.getParameter("proc_id"));
	String errMsg = XHDBAdapter.checkNull((String)request.getParameter("err_msg"));

	//System.out.println("(AdministerDataProcessServErr.jsp) procID : "+procID);
	//System.out.println("(AdministerDataProcessServErr.jsp) errMsg : "+errMsg);		  
%>
<form name="AdminDataProc_ServErr" id="AdminDataProc_ServErr" target='' method='post'> 

<table cellspacing=0 cellpadding=3 width='100%' align=center>
				 
<tr>
	<td class=label><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
	<td class=fields><input type='text' id='facilityID' name='facilityID' id='facilityID' value=''/>					 
	<td class=label><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>	
	<td class=fields>
	<input type=text id='fromDate' name=fromDate  size=19 maxlength=19 onBlur='isAfterCurrDate(this);'> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromDate',null,'hh:mm')" >
	 	 
	<td class=label><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>			 
	<td class=fields>
	<input type=text id='toDate' name= toDate  size=19 maxlength=19 onBlur='isAfterCurrDate(this);'> 
				<input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('toDate',null,'hh:mm')">
	
 		  
	<td colspan=2><input class="button" type="button" name='search' id='search' value='<fmt:message key="eXH.WriteToXls.Label" bundle="${xh_labels}"/>' onClick="showExcelProcess('Y','<%=procID%>','result');"></td>
	<td colspan=2><input class="button" type="button" name='search' id='search' value='<fmt:message key="eXH.Purge.Label" bundle="${xh_labels}"/>' onClick="showExcelProcess('Y','<%=procID%>','purge');"></td>
</tr>									  
<!-- 																					  
<tr>									   													   
	<td colspan=7>
		<textarea name=err_msg rows=22 cols=120 readOnly><%=errMsg%></textarea>	
	</td>
</tr>

 -->
</table>
<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>'>
<input TYPE="hidden" name="proc_id" id="proc_id" value="<%=procID%>">
<input TYPE="hidden" name="rule" id="rule" value="I">
</form>
</BODY>
</HTML> 

