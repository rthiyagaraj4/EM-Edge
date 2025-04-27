<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOR.*,eBL.*,eOR.Common.*,eBL.BLReportIdMapper,org.json.simple.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>

<head>
	
<%
	request.setCharacterEncoding("UTF-8");

	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String bean_id = "refusalOrdersBean" ;
	String bean_name = "eOR.RefusalOrdersBean";
	RefusalOrdersBean Orderables = (RefusalOrdersBean)getBeanObject( bean_id,bean_name,request) ;	
	//SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss.SSS");
%>


	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script src='../../eOP/js/VisitRegistration.js' language='javascript'></script>
    <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eOP/js/BatchProcess.js' language='javascript'></script>
</head>
<body onKeyDown = 'lockKey()'>
<form>

<%

	String facilityid=(String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id"); 
	String userid = (String) session.getValue("login_user")==null?"":(String)session.getValue("login_user"); 
	String locale = (String) session.getValue("LOCALE")==null?"":(String)session.getValue("LOCALE"); 
	Connection conn = null;
	try{
		conn=ConnectionManager.getConnection(request);
		PreparedStatement pstmt	  = null;
		ResultSet rs		  = null;
		
		String practWorkingYN = "N";
		String roomWorkingYN="N";
		String primary_resource_class = "";
		String override_walkin_yn = "";
		String order_type_code = "";
		String order_category = "";
		String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");

		int max_walkin_for_day = 0;
		int visits_registered = 0;
		int pkgSubsListCount=0;
		String submitYN="Y";
		
		String p_locn_code=request.getParameter("clinic_code")== null?"":request.getParameter("clinic_code");
		String room_num=request.getParameter("room_num")== null?"":request.getParameter("room_num");
		String objval=request.getParameter("objval")== null?"":request.getParameter("objval");
		String callfunc=request.getParameter("callfunc")== null?"":request.getParameter("callfunc");
		String pract_id=request.getParameter("pract_id")== null?"":request.getParameter("pract_id");
		String appt_id=(request.getParameter("appt_id") == null)?"":request.getParameter("appt_id");
		String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
		String locntype = request.getParameter("locntype")== null?"":request.getParameter("locntype");		
		String queue_no = request.getParameter("assigned_q_no")==null?"":request.getParameter("assigned_q_no");	
		String att_pract_id = request.getParameter("att_pract_id")== null?"":request.getParameter("att_pract_id");		
		
		String queue_date = request.getParameter("queue_date")==null?"":request.getParameter("queue_date");
		
		String vst_regn_date_time = request.getParameter("vst_regn_date_time")==null?"":request.getParameter("vst_regn_date_time");
		
		String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");

		String service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");
		String bl_install_yn = request.getParameter("bl_install_yn")==null?"N":request.getParameter("bl_install_yn");	
		String appt_ref_no = request.getParameter("appt_ref_no")==null?"":request.getParameter("appt_ref_no");	// Added for Against Incident 35375 
		String invitation_no = request.getParameter("invitation_no")==null?"":request.getParameter("invitation_no"); // Added for Against Incident 35375 
		
		String practList = request.getParameter("practs")==null?"":request.getParameter("practs"); // Added for CRF - Bru-HIMS-CRF 198
		String bl_success = request.getParameter("bl_success")==null?"":request.getParameter("bl_success"); 
		boolean isOrderCtlgAmtCalc = CommonBean.isSiteSpecific(conn, "OP","ORDER_CTLG_AMT_CALC");/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/

				
		/*Below line Added for this CRF Bru-HIMS-CRF-165.1 [IN:035659] */
	    String order_select_count=request.getParameter("order_select_count")==null?"0":request.getParameter("order_select_count");
		    int order_count_appointment=Integer.parseInt(order_select_count);
		 String disableChk ="";  
		 if(order_count_appointment>1)           
				 disableChk = "disabled";				 
	    //End CRF Bru-HIMS-CRF-165.1 [IN:035659]
		
		String Cut_off_date1="";
		String Cut_off_date2="";
		String cnt1="N";		
		String queueNo = "";
		String waitTime = ""; 

		//Added for the CRF - Bru-HIMS-CRF-170 - start
		String consecutive_no_shows="";
		String no_of_visits_months="";
		String no_of_future_appts_months="";
		String no_of_no_show_months="";
		String episode_closure_by=request.getParameter("episode_closure_by")==null?"D":request.getParameter("episode_closure_by");
		//Added for the CRF - Bru-HIMS-CRF-170 - End
		if(callfunc.equals("batchProcess"))
		{

			String sql1="Select to_char(trunc(sysdate - nvl(episode_close_days_fu,0)),'DD/MM/YYYY'), to_char(trunc(sysdate - nvl(episode_close_days_wo_fu,0)),'DD/MM/YYYY'),consecutive_no_shows , no_of_visits_months, no_of_future_appts_months,no_of_no_show_months  from op_param_for_facility_service where OPERATING_FACILITY_ID=? and service_code=?";

			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facilityid);
			pstmt.setString(2,service_code);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
				cnt1="Y";
				Cut_off_date1=rs.getString(1) == null?"":rs.getString(1);
				Cut_off_date2=rs.getString(2) == null?"":rs.getString(2);
				consecutive_no_shows=rs.getString("consecutive_no_shows")==null?"":rs.getString("consecutive_no_shows");
				no_of_visits_months=rs.getString("no_of_visits_months")==null?"":rs.getString("no_of_visits_months");
				no_of_future_appts_months=rs.getString("no_of_future_appts_months")==null?"":rs.getString("no_of_future_appts_months");
				no_of_no_show_months=rs.getString("no_of_no_show_months")==null?"":rs.getString("no_of_no_show_months");				
			}
			

			if(rs!=null)
				rs.close();	
			
			if(cnt1.equals("N"))
			{
				String sql2="Select to_char(trunc(sysdate - nvl(episode_close_days_fu,0)),'DD/MM/YYYY'), to_char(trunc(sysdate - nvl(episode_close_days_wo_fu,0)),'DD/MM/YYYY')  from op_param where OPERATING_FACILITY_ID='"+facilityid+"'";
				
				pstmt = conn.prepareStatement(sql2);
				rs = pstmt.executeQuery();

				if(rs!=null && rs.next())
				{
					
					Cut_off_date1=rs.getString(1)== null?"":rs.getString(1);
					Cut_off_date2=rs.getString(2)== null?"":rs.getString(2);				
						
				}
				if(rs!=null)
				rs.close();	

			}
			
			if(!service_code.equals("")){			
			if(!episode_closure_by.equals("N")){%>			
			<Script language="JavaScript">
			parent.document.Criteria.document.forms[0].cutoffdate.value="<%=Cut_off_date1%>";
			parent.document.Criteria.document.forms[0].cutoffdate1.value="<%=Cut_off_date2%>";
			</script>
			<%}else{%>
			<Script language="JavaSCript">
			parent.document.frames[1].document.forms[0].consecutive_no_shows.value="<%=consecutive_no_shows%>";
			parent.document.frames[1].document.forms[0].no_of_visits_months.value="<%=no_of_visits_months%>";
			parent.document.frames[1].document.forms[0].no_of_future_appts_months.value="<%=no_of_future_appts_months%>";
			parent.document.frames[1].document.forms[0].consecutive_no_shows_months.value="<%=no_of_no_show_months%>";
			parent.document.frames[1].document.forms[0].consecutive_no_shows.disabled=true;
			parent.document.frames[1].document.forms[0].no_of_visits_months.disabled=true;
			parent.document.frames[1].document.forms[0].no_of_future_appts_months.disabled=true;
			parent.document.frames[1].document.forms[0].consecutive_no_shows_months.disabled=true;
			</Script>
			<%}
			}else{
			%>
			<Script language="JavaScript">
			parent.document.frames[1].document.forms[0].cutoffdate.value="";
			parent.document.frames[1].document.forms[0].cutoffdate1.value="";
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<%}
		
		}else if(callfunc.equals("VisitRegn"))
		{
			int no_of_orders = Orderables.getSize();
		%>
				<script>
					var ordreq=parent.f_query_add_mod.patient_sub3.document.getElementById("order_req").value;
		
					if(ordreq != "" && ordreq == "R") {						
						if(parent.f_query_add_mod.patient_sub3.document.forms[0].multiple_orders_yn.value=='Y') { 
							if(<%=no_of_orders%> == 0) {							
								errors = getMessage("SHOULD_NOT_BE_BLANK","Common",new Array(encodeURIComponent(getLabel("Common.ordercatalog.label","common_labels"))));	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
							}
						}
					} 					
				</script>
			<%

			String sql_override_walkin = "select OVERRIDE_WALKIN_YN from AM_OS_USER_LOCN_ACCESS_VW where locn_type='"+locntype+"' and locn_code ='"+p_locn_code+"' and facility_id ='"+facilityid+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+userid+"'";			

			pstmt = conn.prepareStatement(sql_override_walkin);

			rs = pstmt.executeQuery();
			 
			if(rs!=null && rs.next())
			{
				override_walkin_yn = rs.getString("OVERRIDE_WALKIN_YN")==null?"":rs.getString("OVERRIDE_WALKIN_YN");				
			}			

			if(rs!=null)
				rs.close();			
            // Issue Fix Against 35375 Below query Day order[ Monday to Sunday Changed into Sunday to Saturday]  Dated on 28/09/2012 By Saanthaakumar
			/*String sql_max_walkin = "select primary_resource_class,  DECODE(Trim(to_char(to_date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'),'DAY')),'SUNDAY',MAX_WALKIN_FOR_DAY_1,'MONDAY',MAX_WALKIN_FOR_DAY_2, 'TUESDAY',MAX_WALKIN_FOR_DAY_3, 'WEDNESDAY',MAX_WALKIN_FOR_DAY_4, 'THURSDAY',MAX_WALKIN_FOR_DAY_5, 'FRIDAY',MAX_WALKIN_FOR_DAY_6, 'SATURDAY',MAX_WALKIN_FOR_DAY_7) MAX_WALKIN_FOR_DAY from op_clinic where clinic_code = '"+p_locn_code+ "' and facility_id='"+facilityid+"'";		//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368	*/
			//Below Query Newly Added for reopen issue 35375 Dated on 07/11/2012 
			String sql_max_walkin = "SELECT primary_resource_class,DECODE(DAY_NO,'1', max_walkin_for_day_1,'2', max_walkin_for_day_2,'3', max_walkin_for_day_3,'4', max_walkin_for_day_4,'5', max_walkin_for_day_5,'6', max_walkin_for_day_6,'7', max_walkin_for_day_7 ) max_walkin_for_day FROM op_clinic  , SM_DAY_OF_WEEK WHERE clinic_code = '"+p_locn_code+ "' AND facility_id = '"+facilityid+"' AND LTRIM(RTRIM(DAY_OF_WEEK))= LTRIM(RTRIM(TO_CHAR (TO_DATE ('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss'), 'DAY' )))";                                
 
 
			
			pstmt = conn.prepareStatement(sql_max_walkin);

			rs = pstmt.executeQuery();
			
			 
			if(rs!=null && rs.next())
			{
				primary_resource_class = rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");
				max_walkin_for_day = rs.getInt("MAX_WALKIN_FOR_DAY");
			}

			if(rs!=null)
				rs.close();				
			String sql_visits = " select count(*) VISITS_REGISTERED from op_current_patient where facility_id='"+facilityid+"' and locn_code='"+p_locn_code+"' and APPT_OR_WALK_IN_IND='W' and trunc(queue_date)=trunc(to_date('"+vst_regn_date_time+"','dd/mm/yyyy hh24:mi:ss')) ";	//modified by Srinivasrao Yeluri on 22/02/2012 for Incident no 29368		
			
			rs = pstmt.executeQuery(sql_visits);

			if(rs!=null && rs.next())
			{
				visits_registered = rs.getInt("VISITS_REGISTERED");
			}

			if(rs!=null)
				rs.close();		
			if(pstmt!=null)
				pstmt.close(); 				
			if(bl_install_yn.equals("Y")){
				eBL.PkgSubsBean pkgSubsBean=(PkgSubsBean)getBeanObject("PkgSubsBean","PkgSubsBean",request);
				ArrayList pkgSubsList=pkgSubsBean.getSubscribedPkgs();
				pkgSubsListCount=pkgSubsList.size();
				if(pkgSubsListCount > 0){
					if(att_pract_id.equals("")){
						submitYN="N";
					}else{
						submitYN="Y";
					}
				}else{
					submitYN="Y";
				}
			}	

			if(max_walkin_for_day != 0 && appt_ref_no.equals("") && invitation_no.equals("")) // Condition Changed Against Incident Number 35375
			{
				if(visits_registered >= max_walkin_for_day)
				{
				%>
					<script>

						var confirm_allow = window.confirm(getMessage("EXCEED_MAX_WALKIN_LMT","OP"));

						if(confirm_allow)
						{
							if('<%=override_walkin_yn%>' == 'Y')
							{
								//alert("You are <%=queueNo%> in queue and your approximate wait time is <%=waitTime%> ");
								if('<%=submitYN%>'=='Y'){
									parent.f_query_add_mod.patient_sub3.document.forms[0].submit();							
								}else{
									var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
									err = err.replace('$', getLabel("Common.practitioner.label","Common"));
									parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
								}
							}
							else
							{
								alert(getMessage("NOT_AUTHORISED","OP"));
								parent.reset();
							}
						}
						else
						{
							parent.reset();
						} 						
					</script>
				<%
				}
				else if(visits_registered < max_walkin_for_day)
				{
				%>
					<script>
						
						if('<%=submitYN%>'=='Y'){
							parent.f_query_add_mod.patient_sub3.document.forms[0].submit();							
						}else{
							var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
							err = err.replace('$', getLabel("Common.practitioner.label","Common"));
							parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
						}						
					</script>
				<%
				}
			} else {
				%>
					<script>
						
						if('<%=submitYN%>'=='Y'){
							parent.f_query_add_mod.patient_sub3.document.forms[0].submit();							
						}else{
							var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
							err = err.replace('$', getLabel("Common.practitioner.label","Common"));
							parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+err;
						}							
					</script>
				<%
			}
		}
		else if(callfunc.equals("OrderCatalog"))
		{

			int tot_records = Orderables.getSize();			

			String order_string = "";			
			String order_code = "";			
			String order_desc = "";	
			String totNetAmt		= "";
			String totPayerNetAmt	= "";
			String totPatNetAmt		= "";

			ArrayList arr= new ArrayList();
			arr= Orderables.getArrayList();		
			
			String grand_tot_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GrandTotal.label",
				"common_labels");
			String select_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label",
				"common_labels");
			String code_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label",
				"common_labels");
			String desc_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label",
				"common_labels");
			String netAmtLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NetAmount.label","common_labels");
			String payerNetLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PayerNetPayable.label","common_labels");
			String patientNetLbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientNetPayable.label","common_labels");
			
			%>			
			<script>
				var tab_data = "<table cellpadding='0' cellspacing='0'  width='100%' border='1' id='order_catalog_tbl' align='center'><thead><tr><th width ='10%'><%=select_lbl%></th><th width ='30%'><%=code_lbl%></th><th width ='30%'><%=desc_lbl%></th>";
				
				if("<%=isOrderCtlgAmtCalc%>"=="true"){
					tab_data	= tab_data+"<th width ='10%'><%=netAmtLbl%></th><th width ='10%'><%=payerNetLbl%></th><th width ='10%'><%=patientNetLbl%></th>";
				}

				tab_data	= tab_data+"</tr></thead><tbody>";
			</script>
			<%
			//System.out.println("patient_id==>"+patient_id+"==>line no 365 RoomValidationYN.jsp==> Orderables for Loop Starts ==>Sysdate==>"+formatter.format(new java.util.Date()));
			String allOrderCode	= "";
			String ordCtlgCodeForBL	 = "~~";
			for(int i=0;i<tot_records;i++)
			{
				order_string = arr.get(i).toString();			

				//StringTokenizer order_val = new StringTokenizer(order_string,"$$"); 
				//Above line commented and below lind added for this CRF Bru-HIMS-CRF-165.1
				StringTokenizer order_val = new StringTokenizer(order_string,"~~");
				
				while(order_val.hasMoreTokens())
				{
					order_code = order_val.nextToken();
					order_desc = order_val.nextToken();					
					order_type_code = order_val.nextToken();	
					order_category = order_val.nextToken();	
					allOrderCode	= allOrderCode+order_code+"##";
					ordCtlgCodeForBL	= ordCtlgCodeForBL+order_code+"~~";
					System.out.println("order_code-->"+order_code);
				}	
				System.err.println("allOrderCode-->RoomValidationYN.jsp-->"+allOrderCode);
				



				
				
				if(tot_records==1)
				{
					%>
					<script>						
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_txt").value="<%=order_desc%>";
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_code").value="<%=order_code%>";
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_category_code").value="<%=order_category%>";
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_type_code").value="<%=order_type_code%>";
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").innerHTML = '';
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").style.visibility='hidden';						
					</script>	
					<%

				}

				if(tot_records>1 || (isOrderCtlgAmtCalc && tot_records >=1) )
				{	
				%>				
					<script> <!--Below line modified for this CRF Bru-HIMS-CRF-165.1 [IN:035659] -->
						tab_data = tab_data + '<tr><td align="center" width ="10%"><input type="checkbox" id="select_chk" name="select_chk<%=i%>" id="select_chk<%=i%>" onclick="chkValue(this,<%=i%>);calOrdCtlgAmt();" checked <%=disableChk%> value="<%=order_code%>"></td>';				
						tab_data = tab_data + '<td align="center" width ="30%" nowrap class="label"><%=order_code%><input type="hidden" name="order_ctl_code<%=i%>" id="order_ctl_code<%=i%>" value="<%=order_code%>"></td>';
						tab_data = tab_data + '<td align="center" width ="30%" nowrap class="label"><%=order_desc%><input type="hidden" name="order_ctl_desc<%=i%>" id="order_ctl_desc<%=i%>" value="<%=order_desc%>"><input type="hidden" name="order_cat_<%=i%>" id="order_cat_<%=i%>" value="<%=order_category%>"><input type="hidden" name="order_type_<%=i%>" id="order_type_<%=i%>" value="<%=order_type_code%>"></td>';	
						if("<%=isOrderCtlgAmtCalc%>"=="true"){
							tab_data = tab_data + '<td align="center" width ="10%" nowrap class="label"><span id="netAmt<%=order_code%>">nAmt<%=order_code%></span></td>';
							tab_data = tab_data + '<td align="center" width ="10%" nowrap class="label"><span id="payerNetAmt<%=order_code%>">pNetAmt<%=order_code%></span></td>';
							tab_data = tab_data + '<td align="center" width ="10%" nowrap class="label"><span id="patNetAmt<%=order_code%>">ptNetAmt<%=order_code%></span></td>';
						}
						tab_data = tab_data + '</tr>';
					</script>
				<%	
				}					
			}
		/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] Start*/
			if(!allOrderCode.equals("") && isOrderCtlgAmtCalc){
				JSONObject jsonObj  = BLReportIdMapper.getOrderCatalogDtls(conn, patient_id, ordCtlgCodeForBL, bl_success, p_locn_code, request);
				JSONArray orderCatalogDtlsArray 			= (JSONArray) jsonObj.get("orderCatalogDtls");
				try{

					String[] arrOrdCtlgCode = allOrderCode.split("##");
					int i = 0;
					System.out.println("450 orderCatalogDtlsArray->"+orderCatalogDtlsArray.toString());

					for(i=0;i<arrOrdCtlgCode.length;i++){
						String ctlgCode			= arrOrdCtlgCode[i];
						System.err.println("arrOrdCtlgCode[i]"+arrOrdCtlgCode[i]);
						System.err.println("(JSONObject) orderCatalogDtlsArray.get(i);"+(JSONObject) orderCatalogDtlsArray.get(i));
						JSONObject ctlgDtls		= (JSONObject) orderCatalogDtlsArray.get(i);
						System.out.println("ctlgDtls-->"+ctlgDtls.toString());
						JSONObject ctlgAmtDtls	= (JSONObject) ctlgDtls.get(ctlgCode);
										
						System.err.println("ctlgAmtDtls-->"+ctlgAmtDtls.toString());
						String netAmt			= (String) ctlgAmtDtls.get("netAmt");
						String payerNetAmt		= (String) ctlgAmtDtls.get("payerNetAmt");
						String patNetAmt		= (String) ctlgAmtDtls.get("patNetAmt");
					%>
						<script>
							tab_data	= tab_data.replace("nAmt<%=ctlgCode%>","<%=netAmt%>");
							tab_data	= tab_data.replace("pNetAmt<%=ctlgCode%>","<%=payerNetAmt%>");
							tab_data	= tab_data.replace("ptNetAmt<%=ctlgCode%>","<%=patNetAmt%>");
						</script>
					<%
						System.err.print("netAmt==>"+netAmt+"==>payerNetAmt==>"+payerNetAmt+"==>patNetAmt==>"+patNetAmt);
					}
					JSONObject totDtls		= (JSONObject) orderCatalogDtlsArray.get(i);
					JSONObject totAmtDtls	= (JSONObject) totDtls.get("totals");
					totNetAmt				= (String) totAmtDtls.get("totalNetAmt");
					totPayerNetAmt			= (String) totAmtDtls.get("payerTotalNetAmt");
					totPatNetAmt			= (String) totAmtDtls.get("patTotalNetAmt");

					//System.out.print("totNetAmt==>"+totNetAmt+"==>totPayerNetAmt==>"+totPayerNetAmt+"==>totPatNetAmt==>"+totPatNetAmt);
				}catch(Exception e) {
					System.err.println("patient_id==>"+patient_id);
					System.err.println("ordCtlgCodeForBL==>"+ordCtlgCodeForBL);
					System.err.println("orderCatalogDtlsArray->"+orderCatalogDtlsArray.toString());
					System.err.println("Exception in getting json data.");
					e.printStackTrace();
				}
			}

		/*Added By Dharma on 8th Apr 2019 against GHL-CRF-0525.1 [IN:067461] End*/

			if(tot_records>1 || (isOrderCtlgAmtCalc && tot_records >=1))
			{
			%>
				<script>
					if("<%=isOrderCtlgAmtCalc%>"=="true"){
						tab_data = tab_data + "<tr>";
						tab_data = tab_data + "<td colspan='3' align='right' class='label' style='text-align:right;'><b><%=grand_tot_lbl%></b></td>";
						tab_data = tab_data + "<td align='center' width ='10%' nowrap class='label'><b><span id='totNetAmt'><%=totNetAmt%></span></b></td>";
						tab_data = tab_data + "<td align='center' width ='10%' nowrap class='label'><b><span id='totPayerNetAmt'><%=totPayerNetAmt%></span></b></td>";
						tab_data = tab_data + "<td align='center' width ='10%' nowrap class='label'><b><span id='totPatNetAmt'><%=totPatNetAmt%></span></b></td>";
						tab_data = tab_data + "</tr>";
						tab_data = tab_data + "<input type='hidden' id='selOrdCtlgCodes' value ='<%=ordCtlgCodeForBL%>' />";
					}

					tab_data = tab_data + "</tbody></table>";
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").innerHTML= tab_data;
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").style.visibility='visible';	
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_txt").value='';
					if("<%=isOrderCtlgAmtCalc%>"!="true"){
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_code").value='';
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_category_code").value='';
						parent.f_query_add_mod.patient_sub3.document.getElementById("order_type_code").value='';
					}					
					parent.f_query_add_mod.patient_sub3.document.getElementById("multiple_orders_yn").value='Y';	
	
				</script>			
			<%	
			}	
			if(tot_records<1)
			{
			%>
				<script>					
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_txt").value='';
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_cat_code").value='';	
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_category_code").value='';
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_type_code").value='';
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").innerHTML = '';
					parent.f_query_add_mod.patient_sub3.document.getElementById("order_ctlg_tbl").style.visibility='hidden';			
				</script>			
			<%	
			}
			if(tot_records<=1)	
			{				out.println("<script>parent.f_query_add_mod.patient_sub3.document.getElementById('multiple_orders_yn').value='N';</script>");
			}	out.println("<script>parent.messageFrame.document.location.href='../../eCommon/jsp/error.jsp';</script>");
		}
		/*CRF - 198 start*/
		else if(callfunc.equals("SecResource")){

			int tot_records = 0;			
			StringTokenizer practListToken=new StringTokenizer(practList,"$");
			
			//String order_string = "";	commented for check style		
			//String order_code = "";			
			//String order_desc = "";			
			
			String code_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label",
				"common_labels");
			String desc_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label",
				"common_labels");
			String spec_lbl = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.primaryspeciality.label",
					"common_labels");
			%>			
			<script>
				parent.frames[1].document.getElementById("sec_res_lst").value='<%=practList%>';
				var tab_data = "<table width='95%' cellpadding='0' cellspacing='0' BORDER='0' align='center'><tr><td class='BORDER' width='50%'><br></td><td class='BORDER' width='50%'><table border='0' ><tr><td class='COLUMNHEADER' width ='13%'><%=code_lbl%></td><td class='COLUMNHEADER' width ='13%'><%=desc_lbl%></td><td class='COLUMNHEADER' width ='13%'><%=spec_lbl%></td></tr></table><div style='height:100px;overflow-y:auto;overflow-x:no'><table>";
				
			</script>
			<%
				String practName="practName";
				String specName="specName";
			while(practListToken.hasMoreElements()){
				tot_records++;
				String practId=practListToken.nextToken();				
				HashMap practDetails=new HashMap();
				practDetails=getPractDetails(practId,locale,conn);				
				%>									
					<script>
					tab_data = tab_data + "<tr><td class='QUERYDATA' align='center' width ='13%'><%=practId%></td><td class='QUERYDATA' align='center' width ='13%'><%=practDetails.get(practName)%></td><td class='QUERYDATA' align='center' width ='13%'><%=practDetails.get(specName)%></td></tr>";
					</script>
				<%	
									
			}
			if(tot_records>=1){%>
				<script>
				tab_data = tab_data + "</div></table></tr></td></table>";
				parent.frames[1].document.getElementById("sec_res_lbl").innerHTML= tab_data;	
				parent.frames[1].document.getElementById("sec_res_lbl").style.visibility='visible';	
				</script><%
			}else{%>
				<script>
				tab_data="";
				parent.frames[1].document.getElementById("sec_res_lbl").innerHTML= tab_data;	
				parent.frames[1].document.getElementById("sec_res_lbl").style.visibility='visible';
				</script><%
			}
		}
		/*CRF - 198 End*/
		else 
		{

				if(callfunc.equals("Assign"))
				{
					if(appt_id.equals(""))
					{
					HashMap practWorkingHash =ifPractWorkingYN( facilityid, p_locn_code, pract_id,conn);

					practWorkingYN=(String)practWorkingHash.get("practWorkingYN");
					
					}

				}
				if(practWorkingYN==null) practWorkingYN="N";

				if(practWorkingYN.equals("Y") || pract_id.equals("") || !appt_id.equals(""))
				{
					if(appt_id.equals(""))
								{
						
				if(!room_num.equals(""))
				{
					HashMap roomWorkingHash =ifPractWorkingYN( facilityid, p_locn_code	, room_num,conn);

					roomWorkingYN=(String)roomWorkingHash.get("practWorkingYN");
				}
				}

				if(roomWorkingYN==null) roomWorkingYN="N";

				if(roomWorkingYN.equals("Y") || room_num.equals("") || !appt_id.equals(""))
				{			   
										
					if(assign_q_num_by.equals("M")&&callfunc.equals("Arrival"))
					{
						int cnt = 0;						
						boolean submitFlag = true;

						String strPatQ="";					

						if(att_pract_id.equals("*ALL"))
						{
							strPatQ = "select count(*) from op_current_patient where facility_id=? and locn_type=? and locn_code=? and queue_num=? and queue_status < '07' and trunc(queue_date) = to_date(?,'dd/mm/yyyy')";		
						} else {
							strPatQ = "select count(*) from op_current_patient where facility_id=? and locn_type=? AND ((locn_code = ? AND practitioner_id=?) OR (locn_code = ? AND practitioner_id='*ALL')) and queue_num=? and queue_status < '07' and trunc(queue_date) = to_date(?,'dd/mm/yyyy')";
						}
					
						
						pstmt = conn.prepareStatement(strPatQ);

						if(att_pract_id.equals("*ALL"))
						{
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locntype);
							pstmt.setString(3,p_locn_code);
							pstmt.setString(4,queue_no);
							pstmt.setString(5,queue_date);
						} else {
							pstmt.setString(1,facilityid);
							pstmt.setString(2,locntype);
							pstmt.setString(3,p_locn_code);
							pstmt.setString(4,att_pract_id);
							pstmt.setString(5,p_locn_code);
							pstmt.setString(6,queue_no);
							pstmt.setString(7,queue_date);
						}

						rs = pstmt.executeQuery();
						if(rs!=null && rs.next())
						{
							
							cnt = rs.getInt(1);
						
						}
						if(pstmt!=null) pstmt.close();
						if(rs!=null) rs.close();						
						if(cnt>0)
						{	
							submitFlag = false ;
							%>
								<script>										
									alert(getMessage("QUEUE_NUM_EXISTS","OP"));
									eval("parent.frames[1].document.getElementById("queue_no")").focus();

									   if(parent.frames[1].document.getElementById("room_num").value=="")
										parent.frames[1].document.getElementById("room_num").value="NoRoom";

								</script>
							<%	
						}
						if(submitFlag)
						{
							%>
								<script>
									/*
									if('<%=callfunc%>'=='Arrival') {
										alert("You are <%=queueNo%> in queue and your approximate wait time is <%=waitTime%> ");
									}
									*/
									parent.frames[1].document.forms[0].submit();
								</script>
							<%

						} 

					} else {
						
					%>
						<script>
							/*
							if('<%=callfunc%>'=='Arrival') {
								alert("You are <%=queueNo%> in queue and your approximate wait time is <%=waitTime%> ");
							}
							*/
							parent.frames[1].document.forms[0].submit();
						</script>
						<%
					}
				}
				else
				{
					%>
					<script>
						alert(getMessage("Room_Working_YN","OP"));
						parent.frames[1].document.getElementById(<%=objval%>).focus();
						</script>
						<%
				}
				}
				else
				{
					%>
					<script>
						
					alert(getMessage("Pract_Working_YN","OP"));
					parent.frames[1].document.getElementById('pract_name').focus();
						</script>
						<%
				}
		}	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
		if(conn != null)
				ConnectionManager.returnConnection(conn,request);
	}

%>

<%! 

public HashMap ifPractWorkingYN(String facilityId, String assign_care_locn_code,String Practitioner_id ,Connection con)  throws Exception
	{    
	   
		String practWorkingsql =  "{call GET_WORKING_DAY_YN(?,?,?,sysdate,?,?)}";
       
		String practWorkingYN="N";
		HashMap hashFILE_NO_EXISTS=new HashMap();


			CallableStatement practWorkingCS = con.prepareCall(practWorkingsql);
            practWorkingCS.setString(1, facilityId);
            practWorkingCS.setString(2, assign_care_locn_code);
            practWorkingCS.setString(3, Practitioner_id);
			practWorkingCS.registerOutParameter( 4,java.sql.Types.VARCHAR);
            practWorkingCS.registerOutParameter( 5,java.sql.Types.VARCHAR);
            

            try{
				practWorkingCS.execute();

				practWorkingYN = practWorkingCS.getString(4)== null?"":practWorkingCS.getString(4);
				if(practWorkingYN==null) practWorkingYN="N";
				hashFILE_NO_EXISTS.put("practWorkingYN",practWorkingYN);
 
				String P_ERR_MSG = practWorkingCS.getString(5)== null?"":practWorkingCS.getString(5);
                if(P_ERR_MSG==null) P_ERR_MSG="";
			    hashFILE_NO_EXISTS.put("P_ERR_MSG",P_ERR_MSG);
 		}
            catch(Exception e1) {
			
			e1.printStackTrace();
  		   }
            finally{
					practWorkingCS.close();
 				}

	return hashFILE_NO_EXISTS;
	
}//end of File_No_ExistsCall

public HashMap getPractDetails(String Practitioner_id ,String locale,Connection con)  throws Exception
{    
   
	String practsql =  "select AM_GET_DESC.AM_PRACTITIONER(?,?,'1') pract_name,am_get_desc.am_speciality((select PRIMARY_SPECIALITY_CODE from am_practitioner where practitioner_id=?),?,1) primary_speciality from dual";
   	//String practName=""; // commented for check style
   	HashMap practDetails=new HashMap();

   	try{
		PreparedStatement practStmt = con.prepareStatement(practsql);
		
		practStmt.setString(1,Practitioner_id);
		practStmt.setString(2,locale);
		practStmt.setString(3,Practitioner_id);
		practStmt.setString(4,locale);
							
       ResultSet practrs=practStmt.executeQuery();
       while(practrs.next()){
    	   practDetails.put("practName",practrs.getString("pract_name"));
    	   practDetails.put("specName",practrs.getString("primary_speciality"));    	       	          
       }
       if(practStmt!=null) practStmt.close();
   		if(practrs!=null) practrs.close();
        
			
		}
        catch(Exception e1) {
		
		e1.printStackTrace();
		   }


return practDetails;

}
%>
</form>
</body>

</html>

