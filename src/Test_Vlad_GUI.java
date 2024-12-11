import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.ArrayList;

public class Test_Vlad_GUI extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Test_Vlad_GUI::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        // Main Frame
        JFrame frame = new JFrame("Vehicul Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Main Components
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane textScrollPane = new JScrollPane(textArea);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Checkboxes for filtering
        JCheckBox showNuclearSubmarines = new JCheckBox("Submarine Nucleare");
        JCheckBox showConventionalSubmarines = new JCheckBox("Submarine cu combustibil conventional (Diesel)");
        JCheckBox showMilitaryJets = new JCheckBox("Avioane cu reactie cu scop militar");
        JCheckBox showPropellerMilitaryPlanes = new JCheckBox("Avioane cu elice cu scop militar");
        JCheckBox showDeepDivingSubmarines = new JCheckBox("Submarine care au adancimea maxima mai mare de 1500m");
        JCheckBox showLongRangePlanes = new JCheckBox("Avioane cu raza de actiune mai mare de 10.000km");

        leftPanel.add(showNuclearSubmarines);
        leftPanel.add(showConventionalSubmarines);
        leftPanel.add(showMilitaryJets);
        leftPanel.add(showPropellerMilitaryPlanes);
        leftPanel.add(showDeepDivingSubmarines);
        leftPanel.add(showLongRangePlanes);

        // Add components to frame
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(textScrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Buttons
        JButton readFromFileButton = new JButton("Citeste din Fisier");
        JButton writeToFileButton = new JButton("Scriere intr-un Fisier");
        bottomPanel.add(readFromFileButton);
        bottomPanel.add(writeToFileButton);

        // Load data from file
        ArrayList<Submarin> submarines = new ArrayList<>();
        ArrayList<Avion> airplanes = new ArrayList<>();

        // Read From File Button
        readFromFileButton.addActionListener(e -> {
            submarines.clear();
            airplanes.clear();
            try (BufferedReader br = new BufferedReader(new FileReader(new File("text.txt")))) {
                String line;

                // Read each line from the file
                while ((line = br.readLine()) != null) {
                    if (line.contains("Submarin")) {
                        // Parse Submarin data
                        String model = line.split("model ")[1].split(" de tonaj:")[0].trim();
                        int tonaj = Integer.parseInt(line.split(" de tonaj:")[1].split(" de tone")[0].trim());
                        int id = Integer.parseInt(line.split("\\.")[0].trim());
                        int adancimeMax = Integer.parseInt(line.split("adancime maxima de:")[1].split(" cu combustibil")[0].trim());
                        String combustibil = line.split("cu combustibil ")[1].split(" cu culoare")[0].trim();
                        String culoare = line.split("cu culoare: ")[1].split(" si cu armamentul:")[0].trim();
                        String armament = line.split("si cu armamentul:")[1].split(" ,fabricat in ")[0].trim();
                        int anFabricatie = Integer.parseInt(line.split("fabricat in ")[1].trim());
                        System.out.println(combustibil);
                        submarines.add(new Submarin(model, tonaj, id, anFabricatie, culoare, adancimeMax, combustibil, armament));
                    } else if (line.contains("Avion")) {
                        // Parse Avion data
                        int id = Integer.parseInt(line.split("\\.")[0].trim());

                        boolean mil = line.contains("cu scop militar");
                        String marca = line.split("de marca ")[1].split(", de model")[0].trim();
                        String model = line.split(", de model ")[1].split(", care poate transporta")[0].trim();
                        int pssnr = Integer.parseInt(line.split("care poate transporta ")[1].split(" de oameni")[0].replaceAll("[^\\d]", ""));
                        int cargolim = Integer.parseInt(line.split(", ")[2].split(" de tone de marfa")[0].replaceAll("[^\\d]", ""));
                        String tipMotor = line.split("cu motor tip ")[1].split(" cu culoare")[0].trim();
                        String culoare = line.split("cu culoare: ")[1].split(" cu raza:")[0].trim();
                        int maxrange = Integer.parseInt(line.split("cu raza: ")[1].split("km fabricat in anul:")[0].replaceAll("[^\\d]", ""));
                        int anFabricatie = Integer.parseInt(line.split("fabricat in anul: ")[1].split(" cu scop")[0].replaceAll("[^\\d]", ""));
                        maxrange=(maxrange-anFabricatie)/10000;
                        airplanes.add(new Avion(marca, model, id, anFabricatie, culoare, maxrange, pssnr, cargolim, tipMotor, mil));
                    }
                }

                // Sort the lists
                submarines.sort((s1, s2) -> Integer.compare(s1.getId(), s2.getId()));
                airplanes.sort((a1, a2) -> Integer.compare(a1.getId(), a2.getId()));

                // Update text area
                textArea.setText("");
                submarines.forEach(sub -> textArea.append(sub.toString() + "\n"));
                airplanes.forEach(av -> textArea.append(av.toString() + "\n"));

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Write To File Button
        writeToFileButton.addActionListener(e -> {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("textout.txt")))) {
                if(showPropellerMilitaryPlanes.isSelected()){
                    for(Avion av : airplanes){
                        if(av.isMil() && av.isPropType()) {
                            bw.write(av.toString() + "\n");
                        }
                    }
                }
                if(showConventionalSubmarines.isSelected()){
                    for(Submarin submarin : submarines) {
                        if (!submarin.isNuclear()) {
                            bw.write(submarin.toString() + "\n");
                        }
                    }
                }
                if(showNuclearSubmarines.isSelected()){
                    for(Submarin submarin : submarines) {
                        if (submarin.isNuclear()) {
                            bw.write(submarin.toString() + "\n");
                        }
                    }
                }
                if(showMilitaryJets.isSelected()){
                    for(Avion avion : airplanes) {
                        if (avion.isMil() && avion.isJetType()) {
                            bw.write(avion.toString() + "\n");
                        }
                    }
                }
                if(showLongRangePlanes.isSelected()){
                    for(Avion avion : airplanes) {
                        if(avion.getMaxrange()>10000){
                            bw.write(avion.toString() + "\n");
                        }
                    }
                }
                if(showDeepDivingSubmarines.isSelected()){
                    for(Submarin submarin : submarines) {
                        if(submarin.getAdancimeMax()>1500){
                            bw.write(submarin.toString() + "\n");
                        }
                    }

                }
                if(!showConventionalSubmarines.isSelected()&&!showNuclearSubmarines.isSelected()&&!showDeepDivingSubmarines.isSelected()&&!showMilitaryJets.isSelected()&&!showLongRangePlanes.isSelected()&&!showPropellerMilitaryPlanes.isSelected()){
                    bw.write(textArea.getText());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        // Checkbox Filters
        ItemListener updateRightPanel = e -> {
            rightPanel.removeAll();
            if(showNuclearSubmarines.isSelected()){
                for(Submarin submarin : submarines) {
                    if (submarin.isNuclear()) {
                        rightPanel.add(new JLabel(submarin.toString()));
                    }
                }
            }
            if(showPropellerMilitaryPlanes.isSelected()){
                for(Avion av : airplanes){
                    if(av.isMil() && av.isPropType()) {
                        rightPanel.add(new JLabel(av.toString()));
                    }
                }
            }
            if(showConventionalSubmarines.isSelected()){
                for(Submarin submarin : submarines) {
                    if (!submarin.isNuclear()) {
                        rightPanel.add(new JLabel(submarin.toString()));
                    }
                }
            }
            if(showMilitaryJets.isSelected()){
                for(Avion avion : airplanes) {
                    if (avion.isMil() && avion.isJetType()) {
                        rightPanel.add(new JLabel(avion.toString()));
                    }
                }
            }
            if(showLongRangePlanes.isSelected()){
                for(Avion avion : airplanes) {
                    if(avion.getMaxrange()>10000){
                       rightPanel.add(new JLabel(avion.toString()));
                    }
                }
            }
            if(showDeepDivingSubmarines.isSelected()){
                for(Submarin submarin : submarines) {
                    if(submarin.getAdancimeMax()>1500){
                        rightPanel.add(new JLabel(submarin.toString()));
                    }
                }

            }
            rightPanel.revalidate();
            rightPanel.repaint();
        };

        showNuclearSubmarines.addItemListener(updateRightPanel);
        showConventionalSubmarines.addItemListener(updateRightPanel);
        showMilitaryJets.addItemListener(updateRightPanel);
        showPropellerMilitaryPlanes.addItemListener(updateRightPanel);
        showDeepDivingSubmarines.addItemListener(updateRightPanel);
        showLongRangePlanes.addItemListener(updateRightPanel);

        frame.setVisible(true);
    }
}
