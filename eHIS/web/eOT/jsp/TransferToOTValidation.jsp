<!DOCTYPE html>
<%
//"java.sql.*, java.util.*, java.io.*, eOT.*"
%>
<%@page   import="java.util.Hashtable, java.util.HashMap, java.util.ArrayList, eOT.*,eCommon.Common.*" %>
<%@page  contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8");%>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		HashMap<String,String> trns_map = new HashMap<String,String>();
		String func_mode = CommonBean.checkForNull(request.getParameter("func_mode"));
		try{
					
			Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
			hash = (Hashtable)hash.get( "SEARCH" );
			String remarks=java.net.URLDecoder.decode((String) hash.get("remarks_desc"),"UTF-8");
			String bean_id = "TransferToOTBean";
			String bean_name = "eOT.TransferToOTBean";
			TransferToOTBean bean = (TransferToOTBean)mh.getBeanObject( bean_id, request, bean_name);

			if(func_mode.equals("recordtransferDtls")){
				trns_map.put("oper_num",(String)hash.get("oper_num"));
				trns_map.put("slate_user_id",(String)hash.get("slate_user_id"));
				trns_map.put("theatre",(String)hash.get("theatre"));
				trns_map.put("reason_code",(String)hash.get("reason_code"));
				trns_map.put("status_code",(String)hash.get("status_code"));
				trns_map.put("remarks_desc",remarks);
				String err_txt = bean.tranferToOTFromRecovery(trns_map);
				out.println(err_txt);
			 }
	  }catch(Exception e){	 
		  trns_map = null;
	  	  out.println("Err Msg from TransferToOTvalidation.jsp "+e.getMessage());
      }
	%>
			
