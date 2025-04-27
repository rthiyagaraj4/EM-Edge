package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;

public final class __rapidregistration extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RapidRegistration.jsp", 1727679459109L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title></title>\n    <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<Script src=\"../../eCommon/js/DateUtils.js\" language=\"JavaScript\"></Script> <!-- added by mujafar for KDAH-CRF-370.1  -->\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>   \n    <script  src=\'../../eMP/js/PatientRegistration1.js\' language=\'javascript\'></script>\n    <script  src=\'../../eMP/js/RapidRegn.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'   src=\'../../eCommon/html/blank.html\' frameborder=0 style=\'height:83vh;width:100vw\' scrolling=\'no\'></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'      src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t\t<input type = \"hidden\" name=\"parameters\" id=\"parameters\" value=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">\n\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		request.setCharacterEncoding("UTF-8");
        String params = request.getQueryString() ;
        String source = url + params ;
		
		String facilityId = (String) session.getValue("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");
        Connection con = ConnectionManager.getConnection(request);
        java.sql.PreparedStatement pstmt = null ;
		ResultSet rset=null;

        try
        {
		   //Below line added for ML-MMOH-CRF-0887.1
		   String meessageframeSize="50";
		   Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");	
		   if(increasedaddressLength) meessageframeSize="38";
		   //End ML-MMOH-CRF-0887.1
		 
			String sqlQuery = "";
			String dflt_pat_ser_grp_type = "" ;
			String alt_id1_type = "" ;
			String nat_id_prompt = "" ;
			String parameters = "" ;
			String patient_id_length = "" ;
			String names_in_oth_lang_yn = "" ;
			String accept_national_id_no_yn = "";
			String photo_file_name = "";
			String serverdate = "";		
			String alt_id1_unique_yn = "";
			String alt_id2_unique_yn = "";
			String alt_id3_unique_yn = "";
			String alt_id4_unique_yn = "";
			String dflt_grp = "";
			String default_race_code = "";
			String family_no_link_yn = "";
			String name_dervn_logic = "";
			String citizen_nationality_code = "";	
			String create_file_at_pat_regn_yn ="";			
			String maintain_doc_or_file ="";
			String alt_id4_desc ="";
			String alt_id3_desc ="";
			String alt_id2_desc ="";
			String alt_id1_desc ="";
			String nat_data_source_id ="";
			String ext_system_interface_yn ="";
			String accept_oth_alt_id_yn ="";
			String name_dervn_logic_oth_lang ="";
			String altdfltpsg ="";
			String max_patient_age ="";
			String nat_id_accept_alphanumeric_yn ="";
			String alt_id1_accept_oth_pat_ser_yn ="";
			String alt_id1_accept_alphanumeric_yn ="";

			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
			String alt_id2_accept_oth_pat_ser_yn		= "";
			String alt_id2_accept_alphanumeric_yn		= "";
			String alt_id3_accept_oth_pat_ser_yn		= "";
			String alt_id3_accept_alphanumeric_yn		= "";
			String alt_id4_accept_oth_pat_ser_yn		= "";
			String alt_id4_accept_alphanumeric_yn		= "";
			/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */





			int cntSeries = 0 ;
			int cntPatSeries = 0 ;
			int cntLang = 0 ;
			//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]

			//sqlQuery = "SELECT dflt_pat_ser_grp_type,NVL(alt_id1_type,'Alt ID No')alt_id1_type,NVL(nat_id_prompt,'National ID No')nat_id_prompt,patient_id_length,family_no_link_yn,name_dervn_logic, citizen_nationality_code,default_race_code,                    DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp, NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn, NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn, NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,  NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name, accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,			alt_id1_accept_alphanumeric_yn, max_patient_age,NVL(alt_id_pat_ser_grp,'') altdfltpsg,name_dervn_logic_oth_lang, accept_oth_alt_id_yn,ext_system_interface_yn, nat_data_source_id,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,'1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,'1') alt_id2_desc,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,'1') alt_id3_desc, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,'1') alt_id4_desc,maintain_doc_or_file, create_file_at_pat_regn_yn , names_in_oth_lang_yn,(select count(1) from mp_pat_ser_grp where id_type not in ('R', 'X')) cntSeries,(SELECT COUNT (1) FROM mp_pat_ser_grp WHERE (id_type NOT IN ('R', 'X') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE site_or_facility_id = DECODE (site_or_facility,'S',(select site_id from sm_site_param), 'F',? )))) OR gen_pat_id_yn = 'N') cntPatSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang FROM mp_param WHERE module_id = 'MP' ";


			sqlQuery = "SELECT dflt_pat_ser_grp_type,NVL(alt_id1_type,'Alt ID No')alt_id1_type,NVL(nat_id_prompt,'National ID No')nat_id_prompt,patient_id_length,family_no_link_yn,name_dervn_logic, citizen_nationality_code,default_race_code,                    DECODE(dflt_pat_ser_grp_type,'N',nat_id_pat_ser_grp,'A',alt_id_pat_ser_grp,'G',gen_pat_ser_grp) dflt_grp, NVL(alt_id1_unique_yn,'N') alt_id1_unique_yn, NVL(alt_id2_unique_yn,'N') alt_id2_unique_yn, NVL(alt_id3_unique_yn,'N') alt_id3_unique_yn,  NVL(alt_id4_unique_yn,'N') alt_id4_unique_yn,TO_CHAR(SYSDATE,'dd/mm/yyyy') serverdate,TO_CHAR(SYSDATE,'ddmmyyyyhhmmss') photo_file_name, accept_national_id_no_yn,nat_id_accept_alphanumeric_yn,alt_id1_accept_oth_pat_ser_yn,			alt_id1_accept_alphanumeric_yn, max_patient_age,NVL(alt_id_pat_ser_grp,'') altdfltpsg,name_dervn_logic_oth_lang, accept_oth_alt_id_yn,ext_system_interface_yn, nat_data_source_id,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,?,'1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,?,'1') alt_id2_desc,	mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,?,'1') alt_id3_desc, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,?,'1') alt_id4_desc,maintain_doc_or_file, create_file_at_pat_regn_yn , names_in_oth_lang_yn,(select count(1) from mp_pat_ser_grp where id_type not in ('R', 'X')) cntSeries,(SELECT COUNT (1) FROM mp_pat_ser_grp WHERE (id_type NOT IN ('R', 'X') AND gen_pat_id_yn = 'Y' AND (pat_ser_grp_code IN (SELECT pat_ser_grp_code FROM mp_pat_ser_facility WHERE site_or_facility_id = DECODE (site_or_facility,'S',(select site_id from sm_site_param), 'F',? )))) OR gen_pat_id_yn = 'N') cntPatSeries,(select count(*) from sm_language where language_direction='R' and eff_status='E') cntLang,alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn FROM mp_param WHERE module_id = 'MP' ";
			
			pstmt = con.prepareStatement(sqlQuery);			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityId);
            rset = pstmt.executeQuery() ;
            if(rset.next())
            {							
				create_file_at_pat_regn_yn = checkForNull(rset.getString("create_file_at_pat_regn_yn"));
				maintain_doc_or_file = checkForNull(rset.getString("maintain_doc_or_file"));
				alt_id4_desc = checkForNull(rset.getString("alt_id4_desc"));
				alt_id3_desc = checkForNull(rset.getString("alt_id3_desc"));
				alt_id2_desc = checkForNull(rset.getString("alt_id2_desc"));
				alt_id1_desc = checkForNull(rset.getString("alt_id1_desc"));
				nat_data_source_id = checkForNull(rset.getString("nat_data_source_id"));
				ext_system_interface_yn = checkForNull(rset.getString("ext_system_interface_yn"));
				accept_oth_alt_id_yn = checkForNull(rset.getString("accept_oth_alt_id_yn"));
				name_dervn_logic_oth_lang = checkForNull(rset.getString("name_dervn_logic_oth_lang"));
				altdfltpsg = checkForNull(rset.getString("altdfltpsg"));
				max_patient_age = checkForNull(rset.getString("max_patient_age"));
				alt_id1_accept_alphanumeric_yn = checkForNull(rset.getString("alt_id1_accept_alphanumeric_yn"));
				alt_id1_accept_oth_pat_ser_yn = checkForNull(rset.getString("alt_id1_accept_oth_pat_ser_yn"));
				nat_id_accept_alphanumeric_yn = checkForNull(rset.getString("nat_id_accept_alphanumeric_yn"));


				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] Start */
				alt_id2_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
				alt_id2_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id2_accept_alphanumeric_yn"),"N");
				alt_id3_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
				alt_id3_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id3_accept_alphanumeric_yn"),"N");
				alt_id4_accept_oth_pat_ser_yn			= checkForNull(rset.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
				alt_id4_accept_alphanumeric_yn			= checkForNull(rset.getString("alt_id4_accept_alphanumeric_yn"),"N");
				/*Added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772] End */


				accept_national_id_no_yn = checkForNull(rset.getString("accept_national_id_no_yn"));
				photo_file_name = checkForNull(rset.getString("photo_file_name"));
				serverdate = checkForNull(rset.getString("serverdate"));
				
				alt_id4_unique_yn = checkForNull(rset.getString("alt_id4_unique_yn"));
				alt_id3_unique_yn = checkForNull(rset.getString("alt_id3_unique_yn"));
				alt_id2_unique_yn = checkForNull(rset.getString("alt_id2_unique_yn"));
				alt_id1_unique_yn = checkForNull(rset.getString("alt_id1_unique_yn"));
				dflt_grp = checkForNull(rset.getString("dflt_grp"));
				default_race_code = checkForNull(rset.getString("default_race_code"));
				citizen_nationality_code = checkForNull(rset.getString("citizen_nationality_code"));
				name_dervn_logic = checkForNull(rset.getString("name_dervn_logic"));
				family_no_link_yn = checkForNull(rset.getString("family_no_link_yn"));
				dflt_pat_ser_grp_type = checkForNull(rset.getString("dflt_pat_ser_grp_type"));
				alt_id1_type = checkForNull(rset.getString("alt_id1_type"));
				nat_id_prompt = checkForNull(rset.getString("nat_id_prompt"));
				names_in_oth_lang_yn = checkForNull(rset.getString("names_in_oth_lang_yn"));
				patient_id_length = checkForNull(rset.getString("patient_id_length"));
				cntSeries = rset.getInt("cntSeries");
				cntPatSeries = rset.getInt("cntPatSeries");
				cntLang = rset.getInt("cntLang");				
				
				//alt_id2_accept_alphanumeric_yn, alt_id3_accept_alphanumeric_yn, alt_id4_accept_alphanumeric_yn, alt_id2_accept_oth_pat_ser_yn, alt_id3_accept_oth_pat_ser_yn, alt_id4_accept_oth_pat_ser_yn added by Dharma on Apr 6th 2015 against HSA-CRF-0191 [IN:049772]

				//parameters = "dflt_pat_ser_grp_type="+dflt_pat_ser_grp_type+"&alt_id1_type="+alt_id1_type+"&nat_id_prompt="+java.net.URLEncoder.encode(nat_id_prompt)+"&cntSeries="+cntSeries+"&cntPatSeries="+cntPatSeries+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntLang="+cntLang+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&family_no_link_yn="+family_no_link_yn+"&citizen_nationality_code="+citizen_nationality_code+"&default_race_code="+default_race_code+"&dflt_grp="+dflt_grp+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&alt_id3_unique_yn="+alt_id3_unique_yn+"&alt_id4_unique_yn="+alt_id4_unique_yn+"&serverdate="+serverdate+"&photo_file_name="+photo_file_name+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_patient_age="+max_patient_age+"&altdfltpsg="+altdfltpsg+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&accept_oth_alt_id_yn="+accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+" ";

				parameters = "dflt_pat_ser_grp_type="+dflt_pat_ser_grp_type+"&alt_id1_type="+alt_id1_type+"&nat_id_prompt="+java.net.URLEncoder.encode(nat_id_prompt)+"&cntSeries="+cntSeries+"&cntPatSeries="+cntPatSeries+"&patient_id_length="+patient_id_length+"&names_in_oth_lang_yn="+names_in_oth_lang_yn+"&cntLang="+cntLang+"&name_dervn_logic="+java.net.URLEncoder.encode(name_dervn_logic)+"&family_no_link_yn="+family_no_link_yn+"&citizen_nationality_code="+citizen_nationality_code+"&default_race_code="+default_race_code+"&dflt_grp="+dflt_grp+"&alt_id1_unique_yn="+alt_id1_unique_yn+"&alt_id2_unique_yn="+alt_id2_unique_yn+"&alt_id3_unique_yn="+alt_id3_unique_yn+"&alt_id4_unique_yn="+alt_id4_unique_yn+"&serverdate="+serverdate+"&photo_file_name="+photo_file_name+"&accept_national_id_no_yn="+accept_national_id_no_yn+"&nat_id_accept_alphanumeric_yn="+nat_id_accept_alphanumeric_yn+"&alt_id1_accept_oth_pat_ser_yn="+alt_id1_accept_oth_pat_ser_yn+"&alt_id1_accept_alphanumeric_yn="+alt_id1_accept_alphanumeric_yn+"&max_patient_age="+max_patient_age+"&altdfltpsg="+altdfltpsg+"&name_dervn_logic_oth_lang="+java.net.URLEncoder.encode(name_dervn_logic_oth_lang)+"&accept_oth_alt_id_yn="+accept_oth_alt_id_yn+"&ext_system_interface_yn="+ext_system_interface_yn+"&nat_data_source_id="+nat_data_source_id+"&alt_id1_desc="+java.net.URLEncoder.encode(alt_id1_desc)+"&alt_id2_desc="+java.net.URLEncoder.encode(alt_id2_desc)+"&alt_id3_desc="+java.net.URLEncoder.encode(alt_id3_desc)+"&alt_id4_desc="+java.net.URLEncoder.encode(alt_id4_desc)+"&maintain_doc_or_file="+maintain_doc_or_file+"&create_file_at_pat_regn_yn="+create_file_at_pat_regn_yn+"&alt_id2_accept_alphanumeric_yn="+alt_id2_accept_alphanumeric_yn+"&alt_id3_accept_alphanumeric_yn="+alt_id3_accept_alphanumeric_yn+"&alt_id4_accept_alphanumeric_yn="+alt_id4_accept_alphanumeric_yn+"&alt_id2_accept_oth_pat_ser_yn="+alt_id2_accept_oth_pat_ser_yn+"&alt_id3_accept_oth_pat_ser_yn="+alt_id3_accept_oth_pat_ser_yn+"&alt_id4_accept_oth_pat_ser_yn="+alt_id4_accept_oth_pat_ser_yn;

			//Below line modified for ML-MMOH-CRF-0887.1	
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(parameters));
            _bw.write(_wl_block10Bytes, _wl_block10);

            }
            else
                out.println("<script>alert(parent.frames[0].getMessage('MP_PARAM_NOT_FOUND','MP'));window.location.href = '../../eCommon/jsp/dmenu.jsp'</script>") ;
        }
        catch(Exception e ){/* out.println(e); */e.printStackTrace();}
        finally
        {
			if(rset!=null) rset.close();
            if(pstmt != null)    pstmt.close() ;
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }
 
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
