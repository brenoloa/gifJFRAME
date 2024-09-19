import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Game {

    public Game() {
        JFrame tela = new JFrame("teste");
        tela.setSize(500, 500);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);

        String[] img = new String[54];
        for (int i = 0; i < img.length; i++) {
            img[i] = String.format("C:\\Users\\Pichau\\VSCODE\\gifjava\\img\\pvz (%d).png", i + 1); 
            // mude o diretório de acordo com o seu pc (importante colocar o %d pra que a imagem seja trocada)
            //criaçao das 54 imagens no caso o %d é substuido por i inserindo as 54 imagens em um vetor pra nao ser necessario copiar e colar 54 linhas de img[0.1.2.3.4.5]
        }

        //setando a primeira imagem 
        JLabel label = new JLabel(new ImageIcon(img[0])); 
        tela.add(label);
        tela.setVisible(true);

        //timer para mudar as imagens
        Timer timer = new Timer(30, new ActionListener() {
            int yyy = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                yyy = (yyy + 1) % img.length;
                label.setIcon(new ImageIcon(img[yyy]));
            }
        });
        timer.start();
    }
}