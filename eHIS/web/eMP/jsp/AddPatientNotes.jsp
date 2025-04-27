<!DOCTYPE html>


<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
 <% 
 request.setCharacterEncoding("UTF-8"); 
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
  function maxLength1(field,maxChars)
 {
       if(field.value.length >= maxChars) {
          event.returnValue=false;		   
          return false;
       }
 }  

 function maxLengthPaste(field,maxChars)
 {
       event.returnValue=false;
       if((field.value.length +  window.clipboardData.getData("Text").length) > maxChars) {	 
	       var errors1 = getMessage('PATIENT_EXCEED_MAX_LEN','MP');
		   alert(errors1);
         return false;
       }
       event.returnValue=true;
 }
function AddRemarkNotes(){	
	if(trimString(document.patientnotes.addedremarks.value)!=""){ 
		document.patientnotes.submit();
	}else{
		var errors1 =  getMessage("CAN_NOT_BE_BLANK","common");
		errors1 = errors1.replace('$',getLabel("Common.notes.label","common"));
		alert(errors1);
	}
}

function onSuccess(patid,encounter_id,visit_date_time){
	parent.frames[0].location.href="../eMP/jsp/DisplayPatientNotes.jsp?patientid="+patid+"";
	parent.frames[1].location.href="../eMP/jsp/AddPatientNotes.jsp?patientid="+patid+"&encounter_id="+encounter_id+"&visit_date_time="+visit_date_time+"";	
	parent.messageFrame.location.href='../eCommon/jsp/error.jsp?err_num=';
}
function focusTextArea(){
		document.patientnotes.addedremarks.focus();
}

</script>
</head>


<body onload="focusTextArea();">

 <form name="patientnotes" id="patientnotes" method="post"  action='../../servlet/eMP.PatientNotesServlet' target="messageFrame">  
	

<%
	 try{	 
		 String patientid=request.getParameter("patientid")== null?"":request.getParameter("patientid");
		 String encounter_id=request.getParameter("encounter_id")== null?"":request.getParameter("encounter_id");
		 String visit_date_time=request.getParameter("visit_date_time")== null?"":request.getParameter("visit_date_time");
		  
		 

		// String facility_id = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");	//Commented by Dharma for checkstyle execution against PMG2014-MOD-CRF-0002 [IN:050447]		
%>	
	 <table align= center border="0" width="100%" cellspacing='0' cellpadding='2'>
	 <tr><td class='columnheader' colspan = 2  align = center ><fmt:message key="eMP.NewNote.label" bundle="${mp_labels}"/></td>
	 </tr>
	  <tr>
		    <td  align='left' width="70%" >
			<textarea name="addedremarks" id="addedremarks" rows="4" cols="120" onkeypress='return maxLength1(this,"255");' onpaste='return maxLengthPaste(this,"255");'  ></textarea></td>
			<td width="30%" align=center> <input type="button" class='button' value="Add" onclick="AddRemarkNotes()"></td>
		 </tr>		  
	</table>
	

	<input type="hidden" name="patientid" id="patientid" value="<%=patientid%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="visit_date_time" id="visit_date_time" value="<%=visit_date_time%>">
	<input type="hidden" name="operation" id="operation" value="insert">
	<%
	}catch(Exception e){
		//out.print(e);
		e.printStackTrace();
	 }
	
		
		   %>	 
		 
	 
	
	 
</form>
</body>
</html>

