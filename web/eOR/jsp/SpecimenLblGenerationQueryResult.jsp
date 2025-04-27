<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*,eCommon.XSSRequestWrapper "%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<script>
	function Modify(obj){

	var ordering_facility_id=obj.cells[0].innerText;
	var facility_name		=obj.cells[1].innerText;


	var source_type			="";
	var source_type_desc	=obj.cells[2].innerText;

	var source_code			=obj.cells[3].innerText;
	var source_desc			=obj.cells[4].innerText;
	//var source_desc		=obj.cells[4].children(0).value;

	var specimen_type		=obj.cells[5].innerText;


	if(source_type_desc == "Department"){
		source_type ='D'	;
	}else if(source_type_desc == "Nursing Unit"){
		source_type ='N'	;
	}else if(source_type_desc == "Clinic"){
		source_type ='C'	;
	}else if(source_type_desc == "Referral"){
		source_type ='R'	;
	}

//	alert("../../eOR/jsp/SpecimenLblGenerationAddModify.jsp?mode=2&source_type="+source_type+"&source_code="+source_code+"&source_type_desc="+source_type_desc+"&source_desc="+source_desc+"&ordering_facility_id="+ ordering_facility_id+"&specimen_type="+specimen_type+"&facility_name="+facility_name+"&function_id="+parent.function_id);

	document.location.href="../../eOR/jsp/SpecimenLblGenerationAddModify.jsp?mode=2&source_type="+source_type+"&source_code="+source_code+"&source_type_desc="+source_type_desc+"&source_desc="+source_desc+"&ordering_facility_id="+ ordering_facility_id+"&specimen_type="+specimen_type+"&facility_name="+facility_name+"&function_id="+parent.function_id;
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
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		
		<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	</head>
 
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	

    /* Required while Selecting sql and Formatting display*/
	String enableGif ="<img src='../../eCommon/images/enabled.gif' align=center></img>" ;
	String disableGif ="<img src='../../eCommon/images/RRnwd.gif' align=center></img>" ;
	String valSource[]  ={"C","D","N","R"} ;
	String descsource[]={"Clinic","Department","Nursing Unit","Referral"} ;


	String valUrgency[]  ={"R","U","S"} ;
	String descUrgency[] ={"Routine","Urgent","Stat"} ;


	//Search Criteria's from Query Criteria page
	String ordering_facility_id	= CommonBean.checkForNull(request.getParameter("ordering_facility_id"));
	String facility_name		= CommonBean.checkForNull(request.getParameter("facility_name"));
	String source_type			= CommonBean.checkForNull(request.getParameter("source_type"));
	String source_code			= CommonBean.checkForNull(request.getParameter("source_code"));
	String specimen_type 		= CommonBean.checkForNull(request.getParameter("specimen_type"));
	String urgency_indicator	= CommonBean.checkForNull(request.getParameter("urgency_indicator"));
	String nurse_collect_yn=
	CommonBean.checkForNull(request.getParameter("nurse_collect_yn"));

	//String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter( "searched" ) == null?
	false : true  ;



	 String sql = OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_LBL_GENERATION_QUERYCRITERIA_VW_T");



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

	displayFields.add( "ORDERING_FACILITY_ID" );
	displayFields.add( "FACILITY_NAME" );
	displayFields.add( "SOURCE_TYPE" );
	displayFields.add( "SOURCE_CODE" );
	displayFields.add( "SOURCE_DESC" );
	displayFields.add( "SPECIMEN_TYPE" );
	displayFields.add( "URGENCY_INDICATOR" );
	displayFields.add( "NURSE_COLLECT_YN" );
	displayFields.add( "LOOK_AHEAD_MIN" );


	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( ordering_facility_id+"%");
	chkFields.add( source_type+"%");
	chkFields.add( source_code+"%");
	chkFields.add( urgency_indicator +"%");
	chkFields.add( nurse_collect_yn+"%");
	chkFields.add( facility_name+"%");
	chkFields.add( specimen_type+"%");

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

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
		<td class=columnheader width='8%'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></td>
			<td class=columnheader width='20%'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="Common.SourceType.label" bundle="${common_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="eOR.SourceCode.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='12%'><fmt:message key="eOR.SourceDesc.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='15%'><fmt:message key="Common.SpecimenType.label" bundle="${common_labels}"/></td>
			<td class=columnheader width='5%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="eOR.NurseCollect.label" bundle="${or_labels}"/></td>
			<td class=columnheader width='10%'><fmt:message key="eOR.LookAheadMin.label" bundle="${or_labels}"/></td>

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

		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	 <a class='gridLink' href='#'><%=(String)records.get(colCount)%></a></td>
			<%}else{

			String str = (String)records.get(colCount);
			String align="";

			if(colCount == 4){%>
			<!-- <td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none"><INPUT TYPE="hidden" value=<%=str%>>
			</td> -->
			<td class="<%=classvalue%>" <%=align%> onclick="disableClick(event);">
			<%=str%></td>
			<%continue;
			}
			if(colCount ==2)//to display Source type
   			str=eHISFormatter.chkReturn(valSource,str,descsource,"&nbsp;");
			if(colCount ==6)//to display Urgency type
   			str=eHISFormatter.chkReturn(valUrgency,str,descUrgency,"ALL");
			if(colCount ==7)//to display Nurse Colllect
			{
				if(str.equals("Y") )
					str = enableGif;
				else if(str.equals("*") )
					str = "ALL";
				else
					str = disableGif;

				align = "align='center'";
			}
			if(colCount == 8)//to display blank when min generation is zero
   			str=eHISFormatter.chkReturn("0",str,"&nbsp;",str);


			%>

			<td class="<%=classvalue%>" <%=align%> onclick="disableClick(event);">
			<%=str%></td>
			<%}
		 }%>

		</tr>
		<%}%>
	</table>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/SpecimenLblGenerationQueryResult.jsp", searched));
} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
%>
</body>
</html>

