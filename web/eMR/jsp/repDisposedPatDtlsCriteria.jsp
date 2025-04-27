<!DOCTYPE html>
<%@ page  import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<head>
<%
String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page import ="java.util.*" %>
<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eMR/js/MRReports.js" language="javascript"></script> 
 <script src="../../eCommon/js/DateUtils.js"></script>
 <script src="../../eCommon/js/CommonCalendar.js"></script>
   <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
  <script language='javascript' src="../../eCommon/js/FieldFormatMethods.js"></script> 
  <script>

 

//july 13 2010
function validate_date(obj) {
	
		if(obj.value!=''){

			if(isBeforeNow(obj.value,"DMY",localeName))
				return true;
			else {
				alert(getMessage("START_DATE_GREATER_SYSDATE","COMMON"));
				obj.value='';
				obj.focus();
				return false ;
			}
		}
  }

 function showLookUp(val) {
		if(val == 'P') {
			var patientid=PatientSearch('','','','','','','Y','','','OTHER');
			if(patientid != null){
				 document.getElementById("PatientId").value = patientid;
						document.forms[0].p_dispose_pat_id.value	= patientid;
			}else
				 document.getElementById("PatientId").value = "";
		}
  }

function validatePatientId(obj) {
	var patId = obj.value;
	
	if(patId!=""){ 
		var xmlDoc = ""
		var xmlHttp = new XMLHttpRequest()
		xmlStr ="<root><SEARCH patientId=\""+patId+"\" action='validatePatIdStatus' /></root>"
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml")
		xmlHttp.open("POST","../../eIP/jsp/IPintermediate.jsp",false)
		xmlHttp.send(xmlDoc)
		responseText=xmlHttp.responseText
		 var pat_status	= TrimStr(responseText);
		 var ErrorMessage	= ""; 
		 if ( pat_status=="INVALID_PATIENT"){
				 ErrorMessage	= getMessage('INVALID_PATIENT','MP');
			  }
		 if(ErrorMessage!=''){
			alert(ErrorMessage);
			obj.focus();
			obj.value='';
		}else{
			document.forms[0].p_dispose_pat_id.value	= patId;
		}
	}
}


  
	  </script>
</head>
<%
%>

<%
  request.setCharacterEncoding("UTF-8");
  String p_user_name		= (String) session.getValue( "login_user" ) ;
  String function_id       =  request.getParameter("function_id");
  String report_id = "MRDESPDL"; // added by boopathi for ML-MMOH-CRF-0723. 
	 if("INACTIVE_PATIENT_DTLS".equals(function_id)){
		  report_id = "MRINPDTL";
	 }
	 Connection con=null;
		String patientIdLength	= "";


try {
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	con =  ConnectionManager.getConnection(request);
		patientIdLength = eCommon.Common.CommonBean.getPatIdLength(con);
		patientIdLength = checkForNull(patientIdLength,"0");
	
%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
   <form name = 'searchFormRepDisposedPatDtls' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<br><br><br><br>
      <div>
        <table cellpadding='3' cellspacing='0' width='60%' align='center' >
          <tr class='label'>
            <td class='label' colspan='3'>&nbsp;</td>
           </tr>
		   		<tr>
					<td width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> </td>
					<td class="fields" width='30%'> 
					
					<input type='text' name="p_dispose_pat_id" id="p_dispose_pat_id" size="20" maxlength=<%=patientIdLength%>>
					<!--  <input type=text  name='PatientId' id='PatientId'  onBlur="makeValidString(this);ChangeUpperCase(this);validatePatientId(this);" onKeypress='return CheckForSpecChars(event);' align="center" size="" maxlength=<%=patientIdLength%>><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onClick="javascript:showLookUp('P')">
					<input type="hidden" name="p_dispose_pat_id" id="p_dispose_pat_id" >-->
					</td>
				</tr>
				<%if(!function_id.equals("DISPOSED_PATIENT_DTLS")){  %>
				 <tr>
					<td width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='30%'><input type='text' id='' name='from_speciality' id='from_speciality'   maxLength='15' OnBlur="BeforesearchCodeDRG1(fromSpecialty,this)"><input type='button' name='fromSpecialty' id='fromSpecialty' value='?' class='button' onclick="searchCodeDRG(this, from_speciality)" >
					<input type="hidden" name="p_fr_specialty_code" id="p_fr_specialty_code" id='' ></td>
				</tr>
			<%}%>
	 	   <tr>
            <td class='querydata' width='20%'>&nbsp;</td>
            <td class='querydata' width='20%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
            <td class='querydata' width='20%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
          </tr>
   	 
			 <tr>
			
             <td class='label'> 
				<%  if("DISPOSED_PATIENT_DTLS".equals(function_id)){  %><fmt:message key="eMR.DisposedDate.label" bundle="${mr_labels}"/><%}else{%><fmt:message key="eMR.InactiveDate.label" bundle="${mr_labels}"/><%}%>
			 </td>
             <td class='fields'>
               <input type='text' id='p_disp_fm_date' name='p_disp_fm_date' id='p_disp_fm_date' value='' size='10' maxlength='10' readonly  Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_fm_date');"/><img src='../../eCommon/images/mandatory.gif' align='center'></img>
              </td>
              <td class='fields'>
               <input type='text' id='p_disp_to_date' name='p_disp_to_date' id='p_disp_to_date' value='' size='10' maxlength='10' readonly Onblur="validDateObj(this,'DMY','<%=localeName%>');validate_date(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_disp_to_date');"/><img src='../../eCommon/images/mandatory.gif'  align='center'></img>
             </td>
          </tr>
		  

	 

	   </table>
     </div>
	 	 
     <input type='hidden' name='p_report_id' id='p_report_id' value='<%=report_id%>'></input>
     <input type='hidden' name='p_module_id' id='p_module_id' value='MR'></input>
     <input type= 'hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'></input>
     <input type='hidden' name='p_user_name' id='p_user_name' value='<%=p_user_name%>'></input>
     <input type='hidden' name='p_language_id' id='p_language_id' value='<%=localeName%>'></input>

	 	<%
     } catch(Exception e) {  /* out.println(e.toString()); */ e.printStackTrace();  }
     finally {
		ConnectionManager.returnConnection(con,request);
     }
%>
  </form>
</body>
</html>
<%!	
	

	public static String checkForNull(String inputString, String defaultValue)	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

