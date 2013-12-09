import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.*;
import javax.swing.GroupLayout.SequentialGroup;




public class CWGui extends JFrame implements ActionListener{
	private JTextField entry;
	private JTextField entry2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JScrollPane jScrollPane1;
	private JLabel status;
	private JTextArea textArea;
	private CWSolution cw;
	private FileParser fp;
	private List<String> dict;

	public CWGui(){
		initComp();
		try {
			
			fp = new FileParser("TWL06.txt");	    
			dict = fp.getAllWords();
			cw = new CWSolution(dict);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}
	public void actionPerformed(ActionEvent event) {
		String inputText = entry.getText();
		String maxResults = entry2.getText();
		boolean validInput = true;
		if(inputText!=null&&inputText.length()>0){
			//Check both inputs
			for(int i = 0;i<inputText.length();i++){
				Character c = inputText.charAt(i);
				if(!Character.isLetter(c)&&!c.equals('*')){
					validInput = false;
					JOptionPane.showMessageDialog(null, "Invalid Input. Only use Letters or *.");
					break;
				}
			}
			
		}
		if(maxResults!=null&&maxResults.length()>0&&!maxResults.isEmpty()){
			for(int i = 0;i<maxResults.length();i++){
				Character c = maxResults.charAt(i);
				if(!Character.isDigit(c)){
					validInput = false;
					JOptionPane.showMessageDialog(null, "Invalid Input. Only use numbers.");
					break;
				}
			}
		}
		if(validInput){
			maxResults = maxResults.trim();
			int x = 1000;
			if(maxResults!=null&&maxResults.length()>0){
				x = Integer.parseInt(maxResults);
			}


			if(x>0){
				List<String> solutions = cw.solutions(inputText, x);
				String sols = "";
				Iterator<String> iter  = solutions.iterator();
				while(iter.hasNext()){
					sols += iter.next()+"\n";
				}
				textArea.setText(sols);
			}else{
				List<String> solutions = cw.solutions(inputText, 2000);
				String sols = "";
				Iterator<String> iter  = solutions.iterator();
				while(iter.hasNext()){
					sols += iter.next()+"\n";
				}
				textArea.setText(sols);
			}
		}else{
			textArea.setText("Invalid Input");
		}



	}

	private void initComp() {
		entry = new JTextField();
		entry2 = new JTextField();
		textArea = new JTextArea();
		status = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		entry2.setEditable(true);
		entry.setEditable(true);
		entry2.setText("1000");
		entry.addActionListener(this) ;
		entry2.addActionListener(this) ;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Crossword Puzzle Generator");

		textArea.setColumns(20);
		textArea.setLineWrap(true);
		textArea.setRows(5);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		jScrollPane1 = new JScrollPane(textArea);

		jLabel1.setText("Enter pattern");
		jLabel2.setText("Number of Results");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		//Create a parallel group for the horizontal axis
		ParallelGroup hGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

		//Create a sequential and a parallel groups
		SequentialGroup h1 = layout.createSequentialGroup();
		ParallelGroup h2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);

		//Add a container gap to the sequential group h1
		h1.addContainerGap();

		//Add a scroll pane and a label to the parallel group h2
		h2.addComponent(jScrollPane1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);
		h2.addComponent(status, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE);

		//Create a sequential group h3
		SequentialGroup h3 = layout.createSequentialGroup();
		h3.addComponent(jLabel1);
		h3.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED);
		h3.addComponent(entry, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);
		h3.addComponent(jLabel2);
		h3.addComponent(entry2, GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE);

		//Add the group h3 to the group h2
		h2.addGroup(h3);
		//Add the group h2 to the group h1
		h1.addGroup(h2);

		h1.addContainerGap();

		//Add the group h1 to the hGroup
		hGroup.addGroup(GroupLayout.Alignment.TRAILING, h1);
		//Create the horizontal group
		layout.setHorizontalGroup(hGroup);


		//Create a parallel group for the vertical axis
		ParallelGroup vGroup = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		//Create a sequential group v1
		SequentialGroup v1 = layout.createSequentialGroup();
		//Add a container gap to the sequential group v1
		v1.addContainerGap();
		//Create a parallel group v2
		ParallelGroup v2 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		v2.addComponent(jLabel1);
		v2.addComponent(entry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		v2.addComponent(jLabel2);
		v2.addComponent(entry2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
		//Add the group v2 tp the group v1
		v1.addGroup(v2);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE);
		v1.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
		v1.addComponent(status);
		v1.addContainerGap();

		//Add the group v1 to the group vGroup
		vGroup.addGroup(v1);
		//Create the vertical group
		layout.setVerticalGroup(vGroup);
		pack();

	}
	public static void main(String[] args){

		CWGui frame = new CWGui();
		frame.setSize(500, 500);
		frame.setVisible(true);
	}

}
