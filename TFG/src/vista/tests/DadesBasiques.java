/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.JComboBox;

import controlador.Utils;
import model.Pacient;

/**
 *
 * @author a630703
 */
public class DadesBasiques extends Test {

    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public DadesBasiques(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "Dades Bàsiques";
        numPaginesTotal = this.getComponentCount();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Guarda el codi del subjecte
        Utils.setProperty(prop,"codiSubjecte",subjecteText);

        // Guarda les dades basiques
        Utils.setProperty(prop,"sexe",sexeCombo);
        Utils.setProperty(prop,"idioma",idiomaCombo);
        Utils.setProperty(prop,"dataNaixement",dateChooser);
        Utils.setProperty(prop,"nivellEscolaritat",nivellEscolaritatCombo);
        Utils.setProperty(prop,"anysEscolaritat",anysEscolaritatCombo);
        Utils.setProperty(prop,"estatCivil",estatCivilCombo);
        Utils.setProperty(prop,"professio",professioText);
        Utils.setProperty(prop,"categoriaPro",categoriaProCombo);
        Utils.setProperty(prop,"situacioLaboral",situacioLaboralCombo);
        Utils.setProperty(prop,"nivellSocioeconomic",nivellSocioecomomicCombo);
        Utils.setProperty(prop,"professio",professioText);

        Utils.setProperty(prop,"fumador",fumadorCombo);
        Utils.setProperty(prop,"numCigarrets",numCigarretsText);
        Utils.setProperty(prop,"anysFumar",anysFumarText);
        Utils.setProperty(prop,"edatFumar",edatFumarText);
        Utils.setProperty(prop,"consumAlcohol",consumAlcoholCombo);
        Utils.setProperty(prop,"numBegudes",numBegudesText);
        Utils.setProperty(prop,"ubeDia",ubeDiaCombo);
        Utils.setProperty(prop,"anysAlcohol",anysAlcoholText);
        Utils.setProperty(prop,"edatAlcohol",edatAlcoholText);
        Utils.setProperty(prop,"malaltiesCroniques",malaltiesCroniquesText);

        Utils.setProperty(prop,"tempsTractament",tempsTractamentCombo);
    }

    @Override
    public void carregar(Properties prop) {
        // Carrega el codi del subjecte
        Utils.getProperty(prop,"codiSubjecte",subjecteText);

        // Carrega les dades basiques
        Utils.getProperty(prop,"sexe",sexeCombo);
        Utils.getProperty(prop,"idioma",idiomaCombo);
        Utils.getProperty(prop,"dataNaixement",dateChooser);
        Utils.getProperty(prop,"nivellEscolaritat",nivellEscolaritatCombo);
        Utils.getProperty(prop,"anysEscolaritat",anysEscolaritatCombo);
        Utils.getProperty(prop,"estatCivil",estatCivilCombo);
        Utils.getProperty(prop,"professio",professioText);
        Utils.getProperty(prop,"categoriaPro",categoriaProCombo);
        Utils.getProperty(prop,"situacioLaboral",situacioLaboralCombo);
        Utils.getProperty(prop,"nivellSocioeconomic",nivellSocioecomomicCombo);

        Utils.getProperty(prop,"fumador",fumadorCombo);
        Utils.getProperty(prop,"numCigarrets",numCigarretsText);
        Utils.getProperty(prop,"anysFumar",anysFumarText);
        Utils.getProperty(prop,"edatFumar",edatFumarText);
        Utils.getProperty(prop,"consumAlcohol",consumAlcoholCombo);
        Utils.getProperty(prop,"numBegudes",numBegudesText);
        Utils.getProperty(prop,"ubeDia",ubeDiaCombo);
        Utils.getProperty(prop,"anysAlcohol",anysAlcoholText);
        Utils.getProperty(prop,"edatAlcohol",edatAlcoholText);
        Utils.getProperty(prop,"malaltiesCroniques",malaltiesCroniquesText);

        Utils.getProperty(prop,"tempsTractament",tempsTractamentCombo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadesBasiquesScroll = new javax.swing.JScrollPane();
        dadesBasiquesPanel = new javax.swing.JPanel();
        subjecteLabel = new javax.swing.JLabel();
        subjecteText = new javax.swing.JTextField();
        dadesSociodemografiquesPanel = new javax.swing.JPanel();
        sexeLabel = new javax.swing.JLabel();
        idiomaLabel = new javax.swing.JLabel();
        naixementLabel = new javax.swing.JLabel();
        nivellEscolaritatLabel = new javax.swing.JLabel();
        anysEscolaritatLabel = new javax.swing.JLabel();
        estatCivilLabel = new javax.swing.JLabel();
        professioLabel = new javax.swing.JLabel();
        categoriaProLabel = new javax.swing.JLabel();
        situacioLaboralLabel = new javax.swing.JLabel();
        nivellSocioeconomicLabel = new javax.swing.JLabel();
        sexeCombo = new javax.swing.JComboBox<>();
        idiomaCombo = new javax.swing.JComboBox<>();
        dateChooser = new com.toedter.calendar.JDateChooser();
        nivellEscolaritatCombo = new javax.swing.JComboBox<>();
        estatCivilCombo = new javax.swing.JComboBox<>();
        professioText = new javax.swing.JTextField();
        categoriaProCombo = new javax.swing.JComboBox<>();
        situacioLaboralCombo = new javax.swing.JComboBox<>();
        nivellSocioecomomicCombo = new javax.swing.JComboBox<>();
        anysEscolaritatCombo = new javax.swing.JComboBox<>();
        dadesCliniquesPanel = new javax.swing.JPanel();
        fumadorLabel = new javax.swing.JLabel();
        numCigarretsLabel = new javax.swing.JLabel();
        anysFumarLabel = new javax.swing.JLabel();
        edatFumarLabel = new javax.swing.JLabel();
        consumAlcoholLabel = new javax.swing.JLabel();
        numBegudesLabel = new javax.swing.JLabel();
        ubeDiaLabel = new javax.swing.JLabel();
        anysAlcoholLabel = new javax.swing.JLabel();
        edatAlcoholLabel = new javax.swing.JLabel();
        malaltiesCroniquesLabel = new javax.swing.JLabel();
        fumadorCombo = new javax.swing.JComboBox<>();
        numCigarretsText = new javax.swing.JTextField();
        anysFumarText = new javax.swing.JTextField();
        edatFumarText = new javax.swing.JTextField();
        consumAlcoholCombo = new javax.swing.JComboBox<>();
        numBegudesText = new javax.swing.JTextField();
        ubeDiaCombo = new javax.swing.JComboBox<>();
        anysAlcoholText = new javax.swing.JTextField();
        edatAlcoholText = new javax.swing.JTextField();
        malaltiesCroniquesText = new javax.swing.JTextField();
        terapiaNoFarmatologicaPanel = new javax.swing.JPanel();
        tempsTractamentLabel = new javax.swing.JLabel();
        tempsTractamentCombo = new javax.swing.JComboBox<>();

        subjecteLabel.setText("Codi de subjecte:");

        dadesSociodemografiquesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades sociodemogràfiques"));

        sexeLabel.setText("Sexe:");

        idiomaLabel.setText("Idioma:");

        naixementLabel.setText("Data de naixement:");

        nivellEscolaritatLabel.setText("Nivell escolaritat màxim assolit:");

        anysEscolaritatLabel.setText("Escolaritat (anys total):");

        estatCivilLabel.setText("Estat civil:");

        professioLabel.setText("Professió (descriure):");

        categoriaProLabel.setText("Categoria professional:");

        situacioLaboralLabel.setText("Situació laboral:");

        nivellSocioeconomicLabel.setText("Nivell socioeconòmic (veure índex socioeconòmic):");

        sexeCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dona", "Home" }));
        sexeCombo.setSelectedIndex(-1);

        idiomaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Només castellà", "Català i castellà", "Català, castellà i altres", "Català o castellà i altres" }));
        idiomaCombo.setSelectedIndex(-1);

        dateChooser.setDateFormatString("dd/MM/yyyy");

        nivellEscolaritatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No sap llegir ni escriure", "Sense estudis-sap llegir i escriure", "Estudis primaris no finalitzats", "Estudis primaris complets", "Estudis mitjos-batxillerat", "Universitari grau mig", "Universitari grau superior" }));

        estatCivilCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Casat", "Solter", "Separat", "Divorciat", "Vidu" }));
        estatCivilCombo.setSelectedIndex(-1);

        categoriaProCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Directiu/gerent", "Científic/intel·lectual", "Tècnic professional de nivell mig", "Personal suport administratiu", "Treballador de serveis o venedor de comerços o mercats", "Pagès, granger o pescador", "Oficial, operari o artesà", "Operari d'instal·lacions i màquines", "Ocupacions elementals", "Militar", "Altres" }));
        categoriaProCombo.setSelectedIndex(-1);

        situacioLaboralCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En actiu", "Pensionista", "Atur", "Altres" }));
        situacioLaboralCombo.setSelectedIndex(-1);

        nivellSocioecomomicCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
        nivellSocioecomomicCombo.setSelectedIndex(-1);

        anysEscolaritatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
        anysEscolaritatCombo.setSelectedIndex(-1);

        javax.swing.GroupLayout dadesSociodemografiquesPanelLayout = new javax.swing.GroupLayout(dadesSociodemografiquesPanel);
        dadesSociodemografiquesPanel.setLayout(dadesSociodemografiquesPanelLayout);
        dadesSociodemografiquesPanelLayout.setHorizontalGroup(
            dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(idiomaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idiomaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(sexeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sexeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(naixementLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(estatCivilLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estatCivilCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(professioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(professioText, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(categoriaProLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoriaProCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(situacioLaboralLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(situacioLaboralCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(nivellSocioeconomicLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivellSocioecomomicCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(anysEscolaritatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anysEscolaritatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                        .addComponent(nivellEscolaritatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nivellEscolaritatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadesSociodemografiquesPanelLayout.setVerticalGroup(
            dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesSociodemografiquesPanelLayout.createSequentialGroup()
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexeLabel)
                    .addComponent(sexeCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idiomaLabel)
                    .addComponent(idiomaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(naixementLabel)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivellEscolaritatLabel)
                    .addComponent(nivellEscolaritatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anysEscolaritatLabel)
                    .addComponent(anysEscolaritatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(estatCivilLabel)
                    .addComponent(estatCivilCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(professioLabel)
                    .addComponent(professioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(categoriaProLabel)
                    .addComponent(categoriaProCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(situacioLaboralLabel)
                    .addComponent(situacioLaboralCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesSociodemografiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivellSocioeconomicLabel)
                    .addComponent(nivellSocioecomomicCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dadesCliniquesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades clíniques"));

        fumadorLabel.setText("Fumador/a actualment:");

        numCigarretsLabel.setText("Núm. cigarrets/dia:");

        anysFumarLabel.setText("Anys totals que ha fumat:");

        edatFumarLabel.setText("Edat inici fumar:");

        consumAlcoholLabel.setText("Consum d'alcohol actual:");

        numBegudesLabel.setText("Núm. i tipus de begudes alcohòliques/dia (descriure):");

        ubeDiaLabel.setText("UBE/dia:");

        anysAlcoholLabel.setText("Anys totals consum alcohol:");

        edatAlcoholLabel.setText("Edat inici consum alcohol:");

        malaltiesCroniquesLabel.setText("Malalties cròniques concomitants:");

        fumadorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        fumadorCombo.setSelectedIndex(-1);

        numCigarretsText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numCigarretsTextActionPerformed(evt);
            }
        });

        consumAlcoholCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        consumAlcoholCombo.setSelectedIndex(-1);

        ubeDiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1-2", "3-4", "5-6", ">6" }));
        ubeDiaCombo.setSelectedIndex(-1);

        javax.swing.GroupLayout dadesCliniquesPanelLayout = new javax.swing.GroupLayout(dadesCliniquesPanel);
        dadesCliniquesPanel.setLayout(dadesCliniquesPanelLayout);
        dadesCliniquesPanelLayout.setHorizontalGroup(
            dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(consumAlcoholLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(consumAlcoholCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(numBegudesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numBegudesText, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(edatFumarLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edatFumarText, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(ubeDiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ubeDiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(anysAlcoholLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anysAlcoholText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(edatAlcoholLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edatAlcoholText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                        .addComponent(malaltiesCroniquesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(malaltiesCroniquesText, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadesCliniquesPanelLayout.createSequentialGroup()
                            .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadesCliniquesPanelLayout.createSequentialGroup()
                                    .addComponent(numCigarretsLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numCigarretsText))
                                .addComponent(anysFumarLabel, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(anysFumarText))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadesCliniquesPanelLayout.createSequentialGroup()
                            .addComponent(fumadorLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(fumadorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dadesCliniquesPanelLayout.setVerticalGroup(
            dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesCliniquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fumadorLabel)
                    .addComponent(fumadorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCigarretsLabel)
                    .addComponent(numCigarretsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anysFumarLabel)
                    .addComponent(anysFumarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edatFumarLabel)
                    .addComponent(edatFumarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consumAlcoholLabel)
                    .addComponent(consumAlcoholCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numBegudesLabel)
                    .addComponent(numBegudesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubeDiaLabel)
                    .addComponent(ubeDiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anysAlcoholLabel)
                    .addComponent(anysAlcoholText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edatAlcoholLabel)
                    .addComponent(edatAlcoholText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(malaltiesCroniquesLabel)
                    .addComponent(malaltiesCroniquesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        terapiaNoFarmatologicaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Teràpia no farmacològica"));

        tempsTractamentLabel.setText("Temps en tractament no farmacológic:");

        tempsTractamentCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mai", "Ara no, anteriorment sí (fa més de 12 mesos que no en fa)", "Ara no, anteriorment sí (fa entre 6-12 mesos que no en fa)", "Sí, desde fa entre 1-5 mesos", "Sí, desde fa entre 6-12 mesos", "Sí, desde fa més d'1 any" }));
        tempsTractamentCombo.setSelectedIndex(-1);

        javax.swing.GroupLayout terapiaNoFarmatologicaPanelLayout = new javax.swing.GroupLayout(terapiaNoFarmatologicaPanel);
        terapiaNoFarmatologicaPanel.setLayout(terapiaNoFarmatologicaPanelLayout);
        terapiaNoFarmatologicaPanelLayout.setHorizontalGroup(
            terapiaNoFarmatologicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terapiaNoFarmatologicaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tempsTractamentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tempsTractamentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        terapiaNoFarmatologicaPanelLayout.setVerticalGroup(
            terapiaNoFarmatologicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(terapiaNoFarmatologicaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(terapiaNoFarmatologicaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tempsTractamentLabel)
                    .addComponent(tempsTractamentCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dadesBasiquesPanelLayout = new javax.swing.GroupLayout(dadesBasiquesPanel);
        dadesBasiquesPanel.setLayout(dadesBasiquesPanelLayout);
        dadesBasiquesPanelLayout.setHorizontalGroup(
            dadesBasiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesBasiquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesBasiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dadesCliniquesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dadesBasiquesPanelLayout.createSequentialGroup()
                        .addComponent(subjecteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subjecteText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dadesSociodemografiquesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terapiaNoFarmatologicaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        dadesBasiquesPanelLayout.setVerticalGroup(
            dadesBasiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesBasiquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesBasiquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjecteLabel)
                    .addComponent(subjecteText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dadesSociodemografiquesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dadesCliniquesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(terapiaNoFarmatologicaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dadesBasiquesScroll.setViewportView(dadesBasiquesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadesBasiquesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadesBasiquesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void numCigarretsTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numCigarretsTextActionPerformed

    }//GEN-LAST:event_numCigarretsTextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anysAlcoholLabel;
    private javax.swing.JTextField anysAlcoholText;
    private javax.swing.JComboBox<String> anysEscolaritatCombo;
    private javax.swing.JLabel anysEscolaritatLabel;
    private javax.swing.JLabel anysFumarLabel;
    private javax.swing.JTextField anysFumarText;
    private javax.swing.JComboBox<String> categoriaProCombo;
    private javax.swing.JLabel categoriaProLabel;
    private javax.swing.JComboBox<String> consumAlcoholCombo;
    private javax.swing.JLabel consumAlcoholLabel;
    private javax.swing.JPanel dadesBasiquesPanel;
    private javax.swing.JScrollPane dadesBasiquesScroll;
    private javax.swing.JPanel dadesCliniquesPanel;
    private javax.swing.JPanel dadesSociodemografiquesPanel;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel edatAlcoholLabel;
    private javax.swing.JTextField edatAlcoholText;
    private javax.swing.JLabel edatFumarLabel;
    private javax.swing.JTextField edatFumarText;
    private javax.swing.JComboBox<String> estatCivilCombo;
    private javax.swing.JLabel estatCivilLabel;
    private javax.swing.JComboBox<String> fumadorCombo;
    private javax.swing.JLabel fumadorLabel;
    private javax.swing.JComboBox<String> idiomaCombo;
    private javax.swing.JLabel idiomaLabel;
    private javax.swing.JLabel malaltiesCroniquesLabel;
    private javax.swing.JTextField malaltiesCroniquesText;
    private javax.swing.JLabel naixementLabel;
    private javax.swing.JComboBox<String> nivellEscolaritatCombo;
    private javax.swing.JLabel nivellEscolaritatLabel;
    private javax.swing.JComboBox<String> nivellSocioecomomicCombo;
    private javax.swing.JLabel nivellSocioeconomicLabel;
    private javax.swing.JLabel numBegudesLabel;
    private javax.swing.JTextField numBegudesText;
    private javax.swing.JLabel numCigarretsLabel;
    private javax.swing.JTextField numCigarretsText;
    private javax.swing.JLabel professioLabel;
    private javax.swing.JTextField professioText;
    private javax.swing.JComboBox<String> sexeCombo;
    private javax.swing.JLabel sexeLabel;
    private javax.swing.JComboBox<String> situacioLaboralCombo;
    private javax.swing.JLabel situacioLaboralLabel;
    private javax.swing.JLabel subjecteLabel;
    private javax.swing.JTextField subjecteText;
    private javax.swing.JComboBox<String> tempsTractamentCombo;
    private javax.swing.JLabel tempsTractamentLabel;
    private javax.swing.JPanel terapiaNoFarmatologicaPanel;
    private javax.swing.JComboBox<String> ubeDiaCombo;
    private javax.swing.JLabel ubeDiaLabel;
    // End of variables declaration//GEN-END:variables
}
