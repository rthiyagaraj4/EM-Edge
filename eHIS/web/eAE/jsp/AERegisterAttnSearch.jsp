<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
     <script language='javascript' src='../../eAE/js/AERegisterAttn.js'></script>
	<Script src="../../eMP/js/SmartCard.js" language="JavaScript"></Script>
	<!-- Added by Ashwin K for AAKH-CRF-0150-->
	<!--<Script src="../../eMP/js/SmartCard01.js" language="JavaScript"></Script>-->
		<%
	
		if(session.getValue("smart_path")!= null) {
			if(!session.getValue("smart_path").equals(" ")){
				out.println(session.getValue("smart_path"));
			}
		}
		%>


	<Script src="../../eMP/js/json02.js"></Script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>

 <!-- Added By Ashwin K for AAKH-CRF-0150 -->
   
<link href="../../eCommon/html/jquery-ui.css" rel="stylesheet" type="text/css">
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->
<script> 
	<!-- Added By Ashwin K for AAKH-CRF-0150 -->
		$(document).ready(function(){
	$("#M_btn1").prop('disabled', false); 
	$("#National_Id_No").prop('disabled', true);
	$("#EmiratesID_edit").click(function() {
	if($('#EmiratesID_edit').is(':checked'))
		{
		var auth_userEmirates = EditEmiratesID_authScr();
		if(auth_userEmirates == true)
			{
			$("#National_Id_No").prop('disabled', false);
			$("#M_btn1").prop('disabled', true); 
			}
	else
	 {
		$('#EmiratesID_edit').prop('checked', false);
	 }
 }
 else
	{
		$("#National_Id_No").prop('disabled', true);
		$("#M_btn1").prop('disabled', false); 
	}
        });
	});
async function EditEmiratesID_authScr()
{	
	var retVal=new Array();
	var dialogHeight= "10vh" ;
	var dialogWidth	= "22vw" ;
	var dialogTop = "225" ;
	var center = "1" ;														   
	var status="no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
	var arguments	= "" ;
	retVal = await window.showModalDialog("../../eSM/jsp/AuthorizeMain.jsp?mode=s",arguments,features);
	return retVal;
}
<!-- Ended By Ashwin K for AAKH-CRF-0150 -->
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		
		function regAttForNB(){
			if(document.forms[0].invoke_from.value=='EMER_REGN_NB' && document.forms[0].nb_patient_id.value!=""){
				document.forms[0].frameRef.value="parent.parent";
				document.forms[0].patient_id.value=document.forms[0].nb_patient_id.value;
				document.forms[0].patient_id.onblur();
				document.forms[0].patient_id.disabled=true;
				parent.parent.frames[0].document.getElementById("home").disabled = true;
				parent.parent.frames[0].document.getElementById("reset").disabled = true;
				document.forms[0].clear.disabled = true;
			}
		}
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
	
	</script>
	<%
	if(session.getValue("sekure_ws_yn")!= null) {
		if(session.getValue("sekure_ws_yn").equals("Y")){
			out.println("<script src='http://localhost:9996/api/files/Sekure.js'></script>\n"+
						"<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n"
						);
		}
	}
	%>      
	
<%-- 	<%
    String sekureWsYn = (String) session.getAttribute("sekure_ws_yn");
    if ("Y".equals(sekureWsYn)) {
%>
        <script src="http://localhost:9996/api/files/Sekure.js"></script>
        <script src="../../eCommon/js/showModalDialog.js" type="text/javascript"></script>
<%
    }
%> --%>
	
</head>
<% 
        Connection con               = null;
    	PreparedStatement pstmt		 = null;
        ResultSet rset               = null ;
		java.sql.Statement stmt		 = null;
		String Smartcard_path="" ; //added for smart card 
		String function_name="" ; //added for Alkhalej smart card 

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		String facilityId			 = (String)session.getValue("facility_id");
		String bl_install_yn         = (String)session.getValue("bl_operational");
		bl_install_yn				 = (bl_install_yn==null)?"N":bl_install_yn;
		String patient_id_length	 = "";
		String ext_system_interface_yn	 = "";
		String nat_id_length	 = "";
		String nat_id_prompt	 = "";
		String accept_national_id_no_yn	 = "";
		String oper_stn_id			 = request.getParameter("oper_stn_id");
		oper_stn_id					 = (oper_stn_id==null)?"":oper_stn_id;
		oper_stn_id					 = (oper_stn_id==null)?"":oper_stn_id;
		String user_id 			 	 = (String)session.getValue("login_user") ;
		user_id					 = (user_id==null)?"":user_id;
		String params				= request.getQueryString() ;
		String register_pat_yn="N";
		String reg_attendance_for_inpat_yn= request.getParameter("attendance_for_inpat_yn");
		reg_attendance_for_inpat_yn					 = (reg_attendance_for_inpat_yn==null)?"N":reg_attendance_for_inpat_yn;
		// below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272]
		String max_hrs_for_re_attend=request.getParameter("max_hrs_for_re_attend");
		max_hrs_for_re_attend					 = (max_hrs_for_re_attend==null)?"N":max_hrs_for_re_attend;
		//end CRF  Bru-HIMS-CRF-152 [IN030272]
		
		String p_alt_id2_type = "" , p_alt_id3_type = "", p_alt_id4_type = "";
		String entitlement_by_cat_yn = "";
		String biometric_authentication_yn="N";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start*/
		String nb_patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String invoke_from			= request.getParameter("invoke_from") == null ? "" : request.getParameter("invoke_from");
		/*Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End*/
		
		String dflt_emer_follow_type_code = request.getParameter("dflt_emer_follow_type_code"); // added by mujafar for KDAH-CRF-0526
		String  dflt_time_reg_auto_update = request.getParameter("dflt_time_reg_auto_update");// added by mujafar for KDAH-CRF-0526

		int v_cnt=0;
		try{
					con                  = ConnectionManager.getConnection(request);
					Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(con, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
				    StringBuffer patLength = new StringBuffer();
				//  VENKAT S PE_EXE (ae_regn_attn function)
					patLength.append(" select patient_id_length, ext_system_interface_yn, nat_id_length, NVL (nat_id_prompt, 'National ID No') nat_id_prompt,alt_id1_type, alt_id2_type, alt_id3_type, alt_id4_type, entitlement_by_pat_cat_yn, accept_national_id_no_yn,biometric_authentication_yn from MP_PARAM  where MODULE_ID='MP' ");
					pstmt   = con.prepareStatement(patLength.toString());
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next())
					{   
						patient_id_length = rset.getString("patient_id_length");
						ext_system_interface_yn = rset.getString("ext_system_interface_yn");
						nat_id_length = rset.getString("Nat_Id_Length");
						nat_id_prompt = rset.getString("Nat_Id_Prompt");
						accept_national_id_no_yn = rset.getString("accept_national_id_no_yn");	
						p_alt_id2_type = rset.getString("alt_id2_type");	
						p_alt_id3_type = rset.getString("alt_id3_type");	
						p_alt_id4_type = rset.getString("alt_id4_type");	
						entitlement_by_cat_yn = rset.getString("entitlement_by_pat_cat_yn");	
						biometric_authentication_yn=rset.getString("biometric_authentication_yn");	//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
						
					} 
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					if((patLength != null) && (patLength.length() > 0))
					 {
						patLength.delete(0,patLength.length());
					 }

				  stmt	= con.createStatement();	
				  rset	= stmt.executeQuery("Select count(*) v_cnt FROM AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+facilityId+"' and oper_stn_id ='"+oper_stn_id+"' and REGISTER_PAT_YN = 'Y' AND APPL_USER_ID = '"+user_id+"'") ;
                  rset.next();
				  v_cnt=rset.getInt(1);

				   if(v_cnt>0){
                     register_pat_yn	 = "Y";
				   }
				   //for smart card
			pstmt = con.prepareStatement("select VALUE_1,nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
			rset = pstmt.executeQuery();	 
			if(rset!=null && rset.next())
			{
			Smartcard_path=rset.getString("VALUE_1");
			function_name=rset.getString("VALUE_2");   // alkhaleej smart card
			}		
			if(pstmt!=null)
			pstmt.close();
			if(rset!=null)
			rset.close();
			//for smart card
				   
%>
	 <!--Added by Ashwin K for AAKH-CRF-0150 -->
	 <script>
	function MButton_click_AEReg()
		{
		var res = RegAttnSearch_ReadDF1_onclick(<%=function_name%>);
		var arr = res.split("!~");
		var res_natid = arr[0].replace(/^\s+|\s+$/gm,'');
		var res_mobno = arr[1].replace(/^\s+|\s+$/gm,'');
		var patcnt = 0;
		var p_id = "";
		//var res = "";
		$.ajax({
			type: "POST",
			url: "../../eMP/jsp/getPatientCount.jsp",
			data: {
				NatID : res_natid,
				smart_data : res	

			},
			async: false
		})
		.done (function(data, textStatus, jqXHR) { 
		  res = data;
var res1 = res.substring(res.indexOf("<patcnt>")+8,res.indexOf("</patcnt>"));
var res2 = res.substring(res.indexOf("<patid>")+7,res.indexOf("</patid>"));
patcnt = parseInt(res1);
p_id = res2;  
});
if(patcnt == 0)
{
	alert(getMessage('MOBILE_NO_SEARCH','MP'));
	callPatientSearch_MBtn(res_mobno);

}
else
{
	document.getElementById("patient_id").value= p_id;
	searchPatient(p_id);
}
}
</script>
	 <!-- Ended by Ashwin K for AAKH-CRF-0150 -->
	 <body OnMouseDown='CodeArrest()' onLoad='setFocus();disReset();regAttForNB();' onKeyDown = 'lockKey()'>
	 <form name="ae_patient_form" id="ae_patient_form">
	   <table border="0" cellpadding="2" cellspacing="0" align='center' width='100%'>
	     <tr>
		    <td class='label' width='18%'><fmt:message key="Common.detailsunknown.label" bundle="${common_labels}"/>&nbsp;&nbsp;<span class='field'><input type="checkbox" name='eReg' id='eReg' onClick="eRegistration()"></span></td>
		    <td class='LABEL'  width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;<span class='field'><input type='text'  name=patient_id id=patient_id value="" maxLength='<%=patient_id_length%>' size='20' onKeyPress="return(CheckForSpecChars(event))" 
			onBlur="changeCase(this);disReset();searchPatient(document.forms[0].patient_id)">&nbsp;<input type="button" name="patient_search" id="patient_search" class=BUTTON value="?" onChange='disReset();' onClick="if(document.forms[0].patient_id.value==''){callPatientSearch()}" ></span>	
                <%
				boolean isSiteSpe_change_pat_dtls= CommonBean.isSiteSpecific(con, "OP","INVOKE_CHANGE_PATIENT_DETIALS"); 
				int userFunRightsCount	= 0;//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
				if(isSiteSpe_change_pat_dtls)
				{
					userFunRightsCount	= CommonBean.getUserFunRightsCount(con,user_id,"CHG_PAT_DTLS","MP");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
					if(userFunRightsCount > 0) {
					%> <!--Below line modified for this CRF MMS-QH-CRF-0162.1-->
						  <img  align='center'  style="visibility:hidden"  id="Update_pat" Title="Change Patient Details" src='../../eCommon/images/update.jpg' onClick="getPatientDetails(document.forms[0].patient_id.value);OnSearch()"/>
					<%}
				}%>
            </td>	

			<%
				if (accept_national_id_no_yn.equals("Y"))
					{	
							if(ext_system_interface_yn.equals("Y"))
								{%>
									<td nowrap align='right' class="label" width='10%' nowrap><%=nat_id_prompt%>&nbsp;</td>

									<!-- Added id="National_Id_No" by Ashwin K for AAKH-CRF-0150 -->
									<td align="left" width="10%" nowrap><input type="text" name="National_Id_No" id="National_Id_No" <%if(function_name.equals("01")){%>id="National_Id_No" <%}%> value=""size="<%=nat_id_length%>" maxlength="<%=nat_id_length%>" 
									onkeypress="return allowValidNumber(this,event,2, 0);"	onBlur='makeValidQueryCriteria(this);searchPatient(document.forms[0].National_Id_No);' onFocus="" tabindex=1> 
									<%if(function_name.equals("01")){%>
									<input type=button id='M_btn1' value='M' class= 'button' name="National_Id_Button" id="National_Id_Button" onClick='MButton_click_AEReg()'>
									<input type="checkbox" id="EmiratesID_edit" name="EmiratesID_edit" id="EmiratesID_edit"  >
									<%}
									else if(function_name.equals("05")){%><!--Added  by santhosh for TH-KW-CRF-0019.1 -->
									<input type=button id='M_btn1' value='M' class= 'button' name="National_Id_Button" id="National_Id_Button" onClick='MButton_click_AEReg()'>
									<% } 
									else if(function_name.equals("06")){%><!--Added  by santhosh for TH-KW-CRF-0019.1 -->
									<input type=button id='M_btn1' value='M' class= 'button' name="National_Id_Button" id="National_Id_Button" onClick='RegAttnSearch_ReadDF1_onclick("AE_REGATTN")'>
									<% }
									else if (function_name.equals("07")){%><!--Added  by Lakshmanan for MOHE-CRF-0164.1 -->
									<input type=hidden  value='M' class= 'button' name="National_Id_Button" id="National_Id_Button">
									<%}
									else {%>
									<input type=button  value='M' class= 'button' name="National_Id_Button" id="National_Id_Button" onClick='RegAttnSearch_ReadDF1_onclick()'>
									<% } %>
<!-- Added by Ashwin K for AAKH-CRF-0158 -->
									<%if(function_name.equals("01")){%>
					<!--	 <applet code="CardReaderApplet.class" name="CardReader"
						codebase="../../eMP/CardReader/" archive="CardReaderApplet.jar" width="5"
						height="5">
						<PARAM name="button_width" value="0" />
						<PARAM name="button_height" value="0" />
						<PARAM name="button_label" value="0" />						
						<param name="separate_jvm" value="true" />
						Sorry, Your browser does not support Java applet!
						</applet>  -->
							
							<!-- Commented above old card reader applet and added for AAKH-CRF-0158 -->
						 <APPLET style="border:solid 1px gray" id="PublicDataWebComponent" name="PublicDataWebComponent" codebase="../../eMP/CardReader/" CODE="emiratesid.jio.webcomponents.PublicDataReader"
                                                        ARCHIVE="PublicDataApplet-Sagem.jar" WIDTH="0" HEIGHT="0">
                                                        <param name="EncryptParameters" value="false" />
                                                        <param name="RelativeCertPath" value="certs" />
														<param name="separate_jvm" value="true" />
														<PARAM name="button_label" value="0" />	
                                                         This browser does not support Applets.
                                                    </APPLET> 
						<%}%>
<!-- Ended by Ashwin K for AAKH-CRF-0158 -->
									<!-- Ended by Ashwin K for AAKH-CRF-0150 -->
									</td>
								<%
					}
							else
								{%>
									<td nowrap align='right'  class="label" nowrap width='10%'><%=nat_id_prompt%>&nbsp;</td>
									<td align="left" width="10%" nowrap><input type="text" name="National_Id_No" id="National_Id_No" value=""size="17" maxlength="<%=nat_id_length%>" 
									onkeypress="return allowValidNumber(this,event,2, 0);"	onBlur='makeValidQueryCriteria(this);searchPatient(document.forms[0].National_Id_No)' onFocus="" tabindex=1></td>
								<%}
					}
				else
					{%>
						<td nowrap align='right'  class="label" nowrap width='22'></td>
					<%}
									 
		   %>
           
			<td class='label' width='25%' nowrap ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/>&nbsp;&nbsp;<span class='field'><input type='text' name='referal_id' id='referal_id' value='' maxlength='14' size='14'  onBlur='changeCase(this);searchPatient(document.forms[0].referal_id)'>&nbsp;<input type='button' class='button' value='?' name='ref_id_search' id='ref_id_search' onClick='getReferralID()' ></span></td>
           
		    <td class='field'   width='18%'><input type="button" name="search" id="search" class=BUTTON value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>'  onClick="OnSearch();">&nbsp;<input type="button" name="clear" id="clear" class=BUTTON value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="clearing();">	
            </td>
			
	      </tr>	
   	   </table> 
           <input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
		   <input type='hidden' name='params' id='params' value='<%=params%>'> 
		   <input type='hidden' name='patFlag' id='patFlag' value=''> 
		   <input type='hidden' name='register_pat_yn' id='register_pat_yn' value="<%=register_pat_yn%>">
		   <input type='hidden' name='attendance_for_inpat_yn' id='attendance_for_inpat_yn' value="<%=reg_attendance_for_inpat_yn%>">
		   <input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>">
		   <!--Below line added by venkatesh.s on 02-April-2014 against 48233 -->
		   <input type='hidden' name='ext_system_interface_yn' id='ext_system_interface_yn' value="<%=ext_system_interface_yn%>"> 
		   
		   <!-- // (venkat s) for PE_EXE ae regn attn function -->
			<input type='hidden' name='prev_visit_hrs' id='prev_visit_hrs' value="">
			<input type='hidden' name='visit_status' id='visit_status' value="">
			<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value="<%=nat_id_prompt%>">
			<input type='hidden' name='entitlement_by_cat_yn' id='entitlement_by_cat_yn' value="<%=entitlement_by_cat_yn%>">
			<input type='hidden' name='p_alt_id2_type' id='p_alt_id2_type' value="<%=p_alt_id2_type%>">
			<input type='hidden' name='p_alt_id3_type' id='p_alt_id3_type' value="<%=p_alt_id3_type%>">
			<input type='hidden' name='p_alt_id4_type' id='p_alt_id4_type' value="<%=p_alt_id4_type%>">
			<!--added by munisekhar for MMS-QH-CRF-0162-->
			<input type='hidden' name='isSiteSpe_change_pat_dtls' id='isSiteSpe_change_pat_dtls' value="<%=isSiteSpe_change_pat_dtls%>"> 
			<input type='hidden' name='userFunRightsCount' id='userFunRightsCount' value="<%=userFunRightsCount%>"> <!--Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]-->
			<!-- below lines added by venkatesh.S (4008) on 22/Feb/2012 aganist CRF Bru-HIMS-CRF-152 [IN030272] -->
			<input type='hidden' name='max_hrs_for_re_attend' id='max_hrs_for_re_attend' value="<%=max_hrs_for_re_attend%>">
		
<!--end CRF  Bru-HIMS-CRF-152 [IN030272]-->	
		<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] Start-->
			<input type='hidden' name='nb_patient_id' id='nb_patient_id' value="<%=nb_patient_id%>">
			<input type='hidden' name='invoke_from' id='invoke_from' value="<%=invoke_from%>">
			<input type='hidden' name='frameRef' id='frameRef' value="top.content">
		<!-- Added by Dharma on Aug 18th 2017 against ML-MMOH-CRF-0631 [IN:062148] End-->

		<input type='hidden' name='isAERegisterTypeAutoUpdateAppl' id='isAERegisterTypeAutoUpdateAppl' value="<%=isAERegisterTypeAutoUpdateAppl%>"> <!-- added by mujafar for KDAH-CRF-0526 -->
		<input type='hidden' name='dflt_emer_follow_type_code' id='dflt_emer_follow_type_code' value="<%=dflt_emer_follow_type_code%>">
		<input type='hidden' name='dflt_time_reg_auto_update' id='dflt_time_reg_auto_update' value="<%=dflt_time_reg_auto_update%>">
		<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	-->
		<input type='hidden' name='biometric_authentication_yn' id='biometric_authentication_yn' value="<%=biometric_authentication_yn%>">
		

	  <script>
		parent.parent.frames[0].document.forms[0].reset.disabled=true;
	
	</script>

		<%






		%>
				<!--for smart card-->
				<input type="hidden" name="txtSmartcard_path" id="txtSmartcard_path" value="<%=Smartcard_path%>">
				<input type="hidden" name="txtSmartcard_dup" id="txtSmartcard_dup" value="">
				<!--for smart card-->
				<!--for Alkhaleej smart card-->
				<input type="hidden" name="txtSmart_fn_name" id="txtSmart_fn_name" value="<%=function_name%>">

				<!-- Tested and Added by Ashwin K for AAKH-CRF-0150-->
				<input type="hidden" id="retreived_natid" value="">
				<input type="hidden" id="retreied_mobno" value="">
				<input type="hidden" id="pat_cnt" value="0">
				<!-- Tested and Ended by Ashwin K for AAKH-CRF-0150-->
		  </form> 
	
		   
		  </body>
		<%
			if(bl_install_yn.equals("Y"))
			{
                session.removeAttribute("financial_details");
		    }
		%>
<%
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();

    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    finally
    {
	    ConnectionManager.returnConnection(con,request);
    }
%>
</html>

