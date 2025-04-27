<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8"  import=" ePH.*,ePH.Common.*,eCommon.XSSRequestWrapper"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<% request.setCharacterEncoding("UTF-8");
//added By Himanshu Start.
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
   String title=request.getParameter("drugdesc")==null?"":request.getParameter("drugdesc");
%>
<title> Drug Info for <%=title%></title>

<%
	String cims_bean_id			= "@ExternalProductLinkBean";
	String cims_bean_name		= "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean CIMSBean	= (ExternalProductLinkBean)getBeanObject(cims_bean_id,cims_bean_name,request);

if((CIMSBean.getProdID()).equals("CIMS")){%>
	<iframe name='frameCIMSHeader' id='frameCIMSHeader'	src="../../eCommon/html/blank.html?" frameborder=0 scrolling='no'   noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='frameCIMSDetail' id='frameCIMSDetail' src="../../ePH/jsp/CIMSDrugInfoDetail.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto'   noresize style='height:100vh;width:100vw'></iframe>
	
	<%}else{
		String extprodid=request.getParameter("extprodid");
		String drugdesc=request.getParameter("drugdesc");
		String url;
		url="../../eCommon/html/blank.html";
		String url1;
		url1="../../ePH/jsp/DisplayDrugInfoHeader.jsp?extprodid="+extprodid+"&drugdesc="+drugdesc;
		//this js file implements the closeInfo() method
		String JSFile=request.getParameter("JSFile");
	%>
<iframe name="f_infoheader" id="f_infoheader" frameborder="0" scrolling="no"  src="<%=url1%>" style='height:100vh;width:23vw' ></iframe><iframe name="f_info" id="f_info" frameborder="0" scrolling="auto"  src="<%=url%>" style='height:100vh;width:77vw'></iframe>
	<%}%>
</html>

