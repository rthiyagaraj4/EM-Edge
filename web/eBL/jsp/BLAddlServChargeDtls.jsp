<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eBL.BLReportIdMapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	PreparedStatement pstmt1		= null ;
	Statement stmt = null;
	ResultSet rs				= null;	
	ResultSet rs1				= null;	
	boolean siteSpecNMC=false;//Added V190821-MuthuN/NMC-JD-SCF-0015

	try
	{
		con	=	ConnectionManager.getConnection(request);
		siteSpecNMC = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_ENABLE_CMN_FUN_ME_YN");//Added V190821-MuthuN/NMC-JD-SCF-0015
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		CurrencyFormat cf = new CurrencyFormat();
		String query_string=request.getQueryString();

		String str_addl_charge_amt="", str_rule_code="", str_rule_desc="";
		int i=0,noofdecimal=2; 
		String classval="";

		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.out.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.out.println("strclientip "+strclientip);

		String str_trx_doc_ref = request.getParameter("trx_doc_ref");	
		if(str_trx_doc_ref==null) str_trx_doc_ref="";
//		System.out.println("str_trx_doc_ref "+str_trx_doc_ref);

		String str_trx_doc_ref_line_num = request.getParameter("trx_doc_ref_line_no");	
		if(str_trx_doc_ref_line_num==null) str_trx_doc_ref_line_num="";	
//		System.out.println("str_trx_doc_ref_line_num "+str_trx_doc_ref_line_num);

		String str_trx_doc_ref_seq_num = request.getParameter("trx_doc_ref_seq_no");	
		if(str_trx_doc_ref_seq_num==null) str_trx_doc_ref_seq_num="";	
//		System.out.println("str_trx_doc_ref_seq_num "+str_trx_doc_ref_seq_num);

		String total_addl_charge_for_payer = request.getParameter("total_addl_charge_for_payer");	
		if(total_addl_charge_for_payer==null) total_addl_charge_for_payer="";	
//		System.out.println("total_addl_charge_for_payer "+total_addl_charge_for_payer);

		boolean amtRoundOff = true;//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102
%>
	<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<STYLE TYPE="text/CSS">

/* This style is used for locking the table's heading  */

div#tbl-container {
width: 474px;
height: 120px;
overflow: auto;
}

thead td, thead td.locked	{
position:relative;
}

thead td {
top: expression(document.getElementById("tbl-container").scrollTop-2); 
z-index: 20;
}

</STYLE>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>		
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>	
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eBL/js/BLAdhocDisc.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<script>

</script>

<BODY onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" 					      					  onSelect="codeArrestThruSelect();">
<FORM name='BLAddlServChargeDtlsForm' id='BLAddlServChargeDtlsForm' action="" method=''>	
<div id='tbl-container'>
	<table border='1' cellpadding='0' cellspacing='0'  id='tbl' width='100%'>	
	<thead>
		<tr>			
			<td class='COLUMNHEADER' width='70%'>
			<%if(siteSpecNMC){%>			
				<fmt:message key="eBL.Vat_Charges.label" bundle="${bl_labels}"/>
			<%} else {%>
				<fmt:message key="eBL.ADDL_CHARGE.label" bundle="${bl_labels}"/>
			<%}%>
			</td>
			<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>		
		</tr>
	</thead>
	<tbody>

<%
		try
		{
			try
			{		
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
				ResultSet rscurr = pstmt.executeQuery();	
				while(rscurr.next())
				{
					noofdecimal  =  rscurr.getInt(1);		
				}		
				rscurr.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				System.out.println("3="+e.toString());
			}
			
			//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102 try
			ResultSet roundOffRS = null;
			try {
				pstmt = con.prepareStatement("select BILL_ROUNDING_IND  from bl_parameters");
				
				roundOffRS = pstmt.executeQuery();	
				if (roundOffRS != null && roundOffRS.next())
				{
					if(roundOffRS.getString("BILL_ROUNDING_IND").trim().equalsIgnoreCase("0")) {
						amtRoundOff = false;
					}
				}
			} catch(Exception e) {   
				e.printStackTrace();
				System.out.println("4="+e.toString());
			} finally {
				if (roundOffRS != null)   roundOffRS.close();
				if (pstmt != null) pstmt.close();		 		
			}

			String strsql="select RULE_CODE, ADDL_CHARGE_AMT From BL_PAT_CHRG_FOLIO_ADDL_CHARGE Where OPERATING_FACILITY_ID='"+str_facility_id+"' and TRX_DOC_REF='"+str_trx_doc_ref+"' and TRX_DOC_REF_LINE_NUM='"+str_trx_doc_ref_line_num+"' and TRX_DOC_REF_SEQ_NUM='"+str_trx_doc_ref_seq_num+"'";
			
//			System.out.println("strsql "+strsql);	

			stmt = con.createStatement();
			rs = stmt.executeQuery(strsql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  

					str_rule_code = rs.getString(1);
					if(str_rule_code == null) str_rule_code="";

					str_addl_charge_amt = rs.getString(2);
					if(str_addl_charge_amt == null) str_addl_charge_amt="0";

					//Added by Aravindh/10-05-2018/MMS-JU-SCF-0102 if-else condition
					if(amtRoundOff) {
						str_addl_charge_amt = cf.formatCurrency(str_addl_charge_amt, noofdecimal);
					} else {
						str_addl_charge_amt = BLReportIdMapper.truncateUptoTwoDecimal(str_addl_charge_amt, noofdecimal);
					}

					try
					{		
						pstmt1 = con.prepareStatement( " select long_desc from BL_ADDL_CHARGE_RULE_LANG_VW where FACILITY_ID='"+str_facility_id+"' and RULE_CODE='"+str_rule_code+"' and LANGUAGE_ID='"+locale+"'");

						rs1 = pstmt1.executeQuery();	
						while(rs1.next())
						{
							str_rule_desc  =  rs1.getString(1);		
							if(str_rule_desc == null) str_rule_desc="";
						}		
						rs1.close();
						pstmt1.close();
//						System.out.println("str_rule_desc:"+str_rule_desc);
					}
					catch(Exception e)
					{
						System.out.println("Rule Desc Qry:"+e.toString());
					}

					if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
%>
			<tr>
				<td class=<%=classval%> width='70%'><div id="rule_desc_<%=i%>"><%=str_rule_desc%></div>
				<input type="hidden" name="rule_code<%=i%>" id="rule_code<%=i%>" value="<%=str_rule_code%>"></td>

				<td class=<%=classval%> width='30%' ><div style='text-align:right' id="addl_charge_amt<%=i%>"><%=str_addl_charge_amt%></div></td>
			</tr>
<%			
					i++;
				}//while		
			}//rs 
			stmt.close();
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in main qry :"+e);
		}
%>  
	</tbody>
	</table>
	<INPUT TYPE="hidden" name='total_records' id='total_records' value='<%=i%>'>
	<INPUT TYPE="hidden" name='query_string' id='query_string' value='<%=query_string%>'>
	
	<INPUT TYPE="hidden" name='total_addl_charge_for_payer' id='total_addl_charge_for_payer' value='<%=total_addl_charge_for_payer%>'>
</form>
<script>
	parent.frames[1].location.href="../../eBL/jsp/BLAddlServChargeDtlsBtn.jsp?total_addl_charge_for_payer=<%=total_addl_charge_for_payer%>";
</script>

</BODY>
</HTML>
<%
	}
	catch(Exception ee)
	{
	  System.out.println("Error in BLAddlServChargeDtls.jsp " +ee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}
%>

