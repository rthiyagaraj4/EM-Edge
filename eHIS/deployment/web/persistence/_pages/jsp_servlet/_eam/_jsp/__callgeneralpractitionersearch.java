package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;

public final class __callgeneralpractitionersearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/callGeneralPractitionerSearch.jsp", 1736778397069L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\nasync function practSearch(){\n\n\tvar retVal = \tnew String();\n\tvar dialogTop = \"0vh\" ;\n\tvar dialogHeight= \"92vh\" ;\n\tvar dialogWidth\t= \"97vw\" ;\n\t/*Below line added for this CRF ML-MMOH-CRF-0862*/\n\tif(\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\" ==\"true\") {        \t\n\t    dialogWidth=\"97vw\";\n\t}\n\t\n\tvar status = \"no\";\n\tvar arguments\t= \"\" ;\n\tvar tit=\"Pract Search\";\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no; status:\" + status;\n\t\n\tvar sqlArray= new Array();\n\tvar objName=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t   arguments=\'\';\n\t\n\tretVal = await window.showModalDialog(\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eAM/jsp/GeneralPractitionerSearch.jsp?pract_name=\"+\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"+\"&practitioner_type=\"+\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"+\"&primary_specialty=\"+\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"+\"&job_title=\"+\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"+\"&gender=\"+\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"+\"&title=\"+getLabel(\'Common.practitioner.label\',\'Common\'),arguments,features);\n\tPractLookupRetVal(retVal,objName);\n}\npractSearch();\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

    request.setCharacterEncoding("UTF-8");
	//String tel_no="";
	//String mobile_no="";
	//String pager_no="";
	//String job_title_pract_dtls="";
	//String pract_type="";
	//String pract_type_desc="";

/////////////////////////////////////////////////////////////
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	String  practName_FValue = (String) hash.get("practName_FValue")==null?"":(String) hash.get("practName_FValue") ;
	String  practName_FName = (String) hash.get("practName_FName")==null?"":(String) hash.get("practName_FName") ;
	


	String  sql = (String) hash.get("sql")==null?"":(String) hash.get("sql");
	sql = java.net.URLDecoder.decode(sql,"UTF-8");
		session.putValue("sql",sql);

	String  sqlSec = (String) hash.get("sqlSec")==null?"":(String) hash.get("sqlSec") ;
	sqlSec = java.net.URLDecoder.decode(sqlSec,"UTF-8");
	session.putValue("sqlSec",sqlSec);

	String  practitioner_type = (String) hash.get("practitioner_type")==null?"":(String) hash.get("practitioner_type");

	String  specialty_code = (String) hash.get("specialty_code")==null?"":(String) hash.get("specialty_code") ;
	String  job_title = (String) hash.get("job_title")==null?"": (String) hash.get("job_title");
	String  gender = (String) hash.get("gender")==null?"":(String) hash.get("gender");	

	hash.clear();

 	//Added for this CRF ML-MMOH-CRF-0862
  	boolean cernerIdSiteSpecific = false;
  	Connection conn=null;
 	try{
	  conn=ConnectionManager.getConnection(request);
	  cernerIdSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM","CERNER_PRACTITIONER_ID");
 	}catch(Exception ex){
  		ex.printStackTrace();
 	}finally{ 
		if (conn != null) ConnectionManager.returnConnection(conn,request);
	}
 	//End this CRF ML-MMMOH-CRF-0862

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(cernerIdSiteSpecific));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(practName_FName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(practName_FValue));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(specialty_code));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(job_title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
