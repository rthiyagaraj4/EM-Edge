<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.Common.*, eMM.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html> 
<head>		
	<%
		
		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			=		(String)session.getAttribute("LOCALE");
//		String primary_lang		=		(String)session.getAttribute("PRIMARY_LANG");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<!--<script language="JavaScript" src="../js/MmMessages.js"></script> -->
	<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="Javascript" src="../../eMM/js/Item.js"> </script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body>
<%
	//Search Criteria's from Query Criteria page


try{
	HashMap sqlMap					=		new HashMap();
	HashMap funcMap					=		new HashMap();
	ArrayList displayFields			=		new ArrayList();
	ArrayList chkFields				=		new ArrayList();
	String classvalue				=		"";
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;

	if(request.getParameter( "from_query_or_create").equals("query")){
	String item_code				=		request.getParameter( "item_code" ) ;
	String alpha_code				=		request.getParameter( "alpha_code" ) ;
	String short_desc				=		request.getParameter( "short_desc" ) ;
	String category_type_code		=		request.getParameter( "category_type_code" ) ;
	String eff_status				=		request.getParameter( "nature" ) ;
	String curr_supp_code			=		request.getParameter( "curr_supp_code" ) ;
	String special_item				=		request.getParameter( "special_item" ) ;
	String sole_source				=		request.getParameter( "sole_source" ) ;
	String manufacturer_id			=		request.getParameter( "manufacturer_id" ) ;
//	String ord[]					=		request.getParameterValues("orderbycolumns");
//	String bean_id					=		"itemMasterBean" ;
//	String bean_name				=		"eMM.ItemMasterBean";
//	ItemMasterBean bean				=		(ItemMasterBean)mh.getBeanObject( bean_id, request, bean_name ) ;
	item_code						=		CommonBean.checkForNull( item_code )+'%' ;
	alpha_code						=		CommonBean.checkForNull( alpha_code )+'%';
	short_desc						=		CommonBean.checkForNull( short_desc )+'%';
	category_type_code				=		CommonBean.checkForNull( category_type_code );
	curr_supp_code					=		CommonBean.checkForNull( curr_supp_code )+'%';
	eff_status						=		CommonBean.checkForNull( eff_status )+'%';
	special_item					=		CommonBean.checkForNull( special_item )+'%';
	sole_source						=		CommonBean.checkForNull( sole_source )+'%';
	manufacturer_id					=		CommonBean.checkForNull( manufacturer_id )+'%';

	
	//Common parameters.
	

	//include all the common parameters.
	sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_QUERYCRIT"));
	//System.out.println("aaaaa");

	//The fields are going to be display
	

	displayFields.add( "item_code" );
	displayFields.add( "alpha_code" );	
	displayFields.add( "short_desc" );
	displayFields.add( "category_type_code" );
	displayFields.add( "eff_status" );
	
	//The fields are going to be in where condition * should match with the query
	
	chkFields.add( item_code);
	chkFields.add( alpha_code);
	chkFields.add( short_desc);
	chkFields.add( category_type_code);
	chkFields.add( eff_status);	
	chkFields.add( curr_supp_code);
	chkFields.add( special_item);
	chkFields.add( sole_source);
	chkFields.add( manufacturer_id);
	chkFields.add( locale);
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );


}
else{

	String short_desc = request.getParameter("short_desc");

	

	//include all the common parameters.
	sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_ITEM_MASTER_QUERYCRIT_CREATE"));


	
	
	//The fields are going to be display
	
	displayFields.add( "item_code" );
	displayFields.add( "alpha_code" );	
	displayFields.add( "short_desc" );
	displayFields.add( "category_type_code" );
	displayFields.add( "eff_status" );
	
	//The fields are going to be in where condition * should match with the query
	
	chkFields.add( short_desc);
	chkFields.add( short_desc+"%");
	

	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

}

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result		=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

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

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
		<th><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/> </th><th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/> </th><th><fmt:message key="eMM.CategoryType.label" bundle="${mm_labels}"/></th><th> <fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
	<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;
	%>
			<tr onClick="Modify(this);">
	<%

			String link_columns			=	"1";
			records						=	(ArrayList) result.get( recCount );
			for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
				if(request.getParameter( "from_query_or_create").equals("query")){	
	%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" >
					<font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
	<%
					}else{
	%>
						<td onclick="disableClick(event);" class="<%=classvalue%>"><%=(String)records.get( colCount )%></td>
					
	<%			}
				}else{
	%>
					
					<%
					String Inventory		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inventory.label","common_labels");
					String Non_Inventory	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.Non-Inventory.label","mm_labels");%>
					<%if(colCount == 2) {%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);" style="font-size:9pt;WORD-BREAK:BREAK-ALL;"><%=(String)records.get( 2 )%></td>
					<%continue;}%>
					<td class="<%=classvalue%>" onclick="disableClick(event);" style="text-transform: uppercase;">
						<%if(colCount == 3) {
							if( ((String)records.get( colCount )).equals("ST"))
									out.println(Inventory);
								else
									out.println(Non_Inventory);
							}
						
						else if(colCount == 4) {
								//out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}

						
						else {
							
								out.println((String)records.get( colCount ));
							}

				%></td>
	<%
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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
	<%
			if(request.getParameter( "from_query_or_create").equals("query")){
	%>
				<script>history.go(-1);</script>
	<%
			}else{
	%>
				<script>window.close();</script>
	<%}
	
	}
	out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ItemQueryResult.jsp", searched) );
} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>


