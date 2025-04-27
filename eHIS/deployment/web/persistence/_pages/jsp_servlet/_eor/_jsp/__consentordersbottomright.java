package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;

public final class __consentordersbottomright extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ConsentOrdersBottomRight.jsp", 1709119670000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function\n19/08/2013\t  IN038797\t   Karthi L\t\tTo include the field (Filter) of \"Speciality\" in the function of \"Pending Consent\" in Practitioner\'s homepage\n21/10/2015\t  IN057196\t\tRamesh G\tRecording Of Consent Form\n---------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ConsentOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>function_id = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";</script>\n\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<frameset rows=\'*%,8%\'>\n<!-- \t<frame name=\'ConsentOrdersBottomRight0\' id=\'ConsentOrdersBottomRight0\' src=\'ConsentOrdersBottomRightHeading.jsp?source_type=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&source_code=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&order_by=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&priority=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&ord_cat=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&ord_cat_desc=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&priority_desc=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&patientId=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' frameborder=0  scrolling=\'no\' noresize> -->\n<!-- \t<frame name=\'ConsentOrdersBottomRight1\' id=\'ConsentOrdersBottomRight1\' src=\'ConsentOrdersBottomRightDtl.jsp?source_type=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&total_recs=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&period_from=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&period_to=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&function_id=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' frameborder=0 scrolling=\'auto\'  noresize>  -->  <!-- commented for  BRU-HIMS-CRF-359 [IN038797]  -->\n\t<!-- IN057196 Start. -->\n\t<!--   <frame name=\'ConsentOrdersBottomRight1\' id=\'ConsentOrdersBottomRight1\' src=\'ConsentOrdersBottomRightDtl.jsp?source_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&speciality_code=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' frameborder=0 scrolling=\'auto\'  noresize> --> <!-- modified for BRU-HIMS-CRF-359 [IN038797]  -->\n\t<frame name=\'ConsentOrdersBottomRight1\' id=\'ConsentOrdersBottomRight1\' src=\'ConsentOrdersBottomRightDtl.jsp?source_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&consentRec_order_id=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' frameborder=0 scrolling=\'auto\'  noresize>  <!-- modified for BRU-HIMS-CRF-359 [IN038797]  -->\n\t<!-- IN057196 End. -->\n\t<frame name=\'ConsentOrdersBottomRight2\' id=\'ConsentOrdersBottomRight2\' src=\'ConsentOrdersBottomRightBtn.jsp?calledFrom=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' frameborder=0 scrolling=\'no\' noresize><!--IN29559-->\n</frameset>\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, false , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block5Bytes, _wl_block5);

	
	//String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String source = url + params ;

	String source_type		= request.getParameter( "source_type" ) ;
	String source_code		= request.getParameter( "source_code" ) ;
	String patientId		= request.getParameter( "patientId");
	String order_by			= request.getParameter( "order_by" ) ;
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;
	String total_recs		= request.getParameter( "total_recs" ) ;
	String period_from		= request.getParameter( "period_from" ) ;
	String period_to		= request.getParameter( "period_to" ) ;
	String function_id		= request.getParameter( "function_id" ) ;
	String consentRec_order_id = request.getParameter("consentRec_order_id")== null?"":request.getParameter("consentRec_order_id"); //IN057196
	String calledFrom		= request.getParameter( "calledFrom")==null?"":request.getParameter("calledFrom") ;//IN29559
	String speciality_code  = request.getParameter( "speciality_code" )== null?"":request.getParameter( "speciality_code" ); //added for BRU-HIMS-CRF-359 [IN038797]
	if(function_id == null) function_id= "";
	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
	if(total_recs== null) total_recs="" ; 
	if(period_from== null) period_from="" ; else period_from = period_from.trim();
	if(period_to== null) period_to="" ; else period_to = period_to.trim();

	//IN29559,starts
	String orderCat = "";

	try
	{
		orderCat = request.getParameter("orderCategory")==null?"":request.getParameter("orderCategory");

		if(calledFrom.equals("TASK_LIST"))
		{
			ord_cat = orderCat;
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception from line 62,ConsentOrdersBottomRight.jsp");
		e.printStackTrace();
	}
	//IN29559,ends

	/*out.println("<script>alert('source_type="+source_type+"')</script>");
	out.println("<script>alert('source_code="+source_code+"')</script>");
	out.println("<script>alert('patientId="+patientId+"')</script>");
	out.println("<script>alert('order_by="+order_by+"')</script>");
	out.println("<script>alert('priority="+priority+"')</script>");
	out.println("<script>alert('ord_cat="+ord_cat+"')</script>");
	out.println("<script>alert('ord_cat_desc="+ord_cat_desc+"')</script>");
	out.println("<script>alert('priority_desc="+priority_desc+"')</script>");
	out.println("<script>alert('total_recs="+total_recs+"')</script>");
	out.println("<script>alert('period_from="+period_from+"')</script>");
	out.println("<script>alert('period_to="+period_to+"')</script>");*/
	


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(source_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(order_by));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(total_recs));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(ord_cat_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(priority_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(period_from));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(period_to));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(consentRec_order_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
