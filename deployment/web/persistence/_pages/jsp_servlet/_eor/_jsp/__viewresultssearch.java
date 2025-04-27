package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __viewresultssearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ViewResultsSearch.jsp", 1709120074000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n\n<html> \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<link rel=\"StyleSheer\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ViewResults.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<form name=\'view_results_search\' id=\'view_results_search\' target=\'messageFrame\' >\n<table cellpadding=0 cellspacing=0 border=0 width=\"98%\" align=center>\n\n<tr>\n\t\t<td class=\'label\' align=\"right\" nowrap>Period From</td>\n\t\t<td align=\"left\">&nbsp;<input type=\"text\" size=\"10\" maxlength=\"10\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" name=\"period_from\" onKeyPress=\"return OrAllowDateFormat();\" onBlur=\"CheckDate(this);checkWithSysDate(this);checkDateRange(this,period_to);\">\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarValidate(\'period_from\');\" style=\'cursor:pointer\'>&nbsp;\n\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t</td>\n\n\t\t<td class=\"label\" align=\"right\" nowrap>Period To</td>\n\t\t<td align=\"left\">&nbsp;<input type=\"text\" name=\"period_to\" id=\"period_to\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" size=\"10\" maxlength=\"10\" onBlur=\"CheckDate(this);checkWithSysDate(this);checkDateRange(period_from,this);\" onKeyPress=\"return OrAllowDateFormat();\" >\n\t\t<img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendarValidate(\'period_to\');\" style=\'cursor:pointer\'>\n\t\t<img src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t</td>\n\t\t\n\t\t<td class=label align=\'right\' nowrap>&nbsp;Normalcy Indicator</td>\n\t\t<td colspan=\'3\'>&nbsp;<SELECT name=\"normalcy_ind\" id=\"normalcy_ind\">\n\t\t\t\t<option value=\'*\'> -------- Select --------</option>\n\t\t\t\t<option value=\'N\' selected >Normal</option>\n\t\t\t\t<option value=\'A\'>Abnormal</option>\n\t\t\t\t<option value=\'C\'>Critically Abnormal </option>\n\t\t\t</SELECT>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t\n\t\t<td class=label align=\'right\' nowrap>&nbsp;Result Type</td>\n\t\t<td>&nbsp;<SELECT name=\"result_type\" id=\"result_type\">\n\t\t\t<option value=\"\" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">All</option>\n\t\t\t<option value=\"BLTF\" ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =">Blood Transfusion</option>\n\t\t\t<option value=\"LBIN\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =">Laboratory</option>\n\t\t\t<option value=\"RDIN\" ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =">Radiology</option>\n\t\t\t<option value=\"TRET\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">Treatment</option>\n\t\t\t<option value=\"PTCR\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =">Patient Care</option>\n\t\t\t</SELECT>\n\t\t</td>\n\t\t\n\t\t<TD class=\'label\' align=\'right\' nowrap>Order By</TD>\n\t\t<TD>&nbsp;<Select name=\'group_by\' id=\'group_by\'>\n\t\t<Option value=\'E\'>Event</Option>\n\t\t<Option value=\'P\'>Date</Option>\n\t\t</Select></TD>\n\t\t<td align=\"right\" class=\'label\' nowrap>Limited to Current Encounter</td>\n\t\t<td align=\"left\" class=\'label\'>&nbsp;<input type=\"checkbox\" name=\"encounter_chk\" id=\"encounter_chk\" checked onclick=\"setCheck()\"><td>\n\t</tr>\n\t<tr>\n\t\t<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>\n\t\t<td colspan=2 align=\"right\"><input type=button name=\'search_btn\' id=\'search_btn\' class=\'button\' value=\'Search\' onClick=\'populateValues()\'>&nbsp;<input type=button name=\'clear\' id=\'clear\' class=\'button\' value=\'Clear\' onClick=\'clearValues()\'>&nbsp;&nbsp;</td>\n\t</tr>\n</table>\n\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'selectmode\' id=\'selectmode\' value=\'\'>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<Script>populateValues();</Script>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</form>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</body>\n\t<script>populateValues();</script>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block4Bytes, _wl_block4);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	
	String mode					= request.getParameter( "mode" ) ;
	String bean_id				= "Or_ViewResults" ;
	String bean_name			= "eOR.ViewResults";
	Properties properties		= (Properties)session.getValue("jdbc");
	String practitioner_id		= (String)session.getValue("ca_practitioner_id");
	String resp_id				= (String)session.getValue("responsibility_id");
	String facilityid			= (String) session.getValue("facility_id"); 

	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";


	ViewResults bean			= (ViewResults)getBeanObject( bean_id,  bean_name , request) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setMode( mode ) ;

	String patient_id			= bean.checkForNull(request.getParameter("patient_id"),"");
//	String patient_class		= bean.checkForNull(request.getParameter("patient_class"),"");
	String encounter_id			= (String) request.getParameter("encounter_id");
	String Result_type			= (String) request.getParameter("Result_type");
	if(Result_type == null) Result_type = "";

	int patient_id_length		= 0;
	patient_id_length			= bean.getPatientIdLength();

//	ArrayList EventClass		= new ArrayList();
	ArrayList sysdate			= new ArrayList();
	String curr_week_date		= "";
	String last_week_date		= "";

	sysdate						= (ArrayList)bean.getSysDateTime(properties);

	for(int j=0;j<sysdate.size();j++)
	{
		last_week_date			= (String)sysdate.get(1);
		curr_week_date			= (String)sysdate.get(0);
	}


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(last_week_date));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(curr_week_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Result_type.equals("")?"selected":""));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(Result_type.equals("BLTF")?"selected":""));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(Result_type.equals("LBIN")?"selected":""));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Result_type.equals("RDIN")?"selected":""));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Result_type.equals("TRET")?"selected":""));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(Result_type.equals("PTCR")?"selected":""));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block18Bytes, _wl_block18);
//=bean.getFunctionId()
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(curr_week_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block23Bytes, _wl_block23);

	if (!patient_id.equals(""))
	{

            _bw.write(_wl_block24Bytes, _wl_block24);

	}

            _bw.write(_wl_block25Bytes, _wl_block25);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
