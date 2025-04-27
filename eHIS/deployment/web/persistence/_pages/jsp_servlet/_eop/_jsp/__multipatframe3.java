package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public final class __multipatframe3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/MultiPatframe3.jsp", 1709119444304L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eop/jsp/Color_Set.jsp", 1709117135176L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eop/jsp/MpatQMethods.jsp", 1709117138894L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="<!DOCTYPE html>\n\n\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<html>\n<Head>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eOP/js/ManageSPatQueue.js\"></script>\n <!-- <script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script> -->\n <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</Head>\n<body onMouseDown=\"CodeArrest();\" onKeyDown = \'lockKey();\'>\n\n<script>\n    self.setInterval(\'self.location.reload()\',";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =")\n\t/*below line was commented by venkatesh.s  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n\t/*function func1(){}\n\tfunction callMouseOver(obj)\n{\n\tcurrClass = obj.className ;\n\tobj.className = \'OASUSPENDED\';\n}\n\nfunction callOnMouseOut(obj)\n{\n\tobj.className = currClass; \n}\n\nfunction hideToolTip()\n{\n\tdocument.getElementById(\"tooltiplayer\").style.visibility = \'hidden\';\n}*/\n\n\n\n\t\t\n\n\n</script>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    </body>\n </html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
 String getFrameHeaderData(String p_locn_id, String p_pract_id,Connection con,String fid,boolean multi,String roomnum)
  {
	StringBuffer headers=new StringBuffer();
	PreparedStatement stmt =null ; 
	ResultSet rset =null;
	StringBuffer sql=new StringBuffer();		
	try
	{

		sql.append("SELECT SUM(DECODE(APPT_OR_WALK_IN_IND,'A',1,0)) Appt, SUM(CASE WHEN QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) INR, SUM(CASE WHEN VITAL_SIGNS_DATE_TIME IS NOT NULL THEN 1 ELSE 0 END) VITAL, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NOT NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) SEEN, SUM(CASE WHEN CONS_SRVC_START_DATE_TIME IS NULL AND QUEUE_STATUS IN ('01','02') THEN 1 ELSE 0 END ) WAIT FROM OP_CURRENT_PATIENT ");
		sql.append("WHERE locn_code =nvl('"+p_locn_id+"',locn_code) and practitioner_id = nvl('"+p_pract_id+"','*ALL')  ");
		sql.append("and facility_id='"+fid+"'  and trunc(queue_date) = trunc(sysdate)"); 
 	  
		stmt=con.prepareStatement(sql.toString());		
		rset=stmt.executeQuery();
		
		headers.setLength(0);

		while(rset.next())
		{
			headers.append((rset.getString("Appt")==null?"0":rset.getString("Appt"))+";");
			headers.append((rset.getString("INR")==null?"0":rset.getString("INR"))+";");
			headers.append((rset.getString("Vital")==null?"0":rset.getString("Vital"))+";");
			if(multi)
				headers.append((rset.getString("Seen")==null?"0":rset.getString("Seen"))+";");

			headers.append((rset.getString("Wait")==null?"0":rset.getString("Wait"))+";~");
		}

		sql.setLength(0);
	}
	catch(Exception e)
	{
		//headers=e.toString()+"&nbsp;&nbsp;&nbsp;"+sql.toString();	
	}
	finally
	{
		try
		{
		if(rset!=null)	rset.close();
		if(stmt!=null) 	stmt.close();
		
		}
		catch(Exception e){}
	}
	
	return(headers.toString());
  }

 String getFrameDetailData(String p_locn_id, String p_pract_id,String starttime, Connection con,String fid,boolean count, String order,String roomnum,String localeName,String login_user,String p_operator_station,PageContext pageContext)
     {
        
    StringBuffer headers=new StringBuffer();
	PreparedStatement stmt   =null ;
	ResultSet rset   =null;
	StringBuffer sql=new StringBuffer();
	String queue_status = "";
	String p_status = "";

	if(roomnum.equals(""))
		roomnum = "X";
	
   	try
	{
		
		
		sql.append("SELECT to_char(appt_time,'hh24:mi') Appt_time, queue_num, decode('"+localeName+"', 'en', patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name, arrival_status, no_show,queue_status queue_status , appt_confirm_yn, case_type ,waiting_time, visit_type,op_get_desc.OP_VISIT_TYPE(facility_id,visit_adm_type,'"+localeName+"',2) visit_type_desc,encounter_id , patient_id, visit_adm_type, pat_curr_locn_code locn_code, pat_curr_locn_type, practitioner_id, care_locn_type_ind, sex, date_of_birth, room_num, appt_id, TO_CHAR(queue_date,'dd/mm/yyyy') queue_date, TO_CHAR(arrive_date_time,'dd/mm/yyyy hh24:mi') arrive_date_time, op_get_desc.op_clinic(facility_id,locn_code,'"+localeName+"',1) current_location, visit_adm_type_ind, appt_case_yn, vital_signs_date_time, other_res_class, queue_id, queue_status  p_status, queue_status queue_status1, to_char(decode(Queue_status,'01',check_in_date_time,'02',arrive_date_time,'03',vital_signs_date_time,'04',cons_srvc_start_date_time,'05',null,'06',subs_arrive_date_time),'dd/mm/yyyy hh24:mi') dt, other_resource_id other_res_code, case_type appt_walk_ind, service_code, referral_id, contact_reason_code, am_get_desc.am_contact_reason(contact_reason_code,'"+localeName+"',1) contact_reason_desc, a.resource_class res_class,a.qms_call_count,episode_id,op_episode_visit_num  ");
		sql.append("FROM  OP_CURRENT_PATIENT_VW  A ");
	
		sql.append("WHERE locn_code=? and nvl(practitioner_id,'X')=nvl(?,'X')  AND EXISTS (SELECT locn_code  FROM am_os_user_locn_access_vw   WHERE facility_id = a.facility_id AND locn_code = a.locn_code AND LOCN_TYPE=a.LOCN_TYPE and oper_stn_id = '"+p_operator_station+"'  AND appl_user_id = '"+login_user+"')");
			
		sql.append(" and queue_status < decode('N','Y','08','07') and facility_id=?  ");
		sql.append(" and level_of_care_ind='A' and trunc(queue_date) = trunc(sysdate) ");
		sql.append(" and to_date(to_char(queue_date,'HH24:MI'),'HH24:MI') >= to_date(?,'HH24:MI') and nvl(room_num,'X') = '"+roomnum+"' ");
		
		if(order.equals("yes"))
			sql.append( " ORDER BY  visit_type ,case_type, appt_time,queue_num ");
		else
		sql.append(" ORDER BY  case_type, appt_time,queue_num ");

		stmt=con.prepareStatement(sql.toString());
		stmt.setString(1,p_locn_id);		
		stmt.setString(2,p_pract_id);		
		stmt.setString(3,fid);		
		stmt.setString(4,starttime);	 
		rset=stmt.executeQuery();
		
		headers.setLength(0);

		while(rset.next())
		{
			if(count)
			{
			headers.append(rset.getString(1));
				break;
			}		
			else
			{
				headers.append(rset.getString("Appt_time")+";" );
				headers.append(rset.getString("queue_num")+";" );
				headers.append(rset.getString("arrival_status")+";" );
				queue_status = rset.getString("queue_status");
						
				if(queue_status.equals("01"))
				{				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.in.label","common_labels");
				}
				else if(queue_status.equals("02"))	
				{
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.NS.label","op_labels");
				}
				else if(queue_status.equals("03"))	
				{	queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VS.label","op_labels");
				}
				else if(queue_status.equals("04"))																
				{					queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.PR.label","op_labels");
				}
				else if(queue_status.equals("05"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.TR.label","op_labels");
				}
				else if(queue_status.equals("06"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.WT.label","op_labels");
				}
				else if(queue_status.equals("07"))	
				{	
				queue_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.XT.label","op_labels");
				}

				headers.append(queue_status+";" );

				headers.append(rset.getString("patient_name")+";" );
				headers.append(rset.getString("waiting_time")+";");
				
				headers.append(rset.getString("no_show")+";");
				headers.append(rset.getString("appt_confirm_yn")+";"); 
				headers.append(rset.getString("case_type")+";");
			
				headers.append(rset.getString("visit_type")+";");
				
				headers.append(rset.getString("visit_type_desc")+";");				
				headers.append(String.valueOf(rset.getLong("encounter_id"))+";");
				headers.append(rset.getString("patient_id")+";");
				headers.append(rset.getString("visit_adm_type")+";");
				headers.append(rset.getString("locn_code")+";");
				headers.append(rset.getString("pat_curr_locn_type")+";");
				headers.append(rset.getString("practitioner_id")+";");
				headers.append(rset.getString("care_locn_type_ind")+";");
				headers.append(rset.getString("sex")+";");
				headers.append(rset.getString("date_of_birth")+";");
				headers.append(rset.getString("room_num")+";");
				headers.append(rset.getString("appt_id")+";");
				headers.append(rset.getString("queue_date")+";");
				headers.append(rset.getString("arrive_date_time")+";");
				headers.append(rset.getString("current_location")+";");
				headers.append(rset.getString("visit_adm_type_ind")+";");
				headers.append(rset.getString("appt_case_yn")+";");
				headers.append(rset.getString("vital_signs_date_time")+";");
				headers.append(rset.getString("other_res_class")+";");
				headers.append(rset.getString("other_res_code")+";");
				headers.append(rset.getString("appt_walk_ind")+";");
				headers.append(rset.getString("queue_id")+";");
				headers.append(rset.getString("queue_status1")+";");
				headers.append(rset.getString("dt")+";");
				p_status = rset.getString("p_status");
				
				if(p_status.equals("01"))
				{				 p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CheckedIn.label","op_labels");
				}
				else if(p_status.equals("02"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ArrivedAtNursStn.label","op_labels");
				}
				else if(p_status.equals("03"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.InitChkUpORVtlSgnRec.label","op_labels");
				}
				else if(p_status.equals("04"))		
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
				}
				else if(p_status.equals("05"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.UndergoingTrtORInvst.label","op_labels");
				}
				else if(p_status.equals("06"))	
				{				p_status=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.RetFrmInvest.label","op_labels");
				}					

				headers.append(rset.getString("service_code")+";");
				headers.append(rset.getString("referral_id")+";");
				headers.append(rset.getString("contact_reason_code")+";");
				headers.append(rset.getString("contact_reason_desc")+";");
				headers.append(rset.getString("res_class")+";" );
				headers.append(rset.getString("qms_call_count")+";" );
				headers.append(rset.getString("episode_id")+";" );
				headers.append(rset.getString("op_episode_visit_num")+";" );
				headers.append(p_status+"~");
				
			}
		}
		sql.setLength(0);
	}
	catch(Exception e){}
	
	finally
	{
		try
		{
		if(rset!=null)	rset.close();
		if(stmt!=null) 	stmt.close();
		
		}
		catch(Exception e){}
	}	
	return(headers.toString());
     }



	public String color_set(String p_case_type, String p_no_show, String p_appt_confirm_yn, String p_arrival_status, String p_tvisit_type)
	{
		String clr ="white";
		if (p_case_type.equals("A"))
			{
				if (p_arrival_status.equals("O"))
					clr = "green";
				else if (p_arrival_status.equals("L"))
							clr = "brown";
				else if (p_arrival_status.equals("E"))
						clr="RED";
				else if (p_no_show.equals("Y"))
					clr = "yellow";
				else if (p_appt_confirm_yn.equals("Y"))
					clr = "blue";
				else if (p_appt_confirm_yn.equals("N"))
					clr = "white";
			}
		else 
			{
				/*if (p_patient_class.equals("OP"))
					clr = "magenta";
				else*/
				if (p_tvisit_type.equals("E"))
					clr = "PATQRED";
			}
			
		return clr;
	}

 public String createMultiTable(Connection con, String fid, String starttime, int num,ArrayList loccode, ArrayList locdes,ArrayList locntype, ArrayList pname, ArrayList roomno,ArrayList room_desc,ArrayList pid,String order,String locale,String userid,String oprstn,PageContext pageContext,String call_from,ArrayList pkgpatyn, ArrayList pkgencyn,String action_on_pending_bill,String bl_install_yn)
   {
	StringBuffer sb=new StringBuffer();
    sb.append("<html><head></head>");
    sb.append("<body onKeyDown='lockKey();'><form name='PatQ' id='PatQ'>");
    sb.append("<table border='1' width='100%'  cellspacing='3' cellpadding='0' valign='top' align='left'>");
    sb.append("<tr>");

	    String practitionername="";
        String roomnumber="";
		String roomnum="";	String locndesc1=""; String locn="";String pi="";
		String locn_type="";
		String pkgpatyn1="";
		String pkgencyn1="";
		//String episode_id1="";
		//String op_episode_visit_num1="";
		String rowVal="";
		String tokvalue="";
		String headerVals="";String pract="";String details="";String prval="";
		String Appt_time="";
        String queue_num="";
        String arrival_status="";
        String queue_status="";
        String patient_name="";
		String no_show  ="";
        String appt_confirm_yn="";
        String case_type="";
        String visit_type="";
        String visit_type_desc="";
        String encounter_id="";
		String color="";String lin="";String rcolor="";
		String patient_id="";
		String visit_adm_type="";
		String locn_code="";
		
		String pat_curr_locn_type="";
		String practitioner_id="";
		String care_locn_type_ind="";
		String sex="";
		String date_of_birth="";
		String room_num="";
		String appt_id="";
		String queue_date="";
		String arrive_date_time="";
		String current_location="";
		String visit_adm_type_ind="";
		String appt_case_yn="";
		String vital_signs_date_time="";
		String other_res_class="";
		String other_res_code="";
		String queue_id="";
		String p_status = "";
		String queue_status1= "";
		String dt = "";
		String appt_walk_ind = "";

		String referral_id = "";
		String contact_reason_code = "";
		String contact_reason_desc = "";
		String service_code = "";
		String resource_class = "";
		String qms_call_count = "";
		String op_episode_visit_num = "";
		String episode_id = "";
		int qms_call_cnt=0;
		StringTokenizer rows = null;
		StringTokenizer headers = null;
		StringTokenizer detval= null;
		
       //Added below line for this CRF Bru-HIMS-CRF-133
	    boolean isPatEncMovement=false;	 
		 boolean isVIPimgpatfrontappl=false; //Added by Mujafar against ML-MMOH-CRF-1070
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String Sydate = dateFormat.format(cal.getTime());	
	    System.err.println("MultiPatframe3.jsp  Sydate===>"+Sydate);
	     
	//End Bru-HIMS-CRF-133
	
 try{
   /*Below line added for this CRF Bru-HIMS-CRF-133*/	
isPatEncMovement=eOP.QMSInterface.isSiteSpecific(con,"OP","PATENC_MOVEMENT");
isVIPimgpatfrontappl = eCommon.Common.CommonBean.isSiteSpecific(con, "OA","VIP_IMG_PAT_NAME_FRONT_APPL");//Added by Mujafar against ML-MMOH-CRF-1070	  
 
 //int k=1;
         /* Below variable by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
           int id=0;
		for(int j=0;j<num;j++){
        sb.append("<td   valign=top width='50%' align='left' class='CADEFAULT'>");//class='Border'
        sb.append("<table border='0' width='75%'  cellspacing='0' cellpadding='0' >");
        sb.append("<tr>");

        if((String)pname.get(j)==null)
            practitionername="/"+"*ALL";
		else
            practitionername="/"+(String)pname.get(j);

        if((String)roomno.get(j) != null && (String)room_desc.get(j) != null)
        	roomnumber="/"+(String)roomno.get(j)+" "+(String)room_desc.get(j);
		else
			roomnumber = "";
		String callNexticon="";
		 locn=(String)loccode.get(j);
		 String qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(locn,fid,con);
		 boolean isQMSapplicable=eOP.QMSInterface.isSiteSpecific(con,"OP","EXT_QUEUE_NO");
		if(qms_interfaced_yn.equals("Y")){//Condition modified for the SCF - ML-BRu-SCF-1074
			callNexticon="&nbsp;<img src='../../eCommon/images/callNext.png' alt='Call Next Patient' onclick=callNextPatient('"+(String)roomno.get(j)+"');></td>";
		}

		locndesc1=(String)locdes.get(j);
		if(locndesc1 == null) locndesc1="";
        sb.append("<td width='50%' class='CADEFAULT' nowrap><font size='1'><font size='1' color='black'><b>"+locndesc1+practitionername+roomnumber+callNexticon+"</td>");
        sb.append("</tr>");
        sb.append("<tr>");
        sb.append("<td   border='0'  cellspacing='0' cellpadding='0' width='100%' colspan=3 class='CADEFAULT'>");
        sb.append("<table border='1'  width='100%'  valign='top' cellspacing='0' cellpadding='0' >");
        sb.append("<tr>"); 
		sb.append("<th width='' ><font size='1' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Appointment.label","common_labels")+"</th>");
        sb.append("<th width='' ><font size='1' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.in.label","common_labels")+"</th>");
        sb.append("<th width='' ><font size='1' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Vital.label","op_labels")+"</th>");
        sb.append("<th width='' ><font size='1' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.Seen.label","op_labels")+"</th>");
        sb.append("</tr>");		
       
        pi=(String)pid.get(j);
		roomnum=(String)roomno.get(j);
		locn_type=(String)locntype.get(j);
		if(roomnum == null) roomnum="";
		//locndesc1=locndesc1;
		headerVals=getFrameHeaderData(locn,pi,con,fid,true,roomnum);
		rows=new StringTokenizer(headerVals,"~");
		//try{
            while(rows.hasMoreTokens())
            {
                rowVal=rows.nextToken();
                headers=new StringTokenizer(rowVal,";");
				int cntTokens = headers.countTokens();
		        sb.append("<tr>");
				for (int i=0;i<cntTokens-1;i++)
                {
					tokvalue=headers.nextToken();
                    sb.append("<td class='white'><font size='1'>"+tokvalue+"</td>");
                }
               sb.append("</tr>");
            }
  		   
        sb.append("</table>");
        sb.append("</div>");
        sb.append("<div align='left'>");
        sb.append("<table border=1 width='100%'  cellspacing='0' cellpadding='0' >");
        sb.append("<th ><font size='1'  ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.At.label","common_labels")+"</th>");
        sb.append("<th ><font size='1'  ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.QN.label","op_labels")+"</th>");
		if(isQMSapplicable){
        sb.append("<th ><font size='1'  ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.CallRecall.label","op_labels")+"</th>");
		}
        sb.append("<th ><font size='1'  ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.S.label","common_labels")+"</th>");
        sb.append("<th ><font size='1'  ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels")+"</th>");
        sb.append("<th ><font size='1'  ><b>Q</th>");
		locn=(String)loccode.get(j);
        pract=(String)pid.get(j);
		pkgpatyn1 = (String)pkgpatyn.get(j); 
		pkgencyn1 = (String)pkgencyn.get(j); 
		//episode_id1 = (String)episode_id.get(j);
		//op_episode_visit_num1 = (String)op_episode_visit_num.get(j);
		
        boolean first=true;
        details=getFrameDetailData(locn,pract,starttime,con,fid,false,order,roomnum,locale,userid,oprstn,pageContext);
		
        rows=new StringTokenizer(details,"~");
		
		rcolor="QRYODD";
        while(rows.hasMoreTokens())
            {
                if(rcolor.equals("Query_Odd"))
                    rcolor="QRYEVEN";
                else
                    rcolor="Query_Odd";
               rowVal=rows.nextToken();
				detval=new StringTokenizer(rowVal,";");
               sb.append("<tr onMouseOver='hideToolTip();'>");
              
               while(detval.hasMoreTokens())
                {
                    Appt_time=detval.nextToken();
                    queue_num=detval.nextToken();
                    arrival_status=detval.nextToken();
                    queue_status=detval.nextToken();
                    patient_name=detval.nextToken();
                    detval.nextToken();
					no_show  =detval.nextToken();
                    appt_confirm_yn=detval.nextToken();
                    case_type=detval.nextToken();
                    visit_type=detval.nextToken();
                    visit_type_desc=detval.nextToken();
                    encounter_id=detval.nextToken();

					 patient_id=detval.nextToken();
					 visit_adm_type=detval.nextToken();
					 locn_code=detval.nextToken();
					 pat_curr_locn_type=detval.nextToken();
					 practitioner_id=detval.nextToken();
					 care_locn_type_ind=detval.nextToken();
					 sex=detval.nextToken();
					 date_of_birth=detval.nextToken();
					 room_num=detval.nextToken();
					 appt_id=detval.nextToken();
					 queue_date=detval.nextToken();
					 arrive_date_time=detval.nextToken();
					 current_location=detval.nextToken();
					 visit_adm_type_ind=detval.nextToken();
					 appt_case_yn=detval.nextToken();
					 vital_signs_date_time=detval.nextToken();
					 other_res_class=detval.nextToken();
					 other_res_code=detval.nextToken();
					 appt_walk_ind =detval.nextToken();
					 queue_id=detval.nextToken();
					 queue_status1=detval.nextToken();
					 dt=detval.nextToken();

					 service_code = detval.nextToken();
					 referral_id = detval.nextToken(); 
                      				 
					 contact_reason_code = detval.nextToken();
					 contact_reason_desc = detval.nextToken();
					 resource_class = detval.nextToken();
					 //qms_call_count = detval.nextToken().equals("null")?"0":detval.nextToken();
					 qms_call_count = detval.nextToken();
					 episode_id = detval.nextToken();
					 op_episode_visit_num = detval.nextToken();
					 p_status=detval.nextToken();
                   // detval.nextToken();
					color=color_set(case_type, no_show,appt_confirm_yn, arrival_status, visit_type);
				   if(color.equals("PATQRED"))
                        rcolor="PATQRED";
                   if(order.equals("yes"))
                    {
                       	if(first)
                            sb.append("<tr onMouseOver='hideToolTip();'><td colspan=6 align='left'  class='CAGROUPHEADING'><font size='1' ><b>"+visit_type_desc+"</td></tr>");
                        else
                        {
                            if(!visit_type_desc.equals(prval))
                                sb.append("<tr onMouseOver='hideToolTip();'><td colspan=6 align='left'  class='CAGROUPHEADING'><font size='1' ><b>"+visit_type_desc+"</td></tr>");
                        }
                    }
					
                    if(Appt_time.equals("null"))
                        Appt_time="&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp";
                    sb.append("<td width='20%' class='"+rcolor+"'><font size='1'>"+Appt_time+"</td>");
                    if(queue_num.equals("null"))
                        queue_num="&nbsp";
                    sb.append("<td width='15%' class='"+rcolor+"'><font size='1'>"+ queue_num +"</td>");
					
					if(qms_call_count.equals("null")) qms_call_count="";
					String callRecall="Call.png";
					 String mouseOver="Call Patient";
					 if(!qms_call_count.equals("")){
					qms_call_cnt=Integer.parseInt(qms_call_count);
					 if(qms_call_cnt >=1){
						callRecall="Recall.png";
						mouseOver="Recall Patient";
						qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
						qms_call_count=String.valueOf(qms_call_cnt);
					 }else{
						 qms_call_count="";
					 }
					 			 
					}
					if(isQMSapplicable){
						if(qms_interfaced_yn.equals("Y") && !queue_status1.equals("01")){
						sb.append("<td width='5%'><img src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onClick=callPatient('"+patient_id+"','"+encounter_id+"','"+queue_num+"');>&nbsp;<FONT size=1>"+qms_call_count+"</td>");
					}
					else{
						sb.append("<td width='5%'><font size='1'>&nbsp;</td>");
					}
					}
                   if(color.equals("white"))
                            color=rcolor;
                    sb.append("<td  width='5%' class='"+color+"'> &nbsp;</td>");
                   if(patient_name.equals("null"))
                        patient_name="&nbsp";

				    if(patient_id.equals("null"))
                        patient_id="";
				   
				   if(appt_id.equals("null"))
                        appt_id="";
                   if(vital_signs_date_time.equals("null"))
                        vital_signs_date_time="";
				   if(other_res_class.equals("null"))
                        other_res_class="";
					if(queue_id.equals("null"))
                        queue_id="";
					if(arrive_date_time.equals("null"))
                        arrive_date_time="";
					if(other_res_code.equals("null"))
                        other_res_code="";
					if(resource_class.equals("null"))
                        resource_class="";
						
                     /*Below line added for this incident [60902]*/
					 if(referral_id.equals("null")){
					     referral_id="";
					 }	 
					 
						if(!appt_id.equals("")){  				
							appt_walk_ind="A";
						}else if(!referral_id.equals("")){ 
							 appt_walk_ind="R";
						}					  
                     //End incident [60902]*					 
				
					
                    //lin="<a href='javascript:func1()' 				onclick=LoadMenus('"+encounter_id+"','','','"+locn+"','','"+pi+"','','','','','','"+roomnum+"','','','','','','"+locndesc1+"','','','','','','MY')>";
				//onClick=displayToolTip('"+encounter_id+"','"+patient_id+"','"+visit_adm_type+"','"+locn+"','"+pat_curr_locn_type+"','"+pi+"','"+URLEncoder.encode(queue_status1)+"','OP','"+care_locn_type_ind+"','"+sex+"','"+URLEncoder.encode(date_of_birth)+"','"+roomnum+"','"+URLEncoder.encode(p_status)+"','','"+appt_id+"','"+URLEncoder.encode(queue_date)+"','"+URLEncoder.encode(arrive_date_time)+"','"+URLEncoder.encode(current_location)+"','"+URLEncoder.encode(locndesc1)+"',''"+appt_case_yn+"','VITAL_SIGNS_DATE_TIME','ARRIVE_DATE_TIME','N','other_res_class','other_res_code','','','"+queue_id+"')>";
					/*Below line modified for this incident [38281]*/	
                	/* Below modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/				
                    /*Below line modified for this CRF Bru-HIMS-CRF-133*/					
				id++;	
	           lin="<td id='patname"+id+"' class='"+rcolor+"' onClick=\"displayToolTip('"+encounter_id+"','"+patient_id+"','"+visit_adm_type+"','"+locn+"','"+pat_curr_locn_type+"','"+pi+"','"+URLEncoder.encode(queue_status1,"UTF-8")+"','OP','"+care_locn_type_ind+"','"+sex+"','"+URLEncoder.encode(date_of_birth,"UTF-8")+"','"+roomnum+"','"+URLEncoder.encode(p_status,"UTF-8")+"','"+URLEncoder.encode(dt)+"','"+appt_id+"','"+URLEncoder.encode(queue_date,"UTF-8")+"','"+URLEncoder.encode(arrive_date_time,"UTF-8")+"','"+URLEncoder.encode(current_location,"UTF-8")+"','"+URLEncoder.encode(locndesc1,"UTF-8")+"','"+URLEncoder.encode(visit_adm_type_ind,"UTF-8")+"','"+appt_case_yn+"','"+URLEncoder.encode(vital_signs_date_time,"UTF-8")+"','"+URLEncoder.encode(arrive_date_time,"UTF-8")+"','N','"+URLEncoder.encode(other_res_class,"UTF-8")+"','"+URLEncoder.encode(other_res_code,"UTF-8")+"','"+URLEncoder.encode(queue_num,"UTF-8")+"','"+appt_walk_ind+"','"+queue_id+"','M','"+pkgpatyn1+"','"+pkgencyn1+"',this, 'imgArrow"+id+"','"+id+"','link"+id+"','"+episode_id+"','"+op_episode_visit_num+"','','','"+isPatEncMovement+"','"+Sydate+"');\" onMouseOver =\" hideToolTip(this,'imgArrow"+id+"','"+id+"','link"+id+"');\"><a href='javascript:callDummy()' name='link"+id+"'><FONT size=1>";

 
					
                    if( queue_status.equals("null") || queue_status.equals("00") )
					{
						if(call_from.equals("CA"))
						{
							if(patient_id.equals("null") || patient_id.equals(""))
							{ 
						   lin="<td><FONT size=1>";

							}
							else 
							{		 
								/* Below modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/ 
							lin="<td id='patname"+id+"' class='"+rcolor+"'><a href='javascript:func1()' name='link"+id+"'onClick=call_visit_regn('"+patient_id+"','"+appt_id+"','"+referral_id+"','"+locn+"','"+locn_type+"','"+Appt_time+"','"+visit_adm_type+"','"+practitioner_id+"','"+contact_reason_code+"','"+URLEncoder.encode(contact_reason_desc,"UTF-8")+"','"+service_code+"','"+resource_class+"')><FONT size=1>";	
	
							}
						}
						else {
						lin="<td><FONT size=1>";
                          }				
					}
                      /* Below modified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/ 
					  
			if(isVIPimgpatfrontappl) // added by mujafar for ML-MMOH-CRF-1070
			{	
			 String img_temp="";
			String vip_pat_yn = eOA.OACommonBean.getVIPPatient(con,patient_id,fid);
			if(vip_pat_yn.equals("TRUE"))
			img_temp="<img border=0 src='../../eCommon/images/PI_VIP.gif'></img>";	
			else
			img_temp = "";
			
			lin = lin+img_temp;

			}
					  
					  
					  
					   
					    if( queue_status.equals("null") || queue_status.equals("00") )
						{
					    sb.append(lin+patient_name);
						}else
						{
						 sb.append(lin+patient_name+"<FONT></a><img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+id+"'></td>");
						}

                    if( queue_status.equals("null") || queue_status.equals("00") )
                        queue_status="&nbsp";
                    sb.append("<td width= '10%' class='"+rcolor+"'><font size='1'>"+ queue_status+"</td>");
                    prval=visit_type_desc;
                    first=false;
                }
                sb.append("</tr>");
            }

        sb.append("</table>");
        sb.append("</div>");
        sb.append("</td>");
        sb.append("</tr>");
        sb.append("</table>");
        sb.append("</td>");
     /*  if(k%2==0)
		 sb.append("</tr>");
	   k++;*/
	   }
	   /*below line was modified by venkatesh.s against Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
        sb.append("</table><div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:10%; visibility:hidden;' bgcolor='blue'><table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'><tr><td width='100%' id='t'></td></tr></table></div><input type='hidden' name='call_from' id='call_from' value='"+call_from+"'><input type='hidden' name='modalWindowOpen' id='modalWindowOpen' value='N'>	<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='"+fid+"'><input type='hidden' name='action_on_pending_bill' id='action_on_pending_bill' id='action_on_pending_bill' value='"+action_on_pending_bill+"'><input type='hidden' name='bl_install_yn' id='bl_install_yn' id='bl_install_yn' value='"+bl_install_yn+"'></form></body></html>");
		
		// sb.append(" <div name='tooltiplayer' id='tooltiplayer' style='position:absolute;  width:5%; visibility:hidden;' bgcolor='blue'><table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'><tr><td width='100%' id='t'></td></tr></table></div>");
		
		loccode.clear();
		locdes.clear();
		pname.clear();
		roomno.clear();
		pid.clear();
		//episode_id.clear();
		//op_episode_visit_num.clear();
       
   
   }catch(Exception e)
		   {
				
				e.printStackTrace();
		   }
   return(sb.toString());
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 

		request.setCharacterEncoding("UTF-8");
		String rfresh_param = request.getParameter("refresh");
		String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
		String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"":request.getParameter("bl_package_enabled_yn");
		String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]
		String bl_install_yn = (String)session.getValue("bl_operational");// Added For MMS-QH-CRF-0126 [IN:041880]



            _bw.write(_wl_block8Bytes, _wl_block8);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rfresh_param));
            _bw.write(_wl_block11Bytes, _wl_block11);
            _bw.write(_wl_block12Bytes, _wl_block12);

    StringBuffer sql=new StringBuffer();
    String oprstn=request.getParameter("oprstn");
	String userid           = (String) session.getValue("login_user");
     String locale=(String)session.getAttribute("LOCALE");
    String order=request.getParameter("orderby");
	String starttime = request.getParameter("starttime");
	
	
	if(starttime == null || starttime.equals("null") || starttime.equals("")) starttime = "00:00";
    
	String speciality=request.getParameter("Qspeciality");
	if(speciality == null ) speciality = "";

	
    PreparedStatement stmt=null;
    ResultSet rset=null;
    Connection con   = null;
        try
        {
            con=ConnectionManager.getConnection(request);
            String fid    = (String) session.getValue( "facility_id" ) ;
    
            ArrayList loccode=new ArrayList();
            ArrayList locdes=new ArrayList();
            ArrayList pname=new ArrayList();
            ArrayList roomno=new ArrayList();
			/* Below line was added by venkatesh.s on 23-Nov-2012 against 36432*/
			ArrayList room_desc=new ArrayList();
            ArrayList pid=new ArrayList();
            ArrayList locntype=new ArrayList();
            ArrayList pkgpatyn=new ArrayList();
            ArrayList pkgencyn=new ArrayList();
            ArrayList episode_id=new ArrayList();// Added for MMS-QH-CRF-0126 [IN:041880] 
            ArrayList op_episode_visit_num=new ArrayList();// Added for MMS-QH-CRF-0126 [IN:041880] 
			
            int count=0;
				// Commented the OP_CURRENT_PATIENT and added the OP_CURRENT_PATIENT_VW for IN023817 on 14.09.2010 by Suresh M
             //   sql.append("practitioner_id,room_num from OP_CURRENT_PATIENT Where  ");
 
		 /* Below query  was modified by venkatesh.s on 23-Nov-2012 against 36432 to get room short description */
                sql.append("select distinct op_get_desc.op_clinic(facility_id,locn_code,'"+locale+"',1) locn_desc,locn_code,locn_type,am_get_desc.am_practitioner(practitioner_id,'"+locale+"',1) practitioner_name, practitioner_id,room_num ,am_get_desc.am_facility_room ('"+fid+"',room_num,'"+locale+"', 2)room_desc,( case when '"+bl_package_enabled_yn+"' = 'Y' then (select blpackage.get_pkg_pat_yn(facility_id, patient_id, episode_id, op_episode_visit_num) pat_pakyn from dual) end ) pkg_pat_yn, ( case when '"+bl_package_enabled_yn+"' = 'Y' then (select blpackage.is_pkg_open_for_encounter(facility_id, patient_id, 'O', episode_id, op_episode_visit_num) openenc_pakyn from dual) end ) pkg_enc_yn from  OP_CURRENT_PATIENT_VW Where facility_id=? and   queue_status < decode('N','Y','08','07') and trunc(queue_date) = trunc(sysdate)  and nvl(speciality_code,'X')=nvl('"+speciality+"',nvl(speciality_code,'X')) and to_date(to_char(queue_date,'HH24:MI'),'HH24:MI') >= to_date(?,'HH24:MI') and  (locn_type,locn_code ) IN  (SELECT locn_type,locn_code FROM am_locn_for_oper_stn WHERE facility_id=? AND oper_stn_id=?) and (locn_type, locn_code) not in (select  locn_type,locn_code from am_restrn_for_oper_stn where facility_id = ? and OPER_STN_ID=? and appl_user_id = ? and manage_queue_yn = 'N')  order by locn_desc,room_num,nvl(practitioner_name,'!')");
 
        
            stmt=con.prepareStatement(sql.toString());	
			
			stmt.setString(1,fid);
			stmt.setString(2,starttime);
            stmt.setString(3,fid);
            stmt.setString(4,oprstn);
            stmt.setString(5,fid);
            stmt.setString(6,oprstn);
            stmt.setString(7,userid);
		    rset=stmt.executeQuery();

			if(rset != null)
			{
			while(rset.next())
            {
                loccode.add(rset.getString("locn_code"));
                locdes.add(rset.getString("locn_desc"));
                pname.add(rset.getString("practitioner_name"));
                roomno.add(rset.getString("room_num"));
				room_desc.add(rset.getString("room_desc"));
                pid.add(rset.getString("practitioner_id"));
                locntype.add(rset.getString("locn_type"));
                pkgpatyn.add(rset.getString("pkg_pat_yn")==null?"N":rset.getString("pkg_pat_yn"));
                pkgencyn.add(rset.getString("pkg_enc_yn")==null?"N":rset.getString("pkg_enc_yn"));
            //    episode_id.add(rset.getString("episode_id")==null?"":rset.getString("episode_id"));// Added for MMS-QH-CRF-0126 [IN:041880] 
           //     op_episode_visit_num.add(rset.getString("op_episode_visit_num")==null?"":rset.getString("op_episode_visit_num"));// Added for MMS-QH-CRF-0126 [IN:041880] 
              	count++;
            }
			}
			if(count == 0)	
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON')); </script>");
			}
			else
			{  	//out.print(createMultiTable(con,fid,starttime,count,loccode,locdes,locntype,pname,roomno,room_desc,pid,order,locale,userid,oprstn,pageContext,call_from,pkgpatyn,pkgencyn,action_on_pending_bill,bl_install_yn,episode_id,op_episode_visit_num) );
			out.print(createMultiTable(con,fid,starttime,count,loccode,locdes,locntype,pname,roomno,room_desc,pid,order,locale,userid,oprstn,pageContext,call_from,pkgpatyn,pkgencyn,action_on_pending_bill,bl_install_yn) );
			}

			if(rset != null) rset.close();
			if(stmt != null) stmt.close();
			
			loccode.clear();
            locdes.clear();
            pname.clear();
            roomno.clear();
            pid.clear();

        }
        catch(Exception e){
			out.print(e);
			out.print(sql);
			e.printStackTrace();
			}
        finally
        {
            try{
            if(stmt!=null)  stmt.close();
            if(rset!=null)  rset.close();
            }          catch(Exception e){
				e.printStackTrace();
			}

			if(con!=null) ConnectionManager.returnConnection(con,request);
             
        }
    
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
