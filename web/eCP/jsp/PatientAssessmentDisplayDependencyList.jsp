<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" language="java" import="org.w3c.dom.*,java.sql.*, webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<body onmousedown = 'CodeArrest()'>
		<form name='patAssessmentDependencyScore' id='patAssessmentDependencyScore'>
			<table width='100%' cellpadding='0' cellspacing='0' border='0'>
				<tr>
					<th width='80%' style="font-size:10;" align='left'>
						<fmt:message key="Common.Dependency.label" bundle="${common_labels}"/>
					</th>
					<th width='17%' style="font-size:10;" align='left'>
					<fmt:message key="eCP.CutOff.label" bundle="${cp_labels}"/>
					</th>
					<th width='3%'>&nbsp;
					</th>
				</tr>
<%
	Connection con	= null;
	PreparedStatement PrepStmt_DepStrSql =null;
	ResultSet Rs_DepStrSql=null;
	String note_type	= (request.getParameter("note_type")==null)?"":request.getParameter("note_type");
	String dep_desc="", min_score="";
	if(!note_type.equals("")){
		try
		{
			con	= ConnectionManager.getConnection(request);
			String Str_DepScrSql="select a.assess_note_id, a.dependency_code, b.long_desc dep_desc, a.min_score min_score from cp_trgd_dep_clsfn_at_assmt a, cp_dependency_lang_vw b where a.assess_note_id=? and a.dependency_code=b.dependency_code and b.language_id=? order by min_score";
			PrepStmt_DepStrSql = con.prepareStatement(Str_DepScrSql);
			PrepStmt_DepStrSql.setString(1,note_type);
			PrepStmt_DepStrSql.setString(2,locale);
			Rs_DepStrSql=PrepStmt_DepStrSql.executeQuery();

			while(Rs_DepStrSql!=null && Rs_DepStrSql.next()){
				dep_desc=Rs_DepStrSql.getString("dep_desc");
				min_score=Rs_DepStrSql.getString("min_score");
%>
				<tr>
					<td class='label' >
						<%=dep_desc%>
					</td>
					<td class='label' align='right'>
						<%=min_score%>
					</td>
					<td >&nbsp;
					</td>
				</tr>
<%
			}
			if(Rs_DepStrSql != null){
				Rs_DepStrSql.close();
			}
			if(PrepStmt_DepStrSql != null){
				PrepStmt_DepStrSql.close();
			}
		}
		catch(Exception e){
			out.println("Exception : "+e);
		}
		finally{
			if(Rs_DepStrSql != null){
				Rs_DepStrSql.close();
			}
			if(PrepStmt_DepStrSql != null){
				PrepStmt_DepStrSql.close();
			}
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	}
%>
				</table>
			</form>
		</body>
</html>

