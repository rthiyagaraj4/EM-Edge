package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __quicklinksforrespcustomize extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/QuickLinksForRespCustomize.jsp", 1709881382084L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t<script src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\'></script>\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n    \n</head>\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<iframe name=\"detailFrame\" id=\"detailFrame\" SRC=\"../../eCA/jsp/QuickLinksForRespCustomizeDtl.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" scrolling=\"no\" frameborder=\"no\"  noresize style=\"height:90vh;width:100vw\"></iframe>\n\t\t<iframe name=\"messageFrame\" id=\"messageFrame\" frameborder=\"no\" scrolling=\"no\" noresize src=\"../../eCommon/jsp/error.jsp\" style=\"height:10vh;width:100vw\"></iframe> \n\t\t\n\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounterId = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	webbeans.eCommon.RecordSet CustomizeResp = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeResp"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session);
	webbeans.eCommon.RecordSet CustomizeRespDef = (webbeans.eCommon.RecordSet)getObjectFromBean("CustomizeRespDef"+patient_id+encounterId,"webbeans.eCommon.RecordSet",session); 



            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");

	//String practitioner_id	= (String) session.getValue("ca_practitioner_id");
	String respid = (String) session.getValue("responsibility_id");
	String userId=((String) session.getValue("login_user")).trim();

	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

	String prev_notes_called_from = request.getParameter("prev_notes_called_from") == null ? "" : request.getParameter("prev_notes_called_from");

	if(!prev_notes_called_from.equals("") && prev_notes_called_from.equals("PREVIOUS_NOTES"))
		function_id = prev_notes_called_from;

	

	String link_type = request.getParameter("link_type") == null ? "" : request.getParameter("link_type");
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;

	String occurance = request.getParameter("occurance");

	
	if(occurance == null) {
			occurance = "";
			CustomizeResp.clearAll();
			CustomizeRespDef.clearAll();
		}

	try
	{
		con = ConnectionManager.getConnection(request);
		String ql_ref	= "";
		String checkStatus  = "";
		String default_yn  = "";
		StringBuffer sql = new StringBuffer();
		
		//sql.append("select a.QUICK_LINK_REF, NVL((select 'Y' from SM_QUICK_LINK_RESP where QUICK_LINK_REF = a.QUICK_LINK_REF and RESP_ID = ?),'N') checked  from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
		
		/*sql.append("select a.QUICK_LINK_REF, NVL((select 'Y' from SM_QUICK_LINK_FOR_USER where QUICK_LINK_REF = a.QUICK_LINK_REF and LINK_TYPE = ? and APPL_USER_ID =?),'N') checked from SM_QUICK_LINK_LIST a where a.EFF_STATUS = 'E' ");
						
		if(!link_type.equals("F"))
			sql.append(" and a.FUNCTION_SPEC_YN='Y' ");
		else if(!link_type.equals("Q"))
			sql.append(" and a.GLOBAL_YN = 'Y' ");
		
		

		*/

		sql.append("SELECT A.QUICK_LINK_REF , nvl2(c.QUICK_LINK_REF,'Y','N') checked_yn,NVL(C.DEFAULT_YN,'N') DEFAULT_YN");

		sql.append(" FROM SM_QUICK_LINK_LIST_LANG_VW A,SM_QUICK_LINK_RESP B,SM_QUICK_LINK_FOR_USER c WHERE  a.LANGUAGE_ID = '"+locale+"' and B.RESP_ID=? AND A.QUICK_LINK_REF =B.QUICK_LINK_REF and c.APPL_USER_ID(+)=? AND c.LINK_TYPE(+) =?  AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF "); // AND c.QUICK_LINK_REF(+) =A.QUICK_LINK_REF

		if(link_type.equals("Q"))
			sql.append(" AND A.GLOBAL_YN='Y'");
		else if(link_type.equals("F"))
			sql.append(" AND A.FUNCTION_SPEC_YN ='Y' AND A.OPTION_ID=?");

		


		pstmt = con.prepareStatement(sql.toString());
		pstmt.setString(1,respid);
		pstmt.setString(2,userId);
		pstmt.setString(3,link_type);
		if(link_type.equals("F"))
		pstmt.setString(4,function_id);
		
		
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			ql_ref = rs.getString("QUICK_LINK_REF")==null?"":rs.getString("QUICK_LINK_REF");
			
			checkStatus = rs.getString("checked_yn")==null?"":rs.getString("checked_yn");
			default_yn = rs.getString("DEFAULT_YN")==null?"":rs.getString("DEFAULT_YN");
			
						
			if(checkStatus.equals("Y"))
			{
				if(!(CustomizeResp.containsObject(ql_ref))){
					CustomizeResp.putObject(ql_ref);
				}
			}

			if(default_yn.equals("Y"))
			{
				if(!(CustomizeRespDef.containsObject(ql_ref))){
					CustomizeRespDef.putObject(ql_ref);
				}
			}

		}
		
		putObjectInBean("CustomizeResp"+patient_id+encounterId, CustomizeResp,session);
		putObjectInBean("CustomizeRespDef"+patient_id+encounterId, CustomizeRespDef,session);
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}finally{
		try {
			if (con !=null)ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.QuickLinkForResponsibility.label", java.lang.String .class,"key"));
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
