<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page import="eOR.*,java.util.*,eOR.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
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
	<script language="JavaScript" src="../../eOR/js/IndexOrderCatalog.js"></script>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	<script>
	function lockKey() {
		if(event.keyCode == 93)
			alert("Welcome to eHIS");
	}
	</script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int row_disp=12;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;

	String bean_id = "indexordercatalogbean" ;
	String bean_name = "eOR.IndexOrderCatalogBean";
//	String readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",index="";
	//String key=""; 

	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String catalog_desc="", dispMode="", tabVal="";
	String service_code ="",  code="";
//	String status="E";
	//String status_db = "";
	String mode="1";
	
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false;
	//alteredDBRecord = false;

	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	
	service_code	=	request.getParameter("service_code");
	index			=	request.getParameter("index");

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(service_code == null || service_code.equals("null"))service_code="";	
	if(index == null || index.equals("null"))index="";	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="";

	
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCatalogBean bean = (IndexOrderCatalogBean)getBeanObject( bean_id,bean_name, request ) ; /* Initialize Function specific end */
		
	//out.println("<script>alert(' index  :"+index+"');</script>");
	//out.println("<script>alert(' service_code  :"+service_code+"');</script>");

	if(dispMode.equals("")){
		bean.fetchDBRecords(service_code);
		//int dbRecordCount		=  bean.fetchDBRecords(service_code);
		if(tabVal.equals("S")){
			//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index,service_code);
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(index);	
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

		MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
	
		for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			//out.print("<script>alert('update_val')</script>");
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
%>
<body onMouseDown='CodeArrest()'; onKeyDown='lockKey()'>
	<form name="formIndexOrderCatalogDtl" id="formIndexOrderCatalogDtl">
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
	<%

	//out.println(start);

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
	<!-- <br>  -->
	<table class='grid' width='100%'>
	<td class="COLUMNHEADER" width='75%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class="COLUMNHEADER" width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<%
	try{
		if(tabVal.equals("S")){		
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
										
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");

				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				//status			=	(String)    htListRecord.get("status");
				stats  				=	MultiRecordSet.containsObject(code);
				
				if(stats){
					valid = MultiRecordSet.getValidKey(code);
				}
				//out.println("<script>alert('"+stats+"')</script>");

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
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){
				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
										
				code				=	(String)	htListRecord.get("code");
				catalog_desc		=	(String)	htListRecord.get("catalog_desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
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
				<%if(valid.equals("Y")){%>
					<td class='<%=classValue%>' ><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>' ><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></td>
				<%}%>
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
	</form>
</body>
</html>
<%

putObjectInBean(bean_id,bean,request);

%>

