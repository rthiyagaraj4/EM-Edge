<%@ page import ="eST.AssemblyDetailBean,java.util.ArrayList" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="AssemblyDtlList" scope="session" class="java.util.ArrayList"/>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language='javascript' src="../../eST/js/AssemblyDetail.js"></script>
		<script language='javascript' src="../../eST/js/StCommon.js"></script>
		<script language='javascript' src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/ItemSearch.js"></script>
		<script language="JavaScript" src="../../eMM/js/MmCommon.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String index=request.getParameter("index")==null?"-1":request.getParameter("index");
	AssemblyDtlList.clear();
	String bean_id = "AssemblyDetailBean";
	String bean_name = "eST.AssemblyDetailBean";
	String mode=request.getParameter("mode");
	AssemblyDetailBean bean = (AssemblyDetailBean) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		if (! (mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )){
		bean.clear();
    bean.setInstruction("");
	}
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	ArrayList dataList=new ArrayList();
	ArrayList recordSet=new ArrayList();
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
			dataList=bean.getDataList();
			recordSet=(ArrayList) dataList.get(Integer.parseInt(index));
			bean.setItem_code((String)recordSet.get(0));
			bean.setBase_qty((String)recordSet.get(1));
			bean.setPrep_type((String)recordSet.get(5));
			bean.setPrep_mode((String)recordSet.get(6));
			bean.setProcess_cost((String)recordSet.get(4));
			bean.setLabel_Type((String)recordSet.get(7));
			bean.setItem_desc((String)recordSet.get(8));
			bean.setStock_uom((String)recordSet.get(9));
			bean.setInstruction(bean.checkForNull((String)recordSet.get(10))); //Added by Rabbani #Incno:33366 on:18/10/2012
			bean.setShelfLifeValue((String)recordSet.get(11));//Added for ML-MMOH-CRF-1909
            bean.setShelfLifeFlag((String)recordSet.get(12)); //Added for ML-MMOH-CRF-1909
            bean.getDtlData();
				}
	
%>

<iframe name='selectcriteriaframe' id='selectcriteriaframe'	src="../../eST/jsp/AssemblyDetailCriteria.jsp?mode=<%=mode%>&index=<%=index%>"  frameborder=0 scrolling='no' noresize style='height:16vh;width:100vw'></iframe>
<iframe name='detailframe' id='detailframe' src="../../eST/jsp/AssemblyDetailListResult.jsp?mode=<%=mode%>&index=<%=index%>" frameborder=0 style='height:62vh;width:100vw'></iframe>
<iframe name='addModframe' id='addModframe'	src="../../eST/jsp/AssemblyDetailAddModify.jsp?mode=<%=mode%>"  frameborder=0 scrolling='no' noresize style='height:22vh;width:100vw'></iframe>

<%putObjectInBean(bean_id,bean,request);%>
</html>

