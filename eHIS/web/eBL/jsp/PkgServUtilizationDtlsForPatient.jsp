<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*, eBL.*, eCommon.Common.* ,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
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
	<script language="javascript" src="../../eBL/js/PkgUtilization.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		Connection con			= ConnectionManager.getConnection();	
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		PreparedStatement pstmt1= null;
		ResultSet rs1			= null;

		String locale			= (String)session.getAttribute("LOCALE");
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String patientId		= request.getParameter("patientId");
		patientId				= patientId==null ?"":patientId;
		String packageCode		= request.getParameter("packageCode");
		packageCode				= packageCode==null ?"":packageCode;
		String packageSeqNo		= request.getParameter("packageSeqNo");
		packageSeqNo			= packageSeqNo==null ?"":packageSeqNo;
		String packageSrvCode	= "";

		int qtyLmt			= 0;
		int utilizedQty		= 0; 
		int balanceSrvQty	= 0;
		int amtLmt			= 0;
		int utilizedAmt		= 0; 
		int balanceAmt		= 0;
		int OrdPlaced		= 0;
		int OrdRegisterd	= 0;
		int balanceOrd		= 0;
		String sql		   = "SELECT a.pkg_serv_code pkg_serv_code, b.service_desc service_desc, a.qty_limit, a.utilized_serv_qty, a.amt_limit, a.utilized_serv_amt, c.order_catalog_yn     FROM bl_package_sub_dtls a,bl_package_sub_hdr c, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code, short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?  AND a.patient_id = ? AND a.package_code = ? AND a.pkg_serv_code = b.code AND a.pkg_serv_ind =  b.serv_ind AND b.language_id = ?    AND a.package_seq_no = ? AND a.operating_facility_id= c.operating_facility_id ANd a.patient_id=c.patient_id AND a.package_code=c.package_code AND a.package_seq_no=c.package_seq_no union all SELECT a.EXCL_SERV_CODE pkg_serv_code, b.service_desc service_desc, a.qty_limit, a.utilized_serv_qty, a.amt_limit, a.utilized_serv_amt, c.order_catalog_yn FROM bl_package_sub_excl a,bl_package_sub_hdr c, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code, short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw) b WHERE a.operating_facility_id = ?  AND a.patient_id = ? AND a.package_code = ? AND a.EXCL_SERV_CODE = b.code AND a.EXCL_SERV_IND = b.serv_ind and a.EXCLUDE_YN='N' AND b.language_id = ? AND a.package_seq_no = ? AND a.operating_facility_id= c.operating_facility_id ANd a.patient_id=c.patient_id AND a.package_code=c.package_code AND a.package_seq_no=c.package_seq_no order by 1";
		String sqlforOrd = "select blng_serv_code, 	      sum(decode(blpackage.get_order_status(operating_facility_id,primary_key_main, primary_key_line_no),'ORD',1,0)) ordered,         sum(decode(blpackage.get_order_status(operating_facility_id,primary_key_main, primary_key_line_no),'REG',1,0)) registered	from bl_patient_charges_interface where ( operating_facility_id,trx_doc_ref, trx_doc_ref_line_num) in	(select operating_facility_id, trx_doc_ref, trx_doc_ref_line_num from bl_patient_charges_folio where operating_facility_id=? and patient_id=?	and package_seq_no=? and blng_serv_code=? and nvl(trx_status,'X')='X') group by blng_serv_code";	
		System.err.println("In PkgServUtilizationDtlsForPatient.jsp sqlforOrd: "+sqlforOrd);
		%>

	<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
	<table class="grid"  width='100%' id="pkgDtlsForPatient">
	<%
	try{
		int i =0;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facilityId);
		pstmt.setString(2,patientId);
		pstmt.setString(3,packageCode);
		pstmt.setString(4,locale);
		pstmt.setString(5,packageSeqNo);
		pstmt.setString(6,facilityId);
		pstmt.setString(7,patientId);
		pstmt.setString(8,packageCode);
		pstmt.setString(9,locale);
		pstmt.setString(10,packageSeqNo);
		rs = pstmt.executeQuery();	
		while(rs.next())
		{
			if(i==0)
			{%>
				<tr>
				<td class='columnheader' ><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td> 
				<td class='columnheader'  ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td class='columnheader'   colspan="3" align="center" > <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/> </td>
				<td class='columnheader'   colspan="3" align="center"  > <fmt:message key="Common.amount.label" bundle="${common_labels}"/> </td>
				<td class='columnheader'   colspan="3" align="center" > <fmt:message key="Common.Order.label" bundle="${common_labels}"/> </td>
				</tr>
				<tr>
				<td class='columnheader'>&nbsp</td> 
				<td class='columnheader'>&nbsp</td> 
				<td class='columnheader'>	<fmt:message key="eBL.ELIGIBLE.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="eBL.AVAILED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="eBL.ELIGIBLE.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="eBL.AVAILED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="eBL.PLACED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="eBL.REGISTERED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'>	<fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				</tr>

			<%}
			qtyLmt=rs.getInt("qty_limit");
			utilizedQty=rs.getInt("utilized_serv_qty");
			balanceSrvQty = qtyLmt-utilizedQty;
			amtLmt=rs.getInt("amt_limit");
			utilizedAmt=rs.getInt("utilized_serv_amt");
			balanceAmt=amtLmt- utilizedAmt;
			packageSrvCode = (String)rs.getString("pkg_serv_code");
			if(checkForNull((String)rs.getString("order_catalog_yn")).equals("Y"))
			{
				try
				{
					OrdPlaced=0;
					OrdRegisterd=0;
					balanceOrd = 0;
					pstmt1 = con.prepareStatement(sqlforOrd);
					pstmt1.setString(1,facilityId);
					pstmt1.setString(2,patientId);
					pstmt1.setString(3,packageSeqNo);
					pstmt1.setString(4,packageSrvCode);
					rs1 = pstmt1.executeQuery();	
					if(rs1.next())
					{
						OrdPlaced=rs1.getInt("ordered");
						OrdRegisterd=rs1.getInt("registered");	 
						//if(OrdPlaced>OrdRegisterd)
						balanceOrd		= OrdPlaced - OrdRegisterd;
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception from getting order related details :"+e);
				}
				finally
				{
					if (rs1 != null)   rs1.close();
					if (pstmt1 != null) pstmt1.close();
				}
			}
			%>
		<tr>

		<td align="left" nowrap><%=packageSrvCode%></td>
		<td align="left" nowrap><%=(String)rs.getString("service_desc")%></td>
		<td align="center" nowrap> <%=qtyLmt%></td>
		<td align="center" nowrap> <%=utilizedQty%></td>
		<td align="center" nowrap> <%=balanceSrvQty%></td>
		<td align="center" nowrap> <%=amtLmt%></td>
		<td align="center" nowrap> <%=utilizedAmt%></td>
		<td align="center" nowrap> <%=balanceAmt%></td>
		<td align="center" nowrap> <%=OrdPlaced%></td>
		<td align="center" nowrap> <%=OrdRegisterd%></td>
		<td align="center" nowrap> <%=balanceOrd%></td>

<%	i++;}
	%>
 </table>
	<%if(i==0)
	{%>
	 <script>
		parent.PkgUtilizationPatientHdr.location.href="../../eCommon/html/blank.html";
		alert("Services are not defined for the package.");</script>
	 <%}
}
catch(Exception e)
{
	System.out.println("Exception from Package Service Utilization Details For Patient :"+e);
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

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

