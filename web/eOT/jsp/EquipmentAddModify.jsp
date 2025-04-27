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
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/Equipment.js'></script>
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
ResultSet rs=null;
String mode=request.getParameter("mode");
String equipment_code = request.getParameter("equipment_code")==null?"":request.getParameter( "equipment_code" );
String chk_checked="checked";
String chk_value="E";
String disable_flag="";
String equipment_code_disable="";
String long_desc="";
String short_desc="";
String status="";
String sql="";
//RUT-CRF-0091 by MuthuN Starts Here
String location=""; 
String customer_id="";
PreparedStatement pstmt_eq = null;
ResultSet rst_eq=null;
//RUT-CRF-0091 by MuthuN Ends Here
//Added by Muthu for RUT-CRF-0057 Starts Here
String image_file="";
String Ot_param_eq="";
//Added by Rajesh 5-9-2012
String imageUrl = "";
//Added by Rajesh 5-9-2012
con=ConnectionManager.getConnection(request);	
		PreparedStatement pstmt_sm_report_display_eq = null;
	    ResultSet rst_sm_report_display_eq=null;
	  	//Modified by Rajesh 28-8-2012
	  	//String sql_sm_report_eq="select nvl(BUILD_ANAESTHESIA_INTO_CR_YN,'N') build from OT_PARAM where rownum = 1";
		String sql_sm_report_eq="select nvl(INSTRUMENT_CSSD_IMAGE,'N') build from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display_eq=con.prepareStatement(sql_sm_report_eq);
		rst_sm_report_display_eq=pstmt_sm_report_display_eq.executeQuery();
		if(rst_sm_report_display_eq !=null && rst_sm_report_display_eq.next())
	   {		Ot_param_eq=checkForNull(rst_sm_report_display_eq.getString("build"));
	  // System.out.println("Ot_param_eq "+Ot_param_eq); 
	   }
	   if(rst_sm_report_display_eq!=null)rst_sm_report_display_eq.close();
	   if(pstmt_sm_report_display_eq!=null)pstmt_sm_report_display_eq.close();
//Added by Muthu for RUT-CRF-0057 Ends Here
if(mode.equals("modify"))
{	
	try{	
		  //Added by Muthu for RUT-CRF-0057 Starts here	 
			sql="Select equipment_code, long_desc, short_desc, image_file,location, nvl(status,'E') status from OT_EQUIPMENT where equipment_code=?"; 		
		 //Added by Muthu for RUT-CRF-0057 Ends Here
		stmt=con.prepareStatement(sql);
		stmt.setString(1,equipment_code);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			long_desc=rs.getString("long_desc");
			short_desc=rs.getString("short_desc");
		//Added by Muthu for RUT-CRF-0057
			image_file=checkForNull(rs.getString("image_file"));
		//Added by Muthu for RUT-CRF-0057
		location=checkForNull(rs.getString("location"));//RUT-CRF-0091 by MuthuN
			status=rs.getString("status");
		}
		if(status.equals("E"))
		{
			chk_checked="checked";
			disable_flag="";			
		}
		else
		{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}	
	equipment_code_disable="disabled";	  
}catch(Exception e)
	{
	e.printStackTrace();
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
			e.printStackTrace();
			}
		
		}
}

//Added by Rajesh 5-9-2012
try{
	String facility_id	= (String) session.getValue("facility_id");
	String sql_instr_cssd = "select cssd_image_location from ot_param_for_facility where operating_facility_id = ? ";
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(sql_instr_cssd) ;
	stmt.setString(1,facility_id);
	rs = stmt.executeQuery();
	while(rs.next()){
		imageUrl=checkForNull(rs.getString(1));			
	}

	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request); 
}
//Added by Rajesh 5-9-2012
//Added by muthuN for RUT-CRF-0091 on 05-02-2013
	try
		{	con = ConnectionManager.getConnection(request);	
			pstmt_eq = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_eq = pstmt_eq.executeQuery();	
			if ( rst_eq.next() && rst_eq != null )
			{
				customer_id  =  rst_eq.getString(1);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				//System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rst_eq != null)   rst_eq.close();
				if (pstmt_eq != null) pstmt_eq.close();
				if(con!=null) ConnectionManager.returnConnection(con,request); 
			}
//Added by muthuN for RUT-CRF-0091 on 05-02-2013
%>
<!-- Modified by Rajesh 28-8-12-->
<% if(Ot_param_eq.equalsIgnoreCase("Y")){%>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;fnSetImgOnLoad()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}
else{%>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}%>
<!-- Modified by Rajesh 28-8-12-->
<form name="equipment_form" id="equipment_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.EquipmentServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='90%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='26%'></td>
</tr>

<tr>
	<td class=label width='25%'>
		<fmt:message key="eOT.EquipmentCode.Label" bundle="${ot_labels}"/>
	</td>
	<td width='25%' class='fields'>
		<input type="text" name="equipment_code" id="equipment_code" value="<%=equipment_code%>" size=25 maxlength=20  <%=equipment_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>
	</td>
	<td width='25%' class='fields'>
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>" onkeypress="return fnChkForDblQuotes(event);" size=65 maxlength=50 <%=disable_flag%>>
	</td>
	<td>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>
</td>
	<td width='25%' class='fields'>
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>"  onkeypress="return fnChkForDblQuotes(event);" size='20' maxlength='15' <%=disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<!--Added by MuthuN against RUT-CRF-0091 on 01-April-2013 starts here-->
<% if(customer_id.equalsIgnoreCase("RTN")){%>
<tr>
<td class=label >
		<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="location" id="location" value="<%=location%>"  onkeypress="return fnChkForDblQuotes(event);" size='40' maxlength='50' <%=disable_flag%>>
	</td>
</tr>
<%}%>
<!--Added by MuthuN against RUT-CRF-0091 ends here-->

<!-- Added by Muthu for RUT-CRF-0057 Starts here -->
<% if(Ot_param_eq.equalsIgnoreCase("Y")){%>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/>
</td>
	<td width='25%' class='fields'>
	<!-- Modified by Rajesh 28-8-12-->
			<input type="text" name="image_file" id="image_file" value="<%=image_file%>" size='40' maxlength='40' onblur="fnSetImage(this)" <%=disable_flag%>> 
			<a href="javascript:openDialogWindow_comp_image_display(valueForImage,'<%=equipment_code%>')">Click here to enlarge</a>
	</td>
	<td>
	 <div id="equipImgDiv"></div>
	</td>
	<!-- Modified by Rajesh 28-8-12-->
</tr>
<%}%>
<!-- Added by Muthu for RUT-CRF-0057 Ends here -->

<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
</td>
	<td width='25%' class='fields'>
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='26%'></td>
</tr>
<!-- Modified by Rajesh 28-8-12
<tr>
<td>
<input type="button" name="Refresh Images" id="Refresh Images" value="Load Images" onclick="fnLoadImages();">
</td>
</tr>
Modified by Rajesh 28-8-12-->
</table>
<input type=hidden name='mode' id='mode' value='<%=mode%>'>
<input type=hidden name=equipment_code1 value="<%=equipment_code%>">
<input type=hidden name=long_desc1 value="<%=long_desc%>">
<input type=hidden name=short_desc1 value="<%=short_desc%>">
<!--Added by MuthuN against RUT-CRF-0091-->
<input type=hidden name='location1' id='location1' value="<%=location%>">
<!-- Added by Muthu for RUT-CRF-0057 -->
<input type=hidden name=image_file1 value="<%=image_file%>">
<!-- Added by Muthu for RUT-CRF-0057 -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


