<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
//String locale = ((String)session.getAttribute("LOCALE"));
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

function searchEligibilityCheck()
{    	
	parent.resultFrame.location.href='../../eCommon/html/blank.html';

	var customer_group=document.forms[0].customer_group_id.value;
	var customer_id = document.forms[0].customer_id.value;
	var patient_id = document.forms[0].patient_id.value;
	var patient_class_episode=document.forms[0].patient_class_episode.value;
	var episode_id=document.forms[0].episode_name.value;

    var bill_from = document.forms[0].from_bill_id.value
	var bill_to = document.forms[0].to_bill_id.value
	
	var admission_from_dt =  document.forms[0].admission_from_dt.value;
	var admission_to_dt =  document.forms[0].admission_to_dt.value;
	var event_type = ""; //document.forms[0].type.value;
    var eligibility_status_type = "";//document.forms[0].eligibility_status_type.value;

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
		var params = "customer_group="+customer_group+"&customer_id="+customer_id+"&patient_id="+patient_id+"&patient_class_episode="+patient_class_episode+"&episode_id="+episode_id+"&admission_from_dt="+admission_from_dt+"&admission_to_dt="+admission_to_dt+"&bill_from="+bill_from+"&bill_to="+bill_to+"&event_type="+event_type+"&eligibility_status_type="+eligibility_status_type;


		parent.frames[2].document.location.href="../../eXH/jsp/MediMembershipClaimsResult.jsp?"+params;
	
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

function searchCustomerId(){
   
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
			var customer_grp_id = this.document.forms[0].customer_group_id.value;
            var target=this.document.forms[0].customer_desc;
            var customer_id=this.document.forms[0].customer_id; 
			var dest_code=this.document.forms[0].dest_code; 

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


function searchPayerGroupId(){
			var tdesc="";
            var tcode="";
			clearSearchResult();
			
			var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Payer Group";			
            var target=this.document.forms[0].customer_group_id;
            var customer_group_desc=this.document.forms[0].customer_group_desc;

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

function searchEpisodeId(){
			var tdesc="";
            var tcode="";

			clearSearchResult();

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= "Episode Id";			
            var target=this.document.forms[0].episode_name;
			var episode_id=this.document.forms[0].episode_id;
        
            var patient_class = this.document.forms[0].patient_class_episode.value;
			var patient_id = this.document.forms[0].patient_id.value;


			sql="SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE  UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) ";

            if(patient_id!="" && patient_id!=null)
	        {
				sql= sql + " AND PATIENT_ID='"+patient_id+"'" ;
			}

			if(patient_class!="" && patient_class!=null)
	        {
				sql= sql + " AND PATIENT_CLASS='"+patient_class+"'" ;
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
	var target=this.document.forms[0].from_bill_id;
    var from_bill_desc=this.document.forms[0].from_bill_desc;
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
	var target=this.document.forms[0].to_bill_id;
    var to_bill_desc=this.document.forms[0].to_bill_desc;
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

function getTransStatus(){
	var dataElements="";
    var response = "";
	var event = "";
	var type = "";
	var response ="";
	var responseTxt="";
	var select = "";
	var l_type_code = "";
	var	l_type_desc = "";
	event="ECL";
	type="";//document.getElementById("type").value;
	if(type == ""){
		selectbox = document.getElementById("eligibility_status_type");
		selectbox.options.length = 0;	 
		addOption(selectbox,"----Select----","");
		}
	else
	{
	   var selectbox = document.getElementById("eligibility_status_type");
	   selectbox.options.length = 0;
	   addOption(selectbox,"----Select----","");
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

function addOption(selectbox,text,value){
     optn = document.createElement("OPTION");
     optn.text = text;
     optn.value = value;
     selectbox.options.add(optn);
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
String admission_from_dt = "";
String admission_to_dt = "";
String status_code = "",status_desc = "";
String str = "";
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
java.util.Date da = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(da);
cal.add(Calendar.MONTH, -1);
da = cal.getTime();
admission_from_dt =dateFormat.format(da) ;
admission_to_dt = dateFormat.format(new java.util.Date()) ;

ResultSet rs=null;
Statement pstmt = null;
String qry="";
ArrayList arrRow = new ArrayList();
String pid_length="10";
Connection conn = null;
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));		
	%>


<form name="PatientMembershipMaster" id="PatientMembershipMaster" method="post">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>

	<td class=label width="10%"><fmt:message key="eXH.PAYER_GROUP.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" id="customer_group_desc" name="customer_group_desc" id="customer_group_desc">
		<INPUT TYPE="text" id="customer_group_id" name="customer_group_id" id="customer_group_id"   value="" onBlur="searchPayerGroupId();">
	
		<input class="BUTTON" type="button"  name=customerGroupIDSearch id=customerGroupIDSearch value='?' onClick="searchPayerGroupId()">
	</td>
	
	<td class=label width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" id="customer_id" name="customer_id" id="customer_id">
		<input type="hidden" id="dest_code" name="dest_code" id="dest_code">
		<INPUT TYPE="text" id="customer_desc" name="customer_desc" id="customer_desc" onBlur='searchCustomerId()'  value="">
		<input class="BUTTON" type="button"  name=customerIDSearch id=customerIDSearch value='?' onClick="searchCustomerId()">
	</td>

</tr>
<tr>

	<td class=label width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<INPUT TYPE="text" id="patient_id" name="patient_id" id="patient_id" align="left" size='20' maxlength='<%=pid_length%>'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);">
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
			<input type="hidden" id="episode_id" name="episode_id" id="episode_id">
			<INPUT TYPE="text" id="episode_name" name="episode_name" id="episode_name" onBlur='searchEpisodeId()' >
			<input class="BUTTON" type="button"  name=episodeIDSearch id="episodeIDSearch" value='?' onClick="searchEpisodeId()"/>
	</td>
 </tr>
<tr>
	<td class=label width="15%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=admission_from_dt id="admission_from_dt" value="<%=admission_from_dt %>" size=11> <input type='image' id="admission_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admission_from_dt','dd/mm/y');"  >
			<input type=text name=admission_to_dt id="admission_to_dt" value="<%=admission_to_dt %>" size=11> <input type='image' id="admission_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admission_to_dt','dd/mm/y');">
		</td>			
	<td class=label width="5%"><fmt:message key="eBL.BILL_DOC_NO.label" bundle="${bl_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='fields'>
	    <input type="hidden" id="from_bill_desc" name="from_bill_desc" id="from_bill_desc">
		<INPUT TYPE="text" id="from_bill_id" name="from_bill_id" id="from_bill_id" align="left" size='20'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" style="width: 100px">
		<input type="button" value="?" class="button" name='from_bill_search' id='from_bill_search' onClick="getFromBillID()">
		 <fmt:message key="Common.to.label" bundle="${common_labels}"/>
		<input type="hidden" id="to_bill_desc" name="to_bill_desc" id="to_bill_desc">
        <INPUT TYPE="text" id="to_bill_id" name="to_bill_id" id="to_bill_id" align="left" size='20'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" style="width: 110px">
		<input type="button" value="?" class="button" name='to_bill_search' id='to_bill_search' onClick="getToBillID()">
	</td>
</tr>
<!--
<tr>
	<td class=label width="10%"><fmt:message key="Common.Event.label" bundle="${common_labels}"/><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<select name="type" id="type" id="type" onChange="getTransStatus();" style="width: 150px">
			<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
			<option value='CLA'><fmt:message key="eXH.CLATrans.label" bundle="${xh_labels}"/></option>
			<option value='CLE'><fmt:message key="eXH.CLETrans.label" bundle="${xh_labels}"/></option>
			<option value='REV'><fmt:message key="eXH.REVTrans.label" bundle="${xh_labels}"/></option>
			<option value='EOC'><fmt:message key="eXH.EOCTrans.label" bundle="${xh_labels}"/></option>
		</select>
	</td>
	<td class=label width="10%"><fmt:message key="Common.Event.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>
	<td class='fields'>
	<select name='eligibility_status_type' id='eligibility_status_type'  id='eligibility_status_type' style="width: 150px"><option value='' >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%=str%>
	</select>
	</td>
	<td>
	</td>
</tr>
-->
</table>

<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<input class='BUTTON' type="button"  ID="search" name=search value='Search' onClick="searchEligibilityCheck()">
		<input class='BUTTON' type="button"  ID="clear" name=clear value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MediMembershipClaimsMaster.jsp:Exception) "+e1);
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

