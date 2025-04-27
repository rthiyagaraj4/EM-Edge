<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>
<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<%
         request.setCharacterEncoding("UTF-8");
	    String locale			= (String)session.getAttribute("LOCALE");
	    
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonResult.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
	
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugClassForOrderType.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	String order_type			= request.getParameter( "ORDER_TYPE_CODE" ) ;
	String order_type_desc		= request.getParameter( "ORDER_TYPE_DESC" ) ;
	String drug_class			= request.getParameter( "DRUG_CLASS" ).trim() ;

	boolean searched			= request.getParameter( "searched" ) == null ? false : true ;
	String ord[]				= request.getParameterValues("orderbycolumns");

	try {
		String classvalue		= "";

		order_type 			= CommonBean.checkForNull( order_type );
		order_type_desc		= CommonBean.checkForNull( order_type_desc );
		drug_class			= CommonBean.checkForNull( drug_class );

		//Common parameters.
		HashMap sqlMap = new HashMap();
		sqlMap.put( "sqlData", PhRepository.getPhKeyValue( "SQL_PH_ORDER_TYPE_FOR_DRUG_CLASS_SELECT1" ) ) ;

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();
		displayFields.add( "ORDER_TYPE_CODE" );
		displayFields.add( "LONG_DESC" );
		displayFields.add( "DRUG_CLASS_ABBR" );

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(locale);
		chkFields.add( order_type + "%" );
		chkFields.add( order_type_desc + "%" );
		chkFields.add( drug_class + "%" );
		chkFields.add( drug_class + "%" );
		

		// Adding function parameters related array list into the HashMap
		HashMap funcMap = new HashMap();
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		//Calling the Result from Common Adaptor as a arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

		if( result.size() >= 3 && ( !( ( (String)result.get(0)).equals("0")) )) {
%>

		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
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

		<TABLE BORDER="1" CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
		<TH WIDTH="20%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></TH>
		<TH WIDTH="65%"><fmt:message key="ePH.OrderTypeDescription.label" bundle="${ph_labels}"/></TH>
		<TH WIDTH="15%"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></TH>

<%
			//Retriving the records from result arraylist
			ArrayList records = new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
%>

		<TR>

<%
				records = (ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++) {

%>

			<TD ALIGN="left" CLASS="<%=classvalue%>" onClick="disableClick(event);">

<%
	if(colCount!=2){
	out.println((String)records.get( colCount ));
}

else if(colCount==2){

%>
<!--TD CLASS="<%=classvalue%>" onClick="disableClick(event);"-->
<%
if(((String)records.get( colCount)).equals("General"))
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels"));
else
	out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels"));
%>
<%
}else{%>


<%}%>
			</TD>

<%
				}
%>

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
		out.println(CommonBean.setForm ( request ,"../../ePH/jsp/DrugClassForOrderTypeQueryResult.jsp", searched ) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</BODY>
</HTML>

