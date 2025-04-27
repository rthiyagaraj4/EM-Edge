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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnoteslinkmultihistcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkMultiHistCriteria.jsp", 1709116168482L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"> -->\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesLinkRep.js\'></script> \n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script src=\'../../eCA/js/DateCheck.js\' language=\'javascript\'></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t\tfunction CheckForNumsAndColon(event)\n\t\t{\n\t\t\tvar strCheck = \'0123456789:\';\n\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\t\treturn (event.keyCode -= 32);\n\t\t\treturn true ;\n\t\t}\n\n\t\tfunction CheckDateTime(objText)\n\t\t{\n\t\n\t\t\tif(objText.value !=\'\')\n\t\t\t{\t\n\t\t\t\tif(!doDateTimeChk(objText))\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"CA\"));\n\t\t\t\t\tobjText.select();\n\t\t\t\t\treturn false\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar dateArray=objText.value.split(\" \");\n\t\t\t\t\tvar timeArray=dateArray[0].split(\"/\");\n\t\t\t\t\tif(parseInt(timeArray[2],10)==0)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"CA\"));\n\t\t\t\t\t\tobjText.select();\n\t\t\t\t\t\treturn false\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\n\t</script>\n\t\n\t\n\t</head>\n\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t  <center>\n\t  <form name=\'RecClinicalNotesLinkHistRepCriteriaForm\' id=\'RecClinicalNotesLinkHistRepCriteriaForm\'>\n\t  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\n\n\t\t<tr>\n\t\t<td  class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td><td  class=\'fields\' width=\'25%\'><input type=\'checkbox\'  name=\'current_encounter\' id=\'current_encounter\' ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onclick=\"chEncVal(this);\"> </td> <td class=\'label\' width=\'20%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \n\n\t<td class=\'field\' width=\'30%\'>\n\t  <select name=\"pat_class\" id=\"pat_class\" >\n\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;----- ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" -----&nbsp;&nbsp;&nbsp;</option>\n\t  \n\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</select>\n\t  </td> </tr>\n\t  <tr>\n\t  <td  class=\'label\' width=\'25%\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t  <td  class=\'fields\' width=\'25%\'><input type=\'text\'  name=\'past_encounter\' id=\'past_encounter\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"  size=\"15\" maxlength=\"3\" onKeyPress = \"return allowValidNumber(this,event,2,0);\"  ></td>\n\n\t\t<td  width=\'20%\' class=\"LABEL\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t<td  width=\'30%\' class=\"fields\"><input type=\'text\'  name=\'from_date_time\' id=\'from_date_time\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=\'14\' maxLength=\'18\' OnKeyPress=\"return CheckForNumsAndColon(event)\" onBlur=\'CheckDateTime(this);doDateCheck1(this,to_date_time,\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"DMYHM\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\");\'><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'from_date_time\');\">&nbsp;-&nbsp;        \t\n\t\t<input type=\'text\'  name=\'to_date_time\' id=\'to_date_time\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" size=\'14\' maxLength=\'16\' onBlur=\'CheckDateTime(this);doDateCheck1(from_date_time,this,\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\");\' OnKeyPress=\"return CheckForNumsAndColon(event)\" ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" onclick=\"return showCalendarValidate(\'to_date_time\');\"></td> \n\t\t\n\t</tr>\n\n\n\n\n\t<tr>\n\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\n\t<td class=\'field\' width=\'25%\'>\n\t  <select name=\"facilityIdSel\" id=\"facilityIdSel\" >\n\t\t<option value=\"\">&nbsp;&nbsp;&nbsp;----- ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</select>\n\t  </td>\n\t\n\t\n\t<td class= \'fields\' width=\'20%\' ></td>\n\t<td width=\'30%\'  align=right > \n\t<input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\'BUTTON\' onClick=\"showSearchLinkMultiResult();\"></td></tr>\n\n\t</table>\n\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"hist_rec_type\" id=\"hist_rec_type\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"sec_hdg_code\" id=\"sec_hdg_code\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"child_sec_hdg_code\" id=\"child_sec_hdg_code\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"operation_mode\" id=\"operation_mode\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t</form>\n</center>\n</body>\n</html> \n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t<body onKeyDown=\'lockKey()\'>\n\t\t<form name=\'RecClinicalNotesLinkMultiHistDetForm\' id=\'RecClinicalNotesLinkMultiHistDetForm\'>\n\t\t<table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);


		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String facility_id		=	(String) session.getValue("facility_id");
		
		String dft_date   =   "" ;
		String to_date_time   =   "" ;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		//dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,7,"d");

		String patient_class ="";
		String patient_class_desc ="";
		String encounter_id		=	"";
		String patient_id="";
		String hist_rec_type="";
		String sec_hdg_code="";
		String child_sec_hdg_code="";
		String operation_mode="";
		String accession_num="";
		String note_type = "";
		String current_encntr="";
		String prev_encntr="";
		String encntr_past_days="0";
		String encntr_pdays_option="";
		String enc_checked="checked";
		String chk_val="Y";
		String facility_scope="";
		String sel="";
		String facilityId_list ="";
		String facility_name_list ="";

		
		patient_id=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");

		sec_hdg_code=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
		child_sec_hdg_code=(request.getParameter("child_sec_hdg_code")==null)?"":request.getParameter("child_sec_hdg_code");
		encounter_id=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
		hist_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
		operation_mode		=	(request.getParameter("operation_mode")==null)	?	""	:	request.getParameter("operation_mode");
		accession_num		=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num");
		note_type		=	(request.getParameter("note_type")==null)	?	""	:	request.getParameter("note_type");

		try
		{

			con = ConnectionManager.getConnection(request);
			
			String criteria_sql ="select A.CURRENT_ENCNTR ,A.PREV_ENCNTR ,A.FACILITY_ID, A.ENCNTR_PAST_DAYS ,A.ENCNTR_PDAYS_OPTION from CA_PMR_ENCNTR_DETAILS A where a.NOTE_TYPE_ID=?";
			pstmt = con.prepareStatement(criteria_sql);
			pstmt.setString(1,note_type);
			rset = pstmt.executeQuery();

			while(rset.next())
			{
				current_encntr = rset.getString("CURRENT_ENCNTR")==null?"Y":rset.getString("CURRENT_ENCNTR");
				prev_encntr = rset.getString("PREV_ENCNTR")==null?"":rset.getString("PREV_ENCNTR");
				facility_scope = rset.getString("FACILITY_ID")==null?"":rset.getString("FACILITY_ID");
				encntr_past_days= rset.getString("ENCNTR_PAST_DAYS")==null?"0":rset.getString("ENCNTR_PAST_DAYS");
				encntr_pdays_option= rset.getString("ENCNTR_PDAYS_OPTION")==null?"D":rset.getString("ENCNTR_PDAYS_OPTION");
		
			}
			if(rset!=null)rset.close();
			if(pstmt != null)pstmt.close();

			if(encntr_pdays_option.equals("D"))
			{
				encntr_pdays_option = encntr_pdays_option.toLowerCase();
			}
			
			dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,Integer.parseInt(encntr_past_days),encntr_pdays_option);

			
			if(current_encntr.equals("Y"))
			{
				enc_checked="checked";
				chk_val ="Y";
			}
			else
			{
				enc_checked="";
				chk_val ="N";

			}
			if(prev_encntr.equals("0"))
			{
				prev_encntr ="";
			}
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception cauight in RecClinicalNotesLinkmulticriteria.jsp" + e);//COMMON-ICN-0181
		}




		
	
	
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(enc_checked));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(chk_val));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 
				
		try
		{

			String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class_lang_vw where LANGUAGE_ID=? and  patient_class in ('OP','IP','EM','DC') order by 2 ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			rset = pstmt.executeQuery();
			
	
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
    while (rset.next())
			 {
				patient_class= rset.getString("PATIENT_CLASS")==null?"":rset.getString("PATIENT_CLASS");
				patient_class_desc= rset.getString("SHORT_DESC")==null?"":rset.getString("SHORT_DESC");
				
				out.println("<option value="+patient_class+">"+patient_class_desc+"</option>");
			 }
				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception cauight in RecClinicalNotesLinkmulticriteria.jsp" + e);//COMMON-ICN-0181
		}
		
		
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(prev_encntr));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dft_date));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 
				
	try
		{

//			String  sql = "select facility_name facility_name, facility_id from sm_facility_param_VW where language_id = ?  order by facility_name ";
			String  sql = "select facility_id, sm_get_desc.sm_facility_param(facility_id,?,1) facility_name from sm_facility_param order by facility_name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			rset = pstmt.executeQuery();
			
	
	
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
    while (rset.next())
			 {
				
				facilityId_list = rset.getString("facility_id")==null?"":rset.getString("facility_id");
				facility_name_list= rset.getString("facility_name")==null?"":rset.getString("facility_name");
				if(facility_scope.equals("L"))
					{ if (facilityId_list.equals(facility_id))
						{sel ="selected";}
						else {  sel= "";}
					}
				else{ sel= "";}
				out.println("<option value="+facilityId_list+" "+sel+">"+facility_name_list+"</option>");
			 }
				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception cauight in RecClinicalNotesLinkmulticriteria.jsp" + e);//COMMON-ICN-0181
		}
		finally
		{
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}

		
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(hist_rec_type));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block33Bytes, _wl_block33);

	
	//Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement stHist=null;
	ResultSet rs=null;
	ResultSet rsHist=null;
	
	String	from_date_time		=	"";		//to_date_time		=	"";
	String	from_date_time_th	=	"",		to_date_time_th		=	"";
	int		rowCnt			= 0 ;
	int		txt_count		= 0 ;

	int start = 0, end = 0 ,i=1;
	StringBuffer strsql1 = new StringBuffer(" ");

	from_date_time		=	(request.getParameter("from_date_time")==null)	?	""	:	request.getParameter("from_date_time");
	//to_date_time		=	(request.getParameter("to_date_time")==null)	?	""	:	request.getParameter("to_date_time");
		
	if(!from_date_time.equals(""))
	{
		from_date_time_th	=	com.ehis.util.DateUtils.convertDate(from_date_time,"DMYHM",locale,"en");
	}
	if(!to_date_time.equals(""))
	{
	to_date_time_th		=	com.ehis.util.DateUtils.convertDate(to_date_time,"DMYHM",locale,"en");
	}

	//String  patient_id	 = "";
	//String  sec_hdg_code	 = "";
	//String  child_sec_hdg_code	 = "";
	//String  hist_rec_type	 = "";
	String  current_encounter	 = "";
	//String	encounter_id = "";
	String	past_encounter_yn = "";
	String	past_encounter = "";
	String	pat_class_yn = "";
	String	pat_class = "";
	String	med_template = "";
	String	histrectype = "";
//	String	histrectype_prev = "";
	String	hist_rec_type_desc = "";
	String	event_date_time = "";
	String	event_date = "";
	String	classValue = "";
	String	histdatatype = "";
	String data = "";
	String sqlHist ="";
	String resultstr="";
	String contr_sys_id = "";
	String accessionnum="";
	String contr_sys_event_code  = "";
	String eventdesc="";
	String result_disp="";
	String sort_by="";
	String secKey = "";
	String hashKey = "";
	String eventclassdesc = "";
//	String preveventclass = "";
//	String colspanval ="3";
//	String curreventgroupevent="";
	String eventgroupdesc="";
	//String eventgroupdesc="";
	//String eventdesc="";
//	String preveventgroupevent="";
//	String event_date_prev="";
	//String operation_mode="";
	//String accession_num="";
	String result_linked_key="";
	String result_linked_val="";
//	String chkstat = "";
	String from = "";
	String to = "";

	
	//String curreventgroupevent="";
//	int count = 0;
	
//	ArrayList arrList =new ArrayList();

	sqlHist="select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=?";
	


	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	sec_hdg_code			=	(request.getParameter("sec_hdg_code")==null)	?	""	:	request.getParameter("sec_hdg_code");
	child_sec_hdg_code			=	(request.getParameter("child_sec_hdg_code")==null)	?	""	:	request.getParameter("child_sec_hdg_code");
	encounter_id		=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
	current_encounter		=	(request.getParameter("current_encounter")==null)	?	""	:	request.getParameter("current_encounter");
	past_encounter_yn		=	(request.getParameter("past_encounter_yn")==null)	?	""	:	request.getParameter("past_encounter_yn");
	past_encounter		=	(request.getParameter("past_encounter")==null)	?	""	:	request.getParameter("past_encounter");
	pat_class_yn		=	(request.getParameter("pat_class_yn")==null)	?	""	:	request.getParameter("pat_class_yn");
	pat_class		=	(request.getParameter("pat_class")==null)	?	""	:	request.getParameter("pat_class");
	med_template		=	(request.getParameter("med_template")==null)	?	""	:	request.getParameter("med_template");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");
	//operation_mode		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("operation_mode");
	accession_num		=	(request.getParameter("accession_num")==null)	?	""	:	request.getParameter("accession_num");
	//sort_by		=	(request.getParameter("sort_by")==null)	?	""	:	request.getParameter("sort_by");
	
	from		=	(request.getParameter("from")==null)	?"1"	:	request.getParameter("from");
	to		=	(request.getParameter("to")==null)	?	"14"	:	request.getParameter("to");
	
	start =Integer.parseInt(from);
	end =Integer.parseInt(to);
		try
		{
			con =  ConnectionManager.getConnection(request);

		}
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("Exception caught in RecClinicalNotesLinkMultiHIstDetails.jsp ...@ 1" + e);
		}




		eCA.PatientBannerGroupLine manageEmailBean = null;
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);


		try
		{
			//con =  ConnectionManager.getConnection(request);
			String sort_qry =" select DISPLAY_ORDER  from ca_section_hdg b where b.SEC_HDG_CODE=? and b.ADDED_FACILITY_ID =? ";

			stmt = con.prepareStatement(sort_qry);
			stmt.setString(1,sec_hdg_code);
			stmt.setString(2,facility_id);
			rs = stmt.executeQuery();
			while(rs.next())
			{
			 sort_by = rs.getString("DISPLAY_ORDER")==null?"C":rs.getString("DISPLAY_ORDER");
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		}
		catch(Exception e )
		{
			e.printStackTrace();
			//out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);//COMMON-ICN-0181

		}

		

		if(operation_mode.equals("Update")|| operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum"))
		{
			
			try
			{
				if(manageEmailBean.returnSortList().isEmpty())
				{

					String arrPopQry ="select a.RESULT_LINKED_KEY ,a.RESULT_LINKED_VALUE from CA_ENCNTR_MULT_RESULT_KEY a where a.ACCESSION_NUM =? " ;

					stmt = con.prepareStatement(arrPopQry);
					stmt.setString(1,accession_num);
					rs = stmt.executeQuery();
					while(rs.next())
					{
					 result_linked_key = rs.getString("RESULT_LINKED_KEY")==null?"":rs.getString("RESULT_LINKED_KEY");
					 result_linked_val = rs.getString("RESULT_LINKED_VALUE")==null?"":rs.getString("RESULT_LINKED_VALUE");
					// arrList.add(result_linked_key);
					
						if(!manageEmailBean.returnSortList().contains(result_linked_key))
							{
								manageEmailBean.addRecordsToSortList(result_linked_key);
								manageEmailBean.addToHashMap(result_linked_key,result_linked_val);
							}
					 
					}

					if(rs!=null) rs.close();
					if(stmt!=null)stmt.close();
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
				//out.println("Exception caught in RecClinicalNotesLinkMultiHIstdetails.jsp ..@ 2" + e);//COMMON-ICN-0181
			}

		}
		else
		{



	

	//manageEmailBean.clearBean(); 



	

	//out.println("patient_id..."+patient_id+"encounter_id..."+encounter_id+"hist_rec_type..."+hist_rec_type);

	
	
	
	strsql1.append(" Select a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'dd/mm/yyyy') event_date ,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX||DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'2') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind normalcy_str,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT From cr_encounter_detail a  where a.patient_id = ?  and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 and a.facility_id = ? ");

	strsql1.append(" AND  EXISTS (SELECT 1 FROM CA_SECTION_RESULT_EVENT WHERE SEC_HDG_CODE=? AND EVENT_CODE=A.EVENT_CODE AND EVENT_GROUP_CODE=NVL(A.EVENT_GROUP,A.EVENT_CODE))"); 

	if (!current_encounter.equals("N"))
		strsql1.append(" and a.encounter_id=? ");
	if(sort_by.equals("D"))
	  		strsql1.append(" order by a.event_date ");
	if(sort_by.equals("C"))
	  		strsql1.append(" order by a.hist_rec_type desc");

	
	try{
	
		
		if(manageEmailBean.returnSortList().isEmpty())
		{
		//con =  ConnectionManager.getConnection(request);

		stHist=con.prepareStatement(sqlHist);
	
		stmt = con.prepareStatement(strsql1.toString());
		int count1=0;
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,patient_id);
		stmt.setString(++count1,dft_date);			
		stmt.setString(++count1,to_date_time);
		stmt.setString(++count1,facility_id);
		stmt.setString(++count1,sec_hdg_code);
	if (!current_encounter.equals("N"))
		stmt.setString(++count1,encounter_id);



		
	
		rs = stmt.executeQuery();
	
            _bw.write(_wl_block34Bytes, _wl_block34);


 /*	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rs.next() ; */
		
	//while(rs.next()&& i<=end)
	int j=1;
	while(rs.next())
	{
			
			
			
			rowCnt++;
			data="";
			txt_count = 0;

			if( (rowCnt%2)==0 )
				classValue	=	"QRYEVEN";
			else
				classValue	=	"QRYODD";
		
		histrectype = rs.getString("HIST_REC_TYPE")==null?"":rs.getString("HIST_REC_TYPE");
		hist_rec_type_desc = rs.getString("HIST_REC_TYPE_DESC")==null?"":rs.getString("HIST_REC_TYPE_DESC");
		eventclassdesc = rs.getString("event_class_desc")==null?"":rs.getString("event_class_desc");
		event_date_time = rs.getString("EVENT_DATE_TIME")==null?"":rs.getString("EVENT_DATE_TIME");
		event_date = rs.getString("event_date")==null?"":rs.getString("event_date");
		histdatatype = rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
		resultstr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
		contr_sys_id = rs.getString("contr_sys_id")==null?"":rs.getString("contr_sys_id");
		accessionnum = rs.getString("ACCESSION_NUM")==null?"":rs.getString("ACCESSION_NUM");
		contr_sys_event_code = rs.getString("contr_sys_event_code")==null?"":rs.getString("contr_sys_event_code");
		eventdesc = rs.getString("event_desc")==null?"":rs.getString("event_desc");
		eventgroupdesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
		// eventdesc = rs.getString("event_desc");

		//result_disp = rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));

		if(histdatatype.equals("NUM"))
				{
					result_disp = rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					if(result_disp.equals(""))
					{
						result_disp="&nbsp;";
					}
					data =data +result_disp; //rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM")+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
		//*** checking for if there is any STR  
					if(!resultstr.equals("") && resultstr !=null)
					{
						resultstr=replaceSpecialChar(resultstr);
						data=data +"<a href=javaScript:ShowComments('"+java.net.URLEncoder.encode(resultstr)+"')>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+" </a>";
					}
					// 

					//stHist.clearParameters();
					
					stHist.setString(1,rs.getString("HIST_REC_TYPE"));
					stHist.setString(2,rs.getString("CONTR_SYS_ID"));
					stHist.setString(3,rs.getString("ACCESSION_NUM"));
					stHist.setString(4,rs.getString("contr_sys_event_code"));
					rsHist=stHist.executeQuery();

					/*
					sqlHist.append("select count(*) from CR_ENCOUNTER_DETAIL_TXT " );
					sqlHist.append(" where hist_rec_type = '"+rs.getString("HIST_REC_TYPE")+"' and contr_sys_id = '"+rs.getString("CONTR_SYS_ID")+"' " +
								" and accession_num = '"+rs.getString("ACCESSION_NUM")+"' and contr_sys_event_code ='"+rs.getString("contr_sys_event_code")+"' ");
						 stHist=con.prepareStatement(sqlHist.toString());
						 //out.println("insidesqlHist"+sqlHist.toString());
						 rsHist=stHist.executeQuery();
						 */
			
						if (rsHist.next()) 
						{ 
							

							if(rsHist.getInt(1) >0) {
							data=data +"<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";
							txt_count = 1;
							}
						}

					//***

					/*if(!normalrange.equals(" - "))
						range = range + "Normal Range : "+normalrange+" ,	 ";
					if(!criticalrange.equals(" - "))
						range = range + "Critical Range : "+criticalrange; */
				}
				else if(histdatatype.equals("STR"))
				{

					result_disp = resultstr+"";
					if(result_disp.equals(""))
					{
						result_disp="&nbsp;";
					}
					data =data + resultstr+"";
					 //sqlHist  =new StringBuffer();
					//stHist.clearParameters();
					
					stHist.setString(1,rs.getString("HIST_REC_TYPE"));
					stHist.setString(2,rs.getString("CONTR_SYS_ID"));
					stHist.setString(3,rs.getString("ACCESSION_NUM"));
					stHist.setString(4,rs.getString("contr_sys_event_code"));
					 rsHist=stHist.executeQuery();

					/*
					sqlHist.append(" select count(*) from CR_ENCOUNTER_DETAIL_TXT ");
					sqlHist.append(" where hist_rec_type = '"+rs.getString("HIST_REC_TYPE")+"' and contr_sys_id = '"+rs.getString("CONTR_SYS_ID")+"' " +
								" and accession_num = '"+rs.getString("ACCESSION_NUM")+"' and contr_sys_event_code ='"+rs.getString("contr_sys_event_code")+"' ");
						 stHist=con.prepareStatement(sqlHist.toString());
						 rsHist=stHist.executeQuery();
						//out.println("insidesqlHist"+sqlHist.toString());


						*/
						while(rsHist.next()) 
						{ 
							

							if(rsHist.getInt(1) >0) {
							data=data +"<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";
							txt_count = 1;
							}
						}

				}
				else if(histdatatype.equals("HTM")||histdatatype.equals("TXT"))
				{
					
							

							 
					

					
					//data = "<a href=\"javascript:showDocDetails('"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+java.net.URLEncoder.encode(eventdesc)+"','"+contr_sys_id+"','"+contr_sys_event_code+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";
					data = "<a href=\"javascript:getText_res('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' border=0 src='../../eCA/images/flow_text.gif' ></a></font>";

							
						
					

				}
				else if(histdatatype.equals("DOC"))
				{
				data = data + "<a href=\"javascript:showDocDetails('"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+java.net.URLEncoder.encode(eventdesc)+"','"+contr_sys_id+"','"+contr_sys_event_code+"')\"><img border=0 src='../../eCA/images/flow_text.gif'></img></a>";

				
				}



				else if(histdatatype.equals("IMG")) 
				{
					//data +="<a href=javascript:showDocDetails(\""+histdatatype+"\",\""+histrectype+"\",\""+accessionnum+"\",\""+java.net.URLEncoder.encode(eventdesc)+"\",\""+extimageapplid+"\")><img border=no src='../../eCA/images/flow_image.gif'></img></a>";
				}
		
	/*	if(sort_by.equals("D"))
		{
			if(!event_date.equals(event_date_prev))
			{
				out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+event_date+"</font></td></tr>");	
			}
		} 

		if(!histrectype.equals(histrectype_prev))
			{
			out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+hist_rec_type_desc+"</font></td></tr>");
			}
			
				if(!preveventclass.equals(eventclassdesc))
				{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
					//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;

				if(!curreventgroupevent.equals(preveventgroupevent))
					{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1>" +curreventgroupevent+ "</font></td></tr>");
					}
					*/

			
			
			if(result_disp.equals("")||result_disp==null)
				result_disp ="&amp;nbsp;";//3
			
			//putting all in bean
	
				hashKey = histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+sec_hdg_code ;
			
			if(sort_by.equals("D"))
				{
					secKey = sort_by+"~"+event_date_time+"~"+histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+result_disp+"~"+hist_rec_type_desc+"~"+sec_hdg_code;

					

					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
				}
				else if(sort_by.equals("C"))
				{
					secKey=sort_by+"~"+histrectype+"~"+contr_sys_id+"~"+accessionnum+"~"+contr_sys_event_code+"~"+result_disp+"~"+hist_rec_type_desc+"~"+event_date_time+"~"+sec_hdg_code;

					//secKeyVal=Histrectype+"~"+Contrsysid+"~"+Accessionnum+"~"+Contrsyseventcode
					
				}

			
				
					if(!manageEmailBean.returnSortList().contains(hashKey))
						{
							manageEmailBean.addRecordsToSortList(hashKey);
							manageEmailBean.addToHashMap(hashKey,secKey);
						}
				

				
				/*	if ( start != 1 )
				 for( int j=1; j<start; i++,j++ )
				 rs.next() ; */
		
				//while(rs.next()&& i<=end)



	/*		if((j<start)||(i>=end))
			{
				j++;
				i++;
				continue;
			}

			if(sort_by.equals("D"))
		{
			if(!event_date.equals(event_date_prev))
			{
				out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+event_date+"</font></td></tr>");	
			}
		} 

		if(!histrectype.equals(histrectype_prev))
			{
			out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='3'><font size=1>"+hist_rec_type_desc+"</font></td></tr>");
			}
			
				if(!preveventclass.equals(eventclassdesc))
				{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
					//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;

				if(!curreventgroupevent.equals(preveventgroupevent))
					{
					out.println("<tr ><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1>" +curreventgroupevent+ "</font></td></tr>");
					}



			//new 

			out.println("<tr><td class='"+classValue+"' width='40%'>"+event_date_time+"</td><td class='"+classValue+"' width='40%'>"+data+"</td><td class='"+classValue+"' width='20%''><input type='checkbox' name ='select"+rowCnt+"' value ='' "+chkstat+" onClick=\"addToList(this,"+rowCnt+",'"+histdatatype+"','"+histrectype+"','"+accessionnum+"','"+contr_sys_id+"','"+contr_sys_event_code+"','"+java.net.URLEncoder.encode(result_disp)+"','"+hist_rec_type_desc+"','"+event_date_time+"','"+sort_by+"');\"><input type='hidden' name='chk_value"+rowCnt+"' id='chk_value"+rowCnt+"' value='"+histrectype+"~"+accessionnum+"~"+java.net.URLEncoder.encode(eventdesc)+"~"+contr_sys_id+"~"+contr_sys_event_code+"'></td></tr>");

							
				//count++;


			// putting
			event_date_prev =event_date;
			preveventgroupevent = curreventgroupevent;
			histrectype_prev = histrectype; //rowCnt
			preveventclass = eventclassdesc;  */
			//"+histrectype+"~"+accessionnum+"~"+java.net.URLEncoder.encode(eventdesc)+"~"+contr_sys_id+"~"+contr_sys_event_code+"
			//this,\'"+rowCnt+"\'
			//+",\'"+histdatatype+"\',\'"+histrectype+"\',\'"+accessionnum+"\',\'"+contr_sys_id+"\',\'"+contr_sys_event_code+"\'
	i++;
	j++;
	}
	

	putObjectInBean("manageEmailBean"+patient_id+encounter_id,manageEmailBean,session);
	
	
	if(rs!=null) rs.close();
	if(stmt!=null)stmt.close();	
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception caught in RecClinicalNotesLinkMultiHIst.jsp" + e);//COMMON-ICN-0181

	}
	finally 
	{
	
	ConnectionManager.returnConnection(con,request);
	}
		}
		

	

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LimittoCurrentEncounter.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PastEncounters.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
