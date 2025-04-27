<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
-------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eCA/js/CentralizedDB.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 </head>

<body onscroll='processScroll()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="CentrailizedCriteriaForm" id="CentrailizedCriteriaForm" method="post" target="messageFrame"> 
	<%
	Connection con 		= null;
	
	try
	{
	con = ConnectionManager.getConnection(request);
	
		String practitioner_id = (String)session.getValue("ca_practitioner_id");
		if(practitioner_id == null)practitioner_id = "";
		
		
		String resp_id = "CA";
		String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String nationality_id=request.getParameter("nationality_id")==null?"":request.getParameter("nationality_id");
		String alternate_id=request.getParameter("alternate_id")==null?"":request.getParameter("alternate_id");
		String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
		String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
		String from_date="";
		String to_date="";
		String facility_id="";
		
		ArrayList facilityDetails =(ArrayList)bean.getFacilityDetails(con,patient_id,nationality_id,alternate_id);
		ArrayList dateDetails =(ArrayList)bean.getDefaultCDRDateRange(con,resp_id,RepDb);
		
		if (dateDetails.size() > 0) 
	{ 
		if (dateDetails.get(0) != null)
			from_date = ((String) dateDetails.get(0)).trim();
	   	if (dateDetails.get(1) != null)
	   		to_date  = ((String) dateDetails.get(1)).trim();
		
		if (from_date.equals("") || from_date==null) from_date=""; 
		if (to_date.equals("") || to_date==null) to_date=""; 
	}
	%>
		 <table>
		 
			 <tr>
				  <td class='label' width ='5%' colspan=2><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eCA.Facility.label" bundle="${ca_labels}"/></td>
				   <td class='fields' colspan=2 ><Select id='facility_list' name='facility_list' id='facility_list' onchange='changeDate();'>
				   <Option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</Option>
				   	  <%for (int i=0;i<facilityDetails.size();i++) {
						String [] facility = (String[])facilityDetails.get(i);
						facility_id=facility[0];
						 RepDb= facility_id+"#@"+facility[3];%>
						    <Option value=<%=RepDb%>><%=facility[1]%></Option> 
					   <%}%>
					   </Select> 
				  </td>
				  <td>&nbsp;&nbsp;&nbsp;&nbsp;</td>	
				  <td class="label"   width='5%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
				  <td class='fields' colspan=2 >
					<input type="text" maxlength=10 size="7" id="from_date" value='<%=from_date%>' name="from_date" onBlur='chkDateTime(this,"DMY","<%=localeName%>"); '><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');" /> <font size=4>-	
					
					<input type="text" maxlength=10 size="7" id="to_date" value='<%=to_date%>' name="to_date" onBlur='chkDateTime(this,"DMY","<%=localeName%>");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');" ><img src='../../eMP/images/mandatory.gif'align='center'></img>
				  </td>
				
				  <td width='30%' align='right'>
					<input type="button" class=button name='search' id='search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='searchForDetails()'>
					<input type="button" class=button name='clear' id='clear'
					value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick='clearAll()'>
					</td>
			</tr>
		</table>
		<%if(!imgUrl.equals("")){ %>
			<img src='<%=imgUrl%>' width='100%' height='15'/> 
		<%}%>
			<input type="hidden" id="patient_id"name="patient_id" value="<%=patient_id%>">
			<input type="hidden" id="RepDb" name="RepDb" id="RepDb" value="<%=RepDb%>">
			<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>">
			<input type="hidden" name="nationality_id" id="nationality_id" value="<%=nationality_id%>">
			<input type="hidden" name="alternate_id" id="alternate_id" value="<%=alternate_id%>">
	</form>
<%	}	
			catch(Exception e){
				e.printStackTrace();		
			}
			finally
			{
				if(con != null)	con.close();		
			}
%>
</body>
</html>

