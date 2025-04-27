<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.* "%> 
<%-- JSP Page specific attributes end --%>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%> <!--IN072524-->
<%-- Mandatory declarations end --%>
  
<script>
	function Modify(obj){
	var tick_sheet_id		=obj.cells[0].innerText;
	var order_category_desc	=obj.cells[4].innerText;
	var order_category      =obj.cells[3].children[0].value;

	document.location.href="../../eOR/jsp/TickSheetsAddModify.jsp?mode=2&tick_sheet_id="+tick_sheet_id+"&order_category="+order_category+"&order_category_desc="+order_category_desc+"&function_id="+parent.function_id;
}
</script>


<html>
	<head>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language="JavaScript" src="../js/OrMessages.js"></script>-->
		<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	</head>

 <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%

	//String bean_id				= "tSheet1" ;
	//String bean_name			= "eOR.Tick_Sheets1";
	
    /* Required while Selecting sql and Formatting display*/
	String enableGif ="<img src='../../eCommon/images/enabled.gif' align=center></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif' align=center></img>" ;



	//Search Criteria's from Query Criteria page
	String order_category				= CommonBean.checkForNull(request.getParameter("order_category"));
    String tick_sheet_id				=
	CommonBean.checkForNull(request.getParameter("tick_sheet_id"));
	String tick_sheet_desc				= CommonBean.checkForNull(request.getParameter("tick_sheet_desc"));
	String index_yn					=
	CommonBean.checkForNull(request.getParameter("index_yn"));
	String eff_status						=
	CommonBean.checkForNull(request.getParameter("eff_status"));
	//IN072524 Starts
	String fpp_yn						=
			CommonBean.checkForNull(request.getParameter("fpp_yn"));
	if("on".equals(fpp_yn))
		fpp_yn = "Y";
	//IN072524 Ends


	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter("searched") == null?
	false : true  ;
	//IN072524 Starts
	//String sql = OrRepository.getOrKeyValue("SQL_OR_TICK_QUERYCRITERIA");
	String sql = "SELECT A.ORDER_CATEGORY, TICK_SHEET_ID, TICK_SHEET_DESC, SEQ_NO, INDEXED_YN,EFF_STATUS,B.SHORT_DESC ORDER_CATEGORY_DESC,a.fpp_yn FROM OR_TICK_SHEET A,OR_ORDER_CATEGORY B WHERE UPPER(A.ORDER_CATEGORY) LIKE UPPER(?) AND   UPPER(TICK_SHEET_ID) LIKE UPPER(?) AND UPPER(TICK_SHEET_DESC) LIKE UPPER(?) AND UPPER(INDEXED_YN) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?) ##FPP_APPLICABLEYN## AND A.ORDER_CATEGORY =B.ORDER_CATEGORY  union SELECT '*A' ORDER_CATEGORY, TICK_SHEET_ID, TICK_SHEET_DESC,SEQ_NO, INDEXED_YN,EFF_STATUS,'Non Specific'  ORDER_CATEGORY_DESC,a.fpp_yn FROM OR_TICK_SHEET A WHERE  UPPER(TICK_SHEET_ID) LIKE UPPER(?) AND UPPER(TICK_SHEET_DESC) LIKE UPPER(?) AND UPPER(INDEXED_YN) LIKE UPPER(?) AND UPPER(EFF_STATUS) LIKE UPPER(?) ##FPP_APPLICABLEYN## AND ORDER_CATEGORY ='*A' and ordER_category = decode((?),'*A','*A',(?))";
	if("Y".equals(fpp_yn)){
		sql=sql.replace("##FPP_APPLICABLEYN##"," AND a.FPP_YN='Y' ");
	}
	else{
		sql=sql.replace("##FPP_APPLICABLEYN##"," AND (a.FPP_YN IS NULL OR a.FPP_YN='N') ");
	}
	//IN072524 Ends

try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql);


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add("TICK_SHEET_ID");
	displayFields.add("TICK_SHEET_DESC");
	displayFields.add("SEQ_NO");
	displayFields.add("ORDER_CATEGORY");
	displayFields.add("ORDER_CATEGORY_DESC");
	displayFields.add("INDEXED_YN");
	if("Y".equals(fpp_yn))
		displayFields.add("FPP_YN");//IN072524
	displayFields.add("EFF_STATUS");

//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_category.trim() +"%");
	chkFields.add( tick_sheet_id +"%");
	chkFields.add( tick_sheet_desc +"%");
	chkFields.add( index_yn+"%" );
	chkFields.add( eff_status+"%");
	chkFields.add( tick_sheet_id +"%");
	chkFields.add( tick_sheet_desc+"%");
	chkFields.add( index_yn+"%");
	chkFields.add( eff_status+"%");
	if(order_category.trim().equals(""))	order_category = "*A";
	if(order_category.trim().equals("*A")){
		chkFields.add( order_category.trim());
		chkFields.add( order_category.trim() );
	}else{
		chkFields.add( order_category.trim()+"%" );
		chkFields.add( order_category.trim()+"%" );
	}

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table class='grid' width="100%">
		<th class='columnheader' style="text-align: left;"><fmt:message key="eOR.TickSheetID.label" bundle="${or_labels}"/></th>
			<th class='columnheader'style="text-align: left;"><fmt:message key="eOR.TickSheetDescription.label" bundle="${or_labels}"/></th>
			<th class='columnheader' style="text-align: left;"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
			<th class='columnheade' style="text-align: left;"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
			<th class='columnheader'style="text-align: left;"><fmt:message key="eOR.Index.label" bundle="${or_labels}"/></th>
			<!--  //IN072524 STARTS-->
			<%if("Y".equals(fpp_yn)){%>
			<th class='columnheader' style="text-align: left;"><fmt:message key="eOR.FPPPATIENT.label" bundle="${or_labels}"/></th>
			<%}%>
			<!--  //IN072524 ENDS-->
			<th class='columnheader'style="text-align: left;" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

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

		  String link_columns = "1";

		  records=(ArrayList) result.get( recCount );
		  String str="";

		  for(int colCount=0; colCount<records.size(); colCount++){

			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<a class='gridLink' href='#'><%=(String)records.get(colCount)%></a></td>
			<%}else{
				if(colCount==3){%>
					<td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none">
					<INPUT TYPE="hidden" value=<%=(String)records.get( colCount)%>>
					</td>
				<%
					continue ;
				}
					str = (String)records.get(colCount);
					if(colCount==2){
						if( str == null ){ %>
							<td class="<%=classvalue%>" onclick="disableClick(event);"> </td>
				<%
							continue;
						}
					}
					if(colCount == 5 )//to display Nurse Colllect
						str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);
					if(colCount == 6 )//to display Nurse Colllect
						str=eHISFormatter.chkReturn("E",str,enableGif,disableGif);
					if(colCount == 7 )//IN072524 Starts
						str=eHISFormatter.chkReturn("Y",str,enableGif,disableGif);					
					//IN072524 Ends
				%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			  <%}//with out hyper link
		 }//loop for all tds%>

		</tr>
		<%}//L00p for all records%>
	</table>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/TickSheetQueryResult.jsp", searched));
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

