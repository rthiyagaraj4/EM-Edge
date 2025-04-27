<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*,eMP.DLAInterfaceUtil,java.io.*" %>
<%@ page import ="org.apache.commons.codec.binary.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eMP/js/dlainterface.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
request.setCharacterEncoding("UTF-8"); 

String locale = ((String)session.getAttribute("LOCALE"));
String nat_id = "";
boolean recordExists = true;
String exception = (String)session.getAttribute("exception");
String dla_image_yn = "N";
if(exception != null)
{
%>
	<script>
	var msg = getMessage("SQL_DB_CONN_FAIL","MP");
	parent.message_frame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
	</script>
<%}
	else
	{
%>

<HEAD>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String user_name=request.getParameter("user_name"); if(user_name==null) user_name="";
	String pass_word=request.getParameter("pass_word"); if(pass_word==null) pass_word="";
	String serach_mode=request.getParameter("search_by"); if(serach_mode==null) serach_mode="";

	String national_id_name=request.getParameter("national_id_name"); if(national_id_name==null) national_id_name="";
	String first_name=request.getParameter("first_name"); if(first_name==null) first_name="";
	String sur_name=request.getParameter("sur_name"); if(sur_name==null) sur_name="";
	String img = request.getParameter("img");
		
	String national_id = (String)request.getParameter("national_id");	
	String encoded = "";
	boolean isFromOracleDB = Boolean.valueOf(request.getParameter("isFromOracleDB"));



	String function_id = (String)session.getAttribute("dla_function_id");

	String sqlserver_query = "SELECT img_autodisp FROM patient WHERE req_comp_name = ? AND pid='"+national_id+"'";
	

	Connection con = null;
	PreparedStatement stmt = null;
	Statement stmt1 = null;	
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;

	InputStream imgStream = null;
//	FileOutputStream outFile = null;

//	OutputStream o = response.getOutputStream();

	byte[] buff	  = null;
	
//	session.removeAttribute("dla_image_yn");
	try
	{
		session.removeAttribute("dla_image");
		if(!isFromOracleDB)
		{
			String today_datetime1 = (String)session.getAttribute("today_datetime");	
			String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");

			con = DLAInterfaceUtil.getConnection("DLAP");
			if(con != null)
			{
				stmt = con.prepareStatement(sqlserver_query);
				stmt.setString(1,dla_machine_name1+"/"+today_datetime1);
				rs = stmt.executeQuery();

				if(rs.next())
				{					
					recordExists = false;
					imgStream = rs.getBinaryStream("img_autodisp");
				}
				
				if(imgStream != null)
				{			
					Blob pat_photo_blob = rs.getBlob("img_autodisp");
					session.setAttribute("pat_photo_blob",pat_photo_blob);
					buff = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());					
				}
			
				if(buff != null)
				{
					encoded = new String((new Base64()).encode(buff));	
					session.setAttribute("dla_image",encoded);				
					dla_image_yn = "Y";
				}		
			}
			else
			{
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle labels = java.util.ResourceBundle.getBundle( "eMP.resources.Messages",loc);					
				String errorString = labels.getString("SQL_DB_CONN_FAIL");
				
				String forward = "<script>parent.message_frame.location.href = '../eCommon/jsp/MstCodeError.jsp?err_num="+errorString+"'</script>";
				out.print(forward);
			}
		}
		else
		{
			con = ConnectionManager.getConnection();				
			stmt1 = con.createStatement();								
			rs1 = stmt1.executeQuery("SELECT NAT_ID_PROMPT FROM MP_PARAM_LANG_VW WHERE MODULE_ID='MP' AND LANGUAGE_ID='"+locale+"'");
			if(rs1.next())
			{
				nat_id = rs1.getString("NAT_ID_PROMPT");
			}		
		
			String new_req = (String)session.getAttribute("new_req");

			// Updating the purge status in case of duplicate citizen ID
			if(new_req != null && new_req.equalsIgnoreCase("Y"))
			{												 
				String today_datetime = (String)session.getAttribute("today_datetime");
				String req_search = (String)session.getAttribute("req_search");
				String dla_machine_name = (String)session.getAttribute("dla_machine_name");

				DLAInterfaceUtil.updatePurgeStatus(today_datetime,dla_machine_name,req_search);
				session.removeAttribute("new_req");
			}
		} 	
	}
	catch(Exception e)
	{
		e.printStackTrace(System.err);
	}
	finally
	{
		try
		{
			if(rs != null) rs.close(); 
			if(rs1 != null) rs1.close();			
			if(stmt != null) stmt.close();
			if(stmt1 != null) stmt1.close();			
			if(isFromOracleDB) ConnectionManager.returnConnection(con);
			else con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace(System.err);
		}	
	}
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="dispAttr()">

<form name="view_dla_interface_result_form1" id="view_dla_interface_result_form1" id="view_dla_interface_result_form1" action="../../servlet/eMP.DLATransactionServlet" method="post">
<div id="image_body" name="image_body" style="visibility:hidden">
<%if(!recordExists){%>
<table cellspacing=0 cellpadding=4 width='100%' align=center>
<tr>
<td class='COLUMNHEADER' width='30%'>&nbsp;</td>
<td class='COLUMNHEADER' width='30%'>&nbsp;</td>
</tr>

<!--
<div id="space1" style="display:block;" height="100%"width="100%">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
</div>
<div id="image1" style="display:none;" width="100%">
<img id='imgid' src='C:\Documents and Settings\ravindranatho\My Documents\My Pictures\10tata.jpg'></td>
</div>
-->



<tr>
<td>
<!-- <applet code="ImageApplet.class" codebase="../applet/" archive="ImageApplet.jar" height="180" width="180" >
	<param name="imageData" value="<%=encoded%>" >
</applet>  -->
 <!--Commented and added the below code for SRR20056-SCF-5529 [IN:024247] by Suresh M on 09.12.2010-->
 <div id="pat_photo" align = 'center'>
 <script>
	 document.getElementById('pat_photo').innerHTML= '<img id="patient_photo" src = "../../eMP/jsp/DLAPaintImage.jsp" height="180" width="180" >';
</script>  
<div> 
</td>
<td>&nbsp;&nbsp;</td>
<!-- <td><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR></td> -->
</tr>
<tr>
<td>&nbsp;&nbsp;</td>
<td>&nbsp;</td>
</tr>
</table>
<table cellspacing=0 cellpadding=4 width='100%' align=right>
<tr>
<td>&nbsp;&nbsp;</td>
<td align="right">
<input class='BUTTON' type="button" name=image_accept id="image_accept" value='<fmt:message key="Common.Accept.label" bundle="${common_labels}"/>' onClick="getAccept()">
<input class='BUTTON' type="submit" name=Image id="image_close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'>
</td>
</tr>
<tr>
<td>&nbsp;&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>&nbsp;&nbsp;</td>
<td>&nbsp;</td>
</tr>

</table>

<!--
<input type='hidden' name='national_id_name' id='national_id_name' value='<%=national_id_name%>'>
<input type='hidden' name='user_name' id='user_name' value='<%=user_name%>'>
<input type='hidden' name='user_name' id='user_name' value='<%=pass_word%>'>
<input type='hidden' name='serach_mode' id='serach_mode' value='<%=serach_mode%>'>
<input type='hidden' name='first_name' id='first_name' value='<%=first_name%>'>
<input type='hidden' name='sur_name1' id='sur_name1' value='<%=sur_name%>'>
<input type='hidden' id="image_path" name='image_path' id='image_path' value='<%=img%>'>
-->
<%
}else if(!isFromOracleDB){
%>
<SCRIPT>
	alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
</SCRIPT>
<%}%>
</div>
<input type="hidden" name="isFromOracleDB" id="isFromOracleDB" id="isFromOracleDB" value="<%=isFromOracleDB%>">
<input type="hidden" name="nat_id" id="nat_id" id="nat_id" value="<%=nat_id%>">
<input type="hidden" name="function_id" id="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="national_id" id="national_id" id="national_id" value="<%=national_id%>">
<input type="hidden" name="mode" id="mode" id="mode" value="close">
<input type="hidden" name="dla_image_yn" id="dla_image_yn" id="dla_image_yn" value="<%=dla_image_yn%>"> 

</form>
</body>
	<%}%>
</html>


