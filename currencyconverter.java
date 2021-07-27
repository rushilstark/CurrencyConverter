import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import java.io.BufferedReader;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class dvf extends JFrame{
	private JPanel inputPanel;
    private JPanel resultPanel;
    private JPanel menuPanel;
    private JPanel menuPanel1;
    private JLabel promptLabel;
    private JLabel resultLabel;
    private JLabel selectLabel;
    private JMenu currencyMenu;
    private JMenuBar currencyMenuBar;
    private JMenu currencyMenu1;
    private JMenuBar currencyMenuBar1;
    private JTextField inputField;
    private JButton convertButton;
    private JButton clearButton;
    String from;
    String to;

    public dvf()                       
    {
        super();
        this.setSize(500, 200);                         
        this.setLayout(new GridLayout(3, 3));          
        this.setTitle("Currency Converter");     
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        this.selectLabel = new JLabel("Select the currency to convert from: ", JLabel.RIGHT);
        this.resultLabel = new JLabel(" ", JLabel.CENTER);
        this.currencyMenu1 = new JMenu("(Click me to select a currency)");        
        JMenuItem Euros = new JMenuItem("Euros");                       
        Euros.addActionListener(new java.awt.event.ActionListener()     
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                menuChanged1(evt);
            }
        });
        this.currencyMenu1.add(Euros);
        JMenuItem JapaneseYen = new JMenuItem("Indian Rupee");          
        JapaneseYen.addActionListener(new java.awt.event.ActionListener()   
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged1(evt);
            }
        });
        this.currencyMenu1.add(JapaneseYen);
        JMenuItem GambianDalasis = new JMenuItem("Hongkong Dollar");         
        GambianDalasis.addActionListener(new java.awt.event.ActionListener()    
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged1(evt);
            }
        });
        this.currencyMenu1.add(GambianDalasis);
        JMenuItem CD = new JMenuItem("Canadian Dollar");         
        CD.addActionListener(new java.awt.event.ActionListener()   
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged1(evt);
            }
        });
        this.currencyMenu1.add(CD);
        JMenuItem USD = new JMenuItem("US Dollar");                    
        USD.addActionListener(new java.awt.event.ActionListener()      
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged1(evt);
            }
        });
        this.currencyMenu1.add(USD);
        currencyMenuBar1 = new JMenuBar();              
        currencyMenuBar1.add(currencyMenu1);
        currencyMenuBar1 = new JMenuBar();             
        currencyMenuBar1.add(currencyMenu1);
        this.menuPanel1 = new JPanel();
        this.menuPanel1.add(this.selectLabel);
        this.menuPanel1.add(this.currencyMenuBar1);
        this.add(this.menuPanel1);
        this.selectLabel = new JLabel("Select1 the currency to convert to:    ", JLabel.LEFT);
        this.resultLabel = new JLabel(" ", JLabel.CENTER);
        this.currencyMenu = new JMenu("(Click me to select a currency)");      
        JMenuItem Euros1 = new JMenuItem("Euros");                    
        Euros1.addActionListener(new java.awt.event.ActionListener()     
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(Euros1);
        JMenuItem JapaneseYen1 = new JMenuItem("Indian Rupee");         
        JapaneseYen1.addActionListener(new java.awt.event.ActionListener()   
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(JapaneseYen1);
        JMenuItem HKD1 = new JMenuItem("Hongkong Dollar");         
        HKD1.addActionListener(new java.awt.event.ActionListener()    
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(HKD1);
        JMenuItem CD1 = new JMenuItem("Canadian Dollar"); 
        CD1.addActionListener(new java.awt.event.ActionListener()   
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(CD1);
        JMenuItem USD1 = new JMenuItem("US Dollar");                    
        USD1.addActionListener(new java.awt.event.ActionListener()     
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                menuChanged(evt);
            }
        });
        this.currencyMenu.add(USD1);
        currencyMenuBar = new JMenuBar();         
        currencyMenuBar.add(currencyMenu);
        currencyMenuBar = new JMenuBar();               
        currencyMenuBar.add(currencyMenu);
        this.menuPanel = new JPanel();
        this.menuPanel.add(this.selectLabel);
        this.menuPanel.add(this.currencyMenuBar);
        this.add(this.menuPanel);
        this.promptLabel = new JLabel("Enter Amount: ", JLabel.RIGHT);
        this.resultLabel = new JLabel(" ", JLabel.CENTER);
        this.inputField = new JTextField("", 12);
        this.convertButton = new JButton("Convert");
        convertButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                try {
                    buttonclicked(evt);
                } catch (IOException e) {
                    
                    e.printStackTrace();
                }
            }
        });
        this.inputPanel = new JPanel();
        this.inputPanel.add(this.promptLabel);
        this.inputPanel.add(this.inputField);
        this.inputPanel.add(this.convertButton);
        this.add(this.inputPanel);
        this.resultPanel = new JPanel();
        this.resultPanel.add(this.resultLabel);
        this.add(this.resultPanel);
    }
    public void menuChanged(ActionEvent e)
    {
        if (e.getActionCommand().equals("Euros"))
        {
            currencyMenu.setText("EUR");
            to="EUR";
        }
        if (e.getActionCommand().equals("Indian Rupee")) {
            currencyMenu.setText("INR");
            to="INR";
        }
        if (e.getActionCommand().equals("Hongkong Dollar")) {
            currencyMenu.setText("HKD");
            to="HKD";
        }
        if (e.getActionCommand().equals("Canadian Dollar")) {
            currencyMenu.setText("CAD");
            to="CAD";
        }
        if (e.getActionCommand().equals("US Dollar")) {
            currencyMenu.setText("USD");
            to="USD";
        }
    }
    public void menuChanged1(ActionEvent e)
    {
        if (e.getActionCommand().equals("Euros"))
        {
            currencyMenu1.setText("EUR");
            from="EUR";
        }
        if (e.getActionCommand().equals("Indian Rupee")) {
            currencyMenu1.setText("INR");
            from="INR";
        }
        if (e.getActionCommand().equals("Hongkong Dollar")) {
            currencyMenu1.setText("HKD");
            from="HKD";
        }
        if (e.getActionCommand().equals("Canadian Dollar")) {
            currencyMenu1.setText("CAD");
            from="CAD";
        }
        if (e.getActionCommand().equals("US Dollar")) {
            currencyMenu1.setText("USD");
            from="USD";
        }
    }

    public void buttonclicked(ActionEvent evt) throws IOException
    {
        int i=Integer.parseInt(inputField.getText());  
        resultLabel.setText(inputField.getText() + from + " = " + sendHttpGETRequest(to,from,i) + to);
    }

    public static void main(String[] args){
        dvf CurCon = new dvf();
        CurCon.setVisible(true);}
    private static double sendHttpGETRequest(String fromCode,String toCode,int amount) throws IOException {
            String GET_URL="https://v6.exchangerate-api.com/v6/4bd38c887102af556a78a49a/pair/"+toCode+"/"+fromCode+"/"+amount; 
             URL url=new URL(GET_URL);
             HttpURLConnection httpURLConnection=( HttpURLConnection) url.openConnection();
             httpURLConnection.setRequestMethod("GET");
             int responseCode=httpURLConnection.getResponseCode();
             if(responseCode == HttpURLConnection.HTTP_OK)  {
              BufferedReader in=new BufferedReader(new InputStreamReader( httpURLConnection.getInputStream()));
             String inputLine;
             StringBuffer response=new StringBuffer();
             while((inputLine=in.readLine())!=null){
             response.append(inputLine);
             }in.close();
             JSONObject list = new JSONObject(response.toString());
             System.out.println(amount + toCode + " = "+ list.getDouble("conversion_result")+ fromCode);
             return list.getDouble("conversion_result");
            }
            else{
            System.out.println("GET REQUEST FAILED!");
            }
            return 0;
    }
    public JButton getclearButton() {
		return clearButton;
    }
	public void seclearButton(JButton convertButton) {
		this.convertButton = convertButton;
	}
	public JButton getConvertButton() {
		return convertButton;
	}
	public void setConvertButton(JButton convertButton) {
		this.convertButton = convertButton;
	}
	public JButton getClearButton() {
		return clearButton;
	}
	public void setClearButton(JButton clearButton) {
		this.clearButton = clearButton;
	}
	}
