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

function Query()
{    	
	parent.resultFrame.location.href='../../eCommon/html/blank.html';

	var customer_group=document.getElementById("customer_group_id").value;
	var customer_id = document.getElementById("customer_id").value;
	var patient_id = document.getElementById("patient_id").value;
	var episode_type = document.getElementById("patient_class_episode").value;
	var episode_id=document.getElementById("episode_name").value;

    var bill_from = document.getElementById("from_bill_id").value
	var bill_to = document.getElementById("to_bill_id").value
	
	var trans_from_dt =  document.getElementById("trans_from_dt").value;
	var trans_to_dt =  document.getElementById("trans_to_dt").value;
	var event =  document.getElementById("event").value;
	var type =  document.getElementById("type").value;

    var eligibility_status_type = document.getElementById("eligibility_status_type").value;

	var patient_class_episode = "";
	if(episode_type == "O"){
        patient_class_episode ="OP";
	}
	if(episode_type == "I"){
        patient_class_episode ="IP";
	}
	if(episode_type == "E"){
        patient_class_episode ="EM";
	}
	if(episode_type == "D"){
        patient_class_episode ="DC";
	}

	//var patient_class_orderby = document.forms[0].patient_class_orderby.value;
	//var admType = document.getElementById("admission_type").value;

	/*if(!(patient_id != null && patient_id != "" && patient_id != " "))
	{ 
		alert("APP-XH0068 Patient ID Should not be Empty");
		document.forms[0].patient_id.focus();
		return;
	} 
	else if(!(customer_id != null && customer_id != "" && customer_id != " "))
	{ 
		alert("APP-XH0068 Payer Information should not be Empty");
		document.forms[0].customer_id.focus();
		return;
	} 

	
	/*var params= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&admission_from_dt="+admission_from_dt+"&admission_to_dt="+admission_to_dt+"&cust_id="+cust_id+"&eligibility_check="+eligibility_check+"&cust_group_code="+cust_group_code; 
  
	else 
	{
	*/	
		var params = "customer_group="+customer_group+"&customer_id="+customer_id+"&patient_id="+patient_id+"&patient_class_episode="+patient_class_episode+"&episode_id="+episode_id+"&trans_from_dt="+trans_from_dt+"&trans_to_dt="+trans_to_dt+"&bill_from="+bill_from+"&bill_to="+bill_to+"&eligibility_status_type="+eligibility_status_type+"&event_type="+event+"&check_type="+type;

		parent.resultFrame.document.location.href="../../eXH/jsp/MediMembershipQueryResult.jsp?"+params;
	
}
function Report(){

		var event = "";
		var checkBoxes = document.getElementsByName('checkbox');

		for(var i = 0; i < checkBoxes.length; i++)
		{
			if(checkBoxes[i].checked)
			{
				document.getElementById("p_line_level_reqd_yn").value = "Y";
			}
			else
			{
				document.getElementById("p_line_level_reqd_yn").value = "N";
			}
		}
		var event =  document.getElementById("event").value;
	    var report_id =  document.getElementById("p_report_id").value;
        if(!(event !=null && event != "" && event != " " && report_id !=null && report_id != "" && report_id != " " )){
            alert("APP-XH0068 Please Select the Transaction Type and Event.");
			return;
		}
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
		parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = '../../eCommon/jsp/report_options.jsp';
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="messageFrame";
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();
		//document.PAYER_CHECK_QUERY_FORM.submit();
   /* parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = '../../eXH/jsp/PatientMembershipReports.jsp';
	parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="f_query_add_mod";

	//parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="f_query_add_mod";
	parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();*/
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

function getPatID()
{					  
	var pat_id=PatientSearch('','','','','','','','','','VIEW');
	if( pat_id != null )						
		document.forms[0].patient_id.value = pat_id ;					
}

async function searchCustomerId(){
   
			var tdesc="";
            var tcode="";
			var tdestcode = "";

			clearSearchResult();

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit="Payer";	
			var customer_grp_id = this.document.getElementById("customer_group_id").value;
            var target=this.document.getElementById("customer_desc");
            var customer_id=this.document.getElementById("customer_id"); 
			var dest_code=this.document.getElementById("dest_code"); 

			sql="SELECT CUST_CODE code, SHORT_NAME description FROM AR_CUSTOMER WHERE UPPER(CUST_CODE) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?) ";

			if(customer_grp_id!="" && customer_grp_id!=null)
	        {
				sql= sql + " AND CUST_GROUP_CODE ='"+customer_grp_id+"'" ;
			}

			sql= sql + "  ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                customer_id.value=arr[0];
                target.value=arr[1];
            }
            else{
                target.value=tdesc;
                customer_id.value=tcode;
            }
			
}// End of searchCustomerId


async function searchPayerGroupId(){
			var tdesc="";
            var tcode="";

			clearSearchResult();
			
			var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Payer Group";			
            var target=this.document.getElementById("customer_group_id");
            var customer_group_desc=this.document.getElementById("customer_group_desc");

			sql="SELECT CUST_GROUP_CODE code, SHORT_DESC description FROM AR_CUST_GROUP WHERE UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;
            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                customer_group_desc.value=arr[1];
                target.value=arr[0];
            }
            else{
                target.value=tdesc;
                customer_group_desc.value=tcode;
            }

						
}// End of searchPayerGroupId

async function searchEpisodeId(){

			var tdesc="";
            var tcode="";

			clearSearchResult();

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Episode Id";			
            var target=document.getElementById("episode_name");
			var episode_id=document.getElementById("episode_id");
        
            var episode_type = this.document.getElementById("episode_type").value;
			var patient_class_episode = "";

			if(episode_type == "O"){
				patient_class_episode ="OP";
			}
			if(episode_type == "I"){
				patient_class_episode ="IP";
			}
			if(episode_type == "E"){
				patient_class_episode ="EM";
			}
			if(episode_type == "D"){
				patient_class_episode ="DC";
			}

			sql="SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE  UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) ";

			if(patient_class_episode!="" && patient_class_episode!=null)
	        {
				sql= sql + " AND PATIENT_CLASS='"+patient_class_episode+"'" ;
			}

 
			sql= sql + " ORDER BY 1 ";
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
                episode_id.value=arr[0];
				this.document.forms[0].p_visit_id.value = arr[0].substring(11,12);
				
            }
            else{
                target.value=tdesc;
                episode_id.value=tcode;
            }
			
}// End of searchEpisodeId

async function getFromBillID(){

	var tdesc="";
	var tcode="";

	clearSearchResult();

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= "From.";			
	var target=this.document.getElementById("from_bill_id");
    var from_bill_desc=this.document.getElementById("from_bill_desc");
	sql="SELECT DOC_TYPE_CODE code,DOC_NUM description FROM bl_bill_hdr WHERE  UPPER(DOC_TYPE_CODE) LIKE UPPER(?) AND UPPER(DOC_NUM) LIKE UPPER(?) ORDER BY 1 ";

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
async function getToBillID(){

	var tdesc="";
	var tcode="";

	clearSearchResult();

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= "To";			
	var target=this.document.getElementById("to_bill_id");
    var to_bill_desc=this.document.getElementById("to_bill_desc");
	sql="SELECT DOC_TYPE_CODE code,DOC_NUM description FROM bl_bill_hdr WHERE  UPPER(DOC_TYPE_CODE) LIKE UPPER(?) AND UPPER(DOC_NUM) LIKE UPPER(?) ORDER BY 1 ";

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
		to_bill_desc.value=arr[0];
	}
	else{
		target.value=tdesc;
		to_bill_desc.value=tcode;
	}
}

function selectStatus(){

	clearSearchResult();
	var type = document.getElementById("type").value;

	if(type == "" )
	{
		var selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;	 
		addOption(selectbox,"------Select-------","");
	}

	if(type == "IDC" || type == "FAM" || type == "UEC" || type == "IEC"){
		var selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;
		addOption(selectbox,"------Select-------","");
		addOption(selectbox,"Response Success","01");
		addOption(selectbox,"Response Rejected","02");
		addOption(selectbox,"Response Failed","03");
		addOption(selectbox,"Network Error","04");
	}
	
	if(type == "CLM" ){
		var selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;	 
		addOption(selectbox,"------Select-------","");
		addOption(selectbox,"Processed","Processed");
		addOption(selectbox,"Rejected","Rej");
		addOption(selectbox,"Duplicate ","Duplcate");
		addOption(selectbox,"Warning","Warning");
	}
	
	if(type == "REV" || type == "EOC")
	{
		var selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;
		addOption(selectbox,"------Select-------","");
		addOption(selectbox,"Authorised","Auth");
		addOption(selectbox,"Rejected","Rej");
	}
}
function popup(){
  var optn ="";
  var event=document.getElementById("event").value;
  var type="";
  var option="";
   if(event == ""){
	  var selectbox = document.getElementById("type");
	  selectbox.options.length = 0;
	  addOption(selectbox,"------Select-------","");
	  selectbox = document.getElementById("eligibility_status_type");
	  selectbox.options.length = 0;	 
	  addOption(selectbox,"------Select-------","");
   }
  if(event == "ELC"){
	 document.getElementById("p_report_id").value = "XFENCWES";
	 var selectbox = document.getElementById("eligibility_status_type");
	 selectbox.options.length = 0;	 
	 addOption(selectbox,"------Select-------","");
	 selectbox = document.getElementById("type");
	 selectbox.options.length = 0;
	 addOption(selectbox,"------Select-------","");
     addOption(selectbox,"ID Check","IDC");
	 addOption(selectbox,"FAM Check","FAM");
     addOption(selectbox,"UnInsured Eligiblity Check","UEC");
     addOption(selectbox,"Insured Eligiblity Check","IEC");

  }
  if(event == "ECL"){
	 document.getElementById("p_report_id").value = "XFECLWES";
	 var selectbox = document.getElementById("eligibility_status_type");
	 selectbox.options.length = 0;	 
     addOption(selectbox,"------Select-------","");
	 selectbox = document.getElementById("type");
     selectbox.options.length = 0;
	 addOption(selectbox,"------Select-------","");
     addOption(selectbox,"Claims Transactions","CLA");
	 addOption(selectbox,"Claims with End of Case Transactions","CLE");
	 addOption(selectbox,"Reversal Transactions","REV");
     addOption(selectbox,"EOC Transactions","EOC");
  }
}
function addOption(selectbox,text,value){
     optn = document.createElement("OPTION");
     optn.text = text;
     optn.value = value;
     selectbox.options.add(optn);
}
function popupType(){

	var dataElements="";
    var response = "";
	var event = "";
	var type = "";
	var response ="";
	var responseTxt="";
	var select = "";
	var l_type_code = "";
	var	l_type_desc = "";
	event=document.getElementById("event").value;
	type=document.getElementById("type").value;
	if(type == ""){
		selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;	 
		addOption(selectbox,"------Select-------","");
		}
	else
	{
	   var selectbox = document.getElementById("eligibility_status_type");
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

String trans_from_dt = "";
String trans_to_dt = "";
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
trans_from_dt =dateFormat.format(da) ;
trans_to_dt = dateFormat.format(new java.util.Date()) ;

String pid_length="10";
Connection conn = null;
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));		
	%>


<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="get" action="">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>

	<td class=label width="10%"><fmt:message key="eXH.PAYER_GROUP.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" id="customer_group_desc" >
		<INPUT TYPE="text" id="customer_group_id" name="p_cust_group_code" id="p_cust_group_code" onBlur='searchPayerGroupId()'  value="">
		<input class="BUTTON" type="button"  name=customerGroupIDSearch id=customerGroupIDSearch value='?' onClick="searchPayerGroupId()">
	</td>
	
	<td class=label width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" id="customer_id" >
		<input type="hidden" id="dest_code" >
		<INPUT TYPE="text" id="customer_desc" name="p_cust_code" id="p_cust_code" onBlur='searchCustomerId()'  value="">
		<input class="BUTTON" type="button"  name=customerIDSearch id=customerIDSearch value='?' onClick="searchCustomerId()">
	</td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr>

	<td class=label width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<INPUT TYPE="text" id="patient_id" name="p_patient_id" id="p_patient_id" align="left" size='20' maxlength='<%=pid_length%>'  value="" onBlur="ChangeUpperCase(this);" >
		<input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">

	</td>
	<td class=label width="10%"><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<select name="patient_class_episode" id="patient_class_episode" id="patient_class_episode" style="width: 100px">
			<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
			<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
			<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
		</select>
		</select>
			<input type="hidden" id="episode_id" >
			<INPUT TYPE="text" id="episode_name" name="p_episode_id" id="p_episode_id" onBlur='searchEpisodeId()' >
			<input class="BUTTON" type="button"  name=episodeIDSearch id="episodeIDSearch" value='?' onClick="searchEpisodeId()">
	</td>
	<td></td>
	<td></td>
	<td></td>
 </tr>
<tr>
	<td class=label width="15%"><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=p_fr_tran_date id="p_fr_tran_date" value="<%=trans_from_dt %>" size=11  > <input type='image' id="trans_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trans_from_dt','dd/mm/y');"  >
			<input type=text name=p_to_tran_date id="p_to_tran_date" value="<%=trans_to_dt %>" size=11  > <input type='image' id="trans_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('trans_to_dt','dd/mm/y');">
		</td>			
	<td class=label width="10%"><fmt:message key="eBL.BILL_DOC_NO.label" bundle="${bl_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'>
	    <input type="hidden" id="from_bill_desc" >
		<INPUT TYPE="text" id="from_bill_id"  align="left" size='20'  value="" style="width: 100px" onBlur='getFromBillID()' >
		<input type="button" value="?" class="button"  onClick="getFromBillID()">
		<fmt:message key="Common.to.label" bundle="${common_labels}"/>
		<input type="hidden" id="to_bill_desc" >
        <INPUT TYPE="text" id="to_bill_id"  align="left" size='20'  value=""  style="width: 110px" onBlur='getToBillID()'>
		<input type="button" value="?" class="button"  onClick="getToBillID()">
	</td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td class=label width="10%"><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<select  id="event" style="width: 150px" onChange="popup();">
				<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value = 'ELC'><fmt:message key="eXH.Eligiblitycheck.label" bundle="${xh_labels}"/></option>
				<option value = 'ECL'><fmt:message key="eXH.Claims.label" bundle="${xh_labels}"/></option>
		    </select>
			<fmt:message key="Common.Event.label" bundle="${common_labels}"/>
			<select id="type" name="p_trans_type" id="p_trans_type" style="width:170px" onChange="popupType();">
			<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
           </select>
		</select>
		</td>			
      <td class=label width="10%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	  <td class='fields'>
	    <select id='eligibility_status_type' name="p_trans_status" id="p_trans_status" style="width:150px">
		   <option value = ''>---- Select ----</option>
	    </select>
	</td>
	<td></td>
	<td></td>
	<td></td>
</tr>
<tr>
	<td class=label width="10%" >Show Item Details</td>
	<td><input type='checkbox' id='checkbox' value = 'N'> </td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	<td></td>
	<td></td>
	<td></td>
</tr>

</table>

<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<input class='BUTTON' type="button"  ID="query" name="query" id="query" value='Search' onClick="Query()">
		<input class='BUTTON' type="button"  ID="report" name="report" id="report" value='Report' onClick="Report()">
		<input class='BUTTON' type="button"  ID="clear" name=clear value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
<input type="hidden" name="p_visit_id" id="p_visit_id"          value="">
<input type="hidden" name="p_healthcare_transaction_ref" id="p_healthcare_transaction_ref" value="">
<input type="hidden" name="p_history_yn" id="p_history_yn"         value="N">
<input type="hidden" name="p_case_no" id="p_case_no"            value="">
<input type="hidden" name="p_with_out_eligibility_yn" id="p_with_out_eligibility_yn"         value="N">
<input type="hidden" name="p_with_out_claim_submission_yn" id="p_with_out_claim_submission_yn"         value="N">
<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%=p_facility_id%>">
<input type="hidden" name="p_line_level_reqd_yn" id="p_line_level_reqd_yn" id="p_line_level_reqd_yn"   value="N">
<input type="hidden" name="p_module_id" id="p_module_id"         value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"         value="">
<input type="hidden" name="p_language_id" id="p_language_id" id="p_language_id"         value="en">
<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MediMembershipQueryMaster.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>

</form>
</body>
</html>

