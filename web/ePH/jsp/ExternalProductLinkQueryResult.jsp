<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>

<head>
		<title></title>
		<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
				<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body>
 -->
 <body onMouseDown="" onKeyDown="lockKey()"> 
<%
	//Search Criteria's from Query Criteria page
	String Generic_Name	= request.getParameter( "GenericName" );
	String Drug_Code		= request.getParameter( "DrugCode" ) ;
	String Drug_Desc		= request.getParameter( "DrugName" ) ;

	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched			= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";

	Generic_Name = CommonBean.checkForNull( Generic_Name );
	Drug_Code = CommonBean.checkForNull( Drug_Code );
	Drug_Desc = CommonBean.checkForNull( Drug_Desc );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_EXT_PROD_LINK_QUERY"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields that are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add( "GENERIC_NAME" );
	displayFields.add( "DRUG_CODE" );
	displayFields.add( "DRUG_DESC" );
	displayFields.add( "EXDESC" );


	ArrayList chkFields = new ArrayList();
	chkFields.add( Drug_Code.trim() + "%" );
	chkFields.add( Drug_Desc.trim() + "%" );
	chkFields.add( Generic_Name.trim() + "%" );

	
	
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
		<th  style="width:25%"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th><th style="width:20%"><fmt:message key="Common.DrugCode.label" bundle="${common_labels}"/></th>
		<th style="width:25%"><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></th>	<th style="width:30%"><fmt:message key="ePH.ExternalProduct.label" bundle="${ph_labels}"/></th>	
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr  >
	<%

			records=(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
			
				String dkVal = (String)records.get( colCount );

					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
					out.println("<td align=\"left\" class=\""+classvalue+"\">");
					out.println(dkVal);
					out.println("</td>");
				}
	%>
			</tr>
	<%
		}//end of records
	%>
		</table>
	<%
		out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/ExternalProductLinkQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

