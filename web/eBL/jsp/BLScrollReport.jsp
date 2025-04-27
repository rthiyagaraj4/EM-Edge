<!DOCTYPE html>
<%/*
Sr No              Version                Incident              SCF/CRF                        Developer Name
1                 									            MOHE-CRF-0050.2-US-006 			       Palani Narayanan
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
 <base target="_self">
<%
	HttpSession httpSession = request.getSession(false);
	String facility_id = "";
	String locale			= (String)session.getAttribute("LOCALE");
	String login_user	= (String) session.getValue( "login_user" ) ;

	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
	}
	catch(Exception eX)
	{
		eX.printStackTrace();
		out.println("Error= "+eX);
	}
%>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript' src='../js/BLAmount.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src='../js/PkgDef.js'></script> 
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/BLScrollReport.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<script>
var facility_id = '<%=facility_id%>';

function disable(bool,err_mess)
{
	if(err_mess=="")
	{
		if (bool == true)
		{
			var process_label=getLabel("Common.processing.label","common");
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+process_label;
		}
	}
	else
	{
		parent.messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err_mess;
	}
}

function funSubmitReport()
{
	var operator_id = document.forms[0].operator_id.value;
	var cashcounter_code = document.forms[0].cashcounter_code.value;
	var login_time = document.forms[0].login_time.value;
	var logout_time = document.forms[0].logout_time.value;	

	var log_rep_success_mes=getMessage("BL9323","BL");
	document.forms[0].log_rep_success_mes.value=log_rep_success_mes;

	if ((operator_id == null) || (operator_id=='') || (operator_id == ' '))
	{
		alert(getMessage("BL9784","BL"));
		return false;
	}
	if ((cashcounter_code == null) || (cashcounter_code=='') || (cashcounter_code == ' '))
	{
		alert(getMessage("BL9538","BL"));
		return false;
	}
	if ((login_time == null) || (login_time=='') || (login_time == ' '))
	{
		alert(getMessage("BL9785","BL"));
		return false;
	}
	if ((logout_time == null) || (logout_time=='') || (logout_time == ' '))
	{
		return;
	}
	document.forms[0].submit();
	disable(true);
}

function funOperator(clng_evnt)
{
	if(clng_evnt == 'B')
	{
		if( document.forms[0].operator_id.value == "")
		{	
			return;
		}
	}

	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;

		var title=getLabel("eBL.UserIds.label","BL"); //17-11-2020
		title=encodeURIComponent(title);
	var column_sizes = escape("100%,");               
	var cashcounteruser=getLabel("eBL.CASH_COUNTER_USER.label","BL");
	cashcounteruser=encodeURIComponent(cashcounteruser);

	var column_descriptions = cashcounteruser+","; 
	var sql = escape("select distinct CASH_COUNTER_USER_ID CNTR_USER "+
				" from bl_cash_counter_slmt_hdr where "+
				" OPERATING_FACILITY_ID = '"+facility_id+"' "+
				" AND LOGOUT_DATE_TIME IS NOT NULL ");
	
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].operator_id.value)+"&srch_by_clmn_index=2"+"&col_show_hide=Y";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
			document.forms[0].operator_id.value = arr[0];
		}
		else		
		{
			document.forms[0].operator_id.value = '';
		}
	}
}
//22-02-2021   FUCTION STATRTS HERE
	function funCashCounter(clng_evnt)
	{	
		if(clng_evnt == 'B')
		{
			if( document.forms[0].cashcounter_code.value == '')
			{	
				document.forms[0].cashcounter_desc.value ='';
				return;
			}
		}
		if(clng_evnt == 'C') //23-02-2021
		{	
				document.forms[0].cashcounter_code.value = '';
				document.forms[0].cashcounter_desc.value = '';
		}
	
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var title=getLabel("eBL.CASH_COUNTER_CODE.label","BL");  
		title=encodeURIComponent(title);
		var column_sizes = escape("70%,30%");               
		var cashcntrcode=getLabel("eBL.CASH_COUNTER_CODE.label","BL");
		cashcntrcode=encodeURIComponent(cashcntrcode);
		var desc=getLabel("Common.description.label","common");
		desc=encodeURIComponent(desc);
		var column_descriptions = desc+","+cashcntrcode;
		var locale=document.forms[0].locale.value;
		//Modified V201201-PalaniNarayanan/MOHE-CRF-50.2 US-O6
		var code=document.forms[0].cashcounter_code.value;
		var sql="";                                            
		if(code==null || code =="" || code==undefined || code=='undefined')
		{
			sql = escape("select short_desc CNTR_DESC, "+
			"  cash_counter_code CNTR_CODE from bl_cash_counter_lang_vw where language_id='"+locale+"' and "+
			" operating_facility_id ='"+facility_id+"'");
		}
		else{
			sql = escape("select short_desc CNTR_DESC, "+
			"  cash_counter_code CNTR_CODE from bl_cash_counter_lang_vw where language_id='"+locale+"' and "+
			" operating_facility_id ='"+facility_id+"' and "+
			" cash_counter_code ='"+code+"'");
		}
	var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&target="+encodeURIComponent(document.forms[0].cashcounter_code.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";

	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!='')
	{
		var retVal=unescape(retVal);
		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");
				//Modified V201201-PalaniNarayanan/MOHE-CRF-50.2 US-O6
				document.forms[0].cashcounter_desc.value = arr[0];
				document.forms[0].cashcounter_code.value = arr[1];
			}
			else
			{
				document.forms[0].cashcounter_code.value = '';
				document.forms[0].cashcounter_desc.value = '';
			}
		}
	}
//22-02-2021   FUCTION ENDS HERE
	function funLogTime(clng_evnt)
	{

	if(clng_evnt == 'B')
	{
		if( document.forms[0].login_time.value == '')
		{	
			document.forms[0].login_time.value = '';
			document.forms[0].logout_time.value = '';
			return;
		}
	}

	var dialogTop			= "40";
	var dialogHeight		= "10" ;
	var dialogWidth			= "40" ;
	var features			="dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
	var arguments			= "" ;
	var cashcounter_code	= document.forms[0].cashcounter_code.value;
	var operator_id = document.forms[0].operator_id.value;
	var locale = document.forms[0].locale.value;

	if ((cashcounter_code == null) ||(cashcounter_code=='')|| (cashcounter_code ==' ') )
	{
		cashcounter_code = '';
	}
	if ((operator_id == null) ||(operator_id=='')|| (operator_id==' ') )
	{
		operator_id = '';
	}

		var title=getLabel("eBL.CASH_COUNTER_LOGIN_DATE_TIME.label","BL");  //17-11-2020
	title=encodeURIComponent(title);

	var column_sizes = escape("35%,35%,10%,20%");               
	var logintime=getLabel("eBL.LOGIN_TIME.label","BL");
	logintime=encodeURIComponent(logintime);
	var logouttime=getLabel("eBL.LOGOUT_TIME.label","BL");
	logouttime=encodeURIComponent(logouttime);
	var cashcntr=getLabel("eBL.CASH_COUNTER.label","BL");
	cashcntr=encodeURIComponent(cashcntr);
	var user=getLabel("Common.user.label","common");
	user=encodeURIComponent(user);

	var column_descriptions =logintime+","+logouttime+","+cashcntr+","+user; 
	var sql = escape("select to_date(TO_CHAR(login_date_time,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') login_format_date,"+
	 "    to_date(TO_CHAR(logout_date_time,'DD/MM/YYYY HH24:MI:SS'),'DD/MM/YYYY HH24:MI:SS') logout_format_date, "+
	 " CASH_COUNTER_CODE CASH_COUNTER_ID, "+
	 " CASH_COUNTER_USER_ID USER_CODE "+
	 " from bl_cash_counter_slmt_hdr where  "+
	 " CASH_COUNTER_CODE like NVL('"+cashcounter_code+"',CASH_COUNTER_CODE) AND "+
	 " CASH_COUNTER_USER_ID like NVL('"+operator_id+"',CASH_COUNTER_USER_ID) AND  "+
	 " OPERATING_FACILITY_ID = '"+facility_id+"' "+
	 " AND LOGOUT_DATE_TIME IS NOT NULL ");

	
	var message = '';
	if (!(cashcounter_code == ''))
	{
		message = getLabel("eBL.CASH_COUNTER_IS_FILTERED_FOR.label","BL")+" "+cashcounter_code;
		message = encodeURIComponent(message);
	}
		//Added one parameter V201201-PalaniNarayanan/MOHE-CRF-50.2 US-O6
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].login_time.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYY"+"&called_for="+"CASH_COUNTER_LOGINTIME";
	retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);
	var arr=new Array();

	if(retVal == null) retVal='';
	if (retVal != null || retVal!="")
	{
		var retVal=unescape(retVal);

		if(retVal != null && retVal.length>0)
		{
			arr=retVal.split("^~^");

			document.forms[0].cashcounter_code.value = arr[2];
			document.forms[0].operator_id.value = arr[3];
			var login_date_time = arr[0];
			var logout_date_time = arr[1];
			if(locale !='en')
			{
				login_date_time=convertDate(login_date_time,'DMYHMS','en',locale);
				logout_date_time=convertDate(logout_date_time,'DMYHMS','en',locale);
			}
			document.forms[0].login_time.value = login_date_time;
			document.forms[0].logout_time.value = logout_date_time;
		}
		else
		{
			document.forms[0].login_time.value = '';
			document.forms[0].logout_time.value = '';
		}
	}
}
</script>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 	onSelect="codeArrestThruSelect();">
		<form name='report_form' id='report_form' action='../../servlet/eBL.BLCashierReportServlet' method='post' target='dummyFrame'>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>

		<tr>
				<td width="50%" class='label' ><fmt:message key="eBL.OperaterID.label" bundle="${bl_labels}"/></td>
			    <td width="50%" class="fields">
					
					<input type='text' name='operator_id' id='operator_id' size='20' maxlength='50' value="<%=login_user%>" onBlur="funOperator('B')">
					<input type='button' value='?' class='button' onClick="funOperator('C')">
				<!--
					<input type='text' name='operator_id' id='operator_id' size='20' maxlength='50' value='' style="text-transform:uppercase" ><img src='../../eCommon/images/mandatory.gif'>
					-->
				</td>
		</tr>
  		<tr>
				<td width="50%" class='label' ><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
				<td width="50%" class='fields' >
				<!--
					<input type='text' name='cashcounter_code' id='cashcounter_code' size='15' maxlength='40' value='' onBlur="funCashCounter('B')">					
					removed function 23-02-2021 for non-linked incident 11542
					-->
					<input type='text' name='cashcounter_code' id='cashcounter_code' size='15' maxlength='40' value='' onBlur="funCashCounter('B')">
					<input type='text' name='cashcounter_desc' id='cashcounter_desc' size='30' maxlength='40' value=''>	
					<input type='button' value='?' class='button' onClick="funCashCounter('C')">
					
					<!--
					<b id='cashcounter_desc'></b>
					-->
				</td>
		</tr>
		<tr>
				<td width="50%" class='label' ><fmt:message key="eBL.LOGIN_DATE_TIME.label" bundle="${bl_labels}"/></td>
			    <td class="fields" >
					<input type='text' name='login_time' id='login_time' size='21' maxlength='50' value='' >
							<!--
					<img onclick="return showCalendar('login_time','dd/mm/yyyy','hh:mm:ss');" src="../../eCommon/images/CommonCalendar.gif">
						-->
					<input type='button' value='?' class='button' onClick="funLogTime('C')"><img src='../../eCommon/images/mandatory.gif'>
					
				</td>
		</tr>
		<tr>
				<td width="50%" class='label' ><fmt:message key="eBL.LOGOUT_DATE_TIME.label" bundle="${bl_labels}"/></td>
			    <td width="50%" class="fields"  >
<!--	modified V201201-PalaniNarayanan/MOHE-CRF-50		-->	
				<input type='text' name='logout_time' id='logout_time' size='21' maxlength='50' value="" readonly >
							<!--
						<img onclick="return showCalendar('logout_time','dd/mm/yyyy','hh:mm:ss');" src="../../eCommon/images/CommonCalendar.gif">
							-->
					</td>
		</tr>
	
		<tr>
				<td width="50%">&nbsp;</td>
				<td width="50%">&nbsp;</td>
		</tr>
</table>
<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
<input type= hidden name="facility_id" id="facility_id"  value='<%=facility_id%>'>
<input type= hidden name="log_rep_success_mes" id="log_rep_success_mes"  value=''>
<input type= hidden name="login_user" id="login_user"  value='<%=login_user%>'>

</form>
</body>
</html>

