<!DOCTYPE html>
<%@page  import ="eCommon.Common.CommonBean,java.util.HashMap,java.util.Hashtable,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	HashMap cancel_map = new HashMap();
	String func_mode = CommonBean.checkForNull(request.getParameter("func_mode"));
	try{
			
		Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
		hash = (Hashtable)hash.get( "SEARCH" );
		//instantiation of Bean
		String bean_id = "CancelCheckInBean";
		String bean_name = "eOT.CancelCheckInBean";
		CancelCheckInBean bean = (CancelCheckInBean)mh.getBeanObject( bean_id, request, bean_name);

		if(func_mode.equals("cancelCheckInDtls")){
			cancel_map.put("oper_num",(String) hash.get("oper_num"));
			cancel_map.put("slate_user_id",(String)hash.get("slate_user_id"));
			cancel_map.put("reason_code",(String)hash.get("reason_code"));
			cancel_map.put("cancel_date",(String)hash.get("cancel_date"));
			String err_txt = bean.cancelCheckInDtls(cancel_map);
			out.println(err_txt);
		}
	}catch(Exception e){
		cancel_map=null;
		out.println("Err Msg from CancelCheckInvalidation.jsp "+e.getMessage());
	}
%>
			
