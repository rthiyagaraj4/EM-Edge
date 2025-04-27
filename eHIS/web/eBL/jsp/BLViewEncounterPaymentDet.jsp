<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eBL.*,webbeans.op.CurrencyFormat,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rscurr=null;
	//ResultSet rs=null;ResultSet rs1=null;	ResultSet rs2=null;	ResultSet rs3=null;		
	//HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";
	CurrencyFormat cf = new CurrencyFormat();
	String classval="";	int noofdecimal = 2;	
	String tab_chk="";String strBillDocTypeCode=""; String strBillDocNum="";String strFacilityId="";
	String strDocDate="";String strPatientId="";String str_doc_type_code="ffd";String str_doc_num="564";String str_doc_date="5";
	String str_rcpt_nature_code="";String str_doc_amt="";String str_cash_slmt_flag="";String str_remarks="";
	String str_cancelled_ind="";String str_cash_ctr_code="";String str_add_by_id="";
	String str_rem_num="";String str_rem_disp_doc_type="";String str_doc_ser_num="";String str_tot_outstd_amt="";
	String str_reason_desc="";		String str_rem_disp_date="";	String str_wo_apprv_amt="";String str_rem_back_date="";
	String str_apprv_doc=""; String str_rem_not_deliver_yn="";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	try
	{
			con	=	ConnectionManager.getConnection(request);
			strBillDocTypeCode=request.getParameter("doc_type");
			if(strBillDocTypeCode==null || strBillDocTypeCode.equals("")) strBillDocTypeCode="";
			strBillDocNum=request.getParameter("doc_num");
			if(strBillDocNum==null || strBillDocNum.equals("")) strBillDocNum="";
			strDocDate=request.getParameter("doc_date");
			if(strDocDate==null || strDocDate.equals("")) strDocDate="";
			strFacilityId=request.getParameter("facility_id");
			if(strFacilityId==null || strFacilityId.equals("")) strFacilityId="";
			strPatientId = request.getParameter("patient_id");
			if(strPatientId==null) strPatientId="";	
			tab_chk=request.getParameter("tab_chk");
			if(tab_chk==null) tab_chk="";
			try	{		
						pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
						rscurr = pstmt.executeQuery();	
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
%>
<html>
<head>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
 		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script> 
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



		<style>
				thead td, thead td.locked	{
				background-color: navy;
				color: white;
				position:relative;}	
				thead td {
				top: expression(document.getElementById("tbl-container").scrollTop-2); 
				z-index: 20;}
				thead td.locked {z-index: 30;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
				td.locked,  th.locked{
				left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
				position: relative;
				z-index: 10;}
			</style>


<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
<form>
	<!--<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>-->

<%
	int i=0;
	if(tab_chk.equals("pymtdet_tab"))
	{			
			
	try{			
			String sqlPayDet="SELECT DOC_TYPE_CODE, DOC_NUMBER, to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS') DOCM_DATE, RECPT_NATURE_CODE, DOC_AMT, CASH_SLMT_FLAG,CANCELLED_IND, CASH_COUNTER_CODE,ADDED_BY_ID FROM BL_RECEIPT_REFUND_DTL_VW WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND PATIENT_ID = '"+strPatientId+"' AND ((BILL_DOC_TYPE_CODE ='"+strBillDocTypeCode+"'  AND BILL_DOC_NUMBER = '"+strBillDocNum+"') OR ((DOC_TYPE_CODE, DOC_NUMBER,DOC_SRNO) IN ( SELECT ORG_DOC_TYPE_CODE,  ORG_DOC_NUM ,ORG_DOC_SRNO FROM BL_PATIENT_LEDGER WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND AD_PR_ADJ_BILL_DOC_TYPE = '"+strBillDocTypeCode+"' AND AD_PR_ADJ_BILL_DOC_NUM = '"+strBillDocNum+"'))) order by DOC_DATE desc ";
			HashMap sqlMap = new HashMap();			
			sqlMap.put("sqlData",sqlPayDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("DOC_NUMBER");
			displayFields.add("DOCM_DATE");
			displayFields.add("RECPT_NATURE_CODE");
			displayFields.add("DOC_AMT");
			displayFields.add("CASH_SLMT_FLAG");
			displayFields.add("CANCELLED_IND");
			displayFields.add("CASH_COUNTER_CODE");
			displayFields.add("ADDED_BY_ID");
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {

%>
<div>
<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td ></td>		
		<td >
	<%
		// For display the previous/next link

	     out.println(result.get(1));
		
	%>
		</td></tr>
	</table></div>
			<div id="tbl-container" STYLE="overflow: auto;/*  width: 1020px; */ height: 270px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<thead><tr>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.CASHIER.label" bundle="${bl_labels}"/></td>				
			</tr></thead>
<%

		/*try{			
			String sqlPayDet="SELECT DOC_TYPE_CODE, DOC_NUMBER, to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS'), RECPT_NATURE_CODE, DOC_AMT, CASH_SLMT_FLAG,CANCELLED_IND, CASH_COUNTER_CODE,ADDED_BY_ID FROM BL_RECEIPT_REFUND_DTL_VW WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND PATIENT_ID = '"+strPatientId+"' AND ((BILL_DOC_TYPE_CODE ='"+strBillDocTypeCode+"'  AND BILL_DOC_NUMBER = '"+strBillDocNum+"') OR ((DOC_TYPE_CODE, DOC_NUMBER,DOC_SRNO) IN ( SELECT ORG_DOC_TYPE_CODE,  ORG_DOC_NUM ,ORG_DOC_SRNO FROM BL_PATIENT_LEDGER WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"' AND AD_PR_ADJ_BILL_DOC_TYPE = '"+strBillDocTypeCode+"' AND AD_PR_ADJ_BILL_DOC_NUM = '"+strBillDocNum+"'))) ";
			System.out.println("sqlPayDet: "+sqlPayDet);
				pstmt = con.prepareStatement(sqlPayDet);
				rs = pstmt.executeQuery();					
				while(rs.next())
					{
					 System.out.println("inside while");
					  str_doc_type_code= rs.getString(1);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  System.out.println("str_doc_type_code "+str_doc_type_code);

					  str_doc_num = rs.getString(2);
					  if(str_doc_num==null) str_doc_num="";
					  System.out.println("str_doc_num "+str_doc_num);

					  str_doc_date= rs.getString(3);
					  if(str_doc_date==null) str_doc_date="";
					  System.out.println("str_doc_date "+str_doc_date);

					  str_rcpt_nature_code= rs.getString(4);
					  if(str_rcpt_nature_code==null) str_rcpt_nature_code="";
					  System.out.println("str_rcpt_nature_code "+str_rcpt_nature_code);

					  str_doc_amt = rs.getString(5);
					  if(str_doc_amt==null) str_doc_amt="";
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);
					  System.out.println("str_doc_amt "+str_doc_amt);

					  str_cash_slmt_flag = rs.getString(6);
					  if(str_cash_slmt_flag==null) str_cash_slmt_flag="";
					  System.out.println("str_cash_slmt_flag "+str_cash_slmt_flag);

					  str_cancelled_ind= rs.getString(7);
					  if(str_cancelled_ind==null) str_cancelled_ind="";
					  System.out.println("str_cancelled_ind "+str_cancelled_ind);

					  str_cash_ctr_code = rs.getString(8);
					  if(str_cash_ctr_code==null) str_cash_ctr_code="";
					  System.out.println("str_cash_ctr_code "+str_cash_ctr_code);

					  str_add_by_id = rs.getString(9);
					  if(str_add_by_id==null) str_add_by_id="";
					  System.out.println("str_add_by_id "+str_add_by_id);	*/
					ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{				
					if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);

					  str_doc_type_code = (String)records.get(0);						
					  if(str_doc_type_code==null) str_doc_type_code="";

					  str_doc_num =  (String)records.get(1);
					  if(str_doc_num==null) str_doc_num="";

					  str_doc_date=  (String)records.get(2);
					  if(str_doc_date==null) str_doc_date="";

					  str_rcpt_nature_code=  (String)records.get(3);
					  if(str_rcpt_nature_code==null) str_rcpt_nature_code="";

					  str_doc_amt =  (String)records.get(4);
					  if(str_doc_amt==null) str_doc_amt="";
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);

					  str_cash_slmt_flag =  (String)records.get(5);
					  if(str_cash_slmt_flag==null) str_cash_slmt_flag="";

					  str_cancelled_ind=  (String)records.get(6);
					  if(str_cancelled_ind==null) str_cancelled_ind="";
					  str_cash_ctr_code =  (String)records.get(7);
					  if(str_cash_ctr_code==null) str_cash_ctr_code="";

					  str_add_by_id =  (String)records.get(8);
					  if(str_add_by_id==null) str_add_by_id="";
						
						str_doc_date = com.ehis.util.DateUtils.convertDate(str_doc_date,"DMYHMS","en",locale);
				

%>			<tbody>
			<tr id=row<%=i%>>			
			<td class=<%=classval%> width='8%'><%=str_doc_type_code%></td>	 
			<td class=<%=classval%> width="8%"><%=str_doc_num%></td>		
			<td class=<%=classval%> width="18%" ><%=str_doc_date%></td>
			<td class=<%=classval%> width="8%" ><%=str_rcpt_nature_code%></td>
			<td class=<%=classval%> width="10%" style='text-align:right'><%=str_doc_amt%></td>
			<td class=<%=classval%> width="12%" ><%=str_cash_ctr_code%></td>
			<td class=<%=classval%> width="10%"  ><%=str_add_by_id%></td>				
			</tr>
<%
				i++;
		 }//while	
			//if (rs != null)   rs.close();
			//if (pstmt != null) pstmt.close();	
		%>
		</tbody>
		  </table>
		  </div>
		<%
		out.flush();
		}
		 else {
			 %>
			 <div id="tbl-container" STYLE="overflow: auto; /* width: 1020px; */ height: 250px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' align = 'center' id='enctr_bill_det' width='100%'>			
			<thead><tr>			
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.CASH_COUNTER.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="eBL.CASHIER.label" bundle="${bl_labels}"/></td>				
			</tr></thead>
			<tbody>
<%
		java.util.Locale loc = new java.util.Locale("en");
		java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
		String noRecord = bl_labels.getString("BL9812");
%>
			<tr>
					<td colspan='10'><div align='center'><%=noRecord%> </div></td>
			</tr>
			</tbody>
			</table></div>


		<script></script>
<%
			}
		}catch(Exception e)
			{
				System.out.println("ErrorPayDet= "+e);
			}
	}


		if(tab_chk.equals("adjdet_tab"))
		{
%>
			
<%
			try{
				String sqlAdjDet = "SELECT A.DOC_TYPE_CODE, A.DOC_NUM, A.DOC_SLNO, to_char(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') DOCM_DATE, A.DOC_AMT,A.REMARKS, DECODE(B.CANCELLED_YN,'Y','CANCELLED') CANCELLED_IND FROM BL_BILL_ADJ_DTL A, BL_BILL_ADJ_HDR B  WHERE A.OPERATING_FACILITY_ID='"+strFacilityId+"' AND A.ADJUST_EXEMPT_IND='A' AND A.ADJ_DOC_TYPE_CODE = '"+strBillDocTypeCode+"' AND A.ADJ_DOC_NUM = '"+strBillDocNum+"' and A.DOC_TYPE_CODE =B.DOC_TYPE_CODE  and B.DOC_NUM = A.DOC_NUM  ";
				HashMap sqlMap = new HashMap();			
				sqlMap.put("sqlData",sqlAdjDet);
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();
				ArrayList chkFields = new ArrayList();
				displayFields.add("DOC_TYPE_CODE");
				displayFields.add("DOC_NUMBER");
				displayFields.add("DOC_SLNO");
				displayFields.add("DOCM_DATE");
				displayFields.add("DOC_AMT");
				displayFields.add("REMARKS");
				displayFields.add("CANCELLED_IND");				
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>
<div>
<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td ></td>		
		<td >
	<%
		// For display the previous/next link

	     out.println(result.get(1));
		
	%>
		</td></tr>
	</table></div>
	<div id="tbl-container" STYLE="overflow: auto; /* width: 1020px;  */height: 270px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>

			<thead><tr>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></td>				
			</tr></thead>
<%
				/*String sqlAdjDet = "SELECT A.DOC_TYPE_CODE, A.DOC_NUM, A.DOC_SLNO, to_char(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS'), A.DOC_AMT,A.REMARKS, DECODE(B.CANCELLED_YN,'Y','CANCELLED') FROM BL_BILL_ADJ_DTL A, BL_BILL_ADJ_HDR B  WHERE A.OPERATING_FACILITY_ID='"+strFacilityId+"' AND A.ADJUST_EXEMPT_IND='A' AND A.ADJ_DOC_TYPE_CODE = '"+strBillDocTypeCode+"' AND A.ADJ_DOC_NUM = '"+strBillDocNum+"' and A.DOC_TYPE_CODE =B.DOC_TYPE_CODE  and B.DOC_NUM = A.DOC_NUM  ";
				System.out.println("sqlAdjDet: "+sqlAdjDet);
				pstmt = con.prepareStatement(sqlAdjDet);
				rs1 = pstmt.executeQuery();					
				while(rs1.next())
					{
					  str_doc_type_code= rs.getString(1);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  System.out.println("str_doc_type_code "+str_doc_type_code);
					  str_doc_num = rs.getString(2);
					  if(str_doc_num==null) str_doc_num="";
					  System.out.println("str_doc_num "+str_doc_num);
					  str_doc_ser_num = rs.getString(3);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  System.out.println("str_doc_ser_num "+str_doc_ser_num);
					  str_doc_date= rs.getString(4);
					  if(str_doc_date==null) str_doc_date="";
					  System.out.println("str_doc_date "+str_doc_date);
					  str_doc_amt = rs.getString(5);
					  if(str_doc_amt==null) str_doc_amt="0";
					  System.out.println("str_doc_amt "+str_doc_amt);
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);
					  str_remarks = rs.getString(6);
					  if(str_remarks==null) str_remarks="";
					  System.out.println("str_remarks "+str_remarks);
					  str_cancelled_ind= rs.getString(7);
					  if(str_cancelled_ind==null) str_cancelled_ind="";
					  System.out.println("str_cancelled_ind "+str_cancelled_ind);	*/		
					ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{				
									
					if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);
						str_doc_type_code = (String)records.get(0);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  str_doc_num = (String)records.get(1);
					  if(str_doc_num==null) str_doc_num="";
					  str_doc_ser_num = (String)records.get(2);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  str_doc_date= (String)records.get(3);
					  if(str_doc_date==null) str_doc_date="";
					  str_doc_amt = (String)records.get(4);
					  if(str_doc_amt==null) str_doc_amt="0";
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);
					  str_remarks = (String)records.get(5);
					  if(str_remarks==null) str_remarks="";
					  str_cancelled_ind= (String)records.get(6);
					  if(str_cancelled_ind==null) str_cancelled_ind="";

						str_doc_date = com.ehis.util.DateUtils.convertDate(str_doc_date,"DMYHMS","en",locale);

%>			<tbody>
			<tr id=row<%=i%>>			
			<td class=<%=classval%> width='10%'><%=str_doc_type_code%></td>	 
			<td class=<%=classval%> width="10%"><%=str_doc_num%></td>		
			<td class=<%=classval%> width="20%" ><%=str_doc_date%></td>			
			<td class=<%=classval%> width="10%" style='text-align:right'><%=str_doc_amt%></td>
			<td class=<%=classval%> width="30%" ><%=str_remarks%></td>
			<td class=<%=classval%> width="5%"  ><%=str_cancelled_ind%></td>				
			</tr>
<%
			i++;
			}//while	
%>
		</tbody>
		</table>
		</div>
<%
			out.flush();
		}
		 else {

				//if (rs != null)   rs.close();
				//if (pstmt != null) pstmt.close();	

%>
		<script></script>
<%
			}
 			}catch(Exception e)
			{
				System.out.println("ErrorAdjDet= "+e);
			}
	}
		if(tab_chk.equals("exmtdet_tab"))
		{
%>
			
<%
			try{
				String sqlExmDet = "SELECT A.DOC_TYPE_CODE DOC_TYPE_CODE1,A.DOC_NUM  DOC_NUM1, A.DOC_SLNO DOC_SLNO1, to_char(A.DOC_DATE,'DD/MM/YYYY HH24:MI:SS') DOCM_DATE1, A.DOC_AMT DOC_AMT1, A.REMARKS REMARKS1, DECODE(B.CANCELLED_YN,'Y','CANCELLED') CANCELLED_IND1 FROM BL_BILL_ADJ_DTL A, BL_BILL_ADJ_HDR B WHERE A.OPERATING_FACILITY_ID='"+strFacilityId+"' AND A.ADJUST_EXEMPT_IND='E' AND A.ADJ_DOC_TYPE_CODE = '"+strBillDocTypeCode+"' AND A.ADJ_DOC_NUM = '"+strBillDocNum+"' and A.DOC_TYPE_CODE =B.DOC_TYPE_CODE  and B.DOC_NUM = A.DOC_NUM ";
				HashMap sqlMap = new HashMap();			
				sqlMap.put("sqlData",sqlExmDet);
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();
				ArrayList chkFields = new ArrayList();
				displayFields.add("DOC_TYPE_CODE1");
				displayFields.add("DOC_NUM1");
				displayFields.add("DOC_SLNO1");
				displayFields.add("DOCM_DATE1");
				displayFields.add("DOC_AMT1");
				displayFields.add("REMARKS1");
				displayFields.add("CANCELLED_IND1");				
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>
		<div>
		<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td ></td>		
		<td >
	<%
		// For display the previous/next link

	     out.println(result.get(1));
		
	%>
		</td></tr>
	</table></div>
	<div id="tbl-container" STYLE="overflow: auto; /* width: 1020px; */ height: 270px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>

			<thead><tr>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></td>				
			</tr></thead>
<%

				/*pstmt = con.prepareStatement(sqlExmDet);
				rs1 = pstmt.executeQuery();					
				while(rs1.next())
					{
						System.out.println("INSIDE WHILE");
					  str_doc_type_code= rs1.getString(1);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  System.out.println("str_doc_type_code "+str_doc_type_code);

					  str_doc_num = rs1.getString(2);
					  if(str_doc_num==null) str_doc_num="";
					  System.out.println("str_doc_num "+str_doc_num);

					  str_doc_ser_num = rs1.getString(3);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  System.out.println("str_doc_ser_num "+str_doc_ser_num);

					  str_doc_date= rs1.getString(4);
					  if(str_doc_date==null) str_doc_date="";
					  System.out.println("str_doc_date "+str_doc_date);

					  str_doc_amt = rs1.getString(5);
					  if(str_doc_amt==null) str_doc_amt="0";
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);
					  System.out.println("str_doc_amt "+str_doc_amt);

					  str_remarks = rs1.getString(6);
					  if(str_remarks==null) str_remarks="";
					  System.out.println("str_remarks "+str_remarks);

					  str_cancelled_ind= rs1.getString(7);
					  if(str_cancelled_ind==null) str_cancelled_ind="";
					  System.out.println("str_cancelled_ind "+str_cancelled_ind);*/
									
					ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{				
									
					if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);
						str_doc_type_code = (String)records.get(0);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  str_doc_num = (String)records.get(1);
					  if(str_doc_num==null) str_doc_num="";
					  str_doc_ser_num = (String)records.get(2);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  str_doc_date= (String)records.get(3);
					  if(str_doc_date==null) str_doc_date="";
					  str_doc_amt = (String)records.get(4);
					  if(str_doc_amt==null) str_doc_amt="0";
					  str_doc_amt = cf.formatCurrency(str_doc_amt, noofdecimal);
					  str_remarks = (String)records.get(5);
					  if(str_remarks==null) str_remarks="";
					  str_cancelled_ind= (String)records.get(6);
					  if(str_cancelled_ind==null) str_cancelled_ind="";

						str_doc_date = com.ehis.util.DateUtils.convertDate(str_doc_date,"DMYHMS","en",locale);

%>			</tbody>	
			<tr id=row<%=i%>>			
			<td class=<%=classval%> width='10%'><%=str_doc_type_code%></div></td>	 
			<td class=<%=classval%> width="10%"><%=str_doc_num%></div> </td>		
			<td class=<%=classval%> width="20%"><%=str_doc_date%></td>			
			<td class=<%=classval%> width="10%" style='text-align:right'><%=str_doc_amt%></td>
			<td class=<%=classval%> width="30%"><%=str_remarks%></td>
			<td class=<%=classval%> width="5%" ><%=str_cancelled_ind%></td>				
			</tr>
<%
				i++;
					}//while
%>			</tbody>
			</table>
			</div>
<%
				out.flush();
		}
		 else {

				//if (rs != null)   rs.close();
				//if (pstmt != null) pstmt.close();	

%>
		<script></script>
<%
			}
		}catch(Exception e)
		{
			System.out.println("ErrorExmptDet= "+e);
		}
	}
		if(tab_chk.equals("remdet_tab"))
		{
%>			
<%
			try{				
				//String sqlRemDet = "SELECT REMINDER_NO, REMINDER_DISP_DOC_TYPE, REMINDER_DISP_DOC_NUMBER||'/'|| REMINDER_DISP_DOC_SLNO, TOT_OUTSTDG_AMT, REASON_CODE, to_char(REMINDER_DISPATCHED_DATE,'DD/MM/YYYY HH24:MI:SS'), to_char(REMINDER_RECEIVED_BACK_DATE,'DD/MM/YYYY HH24:MI:SS')  FROM BL_BILLS_FOR_REMINDER WHERE OPERATING_FACILITY_ID = '"+strFacilityId+"'  AND DOC_TYPE_CODE = '"+strBillDocTypeCode+"' AND DOC_NUM = '"+strBillDocNum+"' ORDER BY REMINDER_NO,REMINDER_DISPATCHED_DATE " ;
				String sqlRemDet = "SELECT A.REMINDER_NO REM_NO , A.REMINDER_DISP_DOC_TYPE REM_DISP_DOC_TYPE, A.REMINDER_DISP_DOC_NUMBER||'/'|| A.REMINDER_DISP_DOC_SLNO DOC_DISP_SER_NO, A.TOT_OUTSTDG_AMT OUTSTAND_AMT, B.ACTION_REASON_DESC ACT_RES_CODE,to_char(A.REMINDER_DISPATCHED_DATE,'DD/MM/YYYY HH24:MI:SS') DISP_DATE,to_char(A.REMINDER_RECEIVED_BACK_DATE,'DD/MM/YYYY HH24:MI:SS') BACK_DATE, A.REMINDER_NOT_DELIVERED_YN NOT_DELIVER_YN  FROM BL_BILLS_FOR_REMINDER A,BL_ACTION_REASON_LANG B WHERE OPERATING_FACILITY_ID ='"+strFacilityId+"'  AND DOC_TYPE_CODE = '"+strBillDocTypeCode+"' AND DOC_NUM ='"+strBillDocNum+"' AND A.REASON_CODE = B. ACTION_REASON_CODE   And B.LANGUAGE_ID = '"+locale+"' ORDER BY REMINDER_NO,REMINDER_DISPATCHED_DATE " ;
				HashMap sqlMap = new HashMap();			
				sqlMap.put("sqlData",sqlRemDet);
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();
				ArrayList chkFields = new ArrayList();
				displayFields.add("REM_NO");
				displayFields.add("REM_DISP_DOC_TYPE");
				displayFields.add("DOC_DISP_SER_NO");
				displayFields.add("OUTSTAND_AMT");
				displayFields.add("ACT_RES_CODE");
				displayFields.add("DISP_DATE");
				displayFields.add("BACK_DATE");				
				displayFields.add("NOT_DELIVER_YN");				
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>
<div>
<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td ></td>		
		<td >
	<%
		// For display the previous/next link

	     out.println(result.get(1));
		
	%>
		</td></tr>
	</table></div>
			<div id="tbl-container" STYLE="overflow: auto; /* width: 1020px; */ height: 270px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<thead><tr>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.REMAINDER.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='4%'><fmt:message key="Common.NotDelivered.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.RECEIVED_BACK_ON.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='25'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>				
			</tr></thead>
<%
				/*pstmt = con.prepareStatement(sqlRemDet);
				rs2 = pstmt.executeQuery();					
				while(rs2.next())
					{
					  str_rem_num= rs2.getString(1);
					  if(str_rem_num==null) str_rem_num="";
					  System.out.println("str_rem_num "+str_rem_num);
					  str_rem_disp_doc_type = rs2.getString(2);
					  if(str_rem_disp_doc_type==null) str_rem_disp_doc_type="";
					  System.out.println("str_rem_disp_doc_type "+str_rem_disp_doc_type);
					  str_doc_ser_num = rs2.getString(3);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  System.out.println("str_doc_ser_num "+str_doc_ser_num);
					  str_tot_outstd_amt = rs2.getString(4);
					  if(str_tot_outstd_amt==null) str_tot_outstd_amt="";
					  str_tot_outstd_amt = cf.formatCurrency(str_tot_outstd_amt, noofdecimal);
					  System.out.println("str_tot_outstd_amt "+str_tot_outstd_amt);
					  str_reason_desc = rs2.getString(5);
					  if(str_reason_desc==null) str_reason_desc="";
					  System.out.println("str_reason_desc "+str_reason_desc);
					  str_rem_disp_date = rs2.getString(6);
					  if(str_rem_disp_date==null) str_rem_disp_date="";
					  System.out.println("str_rem_disp_date "+str_rem_disp_date);
					  str_rem_back_date = rs2.getString(7);
					  if(str_rem_back_date==null) str_rem_back_date="";
					  System.out.println("str_rem_back_date "+str_rem_back_date);
					  str_rem_not_deliver_yn = rs2.getString(8);
					  if(str_rem_not_deliver_yn==null) str_rem_not_deliver_yn="";
					  System.out.println("str_rem_not_deliver_yn "+str_rem_not_deliver_yn);*/
					ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{				
									
					if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);
					  str_rem_num  = (String)records.get(0);
					  if(str_rem_num==null) str_rem_num="";
					  str_rem_disp_doc_type  = (String)records.get(1);
					  if(str_rem_disp_doc_type==null) str_rem_disp_doc_type="";
					  str_doc_ser_num = (String)records.get(2);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  str_tot_outstd_amt = (String)records.get(3);
					  if(str_tot_outstd_amt==null) str_tot_outstd_amt="";
					  str_tot_outstd_amt = cf.formatCurrency(str_tot_outstd_amt, noofdecimal);
					  str_reason_desc = (String)records.get(4);
					  if(str_reason_desc==null) str_reason_desc="";
					  str_rem_disp_date = (String)records.get(5);
					  if(str_rem_disp_date==null) str_rem_disp_date="";
					  str_rem_back_date = (String)records.get(6);
					  if(str_rem_back_date==null) str_rem_back_date="";
					  str_rem_not_deliver_yn = (String)records.get(7);
					  if(str_rem_not_deliver_yn==null) str_rem_not_deliver_yn="";
						
					  					
				str_rem_disp_date = com.ehis.util.DateUtils.convertDate(str_rem_disp_date,"DMYHMS","en",locale);
				str_rem_back_date = com.ehis.util.DateUtils.convertDate(str_rem_back_date,"DMYHMS","en",locale);
%>
			<tbody>
			<tr id=row<%=i%>>			
			<td class=<%=classval%> width='5%'><%=str_rem_num%></div></td>	 
			<td class=<%=classval%> width='10%'><%=str_rem_disp_doc_type%></div></td>	 
			<td class=<%=classval%> width="10%"><%=str_doc_ser_num%></div> </td>		
			<td class=<%=classval%> width="15%"><%=str_rem_disp_date%></td>			
			<td class=<%=classval%> width="10%" style='text-align:right'><%=str_tot_outstd_amt%></td>			
			<td class=<%=classval%> width="4%" ><%=str_rem_not_deliver_yn%></td>
			<td class=<%=classval%> width="15%" ><%=str_rem_back_date%></td>
			<td class=<%=classval%> width="25%"><%=str_reason_desc%></td>				
			</tr>
<%
				i++;
				}//while
%>
		</tbody>
		</table>
		</div>
<%

						out.flush();
		}
		 else {

				//if (rs != null)   rs.close();
				//if (pstmt != null) pstmt.close();	

%>
		<script></script>
<%
			}
	}catch(Exception e)
		{
			System.out.println("ErrorremDet= "+e);
		}
	}
		if(tab_chk.equals("writoffdet_tab"))
		{
%>			

<%
			try{				
				String sqlWritOff = "SELECT DOC_TYPE_CODE, DOC_NUM||'/'|| DOC_SLNO DOCNUM_SERNUM, to_char(DOC_DATE,'DD/MM/YYYY HH24:MI:SS') DOC_DATE, WO_APPROVED_AMT, WO_APPR_REJN_DOC_REF||'/'|| WO_APPR_REJN_DOC_REF_SL Approval_doc, Decode(CANCELLED_YN,'Y','Cancelled',null) cancelled FROM BL_WO_REQUEST_DTL WHERE OPERATING_FACILITY_ID='"+strFacilityId+"' AND WO_APPROVED_YN='Y' AND ORG_DOC_TYPE_CODE='"+strBillDocTypeCode+"' AND ORG_DOC_NUM='"+strBillDocNum+"' ";
				HashMap sqlMap = new HashMap();			
				sqlMap.put("sqlData",sqlWritOff);
				HashMap funcMap = new HashMap();
				ArrayList displayFields = new ArrayList();
				ArrayList chkFields = new ArrayList();
				displayFields.add("DOC_TYPE_CODE");
				displayFields.add("DOCNUM_SERNUM");
				displayFields.add("DOC_DATE");
				displayFields.add("WO_APPROVED_AMT");
				displayFields.add("Approval_doc");
				displayFields.add("cancelled");				
				funcMap.put("displayFields", displayFields);
				funcMap.put("chkFields", chkFields);
				ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
				if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
%>
		<div>
		<table  cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td ></td>		
		<td >
	<%
		// For display the previous/next link

	     out.println(result.get(1));
		
	%>
		</td></tr>
	</table></div>
			<div id="tbl-container" STYLE="overflow: auto;/*  width: 1020px; */ height: 270px;   padding:3px; margin: 0px">
			<table border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<thead><tr>				
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.DocumentNumber.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='20%'><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.amount.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER' width='30%'><fmt:message key="eBL.DOC_REF.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' width='5'><fmt:message key="Common.cancelled.label" bundle="${common_labels}"/></td>				
			</tr></thead>
<%
				/*pstmt = con.prepareStatement(sqlWritOff);
				rs3 = pstmt.executeQuery();					
				while(rs3.next())
					{
					  str_doc_type_code= rs3.getString(1);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  System.out.println("str_doc_type_code "+str_doc_type_code);					  
					  str_doc_ser_num = rs3.getString(2);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					  System.out.println("str_doc_ser_num "+str_doc_ser_num);
					   str_doc_date= rs3.getString(3);
					  if(str_doc_date==null) str_doc_date="";
					  System.out.println("str_doc_date "+str_doc_date);
					  str_wo_apprv_amt = rs3.getString(4);
					  if(str_wo_apprv_amt==null) str_wo_apprv_amt="";
					  str_wo_apprv_amt = cf.formatCurrency(str_wo_apprv_amt, noofdecimal);
					  System.out.println("str_wo_apprv_amt "+str_wo_apprv_amt);
					  str_apprv_doc = rs3.getString(5);
					  if(str_apprv_doc==null) str_apprv_doc="";
					  System.out.println("str_apprv_doc "+str_apprv_doc);
					  str_cancelled_ind= rs3.getString(6);
					  if(str_cancelled_ind==null) str_cancelled_ind="";
					  System.out.println("str_cancelled_ind "+str_cancelled_ind);*/
					  	ArrayList records=new ArrayList();
					for(int j=2; j<result.size(); j++)
					{				
				
					  	if(i % 2 == 0 )
						{
							classval	=	"QRYEVEN";
						}
						else
						{
							classval	=	"QRYODD";
						}
						records=(ArrayList) result.get(j);
						str_doc_type_code= (String)records.get(0);
					  if(str_doc_type_code==null) str_doc_type_code="";
					  str_doc_ser_num = (String)records.get(1);
					  if(str_doc_ser_num==null) str_doc_ser_num="";
					   str_doc_date= (String)records.get(2);
					  if(str_doc_date==null) str_doc_date="";
					  str_wo_apprv_amt = (String)records.get(3);
					  if(str_wo_apprv_amt==null) str_wo_apprv_amt="";
					  str_wo_apprv_amt = cf.formatCurrency(str_wo_apprv_amt, noofdecimal);
					  str_apprv_doc = (String)records.get(4);
					  if(str_apprv_doc==null) str_apprv_doc="";
					  str_cancelled_ind= (String)records.get(5);
					  if(str_cancelled_ind==null) str_cancelled_ind="";

						
				str_doc_date = com.ehis.util.DateUtils.convertDate(str_doc_date,"DMYHMS","en",locale);

%>			<tbody>
			<tr id=row<%=i%>>			
			<td class=<%=classval%> width='10%'><%=str_doc_type_code%></td>	 
			<td class=<%=classval%> width='10%'><%=str_doc_ser_num%></td>	 
			<td class=<%=classval%> width="10%"><%=str_doc_date%> </td>					
			<td class=<%=classval%> width="20%" style='text-align:right'><%=str_wo_apprv_amt%></td>			
			<td class=<%=classval%> width="10%"><%=str_apprv_doc%></td>
			<td class=<%=classval%> width="30%"><%=str_apprv_doc%></td>
			<td width="5%" class=<%=classval%> ><%=str_cancelled_ind%></td>				
			</tr>
<%
				i++;
			}//while
%>	
			</tbody>
			</table>
			</div>
<%

						out.flush();
			}
		 else {

				//if (rs != null)   rs.close();
				//if (pstmt != null) pstmt.close();	

%>
		<script></script>
<%
			}
	 }catch(Exception e)
		{
			System.out.println("ErrorWritDet= "+e);
		}
	}
%>

</table>
<%
	}
		catch(Exception eX)
		{
			System.out.println("Error= "+eX);
		}
		finally 
			{				
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							 }
			}
%>
</form>

<%out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLViewEncounterPaymentDet.jsp",searched));%>
</body>
</html>

