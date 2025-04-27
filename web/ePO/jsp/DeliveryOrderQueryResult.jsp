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
		<script language="javascript" src="../../ePO/js/DeliveryOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body>
<%
		
		String delivery_type	=		request.getParameter("delivery_type");
		String do_no			=		request.getParameter("do_no");
		String supp_code		=		request.getParameter("supp_code");
		String from_do_date     =		request.getParameter("from_do_date");
		String to_do_date       =   	request.getParameter("to_do_date");
		boolean searched		=		(request.getParameter("searched") == null) ?false:true;
		String classvalue		=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			delivery_type		=		CommonBean.checkForNull(delivery_type,"%");
			do_no				=		CommonBean.checkForNull(do_no,"%");
			supp_code			=		CommonBean.checkForNull(supp_code,"%");
			from_do_date        =       CommonBean.checkForNull(from_do_date,"");
			to_do_date          =  		CommonBean.checkForNull(to_do_date,"");	
			
			HashMap sqlMap				=		new HashMap();
			HashMap funcMap				=		new HashMap();
			ArrayList chkFields			=		new ArrayList();
			ArrayList displayFields		=		new ArrayList();
		
			
			sqlMap.put("sqlData", "SELECT hdr.PO_MASTER_CODE, mc.short_desc delivery_type_desc,hdr.DO_NO,TO_CHAR (hdr.do_date, 'dd/mm/yyyy') do_date,hdr.SUPP_CODE, aps.short_name supplier_desc FROM PO_DELV_ORD_HDR hdr , PO_MASTER_CODE mc,ap_supplier aps,PO_USER_FOR_DELVORD ud WHERE hdr.PO_MASTER_CODE = mc.MASTER_CODE AND (hdr.DO_STATUS = 'UF' ) AND aps.SUPP_CODE = hdr.SUPP_CODE  AND hdr.SUPP_CODE LIKE ? AND hdr.PO_MASTER_CODE LIKE ? AND TO_CHAR (hdr.DO_NO) LIKE ?  AND hdr.do_date BETWEEN TO_DATE (TO_CHAR (NVL (?, '01/01/1901')),   'dd/mm/yyyy' )  AND NVL (TO_DATE (?, 'dd/mm/yyyy'), SYSDATE)  AND mc.MASTER_TYPE = ? and ud.USER_ID = ? and ud.DO_ALLOWED_YN = 'Y'");

			
			displayFields.add("delivery_type_desc");
			displayFields.add("DO_NO");
			displayFields.add("DO_DATE");
			displayFields.add("supplier_desc");
			displayFields.add("PO_MASTER_CODE");
			displayFields.add("SUPP_CODE");
		
					
			chkFields.add(supp_code);
			chkFields.add(delivery_type);
			chkFields.add(do_no);
			chkFields.add(from_do_date);
			chkFields.add(to_do_date);
			chkFields.add("DLVORD");			
			chkFields.add(CommonBean.getLoginById());			

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
					<th width='260'><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
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
				records=(ArrayList) result.get(recCount);
			%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%> </td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class='NODISPLAY'><%=records.get(4)%></td>
				
				
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
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/DeliveryOrderQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

