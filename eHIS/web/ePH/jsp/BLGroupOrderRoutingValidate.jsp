<% /*-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/10/2017      IN063877         Devindra       Unused Variables.
--------------------------------------------------------------------------------------------------------------- */
/*Commented for GHL-SCF-1344 */ %>
 
 <%@page import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
	try{
		request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		String bean_id	= request.getParameter( "bean_id" ) ;
		String bean_name= request.getParameter( "bean_name" ) ;
		String ordering_source_type	= (request.getParameter( "ordering_source_type" )==null?"":request.getParameter( "ordering_source_type" ));
		String disp_locn_type = request.getParameter("disp_locn_type");
		String routing_level = request.getParameter( "routing_level" );
		String facility_id	=	request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String routing_code =   request.getParameter("routing_code")==null?"":request.getParameter("routing_code");
		String identity		=	request.getParameter("identity")==null?"":request.getParameter("identity");
		String modifyMode = request.getParameter("modifyMode")==null?"":request.getParameter("modifyMode");
		Hashtable hash		= (Hashtable)XMLobj.parseXMLString( request ) ;
		hash				= (Hashtable)hash.get( "SEARCH" ) ;
		ArrayList altdispdetails=new ArrayList();
		BLGroupOrderRoutingBean bean = (BLGroupOrderRoutingBean)getBeanObject( bean_id,  bean_name , request) ;
		bean.setLanguageId(locale);
		if (identity.equals("LOADDISPLOCANS")){
			ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			out.println(all.size());
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatListInModify('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
			out.println(allD.size());
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeListInModify('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
		}
		if (identity.equals("LOADALLDISPLOCANS")){
			if (ordering_source_type != null){
				ArrayList arrList = bean.loadRelatedLocation(facility_id,ordering_source_type);
				 String QryMode=request.getParameter("QryMode");
				for (int i=0;i<arrList.size();i++){
					if(QryMode!=null){
						out.println( "loadIntoLocationQry(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
					}
					else{
						out.println( "loadIntoLocation(\"" +(String)arrList.get(i)+ "\",\"" +(String)arrList.get(++i)+ "\") ; " ) ;
					}
				}
			}
			if(routing_code != null){
				if(routing_code.equals("ALLA") || routing_code.equals("CMPA") || routing_code.equals("IVOA") || routing_code.equals("ONCA") || routing_code.equals("TPNA")){
					bean.setDispLocnForAdmixtures("Y");
				}
				else{
					bean.setDispLocnForAdmixtures("N");
				}
			}
			if (routing_code ==null||routing_code.equals(""))	{// ||routing_code=="" added for MMS_BETA_0047[IN:046258]
				if ((routing_level != null)){
					ArrayList all = bean.getDataForList();
					ArrayList routingCode = (ArrayList)all.get(2);
					for (int i=0;i<routingCode.size();i++){
						out.println("addDataToRoutingCode('"+routingCode.get(i)+"','"+routingCode.get(++i)+"','"+routingCode.get(++i)+"','"+modifyMode+"')");
					}
				}
			}
			else if ((routing_code != null)&&(!routing_level.equals("G"))){

				ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
			else if ((routing_code != null)&&(routing_level.equals("G"))){
				ArrayList all = bean.getDefaultDispLocDataForDrug(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDefaultDispLocDataForDrugD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
		}
		else if(identity.equals("LOADALLDISPLOCANS_AFTER_UPDATE")){
			if((routing_code != null)&&(!routing_level.equals("G"))){
				ArrayList all = bean.getDataForDefaultDispenseLocation(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDataForDefaultDispenseLocationD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim(),routing_level.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
			else if((routing_code != null)&&(routing_level.equals("G"))){
				ArrayList all = bean.getDefaultDispLocDataForDrug(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<all.size();i++){
					out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
				}
				ArrayList allD = bean.getDefaultDispLocDataForDrugD(facility_id.trim(),disp_locn_type.trim(),routing_code.trim());
				for (int i=0;i<allD.size();i++){
					out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
				}
			}
		}
		else if(identity.equals("S")){
			ArrayList all = bean.getDefaultDispLocDataForSource(facility_id.trim(),ordering_source_type); //shyampriya
			for (int i=0;i<all.size();i++){
				out.println("addRoutineStatList('"+all.get(i)+"','"+all.get(++i)+"')");
			}
			ArrayList allD = bean.getDefaultDispLocDataForSourceD(facility_id.trim()); //shyampriya
			for (int i=0;i<allD.size();i++){
				out.println("addDischargeList('"+allD.get(i)+"','"+allD.get(++i)+"')");
			}
			return;
		}
		else if(identity.equals("loadCustomer")){
			String cust_group_code=request.getParameter("customer_group"); 
			ArrayList customer = bean.getCustomer(cust_group_code); 
			String customername="";                                                // Added for MMSBETA  MMS_BETA_0037[IN046175]
			for (int i=0;i<customer.size();i+=2){
				 customername=customer.get(i+1).toString().replaceAll(" ","%20");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername = java.net.URLEncoder.encode(customername,"UTF-8");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername=customername.replaceAll("%2520","%20");              // Added for MMSBETA   MMS_BETA_0037[IN046175]
				 out.println("addCustomer('"+customer.get(i)+"','"+customername+"')");
			}
		}
		else if(identity.equals("loadCustomerAfterUpdate")){ //loadCustomerclick
			String cust_group_code=request.getParameter("customer_group"); 
			ArrayList customer = bean.getCustomer(cust_group_code); 
			String customername="";    
			for (int i=0;i<customer.size();i+=2){
				 customername=customer.get(i+1).toString().replaceAll(" ","%20");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername =java.net.URLEncoder.encode(customername,"UTF-8");	// Added for MMSBETA  MMS_BETA_0037[IN046175]
				 customername=customername.replaceAll("%2520","%20");              // Added for MMSBETA   MMS_BETA_0037[IN046175]
				out.println("addCustomerAfterEdit('"+customer.get(i)+"','"+customername+"')"); ///addCustomerclick
			}
		}
		else if(identity.equals("loadPolcyType")){
			String cust_group_code=request.getParameter("customer_group"); 
			String customer_id=request.getParameter("customer_id"); ;
			ArrayList polocyType = bean.getPolocyType(cust_group_code,customer_id,facility_id.trim()); 
			for (int i=0;i<polocyType.size();i+=2){
				out.println("addPolocyType('"+polocyType.get(i)+"','"+polocyType.get(i+1)+"')");
			}
		}	
		else if(identity.equals("loadPolicyAfterUpdate")){//loadPolicyclick
			String cust_group_code=request.getParameter("customer_group");
			String customer_id=request.getParameter("customer_id"); 
			ArrayList polocyType = bean.getPolocyType(cust_group_code,customer_id,facility_id.trim()); 
			for (int i=0;i<polocyType.size();i+=2){
				out.println("addPolocyAfterEdit('"+polocyType.get(i)+"','"+polocyType.get(i+1)+"')");//addPolocyClickType
			}
		}		
		if(identity.equals("alt_disp_locn_select")){	
			String alt_disp_code=request.getParameter("alt_disp_code");
			String frmtime=request.getParameter("frmtime");
			String totime=request.getParameter("totime");
			String flag=request.getParameter("flag");
			String eff_status=request.getParameter("eff_status");
			String repeat=request.getParameter("repeat");
			String id=request.getParameter("id");
			String order_src_type = (String)hash.get("ord_src_type");
			String ord_src_code = (String)hash.get("ord_src_code");
			String perform_fcy = (String)hash.get("perform_fcy");
			String order_fcy = (String)hash.get("order_fcy");
			String day_type = (String)hash.get("day_type");
			String disp_locn_code = (String)hash.get("disp_locn_code");
			String routing_level_code = (String)hash.get("routing_level_code");
			String routing_code_alt = (String)hash.get("routing_code");
			String billing_group_id = (String)hash.get("billing_group_id");
			String customer_group_id = (String)hash.get("customer_group_id");
			String customer_id = (String)hash.get("customer_id");
			String policy_type_id = (String)hash.get("policy_type_id");
			String mode =(String)hash.get("mode");
			String flag_mode =(String)hash.get("flag_mode");
			if(mode.equals("undefined") && flag_mode.equals("I"))
				mode="1";
			if(mode.equals("undefined") && flag_mode.equals("U"))
				mode="UPDATE";
		//	ArrayList altdisp=new ArrayList(); // comment Added for IN063877
		}
		else if(identity.equals("store_alt_data")){
			String mode =request.getParameter("mode");
			String callFrom =request.getParameter("callFrom");
			String res="";
			String tmplDtlString =request.getParameter("tmplDtlString");
			String alt_disp_code=request.getParameter("alt_disp_code");
			String frmtime=request.getParameter("frmtime");
			String totime=request.getParameter("totime");
			String flag=request.getParameter("flag");
			String eff_status=request.getParameter("eff_status");
			String repeat=request.getParameter("repeat");
			String id=(String)hash.get("id");
			String order_src_type = (String)hash.get("ord_src_type");
			String ord_src_code = (String)hash.get("ord_src_code");
			String perform_fcy = (String)hash.get("perform_fcy");
			String order_fcy = (String)hash.get("order_fcy");
			String day_type = (String)hash.get("day_type");
			String disp_locn_code = (String)hash.get("disp_locn_code");
			String routing_level_code = (String)hash.get("routing_level_code");
			String routing_code_alt = (String)hash.get("routing_code");
			String billing_group_id = (String)hash.get("billing_group_id");
			String customer_group_id = (String)hash.get("customer_group_id");
			String customer_id = (String)hash.get("customer_id");
			String policy_type_id = (String)hash.get("policy_type_id");
			String flag_mode =(String)hash.get("flag_mode");
			
			if(mode.equals("undefined") && flag_mode.equals("I"))
				mode="1";
			if(mode.equals("undefined") && flag_mode.equals("U"))
				mode="UPDATE";
			ArrayList altdisp=new ArrayList();
			altdisp=bean.selectedlocn(alt_disp_code,frmtime,totime,flag,eff_status,repeat,id,order_src_type,ord_src_code,perform_fcy,order_fcy,day_type,disp_locn_code,routing_level_code,routing_code_alt,billing_group_id,customer_group_id,customer_id,policy_type_id,mode,tmplDtlString);
			 res =bean.TimeChk();
			if (res.equals("Y")) {
				out.println("alert(getMessage('ALT_TIMINGS_OVERLAP','PH'));") ;
				return;
			}
			bean.getAltDispData();
		}
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
