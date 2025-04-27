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
	
	<title>
		EClaims Transaction History Window
	</title>
	</head>
	<body>
		<form>
		<%

			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs=null;
			ResultSet rs_status=null;

			String l_status_trx_query = "";

			String l_event_type = "", l_trans_status = "", l_trans_number = "",l_trans_date = "", l_transaction_desc = "", l_approval_status_desc = "";

			String trans_num = XHDBAdapter.checkNull(request.getParameter("trans_num")); 

            ResultSetMetaData rsmd =null;
			int columnCount =0;

			String l_rej_image_str = "";

            ArrayList arrRow = new ArrayList();
            ArrayList arrColumns = new ArrayList();
			String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

			String hideTable = "style='display:none;'";

			String patient_id = XHDBAdapter.checkNull(request.getParameter("Patient_id"));
			String episode_id = XHDBAdapter.checkNull(request.getParameter("Episode_id"));    
			String visit_id = XHDBAdapter.checkNull(request.getParameter("Visit_id")); 
			String doc_num = XHDBAdapter.checkNull(request.getParameter("doc_num"));    
			String bill_doc_code = XHDBAdapter.checkNull(request.getParameter("bill_doc_code"));
			String trans_type = XHDBAdapter.checkNull(request.getParameter("trans_type"));
			String trans_event = "ELC";

			String l_app_msg = "";

			l_app_msg = "::: patient_id : "+patient_id+" ::: episode_id : "+episode_id+" ::: visit_id : "+visit_id+" ::: doc_num : "+doc_num+" ::: bill_doc_code : "+bill_doc_code;
			if(isDebugYN.equals("Y")) System.out.println(l_app_msg);


			try
			{ 	
				
				conn = ConnectionManager.getConnection(request);

				l_status_trx_query = "Select  PATIENT_ID, SRL_NO, a.EVENT_TYPE , a.APPROVAL_STATUS, TO_CHAR (MODIFIED_DATE, 'DD/MM/YYYY hh24:mi:ss') MODIFIED_DATE, b.STATUS_DESC  "
										+" from XF_ECLAIMS_TRX_HDR a,  XH_TRANS_STATUS b "
										+" where a.TRANS_TYPE = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
										+" AND  A.APPROVAL_STATUS = B.STATUS_CODE(+) AND B.TRANS_EVENT = ? AND B.TRANS_TYPE = A.EVENT_TYPE ";
				
				if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

				if(trans_type.equals("ECLREQ"))
				{
					l_status_trx_query =l_status_trx_query+" and DOC_TYPE_CODE = ? and  DOC_NUM = ?";
					trans_event = "ECL";
				}
				l_status_trx_query = l_status_trx_query+" order by SRL_NO desc";

				pstmt = conn.prepareStatement(l_status_trx_query);
                
				pstmt.setString(1, trans_type);
				pstmt.setString(2, patient_id);
				pstmt.setInt(3, Integer.parseInt(episode_id));
				pstmt.setInt(4, Integer.parseInt(visit_id));
				pstmt.setString(5, trans_event);

				if(trans_type.equals("ECLREQ"))
				{
					pstmt.setString(6, bill_doc_code);
					pstmt.setInt(7, Integer.parseInt(doc_num));
				}


				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					l_app_msg = "::: Inside RS Next : ";
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					l_event_type = rs.getString("EVENT_TYPE")==null?"":rs.getString("EVENT_TYPE");
					l_trans_status = rs.getString("APPROVAL_STATUS")==null?"":rs.getString("APPROVAL_STATUS");
					l_trans_number = rs.getString("SRL_NO")==null?"":rs.getString("SRL_NO");
					l_trans_date = rs.getString("MODIFIED_DATE")==null?"":rs.getString("MODIFIED_DATE");
					l_approval_status_desc =  rs.getString("STATUS_DESC")==null?"":rs.getString("STATUS_DESC");
					
					arrColumns.add(l_event_type);
					arrColumns.add(l_trans_status);
					arrColumns.add(l_trans_number);
					arrColumns.add(l_trans_date);
					arrColumns.add(l_approval_status_desc);

					arrRow.add(arrColumns);
					arrColumns = new ArrayList();
					arrColumns.clear();
				}
				
					%>
						<table cellspacing=0 cellpadding=3 width='100%' align=center border=1 style="border-collapse: collapse;margin-top: 10px;">
							<tr>
								<td colspan="15" class="COLUMNSUBHEADER" align='center' style="font-size:11px;"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> : <%=patient_id %> </td>
								<td colspan="10" class="COLUMNSUBHEADER" align='center' style="font-size:11px;"><fmt:message key="Common.episodeid.label" bundle="${common_labels}"/> :<%=episode_id %> </td>
								<td colspan="10" class="COLUMNSUBHEADER" align='center' style="font-size:11px;"><fmt:message key="eBL.BILL_DOC_NO.label" bundle="${bl_labels}"/> :<%=doc_num %></td>
								<td colspan="10" class="COLUMNSUBHEADER" align='center' style="font-size:11px;"><fmt:message key="eBL.BILL_DOC_TYPE.label" bundle="${bl_labels}"/> : <%=bill_doc_code %></td>
							</tr>	
						</table>
				<%
					if(arrRow.size()!=0)
					{     
				%>
						<table class="statusTable" width="100%" cellPadding="3" align="center" noWrap="nowrap" border="1" style="border-collapse: collapse;margin-top: 10px;border-style: solid;border-color: #d5ecfb #d5ecfb;">
						<tr>
							<td class='COLUMNSUBHEADER' width='10%' style="font-size:11px;"><b><fmt:message key="Common.Transaction.label" bundle="${common_labels}"/> </b></td>
							<td class='COLUMNSUBHEADER' width='30%' style="font-size:11px;"><b><fmt:message key="Common.EventType.label" bundle="${common_labels}"/> </b></td>
							<td class='COLUMNSUBHEADER' width='30%' style="font-size:11px;"><b><fmt:message key="Common.status.label" bundle="${common_labels}"/></b></td>
							<td class='COLUMNSUBHEADER' width='20%' style="font-size:11px;"><b><fmt:message key="Common.TransactionDate.label" bundle="${common_labels}"/></b></b></td>
						</tr>
					<%
					l_app_msg = "::: Inside If : ";
					if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

					for (int j=0; j<arrRow.size();j++)
					 {
							l_transaction_desc = "";
							l_approval_status_desc = "";

							arrColumns = (ArrayList)arrRow.get(j);

							l_app_msg = "::: Inside While RS Next : ";
							if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

							l_event_type = arrColumns.get(0).toString();
							l_trans_status = arrColumns.get(1).toString();
							l_trans_number = arrColumns.get(2).toString();
							l_trans_date = arrColumns.get(3).toString();

							l_app_msg = "::: l_event_type : "+l_event_type+" ::: l_trans_status : "+l_trans_status+" ::: l_trans_number : "+l_trans_number+" ::: l_trans_date : "+l_trans_date;

							if(isDebugYN.equals("Y")) System.out.println(l_app_msg);

							if (l_event_type.equals("CLA") )
								l_transaction_desc = "Claims";
							if (l_event_type.equals("CLE"))
								l_transaction_desc = "Claims End of case";
							if (l_event_type.equals("REV"))
								l_transaction_desc = "Reversal";
							if (l_event_type.equals("EOC"))
								l_transaction_desc = "End Of Case";
							if (l_event_type.equals("IDC"))
								l_transaction_desc = "ID Check";
							if (l_event_type.equals("UEC"))
								l_transaction_desc = "Uninsured Eligibility Check";
							if (l_event_type.equals("FAM"))
								l_transaction_desc = "FAM Check";
							if (l_event_type.equals("IEC"))
								l_transaction_desc = "Insured Eligibility Check";

							l_approval_status_desc =  arrColumns.get(4).toString();

							/*

							if (l_trans_status.equals("P"))
								l_approval_status_desc = "Processed";
							if (l_trans_status.equals("R"))
								l_approval_status_desc = "Rejected";
							if (l_trans_status.equals("W"))
								l_approval_status_desc = "Processed with Warning";		
							if (l_trans_status.equals("D"))
								l_approval_status_desc = "Duplicate";
							if(l_event_type.equals("REV")||l_event_type.equals("EOC"))
									{
										if(l_trans_status.equals("P")|| l_trans_status.equals("A")){
											l_approval_status_desc = "Authorised";
										}
									}
							if (l_trans_status.equals("99"))
								l_approval_status_desc = "Network Error";

								*/
						
						
						%>
							<tr>
								<td class="gridData" width='10%' style="font-size:12px;" valign="top"><%=l_trans_number%></td>
								<td class="gridData" width='20%' style="font-size:12px;" valign="top"><%=l_transaction_desc%></td>
								<td class="gridData" width='20%' style="font-size:12px;" valign="top"><%=l_approval_status_desc%></td>
							    <td class="gridData" width='15%' style="font-size:12px;" valign="top"><%=l_trans_date%></td>
							</tr>
						
						<%
						
					}
				  %> </table><%
				}
				  else{
					 %> <table cellspacing=0 cellpadding=3 width='100%' height= "100px" align=center border=1 style="border-collapse: collapse;margin-top: 10px;"><tr><td class="gridData" width='10%' style="font-size:15px;" valign="Center" rowspan = "4" align = "Center">No Transaction has been made for this Bill. </td></tr></table><%
				  }

					 
							
			
			}
			catch(Exception e1)
			{
				 out.println("(MediClaimsTransDetailsPopUp.jsp:Exception) "+e1);
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

