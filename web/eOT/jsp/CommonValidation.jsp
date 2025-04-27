
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager,eST.OTTransactionBean,eST.*,eCommon.XSSRequestWrapper,eCommon.Common.*" contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@include file="../../eOT/jsp/StringUtil.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="verifychecklist" class="webbeans.eCommon.RecordSet" scope="session"/>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/> 
 <%
	String locale = (String)session.getAttribute("LOCALE"); 
	String func_mode = request.getParameter("func_mode") ;
	String patient_id	= checkForNull(request.getParameter( "patient_id" )) ;
	String sql			= "";		
	String patient_name	= "";		
	String dob	= "";		
	String sex	= "";
	String sep	= "##";
	String hdr_modified_date = "";
	StringBuilder sbr = new StringBuilder();
	Connection con = null;
	PreparedStatement pstmt  = null;
	PreparedStatement pstmt3  = null;
	ResultSet rst = null;
	ResultSet rst1 = null;
	System.err.println("23,Before try,ComVal.jsp==func_mode==>"+func_mode);
	try{
		con = ConnectionManager.getConnection(request);
	System.err.println("29,try,ComVal.jsp==func_mode==>"+func_mode);
if(func_mode.equalsIgnoreCase("validateElectiveCutOffTime"))
{
		String nature_type				= checkForNull(request.getParameter( "nature_type" )) ;
		String queried_pref_surg_date	= checkForNull(request.getParameter( "queried_pref_surg_date" )) ;
		String order_id					= checkForNull(request.getParameter( "order_id" )) ;		
		String facility_id				= checkForNull(request.getParameter( "facility_id" ));
		String booking_num				= checkForNull(request.getParameter( "booking_num" )) ;		
		//Added against KAUH-SCF-282 Starts Here
		String booking_starttime=checkForNull(request.getParameter( "booking_no" )) ;
		booking_starttime=booking_starttime==null?"":booking_starttime;
		String customerId=checkForNull(request.getParameter( "customerId" )) ;
		customerId=customerId==null?"":customerId;
		//Added against KAUH-SCF-282 Ends Here
		String sql_cutoff				= "";		

		String sql_cut				= "";		
		String null_cutoff_time_yn = "";
		order_id=order_id==null?"":order_id;
		booking_num=booking_num==null?"":booking_num;

		if(order_id.equals("") ) 
		{
		sql_cut = "SELECT NATURE_TYPE FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID =? AND BOOKING_NUM= ?";
				pstmt = con.prepareStatement(sql_cut);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,booking_num);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					nature_type = rst.getString(1);
				}
			}
			else if( (!order_id.equals(""))&&(!booking_num.equals("")) ) 
			{
				sql_cut = "SELECT NATURE_TYPE FROM OT_BOOKING_HDR WHERE OPERATING_FACILITY_ID =? AND BOOKING_NUM= ?";
				pstmt = con.prepareStatement(sql_cut);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,booking_num);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					nature_type = rst.getString(1);
				}
			}
			else if(!order_id.equals(""))
			{
				sql_cutoff = "SELECT TO_CHAR(PREF_SURG_DATE,'DD/MM/YYYY') PREF_SURG_DATE, NATURE_TYPE FROM OT_PENDING_ORDER WHERE ORDER_ID = ?";
				pstmt = con.prepareStatement(sql_cutoff);
				pstmt.setString(1,order_id);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					//queried_pref_surg_date = rst.getString(1);
					nature_type = rst.getString(2);
				}
			}
			if(nature_type!= null && nature_type.equals("EL"))
			{
				String sys_date	= "";
				String sys_next_date	= "";
				String cur_date_diff	= "";
				String date_diff	= "";
				String date_compare = "";
				String date_compare1="";//Added against KAUH-SCF-282	

				//Commented against KAUH-SCF-282
				/*sql_cutoff = "SELECT TO_CHAR(TRUNC(SYSDATE),'DD/MM/YYYY') SYS_DATE,TO_CHAR(TRUNC(SYSDATE+1),'DD/MM/YYYY') SYS_NEXT_DATE,(TRUNC(SYSDATE) - TO_DATE(?,'DD/MM/YYYY')) CUR_DATE_DIFF,(TRUNC(SYSDATE+1) - TO_DATE(?,'DD/MM/YYYY')) DATE_DIFF, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'ISNULL','ISNOTNULL') NULL_CUTOFF_TIME_YN, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'NULL_CUTOFF_TIME',SIGN(SYSDATE-TO_DATE((TO_CHAR(SYSDATE,'DD/MM/YYYY ')||TO_CHAR(CUT_OFF_TIME_FOR_ELEC_CASES,'HH24:MI')),'DD/MM/YYYY HH24:MI'))) DATE_COMPARE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";*/

				//Modified against KAUH-SCF-282
				sql_cutoff = "SELECT TO_CHAR(TRUNC(SYSDATE),'DD/MM/YYYY') SYS_DATE,TO_CHAR(TRUNC(SYSDATE+1),'DD/MM/YYYY') SYS_NEXT_DATE,(TRUNC(SYSDATE) - TO_DATE(?,'DD/MM/YYYY')) CUR_DATE_DIFF,(TRUNC(SYSDATE+1) - TO_DATE(?,'DD/MM/YYYY')) DATE_DIFF, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'ISNULL','ISNOTNULL') NULL_CUTOFF_TIME_YN, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'NULL_CUTOFF_TIME',SIGN(SYSDATE-TO_DATE((TO_CHAR(SYSDATE,'DD/MM/YYYY ')||TO_CHAR(CUT_OFF_TIME_FOR_ELEC_CASES,'HH24:MI')),'DD/MM/YYYY HH24:MI'))) DATE_COMPARE , case  when to_date(TO_CHAR (TRUNC (SYSDATE + 1), 'DD/MM/YYYY')|| ' ' || ?,'dd/mm/yyyy hh24:mi') <= to_Date(TO_CHAR (TRUNC (SYSDATE + 1), 'DD/MM/YYYY')|| ' ' || to_char(cut_off_time_for_elec_cases,'hh24:mi'),'dd/mm/yyyy hh24:mi')  then 1 else 0 end  DATE_COMPARE1 FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";

				if(rst!=null) rst.close();
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql_cutoff);
				pstmt.setString(1,queried_pref_surg_date);
				pstmt.setString(2,queried_pref_surg_date);
				//pstmt.setString(3,facility_id);//Commented against KAUH-SCF-282
				pstmt.setString(3,booking_starttime);//Modified against KAUH-SCF-282
				pstmt.setString(4,facility_id);//Modified against KAUH-SCF-282
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					sys_date = rst.getString("SYS_DATE");
					sys_next_date = rst.getString("SYS_NEXT_DATE");
					cur_date_diff = rst.getString("CUR_DATE_DIFF");
					date_diff = rst.getString("DATE_DIFF");
					null_cutoff_time_yn = rst.getString("NULL_CUTOFF_TIME_YN");
					date_compare = rst.getString("DATE_COMPARE");
					date_compare1=rst.getString("DATE_COMPARE1");//Added against KAUH-SCF-282
				}
				if(sys_date.equals(queried_pref_surg_date)){
					
					if(null_cutoff_time_yn.equals("ISNOTNULL") && date_compare.equals("1") && (cur_date_diff.equals("0"))){
						out.println("CUTOFF_FAILED");
					}
				}
				
				//Modified against KAUH-SCF-282
				if(!customerId.equalsIgnoreCase("KAUH"))
				{
				 if(sys_next_date.equals(queried_pref_surg_date)){
					if(null_cutoff_time_yn.equals("ISNOTNULL") && date_compare.equals("1") && (date_diff.equals("0")) && (date_compare1.equals("0"))){
						out.println("CUTOFF_FAILED");
					}	
				}
				}
				
			}//Nature Type Condition
	
	}else if(func_mode.equalsIgnoreCase("WaitlistElectiveCutOffTime")){	

		//con = ConnectionManager.getConnection();

		String booking_date = request.getParameter( "booking_date" ) ;
		String facilityid	= request.getParameter( "facilityid" ) ;
		String sql_cutoff				= "";		
		String null_cutoff_time_yn = "";
		String sys_date	= "";
		String sys_next_date	= "";
		String cur_date_diff	= "";
		String date_diff	= "";
		String date_compare = "";
			sql_cutoff = "SELECT TO_CHAR(TRUNC(SYSDATE),'DD/MM/YYYY') SYS_DATE,TO_CHAR(TRUNC(SYSDATE+1),'DD/MM/YYYY') SYS_NEXT_DATE,(TRUNC(SYSDATE) - TO_DATE(?,'DD/MM/YYYY')) CUR_DATE_DIFF,(TRUNC(SYSDATE+1) - TO_DATE(?,'DD/MM/YYYY')) DATE_DIFF, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'ISNULL','ISNOTNULL') NULL_CUTOFF_TIME_YN, DECODE(CUT_OFF_TIME_FOR_ELEC_CASES,NULL,'NULL_CUTOFF_TIME',SIGN(SYSDATE-TO_DATE((TO_CHAR(SYSDATE,'DD/MM/YYYY ')||TO_CHAR(CUT_OFF_TIME_FOR_ELEC_CASES,'HH24:MI')),'DD/MM/YYYY HH24:MI'))) DATE_COMPARE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=?";
			if(rst!=null) rst.close();
			if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql_cutoff);
				pstmt.setString(1,booking_date);
				pstmt.setString(2,booking_date);
				pstmt.setString(3,facilityid);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					sys_date = rst.getString("SYS_DATE");
					sys_next_date = rst.getString("SYS_NEXT_DATE");
					cur_date_diff = rst.getString("CUR_DATE_DIFF");
					date_diff = rst.getString("DATE_DIFF");
					null_cutoff_time_yn = rst.getString("NULL_CUTOFF_TIME_YN");
					date_compare = rst.getString("DATE_COMPARE");
				}
				if(sys_date.equals(booking_date)){
					
					if(null_cutoff_time_yn.equals("ISNOTNULL") && date_compare.equals("1") && (cur_date_diff.equals("0"))){
						out.println("CUTOFF_FAILED");
					}
				}else if(sys_next_date.equals(booking_date)){
					
						if(null_cutoff_time_yn.equals("ISNOTNULL") && date_compare.equals("1") && (date_diff.equals("0"))){
						out.println("CUTOFF_FAILED");
					}	
				}
		}else if(func_mode.equalsIgnoreCase("patient_search")){	
			
			
 			 sql = "SELECT DECODE('"+locale+"','en',PATIENT_NAME,NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME) )PATIENT_NAME,TO_CHAR(DATE_OF_BIRTH,'DD/MM/YYYY',DECODE('"+locale+"','th','NLS_CALENDAR=''THAI BUDDHA''','ar','NLS_CALENDAR=''ENGLISH HIJRAH''','NLS_CALENDAR=''GREGORIAN''')) DOB,DECODE(SEX,'M','MALE','F','FEMALE') SEX FROM MP_PATIENT WHERE PATIENT_ID=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,patient_id);
				rst = pstmt.executeQuery();
				int cnt =0;
				while(rst!= null && rst.next()){
					patient_name = checkForNull(rst.getString("PATIENT_NAME"));
					dob = checkForNull(rst.getString("DOB"));
					sex = checkForNull(rst.getString("SEX"));
					//return_val.append(patient_name+"##"+dob+"##"+sex);
					sbr.append(patient_name).append(sep).append(dob).append(sep).append(sex);
					cnt++;
				}
				if(cnt>0) 
					out.println(sbr.toString());
				else 
					out.println("INVALID_PATIENT");
			}
		else if(func_mode.equalsIgnoreCase("updatedoclevel")){	
			
			    String oper_num					= request.getParameter( "oper_num" ) ;	
			    String doc_level				= request.getParameter( "doc_level" ) ;		
		        String facility_id				= request.getParameter( "facility_id" ) ;
		        String modified_date				= request.getParameter( "modified_date" ) ;
					
				if(rst1!=null) rst1.close();
				if(pstmt!=null) pstmt.close();

				String sql_hdr_chk = "SELECT TO_CHAR (modified_date, 'DD/MM/YYYY HH24:MI:SS') modified_date FROM ot_post_oper_hdr WHERE oper_num = '"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
				pstmt=con.prepareStatement(sql_hdr_chk);
				rst1=pstmt.executeQuery();
				if(rst1 !=null && rst1.next()){
					hdr_modified_date= checkForNull(rst1.getString("modified_date"));
				}
				if(rst1!=null) rst1.close();
				if(pstmt!=null) pstmt.close();
			
				if(modified_date.compareTo(hdr_modified_date) > 0)
				{
				String sql_update= "UPDATE OT_POST_OPER_HDR SET DOCUMENTATION_LEVEL = ? AND MODIFIED_DATE = sysdate WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ?";
                  
					if(rst!=null) rst.close();
				    if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement(sql_update);
					pstmt.setString(1,doc_level);// front end value(doc_level) updating OT_POST_OPER_HDR table
					pstmt.setString(2,facility_id);
					pstmt.setString(3,oper_num);
				    int  flag=pstmt.executeUpdate();
					if(flag>0) 
			          {
						con.commit();
					  }
					else
			       {
						con.rollback();
			       }
				   out.println(flag);
				  // System.out.println("if block....");
				}
				else
				{
						//System.out.println("else block....");

						//out.println("<script>alert(\"Resource Busy....:"+hdr_modified_date+"\");</script>");*/


				}
			}else if(func_mode.equalsIgnoreCase("updateDuration")){	
			
			    String duration					= request.getParameter( "duration" ) ;	
		        String facility_id				= request.getParameter( "facility_id" ) ;
				String sql_update= "UPDATE OT_OPER_ROOM SET DURATION = ? WHERE OPERATING_FACILITY_ID = ? ";
                  
					if(rst!=null) rst.close();
				    if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement(sql_update);
					pstmt.setString(1,duration);// front end value(doc_level) updating OT_POST_OPER_HDR table
					pstmt.setString(2,facility_id);
				    int  flag=pstmt.executeUpdate();
					if(flag>0) 
			          {
						con.commit();
					  }
					else
			       {
						con.rollback();
			       }
				   out.println(flag);
	}else if(func_mode.equalsIgnoreCase("Verify_check_list"))
		{
		String final_vals=request.getParameter( "final_vals" );	
		String mode=request.getParameter( "mode" );	
		if(!final_vals.equals(""))
			{
				verifychecklist.putObject(final_vals);
				session.putValue("verifychk_mode",mode);
				out.println("true");
			}else
			{
				out.println("false");
			}
 		}else if(func_mode.equalsIgnoreCase("Verify_check_list_clear_value"))
		{
			verifychecklist.clearAll();
			session.removeAttribute("verifychk_mode");
			
		}else if(func_mode.equalsIgnoreCase("verifychecklist_call"))
		{	
		Statement stmt=null;
		ResultSet rSet=null;
		String speciality_code=request.getParameter( "speciality_code" );
		System.err.println("292,ComVal.jsp==speciality_code=="+speciality_code);
		//con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		String pre_op_check_list ="";
		sql="select PRE_OP_CHECK_LIST from ot_specialities where SPECIALITY_CODE='"+speciality_code+"'";
		System.err.println("297,ComVal.jsp==sql=="+sql);
		rSet = stmt.executeQuery(sql);
		if(rSet !=null && rSet.next())
		{
		pre_op_check_list=rSet.getString(1);
		System.err.println("302,pre_op_check_list=="+pre_op_check_list);
		if(pre_op_check_list ==null) pre_op_check_list="";
		if(!pre_op_check_list.equals(""))
		{
			out.println("true");
		}else
			{
			out.println("false");
			}
		}else
			{
			out.println("false");
			}
		}else if(func_mode.equalsIgnoreCase("verifychecklist_call_post"))
		{	
		Statement stmt=null;
		ResultSet rSet=null;
		String speciality_code=checkForNull(request.getParameter("speciality_code"));
		System.err.println("318,ComVal.jsp==speciality_code=="+speciality_code);
		//con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		String post_op_check_list ="";
		sql="select POST_OP_CHECK_LIST from ot_specialities where SPECIALITY_CODE='"+speciality_code+"'";
		rSet = stmt.executeQuery(sql);
		System.err.println("323,ComVal.jsp==sql=="+sql);
		if(rSet !=null && rSet.next())
		{
		post_op_check_list=checkForNull(rSet.getString(1));

		if(!post_op_check_list.equals(""))
		{
			out.println("true");
		}else{
			out.println("false");
		}
		}else{
			out.println("false");
			}
		}else if(func_mode.equalsIgnoreCase("cancel_oper_chk"))
		{			
		Statement stmt=null;
		ResultSet rSet=null;
		ResultSet rSet1=null;
		ResultSet rSet2=null;
		String oper_num=request.getParameter( "oper_num" );	
		String facility_id	= request.getParameter( "facility_id" ) ;
		String oper_code	= request.getParameter( "oper_code" ) ;
		String specialty_code_all	= request.getParameter( "specialty_code_all" ) ;
		String cur_spec_code	= request.getParameter( "cur_spec_code" ) ;
		//con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		String sql1="";
		String sql2="";
		int count=0;
		int count1=0;
		int count2=0;
		String flag="true";
		String flag1="true";
		String spec_code="";


		sql="select COUNT(*)  from OT_SURGICAL_ACCESSORIES where OPERATING_FACILITY_ID='"+facility_id+"' and OPER_NUM='"+oper_num+"' and oper_code ='"+oper_code+"'";
		rSet=stmt.executeQuery(sql);	
		if(rSet.next())
		{
			count=rSet.getInt(1);

		}
		if(count >0 )
				{
					flag="false";
				}else
				{
				flag="true";
				}

		if(flag.equals("true"))
				{
					StringTokenizer token= new StringTokenizer(specialty_code_all,"*");
					 while(token.hasMoreTokens())
					{
						 spec_code=token.nextToken();
						 if(spec_code.equals(cur_spec_code))
						{
							flag1="true";
						}else
						{
							flag1="false";
						}
					}

					
					

				}


if(flag1.equals("false"))
			{

		sql1="select COUNT(*) from OT_POST_OPER_DTL2 where OPERATING_FACILITY_ID='"+facility_id+"' and OPER_NUM='"+oper_num+"' and SPECIALITY_CODE='"+cur_spec_code+"'";
		sql2="select COUNT(*) from OT_POST_OPER_PERSONNEL where OPERATING_FACILITY_ID='"+facility_id+"' and OPER_NUM='"+oper_num+"' and SPECIALITY_CODE='"+cur_spec_code+"'";

				rSet1=stmt.executeQuery(sql1);	

				if(rSet1 !=null && rSet1.next())
				{
					count1=rSet1.getInt(1);
				}

				rSet2=stmt.executeQuery(sql2);
				if(rSet2 !=null && rSet2.next())
				{
					count2=rSet2.getInt(1);
				}
				if(count1 >0 || count2 >0)
				{
				
					out.println("false");
				}else
				{
					out.println("true");
				}
	
			if(rSet!=null)rSet.close();
			if(rSet1!=null)rSet1.close();
			if(rSet2!=null)rSet2.close();
			}else
			{
				out.println("true");
			}

		}else if(func_mode.equalsIgnoreCase("pick_lict_QOH"))
		{
			String bean_id 				    = "ottransactionbean";
			String bean_name 			    = "eST.OTTransactionBean";
			OTTransactionBean bean	= (OTTransactionBean)getBeanObject(bean_id, bean_name, request ) ;
			String avail_stock="";
			Statement stmt=null;
			ResultSet rset=null;
			stmt = con.createStatement();
			String mm_item_code="";
			String item_id=request.getParameter("item_id");	
			  String store_code	= request.getParameter("store_code") ;
		
			 sql="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
			rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					mm_item_code=rset.getString(1);
					if(mm_item_code ==null) mm_item_code="";
				}
						
			if(!mm_item_code.equals("")  )
			 {
				if(!store_code.equals(""))
				 {
				try 
			 {
			String[] stParameters = {mm_item_code, store_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
			avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			System.err.println("463,avail_stock==="+avail_stock);
			out.println(avail_stock);
			}catch(Exception e)
			 {
				 e.printStackTrace();
				out.println("false");
			 }
			 }
			 }else
			 {
				 out.println("false1");
			 }
			
		}else if(func_mode.equalsIgnoreCase("pick_lict_store_item"))
		{
			String bean_id 				    = "ottransactionbean";
			String bean_name 			    = "eST.OTTransactionBean";
			OTTransactionBean bean	= (OTTransactionBean)getBeanObject(bean_id, bean_name, request ) ;
			String avail_stock="";
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String mm_item_code="";
			String item_id=request.getParameter("item_id");	
			String store_code_desc	= request.getParameter("store_code") ;
             //store_code=store_code.slice("|");
			String iss_store_desc	= request.getParameter("iss_store") ;
		   
		    String store_code="";
		    String store_code1="";
		    String iss_store="";
		    String iss_store1="";
		    /* below code is for splitting Code and Desc  and sending Code to STBean*/
			StringTokenizer store_code_toke = new StringTokenizer(store_code_desc,"|");
			while(store_code_toke.hasMoreTokens())
			{
			 store_code=store_code_toke.nextToken();
			 store_code1=store_code_toke.nextToken();
			}
		    
			StringTokenizer iss_store_toke = new StringTokenizer(iss_store_desc,"|");
			while(iss_store_toke.hasMoreTokens())
			{
			 iss_store=iss_store_toke.nextToken();
			 iss_store1=iss_store_toke.nextToken();
			}
		
			sql="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
			rset=stmt.executeQuery(sql);
	
				if(rset !=null && rset.next())
				{
					mm_item_code=rset.getString(1);
				}				
			if(!item_id.equals("") && !store_code.equals(""))
			 {
				try 
			 {
						
			String[] stParameters = {mm_item_code, store_code, "0", "N", "", "N", iss_store};
			HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
			avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
	//		out.println(avail_stock);
			}catch(Exception e)
			 {
				 e.printStackTrace();
				out.println("false");
			 }
			 }


		}else if(func_mode.equalsIgnoreCase("chkOperRoomChrgeYn"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String hold_area_code=request.getParameter("oper_room_code");
			String oper_room_chk_yn="N";
				 sql="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_HOLDING_AREAS WHERE HOLDING_AREA_CODE ='"+hold_area_code+"' AND OPERATING_FACILITY_ID='"+facility_id+"'   AND NVL(CHARGEABLE_YN,'N') IN (SELECT NVL(CHARGE_HOLDING_AREA_YN,'N') FROM  OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID= '"+facility_id+"' AND  NVL(BL_INTERFACE_FLAG,'N')='Y') ";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					oper_room_chk_yn=rset.getString(1);
				}
    	  out.println(oper_room_chk_yn);
		}else if(func_mode.equalsIgnoreCase("getHoldingAreaCheck"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String holdarea_chk="";
				 sql="select nvl(HOLD_FINALIZATION_STAGE,'X') from ot_param_for_facility where operating_facility_id ='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					holdarea_chk=rset.getString(1);
				}
    	  out.println(holdarea_chk);
		}
		else if(func_mode.equalsIgnoreCase("chkRecRoomChrgeYn"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String recovery_room_code=request.getParameter("recovery_room_code");
			String rec_room_chk_yn="";
				 sql="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_RECOVERY_ROOM_LANG_VW WHERE RECOVERY_ROOM_CODE ='"+recovery_room_code+"' AND OPERATING_FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";

				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					rec_room_chk_yn=rset.getString(1);
				}
    	  out.println(rec_room_chk_yn);
		}else if(func_mode.equalsIgnoreCase("getRecoveryRoomDesc"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String recovery_room_code=request.getParameter("recovery_room_code");
			String rec_room_desc="";
				 sql="SELECT RECOVERY_ROOM_DESC FROM OT_RECOVERY_ROOM_LANG_VW WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND   RECOVERY_ROOM_CODE = '"+recovery_room_code+"' AND LANGUAGE_ID ='"+locale+"'";

				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					rec_room_desc=rset.getString(1);
				}
    	  out.println(rec_room_desc);
		} 
		else if(func_mode.equalsIgnoreCase("getDfltRecCodeAndDesc"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_room_code=request.getParameter("oper_room_code");
			String rec_room_desc="";
			String dflt_recovery_room_code="";
			String rec_dflt_code_desc="";
				 sql="select DFLT_RECOVERY_ROOM_CODE,b.RECOVERY_ROOM_DESC from ot_oper_room a, ot_recovery_room b where a.OPERATING_FACILITY_ID = b.OPERATING_FACILITY_ID and   a.DFLT_RECOVERY_ROOM_CODE = b.RECOVERY_ROOM_CODE and   a.OPERATING_FACILITY_ID= '"+facility_id+"' and   a.OPER_ROOM_CODE  = '"+oper_room_code+"'";

				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					dflt_recovery_room_code=rset.getString(1);
					rec_room_desc=rset.getString(2);
				}
				rec_dflt_code_desc=dflt_recovery_room_code+"##"+rec_room_desc;
    	  out.println(rec_dflt_code_desc);
		}else if(func_mode.equalsIgnoreCase("getChargeRecoveryRoomyn"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String charge_rec_room_yn="";
				 sql="SELECT CHARGE_RECOVERY_ROOM_YN FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					charge_rec_room_yn=rset.getString(1);
				}
    	  out.println(charge_rec_room_yn);
		}else if(func_mode.equalsIgnoreCase("getRecoveryRoomCheck"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String recroom_chk="";
				 sql="select nvl(RECY_ROOM_FINALIZATION_STAGE,'X') from ot_param_for_facility where operating_facility_id='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					recroom_chk=rset.getString(1);
				}
    	  out.println(recroom_chk);
		}else if(func_mode.equalsIgnoreCase("getchkinrecoverytime"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String rec_end_dt_time="";
			/*	 sql="SELECT TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
			*/
				 sql="SELECT TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";

				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					rec_end_dt_time=rset.getString(1);
				}
    	  out.println(rec_end_dt_time);
		}else if(func_mode.equalsIgnoreCase("getChkinrecovery_yn")){
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String chk_in_rec_compl_yn="";
				 sql="SELECT nvl(RECVERY_ROOM_CODE,'X') FROM OT_POST_OPER_HDR  WHERE OPER_NUM='"+oper_num+"'  AND OPERATING_FACILITY_ID='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					chk_in_rec_compl_yn=rset.getString(1);
				}
    	  out.println(chk_in_rec_compl_yn);
		}
		/*else if(func_mode.equalsIgnoreCase("chkHoldingAreaParamSetupChkOutDate")){
			Statement stmt=null;
			ResultSet rset=null;
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String check_hold_fin_stg="";
				sql="SELECT HOLD_FINALIZATION_STAGE FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"' ";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					check_hold_fin_stg=rset.getString(1);
				}
			if(rset !=null rset.close());
			if(stmt !=null stmt.close());
				String sql1="select ";
    		out.println(check_hold_fin_stg);
		}*/
		else if(func_mode.equalsIgnoreCase("getAdminAndSTflag")){
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String st_interface_flag_yn="";
			String rec_surg_accessories_under="";
			String st_admin_flag="";
				 sql="SELECT ST_INTERFACE_FLAG,REC_SURG_ACCESSORIES_UNDER FROM ot_param_for_facility  WHERE  OPERATING_FACILITY_ID='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					st_interface_flag_yn=rset.getString(1);
					rec_surg_accessories_under=rset.getString(2);
				}
				st_admin_flag=st_interface_flag_yn+"##"+rec_surg_accessories_under;
    	  out.println(st_admin_flag);
		}else if(func_mode.equalsIgnoreCase("getErrmsg"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String msg_id=request.getParameter("msg_id");
			
			String err_msg="";
				// sql="SELECT TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";

				
				sql="SELECT NVL(MESSAGE_TEXT,MESSAGE_TEXT_SYSDEF) FROM SM_MESSAGE WHERE MESSAGE_ID = '"+msg_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					err_msg=rset.getString(1);
				}
    	  out.println(err_msg);
		}else if(func_mode.equalsIgnoreCase("checkInTime"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String chk_in_dt_time="";
				 sql="SELECT TO_CHAR(CHECK_IN_TIME,'DD/MM/YYYY HH24:MI') CHECK_IN_TIME FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					chk_in_dt_time=rset.getString(1);
				}
    	  out.println(chk_in_dt_time);
		}else if(func_mode.equalsIgnoreCase("checkInHldingAreaTime"))
		{
			Statement stmt=null;
			ResultSet rset=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String chk_out_holding_area_dt_time="";
				 sql="SELECT TO_CHAR(CHECK_OUT_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_HOLDING_AREA_TIME FROM OT_POST_OPER_HDR WHERE OPER_NUM='"+oper_num+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
				rset=stmt.executeQuery(sql);
				if(rset !=null && rset.next())
				{
					chk_out_holding_area_dt_time=rset.getString(1);
				}
    	  out.println(chk_out_holding_area_dt_time);
		}else if(func_mode.equalsIgnoreCase("picklistdefaultreqvalue"))
		{
			String oper_room_code=request.getParameter("oper_room_code");
				String facilityid=(String)session.getValue("facility_id");
			ResultSet rset=null;
			Statement stmt=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String store_code="";
			String store_desc="";
			String final_val="";
			 sql="SELECT  a.STORE_CODE,b.SHORT_DESC FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND OPERATING_FACILITY_ID='"+facilityid+"' AND OPER_ROOM_CODE='"+oper_room_code+"' AND STORE_TYPE='R' AND  DEFAULT_YN='Y' AND b.language_id='"+locale+"'";

			 rset=stmt.executeQuery(sql);

			if(rset !=null && rset.next())
		{
				store_code=rset.getString("STORE_CODE");
				store_desc=rset.getString("SHORT_DESC");
		final_val=store_code+"|"+store_desc;
		}
 out.println(final_val);

		}else if(func_mode.equalsIgnoreCase("picklistdefaultissuvalue"))
		{
			String oper_room_code=request.getParameter("oper_room_code");
				String facilityid=(String)session.getValue("facility_id");
			ResultSet rset=null;
			Statement stmt=null;
			//con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String store_code="";
			String store_desc="";
			String final_val="";
			 sql="SELECT  a.STORE_CODE,b.SHORT_DESC FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND OPERATING_FACILITY_ID='"+facilityid+"' AND OPER_ROOM_CODE='"+oper_room_code+"' AND STORE_TYPE='I' AND  DEFAULT_YN='Y' AND b.language_id='"+locale+"'";

			 rset=stmt.executeQuery(sql);

			if(rset !=null && rset.next())
		{
				store_code=rset.getString("STORE_CODE");
				store_desc=rset.getString("SHORT_DESC");
		final_val=store_code+"|"+store_desc;
		}
 out.println(final_val);

		}

	else if(func_mode.equals("waitCount")){	
		String surgeon_code = checkForNull(request.getParameter("surgeon_code")) ;
		String speciality_code = checkForNull(request.getParameter("speciality_code")) ;
		String change_from_date = checkForNull(request.getParameter("change_from_date")) ;
		String change_to_date = checkForNull(request.getParameter("change_to_date")) ;
		String facility_id  = (String) session.getAttribute("facility_id");

		String record = "" ;
         sql="select count(*) record from OT_WAITLIST_VW where OPERATING_FACILITY_ID=? and  LANGUAGE_ID=?";		 
			if(!change_from_date.equals(null) && !change_from_date.equals("") && !change_from_date.equals("null") && !change_from_date.equals("undefined")){
				sql=sql+" AND PREFERRED_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')";
			}
			if(!surgeon_code.equals(null) && !surgeon_code.equals("") && !surgeon_code.equals("null") && !surgeon_code.equals("undefined")){
			sql=sql+"AND surgeon_code=?";
			pstmt.setString(3,surgeon_code);

			}
			if(!speciality_code.equals(null) && !speciality_code.equals("") && !speciality_code.equals("null") && !speciality_code.equals("undefined")){
			sql=sql+"AND speciality_code=?";
			pstmt.setString(4,speciality_code);

			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record = checkForNull(rst.getString("record"));
		}
		out.println(record);
	}
	else if(func_mode.equals("rescheduleSearchCount")){	
		String change_theatre_date = checkForNull(request.getParameter("change_theatre_date")) ;
		String surgeon_code = checkForNull(request.getParameter("surgeon_code")) ;
		String facility_id  = (String) session.getAttribute("facility_id");

		String record = "" ;
         sql="select count(*) record from OT_SCHD_OPERS_VW where OPERATING_FACILITY_ID=? and  LANGUAGE_ID=?";		 
			if(!change_theatre_date.equals(null) && !change_theatre_date.equals("") && !change_theatre_date.equals("null") && !change_theatre_date.equals("undefined")){
				sql=sql+" AND APPT_DATE BETWEEN  TO_DATE('"+change_theatre_date+"'||' 00:00','DD/MM/YYYY HH24:MI') AND TO_DATE('"+change_theatre_date+"'||' 23:59','DD/MM/YYYY HH24:MI')";
			}
			if(!surgeon_code.equals(null) && !surgeon_code.equals("") && !surgeon_code.equals("null") && !surgeon_code.equals("undefined")){
			sql=sql+"AND surgeon_code=?";
			pstmt.setString(3,surgeon_code);

			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);

			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record = checkForNull(rst.getString("record"));
		}
		out.println(record);
	}else if(func_mode.equals("cancelTransferCount")){	


		String surgeon_code = checkForNull(request.getParameter("surgeon_code")) ;
		String change_from_date = checkForNull(request.getParameter("change_from_date")) ;
		String change_to_date = checkForNull(request.getParameter("change_to_date")) ;
		String facility_id  = (String) session.getAttribute("facility_id");

		String record = "" ;
         sql="select count(*) record from OT_SCHD_OPERS_VW where OPERATING_FACILITY_ID=? and  LANGUAGE_ID=?";		 
			if(!change_from_date.equals(null) && !change_from_date.equals("") && !change_from_date.equals("null") && !change_from_date.equals("undefined")){
				sql=sql+"AND OPER_STATUS != '99' AND APPT_DATE  BETWEEN TO_DATE(NVL('"+change_from_date+"','01/01/1900')||'00:00', 'DD/MM/YYYY HH24:MI') AND TO_DATE(NVL('"+change_to_date+"','01/01/3000')|| '23:59','DD/MM/YYYY HH24:MI')";
			}
			if(!surgeon_code.equals(null) && !surgeon_code.equals("") && !surgeon_code.equals("null") && !surgeon_code.equals("undefined")){
			sql=sql+"AND surgeon_code=?";
			pstmt.setString(3,surgeon_code);

			}
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locale);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				record = checkForNull(rst.getString("record"));
		}
		out.println(record);
	}
	else if(func_mode.equals("delete_picklist")){	
	//strReq_on_code,strReq_code   REQ_STORE_CODE, REQ_ON_STORE_CODE

		String strReq_code = checkForNull(request.getParameter("strReq_code")) ;		
		//if(strReq_code.equals(""))//Commented by MuthuN
		if(strReq_code.equals("") || strReq_code.equals("undefined")){//Changed by MuthuN against BRU-CRF-268
			strReq_code="X";
		}
		String strReq_on_code = checkForNull(request.getParameter("strReq_on_code")) ;
		//if(strReq_on_code.equals(""))//Commented by MuthuN
		if(strReq_on_code.equals("") || strReq_on_code.equals("undefined")){//Changed by MuthuN against BRU-CRF-268
			strReq_on_code ="X";
		}
		String oper_code = checkForNull(request.getParameter("oper_code")) ;
		String item_type = checkForNull(request.getParameter("item_type")) ;
		String item_id = checkForNull(request.getParameter("item_id")) ;
		String booking_num = checkForNull(request.getParameter("booking_no")) ;
		String facility_id  = (String) session.getAttribute("facility_id");

		int count=0;
//		int i=0;
		
		String sql_chk_rec="select count(*) from OT_PICK_LISTS where  OPERATING_FACILITY_ID='"+facility_id+"' and OPER_CODE ='"+oper_code+"' AND	ITEM_TYPE = '"+item_type+"' AND ITEM_ID = '"+item_id+"' AND BOOKING_NUM='"+booking_num+"' AND nvl(REQ_ON_STORE_CODE,'X')='"+strReq_on_code+"' AND nvl(REQ_STORE_CODE,'X')='"+strReq_code+"'";
		pstmt=con.prepareStatement(sql_chk_rec);
	
		rst1=pstmt.executeQuery();
		if(rst1 !=null && rst1.next())
				{
					count=rst1.getInt(1);
				}

	if(count>0)
		{
		String sql3=" delete from OT_PICK_LISTS where  OPERATING_FACILITY_ID='"+facility_id+"' and OPER_CODE ='"+oper_code+"' AND	ITEM_TYPE = '"+item_type+"' AND ITEM_ID = '"+item_id+"' AND BOOKING_NUM='"+booking_num+"' AND nvl(REQ_ON_STORE_CODE,'X')='"+strReq_on_code+"' AND nvl(REQ_STORE_CODE,'X')='"+strReq_code+"'";
				
		pstmt3=con.prepareCall(sql3);
		pstmt3.execute();
		
			con.commit();
			out.println("true");
		}else
		{
			out.println("false");
		}
		
	}else if(func_mode.equals("holdingChargebleyn")){	
		String oper_num = checkForNull(request.getParameter("oper_num")) ;
		String facility_id  = (String) session.getAttribute("facility_id");
		String chargeable_yn  = "";
		String holding_area_code  = "";

//		int i=0;

		String sql_ha_code="SELECT HOLDING_AREA_CODE FROM   OT_OPER_HOLDING_DTLS WHERE  OPERATING_FACILITY_ID   ='"+facility_id+"' AND OPER_NUM='"+oper_num+"'";

		String sql_ha_chargeableyn="";
		
		pstmt = con.prepareStatement(sql_ha_code);
		rst = pstmt.executeQuery();
		while(rst!=null && rst.next())
	    { 
		holding_area_code=checkForNull(rst.getString("HOLDING_AREA_CODE"));
		 
		 sql_ha_chargeableyn="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_HOLDING_AREAS WHERE HOLDING_AREA_CODE ='"+holding_area_code+"' AND OPERATING_FACILITY_ID='"+facility_id+"'";
		        pstmt3 = con.prepareStatement(sql_ha_chargeableyn);
				rst1=pstmt3.executeQuery();
				if(rst1 !=null && rst1.next())
				{
					chargeable_yn=rst1.getString(1);
				}
				if(("N").equals(chargeable_yn))
                break;
		}
		out.println(chargeable_yn);
	}else if(func_mode.equals("getStoresRoomCode")){	
		String facility_id = checkForNull(request.getParameter("facility_id")) ;
	//	String store_code  = "";
	//	String store_desc = "";
		
		String sql_store_code="SELECT SHORT_DESC,B.STORE_CODE FROM MM_STORE A , ST_STORE B WHERE A.STORE_CODE = B.STORE_CODE AND A.FACILITY_ID = DECODE('"+facility_id +"','ALL',A.FACILITY_ID,'"+facility_id +"')AND A.EFF_STATUS ='E'ORDER BY 1";
		pstmt = con.prepareStatement(sql_store_code);
		rst = pstmt.executeQuery();
//		int i=1;
	}else if(func_mode.equals("picklist_database"))
	{

	String strReq_code = checkForNull(request.getParameter("strReq_code")) ;
		if(strReq_code.equals("")){
			strReq_code="X";
		}
		String strReq_on_code = checkForNull(request.getParameter("strReq_on_code")) ;
		if(strReq_on_code.equals("")){
			strReq_on_code ="X";
		}
		String oper_code = checkForNull(request.getParameter("oper_code")) ;
		String item_type = checkForNull(request.getParameter("item_type")) ;
		String item_id = checkForNull(request.getParameter("item_id")) ;
		String booking_num = checkForNull(request.getParameter("booking_no")) ;
		String facility_id  = (String) session.getAttribute("facility_id");


		int count=0;
	//	int i=0;
		
		String sql_chk_rec="select count(*) from OT_PICK_LISTS where  OPERATING_FACILITY_ID='"+facility_id+"' and OPER_CODE ='"+oper_code+"' AND	ITEM_TYPE = '"+item_type+"' AND ITEM_ID = '"+item_id+"' AND BOOKING_NUM='"+booking_num+"' AND nvl(REQ_ON_STORE_CODE,'X')='"+strReq_on_code+"' AND nvl(REQ_STORE_CODE,'X')='"+strReq_code+"'";
		pstmt=con.prepareStatement(sql_chk_rec);
		
		rst1=pstmt.executeQuery();
		if(rst1 !=null && rst1.next())
				{
					count=rst1.getInt(1);
				}
		
		if(count>0)
		{
			out.println("true");
		}else
		{
			out.println("false");
		}
		


	}else if(func_mode.equals("session_put_val"))
	{
			String function_id	=  checkForNull(request.getParameter("function_id")) ;
			String function_id_old=  (String)session.getAttribute("function_id");
			if(function_id_old ==null) function_id_old="";
	if( !function_id_old.equals(function_id) || function_id_old.equals("")|| function_id_old.equals(null))
		{
	session.putValue("function_id",function_id);

		}

		out.println(function_id_old);
	}else if(func_mode.equals("chkBMIDetails")){	
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		double weight		= Double.parseDouble(request.getParameter("weight"));
		double height		= Double.parseDouble(request.getParameter("height"));
/*		String bmi_details= "";
		String bmi_sql="SELECT BMI BMI1 FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID ='"+facility_id+"'  AND ANAESTHESIA_SERIAL_NUM='"+anesthesia_srl_no+"'";
		pstmt = con.prepareStatement(bmi_sql);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
			bmi_details = checkForNull(rst.getString(1));
			}*/
		double bmi=Math.round((weight/(Math.pow((height/100),2.0))));
		out.println(bmi);

	}else if(func_mode.equals("proc_def_icd"))
		{
			String oper_code	=  checkForNull(request.getParameter("oper_code")) ;
			
			String proc_code="";
			String proc_desc="";
			String coding_scheme="";
			String final_value="";
				String sql_or_cat="SELECT B.SHORT_DESC DESCRIPTION,A.PROC_CODE CODE,A.PROC_CODING_SCHEME CODING_SCHEME FROM OR_ORDER_CATALOG_PROC_LINK A, MR_TERM_CODE B WHERE ORDER_CATALOG_CODE =(SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE = '"+oper_code+"') AND A.PROC_CODING_SCHEME = B.TERM_SET_ID AND A.PROC_CODE = B.TERM_CODE and a.DEFAULT_YN='Y'";
			pstmt=con.prepareStatement(sql_or_cat);

		rst1=pstmt.executeQuery();
		if(rst1 !=null && rst1.next())
				{
					proc_code=rst1.getString(1);
					proc_desc=rst1.getString(2);
					if(proc_desc ==null) proc_desc="";
					coding_scheme=rst1.getString(3);
					final_value=proc_code+"::"+proc_desc+"::"+coding_scheme;
				}else
				{
					final_value="false";
				}
				
				out.println(final_value);

	}
	else if(func_mode.equals("from_direct_booking"))
	{

			String flag_val="";
			String order_catalog_code	=  checkForNull(request.getParameter("order_catalog_code")) ;
			String sql_cat_chk_bl="select bill_yn from or_order_catalog where order_catalog_code ='"+order_catalog_code+"'";
			pstmt=con.prepareStatement(sql_cat_chk_bl);
			System.err.println("sql_cat_chk_bl======"+sql_cat_chk_bl);
		rst1=pstmt.executeQuery();
		if(rst1 !=null && rst1.next())
				{
					flag_val=rst1.getString("bill_yn");
			}
				
		out.println(flag_val);
	
	}else if(func_mode.equals("getEncIdPatClass"))
	{

			String enc_id="";
			String pat_class="";
			String concat_str="";
			//String oper_num		=  checkForNull(request.getParameter("oper_num")) ;
			//String facility_id	=  checkForNull(request.getParameter("facility_id")) ;
			String sql_enc_pat	=  checkForNull(request.getParameter("sql"));
			if(pstmt!=null)pstmt.close();
			if(rst1!=null) rst1.close();
			pstmt=con.prepareStatement(sql_enc_pat);
			rst1=pstmt.executeQuery();
			if(rst1 !=null && rst1.next())
			{
					enc_id=rst1.getString("encounter_id");
					pat_class=rst1.getString("patient_class");
			}
			concat_str=	enc_id+"&&"+pat_class;
			out.println(concat_str);
	
	}else if(func_mode.equals("check_surg_notes"))
	{
		String contr_mod_accession_num		=  checkForNull(request.getParameter("contr_mod_accession_num")) ;
		String facility_id	=  checkForNull(request.getParameter("facility_id"));
		int count=0;
		String flag="true";
			String sql_surg_note="select count(*) from CA_ENCNTR_NOTE where Facility_id='"+facility_id+"' and Event_Status != '9' and CONTR_MOD_ACCESSION_NUM='"+contr_mod_accession_num+"'"; //added by Sanjay for Surgeon Notes against IN34391
	pstmt=con.prepareStatement(sql_surg_note);
			
		rst1=pstmt.executeQuery();
		if(rst1 !=null && rst1.next())
				{
					count=rst1.getInt(1);
				}
			//flag="false";//sanjay
			
			if(count >0)
			{
				flag="true";
			}else
			{
				flag="false";
			}
			
out.println(flag);
		
	}
	else if(func_mode.equals("validateChkInDate"))
	{
		if(rst!=null) rst.close();
		if(pstmt!=null)pstmt.close();
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String order_id = checkForNull(request.getParameter("order_id"));
		String sql_appt_date="SELECT TO_CHAR(APPT_DATE,'DD/MM/YYYY')appt_date FROM OT_QUEUE where order_id='"+order_id+"' AND OPERATING_FACILITY_ID ='"+facility_id+"'";
		pstmt=con.prepareStatement(sql_appt_date);
		System.out.println("sql_appt_date");
		rst=pstmt.executeQuery();
		System.out.println("rst===="+rst);
		String appt_date="";
		if(rst !=null && rst.next()){
			appt_date=rst.getString("appt_date");
			System.out.println(":appt_date:"+appt_date);
		}	
		out.println(appt_date);
	}
	else if(func_mode.equals("callCatalogCode"))
	{
			String catalog_code="";
			String oper_num		=  checkForNull(request.getParameter("oper_code")) ;
			String sql_catalog="SELECT ORDER_CATALOG_CODE FROM OT_OPER_MAST WHERE OPER_CODE ='"+oper_num+"' ";
			if(pstmt!=null)pstmt.close();
			if(rst1!=null) rst1.close();
			pstmt=con.prepareStatement(sql_catalog);
			rst1=pstmt.executeQuery();
			if(rst1 !=null && rst1.next())
			{
					catalog_code=rst1.getString("ORDER_CATALOG_CODE");
			}
			out.println(catalog_code);
	}
	else if(func_mode.equalsIgnoreCase("duplPatientIdSearch")) //PMG2014-CRF-0024 Start
	{
		String facilityId = checkForNull(request.getParameter( "facilityId" ));
		String schedFlag = "N";
		String unSchedFlag = "N";
		String chkFlagVal = "";
		String chkFlagVal2 ="";
		String outValue = "";
		int index = 0;

		StringBuffer schedUnschedChkSqlBuffer = new StringBuffer();
		schedUnschedChkSqlBuffer.append("	SELECT   SUM (schedule) schedule, SUM (unschedule) unschedule	");
		schedUnschedChkSqlBuffer.append("	FROM (SELECT   patient_id,	");
		schedUnschedChkSqlBuffer.append("	CASE WHEN appt_yn = 'Y' AND oper_status NOT IN ('65', '70', '99') THEN COUNT (*)	");
		schedUnschedChkSqlBuffer.append("	ELSE 0 ");
		schedUnschedChkSqlBuffer.append("	END schedule,");
		schedUnschedChkSqlBuffer.append("	CASE WHEN appt_yn = 'N' AND oper_status NOT IN ('65', '70', '99') THEN COUNT (*) 	");
		schedUnschedChkSqlBuffer.append("	ELSE 0 ");
		schedUnschedChkSqlBuffer.append("	END unschedule");
		schedUnschedChkSqlBuffer.append("	FROM ot_queue");
		schedUnschedChkSqlBuffer.append("	WHERE patient_id = ? and OPERATING_FACILITY_ID = ?	");
		schedUnschedChkSqlBuffer.append("	AND (   TO_CHAR (oper_date, 'DD/MM/YYYY') = TO_CHAR (trunc(sysdate), 'DD/MM/YYYY')");
		schedUnschedChkSqlBuffer.append("	OR TO_CHAR (appt_date, 'DD/MM/YYYY') = TO_CHAR (trunc(sysdate), 'DD/MM/YYYY')");
		schedUnschedChkSqlBuffer.append("	)	");
		schedUnschedChkSqlBuffer.append("	GROUP BY patient_id, appt_yn, oper_status)");
		schedUnschedChkSqlBuffer.append("	GROUP BY patient_id");
		System.err.println("schedUnschedChkSqlBuffer : "+schedUnschedChkSqlBuffer+" facilityId :"+facilityId);
		pstmt = con.prepareStatement(schedUnschedChkSqlBuffer.toString());
		pstmt.setString(++index, patient_id);
		pstmt.setString(++index, facilityId);
		rst = pstmt.executeQuery();
		if(rst.isBeforeFirst())
		{
			if(rst!=null && rst.next())
			{
				chkFlagVal = rst.getString("schedule");
				
				if(chkFlagVal.equals("0"))
					schedFlag="N";
				else
					schedFlag="Y";
				chkFlagVal2=rst.getString("unschedule");
				
				if(chkFlagVal2.equals("0"))
					unSchedFlag="N"	;
				else
					unSchedFlag="Y";
				}
			outValue = "REC_EXIST"+"~"+schedFlag+"~"+unSchedFlag;
			System.out.println("outValue : "+outValue);
			out.println(outValue);
		}
		else
			out.println("");
	}//PMG2014-CRF-0024 
	else if(func_mode.equalsIgnoreCase("check_record_surg_notes"))//PMG2014-MOD-CRF-0005 start
	{
		String oper_num		=  checkForNull(request.getParameter("oper_num")) ;
		String facility_id	=  checkForNull(request.getParameter("facility_id"));
		String spec_code	=	checkForNull(request.getParameter("spec_code"));
		String oper_code	=	checkForNull(request.getParameter("oper_code"));
		String contr_mod_accession_num=checkForNull(request.getParameter("contr_mod_accession_num"));
		
		StringBuffer record_surg_notes=new StringBuffer();
		int count=0;
		String flag="true";
		int index = 0;
		
		StringBuffer sql_recorc_surg_note=new StringBuffer();
				
		sql_recorc_surg_note.append("	SELECT RCOUNT, TAB_NAME FROM(	");
		sql_recorc_surg_note.append("	SELECT COUNT(*) RCOUNT, 'eOT.PersonnelDetails.Label' TAB_NAME FROM OT_POST_OPER_PERSONNEL WHERE OPER_NUM = ? AND SPECIALITY_CODE = ? AND OPERATING_FACILITY_ID=?	");
		sql_recorc_surg_note.append("	UNION ALL	");
		sql_recorc_surg_note.append("	SELECT COUNT(*) RCOUNT, 'eOT.TimeandDetails.Label' TAB_NAME FROM OT_POST_OPER_DTL2 WHERE OPER_NUM = ? AND SPECIALITY_CODE = ? and OPERATING_FACILITY_ID=?	");
		sql_recorc_surg_note.append("	AND ( anest_proc_start_time IS NULL OR anest_proc_start_time IS NOT NULL  OR anest_proc_end_time IS NULL OR anest_proc_end_time IS NOT NULL OR anest_start_time IS NULL OR anest_start_time IS NOT NULL OR anest_end_time IS NULL OR anest_end_time IS NOT NULL OR surg_start_time IS NULL       OR surg_start_time IS NOT NULL OR surg_end_time IS NULL OR surg_end_time IS NOT NULL )");
		sql_recorc_surg_note.append("	UNION	");
		sql_recorc_surg_note.append("	SELECT COUNT(*), 'eOT.WoundDetails.Label' TAB_NAME FROM OT_POST_OPER_DTL2 WHERE OPER_NUM = ? AND SPECIALITY_CODE = ? and OPERATING_FACILITY_ID=?	");
		sql_recorc_surg_note.append("	AND WOUND_TYPE IS NOT NULL	");
		sql_recorc_surg_note.append("	UNION	");
		sql_recorc_surg_note.append("	SELECT COUNT(*), 'eOT.VisitingPersonnel.Label' TAB_NAME FROM OT_POST_OPER_DTL2 WHERE OPER_NUM = ? AND SPECIALITY_CODE = ? and OPERATING_FACILITY_ID=?	");
		sql_recorc_surg_note.append("	AND VISITING_PERSONNEL IS NOT NULL	");
		sql_recorc_surg_note.append("	UNION	");
		sql_recorc_surg_note.append("	SELECT COUNT(*) RCOUNT, 'eOT.SurgicalAccessories.Label' TAB_NAME FROM OT_SURGICAL_ACCESSORIES WHERE OPER_NUM = ? and OPERATING_FACILITY_ID=? and ACCESSORY_TYPE ='S' AND OPER_CODE = ?	 ");
		sql_recorc_surg_note.append("	UNION	");
		sql_recorc_surg_note.append("	SELECT COUNT(*) RCOUNT, 'eOT.SurgicalAccessories.Label' TAB_NAME FROM ot_oper_prosthesis WHERE  MODIFIED_FACILITY_ID=?  and (OPER_CODE = ? or SPECIALITY_CODE = ?)");
		sql_recorc_surg_note.append("	UNION	");
		sql_recorc_surg_note.append("	select count(*), 'Common.notes.label' TAB_NAME from CA_ENCNTR_NOTE where Facility_id=? and Event_Status != '9' and CONTR_MOD_ACCESSION_NUM=?	");
		sql_recorc_surg_note.append("	) where RCOUNT>0	");

		pstmt=con.prepareStatement(sql_recorc_surg_note.toString());

		pstmt.setString(++index,oper_num);
		pstmt.setString(++index,spec_code);
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,oper_num);
		pstmt.setString(++index,spec_code);
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,oper_num);
		pstmt.setString(++index,spec_code);
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,oper_num);
		pstmt.setString(++index,spec_code);
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,oper_num);
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,oper_code);//added against 54692		
		pstmt.setString(++index,facility_id);//added against 54692
		pstmt.setString(++index,oper_code);//added against 54692
		pstmt.setString(++index,spec_code);//added against 54692
		pstmt.setString(++index,facility_id);
		pstmt.setString(++index,contr_mod_accession_num);

		rst1=pstmt.executeQuery();

		while(rst1.next())
		{
			record_surg_notes.append(rst1.getString("TAB_NAME")).append(",");
		}
		out.println(record_surg_notes.toString());
	}
	//PMG2014-MOD-CRF-0005 End
	//PMG MOD CRF-24 US-3 START	
	else if(func_mode.equals("getPatientId"))
	{
			String patientId = "";
			int index = 0;
			StringBuffer getPatientIdBuffer = new StringBuffer();
			String orderId = checkForNull(request.getParameter("orderId")) ;
			String facility_id	=  checkForNull(request.getParameter("facilityId"));

			getPatientIdBuffer.append("	SELECT patient_id ");
			getPatientIdBuffer.append("	FROM ot_pending_order ");
			getPatientIdBuffer.append("	WHERE performing_facility_id = ? AND order_id = ? ");

			
			pstmt = con.prepareStatement(getPatientIdBuffer.toString());
			pstmt.setString(++index,facility_id );
			pstmt.setString(++index, orderId);
			rst1 = pstmt.executeQuery();
			
			if(rst1.next()){
			
					patientId = rst1.getString("patient_id");
					}
									
		out.println(patientId);
	}
	//PMG MOD CRF-24 US-3 END
	//ML-BRU-SCF-1550 Start	
	else if(func_mode.equals("check_modified_surgeon_note_Date"))
	{
			String status="YES";			
			String contr_mod_accession_num="";
			String modified_Surgeon_Note_Date=request.getParameter("modified_Surgeon_Note_Date");
			String facility_id=request.getParameter("facility_id");
			String oper_num=request.getParameter("oper_num");
			String modified_Surgeon_Note_Date_arr[]=null;
			
			modified_Surgeon_Note_Date_arr=modified_Surgeon_Note_Date.split("~");			
			contr_mod_accession_num=facility_id+""+oper_num;	
			
			int index = 0,i=0;
			while(i<modified_Surgeon_Note_Date_arr.length){
			StringBuffer Check_Date = new StringBuffer();			
			
			index=0;
			Check_Date.append("	select CONTR_MOD_ACCESSION_NUM, LAST_AMENDED_DATE_TIME	");
			Check_Date.append("	from  CA_ENCNTR_NOTE	");
			Check_Date.append("	where CONTR_MOD_ACCESSION_NUM	like ? and LAST_AMENDED_DATE_TIME=	");
			Check_Date.append("	TO_TIMESTAMP (?, 'yyyy-mm-dd HH24:MI:SS')");			
			pstmt = con.prepareStatement(Check_Date.toString());
			
			pstmt.setString(1,contr_mod_accession_num+"%");
			pstmt.setString(2, modified_Surgeon_Note_Date_arr[i]);
			rst1 = pstmt.executeQuery();			
			if(rst1.next()){			
					//status = "YES";
					}
				else{
					status="NO";
				}
					i++;
				}									
		out.println(status);
	}	
	/* Added start against for MO-GN-5505 [IN058517] */
	else if(func_mode.equals("getCustomerId"))
	{
			String flag = "";
			int index = 0;
			int count = 0;
			StringBuffer getPatientIdBuffer = new StringBuffer();
			String oper_num = request.getParameter("oper_num") ;
			String facility_id	= request.getParameter("facility_id");
			getPatientIdBuffer.append("	SELECT COUNT(*) ");
			getPatientIdBuffer.append("	FROM OT_POST_OPER_PERSONNEL ");
			getPatientIdBuffer.append("	WHERE OPERATING_FACILITY_ID = ? AND OPER_NUM = ? ");
			pstmt = con.prepareStatement(getPatientIdBuffer.toString());
			pstmt.setString(++index,facility_id );
			pstmt.setString(++index, oper_num);
			rst1 = pstmt.executeQuery();
			if(rst1.next()){
				count = rst1.getInt(1);
			}
			if(count > 0 )
		 	flag="true";
			if(count == 0 )
			flag="false";		
		out.println(flag);
	}
	/* Added end against for MO-GN-5505 [IN058517] */
		//Added against PMG2016-KDAH-CRF-0001 
	else if(func_mode.equals("isOTAvailable")){
		try{
			String oper_room_code=request.getParameter("oper_room_code");
			String check_in_date_time=request.getParameter("check_in_date_time");
			String facility_id=request.getParameter("facility_id");		
			String oper_num=checkForNull(request.getParameter("oper_num"));
			String called_from=checkForNull(request.getParameter("called_from"));
			
			if(oper_num=="undefined"){
				System.err.println("if");
			}
			if(oper_num.equals("undefined")){
				System.err.println("if 2");
				oper_num="";
			}
			System.err.println("oper_num===>"+oper_num);
			StringBuffer ot_availabel_query=new StringBuffer();
			
			ot_availabel_query.append("	SELECT 1	");
			ot_availabel_query.append("	FROM ot_post_oper_hdr	");
			ot_availabel_query.append("	WHERE TO_DATE (nvl(?,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')), 'DD/MM/YYYY HH24:MI') BETWEEN check_in_time	");
			ot_availabel_query.append("	AND NVL	");
			ot_availabel_query.append("	(check_out_time,	");
			ot_availabel_query.append("	TO_DATE	");
			ot_availabel_query.append("	('31/12/9999 23:59',	");
			ot_availabel_query.append("	'DD/MM/YYYY HH24:MI'	");
			ot_availabel_query.append("	)	");
			ot_availabel_query.append("	)	");
			ot_availabel_query.append("	AND oper_room_code = ?		");
			ot_availabel_query.append("	AND oper_status != '99'		");
			ot_availabel_query.append("	AND TRUNC (check_in_time) = trunc(TO_DATE (nvl(?,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')), 'DD/MM/YYYY HH24:MI'))	");
			ot_availabel_query.append("	AND  operating_facility_id=?	");
			if(!oper_num.equals("")){
				ot_availabel_query.append("	AND oper_num!=?");
				if(called_from.equals("Check_Out_From_OR")){
				ot_availabel_query.append("	AND check_in_time >(select check_in_time from ot_post_oper_hdr where oper_num=? and operating_facility_id=?	)	");
				}
			}
			
			pstmt = con.prepareStatement(ot_availabel_query.toString());
			System.err.println(ot_availabel_query.toString());
			pstmt.setString(1,check_in_date_time);
			pstmt.setString(2,oper_room_code);
			pstmt.setString(3,check_in_date_time);
			pstmt.setString(4,facility_id);
			
			if(!oper_num.equals("") ){
				pstmt.setString(5,oper_num);
				if(called_from.equals("Check_Out_From_OR")){
				pstmt.setString(6,oper_num);
				pstmt.setString(7,facility_id);
				}
				System.err.println("1420");
			}
			
			System.err.println("psmt--->"+pstmt.toString());
			rst1 = pstmt.executeQuery();
			
			String result="";
			if(rst1.next()){
					result=rst1.getString(1);
					
					}
									
		out.println(result);
			
		}catch(Exception e){
			e.printStackTrace();
			}
		
	}
	//Added against PMG2016-KDAH-CRF-0001 Ends
	}catch(Exception e){
			e.printStackTrace();
			//System.err.println("Err Msg from CommonValidation.jsp :"+e);
		}
		finally{
			if(sbr!=null)sbr.setLength(0);
			if(rst!=null) rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null) con.close();
		}
%>

