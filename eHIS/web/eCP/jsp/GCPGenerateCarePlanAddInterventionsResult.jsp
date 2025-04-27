<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Subbulakshmy. K
*	Created On		:	06/05/2005
* --%>
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>

<html>
<head>
<%
//This file is saved on 18/10/2005.
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script language="JavaScript" src="../../eCP/js/GCPGenerateCarePlan.js"></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	

	String goal_code = request.getParameter("goal_code")==null?"":request.getParameter("goal_code");
	String library_id = request.getParameter("library_id")==null?"":request.getParameter("library_id");
	String version_no = request.getParameter("version_no")==null?"":request.getParameter("version_no");
	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
	String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
	String target_date = request.getParameter("target_date")==null?"":request.getParameter("target_date");

	//String 	intervention_code = "";
	HashMap select_intvn = null;
	select_intvn = bean.getSelectedIntvn();
	//Set s=select_intvn.keySet();
	//Collection ccc = select_intvn.values();
	String tmp_key="#"+ library_id+","+version_no+","+term_set_id+","+term_code;
	String record[]=null;
	String temp_inter_code = tmp_key+","+goal_code+",";
	String temp_code =(String)select_intvn.get(temp_inter_code)== null?"":(String)select_intvn.get(temp_inter_code);
	ArrayList intvn_Code = new ArrayList();
	ArrayList group_Id = new ArrayList();
	int index=0;
%>
<body>
<form name='GCPAddinterventionResult' id='GCPAddinterventionResult'>
<table border=0 cellspacing='0' cellpadding='0' width='100%'><tr>
	<th width='*' align='center'><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></td>
	<th width='5' ><fmt:message key="Common.Remove.label" bundle="${common_labels}"/></td>
	</td>
	</tr>
<%
	if(temp_code.equals("~"))
		temp_code="";
	if(!temp_code.equals("")){
		//index = temp_code.indexOf(",");
//		String temp=temp_code.substring(index+1, temp_code.indexOf("~")+1);
		String temp=temp_code;
		index=0;
		while(index<temp.length()){
			intvn_Code.add(temp.substring(0, temp.indexOf('*')));
			group_Id.add(temp.substring(temp.indexOf('*')+1, temp.indexOf('*')+2));
			index=temp_code.indexOf('|');
			if(temp_code.indexOf('~')>(index+1)){
				temp_code=temp_code.substring(index+1);
				temp=temp_code.substring(0, temp_code.indexOf('|'));
			}
			else 
				temp="";
			index=0;
		}
		temp_code="";
		for(int i=0; i<intvn_Code.size();i++){
			if(temp_code.equals(""))
				temp_code="\'"+intvn_Code.get(i)+"\',";
			else
				temp_code=temp_code+"\'"+intvn_Code.get(i)+"\',";
		}
		temp_code=temp_code.substring(0,temp_code.length()-1);
	}
	Connection con = null;
	PreparedStatement pstmt_intvn_desc = null;
	ResultSet rs_intvn_desc= null;
	intvn_Code=new ArrayList();
	String sql_intvn_desc="select intervention_code, short_desc from ca_intervention where intervention_code in("+temp_code+") order by short_desc";

	try{
		if(!temp_code.equals("")){
			con =ConnectionManager.getConnection(request);
			pstmt_intvn_desc = con.prepareStatement(sql_intvn_desc);

			rs_intvn_desc = pstmt_intvn_desc.executeQuery();

			while(rs_intvn_desc!=null && rs_intvn_desc.next()){
				record=new String[2];
				record[0] = rs_intvn_desc.getString("intervention_code");
				record[1] = rs_intvn_desc.getString("short_desc");
				intvn_Code.add(record);
			}
			if(pstmt_intvn_desc !=null)
				pstmt_intvn_desc.close();
			if(rs_intvn_desc!=null)
				rs_intvn_desc.close();
		}
		if(intvn_Code.size()>0){
			for(int i=0;i<intvn_Code.size(); i++){
				record=(String[])intvn_Code.get(i);
%>
				<tr style='display:inline' id='intvn<%=i%>'><td class='label'  width='*' id='intvn_desc<%=i%>'><%=record[1]%></td>
				<input type='hidden' name='intvn_code<%=i%>' id='intvn_code<%=i%>' value='<%=record[0]%>'>
				<input type='hidden' name='intvn_groupID<%=i%>' id='intvn_groupID<%=i%>' value='<%=group_Id.get(i)%>'>		
				<td width='5' align='center'><INPUT TYPE="checkbox" name="intvn_chk<%=i%>" id="intvn_chk<%=i%>" checked onclick='addRemoveIntvn("<%=i%>","<%=library_id%>","<%=version_no%>","<%=term_set_id%>","<%=term_code%>","<%=goal_code%>","<%=target_date%>");'>
<%
			}
		}

		for(int i=intvn_Code.size();i<10; i++){
%>
			<tr style='display:none' id='intvn<%=i%>'><td class='label'  width='*' id='intvn_desc<%=i%>'></td>
			<input type='hidden' name='intvn_code<%=i%>' id='intvn_code<%=i%>' value=''>
			<input type='hidden' name='intvn_groupID<%=i%>' id='intvn_groupID<%=i%>' value=''>
			
			<td width='5' align='center'><INPUT TYPE="checkbox" name="intvn_chk<%=i%>" id="intvn_chk<%=i%>" onclick='addRemoveIntvn("<%=i%>","<%=library_id%>","<%=version_no%>","<%=term_set_id%>","<%=term_code%>","<%=goal_code%>","<%=target_date%>");'>
<%
		}
%>
		<input type='hidden' name='intvn_count' id='intvn_count' value='<%=intvn_Code.size()%>'>
	</table>
	</form>
</body>
<%
	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(pstmt_intvn_desc !=null)
			pstmt_intvn_desc.close();
		if(rs_intvn_desc!=null)
			rs_intvn_desc.close();
		if(con != null) 
			ConnectionManager.returnConnection(con);
	}
%>
</html>

