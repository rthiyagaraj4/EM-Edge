<!DOCTYPE html>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,webbeans.eCommon.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>
	<%	
//pmd 29/01/05
//java.util.HashMap defaultParameter = new HashMap();
	String bean_id = "PrintCountSheetBean";
	String bean_name = "eST.PrintCountSheetBean";
	PrintCountSheetBean bean = (PrintCountSheetBean) getBeanObject( bean_id, bean_name, request ) ;
	out.println("f_query_add_mod.document.formPrintCountSheetReportCriteria.p_phy_inv_id.value=\""+bean.getCurr_phy_inv_id_for_rep()+"\"");
	%>
	<%
putObjectInBean(bean_id,bean,request);
%>
