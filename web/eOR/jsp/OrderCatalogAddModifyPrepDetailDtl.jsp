<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="eOR.*, java.sql.*, java.util.*, java.text.*,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%!int row_count=0;%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderCatalog.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>
    <STYLE TYPE="text/css">
 
	A {
    	text-decoration : none ;
    }

    A:link {
    	COLOR: blue;
    }

    A:visited {
    	COLOR:blue ;
    }
    A:active {
    	COLOR: blue;
    }

    A.MENUSUBLEVELLINK
    {
    	COLOR:BLUE
    }
    A.MENUHIGHERLEVELLINK
    {
    	COLOR:WHITE
    }

	</STYLE>
</head>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
    <form name="detailLowerForm" id="detailLowerForm">
<%
	//int noOfRecords = 0;
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    int row_disp=8;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "Or_OrderCatalog" ;
	String bean_name = "eOR.OrderCatalogBean";
	//String readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="";
	//String key="";
	String index="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String catalog_desc="", dispMode="", tabVal="";
	//String order_stage="";
	//String status="E";
	String code="";
	//String status_db = "";

	String sec_order_stage_stat    = "";
	String sec_order_stat_durn     = "";
	String sec_order_stat_durn_type= "";

	String sec_order_stage_urg     = "";
	String sec_order_urg_durn      = "";
	String sec_order_urg_durn_type = "";

	String sec_order_stage_rtn     = "";
	String sec_order_rtn_durn      = "";
	String sec_order_rtn_durn_type = "";
	
	String sec_task_updatable		 = "Y";
	String eff_status = "E";
	//String mode="1";

	String order_category="", order_type_code="", pri_order_catalog_code = "";

	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false, alteredDBRecord = false;

	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();

	String mode     =   request.getParameter("mode");
	
    tabVal			=	request.getParameter("tabVal");
	//out.println("####tabVal="+tabVal);
	String pri_sec_tasks_type=request.getParameter("pri_sec_tasks_type")==null?"":request.getParameter("pri_sec_tasks_type");
	//out.println("#####pri_sec_tasks_type="+pri_sec_tasks_type);
	
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;

	index					=	request.getParameter("index");
	order_category			=	request.getParameter("order_category");
	order_type_code			=	request.getParameter("order_type_code");
	pri_order_catalog_code  =   request.getParameter("pri_order_catalog_code");

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(order_category == null || order_category.equals("null"))order_category="";
	if(order_type_code == null || order_type_code.equals("null"))order_type_code="";
	if(pri_order_catalog_code == null || pri_order_catalog_code.equals("null"))pri_order_catalog_code="";

	if(index == null || index.equals("null"))index="";
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="S";


	if ( mode == null || mode.equals("") )
		return;

//out.println("#####in dlt jsp,mode="+mode);

    if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

    //out.println("<script>alert('index="+index+",dispMode="+dispMode+",tabVal"+tabVal+"')</script>");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	OrderCatalogBean bean = (OrderCatalogBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	//out.println("<script>alert(' dispMode  :"+dispMode+"');</script>");
	
	try{
	HashMap orderCatalogHeaderStr = (HashMap)bean.getOrderCatalogHeaderStr();
	if(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY"))){
		eff_status  = (String)orderCatalogHeaderStr.get("eff_status");
		eff_status	= eff_status.trim();
		if(eff_status.trim().equalsIgnoreCase("D")){//only in mod mode if eff_staus is disabled
			sec_task_updatable	 =  "N" ;
		}
	}
	//out.println("<script>alert('dispMode="+dispMode+"');</script>");
	if(dispMode.equals("")){
	  //  HashMap orderCatalogHeaderStr = (HashMap)bean.getOrderCatalogHeaderStr();
	    pri_order_catalog_code = (String)orderCatalogHeaderStr.get("order_catalog_code");
		
       //int dbRecordCount = 0;
		//int dbRecordCount		=  bean.fetchDBRecords(pri_order_catalog_code); // -- Commented for Checking
		//out.println("<script>alert('dbRecordCount="+dbRecordCount+"')</script>");
		//out.println("<script>alert('index="+index+"')</script>");
		if(tabVal.equals("S")){
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,pri_sec_tasks_type);			
			row_count			=	MultiRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A")){
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
			row_count			=  MultiRecordSet.getSize("DB");
		}

		//out.println("debug :"+bean.getDebug());
 //out.println("<script>alert(' row_count  :"+row_count+"');</script>");

		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>

		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common");
			parent.parent.parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
		}
		</script>
		<%
	}else{
  // out.println("<script>alert(' 1111111111');</script>");
		int from_val	= (Integer.parseInt(from));
		int to_val		= (Integer.parseInt(to));

		if(dispMode.equals("Next")){

			dispMode	="Next";
			from		= ""+(start + row_disp);
			to			= ""+(end + row_disp);


		}else if(dispMode.equals("Previous")){

			dispMode	="Previous";
			from		= ""+(start - row_disp);
			to			= ""+(end - row_disp);

		}

		if(to_val > (row_count-1))
			to_val=(row_count-1);

		MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();

		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
//			out.println("<script>alert(' update_val  :"+update_val+"');</script>");
			//out.println("<script>alert(' update_val  :"+update_val+"');</script>");
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				//alteredRecord =
					MultiRecordSet.setBeanValue(j,update_val);
				//System.out.println("####in Detail jsp,alteredRecord="+alteredRecord);
			}else if(tabVal.equals("A")){
				//alteredDBRecord = 
				MultiRecordSet.setDBBeanValue(j,update_val);
				//System.out.println("####in Detail jsp,alteredDBRecord="+alteredDBRecord);
			}
		}

		fm_disp = Integer.parseInt(from);
		to_disp	= Integer.parseInt(to);

		if(to_disp > (row_count-1))
			to_disp=(row_count-1);

		start	= Integer.parseInt(from);
		end     = Integer.parseInt(to);
	}
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
%>

    <%--<Script>alert(document.detailLowerForm.name+","+parent.OrderCatalogAddModifyPrepDetailDtl.document.detailLowerForm.name);</script>--%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr  width='10%'>
	<td class='WHITE' align="right"> <%----%>
	<%

	//out.println(start+","+row_disp+","+row_count);
	//out.println("start="+start+"  end="+end+"  row_disp="+row_disp+"  row_count="+row_count+"  fm_disp="+fm_disp+"  to_disp="+to_disp);

	//if ( (!(start <= 1)) && (start < row_count)){
	if ( (!(fm_disp <= 1)) && (fm_disp < row_count)){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkPrepVal("Previous");'  ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>  <%--text-decoration='none'--%>
	<%
	}

	//if ( !( (start+row_disp) >= row_count ) ){
	if ( !( (fm_disp+row_disp) >= row_count ) ){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkPrepVal("Next");' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>  <%--text-decoration='none' --%>
	<%
	}

	%>
	</td>
	</tr>
	</table>
	<%--<table border='1' cellpadding='0' cellspacing='0' width='125%' align='center'>
	<tr><th width='22%'>&nbsp;</th><th width='25%'>Stage</th><th width='24.5%'>Duration</th><th width='24.5%'>Duration Type</th><th >&nbsp;</th></tr>
	</table>--%>
	<!-- <br>  -->
	<table class='grid' width='100%'>

    <tr>
    <td class=' COLUMNHEADER' width='25%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
    <td class=' COLUMNHEADER' width='30%' colspan='3'><fmt:message key="eOR.StatOrderStage.label" bundle="${or_labels}"/></td>
	<td class=' COLUMNHEADER' width='30%' colspan='3'><fmt:message key="eOR.UrgentOrderStage.label" bundle="${or_labels}"/></td>
	<td class=' COLUMNHEADER' width='30%' colspan='3'><fmt:message key="eOR.RoutineOrderStage.label" bundle="${or_labels}"/></td>

	<td class=' COLUMNHEADER' width='10%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	</tr>
	<%try{
		//out.println("<script>alert('###tabVal in dlt jsp="+tabVal+"');</script>");
		if(tabVal.equals("S")){
			//out.println("<script>alert('###fm_disp="+fm_disp+"');</script>");
			//out.println("<script>alert('###to_disp="+to_disp+"');</script>");				
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				//out.println("<script>alert('in jsp multiRecBean.getAllSelectRecords().size()="+MultiRecordSet.getAllSelectRecords().size()+"')</script>");
				//out.println("<script>alert('###i="+i+"');</script>");
				htListRecord		=	(java.util.HashMap)MultiRecordSet.getListObject(i);
				//System.out.println("####in jsp  htListRecord="+htListRecord);
				//out.println("<script>alert('###htListRecord="+htListRecord+"');</script>");
				code				=	(String)htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");
                sec_order_stage_stat	 =	(String)htListRecord.get("sec_order_stage_stat");
				sec_order_stat_durn		    =	(String)htListRecord.get("sec_order_stat_durn");
				sec_order_stat_durn_type	=(String)htListRecord.get("sec_order_stat_durn_type");

				sec_order_stage_urg		    =	(String)htListRecord.get("sec_order_stage_urg");
				sec_order_urg_durn		    =	(String)htListRecord.get("sec_order_urg_durn");
				sec_order_urg_durn_type	    =(String)htListRecord.get("sec_order_urg_durn_type");

				sec_order_stage_rtn		    =	(String)htListRecord.get("sec_order_stage_rtn");
				sec_order_rtn_durn		    =	(String)htListRecord.get("sec_order_rtn_durn");
				sec_order_rtn_durn_type	   =(String)htListRecord.get("sec_order_rtn_durn_type");
				valid				=	(String)	htListRecord.get("valid");
				//out.println("<script>alert('valid="+valid+"')</script>");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//out.println("<script>alert('"+associate_yn+"')</script>");
				if(associate_yn == null || associate_yn.equals("null")) associate_yn="N";
				//status			=	(String)    htListRecord.get("status");
				stats  				=	MultiRecordSet.containsObject(code);
				//out.println("<script>alert('"+associate_yn+"')</script>");

				//out.println("<script>alert('stats="+stats+"')</script>");

				if(stats){
					valid = MultiRecordSet.getValidKey(code);
					int intLocn = 0;
					try {
						ArrayList allRecords = new ArrayList();
						allRecords = MultiRecordSet.getAllDBRecords();
						HashMap tempHash = new HashMap();
						tempHash.put("code",code);
						intLocn = MultiRecordSet.scanRecord(tempHash);
						HashMap split			  = (HashMap)allRecords.get(intLocn);

                        sec_order_stage_stat      = (String) split.get("sec_order_stage_stat");
						sec_order_stat_durn       = (String) split.get("sec_order_stat_durn");
						sec_order_stat_durn_type  = (String) split.get("sec_order_stat_durn_type");

						sec_order_stage_urg      = (String) split.get("sec_order_stage_urg");
						sec_order_urg_durn       = (String) split.get("sec_order_urg_durn");
						sec_order_urg_durn_type  = (String) split.get("sec_order_urg_durn_type");

						sec_order_stage_rtn      = (String) split.get("sec_order_stage_rtn");
						sec_order_rtn_durn       = (String) split.get("sec_order_rtn_durn");
						sec_order_rtn_durn_type  = (String) split.get("sec_order_rtn_durn_type");
						associate_yn			 = (String)split.get("associate_yn");
						//out.println("<script>alert('"+associate_yn+"')</script>");
						if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";

					} catch (Exception e) {
						//out.println("<script>alert('exception="+e.getMessage()+"')</script>");//common-icn-0181
				                 e.printStackTrace();//COMMON-ICN-0181
					}
					//out.println("<script>alert('order_stage="+order_stage+","+valid+","+fm_disp+","+intLocn+"')</script>");
				}

				/********************/
//				out.println("<script>alert(' valid in select tab :"+valid+"');</script>");
				
				if(valid.equals("Y")){
					checkValue="checked";
					disabled="disabled";
				}else{

					if(associate_yn.equals("Y")){
						checkValue="checked";
						disabled="";
					}else{
						/*if((stats)&&(associate_yn.equals("N"))){
							checkValue="checked";
							disabled="";
						}else*/{
							checkValue="";
							disabled="";
						}
					}
				}

				/**********************/

				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("stats :"+stats);

				tblrow_id	=	"tblrow_id"+i;

				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>

                <TD class='<%=classValue%>' align='center'><select name='sec_order_stage_stat<%=i%>' id='sec_order_stage_stat<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_stat.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_stat.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_stat.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_stat_durn<%=i%>' id='sec_order_stat_durn<%=i%>' value='<%=sec_order_stat_durn%>' size='4' maxlength='4' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_stat_durn_type<%=i%>' id='sec_order_stat_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_stat_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_stat_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <TD class='<%=classValue%>' align='center'><select name='sec_order_stage_urg<%=i%>' id='sec_order_stage_urg<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_urg.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_urg.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_urg.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_urg_durn<%=i%>' id='sec_order_urg_durn<%=i%>' value='<%=sec_order_urg_durn%>'  size='4' maxlength='4' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_urg_durn_type<%=i%>' id='sec_order_urg_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_urg_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_urg_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <TD class='<%=classValue%>' align='center'><select name='sec_order_stage_rtn<%=i%>' id='sec_order_stage_rtn<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_rtn.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_rtn.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_rtn.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_rtn_durn<%=i%>' id='sec_order_rtn_durn<%=i%>' value='<%=sec_order_rtn_durn%>'  size='4' maxlength='4' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_rtn_durn_type<%=i%>' id='sec_order_rtn_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_rtn_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_rtn_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <td class='<%=classValue%>' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%> <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){
				//out.println("<script>alert('fm_disp="+fm_disp+"');</script>");
	//out.println("<script>alert('to_disp="+to_disp+"');</script>");
	
//MultiRecordSet.clearDBRec();
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)MultiRecordSet.getObject(i);
//				System.out.println("###htListRecord2222="+htListRecord);
	//out.println("<script>alert('htListRecord="+htListRecord+"');</script>");
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");

                sec_order_stage_stat		    =	(String)	htListRecord.get("sec_order_stage_stat");

				sec_order_stat_durn		    =	(String)	htListRecord.get("sec_order_stat_durn");
				sec_order_stat_durn_type	    =	(String)	htListRecord.get("sec_order_stat_durn_type");

				sec_order_stage_urg		    =	(String)	htListRecord.get("sec_order_stage_urg");
				sec_order_urg_durn		    =	(String)	htListRecord.get("sec_order_urg_durn");
				sec_order_urg_durn_type	    =	(String)	htListRecord.get("sec_order_urg_durn_type");

				sec_order_stage_rtn		    =	(String)	htListRecord.get("sec_order_stage_rtn");
				sec_order_rtn_durn		    =	(String)	htListRecord.get("sec_order_rtn_durn");
				sec_order_rtn_durn_type	    =	(String)	htListRecord.get("sec_order_rtn_durn_type");

				//out.println("<script>alert('sec_order_stage_stat="+sec_order_stage_stat+",sec_order_stat_durn="+sec_order_stat_durn+",sec_order_stat_durn_type="+sec_order_stat_durn_type+",sec_order_stage_rtn="+sec_order_stage_rtn+",sec_order_rtn_durn="+sec_order_rtn_durn+",sec_order_rtn_durn_type="+sec_order_rtn_durn_type+"')</script>");

				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//String status_db			=	(String)	htListRecord.get("status");
				//out.println("<script>alert(' valid in associate tab :"+valid+"');</script>");
				//out.println("<script>alert(' associate_yn in associate tab :"+associate_yn+"');</script>");
				//out.println("<script>alert(' status_db in associate tab :"+associate_yn+"');</script>");

				///out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("status_db :"+status_db);

				tblrow_id	=	"tblrow_id"+i;
//out.println("<script>alert(' valid in associate tab :"+valid+"');</script>");

				if(valid.equals("N")){
					if(associate_yn.equals("Y"))
						checkValue="checked";
					else
						checkValue="";
				}
				else{
					if(associate_yn.equals("D"))
						checkValue="";
					else
						checkValue="checked";
				} 
				//out.println("<script>alert(' checkValue in associate tab :"+checkValue+"');</script>");%>
				<%--<script>alert('associate_yn=<%=associate_yn%>')</script>--%>
				<%//if (associate_yn.equals("Y") || (associate_yn.equals("D")) ) { // || valid.equals("Y")
				//out.println("<script>alert(' aaaaaaaaaaa');</script>");
				%>
				<tr id='<%=tblrow_id%>'>
				<%if(valid.equals("Y")){
					//out.println("<script>alert(' kkkkkkkkkkkkk');</script>");
					%>
					<td class='<%=classValue%>' ><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<%}%>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_stage_stat<%=i%>' id='sec_order_stage_stat<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_stat.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_stat.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_stat.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_stat_durn<%=i%>' id='sec_order_stat_durn<%=i%>'  value='<%=sec_order_stat_durn%>'  size='4' maxlength='4' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_stat_durn_type<%=i%>' id='sec_order_stat_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_stat_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_stat_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <TD class='<%=classValue%>' align='center'><select name='sec_order_stage_urg<%=i%>' id='sec_order_stage_urg<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_urg.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_urg.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_urg.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_urg_durn<%=i%>' id='sec_order_urg_durn<%=i%>'  value='<%=sec_order_urg_durn%>'  size='4' maxlength='4' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_urg_durn_type<%=i%>' id='sec_order_urg_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_urg_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_urg_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <TD class='<%=classValue%>' align='center'><select name='sec_order_stage_rtn<%=i%>' id='sec_order_stage_rtn<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="O" <%=(sec_order_stage_rtn.equals("O"))?"selected":""%>><fmt:message key="Common.Order.label" bundle="${common_labels}"/></option><option value="A" <%=(sec_order_stage_rtn.equals("A"))?"selected":""%>><fmt:message key="Common.Appointment.label" bundle="${common_labels}"/></Option><option value="N" <%=(sec_order_stage_rtn.equals("N"))?"selected":""%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></Option></select></TD>
				<TD class='<%=classValue%>' align='center'><input type='text' name='sec_order_rtn_durn<%=i%>' id='sec_order_rtn_durn<%=i%>' onKeyPress="return(ChkNumberInput(this,event,'0'))"  value='<%=sec_order_rtn_durn%>' size='4' maxlength='4' class="NUMBER" <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></TD>
				<TD class='<%=classValue%>' align='center'><select name='sec_order_rtn_durn_type<%=i%>' id='sec_order_rtn_durn_type<%=i%>' <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>><option value="H" <%=(sec_order_rtn_durn_type.equals("H"))?"selected":""%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value="D" <%=(sec_order_rtn_durn_type.equals("D"))?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></Option></select></TD>

                <td class='<%=classValue%>' align='center'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=eHISFormatter.chkReturn("y",sec_task_updatable,"","disabled")%>></td>
				
				</tr>
				<%//}
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception@2: "+e);
		}
	%>
	</table>
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
	<input type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>
	<input type="hidden" name="pri_sec_tasks_type" id="pri_sec_tasks_type" value=<%=pri_sec_tasks_type%>>
	<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	</form>
</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

