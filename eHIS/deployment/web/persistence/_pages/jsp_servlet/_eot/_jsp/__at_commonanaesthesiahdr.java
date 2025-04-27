package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import java.util.*;
import com.ehis.util.*;

public final class __at_commonanaesthesiahdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AT_CommonAnaesthesiaHdr.jsp", 1709120152000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="                         \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\"StyleSheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script> \n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordAnesthesiaDetails.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOT/js/AT_RecordIntraAnesthesia.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/AT_PostAnaesthesia.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\'javascript\'>\n\tfunction loadToSecondFrame(){\n\t\tvar frmObj=document.forms[0];\t\n\t\tvar params=frmObj.params.value;\t\t\n\t\tvar locale=frmObj.locale.value;\t\t\n\t\t//params=params+\"&anaesthesia_code=\"+frmObj.anaesthesia_code.value+\"&start_time=\"+frmObj.start_time.value+\"&end_time=\"+frmObj.end_time.value+\"&anaesthetist_code1=\"+frmObj.anaesthetist_code1.value+\"&anaesthetist_code2=\"+frmObj.anaesthetist_code2.value+\"&rec_start_date_time=\"+dateUtils((frmObj.rec_start_date_time.value),locale,\'DMYHM\')+\"&rec_finish_date_time=\"+dateUtils((frmObj.rec_finish_date_time.value),locale,\'DMYHM\')+\"&accession_num=\"+frmObj.accession_num.value;//Commented against SKR-SCF-1286\n\n\t\tparams=params+\"&anaesthesia_code=\"+frmObj.anaesthesia_code.value+\"&start_time=\"+frmObj.start_time.value+\"&end_time=\"+frmObj.end_time.value+\"&anaesthetist_code1=\"+frmObj.anaesthetist_code1.value+\"&anaesthetist_code2=\"+frmObj.anaesthetist_code2.value+\"&rec_start_date_time=\"+frmObj.rec_start_date_time.value+\"&rec_finish_date_time=\"+frmObj.rec_finish_date_time.value+\"&accession_num=\"+frmObj.accession_num.value;//Added against SKR-SCF-1286\n\n\t\tif(frmObj.flag.value==\'POST\')\t{\t\n\t\t\tparent.frames[3].location.href=\'../../eOT/jsp/AT_AnaesthesiaParticulars.jsp?\'+params; }\n\t\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"RecordAnesthesiaHdrForm\" id=\"RecordAnesthesiaHdrForm\" >\n<table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n<tr>\n\t\t<td  class=\'label\' width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</td>\t\n\t\t<td  class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\"text\" name=\"anaes_srl_no\" id=\"anaes_srl_no\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" readonly>\n\t\t</td>\t\n\t\t<input type=\"hidden\"  name=\"source_id\" id=\"source_id\" size=\'17\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" readonly>\t\n\t\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' size=\'10\' value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" readonly>\n\t\t<input type=\'hidden\' name=\'patient_class_desc\' id=\'patient_class_desc\' size=\'10\' value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" readonly>\n\t\t  \n\t\t<td  class=\'label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td>\t\t\t\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\"text\"  name=\"accession_num\" id=\"accession_num\" size=\'18\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" readonly ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t</td>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" size=\'10\'  value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" readonly>\n\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" size=\'30\'  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" readonly> \n\t\t<input type=\"hidden\"  name=\"sex\" id=\"sex\" size=\'2\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" readonly>\n\t\t<input type=\"hidden\"  name=\"dob\" id=\"dob\" size=\'10\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" readonly>\n<tr>\n\t\t<td  class=\'label\' width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\"text\" name=\"weight\" id=\"weight\" size=\'4\'  maxlength=\'6\'  onKeyPress=\"return allowValidNumber(this,event,\'3\',\'2\');\" onBlur=\"if(this.value !=\'\'){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">(";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =")\n\t\t</td>\n\n\t\t<td class=\'label\' width=\"25%\">\t\t\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td  class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\"text\" name=\"height\" id=\"height\" size=\'4\' maxlength=\'6\'   onKeyPress=\"return allowValidNumber(this,event,\'3\',\'2\');\"  onBlur=\"if(this.value !=\'\'){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =")\n\t\t</td>\t\t\n</tr>\n\t\t<input type=\"hidden\" name=\"surgeon_name\" id=\"surgeon_name\" size=\'27\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" readonly>\n<tr>\n\t\t\n\t\t\n\t\t<td class=\'label\' width=\"25%\" >\n\t\t\t ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t<!--Condition Added for IN024805 -->\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<input type=\"text\"  name=\"bsaDisp\" id=\"bsaDisp\" size=\'5\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" readonly>\n\t\t<input type=\"hidden\"  name=\"bsa\" id=\"bsa\"  value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<input type=\"hidden\"  name=\"bsa\" id=\"bsa\" size=\'5\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\t\t<input type=\"text\"  name=\"bsaDisp\" id=\"bsaDisp\"  value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" disabled>\n\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t</td>\n\t\t<td  class=\'label\' width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\" >\n\t\t\t<input type=\"text\"  name=\"bmi\" id=\"bmi\"  size=\'5\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" readonly>\n\t\t\t<input type=\"text\"  name=\"status_desc\" id=\"status_desc\" size=\'18\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" readonly>\n\t\t</td>\n</tr> \n<tr>\n<!-- crf - 0021 -->\n <td class=\'Label\' width=\"25%\"  >\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" \n\t</td>\n\n\t<td class=\'fields\' width=\"25%\" >\n\t\t<input type=\"text\"  name=\"asa\" id=\"asa\"  size=\'5\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" disabled>\n\t\t\n\t</td>\n<!--<td  class=\'label\' width=\"25%\" ></td>\n<td  class=\'label\' width=\"25%\" ></td> -->\n\t\t\n\t<td >\n\t\t<a class=\'gridLink\' href=\"javascript:callPostAnesthesiaNotes();\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>\n\t</td>\t\t\t\n\t<td >\n\t\t<a class=\'gridLink\' href=\"javascript:callRecordChart();\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a>\n\t</td>\t\n\n</tr>\n\n<tr>\n\t\t<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" size=\'8\'  value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" readonly>\t\n\t\t\t\n\n</tr>\n</table>\n\t<input type=\'hidden\' name=\'anesthesia_srl_no\' id=\'anesthesia_srl_no\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\'hidden\' name=\'chart_id\' id=\'chart_id\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\'hidden\' name=\'anaesthesia_code\' id=\'anaesthesia_code\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\'hidden\' name=\'anaesthetist_code1\' id=\'anaesthetist_code1\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\'hidden\' name=\'anaesthetist_code2\' id=\'anaesthetist_code2\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\'hidden\' name=\'end_time\' id=\'end_time\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\'hidden\' name=\'rec_start_date_time\' id=\'rec_start_date_time\' value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\'hidden\' name=\'rec_finish_date_time\' id=\'rec_finish_date_time\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\'hidden\' name=\'strUser\' id=\'strUser\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n   <script> loadToSecondFrame()</script>     \n ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

  String locale = (String)session.getAttribute("LOCALE");
   String slate_user_id = CommonBean.checkForNull( request.getParameter("login_user") ); 
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",stranaesthesiaCode="",stranaesthetistCode1="",stranaesthetistCode2="",strStartTime="",strEndTime="",strAccessionNum="",strRecoveryStartTime="",strRecoveryEndTime="",flag="",postop_done_yn="",postop_done_yn_DB="",post_disable_flag="",strBMIDesc="",strEpisodeType="",asa_score_code = "";  //Added asa_score_code crf//0021
  //Added by AnithaJ for IN024805 on 11/3/2010
  double bsaDisp = 0.0;

 flag=CommonBean.checkForNull(request.getParameter("anesthesia_flag"));
  String strUser ="";
  String slate_user_id_disp = CommonBean.checkForNull(request.getParameter("slate_user_id")).toUpperCase();
   if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }


//Modified by dhanasekarV 19/01/2011

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	 String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,to_char(START_TIME,'dd/mm/yyyy hh24:mi') START_TIME1,to_char(END_TIME,'dd/mm/yyyy hh24:mi') END_TIME1,ACCESSION_NUM ACC_NUM,TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') REC_ST_TIME, TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') REC_END_TIME,POSTOP_DONE_YN,ASA_SCORE_CODE FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";  //Added asa_score_code  for crf-0021

  try{
	conn = ConnectionManager.getConnection(request);

	strAnesthesiaSrlNo=CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	postop_done_yn=CommonBean.checkForNull(request.getParameter("postop_done_yn"));
	  pstmt=conn.prepareCall(sql);
	  pstmt.setString(1,facility_id);
	  pstmt.setString(2,strAnesthesiaSrlNo);
	  rs=pstmt.executeQuery();
  if(rs.next())
  {
	strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
	strHeight=CommonBean.checkForNull(rs.getString("HEIGHT1"));
	strWeight=CommonBean.checkForNull(rs.getString("WEIGHT1"));
	strBSA=CommonBean.checkForNull(rs.getString("BSA1"));
	asa_score_code=CommonBean.checkForNull(rs.getString("ASA_SCORE_CODE")); //crf-0021
	if(!strBSA.equals(""))
	{
		bsaDisp=Double.parseDouble(strBSA);
	}
	strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
	strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
	stranaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
	stranaesthetistCode1=CommonBean.checkForNull(rs.getString("ANAESTHETIST1_CODE1"));
	stranaesthetistCode2=CommonBean.checkForNull(rs.getString("ANAESTHETIST2_CODE1"));
	strStartTime=CommonBean.checkForNull(rs.getString("START_TIME1"));
	strEndTime=CommonBean.checkForNull(rs.getString("END_TIME1"));
	strAccessionNum=CommonBean.checkForNull(rs.getString("ACC_NUM"));
	strRecoveryStartTime=CommonBean.checkForNull(rs.getString("REC_ST_TIME"));
	strRecoveryEndTime=CommonBean.checkForNull(rs.getString("REC_END_TIME"));
	postop_done_yn_DB=CommonBean.checkForNull(rs.getString("POSTOP_DONE_YN"));

  }

if(postop_done_yn.equals("Y") ){
	post_disable_flag="disabled";
}
  if(rs!=null) rs.close();
  if(pstmt!=null) pstmt.close();

  //Added below qry to fetch func_role_id associated to slate user id on 1/19/2011 by Anitha for 25928
	pstmt=conn.prepareCall("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
	pstmt.setString(1,slate_user_id_disp);
	pstmt.setString(2,locale);
	rs=pstmt.executeQuery();
	if(rs.next()){
		strUser=CommonBean.checkForNull(rs.getString("func_role_id"));
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strSourceOrderId);
rs=pstmt.executeQuery();

if(rs.next())
{
strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
strEpisodeId=CommonBean.checkForNull(rs.getString("EPISODE_ID1"));
strSourceType=CommonBean.checkForNull(rs.getString("SOURCE_TYPE1"));
strSourceCode=CommonBean.checkForNull(rs.getString("SOURCE_CODE1"));
strSurgeonCode=CommonBean.checkForNull(rs.getString("ORD_PRACT_ID1"));
strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMY","en",locale));

}
if(rs!=null) rs.close();
pstmt.close();


sql="SELECT PATIENT_NAME SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT WHERE PATIENT_ID =?";
 pstmt = conn.prepareStatement(sql);
 pstmt.setString(1,strPatientId);
 rs=pstmt.executeQuery();
 if(rs.next())
  {
 strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
 strAge=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
 strSex=CommonBean.checkForNull(rs.getString("SEX1"));
  }
sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
pstmt=conn.prepareCall(sql);
pstmt.setString(1,strPatientClass);
rs=pstmt.executeQuery();
if(rs.next())
{
strPatientClassDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();
if(strSourceType.equals("W")||strSourceType.equals("N"))
{
  sql=  "SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE =?";
  strReferralSource="Wards";
}	else
  if(strSourceType.equals("C"))
  {
   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE=?";
	strReferralSource="Clinics";
  }
   else
  if(strSourceType.equals("R"))
  {
   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND  NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE=?";
strReferralSource="Referral";
  }
  
pstmt=conn.prepareCall(sql);
pstmt.setString(1,facility_id);
pstmt.setString(2,strSourceCode);
rs=pstmt.executeQuery();
if(rs.next())
{
strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();

sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=?";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strSurgeonCode);
rs=pstmt.executeQuery();
if(rs.next())
{
strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
}
if(rs!=null) rs.close();
pstmt.close();


sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strPatientClass);
rs=pstmt.executeQuery();
if(rs.next())
{
strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
}
if(rs!=null) rs.close();
pstmt.close();

sql="SELECT POST_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";

pstmt=conn.prepareCall(sql);
rs=pstmt.executeQuery();
if(rs.next())
{
chartId=CommonBean.checkForNull(rs.getString("CHART_ID"));
}
if(rs!=null) rs.close();
pstmt.close();






if(strBMI.length()>0)
{
sql="SELECT STATUS_DESC  STATUS_DESC1 FROM AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strBMI);
rs=pstmt.executeQuery();
if(rs.next())
{
strBMIDesc=CommonBean.checkForNull(rs.getString("STATUS_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();
}


}catch(Exception ee)
{
	System.err.println("exception in AT common Anaes header:"+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strAnesthesiaSrlNo));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strSourceOrderId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(strEncounterId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strPatientClassDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(strAccessionNum));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(post_disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strPatientId));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strName));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(strSex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strAge));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strWeight));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(post_disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strHeight));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(post_disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!strBSA.equals("")){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bsaDisp));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
		else{
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(strBSA));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strBMI));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(strBMIDesc));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(asa_score_code));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(strSurgeryDate));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(strAnesthesiaSrlNo));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strEpisodeId));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strEpisodeType));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(strPatientClass));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(chartId));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(stranaesthesiaCode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(stranaesthetistCode1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(stranaesthetistCode2));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strStartTime));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strEndTime));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strRecoveryStartTime));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strRecoveryEndTime));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block62Bytes, _wl_block62);

  if( flag.equals("POST")==true){
   
            _bw.write(_wl_block63Bytes, _wl_block63);

   }
 
            _bw.write(_wl_block64Bytes, _wl_block64);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AnaesSerialNo.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessionNum.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weight.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.height.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cms.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BSA.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BMIDetails.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsaScore.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PostAnaesthesiaNotes.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecordChart.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }
}
