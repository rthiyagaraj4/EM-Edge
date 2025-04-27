<%@ page import ="java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	Connection con =null;
	PreparedStatement pstmt=null ;
	ResultSet rs=null;
	boolean res = true;

try{
	int order = Integer.parseInt(request.getParameter("order"));
	String fldnm = request.getParameter("fldnm");
	int check = 0;
	int reccnt = 0;
	String field ="";
	if (!fldnm.equalsIgnoreCase("PAT_PHOTO"))
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("select count(1) from mp_pat_search_result");
		rs=pstmt.executeQuery();
		rs.next();
		reccnt = rs.getInt(1);
		if (rs!=null) rs.close();
		if (pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("select field_name field_name,field_order from mp_pat_search_result");
		rs=pstmt.executeQuery();
		if( rs != null )
		{
			while( rs.next() )
			{

				field = rs.getString("field_name")==null?"":rs.getString("field_name");
				check = rs.getInt("field_order");

				if (((check == order) && (!fldnm.equals(field))) || (order > reccnt)){
					res = false;
					break;
				}				
			}
		}
	}
		if (!(res))
		{
			%>
	<script>
			var errors= parent.frames[1].getMessage("ORDER_NO_EXISTS","MP")+ "<br>";
			parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=" + errors+"&error_value="+1;

	</script>
	<%
		}
		else if (res)
		{
		%>
		<script>
			parent.frames[1].document.forms[0].submit();
		</script> 
	<%
	}
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
