package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __operationalstatusentitymodule extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/OperationalStatusEntityModule.jsp", 1709121707948L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n<head>\n\t\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<script>\nvar arrModule = new Array();\nvar arrModVal = new Array();\nvar x = 0;\n\nfunction setValue(Module,Obj)\n{\n\tif(Obj.checked == true)\n\t{\n\t\tObj.value = \"Y\";\n\t\tfor(y = 0;y < x;y++)\n\t\t{\n\t\t\tif(arrModule[y] == Module)\n\t\t\t   arrModVal[y] = \"Y\";\n\t\t}\n\t}\n\telse\n\t{\n\t\tObj.value = \"N\";\n\t\tfor(y = 0;y < x;y++)\n\t\t{\n\t\t\tif(arrModule[y] == Module)\n\t\t\t   arrModVal[y] = \"N\";\n\t\t}\n\t}\n\tvar modules = arrModule[0];\n\tvar modvalues  = arrModVal[0];\n\tfor(z = 1;z < x;z++)\n\t{\n\t\tmodules += \"|\"+arrModule[z];\t \t\n\t\tmodvalues += \"|\"+arrModVal[z];\t \t\n\t}\n\n\tdocument.forms[0].ModuleIDs.value = modules;\n\tdocument.forms[0].ModuleVals.value = modvalues;\n}\n\nfunction initialize()\n{\n\tvar modules = arrModule[0];\n\tvar modvalues  = arrModVal[0];\n\tfor(z = 1;z < x;z++)\n\t{\n\t\tmodules += \"|\"+arrModule[z];\t \t\n\t\tmodvalues += \"|\"+arrModVal[z];\t \t\n\t}\n\n\tdocument.forms[0].ModuleIDs.value = modules;\n\tdocument.forms[0].ModuleVals.value = modvalues;\n}\n\n</script>\n<body onLoad=\"initialize();\" onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey()\'>\n<form name=\"facility_oper_module_result\" id=\"facility_oper_module_result\">\n<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'90%\' align=\'center\'> \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tarrModule[x] = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\tarrModVal[x] = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\tx++;\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\tx++;\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n           \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<th>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n                    <th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<tr><td class=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' align=\'center\'><input type=\'checkbox\' name=\'chbox";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' id=\'chbox";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onClick=\'setValue(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\",this)\'></td></tr>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'))\n\t\t\t\tparent.f_query_details.location.href = \"../../eCommon/html/blank.html\"\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</table>\n\t<input type=\"hidden\" name=\"TotRecs\" id=\"TotRecs\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"ModuleIDs\" id=\"ModuleIDs\" value=\"\">\n\t<input type=\"hidden\" name=\"ModuleVals\" id=\"ModuleVals\" value=\"\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

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
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String entityid = request.getParameter("entityid");
	String opermodules = request.getParameter("opermodules");
	String groupid = request.getParameter("groupid");
	if(opermodules == null || opermodules.equals("null")) opermodules = "";

            _bw.write(_wl_block6Bytes, _wl_block6);

	//	 request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		Connection con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String classValue = "QRYODD";
		String operFlag = "";
		String operYN = "";
		
		int i = 1;

	try
	{
		if(opermodules.equals(""))
		{
			pstmt1 = con.prepareStatement("Select module_id, operational_yn operational_flag, srl_no from SM_MODULES_ACCT_ENTITY_vw where ACCT_ENTITY_ID = ? Union Select module_id, 'N' operational_flag, srl_no from sm_module where install_yn = 'Y' and MODULE_GROUP_ID = 'FM' and module_id not in (Select module_id from SM_MODULES_ACCT_ENTITY where ACCT_ENTITY_ID = ?) order by srl_no  ");
			pstmt1.setString	(	1,	entityid		);
			pstmt1.setString	(	2,	entityid		);
			rs1 = pstmt1.executeQuery();
			if(rs1 != null)
			{
				while(rs1.next())
				{
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs1.getString(1)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs1.getString(2)));
            _bw.write(_wl_block11Bytes, _wl_block11);

				}
			}
		}
		else
		{
			String chkModules = "";
			String chkValues = "";
			StringTokenizer stoken = new StringTokenizer(opermodules,"$");
			String Modules = stoken.nextToken();
			String Flags = stoken.nextToken();

			StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
			StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
						
			while(smodtoken.hasMoreTokens())
			{
				chkModules = smodtoken.nextToken();
				chkValues  = sflagtoken.nextToken();
				
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(chkModules));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(chkValues));
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
		}

		pstmt = con.prepareStatement("Select module_id, module_name, operational_yn operational_flag, srl_no from SM_MODULES_ACCT_ENTITY_vw where ACCT_ENTITY_ID = ? and module_group_id = ? Union Select module_id, module_name, 'N' operational_flag, srl_no from sm_module where module_group_id = ? and install_yn = 'Y' and module_id not in (Select module_id from SM_MODULES_ACCT_ENTITY where ACCT_ENTITY_ID = ?) order by srl_no  ");
		pstmt.setString	(	1,	entityid		);
		pstmt.setString	(	2,	groupid		);
		pstmt.setString	(	3,	groupid		);
		pstmt.setString	(	4,	entityid		);
		rs = pstmt.executeQuery();
		int a=0;
		if(rs != null)
		{ { 
            _bw.write(_wl_block13Bytes, _wl_block13);
}	while(rs.next())
			{
			if(a==0){
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 a=1;}
                 if(classValue.equals("QRYEVEN"))
                     classValue = "QRYODD";
                 else
                    classValue = "QRYEVEN";
				
				if(opermodules.equals(""))
				{
					operYN = rs.getString("operational_flag");
					if(operYN == null || operYN.equals("null")) operYN = "N";

					if(operYN.equals("N"))
						operFlag = "Unchecked";
					else
						operFlag = "Checked";
				}
				else
				{
					String chkModules = "";
					String chkValues = "";
					StringTokenizer stoken = new StringTokenizer(opermodules,"$");
					String Modules = stoken.nextToken();
					String Flags = stoken.nextToken();

					StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
					StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
						
					while(smodtoken.hasMoreTokens())
					{
						chkModules = smodtoken.nextToken();
						chkValues  = sflagtoken.nextToken();
						if(chkModules.equals(rs.getString("module_id")))
						{
							if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";

								operYN = chkValues;
						}
					}	
				}
			
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("module_name")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(operYN));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(operFlag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("module_id")));
            _bw.write(_wl_block25Bytes, _wl_block25);

				i++;
			}
		}
		if(a==0){
            _bw.write(_wl_block26Bytes, _wl_block26);
}

		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();

	}
	catch(Exception e) { out.println(e.toString()); }
	finally 
	{
		
		ConnectionManager.returnConnection(con, request);
	}
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf((i-1)));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Module.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eSM.Operational.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${sm_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
