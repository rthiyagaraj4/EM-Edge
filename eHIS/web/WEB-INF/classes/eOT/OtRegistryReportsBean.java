/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;
import java.net.*;
import java.sql.*;
import org.apache.poi.hssf.model.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import java.io.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import java.util.*;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eOT.Common.OTAdapter;
public class OtRegistryReportsBean extends OTAdapter implements Serializable{

	HSSFWorkbook wb = new HSSFWorkbook();
	Properties	p = getProperties();
	String	 locale	= "";

	public void doCommon() throws Exception {
		locale	= (String) p.getProperty("LOCALE");
		}

	

   public HSSFWorkbook createWorkBook(HashMap data){  
    try{
		int count=0;
		String[] strHeader=(String[]) data.get("strHeader");
		
		String[] strFooter_specimen1=(String[]) data.get("strFooter1");
		String[] strFooter_specimen2=(String[]) data.get("strFooter2");
		String[] strFooter_specimen3=(String[]) data.get("strFooter3");
		String strFooter_specimen4=(String) data.get("strFooter4");
		//this for loop is for placing the headers in the center based on the no of columns in the report
		for(int n=0;n<strHeader.length;n++)
		{
			count++;
		}
		
		count=count/2;
		String siteName=(String) data.get("site_name");
		String facilityName=(String) data.get("facility_name");
		String reportDesc=(String) data.get("report_desc");
		ArrayList hdrDtl1=(ArrayList) data.get("hdrDtl1");// this is specific for placing footer detail for the specimen register report
				
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
		
		//Row for Placing the Site Name
		cell=row.createCell((short)count);
		cell.setCellValue(siteName);
		cell.setCellStyle(style);
		

        //Row For placing Facility Name
		row=sheet.createRow(1);
		cell=row.createCell((short)count);
		cell.setCellValue(facilityName);
		cell.setCellStyle(style);
		

		//Row For Placing Report Description
        row=sheet.createRow(2);
		cell=row.createCell((short)count);
		cell.setCellValue(reportDesc);
		cell.setCellStyle(style);
		
        
		
		// Code For Header Details starts
        String temp="";	
		int count1=0;
		for (int b=0;b<hdrDtl1.size() ;b++ ){
			row=sheet.createRow(b+4);
			cell = null;
			temp=(String) hdrDtl1.get(b);
			
			StringTokenizer st2=new StringTokenizer(temp,"*");
			
			
               while (st2.hasMoreElements())
               {
				   strCellValue=st2.nextToken();
				   cell = row.createCell((short)count1);
			       cell.setCellValue(strCellValue);
				   if(count1%2==0)
                     cell.setCellStyle(style);
					 count1++;	

               }
			   
  			 count1=0; 
		}
       // header Deatils  ends

	   //Code For Column Header
       
		row=sheet.createRow(8);
		cell = null;
        for (int j=0;j<strHeader.length ;j++ ){
  			cell = row.createCell((short)j);
			cell.setCellValue(strHeader[j]);
			cell.setCellStyle(style);
		
		}
       //Code For Column Header ends here
		

		//Code For Records Display in the Excel Sheet Starts
    	ArrayList arrCol =new ArrayList();

		ArrayList arrRow = new ArrayList();
		if(data!=null){
			if(data.get("record")!= null){
				arrRow = (ArrayList) data.get("record");
//				int size = 0;
				int sizeCol = 0;
				for (int i=0; i<arrRow.size();i++ ){
					
					arrCol =(ArrayList) arrRow.get(i);
					
					row = sheet.createRow(i+9);
					cell = null;
					sizeCol = arrCol.size();
					
					for(int k=0;k<sizeCol ;k++){
						strCellValue=(String) arrCol.get(k);
						cell = row.createCell((short)k);
						cell.setCellValue(strCellValue);
					}
				}
			}
			else
			{
			}
			int rowsize=9+arrRow.size();
			
			    if(data.get("strFooter1")!=null && data.get("strFooter2")!=null && data.get("strFooter3")!=null && data.get("strFooter4")!=null )
			    {
				row = sheet.createRow(rowsize+1);
				cell = null;
					
					
				for(int p=0;p<strFooter_specimen1.length ;p++){
						cell = row.createCell((short)p);
						cell.setCellValue(strFooter_specimen1[p]);
						
					}
               row = sheet.createRow(rowsize+2);
				cell = null;
					
					
				for(int q=0;q<strFooter_specimen1.length ;q++){
						cell = row.createCell((short)q);
						cell.setCellValue(strFooter_specimen2[q]);
						
					}
			 row = sheet.createRow(rowsize+3);
				cell = null;
					
					
				for(int r=0;r<strFooter_specimen1.length ;r++){
						cell = row.createCell((short)r);
						cell.setCellValue(strFooter_specimen3[r]);
						
					}

			    row = sheet.createRow(rowsize+4);
				cell = null;
				cell = row.createCell((short)0);
				cell.setCellValue(strFooter_specimen4);
				}	

				else{
				}
						
		}else
		{
		}
		//Code For Records Display in the Excel Sheet ends

	    //FileOutputStream fileOut = new FileOutputStream("C:/workbook1.xls");
		//wb.write(fileOut);
		//fileOut.close();
    }
    catch(Exception exp)
    {
      System.err.println("Caught Exception in createWorkBook, err="+exp);
    }   
 return wb;
}

	   
public HashMap getData(String facility_id,String strSQL,int no_Of_columns,String report_id,String header_Details,String sql_site_name,String sql_facility_name,String sql_report_desc){
	Connection con=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt_1=null;
	PreparedStatement pstmt_2=null;
	PreparedStatement pstmt_3=null;
	PreparedStatement pstmt_4=null;
	ResultSet resultset=null;
	ResultSet rs=null;

	String str = "";
	String strTemp = "";
	String strTempOperation = "";
	String strAddedInOTSlate = ""; //AAKH-CRF-90
	String strSurgeon="";
	String strAnesthetist="";
	String strOper="";
	String strpersonnel="";
	String strSpecimen="";
	String strDiagnosis="";
	String strTime="";
	String strFooter1[]=new String[] {"List Checked By:","","Specimen Recieved By:"};
	String strFooter2[]=new String[] {"Person Despatching Specimen:","","Date Recieved:"};
	String strFooter3[]=new String[] {"Date Sent:","","Time Recieved:"};
	String strFooter4="Time Sent:";
//	String checking="";
	HashMap data=new HashMap();
	ArrayList arrPreviousCell = null;
	ArrayList arrRow = null; 
	ArrayList arrCell = null; 
	ArrayList hdrDtl1 = null;  
	StringTokenizer st1=new StringTokenizer(header_Details,"#");
	hdrDtl1 = new ArrayList();
	while (st1.hasMoreElements()){
	  hdrDtl1.add(st1.nextToken());
	}
	if ( report_id.equals("OTROPREG")){
		data.put("hdrDtl1",hdrDtl1);               
		String strHeader[] = new String []{ "Sl. No.","Operation No.","Oper Date","MRN","Patient Name","Sex","Age","NRIC","Ward","Race","Nature Of Surgery","Pre-OP Diagnosis","Post-OP Diagnosis","Type Of Anaesthesia" ,"Operation","Added in OT Slate","Personnel Involved","Time Details","Specimen"};//AAKH-CRF-90
		data.put("strHeader",strHeader);
	}else if(report_id.equals("OTRREGRP")){
		data.put("hdrDtl1",hdrDtl1);
	    String strHeader1[] = new String []{ "Sl. No.","Operation No.","Oper Date","MRN","Patient Name","Sex","NRIC","Department","Specimen Dtl","Name of Test/Examination"};
		data.put("strHeader",strHeader1);
	}else if (report_id.equals("OTRIMPRY")){
		data.put("hdrDtl1",hdrDtl1);
		String strHeader2[] = new String []{ "Sl. No.","Operation No.", "Oper Date", "MRN", "Patient Name", "Age", "Sex", "NRIC", "Discipline", "Surgeon", "Operation", "Type", "Quantity", "Consignment Item", "Implant Vendor", "Recording Nurse", "Remarks"};
		data.put("strHeader",strHeader2);
	}else if (report_id.equals("OTRODISP")){       
		data.put("hdrDtl1",hdrDtl1);
		String strHeader3[] = new String []{"Sl. No.","Operation No.", "Oper Date", "MRN", "Patient Name", "Sex", "Age", "NRIC", "Ward", "Name of Body Part/Non-Specimen/ Foreign Body", "Disposed To", "Given By", "Received By" };
		data.put("strHeader",strHeader3);
    }else if (report_id.equals("ATRANREG")){
		data.put("hdrDtl1",hdrDtl1);
		String strHeader4[] = new String []{"Sl. No.", "Oper No.", "Oper Date", "Patient ID", "Name", "Sex", "Age", "NRIC", "Ward", "Anesthesia Type","Operation","Start Time","End Time","Surgeon", "Anesthetist" };
		data.put("strHeader",strHeader4);
    }		
    try{
			
		//p=getProperties();
		//java.util.Properties p=getProperties();
		data.put("properties", p);
		con=ConnectionManager.getConnection();
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql_site_name);
		while(rs.next()){
		  data.put("site_name",rs.getString("SITE_NAME"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();

		pstmt = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE FACILITY_ID=? AND LANGUAGE_ID = ?") ;
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locale);		
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			data.put("facility_name",resultset.getString("FACILITY_NAME"));
		}
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();
	 
		//pstmt = con.prepareStatement("SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID =? AND MODULE_ID=? ") ;
		pstmt = con.prepareStatement("SELECT REPORT_DESC FROM SM_REPORT_LANG_VW WHERE  REPORT_ID =? AND MODULE_ID=? AND LANGUAGE_ID = ?") ;
		pstmt.setString(1,report_id);
		pstmt.setString(2,"OT");
		pstmt.setString(3,locale);
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			data.put("report_desc",resultset.getString("REPORT_DESC"));
		}
		if(resultset!=null) resultset.close();
		if(pstmt!=null) pstmt.close();

	  	arrRow = new ArrayList();
		
	    int k=1;  //for serial no in the report
		stmt=con.createStatement();
		rs=stmt.executeQuery(strSQL);
		if(report_id.equals("OTROPREG")){
			pstmt_1 = con.prepareStatement("SELECT A.OPER_NUM ,  B.SHORT_NAME ||'('||C.ROLE_DESC||')' PRACT_ID FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B, OT_ROLES_LANG_VW C  WHERE B.LANGUAGE_ID='"+locale+"' AND C.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM  = ? AND   A.PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND   A.ROLE_ID = C.ROLE_ID(+) order by 1");
			pstmt_2 = con.prepareStatement("SELECT SPECIALITY_CODE ,  TO_CHAR(SURG_START_TIME,'HH24:MI')  SURG_START_TIME,   TO_CHAR(SURG_END_TIME, 'HH24:MI') SURG_END_TIME , OPER_NUM  FROM  OT_POST_OPER_DTL2 WHERE OPERATING_FACILITY_ID = ? AND   OPER_NUM  = ? ORDER BY  1");
			pstmt_3 = con.prepareStatement("SELECT OPER_NUM, SPECIMEN_DTL FROM OT_POST_OPER_SPECIMENS WHERE OPERATING_FACILITY_ID = ? AND   OPER_NUM  = ? ORDER BY 1");
			pstmt_4 = con.prepareStatement("SELECT  A.OPER_NUM,  B.SHORT_DESC  DIAG_DESC FROM  OT_POST_OPER_DIAG A,  MR_ICD_CODE   B WHERE A.DIAG_CODE  =  B.DIAG_CODE AND OPERATING_FACILITY_ID=? AND A.OPER_NUM = ? ORDER BY 1");
			while (rs.next()){		
//				int count=1;				
				strpersonnel="";
                strTime="";
				strSpecimen="";
				strDiagnosis="";

				arrCell = new ArrayList();
                arrCell.add(""+k);
				
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
				
				strDiagnosis=rs.getString(13);
			
				if(resultset!=null) resultset.close();	  
				pstmt_4.setString(1,rs.getString(1));
				pstmt_4.setString(2,rs.getString(2));
				resultset	= pstmt_4.executeQuery();
		        while (resultset.next()){
				   str = resultset.getString(2);
				   str=str==null?"":str;
				   str=str.equalsIgnoreCase("null")?"":str;
				   if(strDiagnosis==null || strDiagnosis.equals("null") || strDiagnosis.equals(""))
					 strDiagnosis=str;			  
				   else
					 strDiagnosis=strDiagnosis+", "+str;
			    }
				if(pstmt_4!=null)pstmt_4.close();	//Added Against Common-ICN-0031
				str="";
				arrCell.add(strDiagnosis);
				arrCell.add(rs.getString(14));                				
				if (strTemp.equalsIgnoreCase(rs.getString(2))){
					strTempOperation = strTempOperation+","+rs.getString(16);
				}else {
					arrCell.add(rs.getString(16));
					arrPreviousCell = arrCell;
					strTemp = "";
					strTempOperation = rs.getString(16);
				}
				arrPreviousCell.set(14,strTempOperation);

				if(resultset!=null) resultset.close();	  
				pstmt_1.setString(1,rs.getString(1));
				pstmt_1.setString(2,rs.getString(2));
				resultset	= pstmt_1.executeQuery();
				while (resultset.next()){
					if(strOper.equalsIgnoreCase(resultset.getString(1))){
						strpersonnel=strpersonnel+","+resultset.getString(2);
					}else{
						strpersonnel=resultset.getString(2);							
						strOper="";
                    }
					strOper=resultset.getString(1);
				}			
				if(pstmt_1!=null)pstmt_1.close();	//Added Against Common-ICN-0031
				if(resultset!=null)resultset.close();	//Added Against Common-ICN-0031
				//Added for AAKH-CRF-90								
				if (strTemp.equalsIgnoreCase(rs.getString(2))){
					strAddedInOTSlate = strAddedInOTSlate+","+rs.getString(17);					
				}else {
					arrCell.add(rs.getString(17));
					arrPreviousCell = arrCell;
					strTemp = "";
					strAddedInOTSlate = rs.getString(17);				
				}				
				arrPreviousCell.set(15,strAddedInOTSlate);				
				//AAKH-CRF-90

				arrCell.add(strpersonnel);  

				if(resultset!=null) resultset.close();	  
				pstmt_2.setString(1,rs.getString(1));
				pstmt_2.setString(2,rs.getString(2));
				resultset	= pstmt_2.executeQuery();
				while(resultset.next()){
					if(resultset.getString(1).equals("*ALL")){
						strTime= (resultset.getString(2)==null?"":resultset.getString(2)) +"-"+ (resultset.getString(3)==null?"":resultset.getString(3));					
					}else{
						if(strTime.equals("")){
						   if(resultset.getString(1).equals("*ALL"))
								strTime=(resultset.getString(2)==null?"":resultset.getString(2)) +"-"+ (resultset.getString(3)==null?"":resultset.getString(3));
						   else if(strTime.equals(""))
								strTime= (resultset.getString(1)==null?"":resultset.getString(1)) +" : "+ (resultset.getString(2)==null?"":resultset.getString(2)) +" - "+ (resultset.getString(3)==null?"":resultset.getString(3));
						}else{ 
							 if(resultset.getString(1).equals("*ALL"))
								strTime= (resultset.getString(2)==null?"":resultset.getString(2)) +"-"+ (resultset.getString(3)==null?"":resultset.getString(3)); 
							 else 
								strTime=strTime+","+resultset.getString(1)+" : "+ (resultset.getString(2)==null?"":resultset.getString(2)) +" - "+ (resultset.getString(3)==null?"":resultset.getString(3));
						}
					}
				}
			    arrCell.add(strTime);				
				if(resultset!=null) resultset.close();	  
				pstmt_3.setString(1,rs.getString(1));
				pstmt_3.setString(2,rs.getString(2));
				resultset	= pstmt_3.executeQuery();
				while(resultset.next()){
					if(strSpecimen.equals(""))
						strSpecimen=resultset.getString(2);
					else
						strSpecimen=strSpecimen+", "+resultset.getString(2);
				}		  
				arrCell.add(strSpecimen);					  
				if(pstmt_3!=null)pstmt_3.close();	//Added Against Common-ICN-0031
				if (!strTemp.equalsIgnoreCase(rs.getString(2))){
						arrRow.add(arrCell);
					    data.put("record",arrRow);
						k++;
				}						 
				strTemp = rs.getString(2);
		   }
		}else if(report_id.equals("ATRANREG")){
			pstmt_1 = con.prepareStatement("SELECT A.OPER_NUM ,  B.SHORT_NAME ||'('||C.ROLE_DESC||')' PRACT_ID FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B, OT_ROLES_LANG_VW C  WHERE B.LANGUAGE_ID='"+locale+"' AND C.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = ? AND   A.OPER_NUM  = ? AND   A.PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND   A.ROLE_ID = C.ROLE_ID(+)  AND A.ROLE_TYPE IN ('OS', 'AS') ");
			pstmt_2 = con.prepareStatement("SELECT A.OPER_NUM ,  B.SHORT_NAME ||'('||C.ROLE_DESC||')' PRACT_ID FROM OT_POST_OPER_PERSONNEL A, AM_PRACTITIONER_LANG_VW B, OT_ROLES_LANG_VW C  WHERE B.LANGUAGE_ID='"+locale+"' AND C.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID = ? AND   A.OPER_NUM  = ? AND   A.PRACTITIONER_ID = B.PRACTITIONER_ID(+) AND   A.ROLE_ID = C.ROLE_ID(+) AND A.ROLE_TYPE IN ('MA', 'AA')");

			while (rs.next()){	
				strSurgeon="";
				strAnesthetist="";
                
				arrCell = new ArrayList();
                arrCell.add(""+k);
				arrCell.add(rs.getString(2));
				arrCell.add(rs.getString(3));
				arrCell.add(rs.getString(4));
				arrCell.add(rs.getString(5));
				arrCell.add(rs.getString(6));
				arrCell.add(rs.getString(7));
				arrCell.add(rs.getString(8));
				arrCell.add(rs.getString(9));
				arrCell.add(rs.getString(10));
				//arrCell.add(rs.getString(10));
					  
				if (strTemp.equalsIgnoreCase(rs.getString(2))){
					arrPreviousCell.set(10,strTempOperation+","+rs.getString(12));					
				}else{
					arrCell.add(rs.getString(12));
					arrCell.add(rs.getString(13));
					arrCell.add(rs.getString(14));

					arrPreviousCell = arrCell;
					strTemp = "";
					strTempOperation = rs.getString(10);
				}
				if(resultset!=null) resultset.close();	  
				pstmt_1.setString(1,rs.getString(1));
				pstmt_1.setString(2,rs.getString(2));
				resultset	= pstmt_1.executeQuery();
				while (resultset.next()){
					 if(strSurgeon.equals(""))
						 strSurgeon=resultset.getString(2);
					 else
						 strSurgeon=strSurgeon+", "+resultset.getString(2);
				 }
				if(pstmt_1!=null)pstmt_1.close();
				 arrCell.add(strSurgeon);
				if(resultset!=null) resultset.close();	  
				pstmt_2.setString(1,rs.getString(1));
				pstmt_2.setString(2,rs.getString(2));
				resultset	= pstmt_2.executeQuery();
				while (resultset.next()){
					 if(strAnesthetist.equals(""))
						strAnesthetist=resultset.getString(2);
					 else
						strAnesthetist=strAnesthetist+", "+resultset.getString(2);			 
				}
				if(pstmt_2!=null)pstmt_2.close();
				arrCell.add(strAnesthetist);				  
				if (!strTemp.equalsIgnoreCase(rs.getString(2))){
					arrRow.add(arrCell);
					data.put("record",arrRow);
					k++;
				}	
				strTemp = rs.getString(2);
				if(resultset!=null) resultset.close(); //Common-ICN-0054
            }//end of while
		 }else {		  
			while (rs.next()){		  			
				arrCell = new ArrayList();
				arrCell.add(""+k);
				for(int i=1;i<=no_Of_columns;i++){
					arrCell.add(rs.getString(i));
				}
				arrRow.add(arrCell);
				data.put("record",arrRow);
				k++;
			}
		 } 
	   if(report_id.equals("OTRREGRP")){		   
          data.put("strFooter1",strFooter1);
		  data.put("strFooter2",strFooter2);
		  data.put("strFooter3",strFooter3);
		  data.put("strFooter4",strFooter4);
        }
		
			
	}
    catch(Exception exp)
    {
		exp.printStackTrace();
      System.err.println("Caught Exception in getData, err="+exp);
    }finally{
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();
			if(pstmt_1!=null) pstmt_1.close();
			if(pstmt_2!=null) pstmt_2.close();
			if(pstmt_3!=null) pstmt_3.close();
			if(pstmt_4!=null) pstmt_4.close();
			//if(con!=null) con.close();
			if(con!=null) ConnectionManager.returnConnection(con); //Common-ICN-0052
		}catch(Exception e){}
}
return data;
// return temp_map;

}//end of getdata function

}

