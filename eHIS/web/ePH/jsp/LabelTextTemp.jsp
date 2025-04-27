<!DOCTYPE html>
  <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<script language="JavaScript" src="../js/LabelText.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "LabelTextBean" ;
	String bean_name = "ePH.LabelTextBean";	
	String label_text_id= "";
	String label_text_1="";
	String label_text_2="";
	String label_text_type="";
	String label_text_1_loc_lang="";
	String label_text_2_loc_lang="";
	String eff_status="";	

	label_text_id = request.getParameter("label_text_id")==null?"":request.getParameter("label_text_id");
	label_text_1 = request.getParameter("label_text_1")==null?"":request.getParameter("label_text_1");
	label_text_2 = request.getParameter("label_text_2")==null?"":request.getParameter("label_text_2");
	label_text_type = request.getParameter("label_text_type")==null?"":request.getParameter("label_text_type");
	label_text_1_loc_lang = request.getParameter("label_text_1_loc_lang")==null?"":request.getParameter("label_text_1_loc_lang");
	label_text_2_loc_lang = request.getParameter("label_text_2_loc_lang")==null?"":request.getParameter("label_text_2_loc_lang");
	eff_status = request.getParameter("eff_status")==null?"N":request.getParameter("eff_status");
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;
		
	LabelTextBean bean = (LabelTextBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLABEL_TEXT_1_LOC_LANG(label_text_1_loc_lang) ;
	bean.setLABEL_TEXT_2_LOC_LANG( label_text_2_loc_lang ) ;

%>
<body onMouseDown="" onKeyDown="lockKey()">
<form>
</form>
</body>
<script>
  apply_1();
</script>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

