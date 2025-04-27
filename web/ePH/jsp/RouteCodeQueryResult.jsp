<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<!-- 
	This sample function explains how to develop the Query Result Page for Type 2.
-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
          request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	     String locale			= (String)session.getAttribute("LOCALE");
	     String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/RouteCode.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//Search Criteria's from Query Criteria page
/////////////////////////////////////////////////////////////////
String route_code	= request.getParameter( "route_code" ) ;
String route_desc		= request.getParameter( "route_desc" ) ;
String route_color		= request.getParameter( "route_color" ) ; //Code Added for CR 0034
String route_local		= request.getParameter( "route_local" ) ;
String eff_status     	= request.getParameter( "eff_status" ) ;
String ext_route_code =request.getParameter( "ext_route_code" ) ;
String ext_route_desc =request.getParameter( "ext_route_desc" ) ;

//String ord[]				= request.getParameterValues("orderbycolumns");
boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;


String exProductLink="N";

try{
	String classvalue			= "";
	
	route_code = CommonBean.checkForNull( route_code );
	route_desc = CommonBean.checkForNull( route_desc );
	route_color = CommonBean.checkForNull( route_color ); //Code Added for CR 0034
	route_local	 = CommonBean.checkForNull( route_local );
	eff_status = CommonBean.checkForNull( eff_status );
	ext_route_code = CommonBean.checkForNull( ext_route_code );
	ext_route_desc = CommonBean.checkForNull( ext_route_desc );
	eff_status = (eff_status.equals("B") ? (""):(eff_status )   )  ;
	
	//Common parameters.
	HashMap sqlMap = new HashMap();
	
//sqlMap.put( "sqlData", "SELECT A.ROUTE_CODE route_code, A.ROUTE_DESC route_desc,A.ROUTE_DESC_LOCAL_LANG route_local, A.EFF_STATUS eff_status,		A.EXT_ROUTE_DESC ext_route_desc FROM PH_ROUTE A  WHERE A.ROUTE_CODE LIKE UPPER(?)  AND UPPER(A.ROUTE_DESC)  LIKE UPPER(?)AND UPPER(A.ROUTE_DESC_LOCAL_LANG) LIKE UPPER(?) AND A.EFF_STATUS LIKE UPPER(?)  AND  NVL(A.EXT_ROUTE_CODE,'%') LIKE (?) AND NVL(UPPER(EXT_ROUTE_DESC),'%') LIKE UPPER(?) ");

//sqlMap.put( "sqlData", "SELECT ROUTE_CODE route_code , ROUTE_DESC route_desc ,ROUTE_DESC_LOCAL_LANG route_local, EFF_STATUS eff_status, EXT_ROUTE_DESC ext_route_desc FROM PH_ROUTE WHERE ROUTE_CODE LIKE UPPER(?)  AND UPPER(ROUTE_DESC)  LIKE UPPER(?) AND NVL(UPPER(ROUTE_DESC_LOCAL_LANG),?) LIKE UPPER(?) AND EFF_STATUS LIKE UPPER(?) AND NVL(EXT_ROUTE_CODE,?) LIKE (?) AND NVL(UPPER(EXT_ROUTE_DESC),?) LIKE UPPER(?)");

	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ROUTE_SELECT1"));
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	
	displayFields.add( "route_code" );
	displayFields.add( "route_desc" );
	displayFields.add( "route_color" ); //Code Added for CR 0034
	//displayFields.add( "route_local" );
	if (exProductLink.equals("Y"))
	{
		displayFields.add( "ext_route_desc" );
	}
	displayFields.add( "eff_status" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	
	chkFields.add( route_code.trim() + "%"  );
	chkFields.add( route_desc.trim() + "%"  );
	chkFields.add( route_local.trim() + "%"  );
	chkFields.add( route_local.trim() + "%"  );
	chkFields.add( eff_status.trim() + "%"  );
	chkFields.add( ext_route_code.trim() + "%"  );
	chkFields.add( ext_route_code.trim() + "%"  );
	chkFields.add( ext_route_desc.trim() + "%"  );
	chkFields.add( ext_route_desc.trim() + "%"  );
	chkFields.add(locale);


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);
//	ArrayList result=(ArrayList)bean.getQueryResultPage(sqlMap, funcMap, request);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
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
		<th style="width:15%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th style="width:30%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
	    <th style="width:10%"><fmt:message key="ePH.routecolor.label" bundle="${ph_labels}"/></th>  <!-- Code Added For CRF -0034  -->
		<th style="width:30%;display:none"  ><fmt:message key="Common.LocalLanguageDescription.label" bundle="${common_labels}"/></th>
	<%if (exProductLink.equals("Y"))
		{%>
		<th style="width:25%"><fmt:message key="ePH.ExternalProductRoute.label" bundle="${ph_labels}"/></th>
			<%}%>

		<th style="width:10%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				
		
		<%
		//Retriving the records from result arraylist
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
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
	<%
				}else{
					
				
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  value="<%=(String)records.get( colCount )%>"
					
	<%	
				String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					
					if  (exProductLink.equals("Y"))
				{
						if((colCount==2)){
							out.println("align=\"center\">");  
							out.println(getImage(dkVal)); 
							out.println("</td>"); 
						}//if
						else
						{
							out.println("align=\"left\">"); 	
							out.println(dkVal);
							out.println("</td>"); 
						}
						dkVal = "";	
						// Code Added For CRF - 0034 Start
				}else if((colCount==2)){
					dkVal= (String)records.get( colCount );
					String dkVal1= (String)records.get( colCount-1 );
					String fontColor ="#OOOOOO";
					String backgroundColor ="#FFFFFF";
					if(dkVal != "" && dkVal != null){
						if(dkVal.length()==12){
							fontColor =dkVal.substring(0, 6);
							backgroundColor= dkVal.substring(6, 12);
						}
					}
					out.println("align=\"center\" style=color="+fontColor+" style=background-color="+backgroundColor+">");  
					out.println(dkVal1); 
					out.println("</td>"); 
    		    	dkVal="";
	       	    	dkVal1="";
					fontColor="";
					backgroundColor="";

				}else 				 // Code Added For CRF - 0034 End
				{

						if((colCount==2)){
							out.println("align=\"center\">");  
							out.println(getImage(dkVal)); 
							out.println("</td>"); 
						}//if
						else
						{
							out.println("align=\"left\">"); 	
							out.println(dkVal);
							out.println("</td>"); 
						}
						dkVal = "";	
						}

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
 <script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script> 
	<%
	}
%>
	</form>
<%
	//it is important to close the form above cause we are opening another form here
out.println(CommonBean.setForm ( request ,"../../ePH/jsp/RouteCodeQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

<%!
public String getImage(String value){
	if(value.equalsIgnoreCase("E"))
		return "<img src=\"../../eCommon/images/enabled.gif\">";
	else 
		return "<img src=\"../../eCommon/images/disabled.gif\">";
		

}
%>

</body>
</html>




