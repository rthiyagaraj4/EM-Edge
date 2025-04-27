<%@ page import="org.apache.commons.lang.*,java.sql.*,org.apache.commons.lang.StringUtils, java.util.*,eXH.*,java.lang.*,java.text.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat,com.ehis.util.*,eBL.Common.*, eBL.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="org.json.simple.JSONObject"%>


<%	
	//Added by Niveditha NMC-JD-CRF-0054.1
	
	String protocol_Link_Id="";
	String mpmastermodule ="MP";
	List<String> oHistTypeList= new ArrayList<String>();
	List<String> types= new ArrayList<String>();
	String DebugYNProtocolLinkId = StringUtils.EMPTY;	
		

	String cg_patdet_patient_id=StringUtils.EMPTY, cg_patdet_national_id=StringUtils.EMPTY, cg_patdet_alt_id1_type=StringUtils.EMPTY, cg_patdet_alt_id1_no=StringUtils.EMPTY, cg_patdet_alt_id2_type=StringUtils.EMPTY, 
	cg_patdet_alt_id2_no=StringUtils.EMPTY, cg_patdet_alt_id3_type=StringUtils.EMPTY, cg_patdet_alt_id3_no=StringUtils.EMPTY, cg_patdet_alt_id4_type=StringUtils.EMPTY, cg_patdet_alt_id4_no=StringUtils.EMPTY, cg_patdet_oth_altid_type=StringUtils.EMPTY, cg_patdet_oth_altid_no=StringUtils.EMPTY; 

	String method = request.getParameter("method");
	String patient_id = request.getParameter("patientid");

	String citizen_flag=StringUtils.EMPTY;
	
	
	try {

			if (method.equals("PatientDetails"))
			{
				protocol_Link_Id="HSWITCHPL";

				XHUtil ProtocolLinkID = new XHUtil();
				XHCustomerGroup custGroupDetails = new XHCustomerGroup(); 
				XHPatientDetailsBean CustomerGroupPatDetails = custGroupDetails.getPatientDetails(patient_id);
			 
				DebugYNProtocolLinkId = ProtocolLinkID.FetchProtocollinkMethod(protocol_Link_Id);	
				
				cg_patdet_patient_id = CustomerGroupPatDetails.getPatientId();
				cg_patdet_national_id = CustomerGroupPatDetails.getNationalId();
				cg_patdet_alt_id1_type = CustomerGroupPatDetails.getAltId1Type();
				cg_patdet_alt_id1_no = CustomerGroupPatDetails.getAltId1No();
				cg_patdet_alt_id2_type = CustomerGroupPatDetails.getAltId2Type();
				cg_patdet_alt_id2_no = CustomerGroupPatDetails.getAltId2No();
				cg_patdet_alt_id3_type = CustomerGroupPatDetails.getAltId3Type();
				cg_patdet_alt_id3_no = CustomerGroupPatDetails.getAltId3No();
				cg_patdet_alt_id4_type = CustomerGroupPatDetails.getAltId4Type();
				cg_patdet_alt_id4_no = CustomerGroupPatDetails.getAltId4No();
				cg_patdet_oth_altid_type = CustomerGroupPatDetails.getOthAltIdType();
				cg_patdet_oth_altid_no = CustomerGroupPatDetails.getOthAltIdNo();

				if("Y".equals(DebugYNProtocolLinkId)){
					System.out.println("BL Interface Validation :::: Patient ID ::::"+cg_patdet_patient_id);
					System.out.println("BL Interface Validation :::: Nationality ID ::::"+cg_patdet_national_id);
					System.out.println("BL Interface Validation :::: Alternative ID One Type ::::"+cg_patdet_alt_id1_type);
					System.out.println("BL Interface Validation :::: Alternative ID One No ::::"+cg_patdet_alt_id1_no);
					System.out.println("BL Interface Validation :::: Alternative ID Two Type ::::"+cg_patdet_alt_id2_type);
					System.out.println("BL Interface Validation :::: Alternative ID Two No ::::"+cg_patdet_alt_id2_no);
					System.out.println("BL Interface Validation :::: Alternative ID Three Type ::::"+cg_patdet_alt_id3_type);
					System.out.println("BL Interface Validation :::: Alternative ID Three No ::::"+cg_patdet_alt_id3_no);
					System.out.println("BL Interface Validation :::: Alternative ID Four Type ::::"+cg_patdet_alt_id4_type);
					System.out.println("BL Interface Validation :::: Alternative ID Four No ::::"+cg_patdet_alt_id4_no);
					System.out.println("BL Interface Validation :::: Alternative ID Five No ::::"+cg_patdet_oth_altid_type);
					System.out.println("BL Interface Validation :::: Alternative ID Five No ::::"+cg_patdet_oth_altid_no);
				}

				JSONObject ob = new JSONObject();
				ob.put("patient_id", cg_patdet_patient_id);
				ob.put("nationality_id", cg_patdet_national_id);
				ob.put("alt_id1_type", cg_patdet_alt_id1_type);
				ob.put("alt_id1_no", cg_patdet_alt_id1_no);
				ob.put("alt_id2_type", cg_patdet_alt_id2_type);
				ob.put("alt_id2_no", cg_patdet_alt_id2_no);
				ob.put("alt_id3_type", cg_patdet_alt_id3_type);
				ob.put("alt_id3_no", cg_patdet_alt_id3_no);
				ob.put("alt_id4_type", cg_patdet_alt_id4_type);
				ob.put("alt_id4_no", cg_patdet_alt_id4_no);
				ob.put("alt_oth_id_type", cg_patdet_oth_altid_type);
				ob.put("alt_oth_id_no", cg_patdet_oth_altid_no);

				citizen_flag = custGroupDetails.getCitizen(patient_id);
			
				if("Y".equals(DebugYNProtocolLinkId)){
					System.out.println("BL Interface Validation :::: Patient Citizen Flag ::::"+citizen_flag);
				}
				
				ob.put("citizen_flag", citizen_flag);

				out.println(ob.toString());
				out.flush();

			}			
		
		}
		catch(Exception e){
			e.printStackTrace();
		}

%>

