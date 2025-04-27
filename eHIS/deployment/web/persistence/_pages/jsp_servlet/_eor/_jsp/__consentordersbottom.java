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
import java.util.*;
import com.ehis.util.*;

public final class __consentordersbottom extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentOrdersBottom.jsp", 1709119668000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function\n19/08/2013\t  IN038797\t   Karthi L\t\tTo include the field (Filter) of \"Speciality\" in the function of \"Pending Consent\" in Practitioner\'s homepage\n21/10/2015    IN057196\t    Ramesh G\tRecording Of Consent Form\n---------------------------------------------------------------------------------------------------------------\n--> \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n<html>\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n \t<script language=\"JavaScript\" src=\"../js/ConsentOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<frameset cols=\'0%,*\'>\n\t<!-- \t<frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&source_code=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&patientId=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&period_from=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&period_to=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  frameborder=0 scrolling=\'no\' noresize>  --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<!--  <frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&order_by=O&function_id=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&calledFrom=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&orderCategory=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'  frameborder=0 scrolling=\'no\' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<!-- IN057196 Start.-->\n\t\t <!-- <frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&speciality_code=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  frameborder=0 scrolling=\'no\' noresize>  --> <!--  added for for BRU-HIMS-CRF-359 [IN038797]-->\n\t\t <!-- <frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  frameborder=0 scrolling=\'no\' noresize>  --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t \n\t\t <frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&consentRec_order_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'  frameborder=0 scrolling=\'no\' noresize> <!--  added for for BRU-HIMS-CRF-359 [IN038797]-->\n\t\t <frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  frameborder=0 scrolling=\'no\' noresize> \n\t\t<!-- IN057196 End.-->\n\t</frameset>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t<frameset cols=\'20%,*\'>\n\t<!--\t<frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  frameborder=0 scrolling=\'no\' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->\n\t<!--\t<frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  frameborder=0 scrolling=\'no\' noresize> --> <!--  commented for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<!-- IN057196 Start.-->\n\t\t<!--<frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  frameborder=0 scrolling=\'no\' noresize> --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<!--<frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  frameborder=0 scrolling=\'no\' noresize> --> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->\n\t\n\t\t<frame name=\'ConsentOrdersBottomLeft\' id=\'ConsentOrdersBottomLeft\'\tsrc=\'ConsentOrdersBottomLeft.jsp?source_type=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  frameborder=0 scrolling=\'no\' noresize> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<frame name=\'ConsentOrdersBottomRight\' id=\'ConsentOrdersBottomRight\' src=\'ConsentOrdersBottomRight.jsp?source_type=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  frameborder=0 scrolling=\'no\' noresize> <!--  added for BRU-HIMS-CRF-359 [IN038797] -->\n\t\t<!-- IN057196 End.-->\n\t</frameset>\n\t<!--IN29559,starts-->\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<!--IN29559,ends-->\n</html>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.ConsentOrders bean= null;{
                bean=(eOR.ConsentOrders)pageContext.getAttribute("bean");
                if(bean==null){
                    bean=new eOR.ConsentOrders();
                    pageContext.setAttribute("bean",bean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	//String bean_id = "Or_ConsentOrders" ;
	//String bean_name = "eOR.ConsentOrders";

	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;

	String practitioner_id	= (String)session.getValue("ca_practitioner_id");
	String facility_id		= (String)session.getValue("facility_id");
	String resp_id			= (String)session.getValue("responsibility_id");


	if(resp_id== null)	resp_id = "";
	
	String source_type		= request.getParameter("location_type");
	String source_code		= request.getParameter("locn");
	String patientId		= request.getParameter("patientId");
	String period_from		= request.getParameter("period_from");
	String period_to		= request.getParameter("period_to");
	String function_id		= request.getParameter("function_id");
	String consentRec_order_id		= request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	if(function_id == null) function_id =""; else function_id = function_id.trim();
	if(source_type == null || source_type.equals("null")) source_type =" "; else source_type = source_type.trim();
	if(source_code == null || source_code.equals("null")) source_code =" "; else source_code = source_code.trim();
	//out.println("<script>alert('source_type="+source_type+"')</script>");
	//out.println("<script>alert('source_code="+source_code+"')</script>");
	//out.println("<script>alert('patientId="+patientId+"')</script>");

	if(patientId == null || patientId.equals("null")) {
		// Will be pased from the Menu
		patientId		= request.getParameter("patient_id");
 	}
	if(patientId == null || patientId.equals("null")) 
		patientId =" "; 
	else patientId = patientId.trim();
	//out.println("<script>alert('patient_id="+patientId+"')</script>");

	if(period_from == null || period_from.equals("null")) period_from =" "; else period_from = period_from.trim();
	if(period_to == null || period_to.equals("null")) period_to =" "; else period_to = period_to.trim();

	Properties properties			= (Properties) session.getValue( "jdbc" );
	// 	ConsentOrders bean = (ConsentOrders)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to) ; //commented for BRU-HIMS-CRF-359 [IN038797]
	//IN057196 Start.
		//ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to,speciality_code) ; //modified for BRU-HIMS-CRF-359 [IN038797]
		ArrayList PriorityData = bean.getStatusByPriority(properties, facility_id,source_type,source_code,practitioner_id,patientId, period_from, period_to,speciality_code,consentRec_order_id) ; //modified for BRU-HIMS-CRF-359 [IN038797]
	//IN057196 End.
	if(PriorityData.size() == 0){
		out.println("<script>parent.ConsentOrderTop.document.consent_order.search_btn.disabled = false;</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); location.href='../../eCommon/html/blank.html'</script>");
	}
	//IN29559,starts
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
	String orderCategory = request.getParameter("orderCategory")==null?"":request.getParameter("orderCategory");
	if(calledFrom.equals("TASK_LIST"))
	{
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consentRec_order_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(orderCategory));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consentRec_order_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);

	}
	else
	{
	//IN29559,ends
	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consentRec_order_id ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(consentRec_order_id ));
            _bw.write(_wl_block30Bytes, _wl_block30);

	}

            _bw.write(_wl_block31Bytes, _wl_block31);

	//putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
