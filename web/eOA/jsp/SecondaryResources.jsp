<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>

<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <%			

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
				

%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOA/js/SecondaryResource.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%				

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
		String clinic_code=request.getParameter("Clinic_Code");
		if(clinic_code ==null)clinic_code="";
		String From_time_param=request.getParameter("From_time");
		if(From_time_param ==null)From_time_param="";
		String To_time_param=request.getParameter("To_time");
		if(To_time_param ==null)To_time_param="";
		String sec_req=request.getParameter("sec_req");
		String Appt_date=request.getParameter("Appt_date");
		if(Appt_date ==null)Appt_date="";
		String from_page=request.getParameter("from_page");
		if(from_page==null)from_page="";
				
		String row_cnt=request.getParameter("row_cnt");
		if(row_cnt==null)row_cnt="";
		String sec_resorces=request.getParameter("sec_resorces");
		if(sec_resorces ==null)sec_resorces="";
		String sec_resorces_req=request.getParameter("sec_resorces_req");
		String sec_resorces_req1=request.getParameter("sec_resorces_req");
		String sec_resorces1=request.getParameter("sec_resorces1");
		String sel_secondary=(String) session.getValue("SEC_RES_SEL");
		String facilityid=(String)session.getValue("facility_id");
		String clinic_name = request.getParameter("clinic_name_sec");
		if(clinic_name ==null)clinic_name="";
		String care_locn_desc =request.getParameter("care_locn_desc_sec");
		if(care_locn_desc ==null) care_locn_desc="";
		String res_pri_class_desc = request.getParameter("res_pri_class_desc");
		if(res_pri_class_desc ==null) res_pri_class_desc="";
		String pract_pri_name=request.getParameter("pract_name_pri");
		if(pract_pri_name==null) pract_pri_name="";
		String visit_type_desc = request.getParameter("visit_type_des");
		if(visit_type_desc ==null) visit_type_desc="";
		String secold_val	=(String) session.getValue("sec_resc_val_old");
		if(secold_val ==null) secold_val="";

		String chk_val=request.getParameter("chk_val");
		if(chk_val ==null) chk_val="";
		String sec_res_id="";
		String sec_res_name="";
		String SecResFunc=request.getParameter("from")==null?"":request.getParameter("from");
		String systm =request.getParameter("ServerTime");
		if(systm ==null) systm="";
		String sysdt=request.getParameter("ServerDate");
		if(sysdt ==null) sysdt="";
		String token="";
		String token1="";
		String res_id1="";
		String time_tb_type="";
		int cpRs= 0;
		int cpRs1=0;
		int cpRs2=0;
		int cpRs3=0;
		

		java.util.ArrayList arrlst=new java.util.ArrayList();
		java.util.ArrayList arrlst2=new java.util.ArrayList();
		java.util.ArrayList arrlst3=new java.util.ArrayList();
		java.util.ArrayList arrlst1=new java.util.ArrayList();
		java.util.ArrayList arrlstmain1=new java.util.ArrayList();
		//java.util.ArrayList resTypeArr=new java.util.ArrayList();
		java.util.ArrayList element1=new java.util.ArrayList();
		java.util.ArrayList element2=new java.util.ArrayList();
		String str="";
		String prevToken="";
		String prevToken1="";
		Connection conn = null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
		//ResultSet rs3=null;
		String res_id="";
		String res_id2="";
		String resor_class="";
		String res_name="";
		String res_description="";
		StringBuffer str1=new StringBuffer();
		StringBuffer str2=new StringBuffer();
		String srl_no="";
		String status="";
		String classValue="";
		String checked="";
		int xy=0;
		int xyz=0;
		String totSoltsBooked="";
		int availableSlots=0;
		String totSlots="";
		int noOfCol=0;
		String width="";
		String tabWidth="";
		int ijk=0;
		String locale=(String)session.getAttribute("LOCALE"); 

		

		
%>
<script> 
function enable_chk(Obj,token) //ADDED FOR ML-MMOH-SCF-3103
{
	var sys_dt=document.forms[0].sysdt.value;
	var appt_dt=document.forms[0].appt_date.value;
	var sys_tm=document.forms[0].systm.value;
	var appt_tm=token;
	if(sys_dt==appt_dt)
	{
		
		var fromtimeharray=sys_tm.split(":");
		var from_time=appt_tm.split(":");

		var fromhtm=new Date(1,1,1,fromtimeharray[0],fromtimeharray[1],0,0);
		var tohtm=new Date(1,1,1,from_time[0],from_time[1],0,0);
	if( Date.parse(fromhtm) >= Date.parse(tohtm)){
			alert(getMessage("FR_TIME_CAN_NOT_SYS_TIME","OA"));
			Obj.checked=false;
			}

	}

}

function validate() //ADDED FOR ML-MMOH-SCF-3103
{ 
	var sel="N";
	var ret_str="";
	var sel_man="";
	var tmparr="";
	var sec_req=document.forms[0].sec_req.value;
if(document.forms[0].ret_value)
	{
		var nos=document.forms[0].ret_value.length;

		for(var i=0;i<nos;i++){
			if(document.forms[0].chk[i].checked){
				sel="Y";	
				ret_str=ret_str+document.forms[0].ret_value[i].value+",Y"+"@";
				tmparr=document.forms[0].ret_value[i].value.split(",");
				sel_man=sel_man+tmparr[4]+",";
			}else{
				
			}
		}
	}else{
		if(document.forms[0].chk)
		{
		if(document.forms[0].chk.checked){
			sel="Y";			
			ret_str=ret_str+document.forms[0].ret_value.value+",Y"+"@";
			tmparr=document.forms[0].ret_value.value.split(",");
			sel_man=sel_man+tmparr[4]+",";
		}else{
		}
	}
	}
	document.forms[0].selectMandatory.value=sel_man;
	var sec_resorces_req=document.forms[0].sec_resorces_req.value;
	var sec_resorces=document.forms[0].sec_resorces.value;

	if(sel_man.length >1)

		sel_man=sel_man.substring(0,sel_man.length -1);
		sel="Y";
document.forms[0].selectedResources.value=ret_str;

if(sel_man.length>0)
	{
parent.frames[0].document.forms[0].sec_sel.value=ret_str;
  return true;
	}else
	{
	parent.frames[0].document.forms[0].sec_sel.value='';
	return false;
	}
	
}
</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onscroll='scrollTitle();'>
<form name="recur_day_results_this" id="recur_day_results_this" method="post">
<font id='pp'></font>
<%try{
		conn = ConnectionManager.getConnection(request);
		stmt=conn.createStatement();	
		
		StringBuffer secRes=new StringBuffer();
		String tok="";
		String resc_desc="";
		
		StringTokenizer st = new StringTokenizer(sec_req,"-");
		StringTokenizer st1=null;
		String resCF="",man="";
		StringBuffer mandatory=new StringBuffer("");
		String mandatory1="";
		StringBuffer sec_resorces_req_one=new StringBuffer("");
		String sec_resorces_req_two="";
		String secRes_one="";
		sec_resorces_req_one.append(sec_resorces_req);
				

			while(st.hasMoreTokens())
			{
				 tok=st.nextToken();
				 st1=new StringTokenizer(tok,"*");
				 resCF=st1.nextToken();
				 man=st1.nextToken();

				 secRes.append("'");
				 secRes.append(resCF);
				 secRes.append("',");
				 sec_resorces_req_one.append(man);
				 sec_resorces_req_one.append(",");
				 if (man.equals("Y"))
				 {
					mandatory.append(((resCF.equals("E"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels"):(resCF.equals("P"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"):(resCF.equals("O"))?com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels"):com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")));
					mandatory.append("-");
				}
			}
			 if (secRes.length()>1)
			{
			 secRes_one=secRes.toString();
			 secRes_one=secRes_one.substring(0,secRes.length()-1);
			 sec_resorces=secRes_one;
			}
			 if (sec_resorces_req_one.length()>1)
			{
				 sec_resorces_req_two=sec_resorces_req_one.toString();
			 sec_resorces_req_two=sec_resorces_req_two.substring(0,secRes.length()-1);
			}
			 if (mandatory.length()>1)
			{
				 mandatory1=mandatory.toString();
				 mandatory1=mandatory1.substring(0,mandatory1.length()-1);
			}

		
	 %><div id='div1'>
<table cellpadding=0 cellspacing=0 width="100%" border='0'  align='center'>
<tr><td class=label><b><%=mandatory1%></b><%=(mandatory1.length()>1)?"&nbsp;&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>":""%>
</td></tr></table></div> <%

	//str="select nvl(practitioner_id,'*') practitioner_id,resource_class,nvl(TOTAL_SLOTS_BOOKED,'0') TOTAL_SLOTS_BOOKED,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where clinic_code='"+clinic_code+"'  and  clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and facility_id='"+facilityid+"' and primary_resource_yn='N' and resource_class in ("+secRes_one+")and time_table_type in (1,2) order by resource_class,resource_type";
	//str="select nvl(practitioner_id,'*') practitioner_id,resource_class,nvl(TOTAL_SLOTS_BOOKED,'0') TOTAL_SLOTS_BOOKED,MAX_PATIENTS_PER_DAY from oa_clinic_schedule where clinic_code=?  and  clinic_date=to_date(?,'dd/mm/yyyy') and facility_id=? and primary_resource_yn='N' and resource_class in (?)and time_table_type in (1,2) order by resource_class,resource_type";
	str = "SELECT NVL(practitioner_id, '*') practitioner_id, resource_class, NVL(TOTAL_SLOTS_BOOKED, '0') TOTAL_SLOTS_BOOKED, MAX_PATIENTS_PER_DAY " +
      "FROM oa_clinic_schedule " +
      "WHERE clinic_code = ? AND clinic_date = TO_DATE(?, 'dd/mm/yyyy') AND facility_id = ? " +
      "AND primary_resource_yn = 'N' AND resource_class IN (" + secRes_one + ") " +
      "AND time_table_type IN (1,2) " +
      "ORDER BY resource_class, resource_type"; // Modified to use dynamic secRes_one ML-MMOH-SCF-3103
	//rs=stmt.executeQuery(str);
	pstmt = conn.prepareStatement(str);
	pstmt.setString(1,clinic_code);
	pstmt.setString(2,Appt_date);
	pstmt.setString(3,facilityid);
/*  pstmt.setString(4,secRes_one); */ //COMMENTED FOR ML-MMOH-SCF-3103
	rs = pstmt.executeQuery(); 

	 if(rs !=null ) 
	{
		while(rs.next())
		{
			arrlst.add(rs.getString("practitioner_id"));
			arrlst.add(rs.getString("resource_class"));
			if(rs.getString("resource_class").equals("P"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
				}else if(rs.getString("resource_class").equals("R"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
				}else if(rs.getString("resource_class").equals("E"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
				}else if(rs.getString("resource_class").equals("O"))
				{
				resc_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
				}
				arrlst.add(resc_desc);
			arrlst.add(rs.getString("TOTAL_SLOTS_BOOKED"));
			arrlst.add(rs.getString("MAX_PATIENTS_PER_DAY"));
		}

	} 
	 noOfCol=(arrlst.size()/5);
  switch(noOfCol){
	case 1: width="'100%'";tabWidth="'100%'";break;
	case 2: width="'50%'";tabWidth="'100%'";break;
	case 3: width="'33%'";tabWidth="'100%'";break;
	case 4: width="'25%'";tabWidth="'100%'";break;
	case 5: width="'20%'";tabWidth="'100%'";break;
  }
					
	if(arrlst.size()>0)
	{%>
		<table cellpadding=0 cellspacing=0 width=<%=tabWidth%> border='0'  align='center'>
		<tr><td>
		<div  id='divTitleTable'>
		<table cellpadding=0 cellspacing=0 width='100%' border='1'  align='center'>

				<%
					for (int i=0;i<arrlst.size();i+=5)
					{
						resor_class=(String) arrlst.get(i+1);
						sec_res_id=resor_class;
						
						res_id=(String) arrlst.get(i);
						res_id2=res_id;
						if(res_id.equals("*"))
						{
							res_id="";
							res_id2="*";
						}
						sec_res_name=(String) arrlst.get(i+2);	
						if(resor_class.equals("P"))
						{
							//str1  = "select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where nvl(a.practitioner_id,'x')=nvl('"+res_id+"','x') and b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ";

							str1.append("select a.pract_type res_type, a.short_name descrip, b.desc_sysdef res_desc from am_practitioner_lang_vw a, am_pract_type_lang_vw b where b.pract_type=a.pract_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ");

							if(res_id.equals("")){
								str1.append(" and a.practitioner_id is null");
							}else{
								str1.append(" and a.practitioner_id ='"+res_id+"'");
							}
						}else if(resor_class.equals("R"))
						{
							//str1  = "select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where nvl(a.room_num,'x')=nvl('"+res_id+"','x') and a.OPERATING_FACILITY_ID='"+facilityid+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id";
							str1.append("select a.room_type res_type, a.short_desc descrip, b.short_desc res_desc from am_facility_room_lang_vw a, am_care_locn_type_lang_vw b where a.OPERATING_FACILITY_ID='"+facilityid+"' and a.room_type=b.LOCN_TYPE and a.language_id = '"+locale+"' and a.language_id = b.language_id ");
							if(res_id.equals("")){
								str1.append(" and a.room_num is null");
							}else{
								str1.append(" and a.room_num ='"+res_id+"'");
							}

						}else
						{
							//str1  = "select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where nvl(a.resource_id,'x')=nvl('"+res_id+"','x') and a.facility_id= '"+facilityid+"' and a.resource_Class='"+resor_class+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id";
							str1.append("select a.resource_type res_type, a.short_desc descrip, b.short_desc res_desc from am_resource_lang_vw a, am_resource_type_lang_vw b where a.facility_id= '"+facilityid+"' and a.resource_Class='"+resor_class+"' and a.resource_type=b.resource_type and a.language_id = '"+locale+"' and a.language_id = b.language_id ");
							if(res_id.equals("")){
								str1.append(" and a.resource_id is null");
							}else{
								str1.append(" and a.resource_id ='"+res_id+"'");
							}
						}
						rs1=stmt.executeQuery(str1.toString());

						str1.setLength(0);
					
						if(rs1!=null && rs1.next())
						{
							res_name= rs1.getString("descrip") ;
							res_description= rs1.getString("res_desc") ;
							//resTypeArr.add(res_description);
						}
						if(rs1 !=null) rs1.close();
						totSoltsBooked=(String)arrlst.get(i+3);
						totSlots=(String)arrlst.get(i+4);
						availableSlots=Integer.parseInt(totSlots)-Integer.parseInt(totSoltsBooked);
						 %>
					
						 <th  align=middle width=<%=width%> >&nbsp;<%=sec_res_name%>&nbsp;-&nbsp;<%=res_name%>&nbsp;-&nbsp;<%=res_description%><br><fmt:message key="Common.booked.label" bundle="${common_labels}"/>&nbsp;<%=totSoltsBooked%>-<fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<%=totSlots%>-<fmt:message key="Common.available.label" bundle="${common_labels}"/>&nbsp;<%=availableSlots%></th><%	
							
						//str2="select resource_class,time_table_type,srl_no,nvl(schedule_status,'N') status,to_char(slot_slab_start_time,'HH24:mi') sttm,to_char(slot_slab_end_time,'HH24:mi') endtm,slot_slab_start_time from oa_clinic_schedule_slot_slab where clinic_code='"+clinic_code+"' and facility_id= '"+facilityid+"' and nvl(practitioner_id,'x')=nvl('"+res_id+"','x') and clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and resource_class='"+resor_class+"' order by slot_slab_start_time,srl_no";
						str2.append("select resource_class,time_table_type,srl_no,nvl(schedule_status,'N') status,to_char(slot_slab_start_time,'HH24:mi') sttm,to_char(slot_slab_end_time,'HH24:mi') endtm,slot_slab_start_time from oa_clinic_schedule_slot_slab where clinic_code='"+clinic_code+"' and facility_id= '"+facilityid+"' ");
						if(res_id.equals("")){
							str2.append(" and practitioner_id is null");
						}else{
							str2.append(" and practitioner_id ='"+res_id+"'");
						}
						str2.append(" and clinic_date=to_date('"+Appt_date+"','dd/mm/yyyy') and resource_class='"+resor_class+"' order by slot_slab_start_time,srl_no ");

						rs2=stmt.executeQuery(str2.toString());
						str2.setLength(0);

						if(rs2 !=null )
						{
							arrlst3=new java.util.ArrayList();
							xy=0;
							while(rs2.next())
							{
									
								arrlst2=new java.util.ArrayList();
								arrlst2.add(res_id2);
								arrlst2.add(res_name);						
								arrlst2.add(rs2.getString("srl_no"));
								arrlst2.add(rs2.getString("time_table_type"));
								arrlst2.add(rs2.getString("status"));
								arrlst2.add(rs2.getString("sttm"));
								arrlst2.add(rs2.getString("endtm"));
								arrlst2.add(rs2.getString("resource_class"));
								arrlst3.add(arrlst2);	
								xy++;
							}
								if(xy>xyz)
								{
									xyz=xy;
								}

							arrlstmain1.add(arrlst3);

						}
						if(rs2 !=null) rs2.close();
					}//end of for loop
				
				%> </table></div></td></tr>
			<%}else { %>
			<script>
				alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
				parent.frames[0].document.forms[0].globalFlag.value='false';
			</script>
			<% } %>
		
				<tr><td>
			    <table cellpadding=0 cellspacing=0 width='100%' border='1' align='center'>
				<tr align=middle>
<%	
			
						
	for (int i=0;i<arrlstmain1.size();i++)
	{

		%><td class='OAQRYODD' valign='abstop' align=middle width='<%=width%>'><table border='1'  width='100%'  cellpadding='0'  cellspacing='0'  ><%

		 element1=(ArrayList) arrlstmain1.get(i);
			int new_indx=0;
			ijk=0;

			for (int j=0;j<element1.size();j++)
			{
				 element2=(ArrayList) element1.get(j);
		
				for (int jk=0;jk<element2.size();jk+=8)
				{

						
					try
					{
						res_id1=(String) element2.get(0);
						token=(String) element2.get(5);
						token1=(String) element2.get(6);
						status=(String) element2.get(4);
						srl_no=(String) element2.get(2);
						time_tb_type=(String)element2.get(3);
						resor_class=(String) element2.get(7);
					}catch(Exception ex){
						token="";
						token1="";
						status="";
					
					}
				
				if ( ijk % 2 == 0 )
					classValue = "OAQRYEVEN" ;
				else
					classValue = "OAQRYODD" ;
				  if (SecResFunc.equals("")){ 
                  if (!(time_tb_type.equals("2")&& prevToken.equals(token)&&prevToken1.equals(token1))) {
					
					 cpRs= token.compareTo(From_time_param);
					 cpRs1=token.compareTo(To_time_param);
					 cpRs2=token1.compareTo(From_time_param);
					 cpRs3=token1.compareTo(To_time_param);

					
					if ((cpRs>=0 &&cpRs1<=0) && (cpRs2>=0 &&cpRs3<=0)) {
						//checked="checked";
						checked="";
					}else{
						checked="";
					}
					
				prevToken=token;
				prevToken1=token1;
			}else{
			checked="";
			}
			}
									

				if(status.equals("N")){

						
				if(arrlst1.size() >0){%>

						<tr><td class='<%=classValue%>' width='20%' nowrap><%=token%> - <%=token1%> &nbsp;<input type='checkbox'  name='chk' id='chk'   onclick="enable_chk(this,'<%=token1%>')" <%=checked%>> 
						<%if(from_page.equals("")) {%>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=clinic_code%>,<%=facilityid%>,<%=res_id1%>,<%=Appt_date%>,<%=resor_class%>,<%=token%>,<%=token1%>,<%=time_tb_type%>,<%=srl_no%>'><input type='hidden' name='ret_srl_no' id='ret_srl_no' value=''>
						<%}else{%>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=clinic_code%>,<%=facilityid%>,<%=res_id1%>,<%=Appt_date%>,<%=resor_class%>,<%=token%>,<%=token1%>,<%=time_tb_type%>,<%=srl_no%>,<%=row_cnt%>'><input type='hidden' name='ret_srl_no' id='ret_srl_no' value='<%=srl_no%>'>
						<%}%></td></tr>
						<%}else{%>

						<tr><td class='<%=classValue%>' width='20%' nowrap><%=token%> - <%=token1%> <input type='checkbox'  name='chk' id='chk'   onclick="enable_chk(this,'<%=token1%>')" <%=checked%>> 
						<%if(from_page.equals("")) {%>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=clinic_code%>,<%=facilityid%>,<%=res_id1%>,<%=Appt_date%>,<%=resor_class%>,<%=token%>,<%=token1%>,<%=time_tb_type%>,<%=srl_no%>'><input type='hidden' name='ret_srl_no' id='ret_srl_no' value=''>
						<%}else{%>
						<input type='hidden' name='ret_value' id='ret_value' value='<%=clinic_code%>,<%=facilityid%>,<%=res_id1%>,<%=Appt_date%>,<%=resor_class%>,<%=token%>,<%=token1%>,<%=time_tb_type%>,<%=srl_no%>,<%=row_cnt%>'><input type='hidden' name='ret_srl_no' id='ret_srl_no' value='<%=srl_no%>'>
						<%}%></td></tr>
							<% }%>
							
				<%}else if(status.equals("1")){%>
						<tr><td class='slotFull'  width='20%' nowrap title='Appointment Exists'><%=token%> - <%=token1%>
						<input type="checkbox" name=chk id=chk value="" style="visibility:hidden">
						<input type="hidden" name="ret_value" id="ret_value" value=""><input type='hidden' name='ret_srl_no' id='ret_srl_no' value=''></td></tr>
				<%}else if(status.equals("B")){ %>
						<tr><td class='slotBlocked' width='20%' nowrap title='Block Exists'><%=token%> - <%=token1%><input type="checkbox" name=chk id=chk value="" style="visibility:hidden">
						<input type="hidden" name="ret_value" id="ret_value" value=""><input type='hidden' name='ret_srl_no' id='ret_srl_no' value=''></td></tr>
						
				<%}
			
				
				new_indx++;
					
				}
				ijk++;

			element2.clear();

			}
			
			%></table></td><%element1.clear();
									

}%>

 </tr>
	</table> 
	</td></tr></table>
	<input type='hidden' name='appt_date' id='appt_date' value='<%=Appt_date%>'>
	<input type='hidden' name='sysdt' id='sysdt' value='<%=sysdt%>'>
	<input type='hidden' name='systm' id='systm' value='<%=systm%>'>
	<input type='hidden' name='sec_resorces_req' id='sec_resorces_req' value='<%=sec_resorces_req_one.toString()%>'>
	<input type='hidden' name='sec_resorces_req1' id='sec_resorces_req1' value='<%=sec_resorces_req1%>'>
	<input type='hidden' name='sec_resorces' id='sec_resorces' value="<%=sec_resorces%>">
	<input type='hidden' name='sec_resorcesT' id='sec_resorcesT' value="<%=sec_resorces1%>">
	<input type='hidden' name='sec_req' id='sec_req' value='<%=sec_req%>'>
	<input type='hidden' name='first_set_value' id='first_set_value' value=''>
	<input type='hidden' name='sec_set_value' id='sec_set_value' value=''>
	<input type='hidden' name='sel_secondary' id='sel_secondary' value='<%=sel_secondary%>'>
	<input type='hidden' name='sec_res_id' id='sec_res_id' value='<%=sec_res_id%>'>
	<input type='hidden' name='selectedResources' id='selectedResources' value=''>
	<input type='hidden' name='selectMandatory' id='selectMandatory' value=''>
	<input type='hidden' name='SecResFunc' id='SecResFunc' value='<%=SecResFunc%>'>
	<input type='hidden' name='from_page' id='from_page' value='<%=from_page%>'>
	<input type='hidden' name='secold_val' id='secold_val' value='<%=secold_val%>'>
	<input type='hidden' name='chk_val' id='chk_val' value='<%=chk_val%>'>



</form>


<%
	//if (rs3!=null) rs3.close();
	if (rs!=null) rs.close();
	if (rs1!=null) rs1.close();
	if(rs2 !=null)rs2.close();
	if (stmt!=null) stmt.close();
	arrlst.clear();
	arrlst2.clear();
	arrlst3.clear();
	arrlst1.clear();
	arrlstmain1.clear();
	element1.clear();
	element2.clear();
	//resTypeArr.clear();
}catch(Exception ex){
	ex.printStackTrace();

}finally
{
  if (conn !=null) ConnectionManager.returnConnection(conn,request);
}

%>
<script>
var x=document.forms[0].SecResFunc.value;
var y=document.forms[0].sel_secondary.value;
if (x=="SecResFunc" && y!=''){
	retain();
}
</script>
</body>
</html>

