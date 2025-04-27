<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*, java.util.*,java.text.*,eOR.Common.*,eCommon.Common.*,eOH.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" %>
<%@ page import ="eOH.*, eOH.Common.*,java.util.ArrayList,java.util.Hashtable,java.util.Map "   %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>

<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../js/OrderSet.js'></script>
 	<script language='javascript' src='../../eOH/js/MTasksLink.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language="javascript" src="../../eOH/js/Hashtable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
    

 </head>
 <jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
	<%
		
		Hashtable hash		= (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash				= (Hashtable)hash.get( "SEARCH" ) ;
		String treatment_code=checkForNull(request.getParameter("treatment_code"));
		String bean_mt_id		= "@MTLinkBean";
		String bean_mt_name	= "eOH.MTLinkBean";
		MTLinkBean mtlink_bean= (MTLinkBean)mh.getBeanObject( bean_mt_id, request, bean_mt_name );
		String taskCode = "";
		String taskDesc = "";
		String seqNo = checkForNull(request.getParameter("seq_no"));
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst=null;
		String strsql="";
		String select_value="Y";

		try{
	    
		strsql="SELECT A.TASK_CODE, (SELECT TASK_DESC FROM OH_TASKS_LANG_VW B WHERE LANGUAGE_ID=? AND B.TASK_CODE = A.TASK_CODE) TASK_DESC, A.SEQ_NO FROM OH_TREATMENT_TASKS A WHERE TRMT_CODE = ? ORDER BY A.SEQ_NO";
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		conn  =  ConnectionManager.getConnection(request);
		pstmt=conn.prepareStatement(strsql);
		pstmt.setString(1,locale);
		pstmt.setString(2,treatment_code);
		rst = pstmt.executeQuery();
		while (rst.next() ){
		taskCode = checkForNull(rst.getString(1));
		taskDesc= checkForNull(rst.getString(2));
		seqNo= checkForNull(rst.getString(3));
		
		mtlink_bean.setCheckedMap( taskCode, taskDesc, seqNo, select_value);
		}
		}catch(Exception e){
				System.err.println("MTasksLinkFrames : "+e);
			}finally{
				try{
					if(rst!=null)	rst.close();
					if(pstmt!=null)	pstmt.close();
					ConnectionManager.returnConnection(conn,request);
				}catch(Exception e){}
			}
	%>
	<iframe name='tab' id='tab' src='../../eOH/jsp/MTLinkComponentDetailTab.jsp?treatment_code=<%=treatment_code%>' frameborder=0 noresize scrolling='no' style='height:30%;width:100vw'></iframe><iframe name='detail' id='detail' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:70%;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<input type="hidden" name="treatment_code" id="treatment_code" value="<%=treatment_code%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</body>
</html>

