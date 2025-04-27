<!DOCTYPE html>
   <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String selected1="";
	String selected2="";
	String selected3="";
	String disabled="";
	String optValue = "";
	String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	iv_prep_yn=iv_prep_yn.trim();
    String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String iv_prep_default  = request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
	String order_set_code   = request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("patient_class");
	String act_patient_class= request.getParameter("act_patient_class");
	if(patient_class == null || patient_class.equals(""))
		patient_class = act_patient_class;
	String start_date		= request.getParameter("start_date")==null?"":request.getParameter("start_date");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String MAR_app_yn		= request.getParameter("MAR_app_yn") == null ? "Y":request.getParameter("MAR_app_yn");
	String atc_allergy_alert_level		= request.getParameter("atc_allergy_alert_level") == null ? "N":request.getParameter("atc_allergy_alert_level");
	String amendOrNot		= "";

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
	bean.setATCAllergyLevel(atc_allergy_alert_level);

	bean.setLanguageId(locale);
	String resp_id		= request.getParameter("resp_id");
		if(resp_id == null) resp_id="";
//	String pract_id		= request.getParameter("pract_id");
//		if(pract_id == null) pract_id="";
	String drug_priv_appln_yn	= (String) session.getValue("PrivilegeApplicability")==null?"":(String) session.getValue("PrivilegeApplicability");

	bean.setRespId(resp_id); 
	bean.setDrugPrivApplnYN(drug_priv_appln_yn);

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String locn_code	= (String)ORbean.getLocationCode();
//licence related code removed during PE By Naveen
	//String licenceRights	= IVLicenceRights.getKey();
	if(patient_class.trim().equals("DC")) 
		patient_class="IP";
    if(!patient_class.trim().equals("IP") && !patient_class.trim().equals("EM")) 
		patient_class="OP";	
	bean.setPatientClass(patient_class);

	int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));

	// Current Rx 
	//code related to below is removed during PE
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		String link						=	"";
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();

			for(int i=0; i<size; i++)	{
				record					=	(HashMap)active_orders.get(i);
				drug_description.append((String)record.get("drug_desc"));
				drug_description.append(" , ");
			}
       */ 

		bean.clear();
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		bean.setPatientClass(patient_class);
		if(!iv_prep_yn.equals("")){
		disabled = "disabled";
		if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2")){
			selected1 = "selected"; 
			bean.setIVType("IVD");
		}
		else if(iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
			selected2 = "selected"; 
			bean.setIVType("IVPB");
		}
		else if(iv_prep_yn.equals("5")){
			selected3 = "selected";
			bean.setIVType("IVWA");
		}
	}

	if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
		selected1 = "selected"; 
		optValue = "IVD";
		bean.setIVType("IVD");
	}
	else if(iv_prep_default.equals("3") || iv_prep_default.equals("4")){
		selected2 = "selected"; 
		optValue = "IVPB";
		bean.setIVType("IVPB");
	}
	else if(iv_prep_default.equals("5")){
		selected3 = "selected";
		optValue = "IVWA";
		bean.setIVType("IVWA");
	}
	String iv_with_additives	= "";
	String iv_without_additives = "";
	String iv_intermittent		= "";

	ArrayList ivLegends = bean.getIvLegends();
	if(ivLegends != null && ivLegends.size()>1){
		iv_with_additives		= (String)ivLegends.get(0);
		iv_without_additives	= (String)ivLegends.get(1);
		iv_intermittent			= (String)ivLegends.get(2);
	}
	/*else
	{
	    bean.setIVType("IVD");
    }*/
%>

<BODY onMouseDown="" onKeyDown="lockKey()" > 
<FORM name="formIVPrescriptionOptions" id="formIVPrescriptionOptions">
<%	if (amendOrNot.equals("N") || amendOrNot.equals("")) {

%>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="15%" CLASS="label"><FONT STYLE="font-size:9"><B> <fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </B></FONT>&nbsp;</TD>
		<TD WIDTH="18%" CLASS="fields">
		    <select name="type" id="type" <%=disabled%> onChange="loadIVPresDetails(formIVPrescriptionOptions,this.value,'<%=patient_id%>','<%=encounter_id%>');">
				<option value="IVD" selected <%=selected1%>> <%=iv_with_additives%></option>
				<option value="IVWA" <%=selected3%> ><%=iv_without_additives%></option>
				<option value="IVPB" <%=selected2%> ><%=iv_intermittent%></option> 	
	       </select>
	</TD>
	<!-- CurrentRx details-->
	<% 

	if(!start_date.equals("")){%>
		<td class="fields" width="4%">
		<input type="button" class="button" value='<fmt:message key="ePH.PrevOrders.label" bundle="${ph_labels}"/>' onClick="javascript:showPreviousOrders('<%=patient_id%>','<%=encounter_id%>');"></td>
	<%}%>

		<td class="fields" width="8%">
		<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
		<td class="CURRTEXT" width="30%"> 
		<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>' > <font  style="font-weight:bold;color:black" size=1></font></marquee> -->
		</td>
		<td class="label" width="10%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','<%=encounter_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>' ></td> <!-- encounter_id added for AAKH-CRF-0088.2  -->
</tr>
</table>
<!--CurrentRx table ends-->
<%	
	} else { %>
			
	<INPUT TYPE="hidden" name="IV_DIRECT" id="IV_DIRECT" VALUE="Y">
	<INPUT TYPE="hidden" name="IV_ADMIXTURE" id="IV_ADMIXTURE" VALUE="N">
				<!-- Below table for CurrentRx details-->
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
		<tr>
				<td width="15%">
				<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
				<td class="CURRTEXT" width="70%">&nbsp;
				<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>' ><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
				</td>		
			<td class="label" width="15%"><input type='button' class='button' onClick="showDrugProfile(<%=patient_id%>)" value='<fmt:message key="ePH.DrugProfile.label" bundle="${ph_labels}"/>'></a></td>
			
		</tr>
		</table>
		<!--CurrentRx table ends-->
<%	}	%>
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=act_patient_class%>">
<input type="hidden" name="start_date" id="start_date" value="<%=start_date%>">
<input type="hidden" name="iv_option" id="iv_option" value="<%=iv_option%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="locn_code" id="locn_code" value="<%= locn_code %>">
<input type="hidden" name="MAR_app_yn" id="MAR_app_yn" value="<%=MAR_app_yn %>">
<input type="hidden" name="adr_count" id="adr_count"  value="<%=adr_count%>">
<%

if(iv_prep_default.equals("3") || iv_prep_default.equals("4") || iv_prep_default.equals("5")){	
%>
<script> 
	loadIVPresDetails(document.formIVPrescriptionOptions,'<%=optValue%>','<%=patient_id%>','<%=encounter_id%>');
	confirmAndProceed(this,this,2,'<%=iv_prep_default%>','<%=order_set_code%>');
</script>
<% }%>
</FORM>
>
<script>
if(document.forms[0].type.disabled==false) //Added for onlinehelp  on 22/3/10
document.forms[0].type.focus();</script>

</BODY>
</HTML>

	<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
%>

