<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page  import="eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,java.sql.Statement,webbeans.eCommon.*" %>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>
<%
	String locale = (String)session.getAttribute("LOCALE");		
	String params		= request.getQueryString() ;
	String facility_id	=request.getParameter("facility_id");
	String anaesthesia_srl_no	=request.getParameter("anaesthesia_srl_no");
	String refresh_flag="1";

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script  language="JavaScript">
	function assignRecId()
	{
		var rows = parent.parent.parent.ObjectCollect.personnel_rows;
		parent.parent.parent.ObjectCollect.personnel_len=rows.length;
	}

	function refresh()
	{
		var params = document.forms[0].params.value;
		parent.personal_details_frame.location.href='../../eOT/jsp/AT_PostAnaesPersonalDetails.jsp?'+params;
		
	}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="personnel_form" id="personnel_form" >
<input type = "hidden"  name='params' id='params'  value="<%=params%>" > 
<input type = "hidden"  name='locale' id='locale'  value="<%=locale%>" > 
<%
 
	String disable_flag= "Y".equals( request.getParameter("postop_done_yn") )?"disabled":"";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Statement stmt=null;
	ResultSet rs1=null;
	try{
		//Added ORDER BY B.ROLE_DESC in below query for IN024272 on 10/6/2010 by AnithaJ
		String sql_pra="SELECT A.PRACT_TYPE, B.ROLE_DESC,A.PRACTITIONER_ID,C.PRACTITIONER_NAME,A.ROLE_ID FROM  AT_PERSONNEL A, OT_ROLES_LANG_VW B, AM_PRACTITIONER_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID =? AND A.ANAESTHESIA_SERIAL_NUM =? AND	 A.PRACT_TYPE = B.ROLE_TYPE AND A.PRACTITIONER_ID = C.PRACTITIONER_ID AND A.ROLE_ID=B.ROLE_ID ORDER BY B.ROLE_DESC";
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(sql_pra);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,anaesthesia_srl_no);
		rs = pstmt.executeQuery();
		int index = 0;
		while(rs.next()){
			index++;
			out.println("<script>loadDBRows('"+rs.getString("PRACT_TYPE")+"##"+rs.getString("ROLE_ID")+"','"+rs.getString("ROLE_DESC")+"','"+rs.getString("PRACTITIONER_ID")+"','"+rs.getString("PRACTITIONER_NAME")+"','"+index+"','L'); </script>");	
		}
	
%>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">

	<tr>
		<td class="label" width='25%'>
		<fmt:message key="Common.Role.label" bundle="${common_labels}"/>
		</td>
		<td  class='fields' width='25%'>
		<select name='pract_type' id='pract_type' OnChange='clearPractitioner();' <%=disable_flag%> >
		<option value=''>
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	<%

		String pract_sql="SELECT ROLE_DESC, ROLE_TYPE ,ROLE_ID FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND APPL_TO_OT_SLATE='N' AND NVL(STATUS,'E')='E'";
		stmt=con.createStatement();
		rs1=stmt.executeQuery(pract_sql);
		while(rs1!=null && rs1.next())
		{
		%>
		<option value='<%=rs1.getString("ROLE_TYPE")+"##"+rs1.getString("ROLE_ID")%>'><%=rs1.getString("ROLE_DESC")%></option>
		<%
		}
	}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
		try{
		if(pstmt!=null)pstmt.close();
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(stmt!=null)stmt.close();
		    ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
		
	%>
		</select>
		<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td class="label" width='25%'>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
		</td>
		<td class="fields" width='25%'>
			<input type="text"  name="practitioner_name" id="practitioner_name" size='15' value="" onblur="if(this.value!='')callPractitioners(this);else practitioner_id.value=''">
			<input type="hidden" name="practitioner_id" id="practitioner_id" value="">
			<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callPractitioners(practitioner_name);"  <%=disable_flag%> >
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		
	</tr>
	<tr>
		<td class="label" width='25%'></td>
		<td class="label" width='25%'></td>
		<td class="label" width='25%'></td>
		<td class='label' width='25%'>
			<input type='button' name='select_button' id='select_button'class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disable_flag%> >
			<input type='button' name='cancel_button' id='cancel_button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();'  <%=disable_flag%> >
		</td>
	</tr>
</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->

<input type='hidden' name='params' id='params' value='<%=params%>' >
<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >
<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=anaesthesia_srl_no%>' >
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='refresh_flag' id='refresh_flag' value='<%=refresh_flag%>'>
<input type='hidden' name='desc_userdef' id='desc_userdef' >
<%
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");

%>
 </form>
</body>
</html>




