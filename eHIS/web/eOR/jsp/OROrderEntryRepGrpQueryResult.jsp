<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %> 
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<script>

function Modify(obj){

   	var cust_rep_grp_code		= obj.innerText;	document.location.href="../../eOR/jsp/OROrderEntryRepGrpAddModify.jsp?mode=2&cust_rep_grp_code="+cust_rep_grp_code+"&function_id="+parent.function_id; 
			
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
	<style>
    /* Ensure table layout is fixed to avoid issues during zoom */
    table.grid {
        width: 100%;
        table-layout: fixed; /* Fixes column widths and table rendering */
        border-collapse: separate; /* Ensures table borders are not collapsed */
        border-spacing: 0; /* Ensures borders don't overlap */
        box-sizing: border-box; /* Include padding/borders in width calculation */
    }

</style>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String sqlQuery		= "select cust_rep_grp_code, cust_rep_grp_desc, or_get_desc.or_order_category(order_category,?,'2') order_category, CUST_REPORT_DESC cust_report_id, a.report_type_id,appl_ord_type,eff_status from or_cust_rep_grp_hdr a,OR_CUSTOM_REPORTS b  where a.cust_report_id=b.cust_report_id and upper(cust_rep_grp_code ) like upper(?) and upper(cust_rep_grp_desc) like upper(?) and upper(order_category) like upper(?) and upper(a.cust_report_id) like upper(?) and upper(a.report_type_id) like upper(?) and  upper(eff_status) like upper(?)";

	String enabledGif	= "<img src='../../eCommon/images/enabled.gif' align=center></img>";
	String disabledGif	= "<img src='../../eCommon/images/disabled.gif' align=center></img>";

	// Parameters passed 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	Properties	p	=	(java.util.Properties) session.getValue("jdbc");
	String locale = (String) p.getProperty("LOCALE");
	

	String cust_rep_grp_code	= CommonBean.checkForNull(request.getParameter("cust_rep_grp_code"));
	String cust_rep_grp_desc		= CommonBean.checkForNull(request.getParameter("cust_rep_grp_desc"));

        if(cust_rep_grp_desc.startsWith("\'"))
		{
           cust_rep_grp_desc = cust_rep_grp_desc.substring(1,cust_rep_grp_desc.length());
		}

	String order_category	= CommonBean.checkForNull(request.getParameter("order_category"));
	String cust_report_id		= CommonBean.checkForNull(request.getParameter("cust_report_id"));
	String report_type_id= CommonBean.checkForNull(request.getParameter("report_type_id"));	
	//String appl_ord_type= CommonBean.checkForNull(request.getParameter("appl_ord_type"));	
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
                displayFields.add( "cust_rep_grp_code" );
				displayFields.add( "cust_rep_grp_desc" );
				displayFields.add( "order_category" );
				displayFields.add( "cust_report_id" );
				displayFields.add( "report_type_id" );
				displayFields.add( "appl_ord_type" );				
				displayFields.add( "eff_status" );
            //Where condition put in order
			ArrayList chkFields = new ArrayList();
				chkFields.add( locale);
				chkFields.add( cust_rep_grp_code +"%" );
				chkFields.add( cust_rep_grp_desc +"%" );
				chkFields.add( order_category +"%" );
				chkFields.add( cust_report_id +"%" );
				chkFields.add( report_type_id +"%" );
				chkFields.add( eff_status +"%" );				
			//	out.println("####chkFields="+chkFields);
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
        //Calling the Result from Common Adapter as an arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
		if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center" >
		<tr>
		<td class="label"></td>
		<td class="label">
	<%
		// To display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>
		<table width="100%" class="grid" style="border-top: 1.5px solid #333; border-right: 1.5px solid #333; border-bottom: 1.5px solid #333; border-left: 1.5px solid #333;">
		<tr>
			<th class='columnheader'  align ="left" width='15%'><fmt:message key="eOR.GroupingCode.label" bundle="${or_labels}"/></th>
			<th class='columnheader' align ="left" width='15%'><fmt:message key="eOR.GroupingDescription.label" bundle="${or_labels}"/></th>			
			<th class='columnheader' align ="left" width='10%'><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></th>
			<th class='columnheader' align ="left"width='5%'><fmt:message key="eOR.PrintReportFormat.label" bundle="${or_labels}"/></th>
			<th class='columnheader' width='10%'align ="left"><fmt:message key="eOR.ReportType.label" bundle="${or_labels}"/></th>
			<th class='columnheader' width='5%'align ="left"><fmt:message key="eOR.ApplicableOrderType.label" bundle="${or_labels}"/></th>			
			<th class='columnheader' width='5%'align ="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
				if(colCount==4)
				{
					if(str.equalsIgnoreCase("ORD"))
					{
						str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderFormatSheet.label","or_labels");
					}
				}
				if(colCount==5)
				{
					if(str.equalsIgnoreCase("A"))
					{
						str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
					}
					else if(str.equalsIgnoreCase("S"))
					{
						str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.specific.label","common_labels");
					}
				}
				if(colCount == 1 || colCount == 2 || colCount == 3 )
				{
	%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=str%>
				</td>
	<%			 } else {
				 if(colCount ==6)//to display Yes/ No (Enabled / Disabled)
					str=eHISFormatter.chkReturn("E",str,enabledGif,disabledGif);
				/*  else if(colCount == 8)//to display Yes/ No (Enabled / Disabled)
					str=eHISFormatter.chkReturn("E",str,enabledGif,disabledGif);*/
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
		out.println(CommonBean.setForm(request ,"../../eOR/jsp/OROrderEntryRepGrpQueryResult.jsp", searched) );
     } catch(Exception e) {
	      //out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
	      e.printStackTrace();//COMMON-ICN-0181
  }
%>
  </body>
  	
</html>

