<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.net.URLEncoder.*" %>

<html>	

<script language='javascript' src='../../eCommon/js/common.js'></script>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
<script src='../../eOA/js/BookAppointment.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="oabill" id="oabill">
<% 
Connection con = null;

java.util.Properties p;

try{
	request.setCharacterEncoding("UTF-8");	
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address ;
	client_ip_address = p.getProperty("client_ip_address");
    String fromPage=(String) request.getParameter("from")==null?"":request.getParameter("from");
	String pat_id1				=	request.getParameter("patient_id");
	if(pat_id1 ==null) pat_id1="";
	String module_id = request.getParameter("calling_module_id");
	String calling_function_id = "BOOKING";
	String episode_type = request.getParameter("episode_type");
	String blng_grp				=	request.getParameter("blng_grp");
	if(blng_grp ==null) blng_grp="";
	String apptrefno=request.getParameter("apptrefno");
	if(apptrefno ==null) apptrefno="";
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";
	String bl_operational			= (String)session.getValue("bl_operational"); 
	if(fromPage.equals("finacial_dtl")){
	//String bl_operational=(String)hash.get("bl_operational");
	//String module_id="IP";
	//String calling_function_id="BOOKING";
	//String episode_type=(String)hash.get("episode_type");
	//String blng_grp=(String)hash.get("blng_grp");
	if(from_page.equals("")){
		if(bl_operational.equals("Y") && !pat_id1.equals("")){
				if((blng_grp == null || blng_grp.equals(""))){
	%><jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="patient_id" value="<%=pat_id1%>" /><jsp:param name="calling_module" value="<%=module_id%>" /><jsp:param name="calling_function_id" value="<%=calling_function_id%>" /><jsp:param name="episode_type" value="<%=episode_type%>" /><jsp:param name="apptrefno" value="<%=apptrefno%>" /></jsp:include>
	<script>
			parent.frames[0].document.Bkappt_form.billing_group.value=document.forms[0].billing_group.value;
			parent.frames[0].document.Bkappt_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;
			parent.frames[0].document.Bkappt_form.bl_operation.value=document.forms[0].bl_operation.value;
			
	</script>	
			
		<%}
		}
	}else{
	if(bl_operational.equals("Y")){
				if((blng_grp == null || blng_grp.equals(""))){
	%><jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" ><jsp:param name="flush" value="true" /><jsp:param name="patient_id" value="<%=pat_id1%>" /><jsp:param name="calling_module" value="<%=module_id%>" /><jsp:param name="calling_function_id" value="<%=calling_function_id%>" /><jsp:param name="episode_type" value="<%=episode_type%>" /><jsp:param name="apptrefno" value="<%=apptrefno%>" /></jsp:include>
	<script>
			parent.frames[0].document.Bkappt_form.billing_group.value=document.forms[0].billing_group.value;
			parent.frames[0].document.Bkappt_form.bl_future_admn_YN.value=document.forms[0].bl_future_admn_YN.value;
			parent.frames[0].document.Bkappt_form.bl_operation.value=document.forms[0].bl_operation.value;
			
	</script>			
<% }
	}
		}
out.println("<script>grabFinancialDetails();</script>");
}// end if conditions for calling page 	
}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally{

	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%>		
</body>
</form>
</html>

