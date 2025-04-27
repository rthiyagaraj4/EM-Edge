<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<% 
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

<html>
	<head>
		<title></title>
	
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/WsDispLocn.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String DISP_LOCN_CODE	= request.getParameter( "DISP_LOCN_CODE" ) ;
	//out.println("1 ="+DISP_LOCN_CODE);
	String DISP_LOCN_DESC	= request.getParameter( "DISP_LOCN_DESC" ) ;
	//out.println("2 ="+DISP_LOCN_DESC);
	String WS_NO	= request.getParameter( "WS_NO" ) ;
	//out.println("3 ="+WS_NO);
	//out.println(session.getValue( "facility_id" ) );
	//String st_document_desc  = request.getParameter( "st_document_desc" ) ;
	//String disp_group_desc  = request.getParameter( "disp_group_desc" ) ;
	//String action			= request.getParameter( "action" ) ;
	//if(action!=null && action.equals("B")) action="";
	String ord[]			= request.getParameterValues("orderbycolumns");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";
	if (DISP_LOCN_CODE==null)   DISP_LOCN_CODE="";
	if (DISP_LOCN_DESC==null)   DISP_LOCN_DESC="";
	if (WS_NO==null)	WS_NO="";
	//if (st_document_desc==null)  st_document_desc="";
	//if (disp_group_desc==null)	disp_group_desc="";
	//if (action==null)			action="";

	DISP_LOCN_CODE = CommonBean.checkForNull( DISP_LOCN_CODE.trim() );
	//ph_trn_desc  = CommonBean.checkForNull( ph_trn_desc.trim() );
	DISP_LOCN_DESC	= CommonBean.checkForNull( DISP_LOCN_DESC.trim());
	WS_NO = CommonBean.checkForNull( WS_NO.trim() );
	//disp_group_desc = CommonBean.checkForNull( disp_group_desc.trim() );
	//action		    = CommonBean.checkForNull( action.trim() );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	//include all the common parameters.
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_WS_NO_FOR_DISP_LOCN_SELECT1"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add( "code" );
	displayFields.add( "short" );
	displayFields.add( "wsno" );


	ArrayList chkFields = new ArrayList();
	chkFields.add(session.getValue( "facility_id" ) );
	chkFields.add( DISP_LOCN_CODE.trim() + "%" );
	chkFields.add(DISP_LOCN_DESC.trim() + "%" );
	chkFields.add(WS_NO.trim() + "%" );
	//chkFields.add( st_document_desc.trim() + "%" );
	//chkFields.add( disp_group_desc.trim() + "%" );
	//chkFields.add( action.trim() + "%" );
	chkFields.add(locale);


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
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th><th><fmt:message key="ePH.WorkstationNo.label" bundle="${ph_labels}"/></th>
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
			<td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);">  <%=(String)records.get( colCount )%>    </font></td>
	<%
				}else{
					String fieldValue=((String)records.get( colCount ));
					if (fieldValue==null) fieldValue = "";
					if (fieldValue.equals("*A")){
						fieldValue="*All";
					}

					String dkVal =fieldValue ;
					if(dkVal == null)	dkVal = "&nbsp" ;
					if(dkVal.equals("")) dkVal = "&nbsp;";
	%>

	<td class="<%=classvalue%>" onclick="disableClick(event); "><%=dkVal%></td>
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
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/WsDispLocnQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>


