<!DOCTYPE html>
<!-- Added by Rajesh 28-8-12-->
<%@page import="java.io.File"%>
<!-- Added by Rajesh 28-8-12-->
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>

<%
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eOT/js/Components.js" language="javascript"></script>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
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

String mode=request.getParameter("mode");
String ph_module_yn=request.getParameter("ph_module_yn");

String item_code = checkForNull(request.getParameter( "item_code" ));
String chk_checked="";
String chk_value="Y";
String item_code_disable="";
String cross_ref_st__item_code="";
String item_desc="";
String short_desc="";
String consumable_yn="";
String sql="";
//RUT-CRF-0091 by MuthuN Starts Here
String location="";
String customer_id="";
PreparedStatement pstmt_cp = null;
ResultSet rst_cp=null;
//RUT-CRF-0091 by MuthuN Ends Here
//Added by Muthu for RUT-CRF-0057
String image_file="";
String disable_flag="";
//Added by Muthu for RUT-CRF-0057
//Added by Rajesh 5-9-2012
String imageUrl = "";
//Added by Rajesh 5-9-2012
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

//Added by Muthu for RUT-CRF-0057
	String Ot_param_cp="";
con=ConnectionManager.getConnection(request);	
		PreparedStatement pstmt_sm_report_display_cp = null;
	    ResultSet rst_sm_report_display_cp=null;
		//Modified by Rajesh 28-8-2012
		//String sql_sm_report_cp="select nvl(BUILD_ANAESTHESIA_INTO_CR_YN,'N') build from OT_PARAM where rownum = 1";
		String sql_sm_report_cp="select nvl(INSTRUMENT_CSSD_IMAGE,'N') build from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display_cp=con.prepareStatement(sql_sm_report_cp);
		rst_sm_report_display_cp=pstmt_sm_report_display_cp.executeQuery();
		if(rst_sm_report_display_cp !=null && rst_sm_report_display_cp.next())
	   {		Ot_param_cp=checkForNull(rst_sm_report_display_cp.getString("build"));
	   //System.out.println("rst_sm_report_display_cp "+Ot_param_cp); 
	   }
	   if(rst_sm_report_display_cp!=null)rst_sm_report_display_cp.close();
	   if(pstmt_sm_report_display_cp!=null)pstmt_sm_report_display_cp.close();
//Added by Muthu for RUT-CRF-0057

//Added by muthuN for RUT-CRF-0091 on 05-02-2013
	try
		{		
			pstmt_cp = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_cp = pstmt_cp.executeQuery();	
			if ( rst_cp.next() && rst_cp != null )
			{
				customer_id  =  rst_cp.getString(1);
			}
			}
			catch(Exception e)
			{   e.printStackTrace();
				//System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rst_cp != null)   rst_cp.close();
				if (pstmt_cp != null) pstmt_cp.close();
				//if(con!=null) ConnectionManager.returnConnection(con,request); 
			}
//Added by muthuN for RUT-CRF-0091 on 05-02-2013
if(mode.equals("modify"))
{
	//con=ConnectionManager.getConnection(request);
		//sql="SELECT A.ITEM_CODE, A.ITEM_DESC, NVL(A.CONSUMABLE_YN,'N') CONSUMABLE_YN, A.CROSS_REF_ST_ITEM_CODE,B.SHORT_DESC FROM OT_SS_COMPONENTS A,MM_ITEM B WHERE A.CROSS_REF_ST_ITEM_CODE=B.ITEM_CODE(+) AND A.ITEM_CODE=? ";
		if("Y".equals(ph_module_yn)){
			//sql="SELECT A.ITEM_CODE, A.ITEM_DESC, NVL(A.CONSUMABLE_YN,'N') CONSUMABLE_YN, A.CROSS_REF_ST_ITEM_CODE,B.SHORT_DESC,C.IMAGE_FILE FROM OT_SS_COMPONENTS_LANG_VW A,MM_ITEM_LANG_VW B, OT_SS_COMPONENTS C WHERE A.CROSS_REF_ST_ITEM_CODE=B.ITEM_CODE(+) AND A.ITEM_CODE=? AND A.LANGUAGE_ID=? AND B.LANGUAGE_ID(+)=A.LANGUAGE_ID";
			sql="SELECT A.ITEM_CODE, A.ITEM_DESC,A.LOCATION, NVL(A.CONSUMABLE_YN,'N') CONSUMABLE_YN, A.CROSS_REF_ST_ITEM_CODE,B.SHORT_DESC,A.IMAGE_FILE FROM OT_SS_COMPONENTS_LANG_VW A,MM_ITEM_LANG_VW B WHERE A.CROSS_REF_ST_ITEM_CODE=B.ITEM_CODE(+) AND A.ITEM_CODE=? AND A.LANGUAGE_ID=? AND B.LANGUAGE_ID(+)=A.LANGUAGE_ID";
		}else{
			sql="SELECT A.ITEM_CODE, A.ITEM_DESC, NVL(A.CONSUMABLE_YN,'N') CONSUMABLE_YN, NULL CROSS_REF_ST_ITEM_CODE,NULL SHORT_DESC, B.IMAGE_FILE FROM OT_SS_COMPONENTS_LANG_VW A, OT_SS_COMPONENTS B WHERE A.ITEM_CODE=? AND A.LANGUAGE_ID=? ";
		}
		stmt=con.prepareStatement(sql);
		stmt.setString(1,item_code);
		stmt.setString(2,locale);
		rs=stmt.executeQuery();
		while(rs.next()){
			item_code=checkForNull(rs.getString(1));
			item_desc=checkForNull(rs.getString(2));
			location=checkForNull(rs.getString(3));//RUT-CRF-0091 by MuthuN
			consumable_yn=checkForNull(rs.getString(4));
			cross_ref_st__item_code=checkForNull(rs.getString(5));
			short_desc=checkForNull(rs.getString(6));
//Added by Muthu for RUT-CRF-0057
			image_file=checkForNull(rs.getString(7));
//Added by Muthu for RUT-CRF-0057
		}
		chk_checked = ("Y".equals(consumable_yn))?"checked":"";
		chk_value=("Y".equals(consumable_yn))?"Y":"N";
		item_code_disable="disabled";	
}
//Added by Rajesh 5-9-2012
try{
	String facility_id	= (String) session.getValue("facility_id");
	String sql_instr_cssd = "select cssd_image_location from ot_param_for_facility where operating_facility_id = ? ";
	//con = ConnectionManager.getConnection(request);
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
	//System.err.println("Err Msg SetupParam4FacilityOtheretails.jsp "+e.getMessage());
}
finally{
	if(rs!=null)rs.close();
	if(stmt !=null)stmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request); 
}
//Added by Rajesh 5-9-2012
%>
<!-- Modified by Rajesh 28-8-12-->
<% if(Ot_param_cp.equalsIgnoreCase("Y")){%>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;fnSetImgOnLoad()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}
else{%>
<body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%}%>
<!-- Modified by Rajesh 28-8-12-->
<form name="ComponentsAddModify_form" id="ComponentsAddModify_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ComponentsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>

<table border=0 cellspacing=0 cellpadding=3 width='90%'  align='center'>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="item_code" id="item_code" value="<%=item_code%>" size=25 maxlength=20  <%=item_code_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<!-- Modified by Rajesh for Restricting " ' chars-->
		<input type="text" name="item_desc" id="item_desc" value="<%=item_desc%>"  onkeypress="return fnChkForDblQuotes(event);" size='65' maxlength='50'>
	<!-- Modified by Rajesh 28-08-2012 -->
	</td>
	<td>
	<img src='../../eCommon/images/mandatory.gif'></td>
	<!-- Modified by Rajesh 28-08-2012 -->
</tr>

<!--Added by MuthuN against RUT-CRF-0091 on 17-April-2013 starts here-->
<% if(customer_id.equalsIgnoreCase("RTN")){%>
<tr>
<td class=label >
		<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
	<td class='fields'>
		<input type="text" name="location" id="location" value="<%=location%>"  onkeypress="return fnChkForDblQuotes(event);" size='40' maxlength='30' <%=disable_flag%>>
	</td>
</tr>
<%}%>
<!--Added by MuthuN against RUT-CRF-0091 ends here-->

<%
	if(ph_module_yn.equals("Y")){
%>
	<tr>
		<td class=label>
		<fmt:message key="eOT.CrossReferenceItemCode.Label" bundle="${ot_labels}"/></td>
		<td class="fields" >
			<input type="text"  name="desc" id="desc" size='20' value="<%=short_desc%>" onBlur="if(this.value!='')callCrossRefCode(code,desc);">
			<input type="hidden" name="code" id="code"  value="<%=cross_ref_st__item_code%>">
			<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callCrossRefCode(code,desc);">
		 </td>
	</tr>
<%
	}else{
%>
		<input type="hidden"  name="desc" id="desc" size='30' value="<%=short_desc%>" >
		<input type="hidden" name="code" id="code"  value="<%=cross_ref_st__item_code%>">
</tr>

<%
	}
%>

<!-- Added by Muthu for RUT-CRF-0057 -->
<% if(Ot_param_cp.equalsIgnoreCase("Y")){%>
<tr>
	<td class=label width='25%'>
		<fmt:message key="Common.ImageFilename.label" bundle="${common_labels}"/>
</td>
	<td width='25%' class='fields'>
	<!-- Added by Rajesh 28-8-12-->
	  <input type="text" name="image_file" id="image_file" value="<%=image_file%>" size='40' maxlength='40' onblur="fnSetImage(this)" <%=disable_flag%>> 
	<a href="javascript:openDialogWindow_comp_image_display(valueForImage)">Click here to enlarge</a>
	</td>
	<td><div id="compImg"></div></td>
	<!-- Added by Rajesh 28-8-12-->

</tr>
<%}%>
<!-- Added by Muthu for RUT-CRF-0057 -->

<tr>
	<td class=label>
		<fmt:message key="Common.Consumable.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%>  >
	</td>
</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='20%'>&nbsp;</td>
</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name=item_code1 value="<%=item_code%>">
<input type='hidden' name=item_desc1 value="<%=item_desc%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!-- Added by Muthu for RUT-CRF-0057 -->
<input type=hidden name=image_file1 value="<%=image_file%>">
<!-- Added by Muthu for RUT-CRF-0057 -->
</form>
</body>
</html>

