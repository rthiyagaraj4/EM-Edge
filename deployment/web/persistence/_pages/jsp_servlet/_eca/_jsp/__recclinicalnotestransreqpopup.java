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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recclinicalnotestransreqpopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesTransReqPopup.jsp", 1738140377313L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\t\t<script Language=\"JavaScript\" src=\'../../eCA/js/IPConsultationList.js\'></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\'javascript\'></script> \n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\nfunction onApply()\n{\n\tif(document.forms[0].remarks.value.length > 400)\n\t{\n\t\tvar msg = getMessage(\'RMRKS_MAX_LENGTH_CNT\',\'CA\');\n\t\tmsg = msg.replace(\'$\',\'400\');\n\t\talert(msg);\n\t\treturn false;\n\t}\n\telse\n\t{\n\t\tvar fields = new Array ( document.forms[0].transcriber );\n\t\t\t\n\t\tvar names  = new Array ( getLabel(\"eCA.Transcriber.label\",\"CA\"));\n\n\t\tif(checkFieldsofMst( fields, names, parent.messageFrame)) \n\t\t{\n\t\tvar patient_id=document.forms[0].patient_id.value;\n\t\tvar encounter_id=document.forms[0].encounter_id.value;\n\t\tvar bean_key=document.forms[0].bean_key.value;\n\t\tvar transcriber=document.forms[0].transcriber.value;\n\t\tvar note_type=document.forms[0].note_type.value;\n\n\t\t\n\t\t//hash_key = patient_id+\"~\"+encounter_id;\n\t\t//hash_value = patient_id+\"~\"+encounter_id+\"~\"+transcriber+\"~\"+notes;\n\t\t\n\t\tvar xmlDoc=\"\";\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\txmlStr\t=\"<root><SEARCH \" ;\n\t\txmlStr +=\" /></root>\" ;\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open( \"POST\",\"../../eCA/jsp/MultiTransRequestIntermediate.jsp?operation_mode=addNoteToBean&patient_id=\"+patient_id+\"&bean_key=\"+bean_key+\"&encounter_id=\"+encounter_id+\"&transcriber=\"+transcriber+\"&note_type=\"+note_type, false);\n\t\txmlHttp.send(xmlDoc);\n\t\tresponseText=xmlHttp.responseText;\n\t\tresponseText = trimString(responseText);\n\t\t\n\t\tparent.TransReqFrame.TranscriptionReqPopUpForm.submit();\n\t\t}\n\t}\n}\n\nfunction getTranscriber_notes(obj)\n {\n\t\n\tif(obj.value!=\'\')\n\t{\n\t\tgetTranscriber_notes1(obj);\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].transcriber.value = \"\";\n\t\tdocument.forms[0].transcriber_desc.value = \"\";\n\t}\n\n\t\n\n }\n async function getTranscriber_notes1(obj)\n {\n\n\n\t\t\n\t\tvar target\t\t\t= document.forms[0].transcriber_desc;\n\t\t//var target\t\t\t= document.forms[0].practitioner;\n\t\t\n        var val\t\t\t\t= document.forms[0].facilityid.value;\n\t\tvar retVal\t\t\t=  new String();\n\t\tvar dialogTop\t\t= \"40\";\n\t\tvar dialogHeight\t= \"10\" ;\n\t\tvar dialogWidth\t\t= \"40\" ;\n\t\tvar features\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\t\tvar arguments\t\t= \"\" ;\n\t\tvar search_desc\t\t= \"\";\n\t\tvar title\t\t\t= \"\";\n\t\t\t\t\n\t\ttitle\t\t\t\t=  getLabel(\"eCA.Transcriber.label\",\"CA\");\n\t\n\t\tvar locale\t\t\t= document.forms[0].locale.value;\n\t\tvar sql=\"\";\n       \n\t\t\n\t\t\tsql=\"Select a.practitioner_id code , b.practitioner_name description from AM_PRACT_FOR_FACILITY A, AM_PRACTITIONER_LANG_VW B where UPPER(b.practitioner_name) like upper(?) AND a.practitioner_id like upper(?) AND a.facility_id = \'\"+val+\"\' AND B.PRACTITIONER_ID = A.PRACTITIONER_ID AND B.LANGUAGE_ID = \'\"+locale+\"\' \";\n\n\t\t\n\t\t \n\t\tvar argArray\t\t= new Array();\n\t\tvar namesArray\t\t= new Array();\n\t\tvar valuesArray\t\t= new Array();\n\t\tvar datatypesArray\t= new Array();\n\t\t\n\t\targArray[0] = sql;\n\t\targArray[1] = namesArray;\n\t\targArray[2] = valuesArray;\n\t\targArray[3] = datatypesArray;\n\t\targArray[4] = \"2,1\";\n\t\targArray[5] = target.value;\n\t\targArray[6] = DESC_LINK;\n\t\targArray[7] = CODE_DESC;\n\t\tretArray = await CommonLookup( title, argArray );\t\n\t\t\n\t\tif(retArray != null && retArray !=\"\")\n\t\t{\n\t\t\tvar ret1=unescape(retArray);\n\t\t \tvar arr=ret1.split(\",\");\n\t\t \tif(arr[1]==undefined) { \n\t\t\tarr[1]=\"\";\n\t\t\tarr[0]=\"\";\n\t\t\t}\n\n\t\t   document.forms[0].transcriber_desc.value = arr[1];\n\t\t   document.forms[0].transcriber.value = arr[0];\n\t\t\t\t\t\n\t\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].transcriber_desc.value = \"\";\n\t\t\tdocument.forms[0].transcriber.value = \"\";\n\t\t\t\n\t\t}\n }\n\n\n\n</script>\n\n\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n\n\t</head>\n\t<body onKeyDown=\"lockKey()\">\n\t\t<form name=\'TranscriptionReqPopUpForm\' id=\'TranscriptionReqPopUpForm\' method=\'post\' target=\'messageFrame\' action=\'../../servlet/eCA.MultiTransRequestServlet\' >\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" >\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'fields\' width=\'50%\'>\n\t\t\t\t\n\t\t\t\t\n\t\t\t<!--\t<select name=\"transcriber\" id=\"transcriber\" onChange=\"\">\n\t\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="---</option> -->\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<!--\t<option value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option> -->\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<input type=\'hidden\' name=\'transcriber\' id=\'transcriber\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t\t<input type=\'text\' name=\'transcriber_desc\' id=\'transcriber_desc\' size=30 maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onBlur =\"getTranscriber_notes(this);\" ><input type=\'button\' class=\'button\' value=\'?\' id=\'src_butn\'  name=\'search_pract\' id=\'search_pract\' onClick=\"getTranscriber_notes1(this);\" ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t\n\t\t\t<!--\t</select> -->\n\t\t\t\n\t\t\t</td>\n\t\t\t<td class=\'label\' width=\'25%\'></td>\n\t\t</tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t<td class=\'fields\' width=\'75%\'>\n\t\t\t\t<textarea name=\"remarks\" rows=\'13\' maxlength=400   onKeyPress=\'\'   onBlur=\"\" cols=\'70\' ></textarea>\n\t\t\t\n\t\t\t</td>\n\n\t\t</tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t<tr><td>&nbsp;</td></tr>\n\t\t\n\t\t<tr>\n\t\t\t<td class=\'label\' width=\'25%\' ></td><td width=\'25%\' align=\'right\'><input type=\'button\' class=\'button\' value=\'Apply\'  name=\'apply\' id=\'apply\' onClick=\"onApply();\">\n\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'cancel_btn\'  name=\'cancel_btn\' onClick=\"window.close();\"></td>\n\t\t</tr>\n\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"note_type\" id=\"note_type\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"practitionerId\" id=\"practitionerId\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"bean_key\" id=\"bean_key\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"modal_yn\" id=\"modal_yn\" value=\"Y\">\n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t</form>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );
	
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
		
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		 java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
		 String locale = (String) p1.getProperty("LOCALE");
		 String userId =((String) session.getValue("ca_practitioner_id")).trim();
		 String facility_id		=	(String) session.getValue("facility_id");

		 eCA.PatientBannerGroupLine multiTransBean = null;

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		String dft_transc_qry ="select CA_GET_DEFAULT_TRANSCRIBER(?,?,?) dft_transcriber,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,?,?),?,'1') DEFAULT_TRANSCRIBER_DESC from dual ";

		String transcriber_qry = "select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_LANG_VW where PRACT_TYPE = 'TR' and LANGUAGE_ID = ? order by 2 ";

		String practitioner_id ="";
		String practitioner_name ="";
		String bean_key				 =	"";
		String CurrentDate			 =	"";
		String CurrentTime			 =	"";
		String patient_id			 =	"";
		String encounter_id			 =	"";
		String note_type			 =	"";
		String patient_class		 =	"";
		String speciality_code		 =	"";
		String performed_by_id		 =	"";
		String dft_transcriber		 =	"";
		String dft_transcriber_desc		 =	"";
		String trans_sel			 =	"";
		

		patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
		encounter_id			=	(request.getParameter("encounter_id")==null)	?	""	:	request.getParameter("encounter_id");
		note_type			=	(request.getParameter("note_type")==null)	?	""	:	request.getParameter("note_type");
		patient_class			=	(request.getParameter("patient_class")==null)	?	""	:	request.getParameter("patient_class");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		performed_by_id			=	(request.getParameter("performed_by_id")==null)	?	""	:	request.getParameter("performed_by_id");

		CurrentDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		CurrentTime	= com.ehis.util.DateUtils.getCurrentDate("HM",locale);

		bean_key = userId+CurrentDate+CurrentTime;

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);



	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		
			try
			{
			
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(dft_transc_qry);
			
			stmt.setString(1,performed_by_id);
			stmt.setString(2,speciality_code);
			stmt.setString(3,patient_class);
			stmt.setString(4,performed_by_id);
			stmt.setString(5,speciality_code);
			stmt.setString(6,patient_class);
			stmt.setString(7,locale);

			rs = stmt.executeQuery();

			while(rs.next())
				{
					
					dft_transcriber = rs.getString("dft_transcriber")==null?"":rs.getString("dft_transcriber");
					dft_transcriber_desc = rs.getString("DEFAULT_TRANSCRIBER_DESC")==null?"":rs.getString("DEFAULT_TRANSCRIBER_DESC");
				


				}
				
				if (rs!=null)	rs.close();
				if (stmt!=null) stmt.close();

			
			stmt = con.prepareStatement(transcriber_qry);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();

				while(rs.next())
				{
					
					practitioner_id = rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID");

					practitioner_name = rs.getString("PRACTITIONER_NAME")==null?"":rs.getString("PRACTITIONER_NAME");
					if(dft_transcriber.equals(practitioner_id))
						{
							trans_sel="selected";
						}
						else
						{
							trans_sel="";
						}

					
					
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trans_sel));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
					


				}
				if (rs!=null)	rs.close();
				if (stmt!=null) stmt.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			finally 
			{
				ConnectionManager.returnConnection(con,request);
			}
		
		
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dft_transcriber));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dft_transcriber_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(userId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(bean_key));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TranscribeNotes.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Transcriber.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
