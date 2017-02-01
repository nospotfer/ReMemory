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
public class IMAGES extends Test {

   
    private HashMap<String, HashMap<Integer, List<Object>>> taulaDigitsDD;
    private HashMap<String, HashMap<Integer, List<Object>>> taulaDigitsDI;
    
    /**
     * Creates new form Digits
     * @param pacientActual
     */
    public IMAGES(Pacient pacientActual) {
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
                if (sumaAnteriors > 0 && num1 < 1) {
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

                if (sumaAnteriors > 0 && num1 < 1) {
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
        java.awt.GridBagConstraints gridBagConstraints;

        IMAGEScroll = new javax.swing.JScrollPane();
        imagesPanel = new javax.swing.JPanel();
        rseQPanel = new javax.swing.JPanel();
        orientacioBtn2 = new javax.swing.JToggleButton();
        memoBtn2 = new javax.swing.JToggleButton();
        orientacioBtn3 = new javax.swing.JToggleButton();
        memoBtn3 = new javax.swing.JToggleButton();
        orientacioBtn4 = new javax.swing.JToggleButton();
        memoBtn4 = new javax.swing.JToggleButton();
        memoBtn5 = new javax.swing.JToggleButton();
        orientacioBtn5 = new javax.swing.JToggleButton();
        raoBtn2 = new javax.swing.JToggleButton();
        raoBtn5 = new javax.swing.JToggleButton();
        raoBtn3 = new javax.swing.JToggleButton();
        raoBtn4 = new javax.swing.JToggleButton();
        activitatsFBtn2 = new javax.swing.JToggleButton();
        activitatsFBtn3 = new javax.swing.JToggleButton();
        activitatsFBtn4 = new javax.swing.JToggleButton();
        activitatsFBtn5 = new javax.swing.JToggleButton();
        activitatsDBtn5 = new javax.swing.JToggleButton();
        activitatsDBtn4 = new javax.swing.JToggleButton();
        activitatsDBtn2 = new javax.swing.JToggleButton();
        activitatsDBtn3 = new javax.swing.JToggleButton();
        cuidatBtn2 = new javax.swing.JToggleButton();
        cuidatBtn3 = new javax.swing.JToggleButton();
        cuidatBtn4 = new javax.swing.JToggleButton();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        orientacioBtn6 = new javax.swing.JToggleButton();
        raoBtn6 = new javax.swing.JToggleButton();
        raoBtn7 = new javax.swing.JToggleButton();
        activitatsDBtn6 = new javax.swing.JToggleButton();
        raoBtn8 = new javax.swing.JToggleButton();
        activitatsDBtn7 = new javax.swing.JToggleButton();
        activitatsDBtn8 = new javax.swing.JToggleButton();
        cuidatBtn5 = new javax.swing.JToggleButton();
        cuidatBtn6 = new javax.swing.JToggleButton();
        cuidatBtn7 = new javax.swing.JToggleButton();
        activitatsDBtn9 = new javax.swing.JToggleButton();
        cuidatBtn14 = new javax.swing.JToggleButton();
        cuidatBtn16 = new javax.swing.JToggleButton();
        cuidatBtn19 = new javax.swing.JToggleButton();
        activitatsDBtn18 = new javax.swing.JToggleButton();
        cuidatBtn20 = new javax.swing.JToggleButton();
        cuidatBtn21 = new javax.swing.JToggleButton();
        cuidatBtn22 = new javax.swing.JToggleButton();
        jLabel220 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        rseTotal4 = new javax.swing.JLabel();
        rseTotal = new javax.swing.JLabel();
        rseQPanel1 = new javax.swing.JPanel();
        orientacioBtn7 = new javax.swing.JToggleButton();
        memoBtn6 = new javax.swing.JToggleButton();
        orientacioBtn8 = new javax.swing.JToggleButton();
        memoBtn7 = new javax.swing.JToggleButton();
        orientacioBtn9 = new javax.swing.JToggleButton();
        memoBtn8 = new javax.swing.JToggleButton();
        memoBtn9 = new javax.swing.JToggleButton();
        orientacioBtn10 = new javax.swing.JToggleButton();
        raoBtn9 = new javax.swing.JToggleButton();
        raoBtn10 = new javax.swing.JToggleButton();
        raoBtn11 = new javax.swing.JToggleButton();
        raoBtn12 = new javax.swing.JToggleButton();
        activitatsFBtn6 = new javax.swing.JToggleButton();
        activitatsFBtn7 = new javax.swing.JToggleButton();
        activitatsFBtn8 = new javax.swing.JToggleButton();
        activitatsFBtn9 = new javax.swing.JToggleButton();
        activitatsDBtn10 = new javax.swing.JToggleButton();
        activitatsDBtn11 = new javax.swing.JToggleButton();
        activitatsDBtn12 = new javax.swing.JToggleButton();
        activitatsDBtn13 = new javax.swing.JToggleButton();
        cuidatBtn8 = new javax.swing.JToggleButton();
        cuidatBtn9 = new javax.swing.JToggleButton();
        cuidatBtn10 = new javax.swing.JToggleButton();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        orientacioBtn11 = new javax.swing.JToggleButton();
        raoBtn13 = new javax.swing.JToggleButton();
        raoBtn14 = new javax.swing.JToggleButton();
        activitatsDBtn14 = new javax.swing.JToggleButton();
        raoBtn15 = new javax.swing.JToggleButton();
        activitatsDBtn15 = new javax.swing.JToggleButton();
        activitatsDBtn16 = new javax.swing.JToggleButton();
        cuidatBtn11 = new javax.swing.JToggleButton();
        cuidatBtn12 = new javax.swing.JToggleButton();
        cuidatBtn13 = new javax.swing.JToggleButton();
        activitatsDBtn17 = new javax.swing.JToggleButton();
        cuidatBtn15 = new javax.swing.JToggleButton();
        cuidatBtn17 = new javax.swing.JToggleButton();
        cuidatBtn23 = new javax.swing.JToggleButton();
        activitatsDBtn19 = new javax.swing.JToggleButton();
        cuidatBtn24 = new javax.swing.JToggleButton();
        cuidatBtn25 = new javax.swing.JToggleButton();
        cuidatBtn26 = new javax.swing.JToggleButton();
        jLabel221 = new javax.swing.JLabel();
        rseTotal1 = new javax.swing.JLabel();
        rseQPanel2 = new javax.swing.JPanel();
        orientacioBtn12 = new javax.swing.JToggleButton();
        memoBtn10 = new javax.swing.JToggleButton();
        orientacioBtn13 = new javax.swing.JToggleButton();
        memoBtn11 = new javax.swing.JToggleButton();
        orientacioBtn14 = new javax.swing.JToggleButton();
        memoBtn12 = new javax.swing.JToggleButton();
        memoBtn13 = new javax.swing.JToggleButton();
        orientacioBtn15 = new javax.swing.JToggleButton();
        raoBtn16 = new javax.swing.JToggleButton();
        raoBtn17 = new javax.swing.JToggleButton();
        raoBtn18 = new javax.swing.JToggleButton();
        raoBtn19 = new javax.swing.JToggleButton();
        activitatsFBtn10 = new javax.swing.JToggleButton();
        activitatsFBtn11 = new javax.swing.JToggleButton();
        activitatsFBtn12 = new javax.swing.JToggleButton();
        activitatsFBtn13 = new javax.swing.JToggleButton();
        activitatsDBtn20 = new javax.swing.JToggleButton();
        activitatsDBtn21 = new javax.swing.JToggleButton();
        activitatsDBtn22 = new javax.swing.JToggleButton();
        activitatsDBtn23 = new javax.swing.JToggleButton();
        cuidatBtn18 = new javax.swing.JToggleButton();
        cuidatBtn27 = new javax.swing.JToggleButton();
        cuidatBtn28 = new javax.swing.JToggleButton();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        orientacioBtn16 = new javax.swing.JToggleButton();
        raoBtn20 = new javax.swing.JToggleButton();
        raoBtn21 = new javax.swing.JToggleButton();
        activitatsDBtn24 = new javax.swing.JToggleButton();
        raoBtn22 = new javax.swing.JToggleButton();
        activitatsDBtn25 = new javax.swing.JToggleButton();
        activitatsDBtn26 = new javax.swing.JToggleButton();
        cuidatBtn29 = new javax.swing.JToggleButton();
        cuidatBtn30 = new javax.swing.JToggleButton();
        cuidatBtn31 = new javax.swing.JToggleButton();
        activitatsDBtn27 = new javax.swing.JToggleButton();
        cuidatBtn32 = new javax.swing.JToggleButton();
        cuidatBtn33 = new javax.swing.JToggleButton();
        cuidatBtn34 = new javax.swing.JToggleButton();
        activitatsDBtn28 = new javax.swing.JToggleButton();
        cuidatBtn35 = new javax.swing.JToggleButton();
        cuidatBtn36 = new javax.swing.JToggleButton();
        cuidatBtn37 = new javax.swing.JToggleButton();
        jLabel222 = new javax.swing.JLabel();
        rseTotal2 = new javax.swing.JLabel();
        rseQPanel3 = new javax.swing.JPanel();
        orientacioBtn17 = new javax.swing.JToggleButton();
        memoBtn14 = new javax.swing.JToggleButton();
        orientacioBtn18 = new javax.swing.JToggleButton();
        memoBtn15 = new javax.swing.JToggleButton();
        orientacioBtn19 = new javax.swing.JToggleButton();
        memoBtn16 = new javax.swing.JToggleButton();
        memoBtn17 = new javax.swing.JToggleButton();
        orientacioBtn20 = new javax.swing.JToggleButton();
        raoBtn23 = new javax.swing.JToggleButton();
        raoBtn24 = new javax.swing.JToggleButton();
        raoBtn25 = new javax.swing.JToggleButton();
        raoBtn26 = new javax.swing.JToggleButton();
        activitatsFBtn14 = new javax.swing.JToggleButton();
        activitatsFBtn15 = new javax.swing.JToggleButton();
        activitatsFBtn16 = new javax.swing.JToggleButton();
        activitatsFBtn17 = new javax.swing.JToggleButton();
        activitatsDBtn29 = new javax.swing.JToggleButton();
        activitatsDBtn30 = new javax.swing.JToggleButton();
        activitatsDBtn31 = new javax.swing.JToggleButton();
        activitatsDBtn32 = new javax.swing.JToggleButton();
        cuidatBtn38 = new javax.swing.JToggleButton();
        cuidatBtn39 = new javax.swing.JToggleButton();
        cuidatBtn40 = new javax.swing.JToggleButton();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        orientacioBtn21 = new javax.swing.JToggleButton();
        raoBtn27 = new javax.swing.JToggleButton();
        raoBtn28 = new javax.swing.JToggleButton();
        activitatsDBtn33 = new javax.swing.JToggleButton();
        raoBtn29 = new javax.swing.JToggleButton();
        activitatsDBtn34 = new javax.swing.JToggleButton();
        activitatsDBtn35 = new javax.swing.JToggleButton();
        cuidatBtn41 = new javax.swing.JToggleButton();
        cuidatBtn42 = new javax.swing.JToggleButton();
        cuidatBtn43 = new javax.swing.JToggleButton();
        activitatsDBtn36 = new javax.swing.JToggleButton();
        cuidatBtn44 = new javax.swing.JToggleButton();
        cuidatBtn45 = new javax.swing.JToggleButton();
        cuidatBtn46 = new javax.swing.JToggleButton();
        activitatsDBtn37 = new javax.swing.JToggleButton();
        cuidatBtn47 = new javax.swing.JToggleButton();
        cuidatBtn48 = new javax.swing.JToggleButton();
        cuidatBtn49 = new javax.swing.JToggleButton();
        jLabel223 = new javax.swing.JLabel();
        rseTotal3 = new javax.swing.JLabel();
        IMAGEScrollInstructions = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.CardLayout());

        rseQPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escala d'autoestima de Rosemberg", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        rseQPanel.setLayout(new java.awt.GridBagLayout());

        orientacioBtn2.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(orientacioBtn2, gridBagConstraints);

        memoBtn2.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(memoBtn2, gridBagConstraints);

        orientacioBtn3.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(orientacioBtn3, gridBagConstraints);

        memoBtn3.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(memoBtn3, gridBagConstraints);

        orientacioBtn4.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(orientacioBtn4, gridBagConstraints);

        memoBtn4.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(memoBtn4, gridBagConstraints);

        memoBtn5.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(memoBtn5, gridBagConstraints);

        orientacioBtn5.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(orientacioBtn5, gridBagConstraints);

        raoBtn2.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn2, gridBagConstraints);

        raoBtn5.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn5, gridBagConstraints);

        raoBtn3.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn3, gridBagConstraints);

        raoBtn4.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn4, gridBagConstraints);

        activitatsFBtn2.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsFBtn2, gridBagConstraints);

        activitatsFBtn3.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsFBtn3, gridBagConstraints);

        activitatsFBtn4.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsFBtn4, gridBagConstraints);

        activitatsFBtn5.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsFBtn5, gridBagConstraints);

        activitatsDBtn5.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn5, gridBagConstraints);

        activitatsDBtn4.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn4, gridBagConstraints);

        activitatsDBtn2.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn2, gridBagConstraints);

        activitatsDBtn3.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn3, gridBagConstraints);

        cuidatBtn2.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn2, gridBagConstraints);

        cuidatBtn3.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn3, gridBagConstraints);

        cuidatBtn4.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn4, gridBagConstraints);

        jLabel99.setText("<html><center>Molt en<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel.add(jLabel99, gridBagConstraints);

        jLabel100.setText("<html><center>En<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel.add(jLabel100, gridBagConstraints);

        jLabel125.setText("<html><center>Molt<br>d'acord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        rseQPanel.add(jLabel125, gridBagConstraints);

        jLabel126.setText("<html><center>D'acord<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel.add(jLabel126, gridBagConstraints);

        jLabel127.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        rseQPanel.add(jLabel127, gridBagConstraints);

        jLabel128.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rseQPanel.add(jLabel128, gridBagConstraints);

        jLabel129.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        rseQPanel.add(jLabel129, gridBagConstraints);

        jLabel130.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        rseQPanel.add(jLabel130, gridBagConstraints);

        jLabel131.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rseQPanel.add(jLabel131, gridBagConstraints);

        jLabel132.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        rseQPanel.add(jLabel132, gridBagConstraints);

        jLabel101.setText("Sóc capaç de fer les coses tan bé com els demés");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        rseQPanel.add(jLabel101, gridBagConstraints);

        jLabel1.setText("Em sento una persona tan valiosa com les altres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Generalment m'inclino a pensar que soc un fracàs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        rseQPanel.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Crec que tinc algunes qualitats bones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Crec que tinc molt del que estar orgullós");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Tinc una actitud positiva cap a mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel5, gridBagConstraints);

        jLabel6.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rseQPanel.add(jLabel6, gridBagConstraints);

        jLabel7.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        rseQPanel.add(jLabel7, gridBagConstraints);

        jLabel8.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        rseQPanel.add(jLabel8, gridBagConstraints);

        jLabel9.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        rseQPanel.add(jLabel9, gridBagConstraints);

        jLabel10.setText("En general em sento satisfet amb mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel10, gridBagConstraints);

        jLabel11.setText("M'agradaria tenir més respecte per mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel11, gridBagConstraints);

        jLabel12.setText("Realment em sento inútil en algunes ocasions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel12, gridBagConstraints);

        jLabel13.setText("De vegades penso que no serveixo per res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel.add(jLabel13, gridBagConstraints);

        orientacioBtn6.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(orientacioBtn6, gridBagConstraints);

        raoBtn6.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn6, gridBagConstraints);

        raoBtn7.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn7, gridBagConstraints);

        activitatsDBtn6.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn6, gridBagConstraints);

        raoBtn8.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(raoBtn8, gridBagConstraints);

        activitatsDBtn7.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn7, gridBagConstraints);

        activitatsDBtn8.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn8, gridBagConstraints);

        cuidatBtn5.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn5, gridBagConstraints);

        cuidatBtn6.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn6, gridBagConstraints);

        cuidatBtn7.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn7, gridBagConstraints);

        activitatsDBtn9.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn9, gridBagConstraints);

        cuidatBtn14.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn14, gridBagConstraints);

        cuidatBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn16, gridBagConstraints);

        cuidatBtn19.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn19, gridBagConstraints);

        activitatsDBtn18.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(activitatsDBtn18, gridBagConstraints);

        cuidatBtn20.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn20, gridBagConstraints);

        cuidatBtn21.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn21, gridBagConstraints);

        cuidatBtn22.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel.add(cuidatBtn22, gridBagConstraints);

        jLabel220.setText("Puntuació total:");

        jLabel224.setText("<html><b>SUMA TOTAL COMPONENTES:");

        rseTotal4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rseTotal4.setText("0");

        rseTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rseTotal.setText("0");

        rseQPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escala d'autoestima de Rosemberg", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        rseQPanel1.setLayout(new java.awt.GridBagLayout());

        orientacioBtn7.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(orientacioBtn7, gridBagConstraints);

        memoBtn6.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(memoBtn6, gridBagConstraints);

        orientacioBtn8.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(orientacioBtn8, gridBagConstraints);

        memoBtn7.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(memoBtn7, gridBagConstraints);

        orientacioBtn9.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(orientacioBtn9, gridBagConstraints);

        memoBtn8.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(memoBtn8, gridBagConstraints);

        memoBtn9.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(memoBtn9, gridBagConstraints);

        orientacioBtn10.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(orientacioBtn10, gridBagConstraints);

        raoBtn9.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn9, gridBagConstraints);

        raoBtn10.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn10, gridBagConstraints);

        raoBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn11, gridBagConstraints);

        raoBtn12.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn12, gridBagConstraints);

        activitatsFBtn6.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsFBtn6, gridBagConstraints);

        activitatsFBtn7.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsFBtn7, gridBagConstraints);

        activitatsFBtn8.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsFBtn8, gridBagConstraints);

        activitatsFBtn9.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsFBtn9, gridBagConstraints);

        activitatsDBtn10.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn10, gridBagConstraints);

        activitatsDBtn11.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn11, gridBagConstraints);

        activitatsDBtn12.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn12, gridBagConstraints);

        activitatsDBtn13.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn13, gridBagConstraints);

        cuidatBtn8.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn8, gridBagConstraints);

        cuidatBtn9.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn9, gridBagConstraints);

        cuidatBtn10.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn10, gridBagConstraints);

        jLabel102.setText("<html><center>Molt en<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel1.add(jLabel102, gridBagConstraints);

        jLabel103.setText("<html><center>En<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel1.add(jLabel103, gridBagConstraints);

        jLabel133.setText("<html><center>Molt<br>d'acord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        rseQPanel1.add(jLabel133, gridBagConstraints);

        jLabel134.setText("<html><center>D'acord<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel1.add(jLabel134, gridBagConstraints);

        jLabel135.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        rseQPanel1.add(jLabel135, gridBagConstraints);

        jLabel136.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rseQPanel1.add(jLabel136, gridBagConstraints);

        jLabel137.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        rseQPanel1.add(jLabel137, gridBagConstraints);

        jLabel138.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        rseQPanel1.add(jLabel138, gridBagConstraints);

        jLabel139.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rseQPanel1.add(jLabel139, gridBagConstraints);

        jLabel140.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        rseQPanel1.add(jLabel140, gridBagConstraints);

        jLabel104.setText("Sóc capaç de fer les coses tan bé com els demés");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        rseQPanel1.add(jLabel104, gridBagConstraints);

        jLabel15.setText("Em sento una persona tan valiosa com les altres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel15, gridBagConstraints);

        jLabel16.setText("Generalment m'inclino a pensar que soc un fracàs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        rseQPanel1.add(jLabel16, gridBagConstraints);

        jLabel17.setText("Crec que tinc algunes qualitats bones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel17, gridBagConstraints);

        jLabel18.setText("Crec que tinc molt del que estar orgullós");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel18, gridBagConstraints);

        jLabel19.setText("Tinc una actitud positiva cap a mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel19, gridBagConstraints);

        jLabel20.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rseQPanel1.add(jLabel20, gridBagConstraints);

        jLabel21.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        rseQPanel1.add(jLabel21, gridBagConstraints);

        jLabel22.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        rseQPanel1.add(jLabel22, gridBagConstraints);

        jLabel23.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        rseQPanel1.add(jLabel23, gridBagConstraints);

        jLabel24.setText("En general em sento satisfet amb mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel24, gridBagConstraints);

        jLabel25.setText("M'agradaria tenir més respecte per mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel25, gridBagConstraints);

        jLabel26.setText("Realment em sento inútil en algunes ocasions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel26, gridBagConstraints);

        jLabel27.setText("De vegades penso que no serveixo per res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel1.add(jLabel27, gridBagConstraints);

        orientacioBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(orientacioBtn11, gridBagConstraints);

        raoBtn13.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn13, gridBagConstraints);

        raoBtn14.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn14, gridBagConstraints);

        activitatsDBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn14, gridBagConstraints);

        raoBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(raoBtn15, gridBagConstraints);

        activitatsDBtn15.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn15, gridBagConstraints);

        activitatsDBtn16.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn16, gridBagConstraints);

        cuidatBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn11, gridBagConstraints);

        cuidatBtn12.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn12, gridBagConstraints);

        cuidatBtn13.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn13, gridBagConstraints);

        activitatsDBtn17.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn17, gridBagConstraints);

        cuidatBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn15, gridBagConstraints);

        cuidatBtn17.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn17, gridBagConstraints);

        cuidatBtn23.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn23, gridBagConstraints);

        activitatsDBtn19.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(activitatsDBtn19, gridBagConstraints);

        cuidatBtn24.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn24, gridBagConstraints);

        cuidatBtn25.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn25, gridBagConstraints);

        cuidatBtn26.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel1.add(cuidatBtn26, gridBagConstraints);

        jLabel221.setText("Puntuació total:");

        rseTotal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rseTotal1.setText("0");

        rseQPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escala d'autoestima de Rosemberg", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        rseQPanel2.setLayout(new java.awt.GridBagLayout());

        orientacioBtn12.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(orientacioBtn12, gridBagConstraints);

        memoBtn10.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(memoBtn10, gridBagConstraints);

        orientacioBtn13.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(orientacioBtn13, gridBagConstraints);

        memoBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(memoBtn11, gridBagConstraints);

        orientacioBtn14.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(orientacioBtn14, gridBagConstraints);

        memoBtn12.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(memoBtn12, gridBagConstraints);

        memoBtn13.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(memoBtn13, gridBagConstraints);

        orientacioBtn15.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(orientacioBtn15, gridBagConstraints);

        raoBtn16.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn16, gridBagConstraints);

        raoBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn17, gridBagConstraints);

        raoBtn18.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn18, gridBagConstraints);

        raoBtn19.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn19, gridBagConstraints);

        activitatsFBtn10.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsFBtn10, gridBagConstraints);

        activitatsFBtn11.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsFBtn11, gridBagConstraints);

        activitatsFBtn12.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsFBtn12, gridBagConstraints);

        activitatsFBtn13.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsFBtn13, gridBagConstraints);

        activitatsDBtn20.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn20, gridBagConstraints);

        activitatsDBtn21.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn21, gridBagConstraints);

        activitatsDBtn22.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn22, gridBagConstraints);

        activitatsDBtn23.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn23, gridBagConstraints);

        cuidatBtn18.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn18, gridBagConstraints);

        cuidatBtn27.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn27, gridBagConstraints);

        cuidatBtn28.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn28, gridBagConstraints);

        jLabel105.setText("<html><center>Molt en<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel2.add(jLabel105, gridBagConstraints);

        jLabel106.setText("<html><center>En<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel2.add(jLabel106, gridBagConstraints);

        jLabel141.setText("<html><center>Molt<br>d'acord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        rseQPanel2.add(jLabel141, gridBagConstraints);

        jLabel142.setText("<html><center>D'acord<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel2.add(jLabel142, gridBagConstraints);

        jLabel143.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        rseQPanel2.add(jLabel143, gridBagConstraints);

        jLabel144.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rseQPanel2.add(jLabel144, gridBagConstraints);

        jLabel145.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        rseQPanel2.add(jLabel145, gridBagConstraints);

        jLabel146.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        rseQPanel2.add(jLabel146, gridBagConstraints);

        jLabel147.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rseQPanel2.add(jLabel147, gridBagConstraints);

        jLabel148.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        rseQPanel2.add(jLabel148, gridBagConstraints);

        jLabel107.setText("Sóc capaç de fer les coses tan bé com els demés");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        rseQPanel2.add(jLabel107, gridBagConstraints);

        jLabel28.setText("Em sento una persona tan valiosa com les altres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel28, gridBagConstraints);

        jLabel29.setText("Generalment m'inclino a pensar que soc un fracàs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        rseQPanel2.add(jLabel29, gridBagConstraints);

        jLabel30.setText("Crec que tinc algunes qualitats bones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel30, gridBagConstraints);

        jLabel32.setText("Crec que tinc molt del que estar orgullós");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel32, gridBagConstraints);

        jLabel33.setText("Tinc una actitud positiva cap a mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel33, gridBagConstraints);

        jLabel34.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rseQPanel2.add(jLabel34, gridBagConstraints);

        jLabel35.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        rseQPanel2.add(jLabel35, gridBagConstraints);

        jLabel36.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        rseQPanel2.add(jLabel36, gridBagConstraints);

        jLabel37.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        rseQPanel2.add(jLabel37, gridBagConstraints);

        jLabel38.setText("En general em sento satisfet amb mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel38, gridBagConstraints);

        jLabel39.setText("M'agradaria tenir més respecte per mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel39, gridBagConstraints);

        jLabel40.setText("Realment em sento inútil en algunes ocasions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel40, gridBagConstraints);

        jLabel41.setText("De vegades penso que no serveixo per res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel2.add(jLabel41, gridBagConstraints);

        orientacioBtn16.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(orientacioBtn16, gridBagConstraints);

        raoBtn20.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn20, gridBagConstraints);

        raoBtn21.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn21, gridBagConstraints);

        activitatsDBtn24.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn24, gridBagConstraints);

        raoBtn22.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(raoBtn22, gridBagConstraints);

        activitatsDBtn25.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn25, gridBagConstraints);

        activitatsDBtn26.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn26, gridBagConstraints);

        cuidatBtn29.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn29, gridBagConstraints);

        cuidatBtn30.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn30, gridBagConstraints);

        cuidatBtn31.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn31, gridBagConstraints);

        activitatsDBtn27.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn27, gridBagConstraints);

        cuidatBtn32.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn32, gridBagConstraints);

        cuidatBtn33.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn33, gridBagConstraints);

        cuidatBtn34.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn34, gridBagConstraints);

        activitatsDBtn28.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(activitatsDBtn28, gridBagConstraints);

        cuidatBtn35.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn35, gridBagConstraints);

        cuidatBtn36.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn36, gridBagConstraints);

        cuidatBtn37.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel2.add(cuidatBtn37, gridBagConstraints);

        jLabel222.setText("Puntuació total:");

        rseTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rseTotal2.setText("0");

        rseQPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escala d'autoestima de Rosemberg", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        rseQPanel3.setLayout(new java.awt.GridBagLayout());

        orientacioBtn17.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(orientacioBtn17, gridBagConstraints);

        memoBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(memoBtn14, gridBagConstraints);

        orientacioBtn18.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(orientacioBtn18, gridBagConstraints);

        memoBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(memoBtn15, gridBagConstraints);

        orientacioBtn19.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(orientacioBtn19, gridBagConstraints);

        memoBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(memoBtn16, gridBagConstraints);

        memoBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(memoBtn17, gridBagConstraints);

        orientacioBtn20.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(orientacioBtn20, gridBagConstraints);

        raoBtn23.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn23, gridBagConstraints);

        raoBtn24.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn24, gridBagConstraints);

        raoBtn25.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn25, gridBagConstraints);

        raoBtn26.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn26, gridBagConstraints);

        activitatsFBtn14.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsFBtn14, gridBagConstraints);

        activitatsFBtn15.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsFBtn15, gridBagConstraints);

        activitatsFBtn16.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsFBtn16, gridBagConstraints);

        activitatsFBtn17.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsFBtn17, gridBagConstraints);

        activitatsDBtn29.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn29, gridBagConstraints);

        activitatsDBtn30.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn30, gridBagConstraints);

        activitatsDBtn31.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn31, gridBagConstraints);

        activitatsDBtn32.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn32, gridBagConstraints);

        cuidatBtn38.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn38, gridBagConstraints);

        cuidatBtn39.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn39, gridBagConstraints);

        cuidatBtn40.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn40, gridBagConstraints);

        jLabel108.setText("<html><center>Molt en<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel3.add(jLabel108, gridBagConstraints);

        jLabel109.setText("<html><center>En<br>desacord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel3.add(jLabel109, gridBagConstraints);

        jLabel149.setText("<html><center>Molt<br>d'acord");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        rseQPanel3.add(jLabel149, gridBagConstraints);

        jLabel150.setText("<html><center>D'acord<br>");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 2);
        rseQPanel3.add(jLabel150, gridBagConstraints);

        jLabel151.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        rseQPanel3.add(jLabel151, gridBagConstraints);

        jLabel152.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        rseQPanel3.add(jLabel152, gridBagConstraints);

        jLabel153.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        rseQPanel3.add(jLabel153, gridBagConstraints);

        jLabel154.setText("5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        rseQPanel3.add(jLabel154, gridBagConstraints);

        jLabel155.setText("6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        rseQPanel3.add(jLabel155, gridBagConstraints);

        jLabel156.setText("7");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        rseQPanel3.add(jLabel156, gridBagConstraints);

        jLabel110.setText("Sóc capaç de fer les coses tan bé com els demés");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        rseQPanel3.add(jLabel110, gridBagConstraints);

        jLabel42.setText("Em sento una persona tan valiosa com les altres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel42, gridBagConstraints);

        jLabel43.setText("Generalment m'inclino a pensar que soc un fracàs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        rseQPanel3.add(jLabel43, gridBagConstraints);

        jLabel44.setText("Crec que tinc algunes qualitats bones");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel44, gridBagConstraints);

        jLabel45.setText("Crec que tinc molt del que estar orgullós");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel45, gridBagConstraints);

        jLabel46.setText("Tinc una actitud positiva cap a mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel46, gridBagConstraints);

        jLabel47.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        rseQPanel3.add(jLabel47, gridBagConstraints);

        jLabel48.setText("8");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        rseQPanel3.add(jLabel48, gridBagConstraints);

        jLabel49.setText("9");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        rseQPanel3.add(jLabel49, gridBagConstraints);

        jLabel50.setText("10");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.insets = new java.awt.Insets(0, 1, 0, 5);
        rseQPanel3.add(jLabel50, gridBagConstraints);

        jLabel51.setText("En general em sento satisfet amb mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel51, gridBagConstraints);

        jLabel52.setText("M'agradaria tenir més respecte per mi mateix");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel52, gridBagConstraints);

        jLabel53.setText("Realment em sento inútil en algunes ocasions");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel53, gridBagConstraints);

        jLabel54.setText("De vegades penso que no serveixo per res");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        rseQPanel3.add(jLabel54, gridBagConstraints);

        orientacioBtn21.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(orientacioBtn21, gridBagConstraints);

        raoBtn27.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn27, gridBagConstraints);

        raoBtn28.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn28, gridBagConstraints);

        activitatsDBtn33.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn33, gridBagConstraints);

        raoBtn29.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(raoBtn29, gridBagConstraints);

        activitatsDBtn34.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn34, gridBagConstraints);

        activitatsDBtn35.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn35, gridBagConstraints);

        cuidatBtn41.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn41, gridBagConstraints);

        cuidatBtn42.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn42, gridBagConstraints);

        cuidatBtn43.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn43, gridBagConstraints);

        activitatsDBtn36.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn36, gridBagConstraints);

        cuidatBtn44.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn44, gridBagConstraints);

        cuidatBtn45.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn45, gridBagConstraints);

        cuidatBtn46.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn46, gridBagConstraints);

        activitatsDBtn37.setText("1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(activitatsDBtn37, gridBagConstraints);

        cuidatBtn47.setText("2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn47, gridBagConstraints);

        cuidatBtn48.setText("3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn48, gridBagConstraints);

        cuidatBtn49.setText("4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        rseQPanel3.add(cuidatBtn49, gridBagConstraints);

        jLabel223.setText("Puntuació total:");

        rseTotal3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rseTotal3.setText("0");

        javax.swing.GroupLayout imagesPanelLayout = new javax.swing.GroupLayout(imagesPanel);
        imagesPanel.setLayout(imagesPanelLayout);
        imagesPanelLayout.setHorizontalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel223)
                .addGap(0, 0, 0)
                .addComponent(rseTotal3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel221)
                .addGap(0, 0, 0)
                .addComponent(rseTotal1)
                .addGap(105, 105, 105))
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagesPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(imagesPanelLayout.createSequentialGroup()
                                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(imagesPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel220)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rseTotal)
                                        .addGap(81, 81, 81))
                                    .addComponent(rseQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(imagesPanelLayout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(rseQPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagesPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel222)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rseTotal2)
                                        .addGap(71, 71, 71))))
                            .addGroup(imagesPanelLayout.createSequentialGroup()
                                .addComponent(rseQPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rseQPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(imagesPanelLayout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rseTotal4)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        imagesPanelLayout.setVerticalGroup(
            imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rseQPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rseQPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel220)
                        .addComponent(rseTotal))
                    .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel222)
                        .addComponent(rseTotal2)))
                .addGap(18, 18, 18)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rseQPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rseQPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel223)
                        .addComponent(rseTotal3))
                    .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel221)
                        .addComponent(rseTotal1)))
                .addGap(33, 33, 33)
                .addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rseTotal4))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        IMAGEScroll.setViewportView(imagesPanel);

        add(IMAGEScroll, "card1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("IMAGE TEST: Instrucciones\n\nSi la memoria autobiográfica es realmente crucial para la construcción del sentido de la identidad \ny para el sentimiento de autosuficiencia (Conway, 2005), qué pasa con el sentido de la identidad en \nlos pacientes que sufren de trastornos episódicos graves de memoria y que son, por tanto, incapaces \nde revivir eventos personales con “calidez e intimidad”. \nLa investigación sugiere que algunos componentes de la autoestima en pacientes con EA se deterioran \ncon el progreso de la enfermedad, mientras que otros parecen estar preservados, al menos parcialmente. \n\nEl IMAGE test, refleja el sentido general del individuo sobre su identidad y el nivel asociado \nde autoestima indicando si tiende a tener una visión positiva o negativa de sí mismo.\n \nInstrucciones de uso: \n\n1. Preguntar su edad subjetiva y compararla con la real. Si está por debajo de la real se atribuye \nvalor negativo. Estimación subjetiva de su propia edad, que es una de auto-representaciones que \nnecesita ser continuamente actualizada durante la vida.\n\n2. El examinador leerá la premisa y el paciente deberá responder si la considera verdadera o falsa. \nSi no la entiende el evaluador puede recurrir a la explicación descrita dentro del paréntesis. Las \ninstrucciones se pueden repetir tantas veces como haga falta. \n\n3. Una vez haya respondido si es verdadero o falso, el evaluador le preguntará cuánto de verdadero \n(totalmente o parcialmente) o, por el contrario, cuánto de falso (totalmente o verdaderamente) y \nlo anotará en la escala tipo Likert que aparece debajo de cada ítem. \n\n4. El cuestionario se evalúa contando las puntuaciones que van del 1-4 en la escala tipo Likert y \nse suman los ítems que se corresponden con la misma categoría (ejemplo: se suman las respuestas de \nlas escalas de los ítems 1-2-3-4-5-6-7 para obtener el resultado de identidad), obteniendo un \nresultado para cada una de las 4. \n\ta.Identidad (máx. 28): refleja cómo los participantes se describen a ellos mismos cuando \n\t  se refieren a quién fueron. \n\tb.Conductual (máx. 28): refleja cómo los participantes se describen cuando se refieren a \n\t  cómo se comportan.\n\tc.Autosatisfacción (máx. 28): refleja la forma en que los participantes se describen \n\t  cuando se refieren a cómo de contentos están con ellos mismos. \n\td.Autoconciencia privada (máx. 12): refleja la forma en que los participantes se describen \n\t  cuando se refieren a su habilidad de observarse y analizarse, sobretodo para los aspectos \n\t  personales y difícilmente accesibles para la curiosidad de otros, como sus propios sentimientos. \n\n5.La puntuación total se obtiene a partir de la suma de los resultados de los 4 componentes del Autoconcepto. \nFinalmente se suman todos ellos (identidad, conductual, autosatisfacción y autoconciencia), que son 4 y se \nobtiene una puntuación total que puede ser como máximo de 96. La puntuación total refleja el sentido de \nidentidad y nivel asociado de autoestima, indicando si tiende a tener una opinión sobre sí mismo generalmente \npositiva o generalmente negativa. Se debe repetir el mismo test “15 días” después de la intervención cognitiva.\n");
        jTextArea1.setToolTipText("");
        jTextArea1.setWrapStyleWord(true);
        IMAGEScrollInstructions.setViewportView(jTextArea1);

        add(IMAGEScrollInstructions, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane IMAGEScroll;
    private javax.swing.JScrollPane IMAGEScrollInstructions;
    private javax.swing.JToggleButton activitatsDBtn10;
    private javax.swing.JToggleButton activitatsDBtn11;
    private javax.swing.JToggleButton activitatsDBtn12;
    private javax.swing.JToggleButton activitatsDBtn13;
    private javax.swing.JToggleButton activitatsDBtn14;
    private javax.swing.JToggleButton activitatsDBtn15;
    private javax.swing.JToggleButton activitatsDBtn16;
    private javax.swing.JToggleButton activitatsDBtn17;
    private javax.swing.JToggleButton activitatsDBtn18;
    private javax.swing.JToggleButton activitatsDBtn19;
    private javax.swing.JToggleButton activitatsDBtn2;
    private javax.swing.JToggleButton activitatsDBtn20;
    private javax.swing.JToggleButton activitatsDBtn21;
    private javax.swing.JToggleButton activitatsDBtn22;
    private javax.swing.JToggleButton activitatsDBtn23;
    private javax.swing.JToggleButton activitatsDBtn24;
    private javax.swing.JToggleButton activitatsDBtn25;
    private javax.swing.JToggleButton activitatsDBtn26;
    private javax.swing.JToggleButton activitatsDBtn27;
    private javax.swing.JToggleButton activitatsDBtn28;
    private javax.swing.JToggleButton activitatsDBtn29;
    private javax.swing.JToggleButton activitatsDBtn3;
    private javax.swing.JToggleButton activitatsDBtn30;
    private javax.swing.JToggleButton activitatsDBtn31;
    private javax.swing.JToggleButton activitatsDBtn32;
    private javax.swing.JToggleButton activitatsDBtn33;
    private javax.swing.JToggleButton activitatsDBtn34;
    private javax.swing.JToggleButton activitatsDBtn35;
    private javax.swing.JToggleButton activitatsDBtn36;
    private javax.swing.JToggleButton activitatsDBtn37;
    private javax.swing.JToggleButton activitatsDBtn4;
    private javax.swing.JToggleButton activitatsDBtn5;
    private javax.swing.JToggleButton activitatsDBtn6;
    private javax.swing.JToggleButton activitatsDBtn7;
    private javax.swing.JToggleButton activitatsDBtn8;
    private javax.swing.JToggleButton activitatsDBtn9;
    private javax.swing.JToggleButton activitatsFBtn10;
    private javax.swing.JToggleButton activitatsFBtn11;
    private javax.swing.JToggleButton activitatsFBtn12;
    private javax.swing.JToggleButton activitatsFBtn13;
    private javax.swing.JToggleButton activitatsFBtn14;
    private javax.swing.JToggleButton activitatsFBtn15;
    private javax.swing.JToggleButton activitatsFBtn16;
    private javax.swing.JToggleButton activitatsFBtn17;
    private javax.swing.JToggleButton activitatsFBtn2;
    private javax.swing.JToggleButton activitatsFBtn3;
    private javax.swing.JToggleButton activitatsFBtn4;
    private javax.swing.JToggleButton activitatsFBtn5;
    private javax.swing.JToggleButton activitatsFBtn6;
    private javax.swing.JToggleButton activitatsFBtn7;
    private javax.swing.JToggleButton activitatsFBtn8;
    private javax.swing.JToggleButton activitatsFBtn9;
    private javax.swing.JToggleButton cuidatBtn10;
    private javax.swing.JToggleButton cuidatBtn11;
    private javax.swing.JToggleButton cuidatBtn12;
    private javax.swing.JToggleButton cuidatBtn13;
    private javax.swing.JToggleButton cuidatBtn14;
    private javax.swing.JToggleButton cuidatBtn15;
    private javax.swing.JToggleButton cuidatBtn16;
    private javax.swing.JToggleButton cuidatBtn17;
    private javax.swing.JToggleButton cuidatBtn18;
    private javax.swing.JToggleButton cuidatBtn19;
    private javax.swing.JToggleButton cuidatBtn2;
    private javax.swing.JToggleButton cuidatBtn20;
    private javax.swing.JToggleButton cuidatBtn21;
    private javax.swing.JToggleButton cuidatBtn22;
    private javax.swing.JToggleButton cuidatBtn23;
    private javax.swing.JToggleButton cuidatBtn24;
    private javax.swing.JToggleButton cuidatBtn25;
    private javax.swing.JToggleButton cuidatBtn26;
    private javax.swing.JToggleButton cuidatBtn27;
    private javax.swing.JToggleButton cuidatBtn28;
    private javax.swing.JToggleButton cuidatBtn29;
    private javax.swing.JToggleButton cuidatBtn3;
    private javax.swing.JToggleButton cuidatBtn30;
    private javax.swing.JToggleButton cuidatBtn31;
    private javax.swing.JToggleButton cuidatBtn32;
    private javax.swing.JToggleButton cuidatBtn33;
    private javax.swing.JToggleButton cuidatBtn34;
    private javax.swing.JToggleButton cuidatBtn35;
    private javax.swing.JToggleButton cuidatBtn36;
    private javax.swing.JToggleButton cuidatBtn37;
    private javax.swing.JToggleButton cuidatBtn38;
    private javax.swing.JToggleButton cuidatBtn39;
    private javax.swing.JToggleButton cuidatBtn4;
    private javax.swing.JToggleButton cuidatBtn40;
    private javax.swing.JToggleButton cuidatBtn41;
    private javax.swing.JToggleButton cuidatBtn42;
    private javax.swing.JToggleButton cuidatBtn43;
    private javax.swing.JToggleButton cuidatBtn44;
    private javax.swing.JToggleButton cuidatBtn45;
    private javax.swing.JToggleButton cuidatBtn46;
    private javax.swing.JToggleButton cuidatBtn47;
    private javax.swing.JToggleButton cuidatBtn48;
    private javax.swing.JToggleButton cuidatBtn49;
    private javax.swing.JToggleButton cuidatBtn5;
    private javax.swing.JToggleButton cuidatBtn6;
    private javax.swing.JToggleButton cuidatBtn7;
    private javax.swing.JToggleButton cuidatBtn8;
    private javax.swing.JToggleButton cuidatBtn9;
    private javax.swing.JPanel imagesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JToggleButton memoBtn10;
    private javax.swing.JToggleButton memoBtn11;
    private javax.swing.JToggleButton memoBtn12;
    private javax.swing.JToggleButton memoBtn13;
    private javax.swing.JToggleButton memoBtn14;
    private javax.swing.JToggleButton memoBtn15;
    private javax.swing.JToggleButton memoBtn16;
    private javax.swing.JToggleButton memoBtn17;
    private javax.swing.JToggleButton memoBtn2;
    private javax.swing.JToggleButton memoBtn3;
    private javax.swing.JToggleButton memoBtn4;
    private javax.swing.JToggleButton memoBtn5;
    private javax.swing.JToggleButton memoBtn6;
    private javax.swing.JToggleButton memoBtn7;
    private javax.swing.JToggleButton memoBtn8;
    private javax.swing.JToggleButton memoBtn9;
    private javax.swing.JToggleButton orientacioBtn10;
    private javax.swing.JToggleButton orientacioBtn11;
    private javax.swing.JToggleButton orientacioBtn12;
    private javax.swing.JToggleButton orientacioBtn13;
    private javax.swing.JToggleButton orientacioBtn14;
    private javax.swing.JToggleButton orientacioBtn15;
    private javax.swing.JToggleButton orientacioBtn16;
    private javax.swing.JToggleButton orientacioBtn17;
    private javax.swing.JToggleButton orientacioBtn18;
    private javax.swing.JToggleButton orientacioBtn19;
    private javax.swing.JToggleButton orientacioBtn2;
    private javax.swing.JToggleButton orientacioBtn20;
    private javax.swing.JToggleButton orientacioBtn21;
    private javax.swing.JToggleButton orientacioBtn3;
    private javax.swing.JToggleButton orientacioBtn4;
    private javax.swing.JToggleButton orientacioBtn5;
    private javax.swing.JToggleButton orientacioBtn6;
    private javax.swing.JToggleButton orientacioBtn7;
    private javax.swing.JToggleButton orientacioBtn8;
    private javax.swing.JToggleButton orientacioBtn9;
    private javax.swing.JToggleButton raoBtn10;
    private javax.swing.JToggleButton raoBtn11;
    private javax.swing.JToggleButton raoBtn12;
    private javax.swing.JToggleButton raoBtn13;
    private javax.swing.JToggleButton raoBtn14;
    private javax.swing.JToggleButton raoBtn15;
    private javax.swing.JToggleButton raoBtn16;
    private javax.swing.JToggleButton raoBtn17;
    private javax.swing.JToggleButton raoBtn18;
    private javax.swing.JToggleButton raoBtn19;
    private javax.swing.JToggleButton raoBtn2;
    private javax.swing.JToggleButton raoBtn20;
    private javax.swing.JToggleButton raoBtn21;
    private javax.swing.JToggleButton raoBtn22;
    private javax.swing.JToggleButton raoBtn23;
    private javax.swing.JToggleButton raoBtn24;
    private javax.swing.JToggleButton raoBtn25;
    private javax.swing.JToggleButton raoBtn26;
    private javax.swing.JToggleButton raoBtn27;
    private javax.swing.JToggleButton raoBtn28;
    private javax.swing.JToggleButton raoBtn29;
    private javax.swing.JToggleButton raoBtn3;
    private javax.swing.JToggleButton raoBtn4;
    private javax.swing.JToggleButton raoBtn5;
    private javax.swing.JToggleButton raoBtn6;
    private javax.swing.JToggleButton raoBtn7;
    private javax.swing.JToggleButton raoBtn8;
    private javax.swing.JToggleButton raoBtn9;
    private javax.swing.JPanel rseQPanel;
    private javax.swing.JPanel rseQPanel1;
    private javax.swing.JPanel rseQPanel2;
    private javax.swing.JPanel rseQPanel3;
    private javax.swing.JLabel rseTotal;
    private javax.swing.JLabel rseTotal1;
    private javax.swing.JLabel rseTotal2;
    private javax.swing.JLabel rseTotal3;
    private javax.swing.JLabel rseTotal4;
    // End of variables declaration//GEN-END:variables
}
