<!DOCTYPE html>
<%@page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
  String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

  java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
  String locale = (String) p1.getProperty("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/QueryNoteTemplate.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
	<body OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="queryTemplateHdrForm" id="queryTemplateHdrForm"  method ='post' target='messageFrame' action=''>
	<BR><BR>
<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	String hdr_det= "select QUERY_DESC,NOTE_TYPE ,ca_get_desc.CA_NOTE_TYPE(NOTE_TYPE,?,2) note_desc,EFF_STATUS from CA_TEMP_QRY_HDR where QUERY_REF =? " ;
	String CurrentDate ="";
	String CurrentTime ="";
	String userId =((String) session.getValue("login_user")).trim();
	String bean_key="";
	String readOnly="";
	String mode ="insert";
	String query_id = "";
	String query_desc = "";
	String note_type = "";
	String note_desc = "";
	String eff_status = "E";
	String checked = "checked";
	String disabled = "disabled";

	query_id = request.getParameter("query_id")==null?"":request.getParameter("query_id");

	
	CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	CurrentTime	= com.ehis.util.DateUtils.getCurrentDate("HM",locale);

	bean_key = userId+CurrentDate+CurrentTime;

	try
	{ 

		con = ConnectionManager.getConnection(request);
		
		if(!query_id.equals("")){
			mode = "modify" ;
		ps = con.prepareStatement(hdr_det);
		ps.setString(1,locale);
		ps.setString(2,query_id);
		rs = ps.executeQuery();

		while(rs.next())
		{
			query_desc = rs.getString("QUERY_DESC")==null?"":rs.getString("QUERY_DESC");
			note_type = rs.getString("NOTE_TYPE")==null?"":rs.getString("NOTE_TYPE");
			note_desc = rs.getString("note_desc")==null?"":rs.getString("note_desc");
			eff_status = rs.getString("EFF_STATUS")==null?"D":rs.getString("EFF_STATUS");
			
		}

		if(rs != null) rs.close();
		if(ps != null) ps.close();

			if(eff_status.equals("E"))
			{
				checked = "checked";
			}
			else
			{
				checked = "";
			}
		}
		if(mode.equals("modify"))
			{
				readOnly ="readonly";
				disabled="disabled";
			}
			else
			{
				readOnly ="";
				disabled="";
			}

	%>
<table border='0' cellspacing='0' cellpadding='3' width='90%' align='center'>
		
		<tr>
			<td class ='label' width='50%'><fmt:message key="eCA.QueryID.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='50%'><input type="text"  name="query_id" id="query_id" value="<%=query_id%>" <%=readOnly%> size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  onBlur=""><img src='../../eCommon/images/mandatory.gif'></td>

		</tr>
		<tr>
			<td class=label width='50%' ><fmt:message key="eCA.QueryDesc.label" bundle="${ca_labels}"/></td>
			<td class='fields' width='50%'><input type="text" name="query_desc" id="query_desc" value="<%=query_desc%>"  size=60 maxlength=60 onKeyPress="checkMaxLimit1(this,60)" onBlur = "return checkMaxLimit1(this,60)"  ><img src='../../eCommon/images/mandatory.gif'></td>
		</tr>
		<tr>
			<td class ='label' width='50%'><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/></td>
			<td class='fields' width='50%'> 
			<input type='text' name='note_type_desc' id='note_type_desc' size=30 maxlength='30' value="<%=note_desc%>" <%=disabled%> onBlur ="getNoteType1(this);" ><input type='button' class='button' value='?' id='src_butn'  name='search_note' id='search_note' onClick="getNoteType(this);" <%=disabled%> ><img src='../../eCommon/images/mandatory.gif'></img><input type="hidden" name="note_type" id="note_type" value="<%=note_type%>">
			
			</td>
		</tr>
		<tr>
			<td class=label><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type="checkbox" name="eff_status" id="eff_status" <%=checked%> value='<%=eff_status%>'  onClick='check(this)' ></td>
		</tr>

</table>
<%
	}
	catch(Exception ee)
	{
		//out.println("Exception in QueryNoteTemplateAddModify.jsp "+ee.toString());//COMMON-ICN-0181
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
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}

%>
		<input type="hidden" name="bean_key" id="bean_key" value="<%=bean_key%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type='hidden' name='global_sel_count' id='global_sel_count' value="0">
		</form>
	<script>
	if('<%=mode%>'=='modify')
	{
		loadDetPageOnModify('<%=query_id%>');
	}

	</script>

	</body>
</html>

