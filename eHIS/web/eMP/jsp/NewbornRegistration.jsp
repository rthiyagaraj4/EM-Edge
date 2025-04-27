<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:26 AM -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String frameSetRows="";
	String patient_id		= request.getParameter("Patient_ID");
	String function_id		= request.getParameter("function_id");
	String parent_details	= request.getParameter("parent_details");
	String function_invoked = request.getParameter("function_invoked");
	String function_name 	= request.getParameter( "function_name" ) ;
	String mother_patient_id="";
	String ca_encounter_id="";
	if(function_name	== null ) function_name	= "" ;	
	if(patient_id == null) patient_id = "" ;
	if(function_id == null) function_id = "" ;
	if( parent_details == null) parent_details = "";
	if(function_invoked == null) function_invoked = "";
	String module_invoked			= request.getParameter("module_invoked") == null ? "" : request.getParameter("module_invoked");
	String calling_module_id		= request.getParameter("calling_module_id") == null ? "" : request.getParameter("calling_module_id");
	String mother_nursing_unit		= request.getParameter("mother_nursing_unit") == null ? "" : request.getParameter("mother_nursing_unit");
	String mother_bed_no			= request.getParameter("mother_bed_no") == null ? "" : request.getParameter("mother_bed_no");
	String called_from_mothercare	= request.getParameter("called_from_mothercare") == null ? "" : request.getParameter("called_from_mothercare");
	ca_encounter_id					= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	parent_details = java.net.URLEncoder.encode(parent_details);
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params;	
	if(!function_id.equals("") && !function_id.equals("NEWBORN_REG") &&!function_id.equals("REG_NEWBORN_FOR_IP")){
		source = source+"&home_required_yn = N";					
	}	
	int src = source.indexOf("access",0);
	String accessRights = source.substring(src+7,src+12);
	//if(called_from_mothercare.equals("MC")){
		mother_patient_id=patient_id;
	//}

	session.putValue("accessRights", accessRights);
	session.setAttribute("paramsValue", params);  
	
	String file_name = "";
	file_name = "../../eMP/jsp/NewbornRegistrationInvoke.jsp?accessRights="+accessRights+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&function_invoked="+function_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&calling_module_id="+calling_module_id;

	if(!(patient_id.equals(""))){ 
		file_name = "../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id="+patient_id+"&function_id="+function_id+"&accessRights="+accessRights+"&parent_details="+java.net.URLEncoder.encode(parent_details)+"&function_invoked="+function_invoked+"&module_invoked="+module_invoked+"&mother_nursing_unit="+mother_nursing_unit+"&mother_bed_no="+mother_bed_no+"&function_name="+function_name+"&calling_module_id="+calling_module_id+"&called_from_mothercare="+called_from_mothercare+"&mother_patient_id="+mother_patient_id+"&ca_encounter_id="+ca_encounter_id;
	}
	

	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	if(called_from_mothercare.equals("MC")){
		frameSetRows="0%,*,5%";
	%>
		<script>
			/*var sStyle = "<%=sStyle%>";
			var HTMLVal = "<HTML><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><BODY CLASS='MESSAGE' onKeyDown='lockKey()'>";
            HTMLVal = HTMLVal +"<form name='form1' id='form1' method='post' action='../../eMP/jsp/PatSearchCheckAltIDExpiryDate.jsp'>";
            HTMLVal = HTMLVal +"<input name='pat_id' id='pat_id' type='hidden' value= \"escape(<%=patient_id%>) \">";
            HTMLVal = HTMLVal +"<input name='jsp_name' id='jsp_name' type='hidden' value= ''>";
            HTMLVal = HTMLVal +"<input name='flag' id='flag' type='hidden' value= ''>";
            HTMLVal = HTMLVal +"<input name='func_id' id='func_id' type='hidden' value= ''>";
            HTMLVal = HTMLVal +"<input name='sflag' id='sflag' type='hidden' value= ''>";
			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.form1.submit();*/
			parent.frames[5].location.href="../../eCommon/jsp/error.jsp";
		</script>		
	<%}else{
		frameSetRows="6%,*,8%";
	}
	%>
	
	<html>
		<head>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
			<script language='javascript' src='../../eMP/js/NewbornRegistration.js'></script>
			<script language='javascript' src='../../eMP/js/NewbornRegistration1.js'></script>
			<script language='javascript' src='../../eMP/js/NewbornRegistration2.js'></script>
			<script language='javascript' src='../../eCommon/js/common.js'></script>
			<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
				async function query(){
					var patientid= await PatientSearchWithDefaultGender('F','N');
					if(patientid!=null){ 
						 frames[1].location.href = '../../eMP/jsp/NewbornRegistrationFirst.jsp?patient_id='+patientid+'&accessRights=<%=accessRights%>&parent_details=<%=parent_details%>&function_invoked=<%=function_invoked%>&mother_nursing_unit=<%=mother_nursing_unit%>&mother_bed_no=<%=mother_bed_no%>&function_name=<%=function_name%>&calling_module_id=<%=calling_module_id%>';
					}
				}
			</script>
			<title><fmt:message key="eMP.RegNewBorn.label" bundle="${mp_labels}"/> </title>		 	
		</head>

			<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder='0' scrolling='no' noresize style='height:7vh;width:100vw'></iframe>
			<iframe name='f_query_add_mod' id='f_query_add_mod' src="<%=file_name%>" frameborder=0 style='height:84vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>

	</html>

<%!	
	private String checkForNull(String inputString){
		return (inputString == null) ? "" : inputString;
	}	
	public static String checkForNull(String inputString, String defaultValue){
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

