<!DOCTYPE html>

<!--
Developed by    : Bhavani Shankar.
Module/Function : Frame having Items of the selected tray/set
Start Date		: 21/02/2006
-->
<%@page   import="eOT.*,eOT.Common.*, eCommon.Common.CommonBean,java.util.HashMap,java.util.Hashtable" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOT/js/InstrumentCount.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="InstrumentCountRecordDtlsForm" id="InstrumentCountRecordDtlsForm">
<%
	String params		= request.getQueryString();
	Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	hash				= (Hashtable)hash.get( "SEARCH" ) ;
	String patient_id	= (String) hash.get( "patient_id" );
	String booking_num	= (String) hash.get( "booking_num" );
	String oper_num		= (String) hash.get( "oper_num" );
	String oper_code	= (String) hash.get( "oper_code" );
	String bio_hazard_yn	= (String) hash.get( "bio_hazard_yn" );
	String result		= "";
	try{
		String bean_id			= (String) hash.get( "bean_id" );
		String bean_name		= (String) hash.get( "bean_name" );
		InstrumentCountBean bean = (InstrumentCountBean)mh.getBeanObject( bean_id, request, bean_name );
		result = bean.updateRecord(patient_id,booking_num,oper_num,bio_hazard_yn);
		bean.clear();
	}catch( Exception e ) {
		System.err.println("Caught Exception error in InstrumentCountRecordDtls: "+e);
		e.printStackTrace();
	}finally {
			hash.clear();
			hash=null;
	}
	out.flush();
%>
<script>
	return <%=result%>;
</script>
	<input type="hidden" name="params" id="params"		value="<%=params%>">
	<input type="hidden" name="oper_code" id="oper_code"	value="<%=oper_code%>">
	<input type="hidden" name="oper_num" id="oper_num"	value="<%=oper_num%>">
	<input type="hidden" name="booking_num" id="booking_num"	value="<%=booking_num%>">
	<input type="hidden" name="patient_id" id="patient_id"  value="<%=patient_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

