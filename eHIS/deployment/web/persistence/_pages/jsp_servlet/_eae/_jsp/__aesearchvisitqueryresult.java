package jsp_servlet._eae._jsp;

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
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __aesearchvisitqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AESearchVisitQueryResult.jsp", 1724134686773L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\t\t\t\t    \n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></SCRIPT>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eAE/js/AESearchVisit.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body onMouseDown=\"CodeArrest()\"  onKeyDown = \'lockKey()\'>\n<!-- Tuesday, January 12, 2010 changed method (post to get) 18111 -->\n<form name = \"SearchVisitQueryResult\" action=\"../../eAE/jsp/AESearchVisitQueryResult.jsp\" method=\"get\"  >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' align=\'center\' >\n\t\t<tr width=\'100%\' >\n\t\t<td align=\'right\' class=\'white\'>\n\t\t\t<table align=\'right\'>\n                <tr>\n                   <td>\n                 ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t<A href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A> \n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t<A  id=\'nextvalue\' href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</A> \n\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t   \t</td>\n        </tr>\n    </table>\n</td>\n</tr>\n<tr>\n\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\' id=\'tb1\' align=\'center\'>\n<tr>\n    <th width=\'15%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n    <th width=\'15%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</th>\n    <th width=\'25%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n \t<th width=\'15%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<th width=\'15%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<!--     <a name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onClick=\"changeRowColor(this,";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =");\"  href=\"javascript:closew(\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\"> Thursday, June 17, 2010 Venkat s -->\n\n \t<a name=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =");\"  href=\'javascript:closew(\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\",\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\");\'>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<script>\n\t\tdocument.getElementById(\"nextvalue\").innerHTML=\" \";\n\t</script>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</tr>\n</table>\n</tr>\n</table>\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'where_criteria\' id=\'where_criteria\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" >\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n<input type=\'hidden\' name=\'pmode\' id=\'pmode\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'max_days_allow_update\' id=\'max_days_allow_update\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'max_days\' id=\'max_days\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'Include_Arrive_startCons_yn\' id=\'Include_Arrive_startCons_yn\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'five_level_triage_appl_yn\' id=\'five_level_triage_appl_yn\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

Connection conn=null;
PreparedStatement pstmt	= null ;
ResultSet rs=null;
String	encounter_id="";
String patient_id="";


String p_mode=request.getParameter("pmode");
String function_name=request.getParameter("function_name")==null?"":request.getParameter("function_name");
String Include_Arrive_startCons_yn=request.getParameter("Include_Arrive_startCons_yn")==null?"":request.getParameter("Include_Arrive_startCons_yn");
//Below line Added For AAKH-CRF-0010 [IN:038535] By Dharma on Mar 14th 2014
String five_level_triage_appl_yn =	(request.getParameter("five_level_triage_appl_yn")==null || request.getParameter("five_level_triage_appl_yn")=="")?"N":request.getParameter("five_level_triage_appl_yn");

String max_days1=request.getParameter("max_days_allow_update");
if ((max_days1 == null) ||  (max_days1.equals("null")) || (max_days1.equals("")))
   max_days1 = "0";
String oper_stn_id = request.getParameter("oper_stn_id");
if (oper_stn_id == null) oper_stn_id = "";
String facilityId = (String) session.getValue( "facility_id" ) ;
String  where_criteria1= request.getParameter("where_criteria");
int max_days=0;
max_days=Integer.parseInt(max_days1);
String loginuser 	= (String) session.getValue( "login_user" ) ;
String whereClause = request.getParameter("whereclause");
String from = request.getParameter( "from" ) ;
String to = request.getParameter( "to" ) ;
String queue_status_desc = "";
if (p_mode == null) p_mode = "";

int start=0;
int end=0;
int i=0;
int aname=1;
StringBuffer  where_criteria = new StringBuffer();
where_criteria.append(where_criteria1);
try
{
	conn=ConnectionManager.getConnection(request);

            _bw.write(_wl_block8Bytes, _wl_block8);

try
{
	
    if(whereClause!=null)
    {
    where_criteria.append(whereClause);
    }
    if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
    if (to == null){ end = 11; }   else {  end = Integer.parseInt( to ) ; }

   if(!(p_mode==null || p_mode.equals("")))
    {
        if (p_mode.equals("CANCELVISIT"))
        {
			/*		Modified for CRF - PMG20089-CRF-0541 (IN08081)
					Modified by Suresh M Date : 11/12/2009
			*/
				
			 if(Include_Arrive_startCons_yn.equals("Y")) 
				 where_criteria.append(" and a.queue_status <='04' ");
			else
				where_criteria.append(" and a.queue_status='01' ");

          where_criteria.append(" and trunc(sysdate)-trunc(a.queue_date) < "+max_days+"  and a.LOCN_CODE not in   (select  locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityId+"' and Oper_stn_id='"+oper_stn_id+"'  and appl_user_id = '"+loginuser+"' and cancel_visit_yn = 'N' )");
        }
        if(p_mode.equals("REVISEVISIT"))
        {         
          where_criteria.append(" and a.queue_status<='02'  and (sysdate - a.queue_date)< "+max_days+" and a.LOCN_CODE not in   (select  locn_code from am_restrn_for_oper_stn where facility_id = '"+facilityId+"' and Oper_stn_id='"+oper_stn_id+"'  and appl_user_id = '"+loginuser+"' and  revise_visit_yn = 'N')  ");
        }
    }
}
catch(Exception e)
{
	e.printStackTrace();
}

try{    
    StringBuffer strsql3 = new StringBuffer();
	strsql3.append("select  a.encounter_id,to_char(a.queue_date,'dd/mm/yyyy hh24:mi') visit_adm_date_time, a.queue_status, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') clinic_desc, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, a.VISIT_TYPE_CODE,'"+locale+"','2') visit_type_desc,AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID,a.LOCN_CODE, a.treatment_area_code,'"+locale+"' ,'2') treatment_area_desc,AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') practitioner_name, to_char(a.queue_date,'dd/mm/yyyy') queue_date, a.patient_id,decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name,SUBSTR (get_patient_line (a.patient_id,'"+locale+"'),1,INSTR (get_patient_line (a.patient_id,'"+locale+"'),'#')- 1) patient_details  from op_patient_queue a, mp_patient b  where a.patient_class = 'EM' and  a.facility_id = ?  and a.patient_id = b.patient_id ");
	strsql3.append(where_criteria.toString());
	strsql3.append("order by to_date(queue_date,'dd/mm/yyyy hh24:mi') desc");
	
    pstmt=conn.prepareStatement(strsql3.toString());
	pstmt.setString(1, facilityId);
	rs = pstmt.executeQuery();
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){

            _bw.write(_wl_block9Bytes, _wl_block9);

					if ( !(start <= 1)) {
				
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

					}
					if (endOfRes.equals("1")){
				
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

                }
				
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 if(Include_Arrive_startCons_yn.equals("Y"))  {
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
 }
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}

String rowclass = "" ;
String visit_adm_dtime="";
String locationDesc="";
String practDesc="";
String	queueStatus="";
String queue_date="";
String patient_name="";
String treatment_area_desc="";

        if ( i % 2 == 0 )
            rowclass = "QRYEVEN" ;
        else
            rowclass = "QRYODD" ;

		visit_adm_dtime=rs.getString("visit_adm_date_time");
		encounter_id=rs.getString("encounter_id");
		patient_id=rs.getString("patient_id");
		
		patient_name=rs.getString("patient_details");
		locationDesc=rs.getString("clinic_desc");
		practDesc=rs.getString("practitioner_name");			
		if(practDesc == null) practDesc="";
		
		treatment_area_desc=rs.getString("treatment_area_desc");
			if(treatment_area_desc == null) treatment_area_desc="";

		queueStatus=rs.getString("queue_status");
		if(queueStatus == null) queueStatus="&nbsp;";
		if(queueStatus.equals(""))
        queue_status_desc ="&nbsp;";
		if(queueStatus.equals("01"))			        queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
		if(queueStatus.equals("02"))                  queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
		if(queueStatus.equals("03"))						queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
		if(queueStatus.equals("04"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
		if(queueStatus.equals("07"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
		if(queueStatus.equals("09"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
		if(queueStatus.equals("99"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
		 
		queue_date=rs.getString("queue_date");
		patient_id=rs.getString("patient_id");

		int count =0;
		
	String sql1 ="select count(*) from AE_PAT_EMERGENCY_DETAIL where encounter_id = '"+encounter_id+"' and facility_id ='"+facilityId+"' ";
		
		
		 ResultSet rs1=null;
		 pstmt=conn.prepareStatement(sql1);
		 rs1=pstmt.executeQuery(sql1);
			while(rs1.next()) 
			{		 
				count = rs1.getInt(1);
			}

			if(pstmt != null) pstmt.close();
			if(rs1  != null) rs1.close();
			
    
       out.println("<tr style='background-color:'><td class='"+rowclass+"'>");
	   int columnCount = 0;
	   if(Include_Arrive_startCons_yn.equals("Y")) 
			columnCount = 6;
		else
			columnCount = 5;

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(columnCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(queueStatus));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(practDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(aname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(columnCount));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(queueStatus));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(java.net.URLEncoder.encode(practDesc)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(count));
            _bw.write(_wl_block30Bytes, _wl_block30);


	    out.println(encounter_id+"</a>");
		out.println("</td><td class='"+rowclass+"'>" );
        out.println(DateUtils.convertDate(visit_adm_dtime,"DMYHM","en",locale)+"</td><td class='"+rowclass+"'>" );
        out.println(patient_name+"</td><td class='"+rowclass+"'>" );       
		out.println(locationDesc+"</td><td class='"+rowclass+"'>" );

		/* Modified for CRF - PMG20089-CRF-0541 (IN08081)
			Modified by Suresh M Date : 11/12/2009
			New column Treatment Area is introduced in Cancel Attendence Function.
		*/
		if(Include_Arrive_startCons_yn.equals("Y")) {
			if(!treatment_area_desc.equals("")) {
				 out.println(treatment_area_desc+"</td><td class='"+rowclass+"'>" );
			} else {
				out.println("&nbsp;</td><td class='"+rowclass+"'>" );
			}
		}
        out.println(queue_status_desc+"</td></tr>" );
        aname++;
        i++;     
 		cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";
            _bw.write(_wl_block31Bytes, _wl_block31);
}
	
    if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
    if((strsql3 != null) && (strsql3.length() > 0))
	{
		strsql3.delete(0,strsql3.length());
	}

    }catch(Exception e)
    {
		e.printStackTrace();
    }
}catch(Exception e)
   {
		e.printStackTrace();
   }
   
   finally
   {
	   out.println("<script> parent.frames[1].document.forms[0].Search.disabled = false;</script>");
       if(conn!=null) ConnectionManager.returnConnection(conn,request);
    }


            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(function_name));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(where_criteria.toString()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(start));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(end));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(p_mode));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(max_days));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(max_days));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(Include_Arrive_startCons_yn));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(five_level_triage_appl_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.regndatetime.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }
}
