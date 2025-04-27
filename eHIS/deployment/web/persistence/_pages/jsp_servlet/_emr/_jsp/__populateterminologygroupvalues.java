package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __populateterminologygroupvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/populateTerminologyGroupValues.jsp", 1709119008051L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'Javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body CLASS=\"MESSAGE\" onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<script>\n\t\t\t\t\t\tvar obj = parent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set;\n\t\t\t\t\t\tvar length  = obj.length;\n\t\t\t\t\t\tfor(i=0;i<length;i++)\n\t\t\t\t\t\t\tobj.remove(0); \n\t\t\t\t\t\tvar term_set_opt = parent.f_query_add_mod.document.createElement(\'OPTION\');\n\t\t\t\t\t\t\tterm_set_opt.text = \'--- \'+getLabel(\'Common.defaultSelect.label\',\'Common\')+\' ---\';\n\t\t\t\t\t\t\tterm_set_opt.value = \"\";\n\t\t\t\t\t\t\tparent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set.add(term_set_opt);\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<form name=Dynamic_form>\n\t\t\t<input type=\'hidden\' name=\'isSelect\' id=\'isSelect\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t\t</form>\n</body>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	StringBuffer selectsql	= new StringBuffer();
	Connection con	= null;
	PreparedStatement pstmt =null;
	ResultSet rs	= null;
	RecordSet PractitionerSpeciality = null;//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
	try
	{	
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);	

		String term_grp_id		= checkForNull(request.getParameter("term_grp_id"));
		String function_type	= checkForNull(request.getParameter("clearAll"));
		String index_type	= checkForNull(request.getParameter("index_type"));
		//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
		String searchval	= checkForNull(request.getParameter("searchval"));
		String indexdesc	= checkForNull(request.getParameter("indexdesc"));
		
		
		if(function_type!=null && function_type.equals("clearAll"))
		{
			 PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			PractitionerSpeciality.clearAll();
		}
		else if(function_type!=null && function_type.equals("notCleared"))
		{
			 PractitionerSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractitionerSpeciality");
			PractitionerSpeciality.clearAll();
			if(index_type!=null && index_type.equals("P"))
			{
				selectsql.append("select PRACTITIONER_ID,PRACTITIONER_NAME from AM_PRACTITIONER ");
				if(searchval!=null && searchval.equals("S"))
					selectsql.append(" where Upper(PRACTITIONER_NAME) like Upper('"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("C"))
					selectsql.append("where Upper(PRACTITIONER_NAME) like Upper('%"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("E"))
					selectsql.append("where Upper(PRACTITIONER_NAME) like Upper('%"+indexdesc+"')");
				selectsql.append(" order by PRACTITIONER_NAME ");
			}	
			else if(index_type!=null && index_type.equals("S"))
			{
				selectsql.append("select SPECIALITY_CODE,SHORT_DESC from AM_SPECIALITY");
				if(searchval!=null && searchval.equals("S"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("C"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('%"+indexdesc+"%')");
				else if(searchval!=null && searchval.equals("E"))
					selectsql.append(" where Upper(SHORT_DESC) like Upper('%"+indexdesc+"')");
				selectsql.append(" order by SHORT_DESC ");
			}
			
			pstmt = con.prepareStatement(selectsql.toString());
			rs = pstmt.executeQuery();

			while(rs!=null && rs.next())
			{
				PractitionerSpeciality.putObject(rs.getString(1));
			}

			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();

		}
		else
		{	
			selectsql.append("  select term_set_id from mr_term_group_hdr  WHERE   eff_status='E'  AND   term_group_id=?");
			pstmt = con.prepareStatement(selectsql.toString());
			pstmt.setString(1,term_grp_id);
			rs = pstmt.executeQuery();
			
            _bw.write(_wl_block8Bytes, _wl_block8);

					String innertext ="";
					while( rs!=null && rs.next() ) 
					{
						innertext = rs.getString( "term_set_id" ) ;
						out.println(	"<script> var element = parent.f_query_add_mod.document.createElement('OPTION');"+
						"element.text = \""+innertext+"\";"+ 
						"element.value= \""+innertext+"\";"+
						"element.selected=true;"+
						"parent.f_query_add_mod.document.addModifyCustomListTerminologyGroupAddModify.term_set.add(element);</script>");
					}
					if (rs != null) rs.close();
					if (pstmt != null) pstmt.close();
		}

		
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_type));
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	catch(Exception e)
	{
		/* out.println("<script>alert('exception is coming here');</script>");
		out.println("Exception in populateTerminologyGroupValues jsp page : "+ e.toString()); */
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
		//Modified against ARYU-SCF-0115 by Shanmukh on 6th-Mar-2018
		session.setAttribute("PractitionerSpeciality", PractitionerSpeciality);
	}
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
