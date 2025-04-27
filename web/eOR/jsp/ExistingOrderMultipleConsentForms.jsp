<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>

<html>
<title>
<fmt:message key="eOR.ConsentRequiredfor.label" bundle="${or_labels}"/>- <%=request.getParameter("order_catalog_desc")%>
</title>
<style>
TD.QRYEVEN1
{
    BACKGROUND-COLOR: #F0F0F2;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;

}

TD.QRYODD1
{
    BACKGROUND-COLOR: #E2E3F0;  
	BORDER-STYLE: none;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18px;	font-family: Verdana, Arial, Helvetica, sans-serif;	font-size: 8pt;	font-weight:normal;text-align:left;padding-left:10px;padding-right:10px;vertical-align:middle;border-bottom:1px;border-top:0px;border-left:0px;border-right:0px;border-style:solid;
}
</style>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_catalog_code = request.getParameter("order_catalog_code");
	order_catalog_code = (order_catalog_code == null) ? "":order_catalog_code;
	String order_catalog_desc = request.getParameter("order_catalog_desc");
	order_catalog_desc = (order_catalog_desc == null) ? "":order_catalog_desc;
	String order_category = request.getParameter("order_category");
	order_category = (order_category == null) ? "":order_category;
	String index = request.getParameter("index");
	index = (index == null) ? "":index;
	String viewBy	  = request.getParameter("viewBy");
	viewBy			  = (viewBy == null) ? "":viewBy;
	String function_from = request.getParameter("function_from");	
	function_from = (function_from == null) ? "":function_from;
	String order_id = request.getParameter("order_id");
	order_id = (order_id == null) ? "":order_id;
	String order_line_num = request.getParameter("order_line_num");
	order_line_num = (order_line_num == null) ? "1":order_line_num;
	String consent_type = request.getParameter("consent_type");
	consent_type = (consent_type == null) ? "":consent_type;
	String consent_form_id = request.getParameter("consent_form_id");
	consent_form_id = (consent_form_id == null) ? "":consent_form_id;
	boolean recbutton=false;
	boolean test=false;
	ArrayList multiConsentList = new ArrayList();
	ArrayList consentDetails = new ArrayList();
	String[] multiConsentValues = null;
	String[] consentDetailsValues = null;
	String[] multiConsentDtls = null;
	int tot_consents_avail=0;

	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";

	String bean_id1 = "Or_OrderCatalogMultiConsent" ;
	String bean_name1 = "eOR.OrderCatalogMultiConsent";
	String form_list="";
	String consent_req_bef_order="";
	String consent_req_bef_regn="";
	String form_id="";

	OrderCatalogMultiConsent bean1 = (OrderCatalogMultiConsent)getBeanObject( bean_id1,bean_name1,request ) ;  
	bean1.clear() ;
	bean1.setLanguageId(localeName);
	ArrayList catalogInfo = new ArrayList();
	catalogInfo = bean1.getCatalogInfo(order_catalog_code);
	form_list = (String) catalogInfo.get(0);
	//***consent_req_bef_order = (String) catalogInfo.get(1);
	//***consent_req_bef_regn = (String) catalogInfo.get(2);

	ConsentOrders bean		= (ConsentOrders)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String practitioner_id = (String)session.getValue("ca_practitioner_id");

	multiConsentDtls		= bean.MultiListDtls(order_catalog_code,practitioner_id);
	/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
	String multiConsentLine[] = new String[4];
	multiConsentLine=bean.MultiListConsentsLine(order_id,order_line_num);

	if(multiConsentDtls[0].equals("F"))
	{
		multiConsentList=bean.multiConsentDraftValues(order_catalog_code,order_id,order_line_num);
	}
	/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
	if(multiConsentList==null || multiConsentList.size()==0)
	{//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
		multiConsentList		= bean.MultiListConsentsForNew(order_catalog_code,order_id,order_line_num, practitioner_id);
	}//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
	consent_req_bef_order = (String) multiConsentLine[2];//added for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
	consent_req_bef_regn = (String) multiConsentLine[3];//added for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008

	int befOrder = Integer.parseInt(consent_req_bef_order);
	int befRegn = Integer.parseInt(consent_req_bef_regn);
	int total_consents=befOrder+befRegn;
	int Total=0;
%>
<form method="post" name="multiple_consent_form" id="multiple_consent_form">
<table cellpadding=0 cellspacing=0 border=0 width="100%" align=center class="grid">
<%
	//String consent_before_ord_release = "0";//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008 
	//String consent_before_ord_regis = "0";//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
	String slClassValue = "";
	String consent_req_bo= "";
	String consent_req_br= "";
	String consentStage="";
	String disable="enable";
	int cBO=0;
	int cBR=0;
	if(multiConsentDtls != null){
	//if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( (Integer.parseInt(multiConsentDtls[1]) > 1 || Integer.parseInt(multiConsentDtls[2]) > 1 ) || ( (Integer.parseInt(multiConsentDtls[1])+Integer.parseInt(multiConsentDtls[2])) > 0 ) )){//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
	if(multiConsentList.size() > 0 && multiConsentDtls.length > 0 && ( befOrder > 1 || befRegn > 1  || (befOrder+befRegn) > 0 ))
	{
		cBO=0;
		cBR=0;
		tot_consents_avail=0;
		for(int i=0;i<multiConsentList.size();i++)
		{
			slClassValue="gridData";
			multiConsentValues = (String[])multiConsentList.get(i);
			//****consent_before_ord_release = multiConsentValues[7];
			//****consent_before_ord_regis  = multiConsentValues[8];
			consentStage=multiConsentValues[3];
			form_id=multiConsentValues[1];
			if (multiConsentValues[10].equals("Y")) 
				disable="disabled";
			else 
				disable="enabled";
			//Total=Integer.parseInt(consent_before_ord_release)+Integer.parseInt(consent_before_ord_regis);//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
			Total=befOrder+befRegn;
			//if(multiConsentValues[6].equals("F")){//changed for SRR20056-SCF-2009  Id:  3736 date:05/06/2008
			if(multiConsentDtls[0].equals("F"))
			{
				if(i==0)
				{
%>
					<tr>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>:&nbsp;<label id='before_release'><%=order_catalog_desc%></label></B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B>(<fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=consent_req_bef_order%>,</label></B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>:&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label>)</B></td>
					<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'>&nbsp;</td>
					</tr>	
<%
				}
%>
			<tr>
			<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name="consent_chk<%=i%>" id="consent_chk<%=i%>" <%=(multiConsentValues[4].equals("Y")|| multiConsentValues[10].equals("Y"))? "checked":""%> <%=(multiConsentValues[4].equals("Y")|| multiConsentValues[10].equals("Y"))? "disabled":""%>></td>	
			<td class='<%=slClassValue%>' width='25%'>  
			<%=(i+1)%>.<B><font style="background-color:<%=multiConsentValues[10].equals("Y")?"#CC3300;":""%>">
			<%=multiConsentValues[2]%>
			</font></B></td>
			<input type=hidden name='consent_form_id<%=i%>' id='consent_form_id<%=i%>' value="<%=multiConsentValues[1]%>">
			<input type="hidden" name="consent_stage_temp<%=i%>" id="consent_stage_temp<%=i%>" value="<%=multiConsentValues[3]%>">
			<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="<%=multiConsentValues[2]%>">
			<input type="hidden" name="consent_desc<%=i%>" id="consent_desc<%=i%>" value="<%=multiConsentValues[2]%>">
			<td class='<%=slClassValue%>' width='25%'>  
			<select name='consent_stage<%=i%>' id='consent_stage<%=i%>' disabled>
<%
			if(!consentStage.equals("") && consentStage.equalsIgnoreCase("A"))
			{
				if(befOrder > 0 && befRegn==0)
				{
%>
					<option value='A' selected ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
<%
				}
				else
				{
%>
					<option value="" >  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
					<option value='A' selected ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
					<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
							
<%
				}
%>
				<input type='hidden' value="A" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
			}
			else if(!consentStage.equals("") && consentStage.equalsIgnoreCase("R"))
			{
				if(befOrder==0 && befRegn > 0)
				{
%>
					<option value='R' selected ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
<%
				}
				else
				{
%>
					<option value="" >  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
					<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
					<option value='R' selected ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
<%
				}
%>
				<input type='hidden' value="R" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
			}
			else
			{
				if(befOrder > 0 && befRegn==0)
				{
%>
					<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
					<input type='hidden' value="A" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
				}
				else if(befOrder==0 && befRegn > 0)
				{
%>
					<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<input type='hidden' value="R" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
				}
				else
				{
%>
					<option value="" >  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
					<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
					<option value='R'><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<input type='hidden' value="" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
				}
			}
%>
			</select>
			</td>
<%
			if(disable.equals("disabled"))
			{
				consentDetails  = bean.getConsents(order_id,order_line_num,form_id);
				for(int z=0;z<consentDetails.size();z++)
				{
					consentDetailsValues = (String[])consentDetails.get(z);
				}
					
%>
					<td class='<%=slClassValue%>' width='25%'><A class="gridLink" HREF="#" title='<fmt:message key="eOR.ClickLinkToPrintConsentDetails.label" bundle="${or_labels}"/>' onClick='callConsent("<%=order_id%>","<%=order_line_num%>","<%=consentDetailsValues[0]%>","<%=java.net.URLEncoder.encode(consentDetailsValues[1])%>","<%=consentDetailsValues[2]%>","<%=java.net.URLEncoder.encode(consentDetailsValues[3])%>","<%=consentDetailsValues[4]%>","<%=java.net.URLEncoder.encode(multiConsentValues[2])%>","<%=multiConsentValues[1]%>")'><img src="../../eCA/images/flow_text.gif" title='Preview'></img></a></td><!--ML-MMOH-SCF-1531-->
<%			}
			else
			{	
%>
				<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
<%			
			}
%>
			</tr>
<%	
		}

		if(multiConsentDtls[0].equals("V") && multiConsentList.size() > 0)
		{
			if(multiConsentValues[10].equals("N"))
				recbutton=true;
								
				if(i==0)
				{
					//consent_req_bo = multiConsentDtls[1];//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
					//consent_req_br = multiConsentDtls[2];//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
					consent_req_bo = consent_req_bef_order;//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
					consent_req_br = consent_req_bef_regn;//changed for SRR20056-SCF-2009  Id:  3736 dated:05/06/2008
%>
				<tr>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>:&nbsp;<label id='before_release'><%=order_catalog_desc%></label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B>(<fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=consent_req_bef_order%>,</label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>:&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label>)</B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'>&nbsp;</td>
				</tr>	
<%
				}					
%>
				<tr>
<%
				if(disable.equals("disabled"))
				{
%>
					<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name="consent_chk<%=i%>" id="consent_chk<%=i%>" <%=(multiConsentValues[4].equals("Y")|| multiConsentValues[10].equals("Y"))? "checked":""%> <%=(multiConsentValues[10].equals("Y")? "disabled":"")%> onclick='checkDefaultYn("<%=i%>",this,"V");' ></td>
					<td class='<%=slClassValue%>' width='25%'><B><label style='<%=(multiConsentValues[10].equals("Y")?"COLOR:#CC3300;":(multiConsentValues[9].equals("Y")? "COLOR:#009933":""))%>' class='<%=(multiConsentValues[9].equals("Y")? "":"label")%>' ><%=(i+1)%>.<%=multiConsentValues[2]%></label></B></td>
					<input type="hidden" name="consent_desc<%=i%>" id="consent_desc<%=i%>" value="<%=multiConsentValues[2]%>">
<%
				}
				else
				{
%>
					<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name="consent_chk<%=i%>" id="consent_chk<%=i%>" <%=(multiConsentValues[4].equals("Y")|| multiConsentValues[10].equals("Y"))? "checked":""%> <%=(multiConsentValues[10].equals("Y")? "disabled":"")%> onclick='checkDefaultYn("<%=i%>",this,"V");' ></td>
					<td class='<%=slClassValue%>' width='25%'><B><label style='<%=(multiConsentValues[10].equals("Y")?"COLOR:#CC3300;":(multiConsentValues[9].equals("Y")? "COLOR:#009933":""))%>' class='<%=(multiConsentValues[9].equals("Y")? "":"label")%>' ><%=(i+1)%>.</label></B>
					<input type="text" name="consent_desc<%=i%>" id="consent_desc<%=i%>" value="<%=multiConsentValues[2]%>"  onBlur="before_show_consent_window(this,'<%=i%>','<%=order_id%>','<%=order_line_num%>');">
					<input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_window(this,'<%=i%>','<%=order_id%>','<%=order_line_num%>');">
					</td>
<%
				}
%>
				<td class='<%=slClassValue%>' width='25%'><select name='consent_stage<%=i%>' id='consent_stage<%=i%>' <%=(multiConsentValues[10].equals("Y")? "disabled":"")%>  onChange='changeValue(this,"<%=i%>","V");'>	
<%
				if(Integer.parseInt(consent_req_bo)>0)
				{
					if(multiConsentValues[3].equals("A"))
					{
						cBO++;	
					}
					else if(multiConsentValues[3].equals("R"))
					{
						cBR++;
					}
				}

				if(Integer.parseInt(consent_req_br)>0)
				{
					if(multiConsentValues[3].equals("R"))
					{
						cBR++;
					}
					else if(multiConsentValues[3].equals("A"))
					{
						cBO++;	
					}
				}
%>
				<option value='A' <%=(multiConsentValues[3].equals("A")? "selected":"")%>  style='<%=(multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("A"))? "background-color:#009933;color:#FFFFFF":""))%>' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
				<option value='R' <%=(multiConsentValues[3].equals("R")? "selected":"")%> style='<%=(multiConsentValues[10].equals("Y")?"background-color:#CC3300;color:#FFFFFF":((multiConsentValues[9].equals("Y") && multiConsentValues[3].equals("R"))? "background-color:#009933;color:#FFFFFF":""))%>'><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option></select></td>
<%	
				if(disable.equals("disabled"))
				{
					consentDetails  = bean.getConsents(order_id,order_line_num,form_id);
					for(int z=0;z<consentDetails.size();z++)
					{
						consentDetailsValues = (String[])consentDetails.get(z);
					}
%>
					<td class='<%=slClassValue%>' width='25%'><A class="gridLink" HREF="#" title='<fmt:message 	key="eOR.ClickLinkToPrintConsentDetails.label" bundle="${or_labels}"/>' onClick='callConsent("<%=order_id%>","<%=order_line_num%>","<%=consentDetailsValues[0]%>","<%=java.net.URLEncoder.encode(consentDetailsValues[1])%>","<%=consentDetailsValues[2]%>","<%=java.net.URLEncoder.encode(consentDetailsValues[3])%>","<%=consentDetailsValues[4]%>","<%=java.net.URLEncoder.encode(multiConsentValues[2])%>")'><img src="../../eCA/images/flow_text.gif" title='Preview'></img></a></td><!--ML-MMOH-SCF-1531-->
<%
				}
				else
				{
%>
					<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
<%
				}
%>
				</tr>
				<input type='hidden' value="<%=multiConsentValues[1]%>" name="consent_form_id<%=i%>">
				<input type='hidden' value="<%=multiConsentValues[3]%>" name="consent_form_stage<%=i%>">
				<input type='hidden' value="<%=multiConsentValues[5]%>" name="order_sequence<%=i%>">
				<input type='hidden' value="<%=multiConsentValues[4]%>" name="default_chk<%=i%>">
				<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="<%=multiConsentValues[2]%>">
<%				
			}
			tot_consents_avail=i;
		}

		for(int i=tot_consents_avail+1;i<Total;i++)
		{

			test=true;
			recbutton=true;
%>
		<tr>
			<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name='consent_chk<%=i%>' id='consent_chk<%=i%>' value="Y" onclick='checkDefaultYn("<%=i%>",this,"VR");'></td>
			<td class='<%=slClassValue%>' width='25%'>  
			<%=(i+1)%>.<input type='text' name='consent_desc<%=i%>' id='consent_desc<%=i%>' value="" onBlur="before_show_consent_window(this,'<%=i%>','<%=order_id%>','<%=order_line_num%>');">
			<input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_window(this,'<%=i%>','<%=order_id%>','<%=order_line_num%>');"></td>
			<td class='<%=slClassValue%>' width='25%'><select name='consent_stage<%=i%>' id='consent_stage<%=i%>' onChange="checkStage('<%=total_consents%>','<%=i%>');changeValue(this,'<%=i%>','VR');">
<%
			if(befOrder>0 && cBO<befOrder)
			{
				cBO++;
%>
				<option value='A' selected><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
				<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
				<input type='hidden' value="A" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
			}
			else if(befRegn>0 && cBR<befRegn)
			{
				cBR++;	
%>
				<option value='A'><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
				<option value='R' selected><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
				<input type='hidden' value="R" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
			}
			else
			{
					
%>
					<option value='A'><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
					<option value='R'><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
					<input type='hidden' value="" name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>">
<%
			}
%>
			</select></td>
			<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
			</tr>
			<input type='hidden' value="" name="consent_form_id<%=i%>" id="consent_form_id<%=i%>">
			<input type='hidden' value="<%=i+1%>" name="order_sequence<%=i%>">
			<input type='hidden' value="Y" name="default_chk<%=i%>" id="default_chk<%=i%>">
			<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="">
<%
			tot_consents_avail=i+1;
				
		}
		if(!test)
			tot_consents_avail++;
			
%>
		<input type='hidden' value="<%=tot_consents_avail%>" name="tot_consents_avail">
<%	
	}
	else if(multiConsentDtls[0].equals("F") && multiConsentList.size() == 0)
	{
	%>
		<tr>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>:&nbsp;<label id='before_release'><%=order_catalog_desc%></label></B></td>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B>(<fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=consent_req_bef_order%>,</label></B></td>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>:&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label>)</B></td>
		<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'>&nbsp;</td>
		</tr>	
<!-- 	<tr>
	<td class="<%=slClassValue%>" colspan='4'><B><font><center><fmt:message key="eOR.ConsentsneedtobeattachforthisCatalog.label" bundle="${or_labels}"/></center></font></B></td>
	</tr> -->
<%
	cBO=0;
	cBR=0;
/*********SRR20056-SCF-2009  Id:  3736 *****start***05/06/2008****/
	for(int i=0;i<(befOrder+befRegn);i++)
	{
		test=true;
		recbutton=true;
%>
		<tr>
		<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name='consent_chk<%=i%>' id='consent_chk<%=i%>' value="Y" onclick='checkDefaultYn("<%=i%>",this,"VR");' checked disabled></td>
		<td class='<%=slClassValue%>' width='25%'>  
		<%=(i+1)%>.<input type='text' name='consent_desc<%=i%>' id='consent_desc<%=i%>' value="" onBlur="before_show_consent_lookup(this,'<%=i%>');">
		<input type='button' class="button" name="consent_button<%=i%>" id="consent_button<%=i%>" value="?" onClick="show_consent_lookup(this,'<%=i%>');"></td>
		<td class='<%=slClassValue%>' width='25%'><select name='consent_stage<%=i%>' id='consent_stage<%=i%>' onChange="checkStage('<%=total_consents%>','<%=i%>');changeValue(this,'<%=i%>','VR');">
<%
		if(befOrder>0 && cBO<befOrder)
		{
			cBO++;
%>
			<option value="A" selected><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
			<option value="R" ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
			<input type='hidden' name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>"  value="A">
<%
		}
		else if(befRegn>0 && cBR<befRegn)
		{
			cBR++;	
%>
			<option value="A"><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
			<option value="R" selected><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
			<input type='hidden'  name="consent_form_stage<%=i%>" id="consent_form_stage<%=i%>" value="R">
<%
		}
%>
		</select></td>
		<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
		</tr>
		<input type='hidden' value="" name="consent_form_id<%=i%>" id="consent_form_id<%=i%>">
		<input type='hidden' value="<%=i%>" name="order_sequence<%=i%>">
		<input type='hidden' value="Y" name="default_chk<%=i%>" id="default_chk<%=i%>">
		<input type="hidden" name="temp_consent_desc<%=i%>" id="temp_consent_desc<%=i%>" value="">
<%
		tot_consents_avail=i+1;
	}
/*********SRR20056-SCF-2009  Id:  3736 *****end***05/06/2008****/
%>
		<input type='hidden' value="<%=tot_consents_avail%>" name="tot_consents_avail">
<%
	} 
	else if(multiConsentDtls[0].equals("V") && multiConsentList.size() == 0)
	{
		recbutton=true;
		int BO=befOrder;
		int BR=befRegn;
			
			
		for(int j=0;j<total_consents;j++)
		{
			if (j==0)
			{
%>
				<tr>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/>:&nbsp;<label id='before_release'><%=order_catalog_desc%></label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B>(<fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/>:&nbsp;<label id='before_release'><%=consent_req_bef_order%>,</label></B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'><B><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/>:&nbsp;<label id='before_regist'><%=consent_req_bef_regn%></label>)</B></td>
				<td class='CAHIGHERLEVELCOLOR' style='border-right:0px;border-left:0px' width='25%'>&nbsp;</td>
				</tr>	
<%
			}

			if (BO>0)
			{
%>
				<tr>
				<td class='<%=slClassValue%>' width='25%'><input type="checkbox" name='consent_chk<%=j%>' id='consent_chk<%=j%>' value="Y" onclick='checkDefaultYn("<%=j%>",this,"VR");'></td>
				<td class='<%=slClassValue%>' width='25%'>  
				<%=(j+1)%>.<input type='text' name='consent_desc<%=j%>' id='consent_desc<%=j%>' value="" onBlur="before_show_consent_lookup(this,'<%=j%>');">
				<input type='button' class="button" name="consent_button<%=j%>" id="consent_button<%=j%>" value="?" onClick="show_consent_lookup(this,'<%=j%>');"></td>
				<td class='<%=slClassValue%>' width='25%'><select name='consent_stage<%=j%>' id='consent_stage<%=j%>' onChange="checkStage('<%=total_consents%>','<%=j%>');changeValue(this,'<%=j%>','VR');">
<%
				if(befOrder>0)
				{
%>
					<option value='A' selected><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
<%
				}

				if(befRegn>0)
				{
%>
					<option value='R' ><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
<%
				}
%>
				</select></td>
				<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
			</tr>
			<input type='hidden' value="" name="consent_form_id<%=j%>" id="consent_form_id<%=j%>">
			<input type='hidden' value="A" name="consent_form_stage<%=j%>" id="consent_form_stage<%=j%>">
			<input type='hidden' value="<%=j%>" name="order_sequence<%=j%>">
			<input type='hidden' value="Y" name="default_chk<%=j%>" id="default_chk<%=j%>">
			<input type="hidden" name="temp_consent_desc<%=j%>" id="temp_consent_desc<%=j%>" value="">
<%			
			BO--;}
			else if(BR>0)
			{
%>
				<tr>
				<td class='<%=slClassValue%>' width='25%'>
				<input type="checkbox" name='consent_chk<%=j%>' id='consent_chk<%=j%>' value="Y" onclick='checkDefaultYn("<%=j%>",this,"VR");'>
				</td>
				<td class='<%=slClassValue%>' width='25%'>  
				<%=(j+1)%>.<input type='text' name='consent_desc<%=j%>' id='consent_desc<%=j%>' value="" onBlur="before_show_consent_lookup(this,'<%=j%>');">
				<input type='button' class="button" name="consent_button<%=j%>" id="consent_button<%=j%>" value="?" onClick="show_consent_lookup(this,'<%=j%>');"></td>
				<td class='<%=slClassValue%>' width='25%'>
					<select name='consent_stage<%=j%>' id='consent_stage<%=j%>' onChange="checkStage('<%=total_consents%>','<%=j%>');changeValue(this,'<%=j%>','VR');">
<%
				if(befOrder>0)
				{
%>
					<option value='A' ><fmt:message key="eOR.BeforeOrderRelease.label" bundle="${or_labels}"/></option>
<%
				}
				
				if(befRegn>0)
				{
%>
					<option value='R' selected><fmt:message key="eOR.BeforeOrderRegistration.label" bundle="${or_labels}"/></option>
<%
				}
%>
				</select>
				</td>
				<td class='<%=slClassValue%>' width='25%'>&nbsp;</td>
				</tr>
				<input type='hidden' value="" name="consent_form_id<%=j%>" id="consent_form_id<%=j%>">
				<input type='hidden' value="R" name="consent_form_stage<%=j%>" id="consent_form_stage<%=j%>">
				<input type='hidden' value="<%=j%>" name="order_sequence<%=j%>">
				<input type='hidden' value="Y" name="default_chk<%=j%>" id="default_chk<%=j%>">
				<input type="hidden" name="temp_consent_desc<%=j%>" id="temp_consent_desc<%=j%>" value="">
<%			
				BR--;
			}
			tot_consents_avail=j;
		}
		tot_consents_avail++;
		}
	}else
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}
%>
</table>
<Input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
<Input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
<Input type='hidden' name='dupilcate' id='dupilcate' value='flase'>
<input type="hidden" name="consent_sql" id="consent_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND")%>">
<Input type='hidden'name='function_from' value='EXISTING_MULTI_CONSENT'>
<Input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
<Input type='hidden' name='order_id' id='order_id' value='<%=order_id%>'>
<Input type='hidden' name='order_line_num' id='order_line_num' value='<%=order_line_num%>'>
<Input type='hidden' name='ord_catalog_code' id='ord_catalog_code' value='<%=order_catalog_code%>'>
<Input type='hidden' name='index' id='index' value='<%=index%>'>
<Input type='hidden' name='mode' id='mode' value='1'>
<Input type='hidden' name='report_type' id='report_type' value='C'>
<Input type='hidden' name='befOrder' id='befOrder' value='<%=befOrder%>'>
<Input type='hidden' name='befRegn' id='befRegn' value='<%=befRegn%>'>
<Input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'>
<Input type='hidden' name='consent_type' id='consent_type' value='<%=consent_type%>'>
<Input type='hidden' name='total_consents_req' id='total_consents_req' value='<%=total_consents%>'>
<Input type='hidden' name='recbutton' id='recbutton' value='<%=recbutton%>'>
<Input type='hidden' name='viewBy' id='viewBy' value='<%=viewBy%>'>
<Input type='hidden' name='total_consents_available' id='total_consents_available' value='<%=tot_consents_avail%>'>
<Input type='hidden' name='temp_consent_form_id' id='temp_consent_form_id' value=''>
<Input type='hidden' name='temp_consent_desc' id='temp_consent_desc' value=''>
<Input type='hidden' name='temp_temp_consent_desc' id='temp_temp_consent_desc' value=''>
<script>
	parent.multi_btn.location.href = "../../eOR/jsp/ExistingOrderMultipleConsentButtons.jsp?<%=request.getQueryString()%>&consent_type=<%=consent_type%>&total_consents=<%=total_consents%>&recbutton=<%=recbutton%>";
</script>
</form>
</body>

</html>
	
<%
	putObjectInBean(bean_id,bean,request);

}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}	
%>

