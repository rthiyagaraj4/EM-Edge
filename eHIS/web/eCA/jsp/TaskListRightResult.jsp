<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      	Name        	Description
--------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
22/03/2012    	IN29559       	DineshT      	Record consent criteria in TaskList function
26/06/2012    	IN033488      	Chowminya G    	Incident No: IN033488 -  Error Marking - Result completed indicator> 
27/07/2012    	IN034216      	Chowminya G    	Incident No: IN034216 -  Blood Unit Consumption Records are not displaying in Task List. 
09/11/2012		IN030473		Ramesh G		Bru-HIMS-CRF-032 
28/11/2012		IN036495		Ramesh G		Task List: The Alignment is not correct
29/05/2013		IN040198		Chowminya G		Status of the Order Catalog is displayed wrongly
12/06/2013	  	IN040761		Akbar			Task List : Include Bed Number & Priority Zone (AE)
26/06/2013	  	IN041063		Nijitha			ALPHA-CA-For discharged Inpatients the Bed No, and for Emergency patients Priority Zone is displayed at Tasklist function. 
---------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
19/10/2017	IN065324		Dinesh T			19/10/2017		Ramesh G		To display the price in OR screen and 																						the billing status in Manage Specimen 																						screen
15/12/2017	IN065942		Dinesh T			15/12/2017		Ramesh G		In Nuclear medicine  department we required the barcode 																	functionality at the time of Registration of order,required 																patient Id,patient name,age,sex,register date and name of 																	study.
03/01/2018	IN066125		Dinesh T			03/01/2017		Ramesh G		EM run on window 10 and IE 11
14/03/2019	IN068778		Selvin M			14/03/2019		Ramesh G		TBMC-CRF-0011
22/01/2019	IN069244		Ramya Maddena		25/01/2019		Ramesh Goli	   	MMS-KH-CRF-0005.1
20/04/2020	IN072853		Sivabagyam M		20/04/2020		Ramesh G		CA-MMS-TASK_LIST
05/15/2020	IN071618	   	Nijitha S	 		05/15/2020		Ramesh Goli		PMG2019-MMS-CRF-0004
22/08/2020	IN073625		Ramesh Goli			22/08/2020		Ramesh G		OR-PMG2020-TECH-CRF-0001/01-Place Order
27/07/2022	26826			Ramesh G											MMS-DM-CRF-0197
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,java.util.*,eCA.*,eOR.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/*		Added by Kishore Kumar N on Sept08-09 for CRF 691	*/
String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
/* ends here. */
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<!-- <link rel='StyleSheet' href='../../eCommon/html/contextMenu.css' type='text/css' /> -->
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/dchk.js"></script>
	<script language="javascript" src="../../eCA/js/TaskList.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>	
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	<Script Language="JavaScript" src="../../eBT/js/BTMessage.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

	var detailArray = new Array(); 

	function hideToolTip(obj,imgObj)
	{
		document.getElementById("tooltiplayer").style.visibility = 'hidden'
		if (obj != null)
		{
			obj.className = 'gridDataBlue';
			document.getElementById(imgObj).src = "../../eCommon/images/inactiveArrow.gif";
		}	
	}

	function callMouseOver(obj)
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';
	}

	function callOnMouseOut(obj)
	{
		obj.className = 'contextMenuItem';
	}

	function callMouseOver_BT(colval1,index,obj)
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

		var tabdata = "<table class='grid' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>Product</td><td class=columnHeadercenter nowrap>Unit No</td><td class=columnHeadercenter nowrap>Blood Group</td><td class=columnHeadercenter nowrap>Rhesus</td></tr>";

		if(colval1 == 'PRDDTL')
		{
			if(detailArray[index] != '')
			{
				tabdata +=detailArray[index]+"</table>";
				document.getElementById("details").innerHTML = tabdata;

				var wdth 	  = obj.offsetWidth;
				var hght1 	  = obj.offsetHeight;

				var wdth1 = getPos(obj).x - wdth;
				var hght = getPos(obj).y + hght1;
				
				document.getElementById("details").style.top  = hght;
				document.getElementById("details").style.left  = wdth1;
				document.getElementById("details").style.visibility = 'visible' ;
			}
		}
		else
		{
			document.getElementById("details").style.visibility='hidden' ;
		}

	}

	function callOnMouseOut_BT(obj)
	{
		obj.className = 'contextMenuItem';
		document.getElementById("details").style.visibility='hidden' ;
	}

	function getPos(inputElement)
	{
		var coords =  new Object();
		coords.x = 0;
		coords.y = 0;
		try
		{
			targetElement = inputElement;
			if(targetElement.x && targetElement.y)
			{
				coords.x = targetElement.x;
				coords.y = targetElement.y;
			}
			else
			{
				if(targetElement.offsetParent)
				{
					coords.x += targetElement.offsetLeft;
					coords.y += targetElement.offsetTop;
					while(targetElement = targetElement.offsetParent)
					{
						coords.x += targetElement.offsetLeft;
						coords.y += targetElement.offsetTop;
					}
				}
				else
				{
					//alert("Could not find any reference for coordinate positioning.");
				}
			}
			return coords;
		}
		catch(error)
		{
			return coords;
		}
	}

	//function displayToolTip(val,val1,orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, task_categ, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id,parent_order_id, orderctlHDR, imgObj,dob,accssion_num,practname,patientDtls,patName,curr_sys_date)//IN065942

function displayToolTip(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, task_categ, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id, parent_order_id, orderctlHDR, imgObj, dob, accssion_num, practname, patientDtls, patName, curr_sys_date, prn_reg_ord, split_order_yn) 
{
    callMouseOverOnTD(orderctlHDR, imgObj);

    // Call the appropriate buildTable function based on task_categ
    if (task_categ == 'B') {
        buildTable_BT(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id);
    } else {
        buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, parent_order_id, dob, accssion_num, practname, patientDtls, patName, curr_sys_date, index, task_categ, prn_reg_ord, split_order_yn);
    }

    // Get the clicked element's position
    var orderctlHDR1 = orderctlHDR.id;
    var elementWidth = document.getElementById(orderctlHDR1).offsetWidth;
    var elementHeight = document.getElementById(orderctlHDR1).offsetHeight;
    var elementPos = getPos(orderctlHDR);
    
    var x = elementPos.x + elementWidth; // Positioning the tooltip immediately to the right
    var y = elementPos.y;

    // Get the body dimensions
    var bodyWidth = document.body.offsetWidth;
    var bodyHeight = document.body.offsetHeight;

    // Ensure the tooltip stays within the bounds of the screen horizontally
    if (x + document.getElementById("tooltiplayer").offsetWidth > bodyWidth) {
        x = bodyWidth - document.getElementById("tooltiplayer").offsetWidth;
    }

    // Vertical position handling: Allow overflow
    if (y + document.getElementById("tooltiplayer").offsetHeight > bodyHeight) {
        // Ensure the tooltip doesn't overflow vertically out of the body
        y = bodyHeight - document.getElementById("tooltiplayer").offsetHeight;
    }

    // Allow top overflow by allowing negative `y` values
    var tooltipHeight = document.getElementById("tooltiplayer").offsetHeight;
    if (y < -tooltipHeight) {
        y = -tooltipHeight; // Tooltip will overflow the top if y is less than negative tooltip height
    }

    // Set the position of the tooltip
    document.getElementById("tooltiplayer").style.left = x + "px";
    document.getElementById("tooltiplayer").style.top = y < 0 ? "0px" : y + "px";
    document.getElementById("tooltiplayer").style.visibility = 'visible';
}




	//function buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id,parent_order_id,dob,accssion_num,practname,patientDtls,patName,curr_sys_date,index,task_categ)//IN065942
	function buildTable(val, val1, orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id,parent_order_id,dob,accssion_num,practname,patientDtls,patName,curr_sys_date,index,task_categ,prn_reg_ord,split_order_yn)//IN065942//IN071618
	{
		var rowval   = val.split (",");	
		//IN061903 start
		//var row      = ("Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn,LB,View,RegisterOrder,NewList,SpecimenCollection,SpecimenDispatch,RecordConsent"); //Chowminya,IN29559
		var row      = ("Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,NotDone,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn,LB,View,RegisterOrder,NewList,SpecimenCollection,SpecimenDispatch,RecordConsent");
		//IN061903 ends
		rowval1      = row.split(",");
		var nn = 0;
		
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
 		for( var i=0; i<rowval.length; i++ )
		{
			var colval  = rowval[i];
			var colval1 = rowval1[i];
			
			if (colval != "" )
			{
				tab_dat   =  tab_dat+"<tr>" ;		
			
				if(colval1=="LB")
				{
					if(colval=="LINE") 
					{
						if(nn>0)
						{
							tab_dat    = tab_dat+ "<td class='contextMenuItemSeperator' nowrap id='mouse'><hr class='contextMenuItemSeperator' size=3 width='100%' align=center></td>" ;
							nn=0;
						}
					}
					else
					{						
						tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'>"+colval+" </td>" ;
						nn=nn+1;
					}
				}
				else if (colval1 != "ChangePerformLocn" && colval1 != "SentOut" && colval1 != "RegisterOrder" && colval1 != "ReceiveResult" && colval1!="NewList" && colval1!="SpecimenCollection" && colval1!="SpecimenDispatch" && (!((sent_out_flag == 'S' || sent_out_flag == 'R') && (colval1 == "ResultEntry" || colval1 == "Completion" ))) ||  colval1 == "Replace" ||  colval1 == "ChangeChargeType")			
				{
					/*if(((colval1=="Replace"))||((colval1=="UpdateLine"))||((colval1=="UpdateOrder")))
					{
						if( parent_order_id == null || parent_order_id == "undefined" || parent_order_id == "")
                          orderId = orderId;
						else
						orderId = parent_order_id;
					}*/

					nn=nn+1;
					
					tab_dat    =tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+escape(patient_dtls)+"','"+escape(discr_msr_id)+"','"+proc_code_scheme+"','"+order_type_code+"','"+order_set_id+"','"+dob+"','"+accssion_num+"','"+escape(practname)+"','"+escape(patientDtls)+"','"+escape(patName)+"','"+ord_pract_id+"','"+escape(curr_sys_date)+"','"+index+"','"+task_categ+"');>"+colval+" </a></td>" ;
				}
				else
				{
					nn=nn+1;
						
					//tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callPerfMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+priority+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+cont_order_ind+"','"+appt_ref_num+"','"+ord_pract_id+"','"+escape(date_time)+"','"+consent_status+"','"+order_set_id+"','"+dob+"');>"+colval+" </a></td>" ;//IN065942
					//tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callPerfMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+priority+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+cont_order_ind+"','"+appt_ref_num+"','"+ord_pract_id+"','"+escape(date_time)+"','"+consent_status+"','"+order_set_id+"','"+dob+"','"+prn_reg_ord+"');>"+colval+" </a></td>" ;//IN065942
					tab_dat    = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callPerfMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+priority+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+cont_order_ind+"','"+appt_ref_num+"','"+ord_pract_id+"','"+escape(date_time)+"','"+consent_status+"','"+order_set_id+"','"+dob+"','"+prn_reg_ord+"','"+split_order_yn+"');>"+colval+" </a></td>" ;//IN065942//IN071618
				}
			
				tab_dat = tab_dat+ "</tr> " ;
			}
			
		}
		tab_dat = tab_dat+ "</table> ";
		document.getElementById("t").innerHTML = tab_dat;
	}

	function buildTable_BT(val,val1,orderId, encounterId, sex, patient_id, procedure_code, patient_class, ord_cat, order_status, order_line_num, performing_facility, performing_location_type, performing_location, int_or_ext, sent_out_flag, order_type_code, priority, source_type, source_code, patient_dtls, discr_msr_id, proc_code_scheme, cont_order_ind, appt_ref_num, ord_pract_id, date_time, consent_status, order_set_id, index, specimen_no, order_facility_id, unit_no, product_code, product_desc, blood_group, rhesus_code, row_id)
	{
		var colval = "";
		var rowval   = val.split (",");	
		
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
 		for( var i=0; i<rowval.length; i++ ) 
		{
			var colval1  = rowval[i];
			
			if (colval1 != "" )
			{
				tab_dat   =  tab_dat+"<tr>" ;		
			
				if(colval1 == "DIVIDER")
				{
					tab_dat = tab_dat+ "<td class='contextMenuItemSeperator' nowrap id='mouse'><hr class='contextMenuItemSeperator' size=3 width='100%' align=center></td>" ;
				}
				else
				{
					if(colval1 == "ORDDTL")
						colval = getLabel("eCA.ViewOrderDetail.label","CA");
					else if(colval1 == "PRDDTL")
						colval = getLabel("eCA.ProductDetails.label","CA");
					else if(colval1 == "TRANSHIST")
						colval = getLabel("eCA.TransfusionHistory.label","CA");
					else if(colval1 == "REQRMENT")
						colval = getLabel("Common.Requirement.label","Common");
					else if(colval1 == "ANDIBODY")
						colval = getLabel("eCA.Antibody.label","CA");
					else if(colval1 == "RQSTREPRNT")
						colval = getLabel("Common.Reprint.label","Common");
					else if(colval1 == "RQSTPRNT")
						colval = getLabel("Common.Request.label","Common") + " / " + getLabel("Common.print.label","Common");
					else if(colval1 == "RECCONS")
						colval = getLabel("eCA.RecordConsumption.label","CA");
					
					tab_dat  = tab_dat+ "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver=\"callMouseOver_BT('"+colval1+"','"+index+"',this)\" onMouseOut='callOnMouseOut_BT(this);'><a class= 'contextMenuLink' href=javascript:callBTMenuFunctions('"+colval1+"','"+escape(val1)+"','"+orderId+"','"+encounterId+"','"+sex+"','"+patient_id+"','"+escape(procedure_code)+"','"+patient_class+"','"+ord_cat+"','"+order_status+"','"+order_line_num+"','"+performing_facility+"','"+performing_location_type+"','"+performing_location+"','"+int_or_ext+"','"+sent_out_flag+"','"+priority+"','"+order_type_code+"','"+source_type+"','"+source_code+"','"+cont_order_ind+"','"+appt_ref_num+"','"+ord_pract_id+"','"+escape(date_time)+"','"+consent_status+"','"+order_set_id+"','"+specimen_no+"','"+order_facility_id+"','"+escape(unit_no)+"','"+product_code+"','"+escape(product_desc)+"','"+blood_group+"','"+rhesus_code+"','"+row_id+"');>"+colval+" </a></td>" ;
				}
			
				tab_dat = tab_dat+ "</tr> " ;
			}
		}
		tab_dat = tab_dat+ "</table> ";
		document.getElementById("t").innerHTML = tab_dat;
	}
	/*function dummy()
	{}*/

	</script>
	
</head>
<!-- Modified by Kishore Kumar N on Sept08-09 for CRF 691	-->
<body onScroll="processScroll()" onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT' onLoad="enableBtn('<%=callFrom%>');moveFrame('<%=callFrom%>')">
<!-- ends here.  -->
<%
PatTaskListRepository patTask = (PatTaskListRepository)getObjectFromBean("patTask","eCA.PatTaskListRepository",session);




java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) property.getProperty("LOCALE");

String practitioner_id=(String) session.getValue("ca_practitioner_id");
String practitioner_type=(String) session.getValue("practitioner_type");//IN065942
String resp_id    			=	(String) session.getValue("responsibility_id");
String locn_desc=request.getParameter("locn_desc")==null?"":request.getParameter("locn_desc");
String locn_code=request.getParameter("locn_code")==null?"":request.getParameter("locn_code");

String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
String status_code =request.getParameter("status_code")==null?"":request.getParameter("status_code");
String taskSelect=request.getParameter("taskSelect")==null?"":request.getParameter("taskSelect");

String OrderCategory=request.getParameter("OrderCategory")==null?"":request.getParameter("OrderCategory");
String OrderType=request.getParameter("OrderType")==null?"":request.getParameter("OrderType");
String Groupby=request.getParameter("Groupby")==null?"":request.getParameter("Groupby");
String To_date=request.getParameter("To_date")==null?"":request.getParameter("To_date");
String From_date=request.getParameter("From_date")==null?"":request.getParameter("From_date");
//Commented by Archana Dhal related to IN18772 and IN18781.
//From_date = com.ehis.util.DateUtils.convertDate(From_date,"DMY",locale,"en");
//To_date = com.ehis.util.DateUtils.convertDate(To_date,"DMY",locale,"en");

String pat_discharge=request.getParameter("pat_discharge")==null?"":request.getParameter("pat_discharge");
String chkAll=request.getParameter("chkAll")==null?"":request.getParameter("chkAll");
String ckhDue=request.getParameter("ckhDue")==null?"":request.getParameter("ckhDue");
String chkElapsed=request.getParameter("chkElapsed")==null?"":request.getParameter("chkElapsed");
String chkPerformed=request.getParameter("chkPerformed")==null?"":request.getParameter("chkPerformed");
String chkFuture=request.getParameter("chkFuture")==null?"":request.getParameter("chkFuture");
String chkReg=request.getParameter("chkReg")==null?"":request.getParameter("chkReg");
String chkOverdue=request.getParameter("chkOverdue")==null?"":request.getParameter("chkOverdue");
String chkUnclassify=request.getParameter("chkUnclassify")==null?"":request.getParameter("chkUnclassify");
String taskSelectAll=request.getParameter("taskSelectAll")==null?"":request.getParameter("taskSelectAll");
String AdminRoute=request.getParameter("AdminRoute")==null?"":request.getParameter("AdminRoute");
String bt_status=request.getParameter("bt_status")==null?"":request.getParameter("bt_status");
String definition=request.getParameter("definition")==null?"":request.getParameter("definition");
String interventionType=request.getParameter("interventionType")==null?"":request.getParameter("interventionType");
String viewBy=request.getParameter("viewBy")==null?"":request.getParameter("viewBy");
String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String isBTViewBillDtls=request.getParameter("isBTViewBillDtls")==null?"":request.getParameter("isBTViewBillDtls");//IN065324

String taskListstr1 = "",taskListstrKey = "",taskListstrVal = "";
int taskIndex = 0;

String facilityId =session.getValue("facility_id")==null ? "" :(String)	session.getValue("facility_id") ;

String slClassValue="";
String discr_msr_id="";
String sent_out_flag 		= "";
String temp_id="";
String location="";
String cont_order_ind="";
String cellBGColor = "";
String patientDetails ="";
String maxRecord = "";

StringTokenizer strTokens = null;
ArrayList TaskAlldata =new ArrayList();
ArrayList ErrStatusChk		= null;//--[IN033488]

String action_type    = "";//--[IN033488]
	String action_date_time    = "";
	String action_by_id    = "";

String bean_id = "Or_ResultReporting";
String bean_name = "eOR.ResultReportingBean";

//26826 Start.
ResultReportingBean bean					= (ResultReportingBean)getBeanObject( bean_id, bean_name, request ) ;
bean.setSiteSpecific("DX_CHK_BFR_PLACE_ORDERS");
//26826 End.

String from	 = patTask.checkForNull(request.getParameter( "from" )) ;
String to	 = patTask.checkForNull(request.getParameter( "to" )) ;

if (from.equals(""))
	from = "1";

if (to.equals(""))
	to = "50";

int start	 = Integer.parseInt(from);
int end		 = Integer.parseInt(to);

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

StringBuffer layer = new StringBuffer();
String sql = "";
String product_desc = "";
String blood_group = "";
String rhesus_code = "";
String request_by = "";
String request_date = "";
String parent_order_id = "";
String split_order_yn = "N";//IN071618
try
{
	con = ConnectionManager.getConnection(request);

	if (taskSelectAll != null && taskSelectAll != "")
	{			
		strTokens = new StringTokenizer(taskSelectAll,"||");	
		while (strTokens.hasMoreTokens())
		{				
			taskListstr1 = strTokens.nextToken();
			taskIndex = taskListstr1.indexOf("~");
			taskListstrKey = taskListstr1.substring(0,taskIndex);
			taskListstrVal = taskListstr1.substring(taskIndex+1,taskListstr1.length());				
			if (taskListstrVal.equals("A"))
			{
				TaskAlldata.add(taskListstrKey);
			}											
		}									
	}
	
	// Added By Sridhar Reddy PMG20089-CRF-0691
	HashMap paramListMap = new  HashMap();
	paramListMap.put("locn_desc",locn_desc);
	if(callFrom.equals("IM") && viewBy.equals("A"))
		paramListMap.put("locn_code","");
	else
		paramListMap.put("locn_code",locn_code);

	paramListMap.put("location_type",location_type);
	paramListMap.put("status_code",status_code);
	paramListMap.put("taskSelect",taskSelect);
	paramListMap.put("OrderCategory",OrderCategory);
	paramListMap.put("OrderType",OrderType);
	paramListMap.put("Groupby",Groupby);
	paramListMap.put("To_date",To_date);
	paramListMap.put("From_date",From_date);
	paramListMap.put("pat_discharge",pat_discharge);
	paramListMap.put("patient_id",patient_id);
	paramListMap.put("facilityId",facilityId);
	paramListMap.put("chkAll",chkAll);
	paramListMap.put("ckhDue",ckhDue);
	paramListMap.put("chkElapsed",chkElapsed);
	paramListMap.put("chkPerformed",chkPerformed);
	paramListMap.put("chkFuture",chkFuture);
	paramListMap.put("chkReg",chkReg);
	paramListMap.put("chkOverdue",chkOverdue);
	paramListMap.put("chkUnclassify",chkUnclassify);
	paramListMap.put("practitioner_id",practitioner_id);
	paramListMap.put("resp_id",resp_id);
	paramListMap.put("TaskAlldata",TaskAlldata);
	paramListMap.put("AdminRoute",AdminRoute);
	paramListMap.put("bt_status",bt_status);
	paramListMap.put("definition",definition);
	paramListMap.put("interventionType",interventionType);
	paramListMap.put("start",start);
	paramListMap.put("end",end);
	paramListMap.put("callFrom",callFrom);
	paramListMap.put("viewBy",viewBy);
	paramListMap.put("encounter_id",encounter_id);	
	paramListMap.put("relationship_id",request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id"));
	ArrayList taskResult = patTask.getTaskResult(property,paramListMap);

	// End PMG20089-CRF-0691

    // Commented By Sridhar Reddy PMG20089-CRF-0691
	//ArrayList taskResult = patTask.getTaskResult(property,locn_desc,locn_code,location_type,status_code,taskSelect,OrderCategory,OrderType,Groupby,To_date,From_date,pat_discharge,patient_id,facilityId,chkAll,ckhDue,chkElapsed,chkPerformed,chkFuture,chkReg,chkOverdue,chkUnclassify,practitioner_id,resp_id,TaskAlldata,AdminRoute,bt_status,definition,interventionType,start,end);	
	
	if( taskResult.size() == 0)//IN072853
	//if( taskResult.size() == 0 && !"V".equals(taskSelect))// added taskSelect condition for IN069244 //commented for IN072853
	{ 
%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			/*		Modified by Kishore Kumar N on Sept08-09 for CRF 691	*/
			clearValuesfor('<%=callFrom%>'); 
			/*ends here.*/
		</script>
<%
	}
	else
	{
%>
<form name='TaskListFilterResultForm' id='TaskListFilterResultForm'  action="../../eCA/jsp/TaskListRightResult.jsp" method="post">
<div id="divHeadSep">
<table class='grid' width="96%" height='' id="tableresult">
<tr id="heading" >
		<td class=columnheader width='' nowrap>&nbsp;&nbsp;</td>
		<%if (Groupby.equals("P")){	%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<%}%>
        <td class=columnheader width='' nowrap><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>		
		<td class=columnheader width='' nowrap><fmt:message key="Common.RequestType.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Request.label" bundle="${common_labels}"/></td>
		<%if (Groupby.equals("T")){	%>
        <td class=columnheader width='' nowrap><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
		<%}%>
		<%if (taskSelect.equals("I")||taskSelect.equals("")){	%>
        <td class=columnheader width='' ><fmt:message key="eCP.PatientInstructionsIntervention.label" bundle="${cp_labels}"/></td>
		<%}%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Stage.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
</tr>


<%
	for( int i=0 ; i< taskResult.size() ; i++ )
	{
		if(i % 2 == 0)
		{
			slClassValue = "gridData";
		}
		else
		{
			slClassValue = "gridData";
		}	

		String[] record = (String[])taskResult.get(i);
		if(i==0)
		{
			if(record[48] != null)
				maxRecord = patTask.checkForNull((String)record[48]);
			else
				maxRecord = "0";
			
			if((Integer.parseInt(maxRecord)>0) || (start>1))
			{
	%>
				<tr align="right">
					<td colspan="10">
						<jsp:include page="ResultScrolling.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name ="from" value= "<%=start%>" /> 
						<jsp:param name ="to" value= "<%=end%>" />	
						<jsp:param name ="total_size" value= "<%=maxRecord%>" />   										 
						<jsp:param name ="form_name" value= "TaskListFilterResultForm" />  
						</jsp:include>
					</td>
				</tr>							
	<%
			}
		}
		if(record[34].equals("B"))
		{
			//In below query 'am_get_desc.am_practitioner(a.REQUEST_FOR_ISSUE_BY,?,'2') REQUEST_FOR_ISSUE_BY' is added by Archana Dhal on 11/23/2010 related to incident no. IN025159.
			sql = "SELECT F.short_Desc PRODUCT_DESC,A.unit_no UNIT_NO, B.blood_group BLOOD_GROUP, B.rhesus_code RHESUS_CODE, am_get_desc.am_practitioner(a.REQUEST_FOR_ISSUE_BY,?,'2') REQUEST_FOR_ISSUE_BY, TO_CHAR (a.REQUEST_FOR_ISSUE_DATE, 'dd/mm/yyyy HH24:MI') REQUEST_FOR_ISSUE_DATE FROM BT_UNIT_REQUEST_DTL A, BT_BLOOD_UNITS_MAST B, BT_PRODUCT_MAST_LANG_VW F WHERE A.PATIENT_ID = ? and F.language_id = ? and  A.OPERATING_FACILITY_ID = ? AND b.unit_no = a.unit_no AND b.product_code = a.product_code AND f.product_code = a.product_code 	and a.PRODUCT_CODE = ? and a.UNIT_NO = ? AND a.SPECIMEN_NO = ? ORDER BY A.issued_date";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,record[22]);
			pstmt.setString(3,locale);
			pstmt.setString(4,record[43]);//--[IN034216]
			pstmt.setString(5,record[45]);
			pstmt.setString(6,record[44]);
			pstmt.setString(7,record[42]);

			rs = pstmt.executeQuery();
			while(rs.next())
			{
				layer.setLength(0);
				product_desc = rs.getString("PRODUCT_DESC") == null ? "" : rs.getString("PRODUCT_DESC");
				blood_group = rs.getString("BLOOD_GROUP") == null ? "" : rs.getString("BLOOD_GROUP");
				rhesus_code = rs.getString("RHESUS_CODE") == null ? "" : rs.getString("RHESUS_CODE");
				request_by = rs.getString("REQUEST_FOR_ISSUE_BY") == null ? "" : rs.getString("REQUEST_FOR_ISSUE_BY");
				request_date = rs.getString("REQUEST_FOR_ISSUE_DATE") == null ? "" : rs.getString("REQUEST_FOR_ISSUE_DATE");
				
				layer.append("<tr><td class=gridData nowrap>"+product_desc+"</td>"+
							"<td class=gridData>"+rs.getString("UNIT_NO")+"</td>"+
							"<td class=gridData>"+blood_group+"</td>"+
							"<td class=gridData>"+rhesus_code+"</td></tr>");
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			out.println("<script>detailArray["+i+"]='"+layer.toString()+"';</script>");
		}

		String accession_num = "";
		String trans_pract_id = "";
		String note_type = "";
		String note_desc = "";
		String note_group = "";
		String request_pract_name = "";
		String req_pract_id = "";
		
		if(record[34].equals("I") && record[2].equals("$NTS"))
		{
			sql = "select a.REQ_ACCESSION_NUM contr_mod_accession_num,a.TRANS_PRACT_ID,a.NOTE_TYPE, ca_get_desc.CA_NOTE_TYPE(a.NOTE_TYPE,?,1) NOTE_TYPE_DESC,( select ca_get_desc.CA_NOTE_GROUP(NOTE_GROUP_ID,?,1) from ca_note_type f  where  f.note_type=a.NOTE_TYPE ) note_group_desc, am_get_desc.am_practitioner (a.REQ_PRACT_ID,?,'1') request_pract_name,a.REQ_PRACT_ID  from CA_TRANSRIPTION_REQ  A, CA_PAT_TASK_LIST B where a.REQ_REFERENCE=b.REQ_REFERENCE and a.REQ_ACCESSION_NUM=b.REQ_ACCESSION_NUM and b.TASK_SRL_NO =? and b.PATIENT_ID=? /*and b.TASK_CODE='&NTS'*/";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,record[6]);
			pstmt.setString(5,record[22]);
		
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				accession_num = rs.getString("contr_mod_accession_num") == null ? "" : rs.getString("contr_mod_accession_num");
				trans_pract_id = rs.getString("TRANS_PRACT_ID") == null ? "" : rs.getString("TRANS_PRACT_ID");
				note_type = rs.getString("NOTE_TYPE") == null ? "" : rs.getString("NOTE_TYPE");
				note_desc = rs.getString("NOTE_TYPE_DESC") == null ? "" : rs.getString("NOTE_TYPE_DESC");
				note_group = rs.getString("note_group_desc") == null ? "" : rs.getString("note_group_desc");
				request_pract_name = rs.getString("request_pract_name") == null ? "" : rs.getString("request_pract_name");
				/*Added by Archana Dhal the below getString of REQ_PRACT_ID on 4/26/2010 at 4:20 PM for IN020723*/
				req_pract_id = rs.getString("REQ_PRACT_ID") == null ? "" : rs.getString("REQ_PRACT_ID");
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
		}
		if(record[8].compareTo("R")==0 || record[8].compareTo("N")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		}
		else if(record[8].compareTo("U")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
		}
		else if(record[8].compareTo("S")==0)
		{
			record[8]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Stat.label","or_labels");
		}	

		String sex1 = "";
		if (record[14].equalsIgnoreCase("M"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if(record[14].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

		if(record[31].equalsIgnoreCase("C"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		}
		else if(record[31].equalsIgnoreCase("N"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		}
		else if(record[31].equalsIgnoreCase("R"))
		{
			location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
		}
		String patientDtls="";//Chowminya,IN29559
		String patName=record[12];
		String curr_sys_date=com.ehis.util.DateUtils.getCurrentDate("DMYHM",localeName);
		patientDtls = record[12]+","+sex1+"/"+record[13]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[22];
		
		//Include Bed number - IN040761/Start
		//IN041063 Starts
		int visit_status=0;
		int adt_status=0;
		if(record[54] != null && !"".equals(record[54]))
		 visit_status = Integer.parseInt(record[54]);
		if(record[55] != null && !"".equals(record[55]))
		 adt_status = Integer.parseInt(record[55]);
		int dischargeStatus_EM=07;
		int dischargeStatus_IP=8;
		String BedDtls="";
		/*if(record[52] != null && !"".equals(record[52])) 
		{
			BedDtls = ","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","")+ ": "+record[52] ;
		}*/
		if(record[52] != null && !"".equals(record[52])) 
		{
			if("IP".equals(record[21]) && adt_status < dischargeStatus_IP || "EM".equals(record[21]) && visit_status < dischargeStatus_EM)
			{	
				BedDtls = ","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","")+ ": "+record[52] ;
			}
		}		
		if(record[21].equalsIgnoreCase("EM") && visit_status < dischargeStatus_EM)
		{
		//IN041063 Ends
			BedDtls = BedDtls +","+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PriorityZone.label","")+": "+record[53];
		}
		patientDtls = patientDtls + BedDtls;
		//Include Bed number - IN040761/End
		
		record[12]=record[12]+","+sex1+"/"+record[13]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+record[22]+","+location+"/"+record[33]+",";		

		StringBuffer menuText = new StringBuffer();
		String proc_code_scheme="";
		String procedure_code="";

		if (!(record[34].equals("S")) && !(record[34].equals("B")))
		{

		record[16]=record[16]+"_|Y|";
		if (record[34].equals("R"))				
			record[16]=record[16]+"Y|"; 	
		if(record[34].equals("C"))  //Condition Added by Chowminya,IN29559
			record[16]=record[16]+"N|N|N|N|Y|"; 
		}
		else
		{


			if(record[16].equals(""))
			{

				record[16]="N|N|N|N|N|_|N|N|N|N|_|N|N|_|Y|";

			}
		}
		StringTokenizer kv=new StringTokenizer(record[16],"|");		
		int count=kv.countTokens();
		
		boolean linef=false;
		boolean lineg=false;
		System.out.println("record[16]========>736====>"+record[16]);
		if(record[16].indexOf(":")!=-1)
		{

			String tempTokens="";
			StringBuffer stringtoken=new StringBuffer();
			while (kv.hasMoreTokens()) 
			{
				tempTokens = kv.nextToken();
				if(tempTokens.trim().length()>1)
				{

					String[] values1=record[16].split(":");
					proc_code_scheme=values1[1];
					procedure_code=values1[2];
					tempTokens=tempTokens.substring(0,1);
				}
				stringtoken.append(tempTokens);				
				stringtoken.append("|");				
			}
			record[16]=stringtoken.toString();
			stringtoken.setLength(0);
		}
		int n=1;		

		if(record[34].equals("B"))
		{

			StringTokenizer strToken = new StringTokenizer(record[16],"|");
			//int count1 = strToken.countTokens();
			String valueToken = "";
			while(strToken.hasMoreTokens()) 
			{
				valueToken = strToken.nextToken();
					menuText.append(valueToken+",");
			}
		}
		else
		{
			//System.out.println("---------------------inside else---------------------------");			
			if(count>1)
			{
				//IN073625 Start.
				//String[] values=record[16].split("|");
				String[] values=record[16].split("\\|");
				//IN073625 End.
				for(int m=0;m<values.length;m++) //IN073625
				//for(int m=0;m<count*2;m++) //IN073625
				{
					//System.out.println("(m===============tasklistrightresult.jsp======785==>"+m);
					//if(m%2==1)  //IN073625
					//{ //IN073625
					//	System.out.println("(m]================tasklistrightresult.jsp======788==>"+m);
						if(values[m].trim().length()>1)
						{
							values[m]=values[m].substring(0,1);
						}
					//	System.out.println("(values[m]================tasklistrightresult.jsp======793==>"+values[m]+"<=======");
						if(values[m].equals("Y") || values[m].equals("_"))
						{	
						//	System.out.println("(n===============tasklistrightresult.jsp======796==>"+n);
							switch(n)
							{
								/* IN061903 start
								case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;  
								case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
								case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;
										break;
								case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
								case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
								case 6: menuText.append( "LINE,");break;
								case 7: menuText.append( "'+getLabel('eOR.Discontinue.label','OR')+',");break;
								case 8: menuText.append( "'+getLabel('eOR.Hold.label','OR')+',");break;
								case 9: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
								case 10: menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
								case 11: menuText.append( "LINE,");break;
								case 12: menuText.append( "'+getLabel('eOR.Replace.label','OR')+',");break;
								case 13: menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
								case 14: menuText.append( "LINE,");break;
								case 15: menuText.append( "'+getLabel('Common.view.label','common')+',");
										 break;
								case 16: menuText.append( "'+getLabel('Common.RegisterOrder.label','COMMON')+',");
										 break;
								case 17: menuText.append( "'+getLabel('eOR.NewList.label','OR')+',");
										 break;
								case 18: menuText.append( "'+getLabel('eOR.SpecimenCollection.label','OR')+',");
										 break;
								case 19: menuText.append( "'+getLabel('eOR.SpecimenDispatch.label','OR')+',");
										 break;
								case 20: menuText.append( "'+getLabel('eOR.RecordConsent.label','OR')+',"); //Added By Chowminya,IN29559
										 break;
								*/
								case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;  
								case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
								case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;
										break;
								case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
								case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
								case 6: menuText.append( "LINE,");break;
								case 7: menuText.append( "'+getLabel('eOR.Discontinue.label','OR')+',");
								break;
								case 8: menuText.append("'+getLabel('eOR.NOTDONE.label','OR')+',");break;
								case 9: menuText.append( "'+getLabel('eOR.Hold.label','OR')+',");break;
								case 10: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
								case 11: menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
								case 12: menuText.append( "LINE,");break;
								case 13: menuText.append( "'+getLabel('eOR.Replace.label','OR')+',");break;
								case 14: menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
								case 15: menuText.append( "LINE,");break;
								case 16: menuText.append( "'+getLabel('Common.view.label','common')+',");
										 break;
								case 17: menuText.append( "'+getLabel('Common.RegisterOrder.label','COMMON')+',");
										 break;
								case 18: menuText.append( "'+getLabel('eOR.NewList.label','OR')+',");
										 break;
								case 19: menuText.append( "'+getLabel('eOR.SpecimenCollection.label','OR')+',");
										 break;
								case 20: menuText.append( "'+getLabel('eOR.SpecimenDispatch.label','OR')+',");
										 break;
								case 21: menuText.append( "'+getLabel('eOR.RecordConsent.label','OR')+',"); //Added By Chowminya,IN29559								
										 break;
								//IN061903 ends
								default: if(!linef)
										 menuText.append(",");
							}
						}
						else
							menuText.append(",");
						n++;
					//	} //IN073625
						//System.out.println("menuText================tasklistrightresult.jsp======866==>"+menuText);
					}
				}
			}

		if (record[12] != "" && record[12] != null)
		{
			patientDetails = record[12].substring(0,record[12].indexOf(",",record[12].indexOf("ID:")));
			patientDetails = patientDetails + BedDtls;   //IN040761 -> included to append Bed No & Pri zone
		}
		if (Groupby.equals("P"))
		{	
			if(!temp_id.equals(record[22]))
			{
%>	
				<tr>
					<td class='CAGROUP' colspan='8'><%=patientDetails%>					
					<%
					if(taskSelect.equals("M") && patTask.getCustomerID().equals("SKR")) 
					{
						if(Integer.parseInt(patTask.getAllergyYN(record[22]))>0)
						{
					%>
					&nbsp;
					<font color='red'>Known Case of Allergy</font>					
					<%
						}
					}
					%>
					</td>
					<!-- IN036495 Start.<td class='CAGROUP' colspan='2'> -->
					<%
					if (taskSelect.equals("I")||taskSelect.equals(""))
					{
					%>
					<td class='CAGROUP' colspan='3'>
					<%
					}else{
					%>
					<td class='CAGROUP' colspan='2'>
					<%
					}
					%>
					<!--IN036495 End.-->
<%
					if(taskSelect.equals("") || taskSelect.equals("M"))
					{
%>
					<input type='button' name='viewMARChart<%=i%>' id='viewMARChart<%=i%>' value='<fmt:message key="eCA.ViewMARChart.label" bundle="${ca_labels}"/>' onClick="callMednDetails('<%=record[22]%>','<%=locn_code%>','<%=To_date%>','<%=record[21]%>')">
<%
					}
					else
						out.println("&nbsp;");
%>
					</td>
				</tr>
<%
				temp_id=record[22];
			}
		}
		else if (Groupby.equals("T"))
		{
			if(!temp_id.equals(record[4]))
			{ //IN036495 Start.
%>	
			<!--	<tr>
					<td class='CAGROUP' colspan='10'><%=record[4]%></td>
				</tr>-->
<%				
				if (taskSelect.equals("I")||taskSelect.equals(""))
					{
					%>
					<tr>
						<td class='CAGROUP' colspan='11'><%=record[4]%></td>
					</tr>
					<%
					}else{
					%>
					<tr>
						<td class='CAGROUP' colspan='10'><%=record[4]%></td>
					</tr>					
					<%
					}
				//IN036495 End.
				temp_id=record[4];
			}
		}
		
		//IN071618 Starts
		String color_billed = "";
		
		if(!"null".equals(record[57]) || !"".equals(record[57]))
		{
				StringTokenizer stoken = new StringTokenizer(record[57],"!");
			
				while (stoken.hasMoreTokens()) 
				{
				  
				      stoken.nextToken();
		              stoken.nextToken();
		              stoken.nextToken();
					  color_billed = stoken.nextToken();
				 
				}	
				if (color_billed.equals("FULLYORPARTIALLYPAID")) {
					split_order_yn = "Y";
				} 
				

		
		} 
		//IN071618 Ends
		/*for(int j=0;j<record.length;j++)
		{
			out.println("record ="+record[j]+"=<BR>");
		}*/
%>
<input type='hidden' name='adminStatus<%=i%>' id='adminStatus<%=i%>' value='<%=record[5]%>'>
<input type='hidden' name='taskCategory<%=i%>' id='taskCategory<%=i%>' value='<%=record[34]%>'>
<input type='hidden' name='RESULT_TYPE<%=i%>' id='RESULT_TYPE<%=i%>' value='<%=record[35]%>'>
<input type='hidden' name='RESULT_ID<%=i%>' id='RESULT_ID<%=i%>' value='<%=record[36]%>'>
<input type='hidden' name='status<%=i%>' id='status<%=i%>' value='<%=record[11]%>'>
<input type='hidden' name='scheduleDate<%=i%>' id='scheduleDate<%=i%>' value='<%=record[3]%>'>
<input type='hidden' name='taskCode<%=i%>' id='taskCode<%=i%>' value='<%=record[2]%>'>
<input type='hidden' name='taskType<%=i%>' id='taskType<%=i%>' value='<%=record[0]%>'>
<input type='hidden' name='taskSrlNo<%=i%>' id='taskSrlNo<%=i%>' value='<%=record[6]%>'>
<input type='hidden' name='patientId<%=i%>' id='patientId<%=i%>' value='<%=record[22]%>'>
<input type='hidden' name='remarks<%=i%>' id='remarks<%=i%>' value=''>
<input type='hidden' name='performedId<%=i%>' id='performedId<%=i%>' value='<%=record[36]%>'>
<input type='hidden' name='orderId<%=i%>' id='orderId<%=i%>' value='<%=record[19]%>'>
<input type='hidden' name='orderNum<%=i%>' id='orderNum<%=i%>' value='<%=record[25]%>'>
<input type='hidden' name='encounterId<%=i%>' id='encounterId<%=i%>' value='<%=record[20]%>'>
<input type='hidden' name='facilityId<%=i%>' id='facilityId<%=i%>' value='<%=record[26]%>'>
<input type='hidden' name='contOrderInd<%=i%>' id='contOrderInd<%=i%>' value='<%=record[37]%>'>
<input type='hidden' name='apptRefNum<%=i%>' id='apptRefNum<%=i%>' value='<%=record[38]%>'>
<input type='hidden' name='ordPractID<%=i%>' id='ordPractID<%=i%>' value='<%=record[39]%>'>
<input type="hidden" name="orderCategory<%=i%>" id="orderCategory<%=i%>" value="<%=record[58]%>"> <!-- 26826 -->

<%
//26826 Start.
if(!"".equals(record[58])){
	String  dxChkBfrPlaceOrderYN= bean.allowedNewOrdersYN(record[22],record[20],record[21],record[26],record[58]);
%> <input type="hidden" name ="dxChkBfrPlaceOrderYN<%=i%>" value="<%=dxChkBfrPlaceOrderYN%>"> <%	
}else{
%> <input type="hidden" name ="dxChkBfrPlaceOrderYN<%=i%>" value="Y"> <%
}
//26826 End.	
	if(record[5].equals("D"))
	{
		cellBGColor = "background-color:#CCFFCC";
	}
	else if(record[5].equals("O") )
	{
		cellBGColor = "background-color:#CCECFF";
	}
	else if(record[5].equals("C") || record[5].equals("P") )
	{
		cellBGColor = "background-color:#66FFCC";
	}
	else if(record[5].equals("E") )
	{
		cellBGColor = "background-color:#FF99CC";
	}
	else if(record[5].equals("F") )
	{
		cellBGColor = "background-color:#D7D7D7";
	}
	else
	{
		cellBGColor = "";
	}
	
%>
<tr>
<%
	if(record[34].equals("B"))
	{
%>
	<td width='' class='<%=slClassValue%>' nowrap><img src="../../eCA/images/TL_BloodCon.gif" name='buc' alt='Blood Unit Consumption' height='15' width='15'/></td>
<%
	}
	else
	{
%>
<td width='' class='<%=slClassValue%>' style='<%=cellBGColor%>' nowrap><%=record[34]%>&nbsp;</td>		<!-- Indicator-->
<%
	}
	if (Groupby.equals("P"))
	{	
		/*
			Modified by Kishore kumar N, for ICN-20903,
 		    date coverted into THAI by using locale
		*/
		String dt = com.ehis.util.DateUtils.convertDate(record[4],"DMY","en",locale);
%>
	<td width='' class='<%=slClassValue%>'  nowrap><%=dt%></td>		<!-- Date-->
<%
	/*
		ends here.
	*/
	}
%> 
	<td width='' class='<%=slClassValue%>'  nowrap><%=record[17]%></td>		<!-- Time-->
<%
	if(record[34].equals("I") && record[2].equals("$NTS"))
	{
%>
	<td width='' class='<%=slClassValue%>' wrap><%=note_group%></td>	<!-- Order Type-->
<%
	}
	else
	{
%>
	<td width='' class='<%=slClassValue%>' wrap><%=record[1]%></td>	<!-- Order Type-->
<%
	}
	if(record[41]==null)record[41]="";
	if(record[15].indexOf("$$RD##")!=-1)
	{
		String[] str = (String[])record[15].split("!~!");
		String order_detail ="";
		String[] strtitle = null;
		for(int s=0;s<str.length;s++)
		{
			if(str[s].indexOf("$$RD##")!=-1)
			{
				String line_order = (String)str[s];
				strtitle  =line_order.split("::");
				String titleText = "";
				if(strtitle[1].length()>0)
				{
					titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
				}
				else
				{
					titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
				}
				strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
				order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
			}
			else
			{
				order_detail = order_detail+str[s]+", ";
			}
		}
		record[15] = order_detail;
		if(record[15].lastIndexOf(",") ==((record[15].length())-2))
		{
			record[15] = record[15] .substring(0,((record[15].length())-2));
		}
	}
	if(record[15].indexOf("!~!")!=-1)
	{
		record[15] = record[15].replace("!~!",",");
	}
	
	if(record[34].equals("O") || record[34].equals("R") || record[34].equals("S") || record[34].equals("B") || record[34].equals("C"))
	{
		/*if(record[37].equalsIgnoreCase("DS"))
		{
			parent_order_id = (String)patTask.parentOrderID(record[19]);
			
		}*/
%>
		<!--IN065942, starts-->
		<!-- <td width='' id='orderctl<%=i%>' class='gridDataBlue' wrap  onClick="displayToolTip('<%=menuText%>','<%=record[18]%>', '<%=record[19]%>', '<%=record[20]%>', '<%=record[14]%>', '<%=record[22]%>', '<%=procedure_code%>', '<%=record[21]%>', '<%=record[23]%>', '<%=record[24]%>', '<%=record[25]%>', '<%=record[26]%>', '<%=record[27]%>', '<%=record[28]%>', '<%=record[29]%>', '<%=sent_out_flag%>', '<%=record[30]%>', '<%=record[8]%>', '<%=record[31]%>', '<%=record[32]%>', '<%=java.net.URLEncoder.encode(record[12])%>', '<%=java.net.URLEncoder.encode(discr_msr_id)%>', '<%=proc_code_scheme%>', '<%=record[37]%>', '<%=record[38]%>', '<%=record[39]%>', '<%=record[3]%>', '<%=record[40]%>', '<%=record[41]%>', '<%=record[34]%>', '<%=i%>', '<%=record[42]%>', '<%=record[43]%>', '<%=record[44]%>', '<%=record[45]%>', '<%=product_desc%>', '<%=blood_group%>', '<%=rhesus_code%>', '<%=record[46]%>','<%=parent_order_id%>', this, 'imgArrow<%=i%>','<%=record[49]%>','<%=record[50]%>','<%=java.net.URLEncoder.encode(record[7])%>','<%=java.net.URLEncoder.encode(patientDtls)%>','<%=java.net.URLEncoder.encode(patName)%>','<%=java.net.URLEncoder.encode(curr_sys_date)%>')"  style='cursor:pointer' onMouseOver="hideToolTip(this,'imgArrow<%=i%>')"> <%=record[15]%>
		<img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>">
		</td> -->
		<td width='' id='orderctl<%=i%>' class='gridDataBlue' wrap  onClick="displayToolTip('<%=menuText%>','<%=record[18]%>', '<%=record[19]%>', '<%=record[20]%>', '<%=record[14]%>', '<%=record[22]%>', '<%=procedure_code%>', '<%=record[21]%>', '<%=record[23]%>', '<%=record[24]%>', '<%=record[25]%>', '<%=record[26]%>', '<%=record[27]%>', '<%=record[28]%>', '<%=record[29]%>', '<%=sent_out_flag%>', '<%=record[30]%>', '<%=record[8]%>', '<%=record[31]%>', '<%=record[32]%>', '<%=java.net.URLEncoder.encode(record[12])%>', '<%=java.net.URLEncoder.encode(discr_msr_id)%>', '<%=proc_code_scheme%>', '<%=record[37]%>', '<%=record[38]%>', '<%=record[39]%>', '<%=record[3]%>', '<%=record[40]%>', '<%=record[41]%>', '<%=record[34]%>', '<%=i%>', '<%=record[42]%>', '<%=record[43]%>', '<%=record[44]%>', '<%=record[45]%>', '<%=product_desc%>', '<%=blood_group%>', '<%=rhesus_code%>', '<%=record[46]%>','<%=parent_order_id%>', this, 'imgArrow<%=i%>','<%=record[49]%>','<%=record[50]%>','<%=java.net.URLEncoder.encode(record[7])%>','<%=java.net.URLEncoder.encode(patientDtls)%>','<%=java.net.URLEncoder.encode(patName)%>','<%=java.net.URLEncoder.encode(curr_sys_date)%>','<%=record[56]%>','<%=split_order_yn%>')"  style='cursor:pointer' onMouseOver="hideToolTip(this,'imgArrow<%=i%>')"> <%=record[15]%><!--IN071618 -->
		<!--IN065942,ends-->
		<img align='right' src="../../eCommon/images/inactiveArrow.gif" name="imgArrow<%=i%>" id="imgArrow<%=i%>">
		</td>
<% split_order_yn ="N";//IN071618
	}
	else if ((record[5].equals("D") || record[5].equals("O") ) && (record[34].equals("I")))
	{
		if(record[11].equals("Pending"))
		{
			if(record[35].equals(""))
			{
%>
				<td width='' class='gridDataBlue' id='orderctl<%=i%>' style='cursor:pointer' onClick="displayToolTip_int('<%=i%>',this)" onMouseOver='hideToolTip()'  wrap ><!-- <a href='javascript:dummy()'  onClick="displayToolTip_int('<%=i%>')"  onMouseOver='hideToolTip()'> --><%=record[15]%><!-- </a> --></td>
<%
			}
			else
			{
				if(record[35].equals("NT") && record[2].equals("$NTS"))
				{
                   /*Added by Archana Dhal the below trans_pract_id parameter is replaced by req_pract_id parameter on 4/26/2010 at 4:20 PM for IN020723*/
%>
				<td width='' class='gridDataBlue' id='orderctl<%=i%>' style='cursor:pointer' onClick="displayToolTipForEvents_int('<%=i%>','<%=record[35]%>','<%=record[36]%>','<%=record[21]%>','<%=accession_num%>','<%=req_pract_id%>','<%=note_type%>',this)"  onMouseOver='hideToolTip()' wrap ><!-- <a href='javascript:dummy()'  onClick="displayToolTipForEvents_int('<%=i%>','<%=record[35]%>','<%=record[36]%>')"  onMouseOver='hideToolTip()'> --><%=note_desc%><!-- </a> --></td>
<%
				}
				else
				{
%>
				<td width='' class='gridDataBlue' id='orderctl<%=i%>' style='cursor:pointer' onClick="displayToolTipForEvents_int('<%=i%>','<%=record[35]%>','<%=record[36]%>','<%=record[21]%>','','','',this)"  onMouseOver='hideToolTip()' wrap ><%=record[15]%></td>
<%
				}
			}
		}
		else
		{
			if(record[35].equals("NT") && record[2].equals("$NTS"))
			{
%>
			<td width='' class='<%=slClassValue%>' wrap ><%=note_desc%></td>
<%
			}
			else
			{
%>
			<td width='' class='<%=slClassValue%>' wrap ><%=record[15]%></td>
<%
			}
		}
	}
	else if(record[5].equals("D") || record[5].equals("O"))
	{
%>
		<!--<td width='' class='gridDataBlue' id='orderctl<%=i%>' style='cursor:pointer' onClick="displayToolTipForEventsPopulation('<%=i%>','<%=record[35]%>','<%=record[36]%>',this)"  onMouseOver='hideToolTip()' wrap ><!-- <a href='javascript:dummy()'  onClick="displayToolTipForEventsPopulation('<%=i%>','<%=record[35]%>','<%=record[36]%>')"  onMouseOver='hideToolTip()'> -->
		<td width='' class='gridDataBlue' id='orderctl<%=i%>' style='cursor:pointer' onClick="displayToolTipForEventsPopulation('<%=i%>','<%=record[35]%>','<%=record[36]%>',this,'<%=record[49]%>')"  onMouseOver='hideToolTip()' wrap ><!--IN066125--><%=record[15]%><!-- </a> --></td>
<%
	}
	else
	{
		if(record[34].equals("I") && record[35].equals("NT") && record[2].equals("$NTS"))
		{
%>
		<td width='' class='<%=slClassValue%>' wrap ><%=note_desc%></td>
<%
		}
		else
		{
%>
		<td width='' class='<%=slClassValue%>' wrap ><%=record[15]%></td>
<%
		}
	}
%>
<%
	if (Groupby.equals("T"))
	{
%>
		<td width='' class='<%=slClassValue%>'  wrap><%=patientDetails%></td>		<!-- Patient Name-->
<%	
	}
	//IN030473 Start.
	if (taskSelect.equals("I")||taskSelect.equals(""))
	{ 
%>
		<td width='' class='<%=slClassValue%>'  wrap>&nbsp; <%if(!"".equals(record[51])){%><img style='display;cursor: hand;' src='../../eCA/images/flow_text.gif' onClick="viewPatientInstructions('<%=record[22]%>','<%=record[20]%>','<%=record[26]%>','<%=record[2]%>','<%=record[51]%>');"><%}%></td>		<!-- record[51]Patient Instructions-->
<%	
	}
	//IN030473 End.
	if(record[34].equals("I") && record[2].equals("$NTS"))
	{
%>
	<td style="width:60px" class='<%=slClassValue%>' wrap><%=request_pract_name%></td>		<!-- Ordered By-->
<%
	}
	else
	{
%>
	<td style="width:60px" class='<%=slClassValue%>' wrap><%=record[7].equals("")?"&nbsp;":record[7]%></td>		<!-- Ordered By-->
<%
	}
%>
	<td style="width:60px" class='<%=slClassValue%>' wrap><%=record[8].equals("")?"&nbsp;":record[8]%></td>	<!-- priority-->
	<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=record[9].equals("")?"&nbsp;":record[9]%></td>	<!-- Stage-->
	<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=record[10].equals("")?"&nbsp;":record[10]%></td>	<!-- position-->
<%
	if(record[34].equals("O") && record[5].equals("C") && !record[24].equals("PF"))
	{
%>
		<td style="width:60px" class='<%=slClassValue%>'  nowrap><a href="javascript:resultViewOrder('Result','<%=record[18]%>','<%=record[19]%>','<%=record[25]%>','<%=cont_order_ind%>','<%=record[22]%>','<%=record[23]%>')"><%=record[11].equals("")?"&nbsp;":record[11]%></a>
		<%
		//--[IN033488]
		StringBuffer error_desc=new StringBuffer();	
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
		error_desc.append(" ");
		error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
		error_desc.append(" ");
		if(record[24].trim().equals("RM") ||record[24].trim().equals("RS")) 
		{
		ErrStatusChk  = patTask.getRltNoteSts(record[19],locale); 		
			if(ErrStatusChk!=null)
			{
				for(int j=0; j<ErrStatusChk.size(); j++)
				{
					String[] record1 		= (String[])ErrStatusChk.get(j);
					action_type				= record1[2];
					action_date_time		= record1[1];
					action_by_id			= record1[0];
				}
			}
		if(action_type.equals("ER"))
		{
		%>
		<img title='<%=error_desc%><%=action_by_id%>' src="../../eCA/images/MarkError.gif"/>
		<%
		action_type = "";//IN040198
		}
		}
		
		//--[IN033488]
		%>
		</td>	<!-- status-->
<%
	}
	else
	{
		if(record[34].equals("B"))
		{	
			if(record[47].equals("Transfused"))
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");
%>
				<td style="width:60px" class='<%=slClassValue%>'><a href="javascript:viewHistory('<%=record[22]%>')"><%=record[47]%></a></td>
<%
			}
			else if(record[47].equals("ReserveAndRequest"))
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");
%>
				<td style="width:60px" class='<%=slClassValue%>'><a href="javascript:viewRequest('<%=request_date%>','<%=request_by%>')"><%=record[47]%></a></td>
<%

			}
			else
			{
				record[47] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA."+record[47]+".label","ca_labels");
%>
				<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=record[47].equals("")?"&nbsp;":record[47]%></td>
<%
			}
		}
		else if(record[34].equals("I"))
		{
			if(record[11].equals("Pending") && record[2].equals("$NTS"))
			{
%>
				<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingTranscription.label","ca_labels")%></td>
<%
			}
			else
			{
%>
				<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=record[11].equals("")?"&nbsp;":record[11]%></td>
<%
			}
		}
		else
		{
%>
		<td style="width:60px" class='<%=slClassValue%>'  nowrap><%=record[11].equals("")?"&nbsp;":record[11]%></td>
<%
		}
	}
%>
</tr>	 
<%
	} //for
} //else

}
catch(Exception e)
{
	
	e.printStackTrace();
}
finally 
{
	if(pstmt != null) pstmt.close();
	if(rs != null) rs.close();
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
%>
</table>
</div>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="localeName" id="localeName" value="<%=locale%>">
<input type="hidden" name="total_recs" id="total_recs" value="1">
<input type="hidden" name="chk0" id="chk0" value="on">
<input type="hidden" name="ord_id0" id="ord_id0" value="">
<input type="hidden" name="cont_order_ind0" id="cont_order_ind0" value="">
<input type="hidden" name="appt_ref_num0" id="appt_ref_num0" value="">
<input type="hidden" name="encounter_id0" id="encounter_id0" value="">
<input type="hidden" name="view_by0" id="view_by0" value="H">
<input type="hidden" name="practitioner_id" id="practitioner_id" value="">
<input type="hidden" name="mode" id="mode" value="1">
<input type="hidden" name="line_id0" id="line_id0" value="">
<input type="hidden" name="order_set_id0" id="order_set_id0" value="">
<input type="hidden" name="route_admin" id="route_admin" value="<%=AdminRoute%>">
<input type="hidden" name="nursing_unit" id="nursing_unit" value="<%=locn_code%>">
<input type="hidden" name="callFrom" id="callFrom" value="<%=callFrom%>">
<input type="hidden" name="isBTViewBillDtls" id="isBTViewBillDtls" value="<%=isBTViewBillDtls%>"><!--IN065324-->
<input type="hidden" name="pract_type" id="pract_type" value="<%=practitioner_type%>"><!--IN065942-->
<input type="hidden" name="order_category0" id="order_category0" value=""><!--IN065942-->
<input type="hidden" name="prn_reg_ord0" id="prn_reg_ord0" value=""><!--IN065942-->
<input type="hidden" name="called_from" id="called_from" value=""><!-- IN071618 -->
<!-- For Next & previous -->
<input type='hidden' name='from' id='from' value='<%=from%>'>
<input type='hidden' name='to' id='to' value='<%=to%>'>
 <!-- For Next & previous -->

</form>
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' id='t'></td>
			</td>
		</tr>
	</table>
</div>
<div name='details' id='details' style='position:absolute; width:60%; visibility:hidden;' bgcolor='blue'>

</div>
</body>
</html>
<!--IN069244 starts-->
<% if("V".equals(taskSelect)){
%>
<script>
parent.parent.TaskListRightFrame.TaskListRightResultFrame.location.href="../jsp/VitalSignFrameSet.jsp?<%=request.getQueryString()%>";	
</script>
<%}%>
<!--IN069244 ends-->
<%
	putObjectInBean("patTask",patTask,session);
%>

