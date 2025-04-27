<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
19/08/2014	  IN050582 		Nijitha S										MO-GN-5452
-------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);//MMS-ME-SCF-0038
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
Connection con	=	null;


String sql	= "";
String dis	= "";	
String mode	= "";

String enabled_checked  = "";
String enabled_yn = "checked";//IN050582
String eff_status = "E";//IN050582
String disabled			= "";

String notetypeSql 	= "";
String sectionSql 	= "";
String sec_hdg_code 	= "";

String service_code 	= "";
String service_desc 	= "";
String Note_Type_Desc   ="";

String pract_name 	= "";

String note_type 	= "";
String note_desc 	= "";

String section_code 	= "";
String section_desc 	= "";

String practitioner_id 	= "";
String procedure_yn		= "";

String text_blk		= "";
String text_type_id =""; //[IN033180]
String text_blk_content = ""; //[IN033180]

String text_blk_id=request.getParameter("text_blk_id");
if(text_blk_id==null) 
{
	text_blk_id 	= "";
	service_code	= "";
	practitioner_id = "";
	note_type	= "";
	text_blk	= "";
	sec_hdg_code	= "";
	mode="insert";	
	text_type_id ="T";		//[IN033180]
	text_blk_content ="";
	session.setAttribute("TEXTBLOCK_CONTENT","");
}
else
	mode="modify";
	


try
{
	
	PreparedStatement stmt	=	null;
	ResultSet rs	=	null;
	PreparedStatement stmt3	=	null;
	ResultSet rs3	=	null;
	PreparedStatement stmt4	=	null;
	ResultSet rs4	=	null;
	con=ConnectionManager.getConnection(request);
		
	if(!mode.equals("insert"))
	{
		dis="readOnly";
		//[IN033180] sql=" Select text_blk_id,text_blk,note_type,sec_hdg_code,service_code,practitioner_id,APPLICABLE_CATEGORY from ca_text_blk_by_serv_pract where text_blk_id= ? ";
		//sql=" Select text_blk_id,text_blk,note_type,sec_hdg_code,service_code,practitioner_id,APPLICABLE_CATEGORY,text_type,text_clob_blk from ca_text_blk_by_serv_pract where text_blk_id= ? "; //[IN033180]//IN050582
		sql=" Select text_blk_id,text_blk,note_type,sec_hdg_code,service_code,practitioner_id,APPLICABLE_CATEGORY,text_type,text_clob_blk,eff_status from ca_text_blk_by_serv_pract where text_blk_id= ? ";//IN050582
		stmt=con.prepareStatement(sql);
		stmt.setString(1,text_blk_id);
		rs=stmt.executeQuery();

		if(rs.next())
		{
			text_blk_id	= rs.getString("text_blk_id");
			//[IN033180]text_blk	= rs.getString("text_blk");
			//[IN033180] Start.
			text_type_id = rs.getString("text_type"); 
			if("T".equals(text_type_id)){
				text_blk	= rs.getString("text_blk");
				session.setAttribute("TEXTBLOCK_CONTENT","");
			}else if("E".equals(text_type_id)){
				java.sql.Clob clob_data =(java.sql.Clob) rs.getClob("text_clob_blk");
				if(clob_data==null){
					text_blk_content="";
				}else{
					/*StringBuffer str = new StringBuffer();
					String strng;
					BufferedReader bufferRead = new BufferedReader(clob_data.getCharacterStream());
					System.out.println("-------------->"+bufferRead);
					while ((strng=bufferRead .readLine())!=null)
						str.append(strng);
					
					text_blk_content = str.toString();
					*/
					
					java.io.Reader			content_reader		= null;
					java.io.BufferedReader	bf_content_reader	= null;
					
					content_reader	= clob_data.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_data.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_data.length());

					text_blk_content =java.net.URLEncoder.encode(new String(arr_notes_content),"UTF-8");
					
					session.setAttribute("TEXTBLOCK_CONTENT",text_blk_content);
					//text_blk_content=new String(arr_notes_content);
					bf_content_reader.close();
				}
			}
			//[IN033180] End.
			note_type	= rs.getString("note_type");
			
			if (note_type==null) note_type="";

			sec_hdg_code	= rs.getString("sec_hdg_code");
			if (sec_hdg_code==null) sec_hdg_code="";

			service_code	= rs.getString("service_code");	
			if (service_code==null) service_code="";

			practitioner_id	= rs.getString("practitioner_id");		
			if (practitioner_id==null) practitioner_id="";

			procedure_yn	= rs.getString("APPLICABLE_CATEGORY");		
			if (procedure_yn==null) procedure_yn="";
			
			eff_status 		= rs.getString("eff_status");//IN050582
			if (eff_status==null) eff_status="D";//IN050582
			
		}

			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement("select short_desc FROM am_service where service_code = ? and eff_status='E' ");
			stmt.setString(1,service_code);
			rs=stmt.executeQuery();
			
			if(rs.next())
				service_desc = rs.getString(1); 

			if(service_desc == null)
				service_desc = "";
			
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement("select practitioner_name FROM am_practitioner where practitioner_id = ? and  eff_status='E' ");
			stmt.setString(1,practitioner_id);
			rs=stmt.executeQuery();

			if(rs.next())
				 pract_name = rs.getString(1); 

			if(pract_name == null)
				pract_name = "";


			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement("select note_type_desc  FROM ca_note_type where note_type  = ? and eff_status='E' ");
			stmt.setString(1,note_type);
			rs=stmt.executeQuery();

			if(rs.next())
				 Note_Type_Desc = rs.getString(1); 
			
			if(Note_Type_Desc == null)
				Note_Type_Desc = "";


			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement("select sec_hdg_desc FROM ca_section_hdg  where sec_hdg_code  = ? and eff_status='E' ");
			stmt.setString(1,sec_hdg_code);
			rs=stmt.executeQuery();

			if(rs.next())
				 section_desc = rs.getString(1); 

			if(section_desc == null)
				section_desc = "";

		if(procedure_yn.equals("P"))
		{
			enabled_checked = "checked";
			disabled = "disabled";
			
			Note_Type_Desc="";
			section_desc="";

		}
		//IN050582 Starts
		if(eff_status.equals("D"))
			enabled_yn = "";
		//IN050582 Ends
	}
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language="javascript" src="../js/TextBlock.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
textarea {
  resize: none;
}
</style>

</head>
<%
if(mode.equals("modify"))
{%>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
}
else{
%>
<body class='CONTENT' OnMouseDown="CodeArrest()" onload="FocusFirstElement();" onKeyDown="lockKey()">
<%}%>
<form name="Textblock_form" id="Textblock_form" action="../../servlet/eCA.TextBlockServlet" method="post" target="messageFrame">
<br><br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width="75%" align=center>
<tr>
	<td class=label><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="text_blk_id" id="text_blk_id" value="<%=text_blk_id%>" size="20" maxlength="20" onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" <%=dis%>><img src="../../eCommon/images/mandatory.gif"></td>
</tr>
<!-- [IN033180] Start -->
<tr>
	<td class=label width="30%"><fmt:message key="eCA.TextType.label" bundle="${ca_labels}"/></td>
	<td class='fields' width="70%">
		<select name="text_type_id" id="text_type_id" onchange="chageTextBlock();">
			<%if("T".equals(text_type_id)){%>
				<option value="T" selected> <fmt:message key="eCA.Text.label" bundle="${ca_labels}"/></option>
				<option value="E"><fmt:message key="eCA.Editor.label" bundle="${ca_labels}"/></option>
			<%}else if("E".equals(text_type_id)){%>
				<option value="T"><fmt:message key="eCA.Text.label" bundle="${ca_labels}"/></option>
				<option value="E" selected><fmt:message key="eCA.Editor.label" bundle="${ca_labels}"/></option>
			<%}%>
		</select>
		<a class='fields' href="javascript:openEditorWindow();" id='TE'><U><fmt:message key="eCA.Editor.label" bundle="${ca_labels}"/></U><img src="../../eCommon/images/mandatory.gif"></a>
	</td>
</tr>
<!--<tr>
	<td class=label><fmt:message key="Common.TextBlock.label" bundle="${common_labels}"/></td>
	<td  class='fields'>
		<textarea name="text_block" rows="3" cols ="40" onBlur="checkMaxLimit1(this,4000);makeValidString(this)"><%=text_blk%></textarea><img src="../../eCommon/images/mandatory.gif"></img>

	</td>
</tr>-->
<tr id='TB'>
	<td class=label><fmt:message key="Common.TextBlock.label" bundle="${common_labels}"/></td>
	<td  class='fields'>
		<textarea name="text_block" rows="3" cols ="40" onBlur="checkMaxLimit1(this,4000);makeValidString(this)"><%=text_blk%></textarea><img src="../../eCommon/images/mandatory.gif"></img>

	</td>
</tr>

<!-- [IN033180] End -->
<tr>
	<td class=label><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>	
	<td class='fields' >
		  <input type='text' name='service_desc' id='service_desc'  value="<%=service_desc%>" size="15" maxlength="15"   onBlur='checkBlurClickService(this)' ><input type='hidden' name='service' id='service' value="<%=service_code%>" size="4" maxlength="4" ><input type='button' name='service_desc_search' id='service_desc_search' value='?' class='button' onClick='checkBlurClickService(this)'>
	</td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>	
	<td class='fields' >
		  <input type='text' name='practitioner_desc' id='practitioner_desc'  value="<%=pract_name%>" size="30" maxlength="30"  onBlur='checkBlurClickPractitioner(this)' ><input type='hidden' name='practitioner' id='practitioner' value="<%=practitioner_id%>" size="15" maxlength="15" ><input type='button' name='practitioner_desc_search' id='practitioner_desc_search' value='?' class='button' onClick='checkBlurClickPractitioner(this);'>
	</td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>	
	<td class='fields' >

	<input type='text' name='Note_Type_Desc' id='Note_Type_Desc'  <%=disabled%>  value="<%=Note_Type_Desc%>"   size="30" OnKeyPress='return CheckForSpeChar(event)'  maxlength="30" onBlur='checkBlurClickNoteType(this)' OnChange='enableonDisableSection(Note_Type_Desc);'><input type='hidden' name='notetype' id='notetype' value="<%=note_type%>" size="15"  ><input type='button' name='notetype_desc_search' id='notetype_desc_search' value='?'  <%=disabled%> class='button' onClick='checkBlurClickNoteType(this);'>
	</td>
</tr>


<!--<%
		notetypeSql = "SELECT note_type_desc,note_type FROM ca_note_type WHERE eff_status='E' order by (note_type_desc)";
		stmt3  = con.prepareStatement(notetypeSql);
		rs3   = stmt3.executeQuery();
%>
		  <select name="notetype" id="notetype" <%=disabled%>>
			<option value=""> ----- Select ----- </option>
<%				if(rs3!= null)
				 {
					String note_type1 ="";
				 	while(rs3.next())
					{
						note_type1    = rs3.getString("note_type");
						note_desc    = rs3.getString("note_type_desc");
						if (note_type1.equals(note_type))
						out.println("<option value='"+note_type1+"' selected>"+note_desc+"</option>");
						else
						out.println("<option value='"+note_type1+"'>"+note_desc+"</option>");
					 }
				}
%>
		  </select>
	</td>
</tr>


<tr><td>&nbsp</td><td></td></tr>
<tr>
	<td class=label align=right>Note Type&nbsp;</td>	
	<td width="60%" align="left" colspan="2">
	<input type='text' name='Note_Type_Desc' id='Note_Type_Desc' READONLY   <%=disabled%> value="<%=Note_Type_Desc%>"  size="30"  OnChange='document.forms[0].flagNoteType.value=false'>
	<input type='hidden' name='notetype' id='notetype'  value="<%=note_type%>" size="15" maxlength="15" > <input type='button' name='notetype_desc_search' id='notetype_desc_search' value='?' <%=disabled%> class='button' onClick='checkBlurClickNoteType();'>
	</td>
</tr>
-->
<tr>
	<td class=label><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>	
	<td  class='fields' >

	<input type='text' name='Section_desc' id='Section_desc' disabled  value="<%=section_desc%>"   size="30"  onBlur='checkBlurClickSection(this)' ><input type='hidden' name='section' id='section' value="<%=sec_hdg_code%>" size="15"  ><input type='button' name='section_desc_search' id='section_desc_search' value='?'  disabled class='button' onClick='checkBlurClickSection(this);'>
	</td>
</tr>


<!--<%
		sectionSql = "SELECT sec_hdg_code,sec_hdg_desc FROM ca_section_hdg WHERE eff_status='E' and content_type !='S' order by (sec_hdg_desc)";
		stmt4  = con.prepareStatement(sectionSql);
		rs4   = stmt4.executeQuery();
%>
		  <select name="section" id="section" <%=disabled%>>
			<option value=""> ----- Select ----- </option>
<%				if(rs4!= null)
				 {
				 	while(rs4.next())
					{
						section_code = rs4.getString("sec_hdg_code");
						section_desc = rs4.getString("sec_hdg_desc");
						if (sec_hdg_code.equals(section_code))
						out.println("<option value='"+section_code+"' selected>"+section_desc+"</option>");
						else
						out.println("<option value='"+section_code+"'>"+section_desc+"</option>");
					 }
				}
%>
		  </select>
	</td>
</tr>

-->
<tr id="AP">
	<td class=label><fmt:message key="eCA.ApplicabletoProcedures.label" bundle="${ca_labels}"/></td>	
	<td  class='fields'><input type=checkbox name=procedure_yn value="P" onclick="enableDisable(this)" <%=enabled_checked%>></td>
</tr>
<!--IN050582 Starts-->
<tr>
	<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>	
	<td  class='fields'><input type=checkbox name=eff_status_disp value='<%=eff_status%>' onclick="enabledstatus_disp(this)" <%=enabled_yn%>></td>
	<input type=hidden name='eff_status' id='eff_status' value='<%=eff_status%>'>
</tr>
<!--IN050582 Ends-->
</table>


<input type=hidden name=mode value="<%=mode%>">
<input type=hidden name=sec_hdg_code1 value="<%=sec_hdg_code%>">
<input type ="hidden" name ="flagService" value="true">
<input type ="hidden" name ="flagPractitioner" value="true">
<input type ="hidden" name ="flagNoteType" value="true">
<input type ="hidden" name ="flagSection" value="true">
<input type ="hidden" name ="chkprevservice" value="">
<input type ="hidden" name ="chkprevpract" value="">
<input type ="hidden" name ="textBlockEditorContent" value="<%=text_blk_content%>">
<!--<input type="hidden" name="note_type" id="note_type" value="">-->

</form>
<script>
	chageTextBlock();
	enableDisableSection(document.Textblock_form.Note_Type_Desc);	
</script>
</body>
</html>
<%
	
	if(rs!=null) rs.close();
	if(rs3!=null) rs3.close();
	if(rs4!=null) rs4.close();
	if(stmt!=null) stmt.close();
	if(stmt3!=null) stmt3.close();
	if(stmt4!=null) stmt4.close();
}
catch(Exception e){
	//out.println("Exception in AddModifyTextBlock.jsp"+e.toString());//COMMON-ICN-0181
          e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>

