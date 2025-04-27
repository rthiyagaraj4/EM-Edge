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

public final class __dispmedicationquerycriteriaframeset extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationQueryCriteriaFrameSet.jsp", 1734671146016L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n/*******************************************************************************\n * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.\n *  \n * Warning: This computer program is protected by copyright law and international treaties.\n * Unauthorized reproduction or distribution of this program, or any portion of it, \n * may result in severe civil and criminal penalties, and will be prosecuted to \n * the maximum extent possible under the law.\n ******************************************************************************/\n/*\n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n?\t\t\t\t100\t\t\t\t\t?                created\n04/13/2017      KDAH-CRF-0338     Devindra/Mukesh    Inclusion of Bed No in the Fill and Deliver screen in Dispense Medication.\n---------------------------------------------------------------------------------------------------------------\n*/ -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/PhCommon.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/DispMedication.js\"></SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<iframe name=\"f_query_criteria_token_info\" id=\"f_query_criteria_token_info\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaTokInfo.jsp?homepage=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  style=\"height:6vh;width:100vw\"></iframe>\n<iframe name=\"f_query_criteria\" id=\"f_query_criteria\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&homepage=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"height:0vh;width:100vw\"></iframe>\n<iframe name=\"f_query_criteria_buttons\" id=\"f_query_criteria_buttons\" src=\"../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" frameborder=\"0\" noresize scrolling=\"no\" style=\"height:7vh;width:100vw\"></iframe>\n<iframe name=\"f_query_criteria_additional\" id=\"f_query_criteria_additional\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" style=\"height:0vh;width:100vw\"></iframe>\n<iframe name=\"f_query_result\" id=\"f_query_result\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" style=\"height:70vh;width:100vw\"></iframe>\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"  style=\"height:0vh;width:100vw;display: none;\"></iframe>\n<iframe name=\"f_query_criteria\" id=\"f_query_criteria\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteria.jsp?function_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"height:33vh;width:100vw\"></iframe>\n<iframe name=\"f_query_criteria_buttons\" id=\"f_query_criteria_buttons\" src=\"../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\t\t\t<iframe name=\"f_query_criteria_token_info\" id=\"f_query_criteria_token_info\" frameborder=\"0\" scrolling=\"no\" noresize src=\"\" style=\"height:0vh;width:100vw;display: none;\" ></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria\" id=\"f_query_criteria\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&fill_list=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&function_id=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" style=\"height:33vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria_buttons\" id=\"f_query_criteria_buttons\" src=\"../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" frameborder=\"0\" noresize scrolling=\"no\" style=\"height:7vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria_additional\" id=\"f_query_criteria_additional\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" style=\"height:0vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_result\" id=\"f_query_result\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" style=\"height:70vh;width:100vw\">\t</iframe>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\n\t\t\t\t<iframe name=\"f_query_criteria_token_info\" id=\"f_query_criteria_token_info\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"\" style=\"height:0vh;width:100vw;display: none;\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria\" id=\"f_query_criteria\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" style=\"height:63vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria_buttons\" id=\"f_query_criteria_buttons\" src=\"../../ePH/jsp/DispMedicationQueryCriteriaButtons.jsp?function_id=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:7vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria_additional\" id=\"f_query_criteria_additional\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaAddn.jsp?homepage=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" style=\"height:0vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_result\" id=\"f_query_result\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationDeliveryFrames.jsp?homepage=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" style=\"height:70vh;width:100vw\"></iframe>\t\n\t\t\t\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<iframe name=\"f_query_criteria_token_info\" id=\"f_query_criteria_token_info\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"\" style=\"height:0vh;width:100vw;display: none;\"></iframe>\n\t\t\t\t<iframe name=\"f_query_criteria\" id=\"f_query_criteria\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationQueryCriteriaForIP.jsp?stage=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" style=\"height:0vh;width:100vw\"></iframe>\n\t\t\t\t<iframe name=\"f_query_result\" id=\"f_query_result\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/DispMedicationDetailFrameSet.jsp?homepage=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" style=\"height:70vh;width:100vw\"></iframe>\t\n\t\t\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );
	
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
		
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String issue_token_on_regn = request.getParameter("issue_token_on_regn");
	String disp_locn_catg      = request.getParameter("disp_locn_catg");
	String function_id		   = CommonBean.checkForNull(request.getParameter("function_id"));
	String homepage		   = CommonBean.checkForNull(request.getParameter("homepage"));//Added for Bru-HIMS-CRF-073.1 [IN:047222]
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;

   //bean.getAllowShortexpiary_yn();

	if(issue_token_on_regn.equals("Y") && disp_locn_catg.equals("O")){

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}else if (issue_token_on_regn.equals("N") && disp_locn_catg.equals("O")){

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}else if ( disp_locn_catg.equals("IAE"))//this condition is added by Himanshu 
	{
		String stage=bean.getDispStage();
		String fill_list = bean.getFillList();
		String strRows = "0,150,*,0,0";
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(stage));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fill_list));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block23Bytes, _wl_block23);

			}
else if(disp_locn_catg.equals("I")){
		String stage=bean.getDispStage();
		String fill_list = bean.getFillList();
		String strRows = "0,85,*,0,0";
		if(stage.equals("D") && fill_list.equals("DWF")){
			strRows = "0,63,*,0,0";
		} 
		else {
			strRows = "0,150,*,0,0"; // 135 changed to 150 for KDAH-CRF-0338
		}
		if(stage.equals("D") && fill_list.equals("DWF")) {

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(stage));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fill_list));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block28Bytes, _wl_block28);

		} else { 
		

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(stage));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fill_list));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(homepage));
            _bw.write(_wl_block31Bytes, _wl_block31);

		}
	}

            _bw.write(_wl_block32Bytes, _wl_block32);

putObjectInBean(bean_id,bean,request);

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
