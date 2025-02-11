import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JLabel titleLabel;
    private JTextArea fortuneTextArea;
    private JButton readFortuneButton;
    private JButton quitButton;

    private ArrayList<String> fortunes;
    private String lastFortune = "";

    public FortuneTellerFrame() {
        // Initialize the JFrame
        setTitle("Fortune Teller");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create fortune list
        fortunes = new ArrayList<>();
        fortunes.add("You will find great fortune... in your fridge.");
        fortunes.add("Beware of the dog; he knows your secrets.");
        fortunes.add("Your future is as bright as your phone screen.");
        fortunes.add("Fortune favors the bold. And those who press 'Read My Fortune'.");
        fortunes.add("Happiness is around the corner. But it might be at the store.");
        fortunes.add("You will soon encounter a mysterious fortune cookie.");
        fortunes.add("Your fortune is currently loading...");
        fortunes.add("The universe has a message for you: 'Keep going'.");
        fortunes.add("A good time to start investing in socks.");
        fortunes.add("A new adventure awaits, but it involves a lot of paperwork.");
        fortunes.add("Your destiny includes pizza. A lot of pizza.");
        fortunes.add("A change is coming. Probably a new favorite song.");

        // Top panel: Title and image
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        ImageIcon fortuneIcon = new ImageIcon("fortune_icon.png"); // Add your own image here
        titleLabel = new JLabel("Fortune Teller", fortuneIcon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));

        topPanel.add(titleLabel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        // Middle panel: Fortune text area
        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());

        fortuneTextArea = new JTextArea(10, 40);
        fortuneTextArea.setEditable(false);
        fortuneTextArea.setFont(new Font("Serif", Font.PLAIN, 18));
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);

        middlePanel.add(scrollPane, BorderLayout.CENTER);
        add(middlePanel, BorderLayout.CENTER);

        // Bottom panel: Buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("Serif", Font.PLAIN, 20));
        readFortuneButton.addActionListener(e -> readFortune());

        quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Serif", Font.PLAIN, 20));
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void readFortune() {
        Random rand = new Random();
        int randomIndex;

        // Generate a random fortune that isn't the same as the last one
        do {
            randomIndex = rand.nextInt(fortunes.size());
        } while (fortunes.get(randomIndex).equals(lastFortune));

        lastFortune = fortunes.get(randomIndex);

        // Append the fortune to the text area
        fortuneTextArea.append(lastFortune + "\n");
    }
}
