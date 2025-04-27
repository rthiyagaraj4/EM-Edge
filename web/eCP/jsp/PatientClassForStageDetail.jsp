<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link><script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../js/PatientClassForStage.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="PatientClassForStageDetail_Form" id="PatientClassForStageDetail_Form" action='../../servlet/eCP.PatientClassForStageServlet' method='POST' target='messageFrame'>
 <%
	String stage_code = request.getParameter("stage_code");
	if(stage_code==null){ 
	stage_code = "";}
		
	String[] record=null;
	String stagesql="";
	String db_action="";
	String classvalue="";
	String select="";
	String checked="";
	Connection conn=null;
	//Statement stagestmt=null;
    PreparedStatement pstmt	= null;
	ResultSet stagers=null;
	ArrayList StageList=new ArrayList();
	try
	{
		conn = ConnectionManager.getConnection(request);
		//stagesql="select patient_class, long_desc patient_class_desc,'I' db_action from am_patient_class where patient_class not in (select patient_class from cp_pat_class_for_stage where stage_code = '"+stage_code+"') union all select a.patient_class patient_class,b.long_desc patient_class_desc, 'U' db_action from cp_pat_class_for_stage a, am_patient_class b where a.stage_code = '"+stage_code+"' and b.patient_class = a.patient_class order by patient_class ";
		//stagesql="select patient_class, long_desc patient_class_desc,'I' db_action from am_patient_class where patient_class not in (select patient_class from cp_pat_class_for_stage where stage_code = ?) union all select a.patient_class patient_class,b.long_desc patient_class_desc, 'U' db_action from cp_pat_class_for_stage a, am_patient_class b where a.stage_code = ? and b.patient_class = a.patient_class order by patient_class ";
		stagesql="SELECT patient_class, long_desc patient_class_desc,'I' db_action FROM am_patient_class_lang_vw WHERE patient_class NOT IN (SELECT patient_class FROM cp_pat_class_for_stage WHERE stage_code = ?)   AND language_id = ? UNION ALL SELECT a.patient_class patient_class,b.long_desc patient_class_desc, 'U' db_action FROM cp_pat_class_for_stage a, am_patient_class_lang_vw b WHERE a.stage_code = ? AND b.patient_class = a.patient_class AND b.language_id = ? ORDER BY patient_class ";
		
		//stagestmt = conn.createStatement();
		pstmt = conn.prepareStatement( stagesql);
		pstmt.setString(1,stage_code);
		pstmt.setString(2,locale);
		pstmt.setString(3,stage_code);
		pstmt.setString(4,locale);
		stagers = pstmt.executeQuery();
		if(stagers!=null)
		{
		while(stagers.next())
		{	
			record=new String[4];
			record[0]=stagers.getString(1);
			record[1]=stagers.getString(2);
			record[2]=stagers.getString("db_action");
			record[3] = stagers.getString("patient_class_desc");
			StageList.add(record);
		}
		}
	} catch ( Exception e )	
			{
				e.printStackTrace();
				throw e ;
			} finally 
				{
					stagers.close() ;
					pstmt.close() ;
					ConnectionManager.returnConnection(conn,request);
					conn.close();
				}
		int totalRecords=StageList.size();
if(totalRecords == 0)
		{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
else{
%>
<table align='center' cellspacing='0' cellpadding='0' border='1' width='90%'>
<tr>
<th align='center'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
<th align='center'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
<%
	for(int i=0;i<StageList.size();i++)
	{
	if(i%2==0) 
				classvalue="QRYEVEN";
			else 
				classvalue="QRYODD";
			record=(String[])StageList.get(i);
			db_action=record[2];
				if(db_action.equals("U")){
					checked="checked";
					select="Y";
				}
				else if(db_action.equals("I"))
			    {
					checked="";
					select="N";
				}
%>
<tr>
<input type='hidden' name='patient_class<%=i%>' id='patient_class<%=i%>' value='<%=record[0]%>'>
<input type='hidden' name='db_action<%=i%>' id='db_action<%=i%>' value='<%=db_action%>'>
<td align='left' class=<%=classvalue%>><%=record[3]%></td>
<td align='center' class=<%=classvalue%>><input type="checkbox" name='select_yn<%=i%>' id='select_yn<%=i%>' value='<%=select%>' <%=checked%>></td>
</tr>
<%}%>
</table>
<input type='hidden' name='stage_code' id='stage_code' value='<%=stage_code%>'>
<input type='hidden' name='total_records' id='total_records' value='<%=totalRecords%>'>
<%}%>
</form>
</body>
</html>

