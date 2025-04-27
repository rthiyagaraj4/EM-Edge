package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __tasklistcalendarintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/TaskListCalendarIntermediate.jsp", 1709116388136L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCA/js/TaskList.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script>\t\nparent.TaskListCalendarFrameTop.document.TaskListTopForm.currentDate.value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\nparent.TaskListCalendarFrameTop.document.TaskListTopForm.currDate.value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\nparent.TaskListCalendarFrameTop.document.getElementById(\"systemDate\").innerText=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";//Added for IN071765\nvar queryString =parent.TaskListCalendarFrameTop.document.TaskListTopForm.queryString.value\t\n//parent.TaskListCalendarFrameBottom.location.href=\'../../eCA/jsp/TaskListCalendarBottom.jsp?\'+queryString+\'&currentDate=\'+\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';//Commented for IN071765\nparent.TaskListCalendarFrameBottom.location.href=\'../../eCA/jsp/TaskListCalendarBottom.jsp?\'+queryString+\'&currentDate=\'+\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\';//Added for IN071765\n</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

/*
------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------
?             	100            		?           	?				?					created 
20/08/2015    	IN056958		 	Karthi L		      								Login Thai. After select order and record order already. In Task list function, system display error message.	
18/11/2015		IN071765			Nijitha S		18/11/2020      Ramesh G					Calendar (DateTime Picker) in task list shows incorrect year format with error.
------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
		String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	try
	{
		String flagString = request.getParameter("flag")==null ? "" : request.getParameter("flag");
		String currDate =  request.getParameter("currdateValue")==null ? "" : request.getParameter("currdateValue");
		String locale = (String)session.getAttribute("LOCALE"); //SRR20056-SCF-9390-IN037479_RF [IN056958]
		currDate = com.ehis.util.DateUtils.convertDate(currDate,"DMY",locale,"en");  //SRR20056-SCF-9390-IN037479_RF [IN056958]
		
		con= ConnectionManager.getConnection(request);
			String sql  = "";
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		if(flagString.equals("PrevMonth"))//IN071765 Starts
		//sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),-1),'dd/mm/yyyy') from dual	";
		sql = "select sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),-1),'Month YYYY',?),sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),-1),'dd/mm/yyyy',?) from dual	";
		else
		//sql = "select to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'Month YYYY'),to_char(add_months(to_date(?,'dd/mm/yyyy'),1),'dd/mm/yyyy') from dual ";
		sql = "select sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),1),'Month yyyy',?) ,sm_convert_date_anyformat(add_months(to_date(?,'dd/mm/yyyy'),1),'dd/mm/yyyy',?) from dual ";
		//IN071765 Ends
		String currentDate = "";
		pstmt = con.prepareStatement(sql);
		//IN071765 Starts
		//pstmt.setString(1,currDate);
		//pstmt.setString(2,currDate);
		pstmt.setString(1,currDate);
		pstmt.setString(2,locale);
		pstmt.setString(3,currDate);	
		pstmt.setString(4,locale);
		//IN071765 Ends
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			currentDate= rs.getString(1)==null ? "" :  rs.getString(1);
			currDate = rs.getString(2)==null ? "" :  rs.getString(2);

		}		
		if(rs !=null)  rs.close();
		if(pstmt != null)pstmt.close();

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(currentDate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(currDate,"DMY",localeName,"en")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(currDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

}
catch(Exception ee)
{
	//out.println("Error from TaskListCalendarIntermediate jsp :"+ee.toString());//COMMON-ICN-0181
          ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
