<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- UserForReportingResult -->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="eOR.*, java.sql.*,eOR.Common.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%!int row_count=0;int row_count1=0;%>
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
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../js/UserForReportingOrderable.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%  
	//String classValue  = "",All="", key="",status="E",readOnly = "";
	String tblrow_id = "", checkValue="";
	String disabled = "",  valid="";
	String associate_yn="";
	String catalog_desc="";
	//boolean flag=false;
	//boolean temp=false;

	HashMap htListRecord= new HashMap();
	//HashMap tempRecordChk= new HashMap();
	
	HashMap select_All = new HashMap();
	boolean isAllPresent = false;
	Vector recList = new Vector();
	
	String   code="";
	//String status_db = "";
	//String mode="1";
	//String checkValue1="";
	
	boolean stats = false;
	String update_val = "";
	//boolean alteredRecord = false;
	//alteredDBRecord = false;

	String index= request.getParameter("index");
	String tabVal= request.getParameter("tabVal");
	String ord_category_value = request.getParameter("ord_category_value");
	String ord_type_value = request.getParameter("ord_type_value");

	if (index == null || index.equals("null")  ) index=""; else index = index.trim();
	if (tabVal == null || tabVal.equals("null")  ) tabVal=""; else tabVal = tabVal.trim();
	if (ord_category_value == null || ord_category_value.equals("null")  ) ord_category_value=""; else ord_category_value = ord_category_value.trim();
	if (ord_type_value == null || ord_type_value.equals("null")  ) ord_type_value=""; else ord_type_value = ord_type_value.trim();

	String bean_id = "Or_UserForReporting" ;
	String bean_name = "eOR.UserForReporting";
	String slClassValue = "";

	eOR.Common.MultiRecordBean MultiRecordSet= new eOR.Common.MultiRecordBean();

	UserForReporting bean = (UserForReporting)getBeanObject( bean_id, bean_name , request ) ;
	MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
	
	row_count			=  MultiRecordSet.getSize("DB");
//	out.println("<script>alert("+row_count+");</script>");
	if( row_count == 0 )
	{//out.println("<script>alert('hi');</script>");
		select_All.put("status","N");
		select_All.put("catalog_desc","All");
		select_All.put("valid","N");
		select_All.put("code","*All");
		select_All.put("associate_yn","N");
		MultiRecordSet.putObject(select_All);
	//	boolean ret = MultiRecordSet.putObject(select_All);
	//	System.err.println("Rec Inserted into MultiRecBean   " + ret );

		select_All = null;
	}
	else
	{
		for(int i=0;i<MultiRecordSet.getSize("DB");i++)
		{
			htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
			code	=	(String)	htListRecord.get("code");
			//	out.println("<script>alert(' Code :  "+code+"')</script>");
			if(!code.equalsIgnoreCase("*All"))
			{
				isAllPresent = false;
			
			}
			else
			{
				isAllPresent = true;
				break;
			}
		}
		if( isAllPresent == false)
		{
			for(int i=0;i<MultiRecordSet.getSize("DB");i++)
			{
				htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				if(htListRecord != null)
				{
					recList.add(i,htListRecord);
				}
				//MultiRecordSet.removeObject(i);
			//	out.println("<script>alert(' htListRecord :  "+htListRecord+"')</script>");
			}
			//boolean x = MultiRecordSet.clearDBRec();
			MultiRecordSet.clearDBRec();
			
			select_All.put("status","N");
			select_All.put("catalog_desc","All");
			select_All.put("valid","N");
			select_All.put("code","*All");
			select_All.put("associate_yn","N");
			MultiRecordSet.putObject(select_All);
			//boolean ret = MultiRecordSet.putObject(select_All);
			//System.err.println("Rec Inserted into MultiRecBean   " + ret );
			select_All = null;
			//boolean ret1 = false;
			for(int i=0;i<recList.size();i++)
			{
				 MultiRecordSet.putObject((HashMap )recList.get(i));
				//ret1 = MultiRecordSet.putObject((HashMap )recList.get(i));
			}
		}else if(isAllPresent == true)
			{
			for(int i=0;i<MultiRecordSet.getSize("DB");i++)
			{
				htListRecord	=	(java.util.HashMap)	MultiRecordSet.getObject(i);
				if(htListRecord != null)
				{
					recList.add(i,htListRecord);
				}
				//MultiRecordSet.removeObject(i);
			}
			//boolean x = MultiRecordSet.clearDBRec();
			MultiRecordSet.clearDBRec();
								
			for(int i=0;i<recList.size();i++)
			{
				MultiRecordSet.putObject((HashMap )recList.get(i));
				//boolean	ret = MultiRecordSet.putObject((HashMap )recList.get(i));
			}	
		}row_count1			=  MultiRecordSet.getSize("DB");
	}
	
if(tabVal.equals("S")){
	MultiRecordSet	= (eOR.Common.MultiRecordBean)bean.getCatalogDesc(index,ord_category_value,ord_type_value);
		
	row_count			=	MultiRecordSet.getSize("SELECT");
//	out.println("<script>alert("+row_count+");</script>");
	if ( row_count	== 0){
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
	}
}else if(tabVal.equals("A")){
		MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();
		row_count1			=  MultiRecordSet.getSize("DB");
//		out.println("<script>alert('row_count :"+row_count+"');</script>");
//		out.println("<script>alert('row_count1 :"+row_count1+"');</script>");
		
}				
/*ArrayList CatalogDesc = new ArrayList();
 CatalogDesc		=  bean.getCatalogDesc(index,ord_category_value,ord_type_value);

*/else{ 
MultiRecordSet	 =(eOR.Common.MultiRecordBean)bean.getBean();
		for(int j=0; j<row_count; j++){
				update_val = request.getParameter("select_yn"+j);
			if(update_val == null || update_val.equals("null")){
				update_val = "N";
			}
			if(tabVal.equals("S")){
				//alteredRecord = MultiRecordSet.setBeanValue(j,update_val);
				MultiRecordSet.setBeanValue(j,update_val);
			}else if(tabVal.equals("A")){
				//alteredDBRecord = MultiRecordSet.setDBBeanValue(j,update_val);
				MultiRecordSet.setDBBeanValue(j,update_val);
			}
		}
}
%>
	<form name="formUserForReportingResult" id="formUserForReportingResult"> 
	<table class='grid' width='100%'>
	<td class=' COLUMNHEADER' width='70%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<td class=' COLUMNHEADER' width='30%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<%
	try{
		if(tabVal.equals("S")){

			String slClassValueTmp=null;
				
		for( int i=0 ; i< row_count ; i++ ) {
				if(i % 2 == 0){
					slClassValue = "gridData";
				}else{
					slClassValue = "gridData";
				}

		slClassValueTmp = slClassValue;
		htListRecord	=	(java.util.HashMap)	MultiRecordSet.getListObject(i);

		code				=	(String)	htListRecord.get("code");
		valid				=	(String)	htListRecord.get("valid");
		catalog_desc		=	(String)	htListRecord.get("catalog_desc");
		associate_yn		=	(String)	htListRecord.get("associate_yn");


		if(associate_yn == null || associate_yn.equals("null"))associate_yn="N";
		stats			=	MultiRecordSet.containsObject(code);
			if(stats){
				valid = MultiRecordSet.getValidKey(code);
			}

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
			 tblrow_id	=	"tblrow_id"+i;
//if(!code.equals("*All")){		
%>

<tr id='<%=tblrow_id%>'> 

	<td width='70%' class='<%=slClassValue%>' name='catalog_desc'<%=i%>><font size=2><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%>
	 <%
		slClassValue = slClassValueTmp;
	%> 
	<input type='hidden'  name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=code%>"></td> 

	<td width='30%' class='<%=slClassValue%>' align='center'><input type='checkbox'	name='select_yn<%=i%>' id='select_yn<%=i%>'<%=checkValue%> <%=disabled%> value='Y' ></td>
</tr>
<%}
//	}
	row_count=row_count;	
	}else if(tabVal.equals("A")){
	
	//	if ( row_count	== 0 || isAllPresent == false){%>
		
		  <!-- <tr>
			<td width='70%' class='QRYODD' name='all_val'><font size=2>All
			 <input type='hidden'  name='all_value' id='all_value' value="*ALL"></td></td>
		<td width='30%' class='QRYODD' align='center'><input type='checkbox' name='all' id='all' value='N' ></td>
		</tr>   --> 
	<%//}
	for( int i=0 ; i< row_count ; i++ ) {
	/*	tempRecordChk =	(java.util.HashMap)MultiRecordSet.getObject(i);
		String code_all=(String)tempRecordChk.get("code");
		if(code_all.trim().equalsIgnoreCase("*All"))
			temp = true;*/
	}
		String slClassValueTmp=null;
	for( int i=0 ; i< row_count1 ; i++ ) {
		if(i % 2 == 0){
			slClassValue = "gridData";
		}else{
			slClassValue = "gridData";
		}
		slClassValueTmp = slClassValue;
				
		htListRecord=(java.util.HashMap)MultiRecordSet.getObject(i);
		code				=	(String)	htListRecord.get("code");
		valid				=	(String)	htListRecord.get("valid");
		associate_yn		=	(String)	htListRecord.get("associate_yn");
		catalog_desc		=	(String)	htListRecord.get("catalog_desc");
		//status_db			=	(String)	htListRecord.get("status");
		
//out.println("<script>alert('code:"+code+"-valid:"+valid+"-associate_yn:"+associate_yn+"-catalog_desc-"+catalog_desc+"--');</script>");
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
			
	//  if( flag == false && isAllPresent == false){%> 
			
	 <!--  <tr id='<%=tblrow_id%>'>
		<td width='70%' class='QRYODD' name='all_val'><font size=2>All
		 <input type='hidden'  name='all_value' id='all_value' value="*ALL"></td>
		<td width='30%' class='QRYODD' align='center'><input type='checkbox' name='all' id='all' value='N'  ></td>
	</tr>  -->
		 <%
	//		isAllPresent=true;
	//	} %>
							
	<tr id='<%=tblrow_id%>'>
		<%if(valid.equals("Y")){%>
		<td width='70%' class='<%=slClassValue%>'name='catalog_desc<%=i%>'><font size=2><b><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%></b>
		<%
			slClassValue = slClassValueTmp;
		%> 
		<input type='hidden'  name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=code%>"> </td> 
		<%}else {%>	
			<td width='70%' class='<%=slClassValue%>'name='catalog_desc<%=i%>'><font size=2><%=((catalog_desc.equals(""))?"&nbsp;":catalog_desc)%>
		<%
			slClassValue = slClassValueTmp;
		%> 
		<input type='hidden'  name='catalog_code<%=i%>' id='catalog_code<%=i%>' value="<%=code%>"> </td> 
		<%}%>
		<td width='30%' class='<%=slClassValue%>' align='center'><input type='checkbox'	name='select_yn<%=i%>' id='select_yn<%=i%>' value='Y' <%=checkValue%> ></td>
	</tr>
			
			
<%}//end of for
	row_count=row_count1;}//end of else if
		}catch(Exception e){
			System.out.println("Exception@2jsp: "+e);
		}%>
		
</table>
		<input type='hidden' name='row_count' id='row_count' value="<%=row_count%>">
		<input type="hidden" name='tabVal' id='tabVal' value="<%=tabVal%>">
		<input type="hidden" name='bean_id' id='bean_id' value="<%=bean_id%>">
		<input type="hidden" name='bean_name' id='bean_name' value="<%=bean_name%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
	
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

