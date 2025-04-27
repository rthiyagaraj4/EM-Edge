package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import java.net.*;

public final class __bookingrefnoshowcancellookupresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/BookingRefNoShowCancelLookupResult.jsp", 1742367655796L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n    <head>\n        <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'></link>\n        <script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n        <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/IPQueryCommon.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n        <script>\n\n\nasync function callCanRev(valu)\n{\n\t\n\tvar dialogHeight= \"80vh\" ;\n\tvar dialogWidth = \"75vw\" ;\n\tvar dialogTop = \"80\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tvar features    = \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments   = \"\" ;\n\tretVal = await window.showModalDialog(\"../../eIP/jsp/AmendBookingMain.jsp?calling=AB&bookingRefNo=\"+escape(valu)+\"&call_function=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\",arguments,features);\n}\n</script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    </head>                         \n    <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n    <form name = \'BookingReferenceLookupResult_form\'>\n            ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!--<td colspan=\'7\' class=\'CAGROUPHEADING\' align=\'left\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td> modified on 12-03-2008 for CRF20056-0231-->\n\t\t\t\t\t\t\t<td colspan=\'11\' class=\'CAGROUPHEADING\' align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<script>\n\t\t\t\tif (parseInt(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')==0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'common\'));\n\t\t\t\t\tparent.frames[1].document.forms[0].search.disabled=false\n\t\t\t\t\tparent.frames[2].document.location.href = \'../../eCommon/html/blank.html\';\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'nextval\').innerHTML = \" \";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n    <input type=\'hidden\' name=\'param\' id=\'param\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n    </form>\n    </body>\n</html>\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );
 
	public String singleToDoubleQuotes(String strDB)
	{
		/*
		StringBuffer stringbuffer = new StringBuffer(strDB);
		String strModified="";
            int i = 0;
            
            for(int j = 0; strDB.indexOf('\'', i) != -1; j++)
            {
                i = strDB.indexOf('\'', i);
                stringbuffer.insert(i + j, "'");
                i++;
            }

            strModified=stringbuffer.toString();
            return strModified;
			*/
			if(strDB == null) strDB = "";
			return strDB.replaceAll("'","''");
	}


	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	request.setCharacterEncoding("UTF-8");
	String priority_ind_scr="";
	String param=request.getParameter("param");
	if(param == null) param="";
	String call_function = request.getParameter("call_function");
	//AB --> Active Booking
	//CB --> Cancel Booking
	//RCB--> Revise Cancel Booking
	if( call_function == null )
		call_function ="";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
	
	Statement stmt1 = null;//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	ResultSet rs1 =null;//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	String facility_id = (String)session.getValue("facility_id");
	String locale			= (String)session.getAttribute("LOCALE");
	StringBuffer where_criteria = new StringBuffer();
	StringBuffer sql = new StringBuffer();

	String class_val = "QRYEVENSMALL";
	String priority_ind="", temp="", priority_ind_desc="";
	String booking_stat = "";
	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from"  );
	String to = request.getParameter( "to" ) ;
	String soundex_type =checkForNull(request.getParameter("soundex"));
	String nursing_unit_code=checkForNull(request.getParameter("nursing_unit"));
	String speciality_code  =checkForNull(request.getParameter("Splcode"));
	String practitioner_id  =checkForNull(request.getParameter("practid"));
	String from_date    =checkForNull(request.getParameter("from_date"));
	if(!(from_date==null || from_date.equals("")))
		from_date = DateUtils.convertDate(from_date,"DMY",locale,"en");
	String to_date      =checkForNull(request.getParameter("to_date"));
	if(!(to_date==null || to_date.equals("")))
		to_date = DateUtils.convertDate(to_date,"DMY",locale,"en");

	String patient_id   =checkForNull(request.getParameter("patient_id"));
	String gender       =checkForNull(request.getParameter("gender"));
	String name_prefix  =request.getParameter("name_prefix");
	String name_suffix  =request.getParameter("name_suffix");
	String first_name   =checkForNull(request.getParameter("first_name"));
	String second_name  =checkForNull(request.getParameter("second_name"));
	String third_name   =checkForNull(request.getParameter("third_name"));
	String family_name  =checkForNull(request.getParameter("family_name"));
	String cancelReason =checkForNull(request.getParameter("cancelReason"));
	String loc_lang		=checkForNull(request.getParameter("loc_lang"));
	/*modification for SRR20056-CRF-0506*/
	String ip_booking_type 	 = checkForNull(request.getParameter("ip_booking_type"));
		
	String booking_type_desc = "";
	booking_stat = request.getParameter("booking_stat");

	if(name_prefix != null)
	name_prefix=singleToDoubleQuotes(name_prefix);

	if(name_suffix != null)
	name_suffix=singleToDoubleQuotes(name_suffix);              

	String patient_name ="";
	String nursing_unit_short_desc="";
	String nursing_unit_short_desc_display = "";
	String bed_no="";
	String patient_id1="";
	String reason_for_cancellation = "";
	String cancelled_by_id = "";
	int p_max_rec_cnt=0;
	StringBuffer sql2 = new StringBuffer();//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	int noshow_bkng_period 	 = 0;//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
	
	
	

            _bw.write(_wl_block7Bytes, _wl_block7);

            try{
                con =ConnectionManager.getConnection(request);
                //stmt = con.createStatement();
                //ipstmt = con.createStatement();
				//Added for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				  sql2.append("select noshow_bkng_period from ip_param where facility_id='"+facility_id+"'");
				  stmt1 = con.createStatement();
				  rs1=stmt1.executeQuery(sql2.toString());
				  
				  if(rs1!= null){
					if(rs1.next()){
					 noshow_bkng_period = rs1.getInt("noshow_bkng_period");//yn
				     }                   
			    }
				  if(rs1!=null) rs1.close();
				 if(stmt1!=null) stmt1.close();
				//end for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
                if(whereClause==null)
                {
                    //facility_id
                    where_criteria.append(" and a.facility_id='"+facility_id+"'");

					where_criteria.append(" and a.facility_id = d.facility_id(+) ");
					where_criteria.append(" and a.nursing_unit_code = d.nursing_unit_code(+) ");

					//nursing_unit_code
                    if(nursing_unit_code!=null && !nursing_unit_code.equals(""))
                        where_criteria.append(" and a.nursing_unit_code='"+nursing_unit_code+"' ");
					//speciality_code
                    if(speciality_code!=null && !speciality_code.equals(""))
                        where_criteria.append(" and a.specialty_code='"+speciality_code+"' ");

                    //practitioner_id
                    if(practitioner_id!=null && !practitioner_id.equals(""))
                        where_criteria.append(" and a.practitioner_id='"+practitioner_id+"' ");
                    //from_date	and to_date
					if((from_date!=null && !from_date.equals("")) && (to_date!=null && !to_date.equals("")))
					{
						where_criteria.append(" and trunc(a.preferred_date) between to_date('"+from_date+"' , 'dd/mm/rrrr') and to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					}
					else
					{
                    //from_date
                    if(from_date!=null && !from_date.equals(""))
                        where_criteria.append(" and trunc(a.preferred_date) >= to_date('"+from_date+"' , 'dd/mm/rrrr') ");

                    //to_date
                    if(to_date!=null && !to_date.equals(""))
                        where_criteria.append(" and trunc(a.preferred_date) <= to_date('"+to_date+"' , 'dd/mm/rrrr') ");
					}

                    //patient_id
                    if(patient_id!=null && !patient_id.equals(""))
                        where_criteria.append(" and a.patient_id like'"+patient_id+"%' ");

                    //gender
                    if(gender!=null && !gender.equals(""))
                        where_criteria.append(" and a.gender='"+gender+"' ");

                    //name_prefix
                    if(name_prefix!=null && !name_prefix.equals(""))
						// Wednesday, March 24, 2010 20211 Venkat S
						if(loc_lang.equals("en"))
                        where_criteria.append(" and a.name_prefix='"+name_prefix+"' ");
					else
                        where_criteria.append(" and a.NAME_PREFIX_LOC_LANG='"+name_prefix+"' ");

                    //name_suffix
                    if(name_suffix!=null && !name_suffix.equals(""))
					{
					// Wednesday, March 24, 2010 20211 Venkat S
						if(loc_lang.equals("en"))
                        where_criteria.append(" and a.name_suffix='"+name_suffix+"' ");
						else
						where_criteria.append(" and a.NAME_SUFFIX_LOC_LANG='"+name_suffix+"' ");

					}
					if(soundex_type.equals("E"))
					{
						//first_name
						if(first_name!=null && !first_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper(ethnic_soundex(a.first_name)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
							else
								where_criteria.append(" and upper(ethnic_soundex(a.FIRST_NAME_LOC_LANG)) like upper(ethnic_soundex('" +first_name +"')) || '%' ");
						}

						//second_name
						if(second_name!=null && !second_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper(ethnic_soundex(a.second_name)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
							else
								where_criteria.append(" and upper(ethnic_soundex(a.SECOND_NAME_LOC_LANG)) like upper(ethnic_soundex('" + second_name +"')) || '%' ");
						}

						//third_name
						if(third_name!=null && !third_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper(ethnic_soundex(a.third_name)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
							else
								where_criteria.append(" and upper(ethnic_soundex(a.THIRD_NAME_LOC_LANG)) like upper(ethnic_soundex('"+ third_name+"')) || '%' ");
						}

						//family_name
						if(family_name!=null && !family_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper(ethnic_soundex(a.family_name)) like upper(ethnic_soundex('" +family_name+"')) || '%' ");
							else
								where_criteria.append(" and upper(ethnic_soundex(a.FAMILY_NAME_LOC_LANG)) like upper(ethnic_soundex('" +family_name+"')) || '%' ");
						}
					}
					else
					{
						//first_name
						if(first_name!=null && !first_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper((a.first_name)) like upper(('" +first_name +"')) || '%' ");
							else
								where_criteria.append(" and upper((a.FIRST_NAME_LOC_LANG)) like upper(('" +first_name +"')) || '%' ");
						}

						//second_name
						if(second_name!=null && !second_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper((a.second_name)) like upper(('" + second_name +"')) || '%' ");
							else
								where_criteria.append(" and upper((a.SECOND_NAME_LOC_LANG)) like upper(('" + second_name +"')) || '%' ");
						}
						//third_name
						if(third_name!=null && !third_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper((a.third_name)) like upper(('"+ third_name+"')) || '%' ");
							else
								where_criteria.append(" and upper((a.THIRD_NAME_LOC_LANG)) like upper(('"+ third_name+"')) || '%' ");
						}
						//family_name
						if(family_name!=null && !family_name.equals(""))
						{
							if(loc_lang.equals("en"))
								where_criteria.append(" and upper(a.family_name) like upper('" +family_name+"') || '%' ");
							else
								where_criteria.append(" and upper(a.FAMILY_NAME_LOC_LANG) like upper('" +family_name+"') || '%' ");
						}
					}
				
					if(!( booking_stat.equals("3")) && cancelReason!="")
					{
						  where_criteria.append(" and (a.booking_status!='9' or a.cancel_reason_code = nvl('"+cancelReason+"', a.cancel_reason_code)) ");
					}
					/*modification for SRR20056-CRF-0506*/
					if(!ip_booking_type.equals(""))
						where_criteria.append( " and BOOKING_TYPE_CODE = '"+ip_booking_type+"' ");
                }
                else
                {
					if(where_criteria.length() > 0) where_criteria.delete(0,where_criteria.length());
                    where_criteria.append(whereClause);
                }

                int start = 0 ;
                int end = 0 ;
                int i=1;
				int nextOfRes = 1;

                if ( from == null )
                    start = 1 ;
                else
                    start = Integer.parseInt( from ) ;
                
                if ( to == null )
                    end = 14 ;
                else
                    end = Integer.parseInt( to ) ;
                //int maxRecord = 0;
				
				/*sql.append(" select a.bkg_lst_ref_no, a.preferred_date, to_char(a.preferred_date, 'dd/mm/rrrr hh:mi')  ");
				sql.append(" disp_preferred_date, a.patient_id,a.patient_name,");
				sql.append(" decode(a.gender,'M','Male','F','Female','U','Unknown') gender, d.short_desc nursing_unit_short_desc, a.bed_no, a.priority_ind, to_char(a.cancellation_date_time,'dd/mm/rrrr hh:mi') cancellation_date_time,decode(a.booking_status,'9','Cancelled','1','No Show') booking_status,decode(a.booking_status,'9',1,'1',2) order_booking_status ");
				sql.append(" From ip_booking_list a,ip_nursing_unit d where ");*/

				/*sql.append("select a.bkg_lst_ref_no, a.preferred_date, to_char(a.preferred_date, 'dd/mm/rrrr hh:mi') disp_preferred_date, a.patient_id, decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name, a.gender gender, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, a.bed_no, a.priority_ind, to_char(a.cancellation_date_time,'dd/mm/rrrr hh:mi') cancellation_date_time, a.booking_status booking_status, decode(a.booking_status,'9',1,'1',2) order_booking_status From IP_BOOKING_LIST a, IP_NURSING_UNIT d  where");*/
				//Maheshwaran K added "surgery_order" and "surgery_date" in the query for the CRF : RUT-CRF-0012 (23395	) as on 29/01/2013

				sql.append("select a.bkg_lst_ref_no, a.preferred_date, to_char(a.preferred_date, 'dd/mm/rrrr hh24:mi') disp_preferred_date,AM_GET_DESC.AM_CONTACT_REASON(decode(a.booking_status,'9',a.CANCEL_REASON_CODE),'"+locale+"',1)contact_reason, a.patient_id, decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name)) patient_name, a.gender gender, IP_GET_DESC.IP_NURSING_UNIT(A.facility_id, A.nursing_unit_code,'"+locale+"','2') nursing_unit_short_desc, a.bed_no, a.priority_ind, to_char(a.cancellation_date_time,'dd/mm/rrrr hh24:mi') cancellation_date_time, a.booking_status booking_status, decode(a.booking_status,'9',1,'1',2) order_booking_status,SM_GET_DESC.SM_APPL_USER(a.CANCELLED_BY_ID,'"+locale+"','1') CANCELLED_BY_ID,am_get_desc.am_complaint (a.chief_complaint,'"+locale+"', '1'  ) booking_reason ,am_get_desc.am_contact_reason (a.reason_for_revision_code,'"+locale+"', '1'  ) revision_reason ,ip_get_desc.ip_booking_type(a.booking_type_code,'"+locale+"','2') booking_type_desc ,a.oper_short_desc surgery_order , TO_CHAR (a.pref_surg_date, 'dd/mm/yyyy') surgery_date  From IP_BOOKING_LIST a, IP_NURSING_UNIT d where");
				//modified on 12-03-2008 to display "Reason for Cancellation" & "Cancelled by ID" for CRF20056-0231
				//
				//sql1.append(" select count(*) as total from IP_BOOKING_LIST a, IP_NURSING_UNIT d where ");     

                if ( booking_stat.equals("9") )
 			    {
					sql.append(" ( a.booking_status='9')  ");
					sql.append(where_criteria.toString()); 

					//sql1.append(" ( a.booking_status='9')  ");
					//sql1.append(where_criteria.toString()) ;       
				}
                else if (booking_stat.equals("3") )
			    {
                   // sql.append(" a.booking_status='1' and a.preferred_date <  sysdate " );
				   //modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
				     sql.append(" a.booking_status='1' and ((SYSDATE - a.preferred_date ) * 1440) > '"+noshow_bkng_period+"' " );
					 sql.append(where_criteria.toString());

                   // sql1.append(" a.booking_status='1' and trunc(a.preferred_date) < trunc(sysdate) ");
					//sql1.append(where_criteria.toString());
				}
				else
			    { 
					//sql.append(" ( ( a.booking_status ='1' and a.preferred_date < sysdate) or a.booking_status='9')  ");
					//modified  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
					sql.append(" ( ( a.booking_status ='1' and ((SYSDATE - a.preferred_date ) * 1440) > '"+noshow_bkng_period+"') or a.booking_status='9')  ");
					sql.append(where_criteria.toString());   
                 	
					//sql1.append(" ( ( a.booking_status ='1'  and trunc(a.preferred_date) < trunc(sysdate)) or a.booking_status='9')  ");
					//sql1.append(where_criteria.toString() );  
				}
                sql.append(" and a.facility_id='"+facility_id+"' order by  preferred_date");
				
				/*rs = stmt.executeQuery(sql1.toString());
                rs.next();
                maxRecord = rs.getInt(1);
                if(rs!=null)rs.close();
				rs      = stmt. executeQuery(sql.toString());*/

				/*stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs = stmt.executeQuery(sql.toString());

				if(rs!=null)
				{
					rs.last();
					maxRecord = rs.getRow();
					rs.beforeFirst();
				}*/
				
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql.toString());

				if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
				{
					rs.next() ;
				}
				
				while ( i<=end && rs.next() )
				{
					if(p_max_rec_cnt == 0 )
					{

				//if (( !(start <= 1) ) || ( !( (start+14) > maxRecord ) ))
				//{
					out.println("<p><table align='right'><tr><td>");
					if ( !(start <= 1) )
					   out.println("<A HREF='../jsp/BookingRefNoShowCancelLookupResult.jsp?booking_stat="+booking_stat+"&param="+param+"&from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

					if ( nextOfRes == 1 )
						out.println("<A id='nextval'   HREF='../jsp/BookingRefNoShowCancelLookupResult.jsp?booking_stat="+booking_stat+"&param="+param+"&from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(where_criteria.toString())+"&call_function="+URLEncoder.encode(call_function)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

					out.println("</td></tr></table></p>");
					out.println("<br><br>");
				//}
			out.println(" <table cellspacing=0 cellpadding=0 align='center' width='100%' border='1' cellpadding=0 cellspacing=0>");
			out.println("<tr>");
			out.println("<th>&nbsp;</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingRefNo.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PreferredDateTime.label","ip_labels")+"&nbsp;"+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelledDate/Time.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReasonforCancellation.label","common_labels")+"&nbsp;"+"</th>");//modified on 12-03-2008 to display "Reason for Cancellation" for CRF20056-0231
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Reasonforbooking.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.Reasonforrevision.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BookingType.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BookingStatus.label","common_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CancelledByID.label","ip_labels")+"&nbsp;"+"</th>");// modified on 12-03-2008 to display "Cancelled By ID" for CRF20056-0231
			//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 29/01/2013
			//Start
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryOrder.label","ip_labels")+"&nbsp;"+"</th>");
			out.println("<th nowrap>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SurgeryDate.label","ip_labels")+"&nbsp;"+"</th>");
			//End
			out.println("</tr>");

			}

			/*if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
			
			while ( rs!=null && rs.next() && i<=end )
			{*/
				reason_for_cancellation = rs.getString("contact_reason");//modified on 12-03-08 for CRF20056-0231
				if(reason_for_cancellation == null) reason_for_cancellation="&nbsp;";
				patient_id1=rs.getString("patient_id");
				if(patient_id1 == null) patient_id1="&nbsp;";

				patient_name=rs.getString("patient_name");
				if(patient_name == null) patient_name="&nbsp;";

				//gender=rs.getString("gender");
				cancelled_by_id  = rs.getString("CANCELLED_BY_ID");//modified on 12-03-08 for CRF20056-0231
				if(cancelled_by_id == null) cancelled_by_id="&nbsp;";
				gender = rs.getString("gender");

				if(gender.equalsIgnoreCase("M"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(gender.equalsIgnoreCase("F"))
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else
					gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
			
			

				nursing_unit_short_desc=rs.getString("cancellation_date_time");
				if(nursing_unit_short_desc== null)
				{
					nursing_unit_short_desc="&nbsp;";
					nursing_unit_short_desc_display = "&nbsp;";
				}
				else
					nursing_unit_short_desc_display = DateUtils.convertDate(nursing_unit_short_desc,"DMYHM","en",locale);

				bed_no = rs.getString("booking_status");
				if( bed_no == null) bed_no="&nbsp;";

				if(bed_no.equalsIgnoreCase("1"))
					bed_no = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.noshow.label","common_labels");
				else if(bed_no.equalsIgnoreCase("9"))
					bed_no = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");



				priority_ind = rs.getString("priority_ind");
				if( priority_ind == null) priority_ind="";

				if(priority_ind.equals("U")) 
					priority_ind_desc="Urgent";
				else if (priority_ind.equals("N")) 
					priority_ind_desc="Non-Urgent";
				
				booking_type_desc  = rs.getString("booking_type_desc");
				if(booking_type_desc == null) booking_type_desc = "&nbsp";

				if((priority_ind_scr.equals("")) && ((call_function.equals("AB")) || (call_function.equals("RCB")) ))
				{
					if ((!(priority_ind.equals(temp)))) 
					{	
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(priority_ind_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
	}
					temp = priority_ind;
				}
				
				if(class_val.equals("QRYEVENSMALL"))
					class_val = "QRYODDSMALL";
				else
					class_val = "QRYEVENSMALL";

				out.println("<tr>");
				out.println("<td class='"+class_val+"' nowrap><a href=\"javascript:callCanRev('"+rs.getString("bkg_lst_ref_no")+"')\">+</a></td>");

				out.println("<td class='"+class_val+"' nowrap>");
				if(param.equals("ADMIT"))
					out.println("<a href=\"javascript:closeWin_noShowCancel('"+rs.getString("bkg_lst_ref_no")+
				"')\">");           
				else if(! (call_function.equals("AB") || call_function.equals("CB") ) )
					out.println("<a href=\"javascript:showModal_noShowCancel('"+rs.getString("bkg_lst_ref_no")+"')\">");

				out.println(rs.getString("bkg_lst_ref_no")+"</a></td>");
				String disp_preferred_date_display = rs.getString("disp_preferred_date");
				if(disp_preferred_date_display == null)
					disp_preferred_date_display = "";
				else
					disp_preferred_date_display = DateUtils.convertDate(disp_preferred_date_display,"DMYHM","en",locale);
				
				String booking_reason = rs.getString("booking_reason");
				String revision_reason = rs.getString("revision_reason");

				if(booking_reason == null)
					booking_reason = "&nbsp;";

				if(revision_reason == null)
					revision_reason = "&nbsp;";				
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 29/01/2013
				//Start
				String surgery_order = checkForNull(rs.getString("surgery_order"),"&nbsp");
				String surgery_date = checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("surgery_date"),"DMY","en",locale),"&nbsp");	
				//End
				out.println("<td nowrap class='"+class_val+"'>"+disp_preferred_date_display+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+nursing_unit_short_desc_display+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+reason_for_cancellation+"</td>");//modified on 12-03-08 to display "reason for cancellation" for CRF20056-0231
				out.println("<td nowrap class='"+class_val+"'>"+booking_reason+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+revision_reason+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+patient_id1+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+patient_name+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+gender+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+booking_type_desc+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+bed_no+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+cancelled_by_id+"</td>");//modified on 12-03-08 to display "Cancelled By ID" for CRF20056-0231
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 29/01/2013
				//Start
				out.println("<td nowrap class='"+class_val+"'>"+surgery_order+"</td>");
				out.println("<td nowrap class='"+class_val+"'>"+surgery_date+"</td>");
				//End
				out.println("</tr>");
				i++;
				p_max_rec_cnt++;
			}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(p_max_rec_cnt));
            _bw.write(_wl_block12Bytes, _wl_block12);

			out.println("</table>");
			if( !rs.next() && p_max_rec_cnt!=0 )
			{
				nextOfRes=0;
			
            _bw.write(_wl_block13Bytes, _wl_block13);

			}
	out.println("<br><center></center>");
    }catch(Exception e) 
	{
		out.println(e.toString());
		e.printStackTrace();
	}
    finally
    {
		try
		{
			if (rs != null) rs.close();
			//if( iprs != null) iprs.close();
			if (stmt != null) stmt.close();
			//if (ipstmt != null) ipstmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception in tryCatch : "+ e.toString());
		}
        ConnectionManager.returnConnection(con,request);
		out.print("<script>if(parent.frames[1].document.forms[0]!= null)");	out.print("parent.frames[1].document.forms[0].search.disabled=false</script>");
    }	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(param));
            _bw.write(_wl_block15Bytes, _wl_block15);
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
