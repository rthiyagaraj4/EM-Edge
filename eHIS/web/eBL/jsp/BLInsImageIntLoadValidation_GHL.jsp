<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"
	import="java.sql.*,java.util.Hashtable,java.util.ArrayList,java.util.HashMap,java.util.Enumeration,eBL.Common.*,eBL.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />
<%! static   String  changBlg="";
//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
	static   String  changCustGrpCode=""; 
	static   String  changCustCode=""; 
	//Ended by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020 
%>
<%
	String beanId = "bl_blinsuranceimagebean";
	String beanName = "eBL.BLInsuranceImageBean";
	BLInsuranceImageBean bean = (BLInsuranceImageBean) getBeanObject(beanId, beanName, request);
	//bean.clearBean();	//Gomu
	String params = request.getQueryString();
	String strPatientId = request.getParameter("patient_id");
	/* String checked_row = "";
	int checked_rows = -1;  
	*/
	
	String checked_row = ""; //May 12 2020
	//checked_row=(checked_row==null)?"":checked_row;
	int checked_rows =0;
		
	String strBillingGroup=request.getParameter("billingGroup");  // Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 changes 
	
	String calling_module_id=request.getParameter("calling_module_id"); // Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 changes 
	
	boolean siteSpecUploadDocAll=false;

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs =null;
	String index="";
	int rowCount=0;
	String stmind="";
	boolean flage=false;
	if(changBlg.equals(""))
	changBlg= strBillingGroup;
	try
	{
		conn=ConnectionManager.getConnection();	
	// Added 03-feb-20 palaniNarayanan/GHL-CRF-0550 changes - start--->	
	
	try{

		String sql3 = "select SETTLEMENT_IND from BL_BLNG_GRP where BLNG_GRP_ID='"+strBillingGroup+"'";		
		pstmt=conn.prepareStatement(sql3);	
		rs = pstmt.executeQuery();
		while(rs.next())
		{			
			stmind=  rs.getString(1);	
		}	
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs!=null)  rs.close();
				if (pstmt != null){
					pstmt.close();}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
	String payerGroupCode1 = "";
	String payerCode1 = "";
	if (stmind.equals("R")) {	
		 payerGroupCode1 = request.getParameter("cust_group_code");
		 payerCode1 = request.getParameter("cust_code");
		if(changCustGrpCode.equals(""))
			changCustGrpCode= payerGroupCode1;
		if(changCustCode.equals(""))
			changCustCode= payerCode1;
	}
	//Ended by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
	if(changBlg.equals(strBillingGroup))
		{
			//flage=false; //Commented by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
			//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
			if ("R".equals(stmind))
				{	
					if(changCustGrpCode.equals(payerGroupCode1) && changCustCode.equals(payerCode1))
					{
						flage=false;
					}else {
						flage=true;			
						bean.clearBean();
					}
				 }else {
					 flage=false;
				 }
		//Ended by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
		}else
			{
				flage=true;
				//BLInsuranceImageBean bean= new BLInsuranceImageBean();
				//hasInsuranceImageValues.clear();
				bean.clearBean();
				changBlg= strBillingGroup;//07-05-2020
			}	
	if(stmind.equals("X"))
	{
			//conn=ConnectionManager.getConnection();	
		siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550

		checked_row = request.getParameter("checked_row");
		checked_row=(checked_row==null)?"":checked_row;
		checked_rows =Integer.parseInt(checked_row);
		int row = checked_rows; 	
	if(siteSpecUploadDocAll)
	{
		try {
		//07-May-20 To make IE Compatibility Logics
		/*request.setCharacterEncoding("UTF-8");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");*/	
		//07-May-20 To make IE Compatibility Logics
		HashMap<String, String> hash = new HashMap<String, String>();
		//07-May-20 To make IE Compatibility Logics	
		String[] tempString = new String[4];
		
		java.util.Enumeration params1 = request.getParameterNames();
		while(params1.hasMoreElements()) {
		String paramName = (String) params1.nextElement();
		//07-May-20 To make IE Compatibility Logics
		paramName=paramName.replace("amp;","");
		String paramValue = request.getParameter(paramName);
			if(null!=paramName){
				hash.put(paramName,paramValue);
			}
			//07-May-20 To make IE Compatibility Logics
		}
		 int totalRecords= (hash.get("total_records")==null) ? 0:Integer.parseInt((String)hash.get("total_records"));		
			/* if(totalRecords=="0")
			bean.clearBean(); */	
 	/*Karthik added the below code to handle Session Record retain - starts */		
		int hashsize=bean.getInsuranceImageValues().size();//08-05-2020
		
		if((!checked_row.equals(null)||!checked_row.equals("")) && (hashsize!=0))
		{
			//bean.hasInsuranceImageValues.clear();//11-May-20
		}
 
		HashMap newInsuranceImageValues		= new HashMap();
		ArrayList<String> existingPayerList=new ArrayList<String>();
		ArrayList<String> newPayerList=new ArrayList<String>();
		ArrayList<String> tempPayerList=new ArrayList<String>();
		ArrayList<String> removalPayerList=new ArrayList<String>();		

			Set<String> kSet=bean.getInsuranceImageValues().keySet();				
			Iterator<String> it=kSet.iterator();

			while(it.hasNext()){
				String key=it.next();
				existingPayerList.add(key);
			}
			 //added for GHL 0550 06/05/2020
			for (int i = checked_rows; i <= totalRecords; i++) 
			{	
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 			
				newPayerList.add(payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate);
			}	

			/*This logic identifies session records which needs to be deleted */
			/*Omit Payers provided in Add Payer Page*/

			/*
			existingPayerList.removeAll(newPayerList);//testing..........
			tempPayerList=existingPayerList;	*/		//testing......

			/*Omit Records selected through Insurance window */		
			/*
			for(int d=0;d<tempPayerList.size();d++){
				if( !tempPayerList.get(d).contains("^^^")){
					removalPayerList.add(tempPayerList.get(d));
				}
			}	*/	

			/*Getting Real Values from Hashmap for list */
			newInsuranceImageValues=bean.getInsuranceImageValues();
			/*
				for(int ret=0;ret<removalPayerList.size();ret++){
				newInsuranceImageValues.remove(removalPayerList.get(ret));
			}
			*/
			bean.setInsuranceImageValues(newInsuranceImageValues);

			/*Karthik added the below code to handle Session Record retain - ends */
			for (int i =checked_rows ; i <= totalRecords; i++)   //added for GHL 0550 06/05/2020
			{ 		
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 
				//String billingGroup=(String)hash.get("blng_grp_code" + i);
				String billingGroup=(String)hash.get("billing_group_desc" + i);
				//billing_group_desc
				String creditAuthRef=(String)hash.get("credit_auth_ref" + i);
				String creditAuthDate=(String)hash.get("credit_auth_date" + i); 	
				String payer_desc=(String)hash.get("payer_desc" + i);
				String replicationKey=payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate;
				//if(!existingPayerList.contains(replicationKey))
				System.out.println("*************"+existingPayerList.isEmpty());
				//if(bean.getSize()==0)					
		try{
				//conn=ConnectionManager.getConnection();
				//PreparedStatement pstmt1 = null;
				//ResultSet rs1 =null;				
					//conn=ConnectionManager.getConnection();
				//10882646				
				
				String	sql1="";			
				if(!calling_module_id.equals("MP"))
				{
					sql1 = "select count(*) from  bl_pat_ins_documents   where patient_id =? and patient_class=? and blng_grp_id=?";	
						
					pstmt=conn.prepareStatement(sql1);			
					pstmt.setString(1,strPatientId);
					pstmt.setString(2,calling_module_id);
					pstmt.setString(3,strBillingGroup);
					rs = pstmt.executeQuery();				
				}
				else 
				{
					sql1 = "select count(*) from  bl_pat_ins_documents   where patient_id =? ";
					pstmt=conn.prepareStatement(sql1);
					pstmt.setString(1,strPatientId);	
					rs = pstmt.executeQuery();
				}
				if(rs.next())
				{
					rowCount = java.lang.Integer.parseInt(rs.getString(1));
					System.err.println("rowCount BLInsImageIntLoadValidation_GHL.jsp "+rowCount);
				}				
				}catch(Exception e)
				{
					System.out.println(e);
					e.printStackTrace();
				}
				finally
				{
					try {
						if(rs!=null)  rs.close();
						if (pstmt != null){
							pstmt.close();
							}		
				
						/*if (conn != null){	
									conn.commit();
									ConnectionManager.returnConnection(conn);
							}*/
						/*Commented against V230822/31032 */									
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				System.err.println("flage BLInsImageIntLoadValidation_GHL.jsp "+flage);
				System.err.println("rowCount,236 BLInsImageIntLoadValidation_GHL.jsp "+rowCount);
				if((rowCount==0 )||( flage==true))//07-05-2020
				{	
					bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate,billingGroup,creditAuthRef,creditAuthDate);	//May 12 2020			
					System.err.println("after setInsuranceValues call ");
				}
			
			/*
					else if(calling_module_id.equals("MP"))
					{
						bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate,billingGroup,creditAuthRef,creditAuthDate);
			}*/
			}
			}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from BLInsImageIntLoadValidation.jsp :"+ e);
			}
	}
	else
	{		
		try {
			request.setCharacterEncoding("UTF-8");
			Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
			hash = (Hashtable) hash.get("SEARCH");		
			String[] tempString = new String[4];
			int totalRecords= (hash.get("total_records")==null) ? 0:Integer.parseInt((String)hash.get("total_records"));
			System.err.println("257,totalRecords BLInsImageIntLoadValidation_GHL.jsp "+totalRecords);
			/*Karthik added the below code to handle Session Record retain - starts */
			
			HashMap newInsuranceImageValues		= new HashMap();
			ArrayList<String> existingPayerList=new ArrayList<String>();
			ArrayList<String> newPayerList=new ArrayList<String>();
			ArrayList<String> tempPayerList=new ArrayList<String>();
			ArrayList<String> removalPayerList=new ArrayList<String>();
			

			Set<String> kSet=bean.getInsuranceImageValues().keySet();
			Iterator<String> it=kSet.iterator();
			
			while(it.hasNext()){
				String key=it.next();
				existingPayerList.add(key);
			}
				
			for (int i = 0; i < totalRecords; i++) {	
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 			
				newPayerList.add(payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate);	
			}	
			
			/*This logic identifies session records which needs to be deleted */
			/*Omit Payers provided in Add Payer Page*/
			existingPayerList.removeAll(newPayerList);
			tempPayerList=existingPayerList;		
			/*Omit Records selected through Insurance window */		
			for(int d=0;d<tempPayerList.size();d++){
				if( !tempPayerList.get(d).contains("^^^")){
					removalPayerList.add(tempPayerList.get(d));
				}
			}		
			
			/*Getting Real Values from Hashmap for list */
			newInsuranceImageValues=bean.getInsuranceImageValues();
			for(int ret=0;ret<removalPayerList.size();ret++){
				newInsuranceImageValues.remove(removalPayerList.get(ret));
			}
			
			bean.setInsuranceImageValues(newInsuranceImageValues);
			System.err.println("299, setInsuranceImageValues call ends");
			/*Karthik added the below code to handle Session Record retain - ends */
			
			for (int i = 0; i < totalRecords; i++) {	
				String payerGroupCode=(String)hash.get("ins_cust_group_code"	+ i);
				String payerCode=(String)hash.get("cust_3"	+ i);
				String policyCode=(String)hash.get("policy_type_code"	+ i);
				String policyNo=(String)hash.get("policy_no"	+ i);
				String startDate=(String)hash.get("policy_start_date"	+ i);
				String endDate=(String)hash.get("policy_exp_date"	+ i); 
				String replicationKey=payerGroupCode+payerCode+policyCode+policyNo+startDate+endDate+"^^^";
				if(!existingPayerList.contains(replicationKey)){
					System.err.println("312 BLInsImageIntLoadValidation_GHL.jsp setInsuranceValues call");
					bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	//Added by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
	else if(stmind.equals("R")) {
		String payerGroupCode="";
		String payerCode="";
		String policyCode="";
		String policyNo="";
		String startDate="";
		String endDate=""; 
		String billingGroup="";
		String creditAuthRef="";
		String  creditAuthDate=""; 
		String 	short_desc = ""; 
		String payer_desc="";
		PreparedStatement pstmt1 = null;
		ResultSet rs1=null;			
		String sql2=null;		
		try{			
			ArrayList<String> existingPayerList=new ArrayList<String>();
			Set<String> kSet=bean.getInsuranceImageValues().keySet();
			Iterator<String> it=kSet.iterator();
			
			while(it.hasNext()){
				String key=it.next();
				existingPayerList.add(key);
			}			
			
			 payerGroupCode = request.getParameter("cust_group_code");
			 payerCode = request.getParameter("cust_code");
			 System.err.println("349,payerGroupCode "+payerGroupCode);
			 System.err.println("349,payerCode "+payerCode);
			try{
				String sql4 = "select SHORT_DESC from BL_BLNG_GRP where BLNG_GRP_ID='"+strBillingGroup+"'"; 
				pstmt1=conn.prepareStatement(sql4);
				rs1 = pstmt1.executeQuery();
				if(rs1.next()){
					billingGroup = rs1.getString(1);
					 System.err.println("357,billingGroup "+billingGroup);
				}
				if(!calling_module_id.equals("MP")){
					 sql2 = "select count(*) from  bl_pat_ins_documents   where patient_id =? and patient_class=? and blng_grp_id=?";
					pstmt=conn.prepareStatement(sql2);				
					pstmt.setString(1,strPatientId);	
					pstmt.setString(2,calling_module_id);
					pstmt.setString(3,strBillingGroup);
					rs = pstmt.executeQuery();
				}else {
					sql2 = "select count(*) from  bl_pat_ins_documents   where patient_id =? ";
					pstmt=conn.prepareStatement(sql2);					
					pstmt.setString(1,strPatientId);						
					rs = pstmt.executeQuery();
				}				
					
				if(rs.next()){
					rowCount = java.lang.Integer.parseInt(rs.getString(1));
				}
					int hashsize=bean.getInsuranceImageValues().size();//07-05-2020
				if((rowCount==0 && hashsize==0 )||( flage==true)){//07-05-2020
					siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550	
					System.err.println("379 siteSpecUploadDocAll BLInsImageIntLoadValidation_GHL.jsp "+siteSpecUploadDocAll);					
					if(siteSpecUploadDocAll) {
						bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate,billingGroup,creditAuthRef,creditAuthDate);//May 12 2020
					}else{				
						bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate);
					}
				}			
			}
			catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}
			finally{
				try {
					if(rs!=null)  rs.close();
					if(rs1!=null)  rs.close();
					if (pstmt != null){
						pstmt.close();}	
					if (pstmt1 != null){
						pstmt1.close();}	
						/* if (conn != null){
						 conn.commit();
						ConnectionManager.returnConnection(conn);
							} */					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}catch(Exception e){
				System.out.println(e);
				e.printStackTrace();
			}	
	}//Ended by Shikha for GHL-CRF-0550 #9942 on 30-Apr-2020
	// Added 09-mar-20 palaniNarayanan/GHL-CRF-0550 changes - start--->
	else
	{
		try{			
			ArrayList<String> existingPayerList=new ArrayList<String>();
			Set<String> kSet=bean.getInsuranceImageValues().keySet();
			Iterator<String> it=kSet.iterator();
			
			while(it.hasNext()){
				String key=it.next();
				existingPayerList.add(key);
			}
			System.out.println("Exsiting  array List"+ existingPayerList);
			String payerGroupCode="";
			String payerCode="";
			String policyCode="";
			String policyNo="";
			String startDate="";
			String endDate=""; 
			String billingGroup="";
			String creditAuthRef="";
			String  creditAuthDate=""; 
			String 	short_desc = ""; 
			String payer_desc="";
			PreparedStatement pstmt1 = null;
			ResultSet rs1=null;			
			String sql2=null;
			try{
				//conn=ConnectionManager.getConnection();					
			String sql4 = "select SHORT_DESC from BL_BLNG_GRP where BLNG_GRP_ID='"+strBillingGroup+"'"; 
			pstmt1=conn.prepareStatement(sql4);
			rs1 = pstmt1.executeQuery();
			if(rs1.next())
			{				
				billingGroup = rs1.getString(1);
				System.err.println("447 billingGroup "+billingGroup);	
			}
			if(!calling_module_id.equals("MP"))
			{
			 sql2 = "select count(*) from  bl_pat_ins_documents   where patient_id =? and patient_class=? and blng_grp_id=?";
			pstmt=conn.prepareStatement(sql2);
			pstmt.setString(1,strPatientId);	
			pstmt.setString(2,calling_module_id);
			pstmt.setString(3,strBillingGroup);
			rs = pstmt.executeQuery();
			}
			else
			{

				sql2 = "select count(*) from  bl_pat_ins_documents   where patient_id =? ";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setString(1,strPatientId);	
				rs = pstmt.executeQuery();
			}
				
			
			if(rs.next())
			{
				rowCount = java.lang.Integer.parseInt(rs.getString(1));
			}
			int hashsize=bean.getInsuranceImageValues().size();//07-05-2020
			if((rowCount==0 && hashsize==0 )||( flage==true))//07-05-2020
			{
				siteSpecUploadDocAll = eCommon.Common.CommonBean.isSiteSpecific(conn, "BL","BL_UPLOAD_DOC_ALL");//Added V191028-Aravindh/GHL-CRF-0550
				System.err.println("siteSpecUploadDocAll 2 BLInsImageIntLoadValidation_GHL.jsp "+siteSpecUploadDocAll);
				if(siteSpecUploadDocAll)
				{
				bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate,billingGroup,creditAuthRef,creditAuthDate);//May 12 2020
				}else{				
				bean.setInsuranceValues(payerGroupCode,payerCode,policyCode,policyNo,startDate,endDate);
				}
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				e.printStackTrace();
			}
		finally
			{
				try {
					if(rs!=null)  rs.close();
					if(rs1!=null)  rs.close();
					if (pstmt != null){
						pstmt.close();}	
					if (pstmt1 != null){
						pstmt1.close();}	
						/* if (conn != null){
						 conn.commit();
						ConnectionManager.returnConnection(conn);
							}			*/		
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
	}	
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from BLInsImageIntLoadValidation.jsp :"+ e);
	}
	}	
	}
	catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception from BLInsImageIntLoadValidation.jsp 1 :"+ e);
	}
	finally{
		if (conn != null){	
			conn.commit();
			ConnectionManager.returnConnection(conn);
		}	
	}
%>
