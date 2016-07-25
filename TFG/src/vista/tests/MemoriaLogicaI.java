/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.ButtonColumn;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Pacient;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author a630703
 */
public class MemoriaLogicaI extends Test {
    
    /**
     * Creates new form MemoriaLogica
     * @param pacientActual
     */
    public MemoriaLogicaI(Pacient pacientActual) {
        super(pacientActual);
        initComponents();
        
        label = "MLI";
        
        initML1ATable();
        initML1BTable();
    }
    
    private void initML1ATable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
        new Object [][] {
            {"1", "La Maria", "<html><i>Maria</i> o variant", "0", "0"},
            {"2", "i el Pedro", "<html><i>Pedro</i> o variant", "0", "0"},
            {"3", "són amics", "<html><i>amics</i> (en qualsevol context)", "0", "0"},
            {"4", "des de fa 30", "<html>es requereix <i>trenta</i> (en qualsevol context), no es requereix el nombre específic d'anys", "0", "0"},
            {"5", "anys", "<html>es requereix <i>anys</i>", "0", "0"},
            {"6", "Cada", "<html><i>cada</i>, tots (en referencia només als dimarts), o <i>els dimarts</i>", "0", "0"},
            {"7", "dimarts", "<html>es requereix <i>dimarts</i> (en qualsevol context)", "0", "0"},
            {"8", "queda", "<html>qualsevol indicació que reflecteixi que els personatges queden intencionadament", "0", "0"},
            {"9", "per esmorzar", "<html>es requereix <i>esmorzar</i> (en qualsevol context)", "0", "0"},
            {"10", "al bar", "<html>es requereix <i>bar</i>", "0", "0"},
            {"11", "Cervanted", "<html>es requereix <i>Cervantes</i> (en qualsevol context)", "0", "0"},
            {"12", "Després surten junts a passejar", "indicació que els personatges passegen", "0", "0"},
            {"13", "pel parc", "<html>es requereix <i>parc</i> (en qualsevol context)", "0", "0"},
            {"14", "del Retiro.", "<html>es requereix <i>Retiro</i> (en qualsevol context)", "0", "0"}
        },
        new String [] {
            header+"Ítem", header+"Detall", header+"Criteri de puntuació", header+"<center>Puntuació<br>Primer record", header+"<center>Puntuació<br>Segon record"
        }
    );
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, true, true
        };
        
        model.setTypes(types);
        model.setCanEdit(canEdit);
        
        //editModel model = new editModel(digitsDirecteTable.getRowCount(),digitsDirecteTable.getColumnCount());
        ML1ATable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML1ATable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        for (int i=0; i<ML1ATable.getColumnModel().getColumnCount();i++){
            ML1ATable.getColumnModel().getColumn(i).setResizable(false);
            ML1ATable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }
        
        ML1ATable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        ML1ATable.getTableHeader().setReorderingAllowed(false);
        
        for (int i = 0; i<ML1ATable.getRowCount(); i++){
            ML1ATable.setRowHeight(i, 30);
        }
        
        Action action1;
        action1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 3));
                table.setValueAt(val == 0 ? "1" : "0", row, 3);
                
                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    sumaTotal += Integer.parseInt((String)table.getValueAt(i, 3));
                }
                historiaAprimerTotal.setText(sumaTotal+"");
                ML1Total.setText(""+(Integer.parseInt(historiaBprimerTotal.getText())+Integer.parseInt(historiaAprimerTotal.getText())+Integer.parseInt(historiaAsegonTotal.getText())));
            }
        };
        Action action2;
        action2 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 4));
                table.setValueAt(val == 0 ? "1" : "0", row, 4);
                
                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    sumaTotal += Integer.parseInt((String)table.getValueAt(i, 4));
                }
                historiaAsegonTotal.setText(sumaTotal+"");
                ML1Total.setText(""+(Integer.parseInt(historiaBprimerTotal.getText())+Integer.parseInt(historiaAprimerTotal.getText())+Integer.parseInt(historiaAsegonTotal.getText())));
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(ML1ATable, action1, 3);
        ButtonColumn buttonColumn2 = new ButtonColumn(ML1ATable, action2, 4);
        ML1ATable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML1ATable.packAll();
    }

    private void initML1BTable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
        new Object [][] {
            {"1", "Elena", "<html><i>Elena</i> o variant", "0"},
            {"2", "Pérez,", "<html>es requereix<i>Pérez</i>","0"},
            {"3", "del sud", "<html><i>sud</i> (en qualsevol context)", "0"},
            {"4", "de Madrid,", "<html><i>Madrid</i> (en qualsevol context), no es requereix el nombre específic d'anys", "0"},
            {"5", "treballadora", "indicació que tenia una feina", "0"},
            {"6", "com a cuinera", "<html>es requereix <i>cuinera</i> o variant", "0"},
            {"7", "al menjador", "<html>es requereix <i>menjador</i>", "0"},
            {"8", "d'una escola,", "<html>es requereix <i>escola</i> o <i>col·legi</i>", "0"},
            {"9", "va denunciar", "<html>indicació de denuncia o reclamació davant l'autoritat (en qualsevol context)", "0"},
            {"10", "a la comisseria", "<html>indicació de lloc de treball de la policia, oficina policial", "0"},
            {"11", "de policia", "<html><i>policia</i> (en qualsevol context)", "0"},
            {"12", "que habia estat assaltada", "indicació d'assalt, atracament", "0"},
            {"13", "la nit anterior", "indicació que l'assalt va ser la nit anterior", "0"},
            {"14", "al carrer Padilla,", "<html>carrer <i>Padilla</i> (en qualsevol context)", "0"},
            {"15", "i que li habien robat", "<html>indicació que la van robar", "0"},
            {"16", "56 euros.,", "<html>indicació que va ser substreta una quantitat entre 49-60 euros", "0"},
            {"17", "Tenia quatre", "<html>es requereix <i>quatre</i> juntament a la idea que eren seus", "0"},
            {"18", "nens petits", "<html>es requereix <i>nens</i> o variant", "0"},
            {"19", "no habia pogut pagar el lloguer", "<html>indicació que reflecteixi que el lloguer no havia estat pagat", "0"},
            {"20", "i portada dos dies", "<html>es requereix <i>dos dies</i> o variant que contingui<i>dos</i>", "0"},
            {"21", "sense menjar.", "<html>indicació que els nens o la familia no havien menjat", "0"},
            {"22", "La policia,", "<html>indicació de policia, un o més agents (en qualsevol context)", "0"},
            {"23", "commoguda per la història de la dona", "<html>indicació que la història va provocar compassió", "0"},
            {"24", "va realitzar una col·lecta", "<html>indicació que es van recollir diners o menjar", "0"},
            {"25", "per ajudar-la.", "<html>indicació que els diners o el menjar recollits eren per a ella o pels seus fills", "0"}
        },
        new String [] {
            header+"Ítem", header+"Detall", header+"Criteri de puntuació", header+"Puntuació"
        }
    );
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, true
        };
        
        model.setTypes(types);
        model.setCanEdit(canEdit);
        
        //editModel model = new editModel(digitsDirecteTable.getRowCount(),digitsDirecteTable.getColumnCount());
        ML1BTable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML1BTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        
        for (int i=0; i<ML1BTable.getColumnModel().getColumnCount();i++){
            ML1BTable.getColumnModel().getColumn(i).setResizable(false);
            ML1BTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }
        ML1BTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        ML1BTable.getTableHeader().setReorderingAllowed(false);
        
        for (int i = 0; i<ML1BTable.getRowCount(); i++){
            ML1BTable.setRowHeight(i, 30);
        }
        
        Action action1;
        action1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 3));
                table.setValueAt(val == 0 ? "1" : "0", row, 3);
                
                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    sumaTotal += Integer.parseInt((String)table.getValueAt(i, 3));
                }
                historiaBprimerTotal.setText(sumaTotal+"");
                ML1Total.setText(""+(sumaTotal+Integer.parseInt(historiaAprimerTotal.getText())+Integer.parseInt(historiaAsegonTotal.getText())));
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(ML1BTable, action1, 3);
        ML1BTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML1BTable.packAll();
    }
    
    private int calculaMLI(int punt) {
        int percentil = 0;
        int edat = pacientActual.getEdat();
        if(edat <= 64){
            if (punt <=3){
               percentil = 1; 
            } else if (punt>=4 && punt<=5){
                percentil = 2;
            }else if (punt>=6 && punt<=7){
                percentil = 3;
            }else if (punt==8){
                percentil = 4;
            }else if (punt>=9 && punt<=10){
                percentil = 5;
            }else if (punt>=11 && punt<=12){
                percentil = 6;
            }else if (punt>=13 && punt<=14){
                percentil = 7;
            }else if (punt>=15 && punt<=17){
                percentil = 8;
            }else if (punt>=18 && punt<=19){
                percentil = 9;
            }else if (punt>=20 && punt<=21){
                percentil = 10;
            }else if (punt>=22 && punt<=23){
                percentil = 11;
            }else if (punt>=24 && punt<=25){
                percentil = 12;
            }else if (punt>=26 && punt<=28){
                percentil = 13;
            }else if (punt>=29 && punt<=30){
                percentil = 14;
            }else if (punt>=31 && punt<=32){
                percentil = 15;
            }else if (punt>=33 && punt<=35){
                percentil = 16;
            }else if (punt>=36 && punt<=37){
                percentil = 17;
            }else if (punt>=38 && punt<=40){
                percentil = 18;
            }else if (punt>=41){
                percentil = 19;
            }
            
        } else if (edat >= 65 && edat<=69){
            
            if (punt <=4){
               percentil = 1; 
            } else if (punt>=5 && punt<=6){
                percentil = 2;
            }else if (punt>=7 && punt<=9){
                percentil = 3;
            }else if (punt>=10 && punt<=11){
                percentil = 4;
            }else if (punt>=12 && punt<=14){
                percentil = 5;
            }else if (punt>=15 && punt<=17){
                percentil = 6;
            }else if (punt>=18 && punt<=19){
                percentil = 7;
            }else if (punt>=20 && punt<=22){
                percentil = 8;
            }else if (punt>=23 && punt<=24){
                percentil = 9;
            }else if (punt>=25 && punt<=27){
                percentil = 10;
            }else if (punt>=28 && punt<=30){
                percentil = 11;
            }else if (punt>=31 && punt<=33){
                percentil = 12;
            }else if (punt>=34 && punt<=35){
                percentil = 13;
            }else if (punt>=36 && punt<=38){
                percentil = 14;
            }else if (punt>=39 && punt<=41){
                percentil = 15;
            }else if (punt>=42 && punt<=44){
                percentil = 16;
            }else if (punt>=45 && punt<=47){
                percentil = 17;
            }else if (punt>=48 && punt<=50){
                percentil = 18;
            }else if (punt>=51){
                percentil = 19;
            }
            
        } else if (edat >= 70 && edat<=74){
            
            if (punt <=3){
               percentil = 1; 
            } else if (punt>=4 && punt<=5){
                percentil = 2;
            }else if (punt>=6 && punt<=8){
                percentil = 3;
            }else if (punt>=9 && punt<=10){
                percentil = 4;
            }else if (punt>=11 && punt<=12){
                percentil = 5;
            }else if (punt>=13 && punt<=15){
                percentil = 6;
            }else if (punt>=16 && punt<=17){
                percentil = 7;
            }else if (punt>=18 && punt<=20){
                percentil = 8;
            }else if (punt>=21 && punt<=22){
                percentil = 9;
            }else if (punt>=23 && punt<=25){
                percentil = 10;
            }else if (punt>=26 && punt<=28){
                percentil = 11;
            }else if (punt>=29 && punt<=31){
                percentil = 12;
            }else if (punt>=32 && punt<=34){
                percentil = 13;
            }else if (punt>=35 && punt<=37){
                percentil = 14;
            }else if (punt>=38 && punt<=40){
                percentil = 15;
            }else if (punt>=41 && punt<=43){
                percentil = 16;
            }else if (punt>=44 && punt<=46){
                percentil = 17;
            }else if (punt>=47 && punt<=49){
                percentil = 18;
            }else if (punt>=50){
                percentil = 19;
            }
            
        }else if (edat >= 75 && edat<=79){
            
            if (punt <=1){
               percentil = 1; 
            } else if (punt>=2 && punt<=3){
                percentil = 2;
            }else if (punt>=4 && punt<=6){
                percentil = 3;
            }else if (punt>=7 && punt<=8){
                percentil = 4;
            }else if (punt>=9 && punt<=10){
                percentil = 5;
            }else if (punt>=11 && punt<=13){
                percentil = 6;
            }else if (punt>=14 && punt<=16){
                percentil = 7;
            }else if (punt>=17 && punt<=18){
                percentil = 8;
            }else if (punt>=19 && punt<=21){
                percentil = 9;
            }else if (punt>=22 && punt<=23){
                percentil = 10;
            }else if (punt>=24 && punt<=26){
                percentil = 11;
            }else if (punt>=27 && punt<=29){
                percentil = 12;
            }else if (punt>=30 && punt<=32){
                percentil = 13;
            }else if (punt>=33 && punt<=35){
                percentil = 14;
            }else if (punt>=36 && punt<=38){
                percentil = 15;
            }else if (punt>=39 && punt<=41){
                percentil = 16;
            }else if (punt>=42 && punt<=44){
                percentil = 17;
            }else if (punt>=45 && punt<=47){
                percentil = 18;
            }else if (punt>=48){
                percentil = 19;
            }
            
        }else if (edat >= 80){
            
            if (punt == 0){
               percentil = 2; 
            }else if (punt>=1 && punt<=2){
                percentil = 3;
            }else if (punt>=3 && punt<=5){
                percentil = 4;
            }else if (punt>=6 && punt<=7){
                percentil = 5;
            }else if (punt>=8 && punt<=10){
                percentil = 6;
            }else if (punt>=11 && punt<=12){
                percentil = 7;
            }else if (punt>=13 && punt<=15){
                percentil = 8;
            }else if (punt>=16 && punt<=17){
                percentil = 9;
            }else if (punt>=18 && punt<=20){
                percentil = 10;
            }else if (punt>=21 && punt<=23){
                percentil = 11;
            }else if (punt>=24 && punt<=26){
                percentil = 12;
            }else if (punt>=27 && punt<=29){
                percentil = 13;
            }else if (punt>=30 && punt<=32){
                percentil = 14;
            }else if (punt>=33 && punt<=35){
                percentil = 15;
            }else if (punt>=36 && punt<=38){
                percentil = 16;
            }else if (punt>=39 && punt<=41){
                percentil = 17;
            }else if (punt>=42 && punt<=44){
                percentil = 18;
            }else if (punt>=45){
                percentil = 19;
            }
            
        }
        
        return percentil;
    }

    private int calculaMLII(int punt) {
        int edat = pacientActual.getEdat();
        int percentil = 0;
        
        if(edat <= 64){
            if (punt == 0){
               percentil = 2;
            }else if (punt>=1 && punt<=2){
                percentil = 3;
            }else if (punt>=3 && punt<=4){
                percentil = 4;
            }else if (punt>=5 && punt<=7){
                percentil = 5;
            }else if (punt>=8 && punt<=9){
                percentil = 6;
            }else if (punt>=10 && punt<=11){
                percentil = 7;
            }else if (punt>=12 && punt<=13){
                percentil = 8;
            }else if (punt>=14 && punt<=15){
                percentil = 9;
            }else if (punt>=16 && punt<=17){
                percentil = 10;
            }else if (punt>=18 && punt<=19){
                percentil = 11;
            }else if (punt>=20 && punt<=21){
                percentil = 12;
            }else if (punt>=22 && punt<=23){
                percentil = 13;
            }else if (punt>=24 && punt<=25){
                percentil = 14;
            }else if (punt>=26 && punt<=27){
                percentil = 15;
            }else if (punt>=28 && punt<=29){
                percentil = 16;
            }else if (punt>=30 && punt<=31){
                percentil = 17;
            }else if (punt>=32 && punt<=33){
                percentil = 18;
            }else if (punt>=34){
                percentil = 19;
            }
            
        } else if (edat >= 65 && edat<=69){
            
            if (punt ==0){
               percentil = 2; 
            } else if (punt==1){
                percentil = 3;
            }else if (punt>=2 && punt<=3){
                percentil = 4;
            }else if (punt==4){
                percentil = 5;
            }else if (punt>=5 && punt<=6){
                percentil = 6;
            }else if (punt>=7 && punt<=8){
                percentil = 7;
            }else if (punt>=9 && punt<=10){
                percentil = 8;
            }else if (punt>=11 && punt<=12){
                percentil = 9;
            }else if (punt>=13 && punt<=14){
                percentil = 10;
            }else if (punt>=15 && punt<=16){
                percentil = 11;
            }else if (punt>=17 && punt<=18){
                percentil = 12;
            }else if (punt>=19 && punt<=21){
                percentil = 13;
            }else if (punt>=22 && punt<=23){
                percentil = 14;
            }else if (punt>=24 && punt<=26){
                percentil = 15;
            }else if (punt>=27 && punt<=29){
                percentil = 16;
            }else if (punt>=30 && punt<=32){
                percentil = 17;
            }else if (punt>=33 && punt<=35){
                percentil = 18;
            }else if (punt>=36){
                percentil = 19;
            }
            
        } else if (edat >= 70 && edat<=74){
            
            if (punt == 0){
               percentil = 4; 
            } else if (punt>=1 && punt<=2){
                percentil = 5;
            }else if (punt==3){
                percentil = 6;
            }else if (punt>=4 && punt<=5){
                percentil = 7;
            }else if (punt>=6 && punt<=7){
                percentil = 8;
            }else if (punt>=8 && punt<=10){
                percentil = 9;
            }else if (punt>=11 && punt<=12){
                percentil = 10;
            }else if (punt>=13 && punt<=14){
                percentil = 11;
            }else if (punt>=15 && punt<=17){
                percentil = 12;
            }else if (punt>=18 && punt<=19){
                percentil = 13;
            }else if (punt>=20 && punt<=22){
                percentil = 14;
            }else if (punt>=23 && punt<=25){
                percentil = 15;
            }else if (punt>=26 && punt<=28){
                percentil = 16;
            }else if (punt>=29 && punt<=32){
                percentil = 17;
            }else if (punt>=33 && punt<=34){
                percentil = 18;
            }else if (punt>=35){
                percentil = 19;
            }
            
        }else if (edat >= 75 && edat<=79){
            
            if (punt == 0){
               percentil = 4; 
            } else if (punt>=1 && punt<=2){
                percentil = 5;
            }else if (punt==3){
                percentil = 6;
            }else if (punt>=4 && punt<=5){
                percentil = 7;
            }else if (punt>=6 && punt<=7){
                percentil = 8;
            }else if (punt>=8 && punt<=9){
                percentil = 9;
            }else if (punt>=10 && punt<=11){
                percentil = 10;
            }else if (punt>=12 && punt<=13){
                percentil = 11;
            }else if (punt>=14 && punt<=15){
                percentil = 12;
            }else if (punt>=16 && punt<=17){
                percentil = 13;
            }else if (punt>=18 && punt<=20){
                percentil = 14;
            }else if (punt>=21 && punt<=22){
                percentil = 15;
            }else if (punt>=23 && punt<=25){
                percentil = 16;
            }else if (punt>=26 && punt<=28){
                percentil = 17;
            }else if (punt>=29 && punt<=31){
                percentil = 18;
            }else if (punt>=32){
                percentil = 19;
            }
            
        }else if (edat >= 80){
            
            if (punt>=0 && punt<=1){
                percentil = 6;
            }else if (punt>=2 && punt<=3){
                percentil = 7;
            }else if (punt==4){
                percentil = 8;
            }else if (punt>=5 && punt<=6){
                percentil = 9;
            }else if (punt>=7 && punt<=8){
                percentil = 10;
            }else if (punt>=9 && punt<=10){
                percentil = 11;
            }else if (punt>=11 && punt<=12){
                percentil = 12;
            }else if (punt>=13 && punt<=15){
                percentil = 13;
            }else if (punt>=16 && punt<=17){
                percentil = 14;
            }else if (punt>=18 && punt<=20){
                percentil = 15;
            }else if (punt>=21 && punt<=22){
                percentil = 16;
            }else if (punt>=23 && punt<=25){
                percentil = 17;
            }else if (punt>=26 && punt<=28){
                percentil = 18;
            }else if (punt>=29){
                percentil = 19;
            }
            
        }
        
        return percentil;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ML1Scroll = new javax.swing.JScrollPane();
        ML1Panel = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ML1ATable = new org.jdesktop.swingx.JXTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        historiaAprimerTotal = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        historiaAsegonTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textHistoriaAprimer = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textHistoriaAsegon = new javax.swing.JTextArea();
        resetHistoriaA = new javax.swing.JButton();
        ML1Scroll2 = new javax.swing.JScrollPane();
        ML1Panel1 = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ML1BTable = new org.jdesktop.swingx.JXTable();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        textHistoriaBprimer = new javax.swing.JTextArea();
        jLabel43 = new javax.swing.JLabel();
        resetHistoriaB = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        puntuacioML1 = new javax.swing.JLabel();
        ML1Total = new javax.swing.JLabel();
        historiaBprimerTotal = new javax.swing.JLabel();
        dataMl1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("<html><center><b>Memoria Lògica I</b>");

        ML1ATable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "9 - 7			 ", null, "0", null},
                {null, "6 - 3", null, "0", null},
                {"2", "5 - 8 - 2			 ", null, "0", null},
                {null, "6 - 9 - 4			 ", null, "0", null},
                {"3", "7 - 2 - 8 - 6			 ", null, "0", null},
                {null, "6 - 4 - 3 - 9			 ", null, "0", null},
                {"4", "4 - 2 - 7 - 3 - 1			 ", null, "0", null},
                {null, "7 - 5 - 8 - 3 - 6			 ", null, "0", null},
                {"5", "3 - 9 - 2 - 4 - 8 - 7			 ", null, "0", null},
                {null, "6 - 1 - 9 - 7 - 4 - 2			 ", null, "0", null},
                {"6", "4 - 1 - 7 - 9 - 3 - 8 - 6			 ", null, "0", null},
                {null, "6 - 9 - 1 - 7 - 4 - 2 - 8			 ", null, "0", null},
                {"7", "3 - 8 - 2 - 9 - 6 - 1 - 7 - 4			 ", null, "0", null},
                {null, "5 - 8 - 1 - 3 - 2 - 6 - 4 - 7			 ", null, "0", null},
                {"8", "2 - 7 - 5 - 8 - 6 - 3 - 1 - 9 - 4			 ", null, "0", null},
                {null, "7 - 1 - 3 - 9 - 4 - 2 - 5 - 6 - 8			 ", null, "0", null}
            },
            new String [] {
                "Ítem", "Intent", "Resposta", "<html><center>Puntuació intent<br>(0-1)", "Puntuació ítem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ML1ATable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML1ATable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML1ATable.setRowSelectionAllowed(false);
        ML1ATable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML1ATable.setSortable(false);
        ML1ATable.setSortsOnUpdates(false);
        jScrollPane6.setViewportView(ML1ATable);

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(65, 110, 160));
        jLabel32.setText("Total Historia A. Primer record:");

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(65, 110, 160));
        jLabel34.setText("Historia A");

        jLabel1.setText("La Maria i el Pedro són amics des de fa 30 anys. Cada dimarts queden per esmorzar al bar Cervantes.");

        jLabel3.setText("Després surten junts a passejar pel parc del Retiro.");

        historiaAprimerTotal.setBackground(new java.awt.Color(255, 255, 255));
        historiaAprimerTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        historiaAprimerTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historiaAprimerTotal.setText("0");
        historiaAprimerTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        historiaAprimerTotal.setOpaque(true);

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(65, 110, 160));
        jLabel36.setText("Total Historia A. Segon record:");

        historiaAsegonTotal.setBackground(new java.awt.Color(255, 255, 255));
        historiaAsegonTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        historiaAsegonTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historiaAsegonTotal.setText("0");
        historiaAsegonTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        historiaAsegonTotal.setOpaque(true);

        textHistoriaAprimer.setColumns(20);
        textHistoriaAprimer.setRows(5);
        jScrollPane2.setViewportView(textHistoriaAprimer);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Transcripció primer record:");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel35.setText("Transcripció segon record:");

        textHistoriaAsegon.setColumns(20);
        textHistoriaAsegon.setRows(5);
        jScrollPane3.setViewportView(textHistoriaAsegon);

        resetHistoriaA.setText("Reset");
        resetHistoriaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ML1PanelLayout = new javax.swing.GroupLayout(ML1Panel);
        ML1Panel.setLayout(ML1PanelLayout);
        ML1PanelLayout.setHorizontalGroup(
            ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ML1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ML1PanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ML1PanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel35)
                                    .addComponent(resetHistoriaA)
                                    .addGroup(ML1PanelLayout.createSequentialGroup()
                                        .addComponent(jLabel32)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(historiaAprimerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ML1PanelLayout.createSequentialGroup()
                                            .addComponent(jLabel36)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(historiaAsegonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(ML1PanelLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))))))
                .addContainerGap())
        );
        ML1PanelLayout.setVerticalGroup(
            ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ML1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ML1PanelLayout.createSequentialGroup()
                        .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(historiaAprimerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(ML1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(historiaAsegonTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetHistoriaA))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ML1Scroll.setViewportView(ML1Panel);

        add(ML1Scroll, "card1");

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("<html><center><b>Memoria Lògica I</b>");

        ML1BTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "9 - 7			 ", null, "0", null},
                {null, "6 - 3", null, "0", null},
                {"2", "5 - 8 - 2			 ", null, "0", null},
                {null, "6 - 9 - 4			 ", null, "0", null},
                {"3", "7 - 2 - 8 - 6			 ", null, "0", null},
                {null, "6 - 4 - 3 - 9			 ", null, "0", null},
                {"4", "4 - 2 - 7 - 3 - 1			 ", null, "0", null},
                {null, "7 - 5 - 8 - 3 - 6			 ", null, "0", null},
                {"5", "3 - 9 - 2 - 4 - 8 - 7			 ", null, "0", null},
                {null, "6 - 1 - 9 - 7 - 4 - 2			 ", null, "0", null},
                {"6", "4 - 1 - 7 - 9 - 3 - 8 - 6			 ", null, "0", null},
                {null, "6 - 9 - 1 - 7 - 4 - 2 - 8			 ", null, "0", null},
                {"7", "3 - 8 - 2 - 9 - 6 - 1 - 7 - 4			 ", null, "0", null},
                {null, "5 - 8 - 1 - 3 - 2 - 6 - 4 - 7			 ", null, "0", null},
                {"8", "2 - 7 - 5 - 8 - 6 - 3 - 1 - 9 - 4			 ", null, "0", null},
                {null, "7 - 1 - 3 - 9 - 4 - 2 - 5 - 6 - 8			 ", null, "0", null}
            },
            new String [] {
                "Ítem", "Intent", "Resposta", "<html><center>Puntuació intent<br>(0-1)", "Puntuació ítem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ML1BTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML1BTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML1BTable.setRowSelectionAllowed(false);
        ML1BTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML1BTable.setSortable(false);
        ML1BTable.setSortsOnUpdates(false);
        jScrollPane7.setViewportView(ML1BTable);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(65, 110, 160));
        jLabel37.setText("Total Historia B. Primer record:");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(65, 110, 160));
        jLabel38.setText("Historia B");

        jLabel39.setText("<html>Elena Pérez, del sud de Madrid, treballadora com a cuinera al menjador d'una escola, va denunciar a la comissaria de <br> policia que havia estat assaltada la nit anterior al carrer Padilla, i que li havien robat 56 euros. Tenia quatre <br> nens petits, no havia pogut pagar el lloguer i portaven dos dies sense menjar. La policia, commoguda per la història <br> de la dona, va realitzar una col·lecta per ajudar-la.");

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(65, 110, 160));
        jLabel42.setText("Puntuació directa ML1:");

        textHistoriaBprimer.setColumns(20);
        textHistoriaBprimer.setRows(5);
        jScrollPane8.setViewportView(textHistoriaBprimer);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setText("Transcripció record:");

        resetHistoriaB.setText("Reset");
        resetHistoriaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaBActionPerformed(evt);
            }
        });

        jLabel45.setText("(max. 25)");

        jLabel46.setText("(max. 53)");

        jLabel47.setText("<html><b>Nota:</b> <i>Memoria lógica II</i> debe aplicarse transcurridos entre 20 y <br>30 minutos desde la aplicación de <i>Memoria lógica I</i>. ");

        jPanel1.setBackground(new java.awt.Color(38, 79, 131));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(105, 150, 200));
        jLabel44.setText("Puntuació escalar ML1:");

        puntuacioML1.setBackground(new java.awt.Color(255, 255, 255));
        puntuacioML1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacioML1.setText("0");
        puntuacioML1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        puntuacioML1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(puntuacioML1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(puntuacioML1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        ML1Total.setBackground(new java.awt.Color(255, 255, 255));
        ML1Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ML1Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ML1Total.setText("0");
        ML1Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ML1Total.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ML1Total.setOpaque(true);

        historiaBprimerTotal.setBackground(new java.awt.Color(255, 255, 255));
        historiaBprimerTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        historiaBprimerTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historiaBprimerTotal.setText("0");
        historiaBprimerTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        historiaBprimerTotal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        historiaBprimerTotal.setOpaque(true);

        javax.swing.GroupLayout ML1Panel1Layout = new javax.swing.GroupLayout(ML1Panel1);
        ML1Panel1.setLayout(ML1Panel1Layout);
        ML1Panel1Layout.setHorizontalGroup(
            ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ML1Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ML1Panel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ML1Panel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ML1Panel1Layout.createSequentialGroup()
                                        .addComponent(jLabel42)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ML1Total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel46))
                                    .addComponent(jLabel43)
                                    .addComponent(resetHistoriaB)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dataMl1)
                                    .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ML1Panel1Layout.createSequentialGroup()
                                            .addComponent(jLabel37)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(historiaBprimerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jLabel45)))))
                            .addGroup(ML1Panel1Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        ML1Panel1Layout.setVerticalGroup(
            ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ML1Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ML1Panel1Layout.createSequentialGroup()
                        .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37)
                            .addComponent(jLabel45)
                            .addComponent(historiaBprimerTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ML1Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(ML1Total, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel46))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetHistoriaB)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataMl1)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        ML1Scroll2.setViewportView(ML1Panel1);

        add(ML1Scroll2, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void resetHistoriaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaAActionPerformed
        for (int i = 0; i<this.ML1ATable.getRowCount(); i++){
            ML1ATable.setValueAt("0", i, 3);
            ML1ATable.setValueAt("0", i, 4);
        }
        ML1Total.setText(historiaBprimerTotal.getText());
        textHistoriaAprimer.setText("");
        textHistoriaAsegon.setText("");
        this.historiaAprimerTotal.setText("0");
        this.historiaAsegonTotal.setText("0");
    }//GEN-LAST:event_resetHistoriaAActionPerformed

    private void resetHistoriaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaBActionPerformed
        for (int i = 0; i<this.ML1BTable.getRowCount(); i++){
            ML1BTable.setValueAt("0", i, 3);
        }
        textHistoriaBprimer.setText("");
        ML1Total.setText(textHistoriaAprimer.getText());
    }//GEN-LAST:event_resetHistoriaBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int MLI = calculaMLI(Integer.parseInt(ML1Total.getText()));
        puntuacioML1.setText(MLI+"");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataMl1.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable ML1ATable;
    private org.jdesktop.swingx.JXTable ML1BTable;
    private javax.swing.JPanel ML1Panel;
    private javax.swing.JPanel ML1Panel1;
    private javax.swing.JScrollPane ML1Scroll;
    private javax.swing.JScrollPane ML1Scroll2;
    private javax.swing.JLabel ML1Total;
    private javax.swing.JLabel dataMl1;
    private javax.swing.JLabel historiaAprimerTotal;
    private javax.swing.JLabel historiaAsegonTotal;
    private javax.swing.JLabel historiaBprimerTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel puntuacioML1;
    private javax.swing.JButton resetHistoriaA;
    private javax.swing.JButton resetHistoriaB;
    private javax.swing.JTextArea textHistoriaAprimer;
    private javax.swing.JTextArea textHistoriaAsegon;
    private javax.swing.JTextArea textHistoriaBprimer;
    // End of variables declaration//GEN-END:variables
}
