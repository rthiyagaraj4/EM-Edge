<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History    	Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
18/08/2022	29035				Ramesh G											ML-MMOH-CRF-1763
--------------------------------------------------------------------------------------------------------------
*/  
%>
<%@page import="com.itextpdf.text.log.SysoLogger"%>
<%@ page import ="java.sql.*,java.util.*,eCA.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<HTML>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
		<script Language='JavaScript' src='../../eCommon/js/ValidateControl.js'></Script>
		<script language='javascript' src='../../eCA/js/MultiLocForPractitioner.js'></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	Properties p 			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	String facility_id		= (String) session.getValue("facility_id");
	String practitionerId 	= request.getParameter("practitionerId");
	String locationType 	= request.getParameter("locationType");
	String searchBy 		= request.getParameter("searchBy")==null?"":(String)request.getParameter("searchBy");
	String searchText		= request.getParameter("searchText")==null?"":(String)request.getParameter("searchText");
//	System.out.println("======facility_id=========>"+facility_id+"<=============");
//	System.out.println("======practitionerId=========>"+practitionerId+"<=============");
//	System.out.println("======locationType=========>"+locationType+"<=============");
//	System.out.println("======searchBy=========>"+searchBy+"<=============");
//	System.out.println("======searchText=========>"+searchText+"<=============");
	
	String or_bean_id 						= "@MultiLocForPractitionerBean";
	String or_bean_name 					= "eCA.MultiLocForPractitionerBean";
	MultiLocForPractitionerBean bean					= (MultiLocForPractitionerBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	ArrayList  resArray = bean.getMultiLocForPrctitionerData(facility_id,practitionerId,locationType,searchBy,searchText,locale);
//	System.out.println("--------------------->"+resArray.size());
	int selectedRec = 0;
	%>
	<BODY class='CONTENT'   OnMouseDown='CodeArrest()' onKeyDown='lockKey()'>
		<form name="Result_form" id="Result_form">			
			<table class='grid' border="1" width="99%" cellspacing='0' cellpadding='5' align='center'>
				<tr>
					<th class='columnheadercenter'  width='20%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
					<th class='columnheadercenter'  width='20%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
					<th class='columnheadercenter'  width='20%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></th>
					<th class='columnheadercenter'  width='20%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></th>
					 <th  class='columnheadercenter'  width='20%'><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
<input type="checkbox" id="allChecked" name="allChecked" id="allChecked" onClick="checkAll(this);" />
					</td>
				</tr>
				<%
					if(resArray.size()>0){
						for(int i=0;i<resArray.size();i++){
							ArrayList array = (ArrayList)resArray.get(i);
							if("Y".equals(array.get(5))){
								selectedRec++;
							}
							%>
							<tr>
								<td class='gridData'><%=array.get(1) %></td>
								<td class='gridData'><%=array.get(2) %></td>
								<td class='gridData'>
									<input type='text' name='eff_from_date<%=i%>' id='eff_from_date<%=i%>' value='<%=(!(array.get(3)).equals(""))?array.get(3):""%>' onblur='validate_date(this,eff_to_date<%=i%>,"DMY","<%=locale%>");'  size=10 maxlength=10>
									<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('eff_from_date<%=i%>');" >
								</td>
								<td class='gridData'>
									<input type='text' name='eff_to_date<%=i%>' id='eff_to_date<%=i%>' value='<%=(!(array.get(4)).equals(""))?array.get(4):""%>' onblur='validate_date(eff_from_date<%=i%>,this,"DMY","<%=locale%>");'  size=10 maxlength=10>
									<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('eff_to_date<%=i%>');" >
								</td>
								<td class='gridData'>
									<input type="checkbox" id="locCheck<%=i%>" name="locCheck<%=i%>" value="<%=array.get(5)%>"  <%=((array.get(5)).equals("Y"))?"checked":""%> onClick="uncheckHeader(this)"/>
								</td>
								<input type="hidden" id="locCode<%=i%>" name="locCode<%=i%>" value="<%=array.get(0)%>" />
							</tr>
							<% 
						}
					}
				%>
			</table>
			<input type=hidden name='totalRecord' id='totalRecord' value='<%=resArray.size() %>'/>
			<input type=hidden name='selectedRecord' id='selectedRecord' value='<%=selectedRec %>'/>
			<input type=hidden name='practitionerId' id='practitionerId' value='<%=practitionerId %>'/>
			<input type=hidden name='locationType' id='locationType' value='<%=locationType %>'/>
		</form>
		<script>
			if(document.forms[0].totalRecord.value == document.forms[0].selectedRecord.value)
				document.forms[0].allChecked.checked=true;
		</script>
	</BODY>
</HTML>

