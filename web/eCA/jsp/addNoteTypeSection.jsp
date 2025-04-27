<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
	<title><fmt:message key="eCA.NoteTypeSection.label" bundle="${ca_labels}"/></title>
	<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
    <script language='javascript' src='../js/NoteTypeSection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement()' onKeyDown="lockKey()">
<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
<form name='frm_noteType_section' id='frm_noteType_section' method='post' action='../../servlet/eCA.NoteTypeSectionServlet' target='messageFrame'>
<%
try{
			conlCon = ConnectionManager.getConnection(request);

			String event_class = "";
			String note_type = request.getParameter("note_type");
			String note_type_desc = request.getParameter("note_type_desc");
			String sec_hdg_code = request.getParameter("sec_hdg_code");
			String sec_hdg_desc = request.getParameter("sec_hdg_desc");
			String note_seq_num = request.getParameter("note_seq_num");
			String chief_yn=request.getParameter("chief_yn")==null?"":request.getParameter("chief_yn");
			String content_type=request.getParameter("content_type")==null?"":request.getParameter("content_type");
			String dis="";
			if (content_type.equals("F") || content_type.equals("R")) dis="";
			else dis="disabled";
			String query_string = request.getQueryString();

			if(note_seq_num == null){
				out.println("<input type='hidden' name='mode' id='mode' value='insert'>");
			}else{
				out.println("<input type='hidden' name='mode' id='mode' value='update'>");
			}
%>
<table cellpadding='3' cellspacing='0' border='0' width='85%' align='center'>

	<tr>
		 <td width="25%" class="label"><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
		 <td width="25%"  class="fields"><%
		StringBuffer sblQry = new StringBuffer();
		StringBuffer sblEventClass = new StringBuffer();
		if(note_type == null)
		{
			sblQry.append("SELECT note_type_desc, note_type, event_class FROM ca_note_type ");
			sblQry.append("WHERE eff_status='E' ");
			sblQry.append("ORDER BY  note_type_desc");

			pstmt = conlCon.prepareStatement( sblQry.toString());
			rslRst = pstmt.executeQuery();
			%><select name="noteType" id="noteType" onChange="populateSections()">
				<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option><%
				int count = 1;
			if(rslRst.next()){
				do
				{
					note_type_desc = rslRst.getString("note_type_desc");
					note_type = rslRst.getString("note_type");
					event_class = rslRst.getString("event_class");
					out.println("<option value='"+note_type+"'>"+note_type_desc+"</option>");
					sblEventClass.append("<input type=hidden name='abc"+ count +"' id='abc"+ count +"' value='"+event_class+"'>");
					count++;
				}while(rslRst.next());
			}
			%></select><%out.println(sblEventClass.toString());
		}else{%><input type=text name='noteType1' id='noteType1' value="<%=note_type_desc%>" disabled><input type=hidden name='noteType' id='noteType' value="<%=note_type%>" ><%}
			%><img src='../../eCommon/images/mandatory.gif'></img>
		  </td>
	
		  <td width="25%"  class="label"><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		  <td width="25%"  ><%if(note_seq_num == null){%><select name="section" id="section" onchange="checkChief_yn(this)"><option> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option></select><%}else{%><input type='text' name='section1' id='section1' value='<%= sec_hdg_desc %>' disabled><input type='hidden' name='section' id='section' value='<%= sec_hdg_code %>'><%}%><img src='../../eCommon/images/mandatory.gif'></img></td>
	</tr>
	
	<tr>
		<td width="25%"  class="label"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
		<td width="25%" class="fields" ><input type='text' name=seq_num size='6' maxlength='6'<%if(note_seq_num!=null){out.println("value='"+note_seq_num+"'");}%>  onkeyPress='return allowValidNumber(this,event,6,0)' OnBlur="CheckPositiveNumberLocal(this)">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img></td>
	
	
			<%
				String checked="";
				if (chief_yn.equals("Y"))	checked="checked";
				else checked="";
		   %>
	
		<td width="25%"  class="label"><fmt:message key="eCA.ChiefComplaintSection.label" bundle="${ca_labels}"/></td>
		<td width="25%" class="fields" ><input type='checkbox' name=chief_yn value='N' onClick='assignValue(this)' <%=checked%>  <%=dis%>></td>
	</tr>
	
<%if( note_seq_num != null){%><input type=hidden name='old_seq_num' id='old_seq_num' value="<%= note_seq_num %>"><%}%>
</table>

<input type='hidden' name='query_string' id='query_string' value="<%=query_string%>">
<input type=hidden name=sectionVal value='<%=sec_hdg_code%>'>
</form>

</body>
</html>
	<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
      //out.println("Exception in addNoteTypeSection.jsp"+e);//common-icn-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conlCon!=null) ConnectionManager.returnConnection(conlCon,request);
}
%>

