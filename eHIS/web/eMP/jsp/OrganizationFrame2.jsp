<!DOCTYPE html>
<!--
	Developed By       :	Shyam Prasad.P
	Created on   	   :	09/02/2006
	Function		   :	Oraganization
-->
<%@ page session="false" contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script src='../../eMP/js/Organization.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<%
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;
	String function_name=request.getParameter("cfrom");
	String id=request.getParameter("org_id");
	String eff_status=request.getParameter("eff_status");
	String name=request.getParameter("org_name");
	if(function_name==null)function_name="";
	if(id==null)id="";
	if(name==null)name="";
	if(eff_status==null)eff_status="";
	String source1="../../eMP/jsp/AddOrganization.jsp?org_id="+id+"&mode=update";
	String src_sub="../../eMP/jsp/Organisationsub.jsp?org_id="+id+"&org_name="+name+"&eff_statusnew="+eff_status;
	String src_sub_res="../../eMP/jsp/OrganisationsubResult.jsp?org_id="+id;
%>
<frameset rows='80,*'>
<%if(function_name.equals("query")){%>
	<frame name='f_query_add_mod_main_criteria' id='f_query_add_mod_main_criteria' src="<%=source1%>" frameborder=0>
    <%}else{%>
		<frame name='f_query_add_mod_main_criteria' id='f_query_add_mod_main_criteria' src='../../eMP/jsp/AddOrganization.jsp' frameborder=0>
	<%}%>
		<FRAMESET COLS="85%,75%">
		<%if(function_name.equals("query")){
		 if(eff_status.equals("E")){
		%>
			<frame name='patient_sub' id='patient_sub'	  src="<%=src_sub%>" frameborder=0 noresize scrolling='no'>
		<%}
		else
			{%>
              <frame name='patient_sub' id='patient_sub'	  src="<%=src_sub%>" frameborder=0 noresize scrolling='no'> 
			<%}
		}
		else{%>
				<frame name='patient_sub' id='patient_sub'	  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
		<%}if(function_name.equals("query")){
		 if(eff_status.equals("E")){		%>
			<frame name='f_query_add_mod_sub_result' id='f_query_add_mod_sub_result'	   src="<%=src_sub_res%>"  frameborder=0 noresize scrolling='auto'>
			<%}else{%>
                <frame name='f_query_add_mod_sub_result' id='f_query_add_mod_sub_result'	  src="<%=src_sub_res%>" frameborder=0 noresize scrolling='auto'>
			<%}
			}else{%>
				<frame name='f_query_add_mod_sub_result' id='f_query_add_mod_sub_result'	  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto'>
			<%}%>
		</FRAMESET>
</frameset>
					<input type="hidden" name="fname" id="fname" value="<%=function_name%>">
</html>

