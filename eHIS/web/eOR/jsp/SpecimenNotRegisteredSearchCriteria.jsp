<!DOCTYPE html>
<%
/* 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN061892			Prakash C			31/10/2017		Ramesh G		ML-MMOH-CRF-0544
---------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<head>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.*, eMR.*, eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /* Mandatory checks start */
		String bean_id = "Or_SpecimenOrder" ;
		String bean_name = "eOR.SpecimenOrder";
	/* Mandatory checks end */
		SpecimenOrder bean = (SpecimenOrder)getBeanObject( bean_id, bean_name , request ) ;
		bean.setLanguageId(localeName);
		String mode	   = "1";
		request.setCharacterEncoding("UTF-8");
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.clear() ;
		bean.setMode( mode ) ;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOR/js/SpecimenNotRegistered.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<%
		Connection con  = null;
		PreparedStatement stmtLen = null;
		ResultSet rsetLen= null;
		String time_alert ="";
		String login_facility_id = (String) session.getValue("facility_id");
		try
		{
			String sql ="Select ALRT_TIME_FOR_NOT_REG_LAB_SPEC from or_param_by_facility where operating_facility_id=?";
			con = ConnectionManager.getConnection(request);
			stmtLen = con.prepareStatement(sql);
			stmtLen.setString( 1 , login_facility_id);
			rsetLen	= stmtLen.executeQuery();
			
			while(rsetLen.next())
				{
				 time_alert  = rsetLen.getString("ALRT_TIME_FOR_NOT_REG_LAB_SPEC")==null?"":rsetLen.getString("ALRT_TIME_FOR_NOT_REG_LAB_SPEC");
				  	
				}
		}
		catch( Exception e )	
			{
				System.err.println( "Error loading values from database" ) ;
				e.printStackTrace() ;			
			} 
		finally 
			{
				if(rsetLen !=null) rsetLen.close();
				if(stmtLen !=null)stmtLen.close();
			}
%>	
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%	
			String disabled		   = "";	
			Properties p = (Properties)session.getValue("jdbc");
			String locale= (String) p.getProperty("LOCALE");
			
			String p_order_id = request.getParameter("p_order_id")==null?"":request.getParameter("p_order_id");
			String p_specimen_no = request.getParameter("p_specimen_no")==null?"":request.getParameter("p_specimen_no");
			String priority = request.getParameter("priority")==null?"B":request.getParameter("priority");
			String practitioner_type = (String)session.getValue("practitioner_type");
			String status = bean.checkForNull(request.getParameter("status"),"A");
			String 	practitioner_id = (String) session.getValue("ca_practitioner_id");
			
			int patient_id_length = bean.getPatientIdLength();						
%>
<form name='specimen_order_search_not_register' id='specimen_order_search_not_register' target='messageFrame' >
	<table cellpadding=3  border='0'  width="100%"  align=left  >
		<tr>
			<td  class='label' id='patientId_lbl_td' colspan=1 width="20%" style="align:left"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields' id='patientId_td' >
					<input type='text' name='patientId' id='patientId' value=''  onKeyPress='return CheckForSpecChars(event)' onBlur='ChangeUpperCase(this)'  size="20" maxlength='<%=patient_id_length%>'><input type=button name=search value='?'  class=button tabIndex="4" onClick="callPatientSearch()" >
			</td>
			<td class=' label' width="0%"><fmt:message key="eOR.TimeFrameAlertForLab.label" bundle="${or_labels}"/></td>	
				<td class='fields'   ><input type='text' id='time_alert'name='time_alert_frame' size='4' value="<%=time_alert%>"  maxlength='4' onKeyPress='return(ChkNumberInput(this,event,"0"))' onblur='emptyValidate(this);OrCheckTime(this)'><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
		</tr>		
		<tr>
			<td class='label' id='specimen_no_lbl_td' ><fmt:message key="eOR.SpecimenNo.label" bundle="${or_labels}"/></td>
			<td class='fields' id='specimen_no_td'  ><input type='text' name='specimen_no' id='specimen_no' size='16' value="<%=p_specimen_no%>"  maxlength='16' onKeyPress='return(ChkNumberInput(this,event,"0"))'></td>
			<td class=' label' width="0%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='fields' id='priority' >
						<select name='priority_value' id='priority_value' <%=disabled%> >
								<option value='B' selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
								<option value='S'><fmt:message key="Common.Stat.label" bundle="${common_labels}"/></option>
								<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
			</td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
			<td class='label' colspan= align='left' ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
			<td class='fields' id='OrderId_td' >
					<input name='order_id' id='order_id' type=text size="20" maxlength="15" value="<%=p_order_id%>"  <%=disabled%> onKeyPress='return CheckForSpecChars(event)' <%=disabled%>></td>		
		</tr>
		<tr>
			<td class='label' colspan=1></td>
			<td class='label' colspan=2></td>
			<td class='label' colspan=3></td>
			<td class='button' colspan=4>
			<input type='button' class='button' name='search_btn' id='search_btn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='populateSelection()'>
			<input type='button' name='clear' id='clear' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearValues()'>
			</td>
		</tr>
	</table>
	<input type="hidden" name="status" id="status" value="<%=status%>">
	<input type="hidden" name="practitioner_type" id="practitioner_type" value="<%=practitioner_type%>">
	<input type="hidden" name="practitioner_id" id="practitioner_id" value="<%=practitioner_id%>">
	
</form>
</body>
</html>
<script language='javascript'>	
	parent.resultframe.location.href = "../../eOR/jsp/SpecimenNotRegisteredSearchResult.jsp?locale=<%=locale%>&priority=<%=priority%>&time_alert=<%=time_alert%>&status=<%=status%>&practitioner_type=<%=practitioner_type%>&practitioner_id=<%=practitioner_id%>";
</script> 

