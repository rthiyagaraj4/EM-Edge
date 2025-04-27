<!DOCTYPE html>
<html>
<%@ page import="eXH.XHDBAdapter" import="java.text.SimpleDateFormat" import="java.util.Date"%>
<%@ page import="java.sql.*, java.util.*,java.net.*, java.text.*, java.net.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  

<%@ page contentType="text/html;charset=UTF-8" %>


<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<head>


<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<title> Patient Eligibility Check </title>

<script>
var err_code="";
var response_str="";
function eligibilityCheck()
{
	var responseMsg = "";

	var patientId = document.forms[0].patient_id.value;

	var encounterId = document.forms[0].encounterId.value;

	var episodeId = document.forms[0].episodeId.value;

	var patientName = document.forms[0].patient_name.value;
	var sex = document.forms[0].sex.value;
	var nationalId = document.forms[0].nationalId.value;

	var patientClass = document.forms[0].patient_cls_episode.value;
	var visitAdmissionDate = document.forms[0].visitAdmissionDt.value;
	var locationType = document.forms[0].locationType.value;

	var serviceCode = document.forms[0].serviceCode.value;
	var specialityCode = document.forms[0].speciality_code.value;
	var custCode = document.forms[0].custCode.value;					

	var firstName = document.forms[0].firstName.value;
	var secondName = document.forms[0].secondName.value;
	var initial = document.forms[0].initial.value;
	var familyName = document.forms[0].familyName.value;
	var dob = document.forms[0].dob.value;
	var episode_type=document.forms[0].episode_type.value;
	var visit_id=document.forms[0].visit_id.value;
	
	var checkType = document.forms[0].checkType.value;
	var membership_number = document.getElementById("membership_number").value;
	var wca_num = document.getElementById("p_wca_num").value ;
	var dependant_num = document.getElementById("p_dependant_num").value;
	var dependant_relation = document.getElementById("p_dependant_relation").value; 
	var dest_code = document.getElementById("destCode").value; 

	var m_surname = document.getElementById("p_surname").value; 
	var m_intial = document.getElementById("p_intial").value; 

	var AddedByFacilityId = document.getElementById("AddedByFacilityId").value ;
	var AddedByUserId = document.getElementById("AddedByUserId").value;
	var WorkstationNo = document.getElementById("WorkstationNo").value; 
    document.forms[0].episodeId.value =episodeId;
	document.forms[0].episode_type.value =episode_type;

	var blng_grp_id=document.forms[0].blng_grp_id.value;
	var admission_type = document.forms[0].admission_type.value;
	var settlement_ind=document.forms[0].settlement_ind.value;

	if(!(membership_number != null && membership_number != "" && membership_number != " ") && checkType != "IDC" && checkType != "UEC")
	{ 
		alert("APP-XH0070 Membership Number Should not be Empty");
		document.getElementById("membership_number").focus();
		return;
	} 

	if(!(m_surname != null && m_surname != "" && m_surname != " ") && checkType != "IDC" && checkType != "UEC")
	{ 
		alert("APP-XH0070 Membership Surname Should not be Empty");
		document.getElementById("p_surname").focus();
		return;
	} 

	if(!(dest_code != null && dest_code != "" && dest_code != " "))
	{ 
		alert("APP-XH0070 Destination Code for the Customer has not been configured, Please configure and try again");
		return;
	} 
	

	dataElements = "<PATIENT_ID>"+patientId+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<EPISODE_TYPE>"+episode_type+"$!^<REQUEST>"+checkType+"$!^<REQUEST_TYPE>ELCREQ$!^<MEMBER_ID>"+membership_number+"$!^<DEPD_CODE>"+dependant_num+"$!^<DEPD_RELN>"+dependant_relation+"$!^<CUST_CD>"+custCode+"$!^<DEST_CD>"+dest_code+"$!^<USER>"+AddedByUserId+"$!^<FACILITY_ID>"+AddedByFacilityId+"$!^<TRANS_ID>$!^<WCA_NUM>"+wca_num+"$!^<WS_NO>"+WorkstationNo+"$!^<EPISODE_ID>"+episodeId+"$!^<VISIT_ID>"+visit_id+"$!^<SURNAME>"+m_surname+"$!^<INITIAL>"+m_intial+"$!^<BLNG_GRP_ID>"+blng_grp_id+"$!^<SETTLEMENT_IND>"+settlement_ind+"$!^<ADMISSION_TYPE>"+admission_type+"$!^";

	//dataElements = "<PATIENT_ID>"+patientId+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<NATIONAL_ID>"+nationalId+"$!^<PATIENT_NAME>"+patientName+"$!^<PATIENT_DOB>"+dob+"$!^<SEX>"+sex+"$!^<PATIENT_CLASS>"+patientClass+"$!^<VISIT_ADMISSION_DATE>"+visitAdmissionDate+"$!^<LOCATION_TYPE>"+locationType+"$!^<SERVICE_CODE>"+serviceCode+"$!^<SPECIALITY_CODE>"+specialityCode+"$!^<CUST_CODE>"+custCode+"$!^<FIRST_NAME>"+firstName+"$!^<SECOND_NAME>"+secondName+"$!^<INITIAL>"+initial+"$!^<FAMILY_NAME>"+familyName+"$!^<CHECKTYPE>"+checkType+"$!^<MEMBERSHIP_NUMBER>"+membership_number+"$!^<WCA_NUMBER>"+wca_num+"$!^<DEPENDENT_NUMBER>"+dependant_num+"$!^<DEPENDENT_RELATION>"+dependant_relation+"$!^";

	var responseMsg = eligibilityCheckTransaction(dataElements,"ECLAIMSEC")
	ParseCheckResponse(responseMsg);

	var trans_id = document.forms[0].transID.value;
}

function fetchResponse()
{							
	var patientId = document.forms[0].patient_id.value;

	var encounterId = document.forms[0].encounterId.value;

	var patientName = document.forms[0].patient_name.value;
	var sex = document.forms[0].sex.value;
	var nationalId = document.forms[0].nationalId.value;

	var patientClass = document.forms[0].patient_cls_episode.value;
	var visitAdmissionDate = document.forms[0].visitAdmissionDt.value;
	var locationType = document.forms[0].locationType.value;

	var serviceCode = document.forms[0].serviceCode.value;
	var specialityCode = document.forms[0].speciality_code.value;
	var custCode = document.forms[0].custCode.value;					

	var firstName = document.forms[0].firstName.value;
	var secondName = document.forms[0].secondName.value;
	var initial = document.forms[0].initial.value;
	var familyName = document.forms[0].familyName.value;
	var dob = document.forms[0].dob.value;
	var m_surname = document.getElementById("p_surname").value; 
	var m_intial = document.getElementById("p_intial").value; 

	
	var checkType = document.forms[0].checkType.value;
	var membership_number = document.getElementById("membership_number").value;
	var wca_num = document.getElementById("p_wca_num").value ;
	var dependant_num = document.getElementById("p_dependant_num").value;
	var dependant_relation = document.getElementById("p_dependant_relation").value; 
	var dest_code = document.getElementById("destCode").value; 
	var trans_id = document.getElementById("transID").value; 

	var AddedByFacilityId = document.getElementById("AddedByFacilityId").value ;
	var AddedByUserId = document.getElementById("AddedByUserId").value;
	var WorkstationNo = document.getElementById("WorkstationNo").value;

	var episode_type=document.forms[0].episode_type.value;
	var episodeId=document.forms[0].episodeId.value;
	var custCode=document.forms[0].custCode.value;
	var AddedByFacilityId = document.getElementById("AddedByFacilityId").value ;

	var visit_id=document.forms[0].visit_id.value;
	document.forms[0].episodeId.value =episodeId;
	document.forms[0].episode_type.value =episode_type;

	var blng_grp_id=document.forms[0].blng_grp_id.value;
	var settlement_ind=document.forms[0].settlement_ind.value;
	/*

	var l_episode_type = "";
	if (episode_type == "OP") {
		l_episode_type = "O";
	}
	if (episode_type == "EM") {
		l_episode_type = "E";
	}
	if (episode_type == "IP") {
		l_episode_type = "I";
	}
	if (episode_type == "DC") {
		l_episode_type = "D";
	}
	if (episode_type == "") {
		l_episode_type = "X";
	}

	*/



	if(!(membership_number != null && membership_number != "" && membership_number != " ") && checkType != "IDC" && checkType != "UEC")
	{ 
		alert("APP-XH0070 Membership Number Should not be Empty");
		document.getElementById("membership_number").focus();
		return;
	} 
	
	if(!(m_surname != null && m_surname != "" && m_surname != " ") && checkType != "IDC" && checkType != "UEC")
	{ 
		alert("APP-XH0070 Membership Surname Should not be Empty");
		document.getElementById("p_surname").focus();
		return;
	}  
		

	dataElements = "<PATIENT_ID>"+patientId+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<EPISODE_TYPE>"+episode_type+"$!^<REQUEST>"+checkType+"$!^<REQUEST_TYPE>ELCRES$!^<MEMBER_ID>"+membership_number+"$!^<DEPD_CODE>"+dependant_num+"$!^<DEPD_RELN>"+dependant_relation+"$!^<CUST_CD>"+custCode+"$!^<DEST_CD>"+dest_code+"$!^<USER>"+AddedByUserId+"$!^<FACILITY_ID>"+AddedByFacilityId+"$!^<TRANS_ID>"+trans_id+"$!^<WCA_NUM>"+wca_num+"$!^<WS_NO>"+WorkstationNo+"$!^<EPISODE_ID>"+episodeId+"$!^<VISIT_ID>"+visit_id+"$!^<SURNAME>"+m_surname+"$!^<INITIAL>"+m_intial+"$!^<BLNG_GRP_ID>"+blng_grp_id+"$!^<SETTLEMENT_IND>"+settlement_ind+"$!^";

	//dataElements = "<PATIENT_ID>"+patientId+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<NATIONAL_ID>"+nationalId+"$!^<PATIENT_NAME>"+patientName+"$!^<PATIENT_DOB>"+dob+"$!^<SEX>"+sex+"$!^<PATIENT_CLASS>"+patientClass+"$!^<VISIT_ADMISSION_DATE>"+visitAdmissionDate+"$!^<LOCATION_TYPE>"+locationType+"$!^<SERVICE_CODE>"+serviceCode+"$!^<SPECIALITY_CODE>"+specialityCode+"$!^<CUST_CODE>"+custCode+"$!^<FIRST_NAME>"+firstName+"$!^<SECOND_NAME>"+secondName+"$!^<INITIAL>"+initial+"$!^<FAMILY_NAME>"+familyName+"$!^<CHECKTYPE>"+checkType+"$!^<MEMBERSHIP_NUMBER>"+membership_number+"$!^<WCA_NUMBER>"+wca_num+"$!^<DEPENDENT_NUMBER>"+dependant_num+"$!^<DEPENDENT_RELATION>"+dependant_relation+"$!^";

	//var responseMsg = eligibilityCheckTransaction(dataElements);
	var responseMsg = eligibilityCheckTransaction(dataElements,"ECLAIMSEC")
	ParseCheckResponse(responseMsg);
	return responseMsg;
	
}
function ParseCheckResponse(responseMsg){
	var responseData = "";
	var warnData = "";
	var warning_data= "";
	var warning_response= "";
	var checkType = document.forms[0].checkType.value;
	var patientId = document.forms[0].patient_id.value;
	var custCode = document.forms[0].custCode.value;
	var memshipno = "";

	document.getElementById('Response').innerHTML = "";
	document.getElementById('Warning').innerHTML = "";
	document.getElementById('dispayWarning').style.display = 'none';
	document.getElementById('comparePatientData').style.display = 'none';

	document.getElementById('update_auth_patientDetail').disabled = true;
	document.getElementById('update_auth').disabled = true;

	responseData = responseMsg.split("$!^");

	if (responseData.length > 0)
	{
		document.forms[0].transID.value = responseData[1];

		if (responseData[0] == "S")
		{
			if (responseData[9].length>0)
					document.getElementById("membership_number").value = responseData[9];

				if (responseData[9].length>0)
					memshipno = responseData[9];
				else
					memshipno = document.getElementById("membership_number").value;

			if(!(responseData[8] !="A"))
			{
				document.getElementById("eligibility_trns").disabled = true;

				if(checkType == "IEC")
				{
					document.getElementById('dispayWarning').style.display = 'block';
					document.getElementById('comparePatientData').style.display = 'none';
					trans_id=responseData[1];
					 warnData = EligibilityTrans("<PATIENT_ID>"+patientId+"$!^<TRANS_ID>"+responseData[1]+"$!^<STATUS>"+responseData[8]+"$!^","ECLAIMSWARN");	
					if(warnData != null && warnData != "" && warnData != " "){
						document.getElementById('Warning').innerHTML = warnData;  
					}
					document.getElementById('update_auth').disabled = true;
				}
				else if(checkType == "UEC"){

					document.getElementById('dispayWarning').style.display = 'none';
					document.forms[0].transID.value = responseData[1];
					response_str=responseData[5];
					var dataElements = "<MEMBERSHIP_NUMBER>"+patientId+"$!^<TRANS_ID>"+responseData[1]+"$!^<PATIENT_ID>"+patientId+"$!^<STATUS>"+responseData[8]+"$!^";
					var memdata = EligibilityTrans(dataElements,"ECLAIMSEMPDTL");
					if(memdata != null && memdata != "" && memdata != " ")
					{
						document.getElementById('Response').innerHTML = memdata;
						document.getElementById('comparePatientData').style.display = 'block';
					}
					
					document.getElementById('update_auth_patientDetail').disabled = true;
					document.getElementById('update_auth').disabled = true;
				}
				else
				{
					document.getElementById('dispayWarning').style.display = 'none';
					document.forms[0].transID.value = responseData[1];
					response_str=responseData[5];
					var memdata = EligibilityTrans("<MEMBERSHIP_NUMBER>"+memshipno+"$!^<CUSTCODE>"+custCode+"$!^","ECLAIMSMEMDTL");
					if(memdata != null && memdata != "" && memdata != " ")
					{
						document.getElementById('Response').innerHTML = memdata+""+response_str;
					}
					else
					{
						document.getElementById('Response').innerHTML = response_str ;
					}
					warnData = EligibilityTrans("<PATIENT_ID>"+patientId+"$!^<TRANS_ID>"+responseData[1]+"$!^<STATUS>"+responseData[8]+"$!^","ECLAIMSWARN");
					if(warnData.length>0){
                          document.getElementById('Warning').innerHTML = warnData;
						  document.getElementById('dispayWarning').style.display = 'block';
					}
					document.getElementById('comparePatientData').style.display = 'block';
					document.getElementById('update_auth_patientDetail').disabled = false;
					document.getElementById('update_auth').disabled = true;
				}
				document.getElementById("auth_number").value =  responseData[7];
				document.getElementById("claims_number").value = responseData[3];
				document.getElementById("response_type").value = responseData[4];
			}
			if(!(responseData[8] !="R"))
			{
				document.getElementById('comparePatientData').style.display = 'none';
                
				trans_id=responseData[1];
				warnData = EligibilityTrans("<PATIENT_ID>"+patientId+"$!^<TRANS_ID>"+responseData[1]+"$!^<STATUS>"+responseData[8]+"$!^","ECLAIMSWARN");
				if(warnData != null && warnData != "" && warnData != " "){
				    document.getElementById('dispayWarning').style.display = 'block';
					document.getElementById('Warning').innerHTML = warnData;  
				}
				document.getElementById('update_auth').disabled = true;
				document.getElementById('update_auth_patientDetail').disabled = true;

				document.getElementById("auth_number").value =  responseData[7];
				document.getElementById("claims_number").value = responseData[3];
				document.getElementById("response_type").value = responseData[4];

			}
			
			if(!(responseData[8] !="F")){
				document.getElementById('dispayWarning').style.display = 'none';
				warnData = failedResponse(responseMsg);
	            if(warnData != null && warnData != "" && warnData != " "){
				   document.getElementById('comparePatientData').style.display = 'block';
                   document.getElementById('Response').innerHTML = warnData;
				}
				document.getElementById('update_auth').disabled = true;
				document.getElementById('update_auth_patientDetail').disabled = true;

				document.getElementById("auth_number").value =  "";
				document.getElementById("claims_number").value = "";
				document.getElementById("response_type").value = responseData[11];
			}
		}
		else {
			
			if(responseData[3] != null && responseData[3]!= "" && responseData[3] != " "){
			alert("APP-XH0070 "+responseData[3]);
			}
			if(responseData[3] == "Error in reading File - No Response File"){
                document.getElementById("fetch_response_elgi").disabled = false;
			}
			else {
				alert("APP-XH0070 Error Occured.");
			}
		}
	}
	else{
		alert("APP-XH0070 No Response File");
	}
}

function Update(update_type)
{
	var response ="";
	var responseData = "";
	var existingData = "";
	var dataElements ="";
	var checkedValue = "";

	var auth_number =document.getElementById("auth_number").value ;
	var claims_number = document.getElementById("claims_number").value;
	var response_type = document.getElementById("response_type").value;
    var warning_code = "";
	var warning_code_desc ="";
	var membership_number = document.getElementById("membership_number").value;
	var wca_num = document.getElementById("p_wca_num").value ;
	var membership_surname = document.getElementById("mem_surname").value;
	var membership_initial = document.getElementById("mem_intial").value ;
	var dependant_num = document.getElementById("p_dependant_num").value;
	var dependant_relation = document.getElementById("p_dependant_relation").value; 

	var checkType=document.forms[0].checkType.value;
	var patientId = document.forms[0].patient_id.value;
    var transId = document.forms[0].transID.value ;

    var admission_type=document.forms[0].admission_type.value;
    var episode_type=document.forms[0].episode_type.value;
	var episodeId=document.forms[0].episodeId.value;
	var custCode=document.forms[0].custCode.value;
	var AddedByFacilityId = document.getElementById("AddedByFacilityId").value ;
	var AddedByUserId = document.getElementById("AddedByUserId").value;
	var WorkstationNo = document.getElementById("WorkstationNo").value; 

	var encounterId=document.forms[0].encounterId.value;
	var visit_id=document.forms[0].visit_id.value;

	var blng_grp_id=document.forms[0].blng_grp_id.value;
	var settlement_ind=document.forms[0].settlement_ind.value;
   
	/*

	var l_episode_type = "";
	if (episode_type == "OP") {
		l_episode_type = "O";
	}
	if (episode_type == "EM") {
		l_episode_type = "E";
	}
	if (episode_type == "IP") {
		l_episode_type = "I";
	}
	if (episode_type == "DC") {
		l_episode_type = "D";
	}

	*/

	if(update_type == "2"){
		var i=0;
		var j=0;
		var mem_details = "";
        var checkBoxes = document.getElementsByName('checkbox');

		for(var i = 0; i < checkBoxes.length; i++)
		{
			if(checkBoxes[i].checked)
			{
				checkedValue = checkBoxes[i].value;

				var dep_cd = checkedValue;
				var surname = document.getElementById("Surname"+dep_cd).innerHTML;
				var firstname = document.getElementById("Firstname"+dep_cd).innerHTML;
				var initial = document.getElementById("Initial"+dep_cd).innerHTML;
				var national_id = document.getElementById("national_id"+dep_cd).innerHTML;
				var dob = document.getElementById("dob"+dep_cd).innerHTML;
				var gender = document.getElementById("gender"+dep_cd).innerHTML;
				var status = document.getElementById("status"+dep_cd).innerHTML;
				var scheme_name = document.getElementById("scheme_name"+dep_cd).innerHTML;
				var scheme_date = document.getElementById("scheme_date"+dep_cd).innerHTML;
				var row="";
				row += dep_cd+"##";
				row += dob+"##";
				row += national_id+"##";
				row += surname+"##";
				row += firstname+"##";
				row += initial+"##";
				row += gender+"##";
				row += status+"##";
				row += scheme_name+"##";
				row += scheme_date;
				if(j==0){
                    mem_details = row;
				}
				else{
					mem_details +="@@"+row ;
				}

				j++;
			 }
	   } 

	    if(j<=0)
		{
			alert("APP-XH0070 Please select at least one Member.");
			return;
		}
		
		var preData = "";

	   dataElements = "<REQUEST>"+checkType+"$!^<REQUEST_TYPE>ELCUPD$!^<UPDATE_TYPE>"+update_type+"$!^<FAMILY_NAME>"+surname+"$!^<FIRST_NAME>"+firstname+"$!^<NAME_SUFFIX>"+initial+"$!^<NATIONAL_ID>"+national_id+"$!^<DATE_OF_BIRTH>"+dob+"$!^<SEX>"+gender+"$!^<PATIENT_ID>"+patientId+"$!^<TRANS_ID>"+transId+"$!^<PREVIOUS_DATA>"+preData+"$!^<AUTHORIZATION_NUM>"+auth_number+"$!^<CLAIMS_NUMBER>"+claims_number+"$!^<RESPONSE_TYPE>"+response_type+"$!^<WARNING_CODE>"+warning_code+"$!^<ADMISSION_TYPE>"+admission_type+"$!^<EPISODE_ID>"+episodeId+"$!^<CUST_CODE>"+custCode+"$!^<FACILITY_ID>"+AddedByFacilityId+"$!^<EPISODE_TYPE>"+episode_type+"$!^<MEMBERSHIP_NUMBER>"+membership_number+"$!^<DEPENDENT_NUMBER>"+dependant_num+"$!^<WCA_NUMBER>"+wca_num+"$!^<DEPENDENT_RELATION>"+dependant_relation+"$!^<USER>"+AddedByUserId+"$!^<WS_NO>"+WorkstationNo+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<VISIT_ID>"+visit_id+"$!^<MEM_SURNAME>"+membership_surname+"$!^<MEM_INITIAL>"+membership_initial+"$!^<MEM_DETAILS>"+mem_details+"$!^<BLNG_GRP_ID>"+blng_grp_id+"$!^<SETTLEMENT_IND>"+settlement_ind+"$!^";

	}
	if(update_type == "1"){

		dataElements = "<REQUEST>"+checkType+"$!^<REQUEST_TYPE>ELCUPD$!^<UPDATE_TYPE>"+update_type+"$!^<CLAIMS_NUMBER>"+claims_number+"$!^<RESPONSE_TYPE>"+response_type+"$!^<WARNING_CODE>"+warning_code+"$!^<WARNING_DESC>"+warning_code_desc+"$!^<AUTHORIZATION_NUM>"+auth_number+"$!^<TRANS_ID>"+transId+"$!^<PATIENT_ID>"+patientId+"$!^<ADMISSION_TYPE>"+admission_type+"$!^<EPISODE_ID>"+episodeId+"$!^<CUST_CODE>"+custCode+"$!^<FACILITY_ID>"+AddedByFacilityId+"$!^<EPISODE_TYPE>"+episode_type+"$!^<MEMBERSHIP_NUMBER>"+membership_number+"$!^<DEPENDENT_NUMBER>"+dependant_num+"$!^<WCA_NUMBER>"+wca_num+"$!^<DEPENDENT_RELATION>"+dependant_relation+"$!^<USER>"+AddedByUserId+"$!^<WS_NO>"+WorkstationNo+"$!^<ENCOUNTER_ID>"+encounterId+"$!^<VISIT_ID>"+visit_id+"$!^<MEM_SURNAME>"+membership_surname+"$!^<MEM_INITIAL>"+membership_initial+"$!^<BLNG_GRP_ID>"+blng_grp_id+"$!^<SETTLEMENT_IND>"+settlement_ind+"$!^";
	}

	//response = UpadtePatientDetails(dataElements);
    response = eligibilityCheckTransaction(dataElements,"ECLAIMSUPD");
	responseData = response.split("$!^");
	if(responseData[0]=="S"){
		alert("APP-XH0070 Details Updated Successfully");
		if(update_type == "2"){

			//var memdata = CheckForMemberShip("<MEMBERSHIP_NUMBER>"+membership_number+"$!^<CUSTCODE>"+custCode+"$!^");
			var memdata = EligibilityTrans("<MEMBERSHIP_NUMBER>"+membership_number+"$!^<CUSTCODE>"+custCode+"$!^","ECLAIMSMEMDTL");
			if(memdata != null && memdata != "" && memdata != " ")
			{
				document.getElementById('Response').innerHTML = memdata;
			}
		}
		window.close();
		
	}
	else
	{
		alert("APP-XH0071 "+responseData[1]);
	}	   
	//window.close();
}

function cancel()
{
	window.close();
}

function reset()
{
  document.forms[0].reset();
}

function changeScreenSize() {        
        window.resizeTo(screen.width-1000,screen.height-1000)   
    }
function selectDR(){
    
	var dependant_relation=document.getElementById("p_dependant_relation").value;

	for(var i = 0;i < document.getElementById("p_dependant_relation").length;i++){
    if(document.getElementById("p_dependant_relation").options[i].value == dependant_relation){
             document.getElementById("p_dependant_relation").selectedIndex = i;
			 break;
      }
	}
}
function failedResponse(responseMsg){
	var responseTxt = "";
	var warning_response = "";
	var error_code = [];
	var error_desc = [];
	responseTxt = responseMsg.split("$!^");
	
	warning_response = "<table border=\"1\" align=\"center\" width=\"100%\" height=\"100%\" id=\"ResponseTable\"><tr><td class=\"columnheader\" colspan=\"4\">Failed File Details</td></tr>";
	warning_response += "<tr><td class=\"columnheader\" >PC Number</td><td class=\"columnheader\"  >Workstation Number</td><td class=\"columnheader\" >Msg Format</td><td class=\"columnheader\" >Error Count</td></tr>";
	warning_response +="<tr ><td id=\"DeptCode\">"+responseTxt[3]+"</td>";
	warning_response +="<td id=\"Firstname\">"+responseTxt[4]+"</td>";
	warning_response +="<td id=\"Surname\">"+responseTxt[5]+"</td>";
	warning_response +="<td id=\"Initial\">"+responseTxt[6]+"</td></tr>";
	warning_response += "<tr><td class=\"columnheader\" colspan=\"4\">Error Details</td></tr>";
	warning_response += "<tr><td class=\"columnheader\" colspan=\"2\">Error Code</td><td class=\"columnheader\"  colspan=\"2\">Error Desc</td></tr>";
	error_code=responseTxt[7].split("##");
	error_desc=responseTxt[10].split("##");
	for (i = 0; i <error_code.length-1; i++) {
		warning_response +="<tr ><td id=\"ErrorCode\" colspan=\"2\" >"+error_code[i]+"</td>";
		warning_response +="<td id=\"ErrorDesc\" colspan=\"2\" >"+error_desc[i]+"</td></tr>";
	}
	warning_response +="</table>";

    return warning_response;
}
function EligibilityTrans(dataElements,calltype){
	//alert(calltype);
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.GetStatusServlet',
		type: 'POST',
		cache: false,
		
		data: {
				callType: calltype,
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
function eligibilityCheckTransaction(dataElements,calltype)
{
	//alert(calltype);
    var responseMsg="";
	var data1=true;
	$.ajax({
		url: '../../servlet/eXH.InvokeMedikreditApplication',
		type: 'POST',
		cache: false,
		
		data: {
				callType: calltype,
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
</head>


<body>

<%

		Connection connMedikredit = null;
		PreparedStatement pstmtMedikredit = null;
		ResultSet rsMedikredit = null;

		/* var params= "title="+title+"&pname="+patient_name+"&pid="+patient_id+"&pcepisode="+pat_cls_episode+"&epid="+episode_id+"&pdob="+pat_dob+"&nid="+national_id+"&sex="+sex+"&vadmitdt="+visit_adm_dt_time+"&locType="+locationType+"&loccd="+locationCode+"&fcid="+facilityId+"&fname="+firstName+"&sname="+secondName+"&initial="+initial+"&memno="+membership_no+"&wca="+wca_no+"&depNum="+dependant_number+"&depRel="+dependant_relationship;  */

		String loginfacility = (String) session.getValue("facility_id");
		String user_id	= (String)session.getValue("login_user") ;
		Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		String AddedAtWsNo     =  p.getProperty("client_ip_address");

		System.out.println(loginfacility + " ::: "+ user_id + " ::: "+ AddedAtWsNo );

		String patient_name = XHDBAdapter.checkNull(request.getParameter("pname"));    
		String patient_id = XHDBAdapter.checkNull(request.getParameter("pid"));
		String encounterId = XHDBAdapter.checkNull(request.getParameter("encounterId")); 
		String patient_cls_episode = XHDBAdapter.checkNull(request.getParameter("pcepisode"));  
		String episodeId = XHDBAdapter.checkNull(request.getParameter("epid"));  
		//String nursing_unit_code = XHDBAdapter.checkNull(request.getParameter("nuc"));
		String dob = XHDBAdapter.checkNull(request.getParameter("pdob"));   
		//to_store  cust_code

		String nationalId = XHDBAdapter.checkNull(request.getParameter("nid"));
		String sex = XHDBAdapter.checkNull(request.getParameter("sex"));
		String visitAdmissionDt = XHDBAdapter.checkNull(request.getParameter("vadmitdt"));  // cust_group_code
		String locationType = XHDBAdapter.checkNull(request.getParameter("locType"));


		String custCode = XHDBAdapter.checkNull(request.getParameter("custCode"));
		String serviceCode= XHDBAdapter.checkNull(request.getParameter("scode")); 
		String locationCode = XHDBAdapter.checkNull(request.getParameter("loccd"));
		String facilityId = XHDBAdapter.checkNull(request.getParameter("fcid"));

		String speciality_code = XHDBAdapter.checkNull(request.getParameter("speciality_code"));
		String firstName = XHDBAdapter.checkNull(request.getParameter("fname"));   //to_store
		String secondName = XHDBAdapter.checkNull(request.getParameter("sname"));
		String initial = XHDBAdapter.checkNull(request.getParameter("initial")); //to_store
		String familyName = XHDBAdapter.checkNull(request.getParameter("familyName"));
		String membershipNumber = XHDBAdapter.checkNull(request.getParameter("memno"));
		String wcaNumber = XHDBAdapter.checkNull(request.getParameter("wca"));    //to_store
		String m_surname = XHDBAdapter.checkNull(request.getParameter("m_surname"));
		String m_initial = XHDBAdapter.checkNull(request.getParameter("m_initial"));

		String dependantNumber = XHDBAdapter.checkNull(request.getParameter("depNum"));
		String dependantRelation = XHDBAdapter.checkNull(request.getParameter("depRel"));

		String checkType = XHDBAdapter.checkNull(request.getParameter("checkType"));
		String destCode = XHDBAdapter.checkNull(request.getParameter("destCode"));
	    String admission_type = XHDBAdapter.checkNull(request.getParameter("admission_type"));
		String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
		String visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));

		String request_status = XHDBAdapter.checkNull(request.getParameter("request_status"));
		String auth_num = XHDBAdapter.checkNull(request.getParameter("auth_num"));
	    String approval_status = XHDBAdapter.checkNull(request.getParameter("approval_status"));
		String warn_code = XHDBAdapter.checkNull(request.getParameter("warn_code"));
		String warn_desc = XHDBAdapter.checkNull(request.getParameter("warn_desc"));
		String event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));

		String blng_grp_id = XHDBAdapter.checkNull(request.getParameter("blng_grp_id"));
		String settlement_ind = XHDBAdapter.checkNull(request.getParameter("settlement_ind"));
		
		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));
		if(isDebugYN.equals("Y")) System.out.println("destCode...."+destCode);
	    if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);


        
		if(checkType.equals("IDC")){
			 destCode = (XHUtil.singleParamExeQry("SELECT DEFAULT_VALUE FROM XH_STANDARD_CONTROL_SEG where  ELEMENT_ID = 'IDC_DEST_CD' and SEGMENT_ID = 'ELC'"));
		}

		if(isDebugYN.equals("Y")) System.out.println("destCode...."+destCode);
	    if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);

		String approval_status_desc = "";

		if (approval_status.equals("A"))
			approval_status_desc = "Authorized";
		if (approval_status.equals("R"))
			approval_status_desc = "Rejected";
		if (approval_status.equals("F"))
			approval_status_desc = "Failed";
		if (!(approval_status.length()>0))
			approval_status_desc = "";

		String enableField = "";

	/*	if (approval_status.equals("A") && event_type.equals("IEC"))
			enableField = "Disabled";*/


		String disabledStr="disabled";
		String eligibilityCheckFields1 = "";
		String eligibilityCheckFields2 = "";
		String eligibilityCheckFields3 = "";


		if(isDebugYN.equals("Y")) System.out.println("admission_type...."+admission_type);
		if(isDebugYN.equals("Y")) System.out.println("event_type...."+event_type);
		if(isDebugYN.equals("Y")) System.out.println("checkType...."+checkType);

		String hideButton = "disabled";

		eligibilityCheckFields1 = "style='display:block;'";
		eligibilityCheckFields2 = "style='display:none;'";
		eligibilityCheckFields3 = "style='display:none;'";

		/*try{
			   SimpleDateFormat in_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			   SimpleDateFormat out_date = new SimpleDateFormat("yyyymmdd");

				Date date = in_date.parse(dob);
				dob = out_date.format(date);
				System.out.println("jsp.....dob.............. "+dob);
			}
			catch(Exception e)
			{
				System.out.println("eXH:::jsp..exception...."+ e.getMessage());
			}
			*/

%>
<form name='add_modify_pat_fin_det_ins_bodyedit' id='add_modify_pat_fin_det_ins_bodyedit' method='post' action="">

	<table cellspacing=0 cellpadding=3 width='100%' align=center border=1>
		<tr>
			<td colspan="15" class="COLUMNHEADER" align='LEFT'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> :<%=patient_id %> </td>
			<td colspan="10" class="COLUMNHEADER" align='center'><fmt:message key="Common.FullName.label" bundle="${common_labels}"/> :<%=patient_name %> </td>
			<td colspan="10" class="COLUMNHEADER" align='RIGHT'><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/> : <%=episodeId %></td>
			<td colspan="10" class="COLUMNHEADER" align='RIGHT'><fmt:message key="eMP.NationalID.label" bundle="${mp_labels}"/><%=nationalId %></td>
		</tr>	
	</table>
<!--</fieldset>-->

<fieldset style=" border-color:grey;">
	<table cellspacing=0 cellpadding=0 width='100%' align=left >
		<tr>
			<td>
				<table cellspacing=0 cellpadding=3 width='100%' align=left >
					<tr>
						<td>
							<table cellspacing=0 cellpadding=3 width='100%' align=left border=0>
								<tr>									
									<td class=label><fmt:message key="eBL.MembershipNo.label" bundle="${bl_labels}"/>							
									</td>
									<td class=label>
										<INPUT TYPE="text" id="membership_number" name="membership_number" id="membership_number"  value="<%=membershipNumber %>" >
									</td>
									<td class=label><fmt:message key="eBL.SchemeAuthNumber.label" bundle="${bl_labels}"/>		
									</td>
									<td class=label>
										<INPUT TYPE="text" id="p_wca_num" name="p_wca_num" id="p_wca_num" align="left" size='20'  value="<%=wcaNumber %>" >			
									</td>
								</tr>
								<tr>	
								    <td class=label><fmt:message key="eBL.Membersuname.label" bundle="${bl_labels}"/>		
									</td>
									<td class=label>
										<INPUT TYPE="text" id="mem_surname" name="p_surname" id="p_surname" align="left" size='20'  value="<%=m_surname %>" >			
									</td>
									<td class=label><fmt:message key="eBL.MemberInitial.label" bundle="${bl_labels}"/>							
									</td>
									<td class=label>
										<INPUT TYPE="text" id="mem_intial" name="p_intial" id="p_intial"  value="<%=m_initial %>" >
									</td>
									
								</tr>
								<tr>
									<td class=label><fmt:message key="eBL.DependantNo.label" bundle="${bl_labels}"/></td>
									<td class=label>
										<INPUT TYPE="text" id="p_dependant_num" name="p_dependant_num" id="p_dependant_num" align="left" size='20'  value="<%=dependantNumber %>" >
									</td>
									<td class=label ><fmt:message key="eBL.DependantRelatiosnhip.label" bundle="${bl_labels}"/>		
									</td>
									<td class=label >
										<select name="p_dependant_relation" id="p_dependant_relation" id="p_dependant_relation" style="width: 150px"  value="<%=dependantRelation %>" >
											<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
											<option value = '0'>Self</option>
											<option value = '1'>Spouse</option>
											<option value = '2'>Child</option>
											<option value = '3'>Other</option>
										</select>
										<script>
											var tempObjName = 'p_dependant_relation';									
											if ('<%=dependantRelation.length()%>' > 0 )
											{
												var selTempObj = document.getElementById(tempObjName);										
												for(var i=0;i<selTempObj.options.length;i++){											
													if (selTempObj.options[i].value == '<%=dependantRelation%>') {

														selTempObj.selectedIndex = i;
														break;
													}
												}
											}
										</script>
									</td>
								</tr>
							</table>
						</td>						
					</tr>
					<tr>
						<td align=RIGHT>							
							<input class='BUTTON' type="button"  ID="eligibility_trns" name="eligibility_trns" id="eligibility_trns" value='Eligibility Trx' onClick="eligibilityCheck()" <%=enableField%>>
							<input class='BUTTON' type="button"  ID="fetch_response_elgi" name="fetch_response_elgi" id="fetch_response_elgi" value='Fetch Response' onClick="fetchResponse()" disabled>
						</td>
					</tr>
				</table>
			</td>
		</tr>	
	</table>	
</fieldset>

<fieldset style=" border-color:grey;">
<div id="resultFieldSet" <%=eligibilityCheckFields1 %>>
	<table cellspacing=0 cellpadding=0 width='100%' align=left  >	
		<tr>
			<td>
				<table cellspacing=0 cellpadding=3 width='100%' align=left >
					<tr>
						<td>
							<table cellspacing=0 cellpadding=3 width='100%' align=left border=0>
								<tr>									
									<td class=label><fmt:message key="eXH.ClaimNumber.label" bundle="${xh_labels}"/>								
									</td>
									<td class=label>
										<INPUT TYPE="text" id="claims_number" name="claims_number" id="claims_number"  value="">
									</td>
									<td class=label><fmt:message key="eXH.responsetype.label" bundle="${xh_labels}"/>		
									</td>
									<td class=label>
										<INPUT TYPE="text" id="response_type" name="response_type" id="response_type" align="left" size='20'  value="<%=approval_status_desc%>" >			
									</td>
								</tr>								
								<!--<tr>
									<td class=label >Warning Code				
									</td>
									<td class=label >
										<INPUT TYPE="text" id="warning_code" name="warning_code" id="warning_code" align="left" size='20'  value="<%=warn_code%>" >
									</td>
									<td class=label>Warning Code Description</td>
									<td class=label>
										<INPUT TYPE="text" id="warning_code_desc" name="warning_code_desc" id="warning_code_desc" align="left" size='20'  value="<%=warn_desc%>" >
									</td>									
								</tr>-->
								<tr>
									<td class=label><fmt:message key="eXH.AuthNumber.label" bundle="${xh_labels}"/>	</td>
									<td class=label>
										<INPUT TYPE="text" id="auth_number" name="auth_number" id="auth_number" align="left" size='20'  value="<%=auth_num%>" >
									</td>

									<td> </td>
									
								</tr>
							</table>
						</td>						
					</tr>
					<tr>
						
					</tr>
				</table>
			</td>
		</tr>	
	</table>
</div>
</fieldset>
<fieldset style=" border-color:grey;" height="100%">

<div id="comparePatientData"  height="100%" <%=eligibilityCheckFields2%> style="height:350px;overflow: auto; border:1px solid #ff0000;">
 
	<table width="100%" height="100px" cellPadding="1" noWrap="nowrap" bgcolor="#000000" border="1" style="overflow: auto;">
        <tr height="100px">
			<td id="Response" colSpan="1"  align="center"  ></td>
		</tr> 		
	</table>
</div>
</fieldset>
<fieldset style=" border-color:grey;">

<div id="dispayWarning"  height="10%" <%=eligibilityCheckFields3%> style="margin-top:5px;">


<table width="100%" height="40%" cellPadding="1" noWrap="nowrap" bgcolor="#000000" border="1" style="border-collapse: collapse;border-style: solid;border-color: #d5ecfb #d5ecfb; overflow-y: auto;">
        <tr height="100%">
			<td id="Warning" colSpan="1"  align="center"  style="background-color: #dae6f2; color: black;" ></td>
		</tr> 		
	</table>
</div>
</fieldset>

<table cellspacing=0 cellpadding=0 width='100%' align=left >
<tr height="25px"> 
			<td  colSpan="2"  align="right"  style="background-color: #dae6f2; color: black;" >							
				<input type="button" class="BUTTON" ID="update_auth" name='update_auth' id='update_auth' value='Save Authorization Detail' onClick="Update('1')" <%=hideButton%> <%=enableField%>>
				<input type="button" class="BUTTON" ID="update_auth_patientDetail" name='update_auth_patientDetail' id='update_auth_patientDetail' value='Save Member Details' onClick="Update('2')" <%=hideButton%> <%=enableField%>>
				<input  type="button" class="BUTTON" value='Close' onClick="cancel()" >
			</td>
		</tr>
</table>
<input type=hidden name="patient_name" id="patient_name" value=" <%=patient_name %>" >
<input type=hidden name="patient_id" id="patient_id" value="<%=patient_id %>" >
<input type=hidden name="encounterId" id="encounterId" value="<%=encounterId %>" >
<input type=hidden name="sex" id="sex" value="<%=sex %>" >
<input type=hidden name="nationalId" id="nationalId" value="<%=nationalId %>" >
<input type=hidden name="patient_cls_episode" id="patient_cls_episode" value="<%=patient_cls_episode %>" >
<input type=hidden name="episodeId" id="episodeId" value="<%=episodeId %>" >
<input type=hidden name="visitAdmissionDt" id="visitAdmissionDt" value="<%=visitAdmissionDt %>" >
<input type=hidden name="locationType" id="locationType" value="<%=locationType %>" >
<input type=hidden name="serviceCode" id="serviceCode" value="<%=serviceCode %>" >
<input type=hidden name="speciality_code" id="speciality_code" value="<%=speciality_code %>" >
<input type=hidden name="custCode" id="custCode" value="<%=custCode %>" >
<input type=hidden name="firstName" id="firstName" value="<%=firstName %>" >
<input type=hidden name="secondName" id="secondName" value="<%=secondName %>" >
<input type=hidden name="initial" id="initial" value="<%=initial %>" >
<input type=hidden name="dob" id="dob" value="<%=dob %>" >
<input type=hidden name="familyName" id="familyName" value="<%=familyName %>" >
<input type=hidden name="checkType" id="checkType" value="<%=checkType%>" >
<input type=hidden name="destCode" id="destCode" value="<%=destCode%>" >
<input type=hidden name="transID" id="transID" value="" >
<input type=hidden name="AddedByFacilityId" id="AddedByFacilityId" value="<%=loginfacility %>" >
<input type=hidden name="AddedByUserId" id="AddedByUserId" value="<%=user_id%>" >
<input type=hidden name="WorkstationNo" id="WorkstationNo" value="<%=AddedAtWsNo%>" >
<input type=hidden name="admission_type" id="admission_type" value="<%=admission_type%>" >
<input type=hidden name="episode_type" id="episode_type" value="<%=episode_type%>" >
<input type=hidden name="visit_id" id="visit_id" value="<%=visit_id%>" >
<input type=hidden name="preData" id="preData" value="" >
<input type=hidden name="blng_grp_id" id="blng_grp_id" value="<%=blng_grp_id%>" >
<input type=hidden name="settlement_ind" id="settlement_ind" value="<%=settlement_ind%>" >

</form>
</body>
</html>

