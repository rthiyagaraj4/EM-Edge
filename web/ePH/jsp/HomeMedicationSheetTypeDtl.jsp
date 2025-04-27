<!DOCTYPE html>
<!-- Developed by    :Arun Kumar M
Module/Function : Home Medication Sheet Type -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<title>
	</title>
  <%
	request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/HomeMedicationSheetType.js"></script> 
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown ='lockKey()' OnMouseDown='CodeArrest()'>
		<form name="HomeMednSheetDtlForm" id="HomeMednSheetDtlForm">
<%
			boolean searched			=	request.getParameter( "searched" ) == null ? false : true  ;
			String medn_type			=	request.getParameter( "medn_type" ) == null ?"":request.getParameter( "medn_type" );
			String tabValue				=	request.getParameter( "tabValue" ) == null ?"":request.getParameter( "tabValue" );
			String tabevent				=	request.getParameter( "tabEvent" ) == null ?"":request.getParameter( "tabEvent" );
			String mode					=	"";
			String from = CommonBean.checkForNull(request.getParameter("from"));
			String to = CommonBean.checkForNull(request.getParameter("to"));
			int start = 0 ;
			int end = 0 ;
			int i = 0;
			int maxRecord	= 0;
			try{
			    String bean_id				= "HomeMednSheetBean" ;
				String bean_name			= "ePH.HomeMednSheetBean";
				HomeMednSheetBean bean		= (HomeMednSheetBean)getBeanObject( bean_id,bean_name,request) ;
				bean.setLanguageId(locale);
				bean.setMeTypeInd(medn_type);
				//Modified for RUT-SCF-0358[IN46714] - Start
				String classvalue			= "";
				String associate_list		="";
				String[] associate_list_val=null;
				int associate_count	=0;
				StringBuffer list_val=new StringBuffer();
				StringBuffer uncheck_list_val=new StringBuffer();
				ArrayList records=new ArrayList();
				List check_list=new ArrayList();
				List uncheck_list=new ArrayList();
				HashMap sqlMap = new HashMap();
				ArrayList result = new ArrayList();
				ArrayList allRecordStatus=bean.getAllRecordsStatus();
				String checked="checked";
				if(!medn_type.equals("") && (tabValue.equals("") || tabValue.equals("S"))){
					if (from.equals("")){
						bean.clear();
				    	result=bean.getFormAllRecords();
					}else{
						result=allRecordStatus;
					}
				}
					if (from.equals("")){
					Iterator r=result.iterator();
			    	while(r.hasNext()){
			    		associate_list=r.next().toString();
			    		associate_list=associate_list.replace("[","");
			    		associate_list=associate_list.replace("]","");
			    		associate_list_val=associate_list.split(",");
			    		if(associate_list_val[2].toString().trim().equals("E")){
			    			list_val.append(associate_list_val[0].toString().trim()+"/"+associate_list_val[1].toString().trim()+"/"+associate_list_val[2].toString().trim());
			    			list_val.append(",");
			    		}
			    		 else{
			    			uncheck_list_val.append(associate_list_val[0].toString().trim()+"/"+associate_list_val[1].toString().trim()+"/E");
			    			uncheck_list_val.append(",");
			    		} 
			    	}
					if(list_val.length()!=0){
						check_list=Arrays.asList(list_val.substring(0, list_val.length()-1).toString());
			    	}

			    	if(uncheck_list_val.length()!=0){
			    		uncheck_list=Arrays.asList(uncheck_list_val.substring(0, uncheck_list_val.length()-1).toString());
			    	}
			    	if(check_list.size()!=0 || uncheck_list.size()!=0)
			    		bean.setFormAssociatedRecords(check_list,uncheck_list);
			    	
			    	associate_count	=	bean.getFormAssociatedRecords().size();
			    	}else{
			    		associate_count	=	bean.getFormAssociatedRecords().size();
			    	}
				if(!medn_type.equals("") && !tabValue.equals("") && tabValue.equals("A")){
				    result=bean.getFormAssociatedRecords();
				  //  associate_count	=	result.size();
				   /*  if(associate_count==0)
				    	result=allRecordStatus; */
				}
				 int query_result_size		= 14;
					
			         if ( from == null || from.equals(""))
						start = 1 ;
					else
						start = Integer.parseInt(from) ;

					if ( to == null || to.equals(""))
						end =query_result_size;
					else
						end = Integer.parseInt(to) ;
					maxRecord = result.size();	
					if( (result != null && result.size()>0)){
%>
					<table id="hmemednfileid" border="0" cellpadding="0" cellspacing="0" width="90%" align="center">
						<tr>
							<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
	<%
	    					if ( !(start <= 1)) {
	%>
			 					<a href='javascript:SubmitLink("<%=(start-query_result_size)%>","<%=(end-query_result_size)%>","<%=(medn_type)%>","<%=(locale)%>")' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>	
	<%
							}
							if ( !((start+14) > result.size() )){
	%>
	    						<a href='javascript:SubmitLink("<%=(start+query_result_size)%>","<%=(end+query_result_size)%>","<%=(medn_type)%>","<%=(locale)%>")' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
	<%
	    					}
	%>
						</td>
						<td width='3%'>&nbsp;</td>
					</tr> 
					</table>
					<table border="1" width="90%" cellspacing="0" cellpadding="0" align="center" id='hmemednsheetdtl'>
							<TR>
								<TH width="10%"><fmt:message key="ePH.FormCode.label" bundle="${common_labels}"/></TH>
								<TH width="30%"><fmt:message key="ePH.FormDescription.label" bundle="${common_labels}"/></TH>
								<TH width="5%" ><fmt:message key="ePH.Select.label" bundle="${common_labels}"/></TH>
							</TR>
<%
							records=new ArrayList();
							ArrayList record_status=new ArrayList();	
							ArrayList formcodeList=bean.getUncheckedData();
								if(!medn_type.equals("") && (tabValue.equals("") || tabValue.equals("S"))){
									mode="insert";
									String link_columns = "1";
									if ( start != 1)
       								for( int j=1; j<start; i++,j++ ) {   }
									if ( i % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								while(i<end && i<result.size())	{
									records=(ArrayList) result.get( i );
										checked="checked"; 
									    for(int col_Count=0 ; col_Count<end ; col_Count++){
%>
										<TR>
											<TD class="<%=classvalue%>" ><%=(String)records.get( col_Count )%></TD>
											<%//if (associate_count>0){
												for(int k=0;k<formcodeList.size();k++){
													if(records.get( col_Count ).equals(formcodeList.get(k))){
														checked="false";
														break;
													}
												}
											//}
											col_Count++; %>
											<TD class="<%=classvalue%>" ><%=(String)records.get( col_Count )%></TD>
											<%col_Count++;
												/*if(records.get( col_Count )!=null && records.get( col_Count ).equals("E"))
													checked="checked";
											 else
												checked=""; */
											%>
								
											<td  CLASS="<%=classvalue%>" >&nbsp;&nbsp;
												<input type="checkbox" name="selected" id="selected" value="E" <%=checked%> onclick="fetchHmeMedTypeRecord()"><!-- Added for RUT-CRF-0061 [IN:45785] -->
											</td>
<%
												break;
											}
											i++;
										}
									}
									else if(!medn_type.equals("") && !tabValue.equals("") && tabValue.equals("A")){
										mode="modify";
										String link_columns = "1";
										if ( start != 1)
	       								for( int j=1; j<start; i++,j++ ) {   }
										if ( i % 2 == 0 )
											classvalue = "QRYODD" ;
										else
											classvalue = "QRYEVEN" ;
										while(i<end && i<result.size())	{
											checked="checked"; 
											records=(ArrayList) result.get( i );
										    for(int col_Count=0 ; col_Count<end ; col_Count++){
										    	//if ( associate_count>0){
														for(int k=0;k<formcodeList.size();k++){
															if(records.get( col_Count ).equals(formcodeList.get(k))){
																checked="";
																break;
														}
													}
												//}
	%>
											<TR>
												<TD class="<%=classvalue%>" ><%=(String)records.get( col_Count )%></TD>
												<%col_Count++; %>
												<TD class="<%=classvalue%>" ><%=(String)records.get( col_Count )%></TD>
<%
												col_Count++;
%>									
												<td  CLASS="<%=classvalue%>" >&nbsp;&nbsp;
													<input type="checkbox" name="selected" id="selected" value="E" <%=checked%> onclick="fetchHmeMedTypeRecord()"><!-- Added for RUT-CRF-0061 [IN:45785] -->
												</td>
<%
												break;
											}
											i++;
										}
									}

								}
								else{
									out.println("<script>errorData('"+medn_type+"');</script>");
								}
								
								putObjectInBean(bean_id,bean,request); 
							}
							catch(Exception e) {
								out.print("Exception @ Result JSP :"+e.toString());
							}
			//Modified for RUT-SCF-0358[IN46714] - End
%>	
				</tr>
			</table>
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%=maxRecord%>">
			<input type="hidden" name="from" id="from" value="<%=start%>">
			<input type="hidden" name="to" id="to" value="<%=end%>">
			<input type="hidden" name="medn_type" id="medn_type" value="<%=medn_type%>">
			<input type="hidden" name="tabValue" id="tabValue" value="<%=tabValue%>">
			<input type="hidden" name="p_mode" id="p_mode" value="<%=mode%>">
		</form>
	</body>
</html>

