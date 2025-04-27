package jsp_servlet._eop._jsp;

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

public final class __assignpractforautoclose extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/AssignPractForAutoClose.jsp", 1723020346716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\"../../eCommon/js/common.js\"></script>\n<script src=\"../../eOP/js/BatchProcess.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onMouseDown=\"CodeArrest();\" onKeyDown =\'lockKey()\'>\n<form name=\"assPracForAutoClose\" id=\"assPracForAutoClose\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="             <P>\n\t\t\t\t\t\t\t<table align=\'right\'  >\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<br><br>\n\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t<table border=\"1\" width=\"90%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\'>\n\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'12%\' nowrap>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'5%\'nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'13%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\t\t\t\t \n\t\t \n\t\t \n\t\t\t\t\t ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t<tr><td   class=\'CAGROUPHEADING\' nowrap colspan=4><font size=\'1\' ><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td></tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' class=\'QRY\'><font size=\'1\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' class=\'QRY\' NOWRAP><font size=\'1\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>  \n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'QRY\'><a href=\'javascript:callChkOut(\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\",\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\");\' name=\'ass_pract";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'><font size=\'1\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.getElementById(\"nextval\").innerHTML=\" \";\n\t\t\t\t\t</script>\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n<input type=\'hidden\' name=\'oper_id\' id=\'oper_id\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'module_id\' id=\'module_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\n</table>\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String facility_id			= (String) session.getValue( "facility_id" ) ;
	String locale               = (String)session.getAttribute("LOCALE"); 
	String userid           = (String) session.getValue("login_user");

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con=null;
	Statement stmt;
	ResultSet rset;

	String classValue = "";
	String p_encounter_id = "";
	String p_queue_no = "";
	String p_patient_id = "";
	String p_regn_time = "";
	String p_status = "";
	String queue_status = "";
	String pat_curr_locn_type_desc="";
    String module_id=request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String  bl_interfaced_yn = (request.getParameter("bl_interfaced_yn")==null)?"N": request.getParameter("bl_interfaced_yn");

	String  bl_install_yn = (request.getParameter("bl_install_yn")==null)?"N": request.getParameter("bl_install_yn");
	
	String oth_res_class = "";		 
	String locn_type	 = "";			
	String locn_code	 = "";		
	String date_time	 = "";		
	String patient_details="";
    String queue_date="";
    String locn_desc ="";
	String prev_locn_code="";
	String oper_id="";
	String pract_id = "";
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;	
    String patient_class = "";	
	String episode_id = "";
	String visit_id = "";
	String  mds_mode="";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
	String allow_chkout_with_bill_stmt_yn = (request.getParameter("allow_chkout_with_bill_stmt_yn")==null)?"N": request.getParameter("allow_chkout_with_bill_stmt_yn");
 	

	if(module_id.equals("OP"))
		{	
        patient_class = "OP";		
		mds_mode="OC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		}
	else if(module_id.equals("AE"))		
		{
        patient_class = "EM";
		mds_mode="EC";//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
		}

	
	try {
			int start = 0 ;
			int end = 0 ;
			int i=1;
			int endOfRes=1;
			int num=1;
    
			if ( from == null )
				start = 1 ;
			else
				start = Integer.parseInt( from ) ;

			if ( to == null )
				end = 10 ;
			else
				end = Integer.parseInt( to ) ;	
			
			

			con=ConnectionManager.getConnection(request);
			stmt=con.createStatement();	

			String sql_op = "Select AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+userid+"','X','','CHECKOUT_PAT_YN') FROM dual" ;
			rset=stmt.executeQuery(sql_op);
			rset.next();
			oper_id = rset.getString(1);

			if(stmt!=null)
				stmt.close();
			if(rset!=null)
				rset.close();
			

			stmt=con.createStatement();			
			String sql="select encounter_id, Practitioner_id ,queue_num, patient_id, TO_CHAR (queue_date, 'dd/mm/yyyy') queue_date, queue_status , TO_CHAR (queue_date, 'dd/mm/yyyy HH24:MI') regn_date_time , (CASE   WHEN INSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),'#')>0 THEN    SUBSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),1,INSTR(GET_PATIENT_LINE(PATIENT_ID,'"+locale+"'),'#')-1)END) patient_details ";  
			if(module_id.equals("OP"))
		    {
				sql=sql+",OTHER_RES_CLASS,";
			}else
			{
				sql=sql+",'' OTHER_RES_CLASS,";
			}
		
			sql=sql+ "  locn_type,am_get_desc.am_care_locn_type(locn_type,'"+locale+"', '1') pat_curr_locn_type_desc, locn_code,op_get_desc.OP_CLINIC(facility_id,locn_code,'"+locale+"',2)locn_desc, TO_CHAR (DECODE (queue_status,'01',check_in_date_time,'02', arrive_date_time,'03', vital_signs_date_time,'04', cons_srvc_start_date_time, '05', NULL,'06', subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt,episode_id,op_episode_visit_num from ";

			if(module_id.equals("OP"))
			{
				//sql=sql+" op_current_patient WHERE facility_id = '"+facility_id+"' AND queue_date < SYSDATE - (SELECT visit_compl_days FROM op_param WHERE operating_facility_id = '"+facility_id+"') AND queue_status < '07' ";
				sql=sql+" op_current_patient,op_param WHERE facility_id = '"+facility_id+"' and operating_facility_id = facility_id   AND TRUNC(queue_date) < TRUNC((SYSDATE - visit_compl_days)) and queue_status < '07' ";
			}
			else
			{
				//sql=sql+" ae_current_patient WHERE facility_id = '"+facility_id+"' AND queue_date < SYSDATE - (SELECT visit_compl_days FROM op_param WHERE operating_facility_id = '"+facility_id+"') AND queue_status < '07' ";
				sql=sql+" ae_current_patient,op_param WHERE facility_id = '"+facility_id+"' and operating_facility_id = facility_id and TRUNC(queue_date) < TRUNC((SYSDATE - visit_compl_days)) and queue_status < '07' ";
			}

			//Maheshwaran K modified MR_MDS_RECORDED_YN for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			sql = sql+"AND MR_MDS_RECORDED_YN(facility_id,encounter_id,'"+patient_class+"',null,'"+mds_mode+"',null) = 'Y' "; 		

			if( bl_install_yn.equals("Y") && bl_interfaced_yn.equals("Y") )
			{
				sql = sql+"  AND BLOPIN.VISIT_AUTO_CLOSE_YN(facility_id, LOCN_CODE, VISIT_TYPE_CODE, DECODE(PRACTITIONER_ID,'*ALL','',PRACTITIONER_ID),ENCOUNTER_ID)='N' ";
			}
			
			sql = sql+" ORDER BY locn_code ";
			
			//BLOPIN.VISIT_AUTO_CLOSE_YN(facility_id, LOCN_CODE, VISIT_TYPE_CODE, DECODE(PRACTITIONER_ID,'*ALL','',PRACTITIONER_ID))='N' ORDER BY locn_code "; 
			
			rset=stmt.executeQuery(sql);      		
	
			if ( start != 1 )
			{
				for( int k=1; k<start; i++,k++ )
				{
					rset.next() ;
				}
			}
			try {

					int cnt=0;
					while(i<=end && rset.next()) {
						if(cnt==0) {
			
            _bw.write(_wl_block7Bytes, _wl_block7);


										if ( !(start <= 1) )
											out.println("<A HREF='../../eOP/jsp/AssignPractForAutoClose.jsp?from="+(start-10)+"&module_id="+module_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&bl_install_yn="+bl_install_yn+"&to="+(end-10)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

										if ( endOfRes == 1 ) 
											out.println("<A id='nextval' HREF='../../eOP/jsp/AssignPractForAutoClose.jsp?from="+(start+10)+"&module_id="+module_id+"&allow_chkout_with_bill_stmt_yn="+allow_chkout_with_bill_stmt_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&bl_install_yn="+bl_install_yn+"&to="+(end+10)+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
										
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

					 }

					 if ( i % 2 == 0 )
						classValue = "QRYEVEN" ;
					 else
						classValue = "QRYODD" ;					 
					 pract_id			 = rset.getString("Practitioner_id");
					 oth_res_class		 = rset.getString("OTHER_RES_CLASS");
					 locn_type			 = rset.getString("locn_type");
					 locn_code			 = rset.getString("locn_code");
					 date_time			 = rset.getString("dt");
					 locn_desc           =  rset.getString("locn_desc");
					 p_encounter_id      = String.valueOf(rset.getLong("encounter_id"));
					 p_queue_no			 = rset.getString("queue_num");
					 p_patient_id        = rset.getString("patient_id");	
					 p_regn_time         = rset.getString("regn_date_time");
					 p_regn_time=DateUtils.convertDate(p_regn_time,"DMYHM","en",locale);
					 patient_details     = rset.getString("patient_details"); 
					pat_curr_locn_type_desc=rset.getString("pat_curr_locn_type_desc"); 
					 episode_id			 = rset.getString("episode_id"); 
					 visit_id			 = rset.getString("op_episode_visit_num"); 

					queue_date=rset.getString("queue_date")==null?"":rset.getString("queue_date"); 
					
					 p_status	= rset.getString("queue_status")==null?"":rset.getString("queue_status");

						if(p_status.equals("00"))
						{
						queue_status="";
						}
						else if(p_status.equals("01"))
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
						}else if(p_status.equals("02"))
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
						}else if(p_status.equals("03"))
						{
							queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
						}else if(p_status.equals("04"))
						{
							queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
						}else if(p_status.equals("05"))
						{
								queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
						}else if(p_status.equals("06"))
						{queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
						}else if(p_status.equals("07"))	
						{
						queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
						}
				    
					if(!locn_code.equals(prev_locn_code))	
						{
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_curr_locn_type_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block15Bytes, _wl_block15);
prev_locn_code=locn_code;
						}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_regn_time));
            _bw.write(_wl_block20Bytes, _wl_block20);

						if (p_queue_no==null) {
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block22Bytes, _wl_block22);

						} else {
							
							String link = ""; 
							
							if(p_status.equals("07") || p_status.equals("08") )
								link="";
							//else 
								//link="<a href='' name='ass_pract"+num+"' onClick=callAssPract("+p_encounter_id+","+p_patient_id+","+locn_type+","+locn_code+","+oth_res_class+","+date_time+","+p_status+");>";						
						
				
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_encounter_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(allow_chkout_with_bill_stmt_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(num));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_details));
            _bw.write(_wl_block28Bytes, _wl_block28);
 
						} 
				
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block30Bytes, _wl_block30);

						i++;
						num++;
						cnt++;

					}

					//if (cnt == 0) 						//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");

					if(!rset.next() && cnt!=0)
					{
						endOfRes = 0 ;
					
            _bw.write(_wl_block31Bytes, _wl_block31);
 }

					if(stmt!=null)
						stmt.close();
					if(rset!=null)
						rset.close();

				} catch(Exception e) {
					e.printStackTrace();
				}
    } catch(Exception e) {
		out.println("Exception in outer of try AssignPractForAutoClose File"+e);
		e.printStackTrace();
	} finally {
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	

            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(oper_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.RegnDateTime.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }
}
