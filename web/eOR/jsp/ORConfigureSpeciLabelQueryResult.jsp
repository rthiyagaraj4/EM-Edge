<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %> 
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>

<script>

function Modify(obj){

   	var config_ref_no		= obj.innerText;	document.location.href="../../eOR/jsp/ORConfigureSpeciLabelHdr.jsp?mode=2&config_ref_no="+config_ref_no+"&function_id="+parent.function_id; 
			
}

</script>

<html>
	<head>
		<title></title>
	

		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!--<link rel='StyleSheet' href='../../eCommon/html/grid.css' type='text/css' />-->
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<!--<script language='Javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	
	</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String sqlQuery		= "select config_ref_no, facility_id, ext_appl, spec_num_format from or_config_spec_frmt_hdr a  where upper(facility_id) like upper(?) and upper(a.spec_num_format) like upper(?) ";

	// Parameters passed 
	request.setCharacterEncoding("UTF-8");
	Properties	p	=	(java.util.Properties) session.getValue("jdbc");
	String locale = (String) p.getProperty("LOCALE");
	

//	String spec_frmt_type	= CommonBean.checkForNull(request.getParameter("spec_frmt_type"));
	String facility_id		= CommonBean.checkForNull(request.getParameter("facility_id"));       
//	String ext_appl	= CommonBean.checkForNull(request.getParameter("ext_appl"));
	String spec_num_format		= CommonBean.checkForNull(request.getParameter("specimen_frmt_type"));	

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
                displayFields.add( "config_ref_no" );
				//displayFields.add( "spec_frmt_type" );
				displayFields.add( "facility_id" );
			//	displayFields.add( "ext_appl" );
				displayFields.add( "spec_num_format" );				
            //Where condition put in order
			ArrayList chkFields = new ArrayList();
				//chkFields.add( locale);
			//	chkFields.add( spec_frmt_type +"%" );
				chkFields.add( facility_id +"%" );
				//chkFields.add( ext_appl +"%" );
				chkFields.add( spec_num_format +"%" );							
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
		<table class='grid' width="100%">
		<tr>
			<td class='COLUMNHEADER' width='5%' align="left"><fmt:message key="Common.SlNo.label" bundle="${common_labels}"/></td>				
			<td class='COLUMNHEADER' width='10%' align="left"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
			<!-- <td class='columnheader' width='5%'><fmt:message key="eOR.ExternalApplication.label" bundle="${or_labels}"/></td> -->
			<td class='COLUMNHEADER' width='65%' align="left"><fmt:message key="eOR.SpecimenNoFormat.label" bundle="${or_labels}"/></td>			
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
	%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=str%>
				</td>
	<%			 }
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
		out.println(CommonBean.setForm(request ,"../../eOR/jsp/ORConfigureSpeciLabelQueryResult.jsp", searched) );
     } catch(Exception e) {
	      //out.print("Exception @ Result JSP :"+e.toString());//common-icn-0181
	      e.printStackTrace();//COMMON-ICN-0181
  }
%>
  </body>
  	
</html>

