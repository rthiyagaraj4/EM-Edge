<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>  

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<!--<object id="locale" classid="clsid:C0276E18-D808-4F12-829E-BC186831D396" CODEBASE="../../eCommon/js/Locale.CAB#version=1,0,0,0"></object>-->

    <script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script> 
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script> 
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<Script src="../../eAE/js/DisasterPatient.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

    <body onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()"  onKeyDown = "lockKey()" onload='chkValue(document.forms[0].creat_attn_detail_yn);setfocus();coldisable()' >
    <form name='DisasterPatReg' id='DisasterPatReg' method='post'   action='../../servlet/eAE.DisasterRegistrationServlet' target='messageFrame'>
	<br><br>
<!--	<script>alert('Main')</script> -->
    <table width='90%' cellpadding='2' cellspacing='0' border='0' align='center'>
		<tr>
			<td  class='label'  nowrap width='25%'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
            <td class='fields'  width='25%'>
            <%
				Connection        con			= null;
				Statement stmt					 = null;
				PreparedStatement pstmt			= null;
				PreparedStatement pstmt3		= null; 
				ResultSet rs					= null;
				ResultSet rset					= null;
				StringBuffer sqlbuf				= new StringBuffer();
				String Site						= request.getParameter("Site");
				if(Site == null)   Site="DS";
				String bl_interface_yn			= request.getParameter("billing_interfaced_yn");
				String operstn					= request.getParameter("operstn");
				String module_id				= request.getParameter("module_id");
			
				request.setCharacterEncoding("UTF-8");
				request= new XSSRequestWrapper(request);
				response.addHeader("X-XSS-Protection", "1; mode=block");
				response.addHeader("X-Content-Type-Options", "nosniff");
				
				String locale					= (String)session.getAttribute("LOCALE");
				String facility_id				= (String)session.getValue("facility_id");
				//String loginUser				= (String)session.getValue("login_user");
				String bl_install_yn			= (String)session.getValue("bl_operational"); 
				if(bl_install_yn == null)   bl_install_yn="";
				 String dflt_disaster_blng_grp_id = "";
				String dflt_slmt_type_code = "";
				String settlement_ind =  "";
				String emer_blng_class_code= "";
				String location_prop= "";
				String service_prop= "";
				String visitType_prop= "";
                /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
				String sql="";
				String  five_level_triage_appl_yn	= (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
				
                /* CRF  SKR-CRF-0021 [IN028173] end  */
				String  max_pat_in_disaster_regn	= (request.getParameter("max_pat_in_disaster_regn")==null || request.getParameter("max_pat_in_disaster_regn")=="")?"0":request.getParameter("max_pat_in_disaster_regn");
				
			
				String pry_zone_for_dis_regn= request.getParameter("pry_zone_for_dis_regn");
				if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
				String un_adult_age_for_dis_regn= request.getParameter("un_adult_age_for_dis_regn");
				if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
				String emer_val_sr              = request.getParameter("emer_val_sr");
				if(emer_val_sr == null)   emer_val_sr="";
				String clinic_code              = request.getParameter("clinic_code");
				if(clinic_code == null)   clinic_code="";
				String service_code             = request.getParameter("service_code");
				if(service_code == null)   service_code="";
				String visit_type                = request.getParameter("visit_type");
				if(visit_type == null)   visit_type="";
				
				//Added below line for this CRF ML-MMOH-CRF-0466				
				String dist_pat_ser_grp = request.getParameter("dist_pat_ser_grp");
				if(dist_pat_ser_grp == null)   dist_pat_ser_grp="";
				
				

/* Thursday, May 20, 2010 PE_EXE
				try{
					pstmt2 = con.prepareStatement("select BILLING_INTERFACED_YN billing_interfaced_yn,DFLT_LOCN_CODE_FOR_DIS_REGN, DFLT_SRVC_CODE_FOR_DIS_REGN,DFLT_PRY_ZONE_FOR_DIS_REGN, DFLT_UN_ADULT_AGE_FOR_DIS_REGN, DFLT_VIS_TYP_CDE_FOR_DIS_REGN from ae_param where operating_facility_id=?");
                    pstmt2.setString(1,facility_id);
					rset1 = pstmt2.executeQuery();
					if (rset1!=null) {
						while (rset1.next()) {
							bl_interface_yn = rset1.getString("billing_interfaced_yn");
							clinic_code = rset1.getString("DFLT_LOCN_CODE_FOR_DIS_REGN");
							if(clinic_code == null)   clinic_code="";
							service_code = rset1.getString("DFLT_SRVC_CODE_FOR_DIS_REGN");
							if(service_code == null)   service_code="";
							visit_type = rset1.getString("DFLT_VIS_TYP_CDE_FOR_DIS_REGN");
							if(visit_type == null)   visit_type="";

							pry_zone_for_dis_regn = rset1.getString("DFLT_PRY_ZONE_FOR_DIS_REGN");
							if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
							un_adult_age_for_dis_regn = rset1.getString("DFLT_UN_ADULT_AGE_FOR_DIS_REGN");
							if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
						}
					}
							 
					if(rset1!=null) rset1.close();
					if(pstmt2!=null) pstmt2.close();

				}catch(Exception ee){ee.printStackTrace();}
							 
				try {                        
                               
					pstmt2 = con.prepareStatement("select site_id from sm_site_param " );
					rset1 = pstmt2.executeQuery() ;
					if(rset1.next())
					Site = rset1.getString(1) ;
					if(rset1!=null) rset1.close();
					if(pstmt2!=null) pstmt2.close();
				}catch(Exception ee){ee.printStackTrace();}

				try{
					String sqlOper="select a.oper_stn_id oper_stn_id from am_oper_stn a, am_user_for_oper_stn b where a.facility_id=? and a.facility_id=b.facility_id and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =? and trunc(sysdate) between b.eff_date_from and  nvl(b.eff_date_to,trunc(sysdate))";
					pstmt=con.prepareStatement(sqlOper);
					pstmt.setString(1,facility_id);
					pstmt.setString(2,loginUser);
					rset=pstmt.executeQuery();
					if(rset != null && rset.next()) {
						operstn	 = (rset.getString("oper_stn_id") == null)?"":rset.getString("oper_stn_id");
					}
					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();

				}catch(Exception e) {
					e.printStackTrace();
				}

				*/
				


			try{
	            con = ConnectionManager.getConnection(request);
				//Added by mano on CRF-0644
				boolean allowSplChar =eCommon.Common.CommonBean.isSiteSpecific(con, "AE","ALLOW_SPLCHAR_DISASTERREF");
				StringBuffer sqlArrival	 = new StringBuffer();
				sqlArrival.append(" select arrival_code, short_desc from am_arrival_lang_vw where facility_id= ? and language_id='"+locale+"' and eff_status='E' order by short_desc "); 


                StringBuffer sqlLocation	  = new StringBuffer();
				//	sqlLocation.append("select a.CLINIC_CODE, a.long_desc SHORT_DESC, c.gender from OP_CLINIC_LANG_VW a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b, am_age_group c  where decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' and a.facility_id = ? and a.language_id = '"+locale+"' and a.clinic_type ='C' and a.level_of_care_ind = 'E'   and a.eff_status = 'E'   and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = a.facility_id and  register_visit_yn = 'Y')  and  a.age_group_code = c.age_group_code(+)  and c.gender is null and (facility_id,clinic_code) in (select facility_id,locn_code from am_locn_for_oper_stn_vw where facility_id =a.facility_id and oper_stn_id =? )order by 2  ");  
				sqlLocation.append("SELECT a.clinic_code, a.long_desc short_desc, c.gender FROM op_clinic_lang_vw a, (SELECT day_no FROM sm_day_of_week WHERE day_of_week = RTRIM (TO_CHAR (SYSDATE, 'DAY'))) b, am_age_group c WHERE DECODE (b.day_no, '1', working_day_1, '2', working_day_2, '3', working_day_3, '4', working_day_4, '5', working_day_5, '6', working_day_6, '7', working_day_7 ) = 'Y' AND a.facility_id = ? AND a.language_id = '"+locale+"' AND a.clinic_type = 'C' AND a.level_of_care_ind = 'E' AND a.eff_status = 'E' AND a.age_group_code = c.age_group_code(+) AND c.gender IS NULL AND (facility_id, clinic_type,clinic_code) IN ( SELECT oper_stn.facility_id, locn_oper_stn.locn_type,locn_oper_stn.locn_code FROM AM_OPER_STN oper_stn , am_locn_for_oper_stn locn_oper_stn WHERE oper_stn.facility_id = a.facility_id AND oper_stn.oper_stn_id = ? AND oper_stn.register_visit_yn = 'Y' AND locn_oper_stn.facility_id = locn_oper_stn.facility_id AND locn_oper_stn.oper_stn_id = locn_oper_stn.oper_stn_id) ORDER BY 2 ");  

				StringBuffer sqlVisitType	  = new StringBuffer();
				sqlVisitType.append("select distinct visit_type_code, visit_type_short_desc from OP_VISIT_TYPE_FOR_CLINIC_VW where visit_type_ind='E'  and eff_status='E'   and clinic_code= ? and FACILITY_ID= ?");

				StringBuffer sqlService	  = new StringBuffer();
                sqlService.append("SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID=? AND C.CLINIC_CODE = ? AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID=?  AND b.CLINIC_CODE=? AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2");




				//sql="select emeg_pat_ser_grp FROM mp_param where module_id='MP'";

				try {
					//pstmt1 = con.prepareStatement(sql) ;
					//rset = pstmt1.executeQuery() ;
					//if(rset!=null) 

					

Properties p;		
	p = (Properties) session.getValue("jdbc");
	String userId				= (String)session.getAttribute("login_user");
	HashMap hashMap		= new HashMap();
	hashMap = eMP.ChangePatientDetails.getSetupData(facility_id,"",con,p);
	String pat_ser_access_by_user_yn = checkForNull((String)hashMap.get("PAT_SER_ACCESS_BY_USER_YN"));
	
	String userAccessSql	= "";
	if(pat_ser_access_by_user_yn.equals("Y")){
		userAccessSql	= " and pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM MP_PAT_SER_GRP_FOR_USER WHERE APPL_USER_ID = '"+userId+"') ";
	}






					if(emer_val_sr!=null) 
					//sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in('E','U') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?))) order by 2");
					
					sqlbuf.append("select pat_ser_grp_code, short_desc,id_type,pat_name_in_loc_lang_reqd_yn, prefix_reqd_yn from mp_pat_ser_grp_lang_vw where language_id='"+locale+"'  and  gen_pat_id_yn = 'Y' and gen_pid_using_alt_id1_rule_yn = 'N' and id_type in ('E', 'U','G','N') and (pat_ser_grp_code in (select pat_ser_grp_code from mp_pat_ser_facility where  site_or_facility_id = decode(site_or_facility,'S',?,'F',?) and used_status = 'N' ))  "+userAccessSql+" order by 2");
						

                    pstmt3 = con.prepareStatement(sqlbuf.toString()); 
				
					//while(rset.next()) { 
						pstmt3.setString(1,Site);
						pstmt3.setString(2,facility_id);
                        rs = pstmt3.executeQuery( );
                        out.println("<select name='pat_ser_grp_code' id='pat_ser_grp_code'>");
						out.println( "<option value=''>----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----</Option>" ) ;  
						if(rs !=null)  {
							while(rs.next())  {
								String sel ="" ;
								
							if(dist_pat_ser_grp.equals("")){
                                if(emer_val_sr.equals((rs.getString(1) == null ? "" :rs.getString(1)) ))
							      sel = "selected" ;
								  
                                  out.println( "<Option value=\""+rs.getString(1)+"\" "+sel+">"+rs.getString(2)+"</Option>" ) ;
							}else{
							   /*Above line commented and Below line added for this CRF ML-MMOH-CRF-0466*/
							    if(dist_pat_ser_grp.equals((rs.getString(1) == null ? "" :rs.getString(1)) )) 
									sel = "selected" ;
									
                                out.println( "<Option value=\""+rs.getString(1)+"\" "+sel+">"+rs.getString(2)+"</Option>" ) ;
							}
                            }
                         }
						out.println("</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>");
						if(rs!=null) rs.close();
						//if(pstmt3!=null) pstmt3.close();
					//}// END of While..........
					if(pstmt3!=null) pstmt3.close();
					sqlbuf.setLength(0);
					//if(rset!=null) rset.close();
					//if(pstmt1!=null) pstmt1.close(); 
                }catch(Exception e) {e.printStackTrace();}
            %>
            </td>
			<td width='25%' class='label' nowrap><fmt:message key="Common.PriorityZone.label" bundle="${common_labels}"/></td>
			<td class='fields'  width='25%'><select name='priority_zone' id='priority_zone'>
         <option value="">-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option> 
			<!-- below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] -->
			 <% if(pry_zone_for_dis_regn.equals("") || !pry_zone_for_dis_regn.equals("") ){
			 
			   
	  sql="SELECT PRIORITY_ZONE,PRIORITY_ZONE_DESC FROM AE_PRIORITY_ZONE_LANG_VW WHERE LANGUAGE_ID= ? and EFF_STATUS='E'";
		if(!five_level_triage_appl_yn.equals("Y")){
				sql	= sql + "  and priority_zone not in ('B','W') ";
		}
			sql= sql + " order by PRIORITY_ZONE_ORDER asc"; 
			     pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,locale) ;
			    rset    = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
				 out.println("<option value='"+rset.getString(1)+"'>");	     
			   out.println(rset.getString(2));
			   out.println("</option>"); 
				}

			  if(pstmt!=null) pstmt.close();
			  if(rset!=null)rset.close();
			  
			   %>
		           
		      <%}%> 
	      <!--CRF  SKR-CRF-0021 [IN028173] end-->

		   </select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>
	</table>
	<br>

	<table width='90%' cellpadding='0' cellspacing='0' border='1' align='center' colspan=7 >		
		<tr>
			 <td  width='10%'>&nbsp;</td><td class = 'label'  colspan=2 align='center'>&nbsp;<b><fmt:message key="Common.Adult.label" bundle="${common_labels}"/>&nbsp;</td>
			<td  class = 'label' colspan=2 align='center'>&nbsp;<b><fmt:message key="eMP.child.label" bundle="${mp_labels}"/>&nbsp;</td>
			<td  class = 'label' colspan=2 align='center'>&nbsp;<b><fmt:message key="eAE.Infant.label" bundle="${ae_labels}"/>&nbsp;</td>
		</tr>
		<tr> </tr>     
		<tr> 
			<td class = 'label' align='right'><b><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
			<td  class = 'label' align='center' width='10%'><b><fmt:message key="eAE.NoofPatients.label" bundle="${ae_labels}"/></td>
			<td  class = 'label' align='center' width='10%'><b><fmt:message key="eAE.EstdAge.label" bundle="${ae_labels}"/>&nbsp;</td>
			<td  class = 'label' align='center' width='10%'>&nbsp;<b><fmt:message key="eAE.NoofPatients.label" bundle="${ae_labels}"/></td>
			<td  class = 'label' align='center' width='10%'><b><fmt:message key="eAE.EstdAge.label" bundle="${ae_labels}"/>&nbsp;</td> 
			<td  class = 'label' align='center' width='10%'><b><fmt:message key="eAE.NoofPatients.label" bundle="${ae_labels}"/></td>
			<td  class = 'label' align='center' width='10%'><b><fmt:message key="eAE.EstdAge.label" bundle="${ae_labels}"/>&nbsp;</td>
		 </tr>		 
		 <tr>
			<td class='label' align='right' width='10%'><b><fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;</b></td>
			<td class='label' align='center'><input type='textbox' name='adultmale' id='adultmale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adult(adultmale,adultmaleage_y)' tabindex=1></td>
			<td class='label' align='center'><input type='textbox' name='adultmaleage_y' id='adultmaleage_y' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adultmaleage(this,adultmale)' tabindex=2><b>Y</b></td>		
			<td class='label' align='center'> 
				<input type='textbox' name='childmale' id='childmale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_child(childmale,childmaleage_y)' tabindex=3></td>
			<td class='label' ><input type='textbox' name='childmaleage_y' id='childmaleage_y' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_childmaleage(this,childmale)'tabindex=4><b>Y</b></td>		
			<td class='label' align='center'>
				<input tabindex=6 type='textbox' name='infantmale' id='infantmale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_infant(infantmale,infantmaleage_d)'></td>
			<td class='label' ><input tabindex=7 type='textbox' name='infantmaleage_m' id='infantmaleage_m' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onBlur='setage_infantmaleage(this,infantmale,infantmaleage_d);return allowValidMonth(this);'><b>M</b><input tabindex=8 type='textbox' name='infantmaleage_d' id='infantmaleage_d' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);"
		    onBlur='setage_infantmaleage(this,infantmale,infantmaleage_m);return allowValidDate(this,event,20, 0);'><b>D</b></td> 
		 </tr>
		 <tr>
			 <td class='label' align='right' width='10%'><b><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;</b></td>
			 <td class='label' align='center' ><input tabindex=9 type='textbox' name='adultfemale' id='adultfemale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adultF(adultfemale,adultfemaleage_y)'></td> 
			 <td class='label' align='center'><input tabindex=10 type='textbox' name='adultfemaleage_y' id='adultfemaleage_y' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adultfemaleage(this,adultfemale)' ><b>Y</b></td>		
			<td class='label' align='center'> 
				<input tabindex=11 type='textbox' name='childfemale' id='childfemale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_childF(childfemale,childfemaleage_y)'></td>
			<td class='label'  ><input tabindex=12 type='textbox' name='childfemaleage_y' id='childfemaleage_y' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_childfemaleage(this,childfemale)'><b>Y</b></td>		
			<td class='label' align='center'> 
				<input type='textbox'  tabindex=14 name='infantfemale' id='infantfemale' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);"  onblur='setage_infantF(infantfemale,infantfemaleage_d)'></td>
			<td class='label' ><input tabindex=15 type='textbox' name='infantfemaleage_m' id='infantfemaleage_m' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);"onBlur='setage_infantfemaleage(this,infantfemale,infantfemaleage_d);return allowValidMonth(this);'><b>M</b><input type='textbox'  tabindex=16 name='infantfemaleage_d' id='infantfemaleage_d' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onBlur='setage_infantfemaleage(this,infantfemale,infantfemaleage_m);return allowValidDate(this,event,20, 0);'><b>D</b></td>
		 </tr>
         <tr>
			 <td class='label' align='right' width='10%'><b><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>&nbsp;</b></td>
			<td class='label' align='center' ><input tabindex=17 type='textbox' name='adultunknown' id='adultunknown' size='3' maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adultU(adultunknown,adultunknownage_y)'></td>
			<td class='label' align='center' ><input type='textbox' tabindex=18 name='adultunknownage_y' id='adultunknownage_y' size='3' maxlength='3' value="<%=un_adult_age_for_dis_regn%>" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_adultunknownage(this,adultunknown)'><b>Y</b></td>	
			<td class='label' align='center'> 
				<input type='textbox' name='childunknown' id='childunknown' size='3' tabindex=19 maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_childU(childunknown,childunknownage_y)'></td>
			<td class='label' ><input tabindex=20 type='textbox' name='childunknownage_y' id='childunknownage_y' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_childunknownage(this,childunknown)'><b>Y</b></td>	
			<td class='label' align='center'>
				<input type='textbox' name='infantunknown' id='infantunknown' size='3'  tabindex=22 maxlength='3' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onblur='setage_infantU(infantunknown,infantunknownage_d)'></td>
			<td class='label' ><input type='textbox' name='infantunknownage_m' id='infantunknownage_m'  tabindex=23 size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onBlur='setage_infantunknownage(this,infantunknown,infantunknownage_d);return allowValidMonth(this);'><b>M</B><input type='textbox'  tabindex=24 name='infantunknownage_d' id='infantunknownage_d' size='2' maxlength='2' value="" onkeypress="return allowValidNumber1(this,event,20, 0);" onBlur='setage_infantunknownage(this,infantunknown,infantunknownage_m);return allowValidDate(this,event,20, 0);'><b>D</B></td>
		 </tr>	 		 		
	</table>
	<br>

	<table width='90%' cellpadding='2' cellspacing='0' border='0' align='center'>

		<tr>
		<%
		if(allowSplChar)
		{
			%>
		<td class='label' ><fmt:message key="eAE.DisasterReference.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'><input type="text" name='Disaster_Reference' id='Disaster_Reference'  
             maxLength='15' value='' onKeyPress="return CheckForSpecChar(event)"  onblur = "SpeCharCheck(this)">&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
		}
		else
		{
			%>
			<td class='label' ><fmt:message key="eAE.DisRegnReference1.label" bundle="${ae_labels}"/></td>
			 <td class='fields' width='25%'><input type="text" name='Disaster_Reference' id='Disaster_Reference'  
             maxLength='15' value='' onKeyPress="return CheckForSpecChars(event)"  onblur = "SpeCharCheck(this)">&nbsp;<img  src='../../eCommon/images/mandatory.gif'></img></td>
             <td class='label' colspan='2'>&nbsp;</td>
			 <%
		}
		%>
			<input type='hidden' name='allowSplChar' id='allowSplChar' value="<%=allowSplChar%>"></input>
			
           </tr>
		<tr>
			<td class='label'  width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class='field'  colspan='3'>
    		 <textarea  name='remarks' cols='50'   align='left'  onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,200);'></textarea>


		</tr> 
	</table>
	<br>

    <table width='90%' cellpadding='2' cellspacing='0' border='0' align='center'>
		<tr>
			<td class='label'  width='25%' nowrap><fmt:message key="eAE.CreateAttendanceDetails.label" bundle="${ae_labels}"/></td>
			<td class='field'  width='25%'><input type='checkbox'  name='creat_attn_detail_yn' id='creat_attn_detail_yn' onClick='chkValue(this);' value="N"></td>
            <td class='label'  colspan='2'>&nbsp;</td>
		</tr>
		<%if(bl_install_yn.equals("Y")){%>
		<tr>
			<td class='label'  width='25%' nowrap><fmt:message key="Common.CaptureFinancialDetails.label" bundle="${common_labels}"/></td>
			<td class='field'  width='25%'><input type='checkbox'  name='CaptureFinancialDetails' id='CaptureFinancialDetails' onClick='chkValue2(this);' value="N"></td>
            <td class='label'  colspan='2'>&nbsp;</td>
		</tr>
		<%}else{%>
		<input type='hidden' name='CaptureFinancialDetails' id='CaptureFinancialDetails' value="N">
		<% }%>
		<tr>
            <td class='label' width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
            <td class='field' width='25%'>
            <select name='clinic_code' id='clinic_code' onchange="populateVisitType(this)" ><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
                <%	
				try {

				   pstmt = con.prepareStatement(sqlLocation.toString());
				   pstmt.setString(1,facility_id);
				   pstmt.setString(2,operstn);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   int counter = 1; 
				   //boolean rec_exists=false;
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);

						if(clinic_code.equals(code))	
			            {
							
							location_prop				=	"selected";
						}
						else
						{
							
							location_prop				=	"";
						}
  						if(counter==1){ counter=0;}
            %>
			<option value='<%=code%>' > <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				if((sqlLocation != null) && (sqlLocation.length() > 0))
				 {
					sqlLocation.delete(0,sqlLocation.length());
				 }

			    }catch (Exception e){e.printStackTrace();}
				finally {
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
				}
            %>
			</select>&nbsp;<img id='mand1' src='../../eCommon/images/mandatory.gif'></img></td>
				<td class='label'  colspan='2'>&nbsp;</td>
		</tr>
		<tr>
			<td class='label'  width='25%'><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
			<td class='field' width='25%'><select name='service_code' id='service_code' ><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option> 
			<%
				if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlService.toString());
				   pstmt.setString(1,facility_id);
				   pstmt.setString(2,clinic_code);
				   pstmt.setString(3,facility_id);
				   pstmt.setString(4,clinic_code);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(service_code.equals(code))	
			            {
							service_prop				=	"selected";
						}
						else
						{
							service_prop				=	"";
						}
            %>
			<option value='<%=code%>' > <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){e.printStackTrace();}
				if((sqlService != null) && (sqlService.length() > 0))
				 {
					sqlService.delete(0,sqlService.length());
				 }
			}
			%>
			
			</select><img id='mand2' src='../../eCommon/images/mandatory.gif'></img></select>
		</td>
		<td class='label'  colspan='2'>&nbsp;</td>
		</tr>

		<tr>
			<td class=label width='25%'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td class='field' width='25%'>
					<select name='visit_type' id='visit_type' ><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			
<%
			if((!clinic_code.equals("")))
				{
				  try {
				   pstmt = con.prepareStatement(sqlVisitType.toString());
				   pstmt.setString(1,clinic_code);
				   pstmt.setString(2,facility_id);
				   rset = pstmt.executeQuery();
				   String code = "";
				   String desc = "";
				   while(rset!=null && rset.next()) {
  						code = rset.getString(1);
						desc = rset.getString(2);
						if(visit_type.equals(code))	
			            {
							visitType_prop	   =	"selected";
						}
						else
						{
							visitType_prop				=	"";
						}
            %>
			<option value='<%=code%>' > <%=desc%></option>
            <%
				   }
					if(pstmt!=null) pstmt.close();
					if(rset!=null)rset.close();
			    }catch (Exception e){e.printStackTrace();}
				if((sqlVisitType != null) && (sqlVisitType.length() > 0))
				 {
					sqlVisitType.delete(0,sqlService.length());
				 }
			}
			%>
			</select><img id='mand3' src='../../eCommon/images/mandatory.gif'></img>
			<td class='label'  colspan='2'>&nbsp;</td>
		</tr>

		<tr>
			<td class='label' ><fmt:message key="Common.ModeofArrival.label" bundle="${common_labels}"/></td>
			<td class='field'  width='25%'>
					<select name='arrival_mode' id='arrival_mode'><option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
			<%
				try {	
					pstmt = con.prepareStatement(sqlArrival.toString());
	   				pstmt.setString(1,facility_id);
					rset = pstmt.executeQuery();
					while(rset!=null && rset.next()) {
						out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
					}
					sqlArrival.setLength(0);
					sqlLocation.setLength(0);
				    if(pstmt!=null) pstmt.close();
 			        if(rset!=null) rset.close();
				}catch (Exception e) {e.printStackTrace();}
				
			%>
            </select>
            </td>
			<td class='label'  colspan='2'>&nbsp;</td>
        </tr>
	    <tr><td colspan=4 class=label height=5></td></tr>
	</table>
	<input type='hidden' name='module_id' id='module_id' id='module_id' value='<%=module_id%>' />
	<input type='hidden' name='max_pat_in_disaster_regn' id='max_pat_in_disaster_regn' value="<%=max_pat_in_disaster_regn%>"></input>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='site' id='site' value='<%=Site%>'>
	<input type='hidden' name='retValue' id='retValue' value=''> 
  	<input type='hidden' name='treatment_area' id='treatment_area'>
	<input type='hidden' name='reasonForVisit' id='reasonForVisit'>
	<input type='hidden' name='cancel_mode' id='cancel_mode' value=''>
  	<input type='hidden' name='BLValue' id='BLValue' value=''>
	 
	<input type='hidden' name='bl_interface_yn' id='bl_interface_yn' value="<%=bl_interface_yn%>"> 
	<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"> 
	<input type='hidden' name='is_financial_captured' id='is_financial_captured' value=""> 
	<%if(localeName.equals("en"))
	{%>
	<input type="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N">
	<%}
  else if(localeName.equals("th"))
	{%>
	<input type="hidden" name="p_passing_local_date" id="p_passing_local_date" value="Y">
  <%}%>
  <input type="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	

<%
	try
	{
	if (bl_install_yn.equals("Y"))
	{
		String sqlBL ="select DFLT_DISASTER_BLNG_GRP_ID,DFLT_SLMT_TYPE_CODE, SETTLEMENT_IND,DFLT_PAT_REGN_BLNG_CLASS from bl_mp_param a, BL_BLNG_GRP b where a.DFLT_DISASTER_BLNG_GRP_ID=b.BLNG_GRP_ID";
		stmt = con.createStatement();
		rset = stmt.executeQuery(sqlBL);
	 	
		if(rset!=null && rset.next())
		{
			dflt_disaster_blng_grp_id = rset.getString("DFLT_DISASTER_BLNG_GRP_ID");
		 if(dflt_disaster_blng_grp_id == null)   dflt_disaster_blng_grp_id="";
			dflt_slmt_type_code = rset.getString("DFLT_SLMT_TYPE_CODE");
			if(dflt_slmt_type_code == null)   dflt_slmt_type_code="";
			settlement_ind = rset.getString("SETTLEMENT_IND");
			if(settlement_ind == null)   settlement_ind="";
			emer_blng_class_code=rset.getString("DFLT_PAT_REGN_BLNG_CLASS");
			if(emer_blng_class_code == null)   emer_blng_class_code="";
		}
		if(rset!=null)	rset.close();
        if(stmt!=null)	stmt.close();

%>
	


	<jsp:include page="../../eBL/jsp/BLFinDetHiddenFlds.jsp" flush="true">
    <jsp:param name="dflt_disaster_blng_grp_id" value="<%=dflt_disaster_blng_grp_id%>" />
    <jsp:param name="dflt_slmt_type_code" value="<%=dflt_slmt_type_code%>" />
    <jsp:param name="settlement_ind" value="<%=settlement_ind%>" />
	<jsp:param name="calling_module" value="AE" />
    <jsp:param name="emer_blng_class_code" value="<%=emer_blng_class_code%>" />
	<jsp:param name="disaster_regn_YN" value="Y" />
    <jsp:param name="episode_type" value="E" />
    <jsp:param name="calling_function_id" value="VISIT_REGISTRATION" />
    </jsp:include> 
	<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=""></input>
	<input type='hidden' name='bl_success' id='bl_success' value="N"></input>
	<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
	<input type='hidden' name='called_from' id='called_from' value="PatRegForm"></input>
	<input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value=""></input>
	<input type='hidden' name='change_data_source' id='change_data_source' value=""></input>	
	<input type='hidden' name='un_adult_age_for_dis_regn' id='un_adult_age_for_dis_regn' value="<%=un_adult_age_for_dis_regn%>"></input>
	<input type='hidden' name='visit_type_dflt' id='visit_type_dflt' value="<%=visit_type%>"></input>
	<input type='hidden' name='clinic_code_dflt' id='clinic_code_dflt' value="<%=clinic_code%>"></input>
	<input type='hidden' name='service_code_dflt' id='service_code_dflt' value="<%=service_code%>"></input>
	
<%
	}
	else
	{
%>
	<!-- Added For Billing -->
	<input type='hidden' name='billing_group' id='billing_group' value=""></input>
	<input type='hidden' name='billing_class' id='billing_class' value=""></input>
	<input type='hidden' name='employer_code' id='employer_code' value=""></input>
	<input type='hidden' name='cash_set_type1' id='cash_set_type1' value=""></input>
	<input type='hidden' name='cash_insmt_ref1' id='cash_insmt_ref1' value=""></input>
	<input type='hidden' name='cash_insmt_date1' id='cash_insmt_date1' value=""></input>
	<input type='hidden' name='cash_insmt_rmks1' id='cash_insmt_rmks1' value=""></input>
	<input type='hidden' name='cust_1' id='cust_1' value=""></input>
	<input type='hidden' name='credit_doc_ref1' id='credit_doc_ref1' value=""></input>
	<input type='hidden' name='credit_doc_date1' id='credit_doc_date1' value=""></input>
	<input type='hidden' name='cust_2' id='cust_2' value=""></input>
	<input type='hidden' name='credit_doc_ref2' id='credit_doc_ref2' value=""></input>
	<input type='hidden' name='credit_doc_date2' id='credit_doc_date2' value=""></input>
	<input type='hidden' name='cust_3' id='cust_3' value=""></input>
	<input type='hidden' name='policy_type' id='policy_type' value=""></input>
	<input type='hidden' name='policy_no' id='policy_no' value=""></input>
	<input type='hidden' name='policy_expiry_date' id='policy_expiry_date' value=""></input>
	<input type='hidden' name='non_insur_blng_grp' id='non_insur_blng_grp' value=""></input>
	<input type='hidden' name='cash_set_type2' id='cash_set_type2' value=""></input>
	<input type='hidden' name='cash_insmt_ref2' id='cash_insmt_ref2' value=""></input>
	<input type='hidden' name='cash_insmt_date2' id='cash_insmt_date2' value=""></input>
	<input type='hidden' name='cash_insmt_rmks2' id='cash_insmt_rmks2' value=""></input>
	<input type='hidden' name='cust_4' id='cust_4' value=""></input>
	<input type='hidden' name='credit_doc_ref3' id='credit_doc_ref3' value=""></input>
	<input type='hidden' name='credit_doc_date3' id='credit_doc_date3' value=""></input>
	<input type='hidden' name='setlmt_ind' id='setlmt_ind' value=""></input>
	<input type='hidden' name='upd_fin_dtls' id='upd_fin_dtls' value=""></input>
	<input type='hidden' name='credit_auth_ref' id='credit_auth_ref' value=""></input>
	<input type='hidden' name='credit_auth_date' id='credit_auth_date' value=""></input>
	<input type='hidden' name='app_days' id='app_days' value=""></input>
	<input type='hidden' name='app_amount' id='app_amount' value=""></input>
	<input type='hidden' name='health_card_expired_yn' id='health_card_expired_yn' value=""></input>
	<input type='hidden' name='annual_income' id='annual_income' value=""></input>
	<input type='hidden' name='family_asset' id='family_asset' value=""></input>
	<input type='hidden' name='no_of_dependants' id='no_of_dependants' value=""></input>
	<input type='hidden' name='resp_for_payment' id='resp_for_payment' value=""></input>
	<input type='hidden' name='credit_doc_reqd_yn1' id='credit_doc_reqd_yn1' value=""></input>
	<input type='hidden' name='credit_doc_reqd_yn2' id='credit_doc_reqd_yn2' value=""></input>
	<input type='hidden' name='bl_operation' id='bl_operation' value=''></input>
	<input type='hidden' name='cred_start_dt1' id='cred_start_dt1' value=""></input>  
	<input type='hidden' name='cred_start_dt2' id='cred_start_dt2' value=""></input>  
	<input type='hidden' name='cred_start_dt3' id='cred_start_dt3' value=""></input>  
	<input type='hidden' name='gl_holder_name' id='gl_holder_name' value=""></input>  
	<input type='hidden' name='gl_holder_reln' id='gl_holder_reln' value=""></input>
	<input type='hidden' name='eff_frm_date' id='eff_frm_date' value=""></input>
	<input type='hidden' name='bl_success' id='bl_success' value="N"></input>
	<input type='hidden' name='billing_mode' id='billing_mode' value='Add'></input>
	<input type='hidden' name='alt_exp_date_fromHCS' id='alt_exp_date_fromHCS' value="N"></input>
	<input type='hidden' name='called_from' id='called_from' value="PatRegForm"></input>
	<input type='hidden' name='dflt_pat_regn_blng_class' id='dflt_pat_regn_blng_class' value=""></input>
	<input type='hidden' name='remarks' id='remarks' value=""></input> 
	<input type='hidden' name='change_data_source' id='change_data_source' value=""></input> 
	<input type='hidden' name='un_adult_age_for_dis_regn' id='un_adult_age_for_dis_regn' value="<%=un_adult_age_for_dis_regn%>"></input>
	<input type='hidden' name='visit_type_dflt' id='visit_type_dflt' value="<%=visit_type%>"></input>
	<input type='hidden' name='clinic_code_dflt' id='clinic_code_dflt' value="<%=clinic_code%>"></input>
	<input type='hidden' name='service_code_dflt' id='service_code_dflt' value="<%=service_code%>"></input>

	



 <%
	}
	 }
	catch(Exception e)
	{
		e.printStackTrace();
	}
	 }catch (Exception e) {e.printStackTrace();}
   finally
      {
  	    ConnectionManager.returnConnection(con,request);
      }
 %>	
   <script>
   /* below lines are add by venkateshs on 29/06/2012 against  the crf  SKR-CRF-0021 [IN028173] */
    var pry_zone_for_dis_regn ="<%=pry_zone_for_dis_regn%>";
	 if (pry_zone_for_dis_regn !=""){  
		 var drop_down = document.forms[0].priority_zone;
		 for (var i = 0; i < drop_down.options.length; i++){
		   if (drop_down.options[i].value == pry_zone_for_dis_regn){
		    drop_down.selectedIndex = i;}}}	
   /* CRF  SKR-CRF-0021 [IN028173] end  */
  </script>

   </form>
	</body>
	<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}
%>
	</html> 

