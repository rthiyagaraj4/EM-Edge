<%@page import="java.util.*, ePH.Common.*, ePH.* " contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String dcode				= request.getParameter( "dispense_code" ) ;
	String function			=request.getParameter("function");
	String scheduleStartTime1= null;
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;

	IpFillBean bean = (IpFillBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(!function.equals("GENERATEFILLLIST") && !function.equals("assignAltDrug") && !function.equals("assignBtchDtls")){
		bean.clear();
	}
	if (function.equals("DispenseLocationSelect")){

		String fillPeriod		= "0";
		String fillHrs			= "0";
		String fill_period_hr	= "0";
		String scheduleStartTime= null;
		String cDate=null,cMonth= null,cYear=null,cHours=null,cMinutes=null;
		String fillPeriodUnit	= null;
		String ip_fill_allocate_bathces_yn= "N";
		String rfinvoked		= "N";
		String incstarttime		= "";
		String incendtime		= "";
		String incendtime1		= "";
		String rtnstarttime		= "";
		String rtnendtime		= "";
		String tmp_start_date_time = "";
		String schedule_start	= "";
		HashMap	eff_date_time	=null;
		//Get building list for the particular dispenselocation
		bean.setDispenseLocation(dcode);
		ArrayList buildingList=bean.getBuildingList();
		ArrayList fillPeriodList=bean.getFillPeriods();
		String temp_fill_prd_ahead = "";
		if (fillPeriodList.size()!=0){
			fillPeriod			=(String)fillPeriodList.get(0);
			temp_fill_prd_ahead = fillPeriod;
			fillHrs				=(String)fillPeriodList.get(1);
			scheduleStartTime	=(String)fillPeriodList.get(2);
			tmp_start_date_time = scheduleStartTime;
			cDate				=(String)fillPeriodList.get(3);
			cMonth				=(String)fillPeriodList.get(4);
			cYear				=(String)fillPeriodList.get(5);
			cHours				=(String)fillPeriodList.get(6);
			cMinutes			=(String)fillPeriodList.get(7);
			fillPeriodUnit		=(String)fillPeriodList.get(8);
			ip_fill_allocate_bathces_yn	=(String)fillPeriodList.get(9);
			rtnstarttime		=(String)fillPeriodList.get(10);
			rtnendtime			=(String)fillPeriodList.get(11);
			incstarttime		=(String)fillPeriodList.get(12);
			incendtime			=(String)fillPeriodList.get(13);
			rfinvoked			=(String)fillPeriodList.get(14);
			incendtime1=incendtime;
		}
		 eff_date_time  =  bean.getNextEffStartDateEndDate(scheduleStartTime);
		 if(eff_date_time.size()==0) {
		   eff_date_time  =  bean.getEffStartDateEndDate(scheduleStartTime);
		 }
           if(buildingList.size()>0){
				out.println("clearData('formPHGenerateFillList.Building_Code');") ;
				out.println("addData('','           ---Select---','formPHGenerateFillList.Building_Code');");
				for (int i=0; i<buildingList.size(); i+=2) {
					out.println("addData('"+ buildingList.get(i) + "', \"" +buildingList.get(i+1) +"\", 'document.formPHGenerateFillList.Building_Code');") ;
				} 
		   }
		if(eff_date_time!=null && eff_date_time.size()>0){
			scheduleStartTime = (String)eff_date_time.get("EFF_START_DATE");
			rtnstarttime	  = (String)eff_date_time.get("EFF_START_DATE");
			rtnendtime		  = (String)eff_date_time.get("EFF_END_DATE");
			incstarttime	  = (String)eff_date_time.get("EFF_START_DATE");
			incendtime		  = (String)eff_date_time.get("EFF_END_DATE");
			
			out.println("formPHGenerateFillList.temp_fill_prd_ahead.value='"+temp_fill_prd_ahead+"';");
			out.println("formPHGenerateFillList.Default_Fill_Period.value=24;");
			out.println("formPHGenerateFillList.Fill_Period_Unit.value='"+fillPeriodUnit+"';");
			out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+scheduleStartTime+"';");
			out.println("formPHGenerateFillList.Exclude_Hrs.value='"+fillHrs+"';");
			out.println("formPHGenerateFillList.Disp_Locn.value='"+dcode+"';");
			out.println("formPHGenerateFillList.cDate.value='"+cDate+"';");
			out.println("formPHGenerateFillList.cMonth.value='"+cMonth+"';");
			out.println("formPHGenerateFillList.cYear.value='"+cYear+"';");
			out.println("formPHGenerateFillList.cHours.value='"+cHours+"';");
			out.println("formPHGenerateFillList.cMinutes.value='"+cMinutes+"';");
			out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+rtnstarttime+"';");
			out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+rtnendtime+"';");
			out.println("formPHGenerateFillList.routinefillalreadyinvoked.value='"+rfinvoked+"';");
			if (ip_fill_allocate_bathces_yn.equals("Y")){
				out.println("formPHGenerateFillList.allocate_during_fill_yn.checked=true");
			}else{
				out.println("formPHGenerateFillList.allocate_during_fill_yn.checked=false");
			}
			out.println("formPHGenerateFillList.ip_fill_excl_prd_behind.value='"+fillHrs+"';");
			  
			  if(fillPeriodUnit.equals("H")){
			   fill_period_hr = ((Integer.parseInt(fillPeriod)/24)-1)+"";
			   }else if(fillPeriodUnit.equals("D")){
			   fill_period_hr =(Integer.parseInt(fillPeriod)-1)+"";
			   }

			//out.println("formPHGenerateFillList.Ip_Fill_Prd_Ahead.value='"+fillPeriod+"';");
			out.println("formPHGenerateFillList.Ip_Fill_Prd_Ahead.selectedIndex='"+fill_period_hr+"';");	out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate(scheduleStartTime,"DMYHM","en",locale)+"';");
			out.println("formPHGenerateFillList.incstarttime.value='"+incstarttime+"';");
			out.println("formPHGenerateFillList.incendtime.value='"+incendtime+"';");
			
		   try{
				String disp_locn_code = request.getParameter("dispense_code");
				HashMap result  =  bean.getNextRoutineEffStartDateEndDate(tmp_start_date_time,fillPeriod,disp_locn_code,schedule_start);
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("EFF_START_DATE")+"';");
				out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("EFF_START_DATE")+"';");
				out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				
				 if(fillPeriodUnit.equals("H")){	
				 out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
				 }else if(fillPeriodUnit.equals("D")){
                 out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate(incendtime1,"DMYHM","en",locale)+"';");
				 }
				//out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}else if (function.equals("CalculateTime")){
			ArrayList currTime = bean.getCurrentTime() ;
			if (currTime.size()>0){
				// store the curr hours and minutes into hidden variables in the calling form
				out.println("document.formPHGenerateFillList.currHours.value="+currTime.get(0)) ;
				out.println("document.formPHGenerateFillList.currMinutes.value="+currTime.get(1)) ;
			}
		}else if (function.equals("BuildingandFloors")){
			String val = request.getParameter( "building_code" ) ;
			ArrayList floorList = bean.getFloorList(val) ;
			if (floorList.size()==0){
				out.println("clearData('document.formPHGenerateFillList.Floor_Code');") ;
			}
			out.println("addData('','           ---Select---','document.formPHGenerateFillList.Floor_Code');");
			for (int ii=0; ii<floorList.size(); ii+=2) {
				out.println("addData('"+ floorList.get(ii) + "', '" + floorList.get(ii+1) +"', 'document.formPHGenerateFillList.Floor_Code');") ;
			}
		}else if (function.equals("FindEndTime")){
			String incstartdate		 = request.getParameter( "incstartdate" ) ;
			String incstartdatetmp   = incstartdate;
			String fillperiod		 = request.getParameter( "fillperiod" ) ;
			String disp_locn_code	 = request.getParameter( "disp_locn_code");
				   incstartdate      = bean.compareDates(incstartdate);
			String proc_type		 = request.getParameter( "proc_type");
			String schedule_start	 = request.getParameter("schedule_start");

		 
		   
		   if(proc_type.equals("R")){
			    HashMap result  =  bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start);
			   
			   out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("EFF_START_DATE")+"';");
			   out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("EFF_START_DATE")+"';");
			   if(!disp_locn_code.equals("")){
				 out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
			   out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
			   }
			   out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
		   }else if(proc_type.equals("I")){
				if(!bean.isGreaterThanSysdate(incstartdate)){
					incstartdate = 	incstartdatetmp;
				}
				
				HashMap eff_date_time  =  bean.getEffStartDateEndDate(scheduleStartTime1);

				disp_locn_code = request.getParameter( "disp_locn_code");
				HashMap result = bean.getStartTime(disp_locn_code,fillperiod,schedule_start);

				 HashMap result1  =  bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start,true);
			    
				
				if(result!=null && result.size()>0){
					//out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("STARTDATE")+"';");
					out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("SCHEDULE_START")+"';");
					out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("SCHEDULE_START"),"DMYHM","en",locale)+"';");
					out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("STARTDATE"),"DMYHM","en",locale)+"';");
					//out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)eff_date_time.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
					out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result1.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
				}
				
		   }
		}else if(function.equals("FindStartTime")){	
			String disp_locn_code = request.getParameter( "disp_locn_code");
			String fillperiod	  = request.getParameter( "fillperiod" ) ;
			String schedule_start = request.getParameter("schedule_start");
			String incstartdate		 = request.getParameter( "incstartdate" ) ;
			       incstartdate      = bean.compareDates(incstartdate);
			HashMap result		  = bean.getStartTime(disp_locn_code,fillperiod,schedule_start);
			HashMap result1  =  bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start);
			HashMap eff_date_time  =  bean.getEffStartDateEndDate(scheduleStartTime1);   

			if(result!=null && result.size()>0){
				//out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("STARTDATE")+"';");
				out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("SCHEDULE_START")+"';");
				out.println("formPHGenerateFillList.schedule_start.value='"+(String)result.get("SCHEDULE_START")+"';");
				//out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("STARTDATE")+"';");
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)eff_date_time.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+(String)result1.get("EFF_END_DATE")+"';");
			}
		}
		else if(function.equals("assignAltDrug")){	
			String disp_locn_code			= request.getParameter( "disp_locn_code");
			String alt_drug_code			= request.getParameter( "alt_drug_code");
			String fill_int_start_date_time = request.getParameter( "fill_int_start_date_time");
			String fill_int_end_date_time	= request.getParameter( "fill_int_end_date_time");
			String order_id					= request.getParameter( "order_id");
			String Proc_Type				= request.getParameter( "Proc_Type");
			String drug_code				= request.getParameter( "drug_code");

			String disp_qty			= "";
			String disp_qty_uom		= "";
			String drug_choice		= "";
			String disp_drug_code	= "";
			String disp_drug_desc	= "";
			String disp_btch		= "";

			String batch_dtls = (String)bean.getAltDrugBtchDtls(disp_locn_code,alt_drug_code,fill_int_start_date_time,fill_int_end_date_time,order_id,Proc_Type,drug_code); 
			ArrayList ip_fill_list = (ArrayList)bean.getIpFillList();
			if(ip_fill_list != null && ip_fill_list.size()>0){
				HashMap ip_fill_record = new HashMap();
				for(int i=0;i<ip_fill_list.size();i++){
					ip_fill_record = (HashMap)ip_fill_list.get(i);
					if(order_id.equals((String)ip_fill_record.get("ORDER_ID"))){
						ip_fill_record.put("Disp_qty",batch_dtls);
						break;
					}
				}
			}
			StringTokenizer	st_batch_dtls = new StringTokenizer(batch_dtls,"|");
			 int count=st_batch_dtls.countTokens();
		    if(count==6)
			  {
			     while(st_batch_dtls.hasMoreTokens()){
				  disp_qty		  = st_batch_dtls.nextToken();
				  disp_qty_uom	  = st_batch_dtls.nextToken();
				  drug_choice	  = st_batch_dtls.nextToken();
				  disp_drug_code  = st_batch_dtls.nextToken();
				  disp_drug_desc  = st_batch_dtls.nextToken();
				  disp_btch		  = st_batch_dtls.nextToken();

				  disp_qty_uom =(String)bean.getAltStockUOM( disp_drug_code);

				  HashMap disp_uoms=(HashMap)bean.getDispUoms();
				  disp_uoms.put(order_id+1+disp_drug_code,disp_qty_uom);

			     }
				 out.println("assignAltDrugVals('"+disp_qty+"','"+disp_drug_desc+"','"+disp_btch+"','"+disp_drug_code+"','"+disp_qty_uom+"')");
			
			 }
			 else if(count==5)
			{
	           out.println("assignAltDrugNoBatchDetails()");
			}
			
		}else if(function.equals("assignBtchDtls")){	
			String order_id			= request.getParameter( "order_id");
			String batch_dtls		= request.getParameter("batch_dtls");
			String disp_btch		= "";
			StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
			StringBuffer bth_dtls_sb	= new StringBuffer();

			ArrayList ip_fill_list = (ArrayList)bean.getIpFillList();
			if(ip_fill_list != null && ip_fill_list.size()>0){
				HashMap ip_fill_record = new HashMap();
				for(int i=0;i<ip_fill_list.size();i++){
					ip_fill_record = (HashMap)ip_fill_list.get(i);
					if(order_id.equals((String)ip_fill_record.get("ORDER_ID"))){

						disp_qty_dtl = new StringTokenizer((String)ip_fill_record.get("Disp_qty"),"|");
						while(disp_qty_dtl.hasMoreTokens()){
//							disp_qty		= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
//							disp_qty_uom	= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
//							drug_choice		= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
//							disp_drug_code  = disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
//							disp_drug_desc  = disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
							disp_btch		= disp_qty_dtl.nextToken();
							disp_btch		= batch_dtls;
							bth_dtls_sb.append(disp_btch);

							
						}
						ip_fill_record.put("Disp_qty",bth_dtls_sb.toString());
						break;
					}
				}
			}
		}
		else if(function.equals("GENERATEFILLLIST")){
			
			//String selectArray = request.getParameter("sel_array");
			String selectArray = (String) hash.get( "sel_array" );
			StringTokenizer st									 = new StringTokenizer(selectArray, ",");
			ArrayList selectDrugs=new ArrayList();
				while (st.hasMoreTokens())
				{
					selectDrugs.add(st.nextToken());
					
				}
			bean.setCheckdRecords(selectDrugs);
			HashMap map = (HashMap)bean.insert();
			boolean result	= ((Boolean)map.get("result")).booleanValue();
			String message	= (String)map.get("message");
			String flag		= (String)map.get("flag");
			if(message==null) message		=	"";
			if(flag==null) flag		=	"";
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\");");
		}

putObjectInBean(bean_id,bean,request);
%>
