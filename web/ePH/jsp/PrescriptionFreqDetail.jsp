<!DOCTYPE html>
 <!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
		<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
		request.setCharacterEncoding("UTF-8"); 
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String classValue		=	"";
		String patient_id		= request.getParameter( "patient_id" ) ;
		String encounter_id		= request.getParameter( "encounter_id" ) ;
		String order_id			= request.getParameter( "order_id" ) ;
		String order_line_no	= request.getParameter( "order_line_no" ) ;
		String start_date		= request.getParameter( "start_date" )==null?"":request.getParameter( "start_date" ) ;
		String sliding_scale_yn	= request.getParameter( "sliding_scale_yn" )==null?"N":request.getParameter( "sliding_scale_yn" ) ;
		String iv_prep_yn	= request.getParameter( "iv_prep_yn" )==null?"":request.getParameter( "iv_prep_yn" ) ;
		if(start_date.length()>10)
			start_date = start_date.substring(0,10);

		String facility_id   = (String)session.getValue( "facility_id" );
		ArrayList<String> week_days	= new ArrayList<String>();

		String wkrmn			=   "0";
		String time				=	"";
		String qty				=	"";
		String unit				=	"";
		String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionBean_1";
		
		PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
		String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
		String presBean_name		= "ePH.PrescriptionBean";		
		PrescriptionBean presBean	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);

		bean.setLanguageId(locale);
		/*ArrayList	freq_det	=	bean.getFreqDet(order_id,order_line_no);

		if(freq_det != null && freq_det.size()>0){
			wkrmn		=	(String)freq_det.get(3);

			if(!wkrmn.equals("0")  && !start_date.equals("")){
				week_days = bean.getDayOfWeek(start_date); 
			}
		}*/
		if(!iv_prep_yn.equals(""))
			order_line_no = "1";
%>
		<FORM name="PrescriptionFreqForm" id="PrescriptionFreqForm" >
			<table  WIDTH="100%" ALIGN="center" BORDER="1">
<%
				//if(sliding_scale_yn.equals("N")){ //if-else condition commented for IN25450 --13/12/2010-- priya
				ArrayList	freq_det	=	presBean.getFreqDet(order_id,order_line_no);
				if(freq_det != null && freq_det.size()>0){
					wkrmn		=	(String)freq_det.get(3);
					if(!wkrmn.equals("0")  && !start_date.equals("")){
						week_days = bean.getDayOfWeek(DateUtils.convertDate(start_date, "DMY",locale,"en")); 
					}
				}
				if(!wkrmn.equals("0")){
%>
					<th colspan=<%=freq_det.size()%>><fmt:message key="Common.Week.label" bundle="${common_labels}"/></th>
					<tr>
<%  
					for(int i=0; i<freq_det.size(); i+=4) { 
						classValue	=	"QRYEVEN";
						wkrmn		=	(String)freq_det.get(i+3);			
%>	
						<td class="<%=classValue%>"><b><%=wkrmn%>
<%
						if(Integer.parseInt(wkrmn) <=7){
%>
							<font color="#990000">(<%=week_days.get((Integer.parseInt(wkrmn))-1)%>)</font>
<%
						}
						else{
							wkrmn =(((Integer.parseInt(wkrmn)-1)%7)+1)+"";
%>	       
						 <font color="#990000">(<%=week_days.get((Integer.parseInt(wkrmn))-1)%>)</font>
<%
						}
%>
						</b></td>
<%	     
					}	
%>
					</tr>
<%
				}
%>
				<th colspan=<%=freq_det.size()%>><fmt:message key="Common.time.label" bundle="${common_labels}"/></th>
				<tr>
<%  
				for(int i=0; i<freq_det.size(); i+=4) { 
					classValue	=	"QRYEVEN";
					time		=	(String)freq_det.get(i);			
%>	
					<td class="<%=classValue%>">&nbsp;&nbsp;&nbsp;<%=time%></td>
<%	
				}
%>
				</tr>
					<th colspan=<%=freq_det.size()%>>Dose</th>
				<tr>
<%  
				for(int i=1; i<freq_det.size(); i+=4) { 
					classValue	=	"QRYEVEN";
					qty			=	(String)freq_det.get(i);
					if(qty != null && qty != "" && Float.parseFloat(qty) < 1.0)
						qty = Float.parseFloat(qty)+"";

					unit		=	(String)freq_det.get(i+1);
					if(sliding_scale_yn.equals("N")){ ////if-else condition added for IN25450 --13/12/2010-- priya
%>	
						<td class="<%=classValue%>"><%=qty%> <%=bean.getUomDisplay(facility_id,unit)%></td>
<%
					}
					else{
%>
						<td class="<%=classValue%>"><fmt:message key="Common.SlidingScale.label" bundle="${common_labels}"/></td>
<%	
					}
				}
 %>
				</tr>
			</table>
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

