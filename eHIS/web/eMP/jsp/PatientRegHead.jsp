<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale					= (String)session.getAttribute("LOCALE");
	String disableAtttribute			= "";
	String refIDDefaultValue			= "";
	String language_direction="";
	int count=0;		
	String drfunctionid = request.getParameter("dr_function_id");
	if(drfunctionid == null) drfunctionid = "";	
	String calledFromModule = request.getParameter("calledFromModule");
	String appt_ref_no = request.getParameter("appt_ref_no");
	String booking_ref_no = request.getParameter("booking_ref_no");
	String referral_id = request.getParameter("referral_id");
	String pat_name_as_multipart_yn = request.getParameter("pat_name_as_multipart_yn")==null?"N":request.getParameter("pat_name_as_multipart_yn");
	String acpt_appt_rfrl_in_reg_pat_yn = request.getParameter("acpt_appt_rfrl_in_reg_pat_yn")==null?"N":request.getParameter("acpt_appt_rfrl_in_reg_pat_yn");
	String names_in_oth_lang_yn=request.getParameter("names_in_oth_lang_yn")==null?"N":request.getParameter("names_in_oth_lang_yn");
	String cntlang	= request.getParameter("cntlang")==null?"0":request.getParameter("cntlang");
	String toDayDate		= request.getParameter("toDayDate")==null?"":request.getParameter("toDayDate");
	String patient_id_length		= request.getParameter("patient_id_length")==null?"":request.getParameter("patient_id_length");		
	String OAinstall_yn		= checkForNull( request.getParameter("oainstall_yn") );
	String RDinstall_yn		= checkForNull( request.getParameter("rdinstall_yn") );
	String OPinstall_yn		= checkForNull( request.getParameter("opinstall_yn") );
	String IPinstall_yn		= checkForNull( request.getParameter("ipinstall_yn") );
	if(calledFromModule == null || calledFromModule.equals("null")) calledFromModule="";
	if(appt_ref_no == null || appt_ref_no.equals("null")) appt_ref_no="";
	if(booking_ref_no == null || booking_ref_no.equals("null")) booking_ref_no="";
	if(referral_id == null || referral_id.equals("null")) referral_id="";	
	if(!appt_ref_no.equals("")) refIDDefaultValue = appt_ref_no;
	else if(!booking_ref_no.equals("")) refIDDefaultValue = booking_ref_no;
	else if(!referral_id.equals("")) refIDDefaultValue = referral_id;
	else refIDDefaultValue = "";	
	if(!refIDDefaultValue.equals("")) disableAtttribute = "disabled"; 
	else disableAtttribute = ""; 
	 Connection con = ConnectionManager.getConnection(request);//Added By dharma
try
{

    String bl_install_yn = (String)session.getValue("mp_bl_oper_yn");
  	String sStyle	= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");              
	count = Integer.parseInt(cntlang)	;
	
		if ( count==1 ) {
			 language_direction = "R" ;
		} else {
			 language_direction = "L" ;
		}

%>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	
	<Script language='javascript' src='../../eMP/js/PatientRegistration.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration1.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration2.js'></Script>
	<Script language='javascript' src='../../eMP/js/PatientRegistration3.js'></Script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<Script>
		
    function CheckForSpecChars(event)
	{
      var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
      var whichCode = (window.Event) ? event.which : event.keyCode;
      key = String.fromCharCode(whichCode);  // Get key value from key code
      if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	  if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	  return true ;
   }
		
	</Script>


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<%
	String SelectedValue				= "";	
	StringBuffer OptionBuffer = null;
	OptionBuffer = new StringBuffer();	
	OptionBuffer.append("<option value='P'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientInformation.label","mp_labels")+"</option>");


		if(acpt_appt_rfrl_in_reg_pat_yn.equals("Y")) 	{
		
			if(OAinstall_yn.equals("Y")) {
				
				/*Added By Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982]Start*/
		
			/*	if(!booking_ref_no.equals("") && appt_ref_no.equals("")){
					HashMap ResultParamHashMap = new HashMap();
					HashMap sqlColumns = new HashMap();
					sqlColumns.put("APPT_REF_NO","S");
					String whereClause	= "where APPT_REF_NO='"+booking_ref_no+"'";
					ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"OA_APPT",con);
					String apptNo				 = (String) (ResultParamHashMap.get("APPT_REF_NO")==null?"":ResultParamHashMap.get("APPT_REF_NO"));
				
					if(!apptNo.equals("")){
						appt_ref_no		= booking_ref_no;
						booking_ref_no	= "";
					}
				}*/
				/*Added By Dharma on 9th Oct 2015 against For ML-MMOH-SCF-0298 [IN:057982]End*/

				if(!appt_ref_no.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='A' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ApptSch.label","mp_labels")+"</option>");
			}	
			if(RDinstall_yn.equals("Y")) {
				OptionBuffer.append("<option value='R'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.RdAppts.label","mp_labels")+"</option>");
			}
			if(OPinstall_yn.equals("Y")) {
				if(!referral_id.equals("") && SelectedValue.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='L' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+"</option>");
			}	
			if(IPinstall_yn.equals("Y")) 	{
				if(!booking_ref_no.equals("")) SelectedValue = "selected";
				else SelectedValue = "";
				OptionBuffer.append("<option value='I' "+SelectedValue+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.IpBooking.label","mp_labels")+"</option>");
			}
	}
	
	 
%>
<form name='regdPatHeadForm' id='regdPatHeadForm'>
<table name='patient_table' id='patient_table' width='100%' border='0' cellspacing='0'>
<!--Width is change to 50% from 100% by Rameswar on 18/04/2016 for HSA-CRf-0299-->
<tr></tr>
<tr></tr>
<tr></tr>
	  <tr>
        <td class='label' nowrap><fmt:message key="eMP.PopulateFrom.label" bundle="${mp_labels}"/></td>
		<td class='fields' colspan='4'><SELECT name='refrlAappt' id='refrlAappt' onChange='enbDsbRefIDVal(this);' <%=disableAtttribute%>><option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=OptionBuffer.toString()%></SELECT>&nbsp;&nbsp;
		
		<input type='text'  maxlength="20" name='refIDValue' id='refIDValue' value="<%=refIDDefaultValue%>"  onBlur="chkrefIDValue(this);" onkeypress="return CheckForSpecChars(event);" disabled><input type='button' class='button' name='refIDValueButton' id='refIDValueButton' value='?' onClick='PopAppRefDetails();' disabled><img id="phimg" src='../../eCommon/images/mandatory.gif' style="Visibility : 'Hidden';"></td>
	</tr>
	<tr>
     	<td class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap colspan='2'><input class='upper' name='patient_id' id='patient_id' size='18' maxlength="<%=patient_id_length%>" onFocus='loadPatSeriesManual();' onblur='ChangeUpperCase(this);checkPatientId()' readonly  disabled onKeyPress='return CheckForSpecChars(event)'><!-- <img src='../../eCommon/images/mandatory.gif'></img>-->
 		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='text'   name='patient_name' id='patient_name' size='50' maxlength='90' readonly value=''></td> 
		<!-- img commented and disabled added by mujafar for ML-MMOH-SCF-1039 -->
        <%		
		if(names_in_oth_lang_yn.equals("Y"))
			{
				out.println("<td class='fields' ><input type='text'  name='patient_name_loc_lang' id='patient_name_loc_lang' size='50' maxlength='90' readonly onBlur='makeValidString(this);'");

				if(language_direction.equals("R"))
				{
				out.println("dir='RTL'" ) ;
				}
				
				out.println(" ></td>" ) ;
			}
			else{
			out.println("<td class='fields' >&nbsp;&nbsp;</td>");
			}
		
        %>
	<td class='fields' >&nbsp;&nbsp;</td>	
    </tr>
	</table>
<!-- Code for Painting Tabs -->
	<table cellspacing='5' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" style='padding-left:0px'>
			<li class="tablistitem" title='<fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/>'>
				<a onclick="invokeTab('demogrp_tab')" class="tabClicked" id="demogrp_tab" >
					<span class="tabSpanclicked" id="demogrp_tabspan"><fmt:message key="eMP.demographicdetails.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="Common.contactmode.label" bundle="${common_labels}"/> & <fmt:message key="Common.AddressDetails.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('cmodeaddr_tab')" class="tabA" id="cmodeaddr_tab" >
					<span class="tabAspan" id="cmodeaddr_tabspan"><fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			
			<li class="tablistitem" title='<fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('rlcnts_tab')" class="tabA" id="rlcnts_tab" >
					<span class="tabAspan" id="rlcnts_tabspan"><fmt:message key="eMP.relatedcontacts.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.documents.label" bundle="${common_labels}"/> & <fmt:message key="Common.others.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('pat_docs_tab')" class="tabA" id="pat_docs_tab" >
					<span class="tabAspan" id="pat_docs_tabspan"><fmt:message key="Common.documents.label" bundle="${common_labels}"/> & <fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
			<%if(bl_install_yn.equals("Y")){%>
			<li class="tablistitem" title='<fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('findtl_tab')" class="tabA" id="findtl_tab" >
					<span class="tabAspan" id="findtl_tabspan"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
				</a>
			</li>	
		<%}%>	
		</ul>
<!--End Of code for Painting Tabs -->
<!-- The below line is required to change the select state of Demograph tab initially selected -->
	<script>prevTabObj='demogrp_tab'</script>
 </td></tr>
</table>
			
<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">
<input type='hidden' name='bl_oper_yn' id='bl_oper_yn' value="%=bl_install_yn%>">
<input type='hidden' name='calledFromModule' id='calledFromModule' value="<%=calledFromModule%>">
<input type='hidden' name='acpt_appt_rfrl_in_reg_pat_yn' id='acpt_appt_rfrl_in_reg_pat_yn' value="<%=acpt_appt_rfrl_in_reg_pat_yn%>">
<input type='hidden' name='IPinstall_yn' id='IPinstall_yn' value="<%=IPinstall_yn%>">
<input type='hidden' name='OPinstall_yn' id='OPinstall_yn' value="<%=OPinstall_yn%>">
<input type='hidden' name='OAinstall_yn' id='OAinstall_yn' value="<%=OAinstall_yn%>">
<input type='hidden' name='RDinstall_yn' id='RDinstall_yn' value="<%=RDinstall_yn%>">
<input type='hidden' name='toDayDate' id='toDayDate' value="<%=toDayDate%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='PatIdflag' id='PatIdflag'>

<script>
	if('<%=refIDDefaultValue%>'!=''&&"<%=acpt_appt_rfrl_in_reg_pat_yn%>"=="Y"){
		//chkrefIDValue(document.getElementById("refIDValue"));
		setTimeout("chkrefIDValue('"+document.getElementById("refIDValue")+"')",1500);
		}
</script>
	
</form>
<% 
	if(OptionBuffer != null && OptionBuffer.length() > 0)
	{
		OptionBuffer.delete(0,OptionBuffer.length());
	}
}catch(Exception e)
{
    out.println("Exception in main try"+e.getMessage());
}finally
{
	 if(con!=null) ConnectionManager.returnConnection(con,request);//Added By dharma
}
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

