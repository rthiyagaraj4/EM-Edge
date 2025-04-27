package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recpatchiefcomplaintaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecPatChiefComplaintAddModify.jsp", 1733067178670L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\t<style>\n\t\ttextarea {\n\t\t  \tresize: none;\n\t\t}\n\t</style>\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/RecPatChiefComplaint.js\' language=\'javascript\'></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../js/DateValidation.js\' language=\'javascript\'></SCRIPT> \n<script src=\"../../eCommon/js/dchk.js\" language=\"javascript\"></script>\n<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\n\nfunction timeCalculate(obj)\n{\n}\n\n\n\n</script>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title><!--IN035950-->\n</head>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onKeyDown=\'lockKey()\'>\n\t<form name=\'RecPatChiefComplaintAddModifyForm\' id=\'RecPatChiefComplaintAddModifyForm\' action=\"../../servlet/eCA.RecPatChiefComplaintServlet\" method=\'post\' target=\'messageFrame\' >\n\t<table border=0 cellpadding=\'1\' cellspacing=0 width=\'75%\' align=center >\n\t<td class=\'COLUMNHEADER\' colspan=\'2\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td class=label >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t</td>\n\t\t<td class=\'fields\'><input type=\'text\' name=\'complaint_desc\' id=\'complaint_desc\' size=\'50\' maxlength=\'50\'   OnKeyPress=\'return CheckForSpecialCharacter(this)\' OnBlur =\'getViewCode(this)\' OnChange=\'resetValues();setValue()\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" readonly ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="></input><input type=\'hidden\' name=\'complaint_id\' id=\'complaint_id\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'></input><input type=\'button\' name=\'ComplaintSrch\' id=\'ComplaintSrch\' value=\'?\'  OnClick=\'resetValues();getViewCode(this);\' class=\'button\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="></input><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t</tr>\n\t<!--  37744 STARTS  -->\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=\'hidden\' name=\'chComplaintMandYN\' id=\'chComplaintMandYN\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t<input type=\'hidden\' name=\'chRemarksMandYN\' id=\'chRemarksMandYN\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<!--  37744 ENDS  -->\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t<!--<td class=\'fields\'><textarea name=\'complaint_details\' value=\'\' rows=\'5\' cols=\'70\' onBlur=\"makeValidString(this)\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</textarea><img src=\'../../eCommon/images/mandatory.gif\'></td>-->\n\t    <!-- 37744 STARTS -->\n\t\t<td class=\'fields\'><textarea name=\'complaint_details\' value=\'\' rows=\'5\' cols=\'70\' onBlur=\"makeValidString(this)\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</textarea>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" <img src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" </td>\n\t    <!--37744 ENDS -->\n\t</tr>\n\n\t<tr>\n\t\t<td class=label   >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </td>\t\t\n\t\t\t<td class=\'fields\'>\t<input type=\'text\' name=\'onset_date\' id=\'onset_date\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' size=\'15\' maxlength=\'16\' onblur=\'checkForCurrentDate(this,\"DMYHM\",\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\",\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\");timeCalculate(this);\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  id =\'imgCalendar\' onclick=\"return showCalendarValidate(\'onset_date\');\" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" ><img align=\'center\'  src=\'../../eCommon/images/mandatory.gif\'> \n\t\t\t<input type=\'hidden\' name=\'ServerDate\' id=\'ServerDate\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t<td class=\'fields\'>\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<!-- 37744 STARTS-->\n\t    <textarea name=\'remarks\' rows=\'2\' cols=\'70\' maxlength=100 onkeyPress = \'checkMaxLimit(this,100)\' onBlur = \'return  ismaxlength(this)\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </textarea>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="<img src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </textarea></td>\n\t\t<!-- 37744 ENDS-->\n\t</tr>\n\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t<tr>\n\t<td class=\'label\' width=\'25%\'> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t<td class=\'fields\' width=\'25%\'> <input type=\'checkbox\' value=\'Y\' name=\'error_yn\' id=\'error_yn\' onClick=\'show_rem(this)\'></td> \n\t</tr>\n\t<tr id=\"sh_rem\" style=\"display:none\">\n\t<td class=\'label\' width =\'25%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </td>\n\t<td class=\'fields\' width=\'25%\'><textarea name=\'err_remarks\' id=\'err_remarks\' value=\'\' rows=\'2\' cols=\'70\' maxlength=100 onkeyPress = \'checkMaxLimit(this,100)\' onBlur = \'return  ismaxlength(this)\'></textarea><img src=\'../../eCommon/images/mandatory.gif\'> </td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t<tr align =\'right\'>\n\t\t\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t<td width=\'25%\' align=\'left\'><input type=\'button\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' name=\'Error_List\' class=\'button\' onclick=\'show_errList()\'></input></td> \n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t<td width=\'25%\'>&nbsp;</td> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t<td width =\'50%\'><input type=\'button\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' name=\'recordButton\' id=\'recordButton\' class=\'button\' onclick=\'apply()\' ></input>\n\t\t<input type=\'button\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' name=\'clearButton\' id=\'clearButton\' class=\'button\' onclick=\'Clearpage()\'></input>\n\t\t<!-- Below cancel button is commented by Archana Dhal on 11/12/2010 related to incident no IN024588 -->\n\t\t<!-- <input type=\'button\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' name=\'cancelButton\' class=\'button\' onclick=\'cancel_page()\'></input> --></td>\n\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'text5\' id=\'text5\' value=\'\'>\n\t<input type=\'hidden\' name=\'text6\' id=\'text6\' value=\'\'>\n\t<input type=\'hidden\' name=\'text7\' id=\'text7\' value=\'\'>\n\t<input type=\'hidden\' name=\'text8\' id=\'text8\' value=\'\'>\n\t<input type=\'hidden\' name=\'text9\' id=\'text9\' value=\'\'>\n\t<input type=\'hidden\' name=\'onset_datetime\' id=\'onset_datetime\'\tvalue=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\'\t\tvalue=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"></input>\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\'\tvalue=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\'\t\t\tvalue=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'></input>\n\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'true\'>\n\t<input type=\'hidden\' name=\'viewCode\' id=\'viewCode\' value=\'\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t<!-- <input type=\'hidden\' name=\'error_yn\' id=\'error_yn\'\t\tvalue=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'></input> -->\n\t<input type=\'hidden\' name=\'spltCode\' id=\'spltCode\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'></input>\n\t<input type=\'hidden\' name=\'open_in_modal\' id=\'open_in_modal\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'></input>\n\t<input type=\'hidden\' name=\'p_called_from_widget\' id=\'p_called_from_widget\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'></input> <!-- //CHL-CRF [IN035950] -->\n\n\t\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
05/12/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible. 
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
28/10/2022      37744         SREENADH M      01/11/2022       Ramesh G        ML-MMOH-CRF-1654							
-------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String title = request.getParameter("title");//IN035950


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String facility_id=(String) session.getValue("facility_id");
	String encounter_id = request.getParameter("encounter_id");
	String relationship_id = request.getParameter("relationship_id");
	String patient_id = request.getParameter("patient_id");
	String resp_id	=	(String)session.getValue("responsibility_id");
	String complaint_desc = "";
	String complaint_text = "";
	String onset_datetime = "";
	String complaint_id = "";
	String remarks = "";
	String mode = "";
	String disable = "";
	PreparedStatement pstmt =null;
	ResultSet rs =null ;
	String error_apply="";
	String ERR_EXIST ="";
	String error_yn="";
	String open_in_modal="";
	String clear="";
	//String complaint_details="";


	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String Dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));
//	String qrystr = request.getQueryString();
	
	String spltCode = (request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code"));
	Dob = com.ehis.util.DateUtils.formatDate(Dob,"DMY","DMYHM",locale);
	//Dob = com.ehis.util.DateUtils.convertDate(Dob,"DMYHM","en",locale);
	open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");
	clear = request.getParameter("clear")==null?"":request.getParameter("clear");
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]

	Connection con          = null; 
	try
	{
		con = ConnectionManager.getConnection(request);
		onset_datetime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		
		String appl_string = "SELECT GET_TASK_APPLICABILITY('MARK_CHIEF_CMP_ERR',NULL,?,?,?,?,?) error_apply, nvl((SELECT 'Y' FROM CA_ENCNTR_CC_ERRLOG WHERE FACILITY_ID=? and   ENCOUNTER_ID=? AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";
		pstmt= con.prepareStatement(appl_string);
						
		pstmt.setString(1,resp_id);
		pstmt.setString(2,relationship_id);
		pstmt.setString(3,facility_id);
		pstmt.setString(4,encounter_id);
		pstmt.setString(5,patient_id);
		pstmt.setString(6,facility_id);
		pstmt.setString(7,encounter_id);

		rs = pstmt.executeQuery();

		while(rs.next())
		{
		 
		 error_apply =rs.getString("error_apply")==null?"":rs.getString("error_apply");
		 ERR_EXIST =rs.getString("ERR_EXIST")==null?"":rs.getString("ERR_EXIST");
		 
		}

		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();
		
		if(mode.equals("modify"))
		{
			disable = "Disabled";
			//complaint_desc =  request.getParameter("complaint_desc")==null?"":request.getParameter("complaint_desc");
			complaint_text =  request.getParameter("complaint_text")==null?"":request.getParameter("complaint_text");
            /*added by Archana on 3/10/2010 at 3:07 PM for IN019870
			    If complaint_text contain double quotes then it will be replaced with the string(&quot;).
		     */
			complaint_text = complaint_text.replaceAll("\"", "&quot;");
			onset_datetime =  request.getParameter("onset_datetime")==null?"":request.getParameter("onset_datetime");
			onset_datetime =  com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);
			complaint_id =  request.getParameter("complaint_id")==null?"":request.getParameter("complaint_id");	
			//remarks =  request.getParameter("remarks")==null?"":request.getParameter("remarks");
			open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");	
			//out.println("complaint_text"+complaint_text);
			
			String comp_desc = "select complaint_desc,remarks from ca_encntr_chief_complaint  where FACILITY_ID =? and ENCOUNTER_ID =? and  complaint_id=? ";
			
			pstmt= con.prepareStatement(comp_desc);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,complaint_id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{

		 
				 complaint_desc =rs.getString("complaint_desc")==null?"":rs.getString("complaint_desc");
				 remarks =rs.getString("remarks")==null?"":rs.getString("remarks");
				
			}
		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();

			//complaint_details =  request.getParameter("complaint_details")==null?"":request.getParameter("complaint_details");
		}
		else{
			mode = "insert";
		}
		if(mode.equals("modify")&&error_apply.equals("A"))
		{
			open_in_modal = request.getParameter("open_in_modal")==null?"":request.getParameter("open_in_modal");
			p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget"); //CHL-CRF [IN035950]
		}


	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 
		if(open_in_modal.equals("Y")&& clear.equals("clear")){
			disable="";
			onset_datetime = com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			//onset_datetime =  request.getParameter("date")==null?"":request.getParameter("date");
			//onset_datetime =  com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);
			}
		
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(complaint_text));
            _bw.write(_wl_block13Bytes, _wl_block13);
if(mode.equals("modify")){  
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(complaint_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block18Bytes, _wl_block18);

		String compRemakSQL = "SELECT CHIEF_COMPLAINT_MAND_YN,CHIEF_REMARKS_MAND_YN from CA_PARAM";
		pstmt= con.prepareStatement(compRemakSQL);
		rs = pstmt.executeQuery();
		String chComplaintMandYN = "";
		String chRemarksMandYN = "";
		while(rs.next()){
			chComplaintMandYN = rs.getString("CHIEF_COMPLAINT_MAND_YN")==null?"N":(String)rs.getString("CHIEF_COMPLAINT_MAND_YN");
			chRemarksMandYN = rs.getString("CHIEF_REMARKS_MAND_YN")==null?"N":(String)rs.getString("CHIEF_REMARKS_MAND_YN"); 
		}
		
		if(pstmt!=null)
			pstmt.close();
		if(rs !=null)
			rs.close();
		
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(chComplaintMandYN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(chRemarksMandYN));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(complaint_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(complaint_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);
if(chComplaintMandYN.equals("Y")){ 
            _bw.write(_wl_block25Bytes, _wl_block25);
}
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(onset_datetime));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Dob));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(mode.equals("modify")){  
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(onset_datetime));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block36Bytes, _wl_block36);
if(chRemarksMandYN.equals("Y")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
 if(mode.equals("modify")&&error_apply.equals("A")){
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
 if(ERR_EXIST.equals("Y")) {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
		 else {
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(onset_datetime));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(error_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(spltCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(open_in_modal));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(p_called_from_widget));
            _bw.write(_wl_block58Bytes, _wl_block58);

	}
	catch(Exception e)
	{
	//	out.println("Exception @ RecPatChiefComplaintAddModify "+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block59Bytes, _wl_block59);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AddComplaint.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ComplaintDetails.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OnsetDateTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.MarkasError.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ErrorRemarks.label", java.lang.String .class,"key"));
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
