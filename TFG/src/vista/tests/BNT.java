/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.ButtonColumn;
import controlador.Utils;
import controlador.VerticalTableHeaderCellRenderer;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import model.Pacient;
import org.jdesktop.swingx.decorator.HighlighterFactory;
import vista.Sessio1;

/**
 *
 * @author a630703
 */
public class BNT extends Test {

    String edatPacient;
    private HashMap<String, HashMap<Integer, List<Object>>> taulaBNTA;
    private HashMap<String, HashMap<Integer, List<Object>>> taulaBNTB;
    private HashMap<String, HashMap<Integer, List<Object>>> taulaBNTC;

    String valoracio;
    
    /**
     * Creates new form BNT
     * @param pacientActual
     * @param valoracio
     */
    public BNT(Pacient pacientActual, String valoracio) {
        super(pacientActual);
        initComponents();
        
        label = "BNT";
        
        numPaginesTotal = this.getComponentCount();

        this.valoracio = valoracio;

        CardLayout card = (CardLayout)this.getLayout();
        card.show(this, "card"+(valoracio));
        numPaginesTotal = 1;
        
        convertEdat();
        
        initBNTATable();
        initBNTBTable();
        initBNTCTable();
        
        initHashBNTA();
        initHashBNTB();
        initHashBNTC();
    }

    @Override
    public void guardarResultats(Properties prop) {
        if (valoracio.equals("1")){
            // BNT A
            Utils.setProperty(prop,"totalBnt"+valoracio,totalBntA);
            Utils.setProperty(prop,"semanticaBnt"+valoracio,semanticaBntA);
            Utils.setProperty(prop,"percentilBNT"+valoracio,percentilBNTA);
            Utils.setProperty(prop,"nssaBNT"+valoracio,nssaBNTA);
        } else if (valoracio.equals("2")){
            // BNT B
            Utils.setProperty(prop,"totalBnt"+valoracio,totalBntB);
            Utils.setProperty(prop,"semanticaBnt"+valoracio,semanticaBntB);
            Utils.setProperty(prop,"percentilBNT"+valoracio,percentilBNTB);
            Utils.setProperty(prop,"nssaBNT"+valoracio,nssaBNTB);
        } else if (valoracio.equals("3")){
            // BNT C
            Utils.setProperty(prop,"totalBnt"+valoracio,totalBntC);
            Utils.setProperty(prop,"semanticaBnt"+valoracio,semanticaBntC);
            Utils.setProperty(prop,"percentilBNT"+valoracio,percentilBNTC);
            Utils.setProperty(prop,"nssaBNT"+valoracio,nssaBNTC);
        }
    }

    private void initBNTATable() {
        CustomModel model = new CustomModel(
            new Object [][] {
                {"1", "Llit(un moble)","","0","0"},
                {"2", "Escombra (serveix per netejar),","","0","0"},
                {"3", "Banc (serveix per seure)","","0","0"},
                {"4", "Pop (animal marí)","","0","0"},
                {"5", "Bolet (quelcom per menjar)","","0","0"},
                {"6", "Helicòpter (serveix per viatjar per l'aire)","","0","0"},
                {"7", "Corona de flors (dels difuntos)","", "0","0"},
                {"8", "Pinces (utensili)","","0","0"},
                {"9", "Compàs (serveix per dibuixar)","","0","0"},
                {"10", "Magdalena (quelcom per menjar)","","0","0"},
                {"11", "Balda (part d'una porta)","","0","0"},
                {"12", "Canoa (s'utlititza a l'aigua)","","0","0"},
                {"13", "Pelicà (una au)","","0","0"},
                {"14", "Unicorn (animal mític)","","0","0"},
                {"15", "Transportador (serveix per mesurar angles)","","0","0"}
            },
            new String [] {
                "", "<html><b><p style=\"font-size:14px;\"><font color=\"rgb(65,110,160)\">Short Form - Version A","Resposta pacient", " Correctes espontàniament", " Correctes amb ajuda semàntica"
            }
        );
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, true ,true, true
        };

        boolean matrix[][] = new boolean[model.getColumnCount()][model.getRowCount()];

        int j = 0;

        for (boolean[] r: matrix) {
            Arrays.fill(r, canEdit[j]);
            j++;
        }

        model.setCanEdit(canEdit);

        model.setTypes(types);

        model.setCanEditMatrix(matrix);

        model.setCustom(true);


        
        BNTATable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        BNTATable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        BNTATable.getColumn(1).setHeaderRenderer(centerRenderer);
        
        TableCellRenderer headerRenderer = new VerticalTableHeaderCellRenderer();
        for (int i=3; i<BNTATable.getColumnModel().getColumnCount(); i++){
            BNTATable.getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        if (BNTATable.getColumnModel().getColumnCount() > 0) {
            BNTATable.getColumnModel().getColumn(0).setResizable(false);
            BNTATable.getColumnModel().getColumn(1).setResizable(false);
            BNTATable.getColumnModel().getColumn(2).setResizable(false);
            BNTATable.getColumnModel().getColumn(3).setResizable(false);
            BNTATable.getColumnModel().getColumn(4).setResizable(false);
        }
        BNTATable.getTableHeader().setReorderingAllowed(false);
        
        BNTATable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        for (int i = 0; i<BNTATable.getRowCount(); i++){
            BNTATable.setRowHeight(i, 30);
        }
        
        Action action1;
        action1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 3));

                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,3);
                    table.setValueAt("",row,4);
                    model.setEditable(4,row,false);
                } else {
                    table.setValueAt("0",row,3);
                    model.setEditable(4,row,true);
                    table.setValueAt("0",row,4);
                }

                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 3).equals("0") || table.getValueAt(i, 3).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 3));
                    }
                }
                correctesBntA.setText(sumaTotal+"");
                totalBntA.setText(""+(sumaTotal+Integer.parseInt(semanticaBntA.getText())));
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
                
                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,4);
                    table.setValueAt("",row,3);
                    model.setEditable(3,row,false);
                } else {
                    table.setValueAt("0",row,4);
                    model.setEditable(3,row,true);
                    table.setValueAt("0",row,3);
                }
                
                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 4).equals("0") || table.getValueAt(i, 4).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 4));
                    }
                }
                semanticaBntA.setText(sumaTotal+"");
                totalBntA.setText(""+(sumaTotal+Integer.parseInt(correctesBntA.getText())));
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(BNTATable, action1, 3);
        ButtonColumn buttonColumn2 = new ButtonColumn(BNTATable, action2, 4);
        BNTATable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        BNTATable.packAll();
    }

    private void initBNTBTable() {
        CustomModel model = new CustomModel(
            new Object [][] {
                {"1", "Arbre (creix al camp)","","0","0"},
                {"2", "Flor (creix al jardí)","","0","0"},
                {"3", "Xiulet (serveix per bufar)","","0","0"},
                {"4", "Escales mecàniques (serveix per pujar)","","0","0"},
                {"5", "Penjador (es troba en un armari)","","0","0"},
                {"6", "Morrió (s'utilitza pels gossos)","","0","0"},
                {"7", "Volcà (un tipus de muntanya)","", "0","0"},
                {"8", "Gla (prové d'un arbre)","","0","0"},
                {"9", "Cactus (quelcom que creix)","","0","0"},
                {"10", "Arpa (intrument musical)","","0","0"},
                {"11", "Dard (serveix per llançar)","","0","0"},
                {"12", "Soga (per penjar)","","0","0"},
                {"13", "Xanques (s'usen per caminar més alt)","","0","0"},
                {"14", "Esfinx (es troba a Egipte)","","0","0"},
                {"15", "Pèrgola (s'usa al jardí)","","0","0"}
            },
            new String [] {
                "", "<html><b><p style=\"font-size:14px;\"><font color=\"rgb(65,110,160)\">Short Form - Version B", "Resposta pacient" ," Correctes espontàniament", " Correctes amb ajuda semàntica"
            }
        );
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, true, true, true
        };

        boolean matrix[][] = new boolean[model.getColumnCount()][model.getRowCount()];

        int j = 0;

        for (boolean[] r: matrix) {
            Arrays.fill(r, canEdit[j]);
            j++;
        }

        model.setCanEdit(canEdit);

        model.setTypes(types);

        model.setCanEditMatrix(matrix);

        model.setCustom(true);
        
        BNTBTable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        BNTBTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        BNTBTable.getColumn(1).setHeaderRenderer(centerRenderer);
        
        TableCellRenderer headerRenderer = new VerticalTableHeaderCellRenderer();
        for (int i=3; i<BNTBTable.getColumnModel().getColumnCount(); i++){
            BNTBTable.getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        if (BNTBTable.getColumnModel().getColumnCount() > 0) {
            BNTBTable.getColumnModel().getColumn(0).setResizable(false);
            BNTBTable.getColumnModel().getColumn(1).setResizable(false);
            BNTBTable.getColumnModel().getColumn(2).setResizable(false);
            BNTBTable.getColumnModel().getColumn(3).setResizable(false);
            BNTBTable.getColumnModel().getColumn(4).setResizable(false);
        }
        BNTBTable.getTableHeader().setReorderingAllowed(false);
        BNTBTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        for (int i = 0; i<BNTBTable.getRowCount(); i++){
            BNTBTable.setRowHeight(i, 30);
        }
        
        Action action1;
        action1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 3));

                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,3);
                    table.setValueAt("",row,4);
                    model.setEditable(4,row,false);
                } else {
                    table.setValueAt("0",row,3);
                    model.setEditable(4,row,true);
                    table.setValueAt("0",row,4);
                }

                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 3).equals("0") || table.getValueAt(i, 3).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 3));
                    }
                }

                correctesBntB.setText(sumaTotal+"");
                totalBntB.setText(""+(sumaTotal+Integer.parseInt(semanticaBntB.getText())));
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

                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,4);
                    table.setValueAt("",row,3);
                    model.setEditable(3,row,false);
                } else {
                    table.setValueAt("0",row,4);
                    model.setEditable(3,row,true);
                    table.setValueAt("0",row,3);
                }

                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 4).equals("0") || table.getValueAt(i, 4).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 4));
                    }
                }

                semanticaBntB.setText(sumaTotal+"");
                totalBntB.setText(""+(sumaTotal+Integer.parseInt(correctesBntB.getText())));
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(BNTBTable, action1, 3);
        ButtonColumn buttonColumn2 = new ButtonColumn(BNTBTable, action2, 4);
        BNTBTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        BNTBTable.packAll();
    }

    private void initBNTCTable() {
        CustomModel model = new CustomModel(
            new Object [][] {
                {"1", "Casa (tipus d'edifici)","","0","0"},
                {"2", "Respall de dents (s'usa a la boca)","","0","0"},
                {"3", "Cargol (un animal)","","0","0"},
                {"4", "Cadira de rodes (es troba a l'hospital)","","0","0"},
                {"5", "Llapis (serveix per escriure)","","0","0"},
                {"6", "Màscara (part d'una disfressa)","","0","0"},
                {"7", "Acordió (instrument musical)","", "0","0"},
                {"8", "Piràmide (es troba a Egipte)","","0","0"},
                {"9", "Armònica (instrument musical)","","0","0"},
                {"10", "Globus terraqui (un tipus de mapa)","","0","0"},
                {"11", "Trípode (el fan servir els fotògrafs)","","0","0"},
                {"12", "Pergamí (un document)","","0","0"},
                {"13", "Jou (s'utilitza per a animals de tir)","","0","0"},
                {"14", "Estetoscopi (el fan servir els metges)","","0","0"},
                {"15", "Àbac (serveix per comptar)","","0","0"}
            },
            new String [] {
                "", "<html><b><p style=\"font-size:14px;\"><font color=\"rgb(65,110,160)\">Short Form - Version C","Resposta pacient", " Correctes espontàniament", " Correctes amb ajuda semàntica"
            }
        );
        
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, true, true, true
        };

        boolean matrix[][] = new boolean[model.getColumnCount()][model.getRowCount()];

        int j = 0;

        for (boolean[] r: matrix) {
            Arrays.fill(r, canEdit[j]);
            j++;
        }

        model.setCanEdit(canEdit);

        model.setTypes(types);

        model.setCanEditMatrix(matrix);

        model.setCustom(true);
        
        BNTCTable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        BNTCTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        BNTCTable.getColumn(1).setHeaderRenderer(centerRenderer);
        
        TableCellRenderer headerRenderer = new VerticalTableHeaderCellRenderer();
        for (int i=3; i<BNTCTable.getColumnModel().getColumnCount(); i++){
            BNTCTable.getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        if (BNTCTable.getColumnModel().getColumnCount() > 0) {
            BNTCTable.getColumnModel().getColumn(0).setResizable(false);
            BNTCTable.getColumnModel().getColumn(1).setResizable(false);
            BNTCTable.getColumnModel().getColumn(2).setResizable(false);
            BNTCTable.getColumnModel().getColumn(3).setResizable(false);
            BNTCTable.getColumnModel().getColumn(4).setResizable(false);
        }
        BNTCTable.getTableHeader().setReorderingAllowed(false);
        BNTCTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        for (int i = 0; i<BNTCTable.getRowCount(); i++){
            BNTCTable.setRowHeight(i, 30);
        }
        
        Action action1;
        action1 = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 3));

                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,3);
                    table.setValueAt("",row,4);
                    model.setEditable(4,row,false);
                } else {
                    table.setValueAt("0",row,3);
                    model.setEditable(4,row,true);
                    table.setValueAt("0",row,4);
                }

                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 3).equals("0") || table.getValueAt(i, 3).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 3));
                    }
                }

                correctesBntC.setText(sumaTotal+"");
                totalBntC.setText(""+(sumaTotal+Integer.parseInt(semanticaBntC.getText())));
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

                CustomModel model = (CustomModel)table.getModel();

                if (val == 0){
                    table.setValueAt("1",row,4);
                    table.setValueAt("",row,3);
                    model.setEditable(3,row,false);
                } else {
                    table.setValueAt("0",row,4);
                    model.setEditable(3,row,true);
                    table.setValueAt("0",row,3);
                }

                int sumaTotal = 0;
                for (int i = 0; i<table.getRowCount(); i++){
                    if (table.getValueAt(i, 4).equals("0") || table.getValueAt(i, 4).equals("1")) {
                        sumaTotal += Integer.parseInt((String) table.getValueAt(i, 4));
                    }
                }

                semanticaBntC.setText(sumaTotal+"");
                totalBntC.setText(""+(sumaTotal+Integer.parseInt(correctesBntC.getText())));
            }
        };
        
        ButtonColumn buttonColumn = new ButtonColumn(BNTCTable, action1, 3);
        ButtonColumn buttonColumn2 = new ButtonColumn(BNTCTable, action2, 4);
        BNTCTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        BNTCTable.packAll();
    }
    
    private void initHashBNTA() {
        
        taulaBNTA = new HashMap<>();
        List<Object> auxList;
        HashMap<Integer, List<Object>> auxMap = new HashMap<>();
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(0, auxList);
        auxMap.put(1, auxList);
        auxMap.put(2, auxList);
        auxMap.put(3, auxList);
        auxMap.put(4, auxList);
        auxMap.put(5, auxList);
        auxMap.put(6, auxList);
        auxMap.put(7, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(14, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(15, auxList);
        taulaBNTA.put("50-56", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(14, auxList);
        taulaBNTA.put("57-59", new HashMap(auxMap));
        
        taulaBNTA.put("60-62", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(7, auxList);
        taulaBNTA.put("63-65", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(14, auxList);
        taulaBNTA.put("66-68", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(9, auxList);
        taulaBNTA.put("69-71", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(11, auxList);
        taulaBNTA.put("72-74", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTA.put("75-77", new HashMap(auxMap));
        
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(17, "99");
        auxMap.put(14, auxList);
        taulaBNTA.put("78-80", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTA.put("81+", new HashMap(auxMap));
        
    }
    
    private void convertEdat(){
        int edatP = pacientActual.getEdat();
        String edat = "";
        if (edatP<=56){
            edat = "50-56";
        }
        else if (edatP>=57 && edatP<=59){
            edat = "57-59";
        }
        else if (edatP>=60 && edatP<=62){
            edat = "60-62";
        }
        else if (edatP>=63 && edatP<=65){
            edat = "63-65";
        }
        else if (edatP>=66 && edatP<=68){
            edat = "66-68";
        }
        else if (edatP>=69 && edatP<=71){
            edat = "69-71";
        }
        else if (edatP>=72 && edatP<=74){
            edat = "72-74";
        }
        else if (edatP>=75 && edatP<=77){
            edat = "75-77";
        }
        else if (edatP>=78 && edatP<=80){
            edat = "78-80";
        }
        else if (edatP>=81){
            edat = "81+";
        }
        edatPacient =  edat;
    }
    
    private void calcularBNTA() {
        List<Object> list;
        System.out.println(Integer.parseInt(totalBntA.getText()));
        System.out.println(edatPacient);
        list = taulaBNTA.get(edatPacient).get(Integer.parseInt(totalBntA.getText()));
        percentilBNTA.setText((String) list.get(1));
        
        int scaledScore = (int) list.get(0);
        
        int anysEscola = pacientActual.getAnysEscola();
        int modificador = 0;
        
        if (anysEscola == 0){
            modificador = 3;
        }
        else if (anysEscola >=1 && anysEscola <=4){
            modificador = 2;
        }
        else if (anysEscola >=5 && anysEscola <=8){
            modificador = 1;
        }
        else if (anysEscola >=9 && anysEscola <=12){
            modificador = 0;
        }
        else if (anysEscola >=13 && anysEscola <=15){
            modificador = -1;
        }
        else if (anysEscola >=16 && anysEscola <=19){
            modificador = -2;
        }
        else if (anysEscola == 20){
            modificador = -3;
        }
        
        nssaBNTA.setText(scaledScore+modificador+"");
    }

    private void initHashBNTB() {
        taulaBNTB = new HashMap<>();
        List<Object> auxList;
        HashMap<Integer, List<Object>> auxMap = new HashMap<>();
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(0, auxList);
        auxMap.put(1, auxList);
        auxMap.put(2, auxList);
        auxMap.put(3, auxList);
        auxMap.put(4, auxList);
        auxMap.put(5, auxList);
        auxMap.put(6, auxList);
        auxMap.put(7, auxList);
        auxList = Arrays.asList(3, "1");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(14, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(15, auxList);
        taulaBNTB.put("50-56", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(10, auxList);
        taulaBNTB.put("57-59", new HashMap(auxMap));
        
        taulaBNTB.put("60-62", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTB.put("63-65", new HashMap(auxMap));
        
        taulaBNTB.put("66-68", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(14, auxList);
        taulaBNTB.put("69-71", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTB.put("72-74", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(9, auxList);
        taulaBNTB.put("75-77", new HashMap(auxMap));
        
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(17, "99");
        auxMap.put(14, auxList);
        taulaBNTB.put("78-80", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTB.put("81+", new HashMap(auxMap));
    }
    
    private void calcularBNTB() {
        List<Object> list;
        System.out.println(Integer.parseInt(totalBntB.getText()));
        System.out.println(edatPacient);
        list = taulaBNTB.get(edatPacient).get(Integer.parseInt(totalBntB.getText()));
        percentilBNTB.setText((String) list.get(1));
        
        int scaledScore = (int) list.get(0);
        
        int anysEscola = pacientActual.getAnysEscola();
        int modificador = 0;
        
        if (anysEscola == 0){
            modificador = 0;
        }
        else if (anysEscola == 1){
            modificador = 3;
        }
        else if (anysEscola >=2 && anysEscola <=4){
            modificador = 2;
        }
        else if (anysEscola >=6 && anysEscola <=9){
            modificador = 1;
        }
        else if (anysEscola >=10 && anysEscola <=13){
            modificador = 0;
        }
        else if (anysEscola >=14 && anysEscola <=16){
            modificador = -1;
        }
        else if (anysEscola >=16 && anysEscola <=20){
            modificador = -2;
        }
        
        nssaBNTB.setText(scaledScore+modificador+"");
    }

    private void initHashBNTC() {
        taulaBNTC = new HashMap<>();
        List<Object> auxList;
        HashMap<Integer, List<Object>> auxMap = new HashMap<>();
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(0, auxList);
        auxMap.put(1, auxList);
        auxMap.put(2, auxList);
        auxMap.put(3, auxList);
        auxMap.put(4, auxList);
        auxMap.put(5, auxList);
        auxMap.put(6, auxList);
        auxMap.put(7, auxList);
        auxMap.put(8, auxList);
        auxMap.put(9, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(14, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(15, auxList);
        taulaBNTC.put("50-56", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(13, auxList);
        taulaBNTC.put("57-59", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(10, auxList);
        taulaBNTC.put("60-62", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(14, auxList);
        taulaBNTC.put("63-65", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(14, auxList);
        taulaBNTC.put("66-68", new HashMap(auxMap));
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(4, "2");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(11, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(13, auxList);
        taulaBNTC.put("69-71", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(14, auxList);
        taulaBNTC.put("72-74", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(8, auxList);
        taulaBNTC.put("75-77", new HashMap(auxMap));
        
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(9, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(10, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(12, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(14, auxList);
        taulaBNTC.put("78-80", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(13, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(14, auxList);
        taulaBNTC.put("81+", new HashMap(auxMap));
    }
    
    private void calcularBNTC() {
        List<Object> list;
        System.out.println(Integer.parseInt(totalBntC.getText()));
        System.out.println(edatPacient);
        list = taulaBNTC.get(edatPacient).get(Integer.parseInt(totalBntC.getText()));
        percentilBNTC.setText((String) list.get(1));
        
        int scaledScore = (int) list.get(0);
        
        int anysEscola = pacientActual.getAnysEscola();
        int modificador = 0;
        
        if (anysEscola == 0){
            modificador = 4;
        }
        else if (anysEscola >=1 && anysEscola <=3){
            modificador = 3;
        }
        else if (anysEscola >=4 && anysEscola <=6){
            modificador = 2;
        }
        else if (anysEscola >=7 && anysEscola <=9){
            modificador = 1;
        }
        else if (anysEscola >=10 && anysEscola <=12){
            modificador = 0;
        }
        else if (anysEscola >=13 && anysEscola <=14){
            modificador = -1;
        }
        else if (anysEscola >=15 && anysEscola <=17){
            modificador = -2;
        }
        else if (anysEscola >=18 && anysEscola <=20){
            modificador = -3;
        }
        
        nssaBNTC.setText(scaledScore+modificador+"");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BNTScroll6 = new javax.swing.JScrollPane();
        MLPanel5 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        BNTBTable = new org.jdesktop.swingx.JXTable();
        jLabel63 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        resetHistoriaB3 = new javax.swing.JButton();
        jLabel69 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        percentilBNTB = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        nssaBNTB = new javax.swing.JLabel();
        semanticaBntB = new javax.swing.JLabel();
        correctesBntB = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        totalBntB = new javax.swing.JLabel();
        dataBnt2 = new javax.swing.JLabel();
        BNTjButton21 = new javax.swing.JButton();
        BNTScroll7 = new javax.swing.JScrollPane();
        MLPanel6 = new javax.swing.JPanel();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        BNTCTable = new org.jdesktop.swingx.JXTable();
        jLabel64 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        resetHistoriaB4 = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        semanticaBntC = new javax.swing.JLabel();
        correctesBntC = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        totalBntC = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel83 = new javax.swing.JLabel();
        percentilBNTC = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        nssaBNTC = new javax.swing.JLabel();
        dataBnt3 = new javax.swing.JLabel();
        BNTjButton22 = new javax.swing.JButton();
        BNTScroll5 = new javax.swing.JScrollPane();
        MLPanel4 = new javax.swing.JPanel();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        BNTATable = new org.jdesktop.swingx.JXTable();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        resetHistoriaB2 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        semanticaBntA = new javax.swing.JLabel();
        correctesBntA = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        totalBntA = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        percentilBNTA = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        nssaBNTA = new javax.swing.JLabel();
        dataBnt1 = new javax.swing.JLabel();
        BNTjButton23 = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jLabel112.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel112.setText("<html><center><b>BOSTON NAMING TEST\t\t\t </b>");

        BNTBTable.setModel(new javax.swing.table.DefaultTableModel(
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
        BNTBTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        BNTBTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BNTBTable.setRowSelectionAllowed(false);
        BNTBTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        BNTBTable.setSortable(false);
        BNTBTable.setSortsOnUpdates(false);
        jScrollPane17.setViewportView(BNTBTable);

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(65, 110, 160));
        jLabel63.setText("Correctes:");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(65, 110, 160));
        jLabel66.setText("Ajuda semàntica:");

        resetHistoriaB3.setText("Reset");
        resetHistoriaB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaB3ActionPerformed(evt);
            }
        });

        jLabel69.setText("(max. 15)");

        jLabel72.setText("(max. 15)");

        jPanel5.setBackground(new java.awt.Color(250, 150, 70));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton4.setText("Calcular");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel73.setText("<html>Percentil<br>range:");

        percentilBNTB.setBackground(new java.awt.Color(255, 255, 255));
        percentilBNTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentilBNTB.setText("0");
        percentilBNTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        percentilBNTB.setOpaque(true);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel80.setText("<html>NSSA<br>NEURONORMA<br>Scaled Score<br>age-adjusted");

        nssaBNTB.setBackground(new java.awt.Color(255, 255, 255));
        nssaBNTB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nssaBNTB.setText("0");
        nssaBNTB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nssaBNTB.setOpaque(true);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(22, 22, 22)
                .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentilBNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nssaBNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(percentilBNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nssaBNTB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        semanticaBntB.setBackground(new java.awt.Color(255, 255, 255));
        semanticaBntB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        semanticaBntB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semanticaBntB.setText("0");
        semanticaBntB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        semanticaBntB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        semanticaBntB.setOpaque(true);

        correctesBntB.setBackground(new java.awt.Color(255, 255, 255));
        correctesBntB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        correctesBntB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctesBntB.setText("0");
        correctesBntB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        correctesBntB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        correctesBntB.setOpaque(true);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(65, 110, 160));
        jLabel74.setText("TOTAL:");

        totalBntB.setBackground(new java.awt.Color(255, 255, 255));
        totalBntB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalBntB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBntB.setText("0");
        totalBntB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalBntB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        totalBntB.setOpaque(true);

        BNTjButton21.setText("Veure Taula");
        BNTjButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNTjButton21ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MLPanel5Layout = new javax.swing.GroupLayout(MLPanel5);
        MLPanel5.setLayout(MLPanel5Layout);
        MLPanel5Layout.setHorizontalGroup(
            MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MLPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel66)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semanticaBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel72))
                            .addComponent(resetHistoriaB3)
                            .addGroup(MLPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel63)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(correctesBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel69))
                            .addGroup(MLPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel74)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataBnt2)
                            .addComponent(BNTjButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        MLPanel5Layout.setVerticalGroup(
            MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel5Layout.createSequentialGroup()
                        .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(jLabel69)
                            .addComponent(correctesBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(semanticaBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel72))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel74)
                            .addComponent(totalBntB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(resetHistoriaB3)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BNTjButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataBnt2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE))
                .addContainerGap())
        );

        BNTScroll6.setViewportView(MLPanel5);

        add(BNTScroll6, "card2");

        jLabel114.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel114.setText("<html><center><b>BOSTON NAMING TEST\t\t\t </b>");

        BNTCTable.setModel(new javax.swing.table.DefaultTableModel(
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
        BNTCTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        BNTCTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BNTCTable.setRowSelectionAllowed(false);
        BNTCTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        BNTCTable.setSortable(false);
        BNTCTable.setSortsOnUpdates(false);
        jScrollPane18.setViewportView(BNTCTable);

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(65, 110, 160));
        jLabel64.setText("Correctes:");

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(65, 110, 160));
        jLabel75.setText("Ajuda semàntica:");

        resetHistoriaB4.setText("Reset");
        resetHistoriaB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaB4ActionPerformed(evt);
            }
        });

        jLabel76.setText("(max. 15)");

        jLabel77.setText("(max. 15)");

        semanticaBntC.setBackground(new java.awt.Color(255, 255, 255));
        semanticaBntC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        semanticaBntC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semanticaBntC.setText("0");
        semanticaBntC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        semanticaBntC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        semanticaBntC.setOpaque(true);

        correctesBntC.setBackground(new java.awt.Color(255, 255, 255));
        correctesBntC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        correctesBntC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctesBntC.setText("0");
        correctesBntC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        correctesBntC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        correctesBntC.setOpaque(true);

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(65, 110, 160));
        jLabel79.setText("TOTAL:");

        totalBntC.setBackground(new java.awt.Color(255, 255, 255));
        totalBntC.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalBntC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBntC.setText("0");
        totalBntC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalBntC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        totalBntC.setOpaque(true);

        jPanel8.setBackground(new java.awt.Color(250, 150, 70));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Calcular");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel83.setText("<html>Percentil<br>range:");

        percentilBNTC.setBackground(new java.awt.Color(255, 255, 255));
        percentilBNTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentilBNTC.setText("0");
        percentilBNTC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        percentilBNTC.setOpaque(true);

        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel84.setText("<html>NSSA<br>NEURONORMA<br>Scaled Score<br>age-adjusted");

        nssaBNTC.setBackground(new java.awt.Color(255, 255, 255));
        nssaBNTC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nssaBNTC.setText("0");
        nssaBNTC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nssaBNTC.setOpaque(true);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addGap(22, 22, 22)
                .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentilBNTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nssaBNTC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(percentilBNTC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nssaBNTC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        BNTjButton22.setText("Veure Taula");
        BNTjButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNTjButton22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MLPanel6Layout = new javax.swing.GroupLayout(MLPanel6);
        MLPanel6.setLayout(MLPanel6Layout);
        MLPanel6Layout.setHorizontalGroup(
            MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MLPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel75)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semanticaBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel77))
                            .addComponent(resetHistoriaB4)
                            .addGroup(MLPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel64)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(correctesBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel76))
                            .addGroup(MLPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel79)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataBnt3)
                            .addComponent(BNTjButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        MLPanel6Layout.setVerticalGroup(
            MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel6Layout.createSequentialGroup()
                        .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(jLabel76)
                            .addComponent(correctesBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(semanticaBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel77))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel79)
                            .addComponent(totalBntC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(resetHistoriaB4)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BNTjButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(dataBnt3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE))
                .addContainerGap())
        );

        BNTScroll7.setViewportView(MLPanel6);

        add(BNTScroll7, "card3");

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("<html><center><b>BOSTON NAMING TEST\t\t\t </b>");

        BNTATable.setModel(new javax.swing.table.DefaultTableModel(
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
        BNTATable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        BNTATable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BNTATable.setRowSelectionAllowed(false);
        BNTATable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        BNTATable.setSortable(false);
        BNTATable.setSortsOnUpdates(false);
        jScrollPane16.setViewportView(BNTATable);

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(65, 110, 160));
        jLabel62.setText("Correctes:");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(65, 110, 160));
        jLabel65.setText("Ajuda semàntica:");

        resetHistoriaB2.setText("Reset");
        resetHistoriaB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetHistoriaB2ActionPerformed(evt);
            }
        });

        jLabel67.setText("(max. 15)");

        jLabel68.setText("(max. 15)");

        semanticaBntA.setBackground(new java.awt.Color(255, 255, 255));
        semanticaBntA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        semanticaBntA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        semanticaBntA.setText("0");
        semanticaBntA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        semanticaBntA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        semanticaBntA.setOpaque(true);

        correctesBntA.setBackground(new java.awt.Color(255, 255, 255));
        correctesBntA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        correctesBntA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        correctesBntA.setText("0");
        correctesBntA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        correctesBntA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        correctesBntA.setOpaque(true);

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(65, 110, 160));
        jLabel71.setText("TOTAL:");

        totalBntA.setBackground(new java.awt.Color(255, 255, 255));
        totalBntA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totalBntA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalBntA.setText("0");
        totalBntA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        totalBntA.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        totalBntA.setOpaque(true);

        jPanel7.setBackground(new java.awt.Color(250, 150, 70));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton6.setText("Calcular");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel81.setText("<html>Percentil<br>range:");

        percentilBNTA.setBackground(new java.awt.Color(255, 255, 255));
        percentilBNTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentilBNTA.setText("0");
        percentilBNTA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        percentilBNTA.setOpaque(true);

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel82.setText("<html>NSSA<br>NEURONORMA<br>Scaled Score<br>age-adjusted");

        nssaBNTA.setBackground(new java.awt.Color(255, 255, 255));
        nssaBNTA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nssaBNTA.setText("0");
        nssaBNTA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nssaBNTA.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addGap(22, 22, 22)
                .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentilBNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nssaBNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(percentilBNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nssaBNTA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        BNTjButton23.setText("Veure Taula");
        BNTjButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNTjButton23ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MLPanel4Layout = new javax.swing.GroupLayout(MLPanel4);
        MLPanel4.setLayout(MLPanel4Layout);
        MLPanel4Layout.setHorizontalGroup(
            MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MLPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel65)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semanticaBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel68))
                            .addComponent(resetHistoriaB2)
                            .addGroup(MLPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel62)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(correctesBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel67))
                            .addGroup(MLPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel71)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataBnt1)
                            .addComponent(BNTjButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        MLPanel4Layout.setVerticalGroup(
            MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MLPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MLPanel4Layout.createSequentialGroup()
                        .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel62)
                            .addComponent(jLabel67)
                            .addComponent(correctesBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(semanticaBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel68))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MLPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel71)
                            .addComponent(totalBntA, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(resetHistoriaB2)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BNTjButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataBnt1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE))
                .addContainerGap())
        );

        BNTScroll5.setViewportView(MLPanel4);

        add(BNTScroll5, "card1");
    }// </editor-fold>//GEN-END:initComponents

    private void resetHistoriaB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaB2ActionPerformed
        for (int i = 0; i<this.BNTATable.getRowCount(); i++){
            BNTATable.setValueAt("0", i, 2);
            BNTATable.setValueAt("0", i, 3);
        }
        percentilBNTA.setText("0");
        nssaBNTA.setText("0");
        this.correctesBntA.setText("0");
        this.semanticaBntA.setText("0");
        this.totalBntA.setText("0");
    }//GEN-LAST:event_resetHistoriaB2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        calcularBNTA();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataBnt1.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void resetHistoriaB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaB3ActionPerformed
        for (int i = 0; i<this.BNTBTable.getRowCount(); i++){
            BNTBTable.setValueAt("0", i, 2);
            BNTBTable.setValueAt("0", i, 3);
        }
        percentilBNTB.setText("0");
        nssaBNTB.setText("0");
        this.correctesBntB.setText("0");
        this.semanticaBntB.setText("0");
        this.totalBntB.setText("0");
    }//GEN-LAST:event_resetHistoriaB3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        calcularBNTB();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataBnt2.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void resetHistoriaB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetHistoriaB4ActionPerformed
        for (int i = 0; i<this.BNTCTable.getRowCount(); i++){
            BNTCTable.setValueAt("0", i, 2);
            BNTCTable.setValueAt("0", i, 3);
        }
        percentilBNTC.setText("0");
        nssaBNTC.setText("0");
        this.correctesBntC.setText("0");
        this.semanticaBntC.setText("0");
        this.totalBntC.setText("0");
    }//GEN-LAST:event_resetHistoriaB4ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        calcularBNTC();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataBnt3.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void BNTjButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNTjButton21ActionPerformed
        File file = new File(Utils.RES_PATH+"taulaBNT.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BNTjButton21ActionPerformed

    private void BNTjButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNTjButton22ActionPerformed
            File file = new File(Utils.RES_PATH+"taulaBNT.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BNTjButton22ActionPerformed

    private void BNTjButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNTjButton23ActionPerformed
            File file = new File(Utils.RES_PATH+"taulaBNT.pdf");
        if (file.exists()){
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(Sessio1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_BNTjButton23ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXTable BNTATable;
    private org.jdesktop.swingx.JXTable BNTBTable;
    private org.jdesktop.swingx.JXTable BNTCTable;
    private javax.swing.JScrollPane BNTScroll5;
    private javax.swing.JScrollPane BNTScroll6;
    private javax.swing.JScrollPane BNTScroll7;
    private javax.swing.JButton BNTjButton21;
    private javax.swing.JButton BNTjButton22;
    private javax.swing.JButton BNTjButton23;
    private javax.swing.JPanel MLPanel4;
    private javax.swing.JPanel MLPanel5;
    private javax.swing.JPanel MLPanel6;
    private javax.swing.JLabel correctesBntA;
    private javax.swing.JLabel correctesBntB;
    private javax.swing.JLabel correctesBntC;
    private javax.swing.JLabel dataBnt1;
    private javax.swing.JLabel dataBnt2;
    private javax.swing.JLabel dataBnt3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JLabel nssaBNTA;
    private javax.swing.JLabel nssaBNTB;
    private javax.swing.JLabel nssaBNTC;
    private javax.swing.JLabel percentilBNTA;
    private javax.swing.JLabel percentilBNTB;
    private javax.swing.JLabel percentilBNTC;
    private javax.swing.JButton resetHistoriaB2;
    private javax.swing.JButton resetHistoriaB3;
    private javax.swing.JButton resetHistoriaB4;
    private javax.swing.JLabel semanticaBntA;
    private javax.swing.JLabel semanticaBntB;
    private javax.swing.JLabel semanticaBntC;
    private javax.swing.JLabel totalBntA;
    private javax.swing.JLabel totalBntB;
    private javax.swing.JLabel totalBntC;
    // End of variables declaration//GEN-END:variables
}
