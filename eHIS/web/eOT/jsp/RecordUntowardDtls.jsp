<!DOCTYPE html>
<%@page   import="java.util.HashMap,java.util.Hashtable,java.util.ArrayList, eOT.ChkInOutRecoveryBean" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations start --%>
<%	
			String bean_id = "ChkInOutRecoveryBean";
			String bean_name = "eOT.ChkInOutRecoveryBean";
			ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean)mh.getBeanObject( bean_id, request, bean_name );
			HashMap map = new HashMap();
			HashMap sub_map = new HashMap();
			String mode = "";
			boolean trx_flag = true;
			String result = "";
			map = (HashMap) bean.getUntowardEventsDtls();
			int size = map.size();
			if(size>0){
				for(int i=1;i<=size&&trx_flag==true;i++){
					sub_map = (HashMap) map.get(""+i);
					mode = (String) sub_map.get("db_mode");
					if("I".equals(mode)){
						trx_flag =bean.insertUntowardEvtsDtlsDB(sub_map);
					}else if ("U".equals(mode)){
						trx_flag=bean.UpdateUntowardEvtsDtlsDB(sub_map);
					}else if ("D".equals(mode)){
						trx_flag =bean.deleteUntowardEvtsDtlsDB(sub_map);
					}
				}
			}
			result  = (trx_flag)?"RECORD_INSERTED":"RECORD_FAILED";
			out.println(result);
  

%>
