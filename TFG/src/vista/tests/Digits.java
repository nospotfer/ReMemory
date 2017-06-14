/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import controlador.ButtonColumn;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import controlador.Utils;
import model.Pacient;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 * @author a630703
 */
public class Digits extends Test {

   
    private HashMap<String, HashMap<Integer, List<Object>>> taulaDigitsDD;
    private HashMap<String, HashMap<Integer, List<Object>>> taulaDigitsDI;
    
    /**
     * Creates new form Digits
     * @param pacientActual
     */
    public Digits(Pacient pacientActual) {
        super(pacientActual);
        initComponents();
        
        this.label = "DIGITS";
        
        numPaginesTotal = this.getComponentCount();
        
        initDigitsDirecteTable();
        initDigitsInversTable();
        
        initHashDD();
        initHashDI();
    }

    @Override
    public void guardarResultats(Properties prop){
        // Digits directe
        Utils.setProperty(prop,"puntuacioDirectaDD",puntuacioDirectaDD);
        Utils.setProperty(prop,"spanDD",spanDD);
        Utils.setProperty(prop,"nssaDD",nssaDD);
        Utils.setProperty(prop,"percentilDD",percentilDD);
        // Digits invers
        Utils.setProperty(prop,"puntuacioDirectaDI",puntuacioDirectaDI);
        Utils.setProperty(prop,"spanDI",spanDI);
        Utils.setProperty(prop,"nssaDI",nssaDI);
        Utils.setProperty(prop,"percentilDI",percentilDI);
    }
    
    private void initDigitsDirecteTable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
            new Object [][] {
                {"1", "9 - 7			 ", null, "0", null},
                {null, "6 - 3", null, "0", "0"},
                {"2", "5 - 8 - 2			 ", null, "0", null},
                {null, "6 - 9 - 4			 ", null, "0", "0"},
                {"3", "7 - 2 - 8 - 6			 ", null, "0", null},
                {null, "6 - 4 - 3 - 9			 ", null, "0", "0"},
                {"4", "4 - 2 - 7 - 3 - 1			 ", null, "0", null},
                {null, "7 - 5 - 8 - 3 - 6			 ", null, "0", "0"},
                {"5", "3 - 9 - 2 - 4 - 8 - 7			 ", null, "0", null},
                {null, "6 - 1 - 9 - 7 - 4 - 2			 ", null, "0", "0"},
                {"6", "4 - 1 - 7 - 9 - 3 - 8 - 6			 ", null, "0", null},
                {null, "6 - 9 - 1 - 7 - 4 - 2 - 8			 ", null, "0", "0"},
                {"7", "3 - 8 - 2 - 9 - 6 - 1 - 7 - 4			 ", null, "0", null},
                {null, "5 - 8 - 1 - 3 - 2 - 6 - 4 - 7			 ", null, "0", "0"},
                {"8", "2 - 7 - 5 - 8 - 6 - 3 - 1 - 9 - 4			 ", null, "0", null},
                {null, "7 - 1 - 3 - 9 - 4 - 2 - 5 - 6 - 8			 ", null, "0", "0"}
            },
            new String [] {
                header+"Ítem", header+"Intent", header+"Resposta", header+"<center>Puntuació intent<br>(0-1)", header+"Puntuació ítem"
            }
        );
        
        
//        boolean colors[][] = new boolean[digitsDirecteTable.getRowCount()][digitsDirecteTable.getColumnCount()];
//        for (boolean[] r: colors)
//            Arrays.fill(r, false);

        //editModel model = new editModel(digitsDirecteTable.getRowCount(),digitsDirecteTable.getColumnCount());
        digitsDirecteTable.setModel(model);
        
        //DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        //centerRenderer.setHorizontalAlignment( JLabel.CENTER );

        
        digitsDirecteTable.getColumnModel().getColumn(4).setCellRenderer( new CustomRenderer(true) );
        digitsDirecteTable.getColumnModel().getColumn(0).setCellRenderer( new CustomRenderer(true) );
        digitsDirecteTable.getColumnModel().getColumn(2).setCellRenderer( new CustomRenderer(true) );
        
        for (int i=0; i<digitsDirecteTable.getColumnModel().getColumnCount();i++){
            digitsDirecteTable.getColumnModel().getColumn(i).setResizable(false);
            digitsDirecteTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }
        
        digitsDirecteTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        digitsDirecteTable.getTableHeader().setReorderingAllowed(false);
        
        
        
        
        
        for (int i = 0; i<digitsDirecteTable.getRowCount(); i++){
            digitsDirecteTable.setRowHeight(i, 30);
        }
        
        Action action;
        action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int num0 = 0;
                int num1 = 0;
                
                int sumaAnteriors = 1;
                
                if (row > 1){
                    //TODO Add verifiction for "1001" here
                    sumaAnteriors = 0;
                    sumaAnteriors+=Integer.parseInt((String)table.getValueAt(row-1,3));
                    sumaAnteriors+=Integer.parseInt((String)table.getValueAt(row-2,3));
                }
                
                if (row != 0){
                    for (int i = 0; i < row; i++){
                        if (table.getValueAt(i,3).equals("0")) num0++;
                    }
                }
                for (int j = row+1; j < table.getRowCount(); j++){
                    if (table.getValueAt(j,3).equals("1")) num1++;
                }
                int val = Integer.parseInt((String)table.getValueAt(row, 3));
                    if (num1 < 1) {
                    //TODO Fix this IF if verifiction for "1001" is added
                    //if (sumaAnteriors > 0 && num1 < 1) {
                    if (val == 0) {
                        table.setValueAt("1", row, 3);
                        table.setValueAt(table.getValueAt(row, 1), row, 2);
                    } else {
                        table.setValueAt("0", row, 3);
                        table.setValueAt("", row, 2);
                    }
                }
                
                
                
                int sumaTotal = 0;
                int suma = 0;
                int span = 0;
                
                model.setEditable(4,true);
                for (int i = 0; i<table.getRowCount(); i++){
                    sumaTotal += Integer.parseInt((String)table.getValueAt(i, 3));
                    if (i%2 == 1){
                        suma = Integer.parseInt((String)table.getValueAt(i, 3))+Integer.parseInt((String)table.getValueAt(i-1, 3));
                        table.setValueAt(suma+"", i, 4);
                    }
                }
                model.setEditable(4,false);
                if (sumaAnteriors > 0 && num1 < 1){
                    puntuacioDirectaDD.setText(sumaTotal+"");
                    sumaTotal+=num0;
                    span = sumaTotal%2==0 ? sumaTotal/2 : sumaTotal/2+1;
                    spanDD.setText(span+"");
                }
            }
        };
        
        resetDD.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            for (int i = 0; i<digitsDirecteTable.getRowCount(); i++){
            digitsDirecteTable.setValueAt("", i, 2);
            digitsDirecteTable.setValueAt("0", i, 3);
                if (i%2 == 1){
                    model.setEditable(4,true);
                    digitsDirecteTable.setValueAt("0", i, 4);
                    model.setEditable(4,false);
                }
            }
            spanDD.setText("0");
            puntuacioDirectaDD.setText("0");
            percentilDD.setText("0");
            nssaDD.setText("0");
          }
        });
        
        
        
        ButtonColumn buttonColumn = new ButtonColumn(digitsDirecteTable, action, 3);
        digitsDirecteTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        digitsDirecteTable.packAll();
        digitsDirecteTable.getColumn(2).setPreferredWidth(300);
    }
    
    
    private void initDigitsInversTable() {
        String header = "<html><font color=\"rgb(255,255,255)\">";
        CustomModel model = new CustomModel(
        new Object [][] {
            {"1", "3 - 1","1 - 3", null, "0", null},
            {null, "2 - 4","4 - 2", null, "0", "0"},
            {"2", "4 - 6","6 - 4", null, "0", null},
            {null, "5 - 7","7 - 5", null, "0", "0"},
            {"3", "6 - 2 - 9", "9 - 2 - 6", null, "0", null},
            {null, "4 - 7 - 5", "5 - 7 - 4", null, "0", "0"},
            {"4", "8 - 2 - 7 - 9", "9 - 7 - 2 - 8", null, "0", null},
            {null, "4 - 9 - 6 - 8", "8 - 6 - 9 - 4", null, "0", "0"},
            {"5", "6 - 5 - 8 - 4 - 3", "3 - 4 - 8 - 5 - 6", null, "0", null},
            {null, "1 - 5 - 4 - 8 - 6", "6 - 8 - 4 - 5 - 1", null, "0", "0"},
            {"6", "5 - 3 - 7 - 4 - 1 - 8", "8 - 1 - 4 - 7 - 3 - 5", null, "0", null},
            {null, "7 - 2 - 4 - 8 - 5 - 6", "6 - 5 - 8 - 4 - 2 - 7", null, "0", "0"},
            {"7", "8 - 1 - 4 - 9 - 3 - 6 - 2", "2 - 6 - 3 - 9 - 4 - 1 - 8", null, "0", null},
            {null, "4 - 7 - 3 - 9 - 6 - 2 - 8", "8 - 2 - 6 - 9 - 3 - 7 - 4", null, "0", "0"},
            {"8", "9 - 4 - 3 - 7 - 6 - 2 - 1 - 8", "8 - 1 - 2 - 6 - 7 - 3 - 4 - 9", null, "0", null},
            {null, "7 - 2 - 8 - 1 - 5 - 6 - 4 - 3", "3 - 4 - 6 - 5 - 1 - 8 - 2 - 7", null, "0", "0"}
        },
        new String [] {
            header+"Ítem", header+"Intent", header+"Resposta correcta", header+"Resposta", header+"<center>Puntuació intent<br>(0-1)", header+"Puntuació ítem"
        }
    );
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class
        };
        boolean[] canEdit = new boolean [] {
            false, false, false, true, true, false
        };
        
        model.setTypes(types);
        model.setCanEdit(canEdit);
        
        digitsInversTable.setModel(model);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        digitsInversTable.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
        digitsInversTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        digitsInversTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        
        for (int i=0; i<digitsInversTable.getColumnModel().getColumnCount();i++){
            digitsInversTable.getColumnModel().getColumn(i).setResizable(false);
            digitsInversTable.getColumn(i).setHeaderRenderer(new CustomRenderer(new Color(190,80,80),true));
        }
        
        digitsInversTable.setHighlighters(HighlighterFactory.createSimpleStriping());
        
        digitsInversTable.getTableHeader().setReorderingAllowed(false);
        
        for (int i = 0; i<digitsInversTable.getRowCount(); i++){
            digitsInversTable.setRowHeight(i, 30);
        }
        
        Action action;
        action = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                model.setEditable(5,true);
                model.setEditable(4,true);
                JTable table = (JTable)e.getSource();
                int row = Integer.parseInt(e.getActionCommand());
                int val = Integer.parseInt((String)table.getValueAt(row, 4));

                int sumaAnteriors = 1;
                
                if (row > 1){
                    //TODO Add verifiction for "1001" here
                    sumaAnteriors = 0;
                    sumaAnteriors+=Integer.parseInt((String)table.getValueAt(row-1,4));
                    sumaAnteriors+=Integer.parseInt((String)table.getValueAt(row-2,4));
                }
                
                int num0 = 0;
                int num1 = 0;
                if (row != 0){
                    for (int i = 0; i < row; i++){
                        if (table.getValueAt(i,4).equals("0")) num0++;
                    }
                }
                for (int j = row+1; j < table.getRowCount(); j++){
                    if (table.getValueAt(j,4).equals("1")) num1++;
                }
                if (num1 < 1) {
                //TODO Fix this IF if verifiction for "1001" is added
                //if (sumaAnteriors > 0 && num1 < 1) {
                    if (val == 0) {
                        table.setValueAt("1", row, 4);
                        table.setValueAt(table.getValueAt(row, 2), row, 3);
                    } else {
                        table.setValueAt("0", row, 4);
                        table.setValueAt("", row, 3);
                    }
                }

                int sumaTotal = 0;
                int suma = 0;
                int span = 0;
                
                for (int i = 0; i<table.getRowCount(); i++){
                    sumaTotal += Integer.parseInt((String)table.getValueAt(i, 4));
                    if (i%2 == 1){
                        suma = Integer.parseInt((String)table.getValueAt(i, 4))+Integer.parseInt((String)table.getValueAt(i-1, 4));
                        table.setValueAt(suma+"", i, 5);
                        table.setRowHeight(i, 30);
                    }
                }
                model.setEditable(5,false);
                if (sumaAnteriors > 0 && num1 < 1){
                    sumaTotal+=num0;
                    puntuacioDirectaDI.setText(sumaTotal+"");
                    span = sumaTotal%2==0 ? sumaTotal/2 : sumaTotal/2+1;
                    spanDI.setText(span+"");
                    puntuacioDirectaDI.setText(sumaTotal+"");
                }
            }
        };
        
        resetDI.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
            for (int i = 0; i<digitsInversTable.getRowCount(); i++){
            digitsInversTable.setValueAt("", i, 3);
            digitsInversTable.setValueAt("0", i, 4);
                if (i%2 == 1){
                    model.setEditable(5,true);
                    digitsInversTable.setValueAt("0", i, 5);
                    model.setEditable(5,false);
                }
            }
            spanDI.setText("0");
            puntuacioDirectaDI.setText("0");
            percentilDI.setText("0");
            nssaDI.setText("0");
          }
        });
        
        ButtonColumn buttonColumn = new ButtonColumn(digitsInversTable, action, 4);
        digitsInversTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        digitsInversTable.packAll();
        digitsInversTable.getColumn(3).setPreferredWidth(300);
    }
    
    private void calcularDigits(boolean digits) {
        int edatPacient = pacientActual.getEdat();
        String edat = "";
        if (edatPacient<=56){
            edat = "50-56";
        }
        else if (edatPacient>=57 && edatPacient<=59){
            edat = "57-59";
        }
        else if (edatPacient>=60 && edatPacient<=62){
            edat = "60-62";
        }
        else if (edatPacient>=63 && edatPacient<=65){
            edat = "63-65";
        }
        else if (edatPacient>=66 && edatPacient<=68){
            edat = "66-68";
        }
        else if (edatPacient>=69 && edatPacient<=71){
            edat = "69-71";
        }
        else if (edatPacient>=72 && edatPacient<=74){
            edat = "72-74";
        }
        else if (edatPacient>=75 && edatPacient<=77){
            edat = "75-77";
        }
        else if (edatPacient>=78 && edatPacient<=80){
            edat = "78-80";
        }
        else if (edatPacient<=81){
            edat = "81-90";
        }
        
        List<Object> list;
        if (digits){
            System.out.println(Integer.parseInt(spanDD.getText()));
            System.out.println(edat);
            list = taulaDigitsDD.get(edat).get(Integer.parseInt(spanDD.getText()));
            percentilDD.setText((String) list.get(1));
        } else {
            list = taulaDigitsDI.get(edat).get(Integer.parseInt(spanDI.getText()));
            percentilDI.setText((String) list.get(1));
        }
        int scaledScore = (int) list.get(0);
        
        int anysEscola = pacientActual.getAnysEscola();
        int modificador = 0;
        
        if (anysEscola <= 2){
            modificador = 2;
        }
        else if (anysEscola >=3 && anysEscola <=7){
            modificador = 1;
        }
        else if (anysEscola >=8 && anysEscola <=12){
            modificador = 0;
        }
        else if (anysEscola >=13 && anysEscola <=16){
            modificador = -1;
        }
        else if (anysEscola >=17){
            modificador = -2;
        }
        if (digits)
            nssaDD.setText(scaledScore+modificador+"");
        else
            nssaDI.setText(scaledScore+modificador+"");
    }
    
    private void initHashDD() {
        taulaDigitsDD = new HashMap<>();
        List<Object> auxList;
        HashMap<Integer, List<Object>> auxMap = new HashMap<>();
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(0, auxList);
        auxMap.put(1, auxList);
        auxMap.put(2, auxList);
        auxMap.put(3, auxList);
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(8, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(9, auxList);
        taulaDigitsDD.put("50-56", new HashMap(auxMap));
        
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(16, "98");
        auxMap.put(8, auxList);
        taulaDigitsDD.put("57-59", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(4, auxList);
        taulaDigitsDD.put("60-62", new HashMap(auxMap));
        
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(7, auxList);
        taulaDigitsDD.put("63-65", new HashMap(auxMap));
        
        auxList = Arrays.asList(4, "2");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(17, "99");
        auxMap.put(8, auxList);
        taulaDigitsDD.put("66-68", new HashMap(auxMap));
        
        taulaDigitsDD.put("69-71", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(4, auxList);
        taulaDigitsDD.put("72-74", new HashMap(auxMap));
        
        auxList = Arrays.asList(3, "1");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(16, "1");
        auxMap.put(7, auxList);
        taulaDigitsDD.put("75-77", new HashMap(auxMap));
        
        auxList = Arrays.asList(17, "99");
        auxMap.put(7, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(8, auxList);
        taulaDigitsDD.put("78-80", new HashMap(auxMap));
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(8, "19-28");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(7, auxList);
        taulaDigitsDD.put("81-90", new HashMap(auxMap));
    }
    
    private void initHashDI() {
    
        taulaDigitsDI = new HashMap<>();
        List<Object> auxList;
        HashMap<Integer, List<Object>> auxMap = new HashMap<>();
        
        auxList = Arrays.asList(2, "<1");
        auxMap.put(0, auxList);
        auxMap.put(1, auxList);
        auxList = Arrays.asList(3, "1");
        auxMap.put(2, auxList);
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(13, "82-89");
        auxMap.put(5, auxList);
        auxList = Arrays.asList(15, "95-97");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(7, auxList);
        taulaDigitsDI.put("50-56", new HashMap(auxMap));
        
        auxList = Arrays.asList(5, "3-5");
        auxMap.put(2, auxList);
        taulaDigitsDI.put("57-59", new HashMap(auxMap));
        
        auxList = Arrays.asList(11, "60-71");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(14, "90-94");
        auxMap.put(5, auxList);
        taulaDigitsDI.put("60-62", new HashMap(auxMap));
        
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(6, auxList);
        taulaDigitsDI.put("63-65", new HashMap(auxMap));
        
        auxList = Arrays.asList(9, "29-40");
        auxMap.put(3, auxList);
        taulaDigitsDI.put("66-68", new HashMap(auxMap));
        
        auxList = Arrays.asList(10, "41-59");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(12, "72-81");
        auxMap.put(4, auxList);
        auxList = Arrays.asList(17, "99");
        auxMap.put(6, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(7, auxList);
        taulaDigitsDI.put("69-71", new HashMap(auxMap));
        
        taulaDigitsDI.put("72-74", new HashMap(auxMap));
        
        auxList = Arrays.asList(6, "6-10");
        auxMap.put(2, auxList);
        taulaDigitsDI.put("75-77", new HashMap(auxMap));
        
        taulaDigitsDI.put("78-80", new HashMap(auxMap));
        
        auxList = Arrays.asList(7, "11-18");
        auxMap.put(3, auxList);
        auxList = Arrays.asList(18, ">99");
        auxMap.put(6, auxList);
        taulaDigitsDI.put("81-90", new HashMap(auxMap));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        digitsDirecteScroll = new javax.swing.JScrollPane();
        digitsDirectePanel = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        digitsDirecteTable = new org.jdesktop.swingx.JXTable();
        jPanel9 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        percentilDD = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        nssaDD = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel87 = new javax.swing.JLabel();
        puntuacioDirectaDD = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        spanDD = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        resetDD = new javax.swing.JButton();
        dataDD = new javax.swing.JLabel();
        digitsInversScroll = new javax.swing.JScrollPane();
        digitsInversPanel = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        digitsInversTable = new org.jdesktop.swingx.JXTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        puntuacioDirectaDI = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        spanDI = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel91 = new javax.swing.JLabel();
        percentilDI = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        nssaDI = new javax.swing.JLabel();
        resetDI = new javax.swing.JButton();
        dataDI = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Dígits directe");

        digitsDirecteTable.setModel(new javax.swing.table.DefaultTableModel(
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
        digitsDirecteTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        digitsDirecteTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        digitsDirecteTable.setRowSelectionAllowed(false);
        digitsDirecteTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        digitsDirecteTable.setSortable(false);
        digitsDirecteTable.setSortsOnUpdates(false);
        jScrollPane4.setViewportView(digitsDirecteTable);

        jPanel9.setBackground(new java.awt.Color(250, 150, 70));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton8.setText("Calcular");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel85.setText("<html>Percentil<br>range:");

        percentilDD.setBackground(new java.awt.Color(255, 255, 255));
        percentilDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentilDD.setText("0");
        percentilDD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        percentilDD.setOpaque(true);

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel86.setText("<html>NSSA<br>NEURONORMA<br>Scaled Score<br>age-adjusted");

        nssaDD.setBackground(new java.awt.Color(255, 255, 255));
        nssaDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nssaDD.setText("0");
        nssaDD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nssaDD.setOpaque(true);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addGap(22, 22, 22)
                .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(percentilDD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nssaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(percentilDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nssaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(220, 218, 195));

        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel87.setText("<html>Puntuació directa<br>ordre directe (DD)");

        puntuacioDirectaDD.setBackground(new java.awt.Color(255, 255, 255));
        puntuacioDirectaDD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        puntuacioDirectaDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacioDirectaDD.setText("0");
        puntuacioDirectaDD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        puntuacioDirectaDD.setOpaque(true);

        jLabel11.setText("(Max = 9)");

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel88.setText("SpanDD");

        spanDD.setBackground(new java.awt.Color(255, 255, 255));
        spanDD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spanDD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spanDD.setText("0");
        spanDD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        spanDD.setOpaque(true);

        jLabel12.setText("(Max = 16)");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel88)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spanDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntuacioDirectaDD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spanDD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel88))
                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntuacioDirectaDD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        resetDD.setText("Reset");
        resetDD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetDDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout digitsDirectePanelLayout = new javax.swing.GroupLayout(digitsDirectePanel);
        digitsDirectePanel.setLayout(digitsDirectePanelLayout);
        digitsDirectePanelLayout.setHorizontalGroup(
            digitsDirectePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitsDirectePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digitsDirectePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addGroup(digitsDirectePanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(digitsDirectePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetDD)
                            .addComponent(dataDD))))
                .addContainerGap())
        );
        digitsDirectePanelLayout.setVerticalGroup(
            digitsDirectePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitsDirectePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addGap(18, 18, 18)
                .addGroup(digitsDirectePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digitsDirectePanelLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetDD)
                        .addGap(18, 18, 18)
                        .addComponent(dataDD))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        digitsDirecteScroll.setViewportView(digitsDirectePanel);

        add(digitsDirecteScroll, "card1");

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Dígits invers");

        digitsInversTable.setModel(new javax.swing.table.DefaultTableModel(
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
        digitsInversTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        digitsInversTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        digitsInversTable.setRowSelectionAllowed(false);
        digitsInversTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        digitsInversTable.setSortable(false);
        digitsInversTable.setSortsOnUpdates(false);
        jScrollPane5.setViewportView(digitsInversTable);

        jPanel11.setBackground(new java.awt.Color(220, 218, 195));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel89.setText("<html>Puntuació directe<br>ordre invers (DI)");

        puntuacioDirectaDI.setBackground(new java.awt.Color(255, 255, 255));
        puntuacioDirectaDI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        puntuacioDirectaDI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        puntuacioDirectaDI.setText("0");
        puntuacioDirectaDI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        puntuacioDirectaDI.setOpaque(true);

        jLabel13.setText("(Max = 9)");

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel90.setText("SpanDI");

        spanDI.setBackground(new java.awt.Color(255, 255, 255));
        spanDI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        spanDI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        spanDI.setText("0");
        spanDI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        spanDI.setOpaque(true);

        jLabel14.setText("(Max = 16)");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spanDI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(puntuacioDirectaDI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spanDI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel90))
                    .addComponent(jLabel89, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(puntuacioDirectaDI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(250, 150, 70));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton9.setText("Calcular");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel91.setText("<html>Percentil<br>range:");

        percentilDI.setBackground(new java.awt.Color(255, 255, 255));
        percentilDI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        percentilDI.setText("0");
        percentilDI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        percentilDI.setOpaque(true);

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel92.setText("<html>NSSA<br>NEURONORMA<br>Scaled Score<br>age-adjusted");

        nssaDI.setBackground(new java.awt.Color(255, 255, 255));
        nssaDI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nssaDI.setText("0");
        nssaDI.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        nssaDI.setOpaque(true);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(percentilDI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nssaDI, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(nssaDI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(percentilDI, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        resetDI.setText("Reset");

        javax.swing.GroupLayout digitsInversPanelLayout = new javax.swing.GroupLayout(digitsInversPanel);
        digitsInversPanel.setLayout(digitsInversPanelLayout);
        digitsInversPanelLayout.setHorizontalGroup(
            digitsInversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digitsInversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digitsInversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addGroup(digitsInversPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(digitsInversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(resetDI)
                            .addComponent(dataDI))))
                .addContainerGap())
        );
        digitsInversPanelLayout.setVerticalGroup(
            digitsInversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, digitsInversPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(18, 18, 18)
                .addGroup(digitsInversPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(digitsInversPanelLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetDI)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dataDI)))
                .addContainerGap())
        );

        digitsInversScroll.setViewportView(digitsInversPanel);

        add(digitsInversScroll, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        calcularDigits(true);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataDD.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void resetDDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetDDActionPerformed

    }//GEN-LAST:event_resetDDActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        calcularDigits(false);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        dataDI.setText("Data del test: "+dateFormat.format(date));
    }//GEN-LAST:event_jButton9ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dataDD;
    private javax.swing.JLabel dataDI;
    private javax.swing.JPanel digitsDirectePanel;
    private javax.swing.JScrollPane digitsDirecteScroll;
    private org.jdesktop.swingx.JXTable digitsDirecteTable;
    private javax.swing.JPanel digitsInversPanel;
    private javax.swing.JScrollPane digitsInversScroll;
    private org.jdesktop.swingx.JXTable digitsInversTable;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel nssaDD;
    private javax.swing.JLabel nssaDI;
    private javax.swing.JLabel percentilDD;
    private javax.swing.JLabel percentilDI;
    private javax.swing.JLabel puntuacioDirectaDD;
    private javax.swing.JLabel puntuacioDirectaDI;
    private javax.swing.JButton resetDD;
    private javax.swing.JButton resetDI;
    private javax.swing.JLabel spanDD;
    private javax.swing.JLabel spanDI;
    // End of variables declaration//GEN-END:variables
}
