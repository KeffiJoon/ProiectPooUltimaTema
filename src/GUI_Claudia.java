import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GUI_Claudia extends JFrame {
    private JPanel interfata;
    private JRadioButton vehiculebutton;
    private JButton okButton;
    private JButton resetButton;
    private JTextArea textArea;
    private JRadioButton autobuz;
    private JRadioButton motocicleta;
    private JCheckBox capacitateCheckBox;
    private JCheckBox aerConditionatCheckBox;
    private JCheckBox atasCheckBox;
    private JCheckBox normaEmisiiCheckBox;
    private JCheckBox discuriCheckBox;
    private JCheckBox linieCheckBox;
    private JButton savebutton;
    private JRadioButton citestedinfisierButton;

    ArrayList<Autobuz> autobuze = Autobuz.getListaAutobuze();
    ArrayList<Motocicleta> motociclete = Motocicleta.getListaMotociclete();
    ArrayList<Vehicul> vehicule =Vehicul.getListaVehicule();
    ArrayList<Autobuz> autobuzele = new ArrayList<>();
    ArrayList<Motocicleta> moto = new ArrayList<>();
    ArrayList<Vehicul> vehicule2= new ArrayList<>();

    public GUI_Claudia() {
        setContentPane(interfata);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400, 800);
        setLocationRelativeTo(null);
        setVisible(true);

        // Inițial, checkbox-urile și combobox-urile sunt dezactivate
        normaEmisiiCheckBox.setEnabled(false);
        capacitateCheckBox.setEnabled(false);
        aerConditionatCheckBox.setEnabled(false);
        atasCheckBox.setEnabled(false);
        linieCheckBox.setEnabled(false);
        discuriCheckBox.setEnabled(false);

        autobuz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean autobuzSelected = autobuz.isSelected();
                normaEmisiiCheckBox.setEnabled(autobuzSelected);
                capacitateCheckBox.setEnabled(autobuzSelected);
                aerConditionatCheckBox.setEnabled(autobuzSelected);
                linieCheckBox.setEnabled(autobuzSelected);

            }
        });

        motocicleta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean motocicletaSelected = motocicleta.isSelected();
                atasCheckBox.setEnabled(motocicletaSelected);
                normaEmisiiCheckBox.setEnabled(motocicletaSelected);
                discuriCheckBox.setEnabled(motocicletaSelected);
            }
        });

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(""); // Resetăm zona de text
                boolean dinfisier=citestedinfisierButton.isSelected();
                if (autobuz.isSelected()) {
                    for (Autobuz m : (dinfisier? autobuzele :autobuze)) {
                        boolean conditions = true;
                        if (normaEmisiiCheckBox.isSelected() && !m.getNormaEmisii().equalsIgnoreCase("euro4")) {
                            conditions = false;
                        }
                        if (capacitateCheckBox.isSelected() && m.getCapacitatePasageri() != 60) {
                            conditions = false;
                        }
                        if (linieCheckBox.isSelected() && m.getLinie() !=40){
                            conditions = false;
                        }
                        if (aerConditionatCheckBox.isSelected() && !m.getAerConditionat()) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(m.toString() + "\n");
                        }
                    }
                }

                if (motocicleta.isSelected()) {
                    for (Motocicleta t : (dinfisier? moto :motociclete)) {
                        boolean conditions = true;
                        if (atasCheckBox.isSelected() && !t.getAreAtas()) {
                            conditions = false;
                        }
                        if (normaEmisiiCheckBox.isSelected() && !t.getNormaEmisii().equalsIgnoreCase("euro4")) {
                            conditions = false;
                        }
                        if (discuriCheckBox.isSelected() && t.getNrDiscuriFata() >4) {
                            conditions = false;
                        }
                        if (conditions) {
                            textArea.append(t.toString() + "\n");
                        }
                    }
                }
                if(vehiculebutton.isSelected()) {
                    for(Vehicul v : (dinfisier? vehicule2:vehicule)) {
                        textArea.append(v.toString() + "\n");
                    }
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });
        citestedinfisierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    try{
                        FileInputStream fin = new FileInputStream("C:\\Users\\nasta\\Downloads\\ProiectPOO\\Proiect-POO-Vehicule-GR2\\src\\file_Claudia.txt");
                        BufferedReader br = new BufferedReader(new InputStreamReader(fin));
                        String linie;

                        while ((linie = br.readLine()) != null) {
                            if (linie.startsWith("Autobuz: ")) {
                                String[] valori = linie.split(": ")[1].split(", ");
                                autobuzele.add(new Autobuz(Integer.parseInt(valori[0]), Boolean.parseBoolean(valori[1]), valori[2], valori[3], Boolean.parseBoolean(valori[4]), Integer.parseInt(valori[5]), valori[6], Integer.parseInt(valori[7]), Integer.parseInt(valori[8])));
                            } else if (linie.startsWith("Motocicleta: ")) {
                                String[] valori = linie.split(": ")[1].split(", ");
                                moto.add(new Motocicleta(Integer.parseInt(valori[0]), valori[1], Integer.parseInt(valori[2]), Boolean.parseBoolean(valori[3]), valori[4], Integer.parseInt(valori[5]), valori[6], Integer.parseInt(valori[7]),Boolean.parseBoolean(valori[8])));
                            } else if (linie.startsWith("Vehicul: ")) {
                                String[] valori = linie.split(": ")[1].split(", ");
                                vehicule2.add(new Vehicul(Integer.parseInt(valori[0]),valori[1],Integer.parseInt(valori[2]),valori[3]));
                            }
                        }
                    }
                    catch (
                            IOException f) {
                        System.out.println("[EROARE!] " + f.getMessage());
                    }

            }
        });
        savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(interfata);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                        bw.write(textArea.getText());
                        JOptionPane.showMessageDialog(interfata, "Rezultatele au fost salvate.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog( interfata,"Eroare la salvarea fișierului.");
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        GUI_Claudia interfata = new GUI_Claudia();
        interfata.setTitle("Interfata Vehicule");
        interfata.getContentPane().setBackground(new Color(210,255,255));

    }

}
