<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,,java.sql.CallableStatement,java.sql.Types,eCommon.Common.CommonBean,eCommon.XSSRequestWrapper,java.util.Properties,eOT.Common.OTRepository,eOT.OperationDtlBean,eOR.OrderEntryBillingQueryBean" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends  
%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%
    String or_bean_id 						= "Or_billingQueryBean";
	String or_bean_name 					= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean		= (OrderEntryBillingQueryBean)mh.getBeanObject( or_bean_id,request, or_bean_name ) ;
	or_bean.clearBean();
%>


<html>
	<head>
		<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
		<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
		<script language='javascript'  src='../../eCommon/js/common.js' ></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
</head>

<%
	String bean_id = "OperationDtlBean";
	String bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);
	chk_bean.clear();
	int dayVal=0;
	String weekDay[]=new String[8];
	String facility_id  = (String) session.getValue("facility_id");
	//Added by lakshmi against change in performing_facility starts here
	String performing_facility_id = (String)session.getValue("performing_facility");
	if(performing_facility_id!=null && performing_facility_id.length()>0)
		{
			facility_id = (String)session.getValue("performing_facility");
		}
	//Added by lakshmi against change in performing_facility ends here
	Properties p=(Properties)session.getValue("jdbc");
	String login_user= p.getProperty("login_user");
	String sunday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels")+",";
	String monday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels")+",";
	String tuesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels")+",";
	String wednesday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels")+",";
	String  thursday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels")+",";
	String  friday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels")+",";
	String  saturday = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels")+",";
	weekDay[1]=sunday;
	weekDay[2]=monday;
	weekDay[3]=tuesday;
	weekDay[4]=wednesday;
	weekDay[5]= thursday;
	weekDay[6]=friday;
	weekDay[7]=saturday;
	//DhanasekarV Modified against the issue IN023690  on 15/11/2010
//String strBookingDate=com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY",locale,"en");
String strBookingDate1 =com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY",locale,"en");
String strBookingDate=request.getParameter("booking_date");
String ammendFlag = request.getParameter("ammendFlag");
System.out.println("=========ammendFlag======OperationRegisterFrame========="+ammendFlag);
	//end IN023690
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String param=request.getQueryString();
	String sql=""+OTRepository.getOTKeyValue("SQL_OT_COMMON_DATE_SELECT1");
	String strSpecialityYN="";
	conn = ConnectionManager.getConnection(request);
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strBookingDate1);
		rs=pstmt.executeQuery();
		if(rs.next()==true)	 dayVal=Integer.parseInt(rs.getString(1));
		rs.close();
		pstmt.close();
		//sql=""+OTRepository.getOTKeyValue("SQL_OT_BOOKING_AUTHORIZATION1");
		sql="SELECT OVERIDE_SPLTY_RESTRICTION_YN OVERIDE_SPLTY_RESTRICTION_YN1  FROM OT_BOOKING_ACCESS_RIGHTS WHERE OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,login_user);
		rs=pstmt.executeQuery();
		if(rs.next()==true)
			strSpecialityYN=CommonBean.checkForNull(rs.getString("OVERIDE_SPLTY_RESTRICTION_YN1"));
		rs.close();
		pstmt.close();
		if(strSpecialityYN.length()==0)	 strSpecialityYN="N";
		////eOT.LogFile.log("OTDebugger"," Authorization  "+strSpecialityYN,this);
		 param=param+"&speciality_access="+strSpecialityYN;
	}catch(Exception ee){
		ee.printStackTrace();
		////eOT.LogFile.log("OTDebugger"," Authorization  "+ee,this);
	}finally{
		ConnectionManager.returnConnection(conn, request);
	}
	//note: To be Replaced by ResourceBundle Message.
	//String title= "Schedule Appointment for "+strBookingDate+" "+weekDay[dayVal];


	StringBuffer sbr = new StringBuffer();
	sbr.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bookappointment.label","common_labels")).append(" ").append(strBookingDate).append(" ").append(weekDay[dayVal]);
	
	String title= sbr.toString();
	sbr.setLength(0);
	String source="../../eCommon/jsp/commonToolbar.jsp?module_id=OT&function_type=F&menu_id=OT_JAVA_DFLT&access=NYNNY&home_required_yn=N";
	String strOrderId = checkForNull(request.getParameter("orderid"));


    /* below procedure added by sathish on 08/01/2008  for disabling billing part when unchecked bl_interface_flag */
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean bill_flag = false;
	try{
		conn	= ConnectionManager.getConnection(request);
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=conn.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
		cstmt.setString(1,facility_id );
		cstmt.setString(2,facility_id );
		cstmt.registerOutParameter(3,Types.VARCHAR);
		cstmt.registerOutParameter(4,Types.VARCHAR);
		cstmt.registerOutParameter(5,Types.VARCHAR);
		cstmt.registerOutParameter(6,Types.VARCHAR);
		cstmt.registerOutParameter(7,Types.VARCHAR);
		cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
		cstmt.execute();
		if(!checkForNull(cstmt.getString(5)).equals("Y")){
			bl_installed=cstmt.getString(3);
			bl_interface=cstmt.getString(4);
			bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
		}else
		{
			//err_text = cstmt.getString(7);
			err_text = cstmt.getString(8);
		}
	}catch(Exception e){
		e.printStackTrace();

   }finally{
		try{
			//if(rst!=null)rst.close(); 
			if(cstmt!=null)cstmt.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}

	}
   param=param+"&bill_flag="+bill_flag;
%>
<TITLE><%=title%></TITLE>
<%if(strOrderId.length()>0){
	%>
	<!--<frameset rows='5%,12%,35%,*,10%'>-->
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" frameborder='0' style='height:4vh;width:98vw' ></iframe>
		<iframe name="OtPatientLineFrame" id="OtPatientLineFrame" src="../../eOT/jsp/OTPatLineFrame.jsp?<%=request.getQueryString()%>" frameborder='0'  scrolling="no" style='height:12vh;width:98vw'> </iframe>
	<%}else{%>
		<!--<frameset rows='4%,50%,*,4%'>-->
		<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder='0' scrolling="no" noresize src="<%= source %>" style='height:4vh;width:98vw'></iframe>
	<%}%>
		<iframe name='header_frame' id='header_frame' src="../../eOT/jsp/OperationProcedureHdr.jsp?<%=param%>" frameborder='0'  scrolling="no" noresize style='height:45vh;width:98vw'></iframe>
		<iframe name='message_search_frame' id='message_search_frame'	 src="../../eOT/jsp/OperationCommonFrame.jsp?<%=param%>" scrolling="no" frameborder='0' style='height:40vh;width:98vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' frameborder='0' style='height:6vh;width:98vw'></iframe>
	<!--</frameset>-->
<form name="OperationRegisterFrameForm"  id="OperationRegisterFrameForm">
	<input type='hidden' name='locale' value="<%=locale%>">
	<input type='hidden' name='params' value="<%=param%>">
</form>
</html>
