<!DOCTYPE html>
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	Connection con = null;
	PreparedStatement pstmt = null ;
	PreparedStatement pstmt1 = null ; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	//ResultSet rs1 = null; ResultSet rs2 = null; 
	ResultSet rs_dec=null;
	ResultSet rs_dec1=null; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	
	ResultSet  rs_chrge = null;

	//Statement stmt=null;	
		String myval=request.getParameter("blng_serv_code");
		//muthu
		  String bling_serv_code1="";
		 //muthu
	String locale = (String)session.getAttribute("LOCALE");
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	con	=	ConnectionManager.getConnection(request);
	//String sql_chr_det=""; String sql_phisician=""; String sql_phisician1="";
	String p_action_ind="";	//String sql=""; String sql1=""; String sql2=""; String sql3="";
	String stradded_serv_yn="";	String readonly="";
	
	String originalqty="";
	String revise_qty_flag="";	String rate_flag="";
	 p_action_ind=request.getParameter("action");
	
	if(p_action_ind==null || p_action_ind.equals("")) p_action_ind="";
	if(p_action_ind.equals("add"))
	{
		
		stradded_serv_yn="Y";
		
	}
		else 
		{
			//System.out.println("Entering into Else Condition********* ");
			stradded_serv_yn=request.getParameter("added_serv_yn");
			readonly="READONLY";
		}
	//if(stradded_serv_yn.equals("null"))stradded_serv_yn="N";
	String p_facility_id="";	String p_login_user=""; 	String p_episode_type="";
	String p_patient_id="";    	String str_episode_id="";long p_episode_id=0;     	String str_visit_id="";
	long p_visit_id=0; String p_service_date="";   String p_service_panel_ind=""; 	String p_service_panel_code="";
	String p_serv_panel_qty=""; 	String p_pract_staff_ind=""; 	//String p_pract_staff_id="";
	String p_serv_panel_str=""; 	String p_order_catalog_code=""; 	String service="";
	String incl_excl="";	String incl_excl_action=""; String incl_action_flag="";String excl_action_flag=""; 	String reason=""; String uom="";String charge="";		String original_qty="";		String revise_qty="";	
	String total_qty="";	String rate="";	 	String practioner_type=""; String pract_staff_id=""; 	
	String practioner="";	String total_pay="";		String patient_pay=""; //String cbflag="";
	//String strservice=""; 		String strincl_excl="";		String strincl_excl_action="";
	//String strreason="";	String strcharge="";	String stroriginal_qty="";
	//String strrevise_qty="";	String strtotal_qty="";	String strrate=""; String struom="";
	//String strpractioner_type="";String strpractioner="";	String strtotal_pay="";String strpatient_pay="";		
	//String cbflag1=""; String cbflag12="";
	String patient_paid=""; String blng_serv_code=""; String action_reason_code="";String  uom_code=""; 
	String pract_id="";	String p_module_id=""; 	String preappr_reqd="";String modify_qty_yn=""; 	int noofdecimal=0;
	float max_chg_amt=0; //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	float max_chg_amt1=0;
    String include_label="";String exclude_label="";
	String str_encounter_id="";String str_acct_seq_no="";String ratecharge_desc="";	String p_charged_yn="";
	String p_order_id=""; String p_order_line_no="";String str_override_yn="";
	String p_serv_qty=""; String str_charge_based_amt="";String p_incl_excl_action="";String override_allowed_yn="",panel_qty="",serv_amt_changed="";
	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	String charge_logic_yn="";
	String dirIndirChrgsFlag="";
	//String bean_name_bl="";
	//HashMap finDtls		= new HashMap();
	/******end*******************/



	String str_epi_type_clinic_code="";
	try
	{
		
		originalqty=request.getParameter("original_qty");
		System.out.println("original_qty"+originalqty);
		
		p_facility_id = (String)httpSession.getValue("facility_id");
		p_login_user =  p.getProperty("login_user");
		p_episode_type = request.getParameter("episode_type");
		p_patient_id = request.getParameter("patient_id");
		str_visit_id = request.getParameter("visit_id");		
		str_episode_id = request.getParameter("episode_id");
		p_service_date = request.getParameter("service_date");
		p_service_panel_ind = request.getParameter("service_panel_ind");
		p_service_panel_code = request.getParameter("service_panel_code");
		p_serv_panel_qty = request.getParameter("serv_panel_qty");
		p_pract_staff_ind = request.getParameter("pract_staff_ind");
		include_label=request.getParameter("include_label");
		exclude_label=request.getParameter("exclude_label");	
		dirIndirChrgsFlag=request.getParameter("dirIndirChrgsFlag");

		practioner_type = request.getParameter("practioner_type");
		pract_id=request.getParameter("pract_id");

		practioner = request.getParameter("practioner");
		pract_staff_id = request.getParameter("pract_staff_id");

		p_serv_panel_str = request.getParameter("serv_panel_str");
		p_order_catalog_code = request.getParameter("order_catalog_code");	
		p_module_id = request.getParameter("module_id");		
		str_encounter_id=request.getParameter("encounter_id");
		ratecharge_desc=request.getParameter("ratecharge_desc");
		p_charged_yn=request.getParameter("p_charged_yn");
		p_serv_qty=request.getParameter("revise_qty");
		if(p_serv_qty==null || p_serv_qty.equals("")) p_serv_qty="";	

		panel_qty=request.getParameter("panel_qty");
		if(panel_qty==null || panel_qty.equals("")) panel_qty="";	

		override_allowed_yn=request.getParameter("override_allowed_yn");
		if(override_allowed_yn==null || override_allowed_yn.equals(" ")) override_allowed_yn="";
	
		p_order_id = request.getParameter("p_order_id");
		if(p_order_id==null || p_order_id.equals("")) p_order_id="";
		
		p_order_line_no= request.getParameter("p_order_line_no");
		if(p_order_line_no==null || p_order_line_no.equals("")) p_order_line_no="";		

		serv_amt_changed=request.getParameter("serv_amt_changed");
		if(serv_amt_changed==null || serv_amt_changed.equals("")) serv_amt_changed="";

		if(str_encounter_id==null || str_encounter_id.equals("")) str_encounter_id="0";
		str_acct_seq_no=request.getParameter("acct_seq_no");
		if(str_acct_seq_no==null || str_acct_seq_no.equals("")) str_acct_seq_no="1";

		str_epi_type_clinic_code=request.getParameter("str_epi_type_clinic_code");
		if(str_epi_type_clinic_code==null) str_epi_type_clinic_code="";

		if(p_episode_type==null) p_episode_type="";
		if(p_patient_id==null) p_patient_id="";
		if(str_visit_id==null) str_visit_id="0";
		if(str_episode_id==null) str_episode_id="0";
		if(p_service_date==null) p_service_date="";
//		p_service_date=com.ehis.util.DateUtils.convertDate(p_service_date,"DMYHMS","en",locale);
		if(p_service_panel_ind==null) p_service_panel_ind="";
		
		if(p_serv_panel_qty==null) p_serv_panel_qty="";		
		if(p_pract_staff_ind==null) p_pract_staff_ind="";
		if(pract_id==null) pract_id="";
		if(practioner_type==null) practioner_type="";
		if(pract_staff_id==null) pract_staff_id="";
		if(practioner==null) practioner="";
//		System.out.println("practioner @@" + practioner);
		if(p_serv_panel_str==null) p_serv_panel_str="";
		if(p_order_catalog_code==null) p_order_catalog_code="";
		if(ratecharge_desc==null) ratecharge_desc="";
		if(p_charged_yn==null) p_charged_yn="";
		p_episode_id=Long.parseLong(str_episode_id);	
		p_visit_id=Integer.parseInt(str_visit_id);	

		//include_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Include.label","common_labels");
		//exclude_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Exclude.label","common_labels");

		/****ghl-crf-1.2*************/	
		calledfrmencYN=request.getParameter("calledfrmencYN");
		if(calledfrmencYN==null) calledfrmencYN="";
//		System.out.println("calledfrmencYN edit"+calledfrmencYN);
		if(calledfrmencYN.equals("Y"))
		{
			bean_id_bl=request.getParameter("bean_id_bl");
			if(bean_id_bl==null) bean_id_bl="";
		}
			/******end*******************/	
	}
	catch(Exception eX)
	{	
		out.println("Error= "+eX);
	}
	
	try
	{
		pstmt1 = con.prepareStatement("select NVL(charge_logic_yn,'N') from bl_parameters where operating_facility_id ='"+p_facility_id+"'");				
		rs_chrge = pstmt1.executeQuery();	
		if ( rs_chrge.next() && rs_chrge != null )
			charge_logic_yn  =  rs_chrge.getString(1);
		System.out.println(" Charage logic  Yn "+charge_logic_yn);
		
	}
	catch(Exception ee1)  {System.out.println("Exception ee"+ee1);}
	finally
	{
		if(rs_chrge!=null) rs_chrge.close();
		if(pstmt1!=null) pstmt1.close();		
	}
	
		try
			{
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
String bling_serv_code=request.getParameter("blng_serv_code");
pstmt1 = con.prepareStatement("select nvl(MAX_CHARGE_AMT,0) MAX_CHARGE_AMT from bl_blng_serv where BLNG_SERV_CODE ='"+bling_serv_code+"'");				
rs_dec1 = pstmt1.executeQuery();	
if ( rs_dec1.next() && rs_dec1 != null ) 
max_chg_amt  =  rs_dec1.getInt(1);
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");				
				rs_dec = pstmt.executeQuery();	
				if ( rs_dec.next() && rs_dec != null ) 
				noofdecimal  =  rs_dec.getInt(1);
				
				/*String sqlincexclover="{call blcommon.bl_check_excl_incl_override('"+p_facility_id+"','"+p_episode_type+"','"+p_episode_id+"','"+p_visit_id+"','"+p_patient_id+"','"+p_service_panel_code+"',?)}";
				CallableStatement call = con.prepareCall(sqlincexclover);	
				call.registerOutParameter(1,java.sql.Types.VARCHAR);
				call.execute();	
				str_override_yn=call.getString(1);
				if(str_override_yn==null) str_override_yn="";
				System.out.println("str_override_yn"+str_override_yn);
				call.close();
				*/
			}
			catch(Exception e)
			{
				System.out.println("4="+e.toString());
			}
			finally 
			{
				if (rs_dec != null)   rs_dec.close();
				if (rs_dec1 != null)   rs_dec1.close(); //Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				if (pstmt != null) pstmt.close();
				if (pstmt1 != null) pstmt1.close();//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							}
			}

	try{   
	//muthu
	String service1=request.getParameter("service");
	//muthu
		if(p_action_ind.equals("modify") || p_action_ind.equals("remove"))
		{
			//System.out.println("Enter into Modify 204 in BodyEdit.jsp **** ");
			service=request.getParameter("service");
			//muthu
			//System.out.println("muthu_in_modified mode======>"+service);
			//muthu
			if(service==null || service.equals("")) service="";
			blng_serv_code=request.getParameter("blng_serv_code");
			if(blng_serv_code==null || blng_serv_code.equals("")) blng_serv_code="";
			incl_excl=request.getParameter("incl_excl");
			if(incl_excl==null || incl_excl.equals("")) incl_excl="";			
			incl_excl_action=request.getParameter("incl_excl_action");
			if(incl_excl_action==null || incl_excl_action.equals("")) incl_excl_action="";
			if(incl_excl_action.equals(include_label))
			{
//				System.out.println("exclude_label edit 1");
				incl_action_flag="SELECTED";
				excl_action_flag="";
			}
			else if(incl_excl_action.equals(exclude_label))
					{
				
						incl_action_flag="";
						excl_action_flag="SELECTED";
					}
					reason=request.getParameter("reason");
					if(reason==null ||reason.equals("")) reason="";
					action_reason_code=request.getParameter("action_reason_code");
					if(action_reason_code==null ||action_reason_code.equals("")) action_reason_code="";
					charge=request.getParameter("charge");
				
					if(charge==null ||charge.equals("")) charge="";
					original_qty=request.getParameter("original_qty");
					if(original_qty==null ||original_qty.equals("")) original_qty="";
					modify_qty_yn=request.getParameter("modify_qty_yn");
					if(modify_qty_yn==null ||modify_qty_yn.equals("")) modify_qty_yn="";
					uom=request.getParameter("uom");
					if(uom==null ||uom.equals("")) uom="";
					uom_code=request.getParameter("uom_code");
					if(uom_code==null ||uom_code.equals("")) uom_code="";
					revise_qty=request.getParameter("revise_qty");
					if(revise_qty==null ||revise_qty.equals("")) revise_qty="";
					total_qty=request.getParameter("total_qty");
					if(total_qty==null ||total_qty.equals("")) total_qty="";
					rate=request.getParameter("rate");
					if(rate==null ||rate.equals("")) rate="";
					if(charge.equals("R"))
						{
							rate_flag="readonly";	
						}
						else if(charge.equals("C"))
							{
								revise_qty_flag="readonly";	
							}

						if(charge.equals("R"))
						{
							str_charge_based_amt=revise_qty;	
						}
						else if(charge.equals("C"))
							{
							str_charge_based_amt=rate;
							}		
							if(incl_excl_action.equals("Exclude en")||incl_excl_action.equals("Exclude"))
							{
								p_incl_excl_action="E";
							}
							else if(incl_excl_action.equals("Include en")||incl_excl_action.equals("Include"))
								{
									p_incl_excl_action="I";
								}

/*	practioner_type=request.getParameter("practioner_type");
	if(practioner_type.equals("")) practioner_type="";
	pract_id=request.getParameter("pract_id");
	if(pract_id.equals("")) pract_id="";
	practioner=request.getParameter("practioner");
	if(practioner.equals("")) practioner="";
*/
						pract_id=request.getParameter("pract_id");
						if(pract_id==null || pract_id.equals("")) pract_id="";
						practioner_type = request.getParameter("practioner_type");
						if(practioner_type==null || practioner_type.equals("")) practioner_type="";
						pract_staff_id = request.getParameter("pract_staff_id");
						if(pract_staff_id==null || pract_staff_id.equals("")) pract_staff_id="";
						practioner = request.getParameter("practioner");
						if(practioner==null || practioner.equals("")) practioner="";
						total_pay=request.getParameter("total_pay");
						if(total_pay==null || total_pay.equals("")) total_pay="";
						patient_pay=request.getParameter("patient_pay");
						if(patient_pay==null || patient_pay.equals("")) patient_pay="";
						patient_paid=request.getParameter("patient_paid");
						if(patient_paid==null || patient_paid.equals("")) patient_paid="";
						preappr_reqd=request.getParameter("cbflag");	
						if(preappr_reqd==null || preappr_reqd.equals("")) preappr_reqd="";

						serv_amt_changed=request.getParameter("serv_amt_changed");
		if(serv_amt_changed==null || serv_amt_changed.equals("")) serv_amt_changed="";
		}
	
		}catch(Exception eX)
			{	
				out.println("Error modfy= "+eX);
			}
		/*	finally 
			{
				if (rs_dec1 != null)   rs_dec1.close();
				if (pstmt1 != null) pstmt1.close();		 		
				if(con!=null) {
				ConnectionManager.returnConnection(con, request);
							 }
			}*/

//billserventry proc.......
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eBL/js/AddModifyPatFinDetails.js'></script>		
	<!--<script Language="JavaScript" src="../../eCommon/js/DateValidation.js"></script>-->
	<!--<script Language="JavaScript" src='../../eCA/js/ViewClinicalNote.js'></script>-->
	<!--<script Language="JavaScript" src='../../eCommon/js/dchk.js'> </script>-->
	<!--<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>-->
	<!--<script language='javascript' src='../../eCA/js/DateCheck.js' ></script>-->
	<!--<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>-->
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<title>
	<%=request.getParameter("title")%>
</title>
</head>
<script>
var mass="";
	function listitemvalidation()
	{
		//var inclexclind=document.forms[0].str_excl_incl_ind.value;
		var inclexclind=document.forms[0].incl_excl.value;	
		var inclexclact=document.forms[0].incl_excl_action.value;
		if(inclexclind=="")
		{
			inclexclact="X";
		}
		if(inclexclind!="" && inclexclind==inclexclact)
		{
	    document.forms[0].incl_excl.value="";
		document.forms[0].action_reason_desc.value="";
		document.forms[0].action_reason_code.value="";	
		}
	}
	function callvalidations()
	{
		//alert("blng_serv_code "+blng_serv_code);
		document.forms[0].serv_amt_changed.value="";
		var blng_serv_code=document.forms[0].blng_serv_code.value;
		//var blng_serv_code=document.forms[0].blng_serv_code.value;
//alert ("blng_serv_code in calvalidations()--------> "+blng_serv_code)		
		var episode_type=document.forms[0].h_episode_type.value;
		var patient_id=document.forms[0].h_patient_id.value;
		var visit_id=document.forms[0].h_visit_id.value;
		var episode_id=document.forms[0].h_episode_id.value;
		var module_id=document.forms[0].h_module_id.value;
		var action1=document.forms[0].action.value;
		var rate=document.forms[0].rate.value;
		var total_qty=document.forms[0].total_qty.value;
		var incl_excl=document.forms[0].incl_excl.value;
		var service_date=document.forms[0].service_date.value;
		var incl_excl_action=document.forms[0].incl_excl_action.value;
		var revise_qty=document.forms[0].revise_qty.value;
		var rate_charge_ind=document.forms[0].charge.value;	
		
		var p_order_id=document.forms[0].p_order_id.value;
		var p_order_line_no=document.forms[0].p_order_line_no.value;
		var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;
		str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);

		var panel_qty=document.forms[0].panel_qty.value;

		/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN SERV" +calledfrmencYN);
		//alert("bean_id_bl SERV" +bean_id_bl);
		/**End **********************/	
				
		var ind="BLNG_SERV_CODE";
		
		if(blng_serv_code!="")
		{
		  
	//alert ("calvalidations() @ rate_charge_ind ===> "+rate_charge_ind)

	var original_qty=  document.forms[0].original_qty.value;
				var string="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&blng_serv_code="+blng_serv_code+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action1="+action1+"&module_id="+module_id+"&rate="+rate+"&total_qty="+total_qty+"&service_date="+service_date+"&incl_excl_action="+incl_excl_action+"&incl_excl="+incl_excl+"&ind="+ind+"&revise_qty="+revise_qty+"&rate_charge_ind="+rate_charge_ind+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&panel_qty="+panel_qty+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;

				
		
		parent.frames[1].location.href=string;

		}
	}

	function cancel()
	{
		//parent.window.close();
		parent.parent.document.getElementById('dialog_tag').close();
	}
	function acceptchargedet()
	{
		//setTimeout('acceptchargedet1()',500);		
		if(document.forms[0].total_pay.value=="" && document.forms[0].patient_pay.value=="")
		{
			if(document.forms[0].rate_chk.value == "Y")
			{		
				document.forms[0].rate_chk_close.value='Y';
				rateval("Y");
			}
			if(document.forms[0].qty_chk.value == "Y")
			{	
				document.forms[0].rate_chk_close.value='Y';				
				revqyt("Y");
			}
		}
		else
		{
			acceptchargedet1();
		}
	}
	
	async function acceptchargedet1()
	{
		var ser=document.forms[0].service.value;
		if(ser=="")
		{
			alert(getMessage('BL9605','BL'));
			document.forms[0].service.focus();
			return false;
		}	
		var rev_qty=document.forms[0].revise_qty.value;
		if(rev_qty=="" || rev_qty<=0)
		{
			alert(getMessage('BL9606','BL'));	
			document.forms[0].revise_qty.focus();
			return false;
		}
		var ratechr_ind=document.forms[0].charge.value;
		var amt=document.forms[0].rate.value;
		
		if(document.forms[0].rate.value=='0.00')
		{
			if(!(confirm(getMessage('BL9861','BL'))))
			{	
				if(ratechr_ind=='C')
				{
					document.forms[0].rate.focus();
					return false;
				}
				else{
					document.forms[0].revise_qty.focus();
					return false;
				}
			}				
		}

		if(amt=="")
		{
			
			alert(getMessage('BL9862','BL'));
			document.forms[0].rate.focus();
			return false;
		}
	/*		if(ratechr_ind=="C" && amt==0)
		{
			alert(getMessage('BL0628','BL'));
		}	
*/
		if(document.forms[0].incl_excl_action.value!="" && document.forms[0].action_reason_desc.value =="")
		{
			alert(getMessage("BL9608","BL"));
			return false;
		}

		var cbflag=eval("document.forms[0].preappr_reqd");
		//alert("cbflag :"+cbflag.checked);
		if(cbflag.checked)
		{
			 cbflag="checked";
		}
		else
		{
			cbflag=" ";
		}		
		var service=document.forms[0].service.value;
		if(service=="") service=" ";
		var blng_serv_code=document.forms[0].blng_serv_code.value;
		if(blng_serv_code=="") blng_serv_code=" ";
		var incl_excl=document.forms[0].incl_excl.value;
		if(incl_excl=="") incl_excl=" ";
		var incl_excl_action=document.forms[0].incl_excl_action.value;
		if(incl_excl_action=="") incl_excl_action="";
//		if(incl_excl_action=="I") incl_excl_action="Include";
//		if(incl_excl_action=="E") incl_excl_action="Exclude";
		var action_reason_desc=document.forms[0].action_reason_desc.value;
		if(action_reason_desc=="") action_reason_desc="";
		var action_reason_code=document.forms[0].action_reason_code.value;
		if(action_reason_code=="") action_reason_code="";
		var charge=document.forms[0].charge.value;
		if(charge=="") charge="";
		
		var original_qty=document.forms[0].original_qty.value;
		if(original_qty=="") original_qty="";
		var modify_qty_yn=document.forms[0].modify_qty_yn.value;
		if(modify_qty_yn=="") modify_qty_yn="";
		var uom=document.forms[0].uom.value;
		if(uom=="") uom="";
		var uom_code=document.forms[0].uom_code.value;
		if(uom_code=="") uom_code="";
		var revise_qty=document.forms[0].revise_qty.value;
		if(revise_qty=="") revise_qty="";
		var total_qty=document.forms[0].total_qty.value;
		if(total_qty=="") total_qty="";
		var rate=document.forms[0].rate.value;
		//alert("Rate acceptchargedet1 "+rate);
		if(rate=="") rate="";
		var practioner_type=document.forms[0].practioner_type.value;
		if(practioner_type=="") practioner_type="";			
		var pract_id=document.forms[0].pract_id.value;
		if(pract_id=="") pract_id=" ";	
		var pract_staff_id=document.forms[0].pract_staff_id.value;
		if(pract_staff_id=="") pract_staff_id=" ";		
		var practioner=document.forms[0].practioner.value;
		if(practioner=="") practioner="";
		if(practioner_type!='' && practioner=='')
		{
			//alert("practioner/staff cannot be epmty");
			alert(getMessage('BL9889','BL'));
			return false;

		}
		var total_pay=document.forms[0].total_pay.value;
		if(total_pay=="") total_pay="0.0";
		var patient_pay=document.forms[0].patient_pay.value;
		if(patient_pay=="") patient_pay="";
		var patient_paid=document.forms[0].patient_paid.value;
		if(patient_paid=="") patient_paid=" ";
		var ratecharge_desc=document.forms[0].ratecharge_desc.value;
		if(ratecharge_desc=="") ratecharge_desc=" ";	
		var charged_yn=document.forms[0].charged_yn.value;
		if(charged_yn=="") charged_yn=" ";
		var override_yn=document.forms[0].override_yn.value;
		if(override_yn=="") override_yn=" ";

		//var net_amount=document.forms[0].net_amount.value;
		//if(net_amount=="") net_amount=" ";

		var serv_amt_changed=document.forms[0].serv_amt_changed.value;
		if(serv_amt_changed=="") serv_amt_changed=" ";
		var excl_incl_ind_for_screen=document.forms[0].excl_incl_ind_for_screen.value;	

		var retVal= await encodeURIComponent(service)+"::"+blng_serv_code+"::"+incl_excl+"::"+incl_excl_action+"::"+encodeURIComponent(action_reason_desc)+"::"+action_reason_code+"::"+charge+"::"+original_qty+"::"+modify_qty_yn+"::"+encodeURIComponent(uom)+"::"+uom_code+"::"+revise_qty+"::"+total_qty+"::"+rate+"::"+practioner_type+"::"+pract_id+"::"+encodeURIComponent(practioner)+"::"+total_pay+"::"+patient_pay+"::"+patient_paid+"::"+cbflag+"::"+pract_staff_id+"::"+ratecharge_desc+"::"+charged_yn+"::"+override_yn+"::"+serv_amt_changed+"::"+excl_incl_ind_for_screen;
		//parent.window.returnValue = escape(retVal);
		//parent.window.close();
		let dialogBody = parent.parent.document.getElementById('dialog-body');
	    dialogBody.contentWindow.returnValue = escape(retVal);
	    
	    const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	    dialogTag.close();   
	}
function disableAllElements_payer()
{
	var len = document.forms[0].elements.length;
	for(var i=0;i<len;i++)
	{
		document.forms[0].elements(i).disabled=true;
	}
	document.forms[0].modify_button.disabled=false;
	document.forms[0].cancel_button.disabled=false;

}
function disableAllElements_payer_remove()
{
	var len = document.forms[0].elements.length;
	for(var i=0;i<len;i++)
	{
		document.forms[0].elements(i).disabled=true;
	}
	document.forms[0].remove_button.disabled=false;
	document.forms[0].cancel_button.disabled=false;
}

function enableAllElements_service()
{
	/*var len = document.forms[0].elements.length;
	for(var i=0;i<len;i++)
	{document.forms[0].elements(i).disabled=false;	}*/
	//document.forms[0].remove_button.disabled=true;
	//document.forms[0].modify_button.disabled=true;
	document.forms[0].preappr_reqd.disabled=true;
	//document.forms[0].practioner_type.disabled=true;
	//document.forms[0].practstaffbut.disabled=true;		
	var	modify_qty_yn=document.forms[0].modify_qty_yn.value;
	if(modify_qty_yn=="N")
	{
		document.forms[0].revise_qty.readOnly=true;
		$('#revise_qty').removeAttr('onblur');//Added V190909-Aravindh/TBMC-SCF-0086
		//document.forms[0].revise_qty.disabled=true;
	}
	else{
		if(modify_qty_yn=="Y")
		{
			 document.forms[0].revise_qty.readOnly=false;
	//		document.forms[0].revise_qty.disabled=false;
		}
		}
	var charge=document.forms[0].charge.value;
	if(charge=="R")
	{
	}
/*	var pract_type_temp=document.forms[0].practioner_type.value;
	if(pract_type_temp=="")
		{document.forms[0].practstaffbut.disabled=true;
		}else{document.forms[0].practstaffbut.disabled=false;}*/
		var service_panel_ind1=document.forms[0].service_panel_ind1.value;
		if(service_panel_ind1=="S")
		{
			document.forms[0].revise_qty.readOnly=true;
			$('#revise_qty').removeAttr('onblur');//Added V190909-Aravindh/TBMC-SCF-0086
		}
		//var v_override_yn="<%=str_override_yn%>";
		var override_allowed_yn	=document.forms[0].override_yn.value;//"<%=override_allowed_yn%>";
		var dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;
		//alert("override_allowed_yn" +override_allowed_yn);
		if(override_allowed_yn=="" || override_allowed_yn=="N")
			{
				document.forms[0].incl_excl_action.disabled=true;
				document.forms[0].action_reason_desc.disabled=true;
			}
		else if(dirIndirChrgsFlag=='Y'){
			//alert("dirIndirChrgsFlag "+dirIndirChrgsFlag);
				document.forms[0].incl_excl_action.disabled=true;
				document.forms[0].action_reason_desc.disabled=true;
			}
			else{
				document.forms[0].incl_excl_action.disabled=false;
				document.forms[0].action_reason_desc.disabled=false;
				}

		modify_validations()
		}

/*function enableAllElements_service_remove()
{
	//document.forms[0].remove_button.disabled=false;
	document.forms[0].cancel_button.disabled=false;
}*/
function remove_payer()
{
	parent.window.returnValue = "remove";
	parent.window.close();	
}

function PractStaffInd()
{
 document.forms[0].pract_id.value="";
  document.forms[0].practioner.value="";
}

async function servicelkup()
{     
//alert ("---------------------------------"+document.forms[0].blng_serv_code.value)
			//alert("------------------------------------"+retArray[0]);
			document.forms[0].incl_excl.value="";
			//document.forms[0].service.value="";			
			document.forms[0].ratecharge_desc.value="";
			document.forms[0].charge.value="";
			document.forms[0].uom.value="";
			document.forms[0].uom_code.value="";
			document.forms[0].rate.value="";	
			document.forms[0].revise_qty.value='';
			document.forms[0].original_qty.value='';
			document.forms[0].total_qty.value='';
			document.forms[0].total_pay.value='';
			document.forms[0].patient_pay.value='';
			document.forms[0].patient_paid.value='';
			document.forms[0].action_reason_desc.value='';
			document.forms[0].incl_excl_action.value='';
			document.forms[0].incl_excl_action.disabled=false;
			document.forms[0].action_reason_desc.disabled=false;
			var dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;
			if(dirIndirChrgsFlag=='Y'){				
					document.forms[0].incl_excl_action.disabled=true;
					document.forms[0].action_reason_desc.disabled=true;
				}
			
			document.forms[0].action_reason_code.value='';
		var target			= document.forms[0].service;		
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= getLabel("Common.service.label",'COMMON');
		var locale  = document.forms[0].locale.value;		
		var sql1="select blng_serv_code code,long_desc description from bl_blng_serv_lang_vw where language_id = '"+locale+"' AND nvl(status,'x') != 'S'  and upper(blng_serv_code) like upper(?) and upper(long_desc) like upper(?)"; 
		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql1;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;				
		retArray = await CommonLookup( title, argArray );	
		var str =unescape(retArray);
		var arr = str.split(",");
		if(retArray != null && retArray !="")
		{
			document.forms[0].blng_serv_code.value=arr[0];
			//muthu
			//alert("--------blng_serv_code-----"+document.forms[0].blng_serv_code.value)
			//alert("--------retArray-----"+retArray[0]);
			//muthu
			//target.value=retArray[0];
			document.forms[0].service.value=arr[1];			
			/*if(document.forms[0].service.value=="")
			{
				document.forms[0].service.focus();
			}*/
			
			callvalidations();
		}
		else
		{
			
			document.forms[0].incl_excl.value="";
			//document.forms[0].max_chg_amt=""; //muthu 27-2-12
			document.forms[0].service.value="";			
			document.forms[0].blng_serv_code.value="";			
			document.forms[0].ratecharge_desc.value="";
			document.forms[0].charge.value="";
			document.forms[0].uom.value="";
			document.forms[0].uom_code.value="";
			document.forms[0].rate.value="";	
			document.forms[0].revise_qty.value='';
			document.forms[0].original_qty.value='';
			document.forms[0].total_qty.value='';
			document.forms[0].total_pay.value='';
			document.forms[0].patient_pay.value='';
			document.forms[0].patient_paid.value='';
			document.forms[0].incl_excl_action.value='';
			document.forms[0].incl_excl_action.disabled=false;			
			document.forms[0].action_reason_desc.disabled=true;
			var dirIndirChrgsFlag=document.forms[0].dirIndirChrgsFlag.value;
			if(dirIndirChrgsFlag=='Y'){
				//alert("dirIndirChrgsFlag "+dirIndirChrgsFlag);
					document.forms[0].incl_excl_action.disabled=true;
					document.forms[0].action_reason_desc.disabled=true;
				}
			document.forms[0].action_reason_desc.value='';
			document.forms[0].action_reason_code.value='';
			//target.focus();
			//document.forms[0].incl_excl_action.focus();
		}
//document.ss..location.href='../../eBL/jsp/BLEnterEditChargeDetailsBodyEdit.jsp';
		
		}

async function reasonlkup()
{

	if((document.forms[0].blng_serv_code.value == "" && document.forms[0].service.value == "") && document.forms[0].incl_excl_action.value != "")
	{
		return false;
	}
	else if((document.forms[0].blng_serv_code.value == "" && document.forms[0].service.value == "") && document.forms[0].incl_excl_action.value == "")
	{
		return false;
	}
		//var note_group      =document.forms[0].note_group.value;
		var action_reason_desc=document.forms[0].action_reason_desc.value;
		//if(action_reason_desc=="")
		//{
   		var target			= document.forms[0].action_reason_desc;
		var inc_exc			= document.forms[0].incl_excl_action.value;
		if(inc_exc=="") return;
		var retVal			=  new String();
		var dialogTop	= "40";
		var dialogHeight		= "10" ;
		var dialogWidth	= "40" ;
		var features			= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title =getLabel("eBL.INCLUDED_EXCLUDED_ACTION.label","BL");		
		//var title = encodeURIComponent(title);		
		var locale  = document.forms[0].locale.value;			
		var sql2="select  a.action_reason_code code,a.action_reason_desc description from bl_action_reason_lang_vw a where nvl(status,'!') != 'S'and upper(language_id) = upper('"+locale+"')and exists (select b.action_type from bl_action_type b, bl_action_reason_by_type c where b.action_type = c.action_type and b.action_type = 'OV' and c.action_reason_code = a.action_reason_code and c.active_yn = 'Y') and upper(a.action_reason_code) like upper(?) and upper(a.action_reason_desc) like upper(?) order by 1";

		var argArray = new Array();
		var namesArray = new Array();
		var valuesArray = new Array();
		var datatypesArray = new Array();
		argArray[0] = sql2;
		argArray[1] = namesArray;
		argArray[2] = valuesArray;
		argArray[3] = datatypesArray;
		argArray[4] = "1,2";
		argArray[5] = target.value;
		argArray[6] = DESC_LINK;
		argArray[7] = DESC_CODE;		
		retArray = await CommonLookup( title, argArray );	
		var str =unescape(retArray);
		var arr = str.split(",");
		if(retArray != null && retArray !="")
		{		
			document.forms[0].action_reason_code.value=arr[0];
			document.forms[0].action_reason_desc.value=arr[1];			
			reasonvalidations();
			//document.forms[0].reason.focus();
			//document.forms[0].incl_excl_action.focus();			
		}
		else
		{			
			document.forms[0].action_reason_desc.value="";
			document.forms[0].action_reason_code.value="";
			//target.focus();
			//document.forms[0].incl_excl_action.focus();
		}
		//}
		var action_reason_desc_temp=document.forms[0].action_reason_desc.value;
		var incl_excl_action_temp=document.forms[0].incl_excl_action.value;
		if(incl_excl_action_temp!="" && action_reason_desc_temp=="")
		{
			//document.forms[0].action_reason_desc.focus();			
			alert(getMessage("BL9608","BL"));
			return false;
		}
	}	


function reasonvalidations()
{
	//alert("reasonvalidations ")
  var action1=document.forms[0].action.value;
  var incl_excl_action=document.forms[0].incl_excl_action.value;
  var episode_type=document.forms[0].h_episode_type.value;
  var patient_id=document.forms[0].h_patient_id.value;
  var visit_id=document.forms[0].h_visit_id.value;
  var episode_id=document.forms[0].h_episode_id.value;
  var added_serv_yn=document.forms[0].added_serv_yn.value;
  var p_order_id=document.forms[0].p_order_id.value;
  var p_order_line_no=document.forms[0].p_order_line_no.value;
  var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;
	
	var panel_qty=document.forms[0].panel_qty.value;
	/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN edit" +calledfrmencYN);
		//alert("bean_id_bl edit" +bean_id_bl);
	/**End **********************/	

	
  var ind="REASON_CODE";
  var action_reason_code=document.forms[0].action_reason_code.value; 
  var original_qty=  document.forms[0].original_qty.value;
//alert('833');
parent.frames[1].location.href="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&action1="+action1+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action_reason_code="+action_reason_code+"&ind="+ind+"&added_serv_yn="+added_serv_yn+"&incl_excl_action="+incl_excl_action+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&panel_qty="+panel_qty+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;
}

async function funQry(clng_evnt)
{


	if(clng_evnt == 'B')
	{
		if( document.forms[0].practioner.value == "")
		{
			document.forms[0].practioner.value = "";
			document.forms[0].pract_staff_id.value = "";
			return;
		}
	}
		var pract_name="";
		var pract_staff_id="";				
		var retVal			= new String();	
		var dialogTop			= "40";
		var dialogHeight		= "90vh" ;
		var dialogWidth			= "80vw" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var sql					= "";
		var sql3				= "";		
		var locale = document.forms[0].locale.value;
		var facility_id = document.forms[0].facility_id.value;
		var pract_id=document.forms[0].pract_id.value;

		var title=encodeURIComponent(getLabel("eBL.PRACT_STAFF_TYPE.label","BL"));
		var column_sizes = escape("15%,10%,10%,10%");
		if(pract_id=="P")
		{
			var staff_name=encodeURIComponent(getLabel("Common.practitionername.label","common"));
			var staff_id=encodeURIComponent(getLabel("Common.identification.label","common"));
			var short_desc=encodeURIComponent(getLabel("Common.shortdescription.label","common"));
			var staff_type=encodeURIComponent(getLabel("Common.practitionertype.label","common"));
		}else if(pract_id=="O"){
				var staff_name=encodeURIComponent(getLabel("Common.OtherStaffName.label","common"));
				var staff_id=encodeURIComponent(getLabel("Common.identification.label","common"));
				var short_desc=encodeURIComponent(getLabel("Common.shortdescription.label","common"));
				var staff_type=encodeURIComponent(getLabel("Common.OtherStaffType.label","common"));
								}
								else
								{
									//alert("857");//lakshmi									
									return false;
								}
		var column_descriptions =staff_name+","+staff_id+","+short_desc+","+staff_type; 

		

		var message = '';
	//Below Query is Modified By muthuN on 27-8-12 against 28655
	sql3="select a.name NAME,a.PRACTITIONER_ID ID,a.st_type_desc ST_TYPE_DESC,a.st_type STAFF_TYPE from BL_AM_PRACT_STAFF_VW a where PRACT_STAFF_IND='"+pract_id+"' AND LANGUAGE_ID='"+locale+"' AND facility_id='"+facility_id+"'  ";

	//sql3="select name NAME,PRACTITIONER_ID ID,st_type_desc ST_TYPE_DESC,st_type ST_TYPE from BL_AM_PRACT_STAFF_VW where PRACT_STAFF_IND='"+pract_id+"' AND LANGUAGE_ID='"+locale+"' AND facility_id='"+facility_id+"'";
/*	sql3 ="SELECT A.PRACTITIONER_NAME NAME,  A.PRACTITIONER_ID ID,  B.DESC_USERDEF ST_TYPE_DESC, "+
	"A.PRACT_TYPE ST_TYPE FROM AM_PRACTITIONER_LANG_VW A, AM_PRACT_TYPE_LANG_VW B "+
	"WHERE EXISTS (SELECT PRACTITIONER_ID FROM AM_PRACT_FOR_FACILITY C  "+
	"WHERE facility_id = 'HS' AND C.PRACTITIONER_ID = A.PRACTITIONER_ID AND NVL(C.EFF_STATUS,'!') != 'S') "+
	"AND UPPER(A.LANGUAGE_ID) = UPPER('en') AND A.PRACT_TYPE = B.PRACT_TYPE "+
	"AND A.LANGUAGE_ID = B.LANGUAGE_ID AND NVL(A.EFF_STATUS,'!') != 'S' ";/*UNION ALL		"+		
	"SELECT A.OTHER_STAFF_NAME NAME, A.OTHER_STAFF_ID ID, B.SHORT_DESC ST_TYPE_DESC, A.OTHER_STAFF_TYPE ST_TYPE "+
	"FROM AM_OTHER_STAFF_LANG_VW A,AM_OTHER_STAFF_TYPE_LANG_VW B  "+		
    "WHERE EXISTS (SELECT OTHER_STAFF_ID FROM AM_OTHER_STAFF_FOR_FACILITY C "+
    "WHERE facility_id = 'HS' AND C.OTHER_STAFF_ID = A.OTHER_STAFF_ID AND NVL(C.EFF_STATUS,'!') != 'S') "+
    "AND UPPER(A.LANGUAGE_ID) = UPPER('en') AND A.OTHER_STAFF_TYPE = B.OTHER_STAFF_TYPE "+
    "AND A.LANGUAGE_ID = B.LANGUAGE_ID AND NVL(A.EFF_STATUS,'!') != 'S' ";	*/	
	 sql = escape(sql3);	
	 var param = "title="+title+"&"+"column_sizes="+column_sizes+"&"+"column_descriptions="+column_descriptions+"&"+"sql="+sql+"&"+"message="+message+"&target="+encodeURIComponent(document.forms[0].practioner.value)+"&srch_by_clmn_index=1"+"&col_show_hide=YYYY";
	 retVal=await window.showModalDialog("../../eBL/jsp/BLLookupMain.jsp?"+param,arguments,features);		 
	 var arr=new Array();
	 if(retVal == null) retVal='';
	 if (retVal != null || retVal!="")
	{
		 if(retVal!='undefined' && retVal!=undefined)
		{
		 var retVal=unescape(retVal);		 
		 if(retVal != null && retVal.length>0)
		  {
			    //arr=retVal.split("::");	
				arr=retVal.split("^~^");	
				pract_name=arr[0];				
				pract_staff_id=arr[1];				
		  
		  document.forms[0].practioner.value=pract_name;	
		document.forms[0].pract_staff_id.value=pract_staff_id;
//		document.forms[0].practioner.focus();
		  }
		}
	}
		//document.forms[0].practioner.value=pract_name;	
		//document.forms[0].pract_staff_id.value=pract_staff_id;
		//document.forms[0].practioner.focus();
	}
	
function practstaffvalidations()
{	
  var action1=document.forms[0].action.value;
  var practioner=document.forms[0].practioner.value;
  var episode_type=document.forms[0].h_episode_type.value;
  var patient_id=document.forms[0].h_patient_id.value;
  var visit_id=document.forms[0].h_visit_id.value;
  var episode_id=document.forms[0].h_episode_id.value;
  var pract_id=document.forms[0].pract_id.value;
  var pract_id=document.forms[0].pract_id.value; 
  var p_order_id=document.forms[0].p_order_id.value;
  var p_order_line_no=document.forms[0].p_order_line_no.value;
  var ind="PRACT_STAFF";
  var original_qty=  document.forms[0].original_qty.value;
	parent.frames[1].location.href="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&action1="+action1+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&practioner="+practioner+"&ind="+ind+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no;
}

function revqyt(qty_chk)
{
	var action1=document.forms[0].action.value;
	var blng_serv_code=document.forms[0].blng_serv_code.value;	
	var episode_type=document.forms[0].h_episode_type.value;	
	var patient_id=document.forms[0].h_patient_id.value;	
	var visit_id=document.forms[0].h_visit_id.value;	
	var episode_id=document.forms[0].h_episode_id.value;	
	var module_id=document.forms[0].h_module_id.value;
	var rate=document.forms[0].rate.value;
	var total_qty=document.forms[0].total_qty.value;
	var revise_qty=document.forms[0].revise_qty.value;	
	var service_date=document.forms[0].service_date.value;
	var incl_excl_action=document.forms[0].incl_excl_action.value;	
	var rate_charge_ind=document.forms[0].charge.value;	
	var p_order_id=document.forms[0].p_order_id.value;
	var p_order_line_no=document.forms[0].p_order_line_no.value;
	var encounter_id='';//document.forms[0].encounter_id.value;
	var panel_qty=document.forms[0].panel_qty.value;
	
	var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);

	/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN edit" +calledfrmencYN);
		//alert("bean_id_bl edit" +bean_id_bl);
	/**End **********************/	

    var ind="REVISED_QTY";
	if(revise_qty!="")
	{
		var original_qty=  document.forms[0].original_qty.value;
		parent.frames[1].location.href="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&action1="+action1+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&revise_qty="+revise_qty+"&rate_charge_ind="+rate_charge_ind+"&ind="+ind+"&rate="+rate+"&blng_serv_code="+blng_serv_code+"&module_id="+module_id+"&service_date="+service_date+"&incl_excl_action="+incl_excl_action+"&total_qty="+total_qty+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&qty_chk="+qty_chk+"&encounter_id="+encounter_id+"&panel_qty="+panel_qty+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;
	}
}
function rateval(rate_chk,obj)
{ 
//alert("max_chg_amt in rateval() ============> "+obj)
//alert("rate_chk rateval() ==========> "+rate_chk)
	//changeAmt(rate_chk);
	//var mass="";
	if(obj!="")
	{
	mass=obj;
	document.forms[0].max_chg_amt1.value=obj;
	
	//alert ("document.cookie---------"+document.cookie);
	 //mass=document.forms[0].max_chg_amt.value;
	 }
	 //alert ("document.cookie---------"+document.cookie);
	 //alert("mass rateval()===========> "+mass);
    var max_chg_amt = document.forms[0].max_chg_amt.value;
	//alert("in rateval() max max_chg_amt line 1036----> "+max_chg_amt);
	var action1=document.forms[0].action.value;		
	var serv_amt_changed = document.forms[0].serv_amt_changed.value;	
//	alert("serv_amt_changed rateval()====> "+serv_amt_changed);
	var blng_serv_code=document.forms[0].blng_serv_code.value;
	//alert("blng_serv_code in rateval()--> "+blng_serv_code);
	var episode_type=document.forms[0].h_episode_type.value;	
	var patient_id=document.forms[0].h_patient_id.value;
	var visit_id=document.forms[0].h_visit_id.value;
	var episode_id=document.forms[0].h_episode_id.value;
	var module_id=document.forms[0].h_module_id.value;	
	
	var rate=document.forms[0].rate.value;
	//alert("rate in rateval() ====> "+rate);
	//document.forms[0].actual_amt_val.value=rate;
	var total_qty=document.forms[0].total_qty.value;
	var incl_excl=document.forms[0].incl_excl.value;
	var service_date=document.forms[0].service_date.value;
	var incl_excl_action=document.forms[0].incl_excl_action.value;		
	var rate_charge_ind=document.forms[0].charge.value;
	//alert("rate_charge_ind in rateval()===> "+rate_charge_ind);
	var min_chg_amt=document.forms[0].min_chg_amt.value;
	//alert("min_chg_amt "+min_chg_amt);
	var modify_qty_yn=document.forms[0].modify_qty_yn.value;
	var revise_qty=document.forms[0].revise_qty.value;
	var p_order_id=document.forms[0].p_order_id.value;
	var p_order_line_no=document.forms[0].p_order_line_no.value;
	var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);
//	var actual_amt=document.forms[0].actual_amt_val.value;
	
	var panel_qty=document.forms[0].panel_qty.value;

	/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN edit" +calledfrmencYN);
		//alert("bean_id_bl edit" +bean_id_bl);
	/**End **********************/	

//Modified By muthukumar on 31-1-12 against SKR-SCF-0320	 
//if(max_chg_amt == "0.0" ){
//alert("rate in rateval() ==> "+rate+"max_chg_amt in rateval()==> "+max_chg_amt);
if(parseFloat(rate) <= parseFloat(max_chg_amt) || max_chg_amt==0 || rate == ""){
	//alert("*** Entering into If condition in rateval() ***")
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
	var ind="RATE";
	 if(rate!=""){	
//muthu	 
//alert("in rateval() inside if condition blng_serv_code ----> "+blng_serv_code);
//alert("in rateval() inside if condition max max_chg_amt ----> "+max_chg_amt);

//muthu
  
 
 var original_qty=  document.forms[0].original_qty.value;
parent.frames[1].location.href="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&blng_serv_code="+blng_serv_code+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action1="+action1+"&module_id="+module_id+"&rate="+rate+"&total_qty="+total_qty+"&service_date="+service_date+"&incl_excl_action="+incl_excl_action+"&incl_excl="+incl_excl+"&modify_qty_yn="+modify_qty_yn+"&rate_charge_ind="+rate_charge_ind+"&min_chg_amt="+min_chg_amt+"&ind="+ind+"&revise_qty="+revise_qty+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&rate_chk="+rate_chk+"&panel_qty="+panel_qty+"&serv_amt_changed="+serv_amt_changed+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;	
	}
	
	}
	else 
	{	
		alert(getMessage("BL9124",'BL'));
		document.forms[0].rate.value='';
	}
/*
}else{
	if(rate!=""){			 parent.frames[1].location.href='../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?blng_serv_code='+blng_serv_code+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action1="+action1+"&module_id="+module_id+"&rate="+rate+"&total_qty="+total_qty+"&service_date="+service_date+"&incl_excl_action="+incl_excl_action+"&incl_excl="+incl_excl+"&modify_qty_yn="+modify_qty_yn+"&rate_charge_ind="+rate_charge_ind+"&min_chg_amt="+min_chg_amt+"&ind="+ind+"&revise_qty="+revise_qty+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&rate_chk="+rate_chk+"&panel_qty="+panel_qty+"&serv_amt_changed="+serv_amt_changed+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;	
	}
}*/
//Modified By muthukumar on 31-1-12 against SKR-SCF-0320
}
function valexclincl()
{
	var blng_serv_code=document.forms[0].blng_serv_code.value;	
	var episode_type=document.forms[0].h_episode_type.value;
	var patient_id=document.forms[0].h_patient_id.value;
	var visit_id=document.forms[0].h_visit_id.value;
	var episode_id=document.forms[0].h_episode_id.value;
	var module_id=document.forms[0].h_module_id.value;
	var action1=document.forms[0].action.value;
	var rate=document.forms[0].rate.value;
	var total_qty=document.forms[0].total_qty.value;
	var incl_excl=document.forms[0].incl_excl.value;


	
	var service_date=document.forms[0].service_date.value;
	var incl_excl_action=document.forms[0].incl_excl_action.value;

	
	var rate_charge_ind=document.forms[0].charge.value;
	var min_chg_amt=document.forms[0].min_chg_amt.value;
	var revise_qty=document.forms[0].revise_qty.value;
	var str_encounter_id=document.forms[0].encounter_id.value;
	var str_acc_seq_no=document.forms[0].acc_seq_no.value;
	var p_order_id=document.forms[0].p_order_id.value;
	var p_order_line_no=document.forms[0].p_order_line_no.value;
	var str_epi_type_clinic_code=document.forms[0].str_epi_type_clinic_code.value;
	str_epi_type_clinic_code=encodeURIComponent(str_epi_type_clinic_code);

	var panel_qty=document.forms[0].panel_qty.value;
	
var serv_amt_changed = document.forms[0].serv_amt_changed.value;
/**Added by Ram ghl-1.2**/
		var calledfrmencYN=document.forms[0].calledfrmencYN.value;
		var bean_id_bl=document.forms[0].bean_id_bl.value;
		//alert("calledfrmencYN edit" +calledfrmencYN);
		//alert("bean_id_bl edit" +bean_id_bl);
	/**End **********************/	


	var ind="EXCL_INCL_ACT";
	var original_qty=  document.forms[0].original_qty.value;
	parent.frames[1].location.href="../../eBL/jsp/BLEnterEditChargeDetailsValidation.jsp?original_qty="+original_qty+"&blng_serv_code="+blng_serv_code+"&episode_type="+episode_type+"&patient_id="+patient_id+"&visit_id="+visit_id+"&episode_id="+episode_id+"&action1="+action1+"&module_id="+module_id+"&rate="+rate+"&total_qty="+total_qty+"&service_date="+service_date+"&incl_excl_action="+incl_excl_action+"&incl_excl="+incl_excl+"&rate_charge_ind="+rate_charge_ind+"&min_chg_amt="+min_chg_amt+"&ind="+ind+"&revise_qty="+revise_qty+"&encounter_id="+str_encounter_id+"&acc_seq_no="+str_acc_seq_no+"&p_order_id="+p_order_id+"&p_order_line_no="+p_order_line_no+"&str_epi_type_clinic_code="+str_epi_type_clinic_code+"&panel_qty="+panel_qty+"&serv_amt_changed="+serv_amt_changed+"&calledfrmencYN="+calledfrmencYN+"&bean_id_bl="+bean_id_bl;	
}

function modify_validations()
{
	document.forms[0].service.disabled=true;	
	document.forms[0].servicebut.disabled=true;		
	var ratecha=document.forms[0].charge.value;
	if(ratecha=="C")
	{
		document.forms[0].revise_qty.disabled=true;
	}

	if(ratecha=="R")
	{
		document.forms[0].rate.disabled=true;
	}

	//parent.frames[1].location.href='../../eBL/jsp/BLEnterEditChargeDetialsHdr.jsp?action1='+action1;
	var chk_inc_excl=document.forms[0].incl_excl.value;
	if(chk_inc_excl=="Excluded")
	{
		document.forms[0].incl_excl_action.value="I";
	}
	else if(chk_inc_excl=="Included"){
		document.forms[0].incl_excl_action.value="E";	
									}
// Added for OH-CRF-1233 on 08/29/2009
<% if(charge_logic_yn.equals("N")){%>
	if(document.forms[0].preappr_reqd.checked)
	{
		document.forms[0].incl_excl_action.disabled = true;
		document.forms[0].action_reason_desc.disabled = true;
		document.forms[0].reasonbut.disabled = true;
	}
	<%}%>
}
function lis()
{	
	if((document.forms[0].blng_serv_code.value == "" && document.forms[0].service.value == "") && document.forms[0].incl_excl_action.value != "")
	{
		//alert("Billing Service Cannot be Null")
		alert(getMessage('BL9991','BL'));
		document.forms[0].incl_excl_action.value="";
		return false;
	}
	else if((document.forms[0].blng_serv_code.value == "" && document.forms[0].service.value == "") && document.forms[0].incl_excl_action.value == "")
	{
		return false;
	}

	var chk_inc_excl=document.forms[0].incl_excl.value;
	var chk_inc_excl_act=document.forms[0].incl_excl_action.value;
	var override_yn = document.forms[0].override_yn.value;

	if(override_yn != 'B')
	{
		/*if(chk_inc_excl==chk_inc_excl_act)
		{
			document.forms[0].incl_excl_action.value="";
			document.forms[0].action_reason_desc.value="";
			document.forms[0].action_reason_code.value="";
			document.forms[0].action_reason_desc.readOnly=true;
			valexclincl();
		}
		else*/ if(chk_inc_excl_act=="")
		{	
			
			document.forms[0].incl_excl_action.value="";
			document.forms[0].action_reason_desc.value="";
			document.forms[0].action_reason_code.value="";
			document.forms[0].action_reason_desc.readOnly=true;
			document.forms[0].reasonbut.disabled=true;
			valexclincl();
		}
		else
		{
			valexclincl();
			document.forms[0].action_reason_desc.readOnly=false;
			document.forms[0].reasonbut.disabled=false;
			document.forms[0].action_reason_desc.focus();
		}
	}
	else
	{
		if(chk_inc_excl_act=="")
		{	
			document.forms[0].incl_excl_action.value="";
			document.forms[0].action_reason_desc.value="";
			document.forms[0].action_reason_code.value="";
			document.forms[0].action_reason_desc.readOnly=true;
			document.forms[0].reasonbut.disabled=true;
			valexclincl();
		}
		else
		{
			valexclincl();
			document.forms[0].action_reason_desc.readOnly=false;
			document.forms[0].reasonbut.disabled=false;
			document.forms[0].action_reason_desc.focus();
		}
	}

/*	if(chk_inc_excl_act=="I")
	{
      temp="Include";
	}
	else{
		temp="Exclude";
	}
	if(chk_inc_excl=="Include en" || chk_inc_excl=="Exclude en")
	{
	var pos=chk_inc_excl.lastIndexOf('en');
	pos=pos-1;
	var chk_inc_excl=chk_inc_excl.substring(0, pos);
	}

	if(chk_inc_excl==temp)
	{
		document.forms[0].incl_excl_action.value="";
	}
*/

}

function accept_chargedts_val()
{
	var serv_disc=document.forms[0].service.value;
	var serv_amt=document.forms[0].rate.value;
	var serv_rev_qty=document.forms[0].revise_qty.value;
}

function putdeci(object)
{	
	
	if(object.value!='')
	{
		var decimal=document.forms[0].noofdecimal.value;
		putDecimal(object,17,decimal);
	}
}

function pract_id_set()
{
	var practioner_type=document.forms[0].practioner_type.value;
	document.forms[0].practioner.value="";
	if(practioner_type=="Practitioner")
	{
		document.forms[0].pract_id.value="P";
	}
	else if(practioner_type=="OtherStaff")
	{
		document.forms[0].pract_id.value="O";
	}
	else
	{
		document.forms[0].pract_id.value="";
	}

}
function serv_focus()
{

	document.forms[0].service.focus();
}
function ChkNumberInput1(val,e,deci,call_from)
{
	
	//document.forms[0].accept_button.disabled=true;
	//rateval();		
	//document.forms[0].total_pay.value="";
	//document.forms[0].patient_pay.value="";
	if(call_from=='rate')
	{		
		document.forms[0].rate_chk.value='Y';
	}
	if(call_from=='qty')
	{
		document.forms[0].qty_chk.value='Y';	
	}
	//ChkNumberInput(val,evnt,deci);
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';
	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

if(key == "." && val.value.indexOf(key) != -1) return false; // Not more than one '.' char

	
}

function changeAmt()
{
	document.forms[0].serv_amt_changed.value=document.forms[0].rate.value;	
}
</script>

<%
	if(p_action_ind.equals("modify"))
	{
		System.out.println("1300 in BodyEdit.jsp ");
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="enableAllElements_service()" >
<%
	}
	
		else
		{
%>
			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="serv_focus()"  >
<%
		}

%>

<form name='ss' id='ss' ACTION='' method='post' target=''>
<table cellpadding=3 cellspacing=0 border='0' width="100%" align='right'>	
</tr>
	<tr>
	<input type='hidden' name='orig_qty' id='orig_qty' id='orig_qty' value="<%=originalqty%>">
	<td width='25%' class='label' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td> 
	<td width='26%' class="fields"><input type='text' name='service' id='service' size='20'  maxlength='100'  value="<%=service%>" onBlur="if(this.value != ''){ servicelkup(); }"><input type='button' class='button' name="servicebut" id="servicebut" value='?'  onClick='servicelkup();' tabindex='0' ><img src='../../eCommon/images/mandatory.gif'><input type=hidden name='blng_serv_code' id='blng_serv_code' value="<%=blng_serv_code%>" ></td>
	
	<%   
/*rs_dec1.close();
	pstmt1.close();
	System.out.println("]]]]]]]]]]]]]]]]]]---->"+bling_serv_code1);
	
	con	=	ConnectionManager.getConnection(request);
pstmt1 = con.prepareStatement("select nvl(MAX_CHARGE_AMT,0) MAX_CHARGE_AMT from bl_blng_serv where BLNG_SERV_CODE ='"+bling_serv_code1+"'");				
rs_dec1 = pstmt1.executeQuery();	
if ( rs_dec1.next() && rs_dec1 != null ) 
max_chg_amt1  =  rs_dec1.getInt(1);
System.out.println("sumasumasumasumasumasumasuma========>"+max_chg_amt1); */
	%>
	
	<td width='25%' class='label'><fmt:message key="eBL.INCLUDED_EXCLUDED.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='incl_excl' id='incl_excl' size='10'  maxlength='30'  value="<%=incl_excl%>" readonly></td>
	
	
	</tr>
	<tr>
	<td width='25%' class='label'><fmt:message key="eBL.INCLUDED_EXCLUDED_ACTION.label" bundle="${bl_labels}"/></td>
	<!--<td width='25%' class="fields"><input type='text' name='incl_excl_action' id='incl_excl_action' size='10' maxlength='30'  value='<%=incl_excl_action%>'></td>-->
	<td  width='25%' class='fields'>
	   <select name='incl_excl_action' id='incl_excl_action' onChange='lis()'>
<%
   
		if(override_allowed_yn.equals("I"))
		{
%>
		 <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		 <option value="<%=include_label%>" <%=incl_action_flag%>><%=include_label%></option>
<%
		}
		else if(override_allowed_yn.equals("E"))
		{
%>
		 <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		 <option value="<%=exclude_label%>" <%=excl_action_flag%>><%=exclude_label%></option>
<%
		}
		else if(override_allowed_yn.equals("B"))
		{
%>
		 <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		 <option value="<%=include_label%>" <%=incl_action_flag%>><%=include_label%></option>
		 <option value="<%=exclude_label%>" <%=excl_action_flag%>><%=exclude_label%></option>
<%
		}
		else
		{
%>
		 <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
		}
%>
	   </select>
	</td>	
	 <!--  <input type=hidden name='h_incl_excl_ind' id='h_incl_excl_ind' value="" >
	   <input type=hidden name='h_incl_excl_action_ind' id='h_incl_excl_action_ind' value="" >-->
	   
	<td width='25%' class='label' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='action_reason_desc' id='action_reason_desc' size='10'  maxlength='30'  value='<%=reason%>' onBlur='reasonlkup();' readonly ><input type='button' class='button' name="reasonbut" id="reasonbut"  disabled value='?'  tabindex='0' onClick='reasonlkup()'><input type=hidden name='action_reason_code' id='action_reason_code' value="<%=action_reason_code%>"></td>
	
	
	</tr>
	<tr>		
	<td width='25%' class='label'><fmt:message key="eBL.RATE_CHARGE.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='ratecharge_desc' id='ratecharge_desc' size='15' readonly maxlength='5'  value="<%=ratecharge_desc%>" >
	<input type='hidden' name='charge' id='charge' size='10'  maxlength='30'  value="<%=charge%>" ></td>		
	
	<td width='25%' class='label'><fmt:message key="eBL.ORIG_QTY_PER_PANEL.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='original_qty' id='original_qty' size='10'  maxlength='7'  value="<%=original_qty%>" readonly style='text-align:right' onBlur='putdeci(this)'><input type=hidden name='modify_qty_yn' id='modify_qty_yn' value="<%=modify_qty_yn%>" ></td>
	
	
	</tr>
	<tr>
	<td width='25%' class='label'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='uom' id='uom' size='15'  maxlength='30'  value="<%=uom%>" readonly>
	<input type=hidden name='uom_code' id='uom_code' value="<%=uom_code%>" ></td>
	
	<td width='25%' class='label'><fmt:message key="eBL.REVISED_QTY_PER_PANEL.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields">
	<% if("readonly".equals(revise_qty_flag)) {%><!-- Modified V190909-Aravindh/TBMC-SCF-0086/Added if-else for readonly -->
		<input type='text' name='revise_qty' id='revise_qty'  size='10'  maxlength='7'  value="<%=revise_qty%>" style='text-align:right' onKeyPress='return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,"qty")'  onBlur='putdeci(this);' <%=revise_qty_flag%> />
	<% } else { %>
		<input type='text' name='revise_qty'  id='revise_qty' size='10'  maxlength='7'  value="<%=revise_qty%>" style='text-align:right' onKeyPress='return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,"qty")'  onBlur='putdeci(this);revqyt("Y")' <%=revise_qty_flag%> />
	<% } %>
		<img src='../../eCommon/images/mandatory.gif' />
	</td>
	
	
	</tr>
	<tr>
	<td width='25%' class='label'><fmt:message key="eBL.TOTAL_QTY.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='total_qty' id='total_qty' size='10'  maxlength='7'  value="<%=total_qty%>" readonly style='text-align:right' onFocus='putdeci(this)'></td>
	
	<td width='25%' class='label'><fmt:message key="eBL.RATE.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='rate' id='rate' size='14'  maxlength='10' style='text-align:right' value="<%=rate%>" onKeyPress='return ChkNumberInput1(this,event,document.forms[0].noofdecimal.value,"rate");' onchange= 'changeAmt()' onBlur='putdeci(this);rateval("","<%=max_chg_amt%>");' <%=rate_flag%>><img src='../../eCommon/images/mandatory.gif'></td>
	
	
	
	</tr>
	<tr>
	<td width='25%' class='label'><fmt:message key="eBL.PRACT_STAFF_TYPE.label" bundle="${bl_labels}"/></td>
	<td  width='25%' class='fields' >
	<%
	if(p_action_ind.equals("add")|| p_action_ind.equals("modify"))
	{
				System.out.println("1408 in BodyEdit.jsp ");
		String pract_select="";
		String other_select="";
		if(pract_id.equals("P"))
		{
			pract_select="SELECTED";
		}
		else if(pract_id.equals("O"))
		{
			other_select="SELECTED";
		}
	%>
		   <select name='practioner_type' id='practioner_type' onChange='PractStaffInd();practstaffvalidations();pract_id_set();' >
		   <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		   <option value='Practitioner' <%=pract_select%>><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
		   <option value='OtherStaff' <%=other_select%>><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
		   </select><input type=hidden name='pract_id' id='pract_id' value='<%=pract_id%>' >
	<%
	}	
	else if( p_action_ind.equals("remove"))
	{
				System.out.println("1429 in BodyEdit.jsp ");
		if(pract_id.equals("P"))
		{
%>
		 <select name='practioner_type' id='practioner_type' >
		  <option value='Practitioner' selected><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
		 <input type=hidden name='pract_id' id='pract_id' value="<%=pract_id%>" >
<%
		}
		else if(pract_id.equals("O"))
		{
%>
		 <select name='practioner_type' id='practioner_type' >
		  <option value='OtherStaff' selected><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option>
		  <input type=hidden name='pract_id' id='pract_id' value="<%=pract_id%>" >
		
<%
		}
		else
		{
%>
			<select name='practioner_type' id='practioner_type' onChange="pract_id_set()">
		    <option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
	 	    <option value='Practitioner'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
		    <option value='OtherStaff'><fmt:message key="Common.OtherStaff.label" bundle="${common_labels}"/></option></select>
			<input type=hidden name='pract_id' id='pract_id' value="<%=pract_id%>" >
<%		}
	}
%>
	</td>
			
	<td width='25%' class='label'><fmt:message key="eBL.PRACTITIONER_STAFF.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='practioner' id='practioner' size='10'  maxlength='100'  value="<%=practioner%>" onBlur="funQry('B')"><input type='button' class='button' name="practstaffbut" id="practstaffbut" value='?'  tabindex='0' onClick="funQry('C')" ><input type=hidden name='pract_staff_id' id='pract_staff_id' value="<%=pract_staff_id%>" ></td>
	
	
	</tr>
	<tr>
	<td width='25%' class='label'><fmt:message key="eBL.TOTAL_PAYABLE.label" bundle="${bl_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='total_pay' id='total_pay' size='14'  maxlength='30'  value="<%=total_pay%>" style='text-align:right' readonly></td>
	
	<td width='25%' class='label'><fmt:message key="Common.PatientPayable.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type='text' name='patient_pay' id='patient_pay' size='14'  maxlength='30'  value="<%=patient_pay%>" readonly style='text-align:right'></td>
	
	
	</tr>
	<tr>	
	<td class='label' width='25%'><fmt:message key="Common.PatientPaid.label" bundle="${common_labels}"/></td>
	<td class='label' width='25%'><input type='text' name='patient_paid' id='patient_paid' size='14'  maxlength='30'  value="<%=patient_paid%>" style='text-align:right' readonly></td>
	
	<td width='25%' class='label'><fmt:message key="eBL.PREAPPR_REQD.label" bundle="${bl_labels}"/></td>	
	<td width='25%' class="fields"><input type='checkbox' name='preappr_reqd' id='preappr_reqd' size='10'  maxlength='30' <%=preappr_reqd%> value="<%=preappr_reqd%>" disabled ></td>
	
		
	<input type='hidden' name='charged_yn' id='charged_yn' value="<%=p_charged_yn%>">
	<input type='hidden' name="excl_incl_ind_for_screen" id="excl_incl_ind_for_screen" value="">

		
	</tr>
	<tr>

	<!--<td width="25%"  class="label">Net Amount</td>
	<td class='label' width='25%'><input type='text' name='net_amount' id='net_amount' size='10'  maxlength='30'  value="<%=patient_paid%>" style='text-align:right' readonly></td>
	<input type='hidden' name='actual_amt_val' id='actual_amt_val' value="">-->
	<%
	if(p_action_ind.equals("add"))
	{
				System.out.println("1494 in BodyEdit.jsp ");
%> 	
	<td width="25%"  class="label">&nbsp;</td>
	<td width="25%"  class="label">&nbsp;</td>
	
	<!-- The Below Button is for Add Functionality -->
	<td width="25%"  class="fields"><input type='button'  name="accept_button" id="accept_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" class='button' onclick='acceptchargedet()'></td>
	<td width="25%"  class="fields"><input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" class='button' onClick='cancel()'></td>
	
	
	<!-- 	-->
<%
	}
	else
	{
%>
	<!--<td  class="fields"><input type='button' class='button' 			onclick='enableAllElements_service();modify_validations()' name="modify_button" id="modify_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modify.label","common_labels")%>" ></td>
	<td  class="fields"><input type='button' class='button' onclick='enableAllElements_service_remove();remove_payer()' name="remove_button" id="remove_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Remove.label","common_labels")%>" ></td>-->

	<td width="25%"  class="label">&nbsp;</td>
	<td width="25%"  class="label">&nbsp;</td>

	<!-- The Below Button is for Add Functionality -->
	<td width="25%"  class="fields"><input type='button' class='button' onclick='acceptchargedet()' name="accept_button" id="accept_button"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Accept.label","common_labels")%>" ></td>
	<td width="25%"  class="fields"><input type='button' class='button' onclick='cancel()'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" ></td>
		
	<!-- 	-->
	<%
	}
%>
	</tr>	
</table>
<input type="hidden" name='serv_amt_changed' id='serv_amt_changed' value="<%=serv_amt_changed%>">
		<input type= hidden name="locale" id="locale"  value="<%=locale%>">
		<input type= hidden name="facility_id" id="facility_id"  value="<%=p_facility_id %>">		
		<input type= 'hidden' name='action' id='action'  value="<%=p_action_ind%>">		
		<input type= 'hidden' name='blng_serv_code1' id='blng_serv_code1'  value=''>
		<input type= hidden name="h_episode_type" id="h_episode_type"  value="<%=p_episode_type%>">
		<input type= hidden name="h_patient_id" id="h_patient_id"  value="<%=p_patient_id%>">
		<input type= hidden name="h_visit_id" id="h_visit_id"  value="<%=p_visit_id%>">
		<input type= hidden name="h_episode_id" id="h_episode_id"  value="<%=p_episode_id%>">
		<input type= hidden name="h_module_id" id="h_module_id"  value="<%=p_module_id%>">
		<input type= hidden name="str_excl_incl_ind" id="str_excl_incl_ind"  value=''>
		<input type= hidden name="added_serv_yn" id="added_serv_yn"  value="<%=stradded_serv_yn%>">
		<input type= hidden name="service_panel_ind" id="service_panel_ind"  value='S'>
		<input type= hidden name="min_chg_amt" id="min_chg_amt"  value=''>
		<input type= hidden name="desc_amt" id="desc_amt"  value=''>
		<input type= hidden name="preapp_yn" id="preapp_yn"  value=''>
		<input type= hidden name="override_yn" id="override_yn"  value="<%=override_allowed_yn%>">
		<input type= hidden name="service_date" id="service_date"  value="<%=p_service_date%>">
		<input type='hidden' name='noofdecimal' id='noofdecimal' value="<%=noofdecimal%>" >
		<input type='hidden' name='charge_flag' id='charge_flag' value="<%=charge%>" >
		<input type='hidden' name='encounter_id' id='encounter_id' value="<%=str_encounter_id%>" >
		<input type='hidden' name='acc_seq_no' id='acc_seq_no' value="<%=str_acct_seq_no%>" >
		<input type='hidden' name='p_order_id' id='p_order_id' value="<%=p_order_id%>" >
		<input type='hidden' name='p_order_line_no' id='p_order_line_no' value="<%=p_order_line_no%>" >
		<input type='hidden' name="service_panel_ind1" id="service_panel_ind1"  value="<%=p_service_panel_ind%>">
		<input type='hidden' name="str_epi_type_clinic_code" id="str_epi_type_clinic_code"  value="<%=str_epi_type_clinic_code%>">
		<input type= 'hidden' name="rate_chk" id="rate_chk"  value=''>
		<input type= 'hidden' name="qty_chk" id="qty_chk"  value=''>
		<input type= 'hidden' name="rate_chk_close" id="rate_chk_close"  value=''>
		<input type= 'hidden' name="panel_qty" id="panel_qty"  value='<%=panel_qty%>'>
		<input type= 'hidden' name="dirIndirChrgsFlag" id="dirIndirChrgsFlag"  value='<%=dirIndirChrgsFlag%>'>

		<input type='hidden' name='bean_id_bl' id='bean_id_bl' value="<%=bean_id_bl%>" >
		<input type='hidden' name='calledfrmencYN' id='calledfrmencYN' value="<%=calledfrmencYN%>" >
	<!-- Modified By muthukumar on 31-1-12 against SKR-SCF-0320 -->
		<input type='hidden' name='max_chg_amt' id='max_chg_amt' value='<%=max_chg_amt%>'>
		<input type='hidden' name='max_chg_amt1' id='max_chg_amt1' value=''>
	<!-- Modified By muthukumar on 31-1-12 against SKR-SCF-0320 -->
		

</form>
</body>
</html>

