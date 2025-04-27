package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __storesforoperatingroomdetailform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StoresforOperatingRoomDetailForm.jsp", 1730118138000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t <script language=\'javascript\' src=\'../../eOT/js/StoresforOperatingRoom.js\'></script> \n\t<script language=\'javascript\' src=\'../../eOT/js/Hashtable.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<BODY class=\'CONTENT\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"StoresforOperatingRoomDetailForm\" id=\"StoresforOperatingRoomDetailForm\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<P>\n<table align=\'right\'>\n<tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<td>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</tr>\n</table>\n<br><br>\n</p>\n<table class=\'grid\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=3  align=\'center\'>\n<td class=\'COLUMNHEADERCENTER\' nowrap > \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n<td class=\'COLUMNHEADERCENTER\'  nowrap> \n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n<td class=\'COLUMNHEADERCENTER\' nowrap>\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n<td class=\'COLUMNHEADERCENTER\' nowrap> \n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\n</table>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"modified_flag\" id=\"modified_flag\" value=\"false\" >\n<input type=\"hidden\" name=\"execute_flag\" id=\"execute_flag\" value=\"YES\" >\n<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" >\n<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" >\n<input type=\"hidden\" name=\"sel\" id=\"sel\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" >\n<input type=\"hidden\" name=\"dflt_sel\" id=\"dflt_sel\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" >\n<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" >\n\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
 
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

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

   
   String facility_name1 = checkForNull(request.getParameter( "facility_name1" )) ;
   String oper_room_code = checkForNull(request.getParameter( "oper_room_code" )) ;
   String store_room_code = checkForNull(request.getParameter( "store_room_code" )) ;
   if(("ALL").equals(facility_name1))facility_name1="";
   String from = checkForNull(request.getParameter( "from" )) ;
   String to =   checkForNull(request.getParameter( "to" ) ) ;
   String totalSelected= checkForNull(request.getParameter("totalSelected"));
   String empty = "".intern();
   String select_value="Y";
   String dflt_select_value="N";
   String facility_name=empty;
   String facility_id1=empty;
   String facility_id2=empty;
   String store_code=empty;
   String store_code_ot=empty;
   String store_desc=empty;
   String sel=empty;
   String sel1=empty;
   String dflt_sel=empty;
   String select_checked=empty;
   String dflt_select_checked=empty;
   String classValue= empty;
   String store_type=empty;
   String type_desc_value=empty;
   String type_desc=empty;
   String select_flag1 = empty;
   String select_flag2 = empty;
   String select_flag3 = empty;
   String select_flag4 = empty;
   String disable_flag=empty;
   String strsql=empty;
   String db_type_value=empty;
   //String count=empty;
   String count = request.getParameter("count")==null?"":request.getParameter( "count" );
   String default_yn="";
   HashMap store_info = new HashMap();
   HashMap store_info1 = new HashMap();
   String deflt =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
  
  String Theatre_Requesting_Consumption_Store =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreRequestingConsumptionStore.Label","ot_labels");
  String Theatre_Issuing_Store=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TheatreIssuingStore.Label","ot_labels");
  
  int start = ( from.equals("") )?1:Integer.parseInt(from);
  int end =  ( to.equals("") )?14:Integer.parseInt(to);
  StringBuffer sbr = new StringBuffer();
  StringBuffer code = new StringBuffer();
  StringBuffer sbr1 = new StringBuffer();
  StringBuffer sbr2 = new StringBuffer();
  StringBuffer sbr3 = new StringBuffer();
  StringBuffer sbr4 = new StringBuffer();
  StringBuffer sbr5 = new StringBuffer();
  Connection conn = null;
  PreparedStatement pstmt = null;
  PreparedStatement pstmt1 = null;
  ResultSet rst=null;
  ResultSet rst1=null;
  String strcount="SELECT COUNT(DEFAULT_YN) FROM OT_STORES_FOR_THEATRE WHERE DEFAULT_YN='Y' AND OPER_ROOM_CODE=?";
  if(("").equals(facility_name1) && ("").equals(store_room_code))
  {
	strsql="select FACILITY_NAME,FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN from (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D  WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'N' SEL,null STORE_TYPE, null DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?))order by FACILITY_NAME,SHORT_DESC";
  }else if("".equals(store_room_code) && !facility_name1.equals("")){

	strsql="select FACILITY_NAME,FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN from (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL,D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C,OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE  AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC, 'N' SEL, null STORE_TYPE, null DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?))order by FACILITY_NAME,SHORT_DESC";
  } else if(!store_room_code.equals("")){

	strsql="SELECT FACILITY_NAME, FACILITY_ID,STORE_CODE,SHORT_DESC, SEL,STORE_TYPE,DEFAULT_YN FROM (SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC,'Y' SEL, D.STORE_TYPE,D.DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C, OT_STORES_FOR_THEATRE D WHERE A.STORE_CODE = B.STORE_CODE  AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND D.STORE_CODE = A.STORE_CODE AND D.OPER_ROOM_CODE = ? AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE=? UNION SELECT C.FACILITY_NAME,B.FACILITY_ID,A.STORE_CODE,B.SHORT_DESC, 'N' SEL, NULL STORE_TYPE, NULL DEFAULT_YN FROM ST_STORE A, MM_STORE_LANG_VW B,SM_FACILITY_PARAM_LANG_VW C WHERE A.STORE_CODE = B.STORE_CODE AND B.FACILITY_ID = C.FACILITY_ID AND B.LANGUAGE_ID  = C.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND B.EFF_STATUS ='E' AND (? = 'ALL' OR C.FACILITY_ID=?) AND A.STORE_CODE=? AND A.STORE_CODE NOT IN(SELECT STORE_CODE FROM OT_STORES_FOR_THEATRE WHERE OPER_ROOM_CODE=?)) ORDER BY FACILITY_NAME,SHORT_DESC";

  }
  int maxRecord = 0;
  int i=1;
  int l=1;
    try{
   		conn  = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement(strsql);

		if(("").equals(facility_name1) && ("").equals(store_room_code))
        {
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,oper_room_code);
		}
		else if("".equals(store_room_code) && !facility_name1.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_name1);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,oper_room_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_name1);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,oper_room_code);
		} else if(!store_room_code.equals(""))
		{
			if(facility_name1.equals("")){
				facility_name1="ALL";
			}
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,facility_name1);
		pstmt.setString(5,store_room_code);
		pstmt.setString(6,locale);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,facility_name1);
		pstmt.setString(9,store_room_code);
		pstmt.setString(10,oper_room_code);
		}
		rst = pstmt.executeQuery();
		int total=0;
		while(rst.next()){
			total++;
		}
        maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
		pstmt=conn.prepareStatement(strsql);
		if(("").equals(facility_name1) && ("").equals(store_room_code))
        {
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,locale);
		pstmt.setString(4,oper_room_code);
		}
		else if("".equals(store_room_code) && !facility_name1.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_name1);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,oper_room_code);
		pstmt.setString(5,locale);
		pstmt.setString(6,facility_name1);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,oper_room_code);

		} else if(!store_room_code.equals(""))
		{
		pstmt.setString(1,locale);
		pstmt.setString(2,oper_room_code);
		pstmt.setString(3,facility_name1);
		pstmt.setString(4,facility_name1);
		pstmt.setString(5,store_room_code);
		pstmt.setString(6,locale);
		pstmt.setString(7,facility_name1);
		pstmt.setString(8,facility_name1);
		pstmt.setString(9,store_room_code);
		pstmt.setString(10,oper_room_code);
		}
		rst = pstmt.executeQuery();
        if(("").equals(count))
		{
		pstmt1=conn.prepareStatement(strcount);
		pstmt1.setString(1,oper_room_code);
		//pstmt1.setString(2,facility_name1);
		rst1 = pstmt1.executeQuery();
		while (rst1.next()){
		count=rst1.getString(1);
		}
		}


            _bw.write(_wl_block7Bytes, _wl_block7);
if(maxRecord >14 ){
            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='previous();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</font>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<font class='HYPERLINK' style='font-size:10pt;color:blue;cursor:pointer;font-weight:normal' onClick='next();'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</font>");

            _bw.write(_wl_block9Bytes, _wl_block9);
}
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
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		rst.next() ;
		int k=0;
		while ( rst.next() && i<=end  ){
          
			classValue  = ( i % 2 == 0 )?"gridData":"gridData" ; 

			type_desc_value=empty;
			select_checked=empty;
			select_value="N";
			dflt_select_value="N";
			dflt_select_checked=empty;
			boolean flag_1=false;
			facility_name = checkForNull(rst.getString(1));
			facility_id1= checkForNull(rst.getString(2));
			store_code=checkForNull(rst.getString(3));
			store_desc=checkForNull(rst.getString(4));
			sel=checkForNull(rst.getString(5));
			if(sel.equals("Y")){
			type_desc_value=checkForNull(rst.getString(6));
			}else
			{
				type_desc_value="";
			}
			dflt_select_value=checkForNull(rst.getString(7));
	        disable_flag = ("Y".equals(sel))?"disabled":"";
			if(("R").equals(type_desc_value))
			{
			type_desc_value="R";  
			select_flag1="";
			select_flag2="selected"; 
			select_flag3="";
			}
			else if(("I").equals(type_desc_value))
	        {
			type_desc_value="I" ;
			select_flag1="";
			select_flag2="";
			select_flag3="selected";
			}
			else 
			{
			type_desc_value="";  //default = blank;
			select_flag1="selected"; 
			select_flag2="";
			select_flag3="";
			}
			
			sbr.append("<tr>");
			sbr.append("<td class='"+classValue+"'>"+facility_name+"</td>");
		    sbr.append("<td class='"+classValue+"'>"+store_desc+"</td>");
			//constructing a List Item
			sbr.append("<td class='"+classValue+"'>");
			sbr.append("<select name=type_desc"+i+" id=type_desc"+i+" "+disable_flag+" onChange='valueChanged(this);'>");
			//default select
			sbr.append("<option value='' "+select_flag1+">");
			sbr.append("----------------------");
			sbr.append(deflt);
			sbr.append("----------------------");
			//Theatre_Requesting_Consumption_Store
			sbr.append("</option>");
			sbr.append("<option value='R' "+select_flag2+">");
			sbr.append(Theatre_Requesting_Consumption_Store);
			sbr.append("</option>");
			//Theatre_Issuing_Store
			sbr.append("<option value='I' "+select_flag3+">");
			sbr.append(Theatre_Issuing_Store);
			sbr.append("</option>");
			sbr.append("</td>");	

			
   			if(sel.equals("Y")){
				   select_checked="checked";
			       select_value="Y";
				   //if(("Y").equals(dflt_select_value)) db_type_value="Y"; else db_type_value="N"; 
				   if(dflt_select_value.equals("Y"))
				   {dflt_select_checked="checked";
				   db_type_value="Y";}else
				   {
					   db_type_value="N"; 
				   }
				   code.append(type_desc_value).append("@@");
				   code.append(select_value).append("@@");
				   code.append(dflt_select_value).append("@@");
				   code.append(facility_id1).append("@@");
				   code.append(store_code).append("@@");
				   code.append("U").append("@@");
				   code.append(db_type_value);
				   sbr.append("<script>pushChkBox('"+i+"','"+code.toString()+"')</script>");
				   code.setLength(0);
				   k++;
			}else{
				select_checked="";
				select_value="N";
			}

			sbr.append("<td class='" + classValue+"'><input type=checkbox name=chk_select"+i+" id=chk_select"+i+" value="+select_value+" "+select_checked+" type_desc='"+type_desc_value+"' facility_name='"+facility_id1+"' store_desc='"+store_code+"' select_yn='"+select_value+"' dflt_select_yn='"+dflt_select_value+"' onclick='validateCheckBox(this);'>");
			sbr.append("<td class='" + classValue+"'><input type=checkbox name=dflt_select"+i+" id=dflt_select"+i+" value="+dflt_select_value+" "+dflt_select_checked+" type_desc='"+type_desc_value+"' facility_name='"+facility_id1+"' store_desc='"+store_code+"' select_yn='"+select_value+"' dflt_select_yn='"+dflt_select_value+"' onclick='validateDfltCheckBox(this);'  >");
 
			sbr.append("</td>");
		    sbr.append("</tr>");
			

			if(totalSelected.length()>0){
			String tokens[] = totalSelected.split(",");
			
			for(int p = 0;p<tokens.length;p++){
				if(Integer.parseInt(tokens[p])==i)
					sbr.append("<script>assingListItemValue("+tokens[p]+");</script>");
			}
		}
			
		
   			i++;
			
		}
  		out.println(checkForNull(sbr.toString()));
  	
            _bw.write(_wl_block15Bytes, _wl_block15);
 
   }catch(Exception e){
	e.printStackTrace();
		//out.println("StoresforOperatinRoomDetailForm : "+e);
	}finally{
		try{
			if(rst!=null)	 rst.close();
			if(rst1!=null)	 rst1.close();
			if(pstmt!=null)	 pstmt.close();
			if(pstmt1!=null) pstmt1.close();
			if(sbr!=null)   sbr.setLength(0);
			//if(code!=null)  code.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){e.printStackTrace();}
	}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(start));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(end));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(select_checked));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dflt_select_checked));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(count));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DefaultStore.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
