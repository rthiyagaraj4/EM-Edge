package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import org.json.simple.JSONObject;

public final class __blcashcounterreceiptrefundvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCashCounterReceiptRefundValidation.jsp", 1729589269915L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
	
		/* Page Added by Karthik for MMS-MD-SCF-0006 [IN:060039] 4/28/2016 */
		String strfacilityid	=  (String) session.getValue("facility_id");
		if(strfacilityid == null) strfacilityid="";
		String strloggeduser	=  (String) session.getValue("login_user");			
		if(strloggeduser == null) strloggeduser="";
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");	
		String strwsno = p.getProperty("client_ip_address");
		String strepisodetype	=	request.getParameter("episodeType"); //"I","O","E" .
		String receiptRefundIndicator = request.getParameter("receiptRefundIndicator"); // "REFUND" , "RECEIPT"
		if(receiptRefundIndicator==null) receiptRefundIndicator="";
		String strcashcountercode="";
		String strsysmessageid="";
		String strshiftid="";

		Connection con = ConnectionManager.getConnection(request);;
		CallableStatement call =null;
						try 
						{
							System.out.println("{ call Ajax BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");
							call = con.prepareCall("{ call BL_USER_CHECK_FOR_CASH_COUNTER (?,?,?,?,?,?,?)}");			
							call.setString(1,strfacilityid);
							call.setString(2,strepisodetype);//"O");//Karthikkkkkk
							call.setString(3,strloggeduser);
							call.setString(4,strwsno);
							call.registerOutParameter(5,java.sql.Types.VARCHAR); // Cash Counter
							call.registerOutParameter(6,java.sql.Types.VARCHAR); // shift
							call.registerOutParameter(7,java.sql.Types.VARCHAR); // Error code
							call.execute();				

							strcashcountercode	 = call.getString(5);
							strshiftid		 = call.getString(6);
							strsysmessageid	 = call.getString(7);		
							call.close();	
							if ( strsysmessageid == null ) strsysmessageid = "";
							if ( strcashcountercode == null ) strcashcountercode = "";
							if ( strshiftid == null ) strshiftid = "";
						}
						catch(Exception e) 
						{   e.printStackTrace();
							out.println(e.toString()); 
						}
						
						if(strsysmessageid.equals("")){
							if(receiptRefundIndicator.equals("RECEIPT") || receiptRefundIndicator.equals("REFUND") ){
								try 
								{
									System.out.println("{ call Ajax blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");
									call = con.prepareCall("{ call blcommon.get_receipt_refund_check (?,?,?,?,?,?,?,?,?,?)}");			
									call.setString(1,strfacilityid);
									call.setString(2,strcashcountercode);
									call.registerOutParameter(3,java.sql.Types.VARCHAR);
									call.registerOutParameter(4,java.sql.Types.VARCHAR);
									call.registerOutParameter(5,java.sql.Types.VARCHAR);
									call.registerOutParameter(6,java.sql.Types.VARCHAR);
									call.registerOutParameter(7,java.sql.Types.VARCHAR);
									call.registerOutParameter(8,java.sql.Types.VARCHAR);
									call.registerOutParameter(9,java.sql.Types.VARCHAR);
									call.registerOutParameter(10,java.sql.Types.VARCHAR);
									call.execute();				
		
		                            String g_rcpt_ip_allowed_yn= call.getString(3);
		                            String g_rcpt_op_allowed_yn= call.getString(4);
		                            String g_rcpt_ref_allowed_yn= call.getString(5);
		                            String g_rfnd_ip_allowed_yn= call.getString(6);
		                            String g_rfnd_op_allowed_yn= call.getString(7);
		                            String g_rfnd_ref_allowed_yn= call.getString(8);
		                            String p_error_id= call.getString(9);
		                            String p_error_text= call.getString(10);	
		                            
								
		                            if(receiptRefundIndicator.equals("RECEIPT")){
			                            if(g_rcpt_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
			                            	strsysmessageid="BL9652";
			                            }
			                            if(g_rcpt_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))){
			                            	strsysmessageid="BL9653";
			                            }
			                            if(g_rcpt_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){
			                            	strsysmessageid="BL9654";
			                            }
		                            }else if(receiptRefundIndicator.equals("REFUND")){
			                            if(g_rfnd_op_allowed_yn.equals("N") && (strepisodetype.equals("O") || strepisodetype.equals("E"))){
			                            	strsysmessageid="BL9655";
			                            }
			                            if(g_rfnd_ip_allowed_yn.equals("N") && (strepisodetype.equals("I") || strepisodetype.equals("D"))) {                 			
			                            	strsysmessageid="BL9656";
			                            }
			                            if(g_rfnd_ref_allowed_yn.equals("N") && strepisodetype.equals("R")){	             			
			                            	strsysmessageid="BL9657";
			                            }
		                            }
			
		
								}
								catch(Exception e) 
								{   e.printStackTrace();
									out.println(e.toString()); 
								}finally{
									call.close();
								}
							}
						}
						
						if(strsysmessageid.equals("")){
                            if(receiptRefundIndicator.equals("RECEIPT")){
									try 
									{
										System.out.println("{ call Ajax blcommon.check_for_receipt (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_receipt (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_receipt_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_receipt_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1260";
				                            }
			
									}
									catch(Exception e) 
									{   e.printStackTrace();
										out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}	
						
						if(strsysmessageid.equals("")){
							if(receiptRefundIndicator.equals("REFUND")){
									try 
									{
										System.out.println("{ call Ajax blcommon.check_for_refund (?,?,?,?,?,?)}");
										call = con.prepareCall("{ call blcommon.check_for_refund (?,?,?,?,?,?)}");								
										call.setString(1,strloggeduser);
										call.setString(2,strfacilityid);
										call.setString(3,strcashcountercode);
										call.registerOutParameter(4,java.sql.Types.VARCHAR);
										call.registerOutParameter(5,java.sql.Types.VARCHAR);
										call.registerOutParameter(6,java.sql.Types.VARCHAR);
										call.execute();				
			
			                            String cash_counter_refund_allowed_yn = call.getString(4);
			                            String p_error_id= call.getString(5);
			                            String p_error_text= call.getString(6);                            
										
			                                if(cash_counter_refund_allowed_yn.equals("N")){
				                            	strsysmessageid="BL1261";
				                            }
			
									}
									catch(Exception e) 
									{   e.printStackTrace();
										out.println(e.toString()); 
									}finally{
										call.close();
									}
							}
						}
			
					JSONObject obj=new JSONObject();
					if(strsysmessageid.equals(""))
					{	
					    obj.put("flag","Y");  
					    obj.put("messageid",strsysmessageid); 
					}else{
					    obj.put("flag","N"); 
					    obj.put("messageid",strsysmessageid); 
					    
					}
 
				    out.print(obj);
				    out.flush();
					
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
