<!DOCTYPE html>

<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.Common.*, eBL.*, eCommon.Common.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%!
	

private String qtydecimal(String input)
{

		CurrencyFormat cf1 = new CurrencyFormat();		
	input = cf1.formatCurrency(input,2);  
	return input;
}
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eBL/js/PkgUtilization.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	$(document).ready(function(){
		
		var noOfDecimal = $('#noOfDecimal').val();
		//putDecimal_Text($('#pkgAmt'),17,noOfDecimal);
		$('[id^=pkgAmt]').each(function(){
			if($.trim($(this).text() != '')){
				putDecimal_Text($(this),17,noOfDecimal);				
			}
			else{
				$(this).text('0');
				putDecimal_Text($(this),17,noOfDecimal);
			}
		});
	
	});
		</script>
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
		String params = request.getQueryString() ;
		String episodeId		= request.getParameter("episodeId");		
		String visitId		= request.getParameter("visitId");
		String episodeType		= request.getParameter("episodeType");
		String packageCode		= "";
		String packageSeqNo		= "";
		String packageStatus	= "";
		String noOfDecimal = request.getParameter("noOfDecimal");
		System.out.println("deciiiiii======"+noOfDecimal);
		//String sql		   = 	"SELECT a.package_code, long_desc, package_seq_no, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, blng_class_code, cust_group_code, cust_code, package_amt,a.status package_Status FROM bl_package_sub_hdr a, bl_package_lang_vw b WHERE a.package_code = b.package_code AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id=? and b.language_id = ? AND a.patient_id = ?  and a.status in('O','C') and   EXISTS (SELECT (1) FROM BL_PACKAGE_ENCOUNTER_DTLS WHERE operating_facility_id = A.operating_facility_id AND PATIENT_ID=A.PATIENT_ID AND PACKAGE_CODE=A.PACKAGE_CODE AND PACKAGE_SEQ_NO=A.PACKAGE_SEQ_NO AND episode_id || LPAD (visit_id, 4, 0) = ? || LPAD (?, 4, 0) )OR (    ? NOT IN ('I', 'D', 'O', 'E') AND episode_id IS NULL )))"; // Encounter_ID=to_number(?) and VISIT_ID =nvl( to_number(?),0) ) 
	//String sql		   = "SELECT a.package_code, long_desc, package_seq_no, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date, TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, blng_class_code, cust_group_code, cust_code, package_amt,a.status packageStatus FROM bl_package_sub_hdr a, bl_package_lang_vw b WHERE a.package_code = b.package_code AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id=? and b.language_id = ? AND a.patient_id = ?    and a.status in('O','C') ";
		String sql="SELECT a.package_code, long_desc, package_seq_no, TO_CHAR (a.eff_from_date, 'dd/mm/yyyy') eff_from_date,  TO_CHAR (a.eff_to_date, 'dd/mm/yyyy') eff_to_date, blng_class_code, cust_group_code, cust_code, package_amt, a.status packagestatus FROM bl_package_sub_hdr a, bl_package_lang_vw b WHERE a.package_code = b.package_code AND a.operating_facility_id = b.operating_facility_id AND a.operating_facility_id = ? AND b.language_id = ?   AND a.patient_id = ?  AND a.status IN ('O', 'C')  AND EXISTS (   SELECT (1) FROM bl_package_encounter_dtls    WHERE operating_facility_id = a.operating_facility_id    AND patient_id = a.patient_id  AND package_code = a.package_code  AND package_seq_no = a.package_seq_no  AND (   (    ? IN ('I', 'D') AND encounter_id = ?)   OR (    ? IN ('O', 'E') AND encounter_id || LPAD (visit_id, 4, 0) =  ? || LPAD (?, 4, 0)   )   OR (    ? NOT IN ('I', 'D', 'O', 'E')  AND encounter_id IS NULL)))";				              

	
	
	System.out.println(sql);%>

<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
<table class='grid' width='100%' id="pkgDtlsForPatient">
<%
try{
	int i =0;
	
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,facilityId);
	pstmt.setString(2,locale);
	pstmt.setString(3,patientId);
	pstmt.setString(4,episodeType);
	pstmt.setString(5,episodeId);
	pstmt.setString(6,episodeType);
	pstmt.setString(7,episodeId);
	pstmt.setString(8,visitId);
	pstmt.setString(9,episodeType);
	
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

		<td class='LABEL' align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displaypkgDtls('<%=packageCode%>','<%=packageSeqNo%>');" >  +</a><%=packageCode%></td>
		<td class='LABEL'  align="left" nowrap><a href='#' name='pkgDtls<%=i%>' onClick="displayServDtls('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=checkForNull((String)rs.getString("LONG_DESC"))%>');" > <%=packageSeqNo%></a></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("LONG_DESC"))%></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_FROM_DATE"))%></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("EFF_TO_DATE"))%></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("BLNG_CLASS_CODE"))%></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_GROUP_CODE"))%></td>
		<td class='LABEL' align="left" nowrap> <%=checkForNull((String)rs.getString("CUST_CODE"))%></td>
		<td class='LABEL'  id='pkgAmt' name='pkgAmt' nowrap style="text-align: right"> <%=checkForNull((String)rs.getString("PACKAGE_AMT"))%></td>
		<td  class='LABEL' align="left" nowrap>
		 <%if(packageStatus.equals("O")){  %>
			<fmt:message key="Common.open.label" bundle="${common_labels}"/>
			<%}else if(packageStatus.equals("C")){ %>
			<fmt:message key="Common.close.label" bundle="${common_labels}"/>
			<%}%> 
		</td>


<%	i++;}
	%>
	
<input type='hidden' name='noOfDecimal' id='noOfDecimal'  value='<%=noOfDecimal %>'>
 </table>
 
 	
	<%if(i==0)
	{%>
	 <script>
	
		parent.PkgPatientHdr.location.href="../../eCommon/html/blank.html";
		parent.PkgPatIdFrame.document.forms[0].patientId.value = "";
		alert(getMessage('BL00960','BL')); 
		window.close();
	
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
	

