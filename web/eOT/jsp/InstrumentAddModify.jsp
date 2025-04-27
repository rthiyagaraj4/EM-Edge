<!DOCTYPE html>
<!-- Added by Rajesh 28-8-12-->
<%@page import="java.io.File"%>
<!-- Added by Rajesh 28-8-12-->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Instrument.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- Added by Rajesh 28-8-12-->
<script> var valueForImage = "";
function fnChkForDblQuotes(event){
	var strCheck = '"\'';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode);  
	if (strCheck.indexOf(key) != -1) return false;  
	return true ;
}
</script>
<!-- Added by Rajesh 28-8-12-->

</head>

<%
Connection con=null;
PreparedStatement stmt=null;
PreparedStatement stmt1=null;
PreparedStatement stmt2=null;
PreparedStatement stmt3=null;
ResultSet rs=null;
ResultSet rs1=null;
ResultSet rs2=null;
ResultSet rs3=null;
String mode=request.getParameter("mode");
String instr_code = checkForNull(request.getParameter("instr_code"));
String chk_checked="checked";
String chk_value="E";
String disable_flag="",instrument_code_disable="",ss_group_code="",ss_group_desc="",long_desc="",short_desc="",cssd_interface_yn="",status="",sql="",ss_group_code_disable="",location="";
String facility_id=(String) session.getAttribute("facility_id");
String install_yn="N";
//Added by Muthu for RUT-CRF-0057
String image_file="";
//Added by Muthu for RUT-CRF-0057
//Added by Rajesh 5-9-2012
String imageUrl = "";
Connection concs = null;
PreparedStatement stmtcs=null;
ResultSet rscs =null;
//Added by Rajesh 5-9-2012
con=ConnectionManager.getConnection(request);
		//Added by lakshmi against CRF-0058 starts here	
		PreparedStatement pstmt_sm_report_display = null;
	    ResultSet rst_sm_report_display=null;
		String Ot_param="";
		//Modified by Rajesh 28-8-2012
		//String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST from OT_PARAM where rownum = 1";
		String sql_sm_report="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
		rst_sm_report_display=pstmt_sm_report_display.executeQuery();
		if(rst_sm_report_display !=null && rst_sm_report_display.next()) 
	   {
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));
		
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
	   if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	   //Added by lakshmi against CRF-0058 ends here

//Added by Muthu for RUT-CRF-0057 starts here	
		PreparedStatement pstmt_sm_report_display_ic = null;
	    ResultSet rst_sm_report_display_ic=null;
		String Ot_param_ic="";
		//Modified by Rajesh 28-8-2012
		//String sql_sm_report_ic="select nvl(BUILD_ANAESTHESIA_INTO_CR_YN,'N') build from OT_PARAM where rownum = 1";	
		String sql_sm_report_ic="select nvl(INSTRUMENT_CSSD_IMAGE,'N') build from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display_ic=con.prepareStatement(sql_sm_report_ic);
		rst_sm_report_display_ic=pstmt_sm_report_display_ic.executeQuery();
		if(rst_sm_report_display_ic !=null && rst_sm_report_display_ic.next())
	   {
		Ot_param_ic=checkForNull(rst_sm_report_display_ic.getString("build"));
		
	   }
	   if(rst_sm_report_display_ic!=null)rst_sm_report_display_ic.close();
	   if(pstmt_sm_report_display_ic!=null)pstmt_sm_report_display_ic.close();
//Added by Muthu for RUT-CRF-0057 ends here
  if(mode.equals("modify")) {
		 //if(Ot_param.equalsIgnoreCase("Y")){		
				sql="SELECT INSTR_CODE, LONG_DESC,SHORT_DESC,SS_GROUP_CODE, LOCATION, IMAGE_FILE, GET_DESC(?,'SS_GROUP_LANG_VW','SHORT_DESC','GROUP_CODE',SS_GROUP_CODE) SS_GROUP_DESC, NVL(STATUS,'E') STATUS FROM OT_INSTRUMENT_LANG_VW WHERE INSTR_CODE=? ";//Modified by lakshmi against CRF-0058
		 /*}
		 else{
			   sql="SELECT INSTR_CODE, LONG_DESC,SHORT_DESC,SS_GROUP_CODE, GET_DESC(?,'SS_GROUP_LANG_VW','SHORT_DESC','GROUP_CODE',SS_GROUP_CODE) SS_GROUP_DESC, NVL(STATUS,'E') STATUS FROM OT_INSTRUMENT WHERE INSTR_CODE=? ";
		 }*/
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,instr_code);
		rs=stmt.executeQuery();
		//Modified by lakshmi against CRF-0058 starts here
		 if(Ot_param.equalsIgnoreCase("Y")){			
		if(rs!=null && rs.next()) {
			instr_code=rs.getString("instr_code");
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			location=checkForNull(rs.getString("location"));
			image_file=checkForNull(rs.getString("image_file"));//Added by Muthu for RUT-CRF-0057
			ss_group_code=checkForNull(rs.getString("ss_group_code"));
			ss_group_desc=checkForNull(rs.getString("ss_group_desc"));
			status=rs.getString("status");
		}
		 }		
		 else{
			if(rs!=null && rs.next()) {
			instr_code=rs.getString("instr_code");
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
			image_file=checkForNull(rs.getString("image_file"));//Added by Muthu for RUT-CRF-0057
			ss_group_code=checkForNull(rs.getString("ss_group_code"));
			ss_group_desc=checkForNull(rs.getString("ss_group_desc"));
			status=rs.getString("status");
		    }
		 }
		 //Modified by lakshmi against CRF-0058 ends here

		if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
	    instrument_code_disable="disabled";	
  }

  //Added by Rajesh 5-9-2012
try{
	String sql_instr_cssd = "select cssd_image_location from ot_param_for_facility where operating_facility_id = ? ";
	concs = ConnectionManager.getConnection(request);
	stmtcs = concs.prepareStatement(sql_instr_cssd) ;
	stmtcs.setString(1,facility_id);
	rscs = stmtcs.executeQuery();
	while(rscs.next()){
		imageUrl=checkForNull(rscs.getString(1));			
	}
	//Added by Rajesh to check location of OT Images
	if("".equals(imageUrl)){
		System.err.println("OT images location->"+application.getRealPath("eOT/images"));
	}
	//Added by Rajesh to check location of OT Images
	if(rscs!=null) rscs.close();
	if(stmtcs !=null) stmtcs.close();
	if(concs != null) concs.close();
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	if(rscs!=null)rscs.close();
	if(stmtcs !=null)stmtcs.close();
	if(concs!=null)
	ConnectionManager.returnConnection(concs,request); 
}
//Added by Rajesh 5-9-2012
%>
<!-- Modified by Rajesh 28-8-12-->
<% if(Ot_param.equalsIgnoreCase("Y")){%>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;fnSetImgOnLoad()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}
else{%>
<body onload="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}%>
<!-- Modified by Rajesh 28-8-12-->
<form name="instrument_form" id="instrument_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.InstrumentServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=0 width='90%'  align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
</tr>
<tr>
	<td class=label >
		<fmt:message key="eOT.InstrumentCode.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="instrument_code" id="instrument_code" value="<%=instr_code%>" size=25 maxlength=20  <%=instrument_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
	<img src='../../eCommon/images/mandatory.gif'>
	</td>
	
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>"  onkeypress="return fnChkForDblQuotes(event);" size='65' maxlength='50' <%=disable_flag%>>
	</td>
	<td>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label >
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"  onkeypress="return fnChkForDblQuotes(event);" size='40' maxlength='30' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<% 
	String sql3="SELECT NVL(INSTALL_YN,'N') INSTALL_YN FROM SM_MODULE WHERE MODULE_ID = ? ";
	stmt3=con.prepareStatement(sql3);
	stmt3.setString(1,"SS");
	rs3=stmt3.executeQuery();
	if(rs3.next()) {
		install_yn=rs3.getString("INSTALL_YN");
	}

%>

<% 
String sql1="SELECT NVL(CSSD_INTERFACE_YN,'N') CSSD_INTERFACE_YN FROM  OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID =? ";
try{
	stmt1=con.prepareStatement(sql1);
	stmt1.setString(1,facility_id);
	rs1=stmt1.executeQuery();
	if(rs1!=null && rs1.next()) {
	cssd_interface_yn=rs1.getString(1);
 }

if(cssd_interface_yn.equals("N")  || install_yn.equals("N"))
	ss_group_code_disable="disabled";
else
    ss_group_code_disable="";
%>
<!--Added by lakshmi against CRF-0058 starts here-->
<% if(Ot_param.equalsIgnoreCase("Y")){%>
<tr>
<td class=label >
		<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="location" id="location" value="<%=location%>"  onkeypress="return fnChkForDblQuotes(event);" size='40' maxlength='30' <%=disable_flag%>>
	</td>
</tr>
<%}%>
<!--Added by lakshmi against CRF-0058 ends here-->

<!-- Added by Muthu for RUT-CRF-0057 -->
<% if(Ot_param_ic.equalsIgnoreCase("Y")){%>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/>
</td>
	<td width='25%' class='fields'>
	<!-- Added by Rajesh 28-8-12-->
		 <input type="text" name="image_file" id="image_file" value="<%=image_file%>" size='40' maxlength='40' onblur ="fnSetImage(this)" <%=disable_flag%>>   
		
	<a href="javascript:openDialogWindow_comp_image_display(valueForImage)">Click here to enlarge</a>
	</td>
	<td><div id="compImg"></div></td>
	<!-- Added by Rajesh 28-8-12-->
</tr>
<%}%>
<!-- Added by Muthu for RUT-CRF-0057 -->

<tr>
<td class=label>
	<fmt:message key="eOT.CrossRefSSGroup.Label" bundle="${ot_labels}"/>
</td>
	<td class='fields'>
		<input type="hidden" name="ss_group_code" id="ss_group_code" value="">
		<input type=hidden name='ss_group_code1' id='ss_group_code1' value="<%=ss_group_code%>">
		<input type="text"  name="ss_group_desc" id="ss_group_desc" size='20' maxlength='20' value="<%=ss_group_desc%>" <%=ss_group_code_disable%>
		onBlur="if(this.value!='')callSS_Group_Code();else { ss_group_code.value=''; ss_group_code1.value ='';}" <%=disable_flag%>>
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onClick="callSS_Group_Code();" <%=ss_group_code_disable%> <%=disable_flag%>>

	</td>   

<%
}catch(Exception e)
{
	e.printStackTrace();

}finally{
	try{
			if(stmt!=null) stmt.close();
            if(stmt1!=null) stmt1.close();
            if(rs!=null)rs.close();
			if(rs1!=null) rs1.close();
            if(stmt2!=null) stmt2.close();
			if(rs2!=null)rs2.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
}%>
</tr>
<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
</tr>
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name='instr_code1' id='instr_code1' value="<%=instr_code%>">
<input type=hidden name='long_desc1' id='long_desc1' value="<%=long_desc%>">
<input type=hidden name='locale' id='locale' value="<%=locale%>">
<input type=hidden name='short_desc1' id='short_desc1' value="<%=short_desc%>">

<!--Added by lakshmi against CRF-0058-->
<input type=hidden name='location1' id='location1' value="<%=location%>">

<!-- Added by Muthu for RUT-CRF-0057 -->
<input type=hidden name=image_file1 value="<%=image_file%>">
<!-- Added by Muthu for RUT-CRF-0057 -->
</form>
</body>
</html>


