package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __tpnregnonstdreg extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/TPNRegNonStdReg.jsp", 1709121521014L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/TPNNonStdRegimen.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/CommonLookup.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/FieldFormatMethods.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PHReports.js\"></SCRIPT>\n\t\n\t <!-- <SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/TPNRegimen.js\"></SCRIPT> --> \n</HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- <BODY> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t<FORM name=\"TpnNonStandardRegimen\" id=\"TpnNonStandardRegimen\">\n\t<table width=\"100%\">\n\t<tr nowrap>\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t <Td   class=\"label\" align=\"left\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t&nbsp;&nbsp;<INPUT TYPE=\"checkbox\"  name=\"paed_regmn\" id=\"paed_regmn\" id=\"paed_regmn\"  onClick=\"\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="> </TD>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<td class=\"label\" height=\"23px\" width=\"30%\" nowrap>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;<input type=\"text\" name=\"stdregimen\" id=\"stdregimen\" maxlength=30  size=30 value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" readonly> <INPUT TYPE=\"button\" CLASS=\"button\" id=\"nonstdbtn\" VALUE=\"?\"\n\t\t\tonfocus=\"\"\n\t\t\tonClick=\"searchNonStandardRegimen(stdregimen)\" STYLE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" STYLE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t </td>\n\t    <td class=\"label\" nowrap><label id=\"npc_la\" name=\"npc_la\" STYLE=\"font-weight:bold;\" align=\"center\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</label>\n\t\t</td>\n\t\t<Td   class=\"label\" align=\"left\" nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t   <input type=text onKeyPress=\"return(ChkNumberInput(this,event,0));\"   onchange=\"CheckNum(this);CheckPositiveNumber(this);reload(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\')\"  class=\"number\" name=\"volume\" maxlength=5 size=5 value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >&nbsp;<label id=\'volumeunit\' name=\'volumeunit\'><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B><img src=\"../../eCommon/images/mandatory.gif\"></TD>\n\t\t</tr>\n\t\t</table>\n\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" id=\"tabs\" name=\"tabs\" id=\"tabs\">\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<Td class=\"hyperlink1\" id=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'   name=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  onClick=\"showDiv(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'parent.DetailFrame.document\');colorTabs(this)\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </td>\n\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\n\t\t\t\t<Td id=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" </td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t<Td  class=\"hyperlink1\" id=\"name1\" name=\"name1\" onClick=\"colorTabs(this);adminDetails(\'parent.DetailFrame.document\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\');\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t</TR>\n\t\t\n</TABLE>\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<INPUT TYPE=\"hidden\" name=\"SQL_PH_TPN_NON_STD_REGIMEN_SELECT1AA\" id=\"SQL_PH_TPN_NON_STD_REGIMEN_SELECT1AA\" value=\"SELECT   TPN_REGIMEN_CODE CODE,   DFLT_TPN_ROUTE,   TOTAL_VOLUME,LONG_NAME DESCRIPTION,   b.QTY_UOM PRES_BASE_UNIT,   ITEM_CODE,   INFUSE_OVERDURN_TYPE,   INFUSE_OVER_VALUE,   B.ORDER_TYPE_CODE,   CONSENT_REQD_YN,   ORD_AUTH_REQD_YN,   ORD_COSIGN_REQD_YN,   ORD_SPL_APPR_REQD_YN,   FREQ_CODE,   DURN_VALUE,   DURN_TYPE,   CHK_FOR_MAX_DURN_ACTION,   PROMPT_MSG,   MAX_DURN_VALUE FROM     PH_TPN_REGIMEN A,  OR_ORDER_CATALOG B,   OR_ORDER_CATALOG_BY_PTCL C WHERE    STANDARD_REGIMEN_YN=\'N\' AND   A.TPN_REGIMEN_CODE=B.ORDER_CATALOG_CODE AND   B.ORDER_CATALOG_CODE=C.ORDER_CATALOG_CODE   AND A.PEAD_TPN_REGIMEN_YN LIKE (NVL(?,A.PEAD_TPN_REGIMEN_YN)) and  exists (select \'Y\' from PH_TPN_CONSTITUENT_LIMIT where TPN_REGIMEN_CODE=A.TPN_REGIMEN_CODE and age_group_code in (select age_group_code from am_age_group where nvl(gender,(select sex from mp_patient where patient_id LIKE UPPER(?)))=(select sex from mp_patient where patient_id LIKE UPPER(?))  and trunc(sysdate)-(select trunc(date_of_birth) from mp_patient where patient_id LIKE UPPER(?)) between  decode(age_unit,\'Y\',365,\'M\',30,1)*min_age and decode(age_unit,\'Y\',365,\'M\',30,1)*max_age and eff_status=\'E\' )) AND TPN_REGIMEN_CODE LIKE (?) AND LONG_NAME LIKE (?) \">\n\t\n\t\n\t<input type=\"hidden\" name=\"start_date\" id=\"start_date\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"patient_height\" id=\"patient_height\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"> \n<input type=\"hidden\" name=\"patient_weight\" id=\"patient_weight\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"stdregimen_hidden\" id=\"stdregimen_hidden\" value=\"\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"QueryString\" id=\"QueryString\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"> \n<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\"hidden\" name=\"problem_ind\" id=\"problem_ind\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<input type=\"hidden\" name=\"regimen_code\" id=\"regimen_code\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n<input type=\"hidden\" name=\"ped_regmn\" id=\"ped_regmn\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n<input type=\"hidden\" name=\"volumeunit1\" id=\"volumeunit1\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\n\n<input type=\"hidden\" name=\"infroute1\" id=\"infroute1\" value=\"\">\n<input type=\"hidden\" name=\"infusevalue1\" id=\"infusevalue1\" value=\"\">\n<input type=\"hidden\" name=\"durnvalue1\" id=\"durnvalue1\" value=\"\">\n<input type=\"hidden\" name=\"startdate1\" id=\"startdate1\" value=\"\">\n<input type=\"hidden\" name=\"end_date1\" id=\"end_date1\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"tpn_tab_reg\" id=\"tpn_tab_reg\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><!-- added for ml-mmoh-crf-1290 -->\n\t\n</FORM>\n\t\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<script>\n   // callresult(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\');\n\t//alert(\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\n\tparent.DetailFrame.location.href =\"../../ePH/jsp/TPNRegNonStdRegDetails.jsp?";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"; \n  \tparent.ButtonFrame.document.TpnButtons.Cancel.disabled=true;\n\tparent.ButtonFrame.document.TpnButtons.Release.disabled=true;\n\t\t\n</script>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );
	
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8 ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8 ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    String mode = request.getParameter("mode");
	String facility_id  = (String) session.getValue("facility_id");
	String uom=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.KCAL.label","ph_labels");
	String order_id								= request.getParameter("order_id");
	if(order_id == null){order_id="";}
	String weight								= request.getParameter("weight");
	String height								= request.getParameter("height");
	String reg_code                             =request.getParameter("code");
	String patient_id							= request.getParameter("patient_id");
	String encounter_id						    = request.getParameter("encounter_id");
	String start_date							= request.getParameter("start_date");

	String priority							    = request.getParameter("priority");
	String location_code						= request.getParameter("location_code");
	String location_type					    = request.getParameter("location_type");
	String pract_id							    = request.getParameter("pract_id");
	String act_patient_class					= request.getParameter("act_patient_class");
	String problem_ind							= request.getParameter("problem_ind");
	//String order_type_flag						= request.getParameter("order_type_flag");
	//String iv_prep_yn							= request.getParameter("iv_prep_yn");
	float wt                                    =Float.parseFloat(weight);
	
	String params								= request.getQueryString();
	String chk_addmixture		="";
	String alert_practitioner_yn="";
	//String time_flag            ="";
	String regCode			="";
	String routeCode		="";
	String totvolume		="";
	String unitofvolume		="";
	//String infusedurn		="";
	String infusevalue		=""; 
	String ordertypecode	="";
	String consentreqd		="";
	String authreqd			="";
	String cosignreqd		="";
	String splappreqd		="";
	//String freqcode			="";
	String durnvalue	 	="";
	String action_type 		="";
	String action_msg 		="";
	String max_durn 		="";
	String end_date 		="";
	String infuse           ="";
	String fluidValuesStd   ="";
	String code="";
	String desc="";
	String order_start_date =""; // Added for  [IN:031523]
	String shortname = "";      // added for [IN:031523] 

    String bean_id	= "@TPNNonStandardRegimenBean"+patient_id+encounter_id;
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean)getBeanObject(bean_id,bean_name, request);

	String bean_id1	= "@TPNStandardRegimenBean"+patient_id+encounter_id;
	String bean_name1	 = "ePH.TPNStandardRegimenBean";
	

	TPNStandardRegimenBean bean1 = (TPNStandardRegimenBean)getBeanObject(bean_id1,bean_name1,request);
	//ArrayList freqlist=bean1.getFrequencies();
	bean1.clear();	 
	bean1.setLanguageId(locale);

	String bean_id2				= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name2			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean2	= (TPNRegimenBean)getBeanObject(bean_id2,bean_name2,request) ;
	bean2.setLanguageId(locale);

	bean.clear();
	bean.setLanguageId(locale);

	ArrayList regimenDetails			=bean.getRegimenDetails();

	if(regimenDetails.size()!=0 && regimenDetails!=null){		
	 regCode			=(String)regimenDetails.get(0);
	 routeCode		=(String)regimenDetails.get(1);
	 totvolume		=(String)regimenDetails.get(2);
	 if(totvolume == null){totvolume="";}
	 if(!weight.equals("") && !fluidValuesStd.equals("")){
		totvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+"";
	    } 
	 unitofvolume		=(String)regimenDetails.get(4);
	 //infusedurn		=(String)regimenDetails.get(6);
	 infusevalue		=(String)regimenDetails.get(7);
	 ordertypecode	=(String)regimenDetails.get(8);
	 consentreqd		=(String)regimenDetails.get(9);
	 authreqd			=(String)regimenDetails.get(10);
	 cosignreqd		=(String)regimenDetails.get(11);
	 splappreqd		=(String)regimenDetails.get(12);
	 //freqcode			=(String)regimenDetails.get(13);
	 durnvalue	 	=(String)regimenDetails.get(14);
	 action_type 		=(String)regimenDetails.get(15);
	 action_msg 		=(String)regimenDetails.get(16);
	 max_durn 		=(String)regimenDetails.get(17);
	 end_date 		=(String)regimenDetails.get(18);
	}
 	//String shortname							=	bean.getRegimenName(start_date,reg_code);
	//ArrayList regmnDtls						    =   bean.getRegimenDetails();
    String regimen_code                         ="";
	String ord_regmn_ind                        ="";
	String max_weight                           ="";
	String min_weight                           ="";
	String disabled                             ="";
	String checked                              ="";
	totvolume                            =""; 
	unitofvolume                         ="";
	fluidValuesStd                              =  null;
	ArrayList fluidReq			                = new ArrayList();
	
	//ArrayList consResults						=	bean.getTPNGroups(patient_id,regimen_code);
	ArrayList uom_data                          =   bean.getUOMData();
	//ML-MMOH-CRF-1290 start
	boolean tpn_tab_reg = false;
	Connection	con=null;
	try{
		con	= ConnectionManager.getConnection(request);
		tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		con.close();
	}
	//ML-MMOH-CRF-1290 end
	if(uom_data.size()==0)
	{
		//out.println("<script>alert(getMessage('PH_UOM_TPN_CONST_NOT_SETUP'));</script>");
		out.println("<script>alert(getMessage('PH_UOM_TPN_CONST_NOT_SETUP','PH'));</script>");
	}
	else 
	{
    ord_regmn_ind                               =(String)uom_data.get(6);
	max_weight                                  =(String)uom_data.get(2);
	min_weight                                  =(String)uom_data.get(3);
	String pediatric_regimen_yn                 ="";
	
	float max_weight_uom=0.0f;
	float min_weight_uom=0.0f;
	if(max_weight!=null)
		max_weight_uom=Float.parseFloat(max_weight);
	if(min_weight!=null)
		min_weight_uom=Float.parseFloat(min_weight);
	if(ord_regmn_ind.equals("W") || ord_regmn_ind.equals("B") )
	{
		if((wt <= max_weight_uom) )
		{
			disabled="disabled";
			checked="checked";
			pediatric_regimen_yn="Y";
		}
		else if((wt > max_weight_uom) && (wt <= min_weight_uom))
		{
			disabled="";
			checked="checked";
			pediatric_regimen_yn="Y";
	    }
		else if(wt > min_weight_uom)
		{
          disabled="disabled";
	      checked="";
		  pediatric_regimen_yn="N";
		 
		}
	}
	if(!locale.equals("en")){ // added for [IN:031523] Start
	     order_start_date  = com.ehis.util.DateUtils.convertDate(start_date, "DMYHM",locale,"en");
 	     shortname							=	bean.getRegimenName(order_start_date,reg_code,patient_id);
	}else{
         shortname							=	bean.getRegimenName(start_date,reg_code,patient_id);
	}  // added for [IN:031523] End
	 ArrayList regmnDtls						    =   bean.getRegimenDetails();
	 if(regmnDtls.size()==0)
		 out.println("<script>alert(getMessage('PH_TPN_CONST_LIMIT_NOT_SETUP','PH'));</script>");
		// out.println("<script>alert('PH_TPN_CONST_LIMIT_NOT_SETUP');</script>");
	else
	{
		if(reg_code==null)
			regimen_code   =   (String)regmnDtls.get(0);
		else
			regimen_code = reg_code;

		fluidReq = bean.getFluidRequired(patient_id);
	  
		if(fluidReq != null) { fluidValuesStd = (String)fluidReq.get(3);}
     
		totvolume		=(String)regmnDtls.get(2);
		unitofvolume		=(String)regmnDtls.get(4);
		if(totvolume == null) { totvolume=""; }
		if(!weight.equals("") && !fluidValuesStd.equals(""))
		{
			totvolume=new Float(Math.ceil(Float.parseFloat(weight)*Float.parseFloat(fluidValuesStd))).intValue()+"";
	    }
		ArrayList consResults  =	bean.getTPNGroups(patient_id,regimen_code);

	// String params1=params;
     
	 
		if (shortname==null || shortname.equals("")){
			out.println("<script>error()</script>");
		}
		
		String visible_flag="";
	
		if(mode.equals("amend")){
			HashMap OrderDetails=bean.getOrderDetails1(order_id);
			
			shortname = (String)OrderDetails.get("CATALOG_DESC");
			
			visible_flag="visibility:hidden";
			totvolume=request.getParameter("volm");
			if(totvolume==null || totvolume.equals(""))
				totvolume = bean.getVolume(order_id);
		}
		params=params+"&volm="+totvolume;
     
		String ph_bean_name	= "ePH.PrescriptionBean_1";
		String ph_bean_id	= "@PrescriptionBean_1"+patient_id+encounter_id;

		PrescriptionBean_1 phbean = (PrescriptionBean_1)getBeanObject(ph_bean_id, ph_bean_name,request);
		bean.setPresRemarks(phbean.getPresRemarks());
		String cho		=bean2.getCabohydrateOrderQuantity();
		String protein	=bean2.getProteinOrderQuantity();
		String lipid	=bean2.getLipidOrderQuantity();
		ArrayList MNResults=bean.getTPNGenerics("MN",patient_id,regimen_code);
		ArrayList MNEnergies = bean.getMNEnergies();

		String carbo_ener = "";
		String lipid_ener = "";
		String prot_ener  = "";
		if(MNEnergies.size()>0){
			 carbo_ener = (String)MNEnergies.get(1);
			 lipid_ener = (String)MNEnergies.get(3);
			 prot_ener  = (String)MNEnergies.get(5);
		}
		//String MNdesc=bean.getDesc("MN");
		code="";
		String std="";
		String dflt="";
		String AbOrWt="";
		String cho_energy="";
		String pro_energy="";
		String li_energy="";
		String tot_energy="";
		String tot_chi_li="";
		String NPC="";
		//int wt=Integer.parseInt(weight);
		int i=0;
		HashMap OrderDetails=new HashMap();
		OrderDetails=bean.getOrderDetails2(order_id);
		if(MNResults.size() != 0)
		{
			for(i=0;i<MNResults.size();i+=11)
			{
				code		=(String)MNResults.get(i);
				AbOrWt      =(String)MNResults.get(i+3); 
				std		    =(String)MNResults.get(i+6);
				dflt		=(String)MNResults.get(i+7);
				if(OrderDetails.containsKey(code))
				{
//					String def_std=((Float.parseFloat((String)OrderDetails.get(code)))/ wt) + "";
					String def_std=((Float.parseFloat((String)OrderDetails.get(code)))) + "";
					std=def_std;
				}
				String relvalue="";
				String N2="";
				if (code.equals("CHO"))
				{
					if (!cho.equals(""))
						relvalue=cho;	
					else 
					{
						if (dflt.equals("Y"))
						{
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
								//relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						}
						else
							relvalue="";
					}
					cho_energy = Float.parseFloat(relvalue)*Float.parseFloat(carbo_ener)+"";
				}
				
				if (code.equals("PROTEIN"))
				{
					if (!protein.equals("")){
						relvalue=protein;	
					}
					else
					{
						if (dflt.equals("Y"))
						{
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
								//relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						}
						else
							relvalue="";	
					}
		
					N2=Float.parseFloat(relvalue)*(16.0/100.0)+"";
					pro_energy	 =Float.parseFloat(relvalue)*Float.parseFloat(prot_ener)+"";
				}
				if (code.equals("LIPID"))
				{
					if (!lipid.equals(""))
						relvalue=lipid;	
					else
					{
						if (dflt.equals("Y"))
							if(AbOrWt.equals("A"))
								relvalue=std;
							else
//								relvalue=Math.round((Float.parseFloat(std) * wt)) + "";
								relvalue=Math.round((Float.parseFloat(std) / wt)) + "";
						else
							relvalue="";	
					}
					li_energy = Float.parseFloat(relvalue)*Float.parseFloat(lipid_ener)+"";
				}
			
				if( !li_energy.equals("") && !cho_energy.equals("")&& !pro_energy.equals(""))
				{
					tot_energy	=((Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+(Float.parseFloat(pro_energy)))+"";
					tot_chi_li=(Float.parseFloat(li_energy))+(Float.parseFloat(cho_energy))+"";
					if(!N2.equals(""))
					NPC=(Math.round((Float.parseFloat(tot_chi_li))/(Float.parseFloat(N2))))+"";
				}
			}
		}

		String lab_value="     NPC:N Ratio    "+NPC+" :1  &nbsp;  Total Energy:"+tot_energy+" "+CommonBean.checkForNull(bean.getUomDisplay(facility_id,uom.toUpperCase())) ;
		String code1="";
		String desc1="";
		String lnk="";
		HashMap record1;
	 
		if(mode.equals("undefined"))
		{
			record1=new HashMap(); 
			record1=bean2.ChkAdMixture();
			chk_addmixture=(String)record1.get("IV_ADMIXTURE_APPL_YN");
			//alert_practitioner_yn=(String)record1.get("ALERT_PRACTITIONER_YN");
			//if(chk_addmixture.equals("Y"))
			//{		  
			   //time_flag=(String)record1.get("time_flag");
			//}
		}
	

            _bw.write(_wl_block9Bytes, _wl_block9);
          if(!mode.equals("amend")) {
				if(ord_regmn_ind.equals("W") || ord_regmn_ind.equals("B") ) { 
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(checked));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
				}
			}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(shortname));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(visible_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(visible_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(lab_value ));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(totvolume));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CommonBean.checkForNull(bean.getUomDisplay(facility_id,unitofvolume))));
            _bw.write(_wl_block23Bytes, _wl_block23);

		for (int t=0;t<consResults.size();t+=3)
		{		
			code1=(String)consResults.get(t);
			desc1=(String)consResults.get(t+1);
			lnk = (String)consResults.get(t+2);
			if (lnk == "Y"){
		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block28Bytes, _wl_block28);
	}else
			{
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(desc1));
            _bw.write(_wl_block31Bytes, _wl_block31);
	}
		}
		
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(params));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(height));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(weight));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean_id2));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean_name2));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(problem_ind));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(regimen_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(params));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pediatric_regimen_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(unitofvolume));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(tpn_tab_reg));
            _bw.write(_wl_block55Bytes, _wl_block55);
 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(bean_id1,bean1,request);
		putObjectInBean(bean_id2,bean2,request);
		putObjectInBean(ph_bean_id,phbean,request);
	
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(regimen_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(params));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(params));
            _bw.write(_wl_block59Bytes, _wl_block59);
	}
	}

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PediatricRegimen.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Regimen.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
