package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainUI {

    private JPanel mainPanel;
    private JButton adicionarPontosTime1;
    private JButton adicionarPontosTime2;
    private JTextField placarTime1;
    private JTextField placarTime2;
    private JLabel placarGeralTime1;
    private JLabel placarGeralTime2;
    private JLabel contadorSet;
    private JCheckBox set1Time1;
    private JPanel panelSetsTime1;
    private JPanel panelSetsTime2;
    private JCheckBox set2Time1;
    private JCheckBox set3Time1;
    private JCheckBox set1Time2;
    private JCheckBox set2Time2;
    private JCheckBox set3Time2;
    private JLabel time1;
    private JLabel time2;


    int novoPonto = 1;
    int pontosTime1, pontosTime2 = 0;
    int contagemSet = 1;

    private List<JCheckBox> checkBoxListTime1 = new ArrayList<>();
    private List<JCheckBox> checkBoxListTime2 = new ArrayList<>();


    public MainUI(){

        checkBoxListTime1.add(set1Time1);
        checkBoxListTime1.add(set2Time1);
        checkBoxListTime1.add(set3Time1);

        checkBoxListTime2.add(set1Time2);
        checkBoxListTime2.add(set2Time2);
        checkBoxListTime2.add(set3Time2);

        contadorSet.setText(contagemSet+"");

        adicionarPontosTime1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(contagemSet < 5){
                    if( (pontosTime1 >= 24 && !((pontosTime1 - pontosTime2) <= 2)) || pontosTime1 >= 29){

                        addPlacarGeral(placarGeralTime1);
                        marcarCheckboxDeVitoria(checkBoxListTime1);
                        if((Integer.parseInt(placarGeralTime1.getText()) - Integer.parseInt(placarGeralTime2.getText())) == 3){
                            JOptionPane.showMessageDialog(null, "Vitoria do JOGO é do: " + time1.getText() +
                                    "\nPlacar final: " + placarGeralTime1.getText() + " x " + placarGeralTime2.getText());
                        }else{
                            JOptionPane.showMessageDialog(null, "Vitoria do set "+ contagemSet +": " + time1.getText());
                        }

                        contagemSet++;
                        contadorSet.setText(contagemSet+"");
                        limpaPontos();

                    }else{
                        pontosTime1 = pontosTime1 + novoPonto;
                        placarTime1.setText("" + pontosTime1);
                    }
                }else{
                    if( (pontosTime1 >= 14 && !((pontosTime1 - pontosTime2) <= 2)) || pontosTime1 == 19){

                        addPlacarGeral(placarGeralTime1);
                        marcarCheckboxDeVitoria(checkBoxListTime1);
                        JOptionPane.showMessageDialog(null, "Vitoria do JOGO é do: " + time1.getText() +
                                "\nPlacar final: " + placarGeralTime1.getText() + " x " + placarGeralTime2.getText());
                        limpaPontos();

                    }else{
                        pontosTime1 = pontosTime1 + novoPonto;
                        placarTime1.setText("" + pontosTime1);
                    }

                }


            }
        });

        adicionarPontosTime2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(contagemSet < 5){
                    if( (pontosTime2 >= 24 && !((pontosTime2 - pontosTime1) <= 2)) || pontosTime2 >= 29){

                        addPlacarGeral(placarGeralTime2);
                        marcarCheckboxDeVitoria(checkBoxListTime2);
                        if((Integer.parseInt(placarGeralTime2.getText()) - Integer.parseInt(placarGeralTime1.getText())) == 3){
                            JOptionPane.showMessageDialog(null, "Vitoria do JOGO é do: " + time2.getText() +
                                    "\nPlacar final: " + placarGeralTime1.getText() + " x " + placarGeralTime2.getText());
                        }else{
                            JOptionPane.showMessageDialog(null, "Vitoria do set "+ contagemSet +": " + time2.getText());
                        }

                        contagemSet++;
                        contadorSet.setText(contagemSet+"");
                        limpaPontos();

                    }else{
                        pontosTime2 = pontosTime2 + novoPonto;
                        placarTime2.setText("" + pontosTime2);
                    }
                }else{
                    if( (pontosTime2 >= 14 && !((pontosTime2 - pontosTime1) <= 2)) || pontosTime2 >= 19){
                            addPlacarGeral(placarGeralTime2);
                            marcarCheckboxDeVitoria(checkBoxListTime2);
                            JOptionPane.showMessageDialog(null, "Vitoria do JOGO é do: " + time2.getText() +
                                    "\nPlacar final: " + placarGeralTime1.getText() + " x " + placarGeralTime2.getText());
                            limpaPontos();
                    }else{
                        pontosTime2 = pontosTime2 + novoPonto;
                        placarTime2.setText("" + pontosTime2);
                    }

                }


            }
        });
    }

    private void marcarCheckboxDeVitoria(List<JCheckBox> list) {
        for (JCheckBox cb: list){
            if(!(cb.isSelected())){
                cb.setSelected(true);
                break;
            }
        }
    }

    private void addPlacarGeral(JLabel placar) {
        System.out.println(placar.getText());
        int placarNumerico = Integer.parseInt(placar.getText()) + 1;

        placar.setText(placarNumerico + "");

    }

    private void limpaPontos() {
        pontosTime1 = 0;
        pontosTime2 = 0;
        placarTime1.setText("");
        placarTime2.setText("");

    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

}
