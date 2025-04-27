package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __fmdocumentfolderaddmod extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMDocumentFolderAddMod.jsp", 1709116836747L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- by Meghanath -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<!-- <LINK rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></LINK> -->\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eFM/js/checkSystemDate.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\'></script>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\'></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eFM/js/FMDocumentFolder.js\'></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<SCRIPT>\n\t\t\tfunction DateCompare(from,to,messageFrame,getVal) \n\t\t\t{\n\t\t\t\tvar getValue = getVal;\n\t\t\t\tvar fromarray; var toarray;\n\t\t\t\tvar fromdate = from.value ;\n\t\t\t\tvar todate = to.value ;\n\t\t\t\tif(fromdate.length > 0 && todate.length > 0 ) \n\t\t\t\t{\n\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\tif(Date.parse(todt) < Date.parse(fromdt)) \n\t\t\t\t\t{\n\t\t\t\t\t\t//alert(\"APP-SM0005 To Date should be Greater than or equal to From Date\");\n\t\t\t\t\t\talert(getMessage(\"TO_DATE_LESSER_FROM_DATE\",\"FM\"));\n\t\t\t\t\t\tto.select();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\telse if(Date.parse(todt) >= Date.parse(fromdt)) \n\t\t\t\t\t{\n\t\t\t\t\t\treturn true;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\tfunction CallPatPrd()\n\t\t\t{\n\t\t\t\tif(document.DocumentFolder_Form.doc_folder_type.value == \'P\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"tab1\").innerHTML=getLabel(\"Common.patientId.label\",\"common\");\n\t\t\t\t\tdocument.getElementById(\"tab2\").innerHTML=\"<input type=\'text\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' onKeyPress=\'return CheckForSpecChars(event)\' maxlength=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' size=\\\"=patient_id_max_length+2>\\\" onBlur=\'ChangeUpperCase(this);\'><input type=\'button\' class=\'button\' name=\'pat_search\' id=\'pat_search\' value=\'?\' align=center onClick=\'patientSearch();\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\tdocument.getElementById(\"tab3\").innerHTML=\"\";\n\t\t\t\t\tdocument.getElementById(\"tab4\").innerHTML=\"\";\n\t\t\t\t}\n\t\t\t\telse if(document.DocumentFolder_Form.doc_folder_type.value == \'D\')\n\t\t\t\t{\t\n\t\t\t\t\tdocument.getElementById(\"tab1\").innerHTML=getLabel(\"Common.periodfrom.label\",\"common\");\n\t\t\t\t\tdocument.getElementById(\"tab2\").innerHTML=\"<input type=\'text\' id=\'date_from\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' size=\'10\' maxlength=\'10\' tabIndex=\'3\' value=\'\' onBlur=\'validDateObj(this,\\\"DMY\\\",localeName);\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"return  showCalendar(\'date_from\');\\\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t\tdocument.getElementById(\"tab3\").innerHTML=getLabel(\"Common.periodto.label\",\"common\");\n\t\t\t\t\tdocument.getElementById(\"tab4\").innerHTML=\"<input type=\'text\' id=\'date_to\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' size=\'10\' maxlength=\'10\'  tabIndex=\'4\' onBlur=\'validDateObj(this,\\\"DMY\\\",localeName);\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"return  showCalendar(\'date_to\');\\\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\t}\n\t\t\t\telse if(document.DocumentFolder_Form.doc_folder_type.value == \'\')\n\t\t\t\t{\n\t\t\t\t\tdocument.getElementById(\"tab1\").innerHTML=\"\";\n\t\t\t\t\tdocument.getElementById(\"tab2\").innerHTML=\"\";\n\t\t\t\t\tdocument.getElementById(\"tab3\").innerHTML=\"\";\n\t\t\t\t\tdocument.getElementById(\"tab4\").innerHTML=\"\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction ValidateString(event)\n\t\t\t{\n\t\t\t\tif((((event.keyCode>=48) && (event.keyCode<=57)) ||((event.keyCode>=65) && (event.keyCode<=90)) ||((event.keyCode>=97) && (event.keyCode<=122))\n\t\t\t\t||(event.keyCode==42)||(event.keyCode==95)||(event.keyCode==32)))\n\t\t\t\t{\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t</SCRIPT>\n\t\t</HEAD>\n\t\t<BODY onMouseDown=\'CodeArrest();\' onLoad=\'curser_focus();\' onKeyDown = \'lockKey();\'>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<FORM name=\'DocumentFolder_Form\' id=\'DocumentFolder_Form\'>\n\t\t\t<BR><BR><BR><BR><BR><BR><BR><BR><BR>\n\t\t\t\t<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'80%\' align=\'center\'>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</TD>\n\t\t\t\t\t\t<TD class=\'fields\' width=\'30%\' ><INPUT type=\'text\' name=\'doc_folder_id\' id=\'doc_folder_id\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onKeyPress=\'return CheckForSpecChars(event);\'size=\'15\' maxlength=\'10\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="><IMG src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></IMG></TD>\n\t\t\t\t\t\t<TD colspan=\'2\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR><TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>\n\t\t\t\t\t\t<TD class=\'fields\' width=\'30%\' ><INPUT type=\'text\' name=\'doc_folder_name\' id=\'doc_folder_name\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' size=\'32\' maxlength=\'30\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><IMG src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></IMG></TD>\n\t\t\t\t\t\t<TD colspan=\'2\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</TD>\n\t\t\t\t\t\t<TD class=\'fields\' width=\'30%\'><SELECT name=\'doc_folder_type\' id=\'doc_folder_type\' onChange=\'CallPatPrd();\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">&nbsp;\n\t\t\t\t\t\t\t\t<OPTION value=\'\'>-------- ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="--------</OPTION>\n\t\t\t\t\t\t\t\t<OPTION value=\'P\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</OPTION> \n\t\t\t\t\t\t\t\t<OPTION value=\'D\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</OPTION>\n\t\t\t\t\t\t\t</SELECT><IMG src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></IMG>\n\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t<TD colspan=\'2\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD id=\'tab1\' class=\'label\' width=\'20%\' ></TD>\n\t\t\t\t\t\t<TD id=\'tab2\' class=\'label\' width=\'30%\' ></TD>\n\t\t\t\t\t\t<TD id=\'tab3\' class=\'label\' width=\'20%\'></TD>\n\t\t\t\t\t\t<TD id=\'tab4\' class=\'label\' width=\'30%\' ></TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR>\n\t\t\t\t\t<TR>\n\t\t\t\t\t\t<TD class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<TD class=\'label\' width=\'30%\' ><INPUT type=\'checkbox\' name=\'eff_status\' id=\'eff_status\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="></TD>\n\t\t\t\t\t\t<TD colspan=\'2\'>&nbsp;</TD>\n\t\t\t\t\t</TR>\n\t\t\t\t\t<TR><TD colspan=\'4\'>&nbsp;</TD></TR>\n\t\t\t\t</TABLE>\n\t\t\t\t<INPUT type=\'hidden\' name=\'operation\' id=\'operation\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t\t\t\t<INPUT type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n\t\t\t\t<INPUT type=\'hidden\' name=\'chkParam\' id=\'chkParam\' value=\'Y\'>\n\t\t\t\t<INPUT type=\'hidden\' name=\'today\' id=\'today\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n\t\t\t</FORM>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<SCRIPT>\n\t\t\t\tdocument.getElementById(\"tab1\").innerHTML=getLabel(\"Common.patientId.label\",\"common\");\n\t\t\t\tdocument.getElementById(\"tab2\").innerHTML=\"<input type=\'text\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=\\\"=patient_id_max_length+2\\\" onBlur=\'ChangeUpperCase(this);\'><input type=\'button\' class=\'button\' name=\'pat_search\' id=\'pat_search\' value=\'?\' align=center onClick=\'patientSearch();\'><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\tdocument.getElementById(\"tab3\").innerHTML=\"\";\n\t\t\t\tdocument.getElementById(\"tab4\").innerHTML=\"\";\n\t\t\t</SCRIPT>\t\t\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<SCRIPT>\n\t\t\t\tdocument.getElementById(\"tab1\").innerHTML=getLabel(\"Common.periodfrom.label\",\"common\");\n\t\t\t\tdocument.getElementById(\"tab2\").innerHTML=\"<input type=\'text\' id=\'date_from\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' size=\'10\' maxlength=\'10\' tabIndex=\'3\' value=\'\' onBlur=\'validDateObj(this,\\\"DMY\\\",localeName);\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"return showCalendar(\'date_from\');\\\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t\tdocument.getElementById(\"tab3\").innerHTML=getLabel(\"Common.periodto.label\",\"common\");\n\t\t\t\tdocument.getElementById(\"tab4\").innerHTML=\"<input type=\'text\' id=\'date_to\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' size=\'10\' maxlength=\'10\'  tabIndex=\'4\' onBlur=\'validDateObj(this,\\\"DMY\\\",localeName);\'><input type=\'image\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\\\"return showCalendar(\'date_to\');\\\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\";\n\t\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\t\n\t</BODY>\n</HTML>\n\t\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

			String facility_id	= (String) session.getValue("facility_id");
			Connection conn		= ConnectionManager.getConnection(request);
			Statement stmt      = null;
			ResultSet rst	    = null;
			
			String more_attribute			= "";
			String patient_id				= "";
			String from_period				= "";
			String to_period				= "";
			String patient_id_max_length    = "";
			String patient_attribute		= "";
			String period_attribute			= "";	
			String today					= "";

			stmt= conn.createStatement();
			String sql = "SELECT patient_id_length FROM mp_param";
			try
			{
				rst = stmt.executeQuery(sql);
				if(rst != null && rst.next())
				{
					patient_id_max_length = rst.getString("patient_id_length");
				}
				if(rst  != null) rst.close();
				String todaysql = "select to_char(sysdate,'dd/mm/yyyy')today from dual";
				rst = stmt.executeQuery(todaysql);
				if (rst != null && rst.next())
				{
					today = rst.getString("today");
				}
				if(rst  != null) rst.close();
			}
			catch(Exception e){}

            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(from_period));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(to_period));
            _bw.write(_wl_block12Bytes, _wl_block12);
		
		try
		{
			String mysql					= "";
			String mode						= "";
			String doc_folder_id			= "";
			String doc_folder_name			= "";
			String p_doc_fld_id				= "";
			String patient_period_specific	= "";
			String IDreadonly_attribute		= "";
			String Nameread_attribute		= "";
			String effstatus				= "E";
			String chk_attribute			= "checked";
						
			mode	= request.getParameter("operation");
			if(mode == null || mode.equals("null"))
				mode = "";
			if(mode.equals("modify"))
			{
				p_doc_fld_id	= request.getParameter("doc_fld_id");
				if(p_doc_fld_id == null || p_doc_fld_id.equals("null"))
					p_doc_fld_id = "";

				mysql = " SELECT doc_folder_id,doc_folder_name,patient_period_specific,patient_id,to_char(from_period,'DD/MM/YYYY') from_period,to_char(to_period,'DD/MM/YYYY') to_period,eff_status FROM fm_doc_folder where facility_id = '"+facility_id+"' and doc_folder_id = '"+p_doc_fld_id+"' ";
				
				rst  = stmt.executeQuery(mysql);
				while(rst !=null && rst.next())
				{
					doc_folder_id			= rst.getString("doc_folder_id");
					doc_folder_name			= rst.getString("doc_folder_name");
					patient_period_specific = rst.getString("patient_period_specific");
					patient_id				= rst.getString("patient_id");
					from_period				= rst.getString("from_period");
					to_period				= rst.getString("to_period");
					effstatus				= rst.getString("eff_status");
				}
				if(p_doc_fld_id == null || p_doc_fld_id.equals("null"))
					p_doc_fld_id = "";
				if(doc_folder_name == null || doc_folder_name.equals("null"))
					doc_folder_name = "";
				if(patient_period_specific == null || patient_period_specific.equals("null"))
					patient_period_specific = "";
				if(patient_id == null || patient_id.equals("null"))
					patient_id = "";
				if(from_period == null || from_period.equals("null"))
					from_period = "";
				if(to_period == null || to_period.equals("null"))
					to_period = "";
				if(effstatus == null || effstatus.equals("null"))
					effstatus = "";
				
				if(patient_period_specific.equals("P"))	
					patient_attribute = "selected";
				else if(patient_period_specific.equals("D"))
					period_attribute = "selected";
				
				if(effstatus.equals("E"))
				{
					chk_attribute = "checked";
				}
				else if(effstatus.equals("D"))
				{
					chk_attribute  = "";
					Nameread_attribute = "readonly";
				}
				IDreadonly_attribute = "readonly";
				more_attribute	   = "disabled";	
			}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(doc_folder_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(IDreadonly_attribute));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(doc_folder_name));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(Nameread_attribute));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(more_attribute));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_attribute));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(period_attribute));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(effstatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(chk_attribute));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(today));
            _bw.write(_wl_block31Bytes, _wl_block31);
		
		if(patient_period_specific.equals("P"))
		{

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id_max_length));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
		else if(patient_period_specific.equals("D"))
		{

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(from_period));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(to_period));
            _bw.write(_wl_block36Bytes, _wl_block36);

		}

		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
		finally
		{
			if(rst  != null) rst.close();
			if(stmt != null) stmt.close();

			ConnectionManager.returnConnection(conn,request);
		}

            _bw.write(_wl_block37Bytes, _wl_block37);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
