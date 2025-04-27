<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
    request.setCharacterEncoding("UTF-8");
    String process                  = request.getParameter("process_id");
    String flag						= "";
	String desktop_summary_type     = "";
	Connection con=null;
	int menu_count=0;
			try{
			con = ConnectionManager.getConnection(request);
			PreparedStatement pStatement			=	null;
	        ResultSet		resultSet				=	null;

		 if(process.equals("Desktop_code1"))
 		{
			String desktop_code		= request.getParameter("desktop_code");
			String menuid		    = request.getParameter("Menu_id");
			String sql = "SELECT DESKTOP_SUMMARY_TYPE FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_ID=?";
            pStatement	= con.prepareStatement(sql);
			pStatement.setString(1, desktop_code);
			resultSet	= pStatement.executeQuery();
			if (resultSet !=null&& resultSet.next()){
				desktop_summary_type =resultSet.getString("DESKTOP_SUMMARY_TYPE");
			}
            if(resultSet!=null)resultSet.close();
			if(pStatement!=null)pStatement.close();
            if (desktop_summary_type.equals("C")){
			String sqlResp="SELECT count(*) FROM sm_menu_dtl WHERE module_id = 'CA' AND function_id = 'CLINICIAN_ACCESS' AND (menu_id = ?  OR menu_id IN (SELECT NVL (submenu_id, '*')  FROM sm_menu_dtl    WHERE menu_id = ?))";

			pStatement	= con.prepareStatement(sqlResp);
			pStatement.setString(1, menuid);
			pStatement.setString(2, menuid);

			resultSet	= pStatement.executeQuery();
			while ((resultSet != null) && (resultSet.next()))
			{
			  menu_count =resultSet.getInt(1);

			}

			 if(menu_count == 1)
				{
				  flag="Y";
				}
			 else 
				{
				  flag="N";
				}
   	    %>
				<script>
			    parent.frames[1].document.forms[0].flagg.value='<%=flag%>'	
				//parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";


		      	</script> 
		<%

			if(resultSet!=null)resultSet.close();
			if(pStatement!=null)pStatement.close();
		 }

		 %>
		<script>
		      parent.frames[1].document.forms[0].desktop_summary_type.value='<%=desktop_summary_type%>';
			  parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0";
		</script> 
		<%
		}
			
		}
		catch(Exception e)
		{
			out.print(e);
		}
		finally { 
				ConnectionManager.returnConnection(con,request);
}
%>

</form>
</body>
</html>


