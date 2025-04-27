package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.StringTokenizer;
import java.util.TreeMap;
import eCommon.XSSRequestWrapper;

public final class __proccodeforpractitionerresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ProcCodeforPractitionerResult.jsp", 1709119256006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n\tCreated \n\t\ton 12/14/2010\n\t\tFor Retunin \n\t\tFunction :Procedure Code For Practitioner\n-->\n";
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

    private final static java.lang.String  _wl_block6 ="\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOA/js/ProcCodeforPractitioner.js\'></script>\n\t\t<!-- in below line only one line added by VenkateshS (4008) on 23 /july/2012 -->\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t</head>\n\t<!-- in below line  this method only  \"onKeyDown = lockKey()\"  added by VenkateshS (4008) on  23/july/2012  -->\n   <body onload=\"paintDesc()\" onKeyDown = \'lockKey()\'>\n\t\n\t\t<form name=\"Proccode_For_Pract_Result_Form\" id=\"Proccode_For_Pract_Result_Form\" action=\'../../servlet/eOA.ProccodeforpractitionerServlet\' method=\"post\" target=\'messageFrame\'>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<table border=\'0\' width=\'30%\' cellpadding=\'0\' cellspacing=\'0\' id=\"paint_data_tab\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'PANELTOOLBAR\' id=\'paint_desc\' nowrap></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<div  id=\"scroll_div\" style=\"position:relative;height:500px;width:1010px;overflow:auto;\" >\n\t\t\t\t\t\t<table border=0 width=\"100%\" cellpadding=\'0\' cellspacing=\'0\' id=\"data_tab\">\n\t\t\t\t\t\t\t<thead id=\"TabHead\">\n\t\t\t\t\t\t\t<tr style=\"position:relative;top:expression(this.offsetParent.scrollTop)\" >\n\t\t\t\t\t\t\t\t<th align=\'left\'>Practitioner</th>\n\t\t\t\t\t\t\t\t<th align=\'center\' >Select All&nbsp;<input type=\'checkbox\' name=\"select_all\" id=\"select_all\" value=\'N\' onclick=\"selectAll(this)\"></th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"linking_code_";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" id=\"linking_code_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" align=\'center\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\"linking_box_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" id=\"linking_box_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" onclick=\"setValue(this,\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\')\">\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'total_num\' id=\'total_num\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\t\t\t\t<!--\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"paint_data_tab\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"data_tab\").style.display=\"none\";\n\t\t\t\t\t\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t\t\t\t\t//-->\n\t\t\t\t\t\t\t\t\t</SCRIPT>\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t<input type=\'hidden\' name=\'final_linked_codes\' id=\'final_linked_codes\' value=\"\"/>\n\t\t<input type=\'hidden\' name=\'final_unlinked_codes\' id=\'final_unlinked_codes\' value=\"\"/>\n\t\t<input type=\'hidden\' name=\'code_to_be_link\' id=\'code_to_be_link\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t<input type=\'hidden\' name=\'link_by\' id=\'link_by\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t<input type=\'hidden\' name=\'db_linked_codes\' id=\'db_linked_codes\' value=\"\"/>\n\t\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\t<!--\n\t\t\tbuildDBValues();\n\t\t//-->\n\t\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );
	
	private String checkForNull(String inputString){
	return (inputString==null)	? "" : inputString;
}
	private String checkForNull(String inputString, String defaultValue){
	return (inputString==null)	? defaultValue : inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale			= checkForNull((String)session.getAttribute("LOCALE")); 
	String link_by		= checkForNull(request.getParameter("link_by")); 
	String link_code	= checkForNull(request.getParameter("link_code")); 
	String specialty		= checkForNull(request.getParameter("specialty")); 
	String search_by			= checkForNull(request.getParameter("search_by")); 
	String search_criteria		= checkForNull(request.getParameter("search_criteria"));
	String term_set_id			= checkForNull(request.getParameter("term_set_id"));
	String RESULT_QRY="";
	String desc_criteria="";
	String splty_criteria="";
	
	if(search_criteria.equals("S")){
		desc_criteria=search_by+"%";
	}else if(search_criteria.equals("E")){
		desc_criteria="%"+search_by;
	}else if(search_criteria.equals("C")){
		desc_criteria="%"+search_by+"%";
	}
	

	if(link_by.equals("PROC_CODE")){
		if(!specialty.equals("")){
			splty_criteria=" AND A.PRIMARY_SPECIALITY_CODE=?";
		}
		RESULT_QRY="SELECT  DISTINCT A.PRACTITIONER_ID CODE,A.PRACTITIONER_NAME SHORT_DESC,A.SHORT_NAME,(SELECT NVL(EFF_STATUS,'N')  FROM OA_PRACT_PROC_LINK WHERE PRACTITIONER_ID=A.PRACTITIONER_ID AND PROC_CODE =? AND PROC_CODING_SCHEME=?) STATUS FROM AM_PRACTITIONER_LANG_VW A WHERE  A.EFF_STATUS='E' AND UPPER(A.PRACTITIONER_NAME) LIKE UPPER(NVL(?,A.PRACTITIONER_NAME)) AND A.EFF_STATUS='E' "+splty_criteria+" ORDER BY SHORT_DESC";
	}else{
		RESULT_QRY="SELECT DISTINCT A.TERM_CODE CODE,A.LONG_DESC, A.SHORT_DESC ,(SELECT NVL(EFF_STATUS,'N') FROM OA_PRACT_PROC_LINK WHERE PRACTITIONER_ID=? AND PROC_CODING_SCHEME=A.TERM_SET_ID AND PROC_CODE=A.TERM_CODE) STATUS FROM MR_D_"+term_set_id+"_LANG_VW A WHERE A.TERM_SET_ID=? AND A.EFF_STATUS='E' AND UPPER(A.SHORT_DESC) LIKE UPPER(NVL(?,A.SHORT_DESC)) ORDER BY SHORT_DESC";
	}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

			try{
					con=ConnectionManager.getConnection(request);
					
            _bw.write(_wl_block9Bytes, _wl_block9);

										String status="";
										String box_status="";
										pstmt=con.prepareStatement(RESULT_QRY);
										pstmt.setString(1,link_code);
										pstmt.setString(2,term_set_id);
										pstmt.setString(3,desc_criteria);
										if(!specialty.equals("") && link_by.equals("PROC_CODE") ){
											pstmt.setString(4,specialty);
										}
										rs=pstmt.executeQuery();
										int i=0;
										String classValue="";
										String linking_code="";
										String display_desc="";
										while(rs.next()){
												linking_code= checkForNull(rs.getString("CODE"));
												display_desc= checkForNull(rs.getString("SHORT_DESC"));
												status=checkForNull(rs.getString("STATUS"));
												if(status.equals("Y")){
													box_status="checked";
												}else{
													box_status="";
												}	
											if(i%2==0){
												classValue="QRYEVENSMALL";
											}else{
												classValue="QRYODDSMALL";
											}
											
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(display_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(box_status));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(i));
            _bw.write(_wl_block20Bytes, _wl_block20);
i++;}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);

								if(i==0){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
						
            _bw.write(_wl_block24Bytes, _wl_block24);
}catch(Exception ex){
				//System.out.println("Exception-@-proccodeforpractitioner_result.jsp=>"+ex);
				ex.printStackTrace();
			}
			finally{
				ConnectionManager.returnConnection(con,request);	
			}
		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(link_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(link_by));
            _bw.write(_wl_block28Bytes, _wl_block28);
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
