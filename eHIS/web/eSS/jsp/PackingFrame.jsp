<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<jsp:useBean id="alPackingList" scope="session" class="java.util.ArrayList"/>
<jsp:useBean id="alPackingDiscrepancyList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Manish Anand">
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	</head>
<%
	alPackingList.clear();
	alPackingDiscrepancyList.clear();
	String doc_type_code		=	request.getParameter("doc_type_code");
	String doc_no				=	request.getParameter("doc_no");
	
	PackingListBean bean		=	(PackingListBean)getBeanObject( "packingListBean", "eSS.PackingListBean",request );  
	bean.clear();

	ArrayList alPackingRecords	=	null;
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(new Long(doc_no));
			
			alPackingRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_ROF_DTL_SELECT_MULTIPLE"),alParameters);

			for (int i=0;i<alPackingRecords.size();i++){
				HashMap hmPackingRecord=(HashMap)alPackingRecords.get(i);
				hmPackingRecord.put("tray_no",			(String)hmPackingRecord.get("TRAY_NO") );
				hmPackingRecord.put("group_code",		(String)hmPackingRecord.get("GROUP_CODE") );
				hmPackingRecord.put("group_desc",		(String)hmPackingRecord.get("GROUP_DESC") );
				hmPackingRecord.put("pack_item_code",	bean.checkForNull((String)hmPackingRecord.get("pack_item_code"),"") );
				hmPackingRecord.put("pack_item_qty",	bean.checkForNull((String)hmPackingRecord.get("pack_item_qty"),""));
				hmPackingRecord.put("pack_cost",		bean.checkForNull((String)hmPackingRecord.get("PACK_COST"),""));
				hmPackingRecord.put("packing_date",		bean.checkForNull((String)hmPackingRecord.get("PACKING_DATE"),""));
				hmPackingRecord.put("pack_item_desc",	bean.checkForNull((String)hmPackingRecord.get("pack_item_desc"),""));
				hmPackingRecord.put("store_code",		bean.checkForNull((String)hmPackingRecord.get("store_code"),""));
				hmPackingRecord.put("hold_yn",			(String)hmPackingRecord.get("HOLD_YN"	));
				hmPackingRecord.put("hold_reason",		bean.checkForNull((String)hmPackingRecord.get("HOLD_REASON"),""));
				hmPackingRecord.put("mode",				eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				
				hmPackingRecord.remove("TRAY_NO");    
				hmPackingRecord.remove("GROUP_CODE");   
				hmPackingRecord.remove("GROUP_DESC");   
				hmPackingRecord.remove("pack_item_code");
				hmPackingRecord.remove("pack_item_qty");      
				if((String) hmPackingRecord.get("pack_item_qty")==null)
				{
					hmPackingRecord.put("pack_item_qty","");
				}
				if((String) hmPackingRecord.get("store_code")==null)
				{
					hmPackingRecord.put("store_code","");
				}
				if((String) hmPackingRecord.get("pack_item_code")==null)
				{
					hmPackingRecord.put("pack_item_code","");
				}
				if((String) hmPackingRecord.get("pack_item_desc")==null)
				{
					hmPackingRecord.put("pack_item_desc","");
				}
				hmPackingRecord.remove("pack_cost"); 
				hmPackingRecord.remove("PACKING_DATE"); 
				hmPackingRecord.remove("pack_item_desc"); 
				hmPackingRecord.remove("HOLD_YN"); 
				hmPackingRecord.remove("HOLD_REASON"); 
				alPackingList.add(hmPackingRecord);				
				
				
			}
			
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}

putObjectInBean("packingListBean",bean,request);

%>
	<frameset rows='100,*'>
		<frame name='framePackingHeader'				src="../../eSS/jsp/PackingHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='framePackingDetail'			src="../../eSS/jsp/PackingDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
				<frame name='framePackingList'			src="../../eSS/jsp/PackingList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
		</frameset>

	</frameset>

</html>
