package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __slatesearchresultsframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SlateSearchResultsFrame.jsp", 1724938838000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--NOTE: Due to Amazon Changes SlateResultsHeader.jsp frame giving as  0%. That Header Line displaying directly respective jsps. i.e SlateSchSearchResults.jsp and SlateUnSchSearchResults.jsp\n -->\n";
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

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<frameset id=\"SlateSearchResultsFrame\" rows=\"0%,*,2%\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<frameset id=\"SlateSearchResultsFrame\" rows=\"0%,40%,31%,2%\">\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<frame name=\"f_header_frame\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SlateResultsHeader.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" > \n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<frame name=\"f_sch_cases_frame\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/SlateSchSearchResults.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<frame name=\"f_header_frame\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SlateResultsHeader.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" > \n\n\t\t\t\t<frame name=\"f_unsch_cases_frame\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/SlateUnSchSearchResults.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="         <frameset id=\"SlateSearchResultsFrame_2\" rows=\"0%,*\">\n\t\t\t\t\t\t<frame name=\"f_header_frame\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SlateResultsHeader.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" > \n\n\t\t\t\t\t\t<frame name=\"f_unsch_cases_frame\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/SlateUnSchSearchResults.jsp?";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t\t\t</frameset>\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="          \n\t\t\t\t\t<frame name=\"f_header_frame\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SlateResultsHeader.jsp?";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" > \n\n\t\t\t\t\t<frame name=\"f_unsch_cases_frame\" frameborder=\"0\" scrolling=\"yes\" noresize src=\"../../eOT/jsp/SlateUnSchSearchResults.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t<frame name=\"f_colours_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eOT/jsp/SlateOrdersColorInd.jsp?";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<frame name=\"f_header_frame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" > \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</frameset>\n</html>\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<script language=\"javascript\">\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\t\t\t//enableSearchCriteria();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String params		= request.getQueryString() ;
	String theatre_date	= request.getParameter("theatre_date");
	String speciality	= request.getParameter("speciality");
	String theatre_from	= request.getParameter("theatre_from");
	String theatre_to	= request.getParameter("theatre_to");
	String surgeon		= request.getParameter("surgeon");
	String view_by		= request.getParameter("view_by");
	String status		= request.getParameter("status");
	String theatre_date_from = request.getParameter("theatre_date_from");
	String elec_emer		= request.getParameter("elec_emer");
	String doc_status		= request.getParameter("doc_status");
	String scan_vals		= request.getParameter("scan_vals");
	String theatre_type		= request.getParameter("theatre_type");
	String patient_id		= request.getParameter("patient_id");//MO-CRF-20082
	String bean_id		= "SlateBean";
	String bean_name	= "eOT.SlateBean";
	SlateBean bean	= (SlateBean)mh.getBeanObject( bean_id, request, bean_name );

	bean.clear();
	boolean ot_sch_dtls_flag = false;
	
	System.out.println(" ******************* view_by : "+view_by+" theatre_date : "+theatre_date+" theatre_from : "+theatre_from+
			" theatre_to : "+theatre_to+" speciality : "+speciality+" surgeon : "+surgeon+" status : "+status+
			" theatre_date_from : "+theatre_date_from+" elec_emer : "+elec_emer+" doc_status : "+doc_status+" scan_vals : "+scan_vals+
			" theatre_type : "+theatre_type+" patient_id : "+patient_id);
	if(view_by.equals("S") || view_by.equals("A"))
		//ot_sch_dtls_flag = bean.loadScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,);
		ot_sch_dtls_flag = bean.loadScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,theatre_date_from,elec_emer,doc_status,scan_vals,theatre_type,patient_id);//MO-CRF-20082
	boolean ot_unsch_dtls_flag = false;
	if(view_by.equals("U") || view_by.equals("A"))
			ot_unsch_dtls_flag = bean.loadUnScheduledCases(theatre_date,theatre_from,theatre_to,speciality,surgeon,status,theatre_date_from,elec_emer,doc_status,scan_vals,theatre_type,patient_id);//MO-CRF-20082
	
	System.out.println(" ******************* ot_sch_dtls_flag : "+ot_sch_dtls_flag +" ot_unsch_dtls_flag : "+ot_unsch_dtls_flag);

            _bw.write(_wl_block10Bytes, _wl_block10);
 	if(view_by.equals("S") || view_by.equals("U")){
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}else if(view_by.equals("A") && ot_sch_dtls_flag==true && ot_unsch_dtls_flag==true){
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		}else if(view_by.equals("A")){	// only one of the schedule/unschedule cases is true
	
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		if((view_by.equals("S") || view_by.equals("A")) && ot_sch_dtls_flag==true){
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params+"&sch_unsch_flag=SCH"));
            _bw.write(_wl_block14Bytes, _wl_block14);

				if(ot_sch_dtls_flag==true){ 
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
		}
		if(view_by.equals("U") && ot_unsch_dtls_flag==true){
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(params+"&sch_unsch_flag=UNSCH"));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(params));
            _bw.write(_wl_block19Bytes, _wl_block19);

	
		}else if(view_by.equals("A") && ot_unsch_dtls_flag==true){
			if(view_by.equals("A") && ot_sch_dtls_flag==true){

		
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params+"&sch_unsch_flag=UNSCH"));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(params));
            _bw.write(_wl_block22Bytes, _wl_block22);

			}else{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(params+"&sch_unsch_flag=UNSCH"));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(params));
            _bw.write(_wl_block25Bytes, _wl_block25);

						}
		}if(ot_sch_dtls_flag==true || ot_unsch_dtls_flag==true){
		//IN055102 start 
			params=params+"&ot_sch_dtls_flag="+ot_sch_dtls_flag+"&ot_unsch_dtls_flag="+ot_unsch_dtls_flag;
		//IN055102 end
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(params));
            _bw.write(_wl_block27Bytes, _wl_block27);

		}else{
		
            _bw.write(_wl_block28Bytes, _wl_block28);

			}
		
            _bw.write(_wl_block29Bytes, _wl_block29);

		if(ot_sch_dtls_flag==false && ot_unsch_dtls_flag==false){
	
            _bw.write(_wl_block30Bytes, _wl_block30);

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
