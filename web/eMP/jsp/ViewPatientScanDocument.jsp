<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.FileUtils" %>
<%
	String patient_id = request.getParameter("patient_id");
	System.out.println(" * * * patient_id * * * "+patient_id);
	//String newPDF = application.getRealPath("") +"\\eMP\\PatientDocuments\\" +patient_id + "_01.pdf";
	String newPDF = "\\\\cscappche608\\eHIS\\Documents\\eMP\\" +patient_id + "_01";
	System.out.println(" * * * newPDF * * * "+newPDF);
	//File pdfFile = (File) request.getAttribute(newPDF);
	File pdfFile = new File(newPDF);
	byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);
	//response.setContentType("application/pdf");
	response.getOutputStream().write(pdfByteArray);
	response.getOutputStream().flush();
%>
