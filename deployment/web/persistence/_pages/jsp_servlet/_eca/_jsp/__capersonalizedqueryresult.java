package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __capersonalizedqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPersonalizedQueryResult.jsp", 1709115576136L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n\t\n\t<script language=javascript src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCA/js/CAPersonalizedHomePage.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n</HEAD>\n<BODY OnMouseDown=\"CodeArrest()\"  onKeyDown=\"lockKey()\">\n\t<form name=\"form1\" id=\"form1\"> \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script language =\"JavaScript\">\n\tvar chkVal = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n     if (chkVal == \"Pract\")\n   {\n\tparent.frame3.document.personalizedPractLookUpForm.look_up.disabled=false;\n\tcallfunction();\n   }else if (chkVal == \"Desk\")\n {\n\tparent.frame3.document.personalizedPractLookUpForm.look_up1.disabled=false;\n\tcallfunction1();\n }\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</form>\n</BODY>\n</HTML>\n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);


	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;	
	PreparedStatement ps = null;
	ResultSet rs = null;
try
{
	ConnectionManager connection = new ConnectionManager();
	con = connection.getConnection(request);
	String string = request.getParameter("pract_id") ;
	String name = request.getParameter("pract_name");
	String selFunVal = "";
	StringBuffer sql = new StringBuffer();
	selFunVal = request.getParameter("selFunVal")==null ? "" : request.getParameter("selFunVal");
		if(string != "*ALL" && name !="ALL")
		 {
			name = name + "%";
		 }

		if (selFunVal.equals("Pract")){
	
		if(sql.length() > 0) sql.delete(0,sql.length());
	    sql.append("SELECT PRACTITIONER_ID, PRACTITIONER_NAME  FROM ");
	    sql.append("AM_PRACTITIONER WHERE upper(PRACT_TYPE)=upper(?) AND "); sql.append("EFF_STATUS=? and upper(PRACTITIONER_NAME) like upper(?)");
			
		}
	  else if (selFunVal.equals("Desk")){

	    if(sql.length() > 0) sql.delete(0,sql.length());
	    sql.append("SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME  FROM ");
	    sql.append("SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_TYPE = 'C' AND EFF_STATUS='E' and upper(DESKTOP_SUMMARY_NAME) LIKE upper(?)"); 
	  }
	  ps=con.prepareStatement(sql.toString());

	  if (selFunVal.equals("Pract")){
				
					ps.setString(1,string);
	                ps.setString(2,"E");
	                ps.setString(3,name);		
			}
	else  if (selFunVal.equals("Desk")){
	                ps.setString(1,name);		
			}

	rs = ps.executeQuery();
	int count = 0;			
	while(rs.next())	
		{
			count++;
		}
	if(rs != null)	 rs.close();
	
	//	if(count==0)
//		{
//		out.println("<script>parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' </script>");
//		}
		if(count == 1)
		{
			rs = ps.executeQuery();
		  if (selFunVal.equals("Pract"))
		{
			while(rs.next())
		 {
			out.println("<script language = \"JavaScript\">");
			out.println("parent.frame3.document.personalizedPractLookUpForm.qry_sub.value='"+							rs.getString("PRACTITIONER_NAME")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.hid_sub.value='"+							rs.getString("PRACTITIONER_ID")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.flag.value='true' ");
			out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ");
			out.println("</script>");
		 }
		}
		 else if (selFunVal.equals("Desk"))
		{
			while(rs.next())
			{
				out.println("<script language = \"JavaScript\">");
			out.println("parent.frame3.document.personalizedPractLookUpForm.desk_sub.value='"+							rs.getString("DESKTOP_SUMMARY_NAME")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.hid_sub1.value='"+							rs.getString("DESKTOP_SUMMARY_ID")+"'" );
			out.println("parent.frame3.document.personalizedPractLookUpForm.flag.value='true' ");
			out.println("parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp' ");
			out.println("</script>");
			}
		}

	  }
	
		if(count > 1 || count==0)
		{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(selFunVal));
            _bw.write(_wl_block8Bytes, _wl_block8);

	}
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
        e.printStackTrace();//COMMON-ICN-0181
	try
	{
			con.rollback();
	}
	catch(Exception ee)
	{
	}
}
finally
{
	try
	{	
		if(rs != null)	 rs.close();
		if(ps != null)	 ps.close();
		if(con != null)ConnectionManager.returnConnection(con);	
			
	}
	catch(Exception ee)
	{
	}
	
}

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
