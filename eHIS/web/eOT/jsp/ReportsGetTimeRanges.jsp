<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.*,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*,java.util.* " %>
<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>

<% 
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String time_range_code = request.getParameter("time_range_code");
	StringBuffer append_str = new StringBuffer();
	append_str.append("::");
	String slot_1 = "";
	String slot_2 = "";
	String slot_3 = "";
	String slot_4 = "";
	String slot_5 = "";
	String slot_6 = "";
	String slot_7 = "";
	String slot_8 = "";
	String slot_9 = "";
	String slot_10 = "";
	String sql = "";
	try{
		connection = ConnectionManager.getConnection(request);
// GET THE TIME RANGES
		sql="SELECT TO_CHAR(TIME_1_SLOT,'HH24:MI') AS SLOT_1, TO_CHAR(TIME_2_SLOT,'HH24:MI') AS SLOT_2, 	TO_CHAR(TIME_3_SLOT,'HH24:MI') AS SLOT_3, TO_CHAR(TIME_4_SLOT,'HH24:MI') AS SLOT_4, TO_CHAR(TIME_5_SLOT,'HH24:MI') AS SLOT_5, TO_CHAR(TIME_6_SLOT,'HH24:MI') AS SLOT_6, TO_CHAR(TIME_7_SLOT,'HH24:MI') AS SLOT_7, TO_CHAR(TIME_8_SLOT,'HH24:MI') AS SLOT_8, TO_CHAR(TIME_9_SLOT,'HH24:MI') AS SLOT_9, TO_CHAR(TIME_10_SLOT,'HH24:MI') AS SLOT_10 FROM OT_OPER_TIME_RANGE WHERE TIME_RANGE_CODE = '"+time_range_code+"' ORDER BY 1";
		pstmt = connection.prepareStatement(sql);
		resultset = pstmt.executeQuery();
		while(resultset.next()){
			 slot_1 = resultset.getString("SLOT_1");
			 slot_1=slot_1==null?"":slot_1;
			 slot_1=slot_1.equalsIgnoreCase("null")?"":slot_1;
			 slot_2	= resultset.getString("SLOT_2");
			 slot_2=slot_2==null?"":slot_2;
			 slot_2=slot_2.equalsIgnoreCase("null")?"":slot_2;
			 slot_3	= resultset.getString("SLOT_3");
			 slot_3=slot_3==null?"":slot_3;
			 slot_3=slot_3.equalsIgnoreCase("null")?"":slot_3;
			 slot_4	= resultset.getString("SLOT_4");
			 slot_4=slot_4==null?"":slot_4;
			 slot_4=slot_4.equalsIgnoreCase("null")?"":slot_4;
			 slot_5 = resultset.getString("SLOT_5");
			 slot_5=slot_5==null?"":slot_5;
			 slot_5=slot_5.equalsIgnoreCase("null")?"":slot_5;
			 slot_6	= resultset.getString("SLOT_6");
			 slot_6=slot_6==null?"":slot_6;
			 slot_6=slot_6.equalsIgnoreCase("null")?"":slot_6;
			 slot_7	= resultset.getString("SLOT_7");
			 slot_7=slot_7==null?"":slot_7;
			 slot_7=slot_7.equalsIgnoreCase("null")?"":slot_7;
			 slot_8	= resultset.getString("SLOT_8");
			 slot_8=slot_8==null?"":slot_8;
			 slot_8=slot_8.equalsIgnoreCase("null")?"":slot_8;
			 slot_9	= resultset.getString("SLOT_9");
			 slot_9=slot_9==null?"":slot_9;
			 slot_9=slot_9.equalsIgnoreCase("null")?"":slot_9;
			 slot_10= resultset.getString("SLOT_10");
			 slot_10=slot_10==null?"":slot_10;
			 slot_10=slot_10.equalsIgnoreCase("null")?"":slot_10;
		}
		append_str.append(slot_1+"::"+slot_2+"::"+slot_3+"::"+slot_4+"::"+slot_5+"::"+slot_6+"::"+slot_7+"::"+slot_8+"::"+slot_9+"::"+slot_10);	
		
	}catch(Exception e){
		System.err.println("Err Msg in StatBySpltyReportGetTimeRanges.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	out.println(append_str);
	append_str.setLength(0);
%>


