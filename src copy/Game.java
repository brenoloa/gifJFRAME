import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Game {
    int delay = 100;
    int x = 0;
    int y = 20;
    Timer timer;
    JLabel label;
    public Game() {
        JFrame tela = new JFrame("teste");
        tela.setSize(500, 500);
        tela.setResizable(false);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLocationRelativeTo(null);
        tela.setLayout(null);
        String[] img = new String[54];
        for (int i = 0; i < img.length; i++) {
            img[i] = String.format("C:\\Users\\Pichau\\VSCODE\\gifjava\\img\\pvz (%d).png", i + 1); 
            // mude o diretório de acordo com o seu pc (importante colocar o %d pra que a imagem seja trocada)
            //criaçao das 54 imagens no caso o %d é substuido por i inserindo as 54 imagens em um vetor pra nao ser necessario copiar e colar 54 linhas de img[0.1.2.3.4.5]
        }

        //setando a primeira imagem 
        label = new JLabel(new ImageIcon(img[0])); 
        label.setBounds(x, y, 200, 200);
        tela.add(label);
        
        JButton botao1 = new JButton("+");
        botao1.setBounds(20, 300, 50, 50);
        botao1.setFont(new Font("ARIAL", Font.BOLD, 20));
        JButton botao2 = new JButton("-");
        botao2.setBounds(20, 355, 50, 50);
        botao2.setFont(new Font("ARIAL", Font.BOLD, 20));

        JButton botao3 = new JButton("^");
        botao3.setBounds(80, 300, 50, 50);
        botao3.setFont(new Font("ARIAL", Font.BOLD, 20));
        JButton botao4 = new JButton("v");
        botao4.setBounds(80, 355, 50, 50);
        botao4.setFont(new Font("ARIAL", Font.BOLD, 20));

        JButton botao5 = new JButton("<");
        botao5.setBounds(140, 300, 50, 50);
        botao5.setFont(new Font("ARIAL", Font.BOLD, 20));
        JButton botao6 = new JButton(">");
        botao6.setBounds(140, 355, 50, 50);
        botao6.setFont(new Font("ARIAL", Font.BOLD, 20));
        
        tela.add(botao5);
        tela.add(botao6);
        tela.add(botao2);
        tela.add(botao1);
        tela.add(botao3);
        tela.add(botao4);
        botao1.addActionListener(this::mais);
        botao2.addActionListener(this::menos);
        botao3.addActionListener(this::subir);
        botao4.addActionListener(this::descer);
        botao5.addActionListener(this::esquerda);
        botao6.addActionListener(this::direita);

        tela.setVisible(true);

        //timer para mudar as imagens
        timer = new Timer(delay, new ActionListener() {
            int yyy = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                yyy = (yyy + 1) % img.length;
                label.setIcon(new ImageIcon(img[yyy]));
                label.setBounds(x, y, 200, 200);
            }
        });
        timer.start();
    }

    private void mais(ActionEvent e) {
        delay -= 20;
        timer.setDelay(delay);
        System.out.println(delay);
    }

    private void menos(ActionEvent e) {
        delay += 20;
        timer.setDelay(delay);
        System.out.println(delay);
    }

    
    private void subir(ActionEvent e) {
        y -= 10;
        label.setBounds(x, y, 200, 200);
    }

    private void descer(ActionEvent e) {
        y += 10;
        label.setBounds(x, y, 200, 200);
    }
    private void esquerda(ActionEvent e) {
        x -= 10;
        label.setBounds(x, y, 200, 200);
    }

    private void direita(ActionEvent e) {
        x += 10;
        label.setBounds(x, y, 200, 200);
    }
}
