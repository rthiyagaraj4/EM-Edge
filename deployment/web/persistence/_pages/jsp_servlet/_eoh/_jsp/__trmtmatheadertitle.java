package jsp_servlet._eoh._jsp;

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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __trmtmatheadertitle extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/TrmtMatHeaderTitle.jsp", 1742903810663L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eOH/js/TrmtMatDetails.js\" language=\"javascript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eOH/js/Hashtable.js\"></script>\n\t\t<script>\n\t\t\tfunction assignThai(){\n\t\t\t\t//var task_desc = document.forms[0].task_desc.value;\n\t\t\t\t//alert(unescape(task_desc));\n\t\t\t}\n\t\t</script>\n\t\t\n\t</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onload=\"assignThai();\">\n\t<form name=\"TrmtMatHeaderFormTitle\" id=\"TrmtMatHeaderFormTitle\">\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t<table align=\'center\' cellpadding=\'4\' cellspacing=\'\' border=\'0\' width=\'98%\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\"25%\">&nbsp;</td>\n\t\t\t\t<td colspan=2 width=\"25%\" align=right>\n\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"close\" id=\"close\" value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onclick=\"closewindow();\" >\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table align=\'center\' cellpadding=\'4\' cellspacing=\'\' border=\'1\' width=\'98%\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\"columnHeaderCenter\" width=\"25%\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t<td class=\"columnHeaderCenter\" width=\"25%\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t<table align=\'center\' cellpadding=\'4\' cellspacing=\'\' border=\'0\' width=\'98%\'>\n\t\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t<tr>\n\t\t\t\t\t\t<!-- <td  width=\'45%\' ><A onclick = \"populateCompositionDetails(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\');\" onmouseover=\"this.style.color=\'blue\'\" onmouseout = \"this.style.color=\'\'\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A></td> -->\n\t\t\t\t\t\t<!-- <td  width=\'45%\' ><font color=\'blue\'><A onclick = \"populateCompositionDetails(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</A></font></td> -->\n\t\t\t\t\t\t<td  width=\'45%\' ><font color=\'blue\'><A onclick = \"populateCompositionDetails(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</A></font></td>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<td width=\"25%\">\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"completed";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"completed";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onClick=\"setCheckValue(count);updatetrmtdtlsentry(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" value=\'\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" >\n\t\t\t\t\t\t\t</td>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" value=\'\' checked disabled ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t\t\t\t\t<!--Added encode for task_desc on 9/17/2010 for 23245 by AnithaJ-->\n\t\t\t\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!-- <td  width=\'45%\' ><font color=\'blue\'><A onclick = \"populateCompositionDetails(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</A></font></td> -->\n\t\t\t\t\t\t\t<td  width=\'45%\' ><font color=\'blue\'><A onclick = \"populateCompositionDetails(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<td width=\"25%\">\n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"completed";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" > \n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =">\n\t\t\t\t\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t</table>\n\n\t\t<!-- <table border=\"1\" width=\"98%\" cellspacing=\'0\' cellpadding=\'1\'  align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td class=\'columnHeaderCenter\' width=\'30%\' wrap>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t<td class=\'columnHeaderCenter\' width=\'30%%\' wrap>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t<td class=\'columnHeaderCenter\' width=\'10%%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t\t</tr>\n\t\t</table> -->\n\n\t\t<input type=\"hidden\" name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n\t\t<input type=\"hidden\" name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t\t<input type=\"hidden\" name=\"totalSelected\" id=\"totalSelected\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" >\n\t\t<input type=\"hidden\" name=\"tooth_range_count_for_order\" id=\"tooth_range_count_for_order\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" >\n\t\t<input type=\"hidden\" name= \"patient_id\" value = \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"hidden\" name= \"chart_num\" value = \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name= \"chart_line_num\" value = \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"hidden\" name= \"trmt_code\" value = \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name= \"maxRecord\" value = \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name= \"display_tooth_no\" value = \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name= \"trmt_dtls_entry_cmpl_yn\" value = \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name= \"params\" value = \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name= \"task_code_req\" value = \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name= \"status_disabled\" value = \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name= \"ind_chart_line_num\" value = \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\" name= \"i\" value = \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\" name= \"count\" value = \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\" name= \"baseline_chart_yn\" value = \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name= \"date_diff_flag\" value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\n\t\t<input type = \"hidden\" name= \"oh_chart_level\" value = \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type = \"hidden\" name= \"other_chart_facility_id\" value = \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<!--Added by Sharon Crasta on 8/20/2009 for IN010893(SRR20056-CRF-0480) -->\n\t\t<input type = \"hidden\" name= \"seq_no\" value = \"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\n\n\t\t<input type = \"hidden\" name= \"from\" value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type = \"hidden\" name= \"to\" value = \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type = \"hidden\" name= \"task_desc\" value = \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type = \"hidden\" name= \"trmt_cat_type\" value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\t\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );
 
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

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rst=null;
	String strsql = "";
    String facility_id = (String)session.getValue( "facility_id" ) ;
	int maxRecord = 0;


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
   
    String DB_task_desc="";
	String DB_task_code="";
	String DB_task_seq="";
	int i=1;
	int count=0;

	String from = checkForNull(request.getParameter( "from" )) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?10:Integer.parseInt(to);

	StringBuffer sbr = new StringBuffer();

	String trmt_desc = "";
	String trmt_dtls_entry_cmpl_yn = "";
    
	String totalSelected=checkForNull(request.getParameter("totalSelected"));
	String tooth_range_count_for_order=checkForNull(request.getParameter("tooth_range_count_for_order"));
	//String site_type=checkForNull(request.getParameter("site_type"));
	String patient_id=checkForNull(request.getParameter("patient_id"));
	String chart_num=checkForNull(request.getParameter("chart_num"));
	String chart_line_num=checkForNull(request.getParameter("chart_line_num"));
	String trmt_code=checkForNull(request.getParameter("trmt_code"));
	String display_tooth_no=checkForNull(request.getParameter("display_tooth_no"));
	String task_code_req = checkForNull(request.getParameter("task_code"));
	String trmt_cat_type = checkForNull(request.getParameter("trmt_cat_type"));
	String seq_no	= checkForNull(request.getParameter( "task_seq" )) ;
	String baseline_chart_yn = checkForNull(request.getParameter("baseline_chart_yn"));//Added by Sridevi Johi on 5/27/2010 for IN021653
	String date_diff_flag = checkForNull(request.getParameter("date_diff_flag"));//Added by Sridevi Johi on 5/27/2010 for IN021668

	 /* Start By sridevi joshi for In012626 on 02/09/09 */
	String ind_chart_line_num=checkForNull(request.getParameter("ind_chart_line_num"));
	 /* End*/

	 /* Added by Sharon Crasta on 11/13/2008 for SCR #6492 */

	 	String task_desc = checkForNull(request.getParameter("task_desc"));

		//task_desc = java.net.URLDecoder.decode(task_desc);
		//task_desc = java.net.URLDecoder.decode( task_desc,"UTF-8" );//Added by Sridevi Joshi on 8/16/2010 for IN023245


	 /* End*/


	String status_disabled =  checkForNull(request.getParameter("status_disabled"));
	String oh_chart_level = checkForNull(request.getParameter( "oh_chart_level" )) ;
	String other_chart_facility_id  = checkForNull(request.getParameter( "other_chart_facility_id" )) ;			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}
	if(!other_chart_facility_id.equals(facility_id)){
		status_disabled = "disabled";	
	}

	
	try{
		conn  =  ConnectionManager.getConnection(request);
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
		pstmt=conn.prepareStatement("SELECT TRMT_DESC FROM OH_TREATMENT  WHERE TRMT_CODE = ?");
		pstmt.setString(1,trmt_code);
		rst = pstmt.executeQuery();
		while(rst.next()){
			trmt_desc = rst.getString("TRMT_DESC");
		}

		//To get TRMT_DTLS_ENTRY_CMPL_YN for Task
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
		pstmt=conn.prepareStatement("SELECT TRMT_DTLS_ENTRY_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS where PATIENT_ID = ? AND CHART_NUM=? AND CHART_LINE_NUM=? AND TRMT_CODE= ? AND TASK_CODE=? AND TASK_SEQ=?");
		pstmt.setString(1,patient_id); 
		pstmt.setString(2,chart_num); 
		pstmt.setString(3,chart_line_num); 
		pstmt.setString(4,trmt_code); 
		pstmt.setString(5,task_code_req); 
		pstmt.setString(6,seq_no); 
		rst = pstmt.executeQuery();
		while(rst.next()){
			trmt_dtls_entry_cmpl_yn = rst.getString("TRMT_DTLS_ENTRY_CMPL_YN");
		}

		/*if(trmt_dtls_entry_cmpl_yn.equals("N") || trmt_dtls_entry_cmpl_yn.equals("")){
			status_disabled = "";
		}
		else{
			status_disabled = "disabled";
		}*/

		if(trmt_dtls_entry_cmpl_yn.equals("Y") || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/27/2010 for IN021653
			status_disabled= "disabled";
		}else{
			status_disabled= "";
		}

		strsql="SELECT A.TASK_CODE,D.TASK_DESC,B.COMPOSITION_CLASS_CODE, B.COMPOSITION_CLASS_DESC, C.COMPOSITION_CODE, C.COMPOSITION_DESC FROM OH_RESTORATIVE_CHART_MATRL A, OH_COMPOSITION_CLASS B, OH_COMPOSITION C, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE = ? AND A.COMPOSITION_CLASS_CODE = B.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CLASS_CODE = C.COMPOSITION_CLASS_CODE AND A.COMPOSITION_CODE = C.COMPOSITION_CODE AND B.COMPOSITION_CLASS_CODE	= C.COMPOSITION_CLASS_CODE AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ?";
		if(pstmt != null) pstmt.close();
		if(rst != null) rst.close();
    
		int total=0;

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,task_code_req);
		pstmt.setString(6,locale);
		rst = pstmt.executeQuery();
		while(rst.next()){
			total++;
		}

        maxRecord = total;

		pstmt = conn.prepareStatement(strsql);
		pstmt.setString(1,patient_id);
		pstmt.setString(2,chart_num);
		pstmt.setString(3,chart_line_num);
		pstmt.setString(4,trmt_code);
		pstmt.setString(5,task_code_req);
		pstmt.setString(6,locale);
		rst = pstmt.executeQuery();
		if( start != 1 ){
			for( int j=1; j<start; i++,j++ ){
				rst.next() ;
			}
		}

		while ( rst.next() && i<=end  ){
			i++;
		}

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

				if(!task_code_req.equals("")){
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(task_desc)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
	 
						if(trmt_dtls_entry_cmpl_yn.equals("N") || trmt_dtls_entry_cmpl_yn.equals("")){
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(task_desc)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
						}else if(trmt_dtls_entry_cmpl_yn.equals("Y")){
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(java.net.URLEncoder.encode(task_desc)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block23Bytes, _wl_block23);
	
						}
			
            _bw.write(_wl_block24Bytes, _wl_block24);

				}else{	
					strsql="SELECT A.TASK_SEQ, A.TASK_CODE, D.TASK_DESC, A.TRMT_DTLS_ENTRY_CMPL_YN FROM OH_RESTORATIVE_CHART_TASKS A, OH_TASKS_LANG D WHERE A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.CHART_LINE_NUM = ? AND A.TRMT_CODE = ? AND A.TASK_CODE=D.TASK_CODE AND D.LANGUAGE_ID = ? AND NVL(STATUS,'X') != 'E' ORDER BY TASK_SEQ";
					if(pstmt != null) pstmt.close();
					if(rst != null) rst.close();
					
					pstmt = conn.prepareStatement(strsql);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,chart_num);
					pstmt.setString(3,chart_line_num);
					pstmt.setString(4,trmt_code);
					pstmt.setString(5,locale);
					rst = pstmt.executeQuery();
					while(rst.next()){
						
						DB_task_code = checkForNull(rst.getString("TASK_CODE"));
						DB_task_desc = checkForNull(rst.getString("TASK_DESC"));
						DB_task_seq = checkForNull(rst.getString("TASK_SEQ"));
						trmt_dtls_entry_cmpl_yn = checkForNull(rst.getString("TRMT_DTLS_ENTRY_CMPL_YN"));
						/*if(trmt_dtls_entry_cmpl_yn.equals("N") || trmt_dtls_entry_cmpl_yn.equals("")){
							status_disabled = "";
						}
						else{
							status_disabled = "disabled";
						}*/

						if(trmt_dtls_entry_cmpl_yn.equals("Y") || baseline_chart_yn.equals("Y") || date_diff_flag.equals("disable")){//Condition for baseline_chart_yn is added by Sridevi Joshi on 5/27/2010 for IN021653
							status_disabled= "disabled";
						}else{
							status_disabled= "";
						}
			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DB_task_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_seq));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(DB_task_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_seq));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
	 
							if(trmt_dtls_entry_cmpl_yn.equals("N") || trmt_dtls_entry_cmpl_yn.equals("")){
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DB_task_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_seq));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block29Bytes, _wl_block29);
 
							}else if(trmt_dtls_entry_cmpl_yn.equals("Y")){
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(DB_task_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(DB_task_seq));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
	
							}
			
            _bw.write(_wl_block31Bytes, _wl_block31);
			count++;	
					}	 
			
            _bw.write(_wl_block32Bytes, _wl_block32);
	} 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(start));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(totalSelected));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(tooth_range_count_for_order));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(chart_num));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(chart_line_num));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(trmt_code));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(display_tooth_no));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(trmt_dtls_entry_cmpl_yn));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(task_code_req));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(status_disabled));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ind_chart_line_num));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(baseline_chart_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(date_diff_flag));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(oh_chart_level));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(other_chart_facility_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(from));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(to));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(task_desc));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(trmt_cat_type));
            _bw.write(_wl_block62Bytes, _wl_block62);
 
	}catch(Exception e){
		out.println("TrmtDetailsForm : "+e);
  	}finally{
		try{
			if(rst!=null)	rst.close();
			if(pstmt!=null)	pstmt.close();
			if(sbr!=null)   sbr.setLength(0);
			ConnectionManager.returnConnection(conn,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block63Bytes, _wl_block63);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.Task.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.DataEntryCompleted.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOH.CompositionClass.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Composition.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
