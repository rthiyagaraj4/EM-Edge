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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __oalocationlookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/OALocationlookupresult.jsp", 1709119245928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\n<html>\n    <head>\n        <title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n        <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\'javascript\' src=\'../../eOA/js/OALocationlookup.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<p>\n\t<table align=\'right\' cellspacing=\"0\">\n\t <tr>\n\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t </tr>\n\t</table>\n</p>\n<BR><BR>\n<table border=\"1\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\">\n<th >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n<th >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\n\t\t<tr><td class=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n \t\t<!-- <a href=\'javascript:retvalue(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\")\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> Commented by Shanthi for the SCF - ML-BRU-SCF-0253 33367 -->\n\t\t<a href=\"javascript:retvalue(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t\t<td class=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td></tr>\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<script>\t\n\t\tdocument.getElementById(\"nextvalue\").innerHTML=\" \";\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t//retvalue(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\");\n\t\tretvalue(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\");\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</script>\n\t<input type=\"hidden\" name=\"functionID\" id=\"functionID\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String facilityId	=(String) session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	String locn_type=request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
	String care_locn_ind=request.getParameter("care_locn_ind")==null?"":request.getParameter("care_locn_ind");
	String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");	
	String clinic_code=request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");	
	String clinic_desc=request.getParameter("clinic_desc")==null?"":request.getParameter("clinic_desc");	
	clinic_desc=clinic_desc.replaceAll("'","''");// included for the SCF ML-BRU-SCF-0253 33367
	String start_ends_contains=request.getParameter("start_ends_contains")==null?"":request.getParameter("start_ends_contains");	
	String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	String search_click = request.getParameter("search_click")==null?"N":request.getParameter("search_click");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String tab_Selected = request.getParameter("tab_Selected")==null?"":request.getParameter("tab_Selected");
	String oper_stn_id = request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	String order_catalog_code=request.getParameter("order_catalog_code")==null?"":request.getParameter("order_catalog_code");
	String order_by=request.getParameter("order_by")==null?"":request.getParameter("order_by");
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	String displayAll=request.getParameter("displayAll")==null?"N":request.getParameter("displayAll");
	
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	

            _bw.write(_wl_block6Bytes, _wl_block6);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con=null;
	PreparedStatement pstmt=null;
	//Statement s=null;
	ResultSet rs=null;
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
	String loginuser 	= (String) session.getValue( "login_user" ) ;
	StringBuffer sql_sb=new StringBuffer();
	String code="";
	String desc="";
	String open_to_all_pract_yn="";
	String retval="";
	String sql="";
	String ident_at_checkin="";
	String care_loc_ind="";
	if(care_locn_ind.equals("Y")){
		care_loc_ind="D";
	}else{
		care_loc_ind=care_locn_ind;
	}

	if(locn_type.equals("D"))
	locn_type="Y";

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		

	if(function_id.equals("WAIT_LIST")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
		sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , am_locn_for_oper_stn b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.SPECIALTY_CODE='"+speciality_code+"' and a.language_id='"+locale+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' and a.facility_id=c.Facility_id ";//query modified for 33672

	}else{
		sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.language_id='"+locale+"' "+whereClause+"  ";

	}
	}else if(function_id.equals("WAIT_LIST_MODIFY")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
	sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b, ip_nurs_unit_for_specialty c  where B.locn_type = 'N' and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id='"+oper_stn_id+"'  AND A.EFF_STATUS = 'E'  and a.facility_id='"+facilityId+"' and c.SPECIALTY_CODE='"+speciality_code+"' and language_id = '"+locale+"' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' AND b.appl_user_id='"+loginuser+"' AND b.MODIFY_WAIT_LIST_YN='Y' ";
	}else{
	sql="Select a.long_desc long_desc, a.clinic_code clinic_code, a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where  a.facility_id=b.facility_id and b.oper_stn_id='"+oper_stn_id+"'  AND a.clinic_code=b.locn_code AND b.appl_user_id='"+loginuser+"' AND b.MODIFY_WAIT_LIST_YN='Y' "+whereClause+" and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and a.rd_appl_yn = '"+rd_appt_yn+"' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type ";
	}

	}else if(function_id.equals("QRY_APPT_PAT")|| function_id.equals("QRY_BLK_APPT")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn,primary_resource_class FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";//query modified for 33238

	}else if(function_id.equals("CLINICS_FOR_DAY") || function_id.equals("GRP_APPT_DOCT") || function_id.equals("QRY_APPT_DOCT") || function_id.equals("QRY_SCH")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn,primary_resource_class FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";//query modified for 33238
	}else if(function_id.equals("TRANSFER_CANCEL_APPT")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
		
			if(displayAll.equals("N")){
				sql_sb.append(" and a.rd_appl_yn = '"+rd_appt_yn+"' ");
			}

	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
			if(!order_catalog_code.equals("")){
				sql_sb.append(" AND ( c.order_catalog_code='"+order_catalog_code+"' OR EXISTS (SELECT 1 FROM OR_ORDER_SET_COMPONENT WHERE  ORDER_SET_CODE=c.ORDER_CATALOG_CODE AND ORDER_CATALOG_CODE='"+order_catalog_code+"' ) )");
			}
		whereClause=new String(sql_sb.toString());
	}
	
	
	if(!order_catalog_code.equals("")){
		//sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn  from op_clinic_lang_vw a,am_os_user_locn_access_vw b,op_catalog_for_clinic c where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type and a.facility_id=c.facility_id and a.clinic_code=c.clinic_code " +whereClause+"  ";
        /*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/		
		sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn,a.PRIMARY_RESOURCE_CLASS PRIMARY_RESOURCE_CLASS  from op_clinic_lang_vw a,am_os_user_locn_access_vw b,op_catalog_for_clinic c where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type and a.facility_id=c.facility_id and  a.clinic_code=c.clinic_code " +whereClause+"  ";

	}else{
		//sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn  from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.clinic_type=b.locn_type " +whereClause+"  ";
		/*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/		
		sql="select a.long_desc long_desc,a.clinic_code clinic_code,open_to_all_pract_yn open_to_all_pract_yn,a.PRIMARY_RESOURCE_CLASS PRIMARY_RESOURCE_CLASS  from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.level_of_care_ind = 'A' and a.facility_id='"+facilityId+"' and a.eff_status = 'E' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and  b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and a.language_id='"+locale+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y')  and a.clinic_type=b.locn_type " +whereClause+"  ";
	}

	}else if(function_id.equals("SetUpDailySchedule")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select care_locn_type_ind,a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur,a.PRIMARY_RESOURCE_CLASS,a.rd_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" and b.locn_type=a.clinic_type ";


	}else if(function_id.equals("GEN_SCH")){
		sql_sb.append(" AND clinic_type='"+locn_type+"' AND CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"'"+whereClause+"  and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type ";


	}else if(function_id.equals("BLK_APPT_SLOTS")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin  from op_clinic_lang_vw a, am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code  and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" and a.clinic_type=b.locn_type ";


	}else if(function_id.equals("TRAN_SCH")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc, a.clinic_code clinic_code, open_to_all_pract_yn,a.clinic_type locn_type from op_clinic_lang_vw a, am_care_locn_type b ,am_locn_for_oper_stn c where a.facility_id='"+facilityId+"' and c.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.language_id='"+locale+"' and a.allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type = b.locn_type and c.locn_code=a.clinic_code"+whereClause+" and b.locn_type=a.clinic_type and b.locn_type=c.locn_type and a.facility_id=c.facility_id ";//condition modified for 33672



	}else if(function_id.equals("BLK_LIFT_CANC_SCH")||function_id.equals("PURG_SCH_REC")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc, a.clinic_code clinic_code, open_to_all_pract_yn, a.ident_at_checkin,a.clinic_type locn_type,a.primary_resource_class  from op_clinic_lang_vw   a, am_care_locn_type b ,am_locn_for_oper_stn c where c.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"'  AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and c.locn_code=a.clinic_code and a.language_id='"+locale+"' and a.facility_id='"+facilityId+"' and a.facility_id=c.facility_id and allow_appt_yn='Y' and a.eff_status='E' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type and  B.LOCN_TYPE=C.LOCN_TYPE"+whereClause+" ";//condition modified for 33672



	}else if(function_id.equals("PRACT_DUTY_ROSTER")){
		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+facilityId+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type "+whereClause+"  ";


	}else if(function_id.equals("CHG_PRACT_SCH")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc long_desc,a.clinic_code clinic_code,a.clinic_type clinic_type, a.open_to_all_pract_yn open_to_all_pract_yn  from OP_CLINIC_lang_vw a,am_locn_for_oper_stn b where a.facility_id='"+ facilityId + "' and a.allow_appt_yn='Y' and b.OPER_STN_ID =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+loginuser+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.level_of_care_ind = 'A' and a.eff_status='E' and a.language_id='"+locale+"' and  a.facility_id=b.facility_id and a.clinic_code = b.locn_code and a.clinic_type=b.locn_type "+whereClause+"  ";//condition modified for 33672



	}else if(function_id.equals("HOLIDAY")){
		if(tab_Selected.equals("Location")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	if(clinic_code.equals("") && clinic_desc.equals("")){
		//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
		sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ) ";
	}else{
		//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
		sql="Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E'  and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ";
	}

	

		}else if(tab_Selected.equals("Holiday")){

		sql_sb.append(" AND a.clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_loc_ind+"' ");
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(a.LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	if(clinic_code.equals("") && clinic_desc.equals("")){
	sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ) ";
	}else{
	sql="Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ";
	}
	
	}

	}else if(function_id.equals("APPT_WAIT_LIST")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		if(locn_type.equals("N")){ 
			// modified on 22 mar 2010 to handle the ursing unit lookup. if condition added
			sql_sb.append("AND a.facility_id='"+facilityId+"' AND a.language_id='"+locale+"' and a.LOCN_TYPE=b.LOCN_TYPE ");
			if(!speciality_code.equals("")){
				sql_sb.append(" AND c.SPECIALTY_CODE='"+speciality_code+"' ");
			}
		}else{
			sql_sb.append("AND a.facility_id='"+facilityId+"' AND a.language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"'  and a.clinic_type=b.LOCN_TYPE ");
			if(!speciality_code.equals("")){
				sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}

	if(locn_type.equals("N")){
		sql="Select a.long_desc long_desc, a.NURSING_UNIT_CODE clinic_code from IP_Nursing_unit_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b,ip_nurs_unit_for_specialty c  where B.locn_type = 'N'  and a.facility_id = b.facility_id and a.NURSING_UNIT_CODE=b.locn_code and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate)))  AND A.EFF_STATUS = 'E' and c.NURSING_UNIT_CODE=a.NURSING_UNIT_CODE and c.facility_id='"+facilityId+"' AND b.appl_user_id='"+loginuser+"' AND b.CREATE_WAIT_LIST_YN='Y' "+whereClause+" ";


	}else{
		sql="Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn,to_char(WORKING_DAY_START_TIME,'HH24:mi') STime,to_char(WORKING_DAY_END_TIME,'HH24:mi') ETime, to_char(BASE_SLOT_SLAB_TIME,'HH24:mi') dur from op_clinic_lang_vw a , AM_OS_USER_LOCN_ACCESS_VW b  where a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and a.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and b.CREATE_WAIT_LIST_YN='Y' and b.appl_user_id='"+loginuser+"'"+whereClause+"  and a.clinic_type=b.LOCN_TYPE and a.rd_appl_yn='"+rd_appt_yn+"'";
	}

	}else if(function_id.equals("SCH_APPT")){
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append(" AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.open_to_all_pract_yn,a.long_desc,a.clinic_code from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id='"+facilityId+"' and a.rd_appl_yn='"+rd_appt_yn+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and (b.book_appt_yn='Y' or b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.language_id='"+locale+"' and a.clinic_type=b.locn_type "+whereClause+"  ";

	}else if(function_id.equals("BULK_TRANSFER")){
		//code for bulk transfer
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="select a.long_desc,a.clinic_code,open_to_all_pract_yn,PRIMARY_RESOURCE_CLASS from op_clinic_lang_vw a,am_os_user_locn_access_vw b where a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind = 'A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+loginuser+"' and a.language_id='"+locale+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+loginuser+"' and (b.tfr_appt_yn='Y' or b.canc_appt_yn='Y') and a.eff_status = 'E' and a.clinic_type=b.locn_type "+whereClause+" "; 
	}else{
	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql_sb.append("AND a.facility_id='"+facilityId+"' AND language_id='"+locale+"' AND  clinic_type='"+locn_type+"' AND a.CARE_LOCN_TYPE_IND='"+care_locn_ind+"' ");
		if(!speciality_code.equals("")){
			sql_sb.append(" AND A.SPECIALITY_CODE='"+speciality_code+"' ");
			}
		if(!clinic_code.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND CLINIC_CODE like upper('"+clinic_code+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND CLINIC_CODE like upper('%"+clinic_code+"%') ");
			}
			}
		if(!clinic_desc.equals("")){
			if(start_ends_contains.equals("S")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('"+clinic_desc+"%') ");
			}else if(start_ends_contains.equals("E")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"') ");
			}else if(start_ends_contains.equals("C")){
			sql_sb.append(" AND upper(LONG_DESC) like upper('%"+clinic_desc+"%') ");
			}
			}
		whereClause=new String(sql_sb.toString());
	}
	
	sql="SELECT a.clinic_code clinic_code,a.long_desc long_desc,open_to_all_pract_yn FROM  op_clinic_lang_vw a WHERE level_of_care_ind = 'A' AND a.eff_status='E' "+whereClause+"  ";
	}
	/*
	if(function_id.equals("HOLIDAY") && tab_Selected.equals("Location")){
		if(order_by.equals("D")){
			sql = sql + "order by Nvl(care_locn_type_ind,'!') , long_desc";
		}else{
			sql = sql + "order by Nvl(care_locn_type_ind,'!') , clinic_code";
		}
	} else {
	if(order_by.equals("D")){
		sql = sql + "order by long_desc";
	}else{
		sql = sql + "order by clinic_code";
	}
	}
	*/
	if(order_by.equals("D")){
		sql = sql + "order by long_desc";
	}else{
		sql = sql + "order by clinic_code";
	}


	
	int cnt=0;	
	try{
	con = ConnectionManager.getConnection(request);
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
	pstmt = con.prepareStatement(sql);
	rs=pstmt.executeQuery();
	
	if(function_id.equals("HOLIDAY") && (rs!=null && rs.next())){  
		if(function_id.equals("HOLIDAY") && tab_Selected.equals("Location")){  
			if(clinic_code.equals("") && clinic_desc.equals("")){
				//below Query is modified for SS-SCF-0788 by Kamatchi S on 13-AUG-2020
				sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"'  and a.EFF_STATUS='E' and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" UNION Select NULL care_locn_type_ind,'*All' long_desc,'*A' clinic_code,null clinic_type from dual) ";
			}else{
				//below Query is modified for SS-SCF-0788 by Kamatchi S on 02-SEP-2020
				sql="Select a.care_locn_type_ind care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a WHERE a.clinic_code  IN (SELECT locn_code FROM oa_holiday where facility_id='"+facilityId+"')  and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and language_id='"+locale+"' and a.level_of_care_ind = 'A' and a.ALLOW_APPT_YN='Y' "+whereClause+" ";
			}
		}else if(function_id.equals("HOLIDAY") && tab_Selected.equals("Holiday")){
			if(clinic_code.equals("") && clinic_desc.equals("")){
				sql="SELECT care_locn_type_ind,long_desc,clinic_code,clinic_type FROM (Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" UNION Select NULL care_locn_type_ind,'*All' long_desc,'*A' clinic_code,null clinic_type from dual) ";
			}else{
				sql="Select care_locn_type_ind,a.long_desc long_desc,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type from op_clinic_lang_vw a   where    LANGUAGE_ID = '"+locale+"' AND a.clinic_code not in (select locn_code from oa_holiday where facility_id='"+facilityId+"' ) and a.facility_id='"+facilityId+"' and a.EFF_STATUS='E' and a.level_of_care_ind = 'A'   and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' "+whereClause+" ";
			}
		}		
		if(order_by.equals("D")){
			sql = sql + "order by long_desc";
		}else{
			sql = sql + "order by clinic_code";
		}
		if(pstmt!=null)pstmt.close();
		if(rs!=null)rs.close();		
		pstmt = con.prepareStatement(sql);
		rs=pstmt.executeQuery();
	}
	
	
	if(start !=1){
		for(int j=1;j<start;i++,j++){
			rs.next() ;
		}
	 }

	while(i<=end && rs.next()){
		if(cnt==0){
			

            _bw.write(_wl_block9Bytes, _wl_block9);
 
	if ( !(start <= 1) )
	 out.println("<td><A HREF=\"../../eOA/jsp/OALocationlookupresult.jsp?from="+(start-14)+"&to="+(end-14)+"&function_id="+function_id+"&tab_Selected="+tab_Selected+"&oper_stn_id="+oper_stn_id+"&locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&search_click="+search_click+"&clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&start_ends_contains="+start_ends_contains+"&order_catalog_code="+order_catalog_code+"&order_by="+order_by+"\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	 out.println("<td><A id='nextvalue' HREF=\"../../eOA/jsp/OALocationlookupresult.jsp?from="+(start+14)+"&to="+(end+14)+"&function_id="+function_id+"&tab_Selected="+tab_Selected+"&oper_stn_id="+oper_stn_id+"&locn_type="+locn_type+"&speciality_code="+speciality_code+"&care_locn_ind="+care_locn_ind+"&search_click="+search_click+"&clinic_code="+clinic_code+"&clinic_desc="+clinic_desc+"&start_ends_contains="+start_ends_contains+"&order_catalog_code="+order_catalog_code+"&order_by="+order_by+"\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
	String classValue = "" ;
	
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;


			if(function_id.equals("SetUpDailySchedule")){
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
			String alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			String STime=rs.getString("STime")==null?"":rs.getString("STime");
			String ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
			String dur=rs.getString("dur")==null?"":rs.getString("dur");
			String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
			String rd_appl_yn=rs.getString("rd_appl_yn")==null?"N":rs.getString("rd_appl_yn");

			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur+"~"+primary_resource_class+"~"+rd_appl_yn;
			}else if(function_id.equals("GEN_SCH")){

			code=rs.getString("clinic_code");
			desc=rs.getString("long_desc");
			String locntype=rs.getString("clinic_type");
			retval=code+"~"+desc+"~"+locntype;

			}else if(function_id.equals("BLK_APPT_SLOTS")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin;

			}else if(function_id.equals("TRAN_SCH")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("locn_type")==null?"":rs.getString("locn_type");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type;

			}else if(function_id.equals("CHG_PRACT_SCH")){
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type;

			}else if(function_id.equals("BLK_LIFT_CANC_SCH")||function_id.equals("PURG_SCH_REC")){

			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");	
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("locn_type")==null?"":rs.getString("locn_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String primary_resource_class=rs.getString("primary_resource_class")==null?"":rs.getString("primary_resource_class");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+primary_resource_class;

			}else if(function_id.equals("PRACT_DUTY_ROSTER")){
				///pract
			code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
			desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
			String clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
			ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
			String fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
			String alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
			String STime=rs.getString("STime")==null?"":rs.getString("STime");
			String ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
			String dur=rs.getString("dur")==null?"":rs.getString("dur");
			retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;

			}else if(function_id.equals("HOLIDAY")){
				if(tab_Selected.equals("Location")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				care_loc_ind=rs.getString("care_locn_type_ind")==null?"":rs.getString("care_locn_type_ind");
				retval=code+"~"+desc+"~"+care_loc_ind;
				}else if(tab_Selected.equals("Holiday")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				care_loc_ind=rs.getString("care_locn_type_ind")==null?"":rs.getString("care_locn_type_ind");
				retval=code+"~"+desc+"~"+care_loc_ind;
				}
				
			}else if(function_id.equals("WAIT_LIST")){
				String clinic_type="";
				ident_at_checkin="";
				String fi_visit_type_appl_yn="";
				String alcn_criteria="";
				String STime="";
				String ETime="";
				String dur="";
				if(locn_type.equals("N")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn="";
				clinic_type="N";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur="";
				}else{
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
				clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
				ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
				STime=rs.getString("STime")==null?"":rs.getString("STime");
				ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
				dur=rs.getString("dur")==null?"":rs.getString("dur");
				}
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;
			}else if(function_id.equals("APPT_WAIT_LIST")){
				String clinic_type="";
				ident_at_checkin="";
				String fi_visit_type_appl_yn="";
				String alcn_criteria="";
				String STime="";
				String ETime="";
				String dur="";
				if(locn_type.equals("N")){
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn="";
				clinic_type="N";
				ident_at_checkin="";
				fi_visit_type_appl_yn="";
				alcn_criteria="";
				STime="";
				ETime="";
				dur="";
				}else{
				code=rs.getString("clinic_code")==null?"":rs.getString("clinic_code");
				desc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn")==null?"":rs.getString("open_to_all_pract_yn");
				clinic_type=rs.getString("clinic_type")==null?"":rs.getString("clinic_type");
				ident_at_checkin=rs.getString("ident_at_checkin")==null?"":rs.getString("ident_at_checkin");
				fi_visit_type_appl_yn=rs.getString("fi_visit_type_appl_yn")==null?"":rs.getString("fi_visit_type_appl_yn");
				alcn_criteria=rs.getString("alcn_criteria")==null?"":rs.getString("alcn_criteria");
				STime=rs.getString("STime")==null?"":rs.getString("STime");
				ETime=rs.getString("ETime")==null?"":rs.getString("ETime");
				dur=rs.getString("dur")==null?"":rs.getString("dur");
				}
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+clinic_type+"~"+ident_at_checkin+"~"+fi_visit_type_appl_yn+"~"+alcn_criteria+"~"+STime+"~"+ETime+"~"+dur;
			}else if(function_id.equals("SCH_APPT")){
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				retval=code+"~"+desc+"~"+open_to_all_pract_yn;
			}else if(function_id.equals("BULK_TRANSFER")){
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				//retval=code+"~"+desc+"~"+open_to_all_pract_yn;
				retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+primary_resource_class;
			}else if(function_id.equals("WAIT_LIST_MODIFY")){
				desc=rs.getString("long_desc");
				code=rs.getString("clinic_code");
				if(locn_type.equals("N")){
					open_to_all_pract_yn="*";
				}else{
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				}

				retval=code+"~"+desc+"~"+open_to_all_pract_yn;

			}else{
				code=rs.getString("clinic_code");
				desc=rs.getString("long_desc");
				open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
				//retval=code+"~"+desc+"~"+open_to_all_pract_yn;
				/*Below Line Added and Above Line Commented for this SCF ML-BRU-SCF-0240 [IN:033238]*/	
                 String primary_resource_class=rs.getString("PRIMARY_RESOURCE_CLASS")==null?"":rs.getString("PRIMARY_RESOURCE_CLASS");
                 retval=code+"~"+desc+"~"+open_to_all_pract_yn+"~"+primary_resource_class;				 
			}	
			retval=retval.replaceAll("'","\\\\'");// included for the SCF ML-BRU-SCF-0253 33367
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block20Bytes, _wl_block20);


cnt++;
i++;

}
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	
            _bw.write(_wl_block21Bytes, _wl_block21);
if((cnt==1 && i==2)&& search_click.equals("N")){
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(java.net.URLEncoder.encode(retval)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(retval));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
}
}catch(Exception e){
	//out.println("OA failed @@"+e.toString());
	e.printStackTrace();
}finally {
	if(pstmt!=null)pstmt.close();
	if(rs!=null)rs.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
}
