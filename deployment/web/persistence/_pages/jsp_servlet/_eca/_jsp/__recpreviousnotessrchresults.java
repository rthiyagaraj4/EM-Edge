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

public final class __recpreviousnotessrchresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecPreviousNotesSrchResults.jsp", 1709116227590L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n<head>\n\t<title>Recorded Previous Notes Search Result</title>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart1.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesFileUpload.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n<script>\nfunction scrollTitleBar()\t//function to make the heading of the table static\n{\n\tvar scrollXY = document.body.scrollTop;\n\t\tdocument.getElementById(\"divTitleTable\").style.position = \'relative\';\n\t\tdocument.getElementById(\"divTitleTable\").style.posTop  = scrollXY-1;\n\t\t\n}\n</script>\t\n<style>\n\t\t.gridDataSelect\n\t\t{\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #FFFFFF;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t\tborder-bottom:1px;\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\t\n\t\t\tbackground-color: #2E9AFE;\t\n\t\t\tborder-style:solid;\n\t\t\tborder-color:#EEEEEE;\n\t\t}\n</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\' onScroll=\'scrollTitleBar()\'>\n<center>\n<form name=\'RecClinicalNotesSearchResultForm\' id=\'RecClinicalNotesSearchResultForm\' action=\"\" method=\"\" target=\"\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\t\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<table  class=\'gridComponentHolder\' WIDTH=\'100%\' align=\'center\'  >\n\t\t\t\t\t<tr><td CLASS=\'BODYCOLORFILLED\' >&nbsp;</td>\t\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<td class=\'LABEL\'  width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/RecPreviousNotesSrchResults.jsp?lower_limit=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&upper_limit=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&note_group=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&note_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&facility=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&defaultval=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&defaultval1=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&defaultval2=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&defaultval3=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&defaultval4=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&ID=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\"text-decoration:none;  font-weight:bold\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t<td class=\'LABEL\' align=\'center\' width=\'8%\'><a class=\'gridLink\' href=\"../../eCA/jsp/RecPreviousNotesSrchResults.jsp?lower_limit=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" style=\"text-decoration:none; font-weight:bold\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<table class=\'grid\' width=\'100%\'  align=\'center\' id=\"tablePreRec\">\n\t\t\t\t<tr id=\"divTitleTable\">\n\t\t\t\t<!-- NMC-JD-CRF-0154--start -->\n\t\t\t\t\t<td class=\'columnheadercenter\'  rowspan=\'\' width=\'\' nowrap ><a    href=\"javascript:OrderByShort(\'DATE\');\"  style=\'color:white\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</a></td>\n\t\t\n\t\t\t\t\t<td class=\'columnheadercenter\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td class=\'columnheadercenter\'  rowspan=\'\' width=\'\' nowrap ><a   href=\"javascript:callOrderBy1(\'REF\');\"  style=\'color:white\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a></td>\n\t\t\t\t\t<td class=\'columnheadercenter\' rowspan=\'\' width=\'\' nowrap ><a    href=\"javascript:callOrderBy2(\'PP\');\"  style=\'color:white\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</a></td>\n\t\t\t\t\t<td class=\'columnheadercenter\'  rowspan=\'\' width=\'\' nowrap ><a   href=\"javascript:callOrderBy3(\'AP\');\"  style=\'color:white\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</a></td>\n\t\t\t\t\t<td class=\'columnheadercenter\'  rowspan=\'\' width=\'\' nowrap ><a   href=\"javascript:callOrderBy4(\'ST\');\"  style=\'color:white\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n\t\t\t\t<!-- NMC-JD-CRF-0154--end -->\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="<tr id=\"idddd\"><td class=\'CAGROUP\' colspan=\'9\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td></tr>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<tr id=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onClick=\"showPreviousNotesView(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')\" style=\'cursor:pointer\'>\n\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t<td class=\'gridData\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t</table>\n\t\t\t\t<input type=hidden name=query_string value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n\t\t\t\t<input type=hidden name=new_query_string value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t<input type=hidden name=notifiable_code value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\n\t\t\t\t<input type=hidden name=accession_num value=\'\'>\n\t\t\t\t<input type=hidden name=function_id value=\'\'>\n\t\t\t\t<input type=hidden name=privilege_type value=\'\'>\n\t\t\t\t<input type=hidden name=forwarded_clinician_id value=\'\'>\n\t\t\t\t<input type=hidden name=action_comment value=\'\'>\n\t\t\t\t<input type=hidden name=performed_by_id value=\'\'>\n\t\t\t\t<input type=hidden name=operation_mode value=\'\'>\n\t\t\t\t<input type=hidden name=doc_linked_note_yn value=\'\'>\n\t\t\t\t<input type=hidden name=appl_task_id value=\'\'>\n\t\t\t\t<input type=hidden name=called_from value=\'\'>\t\n\t\t\t\t<input type=hidden name=rowCnt value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t\t\t\t<!--START NMC-JD-CRF-0154-->\n\t\t\t\t<input type=hidden name=facility_id value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t\t\t\t<input type=hidden name=from_date_time value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t<input type=hidden name=to_date_time value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t\t\t<input type=hidden name=ref_no value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t\t\t<input type=hidden name=note_type value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t<input type=hidden name=performed_by value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t\t\t<input type=hidden name=ID value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t\t\t<input type=hidden name=defaultval value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t<input type=hidden name=defaultval1 value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t\t\t<input type=hidden name=defaultval2 value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t<input type=hidden name=defaultval3 value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t\t\t<input type=hidden name=defaultval4 value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t\t\t<!--END NMC-JD-CRF-0154-->\n\t\t\t\t\n</center>\n</body>\n</html>\n\n\n\n\n\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

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

/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy data from same template if filled up earlier for same patient in template format.
04/09/2015	IN057368		Ramesh G										CRF-CA-GHL-CRF-0372/05 - In Day care Encounter , system lists the OP encounter Notes.
18/05/2017  IN063798		Raja S		22/05/2017		Ramesh Goli			ML-MMOH-CRF-0807
30/10/2017	IN063591		Raja S		30/10/2017		Ramesh Goli			ML-MMOH-CRF-0787
14/10/2020	IN072542		SIVABAGYAM M	14/10/2020	RAMESH G	CA-GHL-CRF-0558.1-US003/02- View Chart Summary
17/10/2023      28796           hariharan k     19/10/2023              Ramesh G                        NMC-JD-CRF-0154                                
------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	PreparedStatement	pstmtcnt	=	null;
	ResultSet			rscnt		=	null;
	
	PreparedStatement   pstmtot		= 	null;	
	ResultSet			rsot		=	null;	
	
	StringBuffer query_notes_detail	=	new StringBuffer();
	StringBuffer query_string		=	new StringBuffer();
	StringBuffer whereClause		=	new StringBuffer();

	String	function_id				=	"";
	String	classValue				=	"";
	String	facility_id				=	"";	
	String	accession_num			=	"";
	String	note_type				=	"";	
	String	note_type_desc			=	"";
	String	note_group				=	"";		
	String	appl_task_id			=	"";
	String	service_code			=	"";	
	String	service_name			=	"";
	String	event_title_desc		=	"";		
	String	event_date_time			=	"";
	String	performed_by_id			=	"";
	String	performed_by_name		=	"";
	String	authorized_by_name		=	"";
	String	status					=	"";	
	String	status1					=	"";
	String	tblrow_id				=	"";
	String	login_user_id			=	"";	
	String	clinician_id			=	"";
	String	resp_id					=	"";		
	String	operations_allowed		=	"";
	String	amendment_type			=	"";
	String	privilege_type			=	"";
	String	patient_id				=	"";	
	String	encounter_id			=	"";
	String	episode_type			=	"";
	String	lower_limit				=	"";	
	String	upper_limit				=	"";
	String	from_date_time			=	"";		
	String	to_date_time			=	"";
	String	event_status			=   "";	
	String	status_display_text		=	"";
	String	filter					=	"";
	String	strModifiedId			=	"";
	String	patient_class			=	"";
	String	other_unsigned_yn		=	"";
	String	doc_linked				=	"";
	String	doc_linked_note_yn		=	"";
	String	med_anc					=	"";
	String	contr_mod_accession_num					=	"";
	String	performed_by			=	"";
	String	ref_no			=	"";
	String doc_ref_id="";
	String encline="";
	String oldEncline="";
	String speciality_code="";
	String res_encounter_id="";
	String p_called_from="";
	String notifiable_code = ""; 
	String nf_accession_num 	=""; 
	String called_from				=	""; 
	String p_event_class_widget	="";
	String encounter_desc	=	"";
	String defaultval  = "ASC";//NMC-JD-CRF-0154 START
	String ID ="";
	String defaultval1  = "DESC";
	String defaultval2  = "DESC";
	String defaultval3  = "DESC";
	String defaultval4  = "DESC";//NM-JD-CRF-0154 END
		
	
	eCA.RecClinicalNotesPractBean pracObj = new eCA.RecClinicalNotesPractBean();	
	
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0,		colIndex			=	0;
	int		sec_count				=	0;
	facility_id			=	(request.getParameter("facility")==null) 		?	""	:	request.getParameter("facility");//NMC-JD-CRF-0154 START
	
	defaultval			=	(request.getParameter("defaultval")==null) 		?	""	:	request.getParameter("defaultval");
	defaultval1			=	(request.getParameter("defaultval1")==null) 		?	""	:	request.getParameter("defaultval1");
	defaultval2			=	(request.getParameter("defaultval2")==null) 		?	""	:	request.getParameter("defaultval2");
	defaultval3			=	(request.getParameter("defaultval3")==null) 		?	""	:	request.getParameter("defaultval3");
	defaultval4			=	(request.getParameter("defaultval4")==null) 		?	""	:	request.getParameter("defaultval4");//NMC-JD-CRF-0154 END
		
	String orderBy      =    request.getParameter("ID")==null?""   :    request.getParameter("ID");//NMC-JD-CRF-0154
	
	patient_id			=	(request.getParameter("patient_id")==null) 		?	""	:	request.getParameter("patient_id");
	encounter_id		=	(request.getParameter("encounter_id")==null) 	?	""	:	request.getParameter("encounter_id");
	patient_class		=	(request.getParameter("patient_class")==null) 	?	""	:	request.getParameter("patient_class");
	episode_type		=	(request.getParameter("episode_type")==null) 	?	""	:	request.getParameter("episode_type");
	event_status		=	(request.getParameter("status")==null) 			?	"0"	:	request.getParameter("status");	
	filter				=	(request.getParameter("filter")==null) 			?	"A"	:	request.getParameter("filter");
	function_id			=	(request.getParameter("function_id")==null) 	? 	""	:	request.getParameter("function_id");
	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
	lower_limit			=	(request.getParameter("lower_limit")==null)		?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)		?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");
	note_type			=   (request.getParameter("note_type")==null)		?	""	:	request.getParameter("note_type");
	note_group			=	(request.getParameter("note_group")==null)		?	""	:	request.getParameter("note_group");
	appl_task_id		=	(request.getParameter("appl_task_id")==null)	?	""	:	request.getParameter("appl_task_id");
	performed_by 		=   (request.getParameter("performed_by")==null)	?	""	:	request.getParameter("performed_by");
	med_anc 			=	(request.getParameter("med_anc")==null)			?	""	:	request.getParameter("med_anc");
	ref_no 				= 	(request.getParameter("ref_no")==null)			?	""	:	request.getParameter("ref_no");
	speciality_code 	= 	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");		
	notifiable_code		=	(request.getParameter("notifiable_code")==null)	?	""	:	request.getParameter("notifiable_code"); 
	nf_accession_num	=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num"); 
	called_from			=	(request.getParameter("called_from")==null)		?	""	:	request.getParameter("called_from"); 
	
	p_called_from				=	(request.getParameter("p_called_from_widget")==null)	?	""	: request.getParameter("p_called_from_widget");//CIS-CA-1490
	p_event_class_widget 		= 	(request.getParameter("p_event_class_widget") == null) 	? 	"" 	: request.getParameter("p_event_class_widget");//IN037701
	other_unsigned_yn			=	(request.getParameter("other_unsigned_yn")==null) 		?	"N"	: request.getParameter("other_unsigned_yn");
	contr_mod_accession_num 	= 	(request.getParameter("contr_mod_accession_num")==null)	?	""	: request.getParameter("contr_mod_accession_num");
	
	
	
	query_string.append("patient_id=");			query_string.append(patient_id);
	query_string.append("&encounter_id=");		query_string.append(encounter_id);
	query_string.append("&episode_type=");		query_string.append(episode_type);
	query_string.append("&function_id=");		query_string.append(function_id);
	query_string.append("&from_date_time="); 	query_string.append(from_date_time);
	query_string.append("&to_date_time="); 		query_string.append(to_date_time);
	query_string.append("&appl_task_id="); 		query_string.append(appl_task_id);
	query_string.append("&patient_class="); 	query_string.append(patient_class);
	query_string.append("&filter="); 			query_string.append(filter);
	query_string.append("&status="); 			query_string.append(event_status);
	query_string.append("&other_unsigned_yn="); query_string.append(other_unsigned_yn);
	query_string.append("&med_anc="); 			query_string.append(med_anc);
	query_string.append("&performed_by="); 		query_string.append(performed_by);
	query_string.append("&ref_no="); 			query_string.append(ref_no);
	query_string.append("&notifiable_code="); 	query_string.append(notifiable_code); 
	query_string.append("&called_from="); 		query_string.append(called_from); 
	query_string.append("&speciality_code="); 	query_string.append(speciality_code);


	from_date_time		= com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	to_date_time		= com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	
	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);

	try
	{

		con				=	ConnectionManager.getConnection(request);
		boolean restrict_rd	=false;	//IN072542
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN072542
		//IN063798 Starts
		String encounterList = "";
		if("DC".equals(patient_class) || "IP".equals(patient_class) )
		 encounterList = pracObj.getPreviousEncounter(patient_id,encounter_id,con); 
		//IN063798 Ends

		login_user_id	=	(String)		session.getValue("login_user");
		//facility_id		=	(String)		session.getValue("facility_id");hari
		resp_id			=	(String)		session.getValue("responsibility_id");
		clinician_id	 =	(String)		session.getValue("ca_practitioner_id");

		if(!(from_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time >= to_date( ?, 'dd/mm/yyyy hh24:mi' ) ");
		if(!(to_date_time.equals("")))
			whereClause.append(" 	and a.event_date_time <= to_date( ?,'dd/mm/yyyy hh24:mi' )+0.00068287 ");

		
			whereClause.append(" 	and a.event_status in ('4','5') ");

		if(!(contr_mod_accession_num.equals("")))
			whereClause.append(" 	and a.contr_mod_accession_num = ? ");
		
		
		//whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT','"+clinician_id+"','"+resp_id+"',a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		whereClause.append("and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,'CA',a.NOTE_TYPE,'CLNT',?,?,a.PERFORMED_BY_ID,a.AUTHORIZED_BY_ID,null),'N')='Y'");//common-icn-0180
		
		//IN072542 STARTS
		if(restrict_rd){
			//whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,'"+login_user_id+"')='N'");//common-icn-0180
		    whereClause.append(" AND RD_PEER_NOTE_RESULT_HIDE_YN(a.facility_id,a.CONTR_MOD_ACCESSION_NUM,?)='N'");//common-icn-0180
		}
		//IN072542 ENDS
		if((filter.equals("R")))
				{
			whereClause.append(" 	and exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='RV' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) ");
				}
		else if((filter.equals("S")))
				{
			whereClause.append(" 	and (exists( select 1 from CA_ENCNTR_NOTE_AUDIT_LOG where FACILITY_ID=a.FACILITY_ID and ACCESSION_NUM=a.ACCESSION_NUM and ACTION_TYPE='SN' AND ACTION_STATUS='RQ' AND ACTION_BY_ID =?) OR EVENT_STATUS='1') ");
				}
		if(!note_type.equals(""))
				{
			whereClause.append(" 	and a.note_type=? " );
				}

		if (!note_group.equals("")){
			whereClause.append(" 	and b.note_group_id=? " );
		}else{
			
			String DispClinicalNotesInOTYN ="N";
			pstmtot = con.prepareStatement("SELECT 'Y' DISP_CLNNOTE_OT FROM OR_PAT_APPLICABLE_FUNC WHERE FUNCTION_ID = 'DISP_CLINICAL_NOTES_IN_OT'");
			rsot = pstmtot.executeQuery();
			if(rsot.next()){
				DispClinicalNotesInOTYN= rsot.getString("DISP_CLNNOTE_OT")==null?"":rsot.getString("DISP_CLNNOTE_OT");
			}
			if(rsot!=null)	rsot.close();
			if(pstmtot!=null) pstmtot.close();
					
			
			if("OT_NOTES".equals(appl_task_id) && "Y".equals(DispClinicalNotesInOTYN)){ 
				whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id in ('CLINICAL_NOTES',?)) OR b.note_group_id IN ('*OPERNOTE'))  " );
			}else if("OT_NOTES".equals(appl_task_id) && "N".equals(DispClinicalNotesInOTYN)){ 
				whereClause.append(" 		and 	 (b.note_group_id IN (SELECT note_group FROM ca_note_group WHERE appl_task_id =?) OR b.note_group_id IN ('*OPERNOTE'))  " );
			}else{
				whereClause.append(" 		and 	b.NOTE_GROUP_ID IN (SELECT 	NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID=?)  " );
			}

		}
		
		
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget)){
				whereClause.append(" 	AND b.EVENT_CLASS= ? ");
		}			
		
		if(!performed_by.equals("")){
			whereClause.append(" 	and a.PERFORMED_BY_ID=? " );
		}
		
		if(!med_anc.equals("")){
			whereClause.append(" 	and a.SERVICE_CODE=? " );
		}

		if(!ref_no.equals("")){
			whereClause.append(" 	and upper(a.DOC_REF_ID) like upper('%"+ref_no.trim()+"%')" );
		}
		
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id,Decode(patient_class,'XT', 'Non-Encounter Specific', replace(CA_GET_VISIT_DTL_NEW(a.FACILITY_ID,a.patient_class,a.ENCOUNTER_ID,A.PATIENT_ID),'\''','  ')) Encline,a.encounter_id , /* ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */  (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc from 	ca_encntr_note a, ca_note_type_lang_vw b  where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and a.patient_id = ? and b.language_id = ?");
		}else{ 
			if(called_from.equals("MR_DIAG")){
				query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id , /*ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */ (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");
			}else{				
				query_notes_detail.append("	select a.facility_id, a.accession_num, a.note_type, b.note_type_desc, nvl2(a.EXT_IMAGE_APPL_ID,'Y','N') doc_linked, b.doc_linked_note_yn , a.service_code, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')  service_name, event_title_desc, to_char(a.event_date_time,'dd/mm/yyyy hh24:mi') event_date_time1, a.performed_by_id, replace(AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') ,'''',' ') performed_by_name, a.authorized_by_id, /*replace(e.practitioner_name,'''',' ')*/ replace(AM_GET_DESC.AM_PRACTITIONER(a.authorized_by_id,?,'1') ,'''',' ')   authorized_by_name, a.note_content, a.event_status status, CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? ,?)  operations_allowed, b.ammendment_type, ( select PRIVILEGE_TYPE from ca_note_type_for_resp where RESP_ID = ? and note_type=a.note_type) privilege_type,A.MODIFIED_BY_ID modifiedid, a.DOC_REF_ID doc_ref_id , null Encline,a.encounter_id , /*ca_pat_enc_dtls(a.encounter_id,b.language_id) encounterdesc */ (select to_char(VISIT_ADM_DATE_TIME,'DD-MM-YYYY') || ' / ' || decode(patient_class, 'IP','Inpatient','OP','Outpatient','DC','Daycare','EM','Emergency') || ' / ' ||  encounter_id  || ' / ' || am_get_desc.am_speciality(SPECIALTY_CODE,b.language_id,2) from pr_encounter where facility_id = a.facility_id and encounter_id= a.encounter_id) encounterdesc  from 	ca_encntr_note a, ca_note_type_lang_vw b where CA_GET_APPL_NOTE_OPERN( a.facility_id, a.accession_num, ?, ?, a.note_type, ? , ?)  is not null and  a.note_type = b.note_type and 	a.patient_id = ? and 	a.facility_id =?  and b.language_id = ?");
			}
		}
		
		//if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code)){
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code) && !"".equals(nf_accession_num)){//Added for IN063591
			//query_notes_detail.append(" and a.accession_num='"+nf_accession_num+"'");//common-icn-0180
			query_notes_detail.append(" and a.accession_num=?");//common-icn-0180
		}else if("NOTIFIABLEFORM".equals(function_id) && "".equals(notifiable_code)){
			query_notes_detail.append(" and a.CONTR_MOD_ACCESSION_NUM  IS NULL");
		}
		//IN057368 Start.
		if("DC".equals(patient_class) || "IP".equals(patient_class) ){
			//query_notes_detail.append(" and a.ENCOUNTER_ID='"+encounter_id+"'"); //Commented for IN063798
			query_notes_detail.append(" and a.ENCOUNTER_ID in "+encounterList); //Modified for IN063798
		}
		//IN057368	End.
		query_notes_detail.append(whereClause.toString());
		if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
			query_notes_detail.append("	order by a.encounter_id,event_date_time desc");
		}//NMC-JD-CRF-0154 -START
		
		else if(orderBy.equals("REF"))
		{ID="REF";
	     if(defaultval1.equals("ASC")){
		query_notes_detail.append(" order by doc_ref_id asc");}
		else{
		query_notes_detail.append(" order by doc_ref_id desc");}}
		
		else if(orderBy.equals("PP"))
		{ID="PP";
	     if(defaultval2.equals("ASC")){
		query_notes_detail.append(" order by performed_by_name asc");}
		else{
		query_notes_detail.append(" order by performed_by_name desc");}}
		
		else if(orderBy.equals("AP"))
		{ ID="AP";
		if(defaultval3.equals("ASC")){
			query_notes_detail.append(" order by authorized_by_name asc");}
			else{
			query_notes_detail.append(" order by authorized_by_name desc");}
		}
		
		else if(orderBy.equals("ST"))
		{ ID="ST";
		if(defaultval4.equals("ASC")){
		      query_notes_detail.append(" order by status asc");}
		else{
			query_notes_detail.append(" order by status desc");}}
		
		else if(orderBy.equals("DATE")&& defaultval.equals("ASC")){
			ID="DATE";
			
			query_notes_detail.append("	order by event_date_time asc");
		}//NMC-JD-CRF-0154 -END
		else {
			query_notes_detail.append("	order by event_date_time desc");
		}
		
		pstmt			=	con.prepareStatement(query_notes_detail.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
       

		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	locale			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	); 

		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	resp_id			);
		pstmt.setString( ++colIndex,	clinician_id	);
		pstmt.setString( ++colIndex,	login_user_id	);
		pstmt.setString( ++colIndex,	other_unsigned_yn	);
		pstmt.setString( ++colIndex,	patient_id		);
		
		
		
		if(!(appl_task_id.equals("MEDICAL_CERTFICATE")) && !(appl_task_id.equals("MC_CONSULT"))){
			pstmt.setString( ++colIndex,	facility_id		);	
		}
		pstmt.setString( ++colIndex,	locale);
		//common-icn-0180 starts
		if("NOTIFIABLEFORM".equals(function_id) && !"".equals(notifiable_code) && !"".equals(nf_accession_num)){
			pstmt.setString	(	++colIndex,	nf_accession_num	);
		}
		//common-icn-0180 ends
		if(!(from_date_time.equals("")))
			pstmt.setString	(	++colIndex,	from_date_time	);
			
		if(!(to_date_time.equals("")))
			pstmt.setString	(	++colIndex,	to_date_time	);
		
		if(!(event_status.equals("0")))
			pstmt.setString	(	++colIndex,	event_status	);
		
		if(!(contr_mod_accession_num.equals("")))
			pstmt.setString	(	++colIndex,	contr_mod_accession_num);		
		//common-icn-0180 starts
		pstmt.setString	(	++colIndex,	clinician_id);		
		pstmt.setString	(	++colIndex,	resp_id);				
		if(restrict_rd)
			pstmt.setString	(	++colIndex,	login_user_id);
		//common-icn-0180 ends
		if((filter.equals("R")))
			pstmt.setString	(	++colIndex,	clinician_id);			
		else if((filter.equals("S")))
			pstmt.setString	(	++colIndex,	clinician_id);			
		
		if(!note_type.equals(""))
			pstmt.setString	(	++colIndex,	note_type	);
		
		if (!note_group.equals(""))
			pstmt.setString	(	++colIndex,	note_group	);
		else			
			pstmt.setString	(	++colIndex,	appl_task_id);
					
		if(!"".equals(p_event_class_widget) && !"null".equals(p_event_class_widget))
				pstmt.setString	(	++colIndex,	p_event_class_widget);				
		
		if(!performed_by.equals(""))
			pstmt.setString	(	++colIndex,	performed_by );			
		
		if(!med_anc.equals(""))
			pstmt.setString	(	++colIndex,med_anc);
					
		rs				=	pstmt.executeQuery();

		if(!(rs.next())){
		
            _bw.write(_wl_block8Bytes, _wl_block8);
		
		}else{
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
			
			if( totalRecordCount>maxRecordsDisp){
				
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(startIndex>maxRecordsDisp)
					{
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((startIndex-maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex-maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(defaultval));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(defaultval1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(defaultval2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(defaultval3));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(defaultval4));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

					}
					if(totalRecordCount>endIndex)
					{
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((startIndex+maxRecordsDisp)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((endIndex+maxRecordsDisp)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(defaultval));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(defaultval1));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(defaultval2));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(defaultval3));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(defaultval4));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

					}
				
            _bw.write(_wl_block26Bytes, _wl_block26);

			}
			
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);


			if(startIndex>1)
			rs.absolute((startIndex-1));

			String countQuerySec = "select count(*) count  from ca_note_section_view where note_type = ? ";
			pstmtcnt = con.prepareStatement(countQuerySec);
		
			while(rs.next())
			{
				tblrow_id		=	"tblrow_id"+(rowCnt);
				rowCnt++;

				if( (rowCnt%2)==0 )
					classValue	=	"QRYEVEN";
				else
					classValue	=	"QRYODD";

				//facility_id			=	rs.getString("facility_id")==null?"":rs.getString("facility_id");//NMC-JD-CRF-0154
				//System.out.println("facility_id-----------------"+facility_id);
				accession_num		=	rs.getString("accession_num")==null?"":rs.getString("accession_num");
				note_type			=	rs.getString("note_type")==null?"":rs.getString("note_type");
				note_type_desc		=	rs.getString("note_type_desc")==null?"":rs.getString("note_type_desc");
				service_code		=	rs.getString("service_code")==null?"":rs.getString("service_code");
				service_name		=	rs.getString("service_name")==null?"":rs.getString("service_name");
				service_name		=	service_name.replace('\'',' ');
				event_title_desc	=	rs.getString("event_title_desc")==null?"&nbsp;":rs.getString("event_title_desc");
				event_date_time		=	rs.getString("event_date_time1")==null?"":rs.getString("event_date_time1");
				performed_by_id		=	rs.getString("performed_by_id")==null?"":rs.getString("performed_by_id");
				performed_by_name	=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				authorized_by_name	=	rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
				doc_ref_id			=	rs.getString("doc_ref_id")==null?"":rs.getString("doc_ref_id");
				status1				=	rs.getString("status")==null?"&nbsp;":rs.getString("status");
				operations_allowed	=	rs.getString("operations_allowed")==null?"":rs.getString("operations_allowed");
				amendment_type		=	rs.getString("ammendment_type")==null?"":rs.getString("ammendment_type");
				privilege_type		=	rs.getString("privilege_type")==null?"":rs.getString("privilege_type");
				strModifiedId		=	rs.getString("modifiedid")==null?"":rs.getString("modifiedid");
				doc_linked_note_yn	=	rs.getString("doc_linked_note_yn")==null?"N":rs.getString("doc_linked_note_yn");
				doc_linked			=	rs.getString("doc_linked")==null?"N":rs.getString("doc_linked");
				res_encounter_id	=	rs.getString("encounter_id")==null?"0":rs.getString("encounter_id");
				event_date_time		=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM","en",locale);			
				encounter_desc		=	rs.getString("encounterdesc")==null?"":rs.getString("encounterdesc");
				
				if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT"))
					encline=rs.getString("Encline")==null?"":rs.getString("Encline");				
				
				if(doc_linked_note_yn.equals("Y")){
					pstmtcnt.clearParameters();
					pstmtcnt.setString(1,note_type);
					rscnt = pstmtcnt.executeQuery();
					while(rscnt.next()){
						sec_count = rscnt.getInt("count");
					}
					if(rscnt!=null)
						rscnt.close();
				}

				if(status1.equals("1"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProgress.label","common_labels");
				else if(status1.equals("2"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Transcribed.label","common_labels");
				else if(status1.equals("3"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unauthorized.label","common_labels");
				else if(status1.equals("4"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorized.label","common_labels");
				else if(status1.equals("5"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels");
				else if(status1.equals("9"))
					status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InError.label","common_labels");

				String img = "";
				
				if(doc_linked.equals("Y"))
					img = "<img src='../../eCA/images/DOCUL.gif' onClick='openDocWindow(\""+accession_num+"\",\""+note_type+"\")' height='20' title='View Linked File' >";
				else
					img = "&nbsp;";
				
				status_display_text	= status;
				if(appl_task_id.equals("MEDICAL_CERTFICATE") || appl_task_id.equals("MC_CONSULT")){
					if(!encline.equals(oldEncline)){
						
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encline));
            _bw.write(_wl_block35Bytes, _wl_block35);
 
					}
				}
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(tblrow_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf((rowCnt)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(doc_ref_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(performed_by_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((authorized_by_name == null || authorized_by_name.equals("") )?"&nbsp;":authorized_by_name));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(status_display_text));
            _bw.write(_wl_block41Bytes, _wl_block41);

				oldEncline=encline;
				if(rowCnt>=maxRecordsDisp) break;
			}
		} 
			
	}catch(Exception e){
		System.out.println("Exception@ 501.RecPreviousNotesSrchResults.jsp : "+e);
		e.printStackTrace();
	}finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
		if(rscnt!=null)	rscnt.close();
		if(pstmtcnt!=null) pstmtcnt.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();	
	}
	
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(query_string.toString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(notifiable_code ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(rowCnt ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ref_no));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(performed_by));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(ID));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(defaultval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(defaultval1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(defaultval2));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(defaultval3));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(defaultval4));
            _bw.write(_wl_block58Bytes, _wl_block58);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitPatientClassEncounterSpecilityDtls.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.RefNo.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Performed.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
