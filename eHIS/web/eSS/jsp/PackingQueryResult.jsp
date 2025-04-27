<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/Packing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String doc_type_code		= request.getParameter("doc_type_code");
	String doc_no				= request.getParameter("doc_no");
	String doc_date				= request.getParameter("doc_date");
	String store_code			= request.getParameter("store_code");
	String service_location_code= request.getParameter("service_location_code");


	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		doc_type_code			= CommonBean.checkForNull(doc_type_code,"%"			);
		doc_no					= CommonBean.checkForNull(doc_no,"%"				);
		doc_date				= CommonBean.checkForNull(doc_date,""				);
		if(!(locale.equals("en")))
		{
					 doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
		}
			
		store_code				= CommonBean.checkForNull(store_code,"%"			);
		service_location_code	= CommonBean.checkForNull(service_location_code,"%"	);

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ROF_HDR_QUERY_RESULT") );
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("doc_type_desc");
		displayFields.add("doc_no");
		displayFields.add("doc_date");
		displayFields.add("store_desc");
		displayFields.add("service_location_desc");
		displayFields.add("doc_type_code");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add((String)session.getAttribute("facility_id"));
		chkFields.add(doc_type_code			);
		chkFields.add(doc_no				);
		chkFields.add(doc_date				);
		chkFields.add(store_code			);
		chkFields.add(service_location_code	);
		chkFields.add(CommonBean.getLoginById());

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );


		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
				<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				String doc_date_disp = (String)records.get(2);
				if(!(locale.equals("en")))
				{
					 doc_date_disp=com.ehis.util.DateUtils.convertDate(doc_date_disp,"DMY","en",locale);
				}
				for(int colCount=0; colCount<records.size(); colCount++){
					if(colCount==5){
						%>
						<td class='NODISPLAY'><%=(String)records.get( colCount )%></td>	
						<%
						continue;
					}
					if(colCount==2){
						%>
						<td class=<%=classvalue%>><%=doc_date_disp%></td>	
						<%
						continue;
					}
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);" align="<%=(colCount==1)?"right":((colCount==2)?"center":"")%>"
						<%
						 //if gif has to be provided
								out.println(">"+(String)records.get( colCount ));
						%></td>
		<%
						}
					}
		%>
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
				self.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/PackingQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

