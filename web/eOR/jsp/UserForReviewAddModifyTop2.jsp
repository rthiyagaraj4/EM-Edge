<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String function_id = request.getParameter( "function_id" ) ;

%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
   	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/UserForReview.js"></script>
 	<script language="JavaScript"> function_id = "<%=function_id%>"</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
//	String readOnly = "" ;
//	String checked = "checked" ;
	/* Mandatory checks start */
	String mode			=	 request.getParameter( "mode" ) ;
	String type			=	 request.getParameter( "type" ) ;
	String resp_id		=	 request.getParameter("resp_id");
	String pract_id		=	 request.getParameter("pract_id");
	String resp_name	=	 request.getParameter("resp_name");
	String pract_name	=	 request.getParameter("pract_name");

	if(type == null)type = "";
	if(resp_id == null)resp_id = "";
	if(pract_id == null)pract_id = "";
	resp_id = resp_id.trim();
	pract_id = pract_id.trim();

	String bean_id = "Or_UserForReview" ;
	String bean_name = "eOR.UserForReview";
//	String disabled = "" ;
	ArrayList responsibility_Data = new ArrayList();

//	String responsibility_id = (String)session.getValue("responsibility_id") ;
//	String qry_string = "";
//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	UserForReview bean = (UserForReview)getBeanObject( bean_id, bean_name , request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;

/* Initialize Function specific end */
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )  || mode.equals( CommonRepository.getCommonKeyValue("MODE_DELETE") ) ) {
		bean.setResponsibility(resp_id);
		bean.setPractitioner(pract_id);

	}
	

%>
<form name='user_for_review' id='user_for_review' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' >

	
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )&& type.equals("responsibility")){%>
			<tr><td width="35%"   class="label"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/> </td>
		<td ><SELECT name="responsibility" id="responsibility" onChange='loadValues(this)'>
				<option value=''> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					
			<%
				
				
			try{
				responsibility_Data = bean.getAllResponsibility();

				for(int i=0; i<responsibility_Data.size(); i++){
					String[] record = (String [])responsibility_Data.get(i);
			
		%>
				<option value=<%=record[0]%>><%=record[1]%>
			
		<%	
				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		%>
			</SELECT><img src="../../eCommon/images/mandatory.gif"></td></tr>
			
		
		<%
		}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && !resp_id.equals("") && !resp_id.equals(" ")){
		%>
		<tr><td width="35%"   class="label"><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/> </td>
		<td ><input type=text name=resp_disp value="<%=resp_name%>" readonly><input type=hidden name=responsibility value='<%=resp_id%>' ><img src="../../eCommon/images/mandatory.gif"></td></tr>
		
		
		<%}//end of if-else for responsibility%>
	
		<% if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )&& type.equals("practitioner")){%>
		<tr>
		<td width="35%"  class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class="fields"><input type='text' name='practitioner_desc' id='practitioner_desc' value='' size=30 maxlength=40 onFocus='loadValues(this)' onKeyPress='return CheckForNotChars(event)' ><input type='button' name='practitioner_button' id='practitioner_button' class='button'   value='?' onClick='show_practtioner_window(document.getElementById("practitioner_desc"))'><img src="../../eCommon/images/mandatory.gif" align='center'></td>
		<input type='hidden' name='practitioner' id='practitioner' value='' size=30 maxlength=40 >
		</tr>

	
		
		<%}else if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )&& !pract_id.equals("")&& !pract_id.equals(" ")){
		%>
		<tr><td width="35%"   class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td ><input type=text name=pract_disp value="<%=pract_name%>" readonly><input type=hidden name=practitioner value='<%=pract_id%>' ><img src="../../eCommon/images/mandatory.gif"></td></tr>
		
		
		<%}//end of if-else for responsibility%>

</table>
 <input type="hidden" name="mode" id="mode" value="<%=mode%>">
  <input type="hidden" name="prac_sql1" id="prac_sql1" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_SQL2_ADMIN")%>"> 
   <input type="hidden" name="prac_sql" id="prac_sql" value="<%=OrRepositoryExt.getOrKeyValue("SQL_OR_PRACTITIONER_LOOKUP_ADMIN")%>">
</form>

</body>
</html>		
<%
putObjectInBean( bean_id, bean , request) ;  
%>

