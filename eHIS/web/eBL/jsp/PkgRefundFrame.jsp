<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,eBL.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
		String params = request.getQueryString();
		String facilityId		= (String) session.getValue( "facility_id" ) ;
		String	loggedInUser	=  (String) session.getValue("login_user");	
		String bean_id		= "PkgRefundBean" ;
		String bean_name	= "eBL.PkgRefundBean";
		PkgRefundBean bean			= (PkgRefundBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.clearBean();
		boolean user_adhoc_refund_appl=bean.getUserAdhocRefundAppl(loggedInUser,facilityId);
		boolean user_refund_appl = bean.getUserPkgRefundAppl(loggedInUser,facilityId);

		
	
%>
<HTML>
<HEAD>
</HEAD>
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
				<script language="javascript" src='../js/PkgRefund.js'></script> 
				<script language="javascript" src="../../eCommon/js/common.js"></script>	
				<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
				<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	<%	if(user_refund_appl || user_adhoc_refund_appl){%>	

		<iframe name='PkgRefundHdrFrame' id='PkgRefundHdrFrame'	src='PkgRefundHdr.jsp?<%=params%>'  frameborder=0 scrolling='auto' noresize style='height:14vh;width:100vw'></iframe>
			<iframe name='PkgRefundSrvDtls' id='PkgRefundSrvDtls'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
			<iframe name='PkgRefundExclDtls' id='PkgRefundExclDtls'	src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize style='height:44vh;width:100vw'></iframe>		
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		
		<%}else{
			out.println("<script>alert(getMessage('BL8661','BL'));</script>");
		
		}%>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

