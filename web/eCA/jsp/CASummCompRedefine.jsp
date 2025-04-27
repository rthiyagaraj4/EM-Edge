<!DOCTYPE html>
<%/* 
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035914		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   								 
-------------------------------------------------------------------------------------------------------------------------------------
*/%>

<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*,ePH.Common.*,eCommon.Common.*,java.text.*,java.lang.*,java.util.*,java.lang.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	webbeans.eCommon.RecordSet SubSecRecordSet = (webbeans.eCommon.RecordSet) getObjectFromBean("SubSecRecordSet", "webbeans.eCommon.RecordSet", session);
%>


<%!int row_count = 0;%>

<html>
	<head>
		<title><fmt:message key="Common.ChangeDescription.label" bundle="${common_labels}"/></title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "")
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";			
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		
		<script src="../../eCA/js/CASummCompRedefine.js" language="javascript"></script>
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		
		<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
		
		
		<!--//IN035914 Starts  --> 
		<script>
		function resetCurrentField(obj,cnt)
		{
			document.getElementById("shortDesc"+cnt).style.backgroundColor='#FFFFFF';
			document.getElementById("shortDesc"+cnt).style.color='#000000';
			document.getElementById("shortDesc"+cnt).style.fontWeight='';
			
			
			document.getElementById("isBoldEnabled"+cnt).style.fontWeight='';
			document.getElementById("isBoldEnabled"+cnt).value='';
			
			document.getElementById("routebgCol"+cnt).value='#FFFFFF';
			document.getElementById("routebgCol"+cnt).style.backgroundColor='#FFFFFF';
			
			document.getElementById("boldButton"+cnt).style.fontWeight='';
			
			
			document.getElementById("routeColor"+cnt).value='';	
			document.getElementById("routeColor"+cnt).style.backgroundColor='#000000';
			document.getElementById("routeColor"+cnt).style.color='#FFFFFF';
			
			document.getElementById("isColorPalletteEnabled"+cnt).value="||";
			
		}
		function boldTrigger(obj,cnt){
		
			/*if(obj.className == ""){
			obj.className = 'boldtrigger';
			document.getElementById("shortDesc"+cnt).className='boldtrigger';
			document.getElementById("isBoldEnabled"+cnt).value='bold';
			
			}
			else{
				obj.className = '';
				document.getElementById("shortDesc"+cnt).className='';
				document.getElementById("isBoldEnabled"+cnt).value='';
			}*/
				var colordef = document.getElementById("isColorPalletteEnabled"+cnt).value
			if(obj.style.fontWeight==""){
				document.getElementById("shortDesc"+cnt).style.fontWeight='bold';
				//alert(document.getElementById("shortDesc"+cnt).size);
				obj.style.fontWeight = 'bold';
				document.getElementById("isBoldEnabled"+cnt).value='bold';
				if("0||FFFFFF"==colordef)
				document.getElementById("isColorPalletteEnabled"+cnt).value="#000000"+"||"+"FFFFFF";
			}else{
			//alert(document.getElementById("shortDesc"+cnt).size);
				document.getElementById("shortDesc"+cnt).style.fontWeight='';
				obj.style.fontWeight = '';
				document.getElementById("isBoldEnabled"+cnt).value='';
				if("#000000||FFFFFF"==colordef)
				document.getElementById("isColorPalletteEnabled"+cnt).value="0"+"||"+"0";
			}
		}
		
		</script>
	<!-- 	
	 <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../ePH/js/prototype.js"></SCRIPT> 
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/colorPicker.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/yahoo.color.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/scriptaculous.js"></SCRIPT>-->
     <script src="../../eCommon/js/common.js" language="javascript"></script>
	 
    <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/prototype1.js"></SCRIPT>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/colorPicker.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/yahoo.color.js"></script>
     <SCRIPT TYPE="text/javascript" LANGUAGE="JavaScript" SRC="../../eCA/js/scriptaculous.js"></SCRIPT> 
 
     <style type="text/css">
		 #colorpicker { position: absolute; width: 145px; height: 145px; overflow: hidden; background: #F9F9F9;
						border: 2px #C0C0C0 outset;z-index: 1000;}
		 #colorpicker-hue-container {position: absolute;top: 4px; left: 120px; width: 18px; height: 110px; }
		 #colorpicker-hue-bg-img { width: 100%;height: 100%;}
         #colorpicker-hue-slider { position: absolute;top: 0;left: 0; width: 100%;height: 100%;}
         #colorpicker-hue-thumb { position: absolute;top: 0;left: 0;width: 18px;height: 18px;z-index: 1009; cursor: default;}
         #colorpicker-bar {text-align: right;padding-right: 10px;}
         #colorpicker-close {cursor: pointer;color: blue;font-size: 10px;font-family: Tahoma, Helvetica, Sans-Serif;
							  font-weight: bold;}
		 #colorpicker-div {position: absolute; top: 8px;left: 8px; width: 100px;height: 100px; border: 1px solid #666;}
		 #colorpicker-bg,
		 #colorpicker-bg-overlay {position: absolute;top: 0;left: 0;width: 100%;height: 100%;z-index: 1001;overflow: hidden;}
		 #colorpicker-selector {position: absolute;top: 0px;left: 0px;width: 11px;height: 11px; z-index: 1009;margin-top: -6px;
								 margin-left: -6px;cursor: default;}
		 #colorpicker-selector img {position: absolute;left: 0;top: 0;}
         #colorpicker-footer { position: absolute; top: 114px;left: 10px; width: 127px;}
		 #colorpicker-value { float: left;}
		 #colorpicker-value,
		 #colorpicker-value-input {font-size: 9px !important;font-family: Helvetica, Verdana, Sans-Serif;height: 15px;background: #FFFFFF;}
         #colorpicker-value-input {width: 40px;}
		 #colorpicker-okbutton {float: right;padding: 0 10px;background: #3366FF;font-size: 10px;font-family: Tahoma, Helvetica;}							Sans-Serif; border: 1px solid #666666;color: #ffffff;}
		 .default
		 {
			color:#000000;
		 }
	 </style>
		<!--//IN035914 Ends  --> 

	</head>

<%
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	HashMap ht = null;
	HashMap hm = null;
	String readOnly = ""; //IN035914

	StringBuffer sql = new StringBuffer();
	String classValue = "";
	String optid = "";
	String sdesc = "";
	String userSDesc="";
	String ldesc = "";
	String user_sdesc = "";
	String user_ldesc = "";
	String userDefShtDesc = "";//IN035914
	String colorLegend = "";//IN035914

	String boldTrigger = "";//IN035914
	String colorPallette = "";//IN035914
	String bgcolor = "";//IN035914
		String isBoldEna ="";
		String isColorPalletteEna="";
		String colorlegend = "";
		String userShtDesc = "";
		String legend = "";
		String  styles ="";
		String boldTriggerst="";
		String	boldTriggeret="";
		String colorPallete="";
		String bgColorPallete="";
		//CHL_CRF_006-IN035914 Ends
	//Modified by Archana @10-12-2008
	String MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session
			.getAttribute("MstQryPageCnt") != ""))) ? ((String) session
			.getAttribute("MstQryPageCnt")) : "14";
	int pageCnt = Integer.parseInt(MstQryPageCnt);
	System.out.println("CAOptionRedefine.jsp:Line:128:pageCnt-->"
			+ pageCnt);
	int row_disp = pageCnt;
	int start = 0;
	int end = 0;
	int fm_disp = 0, to_disp = 0;
	String from = "", to = "";
	String dispMode = "", update_sdesc = "", update_ldesc = "";

	dispMode = request.getParameter("dispMode");
	System.out.println("CAOptionRedefine.jsp:Line:117:dispMode-->"
			+ dispMode);
	from = request.getParameter("from");
	to = request.getParameter("to");
	if (from == null) {
		start = 1;
	} else {
		start = Integer.parseInt(from);
	}
	if (to == null) {
		end = pageCnt;
	} else {
		end = Integer.parseInt(to);
	}
	if (dispMode == null || dispMode.equals("null"))
		dispMode = "";
	try {
		if (dispMode.equals("")) {
			SubSecRecordSet.clearAll();
			con = ConnectionManager.getConnection();
			if (sql.length() > 0)
				sql.delete(0, sql.length());
			sql.append("SELECT SUMMARY_COMP_ID,SUMMARY_COMP_DESC,SUMCOMP_USER_DEF_COLOR_CODE,SUMMARY_COMP_DESC_LEGEND,SUMMARY_COMP_DESC_USER");
			//sql.append(" USER_DEF_SHORT_DESC,");
			//IN035914 Starts 

			//  sql.append(" USER_DEF_LONG_DESC FROM CA_OPTION START WITH "); sql.append(" HEADER_OPTION_ID IS NULL CONNECT BY PRIOR "); sql.append("OPTION_ID=HEADER_OPTION_ID ORDER BY ORDER_SEQ_NO ");

		//	sql.append(" USER_DEF_LONG_DESC,USER_DEF_COLOR_CODE FROM CA_OPTION START WITH ");
			sql.append(" FROM sm_desktop_sum_comp");
			sql.append(" WHERE APPLICABLE_MODULE_ID='CA'");//[Nijitha]
			sql.append(" ORDER BY SUMMARY_COMP_DESC ASC");//[Nijitha]
			//sql.append(" HEADER_OPTION_ID IS NULL CONNECT BY PRIOR ");
			//sql.append("OPTION_ID=HEADER_OPTION_ID ORDER BY ORDER_SEQ_NO ");
			//IN035914 Ends

			pst = con.prepareStatement(sql.toString());
			rs = pst.executeQuery();

			while (rs.next()) {
				optid = rs.getString(1);
				sdesc = rs.getString(2);
				//ldesc = rs.getString(3);
				//user_sdesc = rs.getString(4);
				//user_ldesc = rs.getString(5);
				userDefShtDesc = rs.getString("SUMCOMP_USER_DEF_COLOR_CODE"); //IN035914
				colorLegend = rs.getString("SUMMARY_COMP_DESC_LEGEND"); //IN035914
				userShtDesc = rs.getString("SUMMARY_COMP_DESC_USER"); //IN035914
				
				if (sdesc == null || sdesc.equals("null"))
					sdesc = "";
				
				if (userShtDesc == null || userShtDesc.equals("null"))
					userShtDesc = "";

				ht = new HashMap();
				ht.put("SUMMARY_COMP_ID", optid);
				ht.put("SUMMARY_COMP_DESC", sdesc);
				//ht.put("LONG_DESC", ldesc);
				//ht.put("USER_DEF_SHORT_DESC", user_sdesc);
				//ht.put("USER_DEF_LONG_DESC", user_ldesc);
				ht.put("SUMCOMP_USER_DEF_COLOR_CODE", userDefShtDesc); //IN035914
				ht.put("SUMMARY_COMP_DESC_LEGEND", colorLegend); //IN035914
				ht.put("SUMMARY_COMP_DESC_USER", userShtDesc); //IN035914
				SubSecRecordSet.putObject(ht);
			}
			row_count = SubSecRecordSet.getSize();//IN035914
			//row_count = pageCnt;//IN035914

			fm_disp = 0;
			to_disp = (row_disp - 1);

			if (to_disp > (row_count - 1))
				to_disp = (row_count - 1);

			from = "" + (start - 1);
			to = "" + (end - 1);
%>

<script>
	if('<%=row_count%>' <= 0){
		var msg = getMessage("NO_RECORD_FOUND_FOR_CRITERIA");	
		parent.parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
	}
</script>
<%
	}//if disp_mode
		else {

			int from_val = 0;
			int to_val = 0;

			from_val = Integer.parseInt(from);
			to_val = Integer.parseInt(to);
			if (dispMode.equals("Next")) {
				dispMode = "Next";
				from = "" + (start + row_disp);
				to = "" + (end + row_disp);

			} else if (dispMode.equals("Previous")) {
				dispMode = "Previous";
				from = "" + (start - row_disp);
				to = "" + (end - row_disp);
			}
			if (to_val > (row_count - 1))
				to_val = (row_count - 1);

			for (int j = from_val; j <= to_val; j++) {
				update_sdesc = request.getParameter("shortDesc" + j);
				update_ldesc = request.getParameter("user_sdesc" + j);
				//userShtDesc = request.getParameter("shortDesc" + j);
				
				if (update_sdesc == null || update_sdesc.equals("null")
						|| update_sdesc.equals(""))
					update_sdesc = "";
				if (update_ldesc == null || update_ldesc.equals("null")
						|| update_ldesc.equals(""))
					update_ldesc = "";
					
			//CHL_CRF_006-IN035914 Starts
			 isColorPalletteEna=request.getParameter("isColorPalletteEnabled"+j);
			 isBoldEna=request.getParameter("isBoldEnabled"+j);
			 
			 if("".equals(isBoldEna))
			 {	
				isBoldEna = "0";
			 }
			 else if("bold".equals(isBoldEna))
			 {
				boldTriggerst="<b>";
				boldTriggeret="</b>";
			 }
			 if("||".equals(isColorPalletteEna ))
			 {
			 isColorPalletteEna = "0"+"||"+"0";
			 }
			 
			 legend = isBoldEna+"||"+isColorPalletteEna;
			 StringTokenizer bgColorAndFontColor	=	new StringTokenizer(isColorPalletteEna,"||");
			 if(null!=bgColorAndFontColor)
			 {
			 colorPallete				=	bgColorAndFontColor.nextToken();
			 bgColorPallete				=	bgColorAndFontColor.nextToken();
			 }
			 if("0".equals(colorPallete))
			 colorPallete="";
		
			 styles = "<font style=background-color: #"+bgColorPallete+" color= #"+colorPallete+">"+boldTriggerst+""+update_sdesc+""+boldTriggeret+"</font>";
			 //CHL_CRF_006-IN035914 Ends		
					
					
					
					
				hm = (java.util.HashMap) SubSecRecordSet.getObject(j);
				//hm.put("SUMMARY_COMP_DESC", update_sdesc);
				//hm.put("USER_DEF_LONG_DESC", update_ldesc);
				hm.put("SUMCOMP_USER_DEF_COLOR_CODE", legend);//IN035914
				hm.put("SUMMARY_COMP_DESC_LEGEND", styles);//IN035914
				hm.put("SUMMARY_COMP_DESC_USER", update_sdesc);//IN035914
				SubSecRecordSet.setObject(j, hm);
				boldTriggerst="";
				boldTriggeret="";
			}

			fm_disp = Integer.parseInt(from);
			to_disp = Integer.parseInt(to);

			if (to_disp > (row_count - 1))
				to_disp = (row_count - 1);

			start = Integer.parseInt(from);
			end = Integer.parseInt(to);

		}//else
%>
<body  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<BR>

<form name="caSummCompRedefine" id="caSummCompRedefine" >  <!--IN035914 -->
<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
<tr >
<%
	if ((!(start <= 1))) {
%>
	<td class='white' width='88%'></td> 
		<td  align='right' >
	<A class='gridLink' HREF='javascript:onClick=checkVal("Previous");' text-decoration='none' > <fmt:message key="Common.previous.label" bundle="${common_labels}"/> </A></td>

<%
	}//if
			//else if (!((start + row_disp) >= row_count))
		if (!((start + row_disp) >= row_count)) {//IN035914
%>	<td class='white' width='88%'></td> 
	<td align='right'>
	<A class='gridLink' HREF='javascript:onClick=checkVal("Next");' text-decoration='none' > <fmt:message key="Common.next.label" bundle="${common_labels}"/> </A></td>
<%
	}//if
%>

	</tr>
</table>
<!--<table border='0' cellspacing='0' cellpadding='3' align='center' width='100%'>
	<tr height='18'><td class='COLUMNHEADERCENTER' width='50%' colspan='2'><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='50%' colspan='2'><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></td>
	
</table>-->
<table class='grid' width='100%' align='center' >
<tr height='18'><td class='COLUMNHEADERCENTER' width='50%' colspan='2'><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width='50%' colspan='5'><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></td>
	
<tr height='18'>
	<!--<td class='COLUMNHEADERCENTER' width='25%'>Summary ID</td>-->
   
	<td class='COLUMNHEADERCENTER' width='25%'>Summary Description</td>
	<td class='COLUMNHEADERCENTER' width='25%'>
	<td class='COLUMNHEADERCENTER' width='25%' >Summary Description</td>
	<td class='COLUMNHEADERCENTER' width='3%'>Bold</td>
	<td class='COLUMNHEADERCENTER' width='3%'>FC</td>
	<td class='COLUMNHEADERCENTER' width='3%'>BG</td>
	<td class='COLUMNHEADERCENTER'>Default</td>
	</td>
	
</tr>
<%
	StringTokenizer split_value = null;
		try {
			for (int i = fm_disp; i <= to_disp; i++) {

				classValue = "gridData";//( (i%2)==0 )? "QRYODD" : "QRYEVEN";
				ht = (java.util.HashMap) SubSecRecordSet.getObject(i);
				optid = (String) ht.get("SUMMARY_COMP_ID");
				sdesc = (String) ht.get("SUMMARY_COMP_DESC");
				userSDesc = (String) ht.get("SUMMARY_COMP_DESC_USER");
			
				userDefShtDesc = (String) ht.get("SUMCOMP_USER_DEF_COLOR_CODE");
				if ("||||".equals(userDefShtDesc)) {
					userDefShtDesc = "0" + "||" + "0" + "||" + "0";
				}

				if (null != userDefShtDesc
						&& !"null".equals(userDefShtDesc)
						&& !"".equals(userDefShtDesc)) {

					split_value = new StringTokenizer(userDefShtDesc,
							"||");

					boldTrigger = split_value.nextToken();
					colorPallette = split_value.nextToken();
					bgcolor = split_value.nextToken();
				

				} else {
					userDefShtDesc = "";
				}

				if (boldTrigger.equals("0")) {
					boldTrigger = "";
				}

				
				if(colorPallette.equals("0"))
				colorPallette = "";
				
				if (bgcolor.equals("0") || bgcolor.equals("")) {
					bgcolor = "#FFFFFF";
				}
%>
	<tr>
	
	
		<td class='<%=classValue%>' width='25%'>
		<%=((sdesc.equals("")) ? "&nbsp;" : sdesc)%>
		</td>
	
		
		 <td class='<%=classValue%>' >

		<!-- IN035914 Starts-->
		 <td class='<%=classValue%>'><input style="width: 60%;font-weight:;" id ='shortDesc<%=i%>' name ='shortDesc<%=i%>' type="text" name='usd<%=i%>'  value="<%=((userSDesc.equals("")) ? "" : userSDesc)%>" size="20" maxlength="30" onpaste='return CheckForSpecCharsWithCopyPaste(event);' onKeyPress='return CheckForSpeChar(event);'></td><input type='hidden' name='opt_id<%=i%>' id='opt_id<%=i%>' value="<%=optid%>">
					<input type='hidden' name='uDescLegend<%=i%>' id='uDescLegend<%=i%>' value="">
		 <input type='hidden' name='isBoldEnabled<%=i%>' id='isBoldEnabled<%=i%>' value="">
					<input type='hidden' name='isColorPalletteEnabled<%=i%>' id='isColorPalletteEnabled<%=i%>' value="">
		 <td class='<%=classValue%>'><input title="Bold" type="button" id = 'boldButton<%=i%>' name='bold'  value="B" size="2" maxlength="5" style="font-weight:<%=boldTrigger%>" onclick='boldTrigger(this,<%=i%>);'></td>
						<input type="hidden" name="route_color<%=i%>" id="route_color<%=i%>" value="">
		 <td class='<%=classValue%>'> <input title="Font Color" type="text" class="routecolor" style="width: 20px;height: 20px;" name="routeColor<%=i%>" id="routeColor<%=i%>"  id="routeColor<%=i%>" value="<%=colorPallette%>" onpaste='return CheckForSpeCharInColorPallete(event)' onKeyPress='return CheckForSpeCharInColorPallete(event)';></td> 
						  <script type="text/javascript" LANGUAGE="JavaScript" >
							
							var formbgcolor= ""; 
							formbgcolor = document.getElementById('routeColor<%=i%>').value;
							if(formbgcolor=="")
							{
							document.getElementById('shortDesc<%=i%>').className='default';
							}
							else
							{
							document.getElementById('shortDesc<%=i%>').style.color= "#"+formbgcolor;
							}
							
							new Control.ColorPicker("routeColor<%=i%>", { "swatch" : "routeColor<%=i%>" });
						  </script>
						 
		<td class='<%=classValue%>'><input title="BackGround Color" type="text" class="routecolor" style="width: 20px;height: 20px;" name="routebgCol<%=i%>" id="routebgCol<%=i%>"  id="routebgCol<%=i%>" value="<%=bgcolor%>" onpaste='return CheckForSpeCharInColorPallete(event)'; onKeyPress='return CheckForSpeCharInColorPallete(event)';> </td>
						  <script type="text/javascript" LANGUAGE="JavaScript" >
						  
						  var	percent=50;
							var bckColor="";
							var combinedcolor="";
							var userDefColor = "";
							var shtDesc = "";
							var formcolor= ""; 
						
						  shtDesc = document.getElementById("shortDesc<%=i%>").value;
						  document.getElementById('shortDesc<%=i%>').style.fontWeight='<%=boldTrigger%>';
						  document.getElementById('shortDesc<%=i%>').style.backgroundColor='#<%=bgcolor%>';
						  document.getElementById('routebgCol<%=i%>').value ='<%=bgcolor%>';
						  document.getElementById('uDescLegend<%=i%>').value=formcolor;
						  
						  new Control.ColorPicker("routebgCol<%=i%>", { "swatch" : "routebgCol<%=i%>" });
						  
						  </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	    
							<script>
							  var textColor = "";
							  var bgColor = "";
							  bgColor = document.getElementById('routebgCol<%=i%>').value;
							  textColor = document.getElementById('routeColor<%=i%>').value;
							  if(textColor=="") textColor ="0";
							  if(bgColor=="") bgColor ="0";
							  document.getElementById('isColorPalletteEnabled<%=i%>').value = textColor+"||"+bgColor;
							  document.getElementById("isBoldEnabled<%=i%>").value='<%=boldTrigger%>';
							</script>
		<td class='<%=classValue%>'><input title="Default" type="button" name='reset' id='reset'  value="D" size="2" maxlength="5" onclick='resetCurrentField(this,<%=i%>);'></td>
		<!--IN035914 Ends-->
		

		</td> 
		
	</tr>
<%
	}//for

		}//try

		catch (Exception ex) {
			ex.printStackTrace();
			//out.println("Exception=" + ex.toString());//common-icn-0181
		}
%>
</table>
<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
<input type='hidden' name='fm_disp' id='fm_disp' value="<%=fm_disp%>">
<input type='hidden' name='to_disp' id='to_disp' value="<%=to_disp%>">
<input type='hidden' name='from' id='from' value="<%=from%>">
<input type='hidden' name='to' id='to' value="<%=to%>">

<input type='hidden' name='u_shortdesc' id='u_shortdesc' value="<%=user_sdesc%>">
<input type='hidden' name='u_longdesc' id='u_longdesc' value="<%=user_sdesc%>">
<input type='hidden' name='dispMode' id='dispMode' value="<%=dispMode%>">

</form>


<%
	if (rs != null)
			rs.close();
		if (pst != null)
			pst.close();

	}//try
	catch (Exception eg) {
		eg.printStackTrace();
		//out.println("Exception=" + eg.toString());//COMMON-ICN-0181
	} finally {

		if (con != null)
			ConnectionManager.returnConnection(con, request);
		putObjectInBean("SubSecRecordSet", SubSecRecordSet, session);
	}
%>
</body>
</html>

