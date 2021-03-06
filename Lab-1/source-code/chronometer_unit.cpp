//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "chronometer_unit.h"
#include "main_unit.h"
#include "dos.h"
#include "stdio.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"

struct date d;
struct time t;

struct Chrono {
 int min;
 int sec;
 int zec;
} cr;

TFChronometer *FChronometer;
//---------------------------------------------------------------------------
__fastcall TFChronometer::TFChronometer(TComponent* Owner)
        : TForm(Owner)
{
cr.min = 0;
cr.sec = 0;
cr.zec = 0;
char buf[20];
sprintf(buf,"%02d min %02d sec %02d zec",cr.min,cr.sec, cr.zec);
Edit2->Text=(AnsiString)buf;
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::btnExitClick(TObject *Sender)
{
FChronometer->Close();
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::FormClose(TObject *Sender,
      TCloseAction &Action)
{
FMain->Show();
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::btnStartClick(TObject *Sender)
{
Timer2->Enabled = true;
btnStart->Enabled = false;
btnStop->Enabled = true;
btnZero->Enabled = false;
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::Timer2Timer(TObject *Sender)
{
cr.zec++;
if (cr.zec == 10) {
cr.zec = 0;
cr.sec++;
}
if (cr.sec == 60) {
cr.sec = 0;
cr.min++;
}
char buf[20];
sprintf(buf,"%02d min %02d sec %02d zec",cr.min,cr.sec, cr.zec);
Edit2->Text=(AnsiString)buf;
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::btnStopClick(TObject *Sender)
{
btnStart->Enabled = true;
btnStop->Enabled = false;
btnZero->Enabled = true;
Timer2->Enabled = false;
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::btnZeroClick(TObject *Sender)
{
btnStart->Enabled = true;
btnStop->Enabled = false;
btnZero->Enabled = false;
cr.min = 0;
cr.sec = 0;
cr.zec = 0;
char buf[20];
sprintf(buf,"%02d min %02d sec %02d zec",cr.min,cr.sec, cr.zec);
Edit2->Text=(AnsiString)buf;
}
//---------------------------------------------------------------------------
void __fastcall TFChronometer::Timer1Timer(TObject *Sender)
{
char buf[20];
getdate(&d);
gettime(&t);
sprintf(buf,"%02d-%02d-%4d %02d:%02d:%02d",d.da_day,d.da_mon,d.da_year,
t.ti_hour,t.ti_min,t.ti_sec);
Edit1->Text=(AnsiString)buf;
}
//---------------------------------------------------------------------------
