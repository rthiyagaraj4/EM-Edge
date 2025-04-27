package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blfindtlsqrybanner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFinDtlsQryBanner.jsp", 1709114514572L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script>\nfunction call_bl_fin_dtls()\n{\n\tvar retVal = \tnew String();\n\tvar title=getLabel(\"eBL.PAT_ENCOUNTER_FIN_DTLS.label\",\"BL\");\n\tvar episodetype = document.forms[0].episode_type.value;\n\tvar episodeid = document.forms[0].episode_id.value;\n\tvar visitid = document.forms[0].visit_id.value;\n\tvar patientid= document.forms[0].patient_id.value;\n\tvar episode1 =\"\";\n\n\tif(episodetype==\"D\")\n\t{\n\t\tepisode1=getLabel(\"Common.daycare.label\",\"common\");\n\t}\n\telse if(episodetype==\"I\")\n\t{\n\t\tepisode1=getLabel(\"Common.inpatient.label\",\"common\");\n\t}\n\telse if(episodetype==\"E\")\n\t{\n\t\tepisode1=getLabel(\"Common.emergency.label\",\"common\");\n\t}\n\telse if(episodetype==\"O\")\n\t{\n\t\tepisode1=getLabel(\"Common.Outpatient.label\",\"common\");\n\t}\n\telse if(episodetype==\"R\")\n\t{\n\t\tepisode1=getLabel(\"Common.external.label\",\"common\");\n\t}\n\n\tvar dialogTop\t\t\t= \"200\";\n\tvar dialogHeight\t\t= \"42\" ;\n\tvar dialogWidth\t\t\t= \"70\" ;\n\tvar features\t\t\t= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar arguments\t\t\t= \"\" ;\n\tvar search_desc\t\t\t=\"\";\t\n\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&\"+\"episodetype=\"+episodetype+\"&\"+\"episodeid=\"+episodeid+\"&\"+\"visitid=\"+visitid+\"&\"+\"patientid=\"+patientid+\"&episode1=\"+episode1;\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLFinDtlQryMain.jsp?\"+param,arguments,features);\n}\n\n</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'100%\'>\n\n<tr>\n\t<td width=\'60%\'></td>\n\t<td class=\'PATIENTLINECOLOR\' width=\'40%\' style=\'position:relative;\' nowrap style=\"cursor:pointer;\" onClick=\"call_bl_fin_dtls();\"><font  size=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'><div align=\'right\' title=\"Financial Details\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</div></td>\n</tr>\n</table>\n\n<INPUT TYPE=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n<INPUT TYPE=\"hidden\" name=\"title\" id=\"title\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<INPUT TYPE=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n<INPUT TYPE=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<INPUT TYPE=\"hidden\" name=\"visit_id\" id=\"visit_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<INPUT TYPE=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
Connection con = ConnectionManager.getConnection(request);
	try
	{
		
		//PreparedStatement pstmt = null ;
		//ResultSet rs = null; ResultSet rs23 = null; 
		//Statement stmt=null;
		CallableStatement call=null;

		request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");

		//String fin_tab_banner="";

		String login_user =  p.getProperty("login_user");
		if(login_user==null) login_user="";

		String facility_id = (String)httpSession.getValue("facility_id");
		if(facility_id==null) facility_id="";	

		String title= (String)httpSession.getValue("title");
		if(title==null) title="";

		String episode_type=request.getParameter("episodetype");
		if(episode_type==null) episode_type="";

		String episode_id=request.getParameter("episodeid");
		if(episode_id==null) episode_id="";

		String visit_id=request.getParameter("visitid");
		if(visit_id==null) visit_id="";

		String patient_id=request.getParameter("patientid");
		if(patient_id==null) patient_id="";

/*
		System.out.println("facility_id:"+facility_id);
		System.out.println("patient_id:"+patient_id);
		System.out.println("episode_type:"+episode_type);
		System.out.println("episode_id:"+episode_id);
		System.out.println("visit_id:"+visit_id);
		System.out.println("locale:"+locale);
*/
	
		String banner_qry="";
		
		try
		{
			call = con.prepareCall("{ ? = call   BL_PROC_ITEM_VALIDATIONS_MP.GET_PATIENT_BANNER(?,?,?,?,?)}");	
			call.registerOutParameter(1,java.sql.Types.VARCHAR);
			call.setString(2,facility_id);
			call.setString(3,patient_id);
			call.setString(4,episode_id);
			call.setString(5,visit_id);
			call.setString(6,locale);
			call.execute();
		
			banner_qry = call.getString(1);		
//			System.out.println("banner_qry:"+banner_qry);
			if ( banner_qry == null ) banner_qry = "";

			call.close();	
		}
		catch(Exception e)
		{
			System.out.println("Exception in banner qry:"+e);
		}

//		System.out.println("banner_qry:"+banner_qry);


            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((banner_qry.length()>50?"-5":"2")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(banner_qry));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	catch(Exception e)
	{
		System.out.println("Exception in the Main Try:"+e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);				
    }

            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
