
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eMP.ExternalSourceDetails.label" bundle="${mp_labels}"/></title>
	</head>

	<iframe name='dtl' id='dtl'    src="fetch_ext_vals.jsp"  noresize  style='height:92vh;width:100vw;border:0'></iframe>
	<iframe name='comp' id='comp'    src="fetch_ext_valcomp.jsp" scrolling='no' noresize style='height:8vh;width:100vw;border:0'></iframe>
	
</html>


