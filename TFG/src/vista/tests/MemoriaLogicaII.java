/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.ButtonColumn;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;

import controlador.Utils;
import model.Pacient;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author a630703
 */
public class MemoriaLogicaII extends Test {

    Pacient pacientActual;

    /**
     * Creates new form MemoriaLogicaII
     * @param pacientActual
     */
    public MemoriaLogicaII(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "ML2";

        numPaginesTotal = this.getComponentCount();

        initML2ATable();
        initML2BTable();
        initML2RecTable();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Memoria logica II
        Utils.setProperty(prop,"historiaAprimerTotal2",historiaAprimerTotal2);
        Utils.setProperty(prop,"textHistoriaAprimer2",textHistoriaAprimer2);
        Utils.setProperty(prop,"historiaBprimerTotal2",historiaBprimerTotal2);
        Utils.setProperty(prop,"textHistoriaBprimer2",textHistoriaBprimer2);
        Utils.setProperty(prop,"ML2Total",ML2Total);
        Utils.setProperty(prop,"puntuacioML2",puntuacioML2);
        Utils.setProperty(prop,"totalRecA",totalRecA);
        Utils.setProperty(prop,"totalRecB",totalRecB);
        Utils.setProperty(prop,"totalRec",totalRec);
    }

    private void initML2ATable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
                new Object [][] {
                        {"1", "La Maria", "<html><i>Maria</i> o variant", "0"},
                        {"2", "i el Pedro", "<html><i>Pedro</i> o variant", "0"},
                        {"3", "són amics", "<html><i>amics</i> (en qualsevol context)", "0"},
                        {"4", "des de fa 30", "<html>es requereix <i>trenta</i> (en qualsevol context), no es requereix el nombre específic d'anys", "0"},
                        {"5", "anys", "<html>es requereix <i>anys</i>", "0"},
                        {"6", "Cada", "<html><i>cada</i>, tots (en referencia només als dimarts), o <i>els dimarts</i>", "0"},
                        {"7", "dimarts", "<html>es requereix <i>dimarts</i> (en qualsevol context)", "0", "0"},
                        {"8", "queda", "<html>qualsevol indicació que reflecteixi que els personatges queden intencionadament", "0"},
                        {"9", "per esmorzar", "<html>es requereix <i>esmorzar</i> (en qualsevol context)", "0"},
                        {"10", "al bar", "<html>es requereix <i>bar</i>", "0"},
                        {"11", "Cervanted", "<html>es requereix <i>Cervantes</i> (en qualsevol context)", "0"},
                        {"12", "Després surten junts a passejar", "indicació que els personatges passegen", "0"},
                        {"13", "pel parc", "<html>es requereix <i>parc</i> (en qualsevol context)", "0"},
                        {"14", "del Retiro.", "<html>es requereix <i>Retiro</i> (en qualsevol context)", "0"}
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
        ML2ATable.setModel(model);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML2ATable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        for (int i=0; i<ML2ATable.getColumnModel().getColumnCount();i++){
            ML2ATable.getColumnModel().getColumn(i).setResizable(false);
            ML2ATable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }

        ML2ATable.setHighlighters(HighlighterFactory.createSimpleStriping());

        ML2ATable.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i<ML2ATable.getRowCount(); i++){
            ML2ATable.setRowHeight(i, 30);
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
                historiaAprimerTotal2.setText(sumaTotal+"");
                ML2Total.setText(""+sumaTotal+historiaBprimerTotal2.getText());
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(ML2ATable, action1, 3);
        ML2ATable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML2ATable.packAll();
    }

    private void initML2BTable() {
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
        ML2BTable.setModel(model);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML2BTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );

        for (int i=0; i<ML2BTable.getColumnModel().getColumnCount();i++){
            ML2BTable.getColumnModel().getColumn(i).setResizable(false);
            ML2BTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }

        ML2BTable.setHighlighters(HighlighterFactory.createSimpleStriping());

        ML2BTable.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i<ML2BTable.getRowCount(); i++){
            ML2BTable.setRowHeight(i, 30);
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
                historiaBprimerTotal2.setText(sumaTotal+"");
                ML2Total.setText(""+(sumaTotal+Integer.parseInt(historiaAprimerTotal2.getText())));
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(ML2BTable, action1, 3);
        ML2BTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML2BTable.packAll();
    }

    private void initML2RecTable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        String si = "<html>N&nbsp;&nbsp;&nbsp;<b><font color=\"rgb(80,130,190)\">   S</font></b>";
        String no = "<html><font color=\"rgb(80,130,190)\"><b>N   </b></font>&nbsp;&nbsp;&nbsp;S";
        CustomModel model = new CustomModel(
                new Object [][] {
                        {"1", "Una de les persones de la història, es deia Maria?", si, "0"},
                        {"2", "L'altra persona, es deia Pedro?", si,"0"},
                        {"3", "Es deia a la història que estaven casats?", no, "0"},
                        {"4", "Eren amics des de feia 20 anys?", no, "0"},
                        {"5", "Quedaven cada dimarts?", si, "0"},
                        {"6", "Menjaven al bar El Retiro?", no, "0"},
                        {"7", "Desrés d'esmorzar, anaven a observar ocells a casa del Pedro?", no, "0"},
                        {"8", "Passejaven pel parc del Retiro?", si, "0"}
                },
                new String [] {
                        header+"Ítem", header+"Detall", header+"Resposta", header+"Puntuació"
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

        ML2RecTableA.setModel(model);

        CustomModel model2 = new CustomModel(
                new Object [][] {
                        {"9", "La dona, es deia Diana Pérez?", no,"0"},
                        {"10", "Vivia al sud de Madrid?", si, "0"},
                        {"11", "La dona era cuinera?", si, "0"},
                        {"12", "Traballava a un restaurant?", no, "0"},
                        {"13", "Tenia quatre fills?", si, "0"},
                        {"14", "Els fills eren adolescents?", no, "0"},
                        {"15", "Va tenir lloc el robatori al carrer Reial?", no, "0"},
                        {"16", "Va dir la dona que li havien robat dos dies abans?", no, "0"},
                        {"17", "Va denunciar la dona el robatori a comissaria?", si, "0"},
                        {"18", "Van robar a la dona 75 euros?", no, "0"},
                        {"19", "Havia estat la família sense menjar durant quatre dies?", no, "0"},
                        {"20", "La dona, havia de pagar el lloguer?", si, "0"},
                        {"21", "La policia va detenir el lladre?", no, "0"},
                        {"22", "La policia es va commoure amb la història de la dona?", si, "0"},
                        {"23", "¿La policia va organitzar una col·lecta?", si, "0"}
                },
                new String [] {
                        header+"Ítem", header+"Detall", header+"Resposta", header+"Puntuació"
                }
        );

        model2.setTypes(types);
        model2.setCanEdit(canEdit);

        ML2RecTableB.setModel(model2);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML2RecTableA.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        ML2RecTableA.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );

        for (int i=0; i<ML2RecTableA.getColumnModel().getColumnCount();i++){
            ML2RecTableA.getColumnModel().getColumn(i).setResizable(false);
            ML2RecTableA.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }

        ML2RecTableA.setHighlighters(HighlighterFactory.createSimpleStriping());

        ML2RecTableA.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i<ML2RecTableA.getRowCount(); i++){
            ML2RecTableA.setRowHeight(i, 30);
        }

        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        ML2RecTableB.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        ML2RecTableB.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );

        for (int i=0; i<ML2RecTableB.getColumnModel().getColumnCount();i++){
            ML2RecTableB.getColumnModel().getColumn(i).setResizable(false);
            ML2RecTableB.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }

        ML2RecTableB.setHighlighters(HighlighterFactory.createSimpleStriping());

        ML2RecTableB.getTableHeader().setReorderingAllowed(false);

        for (int i = 0; i<ML2RecTableB.getRowCount(); i++){
            ML2RecTableB.setRowHeight(i, 30);
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

                System.out.println(table.getRowCount());
                if (table.getRowCount() <= 8){
                    totalRecA.setText(sumaTotal+"");
                }else{
                    totalRecB.setText(sumaTotal+"");
                }
                totalRec.setText(""+(Integer.parseInt(totalRecA.getText())+Integer.parseInt(totalRecB.getText())));
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(ML2RecTableA, action1, 3);
        ML2RecTableA.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML2RecTableA.packAll();

        ButtonColumn buttonColumn2 = new ButtonColumn(ML2RecTableB, action1, 3);
        ML2RecTableB.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ML2RecTableB.packAll();
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

        ML2Scroll1 = new javax.swing.JScrollPane();
        ML2Panel2 = new javax.swing.JPanel();
        jLabel109 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        ML2ATable = new org.jdesktop.swingx.JXTable();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        historiaAprimerTotal2 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        textHistoriaAprimer2 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        resetHistoriaA1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        ML2Scroll3 = new javax.swing.JScrollPane();
        MLPanel3 = new javax.swing.JPanel();
        jLabel110 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        ML2BTable = new org.jdesktop.swingx.JXTable();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        textHistoriaBprimer2 = new javax.swing.JTextArea();
        jLabel54 = new javax.swing.JLabel();
        resetHistoriaB1 = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        puntuacioML2 = new javax.swing.JLabel();
        ML2Total = new javax.swing.JLabel();
        historiaBprimerTotal2 = new javax.swing.JLabel();
        dataMl2 = new javax.swing.JLabel();
        ML2Scroll4 = new javax.swing.JScrollPane();
        ML2Panel4 = new javax.swing.JPanel();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ML2RecTableA = new org.jdesktop.swingx.JXTable();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        totalRecA = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        ML2RecTableB = new org.jdesktop.swingx.JXTable();
        jLabel59 = new javax.swing.JLabel();
        totalRecB = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        totalRec = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel109.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel109.setText("<html><center><b>Memoria Lògica II</b>");

        ML2ATable.setModel(new javax.swing.table.DefaultTableModel(
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
        ML2ATable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML2ATable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML2ATable.setRowSelectionAllowed(false);
        ML2ATable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML2ATable.setSortable(false);
        ML2ATable.setSortsOnUpdates(false);
        jScrollPane10.setViewportView(ML2ATable);

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(65, 110, 160));
        jLabel40.setText("Total Historia A (max 14):");

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(65, 110, 160));
        jLabel41.setText("Historia A");

        jLabel2.setText("<html><b>Nota:</b> Memoria lógica II debe aplicarse transcurridos entre 20 y 30 minutos desde la aplicación de Memoria lógica I. ");

        historiaAprimerTotal2.setBackground(new java.awt.Color(255, 255, 255));
        historiaAprimerTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        historiaAprimerTotal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historiaAprimerTotal2.setText("0");
        historiaAprimerTotal2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        historiaAprimerTotal2.setOpaque(true);

        textHistoriaAprimer2.setColumns(20);
        textHistoriaAprimer2.setRows(5);
        jScrollPane11.setViewportView(textHistoriaAprimer2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Transcripció record:");

        resetHistoriaA1.setText("Reset");
        resetHistoriaA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaA1ActionPerformed(evt);
            }
        });

        jLabel8.setText("La Maria i el Pedro són amics des de fa 30 anys. Cada dimarts queden per esmorzar al bar Cervantes.");

        jLabel9.setText("Després surten junts a passejar pel parc del Retiro.");

        javax.swing.GroupLayout ML2Panel2Layout = new javax.swing.GroupLayout(ML2Panel2);
        ML2Panel2.setLayout(ML2Panel2Layout);
        ML2Panel2Layout.setHorizontalGroup(
                ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                                                                .addComponent(jLabel40)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(historiaAprimerTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(resetHistoriaA1)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel41)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel9)
                                                                        .addComponent(jLabel8)
                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap())
        );
        ML2Panel2Layout.setVerticalGroup(
                ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel41)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ML2Panel2Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(ML2Panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel40)
                                                        .addComponent(historiaAprimerTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(resetHistoriaA1)))
                                .addContainerGap())
        );

        ML2Scroll1.setViewportView(ML2Panel2);

        add(ML2Scroll1, "card1");

        jLabel110.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel110.setText("<html><center><b>Memoria Lògica II</b>");

        ML2BTable.setModel(new javax.swing.table.DefaultTableModel(
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
        ML2BTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML2BTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML2BTable.setRowSelectionAllowed(false);
        ML2BTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML2BTable.setSortable(false);
        ML2BTable.setSortsOnUpdates(false);
        jScrollPane13.setViewportView(ML2BTable);

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(65, 110, 160));
        jLabel50.setText("Total Historia B:");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(65, 110, 160));
        jLabel51.setText("Historia B");

        jLabel52.setText("<html>Elena Pérez, del sud de Madrid, treballadora com a cuinera al menjador d'una escola, va denunciar a la comissaria de <br> policia que havia estat assaltada la nit anterior al carrer Padilla, i que li havien robat 56 euros. Tenia quatre <br> nens petits, no havia pogut pagar el lloguer i portaven dos dies sense menjar. La policia, commoguda per la història <br> de la dona, va realitzar una col·lecta per ajudar-la.");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(65, 110, 160));
        jLabel53.setText("Puntuació directa MLII:");

        textHistoriaBprimer2.setColumns(20);
        textHistoriaBprimer2.setRows(5);
        jScrollPane14.setViewportView(textHistoriaBprimer2);

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel54.setText("Transcripció record:");

        resetHistoriaB1.setText("Reset");
        resetHistoriaB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaB1ActionPerformed(evt);
            }
        });

        jLabel55.setText("(max. 25)");

        jLabel56.setText("(max. 39)");

        jPanel2.setBackground(new java.awt.Color(38, 79, 131));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Calcular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(105, 150, 200));
        jLabel58.setText("Puntuació escalar MLII:");

        puntuacioML2.setBackground(new java.awt.Color(255, 255, 255));
        puntuacioML2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacioML2.setText("0");
        puntuacioML2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        puntuacioML2.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel58)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(puntuacioML2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel58)
                                        .addComponent(puntuacioML2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(32, Short.MAX_VALUE))
        );

        ML2Total.setBackground(new java.awt.Color(255, 255, 255));
        ML2Total.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ML2Total.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ML2Total.setText("0");
        ML2Total.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ML2Total.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ML2Total.setOpaque(true);

        historiaBprimerTotal2.setBackground(new java.awt.Color(255, 255, 255));
        historiaBprimerTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        historiaBprimerTotal2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        historiaBprimerTotal2.setText("0");
        historiaBprimerTotal2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        historiaBprimerTotal2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        historiaBprimerTotal2.setOpaque(true);

        javax.swing.GroupLayout MLPanel3Layout = new javax.swing.GroupLayout(MLPanel3);
        MLPanel3.setLayout(MLPanel3Layout);
        MLPanel3Layout.setHorizontalGroup(
                MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel53)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(ML2Total, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addComponent(jLabel56))
                                                                        .addComponent(jLabel54)
                                                                        .addComponent(resetHistoriaB1)
                                                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                                                .addComponent(jLabel50)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(historiaBprimerTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(jLabel55))
                                                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(dataMl2)
                                                                        .addComponent(jScrollPane14)))
                                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                                .addComponent(jLabel51)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        MLPanel3Layout.setVerticalGroup(
                MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel51)
                                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MLPanel3Layout.createSequentialGroup()
                                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel50)
                                                        .addComponent(jLabel55)
                                                        .addComponent(historiaBprimerTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(MLPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel53)
                                                        .addComponent(ML2Total, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel56))
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel54)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(resetHistoriaB1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(dataMl2)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE))
                                .addContainerGap())
        );

        ML2Scroll3.setViewportView(MLPanel3);

        add(ML2Scroll3, "card2");

        jLabel113.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel113.setText("<html><center><b>Memoria Lògica II</b>");

        ML2RecTableA.setModel(new javax.swing.table.DefaultTableModel(
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
        ML2RecTableA.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML2RecTableA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML2RecTableA.setRowSelectionAllowed(false);
        ML2RecTableA.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML2RecTableA.setSortable(false);
        ML2RecTableA.setSortsOnUpdates(false);
        jScrollPane12.setViewportView(ML2RecTableA);

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(65, 110, 160));
        jLabel48.setText("Total Reconeixement Historia A:");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(65, 110, 160));
        jLabel49.setText("Historia A");

        totalRecA.setBackground(new java.awt.Color(255, 255, 255));
        totalRecA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalRecA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalRecA.setText("0");
        totalRecA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalRecA.setOpaque(true);

        ML2RecTableB.setModel(new javax.swing.table.DefaultTableModel(
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
        ML2RecTableB.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        ML2RecTableB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ML2RecTableB.setRowSelectionAllowed(false);
        ML2RecTableB.setSelectionBackground(new java.awt.Color(255, 255, 255));
        ML2RecTableB.setSortable(false);
        ML2RecTableB.setSortsOnUpdates(false);
        jScrollPane15.setViewportView(ML2RecTableB);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(65, 110, 160));
        jLabel59.setText("Total Reconeixement Historia B:");

        totalRecB.setBackground(new java.awt.Color(255, 255, 255));
        totalRecB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalRecB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalRecB.setText("0");
        totalRecB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalRecB.setOpaque(true);

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(65, 110, 160));
        jLabel61.setText("Historia B");

        jPanel3.setBackground(new java.awt.Color(220, 218, 195));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(65, 110, 160));
        jLabel60.setText("Puntuació directa ML II-Reconexement");

        totalRec.setBackground(new java.awt.Color(255, 255, 255));
        totalRec.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalRec.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalRec.setText("0");
        totalRec.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalRec.setOpaque(true);

        jLabel4.setText("(Historia A + Historia B)");

        jLabel6.setText("(Màxim = 23)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel60)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(totalRec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel60)
                                        .addComponent(totalRec, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addContainerGap())
        );

        javax.swing.GroupLayout ML2Panel4Layout = new javax.swing.GroupLayout(ML2Panel4);
        ML2Panel4.setLayout(ML2Panel4Layout);
        ML2Panel4Layout.setHorizontalGroup(
                ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel49))
                                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ML2Panel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel48)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(totalRecA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                                                .addComponent(jLabel59)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(totalRecB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabel61)
                                                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap())
        );
        ML2Panel4Layout.setVerticalGroup(
                ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel61)
                                        .addComponent(jLabel49))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(ML2Panel4Layout.createSequentialGroup()
                                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel48)
                                                        .addComponent(totalRecA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ML2Panel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel59)
                                        .addComponent(totalRecB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        ML2Scroll4.setViewportView(ML2Panel4);

        add(ML2Scroll4, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void resetHistoriaA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaA1ActionPerformed
        for (int i = 0; i<this.ML2ATable.getRowCount(); i++){
            ML2ATable.setValueAt("0", i, 3);
        }
        ML2Total.setText(historiaBprimerTotal2.getText());
        textHistoriaAprimer2.setText("");
        historiaAprimerTotal2.setText("0");
    }//GEN-LAST:event_resetHistoriaA1ActionPerformed

    private void resetHistoriaB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaB1ActionPerformed
        for (int i = 0; i<this.ML2BTable.getRowCount(); i++){
            ML2BTable.setValueAt("0", i, 3);
        }
        textHistoriaBprimer2.setText("");
        historiaBprimerTotal2.setText("0");
        ML2Total.setText(historiaAprimerTotal2.getText());
    }//GEN-LAST:event_resetHistoriaB1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int MLII = calculaMLII(Integer.parseInt(ML2Total.getText()));
        puntuacioML2.setText(MLII+"");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataMl2.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable ML2ATable;
    private org.jdesktop.swingx.JXTable ML2BTable;
    private javax.swing.JPanel ML2Panel2;
    private javax.swing.JPanel ML2Panel4;
    private org.jdesktop.swingx.JXTable ML2RecTableA;
    private org.jdesktop.swingx.JXTable ML2RecTableB;
    private javax.swing.JScrollPane ML2Scroll1;
    private javax.swing.JScrollPane ML2Scroll3;
    private javax.swing.JScrollPane ML2Scroll4;
    private javax.swing.JLabel ML2Total;
    private javax.swing.JPanel MLPanel3;
    private javax.swing.JLabel dataMl2;
    private javax.swing.JLabel historiaAprimerTotal2;
    private javax.swing.JLabel historiaBprimerTotal2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLabel puntuacioML2;
    private javax.swing.JButton resetHistoriaA1;
    private javax.swing.JButton resetHistoriaB1;
    private javax.swing.JTextArea textHistoriaAprimer2;
    private javax.swing.JTextArea textHistoriaBprimer2;
    private javax.swing.JLabel totalRec;
    private javax.swing.JLabel totalRecA;
    private javax.swing.JLabel totalRecB;
    // End of variables declaration//GEN-END:variables
}
