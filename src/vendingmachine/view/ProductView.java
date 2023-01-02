package vendingmachine.view;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import vendingmachine.vo.ProductVO;

public class ProductView {
	ArrayList<ProductVO> productList;
	ArrayList<JLabel> lblList = new ArrayList<JLabel>();
	JTextField insertTf = new JTextField(10);
	JLabel lblResult = new JLabel("제품이 나오는 곳");
	JFrame frame;
	
	public JPanel displayProducts(JFrame frame) {
		this.frame = frame;
		JPanel panC = new JPanel(new GridLayout(3, 3));
		for (ProductVO vo : productList) {
			ImageIcon icon = new ImageIcon("images/"+vo.getImageName()+".jpg");
			JLabel lbl = new JLabel(icon);
			lbl.addMouseListener(lblL);
			lblList.add(lbl);
			panC.add(lbl);
		}
		return panC;
	}
	
	public JPanel inputPurchase() {
		JPanel panS = new JPanel();
		JLabel lblMoney = new JLabel("금액: ");
		JButton btnInsert = new JButton("투입");
		panS.add(lblMoney); panS.add(insertTf); panS.add(btnInsert);
		panS.add(lblResult);
		return panS;
	}
 
	public void setProductList(ArrayList<ProductVO> productList) {
		this.productList = productList;
	}
	
	MouseAdapter lblL = new MouseAdapter(){
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JOptionPane.showMessageDialog(frame, "제품명: , 제품가격: 원");			
		}
	};
}
