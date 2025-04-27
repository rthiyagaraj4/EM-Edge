<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8"%> 
<%@ page import ="eOR.OrderEntryBillingQueryBean,eOH.*,eOT.*,java.util.HashMap,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager"  %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% 

 String locale = (String)session.getAttribute("LOCALE"); 
 try{
		//bean_id name shouldn't be changed.
		String oh_bean_id 		= "OHBillingBean";
		String oh_bean_name 	= "eOH.OHBillingBean";
		OHBillingBean oh_bean	= (OHBillingBean)getBeanObject( oh_bean_id, oh_bean_name, request );

		String or_bean_id 		= "Or_billingQueryBean";
		String or_bean_name 	= "eOR.OrderEntryBillingQueryBean";
		OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request );

		String order_id			= checkForNull(request.getParameter("order_id"));
		String order_line_num	= checkForNull(request.getParameter("order_line_num"));
		String chart_num		= checkForNull(request.getParameter("chart_num"));
		String chart_line_num	= checkForNull(request.getParameter("chart_line_num"));
		String task_code		= checkForNull(request.getParameter("task_code"));
		String task_order_catalog_code		= checkForNull(request.getParameter("task_order_catalog_code"));
		String key		= checkForNull(request.getParameter("key"));
		String key_line		= checkForNull(request.getParameter("key_line"));
		String patient_id	= checkForNull(request.getParameter("patient_id"));
		String episode_type	= "";
		String episode_id	= "";
		String encounter_id	= "";
		String patient_class = "";
		String pract_staff_id = "";
		String visit_id = "";
		String bl_data_exists_yn	= checkForNull(request.getParameter("bl_data_exists_yn"));

		HashMap bill_info	= new HashMap();
		HashMap patient_dtls_hash	= new HashMap();
		StringBuilder bl_bfr = new StringBuilder();


		bill_info = or_bean.getOrderBillDtls(key+key_line);	

		if(bill_info==null){
			bill_info = new HashMap();
			bill_info.put("key",key);
			bill_info.put("key_line_no",key_line);
			bill_info.put("task_code",task_code);
			bill_info.put("chart_num",chart_num);
			bill_info.put("locale",locale);
			bill_info.put("module_id","OH");
			bill_info.put("quantity","1");
			//populate billing details from OTBillingBean........	
			//bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
			// Get the patient details 
			//String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),ENCOUNTER_ID,PATIENT_CLASS,PRACTITIONER_ID FROM OH_RESTORATIVE_CHART_DTL WHERE OPERATING_FACILITY_ID=? AND PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'";
			String SQL = "SELECT PATIENT_ID,EPISODE_TYPE,EPISODE_ID,VISIT_ID,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI'),ENCOUNTER_ID,PATIENT_CLASS,PRACTITIONER_ID FROM OH_RESTORATIVE_CHART_DTL WHERE PATIENT_ID=? AND CHART_NUM=? AND CHART_LINE_NUM=? AND NVL(COND_CLOSED_YN,'N') = 'N'";
			Connection connection  = null ;
			PreparedStatement pstmt= null ;
			ResultSet rst = null;
		try{
			connection	= ConnectionManager.getConnection(request);
			pstmt=connection.prepareStatement(SQL);
			pstmt.setString(1,patient_id);		
			pstmt.setString(2,chart_num);		
			pstmt.setString(3,chart_line_num);	
			rst = pstmt.executeQuery();
			while(rst.next()){
				episode_type	= rst.getString(2);
				episode_id		= CommonBean.checkForNull(rst.getString(3));
				visit_id		= CommonBean.checkForNull(rst.getString(4),"1");
				encounter_id	= rst.getString(6);
				patient_class	= rst.getString(7);
				pract_staff_id	= rst.getString(8);
				bill_info.put("patient_id",rst.getString(1));
				bill_info.put("episode_type",episode_type);
				bill_info.put("episode_id",episode_id);
				bill_info.put("visit_id",visit_id);
				bill_info.put("service_date",rst.getString(5));
				bill_info.put("encounter_id",encounter_id);
				bill_info.put("patient_class",patient_class);
				bill_info.put("pract_staff_id",pract_staff_id);
			}
		}catch ( Exception e ) {
	        e.printStackTrace() ;
		}finally {
            try{
				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				if(connection!=null) 
					ConnectionManager.returnConnection(connection,request);
             }catch(Exception es){es.printStackTrace();}
        }
		

			
			ArrayList bill_dtls= new ArrayList();
			bl_data_exists_yn="Y";
			if(bl_data_exists_yn.equals("Y")){
				ArrayList episode_visit_list = oh_bean.getEpisodeAndVisitId(encounter_id);
				episode_id = (String) episode_visit_list.get(0);
				visit_id = (String) episode_visit_list.get(1);
				//bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,key,order_line_num,patient_id,encounter_id,patient_class,pract_staff_id);	
				bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,encounter_id,patient_class,pract_staff_id);	

				//bill_dtls = oh_bean.getBillDetails(task_code,episode_type,"OH",key,order_line_num,patient_id,episode_id,visit_id, encounter_id,"1",pract_staff_id,facility_id,locale,"TASK");
			}else{				
				bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,"","",patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				//bill_dtls=or_bean.getBillChargeDetails("1",task_order_catalog_code,(String)bill_info.get("service_date"),locale,"","",patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
			}
			
			patient_dtls_hash	= oh_bean.formatBillingDetails(bill_dtls);
			bill_info.putAll(patient_dtls_hash);

			or_bean.setOrderBillDtls(key+key_line,bill_info);
			putObjectInBean(or_bean_id,or_bean,request);
			//bill_info.clear();
		}
		
		bl_bfr.append(bill_info.get("key")).append("::");				//0
		bl_bfr.append(bill_info.get("key_line_no")).append("::");		//1
		bl_bfr.append(bill_info.get("task_code")).append("::");			//2
		bl_bfr.append(bill_info.get("patient_id")).append("::");		//3
		bl_bfr.append(bill_info.get("episode_type")).append("::");		//4
		bl_bfr.append(bill_info.get("episode_id")).append("::");		//5
		bl_bfr.append(bill_info.get("visit_id")).append("::");			//6
		bl_bfr.append(bill_info.get("encounter_id")).append("::");		//7
		bl_bfr.append(bill_info.get("service_date")).append("::");		//8
		bl_bfr.append("P").append("::");								//9
		bl_bfr.append(bill_info.get("pract_staff_id")).append("::");	//10
		bl_bfr.append(bill_info.get("serv_panel_ind")).append("::");	//11
		bl_bfr.append(bill_info.get("serv_panel_code")).append("::");	//12
		bl_bfr.append(bill_info.get("bl_panel_str")).append("::");		//13
		bl_bfr.append(bill_info.get("total_payable")).append("::");		//14
		bl_bfr.append(bill_info.get("patient_payable")).append("::");	//15
		bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");	//16
		bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");	//17
		bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");			//18
		bl_bfr.append(bill_info.get("quantity")).append("::");									//19

		out.println(bl_bfr.toString());
		bl_bfr.setLength(0);
	}catch(Exception e){
		System.err.println("Exception in OHBLGetBillDetails:::"+e);
		e.printStackTrace();
	}
%>

	
