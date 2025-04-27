package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __recordtrans1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/RecordTrans1.jsp", 1709121714963L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction fetchVals1()\n{\n\tvar Obj=document.forms[0].tableid;\n\n\tif(Obj.value !=\'\')\n\t{\n\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\tparent.document.frames[1].document.location.href=\'../../eSM/jsp/RecordTransTitle.jsp?tableid=\'+parent.document.frames[0].document.forms[0].tableid.value;\n\tparent.document.frames[2].document.location.href=\'../../eSM/jsp/RecordTransResult.jsp?tableid=\'+parent.document.frames[0].document.forms[0].tableid.value+\"&moduled_id=\"+parent.document.frames[0].document.forms[0].module_id.value+\"&criteria_String=\"+document.forms[0].criteria.value;\n\t\n\t}\n\telse\n\t{\n\tvar  error = getMessage(\"CAN_NOT_BE_BLANK\",\'Common\');\n\terror = error.replace(\"$\",getLabel(\'Common.defaultSelect.label\',\'Common\'))\n\talert(error);\n\tdocument.forms[0].tableid.focus();\n\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\tparent.document.frames[1].document.location.href=\'../../eCommon/html/blank.html\';\n\tparent.document.frames[2].document.location.href=\'../../eCommon/html/blank.html\';\n\t\n\t\n\t}\n}\n</script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<body  onLoad=\"FocusFirstElement()\"  onKeyDown = \'lockKey()\'; OnMouseDown=\"CodeArrest()\">\n\t\t<form name=\'RecordTransForm1\' id=\'RecordTransForm1\'  target=\'messageFrame\'>\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr><td colspan=\'5\'>&nbsp;</td></tr>\t    \t\t\n\t\t<tr>\n    \t\t\t\t     <td  class=\'label\'><fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></td>\n    \t\t\t\t     <td>&nbsp;&nbsp;<select name=\'tableid\' id=\'tableid\' >\n    \t\t\t\t     <option value=\'\'>----------<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>---------</option>\n    \t\t\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    \t\t\t\t     </select>&nbsp<img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n    \t\t\t\t   </td><td class = label><fmt:message key=\"Common.description.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>\n    \t\t\t\t    <td>&nbsp;&nbsp;<input type = text name = criteria value = \'\' maxlength = 60 size= 30>\n\t\t\t\t\t\t<input type = button class = button value = \'Select\' onClick=fetchVals1()>\n    \t\t\t\t</tr>           \n<tr><td colspan=\'5\'>&nbsp;</td></tr>\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t\t\t</form>\n</body>\n</html>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n";
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

          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection con = null;
	Statement stmt=null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null ;

	String tableid="";
	String tabledesc="";
	String module_id="";
	String sql="";

	stmt=con.createStatement();
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

				     try{
				     	sql="select module_id,table_id,table_desc from sm_record_trans_hdr";
				        rs=stmt.executeQuery(sql) ;

				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
					  		tableid=rs.getString("table_id");
					  		module_id=rs.getString("module_id");
					   		tabledesc=rs.getString("table_desc");
					         out.println("<option value='"+tableid+ "' >"+tabledesc);
    				       }
    				     }
						 if(rs!=null)rs.close();
						 if(stmt!=null)stmt.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}
				        
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}catch(Exception e){}
finally{
	if(stmt!=null) stmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
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
