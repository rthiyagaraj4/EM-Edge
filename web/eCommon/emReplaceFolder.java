import java.io.*;
import java.util.*;
import java.io.File;


/**
 * This program reads a Java, JSP, JS and HTML file line by line, will search for the patterns and will replace.
 */
public class emReplaceFolder {	

	static FileWriter writerLog = null;
	static String logFileTextLine = "";	

	public static void main(String[] args) {		

		String path = "."; 		
		// Reads the current path
		File folder = new File(path);
		// Reads the current 
		replaceBackSlash(folder);	
		//replaceJSPParam(folder);

	}

	public static String replaceString(String aInput, String  aOldPattern, String aNewPattern){
	    return aInput.replace(aOldPattern, aNewPattern);
	}
	
	public static void replaceBackSlash(File file){

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		BufferedOutputStream outStream = null;

		File rfile;

		String backDoubleSlash = "..\\\\";
		String backSingleSlash = "..\\";

		String frontSlash = "../";

		String eCommonBackDSlash = "\\\\eCommon", eCommonBackSSlash = "\\eCommon"; 
		String eCommonFrontSlash = "/eCommon";

		String jspBackDSlash = "\\\\jsp\\\\", jspBackSSlash = "\\jsp\\"; 
		String jspFrontSlash = "/jsp/";

		String jsBackDSlash = "\\\\js\\\\", jsBackSSlash = "\\js\\"; 
		String jsFrontSlash = "/js";

		String htmlBackDSlash = "\\\\html\\\\", htmlBackSSlash = "\\html\\"; 
		String htmlFrontSlash = "/html/";

		String imagesBackDSlash = "\\\\images\\\\", imagesBackSSlash = "\\images\\"; 
		String imagesFrontSlash = "/images/";

		String mediBackDSlash = "\\\\MediPainter\\\\", mediBackSSlash = "\\MediPainter\\"; 
		String mediFrontSlash = "/MediPainter/";

		String iconsBackDSlash = "\\\\icons\\\\", iconsBackSSlash = "\\icons\\"; 
		String iconsFrontSlash = "/icons/";

		String cssBackDSlash = "\\\\css\\\\", cssBackSSlash = "\\css\\"; 
		String cssFrontSlash = "/css/";

		String css2BackDSlash = "\\\\css2\\\\", css2BackSSlash = "\\css2\\"; 
		String css2FrontSlash = "/css2/";

		String reportsBackDSlash = "\\\\reports\\\\", reportsBackSSlash = "\\reports\\"; 
		String reportsFrontSlash = "/reports/";

		String eCommonJSP = "eCommon/jsp/common.jsp";
		String eCommonJSPNew = "eCommon/jsp/Common.jsp";
		
		// Directory path here
		String type = "jsp"; 

		String files;

		String fileOldLine = "", tempLine = "";
		String fileNewLine = "";
		String fileTextLine = "";
	 
		String logFile = "StringReplace_Log.log";			

		String filePath = "";

		boolean writeFlag = false;
		boolean writeLogFlag = false;

		String jspIncludeTag = "";
		String jspParamTag = "";
		String oldParamTag = "";
		String newJspIncludeTag = "";

		int flushPos = 0;



		try {

			if (file.isDirectory()) {					

				File[] listOfFiles = file.listFiles();
				for (int i = 0; i < listOfFiles.length; i++){					
					
					fileTextLine = "";
					writeFlag = false;

					if (listOfFiles[i].isFile()) 
					{
						if ((listOfFiles[i].getName().endsWith("jsp")) || (listOfFiles[i].getName().endsWith("js")) || (listOfFiles[i].getName().endsWith("html"))
								|| (listOfFiles[i].getName().endsWith("java")))
						{
						
							files = listOfFiles[i].getName();
							filePath = listOfFiles[i].getPath();

							System.out.println("Path : "+filePath);

							if (!(filePath.indexOf("emReplaceFolder")>0))
							{
								
								System.out.println("------------------------------------------------------");


								rfile = new File(filePath);				
								
								fis = new FileInputStream(rfile);

								// Here BufferedInputStream is added for fast reading.
								bis = new BufferedInputStream(fis);
								dis = new DataInputStream(bis);

								logFileTextLine += "File : "+filePath;
								logFileTextLine += "\n"+"------------------------------------------"+"\n"; 

								// dis.available() returns 0 if the file does not have more lines.
								while (dis.available() != 0) {

									// this statement reads the line from the file and print it to
									// the console.
									
									writeLogFlag = false;
									fileOldLine = dis.readLine();	
									tempLine = "";
									
									fileNewLine = fileOldLine;	
									
									if ((fileOldLine.indexOf(".jsp")>0) || (fileOldLine.indexOf(".js")>0) || (fileOldLine.indexOf(".html")>0) ||
											(fileOldLine.indexOf(".gif")>0) || (fileOldLine.indexOf(".jpg")>0) || (fileOldLine.indexOf(".png")>0))
									{
										// Double Backslash to be changed to single front slash
										if (fileOldLine.indexOf(backDoubleSlash)>0)
										{
											System.out.println(" Double backslash : "+fileOldLine);								
											fileNewLine = replaceString(fileOldLine, backDoubleSlash, frontSlash);
											System.out.println(" Newline : "+fileNewLine);		
											writeFlag = true;
											writeLogFlag = true;
										}						
										
										// Single Backslash to be changed to single front slash
										if (fileNewLine.indexOf(backSingleSlash)>0)
										{
											System.out.println(" Single backslash : "+fileNewLine);		
											fileNewLine = replaceString(fileNewLine, backSingleSlash, frontSlash);					
											System.out.println(" Newline : "+fileNewLine);		
											writeFlag = true;
											writeLogFlag = true;
										}	
									}
									
									
									// eCommon Double Backslash to be changed to eCommon front slash
									if (fileNewLine.indexOf(eCommonBackDSlash)>0)
									{
										System.out.println(" eCommon backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, eCommonBackDSlash, eCommonFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// eCommon Single Backslash to be changed to eCommon front slash
									if (fileNewLine.indexOf(eCommonBackSSlash)>0)
									{
										System.out.println(" eCommon backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, eCommonBackSSlash, eCommonFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// jsp Double Backslash to be changed to jsp front slash
									if (fileNewLine.indexOf(jspBackDSlash)>0)
									{
										System.out.println(" jsp backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, jspBackDSlash, jspFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// jsp Single Backslash to be changed to jsp front slash
									if (fileNewLine.indexOf(jspBackSSlash)>0)
									{
										System.out.println(" jsp backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, jspBackSSlash, jspFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// js Double Backslash to be changed to js front slash
									if (fileNewLine.indexOf(jsBackDSlash)>0)
									{
										System.out.println(" js backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, jsBackDSlash, jsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// js Single Backslash to be changed to js front slash
									if (fileNewLine.indexOf(jsBackSSlash)>0)
									{
										System.out.println(" js backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, jsBackSSlash, jsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// html Double Backslash to be changed to html front slash
									if (fileNewLine.indexOf(htmlBackDSlash)>0)
									{
										System.out.println(" html backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, htmlBackDSlash, htmlFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// html Single Backslash to be changed to html front slash
									if (fileNewLine.indexOf(htmlBackSSlash)>0)
									{
										System.out.println(" html backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, htmlBackSSlash, htmlFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// images Double Backslash to be changed to images front slash
									if (fileNewLine.indexOf(imagesBackDSlash)>0)
									{
										System.out.println(" images backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, imagesBackDSlash, imagesFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// images Single Backslash to be changed to images front slash
									if (fileNewLine.indexOf(imagesBackSSlash)>0)
									{
										System.out.println(" images backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, imagesBackSSlash, imagesFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// MediPainter Double Backslash to be changed to MediPainter front slash
									if (fileNewLine.indexOf(mediBackDSlash)>0)
									{
										System.out.println(" MediPainter backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, mediBackDSlash, mediFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// MediPainter Single Backslash to be changed to MediPainter front slash
									if (fileNewLine.indexOf(mediBackSSlash)>0)
									{
										System.out.println(" MediPainter backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, mediBackSSlash, mediFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// icons Double Backslash to be changed to icons front slash
									if (fileNewLine.indexOf(iconsBackDSlash)>0)
									{
										System.out.println(" icons backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, iconsBackDSlash, iconsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// icons Single Backslash to be changed to icons front slash
									if (fileNewLine.indexOf(iconsBackSSlash)>0)
									{
										System.out.println(" icons backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, iconsBackSSlash, iconsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// css Double Backslash to be changed to css front slash
									if (fileNewLine.indexOf(cssBackDSlash)>0)
									{
										System.out.println(" css backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, cssBackDSlash, cssFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// css Single Backslash to be changed to css front slash
									if (fileNewLine.indexOf(cssBackSSlash)>0)
									{
										System.out.println(" css backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, cssBackSSlash, cssFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// css2 Double Backslash to be changed to css2 front slash
									if (fileNewLine.indexOf(css2BackDSlash)>0)
									{
										System.out.println(" css2 backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, css2BackDSlash, css2FrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// css2 Single Backslash to be changed to css2 front slash
									if (fileNewLine.indexOf(css2BackSSlash)>0)
									{
										System.out.println(" css2 backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, css2BackSSlash, css2FrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									// Reports Double Backslash to be changed to Reports front slash
									if (fileNewLine.indexOf(reportsBackDSlash)>0)
									{
										System.out.println(" reports backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, reportsBackDSlash, reportsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									// Reports Single Backslash to be changed to Reports front slash
									if (fileNewLine.indexOf(reportsBackSSlash)>0)
									{
										System.out.println(" reports backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, reportsBackSSlash, reportsFrontSlash);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		

									if (fileNewLine.indexOf(eCommonJSP)>0)
									{
										System.out.println(" reports backslash : "+fileNewLine);		
										fileNewLine = replaceString(fileNewLine, eCommonJSP, eCommonJSPNew);					
										System.out.println(" Newline : "+fileNewLine);		
										writeFlag = true;
										writeLogFlag = true;
									}		
									
									if ((fileNewLine.indexOf("<jsp:include page=")>0) && (fileNewLine.indexOf(".jsp")>0))
									{
										
										if (fileNewLine.indexOf("flush=\"true\"")>0)
										{
											jspIncludeTag = fileNewLine.substring(fileNewLine.indexOf("<jsp:include page="),fileNewLine.indexOf("flush=\"true\"")) + ">";
										}

										if (fileNewLine.indexOf("flush=\"true\"")>0)
										{
											jspParamTag = "<jsp:param name=\"flush\" value=\"true\" />";
										}

										if (fileNewLine.indexOf("flush=\"true\">")>0)
										{
											flushPos = fileNewLine.indexOf("flush=\"true\">") + 13;
										}
										else if (fileNewLine.indexOf("flush=\"true\" >")>0)
										{
											flushPos = fileNewLine.indexOf("flush=\"true\" >") +14;
										}
										
										if ((fileNewLine.indexOf("flush=\"true\">")>0) || (fileNewLine.indexOf("flush=\"true\" >")>0))
										{
											tempLine = fileNewLine.substring(fileNewLine.indexOf("<jsp:include page="),flushPos);
											newJspIncludeTag = jspIncludeTag + jspParamTag;
											fileNewLine = replaceString(fileNewLine, tempLine, newJspIncludeTag);

											writeFlag = true;
											writeLogFlag = true;
										}
										
									}	

									if (writeLogFlag)
									{
										logFileTextLine += "OLD : "+ fileOldLine + "\n";
										logFileTextLine += "NEW : "+ fileNewLine + "\n";
									}								

									fileTextLine += fileNewLine + "\n";							
									
								}

								logFileTextLine += "------------------------------------------";
								logFileTextLine += "\n";

								// dispose all the resources after using them.
								fis.close();
								bis.close();
								dis.close();

								if (writeFlag) 
								{
									FileWriter writer = new FileWriter(filePath);
									writer.write(fileTextLine);
									writer.close();
								}						
								
								writerLog = new FileWriter(logFile);
								writerLog.write(logFileTextLine);	
								writerLog.close();
							}
							
						}
						else
						{
							System.out.println("Files not searched for ; "+listOfFiles[i]);
						}

					}
					else
					{
						replaceBackSlash(listOfFiles[i]);					
						System.out.println("Folder : "+listOfFiles[i]);

					}
					
				}
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void replaceJSPParam(File file){

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		BufferedOutputStream outStream = null;

		File rfile;		

		int flushPos = 0;
		
		// Directory path here
		String type = "jsp"; 

		String files;

		String fileOldLine = "", tempLine = "";
		String fileNewLine = "";
		String fileTextLine = "";
	 
		String logFile = "StringReplace_Log.log";			

		String filePath = "";

		String jspIncludeTag = "";
		String jspParamTag = "";
		String oldParamTag = "";
		String newJspIncludeTag = "";

		boolean writeFlag = false;
		boolean writeLogFlag = false;

		try {

			if (file.isDirectory()) {					

				File[] listOfFiles = file.listFiles();
				for (int i = 0; i < listOfFiles.length; i++){					
					
					fileTextLine = "";
					writeFlag = false;

					if (listOfFiles[i].isFile()) 
					{
						if ((listOfFiles[i].getName().endsWith("jsp")) || (listOfFiles[i].getName().endsWith("js")) || (listOfFiles[i].getName().endsWith("html"))
								|| (listOfFiles[i].getName().endsWith("java")))
						{
						
							files = listOfFiles[i].getName();
							filePath = listOfFiles[i].getPath();

							System.out.println("Path : "+filePath);

							if (!(filePath.indexOf("stringReplace")>0))
							{
								
								System.out.println("------------------------------------------------------");


								rfile = new File(filePath);				
								
								fis = new FileInputStream(rfile);

								// Here BufferedInputStream is added for fast reading.
								bis = new BufferedInputStream(fis);
								dis = new DataInputStream(bis);

								logFileTextLine += "File : "+filePath;
								logFileTextLine += "\n"+"------------------------------------------"+"\n"; 

								// dis.available() returns 0 if the file does not have more lines.
								while (dis.available() != 0) {

									// this statement reads the line from the file and print it to
									// the console.
									
									writeLogFlag = false;
									fileOldLine = dis.readLine();	
									tempLine = "";
									
									fileNewLine = fileOldLine;	
									
									if ((fileOldLine.indexOf("<jsp:include page=")>0) && (fileOldLine.indexOf(".jsp")>0))
									{
										System.out.println(" fileOldLine : "+fileOldLine);

										jspIncludeTag = fileOldLine.substring(0,fileOldLine.indexOf(".jsp")+5) + ">";

										if (fileOldLine.indexOf("flush=\"true\"")>0)
										{
											jspParamTag = "<jsp:param name=\"flush\" value=\"true\"/>";
										}

										if (fileOldLine.indexOf("flush=\"true\">")>0)
										{
											flushPos = fileOldLine.indexOf("flush=\"true\">") + 13;
										}
										else if (fileOldLine.indexOf("flush=\"true\" >")>0)
										{
											flushPos = fileOldLine.indexOf("flush=\"true\" >") +14;
										}

										tempLine = fileOldLine.substring(fileOldLine.indexOf("<jsp:include page="),flushPos);

										newJspIncludeTag = jspIncludeTag + jspParamTag;

										fileNewLine = replaceString(fileNewLine, tempLine, newJspIncludeTag);
										System.out.println(" fileNewLine : "+fileNewLine);										
									}									
									
									fileTextLine += fileNewLine + "\r\n";							
									
								}

								logFileTextLine += "------------------------------------------";
								logFileTextLine += "\n";

								// dispose all the resources after using them.
								fis.close();
								bis.close();
								dis.close();
								
								/*
								if (writeFlag) 
								{
									FileWriter writer = new FileWriter(filePath);
									writer.write(fileTextLine);
									writer.close();
								}						
								
								writerLog = new FileWriter(logFile);
								writerLog.write(logFileTextLine);	
								writerLog.close();
								*/
							}
							
						}
						else
						{
							System.out.println("Files not searched for ; "+listOfFiles[i]);
						}

					}
					else
					{
						replaceJSPParam(listOfFiles[i]);					
						System.out.println("Folder : "+listOfFiles[i]);

					}
					
				}
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

} 
