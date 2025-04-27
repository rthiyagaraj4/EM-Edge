/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePH;
import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class FDBExternalDataBaseBean
{

	private FDBDataManager fwConn;

	private HashMap DosageCheckMessages;
    private HashMap DDInteractionResult;
    private HashMap DuplicateTheraphyResult;
    private HashMap DrugAlergiesResult;
    private HashMap ContraIndicationsResult;
	StringBuffer sbDuplicateDescription = new StringBuffer();
// Removed for IN063877 start
//	private HashMap drugcontraindications;
//	private HashMap druginteractiondetail;
 //   private HashMap drugFoodInteractionResult;
 //   private HashMap drugPrecautionResult;
//	private HashMap side_effects;
//	private HashMap OverDose_msg ;
//	private HashMap pat_edu_info;
//	private HashMap common_orders;
	//Removed for IN063877 end
	private HashMap drugInfos;

    //private ArrayList drugList; //Commented for common-icn-0048
	HashMap drug_det= new HashMap();
	HashMap drugMap = new HashMap();

    public FDBExternalDataBaseBean() throws IOException
    {
        FDBFrameworkConnectionManager fwConnMgr = new FDBFrameworkConnectionManager();
        fwConnMgr.setFrameworkConnection();
        fwConn = fwConnMgr.getFrameworkConnection();
    }
	
    public String getDuplicateTherapyResult(ArrayList drug_list, String prod_id) throws FDBException, Exception
    {
		DuplicateTheraphyResult = null;
		String dup_desc ="";
		try{
			FDBDrugDuplicateTherapy drugduplicatetherapy = new FDBDrugDuplicateTherapy(fwConn);
			drugduplicatetherapy.setProspectiveOnly(true);
			drugduplicatetherapy.setUseDuplicateAllowance(true);
			drugduplicatetherapy.setDrugType(4);
			if(drug_list != null && drug_list.size() > 0){
				dup_desc =drugduplicatetherapy.getDuplicateDrugTherapyResult(drug_list,prod_id);
			}
			boolean is_duplicated =false;

			if(!dup_desc.equals("") && !prod_id.equals("")){
				HashMap dup_drug_det  =(HashMap)drugduplicatetherapy.getDuplicateDrugDeatils();
				HashMap drug_det      =(HashMap)drugduplicatetherapy.getDrugDeatils();

				String pres_drug_desc    = (String)drug_det.get(prod_id);
			
				if(dup_drug_det.containsKey(pres_drug_desc)){
					is_duplicated   =   true;
				}
				if(!is_duplicated){
					 dup_desc   = "";
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dup_desc;
	}

	public HashMap getDosageCheckResult(ArrayList dosageCheckParams) throws Exception {

		String ext_prod_id =  "";
		String dosage =  "";
		String dose_uom =  "";
		String frequency =  "";
		String duration = "";
		String ext_dose_uom = "";
		String route_code = "";
		long age_in_days = 0;
		double weightKG = 0;
		double BSAInM2 =  0;
		DosageCheckMessages = null;

		//if(dosageCheckParams != null && dosageCheckParams.size() == 10){
		if(dosageCheckParams != null && dosageCheckParams.size() == 15){
			ext_prod_id = (String) dosageCheckParams.get(1);	//external product id
			weightKG = Double.parseDouble(dosageCheckParams.get(2)==null?"0":(String)dosageCheckParams.get(2));			//patient weight
			BSAInM2 = Double.parseDouble( dosageCheckParams.get(3)==null?"0":(String)dosageCheckParams.get(3));	//patient BSA
			dosage = (String) dosageCheckParams.get(4);			//dosage
			dose_uom = (String) dosageCheckParams.get(5);		//dosage UOM(eHIS)
			frequency = (String) dosageCheckParams.get(6);		//frequency repeat value per day
			duration = (String) dosageCheckParams.get(7);		//duration
			//ext_dose_uom =(String) dosageCheckParams.get(8)==null?"":(String) dosageCheckParams.get(8);
			//age_in_days = Integer.parseInt(dosageCheckParams.get(9)==null?"0":(String) dosageCheckParams.get(9));
			route_code =(String) dosageCheckParams.get(9)==null?"":(String) dosageCheckParams.get(8); //currently desc for future...
			ext_dose_uom =(String) dosageCheckParams.get(8)==null?"":(String) dosageCheckParams.get(9);
			age_in_days = Integer.parseInt(dosageCheckParams.get(13)==null?"0":(String) dosageCheckParams.get(13));
		}
		try	{
			if(age_in_days > 0 && (!ext_dose_uom.equals(""))){
				FDBDrugDoseRange drugdosebean=new FDBDrugDoseRange(fwConn);
				drugdosebean.setDrugType(4);
				drugdosebean.setSeverityFilter(3);
				drugdosebean.setProspectiveOnly(false);
				drugdosebean.setUseCustomInteractions(false);
				DosageCheckMessages = drugdosebean.checkForDrugDoseRange(ext_prod_id, age_in_days, weightKG, BSAInM2, dosage, ext_dose_uom, frequency, duration);
			}
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
		return DosageCheckMessages;
    }
	public HashMap getDDInteractionsResult(String external_product_id, HashMap drugProduct){
		try{
			FDBDrugDrugInteraction bean=new FDBDrugDrugInteraction(fwConn);
			bean.setDrugType(4);
			bean.setSeverityFilter(3);
			bean.setProspectiveOnly(false);
			bean.setUseCustomInteractions(false);
			if(drugProduct!=null && drugProduct.size()>0){

				Collection c=drugProduct.keySet();
				ArrayList drugs=new ArrayList(c);
				DDInteractionResult = new HashMap();
				HashMap result=bean.getDDInteractionsResult(drugs) ;
			
				Set keyset=result.keySet();
				Iterator itr=keyset.iterator();
				Object idset=null;
				while(itr.hasNext())  
				{
					idset=itr.next();
					String ids				 =	idset.toString();
					StringTokenizer idtoken  =	new StringTokenizer(ids, "-");
					String firstid			 =	idtoken.nextToken();
					String secondid			 =	idtoken.nextToken();
					String first_desc		 =	(String)drugProduct.get(firstid);
					String second_desc		 =	(String)drugProduct.get(secondid);

					if(firstid.equals(external_product_id) || secondid.equals(external_product_id)){
						HashMap interactions	 =	(HashMap)result.get(idset);
						Set interactionks		 =	interactions.keySet();
						Iterator interactionsitr =	interactionks.iterator();
						ArrayList interactionsal =	new ArrayList();

						while(interactionsitr.hasNext())  
						{
							interactionsal.add(interactions.get(interactionsitr.next()) );
						}
						DDInteractionResult.put(first_desc+"&nbsp  ------- &nbsp;"+second_desc,interactionsal);
					}  
				}
			}//end of iteration
		}
		catch (Exception e){
			e.printStackTrace() ;
		}
		return DDInteractionResult;
	}
	public HashMap  getDrugAlergyCheckResult(ArrayList drugs, ArrayList alergydrugcodes){
	//	boolean flag			   = false;Removed for IN063877
		DrugAlergiesResult  = new HashMap();
		try{
			FDBDrugAlerggyCheck drugalerggycheck = new FDBDrugAlerggyCheck(fwConn);
			DrugAlergiesResult = drugalerggycheck.getDrugAllergies(drugs, alergydrugcodes);
			
		}catch(Exception exp){
			exp.printStackTrace();
		}
		return DrugAlergiesResult;
	}
	public HashMap  getContraIndCheckResult(String extDrugId, ArrayList icd9code){
		ArrayList drugs = new ArrayList();
		drugs.add(extDrugId);
	//	boolean flag			   = false; Removed for IN063877
		ContraIndicationsResult  = new HashMap();
		
		try{
			FDBMedicalConditionsForICD9Code medcondforicd9code = new FDBMedicalConditionsForICD9Code(fwConn);
			ContraIndicationsResult = medcondforicd9code.getContraIndCheckResultForICD9Code(drugs, icd9code);
		}catch(Exception exp){
			exp.printStackTrace();
		}
		return ContraIndicationsResult;
	}
	public HashMap getExternalDBDrugInfo(String ExtDrugId){
		drugInfos = new HashMap();
		ArrayList Drugs =new ArrayList();
		Drugs.add(new Long(ExtDrugId));
		try{
			FDBDrugPrecaution drugPrecaution=new FDBDrugPrecaution(fwConn);

			drugPrecaution.setGERISeverityFilter(2);
			drugPrecaution.setLACTSeverityFilter(3);
			drugPrecaution.setPEDISeverityFilter(3);
			drugPrecaution.setPREGSignificanceFilter(5);
			drugInfos = (HashMap)drugPrecaution.getAllInfos(Drugs);
			/*
			//Drug Classification (AHFS and FBD) 	
			drugPrecaution.setDrugList(Drugs,"DRUG_CLASSFI"); 
			drugInfos.put("DRUG_CLASSFI",drugPrecaution.getDrugInfo());

			//DrugInteractionDetail
			drugPrecaution.setDrugList(Drugs,"INTE");  
			drugInfos.put("INTE",drugPrecaution.getDrugInteractions());

			//Geriatric Precautions
			drugPrecaution.setGERISeverityFilter(2);
			drugPrecaution.setLACTSeverityFilter(3);
			drugPrecaution.setPEDISeverityFilter(3);
			drugPrecaution.setPREGSignificanceFilter(5);
			drugPrecaution.setDrugList(Drugs,"PREC");
			drugInfos.put("PREC",drugPrecaution.getDrugPrecautionResult());

			//Common Orders
			drugPrecaution.setDrugList(Drugs,"COMMON_ORD"); 
			drugInfos.put("COMMON_ORD",drugPrecaution.getCommonOrders());

			//FoodInteractionInfo
			drugPrecaution.setDrugList(Drugs,"DRUG_FOOD"); 
			drugInfos.put("DRUG_FOOD",drugPrecaution.getDrugFoodInteractionResult());

			//DrugContraIndication
			drugPrecaution.setDrugList(Drugs,"CONT"); 
			drugInfos.put("CONT",drugPrecaution.getDrugContraIndications());

			//Side Effects
			drugPrecaution.setDrugList(Drugs,"SIDE"); 
			drugInfos.put("SIDE",drugPrecaution.getDrugSideEffects());

			//Over Dose
			drugPrecaution.setDrugList(Drugs,"OVER"); 
			drugInfos.put("OVER",drugPrecaution.getDrugOverDose());
		
			//Patient Education
			drugPrecaution.setDrugList(Drugs,"PAT_EDU"); 
			drugInfos.put("PAT_EDU",drugPrecaution.getPatientEducationInfo());
			*/
		}catch(Exception e){
			e.printStackTrace();
		}
		return drugInfos;
	}
}
