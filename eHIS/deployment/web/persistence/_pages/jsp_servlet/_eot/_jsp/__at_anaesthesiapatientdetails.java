package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __at_anaesthesiapatientdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_AnaesthesiaPatientDetails.jsp", 1736744416000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="                     \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<!--Added against MMS-QH-CRF-0199-->\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n<style>\n\t\tTD.OS{\n\t\tBACKGROUND-COLOR:#6666FF;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\t\tTD.PR{\n\t\tBACKGROUND-COLOR:#FF99FF;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\t\tTD.IN{\n\t\tBACKGROUND-COLOR:#CC0099;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\t\tTD.PO{\n\t\tBACKGROUND-COLOR:#FFCC33;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\t\tTD.FN{\n\t\tBACKGROUND-COLOR:#990099;\n\t\tFONT-SIZE: 8pt ;\n\t\tBORDER-STYLE: solid;\n\t\tBORDER-BOTTOM: #CC9966 0px solid;\n\t\tBORDER-LEFT: #CC9966 0px solid;\n\t\tBORDER-RIGHT: #CC9966 0px solid;\n\t\tBORDER-TOP: #CC9966 1px solid;\n\t\t}\n\n</style>\n<form name=\"RecordAnesthesiaPatientDetailsForm\" id=\"RecordAnesthesiaPatientDetailsForm\" >\n<table class=\'grid\' cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" border=\"1\" scrolling=\"no\">\n\t<tr>\n\t\t<th  class=\"columnHeader\" nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\t<th class=\"columnHeader\" nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t<th class=\"columnHeader\"  nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t</tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n\t<td class=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' width=\'5%\'></td>\n\n\t<td width=\'10%\' nowrap id=\'orderctl";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' style=\'cursor:pointer\' class=\'gridDataBlue\' onClick=\"displayToolTipAnaesDetails(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\" onMouseOver=\'hideToolTip();\'><a href=\'javascript:void(0);\' style=\'color: blue; text-decoration: underline;\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a><img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' id=\'imgArrow";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'></td>\n\t\n\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' width=\'20%\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' width=\'7%\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n<!-- Modified against MMS-QH-CRF-0199 -->\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<td class=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' width=\'8%\' nowrap>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\'13%\' nowrap>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n</tr>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n</table>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
 
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String) session.getAttribute("LOCALE");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

	String facility_id=checkForNull(request.getParameter("facility_id"));
	String patient_id1= checkForNull(request.getParameter("patient_id")); 
	String patient_name1= checkForNull(request.getParameter("patient_name"));
	String accession_num= checkForNull(request.getParameter("accession_num"));
	String surgery_date1=checkForNull(request.getParameter("surgery_date"));
	String surgeon_code1= checkForNull(request.getParameter("surgeon_code"));
	String speciality_code1= checkForNull(request.getParameter("speciality_code"));
	String order_date= checkForNull(request.getParameter("order_date"));
	//String anesthesia_srl_no_new= checkForNull(request.getParameter("anesthesia_srl_no"));//49942
	String strTempOperation="";
	StringBuilder whereClause=new StringBuilder();
	//AAKH CRF-00069
	String surgery_date2=checkForNull(request.getParameter("surgery_date2"));
	String order_date2= checkForNull(request.getParameter("order_date2"));
	//AAKH CRF-00069

	//String sql_anesthesia_patient_details="SELECT SOURCE_ORDER_ID,PATIENT_ID, PATIENT_NAME PATIENT_NAME1, SEX, STATUS ,PREOP_ASSE_DONE_YN, NO_OF_PREOP_ASSE, REJECTED_YN, NVL(INTRAOP_DONE_YN,'N') INTRAOP_DONE_YN, POSTOP_DONE_YN,ANAESTHESIA_SERIAL_NUM, 	PROC_MODULE_ID,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,ORDER_ID,ORDER_CATALOG_CODE, ORDER_CATALOG_DESC,TO_CHAR(SURGERY_DATE,'DD/MM/YYYY') SURGERY_DATE,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE, SPECIALITY_CODE, SPECIALITY_DESC, SURGEON_CODE, SURGEON_NAME,ACCESSION_NUM FROM AT_PRE_INTRA_OPER_VW A WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND A.LANGUAGE_ID='"+locale+"' ";
	//Below query is changed against 50585 /* ot_pending_order */
	//commented against MMS-QH-CRF-0199
	/*String sql_anesthesia_patient_details="SELECT SOURCE_ORDER_ID,a.PATIENT_ID, PATIENT_NAME PATIENT_NAME1, SEX, STATUS ,PREOP_ASSE_DONE_YN, NO_OF_PREOP_ASSE, REJECTED_YN, NVL(INTRAOP_DONE_YN,'N') INTRAOP_DONE_YN, POSTOP_DONE_YN,ANAESTHESIA_SERIAL_NUM, 	PROC_MODULE_ID,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH,a.ORDER_ID,ORDER_CATALOG_CODE, ORDER_CATALOG_DESC,TO_CHAR(SURGERY_DATE,'DD/MM/YYYY') SURGERY_DATE,TO_CHAR(REQUEST_DATE,'DD/MM/YYYY') REQUEST_DATE, a.SPECIALITY_CODE, SPECIALITY_DESC, NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code,(SELECT d.short_name FROM am_practitioner_lang_vw d WHERE d.practitioner_id(+) = NVL (b.team_doctor_code, c.performing_team_surgeon) AND d.language_id = 'en') surgeon_name,ACCESSION_NUM FROM AT_PRE_INTRA_OPER_VW A, ot_booking_hdr b, ot_pending_order c WHERE A.OPERATING_FACILITY_ID= '"+facility_id+"' AND A.LANGUAGE_ID='"+locale+"' AND a.source_order_id = c.order_id   AND a.source_order_id = b.order_id(+)";*/
	//Added against MMS-QH-CRF-0199
	String sql_anesthesia_patient_details="SELECT source_order_id, a.patient_id, patient_name patient_name1, sex, a.status,preop_asse_done_yn, no_of_preop_asse, rejected_yn, NVL (intraop_done_yn, 'N') intraop_done_yn, postop_done_yn,anaesthesia_serial_num, proc_module_id,TO_CHAR (date_of_birth, 'DD/MM/YYYY') date_of_birth, a.order_id,       a.order_catalog_code, d.long_desc oper_desc,TO_CHAR (surgery_date, 'DD/MM/YYYY') surgery_date,TO_CHAR (request_date, 'DD/MM/YYYY') request_date, a.speciality_code,       speciality_desc,NVL (b.team_doctor_code, c.performing_team_surgeon) surgeon_code,(SELECT d.short_name FROM am_practitioner_lang_vw d WHERE d.practitioner_id(+) =                 NVL (b.team_doctor_code,c.performing_team_surgeon) AND d.language_id = 'en') surgeon_name,accession_num FROM at_pre_intra_oper_vw a, ot_booking_hdr b, ot_pending_order c, OT_OPER_MAST_LANG_VW d WHERE a.operating_facility_id = '"+facility_id+"'  AND a.language_id = '"+locale+"' AND a.source_order_id = c.order_id AND a.ORDER_CATALOG_CODE = d.ORDER_CATALOG_CODE  and d.LANGUAGE_ID = '"+locale+"' AND a.source_order_id = b.order_id(+)";

	String sql_desc="SELECT B.LONG_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM  = ? AND A.OPER_CODE  = B.OPER_CODE ORDER BY 1";	
//	String sql_enctr_patient="SELECT PATIENT_CLASS, ENCOUNTER_ID FROM OR_ORDER WHERE ORDER_ID=?"; 
	ArrayList pstmt_params = new ArrayList();
	whereClause.append(sql_anesthesia_patient_details);
	if(!(patient_id1.equals(""))){
		pstmt_params.add(patient_id1);
		whereClause.append(" AND A.PATIENT_ID=? ");
	}

	if(!(patient_name1.equals(""))) {
		pstmt_params.add(patient_name1);
		whereClause.append(" AND A.PATIENT_NAME LIKE ? ");
	}
	//AAKH CRF-0069 START
	if(!(surgery_date1.equals(""))){
		pstmt_params.add(surgery_date1);
		if(!(surgery_date2.equals(""))){
			pstmt_params.add(surgery_date2);	
		}else{
			//pstmt_params.add(surgery_date1);
			pstmt_params.add("31/12/9999");
		}
		//whereClause.append(" AND A.SURGERY_DATE=to_date(?,'DD/MM/YYYY') ");
		whereClause.append(" AND A.SURGERY_DATE BETWEEN TO_DATE(?||' 00:00','DD/MM/YYYY HH24:MI')  AND TO_DATE(?||' 23:59','DD/MM/YYYY HH24:MI')  ");
	}
	if(!(order_date.equals(""))){
		pstmt_params.add(order_date);
		if(!(order_date2.equals(""))){	
		pstmt_params.add(order_date2);
		}else{//pstmt_params.add(order_date);
			pstmt_params.add("31/12/9999");
		}
		//whereClause.append(" AND REQUEST_DATE=to_date(?,'DD/MM/YYYY') ");
		whereClause.append(" AND A.REQUEST_DATE BETWEEN TO_DATE(?||' 00:00','DD/MM/YYYY HH24:MI')  AND TO_DATE(?||' 23:59','DD/MM/YYYY HH24:MI')  ");
	}
	//AAKH CRF-00069 END
	if(!(surgeon_code1.equals(""))){
		pstmt_params.add(surgeon_code1);
		//whereClause.append(" AND A.SURGEON_CODE=? ");//54370
		whereClause.append("	AND NVL (b.team_doctor_code, c.performing_team_surgeon)=?");//54370
	}
	if(!(speciality_code1.equals(""))){
		pstmt_params.add(speciality_code1);
		whereClause.append(" AND A.SPECIALITY_CODE=? ");
	}
	//AAKH-CRF-0069
	whereClause.append("	order by a.surgery_date desc,a.request_date,a.patient_id");
	sql_anesthesia_patient_details=whereClause.toString();
	whereClause.setLength(0);
	String patient_id = "",patient_name	= "",sex = "",status = "",intraop_done_yn = "",anesthesia_srl_no= "",proc_module_id	= "",classValue = "",date_of_birth	= "",order_catalog_code ="",order_catalog_desc ="",surgery_date = "",request_date = "",speciality_code ="",speciality_desc ="",surgeon_code ="",surgeon_name="",order_id="",patient_class="",encounter_id="",src_order_id="";
	String patientNameMenu = ""; //49942
	Connection connection   = null ;
	PreparedStatement pstmt = null ;
	ResultSet resultSet     = null ;
	PreparedStatement pstmt1 = null ;
	ResultSet resultSet1     = null ;
	int i=0;
	try{
			connection			= ConnectionManager.getConnection(request);
			pstmt = connection.prepareStatement(sql_anesthesia_patient_details) ;
			if(pstmt_params.size()>0)
			{
				int size = pstmt_params.size();
				for(int j=0;j<size;j++)
				{
					pstmt.setString(j+1,""+pstmt_params.get(j));
				}
			}
			resultSet			= pstmt.executeQuery();
			while(resultSet.next()){
				i++;
				src_order_id = resultSet.getString("SOURCE_ORDER_ID");
				patient_id = resultSet.getString("PATIENT_ID");
				//patient_name = resultSet.getString("PATIENT_NAME1");
				// By Dilip
				ResultSet rs=null;
				String sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1         FROM MP_PATIENT  WHERE PATIENT_ID =? ";
				pstmt = connection.prepareStatement(sql);
				pstmt.setString(1,locale);
				pstmt.setString(2,patient_id);
				rs=pstmt.executeQuery();
				if(rs.next())
					patient_name=checkForNull(rs.getString("SHORT_NAME1"));
				    patientNameMenu = patient_name.replace("'",""); //49942
				
				rs.close();
				pstmt.close();
				// End by Dilip
				sex = resultSet.getString("SEX");
				if(sex.equals("M")){
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				}else if(sex.equals("F")){
					sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				}
				status = resultSet.getString("STATUS");
				intraop_done_yn = resultSet.getString("INTRAOP_DONE_YN");
				anesthesia_srl_no = resultSet.getString("ANAESTHESIA_SERIAL_NUM");
				proc_module_id = resultSet.getString("PROC_MODULE_ID");
				date_of_birth = com.ehis.util.DateUtils.convertDate(resultSet.getString("DATE_OF_BIRTH"),"DMY","en",locale);
				order_id = resultSet.getString("ORDER_ID");
				order_catalog_code = resultSet.getString("ORDER_CATALOG_CODE");
				if(order_catalog_code==null) order_catalog_code="";
				//order_catalog_desc = resultSet.getString("ORDER_CATALOG_DESC"); //Commented against MMS-QH-0199
				order_catalog_desc = resultSet.getString("oper_desc");//Added against MMS-QH-0199
				if(order_catalog_desc==null) order_catalog_desc="&nbsp;";
				surgery_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("SURGERY_DATE"),"DMY","en",locale);
				if(surgery_date==null) surgery_date="&nbsp;";
				request_date = com.ehis.util.DateUtils.convertDate(resultSet.getString("REQUEST_DATE"),"DMY","en",locale);
				if(request_date==null) request_date="&nbsp;";
				speciality_code = resultSet.getString("SPECIALITY_CODE");
				if(speciality_code==null) speciality_code="";
				speciality_desc = resultSet.getString("SPECIALITY_DESC");
				if(speciality_desc==null) speciality_desc="&nbsp;";
				surgeon_code = resultSet.getString("SURGEON_CODE");
				if(surgeon_code==null) surgeon_code="";
				surgeon_name = resultSet.getString("SURGEON_NAME");
				if(surgeon_name==null) surgeon_name="&nbsp;";
				accession_num=resultSet.getString("ACCESSION_NUM");
		if(accession_num==null) accession_num="";
		if(!accession_num.equals("")){	
			pstmt1=connection.prepareStatement(sql_desc);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,facility_id);
			pstmt1.setString(3,accession_num);
			resultSet1=pstmt1.executeQuery();
			strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			whereClause.append(strTempOperation);
			whereClause.append(",").append(order_catalog_desc);
			while(resultSet1.next()){
					whereClause.append(",").append(resultSet1.getString(1));
			}
		}else{
			String sql_proc="SELECT B.LONG_DESC FROM OR_ORDER_LINE A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID =? AND A.ORDER_ID = ? AND A.ORDER_CATALOG_CODE  = B.ORDER_CATALOG_CODE";	
			pstmt1=connection.prepareStatement(sql_proc);
			pstmt1.setString(1,locale);
			pstmt1.setString(2,src_order_id);
			resultSet1=pstmt1.executeQuery();
			strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			whereClause.append(strTempOperation);
			whereClause.append(",").append(order_catalog_desc);
		while(resultSet1.next())
			{
				whereClause.append(",").append(resultSet1.getString(1));
			}
		
		}
			strTempOperation = whereClause.toString();
			whereClause.setLength(0);
			resultSet1.close();
			classValue =(i%2==0)?"gridData":"gridData";	 
			//accession_num is oper_num and src_order_id is order_id
			String sql2 = null;
			//to get the latest Encounter ID when accession_num is not null
			if(accession_num!=null && !(accession_num.equals("")) && !(accession_num.equals("null"))){
				sql2="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OT_POST_OPER_HDR WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND OPER_NUM = '"+accession_num+"' ";
			} 
			//to get the latest Encounter ID when order Id is not equal to null
			else if(src_order_id!=null && !(src_order_id.equals("")) && !(src_order_id.equals("null"))){
				sql2="SELECT ENCOUNTER_ID, PATIENT_CLASS FROM OR_ORDER WHERE ORDERING_FACILITY_ID = '"+facility_id+"' AND ORDER_ID = '"+src_order_id+"' ";
			}
			pstmt = connection.prepareStatement(sql2);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				encounter_id=rs.getString("encounter_id");
				patient_class=rs.getString("patient_class");
			}
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(status));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientNameMenu));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(anesthesia_srl_no));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(proc_module_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(intraop_done_yn));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block23Bytes, _wl_block23);

	out.println("<td class='gridData'   nowrap ><img src='../../eOT/images/drugInfo.gif' OnMouseOver=\"Tip(reasonToolTip('"+src_order_id+"'),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onMouseOut='UnTip();' >"+order_catalog_desc+"</td>");
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(request_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(surgeon_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(speciality_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);

	    } //While loop closing
	if(i==0)
		 out.println("<script>callNoRecord();</script>");

	}catch(Exception e) {
		    e.printStackTrace();
            System.err.println("Exception=="+e);
	}finally{
				if(resultSet!=null) resultSet.close();
				if(pstmt!=null) pstmt.close();
				if(resultSet1!=null) resultSet1.close();
				if(pstmt1!=null) pstmt1.close();
				whereClause.setLength(0);
				if(connection!=null) 
					ConnectionManager.returnConnection(connection,request);
    }

            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SurgeryDate.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesthesiaOrderedDate.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
}
