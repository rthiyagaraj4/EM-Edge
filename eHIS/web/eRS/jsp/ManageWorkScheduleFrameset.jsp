<!DOCTYPE html>
<%
/*
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	ManageWorkSheduleFrameset.jsp
*	Purpose 			:
*	Created By		:	Subbulakshmy. K
*	Created On		:	17-12-2004
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
String p_mode = request.getParameter("p_mode")==null?"":request.getParameter("p_mode");
String mode	  = request.getParameter("mode")==null?"":request.getParameter("mode");
String function_id = request.getParameter( "function_id") ==null?"":request.getParameter("function_id");
String queryString = request.getQueryString();
String workplace_desc="";

if(p_mode.equals("CA"))
{
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	PreparedStatement pstmt_currdate 	= null;

	ResultSet resultSet 		= null;
	ResultSet rs_currdate 		= null;

	String facility_id = (String)session.getAttribute("facility_id")==null?"":(String)session.getAttribute("facility_id");
	String user_id = (String)session.getValue("login_user")==null?"":(String)session.getAttribute("login_user");
	String p_locn_type = request.getParameter( "p_locn_type") ==null?"":request.getParameter("p_locn_type");
	String p_locn_code = request.getParameter( "p_locn_code") ==null?"":request.getParameter("p_locn_code");
	String from_date="", to_date="";
	String sql_wrkplace="";
	String workplace_code="";
	boolean flag=false;

	//to get the wrkplace code
	if(p_locn_type.equals("IP") || p_locn_type.equals("DC")){
		sql_wrkplace="select workplace_code from rs_locn_for_workplace where facility_id = ? and locn_code = (select nursing_unit_code  from ip_nursing_unit	  where facility_id = ? and nursing_unit_code = ?)";
		flag=true;
	}
	else 
		if(p_locn_type.equals("OP") || p_locn_type.equals("EM")){
			sql_wrkplace="select workplace_code  from rs_locn_for_workplace where facility_id = ? and locn_code = (select clinic_code from op_clinic where facility_id = ? and clinic_code = ?)";
			flag=true;
	}
	conn = ConnectionManager.getConnection(request);
	try {
		if(flag){
			pstmt = conn.prepareStatement( sql_wrkplace);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,p_locn_code);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				workplace_code = resultSet.getString("workplace_code")==null?"":resultSet.getString("workplace_code");
			}
			if(pstmt!=null)
				pstmt.close();
			if(resultSet!=null)
				resultSet.close();
		}
		//to get the workplace description
		if(!workplace_code.equals("")){
			//String sql_workplace_desc="select workplace_desc  from rs_workplace where facility_id = ? and workplace_code = ?";
			String sql_workplace_desc="select workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code = ? and language_id = ?";
			pstmt = conn.prepareStatement( sql_workplace_desc);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,workplace_code);
			pstmt.setString(3,locale);
			resultSet = pstmt.executeQuery() ;
			while (resultSet != null && resultSet.next()) {
				workplace_desc = resultSet.getString("workplace_desc")==null?"":resultSet.getString("workplace_desc");
			}
			if(pstmt!=null)
				pstmt.close();
			if(resultSet!=null)
				resultSet.close();
		}
		pstmt_currdate=conn.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') from_date, to_char(trunc(sysdate)+30,'dd/mm/yyyy') to_date from dual ");
		rs_currdate=pstmt_currdate.executeQuery();
		rs_currdate.next();
		from_date = rs_currdate.getString("from_Date");
		to_date = rs_currdate.getString("to_date");
		if(pstmt_currdate!=null)
			pstmt_currdate.close();
		if(rs_currdate!=null)
			rs_currdate.close();
	}catch(Exception e){
		e.printStackTrace() ;
	}
	finally{
		pstmt_currdate.close();
		pstmt.close() ;

		resultSet.close() ;
		rs_currdate.close();
		ConnectionManager.returnConnection(conn,request);
	}	queryString="user_id="+user_id+"&locn_type="+p_locn_type+"&workplace_code="+workplace_code+"&workplace_desc="+workplace_desc+"&from_date="+from_date+"&to_date="+to_date+"&new_to_date="+to_date+"&new_from_date="+from_date+"&facility_id="+facility_id+"&p_mode="+p_mode+"&mode="+mode+"&function_id"+function_id+"&onclick_of=S"+"&producive_flag=W"+"&DAYS=14";
}
else
workplace_desc=request.getParameter("workplace_desc")==null?"":request.getParameter("workplace_desc");
%>
<html>
<head>
<title><fmt:message key="eRS.ManageWorkSchedule.label" bundle="${rs_labels}"/> -- <%=workplace_desc%></title>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eRS/js/ManageWorkSchedule.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</head>
<iframe name="frameManageWorkScheduleBtn" id="frameManageWorkScheduleBtn" src='../../eRS/jsp/ManageWorkScheduleBtn.jsp?<%=queryString%>' frameborder=0 scrolling="no" noresize style='height:4vh;width:100vw'></iframe>
<iframe name="frameManageWorkScheduleHdr" id="frameManageWorkScheduleHdr" src='../../eCommon/html/blank.html' frameborder=0  noresize style='height:38vh;width:100vw'></iframe> 
<iframe name="frameManageWorkScheduleResult" id="frameManageWorkScheduleResult" src='../../eCommon/html/blank.html' frameborder=0 noresize  style='height:58vh;width:100vw'></iframe>
</html>

