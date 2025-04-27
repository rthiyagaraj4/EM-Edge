<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eOR.Common.*,java.util.*, eOR.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
		
		String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
		<script language="Javascript" src="../../eOR/js/IndexTickSheet.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String order_set_id			= request.getParameter( "order_set_code" ) ;
	String order_set_desc		= request.getParameter( "order_set_desc" ) ;
	String index_type				= request.getParameter( "index_type" ) ;
	String source_type			= request.getParameter( "source_type" ) ;
	String source_code			= request.getParameter( "source_code" ) ;
	String short_desc				= request.getParameter( "short_desc" ) ;
	String facility_id				= request.getParameter( "facility_id" ) ;
	String facility_name			= request.getParameter( "facility_name" ) ;
	String practitioner_id			= request.getParameter( "practitioner_id" ) ;
	String practitioner_name	= request.getParameter( "practitioner_name" ) ;
	String service_code			= request.getParameter( "service_code" ) ;
	String service_name			= request.getParameter( "service_name" ) ;
	String diagnosis_code		= request.getParameter( "diagnosis_code" ) ;
	String diagnosis_desc		= request.getParameter( "diagnosis_desc" ) ;

	if(order_set_id==null || order_set_id.equals("")){order_set_id="";}
	else order_set_id = order_set_id.toUpperCase();

	if(order_set_desc==null || order_set_desc.equals("")){order_set_desc="";}
	else order_set_desc = order_set_desc;

	if(index_type==null || index_type.equals("")){index_type="";}
	else index_type = index_type.trim();

	if(source_type==null || source_type.equals("")){source_type="";}
	else source_type = source_type.trim();

	if(source_code==null || source_code.equals("")){source_code="";}
	else source_code = source_code.toUpperCase();

	if(short_desc==null || short_desc.equals("")){short_desc="";}
	else short_desc = short_desc;

	if(facility_id==null || facility_id.equals("")){facility_id="";}
	else facility_id = facility_id.toUpperCase();

	if(facility_name==null || facility_name.equals("")){facility_name="";}
	else facility_name = facility_name;

	if(practitioner_id==null || practitioner_id.equals("")){practitioner_id="";}
	else practitioner_id = practitioner_id.toUpperCase();

	if(practitioner_name==null || practitioner_name.equals("")){practitioner_name="";}
	else practitioner_name = practitioner_name;

	if(service_code==null || service_code.equals("")){service_code="";}
	else service_code = service_code.toUpperCase();

	if(service_name==null || service_name.equals("")){service_name="";}
	else service_name = service_name;

	if(diagnosis_code==null || diagnosis_code.equals("")){diagnosis_code="";}
	else diagnosis_code = diagnosis_code.toUpperCase();

	if(diagnosis_desc==null || diagnosis_desc.equals("")){diagnosis_desc="";}
	else diagnosis_desc = diagnosis_desc;

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue				= "";
	/* Initialize Function specific end */

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", OrRepository.getOrKeyValue("SQL_CARE_SET_QUERY_RESULT"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "order_set_code" );
	displayFields.add( "order_catalog_desc" );
	displayFields.add( "index_type" );
	displayFields.add( "source_type" );
	displayFields.add( "source_code" );
	displayFields.add( "location_desc" );
	displayFields.add( "facility_id" );
	displayFields.add( "facility_name" );
	displayFields.add( "practitioner_id" );
	displayFields.add( "practitioner_name" );
	displayFields.add( "service_code" );
	displayFields.add( "service_desc" );
	displayFields.add( "diagnosis_code" );
	displayFields.add( "diag_desc" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( order_set_id+"%");
	chkFields.add( order_set_desc+"%");
	chkFields.add( index_type+"%");
	chkFields.add( source_type+"%");
	chkFields.add( source_code+"%");
	chkFields.add( short_desc+"%");
	chkFields.add( facility_id+"%");
	chkFields.add( facility_name+"%");
	chkFields.add( practitioner_id+"%");
	chkFields.add( practitioner_name+"%");
	chkFields.add( service_code+"%");
	chkFields.add( service_name+"%");
	chkFields.add( diagnosis_code+"%");
	chkFields.add( diagnosis_desc+"%");

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
		<td width="5%" class="COLUMNHEADER"><fmt:message key="eOR.OrderSetCode.label" bundle="${or_labels}"/></td>
		<td width="15%" class='COLUMNHEADER'><fmt:message key="eOR.OrderSetDesc.label" bundle="${or_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.IndexType.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="eOR.SourceCode.label" bundle="${or_labels}"/></td>
		<td width="10%" class='COLUMNHEADER'><fmt:message key="eOR.SourceDesc.label" bundle="${or_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
		<td width="10%" class='COLUMNHEADER'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td width="10%" class='COLUMNHEADER'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="eOR.ServiceDesc.label" bundle="${or_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
		<td width="5%" class='COLUMNHEADER'><fmt:message key="eOR.DiagnosisDesc.label" bundle="${or_labels}"/></td>

		<%
		//Retriving the records from result arraylist

		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		%>
			<tr>
		<%
		records=(ArrayList) result.get( recCount );
		for(int colCount=0; colCount<records.size(); colCount++){
			%><td class="<%=classvalue%>"  onclick="disableClick(event);">
			<% 	out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
			}
			%>
			</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"../../eOR/jsp/IndexOrderCareSetQueryResult.jsp", searched));
		}
		catch(Exception e) {
		System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>

</body>
</html>


