package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmcheckfilenumber extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMCheckFileNumber.jsp", 1709116830310L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tDeveloped by \t\t:\tPrakash.S\n\tModule\t\t\t\t:\teFM (File Management)\n\tFunction\t\t\t:\tTO Validate the Entered File number\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
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
	Connection con =null;
	Statement stmt=null; 
	ResultSet rs=null;
	String file_no 	= 	"", sql="", curr_file_status="", facility_id="", return_date_time="";
	String iss_date_time = 	"";
	int total=0;
	String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	try
	{
		con			=	webbeans.eCommon.ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		stmt = con.createStatement();
		file_no = 	request.getParameter("file_no");
		if(file_no == null) file_no="";
		if(!(file_no.equals("")))
		{
			sql="Select count(*) as total, return_date_time, iss_date_time, curr_file_status from fm_curr_locn where file_no='"+file_no+"' and facility_id='"+facility_id+"' group by return_date_time, iss_date_time, curr_file_status";

			try
			{
				rs = stmt.executeQuery(sql);
				if ((rs.next()))
				{
					return_date_time	=	rs.getString("return_date_time");
					iss_date_time		=	rs.getString("iss_date_time");
					curr_file_status	=	rs.getString("curr_file_status");
					total				=	rs.getInt("total");
				}

				if(return_date_time == null) return_date_time="";
				if(iss_date_time == null) iss_date_time="";
				if(curr_file_status == null) curr_file_status="";
	

				out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown = 'lockKey()'>");
			//	out.println("<script language=\"javascript\" src=\"../../eFM/js/eFMmessages.js\"></script>");

				if(total != 0)
				{
					if((return_date_time.equals(""))&&(iss_date_time.equals("")))
					{
						out.println("<script>");
						out.println("var msg=getMessage(\"FILE_IN_PERM_LOC\",\"FM\");");
						out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
						out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
						out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
						out.println("</script>");
					}
					else
					{
						if(!(curr_file_status.equals("")))
						{
							if(curr_file_status.equals("L"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"RETURN_DATE_NOT_CHANGED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");
							}
							else if(curr_file_status.equals("T"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"FILE_IN_TRANSIT_CANNOT_PROCEED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");
								
							}
							else if(curr_file_status.equals("A"))
							{
								out.println("<script>");
								out.println("var msg=getMessage(\"RETURN_DATE_ARCHIVED\",\"FM\");");
								out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
								out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
								out.println("</script>");

							}
						}
					}
				}
				else
				{
					out.println("<script>");
					out.println("var msg=getMessage(\"FILE_NOT_EXIST\",\"FM\");");
					out.println("parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+msg;");
					out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.focus();");
					out.println("parent.frames[1].FMChFileRetDateCriteriaFrame.document.forms[0].file_no.select();");
					out.println("</script>");

				}
				
			}
			catch(Exception e1)
			{
				out.println(e1);
			}
			
		}
		out.println("</script></body>");
	if (rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>");
	}
	finally
	{		
		webbeans.eCommon.ConnectionManager.returnConnection(con,request);
	}

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
