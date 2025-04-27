package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmipgeneratepulllistcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMIPGeneratePullListCriteria.jsp", 1742884951347L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMIPGeneratePullList.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onLoad=\"FocusFirstElement()\"onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey();\'>\n\t<form name=\'FMGenPullListCriteriaForm\' id=\'FMGenPullListCriteriaForm\'>\n\t<table cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' border=\'0\' align=\'center\'>\n\t <tr><td colspan=\'4\'>&nbsp;<td></tr> \n\t<tr>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'><select name=\'fs_locn_code\' id=\'fs_locn_code\' onChange=\'fetchResult(this);\'><option value=\'\'>------ ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="------</option>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</select><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t<td class=\'fields\' width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<input type=\'text\' name=\'appl_user_name\' id=\'appl_user_name\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" size=\'30\' maxlength=60 disabled readonly><input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' size=\'40\' maxlength=30 ><input type=button name=searchcode id=searchcode value=\'?\' class=button onClick=\"searchCode(appl_user_id,\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',appl_user_name);\" disabled></td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" readonly size=\'30\' maxlength=60><input type=\'hidden\' name=\'appl_user_id\' id=\'appl_user_id\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' readonly size=\'40\' maxlength=30><input type=button name=searchcode id=searchcode value=\'?\' class=button onClick=\"searchCode(appl_user_id,\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',appl_user_name)\"></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</tr>\n\t<tr><td colspan=\'4\'>&nbsp;<td></tr>\n\t</table>\n\t\t<script>\n\n\t\tvar val = \'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\';\n\n\t\tif (\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'==1)\n\t\t{\n\t\tdocument.forms[0].fs_locn_code.value = \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\';\n\t\tparent.frames[1].location.href=\"../../eFM/jsp/FMIPGeneratePullListResult.jsp?fs_locn_code=\"+val;\n\t\tparent.frames[2].location.href=\"../../eFM/jsp/FMIPGeneratePullListNote.jsp\";\n\n\t\t}\n\n\t\t</script>\n\t</form>\n\t</body>\n</html>\n\t\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
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

	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="";
	String user_name="";
	Connection con	=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs	=	null;

	java.sql.Statement stmt2	=	null;
	ResultSet rs2	=	null;		
	
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
	//	stmt		=	con.createStatement();

		String user_security_yn  = request.getParameter("user_security_yn")==null?"N":request.getParameter("user_security_yn");
		String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");

		String fs_locn_query = "";
		if(user_security_yn.equals("Y"))
		{
			
			if (access_all.equals("*ALL"))
			{
				//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				fs_locn_query="SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 ) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y'  ORDER BY 2";
			}
			else
			{
				//fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				/*fs_locn_query = "SELECT"
							  +"  a.fs_Locn_Code"
							  +"  , ("
							  +"  CASE "
							  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
							  +"  THEN"
							  +"    '*ALL' "
							  +"  ELSE B.SHORT_DESC "
							  +"  END) fs_Locn_desc "
							  +"FROM"
							  +"  FM_USER_ACCESS_RIGHTS_VW A"
							  +"  , FM_STORAGE_LOCN_LANG_VW B "
							  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
							  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
							  +"  AND A.Facility_Id = '"+facility_id+"' "
							  +"  AND A.apPl_User_Id = '"+user_id+"' "
							  +"  AND A.TRACK_OUT_TO_OPD = 'Y' "
							  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
							  +"  AND B.LANGUAGE_ID='"+localeName+"' "
							  +"ORDER BY 2";*/
						fs_locn_query="SELECT"
						  +"  A.FS_LOCN_CODE,"
						  +"  DECODE"
						  +"  (a.fs_locn_code,"
						  +"   '*ALL', '*ALL',"
						  +"  fm_get_desc.fm_storage_locn(a.facility_id, "
						  +"   a.fs_locn_code, "
						  +" '"+localeName+"', "
						  +"  '2') ) fs_locn_short_desc, "
						  +"   A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"  FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"			
						  +"  WHERE A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";
			}
		}
		else
		{
			//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			fs_locn_query="SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 ) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y'   ORDER BY 2";
		}
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			if(stmt != null) stmt=null;
			stmt =	con.createStatement();
			//String appl_str ="select appl_user_name from sm_appl_user where appl_user_id = '"+user_id+"'";
			String appl_str ="select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+user_id+"' and LANGUAGE_ID='"+localeName+"'";

			rs = stmt.executeQuery(appl_str);
			while(rs!=null && rs.next())
			{
	         user_name = rs.getString(1);
			}
			if(rs != null)		rs.close();		
	
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString(1);
				fs_locn_desc	=	rs.getString(2);

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";
					
				out.println("<option value="+fs_locn_code+" >"+fs_locn_desc+"</option>");
			}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(user_security_yn.equals("Y"))
			{
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			else
			{
	
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

			}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fs_locn_code));
            _bw.write(_wl_block23Bytes, _wl_block23);

	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();
	if(rs2 != null)		rs2.close();
	if(stmt2 != null)	stmt2.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block24Bytes, _wl_block24);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.FSLocation.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eFM.GeneratedBy.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${fm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
