<!DOCTYPE html>
<%@ page import="java.sql.*, webbeans.eCommon.*, java.io.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@page import="eBL.BLReportIdMapper"%> 
<%@page import="eBL.BLCashSlmtRestriction"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	CallableStatement call = null;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	String site3TierAlmoFeatureYN = "";
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	String str_error_code="", str_error_text="";
	String str_deposit_alert_yn="",str_deposit_exists_YN="";
	//String str_deposit_alert_yn=request.getParameter("dep_alert");
	//String str_deposit_exists_YN=request.getParameter("dep_exist");
	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");
	String params = request.getQueryString();
	//System.out.println("params AdhocDiscBtn.jsp:"+params);

	//Added By Muthukumar on 30-1-12 for GAP -09
	String dep_adjust_yn  = "Y";
	//Added By Muthukumar on 30-1-12 for GAP -09			

	String str_facility_id = (String) session.getValue("facility_id");
	//System.err.println("str_facility_id in Button Page --> " +str_facility_id);

	String	strloggeduser	=  (String) session.getValue("login_user");	
	if (strloggeduser==null) strloggeduser = "";

	String p_patient_id = request.getParameter("patient_id");	
	if(p_patient_id==null) p_patient_id="";	
	//System.err.println("p_patient_id in Button Page --> " +p_patient_id);

	String episode_type = request.getParameter("episode_type");	
	if(episode_type==null) episode_type="";	
	//System.err.println("episode_type in Button Page --> " +episode_type);
	
	String episode_id = request.getParameter("episode_id");	
	if(episode_id==null) episode_id="";	
	//System.err.println("episode_id in Button Page --> " +episode_id);

	String visit_id = request.getParameter("visit_id");	
	if(visit_id==null) visit_id="";	
	//System.err.println("visit_id in Button Page --> " +visit_id);

	String strclientip = p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
	//System.err.println("strclientip "+strclientip);

	String p_billgenlater = request.getParameter("billgenlater");	
	if(p_billgenlater==null) p_billgenlater="";	

	String p_gross_amt = request.getParameter("gross_amt");	
	if(p_gross_amt==null) p_gross_amt="";	

	String p_disc_amt = request.getParameter("disc_amt");	
	if(p_disc_amt==null) p_disc_amt="";	

	String p_net_amt = request.getParameter("net_amt");	
	if(p_net_amt==null) p_net_amt="";

	String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
	if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";
	
	String bl_items_sl_no = request.getParameter("bl_items_sl_no");
	if(bl_items_sl_no==null) bl_items_sl_no="";
	
	//added by sarath making sitespecific CRF KDAH339.2
	BLCashSlmtRestriction billRestr = new BLCashSlmtRestriction();
	String restrictEligibility = billRestr.checkCashRestrictionEligibility(str_facility_id);
	System.out.println("restrictEligibility -- >"+restrictEligibility);
	

//Newly Added
try{
	//System.err.println("Entering into BL_CHECK_DEPOSIT_EXISTS 1");

	con	=	ConnectionManager.getConnection(request);
	//Added V200228 SHIKHA against AAKH-CRF-0112				
	try {
		site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","3TIERALMOFEATURE");
		if (site3TierAlmoFeature) {
			site3TierAlmoFeatureYN = "Y";
		}else {
			site3TierAlmoFeatureYN = "N";
		}
	} catch(Exception ex) {
		System.err.println("Error in BLAdhocDiscBtn.jsp for getting site3TierAlmoFeature Connection: "+ex);
		ex.printStackTrace();
	}
	//Added V200228 SHIKHA against AAKH-CRF-0112
	call = con.prepareCall("call BL_CHECK_DEPOSIT_EXISTS(?,?,?,?,?,?,?,?,?)");

	//call = con.prepareCall("call BL_CHECK_DEPOSIT_EXISTS ('"+str_facility_id+"','"+p_patient_id+"','"+episode_type+"','"+episode_id+"','"+visit_id+"',?,?,?,?)");

				call.setString(1,str_facility_id);
				call.setString(2,p_patient_id);
				call.setString(3,episode_type);
				call.setString(4,episode_id);
				call.setString(5,visit_id);
				
				call.registerOutParameter(6,java.sql.Types.VARCHAR);	
				call.registerOutParameter(7,java.sql.Types.VARCHAR);	
				call.registerOutParameter(8,java.sql.Types.VARCHAR);
				call.registerOutParameter(9,java.sql.Types.VARCHAR);

				//System.err.println("Before BL_CHECK_DEPOSIT_EXISTS ");

				call.execute();

				//System.err.println("After BL_CHECK_DEPOSIT_EXISTS ");

				str_deposit_alert_yn = call.getString(6);
				if(str_deposit_alert_yn==null) str_deposit_alert_yn="";

				str_deposit_exists_YN = call.getString(7);
				if(str_deposit_exists_YN==null) str_deposit_exists_YN="";
				
				str_error_code = call.getString(8);
	     		if(str_error_code==null) str_error_code="";

				str_error_text = call.getString(9);
				if(str_error_text==null) str_error_text="";
												
				call.close();
				
	//System.err.println("str_facility_id --> " +str_facility_id);
	//System.err.println("p_patient_id --> " +p_patient_id);
	//System.err.println("episode_type --> " +episode_type);
	//System.err.println("episode_id --> " +episode_id);
	//System.err.println("visit_id --> " +visit_id);
	//System.err.println("str_deposit_alert_yn --> " +str_deposit_alert_yn);
	//System.err.println("str_deposit_exists_YN --> " +str_deposit_exists_YN);
	//System.err.println("str_error_code --> " +str_error_code);
	//System.err.println("str_error_text --> " +str_error_text);
		}catch(Exception ec)
		{
			  System.out.println("Get the BL_CHECK_DEPOSIT_EXISTS Values " +ec);
		}	
		finally 
		{
			if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
			}

	//System.err.println("str_deposit_alert_yn" +str_deposit_alert_yn);
	//System.err.println("str_deposit_exists_YN" +str_deposit_exists_YN);	
	//System.err.println("End BL_CHECK_DEPOSIT_EXISTS ");
%>
<html>
	<head>	
<% 
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




	</head>
<%
		/*try{
			
				CallableStatement  call = 
						con.prepareCall("{ ? = call  blcore.Check_Service_discount(?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'))}");	
						call.registerOutParameter(1,java.sql.Types.VARCHAR);
						call.setString(2,str_facility_id);
						call.setString(3,blng_serv_code);
						call.setString(4,strloggeduser);
						call.setString(5,currdate);
						call.execute();				
						discount_allowed_yn = call.getString(1);		
						 if(discount_allowed_yn==null) discount_allowed_yn="";
						call.close();	
						System.out.println("discount_allowed_yn :"+discount_allowed_yn); 
			}catch(Exception ul)
			{
				System.out.println("Exception in user validation : "+ul);
			}
			finally 
			{
				if(con!=null)
				{
					ConnectionManager.returnConnection(con, request);
				}
			}*/
%>
<script>
	function apply()
	{	
		parent.frames[1].document.forms[0].called_butt.value="SUBMIT_BUTTON";

		if(parent.frames[1].document.forms[0].checked_services.value=="")
		{
			alert("Select Atleast one record");
			return;
		}

	/*	parent.frames[1].document.forms[0].target='submit_frame';
		parent.frames[1].document.forms[0].action="../../servlet/eBL.BLAdhocDiscServlet";
		parent.frames[1].document.forms[0].submit();*/

		parent.frames[1].document.forms[0].target='submit_frame';
		parent.frames[1].document.forms[0].action="../../eBL/jsp/BLAdhocDiscSubmit.jsp";
		parent.frames[1].document.forms[0].submit();
	}

	function cancel()
	{
		document.AdhocBtnForm.cancel_button.disabled = true;
		var called_frm = parent.frames[1].document.forms[0].called_frm.value;
		var called_module_id = parent.frames[1].document.forms[0].module_id.value;
		var dep_exist = document.forms[0].dep_exist.value;
		var dep_alert = document.forms[0].dep_alert.value;
		var dep_adjust_yn =null;	
		//var dep_adjust_yn ="N";	
		//	Added by Karthik for site Id Verification GHL-SCF-1036
		var siteId=document.AdhocBtnForm.siteId.value;
		//added by sarath making sitespecific CRF KDAH339.2 
		var restrictEligibility = document.forms[0].restrictEligibility.value;
		var site3TierAlmoFeatureYN = document.forms[0].site3TierAlmoFeatureYN.value; //Added V200228 SHIKHA against AAKH-CRF-0112
		if(called_frm == 'OTH_MOD')				
		{				
			//if(called_module_id != 'OR' || siteId=='AMS'  || siteId=='ALMO' || siteId=='MC' ){ //Added By Muthukumar on 08-06-12 for OR Module Change
			if(called_module_id != 'OR' || siteId=='AMS'  || siteId=='ALMO' || siteId=='MC' ||site3TierAlmoFeatureYN =='Y'){ //Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1  //Added By Muthukumar on 08-06-12 for OR Module Change 
				if(dep_alert == "Y")
				 {
					if(dep_exist == "Y")
						{
						var dep_yn;
						if(restrictEligibility == "Y"){
							dep_yn = confirm(getMessage('BL0707','BL'));
						}
						else{
							dep_yn = confirm(getMessage('BL9123','BL'))
						}
					
				if(dep_yn == true)
					dep_adjust_yn="Y";
				else
					dep_adjust_yn="N";
				}
				else
					 {
						dep_adjust_yn = "N";
					 }
				 }
				 else{
						dep_adjust_yn = "Y";
					 }

		}//Added By Muthukumar on 08-06-12 for OR Module Change// 29-06-12
		
		var bl_items_sl_no  =document.forms[0].bl_items_sl_no.value;
	parent.frames[1].document.forms[0].called_butt.value="CLOSE_BUTTON";			
	parent.frames[1].document.forms[0].target='submit_frame';
	parent.frames[1].document.forms[0].method='post';
	parent.frames[1].document.forms[0].action="../../eBL/jsp/BLAdhocDiscSubmit.jsp?dep_adjust_yn="+dep_adjust_yn+"&bl_items_sl_no="+bl_items_sl_no;
	parent.frames[1].document.forms[0].submit();
		}		
		else
		{
			window.close();
		}
	}

	async function log_in_cash_counter()
	{
		var retVal;
		var dialogHeight= "50";
		var dialogWidth	= "70";
		var dialogTop = "100" ;
		var center = "1" ;														   
		var status="no";
		var cash_counter_leg = getLabel("eBL.CASH_COUNTER_LOGIN.label","BL");
		cash_counter_leg = encodeURIComponent(cash_counter_leg);
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLLogInMain.jsp?called_frm=DISC_FUN";
		retVal =await window.showModalDialog(url,arguments,features);
		if(retVal==null) retVal="";

		if(retVal == "SUCCESS")
		{
			document.getElementById("cash_counter_log_in_disp").style.display="none";
			document.getElementById("cash_counter_log_out_disp").style.display="none";
		}
	}

	async function log_out_cash_counter()
	{
		var retVal;
		var dialogHeight= "50";
		var dialogWidth	= "70";
		var dialogTop = "100" ;
		var center = "1" ;														   
		var status="no";
		var cash_counter_leg = getLabel("eBL.CASH_COUNTER_LOGOUT.label","BL");
		cash_counter_leg = encodeURIComponent(cash_counter_leg);
		var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; scroll: yes " + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
		var arguments	= "" ;
		var url = "../../eBL/jsp/BLLogoutMain.jsp?called_frm=DISC_FUN";
		retVal =await window.showModalDialog(url,arguments,features);
		if(retVal==null) retVal="";
		
		if(retVal == "SUCCESS")
		{
			document.getElementById("cash_counter_log_out_disp").style.display="none";
			document.getElementById("cash_counter_log_in_disp").style.display="inline";
		}
	}
</script>
<body onLoad="" onKeyDown= "lockKey();" onMouseDown="CodeArrest();"   onSelect="codeArrestThruSelect();">
<form name='AdhocBtnForm' id='AdhocBtnForm' method='post' action=''   >	
	<table cellpadding='3' cellspacing='0' width='100%'>	
		<tr>
		<!--
			<td class="label" width="24%">&nbsp;</td>
			<td class="label" width="16%">&nbsp;</td>
			<td class="label" width="18%">&nbsp;</td>
			<td class="label" width="16%"><div align="right"><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></div></td>
			<td width='7%' class="fields">
			<div align="right"><input type='text' name='tot_gross_amt' id='tot_gross_amt' size='4' maxlength='30' value='<%=p_gross_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='7%' class="fields">
			<div align="right"><input type='text' name='tot_disc_amt' id='tot_disc_amt' size='4'  maxlength='30' value='<%=p_disc_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='7%' class="fields">
			<div align="right"><input type='text' name='tot_net_amt' id='tot_net_amt' size='4'  maxlength='30' value='<%=p_net_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='5%' class='label'>&nbsp;</td>
-->

			<td class="label" width="14%">&nbsp;</td>
			<td class="label" width="14%">&nbsp;</td>
			<td class="label" width="14%">&nbsp;</td>
			<td class="label" width="14%"><div align="right"><b><fmt:message key="Common.total.label" bundle="${common_labels}"/></b></div></td>
			<td width='9%' class="fields">
			<div align="right"><input type='text' name='tot_gross_amt' id='tot_gross_amt' size='4' maxlength='30' value='<%=p_gross_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='9%' class="fields">
			<div align="right"><input type='text' name='tot_disc_amt' id='tot_disc_amt' size='4'  maxlength='30' value='<%=p_disc_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='9%' class="fields">
			<div align="right"><input type='text' name='tot_net_amt' id='tot_net_amt' size='4'  maxlength='30' value='<%=p_net_amt%>' readonly style='text-align:right'></div>
			</td>
			<td width='9%' class='label'>&nbsp;</td>
			<td width='8%' class='label'>&nbsp;</td>
		</tr>
	</table>
	<table  cellpadding='3' cellspacing='0' width='100%'>	
		<tr>
			<td class="label" width="25%">&nbsp;</td>
			<td width="25%"  class='labels' align='right'>
				<div id='cash_counter_log_in_disp' style='display:none' >
					<input type='button'  name="log_in_cash_counter_btn" id="log_in_cash_counter_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CASH_COUNTER_LOGIN.label","bl_labels")%>" class='button' onClick='log_in_cash_counter()'>
				</div>
			</td>
			<td width="25%"  class='labels' align='right'>
				<div id='cash_counter_log_out_disp' style='display:none'>
					<input type='button'  name="log_out_cash_counter_btn" id="log_out_cash_counter_btn" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.CASH_COUNTER_LOGOUT.label","bl_labels")%>" class='button' onClick='log_out_cash_counter()'>
				</div>
			</td>
			<td width="25%"  class='labels' align='right'>
				<div >
					<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class='button' onClick='cancel()'>
				</div>
			</td>
		</tr>         
	</table> 
	<input type= 'hidden' name="billgenlater" id="billgenlater"  value='<%=p_billgenlater%>'>
	<input type= 'hidden' name="slmt_reqd_yn" id="slmt_reqd_yn"  value='<%=p_slmt_reqd_yn%>'>

	<!--Added By Muthukumar on 30-1-12 for GAP -09 -->
	<input type="hidden" name="dep_adjust_yn" id="dep_adjust_yn" value="<%=dep_adjust_yn%>">
	<input type="hidden" name="dep_alert" id="dep_alert" value="<%=str_deposit_alert_yn%>">
	<input type="hidden" name="dep_exist" id="dep_exist" value="<%=str_deposit_exists_YN%>">

	<input type="hidden" name="bl_items_sl_no" id="bl_items_sl_no" value="<%=bl_items_sl_no%>">
	<!-- 	Added by Karthik for site Id Verification -->
	<% String siteId = BLReportIdMapper.getCustomerId(); %>
	<input type='hidden' name='siteId' id='siteId' id ='siteId' value='<%=siteId %>' />
	<!-- added by sarath making sitespecific CRF KDAH339.2 -->
	<input type='hidden' name='restrictEligibility' id='restrictEligibility' id ='restrictEligibility' value='<%=restrictEligibility %>' />
	<input type='hidden' name='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' id='site3TierAlmoFeatureYN' value='<%=site3TierAlmoFeatureYN %>'>
	<!--Added By Muthukumar on 30-1-12 for GAP -09 -->
	
</form>	 
</body>
</html>

