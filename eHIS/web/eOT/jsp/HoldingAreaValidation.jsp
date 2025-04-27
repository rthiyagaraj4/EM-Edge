<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.Statement,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean,webbeans.eCommon.ConnectionManager,eCommon.Common.*" %>
<%@page   import="java.util.ArrayList,java.util.HashMap,java.util.Hashtable,eOT.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%-- Mandatory declarations start --%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<%-- Mandatory declarations end --%>

<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
			HashMap holding_area = null;
			ArrayList date_list = null;
	try{
	Connection con = null;
	Statement pstmt  = null;
	ResultSet rst = null;

			String func_mode = CommonBean.checkForNull(request.getParameter("func_mode"));
			String mts = CommonBean.checkForNull(request.getParameter("mts"));
					
			Hashtable hash = (Hashtable)xmlObj.parseXMLString(request);
			hash = (Hashtable)hash.get( "SEARCH" );
			String bean_id = "HoldingAreaBean";
			String bean_name = "eOT.HoldingAreaBean";
			HoldingAreaBean hold_bean = (HoldingAreaBean)mh.getBeanObject( bean_id, request, bean_name );
			//Added Against AAKH-SCF-0431
			String oper_num_bil="";
			if(!func_mode.equals("getSysDateTime"))	
			oper_num_bil=checkForNull((String) hash.get("oper_num"));
			//Added Against AAKH-SCF-0431
			String encounter_id="";
			String episode_id="";
			String episode_type="";
			String visit_id="";
			String nature_type="";
			String nature_code="";
			String surgeon_code="";
			String speciality_code="";
			String patient_class="";
			String bl_episode_type="";
			try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.createStatement();
				String sql="SELECT  ENCOUNTER_ID,EPISODE_ID,EPISODE_TYPE,VISIT_ID,NATURE_TYPE,NATURE_CODE,SURGEON_CODE,SPECIALITY_CODE, PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num_bil+"'";
				rst=pstmt.executeQuery(sql);
				if(rst !=null && rst.next())
				{

					encounter_id=checkForNull(rst.getString(1));
					episode_id=checkForNull(rst.getString(2));
					episode_type=checkForNull(rst.getString(3));
					visit_id=checkForNull(rst.getString(4));
					nature_type=checkForNull(rst.getString(5));
					nature_code=checkForNull(rst.getString(6));
					surgeon_code=checkForNull(rst.getString(7));
					speciality_code=checkForNull(rst.getString(8));
					patient_class=checkForNull(rst.getString(9));
				}
	
			}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from CommonValidation.jsp :"+e);
				}
				finally{
					if(rst!=null) rst.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null) con.close();
					}
			String err_text = "";
			String result="";
			try{
				con = ConnectionManager.getConnection(request);
				pstmt = con.createStatement();
				String sql_bl_episode_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"'";
				rst=pstmt.executeQuery(sql_bl_episode_type);
				if(rst !=null && rst.next())
				{
					bl_episode_type=checkForNull(rst.getString(1));
				}
			}catch(Exception e){
					e.printStackTrace();
					System.err.println("Err Msg from CommonValidation.jsp :"+e);
				}
				finally{
					if(rst!=null) rst.close();
					if(pstmt!=null)pstmt.close();
					if(con!=null) con.close();
					}
			if(func_mode!=null && func_mode.equals("updateAndCommitHoldingAreaDtls")){
				holding_area = new HashMap();
				//converting  the hashtable into hashmap
				holding_area.put("change_date_time",(String)hash.get("change_date_time"));
				holding_area.put("oper_num",(String) hash.get("oper_num"));
				holding_area.put("slate_user_id",(String) hash.get("slate_user_id"));
				holding_area.put("change_holding_code",(String)hash.get("change_holding_code"));
				holding_area.put("change_holding_desc",(String)hash.get("change_holding_desc"));
				holding_area.put("accession_line_num",(String)hash.get("accession_line_num"));
				holding_area.put("charge_hold_area_yn",(String)hash.get("charge_hold_area_yn"));
				holding_area.put("mode",(String)hash.get("mode"));
				if(hash.get("chk_out_dt_time").equals(" ")){
					holding_area.put("chk_out_dt_time","");	
				}else{
					holding_area.put("chk_out_dt_time",(String)hash.get("chk_out_dt_time"));
				}
				holding_area.put("bill_acc_temp",(String)hash.get("bill_acc_temp"));
				if(hash.get("calc_charge_units").equals("undefined")){
				holding_area.put("calc_charge_units","");
				}else{
				holding_area.put("calc_charge_units",(String)hash.get("calc_charge_units"));
				}
				if(hash.get("modified_charge_units").equals("undefined")){
					holding_area.put("modified_charge_units","");
				}else{
					holding_area.put("modified_charge_units",(String)hash.get("modified_charge_units"));
				}
				if(hash.get("service_code").equals("undefined")){
					holding_area.put("service_code","");
				}else{
					holding_area.put("service_code",(String)hash.get("service_code"));
				}
				holding_area.put("accession_num",(String)hash.get("accession_num"));
				if(hash.get("accession_line_num").equals("undefined")){
				holding_area.put("accession_line_num","");
				}else{
				holding_area.put("accession_line_num",(String)hash.get("accession_line_num"));
				}
				holding_area.put("patient_id",(String)hash.get("patient_id"));
				holding_area.put("slate_user_id",(String)hash.get("slate_user_id"));
				holding_area.put("hold_area_chrging_stg",(String)hash.get("hold_area_chrging_stg"));
				holding_area.put("chk_holding_area_chrg_yn_stg",(String)hash.get("chk_holding_area_chrg_yn_stg"));
				holding_area.put("mode",(String)hash.get("mode"));
				holding_area.put("reason_inc_exc",(String)hash.get("reason_inc_exc"));
				holding_area.put("inc_exe_blng_wdw",(String)hash.get("inc_exe_blng_wdw"));
//				holding_area.put("speciality_code",reason_inc_exc);
//				holding_area.put("speciality_code",inc_exe_blng_wdw);

				//newly included for calling billing procedures
				holding_area.put("encounter_id",encounter_id);
				holding_area.put("episode_id",episode_id);
				holding_area.put("episode_type",bl_episode_type);
				holding_area.put("visit_id",visit_id);
				holding_area.put("nature_type",nature_type);
				holding_area.put("nature_code",nature_code);
				holding_area.put("surgeon_code",surgeon_code);
				holding_area.put("speciality_code",speciality_code);
				
				err_text = checkForNull(hold_bean.updateAndCommitHoldingAreaDtls(holding_area));

				out.println(err_text);
			}else if(func_mode!=null && func_mode.equals("updateAndCommitCheckinToORDtls")){
				holding_area = new HashMap();
				//converting  the hashtable into hashmap
				holding_area.put("change_date_time",(String)hash.get("change_date_time"));
				holding_area.put("oper_num",(String) hash.get("oper_num"));
				holding_area.put("slate_user_id",(String) hash.get("slate_user_id"));
				err_text = hold_bean.updateAndCommitCheckinToORDtls(holding_area);
				out.println(err_text);					
			}else if(func_mode!=null && func_mode.equals("getSysDateTime")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(0)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("getSysDate")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(1)); //sysdate_date
			}else if(func_mode!=null && func_mode.equals("getSysTime")){
				date_list = hold_bean.getSysDateTime();
				out.println((String)date_list.get(2)); //sysdate_time
			}else if(func_mode!=null && func_mode.equals("convertMts")){
				//used in Nursing Time and Details.
				result = CommonBean.checkForNull(hold_bean.getConvertedMts(mts));
				out.println(result);
			}
	}catch(Exception e){
		e.printStackTrace();
	   holding_area  = null;
	   date_list = null;
	   out.println("Err Msg from HoldingAreavalidation.jsp"+e.getMessage());
   }
   
%>
