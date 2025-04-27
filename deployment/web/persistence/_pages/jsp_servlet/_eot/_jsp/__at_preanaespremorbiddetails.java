package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __at_preanaespremorbiddetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_PreAnaesPreMorbidDetails.jsp", 1735796894000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\">\n\n\tvar code=new String();\n\tfunction sendparams(index)\n\t{\n\t\tvar rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; \n\t\tvar\tpre_morbid_code=rows.pre_morbid_code;\n\t\tvar\tpre_morbid_desc=rows.pre_morbid_desc;\n\t\tvar\tremarks=rows.remarks;\n\t\tvar temp_check=remarks.substring(0,1);\n\t\tvar\trecId = rows.recId;\t\t\t   \n\t\tvar mode = \"U\";\n\t\tvar str =  pre_morbid_code+\"::\"+pre_morbid_desc+\"::\"+remarks+\'::\'+recId+\'::\'+mode;\n\t\tvar frmObj = parent.frames[1];\n\t\tfrmObj.splitString(str);\n\t}\n\tfunction openDialogWindow(index){\n\tvar rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; \n\tvar str = rows.remarks;\n\t//var remarks = str;\n\tvar remarks=encodeURIComponent(str,\"UTF-8\");\n\tif(str==null || str==\'undefined\' || str==\"\")str=\"\";\n\t window.showModalDialog(\"../../eOT/jsp/AT_TextAreaRemarksNew.jsp?heading=Remarks&remarks=\"+remarks,window,\"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;\");\n}\n\t/*function openDialogWindowNew(index){\n\tvar rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows[index]; \n\tvar str = rows.remarks;\n//\tvar remarks = encodeURIComponent(str);\n\tvar remarks = str;\n\tvar temp_check=remarks.substring(0,1);\n\tif(str==null || str==\'undefined\' || str==\"\")str=\"\";\n\t window.showModalDialog(\"../../eOT/jsp/TextAreaRemarks.jsp?heading=Remarks&remarks=\"+remarks,window,\"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;\");\n}*/\n\n\tfunction createTable()\n\t{    \n\n\t\t var rows = parent.parent.parent.pre_anesthesia_objectcollect_frame.pre_morbid_rows; \n\t\t  var obj=document.getElementById(\"test\");\n\t\t  var tab_data=\"\";\n\t\t  var pre_morbid_code=\"\";\n\t\t  var pre_morbid_desc = \"\";\n\t\t  var preMorbidStatus_label = getLabel(\"eOT.PreMorbidStatus.Label\",\"OT\");\n\t\t  var remarks_label = getLabel(\"Common.remarks.label\",\"Common\");\n\t\t  var remarks=\"\";\n\t\t  var queryVal=\"\";\n\t\t  var recId=\"\";\n\t\t  var args=\"\";\n\t\t  var preMorbidStatus  =getLabel(\"eOT.PreMorbidStatus.Label\",\"OT\");\n\t\t  var Remarks          =getLabel(\"Common.remarks.label\",\"Common\");\n\t\t  tab_data=\"<table border=\'1\' cellpadding=3=\'3\' cellspacing=\'0\' width=\'100%\'>\"\n\t\t  tab_data+=\"<td class=\'COLUMNHEADERCENTER\'>\"+preMorbidStatus_label+\"</td>\"\n\t\t  tab_data+=\"<td class=\'COLUMNHEADERCENTER\'>\"+remarks_label+\"</td>\"\n\t\t  if(rows!=null && rows.length>0 ){\n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t  if(rows[jj]!=null &&  rows[jj].db_mode!=\'D\'){\n\t\t\t   pre_morbid_code=rows[jj].pre_morbid_code;\n\t\t\t   pre_morbid_desc=rows[jj].pre_morbid_desc;\n\t\t\t   remarks=rows[jj].remarks;\n\t\t\t     if(remarks.length>0)\n\t\t\t\t\tstrRemarks=\"<B>\"+Remarks+\"</B>\";\n\t\t\t   else\n\t\t\t\t   strRemarks=\"\"+Remarks+\"\";\n\t\t\t   recId = rows[jj].recId;\t\t\t   \n\t\t\t   args = jj;\n\t\t\t   code+=pre_morbid_code+\",\"; \n\t\t\t   if(jj%2==0)\n\t\t\t\t qryVal=\"QRYEVEN\";\n\t\t\t   else\n\t\t\t\t qryVal=\"QRYODD\"; \n\t\t\t\t\ttab_data+=\"<tr><td class=\"+qryVal+\">\";\n\t\t\t\t\ttab_data+=\"<a href=\\\"javascript:sendparams(\"+args+\");\\\">\"+pre_morbid_desc+\"</a></td>\";\n\t\t\t\t\ttab_data+=\"<td class=\"+qryVal+\">\";\n\t\t\t\t\ttab_data+=\"<a href=\\\"javascript:openDialogWindow(\"+args+\");\\\">\"+strRemarks+\"</a></td>\";\n\t\t\t\t\ttab_data+=\"</tr>\"; \n\t\t\t\t}\n\t\t\t  }//for Loop\n\t\t  }// end if \n\t\t  tab_data+=\"</table>\";\n\n\t\t  document.getElementById(\"test\").innerHTML = tab_data;\n\t\t  document.getElementById(\"test\").style.visibility=\"visible\";\n\t\t parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num= \';\n\t\t //file comiteed\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"createTable();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<div id=\"test\"></div>\n<form name=\"pre_morbid_details_form\" id=\"pre_morbid_details_form\" >\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");	
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
