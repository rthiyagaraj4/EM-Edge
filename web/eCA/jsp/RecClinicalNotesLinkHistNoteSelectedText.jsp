<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">  

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"0":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"0":request.getParameter("encounter_id");

	String buffer = "";
	
	StringBuffer buff =new StringBuffer();
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);



	HashMap multiList = manageEmailBean.returnHashMap();


	//Iterator iter = multiList.keySet().Iterator();
	ArrayList list = new ArrayList(multiList.values());


	for(int i=0;i<list.size();++i)
	{
		buff.append(list.get(i));

	}
	//manageEmailBean.clearBean();

	buffer = buff.toString();
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form>

<div id="finalDiv">
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<%=buffer%>
</div> 

<input type="hidden" name="inHTML" id="inHTML" value='<%=java.net.URLEncoder.encode(buffer)%>'>

</form>
</BODY>
</HTML>

<%
	putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
%>

