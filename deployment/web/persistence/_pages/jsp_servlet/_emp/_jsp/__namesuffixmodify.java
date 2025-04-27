package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __namesuffixmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/NameSuffixModify.jsp", 1709118647591L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eMP/js/NameSuffix.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest()\' onLoad=\'FocusFirstElement()\'  onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'namesuffix_form\' id=\'namesuffix_form\' action=\'../../servlet/eMP.NameSuffixServlet\' method=\'post\' target=\'messageFrame\'>\n\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t<div align=\'left\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'75%\' align=\'center\'> \n\t\t<tr>\n\t\t\t<td width=\'50%\'>&nbsp;</td>\n\t\t\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td> \n\t\t\t<td width=\'60%\' class=\'fields\' colspan=\'2\'><input type=\'text\' name=\'name_suffix\' id=\'name_suffix\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=\'8\'  readonly ><img src=\'../images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t<!-- <td class=\'fields\'><input type =\'text\' name=\'suffix_in_oth_lang\' id=\'suffix_in_oth_lang\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  maxlength=\'8\' size=\'8\'   onblur=\'makeValidString(this)\' >\n\t\t\t\t\t\t\t\t</td>  -->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n    <tr>\n\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td> \n\t\t<td width=\'60%\' class=\'fields\' colspan=\'2\'><input type=\'checkbox\' name=\'baby_suffix_yn\' id=\'baby_suffix_yn\' value=\'Y\'\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t    </td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t<td width=\'60%\' class=\'fields\' colspan=\'2\'><select name=\'baby_sex\' id=\'baby_sex\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\n\t\t\t</select>\n\t\t</td>\n\t</tr>\n   \n    <input type=\'hidden\' name=\'eff_date_from1\' id=\'eff_date_from1\' size=\'10\' maxlength =\'10\'   value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\n    <input type=\'hidden\' name=\'eff_date_to1\' id=\'eff_date_to1\' size=\'10\' maxlength =\'10\'    value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\n    <tr>\n\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td width=\'60%\' class=\'fields\' colspan=\'2\'><input type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\'E\'\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'40%\'>&nbsp;</td>\n\t\t\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n\t\t</tr> \n\t</table>\n\t</div>\n\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\' value=\'\'>\n\t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' value=\'\'>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n</form>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\n    </td></tr>\n    \n\t<input type=\'hidden\' name=\'eff_date_from1\' id=\'eff_date_from1\' size=\'10\' maxlength =\'10\'   value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' readonly>\n\n    <input type=\'hidden\' name=\'eff_date_to1\' id=\'eff_date_to1\' size=\'10\' maxlength =\'10\'    value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' readonly>\n\n    <tr>\n\t\t<td width=\'40%\' class=\'label\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\'40%\'>&nbsp;</td>\n\t\t\t<td width=\'60%\' colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t</table>\n\t</div>\n\t<input type=\'hidden\' name=\'function\' id=\'function\' value=\'modify\'>\n\t<input type=\'hidden\' name=\'eff_date_from\' id=\'eff_date_from\' value=\'\'>\n\t<input type=\'hidden\' name=\'eff_date_to\' id=\'eff_date_to\' value=\'\'>\n\t<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\'modify\'>\n</form>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
request.setCharacterEncoding("UTF-8");
String name_suffix = request.getParameter("name_suffix");
String language_direction = request.getParameter("language_direction");
Connection conn = null;
PreparedStatement pstmt=null;
PreparedStatement pstmt1=null;
ResultSet rset=null;
ResultSet rs1 =null;
String eff_date_from="",eff_date_to="";
String name_suffix_length="";
String names_in_oth_lang_yn="";
String effreadOnly = "";


try{
conn = ConnectionManager.getConnection(request);

String sql = "select name_suffix,baby_suffix_yn,baby_sex,name_suffix_loc_lang,eff_date_from,eff_date_to,eff_status from mp_name_suffix where name_suffix=?";
pstmt = conn.prepareStatement(sql);
pstmt.setString(1,name_suffix);
rset = pstmt.executeQuery();
rset.next();

            _bw.write(_wl_block9Bytes, _wl_block9);
            
                //sql = " select 'x' from mp_param where names_in_oth_lang_yn='Y' and module_id = 'MP'" ;
                sql = "select name_suffix_length,names_in_oth_lang_yn from mp_param where module_id = 'MP'" ;
                
                try
                {
                    pstmt1 =conn.prepareStatement(sql) ;
                    rs1 = pstmt1.executeQuery() ;               
					String effStatus=rset.getString("eff_status");
					if (effStatus.equals("E")) effreadOnly = "";
					else	effreadOnly = "readOnly";

                    if(rs1!=null)
                    {
					if(rs1.next())
					{
					name_suffix_length=rs1.getString("name_suffix_length");
					names_in_oth_lang_yn= rs1.getString("names_in_oth_lang_yn");
					}
                    }
                }catch ( Exception e ){ 
					out.println(e.toString());
					e.printStackTrace();
				}finally{
					if ( rs1 != null ) rs1.close() ;
                    if ( pstmt1 != null ) pstmt1.close() ;                 
                }       
        
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rset.getString("name_suffix") ));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(names_in_oth_lang_yn.equals("Y")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(					(rset.getString("name_suffix_loc_lang")==null?"&nbsp;":rset.getString("name_suffix_loc_lang"))));
            _bw.write(_wl_block15Bytes, _wl_block15);

								String name_suffix_loc_lang=rset.getString("name_suffix_loc_lang")==null?"&nbsp;":rset.getString("name_suffix_loc_lang");
								out.println("<td class='fields'><input type ='text' name='suffix_in_oth_lang' id='suffix_in_oth_lang' value='"+name_suffix_loc_lang+"'  maxlength='"+name_suffix_length+"' size='"+name_suffix_length+"'   onblur='makeValidString(this)' onKeypress='return CheckSpecCh(event);' "+effreadOnly+" ");
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
								
								out.println("></td> ");

								
            _bw.write(_wl_block16Bytes, _wl_block16);
}
/*if ( rset.getDate("eff_date_from") != null )
        {
         java.util.Date date = rset.getDate("eff_date_from");
         SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
         eff_date_from = formatter.format(date);
         date = null;
         formatter = null;
        }
        

if ( rset.getDate("eff_date_to") != null)
    {
     java.util.Date date1 = rset.getDate("eff_date_to");
     SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
     eff_date_to = formatter.format(date1);
     date1 = null;
     formatter = null;
    }*/

if ( rset.getString("eff_status").equals("E") )
{

            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
    if  ( rset.getString("baby_suffix_yn").equals("Y") )
            out.println("checked >");
        else
            out.println(">");

        //out.println("<img src='/eCIS/mp/images/mandatory.gif'></img>");

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
    if (rset.getString("baby_sex").equals("M"))
        {
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");

        }
    else if (rset.getString("baby_sex").equals("F"))
        {
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");

        }
    else if (rset.getString("baby_sex").equals("B"))
        {
        out.println( "<OPTION VALUE="+"B"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"M"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")+"</Option>");
        out.println( "<OPTION VALUE="+"F"+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")+"</Option>");

        }
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(eff_date_from));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eff_date_to));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	String eff_status = rset.getString("eff_status");

    if  ( eff_status.equals("E") )
        out.println("checked >");
    else
        out.println(">");

            _bw.write(_wl_block25Bytes, _wl_block25);

	}

if ( rset.getString("eff_status").equals("D") )
{


    out.println("<tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ForBaby.label","mp_labels")+"</td> <td width='60%' class='fields' colspan='2'>");

        String baby_suffix_yn = rset.getString( "baby_suffix_yn" ) ;
        if ( baby_suffix_yn == null ) baby_suffix_yn = "N" ;

        out.println( "<input type='hidden' name='baby_suffix_yn' id='baby_suffix_yn' value='" + baby_suffix_yn + "'>" ) ;
        if  ( rset.getString("baby_suffix_yn").equals("Y") ) {
            out.println( "<input type='checkbox' name='baby_suffix_yn1' id='baby_suffix_yn1' value='Y' disabled checked>" ) ;
        } else {
            out.println( "<input type='checkbox' name='baby_suffix_yn1' id='baby_suffix_yn1' value='Y' disabled>" ) ;
        }

         //out.println("<img src='/eCIS/mp/images/mandatory.gif'></img>");


        out.println("</td></tr><tr><td width='40%' class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</td><td width='60%' class='fields'  colspan='2'><input type='text' name='baby_sex1' id='baby_sex1' value='" );

        if (rset.getString("baby_sex").equals("M"))
            {

             out.println("Male' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='M'>");

            }
        else if (rset.getString("baby_sex").equals("F"))
            {
             out.println("Female' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='F'>");

            }
        else if (rset.getString("baby_sex").equals("B"))
            {
             out.println("Both' size='6' maxlength='6'  readonly >" );
             out.println("<input type='hidden' name='baby_sex' id='baby_sex' value='B'>");

            }
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(eff_date_from));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eff_date_to));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	String eff_status = rset.getString("eff_status");

    if  ( eff_status.equals("E") )
        out.println("checked >");
    else
        out.println(">");

            _bw.write(_wl_block29Bytes, _wl_block29);
}
}catch ( Exception e ){
	out.println(e.toString());
	e.printStackTrace();
}
finally{
    if ( rset != null ) rset.close() ;
    if ( pstmt != null ) pstmt.close() ;
    if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block30Bytes, _wl_block30);
            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NameSuffix.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.NameSuffixinOtherLanguage.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ForBaby.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
