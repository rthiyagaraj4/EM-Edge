package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.Common.*;
import ePH.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __ipfilldispenselocationall extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IpFillDispenseLocationAll.jsp", 1722846953623L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
28/1/2020		IN072145			Shazana Hasan							SKR-SCF-1305
---------------------------------------------------------------------------------------------------------------
*/   

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String locale			= (String)session.getAttribute("LOCALE");
		
	String facility_id		= (String) session.getValue( "facility_id" );
	String bean_id			= request.getParameter( "bean_id" ) ;
	String bean_name		= request.getParameter( "bean_name" ) ;
	String dcode			= request.getParameter( "dispense_code" ) ;
	String function			=request.getParameter("function");
	String scheduleStartTime1= null;
	
	if ( bean_id == null || bean_id.equals( "" ) )
		return ;
	
	Hashtable hash				= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash						= (Hashtable)hash.get( "SEARCH" ) ;

	IpFillAllBean bean = (IpFillAllBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	if(!function.equals("GENERATEFILLLIST") && !function.equals("assignAltDrug") && !function.equals("assignBtchDtls")&& !function.equals("CALL_UNALLOC_REPORT") && !function.equals("storeAuthUserInBean") && !function.equals("storeAltDrugRemarks")) { // Added storeAuthUserInBean in condition for RUT-CRF-0035 [IN029926]
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
		bean.setDispLocation(dcode); 
		String MaxDurnForIpPres=bean.getMaxDurnForIpPres(locale);
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
		 if(eff_date_time.size()==0){
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
			//out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+rtnendtime+"';");
			out.println("formPHGenerateFillList.routinefillalreadyinvoked.value='"+rfinvoked+"';");
			if (ip_fill_allocate_bathces_yn.equals("Y")){
				out.println("formPHGenerateFillList.allocate_during_fill_yn.checked=true");
			}
			else{
				out.println("formPHGenerateFillList.allocate_during_fill_yn.checked=false");
			}
			out.println("formPHGenerateFillList.ip_fill_excl_prd_behind.value='"+fillHrs+"';");
			if(fillPeriodUnit.equals("H")){
				fill_period_hr = ((Integer.parseInt(fillPeriod)/24)-1)+"";
			}
			else if(fillPeriodUnit.equals("D")){
				fill_period_hr =(Integer.parseInt(fillPeriod)-1)+"";
			}
			else if(fillPeriodUnit.equals("P")){
				fill_period_hr =(Integer.parseInt(MaxDurnForIpPres)-1)+"";
			}
			if(Integer.parseInt(fill_period_hr)<0) // if block added for SRR20056-CRF-0663
				fill_period_hr = "0";
			//out.println("formPHGenerateFillList.Ip_Fill_Prd_Ahead.value='"+fillPeriod+"';");
			out.println("formPHGenerateFillList.Ip_Fill_Prd_Ahead.selectedIndex='"+fill_period_hr+"';");
			out.println("formPHGenerateFillList.fill_prd_ahead_val.value='"+fill_period_hr+"';");
			out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate(scheduleStartTime,"DMYHM","en",locale)+"';");
			out.println("formPHGenerateFillList.incstarttime.value='"+incstarttime+"';");
			out.println("formPHGenerateFillList.incendtime.value='"+incendtime+"';");
			
		   try{
				String disp_locn_code = request.getParameter("dispense_code");
				HashMap result  =  bean.getNextRoutineEffStartDateEndDate(tmp_start_date_time,fillPeriod,disp_locn_code,schedule_start);
			
				//out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("EFF_START_DATE")+"';");
				out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("EFF_START_DATE")+"';");
				out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				
			    if(fillPeriodUnit.equals("H")){	
				 	out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
				 }
				 else if(fillPeriodUnit.equals("D")){
                 	out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate(incendtime1,"DMYHM","en",locale)+"';");
				 }
				 else if(fillPeriodUnit.equals("P")){
                
					HashMap PrescribeEndDate  =  bean.getPrescribeEndDate((String)result.get("EFF_START_DATE"),MaxDurnForIpPres);
			 		out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)PrescribeEndDate.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
				 }
			}
			catch(Exception e){
				e.printStackTrace();
			}
			String sIncPRNDrugs	= "";// added for SRR20056-CRF-0663 --START
			String sProcessType	= "";
			String sDisp_dflt_display = bean.getDispDfltDisplay(dcode);
			if(sDisp_dflt_display!=null && !sDisp_dflt_display.equals("") && !sDisp_dflt_display.equals("X")){
			// sDisp_dflt_display format like "ABSOLUTE_DRUGS~N|FREQUENCY_DRUGS~N|PRN_DRUGS~I";
				StringTokenizer stDftDisplay = new StringTokenizer(sDisp_dflt_display,"|");
				StringTokenizer stDftDisplayVal = null;
				String stDftDisplayID =null;
				String stDftDisplayDtl = null;
				while(stDftDisplay.hasMoreTokens()){
					stDftDisplayDtl = stDftDisplay.nextToken();
					stDftDisplayVal = new StringTokenizer(stDftDisplayDtl,"~");
					while(stDftDisplayVal.hasMoreTokens()){
						stDftDisplayID = stDftDisplayVal.nextToken();
						if(stDftDisplayID.equals("PROCESS_TYPE"))
							sProcessType = stDftDisplayVal.nextToken();
						else if(stDftDisplayID.equals("PRN_DRUGS"))
							sIncPRNDrugs = stDftDisplayVal.nextToken();
					}
				}
				out.println("DispDfltDisplay('"+sProcessType+"','"+sIncPRNDrugs+"');");
				/*if(sIncPRNDrugs!= null && sIncPRNDrugs.equals("I"))
					out.println("formPHGenerateFillList.PrnDrugs.checked = true;");
				if(sProcessType!= null && sProcessType.equals(""))
					out.println("formPHGenerateFillList.Proc_Type.value = '"+sProcessType+"';");
				else if(sProcessType!= null && sProcessType.equals("I"))
					out.println("formPHGenerateFillList.Proc_Type.checked = true;");*/
			}// added for SRR20056-CRF-0663 --END
		}
	}
	else if (function.equals("storeAuthUserInBean")){ // Added for RUT-CRF-0035 [IN029926]  --begin
		String auth_user_id = (String) hash.get( "auth_user_id" );
		bean.setAuthUserID(auth_user_id);
	} // Added for RUT-CRF-0035 [IN029926] end
	else if (function.equals("CalculateTime")){
			ArrayList currTime = bean.getCurrentTime() ;
			if (currTime.size()>0){// store the curr hours and minutes into hidden variables in the calling form
				out.println("document.formPHGenerateFillList.currHours.value="+currTime.get(0)) ;
				out.println("document.formPHGenerateFillList.currMinutes.value="+currTime.get(1)) ;
			}
		}
		else if (function.equals("BuildingandFloors")){
			String val = request.getParameter( "building_code" ) ;
			ArrayList floorList = bean.getFloorList(val) ;
			if (floorList.size()==0){
				out.println("clearData('document.formPHGenerateFillList.Floor_Code');") ;
			}
			out.println("clearData('document.formPHGenerateFillList.Floor_Code');") ;
			out.println("addData('','           ---Select---','document.formPHGenerateFillList.Floor_Code');");
			for (int ii=0; ii<floorList.size(); ii+=2) {
				
				out.println("addData('"+ floorList.get(ii) + "', '" + floorList.get(ii+1) +"', 'document.formPHGenerateFillList.Floor_Code');") ;
			}
		}
		else if (function.equals("FindEndTime")){
			String incstartdate		 = request.getParameter( "incstartdate" ) ;
			String incstartdatetmp   = incstartdate;
			String fillperiod		 = request.getParameter( "fillperiod" ) ;
			String disp_locn_code	 = request.getParameter( "disp_locn_code");
				   incstartdate      = bean.compareDates(incstartdate);
			String proc_type		 = request.getParameter( "proc_type");
			String schedule_start	 = request.getParameter("schedule_start");
			String schedule_start2	 = "";
		   if(proc_type.equals("R")){
				//schedule_start = com.ehis.util.DateUtils.convertDate(schedule_start,"DMYHM",locale,"en"); //Commented for Date format exception DMYHM changed to DMY as bellow
				schedule_start = com.ehis.util.DateUtils.convertDate(schedule_start,"DMY",locale,"en");
				HashMap result  =  bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start);
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("EFF_START_DATE")+"';");
				out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("EFF_START_DATE")+"';");
				if(!disp_locn_code.equals("")){
				 	out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
			   		out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				}
			   	out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");
		   }
		   else if(proc_type.equals("I")){
			  
				if(!bean.isGreaterThanSysdate(incstartdate)){
					incstartdate = 	incstartdatetmp;
				}
				HashMap eff_date_time  =  bean.getEffStartDateEndDate(scheduleStartTime1);
				disp_locn_code = request.getParameter( "disp_locn_code");
				HashMap result = bean.getStartTime(disp_locn_code,fillperiod,schedule_start);
                //schedule_start = com.ehis.util.DateUtils.convertDate(schedule_start,"DMY",locale,"en"); Commented by sandhya on 11/11/2010 for the incident num:24926
				HashMap result1  = bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start,true);
				if(result!=null && result.size()>0){
					// GET START TIME (getStartTime())
					out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("STARTDATE")+"';");
					out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("SCHEDULE_START")+"';");
					out.println("formPHGenerateFillList.schedule_start.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("SCHEDULE_START"),"DMYHM","en",locale)+"';");
					out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result.get("STARTDATE"),"DMYHM","en",locale)+"';");
					  //GET  NEXT ROUTINE EFF START DATE  AND END DATE (getNextRoutineEffStartDateEndDate())
					 String CustomerID = bean.getCustomerID();
					 String code = bean.getDispLocation();
					 String fill_period_hr1 = ((Integer.parseInt(fillperiod)/24))+"";
					// out.println("alert(\"--->" + fill_period_hr1 + "\");") ;
					//String MaxDurnForIpPres1 = "1";
				    HashMap PrescribeEndDate  =  bean.getPrescribeEndDate1(fill_period_hr1,facility_id,code);
			 		if(CustomerID.equals("SRR")){
					 	out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)PrescribeEndDate.get("schedule_start_time"),"DMYHM","en",locale)+"';");
					 }
					 else{
					 	//out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)result1.get("EFF_END_DATE"),"DMYHM","en",locale)+"';");// commented for SKR-SCF-1305
					 	out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)PrescribeEndDate.get("schedule_start_time"),"DMYHM","en",locale)+"';");// ADDED for SKR-SCF-1305
					} 
				}
			}
		}
		else if(function.equals("FindStartTime")){	
			String disp_locn_code = request.getParameter( "disp_locn_code");
			String fillperiod	  = request.getParameter( "fillperiod" ) ;
			String schedule_start = request.getParameter("schedule_start");
			String incstartdate	   = request.getParameter( "incstartdate" ) ;
			       incstartdate    = bean.compareDates(incstartdate);
          // schedule_start     = com.ehis.util.DateUtils.convertDate(schedule_start,"DMYHM",locale,"en"); Commented By Sandhya--on 12/OCt/2010 for the incident num:24346
			scheduleStartTime1 = com.ehis.util.DateUtils.convertDate(scheduleStartTime1,"DMYHM",locale,"en");
			HashMap result		   = bean.getStartTime(disp_locn_code,fillperiod,schedule_start);
			HashMap result1        =  bean.getNextRoutineEffStartDateEndDate(incstartdate,fillperiod,disp_locn_code,schedule_start);
			HashMap eff_date_time  =  bean.getEffStartDateEndDate(scheduleStartTime1);   

			if(result!=null && result.size()>0){
				// GET START DATE AND TIME.(getStartTime())
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+(String)result.get("STARTDATE")+"';");
				out.println("formPHGenerateFillList.Schedule_Start_Time_Routine.value='"+(String)result.get("SCHEDULE_START")+"';");
			  	out.println("formPHGenerateFillList.schedule_start.value='"+(String)result.get("SCHEDULE_START")+"';");
				out.println("formPHGenerateFillList.fill_int_start_date_time.disabled=false;");
				//GET START DATE AND END DATE.(getEffStartDateEndDate())
				out.println("formPHGenerateFillList.fill_int_start_date_time.value='"+com.ehis.util.DateUtils.convertDate((String)eff_date_time.get("EFF_START_DATE"),"DMYHM","en",locale)+"';");
				//GET NEXT ROUTINE EFFSTART DATE AND END DATE.(getNextRoutineEffStartDateEndDate())
				out.println("formPHGenerateFillList.fill_int_end_date_time.value='"+(String)result1.get("EFF_END_DATE")+"';");
			}
		}
		else if(function.equals("assignAltDrug")){	
			String disp_locn_code			= request.getParameter( "disp_locn_code");
			String alt_drug_code			= request.getParameter( "alt_drug_code");
			String fill_int_start_date_time = request.getParameter( "fill_int_start_date_time");
			String fill_int_end_date_time	= request.getParameter( "fill_int_end_date_time");
			String order_id					= request.getParameter( "order_id");
			String order_line_num			= request.getParameter( "order_line_num");
			String Proc_Type				= request.getParameter( "Proc_Type");
			String drug_code				= request.getParameter( "drug_code");

			String iv_prep_yn			    = request.getParameter("iv_prep_yn");
			String nursing_unit_or_locn		= request.getParameter("nursing_unit_or_locn");
			String Nursing_Unit_From		= request.getParameter("Nursing_Unit_From");
			String Nursing_Unit_To		    = request.getParameter("Nursing_Unit_To");
			String Building_Code		    = request.getParameter("Building_Code");
			String Building_Code_to		    = request.getParameter("Building_Code_to");
			String Floor_Code		        = request.getParameter("Floor_Code");
			String ip_fill_excl_prd_behind	= request.getParameter("ip_fill_excl_prd_behind");
			String compound_drug_ind	    = request.getParameter("compound_drug_ind");
			String ip_medical_items	        = request.getParameter("ip_medical_items");
			String ip_excl_intermittent_fill= request.getParameter("ip_excl_intermittent_fill");
			String ip_prn_drugs             = request.getParameter("ip_prn_drugs");
			String alt_drug_remarks_ind     = request.getParameter("alt_drug_remarks_ind");

			String disp_qty			= "";
			String disp_qty_uom		= "";
			String disp_qty_uom_desc= "";
			String drug_choice		= "";
			String disp_drug_code	= "";
			String disp_drug_desc	= "";
			String disp_btch		= "";

			String batch_dtls = (String)bean.getAltDrugBtchDtls(disp_locn_code,alt_drug_code,fill_int_start_date_time,fill_int_end_date_time,order_id,order_line_num,Proc_Type,drug_code,iv_prep_yn,nursing_unit_or_locn,Nursing_Unit_From,Nursing_Unit_To,Building_Code,Building_Code_to,Floor_Code,ip_fill_excl_prd_behind,compound_drug_ind,ip_medical_items,ip_excl_intermittent_fill,ip_prn_drugs); 
			StringTokenizer	st_batch_dtls = new StringTokenizer(batch_dtls,"|");
			boolean itemUOMDefError = false;
			StringTokenizer st_batch_dtls_tmp = new StringTokenizer(batch_dtls,"|");
			st_batch_dtls_tmp.nextToken();
			st_batch_dtls_tmp.nextToken();
			if (st_batch_dtls_tmp.nextToken().equals("U"))
				itemUOMDefError = true;
			if (!itemUOMDefError) {
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
				int count=st_batch_dtls.countTokens();
				if(count==6){
					 while(st_batch_dtls.hasMoreTokens()){
						disp_qty		  = st_batch_dtls.nextToken();
						disp_qty_uom	  = st_batch_dtls.nextToken();
						drug_choice	  = st_batch_dtls.nextToken();
						disp_drug_code  = st_batch_dtls.nextToken();
						disp_drug_desc  = st_batch_dtls.nextToken();
						disp_btch		  = st_batch_dtls.nextToken();
						disp_qty_uom =(String)bean.getAltStockUOM( disp_drug_code);
						disp_qty_uom_desc =bean.getUomDisplay(facility_id,disp_qty_uom);
						HashMap disp_uoms=(HashMap)bean.getDispUoms();
						disp_uoms.put(order_id+1+disp_drug_code,disp_qty_uom);
						disp_drug_desc =bean.getAltDrugDesc(disp_drug_code); //Add3d By Naveen for incident num:25181 on Nov/23/2010
					}//Added for SRR20056-SCF-7499 - Start
					ArrayList un_alloc_records = bean.getUnAllocDrugList();
					ArrayList updated_un_alloc_records = new ArrayList();
					if(un_alloc_records != null && un_alloc_records.size()>0){
						for(int i=0; i <un_alloc_records.size(); i+=8){
							if(order_id.equals((String) un_alloc_records.get(i+6)) &&  order_line_num.equals((String) un_alloc_records.get(i+7))){
								if(drug_choice.equals("N") && disp_qty!=null && !disp_qty.equals("0")){
									 un_alloc_records.set(i+3,disp_drug_code); //replacing the drug_code with alternate drug code
									for(int k=i; k<(i+8); k++){
										updated_un_alloc_records.add(un_alloc_records.get(k));
									}
								}
								/*else{
									for(int j=i; (j<(i+8)&& j<un_alloc_records.size()); j++){
										un_alloc_records.remove(i);
									}
								}
								break;*/
							}
							else{
								for(int k=i; k<(i+8); k++){
									updated_un_alloc_records.add(un_alloc_records.get(k));
								}
							}
						}
					}
					bean.setUnAllocDrugList(updated_un_alloc_records); 	//Added for SRR20056-SCF-7499 - End
					disp_drug_desc=disp_drug_desc.replaceAll(" ","%20"); //Added for [IN:044657]-start
					disp_drug_desc = java.net.URLEncoder.encode(disp_drug_desc,"UTF-8");
					disp_drug_desc=disp_drug_desc.replaceAll("%2520","%20"); //added for [IN:044657] -end
					out.println("assignAltDrugVals('"+disp_qty+"','"+disp_drug_desc+"','"+disp_btch+"','"+disp_drug_code+"','"+disp_qty_uom+"','"+disp_qty_uom_desc+"','"+alt_drug_remarks_ind+"')");
				 }
				 else if(count==5){
				   out.println("assignAltDrugNoBatchDetails()");
				}
			} 
			else {
				//out.println("alert('')");
				out.println("alert(getMessage('PH_ITEM_UOM_DEF_NOT_FOUND','PH'));");
			}
		}
		else if(function.equals("assignBtchDtls")){	
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
							//disp_qty		= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
							//disp_qty_uom	= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
							//drug_choice		= disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
							//disp_drug_code  = disp_qty_dtl.nextToken();
							bth_dtls_sb.append(disp_qty_dtl.nextToken());
							bth_dtls_sb.append("|");
							//disp_drug_desc  = disp_qty_dtl.nextToken();
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
			String patient_Array = (String) hash.get( "patient_Array" );
			String store_code = (String) hash.get( "store_code" );			
			StringTokenizer st		 = new StringTokenizer(selectArray, ",");
			StringTokenizer st1		 = new StringTokenizer(patient_Array, ",");			
			ArrayList selectDrugs=new ArrayList();
			String tmp_selectedReports = (String) hash.get("tmp_selectedReports");/* code added for SKR-SCF-0765[IN037730] --Start --*/
			StringTokenizer st3			 = new StringTokenizer(tmp_selectedReports,",");			
			ArrayList selectedReportsIds = new ArrayList();			
			String key="";
			while (st3.hasMoreTokens())	{
				key = st3.nextToken();
				if(!selectedReportsIds.contains(key ))
					selectedReportsIds.add(key);				            				
			}
			/* code added for SKR-SCF-0765[IN037730] --End --*/	
			//this list used for selected patients
			ArrayList patient_Order=new ArrayList();
			//this list used for selected patients count
			ArrayList patient_seq_count=new ArrayList();
			ArrayList seq_num_list=bean.getPatientList();
			ArrayList patient_insert_list=new ArrayList();
			ArrayList seq_insert_hdr_list=new ArrayList();
			while (st.hasMoreTokens()){
				selectDrugs.add(st.nextToken());
			}
			
			String Ipdsnyn=bean.getIpdsnyn(facility_id);
			bean.setIpseqnum(Ipdsnyn);
			if(Ipdsnyn.equals("Y"))	{
				int Seq_num=0;
				int Seq_num1=Seq_num;
				StringTokenizer st2 = new StringTokenizer(selectArray, ",");
				String token ="";
				String token1="";
				while (st2.hasMoreTokens()&&st1.hasMoreTokens()){
					token= st2.nextToken();
					token1 =st1.nextToken();
					if(token.equalsIgnoreCase("Y")){  
						patient_Order.add(token1);
						patient_Order.add(token);
					}
				}
				String pid="";
				int k=0;
				for(int i=0;i<seq_num_list.size();i++){
					pid=seq_num_list.get(i).toString();
					for(int j=0;j<patient_Order.size();j+=2){
					   if(pid.equals(patient_Order.get(j).toString())){
						  k++;
					   }//end if
					}//for inner loop
					patient_seq_count.add(pid);
					patient_seq_count.add(k);
					k=0;
				}//for outer loop
				int cnt=0;
				/*for(int m=0;m<patient_seq_count.size();m+=2){
				  cnt=Integer.parseInt(patient_seq_count.get(m+1).toString());				  
				   if(cnt>0){				  
				   seq_insert_hdr_list.add(patient_seq_count.get(m).toString());
				   seq_insert_hdr_list.add(Seq_num);
				   Seq_num++;
				  // Seq_num=bean.getSeqNumber(facility_id,store_code);
					}
			   }//OUTER FOR LOOP
				bean.setSeqInserthdrlist(seq_insert_hdr_list);*/				
				int temp_count;
				int seq_temp_count=0;
				String Seq_num_str="";
				//bean.setDailySeqNum(Seq_num_str1);
				int Seq_num_temp=1;
				for(int i=0;i<patient_seq_count.size();i+=2){
					temp_count=Integer.parseInt(patient_seq_count.get(i+1).toString());
					for(int j=0;j<patient_Order.size();j+=2){
					   if((patient_seq_count.get(i).toString().equals(patient_Order.get(j).toString()))&&(temp_count>0)){
						   //seq_temp_count++;
							patient_insert_list.add(patient_seq_count.get(i).toString());
							//Seq_num_temp=Seq_num_temp+seq_temp_count;
							Seq_num_str=Seq_num_temp+"/"+temp_count;							
							patient_insert_list.add(Seq_num_str);
							Seq_num_temp++;
						}
						else{
							Seq_num=Seq_num1;
						}//end if
					}//inner for loop end
			 		Seq_num_temp=1;
				}//outer fro loop end
				bean.setPatientinsertlist(patient_insert_list);
			}//end if
			bean.setCheckdRecords(selectDrugs); 			
			bean.setSelectedReportsIds(selectedReportsIds); //code added for SKR-SCF-0765[IN037730]
			HashMap map = (HashMap)bean.insert();
			boolean result	= ((Boolean)map.get("result")).booleanValue();
			String message	= (String)map.get("message")==null?"":(String)map.get("message");
			String flag		= (String)map.get("flag")==null?"":(String)map.get("flag");
			out.println("assignResult(" + result + ", \"" + bean.replaceNewLineChar(message) + "\", \"" + flag + "\");");
		}
		else if(function.equals("onlineReport")){ 
			String certificate_reimbursement = (String) hash.get( "certificate_reimbursement" );
			String dispense_sheet            = (String) hash.get( "dispense_sheet" );
			String drug_label                = (String) hash.get( "drug_label" );
			String fill_list_drugmedical     = (String) hash.get( "fill_list_drugmedical" );
			String fill_list_patient         = (String) hash.get( "fill_list_patient" );
			String fill_list_unallocated     = (String) hash.get( "fill_list_unallocated" );
			String medical_supply_label      = (String) hash.get( "medical_supply_label" );
			String medication_list           = (String) hash.get( "medication_list" );		 
			String fill_proc_id              = (String) hash.get( "fill_proc_id" );
			String disp_locn_code            = (String) hash.get( "disp_locn_code" );
			String proc_type				  = (String) hash.get( "proc_type" );
			String to_date                   = (String) hash.get( "to_date" );
			String drug_yn                   = (String) hash.get( "drug_yn" );
			String login_user		          =	(String)session.getValue("login_user");
			String report_id                 = "";
			String ReportOutput	          =	""; 

			int rec_count =bean.getFillRecorfCount(fill_proc_id);
			if(rec_count==0)
				return;

			if(medication_list.equals("MEDICATION_LIST")){
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				ReportOutput="";
				report_id="PHMEDLIST";
				report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_facility_id",facility_id) ;
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_language_id",locale) ;
				report1.addParameter("p_fill_proc_id",fill_proc_id) ;
				report1.addParameter("p_disp_locn_code",disp_locn_code) ;
				report1.addParameter("p_disp_date",to_date) ;
				onlineReports.add( report1) ;	
				ReportOutput = onlineReports.execute( request, response );
				report1 = null;

			}
			if(certificate_reimbursement.equals("CERTIFICATE_REIMBURSEMENT")){
				int count =bean.getCertificateReimburseCount(fill_proc_id);
				if(count>0){
					ecis.utils.OnlineReports onlineReports		=	null;
					ecis.utils.OnlineReport report1			=	null;
					onlineReports 		= new ecis.utils.OnlineReports() ;
					ReportOutput="";
					report_id="PHCERTREIM";
					report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
					report1.addParameter("p_report_id",report_id) ;
					report1.addParameter("p_user_name",login_user) ;
					report1.addParameter("p_facility_id",facility_id) ;
					report1.addParameter("p_module_id", "PH") ;
					report1.addParameter("p_language_id",locale) ;
					report1.addParameter("p_fill_proc_id",fill_proc_id) ;
					report1.addParameter("p_disp_locn_code",disp_locn_code) ;
					report1.addParameter("p_disp_date",to_date) ;
					onlineReports.add( report1) ;					
					ReportOutput = onlineReports.execute( request, response );
					report1 = null;
				}
			}
			if(dispense_sheet.equals("DISPENSE_SHEET")) {
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report_id="PHPRDISSHFILL";//Changed PHPRDISSH to PHPRDISSHFILL for incident 37204
				ReportOutput="";
				report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_facility_id",facility_id) ;
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_language_id",locale) ;
				report1.addParameter("p_fill_proc_id",fill_proc_id) ;
				report1.addParameter("p_disp_locn_code",disp_locn_code) ;
				report1.addParameter("p_disp_date",to_date) ;
				onlineReports.add( report1) ;	
				ReportOutput = onlineReports.execute( request, response );
				report1 = null;
			}
			if(drug_label.equals("DRUG_LABEL")||medical_supply_label.equals("MEDICAL_SUPPLY_LABEL")){
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;				
				try{
					//report_id="PHPRDISLBFILL";//code commented and added for SKR-SCF-0765[IN037730] --Start	PHPRDISLBFILL			
					/*StringTokenizer stRep = null; 
					String  patient_id;
					ArrayList selectedDrugs = bean.getSelectedDrugdetails();	
                    ArrayList orderIds = bean.getOrderID();			  
					ArrayList dispNos = bean.getDispNumbers(disp_locn_code,orderIds);			
					for(int i=0;i<selectedDrugs.size(); i++){	
						stRep = new StringTokenizer((String)selectedDrugs.get(i),"~~");						
						if(stRep.hasMoreTokens()){						
							report_id = stRep.nextToken();  
							patient_id = stRep.nextToken();							
							stRep.nextToken() ;*/ //code added for SKR-SCF-0765[IN037730]--End
					ArrayList selectedReportsIds = bean.getSelectedReportsIds();						
					if(selectedReportsIds.contains("PHPRDISLBFILL")){	
						onlineReports 		= new ecis.utils.OnlineReports() ;	
						report1	= new ecis.utils.OnlineReport(facility_id,"PH","PHPRDISLBFILL") ; 
						report1.addParameter("p_report_id","PHPRDISLBFILL") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_language_id",locale) ;  
						report1.addParameter("p_fill_proc_id",fill_proc_id) ;
						report1.addParameter("p_fill_prc_id",fill_proc_id) ;
						report1.addParameter("p_disp_locn_code",disp_locn_code) ;
						report1.addParameter("p_disp_date",to_date) ;
						//report1.addParameter("p_drug_yn",drug_yn) ;										
						//report1.addParameter("p_patient_id",patient_id) ;//code added for SKR-SCF-0765[IN037730] 
						//report1.addParameter("p_disp_no",String.valueOf(dispNos.get(i)) ) ;//code added for SKR-SCF-0765[IN037730] 
						onlineReports.add(report1) ;						
						ReportOutput = onlineReports.execute(request, response );	
						report1 = null;								
					}					
					if(selectedReportsIds.contains("PHRIVCONTFILL")){
						onlineReports 		= new ecis.utils.OnlineReports() ;
						report1	= new ecis.utils.OnlineReport(facility_id,"PH","PHRIVCONTFILL") ; 
						report1.addParameter("p_report_id","PHRIVCONTFILL") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_language_id",locale) ;  
						report1.addParameter("p_fill_proc_id",fill_proc_id) ;
						report1.addParameter("p_fill_prc_id",fill_proc_id) ;
						report1.addParameter("p_disp_locn_code",disp_locn_code) ;
						report1.addParameter("p_disp_date",to_date) ;						 
						onlineReports.add(report1) ;
						ReportOutput = onlineReports.execute(request, response );						
						report1 = null;						
					} //code added for SKR-SCF-0765[IN037730]				
					if(selectedReportsIds.contains("PHRIVINTTFILL")){			
						onlineReports 		= new ecis.utils.OnlineReports() ;			
						report1	= new ecis.utils.OnlineReport(facility_id,"PH","PHRIVINTTFILL") ; 
						report1.addParameter("p_report_id","PHRIVINTTFILL") ;
						report1.addParameter("p_user_name",login_user) ;
						report1.addParameter("p_facility_id",facility_id) ;
						report1.addParameter("p_module_id", "PH") ;
						report1.addParameter("p_language_id",locale) ;  
						report1.addParameter("p_fill_proc_id",fill_proc_id) ;
						report1.addParameter("p_fill_prc_id",fill_proc_id) ;
						report1.addParameter("p_disp_locn_code",disp_locn_code) ;
						report1.addParameter("p_disp_date",to_date) ;						 
						onlineReports.add(report1) ;
						ReportOutput = onlineReports.execute(request, response );						
						report1 = null;								
					} //code added for SKR-SCF-0765[IN037730]	
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			if(fill_list_drugmedical.equals("FILL_LIST_DRUGMEDICAL")) {
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report_id="PHFILLBYNUDRUG";
				ReportOutput="";
				report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_facility_id",facility_id) ;
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_language_id",locale) ;
				report1.addParameter("p_fill_proc_id",fill_proc_id) ;
				report1.addParameter("p_disp_locn_code",disp_locn_code) ;
				report1.addParameter("p_disp_date",to_date) ;
				report1.addParameter("p_fill_proc_type",proc_type) ;
				onlineReports.add( report1) ;	
				ReportOutput = onlineReports.execute( request, response );
				report1 = null;
			}
			if(fill_list_patient.equals("FILL_LIST_PATIENT")) {
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report_id="PHFILLBYNUPAT";
				ReportOutput="";
				report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id) ;
				report1.addParameter("p_user_name",login_user) ;
				report1.addParameter("p_facility_id",facility_id) ;
				report1.addParameter("p_module_id", "PH") ;
				report1.addParameter("p_language_id",locale) ;
				report1.addParameter("p_fill_proc_id",fill_proc_id) ;
				report1.addParameter("p_disp_locn_code",disp_locn_code) ;
				report1.addParameter("p_disp_date",to_date) ;
				report1.addParameter("p_fill_proc_type",proc_type) ;
				onlineReports.add( report1) ;										
				ReportOutput = onlineReports.execute( request, response );
				report1 = null;
			   
			}
			if(fill_list_unallocated.equals("FILL_LIST_UNALLOCATED")) {
				ecis.utils.OnlineReports onlineReports		=	null;
				ecis.utils.OnlineReport report1			=	null;
				onlineReports 		= new ecis.utils.OnlineReports() ;
				report_id="PHUNALDRGMED";
				ReportOutput="";
				report1	= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
				report1.addParameter("p_report_id",report_id);
				report1.addParameter("p_user_name",login_user);
				report1.addParameter("p_facility_ID",facility_id);
				report1.addParameter("p_module_id", "PH");
				report1.addParameter("p_language_id",locale);
				report1.addParameter("p_fill_proc_id",fill_proc_id);
				report1.addParameter("p_disp_locn",disp_locn_code);
				report1.addParameter("p_fill_proc_dt",to_date);
				report1.addParameter("p_fill_proc_type",proc_type);
				report1.addParameter("P_REPORT_TYPE","DT");
																							
				onlineReports.add( report1) ;										
				ReportOutput = onlineReports.execute( request, response );
				report1 = null;
			}
		}
		else if(function.equals("CALL_UNALLOC_REPORT")){
			 bean.InsertUnallocDrugDetails();
			 String disp_locn_code              = (String) hash.get( "disp_locn_code" );
		     String Proc_Type                   = (String) hash.get( "Proc_Type" );
		     String login_at_ws_no		        = (String)bean.getLoginAtWsNo ();
		     String login_user		            = (String)session.getValue("login_user");
		     //String facility_id		            = (String)session.getValue( "facility_id" );
			 String ReportOutput				=	""; 
System.err.println("=====CALL_UNALLOC_REPORT==============>"+request.getQueryString());		    
			//ecis.utils.OnlineReports onlineReports	=	null;
		    //ecis.utils.OnlineReport report1			=	null;
			//onlineReports 		= new ecis.utils.OnlineReports() ;
			ecis.utils.OnlineReports onlineReports	= new ecis.utils.OnlineReports() ;
			String report_id	= "PHUNALDRGMED";
			ReportOutput		= "";
		    ecis.utils.OnlineReport report1			= new ecis.utils.OnlineReport( facility_id, "PH",report_id) ;
			report1.addParameter("p_report_id",report_id);
			report1.addParameter("p_user_name",login_user);
			report1.addParameter("p_facility_id",facility_id);
			report1.addParameter("p_module_id", "PH") ;
			report1.addParameter("p_language_id",locale);			
			report1.addParameter("p_disp_locn_code",disp_locn_code);			
			report1.addParameter("p_fill_proc_type",Proc_Type);	
			report1.addParameter("p_ws_no",login_at_ws_no);														    
			onlineReports.add( report1) ;										
			//ReportOutput = onlineReports.execute( request, response );
			//report1 = null;

			//ecis.utils.OnlineReport report2			=	null;
			//onlineReports 		= new ecis.utils.OnlineReports() ;			
			//ReportOutput		= "";
		    ecis.utils.OnlineReport report2		= new ecis.utils.OnlineReport( facility_id, "PH","PHUNALDRGMES") ;
			report2.addParameter("p_report_id","PHUNALDRGMES");
			report2.addParameter("p_user_name",login_user);
			report2.addParameter("p_facility_id",facility_id);
			report2.addParameter("p_module_id", "PH") ;
			report2.addParameter("p_language_id",locale);			
			report2.addParameter("p_disp_locn_code",disp_locn_code);			
			report2.addParameter("p_fill_proc_type",Proc_Type);	
			report2.addParameter("p_ws_no",login_at_ws_no);														    
			onlineReports.add( report2) ;										
			ReportOutput = onlineReports.execute( request, response );
		}//end else
		else if(function.equals("storeAltDrugRemarks")){
			String order_id=(String)hash.get("order_id");
			String order_line_num=(String)hash.get("order_line_num");
			String alt_drug_remarks = (String)hash.get("alt_drug_remarks")==null?"":(String)hash.get("alt_drug_remarks");
			bean.setAltDrugRemarks(order_id+"~"+order_line_num, java.net.URLDecoder.decode(alt_drug_remarks,"UTF-8"));
		}//end else
	putObjectInBean(bean_id,bean,request);

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
