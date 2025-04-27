<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------

07/06/2020	IN072524	Nijitha S     		07/06/2020		Ramesh G		ML-MMOH-CRF-1229.2
---------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %><!-- IN072524 -->
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
	
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../../eOR/js/HotSpot.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- OnMouseDown="CodeArrest()" > -->
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
  <%
  

	String mode				=	request.getParameter( "mode" ) ;
	//String function_id		=	request.getParameter( "function_id" ) ;

	String image_id         =	request.getParameter( "image_id" ) ;
	String hotspot_pos		=	request.getParameter( "hotspot_pos" ) ;
	String status			=	request.getParameter( "status" ) ;
	String x_pos			=	request.getParameter( "x_pos" ) ;
	String y_pos			=	request.getParameter( "y_pos" ) ;

	String bean_id			= "Or_ImageHotSpot" ;
	String bean_name		= "eOR.ImageHotSpotBean";
	String readOnly			= "" ;
	ArrayList imageList  =new ArrayList();

   String hotspot_id="";
   String hotspot_name="";
//out.println("<script>alert('"+request.getQueryString()+"')</script>");
	/*  variable dec end*/
	if(status==null||status.equals(""))
		status="";
	else
		status=status.trim();

	if(hotspot_pos==null||hotspot_pos.equals(""))
		hotspot_pos="A1";
	else
		hotspot_pos=hotspot_pos.trim();

	if((image_id==null)||image_id.equals(""))
		image_id="";
	else
		image_id=image_id.trim();
	// bean object instantiated
	ImageHotSpotBean  bean = (ImageHotSpotBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	bean.setMode(mode);
	// mandatory bean initial  operation 	 end
	//IN072524 Starts
    	Connection con=null ;
	Boolean isFPPApplicableyn =false;
	String fpp_yn ="";
	String fppchecked ="";
	String fppdisabled ="";
	//IN072524 Ends
	try{
		con = ConnectionManager.getConnection(request);
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");//IN072524
	
	}catch(Exception e){
	System.out.println("Caught=" + e.getMessage());	
	}
	finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con, request);
		 }catch(Exception e){System.out.println("exception"+e);
		 
		 }
	}
	//IN072524 Ends
	if(mode.equals("2")&&status.equals("modify")){
		readOnly="readOnly";
		
		try{
			//String[] ModifyLoadData=(String[]) bean.loadDataModify(image_id,hotspot_pos,x_pos,y_pos);
			String[] ModifyLoadData=(String[]) bean.loadDataModify(image_id,x_pos,y_pos);
			hotspot_name=(String)ModifyLoadData[0];
			hotspot_id=(String)ModifyLoadData[1];
			x_pos=(String)ModifyLoadData[2];
			y_pos=(String)ModifyLoadData[3];
			fpp_yn=(String)ModifyLoadData[4];//IN072524 Starts
		//	out.println("<script>alert('2==="+(String)ModifyLoadData[2]+"--3-"+(String)ModifyLoadData[3]+"--')</script>");
			ModifyLoadData=null;
		}catch(Exception e){
			System.out.println(e);
		}
	}else  if(!mode.equals("2")&&status.equals("insert")){
			 hotspot_id="";
			 hotspot_name="";
			 fpp_yn="";//IN072524 
			 fppdisabled="";//IN072524 
	} else{
			 hotspot_id="";
			 hotspot_pos="";
			 hotspot_name="";
			 image_id="";
	}
	//IN072524 Starts
	if("Y".equals(fpp_yn)){
		fppchecked ="checked";
	}
	if(mode.equals("2")){
		 fppdisabled = "disabled";
	}
	//IN072524 ENDS
  %>

<form name="frm_img_hot_spot" id="frm_img_hot_spot" method="post" 	target="messageFrame">
<table cellpadding="3" cellspacing="0" border=0 width='40%' align="center">

		
		<tr>
			<td class="label"></td>
			<td class="label" ><fmt:message key="Common.Image.label" bundle="${common_labels}"/></td>
			<td class="fields" colspan='2'>
				<select name="image_id_list" id="image_id_list"  onChange="parent.parent.change(this)" <%=readOnly%> >
					<option value=""> --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
						<%
							imageList = bean.getImageOnLoad();
							String[] record=null;
								for(int i=0; i<imageList.size() ; i++){
								record = (String []) imageList.get(i);
						%>
						<option value="<%=record[0]%>||<%=record[2]%>" <%if(image_id.equals(record[0]))out.println("selected");%> 	><%=record[1]%>
						</option>
						<%}	imageList=null;%>
					</select>
			</td>
		</tr>
		<tr>
			<td class="label" id='id1' name='id1'></td>
			<td class="label" id='idname' name='idname'>

			<%	if(image_id.equals("")){out.println("");
				}else{
						out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels")+"");
				}
			%></td>
			<td colspan='2'  class="fields" id='idvalue' name='idvalue'>
			<%
				if(image_id.equals("")){ out.println("");
				}else{
			%>
				  <input type="text"   name="hotspot_id" id="hotspot_id"  <%=readOnly%>    size="7"   maxLength="6"   value='<%=hotspot_id%>'  onBlur='ChangeUpperCase(this);'  onkeypress='return CheckForSpecChars(event)'><img src="../../eCommon/images/mandatory.gif" align='center'></img>
			<%	}%>
			</td>
			<td class="label" id='id4'></td>
		</tr>
		<tr>
			<td class="label" id='imagename1' name='imagename1'></td>
			<td class="label" id='imagename' name='imagename'>
				 <% if(!(image_id.trim().equals(""))){ 
				 out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels")+"");}%></td>
			<td class="fields"  colspan='2' id='imagevalue' name='imagevalue'>

			<%if(!(image_id.equals(""))){	%>

			<input type="text" name="hotspot_name" id="hotspot_name"  size="30" maxLength="30" onBlur="makeValidString( this );"  value="<%=hotspot_name%>">
			<img src="../../eCommon/images/mandatory.gif" align='center'></img>
			<%}%>
		   </td>
			<td class="label"  id='imagename4' ></td>
		</tr>
		<!-- //IN072524 Starts -->
		<%if(isFPPApplicableyn){ %>
		<tr>
		<td class="label" id='fpp_yntd' name='fpp_yntd'></td>
		<td class="label" id='fpp_yntd2' name='fpp_yntd2'><% if(!(image_id.trim().equals(""))){ 
				 out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FPPPATIENT.label","common_labels")+"");}%></td>
		<td class="fields"  colspan='2' id='fpp_yntd3'><%if(!(image_id.equals(""))){	%><input type="checkbox" name="fpp_yn" id="fpp_yn"  value="<%=fpp_yn%>" <%=fppchecked %> <%=fppdisabled %> onclick="setFPPYN(this)"  ><%}%>	</td>
		<td class="label"  id='fpp_yntd4' ></td>
		</tr>
		<%} %> 
		<!-- //IN072524 Ends -->
		
	</table>
	<input type="hidden" name="image_id" id="image_id" value="<%=image_id%>">
	<input type="hidden" name="mode" id="mode" value="<%=mode%>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id" id="function_id" value="Image_Hotspot">
	<input type="hidden" name="hotspot_pos" id="hotspot_pos" value="<%=hotspot_pos%>">
	<input type="hidden" name="x_pos" id="x_pos" value="<%=x_pos%>">
	<input type="hidden" name="y_pos" id="y_pos" value="<%=y_pos%>">
	</form>

 </body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

