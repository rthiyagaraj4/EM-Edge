 <%-- saved 0n 22/10/2005 --%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%
	try{
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
		String locale			= (String)session.getAttribute("LOCALE");
		
		String bean_id	= request.getParameter("bean_id");
		String bean_name	 = request.getParameter("bean_name");
		out.println(bean_id);
		String carbohydrate_Energy = request.getParameter("Carbohydrate_Energy");
		String cabohydrate_Order_Quantity = request.getParameter("Cabohydrate_Order_Quantity");
		String cabohydrate_Strength_Weight = request.getParameter("Cabohydrate_Strength_Weight");
		String protein_Energy = request.getParameter("Protein_Energy");
		String protein_Order_Quantity = request.getParameter("Protein_Order_Quantity");
		String protein_Strength_Weight = request.getParameter("Protein_Strength_Weight");
		String lipid_Energy = request.getParameter("Lipid_Energy");
		String lipid_Order_Quantity = request.getParameter("Lipid_Order_Quantity");
		String lipid_Strength_Weight = request.getParameter("Lipid_Strength_Weight");	/*out.println(bean_id+bean_name+Carbohydrate_Energy+Cabohydrate_Order_Quantity_GM+Cabohydrate_Strength_Weight+Protein_Energy+Protein_Order_Quantity_GM+Protein_Strength_Weight+Lipid_Energy+Lipid_Order_Quantity_GM+ Lipid_Strength_Weight);*/
		StringTokenizer stk;
		ArrayList carbohydrate_Energy_ValueUnit = new ArrayList();
		ArrayList carbohydrate_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList carbohydrate_Strength_Weight_VaueUnit = new ArrayList();
		ArrayList protein_Energy_ValueUnit = new ArrayList();
		ArrayList protein_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList protein_Strength_Weight_VaueUnit = new ArrayList();
		ArrayList lipid_Energy_ValueUnit = new ArrayList();
		ArrayList lipid_Order_Quantity_VaueUnit = new ArrayList();
		ArrayList lipid_Strength_Weight_VaueUnit = new ArrayList();
		stk = new StringTokenizer(carbohydrate_Energy," ");
		while(stk.hasMoreTokens()){
			
			carbohydrate_Energy_ValueUnit.add(stk.nextToken());
		}
	
		stk = new StringTokenizer(cabohydrate_Order_Quantity," ");
		
		while(stk.hasMoreTokens()){
			
			carbohydrate_Order_Quantity_VaueUnit.add(stk.nextToken());
			
		}
		

		stk = new StringTokenizer(cabohydrate_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			carbohydrate_Strength_Weight_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(protein_Energy," ");
		while(stk.hasMoreTokens()){
			protein_Energy_ValueUnit.add(stk.nextToken());
		}
		
		stk = new StringTokenizer(protein_Order_Quantity," ");
		while(stk.hasMoreTokens()){
			protein_Order_Quantity_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(protein_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			protein_Strength_Weight_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(lipid_Energy," ");
		while(stk.hasMoreTokens()){
			lipid_Energy_ValueUnit.add(stk.nextToken());
		}
		
		stk = new StringTokenizer(lipid_Order_Quantity," ");
		while(stk.hasMoreTokens()){
			lipid_Order_Quantity_VaueUnit.add(stk.nextToken());
		}

		stk = new StringTokenizer(lipid_Strength_Weight," ");
		while(stk.hasMoreTokens()){
			lipid_Strength_Weight_VaueUnit.add(stk.nextToken());
		}
		
		TPNRegimenBean bean = (TPNRegimenBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setCarbohydrateEnergy(carbohydrate_Energy_ValueUnit);
		bean.setCabohydrateOrderQuantity(carbohydrate_Order_Quantity_VaueUnit);
		bean.setCabohydrateStrengthWeight(carbohydrate_Strength_Weight_VaueUnit);
		bean.setProteinEnergy(protein_Energy_ValueUnit);
		bean.setProteinOrderQuantity(protein_Order_Quantity_VaueUnit);
		bean.setProteinStrengthWeight(protein_Strength_Weight_VaueUnit);
		bean.setLipidEnergy(lipid_Energy_ValueUnit);
		bean.setLipidOrderQuantity(lipid_Order_Quantity_VaueUnit);
		bean.setLipidStrengthWeight(lipid_Strength_Weight_VaueUnit);
		/*out.println(bean.getCarbohydrateEnergy());
		out.println(bean.getCabohydrateOrderQuantity());
		out.println(bean.getCabohydrateStrengthWeight());
		out.println(bean.getProteinEnergy());
		out.println(bean.getProteinOrderQuantity());
		out.println(bean.getProteinStrengthWeight());
		out.println(bean.getLipidEnergy());
		out.println(bean.getLipidOrderQuantity());
		out.println(bean.getLipidStrengthWeight());
		out.println(bean.getCarbohydrateEnergyUnit());
		out.println(bean.getCabohydrateOrderQuantityUnit());
		out.println(bean.getCabohydrateStrengthWeightUnit());
		out.println(bean.getProteinEnergyUnit());
		out.println(bean.getProteinOrderQuantityUnit());
		out.println(bean.getProteinStrengthWeightUnit());
		out.println(bean.getLipidEnergyUnit());
		out.println(bean.getLipidOrderQuantityUnit());
		out.println(bean.getLipidStrengthWeightUnit());*/
		putObjectInBean(bean_id,bean,request);
	}catch(Exception e){
		out.println("alert('"+e.toString()+"')");
	}
%>
