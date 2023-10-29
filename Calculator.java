import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*<applet code="CAL.class" height=0 width=0></applet>*/
public class CAL extends Applet implements ActionListener{
    TextField input,output;
    Button n1,n2,n3,n4,n5,n6,n7,n8,n9,n0,cc,pow,ca,cs,cm,cd,ce;
    Thread t;
    Panel p1,p2,p3;
    Font f;
    Boolean condition=true;
    String[] checkarr,caloperator;
    double finalcal[],dummyp,sy,sx;
    String cdata,checkdata,checkchar,calint="",postint;
    int test,testop,cindex,csize,checksize,checkindex,removesize=0,checkarrindex,operatorcheck=0,caloutput=0;
    int calindex,opindex,p,size,x,y;
    public void init(){
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        sy=screenSize.getHeight();
        sx=screenSize.getWidth();
        x=(int)sx;
        y=(int)sy;
        x-=16;
        y-=118;
        resize(x,y);
        size=y/7;
        checkarr=new String[1024];
        caloperator=new String[1024];
        finalcal=new double[1024];
        Display display=new Display();
        Thread t1=new Thread(display);
        t1.start();
        f=new Font("Arial",Font.BOLD,size-10);
        setLayout(null);
        p1=new Panel();
        p2=new Panel();
        p3=new Panel();
        p1.setLayout(new GridLayout(2,0));
        p2.setLayout(new GridLayout(4,4));
        p3.setLayout(new CardLayout());
        input=new TextField();
        output=new TextField();
        output.setEditable(false);
        //input.setEditable(false);
        ini();
        addbt();
        add(p1);
        add(p2);
        add(p3);
    }
    public void ini(){
        n1=new Button("1");
        n2=new Button("2");
        n3=new Button("3");
        n4=new Button("4");
        n5=new Button("5");
        n6=new Button("6");
        n7=new Button("7");
        n8=new Button("8");
        n9=new Button("9");
        n0=new Button("0");
        cc=new Button("C");
        pow=new Button("^");
        ca=new Button("+");
        cs=new Button("-");
        cm=new Button("*");
        cd=new Button("/");
        ce=new Button("=");
        p1.add(input);
        p1.add(output);
        p2.add(n1);
        p2.add(n2);
        p2.add(n3);
        p2.add(n4);
        p2.add(n5);
        p2.add(n6);
        p2.add(n7);
        p2.add(n8);
        p2.add(n9);
        p2.add(n0);
        p2.add(cc);
        p2.add(pow);
        p2.add(ca);
        p2.add(cs);
        p2.add(cm);
        p2.add(cd);
        p3.add(ce);
        input.setFont(f);
        output.setFont(f); 
        n1.setFont(f);
        n2.setFont(f);
        n3.setFont(f);
        n4.setFont(f);
        n5.setFont(f);
        n6.setFont(f);
        n7.setFont(f);
        n8.setFont(f);
        n9.setFont(f);
        ca.setFont(f);
        n0.setFont(f);
        cc.setFont(f);
        pow.setFont(f);
        cs.setFont(f);
        cm.setFont(f);
        cd.setFont(f);
        ce.setFont(f);
        p1.setBounds(0,0,x,size*2);
        p2.setBounds(0,size*2,x,size*4);
        p3.setBounds(0,size*6,x,size);
    }
    public void addbt(){
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        n0.addActionListener(this);
        ca.addActionListener(this);
        cs.addActionListener(this);
        cm.addActionListener(this);
        cd.addActionListener(this);
        ce.addActionListener(this);
        cc.addActionListener(this);
        pow.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==n1){
        input.setText( input.getText()+"1");
       }
       if(ae.getSource()==n2){
        input.setText( input.getText()+"2");
       }
       if(ae.getSource()==n3){
        input.setText( input.getText()+"3");
       }
       if(ae.getSource()==n4){
        input.setText( input.getText()+"4");
       }
       if(ae.getSource()==n5){
        input.setText( input.getText()+"5");
       }
       if(ae.getSource()==n6){
        input.setText( input.getText()+"6");
       }
       if(ae.getSource()==n7){
        input.setText( input.getText()+"7");
       }
       if(ae.getSource()==n8){
        input.setText( input.getText()+"8");
       }
       if(ae.getSource()==n9){
        input.setText( input.getText()+"9");
       }
       if(ae.getSource()==n0){
        input.setText( input.getText()+"0");
       }
       if(ae.getSource()==cc){
        input.setText("");
        output.setText("");
       }
       if(ae.getSource()==pow){
        input.setText( input.getText()+"^");
       }
       if(ae.getSource()==ca){
        input.setText( input.getText()+"+");
       }
       if(ae.getSource()==cs){
        input.setText( input.getText()+"-");
       }
       if(ae.getSource()==cm){
        input.setText( input.getText()+"*");
       }
       if(ae.getSource()==cd){
        input.setText( input.getText()+"/");
       }
       if(ae.getSource()==ce){
        check();
        answer();
       }
    }
        public class Display implements Runnable{
        public void run(){  
        while(true){
        try{
        setSize(x,y);
        Thread.sleep(1);
        }catch(Exception e){     
             }
         }
     }
    }
     public void check(){
        checkdata=input.getText();
        checksize=checkdata.length();
        checkindex=0;
         //filter
        operatorcheck=1;
        while(checkindex<checksize){
            checkchar=""+checkdata.charAt(checkindex);
            if(checkindex!=checksize-1){
            postint=""+checkdata.charAt(checkindex+1);
            }
            if((postint.equals("1")||postint.equals("2")||postint.equals("3")||postint.equals("4")||postint.equals("5")||postint.equals("6")||postint.equals("7")||postint.equals("8")||postint.equals("9")||postint.equals("0"))){
                condition=true;
            }
            if(checkchar.equals("1")||checkchar.equals("2")||checkchar.equals("3")||checkchar.equals("4")||checkchar.equals("5")||checkchar.equals("6")||checkchar.equals("7")||checkchar.equals("8")||checkchar.equals("9")||checkchar.equals("0")){
                checkarr[checkindex]=checkchar; 
            }
            else if((checkchar.equals("+")||checkchar.equals("-")||checkchar.equals("*")||checkchar.equals("/")||checkchar.equals("^"))&&(operatorcheck==0)&&(condition)){
                operatorcheck=2;
                checkarr[checkindex]=checkchar;
            }
            else if(operatorcheck==1){
                while(true){
                    checkchar=""+checkdata.charAt(checkindex);
                    if(checkchar.equals("+")||checkchar.equals("-")||checkchar.equals("*")||checkchar.equals("/")||checkchar.equals("^")){
                        checkarr[checkindex]=" ";
                        checkindex++;
                    }
                    else{
                        checkindex--;
                        break;
                    }
                }
            }
            else{
                checkarr[checkindex]=" ";
            }
            if(operatorcheck>0){
                operatorcheck--;
            }
                condition=false;
                checkindex++;       
        }
        checkindex=0;
        input.setText("");
        while(checkindex<checksize){
            if(checkarr[checkindex].equals(" ")){
                checkindex++;
                removesize=removesize+1;
                continue;
            }
            input.setText(input.getText()+""+checkarr[checkindex]);
            checkindex++;
        }
        checksize=checksize-removesize;
        removesize=0;
    }
    public void answer(){
            checkdata=input.getText();
            checksize=checkdata.length();
            checkindex=0;
            calindex=0;
            opindex=0;
            while(checkindex<checksize){
                checkchar=""+checkdata.charAt(checkindex);
                if(checkchar.equals("1")||checkchar.equals("2")||checkchar.equals("3")||checkchar.equals("4")||checkchar.equals("5")||checkchar.equals("6")||checkchar.equals("7")||checkchar.equals("8")||checkchar.equals("9")||checkchar.equals("0")){
                    calint=calint+checkchar;
                }
                else{
                    finalcal[calindex]=Double.valueOf(Integer.parseInt(calint)+".0");
                    calint="";
                    calindex++;
                }
                if(checkchar.equals("+")||checkchar.equals("-")||checkchar.equals("*")||checkchar.equals("/")||checkchar.equals("^")){     
                    caloperator[opindex]=checkchar; 
                    opindex++;
                }   
                checkindex++;
                if(checkindex==checksize){
                    finalcal[calindex]=Double.valueOf(Integer.parseInt(calint)+".0");
                    calint="";
                    calindex++;
                }
            }
            checkindex=0;
            while(checkindex<opindex){
                for(test=0;test<5;test++){
                            calculation(test);            
                    }         
                }
                checkindex++;
            }
          public void calculation(int t){                   
            if(t==0){
                testop=0;
                    while(testop<opindex){
                        if(caloperator[testop].equals("^")){
                            dummyp=finalcal[testop];
                            for(p=1;p<finalcal[testop+1];p++){
                                finalcal[testop]=finalcal[testop]*dummyp;
                            }
                            while(testop<opindex-1){
                                finalcal[testop+1]=finalcal[testop+2];
                                caloperator[testop]=caloperator[testop+1];  
                                testop++;
                            }
                            opindex--;
                        }
                        testop++;
                    }
            }
                            if(t==1){
                            testop=0;
                                while(testop<opindex){
                                    if(caloperator[testop].equals("/")){
                                        finalcal[testop]=finalcal[testop]/finalcal[testop+1];
                                        while(testop<opindex-1){
                                            finalcal[testop+1]=finalcal[testop+2];
                                            caloperator[testop]=caloperator[testop+1];  
                                            testop++;
                                        }
                                        opindex--;
                                    }
                                    testop++;
                                }
                        }
                        if(t==2){
                            testop=0;
                                while(testop<opindex){
                                    if(caloperator[testop].equals("*")){
                                        finalcal[testop]=finalcal[testop]*finalcal[testop+1];
                                        while(testop<opindex-1){
                                            finalcal[testop+1]=finalcal[testop+2];
                                            caloperator[testop]=caloperator[testop+1];  
                                            testop++;
                                        }
                                        opindex--;
                                    }
                                    testop++;
                                }
                        }
                        if(t==3){
                            testop=0;
                                while(testop<opindex){
                                    if(caloperator[testop].equals("+")){
                                        finalcal[testop]=finalcal[testop]+finalcal[testop+1];
                                        while(testop<opindex-1){
                                            finalcal[testop+1]=finalcal[testop+2];
                                            caloperator[testop]=caloperator[testop+1];  
                                            testop++;
                                        }
                                        opindex--;
                                    }
                                    testop++;
                                }
                        }
                        if(t==4){
                            testop=0;
                                while(testop<opindex){
                                    if(caloperator[testop].equals("-")){
                                        finalcal[testop]=finalcal[testop]-finalcal[testop+1];
                                        while(testop<opindex-1){
                                            finalcal[testop+1]=finalcal[testop+2];
                                            caloperator[testop]=caloperator[testop+1];  
                                            testop++;
                                        }
                                        opindex--;
                                    }
                                    testop++;
                                }
                        }
                        output.setText(""+finalcal[0]);
                }      
        }  
