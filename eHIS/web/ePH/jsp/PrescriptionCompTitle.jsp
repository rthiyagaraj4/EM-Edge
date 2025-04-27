<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*, eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
			
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends		
			
		String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<%
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request);

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;

	String locn_code	    = (String)ORbean.getLocationCode();

	bean.setPatientClass(patient_class);

   int take_home			= bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
	// Current Rx 
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();

			for(int i=0; i<size; i++)	{
				record					=	(HashMap)active_orders.get(i);
				drug_description.append((String)record.get("drug_desc"));
				drug_description.append(" , ");
			}
			*/
		bean.setIVType("IVD");
%>

<!-- <BODY  >  -->
<body onMouseDown="" onKeyDown="lockKey()">
<!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" -->
<FORM name="formPrescriptionCompTitle" id="formPrescriptionCompTitle">
<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
<tr>
<!-- CurrentRx details-->
	<td width="10%"> 
			<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callCurrentMedication('<%=patient_id%>','<%=encounter_id%>');">
	</td> 
		<td class="CURRTEXT"  width="80%">&nbsp;
		<!-- <marquee scrollamount="3" title='<fmt:message key="ePH.ClickCurrentRxbuttontoViewCurrentMedication.label" bundle="${ph_labels}"/>' ><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
</td>
<td class="label" width="10%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','<%=encounter_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td><!-- encounter_id Added for AAKH-CRF-0088.2 -->
</tr> 
</table>
<!--CurrentRx table ends-->
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="start_date" id="start_date" value="<%=start_date%>">
<input type="hidden" name="iv_option" id="iv_option" value="<%=iv_option%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="locn_code" id="locn_code" value="<%= locn_code %>">
<input type="hidden" name="drug_codes" id="drug_codes" value="">
<% putObjectInBean(bean_id,bean,request);
   putObjectInBean(or_bean_id,ORbean,request);
%>
</FORM>
</BODY>
</HTML>

