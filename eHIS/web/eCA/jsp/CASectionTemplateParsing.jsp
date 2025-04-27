<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
String selcode = request.getParameter("selcode") == null ? "" : request.getParameter("selcode");
String selopt = request.getParameter("selopt") == null ? "" : request.getParameter("selopt");
//String sec_hdg_code=request.getParameter("sec_hdg_code");
//String NOTE_TYPE=request.getParameter("NOTE_TYPE");
String checkedAll = "checked";
String checkedNote = "";
String checkedSection = "";
String checkedModule = "";
String dis_style = "";
String dis_fromto = "";


if(selopt.equals("A"))
{
	checkedAll = " checked ";
	checkedNote = "";
	checkedSection = "";
	checkedModule = "";
	dis_style = "display:none";
	dis_fromto= "display";
}
else if(selopt.equals("N"))
{
	checkedAll = "";
	checkedNote = " checked ";
	checkedSection = "";
	checkedModule = "";
	dis_style = "display";
	dis_fromto= "display:none";
}
else if(selopt.equals("S"))
{
	checkedAll = "";
	checkedNote = "";
	checkedModule = "";
	checkedSection = " checked ";
	dis_style = "display";
	dis_fromto = "display:none";
}
else if(selopt.equals("P"))
{
	checkedAll = "";
	checkedNote = "";
	checkedModule = "checked";
	checkedSection = "";
	dis_style = "display";
	dis_fromto = "display:none";
}

%>
<html>
<head>

<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/CASectionTemplateParsing.js'></script>
	<script language=javascript   src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<form name="TemplateParsingForm" id="TemplateParsingForm" target='messageFrame'>
<%
Connection con = null;
PreparedStatement ps = null;
ResultSet rs = null;
String sql="";
try{
con = ConnectionManager.getConnection(request);
sql = "select MODULE_ID,MODULE_NAME   from SM_module where MODULE_GROUP_ID='SS' order by 2";
ps = con.prepareStatement(sql);
rs = ps.executeQuery();
%>
<br><br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='85%' align=center>
	<tr>
		<td class=label ><fmt:message key="eCA.SectionScope.label" bundle="${ca_labels}"/></td>
		<td class='fields'>
		<input type='radio' name='selopt' id='selopt' value='A' onclick ='Change_mode(this)'<%=checkedAll%>><fmt:message key="Common.all.label" bundle="${common_labels}"/> 
		<input type='radio' name='selopt' id='selopt' value='N' onclick='Change_mode(this)'<%=checkedNote%>><fmt:message key="Common.notes.label" bundle="${common_labels}"/> 
		<input type='radio' name='selopt' id='selopt' value='S'  onclick='Change_mode(this)'<%=checkedSection%>><fmt:message key="Common.Section.label" bundle="${common_labels}"/>
		<input type='radio' name='selopt' id='selopt' value='P'  onclick='Change_mode(this)'<%=checkedModule%>><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<tr style = "<%=dis_style%>">
		<%if(checkedModule.equals("")){%>
		<td class=label><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<%}%>
<%

		if(mode.equals("Update"))
		{
		if(selopt.equals("N"))
		{
%>
		<input type='text' name='selcodedesc' id='selcodedesc' value=""  onChange='resetValues();'  OnKeyPress='return CheckForSpecialChar(this)' onBlur='getNote(this);setSelCode(selcode);'><input type='hidden' name='selcode' id='selcode' value=""><input type='button' name='selcode_desc_search' id='selcode_desc_search' value='?' class='button' onClick='resetValues();getNote(this);setSelCode(selcode);'><img SRC="../../eCommon/images/mandatory.gif">
		
<%			
		}			
		else if(selopt.equals("S"))
		{
%>
		<input type='text' name='selcodedesc' id='selcodedesc' value=""  onChange='resetValues();'   onBlur='getSections(selcode,this,this);setSelCode(selcode);'><input type='hidden' name='selcode' id='selcode' value=""  ><input type='button' name='selcode_desc_search' id='selcode_desc_search' value='?' class='button' onClick='resetValues();getSections(selcode,selcodedesc,this);setSelCode(selcode);'><img SRC="../../eCommon/images/mandatory.gif">
<%
		}		
		else if(selopt.equals("P"))
		{
%>
			<td class ='label' ><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
			<td class ='fields' >
			<select name ="selcodedesc"  maxlength='2' onchange='setSelCode(this);'><option  value="">----------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				
<%
		while(rs.next())
		{

				out.println("<option value='"+rs.getString(1)+"'>"+rs.getString(2)+"</option>");		
				
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
%>			</select><img SRC="../../eCommon/images/mandatory.gif">
		<input type='hidden' name='selcode' id='selcode' value=""  >
		
	<%
		}	
		}
%>
	</td>
</tr>

<tr  id='from' style="<%=dis_fromto%>">
		<td class=label ><fmt:message key="eCA.FromSection.label" bundle="${ca_labels}"/></td>
		<td class='fields'>
<%
 if(selopt.equals("A"))
 {
%>
		<input type='text' name='fromsectiondesc' id='fromsectiondesc' value="" onBlur='getFromSection(fromsection,this,this);setFromCode(fromsection);' onChange='resetValues();'><input type='hidden' name='fromsection' id='fromsection' value=""><input type='button' name='fromsection_desc_search' id='fromsection_desc_search' value='?' class='button' onClick='resetValues();getFromSection(fromsection,fromsectiondesc,this);setFromCode(fromsection);'>
<%
 }
%>
	</td>
	</tr>
<tr id="to" style="<%=dis_fromto%>">
<td class=label ><fmt:message key="eCA.ToSection.label" bundle="${ca_labels}"/></td>
		<td class='fields'>
<%
 if(selopt.equals("A"))
 {
%>
		<input type='text' name='tosectiondesc' id='tosectiondesc' value="" onBlur='getToSection(tosection,this,this);setToCode(tosection);'   onChange='resetValues();'/><input type='hidden' name='tosection' id='tosection' value=""/><input type='button' name='tosection_desc_search' id='tosection_desc_search' value='?' class='button' onClick='resetValues();getToSection(tosection,tosectiondesc,this);setToCode(tosection);'>
<%
 }
}
catch(Exception ee)
	{
		//out.println("Exception in CASectionTemplateParsing.jsp "+ee.toString());//common-icn-0181
	        ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		try{
				if(con != null) 
			  {	
				ConnectionManager.returnConnection(con);
				con.close();
			  }
			}
		catch(Exception e){
			//out.println(e);//common-icn-0181
			e.printStackTrace();//COMMON-ICN-0181
			}
	}
%>
		</td>
</tr>

</table>
<input type=hidden name="select_mode" id="select_mode" value="<%=selopt%>">
<input type=hidden name="select_code" id="select_code" value="<%=selcode%>">
<input type=hidden name="from_section" id="from_section" value="">
<input type=hidden name="to_section" id="to_section" value="">
<input type ='hidden' name='mode' id='mode' value=''> 

</form>
</body>
</html>

