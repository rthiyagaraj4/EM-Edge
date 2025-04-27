package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;

public final class __interfacemodulequeryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/InterfaceModuleQueryResult.jsp", 1709122345741L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/DomainApplication.js\'></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/common.js\" ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"InterfaceModuleRslt\" id=\"InterfaceModuleRslt\" method=\"POST\" action=\'\'  >\n\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script>\nalert(getMessage(\'XH1021\'));\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<tr>\n\t<td colspan=\"4\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t</td>\n\t</tr>\n\n<tr>\n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>Interface Domain</td>\n\t<td class=\'COLUMNHEADER\'  width=\'25%\'>Description</td>\n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>Sub Domain</td>\n\t<td class=\'COLUMNHEADER\'  width=\'25%\'>Description</td>\n\t\t\n</tr>\n\n\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<tr>\n\t<td style=\'cursor:pointer\' ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" align=\"left\" >\n\t<a href=\'#\' onClick=\'funModify(this)\' module_Id=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'\n\tmodule_Name=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' sub_module_id=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'\n\tsub_module_desc=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</a>\n\t</b>\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" align=\"left\"> \n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</table>\n\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'U\' >\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'module_Id\' id=\'module_Id\' value=\'\'>\n\t<input type=\'hidden\' name=\'module_Name\' id=\'module_Name\' value=\'\'>\n\t<input type=\'hidden\' name=\'sub_module_id\' id=\'sub_module_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'sub_module_desc\' id=\'sub_module_desc\' value=\'\'>\n\n</form>\n</html>\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);


			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "INTERFACEMODULE";
			Connection conn = null;


			try
			{
				
				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				request.setAttribute(XHQueryRender.col,"4");
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = "Previous";
				String strNext  = "Next";
				if (boolPrevious == true)
				{
					strPrevious = "Previous";
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = "Next";
				}
				else
				{
					strNext  = " ";
				}
		
            _bw.write(_wl_block5Bytes, _wl_block5);

if(arrRow.size()==0)
{

            _bw.write(_wl_block6Bytes, _wl_block6);
 } else { 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block9Bytes, _wl_block9);

	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(arrCol.get(1)+""));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(arrCol.get(2)+""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arrCol.get(3)+""));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrCol.get(0)+""));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(""+arrCol.get(1) ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(""+arrCol.get(2) ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(""+arrCol.get(3) ));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	
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
