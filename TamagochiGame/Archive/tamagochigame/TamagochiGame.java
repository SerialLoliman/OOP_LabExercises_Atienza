package tamagochigame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TamagochiGame extends JPanel implements ActionListener {
    
    private int hunger = 0;
    private int happiness = 100;
    private int health = 100;
    private int energy = 100;
    private JFrame menuFrame;
    
    private Random rand = new Random();
    private Timer timer;
    private Button play = new Button("Play");
    private Button rest = new Button("Rest");
   
    public TamagochiGame() {
    setBackground(Color.WHITE);
    setFocusable(true);

    timer = new Timer(5000, this);
    timer.start();
    
    play.setBounds(10, 130, 80, 30);
    play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            happiness += 20;
            hunger += 10;
            energy -= 10;
            health -= 10;
            repaint();}});
        add(play);

    rest.setBounds(100, 130, 80, 30);
    rest.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            happiness -= 10;
            hunger -= 20;
            energy += 20;
            health += 20;
            repaint();}});
        add(rest);}
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Hunger: " + hunger, 10, 25);
        g.drawString("Happiness: " + happiness, 10, 50);
        g.drawString("Health: " + health, 10, 75);
        g.drawString("Energy: " + energy, 10, 100);
        if (happiness>100){happiness=100;}
        if (hunger>100){hunger=100;}
        if (energy>100){energy=100;}
        if (health>100){health=100;}}
    
    private void closeAllWindows() {
    Frame[] frames = Frame.getFrames();
    for (Frame frame : frames) {
        if (!frame.equals(menuFrame)) {
            frame.dispose();}}}
    
    public void actionPerformed(ActionEvent e) {
    hunger += rand.nextInt(10) + 1;
    happiness -= rand.nextInt(10) + 1;
    health -= rand.nextInt(10) + 1;
    energy -= rand.nextInt(10) + 1;

    if (hunger > 100 || happiness < 0 || health < 0) {
        System.out.println("Game Over!");
        timer.stop();
        closeAllWindows();
        JFrame gameOverFrame = new JFrame("Game Over");
        gameOverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameOverFrame.setSize(300, 150);
        gameOverFrame.setLocationRelativeTo(null);
        JPanel gameOverPanel = new JPanel();
        gameOverPanel.setBackground(Color.WHITE);
        JLabel gameOverLabel = new JLabel("Game Over!");
        gameOverLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        gameOverPanel.add(gameOverLabel);
        JButton returnButton = new JButton("Return to Main Menu");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameOverFrame.dispose();
                menuFrame.setVisible(true);
                hunger = 0;
                happiness = 100;
                health = 100;
                energy = 100;
                timer.restart();}});
        gameOverPanel.add(returnButton);
        gameOverFrame.add(gameOverPanel);
        gameOverFrame.setVisible(true);}
    repaint();}
    
    public static void main(String[] args) {
    TamagochiGame game = new TamagochiGame();
    game.menuFrame = new JFrame("Tamagochi Game Menu");
    game.menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game.menuFrame.setSize(300, 150);
    game.menuFrame.setLocationRelativeTo(null);
    JPanel menuPanel = new JPanel();
    menuPanel.setBackground(Color.WHITE);
    JLabel titleLabel = new JLabel("Tamagochi Game");
    titleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
    menuPanel.add(titleLabel);
    JButton startButton = new JButton("Start Game");
    startButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            game.closeAllWindows();
            JFrame gameFrame = new JFrame("Tamagochi Game");
            gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gameFrame.setSize(300, 150);
            gameFrame.setLocationRelativeTo(null);
            gameFrame.add(game);
            gameFrame.setVisible(true);}});
    menuPanel.add(startButton);
    game.menuFrame.add(menuPanel);
    game.menuFrame.setVisible(true);}}