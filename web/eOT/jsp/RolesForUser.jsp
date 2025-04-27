<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Types,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
	<head>	
 	<script language='javascript' src='../../eOT/js/RolesForUser.js'></script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="javascript">
	function hideMenu(menuParam)
		{
			if(menuParam == "yes")
				commontoolbarFrame.document.forms[0].home.value = "<fmt:message key='Common.hideMenu.label' bundle='${common_labels}'/>";
				//050736
			else
			{
				commontoolbarFrame.document.forms[0].apply.disabled=true;
				commontoolbarFrame.document.forms[0].reset.disabled=true;
			}			
	}
	</script>
 </head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		//String url = "../../eCommon/jsp/CommonToolbar.jsp?" ;
		String params = request.getQueryString();
		String facility_id = (String)session.getValue("facility_id");
		String function_id=request.getParameter("function_id");
		String source = url + params;
		String menuParam = "no";
		String SQL = "SELECT DEF_USER_ROLE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
			Connection con = null;
			PreparedStatement pstmt= null;
			ResultSet rst = null;
			String DefaultUserRoleYN="";
			try{
					con = ConnectionManager.getConnection();
					pstmt=con.prepareStatement(SQL);
					pstmt.setString(1,facility_id);
					rst = pstmt.executeQuery();
					while(rst.next()){
						DefaultUserRoleYN = checkForNull(rst.getString(1),"N");
						System.err.println("DefaultUserRoleYN==============="+DefaultUserRoleYN+"======function_id======"+function_id+"====facility_id==="+facility_id);
					}
						int nPos  = source.indexOf("access=");
						if(("OT_MST_ADMN_ROLES_FOR_USER".equals(function_id)  && "N".equals(DefaultUserRoleYN)) )
						{
								source = source.substring(0,nPos+7) + "NN" +  source.substring( nPos+9,source.length() ) ;
								menuParam = "yes";
						}
			}catch(Exception e){
					e.printStackTrace();
					//System.err.println("Err Msg from RoleForUser.jsp "+e);
				}finally{
					if(pstmt!=null)pstmt.close();
					if(con!=null)con.close();
	}
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%>  scrolling='no' noresize frameborder='0' style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  noresize frameborder='0' scrolling='auto' style='height:9vh;width:100vw'></iframe>
		<iframe name='hidden_frame' id='hidden_frame'	src='../../eOT/jsp/CommonMasterObjectCollect.jsp?<%=params%>'  noresize frameborder='0' scrolling='auto' style='height:0vh;width:100vw'></iframe>
	<body onload="hideMenu('<%=menuParam%>')" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form>
		<input type="hidden" name="source" id="source" value="<%=params%>">
		</form>
	</body>
</html
<%
	if(("OT_MST_ADMN_ROLES_FOR_USER".equals(function_id)  && "N".equals(DefaultUserRoleYN)) )
		out.println("<script>alert('')</script>");
		out.println("<script>callAlertFunction('APP-OT0224');</script>");
%>

