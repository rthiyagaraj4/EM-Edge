<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id 			= request.getParameter( "bean_id" ) ;
	String validate 		= request.getParameter( "validate" ) ;
	String flag				= request.getParameter("flag");
	String default_val		= request.getParameter("default_val");
	String default_val1		= request.getParameter("default_val1");
	String default_val2		= request.getParameter("default_val2");
	String isRDInstalled_yn="";
	String isOTInstalled_yn="";
	String result ="";
	String errorMsg=""; //48622
    Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;  //ttttt
    String locale = (String) p.getProperty("LOCALE");//ttttt


	String practitioner_id	= (String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");
	String facility_id 		= (String)session.getValue("facility_id")==null?"":(String)session.getValue("facility_id");
	String resp_id 			= (String)session.getValue("responsibility_id")==null?"":(String)session.getValue("responsibility_id");

	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	default_val				= (default_val == null) ? "" : default_val;
	default_val1			= (default_val1 == null) ? "" : default_val1;
	default_val2			= (default_val2 == null) ? "" : default_val2;

	ResultReportingBean beanObj = (ResultReportingBean)getBeanObject( bean_id, "eOR.ResultReportingBean" ,request ) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
    if (flag == null || flag.equals("")) {
		if ( validate.equals( "location" ) ) {
			String locn_type = (String)hash.get("location_type") ;
			out.println( "clearList('document') ; " ) ;

			ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
			}
		}
	} else if (flag.equalsIgnoreCase("true")) {
		if ( validate.equals( "location" ) ) {
			boolean flagDefault = false;
			String flagDef = (String)hash.get("flagDefault");
			if (flagDef.equals("true")) {
				flagDefault	= true;
			} else {
				flagDefault	= false;
			}
		  	//String locn_type = (String)hash.get("location_type") ;
			out.println( "clearActivityTypeList('document'); " ) ;
			out.println( "clearList('document') ; " ) ;

			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			ArrayList OrderTypeData = beanObj.getOrderCategory(practitioner_id, resp_id);
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				String selected = "false";
				if (OrderTypeData.size() == 1 && i == 0) {
					//out.println("alert('in')");
					selected = "true";
				} else if (record[0].equals(default_val)) {
					selected = "true";
				}
				out.println( "addLocationList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				//System.out.println("record[0]="+record[0]);
				if(record[0].equals("RD"))
				{
					isRDInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"RD");
					//System.out.println("=isRDInstalled_yn="+isRDInstalled_yn);
					out.println("formObj.isRDInstalled_yn.value='"+isRDInstalled_yn+"';");
				}
				if(record[0].equals("OT"))
				{
					isOTInstalled_yn = (String) beanObj.isModuleInstalled(facility_id,"OT");
					//System.out.println("=isOTInstalled_yn="+isOTInstalled_yn);
					out.println("formObj.isOTInstalled_yn.value='"+isOTInstalled_yn+"';");
				}
			
				if (OrderTypeData.size() == 1 || selected.equals("true")) {
					out.println("populateLocnOrdType('locn','"+default_val+"','"+default_val1+"','"+default_val2+"');");

				} else {
					out.println("formObj.locn.value='"+default_val+"';");
				}
				if ((record[0]).equals("CN") && flagDefault) {
				    out.println("formObj.default_order_category.value='Y'");
				    flagDefault = false;
				}
			}
		} else if ( validate.equals( "ord_type") ) {
			
			String orderCategory = (String)hash.get("locn") ;
			out.println( "clearTypeList('document') ; " ) ;
            String selected = "false";
			//ArrayList OrderTypeData = beanObj.getLocation(facility_id, practitioner_id, locn_type) ;
			//System.out.println("orderCategory="+orderCategory);
			ArrayList OrderTypeData = beanObj.getOrderType(orderCategory, practitioner_id, resp_id);
			for( int i=0 ; i< OrderTypeData.size() ; i++ ) {
				String[] record = (String[])OrderTypeData.get(i);
				//out.println("alert('default_val="+default_val1+",record[0]="+record[0]+"')");
				if (record[0].equals(default_val1)) {
					selected = "true";
				}
				out.println( "addTypeList(\"" + record[0] + "\",\"" + record[1] + "\",\"" + selected + "\") ; " ) ;
				/*if (default_val1.equals("") ) {
					out.println("formObj.order_type.value='*ALL';");
				}*/
				if (default_val1.equals("") || selected.equals("true")) {
				//if (selected.equals("true")) {
					out.println("formObj.order_type.value='"+default_val1+"';");
				}
				
				//out.println("formObj.order_type.value='"+default_val+"';");
			}
			
			//String order_type = "" ;
			out.println( "clearActivityTypeList('document'); " ) ;

			/*ArrayList ActivityType = beanObj.getActivityType(orderCategory, order_type);
			for( int i=0 ; i< ActivityType.size() ; i++ ) {
				String[] record = (String[])ActivityType.get(i);
							
				out.println( "addActivityList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}*/
			//String isPerformingLocnYN = "N";

           /* if (!(practitioner_id == null || practitioner_id.equals("")))
				isPerformingLocnYN = beanObj.isPerformingLocnYN("",practitioner_id,orderCategory);
			if ((isPerformingLocnYN == null || isPerformingLocnYN.equals("N")) && !(resp_id == null || resp_id.equals("")))
                isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,"",orderCategory);*/
				//isPerformingLocnYN = beanObj.isPerformingLocnYN(resp_id,practitioner_id,orderCategory);

           /* if (isPerformingLocnYN.equalsIgnoreCase("Y")) {
            	//out.println("formObj.all.performing_locn_lbl_show.innerHTML='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingLocation.label","or_labels")+"'");
            	//out.println("formObj.all.performing_locn_show.innerHTML=\"<select name='performing_location_code' id='performing_location_code'><option value=''>   ---Select---   </option></select>\"");
            	out.println( "clearPerformingLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				if (!(practitioner_id == null || practitioner_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn("", practitioner_id, orderCategory);

	            if ((PerformingLocn.size() == 0) && !(resp_id == null || resp_id.equals("")))
	            	PerformingLocn = beanObj.getPerformingLocn(resp_id,"",orderCategory);

				selected = "";

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					if (record[0].equals(default_val2)) {
						selected = "true";
					}
					out.println( "addPerformingLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
				if (default_val2.equals("") || selected.equals("true")) {
					out.println("formObj.performing_location_code.value=' "+default_val2+" ';");
				}
			} */
			//else {
			//	out.println("formObj.all.performing_locn_lbl_show.innerHTML = \"\"");
			//	out.println("formObj.all.performing_locn_show.innerHTML = \"\"");
				//out.println("alert('resp_id="+resp_id+",practitioner_id="+practitioner_id+",orderCategory="+orderCategory+"')");
			//}
		} else if (validate.equals("source_location_type")) {
            /*String locn_type = (String)hash.get("source_location_type") ;

    		out.println( "clearSourceLocationList('document') ; " ) ;
    		ArrayList LocationList = beanObj.getSourceLocation(locn_type) ;
    		for( int i=0 ; i< LocationList.size() ; i++ ) {
    			String[] record = (String[])LocationList.get(i);
    			out.println( "addSourceLocationList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		    }*/
		} else if (validate.equals("chart_updation")) {
			String order_id = (String)hash.get("order_id");

			beanObj.updateChartValues(order_id,practitioner_id);

			out.println("alert(getMessage(\"RECORD_MODIFIED\",\"SM\"))");
		} else if (validate.equals("TASK_STATUS")) {
			String view_by = (String)hash.get("view_by");

			if (view_by.equals("H")) {
				out.println("formObj.task_status_show.innerHTML = \"<SELECT name='task_status' id='task_status'><option value=''><fmt:message key=\"Common.all.label\" bundle=\"${common_labels}\"/></option><option value='E'><fmt:message key=\"Common.Elapsed.label\" bundle=\"${common_labels}\"/></option><option value='O' ><fmt:message key=\"Common.Overdue.label\" bundle=\"${common_labels}\"/></option><option value='D'><fmt:message key=\"Common.Due.label\" bundle=\"${common_labels}\"/></option><option value='F' >Future</option><option value='C' ><fmt:message key=\"Common.complete.label\" bundle=\"${common_labels}\"/></option><option value='X'>External Orders</option><option value='R'><fmt:message key=\"eOR.AcknolwedgetheResults.label\" bundle=\"${or_labels}\"/></option></select></SELECT>\";");
			} else if (view_by.equals("L")) {
				out.println("formObj.task_status_show.innerHTML = \"<SELECT name='task_status' id='task_status'><option value=''><fmt:message key=\"Common.all.label\" bundle=\"${common_labels}\"/></option><option value='E'><fmt:message key=\"Common.Elapsed.label\" bundle=\"${common_labels}\"/></option><option value='O' ><fmt:message key=\"Common.Overdue.label\" bundle=\"${common_labels}\"/></option><option value='D'><fmt:message key=\"Common.Due.label\" bundle=\"${common_labels}\"/></option><option value='F' ><fmt:message key=\"Common.Future.label\" bundle=\"${common_labels}\"/></option><option value='C' ><fmt:message key=\"Common.complete.label\" bundle=\"${common_labels}\"/></option></SELECT>\";");
			}

		} else if ( validate.equals( "CHANGE_PERFORM_LOCN" ) ) {
		     // String int_or_ext = "";
		      String performing_facility = (String)hash.get("performing_facility") ;
		      String order_category = (String)hash.get("order_category") ;
		      String order_catalog_code = (String)hash.get("order_catalog_code") ;
		      out.println( "clearChangePerformLocnList('document') ; " ) ;
	            ArrayList PerformingLocn = new ArrayList();

				PerformingLocn = beanObj.getPerformingLocationDetails(performing_facility,order_category,order_catalog_code);

				for( int i=0 ; i< PerformingLocn.size() ; i++ ) {
					String[] record = (String[])PerformingLocn.get(i);
					out.println( "addChangePerformLocnList(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				}
		} else if ( validate.equals( "CHECK_INT_OR_EXT" ) ) {
		    String int_or_ext = "";
		    String order_id = (String)hash.get("order_id") ;

			int_or_ext = beanObj.getIntOrExt(order_id);
			out.println( "formObj.int_or_ext.value='" + int_or_ext + "';" ) ;

		}else if ( validate.equals( "SET_REF_CONTENT" ) ) {
		    String ref_form_text = "";
		    String ref_form_id = (String)hash.get("ref_form_id") ;
			ref_form_text = (String ) beanObj.getRefFormContent(ref_form_id);
			//beanObj.setRefFormId(ref_form_id);//out.println(ref_form_id);
			beanObj.setRefFormContent(ref_form_text);
			
		}else if( validate.equals( "ACCESSION_NUM" ) ) {
			String order_id= (String)hash.get("order_id") ;
			String accession_num =  (String)hash.get("accession_num") ;
			String note_type =  (String)hash.get("note_type") ;

			//accession_num = "parent.ResultReportingResult.accession_num.value" ;
			//out.println("alert("+accession_num+")");
			//System.out.println("==accession_num==="+order_id+"====="+accession_num+"=nt="+note_type+"===");
			//int inserted = beanObj.updateORStatus(order_id, accession_num, note_type, practitioner_id);
			beanObj.updateORStatus(order_id, accession_num, note_type, practitioner_id);
			//System.out.println("==inserted======================================"+inserted);
		}else if (validate.equals("procedureLink")) {
			String order_id = (String)hash.get("order_id");
			String order_type_code = (String)hash.get("order_type_code");
			//int report_srl_no = (String)hash.get("order_type_code");
			int report_srl_no = 1;
			String proc_scheme_code = (String)hash.get("proc_scheme_code");
			String patient_id = (String)hash.get("patient_id");
			String patient_class = (String)hash.get("patient_class");
			String encounter_id = (String)hash.get("encounter_id");
			//System.out.println("order_id"+order_id+"order_type_code"+order_type_code+"report_srl_no"+report_srl_no+"proc_scheme_code"+proc_scheme_code);
		    result= beanObj.insertProcedureLink(order_id,order_type_code,report_srl_no,proc_scheme_code,patient_id,patient_class,encounter_id,practitioner_id,facility_id);//48622
			//System.out.println("=====result=========="+result);
			/*if(!result.equals(""))
				out.println("APP-SM0002 Operation Completed Successfully ....");
			else
				out.println("Procedure Link not updated...");*/
			if(result.equals("Success"))
            {
				errorMsg= beanObj.getMessage(locale,"RECORD_INSERTED","CA");
				//out.println("APP-SM0002 Operation Completed Successfully ....");
            }
            else
            out.println("Procedure Link not updated...");
			
		}
	}
	putObjectInBean(bean_id,beanObj,request);
%>

