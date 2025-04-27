package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __datagroupidselectmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DataGroupIdSelectMaster.jsp", 1709122321273L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/DataGroupId.js\" ></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\">\n\nfunction enblAddDetails(){\n\tdocument.forms[0].add_butt.disabled = false;\n\tdocument.forms[0].new_butt.disabled = true;\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n<form name=\"DatagroupId_setup_form\" id=\"DatagroupId_setup_form\" target=\'messageFrame\' method=\'post\' action=\'../../servlet/eXH.DataGroupIdAddModifyServlet\'>\n\n<table cellspacing=0 cellpadding=3 width=\'102%\' align=center>\n<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n</tr>\n\n\n<tr>\n<td class=label >Data</td> \n\n<td class=\'fields\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--\n<select class=\'select\' name=\'\"+name+\"\' id=\'\"+name+\"\'  \"+disabled+\"  onChange=\'onSelectMessageType(this)\'> -->\n<select class=\'select\' name=\'dg_code\' id=\'dg_code\' onChange=\'enblAddDetails();\' ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" >\n            <option value=\'\'>-------Select-------</option>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<option value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n            \n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n</select>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td> <td> </td></tr>\n\n<!--\n<tr>\n\t<td class=label ><fmt:message key=\"eXH.DataGroupCode.Label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/></td>\n\t<td align=left><input type=text name=dg_code size=10 value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  title=\'DataGroup Code\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" > <img src=\'../../eCommon/images/mandatory.gif\' align=middle>\n\t</td>\n\t<td> </td> <td> </td>\n</tr>\n\n<tr>\n\t<td class=label ><fmt:message key=\"eXH.DataGroupDesc.Label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/></td>\n\t<td align=left><input type=text name=dg_desc size=10 value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' > <img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n\t<td> </td> <td> </td>\n</tr>\n-->\n<tr><td colspan=4 class=\'BUTTON\'>\n<input class=\'button\' type=\"button\"  name=\'new_butt\' id=\'new_butt\' value=\'New Data Group\'\nonClick=\'funNew()\'>\n<!-- <fmt:message key=\"eXH.NewDataGroup.Label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/> --> \n<input class=\'button\' type=\"button\"  name=\'add_butt\' id=\'add_butt\' value=\'Add Details\'  disabled onClick=\'funAdd()\'>\n<!-- <fmt:message key=\"eXH.AddDetails.Label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/> -->\n<input class=\'button\' type=\"button\"  name=\'Search\' id=\'Search\' value=\'Search\' onClick=\'funSearch()\'>\n</td>\n</tr>\n\n<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n<input type=hidden name=act_mode value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=hidden name=detail_flag value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\n\n</form>\n\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 

String dg_code = "";
String dg_desc = "";
String selected = "selected";
String defaultval = "";

String mode=request.getParameter("mode");
String detail_flag=request.getParameter("detail_flag");

if(mode.equals("U"))
{
	dg_code=request.getParameter("dg_code");
	defaultval=request.getParameter("dg_code");
	dg_desc=request.getParameter("dg_desc");
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;


            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

try
{

con=ConnectionManager.getConnection();
//String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP WHERE //LANGUAGE_ID='"+locale+"' ORDER BY 2";
String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(mode.equals("U")?"readonly":""));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	while(rs.next())
            {     
			  if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
				 
				 
				 selected = "selected";
              }
              else
              {
                 selected = " ";
              }
				 
			


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(selected));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block11Bytes, _wl_block11);
 	}
            _bw.write(_wl_block12Bytes, _wl_block12);


}catch(Exception e1){
	System.out.println("(DataGroupIdSelectMaster.jsp:Exceptions)"+e1.toString());
	e1.printStackTrace(System.err);
}


            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(dg_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mode.equals("U")?"readonly":""));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dg_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);

		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(detail_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
