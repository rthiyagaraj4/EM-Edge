<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
04/09/2012    IN034888        Menaka V     CRF-CA- Bru-HIMS-CRF-121/01-Only One Orderable is displayed
---------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	<title><fmt:message key="Common.Consent.label" bundle="${common_labels}"/> <fmt:message key="Common.details.label" bundle="${common_labels}"/> --<%=patient_details%></title>
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
</head>

<body Onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0'; 
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%

	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

String pat_name_def			= request.getParameter( "pat_name_def");
String patient_name			= request.getParameter( "patient_name" ) ;
String practitioner_name	= request.getParameter( "practitioner_name" ) ;
String order_pract_name		= request.getParameter( "order_pract_name" ) ;
String curr_sys_date		= request.getParameter( "curr_sys_date" ) ;
String remarks				= request.getParameter( "remarks" ) ;
String ord_id				= request.getParameter("ord_id");
//String Consent_detail		= request.getParameter("Consent_detail");
//String flag					= request.getParameter("flag");
String self					= request.getParameter("self");
String pract_id				= request.getParameter("pract_id");
String relation				= request.getParameter("relation");
String relation_text		= request.getParameter("relation_text");
String index			    = request.getParameter("index");
String order_catalog_cd		= request.getParameter("orderable_val");
//String catalog_code			= "";
String patient_id			= request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id");
String facility_id			= (String)session.getValue("facility_id");
String order_line_num		= request.getParameter("ord_line_num");
String consent_frm_id		= request.getParameter("consent_frm_id");
String task_categ				= request.getParameter("task_categ"); // EMR - Ramesh 

//if(order_catalog_cd == null || order_catalog_cd.equals("null")) order_catalog_cd =""; else order_catalog_cd = order_catalog_cd.trim();
 //out.println("<script>alert('order_catalog_cd--"+order_catalog_cd+"')</script>");
// if(Consent_detail == null){
// }
if(self == null || self.equals("null")) self =""; else self = self.trim();
if(patient_id == null || patient_id.equals("null")) patient_id =""; else patient_id = patient_id.trim();
if(encounter_id == null || encounter_id.equals("null")) encounter_id =" "; else encounter_id = encounter_id.trim();
if(patient_name == null || patient_name.equals("null")) patient_name =" "; else patient_name = patient_name.trim();
if(practitioner_name == null || practitioner_name.equals("null")) practitioner_name =" "; else practitioner_name = practitioner_name.trim();
if(order_pract_name == null || order_pract_name.equals("null")) order_pract_name =" "; else order_pract_name = order_pract_name.trim();
if(curr_sys_date == null || curr_sys_date.equals("null")) curr_sys_date =" "; else curr_sys_date = curr_sys_date.trim();
if(remarks == null || remarks.equals("null")) remarks =" "; else remarks = remarks.trim();
if(ord_id == null || ord_id.equals("null")) ord_id =" "; else ord_id = ord_id.trim();

if(pract_id == null || pract_id.equals("null")) pract_id =" "; else pract_id = pract_id.trim();
if(relation == null || relation.equals("null")) relation =" "; else relation = relation.trim();
if(relation_text == null || relation_text.equals("null")) relation_text =" "; else relation_text= relation_text.trim();
if(pat_name_def == null || pat_name_def.equals("null")) pat_name_def =" "; else pat_name_def = pat_name_def.trim();
if(order_line_num == null ) order_line_num =""; 
if(consent_frm_id == null) consent_frm_id =""; 

 
/*
if(remarks != ""){
	//remarks = java.net.URLDecoder.decode(remarks);
}
*/
//String ConsentFormId="";
ArrayList ConsentFormId = null;
String order_catalog_code = ""; //String Consent_detail="";
StringBuffer order_catalog_desc = new StringBuffer();
StringBuffer order_consent_format  = new StringBuffer();
String consent_format	  = "";
StringBuffer order_consent_id= new StringBuffer();
String consent_form_id	  = "";
StringBuffer order_consent_form_label = new StringBuffer();
String consent_form_label = "",  old_consent_format_id	  = "";
String first_consent_format_id  = "";

StringBuffer new_consent_format_id = new StringBuffer();
StringBuffer new_consent_format_label = new StringBuffer();

//HashMap consentCatalog = new HashMap();

//if(flag.equals("yes") ){
	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id,  bean_name, request ) ;
		bean.setLanguageId(localeName);
		//bean.clearHash();	 
		//ConsentFormId = bean.getFormId(ord_id) ;
		//if(ConsentFormId == null) ConsentFormId ="";
		ConsentFormId = bean.getFormId(ord_id);
		if(order_line_num.equals("") || consent_frm_id.equals("")){
			ConsentFormId = bean.getFormId(ord_id);
		}else{
			
			ConsentFormId = bean.getFormId(ord_id,order_line_num,consent_frm_id);
		}
		HashMap consent= (HashMap)bean.getConsentDetail();
 		String consent_details = "";
		ArrayList consent_ids = new ArrayList(); //--[IN034888]
 		if(ConsentFormId.size()>0){
			//--[IN034888]-Commentted - Start
			/*for(int j=0; j<ConsentFormId.size(); j++)
			{
				
				String[] records = (String[]) ConsentFormId.get(j);
				if(records[0]!=null && !records[0].equals("") && !records[0].equals(old_consent_format_id))
				{
					if(consent!=null && consent.size()>0 )
						consent_details = (String)consent.get(index+records[0].trim());
  					if(consent==null || consent_details==null || consent_details.equals("")  )
					{
						if(patient_id.equals(""))
						{
							if(!patient_details.equals(""))
							{
								patient_id = patient_details.substring((patient_details.indexOf(",ID:")+4));
								if(patient_id == null || patient_id.equals("null")) 
									patient_id =""; 
								else 
									patient_id = patient_id.trim();
							}
						}						
						bean.getConsentDetail(records[0].trim(),index,   records[3],   patient_id, facility_id, encounter_id, ord_id) ;		
 					}

 					if(first_consent_format_id==null || first_consent_format_id.equals("")){
						first_consent_format_id = records[0].trim();
 					}
					//order_catalog_code += records[1]+"||"; 
					order_catalog_desc.append(records[2]+"||"); 
					if(order_catalog_desc==null) order_catalog_desc.append("~~");
					order_consent_format.append(records[3]+"||"); 
					if(order_consent_format==null) order_consent_format.append("~~");
					order_consent_id.append(records[0]+"||"); 
					if((order_consent_id==null)|| (order_consent_id.equals(""))) order_consent_id.append("~~");
					order_consent_form_label.append(records[4]+"||"); 
					if(order_consent_form_label==null) order_consent_form_label.append("~~");
 
  					//Consent_detail = (String)consent.get(index+records[0]);
 					//if(Consent_detail==null){
					//	Consent_detail= "";
					//	bean.getConsentDetail(records[0].trim(),index, records[1]) ;
					//}
					old_consent_format_id = records[0];
					consent_ids.add(records[0]);
				} else
				{  //concatenate the description
					// THEN REMOVE THE LAST || TO APPEND THE DESCRIPTION
					if(!consent_ids.contains(records[0]))
					{
					
				if(order_catalog_desc.lastIndexOf("||")!=-1) {
												
						order_catalog_desc.append(order_catalog_desc.substring(0,order_catalog_desc.lastIndexOf("||")));
					}	
				}
  					order_catalog_desc.append(","+records[2]);  //order_catalog_description
				}
 	 		}*/ //--[IN034888]-Commentted - End
			//--[IN034888] - Start
			for(int j=0; j<ConsentFormId.size(); j++)
			{
				String[] records = (String[]) ConsentFormId.get(j);

				if(!consent_ids.contains(records[0]))
				{
										if(consent!=null && consent.size()>0 )
						consent_details = (String)consent.get(index+records[0].trim());
  					if(consent==null || consent_details==null || consent_details.equals("")  )
					{
						if(patient_id.equals(""))
						{
							if(!patient_details.equals(""))
							{
								patient_id = patient_details.substring((patient_details.indexOf(",ID:")+4));
								if(patient_id == null || patient_id.equals("null")) 
									patient_id =""; 
								else 
									patient_id = patient_id.trim(); 
							}
						}						
						bean.getConsentDetail(records[0].trim(),index,   records[3],   patient_id, facility_id, encounter_id, ord_id) ;		
 					}

 					if(first_consent_format_id==null || first_consent_format_id.equals("")){
						first_consent_format_id = records[0].trim();
 					}
					order_catalog_desc.append(records[2]);
					if(order_catalog_desc==null) order_catalog_desc.append("~~");
					order_consent_format.append(records[3]+"||"); 
					if(order_consent_format==null) order_consent_format.append("~~");
					order_consent_id.append(records[0]+"||"); 
					if((order_consent_id==null)|| (order_consent_id.equals(""))) order_consent_id.append("~~");
					order_consent_form_label.append(records[4]+"||"); 
					if(order_consent_form_label==null) order_consent_form_label.append("~~");
					consent_ids.add(records[0]);
				}
				else
				{
					order_catalog_desc.append(",");
					order_catalog_desc.append(records[2]);
				}
			} //--[IN034888] - End
 			//bean.setCatalogDetail(index, order_catalog_code);
		}
		putObjectInBean(bean_id,bean,request);	
//}

 %>
<form name='formConsentOrderable' id='formConsentOrderable'  action="../../eOR/jsp/ConsentNotesValidate.jsp" method='POST'>

<table cellpadding=3 cellspacing=0 border='0' width="100%" height="100%" align="center">
<tr>

<td colspan='3' class="Label" >
<%	int j=0;
	if(!order_consent_id.equals("")){%>
		<table cellpadding=3 cellspacing=0 border=1 width="100%">
		<tr>
			<td class=COLUMNHEADER width='50%' colspan=''> <font size="1"><b><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></b></font> </td>
			<td class=COLUMNHEADER width='50%'><font size="1"><B><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></B></font><!--<input type="checkbox" name="cat_chk" id="cat_chk" onClick='selectAll("")'>--></td>
				
		</tr>
		</table>
		
<%
	 //StringTokenizer stOrder = new StringTokenizer(order_catalog_code,"||");
	 StringTokenizer stOrder1 = new StringTokenizer(order_catalog_desc.toString(),"||");
     StringTokenizer stOrder2 = new StringTokenizer(order_consent_format.toString(),"||");
     StringTokenizer stOrder3 = new StringTokenizer(order_consent_id.toString(),"||");
     StringTokenizer stOrder4 = new StringTokenizer(order_consent_form_label.toString(),"||");
	 
	
	 String catalog_desc="";
	 String classvalue="";
	 //while(stOrder.hasMoreTokens())
	 while(stOrder3.hasMoreTokens())
	 {
		// catalog_code	= stOrder.nextToken();
		if(stOrder1.hasMoreTokens())
		 catalog_desc	= stOrder1.nextToken();
		 if(catalog_desc!=null && catalog_desc.equals("~~")) catalog_desc = "";
		 consent_format = stOrder2.nextToken();
		 if(consent_format!=null && consent_format.equals("~~")) consent_format = "";
 		 consent_form_id= stOrder3.nextToken();
		 consent_form_label= stOrder4.nextToken();
		 new_consent_format_id.append(consent_form_id+"||"); 
 		 new_consent_format_label.append(consent_form_label+"||");

		 if(consent_form_id==null || consent_form_id.equals("~~")) consent_form_id = "";

		 if(consent_form_label==null || consent_form_label.equals("~~") || consent_form_label.length()==0 || consent_form_label.equals("null") ) consent_form_label = "";
//		 out.println("consent_form_label  " + consent_form_label);

			// Consent = (String)consent.get(index+catalog_code);
		/*if(j%2==0)
			classvalue="QRYODD";
		else
			classvalue="QRYEVEN";*/
			classvalue="gridData";
	
%>
	<table cellpadding=3 cellspacing=0 border=1 width="100%" class="grid">
	<tr> 
		<td class="<%=classvalue%>" colspan='' width='50%' ><font size="1"><%=catalog_desc%></font></td>

		<td class="<%=classvalue%>" width='50%' ><font size="1"><A class='gridLink' href='javascript:consentNotes("<%=consent_form_id%>")')><%=((consent_form_label==null||consent_form_label.equals(""))?consent_form_id:consent_form_label)%></a></font><!--<input type="checkbox" name="chk<%=j%>" id="chk<%=j%>" onClick='chkValidate(<%=j%>)'>--></td>
	</tr>
		<input type=hidden name='catalog_cd<%=j%>' id='catalog_cd<%=j%>' value=''>

<%	j++; }
}%></table>
</td>
		<input type=hidden name='cat_cnt' id='cat_cnt' value='<%=j%>'>
		<input type='hidden' name='orderable_chk' id='orderable_chk' value='<%=order_catalog_cd==null?order_catalog_code:order_catalog_cd%>'>
		<input type='hidden' name="query_string" id="query_string" value="<%=request.getQueryString()%>">
		 
  		<input type="hidden" name="new_consent_format_id" id="new_consent_format_id" value="<%=new_consent_format_id%>">
		<input type="hidden" name="new_consent_format_label" id="new_consent_format_label" value="<%=new_consent_format_label%>">
		<!-- EMR - Ramesh  --->
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="index" id="index" value="<%=index%>">
		<input type="hidden" name="task_categ" id="task_categ" value="<%=task_categ%>">
		<!-- EMR - Ramesh --->

</tr>



</table>
 		<%	
		if(first_consent_format_id!=null && !first_consent_format_id.equals("")) {  %>
				<script>consentNotes("<%=first_consent_format_id%>")</script>
		<% }	%>
</form>
</body>
</html>
<script>//selectAll('load');</script>


 

