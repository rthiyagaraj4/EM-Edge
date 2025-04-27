<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
%>
<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String patient_id	=	"",			encounter_id	=	"";

	patient_id			=	(request.getParameter("patient_id")==null) ? "" : request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) ? "" : request.getParameter("encounter_id");

	String strKey =	"";

	strKey = patient_id + "~"+encounter_id;
	strKey = strKey.trim();

	sectionBean.removePatientSection(strKey);

	putObjectInBean("sectionBean",sectionBean,session);
%>
<script>
//alert('in clear bean');
	self.location.href='../../eCommon/jsp/error.jsp';
</script>
</html>

