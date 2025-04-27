package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __contactreasonqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ContactReasonQueryResult.jsp", 1742375393006L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<HTML>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n</head>\n<BODY OnMouseDown=\'CodeArrest()\'   class=\'CONTENT\' onKeyDown = \'lockKey()\' >\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<p>\n<table align=\'right\'>\n<tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</tr>\n</table>\n\t<br><br>\n</p>\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n<th class=\'columnheader\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n<th class=\'columnheader\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);</script>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'hidden\';\n\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script >\n\tif (document.getElementById(\'next\'))\n\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n</td></tr>\n</table>\n<br>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	
//Below line added for this CRF ML-MMOH-CRF-0566
  Boolean referralRegister = false;
  Boolean isIncompReqCancelApplicable	= false;
  Boolean isRejectRequestApplicable = false;
  Boolean isRejectReportApplicable = false; //Added by Shaik Mujafar for ML-MMOH-CRF-0714
  Boolean isBarcodeScanningApplicable = false;//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
  Boolean isMarkPatientMLC = false; // Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 
  Boolean isPendingForAdmissionAppl=false; //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 Starts-->
  Boolean isBiometricRejectionAppl=false; //	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
PreparedStatement pstmt_rh=null ;
ResultSet rs_rh=null;
String function_name="";
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->
	 
  Connection conn = null;
try {	
	conn = ConnectionManager.getConnection(request);
	//Below line added for this CRF ML-MMOH-CRF-0566
	referralRegister = eCommon.Common.CommonBean.isSiteSpecific(conn, "IP", "RECNL_REFERRAL_REGISTER");
	isIncompReqCancelApplicable =  eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","AUTO_CANCEL_INCOMPLETE_REQUEST");//Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719
	isRejectRequestApplicable =    eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REQUEST_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0713
	isRejectReportApplicable =    eCommon.Common.CommonBean.isSiteSpecific(conn,"MR","REJECT_REPORT_MRP"); //Added by Shaik Mujafar for ML-MMOH-CRF-0714
	isBarcodeScanningApplicable = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "BARCODE_SCANNING_APPLICABLE");//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
	
	isMarkPatientMLC=eCommon.Common.CommonBean.isSiteSpecific(conn,"MP","MARK_PATIENT_MLC"); // Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023
	isPendingForAdmissionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "AE_FOR_ADMISSION_TAB"); //Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972-->
	
	isBiometricRejectionAppl=  eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG"); //	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US11 Starts-->
   	//isBiometricRejectionAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "AE", "SMART_CARD_INTG");   
try
{
pstmt_rh = conn.prepareStatement("select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
rs_rh = pstmt_rh.executeQuery();	
if(rs_rh!=null && rs_rh.next())
{
function_name=rs_rh.getString("VALUE_2");
}
}catch(SQLException esql)
{
	esql.printStackTrace();
}finally
{
 if(pstmt_rh != null)pstmt_rh.close();
 if(rs_rh != null)rs_rh.close();
}
//<!--Added by Himanshu Saxena on  30-Jun-2023 for AAKH-CRF-0175 US1 ends-->

} catch (Exception e) {
       e.printStackTrace();
}
//End this CRF ML-MMOH-CRF-0566
	

	String whereClause = request.getParameter("whereclause");

	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;


	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("contact_reason_code")==null ?"":request.getParameter("contact_reason_code");
	String desc    = request.getParameter("contact_reason_desc")==null ?"":request.getParameter("contact_reason_desc");
	String enabled    = request.getParameter("nature")==null ?"":request.getParameter("nature");
	String applicable = request.getParameter("applicable") == null?"":request.getParameter("applicable");

	int andCheck = 0;

	if ( !(cd == null || cd.equals("")) )
			{
			cd=cd.toUpperCase();
			sbQuery.append("where upper(contact_reason_code) like upper('"+cd+"%')");
			andCheck = 1;
			}
	
		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sbQuery.append("and ");
					sbQuery.append(" upper(contact_reason)  like  upper('"+desc+"%') ");
				}
				else
				{
					sbQuery.setLength(0);
					sbQuery.append("where upper(contact_reason)  like upper('"+desc+"%') ");
					andCheck = 1;
				}
			}
	
		
		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
					{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");
				andCheck = 1;
					}
			else
				{
				//sbQuery.setLength(0);
				sbQuery.append(" and eff_status='E'");
					}
				}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				{
				sbQuery.setLength(0);
				sbQuery.append(" where  eff_status='D'");
				andCheck = 1;
				}
			else
				{
				sbQuery.append(" and eff_status='D'");
				}
		}
		
	}


		if ( !(applicable == null || applicable.equals("")) )
		{
		   if ( applicable.equals("1") )
		        {
			if ( andCheck == 0 )
					{
				sbQuery.setLength(0);	
				sbQuery.append("where BOOK_APPOINTMENT_YN='Y'");	
					}
			else
					{
				sbQuery.append(" and BOOK_APPOINTMENT_YN='Y'");
					}
			}
		   if ( applicable.equals("2") )
			{
			if ( andCheck == 0 )
				{
				sbQuery.setLength(0);	
				sbQuery.append(" where  TRANSFER_APPOINTMENT_YN='Y'");
				}
			else
				{
				sbQuery.append(" and TRANSFER_APPOINTMENT_YN='Y'");
				}
		}
		
		if ( applicable.equals("3") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  CANCEL_APPOINTMENT_YN='Y'");
				}
				else
				{
					sbQuery.append(" and CANCEL_APPOINTMENT_YN='Y'");
				}
			}
			
			if ( applicable.equals("4") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  BLOCK_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(	" and BLOCK_SCHEDULE_YN='Y'");
				}
			}
			
			if ( applicable.equals("5") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  CANCEL_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(" and CANCEL_SCHEDULE_YN='Y'");
				}
			}	
			
			if ( applicable.equals("6") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  TRANSFER_SCHEDULE_YN='Y'");	
				}
				else{
					sbQuery.append("and TRANSFER_SCHEDULE_YN='Y'");
				}
			}
			
			if ( applicable.equals("7") )
			{
				if ( andCheck == 0 )
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where  LIFT_SCHEDULE_YN='Y'");
				}
				else
				{
					sbQuery.append(" and LIFT_SCHEDULE_YN='Y'");
				}
			}
			if ( applicable.equals("8") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  VISIT_REGISTRATION_YN='Y'");
				}
				else
				{
					sbQuery.append(" and VISIT_REGISTRATION_YN='Y'");
				}
			}
			
			if ( applicable.equals("9") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(	" where  REVISE_VISIT_YN='Y'");
				}
				else
				{
					sbQuery.append(" and REVISE_VISIT_YN='Y'");
				}
			}

			if(applicable.equals("10"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_REFERRAL_YN='Y'");
				}
		else
				{
				sbQuery.append(" and REASON_FOR_REFERRAL_YN='Y'");
				}
			}
			if ( applicable.equals("11") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(	" where  CANCEL_VISIT_YN='Y'");
				}
				else
				{
					sbQuery.append(	" and CANCEL_VISIT_YN='Y'");
				}
			}
			if ( applicable.equals("12") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where  cancel_booking_yn='Y'");
				}
				else
				{
					sbQuery.append("and cancel_booking_yn='Y'");
				}
			}
			if ( applicable.equals("13") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append("where  cancel_admission_yn='Y'");
				}
				else
				{
					sbQuery.append(" and cancel_admission_yn='Y'");
				}
			}
			
			if ( applicable.equals("14") )
			{
				if ( andCheck == 0 )
				{
					sbQuery.setLength(0);	
					sbQuery.append("where  cancel_discharge_advice_yn='Y'");
				}
				else
				{
					sbQuery.append(" and cancel_discharge_advice_yn='Y'");
				}
			}	
			
			if (applicable.equals("15"))
			{
				if( andCheck == 0)
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where REASON_FOR_REVISE_BKG_YN='Y'");
				}
				else
				{
						sbQuery.setLength(0);	
						sbQuery.append(" and REASON_FOR_REVISE_BKG_YN='Y'");
				}
			}
			if (applicable.equals("16"))
			{
				if( andCheck == 0)
				{
						sbQuery.setLength(0);	
						sbQuery.append(" where CANCEL_TRANSFER_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append("and CANCEL_TRANSFER_YN='Y'"); 	
				}
			}
			if (applicable.equals("17"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REGISTER_ATTENDANCE_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append("and REGISTER_ATTENDANCE_YN='Y'");
				}
			}
			if (applicable.equals("18"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_RECALL_YN='Y'");
				}
				else
				{

					//sbQuery.setLength(0);	
					sbQuery.append( " and REASON_FOR_RECALL_YN='Y'");
				}
			}

/**************ADD******/
			if(applicable.equals("19"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_WAIT_LIST_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_WAIT_LIST_YN='Y'");
				}
			}

			if(applicable.equals("20"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where MODIFY_WAIT_LIST_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and MODIFY_WAIT_LIST_YN='Y'");
				}
			}

			if(applicable.equals("21"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where -FOLLOWUP_OF_REFERRAL_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and -FOLLOWUP_OF_REFERRAL_YN='Y'");
				}
			}

			if(applicable.equals("22"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where PATIENT_DEPART_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and PATIENT_DEPART_YN='Y'");
				}
			}
			
			if(applicable.equals("23"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REJECTION_OF_REFERRAL_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and REJECTION_OF_REFERRAL_YN='Y'");
				}
			}

			if(applicable.equals("24"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_AE_CHECKOUT_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_AE_CHECKOUT_YN='Y'");
				}
			}

			if(applicable.equals("25"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_OP_CHECKOUT_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CANCEL_OP_CHECKOUT_YN='Y'");
				}
			}

			

			if(applicable.equals("26"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CHANGE_ADMISSION_DTLS_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and CHANGE_ADMISSION_DTLS_YN='Y'");
				}
			}

			if(applicable.equals("27"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REVERT_MO_RELEASE_YN='Y'");
				}
				else
				{
					//sbQuery.setLength(0);	
					sbQuery.append( " and REVERT_MO_RELEASE_YN='Y'");
				}
			}

			if(applicable.equals("28"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where REASON_FOR_LATE_DISCH_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and REASON_FOR_LATE_DISCH_YN='Y'");
				}
			}

			if(applicable.equals("29"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where PRACT_OVERRIDE_REASON_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and PRACT_OVERRIDE_REASON_YN='Y'");
				}
			}

			if(applicable.equals("30"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where TRANS_EXCEED_REASON_YN='Y'");
				}
				else
				{
					
					sbQuery.append( " and TRANS_EXCEED_REASON_YN='Y'");
				}
			}
			// Below Condition Added Against Bru-HIMS-CRF-348 [IN:038247] By Saanthaakumar
			if(applicable.equals("31"))
			{
				if( andCheck == 0)
				{
					sbQuery.setLength(0);	
					sbQuery.append(" where CANCEL_EMBALM_YN='Y'");
				}
				else
				{
					sbQuery.append( " and CANCEL_EMBALM_YN='Y'");
				}
			}
			
			/*Below line added for this CRF ML-MMOH-CRF-0566*/
			if(referralRegister && isIncompReqCancelApplicable && isRejectRequestApplicable && isRejectReportApplicable){
			
			        if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_MEDICAL_REQUEST_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_MEDICAL_REQUEST_YN='Y'");
						}
					}
					if(applicable.equals("33"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where REJECT_REF_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and REJECT_REF_REASON_YN='Y'");
						}
					}
					if(applicable.equals("34"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_REF_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_REF_REASON_YN='Y'");
						}
					}
					
					if(applicable.equals("35"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where reject_request_mrp_yn='Y' ");
						}
						else
						{
							
							sbQuery.append( " and reject_request_mrp_yn='Y' ");
						}
					}
				
					if(applicable.equals("36"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where reject_report_mrp_yn='Y' ");
						}
						else
						{
							
							sbQuery.append( " and reject_report_mrp_yn='Y' ");
						}
					}

					/*Added By Dharma on 11th Mar 2020 against ML-MMOH-CRF-1473 Start*/
					
					if(applicable.equals("37"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where rejected_to_mrd_by_pract_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and rejected_to_mrd_by_pract_yn='Y'");
						}
					}
					if(applicable.equals("38"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where return_to_hod_by_pract_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and return_to_hod_by_pract_yn='Y'");
						}
					}
					/*Added By Dharma on 11th Mar 2020 against ML-MMOH-CRF-1473 End*/
					//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
					if(applicable.equals("39"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					if(applicable.equals("40"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where exclude_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and exclude_yn='Y'");
						}
					}
			    
			}//Added on 26-MAR-2020 FOR MMS-DM-CRF-0157 BY KAMATCHI S
			else if(isBarcodeScanningApplicable){

				 	if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}
				
				if(applicable.equals("33"))
				{
					if( andCheck == 0)
					{
						
						sbQuery.setLength(0);	
						sbQuery.append(" where BARCODE_SCANNING_YN='Y' ");
					}
					else
					{
						
						sbQuery.append( " and BARCODE_SCANNING_YN ='Y' ");
					}
				}

				//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
				if(applicable.equals("34"))
				{
					if( andCheck == 0)
					{
						sbQuery.setLength(0);	
						sbQuery.append(" where exclude_yn='Y'");
					}
					else
					{
						
						sbQuery.append( " and exclude_yn='Y'");
					}
				}
			}
			else
			{
				//Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589
					if(applicable.equals("32"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where UNIT_TRANSFER_REASON_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and UNIT_TRANSFER_REASON_YN='Y'");
						}
					}

					//Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1
					if(applicable.equals("33"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where exclude_yn='Y'");
						}
						else
						{
							
							sbQuery.append( " and exclude_yn='Y'");
						}
					}
			}
			//End this CRF ML-MMOH-CRF-0566
			/***********END**********/
			/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 start*/
		if (isMarkPatientMLC) {
			if(applicable.equals("41"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where MARK_MLC_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and MARK_MLC_YN='Y'");
						}
					}
					if(applicable.equals("42"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where MARK_NONMLC_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and MARK_NONMLC_YN='Y'");
						}
					}
		}
		/*Added by lakhsmanan for ML-MMOH-CRF-1955 on 12-07-2023 end */
		
	//<!--Added by Himanshu Saxena on 12-07-2023  for ML-MMOH-CRF-1972 starts--> 
		if(isPendingForAdmissionAppl)
		{
			if(applicable.equals("43"))
					{
						if( andCheck == 0)
						{
							sbQuery.setLength(0);	
							sbQuery.append(" where CANCEL_FOR_ADMISSION_YN='Y'");
						}
						else
						{
							
							sbQuery.append( " and CANCEL_FOR_ADMISSION_YN='Y'");
						}
					}
		}
	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
	if(function_name.equals("01"))
	{
		if(applicable.equals("44"))
		{
			if( andCheck == 0)
			{
				sbQuery.setLength(0);	
				sbQuery.append(" where REASON_BIOMETRIC_REJECTION_YN='Y'");
			}
			else
			{
				
				sbQuery.append( " and REASON_BIOMETRIC_REJECTION_YN='Y'");
			}
		}
		
	}
	//	<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Ends-->	
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append( " order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			sbQuery.append(ord[i]);
		else
				sbQuery.append(ord[i]+",");
		}
	}
	} //end of where clause IF
	else {
			sbQuery.setLength(0);	
			sbQuery.append( whereClause);
	//	sql = whereClause;

	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;
		

Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;

try{
//conn = ConnectionManager.getConnection(request);


String strsql2="select * from am_contact_reason "+sbQuery.toString();
stmt = conn.createStatement();
 
rs = stmt.executeQuery(strsql2);

	 if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }

	  while ( i<=end && rs.next()  )
	{
		  if(maxRecord==0)
		{


            _bw.write(_wl_block7Bytes, _wl_block7);

if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ContactReasonQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ContactReasonQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
 }
 	
String classValue = "" ;
       if ( i % 2 == 0 )
       		classValue = "QRYEVEN" ;
       	else
		classValue = "QRYODD" ;


	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("contact_reason_code");
	
	out.println("<a href='../../eAM/jsp/addModifyContactReason.jsp?contact_reason_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("contact_reason") );
	out.println("</td>");
	
	out.println("<td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else if ( rs.getString("eff_status").equals("D") )
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;

  }//endwhile

  if(maxRecord == 0)
{
            _bw.write(_wl_block11Bytes, _wl_block11);
}

if ( maxRecord < 14 || (!rs.next()) ) {

            _bw.write(_wl_block12Bytes, _wl_block12);
 
		} else {
            _bw.write(_wl_block13Bytes, _wl_block13);
}

		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
}catch(Exception e){
		e.toString();
}
	finally   {
	
		ConnectionManager.returnConnection(conn,request);

	}

            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonCode.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonDescription.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enabled.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
