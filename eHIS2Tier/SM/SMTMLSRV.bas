Attribute VB_Name = "modSMTMLSRV"
Global GWorkstatinID As String
Global GLastLogDate As String
Global GTmpStr As String
Global GCmdStr As String
Global GLogTable As Recordset
Global GLocalDB As Database
Global GRecordCtr As Integer
Global GCountSet As Recordset
Global GDBCurrentDateTime As String
Global GRequestTable As Recordset
Global GParamTable As Recordset
Global GAuditLogTable As Recordset
Global GSQLText As String
Global GMEDICOMDBConnectString As String
Global GDSName As String
Global GHideFormYN As Integer
Global GLogFileName As String
Global GMailProfileName As String       ' Email profile name
Global GSuccessYN As Boolean
Global GFacilityIDArg As String
Global GRestartYN As Boolean        ' To restart the program.
Global GTestingYN As Boolean        ' To restart the program.
Global GCommandStr As String
Global GLogRecordCtr As Double
Global GMinutesElapsed As Double

' SM_REPORT_FAX_MAIL_REQUEST table data
Global GFacilityID As String
Global GModuleID As String
Global GReportID As String
Global GLocationType As String
Global GLocationCode As String
Global GRoutingMode As String
Global GReportFileName As String
Global GUserID As String
Global GRequestDate As Date

Global GManualMailYN As Boolean     ' Mail routing fetched or manual mail


' appfaxmail.GET_FAXMAIL_ROUTING_PROPERTY stored procedure
Global GRoutingFound As Boolean
Global GMailID As String
Global GErrorText As String

' appfaxmail.GET_MAIL_DETAILS stored procedure
Global GMailAddress As String
Global GMailCcAddress As String
Global GMailBccAddress As String
Global GMailSubject As String
Global GMailText As String
Global GSalutation As String
Global GBody As String
Global GFooter As String

' Test mail parameters
Global GTestMailAddress As String
Global GTestMailCcAddress As String
Global GTestMailBccAddress As String
Global GTestMailSubject As String
Global GTestMailAttachment As String
Global GTestMailText As String
Global GPCLConvertTool As String


Function CheckFileExists(PFileName)
    If PFileName = "" Then
        CheckFileExists = False
        Exit Function
    Else
        Set fs = CreateObject("Scripting.FileSystemObject")
        If Not fs.FileExists(PFileName) Then
            CheckFileExists = False
            Exit Function
        End If
    End If
    CheckFileExists = True
End Function


