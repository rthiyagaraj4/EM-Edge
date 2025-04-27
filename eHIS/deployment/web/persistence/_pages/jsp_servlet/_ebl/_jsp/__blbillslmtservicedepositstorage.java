package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import oracle.sql.*;
import oracle.jdbc.*;
import java.math.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import org.json.simple.JSONObject;

public final class __blbillslmtservicedepositstorage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtServiceDepositStorage.jsp", 1733321123258L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );


String toDateFormat(String date) throws ParseException{	
	
	if(date==null){
		return "";
	}
	
	String formattedDate;		
    String oldFormat = "dd/MM/yyyy HH:mm:ss";// 2013-10-08 17:15:33.0
    String newFormat = "yyyy-mm-dd hh:mm:ss";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);


try{
//     Class.forName("oracle.jdbc.OracleDriver");          
//     Connection con = DriverManager.getConnection("jdbc:oracle:thin:@130.78.62.59:1521:srdv","ibaehis","ibaehis");
    Connection con	=	ConnectionManager.getConnection(request);
    
    String record_count=request.getParameter("total_records");
    int total_records=Integer.parseInt(record_count);
    String checked_records=request.getParameter("checked_records");
    int total_checked_records=Integer.parseInt(checked_records);
    System.out.println("Selected Deposit records" + total_records );
    
    System.out.println(record_count);
       
    /* Array of DEPOSIT_DTLS is Constructed Here  */
	/* StructDescriptor deposit_record_descriptor =  StructDescriptor.createDescriptor("IBAEHIS.DEPOSIT_DTLS",con);
    ArrayDescriptor deposit_array_descriptor = ArrayDescriptor.createDescriptor("IBAEHIS.DEP_DTLS", con);
    */ //V231201
    StringBuffer depDocTypeStr =new StringBuffer();
    StringBuffer depdocNumStr =new StringBuffer();
    StringBuffer depSrlnoStr=new StringBuffer();
    StringBuffer depSlmtTypStr =new StringBuffer();
    StringBuffer depDepositStr =new StringBuffer();
    StringBuffer depAdjAmtStr =new StringBuffer();
    StringBuffer depremarkStr =new StringBuffer();
	Object[] deposit_record_array = new Object[total_records];  // to store n number of object data
    Object[] deposit_object   = new Object[7];  // to store object data
    
    for(int rec_count=0; rec_count<total_records ;rec_count++){
    	boolean checkedRecord=request.getParameter("adjustChk"+rec_count)==null?false:Boolean.parseBoolean(request.getParameter("adjustChk"+rec_count));
    	if(checkedRecord){
    		//depDocTypeStr=request.getParameter("docType"+rec_count);
    		if(!"".equals(request.getParameter("docType"+rec_count))){
    			depDocTypeStr.append(request.getParameter("docType"+rec_count)).append("|");
	    	}else{
	    		depDocTypeStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("docNumber"+rec_count))){
    			depdocNumStr.append(Integer.parseInt(request.getParameter("docNumber"+rec_count))).append("|");
	    	}else{
	    		depdocNumStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("docSrlNo"+rec_count))){
    			depSrlnoStr.append(Integer.parseInt(request.getParameter("docSrlNo"+rec_count))).append("|");
	    	}else{
	    		depSrlnoStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("slmtType"+rec_count))){
    			depSlmtTypStr.append(request.getParameter("slmtType"+rec_count)).append("|");
	    	}else{
	    		depSlmtTypStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("deposit"+rec_count))){
    			depDepositStr.append(Double.parseDouble(request.getParameter("deposit"+rec_count))).append("|");
	    	}else{
	    		depDepositStr.append(" ").append("|");
	    	}
    		
    		if(!"".equals(request.getParameter("adjustedAmt"+rec_count))){
    			depAdjAmtStr.append(Double.parseDouble(request.getParameter("adjustedAmt"+rec_count))).append("|");
	    	}else{
	    		depAdjAmtStr.append(" ").append("|");
	    	}
    		if(!"".equals(request.getParameter("remarks"+rec_count))){
    			depremarkStr.append(request.getParameter("remarks"+rec_count)).append("|");
	    	}else{
	    		depremarkStr.append(" ").append("|");
	    	}
    		/* deposit_object[0]=request.getParameter("docType"+rec_count);
	        deposit_object[1]=Integer.parseInt(request.getParameter("docNumber"+rec_count));
	        deposit_object[2]=Integer.parseInt(request.getParameter("docSrlNo"+rec_count));        
	        deposit_object[3]=request.getParameter("slmtType"+rec_count);
	    	deposit_object[4]=Double.parseDouble(request.getParameter("deposit"+rec_count));
	    	deposit_object[5]=Double.parseDouble(request.getParameter("adjustedAmt"+rec_count));
	    	deposit_object[6]=request.getParameter("remarks"+rec_count);
	        STRUCT deposit_record = new STRUCT(deposit_record_descriptor, con, deposit_object);     
	    	deposit_record_array[rec_count]=deposit_record; */
    	}
    }
    
    //ARRAY deposit_parameter_array = new ARRAY(deposit_array_descriptor,con,deposit_record_array);    
   // session.setAttribute("deposit_parameter_array_session",deposit_parameter_array);
   session.setAttribute("depDocTypeStr",depDocTypeStr.toString());
   session.setAttribute("depdocNumStr",depdocNumStr.toString());
   session.setAttribute("depSrlnoStr",depSrlnoStr.toString());
   session.setAttribute("depSlmtTypStr",depSlmtTypStr.toString());
   session.setAttribute("depDepositStr",depDepositStr.toString());
   session.setAttribute("depAdjAmtStr",depAdjAmtStr.toString());
   session.setAttribute("depremarkStr",depremarkStr.toString());
   System.out.println("BLBillSlmtServiceDepositStorage.jsp:"+depDocTypeStr+" "+depdocNumStr+" "+depSrlnoStr+" "+depSlmtTypStr+" "+depDepositStr+" "+depAdjAmtStr+" "+depremarkStr);
    session.setAttribute("deposit_adjusted_payable_amount",(String)request.getParameter("payableAmount"));
    
	//System.out.println(Arrays.asList(deposit_record_array));  
    
	JSONObject obj=new JSONObject();
    obj.put("flag","SUCCESS");    
    out.print(obj);
    out.flush();
     
} catch(Exception e) {
    System.out.println(e);
}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
