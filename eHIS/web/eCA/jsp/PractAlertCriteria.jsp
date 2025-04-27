<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/1/2009 --%>

<%@page import="java.sql.*,webbeans.eCommon.*,java.net.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	
%>	

	<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>	
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>		
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../js/PractAlert.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
			
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");				
				String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
				String facilityId = (String) session.getValue("facility_id");
						if(facilityId == null) facilityId="";	
						String toDate = "";
			String dt = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			String dt1 = com.ehis.util.DateUtils.minusDate(dt,"DMY",locale,7,"d");					
								
	 %>
	
	</head>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='PractAlert' id='PractAlert' >
			<table id='PatCriteriaTbl' width='100%' border='0' cellpadding='0' cellspacing=0>
			<tr><td>&nbsp;	</td></tr>
		<tr>
		<td id=frv2 class='label' width ='20%'>
			<fmt:message key="Common.Period.label" bundle="${common_labels}"/></b></td>
			<td class ='fields' width ='30%' nowrap>
			<input class = 'fields' id="from_date"  type="text" name="from_date" id="from_date" size=10 maxlength=10 value='<%=dt1%>' onBlur='doDateCheckLoc(this,to_date,"<%=toDate%>","DMY","<%=locale%>",this);'>
			<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv" onclick="return showCalendarValidate('from_date');" ><img src='../../eCommon/images/mandatory.gif'></img><B>-</B>
			<input class = 'fields' id="to_date" type="text" name="to_date" id="to_date" size=10 maxlength=10 title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>' onBlur='doDateCheckLoc(from_date,this,"<%=toDate%>","DMY","<%=locale%>",this);' value='<%=dt%>'>
			<input type='image' src="../../eCommon/images/CommonCalendar.gif" id="cal_pv1" title='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")%>'; onclick="return showCalendarValidate('to_date');"><img src='../../eCommon/images/mandatory.gif'></img>	</td>

		<td class='label'  ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td  class="fields"><SELECT name="group_By" id="group_By" id="group_By"> 
			<option value="1"><fmt:message key="Common.patient.label" bundle="${common_labels}"/> 
			<option value="2"><fmt:message key="Common.category1.label" bundle="${common_labels}"/>	
		</SELECT>
		</td>
		</tr>										
				<tr><td colspan='4'>&nbsp;</td></tr>	
					<tr><td colspan='2'>&nbsp;</td>
					<td align='right' colspan='2'> 
						<input type='button' class='button' name='search' id='search' id = 'searchID' onclick="searchClick()" 	value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'></input>
						<input type='button' class='button' name='clear' id='clear' onclick="javascript:clearClick()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'></input>						

					</td>
					
					
				</tr>			
				
				</table>	
				<input type='hidden' value='<%=facilityId%>' name='facilityid' >
				<input type='hidden' value='<%=ca_practitioner_id%>' name='ca_practitioner_id'></input>
				<input type=hidden value='<%=locale%>' name='locale'>

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
		
	</body>
</html>

<%
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	
}
%> 


