<!DOCTYPE html>
<!--<%@page import="eBL.*,java.util.*" contentType="text/html;charset=UTF-8" %>-->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.* ,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%
Connection con = null;
 try{
	 String bean_id = "" ;
     String bean_name=""; 
	 HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");	
	 
	 String facility_id = (String)httpSession.getValue("facility_id");
	 con = ConnectionManager.getConnection(request);
	 String hand_without_counter_chk_out="";

	 	try
		{		
			PreparedStatement pstmt1 = con.prepareStatement( " select HAND_WITHOUT_COUNTER_CHK_OUT from  BL_PARAMETERS where OPERATING_FACILITY_ID='"+facility_id+"'");
			ResultSet rs1 = pstmt1.executeQuery();	
			while(rs1.next())
			{
				hand_without_counter_chk_out  =  rs1.getString(1);		
			}		
			rs1.close();
			pstmt1.close();
		}catch(Exception e)
			{
				System.out.println("hand_without_counter_chk_out error= ="+e.toString());
			}
%>	
<HTML>
<HEAD>
</HEAD>
	
<!--
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'</link>
-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>		
		<script language='javascript' src='../../eBL/js/BLCashChequeHandover.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			 bean_id = "BLCashChequeHandOverBean" ;
			 bean_name = "eBL.BLCashChequeHandOverBean";
		     BLCashChequeHandOverBean bean			= (BLCashChequeHandOverBean)getBeanObject( bean_id, bean_name, request ) ;
	if(hand_without_counter_chk_out.equals("Y")){
	%>			
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0 scrolling='no' noresize style='height:6vh;width:100vw'></iframe>			
			<!--	<iframe name='BLCashChequeHandoverReqDtlsFrame' id='BLCashChequeHandoverReqDtlsFrame' 	src='../../eBL/jsp/BLCashChequeHandoverReqFrame.jsp?<%=params%>' frameborder=0 scrolling='' noresize></iframe>-->
			<iframe name='BLCashChequeHandoverReqDtlsFrame' id='BLCashChequeHandoverReqDtlsFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style='height:89vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:5vh;width:100vw'></iframe>
		
<%		
				putObjectInBean(bean_id,bean,request);
	}else{
		out.println("<script>callAlertFunction('hand_without_counter_chk_out')</script>");
		}
  }catch(Exception ee)
		{
			out.println("putbean :"+ee);
		}
		finally
		{
		ConnectionManager.returnConnection(con, request);
		}
%>
</HTML>

