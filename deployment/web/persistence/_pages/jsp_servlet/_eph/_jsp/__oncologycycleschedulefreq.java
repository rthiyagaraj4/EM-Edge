package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import eOR.*;
import eOR.Common.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __oncologycycleschedulefreq extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyCycleScheduleFreq.jsp", 1709120982243L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/dchk.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n\t\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../js/OncologyRegimen.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../js/PhCommon.js\"></script>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\t<title>Schedule</title>\n\t\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"onCologyCycleScheduleFreq\" id=\"onCologyCycleScheduleFreq\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t<table border=\"0\"  cellpadding=0 cellspacing=0 width=\"100%\" style=\"top-margin:0\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<td id=\"timeLegend\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr><input type=\"checkbox\" name=\"cycle_checked_yn_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"cycle_checked_yn_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" onclick = \"assignValueSchFreq(this,\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\')\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"><!--ML-MMOH-CRF-1004-->\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td align= \"right\" width = \"10%\"> <input type=\"text\" name=\"cycle_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"cycle_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" size=\"5\" maxlength=\"5\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\"  onchange = \"calcStartDateForWeek(this,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'N\',\'C\')\" value = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" tabIndex=\"1\" ></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <!--maxlength=\"5\" added for ICN-65327 -->\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n&nbsp;&nbsp;&nbsp;&nbsp;<td align= \"right\" width = \"10%\"> <input type=\"text\" name=\"admin_day_";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" id=\"admin_day_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" size=\"5\" maxlength=\"5\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onchange = \"calcStartDateForDay(this,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\',\'Y\')\" value = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" tabIndex=\"1\" ></td>&nbsp;&nbsp;&nbsp;&nbsp; <!--maxlength=\"5\" added for ICN-65327 -->\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<td width = \"2%\"><select name=\"admin_day_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" onchange = \"calcStartDateForWeek(this,\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'N\',\'\');\" ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =">\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<option value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" selected>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" </option>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n</select>\n</td>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<td align=\"center\" width = \"3%\">\n\t\t<input type=\"text\" name=\"cycle_start_date_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"cycle_start_date_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onblur=\"changeStartDate(this,\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\"  MAXLENGTH=\"16\" SIZE = \"13\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="> \n\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'cycle_start_date_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',null,\'hh:mm\');\n\t\tdocument.onCologyCycleScheduleFreq.cycle_start_date_0.focus(); return false;\" >\n\t</td>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\n\t<td align=\"center\" width = \"3%\" >\n\t<input type=\"text\" name=\"cycle_start_date_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" readonly MAXLENGTH=\"16\" SIZE = \"13\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',null,\'hh:mm\');\n\t\treturn false;\" disabled>\n\t<!--<label class=\"label\" id = \"cycle_start_date_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</label>--></td>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="<td align=\"center\">\n<input type=\"text\" name = \"time_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" size=\'5\' maxlength=\'5\' onBlur=\'parent.timeChk(this);\' value = \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"><img src=\"../../eCommon/images/mandatory.gif\" border=\"0\"></img></td><!-- img added for ML-MMOH-CRF-1004 -->\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n<!--\t<td align=\"center\"><label class=\"label\" id = \"cycle_end_date_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</label>\n\t</td>-->\n\t<input type = \"hidden\" name =\"cycle_end_date_";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" value = \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type = \"hidden\" name =\"def_admin_day_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\"><!-- added for ML-MMOH-CRF-1228-->\n\t<input type = \"hidden\" name =\"def_cycle_";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"><!-- ML-MMOH-CRF-1228-->\n<br>\n</tr>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t\n\t<input type = \"hidden\" name = \"no_of_cycle\" value = \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type = \"hidden\" name = \"repeat_value\" value = \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type = \"hidden\" name = \"repeat_durn_type\" value = \"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type = \"hidden\" name = \"drug_code\" value = \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type = \"hidden\" name = \"srl_no\" value = \"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type = \"hidden\" name = \"start_date_time\" value = \"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type = \"hidden\" name = \"end_date_time\" value = \"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type = \"hidden\" name = \"first_start_date\" value = \"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type = \"hidden\" name = \"locale\" value = \"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"><!-- added for ML-MMOH-CRF-1228-->\n\t\n\n\t<input type = \"button\" value = \"OK\" onclick = \"setChangedCycleAdminTime();\">\n\t<input type = \"button\" value = \"Cancel\" onclick = \"window.close();\">\n\n\t\n\t</form>\n\t</body>\n\n</html>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		String locale = (String) session.getAttribute("LOCALE");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

try{

	String start_date_time	= request.getParameter("start_date"); 
	String drug_code		= request.getParameter("drug_code"); 
	String srl_no			= request.getParameter("srl_no"); 
	String no_of_cycle		= request.getParameter("no_of_cycle"); 
	String repeat_durn_type = request.getParameter("repeat_durn_type");
	String order_type_flag	= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");


	String hrsHtml = "";
	String hrsHtmlInital = "";
	String hrsHtmlFinal = "";
	String bean_id			= request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name");
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	
	String facility_id	= "";
	facility_id	= (String) session.getValue("facility_id");

	HashMap hm = bean.getCycleDetails();
	HashMap hm_details = null;
	System.err.println("OncologyCycleScheduleFreq.jsp=============dssd======40==getCycleDetails==>"+bean.getCycleDetails());
	if(hm!=null && hm.size()>0){
		hm_details = (HashMap)hm.get(drug_code+srl_no);//
	}
		System.err.println("OncologyCycleScheduleFreq.jsp==51===>");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block11Bytes, _wl_block11);

		System.err.println("OncologyCycleScheduleFreq.jsp==60==repeat_durn_type=>"+repeat_durn_type);
			if(repeat_durn_type.equals("W") )
			{
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='100%' align='center'><th align='left' width ='1%'></th><th align='left' width ='5%' >Cycle Week</th><th align='center' width ='2%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' width ='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}else if(repeat_durn_type.equals("D")){
			
			hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><td></td><table border='1' width='100%' align='center'><th align='left' width ='1%' > </th><th align='center' width ='3%' >Cycle Day</th><th align='center' width ='4%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	
			}

			if(repeat_durn_type.equals("L")){
				
				hrsHtmlInital =hrsHtmlInital+"</tr><tr><td>&nbsp;</td></tr><tr><table border='1' width='100%' align='center'><th align='left' width ='1%' ></th><th align='left' width ='5%' >Cycle Month</th><th align='center' width ='2%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.day.label","common_labels")+"</th><th align='center' width ='5%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.startdatetime.label","common_labels")+"</th><th  align='center' width ='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.time.label","common_labels")+"</th><tr>";	

			}

			hrsHtmlFinal = "</table></tr></table>";
			hrsHtml =hrsHtmlInital + hrsHtml + hrsHtmlFinal ; 

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(hrsHtml));
            _bw.write(_wl_block13Bytes, _wl_block13);

			System.err.println("OncologyCycleScheduleFreq.jsp==82===>");

	ArrayList time = new ArrayList();
	ArrayList time_list = null;
	String day_list = "";
	String start_date = "";
	String end_date   = "";
	String cycle_no   = "";
	String first_start_date = "";
	String disable_cycle    = "";
	int no_of_day		=1;
	String cycle_checked		= "";//ML-MMOH-CRF-1004
	String cycle_checked_yn	= "";//ML-MMOH-CRF-1004
	String def_admin_day    = "";//ML-MMOH-CRF-1228

	if(repeat_durn_type.equals("W"))
			no_of_day = 7;
	/*else{ 
		if(repeat_durn_type.equals("L"))
		   no_of_day = 31;


	} */

	

	for(int i=0;i<Integer.parseInt(no_of_cycle);i++){
		start_date = start_date_time;
		if(hm_details!=null){
			time_list	= (ArrayList)hm_details.get("cycle_"+i);
			time		= (ArrayList)time_list.get(0);
			day_list	= (String)time_list.get(1);
			cycle_no	= (String)time_list.get(2);
			start_date  = (String)time_list.get(3);
			end_date	= (String)time_list.get(4);
			cycle_checked_yn	= (String)time_list.get(5);//ML-MMOH-CRF-1004
		}
		if(i==0)
		first_start_date = start_date;
		disable_cycle = "";
		
		if(order_type_flag.equals("Existing")){
			disable_cycle = "disabled";
		}
		if(repeat_durn_type.equals("L")){
			no_of_day = 31;	
		}
		if(cycle_checked_yn.equals("Y")){//ML-MMOH-CRF-1004 - start
			cycle_checked = "checked";
			cycle_checked_yn = "Y";
		}
		else{
			cycle_checked = "";
			cycle_checked_yn = "N";
		}//ML-MMOH-CRF-1004 - end

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(cycle_checked));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cycle_checked_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_cycle));
            _bw.write(_wl_block25Bytes, _wl_block25);
}else{
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(day_list));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_cycle));
            _bw.write(_wl_block30Bytes, _wl_block30);
	}

if(repeat_durn_type.equals("W") || repeat_durn_type.equals("L")){

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(disable_cycle));
            _bw.write(_wl_block34Bytes, _wl_block34);

for(int j=1;j<=no_of_day;j++){
	if(j==Integer.parseInt(day_list)){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
else{
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(j));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(j));
            _bw.write(_wl_block37Bytes, _wl_block37);
}
}
            _bw.write(_wl_block39Bytes, _wl_block39);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
	if(i==0){
	
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disable_cycle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
}else{
	/*if(repeat_durn_type.equals("W"))
		start_date = bean.getSysdatePlusDays(start_date,(Integer.parseInt(cycle_no)*7)+"");
	else{
	  if(repeat_durn_type.equals("L"))
		start_date = bean.getSysdatePlusDays(start_date,(Integer.parseInt(cycle_no)*30)+"");
	} */

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(disable_cycle));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block51Bytes, _wl_block51);
}

for(int k=0;k<time.size();k++){
	
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(k));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(time.get(k)));
            _bw.write(_wl_block55Bytes, _wl_block55);
}

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getSysdatePlusDays(start_date,"1")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(day_list));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block61Bytes, _wl_block61);
	
}


            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(no_of_cycle));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(time.size()));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(start_date_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(first_start_date));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block71Bytes, _wl_block71);
	putObjectInBean(bean_id,bean,request);

}catch(Exception exception) {
       exception.printStackTrace();
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
}
