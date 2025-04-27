package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.net.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __reissuemeddisplookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ReissueMedDispLookup.jsp", 1709121388923L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n   <!--  <link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/IeStyle.css\"></link> -->\n   ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n    <script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n    <script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n    <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n    <script language=\"JavaScript\" src=\"../js/PhMessages.js\"></script>\n    <script language=\"JavaScript\" src=\"../js/ReissueMed.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"Javascript\" src=\"../../ePH/js/DrugNameCommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n </head>\n\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<!-- <body topmargin=0 leftmargin=0 bottommargin=0 > -->\n<body topmargin=0 leftmargin=0 bottommargin=0 onMouseDown=\"\" onKeyDown=\"lockKey()\">\n<form name=\"FormReissueMedDispLookup\" id=\"FormReissueMedDispLookup\" >\n\t<table cellpadding=0 cellspacing=0 width=\"100%\"  align=\"center\" border=\"0\" >\n\t<tr>\t\n\t\t<td align=\"right\" class=\"label\" ><fmt:message key=\"ePH.DispenseLocation.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t<td align=\"left\" class=\"label\">&nbsp;&nbsp;<SELECT id=Disp_Location \n      name=Disp_Location> <OPTION selected>-----<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>-----</OPTION>\n\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t  <OPTION VALUE=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t  </OPTION>\n\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t  </SELECT>&nbsp; \n\t\t\t\t</td>\n\t\t\t\t<td align=\"right\" class=\"label\" ><fmt:message key=\"ePH.DispenseDate.label\" bundle=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/></td><td align=\"left\" >&nbsp;&nbsp;<INPUT maxLength=10 size=10 \n      name=Disp_Date>&nbsp<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'Disp_Date\');document.FormReissueMedDispLookup.Disp_Date.focus();return false;\" > \n\t  </td>\n\t\t</tr>\n\t\t<tr>\t\n\t\t\t\t<td align=\"right\" class=\"label\" > <fmt:message key=\"Common.Drug.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/></td><td align=\"left\" colspan=\'3\'>&nbsp;&nbsp;<INPUT \n      maxLength=20 name=Drug_Name><INPUT class=button onclick=drugsearch(document.FormReissueMedDispLookup) type=button value=? name=Drug_Name_Button>\n\t     <INPUT type=\"hidden\" name=\"Drug_Code\" id=\"Drug_Code\">\n\t\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\t\n\t\t\t\t<td align=\"right\" class=\"label\" >Order&nbsp;ID</td>\n\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;<input name=\"Order_Id\" id=\"Order_Id\" maxlength=15 size=15>\n\t\t\t\t</td>\n\t\t\t\t<td align=\"right\" class=\"label\" ><fmt:message key=\"Common.OrderDate.label\" bundle=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/></td>\n\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;<input name=\"Order_Date\" id=\"Order_Date\" maxlength=10 size=10 \n     >&nbsp<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'Order_Date\');document.FormReissueMedDispLookup.Order_Date.focus();return false;\" > </td>\n\t\t</tr>\n\t\t<tr>\t\n\t\t\t\t<td align=\"right\" class=\"label\" ><fmt:message key=\"Common.patientclass.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/></td>\n\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;<SELECT id=Patient_Class \n      name=Patient_Class> \n\t  <OPTION selected value=\"\" >-----<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>-----</OPTION>\n\t  <OPTION value=\"OP\"><fmt:message key=\"Common.Outpatient.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/></OPTION>\n\t  <OPTION value=\"IP\"><fmt:message key=\"Common.inpatient.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/></OPTION>\n\t \n\t  </SELECT> \n    \t\t\t</td>\n\t\t\t\t<td align=\"right\" class=\"label\" >Ordering Location</td>\n\t\t\t\t<td align=\"left\" >&nbsp;&nbsp;<input name=\"Order_Location\" id=\"Order_Location\" maxlength=20 \n     ><INPUT TYPE=\"button\" name=\"OrderLocn_Button\" id=\"OrderLocn_Button\" VALUE=\"?\" CLASS=\"button\"  onClick=\"OrderSearch(document.FormReissueMedDispLookup)\" ></td>\n\t <input type=hidden name=\"Order_Code\" id=\"Order_Code\" >\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<td align=\"right\" class=\"label\" colspan=4>\n\t\t\t\t<input type=\"button\" class=\"button\" name=\"Search\" id=\"Search\" value=\"Search\" onclick=\"callResultPageDisp(document.FormReissueMedDispLookup)\">\n\t\t\t\t<input type=\"button\" class=\"button\" name=\"Cancel\" id=\"Cancel\" value=\"Clear\" onclick=\"cancel(document.FormReissueMedDispLookup)\"></td>\n\t\t</tr>\n   </table>\n   <INPUT TYPE=\"hidden\" name=\"SQL_PH_REISSUE_MEDICATION_SELECT7\" id=\"SQL_PH_REISSUE_MEDICATION_SELECT7\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n   <INPUT TYPE=\"hidden\" name=\"SQL_PH_REISSUE_MEDICATION_SELECT8\" id=\"SQL_PH_REISSUE_MEDICATION_SELECT8\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\n<input type=\"hidden\" name = \"bean_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\"hidden\" name = \"bean_name\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\"hidden\" name=Patient_Id value=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n </form>\n ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );
	
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
        response.setHeader("Content-Type", "text/html; ");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; ");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

    String bean_id		= "ReissueMedBean" ;
    String bean_name	= "ePH.ReissueMedBean";
	String disp_locn = request.getParameter("disp_locn");
	HashMap initvalues	= new HashMap();
    /* Initialize Function specific start */
	ReissueMedBean bean = (ReissueMedBean)getBeanObject( bean_id,bean_name,request) ;
    bean.clear() ;
//to populate data into dispense location and patient class
	initvalues = bean.getInitData(disp_locn);
	int i=0;
	ArrayList dispNo = new ArrayList();
	//ArrayList patClass = new ArrayList();
	dispNo = (ArrayList)initvalues.get("DISP");
	//patClass = (ArrayList)initvalues.get("PATIENT");
	String patientid = request.getParameter("PatientId");
	String disp_locn_desc = request.getParameter("disp_locn_desc");
	disp_locn_desc = URLDecoder.decode(disp_locn_desc);
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);

	  for (i=0; i<dispNo.size(); i+=2){
	  
	  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( (String)dispNo.get(i+1) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((String)dispNo.get(i) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_SELECT7" ) ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( PhRepository.getPhKeyValue( "SQL_PH_REISSUE_MEDICATION_SELECT8" ) ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block24Bytes, _wl_block24);
 putObjectInBean(bean_id,bean,request); 
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
