<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*,eBL.PkgSrvsToNonPkgSvsBean" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgSrvsToNonPkgSvs.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		
		String bean_id			= "bl_PkgSrvsToNonPkgSvsBean" ;
		String bean_name		= "eBL.PkgSrvsToNonPkgSvsBean";

		PkgSrvsToNonPkgSvsBean bean	= (PkgSrvsToNonPkgSvsBean)getBeanObject( bean_id, bean_name, request ) ;
		String locale				= (String)session.getAttribute("LOCALE");
		String facilityId			= (String) session.getValue( "facility_id" ) ;
		String patientId			= request.getParameter("patientId");
		patientId					= patientId==null ?"":patientId;
		String packageCode			= request.getParameter("packageCode");
		packageCode					= packageCode==null ?"":packageCode;
		String packageSeqNo			= request.getParameter("packageSeqNo");
		packageSeqNo				= packageSeqNo==null ?"":packageSeqNo;
		int totalRec = 0;

		ArrayList srvDetails		= new ArrayList();
		ArrayList dtls				= new ArrayList();
		HashMap srvsToNonPkgSvsDtls	= bean.getSrvsToNonPkgSvsDtls();
		
		if(!(srvsToNonPkgSvsDtls!=null && srvsToNonPkgSvsDtls.containsKey(packageSeqNo)))	
		{
			bean.setDBValues(facilityId, patientId, packageSeqNo, locale);
			srvsToNonPkgSvsDtls	= bean.getSrvsToNonPkgSvsDtls();			
		}

		if(srvsToNonPkgSvsDtls!=null && srvsToNonPkgSvsDtls.containsKey(packageSeqNo))
		{
			srvDetails = (ArrayList)srvsToNonPkgSvsDtls.get(packageSeqNo);
			totalRec = 	srvDetails.size();
		}
		
		%>

	<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
	<table class="grid"  width='100%' id="pkgDtlsForPatient">
	<%
	try
	{
		for(int i=0;i<totalRec;i++)
		{
			dtls = (ArrayList)srvDetails.get(i);
			

			if(i==0)		
			{%>
				<tr>
				<td class='columnheader' colspan='2'><fmt:message key="eBL.Transactionreference.label" bundle="${bl_labels}"/></td>
	 
				<td class='columnheader' colspan='2'><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>	

				<td class='columnheader'><fmt:message key="eBL.SERVICE_DATE.label" bundle="${bl_labels}"/></td>
					
				<td class='columnheader' ><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					
				<td class='columnheader' ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				
				<td class='columnheader'><fmt:message key="eBL.EXEMPTINPKG.label" bundle="${bl_labels}"/></td>

				<td class='columnheader'><fmt:message key="eBL.PAYERCOVERAGE.label" bundle="${bl_labels}"/></td>

				<td class='columnheader' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>

				
				<td class='columnheader' ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></td>
				</tr>
			<%}
			%>
			<tr>
			<td align="left" nowrap><%=checkForNull((String)dtls.get(0))%></td>
			<td align="left" nowrap><%=checkForNull((String)dtls.get(1))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(2))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(3))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(4))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(5))%></td>
			<td align="left" nowrap><%=checkForNull((String)dtls.get(6))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(7))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(8))%></td>
			<td align="center" nowrap><%=checkForNull((String)dtls.get(9))%></td>
			<td align="center" nowrap><input type='checkbox' name='del_<%=i%>' id='del_<%=i%>'	 value='N' onClick='selectToDelete(this)' /></td>
			<input type='hidden' name='transDocRef_<%=i%>' id='transDocRef_<%=i%>' value='<%=checkForNull((String)dtls.get(0))%>' />
			
			<input type='hidden' name='transDocRefLineNo_<%=i%>' id='transDocRefLineNo_<%=i%>' value='<%=checkForNull((String)dtls.get(1))%>' />
				
			<input type='hidden' name='billingSrvCode_<%=i%>' id='billingSrvCode_<%=i%>' value='<%=checkForNull((String)dtls.get(2))%>' />
				
			<input type='hidden' name='billingSrvDesc_<%=i%>' id='billingSrvDesc_<%=i%>' value='<%=checkForNull((String)dtls.get(3))%>' />
				
			<input type='hidden' name='serviceDate_<%=i%>' id='serviceDate_<%=i%>' value='<%=checkForNull((String)dtls.get(4))%>' />
				
			<input type='hidden' name='serviceQty_<%=i%>' id='serviceQty_<%=i%>' value='<%=checkForNull((String)dtls.get(5))%>' />
				
			<input type='hidden' name='baseChrAmt_<%=i%>' id='baseChrAmt_<%=i%>' value='<%=checkForNull((String)dtls.get(6))%>' />
				
			<input type='hidden' name='exemptInPkg_<%=i%>' id='exemptInPkg_<%=i%>' value='<%=checkForNull((String)dtls.get(7))%>' />
				
			<input type='hidden' name='payerspkgCoverage_<%=i%>' id='payerspkgCoverage_<%=i%>' value='<%=checkForNull((String)dtls.get(8))%>' />
				
			
			<input type='hidden' name='patientpayable_<%=i%>' id='patientpayable_<%=i%>' value='<%=checkForNull((String)dtls.get(9))%>' />
<%	}
	%>
 </table>
	<%if(totalRec==0)
	{%>
	 <script>
		parent.PkgSrvsToNonPkgSvsPatientHdr.location.href="../../eCommon/html/blank.html";
		alert("Sevices are not applicable for the patient.");</script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from Package SrvsToNonPkgSvs Details  :"+e);
	e.printStackTrace();
}
%>
<input type='hidden' name='patientId' id='patientId' value='<%=patientId%>' />
<input type='hidden' name='packageSeqNo' id='packageSeqNo' value='<%=packageSeqNo%>' />
<input type='hidden' name='facilityId' id='facilityId' value='<%=facilityId%>' />
<input type='hidden' name='totalRec' id='totalRec' value='<%=totalRec%>' />
</form>
</body>
</html>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>


