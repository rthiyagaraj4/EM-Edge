

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<%@ page  import="java.util.ArrayList,java.util.Hashtable,eOT.*" %>


<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%String locale = (String)session.getAttribute("LOCALE"); %>
<%
//	ArrayList date_list = null;
	String func_mode = checkForNull(request.getParameter("func_mode"));
	String speciality_code=checkForNull(request.getParameter("speciality_code"));
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
//	String code_desc = "";
	StringBuffer result=new StringBuffer();
	String order_type_code = "";
	String order_type_desc = "";
	String sql="";
	if(func_mode!=null && func_mode.equals("getOrderTypes")){
					con=ConnectionManager.getConnection(request);
					sql="SELECT B.ORDER_TYPE_CODE, SHORT_DESC FROM OR_ORDER_TYPE_LANG_VW A, OT_SPECIALITY_ORDER_TYPES B WHERE SPECIALITY_CODE =? AND A.ORDER_TYPE_CODE = B.ORDER_TYPE_CODE AND A.LANGUAGE_ID =?";
			try{
				     
					stmt=con.prepareStatement(sql);
					stmt.setString(1,speciality_code);
					stmt.setString(2,locale);

					rs=stmt.executeQuery();
					while(rs.next())
					{
						order_type_code = rs.getString(1);
						order_type_desc = rs.getString(2);

						result.append(order_type_code+"##"+order_type_desc);
						result.append("~");
				   }
				out.println(result.toString());
			}//try
			catch(Exception e){
	   	   out.println("Err Msg from OperationsProcedureValidation.jsp"+e.getMessage());
   }//catch
   finally{
		try{
			if(rs!=null)		rs.close();
			if(stmt !=null)		stmt.close();
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
}//if
%>
