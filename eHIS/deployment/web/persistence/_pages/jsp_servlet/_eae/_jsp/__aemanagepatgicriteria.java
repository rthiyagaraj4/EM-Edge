package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aemanagepatgicriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AEManagePatGICriteria.jsp", 1737911798932L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEManagePatientGI.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script> \n<script language=\'javascript\' src=\'../../eAE/js/AEUtilities.js\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AEPractitionerComponent.js\'></script>\n</head>\n<body onLoad=\"disableHome();\" onMouseDown=\'CodeArrest();\' onKeyDown = \'lockKey()\'>\n<center>\n<form name=\'AEMPSearchCriteriaForm\' id=\'AEMPSearchCriteriaForm\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n       \t<tr><td colspan=4 class=label height=5></td></tr>\n\t<tr>\n\t\n <input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'clinic_code\' id=\'clinic_code\' onChange=\"clear_chk_select1();popTreatmentCode(this,\'\',\'\');\" >\n\t\t\t<option value=\'\'>---------- ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="----------</option> \n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\t<script>parent.AEMPSearchCriteriaFrame.openToAllPractionerYN[";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="]=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\tparent.AEMPSearchCriteriaFrame.clinicType[";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\t\tparent.AEMPSearchCriteriaFrame.specialtyForClinc[";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';\n\t\t\t\t</script> \n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</select></td>\n\t\t\t\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t<select name=\'treatment_area_code\' id=\'treatment_area_code\' onChange=\'checkTreatmentGender()\'>\n\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="----------</option>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<!-- <option value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t<script language=\'javascript\'> -->\n\t\t\t\t\t<script>\n\t\t\t\t\tself.treatmentGender[";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="] = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\';\n\t\t\t\t \tself.openToAllPractForClnYN[";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'; \n\t\t\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</select></td>\n      </tr>\n      <tr>\n\t\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\"patient_id\" id=\"patient_id\" value=\"\" size=\'20\'  maxlength=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" onKeyPress=\"return(CheckForSpecChars(event))\" onBlur=\"ChangeToUpper(this)\"><input type=\'button\' class=\'BUTTON\' value=\'?\' name=\'patient_search\' id=\'patient_search\' onClick = \'callPatientSearch()\'></td>\n\t\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=text name=practitioner_desc size=30 maxlength=30 onBlur=\"beforeGetPractitioner2(practitioner_id,practitioner_desc);\" ><input type=hidden name=\"practitioner_id\" id=\"practitioner_id\"  ><input type=button class=button value=\'?\' name=Practitioner_lookup_button onClick=\"getPractitioner2(practitioner_id,practitioner_desc);\">\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</td>\n\t</tr>\n    <tr>\n\t\t\t<td width=\"25%\" class=\"LABEL\" id=\'bayStatus_lab\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<td width=\"25%\" class=\"fields\" id=\'bayStatus_sel\' ><select name=\"bed_status1\" id=\"bed_status1\" onchange=\"storeBedStatus(this);\">\n\t\t\t<!-- <option value=\"\" >----------";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="--------</option> -->\n\t\t\t<option value=\"A\" >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</option>\n\t\t\t<option value=\"O\" selected>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n\t\t\t<option value=\"R\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t<option value=\"B\"   >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</option>\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t<td class=\"LABEL\" >&nbsp;</td>\n\t\t\t<td class=\'BUTTON\'  width=\"25%\"><input type=\'button\' class=\'BUTTON\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' name=\'refresh\' onClick=\"callShowQueryResult(\'refresh\')\"></td>\t\n\t</tr>\t\n\t<tr><td colspan=4 class=label height=5></td></tr>\n\t\t\t\t\n\t    <input type=\"hidden\" name=\"gender\" id=\"gender\">\n\t\t<input type=\"hidden\" name=\"bed_status\" id=\"bed_status\" value=\'O\'>\n\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"\">\n\t</table>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n    <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n    <input type=\'hidden\' name=\'called_from_ca\' id=\'called_from_ca\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"> \n\t<input type=\'hidden\' name=\'queue_refresh_interval\' id=\'queue_refresh_interval\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\'hidden\' name=\'p_cutoff_hours_prv_day_visit\' id=\'p_cutoff_hours_prv_day_visit\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\' name=\'patient_gender\' id=\'patient_gender\' value=\"\">\n\t<input type=\'hidden\' name=\'clinic_type\' id=\'clinic_type\' value=\"\">\n\t<input type=\'hidden\' name=\'checkout_yn\' id=\'checkout_yn\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'first_open_to_all_pract_yn\' id=\'first_open_to_all_pract_yn\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=\'hidden\' name=\'tabIndicator\' id=\'tabIndicator\' value=\'char_tab\'>\n\t<input type=\'hidden\' name=\'chk_Select1\' id=\'chk_Select1\' value=\'\'>\n\t<input type=\'hidden\' name=\'priority_zone\' id=\'priority_zone\' value=\"\">\n\t<input type=\'hidden\' name=\'orderCriteria\' id=\'orderCriteria\' value=\'queueDate\'>\n\t<input type=\'hidden\' name=\'orderCriteria_sensor\' id=\'orderCriteria_sensor\' value=\'queueDate\'>\n\t<input type=\'hidden\' name=\'asc_desc\' id=\'asc_desc\' value=\' asc\'>\n\t<input type=\'hidden\' name=\'asc_desc_sensor\' id=\'asc_desc_sensor\' value=\'\'>\n\t<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<!--Maheshwaran K added for ML-MMOH-CRF-1973 as on 05-07-2023-->\n<!--\t<input type=\'hidden\' name=\'appear_as_tab_yn\' id=\'appear_as_tab_yn\' value=\'\' >-->\n\t<input type=\'hidden\' name=\'treatment_area_code1\' id=\'treatment_area_code1\' value=\'\' > \n\t<input type=\'hidden\' name=\'isAppearAsTabEnable\' id=\'isAppearAsTabEnable\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\"> \n \n</form>\n</center> \n<script>\nshowQueryResult();\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	StringBuffer query_operator_station	= new StringBuffer();	
	String facility_id				=	"";
	String	login_user_id			=	"",		clinic_type				=	"";
	String	oper_stn_id				=	"";
	String	clinic_code				=	"",		clinic_desc				=	"";
	StringBuffer query_location  = new StringBuffer();		
	String open_to_all_pract_yn	 =	"";
	String	queue_refresh_interval	=	"";

	String	treatment_area_code		=	"",		treatment_area_desc		=	"";
	String	practitioner_name		=	"";
	StringBuffer	query_treatment_area	=new StringBuffer();
	String	treatment_area_gender	=	"",		selected_prop			=	"";
	String  checkout_yn				=	"";
	String	open_to_all_prac_for_clinic_yn	=	"";
	String	first_clinic_code				=	"";		
	String	first_open_to_all_pract_yn		=	"";
	String where_condition					=	"";
	String pid_length						=	"";
	String called_from_ca					=	"";
	String locale							=	"";
	String p_cutoff_hours_prv_day_visit     =	"";
	int		rowIndex				=	1;
	String five_level_triage_appl_yn	=  (request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");
	Boolean isAppearAsTabEnable  =false; //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023
	
	try
	{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		
		locale= (String)session.getAttribute("LOCALE");

		con				=	(Connection)	ConnectionManager.getConnection(request);
		
		isAppearAsTabEnable  = eCommon.Common.CommonBean.isSiteSpecific(con, "AE","AE_TREATMENT_AREA_TAB"); //Maheshwaran K added for ML-MMOH-CRF-1973 as on 21-07-2023

		facility_id		=	(String)		session.getValue("facility_id");
		login_user_id	=	(String)		session.getValue("login_user");
        oper_stn_id     =	(request.getParameter("oper_stn_id")==null)? "" : request.getParameter("oper_stn_id");
		called_from_ca	=	(request.getParameter("called_from_ca")==null)? "" : request.getParameter("called_from_ca");
	
		if(called_from_ca .equals("Y")) 
		{
				String sql= "select a.func_role_id, AM_GET_DESC.AM_PRACTITIONER(b.practitioner_id,'"+locale+"','2') practitioner_name, b.pract_type,(select TAB_MENU_YN from ca_encntr_param) TAB_MENU_YN from sm_appl_user a, am_practitioner b where a.func_role_id=b.practitioner_id and a.appl_user_id =? and a.func_role ='P'";
			
				String func_role_id="",pract_type="";

				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,login_user_id);
				rs=pstmt.executeQuery();
				if(rs !=null && rs.next()){
					func_role_id=rs.getString(1);

					if(func_role_id == null) func_role_id="";
					practitioner_name=rs.getString(2);
					if(practitioner_name == null) practitioner_name="";

					pract_type = rs.getString(3);
					if(pract_type == null) pract_type="";

					session.putValue("ca_practitioner_id",func_role_id);
					session.putValue("practitioner_name",practitioner_name);
					session.putValue("practitioner_type",pract_type);

					String resp_name="";

					if(rs!=null){
						if(rs.next())
							resp_name = rs.getString(1);
						
						session.putValue("resp_name",resp_name);
					}
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
		}

	/*	Monday, May 17, 2010 Venkats PE_EXE 
	sqlstr			=	"select patient_id_length from mp_param where module_id='MP' ";
		stmt			=	con.createStatement();
		rs				=	stmt.executeQuery(sqlstr);
	    if(rs	 != null)
		if(rs.next())
			pid_length	=	rs.getString(1);
        if(pid_length==null || pid_length.equals(""))
			pid_length	= "20";
		*/
		pid_length	=	(request.getParameter("pid_length")==null)? "20" : request.getParameter("pid_length");
		session.removeAttribute("AEUSER");
		queue_refresh_interval	=	(request.getParameter("queue_refresh_interval")==null)? "300" : request.getParameter("queue_refresh_interval");
		p_cutoff_hours_prv_day_visit=	(request.getParameter("p_cutoff_hours_prv_day_visit")==null)? "" : request.getParameter("p_cutoff_hours_prv_day_visit");
		checkout_yn	=	request.getParameter("checkout_yn") ;
		where_condition=(checkout_yn.equals("Y"))?"and checkout_pat_yn = 'Y'":"and manage_queue_yn = 'Y' ";
		//if(stmt!=null)stmt.close();
		//if(rs!=null)rs.close();
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		
				query_location.append("select a.CLINIC_CODE, a.long_desc clinic_desc,  a.CLINIC_TYPE, OPEN_TO_ALL_PRACT_YN,a.SPECIALITY_CODE  from OP_CLINIC_lang_vw a, (select day_no from  sm_day_of_week where day_of_week =  rtrim(to_char(sysdate,'DAY'))) b where 	 language_id='"+locale+"' and decode(b.day_no,'1',working_day_1,'2', working_day_2,'3',working_day_3,'4',  working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y'   and a.facility_id = ? and a.clinic_type in  (select locn_type  from am_care_locn_type where care_locn_type_ind='C')   and a.level_of_care_ind = 'E'   and a.eff_status = 'E'  and  (a.clinic_type, a.clinic_code) in  (select locn_type, locn_code from  am_os_user_locn_access_vw  where facility_id = ? and Oper_stn_id = ? and  appl_user_id = ? ");
				query_location.append(" ");
				query_location.append(where_condition);
				query_location.append(")  order by 2 ");
				pstmt		=	con.prepareStatement(query_location.toString());
				pstmt.setString	(	1,	facility_id		);
				pstmt.setString	(	2,	facility_id		);
				pstmt.setString	(	3,	oper_stn_id		);
				pstmt.setString	(	4,	login_user_id	);
				

				rs			=	pstmt.executeQuery();
				String spec_code="";
				while(rs.next()) 
				{
					clinic_code				=	rs.getString("clinic_code");
					clinic_desc				=	rs.getString("clinic_desc");
					clinic_type				=	rs.getString("clinic_type");
					open_to_all_pract_yn	=	rs.getString("open_to_all_pract_yn");
					spec_code=rs.getString("speciality_code");
					if(rowIndex==1) 
					{
						first_clinic_code			=	clinic_code;
						first_open_to_all_pract_yn	=	open_to_all_pract_yn;
						//selected_prop				=	" SELECTED ";
					}
					else
					{
						//selected_prop	=	"";
					}
		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(selected_prop));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(clinic_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(spec_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
			
					rowIndex++;
				}
		
				if(rs!=null)rs.close();
				if(pstmt!=null)	pstmt.close();

		
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

		
				rowIndex				=	1;
				clinic_code				=	first_clinic_code;
	            
				query_treatment_area.append(" select treatment_area_code, short_desc treatment_area_desc,  gender treatment_area_gender, open_to_all_prac_for_clinic_yn  from ae_tmt_area_for_clinic_lang_vw   where language_id='"+locale+"' and facility_id = ? and CLINIC_CODE = ? and  eff_status = 'E' order by 2 ");

				pstmt		=	con.prepareStatement(query_treatment_area.toString());

				pstmt.setString	(	1,	facility_id		);
				pstmt.setString	(	2,	clinic_code		);

				rs			=	pstmt.executeQuery();

				while(rs.next())
				{
					treatment_area_code				=	rs.getString("treatment_area_code");
					treatment_area_desc				=	rs.getString("treatment_area_desc");
					treatment_area_gender			=	rs.getString("treatment_area_gender");
					open_to_all_prac_for_clinic_yn	=	rs.getString("open_to_all_prac_for_clinic_yn");

					if(treatment_area_gender==null)				treatment_area_gender			=	"";
					if(open_to_all_prac_for_clinic_yn==null)	open_to_all_prac_for_clinic_yn	=	"N";
					//<!-- parent.f_query_add_mod.AEMPSearchCriteriaFrame.-- >
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(treatment_area_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(treatment_area_gender));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rowIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn ));
            _bw.write(_wl_block28Bytes, _wl_block28);

					rowIndex++;
				} // end of while
		
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
		
			
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(pid_length));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
 
		
				clinic_code						=	first_clinic_code;
				open_to_all_pract_yn			=	first_open_to_all_pract_yn;
				open_to_all_prac_for_clinic_yn	=	"";
				treatment_area_code				=	"";
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

		
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
		session.removeAttribute("checkVal");

	query_operator_station.setLength(0);
    query_location.setLength(0);
    query_treatment_area.setLength(0); 
	
	
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(called_from_ca));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_refresh_interval));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(p_cutoff_hours_prv_day_visit));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(checkout_yn));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(first_open_to_all_pract_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(isAppearAsTabEnable));
            _bw.write(_wl_block50Bytes, _wl_block50);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.BedBayStatus.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Vacant.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Occupied.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Reserved.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }
}
