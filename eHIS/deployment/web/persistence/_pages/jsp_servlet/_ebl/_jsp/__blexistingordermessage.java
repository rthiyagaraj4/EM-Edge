package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.placeorder.model.BLChargePatientExistingOrderBean;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blexistingordermessage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLExistingOrderMessage.jsp", 1738011138940L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n<meta HTTP-EQUIV=\"content-type\" CONTENT=\"text/html; charset=UTF-8\">\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"JavaScript\">\n$(document).ready(function(){\n\tif($(\'#calledFrom\').val() == \'cancelAll\' || $(\'#calledFrom\').val() == \'cancelBLServ\'){\n\t\t\n\t}\n});\n</script>\n<script language=\'JavaScript\'>\n\t\t\tfunction toLoadFrame(){\n\t\t\t\tvar dialogFrame = parent.parent.document.getElementById(\'dialog-body\').contentWindow;\n\t\t\t\t\t//parent.document.getElementById(\'BL_mainFrame\').rows = dialogFrame.document.getElementById(\'allFramesMessage\').value;\n\t\t\t\t\t//<input type=\'hidden\' id=\'allFramesMessage\' \tname=\'allFramesMessage\'   value=\'7%,0%,0%,6%,25%,6%,28%,23%,4%\'>\n\t\t\t\t\t//dialogFrame.pline.style.height=\"7vh\";\t\n\t\t\t\t\t//console.log(dialogFrame.document.getElementById(\'pline\'));\n\t\t\t\t\t/* parent.document.getElementById(\'pline\').style.height = \"7vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BillingBanner\').style.height = \"0vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BillingMenu\').style.height = \"0vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BLChargePatientEncounterTab\').style.height = \"6vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BLChargePatientEncounterTabPage\').style.height = \"25vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BLChargePatientExisOrderTraverse\').style.height = \"6vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BLChargePatientExisOrderServDetails\').style.height = \"28vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'BLChargePatientExisOrderServEdit\').style.height = \"23vh\";\n\t\t\t\t\t\tparent.document.getElementById(\'messageFrame\').style.height = \"4vh\"; */\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'pline\').style.height = \"7vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BillingBanner\').style.height = \"0vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BillingMenu\').style.height = \"0vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BLChargePatientEncounterTab\').style.height = \"6vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\').style.height = \"22vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BLChargePatientExisOrderTraverse\').style.height = \"6vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BLChargePatientExisOrderServDetails\').style.height = \"28vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'BLChargePatientExisOrderServEdit\').style.height = \"18vh\";\n\t\t\t\t\t\tdialogFrame.document.getElementById(\'messageFrame1\').style.height = \"8vh\"; \n\t\t\t\t\t\t\n\t\t\t\t\t\tdialogFrame.BLChargePatientExisOrderTraverse.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\tdialogFrame.BLChargePatientExisOrderServDetails.location.href=\'../../eCommon/html/blank.html\';\t\t\t\t\n\t\t\t\t\t\tdialogFrame.BLChargePatientExisOrderServEdit.location.href = \"../../eCommon/html/blank.html\";\n/* \t\t\t\t\tparent.BLChargePatientExisOrderTraverse.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tparent.BLChargePatientExisOrderServDetails.location.href=\'../../eCommon/html/blank.html\';\t\t\t\t\n\t\t\t\t\tparent.BLChargePatientExisOrderServEdit.location.href = \"../../eCommon/html/blank.html\"; */\n\t\t\t}\n\t\t\t\t</script>\n\n</head>\n\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n\n<p align=\"left\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<script type=\'text/javascript\'>\n\t\t\t\ttoLoadFrame();\n\t\t\t\t//alert(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\');\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script language=\'JavaScript\'>\n\t\t\t\t\talert(\'APP-SM0070 Operation Completed Successfully ....\');\n\t\t\t\t\tparent.BLChargePatientEncounterTabPage.document.getElementById(\'add_mod\').click();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t<script language=\'JavaScript\'>\n\t\t\t\t\talert(\'APP-SM0070 Operation Completed Successfully ....\');\n\t\t\t\t\tparent.BillReceiptTab.document.getElementById(\'futureOrder\').click();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script language=\'JavaScript\'>\n\t\t\t\talert(\'APP-SM0070 Operation Completed Successfully ....\');\n\t\t\t\t//console.log(\"cancelBLServ\");\n\t\t\t\tvar dialogFrame = parent.parent.document.getElementById(\'dialog-body\').contentWindow;\n\t\t\t\t//console.log(dialogFrame);\n\t\t\t\t//console.log(dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\'));\n\t\t\t\tvar dialogFrameforBL=dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\');\n\t\t\t\tvar dialogFrameforBL1=dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\').contentWindow;\n\t\t\t\t//console.log(dialogFrameforBL1.document.getElementById(\'add_mod\'));\n\t\t\t\tvar dialogFrameforBLServ=dialogFrameforBL1.document.getElementById(\'add_mod\');\n\t\t\t\tdialogFrameforBLServ.click();\n\t\t\t\t//console.log();\n\t\t\t\t//console.log(parent.BLChargePatientEncounterTabPage.document.getElementById(\'add_mod\'));\n\t\t\t\t//parent.BLChargePatientEncounterTabPage.document.getElementById(\'add_mod\').click();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<script language=\'JavaScript\'>\n\t\t\t\talert(\'APP-SM0070 Operation Completed Successfully ....\');\n\t\t\t\t//console.log(\"cancelAll\");\n\t\t\t\tvar dialogFrame = parent.parent.document.getElementById(\'dialog-body\').contentWindow;\n\t\t\t\t//console.log(dialogFrame);\n\t\t\t\t//console.log(dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\'));\n\t\t\t\tvar dialogFrameforBL=dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\');\n\t\t\t\tvar dialogFrameforBL1=dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\').contentWindow;\n\t\t\t\t//console.log(dialogFrameforBL1.document.getElementById(\'add_mod\'));\n\t\t\t\tvar dialogFrameforBLServ=dialogFrameforBL1.document.getElementById(\'add_mod\');\n\t\t\t\tdialogFrameforBLServ.click();\n\t\t\t\t\n\t\t\t\t//var dialogFrame = parent.parent.document.getElementById(\'dialog-body\').contentWindow;\n\t\t\t\t//console.log(dialogFrame.document.getElementById(\'messageFrame\'));\n\t\t\t\t//console.log(dialogFrame.document.getElementById(\'BLChargePatientEncounterTabPage\'));\n\t\t\t\t//console.log(parent.BLChargePatientEncounterTabPage.document.getElementById(\'add_mod\'));\n\t\t\t\t//parent.BLChargePatientEncounterTabPage.document.getElementById(\'add_mod\').click();\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n<input type=\'hidden\' name=\'calledFrom\'  id=\'calledFrom\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'error\'  id=\'error\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'warning\'  id=\'warning\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n</p>\n<p id=\'ehiserror\'></p>\n</BODY>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");	
	String error=request.getParameter( "err_num" );
	
	System.out.println(" error==>"+error);
	String calledFrom = request.getParameter("calledFrom");
	System.out.println(" calledFrom ===>"+calledFrom);
	String warning = request.getParameter("warning");
	System.out.println("warning:"+request.getParameter( "err_value" ));
	
	//System.out.println("error->"+error);
	if ( error != null ) { System.out.println("error 78->"+error);
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(error ));
            _bw.write(_wl_block8Bytes, _wl_block8);
	
		String error_value = request.getParameter( "err_value" )==null ? "0" : request.getParameter( "err_value" ) ;
		System.out.println("error_value->"+error_value);
		if ( error_value.equals( "1" ) ){
			String beanId = "BLChargePatientNewOrderBean" ;
			String beanName = "eBL.placeorder.model.BLChargePatientNewOrderBean";
			BLChargePatientNewOrderBean chargeBean = (BLChargePatientNewOrderBean) getObjectFromBean(beanId, beanName, session);
			//cleanBeanObject(beanId, beanName, request);
			chargeBean.clearAll();
			
			beanId = "BLChargePatientExistingOrderBean" ;
			beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";

			BLChargePatientExistingOrderBean serviceBean = (BLChargePatientExistingOrderBean) getObjectFromBean(beanId, beanName, session);
			//cleanBeanObject(beanId, beanName, request);
			serviceBean.clearAll();
			if("newOrder".equals(calledFrom)){ 
			System.out.println("inside nweOrder");
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(error));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
			else if("existingOrder".equals(calledFrom)){
            _bw.write(_wl_block11Bytes, _wl_block11);
}
			else if("processOrder".equals(calledFrom)){
            _bw.write(_wl_block12Bytes, _wl_block12);
}
			else if("cancelBLServ".equals(calledFrom)){
            _bw.write(_wl_block13Bytes, _wl_block13);
}
			else if("cancelAll".equals(calledFrom)){
            _bw.write(_wl_block14Bytes, _wl_block14);
}
		}
			
	}


            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(calledFrom ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(error ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(warning ));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
