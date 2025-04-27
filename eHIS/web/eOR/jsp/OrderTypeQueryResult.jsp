<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eOR.*,eOR.Common.*, java.util.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<script>

function Modify(obj){

   	var order_type_code		= obj.innerText;	document.location.href="../../eOR/jsp/OrderTypeAddModify.jsp?mode=2&order_type_code="+order_type_code+"&function_id="+parent.function_id; 
			
}

</script>

<html>
	<head>
		<title></title>
	

		<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language='Javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	
	</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String sqlQuery		= OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_QUERY_RESULT_SELECT");

	String enabledGif	= "<img src='../../eCommon/images/enabled.gif' align=center></img>";
	String disabledGif	= "<img src='../../eCommon/images/disabled.gif' align=center></img>";

	// Parameters passed 
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String order_type_code	= CommonBean.checkForNull(request.getParameter("order_type_code"));
	String long_desc		= CommonBean.checkForNull(request.getParameter("long_desc"));

        if(long_desc.startsWith("\'"))
		{
           long_desc = long_desc.substring(1,long_desc.length());
		}

	String order_category	= CommonBean.checkForNull(request.getParameter("order_category"));
	String regn_reqd_yn		= CommonBean.checkForNull(request.getParameter("regn_reqd_yn"));
	String freq_applicable_yn= CommonBean.checkForNull(request.getParameter("freq_applicable_yn"));
	String soft_stop_yn		= CommonBean.checkForNull(request.getParameter("soft_stop_yn"));
	String cont_order_yn	= CommonBean.checkForNull(request.getParameter("cont_order_yn"));

	String eff_status		= CommonBean.checkForNull(request.getParameter("eff_status"));
	//String ord[]			= request.getParameterValues("orderbycolumns");
	ArrayList records=null;
	String str ="";
	boolean searched		= request.getParameter( "searched" ) == null?false : true  ;
try
	 {
		String classvalue		= "";

		//Common parameters.
		HashMap sqlMap = new HashMap();
			//include all the common parameters.
			sqlMap.put( "sqlData",sqlQuery);
		//Function Parameters
		HashMap funcMap = new HashMap();

			//Display Fields
			ArrayList displayFields = new ArrayList();

				displayFields.add( "order_type_code" );
				displayFields.add( "long_desc" );
				displayFields.add( "short_desc" );
				displayFields.add( "order_category_desc" );
				displayFields.add( "regn_reqd_yn" );
				displayFields.add( "freq_applicable_yn" );
				displayFields.add( "soft_stop_yn" );
				displayFields.add( "cont_order_yn" );
				displayFields.add( "eff_status" );


			//Where condition put in order
			ArrayList chkFields = new ArrayList();
				chkFields.add( order_type_code +"%" );
				chkFields.add( long_desc +"%" );
				chkFields.add( order_category +"%" );
				chkFields.add( regn_reqd_yn +"%" );
				chkFields.add( freq_applicable_yn +"%" );
				chkFields.add( soft_stop_yn +"%" );
				chkFields.add( cont_order_yn  +"%");
				chkFields.add( eff_status +"%" );
			//	out.println("####chkFields="+chkFields);
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adapter as an arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class="label"></td>
		<td class="label">
	<%
		// To display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table class='grid' width="100%">
		<tr>
			<td class=" COLUMNHEADER" width='15%'><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='33%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='17%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='10%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='5%'><fmt:message key="eOR.AutoRegistrationReqd.label" bundle="${or_labels}"/></td>
			<td class=" COLUMNHEADER" width='5%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='5%'><fmt:message key="Common.SoftStop.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='5%'><fmt:message key="Common.Continuous.label" bundle="${common_labels}"/></td>
			<td class=" COLUMNHEADER" width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		</tr>
<%
		//Retrieving the records from result arraylist
		records=new ArrayList();

		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
		<tr >
<%
		  String link_columns = "1";
		  records=(ArrayList) result.get( recCount );
		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			   <td class="<%=classvalue%>" onClick="Modify(this);"  onmouseover="changeCursor(this);">
				 <a class='gridLink' href='#'><%=(String)records.get(colCount)%> </a>
			   </td>
	<%		
			} else {
				str = (String)records.get(colCount);
				if(colCount == 1 || colCount == 2 || colCount == 3 )
				{
	%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=str%>
				</td>
	<%			 } else {
				 if(colCount == 4 || colCount == 5 || colCount == 6 || colCount ==7)//to display Yes/ No (Enabled / Disabled)
					str=eHISFormatter.chkReturn("Y",str,enabledGif,disabledGif);
				  else if(colCount == 8)//to display Yes/ No (Enabled / Disabled)
					str=eHISFormatter.chkReturn("E",str,enabledGif,disabledGif);
	%>
    		<td class="<%=classvalue%>"  onclick="disableClick(event);" >
				<%=str%>
			</td>
			<% } }
		 }%>
		</tr>
		<% } %>
	</table>
	<%
		out.flush();
		} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
		}
	result=null;
		out.println(CommonBean.setForm(request ,"../../eOR/jsp/OrderTypeQueryResult.jsp", searched) );
     } catch(Exception e) {
	     //out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
	     e.printStackTrace();//COMMON-ICN-0181
  }
%>
  </body>
  	
</html>

