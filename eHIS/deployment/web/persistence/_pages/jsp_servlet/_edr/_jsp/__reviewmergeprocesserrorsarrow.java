package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __reviewmergeprocesserrorsarrow extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/ReviewMergeProcessErrorsArrow.jsp", 1709116657745L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eDR/js/ReviewMergeProcessErrors.js\'></script>\n\t<script language=\'javascript\' src=\'../../eDR/js/DuplicateRecord.js\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/rowcolor.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n\t<Script language=\"JavaScript\" src=\"../../eCommon/js/common.js\" ></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<form name=\'group_header_image\' id=\'group_header_image\'>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' height=\'100%\' width=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t<input type=\'hidden\' name=\"CheckBoxes\" id=\"CheckBoxes\" value=\"\">\n\t\t   <input type=\'hidden\' name=\"selAll\" id=\"selAll\" value=\"\">\n\t\t   <input type=\'hidden\' name=\"dup_group_id\" id=\"dup_group_id\" value=\'\'>\n\t\t   <input type=\'hidden\' name=\'chkedVls\' id=\'chkedVls\' value=\'\'>\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t<br><br>\n\t\t\t\t</form>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
	String sStyle	=
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String p_patient_id		= "";
	String class_value		= "";
	String sql				= "";
	String strsql1			= "";

	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();
		if((whereClause == null || whereClause.equals("")))
		{
			sql						= "";
			p_patient_id			= request.getParameter("patient_id");

			if(p_patient_id == null) p_patient_id = "";

			sql = "WHERE dup_indicator = 'V' AND group_status = 'E' ";
		}
         else
		{
			sql = whereClause;
		}
		
		int start	= 0 ;
		int end		= 0 ;
	
		if(from == null) start = 1 ;
		else start = Integer.parseInt( from ) ;

		if(to == null) end = 9 ;
		else end = Integer.parseInt( to ) ;
		
		int maxRecord = 0;
		strsql1 = "SELECT count(1) AS total FROM dr_dup_group_vw2 "+sql;
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		if(rs != null) rs.close();

		boolean printprevious = false;
		
		if(maxRecord<23)
		{
			class_value="white";
		}
		else
		{
			class_value = "label";
		}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

						if(!(start <= 1))
						{
							//whereClause =URLEncoder.encode(sql);
							//whereClause =sql;
							out.println("<A HREF='../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp?from="+(start-9)+"&to="+(end-9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/uparrow.gif' WIDTH='18' HEIGHT='18' BORDER=0 ALT='' onClick=javascript:callDupFunction("+(start-9)+","+(end-9)+",'"+URLEncoder.encode(sql)+"')></IMG></A>");
							out.println("<BR>");
							printprevious = true;
						}
						if(printprevious)
						{
							for (int x=0; x<21; x++)
							out.println("<BR>");
						}
						else
						{
							for (int x=0; x<23; x++)
							out.println("<BR>");
						}
					      if ( !( (start+9) > maxRecord ))
						{
							//whereClause = URLEncoder.encode(sql);
							//whereClause =sql;
							out.println("<A HREF='../../eDR/jsp/ReviewMergeProcessErrorsArrow.jsp?from="+(start+9)+"&to="+(end+9)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><IMG ALIGN='CENTER' SRC='../../eDR/images/downarrow.gif' WIDTH='18' HEIGHT='18' BORDER='0' ALT='' onClick=javascript:callDupFunction("+(start+9)+","+(end+9)+",'"+URLEncoder.encode(sql)+"')></IMG></A>");
						}
						else
						{
							out.println("<BR><BR>");
						}
						
            _bw.write(_wl_block9Bytes, _wl_block9);
	
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exfception e :"+e.toString());
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
		
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
