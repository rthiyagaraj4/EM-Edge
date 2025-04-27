<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,java.lang.*,eST.*" 
contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");

		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 String facilityid=(String)session.getValue("facility_id");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	    <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/GoodsReceivedNote.js"></script>
		<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
	<%
		String doc_type_code		=		request.getParameter("doc_type_code");
		String doc_no				=		request.getParameter("doc_no");
		//String doc_date				=		request.getParameter("doc_date");
		String store_code			=		request.getParameter("store_code");
		String supp_code			=		request.getParameter("supp_code");
		String entry_completed_yn	=		request.getParameter("entry_completed_yn");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String classvalue			=		"";
		String language_id			=		request.getParameter("language_id");

		String from_doc_date		=		request.getParameter("from_doc_date");
		from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		String to_doc_date			=		request.getParameter("to_doc_date");
		to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");

		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();

		String bean_id					=		"goodsReceivedNoteBean" ;
		String bean_name				=		"eST.GoodsReceivedNoteBean";
		eST.GoodsReceivedNoteBean bean  =		(eST.GoodsReceivedNoteBean) getBeanObject(bean_id,bean_name,request);
		String external_po_yn			=	bean.checkForNull((String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),new String[]{(String)session.getAttribute("ACC_ENTITY_ID")}).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
		String sql				= "";
		
	   //Added by Rabbani #inc no:30127 on 09/01/12   Starts
		//boolean flaggrn = bean.isCreateGRNApplicable(facilityid,"GRN");  
		/*  commented to handle jordan crf for unfinalized grn
		if(external_po_yn.equals("Y")){  
		   if(flaggrn){
		    sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT");
		        }else{
			sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT") +" AND PO_NO IS NOT NULL";
			}
	   }else{
			sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT");
		}*/
		sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT");
		//ends
		//commented by Rabbani on 09/01/12
		/* if(external_po_yn.equals("Y")){
			sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT") +" AND PO_NO IS NOT NULL";
		}else{
			sql = eST.Common.StRepository.getStKeyValue("SQL_ST_GRN_HDR_QUERY_RESULT");
		} */
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code			=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no					=		CommonBean.checkForNull(doc_no,"%");
			//doc_date				=		CommonBean.checkForNull(doc_date,"%");
			from_doc_date			=		CommonBean.checkForNull(from_doc_date,"");
			to_doc_date				=		CommonBean.checkForNull(to_doc_date,"");
			store_code				=		CommonBean.checkForNull(store_code,"%");
			supp_code				=		CommonBean.checkForNull(supp_code,"%");

			sqlMap.put("sqlData", sql);


			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("STORE_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("STORE_CODE");
			displayFields.add("SUPP_DESC");

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			//chkFields.add(doc_date);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(store_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(entry_completed_yn);
			chkFields.add(supp_code);
			chkFields.add(language_id);

			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
				<th><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%
				records					=	(ArrayList) result.get(recCount);
				String doc_date_conv	=	com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale);
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" ><%=doc_date_conv%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class='NODISPLAY'><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(6)%></td>
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
		<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);" >
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/GoodsReceivedNoteQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
	}
%>
</body>
</html>

