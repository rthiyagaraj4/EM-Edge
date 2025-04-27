package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.sql.*;
import webbeans.eCommon.*;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.Date;
import java.math.*;
import java.text.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blapprstatustracksearchpayerresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLApprStatusTrackSearchPayerResult.jsp", 1709114400494L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<link rel=\"stylesheet\" type=\"text/css\"\thref=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eBL/js/BLApprStatusTrackSearch.js\'></script>\n\n<style type=\"text/css\">\nspan.a\n{\n\tbackground: #ffffff;\n\tborder: solid 1px #CCCCCC;\n\theight: 150px;\n\tdisplay:inline-block;\n    margin:10px 0;\n    border-radius:5px;\n\tcursor: pointer;\n}\n.box_title2\n{\n\twidth: 220px;\n\theight: 35px;\n    font-size: 12px;\n    font-weight: normal;\n    padding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n    color: #ffffff;\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n    background-color: #83AAB4;\n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    background-color: #A3BF8A;\n    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n    background-color: #DDC68E;\n    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    background-color: #B2B6D7;\n    ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    background-color: #D696D0;\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    line-height: 10px;\n    font-family: verdana;\n\ttext-align: center;\n\twhite-space: nowrap;\n\t\n}\n.box_text\n{\n\tpadding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n\tfont-family: verdana;\n\ttext-align: center;\n\tvertical-align: middle;\n\n}\n.txt\n{\n\tfont-family: verdana;\n\tfont-size: 30pt;\n\tfont-weight: bold;\n}\n.text\n{\n\tpadding-left: 10px;\n    padding-top: 10px;\n    padding-bottom: 10px;\n    padding-right: 10px;\n\tfont-family: verdana;\n\ttext-align: center;\n\tvertical-align: middle;\n\n}\t\n</style>\n</head>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<BODY onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" onload=\"onClickPayer(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<BODY onKeyDown=\"lockKey();\" onMouseDown=\"CodeArrest();\" onSelect=\"codeArrestThruSelect();\" >\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<form name=\'searchresult\' id=\'searchresult\' id=\'searchresult\' method=\'post\'>\n<table width=\"100%\">\n<tr>\n<td class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n</tr>\n</table>  \n<div>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t<span class=\"a\" id =\"payer\" onclick=\"onClickPayer(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');return false\">\n\t\t\t\t\t<div class=\"box_title2\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</div>\n\t\t\t\t\t<div class=\"box_text txt\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</div>\n\t\t\t\t\t<div class=\"text\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</div>\n\t\t\t\t</span>\n\t\t\t</label>  \n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="             \n</div>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t\n<Script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n<script type=\"text/javascript\">\n\tparent.frames[0].search.document.getElementById(\'search_button\').disabled=false; //49172\n\tparent.frames[0].search.document.getElementById(\'processMsg\').style.visibility=\"hidden\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n\t\t<input type=\'hidden\' name=\'user\' id=\'user\' id=\'user\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t<input type=\'hidden\' name=\'strclientip\' id=\'strclientip\' id=\'strclientip\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t<input type=\'hidden\' name=\'cusCount\' id=\'cusCount\' id=\'cusCount\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t<input type=\'hidden\' name=\'cusName\' id=\'cusName\' id=\'cusName\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t<!-- \n\t\t<input type=\'hidden\' name=\'selCust\' id=\'selCust\' id=\'selCust\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'selCusCode\' id=\'selCusCode\' id=\'selCusCode\' value=\'\'>\n\t\t -->\n\t\t<input type=\'hidden\' name=\'click_count\' id=\'click_count\' id=\'click_count\' value=\'0\'><!-- new -->\n\t\t\n\t\t<input type=\'hidden\' name=\'encounterFromDate\' id=\'encounterFromDate\' id=\'encounterFromDate\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t<input type=\'hidden\' name=\'encounterToDate\' id=\'encounterToDate\' id=\'encounterToDate\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\' id=\'episodeType\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t<input type=\'hidden\' name = \"popup_opened_yn\"  id = \"popup_opened_yn\" value=\"N\">\n\t\t<input type=\'hidden\' name = \"apprvSts_AAKHYN\"  id = \"apprvSts_AAKHYN\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"><!--V230425-->\n\t\t<input type=\'hidden\' name = \"PreAuthEclaimYN\"  id = \"PreAuthEclaimYN\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><!-- V230822 -->\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
if(sStyle.equals("IeStyle.css")){
            _bw.write(_wl_block8Bytes, _wl_block8);
}
    else if(sStyle.equals("IeStyleLime.css")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
    else if(sStyle.equals("IeStyleOrange.css")){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
    else if(sStyle.equals("IeStyleBlue.css")){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
    else if(sStyle.equals("IeStyleVoilet.css")){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

	request.setCharacterEncoding("UTF-8");
	Connection con = null; 
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	PreparedStatement pstmt		= null ;
	ResultSet rs				= null;	
	String[] cusCode = null;
	String[] cusName = null;
	BigDecimal[] cusCount = null;
	Array tempArray = null;
	int rowCount = 0;
	try{
	con	=	ConnectionManager.getConnection(request);
	String facility_id = (String) session.getValue("facility_id");
	String userId = (String) session.getAttribute("login_user");
	DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
	DateFormat dateFormat1 = new SimpleDateFormat("hhmmss");
	Calendar cal = Calendar.getInstance();
	String tDate=dateFormat.format(cal.getTime());
	String tTime=dateFormat1.format(cal.getTime());
	String usr = userId+tDate+tTime;
	String strclientip ="";
    strclientip=p.getProperty("client_ip_address");
	String apprvSts_AAKHYN = checkForNull(request.getParameter("apprvSts_AAKHYN"));//V230425 
	String loadSts = checkForNull(request.getParameter("loadSts"));//44856
	String rightsType = checkForNull(request.getParameter("rightsType"));
	String encounterFromDate = checkForNull(request.getParameter("encounterFromDate"));
	String encounterToDate = checkForNull(request.getParameter("encounterToDate"));
	String encId = checkForNull(request.getParameter("encounterId"));
	String PreAuthEclaimYN = checkForNull(request.getParameter("PreAuthEclaimYN"));//V230822
	
	String visit_Id = "";
	int visitId;
	System.err.println("encId=> "+encId);
	if(!encId.equals("")){
	visit_Id=encId.substring(8,12);
	encId = encId.substring(0,8);
	
	}
	double encounterId;	
	if(encId.equals("")){ encounterId = 0; }
	else{
		encounterId=Double.parseDouble(encId);  
	}
	if(visit_Id.equals(""))
	{	visitId=0;
	}else{
		visitId=Integer.parseInt(visit_Id); 
	}	
	
	String patientId = checkForNull(request.getParameter("patientId"));
	String episodeType = checkForNull(request.getParameter("episodeType"));
	String payerGroup = checkForNull(request.getParameter("payerGroup"));
	String payer = checkForNull(request.getParameter("payer"));
	String policy = checkForNull(request.getParameter("policy"));
	if(episodeType.equals("A"))
	{
		episodeType = "**";
	}


			String insuranceQuery="{ call BL_INSU_DASHBOARD.bl_proc_ins_dash_data_tmp(?,?,?,?,?,?,ltrim(?,'0'),?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?)}";
	
			CallableStatement callInsurance= con.prepareCall(insuranceQuery);
			callInsurance.setString(1,usr);
			callInsurance.setString(2,strclientip);
			callInsurance.setString(3,facility_id);
			if(patientId != "" )
			{
			callInsurance.setString(4,patientId);
			}
			else
			{
			callInsurance.setString(4,null);
			}
			callInsurance.setString(5,episodeType);
			if(encounterId != 0 )
			{
			callInsurance.setDouble(6,encounterId);
			}
			else
			{
			callInsurance.setString(6,null);
			}
			if(visitId != 0 )
			{
				callInsurance.setInt(7,visitId);
			}
			else
			{
			callInsurance.setString(7,null);
			}
			if(payerGroup != "" )
			{
			callInsurance.setString(8,payerGroup);
			}
			else
			{
			callInsurance.setString(8,null);
			}
			if(payer != "" )
			{
			callInsurance.setString(9,payer);
			}
			else
			{
			callInsurance.setString(9,null);
			}
			if(policy != "" )
			{
			callInsurance.setString(10,policy);
			}
			else
			{
			callInsurance.setString(10,null);
			}
			callInsurance.setString(11,encounterFromDate);
			callInsurance.setString(12,encounterToDate);
			callInsurance.registerOutParameter(13,Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
			callInsurance.registerOutParameter(14,Types.ARRAY,"BL_CMN_TYPE_VARCHAR100");
			callInsurance.registerOutParameter(15,Types.ARRAY,"BL_CMN_TYPE_NUMBER");
			callInsurance.execute();
			tempArray = callInsurance.getArray(13);
			if(tempArray != null){
			try{
					cusCode = (String[]) tempArray.getArray();
			}
			catch(Exception e){
			cusCode = new String[1];
			e.printStackTrace();
			}
			}
			else{
			cusCode = new String[1];
			}
	
			tempArray = callInsurance.getArray(14);
			if(tempArray != null){
		
			try{
					cusName = (String[]) tempArray.getArray();
			}
			catch(Exception e){
			cusName = new String[1];
			e.printStackTrace();
			}
			}
			else{
			cusName = new String[1];
			}
	
			tempArray = callInsurance.getArray(15);
			if(tempArray != null){
			try{
					cusCount = (BigDecimal[]) tempArray.getArray();
			}
			catch(Exception e){
			cusCount = new BigDecimal[1];
			e.printStackTrace();
			}
			}
			else{
			cusCount = new BigDecimal[1];
			}
			con.commit();
if(loadSts.equals("Y") && (apprvSts_AAKHYN.equals("Y") || PreAuthEclaimYN.equals("Y"))){ //44856
	String customerCode = checkForNull(request.getParameter("customerCode"));
	String custName = checkForNull(request.getParameter("cusName"));
	

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(custName));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(customerCode));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{

            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
if(PreAuthEclaimYN.equals("Y")){ 
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
}else{ 
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
} 
            _bw.write(_wl_block19Bytes, _wl_block19);

		for(int k = 0; k < cusCount.length; k++) {
			rowCount++;

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(cusName[k]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cusCode[k]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(cusName[k]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(cusCount[k]));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
					
		
		if(rowCount == 0){

            _bw.write(_wl_block26Bytes, _wl_block26);

		}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(usr));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strclientip));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(cusCount));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(cusName));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(encounterFromDate));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(encounterToDate));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(apprvSts_AAKHYN));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(PreAuthEclaimYN));
            _bw.write(_wl_block37Bytes, _wl_block37);
} catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
		con.rollback();
	}
	finally 
	{
	}
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprStatusPayerEncLvl.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprStatusPayer.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ClickDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
