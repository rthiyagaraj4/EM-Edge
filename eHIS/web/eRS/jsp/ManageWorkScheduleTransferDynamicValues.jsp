<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	15 Feb 2005
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 

<%
	
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
  
String shift_val = request.getParameter("shift_val")==null?"":request.getParameter("shift_val");
String p_schedule_date = request.getParameter("p_schedule_date")==null?"":request.getParameter("p_schedule_date");
String p_facility_id = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
String p_position_code = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
String transfer = request.getParameter("transfer")==null?"":request.getParameter("transfer");
String p_requirement_id = "";
String shift_code = "";
out.println("shift_val in manageworkscheduletransferdyanamicvalues.jsp 18  {"+shift_val+"}");
try
{
	con = ConnectionManager.getConnection(request);
	HashMap sft_hm = new HashMap();
	StringBuffer sft_sb = new StringBuffer();
	String sql_v = "SELECT a.requirement_id requirement_id,b.shift_code shift_code FROM RS_WORKPLACE_REQUIREMENT a,RS_WORKPLACE_REQUIREMENT_DTL b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm 	   	    AND a.requirement_date_to  AND b.facility_id = a.facility_id AND b.workplace_code = a.workplace_code AND b.requirement_id = a.requirement_id  AND b.position_code = ? AND ";
	StringTokenizer stk = new StringTokenizer(shift_val,",");
	String sft_stk = "";
	sql_v	+=	"b.shift_code IN(";
	boolean first_time	=	true;
	while(stk.hasMoreTokens())	{				
		sft_stk = stk.nextToken();
		sft_hm.put(sft_stk,"N");
		if(!first_time)
			sql_v		+= ",";
		if(first_time){
			sql_v		+= "'"+(sft_stk)+"'";
			first_time	=	false;
		} 
		else{
			sql_v		+= "'"+(sft_stk)+"'";
		}
	}
	sql_v	+=	")";
	pstmt = con.prepareStatement(sql_v);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,transfer);
	pstmt.setString(3,p_schedule_date);
	pstmt.setString(4,p_position_code);
	rs = pstmt.executeQuery();
	if(rs!=null){
		while(rs.next()){
			p_requirement_id = rs.getString("requirement_id");
			shift_code = rs.getString("shift_code");
			if(sft_hm.containsKey(shift_code))
			{
				sft_hm.put(shift_code,"Y");
			}
		}
	}
	if(pstmt != null) pstmt.close();
	if(rs != null)	rs.close();
	if(p_requirement_id.equals(""))
	{
		String sql_c = "SELECT a.requirement_id, b.shift_code shift_code FROM RS_WORKPLACE_REQUIREMENT a,RS_WORKPLACE_REQUIREMENT_DTL b WHERE a.facility_id = ? AND a.workplace_code = ? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL AND b.facility_id = a.facility_id AND b.workplace_code = a.workplace_code AND b.requirement_id = a.requirement_id AND b.position_code = ? AND ";
		stk = new StringTokenizer(shift_val,",");
		sql_c	+=	"b.shift_code IN(";
		first_time	=	true;
		while(stk.hasMoreTokens())	{				
			if(!first_time)
				sql_c		+= ",";
			if(first_time){
				sql_c		+= "'"+(stk.nextToken().trim())+"'";
				first_time	=	false;
			} 
			else{
				sql_c		+= "'"+(stk.nextToken().trim())+"'";
			}
		}
		sql_c	+=	")";
		pstmt = con.prepareStatement(sql_c);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,transfer);
		pstmt.setString(3,p_position_code);

		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				p_requirement_id = rs.getString("requirement_id");
				shift_code = rs.getString("shift_code");
				if(sft_hm.containsKey(shift_code)){
					sft_hm.put(shift_code,"Y");
				}
			}
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	String shift_ind = "";
	String sKey = "";
	Set stKeys = sft_hm.keySet(); 
	Iterator it = stKeys.iterator();
	int i = 0;
	while(it.hasNext())
	{
		sKey = (String)it.next();
		shift_ind = (String) sft_hm.get(sKey);
		if(shift_ind.equals("N")){
			if(i!=0){
				sft_sb.append(",");
			}
			sft_sb.append("'"+sKey+"'");
			i++;
		}
	}
	if(!sft_sb.toString().equals(""))
	{
		i = 0;
		String sql_desc = "select short_desc from am_shift where shift_code in("+sft_sb.toString()+")";
		StringBuffer short_desc = new StringBuffer();
		pstmt = con.prepareStatement(sql_desc);
		rs = pstmt.executeQuery();
		if(rs!=null){
			while(rs.next()){
				if(i!=0){
					short_desc.append(",");
				}
				short_desc.append(rs.getString("short_desc"));
				i++;
			}
			i = 0;
		}
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();
		if(!short_desc.toString().equals("")){
			out.println("<script>alert('APP-RS0038 No requirment for "+(short_desc.toString())+" shifts')</script>");
%>
	<script>
   parent.ManageWorkScheduleTransfer_frames.document.ManageWorkScheduleTransfer.transfer.value = "";
	</script>
<%
		}
	}
	else
	{
%>
	<script>
	parent.ManageWorkScheduleTransfer_frames.document.ManageWorkScheduleTransfer.p_requirement_id.value = "<%=p_requirement_id%>";
	</script>
<%
	}
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</html>
