import java.util.StringTokenizer;
//import javax.comm.*;
import java.util.*;
import java.io.*;
import java.util.zip.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import javax.print.*;

//import javax.swing.*;
class PrintFile
{
	public static void main(String args[]){
			try{
				 FileOutputStream fout7 = new FileOutputStream("C:\\eHIS\\Reports\\PrintFileFirstFile.txt");
					// Writing the Exception to the File
					// Sanjay 05-Feb-14
					fout7.write(args[1].getBytes());
					// Writing the Footer to the File			
					fout7.close();
			 }
			 catch (Exception ee)
			 {
			 }
			//PrintFile pf = new PrintFile();
			switch(args.length) {
  			 case 15:		
			 System.out.println("Aruguments args[0]:"+args[0]+":args[1]:"+args[1]);
			 rl_print_ca_note(args[0], args[1], args[2], args[3], args[4], args[5], args[6], args[7], args[8], args[9], args[10], args[11], args[12], args[13], args[14]);
			 break;
			 default:		
				 System.out.println("Aruguments should be equal to  15");
				 //rl_print_ca_note(args[0]);
				 break;
			 
			}
			
	}
 
 private static void rl_print_ca_note(String specimenNo, String operatingFacilityId, String patientId, String printName, String sectionCode, String languageId, String param7, String param8, String noOfCopies, String user, String USERNAME, String PASSWORD, String URL, String wsNo, String sessionID)
	{
		// Declaring Connection Object
		Connection conn = null;
		// Declaring Callable Objects
		CallableStatement cstmt = null;
		CallableStatement cstmt1 = null;
		CallableStatement cstmt2 = null;
		CallableStatement cstmt3 = null;
		// Declaring prepared statements
		PreparedStatement pstmt = null;
		PreparedStatement pstmtRF = null;
		PreparedStatement pstmtCI = null;
		PreparedStatement pstmtBody = null;
		// Declaring Resultset
		ResultSet rs = null;		
		ResultSet rsRF = null;
		ResultSet rsCI = null;
		ResultSet rsBody = null;
				
		try
		{
			// Declaring variables to store the OUT parameters of rl_notes_printing_for_ca procedure
			String directoryName = "";
			String printerName = "";
			String draftPrintYN = "";
			String printStatus = "";
			String confidentialYN = "";
			// Declaring variable to hold Test Code returned from sql
			String testCode = "";
			String reportFormat = "";
			String customerId = "";
			// Declaring variables to insert into Clob object			
			String fileName = "";
			String sqlRF = "SELECT report_format FROM rl_param";
			String sqlCI = "SELECT NVL(customer_id, '!!') FROM SM_SITE_PARAM";
			String sqlBody = "SELECT char_val,char_val_compress FROM RL_TEMP_CLOB_TBL WHERE test_code = ? ORDER BY seqno";		//Added char_val_compress Against MO-CRF-20147.14
			String htmlFileName = "";
			// Declaring variables for header and Footer
			String header = "";
			String footer = "";
			String reportBody = "";
			String bodyStartTag = ""; 
			String bodyEndTag = "";
			int i = 0;	
			int flagToCheckPrinter = 0;
			Process child = null;            
			// Query to get values
			String sql = "SELECT test_code FROM  RL_OLE_RESULT_TEXT WHERE patient_id = ? AND specimen_no = ? AND operating_facility_id = ? AND group_test_code IN (SELECT test_code FROM RL_REQUEST_DETAIL WHERE patient_id = ? AND specimen_no = ? AND operating_facility_id = ?	AND NVL(cancelled_yn, 'N') <> 'Y' AND (NVL(result_status, 'O') IN ('R', ?) OR ? = 'Y' OR (test_code in (SELECT test_code FROM RL_TEST_CODE WHERE NVL(profile_yn, 'N') = 'Y' AND NVL(group_test_yn, 'N') = 'Y') AND (NVL(result_status,'O') = 'O' OR (NVL(result_status,'O') IN ('A') AND released_date IS NOT NULL))) OR (NVL(preliminary_release_yn,'N') = 'Y' AND NVL(result_status,'O') IN ('A')))) AND test_code in (SELECT test_code FROM RL_TEST_CODE	WHERE NVL(inhibit_report_yn, 'N') <> 'Y' AND NVL(confidential_yn, 'N') = ?) ORDER BY test_code ";
			/*String sql="SELECT test_code FROM  RL_OLE_RESULT_TEXT WHERE specimen='2019000058' ORDER BY test_code";*/
			// Below is the format of jdbc url for MySQL database.			
			if (!URL.contains("@"))
				URL =  "jdbc:oracle:thin:@" + URL;			
			// The username for connecting to the database
			//String USERNAME = "IFC";		  
			// The password for connecting to the database
			//String PASSWORD = "IFC";
			// Register a database jdbc driver to be used 
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			// Establish the Conenction object
			PASSWORD = PASSWORD.toLowerCase();
			System.out.println("URL-" + URL +"-USERNAME-" + USERNAME + "-PASSWORD-" + PASSWORD + "-");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);			
			try
			{
				cstmt = conn.prepareCall("{ call rl_notes_printing_for_ca(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
				// Set all the IN parameters of the Procedure				
				//cstmt.setInt(1, Integer.parseInt(specimenNo));
				cstmt.setString(1, specimenNo);
				cstmt.setString(2, operatingFacilityId);
				cstmt.setString(3, patientId);
				cstmt.setString(4, "RL");
				cstmt.setString(5, printName);
				cstmt.setString(6, sectionCode);
				cstmt.setString(7, languageId);
				cstmt.setString(8, param7);
				cstmt.setString(9, param8);
				cstmt.setString(10, user);
				cstmt.setString(11, wsNo);
				// Set all the OUT parameters of the Procedure				
				cstmt.registerOutParameter(12, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(13, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(14, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
				cstmt.registerOutParameter(16, java.sql.Types.VARCHAR);
				// Execute the procedure
				cstmt.execute();
				// Get all the OUT parameters from the procedure				
				directoryName = cstmt.getString(12);
				printerName = cstmt.getString(13);
				draftPrintYN = cstmt.getString(14);
				printStatus = cstmt.getString(15);
				confidentialYN = cstmt.getString(16);
				
				if(cstmt != null) cstmt.close();
				System.out.println("directoryName: " + directoryName);
				System.out.println("printerName: " + printerName);
				System.out.println("draftPrintYN: " + draftPrintYN);
				System.out.println("printStatus: " + printStatus);
				System.out.println("confidentialYN: " + confidentialYN);							
			}
			catch (Exception e1)
			{
				try
				{			
				
				System.out.println("Exception while calling rl_notes_printing_for_ca : " + e1);				
				File file = new File("C:\\eHIS\\Reports\\PrintFileError1.txt");
				PrintStream ps = new PrintStream(file);
				e1.printStackTrace(ps);				
				ps.close();
				}
				catch (Exception e21)
				{}
			}
			// Query to get Test Code
			try
			{
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,patientId);
				pstmt.setString(2,specimenNo);
				pstmt.setString(3,operatingFacilityId);
				pstmt.setString(4,patientId);
				pstmt.setString(5,specimenNo);
				pstmt.setString(6,operatingFacilityId);
				pstmt.setString(7,printStatus);
				pstmt.setString(8,draftPrintYN);
				pstmt.setString(9,confidentialYN);			
				rs = pstmt.executeQuery();
				while(rs.next() && rs!=null)
				{
					testCode = rs.getString(1);
					System.out.println("test_code: " + testCode);
					
					// Query to insert Clob Object
					try
					{			
						cstmt1 = conn.prepareCall("{ call RL_HTML_RESULT_TEXT.RL_CLOB_INSERT(?, ?, ?, ?) }");
						// Set all the IN parameters of the Procedure			
						cstmt1.setString(1, operatingFacilityId);
						//cstmt1.setInt(2, Integer.parseInt(specimenNo));
						cstmt1.setString(2, specimenNo);
						cstmt1.setString(3, patientId);
						cstmt1.setString(4, testCode);
						// Execute the procedure
						cstmt1.execute();
						// Closing
						if(cstmt1 != null) cstmt1.close();
						fileName = operatingFacilityId + specimenNo + testCode + "_" + sessionID + ".HTML";
						htmlFileName = directoryName + fileName;
						System.out.println("fileName: " + fileName);
						System.out.println("htmlFileName : " + htmlFileName);				
					}
					catch (Exception e3)
					{
						try{
						System.out.println("Exception while Inserting clob Object : " + e3);
						File file = new File("C:\\eHIS\\Reports\\PrintFileError3.txt");
						PrintStream ps = new PrintStream(file);
						e3.printStackTrace(ps);				
						ps.close();
						}
						catch (Exception e23)
						{}
					}
					
					// Execute Query to find get Report Format
					pstmtRF = conn.prepareStatement(sqlRF);
					rsRF = pstmtRF.executeQuery();
					while(rsRF.next() && rsRF!=null)
					{
						reportFormat = rsRF.getString(1);
						System.out.println("reportFormat: " + reportFormat);
					}
					// Closing
					if(rsRF != null) rsRF.close();
					if(pstmtRF != null) pstmtRF.close();

					// Execute Query to get Customer Id
					pstmtCI = conn.prepareStatement(sqlCI);
					rsCI = pstmtCI.executeQuery();
					while(rsCI.next() && rsCI!=null)
					{
						customerId = rsCI.getString(1);
						System.out.println("customerId: " + customerId);
					}
					// Closing
					if(rsCI != null) rsCI.close();
					if(pstmtCI != null) pstmtCI.close();

					// Condition for header part of the Report
					if (reportFormat.equals("4")|| reportFormat.equals("5")) {
						if (customerId.equals("AMRI")) {					
							System.out.println("H1");
							cstmt2 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC_AMRI(?, ?, ?, ?, ?, ?, ?)}");	
						}
						else {
							System.out.println("H2");
							// Sanjay 05-Feb-14
							//added "IF" cluse for MO-CRF-20101.5
							if (customerId.equals("MOD")) {	
							cstmt2 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC_MOD(?, ?, ?, ?, ?, ?, ?)}");
							}
							else
							{
							cstmt2 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC(?, ?, ?, ?, ?, ?, ?)}");	
							}
						}
					} else if (reportFormat.equals("7")) {
						System.out.println("H3");
						cstmt2 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC7(?, ?, ?, ?, ?, ?, ?)}");
					} else if (reportFormat.equals("6")) {
						System.out.println("H4");
						cstmt2 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC6(?, ?, ?, ?, ?, ?, ?)}");		
					}
					
					// Set all the OUT parameters of the Procedure
					// Sandeep K Gujje 13022014, VARCHAR length is 4000. Changed to CLOB to hold huge data
					//cstmt2.registerOutParameter(1, java.sql.Types.VARCHAR);
					cstmt2.registerOutParameter(1, java.sql.Types.CLOB);
					// Set all the IN parameters of the Procedure			
					cstmt2.setString(2,operatingFacilityId);
					//cstmt2.setInt(3, Integer.parseInt(specimenNo));
					cstmt2.setString(3, specimenNo);
					cstmt2.setString(4,testCode);						
					cstmt2.setString(5,languageId);
					cstmt2.setString(6,patientId);			
					cstmt2.setString(7,user);
					cstmt2.setString(8,"H");			
					// Execute the procedure
					cstmt2.execute();
					// Get all the OUT parameters from the procedure
					header = cstmt2.getString(1);
					System.out.println("Header:"+header);
					// Closing
					if(cstmt2 != null) cstmt2.close();
					
					// Condition for footer part of the Report
					if (reportFormat.equals("7") || reportFormat.equals("5")) {
						if (customerId.equals("AMRI")) {
							System.out.println("F1");
							cstmt3 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC_AMRI(?, ?, ?, ?, ?, ?, ?)}");
						}
						else {
							System.out.println("F2");
							//added "IF" cluse for MO-CRF-20101.5
							if (customerId.equals("MOD")) {	
							cstmt3 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC7_MOD(?, ?, ?, ?, ?, ?, ?)}");
							}
							else
							{
							cstmt3 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC7(?, ?, ?, ?, ?, ?, ?)}");
							}
						}
					} else if (reportFormat.equals("4")) {
							System.out.println("F3");
							cstmt3 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC(?, ?, ?, ?, ?, ?, ?)}");
					} else if (reportFormat.equals("6")) {
							System.out.println("F4");
							cstmt3 = conn.prepareCall("{ ? = call RL_HTML_RESULT_TEXT.RL_HTML_HEAD_FOOT_PROC6(?, ?, ?, ?, ?, ?, ?)}");
					}
					// Set all the OUT parameters of the Procedure
					cstmt3.registerOutParameter(1, java.sql.Types.VARCHAR);
					// Set all the IN parameters of the Procedure			
					cstmt3.setString(2, operatingFacilityId);			
					//cstmt3.setInt(3, specimenNo);			
					cstmt3.setString(3, specimenNo);			
					cstmt3.setString(4, testCode);			
					cstmt3.setString(5, languageId);			
					cstmt3.setString(6, patientId);			
					cstmt3.setString(7, user);
					cstmt3.setString(8, "F");
					// Execute the procedure
					cstmt3.execute();
					// Closing
					//if(cstmt3 != null) cstmt3.close();
					// Get all the OUT parameters from the procedure
					footer = cstmt3.getString(1);
					// Creating a HTML File
					System.out.println("Footer:"+footer);
					// Closing
					if(cstmt3 != null) cstmt3.close();

					FileOutputStream fout = new FileOutputStream(htmlFileName);
					// Writing the header to the HTML File
					// Sanjay 05-Feb-14
					fout.write(header.getBytes());
					// Writing the Footer to the HTML File
					fout.write(footer.getBytes());
					//fout.close();
					System.out.println("Report Started.. ");						
					//printerName = printerName + "XX";//Sanjay comment after testing
					// To print the Copies Specified no of times			
					
					//Body Starts here
					// Execute Query to find get Report Format
					pstmtBody = conn.prepareStatement(sqlBody);
					pstmtBody.setString(1,testCode);
					rsBody = pstmtBody.executeQuery();
					bodyStartTag = "<tbody><TR><TD>";
					bodyEndTag = "</table></TD></TR></tbody></table></BODY></HTML>";
					fout.write(bodyStartTag.getBytes());
					System.out.println("Report bodyStartTag added.. ");						
					while(rsBody.next() && rsBody!=null)
					{
						//Added Against MO-CRF-20147.14 Starts
							StringBuffer compresshistData = new StringBuffer();
							java.sql.Blob hist_data_blob =  (java.sql.Blob)rsBody.getBlob(2);
							if( hist_data_blob!= null && hist_data_blob.length()>0){
								InputStream ins1 = hist_data_blob.getBinaryStream();
								ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
								int c;
								while((c = ins1.read()) != -1) 
									bytearrayoutputstream.write(c);
								
								byte[] compressed	=bytearrayoutputstream.toByteArray();
								if(compressed.length > 0){
									if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
										GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
										BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

										String line;
										while ((line = bufferedReader.readLine()) != null) {							
											compresshistData.append(line+"\n");
										}
									}					
								}
								reportBody = compresshistData.toString();
							}
							//Added Against MO-CRF-20147.14 Ends
						else{
							reportBody = rsBody.getString(1);
						}
						fout.write(reportBody.getBytes());
						//System.out.println("reportFormat: " + reportFormat);
					}
					fout.write(bodyEndTag.getBytes());
					System.out.println("Report bodyEndTag added.. ");						
					// Closing
					if(rsBody != null) rsBody.close();
					if(pstmtBody != null) pstmtBody.close();
					//Body ENDS here
					fout.close();
				
				
				String command = "cmd /k htmlprint.exe -hidewindow -marginleft 15 -marginright 15 -printer " + "\"" + printerName + "\"" + " " + directoryName + fileName;
					System.out.println("1 File printed..123"+command);					
					try
					{						
						child = Runtime.getRuntime().exec(command);						
					}
					catch (Exception e)
					{	
						try{
						System.out.println("Exception while printing in PrintFile: " + e);
						File file = new File("C:\\eHIS\\Reports\\PrintFileError4.txt");
						PrintStream ps = new PrintStream(file);
						e.printStackTrace(ps);				
						ps.close();
						}
						catch (Exception e24)
						{}
					}
				}
				// Closing resultset and prepared statement
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				
			}
			catch (Exception e2)
			{
				try{

				System.out.println("Exception while Querying Test Code : " + e2);				
				File file = new File("C:\\eHIS\\Reports\\PrintFileError2.txt");
				PrintStream ps = new PrintStream(file);
				e2.printStackTrace(ps);				
				ps.close();
				}
				catch (Exception e22)
				{}
			}
			
			
			

			/*
			PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
			System.out.println("Number of print services: " + printServices.length);
			flagToCheckPrinter = 0;
			for (PrintService printer : printServices) {
				System.out.println("Printer: " + printer.getName());
				if (printer.getName().equals(printerName))
				{
					flagToCheckPrinter = 1;
					break;
				}
			}
			*/
			flagToCheckPrinter = 1;
			/*if (flagToCheckPrinter == 1)
			{
				i = 0;
				Process child = null;
				while (i < Integer.parseInt(noOfCopies))
				{			
					// Execute command cls && start /b cmd
					//String command = "cmd /c htmlprint.exe -hidewindow -marginleft 15 -marginright 15 -printer " + "\"" + printerName + "\"" + " " + directoryName + fileName;
					String command = "cmd /k htmlprint.exe -hidewindow -marginleft 15 -marginright 15 -printer " + "\"" + printerName + "\"" + " " + directoryName + fileName;
					System.out.println("1 File printed..");					
					try
					{						
						child = Runtime.getRuntime().exec(command);						
					}
					catch (Exception e)
					{	
						try{
						System.out.println("Exception while printing in PrintFile: " + e);
						File file = new File("C:\\eHIS\\Reports\\PrintFileError4.txt");
						PrintStream ps = new PrintStream(file);
						e.printStackTrace(ps);				
						ps.close();
						}
						catch (Exception e24)
						{}
					}
					//child.getRuntime().close();
					System.out.println("Report Printed..");
					//exit();				
					//Window.close();				
					i++;
				}
				
			}	*/	
				
						
			if(conn != null) conn.close();			
		}
		catch (Exception ee)
		{
			try{
			System.out.println("Exception PrintFile: " + ee);
			File file = new File("C:\\eHIS\\Reports\\PrintFileError.txt");
			PrintStream ps = new PrintStream(file);
			ee.printStackTrace(ps);				
			ps.close();
			}
			catch (Exception e20)
			{}
		}
		finally 
		{
			try
			{
				if(conn != null) conn.close();
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(rsRF != null) rsRF.close();
				if(pstmtRF != null) pstmtRF.close();
				if(rsCI != null) rsCI.close();
				if(pstmtCI != null) pstmtCI.close();
				if(cstmt != null) cstmt.close();
				if(cstmt1 != null) cstmt1.close();
				if(cstmt2 != null) cstmt2.close();
				if(cstmt3 != null) cstmt3.close();
			}				
			catch (Exception e)
			{
				try{
					File file = new File("C:\\eHIS\\Reports\\PrintFileError6.txt");
					PrintStream ps = new PrintStream(file);
					e.printStackTrace(ps);				
					ps.close();
				}
			catch (Exception e10)
			{
			}			
		}
	}
}
}