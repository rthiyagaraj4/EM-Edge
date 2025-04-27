<!DOCTYPE html>
<%--
*	Copyright Â© MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
request.setCharacterEncoding("UTF-8");
String locale					= (String)session.getAttribute("LOCALE");
Connection con					= null;
ResultSet termcodeRs			= null;
PreparedStatement termcodeStmt	= null;
String termcodeSql				= "";
String termsetid				= "";
String termsetdesc				= "";
//String defnlevel = "";
%>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/TerminologyCode.js"></script>
<SCRIPT LANGUAGE="JavaScript">
// This function is written for getting values dynamically for classification levels
// Legend in 2nd frame and drawing table in the third frame.
function getdefnlevels()
{
	var termsetid = document.frm_terminology_code.terminology_set.value;
	var isMultiDescAppl = parent.f_term_add_modify.document.term_code_addmodify.isMultiDescAppl.value; // added by mujafar for ML-MMOH-CRF-1281
	
	var icd_termset = termsetid.substring(0,3);
	parent.f_term_result_header.document.term_code_result_header.search_text.value="";
	parent.f_term_result_header.document.term_code_result_header.search_criteria.value="C";
	parent.f_term_result_header.document.term_code_result_header.termcode.value="";
	parent.f_term_result_header.document.term_code_result_header.codelevel.value="";
	parent.f_term_add_modify.document.term_code_addmodify.term_code.value="";
	parent.f_term_add_modify.document.term_code_addmodify.term_code.disabled=false;
	parent.f_term_add_modify.document.term_code_addmodify.short_desc.value="";
	parent.f_term_add_modify.document.term_code_addmodify.long_desc.disabled=false;
	parent.f_term_add_modify.document.term_code_addmodify.long_desc.value="";
	parent.f_term_add_modify.document.term_code_addmodify.short_desc.disabled=false;
	parent.f_term_add_modify.document.term_code_addmodify.eff_status.checked=true;
	parent.f_term_add_modify.document.term_code_addmodify.proc_diag.value="";

	parent.f_term_add_modify.document.term_code_addmodify.proc_diag.disabled=false;
	parent.f_term_add_modify.document.term_code_addmodify.term_code.readOnly=false;
	parent.f_term_add_modify.document.term_code_addmodify.selectable.checked=false;

	parent.f_term_add_modify.document.term_code_addmodify.selectable.disabled=false;
	parent.f_term_add_modify.document.term_code_addmodify.eff_status.disabled=false;

	parent.f_term_add_modify.document.term_code_addmodify.active.checked=false;
	parent.f_term_add_modify.document.term_code_addmodify.active.disabled=false;

	parent.f_term_add_modify.document.term_code_addmodify.potential.checked=false;
	parent.f_term_add_modify.document.term_code_addmodify.potential.disabled=false;

	parent.f_term_add_modify.document.term_code_addmodify.wellness.checked=false;
	parent.f_term_add_modify.document.term_code_addmodify.wellness.disabled=false;
	
	// added by mujafar for ML-MMOH-CRF-1281 START
	if(isMultiDescAppl == "true" && termsetid == "ICD10")
	{ 
		
	parent.f_term_add_modify.document.getElementById('show_multi_desc').style.visibility='visible'; 
	parent.f_term_add_modify.document.getElementById('show_desc').style.visibility='visible';
	if(parent.f_term_add_modify.document.getElementById('cmulti_desc'))
	{
	parent.f_term_add_modify.document.getElementById('multi_desc').checked=false;
	parent.f_term_add_modify.document.getElementById('multi_desc').disabled=false;

	}
	}
	else if(isMultiDescAppl == "true" && termsetid != "ICD10")
	{
		
	 parent.f_term_add_modify.document.getElementById('show_multi_desc').style.visibility='hidden'; 
	 parent.f_term_add_modify.document.getElementById('show_desc').style.visibility='hidden';
	 if(parent.f_term_add_modify.document.getElementById('multi_desc'))
	{
	parent.f_term_add_modify.document.getElementById('multi_desc').checked=false;
	parent.f_term_add_modify.document.getElementById('multi_desc').disabled=false;

	}

	}
	// added by mujafar for ML-MMOH-CRF-1281 END


	parent.f_term_add_modify.document.term_code_addmodify.sensitive.checked=false;
	parent.f_term_add_modify.document.term_code_addmodify.notifiable.checked=false;

	parent.f_term_add_modify.document.term_code_addmodify.code_indicator.value="";
	if(parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code){
		parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.value=""; // Newly Added for this CRF[BRU-HIMS-CRF-19.1]
		parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.disabled=true;
	}
	
	/* implemneting gettin the sensitivity and notifiable form */
	var param="termsetid="+document.frm_terminology_code.terminology_set.value+"&callfunction=sensvity/notifiable";
	
	
	var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			var temp_jsp="../../eMR/jsp/MR_validation.jsp?"+param;
			
			// var xmlDoc = new ActiveXObject( "Microsoft.XMLDom" ) ;
			// var xmlHttp = new ActiveXObject( "Microsoft.XMLHTTP" ) ;
			// xmlDoc.loadXML(xmlStr);
			
			var xmlHttp = new XMLHttpRequest();
			var xmlDoc = "" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			
			xmlHttp.open("POST",temp_jsp,false);
			xmlHttp.send(xmlDoc);
			responseText=trimString(xmlHttp.responseText);
			
			var retVal = responseText.split("&^&");
			
			var x=retVal[0];
			var z=retVal[1];
			/*Monday, January 25, 2010 18498*/
			var d=retVal[2];
			var p=retVal[3];
			var p = p.split("");
			var proc= p[0];
			/**/
	
			
			if(x=="Y"){
              
			parent.f_term_add_modify.document.term_code_addmodify.sensitive.disabled=false;
			}
			else{
				parent.f_term_add_modify.document.term_code_addmodify.sensitive.disabled=true;
				if(parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code)
					parent.f_term_add_modify.document.term_code_addmodify.High_risk_cndn_code.disabled=true; // Newly Added for this CRF[BRU-HIMS-CRF-19.1]

			}

			if(z=="Y"){
				 
			parent.f_term_add_modify.document.term_code_addmodify.notifiable.disabled=false;
			}
			else{
				
			parent.f_term_add_modify.document.term_code_addmodify.notifiable.disabled=true;
			}
			
			/*Monday, January 25, 2010 18498*/
				var obj =parent.f_term_add_modify.document.term_code_addmodify.proc_diag;
				var diagDesc = getLabel("Common.diagnosis.label","Common");
				var procDesc = getLabel("Common.Procedure.label","Common");
				var length  = obj.length;
				for(i=0;i<length;i++) 
				{
					obj.remove(1);
				}
				
				
				if(d == "Y" && proc == "N")
				{
					var opt= parent.f_term_add_modify.document.createElement('Option');
					opt.text=diagDesc; 
					opt.value='D';
					obj.add(opt);
					parent.f_term_add_modify.document.createElement('Option');
				}
				else if(proc == "Y" && d == "N")
				{
					var opt= parent.f_term_add_modify.document.createElement('Option');
					opt.text=procDesc; 
					opt.value='P';
					obj.add(opt);
					parent.f_term_add_modify.document.createElement('Option');
				}
				else if(d=="Y" && proc == "Y")
				{
					var opt1= parent.f_term_add_modify.document.createElement('Option');
					var opt2= parent.f_term_add_modify.document.createElement('Option');
					opt1.text = diagDesc;
					opt1.value='D';
					opt2.text = procDesc;
					opt2.value='P';
					obj.add(opt1);
					obj.add(opt2);
					parent.f_term_add_modify.document.createElement('Option');
				}
				/**/
			
		document.forms[0].diag_spec_yn.value = d;		
		document.forms[0].proc_spec_yn.value = proc;	
		
		parent.f_term_add_modify.document.term_code_addmodify.proc.value = document.forms[0].proc_spec_yn.value
		parent.f_term_add_modify.document.term_code_addmodify.diag.value = document.forms[0].diag_spec_yn.value
			
	/*Monday, January 25, 2010 18499*/		
	//parent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=false;
if(d=="Y")
	parent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=false;
else
	parent.f_term_add_modify.document.term_code_addmodify.code_indicator.disabled=true;
/**/
	
	
	parent.f_term_add_modify.document.term_code_addmodify.mode.value="";
	if(termsetid!="")
	{
		
		parent.f_term_add_modify.document.term_code_addmodify.termcode.value = termsetid;
		parent.f_term_result_header.document.term_code_result_header.termsetid.value= termsetid;
		parent.f_term_add_modify.document.term_code_addmodify.termsetid.value = termsetid;
		parent.f_term_add_modify.document.term_code_addmodify.codelevel.value = "1";
		// This part is for getting LEVEL value of the selected text in the list box and 
		//display as legend in 2nd frame
		var htmlvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_value' method='post' action='../../eMR/jsp/TerminologyCodeDynamicValues.jsp'><input type='hidden' name='termsetid' value='"+termsetid+"'><input type='hidden' name='icd_termset' value='"+icd_termset+"'></form></body></html>"
		parent.blankFrame.document.write(htmlvalue);
		parent.blankFrame.document.dynamic_value.submit();
		// End of getting values.
		// This part is for drawing table dynamically in the third frame according to the
		// selected value in the list box.
		var htmlresvalue = "<html><body onKeyDown='lockKey()'><form name='dynamic_result' id='dynamic_result' method='post' action='../../eMR/jsp/TerminologyCodeResult.jsp'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='diag_spec_yn' id='diag_spec_yn' value='"+d+"'><input type='hidden' name='proc_spec_yn' id='proc_spec_yn' value='"+proc+"'></html>"
		parent.f_term_code_result.document.write(htmlresvalue);
		parent.f_term_code_result.document.dynamic_result.submit();
		
		
		// End of drawing table.
		// This part is for drawing table dynamically in the third frame according to the
		// selected value in the list box for classification level description.
		var htmlclassvalue = "<html><body onKeyDown='lockKey()'><form name='class_level' id='class_level' method='post' action='../../eMR/jsp/TerminologyCodeDisplayLevels.jsp'><input type='hidden' name='codelevel' id='codelevel' value='1'><input type='hidden' name='termsetid' id='termsetid' value='"+termsetid+"'><input type='hidden' name='termcode' id='termcode' value='"+termsetid+"'></html>"
		parent.f_term_selected_frms.f_term_disp_lvl.document.write(htmlclassvalue);
		parent.f_term_selected_frms.f_term_disp_lvl.document.class_level.submit();
		// End of drawing table for classification level.
		parent.f_term_selected_frms.f_term_selected_values.document.location.href="../../eMR/jsp/TerminologyCodeSelectedValues.jsp";
		parent.messageFrame.document.location.href = "../../eCommon/jsp/MstCodeError.jsp";
	}
	else
	{		
		parent.f_term_result_header.document.term_code_result_header.termsetid.value="";
		//document.getElementById("dynlevel").innerText="";
		parent.f_term_result_header.document.getElementById("dynlevel").innerText="";		parent.f_term_code_result.document.location.href="../../eCommon/html/blank.html";
		parent.f_term_selected_frms.f_term_disp_lvl.document.location.href="../../eCommon/html/blank.html";
		//parent.f_term_selected_frms.f_term_selected_values.document.location.href="../../eMR/jsp/TerminologyCodeSelectedValues.jsp";
		parent.f_term_add_modify.document.location.href="../../eMR/jsp/TerminologyCodeAddModify.jsp";
		parent.f_term_selected_frms.f_term_selected_values.document.location.href="../../eCommon/html/blank.html";
	}
}
</SCRIPT>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="" target="messageFrame" name="frm_terminology_code" id="frm_terminology_code">
<TABLE border="0" cellpadding="5" cellspacing="0" width="100%" align='center'>
<TR>
	<TD class='label' width='35%' ><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
	<TD class='fields' width='35%'><SELECT name="terminology_set" id="terminology_set"  onchange="getdefnlevels()">
		<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
		<%
		try
		{
			con = ConnectionManager.getConnection(request);
			termcodeSql = "select term_set_id,mr_get_desc.mr_term_set(term_set_id,'"+locale+"',1)term_set_desc from MR_TERM_SET where eff_status='E' order by term_set_desc";
			termcodeStmt = con.prepareStatement(termcodeSql);
			termcodeRs = termcodeStmt.executeQuery();
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					termsetid = termcodeRs.getString("term_set_id");
					termsetdesc = termcodeRs.getString("term_set_desc");
					out.println("<option value='"+termsetid+"'>"+termsetdesc+"</option>");
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}

		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(termcodeRs!=null) termcodeRs.close();
			if(termcodeStmt!=null) termcodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
		%>		
		</SELECT><img src='../../eCommon/images/mandatory.gif'></img>
	</TD>
	<TD  class="label" width="20%" ></TD>
	<TD  class="label" width='10%' ></TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name='dyanmic_level' id='dyanmic_level' value="">  
<INPUT TYPE="hidden" name="diag_spec_yn" id="diag_spec_yn" value="">
<INPUT TYPE="hidden" name="proc_spec_yn" id="proc_spec_yn" value="">
</FORM>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	
%>

