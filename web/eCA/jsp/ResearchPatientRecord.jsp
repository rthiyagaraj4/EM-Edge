<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
06/12/2012   IN030466     Karthi L		CRF-025 Based on the access rights, practitioner can Record and update the Clinical Studies content in CA Patient Chart Menu	
22/10/2013   IN029866 	  Nijitha S		CA>Clinical Studies>System does not display the Remarks in Thai screen.		
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page language="java" import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src="../../eCA/js/ResearchPatient.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css">
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<!--		<script src='../js/DateValidation.js' language='javascript'></SCRIPT> -->
		<script language='javascript' src='../../eCA/js/DateCheck.js'>  </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	
	<%
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
				
		Connection con=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		String patient_id = "";
		String research_categ_id = "";
		String research_categ_desc = "";
		String research_id = "";
		String close_date1 = "";
		String remarks1 ="";
		String research_categ_fact_id1 =""; // added for CRF-025 IN030466
		String practitioner_id =""; // added for CRF-025 IN030466
		String research_categ_fact_desc = ""; // added for CRF-025 IN030466
		
		practitioner_id = (String)session.getValue("ca_practitioner_id");// added for CRF-025IN030466
		//String remarks = "";
		//String start_date = "";
		//String close_date = "";
	
		String modify_disl = "";
		String img_vis = "";
		String mode ="";
		String chk_val ="";
		String currentdate1 = "";
		String currentdate = "";
		//String chk_disl = "";
		try
		{	
			patient_id = request.getParameter("patient_id")==null ? "" : request.getParameter("patient_id");
			mode = request.getParameter("mode")==null ? "" : request.getParameter("mode");
			if(mode.equals("modify")) mode = "modify";
			else
				mode = "insert";
			con	= ConnectionManager.getConnection(request);

			currentdate1		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			currentdate			= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			
			if(mode.equals("insert"))
			{
				chk_val="D";
				img_vis = "display:none";
			}

			if(mode.equals("modify"))
			{
				modify_disl		= "disabled";
				research_id		= (request.getParameter("research_categ_id")==null)?"":request.getParameter("research_categ_id");
				currentdate1	= (request.getParameter("start_date")==null)?"":request.getParameter("start_date");
				close_date1		= (request.getParameter("close_date")==null)?"":request.getParameter("close_date");
				research_categ_fact_id1		= (request.getParameter("research_categ_fact_id")==null)?"":request.getParameter("research_categ_fact_id");// added for CRF-025
				research_categ_fact_desc	= (request.getParameter("research_categ_fact_desc")==null)?"":request.getParameter("research_categ_fact_desc");// added for CRF-025		
				if(close_date1.equals("N") || close_date1 == null)
				{
					chk_val="D";
					close_date1 = "";
					img_vis = "display:none";
				}
				else
				{
					chk_val="E";
					img_vis = "display";
				}

				if(!currentdate1.equals("&nbsp;") )
					currentdate1 = com.ehis.util.DateUtils.convertDate(currentdate1,"DMY","en",locale);

				if(!close_date1.equals("&nbsp;") )
					close_date1 = com.ehis.util.DateUtils.convertDate(close_date1,"DMY","en",locale);
				
				//String research_sql = "select remarks from ca_research_patient_detail where research_categ_id = ? and patient_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY')"; commented for CRF-025
				//String research_sql = "select remarks from ca_research_patient_detail where research_categ_id = ? and patient_id = ? and start_date = TO_DATE(?,'DD/MM/YYYY') and research_categ_fact_id =?"; // modified for CRF-025- 01/10/2013 //Commented for IN029866
				String research_sql = "select remarks from ca_research_patient_detail where research_categ_id = ? and patient_id = ? and SM_CONVERT_DATE(start_date,?) = TO_DATE(?,'DD/MM/YYYY') and research_categ_fact_id =?"; //IN029866
				stmt1 = con.prepareStatement(research_sql);
				stmt1.setString(1,research_id);
				stmt1.setString(2,patient_id);
				//IN029866 Starts
				stmt1.setString(3,locale);
				//stmt1.setString(3,currentdate1);
				//stmt1.setString(4, research_categ_fact_id1); // added for CRF-025- 01/10/2013
				stmt1.setString(4,currentdate1);
				stmt1.setString(5, research_categ_fact_id1);
				//IN029866 Ends
				rs1=stmt1.executeQuery();

				while(rs1.next())
				{
					remarks1= rs1.getString("remarks");
				}
			}
	%>
	</head>
	<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
		<form name='ResearchPatientRecordfrm' id='ResearchPatientRecordfrm' action="../../servlet/eCA.ResearchPatientRecordServlet" method="post" target="messageFrame">
		<br><br><br><br>
			<table border=0 cellpadding=3 cellspacing=0 width='90%' align=center>
				
				<tr> 
					<td class=label width='25%'><fmt:message key="eCA.ResearchPatientCategory.label" bundle="${ca_labels}"/></td>
					<%
						//String research_cat_sql = "SELECT RESEARCH_CATEG_ID, RESEARCH_CATEG_DESC FROM CA_RESEARCH_CATEGORY WHERE EFF_STATUS ='E'";
						
						String research_cat_sql = "SELECT RESEARCH_CATEG_ID, RESEARCH_CATEG_DESC FROM CA_RESEARCH_CATEGORY_LANG_VW WHERE EFF_STATUS ='E' AND LANGUAGE_ID = ?";

						try
						{	
							stmt = con.prepareStatement(research_cat_sql);
							stmt.setString(1,locale);
							rs = stmt.executeQuery();
					%>
					<td class='fields' width='25%'>	
						
						<select name='research_desc' id='research_desc' <%=modify_disl%> onchange="getResCategRiskFact();msgframereload()"> <!-- CRF025 IN030466 -->
							<option> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
							<%
									while(rs.next())
									{
										research_categ_id = rs.getString("RESEARCH_CATEG_ID");		research_categ_desc = rs.getString("RESEARCH_CATEG_DESC");
									
										if(research_categ_id == null) research_categ_id="";
										if(research_categ_desc == null) research_categ_desc="";
										
										if(research_categ_id.equals(research_id))
										{
											out.println("<option value='"+research_categ_id+"'  selected>"+research_categ_desc+"</option>");
										}
										else
										{
											out.println("<option value='"+research_categ_id+"'  >"+research_categ_desc+"</option>");
										}
									}
								}
								catch(Exception e)
								{
									//out.println("Exception in try2 of ResearchPatientRecord.jsp : "+e.toString());//COMMON-ICN-0181
									e.printStackTrace();//COMMON-ICN-0181
								}
							%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td colspan=2></td>
				</tr>
				<!-- added for CRF 025 - START -->
				<tr>
					<td class=label width='25%'><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/>
					</td><td class='fields' width='25%'>
						<% if(mode.equals("modify")){ 
						%>
						<select style="width:230px" name='res_categ_risk_factor' id='res_categ_risk_factor' <%=modify_disl%> >	
						<% 	out.println("<option value='"+ research_categ_fact_id1 +"'  selected>"+ research_categ_fact_desc +"</option>"); %>
						</select>
						<%}else{%>	
						<select name='res_categ_risk_factor' id='res_categ_risk_factor' <%=modify_disl%> >	
							<option> ------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
						</select>
						<%}
						%>
						<img src='../../eCommon/images/mandatory.gif'>	
					</td>
					<td colspan=2></td>
				</tr>
				<!-- added for CRF 025 - END -->
				<tr>
					<td class=label width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</td><td class='fields' width='30%'>						
					<textarea name='remarks' value="" rows=5 cols=50 value='' onkeyPress='return checkMaxLimit(this,200)' onBlur="SPCheckMaxLen('Complaint Text',this,200,'');Checkrmks(this);" onclick="msgframereload()"><%=remarks1%></textarea><img src='../../eCommon/images/mandatory.gif'>
					</td>
					<td colspan=2></td>
				</tr>
				<tr>
					<td class=label width='25%' ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td><td class='fields' width='25%'>	
					<input type="text" name="start_date" id="start_date" value="<%=currentdate1%>" size=10 maxlength=10 <%=modify_disl%> onblur='CheckCloseDate(this,close_date,"<%=currentdate%>","DMY","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('start_date');" <%=modify_disl%>>
					<img src="../../eCommon/images/mandatory.gif">
					</td>
					
					<td class=label id='research'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td><td class='fields' width='25%'>	
					<input type="text" name="close_date" id="close_date" value="<%=close_date1%>" size=10 maxlength=10  onblur='CheckCloseDate(start_date,this, "<%=currentdate%>","DMY","<%=locale%>");'><input type='image' name='calc' id='calc' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('close_date');">
					<img id='img1' src="../../eCommon/images/mandatory.gif" style='<%=img_vis%>'>
					</td>
					
				</tr>
				<tr>
					<td></td>
					<td colspan="3" align='right'>
					<input type='button' class='button' name='Record' id='Record' onclick='ResearchRecord()' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'>
					</input>
					<input type='button' class='button' name='Clear' id='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='ResearchClear();'>
					<input type='button' class='button' name='Cancel' id='Cancel' onClick='ResearchCancel()' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'>
					</input>
					</td>
				</tr>
			</table>
			<%
		
			if(rs1!=null) rs1.close();
			if(stmt1!=null) stmt1.close();
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Ex in 1s try");
			//out.println("Exception in try :"+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}	
		%>				
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="research_id" id="research_id" value="<%=research_id%>">
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="enabled" id="enabled" value="<%=chk_val%>">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=currentdate%>">
		<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>"><!-- CRF 025 IN030466 -->
		<input type="hidden" name="research_categ_fact_id" id="research_categ_fact_id" value="<%=research_categ_fact_id1%>"><!-- CRF 025 IN030466 -->
		</form>
	</body>
</html>

