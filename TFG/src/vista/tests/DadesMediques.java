/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.tests;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.swing.JComboBox;

import controlador.Utils;
import model.Pacient;

/**
 *
 * @author a630703
 */
public class DadesMediques extends Test {

    Map<JComboBox, JDateChooser> dateMap;
    
    /**
     * Creates new form Test
     *
     * @param pacientActual
     */
    public DadesMediques(Pacient pacientActual) {
        super(pacientActual);
        initComponents();

        label = "Dades Mèdiques";
        numPaginesTotal = this.getComponentCount();

        initDateMap();
        initCombos();
    }

    @Override
    public void guardarResultats(Properties prop) {
        // Guarda les dades mediques
        Utils.setProperty(prop,"alzheimer",alzheimerCombo);
        Utils.setProperty(prop,"parkinson",parkinsonCombo);
        Utils.setProperty(prop,"sindromeDown",sindromeDownCombo);
        Utils.setProperty(prop,"altresDemencies",altresDemenciesText);
        Utils.setProperty(prop,"antecedentsPare",antecedentsPareText);
        Utils.setProperty(prop,"antecedentsMare",antecedentsMareText);
        Utils.setProperty(prop,"altresFamiliars",altresFamiliarsText);

        Utils.setProperty(prop,"cafe",cafeText);
        Utils.setProperty(prop,"tabac",tabacText);
        Utils.setProperty(prop,"alcohol",alcoholText);
        Utils.setProperty(prop,"cannabis",cannabisCombo);
        Utils.setProperty(prop,"toxicsLaborals",toxicsLaboralsText);
        Utils.setProperty(prop,"antecedentsPersonals",antecedentsPersonalsText);

        Utils.setProperty(prop,"hipertensio",hipertensioCombo);
        Utils.setProperty(prop,"insuficienciaCardiaca",insuficienciaCardiacaCombo);
        Utils.setProperty(prop,"infart",infartCombo);
        Utils.setProperty(prop,"cardiopatia",cardiopatiaCombo);
        Utils.setProperty(prop,"arritmia",arritmiaCombo);
        Utils.setProperty(prop,"malaltiaVascularPeriferica",malaltiaVascularCombo);

        Utils.setProperty(prop,"diabetis",diabetisCombo);
        Utils.setProperty(prop,"obesitat",obesitatCombo);
        Utils.setProperty(prop,"dislipemia",dislipemiaCombo);
        Utils.setProperty(prop,"patologiaTiroides",this.patologiaTiroidesCombo);

        Utils.setProperty(prop,"ulcus",ulcusCombo);
        Utils.setProperty(prop,"gastritis",gastritisCombo);
        Utils.setProperty(prop,"colelitiasis",colelitiasisCombo);
        Utils.setProperty(prop,"hepatopatia",hepatopatiaCombo);

        Utils.setProperty(prop,"depresio",depresioCombo);
        Utils.setProperty(prop,"ansietat",ansietatCombo);
        Utils.setProperty(prop,"psicosis",psicosisCombo);
        Utils.setProperty(prop,"abusAlcohol",abusAlcoholCombo);
        Utils.setProperty(prop,"abusDrogues",abusDroguesCombo);

        Utils.setProperty(prop,"avcEstablert",avcEstablertCombo);
        Utils.setProperty(prop,"avcTransitori",avcTransitoriCombo);
        Utils.setProperty(prop,"epilepsia",epilepsiaCombo);
        Utils.setProperty(prop,"traumaCraneal",traumaCranealCombo);
        Utils.setProperty(prop,"malaltiaParkinson",malaltiaParkinsonCombo);
        Utils.setProperty(prop,"esclerosis",esclerosisCombo);
        Utils.setProperty(prop,"cefalea",cefaleaCombo);

        Utils.setProperty(prop,"asma",asmaCombo);
        Utils.setProperty(prop,"epoc",epocCombo);

        Utils.setProperty(prop,"anemia",anemiaCombo);
        Utils.setProperty(prop,"leucosis",leucosisCombo);

        Utils.setProperty(prop,"alergia",alergiaCombo);

        Utils.setProperty(prop,"glaucoma",glaucomaCombo);
        Utils.setProperty(prop,"cataractes",cataractesCombo);

        Utils.setProperty(prop,"insuficienciaRenal",insuficienciaRenalCombo);
        Utils.setProperty(prop,"incontinencia",incontinenciaCombo);

        Utils.setProperty(prop,"artrosi",artrosiCombo);
        Utils.setProperty(prop,"artritis",artritisCombo);
        Utils.setProperty(prop,"fibromialgia",fibromialgiaCombo);

        Utils.setProperty(prop,"benigne",benigneCombo);
        Utils.setProperty(prop,"maligne",maligneCombo);

        Utils.setProperty(prop,"ansiolitics",ansioliticsText);
        Utils.setProperty(prop,"hipnotics",hipnoticsText);
        Utils.setProperty(prop,"antidepresius",antidepresiusText);
        Utils.setProperty(prop,"antimaniacs",antimaniacsText);
        Utils.setProperty(prop,"antipsicotics",antipsicoticsText);
        Utils.setProperty(prop,"antimigranyosos",antimigranyososText);
        Utils.setProperty(prop,"opioides",opioidesText);
        Utils.setProperty(prop,"antiepileptics",antiepilepticsText);
        Utils.setProperty(prop,"antiparkinsonians",antiparkinsoniansText);
        Utils.setProperty(prop,"musculEstriat",musculEstriatText);
        Utils.setProperty(prop,"vasodilatadors",vasodilatadorsText);
        Utils.setProperty(prop,"ACEsterasa",ACEsterasaText);
        Utils.setProperty(prop,"memantina",memantinaText);
        Utils.setProperty(prop,"psicoestimulants",psicoestimulantsText);
        Utils.setProperty(prop,"substanciesAbus",substanciesAbusText);
        Utils.setProperty(prop,"deshabituacio",deshabituacioText);

        Utils.setProperty(prop,"antiacids",antiacidsText);
        Utils.setProperty(prop,"antidiabetics",antidiabeticsText);
        Utils.setProperty(prop,"antitrombotics",antitromboticsText);
        Utils.setProperty(prop,"antiagregants",antiagregantsText);
        Utils.setProperty(prop,"cardiotonics",cardiotonicsText);
        Utils.setProperty(prop,"antihipertensius",antihipertensiusText);
        Utils.setProperty(prop,"diuretics",diureticsText);
        Utils.setProperty(prop,"hipolipemiants",hipolipemiantsText);
        Utils.setProperty(prop,"dermatologics",dermatologicsText);
        Utils.setProperty(prop,"hormones",hormonesText);
        Utils.setProperty(prop,"urologics",urologicsText);
        Utils.setProperty(prop,"corticosteroides",corticosteroidesText);
        Utils.setProperty(prop,"terapiaTiroidea",terapiaTiroideaText);
        Utils.setProperty(prop,"antineopasics",antineopasicsText);
        Utils.setProperty(prop,"antiinflamatoris",antiinflamatorisText);
        Utils.setProperty(prop,"analgesics",analgesicsText);
        Utils.setProperty(prop,"broncodilatadors",broncodilatadorsText);
        Utils.setProperty(prop,"oftalmologics",oftalmologicsText);

        // Afegeix dates (introduit mes tard)
        Utils.setProperty(prop,"hipertensioData",hipertensioDate);
        Utils.setProperty(prop,"insuficienciaCardiacaData",insuficienciaCardiacaDate);
        Utils.setProperty(prop,"infartData",infartDate);
        Utils.setProperty(prop,"cardiopatiaData",cardiopatiaDate);
        Utils.setProperty(prop,"arritmiaData",arritmiaDate);
        Utils.setProperty(prop,"malaltiaVascularData",malaltiaVascularDate);
        Utils.setProperty(prop,"diabetisData",diabetisDate);
        Utils.setProperty(prop,"obesitatData",obesitatDate);
        Utils.setProperty(prop,"dislipemiaData",dislipemiaDate);
        Utils.setProperty(prop,"patologiaTiroidesData",patologiaTiroidesDate);
        Utils.setProperty(prop,"ulcusData",ulcusDate);
        Utils.setProperty(prop,"gastritisData",gastritisDate);
        Utils.setProperty(prop,"colelitiasisData",colelitiasisDate);
        Utils.setProperty(prop,"hepatopatiaData",hepatopatiaDate);
        Utils.setProperty(prop,"depresioData",depresioDate);
        Utils.setProperty(prop,"ansietatData",ansietatDate);
        Utils.setProperty(prop,"psicosisData",psicosisDate);
        Utils.setProperty(prop,"abusAlcoholData",abusAlcoholDate);
        Utils.setProperty(prop,"abusDroguesData",abusDroguesDate);
        Utils.setProperty(prop,"avcEstablertData",avcEstablertDate);
        Utils.setProperty(prop,"avcTransitoriData",avcTransitoriDate);
        Utils.setProperty(prop,"epilepsiaData",epilepsiaDate);
        Utils.setProperty(prop,"traumaCranealData",traumaCranealDate);
        Utils.setProperty(prop,"malaltiaParkinsonData",malaltiaParkinsonDate);
        Utils.setProperty(prop,"esclerosisData",esclerosisDate);
        Utils.setProperty(prop,"cefaleaData",cefaleaDate);
        Utils.setProperty(prop,"asmaData",asmaDate);
        Utils.setProperty(prop,"epocData",epocDate);
        Utils.setProperty(prop,"anemiaData",anemiaDate);
        Utils.setProperty(prop,"leucosisData",leucosisDate);
        Utils.setProperty(prop,"alergiaData",alergiaDate);
        Utils.setProperty(prop,"glaucomaData",glaucomaDate);
        Utils.setProperty(prop,"cataractesData",cataractesDate);
        Utils.setProperty(prop,"insuficienciaRenalData",insuficienciaRenalDate);
        Utils.setProperty(prop,"incontinenciaData",incontinenciaDate);
        Utils.setProperty(prop,"artrosiData",artrosiDate);
        Utils.setProperty(prop,"artritisData",artritisDate);
        Utils.setProperty(prop,"fibromialgiaData",fibromialgiaDate);
        Utils.setProperty(prop,"benigneData",benigneDate);
        Utils.setProperty(prop,"maligneData",maligneDate);
    }

    @Override
    public void carregar(Properties prop) {
        // Carrega les dades mediques
        Utils.getProperty(prop,"alzheimer",alzheimerCombo);
        Utils.getProperty(prop,"parkinson",parkinsonCombo);
        Utils.getProperty(prop,"sindromeDown",sindromeDownCombo);
        Utils.getProperty(prop,"altresDemencies",altresDemenciesText);
        Utils.getProperty(prop,"antecedentsPare",antecedentsPareText);
        Utils.getProperty(prop,"antecedentsMare",antecedentsMareText);
        Utils.getProperty(prop,"altresFamiliars",altresFamiliarsText);

        Utils.getProperty(prop,"cafe",cafeText);
        Utils.getProperty(prop,"tabac",tabacText);
        Utils.getProperty(prop,"alcohol",alcoholText);
        Utils.getProperty(prop,"cannabis",cannabisCombo);
        Utils.getProperty(prop,"toxicsLaborals",toxicsLaboralsText);
        Utils.getProperty(prop,"antecedentsPersonals",antecedentsPersonalsText);

        Utils.getProperty(prop,"hipertensio",hipertensioCombo);
        Utils.getProperty(prop,"insuficienciaCardiaca",insuficienciaCardiacaCombo);
        Utils.getProperty(prop,"infart",infartCombo);
        Utils.getProperty(prop,"cardiopatia",cardiopatiaCombo);
        Utils.getProperty(prop,"arritmia",arritmiaCombo);
        Utils.getProperty(prop,"malaltiaVascularPeriferica",malaltiaVascularCombo);

        Utils.getProperty(prop,"diabetis",diabetisCombo);
        Utils.getProperty(prop,"obesitat",obesitatCombo);
        Utils.getProperty(prop,"dislipemia",dislipemiaCombo);
        Utils.getProperty(prop,"patologiaTiroides",patologiaTiroidesCombo);

        Utils.getProperty(prop,"ulcus",ulcusCombo);
        Utils.getProperty(prop,"gastritis",gastritisCombo);
        Utils.getProperty(prop,"colelitiasis",colelitiasisCombo);
        Utils.getProperty(prop,"hepatopatia",hepatopatiaCombo);

        Utils.getProperty(prop,"depresio",depresioCombo);
        Utils.getProperty(prop,"ansietat",ansietatCombo);
        Utils.getProperty(prop,"psicosis",psicosisCombo);
        Utils.getProperty(prop,"abusAlcohol",abusAlcoholCombo);
        Utils.getProperty(prop,"abusDrogues",abusDroguesCombo);

        Utils.getProperty(prop,"avcEstablert",avcEstablertCombo);
        Utils.getProperty(prop,"avcTransitori",avcTransitoriCombo);
        Utils.getProperty(prop,"epilepsia",epilepsiaCombo);
        Utils.getProperty(prop,"traumaCraneal",traumaCranealCombo);
        Utils.getProperty(prop,"malaltiaParkinson",malaltiaParkinsonCombo);
        Utils.getProperty(prop,"esclerosis",esclerosisCombo);
        Utils.getProperty(prop,"cefalea",cefaleaCombo);

        Utils.getProperty(prop,"asma",asmaCombo);
        Utils.getProperty(prop,"epoc",epocCombo);

        Utils.getProperty(prop,"anemia",anemiaCombo);
        Utils.getProperty(prop,"leucosis",leucosisCombo);

        Utils.getProperty(prop,"alergia",alergiaCombo);

        Utils.getProperty(prop,"glaucoma",glaucomaCombo);
        Utils.getProperty(prop,"cataractes",cataractesCombo);

        Utils.getProperty(prop,"insuficienciaRenal",insuficienciaRenalCombo);
        Utils.getProperty(prop,"incontinencia",incontinenciaCombo);

        Utils.getProperty(prop,"artrosi",artrosiCombo);
        Utils.getProperty(prop,"artritis",artritisCombo);
        Utils.getProperty(prop,"fibromialgia",fibromialgiaCombo);

        Utils.getProperty(prop,"benigne",benigneCombo);
        Utils.getProperty(prop,"maligne",maligneCombo);

        Utils.getProperty(prop,"ansiolitics",ansioliticsText);
        Utils.getProperty(prop,"hipnotics",hipnoticsText);
        Utils.getProperty(prop,"antidepresius",antidepresiusText);
        Utils.getProperty(prop,"antimaniacs",antimaniacsText);
        Utils.getProperty(prop,"antipsicotics",antipsicoticsText);
        Utils.getProperty(prop,"antimigranyosos",antimigranyososText);
        Utils.getProperty(prop,"opioides",opioidesText);
        Utils.getProperty(prop,"antiepileptics",antiepilepticsText);
        Utils.getProperty(prop,"antiparkinsonians",antiparkinsoniansText);
        Utils.getProperty(prop,"musculEstriat",musculEstriatText);
        Utils.getProperty(prop,"vasodilatadors",vasodilatadorsText);
        Utils.getProperty(prop,"ACEsterasa",ACEsterasaText);
        Utils.getProperty(prop,"memantina",memantinaText);
        Utils.getProperty(prop,"psicoestimulants",psicoestimulantsText);
        Utils.getProperty(prop,"substanciesAbus",substanciesAbusText);
        Utils.getProperty(prop,"deshabituacio",deshabituacioText);

        Utils.getProperty(prop,"antiacids",antiacidsText);
        Utils.getProperty(prop,"antidiabetics",antidiabeticsText);
        Utils.getProperty(prop,"antitrombotics",antitromboticsText);
        Utils.getProperty(prop,"antiagregants",antiagregantsText);
        Utils.getProperty(prop,"cardiotonics",cardiotonicsText);
        Utils.getProperty(prop,"antihipertensius",antihipertensiusText);
        Utils.getProperty(prop,"diuretics",diureticsText);
        Utils.getProperty(prop,"hipolipemiants",hipolipemiantsText);
        Utils.getProperty(prop,"dermatologics",dermatologicsText);
        Utils.getProperty(prop,"hormones",hormonesText);
        Utils.getProperty(prop,"urologics",urologicsText);
        Utils.getProperty(prop,"corticosteroides",corticosteroidesText);
        Utils.getProperty(prop,"terapiaTiroidea",terapiaTiroideaText);
        Utils.getProperty(prop,"antineopasics",antineopasicsText);
        Utils.getProperty(prop,"antiinflamatoris",antiinflamatorisText);
        Utils.getProperty(prop,"analgesics",analgesicsText);
        Utils.getProperty(prop,"broncodilatadors",broncodilatadorsText);
        Utils.getProperty(prop,"oftalmologics",oftalmologicsText);

        Utils.getProperty(prop,"hipertensioData",hipertensioDate);
        Utils.getProperty(prop,"insuficienciaCardiacaData",insuficienciaCardiacaDate);
        Utils.getProperty(prop,"infartData",infartDate);
        Utils.getProperty(prop,"cardiopatiaData",cardiopatiaDate);
        Utils.getProperty(prop,"arritmiaData",arritmiaDate);
        Utils.getProperty(prop,"malaltiaVascularData",malaltiaVascularDate);
        Utils.getProperty(prop,"diabetisData",diabetisDate);
        Utils.getProperty(prop,"obesitatData",obesitatDate);
        Utils.getProperty(prop,"dislipemiaData",dislipemiaDate);
        Utils.getProperty(prop,"patologiaTiroidesData",patologiaTiroidesDate);
        Utils.getProperty(prop,"ulcusData",ulcusDate);
        Utils.getProperty(prop,"gastritisData",gastritisDate);
        Utils.getProperty(prop,"colelitiasisData",colelitiasisDate);
        Utils.getProperty(prop,"hepatopatiaData",hepatopatiaDate);
        Utils.getProperty(prop,"depresioData",depresioDate);
        Utils.getProperty(prop,"ansietatData",ansietatDate);
        Utils.getProperty(prop,"psicosisData",psicosisDate);
        Utils.getProperty(prop,"abusAlcoholData",abusAlcoholDate);
        Utils.getProperty(prop,"abusDroguesData",abusDroguesDate);
        Utils.getProperty(prop,"avcEstablertData",avcEstablertDate);
        Utils.getProperty(prop,"avcTransitoriData",avcTransitoriDate);
        Utils.getProperty(prop,"epilepsiaData",epilepsiaDate);
        Utils.getProperty(prop,"traumaCranealData",traumaCranealDate);
        Utils.getProperty(prop,"malaltiaParkinsonData",malaltiaParkinsonDate);
        Utils.getProperty(prop,"esclerosisData",esclerosisDate);
        Utils.getProperty(prop,"cefaleaData",cefaleaDate);
        Utils.getProperty(prop,"asmaData",asmaDate);
        Utils.getProperty(prop,"epocData",epocDate);
        Utils.getProperty(prop,"anemiaData",anemiaDate);
        Utils.getProperty(prop,"leucosisData",leucosisDate);
        Utils.getProperty(prop,"alergiaData",alergiaDate);
        Utils.getProperty(prop,"glaucomaData",glaucomaDate);
        Utils.getProperty(prop,"cataractesData",cataractesDate);
        Utils.getProperty(prop,"insuficienciaRenalData",insuficienciaRenalDate);
        Utils.getProperty(prop,"incontinenciaData",incontinenciaDate);
        Utils.getProperty(prop,"artrosiData",artrosiDate);
        Utils.getProperty(prop,"artritisData",artritisDate);
        Utils.getProperty(prop,"fibromialgiaData",fibromialgiaDate);
        Utils.getProperty(prop,"benigneData",benigneDate);
        Utils.getProperty(prop,"maligneData",maligneDate);
    }

    private void initCombos() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                if (cb.getSelectedIndex() == 0){
                    dateMap.get(cb).setVisible(true);
                }
                else {
                    dateMap.get(cb).setVisible(false);
                }
            }
        };
        hipertensioCombo.addActionListener(action);
        insuficienciaCardiacaCombo.addActionListener(action);
        infartCombo.addActionListener(action);
        cardiopatiaCombo.addActionListener(action);
        arritmiaCombo.addActionListener(action);
        malaltiaVascularCombo.addActionListener(action);
        diabetisCombo.addActionListener(action);
        obesitatCombo.addActionListener(action);
        dislipemiaCombo.addActionListener(action);
        patologiaTiroidesCombo.addActionListener(action);
        ulcusCombo.addActionListener(action);
        gastritisCombo.addActionListener(action);
        colelitiasisCombo.addActionListener(action);
        hepatopatiaCombo.addActionListener(action);
        depresioCombo.addActionListener(action);
        ansietatCombo.addActionListener(action);
        psicosisCombo.addActionListener(action);
        abusAlcoholCombo.addActionListener(action);
        abusDroguesCombo.addActionListener(action);
        avcEstablertCombo.addActionListener(action);
        avcTransitoriCombo.addActionListener(action);
        epilepsiaCombo.addActionListener(action);
        traumaCranealCombo.addActionListener(action);
        malaltiaParkinsonCombo.addActionListener(action);
        esclerosisCombo.addActionListener(action);
        cefaleaCombo.addActionListener(action);
        asmaCombo.addActionListener(action);
        epocCombo.addActionListener(action);
        anemiaCombo.addActionListener(action);
        leucosisCombo.addActionListener(action);
        alergiaCombo.addActionListener(action);
        glaucomaCombo.addActionListener(action);
        cataractesCombo.addActionListener(action);
        insuficienciaRenalCombo.addActionListener(action);
        incontinenciaCombo.addActionListener(action);
        artrosiCombo.addActionListener(action);
        artritisCombo.addActionListener(action);
        fibromialgiaCombo.addActionListener(action);
        benigneCombo.addActionListener(action);
        maligneCombo.addActionListener(action);
    }
    
    private void initDateMap() {
        dateMap = new HashMap<JComboBox, JDateChooser>();
        dateMap.put(hipertensioCombo, hipertensioDate);
        dateMap.put(insuficienciaCardiacaCombo, insuficienciaCardiacaDate);
        dateMap.put(infartCombo, infartDate);
        dateMap.put(cardiopatiaCombo, cardiopatiaDate);
        dateMap.put(arritmiaCombo, arritmiaDate);
        dateMap.put(malaltiaVascularCombo, malaltiaVascularDate);

        dateMap.put(diabetisCombo, diabetisDate);
        dateMap.put(obesitatCombo, obesitatDate);
        dateMap.put(dislipemiaCombo, dislipemiaDate);
        dateMap.put(patologiaTiroidesCombo, patologiaTiroidesDate);

        dateMap.put(ulcusCombo, ulcusDate);
        dateMap.put(gastritisCombo, gastritisDate);
        dateMap.put(colelitiasisCombo, colelitiasisDate);
        dateMap.put(hepatopatiaCombo, hepatopatiaDate);

        dateMap.put(depresioCombo, depresioDate);
        dateMap.put(ansietatCombo, ansietatDate);
        dateMap.put(psicosisCombo, psicosisDate);
        dateMap.put(abusAlcoholCombo, abusAlcoholDate);
        dateMap.put(abusDroguesCombo, abusDroguesDate);

        dateMap.put(avcEstablertCombo, avcEstablertDate);
        dateMap.put(avcTransitoriCombo, avcTransitoriDate);
        dateMap.put(epilepsiaCombo, epilepsiaDate);
        dateMap.put(traumaCranealCombo, traumaCranealDate);
        dateMap.put(malaltiaParkinsonCombo, malaltiaParkinsonDate);
        dateMap.put(esclerosisCombo, esclerosisDate);
        dateMap.put(cefaleaCombo, cefaleaDate);

        dateMap.put(asmaCombo, asmaDate);
        dateMap.put(epocCombo, epocDate);

        dateMap.put(anemiaCombo, anemiaDate);
        dateMap.put(leucosisCombo, leucosisDate);

        dateMap.put(alergiaCombo, alergiaDate);

        dateMap.put(glaucomaCombo, glaucomaDate);
        dateMap.put(cataractesCombo, cataractesDate);

        dateMap.put(insuficienciaRenalCombo, insuficienciaRenalDate);
        dateMap.put(incontinenciaCombo, incontinenciaDate);

        dateMap.put(artrosiCombo, artrosiDate);
        dateMap.put(artritisCombo, artritisDate);
        dateMap.put(fibromialgiaCombo, fibromialgiaDate);

        dateMap.put(benigneCombo, benigneDate);
        dateMap.put(maligneCombo, maligneDate);

        //Iterator it = dateMap.entrySet().iterator();
        /*
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            dateMap.get((JComboBox)pair.getKey()).setVisible(false);
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dadesMediquesScroll = new javax.swing.JScrollPane();
        dadesMediquesPanel = new javax.swing.JPanel();
        antecedentsFamiliarsPanel = new javax.swing.JPanel();
        alzheimerLabel = new javax.swing.JLabel();
        parkinsonLabel = new javax.swing.JLabel();
        sindromeDownLabel = new javax.swing.JLabel();
        altresDemenciesLabel = new javax.swing.JLabel();
        antecedentsPareLabel = new javax.swing.JLabel();
        antecedentsMareLabel = new javax.swing.JLabel();
        altresFamiliarsLabel = new javax.swing.JLabel();
        alzheimerCombo = new javax.swing.JComboBox<>();
        parkinsonCombo = new javax.swing.JComboBox<>();
        sindromeDownCombo = new javax.swing.JComboBox<>();
        altresDemenciesText = new javax.swing.JTextField();
        antecedentsPareText = new javax.swing.JTextField();
        antecedentsMareText = new javax.swing.JTextField();
        altresFamiliarsText = new javax.swing.JTextField();
        dadesCliniquesPanel1 = new javax.swing.JPanel();
        cafeLabel = new javax.swing.JLabel();
        tabacLabel = new javax.swing.JLabel();
        alcoholLabel = new javax.swing.JLabel();
        cannabisLabel = new javax.swing.JLabel();
        toxicsLaboralsLabel = new javax.swing.JLabel();
        antecedentsPersonalsLabel = new javax.swing.JLabel();
        cafeText = new javax.swing.JTextField();
        tabacText = new javax.swing.JTextField();
        alcoholText = new javax.swing.JTextField();
        cannabisCombo = new javax.swing.JComboBox<>();
        toxicsLaboralsText = new javax.swing.JTextField();
        antecedentsPersonalsText = new javax.swing.JTextField();
        cafeCheck = new javax.swing.JLabel();
        tabacCheck = new javax.swing.JLabel();
        alcoholCheck = new javax.swing.JLabel();
        antecedentsPatologicsPersonalsPanel = new javax.swing.JPanel();
        cardiovascularPanel = new javax.swing.JPanel();
        hipertensioLabel = new javax.swing.JLabel();
        insuficienciaCardiacaLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hipertensioCombo = new javax.swing.JComboBox<>();
        insuficienciaCardiacaCombo = new javax.swing.JComboBox<>();
        infartCombo = new javax.swing.JComboBox<>();
        cardiopatiaCombo = new javax.swing.JComboBox<>();
        arritmiaCombo = new javax.swing.JComboBox<>();
        malaltiaVascularCombo = new javax.swing.JComboBox<>();
        hipertensioDate = new com.toedter.calendar.JDateChooser();
        insuficienciaCardiacaDate = new com.toedter.calendar.JDateChooser();
        infartDate = new com.toedter.calendar.JDateChooser();
        cardiopatiaDate = new com.toedter.calendar.JDateChooser();
        arritmiaDate = new com.toedter.calendar.JDateChooser();
        malaltiaVascularDate = new com.toedter.calendar.JDateChooser();
        endocrinoMetabolicPanel = new javax.swing.JPanel();
        diabetisLabel = new javax.swing.JLabel();
        obesitatLabel = new javax.swing.JLabel();
        dislipemiaLabel = new javax.swing.JLabel();
        patologiaTiroidesLabel = new javax.swing.JLabel();
        diabetisCombo = new javax.swing.JComboBox<>();
        obesitatCombo = new javax.swing.JComboBox<>();
        dislipemiaCombo = new javax.swing.JComboBox<>();
        patologiaTiroidesCombo = new javax.swing.JComboBox<>();
        diabetisDate = new com.toedter.calendar.JDateChooser();
        obesitatDate = new com.toedter.calendar.JDateChooser();
        dislipemiaDate = new com.toedter.calendar.JDateChooser();
        patologiaTiroidesDate = new com.toedter.calendar.JDateChooser();
        digestiuPanel = new javax.swing.JPanel();
        ulcusLabel = new javax.swing.JLabel();
        gastritisLabel = new javax.swing.JLabel();
        colelitiasisLabel = new javax.swing.JLabel();
        hepatopatiaLabel = new javax.swing.JLabel();
        ulcusCombo = new javax.swing.JComboBox<>();
        gastritisCombo = new javax.swing.JComboBox<>();
        colelitiasisCombo = new javax.swing.JComboBox<>();
        hepatopatiaCombo = new javax.swing.JComboBox<>();
        ulcusDate = new com.toedter.calendar.JDateChooser();
        gastritisDate = new com.toedter.calendar.JDateChooser();
        colelitiasisDate = new com.toedter.calendar.JDateChooser();
        hepatopatiaDate = new com.toedter.calendar.JDateChooser();
        psiquiatricPanel = new javax.swing.JPanel();
        depresioLabel = new javax.swing.JLabel();
        ansietatLabel = new javax.swing.JLabel();
        psicosisLabel = new javax.swing.JLabel();
        abusAlcoholLabel = new javax.swing.JLabel();
        abusDroguesLabel = new javax.swing.JLabel();
        depresioCombo = new javax.swing.JComboBox<>();
        ansietatCombo = new javax.swing.JComboBox<>();
        psicosisCombo = new javax.swing.JComboBox<>();
        abusAlcoholCombo = new javax.swing.JComboBox<>();
        abusDroguesCombo = new javax.swing.JComboBox<>();
        depresioDate = new com.toedter.calendar.JDateChooser();
        ansietatDate = new com.toedter.calendar.JDateChooser();
        psicosisDate = new com.toedter.calendar.JDateChooser();
        abusAlcoholDate = new com.toedter.calendar.JDateChooser();
        abusDroguesDate = new com.toedter.calendar.JDateChooser();
        cardiovascularPanel1 = new javax.swing.JPanel();
        avcEstablertLabel = new javax.swing.JLabel();
        avcTransitoriLabel = new javax.swing.JLabel();
        epilepsiaLabel = new javax.swing.JLabel();
        traumaCranealLabel = new javax.swing.JLabel();
        malaltiaParkinson = new javax.swing.JLabel();
        esclerosisLabel = new javax.swing.JLabel();
        cefaleaLabel = new javax.swing.JLabel();
        avcEstablertCombo = new javax.swing.JComboBox<>();
        avcTransitoriCombo = new javax.swing.JComboBox<>();
        epilepsiaCombo = new javax.swing.JComboBox<>();
        traumaCranealCombo = new javax.swing.JComboBox<>();
        malaltiaParkinsonCombo = new javax.swing.JComboBox<>();
        esclerosisCombo = new javax.swing.JComboBox<>();
        cefaleaCombo = new javax.swing.JComboBox<>();
        avcEstablertDate = new com.toedter.calendar.JDateChooser();
        avcTransitoriDate = new com.toedter.calendar.JDateChooser();
        epilepsiaDate = new com.toedter.calendar.JDateChooser();
        traumaCranealDate = new com.toedter.calendar.JDateChooser();
        malaltiaParkinsonDate = new com.toedter.calendar.JDateChooser();
        esclerosisDate = new com.toedter.calendar.JDateChooser();
        cefaleaDate = new com.toedter.calendar.JDateChooser();
        respiratoriPanel = new javax.swing.JPanel();
        asmaLabel = new javax.swing.JLabel();
        epocLabel = new javax.swing.JLabel();
        asmaCombo = new javax.swing.JComboBox<>();
        epocCombo = new javax.swing.JComboBox<>();
        asmaDate = new com.toedter.calendar.JDateChooser();
        epocDate = new com.toedter.calendar.JDateChooser();
        hematologicPanel = new javax.swing.JPanel();
        anemiaLabel = new javax.swing.JLabel();
        leucosisLabel = new javax.swing.JLabel();
        anemiaCombo = new javax.swing.JComboBox<>();
        leucosisCombo = new javax.swing.JComboBox<>();
        anemiaDate = new com.toedter.calendar.JDateChooser();
        leucosisDate = new com.toedter.calendar.JDateChooser();
        immunologicPanel = new javax.swing.JPanel();
        alergiaLabel = new javax.swing.JLabel();
        alergiaCombo = new javax.swing.JComboBox<>();
        alergiaDate = new com.toedter.calendar.JDateChooser();
        oftalmologicPanel = new javax.swing.JPanel();
        glaucomaLabel = new javax.swing.JLabel();
        cataractesLabel = new javax.swing.JLabel();
        glaucomaCombo = new javax.swing.JComboBox<>();
        cataractesCombo = new javax.swing.JComboBox<>();
        glaucomaDate = new com.toedter.calendar.JDateChooser();
        cataractesDate = new com.toedter.calendar.JDateChooser();
        genitoUrinariPanel = new javax.swing.JPanel();
        insuficienciaRenalLabel = new javax.swing.JLabel();
        incontinenciaLabel = new javax.swing.JLabel();
        insuficienciaRenalCombo = new javax.swing.JComboBox<>();
        incontinenciaCombo = new javax.swing.JComboBox<>();
        insuficienciaRenalDate = new com.toedter.calendar.JDateChooser();
        incontinenciaDate = new com.toedter.calendar.JDateChooser();
        musculoEsqueleticPanel = new javax.swing.JPanel();
        artrosiLabel = new javax.swing.JLabel();
        artritisLabel = new javax.swing.JLabel();
        fibromialgiaLabel = new javax.swing.JLabel();
        artrosiCombo = new javax.swing.JComboBox<>();
        artritisCombo = new javax.swing.JComboBox<>();
        fibromialgiaCombo = new javax.swing.JComboBox<>();
        artrosiDate = new com.toedter.calendar.JDateChooser();
        artritisDate = new com.toedter.calendar.JDateChooser();
        fibromialgiaDate = new com.toedter.calendar.JDateChooser();
        neoplassicCombo = new javax.swing.JPanel();
        benigneLabel = new javax.swing.JLabel();
        maligneLabel = new javax.swing.JLabel();
        benigneCombo = new javax.swing.JComboBox<>();
        maligneCombo = new javax.swing.JComboBox<>();
        benigneDate = new com.toedter.calendar.JDateChooser();
        maligneDate = new com.toedter.calendar.JDateChooser();
        tractamentActualPanel = new javax.swing.JPanel();
        sistemaNerviosPanel = new javax.swing.JPanel();
        ansioliticsLabel = new javax.swing.JLabel();
        ansioliticsText = new javax.swing.JTextField();
        hipnoticsLabel = new javax.swing.JLabel();
        hipnoticsText = new javax.swing.JTextField();
        antidepresiusLabel = new javax.swing.JLabel();
        antidepresiusText = new javax.swing.JTextField();
        antimaniacsLabel = new javax.swing.JLabel();
        antimaniacsText = new javax.swing.JTextField();
        antipsicoticsLabel = new javax.swing.JLabel();
        antipsicoticsText = new javax.swing.JTextField();
        antimigranyososLabel = new javax.swing.JLabel();
        antimigranyososText = new javax.swing.JTextField();
        opioidesLabel = new javax.swing.JLabel();
        opioidesText = new javax.swing.JTextField();
        antiepilepticsLabel = new javax.swing.JLabel();
        antiepilepticsText = new javax.swing.JTextField();
        antiparkinsoniansLabel = new javax.swing.JLabel();
        antiparkinsoniansText = new javax.swing.JTextField();
        musculEstriatLabel = new javax.swing.JLabel();
        musculEstriatText = new javax.swing.JTextField();
        vasodilatadorsLabel = new javax.swing.JLabel();
        vasodilatadorsText = new javax.swing.JTextField();
        ACEsterasaLabel = new javax.swing.JLabel();
        ACEsterasaText = new javax.swing.JTextField();
        memantinaLabel = new javax.swing.JLabel();
        memantinaText = new javax.swing.JTextField();
        psicoestimulantsLabel = new javax.swing.JLabel();
        psicoestimulantsText = new javax.swing.JTextField();
        substanciesAbusLabel = new javax.swing.JLabel();
        substanciesAbusText = new javax.swing.JTextField();
        deshabituacioLabel = new javax.swing.JLabel();
        deshabituacioText = new javax.swing.JTextField();
        altresFarmacsPanel = new javax.swing.JPanel();
        antiacidsLabel = new javax.swing.JLabel();
        antiacidsText = new javax.swing.JTextField();
        antidiabeticsLabel = new javax.swing.JLabel();
        antidiabeticsText = new javax.swing.JTextField();
        AntitromboticsLabel = new javax.swing.JLabel();
        antitromboticsText = new javax.swing.JTextField();
        antiagregantsLabel = new javax.swing.JLabel();
        antiagregantsText = new javax.swing.JTextField();
        cardiotonicsLabel = new javax.swing.JLabel();
        cardiotonicsText = new javax.swing.JTextField();
        antihipertensiusLabel = new javax.swing.JLabel();
        antihipertensiusText = new javax.swing.JTextField();
        diureticsLabel = new javax.swing.JLabel();
        diureticsText = new javax.swing.JTextField();
        hipolipemiantsLabel = new javax.swing.JLabel();
        hipolipemiantsText = new javax.swing.JTextField();
        dermatologicsLabel = new javax.swing.JLabel();
        dermatologicsText = new javax.swing.JTextField();
        hormonesLabel = new javax.swing.JLabel();
        hormonesText = new javax.swing.JTextField();
        urologicsLabel = new javax.swing.JLabel();
        urologicsText = new javax.swing.JTextField();
        corticosteroidesLabel = new javax.swing.JLabel();
        corticosteroidesText = new javax.swing.JTextField();
        terapiaTiroideaLabel = new javax.swing.JLabel();
        terapiaTiroideaText = new javax.swing.JTextField();
        antineopasicsLabel = new javax.swing.JLabel();
        antineopasicsText = new javax.swing.JTextField();
        antiinflamatorisLabel = new javax.swing.JLabel();
        antiinflamatorisText = new javax.swing.JTextField();
        analgesicsLabel = new javax.swing.JLabel();
        analgesicsText = new javax.swing.JTextField();
        broncodilatadorsLabel = new javax.swing.JLabel();
        broncodilatadorsText = new javax.swing.JTextField();
        oftalmologicsLabel = new javax.swing.JLabel();
        oftalmologicsText = new javax.swing.JTextField();

        antecedentsFamiliarsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedents familiars"));

        alzheimerLabel.setText("Malaltia d'Alzheimer:");

        parkinsonLabel.setText("Malaltia de Parkinson:");

        sindromeDownLabel.setText("Sindrome de Down:");

        altresDemenciesLabel.setText("Altres demències:");

        antecedentsPareLabel.setText("Antecedents del pare:");

        antecedentsMareLabel.setText("Antecedents de la mare:");

        altresFamiliarsLabel.setText("Altres familiars:");

        alzheimerCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        alzheimerCombo.setSelectedIndex(-1);

        parkinsonCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        parkinsonCombo.setSelectedIndex(-1);

        sindromeDownCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        sindromeDownCombo.setSelectedIndex(-1);

        javax.swing.GroupLayout antecedentsFamiliarsPanelLayout = new javax.swing.GroupLayout(antecedentsFamiliarsPanel);
        antecedentsFamiliarsPanel.setLayout(antecedentsFamiliarsPanelLayout);
        antecedentsFamiliarsPanelLayout.setHorizontalGroup(
            antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                        .addComponent(antecedentsPareLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antecedentsPareText))
                    .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                        .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                                .addComponent(parkinsonLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(parkinsonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                                .addComponent(alzheimerLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alzheimerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                                .addComponent(sindromeDownLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sindromeDownCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                        .addComponent(altresDemenciesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(altresDemenciesText))
                    .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                        .addComponent(antecedentsMareLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antecedentsMareText))
                    .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                        .addComponent(altresFamiliarsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(altresFamiliarsText)))
                .addContainerGap())
        );
        antecedentsFamiliarsPanelLayout.setVerticalGroup(
            antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antecedentsFamiliarsPanelLayout.createSequentialGroup()
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alzheimerLabel)
                    .addComponent(alzheimerCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(parkinsonLabel)
                    .addComponent(parkinsonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sindromeDownLabel)
                    .addComponent(sindromeDownCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altresDemenciesLabel)
                    .addComponent(altresDemenciesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antecedentsPareLabel)
                    .addComponent(antecedentsPareText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antecedentsMareLabel)
                    .addComponent(antecedentsMareText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(antecedentsFamiliarsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(altresFamiliarsLabel)
                    .addComponent(altresFamiliarsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dadesCliniquesPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dades clíniques"));

        cafeLabel.setText("Cafè i te (núm. tasses/dia):");

        tabacLabel.setText("Tabac (núm paquets/any):");

        alcoholLabel.setText("Alcohol (núm. grams/dia):");

        cannabisLabel.setText("Cannabis:");

        toxicsLaboralsLabel.setText("Feina i tòxics laborals:");

        antecedentsPersonalsLabel.setText("Altres antecedents personals:");

        cannabisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        cannabisCombo.setSelectedIndex(-1);

        cafeCheck.setText("No");

        tabacCheck.setText("No");

        alcoholCheck.setText("No");

        javax.swing.GroupLayout dadesCliniquesPanel1Layout = new javax.swing.GroupLayout(dadesCliniquesPanel1);
        dadesCliniquesPanel1.setLayout(dadesCliniquesPanel1Layout);
        dadesCliniquesPanel1Layout.setHorizontalGroup(
            dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                        .addComponent(toxicsLaboralsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toxicsLaboralsText))
                    .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                        .addComponent(antecedentsPersonalsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(antecedentsPersonalsText))
                    .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                        .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadesCliniquesPanel1Layout.createSequentialGroup()
                                        .addComponent(alcoholLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(alcoholText))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dadesCliniquesPanel1Layout.createSequentialGroup()
                                        .addComponent(tabacLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tabacText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tabacCheck)
                                    .addComponent(alcoholCheck)))
                            .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                                .addComponent(cannabisLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cannabisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                                .addComponent(cafeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cafeText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cafeCheck)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        dadesCliniquesPanel1Layout.setVerticalGroup(
            dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesCliniquesPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cafeLabel)
                    .addComponent(cafeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cafeCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabacLabel)
                    .addComponent(tabacText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tabacCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alcoholLabel)
                    .addComponent(alcoholText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alcoholCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cannabisLabel)
                    .addComponent(cannabisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toxicsLaboralsLabel)
                    .addComponent(toxicsLaboralsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dadesCliniquesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antecedentsPersonalsLabel)
                    .addComponent(antecedentsPersonalsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        antecedentsPatologicsPersonalsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Antecedents patològics personals "));

        cardiovascularPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cardiovascular"));

        hipertensioLabel.setText("Hipertensió:");

        insuficienciaCardiacaLabel.setText("Insuficiència cardiaca:");

        jLabel1.setText("Infart de miocardi:");

        jLabel2.setText("Cardiopatia isquèmica:");

        jLabel3.setText("Arritmia:");

        jLabel4.setText("Malaltia vascular perifèrica arterial:");

        hipertensioCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        hipertensioCombo.setSelectedIndex(-1);

        insuficienciaCardiacaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        insuficienciaCardiacaCombo.setSelectedIndex(-1);

        infartCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        infartCombo.setSelectedIndex(-1);

        cardiopatiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        cardiopatiaCombo.setSelectedIndex(-1);

        arritmiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        arritmiaCombo.setSelectedIndex(-1);

        malaltiaVascularCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        malaltiaVascularCombo.setSelectedIndex(-1);

        hipertensioDate.setDateFormatString("dd/MM/yyyy");

        insuficienciaCardiacaDate.setDateFormatString("dd/MM/yyyy");

        infartDate.setDateFormatString("dd/MM/yyyy");

        cardiopatiaDate.setDateFormatString("dd/MM/yyyy");

        arritmiaDate.setDateFormatString("dd/MM/yyyy");

        malaltiaVascularDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout cardiovascularPanelLayout = new javax.swing.GroupLayout(cardiovascularPanel);
        cardiovascularPanel.setLayout(cardiovascularPanelLayout);
        cardiovascularPanelLayout.setHorizontalGroup(
            cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(hipertensioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hipertensioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hipertensioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(insuficienciaCardiacaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insuficienciaCardiacaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insuficienciaCardiacaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infartCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(infartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardiopatiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardiopatiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(arritmiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(arritmiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(malaltiaVascularCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(malaltiaVascularDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        cardiovascularPanelLayout.setVerticalGroup(
            cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardiovascularPanelLayout.createSequentialGroup()
                        .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hipertensioLabel)
                                .addComponent(hipertensioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hipertensioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insuficienciaCardiacaLabel)
                            .addComponent(insuficienciaCardiacaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(insuficienciaCardiacaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(infartCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cardiopatiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cardiopatiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(arritmiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(arritmiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardiovascularPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(malaltiaVascularCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(malaltiaVascularDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        endocrinoMetabolicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Endocrino/Metabòlic"));

        diabetisLabel.setText("Diabètis:");

        obesitatLabel.setText("Obesitat:");

        dislipemiaLabel.setText("Dislipemia:");

        patologiaTiroidesLabel.setText("Patologia de tiroides:");

        diabetisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        diabetisCombo.setSelectedIndex(-1);

        obesitatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        obesitatCombo.setSelectedIndex(-1);

        dislipemiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        dislipemiaCombo.setSelectedIndex(-1);

        patologiaTiroidesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        patologiaTiroidesCombo.setSelectedIndex(-1);

        diabetisDate.setDateFormatString("dd/MM/yyyy");

        obesitatDate.setDateFormatString("dd/MM/yyyy");

        dislipemiaDate.setDateFormatString("dd/MM/yyyy");

        patologiaTiroidesDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout endocrinoMetabolicPanelLayout = new javax.swing.GroupLayout(endocrinoMetabolicPanel);
        endocrinoMetabolicPanel.setLayout(endocrinoMetabolicPanelLayout);
        endocrinoMetabolicPanelLayout.setHorizontalGroup(
            endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                        .addComponent(diabetisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diabetisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diabetisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                        .addComponent(obesitatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(obesitatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(obesitatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                        .addComponent(dislipemiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dislipemiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dislipemiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                        .addComponent(patologiaTiroidesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(patologiaTiroidesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(patologiaTiroidesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(213, Short.MAX_VALUE))
        );
        endocrinoMetabolicPanelLayout.setVerticalGroup(
            endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(endocrinoMetabolicPanelLayout.createSequentialGroup()
                        .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(diabetisLabel)
                                .addComponent(diabetisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(diabetisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(obesitatLabel)
                            .addComponent(obesitatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(obesitatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dislipemiaLabel)
                        .addComponent(dislipemiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dislipemiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(endocrinoMetabolicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(patologiaTiroidesLabel)
                        .addComponent(patologiaTiroidesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(patologiaTiroidesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        digestiuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Digestiu"));

        ulcusLabel.setText("Ulcus:");

        gastritisLabel.setText("Gastritis:");

        colelitiasisLabel.setText("Colelitiasis / colecistectomia:");

        hepatopatiaLabel.setText("Hepatopatia:");

        ulcusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        ulcusCombo.setSelectedIndex(-1);

        gastritisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        gastritisCombo.setSelectedIndex(-1);

        colelitiasisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        colelitiasisCombo.setSelectedIndex(-1);

        hepatopatiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        hepatopatiaCombo.setSelectedIndex(-1);

        ulcusDate.setDateFormatString("dd/MM/yyyy");

        gastritisDate.setDateFormatString("dd/MM/yyyy");

        colelitiasisDate.setDateFormatString("dd/MM/yyyy");

        hepatopatiaDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout digestiuPanelLayout = new javax.swing.GroupLayout(digestiuPanel);
        digestiuPanel.setLayout(digestiuPanelLayout);
        digestiuPanelLayout.setHorizontalGroup(
            digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digestiuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(digestiuPanelLayout.createSequentialGroup()
                        .addComponent(ulcusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ulcusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ulcusDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digestiuPanelLayout.createSequentialGroup()
                        .addComponent(gastritisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gastritisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gastritisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digestiuPanelLayout.createSequentialGroup()
                        .addComponent(colelitiasisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colelitiasisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colelitiasisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(digestiuPanelLayout.createSequentialGroup()
                        .addComponent(hepatopatiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hepatopatiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hepatopatiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(179, Short.MAX_VALUE))
        );
        digestiuPanelLayout.setVerticalGroup(
            digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(digestiuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ulcusLabel)
                        .addComponent(ulcusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ulcusDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gastritisLabel)
                        .addComponent(gastritisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gastritisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(colelitiasisLabel)
                        .addComponent(colelitiasisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colelitiasisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(digestiuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(hepatopatiaLabel)
                        .addComponent(hepatopatiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(hepatopatiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        psiquiatricPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Psiquiàtric/Abús"));

        depresioLabel.setText("Depressió:");

        ansietatLabel.setText("Ansietat:");

        psicosisLabel.setText("Psicosis:");

        abusAlcoholLabel.setText("Abús d'alcohol");

        abusDroguesLabel.setText("Abús de drogues");

        depresioCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        depresioCombo.setSelectedIndex(-1);

        ansietatCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        ansietatCombo.setSelectedIndex(-1);

        psicosisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        psicosisCombo.setSelectedIndex(-1);

        abusAlcoholCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        abusAlcoholCombo.setSelectedIndex(-1);

        abusDroguesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        abusDroguesCombo.setSelectedIndex(-1);

        depresioDate.setDateFormatString("dd/MM/yyyy");

        ansietatDate.setDateFormatString("dd/MM/yyyy");

        psicosisDate.setDateFormatString("dd/MM/yyyy");

        abusAlcoholDate.setDateFormatString("dd/MM/yyyy");

        abusDroguesDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout psiquiatricPanelLayout = new javax.swing.GroupLayout(psiquiatricPanel);
        psiquiatricPanel.setLayout(psiquiatricPanelLayout);
        psiquiatricPanelLayout.setHorizontalGroup(
            psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addComponent(depresioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depresioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(depresioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addComponent(ansietatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ansietatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ansietatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addComponent(psicosisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(psicosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(psicosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addComponent(abusAlcoholLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abusAlcoholCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abusAlcoholDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addComponent(abusDroguesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abusDroguesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(abusDroguesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(233, Short.MAX_VALUE))
        );
        psiquiatricPanelLayout.setVerticalGroup(
            psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(psiquiatricPanelLayout.createSequentialGroup()
                        .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(depresioLabel)
                                .addComponent(depresioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(depresioDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ansietatLabel)
                            .addComponent(ansietatCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ansietatDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(psicosisLabel)
                        .addComponent(psicosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(psicosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(abusAlcoholLabel)
                        .addComponent(abusAlcoholCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(abusAlcoholDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(psiquiatricPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(abusDroguesLabel)
                        .addComponent(abusDroguesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(abusDroguesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardiovascularPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Neurològic"));

        avcEstablertLabel.setText("AVC establert:");

        avcTransitoriLabel.setText("AVC transitori:");

        epilepsiaLabel.setText("Epilèpsia:");

        traumaCranealLabel.setText("Trauma craneal greu:");

        malaltiaParkinson.setText("Malaltia de Parkinson:");

        esclerosisLabel.setText("Esclerosis múltiple:");

        cefaleaLabel.setText("Cefalea:");

        avcEstablertCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        avcEstablertCombo.setSelectedIndex(-1);

        avcTransitoriCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        avcTransitoriCombo.setSelectedIndex(-1);

        epilepsiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        epilepsiaCombo.setSelectedIndex(-1);

        traumaCranealCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        traumaCranealCombo.setSelectedIndex(-1);

        malaltiaParkinsonCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        malaltiaParkinsonCombo.setSelectedIndex(-1);

        esclerosisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        esclerosisCombo.setSelectedIndex(-1);

        cefaleaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        cefaleaCombo.setSelectedIndex(-1);

        avcEstablertDate.setDateFormatString("dd/MM/yyyy");

        avcTransitoriDate.setDateFormatString("dd/MM/yyyy");

        epilepsiaDate.setDateFormatString("dd/MM/yyyy");

        traumaCranealDate.setDateFormatString("dd/MM/yyyy");

        malaltiaParkinsonDate.setDateFormatString("dd/MM/yyyy");

        esclerosisDate.setDateFormatString("dd/MM/yyyy");

        cefaleaDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout cardiovascularPanel1Layout = new javax.swing.GroupLayout(cardiovascularPanel1);
        cardiovascularPanel1.setLayout(cardiovascularPanel1Layout);
        cardiovascularPanel1Layout.setHorizontalGroup(
            cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(avcEstablertLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(avcEstablertCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avcEstablertDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(avcTransitoriLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avcTransitoriCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(avcTransitoriDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(epilepsiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(epilepsiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(epilepsiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(traumaCranealLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(traumaCranealCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(traumaCranealDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(malaltiaParkinson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(malaltiaParkinsonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(malaltiaParkinsonDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(esclerosisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(esclerosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(esclerosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addComponent(cefaleaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cefaleaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cefaleaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        cardiovascularPanel1Layout.setVerticalGroup(
            cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                        .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(cardiovascularPanel1Layout.createSequentialGroup()
                                        .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(avcEstablertLabel)
                                                .addComponent(avcEstablertCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(avcEstablertDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(avcTransitoriLabel)
                                            .addComponent(avcTransitoriCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(avcTransitoriDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(epilepsiaLabel)
                                        .addComponent(epilepsiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(epilepsiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(traumaCranealLabel)
                                        .addComponent(traumaCranealCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(traumaCranealDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(malaltiaParkinson)
                                    .addComponent(malaltiaParkinsonCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(malaltiaParkinsonDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(esclerosisLabel)
                            .addComponent(esclerosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(esclerosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cardiovascularPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cefaleaLabel)
                        .addComponent(cefaleaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cefaleaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        respiratoriPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Respiratori"));

        asmaLabel.setText("Asma:");

        epocLabel.setText("EPOC:");

        asmaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        asmaCombo.setSelectedIndex(-1);

        epocCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        epocCombo.setSelectedIndex(-1);

        asmaDate.setDateFormatString("dd/MM/yyyy");

        epocDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout respiratoriPanelLayout = new javax.swing.GroupLayout(respiratoriPanel);
        respiratoriPanel.setLayout(respiratoriPanelLayout);
        respiratoriPanelLayout.setHorizontalGroup(
            respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respiratoriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(respiratoriPanelLayout.createSequentialGroup()
                        .addComponent(asmaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(asmaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(respiratoriPanelLayout.createSequentialGroup()
                        .addComponent(epocLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(epocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(epocDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(asmaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        respiratoriPanelLayout.setVerticalGroup(
            respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(respiratoriPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(asmaLabel)
                        .addComponent(asmaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(asmaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(respiratoriPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(epocLabel)
                        .addComponent(epocCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(epocDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hematologicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Hematològic"));

        anemiaLabel.setText("Anèmia:");

        leucosisLabel.setText("Leucosis:");

        anemiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        anemiaCombo.setSelectedIndex(-1);

        leucosisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        leucosisCombo.setSelectedIndex(-1);

        anemiaDate.setDateFormatString("dd/MM/yyyy");

        leucosisDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout hematologicPanelLayout = new javax.swing.GroupLayout(hematologicPanel);
        hematologicPanel.setLayout(hematologicPanelLayout);
        hematologicPanelLayout.setHorizontalGroup(
            hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hematologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hematologicPanelLayout.createSequentialGroup()
                        .addComponent(anemiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(anemiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(anemiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(hematologicPanelLayout.createSequentialGroup()
                        .addComponent(leucosisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leucosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(leucosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        hematologicPanelLayout.setVerticalGroup(
            hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hematologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(anemiaLabel)
                        .addComponent(anemiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(anemiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(hematologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(leucosisLabel)
                        .addComponent(leucosisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(leucosisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        immunologicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Immunològic"));

        alergiaLabel.setText("Al·lèrgia");

        alergiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        alergiaCombo.setSelectedIndex(-1);

        alergiaDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout immunologicPanelLayout = new javax.swing.GroupLayout(immunologicPanel);
        immunologicPanel.setLayout(immunologicPanelLayout);
        immunologicPanelLayout.setHorizontalGroup(
            immunologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(immunologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(alergiaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alergiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alergiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        immunologicPanelLayout.setVerticalGroup(
            immunologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(immunologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(immunologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(alergiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(immunologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(alergiaLabel)
                        .addComponent(alergiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        oftalmologicPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Oftalmològic"));

        glaucomaLabel.setText("Glaucoma:");

        cataractesLabel.setText("Cataractes:");

        glaucomaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        glaucomaCombo.setSelectedIndex(-1);

        cataractesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        cataractesCombo.setSelectedIndex(-1);

        glaucomaDate.setDateFormatString("dd/MM/yyyy");

        cataractesDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout oftalmologicPanelLayout = new javax.swing.GroupLayout(oftalmologicPanel);
        oftalmologicPanel.setLayout(oftalmologicPanelLayout);
        oftalmologicPanelLayout.setHorizontalGroup(
            oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oftalmologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oftalmologicPanelLayout.createSequentialGroup()
                        .addComponent(glaucomaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(glaucomaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(glaucomaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(oftalmologicPanelLayout.createSequentialGroup()
                        .addComponent(cataractesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cataractesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cataractesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(257, Short.MAX_VALUE))
        );
        oftalmologicPanelLayout.setVerticalGroup(
            oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oftalmologicPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(glaucomaLabel)
                        .addComponent(glaucomaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(glaucomaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(oftalmologicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cataractesLabel)
                        .addComponent(cataractesCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cataractesDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        genitoUrinariPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Genito-urinari"));

        insuficienciaRenalLabel.setText("Insuficiencia renal mod. grave:");

        incontinenciaLabel.setText("Incontinencia urinaria:");

        insuficienciaRenalCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        insuficienciaRenalCombo.setSelectedIndex(-1);

        incontinenciaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        incontinenciaCombo.setSelectedIndex(-1);

        insuficienciaRenalDate.setDateFormatString("dd/MM/yyyy");

        incontinenciaDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout genitoUrinariPanelLayout = new javax.swing.GroupLayout(genitoUrinariPanel);
        genitoUrinariPanel.setLayout(genitoUrinariPanelLayout);
        genitoUrinariPanelLayout.setHorizontalGroup(
            genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genitoUrinariPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genitoUrinariPanelLayout.createSequentialGroup()
                        .addComponent(insuficienciaRenalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(insuficienciaRenalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(insuficienciaRenalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genitoUrinariPanelLayout.createSequentialGroup()
                        .addComponent(incontinenciaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(incontinenciaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(incontinenciaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        genitoUrinariPanelLayout.setVerticalGroup(
            genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genitoUrinariPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(insuficienciaRenalLabel)
                        .addComponent(insuficienciaRenalCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(insuficienciaRenalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(genitoUrinariPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(incontinenciaLabel)
                        .addComponent(incontinenciaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(incontinenciaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        musculoEsqueleticPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Músculo-esquelètic"));

        artrosiLabel.setText("Artrosi:");

        artritisLabel.setText("Artritis:");

        fibromialgiaLabel.setText("Fibromialgia:");

        artrosiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        artrosiCombo.setSelectedIndex(-1);

        artritisCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        artritisCombo.setSelectedIndex(-1);

        fibromialgiaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        fibromialgiaCombo.setSelectedIndex(-1);

        artrosiDate.setDateFormatString("dd/MM/yyyy");

        artritisDate.setDateFormatString("dd/MM/yyyy");

        fibromialgiaDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout musculoEsqueleticPanelLayout = new javax.swing.GroupLayout(musculoEsqueleticPanel);
        musculoEsqueleticPanel.setLayout(musculoEsqueleticPanelLayout);
        musculoEsqueleticPanelLayout.setHorizontalGroup(
            musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musculoEsqueleticPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(musculoEsqueleticPanelLayout.createSequentialGroup()
                        .addComponent(artrosiLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(artrosiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(artrosiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(musculoEsqueleticPanelLayout.createSequentialGroup()
                        .addComponent(artritisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(artritisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(artritisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(musculoEsqueleticPanelLayout.createSequentialGroup()
                        .addComponent(fibromialgiaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fibromialgiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fibromialgiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        musculoEsqueleticPanelLayout.setVerticalGroup(
            musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(musculoEsqueleticPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(artrosiLabel)
                        .addComponent(artrosiCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(artrosiDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(artritisLabel)
                        .addComponent(artritisCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(artritisDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(musculoEsqueleticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fibromialgiaLabel)
                        .addComponent(fibromialgiaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fibromialgiaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        neoplassicCombo.setBorder(javax.swing.BorderFactory.createTitledBorder("Neoplàssic general"));

        benigneLabel.setText("Benigne");

        maligneLabel.setText("Maligne");

        benigneCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        benigneCombo.setSelectedIndex(-1);

        maligneCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sí", "No" }));
        maligneCombo.setSelectedIndex(-1);

        benigneDate.setDateFormatString("dd/MM/yyyy");

        maligneDate.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout neoplassicComboLayout = new javax.swing.GroupLayout(neoplassicCombo);
        neoplassicCombo.setLayout(neoplassicComboLayout);
        neoplassicComboLayout.setHorizontalGroup(
            neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(neoplassicComboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(neoplassicComboLayout.createSequentialGroup()
                        .addComponent(benigneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(benigneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(benigneDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(neoplassicComboLayout.createSequentialGroup()
                        .addComponent(maligneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maligneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(maligneDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        neoplassicComboLayout.setVerticalGroup(
            neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(neoplassicComboLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(benigneLabel)
                        .addComponent(benigneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(benigneDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(neoplassicComboLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(maligneLabel)
                        .addComponent(maligneCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(maligneDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout antecedentsPatologicsPersonalsPanelLayout = new javax.swing.GroupLayout(antecedentsPatologicsPersonalsPanel);
        antecedentsPatologicsPersonalsPanel.setLayout(antecedentsPatologicsPersonalsPanelLayout);
        antecedentsPatologicsPersonalsPanelLayout.setHorizontalGroup(
            antecedentsPatologicsPersonalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antecedentsPatologicsPersonalsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(antecedentsPatologicsPersonalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardiovascularPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endocrinoMetabolicPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(digestiuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(psiquiatricPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardiovascularPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(respiratoriPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hematologicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(immunologicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(oftalmologicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genitoUrinariPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(musculoEsqueleticPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(neoplassicCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        antecedentsPatologicsPersonalsPanelLayout.setVerticalGroup(
            antecedentsPatologicsPersonalsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(antecedentsPatologicsPersonalsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardiovascularPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(endocrinoMetabolicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(digestiuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(psiquiatricPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardiovascularPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(respiratoriPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hematologicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(immunologicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oftalmologicPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(genitoUrinariPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(musculoEsqueleticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(neoplassicCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tractamentActualPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Tractament farmacològic actual "));

        sistemaNerviosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Fàrmacs del Sistema Nerviós, escriure a continuació el nom del fàrmac "));

        ansioliticsLabel.setText("Ansiolítics i sedants:");

        hipnoticsLabel.setText("Hipnòtics:");

        antidepresiusLabel.setText("Antidepresius:");

        antimaniacsLabel.setText("Antimaniacs:");

        antipsicoticsLabel.setText("Antipsicòtics / Neurolèptics:");

        antimigranyososLabel.setText("Antimigranyosos:");

        opioidesLabel.setText("Opioides:");

        antiepilepticsLabel.setText("Antiepilèptics / Anticonvulsivants:");

        antiparkinsoniansLabel.setText("Antiparkinsonians:");

        musculEstriatLabel.setText("Fàrmacs i múscul estriat:");

        vasodilatadorsLabel.setText("Vasodilatadors cerebrals i nootròpics:");

        ACEsterasaLabel.setText("Alzheimer: inhibidors de la Ac-esterasa:");

        memantinaLabel.setText("Alzheimer: memantina:");

        psicoestimulantsLabel.setText("Psicoestimulants:");

        substanciesAbusLabel.setText("Substàncies d'abús:");

        deshabituacioLabel.setText("Deshabituació de substàncies d'abús:");

        javax.swing.GroupLayout sistemaNerviosPanelLayout = new javax.swing.GroupLayout(sistemaNerviosPanel);
        sistemaNerviosPanel.setLayout(sistemaNerviosPanelLayout);
        sistemaNerviosPanelLayout.setHorizontalGroup(
            sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(ansioliticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ansioliticsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(hipnoticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hipnoticsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antidepresiusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antidepresiusText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antimaniacsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antimaniacsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antipsicoticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antipsicoticsText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antimigranyososLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antimigranyososText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(opioidesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(opioidesText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antiepilepticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antiepilepticsText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(antiparkinsoniansLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antiparkinsoniansText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(musculEstriatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(musculEstriatText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(vasodilatadorsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vasodilatadorsText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(ACEsterasaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ACEsterasaText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(memantinaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(memantinaText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(psicoestimulantsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(psicoestimulantsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(substanciesAbusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(substanciesAbusText))
                    .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                        .addComponent(deshabituacioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deshabituacioText)))
                .addContainerGap())
        );
        sistemaNerviosPanelLayout.setVerticalGroup(
            sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sistemaNerviosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ansioliticsLabel)
                    .addComponent(ansioliticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hipnoticsLabel)
                    .addComponent(hipnoticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antidepresiusLabel)
                    .addComponent(antidepresiusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antimaniacsLabel)
                    .addComponent(antimaniacsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antipsicoticsLabel)
                    .addComponent(antipsicoticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antimigranyososLabel)
                    .addComponent(antimigranyososText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opioidesLabel)
                    .addComponent(opioidesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antiepilepticsLabel)
                    .addComponent(antiepilepticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antiparkinsoniansLabel)
                    .addComponent(antiparkinsoniansText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(musculEstriatLabel)
                    .addComponent(musculEstriatText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vasodilatadorsLabel)
                    .addComponent(vasodilatadorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ACEsterasaLabel)
                    .addComponent(ACEsterasaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memantinaLabel)
                    .addComponent(memantinaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(psicoestimulantsLabel)
                    .addComponent(psicoestimulantsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(substanciesAbusLabel)
                    .addComponent(substanciesAbusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaNerviosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deshabituacioLabel)
                    .addComponent(deshabituacioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        altresFarmacsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Altres fàrmacs, escriure a continuació el nom del fàrmac "));

        antiacidsLabel.setText("Antiàcids / Protectors gàstrics:");

        antidiabeticsLabel.setText("Antidiabètics:");

        AntitromboticsLabel.setText("Antitrombòtics / Anticoagulants:");

        antiagregantsLabel.setText("Antiagregants:");

        cardiotonicsLabel.setText("Cardiotònics / Antiarritmics:");

        antihipertensiusLabel.setText("Antihipertensius:");

        diureticsLabel.setText("Diurètics:");

        hipolipemiantsLabel.setText("Hipolipemiants:");

        dermatologicsLabel.setText("Dermatològics:");

        hormonesLabel.setText("Hormones sexuals:");

        urologicsLabel.setText("Urològics:");

        corticosteroidesLabel.setText("Corticosteroides sintètics:");

        terapiaTiroideaLabel.setText("Terapia tiroidea:");

        antineopasicsLabel.setText("Antineopàsics / Immunomoduladors:");

        antiinflamatorisLabel.setText("Antiinflamatoris / Antirreumàtics:");

        analgesicsLabel.setText("Analgèsics / Antipirètics:");

        broncodilatadorsLabel.setText("Broncodilatadors:");

        oftalmologicsLabel.setText("Oftalmològics:");

        javax.swing.GroupLayout altresFarmacsPanelLayout = new javax.swing.GroupLayout(altresFarmacsPanel);
        altresFarmacsPanel.setLayout(altresFarmacsPanelLayout);
        altresFarmacsPanelLayout.setHorizontalGroup(
            altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antiacidsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antiacidsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antidiabeticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antidiabeticsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(AntitromboticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antitromboticsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antiagregantsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antiagregantsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(cardiotonicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cardiotonicsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antihipertensiusLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antihipertensiusText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(diureticsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(diureticsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(hipolipemiantsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hipolipemiantsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(dermatologicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dermatologicsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(hormonesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hormonesText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(urologicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(urologicsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(corticosteroidesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(corticosteroidesText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(terapiaTiroideaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(terapiaTiroideaText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antineopasicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antineopasicsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(antiinflamatorisLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(antiinflamatorisText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(analgesicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(analgesicsText))
                    .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(broncodilatadorsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(broncodilatadorsText))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, altresFarmacsPanelLayout.createSequentialGroup()
                        .addComponent(oftalmologicsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oftalmologicsText)))
                .addContainerGap())
        );
        altresFarmacsPanelLayout.setVerticalGroup(
            altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(altresFarmacsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antiacidsLabel)
                    .addComponent(antiacidsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antidiabeticsLabel)
                    .addComponent(antidiabeticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AntitromboticsLabel)
                    .addComponent(antitromboticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antiagregantsLabel)
                    .addComponent(antiagregantsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cardiotonicsLabel)
                    .addComponent(cardiotonicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antihipertensiusLabel)
                    .addComponent(antihipertensiusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diureticsLabel)
                    .addComponent(diureticsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hipolipemiantsLabel)
                    .addComponent(hipolipemiantsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dermatologicsLabel)
                    .addComponent(dermatologicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hormonesLabel)
                    .addComponent(hormonesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urologicsLabel)
                    .addComponent(urologicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(corticosteroidesLabel)
                    .addComponent(corticosteroidesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terapiaTiroideaLabel)
                    .addComponent(terapiaTiroideaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antineopasicsLabel)
                    .addComponent(antineopasicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(antiinflamatorisLabel)
                    .addComponent(antiinflamatorisText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(analgesicsLabel)
                    .addComponent(analgesicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(broncodilatadorsLabel)
                    .addComponent(broncodilatadorsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(altresFarmacsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oftalmologicsLabel)
                    .addComponent(oftalmologicsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tractamentActualPanelLayout = new javax.swing.GroupLayout(tractamentActualPanel);
        tractamentActualPanel.setLayout(tractamentActualPanelLayout);
        tractamentActualPanelLayout.setHorizontalGroup(
            tractamentActualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tractamentActualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tractamentActualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sistemaNerviosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(altresFarmacsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        tractamentActualPanelLayout.setVerticalGroup(
            tractamentActualPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tractamentActualPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sistemaNerviosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(altresFarmacsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dadesMediquesPanelLayout = new javax.swing.GroupLayout(dadesMediquesPanel);
        dadesMediquesPanel.setLayout(dadesMediquesPanelLayout);
        dadesMediquesPanelLayout.setHorizontalGroup(
            dadesMediquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesMediquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dadesMediquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(antecedentsFamiliarsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dadesCliniquesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(antecedentsPatologicsPersonalsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tractamentActualPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        dadesMediquesPanelLayout.setVerticalGroup(
            dadesMediquesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadesMediquesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(antecedentsFamiliarsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dadesCliniquesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(antecedentsPatologicsPersonalsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tractamentActualPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dadesMediquesScroll.setViewportView(dadesMediquesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadesMediquesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dadesMediquesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 3325, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACEsterasaLabel;
    private javax.swing.JTextField ACEsterasaText;
    private javax.swing.JLabel AntitromboticsLabel;
    private javax.swing.JComboBox<String> abusAlcoholCombo;
    private com.toedter.calendar.JDateChooser abusAlcoholDate;
    private javax.swing.JLabel abusAlcoholLabel;
    private javax.swing.JComboBox<String> abusDroguesCombo;
    private com.toedter.calendar.JDateChooser abusDroguesDate;
    private javax.swing.JLabel abusDroguesLabel;
    private javax.swing.JLabel alcoholCheck;
    private javax.swing.JLabel alcoholLabel;
    private javax.swing.JTextField alcoholText;
    private javax.swing.JComboBox<String> alergiaCombo;
    private com.toedter.calendar.JDateChooser alergiaDate;
    private javax.swing.JLabel alergiaLabel;
    private javax.swing.JLabel altresDemenciesLabel;
    private javax.swing.JTextField altresDemenciesText;
    private javax.swing.JLabel altresFamiliarsLabel;
    private javax.swing.JTextField altresFamiliarsText;
    private javax.swing.JPanel altresFarmacsPanel;
    private javax.swing.JComboBox<String> alzheimerCombo;
    private javax.swing.JLabel alzheimerLabel;
    private javax.swing.JLabel analgesicsLabel;
    private javax.swing.JTextField analgesicsText;
    private javax.swing.JComboBox<String> anemiaCombo;
    private com.toedter.calendar.JDateChooser anemiaDate;
    private javax.swing.JLabel anemiaLabel;
    private javax.swing.JComboBox<String> ansietatCombo;
    private com.toedter.calendar.JDateChooser ansietatDate;
    private javax.swing.JLabel ansietatLabel;
    private javax.swing.JLabel ansioliticsLabel;
    private javax.swing.JTextField ansioliticsText;
    private javax.swing.JPanel antecedentsFamiliarsPanel;
    private javax.swing.JLabel antecedentsMareLabel;
    private javax.swing.JTextField antecedentsMareText;
    private javax.swing.JLabel antecedentsPareLabel;
    private javax.swing.JTextField antecedentsPareText;
    private javax.swing.JPanel antecedentsPatologicsPersonalsPanel;
    private javax.swing.JLabel antecedentsPersonalsLabel;
    private javax.swing.JTextField antecedentsPersonalsText;
    private javax.swing.JLabel antiacidsLabel;
    private javax.swing.JTextField antiacidsText;
    private javax.swing.JLabel antiagregantsLabel;
    private javax.swing.JTextField antiagregantsText;
    private javax.swing.JLabel antidepresiusLabel;
    private javax.swing.JTextField antidepresiusText;
    private javax.swing.JLabel antidiabeticsLabel;
    private javax.swing.JTextField antidiabeticsText;
    private javax.swing.JLabel antiepilepticsLabel;
    private javax.swing.JTextField antiepilepticsText;
    private javax.swing.JLabel antihipertensiusLabel;
    private javax.swing.JTextField antihipertensiusText;
    private javax.swing.JLabel antiinflamatorisLabel;
    private javax.swing.JTextField antiinflamatorisText;
    private javax.swing.JLabel antimaniacsLabel;
    private javax.swing.JTextField antimaniacsText;
    private javax.swing.JLabel antimigranyososLabel;
    private javax.swing.JTextField antimigranyososText;
    private javax.swing.JLabel antineopasicsLabel;
    private javax.swing.JTextField antineopasicsText;
    private javax.swing.JLabel antiparkinsoniansLabel;
    private javax.swing.JTextField antiparkinsoniansText;
    private javax.swing.JLabel antipsicoticsLabel;
    private javax.swing.JTextField antipsicoticsText;
    private javax.swing.JTextField antitromboticsText;
    private javax.swing.JComboBox<String> arritmiaCombo;
    private com.toedter.calendar.JDateChooser arritmiaDate;
    private javax.swing.JComboBox<String> artritisCombo;
    private com.toedter.calendar.JDateChooser artritisDate;
    private javax.swing.JLabel artritisLabel;
    private javax.swing.JComboBox<String> artrosiCombo;
    private com.toedter.calendar.JDateChooser artrosiDate;
    private javax.swing.JLabel artrosiLabel;
    private javax.swing.JComboBox<String> asmaCombo;
    private com.toedter.calendar.JDateChooser asmaDate;
    private javax.swing.JLabel asmaLabel;
    private javax.swing.JComboBox<String> avcEstablertCombo;
    private com.toedter.calendar.JDateChooser avcEstablertDate;
    private javax.swing.JLabel avcEstablertLabel;
    private javax.swing.JComboBox<String> avcTransitoriCombo;
    private com.toedter.calendar.JDateChooser avcTransitoriDate;
    private javax.swing.JLabel avcTransitoriLabel;
    private javax.swing.JComboBox<String> benigneCombo;
    private com.toedter.calendar.JDateChooser benigneDate;
    private javax.swing.JLabel benigneLabel;
    private javax.swing.JLabel broncodilatadorsLabel;
    private javax.swing.JTextField broncodilatadorsText;
    private javax.swing.JLabel cafeCheck;
    private javax.swing.JLabel cafeLabel;
    private javax.swing.JTextField cafeText;
    private javax.swing.JComboBox<String> cannabisCombo;
    private javax.swing.JLabel cannabisLabel;
    private javax.swing.JComboBox<String> cardiopatiaCombo;
    private com.toedter.calendar.JDateChooser cardiopatiaDate;
    private javax.swing.JLabel cardiotonicsLabel;
    private javax.swing.JTextField cardiotonicsText;
    private javax.swing.JPanel cardiovascularPanel;
    private javax.swing.JPanel cardiovascularPanel1;
    private javax.swing.JComboBox<String> cataractesCombo;
    private com.toedter.calendar.JDateChooser cataractesDate;
    private javax.swing.JLabel cataractesLabel;
    private javax.swing.JComboBox<String> cefaleaCombo;
    private com.toedter.calendar.JDateChooser cefaleaDate;
    private javax.swing.JLabel cefaleaLabel;
    private javax.swing.JComboBox<String> colelitiasisCombo;
    private com.toedter.calendar.JDateChooser colelitiasisDate;
    private javax.swing.JLabel colelitiasisLabel;
    private javax.swing.JLabel corticosteroidesLabel;
    private javax.swing.JTextField corticosteroidesText;
    private javax.swing.JPanel dadesCliniquesPanel1;
    private javax.swing.JPanel dadesMediquesPanel;
    private javax.swing.JScrollPane dadesMediquesScroll;
    private javax.swing.JComboBox<String> depresioCombo;
    private com.toedter.calendar.JDateChooser depresioDate;
    private javax.swing.JLabel depresioLabel;
    private javax.swing.JLabel dermatologicsLabel;
    private javax.swing.JTextField dermatologicsText;
    private javax.swing.JLabel deshabituacioLabel;
    private javax.swing.JTextField deshabituacioText;
    private javax.swing.JComboBox<String> diabetisCombo;
    private com.toedter.calendar.JDateChooser diabetisDate;
    private javax.swing.JLabel diabetisLabel;
    private javax.swing.JPanel digestiuPanel;
    private javax.swing.JComboBox<String> dislipemiaCombo;
    private com.toedter.calendar.JDateChooser dislipemiaDate;
    private javax.swing.JLabel dislipemiaLabel;
    private javax.swing.JLabel diureticsLabel;
    private javax.swing.JTextField diureticsText;
    private javax.swing.JPanel endocrinoMetabolicPanel;
    private javax.swing.JComboBox<String> epilepsiaCombo;
    private com.toedter.calendar.JDateChooser epilepsiaDate;
    private javax.swing.JLabel epilepsiaLabel;
    private javax.swing.JComboBox<String> epocCombo;
    private com.toedter.calendar.JDateChooser epocDate;
    private javax.swing.JLabel epocLabel;
    private javax.swing.JComboBox<String> esclerosisCombo;
    private com.toedter.calendar.JDateChooser esclerosisDate;
    private javax.swing.JLabel esclerosisLabel;
    private javax.swing.JComboBox<String> fibromialgiaCombo;
    private com.toedter.calendar.JDateChooser fibromialgiaDate;
    private javax.swing.JLabel fibromialgiaLabel;
    private javax.swing.JComboBox<String> gastritisCombo;
    private com.toedter.calendar.JDateChooser gastritisDate;
    private javax.swing.JLabel gastritisLabel;
    private javax.swing.JPanel genitoUrinariPanel;
    private javax.swing.JComboBox<String> glaucomaCombo;
    private com.toedter.calendar.JDateChooser glaucomaDate;
    private javax.swing.JLabel glaucomaLabel;
    private javax.swing.JPanel hematologicPanel;
    private javax.swing.JComboBox<String> hepatopatiaCombo;
    private com.toedter.calendar.JDateChooser hepatopatiaDate;
    private javax.swing.JLabel hepatopatiaLabel;
    private javax.swing.JComboBox<String> hipertensioCombo;
    private com.toedter.calendar.JDateChooser hipertensioDate;
    private javax.swing.JLabel hipertensioLabel;
    private javax.swing.JLabel hipnoticsLabel;
    private javax.swing.JTextField hipnoticsText;
    private javax.swing.JLabel hipolipemiantsLabel;
    private javax.swing.JTextField hipolipemiantsText;
    private javax.swing.JLabel hormonesLabel;
    private javax.swing.JTextField hormonesText;
    private javax.swing.JPanel immunologicPanel;
    private javax.swing.JComboBox<String> incontinenciaCombo;
    private com.toedter.calendar.JDateChooser incontinenciaDate;
    private javax.swing.JLabel incontinenciaLabel;
    private javax.swing.JComboBox<String> infartCombo;
    private com.toedter.calendar.JDateChooser infartDate;
    private javax.swing.JComboBox<String> insuficienciaCardiacaCombo;
    private com.toedter.calendar.JDateChooser insuficienciaCardiacaDate;
    private javax.swing.JLabel insuficienciaCardiacaLabel;
    private javax.swing.JComboBox<String> insuficienciaRenalCombo;
    private com.toedter.calendar.JDateChooser insuficienciaRenalDate;
    private javax.swing.JLabel insuficienciaRenalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> leucosisCombo;
    private com.toedter.calendar.JDateChooser leucosisDate;
    private javax.swing.JLabel leucosisLabel;
    private javax.swing.JLabel malaltiaParkinson;
    private javax.swing.JComboBox<String> malaltiaParkinsonCombo;
    private com.toedter.calendar.JDateChooser malaltiaParkinsonDate;
    private javax.swing.JComboBox<String> malaltiaVascularCombo;
    private com.toedter.calendar.JDateChooser malaltiaVascularDate;
    private javax.swing.JComboBox<String> maligneCombo;
    private com.toedter.calendar.JDateChooser maligneDate;
    private javax.swing.JLabel maligneLabel;
    private javax.swing.JLabel memantinaLabel;
    private javax.swing.JTextField memantinaText;
    private javax.swing.JLabel musculEstriatLabel;
    private javax.swing.JTextField musculEstriatText;
    private javax.swing.JPanel musculoEsqueleticPanel;
    private javax.swing.JPanel neoplassicCombo;
    private javax.swing.JComboBox<String> obesitatCombo;
    private com.toedter.calendar.JDateChooser obesitatDate;
    private javax.swing.JLabel obesitatLabel;
    private javax.swing.JPanel oftalmologicPanel;
    private javax.swing.JLabel oftalmologicsLabel;
    private javax.swing.JTextField oftalmologicsText;
    private javax.swing.JLabel opioidesLabel;
    private javax.swing.JTextField opioidesText;
    private javax.swing.JComboBox<String> parkinsonCombo;
    private javax.swing.JLabel parkinsonLabel;
    private javax.swing.JComboBox<String> patologiaTiroidesCombo;
    private com.toedter.calendar.JDateChooser patologiaTiroidesDate;
    private javax.swing.JLabel patologiaTiroidesLabel;
    private javax.swing.JLabel psicoestimulantsLabel;
    private javax.swing.JTextField psicoestimulantsText;
    private javax.swing.JComboBox<String> psicosisCombo;
    private com.toedter.calendar.JDateChooser psicosisDate;
    private javax.swing.JLabel psicosisLabel;
    private javax.swing.JPanel psiquiatricPanel;
    private javax.swing.JPanel respiratoriPanel;
    private javax.swing.JComboBox<String> sindromeDownCombo;
    private javax.swing.JLabel sindromeDownLabel;
    private javax.swing.JPanel sistemaNerviosPanel;
    private javax.swing.JLabel substanciesAbusLabel;
    private javax.swing.JTextField substanciesAbusText;
    private javax.swing.JLabel tabacCheck;
    private javax.swing.JLabel tabacLabel;
    private javax.swing.JTextField tabacText;
    private javax.swing.JLabel terapiaTiroideaLabel;
    private javax.swing.JTextField terapiaTiroideaText;
    private javax.swing.JLabel toxicsLaboralsLabel;
    private javax.swing.JTextField toxicsLaboralsText;
    private javax.swing.JPanel tractamentActualPanel;
    private javax.swing.JComboBox<String> traumaCranealCombo;
    private com.toedter.calendar.JDateChooser traumaCranealDate;
    private javax.swing.JLabel traumaCranealLabel;
    private javax.swing.JComboBox<String> ulcusCombo;
    private com.toedter.calendar.JDateChooser ulcusDate;
    private javax.swing.JLabel ulcusLabel;
    private javax.swing.JLabel urologicsLabel;
    private javax.swing.JTextField urologicsText;
    private javax.swing.JLabel vasodilatadorsLabel;
    private javax.swing.JTextField vasodilatadorsText;
    // End of variables declaration//GEN-END:variables
}
