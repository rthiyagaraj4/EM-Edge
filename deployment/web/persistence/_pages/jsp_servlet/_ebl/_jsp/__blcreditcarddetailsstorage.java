package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blcreditcarddetailsstorage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCreditCardDetailsStorage.jsp", 1709114095881L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate     \t  Edit History      Name     \t\t\tDescription\n--------------------------------------------------------------------------------------------------------------\n1-Dec-2014     100           \tKarthikeyan.K       GHL-CRF-0366.1 Karthik Created this File code for Credit Card Integration   \n---------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n</HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String cardOperation=request.getParameter("cardOperation");
	
	if(cardOperation.equals("storedata")){
	
 	String P_patient_id=request.getParameter("P_patient_id");
	String P_episode_ID=request.getParameter("P_episode_ID");
	String P_settlement_type=request.getParameter("P_settlement_type");
	String P_trn_type=request.getParameter("P_trn_type");
	String p_doc_date=request.getParameter("p_doc_date");
	String P_Bill_Doc_Type=request.getParameter("P_Bill_Doc_Type");
	String P_Bill_Doc_Num =request.getParameter("P_Bill_Doc_Num");
	String P_Total_Bill_Amount=request.getParameter("P_Total_Bill_Amount");
	String P_doc_amt=request.getParameter("P_doc_amt");
	String P_Preapaid_Card_Number=request.getParameter("P_Preapaid_Card_Number");
	String P_Reciept_Date=request.getParameter("P_Reciept_Date");
	String P_USER_ID=request.getParameter("P_USER_ID");
	String P_RESP_ID=request.getParameter("P_RESP_ID");
	String P_FACILITY_ID=request.getParameter("P_FACILITY_ID");
	String P_MODULE_ID=request.getParameter("P_MODULE_ID");
	String P_FUNCTION_ID=request.getParameter("P_FUNCTION_ID");
	String P_LANGUAGE_ID=request.getParameter("P_LANGUAGE_ID");
	String P_WS_NO=request.getParameter("P_WS_NO");
	String P_Trx_No=request.getParameter("P_Trx_No");
	String P_Ext_Input_Key=request.getParameter("P_Ext_Input_Key");
	String P_Ext_Application_ID=request.getParameter("P_Ext_Application_ID");
	String P_Ext_Function=request.getParameter("P_Ext_Function");
	String P_PATIENT_NAME=request.getParameter("P_PATIENT_NAME");
	
	Map<String,String> paramMap=new HashMap<String,String>();
	paramMap.put("P_patient_id",P_patient_id);
	paramMap.put("P_episode_ID",P_episode_ID);
	paramMap.put("P_settlement_type",P_settlement_type);
	paramMap.put("P_trn_type",P_trn_type);
	paramMap.put("p_doc_date",p_doc_date);
	paramMap.put("P_Bill_Doc_Type",P_Bill_Doc_Type);
	paramMap.put("P_Bill_Doc_Num",P_Bill_Doc_Num);
	paramMap.put("P_Total_Bill_Amount",P_Total_Bill_Amount);
	paramMap.put("P_doc_amt",P_doc_amt);
	paramMap.put("P_Preapaid_Card_Number",P_Preapaid_Card_Number);
	paramMap.put("P_Reciept_Date",P_Reciept_Date);
	paramMap.put("P_USER_ID",P_USER_ID);
	paramMap.put("P_RESP_ID",P_RESP_ID);
	paramMap.put("P_FACILITY_ID",P_FACILITY_ID);
	paramMap.put("P_MODULE_ID",P_MODULE_ID);
	paramMap.put("P_FUNCTION_ID",P_FUNCTION_ID);
	paramMap.put("P_LANGUAGE_ID",P_LANGUAGE_ID);
	paramMap.put("P_WS_NO",P_WS_NO);
	paramMap.put("P_Trx_No",P_Trx_No);
	paramMap.put("P_Ext_Input_Key",P_Ext_Input_Key);
	paramMap.put("P_Ext_Application_ID",P_Ext_Application_ID);
	paramMap.put("P_Ext_Function",P_Ext_Function);
	paramMap.put("P_PATIENT_NAME",P_PATIENT_NAME);	
	session.setAttribute("BL_CREDIT_CARD_PARAM_MAP", paramMap);
	
	String cardData= request.getParameter("cardData");	
	session.setAttribute("BL_CREDIT_CARD_DETAILS", cardData);
	//System.out.println(cardData);
	}else{
	session.removeAttribute("BL_CREDIT_CARD_DETAILS");
	//System.out.println("session BL_CREDIT_CARD_DETAILS cleared");
	}
	
	

	


            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
