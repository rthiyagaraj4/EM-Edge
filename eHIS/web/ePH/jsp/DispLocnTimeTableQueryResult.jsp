<!DOCTYPE html>
  <!--This file is saved on 07/11/2005-->
<!--
	This sample function explains how to develop the Query Result Page for Type 2.
-->
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<%
         request.setCharacterEncoding("UTF-8");
			//Added by Himanshu for MMS-ME-SCF-0097 Starts 
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			//Added by Himanshu for MMS-ME-SCF-0097 ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../js/DispLocnTimeTable.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
//Search Criteria's from Query Criteria page
String disp_locn_code			= request.getParameter( "DISP_LOCN_CODE" ) ;
String day			= request.getParameter( "day_type" ) ;
boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;

try{
	String classvalue			= "";

	disp_locn_code			= CommonBean.checkForNull( disp_locn_code );
	day			= CommonBean.checkForNull( day );
	
	
	String bean_id	="DispLocnTimeTableBean";
    String bean_name	="ePH.DispLocnTimeTableBean";

	/* Initialize Function specific start */
	DispLocnTimeTableBean bean = (DispLocnTimeTableBean)getBeanObject( bean_id,  bean_name, request ) ;

	//Common parameters.
	HashMap sqlMap = new HashMap();
	

	//sqlMap.put( "sqlData","SELECT (SELECT long_desc from ph_disp_locn_lang_vw B WHERE a.disp_locn_code = b.disp_locn_code AND a.facility_id = b.facility_id AND b.language_id = ?) long_desc, DECODE (a.day_type,0, 'ALLDAYS', 1, 'MONDAY',2, 'TUESDAY',3, 'WEDNESDAY',4, 'THURSDAY',5, 'FRIDAY',6, 'SATURDAY',7, 'SUNDAY',8, 'WORKINGDAYS',9, 'HOLIDAYS') day_type ,TO_CHAR (a.from_time, 'hh24:mi') from_time, TO_CHAR (a.to_time, 'hh24:mi') to_time  FROM ph_disp_locn_time_table a WHERE a.disp_locn_code LIKE NVL(?,'%') AND a.day_type LIKE NVL(?,'%') ");
 
 	sqlMap.put("sqlData", PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_TIME_SELECT"));






	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add( "long_desc" );
	displayFields.add( "day_type" );
	displayFields.add( "from_time" );
	displayFields.add( "to_time" );
	
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

	chkFields.add(locale);
	chkFields.add(disp_locn_code.trim() + "%" );
	chkFields.add(day.trim() + "%" );
	

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
    //out.println("result---->"+result);

	if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<form name="queryResultForm" id="queryResultForm">
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table  border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th class= "COLUMNHEADER"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></th>
		<th class= "COLUMNHEADER"><fmt:message key="ePH.DayType.label" bundle="${ph_labels}"/></th>
		<th class= "COLUMNHEADER"><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></th>
		<th class= "COLUMNHEADER"><fmt:message key="Common.totime.label" bundle="${common_labels}"/></th>


		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr>
	<%

			String link_columns = "1";

			records=(ArrayList) result.get( recCount );
			//out.println("records---->"+records);
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" nowrap>  <%=(String)records.get( colCount )%> </td>
	<%
				}else if(colCount==1 )
						{
							String dkVal = (String)records.get( colCount );
							
							%>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%
						}
							
                 else if(colCount==2 )
						{
							String dkVal = (String)records.get( colCount );
							String dkValToTime = (String)records.get( 3 );
							//out.println("dkVal--------->"+dkVal);
							//out.println("dkValToTime--------->"+dkValToTime);
						 if((dkVal.equals("00:00"))&&(dkValToTime.equals("00:00")))
						 {
                           dkVal="";
						   %>
						  <td class="<%=classvalue%>" ><%=dkVal%></td>
						  <%
						 
						  }else if((!dkVal.equals("00:00"))&&(dkValToTime.equals("00:00")))
						  {
						  %>
						  <td class="<%=classvalue%>" ><%=dkVal%></td>
						  <%}
						   else if((dkVal.equals("00:00"))&&(!dkValToTime.equals("00:00")))
						   {
						    %>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%}else if((!dkVal.equals("00:00"))&&(!dkValToTime.equals("00:00")))
						    {
							%>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%}
						}	
										
                 else if(colCount==3 )
						{
							String dkVal = (String)records.get( colCount );
							String dkValFromTime = (String)records.get( 2 );
							if((dkVal.equals("00:00"))&&(dkValFromTime.equals("00:00")))
							{
                              dkVal="";
							 %>
						    <td class="<%=classvalue%>" ><%=dkVal%></td>
						    <%
							}else if((!dkVal.equals("00:00"))&&(dkValFromTime.equals("00:00")))
						    {
							%>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%}
							else if((dkVal.equals("00:00"))&&(!dkValFromTime.equals("00:00")))
						    {
							%>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%}else if((!dkVal.equals("00:00"))&&(!dkValFromTime.equals("00:00")))
						    {
							%>
							<td class="<%=classvalue%>" ><%=dkVal%></td>
							<%}
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
	} else{
	%>
 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
%>
	</form>
<%
	//it is important to close the form above cause we are opening another form here
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DispLocnTimeTableQueryResult.jsp", searched) );


putObjectInBean(bean_id,bean,request);

} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>


</body>
</html>

