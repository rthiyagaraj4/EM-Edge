<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<!-- 
Sr No        Version          TFS/Incident        SCF/CRF            		    	Developer Name
--------------------------------------------------------------------------------------------------------
1            V220826            34883           MMS-ME-SCF-0104                      Namrata
--------------------------------------------------------------------------------------------------------
-->

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgUtilization.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String patientId		= request.getParameter("patientId");
		patientId				= patientId==null ?"":patientId;
		String packageCode		= "";
		String packageSeqNo		= "";
		String packageStatus	= "";

		// V220826
		String sql		   = "SELECT a.package_code, long_desc, package_seq_no, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date_1 ,eff_from_date , TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, blng_class_code, cust_group_code, cust_code, package_amt,a.status packageStatus FROM bl_package_sub_hdr a, bl_package_lang_vw b WHERE a.package_code = b.package_code AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id=? and b.language_id = ? AND a.patient_id = ? and a.status in('O','C') order by a.ADDED_DATE desc ";
		
		%>

<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
<table class='grid' width='100%' id="pkgDtlsForPatient">
<%
try{
	int i =0;
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,locale);
	pstmt.setString(3,patientId);
	rs = pstmt.executeQuery();	
	while(rs.next())
	{
		if(i==0)
		{%>		
		<script>
		displayPline('<%=patientId%>');
		</script>
		
	<td class='columnheader' ><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' ><fmt:message key="eBL.PKG_AMT.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
		<%}
		packageCode		= checkForNull((String)rs.getString("PACKAGE_CODE"));
		packageSeqNo	= checkForNull((String)rs.getString("PACKAGE_SEQ_NO"));
		packageStatus   = checkForNull((String)rs.getString("packageStatus"));
		%>
	<tr>

		<td align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=packageCode%>','<%=packageSeqNo%>');" >  +</a><%=packageCode%></td>
		<td align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displayServDtls('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=checkForNull((String)rs.getString("LONG_DESC"))%>');" > <%=packageSeqNo%></a></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("LONG_DESC"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_FROM_DATE_1"))%></td> <!-- V220826 -->
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_TO_DATE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("BLNG_CLASS_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_GROUP_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("PACKAGE_AMT"))%></td>
		<td align="left" nowrap>
		 <%if(packageStatus.equals("O")){  %>
			<fmt:message key="Common.open.label" bundle="${common_labels}"/>
			<%}else if(packageStatus.equals("C")){ %>
			<fmt:message key="Common.close.label" bundle="${common_labels}"/>
			<%}%>
		</td>


<%	i++;}
	%>
 </table>
	<%if(i==0)
	{%>
	 <script>
		parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
		parent.PkgPatIdFrame.document.forms[0].patientId.value = "";
		alert("Packages are not subscribed for this patient.");
	</script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from subscribed pakage detailsfor the patient :"+e);
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con);
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
}%>
</form>
</body>
</html>
<%!	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
%>

