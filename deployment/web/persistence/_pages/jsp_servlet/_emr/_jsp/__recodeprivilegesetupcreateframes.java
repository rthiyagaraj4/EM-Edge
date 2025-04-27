package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;

public final class __recodeprivilegesetupcreateframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/RecodePrivilegeSetupCreateFrames.jsp", 1709117069201L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n<!--\n*\tCopyright � iSoft Solutions (P) Ltd.\n*\tCreated By\t\t:\tAnjanyeya Reddy M \n\tModule\t\t\t:   eMR\n\tFunction\t\t:  Recode Set Up Creating frames also\n*\tCreated On\t\t:\t18 Dec 2008\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n \t<script language=\'javascript\' src=\'../../eMR/js/RecodePrivilegeSetup.js\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\n\t \n\t</head>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\n\t\n   <frameset rows=\'31,0,35,35\'> <!-- modified by mujafar for ML-MMOH-CRF-0878 -->\n\t<frame name=\'MasterFrame\' src=\'../../eMR/jsp/addModifyRecodePrivilegeSetup.jsp?record_Count=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&_spec_user_id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&_update_mode_yn=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&_stage_desc=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&_serial_no=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&_colour_ind=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&_text_colour_ind=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&_cf_pr_fr_recode_dys_fm_vstcmpl=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&_cf_pr_fr_recode_dys_fm_disc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&_action_if_not_done=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&_allow_authorization_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&_confirm_not_appl=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&_specific_ind=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' frameborder=0 scrolling=\'no\'>\n\t<frame name=\'HeaderFrame\' src=\'../../eMR/jsp/RecodePrivilegeSetupUserHeader.jsp?\' frameborder=0 scrolling=\'no\'>\n   <!-- Below lines enc_stage_yn,chife_compln_yn and notify_yn added by Venkatesh.S against HAS-CRF-300 -->\n   <!--  inpatient_appl,daycare_appl added by KAMATCHI S for ML-MMOH-CRF-1581 -->\n\t<frame name=\'Criteria\' src=\'../../eMR/jsp/RecodePrivilegeSetupCriteriaDetail.jsp?record_Count=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&_diag_class_appl_yn=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&_accuracy_appl_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&_severity_appl_yn=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&_priority_appl_yn=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&_onset_type_appl_yn=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&_onset_date_appl_yn=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&_applicable_side_appl_yn=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&_status_appl_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&_as_on_date_appl_yn=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&_remarks_appl_yn=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&code_xtn_appl_yn=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&laterality_appl_yn=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&proc_remarks_appl_yn=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&proc_status_appl_yn=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&enc_stage_yn=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&chife_compln_yn=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&notify_yn=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&inpatient_appl=";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&daycare_appl=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' frameborder=0 scrolling=\'no\'>\n\t\n\t<frameset cols=\'50,50\'>\n\t\t<frame name=\'RecordFrame\' src=\'../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?flag=";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&record_Count=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \' frameborder=0 scrolling=\'no\' noresize > <!-- added by mujafar for ML-MMOH-CRF-0878 -->\n\t\t<frame name=\'DetailFrame\' src=\'../../eMR/jsp/RecordPriviegeStageDetailForm.jsp\' frameborder=0 scrolling=\'yes\' noresize>\n\t</frameset>\n\t<frame name=\'dummy\' src=\'../../eMR/jsp/RecodePrivilegeSetupUserHeader.jsp?\' frameborder=0 scrolling=\'no\'>\n\t\n\t\n</frameset>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</html>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String flag="";
	flag=checkForNull(request.getParameter("flag"));

	String _update_mode_yn=checkForNull(request.getParameter("update_mode_yn"));
	String _stage_code=checkForNull(request.getParameter("stage_code"));
	//String _specific_ind=checkForNull(request.getParameter("specific_ind"));
	
	/*
      This method used for the DB values displyed into user interfaces.
	*/
	
	String _stage_desc="";
	int _serial_no=0;
	String _colour_ind="";
	String _text_colour_ind="";
	String _specific_ind="";
	int _cf_pr_fr_recode_dys_fm_vstcmpl=0;
	int _cf_pr_fr_recode_dys_fm_disc=0;
	String _action_if_not_done="";
	String _allow_authorization_yn="";
	String confirm_not_appl="" ; // added by mujafar for ML-MMOH-CRF-0878
	//String _term_set_appl_yn="";
	//String _term_code_appl_yn="";
	//String _term_desc_appl_yn="";
	String _diag_class_appl_yn="";
	String _accuracy_appl_yn="";
	String _severity_appl_yn="";
	String _priority_appl_yn="";
	String _onset_type_appl_yn="";
	String _onset_date_appl_yn="";
	String _applicable_side_appl_yn="";
	String _status_appl_yn="";
	String _as_on_date_appl_yn="";
	String _remarks_appl_yn="";


	String _user_name="";
	String _appl_user_id="";
	String _authorize_yn="";
	String _spec_user_id="";
	String code_xtn_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String laterality_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String proc_remarks_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String proc_status_appl_yn="";//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
	String enc_stage_yn="";  /* HAS-CRF-300 */
	String chife_compln_yn=""; /* HAS-CRF-300 */
	String notify_yn=""; /* HAS-CRF-300 */

	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	String inpatient_appl="";
	String daycare_appl="";
	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

	int record_Count=0;
	StringBuffer _getdbV_sql=new StringBuffer();
	Connection conn =null;
   try{
	            conn  =  ConnectionManager.getConnection(request);
				PreparedStatement _stmt = null;
				PreparedStatement _stmtSPC = null;
				ResultSet _rset=null;
				ResultSet _rset_SPC=null;
				
			/*IN019167 , Wednesday, February 10, 2010 , to validate MR Parameter*/
			_stmt = conn.prepareStatement("select 1 from mr_param ") ;
			_rset = _stmt.executeQuery();
			if(_rset.next())
			{
			
				if(!_update_mode_yn.equals("")){				

				if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
				_getdbV_sql.append("SELECT * from MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+_stage_code+"");
					_stmt = conn.prepareStatement(_getdbV_sql.toString());
					_rset = _stmt.executeQuery();
					while(_rset.next()){
						_stage_desc										= _rset.getString("stage_desc");
						_serial_no											= _rset.getInt("STAGE_NO");
						_colour_ind										= _rset.getString("COLOUR_IND");
						_text_colour_ind								= _rset.getString("TEXT_COLOUR_IND");
						_cf_pr_fr_recode_dys_fm_vstcmpl	= _rset.getInt("CF_PR_FR_RECODE_DYS_FM_VSTCMPL");
						_cf_pr_fr_recode_dys_fm_disc		= _rset.getInt("CF_PR_FR_RECODE_DYS_FM_DISC");
						_action_if_not_done							= _rset.getString("ACTION_IF_NOT_DONE");
						_allow_authorization_yn					= _rset.getString("ALLOW_AUTHORIZATION_YN");
						if(_allow_authorization_yn.equals("Y"))
							flag="";
						else
							flag="d";
						
						confirm_not_appl  = _rset.getString("CONFIRM_APPL"); // added by mujafar for ML-MMOH-CRF-0878
						
						_diag_class_appl_yn				=	_rset.getString("DIAG_CLASS_APPL_YN");
						_accuracy_appl_yn				=	_rset.getString("ACCURACY_APPL_YN");
						_severity_appl_yn				=	_rset.getString("SEVERITY_APPL_YN");
						_priority_appl_yn					=	_rset.getString("PRIORITY_APPL_YN");
						_onset_type_appl_yn			=	_rset.getString("ONSET_TYPE_APPL_YN");
						_onset_date_appl_yn			=	_rset.getString("ONSET_DATE_APPL_YN");
						_applicable_side_appl_yn		=	_rset.getString("APPLICABLE_SIDE_APPL_YN");
						_status_appl_yn					=	_rset.getString("STATUS_APPL_YN");
						_as_on_date_appl_yn			=	_rset.getString("AS_ON_DATE_APPL_YN");
						_remarks_appl_yn				=	_rset.getString("REMARKS_APPL_YN");
						_specific_ind						=	_rset.getString("SPECIFIC_IND");
						proc_remarks_appl_yn			=	_rset.getString("PROC_REMARKS_APPL_YN");
						code_xtn_appl_yn				= _rset.getString("CODE_EXTENSION_APPL_YN");
						laterality_appl_yn					= _rset.getString("LATERALITY_APPL_YN");
						proc_status_appl_yn			= _rset.getString("PROC_STATUS_APPL_YN");//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
						enc_stage_yn				= _rset.getString("ENC_STAGE_YN");/* HAS-CRF-300 */
						chife_compln_yn			= _rset.getString("CHIFE_COMP_YN");/* HAS-CRF-300 */
						notify_yn					= _rset.getString("NOTIFIY_YN");/* HAS-CRF-300 */

						/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
						inpatient_appl = _rset.getString("inpatient_appl_yn")==null? "N":_rset.getString("inpatient_appl_yn");
						daycare_appl= _rset.getString("daycare_appl_yn")==null? "N":_rset.getString("daycare_appl_yn");
						/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
						
						/*
						implemeter the logic for the specindicator
						*/
						String facilityId = (String)session.getValue("facility_id");
						if(_specific_ind.equals("SPC")){
							if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
							_getdbV_sql.append("SELECT A.APPL_USER_ID,A.FACILITY_ID,A.AUTHORIZE_YN, B.APPL_USER_NAME FROM MR_RECODE_PRIVI_SETUP_DTL A, SM_APPL_USER B WHERE A.APPL_USER_ID = B.APPL_USER_ID AND A.STAGE_NO ="+_stage_code+" AND FACILITY_ID='"+facilityId+"' ORDER BY 1");
							
								_stmtSPC = conn.prepareStatement(_getdbV_sql.toString());
								_rset_SPC= _stmtSPC.executeQuery();
								while(_rset_SPC.next()){
										_user_name		=_rset_SPC.getString("APPL_USER_NAME");
										_appl_user_id	=_rset_SPC.getString("APPL_USER_ID");
										_user_name = _user_name.replaceAll("\'", "%27");//Added for ML-MMOH-SCF-2337 by Ajay Hatwate
										_authorize_yn	=_rset_SPC.getString("AUTHORIZE_YN");	_spec_user_id=_spec_user_id+_appl_user_id+"`"+_user_name+"`"+_authorize_yn+"~";
								}
//								if(_rset_SPC!=null)_rset_SPC=null;
//								if(_stmtSPC!=null)_stmtSPC=null;
							   if(_rset_SPC!=null)_rset_SPC.close();
								if(_stmtSPC!=null)_stmtSPC.close();
						}
					}
						if(_rset!=null)_rset.close();
						if(_stmt!=null)_stmt.close();
					//if(conn!=null)conn=null;
			}else{
				if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
				_getdbV_sql.append("SELECT count(*) count from MR_RECODE_PRIVI_SETUP ");
				_stmt = conn.prepareStatement(_getdbV_sql.toString());
					_rset = _stmt.executeQuery();
					while(_rset.next())
						record_Count=_rset.getInt("count");
						if(_rset!=null)_rset.close();
					    if(_stmt!=null)_stmt.close();
					   //if(conn!=null)conn=null;
					   

				
				}
  
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(record_Count));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(java.net.URLEncoder.encode(_spec_user_id,"UTF-8")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(_update_mode_yn));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(_stage_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(_serial_no));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(_colour_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(_text_colour_ind));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(_cf_pr_fr_recode_dys_fm_vstcmpl));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(_cf_pr_fr_recode_dys_fm_disc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(_action_if_not_done));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(_allow_authorization_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(confirm_not_appl));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(_specific_ind));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(record_Count));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(_update_mode_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(_diag_class_appl_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(_accuracy_appl_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(_severity_appl_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(_priority_appl_yn));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(_onset_type_appl_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(_onset_date_appl_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(_applicable_side_appl_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(_status_appl_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(_as_on_date_appl_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(_remarks_appl_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(code_xtn_appl_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(laterality_appl_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(proc_remarks_appl_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(proc_status_appl_yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(enc_stage_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(chife_compln_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(notify_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(inpatient_appl));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(daycare_appl));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(confirm_not_appl));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(_allow_authorization_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(record_Count));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(_update_mode_yn));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(java.net.URLEncoder.encode(_spec_user_id,"UTF-8")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(_specific_ind));
            _bw.write(_wl_block38Bytes, _wl_block38);

			 }
				else
				{
					out.println("<script>alert(getMessage('MR_PARAM_NOT_DEFINED','MR'));</script>");
				}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(conn,request);
			
		}
	
	
            _bw.write(_wl_block39Bytes, _wl_block39);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
