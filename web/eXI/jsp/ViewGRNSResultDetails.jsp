<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@page
	import="java.util.*,eXI.*,webbeans.eCommon.*,eCommon.Common.*,java.sql.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<style>																	   
	div {float: left}												 						   
	.testSty					 															   
	{
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}																  
</style>		   
		<%
					String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
					|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
					.getAttribute("PREFERRED_STYLE")
					: "IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css'></link>
		<link rel='stylesheet' href='../../eXH/html/ViewEvents.css'
			type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript'
			src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eXI/js/ViewGRNS.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		int i = 0;
		String strDocType = "", strDocNo = "";
		String strFacilityId = "", strDocSrlNo = "";
		String strGRNDate = "", strTitle = "";
		String strStoreCode = "", strItemCode = "";
		String strBatchId = "", strExpDate = "";
		String strTradeId = "", strStatus = "";
		String strErrRec = "", strErrText = "";
		ArrayList arrCol = new ArrayList();
		ArrayList resArray = new ArrayList();
	//	ArrayList resArray = null;
		strDocType = checkForNull(request.getParameter("doctype"));
		strDocNo = checkForNull(request.getParameter("docno"));
		strStatus = checkForNull(request.getParameter("trn_status"));
	   	strTitle = "Details for the GRN : " + strDocType + "/" + strDocNo;
	%>
	<title><%=strTitle%>
	</title>
	<body>
		<form>
			<table id="indicatorTable" cellspacing=0 cellpadding=3 width='100%'
				align=center>  
				<tr>
				</tr>
			</table>
			<div id="left_child" style="display:block; width: 36%; ">
				<table id="table1" cellspacing=0 cellpadding=3 border=1>
					<tr>
						<td class='COLUMNHEADER'>
							<fmt:message key="eXI.DocSrlNo.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="eXI.GrnDate.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.StoreCode.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.ItemCode.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.Batch.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.expiryDate.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.TradeID.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER'>
							<fmt:message key="Common.Error.label" bundle="${common_labels}" />
						</td>
					</tr>
					<%
						Connection con = null;
						PreparedStatement pstmt = null;
						ResultSet rs = null;	 
						StringBuffer sbQuery = new StringBuffer();
						strFacilityId = (String) session.getValue("facility_id");  
						ArrayList array;
						try {
							con = ConnectionManager.getConnection(request);
							sbQuery
							.append("SELECT   a.doc_srl_no, TO_CHAR (a.grn_date, 'DD/MM/YYYY'), a.store_code, a.item_code, a.batch_id, "
									+ "TO_CHAR (a.expiry_date, 'DD/MM/YYYY'), a.trade_id, b.status_type, b.process_text,	a.doc_type_code, a.doc_no, a.doc_date, a.doc_ref,a.item_class_code, a.supp_code, a.item_qty, a.item_cost_value, a.grn_unit_cost_in_pur_uom, a.grn_unit_cost_in_stk_uom, a.grn_item_qty, a.pur_uom_code, a.rtv_item_qty, a.pur_uom_conv, a.po_cost, a.po_discount, a.po_tax, a.tot_invoice_qty,a.xi_brand_name, a.xi_packing_size, a.xi_packing_kind, a.xi_batch_id, a.type_of_issue, a.customer_num, a.site_num, a.request_num, a.request_line_num, a.xi_organization_id,  a.inventory_item_id, a.uom_code, a.lot_no,  a.sale_price, a.xi_remarks, a.hdr_remarks, a.processed_by_id, TO_CHAR (a.processed_date, 'DD/MM/YYYY'), a.iba_doc_type_code, a.iba_doc_num, a.iba_doc_line_num, a.trans_status,a.replace_on_expiry_yn, a.supp_name,a.bin_location_code "
									+ "FROM xi_trn_grn a, st_process_status b "
									+ "WHERE a.facility_id = ? "
									+ "AND a.doc_type_code = ? "
									+ "AND a.doc_no = ? "
									+ "AND a.store_code = b.store_code(+) "
									+ "AND a.item_code = b.item_code(+) "
									+ "AND a.batch_id = b.batch_id(+) "
									+ "AND TO_CHAR (a.expiry_date, 'dd/mm/yyyy') = TO_CHAR (b.expiry_date(+), 'dd/mm/yyyy') "
									+ "AND a.facility_id = b.facility_id(+) "
									+ "AND a.doc_type_code = b.doc_type_code(+) "
									+ "AND a.doc_no = b.doc_no(+) "
									+ "AND a.doc_srl_no = b.doc_srl_no(+) "
									+ "ORDER BY a.doc_srl_no,a.batch_id,a.item_code");	 
							pstmt = con.prepareStatement(sbQuery.toString());			 
							pstmt.setString(1, strFacilityId);
							pstmt.setString(2, strDocType);
							pstmt.setString(3, strDocNo);
							rs = pstmt.executeQuery();									 
							if (rs != null) {
								while (rs.next()) {
								
							strDocSrlNo = checkForNull(rs.getString(1), "&nbsp");
							strGRNDate = checkForNull(rs.getString(2), "&nbsp");
							strStoreCode = checkForNull(rs.getString(3), "&nbsp");
							strItemCode = checkForNull(rs.getString(4), "&nbsp");
							strBatchId = checkForNull(rs.getString(5), "&nbsp");
							strExpDate = checkForNull(rs.getString(6), "&nbsp");
							strTradeId = checkForNull(rs.getString(7), "&nbsp");
							strErrRec = checkForNull(rs.getString(8), "&nbsp");
							strErrText = checkForNull(rs.getString(9), "&nbsp");
							array = new ArrayList();
							array.add(0, checkForNull(rs.getString(10)));
							array.add(1, checkForNull(rs.getString(11)));
							array.add(2, checkForNull(rs.getString(12)));
							array.add(3, checkForNull(rs.getString(13)));
							array.add(4, checkForNull(rs.getString(14)));
							array.add(5, checkForNull(rs.getString(15)));
							array.add(6, checkForNull(rs.getString(16)));
							array.add(7, checkForNull(rs.getString(17)));
							array.add(8, checkForNull(rs.getString(18)));
							array.add(9, checkForNull(rs.getString(19)));
							array.add(10, checkForNull(rs.getString(20)));
							array.add(11, checkForNull(rs.getString(21)));
							array.add(12, checkForNull(rs.getString(22)));
							array.add(13, checkForNull(rs.getString(23)));
							array.add(14, checkForNull(rs.getString(24)));
							array.add(15, checkForNull(rs.getString(25)));
							array.add(16, checkForNull(rs.getString(26)));
							array.add(17, checkForNull(rs.getString(27)));
							array.add(18, checkForNull(rs.getString(28)));
							array.add(19, checkForNull(rs.getString(29)));
							array.add(20, checkForNull(rs.getString(30)));
							array.add(21, checkForNull(rs.getString(31)));
							array.add(22, checkForNull(rs.getString(32)));
							array.add(23, checkForNull(rs.getString(33)));
							array.add(24, checkForNull(rs.getString(34)));
							array.add(25, checkForNull(rs.getString(35)));
							array.add(26, checkForNull(rs.getString(36)));
							array.add(27, checkForNull(rs.getString(37)));
							array.add(28, checkForNull(rs.getString(38)));
							array.add(29, checkForNull(rs.getString(39)));
							array.add(30, checkForNull(rs.getString(40)));
							array.add(31, checkForNull(rs.getString(41)));
							array.add(32, checkForNull(rs.getString(42)));
							array.add(33, checkForNull(rs.getString(43)));
							array.add(34, checkForNull(rs.getString(44)));
							array.add(35, checkForNull(rs.getString(45)));
							array.add(36, checkForNull(rs.getString(46)));
							array.add(37, checkForNull(rs.getString(47)));
							array.add(38, checkForNull(rs.getString(48)));
							array.add(39, checkForNull(rs.getString(49)));
							array.add(40, checkForNull(rs.getString(50)));
							array.add(41, checkForNull(rs.getString(51)));
							array.add(42, checkForNull(rs.getString(52)));
							arrCol.add(i, array);
							 
							
							i++;
							if (!strErrText.equalsIgnoreCase("&nbsp"))
								strErrText = strErrText.replace('"', ' ');

							if (!strErrText.equals("") && strErrText.length() > 10)
								strErrRec = strErrText.substring(0, 10) + ".....";
							else
								strErrRec = "&nbsp";
					%>
					<tr class='label'>
						<td nowrap class='label' align='center'>
							<a href='#'
								OnClick="showSingleDetails('<%=strFacilityId%>','<%=strDocType%>','<%=strDocNo%>','<%=strItemCode%>')"><%=strDocSrlNo%>
							</a>
						</td>
						<td nowrap class='label' align='center'>
							<%=strGRNDate%>
						</td>
						<td nowrap class='label' align='center'>
							<%=strStoreCode%>
						</td>
						<td nowrap class='label' align='center'>
							<%=strItemCode%>
						</td>
						<td nowrap class='label' align='center'>
							<%=strBatchId%>
						</td>
						<td nowrap class='label' align='center'>
							<%=strExpDate%>
						</td>
						<td nowrap class='label' align='center'>
							<%=strTradeId%>
						</td>
						<%
										if (strErrRec != null && strErrRec.length() > 0
										&& !strErrRec.equalsIgnoreCase("&nbsp")) {
						%>
						<td nowrap class='label' align='center'>
							<a href='#'
								OnClick="showErrDetails('<%=strDocType%>','<%=strDocNo%>','<%=strErrText%>')"><%=strErrRec%>
							</a>
						</td>
						<%
						} else {
						%>
						<td nowrap class='label' align='center'>
							&nbsp
						</td>
						<%
						}
						%>
					</tr>
					<%
					}
					%>
				</table>
			</div>
			<div id="right_child" class="testSty"
				style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:block; width: 64%; ">
				<table id="table2" cellspacing=0 cellpadding=3 border=1>
					<tr>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.DocType.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.documentno.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.DocumentDate.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.DocRef.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.ItemClassCode.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.SupplierCode.label"
								bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.ItemQty.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.item.label" bundle="${common_labels}" />
							<fmt:message key="Common.Cost.label" bundle="${common_labels}" />
							<fmt:message key="Common.Value.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.grn_unit_cost_in_pur_uom.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.grn_unit_cost_in_stk_uom.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.grn_item_qty.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.pur_uom_code.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.rtv_item_qty.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.pur_uom_conv.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.po_cost.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.po_discount.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.po_tax.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.tot_invoice_qty.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_brand_name.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_packing_size.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_packing_kind.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_batch_id.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.type_of_issue.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.customer_num.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.site_num.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.request_num.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.request_line_num.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_organization_id.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.inventory_item_id.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.UOMCode.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.lot_no.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.sale_price.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.xi_remarks.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.hdr_remarks.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.processed_by_id.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="Common.Process.label" bundle="${common_labels}" />
							<fmt:message key="Common.date.label" bundle="${common_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.iba_doc_type_code.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.iba_doc_num.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.iba_doc_line_num.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.trans_status.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.replace_on_expiry_yn.Label"
								bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.supp_name.Label" bundle="${xi_labels}" />
						</td>
						<td class='COLUMNHEADER' nowrap>
							<fmt:message key="eXI.bin_location_code.Label"
								bundle="${xi_labels}" />
						</td>
					</tr>
					<tr>
						<%
									//	rs.last();  
									try {

									} catch (Exception e) {
								System.out.println("error is ViewGRNSResultDetails.jsp"
										+ e.toString());
									}

									if (arrCol.size() != 0) {
								for (int j = 0; j < arrCol.size(); j++) {

									resArray = (ArrayList) arrCol.get(j);
						%>
					
					<tr>
						<td nowrap class='label' align='center'>
							&nbsp;
							<%=resArray.get(0)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp;
							<%=resArray.get(1)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp;
							<%=resArray.get(2)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(3)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(4)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(5)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(6)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(7)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(8)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(9)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(10)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(11)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(12)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(13)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(14)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(15)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(16)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(17)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(18)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(19)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(20)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(21)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(22)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(23)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(24)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(25)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(26)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(27)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(28)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(29)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(30)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(31)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(32)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(33)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(34)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(35)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(36)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(37)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(38)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(39)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(40)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(41)%>
						</td>
						<td nowrap class='label' align='center'>
							&nbsp
							<%=resArray.get(42)%>
						</td>
					</tr>
					<%
								}
								}
					%>

					</tr>
				</table>
			</div>		  
			<%
					if (rs != null)
					rs.close();
						if (pstmt != null)
					pstmt.close();
					}
				} catch (Exception e1) {
					e1.printStackTrace(System.err);
					System.out.println(" Error in Result Detail Page "
					+ e1.getMessage());
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();

					if (con != null)
						ConnectionManager.returnConnection(con, request);
				}
			%>
		</form>
	</body>
</html>
<%!private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue) {
		return (inputString == null) ? defaultValue : inputString;
	}%>																		    

