package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.net.URLEncoder;
import java.util.ArrayList;
import eDS.Common.JSONObject;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __dsmealrejectionsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DSMealRejectionsQueryCriteria.jsp", 1738425230000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Created Against ML-MMOH-CRF-0685-->\n";
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

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../framework/js/PopupWindow.js\" type=\"text/javascript\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/navbar.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eDS/js/simpletreemenu.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSCommon.js\"></script>\t\t\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\t\t\n\t<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/Moment.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/MomentRange.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/MealAcknowledgeReport.js\"></script>\t\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSPlaceSupplementaryOrder.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eDS/js/DSProcessSupplementary.js\"></script>\n\t<script language=\'javascript\' src=\'../../eDS/js/DSMealrejection.js\'></script>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eDS/css/jquery-ui.css\"/>\n\t \n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\n\t<script language=\"Javascript\" src=\"../../eDS/js/json.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body  OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onload=\"getResult(\'onLoad\');\">\n\t<form action=\"\" style=\"width:100%;height:100%;\">\n\t\t<div id=\"search\" style=\"width:100%;height:20%;border: 0px outset #9999FF;\" align=\"center\">\n\t\t<table border=\"0\" cellpadding=\"2\" cellspacing=\"0\" width=\"90%\" align=\"center\" >\n\t\t<tr>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"servingDate\" id=\"servingDate\" id=\"servingDate\" size=\"10\" maxlength=\"10\" value=\"\" onkeypress=\"return checkForSpecCharsforID(event);\"   onblur=\"isValidDate(this);\" >\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'servingDate\');\">\t\t\t\t\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<input type=\"text\" name=\"servingDateTo\" id=\"servingDateTo\" id=\"servingDateTo\" size=\"10\" maxlength=\"10\" value=\"\" onkeypress=\"return checkForSpecCharsforID(event);\"   onblur=\"isValidDate(this);\" >\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'servingDateTo\');\">\n\t\t\t\t\n\t\t\t</td>\n\t\t\t\t\t\n\t\t</tr>\n\t\t\t\t\n\t\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"Patient_Class\" id=\"Patient_Class\" id=\"Patient_Class\" onChange=\"\">\n\t\t\t\t<option value=\"\" selected>All</option>\t\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t</option>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t\t\t\t\n\t\t</select>\n\t\t</td>\n\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</td>\n\t\t<td>\t\t\t\t\t\n\t\t\t\t<input type=\"text\" name=\"patient_id\" id=\"patient_id\" id=\"patient_id\" onKeypress=\'return CheckForSpecChars(event);\' onBlur=\"makeValidString(this);ChangeUpperCase(this);\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=search value=\'?\' class=button tabIndex=\"4\" onClick=\"callPatientSearch()\">\t\t\n\t\t\t</td>\t\t\n\t\t</tr>\t\t\t\n\t\t\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"AcknowledgeStatus\" id=\"AcknowledgeStatus\" id=\"AcknowledgeStatus\" onChange=\"\">\n\t\t\t\t\t<option value=\"N\" selected>No</option>\t\t\t\t\t\t\t\n\t\t\t\t\t<option value=\"Y\">Yes</option>\t\t\t\t\t\t\t\n\t\t\t\t\t<option value=\"A\">All</option>\t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>\t\n\t\t\t\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</td>\n\t\t\t<td>\n\t\t\t\t<select name=\"PatientStatus\" id=\"PatientStatus\" id=\"PatientStatus\" onChange=\"\">\n\t\t\t\t<option value=\"\" selected>All</option>\t\n\t\t\t\t<option value=\"A\" >Active</option>\t\t\t\t\t\t\t\n\t\t\t\t<option value=\"D\">Discharged</option>\t\t\t\t\t\t\t\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\t\t\t\t\n\n\t\t<tr>\n\t\t\t</td>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\n\t\t\t</td>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\n\t\t\t</td>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\n\t\t\t</td>\n\t\t\t<td class=\"label\" align=\"right\">\n\t\t\t\n\t\t\t</td>\n\t\t\t<td class=\"label\" align=\"right\">\n\n\t\t\t\t<input type=\"button\" value=\"Select\"  class=\"BUTTON\"/ onclick=\"getResult(\'onClick\')\">\n\t\t\t</td>\n\t\t</tr>\t\t\t\n\t\t</table>\t\t\t\n\t\t\n\t\t</div>\n\t\t<div id=\"nextprev\" style=\"width:100%;height:5%;border: 0px outset #9999FF;visibility:visible\" align=\"center\">\n\t\t<table align=\'right\' id=\"nextprevtable\">\t\t\n\t\t</table>\n\t\t</div>\n\t\t<div id=\"result\" style=\" scroll;width:100%;height:70%;border: 0px outset #9999FF;\" align=\"center\">\n\t\t<table border=\"1\" cellpadding=\"1\" cellspacing=\"0\" width=\'100%\' align=\'center\' id=\"supplementaryplacesearchtable\" style=\"overflow-y: scroll;width:100%;border: 1px outset #9999FF;\">\n\t\t</table>\n\t\t</div>\n\t\t<div id=\"footer\" style=\"width:100%;height:5%;border: 0px outset #9999FF;visibility:hidden\" align=\"center\">\n\t\t<table width=\"100%\" height=\"100%\" >\n\t\t<tr>\n\t\t\t<td align==\'right\' width=\'3%\' class=\'ORANGE\'> </td>\n\t\t\t<td align=\'left\' width=\'13%\' colspan=\'3\' class=\'label\'>\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</td>\n\n\t\t\t<td ></td>\n\t\t\t<td align=\'left\' width=\'13%\' colspan=\'3\' class=\'label\'></td>\n\n\t\t\t<td ></td>\n\t\t\t<td align=\'left\' width=\'13%\' colspan=\'3\' class=\'label\'></td>\n\n\t\t\t<td > </td>\n\t\t\t<td align=\'left\' width=\'13%\' colspan=\'3\' class=\'label\'></td>\n\t\n\t\t\t<td align=\'right\' width=\'3%\'>\n\t\t\t</td>\n\t\t\t<td align=\'left\' width=\'13%\' colspan=\'3\' class=\'label\'></td>\t\n\t\t</tr>\n\t\t</table>\n\t\t\n\t\t</div>\n\t\t<input type=\"hidden\" id=\"locale\" name=\"locale\" id=\"locale\" value=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t<input type=\"hidden\" id=\"facility_id\" name=\"facility_id\" id=\"facility_id\" value=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">\t\t\n\t\t<input type=\"hidden\" id=\"onCall\" name=\"onCall\" id=\"onCall\" value=\"onLoad\">\n\t\t<input type=\"hidden\" value=\"\"  id=\"RejectionList\"/>\n\t\t</form>\t\t\n\t</body>\n</html> \n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);
            {DSCommonBeanObj.setFacilityId(session.getAttribute("facility_id").toString()
                );
            }_bw.write(_wl_block1Bytes, _wl_block1);
            {DSCommonBeanObj.setLocale(session.getAttribute("LOCALE").toString()
                );
            }_bw.write(_wl_block2Bytes, _wl_block2);

	String locale	= (String)session.getAttribute("LOCALE");
	String sStyle 	= ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	HttpSession httpSession = request.getSession(false);
	Properties p	= (Properties)httpSession.getValue("jdbc");

	//String strloggeduser	= (String) httpSession.getValue("login_user");
	String strclientip	= "";
	strclientip			= p.getProperty("client_ip_address");
	String facility_id	= (String)session.getAttribute("facility_id");
	if(sStyle==null) sStyle	= "IeStyle.css";	

            _bw.write(_wl_block6Bytes, _wl_block6);
 
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 
			try{
					String patient_type_code="";
					con = ConnectionManager.getConnection(request);
					String sql_patient_class="SELECT PATIENT_CLASS,SHORT_DESC FROM AM_PATIENT_CLASS_LANG_VW WHERE LANGUAGE_ID='"+locale+"' and patient_class != 'DC' ORDER BY 1";
					pstmt = con.prepareStatement(sql_patient_class);
					rst = pstmt.executeQuery();

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					while(rst.next()) {
					if(!rst.getString(1).equalsIgnoreCase("XT"))
					{
						patient_type_code=patient_type_code+rst.getString(1)+"$$";

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rst.getString(1)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rst.getString(2) ));
            _bw.write(_wl_block15Bytes, _wl_block15);
					}}
					  if(rst !=null) rst.close();
					  if(pstmt !=null) pstmt.close();
					  }
			catch(Exception e){
			System.err.println("Exception in DietOrderStatus:"+e);
			e.printStackTrace();
		}
		finally{
   			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
				ConnectionManager.returnConnection(con);
			}
			catch(Exception e){
				e.printStackTrace();
				System.err.println("Exception in Texture of Diet:"+e);
			}
   		}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ServingDateFrom.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.ServingDateTo.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.AcknowledgeStatus.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.PatientStatus.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OrderPlaced.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
