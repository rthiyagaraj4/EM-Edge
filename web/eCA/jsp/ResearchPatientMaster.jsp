<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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

		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/ResearchPatientMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String mode = "";
		String disl = "";
		String research_categ_id = "";
		String research_categ_desc = "";
		String eff_status = "";
		String enabled_checked = "";
		StringBuffer sql =new StringBuffer();
		String chk_disl = "";

		mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
		research_categ_id = (request.getParameter("research_categ_id")==null)?"":request.getParameter("research_categ_id");
		if(mode=="insert" || mode.equals("insert")) {
			enabled_checked = "checked";
		}else{
			mode = "modify";
		}
		try{
			con=ConnectionManager.getConnection(request);
			if(mode.equals("insert")){
			}else 
			if(mode.equals("modify")){
					disl="disabled";
					sql.append("select research_categ_id,research_categ_desc,eff_status from ca_research_category");
					//sql.append(" where research_categ_id='"+research_categ_id+"'");//common-icn-0180
					sql.append(" where research_categ_id=?");//common-icn-0180
					stmt=con.prepareStatement(sql.toString());
					stmt.setString(1, research_categ_id);//common-icn-0180
					rs=stmt.executeQuery();
					if(rs!=null){
						while(rs.next()){
							research_categ_desc= rs.getString("research_categ_desc");
							if(research_categ_desc==null || research_categ_desc.equals(""))	research_categ_desc="";

							eff_status = rs.getString("eff_status");
							if(eff_status==null )	
								eff_status="";
							if(eff_status.equals("E")){
								enabled_checked="checked";
								chk_disl="";
							}else{
								enabled_checked="";
								chk_disl="disabled";
							}
						}
					}
			}
		
			if(rs!=null) 	rs.close();
			if(stmt!=null)  stmt.close();
		}catch(Exception e){ 
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		 }finally{
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
		%>
	</head>
	<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()" class='CONTENT'>
		<form name='ResearchPatientMasterfrm' id='ResearchPatientMasterfrm' action="../../servlet/eCA.ResearchPatientMasterServlet" method="post" target="messageFrame">
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<table border=0 cellpadding=3 cellspacing=0 width='80%' align=center >
				<tr>
					<td class="Label"><fmt:message key="eCA.ResearchCategoryID.label" bundle="${ca_labels}"/></td>
					<td class ='fields'><input type="text" name="research_categ_id" id="research_categ_id" value="<%=research_categ_id%>" <%=disl%> size=10 maxlength=10 OnKeyPress ="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr>
					<td class="Label" ><fmt:message key="eCA.ResearchCategoryDescription.label" bundle="${ca_labels}"/></td>
					<td class ='fields' ><input type="text" name="research_categ_desc" id="research_categ_desc" 	value="<%=research_categ_desc%>" <%=chk_disl%> size=30 maxlength=30 onblur="assign_desc()" OnKeyPress ="return CheckSpecChar(event)"><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr>
					<td class="Label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td class ='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%>  onClick="AssignCheck(this)"></td>
				</tr>
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'></input>
			<input type='hidden' name='research_categ_id1' id='research_categ_id1' value='<%=research_categ_id%>'></input>
			<input type='hidden' name='research_categ_desc1' id='research_categ_desc1' value='<%=research_categ_desc%>'></input>
		</form>
	</body>
</html>

