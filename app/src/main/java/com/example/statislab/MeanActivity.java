package com.example.statislab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MeanActivity extends AppCompatActivity {

    private Button btnMean,btnMode,btnMedian,btnQt,btnDc,btnPr;
    private TextView showMean,showMode,showMedian,showQt,showDc,showPr;
    private EditText F1,F2,F3,F4,F5,F6,F7,F8,l1,l2,l3,l4,l5,l6,l7,l8,f1,f2,f3,f4,f5,f6,f7,f8,qnum,dnum,pnum;

    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mean);

        btnMean = findViewById(R.id.Btn);
        btnMode = findViewById(R.id.CMode);
        btnMedian = findViewById(R.id.CMedian);
        btnQt = findViewById(R.id.CQuartiles);
        btnDc = findViewById(R.id.CDeciles);
        btnPr = findViewById(R.id.CPercentile);

        showMean = findViewById(R.id.calMean);
        showMode = findViewById(R.id.calMode);
        showMedian = findViewById(R.id.calMedian);
        showQt = findViewById(R.id.Mu1);
        showDc = findViewById(R.id.Mu2);
        showPr = findViewById(R.id.Mu3);

        F1 = findViewById(R.id.F1);
        F2 = findViewById(R.id.F2);
        F3 = findViewById(R.id.F3);
        F4 = findViewById(R.id.F4);
        F5 = findViewById(R.id.F5);
        F6 = findViewById(R.id.F6);
        F7 = findViewById(R.id.F7);
        F8 = findViewById(R.id.F8);

        f1 = findViewById(R.id.f1);
        f2 = findViewById(R.id.f2);
        f3 = findViewById(R.id.f3);
        f4 = findViewById(R.id.f4);
        f5 = findViewById(R.id.f5);
        f6 = findViewById(R.id.f6);
        f7 = findViewById(R.id.f7);
        f8 = findViewById(R.id.f8);

        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        l6 = findViewById(R.id.l6);
        l7 = findViewById(R.id.l7);
        l8 = findViewById(R.id.l8);

        qnum = findViewById(R.id.QNum);
        dnum = findViewById(R.id.DNum);
        pnum = findViewById(R.id.PNum);



        btnMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8], fx = new double[8];
                double gap, N=0, sumFX=0;
                String[] s=new String[8];

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }

                if(first[1]-last[0]==0){
                    gap=0;
                }
                else{
                    gap = first[1]-last[0];
                }
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+gap)/2.0;
                    fx[i]=freeq[i]*x[i];
                    N += freeq[i];
                    sumFX += fx[i];
                }

                double mean = sumFX / N;
                showMean.setText(""+decfor.format(mean));
                Toast.makeText(MeanActivity.this,"sumFX:"+sumFX+" N:"+N/*+" x:"+x[0]+" f"+freeq[0]+" fx:"+fx[0]+" last"+last[0]+" first"+first[0]+" gap:"+gap*/,Toast.LENGTH_SHORT).show();
            }
        });
        btnMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8];
                double gap, L0=0, fr1=0, fr0=0, fr2=0,h=0, max=0;
                String[] s=new String[8];

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }

                if(first[1]-last[0]==0){
                    gap=0;
                }
                else{
                    gap = first[1]-last[0];
                }
                h=last[0]-first[0]+gap;
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+2*gap)/2.0;
                    if(i==0){
                        max = freeq[i];
                        fr1= max;
                        fr0=0;
                        fr2=freeq[i+1];
                        L0 = first[i];
                    } else if (i == 7) {
                        if(freeq[i]>max){
                            fr1=freeq[i];
                            fr0=freeq[i-1];
                            fr2 = 0;
                            L0 = first[i];
                        }
                    } else {
                        if(freeq[i]>max){
                            max = freeq[i];
                            fr1=freeq[i];
                            fr0=freeq[i-1];
                            fr2 = freeq[i+1];
                            L0 = first[i]-gap/2.0;
                        }
                    }
                }

                double mode = L0 + (fr1-fr0)*h/(2*fr1-fr0-fr2);
                showMode.setText(""+decfor.format(mode));
                Toast.makeText(MeanActivity.this,"L0:"+L0+" F0:"+fr0+" F1:"+fr1+" F2:"+fr2+" h:"+h,Toast.LENGTH_SHORT).show();
            }
        });
        btnMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8];
                double gap,N=0, L0=0, cfp=0,f=0,fr=0,h,mid=0,cf=0,cp=0;
                String[] s=new String[8];

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }


                gap = first[1]-last[0];

                h=first[1]-first[0];
                for(int i=0;i<8;i++){
                    N+=freeq[i];
                }
                mid=N/2;
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+2*gap)/2.0;
                    cf+=freeq[i];
                    if(cf>mid && cp<mid){
                        cfp = cp;
                        f=freeq[i];
                        L0 = first[i]-gap/2;
                    }
                    cp=cf;
                }

                double median = L0 + (N/2-cfp)*h/(f);
                showMedian.setText(""+decfor.format(median));
                Toast.makeText(MeanActivity.this,"L0:"+L0+" N:"+N+" cfP:"+cfp+" f:"+f+" h:"+h,Toast.LENGTH_SHORT).show();
            }
        });
        btnQt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8];
                double gap,N=0, L0=0, cfp=0,f=0,fr=0,h,mid=0,cf=0,cp=0,q;
                String[] s=new String[8];

                s[0] = qnum.getText().toString();
                q = Double.parseDouble(s[0]);

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }

                if(first[1]-last[0]==0){
                    gap=0;
                }
                else{
                    gap = first[1]-last[0];
                }
                h=last[0]-first[0]+gap;
                for(int i=0;i<8;i++){
                    N+=freeq[i];
                }
                try {
                    if(q>4 || q<0)
                        throw new IllegalAccessException(""+q);
                }
                catch (IllegalAccessException e){
                    Toast.makeText(MeanActivity.this,"make sure your Quartiles number between 0 to 4 but you Entered"+q,Toast.LENGTH_SHORT).show();
                }
                mid=N*q/4;
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+2*gap)/2.0;
                    cf+=freeq[i];
                    if(cf>mid && cp<mid){
                        cfp = cp;
                        f=freeq[i];
                        L0 = first[i];
                    }
                    cp=cf;
                }

                double qtr = L0-gap/2 + (mid-cfp)*h/(f);
                showQt.setText(""+decfor.format(qtr));
                Toast.makeText(MeanActivity.this,"Q:"+q+"L0:"+L0+" N:"+N+" cfP:"+cfp+" f:"+f+" h:"+h,Toast.LENGTH_SHORT).show();
            }
        });
        btnDc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8];
                double gap,N=0, L0=0, cfp=0,f=0,fr=0,h,mid=0,cf=0,cp=0,d;
                String[] s=new String[8];

                s[0] = dnum.getText().toString();
                d = Double.parseDouble(s[0]);

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }

                if(first[1]-last[0]==0){
                    gap=0;
                }
                else{
                    gap = first[1]-last[0];
                }
                h=last[0]-first[0]+gap;
                for(int i=0;i<8;i++){
                    N+=freeq[i];
                }
                try {
                    if(d<0 || d>10)
                        throw new IllegalAccessException(""+d);
                }
                catch (IllegalAccessException e){
                    Toast.makeText(MeanActivity.this,"make sure your DECILES number between 0 to 10 but you Entered"+d,Toast.LENGTH_SHORT).show();
                }
                mid=N*d/10;
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+2*gap)/2.0;
                    cf+=freeq[i];
                    if(cf>mid && cp<mid){
                        cfp = cp;
                        f=freeq[i];
                        L0 = first[i];
                    }
                    cp=cf;
                }

                double dcl = L0-gap/2 + (N*d/10-cfp)*h/(f);
                showDc.setText(""+decfor.format(dcl));
                Toast.makeText(MeanActivity.this,"D:"+d+"L0:"+L0+" N:"+N+" cfP:"+cfp+" f:"+f+" h:"+h,Toast.LENGTH_SHORT).show();
            }
        });
        btnPr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double[] first = new double[8], last = new double[8], freeq= new double[8], x = new double[8];
                double gap,N=0, L0=0, cfp=0,f=0,fr=0,h,mid=0,cf=0,cp=0,p;
                String[] s=new String[8];

                s[0] = pnum.getText().toString();
                p = Double.parseDouble(s[0]);

                s[0] = F1.getText().toString();
                s[1] = F2.getText().toString();
                s[2] = F3.getText().toString();
                s[3] = F4.getText().toString();
                s[4] = F5.getText().toString();
                s[5] = F6.getText().toString();
                s[6] = F7.getText().toString();
                s[7] = F8.getText().toString();

                for(int i=0; i<8; i++){
                    first[i] = Double.parseDouble(s[i]);
                }

                s[0] = l1.getText().toString();
                s[1] = l2.getText().toString();
                s[2] = l3.getText().toString();
                s[3] = l4.getText().toString();
                s[4] = l5.getText().toString();
                s[5] = l6.getText().toString();
                s[6] = l7.getText().toString();
                s[7] = l8.getText().toString();

                for(int i=0; i<8; i++){
                    last[i] = Double.parseDouble(s[i]);
                }

                s[0] = f1.getText().toString();
                s[1] = f2.getText().toString();
                s[2] = f3.getText().toString();
                s[3] = f4.getText().toString();
                s[4] = f5.getText().toString();
                s[5] = f6.getText().toString();
                s[6] = f7.getText().toString();
                s[7] = f8.getText().toString();

                for(int i=0; i<8; i++){
                    freeq[i] = Double.parseDouble(s[i]);
                }

                if(first[1]-last[0]==0){
                    gap=0;
                }
                else{
                    gap = first[1]-last[0];
                }
                h=last[0]-first[0]+gap;
                for(int i=0;i<8;i++){
                    N+=freeq[i];
                }
                try {
                    if(p<0 || p>100)
                        throw new IllegalAccessException(""+p);
                }
                catch (IllegalAccessException e){
                    Toast.makeText(MeanActivity.this,"make sure your PERCENTILE number between 0 to 100 but you Entered"+p,Toast.LENGTH_SHORT).show();
                }
                mid=N*p/100;
                for(int i=0; i<8; i++){
                    x[i]=(last[i]+first[i]+2*gap)/2.0;
                    cf+=freeq[i];
                    if(cf>mid && cp<mid){
                        cfp = cp;
                        f=freeq[i];
                        L0 = first[i];
                    }
                    cp=cf;
                }

                double prl = L0-gap/2 + (N*p/100-cfp)*h/(f);
                showPr.setText(""+decfor.format(prl));
                Toast.makeText(MeanActivity.this,"P:"+p+"L0:"+L0+" N:"+N+" cfP:"+cfp+" f:"+f+" h:"+h,Toast.LENGTH_SHORT).show();
            }
        });

    }
}