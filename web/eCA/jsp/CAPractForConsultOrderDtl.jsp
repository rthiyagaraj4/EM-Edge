<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="eCA.*,java.util.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>	
	<script language="JavaScript" src="../js/CAPractForConsultation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
</head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int row_disp=12;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "capractconsultorderbean" ;
	String bean_name = "eCA.CAConsultationBean";
//	String readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",index=""; //,extStatus=""
	//String key=""; 

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String catalog_desc="", dispMode="", tabVal="";
	String group_by ="",  code="", order_catalog = "";
//	String status="E";
	//String status_db = "";
	String mode="1";
	
	boolean stats = false;
	String update_val = "";
	String display_hdr = "";
	//boolean alteredRecord = false;
	//alteredDBRecord = false;

	eCA.CAMultiRecordBean MultiRecordSet		= new eCA.CAMultiRecordBean();
	
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	
	group_by	=	request.getParameter("group_by");
	order_catalog	=	request.getParameter("order_catalog");
	index			=	request.getParameter("index");

	

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(order_catalog == null || order_catalog.equals("null"))order_catalog="";	
	if(group_by == null || group_by.equals("null"))group_by="";	
	if(index == null || index.equals("null"))index="";	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="";

	
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )  
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	CAConsultationBean bean = (CAConsultationBean)getObjectFromBean( bean_id,bean_name, session ) ; 
	/* Initialize Function specific end */
		
	//out.println("<script>alert(' dispMode  :"+dispMode+"');</script>");
	//out.println("<script>alert(' service_code  :"+service_code+"');</script>");

	if(dispMode.equals("")){
		bean.fetchDBRecords(group_by,order_catalog);
		
		if(tabVal.equals("S")){
			//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,service_code);
			MultiRecordSet		= (eCA.CAMultiRecordBean)bean.getRecordSet(index,group_by,order_catalog);	
			row_count			=	MultiRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A")){
			MultiRecordSet		= (eCA.CAMultiRecordBean)bean.getBean();
			row_count			=  MultiRecordSet.getSize("DB");
		}



		fm_disp	=	0;
		to_disp	=	(row_disp-1);
		if(to_disp > (row_count-1))
		to_disp=(row_count-1);

		from = ""+(start - 1);
		to   = ""+(end - 1);
		%>

		<script>
			if('<%=row_count%>' <= 0){
			var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'common');	
			parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		}
		</script>
		<%
	}else{
		
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

		MultiRecordSet	 =(eCA.CAMultiRecordBean)bean.getBean();
	
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			
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
	if (group_by.equals("P"))
		display_hdr = "Common.ordercatalog.label";		
	else if (group_by.equals("O"))
		display_hdr = "Common.practitioner.label";


%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
	<form name="formPractConsultCatDtl" id="formPractConsultCatDtl">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
	<td class='WHITE' width='86%'></td>
	<%
	
	if ( (!(start <= 1)) && (start < row_count)){
	%>
		<td width='7%'>
		<A class="gridLink" HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
		</td>
	<%	
	}

	if ( !( (start+row_disp)+1 > row_count ) ){
	%>
		<td width='7%'>
		<A class="gridLink" HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
		</td>
	<%
	}

	%>
	</tr>
	</table> 
	<!-- <br>  -->
	<table class='grid' border='1' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<td class='COLUMNHEADER' width='75%'><fmt:message key="<%=display_hdr%>" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<%
	try{
		if(tabVal.equals("S")){	
			for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
										
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("description");
				//extStatus		=	(String)	htListRecord.get("extStatus");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");

				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				//status			=	(String)    htListRecord.get("status");
				stats  				=	MultiRecordSet.containsObject(code);
				
				if(stats){
					valid = MultiRecordSet.getValidKey(code);
					//extStatus = MultiRecordSet.getExtStatusKey(code);
				}
			

				//if(valid.equals("Y") && extStatus.equals("Y")){
				if(valid.equals("Y")){
					checkValue="checked";
					disabled="disabled";
				//}else if(valid.equals("Y") && extStatus.equals("N")){
				//}else if(valid.equals("Y")){
					//checkValue="";
					//disabled="disabled";
				}else{
					if(associate_yn.equals("Y")){
						checkValue="checked";
						disabled="";
					}else{
						if((stats)&&(associate_yn.equals("N")) ){
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

				/**********************/
			
				//out.println("valid :"+valid);
				//out.println("associate_yn :"+associate_yn);
				//out.println("stats :"+stats);
					
				tblrow_id	=	"tblrow_id"+i;

				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='<%=associate_yn%>' <%=checkValue%> <%=disabled%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){
				disabled="disabled";
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			="gridData";	//( (i%2)==0 )? "QRYODD" : "QRYEVEN";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
										
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("description");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				//extStatus		=	(String)	htListRecord.get("extStatus");
				//status_db			=	(String)	htListRecord.get("status");

//out.println("<script>alert(' associate_yn in associate tab :"+associate_yn+"');</script>");
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
				<%//if(valid.equals("Y") && extStatus.equals("Y")){%>
				<%if(valid.equals("Y")){%>
					<td class='<%=classValue%>'><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>'><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<%}
				
				//else if (extStatus.equals("N")){%>
				 	  <!-- <td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
					<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>   -->
					
				<%//}%>				
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='<%=associate_yn%>' <%=checkValue%> ></td>
				
				<%
				
				}
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
	%>
	</table>
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="to" id="to" value=<%=to%>>
	<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
	<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
	<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
	<input type='hidden' name='SelectYNStr' id='SelectYNStr' value="">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="dispMode" id="dispMode" value=<%=dispMode%> > 
	<input type="hidden" name="tabVal" id="tabVal" value=<%=tabVal%>>
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
	<input type="hidden" name="order_catalog" id="order_catalog" value="<%=order_catalog%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">
	</form>
</body>
<!-- Added By Abdelhamid for EDGE WORK -->
<script>

document.addEventListener('DOMContentLoaded', () => {
    // Loop through all checkboxes by their dynamic IDs
    const checkboxes = document.querySelectorAll('input[type="checkbox"][id^="select_yn"]');
    checkboxes.forEach(checkbox => {
        checkbox.addEventListener('change', function () {
            // Update the value to "Y" if checked, "N" otherwise
            this.value = this.checked ? "Y" : "N";
        });
    });
});

</script>
</html>
<%

putObjectInBean(bean_id,bean,request);

%>

