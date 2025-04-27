package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __flowsheettexttoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/FlowSheetTextToolbar.jsp", 1709115892450L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n06/09/2013\t IN034512\t\tKarthi L\tA print Option existed next to Close Button in Clinical Event History.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n17/09/2013\t IN043274\t\tKarthi L  While printing a radiology resulted note from Clinical Event History>Flow sheet, it printed as empty \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n06/03/2014\t ICN060314\t\tRamesh G\t\t Error  Unclosed connection detected.\n---------------------------------------------------------------------------------------------------------------\nDate       \tEdit History    Name        \t\tRev.Date\t\tRev.Name \t\tDescription\n---------------------------------------------------------------------------------------------------------------\n11/11/2015\tIN057113\t\tKarthi L\t\t\t\t\t\t\t \t\t\t\tML-MMOH-CRF-0335 - IN057113\n12/17/2015  IN058156\t\tPrathyusha\t\t\t\t\t        \t\t\tOnce encounter is closed, there is no way for the user to check if the clinical notes in\n                                                                            the event history has been forwarded or modified by another practitioner.  \n05/02/2016\tIN004500\t\tRaja S\t\t\t\t\t\t\t\t\t\t\t\tGHL-SCF-1000\n10/03/2016  IN059532        Raja S\t\t\t\t\t\t\t\t\t\t\tAlpha-Regression-CA - System displays internal server error in \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    Clinical Event History.\n--------------------------------------------------------------------------------------------------------------------\n-->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCA/js/FlowSheet.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\t<body  onKeyDown=\"lockKey()\">\n\t<form name=\"flowsheet_text_toolbar\" id=\"flowsheet_text_toolbar\"> <!-- IN043274 -->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'> <!-- IN043274 -->\n\t\t<input type=\"hidden\" name=\"l_conf_pin_req_yn\" id=\"l_conf_pin_req_yn\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'><!-- ML-MMOH-CRF-0335 - IN057113 - Start  -->\n\t\t<table align=\'right\'><tr>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n\t\t\t    <td align=\'right\'><input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onclick=\"return showNotesAuditFlow(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"  /></td>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<!-- added below lines for IN034512 -->\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t<td align=\'right\'><input type=\'button\' class=\'button\' value=\'Print\' onclick=\'printData()\'>\n\t\t\t\t<input type=\"hidden\" name=\"sourceprint\" id=\"sourceprint\" value=\'CEH\'></td>  <!-- added below lines for IN004500 -->\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\n\t\t\t<td align=\'right\'><input type=\'button\' class=\'button\' value=\'Close\'  onClick=window.close()></td>\n\t\t\t\n\t\t</tr></table>\n\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
  // added for IN034512 - Start
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String AccessionNum = request.getParameter("Accessionnum") == null ? "" : request.getParameter("Accessionnum");
		String histRecType = request.getParameter("Histrectype") == null ? "" : request.getParameter("Histrectype"); //IN058156 //IN059532 added null check
		String contrSysId = request.getParameter("Contrsysid") == null ? "" : request.getParameter("Contrsysid"); //IN058156  //IN059532 added null check
		String noteHeaderDesc = "";
		PreparedStatement pstmt1 =	null; 
		ResultSet rs1 =	null; 
		Connection con = null;
		String confidentialPinReq = "N"; //ML-MMOH-CRF-0335 - IN057113				
		try {
			con = ConnectionManager.getConnection(request);
			String sqlQuery = "SELECT (SELECT ib.REPORT_HEADER FROM ca_note_group_lang_vw ib, ca_note_type ia WHERE ib.note_group = ia.note_group_id AND ia.note_type = a.note_type AND ib.language_id = ?) note_header_desc FROM ca_encntr_note a WHERE a.accession_num = ?";		
			pstmt1 = con.prepareStatement(sqlQuery);

			pstmt1.setString(1,locale);
			pstmt1.setString(2,AccessionNum);		
		
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				noteHeaderDesc		=	rs1.getString("note_header_desc")==null?"":rs1.getString("note_header_desc") ;
			}
			//ML-MMOH-CRF-0335 - IN057113 - Start
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			String selectSql = "SELECT CONF_PIN_REQ_YN FROM CA_PARAM WHERE MODULE_ID = 'CA'";
			pstmt1 = con.prepareStatement(selectSql);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				confidentialPinReq = rs1.getString("CONF_PIN_REQ_YN");
			}
			//ML-MMOH-CRF-0335 - IN057113 - End
		}
		catch(Exception ee)
		{
			out.println(ee.toString());
			ee.printStackTrace();
		}
		finally {
			if(rs1!=null)	rs1.close();
			if(pstmt1!=null)	pstmt1.close();
			if(con!=null)	con.close();	//added for ICN060314
		}
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(AccessionNum));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(confidentialPinReq));
            _bw.write(_wl_block10Bytes, _wl_block10);

			//IN058156 start
			if(histRecType.equals("CLNT")&&contrSysId.equals("CA")){  //IN059532
			
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(AccessionNum));
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
			//IN058156 end
			
            _bw.write(_wl_block14Bytes, _wl_block14);
 if(!noteHeaderDesc.equals("")) { 
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			
            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AuditLink.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
