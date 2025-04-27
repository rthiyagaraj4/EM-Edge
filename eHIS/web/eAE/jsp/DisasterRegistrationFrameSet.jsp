<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script language='javascript' src='../../eAE/js/DisasterPatient.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
	
	String module_id				= request.getParameter("module_id");
	
	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String user_id 	 	= (String)session.getValue("login_user") ;
	
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	Connection con                  =   null;
	// Thursday, May 20, 2010 PE_EXE venkat s
	String OsVal				="";
	String billing_interfaced_yn = "";
	String clinic_code			= "";
	String service_code			= "";
	String visit_type			= "";
	String pry_zone_for_dis_regn			= "";
	String un_adult_age_for_dis_regn		= "";
	String Site								= "";
	String emer_val_sr					    = "";
	String five_level_triage_appl_yn		= "N";
	int max_pat_in_disaster_regn			= 0;
	
	String dist_pat_ser_grp=""; //Added for this CRF ML-MMOH-CRF-0466


	try{
            con=ConnectionManager.getConnection(request);
			//Below query modified for this CRF ML-MMOH-CRF-0466
			String sql = " select  billing_interfaced_yn billing_interfaced_yn, dflt_locn_code_for_dis_regn, dflt_srvc_code_for_dis_regn, dflt_pry_zone_for_dis_regn, dflt_un_adult_age_for_dis_regn, dflt_vis_typ_cde_for_dis_regn, AM_OPER_STN_ACCESS_CHECK('"+fac_id+"','"+user_id+"','C','','REGISTER_VISIT_YN') OsVal, (SELECT site_id FROM sm_site_param) site_id, (SELECT emeg_pat_ser_grp FROM mp_param WHERE module_id = 'MP') emer_val ,five_level_triage_appl_yn,max_pat_in_disaster_regn,dist_pat_ser_grp from ae_param  where OPERATING_FACILITY_ID=?"; // Thursday, May 20, 2010 PE_EXE venkat s

			pstmt  = con.prepareStatement(sql);
			pstmt.setString(1,fac_id);
			rs = pstmt.executeQuery();
			if (rs ==null || !rs.next()) 
			{
               out.println("<script>alert(getMessage('AE_PARAM_NOT_FOUND','AE'));document.location.href= '../../eCommon/jsp/dmenu.jsp'</script>");
			}
			else{
					five_level_triage_appl_yn	= (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");	
					max_pat_in_disaster_regn	= rs.getInt("max_pat_in_disaster_regn");
					
					//Added for this CRF ML-MMOH-CRF-0466
					dist_pat_ser_grp=rs.getString("dist_pat_ser_grp");
					if(dist_pat_ser_grp == null)   dist_pat_ser_grp="";
					
					OsVal=rs.getString("OsVal");
					params  = params+"&operstn="+OsVal;
					billing_interfaced_yn=rs.getString("billing_interfaced_yn");
					params  = params+"&billing_interfaced_yn="+billing_interfaced_yn;
					clinic_code=rs.getString("dflt_locn_code_for_dis_regn");
					if(clinic_code == null)   clinic_code="";
					params  = params+"&clinic_code="+clinic_code;
					service_code=rs.getString("dflt_srvc_code_for_dis_regn");
					if(service_code == null)   service_code="";
					params  = params+"&service_code="+service_code;
					visit_type=rs.getString("dflt_vis_typ_cde_for_dis_regn");
					if(visit_type == null)   visit_type="";
					params  = params+"&visit_type="+visit_type;
					pry_zone_for_dis_regn=rs.getString("dflt_pry_zone_for_dis_regn");
					if(pry_zone_for_dis_regn == null)   pry_zone_for_dis_regn="";
					params  = params+"&pry_zone_for_dis_regn="+pry_zone_for_dis_regn;
					un_adult_age_for_dis_regn=rs.getString("DFLT_UN_ADULT_AGE_FOR_DIS_REGN");
					if(un_adult_age_for_dis_regn == null)   un_adult_age_for_dis_regn="";
					params  = params+"&un_adult_age_for_dis_regn="+un_adult_age_for_dis_regn;
					Site =rs.getString("site_id");
					if(Site == null)   Site="DS";
					params  = params+"&Site="+Site;	
					emer_val_sr=rs.getString("emer_val");
					params  = params+"&emer_val_sr="+emer_val_sr;
					//Below line modified for this CRF ML-MMOH-CRF-0466
					params  = params+"&module_id="+module_id+"&five_level_triage_appl_yn="+five_level_triage_appl_yn+"&max_pat_in_disaster_regn="+max_pat_in_disaster_regn+"&dist_pat_ser_grp="+dist_pat_ser_grp;	
									  

					if(OsVal.equals("1"))
						{
							out.print(" <script>alert(getMessage('AE_NO_OPER_STN_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else if(OsVal.equals("2"))
						{
							out.print(" <script>alert(getMessage('AE_NO_CLINICS_FOR_USER','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("3"))
						{
							out.print(" <script>alert(getMessage('AE_REG_ATTN_NOT_ALL_OPERSTN','AE'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("4"))
						{
							out.print(" <script>alert(getMessage('NOT_VALID','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}else  if(OsVal.equals("5"))
						{
							out.print(" <script>alert(getMessage('INVALID_OPER_STN_ACCESS','Common'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
						}
						else if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")) && (!OsVal.equals("5")))
						{				   

							 %>
								</head>
								<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
									<iframe name='f_query_add_mod' id='f_query_add_mod' src='DisasterRegistrationMain.jsp?params=<%=params%>' frameborder=0  scrolling='auto' style='height:83vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
							 <%			
					   }
					}
                if(rs != null)  rs.close();
		        if(pstmt != null) pstmt.close(); 
			   }catch(Exception e) {e.printStackTrace();}
			   finally
					{
						ConnectionManager.returnConnection(con,request);
					}%>
</html>

