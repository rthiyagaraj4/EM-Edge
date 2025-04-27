<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<!--Added by lakshmi against CRF-0146-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" 
		import= "java.sql.Connection,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository"%>
<% request.setCharacterEncoding("UTF-8");%>

<!--<frameset rows='0%,100%'>-->
  <%
	// String strLegends="Surgery Date,Patient ,Surgeon,Booking No,Operation";
	// String strSizes="10,25,25,10,30";
	 String source="../../eOT/jsp/HdrComDisplay.jsp?";
	 String param="";
	 source=source+param;
//Added by lakshmi against CRF-0146
	  Connection conn=null;
	  PreparedStatement pstmt_sm_report_display = null;
	  ResultSet rst_sm_report_display=null;
	  conn=ConnectionManager.getConnection(request);

	String Ot_param="";
	String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST from OT_PARAM where rownum = 1";
	pstmt_sm_report_display=conn.prepareStatement(sql_sm_report);
	rst_sm_report_display=pstmt_sm_report_display.executeQuery();
	if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
       if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	   if(conn!=null) ConnectionManager.returnConnection(conn,request);
	 %>
	 <%if(Ot_param.equalsIgnoreCase("Y")){%>
		 <frameset rows='0%,15%,*'>
		 <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>' frameborder=0 scrolling='no' noresize>	
		 <!--Added by lakshmi against CRF-0146-->	 
		 <frame name='schdule_fltr' id='schdule_fltr' 	src="../../eOT/jsp/PickListReviewFilter.jsp" noresize frameborder=0 scrolling='no'>	
		 <frame name='schdule_dtl' id='schdule_dtl' 		src="../../eOT/jsp/PickListReviewDtl.jsp"  noresize frameborder=0 scrolling='yes'>
		 </frameset>
		 <%}
	else{%>
		 <frameset rows='0%,*'>
		 <frame name='schedule_hdr' id='schedule_hdr'	src='<%=source%>' frameborder=0 scrolling='no' noresize>	
		 <frame name='schdule_dtl' id='schdule_dtl' 	src="../../eOT/jsp/PickListReviewDtl.jsp"  noresize frameborder=0 scrolling='yes'>
		 </frameset>
<%}%>	 

 <!--Added by lakshmi against CRF-0146-->
<input type='hidden' name='Ot_param' id='Ot_param' value="<%=Ot_param%>">

