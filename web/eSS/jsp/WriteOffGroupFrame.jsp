<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*"contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="alWriteOffGroupList" scope="session" class="java.util.ArrayList"/>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Geetha CR">
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 

	</head>
<%
	alWriteOffGroupList.clear();
	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_no			=	request.getParameter("doc_no");

	WriteOffGroupListBean bean = (WriteOffGroupListBean)getBeanObject( "WriteOffGroupListBean",   "eSS.WriteOffGroupListBean", request);  
	bean.clear();

	ArrayList alWriteOffGroupRecords	=	null;
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		try{
			ArrayList alParameters = new ArrayList(3);
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(new Long(doc_no));
;	alWriteOffGroupRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_SELECT_MULTIPLE"),alParameters);

			for (int i=0;i<alWriteOffGroupRecords.size();i++){
				HashMap hmWriteOffGroupRecord=(HashMap)alWriteOffGroupRecords.get(i);
				hmWriteOffGroupRecord.put("group_code",		(String)hmWriteOffGroupRecord.get("GROUP_CODE") );
				hmWriteOffGroupRecord.put("group_type",		(String)hmWriteOffGroupRecord.get("GROUP_TYPE") );
				hmWriteOffGroupRecord.put("tray_no",	(String)hmWriteOffGroupRecord.get("TRAY_NO") );
				hmWriteOffGroupRecord.put("write_off_reason_code",		(String)hmWriteOffGroupRecord.get("WRITE_OFF_REASON_CODE")  );
				hmWriteOffGroupRecord.put("remarks",		bean.checkForNull((String)hmWriteOffGroupRecord.get("REMARKS")));
				hmWriteOffGroupRecord.put("description",		(String)hmWriteOffGroupRecord.get("DESCRIPTION"));
				hmWriteOffGroupRecord.put("write_off_reason_desc",		(String)hmWriteOffGroupRecord.get("WRITE_OFF_REASON_DESC"));
				hmWriteOffGroupRecord.put("write_off_cost",		(String)hmWriteOffGroupRecord.get("WRITE_OFF_COST"));
				hmWriteOffGroupRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				hmWriteOffGroupRecord.remove("GROUP_CODE") ;
				hmWriteOffGroupRecord.remove("TRAY_NO")  ;
				hmWriteOffGroupRecord.remove("WRITE_OFF_REASON_CODE");
				hmWriteOffGroupRecord.remove("REMARKS");
				hmWriteOffGroupRecord.remove("DESCRIPTION");
				hmWriteOffGroupRecord.remove("WRITE_OFF_REASON_DESC");
				hmWriteOffGroupRecord.remove("GROUP_TYPE");
				alWriteOffGroupList.add(hmWriteOffGroupRecord);

			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}
%>
	<frameset rows='100,*'>
		<frame name='frameWriteOffGroupHeader'				src="../../eSS/jsp/WriteOffGroupHeader.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameWriteOffGroupDetail'			src="../../eSS/jsp/WriteOffGroupDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
			<frameset rows="15,*">
				<frame name='frameWriteOffGroupListHeader'	src='../../eSS/html/WriteOffGroupListHeader.html'			frameborder=0 scrolling='no'   noresize>
				<frame name='frameWriteOffGroupList'			src="../../eSS/jsp/WriteOffGroupList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
			</frameset>
		</frameset>

	</frameset>
<%
putObjectInBean("WriteOffGroupListBean",bean,request);
%>

</html>
