package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import javax.naming.*;
import javax.ejb.*;
import java.rmi.*;
import javax.rmi.*;
import java.util.*;
import com.ehis.util.*;

public final class __patientquicksearchresultmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PatientQuickSearchResultMain.jsp", 1714107639663L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\";\n\t\t\t\t\t \n                     parent.messageFrame.document.write(HTMLVal);\n                     parent.messageFrame.document.form1.submit(); \n                }\n               async  function ViewPatDtl(Pat_id)\n                {\n\t\t\t\t\tPat_id=unescape(Pat_id)\n                    var url         = \"../jsp/ViewPatDetailsMain.jsp?Patient_ID=\"+escape(Pat_id);\n                    var dialogTop       = \"65\";\n                    var dialogHeight    = \"40\"; //33.4\n                    var dialogWidth     = \"65\";\n                    var arguments   = \"\" ;\n                    var features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; dialogTop:\" + dialogTop +\"; status=no;\";\n                    var returnval = await window.showModalDialog( url, arguments, features ) ;\n                }\n\t\t\t</script>\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<iframe name=\'PatIdResult\' id=\'PatIdResult\' src=\"../../eCommon/html/blank.html\" frameborder=0  framespacing=0 noresize scrolling=\'NO\'></iframe>\n<script>\n\t\t\tvar htmlVal=\"<html><body onKeyDown=\'lockKey()\'><form name=\'f1\' id=\'f1\' action=\'../../eMP/jsp/PatientQuickSearchResult.jsp\' method=\'post\'>\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'pat_id1\' id=\'pat_id1\' value=\\\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'national_id_no1\' id=\'national_id_no1\' value=\\\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'alt_id1_no1\' id=\'alt_id1_no1\' value=\\\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\\\">\t\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'alt_id2_no1\' id=\'alt_id2_no1\' value=\\\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'alt_id3_no1\' id=\'alt_id3_no1\' value=\\\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'alt_id4_no1\' id=\'alt_id4_no1\' value=\\\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'First_Name1\' id=\'First_Name1\' value=\\\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'Second_Name1\' id=\'Second_Name1\' value=\\\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'Third_Name1\' id=\'Third_Name1\' value=\\\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'Family_Name1\' id=\'Family_Name1\' value=\\\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'first_name_loc_lang1\' id=\'first_name_loc_lang1\' value=\\\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'second_name_loc_lang1\' id=\'second_name_loc_lang1\' value=\\\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'third_name_loc_lang1\' id=\'third_name_loc_lang1\' value=\\\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'family_name_loc_lang1\' id=\'family_name_loc_lang1\' value=\\\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\\\">\"+\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'pr_resNo1\' id=\'pr_resNo1\' value=\\\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'oth_no1\' id=\'oth_no1\' value=\\\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'search_in\' id=\'search_in\' value=\\\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'func_act\' id=\'func_act\' value=\\\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'act_yn\' id=\'act_yn\' value=\\\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\\\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'order_by1\' id=\'order_by1\' value=\\\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\\\">\"+\t\n\t\t\t\t\t\t\"<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\\\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\\\">\"+\t\n\t\t\t\t\t\t\"</form></body></html>\"\n\t\t\t\n\t\t\tPatIdResult.document.write(htmlVal);\n\t\t\tPatIdResult.document.f1.submit(); \t\t\t\n</script>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<input type=\"hidden\" name=\"pat_id1\" id=\"pat_id1\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\"hidden\" name=\"national_id_no1\" id=\"national_id_no1\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\"hidden\" name=\"alt_id1_no1\" id=\"alt_id1_no1\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"alt_id2_no1\" id=\"alt_id2_no1\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"alt_id3_no1\" id=\"alt_id3_no1\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"alt_id4_no1\" id=\"alt_id4_no1\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"pr_resNo1\" id=\"pr_resNo1\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"oth_no1\" id=\"oth_no1\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"search_in\" id=\"search_in\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"func_act\" id=\"func_act\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"act_yn\" id=\"act_yn\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\n</HTML>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );
	
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
//String locale			= (String)session.getAttribute("LOCALE");
Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rSet = null;
String pat_id1			= request.getParameter("pat_id1");
String valid_patient_id="";
boolean continueFlag=true;
pat_id1=pat_id1.toUpperCase();
String national_id_no1	= request.getParameter("national_id_no1");
String alt_id1_no1		= request.getParameter("alt_id1_no1");
String alt_id2_no1		= request.getParameter("alt_id2_no1");
String alt_id3_no1		= request.getParameter("alt_id3_no1");
String alt_id4_no1		= request.getParameter("alt_id4_no1");
String pr_resNo1		= request.getParameter("pr_resNo1");
String oth_no1			= request.getParameter("oth_no1");
String search_in		= request.getParameter("search_in");
String func_act			= request.getParameter("func_act");
String act_yn			= request.getParameter("act_yn");
String function_id		= request.getParameter("function_id");
String First_Name1		= checkForNull(request.getParameter("First_Name1"));
String Second_Name1		= checkForNull(request.getParameter("Second_Name1"));
String Third_Name1		= checkForNull(request.getParameter("Third_Name1"));
String Family_Name1		= checkForNull(request.getParameter("Family_Name1"));
String first_name_loc_lang1		= checkForNull(request.getParameter("first_name_loc_lang1"));
String second_name_loc_lang1		= checkForNull(request.getParameter("second_name_loc_lang1"));
String third_name_loc_lang1		= checkForNull(request.getParameter("third_name_loc_lang1"));
String family_name_loc_lang1		= checkForNull(request.getParameter("family_name_loc_lang1"));
String order_by1		= checkForNull(request.getParameter("order_by1"));
String gender		= checkForNull(request.getParameter("gender"));

//For Duplicate Patient ID validation
if (!search_in.equals("D")&&(function_id.equals("") || function_id.equals("PAT_REG") ||func_act.equals("DuplicateRegistration") || 	function_id.equals("NEWBORN_REG"))){
	pstmt = conn.prepareStatement("select valid_patient_id from dr_mp_patient where duplicate_patient_id = ?");
	pstmt.setString(1,pat_id1);
	rSet=pstmt.executeQuery();
	if (rSet!=null && rSet.next())
		valid_patient_id = rSet.getString("valid_patient_id");
	if (valid_patient_id==null) valid_patient_id = "";
	if (search_in.equals("P") && !valid_patient_id.equals("")){
			out.println("<script>");
			out.println("for (var i=0;i<parent.criteria.document.forms[0].elements.length;i++) {parent.criteria.document.forms[0].elements[i].disabled=false;}");
			out.println("parent.search_toolbar.document.forms[0].Search.disabled = false;");
			out.println("if(parent.criteria.document.forms[0].maintain_doc_or_file.value == 'D') {");
			out.println("parent.criteria.document.forms[0].MRN.disabled = true;");
			out.println("parent.criteria.document.forms[0].OldFileNo.disabled = true; }");
			out.println("parent.criteria.enableRegister()");
			out.println("</script>");
			if (function_id.equals("DR_VALID_DUPLICATE_PATIENT") || function_id.equals("DR_ENTER_DUPLICATES") || function_id.equals("DR_MERGED_PATIENT_ID") || 												function_id.equals("DR_EXCLUDE_POSSIBLE_PATIENTS") 	|| function_id.equals("DR_EXCLUDED_PATIENT_ID"))
				out.println("<script>parent.criteria.document.forms[0].search_in.disabled=true;</script>");			
			out.println("<script>if (parent.criteria.document.forms[0].searchby1 !=null) if (parent.criteria.document.forms[0].searchby1.value =='') parent.criteria.document.forms[0].searchby1.disabled=true;</script>");
			out.println("<script>parent.commontoolbar.location.href='../jsp/PatientSearchToolBar.jsp'</script>");		
			out.println("<script>var msg = parent.criteria.getMessage('PAT_MERGED_VALID','MP');msg= msg.replace('#','"+valid_patient_id+"');alert(msg);</script>");			out.println("<script>parent.criteria.document.forms[0].Patient_Id1.value='"+valid_patient_id+"';parent.search_toolbar.document.forms[0].Search.focus();</script>");
			continueFlag=false;
	}
}
if(!continueFlag){
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pat_id1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(national_id_no1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(alt_id1_no1));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(alt_id2_no1));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(alt_id3_no1));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(alt_id4_no1));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(First_Name1));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(Second_Name1));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Third_Name1));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Family_Name1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(first_name_loc_lang1));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(second_name_loc_lang1));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(third_name_loc_lang1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(family_name_loc_lang1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(pr_resNo1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(oth_no1));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(search_in));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(act_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order_by1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pat_id1));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(national_id_no1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(alt_id1_no1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(alt_id2_no1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(alt_id3_no1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(alt_id4_no1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(pr_resNo1));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(oth_no1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(search_in));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(act_yn));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
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
