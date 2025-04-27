<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<script language="JavaScript" src="../js/RouteForForm.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "RouteForFormBean" ;
	String bean_name = "ePH.RouteForFormBean";
	String form_desc					= "";
	String route_desc					= "" ;
	String action_text_label			= "";
	String action_text_label_loc_lang	= "";
	String PARAM_YN = request.getParameter( "PARAM_YN" ) ;
    ArrayList formList = new ArrayList() ;
if (mode.equals("1")){
	  for(int i=0; i<10;i++)
	{
	form_desc	= 	request.getParameter( "form_desc"+i );
	route_desc	= 	request.getParameter("route_desc"+i ) ;
	action_text_label	= request.getParameter("action_text_label"+i) ;
	action_text_label_loc_lang	= request.getParameter("action_text_label_loc_lang"+i ) ;	

	if (form_desc==null)
		form_desc="";

	if (route_desc==null)
		route_desc="";

	if (action_text_label==null)
		action_text_label="";

	if (action_text_label_loc_lang==null)
		action_text_label_loc_lang="";	

	formList.add(request.getParameter( "form_desc"+i ));
	formList.add(request.getParameter("route_desc"+i ));
	formList.add(request.getParameter("action_text_label"+i) );
	//based on parameter add the below local language

	// The following if condition is commented by P R Venkatasubbu on 7.12.2004 to handle transactions
	// successfully when the local language option is not enabled.
	
		formList.add(request.getParameter("action_text_label_loc_lang"+i ));
}
}
else if (mode.equals("2")){
	form_desc	= 	request.getParameter( "form_desc" );
	route_desc	= 	request.getParameter("route_desc" ) ;
	action_text_label	= request.getParameter("action_text_label" ) ;
	action_text_label_loc_lang	= request.getParameter("action_text_label_loc_lang" ) ;	

	if (form_desc==null)
		form_desc="";

	if (route_desc==null)
		route_desc="";

	if (action_text_label==null)
		action_text_label="";

	if (action_text_label_loc_lang==null)
		action_text_label_loc_lang="";
	
	formList.add(form_desc);
	formList.add(route_desc);
	formList.add(action_text_label);
	//based on parameter add the below local language
	if(	(PARAM_YN.equals("Y"))  )
	{
	formList.add(action_text_label_loc_lang);
	}
}
if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
		
	RouteForFormBean bean = (RouteForFormBean)getBeanObject( bean_id,bean_name,request) ;
// set the value to the bean

	bean.setRecords( formList ) ;

%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form>
</form>
</body>
<% putObjectInBean(bean_id,bean,request); %>
<script>
  apply_1();
</script>
</html>

