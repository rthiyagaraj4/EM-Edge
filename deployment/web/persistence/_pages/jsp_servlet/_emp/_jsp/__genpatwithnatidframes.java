package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;

public final class __genpatwithnatidframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/genPatWithNatIdFrames.jsp", 1709623442884L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<title></title>\n    <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>   \n\t<script language=\'javascript\' src=\'../../eMP/js/genPatWithNatIdCreate.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'    src=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\'   src=\'../../eMP/jsp/genPatWithNatIdCreate.jsp?patient_id_length=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nat_id_prompt=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nat_id_accept_alphanumeric_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nat_id_check_digit_id=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nat_id_length=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&invoke_routine=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&invoke_routine_name=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nat_id_chk_len=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\n\t\t\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'      src=\'../../eCommon/jsp/error.jsp?\' frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\n\t\t\t\n\t\t\t ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t <script>\n\t\t\t\t\t\tvar ErrorMessage= getMessage(\'WITH_NATIONAL_ID_NOT_CONFIGURED\',\'MP\'); \n\t\t\t\t\t\talert(ErrorMessage);\t\n\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar ErrorMessage= getMessage(\'NATIONAL_ID_NOT_CONFIGURED\',\'MP\'); \n\t\t\t\t\t\talert(ErrorMessage);\t\n\t\t\t\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t\t\t\t\t</script>\n\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block5Bytes, _wl_block5);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
		request.setCharacterEncoding("UTF-8");
		String params = request.getQueryString() ;
        String source = url + params ;
		String facilityId = (String) session.getValue("facility_id");
		String locale			= (String)session.getAttribute("LOCALE");
        Connection con = ConnectionManager.getConnection(request);
		
        try  {
			HashMap ResultParamHashMap = new HashMap();
			HashMap sqlColumns = new HashMap();
			sqlColumns.put("patient_id_length","S");
			sqlColumns.put("nat_id_prompt","S");
			sqlColumns.put("nat_id_accept_alphanumeric_yn","S");
			sqlColumns.put("accept_national_id_no_yn","S");
			sqlColumns.put("nat_id_check_digit_id","S");
			sqlColumns.put("nat_id_length","S");
			sqlColumns.put("invoke_routine","S");
			sqlColumns.put("nat_data_source_id","S");
			sqlColumns.put("nat_id_pat_ser_grp","S");
			sqlColumns.put("nat_id_chk_len","S");
			String whereClause	= "where module_id='MP'";
			ResultParamHashMap = CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PARAM",con);
			String patient_id_length				 = (String) ResultParamHashMap.get("patient_id_length");
			String nat_id_prompt					 = (String) ResultParamHashMap.get("nat_id_prompt");
			String nat_id_accept_alphanumeric_yn	 = (String) ResultParamHashMap.get("nat_id_accept_alphanumeric_yn");
			String accept_national_id_no_yn			 = (String) ResultParamHashMap.get("accept_national_id_no_yn");
			String invoke_routine					 = (String) ResultParamHashMap.get("invoke_routine");
			String invoke_routine_name				 = (String) ResultParamHashMap.get("nat_data_source_id");
			String nat_id_check_digit_id			 = (String) ResultParamHashMap.get("nat_id_check_digit_id");
			String nat_id_pat_ser_grp				 = (String) ResultParamHashMap.get("nat_id_pat_ser_grp");
			String nat_id_chk_len					 = (String) ResultParamHashMap.get("nat_id_chk_len");

	
			String nat_id_length					 = (String) ResultParamHashMap.get("nat_id_length");
			nat_id_prompt							 = (nat_id_prompt==null || nat_id_prompt.equals("")?"National Id No":nat_id_prompt);

			invoke_routine							 = (invoke_routine==null || invoke_routine.equals("")?"N":invoke_routine);
			invoke_routine_name						 = (invoke_routine_name==null || invoke_routine_name.equals("")?"":invoke_routine_name);
			nat_id_check_digit_id					 = (nat_id_check_digit_id==null || nat_id_check_digit_id.equals("")?"":nat_id_check_digit_id);
			nat_id_pat_ser_grp						 = (nat_id_pat_ser_grp==null || nat_id_pat_ser_grp.equals("")?"":nat_id_pat_ser_grp);
			nat_id_chk_len							 = (nat_id_chk_len==null || nat_id_chk_len.equals("")?"N":nat_id_chk_len);
		
			
			sqlColumns.clear();
			ResultParamHashMap.clear();
			if(accept_national_id_no_yn.equals("Y")){
				if(!nat_id_pat_ser_grp.equals("")){
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id_length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLEncoder.encode(nat_id_prompt)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(nat_id_accept_alphanumeric_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(nat_id_check_digit_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(nat_id_length));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(invoke_routine));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(invoke_routine_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nat_id_chk_len));
            _bw.write(_wl_block17Bytes, _wl_block17);

				}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
	}
			}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            
        } catch(Exception e ){
			out.println(e);e.printStackTrace();
		} finally {
            if(con!=null) ConnectionManager.returnConnection(con,request);
        }
 
            _bw.write(_wl_block20Bytes, _wl_block20);
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
