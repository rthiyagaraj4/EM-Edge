<!DOCTYPE html>
<%@ page import="eST.TrnAuditTrailBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/TrnAuditTrail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		</head>

	<%
		request.setCharacterEncoding("UTF-8");
		String locale								=		(String)session.getAttribute("LOCALE");
		String bean_id								=		"trnAuditTrailBean";
		String bean_name							=		"eST.TrnAuditTrailBean";
		String classValue							=		"";
		String mode									=		request.getParameter("mode");
		String function_id							=		request.getParameter("function_id");

		TrnAuditTrailBean trnAuditTrailBean			=		(TrnAuditTrailBean)getBeanObject( bean_id, bean_name, request);  
		
		trnAuditTrailBean.setLanguageId(locale);
		String trn_type				=trnAuditTrailBean.checkForNull(request.getParameter("trn_type"),"%");

		String doc_type_code		=trnAuditTrailBean.checkForNull(request.getParameter("doc_type_code"),"%");
		String doc_no				=trnAuditTrailBean.checkForNull(request.getParameter("doc_no"),"%");
		String doc_date_from		=
		com.ehis.util.DateUtils.convertDate(request.getParameter("doc_date_from"),"DMY",locale,"en");//MODIFIED to show records in thai language by chandrashekar a
		String doc_date_to			=trnAuditTrailBean.checkForNull(request.getParameter("doc_date_to"),"");
		String deleted_by_id		=trnAuditTrailBean.checkForNull(request.getParameter("deleted_by_id"),"%");
		String header		=trnAuditTrailBean.checkForNull(request.getParameter("header"),"");
		String order		=trnAuditTrailBean.checkForNull(request.getParameter("order"),"");
		String search				=trnAuditTrailBean.checkForNull(request.getParameter("search"),"");
		int from					=Integer.parseInt(trnAuditTrailBean.checkForNull(request.getParameter("from"),"0"));
		int to						=Integer.parseInt(trnAuditTrailBean.checkForNull(request.getParameter("to"),"0"));
		ArrayList deletedDocs = null;
		if(search.equals("new")){
		//bean.clear();
		deletedDocs = (ArrayList)trnAuditTrailBean.getDeletedDocs( doc_no, deleted_by_id, doc_date_from, doc_date_to,trn_type,doc_type_code);
		}else
		deletedDocs = trnAuditTrailBean.getDeletedDocDetails();
		int maxRecord = deletedDocs.size() ;
			

		if(maxRecord <= to)
		to = maxRecord-1;
		int count=from;
		String visibleTT="STYLE=visibility:hidden";
		String visibleDT="STYLE=visibility:hidden";
		String visibleDN="STYLE=visibility:hidden";
		String visibleDD="STYLE=visibility:hidden";
		String visibleCB="STYLE=visibility:hidden";
		String visibleDB="STYLE=visibility:hidden";
		String visibleDDT="STYLE=visibility:hidden";
		

		String orderTT="";
		String orderDT="";
		String orderDN="";
		String orderDD="";
		String orderCB="";
		String orderDB="";
		String orderDDT="";
	
		if(header.equals("TT")){
		visibleTT="STYLE=visibility:visible";
		orderTT=order;
		
		}else if(header.equals("DT")){
		visibleDT="STYLE=visibility:visible";
		orderDT=order;
		}else if(header.equals("DN")){
		visibleDN="STYLE=visibility:visible";
		orderDN=order;
		}else if(header.equals("DD")){
		visibleDD="STYLE=visibility:visible";
		orderDD=order;
		}else if(header.equals("CB")){
		visibleCB="STYLE=visibility:visible";
		orderCB=order;
		}else if(header.equals("DB")){
		visibleDB="STYLE=visibility:visible";
		orderDB=order;
		}else if(header.equals("DDT")){
		visibleDDT="STYLE=visibility:visible";
		orderDDT=order;
		}
		
	
		
		%>
	<body >
		<form name='formTrnAuditTrialResult' id='formTrnAuditTrialResult'>
			<table   border="0" cellpadding="0" height='0' cellspacing="0" width="100%"  >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=from%>'>
						<input type=hidden name='to' id='to' value='<%=to%>'>
<%
						if(from > 0) {
%>
							<a href='javascript:submitPrevNext(<%=(from-15)%>,<%=(from-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((from+15) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(from+15)%>,<%=(from+29)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>
			<% if( deletedDocs.size()>0){%>
		<table border="1" cellpadding="0"  cellspacing="0" width="100%"   >
 			<tr>
			<%	if(orderTT.equals("") || orderTT.equals("DESC")){%>
			<th  onclick ="changeOrder(TTorder,'TT');" style="cursor:pointer" nowrap><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/> <img src="../../eST/images/Descending.gif" alt="Descending Order"  id="TT" <%=visibleTT %>  ></th>
			<%}else{%>
			<th  onclick ="changeOrder(TTorder,'TT');" style="cursor:pointer" nowrap><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/> <img src="../../eST/images/Ascending.gif" alt="Ascending Order"  id="TT" <%=visibleTT %>  ></th>
			<%}
			if(orderDT.equals("") || orderDT.equals("DESC")){
			%>
			<th  onclick ="changeOrder(DTorder,'DT');" style="cursor:pointer" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/> <img src="../../eST/images/Descending.gif" alt="Descending Order"  id="DT" <%=visibleDT %>  ></th>
			<%}else{%>
			<th  onclick ="changeOrder(DTorder,'DT');" style="cursor:pointer" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/> <img src="../../eST/images/Ascending.gif" alt="Ascending Order"  id="DT" <%=visibleDT %>  ></th>
			<%}
			if(orderDN.equals("") || orderDN.equals("DESC")){
			%>
			<th  onclick ="changeOrder(DNorder,'DN');" style="cursor:pointer" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> <img src="../../eST/images/Descending.gif" alt="Descending Order" id="DN" <%=visibleDN %>  ></th>	
			<%}else{%>	
			<th  onclick ="changeOrder(DNorder,'DN');" style="cursor:pointer" ><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/> <img src="../../eST/images/Ascending.gif" alt="Ascending Order" id="DN" <%=visibleDN %>  ></th>	
			<%}
			if(orderDD.equals("") || orderDD.equals("DESC")){
			%>
			<th  onclick ="changeOrder(DDorder,'DD');" style="cursor:pointer" ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> <img src="../../eST/images/Descending.gif" alt="Descending Order"  id="DD" <%=visibleDD %> ></th>
			<%}else{%>
			<th  onclick ="changeOrder(DDorder,'DD');" style="cursor:pointer" ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/> <img src="../../eST/images/Ascending.gif" alt="Ascending Order"  id="DD" <%=visibleDD %> ></th>
			<%}
			if(orderCB.equals("") || orderCB.equals("DESC")){
			%>
			<th  onclick ="changeOrder(CBorder,'CB');" style="cursor:pointer" ><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/> <img src="../../eST/images/Descending.gif" alt="Descending Order" id="CB"  <%=visibleCB %> ></th>
			<%}else{%>
			<th  onclick ="changeOrder(CBorder,'CB');" style="cursor:pointer" ><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/> <img src="../../eST/images/Ascending.gif" alt="Ascending Order" id="CB"  <%=visibleCB %> ></th>
			<%}
			if(orderDB.equals("") || orderDB.equals("DESC")){%>
				<th  onclick ="changeOrder(DBorder,'DB');" style="cursor:pointer" > <fmt:message key="eST.DeletedBy.label" bundle="${st_labels}"/><img src="../../eST/images/Descending.gif" alt="Descending Order" id="DB" <%=visibleDB %>></th>
			<%}else{%>
			<th  onclick ="changeOrder(DBorder,'DB');" style="cursor:pointer" > <fmt:message key="eST.DeletedBy.label" bundle="${st_labels}"/><img src="../../eST/images/Ascending.gif" alt="Ascending Order" id="DB" <%=visibleDB %>></th>
			<%} if(orderDDT.equals("") || orderDDT.equals("DESC")){%>
				<th  onclick ="changeOrder(DTTorder,'DDT');" style="cursor:pointer" > <fmt:message key="eST.DeletionDateTime.label" bundle="${st_labels}"/><img src="../../eST/images/Descending.gif" alt="Descending Order" id="DDT" <%=visibleDDT %>></th>
				<%}else{%>
				<th  onclick ="changeOrder(DTTorder,'DDT');" style="cursor:pointer" > <fmt:message key="eST.DeletionDateTime.label" bundle="${st_labels}"/><img src="../../eST/images/Ascending.gif" alt="Ascending Order" id="DDT" <%=visibleDDT %>></th>
				<%}%>
				<input type="hidden"		 name="DTTorder" id="DTTorder"						value='<%=orderDDT%>'>
				<input type="hidden"		 name="DBorder" id="DBorder"						value='<%=orderDB%>'>
				<input type="hidden"		 name="CBorder" id="CBorder"						value='<%=orderCB%>'>
				<input type="hidden"		 name="DDorder" id="DDorder"						value='<%=orderDD%>' >
				<input type="hidden"		 name="DNorder" id="DNorder"						value='<%=orderDN%>'>
				<input type="hidden"		 name="DTorder" id="DTorder"						value='<%=orderDT%>'>
				<input type="hidden"		 name="TTorder" id="TTorder"						value='<%=orderTT%>'>

			</tr>
				<tr>
		<%
				while(count <= to){
				classValue		=		((count+1)%2)==0?"QRYODD":"QRYEVEN" ;
				
				java.util.HashMap hh=(HashMap)deletedDocs.get(count);
	%>

			<td class='<%=classValue%>'   ><%=hh.get("TRN_DESC")%></td>
			<td class='<%=classValue%>' nowrap ><%=hh.get("DOC_DESC")%></td>
			<td class='<%=classValue%>'  ><%=hh.get("DOC_NO")%></td>
			<td class='<%=classValue%>' ><%=hh.get("DOC_DATE")%></td>
			<td class='<%=classValue%>' ><%=hh.get("CREATED_BY")%></td>
			<td class='<%=classValue%>' ><%=hh.get("DELETED_BY")%></td>
			<td class='<%=classValue%>'   ><%=hh.get("DELETED_DATE_TIME")%></td>


</tr>
<%
count++;

}%>
</table>
			<input type="hidden"	 name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden"	 name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden"	 name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden"	 name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden"	 name="trn_type" id="trn_type"					value="<%=trn_type%>">
			<input type="hidden"	 name="doc_type_code" id="doc_type_code"				value="<%=doc_type_code%>">
			<input type="hidden"	 name="doc_no" id="doc_no"						value="<%=doc_no %>">
			<input type="hidden"	 name="doc_date_from" id="doc_date_from"				value="<%=com.ehis.util.DateUtils.convertDate(doc_date_from,"DMY","en",locale)%>">
			<input type="hidden"	 name="doc_date_to" id="doc_date_to"					value="<%=doc_date_to%>">
			<input type="hidden"	 name="deleted_by_id" id="deleted_by_id"				value="<%=deleted_by_id%>">
			<input type="hidden"	 name="order" id="order"						value="<%=order%>">
			<input type="hidden"	 name="header" id="header"						value="<%=header%>">
			
					
	
		</form>
		<%}else{%>
		<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
			
			</script>
		<%	}
		putObjectInBean(bean_id,trnAuditTrailBean,request);
%>
	</body>
</html>

