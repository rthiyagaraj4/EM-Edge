<!DOCTYPE html>
<!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/QueryPresVsDispDrug.js"></script> 
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin='0'>
<%
		//Search Criteria's from Query Criteria page

		String	order_id		=	request.getParameter("order_id");
		String	dt_from			=	request.getParameter("dt_from");
		String  dt_to			=	request.getParameter("dt_to");
		String  order_type		=	request.getParameter("order_type");
		String  order_status	=	request.getParameter("order_status");
		String  patient_class	=	request.getParameter("patient_class");
		String  location_type	=	request.getParameter("location_type");
		String  location_code	=	request.getParameter("location_code");
		String  disp_locn_code	=	request.getParameter("disp_locn_code");
		String  patient_id		=	request.getParameter("patient_id");
		//out.println("disp_locn_code--->" +disp_locn_code+ "in order.jsp");

		String ord[]		= request.getParameterValues("orderbycolumns");
		boolean searched	= request.getParameter( "searched" ) == null ? false : true  ;
		try{

			dt_from		 = CommonBean.checkForNull( dt_from);
			dt_to		 = CommonBean.checkForNull( dt_to );
			order_type = CommonBean.checkForNull( order_type );
			order_id	 = CommonBean.checkForNull( order_id );
			order_status	 = CommonBean.checkForNull( order_status );
			location_type	 = CommonBean.checkForNull( location_type );
			location_code	 = CommonBean.checkForNull( location_code );
			disp_locn_code	 = CommonBean.checkForNull( disp_locn_code );
			patient_id		=	CommonBean.checkForNull( patient_id );
			//Common parameters.
			HashMap sqlMap = new HashMap();
			ArrayList chkFields = new ArrayList();

			//include all the common parameters.
			//String sql=PhRepository.getPhKeyValue("SQL_PH_PRESVSDISP_ORDER_SELECT");
			//	String sql="SELECT   DISTINCT A.ORDER_ID,   TO_CHAR(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME, B.PRACTITIONER_NAME,   Ph_Order_Source(  A.SOURCE_CODE,   A.PATIENT_CLASS,   A.ORDERING_FACILITY_ID,A.SOURCE_TYPE,?) LOCATION,   A.PATIENT_ID,   C.PATIENT_NAME,   D.ORDER_STATUS_TYPE,   (SELECT SHORT_DESC FROM PH_DISP_LOCN WHERE DISP_LOCN_CODE=E.DISP_LOCN_CODE AND FACILITY_ID=E.FACILITY_ID)   DISP_LOCN FROM    OR_ORDER A,   AM_PRACTITIONER B,   MP_PATIENT C,   OR_ORDER_STATUS_CODE D ,   PH_DISP_HDR E WHERE    A.ORD_PRACT_ID=B.PRACTITIONER_ID AND   A.PATIENT_ID=C.PATIENT_ID AND   A.ORDER_ID=E.ORDER_ID(+)   AND   A.ORDER_STATUS=D.ORDER_STATUS_CODE AND   ORDER_CATEGORY='PH' AND   order_status_type IN (25,30,35,56,58,10)";  //Modified query on 23/10/09
			String sql="SELECT   DISTINCT A.ORDER_ID,   TO_CHAR(A.ORD_DATE_TIME,'dd/mm/yyyy hh24:mi') ORD_DATE_TIME, B.PRACTITIONER_NAME,   Ph_Order_Source(  A.SOURCE_CODE,   A.PATIENT_CLASS,   A.ORDERING_FACILITY_ID,A.SOURCE_TYPE,?) LOCATION,   A.PATIENT_ID,   nvl(decode(?,'en',c.patient_name,PATIENT_NAME_LOC_LANG),c.patient_name)patient_name,   D.ORDER_STATUS_TYPE,   (SELECT SHORT_DESC FROM PH_DISP_LOCN_lang_vw WHERE DISP_LOCN_CODE=E.DISP_LOCN_CODE AND FACILITY_ID=E.FACILITY_ID and language_id =?)   DISP_LOCN FROM    OR_ORDER A,   am_practitioner_lang_vw b,   MP_PATIENT C,   OR_ORDER_STATUS_CODE D ,   PH_DISP_HDR E WHERE    A.ORD_PRACT_ID=B.PRACTITIONER_ID AND   A.PATIENT_ID=C.PATIENT_ID AND   A.ORDER_ID=E.ORDER_ID(+)   AND   A.ORDER_STATUS=D.ORDER_STATUS_CODE AND   ORDER_CATEGORY='PH' AND   order_status_type IN (25,30,35,56,58,10) "; //Modified query for getting dipslocation in locale language===for 25317incident on 10/DEC/2010

			chkFields.add( locale.trim() );
			chkFields.add( locale.trim() );
			chkFields.add( locale.trim() );
			//Append query conditions here
			//Add conditions based on parameters passed

			// If order_type (priority) is specified
			if ( (!(order_type.equals("")))&&(order_type!=null)){
				sql=sql+" AND A.PRIORITY=?";
				chkFields.add( order_type.trim() );
			}
			//out.println(patient_id);
			// If patient id  is specified
			if ( (!patient_id.equals("") && !patient_id.equals("null"))){
				sql=sql+" AND A.PATIENT_ID=?";
				chkFields.add( patient_id.trim() );
			}

			// If Order_id is specified

			if ( (!(order_id.equals("")))&&(order_id!=null)){
				sql=sql+" AND UPPER(A.ORDER_ID)=UPPER(?)";
				chkFields.add( order_id.trim() );
			}
			if ( (!(order_status.equals("")))&&(order_status!=null)){
				if (order_status.equals("FD"))
					sql=sql+" AND ORDER_STATUS_TYPE=58 ";
				else if (order_status.equals("PD"))
					sql=sql+" AND ORDER_STATUS_TYPE=56 ";
				//else if (order_status.equals("PND"))
				//sql=sql+" AND ORDER_STATUS_TYPE IN (10,25,30,35) ";
				// added by gangadharan for SRR20056-SCF-7232 , incident no. 27232 on 20/5/2011 
				// less than 10 is given while checking outstanding orders, because to 
				// include pending special approval, pending consent, pending authorization also 
				// 36,94 have been added to include allocated and uncollected which was missing 
				// before while checking for inprocess orders 
				else if (order_status.equals("OUT")) 
					sql=sql+" AND ORDER_STATUS_TYPE <=10 ";
				else if (order_status.equals("INP"))
					sql=sql+" AND ORDER_STATUS_TYPE IN (25,30,35,36,94)  ";
				// added ends 
			}
			if ( (!(patient_class.equals("")))&&(patient_class!=null)){
				sql=sql+" AND A.PATIENT_CLASS=?";
				chkFields.add( patient_class.trim() );
			}
			if ( (!(location_type.equals("")))&&(location_type!=null)){
				sql=sql+" AND A.SOURCE_TYPE=?";
				chkFields.add( location_type.trim() );
			}

			if ( (!(location_code.equals("")))&&(location_code!=null)){
				sql=sql+" AND A.SOURCE_CODE=?";
				chkFields.add( location_code.trim() );
			}

			if ( (disp_locn_code!=null) && !(disp_locn_code.equals("")) && !(disp_locn_code.equals("null"))){
				out.println("entered");
				sql=sql+" AND NVL(E.DISP_LOCN_CODE,'x')=NVL(?,'x')";
				chkFields.add( disp_locn_code.trim() );
			}
			if ( (!(dt_from.equals("")))&&(dt_from!=null)){
				//if from date is specified
				if ( (!(dt_to.equals("")))&&(dt_to!=null)){
					//if to date is also  specified
					sql=sql+" AND A.ORD_DATE_TIME BETWEEN TO_DATE(?,'DD/MM/YYYY') AND TO_DATE(?,'DD/MM/YYYY') + 0.999 ";
					chkFields.add( dt_from.trim() );
					chkFields.add( dt_to.trim() );
				}
				else{
					// if todate is not specified
					sql=sql+" AND A.ORD_DATE_TIME >= TO_DATE(?,'DD/MM/YYYY') ";
					chkFields.add( dt_from.trim() );
				}

			}
			else{
				if ( (!(dt_to.equals("")))&&(dt_to!=null)){
				//if only  to date is  specified
				sql=sql+" AND A.ORD_DATE_TIME <= TO_DATE(?,'DD/MM/YYYY') + 0.999 ";
				chkFields.add( dt_to.trim() );

				}
			}
			chkFields.add( locale.trim() );
			sql=sql+" and b.language_id = ? ORDER BY to_date(ord_date_time, 'dd/mm/yyyy hh24:mi' )DESC, A.ORDER_ID"; // added to_date(ord_date_time, 'dd/mm/yyyy hh24:mi' )DESC, for KAUH-SCF-040 [IN033356]
			//End of concatenating search conditions
			sqlMap.put( "sqlData",  sql);

			//Function Parameters
			HashMap funcMap = new HashMap();

			//The fields are going to be display
			ArrayList displayFields = new ArrayList();
			displayFields.add("ORD_DATE_TIME");
			displayFields.add("ORDER_ID");
			displayFields.add("PRACTITIONER_NAME");
			displayFields.add("LOCATION");
			displayFields.add("PATIENT_ID");
			displayFields.add("PATIENT_NAME");
			displayFields.add("ORDER_STATUS_TYPE");
			displayFields.add("DISP_LOCN");
			//displayFields.add("DISP_LOCN_CODE");


			// Adding function related array list into the HashMap
			funcMap.put( "displayFields", displayFields );
			funcMap.put( "chkFields", chkFields );
			//Calling the Result from Common Adaptor as a arraylist.
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap,request);

			if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
%>
				<table cellpadding=0 cellspacing=0 width="99%" align="center" topmargin='0'>
					<tr>
						<td width="80%" class="white">&nbsp;</td>
						<td width="20%" class="white">&nbsp;
<%
						// For display the previous/next link
						out.println(result.get(1));
%>
						</td>
					</tr>
				</table>
				<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" topmargin='0'>
					<tr>
						<th width="20%"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
						<th width="10%" ><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></th>
						<th width="20%"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th> 
						<th width="15%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
						<th width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
						<th width="23%"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
						<th width="2%"><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
					</tr>
<%
					//Retriving the records from result arraylist
					ArrayList records=new ArrayList();
					String classvalue="",colorCode="", dkVal="", orderCode="", dispStyle="", evtmthd="";
					for(int recCount=2; recCount<result.size(); recCount++) {
						if ( recCount % 2 == 0 )
							classvalue = "QRYODDSMALL" ;
						else
							classvalue = "QRYEVENSMALL" ;
%>
						</tr>
						<tr>
<%
						records=(ArrayList) result.get( recCount );
						orderCode= (String)records.get( 6 );
						for(int colCount=0; colCount<records.size(); colCount++){
							if (colCount==7)
								continue;
							dkVal = (String)records.get( colCount )==null?"":(String)records.get( colCount );
							dispStyle="";
							evtmthd="";
							if(colCount==0 ){
								dkVal	=	com.ehis.util.DateUtils.convertDate(dkVal,"DMYHM","en",locale);
							}
							else if (colCount==1){ 
								//Check if link has to be given
								if (orderCode.equals("58")||orderCode.equals("56") ){
									dispStyle = "cursor:pointer;color:blue;";
									evtmthd = "loadOrderDetails('"+dkVal+"','"+(String)records.get(7)+"');";
								}
							}
							else if (colCount==6){
								dkVal = "";
								if (orderCode.equals("58"))
									dispStyle = "background-color:#990000";
								else if(orderCode.equals("56"))
									dispStyle = "background-color:#CC9933";
								else if(orderCode.equals("10") || orderCode.equals("05")  || orderCode.equals("03") ||orderCode.equals("00")  )
									dispStyle = "background-color:#FF0000";
								else
									dispStyle = "background-color:green";
							}
%>
							<td class='<%=classvalue%>' style="<%=dispStyle%>" onclick="<%=evtmthd%>">&nbsp;<%=dkVal%>&nbsp;</td>
<%
						}
					}		//end of record count
				}
				else{
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</script>
<%
			}
%>
			</tr>
<%
			out.println(CommonBean.setForm ( request ,"../../ePH/jsp/QueryPresVsDispOrder.jsp", searched) );
		}//end of try
		catch (Exception e){
			e.printStackTrace();
		}
%>
		</table>
	</body>
</html>

