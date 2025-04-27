package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import oracle.sql.*;
import com.google.gson.JsonObject;
import java.sql.Date;
import java.text.*;
import java.text.SimpleDateFormat;
import java.sql.*;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import org.json.simple.JSONObject;

public final class __blreprintaudittrailreportajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReprintAuditTrailReportAjax.jsp", 1709114113021L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
Integer toIntegerFormat(String number){	
	if(number==null || number.equals("")){
		return 0;
	}	
	Integer formattedNumber;		
	formattedNumber=Integer.parseInt(number);
	return formattedNumber;		
}

Double toDoubleFormat(String number){	
	if(number==null || number.equals("")){
		return 0.0;
	}	
	Double formattedNumber;		
	formattedNumber=Double.parseDouble(number);
	return formattedNumber;		
}

String toDateFormat(String date,int type) throws ParseException{	
	if(date==null || date.equals("")){
		return null;
	}	
	String formattedDate;	
    String oldFormat = "dd/MM/yyyy HH:mm";// 2013-10-08 17:15:33.0
	if(type==1){
		oldFormat = "dd/MM/yyyy HH:mm";
	}else if(type==2){
		oldFormat = "dd/MM/yyyy";
	}

    String newFormat = "yyyy-MM-dd hh:mm:ss";
    SimpleDateFormat sdfOld = new SimpleDateFormat(oldFormat);
    SimpleDateFormat sdfNew = new SimpleDateFormat(newFormat);    
	formattedDate=sdfNew.format(sdfOld.parse(date));	
	return formattedDate;		
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	CallableStatement statement = null;
	StringBuffer sb = new StringBuffer("") ;
	boolean insertable = true;
	String facilityId = request.getParameter("facilityId");
	String billCount = request.getParameter("billCount");
	String userId = request.getParameter("userId");
	System.out.println("USER: " + userId);
	String patientId = request.getParameter("patientId");
	String episodeType = request.getParameter("episodeType");
	String episodeId = request.getParameter("episodeId");
	String visitId = request.getParameter("visitId");
	String docTypeCode = request.getParameter("docTypeCode");
	String docNum = request.getParameter("docNum");
	String billTotAmt = request.getParameter("billTotAmt");
	String totOutStdAmt = request.getParameter("totOutStdAmt");
	String billDocDate = request.getParameter("billDocDate");
	//System.out.println("newArray: " + newArray);
	

	try {
		con = ConnectionManager.getConnection();
		
		String[] dataArray = {patientId, episodeType, episodeId, visitId, docTypeCode, docNum, billTotAmt, billDocDate,totOutStdAmt,"","","","","",""};
		StructDescriptor bill_doc_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.BILL_DOC_NUMBERS",con);
		Object[] bill_doc_numbers_object   = new Object[15];  // to store object data
		
		bill_doc_numbers_object[0]=patientId;
	    bill_doc_numbers_object[1]=episodeType;
	    bill_doc_numbers_object[2]=toIntegerFormat(episodeId);
	    bill_doc_numbers_object[3]=toIntegerFormat(visitId);
	    bill_doc_numbers_object[4]=docTypeCode;
	    bill_doc_numbers_object[5]=toIntegerFormat(docNum);
	    bill_doc_numbers_object[6]=toDoubleFormat(billTotAmt);
	    bill_doc_numbers_object[7]=toDateFormat(billDocDate,1);
	    bill_doc_numbers_object[8]=toDoubleFormat(totOutStdAmt);
	    bill_doc_numbers_object[9]=toDoubleFormat("0");
	    System.err.println("bill_doc_numbers_object[9] ->"+bill_doc_numbers_object[9]);
	    bill_doc_numbers_object[10]="";
	    bill_doc_numbers_object[11]="";
	    bill_doc_numbers_object[12]="";
	    bill_doc_numbers_object[13]="";
	    bill_doc_numbers_object[14]="";
	    
		STRUCT bill_doc_numbers_record = new STRUCT(bill_doc_record_descriptor, con, bill_doc_numbers_object);
		ArrayDescriptor bill_doc_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.BILL_DTLS", con);
		Object[] bill_doc_numbers_record_array = new Object[1];
		bill_doc_numbers_record_array[0]=bill_doc_numbers_record;
		ARRAY bill_doc_numbers_parameter_array = new ARRAY(bill_doc_array_descriptor,con,bill_doc_numbers_record_array); 
		
		statement=con.prepareCall("{call PROC_MAX_BILL_REPRINT_COUNT(?,?,?,?,?)}");
		statement.setString(1, facilityId);
		statement.setArray(2, bill_doc_numbers_parameter_array);
		statement.setString(3, userId);
		statement.registerOutParameter(4,java.sql.Types.VARCHAR);
		statement.registerOutParameter(5,java.sql.Types.VARCHAR);
		statement.execute();
		String strErrNum = statement.getString(4);
		String strErrText = statement.getString(5);
		System.out.println(strErrNum + "..." + strErrText);
		if ("10".equals(strErrNum) && strErrText != null) {
			if (!(strErrNum.equals("")) || !(strErrText.equalsIgnoreCase("null") )) {
				insertable=false;
				sb.append("Exception while calling procedure proc_max_bill_reprint_count :"+strErrText);  
			}
			out.println(strErrNum+"::::"+strErrText);
		}else {
			out.println("true::::true");
		}
		statement.close();
	} catch(Exception e) {  
		insertable=false;
		sb.append("Exception while calling procedure proc_max_bill_reprint_count :"+e);  
		e.printStackTrace();
	}
		
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
