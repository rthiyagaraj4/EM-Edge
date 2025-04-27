<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" %>	 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/// Module			: OutPatient Management...[OP]
/// Created By		: SRIDHAR R 
/// Created Date	: 8 JUNE 2004
/// Function		: This Page is built as an intermediate Page & is used for Validations for Referral Details Component...
/// Calling Page	: ../../eMP/jsp/ReferralDetailsComponent.jsp
///+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	String locale =((String)session.getAttribute("LOCALE"));
    request.setCharacterEncoding("UTF-8");
%>
<html>
    <head>
 	
        <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
        <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<!--  -->

<%
		Connection con			= null;
		ResultSet rs			= null;
		PreparedStatement pstmt = null;
		
		

	try{
		con = ConnectionManager.getConnection(request);

		 Boolean isImproveReferralProcessAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"OP","IMPROVE_REFERRAL_PROCESS"); //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		 Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by lakshmanan for ML-MMOH-CRF-1972 on 19july2023
		String facility_id	= (String) session.getValue( "facility_id" ) ;
	
		String sql						= "";
		
		//String org_type_desc			= "";
		String nursingUnitDesc			= "";
		String nursingUnitCode			= "";
		String clinicDesc				= "";
		String clinicCode				= "";
		String referredtoid				= "";
		String referredtodesc			= "";
		String hcare_setting_type_desc	= "";
		String hcare_setting_type_code	= "";
		String hcare_setting_type		= "";	
		
		String ServiceCode				= "";
		String ServiceDesc				= "";
	
		String locdesc="";
		String loctype="";
		
		String loc_sql="";

		int ip	= 0;
		int op	= 0;

		String ref_type	=	request.getParameter("ref_type");
		if(ref_type==null) ref_type="";

		String loc_type=request.getParameter("loc_type");
		if(loc_type==null) loc_type="";

		String ref_to=request.getParameter("ref_to");
		if(ref_to==null) ref_to="";

		String location1=request.getParameter("location1");
		if(location1==null) location1="";

		String specLoad=request.getParameter("specLoad");
		if(specLoad==null) specLoad="";

		String Option = request.getParameter("Option");
		if(Option == null) Option = "Y";

		String resetHcare = request.getParameter("resetHcare");
		if(resetHcare == null) resetHcare = "N";

		String referred_to_id=request.getParameter("referred_to_id");
		if(referred_to_id==null) referred_to_id="";

		String referred_to_code	= request.getParameter("ref_to_code");
		if(referred_to_code == null) referred_to_code ="";

		String referred_to_desc=request.getParameter("referred_to_desc");
		if(referred_to_desc==null) referred_to_desc="";

		String loc0=request.getParameter("loc0");
		if(loc0==null) loc0="";

		String src1=request.getParameter("src1");
		if(src1 == null) src1 = "";

		String specialty=request.getParameter("specialty");
		if (specialty == null ) specialty = "";

		String service=request.getParameter("service");
		if (service == null ) service = "";

		String ref_service_code=request.getParameter("ref_service_code");
		if (ref_service_code == null ) ref_service_code = "";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-261*/
		String bedclasscode="",bedshortdesc="",bedtypecode="",bedtypeshortdesc="",admissiontypecode="",admissiontypedesc="";
		String loc_code=request.getParameter("loc_code");
		if (loc_code == null ) loc_code = "";	
		String bedclass_code=request.getParameter("bedclasscode");
		if(bedclass_code == null ) bedclass_code = "";	
		//End Bru-HIMS-CRF-261

		String jsp_val=request.getParameter("jsp_val");
		if (jsp_val == null ) jsp_val = "";

		String BodyFrame = request.getParameter("BodyFrame");
		if (BodyFrame == null ) BodyFrame = "";

		String Module = request.getParameter("Module");
		if (Module == null ) Module = "";


		String Transaction_type = request.getParameter("Transaction_type");
		if (Transaction_type == null ) Transaction_type = "";

		String hcare_type_code = request.getParameter("hcare_type");
		if(hcare_type_code==null) hcare_type_code="";
		
		String function_id = request.getParameter("function_id");
		if (function_id == null)   function_id = "";

		String ref_hcare_setting_type = request.getParameter("ref_hcare_setting_type");
		if (ref_hcare_setting_type == null)  ref_hcare_setting_type = "";
		
		String referred_to_value = request.getParameter("referred_to_value");
		if (referred_to_value == null)  referred_to_value = "";
		
		String ref_priority = request.getParameter("ref_priority");
		if (ref_priority == null)  ref_priority = "";
		
		String ref_specialty = request.getParameter("ref_specialty");
		if (ref_specialty == null)  ref_specialty = "";

		String ref_locn_type = request.getParameter("ref_locn_type");
		if (ref_locn_type == null)  ref_locn_type = "";
		
		
		String ref_locn_code = request.getParameter("ref_locn_code");
		if (ref_locn_code == null)  ref_locn_code = "";

		%>
		<script>
			var BodyFrame = "<%=BodyFrame%>"	
		</script>
		<%
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/	
	       	if (function_id.equals("ModifyReferral")){
			referred_to_value=ref_to;
	         }
		/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
///********************************************************************************
/// Setting the Value For [ ORG TYPE ] For Different Referral Types ... 

%>
	<script>
	var ref_type = "<%=ref_type%>";
	var referred_to = "<%=referred_to_code%>";

	</script>
<%
/// Func used to Populate Hcare Values based on Referral type & Module...
if(src1.equals("populateHcare"))
{
	int i=0;
	if(ref_type.equals("L"))
	{
		sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc  hcare_setting_type_desc from sm_facility_param_lang_vw  a, am_hcare_setting_type_lang_vw b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.facility_id ='"+facility_id+"' and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name ";	


		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				i++;
				referredtoid=rs.getString("referred_to_id");
				referredtodesc=rs.getString("referred_to_id_desc");
				hcare_setting_type_desc=rs.getString("hcare_setting_type_desc");
				hcare_setting_type=rs.getString("hcare_setting_type_code");


			%>
			<script>
				var ref_type= "<%=ref_type%>";
				var temp	= "<%=referredtoid%>";
				var temp1	= "<%=referredtodesc%>";
				var jsp_val = "<%=jsp_val%>";

				var hcare_setting_type_desc	= "<%=hcare_setting_type_desc%>";
				var hcare_setting_type		= "<%=hcare_setting_type%>";
				var hcareOpt	= eval(BodyFrame).document.createElement("OPTION");
				hcareOpt.text	= hcare_setting_type_desc;
				hcareOpt.value	= hcare_setting_type;
				if (("<%=function_id%>"=="DischargePatient" || ("<%=function_id%>"=="ModifyReferral" && eval(BodyFrame).document.forms[0].onloadcount.value<1)) && ("<%=ref_hcare_setting_type%>" == "<%=hcare_setting_type%>"))
					hcareOpt.selected = true;  //above line modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 
				else
					hcareOpt.selected = false;
				hcareOpt.selected=true;

				if(ref_type == "L" || ref_type == "E")
				{
					var opt3=eval(BodyFrame).document.createElement("OPTION");
					opt3.text=temp1;
					opt3.value=temp;
			
					if (jsp_val != "")
					{
						var ref_code = eval(BodyFrame).document.forms[0].referral_type.value;
						if (ref_code == temp)
						if(ref_type == "L" || ref_type == "E")
						{	
							opt3.selected=true;
						}
					}

					<%if(referred_to_id.equals(referredtoid) || ref_type.equals("L") || ref_type.equals("E")) 
					{%>
					opt3.selected=true;
					<%} %>
					if (("<%=function_id%>"=="DischargePatient") && ('<%=referred_to_value%>' == temp))
					opt3.selected = true;
					eval(BodyFrame).document.forms[0].referral_source.value=opt3.text;  // added for crf 508
					eval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=opt3.text;
					eval(BodyFrame).document.forms[0].referred_to.value=opt3.value;
					//eval(BodyFrame).document.forms[0].referred_to.add(opt3);
				}
				eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);

				 if(eval(BodyFrame).document.forms[0].speciality_desc && eval(BodyFrame).document.forms[0].onloadcount.value>0)
				{  //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
				eval(BodyFrame).document.forms[0].speciality_desc.value=""; 
				eval(BodyFrame).document.forms[0].speciality.value="";  
				}
				// Commented on 7 SEP 2004

				if ("<%=function_id%>"=="DischargePatient")
				{
					eval(BodyFrame).document.forms[0].priority.value="<%=ref_priority%>";
					eval(BodyFrame).document.forms[0].speciality.value="<%=ref_specialty%>";
				}
				</script>
				<%
			}// E.O While
		}// E.O If

		/// Added on 23 JULY 2004..
		/// This will be executed if there are no records found in Healthcare...
		if(i == 0 )
		{
			
			out.println("<script>alert(getMessage('REST_HCARE_SET','AM'));</script>");	
			out.println("<script>eval(BodyFrame).document.forms[0].referral_type.focus();</script>");
		}

		 if(rs != null) rs.close();
		 if(pstmt != null)pstmt.close();
	 
	}// E.O if(ref_type.equals("L")
	else
	if(ref_type.equals("E") || ref_type.equals("X"))
	{

		if(Module.equals("IP") || Transaction_type.equals("DA") || Transaction_type.equals("DP") )
		{
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is IP...
			sql= " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE_LANG_VW  WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE IP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) and language_id='"+locale+"' order by SHORT_DESC ";

			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				%>
				<script>
					var hcare_setting_type_desc = "<%=hcare_setting_type_desc%>";
					var hcare_setting_type_code = "<%=hcare_setting_type_code%>";
							
					var hcareOpt = eval(BodyFrame).document.createElement("OPTION");
					hcareOpt.text	= hcare_setting_type_desc;
					hcareOpt.value	= hcare_setting_type_code;
					if (("<%=function_id%>"=="DischargePatient" || ("<%=function_id%>"=="ModifyReferral" && eval(BodyFrame).document.forms[0].onloadcount.value<1) ) && ("<%=ref_hcare_setting_type%>" == "<%=hcare_setting_type_code%>"))
					{ //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023  
						hcareOpt.selected = true; 
						eval(BodyFrame).getval2(hcare_setting_type_code); 
					}
					else
						hcareOpt.selected = false;
				eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);
				</script>
				<%
				}// E.O While
			}// E.O if
		
		   if(rs !=null ) rs.close();
		   if(pstmt!= null) pstmt.close();

		}
		else
		if(Module.equals("OP") || Transaction_type.equals("CO"))
		{
			/// Func used to Populate Hcare Values If Referral type is External or Enterprise  and Module is OP...
			sql = " SELECT HCARE_SETTING_TYPE_CODE, SHORT_DESC FROM AM_HCARE_SETTING_TYPE_LANG_VW   WHERE EFF_STATUS = 'E' AND HCARE_SETTING_TYPE_CODE = (SELECT FROM_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND FROM_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE UNION SELECT TO_HCARE_SETTING_TYPE_CODE FROM AM_HCARE_SETTING_TYPE_RSTRN WHERE OP_REFERRAL_YN = 'Y' AND TO_HCARE_SETTING_TYPE_CODE = HCARE_SETTING_TYPE_CODE) and language_id='"+locale+"' order by SHORT_DESC ";

			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();

			if(rs!=null)
			{
				while(rs.next())
				{
					hcare_setting_type_desc	= rs.getString("SHORT_DESC");
					hcare_setting_type_code = rs.getString("HCARE_SETTING_TYPE_CODE");
				%>
				<script>
					var hcare_setting_type_desc = "<%=hcare_setting_type_desc%>";
					var hcare_setting_type_code = "<%=hcare_setting_type_code%>";
							
					var hcareOpt = eval(BodyFrame).document.createElement("OPTION");
					hcareOpt.text	= hcare_setting_type_desc;
					hcareOpt.value	= hcare_setting_type_code;
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/ 
					if ((eval(BodyFrame).document.forms[0].onloadcount.value<1) && ("<%=ref_hcare_setting_type%>" == "<%=hcare_setting_type_code%>"))
					{
						hcareOpt.selected = true; 
					}
					else
						hcareOpt.selected = false;
					/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/ 
					eval(BodyFrame).document.forms[0].hcare_setting_type.add(hcareOpt);
				</script>
				<%
				}// E.O While
			}// E.O if
			 /*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
			 if (isForAdmission && function_id.equals("ModifyReferral") && ref_type.equals("X")) { %>
			<script>
				eval(BodyFrame).document.forms[0].location0.onchange(); 
				eval(BodyFrame).document.forms[0].onloadcount.value=+1;
			</script>
			<% }
			/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
			
		  if(rs != null) rs.close();
		  if(pstmt != null) pstmt.close();

		}
	}// E.O ref_type

	if(ref_type.equals("E") || ref_type.equals("L"))
	{
		/// <<<<< OP + IP >>>>> Value	
		sql=" select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
		if(rs!=null)
		{
			if (rs.next())
			{
				ip	= rs.getInt(1);
				op	= rs.getInt(2);
			}
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		try{
       	 //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		if(isForAdmission && (function_id.equals("ModifyReferral") || function_id.equals("for_admission") ) )
			{
			if(ip > 0)
				{
				if ((ref_type.equals("L")||ref_type.equals("E")) && op > 0)
					{
					if(Option.equals("Y"))
						{
						loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
						}
					else
						{
						loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
						}
					}
				else 
					{
					loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
					}
				}	
				
			}
		else {
		if(ip > 0)
		{
			if ((ref_type.equals("L")||ref_type.equals("E")) && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}
		sql="select short_desc,locn_type,care_locn_type_ind from AM_CARE_LOCN_TYPE_LANG_VW where "+loc_sql+" and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
         %> <script>
		var length = eval(BodyFrame).document.forms[0].location0.length;
		for(i=0;i<length;i++)
		{
			eval(BodyFrame).document.forms[0].location0.remove(1);
		}</script> <%
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		 if(rs != null)
			{
			  while(rs.next())
				{
				   locdesc=rs.getString(1);
				   loctype=rs.getString(2);
				%>
				 <script>
				var opt=eval(BodyFrame).document.createElement("OPTION");
				opt.text="<%=locdesc%>";
				opt.value="<%=loctype%>";
				eval(BodyFrame).document.forms[0].location0.add(opt);
				eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
				
				</script>
				<%
				 }
			  
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 start*/
				if (isForAdmission && function_id.equals("ModifyReferral")) { %>
				<script>
					eval(BodyFrame).document.forms[0].location0.options[0].selected=true; 
					eval(BodyFrame).document.forms[0].location0.onchange(); 
					</script>
				<% 
				/*added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 end*/
					/*Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187*/
				}
				else if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")) { %> 
					<script> 
					if(eval(BodyFrame).document.forms[0].quick_admission && !eval(BodyFrame).document.forms[0].quick_admission.checked)
					{
						eval(BodyFrame).document.forms[0].location0.options[1].selected=true;
						eval(BodyFrame).document.forms[0].location0.onchange();
					}else if(!eval(BodyFrame).document.forms[0].quick_admission) 
					{ 
						eval(BodyFrame).document.forms[0].location0.options[1].selected=true; 
						eval(BodyFrame).document.forms[0].location0.onchange(); 
					} 
					</script> 
					<% 	
					}
					/*End MMS-DM-CRF-0187*/
					
					 /*Below line Added for this CRF Bru-HIMS-CRF-261*/	
				 %>
     <script>
          if(eval(BodyFrame).document.forms[0].quick_admission && eval(BodyFrame).document.forms[0].quick_admission.checked)
		  { 	 			 
			     if(eval(BodyFrame).document.forms[0].location0){				
				        for(var m=0; m< eval(BodyFrame).document.forms[0].location0.length; m++){ 
	                        if(eval(BodyFrame).document.forms[0].location0[m].value=="N"){
	                           eval(BodyFrame).document.forms[0].location0.value=eval(BodyFrame).document.forms[0].location0[m].value;	
	                           eval(BodyFrame).document.forms[0].location0.disabled=true;
							   //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
							   if(eval(BodyFrame).document.forms[0].isImproveReferralProcessAppl.value == "true" && eval(BodyFrame).document.forms[0].hddFuncID.value != "RegisterInpatientReferral"){
								   eval(BodyFrame).document.forms[0].location0.onchange();
							   }
	                       }
	                   }
	            }
	     }
       </script>			   
<%
			  /*End this CRF Bru-HIMS-CRF-261*/
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}


}// E.O if(src1.equals("populateHcare"))



if(src1.equals("populateReferredTo")){
	if(ref_type.equals("E")){			

		//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
		//sql= " SELECT FACILITY_ID REFERRED_TO_ID, FACILITY_NAME REFERRED_TO_ID_DESC FROM SM_FACILITY_PARAM_LANG_VW WHERE FACILITY_ID != '"+facility_id+"' AND  HCARE_SETTING_TYPE_CODE='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 2";

		//pstmt=con.prepareStatement(sql);
		//rs=pstmt.executeQuery();

		//if(rs!=null)	{
			//while(rs.next()){
				//referredtoid	=	rs.getString("REFERRED_TO_ID");
				//referredtodesc	=	rs.getString("REFERRED_TO_ID_DESC");
			%>
			<script>
				//var referredToCode = "<%=referredtoid%>";
				//var referredToDesc = "<%=referredtodesc%>";
						
				//var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
				//referredToOpt.text	= referredToDesc;
				//referredToOpt.value = referredToCode;
				//if (("<%=function_id%>"=="DischargePatient") && ('<%=referred_to_value%>' == referredToCode))
					//referredToOpt.selected = true;
				//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);

				/*
				if(eval(BodyFrame).document.getElementById('locn_type_img'))
				{
					eval(BodyFrame).document.getElementById('locn_type_img').style.visibility='visible';
				}*/
			</script>
			<%
			//}// E.O while
		//}// E.O if
	
	  //if(rs != null) rs.close();
	  //if(pstmt != null) pstmt.close();

	}else if( ref_type.equals("X")){
		if(Module.equals("IP") || Transaction_type.equals("DA") || Transaction_type.equals("DP") ){

			//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			//sql = "SELECT LONG_DESC, REFERRAL_CODE FROM AM_REFERRAL_LANG_VW    WHERE EFF_STATUS = 'E' AND DEST_USE_AT_DISCH_YN = 'Y' AND HEALTHCARE_SETTING_TYPE='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 1 ";
			
			//pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null){
				//while(rs.next()){
					//referredtoid	=	rs.getString("REFERRAL_CODE");
					//referredtodesc	=	rs.getString("LONG_DESC");
				%>
				<script>
					//var referredToCode = "<%=referredtoid%>";
					//var referredToDesc = "<%=referredtodesc%>";
							
					//var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
					//referredToOpt.text	= referredToDesc;
					//referredToOpt.value = referredToCode;
					//if (("<%=function_id%>"=="DischargePatient") && ('<%=referred_to_value%>' == referredToCode))
						//referredToOpt.selected = true;
					//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);
									//alert('3')	
					//eval(BodyFrame).document.forms[0].referral_source.value=referredToOpt.text;  // added for crf 508
					//eval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=referredToOpt.text;
					//eval(BodyFrame).document.forms[0].referral_source_lkp_id.value=referredToOpt.value;
	

				if(eval(BodyFrame).document.getElementById('locn_type_img'))
				{
					eval(BodyFrame).document.getElementById('locn_type_img').style.visibility='hidden';
				}
				</script>
				<%
				//}// E.O while
			//}// E.O if
		
		//if(rs != null) rs.close();
		//if(pstmt != null) pstmt.close();

		}else if(Module.equals("OP") || Transaction_type.equals("CO")) {

			//String HCARE_TYPE_CODE = request.getParameter("hcare_type");
			//sql= " SELECT LONG_DESC, REFERRAL_CODE FROM AM_REFERRAL_LANG_VW WHERE EFF_STATUS = 'E' AND DEST_USE_AT_CONCL_YN = 'Y' AND //HEALTHCARE_SETTING_TYPE ='"+HCARE_TYPE_CODE+"' and language_id='"+locale+"' order by 1 ";

			///pstmt=con.prepareStatement(sql);
			//rs=pstmt.executeQuery();

			//if(rs!=null)			{
				//while(rs.next())				{
					//referredtoid	=	rs.getString("REFERRAL_CODE");
					//referredtodesc	=	rs.getString("LONG_DESC");
				%>
				<script>
					//var referredToCode = "<%=referredtoid%>";
					//var referredToDesc = "<%=referredtodesc%>";
							
					//var referredToOpt = eval(BodyFrame).document.createElement("OPTION");
					//referredToOpt.text	= referredToDesc;
					//referredToOpt.value = referredToCode;
					//eval(BodyFrame).document.forms[0].referred_to.add(referredToOpt);
										//alert('4')
					//eval(BodyFrame).document.forms[0].referral_source.value=referredToOpt.text;  // added for crf 508
					//eval(BodyFrame).document.forms[0].referral_source_lkp_bkup_text.value=referredToOpt.text;
					//eval(BodyFrame).document.forms[0].referral_source_lkp_id.value=referredToOpt.value;
	
				</script>
				<%
				//}// E.O while
			//}// E.O if
		 // if(rs!= null) rs.close();
		 // if(pstmt!= null)  pstmt.close();
		}
	}

//// Added FOR LOCATION 
if(ref_type.equals("E") || ref_type.equals("L"))
{
	sql="select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facility_id+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";

	pstmt=con.prepareStatement(sql);
	rs=pstmt.executeQuery();
	
	if(rs!=null)
	{
		if (rs.next())
		{
			ip	= rs.getInt("ip");
			op	= rs.getInt("op");
		}
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

	//-----

   try{
       	       	 //Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		if(isForAdmission && (function_id.equals("ModifyReferral") || function_id.equals("for_admission")))
			{  	
		if(ip > 0)
		{
			if (ref_type.equals("L") && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
				}
			}else if (op > 0)
			{
				if(Option.equals("Y")&& !function_id.equals("RegisterInpatientReferral"))
				{
			 loc_sql="care_locn_type_ind in ('D','N') and locn_type in ('Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('D') and locn_type in ('Y') ";
				}
			}
			else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}else {
					if(ip > 0)
		{
			if (ref_type.equals("L") && op > 0)
			{
				if(Option.equals("Y"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}else if (op > 0)
			{
				if(Option.equals("Y")&& !function_id.equals("RegisterInpatientReferral"))
				{
			 loc_sql="care_locn_type_ind in ('C','E','D','N') and locn_type in ('C','E','Y','N') ";
				}
				else
				{
			loc_sql="care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') ";
				}
			}
			else 
		       {
			 loc_sql="care_locn_type_ind in ('N') and locn_type in ('N') ";
			  }
		}else if (op >0 )
			{
			loc_sql="care_locn_type_ind in ('C') and locn_type in ('C') ";
			}
		}
		sql="select short_desc,locn_type,care_locn_type_ind from AM_CARE_LOCN_TYPE_LANG_VW where "+loc_sql+" and  SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc";
         
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		 if(rs != null)
			{
			  while(rs.next())
				{
				   locdesc=rs.getString(1);
				   loctype=rs.getString(2);
				%>
				 <script>
				var opt=eval(BodyFrame).document.createElement("OPTION");
				opt.text="<%=locdesc%>";
				opt.value="<%=loctype%>";
				eval(BodyFrame).document.forms[0].location0.add(opt);
				eval(BodyFrame).location0_array[eval(BodyFrame).location0_array.length] = opt
				 </script>
				<%
				 }
					//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
					if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){%>
					<script>
						eval(BodyFrame).document.forms[0].location0.options[1].selected=true;
						eval(BodyFrame).document.forms[0].location0.onchange();
					</script>
					<%}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

		}catch(Exception e){e.printStackTrace();}
	}
}

/// The function will query the SPECIALTY options if Referral Type is External..
if(src1.equals("populateSpecialty"))
{
	String hcare_code   = request.getParameter("hcare_code");
	String ref_to_code	= request.getParameter("ref_to_code");

	if(ref_to_code ==null) ref_to_code  ="";
	if(hcare_code==null) hcare_code="";

	if(ref_type.equals("X"))
	{
		String specialty_short_desc	= "";
		String specialty_code		= "";
		
		
			
			pstmt=con.prepareStatement("Select specialty_code,am_get_Desc.am_speciality(specialty_code,'"+locale+"',2) specialty_short_desc from am_referral_for_specialty_vw where referral_code='"+ref_to_code+"' order by 2");
			rs		= pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					specialty_code		= rs.getString("specialty_code");
					specialty_short_desc= rs.getString("specialty_short_desc");
					%>
					<script>
						var temp = "<%=specialty_code%>";
						var temp1="<%=specialty_short_desc%>";
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						eval(BodyFrame).document.forms[0].speciality.add(opt);
					</script>
			<%	}	
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}//if ref type='X'
%>
	<script>
		var ref_type= "<%=ref_type%>";

		if(ref_type == 'E' || ref_type == 'X')

		var service = eval(BodyFrame).document.forms[0].service;
		while(service.options.length > 0)
			service.remove(service.options[1]);

		var serviceOpt	= eval(BodyFrame).document.createElement("OPTION");
		serviceOpt.text	= "---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		serviceOpt.value	= "";
		eval(BodyFrame).document.forms[0].service.add(serviceOpt);
	</script>
<%
	ServiceCode = "";
	ServiceDesc = "";

	String reff_to_code	= request.getParameter("ref_to_code");
	if(reff_to_code ==null) reff_to_code  ="";	

	pstmt=con.prepareStatement("SELECT SHORT_DESC SERVICE_SHORT_DESC, SERVICE_CODE FROM AM_SERVICE_LANG_VW WHERE EFF_STATUS = 'E' and language_id='"+locale+"' order by 1");
	rs = pstmt.executeQuery();
	
	if(rs != null)
	{
		while(rs.next())
		{
			ServiceCode = rs.getString("SERVICE_CODE");
			ServiceDesc	= rs.getString("SERVICE_SHORT_DESC");	

			%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.value	= "<%=ServiceCode%>"; 
					opt.text	= "<%=ServiceDesc%>";
					eval(BodyFrame).document.forms[0].service.add(opt);
				</script>
		<%
		}
	}
	
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();

}

if(src1.equals("populateServiceVals"))
{	
	%>
	<script>
		var service = eval(BodyFrame).document.forms[0].service;
		while(service.options.length > 0)
			service.remove(service.options[1]);

		var serviceOpt	= eval(BodyFrame).document.createElement("OPTION");
		serviceOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		serviceOpt.value	= "";
		eval(BodyFrame).document.forms[0].service.add(serviceOpt);
	</script>
<%
	ServiceCode = "";
	ServiceDesc = "";

	String reff_to_code	= request.getParameter("ref_to_code");
	if(reff_to_code ==null) reff_to_code  ="";
	
// for referral type  =  Login Facility or Enterprise
	sql = " SELECT b.SHORT_DESC, a.service_code FROM am_facility_service a , AM_SERVICE_LANG_VW b WHERE a.eff_status = 'E' AND a.operating_facility_id = '"+reff_to_code+"' and a.service_code = b.service_code and b.language_id='"+locale+"' ORDER BY 1 ";
	
	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			ServiceCode = rs.getString("SERVICE_CODE");
			ServiceDesc	= rs.getString("SERVICE_SHORT_DESC");	
			%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.value	= "<%=ServiceCode%>"; 
					opt.text	= "<%=ServiceDesc%>";
					eval(BodyFrame).document.forms[0].service.add(opt);
				</script>
		<%
		}
	}

	if(rs != null) rs.close();
	if(pstmt!= null) pstmt.close();
}
/*Below line added for this CRF ML-MMOH-CRF-0566*/
if(src1.equals("populateReason"))
{
String bedsideReferral=request.getParameter("bedsideReferral");
if(bedsideReferral==null) bedsideReferral="";
%>
<script>  
if(eval(BodyFrame).document.getElementById('referral_reg')){ 
eval(BodyFrame).document.getElementById('referral_reg').style.visibility = "visible";
if("<%=bedsideReferral%>"=="X")eval(BodyFrame).document.getElementById('referral_reg').innerHTML=getLabel("Common.ReasonforRejection.label","Common");

if("<%=bedsideReferral%>"=="S")eval(BodyFrame).document.getElementById('referral_reg').innerHTML=getLabel("Common.ReasonforCancel.label","Common");
}
if(eval(BodyFrame).document.getElementById('referral_reg_id'))eval(BodyFrame).document.getElementById('referral_reg_id').style.visibility = "visible";

if(eval(BodyFrame).document.getElementById('ref_reg_id'))eval(BodyFrame).document.getElementById('ref_reg_id').style.visibility = "visible";

		var referral_reg_id = eval(BodyFrame).document.getElementById('referral_reg_id');
			var length1  = referral_reg_id.length;
	
        for(var i=length1-1; i>=0; i--) { 
				referral_reg_id.remove(i);
		}  	

		var referralOpt	= eval(BodyFrame).document.createElement("OPTION");
		referralOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
		referralOpt.value	= "";
		referral_reg_id.add(referralOpt);
	</script>
<%
	
	String cancel_reason_code="", cancel_reason_desc="";
	if(bedsideReferral.equals("S")){
	   sql = "select contact_reason_code, contact_reason from am_contact_reason where cancel_ref_reason_yn='Y' order by contact_reason";
	}if(bedsideReferral.equals("X")){
	   sql = "select contact_reason_code, contact_reason from am_contact_reason where reject_ref_reason_yn='Y' order by contact_reason";	
	}
		
	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
	if(rs != null)
	{
		while(rs.next())
		{
			cancel_reason_code = rs.getString("contact_reason_code");
			if(cancel_reason_code==null) cancel_reason_code="";
			cancel_reason_desc	= rs.getString("contact_reason");	
			if(cancel_reason_desc==null) cancel_reason_desc="";
			
			%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.value	= "<%=cancel_reason_code%>"; 
					opt.text	= "<%=cancel_reason_desc%>";					
					referral_reg_id.add(opt);
				</script>
		<%
		}
	}

	if(rs != null) rs.close();
	if(pstmt!= null) pstmt.close();
}
//End this CRF ML-MMOH-CRF-0566

if(src1.equals("populateLocation"))
{
	/// Func used to Display Location Values based on Location Type...
%>
	<script>
	// If Loaction Type is clinic, then Referred For is Disabled...
		if(eval(BodyFrame).document.forms[0].ref_for_ip)
		{  
             /*Below line Added for this CRF Bru-HIMS-CRF-261*/			
     		if(eval(BodyFrame).document.forms[0].quick_admission && !eval(BodyFrame).document.forms[0].quick_admission.checked){ 
			   eval(BodyFrame).document.forms[0].ref_for_ip.disabled = false; 
			}
		}
		if('<%=loc_type%>'!=""&&'<%=loc_type%>'!="N"){
		if(eval(BodyFrame).document.forms[0].Bedcode){
		eval(BodyFrame).document.forms[0].Bedcode.disabled = true; 
		eval(BodyFrame).document.forms[0].Bedcode.value = '';
		}if(eval(BodyFrame).document.forms[0].bed_type){
		eval(BodyFrame).document.forms[0].bed_type.disabled = true; 
		eval(BodyFrame).document.forms[0].bed_type.value = '';
		}
		}else{
		if(eval(BodyFrame).document.forms[0].Bedcode)
		eval(BodyFrame).document.forms[0].Bedcode.disabled = false; 	
        if(eval(BodyFrame).document.forms[0].bed_type)		
		eval(BodyFrame).document.forms[0].bed_type.disabled = false; 
	
		}
	</script>
<%
	if(service == null) service = "";

	String referred_to = request.getParameter("ref_to");
	if(referred_to == null) referred_to = "";

/// FOR Location Type = "clinic"
	if(loc_type.equals("C"))
	{	
		if(!service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}else{
					sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}
			}else{
				sql=" SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='C' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',2) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
			}
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and language_id='"+locale+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE, CARE_LOCN_TYPE_IND FROM OP_CLINIC_LANG_VW     WHERE EFF_STATUS = 'E' and clinic_type='C' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and language_id='"+locale+"' order by 1 ";	
			}
		}

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		int clinic_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				clinicDesc			= rs.getString("CLINIC_DESC");
				clinicCode			= rs.getString("CLINIC_CODE");
				clinic_cnt ++;
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=clinicDesc%>"; 
					opt.value	= "<%=clinicCode%>";
				</script>
				<%if((location1.equals(clinicCode)) || (ref_locn_code.equals(clinicCode)) )
				{%>
					<script>opt.selected=true;	</script>
				<%} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
						if (eval(BodyFrame).document.forms[0].location1.options[0].text === "---------Select---------") {
						    // Change the value of the first option
						    eval(BodyFrame).document.forms[0].location1.options[0].value = "";
						  }

					</script>
			<%
			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (clinic_cnt == 1)){
		%>
		<script>
			eval(BodyFrame).document.forms[0].location1.options[1].selected=true;
			eval(BodyFrame).document.forms[0].location1.onchange();
		</script>
		<%
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		%>
		<script>
		// If Loaction Type is clinic, then Referred For is Disabled...
		if(eval(BodyFrame).document.forms[0].ref_for_ip)
		{
			eval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; 
			eval(BodyFrame).document.forms[0].ref_for_ip.value = '';
		}
		</script>
		<%
	}// E.O if(loc_type.equals("C"))

/// FOR Location Type = "NursingUnit [N]"
	if (loc_type.equals("N"))
	{
		if(!service.equals(""))
		{
		   sql=" SELECT long_desc nu_desc, nursing_unit_code FROM ip_nursing_unit_lang_vw WHERE eff_status = 'E' AND facility_id = '"+referred_to+"' AND service_code = '"+service+"'AND patient_class = 'IP' AND LOCN_TYPE = 'N'  and language_id='"+locale+"' UNION SELECT   ip_get_desc.IP_NURSING_UNIT(FACILITY_ID,NURSING_UNIT_CODE,'"+locale+"',1) nu_desc, nursing_unit_code FROM ip_nurs_unit_for_service_vw WHERE facility_id = '"+referred_to+"' AND service_code = '"+service+"' AND appl_patient_class = 'IP' ORDER BY 1 ";
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql="  Select distinct a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and a.language_id='"+locale+"' order by 1 ";
				}else{
					sql="  Select a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"' and a.language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql="  Select a.long_desc NU_DESC, a.nursing_unit_code NURSING_UNIT_CODE ,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+referred_to+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and a.locn_type='N' and a.patient_class = 'IP' and a.facility_id = b.facility_id and b.specialty_code = '"+specialty+"' and a.language_id='"+locale+"' order by 1 ";
			}
		}

		pstmt=con.prepareStatement(sql);
		rs	  = pstmt.executeQuery();
		int nu_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				nursingUnitDesc	= rs.getString("NU_DESC");
				nursingUnitCode	= rs.getString("NURSING_UNIT_CODE");
				nu_cnt ++;
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=nursingUnitDesc%>"; 
					opt.value	= "<%=nursingUnitCode%>";
				</script>
				<%if((location1.equals(nursingUnitCode)) || (nursingUnitCode.equals(ref_locn_code))) 
				{%>
					<script> opt.selected=true;	</script>
				<%} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
						if (eval(BodyFrame).document.forms[0].location1.options[0].text === "---------Select---------") {
						    // Change the value of the first option
						    eval(BodyFrame).document.forms[0].location1.options[0].value = "";
						  }
					</script>
			<%
			}// E.O While
		}// E.O If

		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (nu_cnt == 1)){
		%>
		<script>
			eval(BodyFrame).document.forms[0].location1.options[1].selected=true;
			eval(BodyFrame).document.forms[0].location1.onchange();
		</script>
		<%
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

	}// E.O if (loc_type.equals("N"))

/// FOR Location Type = "day care"
	if (loc_type.equals("Y"))
	{   
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 start*/	
		String SqlAppend="UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1)  CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"'";
		if(isForAdmission && function_id.equals("ModifyReferral")){
			SqlAppend="";
			}
	/*added by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023 end*/
		if(!service.equals(""))
		{ 
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"' "+SqlAppend+" order by 1 ";
				}else{
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  "+SqlAppend+" order by 1 ";
				}
			}else{
					sql=" SELECT long_desc SHORT_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' AND clinic_type='Y' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  "+SqlAppend+" order by 1 ";
			}
		}
		else if(service.equals(""))
		{ 
		    //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and language_id='"+locale+"'  ORDER BY 2";
				}else{
					sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and speciality_code = '"+specialty+"' and language_id='"+locale+"'  ORDER BY 2";
				}
			}else{
				sql=" SELECT  CLINIC_CODE , long_desc SHORT_DESC FROM OP_CLINIC_LANG_VW  WHERE eff_status = 'E' AND FACILITY_ID = '"+referred_to+"' AND CLINIC_TYPE = 'Y' and CARE_LOCN_TYPE_IND = 'D' and speciality_code = '"+specialty+"' and language_id='"+locale+"'  ORDER BY 2";
			}
		}
		pstmt=con.prepareStatement(sql);
		rs		= pstmt.executeQuery();
		int dc_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				nursingUnitDesc	= checkForNull(rs.getString("SHORT_DESC"));
				nursingUnitCode	= checkForNull(rs.getString("CLINIC_CODE"));
				dc_cnt ++;
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=nursingUnitDesc%>"; 
					opt.value	= "<%=nursingUnitCode%>";
				</script>
			<%//	if(location1.equals(nursingUnitCode)) 
				//below line modified by lakshmanan for ML-MMOH-CRF-1972 on 13-08-2023
		if(location1.equals(nursingUnitCode) || (isForAdmission && function_id.equals("ModifyReferral") && nursingUnitCode.equals(ref_locn_code))) 
				{	%>
					<script> opt.selected=true;	</script>
			<%	} %>
					<script>
						eval(BodyFrame).document.forms[0].location1.add(opt);
						if (eval(BodyFrame).document.forms[0].location1.options[0].text === "---------Select---------") {
						    // Change the value of the first option
						    eval(BodyFrame).document.forms[0].location1.options[0].value = "";
						  }
					</script>
			<%
			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (dc_cnt == 1)){
		%>
		<script>
			eval(BodyFrame).document.forms[0].location1.options[1].selected=true;
			eval(BodyFrame).document.forms[0].location1.onchange();
		</script>
		<%
		}

		if(rs !=null) rs.close();
		if(pstmt != null) pstmt.close();

	%>
		<script>
		// If Loaction Type is clinic, then Referred For is Disabled...
		if(eval(BodyFrame).document.forms[0].ref_for_ip)
		{
			eval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; 
			eval(BodyFrame).document.forms[0].ref_for_ip.value = '';
		}
		</script>
		<%
	
	}// E.O if (loc_type.equals("D"))

	if(loc_type.equals("E"))
	{	
		if(!service.equals(""))
		{	 
			 //Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			 if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
		 			sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
				}
			 }else{
				 sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW  WHERE EFF_STATUS = 'E' AND clinic_type='E' AND FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' UNION SELECT op_get_desc.OP_CLINIC(facility_id,CLINIC_CODE,'"+locale+"',1) CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_FOR_SERVICE_VW WHERE FACILITY_ID = '"+referred_to+"' AND SERVICE_CODE = '"+service+"' order by 1 ";
			 }
		}
		else if(service.equals(""))
		{
			//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
			if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral")){
				if(specialty.equals("")){
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
				}else{
					sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
				}
			}else{
				sql=" SELECT long_desc CLINIC_DESC, CLINIC_CODE FROM OP_CLINIC_LANG_VW WHERE EFF_STATUS = 'E' and clinic_type='E' AND FACILITY_ID = '"+referred_to+"' and speciality_code = '"+specialty+"' and CARE_LOCN_TYPE_IND = 'E' and language_id='"+locale+"' order by 1 ";
			}
		}

		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		int pu_cnt = 0;

		if(rs!=null)
		{
			while(rs.next())
			{
				clinicDesc	= rs.getString("CLINIC_DESC");
				clinicCode	= rs.getString("CLINIC_CODE");
				pu_cnt ++;
				%>
				<script>
					var opt=eval(BodyFrame).document.createElement("OPTION");
					opt.text	= "<%=clinicDesc%>"; 
					opt.value	= "<%=clinicCode%>";
				</script>
				<%	if((location1.equals(clinicCode))||(ref_locn_code.equals(clinicCode)))
					{	
						out.println("<script>opt.selected=true;</script>");
					} 
					out.println("<script> eval(BodyFrame).document.forms[0].location1.add(opt);");
					out.println("if (eval(BodyFrame).document.forms[0].location1.options[0].text === '---------Select---------') {");
					out.println("    eval(BodyFrame).document.forms[0].location1.options[0].value = '';}}");
						  
					%>
						<script>
				
		</script>
			<%
			}// E.O While
		}// E.O If
		
		//Added by Ashwini on 12-Apr-2022 for MMS-DM-CRF-0187
		if(isImproveReferralProcessAppl && !function_id.equals("RegisterInpatientReferral") && !specialty.equals("") && (pu_cnt == 1)){
		%>
		<script>
			eval(BodyFrame).document.forms[0].location1.options[1].selected=true;
			eval(BodyFrame).document.forms[0].location1.onchange();
		</script>
		<%
		}		

		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();

	%>
		<script>
		// If Loaction Type is clinic, then Referred For is Disabled...
		if(eval(BodyFrame).document.forms[0].ref_for_ip)
		{
			eval(BodyFrame).document.forms[0].ref_for_ip.disabled = true; 
			eval(BodyFrame).document.forms[0].ref_for_ip.value = '';
		}
		</script>
		<%	
	}
	/* added by lakhsmanan for ML-MMOH-CRF-1972  start*/
	if(function_id.equals("ModifyReferral")){
		String service_desc="";
		String modifyreferralsql="select am_get_desc.am_service(?,'en','2') as service_desc from dual";
		pstmt=con.prepareStatement(modifyreferralsql);
		pstmt.setString(1,service);
		rs=pstmt.executeQuery();
		System.err.println("in getReferralDetails.jsp 1243 service_desc=="+service_desc);
		System.err.println("in getReferralDetails.jsp 1243 service=="+service);
		System.err.println("in getReferralDetails.jsp 1243 ref_priority=="+ref_priority);
		if(rs!=null && rs.next()){
			service_desc=checkForNull(rs.getString("service_desc"));
		}
		if(rs != null) rs.close();
		if(pstmt !=null) pstmt.close();
		System.err.println("in getReferralDetails.jsp 1243 service_desc=="+service_desc);
		%>
		<script> 
		if(eval(BodyFrame).document.forms[0].location0 && eval(BodyFrame).document.forms[0].onloadcount.value<1){
			
			eval(BodyFrame).document.forms[0].pract_name.disabled			= false;
			eval(BodyFrame).document.forms[0].pract_butt.disabled			= false;
			eval(BodyFrame).document.forms[0].service.value = eval(BodyFrame).document.forms[0].hddref_service_code.value;
			eval(BodyFrame).document.forms[0].service_desc.value = "<%=service_desc%>";
			eval(BodyFrame).document.forms[0].onloadcount.value=+1;
	        for(var m=0; m< eval(BodyFrame).document.forms[0].location0.length; m++){ 
                if(eval(BodyFrame).document.forms[0].location0[m].value=="<%=loc_type%>"){
                	eval(BodyFrame).document.forms[0].location0.options[m].selected=true;  
               }
           }
    }		
		</script>
	<%}
	/* added by lakhsmanan for ML-MMOH-CRF-1972  end*/	
}

if(src1.equals("populateService"))
{
	String Nursing_unit	=	request.getParameter("Nursunit");
		if(Nursing_unit==null) Nursing_unit="";

	String Location_Type	=	request.getParameter("Location_Type");
		if(Location_Type==null) Location_Type="";

	String reff_to	=	request.getParameter("reff_to");
		if(reff_to==null) reff_to="";

	String speciality_code	=	request.getParameter("speciality_code");
		if(speciality_code==null) speciality_code="";

	if(ref_type.equals("L") || ref_type.equals("E"))
	{
		if(Location_Type.equals("Y")) // For DayCare
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW  where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'D' and a.clinic_type='Y' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";
		}
		else if(Location_Type.equals("C")) // For Clinic
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'C' and a.clinic_type='C' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";

		}
		else if(Location_Type.equals("E")) // For Procedure Unit
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from op_clinic a where a.speciality_code = '"+speciality_code+"' and a.clinic_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.care_locn_type_ind = 'E' union select a.service_code from op_clinic_for_service a,op_clinic b where a.clinic_code = b.clinic_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.speciality_code ='"+speciality_code+"' and a.clinic_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";

		}
		else if(Location_Type.equals("N")) // For NursingUnit
		{
			sql=" select service_code, short_desc from AM_SERVICE_LANG_VW where service_code in(select a.service_code from ip_nursing_unit a where a.nursing_unit_code ='"+Nursing_unit+"' and a.facility_id='"+reff_to+"' and a.appl_patient_class = 'IP' union select a.service_code from ip_nurs_unit_for_service a,ip_nursing_unit b where a.nursing_unit_code = b.nursing_unit_code and a.facility_id=b.facility_id and a.facility_id='"+reff_to+"' and b.appl_patient_class = 'IP' and a.nursing_unit_code = '"+Nursing_unit+"') and language_id='"+locale+"' order by short_desc ";
		}
		%>
		<script>
			var service = eval(BodyFrame).document.forms[0].service;
			while(service.options.length > 0)
				service.remove(service.options[1]);

			var serviceOpt	= eval(BodyFrame).document.createElement("OPTION");
			serviceOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
			serviceOpt.value	= "";
			eval(BodyFrame).document.forms[0].service.add(serviceOpt);
		</script>
		
	<%
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				ServiceCode = rs.getString("service_code");
				ServiceDesc	= rs.getString("short_desc");		
				%>
					<script>
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text	= "<%=ServiceDesc%>"; 
						opt.value	= "<%=ServiceCode%>";
						eval(BodyFrame).document.forms[0].service.add(opt);
					</script>
			<%
			}
		}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
	}
}	
		/*Below line Added for this CRF  Bru-HIMS-CRF-261 */
		if(src1.equals("populateBedclass") && !loc_code.equals("")){ 		
		sql=" SELECT DISTINCT a.bed_class_code bed_class_code, ip_get_desc.IP_BED_CLASS(a.BED_CLASS_CODE,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED a WHERE a.facility_id = '"+facility_id+"' AND a.eff_status = 'E' AND a.nursing_unit_code = '"+loc_code+"' ORDER BY short_desc ";
		
		%>
		
		<script>  
			var bedcode = eval(BodyFrame).document.forms[0].Bedcode;
			while(bedcode.options.length > 0)
				bedcode.remove(bedcode.options[1]);

			var bedcodeOpt	= eval(BodyFrame).document.createElement("OPTION");
			bedcodeOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
			bedcodeOpt.value	= "";
			eval(BodyFrame).document.forms[0].Bedcode.add(bedcodeOpt);
		</script>
		
	<%
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				bedclasscode = rs.getString("bed_class_code");
				bedshortdesc	= rs.getString("short_desc");		
				
				%>
					<script> 
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text	= "<%=bedshortdesc%>"; 
						opt.value	= "<%=bedclasscode%>";
						eval(BodyFrame).document.forms[0].Bedcode.add(opt);
					</script>
			<%
			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
		
/* Below line code populate the admision type CRF Bru-HIMS-CRF-261*/
sql="select admission_type_code,ip_get_desc.IP_ADMISSION_TYPE(admission_type_code,'"+locale+"',2) short_desc from IP_ADMISSION_TYPE where  eff_status='E' order by short_desc";
		
		%>
		
		<script>  
			var visitadmtype = eval(BodyFrame).document.forms[0].visit_adm_type;
			while(visitadmtype.options.length > 0)
				visitadmtype.remove(visitadmtype.options[1]);

			var visitadmtypeOpt	= eval(BodyFrame).document.createElement("OPTION");
			visitadmtypeOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
			visitadmtypeOpt.value	= "";
			eval(BodyFrame).document.forms[0].visit_adm_type.add(visitadmtypeOpt);
		</script>
		
	<%
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		
 		Boolean isAdmissionTypeAppl = CommonBean.isSiteSpecific(con,"IP","ADMISSION_TYPE_APPL");//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
        String admission_type	= eIP.IPCommonBean.getAdmissionType(con,facility_id);//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618
	

		if(rs != null)
		{
			while(rs.next())
			{
				admissiontypecode = rs.getString("admission_type_code");
				admissiontypedesc	= rs.getString("short_desc");	
                //admissiontypecode="",admissiontypedesc="";				
				
				%>
					<script> 
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text	= "<%=admissiontypedesc%>"; 
						opt.value	= "<%=admissiontypecode%>";
						eval(BodyFrame).document.forms[0].visit_adm_type.add(opt);
						//Added by shanmukh on 1st-AUG-2018 for ML-MMOH-CRF-0618
						if(<%=isAdmissionTypeAppl%> && ("<%=admissiontypecode%>" == "<%=admission_type%>")){
							opt.selected = true;
										}
					</script>
			<%
			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
		
   //populate the admission type End Bru-HIMS-CRF-261
	}
/*Below code  for the popolate the bedtyp*/
if(src1.equals("populateBedtype") && !loc_code.equals("")&& !bedclass_code.equals("")){

sql="SELECT DISTINCT a.bed_type_code bed_type_code, b.short_desc bed_type_short_desc FROM IP_NURSING_UNIT_BED a, IP_BED_TYPE_LANG_VW b WHERE b.language_id = '"+locale+"' and a.facility_id = '"+facility_id+"' AND a.nursing_unit_code = '"+loc_code+"' AND a.bed_class_code = b.bed_class_code AND a.bed_type_code = b.bed_type_code AND a.bed_class_code = '"+bedclass_code+"' AND a.eff_status='E' AND b.eff_status = 'E' AND a.psuedo_bed_status = 'N' ORDER BY b.short_desc";
	
		%>
		
		<script>  
			var bedtype = eval(BodyFrame).document.forms[0].bed_type;
			while(bedtype.options.length > 0)
				bedtype.remove(bedtype.options[1]);

			var bedtypeOpt	= eval(BodyFrame).document.createElement("OPTION");
			bedtypeOpt.text	="---------"+getLabel("Common.defaultSelect.label","Common")+"---------";
			bedtypeOpt.value	= "";
			eval(BodyFrame).document.forms[0].bed_type.add(bedtypeOpt);
		</script>
		
	<%
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();


		if(rs != null)
		{
			while(rs.next())
			{
				bedtypecode = rs.getString("bed_type_code");
				bedtypeshortdesc	= rs.getString("bed_type_short_desc");
              			
				
				%>
					<script> 
						var opt=eval(BodyFrame).document.createElement("OPTION");
						opt.text	= "<%=bedtypeshortdesc%>";  
						opt.value	= "<%=bedtypecode%>";
						eval(BodyFrame).document.forms[0].bed_type.add(opt);
					</script>
			<%
			}
	if(rs != null ) rs.close();
	if(pstmt != null) pstmt.close();
		}
	
   
	}
	
 //End  Bru-HIMS-CRF-261	

if (function_id.equals("DischargePatient"))
{	%>
	<script>
		eval(BodyFrame).document.forms[0].referred.disabled				= true;
		eval(BodyFrame).document.forms[0].referral_type.disabled		= true;
		eval(BodyFrame).document.forms[0].hcare_setting_type.disabled	= true;
		
		eval(BodyFrame).document.forms[0].referred_to.disabled			= true;  // comment for crf 508
		eval(BodyFrame).document.forms[0].referral_source.disabled			= true;
		eval(BodyFrame).document.forms[0].referral_source_lkp_but.disabled			= true;

		eval(BodyFrame).document.forms[0].priority.disabled				= true;
		eval(BodyFrame).document.forms[0].preferred_date.disabled		= true;
		eval(BodyFrame).document.getElementById('preferred_date_cal').disabled		= true;
		eval(BodyFrame).document.forms[0].speciality_desc.disabled			= true;
		eval(BodyFrame).document.forms[0].search_speciality.disabled			= true;
		eval(BodyFrame).document.forms[0].service.value = eval(BodyFrame).document.forms[0].hddref_service_code.value;
		eval(BodyFrame).document.forms[0].service_desc.disabled				= true;
		eval(BodyFrame).document.forms[0].search_service.disabled				= true;
		eval(BodyFrame).document.forms[0].location0.disabled			= true;
		eval(BodyFrame).document.forms[0].location1.disabled			= true;
		eval(BodyFrame).document.forms[0].location2.disabled			= true;
		eval(BodyFrame).document.forms[0].pract_name.disabled			= true;
		eval(BodyFrame).document.forms[0].pract_butt.disabled			= true;
		eval(BodyFrame).document.forms[0].ref_for_ip.disabled			= true;
	</script>
<%	
}

%>
</head>
<body class=message onKeyDown = 'lockKey();'>
	<form name='dummyform' id='dummyform'></form>
</body>
	<%
	}catch(Exception e)
	{
		out.println(e);
	}
	finally 
	{ 
		try{
		
			if(rs!=null)		rs.close();
			if(pstmt != null) pstmt.close();
		}catch(Exception ee){}		

		if(con != null) ConnectionManager.returnConnection(con,request);		
	}
	%>
<%!
	/*Below line Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023 */
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

