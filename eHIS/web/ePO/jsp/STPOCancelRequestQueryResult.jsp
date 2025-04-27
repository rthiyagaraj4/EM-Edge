<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,ePO.STPOCancelRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>  
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
 	    <script language="JavaScript" src="../../ePO/js/STPOCancelRequest.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formSTPOCancelRequestQueryResult" id="formSTPOCancelRequestQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"STpoCancelRequestBean";
		String bean_name				=		"ePO.STPOCancelRequestBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");

		//if ((mode == null) || (mode.equals(""))) 
			//return;
		//if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			//return;

		STPOCancelRequestBean bean		=		(STPOCancelRequestBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		String req_code			        =		request.getParameter("req_code");
		String req_no					=		request.getParameter("req_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		String to_doc_date				=		request.getParameter("to_doc_date");
		String request_by_store			=		request.getParameter("request_by_store");
		String request_type				=		request.getParameter("request_type");
		String pur_unit_code			=		request.getParameter("pur_unit_code");
		
		String checked					=		"checked";  
		int checked_ind;
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		String rmksDisabled					=		"";  
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			req_code				    =		CommonBean.checkForNull(req_code,"%");
			req_no						=		CommonBean.checkForNull(req_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
            to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			request_by_store			=		CommonBean.checkForNull(request_by_store,"%");
			request_type				=		CommonBean.checkForNull(request_type,"%");
			pur_unit_code				=		CommonBean.checkForNull(pur_unit_code,"%");
			

			HashMap sqlMap				=		new HashMap();
	        sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_CANCEL_REQUEST_QUERY_RESULT"));
			
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();

			displayFields.add("REQ_CODE_DESC"); 
			//displayFields.add("DOC_TYPE_DESC");
			displayFields.add("REQ_NO");  
			displayFields.add("REQ_DATE");  
			displayFields.add("REQ_BY_STORE_DESC");  
			displayFields.add("PUR_UNIT");  
			displayFields.add("REQ_CODE"); 
			displayFields.add("REQ_STORE_CODE");   
			displayFields.add("PUR_UNIT_CODE");    
			displayFields.add("REQUEST_STATUS");   
			
         			 
			ArrayList chkFields			=		new ArrayList();
			chkFields.add(req_code);
			chkFields.add(req_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(request_by_store);
			chkFields.add(pur_unit_code);
			chkFields.add(bean.getLoginById());
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add(locale);
			chkFields.add("POREQN");   // Added By Padmapriya INC # 34817 on 07/09/2012
		 
		 
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
			    <td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
		   	 <tr>
					<th width='260'><fmt:message key="ePO.RequestType.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.RequestNo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.RequestDate.label" bundle="${po_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/></th>
					<th><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formSTPOCancelRequestQueryResult);">
					</th>
					<th ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				</tr>		
				
	  	 <%
			ArrayList records=new ArrayList();
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
		 %>
				<tr id="tr_<%=i%>">
		<%
			records				=		(ArrayList) result.get(recCount);
			checked_ind			=		 Arrchkitem.indexOf(records.get(5)+"-"+records.get(1));
			checked				=		(checked_ind != -1 ? "checked":"");
			classvalue			=		(checked == ""?classvalue:"DATACHANGE");
			if(checked_ind != -1)
				rmksDisabled = "";
			else	
				rmksDisabled = "disabled";
			
		%>
		
		<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" nowrap>
		<font class='HYPERLINK'><%=(String)records.get(0)%></font></td>				
		<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%>	</td>		
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>		
		<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(3)%></td>		
		<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(4)%>	</td>	
		<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(8)%>">			
		<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor (<%=i%>,7,this)"  value="<%=records.get(5)%>-<%=records.get(1)%>" title="<%=records.get(8)%>"  <%=checked%>>	</td>	
		<td id="remarks_td_<%=i%>" class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" <%=rmksDisabled%>>
		<font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font>
		
		<% if(checked.equals("checked")){ %>
			<span id="manditHidden_<%=i%>" style=visibility:visible> <%=bean.getImage("M")%> </span>	
		<% }else{ %>
			<span id="manditHidden_<%=i%>" style=visibility:hidden> <%=bean.getImage("M")%> </span>	
		<%}%>	
		</td>
		<td class='NODISPLAY'>
		<%=records.get(5)%>
		</td>				
					
		        <input type="hidden"  name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="" %>
				<input type="hidden"  name="details_<%=i%>" id="details_<%=i%>"			value="" %>	
				<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"               value="">
			</tr>
		<%
			}
		%>
		</table>		
		<input type="hidden" name="checkedIndices" id="checkedIndices"					value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"				value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name%>">
		<input type="hidden" name="mode" id="mode"							value="<%= mode%>">

	   </form>			
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
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/STPOCancelRequestQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

