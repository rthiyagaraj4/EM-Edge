<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../OP/js/messages.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>

<script language="javascript">

function Report()
{
	var event =  document.getElementById("event").value;
	var report_id =  document.getElementById("p_report_id").value;
	if(!(event !=null && event != "" && event != " " && report_id !=null && report_id != "" && report_id != " " )){
		alert("APP-XH0068 Please Select the Report option.");
		return;
	}
	parent.resultFrame.location.href='../../eCommon/html/blank.html';
	parent.f_query_add_mod.PAYER_EXCEPTION_REPORT_FORM.action = '../../eCommon/jsp/report_options.jsp';
	parent.f_query_add_mod.PAYER_EXCEPTION_REPORT_FORM.target="messageFrame";
	parent.f_query_add_mod.PAYER_EXCEPTION_REPORT_FORM.submit();
	//document.PAYER_CHECK_QUERY_FORM.submit();
}


function clearSearch()
{
   
   parent.f_query_add_mod.location.reload();
   parent.resultFrame.location.href='../../eCommon/html/blank.html';	
}


function clearSearchResult()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}

function getCustID(){

	var tdesc="";
	var tcode="";

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= "From.";			
	var target=this.document.getElementById("from_cust_id");
	var from_cust_desc=this.document.getElementById("from_cust_desc");
	sql = " SELECT CUST_CODE code, SHORT_NAME description FROM AR_CUSTOMER WHERE UPPER(CUST_CODE) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?) ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	//          argumentArray[4] = "2,1";
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		from_cust_desc.value=arr[0];
	}
	else{
		target.value=tdesc;
		from_cust_desc.value=tcode;
	}
}
function getBillID(){

	var tdesc="";
	var tcode="";

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= "From.";			
	var target=this.document.forms[0].bill_id;
	var from_bill_desc=this.document.forms[0].bill_desc;
	sql="SELECT BLNG_GRP_ID code,BLNG_GRP_ID description FROM bl_bill_hdr WHERE  UPPER(DOC_TYPE_CODE) LIKE UPPER(?) AND UPPER(DOC_NUM) LIKE UPPER(?) ORDER BY 1 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	//          argumentArray[4] = "2,1";
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		from_bill_desc.value=arr[0];
	}
	else{
		target.value=tdesc;
		from_bill_desc.value=tcode;
	}
}

function addOption(selectbox,text,value){
		optn = document.createElement("OPTION");
		optn.text = text;
		optn.value = value;
		selectbox.options.add(optn);
}
function popup(){

	var dataElements="";
	var response = "";
	var event = "";
	var type = "";
	var response ="";
	var responseTxt="";
	var select = "";
	var l_type_code = "";
	var	l_type_desc = "";
	var selectbox = "";
	event=document.getElementById("event").value;
	type="CLA";
	selectbox = document.getElementById("eligibility_status_type");
	selectbox.options.length = 0;	 
	addOption(selectbox,"------Select-------","");

	if(event == ""){
		alert("APP-XH0068 Please Select the Report option.");
		return;
	}
	else
	{
	if(event=="ECL") {
		document.getElementById("claim_from_dt").disabled = true;
		document.getElementById("claim_to_dt").disabled = true;
		document.getElementById("claim_from_dt_img").disabled = true;
		document.getElementById("claim_to_dt_img").disabled = true;
		document.getElementById("bill_desc").disabled = false;
		document.getElementById("bill_id").disabled = false;
		document.getElementById("bill_search").disabled = false;
		document.getElementById("p_report_id").value = "XFCLMEXC";
	}
	if(event=="ERA") {
		document.getElementById("claim_from_dt").disabled = false;
		document.getElementById("claim_to_dt").disabled = false;
		document.getElementById("claim_from_dt_img").disabled = false;
		document.getElementById("claim_to_dt_img").disabled = false;
		document.getElementById("bill_desc").disabled = true;
		document.getElementById("bill_id").disabled = true;
		document.getElementById("bill_search").disabled = true;
		document.getElementById("p_report_id").value = "XFERAEXC";
	}

	selectbox = document.getElementById("eligibility_status_type");
	selectbox.options.length = 0;
	addOption(selectbox,"------Select-------","");
	dataElements ="<EVENT>"+event+"$!^<TYPE>"+type+"$!^";
	response= getStatus(dataElements);
	responseTxt = response.split("$!^");

	for (i = 0; i <responseTxt.length-1; i++) {
		responseMsg=responseTxt[i].split("##");
		l_type_code=responseMsg[0];
		l_type_desc=responseMsg[1];
		addOption(selectbox,l_type_desc,l_type_code);
	}

	}

}
function getStatus(dataElements)
{
	var responseMsg="";
	var data1=true;
	$.ajax({
	url: '../../servlet/eXH.GetStatusServlet',
	type: 'POST',
	cache: false,

	data: {
		callType: 'ECLAIMS',
		paramString: dataElements
	},
	success: function (data1) {
		responseMsg = data1;
	},		
	dataType: 'text',
	async: false
	});

	return responseMsg;
} 
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%
String adm_from_dt = "";
String adm_to_dt = "";
String status_code = "",status_desc = "";
String str = "";
String p_module_id      = "XF" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;

SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
java.util.Date da = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(da);
cal.add(Calendar.MONTH, -1);
da = cal.getTime();
adm_from_dt = dateFormat.format(da) ;
adm_to_dt = dateFormat.format(new java.util.Date()) ;

String pid_length="10";
pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));

%>
<form name="PAYER_EXCEPTION_REPORT_FORM" id="PAYER_EXCEPTION_REPORT_FORM" method="get" action="">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>

	<td class=label width="10%"><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>

	<td class='fields'>

		<select id="event" style="width: 180px" onChange="popup();">
		<option value = ''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
		<option value = 'ECL'><fmt:message key="eXH.claimExpReport.label" bundle="${xh_labels}"/></option>
		<option value = 'ERA'><fmt:message key="eXH.ERAExpReport.label" bundle="${xh_labels}"/></option>
		</select>
	</td>

	<td class=label width="15%" colspan="2">&nbsp;</td>

</tr>
<tr>

	<td class=label width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>

	<td class='fields'>
		<input type="hidden" id="from_cust_desc" name="p_cust_code" id="p_cust_code">
		<INPUT TYPE="text" id="from_cust_id"  align="left" size='20'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" style="width: 120px">
		<input type="button" value="?" class="button"  onClick="getCustID()">
	</td>

	<td class=label width="15%"><fmt:message key="eXH.claimDate.label" bundle="${xh_labels}"/></td>

	<td class='fields'>
		<input type=text name="p_fr_claim_date" id="p_fr_claim_date" id="claim_from_dt" value="<%=adm_from_dt%>" size=11  > <input type='image' id="claim_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('claim_from_dt','dd/mm/y');"  >
		<input type=text name="p_to_claim_date" id="p_to_claim_date" id="claim_to_dt" value="<%=adm_to_dt %>" size=11  > <input type='image' id="claim_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('claim_to_dt','dd/mm/y');">
	</td>

</tr>

<tr>
	<td class=label width="10%"><fmt:message key="eBL.BillingGroupId.label" bundle="${bl_labels}"/></td>
	<td class='fields'>
		<input type="hidden" id="bill_desc" name="p_blng_grp_id" id="p_blng_grp_id">
		<INPUT TYPE="text" id="bill_id" align="left" size='20'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" style="width: 120px"/>
		<input type="button" value="?" class="button" id= "bill_search" onClick="getBillID()">
	</td>

	<td class=label width="15%"><fmt:message key="eBL.BILL_DATE.label" bundle="${bl_labels}"/></td>

	<td class='fields'>
		<input type=text name="p_fr_bill_date" id="p_fr_bill_date" id="bill_from_dt" value="<%=adm_from_dt%>" size=11  > <input type='image' id="bill_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('bill_from_dt','dd/mm/y');"  >
		<input type=text name="p_to_bill_date" id="p_to_bill_date" id="bill_to_dt" value="<%=adm_to_dt %>" size=11  > <input type='image' id="bill_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('bill_to_dt','dd/mm/y');">
	</td>	
 </tr>

 <tr>
	<td class=label width="10%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td>
		<select name="p_status" id="p_status" id="eligibility_status_type" style="width: 180px">
		<option value = ''><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	<td class=label width="10%" colspan="2"></td>
 </tr>
</table>

<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<input class='BUTTON' type="button"  ID="search" value='Report' onClick="Report()">
		<input class='BUTTON' type="button"  ID="clear" value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
<input type="hidden" name="p_cust_group_code" id="p_cust_group_code"       value="">
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id"   id="p_report_id"         value="">
<input type="hidden" name="p_language_id" id="p_language_id" id="p_language_id"         value="en">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
</fieldset>
</form>
</body>
</html>

