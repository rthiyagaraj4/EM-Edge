<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
    //endss
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PINAuthorizedRights.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-y:hidden">
<%
	String User_id		= request.getParameter( "USER_ID" ) ;
	String User_name		= request.getParameter( "USER_NAME" ) ;
	boolean searched		= request.getParameter( "searched" ) == null ? false : true ;
	String ord[]			= request.getParameterValues("orderbycolumns");

	try {
		User_id			= CommonBean.checkForNull( User_id );
		User_name		= CommonBean.checkForNull( User_name );
		
		//Common parameters.
		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_PIN_AUTH_RIGHTS_SELECT3" ) );

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "USER_ID" );
		displayFields.add( "USER_NAME" );
		
		       
		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(User_id+"%");
		chkFields.add(User_name+"%");
		//chkFields.add( eff_status );
		// Adding function parameters related array list into the HashMap
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if( result.size() >= 3 && ( !( ( (String)result.get(0)).equals("0")) )) {
		
%>
<br><br><br><br>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="center">
		<TR>
			<TD WIDTH="80%" CLASS="white">&nbsp;</TD>
			<TD WIDTH="20%" CLASS="white">&nbsp;

<%
			// For display the previous/next link
			out.println( result.get(1) );
%>

			</TD>
		</TR>
		</TABLE>

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="center">
		<TH><fmt:message key="Common.userid.label" bundle="${common_labels}"/></TH>
		<TH NOWRAP><fmt:message key="Common.username.label" bundle="${common_labels}"/></TH>
		
		

<%
			//Retriving the records from result arraylist
			ArrayList records = new ArrayList();
			String classvalue	= "";

			for(int recCount=2; recCount<result.size(); recCount++) {
					records = (ArrayList) result.get( recCount );
		

				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>
                <tr>
			

<%

				for(int colCount=0; colCount<=(records.size()-2); colCount++) {
					
%>
             <td class="<%=classvalue%>" ><font class='HYPERLINK' onmouseover="changeCursor(this);" onClick="Modify('<%=(String)records.get(colCount)%>','<%=(String)records.get(colCount+1)%>')">  <%=(String)records.get( colCount)%></font> </td>
				   <td class="<%=classvalue%>" NOWRAP> <%=(String)records.get( colCount+1 )%></td>
					     
			

<%
					
%>

			

<%
				
}
%>
		<INPUT TYPE="hidden" name="user_id<%=recCount%>" id="user_id<%=recCount%>" VALUE="<%=(String)records.get(0 ) %>">

		</TR>

<%
			}
%>

	</TABLE>
<%
			out.flush();
		}
		else {
%>
		<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>
<%
		}
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/PINAuthorizedRightsQueryResult.jsp", searched ) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>

</BODY>
</HTML>

