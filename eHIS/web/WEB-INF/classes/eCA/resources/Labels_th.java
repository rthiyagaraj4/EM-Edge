/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           	created
18/11/2011    IN29412     Dinesh T    	AMS CRF
18/11/2011    IN29413     Dinesh T    	AMS CRF
15/12/2011    IN029312    Menaka V 	  	Incident No: IN029312 - <Report is printed either through
										order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
24/02/2012	  IN031116	  Ramesh G	  	Report header is overlapping the hospital letter heads & deliverable.
15/03/2012	 IN030419	  Menaka V	  	Clinical Note Logo Header and Report Header .	
26/09/2012	 IN035338     Nijithas	  	CRF-CA- AMS-CRF-0020 & Bru-HIMS-CRF-001/08 - Spell Check setup done in a facility is applied to all facilities.
04/03/2013	 IN037676	  Dinesh T		Signing the addendum is controlled by the note type parameter
05/04/2013	 IN039182	  Chowminya G	Restrict all users from result linking all diagnosis which are sensitive only in the clinical notes
12/17/2013	 IN040032	  Nijitha S		PMG20089-CRF-0890.2
07/01/2014   07012014     Nijitha		Changes suggested by sunil. 
22/01/2014   IN044246	  Chowminya		 Research Study rename to Patient Classification
02/04/2014	 IN048327	  Nijitha S		The Standard View heading is misspelled
21/03/2014	 IN034513	  Vijayakumar K 	SS-CRF-0007 In the patient Chart Clinician Access, the previous 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014  IN041284		Ramesh G	30/04/2014		Sunil KV      		The alignment for result Link for lab results in a clinical note section template does not display neatly .	
03/06/2014	IN037701		Chowminya		 								SKR-CRF-0036
19/08/2014	IN050593		Karthi L	19/08/2014		Akbar				The Label should be MDS Criteria Met and MDS Criteria Not Met.
01/04/2015	IN048704		Karthi L							 			Bed Side Referral
03/07/2015	IN052940		Ramesh G										In Clinical note there should be an option to auto fetch/Copy 
																			data from same template if filled up earlier for same patient in template format.
10/08/2015  IN056611		Akbar S										 	ML-BRU-SCF-1639
16/11/2015	IN057113		Karthi											ML-MMOH-CRF-0335 - IN057113  		
12/17/2015  IN058156		Prathyusha										Once encounter is closed, there is no way for the user to check if the clinical notes in
																			the event history has been forwarded or modified by another practitioner.  
17/12/2015     IN058148     Prathyusha   									Allow copy text from event history views  		
09/01/2016	IN057106		Vijayakumar K	09/01/2016		Ramesh Goli		ML-MMOH-CRF-0328 [IN:057106]		
11/01/2016	IN58138			Karthi L										Need to provide an alternative view to enable the quicksheet view by event and not by group.																			
05/02/2016	IN004500		Raja S											GHL-SCF-1000 	
29/02/2016	IN057106_changed Vijayakumar K	29/02/2016		Ramesh Goli		ML-MMOH-CRF-0328 files created newly
24/05/2016	IN055439		Karthi L										MO_CRF_20102
06/07/2016	IN059630		Krishna Gowtham									GHL-CRF-0401
01/07/2016	IN059489		Raja S											Require a provision for adding a full page diagonal ‘Draft’ watermark in template printout if it is not signed.[GHL-CRF-0400]
21/07/2016	IN052254		Ramesh Goli										MMS-QH-CRF-0204
20/02/2017	IN061882		Karthi L										ML-MMOH-CRF-0534 [IN061882]
26/04/2016	IN061907		Krishna Gowtham J								ML-MMOH-CRF-0559
10/05/2017	IN063865		Raja S			11/05/2017		Ramesh Goli		ML-MMOH-CRF-0534.1
18/05/2017  IN063798		Raja S			22/05/2017		Ramesh Goli		ML-MMOH-CRF-0807
13/07/2016	IN061885		Krishna Gowtham		13/07/2017		Ramesh G				ML-MMOH-CRF-0537
27/07/2017	IN061891		Raja S			27/07/2017		Ramesh G		ML-MMOH-CRF-0543
24/10/2017	IN065452		Krishna Gowtham	25/10/2017		Ramesh G		ML-MMOH-CRF-0566.2
06/11/2017	IN065070		Raja S			02/11/2017		Ramesh G		ML-MMOH-CRF-0623.1
07/11/2017	IN064342		Krishna Gowtham 07/11/2017		Ramesh G		ML-MMOH-CRF-0468.1
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)
22/01/2018  IN062606        Sharanraj       01/02/2018      Ramesh G        ML-MMOH-CRF-0726
12/02/2018  IN066645        Sharanraj       13/02/2018      Ramesh G        CA-ML-MMOH-CRF-0726/04
15/03/2018	IN066119		Raja S			15/03/2018		Ramesh G		ML-MMOH-CRF-1024
08/05/2018	IN066237	  	 Prakash C 			08/05/2018		Ramesh G	MMS-DM-CRF-0123
11/05/2018	IN063838		Ramesh G										ML-MMOH-CRF-0813
10/05/2018 IN065341             Sivabagyam M        10/05/2018  	Ramesh G        MMS-DM-CRF-0115
05/06/2018	IN67872			Dinesh T		05/06/2018	Ramesh G		GHL-CRF-0497.1	
07/08/2018	IN063818		Raja S			07/08/2018		Ramesh G		MMS-DM-CRF-0102
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
05/12/2018  IN059704        PRATHYUSHA   21/11/2018          Ramesh G      AAKH-CRF-0079.2
07/01/2019	IN069243		sivabagyam M 	07/01/2019		Ramesh G		MO-CRF-20101.2
17/01/2019  IN067541        sivabagyam   17/01/2019     Ramesh G         ML-MMOH-CRF-1159
18/12/2018   IN067236      	 Sivabagyam M	18/12/2018	Ramesh G	   ML-MMOH-CRF-1148
11/03/2019  IN069852		Raja S			11/03/2019  Ramesh G		JD-CRF-0206
9/03/2019	IN069244		SIVABAGYAM M			11/03/2019  Ramesh G		MMS-KH-CRF-0005.1
22/03/2019	IN069244		Ramya Maddena		  25/01/2019		Ramesh Goli	            MMS-KH-CRF-0005.1
20/06/2019	IN066005		SIVABAGYAM M    20/06/2019	Ramesh G		ML-BRU-CRF-0474
07/04/2019	IN070032	sivabagyam M 	07/04/2019		Ramesh G		MO-CRF-20101.6
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567	
29/01/2020  IN069384	SIVABAGYAM	M	29/01/2020		RAMESH G		AAKH-CRF-0097.1
06/04/2020	IN072674		Durga Natarajan		07/04/2020		Ramesh G		MMS-KH-CRF-0032
18/03/2020	IN071264		Nijitha S									GHL-CRF-0604
29/05/2020	IN069908		Durga Natarajan		29/05/2020		Ramesh G		ML-MMOH-CRF-1376
26/06/2020	IN072777		Durga Natarajan	    26/06/2020		Ramesh G	    AAKH-CRF-0097.2
06/08/2020  IN073540    	Chandrashekar                                       AAKH-CRF-0122.3
26/08/2020  IN010564    	Chandrashekar                                       AAKH-CRF-0122.3
20/10/2020  IN073108    Nijitha				20/10/2020       Ramesh G       ML-MMOH-CRF-1546
18/11/2020	7605			SIVABAGYAM M		18/11/2020		RAMESH G	PMG2020-COMN-CRF-0085	
19/04/2021	6484			Durga Natarajan		19/04/2021		RAMESH G	MO-CRF-20147.7 
14/07/2022  33870       Twinkle Shah        21/07/2022	    Ramesh G        ML-MMOH-CRF-1763
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
package eCA.resources;

import java.util.*;

public class  Labels_th  extends ListResourceBundle implements java.io.Serializable
{
	public Object[][] getContents() 
	{
         return contents;
    }
 
	static final Object[][] contents =
	{
	{"eCA.AbnormalValue.label","Abnormal Value"},
	{"eCA.AccessedAt.label","Accessed At"},
	{"eCA.AccidentEmergency.label","Accident & Emergency"},
	{"eCA.ActionBy.label","Action By"},
	{"eCA.AddComplaint.label","Add Complaint"},
	{"eCA.AddEncounterparameter.label","Add Encounter parameter"},
	{"eCA.AddNewPanel.label","Add New Panel"},
	{"eCA.AddNewRow.label","Add New Row"},
	{"eCA.AdhocIntervention.label","Adhoc Intervention"},
	{"eCA.AdmNo.label","Adm No"},
	{"eCA.AdmittedNewborn.label","Admitted Newborn"},
	{"eCA.AdmittedNewborns.label","Admitted Newborns"},
	{"eCA.AdmittedPeriod.label","Admitted Period"},
	{"eCA.AgeCommon.label","Age Common"},
	{"eCA.Alive.label","Alive"},
	{"eCA.AllClinics.label","All Clinics"},
	{"eCA.AllNursingUnits.label","All Nursing Units"},
	{"eCA.AllergicTo.label","Allergic To"},
	{"eCA.AllergyAssessment.label","Allergy Assessment"},
	{"eCA.AllergyList.label","Allergy List"},
	{"eCA.AllowDirect.label","Allow Direct"},
	{"eCA.Allowed.label","Allowed"},
	{"eCA.AllowedDocTypes.label","Allowed Doc Types"},
	{"eCA.AmendOriginalSection.label","Amend Original Section"},
	{"eCA.AmendError.label","Amend/Error"},
	{"eCA.AmendmentType.label","Amendment Type"},
	{"eCA.Anaesthetists.label","Anaesthetists"},
	{"eCA.ApplicableOnlyforTableFormat.label","Applicable Only for Table Format"},
	{"eCA.ApplicableTask.label","Applicable Task"},
	{"eCA.ApplicabletoProcedures.label","Applicable to Procedures"},
	{"eCA.ApplicationDetail.label","Application Detail"},
	{"eCA.ApplicationParameter.label","Application Parameter"},
	{"eCA.ApplicationSetup.label","Application Setup"},
	{"eCA.Arial.label","Arial"},
	{"eCA.ArialBlack.label","Arial Black"},
	{"eCA.ArialNarrow.label","Arial Narrow"},
	{"eCA.ArrivedatNS.label","Arrived at NS"},
	{"eCA.AssignCAMenu.label","Assign CA Menu"},
	{"eCA.AssignChartSummary.label","Assign Chart Summary"},
	{"eCA.AssignPatientRelationship.label","Assign Patient Relationship"},
	{"eCA.AssignRelationship.label","Assign Relationship"},
	{"eCA.AssociateLinking.label","Associate Linking"},
	{"eCA.AttachedSections.label","Attached Sections"},
	{"eCA.AttachedSectionsForType.label","Attached Sections For Note Type"},
	{"eCA.AttendingRelationship.label","Attending Relationship"},
	{"eCA.Author.label","Author"},
	{"eCA.AuthorbutwithoutAuthorizationFacility.label","Author but without Authorization Facility"},
	{"eCA.AuthorwithAuthorizationFacility.label","Author with Authorization Facility"},
	{"eCA.AvailableSections.label","Available Sections"},
	{"eCA.AwaitingReview.label","Awaiting Review"},
	{"eCA.AwaitingSign.label","Awaiting Completion"},
	{"eCA.Babiesof.label","Babies of"},
	{"eCA.Backdate.label","Backdate"},
	{"eCA.BackwardDischarge.label","Backward Discharge"},
	{"eCA.BackwardVisits.label","Backward Visits"},
	{"eCA.BaseURL.label","Base URL"},
	{"eCA.BlockID.label","Block ID"},
	{"eCA.BMICalculator.label","BMI Calculator"},
	{"eCA.BuildClinicalRepository.label","Build Clinical Repository"},
	{"eCA.BuildClinicalRepositoryForDirectRegn.label","Build Clinical Repository For Direct Regn"},
	{"eCA.ByPractitionerRights.label","By Practitioner Rights"},
	{"eCA.CAMenu.label","CA Menu"},
	{"eCA.CanAssign.label","Can Assign"},
	{"eCA.CanHold.label","Can Hold"},
	{"eCA.CanTerminate.label","Can Terminate"},
	{"eCA.CannedText.label","Canned Text"},
	{"eCA.CannedTextDescription.label","Canned Text Description"},
	{"eCA.CardiacIndex.label","Cardiac Index"},
	{"eCA.Centigrade.label","Centigrade"},
	{"eCA.CentigradetoFahrenheit.label","Centigrade to Fahrenheit"},
	{"eCA.Cerebralperfusionpressure.label","Cerebral perfusion pressure"},
	{"eCA.ChangeFileReference.label","Change File Reference"},
	{"eCA.ChartApplicability.label","Chart Applicability"},
	{"eCA.ChartCode.label","Chart Code"},
	{"eCA.ChartComponentAddPanel.label","Chart Component Add Panel"},
	{"eCA.ChartComponentHeader.label","Chart Component Header"},
	{"eCA.ChartComponentList.label","Chart Component List"},
	{"eCA.ChartComponents.label","Chart Components"},
	{"eCA.ChartEvents.label","Chart Events"},
	{"eCA.ChartQueryResult.label","Chart Query Result"},
	{"eCA.ChartRecordingControls.label","Chart Recording Controls"},
	{"eCA.ChartRecordingErrorList.label","Chart Recording Error List"},
	{"eCA.ChartRecordingViewErrorResults.label","Chart Recording View Error Results"},
	{"eCA.ChartRecordingViewErrorsToolBar.label","Chart Recording View Errors Tool Bar"},
	{"eCA.ChartSetup.label","Chart Setup"},
	{"eCA.ChartSetUpIntermediate.label","Chart SetUp Intermediate"},
	{"eCA.ChartSetUpIntermediateUpdateComponentTable.label","Chart SetUp Intermediate Update Component Table"},
	{"eCA.ChartSummaryContent.label","Chart Summary Content"},
	{"eCA.ChartSummaryTemplate.label","Chart Summary Template"},
	{"eCA.ChartSummaryTemplatePreviewof.label","Chart Summary Template Preview of"},
	{"eCA.ChartTemplateCreate.label","Chart Template Create"},
	{"eCA.ChartAddmodify.label","ChartAddmodify"},
	{"eCA.ChartComponentAddNew.label","Chart Component Add New"},
	{"eCA.ChartMain.label","Chart Main"},
	{"eCA.ChartSummaryCareFlowsheet.label","Chart Summary Care Flowsheet"},
	{"eCA.ChatPage.label","Chat Page"},
	{"eCA.Checked.label","Checked"},
	{"eCA.ChiefComplaintSearch.label","Chief Complaint Search"},
	{"eCA.ChiefComplaintSection.label","Chief Complaint Section"},
	{"eCA.ChiefComplaints.label","Chief Complaints"},
	{"eCA.ChiefComplaintMaster.label","ChiefComplaint Master"},
	{"eCA.Clickheretocollapsethecolumn.label","Click here to collapse the column"},
	{"eCA.Clickheretoview.label","Click here to view"},
	{"eCA.ClickheretoviewSecondaryResources.label","Click here to view Secondary Resources."},
	{"eCA.ClicktoAuthorize.label","Click to Authorize"},
	{"eCA.ClicktoNormalize.label","Click to Normalize"},
	{"eCA.ClinicCommon.label","Clinic Common"},
	{"eCA.ClinicEventParam.label","Clinic Event Param"},
	{"eCA.ClinicalCalculator.label","Clinical Calculator"},
	{"eCA.ClinicalEventGroup.label","Clinical Event Group"},
	{"eCA.ClinicalEventMaster.label","Clinical Event Master"},
	{"eCA.ClinicalEventParameter.label","Clinical Event Parameter"},
	{"eCA.ClinicalEvents.label","Clinical Events"},
	{"eCA.ClinicalNoteDetails.label","Clinical Note Details"},
	{"eCA.ClinicalNoteStatusDetails.label","Clinical Note Status Details"},
	{"eCA.ClinicianAccessRichTextEditor.label","Clinician Access - Rich Text Editor"},
	{"eCA.ClinicianDesktop.label","Clinician Desktop"},
	{"eCA.Clinics.label","Clinics"},
	{"eCA.CloseDate.label","Close Date"},
	{"eCA.CloseDetails.label","Close Details"},
	{"eCA.Column.label","Column"},
	{"eCA.ComicSansMS.label","Comic Sans MS"},
	{"eCA.ComplaintDescription.label","Complaint Description"},
	{"eCA.ComplaintDetails.label","Complaint Details"},
	{"eCA.ComplaintDetailsfor.label","Complaint Details for"},
	{"eCA.ComplaintID.label","Complaint ID"},
	{"eCA.ComplaintText.label","Complaint Text"},
	{"eCA.ComponentDescription.label","Component Description"},
	{"eCA.ConsEndDate.label","Cons End Date"},
	{"eCA.ConsInProgress.label","Cons. in Progress"},
	{"eCA.ConstantValue.label","Constant Value"},
	{"eCA.ConstructCAMenu.label","Construct CA Menu"},
	{"eCA.ContentDescription.label","Content Description"},
	{"eCA.ContrSystem.label","Contr System"},
	{"eCA.CourierNew.label","Courier New"},
	{"eCA.CreateNewAddendum.label","Create New Addendum"},
	{"eCA.Creatinineclearance.label","Creatinine clearance"},
	{"eCA.CriticalValue.label","Critical Value"},
	{"eCA.CurrentChiefComplaint.label","Current Chief Complaint"},
	{"eCA.DataSet.label","Data Set"},
	{"eCA.DayAfterAdmit.label","Day After Admit"},
	{"eCA.DayAfterEffect.label","Day After Effect"},
	{"eCA.DayAfterTransfer.label","Day After Transfer"},
	{"eCA.DaySummaryPeriodFrom.label","Day Summary Period From"},
	{"eCA.DefaultFromHistory.label","Default From History"},
	{"eCA.DefineChartScope.label","Define Chart Scope"},
	{"eCA.DefineChiefComplaint.label","Define Chief Complaint"},
	{"eCA.DefineMenu.label","Define Menu"},
	{"eCA.DefinePersonalizedHomePage.label","Define Personalized Home Page"},
	{"eCA.DeltaValue.label","Delta Value"},
	{"eCA.Desktop.label","Desktop"},
	{"eCA.DetailsofErrorRemarks.label","Details of Error Remarks"},
	{"eCA.DiagID.label","Diag ID"},
	{"eCA.DiagType.label","Diag Type"},
	{"eCA.Diagnosisfor.label","Diagnosis for"},
	{"eCA.DiagnosisforChiefComplaint.label","Diagnosis for Chief Complaint"},
	{"eCA.DiagnosisForCurrentChiefComplaint.label","Diagnosis For Current Chief Complaint"},
	{"eCA.DiastolicBloodPressure.label","Diastolic Blood Pressure"},
	{"eCA.DictationWindow.label","Dictation Window"},
	{"eCA.DirectIndirectSettings.label","Direct/Indirect Settings"},
	{"eCA.Disable.label","Disable"},
	{"eCA.Disclaimer.label","Disclaimer"},
	{"eCA.DisclaimerText.label","Disclaimer Text"},
	{"eCA.DiscreteMeasureSearch.label","Discrete Measure Search"},
	{"eCA.DisplayOrderSequence.label","Display Order Sequence"},
	{"eCA.DisplayRecords.label","Display Records"},
	{"eCA.DocumentLinkedNote.label","Document Linked Note"},
	{"eCA.DosageDetails.label","Dosage Details"},
	{"eCA.DrugDuration.label","Drug Duration"},
	{"eCA.EncounterParameter.label","Encounter Parameter"},
	{"eCA.EncounterRadioButtons.label","Encounter Radio Buttons"},
	{"eCA.EncounterSummary.label","Encounter Summary"},
	{"eCA.Encounters.label","Encounters"},
	{"eCA.EndingTime.label","Ending Time"},
	{"eCA.ErrorMarkedBy.label","Error Marked By"},
	{"eCA.EstablishRelationship.label","Establish Relationship"},
	{"eCA.EventCaptions.label","Event Captions"},
	{"eCA.EventCode.label","Event Code"},
	{"eCA.EventDate.label","Event Date"},
	{"eCA.EventGroup.label","Event Group"},
	{"eCA.EventItem.label","Event Item"},
	{"eCA.EventSetup.label","Event Setup"},
	{"eCA.EventTypeParameter.label","Event Type Parameter"},
	{"eCA.EventsFlowSheet.label","Events Flow Sheet"},
	{"eCA.ExtAppParamPanel.label","Ext App Param Panel"},
	{"eCA.ExternalApplicationDetail.label","External Application Detail"},
	{"eCA.ExternalID.label","External ID"},
	{"eCA.ExternalName.label","External Name"},
	{"eCA.ExtremeObesity.label","Extreme Obesity 40 to 50"},
	{"eCA.Fahrenheit.label","Fahrenheit"},
	{"eCA.FahrenheittoCentigrade.label","Fahrenheit to Centigrade"},
	{"eCA.FileReference.label","File Reference"},
	{"eCA.FileSizeLimit.label","File Size Limit"},
	{"eCA.FirstOperand.label","First Operand"},
	{"eCA.FlowSheet.label","Flow Sheet"},
	{"eCA.FlowSheetApplicability.label","Flow Sheet Applicability"},
	{"eCA.FlowSheetComponent.label","Flow Sheet Component"},
	{"eCA.FlowSheetID.label","Flow Sheet ID"},
	{"eCA.FlowSheets.label","Flow Sheets"},
	{"eCA.FomulaConstructionForSummary.label","Fomula Construction For Summary"},
	{"eCA.Font.label","Font"},
	{"eCA.FormulaConstruction.label","Formula Construction"},
	{"eCA.FormulaDefinition.label","Formula Definition"},
	{"eCA.FormulaDefinitionForChartComponents.label","Formula Definition For Chart Components"},
	{"eCA.ForwardTo.label","Forward To"},
	{"eCA.FromSection.label","From Section"},
	{"eCA.FunctionOptions.label","Function Options"},
	{"eCA.FutureFuture.label","Future-Future"},
	{"eCA.FutureAppointments.label","Future Appointments"},
	{"eCA.FutureReferrals.label","Future Referrals"},
	{"eCA.Garamond.label","Garamond"},
	{"eCA.GlomerularFiltrationRate.label","Glomerular Filtration Rate"},
	{"eCA.Graph.label","Graph"},
	{"eCA.GroupButtons.label","Group Buttons"},
	{"eCA.GroupNames.label","Group Names"},
	{"eCA.Groups.label","Groups"},
	{"eCA.GuideLines.label","Guide Lines"},
	{"eCA.Heading.label","Heading "},
	{"eCA.HintMessage.label","Hint Message"},
	{"eCA.HistoryRecordType.label","History Record Type"},
	{"eCA.HistoryRecordTypes.label","History Record Types"},
	{"eCA.HourAfterAdmit.label","Hour After Admit"},
	{"eCA.HourAfterEffect.label","Hour After Effect"},
	{"eCA.HourAfterTransfer.label","Hour After Transfer"},
	{"eCA.HPI.label","HPI"},
	{"eCA.ImageForSection.label","Image For Section"},
	{"eCA.ImageLinked.label","Image Linked"},
	{"eCA.ImageReference.label","Image Reference"},
	{"eCA.ImageReferenceID.label","Image Reference ID"},
	{"eCA.ImmunizationDetails.label","Immunization Details"},
	{"eCA.Impression.label","Impression"},
	{"eCA.IncludeonlythefilledComponents.label","Include only the filled Components"},
	{"eCA.IncludesDate.label","Includes Date"},
	{"eCA.Indication.label","Indication"},
	{"eCA.InsertLeft.label","Insert Left"},
	{"eCA.InsertRight.label","Insert Right"},
	{"eCA.InterventionDetails.label","Intervention Details"},
	{"eCA.Intracranialpressure.label","Intracranial pressure"},
	{"eCA.IPAdmit.label","IP Admit"},
	{"eCA.IPEnc.label","IP Enc"},
	{"eCA.Kilogram.label","Kilogram"},
	{"eCA.KilogramtoPounds.label","Kilogram to Pounds"},
	{"eCA.LifeTime.label","Life Time"},
	{"eCA.LimitPractitionerListtoAccessLocation.label","Limit Practitioner List to Access Location"},
	{"eCA.LimittoCurrentEncounter.label","Limit to Current Encounter"},
	{"eCA.LinkHistoryElementsFor.label","Link History Elements For"},
	{"eCA.LinkResultDocuments.label","Link Result Documents"},
	{"eCA.LinkingImagesForSection.label","Linking Images For Section"},
	{"eCA.LinkingListItems.label","Linking List Items"},
	{"eCA.ListText.label","List Text"},
	{"eCA.LMP.label","LMP"},
	{"eCA.LocationforPractitioner.label","Location for Practitioner"},
	{"eCA.LocationTypeFrom.label","Location Type From"},
	{"eCA.Long.label","Long"},
	{"eCA.LookUpfor.label","LookUp for"},
	{"eCA.LOS.label","LOS"},
	{"eCA.MainFrame.label","Main Frame"},
	{"eCA.MainSection.label","Main Section"},
	{"eCA.MainSectionCode.label","Main Section Code"},
	{"eCA.MainSectionDesc.label","Main Section Desc"},
	{"eCA.MarkallasError.label","Mark all as Error"},
	{"eCA.MarkedasErrorList.label","Marked as Error List"},
	{"eCA.MarkedforError.label","Marked for Error"},
	{"eCA.Meanarterialbloodpressure.label","Mean arterial blood pressure"},
	{"eCA.MeanBloodPressure.label","Mean Blood Pressure"},
	{"eCA.MedicalEvents.label","Medical Events"},
	{"eCA.MenuOptions.label","Menu Options"},
	{"eCA.MenuStructure.label","Menu Structure"},
	{"eCA.Minus.label","Minus"},
	{"eCA.MothersBed.label","Mothers Bed#"},
	{"eCA.MothersID.label","Mothers ID"},
	{"eCA.MotherLinkExists.label","Mother Link Exists"},
	{"eCA.Motherof.label","Mother of"},
	{"eCA.NewBornList.label","New Born List"},
	{"eCA.NewBornEncounterID.label","NewBorn Encounter ID"},
	{"eCA.NewBornID.label","NewBorn ID"},
	{"eCA.NewBornLocation.label","NewBorn Location"},
	{"eCA.NewBornName.label","NewBorn Name"},
	{"eCA.NewFileReference.label","New File Reference"},
	{"eCA.NoofRows.label","No. of Rows"},
	{"eCA.NonCritical.label","Non Critical"},
	{"eCA.Normal185to24.label","Normal 18.5 to 24"},
	{"eCA.Normal25to36LminM2.label","Normal  2.5 to 3.6 L / min / M2"},
	{"eCA.NormalInd.label","Normal Ind"},
	{"eCA.NormalmeanBPis93.3mmHg.label","Normal mean BP is 93.3 mmHg"},
	{"eCA.NormalRange.label","Normal Range"},
	{"eCA.NormalcyStatus.label","Normalcy Status"},
	{"eCA.NotAllowed.label","Not Allowed"},
	{"eCA.NoteDisclaimer.label","Note Disclaimer"},
	{"eCA.NoteGroup.label","Note Group"},
	{"eCA.NoteImageList.label","Note Image List"},
	{"eCA.Noteparameter.label","Note parameter"},
	{"eCA.NoteTitle.label","Note Title"},
	{"eCA.NoteTypebyService.label","Note Type by Service"},
	{"eCA.NoteTypeForResponosibilityDetails.label","Note Type For Responosibility Details"},
	{"eCA.NoteTypeForResponosibilityHeader.label","Note Type For Responosibility Header"},
	{"eCA.NoteTypeForResponosibilityResults.label","Note Type For Responosibility Results"},
	{"eCA.NoteTypeforResponsibility.label","Note Type for Responsibility"},
	{"eCA.NoteTypeFrom.label","Note Type From"},
	{"eCA.NoteTypeSection.label","Note Type Section"},
	{"eCA.NoteTypes.label","Note Types"},
	{"eCA.NOTESHEADERINFORMATION.label","NOTES HEADER INFORMATION"},
	{"eCA.Notescontent.label","Notes content"},
	{"eCA.NotesPrintPreviewView.label","Notes PrintPreview View"},
	{"eCA.NumofNotePerEncounter.label","Num of Note Per Encounter"},
	{"eCA.NurseRelation.label","Nurse Relation"},
	{"eCA.NursingUnits.label","Nursing Units"},
	{"eCA.Onset.label","Onset"},
	{"eCA.OnsetDetails.label","Onset Details"},
	{"eCA.OPVisit.label","OP Visit"},
	{"eCA.OrderSequenceNumber.label","Order Sequence No"},
	{"eCA.OSCCMLCCase.label","OSCC / MLC Case"},
	{"eCA.Overweight25to29.label","Overweight   25 to 29"},
	{"eCA.Paragraph.label","Paragraph"},
	{"eCA.ParsingSectionTemplate.label","Parsing Section Template"},
	{"eCA.PastVisits.label","Past Visits"},
	{"eCA.PatientChartSummaryTemplatePreview.label","Patient Chart Summary Template Preview"},
	{"eCA.PatientProfile.label","Patient Profile"},
	{"eCA.PatientProfileContent.label","Patient Profile Content"},
	{"eCA.PatientRelatedTreatments.label","Patient Related Treatments"},
	{"eCA.Percentage.label","Percentage"},
	{"eCA.PerformedDetails.label","Performed Details"},
	{"eCA.PeriodRange.label","Period Range"},
	{"eCA.PersonalizedHomePage.label","Personalized Home Page"},
	{"eCA.PlasmaCreatinine.label","Plasma Creatinine"},
	{"eCA.Plus.label","Plus"},
	{"eCA.PostProcedureStdOrders.label","Post Procedure Std. Orders"},
	{"eCA.Pounds.label","Pounds"},
	{"eCA.PoundstoKilogram.label","Pounds to Kilogram"},
	{"eCA.PractitionerHomePage.label","Practitioner Home Page"},
	{"eCA.PreImage.label","Pre Image"},
	{"eCA.PreconditionforRecording.label","Precondition for Recording"},
	{"eCA.PreserveTemplateFormat.label","Preserve Template Format"},
	{"eCA.PreviewNotes.label","Preview Notes"},
	{"eCA.PrintDischargeSummaryHeader.label","Print Discharge Summary Header"},
	{"eCA.ProblemDetails.label","Problem Details"},
	{"eCA.ProcedureApplicable.label","Procedure Applicable"},
	{"eCA.ProcedureSet.label","Procedure Set"},
	{"eCA.ProcedureSummary.label","Procedure Summary"},
	{"eCA.ProceduresIntermediate.label","Procedures Intermediate"},
	{"eCA.ProfileContent.label","Profile Content"},
	{"eCA.PromptText.label","Prompt Text"},
	{"eCA.PublishLevel.label","Publish Level"},
	{"eCA.QuickText.label","Quick Text"},
	{"eCA.Relink.label","Re link"},
	{"eCA.RebuildSectionTemplate.label","Rebuild Section Template"},
	{"eCA.RecDate.label","Rec Date"},
	{"eCA.ReceiveMessage.label","Receive Message"},
	{"eCA.RecordClinicalNotesToolbar.label","Record Clinical Notes Toolbar"},
	{"eCA.RecordedClosedBy.label","Recorded/Closed By"},
	{"eCA.RecordingClinicalNotes.label","Recording Clinical Notes"},
	{"eCA.RedCellVolumeinAdultsbasedonBodySurfaceArea.label","Red Cell Volume in Adults based on Body Surface Area"},
	{"eCA.RedefineCAOption.label","Redefine CA Option"},
	{"eCA.RefDate.label","Ref Date"},
	{"eCA.ReferenceRange.label","Reference Range"},
	{"eCA.ReferralRelation.label","Referral Relation"},
	{"eCA.ReferralReln.label","Referral Reln"},
	{"eCA.ReferralsMadeTo.label","Referrals Made To"},
	{"eCA.RelatedPatientHistoryCriteria.label","Related Patient History Criteria"},
	{"eCA.RelationshipforResponsibility.label","Relationship for Responsibility"},
	{"eCA.RelationshipID.label","Relationship ID"},
	{"eCA.RelationshipName.label","Relationship Name"},
	{"eCA.RelationshipPeriod.label","Relationship Period"},
	{"eCA.ReplaceRemarks.label","Replace Remarks"},
	{"eCA.ReportHeader.label","Report Header"},
	{"eCA.RequestedAt.label","Requested At"},
	{"eCA.ResearchCategory.label","Research Category"},
	{"eCA.ResearchCategoryDescription.label","Research Category Description"},
	{"eCA.ResearchCategoryID.label","Research Category ID"},
	{"eCA.ResearchDescription.label","Research Description"},
	{"eCA.ResearchInfo.label","Research Info"},
	{"eCA.ResearchPatient.label","Research Patient"},
	{"eCA.ResearchPatientCategory.label","Research Patient Category"},
	{"eCA.ResearchRemarks.label","Research Remarks"},
	{"eCA.ResultCategory.label","Result Category"},
	{"eCA.Resultlinked.label","Result linked"},
	{"eCA.ReturnfromInvest.label","Return from Invest"},
	{"eCA.ReviewNotes.label","Review Notes"},
	{"eCA.ReviewResults.label","Review Results"},
	{"eCA.ReviewedBy.label","Reviewed By"},
	{"eCA.ReviewerPrivilegeforVerifyingandAuthorization.label","Reviewer Privilege for Verifying and Authorization"},
	{"eCA.RichTextEditorandMEDIPainter.label","Rich Text Editor and MEDIPainter"},
	{"eCA.RichTextEditorforSectionTemplateLongText.label","Rich Text Editor for Section Template Long Text"},
	{"eCA.Row.label","Row"},
	{"eCA.SansSerif.label","Sans Serif"},
	{"eCA.SecondOperand.label","Second Operand"},
	{"eCA.SectionforNoteType.label","Section for Note Type"},
	{"eCA.SectionHeading.label","Section Heading"},
	{"eCA.SectionScope.label","Section Scope"},
	{"eCA.SectionStartsWith.label","Section Starts With"},
	{"eCA.SectionTemplate.label","Section Template"},
	{"eCA.SectionTemplateToolbar.label","Section Template Toolbar"},
	{"eCA.SectionsForChart.label","Sections For Chart"},
	{"eCA.Serumcreatinine.label","Serum creatinine"},
	{"eCA.ServiceName.label","Service Name"},
	{"eCA.ServiceFacilitySpecific.label","Service/Facility Specific"},
	{"eCA.Services.label","Services"},
	{"eCA.ShiftRows.label","Shift Rows"},
	{"eCA.ShiftthisRowby.label","Shift this Row by"},
	{"eCA.Short.label","Short"},
	{"eCA.ShowNotes.label","Show Notes"},
	{"eCA.SignNotes.label","Sign Notes"},
	{"eCA.Size.label","Size"},
	{"eCA.SpecialityDesc.label","Speciality Desc"},
	{"eCA.SpecialtySpecificIndirectRelationship.label","Speciality Specific Indirect Relationship"},
	{"eCA.SpecimenSent.label","Specimen Sent"},
	{"eCA.StartingTime.label","Starting Time"},
	{"eCA.Statuschattingwith.label","Status: chatting with"},
	{"eCA.SubSectionCode.label","Sub Section Code"},
	{"eCA.SubSectionDescription.label","Sub Section Description"},
	{"eCA.SubSectionMain.label","Sub Section Main"},
	{"eCA.Subject.label","Subject"},
	{"eCA.SubSectionforMainSection.label","SubSection for Main Section"},
	{"eCA.SubSectionsfor.label","SubSections for"},
	{"eCA.SUM.label","SUM"},
	{"eCA.SummaryBy.label","Summary By"},
	{"eCA.SummaryColumn.label","Summary Column"},
	{"eCA.SummaryDesc.label","Summary Desc"},
	{"eCA.SummaryID.label","Summary ID"},
	{"eCA.SummaryLegend.label","Summary Legend"},
	{"eCA.SummaryRequired.label","Summary Required"},
	{"eCA.SummaryType.label","Summary Type"},
	{"eCA.SupportingDiagCode.label","Supporting Diag Code"},
	{"eCA.SwitchOptions.label","Switch Options"},
	{"eCA.SystolicBloodPressure.label","Systolic Blood Pressure"},
	{"eCA.Tableforchat.label","Table for chat"},
	{"eCA.TaskDesc.label","Task Desc"},
	{"eCA.TaskforRespMainFrame.label","Task for Resp Main Frame"},
	{"eCA.TaskForResponosibilityRelationshipDetails.label","Task For Responosibility / Relationship Details"},
	{"eCA.TaskForResponosibilityRelationshipHeader.label","Task For Responosibility / Relationship Header"},
	{"eCA.TaskForResponsibilityRelationship.label","Task For Responsibility/Relationship"},
	{"eCA.TaskID.label","Task ID"},
	{"eCA.TaskType.label","Task Type"},
	{"eCA.TasksSearch.label","Tasks Search"},
	{"eCA.TemplateBased.label","Template Based"},
	{"eCA.TerminateRelation.label","Terminate Relation"},
	{"eCA.TextBlockID.label","Text Block ID"},
	{"eCA.ThisEncounterisnotaReferral.label","This Encounter is not a Referral"},
	{"eCA.TimesNewRoman.label","Times New Roman"},
	{"eCA.TitleValue.label","Title Value"},
	{"eCA.ToSection.label","To Section"},
	{"eCA.Tools.label","Tools"},
	{"eCA.Transcriber.label","Transcriber"},
	{"eCA.TraumaCaseDetail.label","Trauma Case Detail"},
	{"eCA.TriageDetail.label","Triage Detail"},
	{"eCA.Unchecked.label","Unchecked"},
	{"eCA.UserDefinedDescription.label","User Defined Description"},
	{"eCA.UserTree.label","UserTree"},
	{"eCA.Verdana.label","Verdana"},
	{"eCA.ViewErrorDocuments.label","View Error Documents"},
	{"eCA.ViewList.label","View List"},
	{"eCA.ViewonlyPrivilege.label","View only Privilege"},
	{"eCA.ViewPatientListbyLocation.label","View Patient List by Location"},
	{"eCA.ViewPatientListbyMedicalService.label","View Patient List by Medical Service"},
	{"eCA.ViewPatientListbyProviderService.label","View Patient List by Provider Service"},
	{"eCA.ViewReferralDetails.label","View Referral Details"},
	{"eCA.ViewClinicalNote.label","View Clinical Note"},
	{"eCA.VisitAdmCloseDate.label","Visit Adm Close Date"},
	{"eCA.VisitAdmEndDate.label","Visit Adm End Date"},
	{"eCA.VisitCloseDate.label","Visit Close Date"},
	{"eCA.VSRecorded.label","VS Recorded"},
	{"eCA.Wingdings.label","Wingdings"},
	{"eCA.XSLfolder.label","XSL folder"},
	{"eCA.Constant.label","CONSTANT"},
	{"eCA.FlowSheetView.label","Flow Sheet View"},
	{"eCA.NormalCPP.label","Normal CPP :"},
	{"eCA.TypeYourMessagehere.label","Type Your Message here "},
	{"eCA.BuildingNotes.label","Building Notes"},
	{"eCA.AddendumToNote.label","Addendum To Note"},
	{"eCA.NewbornExists.label","Newborn Exists"},
	{"eCA.NoPPRelationship.label","No PP Relationship"},
	{"eCA.SelectedEncounter.label","Selected Encounter"},
	{"eCA.ActiveOnly.label","Active Only"},
	{"eCA.AddNewComments.label","Add New Comments"},
	{"eCA.AddYourAddendumBelow.label","Add Your Addendum Below"},
	{"eCA.AllNotes.label","All Notes"},
	{"eCA.ApplicationTask.label","Application Task"},
	{"eCA.AssociatedContributingEvents.label","Associated Contributing Events"},
	{"eCA.AssociatedEventGroups.label","Associated Event Groups"},
	{"eCA.BMIValue.label","BMI Value"},
	{"eCA.CHARTSUMMARY.label","CHART SUMMARY"},
	{"eCA.CheckBox.label","Check-Box"},
	{"eCA.Comment.label","Comment"},
	{"eCA.CommonRemarks.label","Common Remarks"},
	{"eCA.Constants.label","Constants"},
	{"eCA.CurrentlySelectedComponentismarkedforrepositioning.label","Currently Selected Component is marked for repositioning."},
	{"eCA.DefineRedifineFormulaSection.label","Define/Redifine Formula  Section :"},
	{"eCA.Detailsason.label","Details as on"},
	{"eCA.ErrorDetails.label","Error Details"},
	{"eCA.ErrorMarkedDate.label","Error Marked Date"},
	{"eCA.ExistingComments.label","Existing Comments"},
	{"eCA.EXTERNALAPPLICATION.label","EXTERNAL APPLICATION"},
	{"eCA.FinalSelection.label","Final Selection"},
	{"eCA.FrequencywithDurationvalue.label","Frequency with Duration value"},
	{"eCA.HOMEPAGE.label","HOME PAGE"},
	{"eCA.IBAHealth.label","IBA Health"},
	{"eCA.Immunization.label","Immunization"},
	{"eCA.Impressions.label","Impressions"},
	{"eCA.LastRecordedDateTime.label","Last Recorded Date Time :"},
	{"eCA.LinkedParameters.label","Linked Parameters"},
	{"eCA.LOCATIONACCESS.label","LOCATION ACCESS"},
	{"eCA.Men.label","Men"},
	{"eCA.MySchedules.label","My Schedules"},
	{"eCA.MyTaskList.label","My Task List"},
	{"eCA.NormalcyIndication.label","Normalcy Indication"},
	{"eCA.NoteTypeDesc.label","Note Type Desc"},
	{"eCA.NotesView.label","Notes View"},
	{"eCA.Obesity.label","Obesity"},
	{"eCA.OPBookings.label","OP Bookings"},
	{"eCA.Operators.label","Operators"},
	{"eCA.OTBookings.label","OT Bookings"},
	{"eCA.PARAMETER.label","PARAMETER"},
	{"eCA.PerfomedBy.label","Perfomed By"},
	{"eCA.PlacingOption.label","Placing Option"},
	{"eCA.PostProcStdOrders.label","Post  Proc. Std Orders"},
	{"eCA.ProcNarration.label","Proc Narration"},
	{"eCA.RecordingClinicalNotesTabs.label","Recording Clinical Notes - Tabs"},
	{"eCA.RedCellVolume.label","Red Cell Volume"},
	{"eCA.ReferralPatients.label","Referral Patients"},
	{"eCA.ReplaceValue.label","Replace Value"},
	{"eCA.ResultsforReview.label","Results for Review"},
	{"eCA.RichTextEditor.label","Rich Text Editor"},
	{"eCA.SelectSection.label","Select Section"},
	{"eCA.SelectDependentComponents.label","Select Dependent Components"},
	{"eCA.SelectSubSection.label","Select Sub Section"},
	{"eCA.SelectedForErrorAmend.label","Selected For Error/Amend"},
	{"eCA.SelectedItems.label","Selected Items"},
	{"eCA.Span.label","Span"},
	{"eCA.Nohistorydata.label","There is no history data found for last 24 hrs"},
	{"eCA.NoPatientcaredata.label","There is no Patientcare data found for last two encounters"},
	{"eCA.NoResultdata.label","There is no Result data found for last two encounters"},
	{"eCA.ViewAll.label","View All"},
	{"eCA.ViewPatientAllergyCriteriaJSP.label","View Patient AllergyCriteria"},
	{"eCA.ViewPatientListbyLocationResultMain.label","View Patient List by Location Result "},
	{"eCA.ViewPatientListbyMedServiceResultMain.label","View Patient List by MedService Result Main"},
	{"eCA.Women.label","Women "},
	{"eCA.NumberofUsers.label","Number of Users"},
	{"eCA.Restrict.label","Restrict"},
	{"eCA.PrevNotes.label","Prev Notes"},
	{"eCA.LinkDoc.label","Link Doc"},
	{"eCA.HideHeader.label","Hide Header"},
	{"eCA.ViewPatientListbyPPRelationResult.label","View Patient List by PPRelation Result"},
	{"eCA.HealthNewBorns.label","Healthy New Borns"},
	{"eCA.HealthNewBorn.label","Healthy New Born"},
	{"eCA.MothersName.label","Mother's Name"},
	{"eCA.DuetoExpireExpired.label","Due to Expire / Expired"},
	{"eCA.PendingSignature.label","Pending Signature"},
	{"eCA.PendingReview.label","Pending Review"},
    {"eCA.ViewPatientProviderRelation.label","View Patient Provider Relation"},
	{"eCA.CarePendSch.label","Care Pending Schedule"},
	{"eCA.BirthRegister.label","Birth Register"},
	{"eCA.MoreDtlRef.label","More Dtl..."},
	{"eCA.Viewgraph.label","View Graph"},
	{"eCA.ModifyScope.label","Modify Scope"},
	{"eCA.SelectedSubSections.label","Selected Sub Sections"},
	{"eCA.NoofColumns.label","No of Columns"},
	{"eCA.Configuration.label","Configuration"},
	{"eCA.Showdetail.label","Show Detail"},
	{"eCA.PreviewTemplate.label","Preview Template"},
	{"eCA.CollapseAll.label","Collapse All"},
	{"eCA.DefaultMenu.label","Default Menu"},
	{"eCA.Validate.label","Validate"},
	{"eCA.LinkHistory.label","Link History"},
	{"eCA.Upload.label","Upload"},
	{"eCA.Backward.label","Backward"},
	{"eCA.ShowHeader.label","Show Header"},
	{"eCA.ShowImage.label","Show Image"},
	{"eCA.ShowBoth.label","Show Both"},
	{"eCA.ShowEditor.label","Show Editor"},
	{"eCA.AcrossEncounter.label","Across Encounter"},
	{"eCA.MotherDetail.label","Mother Detail"},
	{"eCA.GestationalPeriod.label","Gestational Period"},
	{"eCA.Calculate.label","Calculate"},
	{"eCA.CardiacOutput.label","Cardiac Output"},
	{"eCA.Zoom.label","Zoom"},
	{"eCA.ViewErrorList.label","View Error List"},
	{"eCA.Send.label","Send"},
	{"eCA.Better.label","Better"},
	{"eCA.Worse.label","Worse"},
	{"eCA.Medications.label","Medications"},
	{"eCA.PatientMarkers.label","Patienet Markers"},
	{"eCA.Show.label","Show"},
	{"eCA.SignOut.label","Sign Out"},
	{"eCA.NoDataForEventInGraph.label","For this Event there is no value to display in graph "},
	{"eCA.IncudeOthersUnsignedNotes.label","Include Others' Unsigned Notes"},
    {"eCA.ComplaintBased.label","Complaint Based"},
	{"eCA.DAPrepared.label","Discharge Advice Prepared"},
	{"eCA.DiagnosisRec.label","Diagnosis Recorded"},
	{"eCA.BedAssigned.label","Bed Assigned"},
	{"eCA.QNo.label","Q.No"},
	{"eCA.QPr.label","Q/Pr"},
	{"eCA.Signed.label","Signed"},
	{"eCA.MarkedasError.label","Marked as Error"},
	{"eCA.ShowSelectedItem.label","Show Selected Item"},
	{"eCA.DaySummary.label","Day Summary"},
	{"eCA.DaySum.label","DAY/SUM"},
	{"eCA.EventGroupCode.label","Event Group Code"},
	{"eCA.FileUpload.label","File Upload"},
	{"eCA.ContributingSystem.label","Contra System"},
	{"eCA.MarkasError.label","Mark as Error"},
	{"eCA.RemarksforModify.label","Remarks for Modify "},
	{"eCA.ForwardNotesTo.label","Forward Notes To"},
	{"eCA.AddendumCreatedBy.label","Addendum Created By"},
	{"eCA.AVG.label","AVG"},
	//{"eCA.CorkCroft.label","CorkCroft"},
	{"eCA.CorkCroft.label","CockCroft"},
	{"eCA.Axis.label","Axis"},
	{"eCA.KeyValue.label","Key Value"},
	{"eCA.Static.label","Static"},
	{"eCA.IntervalBased.label","Interval based"},
	{"eCA.Median.label","Median"},
	{"eCA.Trans.label","Trans"},
	{"eCA.AddRows.label","Add Rows"},
	{"eCA.PastRecords.label","Past Records"},
	{"eCA.PastRecordsScope.label","Past Records Scope"},
	//{"eCA.StandardView.label","Standared View"},//IN048327
	{"eCA.StandardView.label","Standard View"},//IN048327
	{"eCA.Graphs.label","Graphs"},
	{"eCA.RegularGraph.label","Regular Graph"},
	{"eCA.SpecialGraph.label","Special Graph"},
	{"eCA.SpecialChartLinks.label","Special Chart Links"},
	{"eCA.SpecificView.label","Specific View"},
	{"eCA.CustomView.label","Custom View"},
	{"eCA.GroupingEvents.label","Grouping Events"},
	{"eCA.SpecialChartKey.label","Special Chart Key"},
	{"eCA.SpecialChartGraph.label","Special Chart Graph"},
	{"eCA.SpecialChartRef.label","Special Chart Ref"},
	{"eCA.GrowthChart.label","Growth Chart"},
	{"eCA.PRDetails.label","Patient Record Details"},
	{"eCA.CurrentQueue.label","Currenet Queue"},
	{"eCA.SpecialityEvent.label","Speciality Event"},
	{"eCA.ComparisionView.label","Comparision View"},
	{"eCA.ComparisionGraph.label","Comparision Graph"},
	{"eCA.GeneralGraph.label","General Graph"},
	{"eCA.OrderSequence.label","Order Sequence"},
	{"eCA.AutoClosePeriod.label","Auto Close Period"},
	{"eCA.AutoCloseType.label","Auto Close Type"}	 ,
	{"eCA.ForceClose.label","Force Close"}	,
	{"eCA.SpecialityTasksForEvents.label","Speciality Tasks For Events"},
	{"eCA.ClinicianAccessTasks.label","Clinician Access Tasks"},
	{"eCA.SpecialityEpisodeCycle.label","Speciality Episode Cycle"},
	{"eCA.EpisodeDescription.label","Episode Description"},
	{"eCA.EventTitleDescription.label","Event Title Description"},
	{"eCA.NoOfTransactionsAllowed.label","No Of Transactions Allowed"},
	{"eCA.AvailableTasks.label","Available Tasks"},
	{"eCA.SpecialtyTaskStartsWith.label","Speciality Task Starts With"},
	{"eCA.SpecialtyTaskDescription.label","Speciality Task Description"},
	{"eCA.SpecialtyTaskHeaderCode.label","Speciality Task Header Code"},
	{"eCA.SpecialtyEventOutcome.label","Speciality Event Outcome"},
	{"eCA.AvailableOutcomes.label","Available Outcomes"},
	{"eCA.AttachedOutcomes.label","Attached Outcomes"},
	{"eCA.CloseEpisode.label","Close Episode"}	,
	{"eCA.AttachedTasks.label","Attached Tasks"},
	{"eCA.Icon.label","Icon"},
	{"eCA.CurrentSelection.label","Current Selection"},
	{"eCA.ViewSpecialtyEventHistory.label","View Speciality Event History"},
	{"eCA.SpecialityMasterCode.label","Speciality Master Code"},
	{"eCA.MasterCategory.label","Master Category"}	,
	{"eCA.SpecialityAssesmentTask.label","Speciality Assesment Task"},
	{"eCA.Foetus.label","Foetus"},
	{"eCA.SpecialityEventDesc.label","Speciality Event Desc"},
	{"eCA.Cycle.label","Cycle"},
	{"eCA.tilldate.label","till date"} ,
	{"eCA.SelectCycle.label","Select Cycle"} ,
	{"eCA.ScrolltoCycle.label","Scroll to Cycle"} ,
	{"eCA.RecMaternityconsPrinting.label","RecMaternitycons Printing"},
	{"eCA.RecMaternityconsView.label","RecMaternityconsView"},
	{"eCA.NonSpecific.label","Non Specific"},
	{"eCA.RecMaternityConsMain.label","RecMaternityConsMain"},
	{"eCA.ClickHereToCreateaNewEvent.label","Click here to create a new event"},
	{"eCA.MaternityHomePage.label","Maternity Home Page"},
	{"eCA.ClickHereToViewTheGraph.label","Click here to view the Graph"},
	{"eCA.PrintHeaderLogo.label","Print Header Label"},
	{"eCA.PrintHeaderImageList.label","Print Header Image List"},
	{"eCA.ChangeIfPatIdGiven.label","Can change only if Patient ID is given"},
	{"eCA.NonEncSpecific.label","Non Enc Specific"},
	{"eCA.Inchs.label","Inchs"},
	{"eCA.SiteForVaccine.label","Site For Vaccine"},
	{"eCA.VaccineCategory.label","Vaccine Category"},
	{"eCA.CanBeUsedAsAdhoc.label","Can Be Used As Adhoc?"},
	{"eCA.DuplicateCheckRecquired.label","Duplicate Check Recquired?"},
	{"eCA.DuplicateCheckDays.label","Duplicate Check Days"},
	{"eCA.DuplicateCheckAction.label","Duplicate Check Action"},
	{"eCA.VaccinesForCategory.label","Vaccines For Category"},
	{"eCA.CategoryId.label","Category ID"},
	{"eCA.VaccineDescription.label","Vaccine Description"},
	{"eCA.SelectVaccine.label","Select Vaccine"},
	{"eCA.VaccineNoDoses.label","No. Of Doses"},
	{"eCA.VaccinePrevAdministered.label","Check Previous Administered"},
	{"eCA.VaccinePrevDays.label","Check Previous Days"},
	{"eCA.VaccinePreAction.label","Check Previous Action"},
	{"eCA.AllowMultiple.label","Allow Multiple"},
	{"eCA.VaccinationSchedule.label","Schedule For Vaccination"},
	{"eCA.SelectedSites.label","Selected Sites"},
	{"eCA.SelectSite.label","Select Site"},
	{"eCA.PendingReferrals.label","Pending Referrals"},
	{"eCA.ViewReferralPatientList.label","View Referral Patient List"},
	{"eCA.ActualDate.label","Actual Date"},
	{"eCA.AdministerDate.label","Administer Date"},
	{"eCA.BatchNumber.label","Batch Number"},
	{"eCA.AdministerDetails.label","Administer Details"},
	{"eCA.ExternalAdminister.label","External Administer"},
	{"eCA.CreatingUser.label","Creating User"},
	{"eCA.ExistingSchedules.label","Existing Schedules"},
	{"eCA.ReferralStatus.label","Referral Status"},
    {"eCA.ForAMonth.label","For a Month"},
	{"eCA.ForAPeriodRange.label","For a Period Range"},
	{"eCA.Consults.label","Consultation List"},
	{"eCA.StillbornDeceased.label","Stillborn/Deceased"},
	{"eCA.AllPatients.label","All Patients"},
	{"eCA.Future.label","Future"},
	{"eCA.TimeInterval.label","Time Interval"},
	{"eCA.MyFilter.label","Filter"},
	{"eCA.ShowTimeInterval.label","Show Time Interval"},
	{"eCA.Ongoing.label","Ongoing"},
	{"eCA.MedAdmin.label","Med Admin"},
	{"eCA.PatientCare.label","Patient Care"},
	{"eCA.CustomiseIcons.label","Customise Icons"},
	{"eCA.CurrentPrivilege.label","Current Privilege"},
	{"eCA.NoteHeader.label","Note Header"},
	{"eCA.HeaderType.label","Header Type"},
	{"eCA.DefineHeader.label","Define Header"},
	{"eCA.TemplateType.label","Template Type"},
	{"eCA.NoteFooter.label","Note Footer"},
	{"eCA.NoteBody.label","Note Body"},
	{"eCA.DocRefFormat.label","Document Ref Format"},
	{"eCA.DateAndTime.label","Date and Time"},
	{"eCA.AccessionNum.label","Accession No."},
	{"eCA.RefNumLogic.label","Reference Number Logic"},
	{"eCA.RefNo.label","Ref No"},
	{"eCA.ImageExists?.label","Image Exists ?"},
	{"eCA.SectionTemplateOutputForm.label","Section Template Output Form"},
	{"eCA.Editor.label","Editor"},
	{"eCA.Right.label","Right"},
	{"eCA.Laterality.label","Laterality"},
	{"eCA.Recorded.label","Recorded"},
	{"eCA.PrintLogoHeader.label","Print Logo Header"},
	{"eCA.DefineQuickLink.label","Define Quick Link"},
	{"eCA.QuickLinkForResponsibility.label","Quick Link For Responsibility"},
	{"eCA.CustomiseLinks.label","Customise Links"},
	{"eCA.CustomiseFilter.label","Customise Filter"},
	{"eCA.relative.label","Relative"},
	{"eCA.QuickLinkType.label","Quick Link Type"},
	{"eCA.QueryFilter.label","Query Filter"},
	{"eCA.ActualFunction.label","Actual Function"},
	{"eCA.ExternalApplication.label","External Application"},
	{"eCA.ExternalURL.label","External URL"},
	{"eCA.FunctionSpecific.label","Function Specific"},
	{"eCA.QuickLinks.label","Quick Links"},
	{"eCA.QuickLinkDescription.label","Quick Link Description"},
	{"eCA.Global.label","Global"},
	{"eCA.LinkType.label","Link Type"},
	{"eCA.Filter.label","Filter"},
	{"eCA.QuickLink.label","Quick Link"},
	{"eCA.Approx.label","Approx"},
	{"eCA.tree.label","Tree"},
	{"eCA.ViewResults.label","View Results"},
	{"eCA.LinkedEncounters.label","Linked Encounters"},
	{"eCA.LinkedDate.label","Linked Date"},
	{"eCA.Results.label","Results"},
	{"eCA.ReserveAndRequest.label","Reserved Requested"},
	{"eCA.ReserveNotRequest.label","Reserved Not Requested"},
	{"eCA.Issued.label","Issued"},
	{"eCA.Transfused.label","Transfused"},
	{"eCA.PartialTransfusion.label","Partial Transfusion"},
	{"eCA.UnitNo.label","Unit No"},
	{"eCA.TransfusionDtls.label","Transfusion Details"},
	{"eCA.Antibody.label","Antibody"},
	{"eCA.PatientAntibody.label","Patient Antibodies"},
	{"eCA.CheckbyPractitioner.label","Checked by Practitioner"},
	{"eCA.TransfusionRemarks.label","Transfusion Remarks"},
	{"eCA.TransfusebyPractitioner.label","Transfused by Practitioner"},
	{"eCA.RecordConsumption.label","Record Consumption"},
	{"eCA.LastReportedDate.label","Last Reported Date"},
	{"eCA.ProductDetails.label","Product Details"},
	{"eCA.ViewOrderDetail.label","View Order Detail"},
	{"eCA.TransfusionHistory.label","Transfusion History"},
	{"eCA.PendingTranscription.label","Pending Transcription"},
	{"eCA.BirthDateTime.label","Birth Date / Time"},

{"eCA.Abnormal.label","Abnormal"}, // to be remove from here
{"eCA.AcceptOption.label","Accept Option"},
{"eCA.ActionDescription.label","Action Description"},
{"eCA.ActionRemarks.label","Action Remarks"},
{"eCA.ActionType.label","Action Type"},
{"eCA.ActiveProblems.label","Active Problems"},
{"eCA.AddAssociateCodesfor.label","Add Associate Codes for"},
{"eCA.addNew.label","add/new"},
{"eCA.Address.label","Address"},
{"eCA.AdministeredBy.label","Administered By"},
{"eCA.AgeRange.label","Age Range"},
{"eCA.Alert.label","Alert"},
{"eCA.AllLocations.label","All Locations"},
{"eCA.AllergicDesc.label","Allergic Description"},
{"eCA.Allergy.label","Allergy"},
{"eCA.AllergyClass.label","Allergy Class"},
{"eCA.AllergyType.label","Allergy Type"},
{"eCA.AlphaInfo.label","Alpha Info"},
{"eCA.Anaesthesia.label","Anaesthesia"},
{"eCA.AnaesthesiaCode.label","Anaesthesia Code"},
{"eCA.Apgarscore.label","Apgar Score"},
{"eCA.ApplicableAgeGroup.label","Applicable Age Group"},
{"eCA.Application.label","Application"},
{"eCA.Assessment.label","Assessment"},
{"eCA.Assigned.label","Assigned"},
{"eCA.AssociateCodesFor.label","Associate Codes For"},
{"eCA.Average.label","Average"},
{"eCA.Batch.label","Batch"},
{"eCA.BedCommon.label","Bed	Common"},
{"eCA.Before.label","Before"},
{"eCA.BSA.label","BSA"},
{"eCA.Category.label","Category"},
{"eCA.Center.label","Center"},
{"eCA.ChangeDescription.label","Change Description"},
{"eCA.Characteristics.label","Characteristics"},
{"eCA.Chart.label","Chart"},
{"eCA.ChartSummaryCurrentMedications.label","ChartSummaryCurrentMedications"},
{"eCA.CheckedIn.label","Checked In"},
{"eCA.CheckedOut.label","Checked Out"},
{"eCA.ChiefComplaint.label","Chief Complaint"},
{"eCA.CLINICALNOTE.label","CLINICAL NOTE"},
{"eCA.ClinicalNotes.label","Clinical Notes"},
{"eCA.Clinician.label","Clinician"},
{"eCA.Cms.label","Cms"},
{"eCA.cms.label","cms"},
{"eCA.CodeIndicator.label","Code Indicator"},
{"eCA.ColumnHeader.label","Column Header"},
{"eCA.CompType.label","Comp Type"},
{"eCA.ComponentDefinition.label","Component Definition"},
{"eCA.ComponentID.label","Component ID"},
{"eCA.ComponentLookup.label","Component Lookup"},
{"eCA.ComponentPrompt.label","Component Prompt"},
{"eCA.ComponentType.label","Component Type"},
{"eCA.Confidential.label","Confidential"},
{"eCA.ConsultingPatient.label","Consulting Patient"},
{"eCA.Continue.label","Continue"},
{"eCA.CriticallyAbnormal.label","Critically Abnormal"},
{"eCA.CustomList.label","Custom List"},
{"eCA.CycleDays.label","Cycle Days"},
{"eCA.CycleDays.label","Cycle Days"},
{"eCA.VaccineSiteID.label","Default Site"},
{"eCA.Define.label","Define"},
{"eCA.DefinitionType.label","Definition Type"},
{"eCA.Demographics.label","Demographics"},
{"eCA.Dependency.label","Dependency"},
{"eCA.DiagnosisType.label","Diagnosis Type"},
{"eCA.DispalyOnly.label","Display Only"},
{"eCA.DisplayOrder.label","Display Order"},
{"eCA.DisplayResult.label","Display Result"},
{"eCA.VaccineDoseNo.label","Dose No"},
{"eCA.Drug.label","Drug"},
{"eCA.DrugName.label","Drug Name"},
{"eCA.Due.label","Due"},
{"eCA.EffStatus.label","Eff Status"},		// might be Enabled
{"eCA.EffectiveTo.label","Effective To"},
{"eCA.Element.label","Element"},
{"eCA.EmbeddedComponent.label","Embedded Component"},
{"eCA.Enable.label","Enable"},
{"eCA.EnterEdit.label","Enter/Edit"},
{"eCA.Error.label","Error"},
{"eCA.ErrorRemarks.label","Error Remarks"},
{"eCA.EventDetails.label","Event Details"},
{"eCA.EventEndDate.label","Event End Date"},
{"eCA.EventStartDate.label","Event Start Date"},
{"eCA.Events.label","Events"},
{"eCA.Expired.label","Expired"},
{"eCA.ExplanatoryText.label","Explanatory Text"},
{"eCA.filename.label","File Name"},
{"eCA.Findings.label","Findings"},
{"eCA.Fixed.label","Fixed"},
{"eCA.Food.label","Food"},
{"eCA.Formatted.label","Formatted"},
{"eCA.FormattedPRE.label","Formatted "},
{"eCA.Formula.label","Formula"},
{"eCA.Forward.label","Forward"},
{"eCA.Freeformat.label","Free format"},
{"eCA.VaccineFrequency.label","Frequency"},
{"eCA.FullyImmunized.label","Fully Immunized"},
{"eCA.GenericName.label","Generic Name"},
{"eCA.GridComponent.label","Grid Component"},
{"eCA.GridComponentDefinition.label","Grid Component Definition"},
{"eCA.GrowthDevelMilestoneAge.label","Growth/Devel Milestone Age"},
{"eCA.HighRisk.label","High Risk"},
{"eCA.History.label","History"},
{"eCA.HourAfterDischarge.label","Hour After Discharge"},
{"eCA.ICD.label","ICD"},
{"eCA.id.label","ID"},
{"eCA.IllegalResident.label","Illegal Resident"},
{"eCA.ImageFileName.label","Image FileName"},
{"eCA.ImageURL.label","Image URL"},
{"eCA.ImmunizationStatus.label","Immunization Status"},
{"eCA.InError.label","In Error"},
{"eCA.Inch.label","Inch"},
{"eCA.IncludeforAnalysis.label","Include for Analysis"},
{"eCA.IncludeinCurrentEncounter.label","Include in Current Encounter"},
{"eCA.Indicator.label","Indicator"},
{"eCA.Inhalant.label","Inhalant"},
{"eCA.Insert.label","Insert"},
{"eCA.Intermediate.label","Intermediate"},
{"eCA.Intervention.label","Intervention"},
{"eCA.InterventionType.label","Intervention Type"},
{"eCA.Last.label","Last"},
{"eCA.LastModifiedBy.label","Last Modified By"},
{"eCA.LegalResident.label","Legal Resident"},
{"eCA.Limit.label","Limit"},
{"eCA.ListId.label","List Id"},
{"eCA.ListItem.label","List Item"},
{"eCA.ListofGridComponents.label","List of Grid Components"},
{"eCA.LoggedUser.label","Logged User"},
{"eCA.LongDescription.label","Long Description"},
{"eCA.LongText.label","Long Text"},
{"eCA.Low.label","Low"},
{"eCA.VaccineMandatory.label","Mandatory"},
{"eCA.MarkError.label","Mark Error"},
{"eCA.MarkedBy.label","Marked By"},
{"eCA.MarkedDate.label","Marked Date"},
{"eCA.MatrixAttributes.label","Matrix Attributes"},
{"eCA.MatrixColumnSpan.label","Matrix Column Span"},
{"eCA.MatrixColumns.label","Matrix Columns"},
{"eCA.MatrixComponent.label","Matrix Component"},
{"eCA.MatrixDefinition.label","Matrix Definition"},
{"eCA.MatrixRows.label","Matrix Rows"},
{"eCA.MaxValue.label","Max Value"},
{"eCA.MedAncService.label","Med/Anc Service"},
{"eCA.MedicalEventType.label","Medical Event Type"},
{"eCA.MedicalReportRequest.label","Medical Report Request"},
{"eCA.MedicalService.label","Medical Service"},
{"eCA.MenuID.label","Menu ID"},
{"eCA.MIN.label","MIN"},
{"eCA.Minimum.label","Minimum"},
{"eCA.Minutes.label","Minutes"},
{"eCA.Modified.label","Modified"},
{"eCA.Monitoring.label","Monitoring"},
{"eCA.Mother.label","Mother"} ,
{"eCA.Multiple.label","Multiple"},
{"eCA.NewDocument.label","New Document"},
{"eCA.NoofBirths.label","No of Births"},
{"eCA.NotAdministered.label","Not Administered"},
{"eCA.NotPerformed.label","Not Performed"},
{"eCA.NoteDescription.label","Note Description"},
{"eCA.Notifiable.label","Notifiable"},
{"eCA.Numeric.label","Numeric"},
{"eCA.NumericPrefixRequired.label","Numeric Prefix Required"},
{"eCA.Observation.label","Observation"},
{"eCA.OldValue.label","Old Value"},
{"eCA.OnsetDatetime.label","Onset Datetime"},
{"eCA.ordered.label","Ordered"},
{"eCA.OrderedBy.label","Ordered By"},
{"eCA.OrganizationType.label","Organization Type"},
{"eCA.OutCome.label","Outcome"},
{"eCA.Outpatient.label","Outpatient"},
{"eCA.PanelDescription.label","Panel Description"},
{"eCA.PanelID.label","Panel ID"},
{"eCA.ParagraphDefinition.label","Paragraph Definition"},
{"eCA.PartiallyImmunized.label","Partially Immunized"},
{"eCA.Patients.label","Patients"},
{"eCA.PediatricDetail.label","Pediatric Detail"},
{"eCA.PendingAuthorization.label","Pending Authorization"},
{"eCA.PendingConsent.label","Pending Consent"},
{"eCA.PendingCosign.label","Pending Cosign"},
{"eCA.Performed.label","Performed"},
{"eCA.PerformedOn.label","Performed On"},
{"eCA.POA.label","POA"},
{"eCA.PoliceStationDetails.label","Police Station Details"},
{"eCA.PositionDuringIncident.label","Position During Incident"},
{"eCA.PractitionerDetails.label","Practitioner Details"},
{"eCA.PractitionerFrom.label","Practitioner From"},
{"eCA.PrescribedBy.label","Prescribed By"},
{"eCA.Presentation.label","Presentation"},
{"eCA.Preview.label","Preview"},
{"eCA.PrintDateTime.label","Print Date/Time"},
{"eCA.Printpreview.label","Print Preview"},
{"eCA.Printing.label","Printing"},
{"eCA.PriorityZone.label","Priority Zone"},
{"eCA.Problem.label","Problem"},
{"eCA.ProblemAssessment.label","Problem Assessment"},
{"eCA.ProblemList.label","Problem List"},
{"eCA.Problems.label","Problems"},
{"eCA.ProcedureCode.label","Procedure Code"},
{"eCA.Procedures.label","Procedures"},
{"eCA.Profile.label","Profile"},
{"eCA.Prompt.label","Prompt"},
{"eCA.ProtectiveDeviceUsed.label","Protective Device Used"},
{"eCA.Range.label","Range"},
{"eCA.Reaction.label","Reaction"},
{"eCA.ReactionCode.label","Reaction"},
{"eCA.ReactionDate.label","Reaction Date"},
{"eCA.ReferralDiagnosis.label","Referral Diagnosis"},
{"eCA.RegisterOrder.label","Register Order"},
{"eCA.Registered.label","Registered"},
{"eCA.RelationshipType.label","Relationship Type"},
{"eCA.Replace.label","Replace"},
{"eCA.Response.label","Response"},
{"eCA.ResponsibilityID.label","Responsibility ID"},
{"eCA.ResponsibilityName.label","Responsibility Name"},
{"eCA.RestrictTo.label","Restrict To"},
{"eCA.Result.label","Result"},
{"eCA.ResultType.label","Result Type"},
{"eCA.Reviewed.label","Reviewed"},
{"eCA.Reviewed.label","Reviewed"},
{"eCA.RootMenu.label","Root Menu"},
{"eCA.RowPosition.label","Row Position"},
{"eCA.Same.label","Same"},
{"eCA.ScheduleDate.label","Schedule Date"},
{"eCA.Scope.label","Scope"},
{"eCA.ScrubNurse.label","Scrub Nurse"},
{"eCA.SearchResult.label","Search Result"},
{"eCA.SearchUser.label","Search User"},
{"eCA.Section.label","Section"},
{"eCA.SectionCode.label","Section Code"},
{"eCA.Selected.label","Selected"},
{"eCA.Selection.label","Selection"},
{"eCA.SelfRelated.label","Self Related"},
{"eCA.Sensitive.label","Sensitive"},
{"eCA.ServiceCode.label","Service Code"},
{"eCA.Sex.label","Sex"},
{"eCA.ShortDescription.label","Short Description"},
{"eCA.ShortText.label","Short Text"},
{"eCA.Sign.label","Sign"},
{"eCA.Signature.label","Signature"},
{"eCA.Single.label","Single"},
{"eCA.SiteName.label","Site Name"},
{"eCA.Specify.label","Specify"},
{"eCA.Specimen.label","Specimen"},
{"eCA.SpecimenCollection.label","Specimen Collection"},
{"eCA.Stage.label","Stage"},
{"eCA.SupportingDiagnosis.label","Supporting Diagnosis"},
{"eCA.System.label","System"},
{"eCA.SystemDefined.label","System Defined"},
{"eCA.SystemDescription.label","System Description"},
{"eCA.Table.label","Table"},
{"eCA.Task.label","Task"},
{"eCA.Tasks.label","Tasks"},
{"eCA.Testing.label","Testing"},
{"eCA.Text.label","Text"},
{"eCA.TextBlock.label","Text Block"},
{"eCA.TextRows.label","Text Rows"},
{"eCA.Title.label","Title"},
{"eCA.TitleText.label","Title Text"},
{"eCA.Top.label","Top"},
{"eCA.Topical.label","Topical"},
{"eCA.Transcribed.label","Transcribed"},
{"eCA.TreatInvest.label","Treat/Invest"},
{"eCA.Treatment.label","Treatment"},
{"eCA.TriageDetails.label","Triage Details"},
{"eCA.UnAssigned.label","Unassigned"},
{"eCA.Unauthorized.label","Unauthorized"},
{"eCA.Unit.label","Unit"},
{"eCA.Units.label","Units"},
{"eCA.Update.label","Update"},
{"eCA.URL.label","URL"},
{"eCA.UserDefined.label","User Defined"},
{"eCA.Vaccine.label","Vaccine"},
{"eCA.VaccineId.label","Vaccine"},
{"eCA.Value.label","Value"},
{"eCA.Values.label","Values"},
{"eCA.Variable.label","Variable"},
{"eCA.VehiclesInvolved.label","Vehicles Involved"},
{"eCA.ViewBy.label","View By"},
{"eCA.VisitAdmDate.label","Visit Adm Date"},
{"eCA.VitalSigns.label","Vital Signs"},
{"eCA.Warn.label","Warn"},
{"eCA.YesNo.label","Yes/No"},
{"eCA.PatEncBanner.label","Patient / Encounter Context Banner"},
{"eCA.BannerType.label","Banner Type"},
{"eCA.ShowPatPhoto.label","Show Patient Photo"},
{"eCA.LinkPatName.label","Hyperlink Patient Name"},
{"eCA.LineSelector.label","Line Selector"},
{"eCA.FieldName.label","Field Name"},
{"eCA.DisplayLenght.label","Display Length"},
{"eCA.ActualLength.label","Actual Length"},
{"eCA.Config.label","Config"},
{"eCA.DisplayText.label","Display Text"},
{"eCA.ToolTipText.label","Tooltip Text"},
{"eCA.Legend.label","Legend"},
{"eCA.SpaceBeforeText.label","No. of Spaces Before Text"},
{"eCA.ViewDefaultBanner.label","View Default Banner"},
{"eCA.PreviewBanner.label","Preview Banner"},
{"eCA.PatientContextBanner.label","Patient Context Banner"},
{"eCA.EncounterContextBanner.label","Encounter Context Banner"},
{"eCA.Interval.label","Interval"},
{"eCA.PatMediReport.label","Patient Medical Report"},
{"eCA.UserPrevilegeForPrintEMail.label","User Privilege For Print And Email"},
{"eCA.PrivilegeFor.label","Privilege For"},
{"eCA.PatientMedicalReport.label","Patient Medical Report"},
{"eCA.EMail.label","EMail"},
{"eCA.PastDays.label","Past Days"},
{"eCA.EmailingSetup.label","Emailing Setup"},
{"eCA.EmailReportControlSetup.label","Email Report Control Setup"},
{"eCA.EmailReportBodyText.label","Email Report Body Text"},
{"eCA.ReportBodyTextID.label","Report Body Text ID"},
{"eCA.ReportBodyTextDesc.label","Report Body Text Description"},
{"eCA.RegisteredEmailRecipient.label","Registered Email Recipient"},
{"eCA.ManagePassword.label","Manage Password"},
{"eCA.UserPrivToVerifyEmail.label","User Privilege to Verify Email"},
{"eCA.EmailIdControl.label","Email Id Control"},
{"eCA.VerificationRequired.label","Verification Required"},
{"eCA.ApplicabletoPatient.label","Applicable To Patient"},
{"eCA.ApplicableToRegisteredUsers.label","Applicable To Registered Users"},
{"eCA.ApplicableToAdhocEmailID.label","Applicable To Adhoc Email Id"},
{"eCA.VerificationRequiredForConfidentialResult.label","Verification Required For Confidential Result"},
{"eCA.Manage.label","Manage"},
{"eCA.Email.label","Email"},
{"eCA.RegisteredRecipientID.label","Recipient ID"},
{"eCA.RegisteredRecipientName.label","Recipient Name"},
{"eCA.EmailId.label","Email Id"},
{"eCA.ApplicableToReport.label","Applicable To Report"},
{"eCA.BodyText.label","Body Text"},
{"eCA.CC.label","CC"},
{"eCA.NoteTypeAccessRights.label","Note Type Access Rights"},
{"eCA.AccessRightsfor.label","Access Rights For"},
{"eCA.ManageSelectedEvents.label","Manage Selected Events"},
{"eCA.ConfigureOutput.label","Configure Output"},
{"eCA.ByCategory.label","By Category"},
{"eCA.DeSelect.label","DeSelect"},
{"eCA.PastEncounters.label","Past Encounters"},
{"eCA.TermDescription.label","Term Description"},
{"eCA.ToPatient.label","To Patient"},
{"eCA.ToAdhocUser.label","To Adhoc User"},
{"eCA.ToRegdRecepient.label","To Registered Recepient"},
{"eCA.EncounterDetailForPMR.label","Encounter Detail for PMR"},
{"eCA.SpecialityForPMR.label","Speciality for PMR"},
{"eCA.PractitionerForPMR.label","Practitioner for PMR"},
{"eCA.PrintMailPrivilegeForPMR.label","Print/Mail Privilege for PMR"},
{"eCA.VerifySignReports.label","Verify And Sign Reports"},
{"eCA.MailedUser.label","Mailed User"},
{"eCA.MailDetails.label","Mail Details"},
{"eCA.Mail.label","Mail"},
{"eCA.MailBody.label","Mail Body"},
{"eCA.MailText.label","Mail Text"},
{"eCA.ClearMailId.label","Clear Mail Id"},
{"eCA.ClickOnValueCell.label","Click on value cell to deselect/select and Perform ==>"},
{"eCA.FilterBy.label","Filter By"},
{"eCA.NonSpeciality.label","Non Speciality"},
{"eCA.ConsultationSetup.label","Consultation Setup"},
{"eCA.SpltyForConsultOrderable.label","Speciality For Consultation Orderable"},
{"eCA.PractForConsultOrderable.label","Practitioner For Consultation Orderable"},
{"eCA.ConsultationParam.label","Consultation Parameter Setup"},
{"eCA.MaxConsultationPractitioner.label","Max no of Consultation by same practitioner"},
{"eCA.BackDateConsultationList.label","Back Date Consultation List"},
{"eCA.MaxConsultationSpeciality.label","Max no of Consultation by Speciality"},
{"eCA.AmendConsultationList.label","Amend Consultation List"},
{"eCA.MinDurationRecquired.label","Min Duration Recquired between consultation"},
{"eCA.Mins.label","Mins"},
{"eCA.Diagnosis.label","Diagnosis"},
{"eCA.ConsultationListBy.label","Consultation List By"},
{"eCA.OnBehalfOf.label","On Behalf of"},
{"eCA.ConsultDate.label","Consult Date"},
{"eCA.NewList.label","New List"},
{"eCA.ExistingList.label","Existing List"},
{"eCA.GenerateList.label","Generate List"},
{"eCA.ChargeConsultation.label","Charge Consultation"},
{"eCA.EHRView.label","EHR View"},
{"eCA.ClinicalEventsCentralRepFor.label","Clinical Events from Central Repository for"},
{"eCA.ChargeApplicable.label","Charge Applicable"},
{"eCA.ApprovalRequired.label","Approval Required"},
{"eCA.DisplayFields.label","Display Fields"},
{"eCA.FutureEvents.label","Future Events"},
{"eCA.FutureEventType.label","Future Event Type"},
{"eCA.ConfigureDisplayFields.label","Configure Display Fields"},
{"eCA.ConsultationListDesc.label","Consultation List Desc"},
{"eCA.ConsultationList.label","Consultation List"},
{"eCA.ExceedMaxConsSpeciality.label","Exceed Max no of  Cons by same Speciality"},
{"eCA.ExceedMaxConsPractitioner.label","Exceed Max no of Cons by same Practitioner"},
{"eCA.CancelCharge.label","Cancel Charge"},
{"eCA.ListReference.label","List Reference"},
{"eCA.TocancelPostedCons.label","To cancel posted consultation charge - Search with status list value as completed. "},
{"eCA.PrintNotesOnSign.label","Print Notes On Sign"},
{"eCA.PrintOnConfirm.label","Print On Confirm"},
{"eCA.PrintDirectly.label","Print Directly"},
{"eCA.RouteOfAdmin.label","Route Of Admin"},
{"eCA.ViewMARChart.label","View MAR Chart"},
{"eCA.ConfigDispCrit.label","Configure Display Criteria"},
{"eCA.RecordedDateAndTime.label","Recorded Date & Time"},
{"eCA.IconsSelected.label","icons selected"},
{"eCA.FormulaAdopted.label","Formula adopted"},
{"eCA.Centemeter.label","Centimeter"},
{"eCA.IsEqualTo.label","is Equal to"},
{"eCA.IBW.label","IBW"},
{"eCA.Kilograms.label","Kilograms"},
{"eCA.CanConvertLbsToKg.label","Can convert lbs to kg"},
{"eCA.Or.label","Or"},
{"eCA.yrs.label","yrs"},
{"eCA.Child.label","Child"},
{"eCA.ClinicalCalculations.label","Clinical Calculations"},
{"eCA.FormulaeToBeUsed.label","Formulae to be used"},
{"eCA.NoPrivilege.label","No Privilege"},
{"eCA.SymbolicLegends.label","Symbolic Legends"},
{"eCA.NormalcyIndicator.label","Normalcy indicator"},
{"eCA.Symboliclegends.label","Symbolic legends"},
{"eCA.Colourlegends.label","Colour legends"},
{"eCA.DisplayEvents.label","Display Events"},
{"eCA.IncludeInErrRecs.label","Include In Error Records"},
{"eCA.MarkedInErrorBy.label","Marked in Error by"},
{"eCA.MarkedErrorDate.label","Marked Error Date"},
{"eCA.ByDiagnosis.label","By Diagnosis"},
{"eCA.ByDocument.label","By Document"},
{"eCA.HideMenu.label","Hide Menu"},
{"eCA.PatientwithoutEncounter.label","Patient without Encounter"},
{"eCA.DocumentName.label","Document Name"},
{"eCA.SearchWord.label","Search Word"},
{"eCA.Sectionsp.label","&nbsp;S&nbsp; &nbsp;E&nbsp; &nbsp;C&nbsp; &nbsp;T&nbsp; &nbsp;I&nbsp; &nbsp;O&nbsp; &nbsp;N&nbsp;"},
{"eCA.ClickForRecAndSign.label","Click on \"Notes View\" for \"Record\" & \"SIGN\" buttons"},
{"eCA.ProcessingPlsWait.label","&nbsp;P&nbsp; &nbsp;r&nbsp; &nbsp;o&nbsp; &nbsp;c&nbsp; &nbsp;e&nbsp; &nbsp;s&nbsp; &nbsp;s&nbsp; &nbsp;i&nbsp; &nbsp;n&nbsp; &nbsp;g&nbsp;  &nbsp;P&nbsp; &nbsp;l&nbsp; &nbsp;e&nbsp; &nbsp;a&nbsp; &nbsp;s&nbsp; &nbsp;e&nbsp;   &nbsp;w&nbsp; &nbsp;a&nbsp; &nbsp;i&nbsp; &nbsp;t&nbsp;"},
{"eCA.ShowMenu.label","Show Menu"},
{"eCA.PractAlert.label","Practitioner Alert"},
{"eCA.AlertCode.label","Alert Code"},
{"eCA.AlertDesc.label","Alert Description"},
{"eCA.Onetime.label","One Time"},
{"eCA.AlertEvent.label","Alert Event"},
{"eCA.ActionDateAndTime.label","Action Date and Time"},
{"eCA.AlertCategoryCode.label","Alert Category Code"},
{"eCA.AlertCategoryDescription.label","Alert Category Description"},
{"eCA.AlertEventCode.label","Alert Event Code"},
{"eCA.AlertEventDescription.label","Alert Event Description"},
{"eCA.AlertCategory.label","Alert Category"},
{"eCA.AlertDescription.label","Alert Description"},
{"eCA.ActionEvent.label","Action Event"},
{"eCA.ActionFrequency.label","Action Frequency"},
{"eCA.ActionPeriod.label","Action Period"},
{"eCA.inEvery.label","in every"},
{"eCA.TriggeringTime.label","Triggering Time"},
{"eCA.TranscriptionApplicable.label","Transcription Applicable"},
{"eCA.CutoffPeriodToAllowTrans.label","Cut off period to allow transcription"},
{"eCA.DaysFromVisitRegDisc.label","days from visit registration or discharge"},
{"eCA.DefaultAgeGrp.label","Default Age Group"},
{"eCA.SpltySpcific.label","Speciality Specific"},
{"eCA.DfltTranscriptionNotes.label","Default Transcription Notes"},
{"eCA.forwardedForAuth.label","Forwarded For Authorization"},
{"eCA.respSentTo.label","Response Sent To"},
{"eCA.AdaptiveMenu.label","Adaptive Menu"},
{"eCA.New.label","New"},
{"eCA.BloodUnitCons.label","Blood Unit Consumption"},
{"eCA.AdaptiveFuncTo.label","Adaptive Function to"},
{"eCA.FunctionRef.label","Function Ref"},
{"eCA.LinkNewFunc.label","Link New Function"},
{"eCA.LinkedFunc.label","Linked Functions"},
{"eCA.ModifyLinkedFunc.label","Modify Linked Function"},
{"eCA.TranscribeNotes.label","Transcribe Notes"},
{"eCA.ReqTranscription.label","Req Transcription"},
{"eCA.MyPatients.label","My Patients"},
{"eCA.MyRelatedPatients.label","My Related Patients"},
{"eCA.Unclassified.label","Unclassified"},
{"eCA.RequestDetails.label","Request Details"},
{"eCA.UncheckToRemove.label","Uncheck to remove"},
{"eCA.RequestDateTime.label","Request Date and Time"},
{"eCA.RequestedBy.label","Requested By"},
{"eCA.AlrgyResRecDate.label","Allergy Resolve Recorded Date"},
{"eCA.ResultRemarks.label","Result/Remarks"},
{"eCA.AccessedBy.label","Accessed By"},
{"eCA.AuditTrailBy.label","Audit Trail By"},
{"eCA.PendingRxForMAR.label","Pending Rx for MAR"}, //Added by Kishore kumar N on Sept-08-09, for CRF 691
{"eCA.PatientDetailsGroup.label","(Pat id/Pat name/Age/Gender)"},
{"eCA.EncounterDetailsGroup.label","(Enc Id, Specialty, Patient Class, Location)"},
{"eCA.ClinicalEventHistory.label","Clinical Event History"},
{"eCA.DeliveryType.label","Delivery Type"},
{"eCA.AttendingNurse.label","Attending Nurse"},
{"eCA.ProcedureClassification.label","Procedure Classification"},
{"eCA.DeliverySurgicalClassification.label","Delivery Surgical Classification"},
{"eCA.VaginalDeliveryType.label","Vaginal Delivery Type"},
{"eCA.NoofBirth.label","No of Birth"},
{"eCA.ComplicationinStage1ofDelivery.label","Complication in Stage 1 of Delivery"},
{"eCA.ComplicationinStage2ofDelivery.label","Complication in Stage 2 of Delivery"},
{"eCA.ComplicationinStage3ofDelivery.label","Complication in Stage 3 of Delivery"},
{"eCA.ComplicationofDelivery.label","Complication of Delivery"},
{"eCA.FoetusComplicationofDelivery.label","Foetus Complication of Delivery"},
{"eCA.AdministeredRxVaccines.label","Administered Rx Vaccines"},
{"eCA.DeliveryRecord.label","Delivery Record"},
{"eCA.RestrictModifyLMP.label","Restrict Modification of LMP/Corrected EDD Beyond"},
{"eCA.WhichEverIsLess.label","which ever is less"},
{"eCA.CorrctdEDDNotExtendBeyond.label","Corrected EDD Should not Extend Beyond or Before"},
{"eCA.DaysFromthecalculatedEDD.label","days From the calculated EDD"},
{"eCA.NewBornDetails.label","NewBorn Details"},
{"eCA.NewBorn.label","NewBorn"},
{"eCA.NumberofOccurrences.label","No of Occurrences"},
{"eCA.RegisterBaby.label","Register Baby"},
{"eCA.QueryID.label","Query ID"},
{"eCA.QueryDesc.label","Query Description"},
{"eCA.Export.label","Export to excel"},
/* added by kishore kumar N on 02-11-09 for CRF 0691.1*/
{"eCA.DoseNumber.label","Dose Number"},
{"eCA.OptLnkVaccineSchedule.label","Option to link the vaccine to schedule"},
{"eCA.NoDaysVaccinesSchedule.label","No of days with in which the vaccines can be linked to schedule"},
{"eCA.AutoLnk.label","Auto Link"},
{"eCA.ManualLnk.label","Manual Link"},
{"eCA.VaccineCatagoryForRXVaccines.label","Adhoc Vaccine Category for MAR"},
{"eCA.ScheduledAge.label","Scheduled Age"},
{"eCA.ActualAge.label","Actual Age"},
/*ends here. */
{"eCA.ValidateURL.label","URL is not validated. If any wrong URL is entered it will fail in transaction."},
{"eCA.ShowTextResult.label","Show Text Result"},
{"eCA.Collapsed.label","Collapsed"},
{"eCA.Expanded.label","Expanded"},
{"eCA.View.label","View"},
{"eCA.RecordedPractType.label","Recorded Practitioner Type"},
{"eCA.RecordedPract.label","Recorded Practitioner"},
{"eCA.IncludeNoOfPreviousNotes.label","Include No of Previous Notes"},
{"eCA.ViewClinicalDocuments.label","View Clinical Documents"},
{"eCA.ViewPreviousNotes.label","View Previous Notes"},
{"eCA.VaccineCategoryType.label","Vaccine Category Type"},
{"eCA.LnkVaccSchedule.label","Link Vaccine Schedule"},
{"eCA.MoreValues.label","More Values..."},
{"eCA.RecordingForDateTime.label","Recording of  $$ for the Date time: $$"},
{"eCA.HighRiskResRecDate.label","High Risk Resolve Recorded Date"},
{"eCA.RecordedDischargeSummary.label","Recorded Discharge Summary"},
{"eCA.ReferralLetter.label","Referral Letter"},
{"eCA.RecordedClinicalNotes.label","Recorded Clinical Notes"},
{"eCA.ErrMrkDlt.label","Error Dtl"},
{"eCA.MaxNoImgAllowed.label","Max no of Images allowed per note"},
{"eCA.BedNo.label","Bed No"},//IN29412
	{"eCA.ConsultingPractitioner.label","Consulting Practitioner_th"},//IN29413
	{"eCA.PrintEventHeaderinClinicalEventHistory.label","Print Event Header in Clinical Event History"},//IN029312
	{"eCA.NoteHeaderMargin.label","Header Margin for Note"},//[IN031116]
	{"eCA.NoteFooterMargin.label","Footer  Margin for Note"},//[IN031116]
	{"eCA.HeaderFooterMargin.label","Note Header and Footer margin required"},//[IN031116]
	{"eCA.ViewChartSetup.label","View Chart Setup"}, //Ramesh
	{"eCA.LogoHeaderForAllPages.label"," Print Logo Header in All Pages"},//IN030419
	{"eCA.ReportHeaderForAllPages.label","Print Report Header in All Pages"},//IN030419
	{"eCA.StartConsultation.label","Do you want to start the Consultation? "},//Menaka
	{"eCA.PatWithEnc.label","Patient Chart with Encounter"},//Menaka
	{"eCA.PrintTextLogoHeader.label","Print Facility / Site Header"},//[IN032210]
	{"eCA.PatWithOutEnc.label","Patient Chart without Encounter"},//Menaka
	{"eCA.EditorText.label","Editor Text"},//[IN033180] 
	{"eCA.TextType.label","Text Type"},//[IN033180] 
	{"eCA.AddendumRecordedBy.label","Addendum Recorded By"},//IN033869
	{"eCA.SpellChecker.label","Spell Checker required"},//IN029712 //IN035338
	{"eCA.DefaultSpellChecker.label","Default Spell Checker"},//IN029712
	{"eCA.SpellCheckerPopUp.label","Spell Checker Pop up window"},//IN029712
	{"eCA.SpellCheckerInLine.label"," Inline Spell Checker"},//IN029712
	{"eCA.LegendForSummary.label"," Rename Summary Menu"},//[IN035950] 
	{"eCA.LegendForNavigation.label"," Rename Navigation Menu"},//[IN035950] 
{"eCA.PractitionerTo.label","Practitioner To"},     //IN035928

	{"eCA.ResearchCategoryFactor.label","Research Category Factor"},//[IN030466]
	{"eCA.ResearchCategoryRiskFactor.label","Research Category Factor"},//[IN030466]
	{"eCA.ResearchCategoryFactorCode.label","Research Category Factor Code"},//[IN030466]
	{"eCA.ResearchCategoryFactorDescription.label","Research Category Factor Description"},//[IN030466]
	{"eCA.researchStudy.label","Research Study"}, // added for CRF-025 - IN030466
	{"eCA.NODATAFOUND.label","There is no data found."}, // added for - IN035950
	{"eCA.defaultcriteria.label","Default Criteria"}, // added for CHL-CRF-018 IN035924
	{"eCA.currentencounter.label","Current Encounter"}, // added for CHL-CRF-018 IN035924
	{"eCA.pastencounter.label","Past Encounter"}, // added for CHL-CRF-018 IN035924
	{"eCA.scopefordata.label","Scope for Data to be displayed in Widget"}, // added for CHL-CRF-018 IN035924
	{"eCA.SignAddendumOthers.label","Addendum Sign for others"},//IN037676
	{"eCA.researchStudy.label","Research Study"}, // added for CRF-025 - IN030466
	{"eCA.NODATAFOUND.label","There is no data found."}, // added for - IN035950
	{"eCA.RiskFactorId.label","Risk Factor ID"}, // added for CRF-028
	{"eCA.RiskFactorDescription.label","Risk Factor Description"}, // added for CRF-028
	{"eCA.RiskFactorType.label","Risk Factor Type"}, // added for CRF-028
	{"eCA.AgeGrp.label","Age Group"}, // added for CRF-028
	{"eCA.RiskFactorIndicator.label","Risk Factor Indicator"}, // added for CRF-028
	{"eCA.Remarks.label","Remarks"}, // added for CRF-028
	{"eCA.AdverseEventType.label","Adverse Event Type"}, // added for CRF-028
	{"eCA.Allergen.label","Allergen"}, // added for CRF-028
	{"eCA.Status.label","Status"}, // added for CRF-028
	{"eCA.Weight.label","Weight"}, // added for CRF-028
	{"eCA.Height.label","Height"}, // added for CRF-028
	{"eCA.DiscreteMeasure.label","Discrete Measure"}, // added for CRF-028
	{"eCA.LabResults.label","Lab Results"}, // added for CRF-028
	{"eCA.OrderCatalog.label","Order Catalog"}, // added for CRF-028
	{"eCA.DrugName.label","Drug Name"}, // added for CRF-028
	{"eCA.Radiology.label","Radiology"}, // added for CRF-028
	{"eCA.TermSet.label","Term Set"}, // added for CRF-028
	{"eCA.RuleforRiskFactor.label","Risk Factor"}, // added for CRF-028
	{"eCA.Start.label","Start"}, // added for CRF-028
	{"eCA.End.label","End"}, // added for CRF-028
	{"eCA.AllAges.label","All Ages"}, // added for CRF-028
	{"eCA.Age.label","Age"}, // added for CRF-028
	{"eCA.Operator.label","Operator"}, // added for CRF-028
	{"eCA.High.label","High"}, // added for CRF-028
	{"eCA.Average.label","Average"}, // added for CRF-028
	{"eCA.Low.label","Low"}, // added for CRF-028
	{"eCA.labtestresult.label","Lab Test Result"}, // added for CRF-028
	{"eCA.groupid.label","Group ID"},// added for BRU-HIMS-CRF-028
	{"eCA.groupdesc.label","Group Description"}, // added for BRU-HIMS-CRF-028
	{"eCA.riskfactor.label","Risk Factor"}, // added for BRU-HIMS-CRF-028
	{"eCA.symbolid.label","Symbol ID"}, // added for BRU-HIMS-CRF-221 //IN041021
	{"eCA.symbol.label","Symbol"}, // added for BRU-HIMS-CRF-221
	{"eCA.symbolgroups.label","Symbol Group"}, // added for BRU-HIMS-CRF-221
	{"eCA.symbolgrpid.label","Symbol Group ID"},  // added for BRU-HIMS-CRF-221  //IN041021
	{"eCA.symbolgrpdesc.label","Symbol Group Desc"}, // added for BRU-HIMS-CRF-221
	{"eCA.noteindicator.label","Note Indicator"}, // added for BRU-HIMS-CRF-221
	{"eCA.ntegrpntetypemand.label","Note Group/Note Type for the symbol group"}, // added for BRU-HIMS-CRF-221
	{"eCA.ResultLinkSensitiveDia.label","Result Link Sensitive Diagnosis"}, // added for IN039182
	{"eCA.MaxDaysViewPreviousNotes.label","Max Allowed Period For View Prev Notes"}, // added for IN043031 
	{"eCA.GenogramOfOtherFamilyMemberExists.label","Genogram of other family member exists"}, // added for BRU-HIMS-CRF-016
	{"eCA.NonPatientID.label","Non-Patient ID"}, // added for BRU-HIMS-CRF-016
	{"eCA.FamilyMembers.label","Family Members"}, // added for BRU-HIMS-CRF-016
	{"eCA.FamilyMember.label","Family Member"}, // added for BRU-HIMS-CRF-016
	{"eCA.PatientID.label","Patient ID"}, // added for BRU-HIMS-CRF-016
	{"eCA.PatientName.label","Patient Name"}, // added for BRU-HIMS-CRF-016
	{"eCA.Age.label","Age"}, // added for BRU-HIMS-CRF-016
	{"eCA.Gender.label","Gender"}, // added for BRU-HIMS-CRF-016
	{"eCA.DeceasedDateTime.label","Deceased Date/Time"}, // added for BRU-HIMS-CRF-016
	{"eCA.Relation.label","Relation"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationWith.label","Relation With"}, // added for BRU-HIMS-CRF-016
	{"eCA.FamilyMemberDetails.label","Family Member Details"}, // added for BRU-HIMS-CRF-016
	{"eCA.FamilyRelationship.label","Family Relationship"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationshipType.label","Relationship Type"}, // added for BRU-HIMS-CRF-016
	{"eCA.NoOfChildren.label","No Of Children"}, // added for BRU-HIMS-CRF-016
	{"eCA.FamilyDemographics.label","Family Demographics"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationStartDate.label","Relation Start Date"}, // added for BRU-HIMS-CRF-016
	{"eCA.Name.label","Name"}, // added for BRU-HIMS-CRF-016
	{"eCA.DateofBirth.label","Date of Birth"}, // added for BRU-HIMS-CRF-016
	{"eCA.DeceasedRemarks.label","Deceased Remarks"}, // added for BRU-HIMS-CRF-016
	{"eCA.FatherDetails.label","Father Details"}, // added for BRU-HIMS-CRF-016
	{"eCA.MotherDetails.label","Mother Details"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationbetweenFatherAndMother.label","Relation between Father and Mother"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationStartDate.label","Relation Start Date"}, // added for BRU-HIMS-CRF-016
	{"eCA.SiblingPosition.label","Sibling Position"}, // added for BRU-HIMS-CRF-016
	{"eCA.RelationID.label","Relation ID"}, // added for BRU-HIMS-CRF-016
	{"eCA.Facility.label","Facility"},//IN043509
	{"eCA.filterbasedon.label","Filter Based On"},//IN042552
	{"eCA.basedon.label","Based On"},//IN042552
	{"eCA.viewlist.label","View List"},//IN042552
	{"eCA.authorizedorordered.label","Authorized/Ordered By"},//IN042552
	{"eCA.secondaryspeciality.label","Secondary Speciality"},//IN042552
	{"eCA.DispSeqNo.label","Display Seq No"},//IN040032
	{"eCA.NOKNOWNALLERGY.label","No Known Allergies Recorded"},//07012014	
	{"eCA.PatientClassification.label","Patient Classification"},//IN044246
	{"eCA.DisplayResultLinkInHTML.label","Display result link in HTML"},  //IN041284
	{"eCA.EncGrpCurrSpeclty.label","Encounter Grouping by Current Specialty"}, //IN034513
	{"eCA.NewVital.label","New Vital"}, //IN037701
	{"eCA.NOOPDAEENCOUNTER.label","There is no data found for OPD/AE Encounter"}, //IN037701
	{"eCA.LOCATIONORPRACT.label","Location/Practitioner"}, //IN037701
	{"eCA.APPOINTMENTDATE.label","Appointment Date"}, //IN037701
	{"eCA.ACCESSSEDBY.label","Accessed By"}, //IN037701
	{"eCA.ACCESSEDDATETIME.label","Accessed Date/Time"}, //IN037701
	{"eCA.mdscriteriamet.label","MDS Criteria Met"}, //IN050593
	{"eCA.mdscriterianotmet.label","MDS Criteria Not Met"}, //IN050593
	{"eCA.referredLocationDtls.label","Referred Location Details"}, //IN050580	
	{"eCA.reportgenerated.label","Report Generated"}, //IN050580	
	{"eCA.assignandconfirm.label","Enable Assign & Confirm in Specialty Consult"},//IN048704
	{"eCA.assignandconfirmdiag.label","Assign and Confirm"},//IN048704
	{"eCA.assigndiag.label","Assign"},//IN048704
	{"eCA.VisitPatientClassEncounterSpecilityDtls.label","Visit Adm DT/ PT Class/ Encounter No / Specialty"}, //IN052940
	{"eCA.CopyFromPreviousNote.label","Copy From Previous Note"},//IN052940
	{"eCA.pinvalidreq.label","Confidential Pin Required for Printing"},//ML-MMOH-CRF-0335 - IN057113  	
	{"eCA.CopyText.label","Copy Text"},//IN058148
	{"eCA.AuditLink.label","Audit Link"},//IN058156
	{"eCA.Antibody.label","Antibody"}, //IN057106
	{"eCA.dispbyevent.label","Display By Event"}, //IN058138
	/*IN057209 start*/ 
	{"eCA.ShiftOne.label","Shift 1"},
	{"eCA.ShiftTwo.label","Shift 2"},
	{"eCA.ShiftThree.label","Shift 3"},
	{"eCA.ShiftSummaryRequired.label","Shift Summary Required"},			
	{"eCA.NumberOfShifts.label","No of Shifts"},
	{"eCA.ShiftDuration.label","Shift Duration"},
	/* IN057209 end*/
	{"eCA.recordsign.label","Record/Sign"}, //ML-MMOH-CRF-0356 [IN057193]
	{"eCA.DisplayDisPrintText.label","Display disclaimer text in Clinical Event History print"}, //IN004500
	// ML-MMOH-CRF-0329 - Start
	{"eCA.notifyalert.label","Notification alert"}, 
	{"eCA.rejectedtest.label","Rejected Test"}, 
	{"eCA.testcode.label","Test Code"},
	{"eCA.rejectreason.label","Rejected Reason"},
	{"eCA.rejectedtime.label","Rejected Time"},
	{"eCA.rejectedtl.label","Rejected Details"},
	// ML-MMOH-CRF-0329 - End
	//IN057106_changed starts
	{"eCA.antibodycode.label","Antibody Code"},
	{"eCA.antibodydescription.label","Antibody Description"},
	{"eCA.resultdatetime.label","Results Date and Time"},
	{"eCA.antibodydetails.label","Antibody Details"},
	//IN057106_changed ends
	{"eCA.TextFormatDflt.label","Select Text Format by Default for Linked Sections"}, //  MO_CRF_20102[IN055439]
	{"eCA.textAlignment.label","Text Alignment"}, //GHL-CRF-0401[IN059630]
    {"eCA.watermark.label","Enable watermarking in unauthorized clinical note"},  //Added for IN059489
	{"eCA.RestrictUnsettledPatient.label","Restrict patient when unsettled/unbilled amount for the encounter"},//Added for IN052254
	{"eCA.amendResultNote.label","Amend Clinical Result Note"},  //JD-CRF-0199 [IN059747]
	{"eCA.AutoRefTime.label","Auto Refresh Time For Summary Menu"}, //IN052053
	{"eCA.disprefrange.label","Disable Reference Range in Link Results"}, // ML-MMOH-CRF-0534 [IN061882]
	{"eCA.dispspectype.label","Disable Specimen Type in Link Results"}, // ML-MMOH-CRF-0534 [IN061882]
	{"eCA.AutoFillActiveDiagnosis.label","Auto Fill Active Diagnosis"}, //IN061907
	{"eCA.datetimeformat.label","Disable Repeated Date /Time in Link Results"}, // ML-MMOH-CRF-0534.1 [IN063865]
	{"eCA.noofenccopyprevnotes.label","No of Encounters to Copy Previous Notes"}, // ML-MMOH-CRF-0807 [IN063798]
	{"eCA.PendDischSummGracePeriod.label","Pending Discharge Summary Grace Period"}, //IN061885
	{"eCA.Xaxiselement.label","X Axis Element"},//058006
	{"eCA.Yaxiselement.label","Y Axis Element"},//058006
	{"eCA.centimeters.label","Centimeters"},//058006
	{"eCA.PersonalisePatList.label","Personalised Patient List"}, // IN061891	
	{"eCA.PatEncDetails.label","View Patient Encounter Details"} , // IN061891
	{"eCA.kgm2.label","Kg\\m2"}, // IN058006
	{"eCA.AddedAt.label","Added At"}, // IN061891
	{"eCA.splchtgrpid.label","Special Chart Group Id"}, //CRF-461 US-003 
	{"eCA.splchtgrpdesc.label","Special Chart Group Desc"}, //CRF-461 US-003
	{"eCA.Effectivestat.label","Effective Status"}, // CRF-461 US-003
	{"eCA.MyReferrals.label","My Referrals"}, //IN065452
	{"eCA.AEConsultation.label","AE Consultation"}, //IN065070
	{"eCA.PromptStartConsultAEPatQueue.label","Prompt for Start Consultation in Current Emergency Patients"}, //IN065070
	{"eCA.PromptStartConsultAEPatQueueInCA.label","Prompt for Start AE Consultation in Clinician Access"}, //IN065070
	{"eCA.OpenPatChrtwithEnc.label","Open Patient Chart with Encounter"}, //IN065070
	{"eCA.OpenPatChrtWithoutEnc.label","Open Patient Chart without Encounter"}, //IN065070
	{"eCA.PromptChartTypeForPatChart.label","Prompt for Chart type while opening patient chart"}, //IN065070
	{"eCA.PromptStartConsultAEPatQueueInCA.label","Prompt for Start AE Consultation in Clinician Access"}, //IN065070
	{"eCA.PreDischargeAdvice.label","Pre Discharge Advice"}, //IN064342
	{"eCA.Prepared.label","Prepared"}, //IN064342
	{"eCA.NotPrepared.label","Not Prepared"}, //IN064342
	{"eCA.FinacialDetailsPopup.label","Pop up required to view patient financial details in view chart summary"}, //IN063285
	{"eCA.CopyFromPreviousSection.label","Copy From Previous Section"}, //IN063931
	{"eCA.TimeFrameDurtn.label","Time Frame Duration To Consider For My Referrals To Be Performed"}, // IN062606
	{"eCA.Hr24Formt.label","24 Hrs Format Time"}, //IN066645
	{"eCA.noofenccopyprevnotessec.label","No of Encounters to Copy Previous Notes / Section"}, //[IN063931]
	{"eCA.DefaultView.label","Default View"},// IN066119
	{"eCA.SelfNoteRefTime.label","Auto Refresh Time For Self-Notes in Summary Menu"},//IN066237
	{"eCA.GenitalDevelopment.label","Genital (Penis) Development"}, //[IN063838]
	{"eCA.BreastDevelopment.label","Breast Development"}, //[IN063838]
	{"eCA.PubicHair.label","Pubic hair"}, //[IN063838]
		{"eCA.centralsed_default_days.label","Default Period To Be Considered While Fetching Patient Encounter Details In CDR"},//IN065341
	{"eCA.AccessRightsApplicabilityForInError.label","Access Rights Applicable to In Error"},//IN066108
	{"eCA.AccessRightsApplicabilityForUnsignedNotes.label","Access Rights Applicable to Unsigned Notes"},//IN066108
	{"eCA.MarkasReject.label","Mark as Reject"},//IN67872
	{"eCA.RemarksforUpdate.label","Remarks for Update"},//IN063818
	{"eCA.Updated.label","Updated"},//IN063818
	{"eCA.LogoHeadersizeDimensions.label","Logo Header size Dimensions"},//IN068669
	{"eCA.Height.label","Height"},//IN068669
	{"eCA.Width.label","Width"},//IN068669
	{"eCA.Px.label","Px"},//IN068669
{"eCA.PrimaryInsurance.label","Primary Insurance"},//IN059704
{"eCA.SecondaryInsurance.label","Secondary Insurance"},//IN059704
{"eCA.InsuranceAuthorizationForm.label","Insurance Authorization Form"},//IN059704
{"eCA.notInsurencePatient.label","This patient payment type is cash"},//IN059704
	{"eCA.BillingGroupPriorityWise.label","Primary Billing Group - Priority Wise"},//IN059704
	{"eCA.EventFilter.label","Event Filter"},//IN069243
	{"eCA.AMShift.label","AM Shift"},//IN067541
{"eCA.PMShift.label","PM Shift"},//IN067541
{"eCA.ONShift.label","ON Shift"},//IN067541
{"eCA.SelectCategory.label","Select Category"},//IN067541
{"eCA.DefineChartCategory.label","Define Chart Category"},//IN067541
{"eCA.Therapist.label","Therapist"},//IN067236
{"eCA.mappingExistingChartId.label","Mapping Existing Chart ID Applicable to Third Party Vitals Data"},//IN069244
{"eCA.ThirdPartyVitalsAck.label","Third Party Vitals Data Required to Acknowledge"},//IN069852
{"eCA.InterVitalSignData.label","Interfaced Vital Signs Data "},//IN069244
{"eCA.LogoforClinicalNotes.label","Logo To Be Considered For Clinical Notes"},//IN066005
{"eCA.Site.label","Site"},//IN066005
{"eCA.LoginFacility.label","Login Facility"},//IN066005
{"eCA.ControlToViewAndPrint.label","Control to view & print lab result report from New Clincial Event History"},//IN070032
{"eCA.SpecimenWise.label","Specimen wise"},//IN070032
{"eCA.SpecimenIndividualPanelWise.label","Individual"},//IN070032
{"eCA.ViewDocuments.label","View Documents"},//IN070610
{"eCA.RestrictingCEHData.label","Restricting Clinical Event History Data"},//IN069242
{"eCA.EventClassType.label","Event Class Type"},//IN069242
{"eCA.ToBeRestrict.label","To be Restricted"},//IN069242
{"eCA.RestrictionApplicableTo.label","Restriction Applicable to"},//IN069242
{"eCA.PrintCommentsManage.label","Print/Comments/Manage"},//IN069242
{"eCA.historyType.label","History Type"},//IN069242
{"eCA.ViewDocuments.label","View Documents"},//IN071639
{"eCA.ApprovalNumber.label","Approval Number"},//IN071639
{"eCA.InsuranceName.label","Insurance Name"},//IN071639
{"eCA.ThirdPartyVitalsDataRep.label","Third Party Vitals Data Representation"},//IN069384
{"eCA.GraphView.label","Graph View"},//IN069384
{"eCA.TableView.label","Table View"},//IN069384
{"eCA.AllowAutoSaveInNotes.label","Allow Auto Save In Notes"},//IN071264
{"eCA.AllowAutoSaveForEvery.label","Allow Auto Save For Every"},//IN071264
{"eCA.DifferenceofTimePeriod.label","Default Time Difference in Interfaced Vital Signs Data"},//IN072674
{"eCA.minutes.label","Minutes"},//IN071264//IN072674
{"eCA.SerumCreatinine.label","Serum Creatinine"},//IN069908
{"eCA.CreatinineclearanceForChildren.label","Creatinine Clearance for Children"},//IN069908
{"eCA.EstimatedGfrValue.label","Estimated GFR Value"},//IN069908
{"eCA.CreatinineclearanceForAdult.label","Creatinine Clearance for Adults"},//IN069908
{"eCA.applicableInterfacedData.label","Applicable for Interfaced Vital Signs Data"},//IN072777
{"eCA.DoctorQuery.label","Doctor Query"},//IN073540
{"eCA.SupervisorQuery.label","SuperVisor Query"},//IN073540
{"eCA.CodingStatus.label","Coding Status"},//IN073540
{"eCA.CompleteStatus.label","Completion Status"},//IN073540
{"eCA.DoctorName.label","Doctor Name"},//IN073540
{"eCA.RecordCompletion.label","Record Completion"},//IN073540
{"eCA.Sno.label","S.No"},	//IN010564
{"eCA.Coder.label","Coder"},//IN073540
{"eCA.Export.label","Export to Excel"},//Changed small e to E for IN010564
{"eCA.ClinicalNoteAuditTrial.label","Clinical Note Audit Trail Report"},//IN073108
{"eCA.DisplayNoteDescription.label","To Display Note type title at the time of Notes view & Notes Print"},//Exception-PMG2020-COMN-CRF-0085 7605
{"eCA.NoteContentCompressionRequired.label","Note Content Compression required"},//6484
{"eCA.Defaultloggedinlistbylocation.label","Default Logged in Practitioner's Primary Specialty in Patient List By Location"},// 33870 added.
//27709
{"eCA.Browser.label","Browser"},
{"eCA.InternetExplorer.label","Internet Explorer"},
{"eCA.GoogleChrome.label","Google Chrome"},
{"eCA.MozillaFirefox.label","Mozilla Firefox"}
//27709
};
}
