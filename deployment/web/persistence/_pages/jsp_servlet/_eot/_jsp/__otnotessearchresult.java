package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.Common.CommonBean;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __otnotessearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/OTNotesSearchResult.jsp", 1709120292000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Created Against ML-MMOH-CRF-1208 [IN:068081] -->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&nbsp;\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\' />\t\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eOT/js/OTNotesSearch.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\tA:ACTIVE {\n\t\tCOLOR: WHITE;\n\t\tTEXT-DECORATION : NONE;\n\t}\n\n\tTD.CAPOPUPMENULAYER\n\t{\n\t\t  FONT-FAMILY: VERDANA;\n\t\t  FONT-SIZE: 10PT;\n\t\t  BACKGROUND-COLOR: #D8BFD8;\n\t\t  COLOR: BLUE;\n\t }\n\t TD.CAPOPUPMENU\n\t{\t\n\t\tBACKGROUND-COLOR: #C0C0C0;\n\t\tFONT-SIZE: 9PT;\n\t\tBORDER-STYLE: DASHED;\n\t\tBORDER-LEFT-COLOR: #FFA500;\n\t\tBORDER-RIGHT-COLOR: #FFA500;\n\t\tBORDER-TOP-COLOR: #FFFACD;\n\t\tBORDER-BOTTOM-COLOR: #FFFACD;\n\t}\n\t</style>\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n<center>\n<form name=\'OTNotesSearchhResultForm\' id=\'OTNotesSearchhResultForm\' action=\"\" method=\"\" target=\"\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<table  class=\'gridComponentHolder\' WIDTH=\'100%\' align=\'center\'  >\n\t\t<tr><td CLASS=\'BODYCOLORFILLED\' >&nbsp;</td>\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<td class=\'LABEL\'  width=\'8%\'><a class=\'gridLink\' href=\"../../eOT/jsp/OTNotesSearchResult.jsp?lower_limit=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&upper_limit=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&noteType=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></td>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td class=\'LABEL\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"../../eOT/jsp/OTNotesSearchResult.jsp?lower_limit=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</tr></table>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t</script>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t<table class=\'grid\' width=\'100%\' id=\'tb1\' align=\'center\'>\n\t\t<th class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</th>\n\t\t<th class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</th>\n\t\t<th></th>\n\t\t<th class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</th>\t\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<tr id=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t<td class=\'gridData\'><a class=\'gridLink\' href=javascript:callRecordSurgeonNotes(\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\")>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</a>&nbsp;</td>\n\t\t\t\t<td>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</table>\n\t<input type=\"hidden\" name=\"query_string\" id=\"query_string\" value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=\"hidden\" name=\"new_query_string\" id=\"new_query_string\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n</form>\n</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;	
	StringBuffer sqlQueryBuffer	=	new StringBuffer();
	StringBuffer whereClause	=	new StringBuffer();
	int	rowCnt					=	0,	maxRecordsDisp		=	10;
	int	startIndex				=	0,	endIndex			=	0;
	int	totalRecordCount		=	0,	colIndex			=	0;
	String patient_id			=	(request.getParameter("patient_id")==null) ?	""	:	request.getParameter("patient_id");
	String encounter_id		=	(request.getParameter("encounter_id")==null) ?	""	:	request.getParameter("encounter_id");
	String fromDateTime		=	(request.getParameter("fromDateTime")==null)	?	""	:	request.getParameter("fromDateTime");
	String toDateTime		=	(request.getParameter("toDateTime")==null)	?	""	:	request.getParameter("toDateTime");
	String lower_limit		=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	String upper_limit		=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	String noteType			=(request.getParameter("noteType")==null)?"":request.getParameter("noteType");
	String appl_task_id		=	(request.getParameter("appl_task_id")==null)?"":request.getParameter("appl_task_id");
	String facility_id		=	(String)		session.getValue("facility_id");
	String login_user_id	=	(String)		session.getValue("login_user");
	String status_display_text =	"";
	StringBuffer  query_string = new StringBuffer();
	query_string.append("patient_id=");		query_string.append(patient_id);
	query_string.append("&encounter_id=");	query_string.append(encounter_id);
	query_string.append("&fromDateTime="); query_string.append(fromDateTime);
	query_string.append("&toDateTime="); query_string.append(toDateTime);
	query_string.append("&appl_task_id="); query_string.append(appl_task_id);

	//Billing Logic Start 
	boolean bill_flag = false; 
	String bl_installed="";
	String err_text = "";
	String bl_interface="";
	CallableStatement cstmt = null;
	//Billing Logic end
	boolean  isModifyNote        =   false ; //Added Against ML-MMOH-CRF-1993
	String locale = (String)session.getAttribute("LOCALE");//Added Against ML-MMOH-CRF-1993
	String fileName   =  "";
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try{
			con = ConnectionManager.getConnection(request);
			
			//Billing Logic Start
			cstmt=con.prepareCall("{call OT_BL_CHECK_INSTALL(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1,facility_id);
			cstmt.setString(2,facility_id);
			cstmt.registerOutParameter(3,Types.VARCHAR);
			cstmt.registerOutParameter(4,Types.VARCHAR);
			cstmt.registerOutParameter(5,Types.VARCHAR);
			cstmt.registerOutParameter(6,Types.VARCHAR);
			cstmt.registerOutParameter(7,Types.VARCHAR);
			cstmt.registerOutParameter(8,Types.VARCHAR);//LANG_ERR_MESG_ID
			cstmt.execute();
			if(!checkForNull(cstmt.getString(5)).equals("Y")){
				bl_installed=cstmt.getString(3);
				bl_interface=cstmt.getString(4);
				bill_flag = ( bl_installed.equals("Y") && bl_interface.equals("Y") )?true:false;
			}else{
				err_text = cstmt.getString(8);
			}	
			//Billing Logic end			
			
			if(!(fromDateTime.equals(""))){
				whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy' ) ");
			}
			if(!(toDateTime.equals(""))){
				whereClause.append(" 	and a.event_date_time <= (to_date( ?,'dd/mm/yyyy' ) + 1)");
			}
			
			if(!noteType.equals("")){
				whereClause.append(" 	and a.NOTE_TYPE=? " );
			}
			
			isModifyNote = CommonBean.isSiteSpecific(con,"OT","OT_MODIFY_NOTE");//Added against ML-MMOH-CRF-1993
			
		
		if(isModifyNote){
			sqlQueryBuffer.append("SELECT DISTINCT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name, nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, OT.APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC,a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE, A.CONTR_MOD_ACCESSION_NUM ," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status  FROM  OT_SCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B , CA_NOTE_GROUP C  ,am_practitioner d, am_practitioner e, am_service f,AT_ANAESTHESIA_RECORD_HDR g  WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code  AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND C.APPL_TASK_ID = 'OT_NOTES' AND B.NOTE_GROUP_ID = C.NOTE_GROUP AND OT.LANGUAGE_ID = '"+locale+"' AND ot.oper_num != ' ' AND (SUBSTR(a.contr_mod_accession_num,'3','10') = ot.oper_num OR (SUBSTR(a.contr_mod_accession_num,'3',length(G.ANAESTHESIA_SERIAL_NUM)) = G.ANAESTHESIA_SERIAL_NUM and ot.order_id=g.source_order_id))");//Modified Against ML-MMOH-CRF-1993
			//AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')
			sqlQueryBuffer.append(whereClause);

			sqlQueryBuffer.append(" UNION  SELECT DISTINCT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name,nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, '' APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC, a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE, A.CONTR_MOD_ACCESSION_NUM ," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status FROM  OT_UNSCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B , CA_NOTE_GROUP C ,am_practitioner d, am_practitioner e, am_service f, AT_ANAESTHESIA_RECORD_HDR g WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND C.APPL_TASK_ID = 'OT_NOTES' AND B.NOTE_GROUP_ID = C.NOTE_GROUP AND OT.LANGUAGE_ID = '"+locale+"' AND  (SUBSTR(a.contr_mod_accession_num,'3','10') = ot.oper_num OR (SUBSTR(a.contr_mod_accession_num,'3',length(G.ANAESTHESIA_SERIAL_NUM)) = G.ANAESTHESIA_SERIAL_NUM and ot.order_id=g.source_order_id))");//Modified Against ML-MMOH-CRF-1993
			//AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')
		}else{
			sqlQueryBuffer.append("SELECT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name, nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, OT.APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC,a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status  FROM  OT_SCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B ,am_practitioner d, am_practitioner e, am_service f  WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code  AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30') ");
			sqlQueryBuffer.append(whereClause);

			sqlQueryBuffer.append(" UNION  SELECT A.NOTE_TYPE, B.NOTE_TYPE_DESC, TO_CHAR(A.EVENT_DATE_TIME,'DD/MM/YYYY HH24:MI') EVENT_DATE_TIME1, A.PERFORMED_BY_ID,REPLACE (d.practitioner_name, '''', ' ') performed_by_name, a.authorized_by_id, REPLACE (e.practitioner_name, '''', ' ') authorized_by_name,nvl2(A.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, A.ACCESSION_NUM, " 
			+ " OT.ORDER_ID, OT.OPER_NUM, OT.OPERATING_FACILITY_ID, to_char(OT.OPER_DATE,'dd/mm/yyyy') OPER_DATE, '' APPT_REF_NUM,  OT.SPECIALITY_CODE,OT.SPECIALITY_DESC, a.service_code, f.short_desc, OT.OPER_CODE, OT.ANAESTHESIA_DOC_COMP_YN, OT.SURGEON_CODE," 
			+ " OT.SURGEON_DOC_COMP_YN, OT.NURSING_DOC_COMP_YN ,DECODE (a.event_status,'1', 'In Progress','2', 'Transcribed', '3', 'Unauthorized', '4', 'Authorized', '5', 'Modified', '9', 'In Error' ) status FROM  OT_UNSCHD_OPERS_VW OT, CA_ENCNTR_NOTE A, CA_NOTE_TYPE B ,am_practitioner d, am_practitioner e, am_service f WHERE A.NOTE_TYPE = B.NOTE_TYPE AND " 
			+ " A.PATIENT_ID = ? AND  A.FACILITY_ID = ? AND  A.ENCOUNTER_ID = ? AND OT.PATIENT_ID = A.PATIENT_ID AND OT.OPERATING_FACILITY_ID " 
			+ "= A.FACILITY_ID AND a.service_code = f.service_code AND d.practitioner_id = a.performed_by_id AND e.practitioner_id(+) = a.authorized_by_id AND A.CONTR_MOD_ACCESSION_NUM =  (OT.OPERATING_FACILITY_ID || OT.OPER_NUM || OT.SPECIALITY_CODE || '30')");
			//Added EXT_IMAGE_APPL_ID Against ML-MMOH-CRF-1977.1
		
			}
			sqlQueryBuffer.append(whereClause);	
			pstmt =	con.prepareStatement(sqlQueryBuffer.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		   
			pstmt.setString(++colIndex,	patient_id);
			pstmt.setString(++colIndex,	facility_id);	
			pstmt.setString(++colIndex,	encounter_id);
			
			if(!(fromDateTime.equals(""))){
				pstmt.setString	(++colIndex, fromDateTime);
			}
			if(!(toDateTime.equals(""))){
				pstmt.setString	(++colIndex, toDateTime);			
			}
			if(!noteType.equals("")){
				pstmt.setString	(++colIndex, noteType);			
			}
			pstmt.setString(++colIndex,	patient_id);
			pstmt.setString(++colIndex,	facility_id);	
			pstmt.setString(++colIndex,	encounter_id);

			if(!(fromDateTime.equals(""))){
				pstmt.setString(++colIndex, fromDateTime);
			}

			if(!(toDateTime.equals(""))){
				pstmt.setString	(++colIndex, toDateTime);
			}
			if(!noteType.equals("")){
				pstmt.setString	(++colIndex, noteType);
			}
			
			rs				=	pstmt.executeQuery();
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
		
			if( totalRecordCount>maxRecordsDisp){

            _bw.write(_wl_block11Bytes, _wl_block11);

		if(startIndex>maxRecordsDisp){

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(noteType));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		if(totalRecordCount>endIndex){

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(noteType));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

		}

            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		if(totalRecordCount == 0){

            _bw.write(_wl_block21Bytes, _wl_block21);
	
		 }	

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

		
		if(startIndex>1){
			rs.absolute((startIndex-1));
		}
		String doc_linked = "";
		String img = "";
		String accessionNum = null;
		String noteTypeDesc = null;
		String eventDateTime = null;
		String performedById = null;
		String operNum = null;
		String bookingNum = null;
		String operDate = null;
		String operCode = null;
		String specialityCode = null;
		String specialityDesc = null;
		String surgeonCode = null;
		String nursingDocCompYN = null;
		String surgeonDocCompYN = null;
		String anesDocCompYN = null;
		String orderId = null;
		String tblrow_id = null;
		String classValue = null;
		String performed_by_name = null;
		String authorized_by_name = null;
		String status = null;
		String CONTR_MOD_ACCESSION_NUM = "";//Added Against ML-MMOH-CRF-1993
		
		while(rs.next()){
			tblrow_id		=	"tblrow_id"+(rowCnt);
			rowCnt++;
			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
			
			facility_id	= rs.getString("OPERATING_FACILITY_ID")==null?"":rs.getString("OPERATING_FACILITY_ID");
			noteType =rs.getString("NOTE_TYPE")==null?"":rs.getString("NOTE_TYPE");
			accessionNum = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
			doc_linked = rs.getString("doc_linked")==null?"":rs.getString("doc_linked"); //Added Against ML-MMOH-CRF-1977.1
			noteTypeDesc = rs.getString("NOTE_TYPE_DESC")==null?"":rs.getString("NOTE_TYPE_DESC");
			eventDateTime = rs.getString("EVENT_DATE_TIME1")==null?"":rs.getString("EVENT_DATE_TIME1");
			performedById = rs.getString("PERFORMED_BY_ID")==null?"":rs.getString("PERFORMED_BY_ID");
			operNum = rs.getString("OPER_NUM")==null?"":rs.getString("OPER_NUM");
			bookingNum = rs.getString("APPT_REF_NUM")==null?"":rs.getString("APPT_REF_NUM");
			operDate = rs.getString("OPER_DATE")==null?"":rs.getString("OPER_DATE");
			operCode = rs.getString("OPER_CODE")==null?"":rs.getString("OPER_CODE");
			specialityCode = rs.getString("service_code")==null?"":rs.getString("service_code");
			specialityDesc = rs.getString("short_desc")==null?"":rs.getString("short_desc");
			surgeonCode = rs.getString("SURGEON_CODE")==null?"":rs.getString("SURGEON_CODE");
			nursingDocCompYN = rs.getString("NURSING_DOC_COMP_YN")==null?"N":rs.getString("NURSING_DOC_COMP_YN");
			surgeonDocCompYN = rs.getString("SURGEON_DOC_COMP_YN")==null?"N":rs.getString("SURGEON_DOC_COMP_YN");
			anesDocCompYN = rs.getString("ANAESTHESIA_DOC_COMP_YN")==null?"N":rs.getString("ANAESTHESIA_DOC_COMP_YN");
			orderId = rs.getString("ORDER_ID")==null?"":rs.getString("ORDER_ID");
			performed_by_name = rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
			authorized_by_name = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
			status = rs.getString("status")==null?"":rs.getString("status");
			if(isModifyNote){
			CONTR_MOD_ACCESSION_NUM = rs.getString("CONTR_MOD_ACCESSION_NUM")==null?"":rs.getString("CONTR_MOD_ACCESSION_NUM");//Added Against ML-MMOH-CRF-1993
			}		
			if(status==null || status.equals(""))	status ="&nbsp;";		
			
			if(status.equals("In Error")){
			 status_display_text ="<a href=\"javascript:showNoteStatus('"+accessionNum+"',"+tblrow_id+")\">"+status+"</a>&nbsp;&nbsp;<a href=\"javascript:showErrorRemarks('"+accessionNum+"','"+facility_id+"')\" style='color:red'><b>?</b></a>";
			}else if( !(status.equals("In Progress")) ){
				status_display_text	=	"<a href=\"javascript:showNoteStatus('"+accessionNum+"',"+tblrow_id+")\">"+status+"</a>";
			}else{
				status_display_text	=	status;
			}
			
		//Added Against ML-MMOH-CRF-1993...starts
		if(isModifyNote){
		String str = CONTR_MOD_ACCESSION_NUM.substring(CONTR_MOD_ACCESSION_NUM.length()-2 , CONTR_MOD_ACCESSION_NUM.length());
		String[] str1 = CONTR_MOD_ACCESSION_NUM.substring(2).split("(?<=\\d)(?=\\D)");
		
		
			if(str.equals("30")) fileName = "../../eOT/jsp/RecordSurgeon.jsp?&tab_name=SCHEDULED";
			else if(str.equals("99")) fileName = "../../eOT/jsp/RecordNursing.jsp?";
			else if(str.equals("RE")) fileName = "../../eOT/jsp/AT_PreAnaesthesia.jsp?&tab_name=AnesthesiaDetails&anesthesia_srl_no="+str1[0];
			else if(str.equals("RA")) fileName = "../../eOT/jsp/AT_IntraAnaesthesia.jsp?&anesthesia_srl_no="+str1[0];
			else if(str.equals("ST")) fileName = "../../eOT/jsp/AT_PostAnaesthesia.jsp?&anesthesia_srl_no="+str1[0];
			else if(str.equals("40")) fileName = "../../eOT/jsp/OTChkInRecoveryRoom.jsp?&recovery_in_out_flag=CHECK_IN_RECO";
			else if(str.equals("10")) fileName = "../../eOT/jsp/OTHoldingArea.jsp?&function_id=OT_HOLDING_AREA";
		}else{
			fileName = "../../eOT/jsp/RecordSurgeon.jsp?";
		}
				String QueryString = fileName +  "&module_id=OT&function_type=F&menu_id=null&access=NYNNY&home_required_yn=N&called_from=OT_SLATE" 
				+ "&patient_id="+ patient_id + "&oper_num=" + operNum + "&booking_num=" + bookingNum + "&booking_no=" + bookingNum + "&waitlist_no=&slate_user_id=" + login_user_id 
				+ "&surgeon_doc_comp_yn=" + surgeonDocCompYN + "&nursing_doc_comp_yn=" +  nursingDocCompYN + "&anesthesia_doc_comp_yn=" + anesDocCompYN + "&order_id=" + orderId 
				+ "&speciality_code=" + specialityCode + "&facility_id=" + facility_id + "&oper_code=" + operCode + "&theatre_date=" + operDate + "&surgeon_code=" + surgeonCode + "&fromModifySurgeon=Y"+"&bill_flag="+bill_flag;//Modified Against ML-MMOH-CRF-1993
			//ML-MMOH-CRF-1977.1 Starts
			if(doc_linked.equals("Y"))
							img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accessionNum+"\",\""+noteType+"\")' height='20' title='View Linked File' >";
			else
			img = "&nbsp;";
			//ML-MMOH-CRF-1977.1 Ends			

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(operDate));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(QueryString));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(noteTypeDesc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(img));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(specialityDesc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(operNum));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(authorized_by_name));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(status_display_text));
            _bw.write(_wl_block33Bytes, _wl_block33);
			
		if(rowCnt>=maxRecordsDisp) break;
		}		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();		
	}catch(Exception e){
		System.err.println("OTNotesSearchResult.jsp==="+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Ot.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Result.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperDate.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteType.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperNum.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorized.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }
}
