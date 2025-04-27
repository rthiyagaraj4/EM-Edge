<!DOCTYPE html>
 <%--corrected on 10/25/2005--%>
<%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*,eST.*,eST.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	try {	
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
	
	
		String bean_id				=	request.getParameter( "bean_id" ) ;
		String bean_name			=	request.getParameter( "bean_name" ) ;
		String selectedEnergyProvided	=	request.getParameter( "selectedEnergyProvided" ) ;
		String proteinVal			=	request.getParameter( "proteinVal" ) ;
		String lipidVal				=	request.getParameter( "lipidVal" ) ;
		String weight			=	request.getParameter( "weight" ) ;
		String proteinValueUnit				=	request.getParameter( "proteinValueUnit" ) ;
		String lipidValueUnit			=	request.getParameter( "lipidValueUnit" ) ;

		String carboPerc = request.getParameter("carboPerc");
		if(carboPerc == null || carboPerc.equals("null") ) carboPerc = "";
		String lipidPerc = request.getParameter("lipidPerc");
		if(lipidPerc == null || lipidPerc.equals("null") ) lipidPerc = "";
		String proteinPerc = request.getParameter("proteinPerc");
		if(proteinPerc == null || proteinPerc.equals("null") ) proteinPerc = "";
		String calcByHBF	 = request.getParameter("calcByHBF");
		if(calcByHBF == null || calcByHBF.equals("null") ) calcByHBF = "";

		Hashtable hash			= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash					= (Hashtable)hash.get( "SEARCH" ) ;
		TPNRegimenBean beanObj =null;
		beanObj		= (TPNRegimenBean)getBeanObject(bean_id,bean_name, request);
		String validate				=	request.getParameter( "validate" ) ;
		if(validate == null || validate.equals("null") ) validate = "";
		String encounter_id				=	request.getParameter( "encounter_id" ) ;
		String facility_id		= (String) session.getValue("facility_id");

		int iCalcByIndex = calcByHBF.equals("Y")?0:1;
		int iStressFactorIndex = request.getParameter("iStressFactorIndex")==null?0:Integer.parseInt(request.getParameter("iStressFactorIndex").toString());
		int iBodyWeightIndex =request.getParameter("iBodyWeightIndex")==null?0:Integer.parseInt(request.getParameter("iBodyWeightIndex").toString());
		String sEnergy =request.getParameter("sEnergy")==null?"":request.getParameter("sEnergy").toString();
		String sRecoEnergy =request.getParameter("sRecoEnergy")==null?"":request.getParameter("sRecoEnergy").toString();
		String sFluid =request.getParameter("sFluid")==null?"":request.getParameter("sFluid").toString();
		String sEnergyProvided =request.getParameter("sEnergyProvided")==null?"":request.getParameter("sEnergyProvided").toString();
		int iProteinSelIndex = request.getParameter("iProteinSelIndex")==null?1:Integer.parseInt(request.getParameter("iProteinSelIndex").toString());
		int iLipidSelIndex = request.getParameter("iLipidSelIndex")==null?1:Integer.parseInt(request.getParameter("iLipidSelIndex").toString());
		boolean bActFactor = Boolean.getBoolean(iLipidSelIndex+"");
		//boolean bActFactor = true;

		beanObj.setHmAssesValues(iCalcByIndex,iBodyWeightIndex,sEnergy,bActFactor,sRecoEnergy,carboPerc,lipidPerc,proteinPerc,sFluid,sEnergyProvided,iProteinSelIndex,iLipidSelIndex,iStressFactorIndex);

	   if (validate.equals("before")) {

			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String accession_num="";
			
			record2=beanObj.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
				   
			if(tpn_screening_type.equals("N")){
			HashMap record3=new HashMap();
			record3=beanObj.ChkScreeningDetails(facility_id,encounter_id,note_type);
			accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
			  }
			  out.println("beforAccessionNumber(\""+ accession_num + "\");");
			}
	if (validate.equals("Discrete")) {
			try{
			HashMap record2=new HashMap(); 
			String tpn_screening_type="";
			String note_type="";
			String test_observ_dt_tm="";
			
			record2=beanObj.ChkAdMixture();
			tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
			note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
			encounter_id			=	request.getParameter( "encounter_id" ) ;
			
			if(tpn_screening_type.equals("D")){
			HashMap record3=new HashMap();
			record3=beanObj.ChkDiscrete(facility_id,encounter_id,note_type);
			test_observ_dt_tm=CommonBean.checkForNull((String)record3.get("TEST_OBSERV_DT_TM"));

			}
			out.println("beforDiscrete(\""+ test_observ_dt_tm + "\");");
			}catch(Exception ee)	{
			 
		        ee.printStackTrace();

			}
	}

	if(calcByHBF.equals("Y")) {  //Harris Benedict Formula
		beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinVal, lipidVal,weight);
	} else {  //Body Weight Formula
		beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinPerc, lipidPerc, carboPerc, weight);
	}
		
		//beanObj.calculateMacroNutrients(selectedEnergyProvided, proteinVal, lipidVal,weight);
		ArrayList energyValue =beanObj.getEnergyValue();
		if(energyValue.size() >0){
			String proteinEnergy = energyValue.get(0)==null?"":(String)energyValue.get(0);
			String lipidEnergy =  energyValue.get(1)==null?"":(String)energyValue.get(1); 
			String carboEnergy = energyValue.get(2)==null?"":(String)energyValue.get(2);
			String proteinEnergyUnit = energyValue.get(3)==null?"":(String)energyValue.get(3);
			String lipidEnergyUnit =  energyValue.get(4)==null?"":(String)energyValue.get(4);
			String carboEnergyUnit = energyValue.get(5)==null?"":(String)energyValue.get(5);
			String proteinStrengthVal = energyValue.get(6)==null?"":(String)energyValue.get(6);
			String lipidStrengthVal =energyValue.get(7)==null?"":(String)energyValue.get(7);
			String carboStrengthVal = energyValue.get(8)==null?"":(String)energyValue.get(8);
			String proteinOrderQuantityVal = energyValue.get(9)==null?"":(String)energyValue.get(9);
			String lipidOrderQuantityVal =energyValue.get(10)==null?"":(String)energyValue.get(10);
			String carboOrderQuantityVal = energyValue.get(11)==null?"":(String)energyValue.get(11);
			out.println("assignMacroNutrients('"+proteinEnergy+"','"+lipidEnergy+"','"+carboEnergy+"','"+proteinEnergyUnit+"','"+lipidEnergyUnit+"','"+carboEnergyUnit+"','"+proteinStrengthVal+"','"+lipidStrengthVal+"','"+carboStrengthVal+"','"+proteinOrderQuantityVal+"','"+lipidOrderQuantityVal+"','"+carboOrderQuantityVal+"','"+proteinValueUnit+"','"+lipidValueUnit+"');");
		}
	

	putObjectInBean(bean_id,beanObj,request);

}catch (Exception e) {
		e.printStackTrace();
	}


%>
