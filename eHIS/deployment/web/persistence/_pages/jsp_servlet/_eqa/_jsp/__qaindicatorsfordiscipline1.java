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

public final class __qaindicatorsfordiscipline1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorsForDiscipline1.jsp", 1742817544862L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n  <script language=\'javascript\' src=\'../../eQA/js/QAIndicatorsForDiscipline.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script> \n  <!-- <script language=\'javascript\' src=\'../../eCommon/js/MstCodeCommon.js\' ></script> -->\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  \n</head>\n  ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \t \n\t <body OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t <form name=\"IndicatorFacilityform\" id=\"IndicatorFacilityform\" action=\"../../servlet/eQA.QAIndicatorForDisciplineServlet\" method=\"post\" target=\"messageFrame\">\n\n\t <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'center\' width=\'90%\'>\n\t    <tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t    <tr>\n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>Discipline</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'>&nbsp;<select name=\'disipid\' id=\'disipid\'  >\n\t\t      <option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----Select----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t      ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t      </select>\n   \t\t      <img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t  </td> \t\n\t\t      <td align=\'left\' width=\'13%\'>&nbsp;</td>\n\t    </tr>\t\n\t\t<tr>\n\t\t   <td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t\n          <tr>\n\t\t      <td align=\'left\' width=\'12%\'>&nbsp;</td> \t\n\t\t      <td class=\'label\' align=\'right\' width=\'25%\'>Indicator ID</td>\n\t\t      <td class=\'label\' align=\'left\' width=\'40%\'>&nbsp;\n\t\t\t  <Input Type=text name=indi id=indi onKeyPress=\'return CheckForSpecChars(event)\' size=\'4\' maxlength=\'4\'>\n\t\t\t\t</td>\n\t\t\t\t  <td align=\'left\' width=\'12%\'>&nbsp;</td> \n\t\t</tr>\n\n<tr>\t\t\t\t <!--  ---------------- -->\n\t<td align=\'right\' class=\'label\' colspan=2></td>\n\t<td class=\'label\' align=right>\n\t<input type=\'button\' name=\'search\' id=\'search\' value=\'Search\' class=\'button\' onclick=\'submitPage()\'></td>\n\t<td class=\'label\' align=center>\n\t<input type=\'button\' name=\'clear\' id=\'clear\' value=\'Clear\' class=\'button\' onclick=\'clearAll();\'></td>\t\n\t</tr>\n</table>\n\t </form>\n\t\t\n    </body>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</html>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
	
     session.removeAttribute("hashIndicator");
	 session.removeAttribute("arrayKeys");
	 Connection con 					= null;
	 PreparedStatement pstmt			= null;
	 ResultSet rset					    = null;
	 
	 String disip			= request.getParameter("disipid");
	 disip			= (disip == null)?"":disip;

	  String  disipline= "select qind_discipline_id,qind_discipline_desc from qa_qind_discipline  where eff_status='E' order by 2";
  
	
            _bw.write(_wl_block4Bytes, _wl_block4);

				 try
				 {
                    con	    = ConnectionManager.getConnection(request);
				    pstmt   = con.prepareStatement(disipline);
				    rset    = pstmt.executeQuery();
			
				 while(rset!=null && rset.next())
				 {
					
                        out.println("<option value='"+rset.getString(1)+"'>");	     
					    out.println(rset.getString(2));
					    out.println("</option>"); 
				 }

				 if(pstmt!=null) pstmt.close();
				 if(rset!=null) rset.close();
              
            _bw.write(_wl_block5Bytes, _wl_block5);
      if(pstmt!=null) pstmt.close();
		if(rset!=null) rset.close();
	  } 
	
	   catch(Exception e)
		   {
		   out.println("Exception in File QAIndicatorsForDiscipline1"+e.toString());}
   finally
    {
    	
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
