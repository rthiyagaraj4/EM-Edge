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
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	$(document).ready(function(){
		var noofdecimal = $('#noofdecimal').val() 
				$('[id^=utilizedAmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
				$('[id^=amtLmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
				$('[id^=balanceAmt]').each(function(){
					if($.trim($(this).text() != '')){
						putDecimal_Text($(this),17,noofdecimal);				
					}
					else{
						$(this).text('0');
						putDecimal_Text($(this),17,noofdecimal);
					}
				});
			});
	</script>
	
	
	<style>
TD.QRYEVEN_AMT{
       BACKGROUND-COLOR: #FFFFFF;  
	FONT-SIZE: 9pt ;
	BORDER-STYLE: SOLID;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;
	height:18;	
	text-align:right;

       }

TD.QRYODD_AMT{
	FONT-SIZE: 9pt ;
    BACKGROUND-COLOR: #FFFFFF;  
	BORDER-STYLE: SOLID;
	border-left-color: #D5E2E5;
	border-right-color: #D5E2E5;
	border-top-color: #D5E2E5;
	border-bottom-color: #D5E2E5;
	height:18;
	text-align:right;
	
    }

	</style>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
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
		//String pkgDesc			= request.getParameter("pkgDesc");
		String pkgDesc			= request.getParameter("packagelongDesc");
		pkgDesc					= pkgDesc==null ?"":pkgDesc; 
		String packageSeqNo		= request.getParameter("packageSeqNo");
		packageSeqNo			= packageSeqNo==null ?"":packageSeqNo;
		String packageSrvCode	= "";
		String classval			= "QRYEVEN";
		String classvalForAmt	= "QRYEVEN_AMT";
		double qtyLmt			= 0.0;
		double utilizedQty		= 0.0; 
		double balanceSrvQty	= 0.0;
		double amtLmt			= 0.0;
		double utilizedAmt		= 0.0; 
		double balanceAmt		= 0.0;
		double OrdPlaced		= 0.0;
		double OrdRegisterd		= 0.0;
		double balanceOrd		= 0.0;
		String Amount_limit_ind =""; 
		double daily_amt_limt	= 0.0;
		boolean dailyLimitSiteSpec = false;
		String toDisplay	="&nbsp";
		int noofdecimal=2;
		try
		{
			String sql = "select nvl(no_of_decimal,2) noofdecimal from  sm_acc_entity_param";
			pstmt=con.prepareStatement(sql);	
			rs = pstmt.executeQuery();
			if (rs.next())
				noofdecimal = rs.getInt("noofdecimal");
				
		}
		catch(Exception e)
		{
			System.out.println("Exception from getNoOfDecimal :"+e);
				e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs=null;
			if(pstmt!=null) pstmt=null;
			
		}
		String sql = "SELECT   a.amt_limit_ind amt_limit_ind, a.pkg_serv_code pkg_serv_code, b.service_desc service_desc, ROUND (a.qty_limit, ?) qty_limit, (CASE WHEN blcommon.is_function_applicable_yn ('BL', 'BL_ENABLE_DAILY_PKG_SERV_LIMIT' ) = 'Y' THEN ROUND (DECODE (NVL(a.amt_limit_ind,'U'), 'U', a.utilized_serv_qty, DECODE (NVL (a.qty_limit, 0), 0, 0, a.utilized_serv_qty )), "+noofdecimal+") ELSE ROUND (DECODE (NVL (a.qty_limit, 0), 0, 0, a.utilized_serv_qty ), ? ) END ) utilized_serv_qty, ROUND (a.amt_limit, ?) amt_limit, (CASE WHEN blcommon.is_function_applicable_yn ('BL', 'BL_ENABLE_DAILY_PKG_SERV_LIMIT' ) = 'Y' THEN ROUND (DECODE (NVL(a.amt_limit_ind,'U'), 'U', a.utilized_serv_amt, DECODE (NVL (a.amt_limit, 0), 0, 0, a.utilized_serv_amt )), "+noofdecimal+" ) ELSE ROUND (DECODE (NVL (a.amt_limit, 0), 0, 0, a.utilized_serv_amt ), ? ) END ) utilized_serv_amt, c.order_catalog_yn FROM bl_package_sub_dtls a, bl_package_sub_hdr c, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code, short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en'  FROM bl_package_serv_group_hdr UNION ALL SELECT 'G' serv_ind, serv_grp_code code, short_desc service_desc, language_id FROM bl_blng_serv_grp_lang_vw UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.patient_id = ? AND a.package_code = ? AND a.pkg_serv_code = b.code AND a.pkg_serv_ind = b.serv_ind AND b.language_id = ? AND a.package_seq_no = ? AND a.operating_facility_id = c.operating_facility_id AND a.patient_id = c.patient_id AND a.package_code = c.package_code AND a.package_seq_no = c.package_seq_no UNION ALL SELECT   a.amt_limit_ind amt_limit_ind, a.excl_serv_code pkg_serv_code, b.service_desc service_desc, ROUND (a.qty_limit, ?) qty_limit, (CASE WHEN blcommon.is_function_applicable_yn ('BL', 'BL_ENABLE_DAILY_PKG_SERV_LIMIT' ) = 'Y' THEN ROUND (DECODE (NVL(a.amt_limit_ind,'U'), 'U', a.utilized_serv_qty, DECODE (NVL (a.qty_limit, 0), 0, 0, a.utilized_serv_qty )), "+noofdecimal+" ) ELSE ROUND (DECODE (NVL (a.qty_limit, 0), 0, 0, a.utilized_serv_qty),?) END ) utilized_serv_qty, ROUND (a.amt_limit, ?) amt_limit, (CASE WHEN blcommon.is_function_applicable_yn ('BL', 'BL_ENABLE_DAILY_PKG_SERV_LIMIT' ) = 'Y' THEN ROUND (DECODE (NVL(a.amt_limit_ind,'U'), 'U', a.utilized_serv_amt, DECODE (NVL (a.amt_limit, 0), 0, 0, a.utilized_serv_amt )), "+noofdecimal+" ) ELSE ROUND (DECODE (NVL (a.amt_limit, 0), 0, 0, a.utilized_serv_amt ), ? ) END ) utilized_serv_amt, c.order_catalog_yn FROM bl_package_sub_excl a, bl_package_sub_hdr c, (SELECT 'S' serv_ind, blng_serv_code code, short_desc service_desc, language_id FROM bl_blng_serv_lang_vw UNION ALL SELECT 'C' serv_ind, serv_classification_code code, short_desc service_desc, language_id FROM bl_serv_classification_lang_vw UNION ALL SELECT 'P' serv_ind, package_serv_group_code code, short_desc service_desc, 'en' FROM bl_package_serv_group_hdr UNION ALL SELECT 'M' serv_ind, item_code code, short_desc service_desc, language_id FROM mm_item_lang_vw) b WHERE a.operating_facility_id = ? AND a.patient_id = ? AND a.package_code = ? AND a.excl_serv_code = b.code AND NVL (a.excl_serv_ind, 'M') = b.serv_ind AND a.exclude_yn = 'N' AND b.language_id = ? AND a.package_seq_no = ? AND a.operating_facility_id = c.operating_facility_id AND a.patient_id = c.patient_id AND a.package_code = c.package_code AND a.package_seq_no = c.package_seq_no ORDER BY 1"; //Added V190404-DHANANJAY/MMS-DM-CRF-0129
		String sqlforOrd = "select blng_serv_code, 	      round(sum(decode(blpackage.get_order_status(operating_facility_id,primary_key_main, primary_key_line_no),'ORD',1,0)),?) ordered,         round(sum(decode(blpackage.get_order_status(operating_facility_id,primary_key_main, primary_key_line_no),'REG',1,0)),?) registered	from bl_patient_charges_interface where ( operating_facility_id,trx_doc_ref, trx_doc_ref_line_num) in	(select operating_facility_id, trx_doc_ref, trx_doc_ref_line_num from bl_patient_charges_folio where operating_facility_id=? and patient_id=?	and package_seq_no=? and blng_serv_code=? and nvl(trx_status,'X')='X') group by blng_serv_code";
		
		%>

	<form name='frmPkgDtlsForPatient' id='frmPkgDtlsForPatient'  target='messageFrame' >	
	<table cellpadding="0" cellspacing="0" border="1" align="center"  width='100%' id="pkgDtlsForPatient">
	<%
	try{
		dailyLimitSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL", "BL_ENABLE_DAILY_PKG_SERV_LIMIT");//Added V190404-DHANANJAY/MMS-DM-CRF-0129
		int i =0;
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1,noofdecimal);
		pstmt.setInt(2,noofdecimal);
		pstmt.setInt(3,noofdecimal);
		pstmt.setInt(4,noofdecimal);
		pstmt.setString(5,facilityId);
		pstmt.setString(6,patientId);
		pstmt.setString(7,packageCode);
		pstmt.setString(8,locale);
		pstmt.setString(9,packageSeqNo);
		pstmt.setInt(10,noofdecimal);
		pstmt.setInt(11,noofdecimal);
		pstmt.setInt(12,noofdecimal);
		pstmt.setInt(13,noofdecimal);
		pstmt.setString(14,facilityId);
		pstmt.setString(15,patientId);
		pstmt.setString(16,packageCode);
		pstmt.setString(17,locale);
		pstmt.setString(18,packageSeqNo);
		rs = pstmt.executeQuery();	
		while(rs.next())
		{
			if(i==0)
			{%>
				<script>					displayPackageHdr('<%=patientId%>','<%=packageCode%>','<%=packageSeqNo%>','<%=pkgDesc%>');
				</script>

				<tr>
				<td class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td> 
				<td class='columnheader'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
				<td class='columnheader' colspan="3" align="center" ><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='columnheader' colspan="3" align="center"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
				<td class='columnheader' colspan="3" align="center"><fmt:message key="Common.Order.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
				<td class='columnheader'>&nbsp;</td> 
				<td class='columnheader'>&nbsp;</td> 
				<td class='columnheader'><fmt:message key="eBL.ELIGIBLE.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.AVAILED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.ELIGIBLE.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.AVAILED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.PLACED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="eBL.REGISTERED.label" bundle="${bl_labels}"/></td>
				<td class='columnheader'><fmt:message key="Common.Balance.label" bundle="${common_labels}"/></td>
				</tr>

			<%}
			qtyLmt=rs.getDouble("qty_limit");
			utilizedQty=rs.getDouble("utilized_serv_qty");
			balanceSrvQty = qtyLmt-utilizedQty;
			amtLmt=rs.getDouble("amt_limit");
			toDisplay = (amtLmt>0)?"0.0":"&nbsp"; 
			utilizedAmt=rs.getDouble("utilized_serv_amt");
			Amount_limit_ind = rs.getString("amt_limit_ind"); 
			if(dailyLimitSiteSpec) {
				if (null == Amount_limit_ind || "U".equals(Amount_limit_ind)){
					balanceAmt= 0 ;
					balanceSrvQty = 0;
				} else {
					balanceAmt=amtLmt- utilizedAmt;
				}
			} else {
				balanceAmt=amtLmt- utilizedAmt;
			}
			packageSrvCode = (String)rs.getString("pkg_serv_code");
			if(checkForNull((String)rs.getString("order_catalog_yn")).equals("Y"))
			{
				try
				{
					OrdPlaced=0.0;
					OrdRegisterd=0.0;
					balanceOrd = 0.0;
					pstmt1 = con.prepareStatement(sqlforOrd);
					pstmt1.setInt(1,noofdecimal);
					pstmt1.setInt(2,noofdecimal);
					pstmt1.setString(3,facilityId);
					pstmt1.setString(4,patientId);
					pstmt1.setString(5,packageSeqNo);
					pstmt1.setString(6,packageSrvCode);
					rs1 = pstmt1.executeQuery();	
					if(rs1.next())
					{
						OrdPlaced=rs1.getDouble("ordered")+rs1.getDouble("registered");
						OrdRegisterd=rs1.getDouble("registered");	 
						balanceOrd		= OrdPlaced - OrdRegisterd;
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception from getting order related details :"+e);
					e.printStackTrace();
				}
				finally
				{
					if (rs1 != null)   rs1.close();
					if (pstmt1 != null) pstmt1.close();
				}
			}
			if(i % 2 == 0 )
			{
				classval		=	"QRYEVEN";
				classvalForAmt	= "QRYEVEN_AMT";
			}
			else
			{
				classval		=	"QRYODD";
				classvalForAmt	= "QRYODD_AMT";
			}	 
			%>
				
		<tr>
		<td class="<%=classval%>" nowrap><%=packageSrvCode%></td>
		<td class='<%=classval%>' nowrap><%=(String)rs.getString("service_desc")%></td>
		<td class='<%=classvalForAmt%>'  name ='amtLmt' id ='amtLmt' align="right"nowrap > <%=amtLmt==0? toDisplay :amtLmt%></td>
		<td class='<%=classvalForAmt%>'  name ='utilizedAmt' id ='utilizedAmt' align="right" nowrap> <%=utilizedAmt==0?toDisplay:utilizedAmt%></td>
		<td class='<%=classvalForAmt%>'  name ='balanceAmt' id ='balanceAmt' align="right" nowrap> <%=balanceAmt==0?toDisplay:balanceAmt%></td>
		<td class='<%=classval%>'  name ='qtyLmt' id ='qtyLmt' nowrap> <%=qtyLmt==0?"&nbsp;":qtyLmt%></td>
		<%	toDisplay = (qtyLmt>0)?"0.0":"&nbsp;";  %>
		<td  class='<%=classval%>'  name ='utilizedQty' id ='utilizedQty' nowrap> <%=utilizedQty==0?toDisplay:utilizedQty%></td>
		<td class='<%=classval%>'  name ='balanceSrvQty' id ='balanceSrvQty' nowrap> <%=balanceSrvQty==0?toDisplay:balanceSrvQty%></td>
		
		<td class='<%=classval%>' nowrap> <%=OrdPlaced==0?"&nbsp;":OrdPlaced%></td>
		<%	toDisplay = (OrdPlaced>0)?"0.0":"&nbsp;";  %>
		<td class='<%=classval%>' nowrap> <%=OrdRegisterd==0?toDisplay:OrdRegisterd%></td>
		<td class='<%=classval%>' nowrap> <%=balanceOrd==0?toDisplay:balanceOrd%></td>
		 </tr>
<%	i++;}
	%>
 </table>
 
 <table cellpadding="0" cellspacing="0" border="0" align="center"  width='100%' >
 	<tr  colspan="5"></tr>
 	<tr>
 		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='25%'>&nbsp;</td>
		<td class='label' width='20%'>&nbsp;</td>
		<td class='label' width='25%'>
			<input type="button" name="close_button" id="close_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="button"  onClick="window.close();" >
		</td>
	</tr>	
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
	System.out.println("Exception from maintrt Package Service Utilization Details For Patient :"+e);
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con);
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();


}%>
<input type='hidden' name='noofdecimal' id='noofdecimal'  value='<%=noofdecimal %>'>

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

