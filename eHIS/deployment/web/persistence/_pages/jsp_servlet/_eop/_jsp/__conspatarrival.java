package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __conspatarrival extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ConsPatArrival.jsp", 1739347935842L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\n    Developed by    :   R.Nanda Kumar \n    Created on  :   18/01/2001\n    Module      :   Out Patient Management\n    Function    :   Consultation - Patient Arrival. This file is called from the \n                CallPatArrival which is called from the SingleManagePatientQueryResult \n                page.\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\n\t<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->\n\t<script  language=\'javascript\' src=\"../../eXH/js/ExternalApplication.js\"></script>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script> <!-- //added by Himanshu Saxena asked by Interface team against ML-BRU-CRF-0628.10 on 22-05-2023 End-->\n\t<!-- //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 End-->\n\t\n\t<script language=\'javascript\' src=\"../../eOP/js/ConsPatArrival.js\"></script>\n\t<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\tfunction allowNumOnly(event)\n\t\t{\n\t\t\tvar strCheck = \'0123456789\';\n\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t\tif (strCheck.indexOf(key) == -1)\n\t\t\t\treturn false;  \n\t\t\telse\n\t\t\t\treturn true ;\t\t\t\n\t\t}\n\t\tfunction chkValue(obj)\n\t\t{\n\t\t\tif(obj.value!=\"\")\n\t\t\t{\n\t\t\t\tif(obj.value<1)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"INVALID_POSITIVE_NUMBER\",\"COMMON\"));\n\t\t\t\t\tobj.select();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n\n</head>\n<!--  //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started   onload=QueueNumberLoad() function Added -->\n<body   onKeyDown = \'lockKey();\' onKeypress=\'return(applyclick(event));\'>\n<!--  //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t\n\t<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->\n\t\n\t\n\t\n\t\n\t<!--Modified by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121-->\n\t<td  id=\'queue_div\' style=\'visibility:hidden;display:none\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td id=\'queue_no_div\' style=\'visibility:hidden;display:none\' class=\'fields\' width=\'25%\'><input type=\'text\' name=\'queue_no\' id=\'queue_no\' value = \'\' size=\'15\' onKeyPress=\'return Check_SpecCharsValidationOP(event);\' onPaste=\'return checkspecialandalphanumericOP(event);\'  onblur = \'chkValue(this);\' maxlength=\'15\' >\n\t\n\t<!--<td id=\'queue_no_div\' style=\'visibility:hidden;display:none\' class=\'fields\' width=\'25%\'><input type=\'text\' name=\'queue_no\' id=\'queue_no\' value = \'\' size=\'10\' onKeyPress=\'return allowNumOnly(event);\' onblur = \'chkValue(this);\' maxlength=\'8\' >-->\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="<img id=\"mand_gif\" src=\'../../eCommon/images/mandatory.gif\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t</tr>\n\t<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 End-->\n\t\n\t\n\t<!--if condition modified by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Started\n\t//if(assign_q_num_by.equals(\"M\") && qms_interfaced_yn.equals(\"N\") -->\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<script>\t\n\t\tdocument.getElementById(\"queue_div\").style.display=\"\";\n\t\tdocument.getElementById(\"queue_no_div\").style.display=\"\";\n\t\tdocument.getElementById(\"queue_div\").style.visibility=\"visible\";\n\t\tdocument.getElementById(\"queue_no_div\").style.visibility=\"visible\";\n\t\tdocument.forms[0].queue_no.disabled=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =";\t\t\n\t\tdocument.forms[0].queue_no.value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\t\n\t\t</script>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n    <tr><td colspan=\'4\' class=\'button\' align=\"right\"><input type=\'button\'  class=\'button\' name=\'ok\' id=\'ok\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onClick=\"submit_ok()\"><input type=\'button\' align=\'left\' class=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onClick=\'exitContact()\'>\n     </td>\n      </tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\n \n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale=(String)session.getAttribute("LOCALE");
	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
		java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
		String workStationId	= (String) p.getProperty("client_ip_address") == null ? "" : (String) p.getProperty("client_ip_address");
		String login_user			= (String) session.getValue("login_user");
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->
	
	String p_encounter_id   = request.getParameter("Encounter_Id");
    String p_queue_status   = request.getParameter("Queue_Status");
	/*Below line added for this CRF Bru-HIMS-CRF-133*/
	String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
	String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
	String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
    String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");	
	//End this CRF Bru-HIMS-CRF-133
	
	String revert_to_check_in = request.getParameter("revert_to_check_in");
	if(revert_to_check_in == null) revert_to_check_in="N";

	String PreviousDay = request.getParameter("PreviousDay");
	
	if(PreviousDay.equals("0") || PreviousDay.equals("0"))  PreviousDay = "+0";
	
	String p_patient_id=request.getParameter("patient_id");
	String p_clinic_code=request.getParameter("locn_code");
	String p_locn_type=request.getParameter("locn_type");
	String p_pract_id=request.getParameter("pract_id");
	String roomAlloted=request.getParameter("room_num");
	String appt_id=request.getParameter("appt_id");
    String p_status=request.getParameter("p_status");
	String dt=request.getParameter("dt");
	String queue_date=request.getParameter("p_queue_date");
	String arrival_date=request.getParameter("arrival_date");
	String cur_short_desc=request.getParameter("curr_locn");
	cur_short_desc=java.net.URLDecoder.decode(cur_short_desc,"UTF-8"); 
	
	if(cur_short_desc == null) cur_short_desc="";
	String cur_care_locn_type=request.getParameter("curr_locn_type_desc");
	if(cur_care_locn_type == null) cur_care_locn_type="";
	String VISIT_ADM_TYPE_IND=request.getParameter("VISIT_ADM_TYPE_IND");
	String appt_case_yn=request.getParameter("appt_case_yn");

	String other_res_class=request.getParameter("other_res_class");
	if(other_res_class == null) other_res_class="";
	String other_res_code=request.getParameter("other_res_code");
	if(other_res_code == null) other_res_code="";
	String queue_num=request.getParameter("queue_num");
	if(queue_num == null) queue_num="0";
	String appt_walk_ind=request.getParameter("appt_walk_ind");
	if(appt_walk_ind == null) appt_walk_ind="";
	String queue_id=request.getParameter("queue_id");
	if(queue_id == null) queue_id=""; 

	String assign_q_num_by = request.getParameter("assign_q_num_by")==null?"":request.getParameter("assign_q_num_by");
	
	String dt_display=DateUtils.convertDate(dt,"DMYHM","en",locale);
	String arr_dt_display=DateUtils.convertDate(arrival_date,"DMYHM","en",locale);
    String qms_interfaced_yn="N";   

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

   // PreparedStatement pstmt       = null;
   // ResultSet rs        	  = null;
    
    PreparedStatement pstmt4	  = null;
    ResultSet rs4		  = null;
  
    String fac_id       = (String) session.getValue( "facility_id" ) ;
   	String roomno="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	Connection conn = null;
    //int total_rec=0;
	String ronly="";
	String selval="";
	String oth_res_desc="";
	
	String  selval1="disabled";
	String  ronly1="readOnly";
	String mand_queue_no="N";//Added by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
	
	String Queue_No_Mandate="N";//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
	Boolean isMandQueueNoAppl;
	 boolean isQMSapplicable=false;
	
	try{

	conn=ConnectionManager.getConnection(request);
    isMandQueueNoAppl = CommonBean.isSiteSpecific(conn,"OP","MANDATORY_QUEUE_NO");//Added by Shanmukh on 29th-JUNE-2018 for ML-MMOH-CRF-1121
     isQMSapplicable=CommonBean.isSiteSpecific(conn,"OP","EXT_QUEUE_NO"); //added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->

    		
    try{

		/*
		pstmt4=conn.prepareStatement("select ASSIGN_QUEUE_NUM_BY from op_param where OPERATING_FACILITY_ID = '"+fac_id+"' ");

		rs4 = pstmt4.executeQuery();

		if(rs4!=null && rs4.next())
		{
			assign_q_num_by = rs4.getString("ASSIGN_QUEUE_NUM_BY");
		}

		 if(rs4 != null) rs4.close();
		 if(pstmt4 != null) pstmt4.close();
		 */
		 
		pstmt4=conn.prepareStatement("select QUEUE_NO_MNDT_YN from op_param where OPERATING_FACILITY_ID = '"+fac_id+"' ");
		rs4 = pstmt4.executeQuery();
		if(rs4!=null && rs4.next())
		{
			mand_queue_no = rs4.getString("QUEUE_NO_MNDT_YN");
		}
		 if(rs4 != null) rs4.close();
		 if(pstmt4 != null) pstmt4.close();
		  if((isMandQueueNoAppl) && (mand_queue_no.equals("Y"))){
			 mand_queue_no="Y";
		 }else{ 
		  mand_queue_no="N";
		 }
			
		  //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 Started-->	
		  if(isQMSapplicable){
		  Queue_No_Mandate="N";
		  String MandateField="";
		  pstmt4=conn.prepareStatement("select Queue_No_Mandate from op_clinic where FACILITY_ID = '"+fac_id+"' and CLINIC_CODE='"+p_clinic_code+"' and CLINIC_TYPE='C' ");
			rs4 = pstmt4.executeQuery();
			if(rs4!=null && rs4.next())
			{
				Queue_No_Mandate = rs4.getString("Queue_No_Mandate");
			}
			
			if(isQMSapplicable && Queue_No_Mandate.equals("Y")){
				 mand_queue_no="N";
			}
			else {
			 mand_queue_no="Y";	
			}
			 if(rs4 != null) rs4.close();
			 if(pstmt4 != null) pstmt4.close();
			//<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 04-05-2023 End-->
		  }
		  
	qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(p_clinic_code,fac_id,conn);
	
	out.println("<form name='ConsPatArrivalForm' id='ConsPatArrivalForm' method='post' action='../../servlet/eOP.ConsPatArrivalServlet'>"); 

	out.println("<table width='95%' align='center' border='0'");
	out.println("<tr><td class='BORDER' align='center'>");
	out.println("<table cellpadding='6' cellspacing='0' BORDER='0'>");
	out.println("<tr><td class='label'  width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CurrentStatus.label","op_labels")+"</td>");    
	
    
	if (dt==null)
    {
        out.println("<td class='QUERYDATA' width='30%' nowrap>"+p_status+"</td>");
    }
    else
    {
        out.println("<td class='QUERYDATA' width='30%' nowrap>"+p_status+" / " +dt_display+ "</td>");
    } 
	out.println("<td class='label' colspan='2'></td></tr>");
    
	
	out.println("<tr><td  class='label'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.currentlocation.label","common_labels")+"&nbsp;&nbsp;</td>");
    
    String cur_loc_desc = "&nbsp;" ;
   	cur_loc_desc = cur_short_desc +"/" + cur_care_locn_type  ;
    out.println("<td class='QUERYDATA'>"+cur_loc_desc+"</td><td class='label' colspan='2'></td></tr>"); 
	
	/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	out.println("<td class='label'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+"</td>");
	/*CRF end SS-CRF-0010 [IN034516]*/
    
    if(revert_to_check_in .equals("Y"))
    {
		selval="disabled";
		ronly="readOnly";
    	out.println("<td class='FIELDS' ><select name='roomnumsel' id='roomnumsel' disabled><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;</option>");
    }
    else
    {
		selval="";
		ronly="";
    	out.println("<td class='FIELDS'><select name='roomnumsel' id='roomnumsel' onChange='selectroomno()'><option value=''>&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;</option>");
    }
        
	/* Below line query modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	 pstmt4=conn.prepareStatement("select a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc from op_pract_for_clinic a where facility_id='"+fac_id+"' and clinic_code='"+p_clinic_code+"' and eff_status='E' and resource_class='R' order by practitioner_id");
	 /*CRF end SS-CRF-0010 [IN034516]*/
	 
     rs4=pstmt4.executeQuery();
     String room_no="";
	 roomno=roomAlloted;
     
			
	   boolean flagval=false;
	   while(rs4.next())
       {flagval=true;
		 room_no=rs4.getString("room_no");
		 /* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
		 room_desc=rs4.getString("room_desc");
		 /*CRF end SS-CRF-0010 [IN034516]*/
		 if(room_no.equals(roomAlloted))
		{
		/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			out.println("<option value='"+room_no+"'selected>"+room_no+" "+room_desc+"</option>");
			/*CRF end SS-CRF-0010 [IN034516]*/
		}
	 else
		{   /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
			out.println("<option value='"+room_no+"'>"+room_no+" "+room_desc+"</option>");
			/*CRF end SS-CRF-0010 [IN034516]*/
		}
	   }
	
		if(flagval==true)	
		{
		out.println("</select>&nbsp;<img id='roomno_vis' src='../../eCommon/images/mandatory.gif' ></td>"); //Modified by Suji Keerthi for SKR-SCF-1504
		}
		else
		{
			 out.println("</select></td>");
			 roomno="NoRoom";
		}
      
	 if(rs4 != null) rs4.close();
	 if(pstmt4 != null) pstmt4.close();	
	
	if(!(other_res_code.equals("")))
	{	
		pstmt4 = conn.prepareStatement("SELECT DECODE(RESOURCE_CLASS, 'P', AM_GET_DESC.AM_PRACTITIONER(practitioner_id,'"+locale+"','2'),	               'R', AM_GET_DESC.AM_FACILITY_ROOM(facility_id, practitioner_id,'"+locale+"','2'), 'E', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2'),  'O', AM_GET_DESC.AM_RESOURCE(facility_id,practitioner_id,'"+locale+"','2')) description FROM op_pract_for_clinic WHERE facility_id='"+fac_id+"' AND resource_class='"+other_res_class+"' AND clinic_code='"+p_clinic_code+"' AND practitioner_id='"+other_res_code+"'  AND eff_status='E'");	
		rs4 = pstmt4.executeQuery();
		if(rs4 != null)
		{
			if(rs4.next())
			{
				oth_res_desc=rs4.getString(1);
			}
		}
		if(rs4 != null) rs4.close();
		if(pstmt4 != null) pstmt4.close();
		if(oth_res_desc == null) oth_res_desc="";
	}
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if(("N").equals(mand_queue_no)){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

	if(assign_q_num_by.equals("M") && qms_interfaced_yn.equals("N"))
	{
		String q_value = "";
		String q_disable = "";

		if(revert_to_check_in .equals("Y"))
		{
			q_value = queue_num;
			q_disable = "true";
		}
		else
		{
			q_value = "";
			q_disable = "false";
		}		
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(q_disable));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(q_value));
            _bw.write(_wl_block14Bytes, _wl_block14);

	}
	else if(assign_q_num_by.equals("S")) 
	{
		out.println("<td class='label' colspan='2'></td></tr>");
	}
   
	out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.otherrestype.label","op_labels")+"&nbsp;&nbsp;</td>");
	out.println("<td class='fields'><select name='other_res_type' id='other_res_type' onChange='clearResourceVal(this);' "+selval+" ><option value=''>&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;</option>");
	if(other_res_class.equals("E"))
	{
	 out.println("<option value='"+other_res_class+"' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}else if(other_res_class.equals("O"))
	{
	 out.println("<option value='"+other_res_class+"'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}else
	{
 	 out.println("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+" </option><option value='O'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</option>");
	}
 out.println("</select></td><td class=label width='20%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.OtherResource.label","op_labels")+"</td><td class='fields' width='25%'>	<input type='text' name='other_res_txt' id='other_res_txt' maxlength='15' size='16' value='"+oth_res_desc+"'  "+ronly1+" ><input type='button' class='button' name='other_res_butt' id='other_res_butt' value='?'  onClick='otherResourceLookUp(this,other_res_txt);' "+selval1+">	</td></tr>"); 

	out.println("<input type='hidden' name='other_res_code' id='other_res_code' value='"+other_res_code+"'>");


	}catch(Exception e) { 
		e.printStackTrace();
		}


    out.println("<tr><td class='label' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ArrivalDateTime.label","common_labels")+"&nbsp;&nbsp;</td>");
    out.println("<td class='QUERYDATA'>"+arr_dt_display+"</td><td class='label' colspan='2'></td></tr>");
	

	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);



//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Started-->
String alert_duration="6000";
pstmt4=conn.prepareStatement("SELECT COMM_PROCESS_IDLE_TIME FROM XH_INTERACTIVE_CONNECT_PARAM WHERE PLUGIN_TYPE = 'BQS'");
rs4 = pstmt4.executeQuery();
if(rs4!=null && rs4.next())
    {
        alert_duration = rs4.getString("COMM_PROCESS_IDLE_TIME");
        alert_duration=alert_duration+"000";

    }

//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 30-05-2023 Ends-->
	out.println("</table></td></tr></table>");	   
    
	out.print("<input type='hidden' name='revert_to_check_in' id='revert_to_check_in' value='"+revert_to_check_in+"'>");
	out.print("<input type='hidden' name='queuestatus' id='queuestatus' value='"+p_queue_status+"'>");
    out.print("<input type='hidden' name='patientid' id='patientid' value='"+p_patient_id+"'>");
    out.print("<input type='hidden' name='locntype' id='locntype' value='"+p_locn_type+"'>");
    out.print("<input type='hidden' name='clinic_code' id='clinic_code' value='"+p_clinic_code+"'>");
    out.print("<input type='hidden' name='practid' id='practid' value='"+p_pract_id+"'>");
    out.print("<input type='hidden' name='encntrid' id='encntrid' value='"+p_encounter_id+"'>");
    out.print("<input type='hidden' name='queue_date' id='queue_date' value='"+queue_date+"'>");
    
	 out.print("<input type='hidden' name='room_num' id='room_num' value='"+roomno+"'>");
	 out.println("<input type='hidden' name='prev_room' id='prev_room' value='"+roomno+"'>");
	 out.print("<input type='hidden' name='room_change' id='room_change' value=''>"); 	 
	 
	 out.print("<input type='hidden' name='appt_id' id='appt_id' value='"+appt_id+"'>");
	 out.print("<input type='hidden' name='appt_case_yn' id='appt_case_yn' value='"+appt_case_yn+"'>");
	 out.print("<input type='hidden' name='VISIT_ADM_TYPE_IND' id='VISIT_ADM_TYPE_IND' value='"+VISIT_ADM_TYPE_IND+"'>");
	  out.print("<input type='hidden' name='res_code' id='res_code' value='"+other_res_code+"'>");
	  out.print("<input type='hidden' name='fac_id' id='fac_id' value='"+fac_id+"'>");
	 out.print("<input type='hidden' name='queue_num' id='queue_num' value='"+queue_num+"'>");
	 out.print("<input type='hidden' name='appt_walk_in' id='appt_walk_in' value='"+appt_walk_ind+"'>");
	 out.print("<input type='hidden' name='queue_id' id='queue_id' value='"+queue_id+"'>");
	 out.print("<input type='hidden' name='locale' id='locale' value='"+locale+"'>");
	 out.println("<input type='hidden' name='assign_q_num_by' id='assign_q_num_by' value='"+assign_q_num_by+"'>");	 	
	 out.println("<input type='hidden' name='qms_interfaced_yn' id='qms_interfaced_yn' value='"+qms_interfaced_yn+"'>");	 	 	 
	 out.println("<input type='hidden' name='qms_exception' id='qms_exception' value='N'>");	
  
    out.println("<input type='hidden' name='curr_locntype' id='curr_locntype' value='"+curr_locntype+"'>");
    out.println("<input type='hidden' name='curr_locncode' id='curr_locncode' value='"+curr_locncode+"'>");
    out.println("<input type='hidden' name='isPatientEncMovement' id='isPatientEncMovement' value='"+isPatientEncMovement+"'>");	
	out.println("<input type='hidden' name='Sydate' id='Sydate' value='"+Sydate+"'>");	
	//Added by Shanmukh on 2nd-JULY-2018 for ML-MMOH-CRF-1121
	out.println("<input type='hidden' name='isMandQueueNoAppl' id='isMandQueueNoAppl' value='"+isMandQueueNoAppl+"'>");	
	out.println("<input type='hidden' name='mand_queue_no' id='mand_queue_no' value='"+mand_queue_no+"'>");
	
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Started-->
	out.println("<input type='hidden' name='isQMSapplicable' id='isQMSapplicable' value='"+isQMSapplicable+"'>");
	out.println("<input type='hidden' name='Queue_No_Mandate' id='Queue_No_Mandate' value='"+Queue_No_Mandate+"'>");
	out.println("<input type='hidden' name='alert_duration' id='alert_duration' value='"+alert_duration+"'>");
	out.println("<input type='hidden' name='work_station_id' id='work_station_id' value='"+workStationId+"'>");
	out.println("<input type='hidden' name='login_user' id='login_user' value='"+login_user+"'>");
	//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 08-05-2023 Ended-->
	

            _bw.write(_wl_block18Bytes, _wl_block18);

out.print("</form>");

            _bw.write(_wl_block19Bytes, _wl_block19);



}catch(Exception e) {
	e.printStackTrace();
	}
    finally{
    		if(conn!=null) ConnectionManager.returnConnection(conn,request);                
            }

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
