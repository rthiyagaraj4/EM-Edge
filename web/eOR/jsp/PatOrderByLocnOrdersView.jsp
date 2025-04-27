<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*,webbeans.eCommon.ConnectionManager ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/PatOrderByLocn.js"></script>
 	<script language="JavaScript" src="../js/RegisterOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<!-- Included to call the common view function-->
 	<Style TYPE="text/css"> </style>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	String code 					= request.getParameter( "code" ) ;
	String[] record					= null;
	String[] orderable_record		= null;
	String[] result_record			= null;

	String bean_id 	 				= "Or_PatOrderByLocnBean" ;
	String bean_name 				= "eOR.PatOrderByLocnBean";
	String class_value				= "";
	StringBuffer stPatient			= new StringBuffer();
	//PatOrderByLocnBean bean 		= (PatOrderByLocnBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	PatOrderByLocnBean bean			= (PatOrderByLocnBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList PatientDetails 		= bean.getNursingUnitPatientDetails(code) ;
	ArrayList OrderableResultDtls	= null;
	ArrayList OrderableDetails 		= null;
	ArrayList ResultDetails 		= null;
	ArrayList Patient				= null;	// ArrayList to store the Patients
	String color 					= "";
	StringBuffer patient_tool_tip	= null;

	int val							= 0;

	/* For Result Details */
	String accession_num			= null;
	String hist_rec_type			= null;
	String contr_sys_event_code		= null;
	String contr_sys_id				= null;
	String ext_image_appl_id		= null;
	String normalcy_ind				= null;
	String hist_data_type			= null;
	String normal_low				= null;
	String normal_high				= null;
	String result_num_uom			= null;
	String result_num				= null;
	String result_str				= null;
	String ext_image_obj_id			= null;
	String long_desc				= null;

	String result_clob				= null;
	StringBuffer disp_value			= null;

	String result_data[] 			= (String[])bean.getAbnormalCondition();
	String high_str					= (result_data[0]==null?"":result_data[0]);
	String low_str					= (result_data[1]==null?"":result_data[1]);
	String abn_str					= (result_data[2]==null?"":result_data[2]);
	String crit_str					= (result_data[3]==null?"":result_data[3]);
	String crit_high_str			= (result_data[4]==null?"":result_data[4]);
	String crit_low_str				= (result_data[5]==null?"":result_data[5]);


	/* End */

%>

 <form name="PatOrderView" id="PatOrderView" >
<table cellpadding=5 cellspacing=2 border=1 width="100%" align="center" class="grid">
	<tr>
		<td CLASS="DATA" align="left"> <font size="1">Patient Name / Orderables </font></td>
<%

		if(PatientDetails!=null && PatientDetails.size() > 0) {
			Patient			 = new ArrayList();
			for( int i=0 ; i< PatientDetails.size() ; i++ ) {
				record 		= (String[])PatientDetails.get(i);
				stPatient.append("'"+(record[1]==null?"":record[1])+ "',");
				patient_tool_tip = new StringBuffer();
				patient_tool_tip.append("Patient Id :- "+ (record[1]==null?"":record[1]));
				patient_tool_tip.append("<br> Sex :- "+ (record[3]==null?"":record[3]));
				patient_tool_tip.append("<br> Age :- "+ (record[4]==null?"":record[4]));
				Patient.add(record[1]);
%>
		<td CLASS="OR_ORDERABLES"  align="left" width="30%" onMouseOver='showToolTip("<%=patient_tool_tip.toString()%>");' onMouseOut="hideToolTip();">
			<font size="1"><%=record[2]%></font>
		</td>
<%			patient_tool_tip = null;
		}
	}
%>
	</tr>
<%
	if(stPatient!=null && stPatient.length() > 0){
		OrderableDetails = bean.getOrderableDetails(stPatient) ;
			for( int i=0 ; i< OrderableDetails.size() ; i++ ) {
				val			= 0;
				record 		= (String[])OrderableDetails.get(i);
				record[0]	= (record[0]==null?"":record[0]);
				record[1]	= (record[1]==null?"":record[1]);
				record[2]	= (record[2]==null?"":record[2]);
%>
	<tr>
		<td CLASS="OR_ORDERABLES" align="left"><font size="1"><%=record[0]%></font></td>
<%
				// To put the Loop and the TD's
				for( int k=0 ; k< PatientDetails.size() ; k++ ) {

				/*if(k % 2 == 0){
					class_value = "QRYEVEN";
				}else{
					class_value = "QRYODD";
				}*/
				class_value="gridData";

%>
		<td CLASS="<%=class_value%>" align="left" nowrap>
<%				if( (((String)Patient.get(k)).equals(record[2])) && val==0) {
					OrderableResultDtls = bean.getOrderableResultDetails(record[1],record[2]); //order_catalog_code and Patient ID
					val++;	//Increment so that Next time, no need to enter
					for( int j=0 ; j< OrderableResultDtls.size() ; j++ ) {
						orderable_record	=  (String[])OrderableResultDtls.get(j);
						orderable_record[0]	= (orderable_record[0]==null?"":orderable_record[0]);
						orderable_record[1]	= (orderable_record[1]==null?"":orderable_record[1]);
						orderable_record[2]	= (orderable_record[2]==null?"":orderable_record[2]);
						orderable_record[6]	= (orderable_record[6]==null?"":orderable_record[6]);

						if(orderable_record[2]!=null && (!orderable_record[2].equals("CO") || !orderable_record[2].equals("CN")) && orderable_record[4].equals("PH"))
							color = "ORYELLOW";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("CN") || orderable_record[2].equals("RJ") || orderable_record[2].equals("RP") || orderable_record[2].equals("FC")) )
							color = "ORCANCEL";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("CD") || orderable_record[2].equals("RS") || orderable_record[2].equals("RA")))
							color = "ORGREEN";
						else if(orderable_record[2]!=null && (orderable_record[2].equals("HD") || orderable_record[2].equals("HC") || orderable_record[2].equals("DC")))
							 color = "OAGREEN";
						else color = "LABEL";
%>
						<!--<table cellpadding=0 cellspacing=0 border=0 align="left">
							<tr>
								<td CLASS=<%=color%> align="left" nowrap>--><font size="1"><a class=<%=color%> href="#" onClick='callMenuFunctions("View","","<%=orderable_record[1]%>","","<%=record[2]%>")'><%=orderable_record[0]%></a></font><br><br>
								<!--</td>
								<td CLASS="LABEL" align="left" nowrap>-->
						<font size="1">
<%
									ResultDetails	= bean.getResultDetails(record[2],orderable_record[1],orderable_record[6]);
 									for( int z=0 ; z< ResultDetails.size() ; z++ ) {
										 result_record		= (String[])ResultDetails.get(z);
										 disp_value			= new StringBuffer();
										 disp_value.append("&nbsp");
										 accession_num		= (result_record[0]==null?"":result_record[0]);
										 hist_rec_type		= (result_record[1]==null?"":result_record[1]);
										 contr_sys_event_code		= (result_record[2]==null?"":result_record[2]);
										 hist_data_type		= (result_record[12]==null?"":result_record[12]);
										 result_num			= (result_record[14]==null?"":result_record[14]);
										 result_num_uom		= (result_record[15]==null?"":result_record[15]);
										 result_str			= (result_record[16]==null?"":result_record[16]);
										 normalcy_ind		= (result_record[17]==null?"":result_record[17]);
										 normal_low			= (result_record[18]==null?"":result_record[18]);
										 normal_high		= (result_record[19]==null?"":result_record[19]);
										 ext_image_obj_id	= (result_record[25]==null?"":result_record[25]);
										 ext_image_appl_id	= (result_record[26]==null?"":result_record[26]);
										 long_desc			= (result_record[39]==null?"":result_record[39]);
										 contr_sys_id			= (result_record[40]==null?"":result_record[40]);

										 if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(high_str) || normalcy_ind.equalsIgnoreCase(low_str) || normalcy_ind.equalsIgnoreCase(abn_str) ))
											normalcy_ind = "<FONT COLOR='RED' >Abnormal</FONT>";
										 else if(normalcy_ind != null && (normalcy_ind.equalsIgnoreCase(crit_str) || normalcy_ind.equalsIgnoreCase(crit_high_str) || normalcy_ind.equalsIgnoreCase(crit_low_str) ))
											normalcy_ind = "<FONT COLOR='MAGENTA'>Critical Abnormal</FONT>";
										 else if(normalcy_ind!=null && !normalcy_ind.equals(""))
											normalcy_ind = "<FONT COLOR='RED' >Abnormal</FONT>";
										 else
											normalcy_ind = "&nbsp;";

										 if(hist_data_type.trim().equals("NUM")){
											disp_value.append(result_num + "&nbsp;&nbsp;"+result_num_uom + "&nbsp;&nbsp;"+"("+normal_low+"-"+normal_high+")"+" "+normalcy_ind);
											if(result_str!=null && !result_str.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											}
											result_clob 	= "";//bean.getClobData(accession_num);
											if(result_clob!=null && !result_clob.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											}
										  }else if(hist_data_type.trim().equals("STR")){
											 if(result_str!=null && !result_str.equals(""))
											 {
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											 }
											 disp_value.append( " "+normalcy_ind);
											 result_clob	 = "";//bean.getClobData(accession_num);
											 if(result_clob!=null && !result_clob.equals(""))
											 {
											 	disp_value.append( "&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											 }
										   }else if(hist_data_type.trim().equals("TXT")){
											if(result_str!=null && !result_str.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewComments('"+i+"_"+j+"_"+k+"_"+z+"')\"> Result Comments </a>");
											}
											disp_value.append(" "+normalcy_ind);
											result_clob		  = "";//bean.getClobData(accession_num);
											if(result_clob !=null && !result_clob.equals(""))
											{
												disp_value.append("&nbsp;<a href=\"javascript:viewClobData('"+accession_num+"')\"> ");
												disp_value.append("<IMG SRC='../images/flow_text.gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
											}
										}
										if ((ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_obj_id!=null && !ext_image_obj_id.equals("")) && (ext_image_appl_id!=null && !ext_image_appl_id.equals("")) ) {
											//disp_value.append("&nbsp;<IMG SRC='../images/Xray.gif' WIDTH='16' HEIGHT='16' BORDER=0>");
											disp_value.append("&nbsp;<a href=\"javascript:getFile('"+hist_rec_type+"','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\"> ");
											disp_value.append("<IMG SRC='../../eCA/images/"+ext_image_appl_id+".gif' WIDTH='16' HEIGHT='16' BORDER=0></a>");
										}
										out.println("<br>&nbsp;&nbsp;"+long_desc+"&nbsp;&nbsp;"+disp_value.toString()+"<br><br>");
%>
										<input type="hidden" name="result_str_<%=i%>_<%=j%>_<%=k%>_<%=z%>" id="result_str_<%=i%>_<%=j%>_<%=k%>_<%=z%>" value="<%=result_str%>">
<%									disp_value = null; // Remove
								} // End of z
%>
							</font>
								<!--</td>
							</tr>
						</table>-->

<%			}
		}else {
			out.println("&nbsp;");
		} // End of OrderableResultDtls -- for
%>
		</td>
<%		}  // End of PatientDetails -- for
%>
	</tr>
<%		} // End of OrderableDetails -- for
	}	%>
</table>
</form>
	<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
		<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0"  width="100%" height="100%" align="center">
			<tr>
				<td width="100%" id="td_id"></td>
			</tr>
			</table>
		</div>
</body>
</html>


<%
		putObjectInBean(bean_id,bean,request);
%>

