/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//import firstdatabank.fdbffc.*;
package webbeans.ePH.FDBInterface;
import firstdatabank.idif.*;
import firstdatabank.database.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;

// Referenced classes of package com.medicom.dif:
//            FrameworkConnectionManager

public class DrugDoseRange{

    public DrugDoseRange() throws IOException {
  /*      doseformhigh = 0.0D;
        doseformlow = 0.0D;
        dosehigh = 0.0D;
        doselow = 0.0D;
        maxdailydoseform = 0.0D;
        maxdailydose = 0.0D;*/
        FrameworkConnectionManager fwConnMgr = new FrameworkConnectionManager();
        fwConnMgr.setFrameworkConnection();
        fwConn = fwConnMgr.getFrameworkConnection();
        screening = new Screening(fwConn);
        screenDrugsList = new ScreenDrugs();
    }

 /*   public void setPatientAgeInDays(long days){
        ageindays = days;
    }
*/
    public void setDrugType(int drugType){
		switch(drugType){
			case 1:
				this.drugType = FDBDrugType.fdbDTRoutedDrug;
				break;
			case 2:
	            this.drugType = FDBDrugType.fdbDTDispensableDrug;
				break;
			case 3:
	            this.drugType = FDBDrugType.fdbDTPackagedDrug;
				break;
			case 4:
	            this.drugType = FDBDrugType.fdbDTGCNSeqNo;
				break;
			case 5:
	            this.drugType = FDBDrugType.fdbDTRtGen;
				break;
			case 6:
				this.drugType = FDBDrugType.fdbDTCompound;
				break;
			case 7:
	            this.drugType = FDBDrugType.fdbDTCustom;
				break;
			case 8:
	            this.drugType = FDBDrugType.fdbDTManufacturedDrug;
				break;
			case 9:
	            this.drugType = FDBDrugType.fdbDTReferenceOnly;
				break;
			case 10:
	            this.drugType = FDBDrugType.fdbDTRoutedDoseFormMedID;
				break;
			case 11:
	            this.drugType = FDBDrugType.fdbDTRoutedDoseFormGeneric;
				break;
			case 12:
	            this.drugType = FDBDrugType.fdbDTRegionalPackagedDrug;
				break;
			default:
	            throw new IllegalArgumentException();
		 }
    }

    public void setSeverityFilter(int filterType){
		switch(filterType){
			case 1:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFContraindicated;
				break;
			case 2:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFSevere;
				break;
			case 3:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFModerate;
				break;
			case 4:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownContraindicated;
				break;
			case 5:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownSevere;
				break;
			case 6:
	            severityFilter = FDBDDIMSeverityFilter.fdbDDIMSFUnknownModerate;
				break;
			default:
	            throw new IllegalArgumentException();
		}
    }

    public void setProspectiveOnlyAttribute(boolean prospectiveOnlyAttrib){
        prospectiveOnlyAttribute = prospectiveOnlyAttrib;
    }

    public void setUseCustomInteractions(boolean useCustomInteractionAttrib){
        useCustomInteractionsAttribute = useCustomInteractionAttrib;
    }

    public HashMap checkForDrugDoseRange(String sDrugCode,  long age_in_days, double weightKG, double BSAInM2, String dosage, String doseUnit, String frequency, String duration) throws Exception {

		ArrayList drugList = new ArrayList();
		String doseRate = "day";
		String durationRate = "day";
		String doseType = "02"; //Maintenance Dose
		int iFreq = Integer.parseInt(frequency == null ?"0":frequency);
		long lDuration = Long.parseLong(duration == null ?"0":duration);
		double dDosage = Double.parseDouble(dosage == null ?"0":dosage);
		DosageCheckMessages = new HashMap();

		ScreenDrugs scrDrgList = new ScreenDrugs();
		ScreenDrug scrDrg = new ScreenDrug(fwConn);
		scrDrg.load(sDrugCode, FDBDrugType.fdbDTGCNSeqNo, "");
		scrDrg.setProspective(true);
		scrDrgList.addItem(scrDrg);
		scrDrg.setDoseType(doseType);

//System.err.println("@@@@@@@@setDrugList= "+sDrugCode);
//System.err.println("@@dDosage= "+dDosage+"  doseUnit= "+doseUnit+" doseRate= "+doseRate+" iFreq= "+iFreq+" lDuration= "+lDuration+" durationRate="+durationRate);

		try{
			scrDrg.setDoseInfo(dDosage, doseUnit, doseRate, iFreq + "", lDuration, durationRate);
		}
		catch(java.lang.IllegalArgumentException e){
			e.printStackTrace();
		}

		DOSEScreenResults screenResultsDosege = new DOSEScreenResults();
//System.err.println("@@age_in_days= "+age_in_days+"  weightKG= "+weightKG+" BSAInM2= "+BSAInM2);
		screenResultsDosege =(DOSEScreenResults) screening.DOSEScreen (scrDrgList, true, age_in_days, weightKG, BSAInM2, FDBDOSESource.fdbDSDRCAndMinMax, "") ;
//System.err.println("@@screenResultsDosege= "+screenResultsDosege+"   count="+screenResultsDosege.count());

		for (int i = 0; i < screenResultsDosege.count(); i++){

			DOSEScreenResult screenResultDRC =screenResultsDosege.item(i);
			String singledosemsg = screenResultDRC.getSingleDoseMessage();
			String dailydosemsg = screenResultDRC.getDailyDoseMessage();
			String maxdailydosemsg = screenResultDRC.getMaxDailyDoseMessage();
			String freqmsg = screenResultDRC.getFrequencyMessage();
			String rangedosemsg = screenResultDRC.getFrequencyMessage();
			String durnmsg = screenResultDRC.getDurationMessage();

			if(singledosemsg != null)
				DosageCheckMessages.put("SINGLEDOSAGE", singledosemsg);
			if(dailydosemsg != null)
				DosageCheckMessages.put("DAILYDOSAGE", dailydosemsg);
			if(maxdailydosemsg != null)
				DosageCheckMessages.put("MAXDAILYDOSAGE", maxdailydosemsg);
			if(freqmsg != null)
				DosageCheckMessages.put("FREQUENCYDOSAGE", freqmsg);
			if(rangedosemsg != null)
				DosageCheckMessages.put("RANGEDOSAGE", rangedosemsg);
			if(durnmsg != null)
				DosageCheckMessages.put("DURATIONDOSAGE", durnmsg);

/*System.err.println("@@@singledosemsg= "+singledosemsg);
System.err.println("@@@dailydosemsg= "+dailydosemsg);
System.err.println("@@@maxdailydosemsg= "+maxdailydosemsg);
System.err.println("@@@freqmsg= "+freqmsg);
System.err.println("@@@rangedosemsg= "+rangedosemsg);
System.err.println("@@@durnmsg= "+durnmsg);*/
			break;
		}
		return DosageCheckMessages;
    }

/*

    private void setDrugDoseRange(ScreenDrugs screenDrugsList, long age_in_days, double weightKG, double BSAInM2) throws FDBException{
System.err.println("@@@setDrugDoseRange= "+screenDrugsList+" age_in_days= "+age_in_days+" weightKG="+weightKG+"BSAInM2 ="+BSAInM2);

		DOSEScreenResults screenResultsDosege = new DOSEScreenResults();
		screenResultsDosege =(DOSEScreenResults) screening.DOSEScreen (screenDrugsList, true, age_in_days, weightKG, BSAInM2, FDBDOSESource.fdbDSDRCAndMinMax, "") ;
System.err.println("@@screenResultsDosege= "+screenResultsDosege+"   count="+screenResultsDosege.count());
		Messages messages = screenResultsDosege.getMessages();
         if(messages!=null && messages.count()>0){
System.err.println("@@messages= "+messages.item(0));
		 }
		for (int i = 0; i < screenResultsDosege.count(); i++){

			DOSEScreenResult screenResultDRC =screenResultsDosege.item(i);

			String singledosemsg = screenResultDRC.getSingleDoseMessage();
			String dailydosemsg = screenResultDRC.getDailyDoseMessage();
			String maxdailydosemsg = screenResultDRC.getMaxDailyDoseMessage();
			String freqmsg = screenResultDRC.getFrequencyMessage();
			String rangedosemsg = screenResultDRC.getFrequencyMessage();
			String durnmsg = screenResultDRC.getDurationMessage();
System.err.println("@@@singledosemsg= "+singledosemsg);
System.err.println("@@@dailydosemsg= "+dailydosemsg);
System.err.println("@@@maxdailydosemsg= "+maxdailydosemsg);
System.err.println("@@@freqmsg= "+freqmsg);
System.err.println("@@@rangedosemsg= "+rangedosemsg);
System.err.println("@@@durnmsg= "+durnmsg);
		}
	//	Messages messages = screenResultsDosege.getMessages(); //GETTING PRE-DEFINED MESSAGES FROM FDB IF DRUGS ARE DUPLICATED

    /*     MMLookupResults mmLookupResults = drug.getMinMaxDosing(ageindays);
       if(mmLookupResults.count() > 0){
            for(int i = 0; i < mmLookupResults.count(); i++){
                doseformhigh = mmLookupResults.item(i).getDoseFormHigh();
                doseformhighunit = mmLookupResults.item(i).getDoseFormHighUnit();
                doseformlow = mmLookupResults.item(i).getDoseFormLow();
                doseformlowunit = mmLookupResults.item(i).getDoseFormLowUnit();
                dosehigh = mmLookupResults.item(i).getDoseHigh();
                dosehighunit = mmLookupResults.item(i).getDoseHighUnit();
                doselow = mmLookupResults.item(i).getDoseLow();
                doselowunit = mmLookupResults.item(i).getDoseLowUnit();
                maxdailydoseform = mmLookupResults.item(i).getMaxDailyDoseForm();
                maxdailydoseformunit = mmLookupResults.item(i).getMaxDailyDoseFormUnit();
                maxdailydose = mmLookupResults.item(i).getMaxDailyDose();
                maxdailydoseunit = mmLookupResults.item(i).getMaxDailyDoseUnit();
            }

        }
    }		

    public HashMap getDrugDosageCheck() throws FDBException{
		HashMap dosageCheckDetails = new HashMap();
		return dosageCheckDetails;
	}
    public double getDoseFormHigh(){
        return doseformhigh;
    }

    public String getDoseFormHighUnit(){
        return doseformhighunit;
    }

    public double getDoseFormLow(){
        return doseformlow;
    }

    public String getDoseFormLowUnit(){
        return doseformlowunit;
    }

    public double getDoseHigh(){
        return dosehigh;
    }

    public String getDoseHighUnit(){
        return dosehighunit;
    }

    public double getDoseLow(){
        return doselow;
    }

    public String getDoseLowUnit(){
        return doselowunit;
    }

    public double getMaxDailyDoseForm(){
        return maxdailydoseform;
    }

    public String getMaxDailyDoseFormUnit(){
        return maxdailydoseformunit;
    }

    public double getMaxDailyDose(){
        return maxdailydoseform;
    }

    public String getMaxDailyDoseUnit(){
        return maxdailydoseformunit;
    }

    public static void main(String args[]){
        try{
            DrugDoseRange drc = new DrugDoseRange();
//            drc.setPatientAgeInDays(10000L);
//            drc.setDrug(6507L);

ArrayList drugList = new ArrayList();
drugList.add("6562L");

DrugDoseRange drugdosebean=new DrugDoseRange();

drugdosebean.setDrugList(drugList);

            //System.out.println(drc.getDoseLow() + " " + drc.getDoseLowUnit());
        //    System.out.println(drc.getDoseHigh() + " " + drc.getDoseHighUnit());
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }*/
//    private FrameworkConnection fwConn;
	private FDBDataManager fwConn;
    private ScreenDrug drug;
    private Screening screening;
    private ScreenDrugs screenDrugsList;
 /*   private long ageindays;
    private double doseformhigh;
    private String doseformhighunit;
    private double doseformlow;
    private String doseformlowunit;
    private double dosehigh;
    private String dosehighunit;
    private double doselow;
    private String doselowunit;
    private double maxdailydoseform;
    private String maxdailydoseformunit;
    private double maxdailydose;
    private String maxdailydoseunit;*/
    private FDBDrugType drugType;
    private FDBDDIMSeverityFilter severityFilter;
    private boolean prospectiveOnlyAttribute;
    private boolean useCustomInteractionsAttribute;
	private HashMap DosageCheckMessages;
}
