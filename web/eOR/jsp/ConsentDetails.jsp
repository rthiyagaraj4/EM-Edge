<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--ConsentDetails.jsp-->  

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<% String patient_details= request.getParameter("patientdetails");
if(patient_details == null || patient_details.equals("null")) patient_details =" "; else patient_details = patient_details.trim();
%>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	<title><fmt:message key="Common.ConsentDetails.label" bundle="${common_labels}"/> --<%=patient_details%></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script type="text/javascript" 	src="../../eCommon/js/CommonCalendar.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	

	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eOR/js/ConsentDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
</head>

<body Onload='FocusFirstElement();disableText()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<!--,listbox()-->



<%

	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

String pat_name_def			= request.getParameter( "pat_name_def");
String patient_name			= request.getParameter( "patient_name" ) ;
String practitioner_name	= request.getParameter( "practitioner_name" ) ;
//String order_pract_name		= request.getParameter( "order_pract_name" ) ;
String curr_sys_date		= request.getParameter( "curr_sys_date" ) ;
String remarks				= request.getParameter( "remarks" ) ;
String ord_id				= request.getParameter("ord_id");
String Consent_detail		= request.getParameter("Consent_detail");
//String flag					= request.getParameter("flag");
String self					= request.getParameter("self");
String pract_id				= request.getParameter("pract_id");
String relation				= request.getParameter("relation");
String relation_text		= request.getParameter("relation_text");
String index			    = request.getParameter("index");
String practitioner_id		= "";
//String catalog_code			= "";
 
// if(Consent_detail == null){
//out.println("<script>alert('Consent_detail--"+Consent_detail+"')</script>");
// }


if(self == null || self.equals("null")) self =""; else self = self.trim();
if(patient_name == null || patient_name.equals("null")) patient_name =" "; else patient_name = patient_name.trim();
//if(practitioner_name == null || practitioner_name.equals("null")) practitioner_name =" "; else 
if (practitioner_name==null||practitioner_name.equals("null")||practitioner_name=="")
	 {
		 practitioner_name="";
	 }
	 //commented by uma on 5/11/2007
	// practitioner_name = practitioner_name.trim();
	 //practitioner_name = java.net.URLDecoder.decode(practitioner_name,"UTF-8");
practitioner_name = practitioner_name.trim();
practitioner_name = practitioner_name;
//if(order_pract_name == null || order_pract_name.equals("null")) order_pract_name =" "; else order_pract_name = order_pract_name.trim();
if(curr_sys_date == null || curr_sys_date.equals("null")) curr_sys_date =" "; else curr_sys_date = curr_sys_date.trim();
if(remarks == null || remarks.equals("null")) remarks =" "; else remarks = remarks.trim();
if(ord_id == null || ord_id.equals("null")) ord_id =" "; else ord_id = ord_id.trim();

if(pract_id == null || pract_id.equals("null")) pract_id =" "; else pract_id = pract_id.trim();
if(relation == null || relation.equals("null")) relation =" "; else relation = relation.trim();
if(relation_text == null || relation_text.equals("null")) relation_text =" "; else relation_text= relation_text.trim();
if(pat_name_def == null || pat_name_def.equals("null")) pat_name_def =" "; else pat_name_def = pat_name_def.trim();

	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name ,request ) ;
	bean.setLanguageId(localeName);
	// Get the Patient Details if stored from the bean
 	HashMap patientDetails= (HashMap)bean.getPatientDetail();
 	ArrayList patient_info= null;
	if(patientDetails!=null && patientDetails.size()!=0)
	{
		patient_info		= (ArrayList)patientDetails.get(index);
		if(patient_info!=null && patient_info.size() > 0)
		{
			patient_name		= (String)patient_info.get(0); 
 			practitioner_name	= (String)patient_info.get(1); 
			relation			= (String)patient_info.get(2); 
			curr_sys_date		= (String)patient_info.get(3); 
			remarks				= (String)patient_info.get(4); 
			practitioner_id		= (String)patient_info.get(5); 
			self				= (String)patient_info.get(6); 
		}
	}
	if(pract_id.equals("") || pract_id.equals(" "))
		pract_id			= practitioner_id;
	if(practitioner_id==null || practitioner_id.equals(""))
		practitioner_id			= pract_id;
		
	patient_name = patient_name.replaceAll("&", "&amp;");
	patient_name = patient_name.replaceAll(">", "&gt;");
	patient_name = patient_name.replaceAll("<", "&lt;");
	patient_name = patient_name.replaceAll("'", "&apos;");
	patient_name = patient_name.replaceAll("\"", "&quot;");
	
/*System.out.println("###pat_name_def="+pat_name_def);
System.out.println("###patient_name="+patient_name);
System.out.println("###practitioner_name="+practitioner_name);
System.out.println("###curr_sys_date="+curr_sys_date);
System.out.println("###remarks="+remarks);
System.out.println("###ord_id="+ord_id);
System.out.println("###Consent_detail="+Consent_detail);
System.out.println("###self="+self);
System.out.println("###pract_id="+pract_id);
System.out.println("###relation="+relation);
System.out.println("###relation_text="+relation_text);
System.out.println("###index="+index);
System.out.println("###practitioner_id="+practitioner_id);
/*
if(remarks != ""){
	//remarks = java.net.URLDecoder.decode(remarks);
}
*/
//String ConsentFormId="";
/*ArrayList ConsentFormId = null;
String order_catalog_code = "",order_catalog_desc = ""; //String Consent_detail="";
//HashMap consentCatalog = new HashMap();

if(flag.equals("yes") ){
	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name ,request ) ;
		//bean.clearHash();	 
		//ConsentFormId = bean.getFormId(ord_id) ;
		//if(ConsentFormId == null) ConsentFormId ="";
		ConsentFormId = bean.getFormId(ord_id);
		
		HashMap consent= (HashMap)bean.getConsentDetail();
		
		if(ConsentFormId.size()>0){
			for(int j=0; j<ConsentFormId.size(); j++)
			{
				String[] records = (String[]) ConsentFormId.get(j);
 				if(records[0]!=null && !records[0].equals("")){
//out.println(" records[1]"+ records[1]);
					if(Consent_detail==null){
				bean.getConsentDetail(records[0].trim(),index, records[1]) ;		
					}
					order_catalog_code += records[1]+"||"; 
					order_catalog_desc += records[2]+"||";    
					Consent_detail = (String)consent.get(index+records[1]);
*/					
				/*	if(Consent_detail==null){
						Consent_detail= "";
						bean.getConsentDetail(records[0].trim(),index, records[1]) ;
					}*/
/*				}
	 		}
 			//bean.setCatalogDetail(index, order_catalog_code);
		}
	putObjectInBean(bean_id,bean,request);
}
*/
%>
<form name='formConsentDetails' id='formConsentDetails'  action="../../eOR/jsp/ConsentNotesValidate.jsp" method='POST'>
<table cellpadding=3 cellspacing=0 border='0' width="100%" height="100%" align="center">
<%--
	<tr>
		<td  class='label' id='ordering_pract'  width='2%' colspan="0"  align=center><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='data' colspan=3 id="ordering_pract_name" width='5%'><%=//order_pract_name%><input type=hidden name='ord_pract' id='ord_pract' value='<%=//order_pract_name%>'> </td>
		<td></td>
		</tr>
		<tr>
		<td  class='labelleft' id='consent'  colspan="0" width='2%'> <fmt:message key="Common.Consent.label" bundle="${common_labels}"/> </td>
		<td class='labelleft' onClick='javascript:consentNotes("<%=//ord_id%>")'><font size=1><A class='gridLink' id='consent' href='#'><fmt:message key="eOR.ConsentNotes.label" bundle="${or_labels}"/></A></td>
		<td></td>	
	</tr>
--%>
<tr>
	<td class=COLUMNHEADER colspan='5' ><B><fmt:message key="eOR.ConsentInformation.label" bundle="${or_labels}"/> </B></td>
</tr>
<tr>
 <td class='fields' id='radio1'><input type='radio' name='self' id='self' value='y' <%if(self.equals("") || self.equals("y")){%>checked <%}%> OnClick='disableText()'><fmt:message key="Common.self.label" bundle="${common_labels}"/><input type='radio' name='self' id='self' value='n' OnClick='enableText()' <%if(self.equals("n")){%>checked<%}%>><fmt:message key="Common.others.label" bundle="${common_labels}"/>
 <font size="1"><a class="gridLink" href="#" onClick="copyDetails('self')"> <fmt:message key="Common.Copy.label" bundle="${common_labels}"/> </a></font>
 </td><td colspan=3></td></tr>
  <tr><td class='labelleft' id='pat_name'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td><td class='fields'><input type='text' name='patient_name' id='patient_name' value='<%=patient_name%>' size="20" maxlength="200"><img src="../../eCommon/images/mandatory.gif" align=center><div><font size="1"><a class="gridLink" href="#" onClick="copyDetails(document.formConsentDetails.patient_name)"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div>
  </td>
	<%if(self.equals("") || self.equals("y")){%>
		<td class='labelleft'><div id="rel" style="visibility:hidden"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></div></td><td class='fields'><div id="rel1" style="visibility:hidden"><SELECT name="reln_box" id="reln_box" ><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ----- 		
<%
			ArrayList RelationData = bean.getRelationData() ;
			for( int i=0 ; i< RelationData.size() ; i++ ) {
			String[] record = (String[])RelationData.get(i);
			if(record[1]!=null && record[1].equals(relation)) {
%>
				<option value="<%=record[1]%>" selected><%=record[0]%></option>
<%			} else { %>
				<option value="<%=record[1]%>"><%=record[0]%></option>
<%			}
		}
%> 
		</SELECT>
		<div><font size="1"><a class="gridLink" href="#" onClick="copyDetails('relation')"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div></div></td>
		
	
		<%}else if(self.equals("n")){%>
		<td class='labelleft'><div id="rel" style="visibility:visible"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></div></td><td class='fields'><div  id="rel1" style="visibility:visible"><SELECT name="reln_box" id="reln_box"  >
 				<!--<option value="<%=relation%>" selected><%=relation_text%></option> -->
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			ArrayList RelationData = bean.getRelationData() ;

			for( int i=0 ; i< RelationData.size() ; i++ ) {
			String[] record = (String[])RelationData.get(i);
			if(record[1]!=null && record[1].equals(relation)) {
%>
				<option value="<%=record[1]%>" selected><%=record[0]%></option>
<%			} else { %>
				<option value="<%=record[1]%>"><%=record[0]%></option>
<%			}
		}
%>		 </SELECT>
			 <div><font size="1"><a class="gridLink" href="#" onClick="copyDetails('relation')"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div></div></td>
			
			<%}%>
			
</tr>
<tr>
	<td  class='labelleft' id='date_time' ><fmt:message key="eOR.ConsentedDateandTime.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='text'  name='dat_time' id='dat_time' value='<%=curr_sys_date%>'    size="16" maxlength="16" onBlur="datetimecheck(this)" onKeyPress='return CheckSpecCharsCols(event)' ><img src="../../eCommon/images/mandatory.gif" align=center><div><font size="1"><a class="gridLink" href="#" onClick="copyDetails(document.formConsentDetails.dat_time)"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div></td>
	<td class='labelleft' id='pract_name'><fmt:message key="eOR.ObtainedByPractitioner.label" bundle="${or_labels}"/> </td>
	<td class='fields'><input type='text'  name='Practioner_name' id='Practioner_name' value='<%=practitioner_name%>' onBlur="onblur_pract_disp(this)" size="20" maxlength=""><input  class='button' type=button name=search value='?'  class=button onClick="practitioner_display(Practioner_name)"><img src="../../eCommon/images/mandatory.gif" align=center><div><font size="1"><a class="gridLink" href="#" onClick="copyDetails(document.formConsentDetails.Practioner_name)"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div></td> 
</tr>
<tr>
	<td  class='labelleft' id=''><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' height="20%" width='2%'><textarea cols="30" rows="2" name="remarks" id=""  onBlur="SPCheckMaxLen('Remarks',this,500,'')" onkeyPress='return checkMaxLimit(this,500)'><%=remarks%></textarea><div><font size="1"><a class="gridLink" href="#" onClick="copyDetails(document.formConsentDetails.remarks)"><fmt:message key="Common.Copy.label" bundle="${common_labels}"/></a></font></div></td><td colspan=3></td>
 </tr>

<!--<tr>
	<td></td><td colspan="3">&nbsp;</td><td  align='right' valign='bottom' >&nbsp;&nbsp;<INPUT TYPE='button' value='OK' class='button' Onclick='onClose();'>&nbsp;&nbsp;<INPUT TYPE='button' value='Close' class='button' onClick='Close()'></td></tr>-->
</table>

<input type="hidden" name="practitioner_code_sql" id="practitioner_code_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_USER_FOR_REVIEW_PRACTITIONER_LOOKUP") %>">
<input type='hidden' name='practitionerId' id='practitionerId' value='<%=practitioner_id%>'> <!-- returned frm commonlkup-->
<input type='hidden' name='pract_id' id='pract_id' value='<%=pract_id%>'> <!-- returned frm main jsp-->
<input type='hidden' name='pat_name' id='pat_name' value="<%=patient_name%>">
<input type='hidden' name='pat_name_def' id='pat_name_def' value="<%=pat_name_def%>">
<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<input type='hidden' name='self1' id='self1' value='<%=self%>'>
<input type='hidden' name='relation' id='relation' value='<%=relation%>'>
<input type='hidden' name='Consent_detail' id='Consent_detail' value='<%=Consent_detail%>'>
<!--added by Dinesh T on 11/19/2010 for incident no 25051, starts-->
<input type='hidden' name='locale' id='locale' value='<%=localeName%>'>
<!--25051, ends-->

<input type='hidden' name='index' id='index' value='<%=index%>'>
<input type='hidden' name='flag' id='flag' value=''>
<input type='hidden' name="relation_name" id="relation_name" value="">
<input type='hidden' name="curr_sys_date" id="curr_sys_date" value="<%=curr_sys_date%>">

</form>
<body>
</html>
<script>onLoadChk();</script>

