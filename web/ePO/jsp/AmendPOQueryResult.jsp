<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,ePO.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		
		<%

			request.setCharacterEncoding("UTF-8");
			String locale			=		(String)session.getAttribute("LOCALE");
		
			String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../ePO/js/PoCommon.js'></script>
		<script language="javascript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<%
		String po_mode			=		request.getParameter("po_mode");
		String purchase_type	=		request.getParameter("purchase_type");
		String po_no			=		request.getParameter("po_no");
	//	String po_date			=		com.ehis.util.DateUtils.convertDate(request.getParameter("po_date"),"DMY",locale,"en");
		String purchase_unit	=		request.getParameter("purchase_unit");
		String supp_code		=		request.getParameter("supp_code");
		String from_po_date     =		request.getParameter("from_po_date");
		String to_po_date       =   	request.getParameter("to_po_date");
		

		boolean searched		=		(request.getParameter("searched") == null) ?false:true;
		String classvalue		=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			po_mode				=		CommonBean.checkForNull(po_mode,"%");
			purchase_type		=		CommonBean.checkForNull(purchase_type,"%");
			po_no				=		CommonBean.checkForNull(po_no,"%");
		//	po_date				=		CommonBean.checkForNull(po_date,"%");
			purchase_unit		=		CommonBean.checkForNull(purchase_unit,"%");
			supp_code			=		CommonBean.checkForNull(supp_code,"%");
			from_po_date        =  CommonBean.checkForNull(from_po_date,"");
			to_po_date          =  CommonBean.checkForNull(to_po_date,"");	
			
			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
			//sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_REQUEST_HDR_SELECT"));
			
		//	sqlMap.put("sqlData", "SELECT hdr.PO_MASTER_CODE, mc.short_desc purchase_type_desc,hdr.PO_NO,TO_CHAR (hdr.po_date, 'dd/mm/yyyy') doc_date,hdr.PUR_UNIT_CODE,pu.short_desc purchae_unit_desc,hdr.SUPP_CODE, aps.short_name supplier_desc FROM PO_ORDER_HDR hdr , PO_MASTER_CODE mc,PO_PURCHASE_UNIT pu,ap_supplier aps,PO_USER_FOR_PUNIT uapu WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND hdr.PUR_UNIT_CODE = pu.PUR_UNIT_CODE AND ( hdr.PO_STATUS = 'FA' OR hdr.PO_STATUS = 'RA') AND aps.SUPP_CODE = hdr.SUPP_CODE AND uapu.PO_ALLOWED_YN = 'Y' AND uapu.PUR_UNIT_CODE = hdr.PUR_UNIT_CODE AND uapu.user_id = ?  AND hdr.PUR_UNIT_CODE LIKE ? AND hdr.SUPP_CODE LIKE ? AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.PO_NO) LIKE ?  AND TO_CHAR (hdr.po_date, 'dd/mm/yyyy') LIKE ? ");
		
		//sqlMap.put("sqlData", "SELECT hdr.PO_MASTER_CODE, mc.short_desc purchase_type_desc,hdr.PO_NO,TO_CHAR (hdr.po_date, 'dd/mm/yyyy') po_date,hdr.PUR_UNIT_CODE,pu.short_desc purchae_unit_desc,hdr.SUPP_CODE, aps.short_name supplier_desc,hdr.PO_ORDER_MODE FROM PO_ORDER_HDR hdr , PO_MASTER_CODE mc,PO_PURCHASE_UNIT pu,ap_supplier aps,PO_USER_FOR_PUNIT uapu WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND hdr.PUR_UNIT_CODE = pu.PUR_UNIT_CODE AND ( hdr.PO_STATUS = 'FA' OR hdr.PO_STATUS = 'RA' OR hdr.PO_STATUS = 'AM') AND aps.SUPP_CODE = hdr.SUPP_CODE AND uapu.PO_ALLOWED_YN = 'Y' AND uapu.PUR_UNIT_CODE = hdr.PUR_UNIT_CODE AND uapu.user_id = ?  AND hdr.PUR_UNIT_CODE LIKE ? AND hdr.SUPP_CODE LIKE ? AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.PO_NO) LIKE ?  AND hdr.po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND hdr.PO_ORDER_MODE LIKE ? AND PO_AMEND_ALLOWED_YN = 'Y' AND mc.MASTER_TYPE = ?  ");
	
		
		//sqlMap.put("sqlData", "SELECT hdr.PO_MASTER_CODE, mc.short_desc purchase_type_desc,hdr.PO_NO,TO_CHAR (hdr.po_date, 'dd/mm/yyyy') po_date,hdr.PUR_UNIT_CODE,pu.short_desc purchae_unit_desc,hdr.SUPP_CODE, aps.short_name supplier_desc,hdr.PO_ORDER_MODE FROM PO_ORDER_HDR hdr , PO_MASTER_CODE mc,PO_PURCHASE_UNIT pu,ap_supplier aps,PO_USER_FOR_PUNIT uapu WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND hdr.PUR_UNIT_CODE = pu.PUR_UNIT_CODE AND ( hdr.PO_STATUS = 'FA' OR hdr.PO_STATUS = 'RA' ) AND aps.SUPP_CODE = hdr.SUPP_CODE AND uapu.PO_ALLOWED_YN = 'Y' AND uapu.PUR_UNIT_CODE = hdr.PUR_UNIT_CODE AND uapu.user_id = ?  AND hdr.PUR_UNIT_CODE LIKE ? AND hdr.SUPP_CODE LIKE ? AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.PO_NO) LIKE ?  AND hdr.po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND hdr.PO_ORDER_MODE LIKE ? AND PO_AMEND_ALLOWED_YN = 'Y' AND mc.MASTER_TYPE = ?  ");
		
		sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_AMEND_PO_QUERY"));
	
	
			
			displayFields.add("purchase_type_desc");
			displayFields.add("PO_NO");
			displayFields.add("PO_DATE");
			displayFields.add("purchae_unit_desc");
			displayFields.add("supplier_desc");
			displayFields.add("PO_MASTER_CODE");
			displayFields.add("PUR_UNIT_CODE");
			displayFields.add("SUPP_CODE");
			displayFields.add("PO_ORDER_MODE");
			
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(purchase_unit);
			chkFields.add(supp_code);
			chkFields.add(purchase_type);
			chkFields.add(po_no);
			chkFields.add(from_po_date);
			chkFields.add(to_po_date);
			chkFields.add(po_mode);
			chkFields.add("PORDER");						
						

			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
		
			System.out.println("chkFields in query result = "+chkFields);
			System.out.println("displayFields in query result = "+displayFields);
			System.out.println("sqlMap in query result = "+sqlMap);
		
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("result in query result = "+result);
			
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<tr>
					<th width='260'><fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.PONo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}"/></th>
					<th width='260'><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/></th>
				 
				</tr>		
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%
		
//				String link_columns = "1";
				records=(ArrayList) result.get(recCount);
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class='NODISPLAY'><%=records.get(5)%></td>
				<td class='NODISPLAY'><%=records.get(6)%></td>
				
			</tr>
		<%
			}
		%>
		</table>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/AmendPOQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

