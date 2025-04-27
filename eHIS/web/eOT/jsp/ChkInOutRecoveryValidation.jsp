<!DOCTYPE html>

<%@page   import="java.util.HashMap,java.util.Hashtable,eCommon.XSSRequestWrapper,java.util.ArrayList, eOT.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>

<%-- Mandatory declarations start --%>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
			String locale = (String)session.getAttribute("LOCALE"); 
			String facility_id=(String)session.getValue("facility_id");
			String bean_id = "ChkInOutRecoveryBean";
			String bean_name = "eOT.ChkInOutRecoveryBean";
			ChkInOutRecoveryBean bean = (ChkInOutRecoveryBean)mh.getBeanObject( bean_id, request, bean_name );

			
			HashMap dispose_dtls = null;
			HashMap untoward_dtls = null;
			String func_mode = checkForNull(request.getParameter("func_mode"));
			String key = checkForNull(request.getParameter("recId"));
			String mode = checkForNull(request.getParameter("mode"));
			String db_mode = "";

			Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
			hash = (Hashtable)hash.get( "SEARCH" );
						
	try{
			
		
			if(func_mode!=null && func_mode.equalsIgnoreCase("recordDisposalDtls")){
				dispose_dtls = new HashMap();
				dispose_dtls.put("oper_num",(String) hash.get("oper_num"));
				dispose_dtls.put("anatomical_site_code",(String) hash.get("anatomical_site_code"));
				dispose_dtls.put("anatomical_site_desc",(String) hash.get("anatomical_site_desc"));
				dispose_dtls.put("disposal_code",(String) hash.get("disposal_code"));
				dispose_dtls.put("disposal_desc",(String) hash.get("disposal_desc"));
				dispose_dtls.put("received_by",(String)hash.get("received_by"));
				dispose_dtls.put("given_by", (String) hash.get("given_by"));

				if(mode.equalsIgnoreCase("I")){
					dispose_dtls.put("update_insert_flag","INSERT");
					bean.recordDisposalDtls(dispose_dtls);
					//out.println("Successfully Recorded");
				}else{
					HashMap map =(HashMap)bean.getDisposalDtls(key);
					String update_insert_flag = (String)map.get("update_insert_flag");
					// applicable only for Check-Out Recovery
					if(update_insert_flag.equals("LOAD")) 
						dispose_dtls.put("update_insert_flag","UPDATE");
					else if(update_insert_flag.equals("UPDATE"))
						dispose_dtls.put("update_insert_flag","UPDATE");
					else if(update_insert_flag.equals("INSERT")) //only for Check-In Recovery
						dispose_dtls.put("update_insert_flag","INSERT");
					bean.updateDisposalDtls(key,dispose_dtls);
					//out.println("Successfully Updated");
				}
			}else if(func_mode!=null && func_mode.equals("cancelDisposalDtls")){
				bean.removeDisposalDtls(key);
				//out.println("successfully Deleted");
			}else if(func_mode!=null && func_mode.equalsIgnoreCase("recordUntowardEvtsDtls")){
				untoward_dtls = new HashMap();
				untoward_dtls.put("oper_num",(String) hash.get("oper_num"));
				untoward_dtls.put("slate_user_id",(String) hash.get("slate_user_id"));
				untoward_dtls.put("unusual_occur_code",(String) hash.get("unusual_occur_code"));
				untoward_dtls.put("unusual_occur_desc",(String) hash.get("unusual_occur_desc"));
				untoward_dtls.put("action_remarks",(String) hash.get("action_remarks"));
				untoward_dtls.put("general_remarks",(String) hash.get("general_remarks"));
				if("I".equals(mode)){
					untoward_dtls.put("db_mode",mode);
					bean.recordUntowardEventsDtls(untoward_dtls);
					//out.println("Successfully Recorded");
				}else{
					HashMap map = (HashMap) bean.getUntowardEventsDtls().get(key);
					db_mode = (String)map.get("db_mode");
					map.put("action_remarks",(String) hash.get("action_remarks"));
					map.put("general_remarks",(String) hash.get("general_remarks"));
					if("L".equals(db_mode)) map.put("db_mode","U");
					bean.updateUntowardEventsDtls(key,map);
					//out.println("Successfully Updated");
				}
			}else if(func_mode!=null && func_mode.equals("cancelUntowardEvtsDtls")){
				 HashMap map = (HashMap) bean.getUntowardEventsDtls().get(key);
					db_mode = (String)map.get("db_mode");
				if("L".equals(db_mode) || "U".equals(db_mode) ) map.put("db_mode","D");
				bean.removeUntowardEventsDtls(key);
				//out.println("successfully Deleted");
			}else if(func_mode!=null && func_mode.equals("getSysDateTime")){
				ArrayList date_list = bean.getSysDateTime();
				out.println((String)date_list.get(0)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("getSysDate")){
				ArrayList date_list = bean.getSysDateTime();
				out.println((String)date_list.get(1)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("getSysTime")){
				ArrayList date_list = bean.getSysDateTime();
				out.println((String)date_list.get(2)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("transfer_desc")){
				String transfer_ward_code = checkForNull(request.getParameter("transfer_ward_code"));
				String desc = bean.getNursingUnitDesc(transfer_ward_code);
				//String desc = bean.getNursingUnitDesc(facility_id,transfer_ward_code);
				out.println(desc);
			}else if(func_mode!=null && func_mode.equals("transferclinic_desc")){
				String transferclinic_ward_code = checkForNull(request.getParameter("transfer_ward_code"));
				String clinicdesc = bean.getClinicDesc(transferclinic_ward_code);
				//String clinicdesc = bean.getClinicDesc(locale,facility_id,transferclinic_ward_code);
				out.println(clinicdesc);
			}
	  }catch(Exception e){
	  dispose_dtls = null;
	  untoward_dtls=null;
	  out.println("Err Msg from ChkInOutRecoveryvalidation.jsp"+e.getMessage());
   }

%>
