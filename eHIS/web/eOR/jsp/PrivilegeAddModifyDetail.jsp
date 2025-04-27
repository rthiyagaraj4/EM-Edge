<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%> 

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

		 

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
 
<%

	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode				 = request.getParameter("mode") ;
	//String function_id		 = request.getParameter("function_id" ) ;
	String action			 = request.getParameter("action" ) ;
	String privilege_ctx_id  = request.getParameter("privilege_ctx_id" ) ;
	if((privilege_ctx_id==null)|| (privilege_ctx_id.equals("null")))
	privilege_ctx_id="";
	String facility_id = "";
	/*String appl_user_id = request.getParameter("appl_user_id");
	String reln_id = request.getParameter("reln_id");
	String resp_id = request.getParameter("resp_id");
	String facility_id = request.getParameter("facility_id");

	out.println("privilege_ctx_id  " + privilege_ctx_id);
	out.println("appl_user_id  " + appl_user_id);
	out.println("reln_id  " + reln_id);
	out.println("resp_id  " + resp_id);
	out.println("facility_id  " + facility_id);*/

	//out.println(privilege_ctx_id);
	String bean_id			 = "privilege" ;
	String bean_name		 = "eOR.PrivilegeBean";
	//String readOnly			 = "" ;
	//String disabled			 = "" ;
	String grp_exception_id  = "" ;
	String facility_name	 = "" ;
	String privilege_id		 = "" ;
	String privilege_value 	 = "" ;
	
	//String priv_value		 = "" ;
	String values			 = "" ;

	//String include			 = "" ;//int count_code= 0;
								//	int count_code1= 0;
	//String active_yn		 = "";
	String privilege_ctx	 = "";
	
	
	//modified by Kavitha K 20.12.2004:
	/*
	String privilege_id1 = "";	//"checked" or ""
	
	String privilege_id2 = "";	// "selected" or ""
	String privilege_id3 = "";	// "selected" or ""
	String privilege_id4 = "";	// "selected" or ""
	String privilege_id5 = "";	// "selected" or ""
	String privilege_id6 = "";	// "selected" or ""
	String privilege_id7 = "";	// "selected" or ""
	String privilege_id8 = "";	// "selected" or ""
	String privilege_id9 = "";	// "selected" or ""*/
	//modified by Kavitha K 20.12.2004

	//added by kavitha 20.12.2004
	String privilege_value1="";//"checked" or ""
	String privilege_value2="A";
	String privilege_value3="A";
	String privilege_value4="A";
	String privilege_value5="A";
	String privilege_value6="A";
	String privilege_value7="A";
	String privilege_value8="A";
	String privilege_value9="A";
	//end of added by kavitha 20.12.2004

	
	String ascc1 = "N";
	String ascc2 = "N";
	String ascc3 = "N";
	String ascc4 = "N";
	String ascc5 = "N";
	String ascc6 = "N";
	String ascc7 = "N";
	String ascc8 = "N";
	String ascc9 = "N";

	//String valSourceLevel[]  ={"U","R","P"} ;
	//String descsourceLevel[]={"User Id","RelationShip","Responsibility"} ;
	//String valSourceVal[]  ={"S","M","A","N"} ;  //modified by kavitha on 20.12.2004--S=Self Order,M=Medical Team,A=All Orders,N=Not Applicable
	//String descsourceVal[]={"Allowed","Not Allowed"} ; //,"Allowed with Exception","Not Allowed with Exception"
	//String update_val = "";
	//boolean alteredRecord=false;
	int   fm_disp=0,to_disp=0, noOfRecords=0;
	//int start=0,row_disp=8,end=0;
	// String previousRecord=0, nextRecord =0;
	ArrayList records = null ;

	//int j = 1 ;
	String classValue ="";

	//String  from= "", to ="" ;
	String nextPrevFlag =""; //removed by Kavitha.K 1/7/2005
	/*	Initialize Function specific start */
	//eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	PrivilegeBean privilege = (PrivilegeBean)getBeanObject( bean_id,bean_name,request ) ;

	privilege.setFunctionId(privilege.checkForNull(request.getParameter("function_id")));

	try{
	
	//Both in UPdate and Insert Mode
	if(action.equalsIgnoreCase("create")){

	privilege.clearALL();
	records =  privilege.getIdentifiers();
			if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
				
				//System.out.println("#####in modify mode");

			//out.println("privilege ctx id   " + privilege_ctx_id);
			//System.err.println("@@@@@@@@########@@@@@@@@@ privilege ctx id " + privilege_ctx_id);
			//privilege.loadDetail(privilege_ctx_id,appl_user_id,reln_id,resp_id,facility_id)	;
			privilege.loadDetail(privilege_ctx_id);
			//privilege_value 	 = privilege.getPrivilege_value();//removed by Kavitha.K 07.01.2005
			//out.println(privilege_value);
			
			//System.err.println("@@@@@@@@@@@@@@@ Privilege Value " + privilege_value);

			//active_yn			 = privilege.getActive_yn()		;
			facility_id			 = privilege.getFacility_id()	;
			facility_name		 = privilege.getFacility_name()	;
		    //privilege_id		 = privilege.getPrivilege_id()	;

			//System.err.println("@@@@@@@@@@@@@@@ Privilege Id " + privilege_id);
	        privilege_ctx		 = privilege.getPrivilege_ctx()	;

			//out.println("<script>alert('privilege_value:::::"+privilege_value+"')</script>");
			//out.println("<script>alert('facility_id:::::"+facility_id+"')</script>");
			//out.println("<script>alert('facility_name:::::"+facility_name+"')</script>");
			//out.println("<script>alert('privilege_ctx:::::"+privilege_ctx+"')</script>");


		}

	}else{

		//System.out.println("#####request="+request);
		privilege.synStore(request);
	//out.println("<script>alert('synStore:::::"+privilege.synStore(request)+"')</script>");

	}
	//if(!mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ))
	records =  privilege.getIdentifiersStore();

	//System.out.println("#####records="+records);
	values  = privilege.getPrivValue();	
	//out.println("<script>alert('#####values:::::"+values+"')</script>");

//	out.println(privilege.tempChk);
	noOfRecords  = records.size();



	/*nextPrevFlag  = ChkDef.defaultString(request.getParameter("nextPrevFlag"));
	previousRecord= ChkDef.defaultInt(request.getParameter("previousRecord"));
	nextRecord	  = ChkDef.defaultInt(request.getParameter("nextRecord"));*///removed by Kavitha.K 1/7/2005

}catch(Exception e){

	System.out.println(e.getMessage());
}

%>

<form name="privilegeDetail" id="privilegeDetail" method="post" scrolling="yes" >




<table border="1" id="headerTab" cellpadding=3 cellspacing=0 width="100%" align="center">
<%try {
	%>

<tr>
	<td class=columnheader rowspan="2"><fmt:message key="eOR.GroupIdentifier.label" bundle="${or_labels}"/></td>
	<!--<th align="left" rowspan="2"><%/*Value */ %>Privilege Type </th>--><!--removed by Kavitha.K 21.12.2004-->
	<!--<th align="left" width='10%' >Active</th>-->
	<td class=columnheadercenter colspan="9"><fmt:message key="eOR.Privilege.label" bundle="${or_labels}"/></td>
</tr>
		
<tr>
	<td class=columnheader><fmt:message key="Common.Order.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.Amend.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.Authorization.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.SpecialApproval.label" bundle="${common_labels}"/></td>
	<td class=columnheader><fmt:message key="eOR.HoldResume.label" bundle="${or_labels}"/></td>
	<td class=columnheader><fmt:message key="Common.Discontinue.label" bundle="${common_labels}"/></td>
</tr>
<%
		//out.println("<script>alert('noOfRecords:::::"+noOfRecords+"')</script>");
	if(noOfRecords != 0){%>
<!--<%
//privilege_value = (String )recCurrent.get("privilege_value");//added by Subhash.Y
//out.println("privilege Value   "  + privilege_value);
%>-->

	
<!--&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//Start
-->
<%	
//String bean_value[] = null;
//String bean_privilege_value[] = null;
String privilege_value_curr = "";
//String grp_exp_id = "";
String grp_id="";
//boolean flag = false;
//int first_time=0;
//int fm= fm_disp-1;//removed by Kavitha.K 1/10/2005


String grp_exception_name ="";
String ascc			  ="";
String temp="";

for(int i=0; i < noOfRecords; i++){
//	htListRecord		=	(java.util.HashMap)	MultiRecordSet.getListObject(i);
//associate_yn		=	(String)	htListRecord.get("associate_yn");
//out.println("<script>alert('associate_yn   :"+associate_yn+"');</script>");

HashMap recCurrent = (HashMap)records.get(i);
grp_exception_name =(String)recCurrent.get("grp_exception_name");
grp_exception_id = (String)recCurrent.get("grp_exception_id");
ascc			  =(String)recCurrent.get("include");
classValue			=( (i%2)==0 )? "QRYODD" : "QRYEVEN";
//privilege_value_curr = (String )recCurrent.get("privilege_value");//Removed by Kavitha.K on 06.01.2005
/*if(privilege_value_curr ==null)
	privilege_value_curr = "A";*///removed by kavitha 07.01.2005

if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
{
	if(!ascc.equals("") && !ascc.equals("N") && !ascc.equals(" "))
	{	
		grp_id=grp_exception_id;
		privilege_value_curr = privilege_value_curr;
		
		//out.println("<script>alert('grp_exception_id   :"+grp_exception_id+"');</script>");
		Vector listPrivIDs = privilege.getPrivilegeIDs(privilege_ctx_id,grp_exception_id);
		//System.err.println("Vector @@######@@@@@@@@@@ " + listPrivIDs);
		//System.out.println("listval"+listPrivIDs);
		//System.out.println("size"+listPrivIDs.size());
		for(int k=0;k<listPrivIDs.size();k++)
		{
			temp = ((String)listPrivIDs.get(k)).trim();
			//out.println("<script>alert('temp   :"+temp+"');</script>");
			k++;
			if(temp.equalsIgnoreCase("O")) 
				{
				//System.out.println("privilege_value1  FOR O :"+((String)listPrivIDs.get(k)).trim());

					if(((String)listPrivIDs.get(k)).trim().equals("Y"))
						{ 
							privilege_value1 = "checked"; 
							ascc1 = "Y";
						}
						
				}
			if(temp.equalsIgnoreCase("V")) { 
				//System.out.println("privilege_value1  FOR V :"+((String)listPrivIDs.get(k)).trim());
				privilege_value2 = ((String)listPrivIDs.get(k)).trim(); 
				
				ascc2 = "Y"; }
			if(temp.equalsIgnoreCase("C")) {
				//System.out.println("privilege_value1  FOR C :"+((String)listPrivIDs.get(k)).trim());
				privilege_value3 = ((String)listPrivIDs.get(k)).trim();  
				ascc3 = "Y"; }
			if(temp.equalsIgnoreCase("A")) { 
				privilege_value4 = ((String)listPrivIDs.get(k)).trim();  
				//System.out.println("privilege_value2  FOR A :"+privilege_value2);
				ascc4 = "Y"; }
			if(temp.equalsIgnoreCase("U")) { 
				privilege_value5 = ((String)listPrivIDs.get(k)).trim(); 
				ascc5 = "Y"; }
			if(temp.equalsIgnoreCase("S")) { 
				privilege_value6 = ((String)listPrivIDs.get(k)).trim(); 
				ascc6 = "Y"; }
			if(temp.equalsIgnoreCase("P")) {
				privilege_value7 = ((String)listPrivIDs.get(k)).trim(); 
				ascc7 = "Y"; }
			if(temp.equalsIgnoreCase("H")) { 
				privilege_value8 = ((String)listPrivIDs.get(k)).trim(); 
			ascc8 = "Y"; }
			if(temp.equalsIgnoreCase("D")) { 
				privilege_value9 = ((String)listPrivIDs.get(k)).trim(); 
				ascc9 = "Y"; }
		}

	}else{privilege_value_curr = "";}
}

//out.println("<script>alert('values:::::"+values+"')</script>");
//System.out.println("####values="+values);

/*end of removed by Kavitha.K 1/19/2005
if((values !="")||(values != null)|| (values !="null")){

	//out.println("<script>alert('values inside value loop  :"+values+"');</script>");

	StringTokenizer stoken = new StringTokenizer(values,"~");
	final int count_code		=	stoken.countTokens();
	bean_value = new String[count_code];
		int k = 0;
	while(stoken.hasMoreTokens()){
		bean_value[k]	=	stoken.nextToken();
		k++;
	}

	for(int x=0;x<bean_value.length;x++){
		//out.println("<script>alert('#####stoken1:::::')</script>");
		
		StringTokenizer stoken1= new StringTokenizer(bean_value[x],"||");		
		String temp = stoken1.nextToken();
		String actualString = stoken1.nextToken();	
		
		//out.println("<script>alert('stoken1:::::"+stoken1+"')</script>");
		//out.println("<script>alert('temp = stoken1.nextToken():::::"+temp+"')</script>");
		//out.println("<script>alert('actualString:::::"+actualString+"')</script>");


		StringTokenizer stoken2 = new StringTokenizer(actualString,",");
//		StringTokenizer stoken1 = new StringTokenizer(bean_value[x],",");
		final int count_code1		=	stoken2.countTokens();
		grp_exp_id = stoken2.nextToken();

		//out.println("<script>alert('stoken2:::::"+stoken2+"')</script>");
		//out.println("<script>alert('count_code1:::::"+count_code1+"')</script>");
		//out.println("<script>alert('grp_exp_id:::::"+grp_exp_id+"')</script>");

		if(grp_exception_id.equals(grp_exp_id))
		{
			privilege_value1 = "";privilege_value2 = "A";privilege_value3 = "A";
			privilege_value4 = "A";privilege_value5 = "A";privilege_value6 = "A";privilege_value7 = "A";
			privilege_value8 = "A";privilege_value9="A";	ascc1 = "N";ascc2 = "N";ascc3 = "N";ascc4 = "N";ascc5 = "N"; ascc6="N"; ascc7 = "N";ascc8 = "N";ascc9= "N";flag =true;
			
			bean_privilege_value = new String[count_code1];	
			bean_privilege_value[0] = grp_exp_id;
			int m = 1;
			while(stoken2.hasMoreTokens())
			{
				bean_privilege_value[m]  = stoken2.nextToken();
				privilege_value_curr = bean_privilege_value[1] ;
				m++;
			}
			//modified by Kavitha.K 20.12.2004
			for(int h=2;h<bean_privilege_value.length;h++){
			if(bean_privilege_value[h].equalsIgnoreCase("O")) {
				if((request.getParameter("O")).equals("Y"))
					{ 
					privilege_value1 = "checked"; 
					ascc1 = "Y";
					}
				}
			if(bean_privilege_value[h].equalsIgnoreCase("V")) {
				//privilege_id2 = "selected"; 
				privilege_value2=request.getParameter("V"); 
				ascc2 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("C")) {
				//privilege_id3 = "selected"; 
				privilege_value3=request.getParameter("include");
				ascc3 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("A")) {
				//privilege_id4 = "selected";
				privilege_value4=request.getParameter("include"); 
				ascc4 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("U")) {
				//privilege_id5 = "selected";
				privilege_value5=request.getParameter("include");
				ascc5 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("S")) {
				//privilege_id6 = "selected"; 
				privilege_value6=request.getParameter("include");
				ascc6 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("P")) {
				//privilege_id7 = "selected"; 
				privilege_value7=request.getParameter("include");
				ascc7 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("H")) {
				//privilege_id8 = "selected";
				privilege_value8=request.getParameter("include");
				ascc8 = "Y"; }
			if(bean_privilege_value[h].equalsIgnoreCase("D")) {
				//privilege_id9 = "selected";
				privilege_value9=request.getParameter("include");
				ascc9 = "Y"; }
			}	//end of modified by Kavitha.K 20.12.2004	

		}
		
		
	}if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) 
	{
		if(!grp_id.equals("")){

  			String flag_value=privilege.getFlagValue();

			//out.println("<script>alert('flag_value:::::"+flag_value+"')</script>");

			if(flag_value!=""){
				StringTokenizer s = new StringTokenizer(flag_value,"~");
				final int fv		=	s.countTokens();
				String fg_value[] = null;
				fg_value = new String[fv];
				int a = 0;
				while(s.hasMoreTokens()){
					fg_value[a]	=	s.nextToken();
					a++;
				}
				if(fg_value.length > 1)
				{
					//first_time=1;
					//if(fg_value.length >= 2){
						for(int b=0;b<fg_value.length;b++)
						{	
							String val=fg_value[b];
							int v=Integer.parseInt(val);
							//for(int c=b+1;c<fg_value.length;c++){
								if(noOfRecords == v)//modified by Kavitha.K 1/10/2005
									first_time = 1 ;
								//else
								//{first_time = 0 ;}
							//}
							
						}		
					//}


				}
			}
			//out.println("<script>alert('first_time::::"+first_time+", i::"+i+",flag :::"+flag +"');</script>");
			if(flag == false && count_code > 0 && first_time == 1){
				privilege_value1 = "";privilege_value2 = "A";privilege_value3 = "A";
				privilege_value4 = "A";privilege_value5 = "A";privilege_value6 = "A";privilege_value7 = "A";
				privilege_value8 = "A";privilege_value9="A";
				ascc1 = "N";ascc2 = "N";ascc3 = "N";ascc4 = "N";ascc5 = "N"; ascc6="N"; ascc7 = "N";ascc8 = "N";ascc9= "N";//privilege_value_curr="";
			}else{flag = false;}

		}
		grp_id="";
	}	

}*/
//end of removed by Kavitha.K 1/19/2005


//out.println("privilege Value   "  + privilege_value_curr);
//out.println("Ascc " + ascc);
%>
<tr>
	<td class="<%=classValue%>" style="display:none">
	<INPUT TYPE="hidden" name="grp_exception_id<%=i%>" id="grp_exception_id<%=i%>" value=<%=grp_exception_id%>></td>
	<td align="left" class='<%=classValue%>' nowrap ><%=grp_exception_name%></td>

	<!-- modified by kavitha k on 20.12.2004-->


<!--&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
//Start
-->
<!--<td align="left" class='<%=classValue%>' nowrap>
<%
//	privilege_value_curr = "";
	%><select name="privilege_value<%=i%>" id="privilege_value<%=i%>">
		<% /*onChange="return parent.parent.assignPrivilege(this)" */ %>
<option selected value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<!-- value="A" <%=eHISFormatter.select(privilege_value+i,"A")%>-->
<!--<option value="A" <%=eHISFormatter.select(privilege_value_curr,"A")%>>Allowed</option>
	<option value="X" <%=eHISFormatter.select(privilege_value_curr,"X")%>>Not Allowed</option>
<%--<option value="Y" >Allowed with Exception</option>
<option value="N" >Not Allowed with Exception</option>--%>
</select>
<INPUT TYPE="hidden" name='privilege_value_hidden<%=i%>' id='privilege_value_hidden<%=i%>' value="<%=(privilege_value_curr).trim()%>">
<img src="../../eCommon/images/mandatory.gif"></img>
</td>
<!--	<td align="center" class='<%//=classValue%>' ><INPUT TYPE="checkbox" name="include<%//=i%>" id="include<%//=i%>" 
	value='<%//= ascc %>' <%//=eHISFormatter.ChkBoxChecked("y",ascc)%> 
	onclick="return parent.parent.checkActive(this)"></td>-->


<%
		int j=1; 
%>
<!--added by kavitha k on 13.12.2004-->
<td class='<%=classValue%>'><input type="checkbox" name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>"
onclick="return parent.parent.checkActive(this)" <%= privilege_value1 %> value='<%=ascc1%>'>
	<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc1.trim()%>">
	</td>
	
<td class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value2).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value2).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value2).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value2).equals("N"))out.println("selected");%>>N</option> 
</select>
	
		<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc2.trim()%>">
	</td>

	<td class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>">
<option value='A'<%if((privilege_value3).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value3).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value3).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value3).equals("N"))out.println("selected");%>>N</option> 
</select>
		<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc3.trim()%>">
	</td>

	<td class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value4).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value4).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value4).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value4).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc4.trim()%>">		
	</td>

	<td align="center" class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value5).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value5).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value5).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value5).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc5.trim()%>">		
	</td>



	<td align="center" class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value6).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value6).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value6).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value6).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc6.trim()%>">		
	</td>

	<td align="center" class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value7).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value7).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value7).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value7).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc7.trim()%>">
		
	</td>

	<td align="center" class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value8).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value8).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value8).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value8).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%= ascc8.trim()%>">
	</td>

	<td align="center" class='<%=classValue%>'><select name="privilege_value<%=i%><%=j%>" id="privilege_value<%=i%><%=j%>" >
<option value='A'<%if((privilege_value9).equals("A"))out.println("selected");%>>A</option>
<option value='S'<%if((privilege_value9).equals("S"))out.println("selected");%>>S</option>
<option value='M'<%if((privilege_value9).equals("M"))out.println("selected");%>>M</option>
<option value='N'<%if((privilege_value9).equals("N"))out.println("selected");%>>N</option> 
</select>
<input type="hidden" name="include<%=i%><%=j++%>" id="include<%=i%><%=j++%>" value="<%=ascc9.trim()%>">
	</td>
	<!--end of added by kavitha k on 13.12.2004-->
</tr>
	<input type="hidden" name="privilege_id<%=i%>" id="privilege_id<%=i%>" value="">
	<!--<input type="hidden" name="privilege_value<%=i%>" id="privilege_value<%=i%>" value="">-->
	<%
	/*
	privilege_id1 = "";
	
	privilege_id2 = "";
	privilege_id3 = "";
	privilege_id4 = "";
	privilege_id5 = "";
	privilege_id6 = "";
	privilege_id7 = "";
	privilege_id8 = "";
	privilege_id9 = "";*/
	//modified by Kavitha.K 21.12.2004
	privilege_value1="";//modified by Kavitha.K 06.01.2005
	privilege_value2="A";
	privilege_value3="A";
	privilege_value4="A";
	privilege_value5="A";
	privilege_value6="A";
	privilege_value7="A";
	privilege_value8="A";
	privilege_value9="A";
	privilege_value_curr = "";
	ascc1 = "N";
	ascc2 = "N";
	ascc3 = "N";
	ascc4 = "N";
	ascc5 = "N";
	ascc6 = "N";
	ascc7 = "N";
	ascc8 = "N";
	ascc9 = "N";
	//end of modified by Kavitha.K 21.12.2004
}//for
}else{
	%><script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));</script>
 <%}%>

</table>

<%//out.println("<script>alert('values:::::"+values+"')</script>");%>
<input type=hidden name="oldvalues" id="oldvalues" value="<%=values%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

<!--<input type='hidden' name='nextPrevFlag' id='nextPrevFlag' value='<%=nextPrevFlag%>' >//removed by Kavitha.K 1/10/2005-->
<input type="hidden" name="noOfRecords" id="noOfRecords" value="<%=noOfRecords%>">
<!--<input type='hidden' name='previousRecord' id='previousRecord' value='<%=fm_disp%>' >//
<input type='hidden' name='nextRecord' id='nextRecord' value='<%=to_disp%>' >removed by Kavitha.K1/10/2005-->
<input type='hidden' name='action' id='action' value='' >
<input type="hidden" name="function_id" id="function_id" value="<%=privilege.getFunctionId()%>">

<input type='hidden' name='privilege_ctx_id' id='privilege_ctx_id' value='<%=privilege_ctx_id%>' >
<input type='hidden' name='privilege_ctx' id='privilege_ctx' value='<%= privilege_ctx %>' >
<input type='hidden' name='privilege_id' id='privilege_id' value='<%= privilege_id %>' >
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<!--<input type='hidden' name='privilege_value' id='privilege_value' value='<%= privilege_value %>' >modified by Kavitha.K 21.12.2004-->
<!--<input type='hidden' name='active_yn' id='active_yn' value='' >-->
<input type='hidden' name='resp_id' id='resp_id' value='' >
<input type='hidden' name='reln_id' id='reln_id' value='' >
<input type='hidden' name='appl_user_id' id='appl_user_id' value=''>
<input type='hidden' name='facility_id' id='facility_id' value='<%= facility_id %>'>

<input type='hidden' name='flagnext' id='flagnext' value='0'>
<input type='hidden' name='flagprev' id='flagprev' value='0'>

<% putObjectInBean(bean_id,privilege,request);}catch(Exception e){
	System.out.println("here" + e.getMessage());

}%>
</form>
</body>
</html>

