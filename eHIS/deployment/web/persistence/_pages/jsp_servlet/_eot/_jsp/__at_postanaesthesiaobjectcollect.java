package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __at_postanaesthesiaobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_PostAnaesthesiaObjectCollect.jsp", 1709120158000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script language=\'javascript\'>\nvar compl_rows = new Array();\nvar personnel_rows = new Array();\nvar personnel_len=0;\n\n</script>\n<script language=\'javascript\'>\n \nfunction createXMLForHdr(){\n  var formObjHdr = parent.AnaesthesiaHdrFrame.RecordAnesthesiaHdrForm;\n  var PostStatusformObj = window.parent.parent.frames[7].document.forms[0];\n  var formObjDtl = parent.AnaesthesiaDetailsFrame.AnaesthesiaParticularsForm;\n  var locale=formObjDtl.locale.value;\n  var table_name=\"AT_ANAESTHESIA_RECORD_HDR\";\n  var db_mode=\"U\";\n  var finish_time = formObjDtl.finish_date.value+\" \"+formObjDtl.finish_time.value;\n  var finish_date=formObjDtl.finish_date.value;\n  var rec_start_date=formObjDtl.rec_start_date.value;\n  var rec_finish_date=formObjDtl.rec_finish_date.value;\n  if(finish_date!=\"\")\n  finish_date=convertDate(finish_date,\"DMY\",locale,\"en\");\n  if(rec_start_date!=\"\")\n  rec_start_date=convertDate(rec_start_date,\"DMY\",locale,\"en\");\n  if(rec_finish_date!=\"\")\n  rec_finish_date=convertDate(rec_finish_date,\"DMY\",locale,\"en\");\n  var height = formObjHdr.height.value;\n  var weight = formObjHdr.weight.value;\n  var BMI = formObjHdr.bmi.value;\n  //var BSA = formObjHdr.bsa.value;\n  var BSA = formObjHdr.bsaDisp.value;\n  var doc_comp = \"\";\n  var status=\"\";\n   if(PostStatusformObj.checkAnaes.checked==true){\n\t\t\tdoc_comp=\"Y\";\n\t\t\tstatus=\"FN\"\n\t}else{\n\t\t\tdoc_comp=\"N\";\n\t\t\tstatus=\"PO\"\n\t}\n\tvar xmlString =\"\";\n\txmlString+=\"<HDR_DTL\"+\" \";\n\txmlString+=\"finish_time=\\\"\"+finish_date+\" \"+formObjDtl.finish_time.value+\"\\\"\"+\" \";\n\txmlString+=\"anesthesia_srl_no=\\\"\"+document.forms[0].anaesthesia_srl_no.value+\"\\\"\"+\" \";\n\txmlString+=\"rec_start_date_time=\\\"\"+rec_start_date+\" \"+formObjDtl.rec_start_time.value+\"\\\"\"+\" \";\n\txmlString+=\"rec_finish_date_time=\\\"\"+rec_finish_date+\" \"+formObjDtl.rec_finish_time.value+\"\\\"\"+\" \";\n\txmlString+=\"height=\\\"\"+formObjHdr.height.value+\"\\\"\"+\" \";\n\txmlString+=\"weight=\\\"\"+formObjHdr.weight.value+\"\\\"\"+\" \";\n\txmlString+=\"BMI=\\\"\"+formObjHdr.bmi.value+\"\\\"\"+\" \";\n\t//xmlString+=\"BSA=\\\"\"+formObjHdr.bsa.value+\"\\\"\"+\" \";\n\txmlString+=\"BSA=\\\"\"+formObjHdr.bsaDisp.value+\"\\\"\"+\" \";\n\txmlString+=\"doc_comp=\\\"\"+doc_comp+\"\\\"\"+\" \";\n\txmlString+=\"status=\\\"\"+status+\"\\\"\"+\" \";\n\txmlString+=\"db_mode=\\\"\"+db_mode+\"\\\"\"+\" \";\n\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n    return xmlString;\n}\n\nfunction createXMLForPersonnelDetails(){\n  var rows=parent.ObjectCollect.personnel_rows;\n  var table_name=\"AT_PERSONNEL\";\n  var len = rows.length;\n  var xmlString =\"\";\n  for(i=0;i<len;i++){\n\t if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t\txmlString+=\"<PERSONNEL_DTL\"+i+\" \";\n\t\txmlString+=\"anesthesia_srl_no=\\\"\"+document.forms[0].anaesthesia_srl_no.value+\"\\\"\"+\" \";\n\t\txmlString+=\"pract_type=\\\"\"+rows[i].pract_type+\"\\\"\"+\" \";\n\t\txmlString+=\"practitioner_id=\\\"\"+rows[i].practitioner_id+\"\\\"\"+\" \";\n\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\n\t }\n  }\n  return xmlString;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"PAObjectCollectForm\" id=\"PAObjectCollectForm\">\n<input type = \"hidden\" name=\"anaesthesia_srl_no\" id=\"anaesthesia_srl_no\" value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type = \"hidden\" name=\"params\" id=\"params\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
 request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getParameter("anesthesia_srl_no")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
