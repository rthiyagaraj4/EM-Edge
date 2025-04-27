<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%

request.setCharacterEncoding("UTF-8"); 
Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;
String calling_object = ""; 
String facility_id		= (String)session.getValue("facility_id");
String calling_from	= request.getParameter("calling_from");
	if(calling_from==null) calling_from="";

calling_object	= request.getParameter("object_name");

String param_val		= request.getParameter("object_val");
String other_code		= request.getParameter("other_code");
	if(other_code==null)	other_code="";
String room_no	= request.getParameter("room_no");
	if(room_no==null) room_no="";
	
	String operation = request.getParameter("operation")==null?"":request.getParameter("operation");
%>
</head>

<body class='message' onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
	try{
		con = ConnectionManager.getConnection(request);
		String sqlNursingUnit=" Select ip_get_desc.ip_nursing_unit('"+facility_id+"',nursing_unit_code,'en',2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id='"+facility_id+"' and locn_type = 'N' and eff_status='E' order by short_desc ";
		if(operation.equals("fetchNursingUnit")){
			sqlNursingUnit=" Select ip_get_desc.ip_nursing_unit('"+facility_id+"',nursing_unit_code,'en',2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id='"+facility_id+"' and locn_type = 'N' and eff_status='E'  and floor_width is not null order by short_desc ";
		}
		if(operation.equals("fetchNursingUnit_floor") || operation.equals("fetchNursingUnit")){
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sqlNursingUnit);
			if(rs!=null){
				while(rs.next()){
				%>
					<script>
					var obj = parent.blank.document.bedMgmtSetupForm.nursing_unit
					var element=parent.blank.document.createElement("option");
					element.text="<%=rs.getString(1)%>";
					element.value="<%=rs.getString(2)%>";				
					obj.add(element)
					</script>
				<%}
			}
		}else{
			String sql_room	="select room_no,(select short_desc from am_facility_room where OPERATING_FACILITY_ID=facility_id and ROOM_NUM=room_no)room_name from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' and eff_status='E' and ROOM_HEIGHT is not null order by 1 ";
			stmt=con.createStatement();
			//System.out.println("sql_room 1:"+sql_room);
			rs=stmt.executeQuery(sql_room);
			if(rs!=null){
				while(rs.next()){
				%>
					<script>
					var obj = parent.blank.document.bedMgmtSetupForm.room;
					var element=parent.blank.document.createElement("option");
					element.text="<%=rs.getString("room_name")%>";
					element.value="<%=rs.getString("room_no")%>";				
					obj.add(element)
					</script>
				<%}			
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	}catch(Exception e){
		out.println("<script>alert('Error in intermediate page')</script>");
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>
<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
