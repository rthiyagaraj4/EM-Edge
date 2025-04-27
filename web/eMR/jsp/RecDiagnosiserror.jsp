<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="eCommon.XSSRequestWrapper"%>
<%	
String sStyle	=   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../js/RecDiagnosis.js' language='javascript'></SCRIPT>
<script src='../js/RecDiagnosisMain.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script>
<script src='../../eXH/js/jquery-1.7.min.js' language='javascript'></script>
<head>
<body class="message" onKeyDown='lockKey()'>
<script>
/*Below funtion modified for this CRF PMG2012-CRF-0030 */
	function onsuccess(Patient_Id, Encounter_Id, patient_class, term_set_id, Practitioner_Id, relationship_id, Locn_Type, Locn_Code, sex, dob, occur_srl_no, f,modal_yn,pract_type,isCalledFromCA,option_id,accession_number,call_from,reload_mdr,p_called_from_widget,called_from_ot)  //CHL-CRF- 0008 - IN:001472
	{ 
		if(f =='EOC')
		{							
			parent.frames[0].document.location.href="../../eMR/jsp/RecDiagnosisEOCResult.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id="+term_set_id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no;
			parent.frames[1].document.location.href="../../eMR/jsp/RecDiagnosisEOCAddModify.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id="+term_set_id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no;
			parent.frames[2].document.location.href="../../eMR/jsp/RecDiagnosisEOCButtons.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&occur_srl_no="+occur_srl_no;
		}
		else if(isCalledFromCA!='Y')
		{
			//Maheshwaran K added for MMS-DM-CRF-197.1
			if(document.RecDaignosiserror_form.error.value.indexOf("APP-MR0182")==0){
				parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.focus();
			}
			else 
			{
				//parent.frames[2].document.location.href="../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id="+term_set_id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no;
			if(call_from=="MAINTAIN_DEATH_REGISTER"){
			
						window.returnValue=reload_mdr;		
						window.close();
			}
			
			var dialogFrame = top.document.getElementById('dialog-body')?top.document.querySelectorAll('#dialog-body')[top.document.querySelectorAll('#dialog-body').length-1].contentWindow.frames[1]:parent;
			dialogFrame.frames[0].document.location.href="../../eCommon/jsp/pline.jsp?EncounterId="+Encounter_Id;
			dialogFrame.frames[2].document.location.href="../../eMR/jsp/RecDiagnosisCurrentDiag.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id="+term_set_id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no+"&modal_yn="+modal_yn+"&practitioner_type="+pract_type+"&option_id="+option_id+"&accession_num="+accession_number+"&called_from_ot="+called_from_ot+"&function_id="+f; //Modified for this CRF [ PMG2012-CRF-0030] //function_id added by Suji Keerthi for ML-MMOH-CRF-1605
			
			dialogFrame.frames[3].document.location.href="../../eMR/jsp/RecDiagnosisCurrentDiagLegend.jsp";
			//parent.frames[4].document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id="+term_set_id+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no;

			dialogFrame.frames[4].document.location.href="../../eMR/jsp/RecDiagnosisAddModify.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id=&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no+"&modal_yn="+modal_yn+"&practitioner_type="+pract_type+"&isCalledFromCA="+isCalledFromCA+"&option_id="+option_id+"&accession_number="+accession_number+"&called_from_ot="+called_from_ot+"&function_id="+f; //Modified for this CRF [ PMG2012-CRF-0030] //function_id added by Suji Keerthi for ML-MMOH-CRF-1605
			dialogFrame.frames[5].document.location.href="../../eMR/jsp/RecDiagnosisOpernToolbar.jsp?Patient_Id="+Patient_Id+"&Encounter_Id="+Encounter_Id+"&patient_class="+patient_class+"&Practitioner_Id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&Locn_Type="+Locn_Type+"&occur_srl_no="+occur_srl_no+"&function_id="+f; //function_id added by Suji Keerthi for ML-MMOH-CRF-1605
				}
		}
		else
		{			
				//Maheshwaran K added for MMS-DM-CRF-197.1
			if(document.RecDaignosiserror_form.error.value.indexOf("APP-MR0182")==0){
			parent.RecDiagnosisAddModify.document.RecDaignosis_form.diag_classfication.focus();
			
		}else {
		    //Modified for this CRF [ PMG2012-CRF-0030]
			parent.parent.frames[1].document.location.href="../../eMR/jsp/RecDiagnosisMain.jsp?patient_id="+Patient_Id+"&encounter_id="+Encounter_Id+"&patient_class="+patient_class+"&term_set_id=&practitioner_id="+Practitioner_Id+"&Locn_Code="+Locn_Code+"&relationship_id="+relationship_id+"&location_type="+Locn_Type+"&Sex="+sex+"&Dob="+dob+"&occur_srl_no="+occur_srl_no+"&practitioner_type="+pract_type+"&modal_yn="+modal_yn+"&option_id="+option_id+"&CA="+isCalledFromCA+"&accession_num="+accession_number+"&p_called_from_widget="+p_called_from_widget+"&called_from_ot="+called_from_ot; //CHL-CRF- 0008 - IN:001472
		}
		}
		if(document.RecDaignosiserror_form.error.value.indexOf("Operation Completed Successfully")>0){
			var term_code="";
			if(parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value =="" && parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_desc.value !=""){
				term_code="*OTH";
			}else{
				term_code=parent.RecDiagnosisAddModify.document.RecDaignosis_form.diagprob_code.value;
			}
			var accuracy_val= parent.RecDiagnosisAddModify.document.RecDaignosis_form.accuracy.value;
			var accuracy_val_arr=accuracy_val.split("=");
			eNotifikasi(Patient_Id, Encounter_Id,term_set_id,term_code,accuracy_val_arr[1]);
		}
	}
</script>
</head>

<form name='RecDaignosiserror_form' id='RecDaignosiserror_form'  action='' method='post' target=''>
<p align="left">
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");	
	String flag		=	 checkForNull(request.getParameter("flag"));
	String call_from	 =checkForNull(request.getParameter("call_from"));
	String reload_mdr	 =checkForNull(request.getParameter("reload_mdr"));
	String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
	String error				=request.getParameter( "error" );

	%>

	<input type='hidden' name='error_value' id='error_value' value="<%=error_value%>"> 
	<input type='hidden' name='error' id='error' value="<%=error%>"> 

	<%if(flag.equals("Record_found")){
		out.print("<script>var ggp_status = window.confirm(getMessage('MR_DIAG_DIFFGRP_CONFIRM','MR'));</script>");
	//out.println("<script>alert(\"ppppopo :\");</script>");

	//out.println("<script>alert(\"+request.getQueryString() :\");</script>");
	//out.println("<script>alert(\"request.getQueryString() :"+request.getQueryString()+"\");</script>");						

		out.println("<script>if(ggp_status)diffGroupforDiag('"+request.getQueryString()+"')</script>");
			//out.println("<script>alert(\"klkklklkl :\");</script>");

	}

	
	String Patient_Id		=checkForNull(request.getParameter("Patient_Id"));
	String patient_class	=checkForNull(request.getParameter("patient_class"));
	String Encounter_Id	=checkForNull(request.getParameter("Encounter_Id"));
	String term_set_id		=checkForNull(request.getParameter("term_set_id"));
	String term_set_code		=checkForNull(request.getParameter("term_set_code"));
	String Practitioner_Id	=checkForNull(request.getParameter("Practitioner_Id"));
	String relationship_id	=checkForNull(request.getParameter("relationship_id"));
	String Locn_Type		=checkForNull(request.getParameter("Locn_Type"));
	String Locn_Code		=checkForNull(request.getParameter("Locn_Code"));
	String sex					=checkForNull(request.getParameter("sex"));
	String dob					=checkForNull(request.getParameter("dob"));
	String occur_srl_no_hid	=checkForNull(request.getParameter("occur_srl_no_hid"));
	String function_id		=checkForNull(request.getParameter("function_id"));
	String modal_yn		=checkForNull(request.getParameter("modal_yn"));
	//String diag_description		=checkForNull(request.getParameter("diag_Description"));
	String isCalledFromCA		=checkForNull(request.getParameter("isCalledFromCA"));
	String practitioner_type	=checkForNull(request.getParameter("practitioner_type"));
	String option_id		=checkForNull(request.getParameter("option_id"));
	String accession_number	=checkForNull(request.getParameter("accession_number"));
	String p_called_from_widget = checkForNull(request.getParameter("p_called_from_widget"));
	String called_from_ot = checkForNull(request.getParameter("called_from_ot")); //this line Adde dor this CRF PMG2012-CRF-0030
	
	
	//String returnval=term_set_id+"^"+term_set_code+"^"+diag_description;
	//System.out.println("returnval=============="+returnval);
	if(error_value != null)
	{
		if(!modal_yn.equals("Y"))
		{
			out.println( error ) ;
		}
		else
		{
			
			//out.print("<script>alert('"+error+"');window.returnValue='"+returnval+"';parent.window.close();</script>");
			//out.print("<script>alert('"+error+"');window.returnValue='"+returnval+"';</script>");
			System.out.println("before calling alert");
			out.println("<script>alert('"+error+"');</script>");
			System.out.println("after calling alert");
			//if(isCalledFromCA.equals("N"))
				out.println( "<script>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"','"+call_from+"','"+reload_mdr+"','"+p_called_from_widget+"','"+called_from_ot+"');</script>" ) ;  //CHL-CRF- 0008 - IN:001472   this line modified for this CRF [PMG2012-CRF-0030]
			/*else if (option_id.equals("OH_REST_CHART_REC1"))
			{
				out.println( "<script language='JavaScript'>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"');</script>" ) ;
				
			}*/
		}
		String queryString = (String)session.getValue( "queryString" ) ;
		if ( queryString == null ) queryString = "" ;
		
		if ( error_value.equals( "1" ) && !modal_yn.equals("Y"))
		{
			out.println( "<script>onsuccess('"+Patient_Id+"','"+Encounter_Id+"','"+patient_class+"','"+term_set_id+"','"+Practitioner_Id+"','"+relationship_id+"','"+Locn_Type+"','"+Locn_Code+"','"+sex+"','"+dob+"','"+occur_srl_no_hid+"','"+function_id+"','"+modal_yn+"','"+practitioner_type+"','"+isCalledFromCA+"','"+option_id+"','"+accession_number+"','"+call_from+"','"+reload_mdr+"','"+called_from_ot+"');</script>" ) ;  //this line modified for this CRF [PMG2012-CRF-0030] 
		}
	}

%>
</p>
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='call_from' id='call_from' value="<%=call_from%>"> 

</form>
</body>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

