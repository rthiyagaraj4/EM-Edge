<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String mandatoryVisibility= "";
String prvImgvisibility= "";
%>	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCA/js/VaccinesForCategory.js'></script>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body   OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()">
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	eCA.VaccineForCategoryBean vaccinebean = (eCA.VaccineForCategoryBean)getObjectFromBean("vaccinebean","eCA.VaccineForCategoryBean",session);
%>
	
	<form name="vaccinesForCategoryResultForm" id="vaccinesForCategoryResultForm">
<!--<div id='divDataTitle' style='postion:relative'>  -->
	 <table class='grid' align='center' id='dataTitleTable1' name='dataTitleTable1' width='100%'>	
			<tbody id='dataTitleTable' name='dataTitleTable'>
			<tr><th class='columnheader' colspan='9' align="left"><fmt:message key="Common.Selected.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></th></tr>
			<tr><th class='columnheadercenter' ><fmt:message key="Common.OrderSrlNo.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="eCA.VaccineDescription.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="eCA.VaccineNoDoses.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="Common.DefaultSite.label" bundle="${common_labels}"/></th>
			<!-- <th class='columnheadercenter' ><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></th> -->
			<th class='columnheadercenter' width='10%'><fmt:message key="eCA.VaccinePrevAdministered.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="eCA.VaccinePrevDays.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="eCA.VaccinePreAction.label" bundle="${ca_labels}"/></th>
			<th class='columnheadercenter' ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/>&nbsp;<img  src="../../eCommon/images/mandatory.gif" ></th>
			<th class='columnheadercenter' ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
		</tr>	
			
<!--	</table>
 </div>  -->
 <%
	 Connection con			= null;
	 PreparedStatement	siteListPSmt = null;
	 ResultSet rsSiteList = null;
	 PreparedStatement	psmtDType = null;
	 ResultSet rsDType = null;
	 PreparedStatement	psmtDupChk = null;

	String finalString = "";
	String classValue = "gridData";

	String searchText = request.getParameter("categoryDesc");	
	String default_yn			= "";


	String siteListQuery = "Select A.VACCINE_ID,A.SITE_ID,A.DEFAULT_YN,B.SHORT_DESC from CA_IM_SITE_FOR_VACCINE A,AM_ANATOMICAL_SITE B where A.VACCINE_ID = ? AND B.ANATOMICAL_SITE_CODE = A.SITE_ID order by 2";
	String categoryId = request.getParameter("categoryId") == null ? "" :  request.getParameter("categoryId");
	String queryDType = "Select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE order by 2";	
	String dupl_qry="select CHECK_DUPLICATE_YN,DUPL_CHECK_DAYS,DUPL_CHECK_ACTION from CA_IM_VACCINE where VACCINE_ID = ? ";
	try
	{
		con = ConnectionManager.getConnection(request);
		psmtDType = con.prepareStatement(queryDType,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
		rsDType = psmtDType.executeQuery();
		siteListPSmt = con.prepareStatement(siteListQuery);
		psmtDupChk = con.prepareStatement(dupl_qry);
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";		

			CommonCollectionUtils<String, Map<String, String>> vaccSchLstMap = vaccinebean.getSelectedVaccineList();
			//out.println("<br> vaccSchLstMap.size()  --- "+vaccSchLstMap.size());
			if(vaccSchLstMap != null && vaccSchLstMap.size() == 0)
			{
				vaccinebean.getQueryVaccineForCategory(categoryId);
				vaccSchLstMap = vaccinebean.getSelectedVaccineList(); 
			}
						//out.println("<br>vaccSchLstMap ---> "+vaccSchLstMap);
			String vaccineId = "";
			String orderSqeNo = "";
			String noDoeses = "";
			String defaultSite = "";
			String mandatory = "N";
			String checkPrevAdministered = "";
			String checkPrevDays = "";
			String checkPrevAction = "";
			String flag = "";
			String vaccineDesc = "";		

			Map<String, String> vaccSchMap = null;

			int cnt = 2;
			CommonCollectionUtils<String, String> vaccineIdLst = vaccinebean.getScheduleVaccineList();
			CommonCollectionUtils<String, String> vaccList = vaccinebean.getVaccineList();
			//out.println("<br> vaccineIdLst "+vaccineIdLst); 
			//out.println("<br> vaccList "+vaccList); 

			
			if(vaccineIdLst != null)
			{
				for(String vaccId : vaccList.keyList())
				{	
					if(vaccSchLstMap != null )
					{
						vaccSchMap = vaccSchLstMap.get(vaccId);
						if(vaccSchMap != null)
						{
							vaccineId = vaccSchMap.get("vaccineId");
							orderSqeNo = vaccSchMap.get("orderSqeNo");
							vaccineDesc = vaccSchMap.get("vaccineDesc");
							noDoeses = vaccSchMap.get("noDoeses");
							defaultSite = vaccSchMap.get("defaultSite");
							mandatory = vaccSchMap.get("Mandatory");
							checkPrevAdministered = vaccSchMap.get("checkPrevAdministered");
							checkPrevDays = vaccSchMap.get("checkPrevDays");
							checkPrevAction = vaccSchMap.get("checkPrevAction");
							flag = vaccSchMap.get("flag");
						}
						else
						{
							vaccineId = vaccId;
							orderSqeNo = String.valueOf(cnt-1);
							vaccineDesc = vaccList.get(vaccId);
							noDoeses = "1";
							defaultSite = "";
							mandatory = "N";
							checkPrevAdministered = "N";
							checkPrevDays = "0";
							checkPrevAction = "";
							flag = "N";
						}
					}
					else
					{
						vaccineId = vaccId;
						orderSqeNo = String.valueOf(cnt-1);
						vaccineDesc = vaccList.get(vaccId);
						noDoeses = "1";
						defaultSite = "";
						mandatory = "N";
						checkPrevAdministered = "N";
						checkPrevDays = "0";
						checkPrevAction = "";
						flag = "N";
					}

					noDoeses = vaccinebean.getVaccineDose(vaccId)==null?noDoeses:vaccinebean.getVaccineDose(vaccId);
					defaultSite = vaccinebean.getVaccineDLFTSite(vaccId)==null?defaultSite:vaccinebean.getVaccineDLFTSite(vaccId);
					checkPrevAdministered = vaccinebean.getVaccineChkPrevAdmin(vaccId)==null?checkPrevAdministered:vaccinebean.getVaccineChkPrevAdmin(vaccId);
					checkPrevDays =  vaccinebean.getVaccineChkPrevDays(vaccId)==null?checkPrevDays:vaccinebean.getVaccineChkPrevDays(vaccId);
					checkPrevAction = vaccinebean.getVaccineChkPrevAction(vaccId)==null?checkPrevAction:vaccinebean.getVaccineChkPrevAction(vaccId);
					flag = "N";

						%>
							<tr id ="trRowId_<%=cnt%>">
								<td class='gridNumericData'><a class='gridLink'  href="#" onclick="javascript:changeSeq(this)"><%=cnt -1 %></a> </td>
								<td class='<%=classValue%>'><%=vaccineDesc%> <input type='hidden' name='vaccineId_<%=cnt%>' id='vaccineId_<%=cnt%>' value='<%=vaccineId%>'></td>
								<td class='<%=classValue%>'>
									<input type='text' name='num_of_doses_<%=cnt%>' id='num_of_doses_<%=cnt%>' size='2' maxlength='2' value="<%=noDoeses%>" OnKeyPress ="return allowValidNumber(this,event,2,null)" onblur='checkDose(this, "<%=vaccineId%>")'>
								</td>
								<td class='<%=classValue%>'>
									<select name='default_site_name_<%=cnt%>' id='default_site_name_<%=cnt%>' onchange='addDLFTSite(this, "<%=vaccineId%>")'>
											<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
											<%
												siteListPSmt.setString(1,vaccineId);
												rsSiteList = siteListPSmt.executeQuery();
												while(rsSiteList.next()){ 
													default_yn = rsSiteList.getString("DEFAULT_YN")==null?"N":rsSiteList.getString("DEFAULT_YN");
													%>
													<option value='<%=rsSiteList.getString("SITE_ID")%>'  <% if (defaultSite.equals( rsSiteList.getString("SITE_ID")))
													//if(default_yn.equals("Y"))
													{ out.println("selected"); }%>><%=rsSiteList.getString("SHORT_DESC") %></option>
											<%	}

											//	rsSiteList.beforeFirst();
											 if ((Integer.parseInt(noDoeses)) > 1)
											{
												mandatoryVisibility = "display:none";
											}
											else  if ((Integer.parseInt(noDoeses)) == 1)
											{
												mandatoryVisibility = "display";
											}
											else
											{
												mandatoryVisibility = "display:none";
											}
											%>	
											</select>
								</td>
								<!-- <td class='<%=classValue%>'>
									<input type='checkbox' name='mandatoryYN_<%=cnt%>' id='mandatoryYN_<%=cnt%>' value='<%=mandatory%>' <% if (mandatory.equalsIgnoreCase("Y")){%> checked <%}%> style='<%=mandatoryVisibility%>' >
								</td> -->
								<td class='<%=classValue%>'>

									<input type='checkbox' name='prvAdmYN_<%=cnt%>' id='prvAdmYN_<%=cnt%>' value='<%=checkPrevAdministered%>' <%if (checkPrevAdministered.equalsIgnoreCase("Y")){%> checked<%}%> onClick="chkMandatory(this,'<%=cnt%>','chkPrvDayImg_', '<%=vaccineId%>');">
								</td>
										<%
										 if (checkPrevAdministered.equalsIgnoreCase("Y")){	
											prvImgvisibility = "display:visible";										
										}else{
											prvImgvisibility = "display:none";									
										}
										%>							
								<td class='<%=classValue%>'>
									<input type='text' name='chk_dup_days_<%=cnt%>' id='chk_dup_days_<%=cnt%>' size='3' maxlength='3' value="<%=checkPrevDays%>" OnKeyPress ="return allowValidNumber(this,event,3,null)" onblur='addPrevDays(this, "<%=vaccineId%>")'><img id = "chkPrvDayImg_<%=cnt%>" src="../../eCommon/images/mandatory.gif" style="<%=prvImgvisibility%>">
								</td>
								<td class='<%=classValue%>'>
									<select name='chk_prv_action_<%=cnt%>' id='chk_prv_action_<%=cnt%>' onchange='addPrevAction(this, "<%=vaccineId%>")'>
										<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
										<option value="A" <% if (checkPrevAction.equalsIgnoreCase("A")){%>selected<% }%>><fmt:message key="Common.Alert.label" bundle="${common_labels}"/></option>
										<option value="S" <% if (checkPrevAction.equalsIgnoreCase("S")){ %>selected<%}%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option>									
									</select>						
								</td>
								<td class='<%=classValue%>'><a name="linkSchedule_<%=cnt%>"  class='gridLink' href="#"  onclick='javascript:showSchedulePopup(this);'><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></a></td>
								<td class='<%=classValue%>'><input type='checkbox' name='selectYN_<%=cnt%>' id='selectYN_<%=cnt%>' value='Y' OnClick ='removeRow(this, "<%=vaccineId%>","<%=vaccineDesc%>")' checked></td>
							</tr>
					<%
					
					cnt++;
				}
			}			
		%>		
	</tbody>
</table>
<!-- </div> -->
	<!-- <input type ='hidden' name='finalString' id='finalString' value='<%=finalString%>'>      -->
	<input type ='hidden' name='array_length' id='array_length' value='<%=cnt%>'> 	
	<input type ='hidden' name='categoryId' id='categoryId' value='<%=categoryId%>'> 
	<input type ='hidden' name='remove_value' id='remove_value' value=''> 
	<input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='secPos' id='secPos' value=''>
	<input type ='hidden' name='freq_duration_temp' id='freq_duration_temp' value=''>
	<input type ='hidden' name='adhocAgeSpecYN' id='adhocAgeSpecYN' value=''>
	<%

	putObjectInBean("vaccinebean",vaccinebean,session);	


	}
	catch(Exception ee)
	{
		//out.println("Exception in VaccinesForcategoryList Block: "+ ee.toString());
		ee.printStackTrace();
	}
	finally
	{
		if (rsDType != null) rsDType.close();
		if (rsSiteList != null) rsSiteList.close();
		if(siteListPSmt != null) siteListPSmt.close();
		if(psmtDType != null) psmtDType.close();
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>	
</form>
</body>
</html>

