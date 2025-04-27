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
import eOT.Common.OTRepository;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.*;
import com.ehis.util.*;

public final class __manageioschdtl extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ManageIOSchDtl.jsp", 1743149281200L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>               \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\n<script src=\'../../eOT/js/Booking.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eOT/js/CancelTransfer.js\' ></script>\n  <head>\n  \t\t<style>\n\t\t TD.OTMENULAYER\n\t\t  {\n\t \t  FONT-FAMILY: VERDANA ;\n\t \t  FONT-SIZE: 10PT ;\n\t \t  BACKGROUND-COLOR: #D8BFD8;\n\t \t  COLOR: WHITE;\n\t\t}\n\t\tTD.OTMENU\n\t\t  {\n\t\t\tBACKGROUND-COLOR: #C0C0C0 ;\n\t\t\tFONT-SIZE: 9PT ;\n\t\t\tBORDER-STYLE: DASHED;\n\t\t\tBORDER-LEFT-COLOR: #FFA500;\n\t\t\tBORDER-RIGHT-COLOR: #FFA500;\n\t\t\tBORDER-TOP-COLOR: #FFFACD;\n\t\t\tBORDER-BOTTOM-COLOR: #FFFACD;\n\t\t  }\n\t\tTD.OTCLASS{\n\t\t\tFONT-SIZE: 9pt ;\n\t\t\tBORDER-STYLE: SOLID;\n\t\t\tborder-left-color: #B2B6D7;\n\t\t\tborder-right-color: #B2B6D7;\n\t\t\tborder-top-color: #E2E3F0;\n\t\t\tborder-bottom-color: #E2E3F0;\n\t\t\theight:30;\t\n\t\t\t   }\n.menu {text-align:left;position:absolute;width:\'1300px\'}\n\n\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 400px; \t/* must be greater than tbody*/\n\t\toverflow: auto;\n\t\tmargin: 0 auto;\n\t}\n\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 250px;\n\toverflow-x: hidden;\n\t}\n\t\nthead tr\t{\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n</style>\n\n<script language=\'javascript\'>\n// Invoke Mail Servlet\nasync function sendMail(fetchCount){\n\tvar formObj = document.pendingOrderDtlForm;\t\n\n\tvar booking_num = eval(\"formObj.mail_booking_num_\"+fetchCount).value;\n\tvar facility_id = formObj.facility_id.value;\n\t\t\t \n\tvar dialogHeight= \"11\" ;  // 7\n\tvar dialogWidth\t= \"26\" ; // 22\n\tvar dialogTop = (window.screen.availHeight-dialogHeight)/3;//\"210\" ;\n\tvar dialogLeft = (window.screen.availWidth-dialogWidth)/4;// \"240\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar scroll=\"no\";\n    var myBars = \'directories=no;location=no;menubar=no\' ;\n\n\tvar features\t= \"dialogLeft:\" + dialogLeft + \";dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \";scroll \"+scroll+\"; status: \" + status + \"; dialogTop :\" + dialogTop+myBars;\n\tvar arguments\t= \"\" ;\n\tvar retVal = await window.showModalDialog(\"../../eOT/jsp/BookingMailReportConfirm.jsp?booking_num=\"+booking_num+\"&facility_id=\"+facility_id,arguments,features);\n\treturn retVal;\n}\nfunction scrollTitle()\n{\nvar tab1=document.getElementById(\"headerTable\");\nvar y = document.body.scrollTop;\ntab1.style.top=y;\n}\n\nfunction assign()\n{\nvar tab1=document.getElementById(\"headerTable\");\ntab1.style.top=0;\ntab1.style.left=0;\n}\n\nfunction callNoRecord()\n{\n\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));\n }\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n</head>\n<!-- <body onload=\'assign()\' onscroll=\"scrollTitle()\"> -->\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'pendingOrderDtlForm\' id=\'pendingOrderDtlForm\' action=\'\' method = \'post\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!-- <div id=\"headerTable\"  class=\'menu\'> -->\n<table class=\'grid\' border=\'1\' width=\'100%\' cellpadding=0 cellspacing=0>\n<div id=\"tableContainer\">\n\t<THEAD>\n\t\t<TR>\n\t\t\t<td class =\'columnheader\' nowrap>&nbsp;</td>\n\t\t\t<td class =\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t<td class =\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class =\'columnheader\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t<!--<td class =\'columnheader\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>-->\n\t\t</TR>\n\t</THEAD>\n<TBODY>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<input type=\"hidden\" name=\"mail_booking_num_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"mail_booking_num_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t<td  class=\"button\"> <input type=\"button\" class=\"button\" name=\"mail_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"mail_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" value=\"\" onclick=\"sendMail(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')\" title=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'> </td>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<!--\t<input type=\"hidden\" name=\"preOperDiag_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"preOperDiag_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">-->\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t    <input type=\"hidden\" name=\"order_id\" id=\"order_id\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><!-- Added for CRF-92 on 21-Jan-14 -->\n\n\t\t </table>\n\t\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t </form>\n\t\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:30%; visibility:hidden;\' bgcolor=\'blue\'></div>\n\t\t\t</BODY>\n\t\t\t</TBODY>\n\t\t\t</div>\n\t\t</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
String strStageCode=checkForNull(request.getParameter("stage_code"));


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	String strFacilityId=checkForNull(request.getParameter("facility_id") );
	String strFromDate=checkForNull(request.getParameter("from_date"));
	String strToDate=checkForNull(request.getParameter("to_date"));
	String strRoomCode=checkForNull(request.getParameter("room_code") );
	String strSurgeonCode=checkForNull(request.getParameter("surgeon_code") );
	String strAneasthetistCode=checkForNull(request.getParameter("aneasthetist_code") );
	String strPatientId=checkForNull(request.getParameter("patient_id") );
	String strPatientName=checkForNull(request.getParameter("patient_name") );
	String strOrderBy=checkForNull(request.getParameter("order_by") );
	String strStatus=checkForNull(request.getParameter("status") );
	System.err.println("strStatus==bh=="+strStatus);
	String strOperCode=checkForNull(request.getParameter("oper_code"));
	String strSpecialityCode=checkForNull(request.getParameter("speciality_code") );
	String strSex=checkForNull(request.getParameter("sex") );
	String strSourceType=checkForNull(request.getParameter("source_type") );
	String strSourceCode=checkForNull(request.getParameter("source_code") );
	String preOperDiag=checkForNull(request.getParameter("preOperDiag") );
	String theatre_type_code=checkForNull(request.getParameter("theatre_type") );
	String strBookingNo=checkForNull(request.getParameter("bookingNum_desc") );
	String strorder_id=checkForNull(request.getParameter("ORDER_ID") );
String order_id = "";
	//ORDER_ID
	
	String preOperDiagnosis_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreOperativeDiagnosis.Label","ot_labels");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	System.err.println("eOT status "+strStatus);

	String strQuery="";
	String strDOB="";
	String strTheatreDesc="";
	String strSpecialityDesc="";
	String strSurgeonName="";
	String strAneasthetistName="";
	//String strBookingNo="";
	String strBookingDate="";
	String strStartTime="";
	String strEndTime="";
	String strStatusDesc="";
	String strWaitListNo="";
	String strPreferredDate="";
	String strParameter="";
	String strOperDesc="";
	String strTempBookNo="";
	//String order_id="";
//Modified By DhanasekarV on 29/04/2011
//	String strOrderid ="";

	Connection conn=null;
	PreparedStatement pst=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;

	ResultSet rst=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	String sql="";
	String sql1="";
	String subSql="";
	String strMenu="";
	String strMenuItem="";
	int fetchCount=0;
	String strStatusSubcancelled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	String strStatusSubrescheduled=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ReScheduleCases.Label","ot_labels");
	String strStatusSubbooked=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.booked.label","common_labels");
	String strStatuswaitlisted=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.WaitList.label","common_labels");
	String strStatusOpersiteIdentified=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels");// Added for IN:41808
	String marker=",";
	String strStatusSub="";
	StringBuilder qry_criteria = new StringBuilder();

   	qry_criteria=(strSurgeonCode.length()>0)?qry_criteria.append("AND SURGEON_CODE= NVL(?,SURGEON_CODE)"):qry_criteria;
	qry_criteria=(strBookingNo.length()>0)?qry_criteria.append("AND BOOKING_NUM= NVL(?,BOOKING_NUM)"):qry_criteria;

	    qry_criteria=(strAneasthetistCode.length()>0)?qry_criteria.append("AND	 ANAESTHETIST_CODE	= NVL(?, ANAESTHETIST_CODE)"):qry_criteria;
    qry_criteria=(strPatientId.length()>0)?qry_criteria.append("AND PATIENT_ID= NVL(?, PATIENT_ID) "):qry_criteria;
//Modified by DhanasekarV against IN027806  on 12/09/2011
	qry_criteria = ((strPatientId.length()==0)&&(strPatientName.length()>0))?qry_criteria.append("AND	 UPPER(PATIENT_NAME) LIKE  UPPER(?) "):qry_criteria;
	   qry_criteria = (strSex.length()>0) ?qry_criteria.append("AND SEX	= NVL(?, SEX) "):qry_criteria;
	   qry_criteria = (strSourceType.length()>0)?qry_criteria.append(" AND DECODE(SOURCE_TYPE,'N','W',SOURCE_TYPE) ='"+strSourceType+"' "):qry_criteria;
	   qry_criteria = (strSourceCode.length()>0)?qry_criteria.append("  AND SOURCE_CODE='"+strSourceCode+"' "):qry_criteria;
  if(strStatus.equals("C")){	
	strStatusSub=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
	strStatusSub="'"+strStatusSub+"'";
	}else if(strStatus.equals("R")){ 
	strStatusSub=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ReScheduleCases.Label","ot_labels");
		strStatusSub="'"+strStatusSub+"'";
	}else if(strStatus.equals("A")){
		strStatusSub="DECODE(BOOKING_STATUS,'9','"+strStatusSubcancelled+"',DECODE( NVL(RESCHEDULED_COUNT,0),0,'"+strStatusSubbooked+"','"+strStatusSubrescheduled+"' ) ) ";
	}else if(strStatus.equals("B") ) {
		strStatusSub="DECODE(NVL(RESCHEDULED_COUNT,0),0,'"+strStatusSubbooked+"','"+strStatusSubrescheduled+"' )";
	}

if(strStatus.equals("W")==false){
	if(preOperDiag.length()>0){
		System.err.println("strStatus >0"+strStatus);
		//Sql query modified by Sanjay for IN:027806 on 23-Jun-11. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
		sql="SELECT PATIENT_ID PATIENT_ID1,(SELECT DECODE( '"+locale+"' ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME1,SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC  THEATRE_DESC1,SPECIALITY_DESC  SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1 , ANAESTHETIST_NAME ANAESTHETIST_NAME1,A.BOOKING_NUM  BOOKING_NUM1,TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE1, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME1,TO_CHAR(BOOKING_END_TIME,'HH24:MI') BOOKING_END_TIME1, "+strStatusSub+" STATUS_DESC1, NULL WAITLIST_NUM1 , NULL PREFERRED_DATE1,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPER_DESC1,CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY')  CANCELLATION_DATE1,CANCEL_REASON_CODE CANCEL_REASON_CODE1,PRE_OPER_DIAG PRE_OPER_DIAG1  FROM  OT_BOOKINGS_VW A, OT_OPER_MAST C WHERE A.LANGUAGE_ID = ? AND A.OPERATING_FACILITY_ID = ? AND BOOKING_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),to_date('01/01/3000','dd/mm/yyyy')) AND 	 THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) AND UPPER(PRE_OPER_DIAG) LIKE UPPER('%"+preOperDiag+"%')  ";
	}else{
		System.err.println("strStatus else==="+strStatus);
		//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
		sql="SELECT PATIENT_ID PATIENT_ID1,(SELECT DECODE( '"+locale+"' ,'en',NVL(PATIENT_NAME,PATIENT_NAME_LOC_LANG), NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) FROM MP_PATIENT WHERE PATIENT_ID = A.PATIENT_ID) PATIENT_NAME1,SEX SEX1,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY') DATE_OF_BIRTH1, THEATRE_DESC  THEATRE_DESC1,SPECIALITY_DESC  SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1 , ANAESTHETIST_NAME ANAESTHETIST_NAME1,A.BOOKING_NUM  BOOKING_NUM1,TO_CHAR(BOOKING_DATE,'DD/MM/YYYY') BOOKING_DATE1, TO_CHAR(BOOKING_START_TIME,'HH24:MI') BOOKING_START_TIME1,TO_CHAR(BOOKING_END_TIME,'HH24:MI') BOOKING_END_TIME1, "+strStatusSub+" STATUS_DESC1, NULL WAITLIST_NUM1 , NULL PREFERRED_DATE1,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPER_DESC1,CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY')  CANCELLATION_DATE1,CANCEL_REASON_CODE CANCEL_REASON_CODE1,PRE_OPER_DIAG PRE_OPER_DIAG1  FROM  OT_BOOKINGS_VW A,  OT_OPER_MAST C, OT_OPER_ROOM D  WHERE A.LANGUAGE_ID = ? AND  A.OPERATING_FACILITY_ID=D.OPERATING_FACILITY_ID AND D.THEATRE_TYPE= nvl('"+theatre_type_code+"',D.THEATRE_TYPE) AND A.THEATRE_CODE=D.OPER_ROOM_CODE AND A.OPERATING_FACILITY_ID = ? AND  BOOKING_DATE BETWEEN TO_DATE(?,'DD/MM/YYYY') AND NVL(TO_DATE(?,'DD/MM/YYYY'),to_date('01/01/3000','dd/mm/yyyy')) AND 	 THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
		
	}
}
subSql=qry_criteria.toString();
qry_criteria.setLength(0);
 if(strStatus.equals("B"))
	{
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS  NOT IN ('9')";
	}else if(strStatus.equals("C")) {
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS IN ('9')";
	}else if(strStatus.equals("R")){
		sql=sql+subSql;
		sql=sql+"AND BOOKING_STATUS NOT IN ('9')  AND  RESCHEDULED_COUNT IS NOT NULL";
	}else if(strStatus.equals("W")){
		if(strRoomCode.equals("*ALL")){
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql="SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1,THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1,SURGEON_NAME SURGEON_NAME1,ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM1, NULL BOOKING_DATE1, NULL BOOKING_START_TIME1,NULL BOOKING_END_TIME1, '"+strStatuswaitlisted+"' STATUS_DESC1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy')  PREFERRED_DATE1,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1   FROM  OT_WAITLIST_VW W WHERE   OPERATING_FACILITY_ID = ? AND LANGUAGE_ID='"+locale+"'  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy')) ";
			sql=sql+subSql;
		}else{
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql="SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1,THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1,SURGEON_NAME SURGEON_NAME1,ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM1, NULL BOOKING_DATE1, NULL BOOKING_START_TIME1,NULL BOOKING_END_TIME1, '"+strStatuswaitlisted+"' STATUS_DESC1,WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE ,'dd/mm/yyyy') PREFERRED_DATE1,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1  FROM  OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy'))  AND 	THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
			sql=sql+subSql;
		}
	}else if(strStatus.equals("A") && preOperDiag.length()==0){
		sql=sql+subSql;
		if(strRoomCode.equals("*ALL")==false){
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql1="UNION SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1, ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM , NULL BOOKING_DATE , NULL BOOKING_START_TIME1 , NULL BOOKING_END_TIME1 , '"+strStatuswaitlisted+"' STATUS_DESC1, WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1 ,OPER_DESC OPER_DESC1,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1, NULL PRE_OPER_DIAG1  FROM OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID     = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy'))  AND 	THEATRE_CODE = DECODE(?,'*ALL',THEATRE_CODE,?) ";
			sql1=sql1+subSql;
		}else{
			//Sql query modified by Sanjay for IN:027806 on 23-JUN-2011. Replaced sysdate with to_date('01/01/3000','dd/mm/yyyy')
			sql1="UNION SELECT PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1, SEX SEX1,to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1, THEATRE_DESC THEATRE_DESC1,SPECIALITY_DESC SPECIALITY_DESC1, SURGEON_NAME SURGEON_NAME1, ANAESTHETIST_NAME ANAESTHETIST_NAME1,NULL BOOKING_NUM , NULL BOOKING_DATE , NULL BOOKING_START_TIME1 , NULL BOOKING_END_TIME1 , '"+strStatuswaitlisted+"' STATUS_DESC1, WAITLIST_NUM WAITLIST_NUM1, to_char(PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1 ,OPER_DESC OPER_DESC1 ,NULL CANCELLED_BY1,NULL CANCELLATION_DATE1,NULL CANCEL_REASON_CODE1,NULL PRE_OPER_DIAG1   FROM OT_WAITLIST_VW W WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID     = ?  AND  PREFERRED_DATE 	BETWEEN to_date(?,'dd/mm/yyyy') AND  NVL(to_date(?,'dd/mm/yyyy'),to_date('01/01/3000','dd/mm/yyyy')) ";
			sql1=sql1+subSql;

		}
  }else if(strStatus.equals("A")){
			sql=sql+subSql;
  }
	if(strStageCode.length()>0){
		sql1=" and A.booking_num in(SELECT APPT_REF_NUM FROM OT_QUEUE WHERE operating_facility_id=? AND BOOKING_STAGE=?)";
		sql=sql+subSql;	
	}

	if(strOperCode.length()>0){
		if(strStatus.equals("B")||strStatus.equals("C")||strStatus.equals("R")){
			sql=sql+"  AND '"+strOperCode+"' IN (SELECT OPER_CODE 	FROM	OT_BOOKING_DTLS WHERE OPERATING_FACILITY_ID= A.OPERATING_FACILITY_ID 	AND	  BOOKING_NUM = A.BOOKING_NUM)";
	}else if(strStatus.equals("W")){
		    sql=sql+"AND '"+strOperCode+"' IN (SELECT OPER_CODE FROM	OT_WAITLISTING_DTL  W WHERE OPERATING_FACILITY_ID =W.OPERATING_FACILITY_ID  AND WAITLIST_NUM = W.WAITLIST_NUM)";
	}else{
		  sql=sql+"  AND '"+strOperCode+"' IN (SELECT OPER_CODE  FROM	OT_BOOKING_DTLS WHERE OPERATING_FACILITY_ID= A.OPERATING_FACILITY_ID AND	  BOOKING_NUM = A.BOOKING_NUM)";
		  sql1=sql1+"AND '"+strOperCode+"' IN (SELECT OPER_CODE FROM	OT_WAITLISTING_DTL 	W WHERE OPERATING_FACILITY_ID = W.OPERATING_FACILITY_ID  AND WAITLIST_NUM = W.WAITLIST_NUM) ";
	 }
   }


	if(strSpecialityCode.length()>0){
		sql=sql+" AND instr(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";

		if(strStatus.equals("A") && preOperDiag.length()==0){
			sql1=sql1+" AND instr(ALL_SPECIALITY_CODES,'#'||?||'#') > 0 ";
		}
	}

	if(strStatus.equals("W")==false){
	  sql=sql+" AND C.OPER_CODE = ( SELECT oper_code FROM  OT_BOOKING_DTLS WHERE A.OPERATING_FACILITY_ID=OPERATING_FACILITY_ID AND BOOKING_NUM= A.BOOKING_NUM AND ROWNUM=1)";
	}
	
	if(sql1.length()>0)	 sql=sql+sql1;
	switch(strOrderBy.charAt(0)){
		case '1':sql=sql+" order by patient_name1";break;
		case '2':sql=sql+" order by patient_id1";break;
		case '3':sql=sql+" order by theatre_desc1";break;
		case '4':sql=sql+" order by surgeon_name1";break;
		case '5':sql=sql+" order by anaesthetist_name1";break;
		case '6':sql=sql+" order by speciality_desc1";break;
		case '7':sql=sql+" order by booking_num1";break;
		case '8':sql=sql+" order by booking_date1";break;
		case '9':sql=sql+" order by waitlist_num1";break;
		case 'A':sql=sql+" order by preferred_date1";break;
		case 'B':sql=sql+" order by status_Desc1";break;
	}
	conn = ConnectionManager.getConnection(request);
	try{
		pstmt=conn.prepareStatement(sql_sm_report); // Added for IN:41808
		rs=pstmt.executeQuery();
		if(rs !=null && rs.next())
	   {
	   customer_id1=checkForNull(rs.getString("customer_id"));
	   }	
	    if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();// End for IN:41808
		pstmt=conn.prepareStatement(sql);		
		int index=0;
		if(strStatus.equals("W"))
		{
			pstmt.setString(++index,strFacilityId);
			pstmt.setString(++index,strFromDate);
			pstmt.setString(++index,strToDate);
		}
		else
		{
			pstmt.setString(++index,locale);
			pstmt.setString(++index,strFacilityId);
			pstmt.setString(++index,strFromDate);
			pstmt.setString(++index,strToDate);
		}

		if((strStatus.equals("W")==false)|| (strRoomCode.equals("*ALL")==false))
		{
			pstmt.setString(++index,strRoomCode);
			
			pstmt.setString(++index,strRoomCode);
			
		}
		if(strSurgeonCode.length()>0) {   
			
			pstmt.setString(++index,strSurgeonCode);
			
		}
		if(strBookingNo.length()>0) {   
			
			pstmt.setString(++index,strBookingNo);
			
		}
		if(strAneasthetistCode.length()>0) {
			
			pstmt.setString(++index,strAneasthetistCode);
			
		}
		if(strPatientId.length()>0)
		{
			
			pstmt.setString(++index,strPatientId);
			
		}
			//Modified by DhanasekarV against IN027806  on 12/09/2011
		if((strPatientId.length()==0) && (strPatientName.length()>0)){
			strPatientName="%"+strPatientName+"%";
			
			pstmt.setString(++index,strPatientName);
			
		}
		if(strSex.length()>0)	{
			
			pstmt.setString(++index,strSex);
			
		}
		if(strSpecialityCode.length()>0)  {
		
			pstmt.setString(++index,strSpecialityCode);
			
		}
		if(strStageCode.length()>0){
			
		   pstmt.setString(++index,strFacilityId);
		   
		   pstmt.setString(++index,strStageCode);
		   
		}
		
		//Added below condition on 1/18/2011 by Anitha for 25897
		if(strStatus.equals("A") && preOperDiag.length()==0){
			 
			pstmt.setString(++index,strFacilityId);
			 
			pstmt.setString(++index,strFromDate);
			
			pstmt.setString(++index,strToDate);
			
			if(strRoomCode.equals("*ALL")==false){
			
			pstmt.setString(++index,strRoomCode);
			
			pstmt.setString(++index,strRoomCode);

			}

			if(strSurgeonCode.length()>0){ 
				
				pstmt.setString(++index,strSurgeonCode);
				
			}
			if(strBookingNo.length()>0) {   
			
			pstmt.setString(++index,strBookingNo);
			
			}
			if(strAneasthetistCode.length()>0){ 
			
				pstmt.setString(++index,strAneasthetistCode);
				
			}
			if(strPatientId.length()>0) {
				
				pstmt.setString(++index,strPatientId);
				
			}
			//Modified by DhanasekarV against IN027806  on 12/09/2011
			if((strPatientId.length()==0) && (strPatientName.length()>0)){
			strPatientName="%"+strPatientName+"%";

				pstmt.setString(++index,strPatientName);
			}

			if(strSex.length()>0)	{
				
				pstmt.setString(++index,strSex);
				
			}
			if(strSpecialityCode.length()>0)  {
				
				pstmt.setString(++index,strSpecialityCode);
				
			}
		}
		
		rs=pstmt.executeQuery();		
		pstmt1=conn.prepareStatement("SELECT short_desc ||'('||(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW AA WHERE AA.LANGUAGE_ID = ? AND AA.SPECIALITY_CODE=C.SPECIALITY_CODE)||')' FROM OT_BOOKING_DTLS B, OT_OPER_MAST C  WHERE b.operating_Facility_id=? AND   B.OPER_CODE=C.OPER_CODE   AND B.BOOKING_NUM=?");

		pstmt2=conn.prepareStatement("SELECT short_desc||'('||(SELECT SHORT_DESC FROM AM_SPECIALITY_LANG_VW AA WHERE AA.LANGUAGE_ID = ? AND AA.SPECIALITY_CODE=C.SPECIALITY_CODE)||')' FROM OT_WAITLISTING_DTL B, OT_OPER_MAST C  WHERE b.operating_Facility_id=? AND  B.OPER_CODE=C.OPER_CODE   AND B.WAITLIST_NUM=?");
		
		
		//{
		
		while(rs.next())
		{
		fetchCount++;
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		
		strPatientName=checkForNull(rs.getString("PATIENT_NAME1"));
		strSex=checkForNull(rs.getString("SEX1"));   	
		strDOB=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));	
		strTheatreDesc=checkForNull(rs.getString("THEATRE_DESC1"));
		strSpecialityDesc=checkForNull(rs.getString("SPECIALITY_DESC1"));
		strSurgeonName=checkForNull(rs.getString("SURGEON_NAME1"));
		strAneasthetistName=checkForNull(rs.getString("ANAESTHETIST_NAME1"));
		strBookingNo=checkForNull(rs.getString("BOOKING_NUM1"));
		strBookingDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("BOOKING_DATE1"),"DMY","en",locale));
		strStartTime=checkForNull(rs.getString("BOOKING_START_TIME1"));
		strEndTime=checkForNull(rs.getString("BOOKING_END_TIME1"));
		strStatusDesc=checkForNull(rs.getString("STATUS_DESC1"));
		strWaitListNo=checkForNull(rs.getString("WAITLIST_NUM1"));
		strPreferredDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("PREFERRED_DATE1"),"DMY","en",locale));
		strOperDesc=checkForNull(rs.getString("OPER_DESC1"));
		preOperDiag=checkForNull(rs.getString("PRE_OPER_DIAG1"));
		if(fetchCount%2==0)	strQuery="gridData";
		else		strQuery="gridData";

			//Added for CRF-92 on 21-Jan-14 
			//Added order id query start
		try{
			if(strorder_id.length()>0){
				String sqlOrder="select order_id from OT_BOOKING_DTLS where BOOKING_NUM =? and OPERATING_FACILITY_ID=? AND order_id=?";
				    pst=conn.prepareStatement(sqlOrder);
					pst.setString(1,strBookingNo);
					pst.setString(2,strFacilityId);
					pst.setString(3,strorder_id);

			}else{
					String sqlOrder="select order_id from OT_BOOKING_DTLS where BOOKING_NUM =? and OPERATING_FACILITY_ID=?";
					pst=conn.prepareStatement(sqlOrder);
					pst.setString(1,strBookingNo);
					pst.setString(2,strFacilityId);
				}
			    rst=pst.executeQuery();
				order_id = "";
				
				if(rst !=null && rst.next())
			   {
				 order_id=checkForNull(rst.getString("order_id"));
			   }else
				   continue;
					if(pst!=null) pst.close();
					if(rst!=null)rst.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		//end
		StringBuilder sbr_menu = new StringBuilder();
		StringBuilder sbr_item = new StringBuilder();

		//Common for All Cases
		sbr_menu.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels"));
		sbr_item.append("BQ5");

		//For Booked Cases
		if(strStatusSubbooked.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ1");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			//sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PrintAppointmentSlip.Label","ot_labels"));
			//sbr_item.append(marker).append("BQ6");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for IN:41808
			//sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
		//	sbr_item.append(marker).append("BQ7");
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemRequestDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ8");// Added for CRF 0092
			}
			
		}
		
		//For Cancelled Cases
		if(strStatusSubcancelled.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDetail.label","common_labels"));
			sbr_item.append(marker).append("BQ2");
		}

		//For Reschedule Cases
		if(strStatusSubrescheduled.equals( strStatusDesc )){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels"));
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels"));
			sbr_item.append(marker).append("BQ1");
			sbr_item.append(marker).append("BQ4");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PrintAppointmentSlip.Label","ot_labels"));
			sbr_item.append(marker).append("BQ6");
			//Reprint Appointment Slip IN34756 - Rajesh V 07/11/2012
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for IN:41808
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperSiteIdentify.Label","ot_labels"));
			sbr_item.append(marker).append("BQ7");
			}
			if(customer_id1.equalsIgnoreCase("RTN")){// Added for CRF 0092
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ItemRequestDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ8");
			}
		}

		//For WaitListed Cases
		if(strStatuswaitlisted.equals( strStatusDesc)){
			sbr_menu.append(marker).append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitListDetails.Label","ot_labels"));
			sbr_item.append(marker).append("BQ3");
		}
		
		strMenu = sbr_menu.toString();
		strMenuItem = sbr_item.toString();
		if(sbr_menu!=null) sbr_menu.setLength(0);
		if(sbr_item!=null) sbr_item.setLength(0);
	

		//strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
		//strMenuItem=strMenuItem+"BQ5";	
		
		//If booked case or Reschduled cases view Booking Menu


		/*if(strStatusDesc.equals("Booked")||strStatusDesc.equals("Rescheduled")||strStatusDesc.equals(strStatusSubbooked)||strStatusDesc.equals(strStatusSub))
			{
			//strMenu+="Booking Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ1";
			}
		if(strStatusDesc.equals("Cancelled") || strStatusDesc.equals(strStatusSub)) {
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Cancelled Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDetail.label","common_labels");
			strMenuItem=strMenuItem+"BQ2";
			}
		if(strStatusDesc.equals("Waitlisted"))
			{
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Waitlist Details";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.WaitListDetails.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ3";
			}
		if(strStatusDesc.equals("Rescheduled") || strStatusDesc.equals(strStatusSub))
			{
			if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Previous Reschedule";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ4";
			}
	//	if(strStatusDesc.equals("Rescheduled")) {
		if(strMenu.length()>0) { strMenu=strMenu+",";strMenuItem=strMenuItem+",";}
			//strMenu+="Patient Demographic";
			strMenu=strMenu+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PatientDemographics.Label","ot_labels");
			strMenuItem=strMenuItem+"BQ5";
		//	}*/

		strParameter = strBookingNo + "," + strFacilityId + "," + strPatientId + "," + strWaitListNo + "," + order_id + "," + strStatusDesc;
		System.err.println("===strParameter==="+strParameter);
		

		//out.println("<br>");
		out.println("<tr>");

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 
		out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"commonDisplayTooltip('"+strMenuItem+"','"+strMenu+"','"+strParameter+"',this,'imgArrow"+fetchCount+"');\"  onMouseOver='hideToolTip();'>"+strPatientName+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"'></td>");


		
		if(strSex.equals("F")){
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}else if(strSex.equals("M")){
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		}else{
			strSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}

		out.println("<td class='"+strQuery+"' nowrap>&nbsp;"+strSex+"</td>");

		out.println("<td class='"+strQuery+"'  nowrap>&nbsp;"+strDOB+"</td>");


		out.println("<td class='"+strQuery+"' nowrap>&nbsp;"+strTheatreDesc+"</td>");

		//if waitlisted cases
		if(strStatusDesc.equals(strStatuswaitlisted))
			{
				pstmt2.setString(1,locale);
				pstmt2.setString(2,strFacilityId);
				pstmt2.setString(3,strWaitListNo);
				rs1=pstmt2.executeQuery();
			}
			else
			{
				pstmt1.setString(1,locale);
				pstmt1.setString(2,strFacilityId);
				pstmt1.setString(3,strBookingNo);
				rs1=pstmt1.executeQuery();
			}

			strTempBookNo=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationsProcedures.Label","ot_labels");
			while(rs1.next())
			{
				strTempBookNo=strTempBookNo+","+rs1.getString(1);
			}		

			if(rs1!=null)		rs1.close();

		out.println("<input type='hidden' name='reason"+fetchCount+"' id='reason"+fetchCount+"' value=\""+strTempBookNo+"\" >"); 

		out.println("<td "+strQuery+" class='"+strQuery+"'  OnMouseOver=\"reasonToolTip('reason',"+fetchCount+")\"  onMouseOut='hideToolTip();' nowrap>"+strOperDesc+" ("+strSpecialityDesc+")</td>");


		

		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strSpecialityDesc+"</td>");


		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strSurgeonName+"</td>");

		out.println("<td class="+strQuery+"   nowrap>&nbsp;"+strAneasthetistName+"</td>");


		out.println("<td class="+strQuery+"  nowrap>&nbsp;"+strStatusDesc+"</td>");

		out.println("<td class="+strQuery+"  >&nbsp;"+strBookingNo+"</td>");

		out.println("<td class="+strQuery+"   nowrap>"+strBookingDate+"("+strStartTime+"-"+strEndTime+")</td>");

		out.println("<td class="+strQuery+"  nowrap>&nbsp;"+order_id+"</td>");
		/*out.println("<td class="+strQuery+"  nowrap>&nbsp;"+strPreferredDate+"</td>");*/

        
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fetchCount));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(preOperDiag));
            _bw.write(_wl_block24Bytes, _wl_block24);

	/*	out.println("<td class="+strQuery+"   ><a class='gridDataBlue' href=\"javascript:showOperRemarks1('"+preOperDiagnosis_title+"','"+fetchCount+"');\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"</a></td>");

		out.println("</tr>");*/
		
	}
	if(fetchCount==0)
		 out.println("<script>callNoRecord();</script>");

	}catch(Exception ee){
		//eOT.LogFile.log("OTDebugger","Exception "+ee,this);
		System.err.println("in BookingQryDtl.jsp"+ee.getMessage());
		ee.printStackTrace();
	}
	finally{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
		if(pstmt2!=null) pstmt2.close();
		if(pstmt!=null) pstmt.close();
		if(conn!=null)ConnectionManager.returnConnection(conn,request);
	}

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primaryspeciality.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BookingNO.Label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDateTime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OrderID.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeDiagnosis.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EmailPrintReminderLetter.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
