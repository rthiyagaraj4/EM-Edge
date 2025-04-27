package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationallstagesframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationAllStagesFrames.jsp", 1734006259568L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script><!-- Added for  Bru-HIMS-CRF-081 [IN:029947]-->\n<script>\n\tvar heightarr = new Array();\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\theightarr[0]=\"0vh\";\n\t\t\theightarr[1]=\"70vh\";\n\t\t\theightarr[2]=\"0vh\";\n\t\t\theightarr[3]=\"10vh\";\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t\t\theightarr[0]=\"5vh\";\n\t\t\theightarr[1]=\"70vh\";\n\t\t\theightarr[2]=\"0vh\";\n\t\t\theightarr[3]=\"10vh\";\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\theightarr[0]=\"10vh\";\n\t\t\theightarr[1]=\"70vh\";\n\t\t\theightarr[2]=\"10vh\";\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t\theightarr[0]=\"10vh\";\n\t\t\theightarr[1]=\"70vh\";\n\t\t\theightarr[2]=\"0vh\";\n\t\t\theightarr[3]=\"10vh\";\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</script>\n</head>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<body>\n<div  name=\'DispMedicationAllStagesFrame\'>\t<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] ---> \n  <div id=\"dispmednframeset2\" name=\"dispmednframeset2\">\t<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] --->\n\t<div id=\"dispmednframeset\" name=\"dispmednframeset\"  >\n\t\t<iframe name=\"f_disp_medication_header\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationHeader.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&iv_prep_yn=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&billing_interface_yn=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></iframe>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<iframe name=\"f_disp_medication_all_stages\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n\t\t\t<iframe name=\"f_disp_medication_interactions\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<iframe name=\"f_disp_medication_verification\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationVerification.jsp?";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></iframe>\n\t\t\t<iframe name=\"f_disp_medication_interactions\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t<iframe name=\"f_disp_medication_allocation\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationAllocation.jsp?";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<iframe name=\"f_disp_medication_allocation\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<iframe name=\"f_disp_medication_filling\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationFilling.jsp?";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<iframe name=\"f_disp_medication_filling\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\"></iframe>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<iframe name=\"f_disp_medication_delivery\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationDelivery.jsp?";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</div> <!--  Added for Bru-HIMS-CRF-081 [IN:029947] -->\n\t\t\t<div id=\"dispmednframeset3\" name=\"dispmednframeset3\" style=\"display:none\">\n\t\t\t\t<iframe name=\"f_disp_medication_drug_profile\"  frameborder=\"0\" scrolling=\"auto\" src=\"../../eCommon/html/blank.html\"></iframe>\n\t\t\t</div> <!--  Added forBru-HIMS-CRF-081 [IN:029947] -->\n\t\t\t<iframe name=\"f_disp_medication_all_stages_legends\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCommon/html/blank.html\" style=\"height:17vh;width:99vw;\"></iframe>\n\t\t</div>\t\n\t</div>   <!--  Added forBru-HIMS-CRF-081 [IN:029947] -->\n\t<script>\n\t\tlet parentElement = document.getElementById(\'dispmednframeset\');  // Replace \'parent\' with your actual parent element\'s ID\n\n// Get all the iframe child elements using getElementsByTagName\nlet iframes = parentElement.getElementsByTagName(\'iframe\');\n\n// Convert HTMLCollection to an array (optional)\nlet iframeArray = Array.from(iframes);\n\nfor(i=0;i<iframeArray.length;i++){\n\tiframeArray[i].style.height=heightarr[i];\n\tiframeArray[i].style.width=\"99vw\";\n}\n\t\n\t</script>\n</body>\t\n</html>\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String params	=	request.getQueryString();
	String disp_stage = request.getParameter("disp_stage");
	
	String	bean_id				=	"DispMedicationAllStages" ;
	String	bean_name			=	"ePH.DispMedicationAllStages";	
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);

	String	bean_id_1				=	"DispMedicationBean" ;
	String	bean_name_1			    =	"ePH.DispMedicationBean";	
	DispMedicationBean bean_1 = (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		//bean_1.setLanguageId(locale);
    String billing_interface_yn		=	bean.getBLInterfaceYN();//checkforbillinginterface();
    String ws_type=bean_1.getWsType();
	String fill_list = bean_1.getFillList().trim();
	
	if(ws_type==null)ws_type="";
	String iv_prep_yn=ws_type;
	if( disp_stage.equals("A")||disp_stage.equals("F") ){
		if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
			bean_1.setAdmixtureType("I");
		}
		else if(iv_prep_yn.equals("6")){
			bean_1.setAdmixtureType("I");
		}
		else if(iv_prep_yn.equals("0")){
			bean_1.setAdmixtureType("C");
		}
		else if(iv_prep_yn.equals("8")){
			bean_1.setAdmixtureType("TA");
		}
		else {
			if(iv_prep_yn != null && iv_prep_yn.equals("7") )
				bean_1.setAdmixtureType("TD");
		}
	}
	String order_id = request.getParameter("order_id");
    bean_1.setOrderID(order_id.trim());

	String rows="10%,*,10%";	
	if(billing_interface_yn.equals("Y")){
		if( disp_stage.equals("V")){
			System.out.println("LINE 69");
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			//rows="0%,*,0%,10%";
		}
		else if( disp_stage.equals("AS") ){
			System.out.println("LINE 73");
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			//rows="5%,*,0%,10%";
		}
		else
		{
			
            _bw.write(_wl_block10Bytes, _wl_block10);

            //rows="10%,*,10%";
		}
	}
	else{
		if( disp_stage.equals("V")){
			System.out.println("LINE 81");
			
            _bw.write(_wl_block8Bytes, _wl_block8);

			//rows="0%,*,0%,10%";
		}
		else if (disp_stage.equals("AS") ){
			System.out.println("LINE 85");
			
            _bw.write(_wl_block11Bytes, _wl_block11);

			//rows="10%,*,0%,10%";
		}
	}	

            _bw.write(_wl_block12Bytes, _wl_block12);
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(params));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(ws_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(billing_interface_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);

		if(disp_stage.equals("AS")){

            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		else if(disp_stage.equals("V")){

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(params));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		else if((ws_type.equals("I")||ws_type.equals("C"))&&(disp_stage.equals("A") ||disp_stage.equals("F"))){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else if(disp_stage.equals("A")){
			 if(bean_1.getFillingStatus().equals("B")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

		}
		else{

            _bw.write(_wl_block21Bytes, _wl_block21);

			}
		}
		else if(disp_stage.equals("F")){
			if(bean_1.getFillingStatus().equals("A") &&(!bean_1.getDispLocnCatg().equals("I"))|| fill_list.equals("AF") ){


            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			else{

            _bw.write(_wl_block23Bytes, _wl_block23);

				}
			}
			else if(disp_stage.equals("D")){

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(params));
            _bw.write(_wl_block16Bytes, _wl_block16);

			}

            _bw.write(_wl_block25Bytes, _wl_block25);

putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
