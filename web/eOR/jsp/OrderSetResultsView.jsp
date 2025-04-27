<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
18/12/2013	IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality							
---------------------------------------------------------------------------------------------------------
*/
%> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 --> 	<script language="JavaScript" src="../js/ResultOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 	<STYLE TYPE="text/css"></style>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="view_order" id="view_order">
<%
	/* Mandatory checks start */
	
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String careSetOrderId = request.getParameter("orderId");
	String line_order_id = request.getParameter("line_order_id");
	String order_line_num = request.getParameter("order_line_num");
	String cont_order_ind = request.getParameter("cont_order_ind");
	String patient_id = request.getParameter("patient_id");
	String ord_cat = request.getParameter("order_cat");
	if(ord_cat==null)ord_cat = "";
	String order_cat_desc = request.getParameter("order_cat_desc");
	if(order_cat_desc==null)order_cat_desc = "";
 	String order_status = request.getParameter("order_status");
 	String facility_id = (String)session.getValue("facility_id");
	String resp_id		= (String)session.getValue("responsibility_id");
	String toolTipTextArea = "Double Click to Zoom";
	if(resp_id== null)	resp_id = "";
	if(careSetOrderId == null || careSetOrderId.equals("") || careSetOrderId.equals("null"))
		careSetOrderId = "";
	if(order_line_num == null || order_line_num.equals("") || order_line_num.equals("null"))
		order_line_num = "";
	if(line_order_id == null || line_order_id.equals("") || line_order_id.equals("null"))
		line_order_id = "";
	// ORDER_SET_ID passed here........ depending upon if line_order_id is null
    if(line_order_id.equals("")) // then for the order_set so pass the order_set_id
	   line_order_id = careSetOrderId;
 	if ( order_status == null) order_status = "";
	ArrayList allValues = new ArrayList();
	ArrayList allOrderId = new ArrayList();
	String orderArray[]	= new String[3];
	int row_count		= 0;
/* Mandatory checks end */

	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
	 ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	bean.clear() ;
	bean.setLanguageId(localeName);

	bean.setMode( mode ) ;

	if(!careSetOrderId.equals("") && !line_order_id.equals("") && careSetOrderId.equals(line_order_id)) {
 		allOrderId	= bean.getOrderIds(careSetOrderId);
		row_count	= allOrderId.size();
	} else {
		row_count	= 1;
	}
	String result_data[] = (String[])bean.getAbnormalCondition();
	//String high_str			= result_data[0];
	//String low_str			= result_data[1];
	//String abn_str			= result_data[2];

	String crit_str			= result_data[3];
	String crit_high_str	= result_data[4];
	String crit_low_str		= result_data[5];
	String slClassValue		= "", textClassValue= "";
	String normalcy_ind			= null; 
	String normalcy_ind_disp	= null; String  result_str =  null;
	//String dcsr_msr_val		= "";
	//String time_key			= "";
	//String tmp_discr_msr_id ="";
	//String tmp_dscr_panel_id = "";
	String report_srl_no	= "";		//String tmp_date = "";
   	String reporting_date			= "";
   	String reporting_practitioner 	= "";
  	String ext_image_obj_id			= "";
  	String ext_image_appl_id		= ""; String hdr_time = "";
	String order_id					= "";
	String color					= "", toolTipText	= "";
	String key_value				= "";
	String tmp_order_cat_desc		= "";

 	TreeMap first_map		 = null;
	TreeMap time_val_map	 = null;
 
	ArrayList 	 panels		= 	null;
	ArrayList 	 discrete	=	null;

	if(row_count == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}
	else
	{
		for(int k=0;k<row_count; k++) 
		{
 
  			if(!careSetOrderId.equals("") && !line_order_id.equals("") && careSetOrderId.equals(line_order_id)) 
			{
 				orderArray		= (String[])allOrderId.get(k);
				order_id		= orderArray[0];
  				ord_cat			= orderArray[1];
				order_cat_desc  = orderArray[2];
			}
			else order_id = line_order_id;
			//11g Conversion Start.
			String encntr_id		= request.getParameter( "encntr_id" ) ;
			String practitioner_id = (String)session.getValue("ca_practitioner_id");
			String pract_Rel_id = bean.getPractRelId(patient_id,facility_id,practitioner_id,encntr_id);
			//11g Conversion End.
			//IN042552 Start.
			String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");
			//allValues		= bean.viewResultDetail(order_id,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_Rel_id);
			allValues		= bean.viewResultDetail(order_id,order_line_num,cont_order_ind,patient_id,ord_cat,facility_id,resp_id,order_status,pract_Rel_id,clinician_id,"","");
			//IN042552 End.
			if(allValues.size()==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
			}
			else
			{
				discrete		= bean.discrete ;
				panels			= bean.panels ;
		 
				String [] print_details = {"","","","","","",""};
				print_details = (String[])bean.getOrderDetails(order_id);
				
				first_map = (TreeMap)bean.traverseList(1,allValues,first_map);

				TreeMap second_map = (TreeMap)bean.traverseList(2,allValues,first_map);

				TreeMap third_map = (TreeMap)bean.traverseList(9,allValues,second_map);
				TreeMap all_times = (TreeMap)bean.getAllTimes(9,allValues);
		 
		 
				HashMap key_value_map1 = (HashMap)bean.getKeyValueData1();
				HashMap key_value_map2 = (HashMap)bean.getKeyValueData2();

				//TreeMap dscr_msr_panel = null;
			//	TreeMap dscr_vals = null;
				Set all_times_set = (Set)all_times.keySet();
				Iterator itr_times = (Iterator)all_times_set.iterator() ;
				//Iterator itr        = (Iterator)all_times_set.iterator() ; // For the Hdg loop
			
				//TreeMap time_panel = null;
				if(panels.size()>0)
				{
					out.println("<table cellpadding=0 cellspacing=0 border=1 width='100%' align=center class='grid'>");
					if(!tmp_order_cat_desc.equals(order_cat_desc) && !order_cat_desc.equals("")){
						out.println("<tr><td class='CAHIGHERLEVELCOLOR' colspan='2' width='100%'><b>"+order_cat_desc+"</b></td></tr>");
						tmp_order_cat_desc = order_cat_desc;
				}
			}
		
			int i=1;
			//Set panel_set = (Set)third_map.keySet();
			//Iterator panel_itr = (Iterator)panel_set.iterator() ;
			String panel_key="";
			TreeMap dscr_map=null;
			String dscr_key="";
			Object obj=null;

			for(int K = 0 ; K < panels.size() ; K++)
			{// panel Iteration
		
			panel_key 				= (String)panels.get(K);
			dscr_map 				= (TreeMap)third_map.get(panel_key);


			//Set dscr_msr_set 				= null;
			//Iterator dscr_itr 				= null;
			//if(dscr_map!=null)
			//	dscr_msr_set				= (Set)dscr_map.keySet();
			/*if(dscr_msr_set!=null)
				dscr_itr					= (Iterator)dscr_msr_set.iterator() ;*/
 			if(dscr_map!=null && key_value_map1!=null && dscr_map.size() > 1) // this is in the case of existance of more than one descr msr panel id's {
  			out.println("<tr><td colspan='"+(all_times.size()+1)+"'><b>"+(String)key_value_map1.get(panel_key)+"</b></td></tr>");
			out.println("<tr><td colspan='"+(all_times.size()+1)+"' class='OR_QRYEVENBORDER'></td></tr>");
			//			while(dscr_itr.hasNext())
  			for(int l = 0; l < discrete.size(); l++)
			{ // descr iteration
				//Added by Siva Kumar on 10/9/2003
				color					= ""; toolTipText	= "";
				//End of Addition
 				if(i % 2 == 0)
				{
					//slClassValue	= "QRYEVEN";
					slClassValue="gridData";
					textClassValue	= "RESULTTEXTAREAEVEN";
				}
				else
				{
					//slClassValue = "QRYODD";
					slClassValue="gridData";
					textClassValue = "RESULTTEXTAREAODD";
				}
				dscr_key =  (String)discrete.get(l);
  				if(dscr_key!=null && dscr_map!=null && !dscr_map.containsKey(dscr_key.trim()))
					continue ;

				 //Added by Siva Kumar on 10/9/2003
				 if(dscr_key!=null && dscr_map!=null)
	                 time_val_map = (TreeMap)dscr_map.get(dscr_key);
				 if(all_times_set!=null)
				  itr_times			 = (Iterator)all_times_set.iterator() ;
				if (itr_times!=null && itr_times.hasNext()) 
				{
					hdr_time	= (String)itr_times.next();
					obj  = time_val_map.get(hdr_time);
					if(obj != null)
					{
 						String value_arr[] = (String[]) obj;

						key_value =	order_id+value_arr[21];
%>
					<%--<Script>alert('<%//=value_arr.length%>,<%//=((value_arr.length == 25) ? value_arr[22] : "no")%>')</Script>--%>
<%
						if (value_arr.length == 26) 
						{
							if (value_arr[22] != null && (!(value_arr[22]).equals(""))) 
							{
								if (value_arr[22].equals("*LB_REFLEX_REG*")) 
								{
									color = "LIGHTYELLOW";
									textClassValue = "RESULTTEXTAREAYELLOW";
									toolTipText = "This test is ordered at the time of Registration";
								}	else if (value_arr[22].equals("*LB_REFLEX_RES*")) 
								{
									color = "TAN";
									textClassValue = "RESULTTEXTAREATAN";
									toolTipText = "This test is ordered at the time of Resulting based on Reflex Test";
								}	else if (!value_arr[22].equals(request.getParameter("practitioner_id"))) 
								{
									color = "Gray";
									textClassValue = "RESULTTEXTAREAGRAY";
									toolTipText = "ordered by : " + value_arr[22];
								}
							}
							ext_image_obj_id	= (value_arr[23]==null)?"":value_arr[23];
							ext_image_appl_id	= (value_arr[24]==null)?"":value_arr[24];
							reporting_practitioner = value_arr[25];
						} 
						else if (value_arr.length == 25) 
						{
							ext_image_obj_id	= (value_arr[22]==null)?"":value_arr[22];
							ext_image_appl_id	= (value_arr[23]==null)?"":value_arr[23];
							reporting_practitioner = value_arr[24];
						}
						reporting_date 	= value_arr[9];
						report_srl_no	= value_arr[0];
                    }
				}
				if (!color.equals(""))
					slClassValue = color;
				//End of Addition
				if(dscr_map!=null)
				{
  	 				if(dscr_map.size()>1)
					{
						out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"' class = '"+slClassValue+"'>"+(String)key_value_map2.get(dscr_key)+"</td>");
		 				//out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"' class = '"+slClassValue+"'><a href='javascript:auditValues(\""+order_id+"\",\""+order_line_num+"\",\""+reporting_date+"\",\""+reporting_practitioner+"\")' title='Tracking Info.'>"+(String)key_value_map2.get(dscr_key)+"</a></td>");
     					i++;
					}
					else
					{
						out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"'  class = '"+slClassValue+"'><b>"+(String)key_value_map2.get(dscr_key)+"</b></td>");
						//out.println("<tr VALIGN='TOP'><td width='30%'  title = '"+toolTipText+"'  class = '"+slClassValue+"'><b><a href='javascript:auditValues(\""+order_id+"\",\""+order_line_num+"\",\""+reporting_date+"\",\""+reporting_practitioner+"\")' title='Tracking Info.'>"+(String)key_value_map2.get(dscr_key)+"</a></b></td>");
						i++;
					}
				} 
 				itr_times = (Iterator)all_times_set.iterator() ;
 				if(itr_times!=null)
				{
					while(itr_times.hasNext())
					{//Iterate Time values of header
						hdr_time = (String)itr_times.next();
						obj = time_val_map.get(hdr_time);
						if(obj != null)
						{//this has values in the array
							String value_arr[] = (String[]) obj;
							normalcy_ind_disp	= "";
							normalcy_ind 		= value_arr[15];
							if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
								normalcy_ind_disp = "<FONT COLOR='MAGENTA'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticalAbnormal.label","or_labels")+"</FONT>";
							else if(normalcy_ind != null)
								normalcy_ind_disp = "<FONT COLOR='RED' ><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"</b></FONT>";
							result_str = value_arr[7]; 
							if(result_str == null) result_str = "";

							if((value_arr[20].trim()).equals("NUM"))
							{
								out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'> <font size=1> ");
								out.println(CommonBean.checkForNull(value_arr[5]));
								if(!CommonBean.checkForNull(value_arr[6]).equals(""))
								   out.println(""+value_arr[6]);
								out.println(""+normalcy_ind_disp);
								if(!((CommonBean.checkForNull(value_arr[11]).trim()).equals("") || (CommonBean.checkForNull(value_arr[12]).trim()).equals("") ))
								{
									out.println("("+CommonBean.checkForNull(value_arr[11])+" - "+ CommonBean.checkForNull(value_arr[12])+")");
								}
 
 						   if(result_str!=null && !result_str.equals(""))
						   {
						   %>
								<textarea rows="4" cols="80"  CLASS = "<%=textClassValue%>" READONLY><%=result_str%></textarea>
						   <%
							}
 							if( value_arr[8] != null && (!(value_arr[8].equals(""))) )
							{
								bean.setClobData(value_arr[8], key_value);
								out.println("<br><br>");
						%>
							<textarea rows="5" cols="80"  CLASS = "<%=textClassValue%>" READONLY title = "<%=toolTipTextArea%>" ondblclick="viewClobData('<%=key_value%>')"><%=CommonBean.checkForNull(value_arr[8])%></textarea>
 						<%
							}
						}
						else if((value_arr[20].trim()).equals("TXT"))
						{
 							out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'> <font size=1>");
 							if(value_arr[7] != null && (!(value_arr[7].equals(""))) )
							{
						%>
								<textarea rows="4" cols="80"   CLASS = "<%=textClassValue%>" READONLY ><%=CommonBean.checkForNull(value_arr[7])%></textarea>
						<% }
 
						  if(  value_arr[8] != null && (!(value_arr[8].equals(""))))
						  {
								bean.setClobData(value_arr[8], key_value);
						%>
						    <textarea rows="5" cols="80"  CLASS = "<%=textClassValue%>" READONLY title = "<%=toolTipTextArea%>" ondblclick="viewClobData('<%=key_value%>')"><%=value_arr[8]%></textarea>
						<% } 
						}
						else
						{
								out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"' > <font size=1>");
								if( value_arr[7] != null && (!(value_arr[7].equals(""))) )
								{
							%>
									<textarea rows="4" cols="80"  CLASS = "<%=textClassValue%>" READONLY><%=CommonBean.checkForNull(value_arr[7])%></textarea>
							<%
								}
								if((!(value_arr[8].equals(""))) && value_arr[8] != null )
								{
										bean.setClobData(value_arr[8], key_value);
							
									if(!(value_arr[20].trim()).equals("HTM"))
									{
									%>
										<textarea rows="5" cols="80"  CLASS = "<%=textClassValue%>" READONLY title = "<%=toolTipTextArea%>" ondblclick="viewClobData('<%=key_value%>')"><%=CommonBean.checkForNull(value_arr[8])%></textarea> 
									<%
									}
									else
									{
										
										String txt= CommonBean.checkForNull(value_arr[8]);
									//if(txt.indexOf("</ADDRESS></table>") != -1)
									//	txt = txt.replaceAll("</ADDRESS></table>","</ADDRESS>");
										if(txt.indexOf("</TD></TR><tr><td></td></tr></table>") != -1)
											txt = txt.replaceAll("</TD></TR><tr><td></td></tr></table>","");
											
											out.println(txt);

											//out.println(CommonBean.checkForNull(value_arr[8]));
										
									}
									%>
							<%  } %>
  					<%	}
 					if(!(value_arr[20].trim()).equals("NUM")) 
					{
 					  %>
 					<%=normalcy_ind_disp%>
					<%	
					} 	
					if(value_arr[16] != null)
					{%>
						<a class="gridLink" href="javascript:viewResultComment(escape('<%=value_arr[16]%>'))">C</a>
					<%	
					}
					if ((ext_image_obj_id != null && (!ext_image_obj_id.equals(""))) && (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
					{%>
					<%--<Script>alert('ext_image_obj_id=<%=ext_image_obj_id%>,ext_image_appl_id=<%=ext_image_appl_id%>,<%=((ext_image_obj_id != null || (!ext_image_obj_id.equals(""))) && (ext_image_appl_id != null || (!ext_image_appl_id.equals(""))))%>')</Script>--%>
					<IMG SRC='../images/Xray.gif' WIDTH='16' HEIGHT='16' BORDER=0>
					<%}%>
                    </td>
					<%}
					else
					{
						out.println("<td title = '"+toolTipText+"' width='70%' class = '"+slClassValue+"'></td>");
					}
				}//end of itr_times.hasNext()
			 } //End of if  itr_times
			}//end of dscr_itr.hasNext()
		//}//end of if dscr_map.size() > 1
		}
		//out.println("<tr><td colspan='"+(panels.size()+1)+"' class='OR_QRYEVENBORDER'></td></tr>");%>

		<Input name="ord_typ_code" id="ord_typ_code" type="hidden" value="<%=print_details[0]%>">
		<Input name="patient_class" id="patient_class" type="hidden" value="<%=print_details[1]%>">
		<Input name="priority" id="priority" type="hidden" value="<%=print_details[2]%>">
		<Input name="ord_id" id="ord_id" type="hidden" value="<%=print_details[3]%>">
		<Input name="source_type" id="source_type" type="hidden" value="<%=print_details[4]%>">
		<Input name="location_code" id="location_code" type="hidden" value="<%=print_details[5]%>">
		<Input name="order_status" id="order_status" type="hidden" value="<%=print_details[6]%>">
		<Input name="report_srl_no" id="report_srl_no" type="hidden" value="<%=report_srl_no%>">
		<Input name="bean_id" id="bean_id" type="hidden" value="<%=bean_id%>">
		<Input type='hidden' name='querystring' id='querystring' value='<%=request.getQueryString()%>'>
			<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		</table>
 		

<%	} } }%>
</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
%>

