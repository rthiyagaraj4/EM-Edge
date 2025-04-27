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
		<script language="javascript" src="../../ePO/js/Tender.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<%
		
		String tender_type	=		request.getParameter("tender_type");
		String tender_no			=		request.getParameter("tender_no");
		String from_do_date     =		request.getParameter("from_do_date");
		String to_do_date       =   	request.getParameter("to_do_date");
		String purchase_unit	=		request.getParameter("purchase_unit");
		boolean searched		=		(request.getParameter("searched") == null) ?false:true;
		String classvalue		=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			tender_type			=		CommonBean.checkForNull(tender_type,"%");
			tender_no			=		CommonBean.checkForNull(tender_no,"%");
			from_do_date        =       CommonBean.checkForNull(from_do_date,"");
			to_do_date          =  		CommonBean.checkForNull(to_do_date,"");	
			purchase_unit		=		CommonBean.checkForNull(purchase_unit,"%");
			
			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
		
			
			sqlMap.put("sqlData", "SELECT hdr.PO_MASTER_CODE, mc.short_desc tender_type_desc,hdr.TENDER_NO,TO_CHAR (hdr.TENDER_DATE, 'dd/mm/yyyy') TENDER_DATE,hdr.PUR_UNIT_CODE,pu.short_desc purchae_unit_desc FROM PO_TENDER_HDR hdr ,PO_PURCHASE_UNIT pu, PO_MASTER_CODE mc ,PO_USER_FOR_PUNIT ud WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND (hdr.TENDER_STATUS = 'UN' )  AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.TENDER_NO) LIKE ?  AND hdr.TENDER_DATE BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND mc.MASTER_TYPE = ? and ud.USER_ID = ? and ud.TNDR_ALLOWED_YN = 'Y' AND ud.PUR_UNIT_CODE = hdr.PUR_UNIT_CODE and hdr.PUR_UNIT_CODE = pu.PUR_UNIT_CODE and hdr.PUR_UNIT_CODE LIKE ?");
			
		//	SELECT hdr.PO_MASTER_CODE, mc.short_desc purchase_type_desc,hdr.PO_NO,TO_CHAR (hdr.po_date, 'dd/mm/yyyy') po_date,hdr.PUR_UNIT_CODE,pu.short_desc purchae_unit_desc,hdr.SUPP_CODE, aps.short_name supplier_desc,hdr.PO_ORDER_MODE FROM PO_ORDER_HDR hdr , PO_MASTER_CODE mc,PO_PURCHASE_UNIT pu,ap_supplier aps,PO_USER_FOR_PUNIT uapu WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND hdr.PUR_UNIT_CODE = pu.PUR_UNIT_CODE AND (hdr.PO_STATUS = 'UF' OR hdr.PO_STATUS = 'PA') AND aps.SUPP_CODE = hdr.SUPP_CODE AND uapu.PO_ALLOWED_YN = 'Y' AND uapu.PUR_UNIT_CODE = hdr.PUR_UNIT_CODE AND uapu.user_id = ?  AND hdr.PUR_UNIT_CODE LIKE ? AND hdr.SUPP_CODE LIKE ? AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.PO_NO) LIKE ?  AND hdr.po_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE) AND hdr.PO_ORDER_MODE LIKE ? AND mc.MASTER_TYPE = ?
			
			displayFields.add("tender_type_desc");
			displayFields.add("TENDER_NO");
			displayFields.add("TENDER_DATE");
			displayFields.add("PO_MASTER_CODE");
			displayFields.add("purchae_unit_desc");
			displayFields.add("PUR_UNIT_CODE");
		
					 
			chkFields.add(tender_type);
			chkFields.add(tender_no);
			chkFields.add(from_do_date);
			chkFields.add(to_do_date);
			chkFields.add("POTNDR");			
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(purchase_unit);			

			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
		
			System.out.println("funcMap in query result = "+funcMap);
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
					<th width='260'><fmt:message key="ePO.TndrType.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.TndrNo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="ePO.PORaisedBy.label" bundle="${po_labels}"/></th>
									 
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
				records=(ArrayList) result.get(recCount);
			%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%> </td>
				<td class='NODISPLAY'><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class='NODISPLAY'><%=records.get(5)%></td>
				
				
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
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/TenderQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

