package jsp_servlet._emp._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __occupationmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/occupationModify.jsp", 1709118664012L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
 String ocpncode;String longdesc;String shortdesc;String effdatefrom;String effdateto;String effstatus;String ocpnclasscode;String ocpn_class_desc;
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");


            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 ocpncode = request.getParameter("occupation_code");
//Connection conn = (Connection) session.getValue( "connection" );
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
ResultSet rs=null;
try{ 
	conn = ConnectionManager.getConnection(request);
	StringBuffer sbQuery = new StringBuffer();
//	String sql ;									// will be deleted once code walkthrough is done
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");
	sbQuery.append("select ocpn_code,a.ocpn_class_code ocpn_class_code,a.long_desc long_desc,a.short_desc occupation_desc,a.eff_date_from,a.eff_date_to,a.eff_status eff_status, b.long_desc ocpn_class_desc from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code and a.ocpn_code='");
	sbQuery.append(ocpncode);
	sbQuery.append("'");
//String sql = "select ocpn_code,a.ocpn_class_code ocpn_class_code,a.long_desc long_desc,a.short_desc occupation_desc,a.eff_date_from,a.eff_date_to,a.eff_status eff_status, b.short_desc ocpn_class_desc from mp_occupation a, mp_occupation_class b where a.ocpn_class_code = b.ocpn_class_code and a.ocpn_code='"+ocpncode+"'"; 
pstmt = conn.prepareStatement(sbQuery.toString());
rset = pstmt.executeQuery();
if (rset.next())
{
	ocpncode = rset.getString("ocpn_code");
	longdesc = rset.getString("long_desc");
	shortdesc = rset.getString("occupation_desc");
	ocpn_class_desc = rset.getString("ocpn_class_desc");
	ocpnclasscode = rset.getString("ocpn_class_code");
	effstatus = rset.getString("eff_status");
}
	out.println("<form name='occupation_form' id='occupation_form' action='../../servlet/eMP.OccupationServlet' method='post' target='messageFrame'><div align='left'><BR><BR><BR><BR><BR><BR><BR><BR><table border='0' cellpadding='3' cellspacing='0' width='75%'align='center'><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" ); out.println( "<input type='text' name='occupation_code' id='occupation_code' value='" + ocpncode + "' size='6' readonly ><img src='../images/mandatory.gif'></img>" ) ; 

	if ( effstatus.equals("E") )
	{
		out.println("</td></tr><!--tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr--><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" +longdesc+ "\">");
		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15' maxlength='15' onBlur='makeValidString(this)' value=\"" + shortdesc +"\">");
		out.println("<img src='../images/mandatory.gif'></img></td></tr>");
		try
		{
			sbQuery.setLength(0);
			sbQuery.append("Select ocpn_class_code,long_desc short_desc  from mp_occupation_class where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ");

//			sql="Select ocpn_class_code,short_Desc  from mp_occupation_class where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by short_desc ";

			pstmt = conn.prepareStatement(sbQuery.toString());
			rs = pstmt.executeQuery();
			out.println("<tr><td width='40%'  class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><select name='occupation_class' id='occupation_class'><option value=''>-------------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------------</option>");
			if( rs != null )
			{
				while(rs.next()) 
				{
					String classcode = rs.getString( "ocpn_class_code" ) ;
					String classname = rs.getString( "short_desc" ) ;
					
					if(ocpnclasscode.equals(classcode))
					{
						out.println("<option value=\"" + classcode + "\" selected>" + classname );
					}
					else out.println("<option value=\"" + classcode + "\">" + classname );
				}
			}		
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();			
		}
		catch(Exception e) { 
			// out.println(e.toString());
			e.printStackTrace();
		}
		out.println("</select><img src='../images/mandatory.gif'></img></td></tr>");
		
	//	out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");
		
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='" + effdatefrom +"' >");
		
		
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "'>");
		
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");
	}
	if ( effstatus.equals("D") )
	{
		out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' value=\"" + longdesc + "\" readonly>");
		out.println("<img src='../images/mandatory.gif'></img></td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td width='60%' colspan='2' class='fields'><input type='text' name='short_desc' id='short_desc' size='15'  maxlength='15' value=\"" + shortdesc +"\" readonly >");
		out.println("<img src='../images/mandatory.gif'></img></td></tr>");
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OccupationClass.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='hidden' name='occupation_class' id='occupation_class' value=\""+ocpnclasscode+"\"><input type='text' size='30' name='occupation_class_desc' id='occupation_class_desc' value=\"" + ocpn_class_desc + "\"");
		out.println(" readonly>&nbsp;<img src='../images/mandatory.gif'></img></td></tr>");
		//out.println("<tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr>");
		
		
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='" + effdatefrom + "' readonly>");

			
		out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='" + effdateto + "' readonly>");
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");
		if  ( effstatus.equals("E") )
			out.println("checked >&nbsp;");
		else
			out.println(">&nbsp;");
		out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='function_name' id='function_name' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''></form>");
	}
 	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
}catch ( Exception e ){ 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174210364 on 12-09-2023
	}
finally{
 	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block5Bytes, _wl_block5);
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
