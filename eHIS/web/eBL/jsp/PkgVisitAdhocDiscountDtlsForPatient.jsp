<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*,eBL.PkgAdhocDiscountBean" contentType="text/html;charset=UTF-8" %>
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
	<script language="javascript" src="../../eBL/js/PkgVisitAdhocDiscount.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String bean_id			= "bl_PkgAdhocDiscountBean" ;
		String bean_name		= "eBL.PkgAdhocDiscountBean";

		PkgAdhocDiscountBean bean	= (PkgAdhocDiscountBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clearBean();		
		String locale			= (String)session.getAttribute("LOCALE");
		String patientId		= request.getParameter("patientId");
		patientId				= patientId==null ?"":patientId;
		String called_from      = request.getParameter("called_from");
		called_from				= called_from==null ?"":called_from;
		String strpackageseqno      = request.getParameter("strpackageseqno");
		strpackageseqno				= strpackageseqno==null ?"":strpackageseqno;
		String episode_id      = request.getParameter("episode_id");
		episode_id				= episode_id==null ?"":episode_id;
		String visit_id      = request.getParameter("visit_id");
		visit_id				= visit_id==null ?"":visit_id;
		String blnggrp      = request.getParameter("blnggrp");
		blnggrp				= blnggrp==null ?"":blnggrp;

		String billdoctype      = request.getParameter("billdoctype");
		billdoctype				= billdoctype==null ?"":billdoctype;
		String billdocnum      = request.getParameter("billdocnum");
		billdocnum				= billdocnum==null ?"":billdocnum;		
		String packageCode		= "";
		String packageSeqNo		= "";
		String packagelongDesc	= "";
		String str_for_qry="";
		//strpackageseqno = "1743";

		strpackageseqno = strpackageseqno.replace("|",",");	
		strpackageseqno =strpackageseqno.substring(0,(strpackageseqno.length())-1);		
		str_for_qry = "and a.package_seq_no IN("+strpackageseqno+")";
	

		String sql		   = "SELECT a.package_code, long_desc, a.package_seq_no,       TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, blng_class_code, cust_group_code, cust_code, package_amt FROM bl_package_sub_hdr a, bl_package_lang_vw b,bl_package_encounter_dtls c WHERE a.package_code = b.package_code AND a.operating_facility_id = b.operating_facility_id and a.operating_facility_id=c.OPERATING_FACILITY_ID and a.PATIENT_ID=c.PATIENT_ID and a.PACKAGE_CODE=c.PACKAGE_CODE and a.PACKAGE_SEQ_NO=c.PACKAGE_SEQ_NO AND b.language_id = ? AND a.patient_id = ?  "+str_for_qry+"";	

		%>

<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
<table class='grid' width='100%' id="pkgDtlsForPatient">
<%
try{
	int i =0;
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,patientId);
	rs = pstmt.executeQuery();	
	while(rs.next())
	{
		if(i==0)
		{%>
	<td class='columnheader' ><fmt:message key="Common.PackageCode.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' > <fmt:message key="Common.description.label" bundle="${common_labels}"/></td> 
	<td class='columnheader' ><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
	<td class='columnheader' ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
	<td class='columnheader' ><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
	<td  class='COLUMNHEADER' ><fmt:message key="eBL.PKG_AMT.label" bundle="${bl_labels}"/></td>
	</tr>
		<%}
		packageCode		= checkForNull((String)rs.getString("PACKAGE_CODE"));
		packageSeqNo	= checkForNull((String)rs.getString("PACKAGE_SEQ_NO"));
		packagelongDesc	= checkForNull((String)rs.getString("LONG_DESC"));
		if(packagelongDesc.length()>30)
			   packagelongDesc = packagelongDesc.substring(0,29);
		%>
	<tr>

		<td align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=packageCode%>','<%=packageSeqNo%>');" >  +</a><%=packageCode%></td>
		<td align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displayAdhocDiscountDtls('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=called_from%>','<%=episode_id%>', '<%=visit_id%>','<%=blnggrp%>','<%=billdoctype%>','<%=billdocnum%>','<%=packagelongDesc%>');" > <%=packageSeqNo%></a></td>
		<td align="left" nowrap> <%=checkForNull(packagelongDesc)%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_FROM_DATE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_TO_DATE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("BLNG_CLASS_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_GROUP_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_CODE"))%></td>
		<td align="left" nowrap> <%=checkForNull((String)rs.getString("PACKAGE_AMT"))%></td>


<%	i++;}
%>
 </table>
 <input type='hidden' name='called_from' id='called_from' value='<%=called_from%>' />
<%}
catch(Exception e)
{
	System.out.println("Exception from Pakage AdhocDiscount details for the patient :"+e);
	e.printStackTrace();
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

