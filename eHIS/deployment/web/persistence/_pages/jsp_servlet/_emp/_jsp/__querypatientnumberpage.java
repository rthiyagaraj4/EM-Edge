package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __querypatientnumberpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/queryPatientNumberPage.jsp", 1741157219399L ,"10.3.6.0","Asia/Calcutta")) return true;
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
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

	out.println("<html><head>");
	out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels")+"</title>");
	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
	out.println("<script  language='javascript'>	function addOrderByCol()	{ 		var from = document.getElementById('item')('orderbycols'); if ( from.options.length > 0 ) { var to = document.getElementById('item')('orderbycolumns'); var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value= from.options[from.selectedIndex].value; to.add(element); 			from.remove(from.selectedIndex); } } function removeOrderByCol()	{ var from = document.getElementById('item')('orderbycolumns'); if ( from.options.length > 0 ){ var to = document.getElementById('item')('orderbycols');		var element = document.createElement('OPTION'); element.text = from.options[from.selectedIndex].text; element.value = from.options[from.selectedIndex].value; to.add(element);			from.remove(from.selectedIndex); } }	function SelectAll(){var i = 0; document.getElementById('orderbycolumns').selectedIndex=0; while ( i < document.getElementById('orderbycolumns').length) { 	document.getElementById('orderbycolumns').options[i].selected=true; i++; }} function execQuery(){  SelectAll(); document.query_form.submit();}</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	out.println("</head><body onKeyDown='lockKey()'><form name='query_form' id='query_form' method='post' action='../jsp/queryPatientNumber.jsp' onsubmit='SelectAll()'>");

	out.println("<table width='80%' align='center'><tr><td>&nbsp;</td></tr><th align='left' width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels")+"</th><tr><td width='60%' ><p class='BOX' title='Query Criteria'><table width='100%'>");


	out.println("<tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td>");
	out.println("<td  align ='left' width='60%'>&nbsp;&nbsp;<input name ='pat_ser_grp_code' size='2' maxlength='2'></td></tr>");

	out.println("<tr><td align='right' width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</td>");
	out.println("<td  align ='left' width='60%'>&nbsp;&nbsp;<input name ='long_desc' size='30' maxlength='30'></td></tr>");


	out.println("</table></td></tr></table></p>");


	out.println("<table width='80%' align='center'><th width='20%' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels")+"</th><tr><td width='60%'> <p class='BOX' title='Sort Order'><table width='100%'><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</th><th>&nbsp;</th><th>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels")+"</th><tr><td width='45%' align='center'><select name='orderbycols' id='orderbycols' size='5' >");
	out.println("<option value='long_desc'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels")+"</option>");
	out.println("</select></td>");

	out.println("<td align='center' width='10%'><img src='../../eCommon/images/add.gif' onclick='addOrderByCol()'></img><img src='../../eCommon/images/remove.gif' onclick='removeOrderByCol()'></img></td>");
	out.println("<td width='45%' align='center'><select name='orderbycolumns' id='orderbycolumns' size='5' multiple='true'>");
	out.println("<option value='pat_ser_grp_code'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</option></select></td></tr></table></p></td></tr></table>");
	out.println("<br><table border='0' width='100%' align='center'><tr><td width='100%' align='center' ><a href='javascript:execQuery()'><img src='../../eCommon/images/RRexecuteQuery.gif' border='0'></a></td></tr></table> ");
	out.println("</form></body></html>");


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
