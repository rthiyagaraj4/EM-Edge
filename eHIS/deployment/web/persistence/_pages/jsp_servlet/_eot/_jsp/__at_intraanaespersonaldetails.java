package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __at_intraanaespersonaldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_IntraAnaesPersonalDetails.jsp", 1709120154000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/Booking.js\"></script>\n\t<script language=\"javascript\">\n\tvar code=new String();\n\n\tfunction sendparams(index)\n\t{\n\t\tvar rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows[index]; \n\t\tvar\tpract_type=rows.pract_type;\n\t\tvar\tdesc_userdef=rows.desc_userdef;\n\t\tvar\tpractitioner_id=rows.practitioner_id;\n\t\tvar\tpractitioner_name=rows.practitioner_name;\n\t\tvar\trecId = rows.recId;\t\t\t   \n\t\tvar mode = \"U\";\n\t\tvar str =  pract_type+\"::\"+desc_userdef+\"::\"+practitioner_id+\"::\"+practitioner_name+\'::\'+recId+\'::\'+mode;\n\t\tvar frmObj = parent.frames[0];\n\t\tfrmObj.splitString(str);\n\t}\n\n\tfunction createTable()\n\t{    \n\t\t var rows = parent.parent.parent.Intra_anesthesia_objectcollect_frame.personnel_rows;\n \n\t\t  var obj=document.getElementById(\"test\");\n\t\t  var tab_data=\"\";\n\t\t  var pract_type=\"\";\n\t\t  var desc_userdef = \"\";\n\t\t  var practitioner_id=\"\";\n\t\t  var practitioner_name = \"\";\n\t\t  var queryVal=\"\";\n\t\t  var recId=\"\";\n\t\t  var Role\t=getLabel(\"Common.Role.label\",\"Common\");\n\t\t  var Name\t\t=getLabel(\"Common.name.label\",\"Common\");\n\t\t  var Position =getLabel(\"Common.Position.label\",\"Common\");\n\t\t\t \n\t\t  \n\t\t  var args=\"\";\n\t\t  tab_data=\"<table border=\'1\' cellpadding=3=\'3\' cellspacing=\'0\' width=\'100%\'>\"\n\t\t  tab_data+=\"<td class=\'COLUMNHEADERCENTER\' align=\'center\'>\"+Role+\"</td>\";\n\t\t  tab_data+=\"<td class=\'COLUMNHEADERCENTER\' align=\'center\'>\"+Name+\"</td>\";\n\t\t  tab_data+=\"<td class=\'COLUMNHEADERCENTER\' align=\'center\'>\"+Position+\"</td>\";\n\t\t  if(rows!=null && rows.length>0 ){\n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\t\t\t  \n\t\t\t  if(rows[jj]!=null &&  rows[jj].db_mode!=\'D\'){\n\t\t\t   pract_type=rows[jj].pract_type;\n\t\t\t   desc_userdef=rows[jj].desc_userdef;\n\t\t\t   practitioner_id=rows[jj].practitioner_id;\n\t\t\t   practitioner_name=rows[jj].practitioner_name;\n\t\t\t  // d_mode=rows[jj].db_mode;\n\t\t\t   recId = rows[jj].recId;\t\t\t   \n\t\t\t   args = jj;\n\t\t\t   code+=practitioner_id+\",\"; \n\t\t\t //  d_mode+=d_mode+\",\"; \n\t\t\t   if(jj%2==0)\n\t\t\t\t qryVal=\"QRYEVEN\";\n\t\t\t   else\n\t\t\t\t qryVal=\"QRYODD\"; \n\t\t\t\t\ttab_data+=\"<tr><td class=\"+qryVal+\">\";\n\t\t\t\t\ttab_data+=\"<a href=\\\"javascript:sendparams(\"+args+\");\\\">\"+desc_userdef+\"</a></td>\";\n\t\t\t\t\ttab_data+=\"<td class=\"+qryVal+\">\"+practitioner_name+\"</td>\";\n\t\t\t\t\ttab_data+=\"<td class=\"+qryVal+\">\"+rows[jj].position_desc+\"</td>\";\n\t\t\t\t\ttab_data+=\"</tr>\"; \n\t\t\t\t}\n\t\t\t  }//end of for Loop\n\t\t  }// end if \n\t\t\t\n\t\t\ttab_data+=\"</table>\";\n\t\t  document.getElementById(\"test\").innerHTML = tab_data;\n\t\t  document.getElementById(\"test\").style.visibility=\"visible\";\n\t\t  parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num= \';//not req.\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n<body onLoad=\"createTable();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<div id=\"test\"></div>\n<form name=\"pre_morbid_details_form\" id=\"pre_morbid_details_form\" >\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
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
