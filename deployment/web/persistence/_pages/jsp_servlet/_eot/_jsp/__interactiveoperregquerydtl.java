package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __interactiveoperregquerydtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/InteractiveOperRegQueryDtl.jsp", 1734903338000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="                                 \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eOT/js/Booking.js\' language=\'javascript\'></script>\n<script src=\'../../eOA/js/oamessages.js\' language=\'javascript\'></script>\n<script src=\'../../eOT/js/InteractiveOperRegQuery.js\' language=\'javascript\'></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n           \n<script src=\'../../eXH/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  <head>\n  \t\t<style>\n\t\t TD.OTMENULAYER\n\t\t  {\n\t \t  FONT-FAMILY: VERDANA ;\n\t \t  FONT-SIZE: 10PT ;\n\t \t  BACKGROUND-COLOR: #D8BFD8;\n\t \t  COLOR: WHITE;\n\t\t}\n\t\tTD.OTMENU\n\t\t  {\n\t\t\tBACKGROUND-COLOR: #C0C0C0 ;\n\t\t\tFONT-SIZE: 9PT ;\n\t\t\tBORDER-STYLE: DASHED;\n\t\t\tBORDER-LEFT-COLOR: #FFA500;\n\t\t\tBORDER-RIGHT-COLOR: #FFA500;\n\t\t\tBORDER-TOP-COLOR: #FFFACD;\n\t\t\tBORDER-BOTTOM-COLOR: #FFFACD;\n\t\t  }\n\t\tTD.OTCLASS{\n\t\t\tFONT-SIZE: 9pt ;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tborder-left-color: #B2B6D7;\n\t\t\tborder-right-color: #B2B6D7;\n\t\t\tborder-top-color: #E2E3F0;\n\t\t\tborder-bottom-color: #E2E3F0;\n\t\t\theight:18;\t\n\t\t\t   }\n.menu {text-align:left;position:absolute;width:\'1300px\'}\n</style>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\'>\nfunction scrollTitle()\n{\nvar tab1=document.getElementById(\"headerTable\");\nvar y = document.body.scrollTop;\ntab1.style.top=y;\n}\n\n\nfunction assign()\n{\nvar tab1=document.getElementById(\"headerTable\");\ntab1.style.top=0;\ntab1.style.left=0;\n}\n</script>  \n</head>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!--Added against MMS-QH-CRF-0199 -->\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\'pendingOrderDtlForm\' id=\'pendingOrderDtlForm\' action=\'\' method = \'post\'>\n\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<table  border=\'1\' width=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' cellpadding=3 cellspacing=0>\n<tr style=\"position: sticky; top: 0; background-color: white; z-index: 1;\">\n<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th> \n<th class=\'columnHeader\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n</tr>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n </table>\n <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n <input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n </form>\n \t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'>\t\n\t</div>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
String maxPixel="1810px";

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(maxPixel));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

/*	out.println("<BR>");		
	out.println("<BR>");		
	out.println("<BR>");		*/
	String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	String theatre=CommonBean.checkForNull(request.getParameter("theatre"));
	String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
	String surgeon_code=CommonBean.checkForNull(request.getParameter("surgeon_code"));
	String
	anaesthetist_code=CommonBean.checkForNull(request.getParameter("anaesthetist_code"));
	String nurse_code=CommonBean.checkForNull(request.getParameter("nurse_code"));
	String oper_code=CommonBean.checkForNull(request.getParameter("oper_code"));
	String anaesthesia_code=CommonBean.checkForNull(request.getParameter("anaesthesia_code"));
	String implant_code=CommonBean.checkForNull(request.getParameter("implant_code"));
	String from_date=CommonBean.checkForNull(request.getParameter("from_date"));
	String to_date=CommonBean.checkForNull(request.getParameter("to_date"));
	String status=CommonBean.checkForNull(request.getParameter("status"));
	String orderby=CommonBean.checkForNull(request.getParameter("orderby"));
	String patient_id=CommonBean.checkForNull(request.getParameter("patient_id"));
	String source_code=CommonBean.checkForNull(request.getParameter("source_code"));
	String patient_id1="";
	String patient_anme1="";
	String sex1="";
	String dob1="";
	String theatre_desc1="";
	String speciality_desc1="";
	String surgeon_name1="";
	String anaesthetist_name1="";
	String oper_no1="";
	String oper_date1="";
	String status_desc1="";
	//String oper_code1="";
	String oper_desc1="";

	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;
	ResultSet rs1=null;

	
	String sql="";
	String sql1="";
	String whereClause="";

	String strMenu="";
	String strMenuItem="";
	String strQuery="";
	String strParameter="";
	String strTempOperation="";
	String flag="OPER_REG";

	int fetchCount=0;

try
{
	conn = ConnectionManager.getConnection(request);
	int index=1;
// modified Nursing unit to ref_source_code on 12/10

//	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND NVL(NURSING_UNIT_CODE,'~') = NVL(?,NVL(NURSING_UNIT_CODE,'~')) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";
//Modified by rajesh on behalf of SCF-1744

//	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";
	//Commented against MMS-QH-CRF-0199
	/*sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,OPER_CODE,OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A WHERE OPERATING_FACILITY_ID	=? AND A.LANGUAGE_ID='"+locale+"' AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) ";*/
	//Modified against MMS-QH-CRF-0199
	sql="SELECT PATIENT_ID, (SELECT DECODE( ? ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID ) PATIENT_NAME1, SEX, TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH , THEATRE_DESC,A.OPER_CODE,C.LONG_DESC OPER_DESC,SPECIALITY_DESC, SURGEON_NAME, ANAESTHETIST_NAME,OPER_NUM, TO_CHAR(OPER_DATE,'DD/MM/YYYY') OPER_DATE , STATUS_DESC FROM OT_POST_OPER_DETAILS_VW A,OT_OPER_MAST_LANG_VW C WHERE OPERATING_FACILITY_ID	=? AND A.LANGUAGE_ID='"+locale+"' AND A.PATIENT_ID = NVL(?,A.PATIENT_ID) AND REF_SOURCE_CODE = NVL (?, REF_SOURCE_CODE) AND OPER_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),SYSDATE) AND ((? = '*ALL')	OR (THEATRE_CODE = ? )) AND ((? = '*ALL') OR (OPER_STATUS = ? )) AND A.language_id = C.language_id AND A.OPER_CODE= C.OPER_CODE ";

	if(!speciality_code.equals(""))
		whereClause=whereClause+" AND INSTR(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";
	if(!surgeon_code.equals(""))
		whereClause=whereClause+" AND (SURGEON_CODE= ? OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('OS','AS')	AND B.PRACTITIONER_ID = ? )) ";
	if(!anaesthetist_code.equals(""))
		whereClause=whereClause+" AND (ANESTHETIST_CODE= ? OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ROLE_TYPE IN ('MA','AA')	AND B.PRACTITIONER_ID =? )) ";
	if(!nurse_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID 	= B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('NS')AND B.PRACTITIONER_ID = ? ) ";
	if(!oper_code.equals(""))
		whereClause=whereClause+" AND ? IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID 	= A.OPERATING_FACILITY_ID AND  OPER_NUM	= A.OPER_NUM) ";

	if(!anaesthesia_code.equals(""))
		whereClause=whereClause+" AND ANESTHESIA_CODE	= ? ";

	if(!implant_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_SURGICAL_ACCESSORIES B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ACCESSORY_TYPE = 'S'	AND B.ACCESSORY_CODE = ? ) ";
	
/*
old code, modified by bshankar to keep the bind variables
	if(!speciality_code.equals(""))
		whereClause=whereClause+" AND INSTR(ALL_SPECIALITY_CODES,'#'||'"+speciality_code+"'||'#') > 0 ";
	if(!surgeon_code.equals(""))
		whereClause=whereClause+" AND (SURGEON_CODE= '"+surgeon_code+"' OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('OS','AS')	AND B.PRACTITIONER_ID = '"+surgeon_code+"' )) ";
	if(!anaesthetist_code.equals(""))
		whereClause=whereClause+" AND (ANESTHETIST_CODE= '"+anaesthetist_code+"' OR (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ROLE_TYPE IN ('MA','AA')	AND B.PRACTITIONER_ID ='"+anaesthetist_code+"' )) ";
	if(!nurse_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_POST_OPER_PERSONNEL B WHERE A.OPERATING_FACILITY_ID 	= B.OPERATING_FACILITY_ID	AND A.OPER_NUM = B.OPER_NUM	AND B.ROLE_TYPE	IN ('NS')AND B.PRACTITIONER_ID = '"+nurse_code+"' ) ";
	if(!oper_code.equals(""))
		whereClause=whereClause+" AND '"+oper_code+"' IN (SELECT OPER_CODE FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID 	= A.OPERATING_FACILITY_ID AND  OPER_NUM	= A.OPER_NUM) ";

	if(!anaesthesia_code.equals(""))
		whereClause=whereClause+" AND ANESTHESIA_CODE	= '"+anaesthesia_code+"' ";
	if(!implant_code.equals(""))
		whereClause=whereClause+" AND (OPERATING_FACILITY_ID, OPER_NUM) IN (SELECT OPERATING_FACILITY_ID, OPER_NUM FROM OT_SURGICAL_ACCESSORIES B WHERE A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID	AND	 A.OPER_NUM	= B.OPER_NUM AND B.ACCESSORY_TYPE = 'S'	AND B.ACCESSORY_CODE = '"+implant_code+"' ) ";
*/
	switch(orderby.charAt(0))
	{
		case '1':whereClause=whereClause+" order by PATIENT_NAME";break;
		case '2':whereClause=whereClause+" order by PATIENT_ID";break;
		case '3':whereClause=whereClause+" order by THEATRE_DESC";break;
		case '4':whereClause=whereClause+" order by SURGEON_NAME";break;
		case '5':whereClause=whereClause+" order by ANAESTHETIST_NAME";break;
		case '6':whereClause=whereClause+" order by SPECIALITY_DESC";break;
		case '7':whereClause=whereClause+" order by OPER_NUM";break;
		case '8':whereClause=whereClause+" order by OPER_DATE";break;
		case '9':whereClause=whereClause+" order by STATUS_DESC";break;
		
	}
	sql=sql+whereClause;
	pstmt=conn.prepareStatement(sql);
	pstmt.setString(index++,locale);
	pstmt.setString(index++,facility_id);
	pstmt.setString(index++,patient_id);
	pstmt.setString(index++,source_code);
	pstmt.setString(index++,from_date);
	pstmt.setString(index++,to_date);
	pstmt.setString(index++,theatre);
	pstmt.setString(index++,theatre);
	pstmt.setString(index++,status);
	pstmt.setString(index++,status);
	if(!speciality_code.equals("")){
		pstmt.setString(index++,speciality_code);
	}
	if(!surgeon_code.equals("")){
		pstmt.setString(index++,surgeon_code);
		pstmt.setString(index++,surgeon_code);
	}
	if(!anaesthetist_code.equals("")){
		pstmt.setString(index++,anaesthetist_code);
		pstmt.setString(index++,anaesthetist_code);
	}
	if(!nurse_code.equals("")){
		pstmt.setString(index++,nurse_code);
	}

	if(!oper_code.equals("")){
		pstmt.setString(index++,oper_code);
	}
	if(!anaesthesia_code.equals(""))
		pstmt.setString(index++,anaesthesia_code);

	if(!implant_code.equals("")){
		pstmt.setString(index++,implant_code);
	}
	rs=pstmt.executeQuery();
	System.err.println(" SQl : "+sql);
	while(rs.next())
	{
		fetchCount++;
	
		patient_id1=CommonBean.checkForNull(rs.getString("PATIENT_ID"));
		patient_anme1=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
		sex1=CommonBean.checkForNull(rs.getString("SEX"));   	
		//dob1=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH"));	
		dob1=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH"),"DMY","en",locale));
		//preferedDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMY","en",locale);
		theatre_desc1=CommonBean.checkForNull(rs.getString("THEATRE_DESC"));
		speciality_desc1=CommonBean.checkForNull(rs.getString("SPECIALITY_DESC"));
		//oper_desc1=CommonBean.checkForNull(rs.getString("OPER_DESC"));
		surgeon_name1=CommonBean.checkForNull(rs.getString("SURGEON_NAME"));
		anaesthetist_name1=CommonBean.checkForNull(rs.getString("ANAESTHETIST_NAME"));
		oper_no1=CommonBean.checkForNull(rs.getString("OPER_NUM"));
		//oper_date1=CommonBean.checkForNull(rs.getString("OPER_DATE"));
		oper_date1=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("OPER_DATE"),"DMY","en",locale));
		status_desc1=CommonBean.checkForNull(rs.getString("STATUS_DESC"));
		//oper_code1=CommonBean.checkForNull(rs.getString("OPER_CODE"));
		oper_desc1=CommonBean.checkForNull(rs.getString("OPER_DESC"));
		//Commented against MMS-QH-CRF-0199
		/*sql1="SELECT B.SHORT_DESC OPER_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPER_NUM = '"+oper_no1+"' AND A.OPER_CODE = B.OPER_CODE ORDER BY 1 ";*/	
		//Added against MMS-QH-CRF-0199
		sql1="SELECT B.LONG_DESC OPER_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID = '"+facility_id+"' AND A.OPER_NUM = '"+oper_no1+"' AND A.OPER_CODE = B.OPER_CODE ORDER BY 1 ";
		pstmt1=conn.prepareStatement(sql1);
		rs1=pstmt1.executeQuery();

		//strTempOperation="Operations/Procedures,";
		strTempOperation=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels")+",";

		while(rs1.next())
		{
			strTempOperation=strTempOperation+rs1.getString(1)+",";
		}		
		if(rs1!=null)		rs1.close();
		if(pstmt1!=null)		pstmt1.close();

		//strMenu="Patient History"+","+"Surgery History"+","+"Patient Demographics";
		strMenu=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientHistory.label","common_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeryHistory.Label","ot_labels")+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
		
		strMenuItem="PH"+","+"SH"+","+"PDD";
		strParameter=oper_no1+"::"+facility_id+"::"+patient_id1+"::"+patient_anme1+"::"+sex1+"::"+dob1+"::"+flag;
		if(fetchCount%2==0)	strQuery="class='gridData'";
		else		strQuery="class='gridData'";
		out.println("<tr>");
		//out.println("<td width='220' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"DisplayTooltipForOperRegQry('"+strMenuItem+"','"+strMenu+"','"+strParameter+"',this,'imgArrow"+fetchCount+"');\" width='200'  onMouseOver='hideToolTip();'>"+patient_anme1+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");
		out.println("<td width='220' nowrap id='orderctl" + fetchCount + "' style='cursor:pointer' class='gridDataBlue' onClick=\"DisplayTooltipForOperRegQry('" + strMenuItem + "','" + strMenu + "','" + strParameter + "',this,'imgArrow" + fetchCount + "');\"  width='200'  onMouseOver='hideToolTip();'>"
	+"<a href='javascript:void(0);' style='color: blue; text-decoration: underline;'>"
    + patient_anme1+"</a>"
    + "<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow" + fetchCount + "'></a></td>");

		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+sex1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+dob1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+theatre_desc1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+speciality_desc1+"</td>");

		out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempOperation+"\" >"); 
       //Modified against MMS-QH-CRF-0199
		out.println("<td "+strQuery+" class='"+strQuery+"' ><img src='../../eOT/images/drugInfo.gif' OnMouseOver=\"Tip(reasonToolTip('reason',"+fetchCount+"),FONTFACE, 'TimesNewRoman', FONTSIZE, '9pt',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onMouseOut='UnTip();'>"+oper_desc1+"</font></td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+surgeon_name1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+anaesthetist_name1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left'>&nbsp;"+oper_no1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left' nowrap>"+oper_date1+"</td>");
		out.println("<td "+strQuery+" class='"+strQuery+"'  align='left' nowrap >&nbsp;"+status_desc1+"</td>");
		out.println("</tr>");
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(fetchCount==0)
	 out.println("<script>callNoRecord();</script>");
}catch(Exception ee)
{
	ee.printStackTrace();
	System.err.println("Exception264="+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oper_no1));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Anaesthetist.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationNo.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationDate.Label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
}
