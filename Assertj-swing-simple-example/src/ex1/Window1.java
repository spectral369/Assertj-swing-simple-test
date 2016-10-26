package ex1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Window1 extends JPanel {
	/**
	 * 
	 */
	JFrame f;
	private static final long serialVersionUID = 1L;
	JPanel p;
	JLabel lb = null;
	JLabel spacer;

	public Window1() {
		

		f = new JFrame("APP");
		
		f.setSize(500,400);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setName("TestAPP");
		f.setTitle("testapp");

		p = new JPanel();

		p.setSize(getSize());
		p.setName("panel1");
		JTextField tf = new JTextField();
		tf.setName("tf");
		tf.setColumns(18);
		tf.setPreferredSize(new Dimension(getWidth()/2, 20));
		tf.setMaximumSize(tf.getPreferredSize());
		p.add(tf);

		JButton b = new JButton("OK");
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (!tf.getText().isEmpty())
					lb.setText(tf.getText());
			}
		});
		b.setName("b");
		p.add(b);
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(spacer = new JLabel(" "), "span, grow");
		lb = new JLabel();
		lb.setName("lb");
		lb.setText("textbox text will be copied here(>0)");
		p.add(lb);

		String[] bookTitles = new String[] { "Effective Java", "Head First Java", "Thinking in Java",
				"Java for Dummies" };

		JComboBox<String> bookList = new JComboBox<>(bookTitles);
		bookList.setPreferredSize(getMinimumSize());
		bookList.setName("combobox");
		p.add(bookList);

		String[] selections = { "green", "red", "orange", "dark blue" };
		JList<String> list = new JList<String>(selections);
		list.setSelectedIndex(1);
		JScrollPane sp =  new JScrollPane(list);
		list.setName("list");
		sp.setPreferredSize(getPreferredSize());
		p.add(sp);

		
		JCheckBox rb1 =  new JCheckBox("1");
		rb1.setName("rb1");
		p.add(rb1);
		JCheckBox rb2 =  new JCheckBox("2");
		rb2.setName("rb2");
		p.add(rb2);
		JCheckBox rb3 =  new JCheckBox("3");
		rb3.setName("rb3");
		p.add(rb3);

		JRadioButton male = new JRadioButton("male");
		male.setName("male");
		JRadioButton female = new JRadioButton("Female");
		female.setName("female");
		JRadioButton assume = new JRadioButton("Did you just assume my gender ?");
		assume.setName("assume");
		ButtonGroup bG = new ButtonGroup();
		bG.add(male);
		bG.add(female);
		bG.add(assume);

		p.add(male);
		p.add(female);
		p.add(assume);
		male.setSelected(true);

		JMenuBar myMenuBar = new JMenuBar();
		myMenuBar.setName("menubar");
		JMenu myFileMenu = new JMenu("File");
		myFileMenu.setName("filemenu");
		JMenuItem myRegisterItem = new JMenuItem("checkFemale");
		myRegisterItem.setName("checkfemale");
		myMenuBar.add(myFileMenu);
		myFileMenu.add(myRegisterItem);
		myFileMenu.addSeparator();
		JMenu more = new JMenu("More");
		more.setName("more");
		JMenuItem checkMale = new JMenuItem("checkMale");
		checkMale.setName("checkmale");
		myFileMenu.add(more);
		more.add(checkMale);
		checkMale.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				male.setSelected(true);
			}
		});
		myRegisterItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				female.setSelected(true);
			}

		});

		myMenuBar.setPreferredSize(new Dimension(getWidth(), 20));
		f.add(p);
		f.setJMenuBar(myMenuBar);
		f.setAlwaysOnTop(true);
		// f.pack(); //resize

		repaint();
		revalidate();
		f.setVisible(true);
	}

/*	public static void main(String[] args) {
		Window1 f = new Window1();

	}*/

}
