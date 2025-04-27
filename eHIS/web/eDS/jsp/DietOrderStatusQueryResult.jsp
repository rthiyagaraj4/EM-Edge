<!DOCTYPE html>
<!-- Created for ML-MMOH-CRF-0423 -->
<%@  page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eDS.DSCommonBean,eDS.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% 
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id");
%>
<jsp:useBean id="DSCommonBeanObj" class="eDS.DSCommonBean"/> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eDS/js/DietOrderStatus.js'></script>
<html>
<head>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try{
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String patientClass = request.getParameter("patient_Class");
		String ward_Clinic_code =request.getParameter("ward_Clinic_code");
		String wardClinicDesc=request.getParameter("ward_Clinic_Desc");
		String servDate =request.getParameter("serv_Date");
            			
		//Temporary Variables
		String wardOrClinicTemp="";
		int count=0;			
        	int total_No_Of_Patients=0;
        	int total_Orders=0;
		int total_Orders_temp=0;
        	int pending_orders=0;
		int full_Nbm=0;
		int mac_Only=0; //ML-MMOH-CRF-1826
		int total_Orders_Nbm=0;
		int attendant_Orders=0;
		String diet_Type_temp="";
		String menu_Type_temp="";	//ML-MMOH-CRF-0902
		//Variables Used for Permanent
		String wardOrClinic = "";
		String totalNoOfPatients = "";
		String totalOrders= "";
		String totalOrdersNbm="";
		String pendingorders = "";
		String attendantOrders="";
		String fullNbm="";
		String dietType="";
		String macOnlyCnt=""; //ML-MMOH-CRF-1826
		String menuType="";//ML-MMOH-CRF-0902
		String assignMenuTypeCnt="";//ML-MMOH-CRF-0902
		boolean isMenuType =false;//ML-MMOH-CRF-0902
		boolean isDietTypeCnt =false;//ML-MMOH-CRF-0968
	    	String assignDietTypeCnt="";//Added Against Linked issue 63512
		//Query
		String Attendent_Label_Name="";//ML-MMOH-SCF-0812
		String stafforder_Sql="";
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
		//ML-MMOH-CRF-0968
       		isDietTypeCnt = CommonBean.isSiteSpecific(conn,"DS","DS_NOTIFICATIONS");
		//ML-MMOH-CRF-0968
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null,pstmt1=null;
			
		int maxRecord = 0;
			
		ResultSet rset=null;
		ResultSet rs = null,rs1=null;
		int gracePeriod = 0;
		String strQury = "select grace_period,Attendent_Label_Name from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-SCF-0812
    	try{
    		stmt = conn.prepareStatement(strQury);
    		rset	= stmt.executeQuery();
    		if(rset != null && rset.next()){
    			gracePeriod = rset.getInt(1);
			Attendent_Label_Name = rset.getString(2);//ML-MMOH-SCF-0812
    		}
    	}
    	catch(Exception ee){
			ee.printStackTrace();
			System.err.println("93->DietOrderStatusQueryResult.jsp===>"+ee.getMessage());  		
    	}
	
	try{		
		stafforder_Sql=DSCommonBeanObj.getDietOrderQuery(wardClinicDesc,ward_Clinic_code,patientClass,facility_id,locale,servDate,gracePeriod,isDietTypeCnt);//CRF-968-US2
		
		stmt1=conn.prepareStatement(stafforder_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset = stmt1.executeQuery();
		rset.last();
		maxRecord=rset.getRow();
        if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
	    rset.beforeFirst();

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("110->DietOrderStatusQueryResult.jsp===>"+e.getMessage());
	}
%>
<form name='QueryResult' id='QueryResult'>
<%
	ArrayList<String> wardOrClinic_Value=new ArrayList<String>();
	ArrayList<String> totalNoOfPatients_value=new ArrayList<String>();
	ArrayList<String> totalOrders_value=new ArrayList<String>();
	ArrayList<String> pendingorders_value=new ArrayList<String>();
	ArrayList<String> attendantOrders_value=new ArrayList<String>();
	ArrayList<String> fullNbm_value=new ArrayList<String>();
	ArrayList<String> macOnlyCnt_value=new ArrayList<String>(); //ML-MMOH-CRF-1826
	ArrayList<String> menuType_value=new ArrayList<String>();//ML-MMOH-CRF-0902
	ArrayList<String> dietType_value=new ArrayList<String>();

	String classValue= " ";
    while ( rset.next() )
	{		
	//Code starts here for separation
	count++;	
	
	if(count ==1)
	{
		wardOrClinicTemp=rset.getString(1);//NURSING_UNIT
		wardOrClinic = rset.getString(1);//NURSING_UNIT
		if(wardOrClinic == null)
		wardOrClinic="";	
		if(wardOrClinicTemp == null)
		wardOrClinicTemp="";
	
	    dietType=rset.getString(3);	//DIET_TYPE_DESC
	    totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
		totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
		attendantOrders=rset.getString(6);//Attendant Orders
		fullNbm=rset.getString(7);//FULL_NBM
		//Added for Linked issue-63512 Starts Here               
		assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
		 menuType=rset.getString(9);	//MENU_TYPE_DESC
		 assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
		 macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
		 System.err.println("macOnlyCnt===>"+macOnlyCnt);
	if(dietType == null)
		dietType="";
	
	if(menuType == null)	//ML-MMOH-CRF-0902
		menuType="";
	
		//integer Conversion starts Here
		total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
		total_Orders +=Integer.parseInt(totalOrders);
		total_Orders_temp=Integer.parseInt(totalOrders);
		full_Nbm +=Integer.parseInt(fullNbm);	
		mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
		total_Orders_Nbm =total_Orders+full_Nbm;
		//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
		//To Avoid Negative Values starts here
	if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
		pending_orders =0;
	else
		pending_orders =total_No_Of_Patients-total_Orders_Nbm;
	//To Avoid Negative Values Ends here
	
		attendant_Orders +=Integer.parseInt(attendantOrders);
	//Modified for Linked issue-63512
	if(!dietType.equalsIgnoreCase(""))		
		diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";	
		
	//ML-MMOH-CRF-0902 starts here
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
		System.err.println("menu_Type_temp"+menu_Type_temp);
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here
	
		totalNoOfPatients =""+total_No_Of_Patients;
	    totalOrders= ""+total_Orders;
		totalOrdersNbm=""+total_Orders_Nbm;
		fullNbm=""+full_Nbm;
		macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
	    pendingorders =""+pending_orders;
		dietType=""+diet_Type_temp;
		menuType=""+menu_Type_temp;//ML-MMOH-CRF-0902
		
	//If Only One Record is Available Starts Here
		if(maxRecord == 1)
		{
			wardOrClinic_Value.add(wardOrClinicTemp);
			totalNoOfPatients_value.add(totalNoOfPatients);
			totalOrders_value.add(totalOrdersNbm);
			pendingorders_value.add(pendingorders);
			attendantOrders_value.add(attendantOrders);
			fullNbm_value.add(fullNbm);
			macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
			dietType_value.add(dietType);
			menuType_value.add(menuType);
		}
   //If Only One Record is Available Ends Here
	}
	else
	{
		wardOrClinic = rset.getString(1);//NURSING_UNIT
	if(wardOrClinic == null)
		wardOrClinic="";	
	if(wardOrClinicTemp.equalsIgnoreCase("") || !wardOrClinicTemp.equalsIgnoreCase(wardOrClinic))
	{		
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);
		menuType_value.add(menuType);
		
		//Reset Values starts Here 
		total_No_Of_Patients=0;
		total_Orders=0;
		full_Nbm=0;
		mac_Only=0; //ML-MMOH-CRF-1826
		total_Orders_Nbm=0;
		pending_orders=0;	
		attendant_Orders=0;
		diet_Type_temp="";
		menu_Type_temp="";
		//Reset Values Ends Here 

		wardOrClinicTemp=rset.getString(1);//NURSING_UNIT
		wardOrClinic = rset.getString(1);//NURSING_UNIT
		if(wardOrClinic == null)
			wardOrClinic="";	
		if(wardOrClinicTemp == null)
			wardOrClinicTemp="";

		dietType=rset.getString(3);	//DIET_TYPE_DESC
		totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
		totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
		attendantOrders=rset.getString(6);//Attendant Orders
		fullNbm=rset.getString(7);//FULL_NBM
	   //Added for Linked issue-63512 
		assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
		menuType=rset.getString(9);	//MENU_TYPE_DESC
		assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
		macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
		
	if(dietType == null)
	   dietType="";
 	
	if(menuType == null)	//ML-MMOH-CRF-0902
		menuType="";
		
		//integer Conversion starts Here
		total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
		total_Orders +=Integer.parseInt(totalOrders);
		total_Orders_temp=Integer.parseInt(totalOrders);
		full_Nbm +=Integer.parseInt(fullNbm);	
		mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
		total_Orders_Nbm =total_Orders+full_Nbm;
		//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
		//To Avoid Negative Values starts here
		if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
		pending_orders =0;
	else
		pending_orders =total_No_Of_Patients-total_Orders_Nbm;
		//To Avoid Negative Values Ends here
		attendant_Orders +=Integer.parseInt(attendantOrders);
	
	//Modified for Linked issue-63512 
	if(!dietType.equalsIgnoreCase(""))
		diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";
		
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here	
	 totalNoOfPatients =""+total_No_Of_Patients;
   	 totalOrders= ""+total_Orders;
	 totalOrdersNbm=""+total_Orders_Nbm;
	 fullNbm=""+full_Nbm;
	 macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
   	 pendingorders =""+pending_orders;
  	 dietType=diet_Type_temp;
	 menuType=menu_Type_temp;
	  
	 //For Last Record
	if(count == maxRecord)
	{	
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);		
		menuType_value.add(menuType);				
	}
	//For last Record Ends Here
	}
	else
	{
	
	wardOrClinic = rset.getString(1);//NURSING_UNIT
	if(wardOrClinic == null)
	wardOrClinic="";	
	
    	dietType=rset.getString(3);	//DIET_TYPE_DESC
	totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
	totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
	attendantOrders=rset.getString(6);//Attendant Orders
	fullNbm=rset.getString(7);//FULL_NBM	
	//Added for Linked issue-63512        	
	assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
	menuType=rset.getString(9);	//MENU_TYPE_DESC
	assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
	macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
	
	if(dietType == null)
	dietType="";
	
	if(menuType == null)	//ML-MMOH-CRF-0902
	menuType="";
	
	//integer Conversion starts Here
	total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
	total_Orders +=Integer.parseInt(totalOrders);
	total_Orders_temp=Integer.parseInt(totalOrders);
	full_Nbm +=Integer.parseInt(fullNbm);	
	mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
	total_Orders_Nbm =total_Orders+full_Nbm;
	//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
	
	//To Avoid Negative Values starts here
	if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
	pending_orders =0;
	else
	pending_orders =total_No_Of_Patients-total_Orders_Nbm;
	//To Avoid Negative Values Ends here
	attendant_Orders +=Integer.parseInt(attendantOrders);
	
	//Modified for Linked issue-63512 
	if(!dietType.equalsIgnoreCase(""))
       diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here
	
	 totalNoOfPatients =""+total_No_Of_Patients;
         totalOrders= ""+total_Orders;
	 totalOrdersNbm=""+total_Orders_Nbm;
         fullNbm=""+full_Nbm;
         macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
         pendingorders =""+pending_orders;
	
	dietType=diet_Type_temp;
	menuType=menu_Type_temp;	//ML-MMOH-CRF-0902

	//For Last Record
	if(count == maxRecord)
	{	
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);		
		menuType_value.add(menuType);	//ML-MMOH-CRF-0902	
	}
	//For last Record Ends Here
	}	
	}//Count!=1 else 
	//Code Ends here for separation
}   
%>
<P>
<table align='right'>
<tr>
<td>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eDS/jsp/DietOrderStatusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&patient_Class="+patientClass+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+wardClinicDesc+"&serv_Date="+servDate+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > wardOrClinic_Value.size() ) )
		out.println("<A HREF='../../eDS/jsp/DietOrderStatusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&patient_Class="+patientClass+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+wardClinicDesc+"&serv_Date="+servDate+ "'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th>
					<fmt:message key="eDS.WardOrClinicDesc.Label" bundle="${ds_labels}"/>
				</th>
				<th>
					<fmt:message key="eDS.TotalNoOfPatients.Label" bundle="${ds_labels}"/>
				</th>
				<th>
					<fmt:message key="eDS.TotalOrders.Label" bundle="${ds_labels}"/>
				</th>
				<th>
					<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>
				</th>
			   <th>
			   <!-- ML-MMOH-SCF-0812 -->
					<%=Attendent_Label_Name%>
					<fmt:message key="Common.Orders.label" bundle="${common_labels}"/>
					<!--<fmt:message key="eDS.AttendantOrders.Label" bundle="${ds_labels}"/>-->
				<!-- ML-MMOH-SCF-0812 -->
				</th>
				<th>
					<fmt:message key="eDS.FullNBM.Label" bundle="${ds_labels}"/>
				</th>
				<!-- ML-MMOH-CRF-0902 -->
				<%if(isMenuType) { %>
				<th>
					<fmt:message key="eDS.MenuType.Label" bundle="${ds_labels}"/>
				</th>
				<%}%>
				<!-- ML-MMOH-CRF-0902 -->
				<th>
					<fmt:message key="eDS.DietType.Label" bundle="${ds_labels}"/>
				</th>
			</tr>
<%
    int m=0;//Count to Manage Next and Previous

	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
    	m++;
		classValue= " ";
   while(m<wardOrClinic_Value.size() && m<end)
{
	if ( m % 2 == 0 )
		classValue = "QRYEVEN" ;  
			else
		classValue = "QRYODD" ;

		out.println("<td class='" + classValue+"' nowrap>"+wardOrClinic_Value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+totalNoOfPatients_value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+totalOrders_value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+pendingorders_value.get(m)+"</td>");
		if(wardClinicDesc.equalsIgnoreCase("Nursing Unit"))	
		{
			out.println("<td class='" + classValue+"' nowrap>"+attendantOrders_value.get(m)+"</td>");
			out.println("<td class='" + classValue+"' nowrap>"+fullNbm_value.get(m)+"</td>");
		}
		else
		{
			out.println("<td class='" + classValue+"' nowrap>NA</td>");
			out.println("<td class='" + classValue+"' nowrap>NA</td>");		
		}
		
		if(isMenuType){
		
		String menuType_arr[]=menuType_value.get(m).split(",");
		out.println("<td class='" + classValue+"' nowrap>");
	
		for(int y=0;y<menuType_arr.length;y++)
		{
		if(y!=0)
		{
			out.print(",<br>");
			out.print(menuType_arr[y]);
		}
		else
		{
		if(menuType_arr[y].equalsIgnoreCase(""))
			out.print("<br>");
		else
			out.print(menuType_arr[y]);
		}
		}
		out.println("</td>");
		
		}
	
		String dietType_arr[]=dietType_value.get(m).split(",");
		out.println("<td class='" + classValue+"' nowrap>");
			
	
		for(int y=0;y<dietType_arr.length;y++)
		{
		if(y!=0)
		{
			out.print(",<br>");
			out.print(dietType_arr[y]);
		}
		else
		{
		if(dietType_arr[y].equalsIgnoreCase(""))
			out.print("<br>");
		else
			out.print(dietType_arr[y]);
		}
		}
		out.println("</td>");
		out.println("</tr>");
		m++;
		}	
%>
</td></tr>
</table>
</center>
<br><center>
<%
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
    e.printStackTrace();
    System.err.println("452->DietOrderStatusQueryResult.jsp===>"+e.getMessage());
}
%>
</center>
</form>
</body>
</html>

