<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String locale	= (String)session.getAttribute("LOCALE");
	String facility_id	= (String)session.getValue( "facility_id" );
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String fromChartCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.ChartCodeFrom.Label","oh_labels");
	String toChartCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels");
	String num_code="";
	String num_desc="";
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//
try{
	con=ConnectionManager.getConnection(request);

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOH/js/MasterReports.js"></script>
 	<script language='javascript' src='../../eOH/js/OHReportsLkupSQL.js'></script> 
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br>
	<form name="MReportForm" id="MReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width="98%" align="center" cellpadding="0" cellspacing="0" border="0">
		<th colspan="4" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
<tr>
			<td width="22%" class="label"><fmt:message key="eOH.ChartCodeFrom.Label" bundle="${oh_labels}"/> &nbsp;</td>

		    <td class='fields' width='25%'>
				<input type='hidden' name='param6' id='param6' value=""> 
				<input type='hidden' name="P_CHART_CODE_FROM" id="P_CHART_CODE_FROM" value=""> 
				<input type='text' name='param5_desc' id='param5_desc' size='25' title='<%=fromChartCode%>'  param1 = 'P_CHART_CODE_FROM'  param2 = 'param6' key ='PERIO_CHART_CODE' onBlur="if(this.value!='')callCommonMasterLookup(this); else P_CHART_CODE_FROM.value='',param6.value='' "> 
				<input type='button' class='button' value='?' name='FromTrmtCatTypeLookUp' id='FromTrmtCatTypeLookUp' onClick="callCommonMasterLookup(param5_desc);">
					
					
			</td>
			<td width="22%" class="label" align ="center"><fmt:message key="Common.to.label" bundle="${common_labels}"/> &nbsp;</td>
			<td class='fields' width='25%'>
				<input type='hidden' name='param8' id='param8' value=""> 
				<input type='hidden' name="P_CHART_CODE_TO" id="P_CHART_CODE_TO" value=""> 
				<input type='text' name='param7_desc' id='param7_desc' size='25' title='<%=toChartCode%>'  param1 = 'P_CHART_CODE_TO'  param2 = 'param8' key ='PERIO_CHART_CODE' onBlur="if(this.value!='')callCommonMasterLookup(this); else P_CHART_CODE_TO.value='',param8.value='' "> 
				<input type='button' class='button' value='?' name='ToTrmtCatTypeLookUp' id='ToTrmtCatTypeLookUp' onClick="callCommonMasterLookup(param7_desc);">
	
					
			</td>
</tr><tr>
			<td width="22%" class="label"><fmt:message key="eOH.NumberingSystem.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td align="left" width="25%">
			<select name="P_NUMBER_SYSTEM" id="P_NUMBER_SYSTEM">
				<% 
					try{

						//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
						//Based on the Chart Level the paramters need to be taken.
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();

						pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
						rs = pstmt.executeQuery();
						while (rs != null && rs.next()){
							oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
						}

						if(oh_chart_level.equals("E")){
							pstmt=con.prepareStatement("SELECT A. NUMBERING_SYSTEM, A.NUMBERING_SYSTEM_DESC,  (SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM) DEF_NUMBERING_SYSTEM FROM OH_NUMBERING_SYSTEM A ORDER BY NUMBERING_SYSTEM_DESC");
						}else{//End
							pstmt=con.prepareStatement("SELECT A. NUMBERING_SYSTEM, A.NUMBERING_SYSTEM_DESC,  (SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID=?) DEF_NUMBERING_SYSTEM FROM OH_NUMBERING_SYSTEM A ORDER BY NUMBERING_SYSTEM_DESC");
							pstmt.setString(1,facility_id);
						}
						rs=pstmt.executeQuery();
						while(rs.next()){
							num_code=rs.getString(1);
							num_desc=rs.getString(2);
					%>	
							<option value= "<%=num_code%>"> <%=num_desc%> </option>
						<% 
						}				
					}catch(Exception e){
						out.println("exp"+e);
					}finally{
						try{
							if(rs!=null) rs.close();
							if(pstmt!=null) pstmt.close();
						}catch(Exception e){
							out.println("exp"+e);
						}
					}
				%>		
			</select>
			</td>
			<td align="right" width="25%">
			</td>
			<td align="right" width="25%">
			</td>
</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
	</table>

	<input type="hidden" name="facility_id" id="facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="user_name" id="user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="module_id" id="module_id" value="OH">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OH">
	<input type="hidden" name="report_id" id="report_id" value="OHRPCTAP">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRPCTAP">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<!--Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)-->
	<input type="hidden" name="oh_chart_level" id="oh_chart_level" value="<%=oh_chart_level%>">
	
</form>
</body>
</html>
<%
}catch(Exception e){
	out.println("exp"+e);
}finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e){
		out.println("exp"+e);
	}
}
%>		
		

