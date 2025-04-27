<!DOCTYPE html>
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eDS.DSCommonBean,eDS.*" %>
<%@  page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE");
   String facility_id = (String)session.getAttribute("facility_id");%>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/MealCensus.js'></script>
<HTML>
<head>
<%
String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")) ?
	(String) session.getAttribute("PREFERRED_STYLE"):"IeStyle.css" ;
	if(sStyle==null)sStyle="IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String kitchenCode = checkForNull(request.getParameter("kitchen_code"));
	String wardCode =checkForNull(request.getParameter("ward_code"));
	String servDate =checkForNull(request.getParameter("serv_Date"));
	String servingDate	=  com.ehis.util.DateUtils.convertDate(servDate,"DMY", locale, "en");
	//Added Against ML-MMOH-CRF-1063 Starts Here
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String anchorID= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	System.err.println("reOrder-->"+reOrder+"  orderBy-->"+orderBy+"  anchorID-->"+anchorID);
	System.err.println("kitchenCode-->"+kitchenCode+"--->wardCode-->"+wardCode+"--->servDate-->"+servDate);
	//Added Against ML-MMOH-CRF-1063 Ends Here
	String encounter_Id = "";
	String assign_Bed_Num = "";
	String patient_Id= "";
	String patient_Name = "";
	String meal_Type = "";
	String mealtype_desc = "";
	String diettype_desc= "";
	String mealclass_desc = "";
	String menu_desc = "";
	boolean isMenuType =false;//ML-MMOH-CRF-0902
	//ML-MMOH-CRF-0902
	String menu_Type_Desc ="";
	//ML-MMOH-CRF-0902
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 14 ;
    else
        end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);
	//ML-MMOH-CRF-0902
        isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
	//ML-MMOH-CRF-0902
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;

	try{
		System.err.println("72- orderBy->"+orderBy+"wardCode==>"+wardCode);
		String strsql = "select count(*) total "+
						"from Ds_Epsd_Meal_Plan_Hdr mealplanhdr,Ds_Meal_Type_Lang_Vw mealType,Ds_Diet_Type_Lang_Vw dietType,"+
						"Ds_Meal_Class_Lang_Vw mealClass,Ds_Menu_Lang_Vw menu,pr_encounter  prencounter,mp_patient mpatient "+
						"where mealplanhdr.meal_Type = mealType.meal_Type and mealplanhdr.diet_Type = dietType.diet_Type "+
						"and mealplanhdr.meal_Class = mealClass.meal_Class and mealplanhdr.menu_Code = menu.menu_Code "+
						"and mealplanhdr.operating_facility_Id  = '"+facility_id+"' and mealplanhdr.kitchen_Code  = '"+kitchenCode+"' "+
						"and mpatient.patient_id =   prencounter.patient_id and prencounter.encounter_id = mealplanhdr.encounter_id ";//57812
												
						System.err.println("80- wardCode->"+wardCode);
						if(wardCode.equals("") || wardCode==null){
						strsql+="and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}else{
						strsql+="and prencounter.ASSIGN_CARE_LOCN_CODE = '"+wardCode+"' "+						
						"and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						System.err.println("90- ELSE strsql->"+strsql);
						}//57812

						
		String strsql1 = "select mealplanhdr.encounter_Id, prencounter.assign_Bed_Num, prencounter.patient_Id, "+
						"mpatient.patient_Name,mealplanhdr.meal_Type,mealType.short_Desc mealtype_desc, "+
						"dietType.short_Desc diettype_desc, mealClass.short_Desc mealclass_desc,menu.short_Desc menu_desc, "+
						"ds_get_desc.ds_menu_type(menu_type,'"+locale+"','2') menu_type_desc "+
						"from Ds_Epsd_Meal_Plan_Hdr mealplanhdr,Ds_Meal_Type_Lang_Vw mealType,Ds_Diet_Type_Lang_Vw dietType,"+
						"Ds_Meal_Class_Lang_Vw mealClass,Ds_Menu_Lang_Vw menu,pr_encounter  prencounter,mp_patient mpatient "+
						"where mealplanhdr.meal_Type = mealType.meal_Type and mealplanhdr.diet_Type = dietType.diet_Type "+
						"and mealplanhdr.meal_Class = mealClass.meal_Class and mealplanhdr.menu_Code = menu.menu_Code "+
						"and mealplanhdr.operating_facility_Id  = '"+facility_id+"' and mealplanhdr.kitchen_Code  = '"+kitchenCode+"' "+
						"and mpatient.patient_id =   prencounter.patient_id and prencounter.encounter_id = mealplanhdr.encounter_id ";
						//57812 & ML-MMOH-CRF-0902
						if(wardCode.equals("") || wardCode==null){
						strsql1+="and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}else{
						strsql1+="and prencounter.ASSIGN_CARE_LOCN_CODE = '"+wardCode+"' "+
						"and to_char(mealplanhdr.serving_Date,'dd/mm/yyyy') = '"+servingDate+"' "+
						"and mealType.language_Id = '"+locale+"' and dietType.language_Id = '"+locale+"' "+
						"and mealClass.language_Id = '"+locale+"' and menu.language_Id = '"+locale+"' ";
						}//57812
						
			//Added Against ML-MMOH-CRF-1063 Starts Here
			if (orderBy.equals("PI")){
					if(reOrder.equals("1")){
							strsql1= strsql1+" order by patient_id desc ";
							
					}else{
							strsql1 =strsql1+" order by patient_id  ";
						
					}
			   }else if (orderBy.equals("PN")){
					if(reOrder.equals("1")){
						     strsql1 =strsql1+" order by lower(trim(patient_Name)) desc ";
					}else{
							strsql1= strsql1+" order by lower(trim(patient_Name)) ";
					}
			   }else if (orderBy.equals("BD")){
					if(reOrder.equals("1")){
							 strsql1 =strsql1+" order by assign_Bed_Num desc ";
					}else{
							 strsql1= strsql1+" order by assign_Bed_Num ";
					}
			  }else if (orderBy.equals("MT")){
					if(reOrder.equals("1")){
							 strsql1 =strsql1+" order by meal_Type desc ";
					}else{
							 strsql1 =strsql1+" order by meal_Type ";//Modified for ICN-64265
					}
			  }else if(orderBy.equals("ME")){
					if(isMenuType){
				if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by menu_type_desc desc ";
					}else{
						   strsql1 =strsql1+" order by menu_type_desc ";
				    }
					}
			  }
			  else if(orderBy.equals("DT")){
				       if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by diettype_desc desc ";
					}else{
						   strsql1 =strsql1+" order by diettype_desc ";						  
					}
			  } 
			  else if(orderBy.equals("MC")){
		              if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by mealclass_desc desc ";
					}else{
						   strsql1 =strsql1+" order by mealclass_desc ";
					}
			  }
			  else if(orderBy.equals("MN")){
		              if(reOrder.equals("1")){
						   strsql1 =strsql1+" order by menu_desc desc ";
					}else{
						   strsql1 =strsql1+" order by menu_desc ";
					}
			  }else
			  {
				   System.err.println("132 orderBy==>"+orderBy);
				   strsql1 =strsql1+" order by prencounter.assign_Bed_Num,prencounter.patient_id";
			  }
			//Added Against ML-MMOH-CRF-1063 Ends Here						
		// System.out.println("SQL: " + strsql) ;
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");

		if(maxRecord == 0){
			//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");//GDOH-SCF-0160
			
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	
	
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<!-- Modified Against ML-MMOH-CRF-1063 Starts Here -->
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eDS/jsp/MealCensusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&kitchen_code="+kitchenCode+"&ward_code="+wardCode+"&serv_Date="+servDate +"&reOrder="+reOrder +"&anchorID="+anchorID +"&orderBy="+orderBy +"'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eDS/jsp/MealCensusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&kitchen_code="+kitchenCode+"&ward_code="+wardCode+"&serv_Date="+servDate +"&reOrder="+reOrder +"&anchorID="+anchorID + "&orderBy="+orderBy +"'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
<!-- Modified Against ML-MMOH-CRF-1063 Ends Here -->
</td>
</tr>
</table>
<br><br>
</p>
<!-- Modified Against ML-MMOH-CRF-1063 Starts Here -->
<table id='PatCriteriaTbl' border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><a id = 'm01' href="javascript:callOrderBy('PI','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');"onclick='changeColor(this);' style='color:white'>
					<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='patId' value="m01"></span>
				</div>
				</th>
				<th><a id = 'm02' href="javascript:callOrderBy('PN','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='patNamId' value="m02"></span>
				</div>
				</th>
				<th><a id = 'm03' href="javascript:callOrderBy('BD','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="Common.bedno.label" bundle="${common_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='bedId' value="m03"></span>
				</div>
				</th>
				<th><a id = 'm04' href="javascript:callOrderBy('MT','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="eOT.MealType.Label" bundle="${ot_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='mealTypeId' value="m04"></span>
				</div>
				</th>
				<!-- ML-MMOH-CRF-0902 -->
				<%if(isMenuType) { %>
				<th><a id = 'm05' href="javascript:callOrderBy('ME','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='menuTypeId' value="m05"></span>
				</div>
				</th>
				<%}%>
				<!-- ML-MMOH-CRF-0902 -->
				<th><a id = 'm06' href="javascript:callOrderBy('DT','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="eOT.DietType.Label" bundle="${ot_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='dietTypeId' value="m06"></span>
				</div>
				</th>
				<th><a id = 'm07' href="javascript:callOrderBy('MC','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="eOT.MealClass.Label" bundle="${ot_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='mealClsId' value="m07"></span>
				</div>
				</th>
				<th><a id = 'm08' href="javascript:callOrderBy('MN','<%=kitchenCode%>','<%=wardCode%>','<%=servDate%>');" onclick='changeColor(this);' style='color:white'>
					<fmt:message key="eOT.Menu.Label" bundle="${ot_labels}"/></a>
				<div style='vertical-align:middle; display:inline;'>
				<span id='menuId' value="m08"></span>
				</div>
				</th>
			<!-- Modified Against ML-MMOH-CRF-1063 Ends Here -->
				<th></th>
			</tr>
<%
    if ( start != 1 )
    for( int j=1; j<start; i++,j++ )
    rset.next() ;
	String classValue= " ";
	int rowId=1; //IN:39948 
    while ( rset.next() && i<=end  )
	{
		if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;  
        else
            classValue = "QRYODD" ;  
    out.println("<tr>");

   encounter_Id = rset.getString("encounter_Id");

	if(rset.getString("assign_Bed_Num") ==  null){
		assign_Bed_Num = "&nbsp;";
	}
	else assign_Bed_Num=rset.getString("assign_Bed_Num");
    patient_Id= rset.getString("patient_Id");
    patient_Name = rset.getString("patient_Name");
    meal_Type = rset.getString("meal_Type");
    mealtype_desc = rset.getString("mealtype_desc");
    diettype_desc= rset.getString("diettype_desc");
    mealclass_desc = rset.getString("mealclass_desc");
    menu_desc = rset.getString("menu_desc");
	//ML-MMOH-CRF-0902 starts here
	if(isMenuType){
    		menu_Type_Desc = checkForNull(rset.getString("menu_type_desc"));
	}
	else{
    		menu_Type_Desc = "";
	}
	//ML-MMOH-CRF-0902 ends here
    out.println("<td class='" + classValue+"' nowrap>"+patient_Id+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+patient_Name+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+assign_Bed_Num+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealtype_desc+"</td>");	
	if(isMenuType){ 
	out.println("<td class='" + classValue+"' nowrap>"+menu_Type_Desc+"&nbsp;</td>");//ML-MMOH-CRF-0902	
	}
    out.println("<td class='" + classValue+"' nowrap>"+diettype_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+mealclass_desc+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+menu_desc+"</td>");%>
	<input type="hidden" name="encounterHdn<%=rowId%>" id="encounterHdn<%=rowId%>" value="<%=encounter_Id%>">
	<input type="hidden" name="mealTypeHdn<%=rowId%>" id="mealTypeHdn<%=rowId%>" value="<%=meal_Type%>">
	<input type="hidden" name="servingDate<%=rowId%>" id="servingDate<%=rowId%>" value="<%=servDate%>">
	<!--Added Against ML-MMOH-CRF-1063 Starts Here -->
	<input type="hidden" name="isMenuType<%=rowId%>" id="isMenuType<%=rowId%>" value="<%=isMenuType%>">
	<input type="hidden" name="reOrder" id="reOrder" id ="reOrder" value="<%=reOrder%>">
	<input type="hidden" name="orderBy" id="orderBy" id= "orderBy" value="<%=orderBy%>">
	<input type="hidden" name="anchorID" id="anchorID" id ="anchorID" value="<%=anchorID%>">
	<input type="hidden" name="kitchenCode" id="kitchenCode" id ="kitchenCode" value="<%=kitchenCode%>">
	<input type="hidden" name="servDate" id="servDate" id ="servDate" value="<%=servDate%>">
	<!--Added Against ML-MMOH-CRF-1063 Ends Here -->
    <td class='<%=classValue%>' nowrap>
	<input type='button' value='+' name='detail_Record_<%=rowId%>' id='detail_Record_<%=rowId%>' onclick='showDetailRecord("<%=rowId %>");'></td>
	<%
	out.println("</tr>");
	rowId++;
	i++;
} 
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	if(conn!=null)	ConnectionManager.returnConnection(conn,request);
}catch(Exception e){
	e.printStackTrace();
	System.err.println("236->MealCensusQueryResult.jsp===>"+e.getMessage());
}
%>
</table>
</center>
</form>
<!--Added Against ML-MMOH-CRF-1063 Starts Here -->
<script>
		var anchorID = '<%= anchorID %>' + '';
        var str = anchorID !== '' ? document.getElementById('PatCriteriaTbl').querySelector("#"+anchorID):'';
		var con = str.toString();
		var ch1 = con.split(",");
		var res = ch1[0].substring(24,26);
		var isMenuType = document.forms[0].isMenuType1 !== undefined ? document.forms[0].isMenuType1.value : "false";
		
if(isMenuType=="true" && anchorID !== ''){
	  if('<%=reOrder%>'=='1')
	  {   
       var ch = "";
       ch = document.getElementById('PatCriteriaTbl').querySelector("#"+anchorID).style.color= 'pink';
		if(res == "PI"){		   
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
		}else if(res == "PN"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
			
		}else if (res == "BD"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";         
		}else if (res == "MT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";           
		}
		else if (res == "ME"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";   
		}else if (res == "DT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MC"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MN"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";            
		}
	}
	else if('<%=reOrder%>'=='2')
	{		
		ch = document.getElementById('PatCriteriaTbl').querySelector("#"+anchorID).style.color='yellow';
		if(res == "PI"){		   
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
		}else if(res == "PN"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
			
		}else if (res == "BD"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";         
		}else if (res == "MT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";           
		}else if (res == "ME"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";   
		}else if (res == "DT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MC"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MN"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
		}
	}	
}
else{
	  if('<%=reOrder%>'=='1')
	  {   
       var ch = "";
       ch = document.getElementById('PatCriteriaTbl').querySelector("#" + anchorID).style.color= 'pink';
		if(res == "PI"){		   
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
		}else if(res == "PN"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
			
		}else if (res == "BD"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";         
		}else if (res == "MT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";           
		}else if (res == "DT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MC"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MN"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " "+"<img src=../../eDS/css/Maxtomin.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";            
		}
	}
	else if('<%=reOrder%>'=='2')
	{		
		ch = document.getElementById('PatCriteriaTbl').querySelector("#"+anchorID).style.color='yellow';
		if(res == "PI"){		   
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
		}else if(res == "PN"){	
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";
			
		}else if (res == "BD"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";         
		}else if (res == "MT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";           
		}else if (res == "DT"){			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MC"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " ";            
		}else if (res == "MN"){
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#menuId").innerHTML= " "+"<img src=../../eDS/css/Mintomax.PNG></img>";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patId").innerHTML= " ";			
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#patNamId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#bedId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#dietTypeId").innerHTML= " ";
			ch.innerHTML =document.getElementById('PatCriteriaTbl').querySelector("#mealClsId").innerHTML= " ";
		}
	}	
}
</script>
<!--Added Against ML-MMOH-CRF-1063 Ends Here -->
</BODY>
</HTML>

