<!DOCTYPE html>
<%@ page import="eBL.*,java.sql.*, webbeans.eCommon.* ,webbeans.op.CurrencyFormat, java.io.*,java.util.*,java.net.*,java.lang.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
  <%@include file="../../eCommon/jsp/Common.jsp" %>

<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs=null;ResultSet rst2=null;
	//CallableStatement call = null;
	String str_blng_serv_code="",str_order_cat_code="";
	String order_serv_cnt="";String str_serv_panel_ind="";	String str_trx_date_time="";String str_serv_qty="";
	String str_overridden_excl_incl_ind="";
	String str_dep_blng_serv_code="",str_dep_serv_charge_eff_perc="",str_mult_surg_disc_seq="",str_multi_surg_disc_eff_perc="",str_ref_sec_module_id="",str_ref_sec_key_main="",str_ref_sec_key_line_num="",str_charge_based_amt="",str_disc_seq_num="",str_pract_id="",			str_ref_oper_num="",str_ref_module_id="";

try{
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	con	=	ConnectionManager.getConnection(request);	

	String strclientip = p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
//	System.out.println("strclientip  dtl proc :"+strclientip);

	String locale	= (String)session.getAttribute("LOCALE");
//	System.out.println("locale  dtl proc :"+locale);

	String facility_id = (String) session.getValue("facility_id");
	if (facility_id==null) facility_id = "";
//	System.out.println("facility_id  dtl proc :"+facility_id);

	String	strloggeduser	=  (String) session.getValue("login_user");	
	if (strloggeduser==null) strloggeduser = "";
//	System.out.println("strloggeduser  dtl proc :"+strloggeduser);

	String	patient_id  = request.getParameter("patient_id");	
	if (patient_id==null) patient_id = "";
//	System.out.println("patient_id  dtl proc :"+patient_id);

	String	episode_type = request.getParameter("episode_type");	
	if (episode_type==null) episode_type = "";
//	System.out.println("episode_type  dtl proc :"+episode_type);

	String	episode_id = request.getParameter("episode_id");
	if (episode_id==null) episode_id = "";
//	System.out.println("episode_id  dtl proc :"+episode_id);

	String	visit_id = request.getParameter("visit_id");	
	if (visit_id==null) visit_id = "";
//	System.out.println("visit_id  dtl proc :"+visit_id);

	String  total_records=request.getParameter("totalRecords");	
	if (total_records==null) total_records = "";

	
	String  ord_tot_rec=request.getParameter("ord_tot_rec");	
	if (ord_tot_rec==null) ord_tot_rec = "";

//	System.out.println("ord_tot_rec submit @@"+ord_tot_rec);
	int int_ord_tot_rec=Integer.parseInt(ord_tot_rec);	
//	System.out.println("ord_tot_rec INT submit @@"+ord_tot_rec);

//	System.out.println("total_records submit @@"+total_records);
	if ( total_records == null ) total_records = "";
	int int_total_records=Integer.parseInt(total_records);	
//	System.out.println("int_total_records submit @@"+int_total_records);
	

	String bean_id = "Bl_BLAddlSurgeryReturnValuesBean" ;
	String bean_name = "eBL.BLAddlSurgeryReturnValuesBean";

	BLAddlSurgeryReturnValuesBean bean			= (BLAddlSurgeryReturnValuesBean)getBeanObject( bean_id, bean_name, request ) ;
	putObjectInBean(bean_id,bean,request);
//	beansetvalues.clearBean();			
	String currdate="",str_ws_by_ip_name="",strclientname="";;
	String blng_serv_code="", dep_blng_serv_code="", order_cat_code="", serv_panel_ind="", serv_qty="",  charging_stage="", charge_based_amt="",pract_id="", overridden_excl_incl_ind="",  dep_serv_charge_eff_perc="", mult_surg_disc_seq="", ref_sec_module_id="",ref_sec_key_main="",ref_sec_key_line_num="",multi_surg_disc_eff_perc="",disc_seq_num="",ref_module_id="",ref_oper_num="";
	serv_panel_ind="S";
	serv_qty="1";
	 try{		
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
	

	}catch(Exception e)
	{
		System.out.println("error in date");
	}
//	System.out.println("currdate :" +currdate); 
	try
	{
	
		String sqlst1="select ws_by_ip_name from sm_facility_param_vw where facility_id = '"+facility_id+"'";
		 pstmt=con.prepareStatement(sqlst1);
		rs = pstmt.executeQuery();
		if (rs!=null)
		{
		   if (rs.next())
		   {
				 str_ws_by_ip_name = rs.getString("ws_by_ip_name");
		   }
		}

		if (rs != null)   rs.close();
		if (pstmt != null)   pstmt.close();

		if ( str_ws_by_ip_name == null ) str_ws_by_ip_name ="";		
		if (str_ws_by_ip_name.equals("I"))
		{
			strclientname = InetAddress.getByName((String) strclientip).getHostName().toUpperCase();
		}
		else
		{	
			strclientname = strclientip; 
		}		
//System.out.println("strclientname  dtl proc :"+strclientname);
	//HashMap hm_StringDtls =(HashMap) bean.getServiceString("service_string"); 
				
	//FOR DEATAILS

int int_order_serv_cnt=0;
		for(int ord=0;ord<int_ord_tot_rec;ord++)
		{
			order_serv_cnt = request.getParameter("order_serv_cnt_"+ord);
			int_order_serv_cnt = Integer.parseInt(order_serv_cnt);	
			int_order_serv_cnt=int_order_serv_cnt+1;
			for(int i=0;i<int_order_serv_cnt;i++)
			{
				String selected_row = request.getParameter("selected_row_"+ord+"_"+i);
				if(selected_row == null) selected_row="";

			if(selected_row.equals("Y")){
				order_cat_code = request.getParameter("order_cat_code"+ord+"_"+i);
				if ( order_cat_code == null )  order_cat_code = "";
				str_order_cat_code = str_order_cat_code + order_cat_code+"|";

				blng_serv_code = request.getParameter("blng_serv_code_"+ord+"_"+i);
				if ( blng_serv_code == null )  blng_serv_code = "";
				str_blng_serv_code = str_blng_serv_code + blng_serv_code+"|";

				str_serv_panel_ind=str_serv_panel_ind + serv_panel_ind +"|";
				
				str_trx_date_time = str_trx_date_time + currdate+"|";

				str_serv_qty = str_serv_qty + serv_qty+"|";

				str_charge_based_amt = str_charge_based_amt + charge_based_amt+"|";

				str_overridden_excl_incl_ind = str_overridden_excl_incl_ind + overridden_excl_incl_ind+"|";

				dep_blng_serv_code = request.getParameter("dep_blng_serv_code_"+ord+"_"+i);				
				if ( dep_blng_serv_code == null )  dep_blng_serv_code = "";
				str_dep_blng_serv_code = str_dep_blng_serv_code + dep_blng_serv_code+"|";


				dep_serv_charge_eff_perc = request.getParameter("charge_perc"+ord+"_"+i);				
				if ( dep_blng_serv_code == null )  dep_blng_serv_code = "";
				str_dep_serv_charge_eff_perc = str_dep_serv_charge_eff_perc + dep_serv_charge_eff_perc+"|";
				
				str_mult_surg_disc_seq=str_mult_surg_disc_seq+mult_surg_disc_seq+"|";

				//str_multi_surg_disc_eff_perc=str_multi_surg_disc_eff_perc+mult_surg_disc_seq+"|";

				multi_surg_disc_eff_perc = request.getParameter("multi_surg_disc_eff_perc_"+ord+"_"+i);				
				if ( multi_surg_disc_eff_perc == null )  multi_surg_disc_eff_perc = "";
				str_multi_surg_disc_eff_perc = str_multi_surg_disc_eff_perc + multi_surg_disc_eff_perc+"|";

				ref_sec_module_id = request.getParameter("sec_key_module_id_"+ord+"_"+i);				
				if ( ref_sec_module_id == null )  ref_sec_module_id = "";
				str_ref_sec_module_id = str_ref_sec_module_id + ref_sec_module_id+"|";

				ref_sec_key_main = request.getParameter("sec_key_main_"+ord+"_"+i);				
				if ( ref_sec_key_main == null )  ref_sec_key_main = "";
				str_ref_sec_key_main = str_ref_sec_key_main + ref_sec_key_main+"|";

				ref_sec_key_line_num = request.getParameter("sec_key_line_no_"+ord+"_"+i);				
				if ( ref_sec_key_line_num == null )  ref_sec_key_line_num = "";
				str_ref_sec_key_line_num = str_ref_sec_key_line_num + ref_sec_key_line_num+"|";
				

				disc_seq_num = request.getParameter("disc_seq_num_"+ord+"_"+i);				
				if ( disc_seq_num == null )  disc_seq_num = "";
				str_disc_seq_num = str_disc_seq_num + disc_seq_num+"|";
				
				pract_id = request.getParameter("pract_name_"+ord+"_"+i);				
				if ( pract_id == null )  pract_id = "";
				str_pract_id = str_pract_id + pract_id+"|";


				ref_oper_num = request.getParameter("ref_oper_num_"+ord+"_"+i);				
				if ( ref_oper_num == null )  ref_oper_num = "";
				str_ref_oper_num = str_ref_oper_num + ref_oper_num+"|";

				ref_module_id = request.getParameter("ref_module_id_"+ord+"_"+i);				
				if ( ref_oper_num == null )  ref_oper_num = "";
				str_ref_module_id = str_ref_module_id + ref_module_id+"|";

				
				}
			}
		}

		BLAddlSurgeryReturnValuesBean beansetvalues = (BLAddlSurgeryReturnValuesBean)getBeanObject(bean_id, bean_name, request);
		beansetvalues.clearBean();	
		String addl_services_yn = request.getParameter("addl_services_yn");
		if(addl_services_yn.equals("Y"))
		{
		beansetvalues.setAddSurgeryValues(facility_id,patient_id,episode_type,episode_id,visit_id,str_order_cat_code,str_serv_panel_ind,str_blng_serv_code,str_trx_date_time,str_serv_qty,charging_stage,str_charge_based_amt,str_pract_id,str_overridden_excl_incl_ind,strloggeduser,strclientip,str_dep_blng_serv_code,str_dep_serv_charge_eff_perc,str_disc_seq_num,str_multi_surg_disc_eff_perc,str_ref_sec_module_id,str_ref_sec_key_main,str_ref_sec_key_line_num,str_ref_oper_num,str_ref_module_id);
		}

		
		HashMap hm =new HashMap();
		
		BLAddlSurgeryReturnValuesBean beangetvalues = (BLAddlSurgeryReturnValuesBean)getBeanObject(bean_id, bean_name, request);
		hm=beangetvalues.getAddSurgeryValues();
		
		
		
			

	}catch(Exception e)
	{
		System.out.println("Exception main :"+ e);
	}



			%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form>


	
		<input type='hidden' name="facility_id" id="facility_id" value="<%=facility_id%>">
		<input type='hidden' name="patient_id" id="patient_id" value="<%=patient_id%>" >
		<input type='hidden' name="episode_type" id="episode_type" value="<%=episode_type%>" >
		<input type='hidden' name="episode_id" id="episode_id" value="<%=episode_id%>" >
		<input type='hidden' name="visit_id" id="visit_id" value="<%=visit_id%>" >
		<input type='hidden' name="str_order_cat_code" id="str_order_cat_code" value="<%=str_order_cat_code%>" >
		<input type='hidden' name="str_serv_panel_ind" id="str_serv_panel_ind" value="<%=str_serv_panel_ind%>" >
		<input type='hidden' name="str_blng_serv_code" id="str_blng_serv_code" value="<%=str_blng_serv_code%>" >
		<input type='hidden' name="str_trx_date_time" id="str_trx_date_time" value="<%=str_trx_date_time%>" >
		<input type='hidden' name="str_serv_qty" id="str_serv_qty" value="<%=str_serv_qty%>" >
		<input type='hidden' name="charging_stage" id="charging_stage" value="<%=charging_stage%>" >
		<input type='hidden' name="str_charge_based_amt" id="str_charge_based_amt" value="<%=str_charge_based_amt%>" >
		<input type='hidden' name="str_pract_id" id="str_pract_id" value="<%=str_pract_id%>" >
		<input type='hidden' name="str_overridden_excl_incl_ind" id="str_overridden_excl_incl_ind" value="<%=str_overridden_excl_incl_ind%>" >
		<input type='hidden' name="strloggeduser" id="strloggeduser" value="<%=strloggeduser%>" >
		<input type='hidden' name="strclientip" id="strclientip" value="<%=strclientip%>" >
		<input type='hidden' name="str_dep_blng_serv_code" id="str_dep_blng_serv_code" value="<%=str_dep_blng_serv_code%>" >
		<input type='hidden' name="str_dep_serv_charge_eff_perc" id="str_dep_serv_charge_eff_perc" value="<%=str_dep_serv_charge_eff_perc%>" >
		<input type='hidden' name="str_disc_seq_num" id="str_disc_seq_num" value="<%=str_disc_seq_num%>" >
		<input type='hidden' name="str_multi_surg_disc_eff_perc" id="str_multi_surg_disc_eff_perc" value="<%=str_multi_surg_disc_eff_perc%>" >
		<input type='hidden' name="str_ref_sec_module_id" id="str_ref_sec_module_id" value="<%=str_ref_sec_module_id%>" >
		<input type='hidden' name="str_ref_sec_key_main" id="str_ref_sec_key_main" value="<%=str_ref_sec_key_main%>" >
		<input type='hidden' name="str_ref_sec_key_line_num" id="str_ref_sec_key_line_num" value="<%=str_ref_sec_key_line_num%>" >
		
</form>	 
			<script>
		var facility_id = document.forms[0].facility_id.value; 
		var patient_id = document.forms[0].patient_id.value; 
		var episode_type = document.forms[0].episode_type.value; 
		var episode_id = document.forms[0].episode_id.value; 
		var visit_id = document.forms[0].visit_id.value; 
		var str_order_cat_code = document.forms[0].str_order_cat_code.value; 
		var str_serv_panel_ind = document.forms[0].str_serv_panel_ind.value; 
		var str_blng_serv_code = document.forms[0].str_blng_serv_code.value; 
		var str_trx_date_time = document.forms[0].str_trx_date_time.value; 
		var str_serv_qty = document.forms[0].str_serv_qty.value; 
		var charging_stage = document.forms[0].charging_stage.value; 
		var str_charge_based_amt = document.forms[0].str_charge_based_amt.value; 
		var str_pract_id = document.forms[0].str_pract_id.value;
		var str_overridden_excl_incl_ind = document.forms[0].str_overridden_excl_incl_ind.value; 
		var strloggeduser = document.forms[0].strloggeduser.value; 
		var strclientip = document.forms[0].strclientip.value; 
		var str_dep_blng_serv_code = document.forms[0].str_dep_blng_serv_code.value; 
		var str_dep_serv_charge_eff_perc = document.forms[0].str_dep_serv_charge_eff_perc.value; 
		var str_disc_seq_num = document.forms[0].str_disc_seq_num.value; 
		var str_multi_surg_disc_eff_perc = document.forms[0].str_multi_surg_disc_eff_perc.value; 		
		var str_ref_sec_module_id = document.forms[0].str_ref_sec_module_id.value; 
		var str_ref_sec_key_main = document.forms[0].str_ref_sec_key_main.value; 
		var str_ref_sec_key_line_num = document.forms[0].str_ref_sec_key_line_num.value; 
		

	parent.window.returnValue="success";
	parent.window.close();
	</script>
</body>
</html>

<%

}catch(Exception e)
{
	System.out.println("Exception main :"+ e);
}
finally
	{

		if(pstmt != null)pstmt.close();
		// call.close();	
		ConnectionManager.returnConnection(con, request);
	}	
%>

		

