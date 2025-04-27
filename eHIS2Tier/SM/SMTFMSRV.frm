VERSION 5.00
Begin VB.Form frmSMTFMSRV 
   BackColor       =   &H00B17300&
   BorderStyle     =   1  'Fixed Single
   Caption         =   "IBA Fax Manager"
   ClientHeight    =   1965
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   4170
   ClipControls    =   0   'False
   Icon            =   "SMTFMSRV.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   ScaleHeight     =   1965
   ScaleWidth      =   4170
   StartUpPosition =   3  'Windows Default
   Begin VB.PictureBox WebBrowser1 
      Height          =   735
      Left            =   3000
      ScaleHeight     =   675
      ScaleWidth      =   1035
      TabIndex        =   4
      Top             =   1320
      Visible         =   0   'False
      Width           =   1095
   End
   Begin VB.TextBox ProgressBar 
      BackColor       =   &H0000C000&
      BorderStyle     =   0  'None
      Enabled         =   0   'False
      ForeColor       =   &H00FFFFFF&
      Height          =   375
      Left            =   250
      TabIndex        =   3
      Top             =   1200
      Width           =   255
   End
   Begin VB.Timer CurrTimer 
      Enabled         =   0   'False
      Interval        =   1000
      Left            =   1440
      Top             =   1560
   End
   Begin VB.Timer RequestTimer 
      Enabled         =   0   'False
      Interval        =   1
      Left            =   1920
      Top             =   1560
   End
   Begin VB.Label MsgText 
      BackColor       =   &H00B17300&
      ForeColor       =   &H00FFFFFF&
      Height          =   255
      Left            =   240
      TabIndex        =   5
      Top             =   1650
      Width           =   3855
   End
   Begin VB.Label Label2 
      Alignment       =   2  'Center
      BackColor       =   &H00B17300&
      Caption         =   "Ver 2.0"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9.75
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFF00&
      Height          =   255
      Left            =   360
      TabIndex        =   2
      Top             =   720
      Width           =   3495
   End
   Begin VB.Label CurrTime 
      Alignment       =   1  'Right Justify
      BackColor       =   &H00B17300&
      Caption         =   "CurrTime"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00E0E0E0&
      Height          =   255
      Left            =   2520
      TabIndex        =   1
      Top             =   0
      Width           =   1575
   End
   Begin VB.Label Label1 
      Alignment       =   2  'Center
      BackColor       =   &H00B17300&
      Caption         =   "IBA Fax Manager"
      BeginProperty Font 
         Name            =   "Book Antiqua"
         Size            =   14.25
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00FFFFC0&
      Height          =   375
      Left            =   360
      TabIndex        =   0
      Top             =   360
      Width           =   3495
   End
End
Attribute VB_Name = "frmSMTFMSRV"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
' -------------------------------------------------------------------------------------------------------
' Revision History
' -------------------------------------------------------------------------------------------------------
' Date          Who         Version     Remarks
' -------------------------------------------------------------------------------------------------------
' Jan 04,05     S. Sundar   1.0         Created.
' Sep 28,05     S. Sundar   2.0         Priority Faxing Added.
' Jan 07,06     S. Sundar   2.0         Explicity (Manual) Faxing Handled.
' Jan 24,06     S. Sundar   2.0         If FROM_USER,TEL,FAX are NULL, call get_contact_details
'
' -------------------------------------------------------------------------------------------------------
Dim wdApp As Object   ' Declare variable to hold the reference.
Dim en As rdoEnvironment
Dim er As rdoError
Dim cn As rdoConnection
Dim rQry As rdoQuery
Private Sub CurrTime_DblClick()
    Call SpoolLog(False, True)
End Sub
Private Sub CurrTimer_Timer()
    On Error GoTo err
    
    CurrTime = FormatDateTime(Now, vbShortDate) & " " & FormatDateTime(Now, vbShortTime)
    ProgressBar.Left = ProgressBar.Left + 50
    If ProgressBar.Left > 3500 Then
        ProgressBar.Left = 250
    End If
    
    Exit Sub
err:
    WriteLog ("Error at CurrTimer_Timer() : " & err.Description)
End Sub
Private Sub Form_Load()
    Call Initialize
End Sub
Private Sub Initialize()
    Dim strArgs() As String
    Dim IsFormHidden As Boolean
    
    On Error GoTo err
    
    ' Read command line argument and decide whether the form is to be shown
    ' or hidden.
    GCommandStr = Command$
    GCmdStr = "SMTFMSRV " & GCommandStr
    strArgs = Split(Command$, " ")
    
    'Dispaly command line arguments.
    
    ' Read facility id. This is used to check whether the program is running
    ' or not.
    GFacilityIDArg = strArgs(3)
    
    IsFormHidden = False
    If UBound(strArgs) >= 0 Then
        If UCase(Right(GCommandStr, 1)) = "H" Then
            ' Hide the form.
            If GHideFormYN Then
                IsFormHidden = True
                Me.Hide
            End If
        End If
    Else
        ' Show the form.
        Me.Show
    End If
    
    If Not IsFormHidden Then
        ' Position objects
        Me.Left = 3500
        Me.Top = 2000
        ProgressBar.Left = 250
        ProgressBar.BackColor = &HFFFFFF 'Idle
    
        ' Load animated MEDICOM. Commented since it is not working.
        'WebBrowser1.Navigate "about:<html><body scroll='no'><img src='C:\Sundar\MEDICOM\MEDI\MEDFaxMGR\AnimatedMEDICOM.GIF'></img></body></html>"
        
        ' Display current time
        CurrTime = FormatDateTime(Now, vbShortDate) & " " & FormatDateTime(Now, vbShortTime)
    End If
    
    ' Open local database.
    Set GLocalDB = DBEngine.Workspaces(0).OpenDatabase("C:\MEDICOM\SMTFMSRV\SMTFMSRV.MDB")
    
    ' Purge log.
    GSQLText = "DELETE FROM Log;"
    GLocalDB.Execute GSQLText
    
    ' Get program PATH and timestamp.
    GTmpStr = App.Path & "\" & App.EXEName & ".EXE"
    ' Open audit log table (Log)
    Set GLogTable = GLocalDB.OpenRecordset("Log", dbOpenDynaset)
    WriteLog ("Program Start.")
    GTmpStr = App.Path '& "\" & App.EXEName & ".EXE"
    WriteLog ("Program=[" & GTmpStr & "] TimeStamp=[" & FileDateTime(GTmpStr) & "]")
    WriteLog ("Args=[" & GCommandStr & "]")
    
    ' Read and validate parameters (Param table).
    GMEDICOMDBConnectString = ""
    GDSName = ""
    GTestingYN = False
    GRestartYN = False
    GControlDocument = ""
    GHideFormYN = 0
    Set GParamTable = GLocalDB.OpenRecordset("Param", dbOpenDynaset)
    GParamTable.MoveFirst
    With GParamTable
        Do While Not .EOF
            If UCase(GParamTable!ID) = UCase("ConnectString") Then
                GMEDICOMDBConnectString = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("DSName") Then
                GDSName = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("ControlDocument") Then
                GControlDocument = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("HideFormYN") Then
                GHideFormYN = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("LogFileName") Then
                GLogFileName = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("Testing") Then
                GTestingYN = GParamTable!Value
            ElseIf UCase(GParamTable!ID) = UCase("Restart") Then
                GRestartYN = GParamTable!Value
            End If
            GParamTable.MoveNext
        Loop
    End With
    GParamTable.Close
    
    If GMEDICOMDBConnectString = "" Then
        Response = MsgBox("ReadParam() : Unable to read database connect string !!", vbCritical, "MEDICOM FAX Manager")
        GoTo Abort
    Else
        WriteLog ("DB Connect String=[" & GMEDICOMDBConnectString & "]")
    End If
    
    If GDSName = "" Then
        Response = MsgBox("ReadParam() : Unable to read data source name !!", vbCritical, "MEDICOM FAX Manager")
        GoTo Abort
    Else
        WriteLog ("Data Source=[" & GDSName & "]")
    End If
    
    If GControlDocument = "" Then
        Response = MsgBox("ReadParam() : Unable to read control document name !!", vbCritical, "MEDICOM FAX Manager")
        GoTo Abort
    Else
        WriteLog ("Control Document=[" & GControlDocument & "]")
    End If
    WriteLog ("Restart?=[" & GRestartYN & "]")
    
    GSuccessYN = True
    Call ODBCTesting
    If Not GSuccessYN Then
        GoTo Abort
    End If
    
    ' Open word application
    Set wdApp = CreateObject("word.application")
    
    ' Set visible false
    wdApp.Visible = False
    
    'Call FaxTesting
    'Call PrintFaxControlDocument
  
    ' Enable timer control.
    RequestTimer.Enabled = True
    GMinutesElapsed = 0
    CurrTimer.Enabled = True
    
    WriteLog ("Initialization Complete.")
    Exit Sub

err:
    Response = MsgBox("Error at Intitialize() : " & err.Description, vbCritical, "MEDICOM FAX Manager")
Abort:
    Call Terminate
End Sub
Private Sub ReOpenWordApplication()
    On Error GoTo err
    'Close Word application
    wdApp.Quit
    Set wdApp = Nothing

    ' Open word application and set visible false
    Set wdApp = CreateObject("word.application")
    wdApp.Visible = False
    Exit Sub
err:
    WriteLog ("Error at RequestTimer_Timer() : " & err.Description)
    err.Clear
End Sub
Private Sub Terminate()
    On Error Resume Next
    
    'Close Word application
    wdApp.Quit
    Set wdApp = Nothing
    
    'Disable timers
    RequestTimer.Enabled = False
    CurrTimer.Enabled = False
    
    If GLogRecordCtr > 0 Then
        Call SpoolLog(True, False)
    End If
    
    ' Close local database.
    GLocalDB.Close
    
    'Restart new instance, if set.
    If GRestartYN = True Then
        GRetVal = Shell(GCmdStr, vbNormalFocus)
    End If
    
    'Close the form
    Unload Me
    End
End Sub

Private Sub Form_Unload(Cancel As Integer)
    On Error Resume Next

    'Close Word application
    wdApp.Quit
    Set wdApp = Nothing

End Sub

Private Sub MsgText_DblClick()
    GLastLogDate = "About to start new instance ..."
    Response = MsgBox(GLastLogDate, vbInformation, "MEDICOM FAX Manager")
End Sub

Private Sub RequestTimer_Timer()
    On Error GoTo err

    ' Initialize
    ProgressBar.BackColor = &HFFFFFF ' Idle
    If RequestTimer.Interval <> 30000 Then
        RequestTimer.Interval = 30000
    End If
    
    ' Restart WORD application every half-an-hour.
    GMinutesElapsed = GMinutesElapsed + 0.5
    If GMinutesElapsed > 30 Then                'Reopen WORD application every 30 minutes.
        GMinutesElapsed = 0
        Call ReOpenWordApplication
    End If
    
    ' Check if program running - backend.
    If Not CheckProgramRunning Then
        Response = MsgBox("MEDICOM Fax Manager is about to abort ...", vbDefaultButton1, "MEDICOM FAX Manager")
        GRestartYN = False
        Call Terminate
        Exit Sub
    End If

    Call Process
    Exit Sub
err:
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable progressbar timer
    RequestTimer.Enabled = True
    WriteLog ("Error at RequestTimer_Timer() : " & err.Description)
End Sub
Private Sub Process()
    On Error GoTo err
    
    Dim LVFSO As FileSystemObject
    
    ' Search for new requests in sm_report_fax_mail_request.
    If Not AnyNewRequest Then
        GoTo Exit_sub
    End If
    
    ' Disable process timer.
    RequestTimer.Enabled = False
    
    ' Change progressbar attribute.
    ProgressBar.BackColor = &HC000& ' Processing
    
    MsgText = "Last request processed at " & CurrTime
    Me.Refresh
    
    ' Open a connection to MEDICOM database.
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
    Connect:=GMEDICOMDBConnectString)

    GSQLText = "SELECT * FROM sm_report_fax_mail_request "
    GSQLText = GSQLText & "WHERE submitted_yn IS NULL "
    GSQLText = GSQLText & "AND routing_mode = 'F'"
    Set GRequestTable = GLocalDB.OpenRecordset(GSQLText, dbOpenDynaset)

    With GRequestTable
        GRequestTable.MoveFirst
        
        Do Until GRequestTable.EOF
            
            ' Store table data.
            GFacilityID = GRequestTable!operating_facility_id
            GModuleID = GRequestTable!module_id
            GReportID = GRequestTable!report_id
            GLocationType = GRequestTable!dest_locn_type
            GLocationCode = GRequestTable!dest_locn_code
            GRoutingMode = GRequestTable!routing_mode
            GReportPriority = IIf(IsNull(GRequestTable!report_priority), "N", GRequestTable!report_priority)
            GReportFileName = GRequestTable!report_file_name
            GUserID = GRequestTable!user_id
            GRequestDate = GRequestTable!request_date
            
            GTmpStr = "Facility=[" & GFacilityID & "] "
            GTmpStr = GTmpStr & " Module=[" & GModuleID & "] "
            GTmpStr = GTmpStr & " User=[" & GUserID & "] "
            GTmpStr = GTmpStr & " Report=[" & GReportID & "] "
            GTmpStr = GTmpStr & " LocnType=[" & GLocationType & "] "
            GTmpStr = GTmpStr & " LocnCode=[" & GLocationCode & "] "
            GTmpStr = GTmpStr & " Requested On=[" & GRequestDate & "] "
            GTmpStr = GTmpStr & " File=[" & GReportFileName & "] "
            GTmpStr = GTmpStr & " Priority=[" & GReportPriority & "] "
            WriteLog (GTmpStr)
            GFromUserName = "A"
            'Jan 24,06
            If GFromUserName = "" Then
                ' From details (user name , tel, fax) are null, call get_contact_details
                WriteLog ("Fetching sender's details ...")
                GSQLText = "{call appfaxmail.get_contact_details(?,?,?)}"
                Set rQry = cn.CreateQuery("", GSQLText)
                rQry.Execute
                GFromUserName = rQry(0)
                GFromPhoneNumber = rQry(1)
                GFromFaxNumber = rQry(2)
            End If
            GTmpStr = "From User Name=[" & GFromUserName & "] "
            GTmpStr = GTmpStr & " From Phone Number=[" & GFromPhoneNumber & "] "
            GTmpStr = GTmpStr & " From Fax Number=[" & GFromFaxNumber & "] "
            WriteLog (GTmpStr)
                
            If GLocationType = "@" And GLocationCode = "@" Then
                GManualFaxYN = True
                GFaxNumber = IIf(IsNull(GRequestTable!fax_mail_address), "", GRequestTable!fax_mail_address)
                GAltFaxNumber = IIf(IsNull(GRequestTable!fax_mail_cc_address), "", GRequestTable!fax_mail_cc_address)
                GRecipientName = IIf(IsNull(GRequestTable!to_reciepient_name), "", GRequestTable!to_reciepient_name)
                GCompanyName = IIf(IsNull(GRequestTable!to_company_name), "", GRequestTable!to_company_name)
                GPhoneNumber = IIf(IsNull(GRequestTable!to_phone_number), "", GRequestTable!to_phone_number)
                GFromUserName = IIf(IsNull(GRequestTable!from_user_name), "", GRequestTable!from_user_name)
                GFromFaxNumber = IIf(IsNull(GRequestTable!from_fax_number), "", GRequestTable!from_fax_number)
                GFromPhoneNumber = IIf(IsNull(GRequestTable!from_phone_number), "", GRequestTable!from_phone_number)
                
                GTmpStr = "Fax Number=[" & GFaxNumber & "] "
                GTmpStr = GTmpStr & " Alt Fax Number=[" & GAltFaxNumber & "] "
                GTmpStr = GTmpStr & " To Reciepient Name=[" & GRecipientName & "] "
                GTmpStr = GTmpStr & " To Company Name=[" & GCompanyName & "] "
                GTmpStr = GTmpStr & " To Phone Number=[" & GPhoneNumber & "] "
                WriteLog (GTmpStr)
                
            Else
                GManualFaxYN = False
            End If
            
            Do
                ' Check for file existence
                If Not CheckFileExists(GReportFileName) Then
                    ' Report file not found.
                    WriteLog (GReportFileName & " not exists !!")
                    GRequestTable.Edit
                    GRequestTable!submitted_yn = "N"
                    GRequestTable.Update
                    Exit Do
                End If
                
                If Not GManualFaxYN Then
                
                    ' Check if Fax ID is passed.
                    GFaxID = IIf(IsNull(GRequestTable!fax_mail_id), "", GRequestTable!fax_mail_id)
                    If GFaxID = "" Then
                        ' Get fax routing information
                        Call GetFaxRouting
                        If Not GRoutingFound Then
                            ' Routing not found.
                            ' Update sm_report_fax_mail_request
                            GRequestTable.Edit
                            GRequestTable!submitted_yn = "N"
                            GRequestTable.Update
                            Exit Do
                        End If
                    End If
                    
                    ' Get fax details
                    Call GetFaxDetails
                    If Not GSuccessYN Then
                        ' Fax details not found.
                        GRequestTable.Edit
                        GRequestTable!submitted_yn = "N"
                        GRequestTable.Update
                        Exit Do
                    End If
                
                    ' Get fax service details
                    Call GetFaxServiceDetails
                    If Not GSuccessYN Then
                        ' Fax service details not found.
                        GRequestTable.Edit
                        GRequestTable!submitted_yn = "N"
                        GRequestTable.Update
                        Exit Do
                    End If
                
                    ' Get printer queue name
                    Call GetPrinterQueueName
                    If Not GSuccessYN Then
                        ' Printer details not found.
                        ' It might be successfully printed next time.
                        ' So, do not change status (submitted_yn).
                        Exit Do
                    End If
                
                    ' Get FROM user name / fax number / phone number
                    Call GetUserDetails
                    If Not GSuccessYN Then
                        'From user name / fax number / phone number are optional.
                        'Do nothing.
                    End If
                
                End If ' If Not GManualFaxYN Then
                
                ' Create document (.DOC) and Print to FAX Port.
                Call PrintFaxControlDocument
                If Not GSuccessYN Then
                    Exit Do
                End If
                
                ' Get DB current date time.
                GSQLText = "{call get_current_timestamp(?)}"
                Set rQry = cn.CreateQuery("", GSQLText)
                rQry.Execute
                GDBCurrentDateTime = rQry(0)
                
                ' Request is successfully submitted.
                ' Update sm_report_fax_mail_request
                GRequestTable.Edit
                GRequestTable!fax_service_id = GFaxServiceID
                GRequestTable!printer_queue_name = GPrinterQueueName
                GRequestTable!submitted_yn = "Y"
                GRequestTable!submitted_date = GDBCurrentDateTime
                GRequestTable.Update
                WriteLog ("Process Success. Submitted At " & GDBCurrentDateTime)
            
                Exit Do
                
            Loop Until True
            
            GRequestTable.MoveNext
            
        Loop
    End With
    GRequestTable.Close
    GoTo Terminate_Process
err:
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at Process() " & GTmpStr)
    Call SpoolLog(False, False)
Terminate_Process:
    ' Minimize word application
    wdApp.Visible = False
    
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable process timer.
    RequestTimer.Enabled = True
    
    ' Close database connection
    en.Close
    cn.Close
Exit_sub:
    ' Reset progressbar attribute
    ProgressBar.BackColor = &HFFFFFF ' Idle
    
    ' Enable process timer.
    RequestTimer.Enabled = True
    Exit Sub
End Sub
Private Function AnyNewRequest()
    Dim NewRequestCountSQLText As String
    
    On Error GoTo err
    
    WriteLog "Searching for new requests ... "
    
    NewRequestCountSQLText = "SELECT COUNT(*) FROM sm_report_fax_mail_request WHERE submitted_yn IS NULL AND routing_mode = 'F'"
   
    Set GCountSet = GLocalDB.OpenRecordset(NewRequestCountSQLText)
    GRecordCtr = GCountSet(0)
    If GRecordCtr > 0 Then
        AnyNewRequest = True
    Else
        AnyNewRequest = False
    End If
    
    Exit Function
err:
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at AnyNewRequest() : " & GTmpStr)
    Call SpoolLog(False, False)
End Function
Private Sub ODBCTesting()
    On Error GoTo err
    
    err.Clear
    
    WriteLog ("Validating ODBC ...")
    
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
        Connect:=GMEDICOMDBConnectString)
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "workstation.get_workstation_id"  ' p_proc_name
    rQry(1) = ""                                ' p_in_1
    rQry(2) = ""                                ' p_in_2
    rQry(3) = ""                                ' p_in_3
    rQry(4) = ""                                ' p_in_4
    rQry(5) = ""                                ' p_in_5
    rQry(6) = ""                                ' p_in_6
    rQry(7) = ""                                ' p_in_7
    rQry(8) = ""                                ' p_in_8
    rQry(9) = ""                                ' p_in_9
    rQry(10) = ""                               ' p_in_10
    rQry.Execute
   
    GWorkstatinID = rQry(11)
    WriteLog ("Workstation ID=[" & GWorkstatinID & "]")
        
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at ODBCTesting() Error : " & GTmpStr)
    Response = MsgBox("Error at ODBCTesting() : " & GTmpStr, vbCritical, "MEDICOM FAX Manager")
Exit_sub:
    en.Close
    cn.Close
End Sub
Private Function CheckProgramRunning()
    On Error GoTo err
    
    Dim LRunningStatus As String
    
    err.Clear
    
    WriteLog ("Checking program status ...")
    
    Set en = rdoEnvironments(0)
    Set cn = en.OpenConnection(dsName:=GDSName, Prompt:=rdDriverNoPrompt, _
        Connect:=GMEDICOMDBConnectString)
    
    GSQLText = "{call check_program_running(?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = GFacilityIDArg        ' p_facility_id
    rQry(1) = ""                    ' p_machine_name
    rQry(2) = "SMTFMSRV"            ' p_pgm_id
    'rQry(3) = ""                   ' p_running_status ('TRUE' or 'FALSE')
    rQry.Execute
   
    LRunningStatus = rQry(3)
    
        
    If UCase(LRunningStatus) = "TRUE" Then
        CheckProgramRunning = True
    Else
        CheckProgramRunning = False
        WriteLog ("Status= [" & LRunningStatus & "]")
    End If
    
    If GTestingYN = True Then
        CheckProgramRunning = True
    End If
    
    GoTo Exit_Function
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at CheckProgramRunning () : " & GTmpStr)
    Response = MsgBox("Error at CheckProgramRunning () : " & GTmpStr, vbCritical, "MEDICOM FAX Manager")
    Call SpoolLog(False, False)
Exit_Function:
    en.Close
    cn.Close
End Function
Sub GetFaxRouting()
    On Error GoTo err
    
    err.Clear
    GRoutingFound = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_faxmail_routing_property"  ' p_proc_name
    rQry(1) = GFacilityID                                ' Arguments
    rQry(2) = GModuleID
    rQry(3) = GReportID
    rQry(4) = GLocationType
    rQry(5) = GLocationCode
    rQry(6) = GRoutingMode
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute
    
    If IsNull(rQry(11)) Then
        GFaxID = ""
    Else
        GFaxID = rQry(11)
    End If

    If IsNull(rQry(12)) Then
        GErrorText = ""
    Else
        GErrorText = LTrim(RTrim(rQry(12)))
    End If
    
    If Len(GFaxID) > 0 And Len(GErrorText) = 0 Then
        GRoutingFound = True
        WriteLog ("GetFaxRotuing() Fax ID=[" & GFaxID & "]")
    End If
    
    GoTo Exit_sub
    
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er

    End If
    WriteLog ("Error at GetFaxRotuing() : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GRoutingFound Then
        WriteLog ("GetFaxRotuing() No routing found.")
    End If
    Exit Sub
End Sub
Sub GetFaxDetails()
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_fax_details"           ' p_proc_name
    rQry(1) = GFaxID                          ' Arguments
    rQry(2) = ""
    rQry(3) = ""
    rQry(4) = ""
    rQry(5) = ""
    rQry(6) = ""
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute

    If IsNull(rQry(11)) Then
        GRecipientName = ""
    Else
        GRecipientName = rQry(11)
    End If

    If IsNull(rQry(12)) Then
        GFaxNumber = ""
    Else
        GFaxNumber = rQry(12)
    End If

    If IsNull(rQry(13)) Then
        GAltFaxNumber = ""
    Else
        GAltFaxNumber = rQry(13)
    End If
    
    If IsNull(rQry(14)) Then
        GFaxServiceID = ""
    Else
        GFaxServiceID = rQry(14)
    End If
    
    If IsNull(rQry(16)) Then
        GCompanyName = ""
    Else
        GCompanyName = rQry(16)
    End If

    If IsNull(rQry(17)) Then
        GPhoneNumber = ""
    Else
        GPhoneNumber = rQry(17)
    End If

    If IsNull(rQry(18)) Then
        GErrorText = ""
    Else
        GErrorText = rQry(18)
    End If

    If Len(GFaxNumber) > 0 And Len(GErrorText) = 0 Then
        GSuccessYN = True
        WriteLog ("GetFaxDetails() Fax Number=[" & GFaxNumber & "]")
    End If
    
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at GetFaxDetails() : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("GetFaxDetails() " & GErrorText)
    End If
    Exit Sub
End Sub
Sub GetFaxServiceDetails()
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_fax_service_details"  ' p_proc_name
    rQry(1) = GFaxServiceID                         ' Arguments
    rQry(2) = ""
    rQry(3) = ""
    rQry(4) = ""
    rQry(5) = ""
    rQry(6) = ""
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute

    If IsNull(rQry(11)) Then
        GFaxServiceName = ""
    Else
        GFaxServiceName = rQry(11)
    End If

    If IsNull(rQry(15)) Then
        GPrinterID = ""
    Else
        GPrinterID = rQry(15)
    End If

    If IsNull(rQry(22)) Then
        GErrorText = ""
    Else
        GErrorText = rQry(22)
    End If
    
    If Len(GPrinterID) > 0 And Len(GErrorText) = 0 Then
        GSuccessYN = True
        WriteLog ("GetFaxServiceDetails() Printer ID=[" & GPrinterID & "]")
    End If
    
    GoTo Exit_sub
    
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at GetFaxServiceDetails() : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("GetFaxServiceDetails() No fax service details found.")
    End If
    Exit Sub
End Sub
Sub GetPrinterQueueName()
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appprint.get_queue_name"             ' p_proc_name
    rQry(1) = GPrinterID                         ' Arguments
    rQry(2) = ""
    rQry(3) = ""
    rQry(4) = ""
    rQry(5) = ""
    rQry(6) = ""
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute

    If IsNull(rQry(13)) Then
        GPrinterQueueName = ""
    Else
        GPrinterQueueName = rQry(13)
    End If

    If Len(GPrinterQueueName) > 0 Then
        GSuccessYN = True
        WriteLog ("GetPrinterQueueName() PrinterQueue=[" & GPrinterQueueName & "]")
    End If
    
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at GetPrinterQueueName() Error : " & GTmpStr)
    Call SpoolLog(False, False)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("GetPrinterQueueName() Printer queue name not found.")
    End If
    Exit Sub
End Sub
Sub GetUserDetails()
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    GSQLText = "{call wrapprc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"
    Set rQry = cn.CreateQuery("", GSQLText)
    
    rQry(0) = "appfaxmail.get_user_details"      ' p_proc_name
    rQry(1) = GFacilityID                         ' Arguments
    rQry(2) = GUserID
    rQry(3) = ""
    rQry(4) = ""
    rQry(5) = ""
    rQry(6) = ""
    rQry(7) = ""
    rQry(8) = ""
    rQry(9) = ""
    rQry(10) = ""
    rQry.Execute

    If IsNull(rQry(12)) Then
        GFromUserName = ""
    Else
        GFromUserName = rQry(12)
    End If

    If IsNull(rQry(13)) Then
        GFromPhoneNumber = ""
    Else
        GFromPhoneNumber = rQry(13)
    End If

    If IsNull(rQry(14)) Then
        GFromFaxNumber = ""
    Else
        GFromFaxNumber = rQry(14)
    End If

    If Len(GFromUserName) > 0 Then
        GSuccessYN = True
        WriteLog ("Error at GetUserDetails() UserName=[" & GFromUserName & "]")
    End If
    
    GoTo Exit_sub
err:
    GSuccessYN = False
    GTmpStr = ""
    If err Then
        GTmpStr = err.Description
    Else
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If
    WriteLog ("Error at GetUserDetails() : " & GTmpStr)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("GetUserDetails() User details not defined.")
    End If
    Exit Sub
End Sub
Sub PrintFaxControlDocument()
    Dim LVErr As Integer
    
    On Error GoTo err
    
    err.Clear
    GSuccessYN = False
    
    ' Create a document
    WriteLog ("PrintFaxControlDocument() : Opening fax control document " & GControlDocument & " ...")
    wdApp.Documents.Open GControlDocument
    WriteLog ("PrintFaxControlDocument() : Preparing the document ...")
    wdApp.Selection.WholeStory
    wdApp.Selection.TypeText Text:="<TOFAXNUM:" & GFaxNumber & ">"
    wdApp.Selection.TypeParagraph
    If Len(GAltFaxNumber) > 0 Then
        WriteLog ("PrintFaxControlDocument() Alt Fax Number=[" & GAltFaxNumber & "]")
        wdApp.Selection.TypeText Text:="<TOALTFAXNUM:" & GAltFaxNumber & ">"
        wdApp.Selection.TypeParagraph
    End If
    wdApp.Selection.TypeText Text:="<TONAME:" & GRecipientName & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<TOCOMPANY:" & GCompanyName & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<TOCONTACTNUM:" & GPhoneNumber & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<FROMNAME:" & GFromUserName & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<FROMFAXNUM:" & GFromFaxNumber & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<FROMPHONE:" & GFromPhoneNumber & ">"
    wdApp.Selection.TypeParagraph
    wdApp.Selection.TypeText Text:="<ADDDOC:" & GReportFileName & ">"
    wdApp.Selection.TypeParagraph
    
    ' May 30, 05 Sundar: Priority Faxing
    
    If GReportPriority = "H" Then
        wdApp.Selection.TypeText Text:="<PRIORITY:HIGH>"
        wdApp.Selection.TypeParagraph
    End If
    
    wdApp.Selection.WholeStory
    wdApp.Selection.Font.Name = "Courier"
    wdApp.Selection.Font.Size = 12
    wdApp.Documents.Save
    
    ' Print to the default printer.
    WriteLog ("PrintFaxControlDocument() : Faxing the document ...")
    'ActiveDocument.PrintOut
    wdApp.ActiveDocument.PrintOut
    wdApp.Documents.Close
        
    GSuccessYN = True
    WriteLog ("PrintFaxControlDocument() : Document faxed.")
    GoTo Exit_sub
err:
    ' Restart the program if error is 462 - Remote server is unavailable.
    If err.Number = 462 Then
        WriteLog ("PrintFaxControlDocument() : Error opening word application.")
        GRestartYN = True
        Call Terminate
        Exit Sub
    End If

    GSuccessYN = False
    GTmpStr = ""
    If err Then
        LVErr = err.Number
        GTmpStr = err.Description
    Else
        LVErr = er.Number
        For Each er In rdoErrors
           GTmpStr = GTmpStr & er.Description & ":" & er.Number & vbCr & Chr(10)
        Next er
    End If

    Call SpoolLog(False, False)
Exit_sub:
    If Not GSuccessYN Then
        WriteLog ("PrintFaxControlDocument() : Document not faxed. " & err.Description)
    End If
    Exit Sub
End Sub
Private Sub WriteLog(PMsg As String)

    Dim CurrentDate As String
    Dim CurrentTime As String
    Dim LCountSet As Recordset
    
    On Error GoTo err
    
    '
    ' Purge logs daily morning 12:00.
    ' Change following line. Restart testing hourly.
    '
    CurrentDate = Format(Now, "mmm-dd-yy")
    If GLastLogDate <> CurrentDate Then
        If PMsg <> "Program Start." Then
            Call SpoolLog(True, False)
        End If
        
        GSQLText = "DELETE FROM Log;"
        GLocalDB.Execute GSQLText
        GLogRecordCtr = 0
        
        '
        ' Restart the program unless the program is started just now.
        '
        If PMsg <> "Program Start." Then
            If GRestartYN = True Then
                Call Terminate
                Exit Sub
            End If
        End If
    End If
    
    If LTrim(RTrim(PMsg)) <> "" Then
        '
        ' Get maximum seq no.
        '
        On Error Resume Next
        GSQLText = "SELECT MAX(SEQNO) AS GLogRecordCtr FROM Log"
        Set LCountSet = GLocalDB.OpenRecordset(GSQLText)
        If err Then
            GLogRecordCtr = 0
        Else
            GLogRecordCtr = CInt(LCountSet("GLogRecordCtr"))
        End If
        On Error GoTo err
        
        '
        ' Write into log table.
        '
        CurrentTime = Format(Now, "mmm dd, yyyy hh:mm:ss AMPM")
        GLogTable.AddNew
        GLogTable("SeqNo") = GLogRecordCtr + 1
        GLogTable("TimeStamp") = CurrentTime
        GLogTable("Message") = Left(PMsg, 200)
        GLogTable.Update
    End If
    
    GLastLogDate = CurrentDate
    
Exit_WriteLog:
    Exit Sub
err:
    Response = MsgBox("WriteLog() : " & err.Description, vbCritical, "MEDICOM FAX Manager")
    Resume Exit_WriteLog
End Sub
Private Sub SpoolLog(UniqueTimeYN As Boolean, ViewYN As Boolean)
    
    On Error GoTo err
    
    '
    ' Close log table.
    '
    GLogTable.Close
    
    '
    ' Build log name: SMTFMSRV-<DD-MON-YY-HH24-MI-SS>.Log>
    '
    If UniqueTimeYN = True Then
        GLogFileName = "C:\MEDICOM\SMTFMSRV\SMTFMSRV-" & Format(Now, "dd-Mmm-yy-hh-mm-ss-AMPM") & ".Log"
    Else
        GLogFileName = "C:\MEDICOM\SMTFMSRV\SMTFMSRV-" & Format(Now, "dd-Mmm-yy") & ".Log"
    End If
    
    '
    ' Open log file
    '
    Close #1
    Open GLogFileName For Output As 1
    Print #1,
    Print #1, "MEDICOM Solutions Middle East llc"
    Print #1,
    Print #1, Format(Now, "mmm dd, yyyy hh:mm:ss AMPM")
    Print #1,
    Print #1, "                                MEDICOM FAX Manager"
    Print #1,
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1, "Time"; Tab(27); "Message"
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1,
    
    '
    ' Read log table and spool to file.
    '
    Set GLogTable = GLocalDB.OpenRecordset("Log", dbOpenDynaset)
    GLogTable.MoveFirst
    With GLogTable
        .Sort = "SeqNo"
        Do While Not .EOF
            Print #1, Format(GLogTable!TimeStamp, "mmm dd, yyyy hh:mm:ss AMPM"); Tab(27); GLogTable!Message
            GLogTable.MoveNext
        Loop
    End With
    
    Print #1,
    Print #1, "----------------------------------------------------------------------------------------------------------------------------------------"
    Print #1,
    Print #1, "End of log."
    Close #1
    
    If ViewYN Then
        GRetVal = Shell("C:\PROGRAM FILES\WINDOWS NT\ACCESSORIES\WORDPAD.EXE " & GLogFileName, vbMaximizedFocus)
    End If
    
Exit_SpoolLog:
    Exit Sub
err:
    Exit Sub
End Sub
Private Sub FaxTesting()
    On Error GoTo err
    
    GReportFileName = "\\HL7Test\SMTFMSRV\RightsFax.doc"
    If Not CheckFileExists(GReportFileName) Then
        Exit Sub
    End If
    GPrinterQueueName = "\\hl7test\hpfax"
    
    Set LVFSO = New FileSystemObject
    LVFSO.CopyFile GReportFileName, GPrinterQueueName
    Exit Sub
err:
    Response = MsgBox("FaxTesting() : " & err.Description, vbCritical, "MEDICOM FAX Manager")
End Sub
