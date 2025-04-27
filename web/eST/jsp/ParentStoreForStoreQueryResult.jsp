<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*, java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
  <%
		request.setCharacterEncoding("UTF-8");
		String locale			=			(String)session.getAttribute("LOCALE");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
  %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/ParentStoreForStore.js"></script>	
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown="CodeArrest()">

<%
	String store_code					=	request.getParameter("store_code");
	String store_desc					=	request.getParameter("store_desc");
	String parent_store_code			=	request.getParameter("parent_store_code");
	String parent_store_desc			=	request.getParameter("parent_store_desc");

	String bean_id						=	"ParentStoreForStoreBean";
	String bean_name					=	"eST.ParentStoreForStoreBean";
	ParentStoreForStoreBean bean		=	(ParentStoreForStoreBean) getBeanObject( bean_id,bean_name,request);  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	boolean searched					=	(request.getParameter("searched") == null) ?false:true;
	//String orderBy[]					=	request.getParameterValues("orderByCols");
	String classvalue					=	"";

	try{
		
		store_code						=	 CommonBean.checkForNull(store_code)+"%";
		store_desc						=	 CommonBean.checkForNull(store_desc)+"%";
		parent_store_code				=	 CommonBean.checkForNull(parent_store_code)+"%";
		parent_store_desc				=	 CommonBean.checkForNull(parent_store_desc)+"%";

		HashMap sqlMap					=	 new HashMap();
		HashMap funcMap					=	 new HashMap();
		ArrayList displayFields			=	 new ArrayList();
		ArrayList chkFields				=	 new ArrayList();

	


		//String sql="  SELECT b.STORE_CODE STORE_CODE,d.LONG_DESC STORE_DESC, b.PARENT_STORE_CODE PARENT_STORE_CODE,a.LONG_DESC PARENT_STORE_DESC , c.ITEM_CLASS_CODE  ITEM_CLASS_CODE , c.LONG_DESC ITEM_CLASS_DESC,b.EFF_STATUS  EFF_STATUS FROM MM_STORE  a, st_store_parent_store b,MM_ITEM_CLASS c,  MM_STORE  d  WHERE a.STORE_CODE=b.PARENT_STORE_CODE      AND  b.STORE_CODE = d.STORE_CODE AND c.ITEM_CLASS_CODE=b.ITEM_CLASS_CODE    AND Upper(b.STORE_CODE) LIKE Upper(?) AND Upper(d.LONG_DESC) LIKE   Upper(?) AND  Upper(b.PARENT_STORE_CODE) LIKE   Upper(?) AND Upper(a.LONG_DESC) LIKE  Upper(?) and language_id=?" ;

		//sqlMap.put("sqlData",sql);

		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_PARENT_STORE_QUERY_RESULT"));


		displayFields.add("STORE_CODE");
		displayFields.add("STORE_DESC");
		displayFields.add("PARENT_STORE_CODE");
		displayFields.add("PARENT_STORE_DESC");
		displayFields.add("ITEM_CLASS_CODE");
		displayFields.add("ITEM_CLASS_DESC");
		displayFields.add("EFF_STATUS");
		
		

		chkFields.add(store_code);	
		chkFields.add(store_desc);	
		chkFields.add(parent_store_code);	
		chkFields.add(parent_store_desc);	
		//chkFields.add(locale);	
		
		
		funcMap.put("displayFields", displayFields);
		funcMap.put("chkFields", chkFields);

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  align=center>
			<tr>
		
				<th ><fmt:message	 key="Common.StoreCode.label"         bundle="${common_labels}"/></th>
				<th ><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eST.ParentStore.label" bundle="${st_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th ><fmt:message    key="Common.ItemClassCode.label"     bundle="${mm_labels}"/></th>
				<th ><fmt:message    key="Common.ItemClass.label"     bundle="${mm_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th > <fmt:message    key="Common.enabled.label"     bundle="${common_labels}"/> </th>
		</tr>
		
		
		<%
		
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
					
				else
					classvalue = "QRYODD" ;
			%>
			<tr onClick="Modify(this);"  >
			<%
				//String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if(colCount==0)
					{
						
					%>
						<td  class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK' >  <%=(String)records.get( colCount )%>    </font></td>
					<%
					
					}else
					{
						%>
						<% 
							if(colCount == 6) 
							{%>
							<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
							<font style='display:none'><%=records.get(colCount)%></font>
							<%
								
								if( ((String)records.get( colCount )).equals("E"))
										out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
										out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else 
							{%>
								<td class='<%=classvalue%>' onclick='disableClick(event);'>
							<%	out.println((String)records.get( colCount ));
							}

					%> </td>
					<%
					}
				}
				%>
			</tr>
		<%}	%>
		</table>
		<%
			out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/ParentStoreForStoreQueryResult.jsp", searched) );
	} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

