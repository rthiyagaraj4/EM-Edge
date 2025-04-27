package jsp_servlet._ess._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eSS.ReportsMasterCodeBean;

public final class __logsheetforautoclavesteamcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ess/jsp/LogSheetForAutoclaveSteamCriteria.jsp", 1741326114725L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eSS/js/SsCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eSS/js/LogSheetForAutoclaveSteam.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<body onLoad=\"FocusFirstElement();\"onMouseDown=\'CodeArrest();\'>\n\t\t<form name=\"formLogSheetForAutoclaveSteam\" id=\"formLogSheetForAutoclaveSteam\" action=\"../../eCommon/jsp/report_options.jsp\"  target=\"messageFrame\" >\n\t\t<br><br>\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\'center\' >\n\t\t\t<tr>\n\t\t\t<td width=\'100%\' align=\'center\' class=\"WHITE\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"80%\" align=\"center\" border=\"0\">\t\n\t\t\t\t<th align=\"left\" colspan=\"4\"><fmt:message key=\"Common.reportcritera.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/></th>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t <td align=\"right\" class=\"label\"><fmt:message key=\"eSS.SterilizationType.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t   \t\t\t  <td class=\"label\">&nbsp;&nbsp;&nbsp;&nbsp;<select name=\"p_sterile_type\" id=\"p_sterile_type\" >\n\t\t   \t\t\t  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t        \t  </select>\n\t\t        \t      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" class=\"label\">&nbsp;&nbsp;<fmt:message key=\"Common.from.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/></td>\n\t\t\t\t\t<td align=\"right\" >&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" class=\"label\">&nbsp;&nbsp;<fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/></td>\n\t\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"eSS.LoadNo.label\" bundle=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/></td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input class=\"NUMBER\"   maxLength=8 size=8 name=\"p_load_fm\" id=\"p_load_fm\" value=\"\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);\"></td>\n\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input class=\"NUMBER\"    maxLength=8 size=8 name=\"p_load_to\" id=\"p_load_to\" value=\"\" onKeyPress=\"return isValidInteger();\" onBlur=\"checkIntegerFormat(this);\"></td>\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\" nowrap><fmt:message key=\"eSS.AutoclaveDate.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/></td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name=\"p_fm_date1\" id=\"p_fm_date1\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" type=text class=\"DATE\" onBlur=\"CheckDate(this,\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\">&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_fm_date1\');\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</img></td>\n\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name=\"p_to_date1\" id=\"p_to_date1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\">&nbsp;<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'p_to_date1\');\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</img></td>\n\t\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\t\t\t\t\t\tvalue=\"SS\">\n\t\t\n\t\t\t<input type=\"hidden\" name=\"p_fm_date\" id=\"p_fm_date\" \t\t\t\t\t\t\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"p_to_date\" id=\"p_to_date\" \t\t\t\t\t\t\t\tvalue=\"\">\n\t\t\t\n\n\t\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" \t\t\t\t\t\t\tvalue=\"SSBLGSTRST\">\n\t\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" name=\"lang_id\" id=\"lang_id\"\t\t\t\t\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t</form>\n\t</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale= (String)session.getAttribute("LOCALE");


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		
		String bean_id					=	"reportsMasterCodeBean";
		String bean_name				=	"eSS.ReportsMasterCodeBean";
//		String p_report_id				=	 null;
		String facility_id				=  (String) session.getValue( "facility_id" ) ;
		String user_name				=  (String) session.getValue( "login_user" ) ;
		
//		ReportsMasterCodeBean bean		= (ReportsMasterCodeBean) mh.getBeanObject( bean_id, request,  bean_name);
		ReportsMasterCodeBean bean		= (ReportsMasterCodeBean) getBeanObject( bean_id, bean_name, request);
		HashMap alstartdate 	= 		 null;
		alstartdate             =        bean.getDurationforStartDate();
		String currentdate	    =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
		String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
		
		bean.clear();
		bean.setLanguageId(locale);
		
		
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bean.getSterile_type_List()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(bean.getMandatoryImageTag()));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ss_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(currentdateminus));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bean.getMandatoryImageTag()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.getMandatoryImageTag()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
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
}
