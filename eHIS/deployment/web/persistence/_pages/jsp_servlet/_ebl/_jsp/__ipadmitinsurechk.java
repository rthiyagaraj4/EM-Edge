package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ipadmitinsurechk extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/IPAdmitInsureChk.jsp", 1743571439669L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<script>\n\tasync function showPackage(patId)\n\t{\t\t\t\n\t\tparent.Main_frame.document.forms[0].package_flag.value=\'Y\';\n\t\tvar retVal;\n\t\tvar dialogHeight= \"20\" ;\n\t\tvar dialogWidth\t= \"50\" ;\n\t\tvar dialogTop = \"150\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar patient_id = patId;\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"QueryPackageDetails.jsp?patient_id=\"+patient_id+\"&mode=IP\";\n\t\tretVal =await window.showModalDialog(url,arguments,features);\n\t\t\n\t//\tif ((retVal!=null) && (retVal!=\"\")) parent.frames[1].document.forms[0].pkg_sel.value = \"Y\";\n\t\tvar returnArray = new Array();\n\t\tif ((retVal!=null) && (retVal!=\"\")) returnArray = retVal.split(\",\");\n\t\tif(returnArray.length>0)\n\t\t{\n\t\t\tparent.Main_frame.document.forms[0].pkg_bill_type.value = returnArray[0];\n\t\t\tparent.Main_frame.document.forms[0].pkg_bill_no.value = returnArray[1];\n\t\t} \n\t}\n</script>\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n/*\t\t\t\t\t\tif(window.confirm(\'The Insurance Policy of the patient has expired.\\nDo you want to modify the Financial Details?\\n\\nClick OK to continue. Click Cancel to stop.\')==true)\n*/\n\t\t\t\t\t\tif(window.confirm(getMessage(\'BL9320\',\'BL\')==true)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.Main_frame.tab_click(\'findtl_tab\');\n\t\t\t\t\t\t\tif(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =") showPackage(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\n\t\t\t\t\t\t} \n\t\t\t\t\t\telse{\n\n\t\t\t\t\t\t\tparent.Select_frame.document.forms[0].patient_id.value=\'\';\n\t\t\t\t\t\t\tparent.Select_frame.document.forms[0].patient_id.focus();\n\t\t\t\t\t\t\tparent.Select_frame.document.forms[0].encounter_id.focus();\t\n\t\t\t\t\t\t\tparent.Select_frame.document.forms[0].patient_id.focus();\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
	String patId = request.getParameter("patientId");
	String facilityId = (String)session.getValue("facility_id"); 

	Connection con = null;
	//Statement stmt = null;
	ResultSet rs1 = null;
	PreparedStatement pstmt = null;
	//String retVal="";
	boolean packageDetReq = false;
	
	try 
	{
		con	=	ConnectionManager.getConnection(request);
		//stmt = con.createStatement();

		String pSql = "select count(*) ct from bl_package_trn_hdr a, bl_package_codes b "+
						"where a.patient_id = ? and a.package_code = b.package_code and "+
						"nvl(a.closed_yn, 'N') not in ('A', 'I') and nvl(a.bill_status, 'N') = 'N' and "+
						"nvl(a.expiry_date, trunc(sysdate)) >= trunc(sysdate) and nvl(b.apply_to, 'N') in ('B', 'I')";
		//rs1 = stmt.executeQuery(pSql);
		pstmt = con.prepareStatement(pSql);
		pstmt.setString(1, patId);
		rs1 = pstmt.executeQuery();
		if(rs1.next()) {
			if(rs1.getInt("ct")>0) packageDetReq=true;
		}	
		if (rs1 != null)   rs1.close();

		
		String sql = "select POLICY_EXPIRY_WARNING_PERIOD, Policy_expiry_date, "+
					"decode(sign(trunc(policy_expiry_date)-trunc(sysdate)),-1,'E','U') ins_chk, "+
					"decode(sign((trunc(policy_expiry_date) - trunc(sysdate)) - POLICY_EXPIRY_WARNING_PERIOD),-1,(trunc(policy_expiry_date) - trunc(sysdate)),0) warn_days "+
					"from bl_patient_fin_dtls a, ip_param b "+
					"where policy_type_code is not null and facility_id=? and patient_id=? ";
		
		//rs1 = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, facilityId);
		pstmt.setString(2, patId);
		rs1 = pstmt.executeQuery();
		if(rs1.next()) {
			if(rs1.getString("ins_chk").equals("E")) {
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(packageDetReq));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patId));
            _bw.write(_wl_block8Bytes, _wl_block8);

			}		
			else if(rs1.getInt("warn_days")>0){
/*				out.println("<script>alert('The Insurance policy of the patient will expire with in the next "+rs1.getInt("warn_days")+" days')</script>");
*/
				out.println("<script>alert(getMessage('BL9542','BL')+rs1.getInt('warn_days'));</script>");

				
				if(packageDetReq){
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
				}
			}
			else {
				if(packageDetReq){
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
				}
			}
		}
		else {
			if(packageDetReq) {
					out.println("<script>if(!(parent.Select_frame.document.forms[0].patient_id.value=='')) showPackage('"+patId+"')</script>");
			}
		}		
		if (rs1 != null)   rs1.close();
	}
	catch(Exception e) {
		out.println(e.toString());
	}
	finally {
		
		if(pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con, request);

	}

            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
