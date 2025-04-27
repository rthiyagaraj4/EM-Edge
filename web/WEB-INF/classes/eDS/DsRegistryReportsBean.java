package eDS;
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
import eDS.*;
import eDS.Common.*;
import java.util.*;
import java.util.Properties;
import eCommon.Common.CommonBean;
import eDS.Common.DSAdapter;
public class DsRegistryReportsBean extends DSAdapter implements Serializable{

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
		/* String[] strFooter_specimen1=(String[]) data.get("strFooter1");
		String[] strFooter_specimen2=(String[]) data.get("strFooter2");
		String[] strFooter_specimen3=(String[]) data.get("strFooter3");
		String strFooter_specimen4=(String) data.get("strFooter4"); */ //Common-ICN-0044
		//this for loop is for placing the headers in the center based on the no of columns in the report
		for(int n=0;n<strHeader.length;n++){
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
         while (st2.hasMoreElements()){
				   strCellValue=st2.nextToken();
				   cell = row.createCell((short)count1);
			       cell.setCellValue(strCellValue);
				   if(count1%2==0)
                     cell.setCellStyle(style);
					 count1++;	
               }
  			 count1=0; 
		} //for-loop ending
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
				} // for-loop end
			} // if-loop end
			else
			{
			}
			//int rowsize=9+arrRow.size();		//Common-ICN-0044	    
		} // ends data
		else{
		}
		//Code For Records Display in the Excel Sheet ends
    }catch(Exception exp){
      exp.printStackTrace();
    }   
 return wb;
}
	   
public HashMap getData(String facility_id,String strSQL,int no_Of_columns,String report_id,String header_Details,String sql_site_name,String sql_facility_name,String sql_report_desc,String qryHeader){
	Connection con=null;	
	Statement stmt=null;
	PreparedStatement pstmt=null;
	/* PreparedStatement pstmt_1=null;
	PreparedStatement pstmt_2=null;
	PreparedStatement pstmt_3=null;
	PreparedStatement pstmt_4=null; */	//Common-ICN-0044
	ResultSet resultset=null;
	ResultSet rs=null;

	String str = "";
	String strTemp = "";
	/* String strTempOperation = "";
	String strAddedInOTSlate = ""; 
	String strSurgeon="";
	String strAnesthetist="";
	String strOper=""; */	//Common-ICN-0044
	String strpersonnel="";
	String strSpecimen="";
	String strDiagnosis="";
	String remarks="";
	String strTime="";
	/* String strFooter1[]=new String[] {"List Checked By:","","Specimen Recieved By:"};
	String strFooter2[]=new String[] {"Person Despatching Specimen:","","Date Recieved:"};
	String strFooter3[]=new String[] {"Date Sent:","","Time Recieved:"};
	String strFooter4="Time Sent:"; 
	ArrayList arrPreviousCell = null;*/	//Common-ICN-0044
	HashMap data=new HashMap();
	ArrayList arrRow = null; 
	ArrayList arrCell = null; 
	ArrayList hdrDtl1 = null;  
	ArrayList<String> result = new ArrayList<String>();
	/* String strConcat="";
	String strMerge="";
	String strMealTypeModify=""; */	//Common-ICN-0044
	String NBM="";
	StringTokenizer st1=new StringTokenizer(header_Details,"#");
	hdrDtl1 = new ArrayList();
	while (st1.hasMoreElements()){
	  hdrDtl1.add(st1.nextToken());
	}
		try{
		con=ConnectionManager.getConnection();
		
		pstmt = con.prepareStatement(qryHeader) ;
	if (report_id.equals("DSORSHET")){ //DS Module
		data.put("hdrDtl1",hdrDtl1);               
	
		String strHeading[] = new String []{ "Bed No","Patient ID","Patient Name","Age","DietType","NBM","Nutritional Diagnosis","Feeding Instruction"};
		
		for(int k=0; k<strHeading.length;k++){
			result.add(strHeading[k]);
		}
		result.add("Remarks");
		resultset=pstmt.executeQuery();
		while(resultset.next()){
			result.add(resultset.getString("meal_type_desc"));
		}
		
		String strHeader[] = (String[])result.toArray(new String[result.size()]);
		data.put("strHeader",strHeader);
		
	} //if cond ends
		data.put("properties", p);
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql_site_name);
		while(rs.next()){
		  //data.put("site_name",rs.getString("SITE_NAME"));
		}
		data.put("site_name","Diet Order Sheet");
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
	 
		pstmt = con.prepareStatement("SELECT REPORT_DESC FROM SM_REPORT_LANG_VW WHERE  REPORT_ID =? AND MODULE_ID=? AND LANGUAGE_ID = ?") ;
		pstmt.setString(1,report_id);
		pstmt.setString(2,"DS");
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
		
		if(report_id.equals("DSORSHET")){
			while (rs.next()){									
				strpersonnel="";
                strTime="";
				strSpecimen="";
				strDiagnosis="";
				str="";
				remarks="";
				arrCell = new ArrayList(31);
 				arrCell.add(CommonBean.checkForNull(rs.getString(1))); // Bed no-1
				arrCell.add(CommonBean.checkForNull(rs.getString(2))); // Patient Id-2
				arrCell.add(CommonBean.checkForNull(rs.getString(3))); // patient Name-3 
				arrCell.add(CommonBean.checkForNull(rs.getString(4))); // Age-4
				arrCell.add(CommonBean.checkForNull(rs.getString(5))); // Diet Type-5
				NBM=CommonBean.checkForNull(rs.getString(6).trim());
				if(NBM.equals("-"))
				   NBM="";
				arrCell.add(NBM); // NBM-6
				arrCell.add(CommonBean.checkForNull(rs.getString(7))); // Nutritional Diagnosis-7
				arrCell.add(CommonBean.checkForNull(rs.getString(8))); // Feeding Instruction-8
				remarks=CommonBean.checkForNull(rs.getString(9));
				if(remarks.equalsIgnoreCase("null"))
					remarks="";
				arrCell.add(remarks); // Remarks-9
				//-10 Meal Type cell-Start from-1
				for(int l=0;l<22;l++)
				{
					arrCell.add(""); 
				}				
			
				//-22 Meal Type cell-End
				String arrRowHeader[] = (String[])data.get("strHeader");
				int arrRowIndex=0;
				//Header Row count
				for(int rowIndex = 0;rowIndex<arrRowHeader.length;rowIndex++)
				{
					if(arrRowHeader[rowIndex].equals(rs.getString(10))) //MealTypeDesc
					{
						arrRowIndex = rowIndex;
						break;
					}						
				}
				
				arrCell.set(arrRowIndex,rs.getString(12));				
				String patientId = rs.getString(2);
					
				if (!strTemp.equalsIgnoreCase(rs.getString(2))){
					arrRow.add(arrCell);
					data.put("record",arrRow);//Datas
					k++;
				}else{
					ArrayList arrColumn = (ArrayList)data.get("record");
					int arrColumnIndex=0;
					
					for(int colIndex = 0;colIndex<arrColumn.size();colIndex++)
					{
						if(((ArrayList)arrColumn.get(colIndex)).get(1).equals(patientId))
						{
							arrColumnIndex = colIndex;
							break;
						}						
					}
					
					//ArrayList arrList = arrColumn.get(arrColumnIndex);
					//arrColumn.set(arrColumnIndex,arrCell);
					ArrayList mealTyeValue = (ArrayList)arrColumn.get(arrColumnIndex);
					mealTyeValue.set(arrRowIndex,rs.getString(12));
					arrColumn.set(arrColumnIndex,mealTyeValue);
				}
				strTemp = rs.getString(2);
		   }// while loop end
		}	   
	}
    catch(Exception exp)
    {
		exp.printStackTrace();
    }finally{
		try{
			//Common-ICN-0044
			arrRow.clear();
			arrCell.clear();
			hdrDtl1.clear();
			//Common-ICN-0044
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(resultset!=null) resultset.close();
			if(pstmt!=null) pstmt.close();
			//if(con!=null) con.close();
			if(con!=null)closeConnection(con); //Common-ICN-0052
		}catch(Exception e){
			e.printStackTrace();
		}
}
return data;
// return temp_map;
}//end of getdata function
}
