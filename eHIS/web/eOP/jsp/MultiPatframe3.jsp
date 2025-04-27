<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,java.net.*,webbeans.eCommon.*,javax.servlet.jsp.JspWriter,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="MpatQMethods.jsp" %>
<%@ include file="Color_Set.jsp" %>

<% 

		request.setCharacterEncoding("UTF-8");
		String rfresh_param = request.getParameter("refresh");
		String call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
		String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"":request.getParameter("bl_package_enabled_yn");
		String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]
		String bl_install_yn = (String)session.getValue("bl_operational");// Added For MMS-QH-CRF-0126 [IN:041880]


%>

<html>
<Head>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eOP/js/ManageSPatQueue.js"></script>
 <!-- <script src="../../eOP/js/menu.js" language="JavaScript1.2"></script> -->
 <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</Head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>

<script>
    self.setInterval('self.location.reload()',<%=rfresh_param%>)
	/*below line was commented by venkatesh.s  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/
	/*function func1(){}
	function callMouseOver(obj)
{
	currClass = obj.className ;
	obj.className = 'OASUSPENDED';
}

function callOnMouseOut(obj)
{
	obj.className = currClass; 
}

function hideToolTip()
{
	document.getElementById("tooltiplayer").style.visibility = 'hidden';
}*/



		


</script>

<%! public String createMultiTable(Connection con, String fid, String starttime, int num,ArrayList loccode, ArrayList locdes,ArrayList locntype, ArrayList pname, ArrayList roomno,ArrayList room_desc,ArrayList pid,String order,String locale,String userid,String oprstn,PageContext pageContext,String call_from,ArrayList pkgpatyn, ArrayList pkgencyn,String action_on_pending_bill,String bl_install_yn)
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
 %>
    <%
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
    %>
    </body>
 </html>

