package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.io.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __displayapptresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/displayApptResults.jsp", 1709119232897L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<Script src=\"../../eOA/js/ChangeDate.js\" language=\"JavaScript\"></Script>\n <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n <script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script> \n  <script language=\'javascript\' src=\'../../eCommon/js/tableheaderscroll.js\'></script>\n <style type=\"text/css\">\n\t\ttable.mt {border-width: 1px;border-spacing:0px ;border-collapse: collapse;}\n\t\ttable.mt th {border-width: 1px;padding: 1px;white-space: normal; text-align:left;word-wrap:normal;}\n\t\ttable.mt td {white-space:normal;word-wrap: break-word; word-break: break-all;}\n</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<html>\n\t\t<head>\t\n\n\t</head>\n\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n<body onLoad=\'visiblelity()\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onscroll=\"scrollheader();\">\n\n<form name=\"single_pract\" id=\"single_pract\">\n\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'SCHEDULE_APPOINTMENT\'>\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table border=\'1\' width=\'99%\' style=\'border-spacing:0px ;border-collapse: collapse;\' id=\'dataTable\' class=\'mt\'>\n\t<tr>\n\t<th align=\'left\' width=\'4%\'><div  id=\'head1\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</div></th>\n\t<th align=\'left\' width=\'4%\'><div  id=\'head2\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</div></th>\n\t<th align=\'left\' width=\'4%\'><div  id=\'head3\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div></th>\n\t<th align=\'left\' width=\'21%\'><div  id=\'head4\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</div></th>\n\t<th align=\'left\' width=\'5%\'><div  id=\'head5\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div></th>\n\t<th align=\'left\' width=\'12%\' ><div  id=\'head6\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div></th>\n\t<th align=\'left\' width=\'15%\' ><div  id=\'head7\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</div></th>\n\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<th align=\'left\' width=\'15%\' ><div  id=\'head10\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div></th> \n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<th align=\'left\' width=\'12%\'><div  id=\'head8\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div></th>\n\t<th align=\'left\' width=\'15%\' ><div  id=\'head9\'  class=\'myClass\' nowrap >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div></th>\n</tr>\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<tr>\n\t\t\t\n<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" width=\'50%\' colspan=\'9\'><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<tr>\n<td class=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr> \n\t\t\t\t<td ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" class=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<td ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' >&nbsp;</td>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n<td ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'><center><img src=\'../../eCommon/images/inpatient.gif\'><center></td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t\t<td ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<img src=\'../../eCommon/images/PI_VIP.gif\' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  style=\"background-color:";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t<td ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<td ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' >&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<!--End ML-MMOH-CRF-1114-->\n\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</br>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\t\n\t\t\t\t\n\t\t\t</tr>\n\t\t\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n</table>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'COMMON\'));\n</script>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n<script> fxheaderInit(\'dataTable\',420);\t</script>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n      \n</form>\n</body>\n\t\t\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );


public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//out.println("sStyle==>" +sStyle);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		request.setCharacterEncoding("UTF-8");	
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");

		Connection con = null;
		PreparedStatement pstmt_label		= null;
				
		ResultSet rs32= null;
		String wrap_reqd="";
		wrap_reqd="nowrap";
		String facilityid=(String)session.getValue("facility_id");
		String locale = (String)session.getAttribute("LOCALE");
		StringBuffer  sql_label =new StringBuffer();
		String show_vip="N";
		
try
{
		String clinic_code=(String)request.getParameter("clinic_code");
		if( clinic_code == null|| clinic_code.equals("null")) clinic_code="";
		String practitioner_id=(String)request.getParameter("practitioner_id");
		if( practitioner_id == null|| practitioner_id.equals("null")) practitioner_id="";
		String Date=(String)request.getParameter("Date");
		String res_type=request.getParameter("res_type");
			
		String clinic_type=request.getParameter("clinic_type");
		String from_page=request.getParameter("from_page");
	
		String oper_stn_id=request.getParameter("oper_stn_id");
			if(oper_stn_id == null) oper_stn_id="";
			if(oper_stn_id!=null && !oper_stn_id.equals("")){
				show_vip="Y";
			}
		String rd_appt_yn=request.getParameter("rd_appt_yn");
		String colour_indicator="";
		String care_locn_type_ind="";
		String res_ind="";
		String nowarp1 ="";
		String res_class_desc				="";
		
	con=ConnectionManager.getConnection(request);

	Boolean isRemarksFieldAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA", "REMARKS_FOR_OTHERS"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		
	
	if(res_type.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_type.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_type.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_type.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}
		String care_locn_ind_desc	  		="";
		
		String P_O_CLINIC             		="";       
		String P_O_FROM_TIME          		="";
		String P_O_TO_TIME            		="";
		String P_O_APPT_REF_NO        		="";
		String P_O_PATIENT_NAME       		="";
		String P_O_PATIENT_ID         		="";
		String P_O_VISIT_TYPE_DESC       	="";
		String P_O_CONTACT_REASON_CODE      ="";
		String P_O_PATIENT_GENDER       	="";
		String P_O_PATIENT_AGE      		="";
		String P_O_VISIT_TYPE_IND     		="";
		String date1 						="";
		String sql							="";
		String P_O_practitioner_id			="";
		String oth_contact_no				=""; 
		String res_tel_no					="";
		String P_O_PRACTITIONER_NAME       	="";
		String PATIENT_CAT_CODE       		="";
		String APPT_REMARKS		      		=""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		String practName ="";
		String findme ="";
		int i = 0;	
		int cnt = 0;
		String classValue="";
		
	sql_label.append("SELECT NVL (TO_CHAR (appt_slab_from_time, 'hh24:mi'),' ') appt_slab_from_time,NVL (TO_CHAR (appt_slab_to_time, 'hh24:mi'), ' ') appt_slab_to_time,appt_ref_no,patient_id,DECODE ('"+locale+"','"+locale+"', patient_name,NVL (patient_name_loc_lang, patient_name))patient_name,gender,mp_get_age_ymdh (date_of_birth)age,    op_get_desc.op_visit_type(facility_id,appt_type_code,'"+locale+"','2') visit_type_short_desc,(select contact_reason from am_contact_reason_lang_vw where  contact_reason_code=oa_appt_patient_vw.TRANS_EXCEED_REASON_CODE and nvl(trans_exceed_reason_yn,'N') = 'Y' and  language_id='"+locale+"')translator_override_reason,(SELECT OTH_CONTACT_NO FROM oa_appt WHERE appt_ref_no = oa_appt_patient_vw.appt_ref_no)oth_contact_no,(SELECT RES_TEL_NO FROM oa_appt WHERE appt_ref_no = oa_appt_patient_vw.appt_ref_no)RES_TEL_NO,op_get_desc.op_clinic(facility_id,clinic_code,'"+locale+"','1')clinic_name,DECODE(resource_class,'P',am_get_desc.am_practitioner(practitioner_id,'"+locale+"','1'),'R',am_get_desc.am_facility_room(facility_id,practitioner_id,'"+locale+"','2'),'E',am_get_desc.am_resource(facility_id,practitioner_id,'"+locale+"','2'),'O',am_get_desc.am_resource(facility_id,practitioner_id,'"+locale+"','2'))practitioner_full_name,sm_get_desc.sm_appl_user(modified_by_id, '"+locale+"', '1') modified_by,sm_get_desc.sm_appl_user(added_by_id, '"+locale+"', '1')added_by,TO_CHAR (added_date, 'dd/mm/yyyy hh24:mi') added_date, facility_id,TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi')modified_date,am_get_desc.am_speciality (speciality_code,'"+locale+"','2') speciality_desc,         sm_get_desc.sm_facility_param (facility_id,'"+locale+"',1)facility_name,(SELECT deceased_yn FROM mp_patient WHERE patient_id = oa_appt_patient_vw.patient_id) deceased_yn,(SELECT color_indicator FROM op_visit_type     WHERE facility_id = oa_appt_patient_vw.facility_id AND visit_type_code = oa_appt_patient_vw.appt_type_code)color_indicator,(SELECT am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)FROM oa_appt WHERE facility_id = oa_appt_patient_vw.facility_id AND appt_ref_no = oa_appt_patient_vw.appt_ref_no)contact_reason,care_locn_type_ind,resource_class,PATIENT_CAT_CODE,appt_remarks FROM oa_appt_patient_vw WHERE facility_id = '"+facilityid+"'AND appt_date = TO_DATE (NVL ('"+Date+"','01/01/1400'),'dd/mm/yyyy')AND UPPER (patient_name) LIKE UPPER ('%%')"); ////Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	
	
	if(!clinic_code.equals("")){
		sql_label.append("AND CLINIC_CODE = '"+clinic_code+"'");
			
	if(!res_type.equals("")){
			sql_label.append("AND resource_class = '"+res_type+"'");
	} 
		sql_label.append("AND care_locn_type_ind = '"+clinic_type+"'");
		sql_label.append("ORDER BY resource_class,practitioner_full_name,appt_slab_from_time");
		
	}else{
	
	if(!practitioner_id.equals("")){
		sql_label.append("AND practitioner_id = '"+practitioner_id+"'");
	}
		sql_label.append("AND resource_class = '"+res_type+"'");
	if(!clinic_type.equals("")){
			sql_label.append("AND care_locn_type_ind = '"+clinic_type+"'");
	} 
		sql_label.append("ORDER BY care_locn_type_ind,clinic_name,appt_slab_from_time asc");
	}	
		pstmt_label = con.prepareStatement(sql_label.toString());
		rs32 = pstmt_label.executeQuery();
		sql_label=null;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
 while(rs32.next() ){
	if( cnt == 0 ){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(isRemarksFieldAppl){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	 }

if ( i % 2 == 0 )
                classValue = "QRYEVEN" ;
            else
		        classValue = "QRYODD" ;

					
					P_O_FROM_TIME                  =rs32.getString("appt_slab_from_time" );	
					if(P_O_FROM_TIME == null) P_O_FROM_TIME="";
					P_O_TO_TIME = rs32.getString("appt_slab_to_time"); 
					if( P_O_TO_TIME == null) P_O_TO_TIME="";	
					
					P_O_APPT_REF_NO = rs32.getString("APPT_REF_NO"); 
					
					P_O_PATIENT_NAME = rs32.getString("patient_name"); 
					if( P_O_PATIENT_NAME == null) P_O_PATIENT_NAME="";	
					P_O_PATIENT_ID = checkForNull(rs32.getString("patient_id")); 
					P_O_PATIENT_GENDER = checkForNull(rs32.getString("gender")); 
					P_O_PATIENT_AGE= checkForNull(rs32.getString("age"));
					
					P_O_VISIT_TYPE_DESC = rs32.getString("visit_type_short_desc"); 
					P_O_CONTACT_REASON_CODE = checkForNull(rs32.getString("contact_reason")); 
					APPT_REMARKS = checkForNull(rs32.getString("appt_remarks")); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
					care_locn_type_ind  = rs32.getString("care_locn_type_ind");
					res_ind  = rs32.getString("resource_class");
					res_tel_no = checkForNull(rs32.getString("RES_TEL_NO"));
					oth_contact_no = checkForNull(rs32.getString("oth_contact_no"));
					colour_indicator=checkForNull(rs32.getString("COLOR_INDICATOR"));	
					PATIENT_CAT_CODE=checkForNull(rs32.getString("PATIENT_CAT_CODE"));
					practName = rs32.getString("practitioner_full_name")==null?"":rs32.getString("practitioner_full_name");
						
	if(care_locn_type_ind.equals("C")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}else if(care_locn_type_ind.equals("E")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		}else if(care_locn_type_ind.equals("D")){
			care_locn_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
		}
	if(res_ind.equals("P"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
	}else if(res_ind.equals("E"))
	{
	res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
	}else if(res_ind.equals("R"))
	{
   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
	}else if(res_ind.equals("O"))
	{
res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
	}	

		if(clinic_code.equals("")){
		if(!P_O_CLINIC.equals(rs32.getString("clinic_name"))){
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rs32.getString("clinic_name") ));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
			P_O_CLINIC			= rs32.getString("clinic_name");
			}
			else{
			if(!P_O_PRACTITIONER_NAME.equals(practName)){
			
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practName));
            _bw.write(_wl_block27Bytes, _wl_block27);

			}
			P_O_PRACTITIONER_NAME			= practName;	}
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_O_FROM_TIME));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_O_TO_TIME));
            _bw.write(_wl_block33Bytes, _wl_block33);

webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
patdata.setFacility_id(facilityid);			
				String isInpatient = patdata.CheckInPatient(con,P_O_PATIENT_ID,facilityid);
if(!isInpatient.equals("CURRENTLY_IN_PATIENT")) {
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block35Bytes, _wl_block35);

}else{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
} if(!PATIENT_CAT_CODE.equals("")){findme=PATIENT_CAT_CODE.substring(0,1);} else findme="";
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!P_O_PATIENT_ID.equals("")){
            out.print( String.valueOf(P_O_PATIENT_ID));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_PATIENT_NAME));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_PATIENT_AGE));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_PATIENT_GENDER));
}else{
            out.print( String.valueOf(P_O_PATIENT_NAME));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_PATIENT_AGE));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_PATIENT_GENDER));
}if(findme.equals("V")){
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(P_O_APPT_REF_NO));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(P_O_VISIT_TYPE_DESC));
            _bw.write(_wl_block45Bytes, _wl_block45);
/*modified for this CRF [Bru-HIMS-CRF-177]*/
            _bw.write(_wl_block46Bytes, _wl_block46);
if(!P_O_CONTACT_REASON_CODE.equals("")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(P_O_CONTACT_REASON_CODE));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(isRemarksFieldAppl){
            _bw.write(_wl_block50Bytes, _wl_block50);
if(!APPT_REMARKS.equals("")){
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(APPT_REMARKS));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
if((!res_tel_no.equals(""))&&(!oth_contact_no.equals(""))){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_tel_no));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if(!res_tel_no.equals("")){
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_tel_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else if(!oth_contact_no.equals("")) {
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(wrap_reqd));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(rs32.getString("added_by")));
            _bw.write(_wl_block56Bytes, _wl_block56);
	
	i++;
	cnt++;

}
if(rs32 !=null) rs32.close();



            _bw.write(_wl_block57Bytes, _wl_block57);
if(cnt == 0){
            _bw.write(_wl_block58Bytes, _wl_block58);
}else{
            _bw.write(_wl_block59Bytes, _wl_block59);

}

if(pstmt_label !=null)pstmt_label.close();
}catch(Exception e) { 
	e.printStackTrace(); 
}finally{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.isinpatient.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ContactDetails.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ApptGivenBy.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
