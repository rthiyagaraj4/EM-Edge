package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __patienthistquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientHistQuery.jsp", 1714373825783L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Last Modified Date Time : 9/27/2005 11:49 AM -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eMP/js/PatHistSearch.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n\n<BODY onLoad=\"focusField()\" onKeyDown = \'lockKey()\'>\n<form name=\"PatientHistorySearchForm\" id=\"PatientHistorySearchForm\" target=\"messageFrame\">\n<table width=\'100%\' align=\'center\' valign=\'top\'>\n\t<th align=\'left\'> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t<tr>\n\t\t<td width=\"100%\" class=\"Border\" align=\'center\'>\n\t\t\t<table width=\'100%\' cellPadding=\"0\" cellSpacing=\"0\"  align=\'left\'>\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<td align=\'right\' width=\'15%\' class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t<td  align=\"left\" width=\"25%\"><input type=text name=\'Patient_ID\' id=\'Patient_ID\' size=\"20\" value = \'\' onBlur=\'changeCase(this)\' \n\t\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\'\n\t\t\t\t\tmaxlength=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="><input type=\'button\' name=\'pat_id\' id=\'pat_id\' value=\'?\' class=\'button\' onclick=\'PatSearch()\'>\n\t\t\t\t\t&nbsp;<img src=\'../images/mandatory.gif\'></img></td>\n\t\t\t\t\t<td align=\'right\' width=\'15%\' class=\"label\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n\t\t\t\t\t<td align=\"left\" width=\"25%\"><Select name=\"History_Type\" id=\"History_Type\">\n\t\t\t\t\t<Option value=0>&nbsp; -----";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="-----&nbsp;</Option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t</Select></td>\n\t\t\t\t\t<td align=\'left\' width=\'5%\' class=\"label\"><input type=\'button\' name=\'Search\' id=\'Search\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' class=\'button\' onclick=\'search()\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\'left\' width=\'5%\' class=\"label\">&nbsp;&nbsp;<input type=\'button\' name=\'Clear\' id=\'Clear\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' class=\'button\' onclick=\'clear_frame()\'>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</table>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String alt_id1_type = "";
	String alt_id2_type = "";
	String alt_id3_type = "";
	String alt_id4_type = "";
	String nat_id_prompt  = "";
	
	// Below code added by mujafar for ML-MMOH-CRF-0998 START
	String other_alt_no_yn="";
	String mar_status_yn = "";
	String residence_desc_yn="";
	String regn_date_time_yn="";
	String status_desc_yn="";
	String race_yn="";
	String religion_yn= "";
	String ethnicity_yn = "";
	String next_of_kin_hist_yn="";
	String first_notify_hist_yn="";
	
	// Below code added by mujafar for ML-MMOH-CRF-0998 END

	/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
	Properties p = (java.util.Properties) session.getValue("jdbc");
	ArrayList arrayList = new ArrayList(); 
	String contact1_no_yn = "";
	String contact2_no_yn = "";
	/*End GHL-CRF-0534*/
	
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

					try{
						con = ConnectionManager.getConnection(request);
				String locale=(String)session.getAttribute("LOCALE");

				
				arrayList = eMP.ChangePatientDetails.getResultRows(con,"mp_contact_mode1",p); //Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

					int patlen = 0;
					pstmt = con.prepareStatement("select patient_id_length from mp_param");
					rs = pstmt.executeQuery();
					if(rs != null){
						while(rs.next()) {
							patlen = rs.getInt("patient_id_length");
						}
					}
				
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patlen));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
                                     //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
					pstmt = con.prepareStatement("SELECT sex_hist_yn,old_file_no_yn,birth_date_hist_yn, legal_name_hist_yn, alias_name_hist_yn, address_hist_yn, ocpn_n_empl_hist_yn, suspend_reinstate_hist_yn, inact_act_hist_yn, rec_revoke_death_hist_yn, coded_pseudo_name_hist_yn, contact_no_hist_yn, general_alert_info_hist_yn, alt_id1_hist_yn, alt_id2_hist_yn, (CASE WHEN alt_id1_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id1_type) END ) alt_id1_type, (CASE WHEN alt_id2_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id2_type) END) alt_id2_type, (CASE WHEN alt_id3_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id3_type) END) alt_id3_type, (CASE WHEN alt_id4_type IS NOT NULL THEN (SELECT long_desc FROM mp_alternate_id_type WHERE alt_id_type = alt_id4_type) END) alt_id4_type, alt_id3_hist_yn, alt_id4_hist_yn, nationality_hist_yn,FAMILY_LINK_HIST_YN,ORG_MEMBER_HIST_YN,PAT_CAT_HIST_YN,nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT ,NAT_ID_HIST_YN,BIRTH_PLACE_CODE_HIST_YN,PAT_SER_GRP_HIST_YN,other_alt_no_yn,mar_status_yn,residence_desc_yn,regn_date_time_yn,status_desc_yn,race_yn,religion_yn,ethnicity_yn,next_of_kin_hist_yn,first_notify_hist_yn,contact1_no_yn,contact2_no_yn FROM mp_Param_lAng_vw where language_id='"+locale+"'");  // modified by mujafar for ML-MMOH-CRF-0998 END

					rs = pstmt.executeQuery();
						if(rs != null){
							while(rs.next()) {
									alt_id1_type = rs.getString("alt_id1_type");
									if (alt_id1_type==null) alt_id1_type = "";
									alt_id2_type = rs.getString("alt_id2_type");
									if (alt_id2_type==null) alt_id2_type = "";
									alt_id3_type = rs.getString("alt_id3_type");
									if (alt_id3_type==null) alt_id3_type = "";
									alt_id4_type = rs.getString("alt_id4_type");
									if (alt_id4_type==null) alt_id4_type = "";
									nat_id_prompt = rs.getString("NAT_ID_PROMPT");
									if (nat_id_prompt==null) nat_id_prompt = "";
									
									// added by mujafar for ML-MMOH-CRF-0998 start
									
									other_alt_no_yn = rs.getString("other_alt_no_yn");
									if (other_alt_no_yn==null) other_alt_no_yn = "";
									
									mar_status_yn = rs.getString("mar_status_yn");
									if (mar_status_yn==null) mar_status_yn = "";
									
									residence_desc_yn = rs.getString("residence_desc_yn");
									if (residence_desc_yn==null) residence_desc_yn = "";
									
									regn_date_time_yn = rs.getString("regn_date_time_yn");
									if (regn_date_time_yn==null) regn_date_time_yn = "";
									
									status_desc_yn = rs.getString("status_desc_yn");
									if (status_desc_yn==null) status_desc_yn = "";
									
									race_yn = rs.getString("race_yn");
									if (race_yn==null) race_yn = "";
									
									religion_yn = rs.getString("religion_yn");
									if (religion_yn==null) religion_yn = "";
									
									ethnicity_yn = rs.getString("ethnicity_yn");
									if (ethnicity_yn==null) ethnicity_yn = "";
									
									next_of_kin_hist_yn = rs.getString("next_of_kin_hist_yn");
									if (next_of_kin_hist_yn==null) next_of_kin_hist_yn = "";
									
									first_notify_hist_yn = rs.getString("first_notify_hist_yn");
									if (first_notify_hist_yn==null) first_notify_hist_yn = "";
									
									// added by mujafar for ML-MMOH-CRF-0998 END

									/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
									contact1_no_yn = rs.getString("contact1_no_yn");
									if (contact1_no_yn==null) contact1_no_yn = "";
									
									contact2_no_yn = rs.getString("contact2_no_yn");
									if (contact2_no_yn==null) contact2_no_yn = "";
									/*End GHL-CRF-0534*/
																	
									if (rs.getString("sex_hist_yn").equals("Y"))
										{out.println("<Option value=10>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</Option>");}
									if (rs.getString("birth_date_hist_yn").equals("Y"))
										{out.println("<Option value=20>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</Option>");}
									if (rs.getString("legal_name_hist_yn").equals("Y"))
									{	out.println("<Option 	value=30>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</Option>");
										out.println("<Option value=35>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientNameLocal.label","mp_labels")+"</Option>");
										}
									if (rs.getString("alias_name_hist_yn").equals("Y"))
										{out.println("<Option value=40>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AliasName.label","mp_labels")+"</Option>");}				
									if (rs.getString("contact_no_hist_yn").equals("Y"))
										{out.println("<Option value=60>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.contactNo.label","common_labels")+"</Option>");}		
									if (rs.getString("suspend_reinstate_hist_yn").equals("Y"))
									{	out.println("<Option value=80>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Suspended.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=90>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reinstated.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("inact_act_hist_yn").equals("Y"))
									{
										out.println("<Option value=100>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=110>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Inactive.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("rec_revoke_death_hist_yn").equals("Y"))
									{	out.println("<Option 	value=120>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.deceased.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
										out.println("<Option value=130>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Revoked.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</Option>");
									}
									if (rs.getString("ocpn_n_empl_hist_yn").equals("Y"))
										{out.println("<Option value=140>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.employerdetails.label","common_labels")+"</Option>");}
									if (rs.getString("address_hist_yn").equals("Y"))
										{
										out.println("<Option value=150>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.residenceaddress.label","mp_labels")+"</Option>");
										out.println("<Option value=155>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MailingAddress.label","common_labels")+"</Option>");
										}
									if (rs.getString("alt_id1_hist_yn").equals("Y"))
										{out.println("<Option value=160>"+alt_id1_type);}
									if (rs.getString("alt_id2_hist_yn").equals("Y"))
										{out.println("<Option value=170>"+alt_id2_type);}
									if (rs.getString("alt_id3_hist_yn").equals("Y"))
										{out.println("<Option value=180>"+alt_id3_type);}
									if (rs.getString("alt_id4_hist_yn").equals("Y"))
										{out.println("<Option value=190>"+alt_id4_type);}
									if (rs.getString("nationality_hist_yn").equals("Y"))
										{out.println("<Option value=200>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nationality.label","common_labels")+"</Option>");}
									if (rs.getString("FAMILY_LINK_HIST_YN").equals("Y"))
										{out.println("<Option value=220>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.FamilyLink.label","mp_labels")+"</Option>");}
									if (rs.getString("ORG_MEMBER_HIST_YN").equals("Y"))
										{out.println("<Option value=230>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OrganizationMembership.label","mp_labels")+"</Option>");}
									if (rs.getString("PAT_CAT_HIST_YN").equals("Y"))
										{out.println("<Option value=210>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.category.label","common_labels")+"</Option>");
                                    if (rs.getString("NAT_ID_HIST_YN").equals("Y"))
										{out.println("<Option value=240>"+nat_id_prompt+"</Option>");}
									if (rs.getString("BIRTH_PLACE_CODE_HIST_YN").equals("Y")) { 				out.println("<Option value=250>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthPlace.label","common_labels")+"</Option>");
									}
									if (rs.getString("PAT_SER_GRP_HIST_YN").equals("Y")) { 
										out.println("<Option value=270>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+"</Option>");
									}
							}	
                                                                      //modified by N Munisekhar against Bru-HIMS-CRF-315 [IN036041]
									if (rs.getString("old_file_no_yn").equals("Y"))
									{out.println("<Option value='280'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OldFileNo.label","common_labels")+"</Option>");}
								
								// added by mujafar for ML-MMOH-CRF-0998 start
								
								if (rs.getString("other_alt_no_yn").equals("Y"))
									{out.println("<Option value='290'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels")+"</Option>");}
								if (rs.getString("mar_status_yn").equals("Y"))
									{out.println("<Option value='300'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.maritalstatus.label","mp_labels")+"</Option>");}
								if (rs.getString("residence_desc_yn").equals("Y"))
									{out.println("<Option value='330'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.residency.label","common_labels")+"</Option>");}
								if (rs.getString("regn_date_time_yn").equals("Y"))
									{out.println("<Option value='430'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Registrationdatetime.label","common_labels")+"</Option>");}
								if (rs.getString("status_desc_yn").equals("Y"))
									{out.println("<Option value='350'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</Option>");}
								if (rs.getString("race_yn").equals("Y"))
									{out.println("<Option value='370'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.race.label","common_labels")+"</Option>");}
								if (rs.getString("religion_yn").equals("Y"))
									{out.println("<Option value='390'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.religion.label","common_labels")+"</Option>");}
								if (rs.getString("ethnicity_yn").equals("Y"))
									{out.println("<Option value='410'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ethnicity.label","mp_labels")+"</Option>");}
								if (rs.getString("next_of_kin_hist_yn").equals("Y"))
									{out.println("<Option value='450'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nextofkin.label","common_labels")+"</Option>");}
								if (rs.getString("first_notify_hist_yn").equals("Y"))
									{out.println("<Option value='460'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.firsttonotify.label","common_labels")+"</Option>");}
								
								// added by mujafar for ML-MMOH-CRF-0998 END

								/*Added by Ashwini on 25-Sep-2018 for GHL-CRF-0534*/
								if (rs.getString("contact1_no_yn").equals("Y"))
									{out.println("<Option value='480'>"+(String)arrayList.get(0)+"</Option>");}
								if (rs.getString("contact2_no_yn").equals("Y"))
									{out.println("<Option value='500'>"+(String)arrayList.get(1)+"</Option>");}
								/*End GHL-CRF-0534*/
								
						}
										out.println("<option value='260'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bloodgroup.label","common_labels")+"</option>");
					}
					
					
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}catch(Exception e) { out.println(e.toString());}
finally{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueryCriteria.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HistoryType.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
