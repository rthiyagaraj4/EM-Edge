<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<% 
	request.setCharacterEncoding("UTF-8");
    Connection con=null;
	ResultSet rs=null;
	Statement stmt=null;
 try
  {
	
	con	= ConnectionManager.getConnection(request);
	stmt = con.createStatement();
	

	String report_gr_id=checkForNull(request.getParameter("report_gr_id"));
    String sub_group_code=checkForNull(request.getParameter("sub_group_code"));
    String main_group=checkForNull(request.getParameter("main_group"));
	String master=checkForNull(request.getParameter("master"));
    String levelcode=checkForNull(request.getParameter("levelcode"));
	String master_table_reference=checkForNull(request.getParameter("master_table_reference1"));
	
	String sql="";
	//Below line modified for this CRF PER-RH-206
	//Modified by Ashwini on 12-Sep-2019 for ML-MMOH-CRF-1349 //MROPCSMS Removed by Ashwini on 19-May-2020 for ML-MMOH-CRF-1532
	if(report_gr_id.equals("MRIPCSMB") || report_gr_id.equals("MRDCCSMB") || report_gr_id.equals("MROPCSMB"))
	{   
	    sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='TL'  and SUBGROUP_CODE='"+main_group+"' and GROUP_CODE='"+levelcode +"' and LEVEL3_CODE='"+sub_group_code+"'";
	 	
	int ordersrlno=0;
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	if(rs!=null) rs.close();
	%>
	<script>
	parent.frames[1].frames[0].document.forms[0].serialvalue.value=<%=ordersrlno%>
	parent.frames[1].frames[0].document.getElementById("fetchdata").innerText=' <%=ordersrlno%>'
		
	</script>


	
 <% }
    else if(report_gr_id.equals("MRBRADEX") || report_gr_id.equals("MRBLABRG") || report_gr_id.equals("MRIPCSBD") || report_gr_id.equals("MRIPCSOBD"))
     {   //Above line modified for this CRF PER-PD-209A
		  sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='"+master+"'  and SUBGROUP_CODE='"+main_group+"' and GROUP_CODE='"+levelcode+"'";
	      int ordersrlno=0;
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	%>
	<script>
	parent.frames[1].frames[0].document.forms[0].serialvalue.value=<%=ordersrlno%>
	parent.frames[1].frames[0].document.getElementById("fetchdata").innerText=' <%=ordersrlno%>'
		
	</script>
		<%
	 }
	 else
	 {
		  sql="select ORDER_BY_SRL_NO from mr_report_grouping  where   report_id='"+report_gr_id +"'  and MAST_TABLE_NAME_REFERENCE='"+master_table_reference+"'  and GROUP_CODE='"+main_group+"'";
	      int ordersrlno=0;
	if(rs!=null) rs.close();
	rs=stmt.executeQuery(sql);
	if(rs.next())
	{
		ordersrlno=rs.getInt(1);
	}
	%>
	<script>
	parent.frames[1].frames[0].document.forms[0].serialvalue.value=<%=ordersrlno%>
	parent.frames[1].frames[0].document.getElementById("fetchdata").innerText=' <%=ordersrlno%>'
		
	</script>
		<%
	 }
 if(stmt!=null) stmt.close();
 if(rs!=null) rs.close();}
  catch(Exception e)
   {
	   //out.println("Exception in File SSPopulateValues"+e.toString());
	   e.printStackTrace();
   }
   finally
   {
    ConnectionManager.returnConnection(con,request);
   }
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
