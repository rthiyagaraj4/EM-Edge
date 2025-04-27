
 <%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facilityid=(String)session.getValue("facility_id");  
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<script language='javascript' src="../../eST/js/StCommon.js"></script>
<script language='javascript' src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String index=request.getParameter("index")==null?"-1":request.getParameter("index");
String mode=request.getParameter("mode")==null?"1":request.getParameter("mode");
String bean_id = "ManufacturingReceiptsBean";
String bean_name = "eST.ManufacturingReceiptsBean";

//String disable ="";
ManufacturingReceiptsBean bean = (ManufacturingReceiptsBean) getBeanObject(bean_id, bean_name, request);
bean.initialize();
bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

String dflt_mfg_mode =request.getParameter("dflt_mfg_mode")==null?"R":request.getParameter("dflt_mfg_mode");
bean.setLanguageId(locale);
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	   dflt_mfg_mode = bean.checkForNull((String)bean.fetchRecord("SELECT DFLT_MFG_MODE FROM st_facility_param WHERE facility_id=?",facilityid).get("DFLT_MFG_MODE"),"R");
	 
%>
<%
putObjectInBean(bean_id,bean,request);
%>
<iframe name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/ManufacturingReceiptsQueryCriteria.jsp?mode=<%=mode%>&index=<%=index%>&dflt_mfg_mode=<%=dflt_mfg_mode%>"  frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' src="../../eST/jsp/ManufacturingReceiptsQueryResult.jsp?mode=<%=mode%>&index=<%=index%>&dflt_mfg_mode=<%=dflt_mfg_mode%>" frameborder=0 style='height:80vh;width:100vw'></iframe>
</html>

