<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>

<%-- Mandatory declarations end --%>
<html>
	<head>
		<title> </title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
		
<%
			request.setCharacterEncoding("UTF-8");
			String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	</head>
<%
	dispatchList.clear();
	
	String doc_type_code	=	request.getParameter("rof_doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	
	DispatchBean bean = (DispatchBean)getBeanObject( "DispatchBean", "eSS.DispatchBean",request );  
	bean.clear();

	ArrayList alDispatchRecords	=new ArrayList();
	if( (doc_no!=null) && (doc_type_code!=null) )
	{
		try{
			ArrayList alParameters = new ArrayList();
			alParameters.add(session.getAttribute("facility_id"));
			alParameters.add(doc_type_code);
			alParameters.add(doc_no);

		
		alDispatchRecords.clear();
		alDispatchRecords=bean.fetchRecords(bean.getSsRepositoryValue("SQL_SS_DISPATCH_ROF_DTL"),alParameters);//out.println(alDispatchRecords);
			dispatchList.clear();

			for (int i=0;i<alDispatchRecords.size();i++){
				HashMap hmDispatchRecord=(HashMap)alDispatchRecords.get(i);
				hmDispatchRecord.put("GROUP_CODE",			(String)hmDispatchRecord.get("GROUP_CODE") );
				hmDispatchRecord.put("TRAY_NO",		(String)hmDispatchRecord.get("TRAY_NO") );
				hmDispatchRecord.put("WASH_LOAD_NO",		(String)hmDispatchRecord.get("WASH_LOAD_NO") );
				hmDispatchRecord.put("AUTOCLAVE_LOAD_NO",	(String)hmDispatchRecord.get("AUTOCLAVE_LOAD_NO")  );
				hmDispatchRecord.put("PACKING_DATE",	(String)hmDispatchRecord.get("PACKINGDATE"));
				hmDispatchRecord.put("DISPATCH_DATE",	(String)hmDispatchRecord.get("DISPATCH_DATE"));
				hmDispatchRecord.put("STERILE_COST",	""+(Double.parseDouble((String)hmDispatchRecord.get("STERILE_COST"))));
				hmDispatchRecord.put("PACKING_COST",	""+(Double.parseDouble((String)hmDispatchRecord.get("PACKING_COST"))));
				hmDispatchRecord.put("CONSUMABLE_COST",	""+(Double.parseDouble((String)hmDispatchRecord.get("CONSUMABLE_COST"))));
				hmDispatchRecord.put("ROF_COST",	""+(Double.parseDouble(((String)hmDispatchRecord.get("CONSUMABLE_COST")))+Double.parseDouble(((String)hmDispatchRecord.get("STERILE_COST")))+Double.parseDouble(((String)hmDispatchRecord.get("PACKING_COST")))));
				
				hmDispatchRecord.put("mode",			eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
				
				dispatchList.add(hmDispatchRecord);

			}
		}
		catch(Exception exception){
			// out.print(exception);
			exception.printStackTrace(); // COMMON-ICN-0185
		}
	}

%>
	<frameset rows='100,*'>
		<frame name='frameDispatchHeader' id='frameDispatchHeader'				src="../../eSS/jsp/DispatchAddModify.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no'   noresize>
		<frameset cols="40%,*" >
			<frame name='frameDispatchDetail' id='frameDispatchDetail'			src="../../eSS/jsp/DispatchModifyDetail.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='no'   noresize>
				<frame name='frameDispatchList' id='frameDispatchList'			src="../../eSS/jsp/DispatchList.jsp?<%=request.getQueryString()%>"					frameborder=0 scrolling='auto' noresize>
		</frameset>

	</frameset>

</html>
<%
	putObjectInBean("DispatchBean",bean,request);
%>

