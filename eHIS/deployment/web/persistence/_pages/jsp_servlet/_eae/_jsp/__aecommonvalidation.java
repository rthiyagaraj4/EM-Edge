package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.ConnectionManager;

public final class __aecommonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eae/jsp/AEcommonValidation.jsp", 1729154088645L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);


Connection conn = null;

try {
	
	conn=ConnectionManager.getConnection(request);
	conn.setAutoCommit(false);

	CallableStatement cs = null;
	PreparedStatement pstmt	  = null;
	ResultSet rs		  = null;

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");

	String facilityid=(String)session.getValue("facility_id"); 
	String locale = (String)session.getValue("LOCALE");

	String bl_install_yn			= (String)session.getValue("bl_operational"); 
    if(bl_install_yn == null)   bl_install_yn="";

	String callfunc=checkForNull(request.getParameter("callfunc"));
	String sou_value			 = checkForNull(request.getParameter("sou_value"));

	//Below Added by Suji Keerthi for ML-MMOH-CRF-1527 US008
	Boolean resiAddMailAdd = false;
	resiAddMailAdd   	=eCommon.Common.CommonBean.isSiteSpecific(conn, "MP","BMI_REG_PAT_CHNGES_RH101");
	
	//String NatIdFlag=checkForNull(request.getParameter("NatIdFlag")); for CS Thursday, May 13, 2010
	

	if(callfunc.equals("bedChargeAEChkOut")) {

		try {
				
		   /*Ae_bed_calculation from AECheckout Transactoion Date: Thursday, September 17, 2009 crf- 00365	 */
		 
			String validAmtErr="";
			int noofdecimal=0;
	
			String P_patient_id=checkForNull(request.getParameter("patient_id"));	
			String p_encounter_id=checkForNull(request.getParameter("encounterId"));
			String p_episode_type=checkForNull(request.getParameter("episode_type"));
			String p_episode_id=checkForNull(request.getParameter("episode_id"));
			String p_visit_id=checkForNull(request.getParameter("visit_id"));
			String	p_user_id	=  (String) session.getValue("login_user");	
			String bedCharCmt=checkForNull(request.getParameter("bedCharCmt"));	
			
			/* Previously  ae_post_chrg_auto_check this value getting from below quey*/
			//String sqlAuto="select nvl(a.ae_post_chrg_auto_check,'N') ae_post_chrg_auto_check,nvl(b.no_of_decimal,2) noofdecimal from bl_parameters a, sm_acc_entity_param b where operating_facility_id=?";
	
			/* This block used for the calculating the Number of decimal */
	
			try {
	
				String sqlAuto="select nvl(no_of_decimal,2) noofdecimal from sm_acc_entity_param ";
	
				pstmt = conn.prepareStatement(sqlAuto);
				rs = pstmt.executeQuery();
	
				while(rs.next()) {				
				noofdecimal  =  rs.getInt("noofdecimal");	
				}
	
				if(rs!=null)rs.close();		
				if(pstmt!=null)pstmt.close(); 
			}
			catch(Exception ex) {
				ex.printStackTrace();	
			}
					
			try {
			 	if(bl_install_yn.equals("Y")) {// added for billing 
			 		
					String sqlbl = "{call bl_ae_bed_calc.ae_bed_calculation(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
					cs = conn.prepareCall(sqlbl);
					cs.setString(1, facilityid);
					cs.setString(2, p_episode_type);
					cs.setString(3, p_episode_id);
					cs.setString(4,  p_visit_id);
					cs.setString(5,  p_encounter_id);
					cs.setString(6, P_patient_id);
					cs.setString(7, "N");
					cs.setString(8, "S");
					cs.setString(9, p_user_id);
								
					cs.registerOutParameter(10,  java.sql.Types.VARCHAR);
					cs.registerOutParameter(11,  java.sql.Types.VARCHAR);
					cs.registerOutParameter(12, java.sql.Types.VARCHAR);
					cs.registerOutParameter(13, java.sql.Types.VARCHAR);
					cs.registerOutParameter(14, java.sql.Types.VARCHAR);
		
					cs.execute();			
		
					String p_charge_net_amt = cs.getString(10);
					if(p_charge_net_amt==null) p_charge_net_amt="";	
					
					String p_patient_payble = cs.getString(11);
					if(p_patient_payble==null) p_patient_payble="";	
					
					String err_level = cs.getString(12);
					String sys_message_id = cs.getString(13);
					String err_text = cs.getString(14);
		
					if(err_level==null) err_level="";	
					if(sys_message_id==null) sys_message_id="";	
					if(err_text==null) err_text="";  
					
					
					if(cs != null)cs.close();
				
					/*if(err_level.equals("0")){
						err_level="";
					}*/
			
	
					if((err_level.equals("10") && !err_level.equals("")) || !sys_message_id.equals("")){
		
						if (err_level.equals("10") && !err_level.equals("")) {
		
							String final_message="";
							final_message=err_text;
							validAmtErr="err";
							out.println(validAmtErr+"&^&"+final_message);
						}
		
						if(!sys_message_id.equals("")) {
		
							String final_message="";
							java.util.Locale loc = new java.util.Locale(locale);
							java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
							final_message = (String) messages.getString(sys_message_id);
	
	
							validAmtErr="err";
							out.println(validAmtErr+"&^&"+final_message);
						}
					}
					else 
					{
		
					//String  finalAmt=String.valueOf(p_charge_net_amt);
					//String  patient_payble=String.valueOf(p_patient_payble);
		
						String  finalAmt=p_charge_net_amt;
						String  patient_payble=p_patient_payble;
		
						CurrencyFormat cf = new CurrencyFormat();
		
						String final_message = cf.formatCurrency(finalAmt, noofdecimal);
						String patientPayble = cf.formatCurrency(patient_payble, noofdecimal);
		
						if(bedCharCmt.equals("Y"))
							conn.commit();
						else
						conn.rollback();
						
						validAmtErr="amount";
		
						out.println(validAmtErr+"&^&"+final_message+"&^&"+patientPayble+"&^&");
					}	
	
			 	/*@ End of Ae_bed_calculation from AECheckout Transactoion */
	
				}
		 	}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	} 
	else if(callfunc.equals("cancelAEChkOut"))  {
			
		String p_serv_date="";
		String validAmtErr="";

		String P_patient_id=checkForNull(request.getParameter("patient_id"));			
		String p_encounter_id=checkForNull(request.getParameter("encounterId"));
		String p_episode_type=checkForNull(request.getParameter("episode_type"));
		String p_episode_id=checkForNull(request.getParameter("episode_id"));
		String p_visit_id=checkForNull(request.getParameter("visit_id"));
		String	p_user_id	=  (String) session.getValue("login_user");	
		String p_ws_no = p.getProperty("client_ip_address");
		

		String sqlAuto="select to_char(sysdate,'dd/mm/yyyy hh24:mi') sys from dual ";
		pstmt = conn.prepareStatement(sqlAuto);		
		rs = pstmt.executeQuery();

		while(rs.next()){
			p_serv_date=rs.getString("sys");
			
		}

		if(rs!=null) rs.close();		
		if(pstmt!=null)	pstmt.close(); 

		if(bl_install_yn.equals("Y")) {// added for billing 


			String sqlbl = "{ call bl_ae_bed_calc.cancel_ae_bed_charges(?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY  HH24:MI'),?,?,?,?,?)}";

			cs = conn.prepareCall(sqlbl);
			cs.setString(1, facilityid);
			cs.setString(2, p_episode_type);
			cs.setString(3, p_episode_id);
			cs.setString(4, P_patient_id);
			cs.setString(5, p_encounter_id);
			cs.setString(6, p_visit_id);
			cs.setString(7, p_serv_date);
			cs.setString(8,  p_user_id);
			cs.setString(9,  p_ws_no);			
			cs.registerOutParameter(10, java.sql.Types.VARCHAR);
			cs.registerOutParameter(11, java.sql.Types.VARCHAR);
			cs.registerOutParameter(12, java.sql.Types.VARCHAR);

			cs.execute();
			
			String err_level = cs.getString(10);
			String sys_message_id = cs.getString(11);
			String err_text = cs.getString(12);


			if(err_level==null) err_level="";	
			if(sys_message_id==null) sys_message_id="";	
			if(err_text==null) err_text="";  

			String final_message="";

			if(cs != null) 	cs.close();


			if(  (!sys_message_id.equals(""))  || (err_level.equals("10") && !err_text.equals("") ) )
			{
				if((err_level.equals("10") && !err_text.equals("") ))
				{

					final_message=err_text;
					validAmtErr="err";
					out.println(validAmtErr+"&^&"+final_message);

				}
				else
				{
					
					java.util.Locale loc = new java.util.Locale(locale);
					java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
					final_message = (String) messages.getString(sys_message_id);
				}
				
			}
			else {
				final_message="";
				conn.commit();
			}	
			
			
			out.println(final_message+"&^&");
		}
	} else if(callfunc.equals("batchProcess")) {
		if(bl_install_yn.equals("Y")) {// added for billing 

			String final_message="";
			String p_ws_no = p.getProperty("client_ip_address");
				
			String sqlbl = "{ call bl_ae_bed_calc.bl_ae_bed_calculations_all(?,?,?,?,?)}";
	
			cs = conn.prepareCall(sqlbl);
	
			cs.setString(1, facilityid);
			cs.setString(2, p_ws_no);
	
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.registerOutParameter(4, java.sql.Types.VARCHAR);
			cs.registerOutParameter(5, java.sql.Types.VARCHAR);
	
			cs.execute();
	
			String p_err_code = cs.getString(3);
			//String p_sys_mesg_id = cs.getString(4);
			String p_error_text = cs.getString(5);
			
			if (p_err_code == null) p_err_code = "x";
			if (p_error_text == null) p_error_text = "x";
			
			if(cs != null)	cs.close();
	
			if(!p_err_code.equals("x")){
	
				java.util.Locale loc = new java.util.Locale(locale);
				java.util.ResourceBundle messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
				final_message = (String) messages.getString(p_err_code);
			}
			else if(!p_error_text.equals("x")){
				final_message=p_error_text;	
			}
			else{
				final_message="";
			}
			
			out.println(final_message+"&^&");
		}
	}
	/*
	Below code implemented for incident no: 17933 date  Wednesday, January 06, 2010
	*/
	else if(callfunc.equals("clinic_code")) {

		String visit_type_code="";
		String visit_type_desc="";
		StringBuffer type_code_desc=new StringBuffer();		

		String location_code = request.getParameter("location_code");

		String sql = "select a.visit_type_code, b.SHORT_DESC visit_type_short_desc  from  op_visit_type_for_clinic a, op_visit_type b where a.facility_id=b.facility_id and a.visit_type_code=b.visit_type_code and b.visit_type_ind='E'  and a.eff_status='E' and a.clinic_code= '"+location_code+"'  and a.facility_id='"+facilityid+"'";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while (rs!=null && rs.next() )
		{
			visit_type_code =rs.getString("visit_type_code");
			visit_type_desc = rs.getString("visit_type_short_desc");
			type_code_desc.append(visit_type_code+"##"+visit_type_desc);
			type_code_desc.append("~");
		}
		
        out.println(type_code_desc);

		if(rs!=null)rs.close();		
		if(pstmt!=null)pstmt.close();

	}
	else if(callfunc.equals("serviceCode")) {

		String service_code="";
		String service_desc="";
		StringBuffer serv_code_desc=new StringBuffer();

		String location_code = request.getParameter("location_code");

		String sql = "SELECT A.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A, AM_FACILITY_SERVICE B,OP_CLINIC_FOR_SERVICE C WHERE C.FACILITY_ID='"+facilityid +"' AND C.CLINIC_CODE = '"+location_code+"' AND B.OPERATING_FACILITY_ID = C.FACILITY_ID AND C.SERVICE_CODE = B.SERVICE_CODE AND A.SERVICE_CODE = B.SERVICE_CODE UNION SELECT b.SERVICE_CODE, A.SHORT_DESC FROM AM_SERVICE A,OP_CLINIC B WHERE B.FACILITY_ID='"+facilityid+"'  AND b.CLINIC_CODE='"+location_code+"' AND A.SERVICE_CODE = B.SERVICE_CODE ORDER BY 2";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs!=null && rs.next() )
		{
			service_code =rs.getString(1);
			service_desc = rs.getString(2);
			serv_code_desc.append(service_code+"##"+service_desc);
			serv_code_desc.append("~");
		}
		
        out.println(serv_code_desc);

		if(rs!=null)rs.close();		
		if(pstmt!=null)pstmt.close(); 

	}
	else if(callfunc.equals("idChk"))
	{
		/* this block implementing for icn:19689 date:Thursday, March 11, 2010 */
		
		String func_source=checkForNull(request.getParameter("func_source"));	
		session.putValue("queryString",func_source);
		String nat_id_check_digit_id=checkForNull(request.getParameter("nat_id_check_digit_id"));			
		String Nat_Id                    = checkForNull(request.getParameter("Nat_Id"));	
		String sql = "";
		String result ="";
		if(nat_id_check_digit_id != null)
		{
			sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			if( rs!=null && rs.next())
			{
				nat_id_check_digit_id = rs.getString("program_name");
				if(rs!= null)  rs.close();

				sql	= "select "+nat_id_check_digit_id+"('"+Nat_Id+"') from dual";
			
				 pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
					result = rs.getString(1);
				if(rs != null)  rs.close();
			}
		}

		out.println(result);

		if(rs != null)  rs.close();
		if(pstmt != null)  pstmt.close();

	}
	else if(callfunc.equals("Reg"))
	{

		/*this block implementing 20409 Date:Thursday, April 01, 2010 */
		
		String nat_id_check_digit_id=checkForNull(request.getParameter("nat_id_check_digit_id"));
		 
		String Nat_Id = checkForNull(request.getParameter("Nat_Id"));	
		String sql = "";
		String result ="";
		if(nat_id_check_digit_id != null)
		{
			sql = "SELECT program_name FROM mp_check_digit_scheme WHERE scheme_id = '"+nat_id_check_digit_id+"' ";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();

			if( rs!=null && rs.next())
			{
				nat_id_check_digit_id = rs.getString("program_name");
				if(rs!= null)  rs.close();

				sql	= "select "+nat_id_check_digit_id+"('"+Nat_Id+"') from dual";
			
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
					result = rs.getString(1);
				
				if(rs != null)  rs.close();
			}
		}

		out.println(result);

		if(rs != null)  rs.close();
		if(pstmt != null)  pstmt.close();

	}
	if (sou_value.equals("1")) {
		String P_Patient_ID=checkForNull(request.getParameter("P_Patient_ID"));	
		webbeans.op.PatientData patdata1 = new  webbeans.op.PatientData();
		patdata1.setFacility_id(facilityid);
		String patientIdStatus1 = patdata1.CheckStatus(conn,P_Patient_ID);	
		if(!P_Patient_ID.equals("")){	
			if ( patientIdStatus1.equals("INVALID_PATIENT")) {	
				out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[1].document.forms[0].patient_id.focus();parent.frames[1].document.forms[0].patient_id.select();parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp' </script>");	
			}else{
				out.println("<script>parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp';</script>");
			}	
		}
	}
	if(sou_value.equals("2")) //  added by mujafar for ML-MM0H-CRF-0632
	{
		String P_Patient_ID=checkForNull(request.getParameter("P_Patient_ID"));	
		
		webbeans.op.PatientData patdata1 = new  webbeans.op.PatientData();
		patdata1.setFacility_id(facilityid);
		String patientIdStatus1 = patdata1.CheckStatus(conn,P_Patient_ID);	
		if(!P_Patient_ID.equals(""))
		{	
			if ( patientIdStatus1.equals("INVALID_PATIENT")) 
			{			
				out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[1].frames[2].document.forms[0].patient_id1.focus();parent.frames[1].frames[2].document.forms[0].patient_id1.value='';/*start*/if(parent.frames[1].frames[2].document.forms[0].patient_id1_val.value != ''){if(parent.frames[1].frames[2].document.forms[0].contact1_new_nat_id_no)parent.frames[1].frames[2].document.forms[0].contact1_new_nat_id_no.value='';if(parent.frames[1].frames[2].document.forms[0].next_contact_name)parent.frames[1].frames[2].document.forms[0].next_contact_name.value = '';if(parent.frames[1].frames[2].document.forms[0].contact1_birth_date)parent.frames[1].frames[2].document.forms[0].contact1_birth_date.value='';if(parent.frames[1].frames[2].document.forms[0].next_addr_line1)parent.frames[1].frames[2].document.forms[0].next_addr_line1.value='';if(parent.frames[1].frames[2].document.forms[0].next_addr_line2)parent.frames[1].frames[2].document.forms[0].next_addr_line2.value='';if(parent.frames[1].frames[2].document.forms[0].next_addr_line3)parent.frames[1].frames[2].document.forms[0].next_addr_line3.value='';if(parent.frames[1].frames[2].document.forms[0].next_addr_line4)parent.frames[1].frames[2].document.forms[0].next_addr_line4.value=''; if(parent.frames[1].frames[2].document.forms[0].contact1_res_town_code){parent.frames[1].frames[2].document.forms[0].contact1_res_town_code.value='';parent.frames[1].frames[2].document.forms[0].n_town.value = '';}if(parent.frames[1].frames[2].document.forms[0].contact1_res_area_code){parent.frames[1].frames[2].document.forms[0].contact1_res_area_code.value='';parent.frames[1].frames[2].document.forms[0].n_area.value = '';}if(parent.frames[1].frames[2].document.forms[0].contact1_region_code){parent.frames[1].frames[2].document.forms[0].contact1_region_code.value=''; parent.frames[1].frames[2].document.forms[0].n_region.value = '';}	if(parent.frames[1].frames[2].document.forms[0].next_postal_code1){parent.frames[1].frames[2].document.forms[0].next_postal_code1.value='';parent.frames[1].frames[2].document.forms[0].next_postal_code.value = '';}	if(parent.frames[1].frames[2].document.forms[0].next_country_desc){parent.frames[1].frames[2].document.forms[0].next_country_desc.value='';parent.frames[1].frames[2].document.forms[0].next_country_code.value = '';} if(parent.frames[1].frames[2].document.forms[0].next_res_tel_no)parent.frames[1].frames[2].document.forms[0].next_res_tel_no.value='';if(parent.frames[1].frames[2].document.forms[0].contact1_mob_tel_no)parent.frames[1].frames[2].document.forms[0].contact1_mob_tel_no.value='';if(parent.frames[1].frames[2].document.forms[0].contact1_email_id)	parent.frames[1].frames[2].document.forms[0].contact1_email_id.value='';parent.frames[1].frames[2].document.forms[0].patient_id1_val.value='';parent.frames[1].frames[2].document.forms[0].next_contact_relation.options[0].selected=true;parent.frames[1].frames[2].document.forms[0].next_job_title.value='';}");
				
				out.println("if(parent.frames[1].frames[2].document.forms[0].next_off_tel_no)parent.frames[1].frames[2].document.forms[0].next_off_tel_no.value='';");
				
				if(resiAddMailAdd){
					out.println("{if(parent.frames[1].frames[2].document.forms[0].n_next_addr_line1)parent.frames[1].frames[2].document.forms[0].n_next_addr_line1.value='';if(parent.frames[1].frames[2].document.forms[0].n_ma_addr_line2)parent.frames[1].frames[2].document.forms[0].n_ma_addr_line2.value='';if(parent.frames[1].frames[2].document.forms[0].n_ma_addr_line3)parent.frames[1].frames[2].document.forms[0].n_ma_addr_line3.value='';if(parent.frames[1].frames[2].document.forms[0].n_ma_addr_line4)parent.frames[1].frames[2].document.forms[0].n_ma_addr_line4.value=''; if(parent.frames[1].frames[2].document.forms[0].n_contact_ma_town_code){parent.frames[1].frames[2].document.forms[0].n_contact_ma_town_code.value='';parent.frames[1].frames[2].document.forms[0].nkma_town.value = '';}if(parent.frames[1].frames[2].document.forms[0].n_contact_ma_area_code){parent.frames[1].frames[2].document.forms[0].n_contact_ma_area_code.value='';parent.frames[1].frames[2].document.forms[0].nkma_area.value = '';}if(parent.frames[1].frames[2].document.forms[0].n_contac_region_code){parent.frames[1].frames[2].document.forms[0].n_contac_region_code.value=''; parent.frames[1].frames[2].document.forms[0].contact1_region.value = '';}	if(parent.frames[1].frames[2].document.forms[0].n_ma_postal_code1){parent.frames[1].frames[2].document.forms[0].n_ma_postal_code1.value='';parent.frames[1].frames[2].document.forms[0].n_ma_postal_code.value = '';}	if(parent.frames[1].frames[2].document.forms[0].nk_ma_country_desc){parent.frames[1].frames[2].document.forms[0].nk_ma_country_desc.value='';parent.frames[1].frames[2].document.forms[0].nkin_mail_country_code.value = '';} if(parent.frames[1].frames[2].document.forms[0].ra_contact_name)parent.frames[1].frames[2].document.forms[0].ra_contact_name.value='';if(parent.frames[1].frames[2].document.forms[0].ma_contact_name)parent.frames[1].frames[2].document.forms[0].ma_contact_name.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact3_mode)parent.frames[1].frames[2].document.forms[0].nk_contact3_mode.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact3_no)parent.frames[1].frames[2].document.forms[0].nk_contact3_no.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact4_mode)parent.frames[1].frames[2].document.forms[0].nk_contact4_mode.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact4_no)parent.frames[1].frames[2].document.forms[0].nk_contact4_no.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact5_mode)parent.frames[1].frames[2].document.forms[0].nk_contact5_mode.value='';if(parent.frames[1].frames[2].document.forms[0].nk_contact5_no)parent.frames[1].frames[2].document.forms[0].nk_contact5_no.value='';}");
				}
		
				out.println("/*end*/parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp'; </script>"); 
				//Modified by Suji keerthi for ML-MMOH-CRF-1527 US008
	
			}
			else
			{
				out.println("<script>parent.frames[2].document.location.href='../../eCommon/jsp/error.jsp';</script>");
			}			
		}
	}
	
	if(sou_value.equals("3")) //  added by mujafar for ML-MM0H-CRF-0632
	{
		String P_Patient_ID=checkForNull(request.getParameter("P_Patient_ID"));	
		
		webbeans.op.PatientData patdata1 = new  webbeans.op.PatientData();
		patdata1.setFacility_id(facilityid);
		String patientIdStatus1 = patdata1.CheckStatus(conn,P_Patient_ID);	
		if(!P_Patient_ID.equals(""))
		{	
			if ( patientIdStatus1.equals("INVALID_PATIENT")) 
			{			
				out.println("<script>alert(parent.frames[1].getMessage('INVALID_PATIENT','MP'));parent.frames[3].document.forms[0].patient_id1.focus();parent.frames[3].document.forms[0].patient_id1.value='';/*start*/if(parent.frames[3].document.forms[0].patient_id1_val.value != ''){if(parent.frames[3].document.forms[0].contact1_new_nat_id_no){parent.frames[3].document.forms[0].contact1_new_nat_id_no.value='';}if(parent.frames[3].document.forms[0].next_contact_name)parent.frames[3].document.forms[0].next_contact_name.value = '';if(parent.frames[3].document.forms[0].contact1_birth_date)parent.frames[3].document.forms[0].contact1_birth_date.value='';if(parent.frames[3].document.forms[0].next_addr_line1)parent.frames[3].document.forms[0].next_addr_line1.value='';if(parent.frames[3].document.forms[0].next_addr_line2)parent.frames[3].document.forms[0].next_addr_line2.value='';if(parent.frames[3].document.forms[0].next_addr_line3)parent.frames[3].document.forms[0].next_addr_line3.value='';if(parent.frames[3].document.forms[0].next_addr_line4)parent.frames[3].document.forms[0].next_addr_line4.value=''; if(parent.frames[3].document.forms[0].contact1_res_town_code){parent.frames[3].document.forms[0].contact1_res_town_code.value='';parent.frames[3].document.forms[0].n_town.value = '';}if(parent.frames[3].document.forms[0].contact1_res_area_code){parent.frames[3].document.forms[0].contact1_res_area_code.value='';parent.frames[3].document.forms[0].n_area.value = '';}if(parent.frames[3].document.forms[0].contact1_region_code){parent.frames[3].document.forms[0].contact1_region_code.value=''; parent.frames[3].document.forms[0].n_region.value = '';}	if(parent.frames[3].document.forms[0].next_postal_code1){parent.frames[3].document.forms[0].next_postal_code1.value='';parent.frames[3].document.forms[0].next_postal_code.value = '';}	if(parent.frames[3].document.forms[0].next_country_desc){parent.frames[3].document.forms[0].next_country_desc.value='';parent.frames[3].document.forms[0].next_country_code.value = '';} if(parent.frames[3].document.forms[0].next_res_tel_no)parent.frames[3].document.forms[0].next_res_tel_no.value='';if(parent.frames[3].document.forms[0].contact1_mob_tel_no)parent.frames[3].document.forms[0].contact1_mob_tel_no.value='';if(parent.frames[3].document.forms[0].contact1_email_id)	parent.frames[3].document.forms[0].contact1_email_id.value='';parent.frames[3].document.forms[0].patient_id1_val.value='';parent.frames[3].document.forms[0].next_contact_relation.options[0].selected=true;parent.frames[3].document.forms[0].next_job_title.value='';} /*end*/parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp'; </script>");
			}
			else
			{
				out.println("<script>parent.frames[4].document.location.href='../../eCommon/jsp/error.jsp';</script>");
			}			
		}
	}	

}
catch(Exception ex){
	conn.rollback();
	ex.printStackTrace();
}
finally{
	ConnectionManager.returnConnection(conn, request);	
}


            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
