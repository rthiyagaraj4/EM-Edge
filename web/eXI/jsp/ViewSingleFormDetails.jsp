<!DOCTYPE html>
<%@page
	import="java.util.*, eST.*, eST.Common.* ,webbeans.eCommon.*, eCommon.Common.*,java.sql.*,java.util.*, eXH.*, eXI.* ,webbeans.eCommon.*, eCommon.Common.*,java.sql.*,eXI.*,eXI.XIDBAdapter.*"%>
<html>
	<head>
		<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
		<%@ page contentType="text/html;charset=UTF-8" %>
		<%request.setCharacterEncoding("UTF-8"); %>
		<script Language="JavaScript"
			src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String title_name = request.getParameter("title_name");
  if(title_name==null || title_name=="" || title_name.equals(""))
  title_name = "";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
			type='text/css' />

		<script>
							    
</script>
		<title><%=title_name%></title>
		<%
	String facility = request.getParameter("facility");
    String docno = request.getParameter("docno");
    String doctext = request.getParameter("doctext");  
	String item_code = request.getParameter("item_code");

	Connection con			=	null;										 
	PreparedStatement pstmt	=	null;									     
	ResultSet		rs		=	null;
	StringBuffer	sbQuery		=		new StringBuffer();	
	try
	{
		con	= ConnectionManager.getConnection(request); 			    
		sbQuery.append("SELECT   a.doc_srl_no, TO_CHAR (a.grn_date, 'DD/MM/YYYY'), a.store_code, a.item_code, a.batch_id, "+
								 "TO_CHAR (a.expiry_date, 'DD/MM/YYYY'), a.trade_id, b.status_type, b.process_text,	a.application_id, a.event_type, a.trx_no,a.facility_id, a.doc_type_code, a.doc_no, TO_CHAR (a.doc_date,'DD/MM/YYYY'), a.doc_ref,  a.item_class_code, a.supp_code, a.item_qty, a.item_cost_value, a.grn_unit_cost_in_pur_uom, a.grn_unit_cost_in_stk_uom, a.grn_item_qty, a.pur_uom_code, a.rtv_item_qty, a.pur_uom_conv, a.po_cost, a.po_discount, a.po_tax, a.tot_invoice_qty, a.xi_brand_name, a.xi_packing_size, a.xi_packing_kind, a.xi_batch_id, a.type_of_issue, a.customer_num, a.site_num, a.request_num, a.request_line_num, a.xi_organization_id,  a.inventory_item_id, a.uom_code, a.lot_no,  a.sale_price, a.xi_remarks, a.hdr_remarks, a.processed_by_id, a.processed_date, a.iba_doc_type_code, a.iba_doc_num, a.iba_doc_line_num, a.trans_status,a.replace_on_expiry_yn, a.supp_name, a.bin_location_code,	 a.added_by_id, TO_CHAR (a.added_date,'DD/MM/YYYY'), a.added_at_ws_no,  a.modified_by_id, TO_CHAR (a.modified_date,'DD/MM/YYYY'), a.modified_at_ws_no,    a.load_status, a.comm_status,a.err_msg "+		  
							"FROM xi_trn_grn a, st_process_status b "+
						   "WHERE a.facility_id = ? "+									   
							 "AND a.doc_type_code = ? "+
							 "AND a.doc_no = ? "+
							 "AND a.store_code = b.store_code(+) "+					  					  
							 "AND a.item_code = b.item_code(+) "+
							 "AND a.batch_id = b.batch_id(+) "+
							 "AND TO_CHAR (a.expiry_date, 'dd/mm/yyyy') = TO_CHAR (b.expiry_date(+), 'dd/mm/yyyy') "+
							 "AND a.facility_id = b.facility_id(+) "+
							 "AND a.doc_type_code = b.doc_type_code(+) "+
							 "AND a.doc_no = b.doc_no(+) "+
							 "AND a.doc_srl_no = b.doc_srl_no(+) and a.item_code=nvl('"+item_code+"',a.item_code) "+
						"ORDER BY a.doc_srl_no");
																												  
		pstmt	=	con.prepareStatement(sbQuery.toString());				    		 

		pstmt.setString(1,facility);

		pstmt.setString(2,docno);

		pstmt.setString(3,doctext);

		rs	=	pstmt.executeQuery();
		
		if( rs != null)
		{
			while ( rs.next() )
			{
%>

	</head>
	<body style='background-color:#E2E3F0;' onMouseDown="CodeArrest()"
		onKeyDown="lockKey()">
		<table width='100%' border='0' cellspacing='0' cellpadding='0'
			align=center>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.DocSrlNo.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(1))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_packing_size.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(33))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.GrnDate.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(2))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_packing_kind.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(34))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.StoreCode.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(3))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_batch_id.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(35))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.ItemCode.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(4))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.type_of_issue.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(36))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.Batch.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(5))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.customer_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(37))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.expiryDate.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(6))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.site_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(38))%> </B>
				</td>
			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.TradeID.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(7))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.request_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(39))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.Error.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(8))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.request_line_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(40))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.status.label" bundle="${common_labels}" />
					<fmt:message key="Common.type.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(9))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_organization_id.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(41))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.Application.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(10))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.inventory_item_id.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(42))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.Event.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(11))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.UOMCode.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(43))%> </B>
				</td>
			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.trx_no.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(12))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.lot_no.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(44))%> </B>
				</td
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.facility.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(13))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.sale_price.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(45))%> </B>
				</td>


			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.DocType.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(14))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_remarks.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(46))%> </B>
				</td>
			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.documentno.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(15))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.hdr_remarks.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(47))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.DocumentDate.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(16))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.processed_by_id.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(48))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.DocRef.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(17))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.Process.label" bundle="${common_labels}" />
					<fmt:message key="Common.date.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(49))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.ItemClassCode.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(18))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.iba_doc_type_code.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(50))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.SupplierCode.label"
						bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(19))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.iba_doc_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(51))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.ItemQty.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(20))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.iba_doc_line_num.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(52))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="Common.item.label" bundle="${common_labels}" />
					<fmt:message key="Common.Cost.label" bundle="${common_labels}" />
					<fmt:message key="Common.Value.label" bundle="${common_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(21))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.trans_status.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(53))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.grn_unit_cost_in_pur_uom.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(22))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.replace_on_expiry_yn.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(54))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.grn_unit_cost_in_stk_uom.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(23))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.supp_name.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(55))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.grn_item_qty.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(24))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.bin_location_code.Label"
						bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(56))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.pur_uom_code.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(25))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(57))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.rtv_item_qty.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(26))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.AddedID.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(58))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.pur_uom_conv.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(27))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.AddedDate.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(59))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.po_cost.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(28))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.AddedWSNo.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(60))%> </B>
				</td>


			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.po_discount.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(29))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.ModifiedID.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(61))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.po_tax.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(30))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.ModifiedDate.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(62))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.tot_invoice_qty.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(31))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXH.ModifiedWSNo.Label" bundle="${xh_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(63))%> </B>
				</td>

			</tr>

			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.xi_brand_name.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(32))%> </B>
				</td>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.CommStatus.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(64))%> </B>
				</td>

			</tr>
			<tr>
				<td align='left' class='label' width='10%'>
					<fmt:message key="eXI.Loadstatus.Label" bundle="${xi_labels}" />
				</td>
				<td align='left' class='label' width='10%'>
					<B><%=XIDBAdapter.checkNull(rs.getString(65))%> </B>
				</td>

			</tr>




			<%}
		}
		 if (rs != null) rs.close();
			if( pstmt != null) pstmt.close();
		
	}
	catch (Exception e1)
	{
		e1.printStackTrace(System.err);
		System.out.println( " Error in Result Detail Page " + e1.getMessage());
	}
	finally
	{
		if (rs != null) rs.close();
		if( pstmt != null) pstmt.close();

		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
		
		%>



			<tr>
				<td>
				</td>
				<td colspan="20">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type='Button' class='Button' name='Ok' id='Ok' value='Close'
						onclick='doClose()'>
				</td>
			</tr>
		</table>

	</body>

	<script>
function doClose()												   			 
{
	//parent.window.close();
    const dialogTag = parent.parent.document.getElementById('dialog_tag');    
    dialogTag.close();   
}
</script>
</html>

