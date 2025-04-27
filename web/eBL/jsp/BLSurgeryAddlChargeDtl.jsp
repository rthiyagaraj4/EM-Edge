<!DOCTYPE html>
<%@ page import="eBL.*,java.sql.*, webbeans.eCommon.*, java.io.*,webbeans.op.CurrencyFormat" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt = null ;
	ResultSet rs=null,rsserv_desc=null,rsrole=null,rs1=null,rs2=null,rscurr=null,rsc=null,rst2=null,rso=null;
	CallableStatement call = null;
	
	String p_facility_id="",p_patient_id="",trx_date_time="",	module_id="",order_item="",serv_panel_ind="",serv_qty="",charge_amt="";
	String service_code="",charge_ind="", charge_perc="",  dep_blng_serv_code="",  gross_amount="",  ass_ot_role_type="",serv_desc="",ass_ot_role_type_desc="",item_desc="",dep_serv_desc="",charge_base_amt="",order_id="",currdate="";
	int noofdecimal = 2;	int i=0;double tot_amt=0;
	String query_string="", function_id="";
	
	String sec_key_module_id="",sec_key_main="",sec_key_line_no="";
	String mult_surg_disc_perc="",disc_amt="",net_amt="",pat_pay_amt="",cat_blng_serv_desc="",checked_val="",mult_surg_disp_disc_perc="";
	//double base_rate=0.00,gross_charge_amt=0.00,net_charge_amt=0.00,get_bill_disc_amt=0.00;
	String sysmessageid="",errortext="",errorlevel="",disc_seq_num="",disabled_view_mode="",pract_id="",pract_short_name="";

	String sec_key="", p_sec_key_main="", override_yn="", acc_seq_no="",str_serv_panel_ind="",str_serv_panel_code="";
	String style_ref="";
	
	try
	{
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		String locale	= (String)session.getAttribute("LOCALE");
		con	=	ConnectionManager.getConnection(request);	
		CurrencyFormat cf = new CurrencyFormat();
		p_facility_id = (String) session.getValue("facility_id");
		if (p_facility_id==null) p_facility_id = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
		
		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		query_string=request.getQueryString();
		
		p_patient_id = request.getParameter("patient_id");	
		if(p_patient_id==null) p_patient_id="";	
	
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	
		
		String p_str_order_catalog_code = request.getParameter("str_order_catalog_code");	
		if(p_str_order_catalog_code==null) p_str_order_catalog_code="";	

		
			

				
		String p_sec_key_main_oper_num = request.getParameter("sec_key_main_oper_num");	
		if(p_sec_key_main_oper_num==null) p_sec_key_main_oper_num="";	

		
		String p_sec_key_main_order_id = request.getParameter("sec_key_main_order_id");	
		if(p_sec_key_main_order_id==null) p_sec_key_main_order_id="";	

				
		String sql="SELECT 'X' FROM BL_PATIENT_CHARGES_INTERFACE WHERE SEC_KEY_MAIN='"+p_sec_key_main_oper_num+"' ";
		
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);
		if(rs.next())
		{
			sec_key=rs.getString(1);
		}
		if(sec_key.equals("X"))
		{
			p_sec_key_main=p_sec_key_main_oper_num;
		}
		else
		{
			p_sec_key_main=p_sec_key_main_order_id;
		}
		if(stmt.equals(null))stmt.close();
		if(rs.equals(null))rs.close();
		
		checked_val="checked";
		String str_disabled="";
		String classval="";
		String chk_box_val="";
		chk_box_val="Y";
		module_id="BL";			
		order_item="";
		serv_panel_ind="S";
		serv_qty="1";
		charge_amt="";
		String addl_services_yn="N";

		HashMap hmServiceString = new HashMap();
		ArrayList order_catalog_array=new ArrayList();
		ArrayList arr_role_type = new ArrayList();
		ArrayList arr_sur_id = new ArrayList();

		String bean_id 		 		= request.getParameter("bean_id");	
		if(bean_id == null) bean_id="";

		String bean_name 			= request.getParameter("bean_name");
		if(bean_name == null) bean_name="";

		BLSurgeryAddlChargeBean bean = (BLSurgeryAddlChargeBean)getBeanObject( bean_id, bean_name, request );		
		bean.clearBean();	
		bean.setPatientId(p_patient_id); // set the Patient Id		
		bean.setVisitId(visit_id); // set the visit_id
		bean.setEpisodeId(episode_id); // set the episode_id 
		bean.setEpisodeType(episode_type); // set the episode_type 
		bean.setEncounterId(encounter_id); // set the encounter_id

		function_id = request.getParameter("function_id");
			if(function_id == null) function_id="EDIT";

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		 <script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		</head>

<script>
	function selected(ord,i)
	{
	
		var v_patient_id = document.forms[0].patient_id.value;
		var v_episode_type = document.forms[0].episode_type.value;
		var v_episode_id = document.forms[0].episode_id.value;
		var v_visit_id = document.forms[0].visit_id.value;
		i=i;
		var sys_message_id=eval("document.forms[0].sysmessageid_"+ord+"_"+i);
		var error_level=eval("document.forms[0].errorlevel_"+ord+"_"+i);
		var error_text=eval("document.forms[0].errortext_"+ord+"_"+i);
		var selected_row=eval("document.forms[0].selected_row_"+ord+"_"+i);
		var dep_serv_disc =document.getElementById("dep_serv_id"+ord+"_"+i);
	
		if(sys_message_id.value!="" || (error_level.value=="10" || error_text.value!=""))
		{
			if(sys_message_id!="")
			{
				alert(getMessage(sys_message_id.value,'BL'));			
				selected_row.checked=false;
				return;
			}
			if(error_text!="")
			{
				dep_serv_disc.innerText = error_text.value;
				selected_row.checked=false;
				return;
			}
			selected_row.checked=false;
			return;
		}

		
		if(selected_row.checked==false)
		{			
			/*var pract_name = eval("document.forms[0].pract_name_"+ord+"_"+i);
			pract_name.disabled=true;*/
			selected_row.value="N";
			
			
		}
		else
		{
			/*var pract_name = eval("document.forms[0].pract_name_"+ord+"_"+i);
			pract_name.disabled=false;*/
			
			selected_row.value="Y";
		}
		
		var a_serv_code = new Array();
		var  ord_catlog_count=document.forms[0].ord_tot_rec.value;
		var blng_serv_code=eval("document.forms[0].blng_serv_code_"+ord+"_"+i);
		var order_cat_code=eval("document.forms[0].order_cat_code"+ord+"_"+i);
		p_blng_serv_code = blng_serv_code.value;
		p_order_cat_code = order_cat_code.value;
		var checked_val=selected_row.value;
		var v_ord=ord;
		var string="../../eBL/jsp/BLAddlSurgeryValidation.jsp?blng_serv_code="+p_blng_serv_code+"&order_cat_code="+p_order_cat_code+"&ord_catlog_count="+ord_catlog_count+"&ord_i="+ord+"&checked_val="+checked_val+"&p_patient_id="+v_patient_id+"&episode_type="+v_episode_type+"&episode_id="+v_episode_id+"&visit_id="+v_visit_id;
		
		parent.frames[3].location.href=string;
	}
	
	function phylkp(ord,i,clng_evnt)
	{		
		var target= eval("document.forms[0].pract_name_"+ord+"_"+i);
		var pract_id= eval("document.forms[0].pract_id_"+ord+"_"+i);
		var order_id = eval("document.forms[0].order_id_"+ord+"_"+i);
		var ass_ot_role_type = eval("document.forms[0].ass_ot_role_type_"+ord+"_"+i);		
		var v_ass_ot_role_type =ass_ot_role_type.value;
		if(clng_evnt == 'B')
		{
			if( target.value == "")
			{
				target.value = "";
				pract_id.value = "";
				return;
			}
		}
				
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "10" ;
		var dialogWidth			= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		
		var locale = document.forms[0].locale.value;		

		var title=encodeURIComponent(getLabel("Common.practitioner.label","common"));
		var column_sizes = escape("15%,10%");
		var pract_name=encodeURIComponent(getLabel("Common.practitioner.label","common"));
		var pract_id=encodeURIComponent(getLabel("Common.practitionerid.label","common"));
								
		var column_descriptions =pract_name+","+pract_id; 
		var message = '';
		var v_order_id=order_id.value;
	
		sql="SELECT B.SHORT_NAME pract_name, A.PRACTITIONER_ID pract_id FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B WHERE A.PRACTITIONER_ID = B.PRACTITIONER_ID AND A.ROLE_TYPE = NVL(Decode('"+v_ass_ot_role_type+"','--',''),A.ROLE_TYPE) AND A.OPER_NUM IN (SELECT OPER_NUM FROM OT_POST_OPER_HDR 	  WHERE ORDER_ID = '"+v_order_id+"') AND B.LANGUAGE_ID = '"+locale+"'";

		sql = escape(sql);	
		var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(target.value)+"&srch_by_clmn_index=2"+"&col_show_hide=YY";
		 
		retVal=window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
		var arr=new Array();
		
		if(retVal == null || retVal=='undefined' || retVal==undefined) retVal='';
		if (retVal!="")
		{
			var retVal=unescape(retVal);
			arr=retVal.split("^~^");	
			var v_pract_id= eval("document.forms[0].pract_id_"+ord+"_"+i);			
			pract_name=arr[0];				
			v_pract_id.value=arr[1];			  
			target.value=pract_name;	
			pract_id.value=pract_id;
		}	
		else
		{
			var v_pract_id= eval("document.forms[0].pract_id_"+ord+"_"+i);
			var v_pract_name= eval("document.forms[0].pract_name_"+ord+"_"+i);
			v_pract_id.value="";
			v_pract_name.value="";
		} 
	}

	function displayToolTip(ass_ot_role_type_desc)
	{
		document.getElementById("t").innerHTML = ass_ot_role_type_desc;
		resizeWindow();
	}
	
	function disableselect()
	{
		var fun_id='<%=function_id%>'
		
		if(fun_id=="VIEW")
			{
		
				document.getElementById("sel").style.display="none";
			}
			else{
				document.getElementById("sel").style.display="inline";
				}
		}
</script>

<body onLoad='disableselect()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='edit_enter_main' id='edit_enter_main' method='post' method='post' target='dummy_frame'>
<%
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("rscurr="+e.toString());
		}

		try
		{		
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			pstmt=con.prepareStatement(query_date);
			rst2 = pstmt.executeQuery();
			if (rst2!=null)
			{
				if (rst2.next())
				{
					currdate = rst2.getString(1);
				}
			}
			if (rst2 != null)   rst2.close();
			if (pstmt != null)   pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("error in date:"+e);
		}
	
		try
		{
			i=0;
			
			//function_id = request.getParameter("function_id");
			//if(function_id == null) function_id="EDIT";

			if(function_id.equals("VIEW"))
			{
				disabled_view_mode="DISABLED";		
				style_ref = "display:none";
			}
			else
			{
				disabled_view_mode="";
				style_ref = "display:inline";
			}

			String str_role_pract_ids = request.getParameter("role_pract_id");
			if(str_role_pract_ids == null) str_role_pract_ids="";

			StringTokenizer st_role_pract_ids = new StringTokenizer(str_role_pract_ids,"@@");

			while(st_role_pract_ids.hasMoreTokens())
			{
				String temp = (String) st_role_pract_ids.nextToken();
				StringTokenizer st_ind_val = new StringTokenizer(temp,"||");
				while(st_ind_val.hasMoreTokens())
				{
					arr_role_type.add(st_ind_val.nextToken());
					arr_sur_id.add(st_ind_val.nextToken());		
				}
			}
			
			try
			{
				StringTokenizer arr_st_ord_cat = new StringTokenizer(p_str_order_catalog_code,"|");			
				while(arr_st_ord_cat.hasMoreTokens())
				{
					order_catalog_array.add(arr_st_ord_cat.nextToken());					
				}
			}
			catch(Exception e)
			{
				System.out.println("order_catalog_array Exception:"+e);
			}

			hmServiceString.clear();			
			
			
			for(i=0;i<order_catalog_array.size();i++)
			{

//				System.out.println("order_catalog_array.get(i) " +order_catalog_array.get(i));
//				System.out.println("p_patient_id " +p_patient_id);
//				System.out.println("p_sec_key_main " +p_sec_key_main);

				pstmt = con.prepareStatement( " SELECT To_Char(CHARGE_DATE_TIME,'dd-mm-yyyy hh24:mi:ss'),PRIMARY_KEY_MAIN,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO,SERVICE_PANEL_IND  FROM bl_patient_charges_interface WHERE SERV_ITEM_CODE='"+order_catalog_array.get(i)+"' and patient_id='"+p_patient_id+"'and SEC_KEY_MAIN='"+p_sec_key_main+"'");

				rsc = pstmt.executeQuery();	
				while(rsc.next())
				{
					trx_date_time  =  rsc.getString(1);		
					order_id = rsc.getString(2);		
					sec_key_module_id = rsc.getString(3);		
					sec_key_main = rsc.getString(4);		
					sec_key_line_no = rsc.getString(5);
					serv_panel_ind = rsc.getString(6);
				}
				
				rsc.close();
				pstmt.close();				
//				System.out.println("sec_key_line_no " +sec_key_line_no);
//				System.out.println("serv_panel_ind " +serv_panel_ind);
				String sqlcharge="";
				
				if(function_id.equals("EDIT"))
				{
				sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_CHARGES('"+p_facility_id+"','"+order_catalog_array.get(i)+"','"+p_patient_id+"','"+episode_type+"','"+episode_id+"','"+visit_id+"','"+encounter_id+"','"+acc_seq_no+"',to_date('"+currdate+"','dd/mm/yyyy HH24:MI:SS'),?,'"+module_id+"','"+order_item+"','"+serv_panel_ind+"','"+serv_qty+"','"+charge_amt+"','"+override_yn+"','"+locale+"','"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";
				}
				else if(function_id.equals("VIEW"))
				{
					//sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_VIEW('"+p_facility_id+"','"+module_id+"',?,'"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";
					sqlcharge="{ call BL_PROC_SUBSERVICES.BL_GET_BILL_SUBSERV_VIEW('"+p_facility_id+"','"+module_id+"',?,'"+sec_key_module_id+"','"+p_sec_key_main+"','"+sec_key_line_no+"')}";

				}

				call = con.prepareCall(sqlcharge);
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.execute();
				String service_string=call.getString(1);
				if(addl_services_yn=="N"){
					addl_services_yn=Integer.parseInt(service_string.split("<NR>")[0].split(":")[1])>1?"Y":"N";

					
				}
				hmServiceString.put(order_catalog_array.get(i),service_string);
				bean.setServiceString(hmServiceString); 
				
				call.close();
			}
			/*if(addl_services_yn.equals("N"))
					{
				System.err.println("addl_services_yn inside");				
					out.println("<script>alert(getMessage('BL9758' ,'BL'));parent.window.returnValue=\"NA\";parent.window.close();</script>");
					}*/
		}
		catch(Exception e)
		{
			System.out.println("Exception in for :"+e);
		}
		
%>
	<table border='1' cellpadding='3' cellspacing='0' align = 'center'  width='100%'>	
		<tr>
			
			<td class='COLUMNHEADER' width='6%'  ><div id="sel"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></div></td>
			<td class='COLUMNHEADER' width='16%' ><fmt:message key="Common.BillingService.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='8%'  ><fmt:message key="Common.Percent.label" bundle="${common_labels}"/> %</td>
			<td class='COLUMNHEADER' width='16%' ><fmt:message key="eBL.DEPENDENT_SERVICE.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%' ><fmt:message key="eBL.GROSS_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%' ><fmt:message key="eBL.DISCOUNT_PERC.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%' ><fmt:message key="eBL.DISC_AMT.label" bundle="${bl_labels}"/></td>
			<td class='COLUMNHEADER' width='8%' ><fmt:message key="Common.NetAmount.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='8%' ><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' width='14%' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		</tr>
<%
		int ord=0;
		try
		{	
			if(order_catalog_array.size()!=0)
			{
				String disc_rule_line ="",cat_blng_serv_code="";
				ArrayList disc_rule=new ArrayList();
				HashMap hm_StringDtls =(HashMap) bean.getServiceString("service_string"); 
				String serv_str_temp="";
				String ord_key_code = (String)order_catalog_array.get(ord);
				disc_rule=bean.getDiscountLine(ord_key_code);
				i=0;
				
				for(ord=0;ord<order_catalog_array.size();ord++)
				{
					i++;	
					String ord_key =  (String)hm_StringDtls.get(order_catalog_array.get(ord));
					pstmt = con.prepareStatement( " select SERV_ITEM_DESC,CHARGE_BASED_AMT,BLNG_SERV_CODE,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO,SERVICE_PANEL_IND,PANEL_CODE  from bl_patient_charges_interface where SERV_ITEM_CODE='"+order_catalog_array.get(ord)+"' and patient_id='"+p_patient_id+"' and SEC_KEY_MAIN='"+p_sec_key_main+"'");
					rs1 = pstmt.executeQuery();	
					//String temp1="select SERV_ITEM_DESC,CHARGE_BASED_AMT,BLNG_SERV_CODE,SEC_KEY_MODULE_ID,SEC_KEY_MAIN,SEC_KEY_LINE_NO  from bl_patient_charges_interface where SERV_ITEM_CODE='"+order_catalog_array.get(ord)+"' and patient_id='"+p_patient_id+"' and SEC_KEY_MAIN='"+p_sec_key_main+"'";
					while(rs1.next())
					{
						item_desc =  rs1.getString(1);							
						charge_base_amt =  rs1.getString(2);			
						charge_base_amt = cf.formatCurrency(charge_base_amt, noofdecimal);
						cat_blng_serv_code = rs1.getString(3);	
						sec_key_module_id = rs1.getString(4);		
						sec_key_main = rs1.getString(5);		
						sec_key_line_no = rs1.getString(6);
						str_serv_panel_ind = rs1.getString(7);
						str_serv_panel_code = rs1.getString(8);
						if(str_serv_panel_code==null) str_serv_panel_code="";
					}
					
					rs1.close();
					pstmt.close();				

					if(str_serv_panel_ind.equals("L") && !str_serv_panel_code.equals(""))
					{
						pstmt = con.prepareStatement( " select SHORT_DESC from BL_PANEL_HDR_LANG_VW where PANEL_CODE='"+str_serv_panel_code +"'and LANGUAGE_ID ='"+locale+"' ");
					}else{					
						pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+cat_blng_serv_code +"'and LANGUAGE_ID ='"+locale+"' ");
					}					
						rso = pstmt.executeQuery();	
						while(rso.next())
						{
						   cat_blng_serv_desc =  rso.getString(1);
						}					
						rso.close();
						pstmt.close();	
//						System.out.println("****cat_blng_serv_desc:"+cat_blng_serv_desc);

					if(ord!=0)
					{
						disc_rule_line=(String)disc_rule.get(ord-1);
					}
					dep_blng_serv_code="";
					tot_amt=0;
					String delimit="<NR>";	
					String serv_str=ord_key.replaceAll(delimit,"|");
					
					int t=serv_str.indexOf("|");
					//char nr=serv_str.charAt(t-1);		
								

				/*	if(nr == '1')
					{
						out.println("<script>parent.window.returnValue=\"NA\";parent.window.close();</script>");
					}*/

					if(t!=-1)
					{
						serv_str_temp=serv_str.substring(t);
						
					}
					else
					{
						serv_str_temp=serv_str;
					}

					
					
					StringTokenizer st = new StringTokenizer(serv_str_temp,"|");
					int surg_count=0;
					int k=0;
					while(st.hasMoreTokens())
					{
						String string1 = st.nextToken();
						StringTokenizer st1 = new StringTokenizer(string1,"#");			
						
						while(st1.hasMoreTokens())
						{
							i++;
							service_code = st1.nextToken();

							if(service_code.equals(" ")) service_code="";
							try
							{
								pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+service_code +"'and LANGUAGE_ID ='"+locale+"' ");
							
								rsserv_desc = pstmt.executeQuery();	
					
								while(rsserv_desc.next())
								{
								   serv_desc  =  rsserv_desc.getString(1);
								}	
								rsserv_desc.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							charge_ind = st1.nextToken();
							
							if(charge_ind.equals(" ")) charge_ind="";

							charge_perc = st1.nextToken();
							
							if(charge_perc.equals(" "))
							{
								charge_perc="";							
							}
							else
							{
								charge_perc = cf.formatCurrency(charge_perc, noofdecimal);
							}

							dep_blng_serv_code = st1.nextToken();
							if(dep_blng_serv_code.equals(" ")) dep_blng_serv_code="";
							dep_serv_desc="";

							try
							{
								pstmt = con.prepareStatement( " select SHORT_DESC from bl_blng_serv_lang_vw where BLNG_SERV_CODE='"+dep_blng_serv_code +"'and LANGUAGE_ID ='"+locale+"' ");
							
								rs2 = pstmt.executeQuery();	
					
								while(rs2.next())
								{
								   dep_serv_desc  =  rs2.getString(1);							
								}	
								rs2.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}
							gross_amount = st1.nextToken();
							if(gross_amount.equals(" ")) gross_amount="";
							gross_amount = cf.formatCurrency(gross_amount, noofdecimal);									

							tot_amt = tot_amt+Double.parseDouble(gross_amount);									

							disc_seq_num = st1.nextToken();
							if(disc_seq_num.equals(" ")) disc_seq_num="";

							mult_surg_disc_perc = st1.nextToken();
							if(mult_surg_disc_perc.equals(" ")) mult_surg_disc_perc="";
							mult_surg_disc_perc = cf.formatCurrency(mult_surg_disc_perc, noofdecimal);

							mult_surg_disp_disc_perc  = st1.nextToken();
							if(mult_surg_disp_disc_perc.equals(" ")) mult_surg_disp_disc_perc="";
							mult_surg_disp_disc_perc = cf.formatCurrency(mult_surg_disp_disc_perc, noofdecimal);

							disc_amt = st1.nextToken();
							if(disc_amt.equals(" ")) disc_amt="";
								
							disc_amt = cf.formatCurrency(disc_amt, noofdecimal);
							if(disc_amt.equals(" ")) disc_amt="";
								
							net_amt = st1.nextToken();
							if(net_amt.equals(" ")) net_amt="";
							net_amt = cf.formatCurrency(net_amt, noofdecimal);
							
							pat_pay_amt = st1.nextToken();	
							if(pat_pay_amt.equals(" ")) pat_pay_amt="";
							pat_pay_amt = cf.formatCurrency(pat_pay_amt, noofdecimal);

							ass_ot_role_type = st1.nextToken();
							if(ass_ot_role_type.equals(" ")) ass_ot_role_type="";
	
							try
							{
								pstmt = con.prepareStatement( "SELECT ROLE_TYPE_DESC FROM OT_ROLE_TYPE 	WHERE UPPER(ROLE_TYPE)=UPPER('"+ass_ot_role_type+"')");
				
								rsrole = pstmt.executeQuery();	

								while(rsrole.next())
								{
								   ass_ot_role_type_desc  =  rsrole.getString(1);		
								}	
								rsrole.close();
								pstmt.close();
							}
							catch(Exception e)
							{
								System.out.println("1="+e.toString());
							}

							sysmessageid =st1.nextToken();
							if(sysmessageid.equals(" ")) sysmessageid="";
							
							errorlevel=st1.nextToken();	
							if(errorlevel.equals(" ")||errorlevel.equals("0")) errorlevel="";
							
							errortext=st1.nextToken();
							if(errortext.equals(" ")) errortext="";

//							System.out.println("sysmessageid:"+sysmessageid);
//							System.out.println("errortext:"+errortext);

					

							if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
							{
								checked_val="";
							}
							else
							{
								checked_val="checked";
							}
							
							if(k==0)
							{
								classval="PATIENTLINECOLOR";
								str_disabled="";
								//checked_val="";
								chk_box_val="Y";
							}
							else
							{
								if(i % 2 == 0 )
								{
									if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
									{
										classval="RED";
										str_disabled="DISABLED";
										chk_box_val="";
									}
									else
									{
										classval	=	"NORMPATLINE";		
										str_disabled="";
										chk_box_val="Y";
									}
								}
								else
								{
									if(!sysmessageid.equals("") || (!errorlevel.equals("") || !errortext.equals("")))
									{
										classval="RED";
										str_disabled="DISABLED";
										chk_box_val="";
									}
									else
									{					
										classval	=	"NORMPATLINE";
										str_disabled="";
										chk_box_val="Y";
									}
								}
							}
%>	
	<!--
	<table border='1' cellpadding='3' cellspacing='0' align = 'center' width='100%'>		
-->
		<tr id=row<%=i%>>
				<%
							if(k==0)
							{
				%>
			<!--	<td class=<%=classval%> width='6%' ><input type="checkbox" name='selected_row_<%=ord%>_<%=k%>' id='selected_row_<%=ord%>_<%=k%>' DISABLED style='display:none'></td>-->
			<td class=<%=classval%> width='6%' ><input type="hidden" name='selected_row_<%=ord%>_<%=k%>' id='selected_row_<%=ord%>_<%=k%>' value="<%=chk_box_val%>" ><input type="checkbox" name='selected_row1_<%=ord%>_<%=k%>' id='selected_row1_<%=ord%>_<%=k%>' value="<%=chk_box_val%>" onClick="selected(<%=ord%>,<%=k%>)"  <%=disabled_view_mode%> DISABLED style='display:none'></td>	
				<%								
							}
							else
							{
				%>
			<td class=<%=classval%> width='6%' ><div id= 'sel1' style=<%=style_ref%>><input type="hidden" name='selected_row_<%=ord%>_<%=k%>' id='selected_row_<%=ord%>_<%=k%>' value="<%=chk_box_val%>" ><input type="checkbox" name='selected_row1_<%=ord%>_<%=k%>' id='selected_row1_<%=ord%>_<%=k%>' <%=checked_val%> value="<%=chk_box_val%>" onClick="selected(<%=ord%>,<%=k%>)"  <%=disabled_view_mode%> ></div></td>	 
				<%
							}
				%>

<%
							if(k==0)
							{
%>
			<td class=<%=classval%> width="16%" ><%=(cat_blng_serv_desc==null || cat_blng_serv_desc.equals(""))?"&nbsp;":cat_blng_serv_desc%></td>		
<%							}
							else
							{
%>
			<td class=<%=classval%> width="16%" ><%=(serv_desc==null || serv_desc.equals(""))?"&nbsp;":serv_desc%></td>
<%
							}
%>
			<input type="hidden" name="blng_serv_code_<%=ord%>_<%=k%>" id="blng_serv_code_<%=ord%>_<%=k%>" value="<%=service_code%>"> 
			<input type="hidden" name="order_cat_code<%=ord%>_<%=k%>" id="order_cat_code<%=ord%>_<%=k%>" value="<%=order_catalog_array.get(ord)%>"> 

			<td class=<%=classval%> width="8%" style='text-align:right' ><%=(charge_perc==null || charge_perc.equals(""))?"&nbsp;":charge_perc%></td>
			<input type="hidden" name="charge_perc<%=ord%>_<%=k%>" id="charge_perc<%=ord%>_<%=k%>" value="<%=charge_perc%>"> 	
			
			<td class=<%=classval%> width="16%" ><div id="dep_serv_id<%=ord%>_<%=k%>"><%=(dep_serv_desc==null || dep_serv_desc.equals(""))?"&nbsp;":dep_serv_desc%></div></td>
			<input type="hidden" name="dep_blng_serv_code_<%=ord%>_<%=k%>" id="dep_blng_serv_code_<%=ord%>_<%=k%>" value="<%=dep_blng_serv_code%>"> 		
			
			<td class=<%=classval%> width="8%" nowrap  style='text-align:right'><%=(gross_amount==null || gross_amount.equals(""))?"&nbsp;":gross_amount%></td>

			<input type="hidden" name="gross_amt_<%=ord%>_<%=k%>" id="gross_amt_<%=ord%>_<%=k%>" value="<%=gross_amount%>">
			
			<td class=<%=classval%> width="8%"  nowrap style='text-align:right'><%=mult_surg_disp_disc_perc%></td>
			<input type="hidden" name="multi_surg_disc_eff_perc_<%=ord%>_<%=k%>" id="multi_surg_disc_eff_perc_<%=ord%>_<%=k%>" value="<%=mult_surg_disc_perc%>">
			
			<td class=<%=classval%> width="8%"  nowrap style='text-align:right'><%=disc_amt%></td>
			<input type="hidden" name="disc_amt_<%=ord%>_<%=k%>" id="disc_amt_<%=ord%>_<%=k%>" value="<%=disc_amt%>">

			<td class=<%=classval%> width="8%"  nowrap style='text-align:right'><%=net_amt%></td>
			<input type="hidden" name="net_amt_<%=ord%>_<%=k%>" id="net_amt_<%=ord%>_<%=k%>" value="<%=net_amt%>">

			<td class=<%=classval%> width="8%" nowrap style='text-align:right'><%=pat_pay_amt%></td>
			<input type="hidden" name="pat_pay_amt_<%=ord%>_<%=k%>" id="pat_pay_amt_<%=ord%>_<%=k%>" value="<%=pat_pay_amt%>">
<% if(function_id.equals("EDIT"))
{
%>
			<td class=<%=classval%> width="14%">
				<select name='pract_name_<%=ord%>_<%=k%>' id='pract_name_<%=ord%>_<%=k%>' onchange='' <%=str_disabled%> <%=disabled_view_mode%> >
				<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
							//ArrayList arr_pract_id= new ArrayList();
						
							if(k==0)
							{
								for(int n=0;n<arr_role_type.size();n++)
								{
									if(arr_role_type.get(n).equals("OS"))
									{										
										pract_id=(String)arr_sur_id.get(n);
										//out.println("<input type='hidden' name='pract_id_' id='pract_id_'"+ord+"_"+k+"' value='"+pract_id+"'>");
										String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

										stmt = con.createStatement();
										
										ResultSet rssn = stmt.executeQuery(s1);
											
										while(rssn.next())
										{
											pract_short_name = rssn.getString(1) ;
											out.println("<option  value=\""+pract_id+"\">"+pract_short_name+"</option>");
										}	
										rssn.close();
										stmt.close();
									}
								}
							}
							if(!ass_ot_role_type.equals(""))
							{
								for(int n=0;n<arr_role_type.size();n++)
								{
									if(arr_role_type.get(n).equals(ass_ot_role_type))
									{
										pract_id=(String)arr_sur_id.get(n);
										String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

										stmt = con.createStatement();
										ResultSet rssn = stmt.executeQuery(s1);
												
										while(rssn.next())
										{
											pract_short_name = rssn.getString(1) ;												   
											out.println("<option  value=\""+pract_id+"\">"+pract_short_name+"</option>");
										}	
										rssn.close();
										stmt.close();
									}
								}
							}
							else
							{
								
								for(int m=0;m<arr_sur_id.size();m++)
								{									
									pract_id=(String)arr_sur_id.get(m);
									String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id+"' AND LANGUAGE_ID ='"+locale+"'";

									stmt = con.createStatement();
											
									ResultSet rssn = stmt.executeQuery(s1);
												
									while(rssn.next())
									{
										pract_short_name = rssn.getString(1) ;												   
										out.println("<option value=\""+arr_sur_id.get(m)+"\">"+pract_short_name+"</option>");
									}	
									rssn.close();
									stmt.close();
								}
							}
%>
				</select>
<%
	}
	else{
			String pract_id_view = st1.nextToken();
			if(pract_id_view.equals(" ")) pract_id_view="";
			String s1="SELECT SHORT_NAME FROM  AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID ='"+pract_id_view+"' AND LANGUAGE_ID ='"+locale+"'";

			stmt = con.createStatement();
					
			ResultSet rssn = stmt.executeQuery(s1);
						
			while(rssn.next())
			{
				pract_short_name = rssn.getString(1) ;	
				%>
				<td class=<%=classval%> width="10%"><input type="text" name="pract_name_<%=ord%>_<%=k%>" id="pract_name_<%=ord%>_<%=k%>" size="10" value="<%=pract_short_name%>" readonly <%=disabled_view_mode%>></td>
			<%
				
			}	
			rssn.close();
			stmt.close();
			

		}

%>
			</td>
			<input type="hidden" name="order_id_<%=ord%>_<%=k%>" id="order_id_<%=ord%>_<%=k%>" value="<%=order_id%>"> 
			<input type="hidden" name="sysmessageid_<%=ord%>_<%=k%>" id="sysmessageid_<%=ord%>_<%=k%>" value="<%=sysmessageid%>"> 
			<input type="hidden" name="errorlevel_<%=ord%>_<%=k%>" id="errorlevel_<%=ord%>_<%=k%>" value="<%=errorlevel%>"> 
			<input type="hidden" name="errortext_<%=ord%>_<%=k%>" id="errortext_<%=ord%>_<%=k%>" value="<%=errortext%>"> 
			<input type="hidden" name="sec_key_module_id_<%=ord%>_<%=k%>" id="sec_key_module_id_<%=ord%>_<%=k%>" value="<%=sec_key_module_id%>"> 
			<input type="hidden" name="sec_key_main_<%=ord%>_<%=k%>" id="sec_key_main_<%=ord%>_<%=k%>" value="<%=sec_key_main%>"> 
			<input type="hidden" name="sec_key_line_no_<%=ord%>_<%=k%>" id="sec_key_line_no_<%=ord%>_<%=k%>" value="<%=sec_key_line_no%>"> 
			<input type="hidden" name="disc_seq_num_<%=ord%>_<%=k%>" id="disc_seq_num_<%=ord%>_<%=k%>" value="<%=disc_seq_num%>"> 
			<input type="hidden" name="ass_ot_role_type_<%=ord%>_<%=k%>" id="ass_ot_role_type_<%=ord%>_<%=k%>" value="<%=ass_ot_role_type%>">
			<input type="hidden" name="ref_module_id_<%=ord%>_<%=k%>" id="ref_module_id_<%=ord%>_<%=k%>" value="OT"> 
			<input type="hidden" name="ref_oper_num_<%=ord%>_<%=k%>" id="ref_oper_num_<%=ord%>_<%=k%>" value="<%=p_sec_key_main_oper_num%>"> 
		</tr>
<%			
						}
						k++;
						surg_count++;					
					}	
%>
		<input type="hidden" name="order_serv_cnt_<%=ord%>" id="order_serv_cnt_<%=ord%>" value="<%=k-1%>">
		<!--input type="hidden" name="order_serv_cnt_<%=ord%>" value="<%=k-1%>"--> 
<%		
					tot_amt=tot_amt+Double.parseDouble(charge_base_amt);
				}
%>
		<input type="hidden" name='ord_tot_rec' id='ord_tot_rec' value=<%=ord%> >
<%
//			System.err.println("****** Testing");
			}
			else
			{
%>
			<script>
				alert(getMessage("BL9758","BL"));
				parent.window.returnValue="success";
				parent.window.close();
			</script>
<%
			}
		}
		catch(Exception ee)
		{
			System.out.println("Exception in string token :"+ee);
		}	
%>
	<tr>
		<!--<table cellpadding=3 cellspacing=0  width="100%">-->
	<!--	<td width='6%'  class='label'>&nbsp;</td>
		<td width='16%'  class='label'>&nbsp;</td>
		<td width='8%'  class='label'>&nbsp;</td>-->
		<td width='36%'  class='label' colspan="4" ><div align='right'><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></div></td>
		<td width='8%' class='fields'><input type='text' name='gross_amt' id='gross_amt' size='10' maxlength='30' 
			value='' readonly style='text-align:right' ></td>
	    <td width='8%'  class='label'>&nbsp;</td>
		<td width='8%' class="fields"><input type='text' name='disc_amt' id='disc_amt' size='10' maxlength='30' 
			value='' readonly style='text-align:right' ></td>
				
		<td width='8%' class="fields">	<input type='text' name='net_amt' id='net_amt' size='10'  maxlength='30' value='' readonly 			style='text-align:right'></td>

		<td width='8%' class="fields"><input type='text' name='patient_payable' id='patient_payable' size='10'  maxlength='30' value='' readonly style='text-align:right'></td>
       <td width='14%'  class='label'>&nbsp;</td>
	</tr>
	</table>
	<input type="hidden" name='locale' id='locale' value=<%=locale%> >
	<input type="hidden" name='totalRecords' id='totalRecords' value=<%=ord%> >
	<input type="hidden" name='order_catlog_array' id='order_catlog_array' value=<%=order_catalog_array%> >
	<input type="hidden" name='episode_type' id='episode_type' value=<%=episode_type%> >
	<input type="hidden" name='patient_id' id='patient_id' value=<%=p_patient_id%> >
	<input type="hidden" name='episode_id' id='episode_id' value=<%=episode_id%> >	
	<input type="hidden" name='visit_id' id='visit_id' value=<%=visit_id%> >
	<input type="hidden" name='addl_services_yn' id='addl_services_yn' value=<%=addl_services_yn%> >
</form>
</body>
<script>

			parent.frames[2].location.href="../../eBL/jsp/BLSurgeryAddlChargeBtn.jsp?<%=query_string%>";
</script>
</html>
<%
	}
	catch(Exception e)
	{
		System.out.println("Exception main :"+ e);
	}
	finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}	
%>

