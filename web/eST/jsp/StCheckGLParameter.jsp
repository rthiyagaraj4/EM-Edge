<!DOCTYPE html>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import=" eST.*, eST.Common.* , eCommon.Common.*"%>
<script language='javascript' src='../../eST/js/StMessages.js'></script>
<%
	StTransaction bean = (StTransaction)getBeanObject( "stTransaction",  "eST.Common.StTransaction",request  );
	//bean.setAccEntityId((String)session.getAttribute("ACC_ENTITY_ID"));
	//if(!bean.hasGLParameter()) {
%>
		<script language="javascript">
			//alert(getMessage("ST_NOT_INTRFCD_WTH_GL"));	
			//history.go(-1);
		</script>
<%
//	}
	bean = null;
%>

<%
putObjectInBean("stTransaction",bean,request);
%>

