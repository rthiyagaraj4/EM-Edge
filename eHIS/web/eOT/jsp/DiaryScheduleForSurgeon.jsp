<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Types,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<html>
	<head>
	<script language='JavaScript' src='../../eCommon/js/ValidateControl.js'></script>
 	<script language='javascript' src='../../eOT/js/DairyScheduleForSuregon.js'></script>
 	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript">
	//046233 - To change the Menu label in Toolbar when left frame expands:
	function hideMenu(menuParam)
	{
		if(menuParam == "yes")
			commontoolbarFrame.document.forms[0].home.value = "<fmt:message key='Common.hideMenu.label' bundle='${common_labels}'/>";
		
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String facility_id = (String)session.getValue("facility_id");
		String function_id=request.getParameter("function_id");
		String menuParam = "no";
	String SQL = "SELECT DIARY_SCHED_FOR_SURG_REQD_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String diaryScheduleForSurgeonReqdYN="";
	try{
			con = ConnectionManager.getConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				diaryScheduleForSurgeonReqdYN = checkForNull(rst.getString(1),"N");
			}
			//[046233] start
			int nPos  = source.indexOf("access=");
			/*				
			if(("OT_MST_CODE_DIARY_SCH_SURGEON".equals(function_id)  && "N".equals(diaryScheduleForSurgeonReqdYN)) ){
				source = source.substring(0,nPos+7) + "N" +  source.substring( nPos+8,source.length() ) ;
			}else if (("OT_MST_CODE_DIARY_SCH_THEATRE".equals(function_id)  && "Y".equals(diaryScheduleForSurgeonReqdYN)) ){
				source = source.substring(0,nPos+7) + "N" +  source.substring( nPos+8,source.length() ) ;
			}*/
			// To enable/disable the Create and Apply access from the respective page[surgeon or Theatre] based on OT Parameter for facility:
			if(("OT_MST_CODE_DIARY_SCH_SURGEON".equals(function_id)  && "N".equals(diaryScheduleForSurgeonReqdYN)) ){
				source = source.substring(0,nPos+7) + "NN" +  source.substring( nPos+9,source.length() ) ;
				menuParam = "yes";
			}else if (("OT_MST_CODE_DIARY_SCH_THEATRE".equals(function_id)  && "Y".equals(diaryScheduleForSurgeonReqdYN)) ){
				source = source.substring(0,nPos+7) + "NN" +  source.substring( nPos+9,source.length() ) ;
				menuParam = "yes";
			}
			//[046233]  end
		}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg from DiaryScheduleForSurgeon.jsp "+e);
	}finally{
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}
	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' frameborder='0' style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html'  noresize frameborder='0' scrolling='auto' style='height:83vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp?<%=params%>'  noresize frameborder='0' scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body onload="hideMenu('<%=menuParam%>')" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	<form>
	<input type="hidden" name="source" id="source" value="<%=params%>">
	</form>
	</body>
</html>

<%
	if(("OT_MST_CODE_DIARY_SCH_SURGEON".equals(function_id)  && "N".equals(diaryScheduleForSurgeonReqdYN)) ){
		out.println("<script>callAlertFunction('APP-OT0122')</script>");
	}else if (("OT_MST_CODE_DIARY_SCH_THEATRE".equals(function_id)  && "Y".equals(diaryScheduleForSurgeonReqdYN)) ){
			out.println("<script>callAlertFunction('APP-OT0127')</script>");
	}
%>

