package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __emailrecipientscontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EmailRecipientsControl.jsp", 1709115810716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<title>Email Recipients</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<SCRIPT>\nfunction colseWindow(){\n\twindow.close();\n}\nfunction clearRecipientIds(){\n\tvar en=document.forms[0].elements[\"recipintId\"];\n\tif((en.length)==undefined){\n\t\tdocument.forms[0].recipintId.checked = false;\n\t}else{\n\t\tfor(var i=0;i<en.length;i++){\n\t\t\ten[i].checked=false;\n\t\t}\n\t}\n}\nfunction applyRecipientIds(){\n\tvar en=document.forms[0].elements[\"recipintId\"];\t\n\tvar recipintIdlist=\"\";\n\tif((en.length)==undefined){\n\t\tif(document.forms[0].recipintId.checked)\n\t\t\trecipintIdlist = document.forms[0].recipintId.value;\n\t}else{\t\t\n\t\tfor(var i=0;i<en.length;i++){\n\t\t\tif(en[i].checked){\n\t\t\t\tif(recipintIdlist!=\"\")\n\t\t\t\t\trecipintIdlist=recipintIdlist+\",\";\n\t\t\t\trecipintIdlist=recipintIdlist+en[i].value;\n\t\t\t}\n\t\t}\n\t}\n\tif(recipintIdlist!=\"\"){\n\t\twindow.returnValue = recipintIdlist;\n\t\twindow.close();\n\t}else{\n\t\talert(\"Please select any one Recipient.\");\n\t}\n}\n</SCRIPT>\n</HEAD>\n<BODY>\n\t<form name=\"\" id=\"\" method=\"post\">\n\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" height=\"100%\" align=\'center\'>\n\t\t<TR height=\"90%\">\n\t\t\t<TD>\n\t\t\t\t<DIV style=\"width:100%; height:100%; overflow: auto;\">\n\t\t\t\t<TABLE border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TH align=\"center\" >Recipient Name</TH>\n\t\t\t\t\t\t<TH align=\"center\" >Email Id</TH>\n\t\t\t\t\t\t<TH align=\"center\" >Select</TH>\n\t\t\t\t\t</TR>\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t <TR>\n\t\t\t\t\t\t\t\t\t\t<TD class=\'gridData\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TD>\n\t\t\t\t\t\t\t\t\t\t<TD class=\'gridData\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</TD>\n\t\t\t\t\t\t\t\t\t\t<TD class=\'gridData\' align=\"center\"><input type=\"checkbox\" name=\"recipintId\" id=\"recipintId\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="checked";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/></TD>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"3\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"3\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"3\" align=\"center\">Email Recipients Not available.</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"3\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t<TR><TD colspan=\"3\">&nbsp;</TD></TR>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\t\t\t\t</TABLE>\n\t\t\t\t</DIV>\n\t\t\t</TD>\n\t\t</TR>\n\t\t<TR height=\"10%\">\n\t\t\t<TD align=\"right\" >\n\t\t\t\t<input type=\"button\" value=\"Apply\" onClick=\"javascript:applyRecipientIds();\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="disabled ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/>&nbsp;&nbsp;<input type=\"button\" value=\"Clear\" onClick=\"javascript:clearRecipientIds();\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/>&nbsp;&nbsp;<input type=\"button\" value=\"Close\" onClick=\"javascript:colseWindow();\" />\n\t\t\t</TD>\n\t\t</TR>\n\t</TABLE>\n\t</form>\n</BODY>\t\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;		
	
	String recipients_id= request.getParameter("recipients_id") == null ? "": request.getParameter("recipients_id") ;  //Bru-HIMS-CRF-024 [Ramesh]
	String[] temp=recipients_id.split(",");
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<temp.length;i++){
		 sb.append("'"+temp[i]+"'");			
		 if( (i+1)!=temp.length)
			 sb.append(",");
	}
	if((sb.toString()).equals(""))
		sb.append("''");
	int i=0;

            _bw.write(_wl_block7Bytes, _wl_block7);
							
						String sql ="SELECT B.MAILER_ID,B.MAILER_NAME,B.EMAIL_ID,NVL((SELECT 'Y' FROM  SM_REGD_MAILING_LST A WHERE A.MAILER_ID IN("+sb.toString()+") AND A.MAILER_ID=B.MAILER_ID),'N') STATUS FROM SM_REGD_MAILING_LST B WHERE B.EFF_STATUS='E'";
						try{
							con	= ConnectionManager.getConnection(request);
							pstmt	= con.prepareStatement(sql);							
							rs = pstmt.executeQuery();
							
							if(rs!=null){
								while(rs.next()){
									String mailerId = rs.getString("MAILER_ID")==null?"":(String)rs.getString("MAILER_ID");
									String mailerName = rs.getString("MAILER_NAME")==null?"":(String)rs.getString("MAILER_NAME");
									String emailId = rs.getString("EMAIL_ID")==null?"":(String)rs.getString("EMAIL_ID");
									String status =  rs.getString("STATUS")==null?"":(String)rs.getString("STATUS");
									 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mailerName));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(emailId ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(mailerId));
            _bw.write(_wl_block11Bytes, _wl_block11);
if("Y".equals(status)){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

									 i++;
								}
							}
							if(i==0){
								
            _bw.write(_wl_block14Bytes, _wl_block14);

							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							
						}catch(Exception e){
								e.printStackTrace();
								//out.println("Exception from EmailRecipientsControl.jsp " + e.toString());//COMMON-ICN-0181
						}finally{
								if(con != null) ConnectionManager.returnConnection(con, request);
						} 
						
					
            _bw.write(_wl_block15Bytes, _wl_block15);
if(i==0){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
if(i==0){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
