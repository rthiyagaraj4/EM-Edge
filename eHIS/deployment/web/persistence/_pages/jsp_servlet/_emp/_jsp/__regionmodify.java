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
import java.util.*;
import com.ehis.util.*;

public final class __regionmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegionModify.jsp", 1709118712386L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<!--Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132-->\n<script src=\"../js/Region.js\" language=\"javascript\"></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
	
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String region_code = request.getParameter("region_code");
String postal_code_link_yn="";
Connection conn = null;
PreparedStatement pstmt=null;
ResultSet rset=null;
PreparedStatement pstmt1=null;
ResultSet rset1=null;
String eff_date_from="",eff_date_to="";
String country_code="";
Boolean isGSTCodeApplicable = false; //Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132

try{
out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()'>");

//Connection conn = (Connection) session.getValue( "connection" );
conn = ConnectionManager.getConnection(request);

//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
isGSTCodeApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "MP", "GST_CODE");

StringBuffer sql = new StringBuffer("select region_code,GST_Region,long_desc,short_desc,eff_date_from,eff_date_to,eff_status,country_code from mp_region where region_code='");
sql.append(region_code);
sql.append("'");
pstmt = conn.prepareStatement(sql.toString());
rset = pstmt.executeQuery();
rset.next();

String GST_Region	= rset.getString("GST_Region") ;
			if ( GST_Region == null )
					GST_Region="";
out.println("<form name='region_form' id='region_form' action='../../servlet/eMP.RegionServlet' method='post' target='messageFrame'> <BR><BR><BR><BR><BR><BR><BR><BR><BR><div align='left'><table border='0' cellpadding='3' cellspacing='0' width='75%' align='center'><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td</tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels")+"</td><td width='60%' class='fields' colspan='2'>" );

out.println("<input type='text' name='region_code' id='region_code' value='" + rset.getString("region_code") + "' size='6' maxlength='6' OnBlur='ChangeUpperCase(this)' readonly ><img src='../images/mandatory.gif'>") ;

//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
	if(isGSTCodeApplicable)
	{
	String rdonly = "";
	if(!GST_Region.equals(""))
	{rdonly = "readonly";}
	else
	{rdonly = "";}
	out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GoodsandServicesTax.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Regioncode.label","mp_labels")+"</td><td width='60%' class='fields' colspan='2'>" );
	out.println("<input type='text' name='GST_Region' id='GST_Region' onKeyPress='return NumChkForRegion(event);' onBlur='ZeroChkForRegion(this);CodeLen(this)' value='" + GST_Region + "' size='2' maxlength='2' "+rdonly+" ><img src='../images/mandatory.gif'>") ;
	}

//Added by Ashwini on 28-Jun-2017 for AMS-CRF-0132
out.println("<input type='hidden' name='isGSTCodeApplicable' id='isGSTCodeApplicable' value='"+isGSTCodeApplicable+"'>");

if ( rset.getDate("eff_date_from") != null )
		{
		 java.util.Date date = rset.getDate("eff_date_from");
		 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
 		 eff_date_from= formatter.format(date);
 		 date = null;
 		 formatter = null;
 		}


if ( rset.getDate("eff_date_to") != null)
	{
	 java.util.Date date1 = rset.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 eff_date_to= formatter.format(date1);
	 date1 = null;
	 formatter = null;
	}
country_code=checkForNull(rset.getString("country_code"));

if ( rset.getString("eff_status").equals("E") )
{
	out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' maxlength='30' onBlur='makeValidString(this)' value=\"" + rset.getString("long_desc") + "\"><img src='../images/mandatory.gif'>");
 
            _bw.write(_wl_block6Bytes, _wl_block6);
 out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15'  maxlength='15' onBlur='makeValidString(this)' value=\"" + rset.getString("short_desc") + "\"><img src='../images/mandatory.gif'></img>" );
	out.println("</td></tr>");
	try{
   		pstmt1=conn.prepareStatement("Select country_Code,SHORT_NAME from Mp_country where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by Short_Desc");

			rset1 = pstmt1.executeQuery();
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.country.label","common_labels")+"</td><td width='60%'class='fields' colspan='2'><select name='country_code' id='country_code'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------</option>");
		
		if( rset1 != null )
			{
				String classcode="";
				String classname ="";
				while(rset1.next()) 
				{
					classcode = rset1.getString( "country_code" ) ;
					classname = rset1.getString( "SHORT_NAME" ) ;
					if(country_code.equals(classcode)) 
						out.println("<option value=\"" + classcode + "\" selected>" + classname );
					else 
						out.println("<option value=\"" + classcode + "\">" + classname);
				}
			}
		
		if (rset1 != null) rset1.close();
		if (pstmt1 != null) pstmt1.close(); 
			
		} catch(Exception e) { 
			// out.println(e.toString());
			e.printStackTrace();
		} finally {
			if (rset1 != null) rset1.close();
			if (pstmt1 != null) pstmt1.close(); 			
		}
		out.println("</select><img src='../images/mandatory.gif'></img></td></tr>");
		out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"'>");

	

	/*out.println("'></td><td width='47%' class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;");*/
	out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'  value='"+eff_date_to+"'>");

	

	/*out.println("'></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td</tr>");*/
	out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");

	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");

	out.println("</td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td</tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
}
if ( rset.getString("eff_status").equals("D") )
{
	out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='text' name='long_desc' id='long_desc' size='30' value=\"" + rset.getString("long_desc") + "\" readonly><img src='../images/mandatory.gif'></img>");

            _bw.write(_wl_block6Bytes, _wl_block6);
 out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='text' name='short_desc' id='short_desc' size='15' value=\"" + rset.getString("short_desc") + "\" readonly ><img src='../images/mandatory.gif'></img>");
	out.println("</td></tr>");
	/*out.println("<tr><td  width='40%' class='label'>Effective From</td><td  width='13%'>&nbsp;&nbsp;&nbsp;*/
	
	//Added for GHL-CRF-0346 linked incidnet[57733]
		try{
   		pstmt1=conn.prepareStatement("Select country_Code,SHORT_NAME from Mp_country where eff_status='E' and ( (eff_date_from <= sysdate and eff_date_to >= sysdate ) or (eff_date_from <= sysdate and eff_date_to is null ) or (eff_date_to >= sysdate and eff_date_from is null) or (eff_date_from is null and eff_date_to is null ) ) order by Short_Desc");

			rset1 = pstmt1.executeQuery();
		
		out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.country.label","common_labels")+"</td><td width='60%'class='fields' colspan='2'><select name='country_code' id='country_code'><option value=''>-------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------</option>");
		
		if( rset1 != null )
			{
				String classcode="";
				String classname ="";
				while(rset1.next()) 
				{
					classcode = rset1.getString( "country_code" ) ;
					classname = rset1.getString( "SHORT_NAME" ) ;
					if(country_code.equals(classcode)) 
						out.println("<option value=\"" + classcode + "\" selected>" + classname );
					else 
						out.println("<option value=\"" + classcode + "\">" + classname);
				}
			}
		
		if (rset1 != null) rset1.close();
		if (pstmt1 != null) pstmt1.close(); 
			
		} catch(Exception e) { 
			// out.println(e.toString());
			e.printStackTrace();
		} finally {
			if (rset1 != null) rset1.close();
			if (pstmt1 != null) pstmt1.close(); 			
		}
		out.println("</select><img src='../images/mandatory.gif'></img></td></tr>");
	
	
	
	//End GHL-CRF-0346 incidnet[57733]
	
	
	out.println("<input type='hidden' name='eff_date_from1' id='eff_date_from1' size='10' maxlength ='10'  value='"+eff_date_from+"'>");
	

	/*out.println("' readonly></td><td width='47%'  class='label'>&nbsp;&nbsp;To&nbsp;&nbsp;&nbsp;");*/
	
	out.println("<input type='hidden' name='eff_date_to1' id='eff_date_to1' size='10' maxlength ='10'   value='"+eff_date_to+"'>");

	
	/*out.println("' readonly></td></tr><tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td</tr>");*/
	out.println("<tr><td class='label' width='40%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+"</td><td class='fields' width='60%' colspan='2'><input type='checkbox' name='eff_status' id='eff_status' value='E'");

	String eff_status = rset.getString("eff_status");
	
	if  ( eff_status.equals("E") )
		out.println("checked >");
	else
		out.println(">");
	out.println("</td></tr> <tr><td width='40%'>&nbsp;</td><td width='60%' colspan='2'>&nbsp;</td</tr></table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from' value=''><input type='hidden' name='eff_date_to' id='eff_date_to' value=''><input type='hidden' name='function_name' id='function_name' value='modify'></form>");
}
  	if ( rset != null ) rset.close() ;
	if ( pstmt != null ) pstmt.close() ;
}catch ( Exception e ) {
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
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
