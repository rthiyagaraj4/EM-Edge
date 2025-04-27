<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.net.URLEncoder.*,com.ehis.util.*,java.util.*,eCommon.XSSRequestWrapper" %>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
	
<% 
Connection con = null;
ResultSet rs=null;
Statement stmt =null; 

ResultSet rssql1=null;
Statement stsql2 = null;	
java.util.Properties p;
PreparedStatement pstmt		= null;
// added by N Munisekhar on 04-May-2012 against [IN:039768]
String apptrefno="";
try{
	
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();

	 stsql2 = con.createStatement();	

	String oper_stn_id="";
	String locale			= (String)session.getAttribute("LOCALE");

	String fac_id    	= (String) session.getValue( "facility_id" ) ;
	String biometric_reason   = checkForNull((String) session.getValue( "biometric_reason" )) ;//Added By Himanshu for AAKH-crf-0175 on 04-09-23
	String smartCardFunc	=  isSiteSpecificforBiometric(con);//added by Himanshu Saxena for AAKH-CRF-0175 as on 04-09-2023 
			
	String curr_user_id=(String)session.getValue("login_user");
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String client_ip_address ;
	client_ip_address = p.getProperty("client_ip_address");
    String lbValue=request.getParameter("LBoxValue")==null?"":request.getParameter("LBoxValue");
    String fromPage=(String) request.getParameter("from")==null?"":request.getParameter("from");
	//System.out.println("fromPage--------->"+fromPage);
	String reason_code=request.getParameter("reason_code");
	String proc_code	=request.getParameter("proc_code");//ADDED oN 1/4/2011 FOR RETNUIN CRF
	String term_set_id=request.getParameter("term_set_id");//ADDED oN 1/4/2011 FOR RETNUIN CRF
	//System.out.println("proc_code--------->"+proc_code);
	//System.out.println("term_set_id--------->"+term_set_id);
	String odrer_category=request.getParameter("odrer_category");
	String pat_id1				=	request.getParameter("patient_id");
	if(pat_id1 ==null) pat_id1="";
	String blng_grp				=	request.getParameter("blng_grp");
	if(blng_grp ==null) blng_grp="";

	if(odrer_category ==null) odrer_category="";

	oper_stn_id=(String) request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
	
	String other_remarks = request.getParameter("other_remarks"); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

	if (fromPage.equals("GenerateSchedule")){
		StringBuffer sql=new StringBuffer("");
		sql.append("Select a.long_desc long_desc, a.alcn_criteria alcn_criteria,a.clinic_code clinic_code,a.CLINIC_TYPE clinic_type,a.OPEN_TO_ALL_PRACT_YN open_to_all_pract_yn,ident_at_checkin,fi_visit_type_appl_yn from op_clinic_lang_vw a , am_locn_for_oper_stn b  where a.facility_id='"+fac_id+"' and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.language_id='"+locale+"' and ");

		if(lbValue.equals("D")){
			sql.append(" clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+lbValue+"' ");
		}  
  
		sql.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+fac_id+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id  AND b. appl_user_id ='"+curr_user_id+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.ALLOW_APPT_YN='Y' and a.level_of_care_ind = 'A' and a.clinic_type=b.locn_type order by a.long_desc");

		rs=stmt.executeQuery(sql.toString());
		sql.setLength(0);
		%>
       <script>
	   i=1;
       obj1=parent.frames[1].document.forms[0].clinic;
	   obj1.remove(obj1.options[0]);
       opt=parent.frames[1].document.createElement('OPTION');
	   opt2=parent.frames[1].document.forms[0].default_select.value;
       opt.value='';
	   opt.text="------------------------"+opt2+"------------------------";
	   obj1.add(opt);

       len= parent.frames[1].document.forms[0].clinic.options.length;
	   while(i<len){
		   obj1.remove(obj1.options[i]);
		   i+=1;
	   }
		</script>
	  <% String dat="";
	     String ID="";
		 String locntype="";
		 while(rs.next() && rs!=null){
		 
			dat=rs.getString("long_desc");
			ID=rs.getString("clinic_code");
			locntype = rs.getString("clinic_type");


			%>
			<script>
			opt=parent.frames[1].document.createElement('OPTION');
			opt.value="<%=ID%>|<%=locntype%>"
			opt.text="<%=dat%>"
			parent.frames[1].document.forms[0].clinic.add(opt);
			</script>
			<%
		 }
			if(rs !=null) rs.close();%>
		
		<script>
		parent.frames[3].location.href='../../eCommon/jsp/error.jsp'
		</SCRIPT>
	<%}else if (fromPage.equals("GenerateSchedule_ref")){

		String clinic_code=(String) request.getParameter("clinic_code")==null?"":request.getParameter("clinic_code");

			
		String currentdate=(String) request.getParameter("sys_date")==null?"":request.getParameter("sys_date");		
		int dutyRosterCount = 0;
		String effdatefrom="";
		String effdateto="";
		String checkBoxAttribute1 = "";
		String checkBoxAttribute2 = "";
		String checkBoxAttribute3 = "";
		String checkBoxAttribute4 = "";
		String checkBoxAttribute5 = "";
		String checkBoxAttribute6 = "";
		String checkBoxAttribute7 = "";
			
		String day_1=request.getParameter("day_1");
		String day_2=request.getParameter("day_2");
		String day_3=request.getParameter("day_3");
		String day_4=request.getParameter("day_4");
		String day_5=request.getParameter("day_5");
		String day_6=request.getParameter("day_6");
		String day_7=request.getParameter("day_7");
		/*System.out.println("day_1:"+day_1);
		System.out.println("day_2:"+day_2);
		System.out.println("day_3:"+day_3);
		System.out.println("day_4:"+day_4);
		System.out.println("day_5:"+day_5);
		System.out.println("day_6:"+day_6);
		System.out.println("day_7:"+day_7);*/

		/*String dis1 = "DISABLED";
		String dis2 = "DISABLED";
		String dis3 = "DISABLED";
		String dis4 = "DISABLED";
		String dis5 = "DISABLED";
		String dis6 = "DISABLED";
		String dis7 = "DISABLED";
		String dis="DISABLED";
		*/
		String chk="DISABLED";
		//dis = dis;
		String dayofweek="";

		String day_1_desc="";
		String day_2_desc="";
		String day_3_desc="";
		String day_4_desc="";
		String day_5_desc="";
		String day_6_desc="";
		String day_7_desc="";

		String eff_from_disply="";
		String eff_to_disply="";

		int i=0;


		if(!(clinic_code == null ||clinic_code.equals(""))){

			rs=stmt.executeQuery("select to_char(max(effective_to_date_time+1),'dd/mm/yyyy') d from oa_clinic_schedule_validity where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' ");
				
			if(rs.next()){
				effdatefrom =  rs.getString("d");

				if(effdatefrom == null ||effdatefrom.equals(""))
					effdatefrom = "";

				if(!effdatefrom.equals("")){
					String datComp="select case when  sysdate <to_date('"+effdatefrom+"','dd/mm/yyyy') then '0'else '1' end if from dual ";
					rssql1=stsql2.executeQuery(datComp);
					rssql1.next();
					if(rssql1.getString(1).equals("1"))
						effdatefrom=currentdate;
					}
					effdateto = effdatefrom;
				}
				if(rs !=null)	 rs.close();
				if(rssql1 !=null) rssql1.close();

				String sql_temp = "select count(1) cnt from oa_roster_for_pract where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' and TO_CHAR(on_duty_date,'dd/mm/yyyy') between '"+effdatefrom+"' and '"+effdateto+"'";
				
				rssql1 = stsql2.executeQuery(sql_temp);
				if(rssql1.next())	{
					dutyRosterCount = rssql1.getInt("cnt");
				}
			}
			if(rs !=null) rs.close();

			StringBuffer dispStr=new StringBuffer("");
			day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_1.toLowerCase())+".label","common_labels");
			day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_2.toLowerCase())+".label","common_labels");
			day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_3.toLowerCase())+".label","common_labels");
			day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_4.toLowerCase())+".label","common_labels");
			day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_5.toLowerCase())+".label","common_labels");
			day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_6.toLowerCase())+".label","common_labels");
			day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common."+(day_7.toLowerCase())+".label","common_labels");

			String sql="select distinct lower(b.day_of_week)day_of_week, a.day_no from oa_clinic_time_table a, sm_day_of_week b where facility_id = '"+fac_id+"' and clinic_code = '"+clinic_code+"' and a.day_no = b.day_no order by a.day_no ";
			rs=stmt.executeQuery(sql);
			String time_table_yn="";
			String day_no="";
			if(rs.next()){
				chk="CHECKED";				
				dispStr.append("<table id='id' border='0' cellpadding='0' cellspacing='0'  width='80%'>");
				do{ 
					dayofweek =  rs.getString("day_of_week");
					dayofweek = dayofweek.substring(0, 3);
					day_no=rs.getString("day_no");
					i++;
					if(day_1.equalsIgnoreCase(dayofweek)){						
						checkBoxAttribute1 = "CHECKED";
					}else if(day_2.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute2 = "CHECKED";
					}else if(day_3.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute3 = "CHECKED";
					}else if(day_4.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute4 = "CHECKED";
					}else if(day_5.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute5 = "CHECKED";
					}else if(day_6.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute6 = "CHECKED";
					}else if(day_7.equalsIgnoreCase(dayofweek)){
						checkBoxAttribute7 = "CHECKED";
					}				
				}while(rs.next());

				/*day_1_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
				day_2_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
				day_3_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
				day_4_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
				day_5_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
				day_6_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
				day_7_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");*/

				

				dispStr.append("<tr><td  id ='lbl' width='23%' class=label >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.TimeTableAvailableDays.label","oa_labels")+"</td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_1_desc+"<br>&nbsp;<input type='checkbox' name='day_1' id='day_1' value='"+day_1+"' "+checkBoxAttribute1+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_2_desc+"<br>&nbsp;<input type='checkbox' name='day_2' id='day_2' value='"+day_2+"' "+checkBoxAttribute2+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_3_desc+"<br>&nbsp;<input type='checkbox' name='day_3' id='day_3' value='"+day_3+"' "+checkBoxAttribute3+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_4_desc+"<br>&nbsp;<input type='checkbox' name='day_4' id='day_4' value='"+day_4+"' "+checkBoxAttribute4+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_5_desc+"<br>&nbsp;<input type='checkbox' name='day_5' id='day_5' value='"+day_5+"' "+checkBoxAttribute5+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_6_desc+"<br>&nbsp;<input type='checkbox' name='day_6' id='day_6' value='"+day_6+"' "+checkBoxAttribute6+" disabled></td>");

				dispStr.append("<td class=fields width='7%'>&nbsp;"+day_7_desc+"<br>&nbsp;<input type='checkbox' name='day_7' id='day_7' value='"+day_7+"' "+checkBoxAttribute7+" disabled></td>");
				dispStr.append("</tr></table>");


				eff_from_disply=DateUtils.convertDate(effdatefrom,"DMY","en",locale);
				eff_to_disply=DateUtils.convertDate(effdateto,"DMY","en",locale);
				
				%>
				<script>

							
					parent.frames[1].document.forms[0].eff_from.value="<%=eff_from_disply%>";
					parent.frames[1].document.forms[0].eff_from_date.value="<%=effdatefrom%>";
					parent.frames[1].document.forms[0].eff_to.value="<%=eff_to_disply%>";
					parent.frames[1].document.forms[0].eff_to_date.value="<%=effdateto%>";
                    /*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/
				 //  if('<%=fromPage%>'=="GenerateSchedule_ref" && parent.frames[1].document.forms[0].chkvalue){
				  //     parent.frames[1].document.forms[0].chkvalue.value="timetableexist";				
				  // }
				   //if('<%=fromPage%>'!="GenerateSchedule_ref"){
					    parent.frames[1].document.forms[0].all_practitioners.value="<%=chk%>";
				  // }
				     /*Above Line condtion Added for this CRF [AMRI-CRF-0236]*/

					parent.frames[1].document.forms[0].no_days.value="<%=i%>";
					parent.frames[1].document.forms[0].generate.disabled=false;

					parent.frames[1].document.forms[0].dutyRosterCount.value="<%=dutyRosterCount%>";

					parent.frames[1].document.getElementById("info").innerHTML="<%=dispStr.toString()%>";
					parent.frames[3].location.href='../../eCommon/jsp/error.jsp'
				</script>
				<%
				dispStr.setLength(0);
			}else{%>
				<script>
				/*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/
			//	if('<%=fromPage%>'=="GenerateSchedule_ref" && parent.frames[1].document.forms[0].chkvalue){
			//	parent.frames[1].document.forms[0].chkvalue.value="timetablenotexist";				
			//	}
				//End this CRF [AMRI-CRF-0236]
				
			    alert(parent.frames[1].getMessage("TIME_TABLE_DOES_NOT_EXIST","OA"));				
				
				parent.frames[1].document.forms[0].eff_to.value='';
				parent.frames[1].document.forms[0].eff_from.value='';
				/*Below Line condtion Added for this CRF [AMRI-CRF-0236]*/				
				//if('<%=fromPage%>'!="GenerateSchedule_ref"){
				parent.frames[1].document.forms[0].all_practitioners.checked=false;
				parent.frames[1].document.forms[0].all_practitioners.disabled=true;
				//}
				// End [AMRI-CRF-0236]
				parent.frames[1].document.forms[0].generate.disabled=true;
				parent.frames[3].location.href='../../eCommon/jsp/error.jsp'
				</script>
			<%}
			if(rs !=null) rs.close();			 
			%>
	<%}else if (fromPage.equals("QryApptforPractCriteria")){%>

	   <script>
		obj=parent.frames[1].document.frames[0].document.forms[0].blocation;
		var len=obj.options.length;
		i=0;
		for(;i<len;i++) obj.remove(obj.options[i]) ;
		opt=parent.frames[1].document.frames[0].document.createElement('OPTION');
		opt.value='';
		opt.text='-----------------------'+getLabel("Common.defaultSelect.label","Common")+'-----------------------';
		obj.add(opt);
	   </script>
		<%
		StringBuffer sqlQuery=new StringBuffer("");
		sqlQuery.append("select long_desc long_desc, clinic_code,ident_at_checkin,open_to_all_pract_yn,to_char(sysdate,'dd/mm/yyyy')  sydate from op_clinic_lang_vw   where facility_id='"+fac_id+"' and ");

		if(lbValue.equals("D")){
			sqlQuery.append("  clinic_type='Y' ");

		}else{
			sqlQuery.append("  clinic_type='"+lbValue+"' ");

		}
		  
		  
		 sqlQuery.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and level_of_care_ind = 'A' and  eff_status='E' and  language_id ='"+locale+"' order by long_desc") ;

		if (rs!=null) rs.close();
		rs=stmt.executeQuery(sqlQuery.toString());
		sqlQuery.setLength(0);

		String clinicCode="";
		String clinicDesc="";
		String open_to_all_pract_yn="";
		String ident_at_checkin="";

		while(rs.next() && rs!=null){
			clinicCode=rs.getString("clinic_code");
			clinicDesc=rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			ident_at_checkin=rs.getString("ident_at_checkin");
			%>
			<script>
			obj=parent.frames[1].document.frames[0].document.forms[0].blocation;
			opt=parent.frames[1].document.frames[0].document.createElement('OPTION');
			opt.value="<%=open_to_all_pract_yn%>$<%=clinicCode%>";
			opt.text="<%=clinicDesc%>";
			obj.add(opt);
			</script>
		<%}
			
		if(rs !=null)	 rs.close();
			%>
	   <script>
		parent.frames[2].location.href='../../eCommon/jsp/error.jsp'
	  </SCRIPT>

<%} else if (fromPage.equals("LocationForADay")){ %> 
	   <script>
        
       obj1=parent.frames[1].document.forms[0].blocation;
	   while(obj1.options.length > 0) 
		   obj1.remove(obj1.options[0]);

       opt=parent.frames[1].document.createElement('OPTION');
       opt.value='';
	   opt.text='-----------------------'+getLabel("Common.defaultSelect.label","Common")+'-----------------------';
	   obj1.add(opt);

       
		</script>  
					  
		<%
		StringBuffer sql	= new StringBuffer("");
		sql.append("select long_desc long_desc, clinic_code, open_to_all_pract_yn ,to_char(sysdate,'dd/mm/yyyy')  sydate from op_clinic_lang_vw   where facility_id='"+fac_id+"' and language_id='"+locale+"' and ");

		if(lbValue.equals("D")){
			sql.append("  clinic_type='Y' ");
		}else{
			sql.append("  clinic_type='"+lbValue+"' ");
		}


		sql.append(" and CARE_LOCN_TYPE_IND='"+lbValue+"' and level_of_care_ind = 'A' and  eff_status='E' order by long_desc") ;

		if (rs!=null) rs.close();
		rs 	= stmt.executeQuery( sql.toString() ) ;
		sql.setLength(0);

		String clinicCode = "" ;
		String clinicDesc = "" ;
		String open_to_all_pract_yn="";

		while(rs.next() && rs!=null){
			clinicCode=rs.getString("clinic_code");
			clinicDesc=rs.getString("long_desc");
			open_to_all_pract_yn=rs.getString("open_to_all_pract_yn");
			%>
			<script>
			obj=parent.frames[1].document.forms[0].blocation;
			opt=parent.frames[1].document.createElement('OPTION');
			opt.value="<%=open_to_all_pract_yn%>$<%=clinicCode%>";
			opt.text="<%=clinicDesc%>";
			obj.add(opt);
			</script>
		<%} 
		if(rs !=null) rs.close();	
			%> 

		<script>
		parent.frames[3].location.href='../../eCommon/jsp/error.jsp'
		</script>
		<%
	}else if (fromPage.equals("WaitListMgmtCancel")){
		
		PreparedStatement pStmt=null;
		con.setAutoCommit(false);
		Statement stmtsd=null;
		stmtsd=con.createStatement();
		String sys_date="";
			String sql="select to_char(sysdate,'dd/mm/yyyy') sys_dt from dual";
		rs=stmtsd.executeQuery(sql);
		while(rs.next())
		{
			sys_date=rs.getString("sys_dt");
		}
		if(rs !=null) rs.close();
		//Updating audit columns::
		String sQl="update pr_wait_list set wait_list_status='C' , REASON_FOR_CANCEL='"+reason_code+"' , REMARKS_FOR_CANCEL='"+other_remarks+"', MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"' where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		pStmt=con.prepareStatement(sQl);
		
		pStmt.setString(1,fac_id);
		pStmt.setString(2,lbValue);

		int cnt=pStmt.executeUpdate();

		//Added By Himanshu for AAKH-crf-0175 on 04-09-23 Start
		 try 
			{
			if(cnt!=0 && smartCardFunc.equals("01") && !biometric_reason.equals("")){
				String clinic_code=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
				session.removeAttribute("biometric_reason");
				String status1=insertReasonforBiometric(con,fac_id,"OA_MANAGE_WAITLIST",pat_id1,lbValue,clinic_code,biometric_reason,client_ip_address,curr_user_id);
				}
			}
			catch(Exception e){e.printStackTrace();}
		//  for AAKH-crf-0175 on 04-09-23 Ends

		if (cnt!=0){
			con.commit();
			%>
			<script>
			
			var error1=getMessage("RECORD_MODIFIED","SM");
			alert(error1);
			//parent.window.close();
			parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
			parent.parent.parent.frames[2].frames[3].location.reload();
			</script>
			<%

		}else{
			try{
			con.rollback();
		   }catch(Exception es){}
			
			%>
			<script>
			
			var error5=getMessage("NO_CHANGE_TO_SAVE","Common");
			
			parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num="+error5;
			parent.frames[2].location.reload();
			</script>
			
			<%
		
		}
		if (pStmt!=null) pStmt.close();


	} else if (fromPage.equals("WaitListMgmtModify")){

	   String preferredDate=request.getParameter("preferredDate")==null?"":request.getParameter("preferredDate");
	   String status=request.getParameter("status")==null?"":request.getParameter("status");
	   String clinic_code=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
	   String resourceId=request.getParameter("resourceid")==null?"":request.getParameter("resourceid");
	   String resource_class=request.getParameter("resource")==null?"":request.getParameter("resource");
	   String elapsed=request.getParameter("elapsed");
	   String wait_list_ref_no=request.getParameter("wait_list_ref_no")==null?"":request.getParameter("wait_list_ref_no");


	   String wait_list_category=request.getParameter("wait_list_category")==null?"":request.getParameter("wait_list_category");
	   String reason_modify_code=request.getParameter("reason_modify_code")==null?"":request.getParameter("reason_modify_code");
		
		//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		String remarks_for_modify = request.getParameter("remarks_for_modify")==null?"":request.getParameter("remarks_for_modify");
	   
	   if (elapsed==null) elapsed="";
				   
	   String sQl="";
	   PreparedStatement pStmt=null;
	   con.setAutoCommit(false);
	Statement stmtsd=null;
		stmtsd=con.createStatement();
		String sys_date="";
			String sql="select to_char(sysdate,'dd/mm/yyyy') sys_dt from dual";
		rs=stmtsd.executeQuery(sql);
		while(rs.next())
		{
			sys_date=rs.getString("sys_dt");
		}
		if(rs !=null) rs.close();
	   if (elapsed.equals("N")){
		   //Updating audit columns::
		   sQl="update pr_wait_list set WAIT_LIST_PRIORITY=?,PREFERRED_DATE_TIME=to_date(?,'dd/mm/yyyy'),locn_code=?,resource_class=?,RESOURCE_ID=? ,ORDER_CATALOG_CODE=? ,WAITLIST_CATEGORY_CODE=? ,REASON_FOR_MODIFY=?,MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate,wait_list_ref_no=?, MODIFIED_FACILITY_ID='"+fac_id+"', REMARKS_FOR_MODIFY=? where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114

		   pStmt=con.prepareStatement(sQl);
		   pStmt.setString(1,status);
		   pStmt.setString(2,preferredDate);
		   pStmt.setString(3,clinic_code);
		   pStmt.setString(4,resource_class);
		   pStmt.setString(5,resourceId);
		   pStmt.setString(6,odrer_category);
		   pStmt.setString(7,wait_list_category);
		   pStmt.setString(8,reason_modify_code);
		   pStmt.setString(9,wait_list_ref_no);
		   pStmt.setString(10,remarks_for_modify); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
		   pStmt.setString(11,fac_id);
		   pStmt.setString(12,lbValue);

		 //Added By Himanshu for AAKH-crf-0175 on 04-09-23 Start
		   try 
			{
			if(smartCardFunc.equals("01") && !biometric_reason.equals("")){
				session.removeAttribute("biometric_reason");
				String status1=insertReasonforBiometric(con,fac_id,"OA_MANAGE_WAITLIST",pat_id1,lbValue,clinic_code,biometric_reason,client_ip_address,curr_user_id);
				}
			}
			catch(Exception e){e.printStackTrace();}
		 // for AAKH-crf-0175 on 04-09-23 Start   
			
	}else if (elapsed.equals("Y")){
			//Updating audit columns::
			sQl="update pr_wait_list set PREFERRED_DATE_TIME=to_date(?,'dd/mm/yyyy'),REASON_FOR_MODIFY=? ,MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"', REMARKS_FOR_MODIFY=? where facility_id=? and WAIT_LIST_NO=?"; //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			if (pStmt!=null) pStmt.close();
			pStmt=con.prepareStatement(sQl);
			pStmt.setString(1,preferredDate);
			pStmt.setString(2,reason_modify_code);
			pStmt.setString(3,remarks_for_modify); //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
			pStmt.setString(4,fac_id);
			pStmt.setString(5,lbValue);
		}

	   int result=pStmt.executeUpdate();
	   if (result!=0){
		   con.commit();
			%>
			<script>
			
			var error2=getMessage("RECORD_MODIFIED","SM");
			alert(error2);
			//window.close();
			parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
			</script>
			<%

	   }else{
		   try{
			con.rollback();
		   }catch(Exception es){}
		
			
			%>
			<script>
			
			var error4=getMessage("NO_CHANGE_TO_SAVE","Common");
			alert(error4);
			
			</script>
			<%
		 
	   }
	   
	   if (pStmt!=null) pStmt.close();

	}else if (fromPage.equals("WaitListMgmtModifyWindow")){

		String clinic_code1=request.getParameter("clinicCode")==null?"":request.getParameter("clinicCode");
		String clinic_type =request.getParameter("locn_type")==null?"":request.getParameter("locn_type");
		String sql  = "select primary_resource_class from op_clinic where clinic_code='"+clinic_code1+"' and care_locn_type_ind='"+clinic_type+"' and facility_id='"+fac_id+"'";

		String code="";
		String desc="";

		if (rs!=null) rs.close();
		rs = stmt.executeQuery(sql);
		while(rs!=null && rs.next()){
			code=rs.getString("primary_resource_class");
				if(code.equals("P"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			}else if(code.equals("E"))
			{
		    desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			}else if(code.equals("R"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}else if(code.equals("O"))
			{
			desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
			
			if (desc==null) desc="";
		
		}
				if(rs !=null) rs.close();	
%>
		<script>
		if (parent.frames[0].document.getElementById("resourceType1")){
			parent.frames[0].document.getElementById("resourceType1").value="<%=code%>";
			parent.frames[0].document.getElementById("pract_type1").innerHTML="<%=desc%>";
		}else{
		    parent.frames[1].document.forms[0].resourceType1.value="<%=code%>";
			parent.frames[1].document.getElementById("pract_type1").innerHTML="<%=desc%>";
			parent.frames[3].location.href='../../eCommon/jsp/error.jsp';
		}
		</script>
		<%
	}else if (fromPage.equals("ForceClose")){
		String force_prd_days=request.getParameter("force_prd_days");
		String patientid=request.getParameter("patientid");
		if(patientid ==null) patientid="";
		String sQl="";
		PreparedStatement pStmt=null;
		con.setAutoCommit(false);
		int result=0;
		if(patientid.equals("null") || patientid.equals(""))
			{
			//Updating Audit Columns::
		sQl="update pr_wait_list set wait_list_status ='X', MODIFIED_BY_ID='"+curr_user_id+"',MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"'  where facility_id=? and wait_list_status='O' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') between   trunc(sysdate - ?)  and  trunc(sysdate-1)";
	

		if (pStmt!=null) pStmt.close();
		pStmt=con.prepareStatement(sQl);
		pStmt.setString(1,fac_id);
		pStmt.setString(2,force_prd_days);

	    result=pStmt.executeUpdate();
			}else
			{
			//Updating audit columns::
		sQl="update pr_wait_list set wait_list_status ='X', MODIFIED_BY_ID='"+curr_user_id+"', MODIFIED_AT_WS_NO='"+client_ip_address+"', MODIFIED_DATE=sysdate, MODIFIED_FACILITY_ID='"+fac_id+"'  where facility_id=? and wait_list_status='O' and to_date(to_char(preferred_date_time,'dd/mm/yyyy'),'dd/mm/yyyy') between trunc(sysdate - ? )  and  trunc(sysdate-1) and patient_id=?";
				

		if (pStmt!=null) pStmt.close();
		pStmt=con.prepareStatement(sQl);
		pStmt.setString(1,fac_id);
		pStmt.setString(2,force_prd_days);
		pStmt.setString(3,patientid);

	    result=pStmt.executeUpdate();

			}

	   if (result !=0){
		  con.commit();
		%>
			<script>
			var error=getMessage("RECORD_MODIFIED","SM");
			var err_value="";
			</script>
			<html>
			<script>parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num="+error;</script>
			<body class='message' onKeyDown = 'lockKey()'></html>
			<%

	   }else{
		   try{
			con.rollback();
		   }catch(Exception es){}
		
			%>
			<html>
			<script>
			var error3=getMessage("NO_CHANGE_TO_SAVE","Common");
			var err_value3="";
			parent.frames[2].location.href ="../../eCommon/jsp/error.jsp?err_num="+error3;
			</script>
			<body class='message' onKeyDown = 'lockKey()'></html>
			
			<%
			
			
	   }
	   
	   if (pStmt!=null) pStmt.close();


	}else if (fromPage.equals("chkpatient_id_valid")){ 

			String patient_id_chk=request.getParameter("patient_id");
			String sql_pat_id="Select * from mp_patient where patient_id='"+patient_id_chk+"'";
			rs=stmt.executeQuery(sql_pat_id);
			if(rs !=null && rs.next())
			{%>
			<script>	parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
			</script>
			<%}else
			{%>
				<script>
				alert(getMessage("INVALID_PATIENT","MP"));
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
				parent.frames[1].document.forms[0].patientid.value="";
				</script>
			<%}

	}else if (fromPage.equals("rule_based_patient_val")){ 
	// added by N Munisekhar on 04-May-2012 against [IN:039768]
	        String sql_pat_id="";
			String patient_id=request.getParameter("patient_id");
			apptrefno=request.getParameter("apptrefno");
			String from_page_new=request.getParameter("from_page_new")==null?"":request.getParameter("from_page_new");
			if(patient_id!=null){ 
			 sql_pat_id="Select NAME_PREFIX,FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME,NAME_SUFFIX,NAME_PREFIX_LOC_LANG,FIRST_NAME_LOC_LANG,SECOND_NAME_LOC_LANG,THIRD_NAME_LOC_LANG,FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG, SEX, ACTIVE_YN, SUSPEND_YN, DECEASED_YN, LANGUAGE_ID,CONTACT2_NO ,NATIONALITY_CODE country_id,b.long_desc country_desc,c.long_name language_desc  from mp_patient a, mp_country b,MP_LANGUAGE c where patient_id='"+patient_id+"' and A.NATIONALITY_CODE=B.COUNTRY_CODE(+) and A.LANGUAGE_ID=C.LANG_ID(+) ";
			}// added by N Munisekhar on 04-May-2012 against [IN:039768]
			else if(patient_id==null && apptrefno!="")
			{
		sql_pat_id="SELECT NAME_PREFIX,FIRST_NAME,SECOND_NAME,THIRD_NAME,FAMILY_NAME,NAME_SUFFIX,NAME_PREFIX_LOC_LANG, FIRST_NAME_LOC_LANG, SECOND_NAME_LOC_LANG, THIRD_NAME_LOC_LANG, FAMILY_NAME_LOC_LANG,NAME_SUFFIX_LOC_LANG,gender SEX, LANGUAGE_ID, OTH_CONTACT_NO CONTACT2_NO,NATIONAL_ID_NO country_id, b.long_desc country_desc,c.long_name language_desc FROM oa_appt_del_tr a,mp_country b, mp_language c WHERE a.appt_ref_no ='"+apptrefno+"' AND a.NATIONAL_ID_NO = b.country_code(+) and A.LANGUAGE_ID=C.LANG_ID(+)";
		}
			rs=stmt.executeQuery(sql_pat_id);
			String name_prefix="";
			String first_name="";
			String second_name="";
			String third_name="";
			String family_name="";
			String name_suffix="";
			String name_prefix_loc_lang="";
			String first_name_loc_lang="";
			String second_name_loc_lang="";
			String third_name_loc_lang="";
			String family_name_loc_lang="";
			String name_suffix_loc_lang="";
			String deceased_yn="";
			String suspend_yn="";
			String gender="";
			String contact2_no="";
			String language_id="";
			String language_desc="";
			String country_id="";
			String country_desc="";
			if(rs !=null && rs.next()){
				name_prefix=rs.getString("NAME_PREFIX")==null?"":rs.getString("NAME_PREFIX");
				first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
				second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
				third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
				family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
				name_suffix=rs.getString("NAME_SUFFIX")==null?"":rs.getString("NAME_SUFFIX");
				name_prefix_loc_lang=rs.getString("name_prefix_loc_lang")==null?"":rs.getString("name_prefix_loc_lang");
				first_name_loc_lang=rs.getString("first_name_loc_lang")==null?"":rs.getString("first_name_loc_lang");
				second_name_loc_lang=rs.getString("second_name_loc_lang")==null?"":rs.getString("second_name_loc_lang");
				third_name_loc_lang=rs.getString("third_name_loc_lang")==null?"":rs.getString("third_name_loc_lang");
				family_name_loc_lang=rs.getString("family_name_loc_lang")==null?"":rs.getString("family_name_loc_lang");
				name_suffix_loc_lang=rs.getString("name_suffix_loc_lang")==null?"":rs.getString("name_suffix_loc_lang");
				// added by N Munisekhar on 04-May-2012 against [IN:039768]
				if(patient_id!=null){ 
				deceased_yn=rs.getString("DECEASED_YN")==null?"N":rs.getString("DECEASED_YN");
				suspend_yn=rs.getString("SUSPEND_YN")==null?"N":rs.getString("SUSPEND_YN");
				}
				gender=rs.getString("SEX")==null?"":rs.getString("SEX");
				contact2_no=rs.getString("CONTACT2_NO")==null?"":rs.getString("CONTACT2_NO");
				language_id=rs.getString("language_id")==null?"":rs.getString("language_id");
				language_desc=rs.getString("language_desc")==null?"":rs.getString("language_desc");
				country_id=rs.getString("country_id")==null?"":rs.getString("country_id");
				country_desc=rs.getString("country_desc")==null?"":rs.getString("country_desc");
				if(deceased_yn.equals("Y")){//System.out.println("coming inside one");
					%>
					<script>
						alert(getMessage("PAT_DECEASED_NOT_ALLOWED","MP"));
						if('<%=from_page_new%>'=='' || '<%=from_page_new%>'=='Pending_referral'){
							var frameName="";
							if(parent.f_query_add_mod && parent.f_query_add_mod.querying){
								frameName = "parent.f_query_add_mod.querying";
							}else if(parent.querying){
								frameName = "parent.querying";
							}
							if(eval(frameName).document.schedule_appointment.patient_id){
								eval(frameName).document.schedule_appointment.patient_id.focus();
								eval(frameName).document.schedule_appointment.patient_id.select();
							}
							if(eval(frameName).document.schedule_appointment.name_prefix){
								eval(frameName).document.schedule_appointment.name_prefix.value='';
								eval(frameName).document.schedule_appointment.name_prefix.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.first_name){
								eval(frameName).document.schedule_appointment.first_name.value='';
								eval(frameName).document.schedule_appointment.first_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.second_name){
								eval(frameName).document.schedule_appointment.second_name.value='';
								eval(frameName).document.schedule_appointment.second_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.third_name){
								eval(frameName).document.schedule_appointment.third_name.value='';
								eval(frameName).document.schedule_appointment.third_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.family_name){
								eval(frameName).document.schedule_appointment.family_name.value='';
								eval(frameName).document.schedule_appointment.family_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.name_suffix){
								eval(frameName).document.schedule_appointment.name_suffix.value='';
								eval(frameName).document.schedule_appointment.name_suffix.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.value='';
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.first_name_oth_lang){
								eval(frameName).document.schedule_appointment.first_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.second_name_oth_lang){
								eval(frameName).document.schedule_appointment.second_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.third_name_oth_lang){
								eval(frameName).document.schedule_appointment.third_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.family_name_oth_lang){
								eval(frameName).document.schedule_appointment.family_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.value='';
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.contact_no){
								eval(frameName).document.schedule_appointment.contact_no.value='';
								eval(frameName).document.schedule_appointment.contact_no.disabled=false;
								//if(eval(frameName).document.schedule_appointment.contact_no_gif)
									//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility='visible';
							}
							if(eval(frameName).document.schedule_appointment.gender){
								eval(frameName).document.schedule_appointment.gender.value='';
								eval(frameName).document.schedule_appointment.gender.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.nationality_desc){
								eval(frameName).document.schedule_appointment.nationality_desc.value='';
								eval(frameName).document.schedule_appointment.nationality_desc.disabled=false;
								eval(frameName).document.schedule_appointment.nationality_button.disabled=false;
								eval(frameName).document.schedule_appointment.nationality_code.value='';
							}
							if(eval(frameName).document.schedule_appointment.language_desc){
								eval(frameName).document.schedule_appointment.language_desc.value='';
								eval(frameName).document.schedule_appointment.language_desc.disabled=false;
								eval(frameName).document.schedule_appointment.language_button.disabled=false;
								eval(frameName).document.schedule_appointment.language_code.value='';
							}
						}
					</script>
				<%}else if(suspend_yn.equals("Y")){//System.out.println("coming inside two");
						%>
					<script>
						alert(getMessage("PAT_SUSPENDED_NOT_ALLOWED","MP"));
						if('<%=from_page_new%>'=='' || '<%=from_page_new%>'=='Pending_referral'){
							var frameName="";
							if(parent.f_query_add_mod && parent.f_query_add_mod.querying){
								frameName = "parent.f_query_add_mod.querying";
							}else if(parent.querying){
								frameName = "parent.querying";
							}						
							if(eval(frameName).document.schedule_appointment.patient_id){
								eval(frameName).document.schedule_appointment.patient_id.focus();
								eval(frameName).document.schedule_appointment.patient_id.select();
							}
							if(eval(frameName).document.schedule_appointment.name_prefix){
								eval(frameName).document.schedule_appointment.name_prefix.value='';
								eval(frameName).document.schedule_appointment.name_prefix.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.first_name){
								eval(frameName).document.schedule_appointment.first_name.value='';
								eval(frameName).document.schedule_appointment.first_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.second_name){
								eval(frameName).document.schedule_appointment.second_name.value='';
								eval(frameName).document.schedule_appointment.second_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.third_name){
								eval(frameName).document.schedule_appointment.third_name.value='';
								eval(frameName).document.schedule_appointment.third_name.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.family_name){
								eval(frameName).document.schedule_appointment.family_name.value='';
								eval(frameName).document.schedule_appointment.family_name.disabled=false;
							}						
							if(eval(frameName).document.schedule_appointment.name_suffix){
								eval(frameName).document.schedule_appointment.name_suffix.value='';
								eval(frameName).document.schedule_appointment.name_suffix.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.value='';
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.first_name_oth_lang){
								eval(frameName).document.schedule_appointment.first_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.second_name_oth_lang){
								eval(frameName).document.schedule_appointment.second_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.third_name_oth_lang){
								eval(frameName).document.schedule_appointment.third_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.family_name_oth_lang){
								eval(frameName).document.schedule_appointment.family_name_oth_lang.value='';
								eval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.value='';
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.contact_no){
								eval(frameName).document.schedule_appointment.contact_no.value='';
								eval(frameName).document.schedule_appointment.contact_no.disabled=false;
								//if(eval(frameName).document.schedule_appointment.contact_no_gif)
									//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility='visible';
							}
							if(eval(frameName).document.schedule_appointment.gender){
								eval(frameName).document.schedule_appointment.gender.value='';
								eval(frameName).document.schedule_appointment.gender.disabled=false;
							}
							if(eval(frameName).document.schedule_appointment.nationality_desc){
								eval(frameName).document.schedule_appointment.nationality_desc.value='';
								eval(frameName).document.schedule_appointment.nationality_desc.disabled=false;
								eval(frameName).document.schedule_appointment.nationality_button.disabled=false;
								eval(frameName).document.schedule_appointment.nationality_code.value='';
							}
							if(eval(frameName).document.schedule_appointment.language_desc){
								eval(frameName).document.schedule_appointment.language_desc.value='';
								eval(frameName).document.schedule_appointment.language_desc.disabled=false;
								eval(frameName).document.schedule_appointment.language_button.disabled=false;
								eval(frameName).document.schedule_appointment.language_code.value='';
							}
						}
					</script>
				<%}else{
						%>
					<script>
						if('<%=from_page_new%>'=='' || '<%=from_page_new%>'=='Pending_referral'){
							var frameName="";
							if(parent.f_query_add_mod && parent.f_query_add_mod.querying){
								frameName = "parent.f_query_add_mod.querying";
							}else if(parent.querying){
								frameName = "parent.querying";
							}
							if(eval(frameName).document.schedule_appointment.name_prefix){
								eval(frameName).document.schedule_appointment.name_prefix.value="<%=name_prefix%>";
								eval(frameName).document.schedule_appointment.name_prefix.disabled=true;
							}							
							if(eval(frameName).document.schedule_appointment.first_name){
								eval(frameName).document.schedule_appointment.first_name.value='<%=first_name%>';
								eval(frameName).document.schedule_appointment.first_name.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.second_name){
								eval(frameName).document.schedule_appointment.second_name.value='<%=second_name%>';
								eval(frameName).document.schedule_appointment.second_name.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.third_name){
								eval(frameName).document.schedule_appointment.third_name.value='<%=third_name%>';
								eval(frameName).document.schedule_appointment.third_name.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.family_name){
								eval(frameName).document.schedule_appointment.family_name.value='<%=family_name%>';
								eval(frameName).document.schedule_appointment.family_name.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.name_suffix){
								eval(frameName).document.schedule_appointment.name_suffix.value="<%=name_suffix%>";
								eval(frameName).document.schedule_appointment.name_suffix.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.value="<%=name_prefix_loc_lang%>";
								eval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=true;
							}							
							if(eval(frameName).document.schedule_appointment.first_name_oth_lang){
								eval(frameName).document.schedule_appointment.first_name_oth_lang.value='<%=first_name_loc_lang%>';
								eval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.second_name_oth_lang){
								eval(frameName).document.schedule_appointment.second_name_oth_lang.value='<%=second_name_loc_lang%>';
								eval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.third_name_oth_lang){
								eval(frameName).document.schedule_appointment.third_name_oth_lang.value='<%=third_name_loc_lang%>';
								eval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.family_name_oth_lang){
								eval(frameName).document.schedule_appointment.family_name_oth_lang.value='<%=family_name_loc_lang%>';
								eval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.value="<%=name_suffix_loc_lang%>";
								eval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=true;
							}
							if(eval(frameName).document.schedule_appointment.contact_no){
								eval(frameName).document.schedule_appointment.contact_no.value='<%=contact2_no%>';
								eval(frameName).document.schedule_appointment.contact_no.disabled=true;
								//if(eval(frameName).document.schedule_appointment.contact_no_gif)
									//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility='hidden';
							}
							if(eval(frameName).document.schedule_appointment.gender){
								eval(frameName).document.schedule_appointment.gender.value='<%=gender%>';
								eval(frameName).document.schedule_appointment.gender.disabled=true;
							}

							if(eval(frameName).document.schedule_appointment.nationality_desc){
								eval(frameName).document.schedule_appointment.nationality_desc.value='<%=country_desc%>';
								eval(frameName).document.schedule_appointment.nationality_desc.disabled=true;
								eval(frameName).document.schedule_appointment.nationality_button.disabled=true;
								eval(frameName).document.schedule_appointment.nationality_code.value='<%=country_id%>'
							}

							if(eval(frameName).document.schedule_appointment.language_desc){
								eval(frameName).document.schedule_appointment.language_desc.value='<%=language_desc%>';
								eval(frameName).document.schedule_appointment.language_desc.disabled=true;
								eval(frameName).document.schedule_appointment.language_button.disabled=true;
								eval(frameName).document.schedule_appointment.language_code.value='<%=language_id%>';
							}
						}
					</script>
				<%}%>
				<script>parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
			</script>
			<%}else{%>
				<script>				
				alert(getMessage("INVALID_PATIENT","MP"));			
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
				if('<%=from_page_new%>'==''  || '<%=from_page_new%>'=='Pending_referral'){
							var frameName="";
							if(parent.f_query_add_mod && parent.f_query_add_mod.querying){
								frameName = "parent.f_query_add_mod.querying";
							}else if(parent.querying){
								frameName = "parent.querying";
							}				
					if(eval(frameName).document.schedule_appointment.patient_id){
						eval(frameName).document.schedule_appointment.patient_id.focus();
						eval(frameName).document.schedule_appointment.patient_id.select();
					}
					if(eval(frameName).document.schedule_appointment.name_prefix){
						eval(frameName).document.schedule_appointment.name_prefix.value='';
						eval(frameName).document.schedule_appointment.name_prefix.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.first_name){
						eval(frameName).document.schedule_appointment.first_name.value='';
						eval(frameName).document.schedule_appointment.first_name.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.second_name){
						eval(frameName).document.schedule_appointment.second_name.value='';
						eval(frameName).document.schedule_appointment.second_name.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.third_name){
						eval(frameName).document.schedule_appointment.third_name.value='';
						eval(frameName).document.schedule_appointment.third_name.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.family_name){
						eval(frameName).document.schedule_appointment.family_name.value='';
						eval(frameName).document.schedule_appointment.family_name.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.name_suffix){
						eval(frameName).document.schedule_appointment.name_suffix.value='';
						eval(frameName).document.schedule_appointment.name_suffix.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.name_prefix_oth_lang){
						eval(frameName).document.schedule_appointment.name_prefix_oth_lang.value='';
						eval(frameName).document.schedule_appointment.name_prefix_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.first_name_oth_lang){
						eval(frameName).document.schedule_appointment.first_name_oth_lang.value='';
						eval(frameName).document.schedule_appointment.first_name_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.second_name_oth_lang){
						eval(frameName).document.schedule_appointment.second_name_oth_lang.value='';
						eval(frameName).document.schedule_appointment.second_name_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.third_name_oth_lang){
						eval(frameName).document.schedule_appointment.third_name_oth_lang.value='';
						eval(frameName).document.schedule_appointment.third_name_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.family_name_oth_lang){
						eval(frameName).document.schedule_appointment.family_name_oth_lang.value='';
						eval(frameName).document.schedule_appointment.family_name_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.name_suffix_oth_lang){
						eval(frameName).document.schedule_appointment.name_suffix_oth_lang.value='';
						eval(frameName).document.schedule_appointment.name_suffix_oth_lang.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.contact_no){
						eval(frameName).document.schedule_appointment.contact_no.value='';
						eval(frameName).document.schedule_appointment.contact_no.disabled=false;
						//if(eval(frameName).document.schedule_appointment.contact_no_gif)
							//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility='visible';
					}
					if(eval(frameName).document.schedule_appointment.gender){
						eval(frameName).document.schedule_appointment.gender.value='';
						eval(frameName).document.schedule_appointment.gender.disabled=false;
					}
					if(eval(frameName).document.schedule_appointment.nationality_desc){
						eval(frameName).document.schedule_appointment.nationality_desc.value='';
						eval(frameName).document.schedule_appointment.nationality_desc.disabled=false;
						eval(frameName).document.schedule_appointment.nationality_button.disabled=false;
						eval(frameName).document.schedule_appointment.nationality_code.value='';
					}
					if(eval(frameName).document.schedule_appointment.language_desc){
						eval(frameName).document.schedule_appointment.language_desc.value='';
						eval(frameName).document.schedule_appointment.language_desc.disabled=false;
						eval(frameName).document.schedule_appointment.language_button.disabled=false;
						eval(frameName).document.schedule_appointment.language_code.value='';
					}
				}
				</script>
			<%}
	}else if(fromPage.equals("rule_based_appt")){	
		

		String from_page_new=request.getParameter("from_page_new");		
		String clinic_code=request.getParameter("clinic_code");
		String clinic_date=request.getParameter("clinic_date");
		String pract_id=request.getParameter("pract_id");
		String start_time=request.getParameter("start_time");
		String end_time=request.getParameter("end_time");
		String time_table_type=request.getParameter("time_table_type");

		
			String book_appt_yn ="";
			String book_appt_wo_pid_yn ="";
			String obook_appt_yn ="";
			String book_appt_across_catg_yn ="";
			String tfr_appt_yn ="";
			String tfr_appt_across_catg_yn ="";
			String canc_appt_yn ="";
			String FORCED_BOOK_APPT_YN ="";
			String GLOBAL_BOOK_APPT_YN ="";
			String global_locn_yn ="";
			//String chk_frm_CA="select CARE_LOCN_TYPE_IND from op_clinic where clinic_code='"+clinic_code+"' and facility_id='"+facilityid+"'";
			String sql_access="select book_appt_yn,book_appt_wo_pid_yn,obook_appt_yn,book_appt_across_catg_yn,tfr_appt_yn,tfr_appt_across_catg_yn,canc_appt_yn,FORCED_BOOK_APPT_YN,GLOBAL_BOOK_APPT_YN,global_locn_yn from am_os_user_locn_access_vw  where facility_id=? and locn_code=?  and oper_stn_id=? and appl_user_id=?  and (book_appt_yn='Y' or book_appt_wo_pid_yn='Y' or obook_appt_yn='Y' or book_appt_across_catg_yn='Y' or tfr_appt_yn='Y' or tfr_appt_across_catg_yn='Y' or canc_appt_yn='Y') ";
			pstmt = con.prepareStatement(sql_access);
			pstmt.setString(1,fac_id);
			pstmt.setString(2,clinic_code);
			pstmt.setString(3,oper_stn_id);
			pstmt.setString(4,curr_user_id);
			if(rs !=null) rs.close();
			rs=pstmt.executeQuery();
			if(rs !=null && rs.next()){
				book_appt_yn			= checkForNull(rs.getString("book_appt_yn"));
				book_appt_wo_pid_yn		= checkForNull(rs.getString("book_appt_wo_pid_yn"));
				obook_appt_yn			= checkForNull(rs.getString("obook_appt_yn"));
				book_appt_across_catg_yn= checkForNull(rs.getString("book_appt_across_catg_yn"));
				tfr_appt_yn				= checkForNull(rs.getString("tfr_appt_yn"));
				tfr_appt_across_catg_yn	= checkForNull(rs.getString("tfr_appt_across_catg_yn"));
				canc_appt_yn			= checkForNull(rs.getString("canc_appt_yn"));
				FORCED_BOOK_APPT_YN		= checkForNull(rs.getString("FORCED_BOOK_APPT_YN"));
				GLOBAL_BOOK_APPT_YN		= checkForNull(rs.getString("GLOBAL_BOOK_APPT_YN"));
				global_locn_yn			= checkForNull(rs.getString("global_locn_yn"));
			}
			if(rs !=null) rs.close();
		
			%>
			<script>
				parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num= ";
				var frameName="";
				if(parent.result){
					frameName = "parent.result";
				}else if(parent.f_query_add_mod && parent.f_query_add_mod.result){
					frameName = "parent.f_query_add_mod.result";
				}else if((parent.frames[3])&&(parent.frames[3].result)){
					frameName = "parent.frames[3].result";
				}
				eval(frameName).rule_sch_appt_form.book_appt_yn.value='<%=book_appt_yn%>';
				eval(frameName).rule_sch_appt_form.book_appt_wo_pid_yn.value='<%=book_appt_wo_pid_yn%>';
				eval(frameName).rule_sch_appt_form.book_appt_across_catg_yn.value='<%=book_appt_across_catg_yn%>';
				eval(frameName).rule_sch_appt_form.tfr_appt_yn.value='<%=tfr_appt_yn%>';
				eval(frameName).rule_sch_appt_form.tfr_appt_across_catg_yn.value='<%=tfr_appt_across_catg_yn%>';
				eval(frameName).rule_sch_appt_form.canc_appt_yn.value='<%=canc_appt_yn%>';
				eval(frameName).rule_sch_appt_form.obook_appt_yn.value='<%=obook_appt_yn%>';
				eval(frameName).rule_sch_appt_form.global_locn_yn.value='<%=global_locn_yn%>';
				eval(frameName).rule_sch_appt_form.global_book_appt_yn.value='<%=GLOBAL_BOOK_APPT_YN%>';
				eval(frameName).BookAppointmentModalWindow('<%=clinic_code%>','<%=pract_id%>','<%=start_time%>','<%=end_time%>','<%=time_table_type%>');
			</script>
	<%
	}else if(fromPage.equals("pop_wtlist_data")){
		String waitListNo=request.getParameter("waitListNo");
		String waitListDataSql="Select FIRST_NAME, SECOND_NAME, THIRD_NAME, FAMILY_NAME,GENDER,NATIONALITY_CODE country_id,b.long_desc country_desc/*,LANGUAGE_ID,c.long_name language_desc*/  from pr_wait_list a, mp_country b/*,MP_LANGUAGE c*/ where wait_list_no='"+waitListNo+"' and A.NATIONALITY_CODE=B.COUNTRY_CODE(+) /*and A.LANGUAGE_ID=C.LANG_ID(+)*/";
		
		//System.out.println("waitListDataSql :"+waitListDataSql);
		rs=stmt.executeQuery(waitListDataSql);
		String first_name="";
		String second_name="";
		String third_name="";
		String family_name="";
		String gender="";
		String contact2_no="";
		String language_id="";
		String language_desc="";
		String country_id="";
		String country_desc="";
		if(rs !=null && rs.next()){
			first_name=rs.getString("FIRST_NAME")==null?"":rs.getString("FIRST_NAME");
			second_name=rs.getString("SECOND_NAME")==null?"":rs.getString("SECOND_NAME");
			third_name=rs.getString("THIRD_NAME")==null?"":rs.getString("THIRD_NAME");
			family_name=rs.getString("FAMILY_NAME")==null?"":rs.getString("FAMILY_NAME");
			gender=rs.getString("GENDER")==null?"":rs.getString("GENDER");
			country_id=rs.getString("country_id")==null?"":rs.getString("country_id");
			country_desc=rs.getString("country_desc")==null?"":rs.getString("country_desc");		
		}%>
		<script>
			var frameName="";
			if(parent.f_query_add_mod && parent.f_query_add_mod.querying){
				frameName = "parent.f_query_add_mod.querying";
			}else if(parent.querying){
				frameName = "parent.querying";
			}						
			if(eval(frameName).document.schedule_appointment.first_name){
				eval(frameName).document.schedule_appointment.first_name.value='<%=first_name%>';
				eval(frameName).document.schedule_appointment.first_name.disabled=true;
			}
			if(eval(frameName).document.schedule_appointment.second_name){
				eval(frameName).document.schedule_appointment.second_name.value='<%=second_name%>';
				eval(frameName).document.schedule_appointment.second_name.disabled=true;
			}
			if(eval(frameName).document.schedule_appointment.third_name){
				eval(frameName).document.schedule_appointment.third_name.value='<%=third_name%>';
				eval(frameName).document.schedule_appointment.third_name.disabled=true;
			}
			if(eval(frameName).document.schedule_appointment.family_name){
				eval(frameName).document.schedule_appointment.family_name.value='<%=family_name%>';
				eval(frameName).document.schedule_appointment.family_name.disabled=true;
			}
			if(eval(frameName).document.schedule_appointment.contact_no){
				eval(frameName).document.schedule_appointment.contact_no.value='<%=contact2_no%>';
				eval(frameName).document.schedule_appointment.contact_no.disabled=true;
				//if(eval(frameName).document.schedule_appointment.contact_no_gif)
					//eval(frameName).document.schedule_appointment.contact_no_gif.style.visibility='hidden';
			}
			if(eval(frameName).document.schedule_appointment.gender){
				eval(frameName).document.schedule_appointment.gender.value='<%=gender%>';
				eval(frameName).document.schedule_appointment.gender.disabled=true;
			}

			if(eval(frameName).document.schedule_appointment.nationality_desc){
				eval(frameName).document.schedule_appointment.nationality_desc.value='<%=country_desc%>';
				eval(frameName).document.schedule_appointment.nationality_desc.disabled=true;
				eval(frameName).document.schedule_appointment.nationality_button.disabled=true;
				eval(frameName).document.schedule_appointment.nationality_code.value='<%=country_id%>'
			}

			if(eval(frameName).document.schedule_appointment.language_desc){
				eval(frameName).document.schedule_appointment.language_desc.value='<%=language_desc%>';
				eval(frameName).document.schedule_appointment.language_desc.disabled=true;
				eval(frameName).document.schedule_appointment.language_button.disabled=true;
				eval(frameName).document.schedule_appointment.language_code.value='<%=language_id%>';
			}
		</script>
					
	<%}

	if(rssql1!=null) rssql1.close();
	if (rs!=null) rs.close();
	if(stmt !=null) stmt.close();
	if(stsql2!=null) stsql2.close();
	if(pstmt!=null) pstmt.close();

	if(fromPage.equals("PROC_PRACT_LINK")){
			String  short_desc="";
			String PROC_DESC_SQL="SELECT SHORT_DESC FROM MR_D_"+term_set_id+"_LANG_VW WHERE TERM_CODE = ? AND TERM_SET_ID=? AND LANGUAGE_ID=? ";
			pstmt = con.prepareStatement(PROC_DESC_SQL);
			pstmt.setString(1,proc_code);
			pstmt.setString(2,term_set_id);
			pstmt.setString(3,locale);
			rs=pstmt.executeQuery();
			while(rs.next()){
				short_desc = rs.getString("SHORT_DESC");
			}
			if (rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(short_desc.equals("")){%>
				<script>
					alert(getMessage('MR_INVALID_PROC_CODE','MR'))
					parent.frames[1].document.forms[0].proc_desc.value="";
					parent.frames[1].document.forms[0].proc_code.value="";
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
				</script>
			<%}else{%>
			<SCRIPT LANGUAGE="JavaScript">
			<!--
				parent.frames[1].document.forms[0].proc_desc.value="<%=short_desc%>";
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			//-->
			</SCRIPT>
			<%}
	}

}catch( Exception e ){
	//out.println(e.toString());
	e.printStackTrace();
}
finally{

	if (con!=null) ConnectionManager.returnConnection(con,request);
}
%>		


<%!

public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 		}
	 	}
	 	return function_name;
}
 public static String insertReasonforBiometric(Connection con,String facility_id,String fun_id,String patient_id,String ref_no,String location_code,String reason,String addedworkstation,String user_id) 
	 {
	 	CallableStatement cstmt = null;
	 	String status="E";
	 	try{
	 			StringBuffer sqloa = new StringBuffer() ;
	 			sqloa.append("{call mp_biometric_auth_prc(?,?,?,?,?,?,?,?,?)}");
	 				cstmt = con.prepareCall(sqloa.toString());
	 				cstmt.setString(1, facility_id);
	 				cstmt.setString(2, fun_id);
	 				cstmt.setString(3, patient_id);
	 				cstmt.setString(4, ref_no);
	 				cstmt.setString(5, location_code);
	 				cstmt.setString(6, reason);
	 				cstmt.setString(7, addedworkstation);
	 				cstmt.setString(8, user_id);
	 				cstmt.registerOutParameter(9,java.sql.Types.VARCHAR	);
	 				cstmt.execute();
	 				status = cstmt.getString(9);
	 	}catch(Exception e)
	 	{
	 		status="E";
	 		e.printStackTrace();
	 	}finally
	 	{
	 		try{if(cstmt != null)cstmt.close();}
	 		catch(Exception fe){}
	 	}
	 	return status;
	 }
%>

