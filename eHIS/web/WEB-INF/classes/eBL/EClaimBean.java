/*
Sr No      Version           TFS             SCF/CRF           				Developer Name
-----------------------------------------------------------------------------------------------
1          V210305          15347        NMC-JD-CRF-0087.1					  Mohana Priya K
2          V210315          15959        BL-NMC-JD-CRF-0087.1/01-Date format  Mohana Priya K
3		   V210326			16280		 NMC-JD-SCF-0156					  Mohana Priya K
4		   V210413			17034	   	 NMC-JD-SCF-0179 TF					  Mohana Priya K
5		   V220201			27305		 NMC-JD-CRF-0134					  Mohana Priya K
-----------------------------------------------------------------------------------------------
 */
package eBL;
import java.sql.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import eBL.Common.BlAdapter;

public class EClaimBean extends BlAdapter implements Serializable{
	HSSFWorkbook wb = new HSSFWorkbook();
	Properties	p = getProperties();
	String	 locale	= "";

	public void doCommon() throws Exception {
		locale	= (String) p.getProperty("LOCALE");
		}

	public HSSFWorkbook createWorkBook(HashMap<String, ArrayList<ArrayList<String>>> data){ 
	   	String strCellValue="";
	    HSSFSheet sheet = wb.createSheet("new sheet");
		HSSFFont font = wb.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		font.setFontHeightInPoints((short)12);
		font.setFontName("Arial");
		font.setItalic(false);
		font.setStrikeout(false);
		
       HSSFCellStyle style = wb.createCellStyle();
       style.setFont(font);	
	   HSSFRow row = sheet.createRow(0);
	   HSSFCell cell = null;
	   try{
	   String strHeader[] = new String []{ "Claim Count","Bupa ID","Patient File No","Policy Number","Insurer name","Policy Name","Patient Name","Invoice No","Invoice Date","Preauth ID","Doctor Name","Specialty","Clinical Data","ICD10 1" ,"ICD10 2","ICD10 3","ICD10 4","Claim Type","REFER_IND",
		"EMER_IND","Total Invoice Deductible","Tooth No","Service Code/Pharmacy codes (SFDA Global Trade Item Number Codes (GTIN))","Service Description","Treatment Date From","Treatment Date To","Inputted Quantity","Billed Amount","Line Item Discount","VAT","(Left)eye Test Reading",
		"(Right)eye Test Reading","Times" ,"Per","Unique Member ID","Unique Physician Id(SCHS License number)","Date of admission","Date of discharge","Admission Type","Discharge Disposition","Emergency Department Disposition"
		,"Admission Diagnosis(ICD-10-AM 10th version)","Principal Diagnosis(ICD-10-AM 10th version)","Additional Diagnosis(ICD-10-AM 10th version)","Condition Onset Flag","Principal Procedure(ACHI version 10)","Additional Procedure (ACHI) up to 5 (ACHI version 10)",
		"AR DRG(AR DRG V9.0)","Surgery Flag","Authorisation number","Days Supply","Emergency Arrival Code","Emergency Service Start" ,"Emergency Waiting Time","Service Event Type","Care Type","Activity Object - Code(LOINC code sets version 2.65 )","LOINC code value(Test value as per LOINC specifications)","Type of encounter",
		"Primary Diagnosis","Class","Encounter ID","Approval No","Approval date","Posted date"}; //V210305 //V210326 //V210413 //V220201
	
		//Code For Column Header	    
		cell = null;
		for (int j=0;j<strHeader.length ;j++ ){
			cell = row.createCell((short)j);
			cell.setCellValue(strHeader[j]);
			cell.setCellStyle(style);			
		}
		System.err.println("Data before writing Excel files "+data);
	   //Code For Column Header ends here
		ArrayList<String> arrCol = new ArrayList<String>();
		ArrayList<ArrayList<String>> arrRow = new ArrayList<ArrayList<String>>();
		if(data!=null){
			if(data.get("record")!= null){
				arrRow = (ArrayList<ArrayList<String>>) data.get("record");
				System.err.println("arrRow size "+arrRow.size());
				int sizeCol = 0;
				for (int i=0; i<arrRow.size();i++ ){						
					arrCol =(ArrayList<String>) arrRow.get(i);
					row = sheet.createRow(i+1);
					cell = null;
					sizeCol = arrCol.size();
					System.err.println("arrCol size "+arrCol.size());						
					for(int k=0;k<sizeCol ;k++){
						strCellValue=(String) arrCol.get(k);
						cell = row.createCell((short)k);
						cell.setCellValue(strCellValue);
					}
				}
			}
		}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Exception in EClaimBean "+e);
		}	   
	return wb;	
 }
   
public HashMap<String, ArrayList<ArrayList<String>>> getData(String facility_id,int no_Of_columns){
	// TODO Auto-generated method stub
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;

	HashMap<String, ArrayList<ArrayList<String>>> data=new HashMap<String, ArrayList<ArrayList<String>>>();
	ArrayList<ArrayList<String>> arrRow = new ArrayList<ArrayList<String>>(); 
	ArrayList<String> arrCell = null; 

try{	
		con=ConnectionManager.getConnection();
		/*String strSQL="select bl_count, bl_member_id , BL_PATIENT_NO , BL_POLICY_NO , BL_PAYER_NAME ,BL_POLICY_NAME ,BL_POLICY_NAME policy_class ,"+
		" BL_PATIENT_NAME  ,BL_INV_NO, TO_CHAR (bl_invoice_date, 'ddmmyyyy') bl_invoice_date,BL_APPRV_NO , BL_DOC_NAME , BL_SPECLIATY  , BL_CLINICAL_DATA ,bl_ph_diag,"+
		"bl_icd101  ,bl_icd102 ,bl_icd103 ,bl_icd104 ,decode(BL_CLAIM_TYPE,'OP','O','ER','O') claim_type,"+
		"BL_TOT_INV_DEDUCT,BL_TOOTH_NO ,BL_SERV_CODE,BL_SERV_DESC,TO_CHAR (bl_tretment_date_fm, 'dd/mm/yyyy') bl_tretment_date_fm, TO_CHAR (bl_tretment_date_to, 'dd/mm/yyyy') bl_tretment_date_to  ,"+
		" BL_INPUT_QTY, BL_BILL_AMT , BL_DISC_AMT,BL_VAT_AMT ,BL_LEFT_EYE_TEST ,BL_RIGHT_EYE_TEST ,BL_UNQ_MEMBER_ID  , BL_UNQ_PHYSICN_ID,"+
		"decode(BL_ENCOUNTER_TYPE,'OP','Outpatient - patient not admitted and not seen in Emergency Department','ER','Emergency - patient is seen in Emergency Department and is not admitted to Inpatient Bed') type_of_encounter,"+
		"bl_encounter_id,BL_DOC_APPRV_NO,TO_CHAR (bl_apprv_date, 'dd/mm/yyyy') bl_apprv_date,TO_CHAR (bl_posted_date, 'dd/mm/yyyy') bl_posted_date from bl_temp_eclaims order by bl_count";  //V210305 //V210315
		*/
		String strSQL="select bl_count, bl_member_id , BL_PATIENT_NO , BL_POLICY_NO , BL_PAYER_NAME ,BL_POLICY_NAME ,"+
		" BL_PATIENT_NAME  ,BL_INV_NO, TO_CHAR (bl_invoice_date, 'ddmmyyyy') bl_invoice_date,BL_APPRV_NO , BL_DOC_NAME , BL_SPECLIATY  , BL_CLINICAL_DATA ,"+
		"bl_icd101  ,bl_icd102 ,bl_icd103 ,bl_icd104 ,decode(BL_CLAIM_TYPE,'OP','O','ER','O') claim_type,"+
		"BL_TOT_INV_DEDUCT,BL_TOOTH_NO ,BL_SERV_CODE,BL_SERV_DESC,TO_CHAR (bl_tretment_date_fm, 'ddmmyyyy') bl_tretment_date_fm, TO_CHAR (bl_tretment_date_to, 'ddmmyyyy') bl_tretment_date_to  ,"+
		" BL_INPUT_QTY, BL_BILL_AMT , BL_DISC_AMT,BL_VAT_AMT ,BL_LEFT_EYE_TEST ,BL_RIGHT_EYE_TEST ,BL_UNQ_MEMBER_ID  , BL_UNQ_PHYSICN_ID,"+
		"bl_encounter_type,bl_ph_diag,BL_POLICY_CLASS policy_class ,bl_encounter_id,BL_DOC_APPRV_NO,TO_CHAR (bl_apprv_date, 'dd/mm/yyyy') bl_apprv_date,TO_CHAR (bl_posted_date, 'dd/mm/yyyy') bl_posted_date from bl_temp_eclaims order by bl_count";  //V210305 //V210315
		//V210326
			
	stmt=con.createStatement();
	rs=stmt.executeQuery(strSQL);
	
     while(rs.next()) { 
		arrCell = new ArrayList<String>();
		//V210326 starts
		arrCell.add(rs.getString(1));
		arrCell.add(rs.getString(2));
		arrCell.add(rs.getString(3));
		arrCell.add(rs.getString(4));
		arrCell.add(rs.getString(5));
		arrCell.add(rs.getString(6));
		arrCell.add(rs.getString(7));
		arrCell.add(rs.getString(8));
		arrCell.add(rs.getString(9));
		arrCell.add(rs.getString(10));
		arrCell.add(rs.getString(11));
		arrCell.add(rs.getString(12));
		arrCell.add(rs.getString(13));
		arrCell.add(rs.getString(14));
		arrCell.add(rs.getString(15));
		arrCell.add(rs.getString(16));
		arrCell.add(rs.getString(17));
		arrCell.add(rs.getString(18));
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(rs.getString(19));
		arrCell.add(rs.getString(20));
		arrCell.add(rs.getString(21));
		arrCell.add(rs.getString(22));
		arrCell.add(rs.getString(23));
		arrCell.add(rs.getString(24));
		arrCell.add(rs.getString(25));
		arrCell.add(rs.getString(26));
		arrCell.add(rs.getString(27));
		arrCell.add(rs.getString(28));
		arrCell.add(rs.getString(29));
		arrCell.add(rs.getString(30));
		arrCell.add(null);
		arrCell.add(null);
		
		arrCell.add(rs.getString(31));
		arrCell.add(rs.getString(32));  //V210413
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		//arrCell.add(rs.getString(32)); //commented V210413
		
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		arrCell.add(null);
		
		arrCell.add(rs.getString(33));
		arrCell.add(rs.getString(34));
		arrCell.add(rs.getString(35));	
		//V210305 Starts
		arrCell.add(rs.getString(36));	
		arrCell.add(rs.getString(37));	
		arrCell.add(rs.getString(38));	
		arrCell.add(rs.getString(39));	
		//V210305 Ends
		//V210326 ends
		arrRow.add(arrCell);		
	}
	data.put("record",arrRow);
	}catch(Exception exp){
		exp.printStackTrace();
		System.err.println("Caught Exception in EClaimbean- getData, err="+exp);
	}finally{
			try{ 
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	return data;
	}//end of getdata function
}