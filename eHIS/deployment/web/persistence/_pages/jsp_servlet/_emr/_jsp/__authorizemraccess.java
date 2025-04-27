package jsp_servlet._emr._jsp;

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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __authorizemraccess extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/AuthorizeMRAccess.jsp", 1729660891591L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n<!--\n\t\t\t\t\t\t\t\t\t\t\t\tDeveloped by\t\t   :\t\tKumar\n\t\t\t\t\t\t\t\t\t\t\t\tDeveloped on\t \t   :\t \t11/12/2001\n\t\t\t\t\t\t\t\t\t\t\t\tModified by      \t\t   :\n\t\t\t\t\t\t\t\t\t\t\t\tModified Date\t       :\t\t\t\t\t\t\t\t\t\t-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<!--<script language=\'javascript\'src=\'../../eMR/js/vwActiveProblems.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n-->\n<script>\n function checkuser_event(e){\t\n\t\t\tif(e.keyCode==13||e.keyCode==32)\n\t\t\t\tvar key = new Array(13,32);\n\t\t\tif(key!=null){\n\t\t\t\tfor(var i=0;i<key.length;i++){\n\t\t\t\t\tif(e.keyCode==key[i]){\n\t\t\t\t\t\tchkpasswd();\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\tfunction chkpasswd() {\n\tvar p1 = document.Authorize_form.appl_user_passwd.value;\n\tvar p2 = document.Authorize_form.screen_passwd.value;\n\tvar ar = document.Authorize_form.access_rights.value;\n\tvar nr = document.Authorize_form.no_records.value;\n\tvar modal_yn = document.Authorize_form.modal_yn.value;\n\n\t\n\t\n\tp2 = p2.toUpperCase();\t\n\tp1 = p1.toUpperCase();\n\tif(Authorize_form.screen_passwd.value==\'\'){\n\t\t\t\talert(\'APP-SM0007 Password Should be Entered\');\n\t\t\t\tdocument.getElementById(\"screen_passwd\").focus();\n\t\t\t}\n\telse{\n\t\n \tif (nr==0 || ar == \"N\"){\n\t\talert(getMessage(\"NO_AUTH_SENSITIVE_DIAGNOSIS\",\"CA\"));\n\t\tif(modal_yn == \"Y\"){\n\t\t\t// top.window.returnValue = \"X\" ;\n\t\t\tparent.parent.document.getElementById(\"dialog-body\").contentWindow.returnValue = \"X\";\n\t\t\tparent.parent.document.getElementById(\"dialog_tag\").close();\n\t\t}\n\t}else if (p1 != p2){\n\t\talert(getMessage(\"PWD_MISMATCH\",\"CA\"));\n\t\tdocument.getElementById(\"screen_passwd\").value=\"\";\n\t\tdocument.getElementById(\"screen_passwd\").focus();\n\t\tif(modal_yn == \"Y\"){\n\t\t\t// top.window.returnValue = \"X\" ;\n\t\t\tparent.parent.document.getElementById(\"dialog-body\").contentWindow.returnValue = \"X\";\n\t\t\tparent.parent.document.getElementById(\"dialog_tag\").close();\n\t\t}\n\n\t}else{\n\t\t// top.window.returnValue = \"T\" ;\n\t\tparent.parent.document.getElementById(\"dialog-body\").contentWindow.returnValue = \"T\";\n\t\tparent.parent.document.getElementById(\"dialog_tag\").close();\n\t}\n\n\t}\n\n\n\t/*var p1 = document.Authorize_form.appl_user_passwd.value;\t\n\tvar p2 = document.Authorize_form.screen_passwd.value;\t\n\tvar ar = document.Authorize_form.access_rights.value;\n\tvar nr = document.Authorize_form.no_records.value;\t\n\tif (nr==0 || ar == \"N\")\n\t{\n\t\talert(getLabel(\"eMR.UnauthorisedUser.label\",\"MR\"));\n\t}\n\telse if (p1 != p2)\n\t{\n\t\talert(getMessage(\"PWD_MISMATCH\",\'SM\'));\n\t}\n\telse\n\t{\n\t\tparent.parent.window.returnValue = \"T\" ;\n\t\tparent.parent.window.close();\n\t}*/\n\n\n\n\n\n}\n\nfunction closeAuthorization(){\n\n\ttop.window.returnValue = \"F\";\n\ttop.window.close();\n}\n/*\nAnjaneya Reddy added for ICN 6473.\n*/\nfunction focusObj(){\n\tdocument.getElementById(\"screen_passwd\").focus();\n}\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\n</head>\n<body onKeyDown=\"lockKey()\" onLoad=\'focusObj()\'>\n\t\t<form name=\'Authorize_form\' id=\'Authorize_form\' >\n\t\t\t<div align=\'center\'><br>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table align=\"center\" width=\"80%\" border=0 cellspacing=0 cellpadding=0>\n\t\t\t\n\t\t\t<tr><td colspan=2 >&nbsp</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td width=\"50%\" align=\"center\" class=\"label\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t <td width=\"50%\" align=\"left\" colspan=\"2\">&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"password\"  name=\"screen_passwd\" id=\"screen_passwd\" size=\"20\" maxlength=\"20\" onkeypress=\"checkuser_event(event)\"></td>\n\n\t\t\t</tr>\n\t\t\t\t<tr><td colspan=2 >&nbsp</tr>\n\t\t\t<tr>\n\t\t\t\t\t <td width=\"50%\" class=\'button\' >\n\t\t\t\t\t ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t <td width=\"50%\" class=\'button\' >&nbsp;&nbsp;\n\t\t\t\t\t <input type=\'button\' name=\'ok\' id=\'ok\' onClick=\"chkpasswd();\" value=\'   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="   \'  class=\'button\'>\n\t\t\t\t\t <input type=\'button\' name=\'cancel\' id=\'cancel\' onClick=\"closeWindow();\" value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  class=\'button\'>\n\t\t\t\t\t </td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<!--Password &nbsp;\n\t\t\t<input type=\"password\"  name=\"screen_passwd\" id=\"screen_passwd\" size=\"8\" maxlength=\"8\" ><br><br>\n\n\t\t\t <input type=\'button\' name=\'ok\' id=\'ok\' onClick=\"chkpasswd();\" value=\'   OK   \'  class=\'button\'>\n\t\t\t <input type=\'button\' name=\'cancel\' id=\'cancel\' onClick=\"closeAuthorization();\" value=\'Cancel\'  class=\'button\'>-->\n\n<input type=\"hidden\" name=\"appl_user_passwd\" id=\"appl_user_passwd\" value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\"hidden\" name=\"access_rights\" id=\"access_rights\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\"hidden\" name=\"no_records\" id=\"no_records\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\"hidden\" name=\"modal_yn\" id=\"modal_yn\" value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</div>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<script>\nfunction closeWindow() {\n\t const dialogTag = parent.parent.document.getElementById(\'dialog_tag\');    \n\t    dialogTag.close();   \n}</script>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
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
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con=null;
//	PreparedStatement pstmt=null;
	//PreparedStatement stmt=null;
	Statement stmt=null;
	ResultSet rset=null ;

	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String loginuser=p.getProperty( "login_user" ) ;
	String facilityId = (String)session.getValue("facility_id");//Maheshwaran K added for the ML-BRU-SCF-1008 [IN:043211]  as on 12/09/2013
	String P_access_type="";
	String P_access_data="" ;
	String P_patient_type="" ;
	
	String P_constr = checkForNull(request.getParameter("constr"));
	String modal_yn = request.getParameter("modal_yn");

	
	if(modal_yn == null) modal_yn="N";

	StringTokenizer st = new StringTokenizer(P_constr,"/");
	if(!(P_constr.equals("null"))){
	while(st.hasMoreTokens())
	{
			P_access_type=st.nextToken();
			P_access_data=st.nextToken();
			P_patient_type=st.nextToken();
	}
	}

	String accrights="";
	String pword="";
	int i=1;
	//StringBuffer L_access_detail = new StringBuffer("");
	StringBuffer L_rights_column = new StringBuffer("");
	String L_passwd_column="";

		if (P_access_type.equals("V")){
			//L_access_detail.append("View");
			L_rights_column.append("VW_");
		}
		else{
			//L_access_detail.append("Edit");
			L_rights_column.append("REC_");
		}

		if (P_access_data.equals("HR")){
			//L_access_detail.append(" High Risk ");
			L_rights_column.append("HIGH_RISK_");
			L_passwd_column = "HIGH_RISK_PASSWORD" ;
		}
		else{
			//L_access_detail.append(" Sensitive Diagnosis ") ;
			L_rights_column.append("SEN_DIAG_" );
			L_passwd_column = "SEN_DIAG_PASSWORD" ;
		}

		if (P_patient_type.equals("C")){
				//L_access_detail.append(" Consulting Patient" );
				L_rights_column.append("FOR_CONS_PAT_YN");
		}
		else {
			L_rights_column.append("FOR_OTH_PAT_YN") ;
		}

            _bw.write(_wl_block8Bytes, _wl_block8);

		try{
		con=ConnectionManager.getConnection(request);
		

		

		/*String sql  = " Select ? access_rights_yn , app_password.decrypt(?) password from mr_user_access_rights where appl_user_id =?";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,L_rights_column.toString());
		stmt.setString(2,L_passwd_column);
		stmt.setString(3,loginuser);*/
		//Maheshwaran K added facility id in the query for the ML-BRU-SCF-1008 [IN:043211]  as on 12/09/2013
		String sql  = " Select "+L_rights_column.toString()+" access_rights_yn , app_password.decrypt("+L_passwd_column+") password from mr_user_access_rights where appl_user_id ='"+loginuser+"' and FACILITY_ID= '"+facilityId+"'";
		
		stmt=con.createStatement();
		rset=stmt.executeQuery(sql);
		if(!(rset.next()))
		{
			i = 0;
		}
		else
		{
			do
			{
			accrights = rset.getString("access_rights_yn");
			pword = rset.getString("password");
			}while(rset.next());

		}


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pword));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accrights));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);

		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();

}
	catch (Exception e){
		//out.println("Exception "+e.toString());
		e.printStackTrace();
	}
	finally {
		ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block18Bytes, _wl_block18);
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.password.label", java.lang.String .class,"key"));
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
}
