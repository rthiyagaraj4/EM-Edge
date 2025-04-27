<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCA/js/CAMainMenu.js' language='javascript'></script>
	<script src='../../eCA/js/MaternityConsTree.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>	
	<script src="../../eCommon/js/common.js" language="javascript"></script> 
</head>
<%

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String module_id =  request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String patient_id =  request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	//Querires to fecth the data
	//String cycle_sql1="SELECT SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC FROM CA_SPLTY_EPISODE_CYCLE_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=?";

	//String cycle_sql2="SELECT CYCLE_NO FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? ORDER  BY 1";

	//String cycle_sql_open="SELECT CYCLE_NO FROM CA_PAT_SPLTY_EPISODE_HDR WHERE PATIENT_ID=? AND  MODULE_ID=? AND CYCLE_STATUS='O' ORDER  BY 1";
	
	//String sql="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_DESC FROM CA_SPLTY_EVENT_LANG_VW WHERE MODULE_ID=? AND LANGUAGE_ID=? AND EFF_STATUS='E' ORDER BY 2";

	String menuSql="SELECT  A.SPLTY_EVENT_CODE,A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,'MAIN' HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE  MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL ORDER BY ORDER_SEQ_NO ";

	String sel_menuSql="SELECT  A.SPLTY_EVENT_CODE,A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,'MAIN' HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE SPLTY_EVENT_CODE=?  AND MODULE_ID=?  AND HEADER_SPLTY_TASK_CODE IS NULL ORDER BY ORDER_SEQ_NO";

	String hdquerySQL="SELECT A.SPLTY_TASK_CODE,CA_GET_DESC.CA_SPLTY_TASKS( A.SPLTY_TASK_CODE,?,'1') SPLTY_TASK_DESC,A.ORDER_SEQ_NO,A.NUMB_OF_TRANS_ALLOWED,A.SPLTY_TASK_TYPE,A.EXECUTABLE_NAME,A.ACTION_CODE,A.HEADER_SPLTY_TASK_CODE FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND HEADER_SPLTY_TASK_CODE =? ORDER BY ORDER_SEQ_NO";

	String actionSQL="SELECT A.ACTION_CODE,CASE WHEN A.SPLTY_TASK_TYPE='NT' THEN CA_GET_DESC.CA_NOTE_TYPE(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='CH' THEN CA_GET_DESC.CA_CHART(A.ACTION_CODE,?,'1') WHEN A.SPLTY_TASK_TYPE='TM' THEN CA_GET_DESC.CA_SECTION_HDG(A.ACTION_CODE,?,'1') END SPLTY_TASK_DESC FROM CA_SPLTY_TASKS_FOR_EVENTS_VW A  WHERE SPLTY_EVENT_CODE=? AND MODULE_ID=? AND SPLTY_TASK_CODE =?";

	String dateSQL="SELECT TO_CHAR(TRANS_DATE,'DD/MM/YYYY HH24:MI')TRANS_DATE_STR,ACCESSION_NUM FROM CA_PAT_SPLTY_EPISODE_TASK WHERE PATIENT_ID	=? AND FACILITY_ID	=? AND MODULE_ID=? AND CYCLE_NO=? AND SPLTY_EVENT_CODE =? AND SPLTY_TASK_CODE=?";

	//String eventSQl="SELECT SPLTY_EVENT_CODE,SPLTY_EVENT_STATUS,CA_GET_DESC(SPLTY_EVENT_CODE,?,'1') FROM CA_PAT_SPLTY_EPISODE_EVENT WHERE  PATIENT_ID =? AND MODULE_ID=? AND CYCLE_NO=?";

	//String CYCLE_NO_OPEN=null;
	//int cycle_val=0;
	//String SPLTY_EPISODE_DESC=null;
	//String SPLTY_TITLE_EVENT_DESC=null;
	String facility_id = (String) session.getValue("facility_id");
	int cycle_no=0;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	//main task variables
	String splt_event_code="";
	String splty_task_code="";
	String splty_task_desc="";
	String splty_task_type="";
	String actn_code;
	//String actn_code_desc;
	//sub tasks variables
	String sub_task_code=null;
	String sub_task_desc=null;
	String sub_task_type=null;
	String sub_hd_tsk_code=null;
	String sub_act_code=null;
	String sub_act_desc=null;

	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	PreparedStatement pstmt3 = null;
	Connection con = null;
	ResultSet rs = null,rsMenu=null,rs2=null,rsDate=null;
	//String where_cond="";
	String req_event_code=request.getParameter("req_event_code")==null?"":request.getParameter("req_event_code");

	try{
	con = ConnectionManager.getConnection(request);
	}catch(Exception e){
		e.printStackTrace() ;
	}

%>
<body  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onload="callfunction()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<FORM METHOD=POST ACTION="" name="maternityMenu" id="maternityMenu">
<TABLE width='100%' align='center' border=0 cellspacing=0>

<TR>
	<TD width='50%'>&nbsp;</TD><TD align='right' width='50%'><img src='../../eCommon/images/close-all.gif' onclick="changeTree(this)" id='toggleTreeCollapse' style='display' alt = 'Collapse All'></img>&nbsp;<img src='../../eCommon/images/expand-all.gif' onclick="changeTree(this)" id='toggleTreeExpand' style='display' alt = 'Expand All'></img></TD>
</TR>
</TABLE>
<script>

	var obj;
	obj = new dTree('obj');
	obj.add(0,-1,'<font size=2 style=font-weight:bold style=color:#333>'+getLabel("Common.menu.label","common")+'</font>');
	obj.config.useStatusText=true;
	obj.add('OBGSTATUS','0','OBG STATUS','','OBG STATUS','','','','','R');

<%
try{
	//String date="";
	if(req_event_code.equals("")){
	pstmt=con.prepareStatement(menuSql);
	pstmt.setString(1,locale);
	pstmt.setString(2,module_id);
	rsMenu=pstmt.executeQuery();
	while(rsMenu.next()){
		splt_event_code=rsMenu.getString(1);
		splty_task_code=rsMenu.getString(2);
		splty_task_desc=rsMenu.getString(3); 
		splty_task_type=rsMenu.getString(6); 
		actn_code=rsMenu.getString(8);
%>
	obj.add('<%=splty_task_code%>','OBGSTATUS','<%=splty_task_desc%>','','<%=splty_task_desc%>','','','','','R');
<%
	if(splty_task_type.equals("HD")){
	pstmt1=con.prepareStatement(hdquerySQL);
	pstmt1.setString(1,locale);
	pstmt1.setString(2,splt_event_code);
	pstmt1.setString(3,module_id);
	pstmt1.setString(4,splty_task_code);
	rs	  =pstmt1.executeQuery();
	while(rs.next()){
	sub_task_code=rs.getString(1);
	sub_task_desc=rs.getString(2);
	sub_task_type=rs.getString(5);
	sub_hd_tsk_code=rs.getString(8);
	%>
	obj.add('<%=sub_task_code%>','<%=splty_task_code%>','<%=sub_task_desc%>','','<%=sub_task_code%>','','','','','R');
	<%
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);	
	rs2	  =pstmt2.executeQuery();
	while(rs2.next()){
	sub_act_code=rs2.getString(1);
	sub_act_desc=rs2.getString(2);
	%>
	obj.add('<%=sub_act_code%>','<%=sub_task_code%>','<%=sub_act_desc%>','','<%=sub_act_code%>','','','','','R');
	<%}
	if(rs2!=null)
	rs2.close();
	if(pstmt2!=null)
	pstmt2.close();
	}
	if(rs!=null)
	rs.close();
	if(pstmt1!=null)
	pstmt1.close();
}else{
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs	  =pstmt2.executeQuery();
	while(rs.next()){
		sub_act_code=rs.getString(1);
		sub_act_desc=rs.getString(2);
	%>
	obj.add('<%=sub_act_code%>','<%=splty_task_code%>','<%=sub_act_desc%>','','<%=sub_act_code%>','','','','','R');
	<%
	try{
	pstmt3=con.prepareStatement(dateSQL);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,facility_id);
	pstmt3.setString(3,module_id);
	pstmt3.setInt(4,cycle_no);
	pstmt3.setString(5,splt_event_code);
	pstmt3.setString(6,splty_task_code);
	rsDate=pstmt3.executeQuery();
	while(rsDate.next()){
	}
	if(rsDate!=null)
		rsDate.close();
	if(pstmt3!=null)
		pstmt3.close();
	}catch(Exception e){
	e.printStackTrace() ;
	}
	}
	if(rs!=null)
	rs.close();
	if(pstmt2!=null)
	pstmt2.close();
}
}
if(rsMenu!= null) rsMenu.close();
if(pstmt!=null) pstmt.close();
}else{//if event is selected....
	pstmt=con.prepareStatement(sel_menuSql);
	pstmt.setString(1,locale);
	pstmt.setString(2,req_event_code);
	pstmt.setString(3,module_id);
	rsMenu=pstmt.executeQuery();
	while(rsMenu.next()){
		splt_event_code=rsMenu.getString(1);
		splty_task_code=rsMenu.getString(2);
		splty_task_desc=rsMenu.getString(3);
		splty_task_type=rsMenu.getString(6);
		actn_code=rsMenu.getString(8);

%>
	obj.add('<%=splty_task_code%>','OBGSTATUS','<%=splty_task_desc%>','','<%=splty_task_desc%>','','','','','R');
<%
	if(splty_task_type.equals("HD")){
	pstmt1=con.prepareStatement(hdquerySQL);
	pstmt1.setString(1,locale);
	pstmt1.setString(2,splt_event_code);
	pstmt1.setString(3,module_id);
	pstmt1.setString(4,splty_task_code);
	rs	  =pstmt1.executeQuery();
	while(rs.next()){
	sub_task_code=rs.getString(1);
	sub_task_desc=rs.getString(2);
	sub_task_type=rs.getString(5);
	sub_hd_tsk_code=rs.getString(8);
	%>
	obj.add('<%=sub_task_code%>','<%=splty_task_code%>','<%=sub_task_desc%>','','<%=sub_task_code%>','','','','','R');
	<%
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs2	  =pstmt2.executeQuery();
	while(rs2.next()){
	sub_act_code=rs2.getString(1);
	sub_act_desc=rs2.getString(2);
	%>
	obj.add('<%=sub_act_code%>','<%=sub_task_code%>','<%=sub_act_desc%>','','<%=sub_act_code%>','','','','','R');
	<%}
	if(rs2!=null)
	rs2.close();
	if(pstmt2!=null)
	pstmt2.close();
	}
	if(rs!=null)
	rs.close();
	if(pstmt1!=null)
	pstmt1.close();
}else{
	pstmt2=con.prepareStatement(actionSQL);
	pstmt2.setString(1,locale);
	pstmt2.setString(2,locale);
	pstmt2.setString(3,locale);
	pstmt2.setString(4,splt_event_code);
	pstmt2.setString(5,module_id);
	pstmt2.setString(6,splty_task_code);
	rs	  =pstmt2.executeQuery();
	while(rs.next()){
		sub_act_code=rs.getString(1);
		sub_act_desc=rs.getString(2);
	%>
	obj.add('<%=sub_act_code%>','<%=splty_task_code%>','<%=sub_act_desc%>','','<%=sub_act_code%>','','','','','R');
	<%//query the transactio dates and paint them
	try{
	pstmt3=con.prepareStatement(dateSQL);
	pstmt3.setString(1,patient_id);
	pstmt3.setString(2,facility_id);
	pstmt3.setString(3,module_id);
	pstmt3.setInt(4,cycle_no);
	pstmt3.setString(5,splt_event_code);
	pstmt3.setString(6,splty_task_code);
	rsDate=pstmt3.executeQuery();
	while(rsDate.next()){
//here to paint the transactions dates
	}
	if(rsDate!=null)
		rsDate.close();
	if(pstmt3!=null)
		pstmt3.close();
	}catch(Exception e){
	e.printStackTrace() ;
	}
	}
	if(rs!=null)
	rs.close();
	if(pstmt2!=null)
	pstmt2.close();
}
	}//end rsMenu 
  }//end of else
 }//end of try

	catch(Exception e)
	{
		//out.println("Error while gettting the menu: "+e);//COMMON-ICN-0181
           e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try
		{
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
			
			if(con!= null) ConnectionManager.returnConnection(con,request);
		}
		catch(Exception e)
		{
			//out.println("Exception in CAMainMenu.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}
	%>


			document.write(obj);
			obj.openAll();

	</script>
	<input type=hidden name='req_event_code' id='req_event_code' value='<%=req_event_code%>'>
	<input type=hidden name='module_id' id='module_id' value='<%=module_id%>'>
	<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'>
	<input type=hidden name='queryString' id='queryString' value='<%=queryString%>'>
	
</FORM>
</body>
</html>

