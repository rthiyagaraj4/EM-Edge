package jsp_servlet._ebl._jsp;

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

public final class __blapprstatustrackmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLApprStatusTrackMain.jsp", 1709721010326L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n<HEAD>\n</HEAD>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n\t\t\n\t\t<script language=\'javascript\' src=\'../../eBL/js/BLApprStatusTrackSearch.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n  <iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'../../eCommon/jsp/commonToolbar.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' frameborder=0 scrolling=\'no\' noresize style=\"height:7vh;width:100vw\"></iframe>\n\t\t<iframe name=\'tabFrame\' id=\'tabFrame\' src=\'../../eBL/jsp/PreAuthEclaimStsTab.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&validInsUser=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&PreAuthEclaimYN=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&validFrontUser=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&apprvSts_AAKHYN=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 scrolling=\'\' noresize style=\"height:5vh;width:100vw\"></iframe>\n\t\t<iframe name=\'BLApprStatusTrackQueryFrame\' id=\'BLApprStatusTrackQueryFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'\' noresize style=\"height:81vh;width:100vw\"></iframe>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<!-- <iframe name=\'dummy\' id=\'dummy\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'\' noresize></iframe> \n\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'\' noresize></iframe> \n\t\t -->\n\t\t <iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\"height:7vh;width:100vw\"></iframe>\t\t\t\n\t\t  \n\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n   <iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'\tsrc=\'../../eCommon/jsp/commonToolbar.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'  frameborder=0  noresize scrolling=\"no\" style=\"height:7vh;width:100vw\">\n\t\t\t<iframe name=\'BLApprStatusTrackQueryFrame\' id=\'BLApprStatusTrackQueryFrame\' src=\'../../eBL/jsp/BLApprStatusTrackQueryFrame.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' frameborder=0  noresize style=\"height:80vh;width:100vw\"></iframe>\t\n\t\t\t<iframe name=\'dummy\' id=\'dummy\'\t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize  style=\"height:5vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\'dummyFrame\' id=\'dummyFrame\'\t\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize  style=\"height:5vh;width:100vw\"></iframe>\n\t\t\t<iframe name=\'messageFrame\' id=\'messageFrame\'\t src=\'../../eCommon/jsp/error.jsp\' frameborder=0 noresize scrolling=\'auto\' noresize style=\"height:5vh;width:100vw\"></iframe>\t  \n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<script>\n\t\talert(getMessage(\'BL0968\',\'BLEXT\'));\n\t\t//alert(\"Privilege is not provided for Login User. Cannot Proceed\");\n\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';\n\t</script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			String userId = (String) session.getAttribute("login_user");
			String responsibility_id=(String)session.getAttribute("responsibility_id");	
			String facility_id  =  (String) session.getValue("facility_id") ;
			System.err.println("userId BLApprStatusTrackMain.jsp=>"+userId);
			System.err.println("responsibility_id "+responsibility_id);
			System.err.println("facility_id "+facility_id);
			System.err.println("request "+session.getAttribute("site_id"));
			
			String validInsUser = "";
			String validFrontUser = "";
			String p_privilege_val = "";
			String p_allowed_yn = "";
			String functionID	= 	"APPR_STATUS_DASHBOARD";
			String privilegeIns	= 	"APPR_STATUS_INS_TEAM";
			String privilegeFront	= 	"APPR_STATUS_FRONT_OFFICE";
			Connection con = null;
			boolean  apprvSts_AAKH= false;
			String apprvSts_AAKHYN = "N";	//V230425-AAKH-CRF-0152
			//NMC-JD-CRF-0102.2
			boolean  PreAuthEclaim = false;
			String PreAuthEclaimYN = "N";	
			
			
			try
			{
				con	=	ConnectionManager.getConnection(request);
				//V230425
				try {
					apprvSts_AAKH = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "APPR_STS_TRACK_FOR_AAKH");
				if (apprvSts_AAKH)
					apprvSts_AAKHYN = "Y";
				else
					apprvSts_AAKHYN = "N";
				  } catch (Exception ex) {
					ex.printStackTrace();
					System.err.println("Exception in apprvSts_AAKH " + ex);
				}
				System.err.println("apprvSts_AAKHYN " + apprvSts_AAKHYN);
				//NMC-JD-CRF-0102.2
				try {
					PreAuthEclaim = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "PREAUTH_ECLAIM_STS_TRCK");
					//PreAuthEclaim = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "UPLOAD_CLARIFICATION_DOC");
				if (PreAuthEclaim)
					PreAuthEclaimYN = "Y";
				else
					PreAuthEclaimYN = "N";
				  } catch (Exception ex) {
					ex.printStackTrace();
					System.err.println("Exception in PreAuthEclaim " + ex);
				}
				System.err.println("PreAuthEclaim " + PreAuthEclaim);
				
				if(PreAuthEclaim){
					functionID	= 	"EBL_TRANS_PRE_AUTH_CLAIM_STS";
					privilegeIns = 	"PRE_AUTH_ECLAIMS_STATUS";
				}
				//NMC-JD-CRF-0102.2
				//V230425
				CallableStatement cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
				cstmt1.setString(1, facility_id);			
				cstmt1.setString(2, userId);			
				cstmt1.setString(3, responsibility_id);			
				cstmt1.setString(4, functionID);			
				cstmt1.setString(5, privilegeIns);	
				cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
				cstmt1.execute();	
				p_privilege_val = cstmt1.getString(6);
				p_allowed_yn = cstmt1.getString(7);
				System.err.println("p_privilege_val " + p_privilege_val);
				System.err.println("p_allowed_yn " + p_allowed_yn);
				System.err.println("userId " + userId);
				if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
				{
					validInsUser = "Y";
				}
				else
				{			
					validInsUser="N";
				} 
			
				
				
				if(!apprvSts_AAKH && !PreAuthEclaim){ //to restrict frontuser access for aakh and alna and allow for other -V230425
					cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
					cstmt1.setString(1, facility_id);			
					cstmt1.setString(2, userId);			
					cstmt1.setString(3, responsibility_id);			
					cstmt1.setString(4, functionID);			
					cstmt1.setString(5, privilegeFront);	
					cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
					cstmt1.execute();	
					p_privilege_val = cstmt1.getString(6);
					p_allowed_yn = cstmt1.getString(7);
					if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
					{
						validFrontUser = "Y";
					}
					else
					{			
						validFrontUser="N";
					} 
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			System.err.println("PreAuthEclaimYN main-" + PreAuthEclaimYN);
			System.err.println("validInsUser " + validInsUser);
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			
			//validInsUser="Y";

            _bw.write(_wl_block4Bytes, _wl_block4);
if(validInsUser.equals("Y") && PreAuthEclaimYN.equals("Y")){

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(params));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(validInsUser));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(PreAuthEclaimYN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(validFrontUser));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apprvSts_AAKHYN));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);
	
}
else if(validInsUser.equals("Y") || validFrontUser.equals("Y") ){
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(params));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(validInsUser));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(validFrontUser));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(apprvSts_AAKHYN));
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block16Bytes, _wl_block16);
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
