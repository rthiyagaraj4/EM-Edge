<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/ReasonCode.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var image_id = obj.cells[0].innerText;
		var	hot_spot_id		= obj.cells[2].innerText;
		var	image_link		= obj.cells[4].innerText;

		//alert(image_id)
		//alert(hot_spot_id)
		//alert(image_link)

		document.location.href="../../eOR/jsp/ImageHotSpotLinkAddModify.jsp?mode=2&image_id="+encodeURIComponent(image_id)+"&hot_spot_id="+encodeURIComponent(hot_spot_id)+"&image_link="+encodeURIComponent(image_link)+"&function_id"+parent.function_id;
	}
	</script>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String image_id		= CommonBean.checkForNull(request.getParameter("image_id"));
    String image_desc	= CommonBean.checkForNull(request.getParameter("image_desc"));
    String hot_spot_id	= CommonBean.checkForNull(request.getParameter("hot_spot_id"));
    String hot_spot_desc= CommonBean.checkForNull(request.getParameter("hot_spot_desc"));
    String image_link	= CommonBean.checkForNull(request.getParameter("image_link"));

	image_id	= image_id.toUpperCase();
	hot_spot_id = hot_spot_id.toUpperCase();
	image_desc	= image_desc.toUpperCase();
	hot_spot_desc = hot_spot_desc.toUpperCase();
	image_link = image_link.toUpperCase();
	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_OR_IMAGE_HOTSPOT_LINK_SELECT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "image_id" );
	displayFields.add( "image_name" );
	displayFields.add( "hotspot_id" );
	displayFields.add( "hotspot_name" );
	displayFields.add( "image_link_id" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();


	chkFields.add(image_id+"%");
	chkFields.add(image_desc+"%");
	chkFields.add(hot_spot_id+"%");
	chkFields.add(hot_spot_desc+"%");
	chkFields.add(image_link+"%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th class='columnheader' width='15%'align="left"><fmt:message key="eOR.ImageId.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width='27%'align="left"><fmt:message key="eOR.ImageDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width='15%'align="left"><fmt:message key="eOR.HotspotId.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width='28%'align="left"><fmt:message key="eOR.HotspotDesc.label" bundle="${or_labels}"/></th>
		<th class='columnheader' width='15%'align="left"><fmt:message key="eOR.ImageLinkId.label" bundle="${or_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();

		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr onClick="Modify(this);" >
		<%
		String link_columns = "1";// disp ="";
		records=(ArrayList) result.get( recCount );

		  for(int colCount=0; colCount<records.size(); colCount++){
			String str = (String)records.get(colCount);
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><a class='gridLink' href='#'><%=(String)records.get(colCount)%> </a></td>
			<%}else{
			%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			<%
			}
		 }
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"ImageHotSpotLinkQueryResults.jsp", searched));
	}
	catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
	</body>
	</html>
<!--
select a.image_id image_id, b.image_name image_name, a.hotspot_id hotspot_id, c.hotspot_name hotspot_name, a.image_link_id image_link_id from or_image_hotspot_link a, or_image b, or_image_hotspot c where a.image_id = (?) and a.image_id = b.image_id and b.image_name = (?) and a.hotspot_id =(?) and a.hotspot_id = c.hotspot_id and c.hotspot_name = (?) and a.image_link_id = (?)

-->

