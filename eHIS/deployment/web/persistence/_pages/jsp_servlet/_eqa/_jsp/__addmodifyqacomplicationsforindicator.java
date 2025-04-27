package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __addmodifyqacomplicationsforindicator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/addModifyQAComplicationsForIndicator.jsp", 1709121610000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<head>\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script type=\'text/javascript\' src=\'../../eQA/js/QAComplicationsForIndicator.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eQA/js/QAValidate.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\'  src=\'../../eCommon/js/MstCodeCommon.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body onload=\'populateDesc()\'  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<form name=\'QA_Complications_Indicator\' id=\'QA_Complications_Indicator\' target=\'messageFrame\' method=\'post\' action = \'../../servlet/eQA.QAComplicationForIndicatorServlet\'  >\n<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n<tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n  <td width=\'20%\' align=\'right\' class=\'label\'>Indicator ID&nbsp;&nbsp;</td>\n  <td width=\'80%\' align=\'left\' colspan=\'2\' class=\'label\'>\n  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n <INPUT TYPE=\"text\" name=\"indicator_code\" id=\"indicator_code\" value=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" readonly> \n  \n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n  <select name=\'indicator_code\' id=\'indicator_code\' onchange=\'populateDesc()\'>\n  \n  <option value=\'\'>--------Select----------</option>\n  ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' selected>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</option>\n\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    \t\t\t  <option value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n </select>\n &nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n </td>\n </tr>\n <tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\'>&nbsp;</td>\n </tr>\n <tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\' class=label>\n\t<label name=\'indicator\' id=\'indicator\'></label></td>\n </tr>\n <tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\'>&nbsp;&nbsp;</td>\n </tr>\n <tr>\n      <td width=\'20%\' align=\'right\' class=\'label\'>Complication Code&nbsp;&nbsp;</td>\n      <td width=\'80%\' align=\'left\' colspan=\'2\'>\n      \n\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<input type=\'text\' name=\'complication_code\' id=\'complication_code\' size=\'10\'  value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  maxlength=\'4\' onBlur=\'ChangeUpperCase(this);\' readonly onKeyPress=\'return CheckForSpecChars(event)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t  <input type=\'text\' name=\'complication_code\' id=\'complication_code\' size=\'10\'    value=\'\'  maxlength=\'4\' onKeyPress=\'return CheckForSpecChars(event)\' onBlur=\'ChangeUpperCase(this)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n      </td>\n</tr>\n<tr>\n\t<td width=\'20%\' >&nbsp;</td>\n\t<td width=\'80%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'20%\' align=\'right\' class=\'label\'>Description&nbsp;&nbsp;</td>\n\t<td width=\'80%\' align=\'left\' >\n\t<input type=\'text\' name=\'complication_desc\' id=\'complication_desc\' size=\'70\'  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" maxlength=\'60\' >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n</tr>\n<tr>\n\t<td width=\'30%\' >&nbsp;</td>\n\t<td width=\'70%\' colspan=\'2\'>&nbsp;</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\'indicator_desc\' id=\'indicator_desc\' value=\'\'>\n</form>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String indicator_code="";
	String mode="";
	String complication_code = "";
	String complication_desc = "";

    
	try
	{
		indicator_code=request.getParameter("indicator_code")==null ?"":request.getParameter("indicator_code");	
		conn = ConnectionManager.getConnection(request);
		if(!indicator_code.equals(""))
		{  
			pstmt=conn.prepareCall("select QIND_CLIND_ID indicator_code,COMPL_CODE complication_code,COMPL_DESCRIPTION complication_desc From QA_QIND_CLIND_COMPL where QIND_CLIND_ID=?");
			pstmt.setString(1,indicator_code);
			rs=pstmt.executeQuery();
			if(rs.next()==true)			
				{
					 mode="U";
					 indicator_code=rs.getString("indicator_code");
					 complication_code=rs.getString("complication_code");
					 complication_desc=rs.getString("complication_desc");
				} 
				if(pstmt!=null) pstmt.close();
	            if(rs!=null) rs.close();
				if((indicator_code==null) || (indicator_code.equals("null")))
					indicator_code="";
				if((complication_code==null) || (complication_code.equals("null")))
					complication_code="";
                if((complication_desc==null) || (complication_desc.equals("null")))
					complication_desc="";

					
		}
		else
	 	 mode="I";
   


            _bw.write(_wl_block4Bytes, _wl_block4);
if(mode.equals("U")){
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(indicator_code));
            _bw.write(_wl_block6Bytes, _wl_block6);
}else{
            _bw.write(_wl_block7Bytes, _wl_block7);

	 
	  pstmt = conn.prepareStatement("select qind_clind_id,qind_clind_desc from qa_qind_clind WHERE EFF_STATUS='E' order by	to_number(qind_clind_id)");
	  rs = pstmt.executeQuery();
	  if(rs!=null)
	  {
		  while(rs.next())
		  {
			  if(indicator_code.equals(rs.getString(1)))
			  {
			  
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		  }
	  }     if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
  }
  
            _bw.write(_wl_block13Bytes, _wl_block13);
if(mode.equalsIgnoreCase("U")){
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(complication_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
} else {
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(complication_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block19Bytes, _wl_block19);
           if(rs!=null)rs.close();
			 if(pstmt!=null)pstmt.close();
	   }
	  catch(Exception e)
	  {
		   out.println("Exception in addModifyQAComplicationsForIndicator"+e.toString());
	  }
finally
{ 
    ConnectionManager.returnConnection(conn, request);
	
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
