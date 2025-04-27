/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.clinicaleventhistory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ehis.util.DateUtils;

import eCommon.Common.CommonBean;
import eIPAD.IPADConstants;
import eIPAD.clinicaleventhistory.ClinicalEventHistory;
import eIPAD.clinicaleventhistory.EventHistoryRecord;
import eIPAD.clinicaleventhistory.EventHistoryRequest;
import eIPAD.clinicaleventhistory.EventHistoryResponse;

/**
 * @author GRamamoorthy
 *
 */
public class ClinicalEventHistoryServlet extends HttpServlet implements Servlet {

	/**
	 * default constructor of the class
	 */
	public ClinicalEventHistoryServlet() {
	}
	

	/**
	 * 
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		String selectedTimePeriod = req.getParameter("selectedperiod");
		String patientClass = req.getParameter("patientclass");
		String encounterId = req.getParameter("encounter_id");
		String patientId = req.getParameter("patientid");
		String facilityId = req.getParameter("facility_id");
		HttpSession session = req.getSession();
		
		// now initialize the request object with values
		ClinicalEventHistory eventHistory = new ClinicalEventHistory();
		EventHistoryRequest eventHistoryRequest = new EventHistoryRequest();
		eventHistoryRequest.setRequest(req);
		eventHistoryRequest.setSession(session);
		eventHistoryRequest.setPatientId(patientId);
		eventHistoryRequest.setFacilityId(facilityId);
		eventHistoryRequest.setPatientClass(patientClass);
		// here the locale is obtained from constants file
		eventHistoryRequest.setLocale(IPADConstants.LOCALE);
		eventHistoryRequest.setEncounterId(encounterId);
		eventHistoryRequest.setSelectedTimePeriod(selectedTimePeriod);
		
		// get the event history records
		EventHistoryResponse eventHistoryResponse = eventHistory
				.getEventHistory(eventHistoryRequest);
		/*Map<EventHistoryType, List<EventHistoryRecord>> eventHistoryMap = eventHistoryResponse
				.getHistoryRecordMap();*/
		List<EventHistoryRecord> historyRecordList = eventHistoryResponse.getHistoryRecordList();
		// just a safe check and handling of empty records
		/*if(eventHistoryMap == null || eventHistoryMap.isEmpty()){
			printWriter.println("<span>No records found for the selected values</spaned");
			return;
		}*/
		if(historyRecordList == null || historyRecordList.isEmpty()){
			printWriter.println("<span>No records found for the selected values</spaned");
			return;
		}
		
		String include_normalcy_indicator = req.getParameter("normalcy");
		include_normalcy_indicator = CommonBean.checkForNull(
				include_normalcy_indicator, "N");
		
		String selectedhisrectype = req.getParameter("hist_type");
		String titleofdocument = "";
		
		StringBuffer outdata = new StringBuffer();
		outdata.append("<table class='grid' cellspacing=0 cellpadding=0 width='100%'>");
		
		StringBuffer data = new StringBuffer();
		
		String prevhisttype = "";
		int histcount = 0;
		String colspanval ="3";
		String viewby = req.getParameter("viewby");
		viewby = CommonBean.checkForNull(viewby, "N");
		String preveventclass = "";
		String preveventgroupevent = "";
		String displayStyle = "gridDataChart";
		String preveventdatetime = "";
		boolean first = true;
		
		String enctr_id = "";
		String resultNum = "0";
		String histdatatype="";
		String histrectype="";
		String accessionnum="";
		String eventdatetime="";
		String eventdate_hd ="";
		String pre_eventdate_hd ="";
		String sortEventDateTime="";
		String eventdatetime_th = "";
		String histtypedesc="";
		String eventclassdesc="";
		String eventgroupdesc="";
		String eventdesc="";
		String resultstr="";
		String encline="";
		String range="";
		String extimageapplid="";
		String contr_sys_id = "";
		String contr_sys_event_code  = "";
		String normalrangeLow="";
		String normalrangeHigh="";
		String normalrange = " - ";
		String normalcy_ind="";
		String criticalrangeLow="";
		String criticalrangeHigh="";
		String criticalrange = " - ";
		String strStatus="";
		String pacsimg = "";
		String curreventgroupevent="";
		String result_uom = "";
		String resultNumPrefix = "";
		int historyRecordCount = 0;
		String performed_by = "";
		String normalcy_str = "";
		String color_cell_indicator = "";
		int quick_text_count = 0; 
		String quick_text_image_visible = "";
		
		StringBuffer toolTip = new StringBuffer();
		String classValue = "";
		
		String descCellInd = "";
		String delta_fail_id_ind = "";
		
		int txt_count=0;
		int i=0;
		
		// iterate through the records and form the
		// html output
		for(EventHistoryRecord record : historyRecordList){
			// reset the contents of data
			data.delete(0, data.length());
			
			txt_count = 0;
			
			histdatatype = record.getHistdatatype();
			resultstr = record.getResultstr();
			historyRecordCount = record.getHistoryRecordCount();
			histrectype = record.getHistrectype();
			histtypedesc = record.getHisttypedesc();
			
			contr_sys_id = record.getContr_sys_id();
			accessionnum = record.getAccessionnum();
			contr_sys_event_code = record.getContr_sys_event_code();
			
			resultNum = record.getResultNum();
			resultNumPrefix = record.getResultNumPrefix();
			result_uom = record.getResult_uom();
			
			normalrangeLow = record.getNormalrangeLow();
			normalrangeLow = CommonBean.checkForNull(normalrangeLow);
			normalrangeHigh = record.getNormalrangeHigh();
			normalrangeHigh = CommonBean.checkForNull(normalrangeHigh);
			
			criticalrangeLow = record.getCriticalrangeLow();
			criticalrangeLow = CommonBean.checkForNull(criticalrangeLow);
			criticalrangeHigh = record.getCriticalrangeHigh();
			criticalrangeHigh = CommonBean.checkForNull(criticalrangeHigh);
			
			performed_by = record.getPerformed_by();
			normalcy_str = record.getNormalcy_str();
			extimageapplid = record.getExtimageapplid();
			strStatus = record.getStrStatus();
			color_cell_indicator = record.getColor_cell_indicator();
			color_cell_indicator = CommonBean.checkForNull(color_cell_indicator);
			
			if(include_normalcy_indicator.equals("I")){
				color_cell_indicator = record.getSymbol_legend_ind() == null ? "" : record.getSymbol_legend_ind();
			}
				
			descCellInd = record.getDescCellInd() == null ? "" : record.getDescCellInd();
			
			enctr_id = record.getEnctr_id();
			quick_text_count = record.getQuick_text_count();
			
			eventclassdesc = record.getEventclassdesc();
			eventgroupdesc = record.getEventgroupdesc();
			eventdesc = record.getEventdesc();
			sortEventDateTime = record.getSortEventDateTime();
			resultstr = record.getResultstr();
			encline = record.getEncline();
			encline = encline.replace('\'',' ');
			enctr_id = record.getEnctr_id();
			eventdatetime = record.getEventdatetime();
			
			eventdatetime_th	= DateUtils.convertDate(eventdatetime,"DMYHM","en","en");
			if(eventdatetime_th != null && !eventdatetime_th.trim().equals("")){
				eventdate_hd = eventdatetime_th.substring(0,eventdatetime_th.indexOf(" "));	
			}
			
			strStatus = record.getStrStatus();
			strStatus = CommonBean.checkForNull(strStatus);
			delta_fail_id_ind = record.getDelta_fail_id_ind();
			delta_fail_id_ind = CommonBean.checkForNull(delta_fail_id_ind);
			
			if(quick_text_count == 1){
				quick_text_image_visible = "style='display:inline'";
			}
			else{
				quick_text_image_visible = "style='display:none'";
			}
						
			/**
			 * TODO
			 * the below code has to be uncommented and the data buffer should
			 * be updated
			 */
			if(histdatatype.equals("NUM"))
			{
				if(!(resultNumPrefix).equals("")){
					data = data.append(resultNumPrefix);
				}
					
				data = data.append(resultNum).append("  ").append(result_uom);//rs.getString("RESULT_NUM") == null? "" :rs.getString("RESULT_NUM"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
	                             
				if(!resultstr.equals(""))
				{
					resultstr=replaceSpecialChar(resultstr);
					data=data.append("<a class='gridLink' href=javaScript:ShowComments('"+java.net.URLEncoder.encode(resultstr)+"')>Comments</a>");
				}
				 
				if (historyRecordCount > 0) {
					data.append("<a class='gridLink' href=\"javascript:getText('");
					data.append(histrectype);
					data.append("','");
					data.append(contr_sys_id);
					data.append("','");
					data.append(accessionnum);
					data.append("','");
					data.append(contr_sys_event_code);
					data.append("')\"><img id='textimg' src='../images/Grid Note icon.png' ></a></font>");
					txt_count = 1;
				}

				/**
				 * TODO
				 * the "normal range" string should be replaced with
				 * a string from resource bundle
				 */
				if(!normalrangeLow.equals("") && !normalrangeHigh.equals("")){
					normalrange = "Normal Range" + " : " + normalrangeLow + " - " + normalrangeHigh + " " + result_uom;
				}
				else if(!normalrangeLow.equals("") && normalrangeHigh.equals("")){
					normalrange = "Normal Range" + " : (>=" + normalrangeLow + " " + result_uom + ")";	
				}
				else if(normalrangeLow.equals("") && !normalrangeHigh.equals("")){
					normalrange = "Normal Range" + " : (<=" + normalrangeHigh + " " + result_uom + ")";
				}
				else{
					normalrange = "";
				}
				
				/**
				 * TODO
				 * the "critical" string should be replaced with
				 * a string from resource bundle
				 */
				if(!criticalrangeLow.equals("") && !criticalrangeHigh.equals(""))
				{
					criticalrange = "Critical" + " : " + "Low" + "(<"+ criticalrangeLow + " " + result_uom+") & "+ "High" +"(>" + criticalrangeHigh + " " + result_uom+")" ;
				}
				else if(!criticalrangeLow.equals("") && criticalrangeHigh.equals(""))
				{
					criticalrange = "Critical" + " : " + "Low" + "(<"+ criticalrangeLow + " " + result_uom+")" ;
				}
				else if(criticalrangeLow.equals("") && !criticalrangeHigh.equals(""))
				{
					criticalrange = "Critical" + " : " + "High" +"(>" + criticalrangeHigh + " " + result_uom+")" ;
				}
				else{
					criticalrange = "";
				}
					
								
				if(!normalrange.equals("") && !criticalrange.equals("")){
					toolTip.append(normalrange+"<br> "+criticalrange);
				}
				else if(!normalrange.equals("")){
					toolTip.append(normalrange);
				}
				else if(!criticalrange.equals("")){
					toolTip.append(criticalrange);
				}
				else{
					toolTip.append("");
				}

				if(!performed_by.equals(""))
				{
					if(!(toolTip.toString()).equals("")){
						toolTip.append("<br>"+ "Performed" + " " + "By" + " : " + performed_by);
					}
				}
				range = toolTip.toString();
			}
			else if(histdatatype.equals("STR"))
			{
				data.append(resultstr+"");

				if(!normalcy_str.equals(""))
				{
					data.append("<font color=blue>( Normal Value : " + normalcy_str + " )</font>");
				}
				
				if (historyRecordCount > 0) {
					data=data.append("<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../images/Grid Note icon.png' ></a></font>");
					txt_count = 1;
				}
			}
			else if(histdatatype.equals("HTM")||histdatatype.equals("TXT"))
			{
				if (historyRecordCount > 0) {
					data.delete(0, data.length());
					data.append("<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img border=no src='../images/Grid Note icon.png'></img></a>");
				}
			}
			else if(histdatatype.equals("DOC"))
			{
				if (historyRecordCount > 0) {
					data.append("<a class='gridLink'  href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img border=no src='../images/Grid Note icon.png'></img></a>");
				}
			}
			else if(histdatatype.equals("IMG")) 
			{
				//data +="<a href=javascript:showDocDetails(\""+histdatatype+"\",\""+histrectype+"\",\""+accessionnum+"\",\""+java.net.URLEncoder.encode(eventdesc)+"\",\""+extimageapplid+"\")><img border=no src='../../eCA/images/flow_image.gif'></img></a>";
			}

			if(!extimageapplid.equals(""))
			{
				data.append("&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif' onClick=\" getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimageapplid+"')\">");
			}
			
			if("P".equals(strStatus)){
				data.append(" <font color='red'>(Preliminary)</font>");
			}
			
			if(include_normalcy_indicator.equals("I") && !include_normalcy_indicator.equals(""))
			{
				if(!color_cell_indicator.equals("NONE")){
					data.insert(0, "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
					data.append("</font>");
				}
				else if(normalcy_ind.equals("."))
				{
					data.insert(0, "<font  style='background-image:url(\"../images/NI_Normal.png\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
					data.append("</font>");
				}
				else if(!normalrangeLow.equals("") && !normalrangeHigh.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrangeLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrangeHigh)))
						{
							data.insert(0, "<font  style='background-image:url(\"../images/NI_Normal.png\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
							data.append("</font>");
						}
					}
				}
				else if(!normalrangeLow.equals("") && normalrangeHigh.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrangeLow)) 
						{
							data.insert(0, "<font  style='background-image:url(\"../images/NI_Normal.png\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
							data.append("</font>");
						}
					}
				}
				else if(normalrangeLow.equals("") && !normalrangeHigh.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrangeHigh))
						{
							data.insert(0, "<font  style='background-image:url(\"../images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
							data.append("</font>");
						}
					}
				}
			}
			else if(include_normalcy_indicator.equals("C") && !include_normalcy_indicator.equals(""))
			{
				if(!color_cell_indicator.equals("NONE")){
					data.insert(0, "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
					data.append("</font>");			
				}
				else if(normalcy_ind.equals("."))
				{
					data.insert(0,"<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
					data.append("</font>");
				}
				else if(!normalrangeLow.equals("") && !normalrangeHigh.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrangeLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrangeHigh)))
						{
							data.insert(0, "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
							data.append("</font>");
						}
					}
				}
				else if(!normalrangeLow.equals("") && normalrangeHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrangeLow))
						{
							data.insert(0,"<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"); 
							data.append("</font>");
						}
					}
				}
				else if(normalrangeLow.equals("") && !normalrangeHigh.equals(""))
				{
					if(Float.parseFloat(resultNum) > 0)
					{
						if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrangeHigh))
						{
							data.insert(0, "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>");
							data.append("</font>");
						}
					}
				}
			}
			else{
				data.insert(0, "<font size=1>");
				data.append("</font>");	
			}
				
			
			if(!prevhisttype.equals(histtypedesc))
			{
				histcount++;

				if(!prevhisttype.equals("")){
					outdata.append("</table></td></tr>");	
				}
				outdata.append("<tr onMouseOver='javascript:showPopUp()' onMouseOut='hidePopUp()'><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR><input type=button name='collapse' value=' - ' onclick=\"collapseExpand(this,'"+histcount+"');\"> "+histtypedesc+"</td></tr>");
				//printdata = printdata + "<tr><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR>"+histtypedesc+"</td></tr>";
				outdata.append("<tr><td><table width='100%' id='tableId"+histcount+"'>");
				pre_eventdate_hd = "";
			}
			
			if(viewby.equals("D"))
			{
				if(!pre_eventdate_hd.equals(eventdate_hd))
				{
					outdata.append("<tr onMouseOver='javascript:hidePopUp()'><td colspan='"
							+ colspanval
							+ "' class=CATHIRDLEVELCOLOR><font size=1 color = black ><b>"
							+ eventdate_hd + "</b></font></td></tr>");
					//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1><b>"+eventdate_hd+"</b></font></td></tr>";
				}
			}
			
			if(!preveventclass.equals(eventclassdesc))
			{
				outdata.append("<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>");
				//printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
			}

			if (!eventgroupdesc.equals("")){
				 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
			}
			else{
				curreventgroupevent = eventdesc;
			}
				 
			
			if(viewby.equals("E"))
			{
				if(!curreventgroupevent.equals(preveventgroupevent))
				{
					if (!eventgroupdesc.equals("")){
						outdata.append("<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> ("+eventgroupdesc+")- "+eventdesc+"</font></td></tr>");
						//printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>("+eventgroupdesc+")- "+eventdesc+"</font></td></tr>";
					}else{
						outdata.append("<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> "+eventdesc+"</font></td></tr>");
						//printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>"+eventdesc+"</font></td></tr>";
					}
				}
				
				if(i%2==0){
					classValue = "QRYEVEN";
				}
				else{
					classValue = "QRYODD";
				}
				
				
				if(strStatus.equals("E"))
				{
					outdata.append("<tr><td class='TD_BROWN'  width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td><td class='TD_BROWN' onMouseOver='javascript:hidePopUp()' id='"+i+"'><font size=1>"+data+"</font>"+pacsimg+"</td></tr>");
				}
				else
				{
					outdata.append("<tr><td class='gridDataChart' width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='javascript:hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td>");
					
					outdata.append("<td class='"
							+ displayStyle
							+ "' onMouseOver=\"javascript:displayTooltip(this,'"
							+ range
							+ "')\" onMouseOut='javascript:hideTooltip(this)' onClick=\"changeColor('"
							+ enctr_id
							+ "','"
							+ sortEventDateTime
							+ "','"
							+ classValue
							+ "',this,'"
							+ eventdatetime
							+ "','"
							+ histrectype
							+ "','"
							+ contr_sys_id
							+ "','"
							+ accessionnum
							+ "','"
							+ contr_sys_event_code
							+ "','"
							+ i
							+ "')\" style='cursor:hand' id='"
							+ i
							+ "'>"
							+ data
							+ "&nbsp;<input type='image' "
							+ quick_text_image_visible
							+ " name='image"
							+ i
							+ "'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"
							+ eventdatetime + "','" + histrectype + "','"
							+ contr_sys_id + "','" + accessionnum + "','"
							+ contr_sys_event_code + "','S')\" ></td></tr>");
					
					//printdata = printdata +"<tr><td class='gridDataChart' width='50%'><font size=1>"+eventdatetime_th+"</font></td>";
					//printdata = printdata +"<td class='"+displayStyle+"'>"+data+"</td></tr>";
				}
				i++;
			}
			else 
			{
				if(i%2==0){
					classValue = "QRYEVEN";
				}
				else{
					classValue = "QRYODD";
				}

				outdata.append("<tr>");
				int eventIndex = eventdatetime.indexOf(" ");
				if(eventIndex >= 0){
					outdata.append("<td  class='gridDataChart' width='10%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime.substring(eventIndex)+"</font></td>");	
				}
				
				outdata.append("<td  width='50%' class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td><td class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)' onClick=\"changeColor('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" style='cursor:hand' ><font size=1>"+data+"</font>"+pacsimg+"<input type='image' "+quick_text_image_visible+" style='display:none' name='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" ></td></tr>");
				
				//printdata = printdata + "<tr><td class='gridDataChart'><font size=1>"+eventdatetime.substring(eventdatetime.indexOf(" "))+"</font></td><td class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td>";
					
				//printdata = printdata +"<td class='"+displayStyle+"' id='"+i+"'><font size=1>"+data+"I am here 1</font>"+pacsimg+"<input type='image' style='display:none' name='image"+i+"'   src='../../eCA/images/II_comment.gif' ></td></tr>";
				
				i++;
			}
			preveventdatetime = eventdatetime;
			prevhisttype = histtypedesc;
			preveventclass = eventclassdesc;
			preveventgroupevent = curreventgroupevent;
			pre_eventdate_hd = eventdate_hd;

			if(first)
			{
				if(viewby.equals("D"))
				{
					if(!selectedhisrectype.equals("")){
						titleofdocument = histtypedesc;
					}
				}
				else
				{
					titleofdocument = histtypedesc;
				}
			}
			first = false;
		}
	
		outdata = outdata.append("</table></td></tr>");
		outdata = outdata.append("</table>");
		
		printWriter.println(outdata);
		
	}
	
	/**
	 * 
	 * @param resultStr
	 * @return
	 */
	private String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
	}


	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	

}
