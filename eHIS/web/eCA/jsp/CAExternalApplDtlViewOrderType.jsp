<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*, java.util.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script language='javascript' src='../js/CAExternalApplDtl.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");	
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String sql = "";
	String order_type_code = "";
	String short_desc = "";
	String order_category = "";
	//int i = 0;
	order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");



	try
	{
			con = ConnectionManager.getConnection();
%>

<body onKeyDown="lockKey()">


<%
			sql = "select ORDER_TYPE_CODE,replace(SHORT_DESC,'''','') SHORT_DESC from OR_ORDER_TYPE where ORDER_CATEGORY = ? and EFF_STATUS='E' order by short_desc ";
		
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,order_category);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				
				order_type_code = rs.getString("ORDER_TYPE_CODE")==null?"":rs.getString("ORDER_TYPE_CODE");
				short_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");

				out.println("<script>");
				out.println("var opt = parent.frames[1].document.createElement('OPTION');");
				out.println("opt.text = '"+short_desc+"';");
				out.println("opt.value ='"+order_type_code+"';");
				out.println("parent.frames[1].document.forms[0].order_type.add(opt);");	
				out.println("</script>");				
			}

%>
<script>
	parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
</script>
</body>
	</html>
<%
}
catch(Exception ex)
	{
		//out.println("Exception @ CAExternalApplDtlViewOrderType.jsp "+ex.toString());//COMMON-ICN-0181
                   ex.printStackTrace();//COMMON-ICN-0181
	}
finally
	{
		try
		{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
		
			ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
				//out.println("Exception @ finally CAExternalApplDtlViewOrderType.jsp "+e.toString());//common-icn-0181
		                 e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>


