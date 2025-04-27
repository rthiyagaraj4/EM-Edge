package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;
import org.apache.commons.codec.binary.Base64;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __billreceiptmainframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptMainFrame.jsp", 1740484196760L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n---------------------------------------------------------------------------------------------------------------\nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<HTML>\n<HEAD>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n    <title>Bill Generation</title>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"></link>\n\t<input type=\'hidden\' id=\'allFramesExisting\' name=\'allFramesExisting\'  value=\'7%,4%,25%,18%,30%,13%,4%\'>\n\t<input type=\'hidden\' id=\'hideSearchCriteria\' \t\tname=\'hideSearchCriteria\' \t value=\'7%,4%,0%,31%,40%,14%,4%\'>\n\t<input type=\'hidden\' id=\'allFramesNewDtl\' \tname=\'allFramesNewDtl\' \t value=\'7%,0%,0%,6%,0%,47%,37%,5%\'>\n\t<input type=\'hidden\' id=\'allFramesNewRcrd\' \tname=\'allFramesNewRcrd\'   value=\'7%,0%,0%,5%,0%,29%,50%,5%\'>\n\t<input type=\'hidden\' id=\'allFramesMessage\' \tname=\'allFramesMessage\'   value=\'7%,0%,0%,32%,25%,7%,29%,5%\'>\n\t<input type=\'hidden\' id=\'allFramesOtherOut\' \tname=\'allFramesOtherOut\'   value=\'7%,6%,0%,6%,76%,0%,0%,5%\'>\n\t<input type=\'hidden\' id=\'allFramesUnConfirmed\' \tname=\'allFramesUnConfirmed\'   value=\'7%,6%,0%,86%,0%,0%,0%,5%\'>\n\t<input type=\'hidden\' id=\'showEncBilling\' \tname=\'showEncBilling\'   value=\'7%,6%,27%,44%,0%,12%,4%\'>\n\t<input type=\'hidden\' id=\'framesAltered\' \tname=\'framesAltered\'   value=\'7%,6%,27%,44%,0%,12%,4%\'>\n\n\t<script>\n\tfunction refresh(){\n\t\tvar reqParam = BillReceiptExisOrderSearch.document.forms[0].queryString.value;\n\t\tBillReceiptExisOrderSearch.document.location.href = \"../../eBL/jsp/BillReceiptExistingOrderSearch.jsp?\"+reqParam;\n\t\tBillReceiptExisOrderDetails.document.location.href = \'../../eCommon/html/blank.html\';\n\t\tBillReceiptExisOrderSummary.document.location.href = \'../../eBL/jsp/BillReceiptExisOrderSummary.jsp\';\n\t\tBillReceiptWindow.document.location.href = \'../../eBL/jsp/BillReceiptPaymentMain.jsp\';\n\t\tmessageFrame.document.location.href = \'../../eCommon/jsp/error.jsp\';\n\t}\n\n\tfunction closeWindow(){\n\t\twindow.close();\n\t\t/* const dialogTag = parent.parent.document.getElementById(\'dialog_tag\');    \n\t\tdialogTag.close(); */\n\t}\n\t</script>\n</HEAD>\n\t\t<iframe name=\'pline\' id=\'pline\' \t\tframeborder=\'0\'\tsrc=\"../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"  scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BillReceiptTab\' id=\'BillReceiptTab\' \tframeborder=\'0\'\tsrc=\"../../eBL/jsp/BillReceiptTabs.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"  scrolling=\'no\' noresize style=\'height:4vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BillReceiptInfo\' id=\'BillReceiptInfo\'\tsrc=\'../../eBL/jsp/BillReceiptInfo.jsp?";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'  frameborder=0  noresize style=\'height:27vh;width:100vw\'></iframe> \t\t\t\t\t\t\t\t\t\n\t\t\t<iframe name=\'BillReceiptExisOrderSearch\' id=\'BillReceiptExisOrderSearch\'\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize  style=\'height:16vh;width:100vw\'> </iframe>\n\t\t\t<iframe name=\'BillReceiptExisOrderDetails\' id=\'BillReceiptExisOrderDetails\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize style=\'height:24vh;width:100vw\'></iframe>\n\t\t\t<iframe name=\'BillReceiptExisOrderSummary\' id=\'BillReceiptExisOrderSummary\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\t<!-- <iframe name=\'BillReceiptWindow\' id=\'BillReceiptWindow\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize style=\'height:4vh;width:100vw\'></iframe>  BillReceiptPaymentMain.jsp -->\n\t\t\t<iframe name=\'messageFrame1\' id=\'messageFrame1\'\t\tframeborder=\'0\' src=\'../../eCommon/jsp/error.jsp\'  scrolling=\'auto\' noresize style=\'height:8vh;width:100vw\'></iframe>\n\t\t\n\t\t\n\t\t\t<!---<FRAMESET id=\"BL_mainFrame\"  ROWS =\'7%,4%,25%,18%,30%,13%,4%\' framespacing=0 >\t\t\t\n\t\t\t<frame name=\'pline\' \t\tframeborder=\'0\'\tsrc=\"../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"  scrolling=\'no\' noresize>\n\t\t\t<frame name=\'BillReceiptTab\' \tframeborder=\'0\'\tsrc=\"BillReceiptTabs.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"  scrolling=\'no\' noresize>\n\t\t\t<FRAME name=\'BillReceiptInfo\'\tsrc=\'BillReceiptInfo.jsp?";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'  frameborder=0  noresize> \t\t\t\t\t\t\t\t\t\n\t\t\t<FRAME name=\'BillReceiptExisOrderSearch\'\tsrc=\'../../eCommon/html/blank.html\' frameborder=0 noresize  > \n\t\t\t<FRAME name=\'BillReceiptExisOrderDetails\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize>\n\t\t\t<FRAME name=\'BillReceiptExisOrderSummary\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize>--->\n\t\t\t<!-- <FRAME name=\'BillReceiptWindow\'\tsrc=\'../../eCommon/html/blank.html\'  frameborder=0 noresize>  BillReceiptPaymentMain.jsp -->\n\t\t\t<!--<frame name=\'messageFrame\'\t\tframeborder=\'0\' src=\'../../eCommon/jsp/error.jsp\'  scrolling=\'auto\' noresize>\n\t\t</FRAMESET>--->\n\t\t\n</HTML>\n\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


String FacilityId = (String)session.getAttribute("facility_id");
String call_from  = request.getParameter("call_from");
String encounter_date	= request.getParameter("encounter_date");
String patient_id	="";
String encounter_id	="";
//V220412
if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
	patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
	encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
}else{
	patient_id	= request.getParameter("patient_id");
	encounter_id	= request.getParameter("encounter_id");
}
//V220412

String episode_id	= request.getParameter("episode_id");
String visit_id	= request.getParameter("visit_id");
String episode_type = request.getParameter("episode_type");
String payerGroup = request.getParameter("payerGroup");
String payer = request.getParameter("payer");

String userId = (String) session.getValue("login_user");
String reqParam = request.getQueryString();

String beanId = "BillReceiptExistOrderExclusion" ;
String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
BillReceiptExistOrderExclusion exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
exclusionBean.clearAll();


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(reqParam ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(reqParam ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(reqParam ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(reqParam ));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
