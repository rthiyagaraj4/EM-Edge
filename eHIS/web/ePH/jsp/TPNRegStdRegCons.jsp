<!DOCTYPE html>
 <%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@page import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>

<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	//Search Criteria's from Query Criteria page
	String Reg_Code		= request.getParameter( "RegimenCode" ) ;


	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
	String oldgroup		="";	

try{

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_TPN_STD_REGIMEN_SELECT17"));
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "CONST_GROUP_NAME" );
	displayFields.add( "CONST_GENERIC_NAME" );
	displayFields.add( "CONST_CONCENTRATION_PERC" );
	displayFields.add( "CONST_VOLUME" );
	displayFields.add( "CONST_VOLUME_UNIT" );
	displayFields.add( "CONST_WEIGHT" );
	displayFields.add( "CONST_WEIGHT_UNIT" );


	ArrayList chkFields = new ArrayList();
	chkFields.add( Reg_Code.trim() );
	chkFields.add( locale);

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
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
		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th  style="width:30%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
		<th style="width:10%"><fmt:message key="ePH.ConcentrationPercentage.label" bundle="${ph_labels}"/></th>
		<th style="width:20%" colspan=2><fmt:message key="Common.volume.label" bundle="${common_labels}"/></th>	
		<th style="width:20%" colspan=2><fmt:message key="Common.weight.label" bundle="${common_labels}"/></th>	
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String classvalue;
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYODD" ;
			else
				classvalue = "QRYEVEN" ;
	%>
			<tr >
	<%
			records=(ArrayList) result.get( recCount );
	
			for(int colCount=0; colCount<records.size(); colCount++){
				if (colCount==0)
				{
					String str=(String)records.get(colCount);
					
					if (!str.equals(oldgroup))
					{
						%>
							<tr>
						<th colspan=6><%=str%></th>
							</tr>
							<%
							
					}
					oldgroup=str;
					continue;
				}

				if ((colCount==1)||(colCount==4)||(colCount==6))
				{
					%>
								<td class="<%=classvalue%>" style="font-size:8pt">
				<%}
				else if ((colCount==3)||(colCount==5))
				{%>
									<td class="<%=classvalue%>" width="10%" style="font-size:8pt">
				<%
				}
				else
				{
				%>
									<td class="<%=classvalue%>" style="font-size:8pt">
				<%
				}
				%>


				<%
					String dkVal = (String)records.get( colCount );
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
	
					//this check is to stop the uom displays if there are no values for the qty column
					if ( colCount==4 || colCount==6 )
					{
						String tmp=(String)records.get(colCount-1);
						if (tmp==null || tmp.equals("")) 
							out.println("&nbsp;");
						else
							out.println("&nbsp;"+dkVal);
					}
					else
					{
						out.println("&nbsp;"+dkVal);
					}
					out.println("</td>");
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
		out.println("No Constituents for this Standard Regimen!!!!");
	%>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/TPNRegStdRegCons.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>

</body>
</html>

