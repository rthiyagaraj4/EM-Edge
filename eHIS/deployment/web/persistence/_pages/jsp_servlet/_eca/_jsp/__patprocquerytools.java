package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patprocquerytools extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatProcQueryTools.jsp", 1709116020091L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"javascript\" src=\"../../eCA/js/procedures.js\" ></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body onMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t<form name=\'Proc_toolForm\' id=\'Proc_toolForm\'>\n\t<br>\n\t\t<table border=\'0\' width=\'100%\' cellpadding=\'3\' cellspacing=\'0\'>\n         <tr>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<td align=\'left\'>\n \t\t\t\t\t\t<input type=\'button\' name=\'btnView\' id=\'btnView\' onclick=\"showErrorList();\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"  class=\'button\'></td>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t\t\t<td align=\'right\'> \n\t\t\t\t\t<input type=\"button\" class=\'Button\' name=\"cannedText\" id=\"cannedText\" title=\'Canned Text\' onclick=\"return canTextValue();\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<input type=\'button\'  name=\'error\' id=\'error\' onclick=\"markError()\" class=\'button\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<input type=\"button\" class=\'Button\' name=\"record_button\" id=\"record_button\" title=\'Record\' onclick=\"apply()\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"button\" class=\'Button\' name=\"clear_button\" id=\"clear_button\" title=\'Clear\' value=\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \" onclick=\"clearform(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\">\n\t\t\t<!-- <input type=\"button\" class=\'Button\' name=\"cancel_button\" id=\"cancel_button\" title=\'Cancel\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  onclick=\"cancel_a(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\"> --></td>\n\t\t</tr>\n        </table>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar msg = getLabel(\'Common.Modify.label\',\'COMMON\');\t\n\t\t                //alert(\"msg\"+msg);\n\t\t\t\t\t\tdocument.forms[0].record_button.title = msg;\n\t\t\t\t\t\tdocument.forms[0].record_button.value = msg;\n\t\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].record_button.style.display = \'none\';\n\t\t\t\t\t\tdocument.forms[0].cannedText.style.display = \'none\';\n\t\t\t\t\t\t\n\n\t\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<input type=\"hidden\" name=\"objName\" id=\"objName\"   value=\'\'>\n\t\t<input type=\"hidden\" name=\"Encounter_Id\" id=\"Encounter_Id\"   value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"   value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"   value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n\t\t<input type=\"hidden\" name=\"viewErrButton\" id=\"viewErrButton\"   value=\'\'>\n\t\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		Connection con=null;
		PreparedStatement pstmt=null;		
		ResultSet rset=null;		
		String applied="";
		String rec_exist="";		
		String modify = "";
		String sql="";
		String Encounter_Id=request.getParameter("Encounter_Id");
		
		String modal_yn = request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");
		String viewErrButton = request.getParameter("viewErrButton")==null?"N":request.getParameter("viewErrButton");
		String errorModify=request.getParameter("errorModify")==null?"N":request.getParameter("errorModify");
		String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	
		String resp_id = (String)session.getValue("responsibility_id");
		String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
		String facilityid = (String) session.getValue("facility_id");

		try
		{
			con=ConnectionManager.getConnection(request);
	
			sql="SELECT GET_TASK_APPLICABILITY('MARK_PROC_ERROR',NULL,?,?,?,?,?), nvl((SELECT 'Y' FROM pr_encounter_procedure WHERE PATIENT_ID=? AND ERROR_YN='Y' AND ROWNUM=1),'N') ERR_EXIST, GET_TASK_APPLICABILITY('MOIDFY_PROCEDURE',NULL,?,?,?,?,?) FROM DUAL";
					
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,resp_id);
			pstmt.setString(2,reln_id);
			pstmt.setString(3,facilityid);
			pstmt.setString(4,Encounter_Id);
			pstmt.setString(5,patient_id);
			pstmt.setString(6,patient_id);
			pstmt.setString(7,resp_id);
			pstmt.setString(8,reln_id);
			pstmt.setString(9,facilityid);
			pstmt.setString(10,Encounter_Id);
			pstmt.setString(11,patient_id);
			rset=pstmt.executeQuery();

			if (rset.next())
			{
				applied = rset.getString(1);
				rec_exist = rset.getString(2);
				modify = rset.getString(3);			
			}

			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();		
		}

		catch(Exception e)
		{
			//out.println("Exception "+e.toString());//COMMON-ICN-0181
                        e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);

		}

            _bw.write(_wl_block8Bytes, _wl_block8);
	
			if(viewErrButton.equals("Y"))
				rec_exist="Y";
				
				if(applied!=null && applied.equals("A"))
				{ 
					if (rec_exist.equals("Y")) 
					{
			
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);

					}
				}
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CannedText.label","ca_labels")));
            _bw.write(_wl_block12Bytes, _wl_block12);
	
				if(applied!=null && applied.equals("A"))
				{ 
					if(errorModify.equals("Y")) 
					{ 
			
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")));
            _bw.write(_wl_block14Bytes, _wl_block14);

					}
				}
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);

			
			if(mode.equals("update"))
			{
				if(modify.equals("A"))
				{
		
            _bw.write(_wl_block21Bytes, _wl_block21);

				}
				else
				{
		
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			}
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(Encounter_Id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
