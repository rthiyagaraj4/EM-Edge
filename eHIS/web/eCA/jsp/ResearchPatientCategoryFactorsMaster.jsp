<!DOCTYPE html>
 <%@ page import ="java.sql.*, java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
		<script src="../../eCA/js/ResearchPatientCategoryFactors.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String mode = "";
		String disl = "";
		String research_categ_fact_id = "";
		String research_categ_fact_desc = "";
		String eff_status = "E";
		String enabled_checked = "";
		StringBuffer sql =new StringBuffer();
		ArrayList<String> checkedList = new ArrayList<String>();
		mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
		research_categ_fact_id = (request.getParameter("research_categ_fact_id")==null)?"":request.getParameter("research_categ_fact_id");
		if(mode=="insert" || mode.equals("insert")) {
			enabled_checked = "checked";
		}else{
			mode = "modify";
		}
		try{
			con=ConnectionManager.getConnection(request);
			if(mode.equals("insert")){
			}else if(mode.equals("modify")){
						disl="disabled";
						sql.append("SELECT RESEARCH_CATEG_FACT_ID,RESEARCH_CATEG_FACT_DESC,EFF_STATUS FROM  CA_RESEARCH_CATEGORY_FACT");
						//sql.append(" WHERE RESEARCH_CATEG_FACT_ID='"+research_categ_fact_id+"'");//common-icn-0180
						sql.append(" WHERE RESEARCH_CATEG_FACT_ID=?");//common-icn-0180
						stmt=con.prepareStatement(sql.toString());
						stmt.setString(1,research_categ_fact_id);//common-icn-0180
						rs=stmt.executeQuery();
						if(rs!=null){
							while(rs.next()){
								research_categ_fact_desc= rs.getString("research_categ_fact_desc");
								if(research_categ_fact_desc==null || research_categ_fact_desc.equals(""))	research_categ_fact_desc="";
								eff_status = rs.getString("eff_status");
								if(eff_status==null )	
									eff_status="D";
								if(eff_status.equals("E")){
									enabled_checked="checked";
								}else{
									enabled_checked="";
								}
							}
						}
						if(stmt!=null)  stmt.close();
						if(rs!=null) 	rs.close();
						
						//stmt=con.prepareStatement("SELECT RESEARCH_CATEG_ID FROM  CA_RESEARCH_CATEGORY_FACT_DTL WHERE RESEARCH_CATEG_FACT_ID='"+research_categ_fact_id+"'");//common-icn-0180
						stmt=con.prepareStatement("SELECT RESEARCH_CATEG_ID FROM  CA_RESEARCH_CATEGORY_FACT_DTL WHERE RESEARCH_CATEG_FACT_ID=?");//common-icn-0180
						stmt.setString(1,research_categ_fact_id);//common-icn-0180
						rs=stmt.executeQuery();
						if(rs!=null){
							while(rs.next()){
								checkedList.add((String)rs.getString("RESEARCH_CATEG_ID"));
							}
						}
						if(stmt!=null)  stmt.close();
						if(rs!=null) 	rs.close();				
				}
			
		}catch(Exception e){ 
			//out.println(e);//common-icn-0181
		}finally{
					if(con!=null) ConnectionManager.returnConnection(con,request);
		}
		%>
	</head>
	<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()" class='CONTENT'>
		<form name='ResearchPatientCategoryFactorsMasterfrm' id='ResearchPatientCategoryFactorsMasterfrm' action="../../servlet/eCA.ResearchPatientCategoryFactorsMasterServlet" method="post" target="messageFrame">
			<br><br><br><br><br><br><br><br><br><br><br><br>
			<table border=0 cellpadding=3 cellspacing=0 width='80%' align=center > 
				<tr>
					<td class=label><fmt:message key="eCA.ResearchCategoryFactorCode.label" bundle="${ca_labels}"/></td>
					<td class ='fields'><input type="text" name="research_categ_fact_id" id="research_categ_fact_id" value="<%=research_categ_fact_id%>" <%=disl%> size=10 maxlength=10 OnKeyPress ="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eCA.ResearchCategoryFactorDescription.label" bundle="${ca_labels}"/></td>
					<td class ='fields' ><input type="text" name="research_categ_fact_desc" id="research_categ_fact_desc" 	value="<%=research_categ_fact_desc%>"  size=32 maxlength=30   OnKeyPress ="return CheckSpecChar(event)"><img src='../../eCommon/images/mandatory.gif'></td>
				</tr>
				<tr>
					<td class=label valign="top"><fmt:message key="eCA.ResearchPatientCategory.label" bundle="${ca_labels}"/></td>
					<td class ='fields' >
						<table border=0 cellpadding=0 cellspacing=0  width='50%'>
							<tr>
								<td style="width: 200px;" class ='fields'>
									<div style="overflow: auto; width: 200px; height: 80px; border: 1px solid #D5E2E5; padding-left: 5px">	
									<%
									try{
										con=ConnectionManager.getConnection(request);
										stmt=con.prepareStatement("SELECT RESEARCH_CATEG_ID,RESEARCH_CATEG_DESC FROM CA_RESEARCH_CATEGORY WHERE EFF_STATUS='E'");
										rs=stmt.executeQuery();
										if(rs!=null){
											while(rs.next()){
											String researchCategId_ =(String)rs.getString("RESEARCH_CATEG_ID");
											String researchCategDesc_ =(String)rs.getString("RESEARCH_CATEG_DESC");
											String checkedStatus = (checkedList.contains(researchCategId_))?"checked":"";
											out.println("<INPUT TYPE='checkbox' name='Res_Pat_Cate' id='Res_Pat_Cate' value='"+researchCategId_+"' "+checkedStatus+"/>"+researchCategDesc_+"<br>");
											
											}
										}
										if(rs!=null) 	rs.close();
										if(stmt!=null)  stmt.close();
									}catch(Exception e){ 
										out.println(e);
									 }finally{
												if(con!=null) ConnectionManager.returnConnection(con,request);
									}
									%>									
									</div>
								</td>
								<td valign="top">					
									&nbsp;<img src='../../eCommon/images/mandatory.gif'>					
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
					<td class ='fields'><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked%>  onClick="AssignCheck(this)"></td>
				</tr>
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'></input>
			<input type='hidden' name='research_categ_fact_id1' id='research_categ_fact_id1' value='<%=research_categ_fact_id%>'></input>
			<input type='hidden' name='research_categ_fact_select_categ' id='research_categ_fact_select_categ' value=''/>
			<input type='hidden' name='eff_status1' id='eff_status1' value='<%=eff_status%>'/>
		</form>
	</body>
</html>

