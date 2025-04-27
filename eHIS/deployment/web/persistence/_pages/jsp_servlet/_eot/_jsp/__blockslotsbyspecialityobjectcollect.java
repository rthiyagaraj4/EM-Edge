package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __blockslotsbyspecialityobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/BlockSlotsBySpecialityObjectCollect.jsp", 1709120168000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eOT/js/Hashtable.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\">\n\tvar rows = new Array();\n\tvar hash = new Hashtable()\n\t \n</script>\n<script language=\"javascript\">\nfunction createXMLForOT_SPECIALITY_TIME_TABLE(){\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n //alert(window.parent.parent.frames[1].frames[1].name);//hidden frame\n  var masterFrame=window.parent.parent.frames[1].frames[0];\n //alert(window.parent.parent.frames[1].frames[0].name);//masterframe\n  var formObj=masterFrame.document.forms[0];\n  var concatedStr=formObj.oper_room_code.value;\n  var arr=concatedStr.split(\"::\");\n  var oper_room_code=arr[0];\n  //alert(\"oper_room_code in Object Collect==\"+oper_room_code);\n  var len = rows.length;\n //alert(\"Length of the rows array===\"+len);\n  var table_name = \"OT_SPECIALITY_TIME_TABLE\";\n  var xmlString =\"\";\n  for(var i=0;i<len;i++){\n\t  if(rows[i]!=null && rows[i].mode!=\'L\' ){\n\t\t//alert(\"in the createXMLForOT_SPECIALITY_TIME_TABLE function\");\n\t\txmlString+=\"<SPECIALITY_TIME_TABLE\"+i+\" \";\n\t\txmlString+=\"operating_facility_id=\\\"\"+formObj.facility_id.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_room_code=\\\"\"+oper_room_code+\"\\\"\"+\" \";\n\t\txmlString+=\"day_code=\\\"\"+rows[i].day_code +\"\\\"\"+\" \";\n\t\txmlString+=\"speciality_code=\\\"\"+rows[i].speciality_code+\"\\\"\"+\" \";\n\t\txmlString+=\"start_time=\\\"\"+rows[i].start_time+\"\\\"\"+\" \";\n\t\txmlString+=\"db_start_time=\\\"\"+rows[i].start_time+\"\\\"\"+\" \";\n\t\txmlString+=\"end_time=\\\"\"+rows[i].end_time +\"\\\"\"+\" \";\n\t\txmlString+=\"schedule_type=\\\"\"+rows[i].schedule_type+\"\\\"\"+\" \";\n\t\txmlString+=\"first_week_yn=\\\"\"+rows[i].week1+\"\\\"\"+\" \";\n\t\txmlString+=\"second_week_yn=\\\"\"+rows[i].week2+\"\\\"\"+\" \";\n\t\txmlString+=\"third_week_yn=\\\"\"+rows[i].week3+\"\\\"\"+\" \";\n\t\txmlString+=\"fourth_week_yn=\\\"\"+rows[i].week4+\"\\\"\"+\" \";\n\t\txmlString+=\"fifth_week_yn=\\\"\"+rows[i].week5+\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+rows[i].mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t}\n\n\n\t }\n return xmlString;\n}\n\n/*function createXMLForSWAB_INSTR_TMPL_Hdr(){\n\t//alert(\"inside hdr func\");\n\t\n  var rows=window.parent.parent.frames[1].frames[1].rows;\n  \n  var formObj =window.parent.parent.frames[1].frames[0];\n  \n  var frmObj=formObj.document.forms[0];\n  var mode = frmObj.mode.value;\n  \n  var len = rows.length;\n  \n  var table_name = \"OT_SWAB_INSTR_TMPL_HDR\";\n  var xmlString =\"\";\n   \n\t  if(frmObj.template!=null){\n\t\t  //alert(\"before xml of HDR\");\n\t\txmlString+=\"<SWAB_INSTR_TMPL_HDR \"+\" \";\n\t\txmlString+=\"template_id=\\\"\"+frmObj.template.value+\"\\\"\"+\" \";\n\t\txmlString+=\"description=\\\"\"+frmObj.description.value +\"\\\"\"+\" \";\n\t\txmlString+=\"status=\\\"\"+frmObj.status.value +\"\\\"\"+\" \";\n\t\txmlString+=\"mode=\\\"\"+mode.toUpperCase()+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t\t//alert(\"after xml of HDR\");\n\t }\n \n return xmlString;\n}*/\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"ObjectCollectForm\" id=\"ObjectCollectForm\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
 request.setCharacterEncoding("UTF-8");
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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
