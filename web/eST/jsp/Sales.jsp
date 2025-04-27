<!DOCTYPE html>
 
<%@ page import=" eST.SalesBean"  	contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>

<html>
<title><%= request.getParameter( "tit" )==null?"":(String)request.getParameter("tit") %></title>
<head>
	<%
	 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<script language='javascript' src='../../eST/js/Sales.js'></script>
	<script language='javascript' src='../../eST/js/StTransaction.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter( "function_id" ) %>"
		menu_id		= "<%= request.getParameter( "menu_id" ) %>"
		module_id	= "<%= request.getParameter( "module_id" ) %>"
    </script>
</head>
<%
	String module_id = (String)request.getParameter("module_id")==null?"ST":(String)request.getParameter("module_id");
	String ref_no    = (String)request.getParameter("ref_no")==null?"":(String)request.getParameter("ref_no");
	String function_id    = (String)request.getParameter("function_id")==null?"":(String)request.getParameter("function_id");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityid=(String)session.getValue("facility_id");
	eST.SalesBean bean = (eST.SalesBean)getBeanObject( "salesBean",  "eST.SalesBean" ,request);
	bean.setLanguageId(locale);
	bean.setModuleId(module_id);
	bean.setRefNo(ref_no);
	bean.setfunction_id(function_id);
	String site_id = bean.getCustomerID();
	// Passing login_facility_id, material_group_code as arguments
	if(!(bean.recordExists(facilityid, "ALL"))) {
		out.println("<script>alert(getMessage('FACILITY_PARAM_NOT_SET','ST'));window.location.href ='../../eCommon/jsp/dmenu.jsp;'</script>");
	}

	


	if(module_id.equals("OT")){				
		if((String)request.getParameter("patient_id")==null||(String)request.getParameter("sal_trn_type")==null){%>
		<script>
			alert("Patint ID and Sale Trn Type cannot be blank");
			let dialogBody = parent.parent.document.getElementById('dialog-body');
                  dialogBody.contentWindow.returnValue = retVal;
    
            const dialogTag = parent.parent.document.getElementById("dialog_tag");    
                 dialogTag.close();   
			//window.close();
		</script>
		<%}
		bean.setPatient_id((String)request.getParameter("patient_id"));
		bean.setPatient_name((String)bean.getPatientName((String)request.getParameter("patient_id")));
		bean.setSal_trn_type((String)request.getParameter("sal_trn_type"));
		bean.setEncounter_id((String)request.getParameter("encounter"));
		bean.setPhysician_id((String)request.getParameter("p_ord_practitioner_id"));
		//Added by Rabbani inc no:26404 on 03/02/12
		bean.setPractitioner_name((String)request.getParameter("p_ord_practitioner_id"));
		//Added By Shaiju on 08/02/2011 Starts
		bean.setSlateUserId((String)request.getParameter("slate_user_id"));
		//Added By Shaiju on 08/02/2011 Ends
		params = "menu_id=ST_MENU&module_id=ST&function_id=ST_SALES&function_name="+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eST.Sales/PatientIssue.label","ST_labels")+"&function_type=F&access=YYYYN&home_required_yn=N&module_id=OT&patient_id="+(String)request.getParameter("patient_id")+"&encounter="+(String)request.getParameter("encounter")+"&sal_trn_type="+(String)request.getParameter("sal_trn_type");
		session.putValue( "queryString",params );
		source = url + params ;
	}

	//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String count		= request.getParameter("count") == null?"0":request.getParameter("count");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");

%>
<%
//putObjectInBean("salesBean",bean,request);
%>
<!-- <frameset rows="42,*,50" > -->
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src="<%= source %>" frameborder=0 scrolling='no' style='height:6vh;width:100vw'></iframe>

	<% if(site_id.equals("MC")){%>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eST/jsp/SalesQueryFrame.jsp?mode=2&<%=params%>" frameborder=0 scrolling='no' style='height:86vh;width:100vw'></iframe>
	<%}else{ %>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' style='height:84vh;width:100vw'></iframe>
	<%}%>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:8vh;width:100vw'></iframe>

<%
if(homepage.equals("Y") && !count.equals("0")){
%>
		<script>
			parent.workAreaFrame.f_query_add_mod.document.location.href="../../eST/jsp/SalesQueryFrame.jsp?mode=2&<%=params%>";
		</script>
<%
}
%>
</html>

