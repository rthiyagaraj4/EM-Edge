package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.HashMap;
import com.ehis.eslp.*;
import java.net.*;

public final class __staffrequirementheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/StaffRequirementHeader.jsp", 1709116620761L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>      \t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n      \t<script language=\'javascript\' src=\'../../eCommon/js/common.js\' ></script>\t\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/messages.js\' ></script>\n\t\t<script language=\"javascript\" src=\"../js/CpMessages.js\"></script>  \n\t\t\t  <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCP/js/StaffRequirement.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t<script>\n\t\tfunction hello(form)\n\t  {\n\t\n\t\t\tvar a=document.forms[0].workplace_code.value;\n\t\t\n\t\t\t\t\tremoveitems(form.shift_code);\n\t\n\t\t\tvar HTMLVal = \"<HTML><HEAD><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link></HEAD><BODY CLASS=\'MESSAGE\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"<form name=\'form1\' id=\'form1\' method=\'post\' action=\'../../eCP/jsp/StaffRequirementIntermediate.jsp\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"<input name=\'workplace_code\' id=\'workplace_code\' type=\'hidden\' value= \'\"+a +\"\'>\";\n\t\t\t\t\tHTMLVal = HTMLVal +\"</form></BODY></HTML>\";\n\t\t\t\t\tparent.parent.messageFrame.document.write(HTMLVal);\n\t\t\t\t\tparent.parent.messageFrame.document.forms[0].submit();\n\n\t  }\n\n\n\n\t\tfunction removeitems(obj)\n\t\t\t{\n\t\t\t\tvar len=obj.length;\n\t\t\t\tvar i=1;\n\t\t\t\twhile(i<len)\n\t\t\t\t{\n\t\t\t\t\tlen=obj.length\n\t\t\t\t\tobj.remove(i)\n\t\t\t\t}\n\t\t\t}\n\n\n\t\t\n\t\t\n\n\t\t</script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<body  onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<form name=form_add_mod>\n\t\t<table border=\'0\' cellspacing=\'0\' cellpadding=\'0\' align=\'center\' width=\'98%\'>\n\t\t\t<tr>\n\t\t\t\t<td align=\'right\' class=\'label\'><fmt:message key=\"Common.Dependency.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></td>\n\t\t\t\t<td align=\"left\" colspan=\"5\">&nbsp;&nbsp;\n\t\t\t\t\t<select name=\'dependency_code\' id=\'dependency_code\'>\n\t\t\t\t\t\t<option value=\'\'>------<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>------</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t</select>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t <tr>\n\t\t\t\t<td  align=right class=\"label\"><fmt:message key=\"Common.Workplace.label\" bundle=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/></td>\n\t\t\t\t<td align=\'left\' colspan=\"5\"> &nbsp;&nbsp;\n\t\t\t\t\t<input type=text name=\"workplace_desc\" id=\"workplace_desc\" value=\"\" size=\'30\' maxlength=\'30\'  onblur=\'hello(this.form)\'  readonly><input class=\'button\' type=button name=\"workplace_button\" id=\"workplace_button\" value=\"?\"  onClick=\'viewAgeGroup1(workplace_desc,facility_id);hello(this.form)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t\t\t<input type=\"hidden\" name=\"workplace_code\" id=\"workplace_code\" value=\"\" >\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t <tr>\n\t\t\t\t<td align=\'right\' class=\'label\'><fmt:message key=\"Common.SHIFT.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/></td>\n\t\t\t\t<td align=\"left\">&nbsp;&nbsp;\n\t\t\t\t\t<select name=\'shift_code\' id=\'shift_code\' onChange=\'ChangeType(this.form,this);display(start_time,end_time)\'>\n\t\t\t\t\t\t<option value=\'\'>------<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>------</option>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"start_time1\" id=\"start_time1\" value=\"\">\n\t\t\t\t\t<input type=\"hidden\" name=\"end_time1\" id=\"end_time1\" value=\"\" >\n\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t\t<td align=\"right\" class=\"label\"><fmt:message key=\"Common.StartTime.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/></td>\n\t\t\t\t<td align=\"left\"  id=\'start_time\' class=\"data\"><B></B></td>\n\t\t\t\t<td align=\"right\" class=\"label\" class=\"data\"><fmt:message key=\"Common.EndTime.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/></td>\n\t\t\t\t<td align=\"left\" id=\'end_time\' class=\"data\"><B></B></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td colspan=\"6\" align=\"right\"><input type=button class=button value=\'<fmt:message key=\"Common.search.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\' onclick=\'searchDetails()\'></td>\n\t\t\t</tr>\n\n\t\t</table>\n\n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t\n\t</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

String dependency_sql="";
Vector dependency_list=new Vector();
Connection conn=null;
Statement dependency_stmt=null;
ResultSet dependency_rs=null;
String facility_id=(String)session.getValue("facility_id");

try
{
	
conn=ConnectionManager.getConnection();

dependency_sql="Select dependency_code,long_desc from cp_dependency where eff_status='E' order by long_desc";
dependency_stmt=conn.createStatement();
dependency_rs=dependency_stmt.executeQuery(dependency_sql);
while(dependency_rs.next())
	{
	
		dependency_list.add(dependency_rs.getString("dependency_code"));
		dependency_list.add(dependency_rs.getString("long_desc"));
	}



}catch(Exception e)
{
	e.printStackTrace();
	throw e;
}
finally
{
	if(dependency_rs!=null) dependency_rs.close();
	if(dependency_stmt!=null) dependency_stmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
for(int i=0;i<dependency_list.size();i+=2)
						{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(dependency_list.get(i)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( (String)dependency_list.get(i+1)));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
