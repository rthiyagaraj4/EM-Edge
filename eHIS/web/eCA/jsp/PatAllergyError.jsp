<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		out.flush();

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="JavaScript">

function onsuccess() {
	var frameRef;
	if(top.content != null)
	{
		frameRef = top.content.workAreaFrame;
	}
	else
	{
		frameRef = parent;
	}
			var P_Encounter_Id = frameRef.add_modify.document.PatientAllergy_form.Encounter_Id.value;
			 var P_Practitioner_Id = frameRef.add_modify.document.PatientAllergy_form.Practitioner_Id.value;
			 var P_Clinic_Code = frameRef.add_modify.document.PatientAllergy_form.Clinic_Code.value;
			 var P_Patient_Id = frameRef.add_modify.document.PatientAllergy_form.Patient_Id.value;
		 	 var P_Location_Type = frameRef.add_modify.document.PatientAllergy_form.Location_Type.value;
			frameRef.query.location.href ='../../eCA/jsp/PaintPatAllegyResult.jsp?aclass=S&Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&patient_id='+P_Patient_Id+'&Location_Type='+P_Location_Type
			// parent.query.document.location.reload();
			
			frameRef.add_modify.location.href ='../../eCA/jsp/addModifyPatAllegy.jsp?aclass=S&Encounter_Id='+P_Encounter_Id+'&Practitioner_Id='+P_Practitioner_Id+'&Clinic_Code='+P_Clinic_Code+'&Patient_Id='+P_Patient_Id+'&Location_Type='+P_Location_Type

			frameRef.tools.location.href='../../eCA/jsp/PatAllergyQueryTools.jsp?patient_id='+P_Patient_Id;
			
			if(top.content != null)
			{
				if(parent.CommonToolbar.allergy_tabid==null)
				{
					//parent.CommonToolbar.allergy_hidden_tabid.style.visibility = "visible";
				}
			}

}
</script>

</head>

<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<p>
<%
	String error=request.getParameter( "err_num" );

	if (error != null) {
		out.println(error);

		String queryString = (String) session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		
		if ( error_value.equals( "1" ) )
		 out.println( "<script language='JavaScript'>onsuccess()</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>" ) ;
		
	}

%>
</p>
</BODY>
</html>

