VERSION 5.00
Begin VB.Form MEDPrint 
   BorderStyle     =   1  'Fixed Single
   Caption         =   "IBA Print Manager (Version 5.10)"
   ClientHeight    =   2565
   ClientLeft      =   45
   ClientTop       =   330
   ClientWidth     =   6615
   Icon            =   "MEDPrint.frx":0000
   LinkTopic       =   "Form1"
   MaxButton       =   0   'False
   MinButton       =   0   'False
   ScaleHeight     =   2565
   ScaleWidth      =   6615
   StartUpPosition =   3  'Windows Default
   Begin VB.TextBox FPrinterPort 
      BackColor       =   &H8000000F&
      BorderStyle     =   0  'None
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   210
      Left            =   3120
      TabIndex        =   4
      Text            =   "FPrinterPort"
      Top             =   4680
      Width           =   3135
   End
   Begin VB.TextBox FDriverName 
      BackColor       =   &H8000000F&
      BorderStyle     =   0  'None
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   210
      Left            =   3120
      TabIndex        =   2
      Text            =   "FDriverName"
      Top             =   3915
      Width           =   3015
   End
   Begin VB.ListBox PrintersList 
      BeginProperty Font 
         Name            =   "Verdana"
         Size            =   9
         Charset         =   0
         Weight          =   400
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   2370
      Left            =   120
      TabIndex        =   0
      Top             =   3720
      Width           =   2895
   End
   Begin VB.Frame Frame1 
      Height          =   2295
      Left            =   120
      TabIndex        =   6
      Top             =   0
      Width           =   6375
      Begin VB.Timer Close_Timer 
         Left            =   5040
         Top             =   240
      End
      Begin VB.CommandButton Close_but 
         Caption         =   "Close"
         Height          =   375
         Left            =   5160
         TabIndex        =   18
         Top             =   1800
         Width           =   975
      End
      Begin VB.TextBox FFileStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   1560
         TabIndex        =   16
         Text            =   "FFileStatus"
         Top             =   600
         Width           =   2220
      End
      Begin VB.TextBox FFileName 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   840
         TabIndex        =   12
         Text            =   "FFileName"
         Top             =   360
         Width           =   4620
      End
      Begin VB.TextBox FPrinterName 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   210
         Left            =   840
         TabIndex        =   11
         Text            =   "FPrinterName"
         Top             =   960
         Width           =   4500
      End
      Begin VB.TextBox FStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   9
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H000000C0&
         Height          =   495
         Left            =   120
         MultiLine       =   -1  'True
         TabIndex        =   10
         Top             =   1680
         Width           =   4965
      End
      Begin VB.TextBox FPrinterStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   200
         Left            =   840
         TabIndex        =   9
         Text            =   "FPrinterStatus"
         Top             =   1440
         Width           =   2500
      End
      Begin VB.TextBox FJobStatus 
         BackColor       =   &H8000000F&
         BorderStyle     =   0  'None
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   8.25
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00FF0000&
         Height          =   200
         Left            =   3600
         TabIndex        =   8
         Text            =   "FJobStatus"
         Top             =   1440
         Width           =   2500
      End
      Begin VB.Image Image1 
         Height          =   480
         Left            =   5640
         Top             =   240
         Width           =   480
      End
      Begin VB.Label Label4 
         Caption         =   "Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   200
         Left            =   840
         TabIndex        =   17
         Top             =   600
         Width           =   660
      End
      Begin VB.Label Label2 
         Caption         =   "Printer"
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   9
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   195
         Left            =   120
         TabIndex        =   15
         Top             =   960
         Width           =   780
      End
      Begin VB.Label Label7 
         Caption         =   "Printer Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   195
         Left            =   840
         TabIndex        =   14
         Top             =   1200
         Width           =   1860
      End
      Begin VB.Label Label8 
         Caption         =   "Job Status:"
         BeginProperty Font 
            Name            =   "Arial"
            Size            =   8.25
            Charset         =   0
            Weight          =   700
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         ForeColor       =   &H00800000&
         Height          =   195
         Left            =   3600
         TabIndex        =   13
         Top             =   1200
         Width           =   1020
      End
      Begin VB.Label Label1 
         Caption         =   "File"
         BeginProperty Font 
            Name            =   "Verdana"
            Size            =   9
            Charset         =   0
            Weight          =   400
            Underline       =   0   'False
            Italic          =   0   'False
            Strikethrough   =   0   'False
         EndProperty
         Height          =   195
         Left            =   120
         TabIndex        =   7
         Top             =   360
         Width           =   1500
      End
   End
   Begin VB.Label Label6 
      Caption         =   "Printer Port"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   195
      Left            =   3120
      TabIndex        =   5
      Top             =   4440
      Width           =   1500
   End
   Begin VB.Label Label5 
      Caption         =   "Driver Name"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   195
      Left            =   3120
      TabIndex        =   3
      Top             =   3675
      Width           =   1500
   End
   Begin VB.Label Label3 
      Caption         =   "List of printers"
      BeginProperty Font 
         Name            =   "Arial"
         Size            =   9
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      ForeColor       =   &H00800000&
      Height          =   255
      Left            =   120
      TabIndex        =   1
      Top             =   3480
      Width           =   2175
   End
End
Attribute VB_Name = "MEDPrint"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
Private Sub Close_but_Click()
    Unload Me
End Sub
Private Sub Close_Timer_Timer()
    Unload Me
End Sub
Private Sub Form_Load()
     
    '
    ' Declare variables
    '
    Dim LVOutFSO As FileSystemObject
    Dim LVErrFSO As FileSystemObject
    Dim LVErrFile As File
    Dim LVCmdSyntax As String
    Dim LVCtr As Integer
    Dim LVErrFileName As String
    Dim LVPrinterName As String
    Dim LVServerName As String
    Dim LVTmpStr As String
    Dim LVPos As Integer
    Dim LVDefaultPrinterName As String
    Dim LVDefaultDriverName As String
    Dim LVDefaultPrinterPort As String
    
    On Error Resume Next
    
    '
    ' Initialize.
    '
    FStatus = "Initializing ..."
    
    FFileName = ""
    FPrinterName = ""
    FDriverName = ""
    FPrinterPort = ""
    FPrinterStatus = ""
    FJobStatus = ""
    FStatus = ""
    FFileStatus = ""
    Close_Timer.Enabled = False
    Close_but.Visible = False
    Me.Left = 2500
    Me.Top = 2500
    Me.Height = 2850    '6735
    
    GVServerName = ""
    GVShareName = ""
    GVFunctionName = ""
    GVWorkingDir = ""
    GVCopies = ""
    GVReportType = ""
    GRetValStr = ""
    GVCmdLine = ""
    
    If GTestingYN Then
        '
        ' Set the values for testing.
        '
        Call Testing
    Else

        '
        ' Get command line arguments
        ' Argument 1 - Application Name
        ' Argument 2 - Function Name
        ' Argument 3 - Report File name
        ' Argument 4 - Printer name
        ' Argument 5 - Copies
        ' Argument 6 - Report Type (LOCAL  STANDARD)
        GetCommandLine
        'MsgBox "Command Line = " & GVCmdLine
        
        '
        ' Usage Statement
        '
        LVCmdSyntax = "Invalid Arguments!!!" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "Usage:" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "========" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "MEDPrint.EXE;Function Name;Report File Name;Printer Name;Num of Copies;Report Type" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "    Where Report Type=LOCAL for local language reports or STANDARD"
        LVCmdSyntax = LVCmdSyntax & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "Example:" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "========" & vbCrlf
        LVCmdSyntax = LVCmdSyntax & "MEDPrint.EXE;MPRIDLBL;C:\Medicom\Reports;MPRIDLBL.LIS;\\MEDNET2\Cardialogy Lexmark;2;LOCAL" & vbCrlf & vbCrlf
        LVCmdSyntax = LVCmdSyntax & GVCmdLine
            
        '
        ' Get report method
        ' B = Batch Method
        ' O = Online Method (Default)
        '
        If Len(GVReportMethod) = 0 Then
            GVReportMethod = GArgArray(8)
            If Len(GVReportMethod) = 0 Then
                GVReportMethod = "O"
            End If
        End If
        
        If GVReportMethod = "B" Then
            Me.Visible = False
        End If
            
        '
        ' Get function name
        '
        If Len(GVFunctionName) = 0 Then
            GVFunctionName = GArgArray(2)
            If Len(GVFunctionName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "MEDICOM Print Manager - FunctionName Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get reporrs dir path
        '
        If Len(GVWorkingDir) = 0 Then
            GVWorkingDir = GArgArray(3)
            If Len(GVWorkingDir) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "MEDICOM Print Manager - ReportsDir Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        
        '
        ' Get report file name
        '
        If Len(FFileName) = 0 Then
            FFileName = GArgArray(4)
            If Len(FFileName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "MEDICOM Print Manager - FileName Missing"
                FStatus = "Invalid Command!!"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get printer name
        '
        If Len(FPrinterName) = 0 Then
            FPrinterName = GArgArray(5)
            If Len(FPrinterName) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "MEDICOM Print Manager - PrintName Missing"
                GoTo Log_Error
            End If
        End If
        
        '
        ' Get number of copies
        '
        If GVCopies = 0 Then
            GVCopies = GArgArray(6)
            If GVCopies = 0 Then
                GVCopies = 1
            End If
        End If
        
        '
        ' Get report type
        ' LOCAL=Local language report (Arabic)
        ' STANDARD=Standard report (Not containing local language)
        '
        If Len(GVReportType) = 0 Then
            GVReportType = GArgArray(7)
            If Len(GVReportType) = 0 Then
                MsgBox LVCmdSyntax, vbCritical, "MEDICOM Print Manager - PrintName Missing"
                GoTo Log_Error
            End If
        End If
        
    End If
    
    '
    ' In Working Dir,
    '   remove the "\" at end, if exists.
    '
    If Right(GVWorkingDir, 1) = "\" Then
        GVWorkingDir = Mid(GVWorkingDir, 1, Len(GVWorkingDir) - 1)
    End If
    
    '
    ' Remove error log file (FunctionName.Err) if exists.
    '
    Err.Clear
    LVErrFileName = GVWorkingDir & "\" & GVFunctionName & ".Err"
    Set LVErrFSO = New FileSystemObject
    Set LVErrFile = LVErrFSO.GetFile(LVErrFileName)
    LVErrFile.Delete
    
    '
    ' Open File
    '
    Err.Clear
    FStatus = "Opening file ..."
    FFileStatus = "OK"
    Close #1
    If InStr(FFileName, "\") = 0 Then ' If FileName is NOT with PATH.
        FFileName = GVWorkingDir & "\" & FFileName
    End If
    Open FFileName For Input As #1
    If Err Then
        FFileStatus = Err.Description
        FStatus = "Cannot open " & FFileName & ". " & FFileStatus
        GoTo Log_Error
    End If
    
    '
    ' Capture the default printer's attributes for later usage.
    '
    LVDefaultPrinterName = Printer.DeviceName
    LVDefaultDriverName = Printer.DriverName
    LVDefaultPrinterPort = Printer.Port
    
    '
    ' Validate Printer.
    '
    Err.Clear
    FStatus = "Validating printer ..."
    FStatus = ValidatePrinter
    If FStatus <> "Success" Then
        GoTo Log_Error
    End If
        
    '
    ' Set this printer default
    '
    SetDefaultPrinter FPrinterName, FDriverName, FPrinterPort
    
    '
    ' Manipulate printername if port name like "LPT%"
    '
    If InStr(1, FPrinterName, "\\") = 0 Then        '
        ' Get the computer (server) name and
        ' concatenate with printer share name.
        '
        LVPrinterName = FPrinterPort
        'Following lines has been comented by
        'Nanjayan on 14-04-2003
        'Since the local printer is not taking the
        '\\server name\share name

        'LVTmpStr = Mid(FPrinterName, 3)
        'LVPos = InStr(1, LVTmpStr, "\")
        'LVServerName = Left(LVTmpStr, LVPos - 1)
        'LVPrinterName = "\\" & LVServerName & "\" & GVShareName
    Else
        LVPrinterName = GVServerName & "\" & GVShareName
    End If
    'MsgBox LVPrinterName
    
    '
    ' Do printing.
    '
    FStatus = "Opening printer ... " & GVCopies
    Err.Clear
    For LVCtr = 1 To GVCopies
        FStatus = "Printing Copy(" & LVCtr & ") ..."
        'MsgBox FFileName & " " & LVPrinterName
        
        If UCase(GVReportType) = "LOCAL" Then
            '
            ' Local language report.
            ' Call PrintDocument function to read line by line and print
            '
            LVTmpStr = PrintDocument
        Else
            '
            ' Standard report (not containing any local language characters)
            ' Print directly to printer.
            '
            Set LVOutFSO = New FileSystemObject
            LVTmpStr = "Success"
            LVOutFSO.CopyFile FFileName, LVPrinterName
            If Err Then
                LVTmpStr = Err.Description
            End If
        End If
        
        If LVTmpStr <> "Success" Then
            FStatus = "Printing Failed!! - " & LVTmpStr
            GoTo Log_Error
        Else
            FStatus = "Printing Successful."
        End If
        
        '
        ' Re-open the file
        '
        LVOperation = "ReopenFile"
        Close #1
        Open FFileName For Input As #1

    Next LVCtr

    '
    ' Re-open the file
    '
    LVOperation = "CloseFile"
    Close #1
    
    '
    ' Reset the default printer.
    '
    SetDefaultPrinter LVDefaultPrinterName, LVDefaultDriverName, LVDefaultPrinterPort
    
    If GVReportMethod <> "B" Then
        '
        ' Enable "Close" timer.
        ' For 1 second, set the interval to 1000.
        ' Set the interval for 2 seconds.
        '
        Close_Timer.Enabled = True
        Close_Timer.Interval = 2000
    Else
        Close_Timer.Enabled = True
        Close_Timer.Interval = 1        ' To close the form immediately.
    End If
    
    '
    ' Exit Sub
    '
    Exit Sub
    
Log_Error:
    '
    ' Reset the default printer.
    '
    SetDefaultPrinter LVDefaultPrinterName, LVDefaultDriverName, LVDefaultPrinterPort
    
    '
    ' Write error message into error log file.
    '
    Close #9
    Open LVErrFileName For Output As #9
    Print #9, FStatus
    Close #9
    If GVReportMethod <> "B" Then

        '
        ' Show close button.
        '
        Close_but.Visible = True
        Close_but.Enabled = True
        
        '
        ' Exit Sub
        '
        Exit Sub
    Else
        Close_Timer.Enabled = True
        Close_Timer.Interval = 1        ' To close the form immediately.
    End If
End Sub
Private Function PrintDocument() As String
    
    '
    ' Declare variables.
    '
    Dim LVCtr As Long
    Dim LVCurrPos As Integer
    Dim LVCurrChar As String
    Dim LVAscOfCurrChar As String
    Dim LVOperation As String
    Dim LVTextLine As String
    Dim LVFormattedTextLine As String
    Dim LVSkipPageYN As Boolean
    Dim LVIsAControlCharacter As Boolean
    Dim LVControlCharSeqStartPos As Integer
    
    
    On Error GoTo Err_PrintDocument
    
    '
    ' Initialize
    '
    LVOperation = "Initialize"
    PrintDocument = "Success"
    LVCtr = 0
    
    '
    ' Set printer properties.
    '
    LVOperation = "SetPrinter"
    Printer.Orientation = 2             ' Portrait
    Printer.Font = "Courier New"
    Printer.FontSize = 9.14
    
    '
    ' Do printing.
    ' Read line by line and print.
    '
    LVOperation = "DoPrint"
    Do While Not EOF(1)
        ' Initialize
        LVCtr = LVCtr + 1               ' Increment line counter.
        LVSkipPageYN = False
        
        ' Read the line
        Line Input #1, LVTextLine
        
        '
        ' Interpret the control characters.
        ' Chr(27) = Start character of control characters sequence.
        '
        If InStr(1, LVTextLine, Chr(27)) > 0 Then
        
            '
            ' Check the layout (portrait / landscape) of the report.
            ' and set the layout accordingly.
            ' This check is required only for the first line
            ' of the report.
            ' &l1O=Landscape (ampersand el one Oh)
            ' &l0O=Portrait  (ampersand el zero Oh)
            '
            
            If LVCtr = 1 Then
                If InStr(1, LVTextLine, "&l1O") > 0 Then
                    Printer.Orientation = 2 ' Landscape
                End If
                If Printer.Orientation = 1 Then     ' Extra 2 blank lines for portait reports
                    Printer.Print vbCrlf
                    Printer.Print vbCrlf
                End If
                '
                ' Check the alignment (Left to Right / Right to Left).
                ' and set the alignment accordingly.
                ' This check is done on first line of the report.
                ' #$%R=Right To Left (Ash Dollar Percentage R-capital)
                ' Else Left To Right
                '
 
                If InStr(1, LVTextLine, "#$%R") > 0 Then
                    Printer.RightToLeft = True
                Else
                    Printer.RightToLeft = False
                End If
            End If
        
            '
            ' Check for PAGESKIP (chr(12)) character.
            '
            If InStr(1, LVTextLine, Chr(12)) > 0 Then
                '
                ' We assume end of report is marked by string END OF REPORT.
                '
                ' If PAGESKIP is given at the end (END OF REPORT),
                '   Do not skip the page.
                ' Else
                '   Skip the page.
                '
                LVTmpStr = LVTextLine
                LVTmpStr = UCase(Replace(LVTmpStr, " ", "", 1))
                If InStr(1, LVTmpStr, "ENDOFREPORT") = 0 Then
                    LVSkipPageYN = True
                End If
            End If
        
            '
            ' Remove control characters.
            '
            LVFormattedTextLine = ""
            For Pos = 1 To Len(LVTextLine)
                LVCurrChar = Mid(LVTextLine, Pos, 1)
                LVAscOfCurrChar = Asc(LVCurrChar)
                
                If LVAscOfCurrChar = 27 Then
                    LVIsAControlCharacter = True
                    LVControlCharSeqStartPos = Pos
                End If
                
                If Not LVIsAControlCharacter Then
                    LVFormattedTextLine = LVFormattedTextLine & LVCurrChar
                End If
                
                'MsgBox CurrChar & "  - " & Asc(CurrChar) & Chr(10) & "t = " & t & Chr(10) & "LVControlCharSeqStartPos = " & LVControlCharSeqStartPos
                If LVControlCharSeqStartPos > 0 Then
                    If LVAscOfCurrChar > 64 And LVAscOfCurrChar < 91 Then
                        LVControlCharSeqStartPos = 0
                        LVIsAControlCharacter = False
                    End If
                End If
            Next Pos
            
           
        Else
            '
            ' There is no control character in the current line.
            ' Hence, just assign whatever is read, to formatted text line.
            '
            LVFormattedTextLine = LVTextLine
            
            '
            ' Check for PAGESKIP (chr(12)) character.
            '
            If InStr(1, LVTextLine, Chr(12)) > 0 Then
                '
                ' We assume end of report is marked by string END OF REPORT.
                '
                ' If PAGESKIP is given at the end (END OF REPORT),
                '
                '   do not skip the page.
                ' else
                '   skip the page.
                '
                LVTmpStr = LVFormattedTextLine
                LVTmpStr = UCase(Replace(LVTmpStr, " ", "", 1))
                If InStr(1, LVTmpStr, "ENDOFREPORT") = 0 Then
                    LVSkipPageYN = True
                End If
            End If
        End If
        
        '
        ' Remove PAGESKIP (Chr(12)) from the formatted line.
        ' Otherwise Chr(12) (a box) will get printed.
        '
        LVFormattedTextLine = Replace(LVFormattedTextLine, Chr(12), "", 1)
        
        '
        ' Print the formatted line to the printer.
        '
        ' For Portrait reports, insert 6 spaces for each line.
        If Printer.Orientation = 1 Then
            LVFormattedTextLine = "        " & LVFormattedTextLine
        End If
        Printer.Print LVFormattedTextLine
        'MsgBox LVFormattedTextLine
        
        '
        ' Skip page.
        '
        If LVSkipPageYN And LVCtr <= 1 Then
            Printer.Print vbCrlf
            Printer.Print vbCrlf
        ElseIf LVSkipPageYN And LVCtr > 5 Then
            Printer.NewPage ' Skip the page.
            '
            ' Insert 2 blank lines (top margin).
            ' This should be removed during phase 2.
            ' That is, when we interpret all control characters
            ' and take action accordingly.
            '
            Printer.Print vbCrlf
            Printer.Print vbCrlf
            If Printer.Orientation = 1 Then     ' Extra 2 blank lines for portait reports
                Printer.Print vbCrlf
                Printer.Print vbCrlf
            End If
         End If
        
    Loop 'Do While Not EOF(1)
    
    '
    ' Inform printer that printing is over.
    '
    LVOperation = "EndPrint"
    Printer.EndDoc
    
    '
    ' Exit
    '
    Exit Function
    
Err_PrintDocument:
    PrintDocument = Err.Description
    Exit Function
End Function

Private Sub PrintersList_Click()
   FPrinterName = PrintersList.Text
End Sub
Public Function ValidatePrinter() As String
   Dim hPrinter As Long
   Dim ByteBuf As Long
   Dim BytesNeeded As Long
   Dim PI2 As PRINTER_INFO_2
   Dim JI2 As JOB_INFO_2
   Dim PrinterInfo() As Byte
   Dim JobInfo() As Byte
   Dim result As Long
   Dim LastError As Long
   Dim tempStr As String
   Dim NumJI2 As Long
   Dim pDefaults As PRINTER_DEFAULTS
   Dim I As Integer
   
  
   'Set a default return value if no errors occur.
   ValidatePrinter = "Success"
   FPrinterStatus = ""
   FJobStatus = ""
   
   'Set desired access security setting.
   pDefaults.DesiredAccess = PRINTER_ACCESS_USE
   
   'Call API to get a handle to the printer.
   result = OpenPrinter(FPrinterName, hPrinter, pDefaults)
   If result = 0 Then
      'If an error occurred, display an error and exit sub.
      'sMsg = MessageText(Err.LastDllError)
      ValidatePrinter = "Cannot open printer " & FPrinterName & ". " & MessageText(Err.LastDllError)
      Exit Function
   End If

   'Init BytesNeeded
   BytesNeeded = 0

   'Clear the error object of any errors.
   Err.Clear

   'Determine the buffer size that is needed to get printer info.
   result = GetPrinter(hPrinter, 2, 0&, 0&, BytesNeeded)
   
   'Check for error calling GetPrinter.
   If Err.LastDllError <> ERROR_INSUFFICIENT_BUFFER Then
      'Display an error message, close printer, and exit sub.
      ValidatePrinter = "Couldn't allocate buffer for Printer Info"
      ClosePrinter hPrinter
      Exit Function
   End If
   
   ReDim PrinterInfo(1 To BytesNeeded)
   
   ByteBuf = BytesNeeded
   
   'Call GetPrinter to get the status.
   result = GetPrinter(hPrinter, 2, PrinterInfo(1), ByteBuf, BytesNeeded)
   
   'Check for errors.
   If result = 0 Then
      'Display error message, close printer, and exit sub.
      ValidatePrinter = "Couldn't get Printer Status! " & MessageText(Err.LastDllError)
      ClosePrinter hPrinter
      Exit Function
   End If

   'Copy contents of printer status byte array into a
   'PRINTER_INFO_2 structure to separate the individual elements.
   CopyMemory PI2, PrinterInfo(1), Len(PI2)
   
   'Check if printer is in ready state.
   FPrinterStatus = CheckPrinterStatus(PI2.Status)
   
   ' Assign DriverName and PortName
   FDriverName = GetString(PI2.pDriverName)
   FPrinterPort = GetString(PI2.pPortName)
   GVShareName = GetString(PI2.pShareName)
   GVServerName = GetString(PI2.pServerName)
   
   'Call API to get size of buffer that is needed.
   result = EnumJobs(hPrinter, 0&, &HFFFFFFFF, 2, ByVal 0&, 0&, BytesNeeded, NumJI2)
   
   'Check if there are no current jobs, and then display appropriate message.
   If BytesNeeded = 0 Then
      FJobStatus = "No Print Jobs!"
   Else
      FJobStatus = "Pending Print Jobs!"
   End If
   
   'Close the printer handle.
   ClosePrinter hPrinter
End Function

Private Sub SetDefaultPrinter(ByVal PrinterName As String, _
    ByVal DriverName As String, ByVal PrinterPort As String)
    Dim DeviceLine As String
    Dim r As Long
    Dim l As Long
    DeviceLine = PrinterName & "," & DriverName & "," & PrinterPort
    ' Store the new printer information in the [WINDOWS] section of
    ' the WIN.INI file for the DEVICE= item
    r = WriteProfileString("windows", "Device", DeviceLine)
    ' Cause all applications to reload the INI file:
    l = SendMessage(HWND_BROADCAST, WM_WININICHANGE, 0, "windows")
End Sub
Private Sub Testing()
    GVFunctionName = "MPRRLRGS"
    FFileName = "C:\Medicom\Reports\MPRRLRGS.LIS"
    FPrinterName = "\\CGanesan\HPLaserJ1200"
    FPrinterName = "\\HL7TEST\HPLaserJ"
    FPrinterName = "\\MEDNET2\Lexmark_Mktg"
    FPrinterName = "\\CHANDRA\NRGP6216"
    FPrinterName = "\\MEDNET2\Lexmark_VC"
    FPrinterName = "\\MEDNET2\Lexmark_R&D"
    FPrinterName = "\\CGANESAN\HP LaserJet 1200 Series PCL 6"
    GVCopies = 1
   
      
    '
    ' Add printers list for testing.
    '
    PrintersList.Clear
    PrintersList.AddItem "\\MEDNET2\Lexmark_R&D"
    PrintersList.AddItem "\\MEDNET2\Lexmark_110"
    PrintersList.AddItem "\\MEDNET2\Lexmark110"
    PrintersList.AddItem "\\MEDNET2\Lexmark_210"
    PrintersList.AddItem "\\MEDNET2\Lexmark460"
    PrintersList.AddItem "\\MEDNET2\Lexmark_VC"
    PrintersList.AddItem "\\MEDNET2\Lexmark_Mktg"
    PrintersList.AddItem "\\CGANESAN\HPLaserJ1200"
    PrintersList.AddItem "\\CGANESAN\HPLaserJet 1200 Series PCL 6"
    PrintersList.AddItem "\\HL7TEST\HPLaserJ"
    PrintersList.AddItem "\\CHANDRA\NRGP6216"
    PrintersList.AddItem "\\CSS-HELPDESK\HP DeskJet 895Cxi"
    PrintersList.AddItem "\\WALEED\Epson LQ-2070 ESC/P 2"
    PrintersList.AddItem "192.7.2.176"

    
End Sub



