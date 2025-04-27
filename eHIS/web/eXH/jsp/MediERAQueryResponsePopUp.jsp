<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*"  %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="eXH.XHDBAdapter" import="java.text.SimpleDateFormat" import="java.util.Date"%>
<%@ page import="java.sql.*, java.util.*,java.net.*, java.text.*, java.net.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ page import="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>
<% String sStyle = (String)session.getAttribute("PREFERRED_STYLE"); %>
<html>
	<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script Language="javascript" src="../../eMP/js/PasInterface.js"> </script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		tr, td{
			border-bottom: 1px solid #d5ecfb;
			border-top: 1px solid #d5ecfb;
			border-left: 1px solid #d5ecfb;
			border-right: 1px solid #d5ecfb;			
		}

		.btn {
			border: none; /* Remove borders */
			color: white; /* Add a text color */
			padding: 5px 20px; /* Add some padding */
			cursor: pointer; /* Add a pointer cursor on mouse-over */
		}

		.btn {background-color: #0063c5;} /* Blue */
		.btn:hover {background: #0b7dda;}
	
		tbody {
			 height: 4px;
			 overflow: auto;
		}

	</style>
	<script>
		function cancel()
		{
			window.close();
		}
		function toggle(line_num)
		{
			 if( document.getElementById("hidethis"+line_num).style.display=='none' ){
			   document.getElementById("hidethis"+line_num).style.display = 'table'; // set to table-row instead of an empty string
			 }else{
			   document.getElementById("hidethis"+line_num).style.display = 'none';
			 }
		}
	</script>

	<title>
		EClaims Transaction Response Window
	</title>
	</head>
	<body>
		<form>
		<%

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			ResultSet rs_status=null;

			String l_trans_hdr_query = "", l_trans_dtl_query = "", l_patient_query = "", l_status_dtl_query = "",l_status_trx_query = "";

			String l_app_msg = "";

			String l_patient_id = "", l_episode_id = "", l_episode_type = "", l_visit_id = "", l_patient_name = "", l_sex = "", l_date_of_birth = "";
			String l_cust_code = "", l_destination_code = "", l_membership_num = "", l_wca_number = "", l_dependent_num = "",l_dependent_relationship_desc = "" ,l_dependent_relationship = "", l_authorization_num = "", l_customer_name = "";
			String l_trans_type = "", l_event_type = "", l_case_num = "", l_claim_num = "", l_request_date = "", l_request_status = "", l_approval_status = "", l_warn_code = "", l_warn_desc = "";
			String l_doc_type_code = "", l_doc_num = "", l_doc_date = "", l_claimed_amount = "", l_appr_net_amount = "", l_received_amount = "";

			String l_episode_type_desc = "", l_transaction_desc = "", l_approval_status_desc = "";

			String l_bill_doc_line_num = "", l_serv_qty = "", l_blng_serv_code = "", l_blng_serv_desc = "", l_serv_item_code = "", l_serv_item_desc = "";
			String l_serv_gross_amt = "", l_serv_disc_amt = "", l_serv_net_amt = "", l_appr_gross = "", l_appr_net = "", l_appr_disc = "", l_claim_status = "", l_claim_status_desc = "", l_item_status_code = "", l_item_status_desc = "", l_received_amt = "";
           
			String l_status_type = "", l_status_code = "", l_status_desc = "",l_status_trx_type = "", l_status_trx_code = "", l_status_trx_desc = "";

			String trans_num = XHDBAdapter.checkNull(request.getParameter("trans_num")); 
			String era_id = XHDBAdapter.checkNull(request.getParameter("era_id")); 

			

            ResultSetMetaData rsmd =null;
			int columnCount =0;

			String l_rej_image_str = "";

            ArrayList arrRow = new ArrayList();
            ArrayList arrColumns = new ArrayList();
			ArrayList arrRow1 = new ArrayList();
            ArrayList arrColumns1 = new ArrayList();
			String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

			l_app_msg = "PatientQueryResponsePopUp.jsp:::trans_num....."+trans_num;
			if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

			String hideTable = "style='display:none;'";

			l_app_msg = "::: MK_ERA_NO : "+era_id;
			if(isDebugYN.equals("Y")) System.out.println(l_app_msg);


			try
			{ 
				conn = ConnectionManager.getConnection(request);

				l_trans_hdr_query= "Select FACILITY_ID, a.PATIENT_ID, EPISODE_ID, EPISODE_TYPE, VISIT_ID, nvl(b.FIRST_NAME,b.PATIENT_NAME) PATIENT_NAME , b.SEX, to_char(b.DATE_OF_BIRTH, 'DD/MM/YYYY') DATE_OF_BIRTH, "
								   +"		a.CUST_CODE, DESTINATION_CODE, MEMBERSHIP_NUM, WCA_NUMBER, DEPENDENT_NUM, DEPENDENT_RELATIONSHIP, AUTHORIZATION_NUM, "
								   +"		a.TRANS_TYPE, a.EVENT_TYPE, CASE_NUM, CLAIM_NUM, to_char(REQUEST_DATE, 'DD/MM/YYYY HH24:mi:ss') REQUEST_DATE, REQUEST_STATUS, APPROVAL_STATUS, WARN_CODE, WARN_DESC, "
								   +"		a.DOC_TYPE_CODE, a.DOC_NUM, to_char(DOC_DATE, 'DD/MM/YYYY HH24:mi:ss') DOC_DATE, TO_CHAR (a.SUB_GROSS_AMOUNT, 9999990.99) SUB_GROSS_AMOUNT, TO_CHAR (a.APPR_NET_AMOUNT, 9999990.99) APPR_NET_AMOUNT, "
								   +"		TO_CHAR (a.PAID_TO_PROVIDER, 9999990.99) PAID_TO_PROVIDER, c.SHORT_NAME CUSTOMER_NAME, e.STATUS_DESC "
								   +" from XF_ECLAIMS_TRX_HDR a, MP_PATIENT b, AR_CUSTOMER c, xf_era_claim d, XH_TRANS_STATUS e "
								   +" where a.PATIENT_ID = b.PATIENT_ID  and a.CUST_CODE = c.CUST_CODE(+) "
								   +"		AND a.doc_num = d.bill_doc_number(+) "
								   +"		AND nvl(d.process_status,'0') = e.status_code(+) "
								   +"		AND e.APPLICATION_ID = 'ECLAIMS' "
								   +"		and e.TRANS_TYPE = 'CLA' "
								   +"		and e.TRANS_EVENT = 'ERA' "								   
								   +"		AND SRL_NO = ?" ;	
								   
				l_app_msg = "::: L_TRANS_HDR_QUERY : "+l_trans_hdr_query;
				if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

				pstmt = conn.prepareStatement(l_trans_hdr_query);
				pstmt.setInt(1, Integer.parseInt(trans_num));
				rs = pstmt.executeQuery();

                rsmd = rs.getMetaData(); 
                columnCount = rsmd.getColumnCount();

                l_app_msg = "columnCount "+columnCount;
			    if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

				while(rs.next())
				{
					l_patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
					l_episode_id = rs.getString("EPISODE_ID")==null?"":rs.getString("EPISODE_ID");
					l_episode_type = rs.getString("EPISODE_TYPE")==null?"":rs.getString("EPISODE_TYPE");
					l_visit_id = rs.getString("VISIT_ID")==null?"":rs.getString("VISIT_ID");
					l_patient_name = rs.getString("PATIENT_NAME")==null?"":rs.getString("PATIENT_NAME");
					l_sex = rs.getString("SEX")==null?"":rs.getString("SEX");
					l_date_of_birth = rs.getString("DATE_OF_BIRTH")==null?"":rs.getString("DATE_OF_BIRTH");

					l_cust_code = rs.getString("CUST_CODE")==null?"":rs.getString("CUST_CODE");
					l_destination_code = rs.getString("DESTINATION_CODE")==null?"":rs.getString("DESTINATION_CODE");
					l_membership_num = rs.getString("MEMBERSHIP_NUM")==null?"":rs.getString("MEMBERSHIP_NUM");
					l_wca_number = rs.getString("WCA_NUMBER")==null?"":rs.getString("WCA_NUMBER");
					l_dependent_num = rs.getString("DEPENDENT_NUM")==null?"":rs.getString("DEPENDENT_NUM");
					l_dependent_relationship = rs.getString("DEPENDENT_RELATIONSHIP")==null?"":rs.getString("DEPENDENT_RELATIONSHIP");
					l_authorization_num = rs.getString("AUTHORIZATION_NUM")==null?"":rs.getString("AUTHORIZATION_NUM");

					l_trans_type = rs.getString("TRANS_TYPE")==null?"":rs.getString("TRANS_TYPE");
					l_event_type = rs.getString("EVENT_TYPE")==null?"":rs.getString("EVENT_TYPE");
					l_case_num = rs.getString("CASE_NUM")==null?"":rs.getString("CASE_NUM");
					l_claim_num = rs.getString("CLAIM_NUM")==null?"":rs.getString("CLAIM_NUM");

					l_request_date = rs.getString("REQUEST_DATE")==null?"":rs.getString("REQUEST_DATE");
					l_request_status = rs.getString("REQUEST_STATUS")==null?"":rs.getString("REQUEST_STATUS");
					l_approval_status = rs.getString("APPROVAL_STATUS")==null?"":rs.getString("APPROVAL_STATUS");
					l_warn_code = rs.getString("WARN_CODE")==null?"":rs.getString("WARN_CODE");
					l_warn_desc = rs.getString("WARN_DESC")==null?"":rs.getString("WARN_DESC");

					l_doc_type_code = rs.getString("DOC_TYPE_CODE")==null?"":rs.getString("DOC_TYPE_CODE");
					l_doc_num = rs.getString("DOC_NUM")==null?"":rs.getString("DOC_NUM");
					l_doc_date = rs.getString("DOC_DATE")==null?"":rs.getString("DOC_DATE");
					l_claimed_amount = rs.getString("SUB_GROSS_AMOUNT")==null?"":rs.getString("SUB_GROSS_AMOUNT");
					l_appr_net_amount = rs.getString("APPR_NET_AMOUNT")==null?"":rs.getString("APPR_NET_AMOUNT");
					l_received_amount = rs.getString("PAID_TO_PROVIDER")==null?"":rs.getString("PAID_TO_PROVIDER");

					l_approval_status_desc = rs.getString("STATUS_DESC")==null?"":rs.getString("STATUS_DESC");


					l_customer_name = rs.getString("CUSTOMER_NAME")==null?"":rs.getString("CUSTOMER_NAME");

					if (l_episode_type.equals("I"))
						l_episode_type_desc = "Inpatient";
					if (l_episode_type.equals("O"))
						l_episode_type_desc = "Outpatient";
					if (l_episode_type.equals("E"))
						l_episode_type_desc = "Emergency";
					if (l_episode_type.equals("D"))
						l_episode_type_desc = "Daycare";

					if (l_event_type.equals("CLA") || l_event_type.equals("CLE"))
						l_transaction_desc = " ERA - Claims";
					
					

					if(l_dependent_relationship.equals("1"))
						l_dependent_relationship_desc ="Self"; 
					if(l_dependent_relationship.equals("2"))
						l_dependent_relationship_desc ="Spouse";
					if(l_dependent_relationship.equals("3"))
						l_dependent_relationship_desc ="Child"; 
					if(l_dependent_relationship.equals("4"))
						l_dependent_relationship_desc ="Other";

					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

				}				
                l_app_msg = "l_trans_hdr_query after while"+rs;
			    if(isDebugYN.equals("Y")) System.out.println(l_app_msg);
				%>
				<table width="100%" cellPadding="3" bgcolor="#000000" border="1" style="border-collapse: collapse;margin-top: 10px;border-style: solid;border-color: #d5ecfb #d5ecfb;">
					<tr>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_patient_id%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_patient_name%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.gender.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_sex.equals("M")?"Male":"Female"%></td>
					</tr>
					<tr>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_episode_id%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_episode_type_desc%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="eBL.PayerName.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_customer_name%></td>
					</tr>
				</table>
				<table width="100%" cellPadding="3" bgcolor="#000000" border="1" style="border-collapse: collapse;margin-top: 10px;border-style: solid;border-color: #d5ecfb #d5ecfb;">
					<tr>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/> <fmt:message key="eBL.NUM.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=trans_num%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></b></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_request_date%></td>
						<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/></b></td>
		 		        <td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_transaction_desc%></td>
					</tr>
					<%
						if (l_event_type.equals("CLA") || l_event_type.equals("CLE") || l_event_type.equals("REV") || l_event_type.equals("EOC") )
						{
							%>
								<tr>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="eBL.BILL_DOC_TYPE.label" bundle="${bl_labels}"/></b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_doc_type_code%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b><fmt:message key="eBL.BILL_DOC_NO.label" bundle="${bl_labels}"/></b></td>
									<td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_doc_num%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_approval_status_desc%></td>
								</tr>
								<tr>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="eXH.claimedAmount.label" bundle="${xh_labels}"/></b></td>
									<td class="gridNumericData"  style="font-size:11px;" width='15%' align='right' valign="top"><%=l_claimed_amount%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></b></td>
									<td class="gridNumericData"  style="font-size:11px;" width='20%' align='right' valign="top"><%=l_appr_net_amount%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="Common.received.label" bundle="${common_labels}"/><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"/></b></td>
									<td class="gridNumericData"  style="font-size:11px;" width='15%' align='right' valign="top"><%=l_received_amount%></td>
								</tr>
								<tr>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b>HNET Reference Number</b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_authorization_num%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b></b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"></td>
									<td class="gridData"  style="font-size:11px;" width='20%' valign="top"></td>
									
								</tr>

							<%

						}
						if (l_event_type.equals("IDC") || l_event_type.equals("UEC") || l_event_type.equals("FAM") || l_event_type.equals("IEC"))
						{
							%>
								<tr>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b><fmt:message key="eBL.PayerName.label" bundle="${bl_labels}"/></b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_customer_name%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b>Membership No.</b></td>
									<td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_membership_num%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b>WCA Number</b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_wca_number%></td>
								</tr>
								<tr>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b>Dependant No</b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_dependent_num%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='20%' align='top' valign="top"><b>Dependant Relationship</b></td>
									<td class="gridData"  style="font-size:11px;" width='20%' valign="top"><%=l_dependent_relationship_desc%></td>
									<td class="COLUMNSUBHEADER"  style="font-size:11px;" width='15%' align='top' valign="top"><b>HNET Reference Number</b></td>
									<td class="gridData"  style="font-size:11px;" width='15%' valign="top"><%=l_authorization_num%></td>
								</tr>

							<%

						}

					%>
				</table>

				<%
				if (l_event_type.equals("CLA") || l_event_type.equals("CLE"))
				{
					rs = null;

					l_trans_dtl_query = "Select A.DOC_TYPE_CODE, A.DOC_NUM, A.APPROVAL_STATUS, A.SRL_NO, b.bill_doc_type_code, b.bill_doc_num, bill_doc_line_num, serv_qty, "
								   +"		blng_serv_code, blng_serv_desc, serv_item_code, serv_item_desc, b.claim_status_desc, item_status_code, item_status_desc, " 
								   +"		TO_CHAR (serv_gross_amt, 9999990.99) serv_gross_amt, TO_CHAR (serv_disc_amt, 9999990.99) serv_disc_amt, TO_CHAR (serv_net_amt, 9999990.99) serv_net_amt, "
								   +"		TO_CHAR (appr_gross, 9999990.99) appr_gross,TO_CHAR (appr_net, 9999990.99) appr_net,TO_CHAR (appr_disc, 9999990.99) appr_disc, b.claim_status, "
								   +"		DECODE (c.process_status,'1', TO_CHAR (b.paid_to_provider, 9999990.99), '' ) paid_to_provider, e.STATUS_DESC "
								   +" FROM	xf_eclaims_trx_hdr a, xf_eclaims_trx_dtl b, xf_era_claim c, XH_TRANS_STATUS e "
								   +" WHERE A.DOC_TYPE_CODE = B.BILL_DOC_TYPE_CODE "
								   +"		AND A.DOC_NUM = B.BILL_DOC_NUM "
								   +"		AND b.srl_no = c.prov_claim_no(+) "
								   +"		AND b.bill_doc_type_code = c.bill_doc_type_code(+) "
								   +"		AND b.bill_doc_num = c.bill_doc_number(+) "
								   +"		and a.SRL_NO = b.SRL_NO "
								   +"		and c.process_status = e.STATUS_CODE(+) "
								   +"		AND e.APPLICATION_ID = 'ECLAIMS' "
								   +"		and e.TRANS_TYPE = 'CLA' "
								   +"		and e.TRANS_EVENT = 'ERA' "
								   +"		and b.BILL_DOC_TYPE_CODE = ? and b.BILL_DOC_NUM = ? and b.SRL_NO = ? and C.MK_ERA_NO = ? " 
								   +" ORDER BY b.BILL_DOC_LINE_NUM ASC";		
								   
					l_app_msg = "::: l_trans_dtl_query : "+l_trans_dtl_query;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);
				
					l_app_msg = "::: trans_num : "+trans_num;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					l_app_msg = "::: l_doc_num : "+l_doc_num;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					l_app_msg = "::: l_doc_type_code : "+l_doc_type_code;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					l_app_msg = "::: MK_ERA_NO : "+era_id;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					l_app_msg = "::: L_TRANS_DTL_QUERY : "+l_trans_dtl_query;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					pstmt = conn.prepareStatement(l_trans_dtl_query);
					pstmt.setString(1, l_doc_type_code);
					pstmt.setInt(2, Integer.parseInt(l_doc_num));
					pstmt.setInt(3, Integer.parseInt(trans_num));
					pstmt.setString(4, era_id);
					rs = pstmt.executeQuery();
                    rsmd = rs.getMetaData(); 
					columnCount = rsmd.getColumnCount();

					l_app_msg = "columnCount "+columnCount;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

                    l_app_msg = "rs "+rs;
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					if (rs!=null)
					{

						%>
							
							<table class="statusTable" width="100%" cellPadding="3" noWrap="wrap" border="1" style="border-collapse: collapse;margin-top: 10px;border-style: solid;border-color: #d5ecfb #d5ecfb;">
							<tr>
								<td class='COLUMNSUBHEADER' width='10%' style="font-size:11px;" rowspan="1"><b><fmt:message key="eBL.IRBDocLineNo.label" bundle="${bl_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='30%' style="font-size:11px;" rowspan="1"><b><fmt:message key="eBL.ServiceHeading.label" bundle="${bl_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='8%'  style="font-size:11px;" rowspan="1" align="right"><b><fmt:message key="eXH.ServiceQty.label" bundle="${xh_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='16%' style="font-size:11px;" rowspan="1"><b><fmt:message key="eXH.claimstatus.label" bundle="${xh_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='12%' style="font-size:11px;" rowspan="1" align="right"><b><fmt:message key="eBL.ServiceAmount.label" bundle="${bl_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='12%' style="font-size:11px;" rowspan="1" align="right"><b><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></b></td>
								<td class='COLUMNSUBHEADER' width='12%' style="font-size:11px;" rowspan="1" align="right"><b><fmt:message key="Common.received.label" bundle="${common_labels}"/><fmt:message key="eBL.Amount.label" bundle="${bl_labels}"/></b></td>
							</tr>							
							</table>
							<div style="width:100%; height:200px; overflow:auto;border-collapse: collapse;">
							<table class="statusTable" width="100%" cellPadding="3" noWrap="nowrap" border="1" style="border-collapse: collapse;border-style: solid;border-color: #d5ecfb #d5ecfb;">
							
						<%

						while(rs.next())
						{
							l_rej_image_str = "";
							l_bill_doc_line_num = rs.getString("BILL_DOC_LINE_NUM");
							l_serv_qty = rs.getString("SERV_QTY");
							l_blng_serv_code = rs.getString("BLNG_SERV_CODE")==null?"":rs.getString("BLNG_SERV_CODE");
							l_blng_serv_desc = rs.getString("BLNG_SERV_DESC")==null?"":rs.getString("BLNG_SERV_DESC");
							l_serv_item_code = rs.getString("SERV_ITEM_CODE")==null?"":rs.getString("SERV_ITEM_CODE");
							l_serv_item_desc = rs.getString("SERV_ITEM_DESC")==null?"":rs.getString("SERV_ITEM_DESC");
							
							l_serv_gross_amt = rs.getString("SERV_GROSS_AMT")==null?"":rs.getString("SERV_GROSS_AMT");

							l_serv_disc_amt = rs.getString("SERV_DISC_AMT")==null?"":rs.getString("SERV_DISC_AMT");
							l_serv_net_amt = rs.getString("SERV_NET_AMT")==null?"":rs.getString("SERV_NET_AMT");
							l_appr_gross = rs.getString("APPR_GROSS")==null?"":rs.getString("APPR_GROSS");
							l_appr_net = rs.getString("APPR_NET")==null?"":rs.getString("APPR_NET");
							l_appr_disc = rs.getString("APPR_DISC")==null?"":rs.getString("APPR_DISC");
							l_claim_status = rs.getString("CLAIM_STATUS")==null?"":rs.getString("CLAIM_STATUS");
							l_claim_status_desc = rs.getString("STATUS_DESC")==null?"":rs.getString("STATUS_DESC");

							l_item_status_code = rs.getString("ITEM_STATUS_CODE")==null?"":rs.getString("ITEM_STATUS_CODE");
							l_item_status_desc = rs.getString("ITEM_STATUS_DESC")==null?"":rs.getString("ITEM_STATUS_DESC");
							l_received_amt = rs.getString("PAID_TO_PROVIDER")==null?"":rs.getString("PAID_TO_PROVIDER");

							l_app_msg = "l_bill_doc_line_num "+l_bill_doc_line_num;
							if(isDebugYN.equals("Y")) System.out.println(l_app_msg);							
							%>
								<tr>
									<td class="gridData" width='10%' style="font-size:11px;" valign="top" align="center"><%=l_bill_doc_line_num%></td>
									<td class="gridData" width='30%'style="font-size:11px;" valign="top"><%=l_blng_serv_desc%></td>
									<td class="gridData" width='8%' style="font-size:11px;" valign="top" align="center"><%=l_serv_qty%></td>
									<td class="gridData" width='16%' style="font-size:11px;" valign="top"><%=l_claim_status_desc%></td>
									<td class="gridNumericData" width='12%' style="font-size:11px;" valign="top" align="right"><%=l_serv_net_amt%></td>
									<td class="gridNumericData" width='12%' style="font-size:11px;" valign="top" align="right"><%=l_appr_net%></td>
									<td class="gridNumericData" width='12%' style="font-size:11px;" valign="top" align="right"><%=l_received_amt%></td>	
								</tr>
							
							<%
							l_app_msg = "l_claim_status "+l_claim_status;
							if(isDebugYN.equals("Y")) System.out.println(l_app_msg);
                            
							
						    arrColumns.clear();
							arrRow.clear();
									
						}
						%>
							</table>
							</div>
						<%
					}
				}		
			}
			catch(Exception e1)
			{
				 out.println("(MediERAOueryResponsePopUp.jsp:Exception) "+e1);
				 e1.printStackTrace(System.err);
			}
			finally
			{
				pstmt = null;
				rs = null;
				ConnectionManager.returnConnection(conn);
			}

		%>
		</form>
	</body>
</html>

