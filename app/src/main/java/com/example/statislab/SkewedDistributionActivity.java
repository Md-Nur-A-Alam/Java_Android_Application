package com.example.statislab;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;

import java.text.DecimalFormat;

public class SkewedDistributionActivity extends AppCompatActivity {
    private Button btn;
    private TextView mu1,mu2,mu3,mu4,mu5,mu6,mu7,mu8,beta1,beta2,gama1,gama2,kartic,skewed;
    private EditText F1,F2,F3,F4,F5,F6,F7,F8,l1,l2,l3,l4,l5,l6,l7,l8,f1,f2,f3,f4,f5,f6,f7,f8;
    private static final DecimalFormat decfor = new DecimalFormat("0.00");
    private static final DecimalFormat decfor2 = new DecimalFormat("0.000000");

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skewed_distribution);

        btn = findViewById(R.id.Btn);
        mu1 = findViewById(R.id.Mu1);
        mu2 = findViewById(R.id.Mu2);
        mu3 = findViewById(R.id.Mu3);
        mu4 = findViewById(R.id.Mu4);
        mu5 = findViewById(R.id.mu4);
        mu6 = findViewById(R.id.mu5);
        mu7 = findViewById(R.id.mu6);
        mu8 = findViewById(R.id.mu7);

        beta1 = findViewById(R.id.Beta1);
        beta2 = findViewById(R.id.Beta2);
        gama1 = findViewById(R.id.Gama1);
        gama2 = findViewById(R.id.Gama2);
        kartic = findViewById(R.id.Kartic);
        skewed = findViewById(R.id.Skewed);

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

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double[] first = new double[8], last = new double[8], freeq= new double[8], m1 = new double[4],m = new double[4],b = new double[2],g = new double[2], fd = new double[8], fd2 = new double[8], fd3 = new double[8], fd4 = new double[8];
                double N=0,d=0,sumFd=0,sumFd2=0,sumFd3=0,sumFd4=0,h=0;
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

                h = first[1]-first[0];

                for(int i=0; i<8; i++){
                    d=i-3;
                    fd[i]=freeq[i]*d;
                    fd2[i]=freeq[i]*d*d;
                    fd3[i]=freeq[i]*d*d*d;
                    fd4[i]=freeq[i]*d*d*d*d;
                    N += freeq[i];
                    sumFd+=fd[i];
                    sumFd2 +=fd2[i];
                    sumFd3 +=fd3[i];
                    sumFd4 +=fd4[i];
                }

                m1[0]=sumFd*h/N;
                m1[1]=sumFd2*h*h/N;
                m1[2]=sumFd3*h*h*h/N;
                m1[3]=sumFd4*h*h*h*h/N;

                m[0] = 0;
                m[1] = m1[1] - m1[0]*m1[0];
                m[2] = m1[2] - 3*m1[0]*m1[1] + 2*m1[0]*m1[0]*m1[0];
                m[3] = m1[3] - 4*m1[0]*m1[2] + 6*m1[0]*m1[0]*m1[1] - 3*m1[0]*m1[0]*m1[0]*m1[0];

                b[0]=(m[2]*m[2])/(m[1]*m[1]*m[1]);
                b[1]=(m[3])/(m[1]*m[1]);

                String s1,s2;
                if (b[1]<3){
                    s2="platykurtic curve";
                } else if(b[1]==3){
                    s2="Mesokurtic curve";
                } else{
                    s2 = "Leptokurtic curve";
                }
                if (b[0]>0){
                    s1="Positive Kurtosis";
                } else{
                    s1 = "Negative Kurtosis";
                }
                g[0]=Math.sqrt(b[0]);
                g[1]=b[1]-3;
                mu1.setText("µ1'\n"+decfor.format(m1[0]));
                mu2.setText("µ2'\n"+decfor.format(m1[1]));
                mu3.setText("µ3'\n"+decfor.format(m1[2]));
                mu4.setText("µ4'\n"+decfor.format(m1[3]));
                mu5.setText("µ1\n"+decfor.format(m[0]));
                mu6.setText("µ2\n"+decfor.format(m[1]));
                mu7.setText("µ3\n"+decfor.format(m[2]));
                mu8.setText("µ4\n"+decfor.format(m[3]));
                beta1.setText("β1\t"+decfor2.format(b[0]));
                beta2.setText("β2\t"+decfor.format(b[1]));
                kartic.setText(s2);
                skewed.setText(s1);
                gama1.setText("γ1:\t"+decfor.format(g[0]));
                gama2.setText("γ2:\t"+decfor.format(g[1]));

                Toast.makeText(SkewedDistributionActivity.this," N:"+N+"sumFD:"+sumFd+" sumFD2:"+sumFd2+" sumFD3:"+sumFd3+" sumFD4:"+sumFd4+" h:"+h,Toast.LENGTH_SHORT).show();
//                Toast.makeText(SkewedDistributionActivity.this," N:"+N+"  FD0:"+fd[0]+"  FD1:"+fd[1]+"  FD2:"+fd[2]+"  FD3:"+fd[3]+"  FD4:"+fd[4]+"  FD5:"+fd[5]+"  FD6:"+fd[6]+"  FD7:"+fd[7],Toast.LENGTH_SHORT).show();

            }
        });
    }
}