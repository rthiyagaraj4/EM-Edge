package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;

public final class __postoperdiagnosisdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PostOperDiagnosisDtls.jsp", 1709120312000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/RecordSurgeon.js\'></script>\n<script language=\"javascript\">\nvar code = new String();\n\nfunction sendparams(index){\n\tvar rows = parent.parent.ObjectCollect.diagnosis_rows[index];\n\tvar mode = \"U\";\n\tvar str = rows.icd_code+\'::\'+rows.icd_desc+\'::\'+rows.primary+\'::\'+rows.significant+\'::\'+rows.onset_date+\'::\'+rows.close_date+\'::\'+rows.remarks+\'::\'+rows.recId+\'::\'+mode;\n\t//alert(str);\n\tvar frmObj = parent.RecordFrame;\n\tfrmObj.splitString(str);\n}\n\nfunction openDialogWindow(strVal,remarks){\n  window.showModalDialog(\'../../eOT/jsp/TextArea.jsp?heading=\'+strVal+\'&remarks=\'+remarks,window,\"dialogHeight: 145px; dialogWidth:500px; center: yes; help: no; resizable: no; status: no;\");\n}\n\nfunction createTable(){   \n  var rows=parent.parent.ObjectCollect.diagnosis_rows;\n  var db_flag=parent.parent.ObjectCollect.db_flag;\n // alert(rows.length);\n\n\n  var tab_data=\"\";\n  tab_data=\"<table border=\'1\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\"\n  tab_data+=\"<td align=\'center\'>&nbsp;ICD&nbsp;</td>\"\n  tab_data+=\"<td align=\'center\'>\n  <fmt:message key=\"Common.primary.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></td>\"\n  tab_data+=\"<td align=\'center\'>\n  <fmt:message key=\"Common.significant.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></th>\"\n  tab_data+=\"<td class=\'columnheader\' ><fmt:message key=\"Common.onsetdate.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\"\n  tab_data+=\"<td\tclass=\'columnheader\'><fmt:message key=\"eCA.CloseDate.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/></td>\"\n  tab_data+=\"<td  class=\'columnheader\'>\n  <fmt:message key=\"Common.remarks.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></td>\" \n  var args=\'\';\n  if(rows!=null){\n\t  for(var jj=0;jj<rows.length;jj++) {\n\t\t   if(rows[jj]!=null  && rows[jj].db_mode!=\'D\'){\n\t\t\t\targs=jj;\n\t\t\t\tcode+= rows[jj].icd_code+\",\";\n\t\t\t    if(jj%2==0)\n\t\t\t     qryVal=\"QRYEVEN\";\n\t\t\t   else\n\t\t\t\t qryVal=\"QRYODD\";\n\t\t\t\t   tab_data+=\"<tr><td class=\"+qryVal+\">\";\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t   \n\t\t\t\t   tab_data+=rows[jj].icd_desc+\"</a></td>\";\n\t\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t   tab_data+=\"<a href=\\\"javascript:sendparams(\"+args+\");\\\">\"+rows[jj].icd_desc+\"</a></td>\";\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\ttab_data+=\"<td class=\"+qryVal+\" align=\'center\'>\";\n\t\t\t\t   if(rows[jj].primary==\'Y\'){\n\t\t\t\t     tab_data+=\"<input type=\'checkbox\' name=chkbox_pri_\"+jj+\" checked disabled></td>\";\n\t\t\t\t   }else {\n\t\t\t\t\t tab_data+=\"<input type=\'checkbox\' name=chkbox_pri_\"+jj+\" disabled ></td>\";\n\t\t\t\t   }\n\n\t\t\t\t   tab_data+=\"<td class=\"+qryVal+\" align=\'center\'>\";\n\t\t\t\t   \n\t\t\t\t   if(rows[jj].significant==\'Y\'){\n\t\t\t\t     tab_data+=\"<input type=\'checkbox\' name=chkbox_sig_\"+jj+\" checked disabled ></td>\";\n\t\t\t\t   }else {\n\t\t\t\t\t tab_data+=\"<input type=\'checkbox\' name=chkbox_sig_\"+jj+\" disabled ></td>\";\n\t\t\t\t   }\n\n\t\t\t\t   tab_data+=\"<td class=\"+qryVal+\">\"+rows[jj].onset_date+\"</td>\";\n\t\t\t\t   tab_data+=\"<td class=\"+qryVal+\">\"+rows[jj].close_date+\"</td>\";\n\t\t\t\t   tab_data+=\"<td class=\"+qryVal+\">\n\t\t\t\t   <a href=\\\"javascript:openDialogWindow(remarks,\'\"+rows[jj].remarks+\"\');\\\"><fmt:message key=\"Common.remarks.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/></a></td>\";\n\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t   if(db_flag==\'ON\')\n\t\t\t\t\t\tparent.parent.ObjectCollect.db_flag=\'OFF\';\n\n\n\t\t\t\t  //alert(tab_data);\t\t\n\t   }\n\t }\n  }\n  document.getElementById(\"test\").innerHTML = tab_data;\n  document.getElementById(\"test\").style.visibility=\'visible\';\n}\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\'createTable();\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'InstrumentDtlsForm\' id=\'InstrumentDtlsForm\' >\n</form>\n<div id=\'test\'></div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	//If calling from Surgeon History this flag is used
	String qry_mode = CommonBean.checkForNull(request.getParameter("qry_mode"));
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String remarks =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels")+",";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
if( surgeon_doc_comp_yn.equals("Y") || qry_mode.equals("YES") ){
            _bw.write(_wl_block10Bytes, _wl_block10);
} else {
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
