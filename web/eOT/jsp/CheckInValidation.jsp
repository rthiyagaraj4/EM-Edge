<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.util.HashMap,java.util.Hashtable,java.util.Iterator,java.util.Map,eOT.CheckInBean" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	String bean_id = "CheckInBean";
	String bean_name = "eOT.CheckInBean";
	CheckInBean chk_bean = (CheckInBean) mh.getBeanObject( bean_id, request, bean_name );
	try {
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		HashMap map = CToHashMap((Hashtable)hash.get("SEARCH"));
		String func_mode = request.getParameter("func_mode");
		String mode = request.getParameter("mode");
		String key = request.getParameter("recId");
		if(func_mode.equals("recordOperationDtls")){
			 if("I".equalsIgnoreCase(mode)){
				chk_bean.recordOperationDtls(map);
			}else{
				chk_bean.updateOperationDtls(key,map);
			}
		}else if(func_mode.equalsIgnoreCase("cancelOperationDtls")){
					chk_bean.removeOperationDtls(key);
					//out.println("successfully Deleted");
	  }else if(func_mode.equalsIgnoreCase("ReviseBillDtls")) {
		    HashMap hash_temp = (HashMap) chk_bean.getOperationDtls().get(key);
		    hash_temp.putAll(map);
			chk_bean.updateOperationDtls(key,hash_temp);
	 }
}catch(Exception e){
	out.println(e.getMessage());	  
}
%>
