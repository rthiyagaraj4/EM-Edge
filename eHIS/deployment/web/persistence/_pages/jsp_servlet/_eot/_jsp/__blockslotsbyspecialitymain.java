package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import eCommon.Common.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __blockslotsbyspecialitymain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/BlockSlotsBySpecialityMain.jsp", 1709120168000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/BlockSlotsBySpeciality.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script Language=\"JavaScript\">\n\nfunction assignValues(obj){\n\tvar formObj=document.forms[0];\n\tvar rows=window.parent.frames[1].rows;\n\tif(rows!=null){\n\t\tif(rows.length!=0)\n\t\t\trows.length=0;\n\t}\n\tvar RecordFrame=window.parent.frames[3];\n\tvar RecordFrame_formObj=RecordFrame.document.forms[0];\n\tvar update_mode_yn=RecordFrame_formObj.mode.value;\n\tvar val=obj.value;\n\tvar arr=val.split(\"::\");\n    var oper_room_code=arr[0];\n\tvar wd_start_time=arr[1];\n\tvar wd_end_time=arr[2];\n\tvar hd_start_time=arr[3];\n\tvar hd_end_time=arr[4];\n\t//alert(oper_room_code+\" \"+wd_start_time+\" \"+wd_end_time+\" \"+hd_start_time+\" \"+hd_end_time);\n\t\t\n    window.parent.frames[4].location.href=\'../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?\';\t\n\twindow.parent.frames[3].location.href=\"../../eOT/jsp/BlockSlotsBySpecialityRecord.jsp?oper_room_code=\"+oper_room_code+\"&wd_start_time=\"+wd_start_time+\"&wd_end_time=\"+wd_end_time+\"&hd_start_time=\"+hd_start_time+\"&hd_end_time=\"+hd_end_time+\"&update_mode_yn=\"+update_mode_yn;\n\n\t//alert(oper_room_code+\" \"+wd_start_time+\" \"+wd_end_time+\" \"+hd_start_time+\" \"+hd_end_time+\" \"+update_mode_yn);\n\t\n   //window.parent.frames[4].location.href=\'../../eOT/jsp/BlockSlotsBySpecialityDetailForm.jsp?\';  \n\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onload=\"parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\"BlockSlotsBySpecialityHdr\" id=\"BlockSlotsBySpecialityHdr\"  onload=\'FocusFirstElement()\'  action=\"\" method=\"\" target=\"messageFrame\"> \n\n<table border=0 cellspacing=0 cellpadding=3 width=\'60%\'  align=center>\n<!-- <tr>\n\t<td width=\'35%\'>&nbsp;</td>\n\t<td width=\'65%\'>&nbsp;</td>\n</tr> -->\n\n<tr>\n\t<td class=\"label\">\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</td>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<td class=\"fields\">\n\t\t<select name=\"oper_room_code\" id=\"oper_room_code\" onchange=\'assignValues(this);\'>\n\t\t<option value=\'\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</option>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n             <option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</option>\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\t\n\t ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<td class=\'label\'><select name=\"oper_room_code\" id=\"oper_room_code\"  disabled>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n           <option value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" selected>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\t\t\t   \n\t\t   <option value=\'\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n      ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'>\n\t\t\n\t ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\n</tr>\n\n<!-- <tr>\n\t<td width=\'35%\'>&nbsp;</td>\n\t<td width=\'65%\'>&nbsp;</td>\n</tr> -->\n</table>\n<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\"hidden\" name=\'oper_room_code1\' id=\'oper_room_code1\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<input type=\"hidden\" name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<input type=\"hidden\" name=\'curr_date\' id=\'curr_date\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("update_mode_yn");
//String chk_checked="checked";
//String chk_value="E";
String oper_room_code = request.getParameter("oper_room_code")==null?"":request.getParameter( "oper_room_code" );
if(oper_room_code.equals("null") || oper_room_code=="null"){
	oper_room_code="&nbsp;";
}
String short_desc="";
String sql="";
String facility_id=(String) session.getAttribute("facility_id");
String val="";
String curr_date="";
	try{	
		con=ConnectionManager.getConnection(request);
		stmt=con.prepareStatement("select '01'||to_char(sysdate,'/mm/yyyy') from dual");
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			curr_date=rs.getString(1);
		}
		if(rs!=null)rs.close();	
		if(stmt!=null) stmt.close();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

	if (mode.equals("insert")){
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		//sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
		sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID= ? AND NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? ORDER BY 1 ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 oper_room_code=rs.getString(1);
			 short_desc=rs.getString(2);
			 val=rs.getString(1)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5)+"::"+rs.getString(6);
    
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(val));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
  }
    
            _bw.write(_wl_block15Bytes, _wl_block15);
 
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();	  
}else if(mode .equals("modify")){

            _bw.write(_wl_block16Bytes, _wl_block16);

		//sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? ORDER BY 1 ";
		sql="SELECT  OPER_ROOM_CODE,SHORT_DESC,TO_CHAR(WD_START_TIME,'HH24:MI'),TO_CHAR(WD_END_TIME,'HH24:MI'),TO_CHAR(HD_START_TIME,'HH24:MI'),TO_CHAR(HD_END_TIME,'HH24:MI') FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID= ? AND NVL(STATUS,'E') = 'E' AND NVL(RESTRICT_BY_SPLTY_YN,'N')='Y' AND OPERATING_FACILITY_ID=? AND OPER_ROOM_CODE=? ORDER BY 1 ";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,facility_id);
		stmt.setString(3,oper_room_code);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
             short_desc=rs.getString(2);			         
      
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}
	  
            _bw.write(_wl_block21Bytes, _wl_block21);
 
}
	}catch(Exception e){
		e.printStackTrace();
		/* System.err.println("Exception in Block Slots by Speciality Main jsp:"+e);
		out.println("m==:"+m);
		out.println("Exception in Block Slots by Speciality Main jsp:"+e); */
	}finally{
		try{		
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(curr_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(request.getQueryString()));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
