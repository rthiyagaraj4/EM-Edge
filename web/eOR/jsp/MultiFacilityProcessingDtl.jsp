<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import=" eOR.*,eCommon.XSSRequestWrapper"  %>
<%-- Mandatory declarations end --%>

<%!int row_count=0;%>
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
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eOR/js/MultiFacilityProcessing.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	
	</script>

</head>
<%
	int row_disp=7;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "multifacilityprocessingbean" ;
	String bean_name = "eOR.MultiFacilityProcessingBean";
	//String readOnly = "", key="",status="E",
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",  index="";

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String catalog_desc="", dispMode="", tabVal="",performing_locn="";
	String performing_facility_id ="",  code="";
	//String status_db = "";
	String mode="1";

	String ordering_facility_id="",	order_category="", order_type_code="", source_type="", source_location="";

	boolean stats = false;
	String update_val = "";
	String sel = "";
	//boolean alteredRecord = false;
	//boolean alteredDBRecord = false;

	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	 
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;

	performing_facility_id	=	request.getParameter("performing_facility_id");
	index					=	request.getParameter("index");
	ordering_facility_id	=	request.getParameter("ordering_facility_id");
	order_category			=	request.getParameter("order_category");
	order_type_code			=	request.getParameter("order_type_code");
	performing_facility_id  =	request.getParameter("performing_facility_id");
	source_type				=	request.getParameter("source_type");
	source_location			=	request.getParameter("source_location");

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(ordering_facility_id == null || ordering_facility_id.equals("null"))ordering_facility_id="";
	if(order_category == null || order_category.equals("null"))order_category="";
	if(order_type_code == null || order_type_code.equals("null"))order_type_code="";
	if(performing_facility_id == null || performing_facility_id.equals("null"))performing_facility_id="";

	source_type = (source_type == null) ? "" : source_type;
	source_location = (source_location == null) ? "" : source_location;

	if(index == null || index.equals("null"))index="";
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="S";
	//out.println("<script>alert('index="+index+",dispMode="+dispMode+",tabVal"+tabVal+"')</script>");

	if ( mode == null || mode.equals("") )
		return;

	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	//MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)getBeanObject( bean_id, bean_name, request ) ;
	/* Initialize Function specific end */

	//out.println("<script>alert(' index  :"+index+"');</script>");
	//out.println("<script>alert(' performing_facility_id  :"+performing_facility_id+"');</script>");
    ArrayList PerformingLocn_Data = new ArrayList();
	try{
		//out.println("<script>alert('dispMode="+dispMode+"');</script>");
	if(dispMode.equals("")){
		
		bean.fetchDBRecords(ordering_facility_id, order_category, order_type_code, performing_facility_id, source_type, source_location);
		//int dbRecordCount		=  bean.fetchDBRecords(ordering_facility_id, order_category, order_type_code, performing_facility_id, source_type, source_location);
		//out.println("<script>alert('dbRecordCount="+dbRecordCount+"')</script>");
		//System.out.println("index="+index+" ,performing_facility_id="+performing_facility_id+" ,order_category="+order_category+" ,order_type_code="+order_type_code);
		
		if(tabVal.equals("S")){
			//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,performing_facility_id, order_category, order_type_code);
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index, order_category, order_type_code,ordering_facility_id, performing_facility_id, source_type, source_location);
			
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
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}else{

			//out.println("<script>alert('in else');</script>");

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
           // System.out.println("inDtlPgupdate_val :"+update_val);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				MultiRecordSet.setBeanValue(j,update_val);
				//alteredRecord = MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				MultiRecordSet.setDBBeanValue(j,update_val);
				//alteredDBRecord = MultiRecordSet.setDBBeanValue(j,update_val);
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
		//out.println("<script>alert('"+e.getMessage()+"')</script>");//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
	<form name="formMultiFacilityProcessingDtl" id="formMultiFacilityProcessingDtl">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
	<%

	//out.println("start="+start+", end="+end+" ,row_count="+row_count+" ,row_disp="+row_disp);

	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%
	}

	if ( !( (start+row_disp) > row_count ) ){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%
	}

	%>
	</td>
	</tr>
	</table>
	<table class='grid' width='100%'  >
	<th class="columnheader" width='50%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
	<th class="columnheader" width='30%'><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></th> 
	<th class="columnheader" width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	<%
	try{
		//System.out.println("#####tabVal="+tabVal);
		if(tabVal.equals("S")){
			ArrayList allRecords=null;
			HashMap tempHash=null;
			HashMap split=null;
			String[] record = null;
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
				//System.out.println("#####htListRecord="+htListRecord);
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");
				performing_locn		=	(String)	htListRecord.get("performing_locn");

				valid				=	(String)	htListRecord.get("valid");
			
				//out.println("<script>alert('performing_locn="+performing_locn+","+valid+"')</script>");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				//status			=	(String)    htListRecord.get("status");
								
				stats  				=	MultiRecordSet.containsObject(code);
				//System.out.println("#####stats="+stats);	
				if(stats){
					valid = MultiRecordSet.getValidKey(code);
					//System.out.println("######valid="+valid);
					int intLocn = 0;
					try {
						allRecords = new ArrayList();
						allRecords = MultiRecordSet.getAllDBRecords();
						//System.out.println("###allRecords in jsp="+allRecords);
						tempHash = new HashMap();
						tempHash.put("code",code);
						intLocn = MultiRecordSet.scanRecord(tempHash);
						split			= (HashMap)allRecords.get(intLocn);
						performing_locn			= (String) split.get("performing_locn");
					} catch (Exception e) {
						out.println("<script>alert('exception="+e.getMessage()+"')</script>");
					}
					//out.println("####performing_locn="+performing_locn+","+valid+","+fm_disp+","+intLocn);
				}

				/********************/
				
				if(valid.equals("Y")){
					checkValue="checked";
             	  	disabled="disabled";
				}else{
					if(associate_yn.equals("Y")){
						checkValue="checked";
						disabled="";
					}else{
						if((stats)&&(associate_yn.equals("N"))){
							checkValue="checked";
							disabled="";
						}else{
							if(associate_yn.equals("A"))
							{
								
								checkValue="";
								disabled="disabled";
							}
							else
							{
								checkValue="";
								disabled="";
							}
						}
					}
				}
			//	System.out.println("<script>alert('inDtlSUpdVal : "+UpdVal+"')</script>");
			//	if(

				/**********************/

				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("stats :"+stats);

				tblrow_id	=	"tblrow_id"+i;

				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>'><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<TD class='<%=classValue%>'>
				<select name='performing_facility_lo<%=i%>' id='performing_facility_lo<%=i%>' <%=disabled%> >
						<option value=" "> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option> 							
						
				<%
					try{						
                        PerformingLocn_Data = bean.getPerformingLocn(order_category,performing_facility_id,code);//,order_type_code);             

						//System.out.println("####PerformingLocn_Data : "+PerformingLocn_Data.size());
						//System.out.println("#####PerformingLocn_Data : "+PerformingLocn_Data);
						if(PerformingLocn_Data.size()>=0){
					 	for(int pln=0; pln<PerformingLocn_Data.size(); pln++){
							//System.out.println("#######################");
						record = (String [])PerformingLocn_Data.get(pln);
						//System.out.println("###record="+record);
   		//		       System.out.println("Sel perf_locn:"+performing_locn);
		//		  	   System.out.println("Bean perf_locn:"+record[1]);

						if(performing_locn.equals(""))
						{
                        
						 if(!record[2].equals("")&&record[2].equals("Y"))
					     { 
                           sel = "selected";
						 }
						}
												            
						%>
					<option value="<%=record[1]%>" <%=sel%> <%=((record[1]).equals(performing_locn))?"selected":""%>><%=record[0]%></Option>
			
                                   			
						<%
						}
				}
						//System.out.println("####22222PerformingLocn_Data : "+PerformingLocn_Data.size());
						//System.out.println("#####222222222PerformingLocn_Data : "+PerformingLocn_Data);
						 PerformingLocn_Data=null;
						 
					}catch(Exception e){
						System.out.println("<script>alert('here1 : "+e+"')</script>");
						e.printStackTrace();
				}
				%>
				</select></TD>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){
				String[] record = null;
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");
				performing_locn		=	(String)	htListRecord.get("performing_locn");
			//	System.out.println("ifAssDBPerfLoc :"+performing_locn);
				valid				=	(String)	htListRecord.get("valid");
	        //	System.out.println("@@@inDtlAAvalid :"+valid);
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//status_db			=	(String)	htListRecord.get("status");


				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("status_db :"+status_db);

				tblrow_id	=	"tblrow_id"+i;

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

				%>
				<tr id='<%=tblrow_id%>'>
				<%if(valid.equals("Y")){%>
					<td class='<%=classValue%>'><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>'><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<%}%>
				<TD class='<%=classValue%>'><select name='performing_facility_lo<%=i%>' id='performing_facility_lo<%=i%>' ><option value=""> ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- </option>
				<%
					try{
						//String ord_cat = "";
						
						PerformingLocn_Data = bean.getPerformingLocn(order_category,performing_facility_id,code);//,order_type_code);

						for(int pln=0; pln<PerformingLocn_Data.size(); pln++){
							record = (String [])PerformingLocn_Data.get(pln);
												
				//		System.out.println("Ass perf_locn:"+performing_locn);
				//		System.out.println("Bean perf_locn:"+record[1]);

				//		out.print("<script>alert('Ass PerfLoc :'+performing_locn) </script>");
				//		out.print("<script>alert('Bean PerfLoc :'+record) </script>");

				%>
						<option value="<%=record[1]%>"  <%=((record[1]).equals(performing_locn))?"selected":""%>><%=record[0]%></Option>
				<%
						}PerformingLocn_Data=null;
					}catch(Exception e){
						System.out.println("<script>alert('here2 : "+e+"')</script>");
					}
				%>
				</select></TD>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>

				</tr>
				<%
				}
			}
		}
		catch(Exception e){
			System.out.println("Exception@2: "+e);
		}
	%>
	</table>
	<input class='fields' type="hidden" name="from" id="from" value="<%=from%>">
	<input class='fields' type="hidden" name="to" id="to" value=<%=to%>>
	<input class='fields' type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input class='fields' type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input class='fields' type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input class='fields' type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input class='fields' type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input class='fields' type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input class='fields' type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> >
	<input class='fields' type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>

	<input class='fields' type="hidden" name="performing_facility_id" id="performing_facility_id" value=<%=performing_facility_id%>>
	<input class='fields' type="hidden" name="index" id="index" value=<%=index%>>
	<input class='fields' type="hidden" name="ordering_facility_id" id="ordering_facility_id" value=<%=ordering_facility_id%>>
	<input class='fields' type="hidden" name="order_category" id="order_category" value=<%=order_category%>>
	<input class='fields' type="hidden" name="order_type_code" id="order_type_code" value=<%=order_type_code%>>
	<input class='fields' type="hidden" name="performing_facility_id" id="performing_facility_id" value=<%=performing_facility_id%>>
	<input class='fields' type="hidden" name="source_type" id="source_type" value=<%=source_type%>>
	<input class='fields' type="hidden" name="source_location" id="source_location" value=<%=source_location%>>

	</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

