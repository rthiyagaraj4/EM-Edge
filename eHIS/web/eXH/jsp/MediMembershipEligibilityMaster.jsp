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

<script language="javascript">

function searchEligibilityCheck()
{    	
	parent.resultFrame.location.href='../../eCommon/html/blank.html';

	var patient_id = document.forms[0].patient_id.value;
	var customer_group=document.forms[0].customer_group_id.value;
    var customer_id = document.forms[0].customer_id.value;
	var patient_class_episode=document.forms[0].patient_class_episode.value;
	var episode_id=document.forms[0].episode_name.value;
	var encounter_id=document.forms[0].encounter_id.value;
	var episode_type=document.forms[0].patient_class_episode.value;
	var admType = document.getElementById("admission_type").value;

	var customer_id = document.forms[0].customer_id.value;
	
	var admission_from_dt =  document.forms[0].admission_from_dt.value;
	var admission_to_dt =  document.forms[0].admission_to_dt.value;
	//var patient_class_orderby = document.forms[0].patient_class_orderby.value;
    var eligibility_status_type = document.forms[0].eligibility_status_type.value;

	if(!(patient_id != null && patient_id != "" && patient_id != " "))
	{ 
		alert("APP-XH0068 Patient ID Should not be Empty");
		document.forms[0].patient_id.focus();
		return;
	} 
	/*else if(!(customer_id != null && customer_id != "" && customer_id != " "))
	{ 
		alert("APP-XH0068 Payer Information should not be Empty");
		document.forms[0].customer_id.focus();
		return;
	} */

	
	/*var params= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&admission_from_dt="+admission_from_dt+"&admission_to_dt="+admission_to_dt+"&cust_id="+cust_id+"&eligibility_check="+eligibility_check+"&cust_group_code="+cust_group_code; */
  
	
		var params = "patient_id="+patient_id+"&admission_type="+admType+"&customer_group="+customer_group+"&customer_id="+customer_id+"&patient_class_episode="+patient_class_episode+"&episode_id="+episode_id+"&admission_from_dt="+admission_from_dt+"&admission_to_dt="+admission_to_dt+"&eligibility_status_type="+eligibility_status_type+"&episode_type="+episode_type+"&encounter_id="+encounter_id;

		parent.frames[2].document.location.href="../../eXH/jsp/MediMembershipEligibilityResult.jsp?"+params;
	
	
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
			
}// End of searchEncounterId


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
            var target=this.document.forms[0].episode_name;
			var encounter_id=this.document.forms[0].encounter_id;
        
            var patient_class = this.document.forms[0].patient_class_episode.value;
			var patient_id = this.document.forms[0].patient_id.value;

			sql="SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE DISCHARGE_DATE_TIME is null and UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) ";

			if(patient_class!="" && patient_class!=null)
	        {
				sql= sql + " AND PATIENT_CLASS='"+patient_class+"'" 
			}

			if(patient_class!="" && patient_class!=null)
	        {
				sql= sql + " AND PATIENT_ID='"+patient_id+"'" 
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
                encounter_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                encounter_id.value=tcode;
            }
}


function checkEligibilityTransaction()
{
	document.getElementById("claim_trns").disabled = false; 
	document.getElementById("eoc_trns").disabled = false; 
	document.getElementById("reversal_trns").disabled = false; 
}

function isAfterCurrDate(obj)
{
	var date = obj.value;
//	var locale = document.getElementById("locale").value;	
	var locale = "en";
	if(isValidDate(obj) && date.length > 0 )
	{
		if(!isBeforeNow(date,'DMY',locale))
		{
			alert("APP-XH0010 Date cannot be greater than System Date ");
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

function validDate(date, format, locale){
	var dateFlag=true;
	var dateArr;
	var dateArr1;
	if(format=="DMY"){
		dateArr=date.split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="DMYHM"){
		dateArr1=date.split(" ");
		dateArr=(dateArr1[0]).split("/");
		if(dateArr[2]==0){
			dateFlag=false;
		}
	}else if(format=="YY"){
		if(date==0){
			dateFlag=false;
		}
	}else if(format=="MY"){
		dateArr=date.split("/");
		if(dateArr[1]==0){
			dateFlag=false;
		}
	}
	if(dateFlag){
		var xhr =  getXHR();
		var url = "../../eCommon/jsp/DateUtils.jsp?methodName=validDate&format="+format+"&locale="+locale+"&date="+date;
		xhr.open("POST", url, false);
		xhr.setRequestHeader("Content-Type","text/plain")
		xhr.send("");
		var xmlText = xhr.responseText
		if (TrimStr(xmlText) == "true"){
			dateFlag=true;
		}else{
			dateFlag=false;
		}
	}
	return dateFlag;
}

function isValidDate(obj)
{	
	var date = obj.value;
//	var locale = document.getElementById("locale").value;
	var locale = "en";

	if(date.length > 0 )
	{
		if(!validDate(date,'DMY',locale))
		{
			var msg = getMessage("INVALID_VALUE",'COMMON');
			msg = msg.replace('#','Date Format');

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

function enableAdmissionFields()
{
	clearSearchResult();

	var admType = document.getElementById("admission_type").value;

	if(admType == "1")
	{
		//document.getElementById("patient_class_orderby").disabled = true; 
		document.getElementById("admission_from_dt").disabled = true;
		document.getElementById("admission_from_dt_img").disabled = true;
		document.getElementById("admission_to_dt").disabled = true;
		document.getElementById("admission_to_dt_img").disabled = true;
		document.getElementById("episode_name").disabled = true; 
		document.getElementById("episodeIDSearch").disabled = true;
		
		document.getElementById("patient_class_episode").disabled = true;   
	}
	else
	{
		//document.getElementById("patient_class_orderby").disabled = false; 
		document.getElementById("admission_from_dt").disabled = false;
		document.getElementById("admission_from_dt_img").disabled = false;
		document.getElementById("admission_to_dt").disabled = false;
		document.getElementById("admission_to_dt_img").disabled = false;
		document.getElementById("episode_name").disabled = false; 
		document.getElementById("episodeIDSearch").disabled = false;

		document.getElementById("patient_class_episode").disabled = false;   
	}
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%

String preadmissonDisabled = "disabled";

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
//String ID="";
//String dat="";
//String en="";
Connection conn = null;

	/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

	pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));

	try
	{ 
		conn = ConnectionManager.getConnection(request);
					
	    qry= "SELECT STATUS_CODE,STATUS_DESC FROM XH_TRANS_STATUS WHERE APPLICATION_ID ='ECLAIMS' AND TRANS_EVENT ='ELC' AND TRANS_TYPE ='IDC' AND ACTIVE_FLAG = 'Y'";

		pstmt = conn.createStatement();
		rs = pstmt.executeQuery(qry);
		//System.out.println("Result Set size..."+rs);

        while(rs.next()) {
            status_code=rs.getString("STATUS_CODE");
            status_desc=rs.getString("STATUS_DESC");
            str+="<option value='"+status_code+"'>"+status_desc;
        }
		//System.out.println("After while..."+str);
	%>


<form name="PatientMembershipMaster" id="PatientMembershipMaster" method="post">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>

	<td class=label width="10%"><fmt:message key="eXH.PAYER_GROUP.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" id="customer_group_desc" name="customer_group_desc" id="customer_group_desc">
		<INPUT TYPE="text" id="customer_group_id" name="customer_group_id" id="customer_group_id" onBlur='searchPayerGroupId()'  value="">
		<input class="BUTTON" type="button"  name=customerGroupIDSearch id=customerGroupIDSearch value='?' onClick="searchPayerGroupId()">
	</td>
	
	<td class=label width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/> </td>
	<td class='fields'>
	    <input type="hidden" id="customer_id" name="customer_id" id="customer_id">
		<input type="hidden" id="dest_code" name="dest_code" id="dest_code">
		<INPUT TYPE="text" id="customer_desc" name="customer_desc" id="customer_desc" onBlur='searchCustomerId()'  value="">
		<input class="BUTTON" type="button"  name=customerIDSearch id=customerIDSearch value='?' onClick="searchCustomerId()">
	</td>
	<td></td>	
</tr>
<tr>

<td class=label width="10%" valign=center><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
	<td class='fields' >
		<select name="admission_type" id="admission_type" id="admission_type" style="width: 150px" onchange="enableAdmissionFields()">			
			<option value = '1'><fmt:message key="Common.preadmission.label" bundle="${common_labels}"/></option>
			<option value = '2'><fmt:message key="Common.admission.label" bundle="${common_labels}"/></option>
		</select>
	</td>

	<td class=label width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<INPUT TYPE="text" id="patient_id" name="patient_id" id="patient_id" align="left" size='20' maxlength='<%=pid_length%>'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);" required >
		<input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
		<img align='center' src='../../eCommon/images/mandatory.gif'></img>

	</td>
	<td></td>	
</tr>
<tr>

<td class=label width="10%"><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name="patient_class_episode" id="patient_class_episode" id="patient_class_episode" style="width: 120px" <%=preadmissonDisabled %> >
		<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
		<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
		<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
		<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
	</select>
	    <input type="hidden" id="encounter_id" name="encounter_id" id="encounter_id">
		<INPUT TYPE="text" id="episode_name" name="episode_name" id="episode_name" onBlur='searchEpisodeId()' <%=preadmissonDisabled %>>
		<input class="BUTTON" type="button"  name=episodeIDSearch id="episodeIDSearch" value='?' onClick="searchEpisodeId()" <%=preadmissonDisabled %>>
	</td>

	<td class=label width="10%"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<input type=text name=admission_from_dt id="admission_from_dt" value="<%=admission_from_dt %>" size=11  <%=preadmissonDisabled %> > <input type='image' id="admission_from_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admission_from_dt','dd/mm/y');" <%=preadmissonDisabled %> >
		<input type=text name=admission_to_dt id="admission_to_dt" value="<%=admission_to_dt %>" size=11 <%=preadmissonDisabled %> > <input type='image' id="admission_to_dt_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admission_to_dt','dd/mm/y');" <%=preadmissonDisabled %>>
	</td>	
	<td></td>	
</tr>
<tr>
<!--
<td class=label width="10%">Order By</td>
<td class='fields'> 
		<select name="patient_class_orderby" id="patient_class_orderby" id="patient_class_orderby" style="width: 150px" <%=preadmissonDisabled %>>
			<option value = ''>---- Select ----</option>
			<option value="Patient_Id">Patient Id</option>
			<option value="Patient_Class">Patient Class</option>
		</select>
		<!-- <img src='../../eCommon/images/mandatory.gif'> 
	</td>
-->

<td class=label width="10%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	<select name='eligibility_status_type' id='eligibility_status_type' style="width: 150px"><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<%=str%>
	</select>
	</td>
	<td></td>
	<td></td>
	<td></td>

</tr>

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
			 out.println("(MediMembershipEligibilityMaster.jsp:Exception) "+e1);
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

