<!DOCTYPE html>

<%@page  import="eOT.OperationDtlBean" %>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String bean_id = "OperationDtlBean";
	String bean_name = "eOT.OperationDtlBean";
	OperationDtlBean chk_bean = (OperationDtlBean)mh.getBeanObject( bean_id, request, bean_name);
	
	Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
	HashMap map = CToHashMap((Hashtable)hash.get("SEARCH"));
	
	String strMode=checkForNull(request.getParameter("mode"),"U");
	String key=checkForNull(request.getParameter("key"));
	char choice = strMode.charAt(0);
//I-insert U-update D-delete
	switch(choice){
	case 'D' :
		chk_bean.removeOperationDtls(key);
		break;
	case 'I' :
		chk_bean.recordOperationDtls(map);
		break;
	case 'U' :
		HashMap hash_temp = (HashMap) chk_bean.getOperationDtls().get(key);
		hash_temp.putAll(map);
		chk_bean.updateOperationDtls(key,hash_temp);
		break;
	}
	out.println("writed in Session");
%>
