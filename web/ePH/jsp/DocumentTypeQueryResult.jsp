<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../ePH/js/DocumentType.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//Search Criteria's from Query Criteria page
	String ph_trn_type		= request.getParameter( "ph_trn_type" ) ;
	String ph_trn_desc		= request.getParameter( "ph_trn_desc" ) ;
	String ord[]			= request.getParameterValues("orderbycolumns");
	String facilityId			= (String)session.getValue("facility_id");
	boolean searched		= request.getParameter( "searched" ) == null ? false : true  ;


try{
	String classvalue			= "";
	if (ph_trn_type==null)   ph_trn_type="";
	if (ph_trn_desc==null)   ph_trn_desc="";
	
	ph_trn_type			= CommonBean.checkForNull( ph_trn_type.trim() );
	ph_trn_desc			= CommonBean.checkForNull( ph_trn_desc.trim() );

	//Common parameters.
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_TRN_DOC_TYPE_SELECT7"));

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add( "PH_TRN_TYPE_CODE" );
	displayFields.add( "PH_TRN_DESC" );
	displayFields.add( "ST_DOC_TYPE_CODE" );	
	displayFields.add( "ST_DOC_DESC" );
	
  
	ArrayList chkFields = new ArrayList();
	chkFields.add( ph_trn_type.trim() + "%" );
	chkFields.add( ph_trn_desc.trim() + "%" );
	chkFields.add(locale);
	chkFields.add(facilityId);

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
		<th><fmt:message key="ePH.PharmacyTransactionType.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.PharmacyTransactionDescription.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.STDocumentType.label" bundle="${ph_labels}"/></th><th><fmt:message key="ePH.STDocumentDescription.label" bundle="${ph_labels}"/></th>
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

	<td class="<%=classvalue%>" align="left" onclick="disableClick(event); "><%=dkVal%></td>
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
	out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DocumentTypeQueryResult.jsp", searched) );
} catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>


