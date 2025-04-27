<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
------------------------------------------------------------------------------------------------------------------------------------
?           100				?				created
05/12/2017	IN065683		Ramesh G								After create vaccine category as age specific, System 																			automatically add this vaccine category in manage 																				immunization for all patients.
------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
String categoryId = request.getParameter("categoryId") == null ? "" : request.getParameter("categoryId");
String vaccineId = request.getParameter("vaccineId") == null ? "" : request.getParameter("vaccineId");
String rowCount = request.getParameter("rowCount") == null ? "0" : request.getParameter("rowCount");
rowCount = rowCount.equals("")?"1":rowCount;
Connection con			= null;
PreparedStatement	psmtDType = null;
ResultSet rsDType = null;

String durationDays = "";
String durationType = "";
String mandatory = "";
String default1 = "";
String adhocAgeSpecYN = "N";
String minAge = "";
String maxAge = "";
String ageUnit = "";

String due = "";
String dueType = "";
String elapsed = "";
String elapsedType = "";
String strYears = "";
String strMonths = "";
String strDays = "";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../js/VaccinesForCategory.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

<script>
	var argArray = window.dialogArguments ;
	var fieldLegend     = argArray[0];
	window.document.title=fieldLegend;
	
	
	function popUpClose()
	{
		const dialogTag =parent.document.getElementById("dialog_tag");
	          dialogTag.close();
	}
	
</script>

</head>
<body   OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" >
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.VaccineForCategoryBean vaccinebean = (eCA.VaccineForCategoryBean)getObjectFromBean("vaccinebean","eCA.VaccineForCategoryBean",session);  
	String classValue = "";  
	String queryDType = "Select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE WHERE DURN_TYPE NOT IN ('M','H') order by 2";
	String vaccDesc = vaccinebean.getVaccineList().get(vaccineId);
	String categoryDesc = vaccinebean.getCategoryDesc(categoryId, locale) == null?"": vaccinebean.getCategoryDesc(categoryId, locale);
	String duplicateYN = "N";
	String duplicateDays = "";
	String duplicateAction = "";
	
%>
	
<form name="vaccinesForCatSchPopupForm" id="vaccinesForCatSchPopupForm">
	<%try
		{
			List<Map<String, String>> vaccineCategSchList = vaccinebean.getVaccineCategSchList(vaccineId);

			if (vaccineCategSchList == null)
			{
				/*To load From DB.*/				
				vaccinebean.getQueryVaccineSchedule(categoryId,vaccineId,rowCount);	
				vaccineCategSchList = vaccinebean.getVaccineCategSchList(vaccineId);
			}
			//out.println(vaccineCategSchList);
			con = ConnectionManager.getConnection(request);
			psmtDType = con.prepareStatement(queryDType,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rsDType = psmtDType.executeQuery();
			//boolean isAdhocAgeSpec = true;
			boolean isAdhocAgeSpec = vaccinebean.isAdhocAgeSpecific(categoryId, con);
			//boolean isAdhoc = vaccinebean.isAdhocCategory(categoryId);
			if(isAdhocAgeSpec)
			{
				adhocAgeSpecYN = "Y";
				Map<String, String> scbAgeMap = vaccinebean.getScheduleAge(categoryId);
				
				if(scbAgeMap != null)
				{
					minAge = scbAgeMap.get("MinAge");
					maxAge = scbAgeMap.get("MaxAGe");
					ageUnit = scbAgeMap.get("AgeUnit");
					//out.println("categoryId  "+categoryId+" ,  MinAge "+minAge+" , maxAge  "+maxAge+"  ageUnit "+ageUnit );
				}
				

				PreparedStatement pst = null;
				ResultSet rs = null;
				try
				{
					String strSql = " select DUPL_CHECK_DAYS, DUPL_CHECK_ACTION   from CA_IM_VACCINE where VACCINE_ID = ? AND CHECK_DUPLICATE_YN ='Y'";
					pst = con.prepareStatement(strSql);
					pst.setString(1, vaccineId);
					rs = pst.executeQuery();

					if (rs.next())
					{
						duplicateYN = "Y";			
						duplicateAction = rs.getString("DUPL_CHECK_DAYS")== null?"":rs.getString("DUPL_CHECK_DAYS");
						duplicateDays = rs.getString("DUPL_CHECK_ACTION")== null?"":rs.getString("DUPL_CHECK_ACTION");
					}
					if (rs != null)rs.close();
					if (pst != null)pst.close();
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}

			//	Map<String, String> dupliVaccDlt = vaccinebean.getDuplicateVaccDlt(vaccineId);
				/*if(dupliVaccDlt != null)
				{
					duplicateYN = "Y";
					duplicateAction = dupliVaccDlt.get("DUPL_CHECK_ACTION");
					duplicateDays = dupliVaccDlt.get("DUPL_CHECK_DAYS");				
				}*/
				
			}
			
	%>
	 <table  width='100%' class='grid' >	
			<tr>
				<td class='columnheader' colspan='4'><fmt:message key="eCA.VaccinationSchedule.label" bundle="${ca_labels}"/></td>
			</tr>
			<tr>
				<td class='gridData'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
				<td class='gridData'><%=categoryDesc%></td>
				
				<td class='gridData'><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/>
				<td class='gridData'><%=vaccDesc%></td>
				</td>			
			</tr>
	</table>
<br><br>
<div id='divDataTitle' style='postion:relative'>
	 <table  width='100%' id='dataTitleTable'  class='grid' align='center' border='0'>					
			<tr>
				<td class='COLUMNHEADERCENTER'><fmt:message key="Common.DoseNo.label" bundle="${common_labels}"/></td>
				<%
					if(isAdhocAgeSpec)	
					{%>
						<td class='COLUMNHEADERCENTER' colspan='2' ><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.age.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif"></td>
					<%}
					else
					{%>
						<td colspan="2" class='COLUMNHEADERCENTER' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/><img src="../../eCommon/images/mandatory.gif"></td>
					<%}
				%>								
				<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Due.label" bundle="${common_labels}"/><%if(isAdhocAgeSpec)	{%><img src="../../eCommon/images/mandatory.gif"><%}%></td>
				<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/><%if(isAdhocAgeSpec)	{%><img src="../../eCommon/images/mandatory.gif"><%}%></td>
				<%//IN065683 Start.
				//if(!isAdhocAgeSpec)	
				//{
				//IN065683 End.
				%>
					<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
				<%//} //IN065683%>
			</tr>			
			<%

				for(int j = 0;j<Integer.parseInt(rowCount);j++) {		
					
					if(vaccineCategSchList != null && j < vaccineCategSchList.size())
					{
						Map<String, String> map = vaccineCategSchList.get(j);
						if (map != null)
						{
							strYears = map.get("Yrs")==null?"":map.get("Yrs");
							strMonths = map.get("Months")==null?"":map.get("Months");
							strDays = map.get("Days")==null?"":map.get("Days");
							mandatory = map.get("mandatory")==null?"N":map.get("mandatory");
							default1 = map.get("defaultC")==null?"":map.get("defaultC");
							durationDays = map.get("duration")==null?"":map.get("duration");
							durationType = map.get("durationType")==null?"":map.get("durationType");

							due = map.get("Due")==null?"":map.get("Due");
							dueType = map.get("dueType")==null?"":map.get("dueType");
							elapsed = map.get("elapsed")==null?"":map.get("elapsed");
							elapsedType = map.get("elapsedType")==null?"":map.get("elapsedType");
						}						
					}
					else
					{
						if(isAdhocAgeSpec)
						{
							strYears = "";
							strMonths = "";
							strDays = "0";
							mandatory = "";
							default1 = "";
							durationDays = "0";
							durationType = "D";
							due = "0";
							dueType = "D";
							elapsed = "0";
							elapsedType = "D";
						}
						else
						{
							strYears = "";
							strMonths = "";
							strDays = "";
							mandatory = "";
							default1 = "";
							durationDays = "0";
							durationType = "D";
							due = "";
							dueType = "";
							elapsed = "";
							elapsedType = "";
						}
					}
					
				classValue = "gridData"; %>
				<tr id ="trRowId<%=j%>">
					<td width='15%'class='<%=classValue%>'  style='display:none'> <input type='hidden' name='seq_num<%=j%>' id='seq_num<%=j%>' value='<%=j+1%>'>				
					</td>	
					<td	class='<%=classValue%>'><%=j+1%></td>
					<%
					if(!isAdhocAgeSpec)	
					{%>
					<td colspan="2" class='<%=classValue%>'><input type='text' name='duration<%=j%>' id='duration<%=j%>' size='2' maxlength='2' value="<%=durationDays%>" OnKeyPress ="return allowValidNumber(this,event,2,null)" ></input>					
						<select name='duration_type<%=j%>' id='duration_type<%=j%>'>
							<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
							<%				
								while(rsDType.next()){ %>
									<option value='<%=rsDType.getString("DURN_TYPE")%>'  <% if ((durationType).equals( rsDType.getString("DURN_TYPE"))){ out.println("selected"); }%>><%=rsDType.getString("DURN_DESC")%></option>
							<%	}
								rsDType.beforeFirst();
							%>	
						</select>
					</td>
					<%}
					  else
					  {%>
							<td class='<%=classValue%>' colspan='2'>
								<input type='text' name='txtYear<%=j%>' id='txtYear<%=j%>' size='3' value='<%=strYears%>' maxlength='3' OnKeyPress ="return allowValidNumber(this,event,3,null)" onblur='checkAgeSpecific(this, "Y")'>&nbsp;Y&nbsp;&nbsp;
								<input type='text' name='txtMonth<%=j%>' id='txtMonth<%=j%>' size='3'  value='<%=strMonths%>'  maxlength='2' OnKeyPress ="return allowValidNumber(this,event,3,null)" onblur='checkAgeSpecific(this, "M");checkMonths(this);'>&nbsp;M&nbsp;&nbsp;
								<input type='text' name='txtDay<%=j%>' id='txtDay<%=j%>' size='3'  value='<%=strDays%>' maxlength='3' OnKeyPress ="return allowValidNumber(this,event,3,null)" onblur='checkAgeSpecific(this, "D");checkDays(this)'>&nbsp;D
							</td>
					  <%}
					%>
					<td class='<%=classValue%>'><input type='text' name='txtDueduration<%=j%>' id='txtDueduration<%=j%>' size='2' maxlength='2' value="<%=due%>" OnKeyPress ="return allowValidNumber(this,event,2,null)" ></input>&nbsp;<select name='selDueduration_type<%=j%>' id='selDueduration_type<%=j%>' >
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%				
					while(rsDType.next()){ %>
							<option value='<%=rsDType.getString("DURN_TYPE")%>'  <% if ((dueType).equals( rsDType.getString("DURN_TYPE"))){ out.println("selected"); }%>><%=rsDType.getString("DURN_DESC")%></option>
					<%	}
						rsDType.beforeFirst();
					%>	
					</select></div>
					</td>
					<td class='<%=classValue%>'><input type='text' name='txtElapsed<%=j%>' id='txtElapsed<%=j%>' size='2' maxlength='2' value="<%=elapsed%>" OnKeyPress ="return allowValidNumber(this,event,2,null)"></input>&nbsp;<select name='selElapsedduration_type<%=j%>' id='selElapsedduration_type<%=j%>'>
					<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%				
						while(rsDType.next()){ %>
							<option value='<%=rsDType.getString("DURN_TYPE")%>'  <% if ((elapsedType).equals( rsDType.getString("DURN_TYPE"))){ out.println("selected"); }%>><%=rsDType.getString("DURN_DESC")%></option>
					<%	}
						rsDType.beforeFirst();
					%>	
					</select>
					</td>
					<%//IN065683 Start.
					//if(!isAdhocAgeSpec)	
					//{
					//IN065683 End.
					%>			
					<td class='<%=classValue%>'><input type='checkbox' name='mandatoryYN<%=j%>' id='mandatoryYN<%=j%>' value='' <% if ((mandatory.equals("Y"))){ out.println("checked"); }%>></td>
					<td class='<%=classValue%>'><input type='checkbox' name='defaultCU<%=j%>' id='defaultCU<%=j%>' value='<%=default1%>' <% if ((default1).equals("C")){ out.println("checked"); }%>></td>				
					<%//} //IN065683%>
				</tr>
			 <%}%>	
			 <tr>
				<td colspan="7" class='gridNumericData' align="center">
					<input type='button' class='button' name='buttonOk' id='buttonOk' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' OnClick='javascript:setTimeout(addVaccineDuration(),1000)' style="margin-top: 20px;">

					<input type='button' class='button' name='buttonCancel' id='buttonCancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' OnClick='popUpClose()'>
				</td>				
			</tr>	
			<input type ='hidden' name='vaccineCode<%=rowCount%>' id='vaccineCode<%=rowCount%>' 
								
</table>
</div>
	<input type ='hidden' name='array_length' id='array_length' value='<%=rowCount%>'> 
	<input type ='hidden' name='categoryId' id='categoryId' value='<%=categoryId%>'> 
	<input type ='hidden' name='vaccineId' id='vaccineId' value='<%=vaccineId%>'> 
	<input type ='hidden' name='operation' id='operation' value=''> 
	<input type ='hidden' name='remove_value' id='remove_value' value=''> 
	<input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='secPos' id='secPos' value=''>
	<input type='hidden' name='adhocAgeSpecYN' id='adhocAgeSpecYN' value='<%=adhocAgeSpecYN%>'>
	<input type='hidden' name='maxAge' id='maxAge' value='<%=maxAge%>'>
	<input type='hidden' name='minAge' id='minAge' value='<%=minAge%>'>
	<input type='hidden' name='ageUnit' id='ageUnit' value='<%=ageUnit%>'>
	<input type='hidden' name='duplicateYN' id='duplicateYN' value='<%=duplicateYN%>'>
	<input type='hidden' name='duplicateDays' id='duplicateDays' value='<%=duplicateDays%>'>
	<input type='hidden' name='duplicateAction' id='duplicateAction' value='<%=duplicateAction%>'>
	<input type='hidden' name='isAdhocAgeSpec' id='isAdhocAgeSpec' value='<%=isAdhocAgeSpec?"Y":"N"%>'>
	<%
	putObjectInBean("vaccinebean",vaccinebean,session);	


	}
	catch(Exception ee)
	{
	//	out.println("Exception in VaccinesSchForCategoryPopup Block: "+ ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
		//ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(rsDType != null) rsDType.close();
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>	
</form>
</body>
</html>

