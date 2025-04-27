package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import eBL.*;
import eBL.Common.*;
import eCommon.Common.*;

public final class __blpkgassociatedtlsvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPkgAssociateDtlsValidation.jsp", 1739259291695L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\t\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

private String checkForNull(String input){
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

String facilityId=(String) session.getValue( "facility_id" ) ;
String patient_id=checkForNull(request.getParameter("patientId"));
String package_code=checkForNull(request.getParameter("packageCode"));
String package_seq_no=checkForNull(request.getParameter("packageSeqNo"));
String blng_class =checkForNull(request.getParameter("blng_class"));	
String  pkg_amount = checkForNull(request.getParameter("pkgAmount")); 
String calledFrom = checkForNull(request.getParameter("calledFrom"));

StringTokenizer pkgCodeArr = new StringTokenizer(package_code,"^");
StringTokenizer pkgSeqArr =  new StringTokenizer(package_seq_no,"^"); 
StringTokenizer blngClassArr =  new StringTokenizer(blng_class,"^"); 
StringTokenizer pkgAmtArr = new StringTokenizer(pkg_amount,"^"); 

if(pkg_amount == null)
pkg_amount ="";

int encounterSequenceNo=0;
float partialDepositAmount=0;
float totalDepositAmount=0;
float cumPartDepAmt = 0;
float minDepAmt = 0;
float cumMinDepAmt = 0;
PreparedStatement pstmtChrg =null;
ResultSet rsChrg =null;
String blngClassCode=null;
String custGrpCode=null;
String custCode=null;
String mandDepYn = "";
String siteId = BLReportIdMapper.getCustomerId();
Connection con = null;
try{
// 	if("ALMO".equals(siteId)){
		con	=	ConnectionManager.getConnection(request);	
		while(pkgCodeArr.hasMoreTokens() && pkgSeqArr.hasMoreTokens()){
			package_code = pkgCodeArr.nextToken();
			package_seq_no = pkgSeqArr.nextToken();
			
			
			package_code = package_code.trim();
			package_seq_no = package_seq_no.trim();
			
			
			if(pkg_amount.length() == 0 ){
				pstmtChrg = con.prepareStatement("select BLNG_CLASS_CODE,CUST_GROUP_CODE,CUST_CODE from bl_package_sub_hdr where PATIENT_ID=? and package_code =? and PACKAGE_SEQ_NO=?");
				pstmtChrg.setString(1,patient_id);
				pstmtChrg.setString(2,package_code);
				pstmtChrg.setString(3,package_seq_no);
				rsChrg = pstmtChrg.executeQuery() ;
					if( rsChrg != null ) 
					{	
						while( rsChrg.next() )
						{  
							blngClassCode = rsChrg.getString(1);
							custGrpCode = rsChrg.getString(2);
							custCode = rsChrg.getString(3);
						}
					}
					if (rsChrg != null) rsChrg.close();
					if (pstmtChrg!=null) pstmtChrg.close();
				System.out.println("blngClassCode:"+blngClassCode+"custGrpCode:"+custGrpCode+"custCode:"+custCode);
				
				CallableStatement callstmt = con.prepareCall("{ call blpackage.GetPackagePrice(?,?,?,?,?,sysdate,?,?,?,?,?,?,?,?,?)}"); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
				callstmt.setString(1,facilityId);			
				callstmt.setString(2,package_code);			
				callstmt.setString(3,blngClassCode);	//blng_class_code	
				callstmt.setString(4,custGrpCode);	//payerGrpCode		
				callstmt.setString(5,custCode);	// payerCode			
				callstmt.registerOutParameter(6,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(7,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(8,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(9,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(10,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(11,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(12,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(13,java.sql.Types.VARCHAR);
				callstmt.registerOutParameter(14,java.sql.Types.VARCHAR); //Added new parameter V171221-Gayathri/MMS-DM-CRF-0118
				callstmt.execute();			
				String pkgPrice = callstmt.getString(6);
				totalDepositAmount=Float.parseFloat(pkgPrice);
				blng_class =  blngClassCode;
				}
				else{
					blng_class = blngClassArr.nextToken();
					pkg_amount = pkgAmtArr.nextToken();
					blng_class = blng_class.trim();
					pkg_amount = pkg_amount.trim();
					totalDepositAmount = Float.parseFloat(pkg_amount);
				}
				System.out.println("patient_id:"+patient_id+"package_code:"+package_code+"package_seq_no:"+package_seq_no+"totalDepositAmount:"+totalDepositAmount);
				
				//pstmtChrg = con.prepareStatement("select  count(*) from BL_PACKAGE_ENCOUNTER_DTLS where patient_id =? and  PACKAGE_SEQ_NO =?");
				pstmtChrg = con.prepareStatement("select  count(*) from bl_package_encounter_dtls where patient_id =? and  PACKAGE_SEQ_NO =?");
				pstmtChrg.setString(1,patient_id);
				pstmtChrg.setString(2,package_seq_no);
				rsChrg = pstmtChrg.executeQuery() ;
					if( rsChrg != null ) 
					{	
						while( rsChrg.next() )
						{  
							String strTotalVisit = rsChrg.getString(1);
								if("Associate".equals(calledFrom)){//MMS-SCF-0389 Karthik added a correction for Associate and Subscription Cases
									encounterSequenceNo=Integer.parseInt(strTotalVisit) + 2;
								}else{
									encounterSequenceNo=Integer.parseInt(strTotalVisit) + 1;	
								}
							System.out.println(encounterSequenceNo);
						}
					}
					if (rsChrg != null) rsChrg.close();
					if (pstmtChrg!=null) pstmtChrg.close();
				
				//pstmtChrg = con.prepareStatement("select MIN_PARTIAL_DEPOSIT_TYPE,MIN_PARTIAL_DEPOSIT from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and ENCOUNTER_SEQ_NO=? and  BLNG_CLASS_CODE = ?");
				//Added below logics - Rajesh V for IN 55781
				String isAcrossEncYN = "N";
				String isPartDepositAllowed = "N";
				try{
					pstmtChrg = con.prepareStatement(BlRepository.getBlKeyValue("BL_PKG_ACROSS_ENC_YN"));
					pstmtChrg.setString(1,facilityId );
					pstmtChrg.setString(2, package_code);
					rsChrg = pstmtChrg.executeQuery() ;
					if(rsChrg != null && rsChrg.next()){
						isAcrossEncYN = rsChrg.getString("across_encounter_yn");
					}
					
					if("Y".equals(isAcrossEncYN)){
						pstmtChrg = null;
						rsChrg = null;
						System.err.println(BlRepository.getBlKeyValue("BL_PKG_PART_DEP_ALLOWED_YN_ASSOC"));
						pstmtChrg = con.prepareStatement(BlRepository.getBlKeyValue("BL_PKG_PART_DEP_ALLOWED_YN_ASSOC"));
						pstmtChrg.setString(1, facilityId);
						pstmtChrg.setString(2, package_code);
						pstmtChrg.setString(3, blng_class);
						pstmtChrg.setString(4, facilityId);
						pstmtChrg.setString(5, package_code);
						pstmtChrg.setString(6, blng_class);
						pstmtChrg.setString(7,facilityId);
						pstmtChrg.setString(8,patient_id);
						pstmtChrg.setString(9,package_code);
						pstmtChrg.setString(10,package_seq_no);
						rsChrg = pstmtChrg.executeQuery() ;
						if(rsChrg != null && rsChrg.next()){
							isPartDepositAllowed = rsChrg.getString("allow_partial_deposit_yn");
						}
					}
				}
				catch(Exception e){
					System.err.println("The Exception is "+e);
				}
				if("Y".equals(isAcrossEncYN) && "Y".equals(isPartDepositAllowed)){
					pstmtChrg = null;
					rsChrg = null;
					
					pstmtChrg = con.prepareStatement("select MIN_PARTIAL_DEPOSIT_TYPE,MIN_PARTIAL_DEPOSIT,NVL(Deposit_mandatory_yn,'N') Deposit_mandatory_yn from bl_package_deposit_dtls where OPERATING_FACILITY_ID=? and PACKAGE_CODE=? and ENCOUNTER_SEQ_NO=? and  (BLNG_CLASS_CODE = ? or BLNG_CLASS_CODE = '**' ) order by  decode(blng_class_code ,'**',999,1) ");
					pstmtChrg.setString(1,facilityId);
					pstmtChrg.setString(2,package_code);
					pstmtChrg.setInt(3,encounterSequenceNo);
					pstmtChrg.setString(4,blng_class);
											
					rsChrg = pstmtChrg.executeQuery() ;
							
					if( rsChrg != null ) 
					{	
						int cnt = 0;
						if(rsChrg.next())
						{  
							cnt++;
							String strPartialDepositType = rsChrg.getString(1);
							String strPartialDeposit = rsChrg.getString(2);
							mandDepYn =  rsChrg.getString("Deposit_mandatory_yn");
							
							if(strPartialDepositType.equals("P")){
								float partialFactor=Float.parseFloat(strPartialDeposit)/100;
								partialDepositAmount=partialFactor*totalDepositAmount;
							}else{
								partialDepositAmount=Float.parseFloat(strPartialDeposit);
							}
							
							if("Y".equals(mandDepYn)){
								minDepAmt = partialDepositAmount;
							}
							
						}
						if(cnt<1){
							if("Associate".equals(calledFrom)){
								partialDepositAmount = 0;
								minDepAmt = 0;
							}
							else{
								partialDepositAmount = totalDepositAmount;
							}
							
						}
					}
					cumPartDepAmt = cumPartDepAmt+partialDepositAmount;
					cumMinDepAmt = cumMinDepAmt+minDepAmt;
				}
				else{
					if("Associate".equals(calledFrom)){
						partialDepositAmount = 0;
						minDepAmt = 0;
					}
					else{
						partialDepositAmount = totalDepositAmount;
					}
					
					cumPartDepAmt = cumPartDepAmt+partialDepositAmount;
					cumMinDepAmt = cumMinDepAmt+minDepAmt;
				}
				
		}
			
			if (rsChrg != null) rsChrg.close();
			if (pstmtChrg!=null) pstmtChrg.close(); 
			if(cumPartDepAmt>0){
				out.println(cumPartDepAmt+"|"+cumMinDepAmt);
			}
			else{
				out.println("PARTIAL_DEPOSIT_DTLS_NOTFOUND|");
			}
// 	}
// 	else{
// 		System.out.println("blpkg&&&&&&&&&&&");
// 		System.out.println("blpkg&&&&&&&&&&&//pkg_amount/cumMinDepAmt"+pkg_amount+"/"+cumMinDepAmt);
// 		out.println(pkg_amount+"|"+cumMinDepAmt);
// 	}
			
		
		
}catch(SQLException e){
	System.err.println("Err Msg from BLPkgAssociateDtlsValidation.jsp "+e);
} 
finally{
	ConnectionManager.returnConnection(con);
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
