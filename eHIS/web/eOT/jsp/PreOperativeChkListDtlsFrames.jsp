<!DOCTYPE html>
<% //@page  import="java.sql.*, java.util.*,java.io.*" contentType=" text/html;charset=" %>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.CallableStatement,java.sql.Types,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" contentType="text/html; charset=UTF-8" %>
<%//@ page contentType="text/html;charset=UTF-8"  import ="eCommon.Common.CommonBean"  %>

<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>


<%
	String params = request.getQueryString();
	String called_from = CommonBean.checkForNull(request.getParameter("called_from"));
	/* Below Procedure newly added by sathish.k on 09-01-2009 for disabling billing part while unchecked bl_interface_flag 
	Note: if any billing part is calling in PreOperChkListHdr.jsp(Hdr part of ChkecIn) pls call this procedure in OTChekIn.jsp*/
	String facility_id	= (String) session.getValue("facility_id");
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null ;
	CallableStatement cstmt = null;
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	boolean bill_flag = false;
	try{
		connection	= ConnectionManager.getConnection(request);
		//for checking whether the Billing module is installed or not
		//ORDERING_FACILITY_ID,FACILITY_ID ,P_BL_INSTALLED,P_BL_INTERFACED ,P_ERROR_FLAG,P_ERROR_CODE, P_ERROR_MESG
		cstmt=connection.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
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
	    	System.err.println("Error PreOperativeChkListDtlsFrames.jsp:"+e);
   }finally{
		try{
			//if(rst!=null)rst.close();
			if(cstmt!=null)cstmt.close();
			if(connection!=null) ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){
			e.printStackTrace();
		    	System.err.println("Finally Block PreOperativeChkListDtlsFrames.jsp:"+e);
		}
    }
	 params=params+"&bill_flag="+bill_flag;
%>

<%
		if(called_from.equals("OT_MENU")){
%>
	<iframe name='RecordFrame' id='RecordFrame' SRC='../../eOT/jsp/ChkListOperationRecord.jsp?<%=params%>'  scrolling='no' noresize='no' style='height:56vh;width:100vw;border:0'></iframe>
		<iframe name='DetailFrame' id='DetailFrame' SRC='../../eOT/jsp/ChkListOperationDtls.jsp?<%=params%>' scrolling='no' noresize='auto'  style='height:44vh;width:100vw;border:0'></iframe>
	
<%
		}else if(called_from.equals("OT_SLATE") || called_from.equals("BOOKING") ){
%>
		<iframe name='DetailFrame' id='DetailFrame' SRC='../../eOT/jsp/ChkListOperationDtls.jsp?<%=params%>' scrolling='no' noresize='no' style='height:100vh;width:100vw;border:0'></iframe>
		
	<%
			}
%>
</HTML>


