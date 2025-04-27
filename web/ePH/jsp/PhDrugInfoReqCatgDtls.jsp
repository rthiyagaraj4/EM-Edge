<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");	
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	 <script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	 <script language="JavaScript" src="../../ePH/js/PhDrugInfo.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>
<%
ArrayList Reqcatg = null;
ArrayList Enq_Dtl = null;
String check	="";
String dis="";
String replied_by="";
String login_by_name= (String)session.getValue( "login_user" );

String mode	= request.getParameter( "mode" ) ;
if(mode==null) mode="";
String Enq_num	= request.getParameter("Enq_num") ;
if(Enq_num==null) Enq_num="";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";
	//if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
	//return ;
	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList RequestCatg= bean.getRequestCatg();
	int no_of_req=0;
		if(!Enq_num.equals("")){
		
		Reqcatg =bean.getReqCatgDetails();
		Enq_Dtl =bean.getEnquirerDetails();
		replied_by=(String)Enq_Dtl.get(39);
		if(replied_by==null) replied_by="";
		if(!replied_by.equals("")) dis="disabled";
	no_of_req=Reqcatg.size();
	}
String check_records="";
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name='PhDrugInfoReqCatgDtlsForm' id='PhDrugInfoReqCatgDtlsForm'>

<TABLE cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
	
		<TR >
				<TH colspan='6' height='15' width='100%'>&nbsp;<fmt:message key="ePH.RequestCategoryDetails.label" bundle="${ph_labels}"/></TH>
			</TR>
				<TR><TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD>
			</TR>
			<%
			StringTokenizer st=null;
			String sys_def	="";
			String req_cag_code1="";
			int i=0;
			int j=0;
			String req_cag_code="";
			int k=(int)RequestCatg.size();
			int no_of_records=(int)k/2;
			int count=0;
				
				if(RequestCatg.size()>0){
					while(i<k) {
					%> <TR>	<%
						
				req_cag_code = (String)RequestCatg.get(i);
				st=new StringTokenizer(req_cag_code,"**");
				while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
				if(no_of_req >0){
					check="";
					for(int s=0; s<no_of_req; s++){
						check_records=(String)Reqcatg.get(s);
						
						if(check_records.equals(req_cag_code1))
							check="checked";
						
						
					}
				}
				if(j+1<=k){
				%>
			<TD class="label" width="23%" colspan='1' value='<%=req_cag_code%>'><%=RequestCatg.get(i+=1)%>&nbsp;&nbsp;<TD class="label" width="10%" colspan='1' ><input type=checkbox value='<%=req_cag_code%>' name='chk<%=++count%>' <%=check%> <%=dis%>></TD>

				<%check="";
					j=i;
				}
				if(j+1<k){
					req_cag_code = (String)RequestCatg.get(i+=1);
					st=new StringTokenizer(req_cag_code,"**");
				while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
					if(no_of_req >0){
					for(int s=0; s<no_of_req; s++){
						check_records = (String)Reqcatg.get(s);
						if(check_records.equals(req_cag_code1))
							check="checked";
						
						
					}
				}
				%>
				<TD class="label" width="23%" colspan='1' value='<%=req_cag_code%>'><%=RequestCatg.get(i+=1)%>&nbsp;&nbsp;
				<TD class="label" width="10%" colspan='1'><input type=checkbox name='chk<%=++count%>' id='chk<%=count%>' <%=check%> <%=dis%> value='<%=req_cag_code%>'></TD>
				<%	
					check="";
				j=i;
				}
				else{%>
				<TD class="label" width="35%" colspan='2'>&nbsp;&nbsp;</TD>
				<%} if(j+1<k){
					req_cag_code = (String)RequestCatg.get(i+=1);	
					st=new StringTokenizer(req_cag_code,"**");
						while(st.hasMoreTokens()){
				     req_cag_code1=st.nextToken();
					  sys_def=st.nextToken();
					
				}
					if(no_of_req >0){
					for(int s=0; s<no_of_req; s++){
						check_records = (String)Reqcatg.get(s);
						if(check_records.equals(req_cag_code1))
							check="checked";
						
					}
				}
				%>
				<TD class="label" width="23%" colspan='1' value='<%=req_cag_code%>'><%=RequestCatg.get(i+=1)%>&nbsp;&nbsp;
				<TD class="label" width="10%" colspan='1'><input type=checkbox name='chk<%=++count%>' id='chk<%=count%>' <%=check%> <%=dis%> value='<%=req_cag_code%>'></TD>
					<%
					check="";
				j=i;	
				}else{%>
				<TD class="label" width="35%" colspan='2'>&nbsp;&nbsp;</TD>
				<%} %>
			</TR>
				<%
					i=j+1;
				}
				}
				%>
			
		
			<TR><TD class='label' colspan='6'>&nbsp;&nbsp;&nbsp;</TD></TR>
</TABLE>

	
	
	
	<INPUT TYPE="hidden" name="no_of_records" id="no_of_records" VALUE="<%=no_of_records%>">
	<INPUT TYPE="hidden" name="chkBox" id="chkBox" VALUE="<%=no_of_records%>">
</form>
	

</body>
<% putObjectInBean(bean_id,bean,request); %>
</html>

