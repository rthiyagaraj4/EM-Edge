<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
07/11/2012		IN036060		Karthi L		Sort order and Search criteria in Order Type Desc and Order Catalog Desc are not working
18/12/2013		IN045770		Ramesh G		Bru-HIMS-CRF-348.2- 45197/03
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@page import="eOR.Common.*,java.util.*,java.sql.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language = 'javascript' src = '../../eOR/js/OrderCatalogForDeceased.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<BODY class='CONTENT'  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name=result_form >
<%
	String classvalue = "";
	String enableGif ="<img src='../../eCommon/images/enabled.gif'></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif'></img>" ;

	try
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

		String order_category		= CommonBean.checkForNull(request.getParameter("order_category"));
		String order_type_code		= CommonBean.checkForNull(request.getParameter("order_type_code"));
		String order_type_desc		= CommonBean.checkForNull(request.getParameter("order_type_desc")); // IN036060
		String order_catalog_code	= CommonBean.checkForNull(request.getParameter("order_catalog_code"));
		String order_catalog_desc	= CommonBean.checkForNull(request.getParameter("order_catalog_desc")); // IN036060
		String post_applicability	= CommonBean.checkForNull(request.getParameter("post_applicability"));
		String post_type			= CommonBean.checkForNull(request.getParameter("post_type"));
		
		boolean searched			= request.getParameter( "searched" ) == null? false : true  ;

		//Common parameters.
		HashMap sqlMap = new HashMap();

		//include all the common parameters.
		//sqlMap.put( "sqlData", "SELECT ORDER_CATEGORY,or_get_desc.OR_ORDER_CATEGORY(ORDER_CATEGORY,'en',2) ORDER_CATEGORY_DESC,ORDER_TYPE_CODE,NVL(or_get_desc.OR_ORDER_TYPE(ORDER_TYPE_CODE,'en',2), 'ALL') ORDER_TYPE_DESC, ORDER_CATALOG_CODE,NVL(or_get_desc.OR_ORDER_CATALOG(ORDER_CATALOG_CODE,'en',2), 'ALL') ORDER_CATALOG_DESC,decode(POSTMORTEM_APPLICABILITY,'B','Both','R','Post Mortem Request','Q','Post Mortem Record')POSTMORTEM_APPLICABILITY,decode(POSTMORTEM_TYPE,'B','Both','C','Clinical Post Mortem','M','Medico Legal Post Mortem')POSTMORTEM_TYPE, nvl(ALLOW_FOR_DECEASED,'N')ALLOW_FOR_DECEASED FROM OR_ORDER_RULES_DECEASED WHERE ORDER_CATEGORY LIKE ? AND ORDER_TYPE_CODE LIKE ?  AND ORDER_CATALOG_CODE LIKE ? AND POSTMORTEM_APPLICABILITY LIKE ? AND POSTMORTEM_TYPE LIKE ? ");
		// modified above query for IN036060
		//IN045770 Start.
		//sqlMap.put( "sqlData", "SELECT ORDER_CATEGORY,ORDER_CATEGORY_DESC,ORDER_TYPE_CODE,ORDER_TYPE_DESC, ORDER_CATALOG_CODE,ORDER_CATALOG_DESC,decode(POSTMORTEM_APPLICABILITY,'B','Both','R','Post Mortem Request','Q','Post Mortem Record')POSTMORTEM_APPLICABILITY,decode(POSTMORTEM_TYPE,'B','Both','C','Clinical Post Mortem','M','Medico Legal Post Mortem')POSTMORTEM_TYPE, decode(nvl(ALLOW_FOR_DECEASED,'N'),'Y','Yes','N','No')ALLOW_FOR_DECEASED FROM OR_ORDER_RULES_DECEASED_VW WHERE ORDER_CATEGORY LIKE ? AND ORDER_TYPE_CODE LIKE ?  and order_type_desc like ? AND ORDER_CATALOG_CODE LIKE ? and order_catalog_desc like ? AND POSTMORTEM_APPLICABILITY LIKE ? AND POSTMORTEM_TYPE LIKE ? ");
		sqlMap.put( "sqlData", "SELECT ORDER_CATEGORY,ORDER_CATEGORY_DESC,ORDER_TYPE_CODE,ORDER_TYPE_DESC, ORDER_CATALOG_CODE,ORDER_CATALOG_DESC,decode(POSTMORTEM_APPLICABILITY,'B','All','R','Post Mortem Request','Q','Post Mortem Record','E','Embalm Registration')POSTMORTEM_APPLICABILITY,decode(POSTMORTEM_TYPE,'B','Both','C','Clinical Post Mortem','M','Medico Legal Post Mortem','E','Not Applicable')POSTMORTEM_TYPE, decode(nvl(ALLOW_FOR_DECEASED,'N'),'Y','Yes','N','No')ALLOW_FOR_DECEASED FROM OR_ORDER_RULES_DECEASED_VW WHERE ORDER_CATEGORY LIKE ? AND ORDER_TYPE_CODE LIKE ?  and order_type_desc like ? AND ORDER_CATALOG_CODE LIKE ? and order_catalog_desc like ? AND POSTMORTEM_APPLICABILITY LIKE ? AND POSTMORTEM_TYPE LIKE ? ");
		//IN045770 End.
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add( "ORDER_CATEGORY" );
		displayFields.add( "ORDER_CATEGORY_DESC" );
		displayFields.add( "ORDER_TYPE_CODE" );
		displayFields.add( "ORDER_TYPE_DESC" );
		displayFields.add( "ORDER_CATALOG_CODE" );
		displayFields.add( "ORDER_CATALOG_DESC" );
		displayFields.add( "POSTMORTEM_APPLICABILITY" );
		displayFields.add( "POSTMORTEM_TYPE" );
		displayFields.add( "ALLOW_FOR_DECEASED" );
		ArrayList chkFields = new ArrayList();
		chkFields.add( order_category.trim()+"%" );
		chkFields.add( order_type_code.trim()+"%" );
		chkFields.add( order_type_desc.trim()+"%" ); //IN036060
		chkFields.add( order_catalog_code.trim()+"%" );
		chkFields.add( order_catalog_desc.trim()+"%" ); //IN036060
		chkFields.add( post_applicability.trim()+"%" );
		chkFields.add( post_type.trim()+"%" );
	
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		int rowCount = 1;
		
		for(int i=0; i< result.size();i++) {
		}

		if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) ))
		{

%>
			<table cellpadding=3 cellspacing=0 width="100%" align=center>
			<tr>
				<td class='label'></td>
				<td class='label'>
<%
				out.println(result.get(1));
%>
				</td>
			</tr>
			</table>

			<table class='grid' width='100%'>
			<tr>
			  <th class='columnheader'  width="5%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			  <th class='columnheader'  width="5%"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/>Desc</td>
			  <th class='columnheader'  width="10%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
			  <th class='columnheader'  width="20%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/>Desc</td>
			  <th class='columnheader' width="10%"><fmt:message key="Common.OrdercatalogCode.label" bundle="${common_labels}"/></td>
			  <th class='columnheader' width="20%"><fmt:message key="Common.OrderCatalogDesc.label" bundle="${common_labels}"/></td>
			  <th class='columnheader'  width="15%"><fmt:message key="eOR.appl.label" bundle="${or_labels}"/></td>
			  <th class='columnheader'  width="20%"><fmt:message key="eOR.Type.label" bundle="${or_labels}"/></td>
			  <th class='columnheader'  width="10%">Allow Orders for Deceased</td>
			</tr>

<%
			ArrayList records=new ArrayList();
			int index = 0;
			
			
			
			for(int recCount=2; recCount<result.size(); recCount++) 
			{
				if ( recCount % 2 == 0 )
					classvalue = "gridData" ;
				else
					classvalue = "gridData" ;
					
				
%>			
				
				<tr>
<%
				
			    String orderCategoryCol = "0";
				records=(ArrayList) result.get( recCount );
				
				String order_category_short_code = (String)records.get(0);
				String order_category_code = (String)records.get(1);
				String order_type_short_code = (String)records.get(2);
				String order_type_code_return = (String)records.get(3);
				String order_catalog_short_code = (String)records.get(4);
				String order_catalog_code_return = (String)records.get(5);
				String post_mortem_appl = (String)records.get(6);
				String post_mortem_type = (String)records.get(7);
				String allow_for_deceased = (String)records.get(8);
				String deleteValue = (String)records.get(0)+"~~##"+(String)records.get(2)+"~~##"+(String)records.get(4)+"~~##"+(String)records.get(6)+"~~##"+(String)records.get(7)+"~~##"+ (String)records.get(8);
				for(int colCount=0; colCount<records.size(); colCount++)
				{
					if(orderCategoryCol.equals(String.valueOf(colCount)))
					{ 
%>
						<td class="<%=classvalue%>">  <a href = 'javascript:updatedata("<%=order_category_code%>","<%=order_type_code_return%>","<%=order_catalog_code_return%>","<%=post_mortem_appl%>","<%=post_mortem_type%>","<%=allow_for_deceased%>","<%=order_category_short_code%>","<%=order_type_short_code%>","<%=order_catalog_short_code%>");'> <%=order_category_short_code%>  </td>
<%
					}
					else
					{
%>
						<td class="<%=classvalue%>"><%=(String)records.get(colCount)%></td>
<%
					}
				}
				index++;
%>
					
				</tr>
<%			
			}
						
		%>
		</table>
		</form>
<%
		out.flush();
		} 
		else
		{
%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
<%
		}

		out.println(CommonBean.setForm(request ,"OrderCatalogForDeceasedQueryResult.jsp", searched));

	}
	catch(Exception e )
	{
		e.printStackTrace();
	}
%>
<input type = 'hidden' name = 'language_id' value = '<%=localeName%>'/>
</body>
</html>


