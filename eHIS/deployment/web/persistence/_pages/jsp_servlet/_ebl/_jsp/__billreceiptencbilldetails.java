package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.billreceipt.model.BillReceiptCustomerDetails;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __billreceiptencbilldetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptEncBillDetails.jsp", 1737913084988L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="    \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Encounter Billing Details</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n$(document).ready(function(){\t\n\t/*$(\'#encBillingDetails\').hide();\n\t\n\t$(\'#resizeBtnSearch\').click(function(){\n\t\tvar defValue = $(this).attr(\'defValue\');\n\t\tif(defValue ==\'shrink\'){\n\t\t\t$(this).attr(\'defValue\',\'expand\');\n\t\t\t$(this).attr(\'src\',\'../../eOT/images/ShowMore.gif\');\n\t\t\t$(\'#encBillingDetails\').hide();\t\n\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#searchCriteriaDiv\').hide();\n\t\t\tparent.document.getElementById(\'BL_mainFrame\').rows =  parent.document.getElementById(\'allFramesExisting\').value;\n\t\t}\n\t\telse{\n\t\t\t$(this).attr(\'defValue\',\'shrink\');\n\t\t\t$(this).attr(\'src\',\'../../eOT/images/ShowLess.gif\');\n\t\t\t$(\'#encBillingDetails\').show();\n\t\t\t$(parent.BillReceiptExisOrderSearch.document).find(\'#searchCriteriaDiv\').hide();\n\t\t\tparent.document.getElementById(\'BL_mainFrame\').rows =  parent.document.getElementById(\'showEncBilling\').value;\n\t\t}\n\t});*/\n});\n</script>\n</head>\n<body>\n\t<table  style=\"width: 100%\" CELLSPACING=\'10\' cellpadding=3 align=\'center\'>\n\t\t<tr style=\"width: 100%\">\n   \t\t\t<th width=\'100%\' class=\'COLUMNHEADER\' nowrap align=\'left\' >\n   \t\t\t\tEncounter Billing Details\n   \t\t\t\t<!-- &nbsp;&nbsp;<img id=\"resizeBtnSearch\" alt=\"\" defValue=\"expand\" src=\"../../eOT/images/ShowMore.gif\" style=\"cursor: pointer;\" >  --> \n   \t\t\t</th>\n   \t\t</tr>\n\t</table>\n\t<form name=\'frmEncBill\' id=\'frmEncBill\' id=\'frmEncBill\'>\n\t\t<table id=\'encBillingDetails\' name=\'encBillingDetails\' id=\'encBillingDetails\' CELLSPACING=0 cellpadding=3 align=\'center\' class=\'grid\'>\n\t\t\t<tr style=\"width: 100%\">\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tBilling Group\n\t\t\t\t</th>\n\t\t\t\t<th width=\"4%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPriority\n\t\t\t\t</th>\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPayer\n\t\t\t\t</th>\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPolicy Type\n\t\t\t\t</th>\n\t\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPolicy Number\n\t\t\t\t</th>\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPolicy Start Date\n\t\t\t\t</th>\n\t\t\t\t<th width=\"10%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tPolicy Expiry Date\n\t\t\t\t</th>\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tCredit Auth Ref\n\t\t\t\t</th>\n\t\t\t\t<th width=\"9%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tCredit Auth Date\n\t\t\t\t</th>\n\t\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tEffective From\n\t\t\t\t</th>\n\t\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tEffective To\n\t\t\t\t</th>\n\t\t\t\t<th width=\"8%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tApproved Amt\n\t\t\t\t</th>\n\t\t\t\t<th width=\"4%\" class=\'COLUMNHEADER\'>\n\t\t\t\t\tDays\n\t\t\t\t</th>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"9%\" class=\'LABEL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"4%\" class=\'LABEL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"9%\" class=\'LABEL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"8%\" class=\'LABEL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" class=\'LABEL\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
	
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


private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String episodeType= replaceNull(request.getParameter("episode_type"));
	//V220512
	//String patientId = replaceNull(request.getParameter("patient_id"));
	String patientId="";
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
		patientId	=replaceNull(request.getParameter("patient_id"));
	}
	//V220512
	String episodeId= replaceNull(request.getParameter("episode_id"));
	String visitId= replaceNull(request.getParameter("visit_id"));
	String locale= (String)session.getAttribute("LOCALE");
	String facilityId = (String) session.getValue("facility_id");
	BillReceiptRequest brRequest = new BillReceiptRequest();
	brRequest.setEpisodeType(episodeType);
	brRequest.setPatientId(patientId);
	brRequest.setEpisodeId(episodeId);
	brRequest.setVisitId(visitId);
	brRequest.setLocale(locale);
	brRequest.setFacilityId(facilityId);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptCustomerDetails> custList = billReceiptBC.getEncBillDetails(brRequest);
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
for(BillReceiptCustomerDetails cust:custList){ 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( replaceNull(cust.getBlngGrpId()) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( replaceNull(cust.getPriority()) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( replaceNull(cust.getCustCode()) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( replaceNull(cust.getPolicyTypeCode()) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( replaceNull(cust.getPolicyNo()) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( replaceNull(cust.getPolStartDate()) ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( replaceNull(cust.getPolExpDate()) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( replaceNull(cust.getCreditAuthRef()) ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( replaceNull(cust.getCreditAuthDate()) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( replaceNull(cust.getEffectiveFrom()) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( replaceNull(cust.getEffectiveTo()) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( replaceNull(cust.getApprovedAmt()) ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( replaceNull(cust.getApprovedDays()) ));
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
