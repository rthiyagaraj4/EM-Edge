package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.lang.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __narcregcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/NarcRegCriteria.jsp", 1727437413310L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n<!-- \t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link>\n -->\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' ></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<!--<script language=\"javascript\" src=\"../../eST/js/StMessages.js\"></script> -->\n\t\t<script language=\"javascript\" src=\"../../eST/js/NarcReg.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body onLoad=\"FocusFirstElement();\">\n\t\t<form name=\"NarcRegCriteria\" id=\"NarcRegCriteria\" action=\"../../eCommon/jsp/report_options.jsp\"  target=\"messageFrame\" >\n\t\t<br><br>\n\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\' align=\'center\' >\n\t\t\t<tr>\n\t\t\t<td width=\'100%\' align=\'center\' class=\"WHITE\">\n\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"98%\" align=\"center\" border=\"0\">\n\t\t\t\t<th colspan=8 align=left>Report Criteria</th>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\" class=\"label\">Store</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name=\"p_str_code\" id=\"p_str_code\"  value=\"\" ><input class=\"button\" name=\"p_fm_stc\" id=\"p_fm_stc\" onClick=\" searchCodeStore(p_str_code);\"  type=\"button\"  value=\"?\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></td></td>\n\t\t\t\t\t<td align=\"left\" class=\"label\">Item</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=20 size=20  name=\"p_item_code\" id=\"p_item_code\" value=\"\" ><input class=\"button\" name=\"p_fm_sr2\" id=\"p_fm_sr2\" onClick=\"return searchCodeItem(p_item_code);\" type=\"button\" value=\"?\" ><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img></td></td>\n\t\t\t\t\t<td class=\"label\">&nbsp;</td>\n\n\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\"left\">&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" class=\"label\">&nbsp;&nbsp;From</td>\n\t\t\t\t\t<td align=\"right\" >&nbsp;</td>\n\t\t\t\t\t<td class=\"label\" class=\"label\" colspan=5 width\"10%\">&nbsp;&nbsp;To</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\t\n\t\t\t\t\t<td align=\"left\" class=\"label\">Month/Year</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name=\"p_from_month\" id=\"p_from_month\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onBlur=\"Pfrmmnth();\" onKeyPress=\"return isValidInteger();\"  class=\"NUMBER\"> \n\t\t\t\t\t<class=text> / \t<class=text> <input maxLength=4 size=4 name=\"p_from_year\" id=\"p_from_year\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" onBlur=\"Pfrmyear();\" onKeyPress=\"return isValidInteger();\"  class=\"NUMBER\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>   </td> \n\t\t\t\t <td align=\"left\" class=\"label\">Month/Year</td>\n\t\t\t\t\t<td class=label>&nbsp;&nbsp;<input maxLength=2 size=2 name=\"p_to_month\" id=\"p_to_month\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onBlur=\"Ptomnth();\" onKeyPress=\"return isValidInteger();\"  class=\"NUMBER\"> \n\t\t\t\t\t<class=text> / \t<class=text> <input maxLength=4 size=4 name=\"p_to_year\" id=\"p_to_year\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onBlur=\"Ptoyear();\" onKeyPress=\"return isValidInteger();\"  class=\"NUMBER\"><img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>   </td> \n\t\t\t\t \t<td class=\"label\">&nbsp;</td>\n\t\t\t\t </tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t   <!--  <tr>\n\t\t\t\t\t<td align=\"right\" class=\"label\">Print Technical Specification</td>\n\t\t\t\t\t<td align=\"left\">&nbsp;<input type=\"checkbox\" value=\"E\" name=\"print_spec\" id=\"print_spec\"></td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t\t<td align=\"right\">&nbsp;</td>\n\t\t\t\t</tr> -->\n                \n\t\t\t\t</table>\n\t\t\t\t</td>  \n\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" \t\tvalue=\"ST\">\n\t\t\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"STBNARDC\">\n\t\t\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" name=\"SQL_ST_STORE_LOOKUP\" id=\"SQL_ST_STORE_LOOKUP\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\"hidden\" name=\"SQL_ST_ITEM_LOOKUP\" id=\"SQL_ST_ITEM_LOOKUP\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" name=\"curr_proc_month\" id=\"curr_proc_month\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\"hidden\" name=\"curr_proc_year\" id=\"curr_proc_year\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\n\t\t</form>\n\t\t          \n\t\t\t</body>\n</html>\t\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);


		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		
		String bean_id					=		"MonthlySummaryReportBean";
		String bean_name				=		"eST.MonthlySummaryReportBean";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
				
		MonthlySummaryReportBean bean = (MonthlySummaryReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		String []stParameters=	{facility_id, "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
		String curr_proc_month =(String)hmRecord.get("CURR_PROC_MONTH");		
		String curr_proc_year  = com.ehis.util.DateUtils.convertDate((String)hmRecord.get("CURR_PROC_YEAR"),"YY","en",locale);
	    String LoginFacilityId			=		bean.getLoginFacilityId();
		
	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_proc_month));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_proc_year));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(curr_proc_month));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(curr_proc_year));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(curr_proc_month));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(curr_proc_year ));
            _bw.write(_wl_block20Bytes, _wl_block20);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
