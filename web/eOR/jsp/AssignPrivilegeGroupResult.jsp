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
	<script language="JavaScript" src="../../eOR/js/AssignPrivilegeGroup.js"></script>
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	int row_disp=12;
	int start = 0 ;
	int end = 0 ;
	int fm_disp=0, to_disp=0;
    String bean_id = "Or_Assignprevilege_Group" ;
	String bean_name = "eOR.AssignPrevilegeGroup";
	String tblrow_id = "", checkValue="";
	String disabled = "", classValue  = "", valid="";
	String associate_yn="",index="";
	HashMap htListRecord= new HashMap();
	String from= "", to ="" ;
	String desc="", dispMode="", tabVal="";
	String order_catalog_code ="",  code="";
	String group_by="",grp_by_code="",dtl_grp_by_code="";
	String speciality = ""; 
	String search_criteria = ""; 
    String mode="1";
	boolean stats = false;
	String update_val = "";
	eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	tabVal			=	request.getParameter("tabVal");
	dispMode		=	request.getParameter("dispMode") ;
	from			=	request.getParameter( "from" ) ;
	to				=	request.getParameter( "to" ) ;
	group_by=request.getParameter("group_by");
	if(group_by == null || group_by.equals("null"))group_by="";	
		grp_by_code=request.getParameter("grp_by_code");
	if(grp_by_code == null || grp_by_code.equals("null"))grp_by_code="";	
		dtl_grp_by_code=request.getParameter("dtl_grp_by_code");
	if(dtl_grp_by_code == null || dtl_grp_by_code.equals("null"))dtl_grp_by_code="";
		 index			=	request.getParameter("index");
	speciality			=	request.getParameter("speciality")==null?"":request.getParameter("speciality");
	search_criteria			=	request.getParameter("search_criteria")==null?"":request.getParameter("search_criteria");

	if ( from == null || from=="null" || from.equals("null") )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null || to =="null" || to.equals("null") )
		end = row_disp;//7 ;
	else
		end = Integer.parseInt( to ) ;

	if(order_catalog_code == null || order_catalog_code.equals("null"))order_catalog_code="";	
	if(index == null || index.equals("null"))index="";	
	if(dispMode == null || dispMode.equals("null"))dispMode="";
	if(tabVal == null || tabVal.equals("null")) tabVal="";

	
	if ( mode == null || mode.equals("") ) 
		return;
	
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
		AssignPrevilegeGroup bean = (AssignPrevilegeGroup)getBeanObject( bean_id,  bean_name, request ) ; /* Initialize Function specific end */
	if(dispMode.equals("")){
		bean.fetchDBRecords(grp_by_code,dtl_grp_by_code);
		if(tabVal.equals("S")){
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getRecordSet(grp_by_code,dtl_grp_by_code,index,search_criteria,speciality);	
			row_count			=	MultiRecordSet.getSize("SELECT");
		}else if(tabVal.equals("A")){
			MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
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
        MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
	    for(int j=from_val; j<=to_val; j++){
			update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				MultiRecordSet.setDBBeanValue(j,update_val);
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
	<form name="AssignPrivilegeResultForm" id="AssignPrivilegeResultForm">
	<table cellpadding='3' cellspacing='0' border='0' width='97%' align='center'>
	<tr width='10%'>
	<td class='WHITE' align="right">
	<%
	  if ( (!(start <= 1)) && (start < row_count)){
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' ><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%	
	}
     if ( !( (start+row_disp) > row_count ) )
	{
	%>
		<A class='gridlink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' ><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%
	}
%>
	</td>
	</tr>
	</table> 
	<table class='grid' width='100%'>
	<%if(dtl_grp_by_code.equals("R")){%>
	<th class='columnheader' width='75%'><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></th>
	<%}
		/*
		Added by kishore kumar N on AUG-20-09 for CRF 641
		else if(dtl_grp_by_code.equals("P")	 )	{*/
		
		/* Added by Uma on 9/27/2009 for PMG-CRF-641*/
		if(group_by.equalsIgnoreCase("PG"))
		{
		%>		
			<th class='columnheader' width='75%' style="text-align:left"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<%
		}
		else
		{
	%>
			<th class='columnheader' width='75%' 	><fmt:message key="eOR.PrivilegeGroup.label" bundle="${or_labels}"/></th>
	<%}/*}
		ends here.
	*/%>
    <th class='columnheader' width='25%' style="text-align:left"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
	
	<%	 
	
	try{
		if(tabVal.equals("S")){		
			for(int i=fm_disp; i<=to_disp; i++){

				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
				code				=	(String)	htListRecord.get("code");
				desc		=	(String)	htListRecord.get("desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
				if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
				stats  				=	MultiRecordSet.containsObject(code);
				if(stats){
					valid = MultiRecordSet.getValidKey(code);
				}
				 if(valid.equals("Y")){
					checkValue="checked";
						if(associate_yn.equals("Y")){
						  checkValue="checked";
						disabled="";
					     }
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
		   tblrow_id	=	"tblrow_id"+i;
				mode = checkValue==""?"1":"2";
				%>
				<tr id='<%=tblrow_id%>'>
				<td class='<%=classValue%>' ><%=((desc.equals(""))?"&nbsp;":desc)%></td>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> <%=disabled%>></td>
				</tr>
				<%
				}
			}else if(tabVal.equals("A")){

				for(int i=fm_disp; i<=to_disp; i++){
				classValue			=	( (i%2)==0 )? "gridData" : "gridData";
				htListRecord		=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				code				=	(String)	htListRecord.get("code");
				desc		=	(String)	htListRecord.get("desc");
				valid				=	(String)	htListRecord.get("valid");
				associate_yn		=	(String)	htListRecord.get("associate_yn");
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
				mode = checkValue==""?"1":"2";
			%>
				<tr id='<%=tblrow_id%>'>
				<%if(valid.equals("Y")){%>
					<td class='<%=classValue%>' ><b><%=((desc.equals("null"))?"&nbsp;":desc)%></b></td>
				<%}else{%>
					<td class='<%=classValue%>' ><%=((desc.equals("null"))?"&nbsp;":desc)%></td>
				<%}%>
				<td class='<%=classValue%>'><input type='checkbox' name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>
				</tr>
				<%
				}
			}
		}
		catch(Exception e)
		{

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
     <input type="hidden" name="grp_by_code" id="grp_by_code" value="<%=grp_by_code%>">
	 <input type="hidden" name="dtl_grp_by_code" id="dtl_grp_by_code" value="<%=dtl_grp_by_code%>">


</form>
</body>
</html>
<%

putObjectInBean(bean_id,bean,request);

%>

