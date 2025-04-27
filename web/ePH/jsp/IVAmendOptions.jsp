<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String amendOrNot		= "";

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name, request);
	//String licenceRights	= IVLicenceRights.getKey();
	bean.setPatientClass(patient_class);

	int take_home					=	bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));


	// Current Rx 
	/*	ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
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
		bean.setIVType("IVD");
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
<FORM name="formIVPrescriptionOptions" id="formIVPrescriptionOptions">
<%	if (amendOrNot.equals("N") || amendOrNot.equals("")) {
		
%>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD WIDTH="10%" ALIGN="right" CLASS="label"><FONT STYLE="font-size:9"><B>&nbsp;&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/> </B></FONT>&nbsp;</TD>
		<TD WIDTH="18%" ALIGN="left" CLASS="label"><select name="type" id="type" onChange="setIVType();loadIVPresDetails(formIVPrescriptionOptions,this.value,'<%=patient_id%>','<%=encounter_id%>');confirmAndProceed(this,this);">
	<option value="IVD" selected><fmt:message key="Common.IVwithAdditives.label" bundle="${common_labels}"/></option>
	<option value="IVWA"  ><fmt:message key="ePH.IVwithoutAdditives.label" bundle="${ph_labels}"/></option>
	<option value="IVPB"  ><fmt:message key="ePH.IVPiggyBack.label" bundle="${ph_labels}"/></option>
	<option value="IVB"  ><fmt:message key="ePH.IVBolus/IVPush.label" bundle="${ph_labels}"/></option>
	<!-- <option value="IVF">IV Fluids Only</option> -->
	</select>
<!-- 	<INPUT TYPE="radio"  name="IV_DIRECT" id="IV_DIRECT" VALUE="" onClick="confirmAndProceed(this, document.formIVPrescriptionOptions.IV_ADMIXTURE)"><FONT STYLE="font-size:9">IV Direct</FONT></TD>
		<TD WIDTH="12%" ALIGN="left" CLASS="label"><INPUT TYPE="radio"  name="IV_ADMIXTURE" id="IV_ADMIXTURE" VALUE="" onClick="confirmAndProceed(this, document.formIVPrescriptionOptions.IV_DIRECT)"><FONT STYLE="font-size:9">IV Admixture</FONT> -->
	</TD>
	<!-- CurrentRx details-->
		<td align="left" width="12%">
		<input type="button" class="button" value="Current Rx" onClick="javascript:callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
		<td class="CURRTEXT" align="left" width="50%">&nbsp;
		<!-- <marquee scrollamount="3" title="Click Current Rx button to View Current Medication"><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
		</td>

	   <td class="label" align="center" width="10%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td>
	
</tr>
</table>
<!--CurrentRx table ends-->

<%	} else { %>

	<INPUT TYPE="hidden" name="IV_DIRECT" id="IV_DIRECT" VALUE="Y">
	<INPUT TYPE="hidden" name="IV_ADMIXTURE" id="IV_ADMIXTURE" VALUE="N">
				<!-- Below table for CurrentRx details-->
		<table border="0" width="100%" cellspacing="0" cellpadding="0">
		<tr>
				<td align="left" width="15%">
				<input type="button" class="button" value="Current Rx" onClick="javascript:callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
				<td class="CURRTEXT" align="left" width="70%"><!--  -->
				<!-- <marquee scrollamount="3" title="Click Current Rx button to View Current Medication"><font  style="font-weight:bold;color:black" size=1></font></marquee> -->
				</td>			
			<td class="label" align="center" width="15%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>')" value='Drug Profile'></a></td>
			
		</tr>
		</table>
		<!--CurrentRx table ends-->
<%	}	%>
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
<input type="hidden" name="start_date" id="start_date" value="<%=start_date%>">
<input type="hidden" name="iv_option" id="iv_option" value="<%=iv_option%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
</FORM>
</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

