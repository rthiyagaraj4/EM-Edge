<!DOCTYPE html>
<!-- 
	Created 
		on 12/14/2010
		For Retunin 
		Function :Procedure Code For Practitioner
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*,java.util.StringTokenizer,java.util.TreeMap"%>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale = checkForNull((String)session.getAttribute("LOCALE")); 
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	StringBuffer splty_list_values=new StringBuffer();
	StringBuffer termset_list_values=new StringBuffer();
	String SPLTY_QRY="SELECT SPECIALITY_CODE,SHORT_DESC FROM AM_SPECIALITY WHERE EFF_STATUS='E' ORDER BY SHORT_DESC ASC ";
	String TERM_SET_QRY="SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET WHERE PROC_SPEC_YN='Y' AND EFF_STATUS='E' ORDER BY TERM_SET_DESC ASC";
	try{
		con=ConnectionManager.getConnection(request);
		pstmt=con.prepareStatement(SPLTY_QRY);
		rs=pstmt.executeQuery();
		while(rs.next()){
			splty_list_values.append("<option value='"+rs.getString("SPECIALITY_CODE")+"'>"+rs.getString("SHORT_DESC")+"</option><br>");
		}
		pstmt.close();
		rs.close();

		pstmt=con.prepareStatement(TERM_SET_QRY);
		rs=pstmt.executeQuery();
		while(rs.next()){
			termset_list_values.append("<option value='"+rs.getString("TERM_SET_ID")+"'>"+rs.getString("TERM_SET_DESC")+"</option><br>");
		}
		pstmt.close();
		rs.close();

	}catch(Exception ex){
		System.out.println("Exception In proccodeforpractitioner_criteria.jsp==>" +ex);		
		ex.printStackTrace();
	}finally{
		if(con!=null){
			con.close();
		}
		ConnectionManager.returnConnection(con,request);	
	}
%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eOA/js/ProcCodeforPractitioner.js'></script>
		<!--in below line only one line added by VenkateshS (4008) on 23 /july/2012 -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<!-- in below line  this method only  "onKeyDown = lockKey()"  added by VenkateshS (4008) on  23/july/2012  -->
	<body  onKeyDown = 'lockKey()'>
		<form name="Proccode_For_Pract_Criteria_Form" id="Proccode_For_Pract_Criteria_Form" action="" method="post">
			<table width='100%' cellpadding='0' cellspacing='0' border='0' align='center'>
					<tr>
						<td width="15%" class="label">Link By--></td>
						<td width="20%" class="fields">
							<select name="link_by" id="link_by" onchange="changeLinkingproperties(this);">
								<option value="PROC_CODE"><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></option>
								<option value="PRACTITIONER"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
							</select>
						</td>
						<td width="10%" class="label">&nbsp;</td>
						<td width="40%" class="fields">&nbsp;</td>
					</tr>
					<tr>
						<td class="label" nowrap><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
						<td class="fields">
						<!-- values from DB -->
							<select name="term_set_id" id="term_set_id">
								<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
								<%=termset_list_values.toString()%>							
							</select><img src='../../eCommon/images/mandatory.gif'/>
						</td>
						<td  class="label"><label id="linking_splty"><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></label></td>
						<td  class="fields">
						<!-- values from DB -->
							<select name='specialty' id='specialty'>
								<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
								<%=splty_list_values.toString()%>							
							</select>
						</td>
					</tr>
					<tr>
						<td  class="label" nowrap><label id="change_lookup_to"><fmt:message key="Common.ProcedureCode.label" bundle="${common_labels}"/></label></td>
						<td  class="fields" nowrap>
							<div id='proc_code_id'>
								<input type='text' name='proc_code' id='proc_code' value="" size='6' maxlength='6' onblur="getProcdesc(this,document.Proccode_For_Pract_Criteria_Form.proc_desc,'Y')">
								<input type='text' name='proc_desc' id='proc_desc' size='44' maxlength='44' value="" disabled/>
								<input type='button' name='link_lokup_btn' id='link_lokup_btn' value='?' onclick="changeLinkinglookup(proc_desc,document.Proccode_For_Pract_Criteria_Form.proc_code,'N')"><img src='../../eCommon/images/mandatory.gif'/>
								<span id="proc_code_desc_id"></span>
							</div>
							<div style='display:none' id="practitoner_block_id">
								<input type="text" name="pract_desc" id="pract_desc" size='50' maxlength='50' onblur="changeLinkinglookup(this,document.Proccode_For_Pract_Criteria_Form.pract_code,'Y')"><input type="hidden" name="pract_code" id="pract_code" value=""><input type='button' name='link_lokup_btn' id='link_lokup_btn' value='?' onclick="changeLinkinglookup(pract_desc,document.Proccode_For_Pract_Criteria_Form.pract_code,'N')"><img src='../../eCommon/images/mandatory.gif'/>
							</div>
						</td>
						<td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
						<td class="fields">
							<input type="text" name="search_by" id="search_by" size='10' maxlength='50'>
							<select name='search_criteria' id='search_criteria'>
								<option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
								<option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
							</select>
						</td>
					</tr>
					<tr align='center'>
						<td class="label">&nbsp;</td>
						<td class="fields">&nbsp;</td>
						<td class="label">&nbsp;</td>
						<td  align='right'>
							<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='displayResults()'>&nbsp;<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onclick="clearAll();">
						</td>
					</tr>
			</table>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		</form>
	</body>
</html>
<%clearBuffers(termset_list_values,splty_list_values );%>
<%!	
	private String checkForNull(String inputString){
	return (inputString==null)	? "" : inputString;
}
	private String checkForNull(String inputString, String defaultValue){
	return (inputString==null)	? defaultValue : inputString;
}
public void clearBuffers(StringBuffer termset_list_values,StringBuffer  splty_list_values){
	termset_list_values=null;
	splty_list_values=null;
}
%>

