<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!--  		<script language="javascript" src="../../eCommon/js/messages.js"></script>
 --> 		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
<!-- 		<script language='javascript' src='../../eST/js/StMessages.js'></script>
 -->		<script language="javascript" src="../../eST/js/GoodsReturnToVendor.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		String doc_type_code = request.getParameter("doc_type_code");
		String doc_no = request.getParameter("doc_no");
		//String doc_date = request.getParameter("doc_date");
		String store_code= request.getParameter("store_code");
		String language_id= request.getParameter("language_id");
		String entry_completed_yn= request.getParameter("entry_completed_yn");
		String doc_date_conv="";
		boolean searched = (request.getParameter("searched") == null) ?false:true;
		String classvalue = "";
		String from_doc_date		=		request.getParameter("from_doc_date");
		from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		String to_doc_date			=		request.getParameter("to_doc_date");
		to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			/*if(!locale.equals("en"))
			{
			   doc_date=  com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
			}*/
			doc_type_code = CommonBean.checkForNull(doc_type_code,"%");
			doc_no = CommonBean.checkForNull(doc_no,"%");
			//doc_date = CommonBean.checkForNull(doc_date,"%");
			from_doc_date = CommonBean.checkForNull(from_doc_date,"");
			to_doc_date = CommonBean.checkForNull(to_doc_date,"");
			store_code = CommonBean.checkForNull(store_code,"%");

			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_RTV_HDR_QUERY_RESULT"));
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("STORE_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("STORE_CODE");

			ArrayList chkFields = new ArrayList();
			

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			//chkFields.add(doc_date);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(store_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(entry_completed_yn);
			chkFields.add(language_id);


			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
				<tr>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
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
		 if(!locale.equals("en"))
				{
				  doc_date_conv=records.get(2).toString();
     doc_date_conv = com.ehis.util.DateUtils.convertDate(doc_date_conv,"DMY","en",locale);
				}else
				{
 doc_date_conv=records.get(2).toString();
//				  doc_date_conv = com.ehis.util.DateUtils.convertDate(doc_date_conv,"DMY",locale,"en");
				}
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=doc_date_conv%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class='NODISPLAY'><%=records.get(4)%></td>
			</tr>
		<%
			}
		%>
		</table>
		<!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
		<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:80vw;height:100vh;background-color:#CCCFFF;filter:alpha(opacity=80);" >
		<table border="0" align="center" width="100%" height="100%">
		<tr><td align="center">
			
			</td></tr>
		</table>
		</div>
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/GoodsReturnToVendorQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

