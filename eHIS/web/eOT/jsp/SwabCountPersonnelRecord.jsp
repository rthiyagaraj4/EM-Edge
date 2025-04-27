<!DOCTYPE html>
<%@page  import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement, eOT.Common.*, eOT.*,webbeans.eCommon.*,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<HTML>
<HEAD>
	<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<Script Language="JavaScript" src="../../eOT/js/RecordNursing.js"></Script>
	<Script Language="JavaScript" src="../../eOT/js/RecordSurgeon.js"></Script>
	<Script Language="JavaScript" src="../../eOT/js/SwabCount.js"></Script>
	<script language="JavaScript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String tab = CommonBean.checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();	
%>

</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name = 'PersonnelRecordForm' >
<input type = "hidden"  name='params' id='params'  value="<%=params%>" > 

<%
	String called_from =  CommonBean.checkForNull(request.getParameter("called_from"));
	String refresh_flag=CommonBean.checkForNull(request.getParameter("refresh_flag"));
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	String facility_id = (String) session.getValue("facility_id");
	String oper_room_code = CommonBean.checkForNull(request.getParameter("oper_room_code"));
	String theatre_date = CommonBean.checkForNull(request.getParameter("theatre_date"));
	String doc_level="",surgeon_doc_comp_yn ="",nursing_doc_comp_yn ="";
	String customer_id1=""; // Added for IN:046182
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	if(tab.equals("record_surgeon")){
		surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	} else if(tab.equals("record_nursing")){
		nursing_doc_comp_yn = CommonBean.checkForNull(request.getParameter("nursing_doc_comp_yn"));
	}
	String db_speciality_code="",disable_flag="";

	if(surgeon_doc_comp_yn.equals("Y") || nursing_doc_comp_yn.equals("Y") )
		disable_flag="disabled";
	else 
		disable_flag="";
   
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		 pstmt=con.prepareStatement(sql_sm_report); // Added for IN:046182
		 rst=pstmt.executeQuery();
		 if(rst !=null && rst.next())
	    {
	    customer_id1=CommonBean.checkForNull(rst.getString("customer_id"));
	    }	
	    if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();// End for IN:046182
		String doc_level_sql ="SELECT DOCUMENTATION_LEVEL, OPER_ROOM_CODE FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND  OPER_NUM='"+oper_num+"'";
		pstmt = con.prepareStatement(doc_level_sql);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           doc_level=rst.getString("DOCUMENTATION_LEVEL");
		   oper_room_code = rst.getString("OPER_ROOM_CODE");
		}
		/* Commented against 39666 on 06-05-2013
		doc_level=doc_level==null?"AS":doc_level;
		doc_level=doc_level.equalsIgnoreCase("null")?"AS":doc_level;
		doc_level=doc_level.equals("")?"AS":doc_level;*/

		doc_level=doc_level==null?"":doc_level;
		doc_level=doc_level.equalsIgnoreCase("null")?"":doc_level;
		doc_level=doc_level.equals("")?"":doc_level;
		//Modified by DhanasekarV 	
		String SQL1 ="SELECT DISTINCT(SPECIALITY_CODE) FROM OT_POST_OPER_PERSONNEL WHERE  OPERATING_FACILITY_ID=? AND  OPER_NUM=?";
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();	 
		while(rst.next()){
           db_speciality_code=rst.getString(1);
		}
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2"));
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,facility_id);
		pstmt.setString(5,oper_num);
		rst = pstmt.executeQuery();
		int index = 0;
		while(rst.next()){
			index++;
			out.println("<script>loadDBRows('"+rst.getString("SPECIALITY_CODE")+"','"+rst.getString("SPECIALITY_DESC")+"','"+rst.getString("ROLE_ID") +"','"+rst.getString("ROLE_DESC")+"','"+rst.getString("PRACTITIONER_ID")+"','"+rst.getString("PRACTITIONER_NAME")+"','"+index+"','"+rst.getString("ROLE_TYPE")+"','L'); </script>");	

		}
		out.println("<script>assignRecId()</script>");
		out.println("<script>refresh()</script>");
	
%>


<table  border='0' cellpadding=3 cellspacing='0' width='100%' align='center'>
<tr>
	 <td class="label" width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
     <td class="fields" width="25%">
		 <select name='speciality' id='speciality' <%=disable_flag%> >
		</select>
	</td>
</tr>		
 <tr> 
	  <td class="label" width="25%"  ><fmt:message key="Common.Role.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width="25%" nowrap>
		   <select name='role_desc' id='role_desc'  onChange="assign(this);" <%=disable_flag%>>
			<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
	<%	  
	    String SQL ="SELECT ROLE_DESC,ROLE_ID ,ROLE_TYPE FROM OT_ROLES_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND NVL(APPL_TO_OT_SLATE,'N') = 'N' AND NVL(STATUS,'E') = 'E'";
		String val = "";
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(SQL) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			val = rst.getString("ROLE_ID")+"##"+rst.getString("ROLE_TYPE");
			
	%>
		<option value="<%=val%>"><%=rst.getString("ROLE_DESC")%></option>

	<%	}
		
	
	%>
		  
		  </select>
		   <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
 
 <tr> 
	  <td class="label" width="25%">
			<fmt:message key="Common.name.label" bundle="${common_labels}"/> </td>
	  <td class="fields" width="25%">
		  <input type='hidden' name='practitioner_id' id='practitioner_id' >
		  <input type='text' name='practitioner_name' id='practitioner_name'  size='20' onblur="if(this.value!='')searchDoctor(practitioner_id,practitioner_name); else practitioner_id.value='';" <%=disable_flag%>> 
		  <input type='button' class='button' value='?' name='DoctorLookUp' id='DoctorLookUp' onClick='searchDoctor(practitioner_id,practitioner_name);' <%=disable_flag%> > <img src='../../eCommon/images/mandatory.gif'></img>
	  </td>
 </tr>
 <tr>    <td class="fields" width="25%"></td>
        <td class="fields" width="25%"></td>
		<td class="fields" width="25%">
		<% if(customer_id1.equalsIgnoreCase("MOHBR")){ // Added for IN:046182%>
		<input type='button' name='view' id='view' class='button' value='View Staff Assignment' onClick='javascript:viewStaffAssignment("<%= theatre_date %>","<%=oper_room_code %>")'  >
		<%}%>	
		<input type='button' name='record' id='record' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();' <%=disable_flag%> >
		<input type='button' name='cancel' id='cancel' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
		</td>
	
</tr>
</table>
<!-- added by Sathish for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='recId' id='recId' value=''>

<input type='hidden' name='oper_num' id='oper_num' value='<%=oper_num%>'>
<input type='hidden' name='called_from' id='called_from' value='<%=called_from%>'>
<input type='hidden' name='db_speciality_code' id='db_speciality_code' value='<%=db_speciality_code%>' >
<input type='hidden' name='role_type' id='role_type' >
<input type='hidden' name='role_id' id='role_id' >
<input type='hidden' name='refresh_flag' id='refresh_flag' value='<%=refresh_flag%>'>
<input type = "hidden"  name="doc_level" id="doc_level"  value="<%=doc_level%>" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<%}catch(Exception e){
		 System.err.println("Err Msg in Personnel Records"+e.getMessage());
	}finally{
			if(rst!=null)rst.close();
			if(rst!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
</form>
</body>
</html>
<script>
	doc_level = document.forms[0].doc_level.value;
	callPopulateList(doc_level);
</script>


