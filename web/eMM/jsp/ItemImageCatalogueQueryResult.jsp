<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.Common.*, eMM.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
 
<html>
	<head>
		<title></title> 
		<%

		request.setCharacterEncoding("UTF-8");
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
		<script language="Javascript" src="../../eMM/js/ItemImageCatalogue.js"> </script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	//Search Criteria's from Query Criteria page
	
	 String item_code	= ((request.getParameter("item_code") == null) || (request.getParameter("item_code").trim() == ""))  ? "%" : (request.getParameter("item_code").trim())+"%";		
     String file_name	= ((request.getParameter("file_name") == null) || (request.getParameter("file_name").trim() == ""))  ? "%" : (request.getParameter("file_name").trim())+"%";
	 String short_desc	= ((request.getParameter("short_desc") == null) || (request.getParameter("short_desc").trim() == ""))  ? "%" : (request.getParameter("short_desc").trim())+"%";
	
	 boolean searched	=(request.getParameter("searched") == null) ?false:true;
	
try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();

	sqlMap.put( "sqlData", MmRepository.getMmKeyValue( "SQL_MM_ITEM_IMAGE_CATLG_QUERYCRIT"));

	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "ITEM_CODE" );
	displayFields.add( "SHORT_DESC"	);
	displayFields.add( "SRL_NO" );
	displayFields.add( "FILE_NAME" );
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add( item_code);
	chkFields.add( short_desc);
	chkFields.add( CommonBean.getLoginFacilityId());
	chkFields.add( file_name);
	

	
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	System.out.println("result"+result);
	//out.println((String) result.get(0));
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align=center>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center >
		<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th></th>
		<th ><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="eMM.ImageCatalogueFileName.label" bundle="${mm_labels}"/></th>
		
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
			records=(ArrayList) result.get( recCount );
	%>
			
		<tr onClick="Modify(this);" >
		<td class="<%=classvalue%>" onmouseover="changeCursor(this);" align="left" ><font class='HYPERLINK'>  <%=(String)records.get( 0 )%></font></td>
		
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( 1 )%></td>
		<td class="NODISPLAY"><%=(String)records.get( 2 )%></td>
		<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( 3 )%></td>
	</td>
	
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
	out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ItemImageCatalogueQueryResult.jsp", searched) );
} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

