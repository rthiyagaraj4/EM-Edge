<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Sreelatha
*	Created On		:	7 Jan 2005
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.*,webbeans.eCommon.*,java.util.*"%>
<%
Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String workplace_code="";
String facility_id="";
String location_type="";
String clearAll="";

try{
	workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
	clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");

	RecordSet	LocationWorkplace	=	null;
	LocationWorkplace	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LocationWorkplace");

	if(clearAll.equals("clearAll")){
		LocationWorkplace.clearAll();
	}
	else if(clearAll.equals("notCleared")){

		con = ConnectionManager.getConnection(request);

		String sql="select locn_code, 'I' db_action  from rs_locn_vw  where facility_id = ? and locn_type =?  and (facility_id,locn_code,locn_type) not in   (select facility_id,locn_type,locn_code from rs_locn_for_workplace where facility_id = ?  and workplace_code = ? ) union all select a.locn_code, 'U' db_action   from rs_locn_for_workplace a, rs_locn_vw b  where a.facility_id = ?  and a.workplace_code = ?  and a.locn_type = ?   and b.facility_id = a.facility_id   and b.locn_type = a.locn_type  and b.locn_code = a.locn_code  order by 1"; 

		//LocationWorkplace.clearAll();
		 pstmt=con.prepareStatement(sql);
		 pstmt.setString(1,facility_id);
		 pstmt.setString(2,location_type);
		 pstmt.setString(3,facility_id);
		 pstmt.setString(4,workplace_code);
		 pstmt.setString(5,facility_id);
		 pstmt.setString(6,workplace_code);
		 pstmt.setString(7,location_type);
		 rs=pstmt.executeQuery();
    	 while(rs.next())
		 {
			LocationWorkplace.putObject(rs.getString(1));
			LocationWorkplace.clearAll();
		 }
	}
	//for(int i=0; i<LocationWorkplace.getSize();i++)
		
%>
<html>
<head>
</head>
<body CLASS='MESSAGE'>
<form name="Dynamic_form" id="Dynamic_form">
<input type="hidden" name="E" id="E" value='<%=clearAll%>'>
<input type=hidden name=R value=''>
<input type=hidden name=S value=''>
<input type=hidden name=X value=''>
<input type=hidden name=Y value=''>
</form>
</body>
</html>
<%
	}
	catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		  if(pstmt!=null) pstmt.close();
		  if(rs!=null) rs.close();
		  if(con !=null)
		ConnectionManager.returnConnection(con,request);
	  }
%>

